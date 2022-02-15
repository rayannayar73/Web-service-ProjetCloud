package projetCloud.controlleur;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import projetCloud.exception.*;

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

import projetCloud.model.Admin;
import projetCloud.model.Utilisateur;
import projetCloud.repository.UtilisateurRepository;
import projetCloud.service.UtilisateurService;
@RestController
@RequestMapping("/ato")
public class UtilisateurController {
	@Autowired
	private UtilisateurRepository utilisateurRepository;

	@Autowired
	private UtilisateurService utilisateurService;

	@GetMapping("/utilisateur")
	public List<Utilisateur> getAllEmployees() {
		return utilisateurRepository.findAll();
	}

	@GetMapping("/utilisateur/{id}")
	public ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable(value = "id") Long utilisateurId)
			throws ResourceNotFoundException {
		Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId)
				.orElseThrow(() -> new ResourceNotFoundException("Utilisateur not found for this id :: " + utilisateurId));
		return ResponseEntity.ok().body(utilisateur);
	}

	@PostMapping("/admin")
	public Admin createUtilisateur(@Validated @RequestBody Admin utilisateur) throws Exception {
		return utilisateurService.createAdmin(utilisateur);
	}

	@PutMapping("/utilisateur/{id}")
	public ResponseEntity<Utilisateur> updateUtilisateur(@PathVariable(value = "id") Long utilisateurId,
			@Validated @RequestBody Utilisateur utilisateurDetails) throws ResourceNotFoundException {
		Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId)
				.orElseThrow(() -> new ResourceNotFoundException("Utilisateur not found for this id :: " + utilisateurId));

		utilisateur.setNom(utilisateurDetails.getNom());
		utilisateur.setPrenom(utilisateurDetails.getPrenom());
		final Utilisateur updatedUtilisateur = utilisateurRepository.save(utilisateur);
		return ResponseEntity.ok(updatedUtilisateur);
	}

	@DeleteMapping("/utilisateur/{id}")
	public Map<String, Boolean> deleteUtilisateur(@PathVariable(value = "id") Long utilisateurId)
			throws ResourceNotFoundException {
		Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + utilisateurId));

		utilisateurRepository.delete(utilisateur);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
