package ma.emsi.maintenance.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


/**
 * The persistent class for the Usine database table.
 * 
 */
@Entity
@Table(name="usine")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idUsine")

//@NamedQuery(name="Usine.findAll", query="SELECT u FROM Usine u")
public class Usine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUsine;

	private String adresse;

	private String code;

	private String label;

	private String specialite;

	//bi-directional many-to-one association to Atelier
	@OneToMany(mappedBy="usine", fetch=FetchType.EAGER)

	private Set<Atelier> ateliers;

	//bi-directional many-to-one association to Utilisateur
	@OneToMany(mappedBy="usine", fetch=FetchType.EAGER)
	@JsonIgnore
	private Set<Utilisateur> utilisateurs;

	public Usine() {
	}

	public int getIdUsine() {
		return this.idUsine;
	}

	public void setIdUsine(int idUsine) {
		this.idUsine = idUsine;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getSpecialite() {
		return this.specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public Set<Atelier> getAteliers() {
		return this.ateliers;
	}

	public void setAteliers(Set<Atelier> ateliers) {
		this.ateliers = ateliers;
	}

	public Atelier addAtelier(Atelier atelier) {
		getAteliers().add(atelier);
		atelier.setUsine(this);

		return atelier;
	}

	public Atelier removeAtelier(Atelier atelier) {
		getAteliers().remove(atelier);
		atelier.setUsine(null);

		return atelier;
	}

	public Set<Utilisateur> getUtilisateurs() {
		return this.utilisateurs;
	}

	public void setUtilisateurs(Set<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public Utilisateur addUtilisateur(Utilisateur utilisateur) {
		getUtilisateurs().add(utilisateur);
		utilisateur.setUsine(this);

		return utilisateur;
	}

	public Utilisateur removeUtilisateur(Utilisateur utilisateur) {
		getUtilisateurs().remove(utilisateur);
		utilisateur.setUsine(null);

		return utilisateur;
	}

}