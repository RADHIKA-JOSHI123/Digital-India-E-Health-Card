<%@ page import="com.bean.Registrationbean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Information</title>
<script
	src="https://cdn.rawgit.com/davidshimjs/qrcodejs/gh-pages/qrcode.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="css//Display_User_Info_css.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
table {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	padding: 15px;
	text-align: left;
}

#t01 tr:nth-child(even) {
	background-color: #fff;
}

#t01 tr:nth-child(odd) {
	background-color: #fff;
}

#t01 th {
	background-color: black;
	color: white;
}
</style>
<script>
        function generateQRCode() {
        	
            let website = document.getElementById("idid1").value;
           // alert(website);
            if (website) {
                let qrcodeContainer = document.getElementById("qrcode");
                qrcodeContainer.innerHTML = "";
                new QRCode(qrcodeContainer, website);

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

<body style="font-size: 30px;">
	<%!Registrationbean reg = null;%>
	<%
		if (!session.isNew()) {
		Object o = request.getAttribute("Current_User_Obj");
		reg = (Registrationbean) o;
	%>
	<div class="gettingid" id="idid">
		<input type="text" id="idid1" value="<%=reg.getHealthid()%>"
			style="display: none;">
	</div>
	<div class="topheader">
		<div class="logo">
			<img src="images//logos1.png">
		</div>
		<div class="healthlogo">
			<img src="images//healthidlogo.PNG">
		</div>
		<h1
			style="text-align: center; font-family: Verdana, Geneva, Tahoma, sans-serif; color: red;">
			HEALTH CARD</h1>
	</div>
	<hr style="height: 4px; background: red;">
	<div class="boxed" id="divToPrint">
		<div class="container">
			<table id="t01"
				style="border: 3px solid black; border-collapse: collapse; margin-left: auto; margin-right: auto;">
				<tr>
					<td colspan="3"><img src="images//cardbanner.PNG"
						style="display: block; width: 100%;" onload="generateQRCode();"></td>
				</tr>
				<tr>
					<td rowspan="3"><img src="images//finalchip.png" width="150px"
						height="auto"></td>
					<td><b><%= reg.getRegFname()+ " "+reg.getRegMname()+" " + reg.getRegLname()%></b></td>
					<td rowspan="4">
						<div id="qrcode-container">
							<div id="qrcode" class="qrcode"></div>
						</div>
					</td>
				</tr>
				<tr>
					<td>Gender: <b><%= reg.getGender()%></b>
					</td>
				</tr>
				<tr>
					<td>DOB: <b><%= reg.getDob()%></b>
					</td>
				</tr>
				<tr>
					<td><b>EMERGENCY CONTACT:</b></td>
					<td><b> <%=reg.getMobno()%>
					</b></td>
				</tr>
				<tr>
					<td><b>HEALTH ID: </b></td>

					<td colspan="2"><b><%=reg.getHealthid()%></b></td>
				</tr>
				<tr>
					<td colspan="3"
						style="border: solid #000 3px; text-align: center; background-color: rgb(71, 166, 211);"><b><i>For
								any queries, Contact: <a>healthcardid.india@gmail.com</a>
						</i></b></td>
				</tr>
			</table>
			<br>
			<table id="t01"
				style="border: 3px solid black; border-collapse: collapse; margin-left: auto; margin-right: auto;">
				<tr>
					<td colspan="3"><img src="images//cardbanner.PNG"
						style="display: block; width: 100%;"></td>
				</tr>
				<tr>
					<td><b>State:</b></td>
					<td><b> <%=reg.getState()%>
					</b></td>
				</tr>
				<tr>
					<td><b>City</b></td>
					<td><b> <%=reg.getCity()%>
					</b></td>
				</tr>
				<tr>
					<td><b>Email:</b></td>
					<td><b> <%=reg.getEmail()%>
					</b></td>
				</tr>
				<tr>
					<td><b>HEALTH ID: </b></td>
					<td colspan="2"><b><%=reg.getHealthid()%></b></td>
				</tr>
				<tr>
					<td><b>DIGITALLY SIGNED BY UIDAI:</b></td>
					<td><img src="images//signature1.jpg" height="100px"
						width="auto" style="display: block;"></td>
				</tr>
				<tr>
					<td colspan="3"
						style="border: solid #000 3px; text-align: center; background-color: rgb(71, 166, 211);"><b><i>For
								any queries, Contact: <a>healthcardid.india@gmail.com</a>
						</i></b></td>
				</tr>
			</table>
		</div>
	</div>
		<%
			}
		%>
	<p style="text-align: center; font-size: 20px; color: red">
		<input type="button" value="print" onclick="PrintDiv();" />
	</p>
	</div>
</body>
</html>