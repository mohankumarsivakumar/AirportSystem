package global.coda.airport.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import global.coda.airport.bean.CrewProfiles;
import global.coda.airport.delegate.Delegate;

/**
 * Servlet implementation class OtherCrew
 */
@WebServlet("/crew/OtherCrew")
public class OtherCrew extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OtherCrew() {
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
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		Delegate i = new Delegate();
		ArrayList<CrewProfiles> a = new ArrayList<CrewProfiles>();
		try {

			a = i.viewOtherCrew(Integer.parseInt((String) request.getParameter("sid")));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (a == null) {
			out.print("there was an error fetching data !!!");

		} else {
			RequestDispatcher rd = request.getRequestDispatcher("cocrew.jsp");
			request.setAttribute("cocrews", a);
			rd.forward(request, response);
		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
