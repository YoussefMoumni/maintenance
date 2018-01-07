package ma.emsi.maintenance.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ma.emsi.maintenance.model.Machine;
import ma.emsi.maintenance.services.MachineService;

@Controller
@RequestMapping("machine") 
@CrossOrigin(origins = {"http://localhost:8888" , "http://localhost:3000"})
public class MachineContoller {

	@Autowired
	MachineService machineService;
	
	@GetMapping("/all")
	@ResponseBody
	public List<Machine> allmachines() {
		return machineService.getallMachines();	
	}
	
	@GetMapping("/liste")
	public String main(Model m) {
		m.addAttribute("machines", machineService.getallMachines());
		return "CA";
	}
	
	@RequestMapping("/atelier/{idatelier}")
	@ResponseBody
	public List<Machine> allmachines(@PathVariable int idatelier){
		return machineService.getMachinesByAtelier(idatelier);
		
	}
	
	
}
