package projetCloud;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import projetCloud.model.Admin;
import projetCloud.model.Etat;
import projetCloud.model.Region;
import projetCloud.model.Signalement;
import projetCloud.model.Type;
import projetCloud.model.Utilisateur;
import projetCloud.repository.*;
import projetCloud.repository.RegionRepository;
import projetCloud.repository.SignalementRepository;
import projetCloud.service.AdminService;
import projetCloud.service.UtilisateurService;

@SpringBootApplication
public class HibernateExampleApplication  implements CommandLineRunner {

	@Autowired
	UtilisateurService utilisateurService;

	
	@Autowired
	AdminService adminService;

	@Autowired
	SignalementRepository signalementRepository;

	@Autowired
	UtilisateurRepository utilisateur;

	@Autowired
	EtatRepository etatRepository;

	@Autowired
	RegionRepository region;

	@Autowired
	TypeRepository type;

	public static void main(String[] args) {
		SpringApplication.run(HibernateExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		adminService.createAdmin(new Admin("ravelojaona","rayan","rayan@gmail.com","RAYANnayar73tsyizy"));


		etatRepository.save(new Etat(1, "nouveau"));
		etatRepository.save(new Etat(2, "en cours"));
		etatRepository.save(new Etat(3, "terminé"));
		
		type.save(new Type(1, "accident"));
		type.save(new Type(2, "tondra-drano"));
		type.save(new Type(3, "eboulement de terrain"));

		region.save(new Region(1,"analamanga","analamanga.jpg"));
		utilisateurService.createUtilisateur(new Utilisateur("analamanga","analamanga","analamanga@gmail.com","RAYANnayar73"));

		region.save(new Region(2,"alaotra mangoro","alaotra_mangoro.png"));
		utilisateurService.createUtilisateur(new Utilisateur("analamangaTest","analamangaTest","analamangaTest@gmail.com","RAYANnayar73"));

		// region.save(new Region(3,"alaotra mangoro","alaotra_mangoro.png"));
		utilisateurService.createUtilisateur(new Utilisateur("alaotra","mangoro","alaotraMangoro@gmail.com","RAYANnayar73"));

		// region.save(new Region(4,"analamanga","analamanga.jpg"));
		utilisateurService.createUtilisateur(new Utilisateur("analamangaq","analamangaq","analamangaq@gmail.com","RAYANnayar73"));

		// region.save(new Region(5,"alaotra mangoro","alaotra_mangoro.png"));
		utilisateurService.createUtilisateur(new Utilisateur("alaotraa","mangoroa","alaotraMangoroa@gmail.com","RAYANnayar73"));

		// region.save(new Region(6,"analamanga","analamanga.jpg"));
		utilisateurService.createUtilisateur(new Utilisateur("analamangaz","analamangaz","analamangaz@gmail.com","RAYANnayar73"));

		// region.save(new Region(7,"alaotra mangoro","alaotra_mangoro.png"));
		utilisateurService.createUtilisateur(new Utilisateur("alaotrwa","mangorow","alaotraMangorow@gmail.com","RAYANnayar73"));

		// region.save(new Region(8,"analamanga","analamanga.jpg"));
		utilisateurService.createUtilisateur(new Utilisateur("analamangas","analamangas","analamangas@gmail.com","RAYANnayar73"));

		// region.save(new Region(9,"alaotra mangoro","alaotra_mangoro.png"));
		utilisateurService.createUtilisateur(new Utilisateur("alaotrax","mangorox","alaotraMangorox@gmail.com","RAYANnayar73"));

		// region.save(new Region(10,"analamanga","analamanga.jpg"));
		utilisateurService.createUtilisateur(new Utilisateur("analamangae","analamangae","analamangae@gmail.com","RAYANnayar73"));

		// region.save(new Region(11,"alaotra mangoro","alaotra_mangoro.png"));
		utilisateurService.createUtilisateur(new Utilisateur("alaotrad","mangorod","alaotraMangorod@gmail.com","RAYANnayar73"));

		// region.save(new Region(12,"analamanga","analamanga.jpg"));
		utilisateurService.createUtilisateur(new Utilisateur("analamangac","analamangac","analamangac@gmail.com","RAYANnayar73"));

		// region.save(new Region(13,"alaotra mangoro","alaotra_mangoro.png"));
		utilisateurService.createUtilisateur(new Utilisateur("alaotrar","mangoror","alaotraMangoror@gmail.com","RAYANnayar73"));

		// region.save(new Region(14,"analamanga","analamanga.jpg"));
		utilisateurService.createUtilisateur(new Utilisateur("analamangaf","analamangaf","analamangaf@gmail.com","RAYANnayar73"));

		// region.save(new Region(15,"alaotra mangoro","alaotra_mangoro.png"));
		utilisateurService.createUtilisateur(new Utilisateur("alaotrav","mangorov","alaotraMangorov@gmail.com","RAYANnayar73"));

		// region.save(new Region(16,"analamanga","analamanga.jpg"));
		utilisateurService.createUtilisateur(new Utilisateur("analamangat","analamangat","analamangat@gmail.com","RAYANnayar73"));

		// region.save(new Region(17,"alaotra mangoro","alaotra_mangoro.png"));
		utilisateurService.createUtilisateur(new Utilisateur("alaotrag","mangorog","alaotraMangorog@gmail.com","RAYANnayar73"));

		// region.save(new Region(18,"analamanga","analamanga.jpg"));
		utilisateurService.createUtilisateur(new Utilisateur("analamangab","analamangab","analamangab@gmail.com","RAYANnayar73"));

		// region.save(new Region(19,"alaotra mangoro","alaotra_mangoro.png"));
		utilisateurService.createUtilisateur(new Utilisateur("alaotrya","mangoroy","alaotraMangoroy@gmail.com","RAYANnayar73"));

		// region.save(new Region(20,"analamanga","analamanga.jpg"));
		utilisateurService.createUtilisateur(new Utilisateur("analamangah","analamangah","analamangah@gmail.com","RAYANnayar73"));

		// region.save(new Region(21,"alaotra mangoro","alaotra_mangoro.png"));
		utilisateurService.createUtilisateur(new Utilisateur("alaotran","mangoron","alaotraMangoron@gmail.com","RAYANnayar73"));

		// region.save(new Region(22,"analamanga","analamanga.jpg"));
		utilisateurService.createUtilisateur(new Utilisateur("analamangau","analamangau","analamangau@gmail.com","RAYANnayar73"));

		// region.save(new Region(23,"alaotra mangoro","alaotra_mangoro.png"));
		utilisateurService.createUtilisateur(new Utilisateur("alaotraj","mangoroj","alaotraMangoroj@gmail.com","RAYANnayar73"));

		Date ajd = new Date();
		//date - type - etat - user
		// var lat=[-18.939,-18.908718,-18.910390];
		// let lng = "47.521";
		// var lng=[47.521, 47.508899,47.505972];
		//longitude, latitude, description, dateSignalement, type, etat, utilisateur, region
		utilisateurService.createUtilisateur(new Utilisateur(24,"ravelojaona","rayan","rayan24@gmail.com","RAYANnayar73"));
		utilisateurService.createUtilisateur(new Utilisateur(25,"ravelojaona","rayan","rayan25@gmail.com","RAYANnayar73"));
		utilisateurService.createUtilisateur(new Utilisateur(26,"ravelojaona","rayan","rayan26@gmail.com","RAYANnayar73"));

		signalementRepository.save(new Signalement((float)47.521,(float)-18.939,"",new Date(ajd.getTime()-(1000*60*60*72)),new Type(1),new Etat(1),new Utilisateur(24),new Region(1)));
		signalementRepository.save(new Signalement((float)47.508899,(float)-18.908718,"",new Date(ajd.getTime()-(1000*60*60*48)),new Type(1),new Etat(1),new Utilisateur(24),new Region(1)));
		signalementRepository.save(new Signalement((float)47.505972,(float)-18.910390,"",new Date(ajd.getTime()-(1000*60*60*48)),new Type(2),new Etat(3),new Utilisateur(24),new Region(1)));
		signalementRepository.save(new Signalement((float)47.500972,(float)-18.910390,new Date(ajd.getTime()-(1000*60*60*24)),new Type(2),new Etat(3),new Utilisateur(24)));
		signalementRepository.save(new Signalement((float)47.507972,(float)-18.910390,new Date(ajd.getTime()-(1000*60*60*72)),new Type(3),new Etat(1),new Utilisateur(24)));
		
		signalementRepository.save(new Signalement((float)49.521,(float)-18.939,new Date(ajd.getTime()-(1000*60*60*72)),new Type(1),new Etat(1),new Utilisateur(25)));
		signalementRepository.save(new Signalement((float)49.508899,(float)-18.908718,new Date(ajd.getTime()-(1000*60*60*48)),new Type(1),new Etat(1),new Utilisateur(25)));
		signalementRepository.save(new Signalement((float)49.505972,(float)-18.910390,"",new Date(ajd.getTime()-(1000*60*60*48)),new Type(2),new Etat(3),new Utilisateur(25),new Region(2)));
		signalementRepository.save(new Signalement((float)49.500972,(float)-18.910390,"",new Date(ajd.getTime()-(1000*60*60*24)),new Type(2),new Etat(3),new Utilisateur(25),new Region(2)));
		signalementRepository.save(new Signalement((float)49.507972,(float)-18.910390,"",new Date(ajd.getTime()-(1000*60*60*72)),new Type(3),new Etat(1),new Utilisateur(25),new Region(2)));
		
		signalementRepository.save(new Signalement((float)45.521,(float)-18.939,new Date(ajd.getTime()-(1000*60*60*72)),new Type(1),new Etat(1),new Utilisateur(26)));
		signalementRepository.save(new Signalement((float)45.508899,(float)-18.908718,"",new Date(ajd.getTime()-(1000*60*60*48)),new Type(1),new Etat(1),new Utilisateur(26),new Region(2)));
		signalementRepository.save(new Signalement((float)45.505972,(float)-18.910390,"",new Date(ajd.getTime()-(1000*60*60*48)),new Type(2),new Etat(3),new Utilisateur(26),new Region(2)));
		signalementRepository.save(new Signalement((float)45.500972,(float)-18.910390,"",new Date(ajd.getTime()-(1000*60*60*24)),new Type(2),new Etat(3),new Utilisateur(26),new Region(2)));
		signalementRepository.save(new Signalement((float)45.507972,(float)-18.910390,"",new Date(ajd.getTime()-(1000*60*60*72)),new Type(3),new Etat(1),new Utilisateur(26),new Region(2)));
		
	}

}
