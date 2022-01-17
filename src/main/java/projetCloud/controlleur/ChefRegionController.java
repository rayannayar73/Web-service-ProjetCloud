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

import projetCloud.model.*;
import projetCloud.repository.*;
@RestController
@RequestMapping("/ato")

public class ChefRegionController {
	@Autowired
	private ChefRegionRepository chefRegionRepository;
	
	@GetMapping("/chefregions")
	public List<ChefRegion> getAllChefRegion() {
		return chefRegionRepository.findAll();
	}
	
	@GetMapping("/chefregions/{id}")
	public ResponseEntity<ChefRegion> getChefRegionById(@PathVariable(value = "id") Long chefRegionId)
			throws ResourceNotFoundException {
		ChefRegion signalement = chefRegionRepository.findById(chefRegionId)
				.orElseThrow(() -> new ResourceNotFoundException("chef not found for this id :: " + chefRegionId));
		return ResponseEntity.ok().body(signalement);
	}
	@PostMapping("/chefregions")
	public ChefRegion createChefRegion(@Validated @RequestBody ChefRegion chefRegion) {
		return chefRegionRepository.save(chefRegion);
	}
	
	@PutMapping("/chefregions/{id}")
	public ResponseEntity<ChefRegion> updateChefRegion(@PathVariable(value = "id") Long chefId,
			@Validated @RequestBody ChefRegion signalementDetails) throws ResourceNotFoundException {
		ChefRegion signalement = chefRegionRepository.findById(chefId)
				.orElseThrow(() -> new ResourceNotFoundException("chef not found for this id :: " + chefId));
		signalement.setNom(signalementDetails.getNom());
		signalement.setPrenom(signalementDetails.getPrenom());
		signalement.setEmail(signalementDetails.getEmail());
		signalement.setMdp(signalementDetails.getMdp());
		signalement.setRegion(signalementDetails.getRegion());
		final ChefRegion updatedSignalement = chefRegionRepository.save(signalement);
		return ResponseEntity.ok(updatedSignalement);
	}
	@DeleteMapping("/chefregions/{id}")
	public Map<String, Boolean> deleteChefRegion(@PathVariable(value = "id") Long chefId)
			throws ResourceNotFoundException {
		ChefRegion chef = chefRegionRepository.findById(chefId)
				.orElseThrow(() -> new ResourceNotFoundException("chef not found for this id :: " + chefId));

		chefRegionRepository.delete(chef);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
