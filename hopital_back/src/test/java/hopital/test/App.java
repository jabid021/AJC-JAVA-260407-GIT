package hopital.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import hopital.context.Singleton;
import hopital.model.Compte;
import hopital.model.Medecin;
import hopital.model.Patient;
import hopital.model.Secretaire;
import hopital.model.Visite;
import hopital.service.CompteService;
import hopital.service.PatientService;
import hopital.service.VisiteService;

public class App {

	public static PatientService patientSrv = Singleton.getInstance().getPatientSrv();
	public static CompteService compteSrv = Singleton.getInstance().getCompteSrv();
	public static VisiteService visiteSrv = Singleton.getInstance().getVisiteSrv();
	
	static File fichier = new File("fileAttente.txt");
	static LinkedList<Patient> fileAttente = new LinkedList();
	static Compte connected = null;
	static boolean enPause = false;

	public static int saisieInt(String message) 
	{
		Scanner monScanner = new Scanner(System.in); 
		System.out.println(message);
		return monScanner.nextInt();
	}

	public static double saisieDouble(String message) 
	{
		Scanner monScanner = new Scanner(System.in); 
		System.out.println(message);
		return monScanner.nextDouble();
	}

	public static String saisieString(String message) 
	{
		Scanner monScanner = new Scanner(System.in); 
		System.out.println(message);
		return monScanner.nextLine();
	}

	public static boolean saisieBoolean(String message) 
	{
		Scanner monScanner = new Scanner(System.in); 
		System.out.println(message);
		return monScanner.nextBoolean();
	}

	public static void main(String[] args) {

		menuPrincipal();
	}

	public static void menuPrincipal() 
	{
		System.out.println("\n----Appli Hopital------");
		System.out.println("1 - Se connecter");
		System.out.println("2 - Stop");
		int choix = saisieInt("Choisir un menu");

		switch(choix) 
		{
		case 1 : seConnecter();break;
		case 2 : System.exit(0);break;
		}

		menuPrincipal();
	}





	public static void seConnecter() {
		String login = saisieString("Saisir votre login");
		String password = saisieString("Saisir votre password");

		connected = compteSrv.getByLoginAndPassword(login, password);


		if(connected instanceof Medecin) 
		{
			int salle = saisieInt("Choisir votre salle");
			((Medecin) connected).setSalle(salle);
			menuMedecin();
		}
		else if(connected instanceof Secretaire) 
		{
			if(enPause) 
			{
				menuSecretairePause();
			}
			else 
			{
				menuSecretaire();
			}
		} 
		else
		{
			System.out.println("Identifiants invalides");
		}
	}

	public static void menuSecretaire() {
		System.out.println("\n----Menu Secretaire------");
		System.out.println("1 - Recevoir un patient");
		System.out.println("2 - Afficher les anciennes visites");
		System.out.println("3 - Afficher l'etat de la file d'attente");
		System.out.println("4 - Supprimer un patient");
		System.out.println("5 - Partir en pause");
		System.out.println("6 - Se deconnecter");
		int choix = saisieInt("Choisir un menu");

		switch(choix) 
		{
		case 1 : accueilPatient();break;
		case 2 : afficherVisites();break;
		case 3 : afficherFileAttente();break;
		case 4 : supprimerPatient();break;
		case 5 : partirPause();break;
		case 6 : connected=null;menuPrincipal();break;
		}

		menuSecretaire();

	}

	public static void partirPause() {
		try {
			FileOutputStream fos = new FileOutputStream(fichier);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(fileAttente);
			fileAttente.clear();
			enPause=true;
			oos.close();
			fos.close();
		}
		catch(Exception e) {e.printStackTrace();}

		menuSecretairePause();
	}

	public static void supprimerPatient() {
		int idPatient = saisieInt("Saisir l'id du patient à supprimer");
		Patient patient = patientSrv.getById(idPatient);
		if(patient==null) {System.out.println("Ce patient n'existe pas....");}
		else 
		{
			patientSrv.deleteById(idPatient);
			System.out.println("Suppression du patient...");
			System.out.println("DONE");
		}

	}

	public static void afficherFileAttente() {
		if(fileAttente.isEmpty()) {System.out.println("La file d'attente est vide...");}
		else 
		{
			System.out.println("Etat de la file d'attente :");
			for(Patient p : fileAttente) 
			{
				System.out.println(p);
			}
			if(connected instanceof Medecin) {System.out.println("Le prochain patient est : "+fileAttente.peekFirst());}
		}
	}

	public static void afficherVisites() {
		int idPatient = saisieInt("Saisir l'id du patient pour afficher son historique");
		Patient patient = patientSrv.getById(idPatient);
		if(patient==null) {System.out.println("Ce patient n'existe pas....");}
		else 
		{
			List<Visite> visites = visiteSrv.getByPatientId(idPatient);
			if(visites.isEmpty()) {System.out.println("Ce patient n'a pas encore de visite...");}
			else 
			{
				System.out.println("Historique des visites du patient "+patient);
				for(Visite v : visites) {System.out.println(v);}
			}

		}

	}

	public static void accueilPatient() {
		int idPatient = saisieInt("Saisir l'id du patient");
		Patient patient = patientSrv.getById(idPatient);
		if(patient==null) 
		{
			System.out.println("Ce patient n'existe pas encore... Creation d'un nouveau patient");
			String nom = saisieString("Saisir le nom");
			String prenom = saisieString("Saisir le prenom");
			patient = new Patient(idPatient,nom,prenom);
			patientSrv.insert(patient);
		}
		else 
		{
			System.out.println("Patient déjà connu : "+patient);
		}
		
		if(fileAttente.contains(patient)) 
		{
			System.out.println("Ce patient est deja dans la file...");
		}
		else 
		{
			fileAttente.add(patient);
		}
	}

	public static void menuSecretairePause() {
		System.out.println("\n----Menu Secretaire PAUSE------");
		System.out.println("1 - Revenir de pause");
		System.out.println("2 - Se deconnecter");
		int choix = saisieInt("Choisir un menu");

		switch(choix) 
		{
		case 1 : revenirPause();break;
		case 2 :connected=null;menuPrincipal();break;
		}

		menuSecretairePause();

	}

	public static void revenirPause() {
		
		try {
			FileInputStream fis = new FileInputStream(fichier);
			ObjectInputStream ois = new ObjectInputStream(fis);

			fileAttente=(LinkedList<Patient>) ois.readObject();
			enPause=false;
			ois.close();
			fis.close();
		}
		catch(Exception e) {e.printStackTrace();}

		menuSecretaire();
	}

	public static void menuMedecin() {
		System.out.println("\n----Menu Medecin------");
		System.out.println("1 - Recevoir un patient");
		System.out.println("2 - Afficher l'etat de la file d'attente");
		System.out.println("3 - Save Visite");
		System.out.println("4 - Consulter CA");
		System.out.println("5 - Se deconnecter");
		int choix = saisieInt("Choisir un menu");

		switch(choix) 
		{
		case 1 : recevoirPatient();break;
		case 2 : afficherFileAttente();break;
		case 3 : sauvegarderVisites();break;
		case 4 : afficherCA();break;
		case 5 : connected=null;menuPrincipal();break;
		}

		menuMedecin();

	}

	public static void afficherCA() {
		String debut = saisieString("Saisir le debut de la periode");
		String fin = saisieString("Saisir la fin de la periode");
		
		/*List<Visite> visitesPeriode = visiteSrv.getByMedecinIdAndPeriode(connected.getId(), LocalDate.parse(debut), LocalDate.parse(fin));
		double ca = 0;
		for(Visite v : visitesPeriode) 
		{
			ca += v.getPrix();
		}*/
		
		double ca = visiteSrv.getByMedecinIdAndPeriode(connected.getId(), LocalDate.parse(debut), LocalDate.parse(fin))
				.stream()
				.mapToDouble(v->v.getPrix())
				.sum();
		
		System.out.println("VOTRE CA sur la periode "+debut+" - "+fin+" est de : "+ca+"€");
	}

	public static void sauvegarderVisites() {
		Medecin medecin = (Medecin) connected;
		if(medecin.getConsultations().isEmpty()) 
		{
			System.out.println("Aucune visite à save...");
		}
		else 
		{
			System.out.println("Sauvegarde de vos visites en BDD :");
			for(Visite v : medecin.getConsultations()) 
			{
				v=visiteSrv.insert(v);
				System.out.println(v);
			}
			medecin.getConsultations().clear();
		}

	}

	public static void recevoirPatient() {
		if(fileAttente.isEmpty()) {System.out.println("La file d'attente est vide...");}
		else 
		{
			Medecin medecin = (Medecin) connected;
			Patient prochainPatient = fileAttente.pollFirst();
			Visite visite = new Visite(prochainPatient,medecin);
			System.out.println("Creation d'une visite pour le patient : "+prochainPatient);
			medecin.getConsultations().add(visite);
			if(medecin.getConsultations().size()==3) 
			{
				System.out.println("Votre liste de visite vient d'atteindre 3 -> SAVE AUTO");
				sauvegarderVisites();
			}
		}
	}


}
