package ma.emsi.maintenance.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.emsi.maintenance.model.Technicien;
import ma.emsi.maintenance.repository.TechnicienRepository;

@Service("technicienService")
public class TechnicienServiceImp  implements  TechnicienService{
	@Autowired
	TechnicienRepository technicienrepository;

	@Override
	public void ajoutertechnicien(Technicien t) {
	technicienrepository.save(t);
	}
	
	@Override
	public List<Technicien> getTechniciens() {
		return technicienrepository.findAll();
      }
}
