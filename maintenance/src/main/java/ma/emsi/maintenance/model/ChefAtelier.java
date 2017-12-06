package ma.emsi.maintenance.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the ChefAtelier database table.
 * 
 */
@Entity
@DiscriminatorValue("CA")
//@NamedQuery(name="ChefAtelier.findAll", query="SELECT c FROM ChefAtelier c")
public class ChefAtelier extends Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;



	private int idAtelier;

	//bi-directional one-to-one association to Utilisateur
	@OneToOne
	@JoinColumn(name="idUtilisateur")
	private Utilisateur utilisateur;

	//bi-directional many-to-one association to MCorrective
	@OneToMany(mappedBy="chefAtelier", fetch=FetchType.EAGER)
	private Set<MCorrective> mcorrectives;

	public ChefAtelier() {
	}



	public int getIdAtelier() {
		return this.idAtelier;
	}

	public void setIdAtelier(int idAtelier) {
		this.idAtelier = idAtelier;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Set<MCorrective> getMcorrectives() {
		return this.mcorrectives;
	}

	public void setMcorrectives(Set<MCorrective> mcorrectives) {
		this.mcorrectives = mcorrectives;
	}

	public MCorrective addMcorrective(MCorrective mcorrective) {
		getMcorrectives().add(mcorrective);
		mcorrective.setChefAtelier(this);

		return mcorrective;
	}

	public MCorrective removeMcorrective(MCorrective mcorrective) {
		getMcorrectives().remove(mcorrective);
		mcorrective.setChefAtelier(null);

		return mcorrective;
	}

}