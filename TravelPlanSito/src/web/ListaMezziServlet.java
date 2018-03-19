package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.appviaggi.model.MezzoDiTrasporto;

import it.appviaggi.util.JPAUtils;

/**
 * Servlet implementation class ListaMezziServlet
 */
@WebServlet("/mezzi")
public class ListaMezziServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaMezziServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<MezzoDiTrasporto> mezzi = JPAUtils.getInstance().getEm().createQuery("select m from MezzoDiTrasporto m", MezzoDiTrasporto.class).getResultList();
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(mezzi);
		response.setContentType("application/json");
		response.getWriter().append(json);
	}


}
