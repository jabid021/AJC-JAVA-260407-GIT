package demo.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/urlDemoServlet")
public class ServletDemo extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
	{
		System.out.println(request.getParameter("prenom"));
		
		System.out.println("On est en mode GET !");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
	{
		System.out.println(request.getParameter("prenom"));
		System.out.println("On est en mode POST !");
	}

}
