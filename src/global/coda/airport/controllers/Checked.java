package global.coda.airport.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import global.coda.airport.delegate.Delegate;

/**
 * Servlet implementation class Checked
 */
@WebServlet("/customer/Checked")
public class Checked extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Checked() {
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
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		HttpSession session = request.getSession(false);
		String seats[] = request.getParameterValues("seats");
		int pnr = (int) session.getAttribute("activepnr");
		Delegate i = new Delegate();
		int valid = 0;
		try {
			valid = i.board(seats, pnr);
			// out.println(cancel);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (valid == 1) {
			out.println("successfully boarded");
			session.removeAttribute("activepnr");
			out.println("<a href='customerhome.jsp'>home</a>");
		}

		else {
			out.println("checkin failed try again!!!");

		}

	}

}
