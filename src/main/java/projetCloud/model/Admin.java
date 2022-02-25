package projetCloud.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin implements Serializable{

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
	private String mdp;
	
	public Admin() {
		super();
	}
	
	public Admin(long id) {
		super();
		this.id = id;
	}

	public Admin(String email) {
		super();
		this.email = email;
	}

	public Admin(String nom, String prenom, String email, String mdp) {
		super();
		this.nom = nom;
		this.prenom = prenom;
        this.email = email;
		this.mdp = mdp;
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

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
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

}
