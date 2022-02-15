package projetCloud.controlleur;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import projetCloud.exception.*;
//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projetCloud.model.*;
import projetCloud.repository.*;
import projetCloud.service.NotificationService;
@RestController
@RequestMapping("/ato")
public class SignalementControlleur {
	@Autowired
	private SignalementRepository signalementRepository;

	@Autowired
	private NotificationService notificationService;

	@GetMapping("/signalement")
	public List<Signalement> getAllSignalement() {
		return signalementRepository.findAll();
	}
	
	@GetMapping("/signalement/utilisateur/{id}")
	public List<Signalement> getAllSignalementByUtilisateur(@PathVariable(value = "id") Long utilisateurId) {
		return signalementRepository.findSignalementByUser(utilisateurId);
	}
	
	@GetMapping("/signalement/region/{id}")
	public List<Signalement> getAllSignalementByRegion(@PathVariable(value = "id") Long regionId) {
		return signalementRepository.findSignalementByRegion(regionId);
	}

	@GetMapping("/signalement/jour")
	public List<List<Object>> getAllSignalementByDay() {
		return signalementRepository.listeSignalementParJour();
	}
	@GetMapping("/signalement-nombre/jour")
	public List<List<Object>> getnombreSignalementByDay() {
		return signalementRepository.nombreSignalementParJour();
	}
	
	@GetMapping("/signalement/mois")
	public List<List<Object>> getAllSignalementByMonth() {
		return signalementRepository.listeSignalementParMois();
	}
	
	@GetMapping("/signalement-Terminé/jour")
	public List<List<Object>> getAllSignalementTerminéByDay() {
		return signalementRepository.listeSignalementTerminéParJour();
	}

	@GetMapping("/signalement-Terminé-nombre/jour")
	public List<List<Object>> getNombreSignalementTerminéByDay() {
		return signalementRepository.nombreSignalementTerminéParJour();
	}
	
	@GetMapping("/signalement-Terminé/mois")
	public List<List<Object>> getAllSignalementTerminéByMonth() {
		return signalementRepository.listeSignalementTerminéParMois();
	}

	@GetMapping("/signalement-Nouveau/jour")
	public List<List<Object>> getAllSignalementNouveauByDay() {
		return signalementRepository.listeSignalementNouveauParJour();
	}

	@GetMapping("/signalement-Nouveau-nombre/jour")
	public List<List<Object>> getNombreSignalementNouveauByDay() {
		return signalementRepository.nombreSignalementNouveauParJour();
	}
	
	@GetMapping("/signalement-Nouveau/mois")
	public List<List<Object>> getAllSignalementNouveauByMonth() {
		return signalementRepository.listeSignalementNouveauParMois();
	}
	
	@GetMapping("/signalement-Terminé/nombre")
	public int getNombreSignalementTerminé() {
		return signalementRepository.nombreSignalementTerminé();
	}
	
	@GetMapping("/signalement/nombre")
	public int getNombreSignalement() {
		return signalementRepository.nombreSignalement();
	}

	@GetMapping("/signalement/{id}")
	public ResponseEntity<Signalement> getSignalementById(@PathVariable(value = "id") Long signalementId)
			throws ResourceNotFoundException {
		Signalement signalement = signalementRepository.findById(signalementId)
				.orElseThrow(() -> new ResourceNotFoundException("signalement not found for this id :: " + signalementId));
		return ResponseEntity.ok().body(signalement);
	}

	@PostMapping("/signalement")
	public Signalement createSignalement(@Validated @RequestBody Signalement signalement) throws ParseException {
		Date daty = new Date();
		signalement.setDateSignalement(daty);
		return signalementRepository.save(signalement);
	}
	
	@PutMapping("/signalement/{id}")
	public ResponseEntity<Signalement> updateSignalement(@PathVariable(value = "id") Long signalementId,
			@Validated @RequestBody Signalement signalementDetails) throws ResourceNotFoundException {
		Signalement signalement = signalementRepository.findById(signalementId)
				.orElseThrow(() -> new ResourceNotFoundException("signalement not found for this id :: " + signalementId));
		Date daty = new Date();
		signalement.setType(signalementDetails.getType());
		signalement.setEtat(signalementDetails.getEtat());
		signalement.setUtilisateur(signalementDetails.getUtilisateur());
		signalement.setDateSignalement(signalementDetails.getDateSignalement());
		signalement.setDateFinSignalement(signalementDetails.getDateFinSignalement());
		signalement.setRegion(signalementDetails.getRegion());
		signalement.setLongitude(signalementDetails.getLongitude());
		signalement.setLatitude(signalementDetails.getLatitude());
		signalement.setDescription(signalementDetails.getDescription());
		if(signalementDetails.getEtat().getId()==3) {
			Notification notification = new Notification(signalement);
			notificationService.createNotification(notification);
			signalement.setDateFinSignalement(daty);
		}
		final Signalement updatedSignalement = signalementRepository.save(signalement);
		return ResponseEntity.ok(updatedSignalement);
	}

	@DeleteMapping("/signalement/{id}")
	public Map<String, Boolean> deleteSignalement(@PathVariable(value = "id") Long signalementId)
			throws ResourceNotFoundException {
		Signalement signalement = signalementRepository.findById(signalementId)
				.orElseThrow(() -> new ResourceNotFoundException("signalement not found for this id :: " + signalementId));

		signalementRepository.delete(signalement);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
