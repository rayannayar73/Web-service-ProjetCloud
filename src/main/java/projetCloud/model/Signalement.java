package projetCloud.model;

import java.util.Date;

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
	
	@Column(name = "dateSignalement", nullable = false)
	private Date dateSignalement;
	
	@Column(name = "dateFinSignalement", nullable = true)
	private Date dateFinSignalement;

	@ManyToOne
	private Type type;
	 
	@ManyToOne
	private Utilisateur utilisateur;
	
	@ManyToOne
	private Region region;
	
	@ManyToOne
	private Etat etat;
	
	public Signalement() {
		
	}
	public Signalement(long id, float longitude, float latitude, String description, Date dateSignalement, Date dateFinSignalement, Type type,
			Etat etat, Utilisateur utilisateur, Region region) {
		super();
		this.id = id;
		this.longitude = longitude;
		this.latitude = latitude;
		this.description = description;
		this.dateSignalement = dateSignalement;
		this.dateFinSignalement = dateFinSignalement;
		this.type = type;
		this.utilisateur = utilisateur;
		this.region = region;
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

	
	public Date getDateSignalement() {
		return dateSignalement;
	}

	public void setDateSignalement(Date dateSignalement) {
		this.dateSignalement = dateSignalement;
	}

	public Date getDateFinSignalement() {
		return dateFinSignalement;
	}

	public void setDateFinSignalement(Date dateFinSignalement) {
		this.dateFinSignalement = dateFinSignalement;
	}

	
	@Override
	public String toString() {
		return "Signalement [id=" + id + ", longitude=" + longitude + ", latitude=" + latitude + ", description="
				+ description + ", dateSignalement=" + dateSignalement+ ", dateFinSignalement=" + dateFinSignalement + ", type=" + type + ", etat=" + etat
				+ ", utilisateur=" + utilisateur + ", region=" + region + "]";
	}
	
}
