package projetCloud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "signalement")
public class Signalement {

	private long id;
	private long idType;
	private long idUtilisateur;
	private long idRegion;
	private float longitude;
	private float latitude;
	private String description;
	
	public Signalement() {
		
	}
	
	public Signalement(long idType, long idUtilisateur, long idRegion, float longitude, float latitude,
			String description) {
		this.idType = idType;
		this.idUtilisateur = idUtilisateur;
		this.idRegion = idRegion;
		this.longitude = longitude;
		this.latitude = latitude;
		this.description = description;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "idType", nullable = false)
	public long getIdType() {
		return idType;
	}


	public void setIdType(long idType) {
		this.idType = idType;
	}

	@Column(name = "idUtilisateur", nullable = false)
	public long getIdUtilisateur() {
		return idUtilisateur;
	}


	public void setIdUtilisateur(long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	@Column(name = "idRegion", nullable = false)
	public long getIdRegion() {
		return idRegion;
	}


	public void setIdRegion(long idRegion) {
		this.idRegion = idRegion;
	}

	@Column(name = "longitude", nullable = false)
	public float getLongitude() {
		return longitude;
	}


	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	@Column(name = "latitude", nullable = false)
	public float getLatitude() {
		return latitude;
	}


	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	@Column(name = "description", nullable = false)
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Signalement [id=" + id + ", idType=" + idType + ", idUtilisateur=" + idUtilisateur + ", idRegion="
				+ idRegion + ", longitude=" + longitude + ", latitude=" + latitude + ", description=" + description
				+ "]";
	}
	
	
	
}
