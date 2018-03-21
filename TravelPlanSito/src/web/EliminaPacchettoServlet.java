package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.appviaggi.business.GestionePacchetto;


/**
 * Servlet implementation class CreaPacchettoServlet
 */
@WebServlet("/deletePack")
public class EliminaPacchettoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private GestionePacchetto gp = new GestionePacchetto();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminaPacchettoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idPacchetto = Integer.parseInt(request.getParameter("idPacchetto"));
		
		Boolean eo = gp.eliminaPacchetto(idPacchetto);
		
		response.getWriter().append(eo.toString());


	}	
}