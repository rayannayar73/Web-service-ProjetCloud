package projetCloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projetCloud.model.*;

public interface ChefRegionRepository extends JpaRepository<ChefRegion, Long> {

}
