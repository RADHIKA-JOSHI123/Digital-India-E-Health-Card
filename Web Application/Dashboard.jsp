<%@ page import = "com.bean.Registrationbean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Dashboard.healthID.in</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<!-- Google Fonts -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Material Design Bootstrap -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.0/css/mdb.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css//dashcss.css">

<script>  
  window.watsonAssistantChatOptions = {
      integrationID: "c9fe6ecd-ed2e-4a71-ab76-509d7e75a960", // The ID of this integration.
      region: "us-south", // The region your integration is hosted in.
      serviceInstanceID: "782d680f-8669-4eb4-9967-89f5a47a7b0c", // The ID of your service instance.
      onLoad: function(instance) { instance.render(); }
    };
  setTimeout(function(){
    const t=document.createElement('script');
    t.src="https://web-chat.global.assistant.watson.appdomain.cloud/loadWatsonAssistantChat.js";
    document.head.appendChild(t);
  });
</script>
<style type="text/css">
#b {
	background-color: #eee;
	border: none;
	color: blue;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	cursor: pointer;
}

#am {
	display: inline-block;
	border: 1px solid black;
	box-sizing: border-box;
	border-radius: 8px;
	background-color: lightgreen;
	text-align: center;
	float: right;
	border: 1px solid black;
	box-sizing: border-box;
	border-radius: 8px;
	background-color: lightgreen;
	box-sizing: border-box;
	border-radius: 8px;
	background-color: lightgreen;
	border-radius: 8px;
	background-color: lightgreen;
}
</style>
</head>
<body>

	<%
		Registrationbean currentUser = (Registrationbean) (session.getAttribute("UserObj"));
		session.setAttribute("Usernm", currentUser.getEmail());
		session.setAttribute("UserObj", currentUser);
	%>
	
	<!-- Side Navigation Bar -->
	<div class="sidenav">

		<form action="DisplayServlet" method="get" align="center">
			<center>
				<div class="imgcontainer">
					<img src="images//ava.jpg" alt="Avatar" class="avatar"
						style="padding-left: 50px;">
				</div>

				<h5>
					User Account:&nbsp;&nbsp; <input type="text" value="<%= currentUser.getEmail() %>"
						name="acc_uname" style="border: 2px solid #eee; background-color: #eee; font-size: 15px"
						readonly>
				</h5>
			</center>
			<hr>
			<center>
				<h4>Quick Links</h4>
			</center>
			<hr>
			<Button name="operation" value="ViewProfile" id="b">View Card</Button>
			<hr>
			<Button name="operation" value="UpdateMedicalInfo" id="b" onClick="JavaScript:window.location='addmedicalinfo.jsp';">
				<a href = "addmedicalinfo.jsp">Update Medical Information</a>
			</Button>
			<hr>
			<Button name="operation" value="AddDisease" id="b">
			<a href = "adddisease.jsp">	Add New Infected Disease </a>
			</Button>
			<hr>
			<Button name="operation" value="ViewReport" id="b">Health Report</Button>
			

			<hr>
			<Button name="operation" value="contact" id="b">
				<a href="guidelines.pdf" target="_blank"> Guidelines</a>
			</Button>
			<hr>
		</form>
	</div>
	<div class="topwelcome">

		<div
			style="background: url(https://i.postimg.cc/ZnHTP71s/aircraft-airplane-boat-1575833.jpg)"
			class="page-holder bg-cover ">
			<div class="welcome" style="padding-left: 120px;">
				<button id="blogout" style="width: auto;"
					ONCLICK="window.location.href='LogOut.jsp'">
					<i class="fa fa-fw fa-user"></i> Logout
				</button>
				<div class="container py-5">
					<header class="text-center text-white py-5">
					<h1 class="display-4 font-weight-bold mb-4">
						WELCOME TO HEALTH-CARD-ID.IN<br>
						<%= currentUser.getRegFname()+ " " + currentUser.getRegMname() + " " + currentUser.getRegLname() %>
						<br>Manage Your Entire Health
						Records <br>Here!
					</h1>
				</div>
			</div>
		</div>
	</div>
	</div>
	<div class="movingtext">
		<marquee
			style="background-image: linear-gradient(black, rgb(32, 32, 65)); color: #fff;">
			<h5>
				<b>Health ID - Key to your digital healthcare journey</b> | As you
				are aware, PM Modi recently announced the National Digital Health
				Mission. Under this program, citizens will get a unique Health ID
				which can be used anytime to get a complete medical history of the
				patient. Generate your Health ID today itself by using your Aadhar
				card or your mobile number.
			</h5>
		</marquee>
	</div>
	<br>
	<div class="middlemain"
		style="padding-left: 80px; font-family: Verdana, sans-serif;">
		<img src="images//medicalgif.gif" width="300px" height="auto"
			style="float: right;">
		<h2 style="color: #004d4d; font-size: 50px; text-align: center;">
			A Health ID will give you<br> complete ownership over your<br>
			health history
		</h2>

		<p
			style="font-size: 25px; font-family: Verdana, sans-serif; text-align: justify; psdding-left: 10px; padding-right: 10px;">Your
			Health ID is a hassle-free method of accessing your health records
			digitally. With the ability to create easy to remember Health ID, you
			can link it with your Aadhaar or Mobile number. Presenting this
			Health ID to a participating healthcare providers will allow you to
			receive your lab reports, prescriptions and diagnosis digitally from
			verified doctors and health service providers seamlessly.</p>

		<div class="tableoffeatures">
			<table style="width: 100%;">
				<tr>
					<td><img src="images//1.png"></td>
					<td><img src="images//2.png"></td>
					<td><img src="images//3.png"></td>
				</tr>
				<tr>
					<td><img src="images//4.png"></td>
					<td><img src="images//5.png"></td>
					<td><img src="images//6.png"></td>
				</tr>

			</table>
		</div>
	</div>



	<footer class="page-footer bg-dark" id="contactofpage"
		style="padding-left: 70px; color: #fff;">
	<div class="bg-success">
		<div class="container">
			<div class="row py-4 d-flex align-items-center">
				<div class="col-md-12 text-center">
					Connect with us on Social Media: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="#"><i class="fab fa-facebook-f white-text mr-4"> </i></a> <a
						href="#"><i class="fab fa-twitter white-text mr-4"> </i></a> <a
						href="#"><i class="fab fa-google-plus-g white-text mr-4">
					</i></a> <a href="#"><i class="fab fa-linkedin-in white-text mr-4">
					</i></a> <a href="#"><i class="fab fa-instagram white-text"> </i></a>
				</div>

			</div>
		</div>
	</div>

	<div class="container text-center text-md-left mt-5">
		<div class="row">

			<div class="col-md-3 mx-auto mb-4">
				<h6 class="text-uppercase font-weight-bold">NDHM.GOV.IN</h6>
				<hr class="bg-success mb-4 mt-0 d-inline-block mx-auto"
					style="width: 125px; height: 2px">
				<p class="mt-2" align="justify">The National Digital Health
					Mission aims to develop the backbone necessary to support the
					integrated digital health infrastructure of the country. It will
					bridge the existing gap amongst different stakeholders of
					Healthcare ecosystem through digital highways.</p>
			</div>

			<div class="col-md-2 mx-auto mb-4">
				<h6 class="text-uppercase font-weight-bold">Policies</h6>
				<hr class="bg-success mb-4 mt-0 d-inline-block mx-auto"
					style="width: 85px; height: 2px">

				<ul class="list-unstyled">
					<li class="my-2"><a href="#">Terms and Conditions</a></li>
					<li class="my-2"><a href="#">Website Policies</a></li>
					<li class="my-2"><a href="#">Whistle Blower Policy</a></li>
					<li class="my-2"><a href="#">Privacy Policy</a></li>
				</ul>
			</div>

			<div class="col-md-2 mx-auto mb-4">
				<h6 class="text-uppercase font-weight-bold">Useful links</h6>
				<hr class="bg-success mb-4 mt-0 d-inline-block mx-auto"
					style="width: 110px; height: 2px">
				<ul class="list-unstyled">
					<li class="my-2"><a href="index.html">Home</a></li>
					<li class="my-2"><a href="registration.jsp">Registration</a></li>
					<li class="my-2"><a href="login.jsp">Login</a></li>
					<li class="my-2"><a href="#">Facility</a></li>
				</ul>
			</div>

			<div class="col-md-3 mx-auto mb-4">
				<h6 class="text-uppercase font-weight-bold">Contact</h6>
				<hr class="bg-success mb-4 mt-0 d-inline-block mx-auto"
					style="width: 75px; height: 2px">
				<ul class="list-unstyled">
					<li class="my-2"><i class="fas fa-home mr-3"></i> Maharashtra,
						India</li>
					<li class="my-2"><i class="fas fa-envelope mr-3"></i>
						healthcardid.india@gmail.com</li>
					<li class="my-2"><i class="fas fa-phone mr-3"></i> + 91 234
						567 88</li>
					<li class="my-2"><i class="fas fa-print mr-3"></i> + 91 234
						567 89</li>
				</ul>
			</div>
		</div>
	</div>
	</footer>
</body>
</html>