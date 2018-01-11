package ma.emsi.maintenance.model;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Table(name="Maintenance")
@DiscriminatorColumn(name="type",discriminatorType=DiscriminatorType.STRING)
public class Maintenance {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable = false)
	private int idUtilisateur;
	private String nature;
	private byte resolut;
	@Temporal(TemporalType.TIMESTAMP)
	private Date resolutDateTime;
	
	 //bi-directional many-to-one association to Machine
		@ManyToOne
        @JoinColumn(name="idMachine")
		private Machine machine;
		//bi-directional many-to-one association to Intervention
		@OneToMany(mappedBy="maintenance", fetch=FetchType.EAGER)
		private Set<Intervention> interventions;
     
		@Column(insertable=false , updatable=false)
		private String type;
		
		public String getNature() {
			return nature;
		}

		public void setNature(String nature) {
			this.nature = nature;
		}

		public Machine getMachine() {
			return machine;
		}

		public void setMachine(Machine machine) {
			this.machine = machine;
		}

		public int getIdUtilisateur() {
			return idUtilisateur;
		}

		public void setIdUtilisateur(int idUtilisateur) {
			this.idUtilisateur = idUtilisateur;
		}

		public byte getResolut() {
			return resolut;
		}

		public void setResolut(byte resolut) {
			this.resolut = resolut;
		}

		public Date getResolutDateTime() {
			return resolutDateTime;
		}

		public void setResolutDateTime(Date resolutDateTime) {
			this.resolutDateTime = resolutDateTime;
		}

		public Set<Intervention> getInterventions() {
			return interventions;
		}

		public void setInterventions(Set<Intervention> interventions) {
			this.interventions = interventions;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}
		
		
		
		
		
		
}
