package quest.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import quest.context.Singleton;
import quest.model.Filiere;
import quest.model.Genre;
import quest.model.Stagiaire;


@WebServlet("/stagiaire")
public class StagiaireController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id")==null) 
		{
			chercherTous(request,response);
		} 
		else 
		{
			if(request.getParameter("delete")==null) 
			{
				chercherParId(request, response);
			}
			else 
			{
				supprimer(request, response);
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id")=="") 
		{
			ajouter(request,response);
		}
		else 
		{
			modifier(request,response);
		}
	}
	
	public void chercherTous(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		List<Stagiaire> stagiaires = Singleton.getInstance().getPersonneSrv().getAllStagiaire();
		List<Filiere> filieres = Singleton.getInstance().getDaoFiliere().findAll();
		request.setAttribute("stagiaire", new Stagiaire());
		request.setAttribute("stagiaires", stagiaires);
		request.setAttribute("civilites", Genre.values());
		request.setAttribute("filieres", filieres);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/stagiaires.jsp").forward(request, response);
		
	}
	public void chercherParId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		List<Stagiaire> stagiaires = Singleton.getInstance().getPersonneSrv().getAllStagiaire();
		List<Filiere> filieres = Singleton.getInstance().getDaoFiliere().findAll();
		Integer id =  Integer.parseInt(request.getParameter("id"));
		Stagiaire stagiaire = Singleton.getInstance().getPersonneSrv().getStagiaireById(id);
		
		request.setAttribute("stagiaire", stagiaire);
		request.setAttribute("stagiaires", stagiaires);
		request.setAttribute("civilites", Genre.values());
		request.setAttribute("filieres", filieres);
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/stagiaires.jsp").forward(request, response);
		
	}
	public void supprimer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Integer id =  Integer.parseInt(request.getParameter("id"));
		Singleton.getInstance().getPersonneSrv().delete(id);
		response.sendRedirect("stagiaire");
		
	}
	public void ajouter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		Genre civ = Genre.valueOf(request.getParameter("civilite"));
		String email = request.getParameter("email");
		String numero = request.getParameter("adresse.numero");
		String voie = request.getParameter("adresse.voie");
		String cp = request.getParameter("adresse.cp");
		String ville = request.getParameter("adresse.ville");
		Filiere filiere = new Filiere();
		filiere.setId(Integer.parseInt(request.getParameter("filiere.id")));
		
		Stagiaire stagiaire = new Stagiaire(null, login, password, nom, prenom, civ,email, numero,voie,ville,cp,filiere);
		Singleton.getInstance().getPersonneSrv().insert(stagiaire);
		
		response.sendRedirect("stagiaire");
	}
	public void modifier(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Integer id =  Integer.parseInt(request.getParameter("id"));
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		Genre civ = Genre.valueOf(request.getParameter("civilite"));
		String email = request.getParameter("email");
		String numero = request.getParameter("adresse.numero");
		String voie = request.getParameter("adresse.voie");
		String cp = request.getParameter("adresse.cp");
		String ville = request.getParameter("adresse.ville");
		Filiere filiere = new Filiere();
		filiere.setId(Integer.parseInt(request.getParameter("filiere.id")));
		
		Stagiaire stagiaire = new Stagiaire(id, login, password, nom, prenom, civ,email, numero,voie,ville,cp,filiere);
		Singleton.getInstance().getPersonneSrv().update(stagiaire);
		
		response.sendRedirect("stagiaire");
	}

}
