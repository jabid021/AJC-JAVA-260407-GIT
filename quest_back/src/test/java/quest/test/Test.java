package quest.test;

import java.time.LocalDate;

import quest.model.Filiere;
import quest.model.Formateur;
import quest.model.Genre;
import quest.model.Matiere;
import quest.model.Module;
import quest.model.Ordinateur;
import quest.model.Salle;
import quest.model.Stagiaire;

public class Test {

	public static void main(String[] args) {
		Salle salle1 = new Salle(null,"Violet","161","avenue de verdun","92400","Ivry sur seine");
		Filiere filiere1 = new Filiere(null,"SOPRA-JAVA-260209",LocalDate.parse("2026-02-09"),LocalDate.parse("2026-05-12"),salle1);
		Filiere filiere2 = new Filiere(null,"SOPRA-JAVA-260407",LocalDate.parse("2026-04-07"),LocalDate.parse("2026-07-15"),null);

		Stagiaire stagiaire1 = new Stagiaire(null,"stagiaire1","stagiaire1","Doe","John",Genre.Homme,"john@gmail.co","6","rue rougemont","75009","Paris",filiere1);
		Stagiaire stagiaire2 = new Stagiaire(null,"stagiaire2","stagiaire2","Doe","Jane",Genre.Femme,"jane@gmail.co","12","avenue de paris","75011","Paris",filiere2);


		Formateur formateur1 = new Formateur(null,"formateur1","formateur1","Abid","Jordan",Genre.Homme,true);
		Formateur formateur2 = new Formateur(null,"formateur2","formateur2","Perrouault","Jeremy",Genre.Homme, false);

		
		Ordinateur ordinateur1 = new Ordinateur(null,"Asus",8,stagiaire1);
		Ordinateur ordinateur2 = new Ordinateur(null,"Apple",16,null);
		
		Matiere matiere1 = new Matiere(null,"SQL");
		Matiere matiere2 = new Matiere(null,"Spring Core");
		Matiere matiere3 = new Matiere(null,"Angular");
		
		
		Module module1 = new Module(null,4659,LocalDate.parse("2026-02-09"),LocalDate.parse("2026-02-12"),matiere1 ,filiere1,formateur1);
		Module module2 = new Module(null,9367,LocalDate.parse("2026-03-23"),LocalDate.parse("2026-03-25"),matiere2 ,filiere1,formateur1);
		Module module3 = new Module(null,3422,LocalDate.parse("2026-04-20"),LocalDate.parse("2026-04-24"),matiere3 ,filiere1,formateur2);
		
		Module module4 = new Module(null,6618,LocalDate.parse("2026-04-16"),LocalDate.parse("2026-04-20"),matiere1 ,filiere2,formateur1);
		Module module5 = new Module(null,6511,LocalDate.parse("2026-06-04"),LocalDate.parse("2026-06-08"),matiere2 ,filiere2,formateur1);
		Module module6 = new Module(null,2377,LocalDate.parse("2026-06-26"),LocalDate.parse("2026-07-02"),matiere3 ,filiere2,null);
		
		
		
		System.out.println("Affichage du jeu d'essai :");
		
		System.out.println("\n---Liste des salles---");
		System.out.println(salle1);
		
		System.out.println("\n---Liste des filieres---");
		System.out.println(filiere1);
		System.out.println(filiere2);
		
		
		System.out.println("\n---Liste des Personnes---");
		System.out.println(stagiaire1);
		System.out.println(stagiaire2);
		System.out.println(formateur1);
		System.out.println(formateur2);
		
		System.out.println("\n---Liste des ordinateurs---");
		System.out.println(ordinateur1);
		System.out.println(ordinateur2);
		
		System.out.println("\n---Liste des matieres---");
		System.out.println(matiere1);
		System.out.println(matiere2);
		System.out.println(matiere3);
		
		System.out.println("\n---Liste des modules---");
		System.out.println(module1);
		System.out.println(module2);
		System.out.println(module3);
		System.out.println(module4);
		System.out.println(module5);
		System.out.println(module6);
		
	}

}
