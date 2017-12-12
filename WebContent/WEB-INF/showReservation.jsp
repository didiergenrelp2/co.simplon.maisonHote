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
		
		<table border=1 class="reservationTable">
			<tr>
				<th>Nom</th>
				<th>Prenom</th>
				<th>Telephone</th>
				<th>Email</th>
				<th>Nombre de nuit(s)</th>
				<th>Nombre de personnes(s)</th>
				<th>Type de séjour</th>
				<th>Option Animal</th>
				<th>Option Fumeur</th>
				<th>Option Parking</th>
			</tr>
			<tr>
				<td><%=reservation.getNom()%></td>
				<td><%=reservation.getPrenom()%></td>
				<td><%=reservation.getTelephone()%></td>
				<td><%=reservation.getEmail()%></td>
				<td><%=reservation.getNbNuit()%></td>
				<td><%=reservation.getNbPersonne()%></td>
				<td><%=reservation.getTypeSejour()%></td>
				<td><%if(reservation.getAnimal()==null) out.println("Non");
						else out.println("Oui");%></td>
				<td><%if(reservation.getFumeur()==null) out.println("Non");
						else out.println("Oui");%></td>
				<td><%if(reservation.getParking()==null) out.println("Non");
						else out.println("Oui");%></td>
			</tr>
			
			
		</table>
		<a href="index.html" >Retour</a>
		<br>
		<a href="FormulaireServlet">Réservations effectuées</a>
		
		
	</body>
</html>