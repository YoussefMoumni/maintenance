package ma.emsi.maintenance.services;

import java.util.List;

import ma.emsi.maintenance.model.Utilisateur;

public interface UtilisateurService {

	Utilisateur getUtilisateur(int id);
     
	List<Utilisateur> getUtilisateurs();
	
	Utilisateur getUtilisateurByLogin(String login);
	
	void ajouterUtilisateur(Utilisateur U);
}
