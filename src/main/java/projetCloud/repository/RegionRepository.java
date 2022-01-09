package projetCloud.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projetCloud.model.*;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {

}
