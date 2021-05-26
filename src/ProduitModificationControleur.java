

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProduitModificationControleur
 */
@WebServlet("/ProduitModificationControleur")
public class ProduitModificationControleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProduitModificationControleur() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id =request.getParameter("ID");
		ProduitDAOModele produitDAOModele = new ProduitDAOModele();
		ProduitBeanModele produit = produitDAOModele.lire(Integer.parseInt(id));
		request.setAttribute("produit", produit);
		request.getRequestDispatcher("/produitModificationVue.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("ID");
		String reference = request.getParameter("reference");
		String quantite_stock = request.getParameter("quantite_stock");
		String emplacement = request.getParameter("emplacement");
		String urgence = request.getParameter("urgence");
		String commande = request.getParameter("etat_commande");
		
		ProduitBeanModele produit = new ProduitBeanModele();
		ProduitDAOModele produitDAOModele = new ProduitDAOModele();
		
		try {
			produit.setID(Integer.parseInt(id));
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		produit.setReference(reference);
		try {
			produit.setQuantite_stock(Integer.parseInt(quantite_stock));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		produit.setEmplacement(emplacement);
		produit.setUrgence(urgence);
		produit.setEtat_commande(commande);
		
		int id_modifie = produit.getID();
		int quantite_modifie = produit.getQuantite_stock();
		String emplacement_modifie = produit.getEmplacement();
		String urgence_modifie = produit.getUrgence();
		String commande_modifie = produit.getEtat_commande();
		produitDAOModele.modifier(id_modifie, quantite_modifie, emplacement_modifie, urgence_modifie, commande_modifie);
		
		request.setAttribute("produit", produit);

	    System.out.println("goPost() ProduitModificationControleur");
		request.getRequestDispatcher("MenuControleur").forward(request, response);
	}


}
