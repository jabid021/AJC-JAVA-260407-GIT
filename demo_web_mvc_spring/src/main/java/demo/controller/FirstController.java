package demo.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class FirstController {

	
	@RequestMapping("/home")
	public String demo1() 
	{
		System.out.println("On est dans demo1 en GET !");
		return "/WEB-INF/index.jsp";
	}
	
	
	@RequestMapping(value = "/test2",method = RequestMethod.POST)
	public String demo2(@RequestParam(name="prenom") String pre, Integer age,Integer id,LocalDate naissance,Model model,HttpSession session) 
	{
		
		//String pre = request.getParameter("prenom");
		//Integer age = Integer.parseInt(request.getParameter("age"));
		
		System.out.println(pre);
		System.out.println(age);
		System.out.println(id);
		System.out.println(naissance);
		
		//Pour envoyer des donnees vers la jsp "suite.jsp" on faisait :
		//request.setAttribute("nom",value);
		
		model.addAttribute("lePrenom",pre);
		model.addAttribute("age",age);
		model.addAttribute("id",id);
		
		//Pour attacher des données dans la session utilisateur on faisait :
		//request.getSession().setAttribute("nom",value);
		session.setAttribute("leRole", "Admin");
		
	
		return "forward:/WEB-INF/suite.jsp";	//forward: est optionnel, on aurait pu ecrire return "/WEB-INF/suite.jsp"
		//return "redirect:/home"; //Redirect vers l'url d'une methode d'un controller, alors que forward va envoyer vers une jsp	
	}
	
	
	@RequestMapping(value="uneAutrePage",method = RequestMethod.GET)
	public String demo3() 
	{
		return "/WEB-INF/uneAutrePage.jsp";
	}
	
	
}
