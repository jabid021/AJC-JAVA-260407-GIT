package demo.model.perclass;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="vehicule")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(sequenceName = "auto_increment_id_vehicule", name = "seqVehicule")
public abstract class Vehicule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqVehicule" )
	@Column(name="id_vehicule")
	protected Integer id;
	protected int nbRoues;
	protected int capacite;
	
	public Vehicule() {}
	
	public Vehicule(int nbRoues, int capacite) {
		this.nbRoues = nbRoues;
		this.capacite = capacite;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getNbRoues() {
		return nbRoues;
	}

	public void setNbRoues(int nbRoues) {
		this.nbRoues = nbRoues;
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	
	
	

}
