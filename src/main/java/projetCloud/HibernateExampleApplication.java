package projetCloud;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import projetCloud.model.Etat;
import projetCloud.model.Region;
import projetCloud.model.Signalement;
import projetCloud.model.Type;
import projetCloud.model.Utilisateur;
import projetCloud.repository.*;
import projetCloud.repository.RegionRepository;
import projetCloud.repository.SignalementRepository;
import projetCloud.service.UtilisateurService;

@SpringBootApplication
public class HibernateExampleApplication  implements CommandLineRunner {

	@Autowired
	UtilisateurService utilisateurService;

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
		// utilisateurService.createAdmin(new Utilisateur("ravelojaona","rayan","rayan@gmail.com","12qsQasdef34"));

		utilisateur.save(new Utilisateur(1,"rayan","nayar","rayan@gmail.com","1234rayanNayar"));

		etatRepository.save(new Etat(1, "nouveau"));
		etatRepository.save(new Etat(2, "en cours"));
		etatRepository.save(new Etat(3, "terminé"));
		
		type.save(new Type(1, "accident"));
		type.save(new Type(2, "tondra-drano"));
		type.save(new Type(3, "eboulement de terrain"));

		region.save(new Region(1,"analamanga","analamanga.jpg"));
		region.save(new Region(1,"alaotra mangoro","alaotra_mangoro.png"));

		Date ajd = new Date();
		//date - type - etat - user
		signalementRepository.save(new Signalement(new Date(ajd.getTime()-(1000*60*60*72)),new Type(1),new Etat(1),new Utilisateur(1)));
		signalementRepository.save(new Signalement(new Date(ajd.getTime()-(1000*60*60*48)),new Type(1),new Etat(1),new Utilisateur(1)));
		signalementRepository.save(new Signalement(new Date(ajd.getTime()-(1000*60*60*48)),new Type(2),new Etat(3),new Utilisateur(1)));
		signalementRepository.save(new Signalement(new Date(ajd.getTime()-(1000*60*60*24)),new Type(2),new Etat(3),new Utilisateur(1)));
		signalementRepository.save(new Signalement(new Date(ajd.getTime()-(1000*60*60*72)),new Type(3),new Etat(1),new Utilisateur(1)));
		
	}

}
