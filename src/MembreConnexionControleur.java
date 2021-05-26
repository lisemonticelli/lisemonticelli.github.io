

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class MembreConnexionControleur
 */
@WebServlet("/MembreConnexionControleur")
public class MembreConnexionControleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MembreConnexionControleur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nom_utilisateur = request.getParameter("nom_utilisateur");
		MembreDAOModele membreDAOModele = new MembreDAOModele();
		String nomVerify = membreDAOModele.verifier(nom_utilisateur);
		
		if (!nomVerify.equals("")) {
			request.getRequestDispatcher("MenuControleur").forward(request, response);
		}
		else {
			System.out.printf("Utilisateur non enregistré");
			request.getRequestDispatcher("/membreConnexionVue.jsp").forward(request, response);
		}
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
