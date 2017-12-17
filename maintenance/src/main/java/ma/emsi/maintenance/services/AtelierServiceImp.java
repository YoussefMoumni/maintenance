package ma.emsi.maintenance.services;

import java.util.List;

import ma.emsi.maintenance.model.Atelier;
import ma.emsi.maintenance.repository.AtelierRepository;
import ma.emsi.maintenance.model.Machine;

public class AtelierServiceImp {
	
	AtelierRepository atelierRepository;
	
	Atelier getAtelierById(int id) {
		return atelierRepository.findOne(id);
	}
	
	List <Machine> getAtelierMAchines(){
		return null;
		
		
	}
	

}
