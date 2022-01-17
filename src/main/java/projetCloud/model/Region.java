package projetCloud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "region")
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nom")
    private String nom;
    
    
    
    public Region() {
		super();
	}
	public Region(long id) {
		super();
		this.id = id;
	}
	public long getId(){
        return id;
    }
    public void setId(long id){
        this.id=id;
    }
    public String getNom(){
        return nom;
    }
    public void setNom(String nom){
        this.nom=nom;
    }
    @Override
    public String toString() {
		return "Region [id=" + id + ", nom=" + nom + "]";
	}
}
