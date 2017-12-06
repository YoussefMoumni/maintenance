package ma.emsi.maintenance.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import javax.persistence.OneToMany;


/**
 * The persistent class for the Machine database table.
 * 
 */
@Entity
@NamedQuery(name="Machine.findAll", query="SELECT m FROM Machine m")
public class Machine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMachine;

	@Temporal(TemporalType.TIMESTAMP)
	private Date achatDate;

	private String code;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dernierIntervention;

	private int idAtelier;

	private String marque;

	private String model;

	@Temporal(TemporalType.TIMESTAMP)
	private Date productionDate;

	//bi-directional many-to-one association to MCorrective
	@OneToMany(mappedBy="machine", fetch=FetchType.EAGER)
	private Set<MCorrective> mcorrectives;

	public Machine() {
	}

	public int getIdMachine() {
		return this.idMachine;
	}

	public void setIdMachine(int idMachine) {
		this.idMachine = idMachine;
	}

	public Date getAchatDate() {
		return this.achatDate;
	}

	public void setAchatDate(Date achatDate) {
		this.achatDate = achatDate;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getDernierIntervention() {
		return this.dernierIntervention;
	}

	public void setDernierIntervention(Date dernierIntervention) {
		this.dernierIntervention = dernierIntervention;
	}

	public int getIdAtelier() {
		return this.idAtelier;
	}

	public void setIdAtelier(int idAtelier) {
		this.idAtelier = idAtelier;
	}

	public String getMarque() {
		return this.marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Date getProductionDate() {
		return this.productionDate;
	}

	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}

	public Set<MCorrective> getMcorrectives() {
		return this.mcorrectives;
	}

	public void setMcorrectives(Set<MCorrective> mcorrectives) {
		this.mcorrectives = mcorrectives;
	}

	public MCorrective addMcorrective(MCorrective mcorrective) {
		getMcorrectives().add(mcorrective);
		mcorrective.setMachine(this);

		return mcorrective;
	}

	public MCorrective removeMcorrective(MCorrective mcorrective) {
		getMcorrectives().remove(mcorrective);
		mcorrective.setMachine(null);

		return mcorrective;
	}

}