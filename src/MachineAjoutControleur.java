

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MachineAjoutControleur
 */
@WebServlet("/MachineAjoutControleur")
public class MachineAjoutControleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MachineAjoutControleur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		String nom_machine = request.getParameter("nom_machine");
		
		MachineBeanModele machine = new MachineBeanModele();
			
		machine.setNom_machine(nom_machine);
	
		MachineDAOModele machineDAOModele = new MachineDAOModele();
		machineDAOModele.creer(machine);
		
		request.setAttribute("machine", machine);
		request.getRequestDispatcher("/machineAjoutVue.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom_machine = request.getParameter("nom_machine");
			
		MachineBeanModele machine = new MachineBeanModele();
			
		machine.setNom_machine(nom_machine);

		MachineDAOModele machineDAOModele = new MachineDAOModele();
		machineDAOModele.creer(machine);
		
		request.setAttribute("machine", machine);
	    System.out.println("goPost() MachineAjoutControleur");

		request.getRequestDispatcher("MenuControleur").forward(request, response);
	}

}
