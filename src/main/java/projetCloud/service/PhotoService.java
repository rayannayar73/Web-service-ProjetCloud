package projetCloud.service;

import java.io.IOException;
import java.util.List;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import projetCloud.model.Photo;
import projetCloud.repository.PhotoRepository;

@Service
public class PhotoService {

    @Autowired
    private PhotoRepository photoRepo;

    public Photo addPhoto(String title, long idSignalement, MultipartFile file) throws IOException { 
        Photo photo = new Photo(title, idSignalement); 
        photo.setImage(
          new Binary(BsonBinarySubType.BINARY, file.getBytes())
        ); 
        return photoRepo.insert(photo); 
    }

    public List<Photo> getPhoto(long id) { 
        return photoRepo.findByIdSignalement(id); 
    }
}