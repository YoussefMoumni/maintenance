package ma.emsi.maintenance.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.emsi.maintenance.model.Utilisateur;
import ma.emsi.maintenance.repository.UtilisateurRepository;
@Service("utilisateurService")	
public class UtilisateurServiceImp implements UtilisateurService {
	@Autowired
	UtilisateurRepository utilisateurRepository; 
	
	
	@Override
	public void ajouterUtilisateur(Utilisateur U) {
		utilisateurRepository.save(U);	
	}
	@Override
	public Utilisateur getUtilisateur(int id) {
		return utilisateurRepository.findOne(id);
	}
	@Override
	public Utilisateur getUtilisateurByLogin(String login) {
		return utilisateurRepository.findBylogin(login);
	}
	@Override 
	public List<Utilisateur> getUtilisateurs() {
		return utilisateurRepository.findAll();
	}
	@Override 
	public Utilisateur RechercheParLogin(String login) {
		return utilisateurRepository.findBylogin(login);
	}

}
