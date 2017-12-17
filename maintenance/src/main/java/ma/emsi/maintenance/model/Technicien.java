package ma.emsi.maintenance.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the Technicien database table.
 * 
 */
@Entity
@Inheritance
@DiscriminatorValue("T")

//@NamedQuery(name="Technicien.findAll", query="SELECT t FROM Technicien t")
public class Technicien extends Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;

	private String specialite;

	//bi-directional many-to-one association to Intervention
	@OneToMany(mappedBy="technicien", fetch=FetchType.EAGER)
	private Set<Intervention> interventions;


	
	
	public Technicien() {
	}

	
	

	public Technicien(String login, String mdp, String nom, String prenom , String specialite) {
		super(login, mdp, nom, prenom);
		this.specialite=specialite;
		
	}




	public String getSpecialite() {
		return this.specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public Set<Intervention> getInterventions() {
		return this.interventions;
	}

	public void setInterventions(Set<Intervention> interventions) {
		this.interventions = interventions;
	}

	public Intervention addIntervention(Intervention intervention) {
		getInterventions().add(intervention);
		intervention.setTechnicien(this);

		return intervention;
	}

	public Intervention removeIntervention(Intervention intervention) {
		getInterventions().remove(intervention);
		intervention.setTechnicien(null);

		return intervention;
	}

	
}