package br.com.cinema.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/login")
public class ServletLogin extends HttpServlet implements Servlet 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String ERRO = "Ocorreu um erro! Verifique login e senha.";

	protected void doGet(HttpServletRequest request, 
						HttpServletResponse response) 
						throws ServletException, IOException 
	{
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, 
						  HttpServletResponse response) 
						  throws ServletException, IOException
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username.equals("admin") && password.equals("admin"))
		{
			HttpSession session = request.getSession();
			session.setAttribute("username",username);
			
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request,response);
		}
		else
		{
			response.sendRedirect("login.jsp?erro="+ ERRO);
		}
	}

}




