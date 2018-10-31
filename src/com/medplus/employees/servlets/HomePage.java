package com.medplus.employees.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/HomePage")
public class HomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		String name=request.getParameter("user");
		
		String pw=request.getParameter("pass");
		if(name.equals("admin") && pw.equals("admin"))
		{
			session.setAttribute("user", name);
			System.out.println(session.getAttribute("user"));
			RequestDispatcher rd=request.getRequestDispatcher("WelcomeAdmin.jsp");
			rd.forward(request,response);
		}else if(name.equals("medplus") && pw.equals("hello")) {
			session.setAttribute("user", name);
			RequestDispatcher rd=request.getRequestDispatcher("WelcomeMedplus.jsp");
			rd.forward(request,response);
		}else {
			RequestDispatcher rd=request.getRequestDispatcher("UnAuthorized.jsp");
			rd.forward(request,response);
		}
    
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		doGet(request, response);
	}

}
