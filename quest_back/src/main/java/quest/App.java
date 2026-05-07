package quest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import quest.dao.DAOFiliere;
import quest.dao.DAOModule;
import quest.dao.DAOOrdinateur;
import quest.dao.DAOSalle;
import quest.model.Filiere;
import quest.model.Formateur;
import quest.model.Genre;
import quest.model.Matiere;
import quest.model.Module;
import quest.model.Ordinateur;
import quest.model.Personne;
import quest.model.Salle;
import quest.model.Stagiaire;
import quest.service.MatiereService;
import quest.service.PersonneService;
public class App {
	private static Logger log = LoggerFactory.getLogger(App.class);

	static MatiereService matiereSrv = new MatiereService();
	static PersonneService personneSrv = new PersonneService();

	static DAOOrdinateur daoOrdinateur = new DAOOrdinateur();
	static DAOFiliere daoFiliere = new DAOFiliere();
	static DAOSalle daoSalle = new DAOSalle();
	static DAOModule daoModule = new DAOModule();
	static Random r = new Random();

	static Personne connected;


	///------------PARTIE APP--------------//
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



	public static void menuAdmin()
	{
		System.out.println("\n----Menu Admin-------");
		System.out.println("1 - Gestion des matieres");
		System.out.println("2 - Gestion des salles");
		System.out.println("3 - Gestion des filieres");
		System.out.println("4 - Gestion des ordinateurs");
		System.out.println("5 - Gestion des stagiaires");
		System.out.println("6 - Gestion des formateurs");
		System.out.println("7 - Se deconnecter");

		int choix = saisieInt("Choisir un menu");
		switch(choix)
		{
		case 1 : gestionMatieres(); break;
		case 2 : gestionSalles();break;
		case 3 : gestionFilieres();break;
		case 4 : gestionOrdinateurs();break;
		case 5 : gestionStagiaires();break;
		case 6 : gestionFormateurs();break;
		case 7 : menuPrincipal();break;
		}

		menuAdmin();
	}


	public static void gestionMatieres() {
		System.out.println("\n----Gestion des matieres------");
		System.out.println("1 - Lister les matieres");
		System.out.println("2 - Ajouter une nouvelle matiere");
		System.out.println("3 - Modifier une matiere");
		System.out.println("4 - Supprimer une matiere");
		System.out.println("5 - Retour menu Admin");

		int choix = saisieInt("Choisir un menu");
		switch(choix)
		{
		case 1 : afficherMatiere();break;
		case 2 : ajouterMatiere();break;
		case 3 : modifierMatiere();break;
		case 4 : supprimerMatiere();break;
		case 5 : menuAdmin();break;
		}
		gestionMatieres();
	}

	public static void supprimerMatiere() {
		afficherMatiere();
		int id = saisieInt("Saisir l'id de la matiere à supprimer");
		matiereSrv.delete(id);
	}

	public static void modifierMatiere() {
		afficherMatiere();
		int id = saisieInt("Saisir l'id de la matiere à modifier");

		System.out.println("Modif d'une matiere : ");
		String libelle = saisieString("Saisir le libelle de la matiere : ");

		Matiere matiere = new Matiere(id,libelle);

		matiereSrv.update(matiere);
	}

	public static void ajouterMatiere() {
		System.out.println("Creation d'une matiere : ");
		String libelle = saisieString("Saisir le libelle de la matiere : ");

		Matiere matiere = new Matiere(null,libelle);
		matiereSrv.insert(matiere);


		System.out.println("L'ajout de la matiere a bien ete effectue : "+matiere);
		System.out.println("Elle a l'id "+matiere.getId());

	}

	public static void afficherMatiere() {

		List<Matiere> matieres = matiereSrv.getAll();

		if(matieres.isEmpty()) {System.out.println("Aucune matiere dans la bdd...");}
		else
		{
			for(Matiere m : matieres ) {System.out.println(m);}
		}

	}


	public static void gestionSalles() {
		System.out.println("\n----Gestion des salles------");
		System.out.println("1 - Lister les salles");
		System.out.println("2 - Ajouter une nouvelle salle");
		System.out.println("3 - Modifier une salle");
		System.out.println("4 - Supprimer une salle");
		System.out.println("5 - Retour menu Admin");

		int choix = saisieInt("Choisir un menu");
		switch(choix)
		{
		case 1 : afficherSalle();break;
		case 2 : ajouterSalle();break;
		case 3 : modifierSalle();break;
		case 4 : supprimerSalle();break;
		case 5 : menuAdmin();break;
		}
		gestionSalles();
	}

	public static void supprimerSalle() {
		afficherSalle();
		int id = saisieInt("Saisir l'id de la salle à supprimer");
		daoSalle.delete(id);
	}

	public static void modifierSalle() {
		afficherSalle();
		int id = saisieInt("Saisir l'id de la salle à modifier");

		System.out.println("Modif d'une salle : ");
		String nom = saisieString("Saisir le nom de la salle : ");
		System.out.println("Saisie de l'adresse : ");
		String numero = saisieString("Saisir le numero");
		String voie = saisieString("Saisir la voie");
		String ville = saisieString("Saisir la ville");
		String cp = saisieString("Saisir le cp");
		Salle salle = new Salle(id,nom,numero,voie,ville,cp);

		daoSalle.update(salle);
	}

	public static void ajouterSalle() {
		System.out.println("Creation d'une salle : ");
		String nom = saisieString("Saisir le nom de la salle : ");
		System.out.println("Saisie de l'adresse : ");
		String numero = saisieString("Saisir le numero");
		String voie = saisieString("Saisir la voie");
		String ville = saisieString("Saisir la ville");
		String cp = saisieString("Saisir le cp");

		Salle salle = new Salle(null,nom,numero,voie,ville,cp);
		daoSalle.insert(salle);
	}

	public static void afficherSalle() {

		List<Salle> salles = daoSalle.findAll();

		if(salles.isEmpty()) {System.out.println("Aucune salle dans la bdd...");}
		else
		{
			for(Salle s : salles ) {System.out.println(s);}
		}

	}



	public static void gestionFilieres() {
		System.out.println("\n----Gestion des filieres------");
		System.out.println("1 - Lister les filieres");
		System.out.println("2 - Ajouter une nouvelle filiere");
		System.out.println("3 - Modifier une filiere");
		System.out.println("4 - Supprimer une filiere");
		System.out.println("5 - Gestion des modules");
		System.out.println("6 - Retour menu Admin");

		int choix = saisieInt("Choisir un menu");
		switch(choix)
		{
		case 1 : afficherFiliere();break;
		case 2 : ajouterFiliere();break;
		case 3 : modifierFiliere();break;
		case 4 : supprimerFiliere();break;
		case 5 : afficherFiliere();gestionModule(saisieInt("Choisir la filiere"));
		case 6 : menuAdmin();break;
		}
		gestionFilieres();
	}

	public static void supprimerFiliere() {
		afficherFiliere();
		int id = saisieInt("Saisir l'id de la filiere à supprimer");
		daoFiliere.delete(id);
	}

	public static void modifierFiliere() {
		afficherFiliere();
		int id = saisieInt("Saisir l'id de la filiere à modifier");

		System.out.println("Modif d'une filiere : ");

		String libelle = saisieString("Saisir le libelle de la filiere : ");
		String debut = saisieString("Saisir la date de debut de la filiere (yyyy-mm-dd) :  ");
		String fin = saisieString("Saisir la date de fin de la filiere (yyyy-mm-dd) :  ");
		String choix = saisieString("Filiere en presentiel (dans une salle) ? y/n");
		Salle salle = null;
		if(choix.equals("y"))
		{
			afficherSalle();
			int idSalle = saisieInt("Choisir la salle");
			salle = daoSalle.findById(idSalle);
		}

		Filiere filiere = new Filiere(id,libelle,LocalDate.parse(debut),LocalDate.parse(fin),salle);
		daoFiliere.update(filiere);

	}

	public static void ajouterFiliere() {
		System.out.println("Creation d'une filiere : ");
		String libelle = saisieString("Saisir le libelle de la filiere : ");
		String debut = saisieString("Saisir la date de debut de la filiere (yyyy-mm-dd) :  ");
		String fin = saisieString("Saisir la date de fin de la filiere (yyyy-mm-dd) :  ");
		String choix = saisieString("Filiere en presentiel (dans une salle) ? y/n");
		Salle salle = null;
		if(choix.equals("y"))
		{
			afficherSalle();
			int idSalle = saisieInt("Choisir la salle");
			salle = daoSalle.findById(idSalle);
		}

		Filiere filiere = new Filiere(null,libelle,LocalDate.parse(debut),LocalDate.parse(fin),salle);
		daoFiliere.insert(filiere);
	}

	public static void afficherFiliere() {
		List<Filiere> filieres = daoFiliere.findAll();

		if(filieres.isEmpty()) {System.out.println("Aucune filiere dans la bdd...");}
		else
		{
			for(Filiere f : filieres ) {System.out.println(f);}
		}
	}

	public static void gestionOrdinateurs() {
		System.out.println("\n----Gestion des ordinateurs------");
		System.out.println("1 - Lister les ordinateurs");
		System.out.println("2 - Ajouter un nouvel ordinateur");
		System.out.println("3 - Modifier un ordinateur");
		System.out.println("4 - Supprimer un ordinateur");
		System.out.println("5 - Retour menu Admin");

		int choix = saisieInt("Choisir un menu");
		switch(choix)
		{
		case 1 : afficherOrdinateur();break;
		case 2 : ajouterOrdinateur();break;
		case 3 : modifierOrdinateur();break;
		case 4 : supprimerOrdinateur();break;
		case 5 : menuAdmin();break;
		}
		gestionOrdinateurs();
	}


	public static void supprimerOrdinateur() {
		afficherOrdinateur();
		int id = saisieInt("Saisir l'id de l'ordinateur à supprimer");
		daoOrdinateur.delete(id);
	}

	public static void modifierOrdinateur() {
		afficherOrdinateur();
		int id = saisieInt("Saisir l'id de l'ordinateur à modifier");

		System.out.println("Modif d'un ordinateur : ");

		String marque = saisieString("Saisir la marque de l'ordinateur : ");
		int ram = saisieInt("Saisir la ram");

		String choix = saisieString("Affecter un utilisateur ? y/n");
		Stagiaire utilisateur = null;
		if(choix.equals("y"))
		{
			afficherStagiaire();
			int idUtilisateur = saisieInt("Choisir l'utlisateur");
			utilisateur = personneSrv.getStagiaireById(idUtilisateur);
		}

		Ordinateur ordinateur = new Ordinateur(id,marque,ram,utilisateur);
		daoOrdinateur.update(ordinateur);
	}

	public static void ajouterOrdinateur() {
		System.out.println("Creation d'un ordinateur : ");
		String marque = saisieString("Saisir la marque de l'ordinateur : ");
		int ram = saisieInt("Saisir la ram");

		String choix = saisieString("Affecter un utilisateur ? y/n");
		Stagiaire utilisateur = null;
		if(choix.equals("y"))
		{
			afficherStagiaire();
			int idUtilisateur = saisieInt("Choisir l'utlisateur");
			utilisateur =  personneSrv.getStagiaireById(idUtilisateur);
		}

		Ordinateur ordinateur = new Ordinateur(null,marque,ram,utilisateur);
		daoOrdinateur.insert(ordinateur);
	}

	public static void afficherOrdinateur() {

		List<Ordinateur> ordinateurs = daoOrdinateur.findAll();

		if(ordinateurs.isEmpty()) {System.out.println("Aucun ordinateur dans la bdd...");}
		else
		{
			for(Ordinateur o : ordinateurs ) {System.out.println(o);}
		}

	}

	public static void gestionStagiaires() {
		System.out.println("\n----Gestion des stagiaires------");
		System.out.println("1 - Lister les stagiaires");
		System.out.println("2 - Ajouter un nouveau stagiaire");
		System.out.println("3 - Modifier un stagiaire");
		System.out.println("4 - Supprimer un stagiaire");
		System.out.println("5 - Retour menu Admin");

		int choix = saisieInt("Choisir un menu");
		switch(choix)
		{
		case 1 : afficherStagiaire();break;
		case 2 : ajouterStagiaire();break;
		case 3 : modifierStagiaire();break;
		case 4 : supprimerStagiaire();break;
		case 5 : menuAdmin();break;
		}
		gestionStagiaires();
	}


	public static void supprimerStagiaire() {
		afficherStagiaire();
		int id = saisieInt("Saisir l'id du stagiaire à supprimer");
		personneSrv.delete(id);
	}

	public static void modifierStagiaire() {
		afficherStagiaire();
		int id = saisieInt("Saisir l'id du stagiaire à modifier");

		System.out.println("Modif d'un stagiaire : ");

		String login = saisieString("Saisir le login");
		String password = saisieString("Saisir le password");
		String nom = saisieString("Saisir le nom");
		String prenom = saisieString("Saisir le prenom");
		String civilite = saisieString("Saisir la civilite : "+Arrays.toString(Genre.values()));

		String email = saisieString("Saisir l'email");
		String numero = saisieString("Saisir le numero");
		String voie = saisieString("Saisir la voie");
		String ville = saisieString("Saisir la ville");
		String cp = saisieString("Saisir le cp");

		afficherFiliere();
		int idFiliere = saisieInt("Choisir une filiere");
		Filiere filiere = daoFiliere.findById(idFiliere);

		Stagiaire stagiaire = new Stagiaire(id,login,password,nom,prenom,Genre.valueOf(civilite),email,numero,voie,ville,cp,filiere);
		personneSrv.update(stagiaire);
	}

	public static void ajouterStagiaire() {
		System.out.println("Creation d'un stagiaire : ");
		String login = saisieString("Saisir le login");
		String password = saisieString("Saisir le password");
		String nom = saisieString("Saisir le nom");
		String prenom = saisieString("Saisir le prenom");
		String civilite = saisieString("Saisir la civilite : "+Arrays.toString(Genre.values()));

		String email = saisieString("Saisir l'email");
		String numero = saisieString("Saisir le numero");
		String voie = saisieString("Saisir la voie");
		String ville = saisieString("Saisir la ville");
		String cp = saisieString("Saisir le cp");

		afficherFiliere();
		int idFiliere = saisieInt("Choisir une filiere");
		Filiere filiere = daoFiliere.findById(idFiliere);

		Stagiaire stagiaire = new Stagiaire(null,login,password,nom,prenom,Genre.valueOf(civilite),email,numero,voie,ville,cp,filiere);

		personneSrv.insert(stagiaire);
	}

	public static void afficherStagiaire() {
		List<Stagiaire> stagiaires = personneSrv.getAllStagiaire();

		if(stagiaires.isEmpty()) {System.out.println("Aucun stagiaire dans la bdd...");}
		else
		{
			for(Stagiaire s : stagiaires ) {System.out.println(s);}
		}

	}


	public static void gestionFormateurs() {
		System.out.println("\n----Gestion des formateurs------");
		System.out.println("1 - Lister les formateurs");
		System.out.println("2 - Ajouter un nouveau formateur");
		System.out.println("3 - Modifier un formateur");
		System.out.println("4 - Supprimer un formateur");
		System.out.println("5 - Retour menu Admin");

		int choix = saisieInt("Choisir un menu");
		switch(choix)
		{
		case 1 : afficherFormateur();break;
		case 2 : ajouterFormateur();break;
		case 3 : modifierFormateur();break;
		case 4 : supprimerFormateur();break;
		case 5 : menuAdmin();break;
		}
		gestionFormateurs();
	}


	public static void supprimerFormateur() {
		afficherFormateur();
		int id = saisieInt("Saisir l'id de l'formateur à supprimer");
		personneSrv.delete(id);
	}

	public static void modifierFormateur() {
		afficherFormateur();
		int id = saisieInt("Saisir l'id du formateur à modifier");

		System.out.println("Modif d'un formateur : ");

		String login = saisieString("Saisir le login");
		String password = saisieString("Saisir le password");
		String nom = saisieString("Saisir le nom");
		String prenom = saisieString("Saisir le prenom");
		String civilite = saisieString("Saisir la civilite : "+Arrays.toString(Genre.values()));

		boolean admin = saisieBoolean("Le formateur est admin ? true/false");

		Formateur formateur = new Formateur(id,login,password,nom,prenom,Genre.valueOf(civilite),admin);
		personneSrv.update(formateur);
	}

	public static void ajouterFormateur() {
		System.out.println("Creation d'un formateur : ");
		String login = saisieString("Saisir le login");
		String password = saisieString("Saisir le password");
		String nom = saisieString("Saisir le nom");
		String prenom = saisieString("Saisir le prenom");
		String civilite = saisieString("Saisir la civilite : "+Arrays.toString(Genre.values()));

		boolean admin = saisieBoolean("Le formateur est admin ? true/false");

		Formateur formateur = new Formateur(null,login,password,nom,prenom,Genre.valueOf(civilite),admin);
		personneSrv.insert(formateur);
	}

	public static void afficherFormateur() {

		List<Formateur> formateurs = personneSrv.getAllFormateur();

		if(formateurs.isEmpty()) {System.out.println("Aucun formateur dans la bdd...");}
		else
		{
			for(Formateur f : formateurs ) {System.out.println(f);}
		}

	}


	public static void gestionModule(int idFiliere) {
		Filiere filiere = daoFiliere.findById(idFiliere);
		System.out.println("\n----Gestion des modules de la filiere "+filiere.getLibelle()+"("+filiere.getId()+") -----");
		System.out.println("1 - Afficher les modules");
		System.out.println("2 - Ajouter un module");
		System.out.println("3 - Supprimer module");
		System.out.println("4 - Retour Gestion des filieres");

		int choix = saisieInt("Choisir un menu");
		switch(choix)
		{
		case 1 : afficherModulesFiliere(idFiliere);break;
		case 2 : ajouterModule(idFiliere);break;
		case 3 : supprimerModule(idFiliere);break;
		case 4 : gestionFilieres();break;
		}

		gestionModule(idFiliere);
	}

	public static void supprimerModule(int idFiliere) {
		afficherModulesFiliere(idFiliere);
		int id = saisieInt("Saisir l'id du module");
		daoModule.delete(id);

	}

	public static void ajouterModule(int idFiliere) {
		Filiere filiere = daoFiliere.findById(idFiliere);
		System.out.println("Ajout d'un module dans la filiere "+filiere.getLibelle());
		afficherMatiere();
		int idMatiere = saisieInt("Choisir une matiere");
		Matiere matiere = matiereSrv.getById(idMatiere);

		String debut = saisieString("Saisir la date début");
		String fin = saisieString("Saisir la date fin");

		int quest = r.nextInt(1000,10000);

		Formateur formateur=null;

		String choix = saisieString("Affecter un formateur ? y/n");
		if(choix.equals("y"))
		{
			afficherFormateur();
			int idFormateur = saisieInt("Saisir l'id du formateur");
			formateur = personneSrv.getFormateurById(idFormateur);
		}

		Module module = new Module(null,quest,LocalDate.parse(debut),LocalDate.parse(fin),matiere,filiere,formateur);
		daoModule.insert(module);
	}

	public static void afficherModulesFiliere(int idFiliere) {
		List<Module> modules = daoModule.findAllByFiliereId(idFiliere);

		if(modules.isEmpty()) {System.out.println("Aucun module dans cette filiere...");}
		else
		{
			for(Module m : modules ) {System.out.println(m);}
		}

	}

	public static void seConnecter() {
		log.info("Connexion demandée en cours ...");

		String login = saisieString("Saisir votre login");
		String password = saisieString("Saisir votre password");

		log.info("Login et mdp saisi !");

		connected = personneSrv.getByLoginAndPassword(login, password);

		if(connected instanceof Stagiaire)
		{
			menuStagiaire();
		}
		else if(connected instanceof Formateur)
		{
			if(((Formateur) connected).isAdmin())
			{
				menuAdmin();
			}
			else
			{
				menuFormateur();
			}
		}
		else
		{
			System.out.println("Les identifiants sont invalides...");
		}
	}


	public static void menuStagiaire() {
		System.out.println("\n----MENU STAGIAIRE--------");
		System.out.println("Welcome "+connected.getLogin());
		System.out.println("SITE EN COURS DE CONSTRUCTION....");
		System.out.println("1 - Se deconnecter");
		int choix = saisieInt("Choisir un menu");
		switch(choix)
		{
			case 1 : menuPrincipal();break;
		}

		menuStagiaire();
	}

	public static void menuFormateur() {
		System.out.println("\n----MENU FORMATEUR--------");
		System.out.println("SITE EN COURS DE CONSTRUCTION....");
		System.out.println("1 - Se deconnecter");
		int choix = saisieInt("Choisir un menu");
		switch(choix)
		{
			case 1 : menuPrincipal();break;
		}
		menuFormateur();
	}

	public static void menuPrincipal()
	{
		System.out.println("----APP PROJET QUEST-------");
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

	public static void main(String[] args) {
		// Activer la configuration du niveau des Loggers
		Configurator.setRootLevel(Level.DEBUG);

		menuPrincipal();
	}

}
