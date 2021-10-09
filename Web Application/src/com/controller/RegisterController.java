package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.MedicalInfoBean;
import com.bean.Registrationbean;
import com.dao.RegisterDao;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegisterController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		int i;
		String regFname = request.getParameter("firstname");
		String regMname = request.getParameter("mname");
		String regLname = request.getParameter("sname");
		String dob = request.getParameter("birthday");
		String gender = request.getParameter("gender");
		String state = request.getParameter("state");
		String city = request.getParameter("city");
		String email = request.getParameter("email");
		String mobno = request.getParameter("mobno");
		String pass = request.getParameter("pass");

		System.out.println(regFname+regMname+regLname+dob+gender+state+city+email+mobno+pass);

		Registrationbean regobj = new Registrationbean(regFname, regMname, regLname, dob, gender, state, city, email, mobno, pass,null);
		regobj.createHealthid();
		MedicalInfoBean mib = new MedicalInfoBean("NA","NA","NA","NA","NA",email);
		RegisterDao rd = new RegisterDao();
		i=rd.saveData(regobj);
		if(i>0){
			i = rd.saveMedicalData(mib);
			if(i > 0){
			
			response.sendRedirect("login.jsp");
			}
			else{
				response.sendRedirect("Error.jsp");
				System.out.println("Insertion Failed in medical data!");
			}
		}
		else{
			response.sendRedirect("Error.jsp");
			System.out.println("Insertion Failed in registration!");
		}
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
