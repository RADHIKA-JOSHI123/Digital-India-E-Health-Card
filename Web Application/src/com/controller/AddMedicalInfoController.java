package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.MedicalInfoBean;
import com.bean.Registrationbean;
import com.dao.RegisterDao;

/**
 * Servlet implementation class AddMedicalInfoController
 */
@WebServlet("/AddMedicalInfoController")
public class AddMedicalInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMedicalInfoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String wbg = request.getParameter("bloodgroup");
		String wbp = request.getParameter("bpgroup");
		String height = request.getParameter("height");
		String weight = request.getParameter("weight");
		String allergies = request.getParameter("alergies");
		System.out.println("In add medical info controller: "+wbg+wbp+height+weight+allergies);
	
		
		
		HttpSession session = request.getSession(true);
		Registrationbean r=new Registrationbean();
		RegisterDao rd=new RegisterDao();		
		Boolean b=false;
		String str = (String) session.getAttribute("Usernm");
		System.out.println("str: "+str);
		
		r = rd.DisplayUser(str);
		
		MedicalInfoBean mib = new MedicalInfoBean(wbg,wbp,height,weight,allergies,str);
		
		int i = rd.UpdateMedicalInfo(mib);
		if(i > 0){
			session = request.getSession(true);
			session.setAttribute("UserObj",r);
			session.setAttribute("Usernm", str);
			request.getRequestDispatcher("Dashboard.jsp").forward(request, response);
		}
		else{
			System.out.println("Updation of Amount Failed!");
		}			
		
		
		
		
		//session.setAttribute("UserObj",r);
		
		
		/*
		
		
		PrintWriter out=response.getWriter();
		HttpSession session = request.getSession(true);
		boolean UpdateSuccessfull;
		String 
		Registrationbean reg = (Registrationbean) (session.getAttribute("UserObj"));
		*/
		
	
	
	
	}
		
		/*
		
		RegisterDao rd=new RegisterDao();
		System.out.println("In amic: email for testing: "+reg.getEmail());
		MedicalInfoBean mib = new MedicalInfoBean(wbg,wbp,height,weight,allergies,reg.getEmail());
		
		//int i = rd.DisplayMedicalInfo(mib.getMemail());
		
		int i=rd.UpdateMedicalInfo(mib);
		if(i>0){
			UpdateSuccessfull=true;
			
			session = request.getSession(true);
			session.setAttribute("UserObj",reg);
			request.getRequestDispatcher("Dashboard.jsp").forward(request, response);
		}
		else{
			UpdateSuccessfull=false;
			session = request.getSession(true);
			session.setAttribute("UserObj",reg);
			session.setAttribute("UpdateSuccessfullyDone",UpdateSuccessfull);
			request.getRequestDispatcher("addmedicalinfo.jsp").forward(request, response);
		}		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
