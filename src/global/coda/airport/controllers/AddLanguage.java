package global.coda.airport.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import global.coda.airport.delegate.Delegate;

/**
 * Servlet implementation class AddLanguage
 */
@WebServlet("/admin/AddLanguage")
public class AddLanguage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddLanguage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		int crewid = Integer.parseInt((String) request.getParameter("crewid"));
		String type[] = request.getParameterValues("language");
		Delegate i = new Delegate();
		int status = 0;

		status = i.addLanguage(crewid, type);

		if(status==0) {
			RequestDispatcher rd = request.getRequestDispatcher("addlanguage.jsp");
			request.setAttribute("languagestatus", "language was not added");
			rd.include(request, response);
			
			
			}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("addlanguage.jsp");
			request.setAttribute("languagestatus", "language was added successfully");
			rd.include(request, response);
			
		}
	}

}
