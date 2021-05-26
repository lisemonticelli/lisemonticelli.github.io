import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProduitDAOModele {
	private List<ProduitBeanModele> produitListe = new ArrayList<ProduitBeanModele>();
	

	public int creer(ProduitBeanModele produit)
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		int resultat = -1;
		try
		{

			String requete = new String("INSERT INTO stock (reference, id_fournisseur, designation, quantite_stock, emplacement, id_machine, urgence, pump, etat_commande) VALUES (?,?,?,?,?,?,?,?,?);");
			PreparedStatement statement = connexion.prepareStatement(requete,
					Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, produit.getReference());
			statement.setInt(2, produit.getId_fournisseur().getID());
			statement.setString(3, produit.getDesignation());
			statement.setInt(4, produit.getQuantite_stock());
			statement.setString(5, produit.getEmplacement());
			statement.setInt(6, produit.getId_machine().getID());
			statement.setString(7, produit.getUrgence());
			statement.setDouble(8, produit.getPump());
			statement.setString(9, produit.getEtat_commande());

			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
				resultat = rs.getInt(1);
				produit.setID(resultat);
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

	public List<ProduitBeanModele> getProduitListe() {
		return produitListe;
	}

	public void setProduitListe(List<ProduitBeanModele> produitListe) {
		this.produitListe = produitListe;
	}

	// read all
	public List<ProduitBeanModele> lireListe()
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		List<ProduitBeanModele> produitListe = new ArrayList<ProduitBeanModele>();		

		try
		{
			String requete = new String("SELECT ID, reference, id_fournisseur, designation, quantite_stock, emplacement, id_machine, urgence, pump, etat_commande  FROM stock;");
			Statement statement = connexion.createStatement();
			ResultSet rs = statement.executeQuery(requete);

			while ( rs.next() )
			{
				ProduitBeanModele produit = new ProduitBeanModele();
				FournisseurDAOModele fournisseurDAOModele = new FournisseurDAOModele();
				MachineDAOModele machineDAOModele = new MachineDAOModele();
				produit.setID(rs.getInt("ID"));
				produit.setReference(rs.getString("reference"));
				produit.setId_fournisseur(fournisseurDAOModele.lire(rs.getInt("id_fournisseur")));
				produit.setDesignation(rs.getString("designation"));
				produit.setQuantite_stock(rs.getInt("quantite_stock"));
				produit.setEmplacement(rs.getString("emplacement"));
				produit.setId_machine(machineDAOModele.lire(rs.getInt("id_machine")));
				produit.setUrgence(rs.getString("urgence"));
				produit.setPump(rs.getDouble("pump"));
				produit.setEtat_commande(rs.getString("etat_commande"));
				produitListe.add(produit);
				
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
		return produitListe;
	}
	
	public void modifier(int id, int quantite_stock, String emplacement, String urgence, String etat_commande) {
		
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();
		
		try {
			String querty = "UPDATE stock SET quantite_stock = '" + quantite_stock + "', emplacement = '" + emplacement +"', urgence = '" + urgence + "', etat_commande = '" + etat_commande + "' WHERE ID = " + id ;
			Statement statement = connexion.createStatement();
			System.out.println(querty + "," + statement);
			statement.executeUpdate(querty);
			System.out.println("Modifications effectuées");
			
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
	}
	
	public  ProduitBeanModele lire(int id)
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		ProduitBeanModele produit = new ProduitBeanModele();
		try
		{
			String requete = new String("SELECT ID, reference, id_fournisseur, designation, quantite_stock, emplacement, id_machine, urgence, pump, etat_commande FROM stock WHERE ID = ?;");
			PreparedStatement statement = connexion.prepareStatement(requete);

			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();

			if ( rs.next() )
			{
				produit = new ProduitBeanModele();

				FournisseurDAOModele fournisseurDAOModele = new FournisseurDAOModele();
				MachineDAOModele machineDAOModele = new MachineDAOModele();
				
				produit.setID(id);
				produit.setReference(rs.getString("reference"));
				produit.setId_fournisseur(fournisseurDAOModele.lire(rs.getInt("id_fournisseur")));
				produit.setDesignation(rs.getString("designation"));
				produit.setQuantite_stock(rs.getInt("quantite_stock"));
				produit.setEmplacement(rs.getString("emplacement"));
				produit.setId_machine(machineDAOModele.lire(rs.getInt("id_machine")));
				produit.setUrgence(rs.getString("urgence"));
				produit.setPump(rs.getDouble("pump"));
				produit.setEtat_commande(rs.getString("etat_commande"));
				
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
		return produit;
	}
}



