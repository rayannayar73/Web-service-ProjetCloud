package projetCloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projetCloud.model.Etat;

@Repository
public interface EtatRepository extends JpaRepository<Etat, Long>{

}
