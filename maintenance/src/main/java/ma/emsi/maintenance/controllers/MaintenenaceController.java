package ma.emsi.maintenance.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ma.emsi.maintenance.model.Maintenance;
import ma.emsi.maintenance.services.MaintenanceService;

@Controller 
@RequestMapping("/maintenance") 
@CrossOrigin(origins = {"http://localhost:8888" , "http://localhost:3000"})

public class MaintenenaceController {
	@Autowired
	MaintenanceService maintenanceService;
	
	@GetMapping("/all")
	@ResponseBody
	public List<Maintenance> affichertouts() {
	return maintenanceService.getMaintenances();
	}
	
	
}
