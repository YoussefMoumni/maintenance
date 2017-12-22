package ma.emsi.maintenance.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ma.emsi.maintenance.model.Technicien;
import ma.emsi.maintenance.services.TechnicienService;

@Controller 
@RequestMapping("T") 
@CrossOrigin(origins = "http://localhost:8888")

public class TechnicienController {
	@Autowired
	TechnicienService technicienService;
	
	@GetMapping("/all")
	@ResponseBody
	public List<Technicien> getall() {
	return technicienService.getTechniciens(); 
	}
	
}
