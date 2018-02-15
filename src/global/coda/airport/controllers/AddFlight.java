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
 * Servlet implementation class AddFlight
 */
@WebServlet("/admin/AddFlight")
public class AddFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFlight() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String airline=(String) request.getParameter("airline");
		String startplace=(String) request.getParameter("startplace");
		String endplace=(String)request.getParameter("endplace");
		String flno=(String) request.getParameter("flno");
		System.out.println(flno);
		Delegate i=new Delegate();
			int status =0;
			try {
				status = i.addFlight(flno,airline,startplace,endplace);
			//	out.println(cancel);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			if(status==0) {
				RequestDispatcher rd = request.getRequestDispatcher("addflight.jsp");
				request.setAttribute("flightstatus", "flight was not added");
				rd.include(request, response);
				
				
				}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("addflight.jsp");
				request.setAttribute("flightstatus", "flight was added successfully!!! your flight id is:"+status);
				rd.include(request, response);
				
			}
			
				}
	}

