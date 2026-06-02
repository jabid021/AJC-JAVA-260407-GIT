package quest.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import quest.context.Singleton;
import quest.model.Filiere;
import quest.model.Salle;


@WebServlet("/filiere")
public class FiliereController extends HttpServlet {

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
		List<Filiere> filieres = Singleton.getInstance().getDaoFiliere().findAll();
		List<Salle> salles = Singleton.getInstance().getDaoSalle().findAll();
		request.setAttribute("filiere", new Filiere());
		request.setAttribute("filieres", filieres);
		request.setAttribute("salles", salles);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/filieres.jsp").forward(request, response);
		
	}
	public void chercherParId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		Integer id =  Integer.parseInt(request.getParameter("id"));
		Filiere filiere = Singleton.getInstance().getDaoFiliere().findById(id);

		List<Filiere> filieres = Singleton.getInstance().getDaoFiliere().findAll();
		List<Salle> salles = Singleton.getInstance().getDaoSalle().findAll();
		
		request.setAttribute("filiere", filiere);
		request.setAttribute("filieres", filieres);
		request.setAttribute("salles", salles);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/filieres.jsp").forward(request, response);
		
	}
	public void supprimer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Integer id =  Integer.parseInt(request.getParameter("id"));
		Singleton.getInstance().getDaoFiliere().deleteById(id);
		response.sendRedirect("filiere");
		
	}
	public void ajouter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String libelle = request.getParameter("libelle");
		LocalDate debut = LocalDate.parse(request.getParameter("debut"));
		LocalDate fin = LocalDate.parse(request.getParameter("fin"));
		Salle salle = null;
		if(!request.getParameter("salle.id").equals("")) 
		{
			salle = new Salle();
			salle.setId(Integer.parseInt(request.getParameter("salle.id")));
		}
	
		Filiere filiere = new Filiere(null, libelle,debut,fin,salle);
		Singleton.getInstance().getDaoFiliere().save(filiere);
		
		response.sendRedirect("filiere");
	}
	
	public void modifier(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Integer id =  Integer.parseInt(request.getParameter("id"));
		String libelle = request.getParameter("libelle");
		LocalDate debut = LocalDate.parse(request.getParameter("debut"));
		LocalDate fin = LocalDate.parse(request.getParameter("fin"));
		Salle salle = null;
		if(!request.getParameter("salle.id").equals("")) 
		{
			salle = new Salle();
			salle.setId(Integer.parseInt(request.getParameter("salle.id")));
		}
	
		Filiere filiere = new Filiere(id, libelle,debut,fin,salle);

		Singleton.getInstance().getDaoFiliere().save(filiere);
		
		response.sendRedirect("filiere");
		
	}

}
