package projetCloud.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "signalement")
public class Signalement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "longitude", nullable = false)
	private float longitude;
	
	@Column(name = "latitude", nullable = false)
	private float latitude;
	
	@Column(name = "description", nullable = false)
	private String description;

	@ManyToOne
	private Type type;
	 
	@ManyToOne
	private Utilisateur utilisateur;
	
	@ManyToOne
	private Region region;
	
	public Signalement() {
		
	}
	
	public Signalement(long id, Region region, float longitude, float latitude, String description, Type type,
			Utilisateur utilisateur) {
		this.id = id;
		this.region = region;
		this.longitude = longitude;
		this.latitude = latitude;
		this.description = description;
		this.type = type;
		this.utilisateur = utilisateur;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Region getRegion() {
		return region;
	}


	public void setRegion(Region region) {
		this.region = region;
	}

	public float getLongitude() {
		return longitude;
	}


	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public float getLatitude() {
		return latitude;
	}


	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Signalement [id=" + id + ", type=" + type.getNom() + ", Utilisateur=" + utilisateur.getNom()+ utilisateur.getPrenom() + ", Region="
				+ region.getNom() + ", longitude=" + longitude + ", latitude=" + latitude + ", description=" + description
				+ "]";
	}
	
	
	
}
