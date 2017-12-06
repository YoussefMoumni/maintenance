package ma.emsi.maintenance.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the DirectionTCentral database table.
 * 
 */
@Entity
@Table(name="DirectionTechniqueC")
@DiscriminatorValue("DTC")
//@NamedQuery(name="DirectionTCentral.findAll", query="SELECT d FROM DirectionTCentral d")
public class DirectionTCentral extends DirectionT implements Serializable {
	private static final long serialVersionUID = 1L;

	

	//bi-directional one-to-one association to DirectionT
	@OneToOne
	@JoinColumn(name="idUtilisateur")
	private DirectionT directionT;

	//bi-directional many-to-one association to Enteprise
	@ManyToOne
	@JoinColumn(name="idEnteprise")
	private Enteprise enteprise;

	//bi-directional many-to-one association to Enteprise
	@OneToMany(mappedBy="directionTcentral", fetch=FetchType.EAGER)
	private Set<Enteprise> enteprises;

	public DirectionTCentral() {
	}

	

	public DirectionT getDirectionT() {
		return this.directionT;
	}

	public void setDirectionT(DirectionT directionT) {
		this.directionT = directionT;
	}

	public Enteprise getEnteprise() {
		return this.enteprise;
	}

	public void setEnteprise(Enteprise enteprise) {
		this.enteprise = enteprise;
	}

	public Set<Enteprise> getEnteprises() {
		return this.enteprises;
	}

	public void setEnteprises(Set<Enteprise> enteprises) {
		this.enteprises = enteprises;
	}

	public Enteprise addEntepris(Enteprise entepris) {
		getEnteprises().add(entepris);
		entepris.setDirectionTcentral(this);

		return entepris;
	}

	public Enteprise removeEntepris(Enteprise entepris) {
		getEnteprises().remove(entepris);
		entepris.setDirectionTcentral(null);

		return entepris;
	}

}