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
		utilisateurService.createAdmin(new Admin("ravelojaona","rayan","rayan@gmail.com","RAYANnayar73"));

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
		// var lat=[-18.939,-18.908718,-18.910390];
		// let lng = "47.521";
		// var lng=[47.521, 47.508899,47.505972];
		signalementRepository.save(new Signalement((float)47.521,(float)-18.939,new Date(ajd.getTime()-(1000*60*60*72)),new Type(1),new Etat(1),new Utilisateur(1)));
		signalementRepository.save(new Signalement((float)47.508899,(float)-18.908718,new Date(ajd.getTime()-(1000*60*60*48)),new Type(1),new Etat(1),new Utilisateur(1)));
		signalementRepository.save(new Signalement((float)47.505972,(float)-18.910390,new Date(ajd.getTime()-(1000*60*60*48)),new Type(2),new Etat(3),new Utilisateur(1)));
		signalementRepository.save(new Signalement((float)47.500972,(float)-18.910390,new Date(ajd.getTime()-(1000*60*60*24)),new Type(2),new Etat(3),new Utilisateur(1)));
		signalementRepository.save(new Signalement((float)47.507972,(float)-18.910390,new Date(ajd.getTime()-(1000*60*60*72)),new Type(3),new Etat(1),new Utilisateur(1)));
		
	}

}
