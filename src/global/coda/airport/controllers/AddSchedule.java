package global.coda.airport.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import global.coda.airport.delegate.Delegate;

/**
 * Servlet implementation class AddSchedule
 */
@WebServlet("/admin/AddSchedule")
public class AddSchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat tf = new SimpleDateFormat("hh:mm");

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddSchedule() {
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
		Date date = null, departuretime = null, arrivaltime = null;
		try {
			date = df.parse((String) request.getParameter("journeydate"));
			departuretime = tf.parse((String) request.getParameter("departuretime"));
			arrivaltime = tf.parse((String) request.getParameter("arrivaltime"));
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		int ecseats = Integer.parseInt((String) request.getParameter("ecseats"));
		float eccost = Float.parseFloat((String) request.getParameter("eccost"));
		int bsseats = Integer.parseInt((String) request.getParameter("bsseats"));
		float bscost = Float.parseFloat((String) request.getParameter("bscost"));

		Delegate i = new Delegate();
		int status = 0;
		try {
			status = i.addSchedule(flid, date, departuretime, arrivaltime, ecseats, eccost, bsseats, bscost);
			// out.println(cancel);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		if(status==0) {
			RequestDispatcher rd = request.getRequestDispatcher("addschedule.jsp");
			request.setAttribute("schedulestatus", "flight was not scheduled");
			rd.include(request, response);
			
			
			}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("addschedule.jsp");
			request.setAttribute("flightstatus", "flight was scheduled successfully!!! your schedule no is:"+status);
			rd.include(request, response);
			
		}
		

	}

}
