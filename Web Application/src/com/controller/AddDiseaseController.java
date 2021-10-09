package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.DiseaseBean;
import com.bean.Registrationbean;
import com.dao.RegisterDao;

/**
 * Servlet implementation class AddDiseaseController
 */
@WebServlet("/AddDiseaseController")
public class AddDiseaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDiseaseController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Registrationbean r=new Registrationbean();
		RegisterDao rd=new RegisterDao();		
		Boolean b=false;
		String str = (String) session.getAttribute("Usernm");
		System.out.println("iN add disease controller! str: "+str);
		
		r=rd.DisplayUser(str);		
		session.setAttribute("Usernm", str);
		
		String dname = request.getParameter("full_name");
		String dduration = request.getParameter("Period");
		String dsym = request.getParameter("message");
		String dmed = request.getParameter("medication");
		String dloc = request.getParameter("loc");
		String dhier = request.getParameter("hier_name");
		System.out.println(dname+dduration+dsym+dmed+dloc+dhier+str);
		
		DiseaseBean db = new DiseaseBean(dname,dduration,dsym,dmed,dloc,dhier,str);
		int i=rd.save_disease_Rec_Data(db);	
		if(i>0){
			System.out.println("Disease saved in db!!");				
			session = request.getSession(true);
			session.setAttribute("UserObj",r);
			request.getRequestDispatcher("Dashboard.jsp").forward(request, response);
		}

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
