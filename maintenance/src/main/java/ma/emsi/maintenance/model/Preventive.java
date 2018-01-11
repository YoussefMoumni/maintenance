package ma.emsi.maintenance.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;

@Entity
@DiscriminatorValue("P")
public class Preventive  extends Maintenance  implements Serializable {


	private static final long serialVersionUID = 1L;

	public Preventive() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
