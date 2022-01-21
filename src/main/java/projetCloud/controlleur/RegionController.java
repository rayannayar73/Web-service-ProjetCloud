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
import projetCloud.repository.*;;
@RestController
@RequestMapping("/ato")

public class RegionController {
	
	@Autowired
	private RegionRepository regionRepository;
	
	@GetMapping("/regions")
	public List<Region> getAllRegions() {
		return regionRepository.findAll();
	}
	@GetMapping("/regions/{id}")
	public ResponseEntity<Region> getRegionById(@PathVariable(value = "id") Long regionId)
			throws ResourceNotFoundException {
		Region region =regionRepository.findById(regionId)
				.orElseThrow(() -> new ResourceNotFoundException("Region not found for this id :: " + regionId));
		return ResponseEntity.ok().body(region);
	}
	@PostMapping("/regions")
	public Region createRegion(@Validated @RequestBody Region region) {
		return regionRepository.save(region);
	}
	
	@PutMapping("/regions/{id}")
	public ResponseEntity<Region> updateType(@PathVariable(value = "id") Long regionId,
			@Validated @RequestBody Region regionDetails) throws ResourceNotFoundException {
		Region region = regionRepository.findById(regionId)
				.orElseThrow(() -> new ResourceNotFoundException("type not found for this id :: " + regionId));
		region.setImage(regionDetails.getImage());
		final Region updatedRegion = regionRepository.save(region);
		return ResponseEntity.ok(updatedRegion);
	}
	
	@DeleteMapping("/regions/{id}")
	public Map<String, Boolean> deleteRegion(@PathVariable(value = "id") Long regionId)
			throws ResourceNotFoundException {
		Region region = regionRepository.findById(regionId)
				.orElseThrow(() -> new ResourceNotFoundException("region not found for this id :: " + regionId));

		regionRepository.delete(region);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
}
