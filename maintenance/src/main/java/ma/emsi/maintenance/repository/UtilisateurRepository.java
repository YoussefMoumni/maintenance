/**
 * 
 */
package ma.emsi.maintenance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.emsi.maintenance.model.Utilisateur;



/**
 * @author ab
 *
 */
public interface UtilisateurRepository extends JpaRepository <Utilisateur, Integer > {

public Utilisateur findByLogin (String login);
}
