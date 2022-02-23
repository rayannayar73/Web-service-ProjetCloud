package projetCloud.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import projetCloud.model.Signalement;

public class SignalementSpecificationsBuilder {
    

    private final List<SearchCriteria> params;

    public SignalementSpecificationsBuilder() {
        params = new ArrayList<>();
    }

    // API

    public final SignalementSpecificationsBuilder with(final String key, final String operation, final Object value, final String prefix, final String suffix) {
        return with(null, key, operation, value, prefix, suffix);
    }

    public final SignalementSpecificationsBuilder with(final String orPredicate, final String key, final String operation, final Object value, final String prefix, final String suffix) {
        SearchOperation op = SearchOperation.getSimpleOperation(operation.charAt(0));
        if (op != null) {
            if (op == SearchOperation.EQUALITY) { // the operation may be complex operation
                final boolean startWithAsterisk = prefix != null && prefix.contains(SearchOperation.ZERO_OR_MORE_REGEX);
                final boolean endWithAsterisk = suffix != null && suffix.contains(SearchOperation.ZERO_OR_MORE_REGEX);

                if (startWithAsterisk && endWithAsterisk) {
                    op = SearchOperation.CONTAINS;
                } else if (startWithAsterisk) {
                    op = SearchOperation.ENDS_WITH;
                } else if (endWithAsterisk) {
                    op = SearchOperation.STARTS_WITH;
                }
            }
            params.add(new SearchCriteria(orPredicate, key, op, value));
        }
        return this;
    }

    public Specification<Signalement> build() {
        if (params.size() == 0)
            return null;

        Specification<Signalement> result = new SignalementSpecification(params.get(0));
     
        for (int i = 1; i < params.size(); i++) {
            result = params.get(i).isOrPredicate()
              ? Specification.where(result).or(new SignalementSpecification(params.get(i))) 
              : Specification.where(result).and(new SignalementSpecification(params.get(i)));
        }
        return result;
    }

    public final SignalementSpecificationsBuilder with(SignalementSpecification spec) {
        params.add(spec.getCriteria());
        return this;
    }

    public final SignalementSpecificationsBuilder with(SearchCriteria criteria) {
        params.add(criteria);
        return this;
    }
}