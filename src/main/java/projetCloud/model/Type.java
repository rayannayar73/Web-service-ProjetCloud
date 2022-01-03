package projetCloud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "type")
public class Type {

	private long id;
	private String nom;
	
	public Type() {
		
	}
	
	public Type(String nom) {
		this.nom = nom;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "nom", nullable = false)
	public String getNom() {
		return nom;
	}
	public void setNom(String firstName) {
		this.nom = firstName;
	}
	
	@Override
	public String toString() {
		return "Type [id=" + id + ", nom=" + nom + "]";
	}
	
}
