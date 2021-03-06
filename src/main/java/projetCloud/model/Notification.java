package projetCloud.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "notification")
public class Notification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	private Signalement signalement;

	@Column(name = "date")
    private Date daty;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Signalement getSignalement() {
		return signalement;
	}

	public void setSignalement(Signalement signalement) {
		this.signalement = signalement;
	}

	public Notification() {
		super();
	}

	public Notification(long id) {
		super();
		this.id = id;
	}

	public Notification(Signalement signalement) {
		super();
		this.daty = new Date();
		this.signalement = signalement;
	}

	public Notification(long id, Signalement signalement) {
		super();
		this.id = id;
		this.signalement = signalement;
	}

	

    /**
     * @return Date return the daty
     */
    public Date getDaty() {
        return daty;
    }

    /**
     * @param daty the daty to set
     */
    public void setDaty(Date daty) {
        this.daty = daty;
    }

}
