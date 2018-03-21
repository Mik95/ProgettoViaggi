package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.appviaggi.model.ViaggioDiRientro;
import it.appviaggi.util.JPAUtils;

/**
 * Servlet implementation class ListaMezziServlet
 */
@WebServlet("/rientri")
public class ListaRientriServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaRientriServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<ViaggioDiRientro> rientri = JPAUtils.getInstance().getEm().createQuery("select r from ViaggioDiRientro r", ViaggioDiRientro.class).getResultList();
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(rientri);
		response.setContentType("application/json");
		response.getWriter().append(json);
	}


}
