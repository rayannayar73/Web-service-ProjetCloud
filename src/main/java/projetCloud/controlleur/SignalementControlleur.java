package projetCloud.controlleur;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import projetCloud.exception.*;
//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javafx.beans.binding.BooleanExpression;

import com.google.common.base.Joiner;

import projetCloud.model.*;
import projetCloud.repository.*;
import projetCloud.service.NotificationService;
import projetCloud.service.SignalementService;
@RestController
@RequestMapping("/ato")
public class SignalementControlleur {
	@Autowired
	private SignalementRepository signalementRepository;

	@Autowired
	private SignalementService signalementService;

	private int nbrPage = 5;

	private NotificationService notificationService;

	@GetMapping("/signalement")
	public Page<Signalement> getAllSignalement(
		@RequestParam Optional<Integer> page,
		@RequestParam Optional<String> sortBy
	) {
		return signalementRepository.findAll(
			PageRequest.of(
				page.orElse(0),
				nbrPage,
				Sort.Direction.ASC, sortBy.orElse("id")
			)
		);
	}

	@GetMapping("/signalements")
	public List<Signalement> getAllSignalement(
		@RequestParam(value = "avant", required = false) java.sql.Date avant,
		@RequestParam(value = "apres", required = false) java.sql.Date apres,
		@RequestParam(value = "type", required = false) Long type,
		@RequestParam(value = "etat", required = false) Long etat,
		@RequestParam Optional<Integer> page ) {
		return signalementService.findSignalement(type,etat,avant,apres,
		PageRequest.of(
			page.orElse(0),
			nbrPage
		)
		).getContent();
	}
	
	@GetMapping("/signalement/region/{id}")
	public Page<Signalement> getAllSignalementByRegion(
		@PathVariable(value = "id") Long regionId,
		@RequestParam(value = "avant", required = false) java.sql.Date avant,
		@RequestParam(value = "apres", required = false) java.sql.Date apres,
		@RequestParam(value = "type", required = false) Long type,
		@RequestParam(value = "etat", required = false) Long etat,
		@RequestParam Optional<Integer> page,
		@RequestParam Optional<String> sortBy ) {
		return signalementService.findSignalementByRegion(
			regionId, type, etat, avant, apres,
			PageRequest.of(
				page.orElse(0),
				nbrPage)
		);
	}
	
	@GetMapping("/signalement/utilisateur/{id}")
	public List<Signalement> getAllSignalementByUtilisateur(@PathVariable(value = "id") Long utilisateurId) {
		return signalementRepository.findSignalementByUser(utilisateurId);
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
			throws Throwable {
		Signalement signalement = (Signalement) signalementRepository.findById(signalementId)
				.orElseThrow(() -> new ResourceNotFoundException("signalement not found for this id :: " + signalementId));
		return ResponseEntity.ok().body(signalement);
	}

	@PostMapping("/signalement")
	public Signalement createSignalement(@Validated @RequestBody Signalement signalement) throws ParseException {
		Date daty = new Date();
		signalement.setDateSignalement(daty);
		return (Signalement) signalementRepository.save(signalement);
	}
	
	@PutMapping("/signalement/{id}")
	public ResponseEntity<Signalement> updateSignalement(@PathVariable(value = "id") Long signalementId,
			@Validated @RequestBody Signalement signalementDetails) throws Throwable {
		Signalement signalement = (Signalement) signalementRepository.findById(signalementId)
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
		final Signalement updatedSignalement = (Signalement) signalementRepository.save(signalement);
		return ResponseEntity.ok(updatedSignalement);
	}

	@DeleteMapping("/signalement/{id}")
	public Map<String, Boolean> deleteSignalement(@PathVariable(value = "id") Long signalementId)
			throws Throwable {
		Signalement signalement = (Signalement) signalementRepository.findById(signalementId)
				.orElseThrow(() -> new ResourceNotFoundException("signalement not found for this id :: " + signalementId));

		signalementRepository.delete(signalement);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
