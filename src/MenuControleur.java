

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class MenuControleur
 */
@WebServlet("/MenuControleur")
public class MenuControleur extends HttpServlet {
	

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuControleur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ProduitDAOModele produitDAOModele = new ProduitDAOModele();
		MembreDAOModele membreDAOModele = new MembreDAOModele();
		FournisseurDAOModele fournisseurDAOModele = new FournisseurDAOModele();
		MachineDAOModele machineDAOModele = new MachineDAOModele();
		
		List<ProduitBeanModele> produitListe = produitDAOModele.lireListe();
		List<MembreBeanModele> membreListe = membreDAOModele.lireListe();
		List<FournisseurBeanModele> fournisseurListe = fournisseurDAOModele.lireListe();
		List<MachineBeanModele> machineListe = machineDAOModele.lireListe();
		
		request.setAttribute("produitListe", produitListe);
		request.setAttribute("membreListe", membreListe);
		request.setAttribute("fournisseurListe", fournisseurListe);
		request.setAttribute("machineListe", machineListe);		
	
		request.getRequestDispatcher("/menuVue.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
			
