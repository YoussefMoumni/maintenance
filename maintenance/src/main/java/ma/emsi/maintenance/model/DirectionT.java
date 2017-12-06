package ma.emsi.maintenance.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DirectionT database table.
 * 
 */
@Entity
@Table(name="DirectionTechnique")
@DiscriminatorValue("DT")
//@NamedQuery(name="DirectionT.findAll", query="SELECT d FROM DirectionT d")
public class DirectionT extends Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;

	

	//bi-directional one-to-one association to Utilisateur
	@OneToOne
	@JoinColumn(name="idUtilisateur")
	private Utilisateur utilisateur;

	//bi-directional one-to-one association to DirectionTCentral
	@OneToOne(mappedBy="directionT")
	private DirectionTCentral directionTcentral;

	public DirectionT() {
	}

	

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public DirectionTCentral getDirectionTcentral() {
		return this.directionTcentral;
	}

	public void setDirectionTcentral(DirectionTCentral directionTcentral) {
		this.directionTcentral = directionTcentral;
	}

}