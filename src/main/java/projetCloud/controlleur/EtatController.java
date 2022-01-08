package projetCloud.controlleur;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

import projetCloud.model.Etat;
import projetCloud.repository.EtatRepository;;
@RestController
@RequestMapping("/ato")
public class EtatController {
	@Autowired
	private EtatRepository etatRepository;

	@GetMapping("/etat")
	public List<Etat> getAllEtat() {
		return etatRepository.findAll();
	}

	@GetMapping("/etat/{id}")
	public ResponseEntity<Etat> getEtatById(@PathVariable(value = "id") Long etatId)
			throws ResourceNotFoundException {
		Etat etat = etatRepository.findById(etatId)
				.orElseThrow(() -> new ResourceNotFoundException("Etat not found for this id :: " + etatId));
		return ResponseEntity.ok().body(etat);
	}

	@PostMapping("/etat")
	public Etat createEtat(@Validated @RequestBody Etat etat) {
		return etatRepository.save(etat);
	}

	@PutMapping("/etat/{id}")
	public ResponseEntity<Etat> updateEtat(@PathVariable(value = "id") Long etatId,
			@Validated @RequestBody Etat etatDetails) throws ResourceNotFoundException {
		Etat etat = etatRepository.findById(etatId)
				.orElseThrow(() -> new ResourceNotFoundException("Etat not found for this id :: " + etatId));

		etat.setId(etatDetails.getId());
		etat.setNom(etatDetails.getNom());
		final Etat updatedEtat = etatRepository.save(etat);
		return ResponseEntity.ok(updatedEtat);
	}

	@DeleteMapping("/etat/{id}")
	public Map<String, Boolean> deleteEtat(@PathVariable(value = "id") Long etatId)
			throws ResourceNotFoundException {
		Etat etat = etatRepository.findById(etatId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + etatId));

		etatRepository.delete(etat);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
