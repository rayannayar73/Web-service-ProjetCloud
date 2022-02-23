package projetCloud.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import projetCloud.model.Signalement;

import java.sql.Date;
import java.util.*;

@Repository
public interface SignalementRepository extends JpaRepository<Signalement, Long>, JpaSpecificationExecutor<Signalement> {

	@Query("SELECT s FROM Signalement s WHERE  region_id=:region and type_id=:type and etat_id=:etat and date_signalement>=:avant and date_signalement<=:apres ")
	Page<Signalement> findWithRegionSignalementByAll( Pageable pageable,@Param("region") Long region,@Param("type") Long type,@Param("etat") Long etat,@Param("avant") Date avant,@Param("apres") Date apres);

	@Query("SELECT s FROM Signalement s WHERE region_id=:region and type_id=:type and etat_id=:etat and date_signalement>=:avant")
	Page<Signalement> findWithRegionSignalementByAllBefore(Long region, Long type, Long etat, Date avant, Pageable pageable);

	@Query("SELECT s FROM Signalement s WHERE region_id=:region and type_id=:type and etat_id=:etat and date_signalement<=:apres")
	Page<Signalement> findWithRegionSignalementByAllAfter(Long region, Long type, Long etat, Date apres, Pageable pageable);
	
	@Query("SELECT s FROM Signalement s WHERE region_id=:region and etat_id=:etat AND type_id=:type")
	Page<Signalement> findWithRegionSignalementByEtatAndType(Long region, Long etat, Long type, Pageable pageable);
	
	@Query("SELECT s FROM Signalement s WHERE region_id=:region and type_id=:type and date_signalement>=:avant and date_signalement<=:apres")
	Page<Signalement> findWithRegionSignalementByTypeAndDateRoa(Long region, Long type, Date avant, Date apres, Pageable pageable);

	@Query("SELECT s FROM Signalement s WHERE region_id=:region and type_id=:type  and date_signalement>=:avant")
	Page<Signalement> findWithRegionSignalementByTypeBefore(Long region, Long type, Date avant, Pageable pageable);

	@Query("SELECT s FROM Signalement s WHERE region_id=:region and type_id=:type  and date_signalement<=:apres")
	Page<Signalement> findWithRegionSignalementByTypeAfter(Long region, Long type, Date apres, Pageable pageable);
	
	@Query("SELECT s FROM Signalement s WHERE region_id=:region and type_id=:type")
	Page<Signalement> findWithRegionSignalementByType(Long region, Long type, Pageable pageable);

	@Query("SELECT s FROM Signalement s WHERE region_id=:region and etat_id=:etat")
	Page<Signalement> findWithRegionSignalementByEtat(Long region, Long etat, Pageable pageable);

	@Query("SELECT s FROM Signalement s WHERE region_id=:region and etat_id=:etat and date_signalement>=:avant and date_signalement<=:apres")
	Page<Signalement> findWithRegionSignalementByEtatAndDateRoa(Long region, Long etat, Date avant, Date apres, Pageable pageable);

	@Query("SELECT s FROM Signalement s WHERE region_id=:region and etat_id=:etat and date_signalement>=:avant")
	Page<Signalement> findWithRegionSignalementByEtatBefore(Long region, Long etat, Date avant, Pageable pageable);

	@Query("SELECT s FROM Signalement s WHERE region_id=:region and etat_id=:etat and date_signalement<=:apres")
	Page<Signalement> findWithRegionSignalementByEtatAfter(Long region, Long etat, Date apres, Pageable pageable);

	@Query("SELECT s FROM Signalement s WHERE region_id=:region and date_signalement>=:avant and date_signalement<=:apres")
	Page<Signalement> findWithRegionSignalementByDateRoa(Long region, Date avant, Date apres, Pageable pageable);
	
	@Query("SELECT s FROM Signalement s WHERE region_id=:region and date_signalement>=:avant ")
	Page<Signalement> findWithRegionSignalementByDateAvant(Long region, Date avant, Pageable pageable);

	@Query("SELECT s FROM Signalement s WHERE region_id=:region and date_signalement<=:apres")
	Page<Signalement> findWithRegionSignalementByDateApres(Long region,  Date apres, Pageable pageable);
	


	@Query("SELECT s FROM Signalement s WHERE type_id=:type and etat_id=:etat and date_signalement>=:avant and date_signalement<=:apres")
	Page<Signalement> findSignalementByAll(Long type, Long etat, Date avant, Date apres, Pageable pageable);

	@Query("SELECT s FROM Signalement s WHERE type_id=:type and etat_id=:etat and date_signalement>=:avant")
	Page<Signalement> findSignalementByAllBefore(Long type, Long etat, Date avant, Pageable pageable);

	@Query("SELECT s FROM Signalement s WHERE type_id=:type and etat_id=:etat and date_signalement<=:apres")
	Page<Signalement> findSignalementByAllAfter(Long type, Long etat, Date apres, Pageable pageable);
	
	@Query("SELECT s FROM Signalement s WHERE etat_id=:etat AND type_id=:type")
	Page<Signalement> findSignalementByEtatAndType(Long etat, Long type, Pageable pageable);
	
	@Query("SELECT s FROM Signalement s WHERE type_id=:type and date_signalement>=:avant and date_signalement<=:apres")
	Page<Signalement> findSignalementByTypeAndDateRoa(Long type, Date avant, Date apres, Pageable pageable);

	@Query("SELECT s FROM Signalement s WHERE type_id=:type  and date_signalement>=:avant")
	Page<Signalement> findSignalementByTypeBefore(Long type, Date avant, Pageable pageable);

	@Query("SELECT s FROM Signalement s WHERE type_id=:type  and date_signalement<=:apres")
	Page<Signalement> findSignalementByTypeAfter(Long type, Date apres, Pageable pageable);
	
	@Query("SELECT s FROM Signalement s WHERE type_id=:type")
	Page<Signalement> findSignalementByType(Long type, Pageable pageable);

	@Query("SELECT s FROM Signalement s WHERE etat_id=:etat")
	Page<Signalement> findSignalementByEtat(Long etat, Pageable pageable);

	@Query("SELECT s FROM Signalement s WHERE etat_id=:etat and date_signalement>=:avant and date_signalement<=:apres")
	Page<Signalement> findSignalementByEtatAndDateRoa(Long etat, Date avant, Date apres, Pageable pageable);

	@Query("SELECT s FROM Signalement s WHERE etat_id=:etat and date_signalement>=:avant")
	Page<Signalement> findSignalementByEtatBefore(Long etat, Date avant, Pageable pageable);

	@Query("SELECT s FROM Signalement s WHERE etat_id=:etat and date_signalement<=:apres")
	Page<Signalement> findSignalementByEtatAfter(Long etat, Date apres, Pageable pageable);

	@Query("SELECT s FROM Signalement s WHERE date_signalement>=:avant and date_signalement<=:apres")
	Page<Signalement> findSignalementByDateRoa(Date avant, Date apres, Pageable pageable);
	
	@Query("SELECT s FROM Signalement s WHERE date_signalement>=:avant")
	Page<Signalement> findSignalementByDateAvant(Date avant, Pageable pageable);
	
	@Query("SELECT s FROM Signalement s WHERE date_signalement>=:apres")
	Page<Signalement> findSignalementByDateApres(Date apres, Pageable pageable);
	

	@Query("SELECT s FROM Signalement s WHERE region_id=?1")
	List<Signalement> findSignalementByRegion(Long idRegion);
	
	@Query("SELECT s FROM Signalement s WHERE utilisateur_id=?1")
	List<Signalement> findSignalementByUser(Long idUtilisateur);

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
