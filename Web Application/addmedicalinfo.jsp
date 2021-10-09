<%@page import="com.sun.org.apache.xalan.internal.xsltc.compiler.sym"%>
<%@ page import="com.bean.Registrationbean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Title Page-->
<title>Add Medical Information</title>

<!-- Font special for pages-->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i"
	rel="stylesheet">

<!-- Main CSS-->
<link href="css//addmedicalinfocss.css" rel="stylesheet" media="all">

<script language="Javascript" type="text/javascript">
        function ValidateWeight() {
            var weightnum = document.getElementById("weight").value;
            //alert(weightnum)
            if ((weightnum < 0) || (weightnum > 450)) {
                alert("Enter Valid Weight!!");
                document.getElementById("weight").value = "";
            }
        }

        function ValidateHeight() {
            var heightnum = document.getElementById("height").value;
            //alert(weightnum)
            if ((heightnum < 0) || (heightnum > 300)) {
                alert("Enter Valid Height!!");
                document.getElementById("height").value = "";
            }
        }

        function confirmComplete() {
            var answer = confirm("Are you sure you to Save these details?");
            if (answer == true) {
                return true;
            } else {
                return false;
            }
        }
    </script>

</head>

<body>

<%!boolean o = false;%>
	<%
		session = request.getSession(true);
		String str = (String) session.getAttribute("Usernm");
		System.out.println("In add medical info Page: " + str);
		session.setAttribute("Usernm", str);
	%>
	<div class="logo">
		<img src="images//logos1.png">
	</div>
	<div class="healthlogo">
		<img src="images//healthidlogo.PNG">
	</div>
	<div class="topnav" id="myTopnav" style="text-align: center;">
		<h1
			style="margin-top: 5px; margin-bottom: 15px; font-family: Verdana, Geneva, Tahoma, sans-serif; font-weight: bolder; color: rgb(168, 0, 0);">
			HEALTH-CARD-ID.IN</h1>
	</div>
	<div class="topnav" id="myTopnav"
		style="text-align: right; background: rgb(0, 234, 255); border: dotted black 2px;">
		<h6
			style="margin-top: 5px; margin-bottom: 10px; margin-right: 5px; font-family: Verdana, Geneva, Tahoma, sans-serif; font-weight: bolder;">
			For any queries, mail: healthcardid.india@gmail.com</h6>
	</div>
	<div class="page-wrapper bg-dark p-t-100 p-b-50"
		style="background: url('images//medicalgifbackground.gif'); background-attachment: fixed; background-repeat: no-repeat; height: auto; background-size: cover; background-position: center;">

		<div class="wrapper wrapper--w900">
			<div class="card card-6">
				<div class="card-heading">
					<h2 class="title">Add Medical Information</h2>
				</div>
				<div class="card-body" style="color: black;">
					<form action = "AddMedicalInfoController" method="get" style="color: #000;">
						<div class="form-row">
							<div class="name">Blood Group</div>
							<div class="value">
								<select name="bloodgroup" class="input--style-6" id="bloodgroup"
									placeholder="Enter Your Blood Group."
									style="width: 100%; height: 20%; color: black; font-family: Verdana; font-size: 18px; padding: 12px 20px; margin: 8px 0; display: inline-block; border: 1px solid black; box-sizing: border-box; border-radius: 8px;"
									required>
									<option value="A+">A+</option>
									<option value="A">A-</option>
									<option value="B+">B+</option>
									<option value="B-">B-</option>
									<option value="O+">O+</option>
									<option value="O-">O-</option>
									<option value="AB+">AB+</option>
									<option value="AB-">AB-</option>
								</select>
							</div>
						</div>

						<div class="form-row">
							<div class="name">Blood Pressure</div>
							<div class="value">
								<select name="bpgroup" class="input--style-6" id="bpgroup"
									placeholder="Enter Your Blood Group."
									style="width: 100%; height: 20%; color: black; font-family: Verdana; font-size: 18px; padding: 12px 20px; margin: 8px 0; display: inline-block; border: 1px solid black; box-sizing: border-box; border-radius: 8px;"
									required>
									<option value="Normal: Below 120">Normal: Below 120</option>
									<option value="Elevated: 120-129">Elevated: 120-129</option>
									<option value="Stage 1 high blood pressure: 130-139">Stage
										1 high blood pressure: 130-139</option>
									<option value="Stage 2 hypertension: 140 or more">Stage
										2 hypertension: 140 or more</option>
									<option value="Hypertensive crisis: 180 or more. Call 112.">Hypertensive
										crisis: 180 or more. Call 112.</option>

								</select>
							</div>
						</div>

						<div class="form-row">
							<div class="name">Height (in cm):</div>
							<div class="value">
								<input class="input--style-6" id="height" type="number"
									name="height" placeholder="Enter your Height in cms."
									style="width: 100%; height: 20%; color: black; font-family: Verdana; font-size: 18px; padding: 12px 20px; margin: 8px 0; display: inline-block; border: 1px solid black; box-sizing: border-box; border-radius: 8px;"
									onblur="ValidateHeight();" required>
							</div>
						</div>

						<div class="form-row">
							<div class="name">Weight (in kgs):</div>
							<div class="value">
								<input class="input--style-6" id="weight" type="number"
									name="weight" placeholder="Enter your Weight in kgs."
									style="width: 100%; height: 20%; color: black; font-family: Verdana; font-size: 18px; padding: 12px 20px; margin: 8px 0; display: inline-block; border: 1px solid black; box-sizing: border-box; border-radius: 8px;"
									onblur="ValidateWeight();" required>
							</div>
						</div>

						<div class="form-row">
							<div class="name">Allergies:</div>
							<div class="value">
								<div class="input-group">
									<textarea class="textarea--style-6" id="alergies"
										name="alergies"
										placeholder="Enter the allergies you have. Enter NA if none."
										style="width: 100%; height: 20%; color: black; font-family: Verdana; font-size: 18px; padding: 12px 20px; margin: 8px 0; display: inline-block; border: 1px solid black; box-sizing: border-box; border-radius: 8px;"
										required></textarea>
								</div>
							</div>
						</div>



						<div class="card-footer">
							<button class="btn btn--radius-2 btn--blue-2"
								id="addhealthinfobtn" type="submit"
								style="width: 100%; display: block;"
								onclick="{return confirmComplete();}">UPDATE</button>
						</div>
						<!--   <div class="form-row">
                                <div class="alert">Your past disease has been successfully added to your health card.</div>
                            </div>
                        -->
					</form>
				</div>
			</div>
		</div>
	</div>

				
</body>
</html>