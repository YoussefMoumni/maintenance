package ma.emsi.maintenance.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ma.emsi.maintenance.model.TechnicienCentral;
import ma.emsi.maintenance.services.TechnicienCentralService;
@Controller
@RequestMapping("TC")
public class TechnicienCentralController<TechncienCentral> {
	@Autowired
	TechnicienCentralService technicienCentalService;

	@GetMapping("all")
	@ResponseBody
	public List<TechnicienCentral> getall() {
	return technicienCentalService.getTechnicienCentrals();
	}
	
}
