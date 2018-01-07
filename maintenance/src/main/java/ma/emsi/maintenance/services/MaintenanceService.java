package ma.emsi.maintenance.services;
import java.util.List;

import ma.emsi.maintenance.model.Maintenance;

public interface MaintenanceService {
   List <Maintenance> getMaintenances();
}
