package projetCloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import projetCloud.model.Signalement;
import java.util.*;

@Repository
public interface SignalementRepository extends JpaRepository<Signalement, Long>{
	String req = "SELECT s FROM Signalement s WHERE utilisateur_id=?1";
	
	@Query(req)
	List<Signalement> findSignalementByUser(Long idUtilisateur);
	
	@Query("SELECT s FROM Signalement s WHERE etat_id=?1")
	List<Signalement> findSignalementByEtat(Long idEtat);
	
	@Query("SELECT s FROM Signalement s WHERE type_id=?1")
	List<Signalement> findSignalementByType(Long idType);
	
	@Query("SELECT s FROM Signalement s WHERE region_id=?1")
	List<Signalement> findSignalementByRegion(Long idRegion);
	 
}
