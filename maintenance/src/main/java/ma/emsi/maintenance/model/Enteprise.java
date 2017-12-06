package ma.emsi.maintenance.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


/**
 * The persistent class for the Enteprise database table.
 * 
 */
@Entity
@NamedQuery(name="Enteprise.findAll", query="SELECT e FROM Enteprise e")
public class Enteprise implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEnteprise;

	private String adresse;

	private String description;

	private String label;

	//bi-directional many-to-one association to DirectionTCentral
	@OneToMany(mappedBy="enteprise", fetch=FetchType.EAGER)
	private Set<DirectionTCentral> directionTcentrals;

	//bi-directional many-to-one association to DirectionTCentral
	@ManyToOne
	@JoinColumn(name="idUtilisateur")
	private DirectionTCentral directionTcentral;

	//bi-directional many-to-one association to TechnicienCentral
	@OneToMany(mappedBy="enteprise", fetch=FetchType.EAGER)
	private Set<TechnicienCentral> technicienCentrals;

	public Enteprise() {
	}

	public int getIdEnteprise() {
		return this.idEnteprise;
	}

	public void setIdEnteprise(int idEnteprise) {
		this.idEnteprise = idEnteprise;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Set<DirectionTCentral> getDirectionTcentrals() {
		return this.directionTcentrals;
	}

	public void setDirectionTcentrals(Set<DirectionTCentral> directionTcentrals) {
		this.directionTcentrals = directionTcentrals;
	}

	public DirectionTCentral addDirectionTcentral(DirectionTCentral directionTcentral) {
		getDirectionTcentrals().add(directionTcentral);
		directionTcentral.setEnteprise(this);

		return directionTcentral;
	}

	public DirectionTCentral removeDirectionTcentral(DirectionTCentral directionTcentral) {
		getDirectionTcentrals().remove(directionTcentral);
		directionTcentral.setEnteprise(null);

		return directionTcentral;
	}

	public DirectionTCentral getDirectionTcentral() {
		return this.directionTcentral;
	}

	public void setDirectionTcentral(DirectionTCentral directionTcentral) {
		this.directionTcentral = directionTcentral;
	}

	public Set<TechnicienCentral> getTechnicienCentrals() {
		return this.technicienCentrals;
	}

	public void setTechnicienCentrals(Set<TechnicienCentral> technicienCentrals) {
		this.technicienCentrals = technicienCentrals;
	}

	public TechnicienCentral addTechnicienCentral(TechnicienCentral technicienCentral) {
		getTechnicienCentrals().add(technicienCentral);
		technicienCentral.setEnteprise(this);

		return technicienCentral;
	}

	public TechnicienCentral removeTechnicienCentral(TechnicienCentral technicienCentral) {
		getTechnicienCentrals().remove(technicienCentral);
		technicienCentral.setEnteprise(null);

		return technicienCentral;
	}

}