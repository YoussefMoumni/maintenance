package ma.emsi.maintenance.services;

import java.util.List;

import ma.emsi.maintenance.model.Machine;

public interface MachineService {

	List<Machine> getMachinesByAtelier(int atelier);

	List<Machine> getallMachines();

}
