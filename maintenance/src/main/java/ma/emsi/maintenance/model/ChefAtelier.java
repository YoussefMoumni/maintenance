package ma.emsi.maintenance.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;


/**
 * The persistent class for the ChefAtelier database table.
 * 
 */
@Entity
@DiscriminatorValue("CA")
//@NamedQuery(name="ChefAtelier.findAll", query="SELECT c FROM ChefAtelier c")
public class ChefAtelier extends Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;


	@OneToOne
	@JoinColumn(name="idAtelier")
	private Atelier atelier;

	//bi-directional one-to-one association to Utilisateur
	@OneToOne
	@JoinColumn(name="idUtilisateur")
	private Utilisateur utilisateur;

	//bi-directional many-to-one association to Maintenance
	@OneToMany(mappedBy="chefAtelier", fetch=FetchType.EAGER)
    private Set<Corrective> maintenances;

	public ChefAtelier() {
	}


	

	public Atelier getAtelier() {
		return atelier;
	}




	public void setAtelier(Atelier atelier) {
		this.atelier = atelier;
	}




	public Set<Corrective> getMaintenances() {
		return maintenances;
	}




	public void setMaintenances(Set<Corrective> maintenances) {
		this.maintenances = maintenances;
	}




	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	

}