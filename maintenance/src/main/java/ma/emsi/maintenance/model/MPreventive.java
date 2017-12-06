package ma.emsi.maintenance.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import javax.persistence.OneToOne;


/**
 * The persistent class for the MPreventive database table.
 * 
 */
@Entity
@NamedQuery(name="MPreventive.findAll", query="SELECT m FROM MPreventive m")
public class MPreventive extends MCorrective implements Serializable {
	private static final long serialVersionUID = 1L;



	@Temporal(TemporalType.TIMESTAMP)
	private Date preventionDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date prochaineDate;

	private String traitement;

	//bi-directional one-to-one association to MCorrective
	@OneToOne
	@JoinColumn(name="idMaintenance")
	private MCorrective mcorrective;

	public MPreventive() {
	}



	public Date getPreventionDate() {
		return this.preventionDate;
	}

	public void setPreventionDate(Date preventionDate) {
		this.preventionDate = preventionDate;
	}

	public Date getProchaineDate() {
		return this.prochaineDate;
	}

	public void setProchaineDate(Date prochaineDate) {
		this.prochaineDate = prochaineDate;
	}

	public String getTraitement() {
		return this.traitement;
	}

	public void setTraitement(String traitement) {
		this.traitement = traitement;
	}

	public MCorrective getMcorrective() {
		return this.mcorrective;
	}

	public void setMcorrective(MCorrective mcorrective) {
		this.mcorrective = mcorrective;
	}

}