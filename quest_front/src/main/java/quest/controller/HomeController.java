package quest.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import quest.model.Formateur;
import quest.model.Personne;
import quest.model.Stagiaire;
import quest.service.PersonneService;


@WebServlet("/home")
public class HomeController extends HttpServlet {

	
	@Autowired
	PersonneService personneSrv;
	
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("logout")!=null) 
		{
			request.getSession().invalidate();
		}
		
		
		if(request.getSession().getAttribute("connected")==null) 
		{
			this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
		else 
		{
			Personne connected = (Personne) request.getSession().getAttribute("connected");
			if(connected instanceof Stagiaire) 
			{
				this.getServletContext().getRequestDispatcher("/espaceStagiaire.jsp").forward(request, response);
			}
			else if(connected instanceof Formateur) 
			{
				if(((Formateur) connected).isAdmin()) 
				{
					this.getServletContext().getRequestDispatcher("/espaceAdmin.jsp").forward(request, response);	
				}
				else 
				{
					this.getServletContext().getRequestDispatcher("/espaceFormateur.jsp").forward(request, response);
				}
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		Personne connected = personneSrv.getByLoginAndPassword(login, password);
		
		if(connected==null) 
		{
			response.sendRedirect("home?error");
		}
		else 
		{
			List<String> roles = new ArrayList();
			request.getSession().setAttribute("connected", connected);
			
			if(connected instanceof Stagiaire) 
			{
				roles.add("ROLE_STAGIAIRE");
			}
			else 
			{
				roles.add("ROLE_FORMATEUR");
				if(((Formateur) connected).isAdmin()) 
				{
					roles.add("ROLE_ADMIN");
				}
			}
			
			request.getSession().setAttribute("roles", roles);
			response.sendRedirect("home");
		}
		
		
		
		
		
	}

}
