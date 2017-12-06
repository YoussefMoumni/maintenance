package ma.emsi.maintenance.services;

import java.util.List;

import ma.emsi.maintenance.model.Technicien;

public interface TechnicienService {
	void ajoutertechnicien(Technicien t);

	List<Technicien> getTechniciens();

}
