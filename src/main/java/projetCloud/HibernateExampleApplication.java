package projetCloud;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import projetCloud.model.Etat;
import projetCloud.model.Signalement;
import projetCloud.model.Utilisateur;
import projetCloud.repository.EtatRepository;
import projetCloud.repository.SignalementRepository;
import projetCloud.service.UtilisateurService;

@SpringBootApplication
public class HibernateExampleApplication  implements CommandLineRunner {

	@Autowired
	UtilisateurService utilisateurService;

	@Autowired
	SignalementRepository signalementRepository;

	@Autowired
	EtatRepository etatRepository;

	public static void main(String[] args) {
		SpringApplication.run(HibernateExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// utilisateurService.createAdmin(new Utilisateur("ravelojaona","rayan","rayan@gmail.com","12qsQasdef34"));

		etatRepository.save(new Etat(1, "nouveau"));
		etatRepository.save(new Etat(2, "en cours"));
		etatRepository.save(new Etat(3, "terminé"));

		Date ajd = new Date();
		signalementRepository.save(new Signalement(new Date(ajd.getTime()-(1000*60*60*72)),new Etat(1)));
		signalementRepository.save(new Signalement(new Date(ajd.getTime()-(1000*60*60*48)),new Etat(1)));
		signalementRepository.save(new Signalement(new Date(ajd.getTime()-(1000*60*60*48)),new Etat(3)));
		signalementRepository.save(new Signalement(new Date(ajd.getTime()-(1000*60*60*24)),new Etat(3)));
		signalementRepository.save(new Signalement(new Date(ajd.getTime()-(1000*60*60*72)),new Etat(1)));
	}

}
