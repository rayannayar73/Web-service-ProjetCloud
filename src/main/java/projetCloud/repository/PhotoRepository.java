package projetCloud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import projetCloud.model.Photo;

public interface PhotoRepository extends MongoRepository<Photo, String> {
    
    @Query("{ idSignalement : ?0 }")
    List<Photo> findByIdSignalement(Long idSignalement);
 }
