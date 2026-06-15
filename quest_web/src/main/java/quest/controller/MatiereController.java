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
import quest.model.Matiere;
import quest.service.MatiereService;

public class MatiereController{

	@Autowired
	MatiereService matiereSrv;
	
	/*public String rechercheParLib()  
	{
		String recherche = request.getParameter("recherche");
		
		List<Matiere> matieres = matiereSrv.getByLibelleContaining(recherche);
		
		if(matieres.isEmpty()) 
		{
			response.getWriter().println("<tr><td colspan='100%' align='center'>Aucune Matiere</td></tr>");
		}
		for(Matiere m : matieres) 
		{
			
			response.getWriter().println("<tr>");
			response.getWriter().println("<td>"+m.getId()+"</td>");
			response.getWriter().println("<td>"+m.getLibelle()+"</td>");
			response.getWriter().println("<td>");
			response.getWriter().println("<a href='matiere?id="+m.getId()+"' class='btn btn-warning'>Modifier</a>");
			response.getWriter().println("<a href='matiere?id="+m.getId()+"&delete' class='btn btn-danger'>Supprimer</a>");
			response.getWriter().println("</td>");
			response.getWriter().println("</tr>");
		}
		
	}*/
	
	public String chercherTous()  
	{
		List<Matiere> matieres = matiereSrv.getAll();
		request.setAttribute("matiere", new Matiere());
		request.setAttribute("matieres", matieres);
		this.getServletContext().getRequestDispatcher("/WEB-INF/matieres.jsp").forward(request, response);
		
	}
	public String chercherParId()  
	{
		List<Matiere> matieres = matiereSrv.getAll();
		
		
		Integer id =  Integer.parseInt(request.getParameter("id"));
		Matiere matiere = matiereSrv.getById(id);

		request.setAttribute("matiere", matiere);
		request.setAttribute("matieres", matieres);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/matieres.jsp").forward(request, response);
		
	}
	public String supprimer()  
	{
		Integer id =  Integer.parseInt(request.getParameter("id"));
		matiereSrv.delete(id);
		response.sendRedirect("matiere");
		
	}
	
	public String ajouter()  
	{
		String libelle = request.getParameter("libelle");
		
		Matiere matiere = new Matiere(null, libelle);
		matiereSrv.insert(matiere);
		
		response.sendRedirect("matiere");
	}
	public String modifier()  
	{
		Integer id =  Integer.parseInt(request.getParameter("id"));
		String libelle = request.getParameter("libelle");
		
		Matiere matiere = new Matiere(id, libelle);
		matiereSrv.update(matiere);
		
		response.sendRedirect("matiere");
		
	}
}
