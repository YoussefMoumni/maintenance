package ma.emsi.maintenance.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the Atelier database table.
 * 
 */
@Entity
@NamedQuery(name="Atelier.findAll", query="SELECT a FROM Atelier a")
public class Atelier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private int idAtelier;
	
	private String code;
	
	private String specialite;

	//bi d one to chefatelier
	@OneToOne(mappedBy="atelier")
    private ChefAtelier chefatelier;
	
	//bi-directional many-to-one association to Usine
	
	@ManyToOne
	@JoinColumn(name="idUsine")
	private Usine usine;

	public Atelier() {
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getIdAtelier() {
		return this.idAtelier;
	}

	public void setIdAtelier(int idAtelier) {
		this.idAtelier = idAtelier;
	}

	public String getSpecialite() {
		return this.specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public Usine getUsine() {
		return this.usine;
	}

	public void setUsine(Usine usine) {
		this.usine = usine;
	}

}