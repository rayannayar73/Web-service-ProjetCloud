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
	
	@Query(value="select extract(year from signalement.date_signalement) as année,\r\n"
			+ "		to_char(signalement.date_signalement,'Mon') as mois,\r\n"
			+ "       extract(day from signalement.date_signalement) as jour,\r\n"
			+ "       count(signalement) as nombreSignalement\r\n"
			+ "from signalement\r\n"
			+ "group by 1,2,3\r\n"
			+ "order by 1 desc,2 desc,3 desc",nativeQuery=true)
	List<List<Object>> listeSignalementParJour();

	@Query(value="select nombreSignalement from ("
			+"select extract(year from signalement.date_signalement) as année,\r\n"
			+ "		to_char(signalement.date_signalement,'Mon') as mois,\r\n"
			+ "       extract(day from signalement.date_signalement) as jour,\r\n"
			+ "       count(signalement) as nombreSignalement\r\n"
			+ "from signalement\r\n"
			+ "group by 1,2,3\r\n"
			+ "order by 1 desc,2 desc,3 desc) as isa",nativeQuery=true)
	List<List<Object>> nombreSignalementParJour();

	@Query(value="select extract(year from signalement.date_signalement) as année,\r\n"
			+ "		to_char(signalement.date_signalement,'Mon') as mois,\r\n"
			+ "       count(signalement) as nombreSignalement\r\n"
			+ "from signalement\r\n"
			+ "group by 1,2\r\n"
			+ "order by 1 desc,2 desc",nativeQuery=true)
	List<List<Object>> listeSignalementParMois();
	
	@Query(value="select extract(year from signalement.date_signalement) as année,\r\n"
			+ "		to_char(signalement.date_signalement,'Mon') as mois,\r\n"
			+ "       extract(day from signalement.date_signalement) as jour,\r\n"
			+ "       count(signalement) as nombreSignalement\r\n"
			+ "from signalement\r\n"
			+ "where signalement.etat_id=3\r\n"
			+ "group by 1,2,3\r\n"
			+ "order by 1 desc,2 desc,3 desc",nativeQuery=true)
	List<List<Object>> listeSignalementTerminéParJour();

	@Query(value="select nombreSignalement from ("
			+"select extract(year from signalement.date_signalement) as année,\r\n"
			+ "		to_char(signalement.date_signalement,'Mon') as mois,\r\n"
			+ "       extract(day from signalement.date_signalement) as jour,\r\n"
			+ "       count(signalement) as nombreSignalement\r\n"
			+ "from signalement\r\n"
			+ "where signalement.etat_id=3\r\n"
			+ "group by 1,2,3\r\n"
			+ "order by 1 desc,2 desc,3 desc) as isa",nativeQuery=true)
	List<List<Object>> nombreSignalementTerminéParJour();
	
	@Query(value="select extract(year from signalement.date_signalement) as année,\r\n"
			+ "		to_char(signalement.date_signalement,'Mon') as mois,\r\n"
			+ "       count(signalement) as nombreSignalement\r\n"
			+ "from signalement\r\n"
			+ "where signalement.etat_id=3\r\n"
			+ "group by 1,2\r\n"
			+ "order by 1 desc,2 desc",nativeQuery=true)
	List<List<Object>> listeSignalementTerminéParMois();
	
	@Query(value="select extract(year from signalement.date_signalement) as année,\r\n"
			+ "		to_char(signalement.date_signalement,'Mon') as mois,\r\n"
			+ "       extract(day from signalement.date_signalement) as jour,\r\n"
			+ "       count(signalement) as nombreSignalement\r\n"
			+ "from signalement\r\n"
			+ "where signalement.etat_id=1\r\n"
			+ "group by 1,2,3\r\n"
			+ "order by 1 desc,2 desc,3 desc",nativeQuery=true)
	List<List<Object>> listeSignalementNouveauParJour();
	
	@Query(value="select nombreSignalement from ("
			+"select extract(year from signalement.date_signalement) as année,\r\n"
			+ "		to_char(signalement.date_signalement,'Mon') as mois,\r\n"
			+ "       extract(day from signalement.date_signalement) as jour,\r\n"
			+ "       count(signalement) as nombreSignalement\r\n"
			+ "from signalement\r\n"
			+ "where signalement.etat_id=1\r\n"
			+ "group by 1,2,3\r\n"
			+ "order by 1 desc,2 desc,3 desc) as isa",nativeQuery=true)
	List<List<Object>> nombreSignalementNouveauParJour();
	
	@Query(value="select extract(year from signalement.date_signalement) as année,\r\n"
			+ "		to_char(signalement.date_signalement,'Mon') as mois,\r\n"
			+ "       count(signalement) as nombreSignalement\r\n"
			+ "from signalement\r\n"
			+ "where signalement.etat_id=1\r\n"
			+ "group by 1,2\r\n"
			+ "order by 1 desc,2 desc",nativeQuery=true)
	List<List<Object>> listeSignalementNouveauParMois();
	
	@Query(value="select count(signalement) as nombreSignalement\r\n"
			+ "from signalement\r\n"
			+ "where signalement.etat_id=3",nativeQuery=true)
	int nombreSignalementTerminé();
	
	@Query(value="select count(signalement) as nombreSignalement\r\n"
			+ "from signalement\r\n",nativeQuery=true)
	int nombreSignalement();
	 
}
