package quest.controller;

import java.io.IOException;
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
		List<Matiere> matieres = Singleton.getInstance().getMatiereSrv().getAll();
		request.setAttribute("matieres", matieres);
		this.getServletContext().getRequestDispatcher("/matieres.jsp").forward(request, response);
		
	}
	public void chercherParId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}
	public void supprimer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
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
		
	}

}
