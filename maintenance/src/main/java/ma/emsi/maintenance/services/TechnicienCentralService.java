package ma.emsi.maintenance.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ma.emsi.maintenance.model.TechnicienCentral;
@Service("technicienServiceCentralService")
public interface TechnicienCentralService {
	public List<TechnicienCentral> getTechnicienCentrals();

}
