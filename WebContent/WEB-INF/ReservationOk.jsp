<%@ page import="co.simplon.maisonHote.Reservation"%>
<%@ page language="java" contentType="text/html; charset=UTF8"
    pageEncoding="UTF8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
		<title>Félicitation</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	<body style="text-align:center;">
<% Reservation reservation = (Reservation) request.getAttribute("reservation");%>
		<h1>Félicitation</h1>
		<p>Votre réservation a été enregistrée avec les informations suivantes :</p>
		<table class="resultTable">			
			<tr>
				<td>Nom</td>
				<td><%=reservation.getNom()%></td>
			</tr>
			<tr>
				<td>Prénom</td>
				<td><%=reservation.getPrenom()%></td>
			</tr>
			<tr>
				<td>Téléphone</td>
				<td><%=reservation.getTelephone()%></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><%=reservation.getEmail()%></td>
			</tr>
		</table>
		<a href="index.html" >Retour</a>
	</body>
</html>


