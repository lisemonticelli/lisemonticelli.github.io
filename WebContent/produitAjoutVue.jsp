<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Ajout de produit</title>
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
		
		.element1{
		padding-right:100px;}
		
		.element2{
		padding-right:74px;}
		
		.element3{
		padding-right:88px;}
		
		.element4{
		padding-right:56px;}
		
		.element5{
		padding-right:185px;}
		
		.element6{
		padding-right:193px;}
		
		.element7{
		padding-right:119.5px;}
		
		.element8{
		padding-right:105px;}
		
		.valider{
	    background-color:#32CD32;
	    margin-top:20px;
	    margin-left : 100px;
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
   		margin-top: 45px;
		}
		
	</style>
	
	<body>
	
		<div class="entete">
			<div id="changer"><a href="MembreConnexionControleur" >Changer d'utilisateur</a></div>
			<h1>GESTION DES STOCKS</h1>
		</div>
		
		<h2>Ajouter un nouveau produit</h2>
		
		<div class="corps">
			<form action="ProduitAjoutControleur" method="post">
				<div class="choix">
				Référence <input type="text" name="reference" class="element1" value="<c:out value="${produit.reference}"/>" /><br />
				
				<p>Fournisseur
					<select name="id_fournisseur" class="element2">
					<c:forEach items="${fournisseurListe}" var="fournisseur">
						<option value="${fournisseur.ID}">${fournisseur.nom_fournisseur}</option>
					</c:forEach>
					</select>
				</p>
				
				Désignation <input type="text" name="designation" class="element3" value="<c:out value="${produit.designation}"/>"/><br />
				
				Quantité en stock <input type="number" name="quantite_stock"  class="element4" value="<c:out value="${produit.quantite_stock}"/>"/> <br />
				
				Emplacement :
					<dl>
						<dt><input type="checkbox" name="emplacement" value="Camion" /> Camion </dt>
						<dt><input type="checkbox" name="emplacement" value="Stock"/> Stock atelier </dt>
						<dt><input type="checkbox" name="emplacement" value="Stock et camion"/> Stock et camion</dt>
					</dl>
						
				<p>Machine
					<select name="id_machine"  class="element5">
						<c:forEach items="${machineListe}" var="machine">
							<option value="${machine.ID}">${machine.nom_machine}</option>
						</c:forEach>
					</select>
				</p>
				
				<p>Urgence
					<select name="urgence" class="element6">
						<option value="Basse">Basse</option>
						<option value="Moyenne">Moyenne</option>
						<option value="Elevée">Elevée</option>
					</select>
				</p>
				
				PUMP <input type="number" name="pump"  class="element7"/><br />
				
				<p>Etat de Commande
					<select name="etat_commande" class="element8">
						<option value="En stock">En stock</option>
						<option value="A commander">A commander</option>
						<option value="En cours de livraison">En cours de livraison</option>
						<option value="Arrivée sur site">Arrivée sur site</option>
					</select>
				</p>
								
				</div>		
				<input type="submit" value="Ajouter" class="valider"/>
				
			</form>
		</div>
	
		<img src="https://tse2.mm.bing.net/th?id=OIP.6gt5qk_BeUmxcLckJMrrHQHaB9&pid=Api" width="300px" class="logo">
		
	</body>
</html>