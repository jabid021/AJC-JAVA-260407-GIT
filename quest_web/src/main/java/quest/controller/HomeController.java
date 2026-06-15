package quest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpSession;
import quest.model.Formateur;
import quest.model.Personne;
import quest.model.Stagiaire;
import quest.service.PersonneService;


@Controller
public class HomeController {

	
	@Autowired
	PersonneService personneSrv;
	

	
	@RequestMapping(value={"/home","/"},method = RequestMethod.GET)
	public String redirectEspace(HttpSession session) 
	{
		if(session.getAttribute("connected")==null) 
		{
			return "/index.jsp";
		}
		else 
		{
			Personne connected = (Personne) session.getAttribute("connected");
			if(connected instanceof Stagiaire) 
			{
				return "/espaceStagiaire.jsp";
			}
			else if(connected instanceof Formateur) 
			{
				if(((Formateur) connected).isAdmin()) 
				{
					return "/espaceAdmin.jsp";	
				}
				else 
				{
					return "/espaceFormateur.jsp";
				}
			}
		}
		return "/index.jsp";
	}

	@RequestMapping(value="/home",method = RequestMethod.POST)
	public String connect(String login,String password,HttpSession session) 
	{
		Personne connected = personneSrv.getByLoginAndPassword(login, password);
		if(connected==null) 
		{
			return "redirect:/home?error";
		}
		else 
		{
			List<String> roles = new ArrayList();
			
			session .setAttribute("connected", connected);
			
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
			
			session.setAttribute("roles", roles);
			return "redirect:/home";
		}
	}
	
	
	@RequestMapping(value="logout",method = RequestMethod.GET)
	public String logout(HttpSession session) 
	{
		session.invalidate();
		return "redirect:/home";
	}

}
