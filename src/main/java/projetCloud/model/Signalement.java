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
	
	@Column(name = "idRegion", nullable = false)
	private long idRegion;
	
	@Column(name = "longitude", nullable = false)
	private float longitude;
	
	@Column(name = "latitude", nullable = false)
	private float latitude;
	
	@Column(name = "description", nullable = false)
	private String description;

	@ManyToOne(cascade=CascadeType.ALL)
	private Type type;
	 
	@ManyToOne(cascade=CascadeType.ALL)
	private Utilisateur utilisateur;
	
	public Signalement() {
		
	}
	
	public Signalement(long idType, long idUtilisateur, long idRegion, float longitude, float latitude,
			String description) {
		this.type.setId(idType);
		this.utilisateur.setId(idUtilisateur);
		this.idRegion = idRegion;
		this.longitude = longitude;
		this.latitude = latitude;
		this.description = description;
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

	public long getIdRegion() {
		return idRegion;
	}


	public void setIdRegion(long idRegion) {
		this.idRegion = idRegion;
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
		return "Signalement [id=" + id + ", type=" + type.getNom() + ", idUtilisateur=" + utilisateur + ", idRegion="
				+ idRegion + ", longitude=" + longitude + ", latitude=" + latitude + ", description=" + description
				+ "]";
	}
	
	
	
}
