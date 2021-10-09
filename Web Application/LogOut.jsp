<%@ page import="com.bean.Registrationbean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logout Successfully</title>
<SCRIPT type="text/javascript">
	window.history.forward();
	function noBack() {
		window.history.forward();
	}
</SCRIPT>
</head>
<body onload="noBack();" onpageshow="if (event.persisted) noBack();"
	onunload="">
	<%
	
		session = request.getSession(true);
		//session.invalidate();

		Registrationbean r = (Registrationbean) session.getAttribute("UserObj");
		r = null;
		session.setAttribute("Usernm", r);
		System.out.println("Logout jsp page: " + r);
		response.setHeader("Cache-Control", "no-cache");

		response.setHeader("Cache-Control", "no-store");

		response.setHeader("Pragma", "no-cache");

		response.setDateHeader("Expires", 0);
		if (session.getAttribute("userRecord") == null) {

			response.sendRedirect("index.html");

		}
		//System.out.println("Logout jsp page: " + r);
		//r = null;
		//session.setAttribute("Usernm", r);

//		User user = (User) session.getAttribute("userRecord");

	//	response.setHeader("Cache-Control", "no-cache");
//
	//	response.setHeader("Cache-Control", "no-store");
//
	//	response.setHeader("Pragma", "no-cache");

		//response.setDateHeader("Expires", 0);

//		if (session.getAttribute("userRecord") == null) {

	//		response.sendRedirect("/index.jsp");
//
	//	}
	%><center>
		<h1>
			Log out Successfully!! <br> Hope you had a great experience!!<br>
			<a href="Home.html">Click here to Continue!!</a>
		</h1>
	</center>
</body>
</html>