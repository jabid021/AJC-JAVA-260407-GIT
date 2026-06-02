package quest.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import quest.context.Singleton;
import quest.model.Matiere;


@WebServlet("/matiere")
public class MatiereController extends HttpServlet {

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
		List<Matiere> matieres = Singleton.getInstance().getMatiereSrv().getAll();
		request.setAttribute("matiere", new Matiere());
		request.setAttribute("matieres", matieres);
		this.getServletContext().getRequestDispatcher("/WEB-INF/matieres.jsp").forward(request, response);
		
	}
	public void chercherParId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		List<Matiere> matieres = Singleton.getInstance().getMatiereSrv().getAll();
		
		
		Integer id =  Integer.parseInt(request.getParameter("id"));
		Matiere matiere = Singleton.getInstance().getMatiereSrv().getById(id);

		request.setAttribute("matiere", matiere);
		request.setAttribute("matieres", matieres);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/matieres.jsp").forward(request, response);
		
	}
	public void supprimer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Integer id =  Integer.parseInt(request.getParameter("id"));
		Singleton.getInstance().getMatiereSrv().delete(id);
		response.sendRedirect("matiere");
		
	}
	public void ajouter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String libelle = request.getParameter("libelle");
		
		Matiere matiere = new Matiere(null, libelle);
		Singleton.getInstance().getMatiereSrv().insert(matiere);
		
		response.sendRedirect("matiere");
	}
	public void modifier(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Integer id =  Integer.parseInt(request.getParameter("id"));
		String libelle = request.getParameter("libelle");
		
		Matiere matiere = new Matiere(id, libelle);
		Singleton.getInstance().getMatiereSrv().update(matiere);
		
		response.sendRedirect("matiere");
		
	}

}
