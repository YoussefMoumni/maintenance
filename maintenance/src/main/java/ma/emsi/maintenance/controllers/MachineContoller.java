package ma.emsi.maintenance.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ma.emsi.maintenance.model.Machine;
import ma.emsi.maintenance.services.MachineService;

@Controller
@RequestMapping("machine") 

public class MachineContoller {

	@Autowired
	MachineService machineService;
	
	@GetMapping("/all")
	@ResponseBody
	public List<Machine> allmachines() {
		return machineService.getallMachines();	
	}
	
	@RequestMapping("/atelier/{idatelier}")
	@ResponseBody
	public List<Machine> allmachines(@PathVariable int idatelier){
		return machineService.getMachinesByAtelier(idatelier);
		
	}
	
	
}
