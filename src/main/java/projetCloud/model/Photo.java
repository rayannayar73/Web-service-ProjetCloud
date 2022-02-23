package projetCloud.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "photos")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private Long idSignalement;
    
    private String title;
        
    private Binary image;


    public Photo() {
		super();
	}
	public Photo(String id) {
		super();
		this.id = id;
	}

    public Photo(String title, Long idSignalement) {
		super();
		this.idSignalement = idSignalement;
		this.title = title;
	}

    public Photo(Long idSignalement){
        super();
		this.idSignalement = idSignalement;
    }

	public String getId(){
        return id;
    }

    public void setId(String id){
        this.id=id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title=title;
    }

    public Binary getImage(){
        return image;
    }

    public void setImage(Binary binary) {
        this.image = binary;
    }

    public long getIdSignalement() {
        return idSignalement;
    }

    public void setIdSignalement(long idSignalement) {
        this.idSignalement = idSignalement;
    }

}
