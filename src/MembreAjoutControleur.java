
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class MembreAjoutControleur
 */
@WebServlet("/MembreAjoutControleur")
public class MembreAjoutControleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MembreAjoutControleur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nom = request.getParameter("nom_utilisateur");
		
		MembreBeanModele membre = new MembreBeanModele();
		
		membre.setNom_utilisateur(nom);
		
		MembreDAOModele membreDAOModele = new MembreDAOModele();
		membreDAOModele.creer(membre);
		
		request.setAttribute("membre", membre);
		request.getRequestDispatcher("/membreAjoutVue.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String nom = request.getParameter("nom_utilisateur");
		
		MembreBeanModele membre = new MembreBeanModele();
		
		membre.setNom_utilisateur(nom);
		
		MembreDAOModele membreDAOModele = new MembreDAOModele();
		membreDAOModele.creer(membre);
		
		request.setAttribute("membre", membre);
		request.getRequestDispatcher("/membreConnexionVue.jsp").forward(request, response);

	}

}
