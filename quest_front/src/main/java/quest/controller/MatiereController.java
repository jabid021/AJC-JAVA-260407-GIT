package quest.controller;

import jakarta.servlet.http.HttpServlet;


//@WebServlet("/matiere")
public class MatiereController extends HttpServlet {

	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id")==null) 
		{
			if(request.getParameter("recherche")==null) 
			{
				chercherTous(request,response);
			}
			else 
			{
				rechercheParLib(request,response);
			}
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

	

	public void rechercheParLib(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String recherche = request.getParameter("recherche");
		
		List<Matiere> matieres = Singleton.getInstance().getDaoMatiere().findByLibelleContaining(recherche);
		
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
*/
}
