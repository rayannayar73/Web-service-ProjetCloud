package projetCloud.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "chefRegion")
public class ChefRegion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nom", nullable = false)
	private String nom;
	
	@Column(name = "prenom", nullable = false)
	private String prenom;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "mdp", nullable = false)
	private String mdp ;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Region region;

	public ChefRegion(long id, String nom, String prenom, String email, String mdp, Region region) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
		this.region = region;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	@Override
	public String toString() {
		return "ChefRegion [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", mdp=" + mdp
				+ ", region=" + region + "]";
	}
}
