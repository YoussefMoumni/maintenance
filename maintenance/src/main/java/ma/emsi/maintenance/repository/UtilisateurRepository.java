/**
 * 
 */
package ma.emsi.maintenance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import ma.emsi.maintenance.model.Utilisateur;



/**
 * @author ab
 *
 */
public interface UtilisateurRepository extends JpaRepository <Utilisateur, Integer > , QueryByExampleExecutor<Utilisateur> {

	//@Query("select u from Utilisateur as u where u.login = ?1 ")
	Utilisateur findBylogin(String login);




}
