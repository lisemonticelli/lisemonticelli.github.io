

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ProduitAjoutControleur
 */
@WebServlet("/ProduitAjoutControleur")
public class ProduitAjoutControleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProduitAjoutControleur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FournisseurDAOModele fournisseurDAO = new FournisseurDAOModele();
	    List<FournisseurBeanModele> fournisseurListe = fournisseurDAO.lireListe();
	   
	    MachineDAOModele machineDAO = new MachineDAOModele();
	    List<MachineBeanModele> machineListe = machineDAO.lireListe();
	    
	    request.setAttribute("fournisseurListe", fournisseurListe);
	    request.setAttribute("machineListe", machineListe);
	    System.out.println("goGet() ProduitAjoutControleur");
		request.getRequestDispatcher("/produitAjoutVue.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reference = request.getParameter("reference");
		String fournisseur = request.getParameter("id_fournisseur");
		String designation = request.getParameter("designation");
		String quantite = request.getParameter("quantite_stock");
		String emplacement = request.getParameter("emplacement");
		String machine = request.getParameter("id_machine");
		String urgence = request.getParameter("urgence");
		String pump = request.getParameter("pump");
		String commande = request.getParameter("etat_commande");
		
		System.out.println(reference + ", " + fournisseur +", "+ designation+", "+ quantite+", "+ emplacement+", "+ machine +"," +urgence+"," +pump+", " + commande);
			
		ProduitBeanModele produit = new ProduitBeanModele();
			
		produit.setReference(reference);
		
		FournisseurDAOModele fournisseurDAOModele = new FournisseurDAOModele();
		produit.setId_fournisseur(fournisseurDAOModele.lire(new Integer(fournisseur)));
		
		produit.setDesignation(designation);
		try {
			produit.setQuantite_stock(Integer.parseInt(quantite));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		produit.setEmplacement(emplacement);
		
		MachineDAOModele machineDAOModele = new MachineDAOModele();
		produit.setId_machine(machineDAOModele.lire(new Integer(machine)));
	
		produit.setUrgence(urgence);
		try {
			produit.setPump(Double.parseDouble(pump));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		produit.setEtat_commande(commande);
		

		ProduitDAOModele produitDAOModele = new ProduitDAOModele();
		produitDAOModele.creer(produit);
		
		request.setAttribute("produit", produit);

	    System.out.println("goPost() ProduitAjoutControleur");
		request.getRequestDispatcher("MenuControleur").forward(request, response);

	}
}


