package projetCloud.controlleur;
//import javax.validation.Valid;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import projetCloud.model.Photo;
// import projetCloud.repository.PhotoRepository;
import projetCloud.service.PhotoService;;
@RestController
@RequestMapping("/ato")
public class PhotoController {
	@Autowired
	// private PhotoRepository photoRepository;

    private PhotoService photoService;

    @PostMapping("/photos")
    public Photo addPhoto(
        @RequestParam("idSignalement")Long idSignalement, 
        @RequestParam("title") String title, 
        @RequestPart("image") MultipartFile image) 
        throws IOException {
            Photo retour = photoService.addPhoto(title, idSignalement, image);
            return retour;
    }

    @GetMapping("/photos/{idSignalement}")
    public List<Photo> getPhoto(Model model, @PathVariable(value = "idSignalement") Long signalementId) {
        List<Photo> photo = photoService.getPhoto(signalementId); 
        return photo; 
    }
}
