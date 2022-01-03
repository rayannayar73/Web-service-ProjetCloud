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
public class TypeControlleur {
	@Autowired
	private TypeRepository typeRepository;

	@GetMapping("/type")
	public List<Type> getAllType() {
		return typeRepository.findAll();
	}

	@GetMapping("/type/{id}")
	public ResponseEntity<Type> getTypeById(@PathVariable(value = "id") Long typeId)
			throws ResourceNotFoundException {
		Type type = typeRepository.findById(typeId)
				.orElseThrow(() -> new ResourceNotFoundException("type not found for this id :: " + typeId));
		return ResponseEntity.ok().body(type);
	}

	@PostMapping("/type")
	public Type createType(@Validated @RequestBody Type type) {
		return typeRepository.save(type);
	}

	@PutMapping("/type/{id}")
	public ResponseEntity<Type> updateType(@PathVariable(value = "id") Long typeId,
			@Validated @RequestBody Type typeDetails) throws ResourceNotFoundException {
		Type type = typeRepository.findById(typeId)
				.orElseThrow(() -> new ResourceNotFoundException("type not found for this id :: " + typeId));
		type.setNom(typeDetails.getNom());
		final Type updatedType = typeRepository.save(type);
		return ResponseEntity.ok(updatedType);
	}

	@DeleteMapping("/type/{id}")
	public Map<String, Boolean> deleteType(@PathVariable(value = "id") Long typeId)
			throws ResourceNotFoundException {
		Type type = typeRepository.findById(typeId)
				.orElseThrow(() -> new ResourceNotFoundException("type not found for this id :: " + typeId));

		typeRepository.delete(type);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
