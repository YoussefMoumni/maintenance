package ma.emsi.maintenance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.emsi.maintenance.model.Technicien;

public interface TechnicienRepository extends JpaRepository <Technicien, Long > {

	
}
