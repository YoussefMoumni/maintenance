package ma.emsi.maintenance.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.emsi.maintenance.model.TechnicienCentral;
import ma.emsi.maintenance.repository.TechnicienCentralRepository;

@Service("technicienCentalService")
class TechnicienCentalServiceImp implements TechnicienCentralService {
	@Autowired
	TechnicienCentralRepository technicienCentalRepository;
	
	@Override
	public List<TechnicienCentral> getTechnicienCentrals() {
		return technicienCentalRepository.findAll();
		
	}
}