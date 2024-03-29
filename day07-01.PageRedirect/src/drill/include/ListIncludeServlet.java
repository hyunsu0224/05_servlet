package drill.include;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListIncludeServlet
 */
@WebServlet("/listinclude")
public class ListIncludeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request
						 , HttpServletResponse response) 
					throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8" );
		request.setAttribute("fruit", "사과");

		RequestDispatcher reqd = request.getRequestDispatcher("listJsp");
		
		reqd.include(request, response);
	}

}
