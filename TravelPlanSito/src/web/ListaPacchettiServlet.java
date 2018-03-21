package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.appviaggi.model.PacchettoViaggio;
import it.appviaggi.util.JPAUtils;

/**
 * Servlet implementation class ListaMezziServlet
 */
@WebServlet("/pacchetti")
public class ListaPacchettiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaPacchettiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<PacchettoViaggio> pacchetti = JPAUtils.getInstance().getEm().createQuery("select p from PacchettoViaggio p", PacchettoViaggio.class).getResultList();
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(pacchetti);
		response.setContentType("application/json");
		response.getWriter().append(json);
	}


}
