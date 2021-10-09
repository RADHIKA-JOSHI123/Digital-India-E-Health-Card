package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.DiseaseBean;
import com.bean.MedicalInfoBean;
import com.bean.Registrationbean;
import com.dao.RegisterDao;

/**
 * Servlet implementation class DisplayServlet
 */
@WebServlet("/DisplayServlet")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username_op=request.getParameter("acc_uname");
		List<DiseaseBean> dlist = null;
		try{
			String str=request.getParameter("operation");
			if(str.equals("ViewProfile")){
				RegisterDao rd=new RegisterDao();
				Registrationbean r=rd.DisplayUser(username_op);
				request.setAttribute("Current_User_Obj",r);
				request.getRequestDispatcher("Display_User_Info.jsp").forward(request, response);
			}
			
			if(str.equals("ViewReport")){
				RegisterDao rd=new RegisterDao();
				Registrationbean r=rd.DisplayUser(username_op);
				request.setAttribute("Current_User_Obj",r);
				MedicalInfoBean mib = rd.DisplayMedicalInfo(username_op);
				request.setAttribute("Current_Med_Obj", mib);
				dlist = rd.DisplayDiseaseHistory(username_op);
				request.setAttribute("DiseaseHistory", dlist);
				
				request.getRequestDispatcher("report.jsp").forward(request, response);
			}
			
			
			if(str.equals("AddDisease")){
				System.out.println("IN ADD disease displayservlet");
				RegisterDao rd=new RegisterDao();
				Registrationbean r=rd.DisplayUser(username_op);
				request.setAttribute("Current_User_Obj",r);
				request.getRequestDispatcher("adddisease.jsp").forward(request, response);
			}
			
			
			
		}catch(Exception e){
			response.sendRedirect("Error.jsp");
		}

		/*if(str.equals("UpdateMedicalInfo")){
		RegisterDao rd=new RegisterDao();
		Registrationbean r=rd.DisplayUser(username_op);
		System.out.println("In display servlet: Checking the obj content: "+r.getEmail());
		request.setAttribute("Current_User_Obj",r);
		request.getRequestDispatcher("addmedicalinfo.jsp").forward(request, response);
	}
	*/

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
