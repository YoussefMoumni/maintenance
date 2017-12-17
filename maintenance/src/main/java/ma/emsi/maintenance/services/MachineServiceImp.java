package ma.emsi.maintenance.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import ma.emsi.maintenance.model.Machine;
import ma.emsi.maintenance.repository.MachineRepository;
@Service("machineService")	
public class MachineServiceImp implements MachineService {
	@Autowired
	MachineRepository machineRepository ;
	
	@Override
	public List<Machine> getallMachines() {
		
		return machineRepository.findAll();
	}
	
	@Override
    public List <Machine> getMachinesByAtelier(@PathVariable int atelier){
		return machineRepository.findByidAtelier(atelier);
	}
	
	
	

}