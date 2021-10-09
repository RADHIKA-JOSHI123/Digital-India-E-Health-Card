<%@page import="com.sun.org.apache.bcel.internal.generic.LSTORE"%>
<%@ page import="com.bean.Registrationbean"%>
<%@ page import="com.bean.DiseaseBean"%>
<%@ page import="com.bean.MedicalInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Required meta tags-->
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Title Page-->
<title>Report</title>
<script
	src="https://cdn.rawgit.com/davidshimjs/qrcodejs/gh-pages/qrcode.min.js"></script>
<!-- Font special for pages-->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i"
	rel="stylesheet">

<!-- Main CSS-->
<link href="css//reportcss.css" rel="stylesheet" media="all">
<script>
        function generateQRCode() {
        	let website = document.getElementById("idid1").value;
            //alert(website);
            if (website) {
                let qrcodeContainer = document.getElementById("qrcode");
                qrcodeContainer.innerHTML = "";
                //new QRCode(qrcodeContainer, website);
                new QRCode(qrcodeContainer, {
                    text: website,
                    width: 128,
                    height: 128,
                    colorDark: "#5868bf",
                    colorLight: "#ffffff",
                    correctLevel: QRCode.CorrectLevel.H
                });

                document.getElementById("qrcode-container").style.display = "block";
            }
        }

        function PrintDiv() {
            var divToPrint = document.getElementById('divToPrint');
            var popupWin = window.open('', '_blank', 'width=500,height=500');
            popupWin.document.open();
            popupWin.document.write('<html><body onload="window.print()">' + divToPrint.innerHTML + '</html>');
            popupWin.document.close();
        }
    </script>

</head>

<body onload="generateQRCode();">
	<%!Registrationbean reg = null;%>
	<%!MedicalInfoBean mib = null;%>
	<%!List<DiseaseBean> listdhis; %>
	<%
		if (!session.isNew()) {
		Object o = request.getAttribute("Current_User_Obj");
		reg = (Registrationbean) o;
		o = request.getAttribute("Current_Med_Obj");
		mib = (MedicalInfoBean) o;
		listdhis = (List<DiseaseBean>) request.getAttribute("DiseaseHistory");
	%>
	<div class="gettingid" id="idid">
		<input type="text" id="idid1" value="<%=reg.getHealthid()%>"
			style="display: none;">
	</div>

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

	<div class="fullbody" id="divToPrint">

		<table border="1" width=100% height=20% id="t01"
			style="margin-left: 10px; margin-bottom: 10px; margin-top: 10px; margin-right: 15px; font-size: 14px;">
			<tr style="height: 20%;">
				<td colspan="4"
					style="text-align: center; padding: 10px; font-size: 18px; margin-right: 20px; color: rgb(0, 0, 0);"
					bgcolor="FFDD90"><b> MEDICAL REPORT </b></td>
			</tr>
			<tr style="height: 20%;">
				<td colspan="4"
					style="text-align: center; padding: 10px; font-size: 14px; margin-right: 20px; color: rgb(0, 0, 0); text-align: right;">
					<b><%= (new java.util.Date()).toLocaleString()%></b>
				</td>
			</tr>
			<tr>
				<td style="padding: 10px; font-size: 16px;" bgcolor="#BCFF95"
					colspan="4"><b> PERSONAL INFORMATION</b></td>
			</tr>
			<tr>
				<td style="padding: 10px; width: 25%;"><b>HEALTH ID: </b></td>
				<td colspan="2" style="padding: 10px;"><b> <%=reg.getHealthid()%></b></td>
				<td rowspan="3">
					<div id="qrcode-container">
						<div id="qrcode" class="qrcode"></div>
				</td>

			</tr>
			<tr>
				<td style="padding: 10px;">FULL NAME</td>
				<td colspan="2" style="padding: 10px;"><b><%=reg.getRegFname()+ " " +reg.getRegMname()+ " " + reg.getRegLname()%></b>
				</td>
			</tr>
			<tr>
				<td style="padding: 10px;">DATE OF BIRTH:</td>
				<td colspan="2" style="padding: 10px;"><b><%= reg.getDob()%></b>
				</td>
			</tr>
			<tr>
				<td style="padding: 10px; width: 25%;">GENDER:</td>
				<td style="padding: 10px; width: 30%;"><b><%= reg.getGender()%></b>
				</td>
				<td style="padding: 10px; width: 20%;">BLOOD GROUP:</td>
				<td style="padding: 10px; width: 25%;"><b> <%=mib.getBg()%>
				</b></td>
			</tr>
			<tr>
				<td style="padding: 10px;">STATE:</td>
				<td style="padding: 10px;"><b> <%=reg.getState()%>
				</b></td>
				<td style="padding: 10px;">BLOOD PRESSURE:</td>
				<td style="padding: 10px;"><b> <%= mib.getBp()%> mmHg
				</b></td>
			</tr>
			<tr>
				<td style="padding: 10px;">CITY:</td>
				<td style="padding: 10px;"><b> <%=reg.getCity()%>
				</b></td>
				<td style="padding: 10px;">HEIGHT:</td>
				<td style="padding: 10px;"><b> <%=mib.getHeight()%> cm
				</b></td>
			</tr>

			<tr>
				<td style="padding: 10px;">ALLERGIES:</td>
				<td style="padding: 10px;"><b> <%=mib.getAllergies()%>
				</b></td>
				<td style="padding: 10px;">WEIGHT:</td>
				<td style="padding: 10px;"><b> <%=mib.getWeight()%> kg
				</b></td>
			</tr>
			<tr>
				<td style="padding: 10px; font-size: 16px; color: rgb(0, 0, 0);"
					bgcolor="#BCFF95" colspan="4"><b> INFECTED DISEASE HISTORY</b>

				</td>
			</tr>
			<tr></tr>
			<%
            
            %>
			<tr style="text-align: center">
				<td style="padding: 10px;" bgcolor="BCFF95"><b>DISEASE NAME</b></td>
				<td style="padding: 10px;" bgcolor="BCFF95"><b>INFECTED
						DATE</b></td>
				<td style="padding: 10px;" bgcolor="BCFF95"><b>SYMPTOMS</b></td>
				<td style="padding: 10px;" bgcolor="BCFF95"><b>TREATMENT</b></td>

			</tr>
			<%for(DiseaseBean dhisobjtemp : listdhis){ %>
			<tr style="text-align: center">
				<td style="padding: 10px;"><%=dhisobjtemp.getDNAME()%></td>
				<td style="padding: 10px;">Infected on: <%=dhisobjtemp.getDDATE()%>
				</td>
				<td style="padding: 10px;"><%=dhisobjtemp.getDSYMP()%></td>
				<td style="padding: 10px;"><%=dhisobjtemp.getDMED()%></td>
			</tr>
			<%} %>
		</table>
		<br>
		<p style="font-size: 16px; padding: 20px;">
			I hereby declare that the information provided is true and correct. I
			also understand that any willful dishonesty may render for refusal of
			this application or immediate termination of card. <br> Name:<b> <%=reg.getRegFname()+" " +reg.getRegMname()+" " +reg.getRegLname()%></b><br>
			Mobile Number: <b><%=reg.getMobno()%></b><br>Email:  <b> <%=reg.getEmail()%>
			</b><br>Location: <b>
			<%=reg.getCity()+", "+reg.getState()+"." %>
			</b>
		</p>
		<img src="images//signature1.jpg" height="100px" width="auto"
			style="display: block; float: right;"> <br>
		<br>
		<p style="text-align: center; font-size: 30px; color: red">
			<input type="button" value="Print" onclick="PrintDiv();"
				style="font-size: 20px;" />
		</p>

	</div>
	<%} %>

</body>
</html>