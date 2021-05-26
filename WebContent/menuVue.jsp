<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Menu</title>

		<style  type="text/css">
		
			.entete{
			border-bottom : 3px solid #32CD32;}
			
			#changer{
			float:left;
			margin-left: 40px;
		    background-color:#32CD32;
		    color: black;
		    border: 2px solid #32CD32;
		    padding: 10px 20px;
		    text-align: center;
		    text-decoration:none;
		    display: inline-block;
		    font-size: 20px;
		    font-weight: bold;
			}
			
			a:link{
			text-decoration:none;}
			
			a:hover{
			color:white;}
			
			a:visited{
			color: black;}
			
			h1{
			text-align:center;
			margin-right: 275px;
			}
		
			body{
			background-color:rgb(245, 245, 245);}
			
			h2{
			text-align:center;
			margin-top:30px;
			font-size:30px;
			color : #4CAF50;}
			
			.ajout{
			float:right;
			margin-right :2px;
			background-color: #32CD32;
			font-size : 15px;
			font-weight:bold;
		    color: black;
		    border: 2px solid #32CD32;
		    padding: 10px 20px;
		    text-align: center;
		    text-decoration:none;
		    display: inline-block;}
		    
		    .modif{
		    background-color: #32CD32;
			font-size : 15px;
			font-weight:bold;
		    color: black;
		    border: 2px solid #32CD32;
		    padding: 10px 20px;
		    text-align: center;
		    text-decoration:none;
		    display: inline-block;
		    margin-left:12px;
		    }
		    
		    #myInput{
		    margin-top: 12px;
		    margin-left:2px;
	    	padding-top: 5px;
	   		padding-right: 400px;}
			
			table{
			margin: auto;
	   		width: 100%;}
	   		
			th,td{
			border:0.5px solid;}
			
			th{
			background-color:rgb(152, 251, 152)}
			
			.num{
			text-align:right;}
			
			.logo{
			margin-left: 610px;
	   		margin-top: 45px;
			}
			
		</style>
	</head>
	
	<body onload="alerter()">
		<div class="entete">
			<div id="changer"><a href="MembreConnexionControleur">Changer d'utilisateur</a></div>
			<h1>GESTION DES STOCKS</h1>
		</div>
		
		<div class="corps">
		<h2>Liste des produits</h2>
		
		<a type="button" href="ProduitAjoutControleur" class="ajout">Ajouter un produit</a>
		<a type="button" href="MachineAjoutControleur" class="ajout">Ajouter une machine</a>
		<a type="button" href="FournisseurAjoutControleur" class="ajout">Ajouter un fournisseur</a>
		<input class="w3-input w3-border w3-padding" type="text" value="Rechercher par référence" id="myInput" onkeyup="myFunction()">
	
		
		
		<table id="myTable" class="w3-table w3-bordered" >
			<tr>
				<th>Référence</th>
				<th>Fournisseur</th>
				<th>Désignation</th>
				<th>Quantité en stock</th>
				<th>Emplacement</th>
				<th>Machine</th>
				<th>Urgence</th>
				<th>PUMP</th>
				<th>Etat de commande</th>
				<th></th>
			</tr>
			<c:forEach items="${produitListe}" var="produit">
			<tr>
				<td id="reference"><c:out value="${produit.reference}" /></td>
				<td><c:out value="${produit.id_fournisseur.nom_fournisseur}" /></td>
				<td><c:out value="${produit.designation}" /></td>
				<td id="stock" class="num"><c:out value="${produit.quantite_stock}" /></td>
				<td><c:out value="${produit.emplacement}" /></td>
				<td><c:out value="${produit.id_machine.nom_machine}" /></td>
				<td id="urgence"><c:out value="${produit.urgence}" /></td>
				<td class="num"><c:out value="${produit.pump}" /></td>
				<td id="commande"><c:out value="${produit.etat_commande}" /></td>
				<td><a type="button" href="ProduitModificationControleur?ID=<c:out value="${produit.ID}" />&quantite_stock=<c:out value="${produit.quantite_stock}" />&emplacement=<c:out value="${produit.emplacement}" />&urgence=<c:out value="${produit.urgence}" />&etat_commande=<c:out value="${produit.etat_commande}" />" class="modif">Modifier</a></td> 
			</tr>
			</c:forEach>
		</table>
		</div>
		
		<img src="https://tse2.mm.bing.net/th?id=OIP.6gt5qk_BeUmxcLckJMrrHQHaB9&pid=Api" width="300px" class="logo">
			
		<script  type="text/javascript">
			var document="C:\Gestion_Stocks\gestion_stocks.accdb"
			function myFunction() {
			  var input, filter, table, tr, td, i;
			  input = document.getElementById("myInput");
			  filter = input.value.toUpperCase();
			  table = document.getElementById("myTable");
			  tr = table.getElementsByTagName("tr");
			  for (i = 0; i < tr.length; i++) {
			    td = tr[i].getElementsByTagName("td")[0];
			    if (td) {
			      txtValue = td.textContent || td.innerText;
			      if (txtValue.toUpperCase().indexOf(filter) > -1) {
			        tr[i].style.display = "";
			      } else {
			        tr[i].style.display = "none";
			      }
			    }
			  }
			}
	
			document.getElementsByTagName("body").onload = function() {alerter()};
			function alerter(){
				var reference, urgence, commande, i, quantite, tr, table, td;
				table = document.getElementById("myTable");
				tr = table.getElementsByTagName("tr");
				//window.alert(reference + "," + quantite +"," + urgence +", "+commande);
				for (i=1; i<=tr.length; i++){
	
				    td = tr[i].getElementsByTagName("td");
					reference = td[0].innerHTML;
					quantite = td[3].innerHTML;
					urgence = td[6].innerHTML;
					commande = td[8].innerHTML;

					if (urgence ==="Moyenne"){
						if (commande === "En cours de livraison"){
							document.getElementsByTagName("tr")[i].style.backgroundColor = "yellow";
						}
						else if (commande === "Arrivée sur site"){
							document.getElementsByTagName("tr")[i].style.backgroundColor = "rgb(152, 251, 152)";
							window.alert("La commande du produit "+ reference + " est arrivée et est prête à être rangée.");
						}
						else if (commande === "A commander"){
							document.getElementsByTagName("tr")[i].style.backgroundColor = "orange";
							alert("Le produit "+ reference + " doit être commandé !");
						}
					}
					else if (urgence === "Elevée"){
						if (commande === "En cours de livraison"){
							//tr[i].css("background-color","yellow");
							document.getElementsByTagName("tr")[i].style.backgroundColor = "yellow";
						}
						else if (commande === "Arrivée sur site"){
							//tr[i].css("background-color","green");
							document.getElementsByTagName("tr")[i].style.backgroundColor = "rgb(152, 251, 152)";
							window.alert("La commande du produit "+ reference + " est arrivée et est prête à être rangée.");
						}
						else if (commande === "A commander"){
							//tr[i].css("background-color","red");
							document.getElementsByTagName("tr")[i].style.backgroundColor = "red";
							window.alert("Le produit "+ reference + " doit être commandé !");
						}
					}
					/*else if (quantite < 2){
						document.getElementsByTagName("tr")[i].style.backgroundColor = "red";
						window.alert("Stock du produit "+ reference +" insuffisant !");
					}*/
				}
				
			}
		</script>
	</body>
</html>