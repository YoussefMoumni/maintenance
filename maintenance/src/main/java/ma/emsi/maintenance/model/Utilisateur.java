package ma.emsi.maintenance.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Utilisateur database table.
 * 
 */

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Table(name="Utilisateur")
@DiscriminatorColumn(name="type",discriminatorType=DiscriminatorType.STRING)


//@NamedQuery(name="Utilisateur.findAll", query="SELECT u FROM Utilisateur u")
public  abstract class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable = false)
	private int idUtilisateur;
	@Column(nullable = false)
	private String login;
	@Column(nullable = false)
	private String mdp;

	private String nom;

	private String prenom;




	//bi-directional many-to-one association to Usine
	@ManyToOne
	@JoinColumn(name="idUsine")
	private Usine usine;
//////////////////////////////////////////////////////////////////////////////////////////////////////
	public Utilisateur() {
	}
	public Utilisateur(String login, String mdp, String nom, String prenom) {
	
	this.login = login;
	this.mdp = mdp;
	this.nom = nom;
	this.prenom = prenom;
}

	
	public int getIdUtilisateur() {
		return this.idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return this.mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Usine getUsine() {
		return this.usine;
	}

	public void setUsine(Usine usine) {
		this.usine = usine;
	}

}