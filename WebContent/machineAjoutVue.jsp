<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nouvelle machine</title>
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
		margin-top:85px;
		font-size:30px;
		color : #4CAF50;
		text-align: center}
		
		.corps{
		text-align:center;
		padding-top:20px;
		line-height:100px;
		font-size :20px}
		
		.nom{
		padding: 5px 100px;
		margin-left: 20px;}
		
		.valider{
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
		
		.logo{
		margin-left: 610px;
   		margin-top: 250px;
		}
		
	</style>
	
	<body>
	
		<div class="entete">
			<div id="changer"><a href="MembreConnexionControleur" >Changer d'utilisateur</a></div>
			<h1>GESTION DES STOCKS</h1>
		</div>
		
		<h2>Ajouter une nouvelle machine</h2>
		<div class="corps">
			<form action="MachineAjoutControleur" method="post">
				Nom <input type="text" name="nom_machine" class="nom"/> <br />
		
				<input type="submit" value="Ajouter la machine" class="valider"/>
			</form>
		</div>
		<img src="https://tse2.mm.bing.net/th?id=OIP.6gt5qk_BeUmxcLckJMrrHQHaB9&pid=Api" width="300px" class="logo">
	</body>
</html>