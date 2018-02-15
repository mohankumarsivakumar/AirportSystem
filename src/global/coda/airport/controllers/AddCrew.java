package global.coda.airport.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;

import com.sun.istack.internal.logging.Logger;

import global.coda.airport.delegate.Delegate;

/**
 * Servlet implementation class AddCrew
 */
@WebServlet("/admin/AddCrew")
public class AddCrew extends HttpServlet {
	private static final long serialVersionUID = 1L;
Logger log=Logger.getLogger(AddCrew.class);
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCrew() {
		super();
		BasicConfigurator.configure();
	
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
		String name = (String) request.getParameter("name");
		String designation = (String) request.getParameter("designation");
		String contact = (String) request.getParameter("contact");
		String password = (String) request.getParameter("password");
		String gender = (String) request.getParameter("gender");
		Delegate i = new Delegate();
		int status = 0;

		status = i.addCrew(name, designation, contact, password, gender);

		if (status == 0) {
			RequestDispatcher rd = request.getRequestDispatcher("addcrew.jsp");
			request.setAttribute("schedulestatus", "crew was not added!!!");
			rd.include(request, response);
			log.info("crew was not successful");
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("addcrew.jsp");
			request.setAttribute("schedulestatus", "crew was added successfully!!!");
			rd.include(request, response);
			log.info("crew was added successful");
		}

	}

}
