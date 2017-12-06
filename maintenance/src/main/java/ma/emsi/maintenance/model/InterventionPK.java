package ma.emsi.maintenance.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * The primary key class for the Intervention database table.
 * 
 */
@Entity
@Embeddable
public class InterventionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int idUtilisateur;

	@Column(insertable=false, updatable=false)
	private int idMaintenance;

	@Id
	@GeneratedValue
	private int id;

	public InterventionPK() {
	}
	public int getIdUtilisateur() {
		return this.idUtilisateur;
	}
	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	public int getIdMaintenance() {
		return this.idMaintenance;
	}
	public void setIdMaintenance(int idMaintenance) {
		this.idMaintenance = idMaintenance;
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof InterventionPK)) {
			return false;
		}
		InterventionPK castOther = (InterventionPK)other;
		return 
			(this.idUtilisateur == castOther.idUtilisateur)
			&& (this.idMaintenance == castOther.idMaintenance)
			&& (this.id == castOther.id);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idUtilisateur;
		hash = hash * prime + this.idMaintenance;
		hash = hash * prime + this.id;
		
		return hash;
	}
}