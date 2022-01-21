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

public class NotificationControlleur {
	@Autowired
	private NotificationRepository notificationRepository;
	
	@GetMapping("/notification")
	public List<Notification> getAllNotification() {
		return notificationRepository.findAll();
	}
	
	@GetMapping("/notification/{id}")
	public ResponseEntity<Notification> getNotificationById(@PathVariable(value = "id") Long notificationId)
			throws ResourceNotFoundException {
		Notification notif = notificationRepository.findById(notificationId)
				.orElseThrow(() -> new ResourceNotFoundException("notification not found for this id :: " + notificationId));
		return ResponseEntity.ok().body(notif);
	}
	@PostMapping("/notification")
	public Notification createNotification(@Validated @RequestBody Notification notification) {
		return notificationRepository.save(notification);
	}
	
	@PutMapping("/notification/{id}")
	public ResponseEntity<Notification> updateNotification(@PathVariable(value = "id") Long notificationId,
			@Validated @RequestBody Notification signalementDetails) throws ResourceNotFoundException {
		Notification notif = notificationRepository.findById(notificationId)
				.orElseThrow(() -> new ResourceNotFoundException("notification not found for this id :: " + notificationId));
		notif.setSignalement(signalementDetails.getSignalement());
		final Notification updatedNotification = notificationRepository.save(notif);
		return ResponseEntity.ok(updatedNotification);
	}
	@DeleteMapping("/notification/{id}")
	public Map<String, Boolean> deleteNotification(@PathVariable(value = "id") Long notificationId)
			throws ResourceNotFoundException {
		Notification notif = notificationRepository.findById(notificationId)
				.orElseThrow(() -> new ResourceNotFoundException("chef not found for this id :: " + notificationId));
		notificationRepository.delete(notif);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
