package projetCloud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {

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
	
	public Utilisateur() {
		super();
	}
	
	public Utilisateur(long id) {
		super();
		this.id = id;
	}

	public Utilisateur(long id,String nom, String prenom, String email, String mdp) {
		super();
		this.nom = nom;
		this.prenom = prenom;
        this.email = email;
		this.mdp = mdp;
	}
	public Utilisateur(String nom, String prenom, String email, String mdp) {
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
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom +" email="+email +" mdp="+ mdp + "]";
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
