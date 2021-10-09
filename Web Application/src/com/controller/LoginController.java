package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.LoginBean;
import com.bean.Registrationbean;
import com.dao.RegisterDao;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
System.out.println("In Login Controller");
		
		String usernm = request.getParameter("username");
		String pass = request.getParameter("password");
		System.out.println(usernm+pass);
		LoginBean lobj = new LoginBean(usernm, pass);
		RegisterDao rd = new RegisterDao();
		boolean b=rd.ValidateUser(lobj);				
		if(b){
			Registrationbean r=rd.DisplayUser(usernm);
			HttpSession session = request.getSession(true);
			session.setAttribute("UserObj",r);
			request.getRequestDispatcher("Dashboard.jsp").forward(request, response);
		}
		else{
			response.sendRedirect("Error.jsp");
		}
	
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
