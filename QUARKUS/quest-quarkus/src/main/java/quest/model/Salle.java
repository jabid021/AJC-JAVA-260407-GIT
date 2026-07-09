package quest.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "salle")
public class Salle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 20, nullable = false)
	private String nom;

	@Embedded
	private Adresse adresse;

	@OneToMany(mappedBy = "salle")
	private List<Filiere> historique;

	public Salle() {
	}

	public Salle(Integer id, String nom, String numero, String voie, String ville, String cp) {
		this.id = id;
		this.nom = nom;
		this.adresse = new Adresse(numero, voie, ville, cp);
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Filiere> getHistorique() {
		return historique;
	}

	public void setHistorique(List<Filiere> historique) {
		this.historique = historique;
	}

	public String toString() {
		return "Salle [id=" + id + ", nom=" + nom + ", adresse=" + adresse + "]";
	}

}
