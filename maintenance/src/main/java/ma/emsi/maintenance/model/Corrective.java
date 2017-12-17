package ma.emsi.maintenance.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@DiscriminatorValue("C")
public class Corrective  extends Maintenance  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String chefateliertcmt;     //// ecrit parf chef atelier 

	@Temporal(TemporalType.TIMESTAMP)
	private Date declarDateTime;        //// auto lors de la declaration du chef 

	private byte demandeMateriel;       ///// par le technicien 

	private boolean demandeSiege;       ///// 

	private String gravite;
	
	//bi-directional many-to-one association to ChefAtelier
    @ManyToOne
    @JoinColumn(name="idUtilisateur", nullable = false ,insertable=false, updatable=false)
	private ChefAtelier chefAtelier;
     
	
	

}
