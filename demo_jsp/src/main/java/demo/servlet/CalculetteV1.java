package demo.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/calculetteV1")
public class CalculetteV1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().println("<html>");
		response.getWriter().println("<body>");
		response.getWriter().println("<h1>Quackulette du futur (v1)</h1>");
		response.getWriter().println("<form action='calculetteV1' method='POST'>");
		response.getWriter().println("<input type='number' name='nb1'>");
		response.getWriter().println("<input type='number' name='nb2'>");
		response.getWriter().println("<input checked type='radio' name='operation' value='add'>Add <input type='radio' name='operation' value='soustract'>Soustract");
		response.getWriter().println("<input type='submit' value='Calculate'>");
		response.getWriter().println("</form>");
		response.getWriter().println("</body>");
		response.getWriter().println("</html>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(request.getParameter("operation"));

		int nb1 = Integer.parseInt(request.getParameter("nb1"));
		int nb2 = Integer.parseInt(request.getParameter("nb2"));
		String operation = request.getParameter("operation");
		int resultat;
		if(operation.equals("add")) 
		{
			resultat = nb1+nb2;
		}
		else 
		{
			resultat = nb1-nb2;
		}
		
		response.getWriter().println("<p>Le resultat de l'operation "+nb1+" "+operation+" "+nb2+ " est => "+resultat+" <p/>");
		
		
	}

}
