

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FournisseurAjoutControleur
 */
@WebServlet("/FournisseurAjoutControleur")
public class FournisseurAjoutControleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FournisseurAjoutControleur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom_fournisseur= request.getParameter("nom_fournisseur");
		
		FournisseurBeanModele fournisseur= new FournisseurBeanModele();
			
		fournisseur.setNom_fournisseur(nom_fournisseur);
		
		FournisseurDAOModele fournisseurDAOModele = new FournisseurDAOModele();
		fournisseurDAOModele.creer(fournisseur);
		
		request.setAttribute("fournisseur", fournisseur);
		request.getRequestDispatcher("/fournisseurAjoutVue.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom_fournisseur= request.getParameter("nom_fournisseur");
		
		FournisseurBeanModele fournisseur= new FournisseurBeanModele();
			
		fournisseur.setNom_fournisseur(nom_fournisseur);
		
		FournisseurDAOModele fournisseurDAOModele = new FournisseurDAOModele();
		fournisseurDAOModele.creer(fournisseur);
		
		request.setAttribute("fournisseur", fournisseur);
	    System.out.println("goPost() FournisseurAjoutControleur");

		request.getRequestDispatcher("MenuControleur").forward(request, response);
		
}

}
