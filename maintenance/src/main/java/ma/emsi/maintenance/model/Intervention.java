package ma.emsi.maintenance.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import javax.persistence.ManyToOne;


/**
 * The persistent class for the Intervention database table.
 * 
 */
@Entity
@NamedQuery(name="Intervention.findAll", query="SELECT i FROM Intervention i")
public class Intervention implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@EmbeddedId
	private InterventionPK id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateDepart;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateinterv;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateRetour;
	private String techniciencomment;
	private String nature;
	private String type;

	//bi-directional many-to-one association to MCorrective
	@ManyToOne(optional=false)
	@JoinColumn(name="idMaintenance" ,insertable = false, updatable = false)
	private MCorrective mcorrective;

	//bi-directional many-to-one association to Technicien
	@ManyToOne
	@JoinColumn(name="idUtilisateur", insertable = false, updatable = false)
	private Technicien technicien;

	
	
	public Intervention() {
	}

	public InterventionPK getId() {
		return this.id;
	}

	public void setId(InterventionPK id) {
		this.id = id;
	}

	public Date getDateDepart() {
		return this.dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public Date getDateinterv() {
		return this.dateinterv;
	}

	public void setDateinterv(Date dateinterv) {
		this.dateinterv = dateinterv;
	}

	public Date getDateRetour() {
		return this.dateRetour;
	}

	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}

	public MCorrective getMcorrective() {
		return this.mcorrective;
	}

	public void setMcorrective(MCorrective mcorrective) {
		this.mcorrective = mcorrective;
	}

	public Technicien getTechnicien() {
		return this.technicien;
	}

	public void setTechnicien(Technicien technicien) {
		this.technicien = technicien;
	}

	public String getTechniciencomment() {
		return techniciencomment;
	}

	public void setTechniciencomment(String techniciencomment) {
		this.techniciencomment = techniciencomment;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}