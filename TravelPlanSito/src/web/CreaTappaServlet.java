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
import it.appviaggi.business.GestioneTappa;


/**
 * Servlet implementation class CreaPacchettoServlet
 */
@WebServlet("/tappa")
public class CreaTappaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private GestioneTappa gt = new GestioneTappa();
	private ObjectMapper mapper = new ObjectMapper();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreaTappaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int idMezzo = Integer.parseInt(request.getParameter("idMezzo"));
		int idStruttura = Integer.parseInt(request.getParameter("idStruttura"));
		int idPacchetto = Integer.parseInt(request.getParameter("idPacchetto"));
		String data = request.getParameter("data");
		
		Boolean eo = gt.creaTappa( idMezzo, idStruttura, idPacchetto, data);
		
		String json = mapper.writeValueAsString(eo);
		response.setContentType("application/json");
		response.getWriter().append(json);


	}	
}