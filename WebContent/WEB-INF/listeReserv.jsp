<%@page import="java.util.Collection"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.text.SimpleDateFormat"%>
<!-- interface ou servlet ? -->
<%@page import="co.simplon.maisonHote.ReservationInterface"%> 
<%@page import="co.simplon.maisonHote.Reservation"%> 
<%@ page language="java" contentType="text/html; charset=UTF8"
    pageEncoding="UTF8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
		<title>Réservations effectuées</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	<body style="text-align:center;">
		<h1>Réservation efectuées</h1>
		<p>Les réservations ont été enregistrée avec les informations suivantes :</p>
			
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
		<%
			/* SimpleDateFormat dateFormater = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); */
			Collection<Reservation> listeResa = (Collection<Reservation>) request.getAttribute("reservations");
			if(listeResa != null){
				Iterator it = listeResa.iterator() ;
			    while (it.hasNext()){
			    	Reservation serveur=(Reservation) it.next() ;
		%>
					<tr>
						<td><%=serveur.getNom()%></td>
						<td><%=serveur.getPrenom()%></td>
						<td><%=serveur.getTelephone()%></td>
						<td><%=serveur.getEmail()%></td>
						<td><%=serveur.getNbNuit()%></td>
						<td><%=serveur.getNbPersonne()%></td>
						<td><%=serveur.getTypeSejour()%></td>
						<td><%if(serveur.getAnimal()==null) out.println("Non");
							else out.println("Oui");%></td>
						<td><%if(serveur.getFumeur()==null) out.println("Non");
							else out.println("Oui");%></td>
						<td><%if(serveur.getParking()==null) out.println("Non");
							else out.println("Oui");%></td>
												
						<%-- <td><%=dateFormater.format(serveur.getDateEnregistrement())%></td> --%>
					</tr>
		<%      }
			}
		%>
		</table>
		<a href="index.html" >Retour</a>
	</body>
</html>