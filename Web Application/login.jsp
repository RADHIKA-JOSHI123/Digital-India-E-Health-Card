<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login.healthID</title>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <!-- Google Fonts -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <!-- Bootstrap core CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.0/css/mdb.min.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" type="text/css" href="css/logincss.css">
</head>
<body>
<div class="entirebody">
        <div class="logo">
            <img src="images//logos1.png">
        </div>
        <div class="healthlogo">
            <img src="images//healthidlogo.PNG">
        </div>
        <div class="topnav" id="myTopnav">
            <a href="index.html">Home</a>
            <a href="login.jsp" class="active">Login</a>
            <a href="registration.jsp">Generate ID</a>
            <a href="#contactofpage">Facility</a>
            <a href="#contactofpage">About</a>
            <a href="#contactofpage">Contact</a>
            <a href="javascript:void(0);" class="icon" onclick="myFunction()">
                <i class="fa fa-bars"></i>
            </a>
        </div>
        <div class="movingtext">
            <marquee style="background-image: linear-gradient(rgb(18, 18, 98), black, rgb(32, 32, 65)); margin-top: 10px;">
                <h5>
                    <b>Health ID - Key to your digital healthcare journey</b> | As you are aware, PM Modi recently announced the National Digital Health Mission. Under this program, citizens will get a unique Health ID which can be used anytime to get
                    a complete medical history of the patient. Generate your Health ID today itself by using your Aadhar card or your mobile number.
                </h5>
            </marquee>
        </div>

        <div class="w3-container w3-cursive" style="text-align: center; background: linear-gradient(green,rgb(59, 179, 35),green); text-align: center; display: block;">
            <table style="width: 100%;">
                <tr>
                    <td>
                        <div class="cardlies">
                            <p class="w3-xlarge" style="color: red; float:left;"><i>"Card NEVER Lies!"</i></p>
                        </div>
                    </td>
                    <td>
                        <p class="w3-large ml6">
                            <span class="text-wrapper">
                  <span class="letters" style="font-size: 25px; font-weight: bolder; color: #fff; -webkit-text-stroke: 2px black; float: right;">Login Here!!</span>
                            </span>

                        </p>
                    </td>
                    <td>
                        <a href="guidelines.pdf" target="_blank"><Button type="button" style="float: right; background: rgb(255, 0, 0); width: 150px; height: fit-content;"> Guidelines </Button></a>
                        <div class="needhelp">
                            <span style="float: right; margin-top: 20px; font-size: 20px;"> Need Help? &nbsp;&nbsp; </span></div>
                    </td>
                </tr>
            </table>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/animejs/2.0.2/anime.min.js"></script>
        </div>
        <div class="regform">
            <table style="width: 100%;">
                <tr>
                    <td>


                        <div class="medicalgif">
                            <img src="images//doc.gif" style=" width: 400px; height: auto;">
                        </div>
                    </td>
                    <td>

                        <div class="login-box">
			<form action="LoginController">
				<img src="images//ava.jpg" class="avatar">
				<h1>Login Here</h1>

				<p>Username</p>
				<input type="text" name="username" id="username"
					placeholder="Enter Username">
				<p>Password</p>
				<input type="password" name="password" id="myInput"
					placeholder="Enter Password"> <input type="checkbox"
					onclick="ShowPassword()">
				<p>Show Password</p>
				<button type="submit" value="submit" width="10%"
					style="width: 100%; border: none; outline: none; height: 40px; background: #1c8adb; color: #fff; font-size: 18px; border-radius: 20px;">Login</button>
				<a href="#">Forget Password</a> &nbsp;&nbsp;&nbsp; New here? <a
					href="registration.jsp">Sign up</a> <br>
			</form>
		</div>

                    </td>
                    <td>
                        <div class="rightgif">
                            <img src="images\\superdoc.gif" width=480px height=510px style="float : right;">
                        </div>
                    </td>
                </tr>
                <tr>
                    <td colspan="3">

                        <footer class="page-footer bg-dark" id="contactofpage">

                            <div class="bg-success">
                                <div class="container">
                                    <div class="row py-4 d-flex align-items-center">


                                        <div class="col-md-12 text-center">
                                            Connect with us on Social Media: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            <a href="#"><i class="fab fa-facebook-f white-text mr-4" > </i></a>
                                            <a href="#"><i class="fab fa-twitter white-text mr-4"> </i></a>
                                            <a href="#"><i class="fab fa-google-plus-g white-text mr-4"> </i></a>
                                            <a href="#"><i class="fab fa-linkedin-in white-text mr-4"> </i></a>
                                            <a href="#"><i class="fab fa-instagram white-text"> </i></a>
                                        </div>

                                    </div>
                                </div>
                            </div>

                            <div class="container text-center text-md-left mt-5">
                                <div class="row">

                                    <div class="col-md-3 mx-auto mb-4">
                                        <h6 class="text-uppercase font-weight-bold">NDHM.GOV.IN</h6>
                                        <hr class="bg-success mb-4 mt-0 d-inline-block mx-auto" style="width: 125px; height: 2px">
                                        <p class="mt-2" align="justify">The National Digital Health Mission aims to develop the backbone necessary to support the integrated digital health infrastructure of the country. It will bridge the existing gap amongst different stakeholders of
                                            Healthcare ecosystem through digital highways.</p>
                                    </div>

                                    <div class="col-md-2 mx-auto mb-4">
                                        <h6 class="text-uppercase font-weight-bold">Policies</h6>
                                        <hr class="bg-success mb-4 mt-0 d-inline-block mx-auto" style="width: 85px; height: 2px">

                                        <ul class="list-unstyled">
                                            <li class="my-2"><a href="#">Terms and Conditions</a></li>
                                            <li class="my-2"><a href="#">Website Policies</a></li>
                                            <li class="my-2"><a href="#">Whistle Blower Policy</a></li>
                                            <li class="my-2"> <a href="#">Privacy Policy</a></li>
                                        </ul>
                                    </div>

                                    <div class="col-md-2 mx-auto mb-4">
                                        <h6 class="text-uppercase font-weight-bold">Useful links</h6>
                                        <hr class="bg-success mb-4 mt-0 d-inline-block mx-auto" style="width: 110px; height: 2px">
                                        <ul class="list-unstyled">
                                            <li class="my-2"><a href="index.html">Home</a></li>
                                            <li class="my-2"><a href="registration.jsp">Registration</a></li>
                                            <li class="my-2"><a href="login.jsp">Login</a></li>
                                            <li class="my-2"> <a href="#">Facility</a></li>
                                        </ul>
                                    </div>

                                    <div class="col-md-3 mx-auto mb-4">
                                        <h6 class="text-uppercase font-weight-bold">Contact</h6>
                                        <hr class="bg-success mb-4 mt-0 d-inline-block mx-auto" style="width: 75px; height: 2px">
                                        <ul class="list-unstyled">
                                            <li class="my-2"><i class="fas fa-home mr-3"></i> Maharashtra, India</li>
                                            <li class="my-2"><i class="fas fa-envelope mr-3"></i> healthcardid.india@gmail.com</li>
                                            <li class="my-2"><i class="fas fa-phone mr-3"></i> + 91 234 567 88</li>
                                            <li class="my-2"><i class="fas fa-print mr-3"></i> + 91 234 567 89</li>
                                        </ul>
                                    </div>
                                </div>
                            </div>

                        </footer>
                    </td>
                </tr>
            </table>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="js/login.js"></script>
</body>
</html>