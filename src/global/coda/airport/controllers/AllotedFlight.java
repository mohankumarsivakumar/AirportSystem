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
import javax.servlet.http.HttpSession;

import global.coda.airport.bean.Schedule;
import global.coda.airport.delegate.Delegate;

/**
 * Servlet implementation class AllotedFlight
 */
@WebServlet("/crew/AllotedFlight")
public class AllotedFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllotedFlight() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		Delegate i=new Delegate();
		ArrayList<Schedule> a=new ArrayList<Schedule>();
		HttpSession session=request.getSession(false); 
			try {
				
			a=i.viewAllotedFlight((int)session.getAttribute("cid"));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			if (a == null) {
				out.println("error occured in fetching.try again!!!");
				
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("allotedflight.jsp");
				request.setAttribute("flight", a);
				rd.forward(request, response);
			}
			

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
