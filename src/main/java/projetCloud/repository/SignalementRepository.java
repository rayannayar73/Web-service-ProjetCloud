package projetCloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projetCloud.model.Signalement;

@Repository
public interface SignalementRepository extends JpaRepository<Signalement, Long>{

}
