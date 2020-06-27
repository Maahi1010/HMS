package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.bean.PatientBean;

import com.service.PatientService;
import com.util.DateUtil;



/**
 * Servlet implementation class PatientServlet
 */
@WebServlet("/PatientServlet")
public class PatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PatientService service = new PatientService();
		String source = request.getParameter("source");
		
		PrintWriter out = response.getWriter();
		
		
		int ssn=Integer.parseInt(request.getParameter("pid"));
		
		if(source.equals("addPatient")) {
			if(service.findCustomerBySsnId(ssn)==null) {
			PatientBean patient = new PatientBean();
			patient.setSsn(ssn);
			patient.setName(request.getParameter("name"));
			patient.setDoa(request.getParameter("date"));
			System.out.println((request.getParameter("date")));
			patient.setAge(Integer.parseInt(request.getParameter("age")));
			patient.setBedType(request.getParameter("bed"));
			patient.setCity(request.getParameter("city"));
			patient.setAddress(request.getParameter("address"));
			patient.setState(request.getParameter("state"));
		
			
			System.out.println(ssn);
		
				
				try {
					if(service.addPatient(patient)) {
						out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
						out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
						out.println("<script>");
						out.println("$(document).ready(function(){");
						out.println("swal ( 'Status', 'Customer creation initialized successfully!!', 'success');");
						out.println("});");
						out.println("</script>");
						
						RequestDispatcher rd = request.getRequestDispatcher("patientRegistration.jsp");
						rd.include(request, response);
					}
					else
					{
						out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
						out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
						out.println("<script>");
						out.println("$(document).ready(function(){");
						out.println("swal ( 'Status', 'Customer creation failed!!', 'error');");
						out.println("});");
						out.println("</script>");
						
						RequestDispatcher rd = request.getRequestDispatcher("patientRegistration.jsp");
						rd.include(request, response);


					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
				out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
				out.println("<script>");
				out.println("$(document).ready(function(){");
				out.println("swal ( 'Status', 'Customer with given SSN ID exists!!', 'error');");
				out.println("});");
				out.println("</script>");
				
				RequestDispatcher rd = request.getRequestDispatcher("patientRegistration.jsp");
				rd.include(request, response);

			}
			
		}
	}
}

