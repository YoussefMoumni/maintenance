package ma.emsi.maintenance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan
@EntityScan("ma.emsi.maintenance.model")
@EnableJpaRepositories("ma.emsi.maintenance.repository")
public class MaintenanceApplication {
	public static void main(String[] args) {
		SpringApplication.run(MaintenanceApplication.class, args);
	
		
	}
}
