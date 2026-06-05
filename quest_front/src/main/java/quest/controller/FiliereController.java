package quest.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import quest.dao.IDAOFiliere;
import quest.dao.IDAOSalle;
import quest.model.Filiere;
import quest.model.Salle;


@WebServlet("/filiere")
public class FiliereController extends HttpServlet {

	@Autowired
	IDAOFiliere daoFiliere;
	
	@Autowired
	IDAOSalle daoSalle;



	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}

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
		List<Filiere> filieres = daoFiliere.findAll();
		List<Salle> salles = daoSalle.findAll();
		request.setAttribute("filiere", new Filiere());
		request.setAttribute("filieres", filieres);
		request.setAttribute("salles", salles);

		this.getServletContext().getRequestDispatcher("/WEB-INF/filieres.jsp").forward(request, response);

	}
	public void chercherParId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		Integer id =  Integer.parseInt(request.getParameter("id"));
		Filiere filiere = daoFiliere.findById(id).orElse(null);

		List<Filiere> filieres = daoFiliere.findAll();
		List<Salle> salles = daoSalle.findAll();

		request.setAttribute("filiere", filiere);
		request.setAttribute("filieres", filieres);
		request.setAttribute("salles", salles);

		this.getServletContext().getRequestDispatcher("/WEB-INF/filieres.jsp").forward(request, response);

	}
	public void supprimer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Integer id =  Integer.parseInt(request.getParameter("id"));
		daoFiliere.deleteById(id);
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
		daoFiliere.save(filiere);

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

		daoFiliere.save(filiere);

		response.sendRedirect("filiere");

	}

}
