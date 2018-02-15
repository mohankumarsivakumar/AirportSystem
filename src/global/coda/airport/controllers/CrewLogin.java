package global.coda.airport.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import global.coda.airport.delegate.Delegate;

/**
 * Servlet implementation class CrewLogin
 */
@WebServlet("/crew/CrewLogin")
public class CrewLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CrewLogin() {
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
		int cid = Integer.parseInt(request.getParameter("cid"));
		String password = request.getParameter("password");
		Delegate i = new Delegate();
		int valid = 0;
		valid = i.verifyCrewLogin(cid, password);
		if (valid == 1) {
			HttpSession session = request.getSession(true);
			session.setAttribute("cid", cid);

			RequestDispatcher rd = request.getRequestDispatcher("crewhomepage.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("crewlogin.jsp");
			request.setAttribute("employeestatus", "invalid employeeid or password");
			rd.include(request, response);

		}
	}

}
