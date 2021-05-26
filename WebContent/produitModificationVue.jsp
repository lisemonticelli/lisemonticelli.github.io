<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifier le produit</title>
</head>
	<style>
	
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
		margin-right: 260px;
		}
	
		body{
		background-color:rgb(245, 245, 245);}
		
		h2{
		text-align:center;
		margin-top:30px;
		font-size:30px;
		color : #4CAF50;}
		
		.corps{
		margin-left:600px;}
		
		.choix{
		text-align:justify;
		font-size :15px;}
				
		.element4{
		padding-right:105px;}
				
		.element6{
		padding-right:193px;}

		.element8{
		padding-right:60px;}
		
		.valider{
	    background-color:#32CD32;
	    margin-top:20px;
	    margin-left : 20px;
	    color: black;
	    border: 2px solid #32CD32;
	    padding: 10px 20px;
	    text-align: center;
	    text-decoration:none;
	    display: inline-block;
	    font-size: 20px;
	    font-weight: bold;
		}
		
		.logo{
		margin-left: 610px;
   		margin-top: 160px;
		}
		
	</style>
	
	<body>
	
		<div class="entete">
			<div id="changer"><a href="MembreConnexionControleur" >Changer d'utilisateur</a></div>
			<h1>GESTION DES STOCKS</h1>
		</div>
		
		<h2>Modifier l'etat du stock</h2>
		<div class="corps">
			<form action="ProduitModificationControleur" method="post">
			<div class="choix">
				<p hidden> <input type="text" name="ID" value="${produit.ID}"/></p>
				<p>Référence 
					<c:out value="${produit.reference}" />
				</p>
				
				<p>Quantité stock : <input type="number" name="quantite_stock" value="<c:out value="${produit.quantite_stock}"/>"/></p>
				
				 
				<p>	Emplacement : </p>
				
					<dl>
						<dt><input type="checkbox" name="emplacement" value="Camion" checked="<c:out value="${produit.emplacement}"/>"/> Camion </dt>
						<dt><input type="checkbox" name="emplacement" value="Stock" checked="<c:out value="${produit.emplacement}"/>"/> Stock atelier </dt>
						<dt><input type="checkbox" name="emplacement" value="Stock et camion" checked="<c:out value="${produit.emplacement}"/>"/> Stock et camion </dt>
					</dl>
					
				<p>Urgence</p>
					<p>Ancien état d'urgence  : <c:out value="${produit.urgence}" /> </p>
					Nouvel état d'urgence : 
					<select name="urgence" class="element6">
						<option value="Basse">Basse</option>
						<option value="Moyenne">Moyenne</option>
						<option value="Elevée">Elevée</option>
					</select>
				
				
				<p>Etat de Commande</p>
					<p> Ancien état de la commande : <c:out value="${produit.etat_commande}" /></p>
					Nouvel état de la commande : 
					<select name="etat_commande" class="element8">
						<option value="En stock">En stock</option>
						<option value="A commander">A commander</option>
						<option value="En cours de livraison">En cours de livraison</option>
						<option value="Arrivé sur site">Arrivée sur site</option>
					</select>
				
				</div>
				<input type="submit" value="Enregistrer la modification" class="valider"/>
			</form>
		</div>
		<img src="https://tse2.mm.bing.net/th?id=OIP.6gt5qk_BeUmxcLckJMrrHQHaB9&pid=Api" width="300px" class="logo">
	</body>
</html>