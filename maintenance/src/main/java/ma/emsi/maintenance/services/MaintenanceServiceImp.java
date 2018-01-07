package ma.emsi.maintenance.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.emsi.maintenance.model.Maintenance;
import ma.emsi.maintenance.repository.MaintenanceRepository;
@Service("maintenanceService")	

public class MaintenanceServiceImp implements MaintenanceService {
	@Autowired
  MaintenanceRepository maintenanceRepository;
	@Override
	public List<Maintenance> getMaintenances() {
		return maintenanceRepository.findAll();
	
	}

}
