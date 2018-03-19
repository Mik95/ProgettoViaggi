package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.appviaggi.business.EsitoOperazione;
import it.appviaggi.business.GestionePacchetto;


/**
 * Servlet implementation class CreaPacchettoServlet
 */
@WebServlet("/pacchetto")
public class CreaPacchettoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private GestionePacchetto gp = new GestionePacchetto();
	private ObjectMapper mapper = new ObjectMapper();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreaPacchettoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int nPersone = Integer.parseInt(request.getParameter("nPersone"));
		int idLuogo = Integer.parseInt(request.getParameter("idLuogo"));
		String partenza = request.getParameter("partenza");
		String email = request.getParameter("email");
		
		int eo = gp.creaPacchetto( nPersone, idLuogo, partenza, email);
		
		String json = mapper.writeValueAsString(eo);
		response.setContentType("application/json");
		response.getWriter().append(json);


	}	
}