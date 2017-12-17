package ma.emsi.maintenance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ma.emsi.maintenance.model.Machine;

public interface MachineRepository extends JpaRepository <Machine , Integer>{
	
	//@Query("select m from Machine as m where m.idAtelier = ?1 ")
	List <Machine> findByidAtelier(int id);
}
