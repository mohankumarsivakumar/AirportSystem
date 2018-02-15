package global.coda.airport.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import global.coda.airport.delegate.Delegate;

/**
 * Servlet implementation class AddSeat
 */
@WebServlet("/admin/AddSeat")
public class AddSeat extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddSeat() {
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
		int flid = Integer.parseInt((String) request.getParameter("flid"));
		String type = (String) request.getParameter("type");
		int startseat = Integer.parseInt((String) request.getParameter("startseat"));
		int endseat = Integer.parseInt((String) request.getParameter("endseat"));
		Delegate i = new Delegate();
		int status = 0;

		
			status = i.addSeats(flid, type, startseat, endseat);
			if(status==0) {
				RequestDispatcher rd = request.getRequestDispatcher("addseat.jsp");
				request.setAttribute("seatstatus", "seats were not added successfully!!");
				rd.include(request, response);
				
				
				}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("addseat.jsp");
				request.setAttribute("flightstatus", "seats were added successfully");
				rd.include(request, response);
				
			}
			
	

	}

}
