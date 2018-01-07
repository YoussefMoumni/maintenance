package ma.emsi.maintenance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.emsi.maintenance.model.Maintenance;

public interface MaintenanceRepository extends JpaRepository <Maintenance , Integer> {

}
