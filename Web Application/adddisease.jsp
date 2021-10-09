<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Title Page-->
<title>Add Disease</title>

<!-- Font special for pages-->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i"
	rel="stylesheet">

<!-- Main CSS-->
<link href="css//adddiseasecss.css" rel="stylesheet" media="all">

<script language="Javascript" type="text/javascript">
	function confirmComplete() {
		var answer = confirm("Are you sure you add it to your records?");
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
		System.out.println("In Add disease Page: " + str);
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
	<div class="page-wrapper bg-dark p-t-100 p-b-50" style="background: url('images//medicalgifbackground.gif'); background-attachment: fixed; background-repeat: no-repeat; height: auto; background-size: cover; background-position: center;">
		
			<div class="wrapper wrapper--w900">
				<div class="card card-6">
					<div class="card-heading">
						<h2 class="title">Add Disease</h2>
					</div>
					<div class="card-body" style="color: black;">
						<form action ="AddDiseaseController" method="get">
							<div class="form-row">
								<div class="name">Disease Name</div>
								<div class="value">
									<input class="input--style-6" id="diseasename" type="text"
										name="full_name" placeholder="Disease Name" style="width: 100%; height: 20%; color: black; font-family: Verdana; font-size: 18px; padding: 12px 20px; margin: 8px 0; display: inline-block; border: 1px solid black; box-sizing: border-box; border-radius: 8px;" required>
								</div>
							</div>

							<div class="form-row">
								<div class="name">Infected Date</div>
								<div class="value">
									<input class="input--style-6" type="date" name="Period"
										id="diseasedate" style="width: 100%; height: 20%; color: black; font-family: Verdana; font-size: 18px; padding: 12px 20px; margin: 8px 0; display: inline-block; border: 1px solid black; box-sizing: border-box; border-radius: 8px;" required>
								</div>
							</div>

							<div class="form-row">
								<div class="name">Symptoms</div>
								<div class="value">
									<div class="input-group">
										<textarea class="textarea--style-6" id="diseasesymptoms"
											name="message"
											placeholder="Enter the Symptoms you faced during the Disease period." style="width: 100%; height: 20%; color: black; font-family: Verdana; font-size: 18px; padding: 12px 20px; margin: 8px 0; display: inline-block; border: 1px solid black; box-sizing: border-box; border-radius: 8px;"
											required></textarea>
									</div>
								</div>
							</div>
							<div class="form-row">
								<div class="name">Medication:</div>
								<div class="value">
									<input class="input--style-6" id="medication" type="text"
										name="medication"
										placeholder="Medication consumed for treatment." style="width: 100%; height: 20%; color: black; font-family: Verdana; font-size: 18px; padding: 12px 20px; margin: 8px 0; display: inline-block; border: 1px solid black; box-sizing: border-box; border-radius: 8px;" required>
								</div>
							</div>
							<div class="form-row">
								<div class="name">Location:</div>
								<div class="value">
									<input class="input--style-6" id="loc" type="text" name="loc"
										placeholder="City where you got infected at." style="width: 100%; height: 20%; color: black; font-family: Verdana; font-size: 18px; padding: 12px 20px; margin: 8px 0; display: inline-block; border: 1px solid black; box-sizing: border-box; border-radius: 8px;" required>
								</div>
							</div>
							<div class="form-row">
								<div class="name">Hierarchical Disease</div>
								<div class="value">
									<input class="input--style-6" id="hiername" type="text"
										name="hier_name"
										placeholder="Hierarchical Disease from Parents. Enter NA if none."
										style="width: 100%; height: 20%; color: black; font-family: Verdana; font-size: 18px; padding: 12px 20px; margin: 8px 0; display: inline-block; border: 1px solid black; box-sizing: border-box; border-radius: 8px;" required>
								</div>
							</div>
							<div class="card-footer">
								<button class="btn btn--radius-2 btn--blue-2" id="adddiseasebtn"
									type="submit" style="width: 100%; display: block;" onclick="{return confirmComplete();}">ADD</button>
							</div>
							<div class="form-row">
								<div class="alert">Your past disease has been successfully
									added to your health card.</div>
							</div>
						</form>
					</div>
				</div>
			</div>
	</div>

</body>
</html>