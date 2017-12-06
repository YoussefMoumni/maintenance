package ma.emsi.maintenance.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


/**
 * The persistent class for the MCorrective database table.
 * 
 */
@Entity
@NamedQuery(name="MCorrective.findAll", query="SELECT m FROM MCorrective m")
public class MCorrective implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMaintenance;

	private String chefateliertcmt;     //// ecrit parf chef atelier 

	@Temporal(TemporalType.TIMESTAMP)
	private Date declarDateTime;        //// auto lors de la declaration du chef 

	private byte demandeMateriel;       //// par le technicien 

	private boolean demandeSiege;           /////

	private String gravite;

	private String nature;

	private byte resolut;

	@Temporal(TemporalType.TIMESTAMP)
	private Date resolutDateTime;

	private String type;

	//bi-directional many-to-one association to Intervention
	@OneToMany(mappedBy="mcorrective", fetch=FetchType.EAGER)
	private Set<Intervention> interventions;

	//bi-directional many-to-one association to ChefAtelier
	@ManyToOne
	@JoinColumn(name="idUtilisateur")
	private ChefAtelier chefAtelier;

	//bi-directional many-to-one association to Machine
	@ManyToOne
	@JoinColumn(name="idMachine")
	private Machine machine;

	//bi-directional one-to-one association to MPreventive
	@OneToOne(mappedBy="mcorrective")
	private MPreventive mpreventive;

	public MCorrective() {
	}

	public int getIdMaintenance() {
		return this.idMaintenance;
	}

	public void setIdMaintenance(int idMaintenance) {
		this.idMaintenance = idMaintenance;
	}

	

	public Date getDeclarDateTime() {
		return this.declarDateTime;
	}

	public void setDeclarDateTime(Date declarDateTime) {
		this.declarDateTime = declarDateTime;
	}

	public byte getDemandeMateriel() {
		return this.demandeMateriel;
	}

	public void setDemandeMateriel(byte demandeMateriel) {
		this.demandeMateriel = demandeMateriel;
	}

	

	public String getGravite() {
		return this.gravite;
	}

	public void setGravite(String gravite) {
		this.gravite = gravite;
	}

	public String getNature() {
		return this.nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public byte getResolut() {
		return this.resolut;
	}

	public void setResolut(byte resolut) {
		this.resolut = resolut;
	}

	public Date getResolutDateTime() {
		return this.resolutDateTime;
	}

	public void setResolutDateTime(Date resolutDateTime) {
		this.resolutDateTime = resolutDateTime;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<Intervention> getInterventions() {
		return this.interventions;
	}

	public void setInterventions(Set<Intervention> interventions) {
		this.interventions = interventions;
	}

	public Intervention addIntervention(Intervention intervention) {
		getInterventions().add(intervention);
		intervention.setMcorrective(this);

		return intervention;
	}

	public Intervention removeIntervention(Intervention intervention) {
		getInterventions().remove(intervention);
		intervention.setMcorrective(null);

		return intervention;
	}

	public ChefAtelier getChefAtelier() {
		return this.chefAtelier;
	}

	public void setChefAtelier(ChefAtelier chefAtelier) {
		this.chefAtelier = chefAtelier;
	}

	public Machine getMachine() {
		return this.machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}

	public MPreventive getMpreventive() {
		return this.mpreventive;
	}

	public void setMpreventive(MPreventive mpreventive) {
		this.mpreventive = mpreventive;
	}

}