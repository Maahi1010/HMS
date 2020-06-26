package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.LoginBean;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();    
        HttpSession session=request.getSession();  
        session.invalidate();  
        RequestDispatcher rd = 
				getServletContext().getRequestDispatcher("/login.jsp");
		
		
		
        out.print("You are successfully logged out!");  
        rd.include(request, response);
        out.close();  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out=response.getWriter();  
        
          
        String name=request.getParameter("username");  
       String password=request.getParameter("password");  
        LoginBean userBn = new LoginBean();
		userBn.setUsername(name);
		userBn.setPassword(password);
		//UserService userSvc = new UserService();
		//boolean userFound= userSvc.getUserService(userBn);
		if(password.equalsIgnoreCase("admin123")) {
			HttpSession session=request.getSession();  
	        session.setAttribute("name",userBn.getUsername()); 
			//RequestDispatcher rd = getServletContext().getRequestDispatcher("/welcome.jsp");
	        out.print("You are successfully logged in !");  
	        out.println("<a href='LoginServlet' method='get'>logout</a>");  
	        
			//rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = 
					getServletContext().getRequestDispatcher("/login.jsp");
			
			out.println("<font color=red>No user found, please enter correct credentials. </font>");
			rd.include(request, response);
		}
}
	}

