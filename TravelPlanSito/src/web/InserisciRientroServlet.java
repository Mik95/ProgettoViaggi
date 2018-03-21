package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.appviaggi.business.GestionePacchetto;

/**
 * Servlet implementation class InserisciRientroServlet
 */
@WebServlet("/rientro")
public class InserisciRientroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private GestionePacchetto gp = new GestionePacchetto();
	private ObjectMapper mapper = new ObjectMapper();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserisciRientroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idLuogo = Integer.parseInt(request.getParameter("idLuogo"));
		int idMezzo = Integer.parseInt(request.getParameter("idMezzo"));
		int idPacchetto = Integer.parseInt(request.getParameter("idPacchetto"));
		
		Boolean eo = gp.inserisciViaggioRientro(idLuogo, idMezzo, idPacchetto);
		
		String json = mapper.writeValueAsString(eo);
		response.setContentType("application/json");
		response.getWriter().append(json);


	}	
}
