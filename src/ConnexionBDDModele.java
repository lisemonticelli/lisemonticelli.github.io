import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBDDModele {

	Connection connexion;

	public ConnexionBDDModele()
	{

		try
		{
			System.out.println("Chargement de pilote JDBC<-->Microsoft Access  ...");
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			System.out.println("pilote chargé.");

			String nomBDD = "gestion_stocks.accdb"; // Nom de la BD sur laquelle nous allons acceder
			String urlBDD = "jdbc:ucanaccess://C:/Gestion_Stocks/"+nomBDD;

			try
			{
				connexion = DriverManager.getConnection(urlBDD);
				System.out.println("Connexion établie.");
			}

			catch (SQLException ex)
			{
				ex.printStackTrace();
			}
		}

		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
	}

	public Connection getConnexion()
	{
		return connexion;
	}	

	public void fermerConnexion()
	{
		try
		{
			connexion.close();

		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}