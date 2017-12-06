package ma.emsi.maintenance.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TechnicienCentral database table.
 * 
 */
@Entity
@Table(name="TechnicienCentral")
@DiscriminatorValue("TC")
//@NamedQuery(name="TechnicienCentral.findAll", query="SELECT t FROM TechnicienCentral t")
public class TechnicienCentral extends Technicien implements Serializable {
	private static final long serialVersionUID = 1L;

	

	//bi-directional many-to-one association to Enteprise
	@ManyToOne
	@JoinColumn(name="idEnteprise")
	private Enteprise enteprise;

	//bi-directional one-to-one association to Technicien
	@OneToOne
	@JoinColumn(name="idUtilisateur")
	private Technicien technicien;

	public TechnicienCentral() {
	}


	public Enteprise getEnteprise() {
		return this.enteprise;
	}

	public void setEnteprise(Enteprise enteprise) {
		this.enteprise = enteprise;
	}

	public Technicien getTechnicien() {
		return this.technicien;
	}

	public void setTechnicien(Technicien technicien) {
		this.technicien = technicien;
	}

}