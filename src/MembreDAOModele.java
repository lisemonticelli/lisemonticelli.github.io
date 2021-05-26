
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MembreDAOModele {

	public int creer(MembreBeanModele membre)
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		int resultat = -1;
		try
		{

			String requete = new String("INSERT INTO utilisateur (nom_utilisateur) VALUES (?);");
			PreparedStatement statement = connexion.prepareStatement(requete,
					Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, membre.getNom_utilisateur());

			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
				resultat = rs.getInt(1);
				membre.setID(resultat);
			}
			else 
				resultat = -1;

		}
		catch (SQLException ex3)
		{
			while (ex3 != null)
			{
				System.out.println(ex3.getSQLState());
				System.out.println(ex3.getMessage());
				System.out.println(ex3.getErrorCode());
				ex3=ex3.getNextException();
			}
		}
		finally 
		{
			connexionBDDModele.fermerConnexion();
		}
		return resultat;
	}

	// read all
	public List<MembreBeanModele> lireListe()
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		List<MembreBeanModele> membreListe = new ArrayList<MembreBeanModele>();		

		try
		{
			String requete = new String("SELECT ID, nom_utilisateur FROM utilisateur;");
			Statement statement = connexion.createStatement();
			ResultSet rs = statement.executeQuery(requete);

			while ( rs.next() )
			{
				MembreBeanModele membre = new MembreBeanModele();
				membre.setID(rs.getInt("ID"));
				membre.setNom_utilisateur(rs.getString("nom_utilisateur"));
				membreListe.add(membre);
			}
		}
		catch (SQLException ex3)
		{
			while (ex3 != null)
			{
				System.out.println(ex3.getSQLState());
				System.out.println(ex3.getMessage());
				System.out.println(ex3.getErrorCode());
				ex3=ex3.getNextException();
			}
		}
		finally 
		{
			connexionBDDModele.fermerConnexion();
		}
		return membreListe;
	}
	
	public String verifier(String nom)
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();
		
		try 
		{
			String requete = new String("SELECT ID, nom_utilisateur FROM utilisateur WHERE nom_utilisateur=?;");

			 PreparedStatement statement = connexion.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
			 statement.setString(1, nom);
			 ResultSet rs = statement.executeQuery();
			 
			 if (rs.next()) {
				String nomVerify = rs.getString("nom_utilisateur");
				return nomVerify;
			 }
		}
		catch (SQLException ex3)
		{
			while (ex3 != null)
			{
				System.out.println("here");
				System.out.println(ex3.getSQLState());
				System.out.println(ex3.getMessage());
				System.out.println(ex3.getErrorCode());
				ex3=ex3.getNextException();
			}
		}
		finally{
			connexionBDDModele.fermerConnexion();
		}
		return "";
	}

	public static MembreBeanModele lire(int id)
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		MembreBeanModele membre = new MembreBeanModele();
		try
		{
			String requete = new String("SELECT ID, nom_utilisateur FROM utilisateur WHERE ID = ?;");
			PreparedStatement statement = connexion.prepareStatement(requete);

			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();

			if ( rs.next() )
			{
				membre = new MembreBeanModele();
				membre.setID(id);
				membre.setNom_utilisateur(rs.getString("nom_utilisateur"));
			}
		}
		catch (SQLException ex3)
		{
			while (ex3 != null)
			{
				System.out.println(ex3.getSQLState());
				System.out.println(ex3.getMessage());
				System.out.println(ex3.getErrorCode());
				ex3=ex3.getNextException();
			}
		}
		return membre;
	}


}
