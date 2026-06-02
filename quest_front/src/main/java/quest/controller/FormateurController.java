package quest.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import quest.context.Singleton;
import quest.model.Formateur;
import quest.model.Genre;


@WebServlet("/formateur")
public class FormateurController extends HttpServlet {
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
		List<Formateur> formateurs = Singleton.getInstance().getPersonneSrv().getAllFormateur();
		request.setAttribute("formateur", new Formateur());
		request.setAttribute("formateurs", formateurs);
		request.setAttribute("civilites", Genre.values());
		this.getServletContext().getRequestDispatcher("/WEB-INF/formateurs.jsp").forward(request, response);
		
	}
	public void chercherParId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		List<Formateur> formateurs = Singleton.getInstance().getPersonneSrv().getAllFormateur();
		
		Integer id =  Integer.parseInt(request.getParameter("id"));
		Formateur formateur = Singleton.getInstance().getPersonneSrv().getFormateurById(id);
		
		request.setAttribute("formateur", formateur);
		request.setAttribute("formateurs", formateurs);
		request.setAttribute("civilites", Genre.values());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/formateurs.jsp").forward(request, response);
		
	}
	public void supprimer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Integer id =  Integer.parseInt(request.getParameter("id"));
		Singleton.getInstance().getPersonneSrv().delete(id);
		response.sendRedirect("formateur");
		
	}
	public void ajouter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		Genre civ = Genre.valueOf(request.getParameter("civilite"));
		boolean admin = (request.getParameter("admin")==null)?false : true;
		
		Formateur formateur = new Formateur(null, login, password, nom, prenom, civ, admin);
		Singleton.getInstance().getPersonneSrv().insert(formateur);
		
		response.sendRedirect("formateur");
	}
	public void modifier(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Integer id =  Integer.parseInt(request.getParameter("id"));
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		Genre civ = Genre.valueOf(request.getParameter("civilite"));
		boolean admin = (request.getParameter("admin")==null)?false : true;
		
		Formateur formateur = new Formateur(id, login, password, nom, prenom, civ, admin);
		Singleton.getInstance().getPersonneSrv().update(formateur);
		
		response.sendRedirect("formateur");
	}

}
