package global.coda.airport.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import global.coda.airport.delegate.Delegate;

/**
 * Servlet implementation class LeaveRequests
 */
@WebServlet("/crew/LeaveRequests")
public class LeaveRequests extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LeaveRequests() {
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
		Delegate i = new Delegate();
		int res = 0;
		String type = (String) request.getParameter("type");
		HttpSession session = request.getSession(false);
		session.setAttribute("count", request.getParameter("number"));
		try {
			session.setAttribute("startdate", df.parse((String)request.getParameter("leavedate")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		if (type.equals("leave")) {
		
			try {
				try {
					res = i.leaveRequests((int) session.getAttribute("cid"),df.parse((String)request.getParameter("leavedate")),Integer.parseInt((String)request.getParameter("number")));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}  catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				if (res==1) {
				out.println("your request has been recorded");
				
				
			} else {
				
				out.println("your request has not been recorded");
			}
		}

		else if (type.equals("compensation")) {
			RequestDispatcher rd = request.getRequestDispatcher("compensation.jsp");
			rd.forward(request, response);
			
		}
	}
}