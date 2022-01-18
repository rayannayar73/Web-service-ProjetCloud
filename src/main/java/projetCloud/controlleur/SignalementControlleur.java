package projetCloud.controlleur;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import projetCloud.exception.*;
//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RestController
@RequestMapping("/ato")
public class SignalementControlleur {
	@Autowired
	private SignalementRepository signalementRepository;

	@GetMapping("/signalement")
	public List<Signalement> getAllSignalement() {
		return signalementRepository.findAll();
	}

	@GetMapping("/signalement/{id}")
	public ResponseEntity<Signalement> getSignalementById(@PathVariable(value = "id") Long signalementId)
			throws ResourceNotFoundException {
		Signalement signalement = signalementRepository.findById(signalementId)
				.orElseThrow(() -> new ResourceNotFoundException("signalement not found for this id :: " + signalementId));
		return ResponseEntity.ok().body(signalement);
	}

	@PostMapping("/signalement")
	public Signalement createSignalement(@Validated @RequestBody Signalement signalement) {
		return signalementRepository.save(signalement);
	}
	
	@PutMapping("/signalement/{id}")
	public ResponseEntity<Signalement> updateSignalement(@PathVariable(value = "id") Long signalementId,
			@Validated @RequestBody Signalement signalementDetails) throws ResourceNotFoundException {
		Signalement signalement = signalementRepository.findById(signalementId)
				.orElseThrow(() -> new ResourceNotFoundException("signalement not found for this id :: " + signalementId));
		signalement.setType(signalementDetails.getType());
		signalement.setEtat(signalementDetails.getEtat());
		signalement.setUtilisateur(signalementDetails.getUtilisateur());
		signalement.setRegion(signalementDetails.getRegion());
		signalement.setLongitude(signalementDetails.getLongitude());
		signalement.setLatitude(signalementDetails.getLatitude());
		signalement.setDescription(signalementDetails.getDescription());
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
