package quest.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import quest.context.Singleton;
import quest.model.Salle;


@WebServlet("/salle")
public class SalleController extends HttpServlet {

	//doGet (url) => findAll/findById / delete
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Si on ne recoit pas d'id => findAll sinon => findById ou delete
		if(request.getParameter("id")==null) 
		{
			chercherTous(request,response);
		} 
		else 
		{
			//Si on ne recoit pas de parametre "delete" => findById sinon => delete
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

	
	//doPost (url / formulaire) => insert / update 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Si on ne recoit pas d'id => Insert sinon => Update
		if(request.getParameter("id")=="") 
		{
			ajouter(request,response);
		}
		else 
		{
			modifier(request,response);
		}
	}

	
	
	
	////D'un controller à l'autre, on ne modifie que le bloc suivant
	
	
	
	
	
	public void chercherTous(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		List<Salle> salles = Singleton.getInstance().getDaoSalle().findAll();
		request.setAttribute("salle", new Salle());
		request.setAttribute("salles", salles);
		this.getServletContext().getRequestDispatcher("/WEB-INF/salles.jsp").forward(request, response);
		
	}
	public void chercherParId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		List<Salle> salles = Singleton.getInstance().getDaoSalle().findAll();
		
		
		Integer id =  Integer.parseInt(request.getParameter("id"));
		Salle salle = Singleton.getInstance().getDaoSalle().findById(id);

		request.setAttribute("salle", salle);
		request.setAttribute("salles", salles);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/salles.jsp").forward(request, response);
		
	}
	public void supprimer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Integer id =  Integer.parseInt(request.getParameter("id"));
		Singleton.getInstance().getDaoSalle().deleteById(id);
		response.sendRedirect("salle");
		
	}
	public void ajouter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String nom = request.getParameter("nom");
		String numero = request.getParameter("adresse.numero");
		String voie = request.getParameter("adresse.voie");
		String cp = request.getParameter("adresse.cp");
		String ville = request.getParameter("adresse.ville");
		
		Salle salle = new Salle(null, nom, numero, voie, ville, cp);
		Singleton.getInstance().getDaoSalle().save(salle);
		
		response.sendRedirect("salle");
	}
	public void modifier(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Integer id =  Integer.parseInt(request.getParameter("id"));
		String nom = request.getParameter("nom");
		String numero = request.getParameter("adresse.numero");
		String voie = request.getParameter("adresse.voie");
		String cp = request.getParameter("adresse.cp");
		String ville = request.getParameter("adresse.ville");
		
		Salle salle = new Salle(id, nom, numero, voie, ville, cp);
		Singleton.getInstance().getDaoSalle().save(salle);
		
		response.sendRedirect("salle");
	}

}
