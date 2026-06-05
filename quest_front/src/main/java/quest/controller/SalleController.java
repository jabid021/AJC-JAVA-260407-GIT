package quest.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import quest.dao.IDAOSalle;
import quest.model.Salle;


@WebServlet("/salle")
public class SalleController extends HttpServlet {

	@Autowired
	IDAOSalle daoSalle;
	
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}
	
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
		List<Salle> salles = daoSalle.findAll();
		request.setAttribute("salle", new Salle());
		request.setAttribute("salles", salles);
		this.getServletContext().getRequestDispatcher("/WEB-INF/salles.jsp").forward(request, response);
		
	}
	public void chercherParId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		List<Salle> salles = daoSalle.findAll();
		
		
		Integer id =  Integer.parseInt(request.getParameter("id"));
		Salle salle = daoSalle.findById(id).orElse(null);

		request.setAttribute("salle", salle);
		request.setAttribute("salles", salles);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/salles.jsp").forward(request, response);
		
	}
	public void supprimer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Integer id =  Integer.parseInt(request.getParameter("id"));
		daoSalle.deleteById(id);
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
		daoSalle.save(salle);
		
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
		daoSalle.save(salle);
		
		response.sendRedirect("salle");
	}

}
