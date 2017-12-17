package ma.emsi.maintenance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ma.emsi.maintenance.model.Atelier;

public interface AtelierRepository extends JpaRepository <Atelier , Integer>  {

	
}
