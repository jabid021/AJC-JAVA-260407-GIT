package quest.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import quest.view.Views;

@Entity
@Table(name="module")
public class Module {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	private Integer id;
	@JsonView(Views.Common.class)
	private int quest;
	@Column(nullable = false)
	@JsonView(Views.Common.class)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate debut;
	@Column(nullable = false)
	@JsonView(Views.Common.class)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate fin;
	
	@ManyToOne
	@JoinColumn(name="matiere",nullable = false)
	@JsonView(Views.FiliereWithModules.class)
	private Matiere matiere;
	
	@ManyToOne
	@JoinColumn(name="filiere",nullable = false)
	@JsonView(Views.FormateurWithModules.class)
	private Filiere filiere;
	
	@ManyToOne
	@JoinColumn(name="formateur")
	@JsonView(Views.FiliereWithModules.class)
	private Formateur formateur;
	
	public Module() {}
	public Module(Integer id, int quest, LocalDate debut, LocalDate fin, Matiere matiere, Filiere filiere,
			Formateur formateur) {
		this.id = id;
		this.quest = quest;
		this.debut = debut;
		this.fin = fin;
		this.matiere = matiere;
		this.filiere = filiere;
		this.formateur = formateur;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getQuest() {
		return quest;
	}
	public void setQuest(int quest) {
		this.quest = quest;
	}
	public LocalDate getDebut() {
		return debut;
	}
	public void setDebut(LocalDate debut) {
		this.debut = debut;
	}
	public LocalDate getFin() {
		return fin;
	}
	public void setFin(LocalDate fin) {
		this.fin = fin;
	}
	public Matiere getMatiere() {
		return matiere;
	}
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
	public Filiere getFiliere() {
		return filiere;
	}
	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}
	public Formateur getFormateur() {
		return formateur;
	}
	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}
	@Override
	public String toString() {
		return "Module [id=" + id + ", quest=" + quest + ", debut=" + debut + ", fin=" + fin + ", matiere=" + matiere
				+ ", filiere=" + filiere + ", formateur=" + formateur + "]";
	}
	

}
