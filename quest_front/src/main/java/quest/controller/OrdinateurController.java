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
import quest.dao.IDAOOrdinateur;
import quest.model.Ordinateur;
import quest.model.Stagiaire;
import quest.service.PersonneService;


@WebServlet("/ordinateur")
public class OrdinateurController extends HttpServlet {

	@Autowired
	IDAOOrdinateur daoOrdinateur;
	
	@Autowired
	PersonneService personneSrv;
	
	
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("numero")==null) 
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
		if(request.getParameter("numero")=="") 
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
		List<Ordinateur> ordinateurs = daoOrdinateur.findAll();
		List<Stagiaire> stagiaireDisponibles = personneSrv.getAllStagiaireDisponibles();
		request.setAttribute("ordinateur", new Ordinateur());
		request.setAttribute("ordinateurs", ordinateurs);
		request.setAttribute("utilisateurs", stagiaireDisponibles);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/ordinateurs.jsp").forward(request, response);
		
	}
	public void chercherParId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		Integer numero =  Integer.parseInt(request.getParameter("numero"));
		Ordinateur ordinateur = daoOrdinateur.findById(numero).orElse(null);

		List<Ordinateur> ordinateurs = daoOrdinateur.findAll();
		List<Stagiaire> stagiaireDisponibles = personneSrv.getAllStagiaireDisponibles();
		
		if(ordinateur.getUtilisateur()!=null) 
		{
			stagiaireDisponibles.add(ordinateur.getUtilisateur());
		}
		
		request.setAttribute("ordinateur", ordinateur);
		request.setAttribute("ordinateurs", ordinateurs);
		request.setAttribute("utilisateurs", stagiaireDisponibles);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/ordinateurs.jsp").forward(request, response);
		
	}
	public void supprimer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Integer numero =  Integer.parseInt(request.getParameter("numero"));
		daoOrdinateur.deleteById(numero);
		response.sendRedirect("ordinateur");
		
	}
	public void ajouter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String marque = request.getParameter("marque");
		int ram = Integer.parseInt(request.getParameter("ram"));
		Stagiaire utilisateur = null;
		if(!request.getParameter("utilisateur.id").equals("")) 
		{
			utilisateur = new Stagiaire();
			utilisateur.setId(Integer.parseInt(request.getParameter("utilisateur.id")));
		}
	
		Ordinateur ordinateur = new Ordinateur(null, marque,ram,utilisateur);
		daoOrdinateur.save(ordinateur);
		
		response.sendRedirect("ordinateur");
	}
	
	public void modifier(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Integer numero =  Integer.parseInt(request.getParameter("numero"));
		String marque = request.getParameter("marque");
		int ram = Integer.parseInt(request.getParameter("ram"));
		int version = Integer.parseInt(request.getParameter("version"));
		Stagiaire utilisateur = null;
		if(!request.getParameter("utilisateur.id").equals("")) 
		{
			utilisateur = new Stagiaire();
			utilisateur.setId(Integer.parseInt(request.getParameter("utilisateur.id")));
		}
	
		Ordinateur ordinateur = new Ordinateur(numero, marque,ram,utilisateur);
		ordinateur.setVersion(version);

		daoOrdinateur.save(ordinateur);
		
		response.sendRedirect("ordinateur");
		
	}

}
