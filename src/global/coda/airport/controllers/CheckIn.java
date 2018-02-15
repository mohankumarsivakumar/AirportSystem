package global.coda.airport.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import global.coda.airport.delegate.Delegate;

/**
 * Servlet implementation class CkeckIn
 */
@WebServlet("/customer/CheckIn")
public class CheckIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckIn() {
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
		 HttpSession session=request.getSession(false);
		 Delegate i=new Delegate();
		// out.println(request.getParameter("pnr"));
			ArrayList<Integer> a=new ArrayList<Integer>(100);
			
				try {
					a = i.checkin(Integer.parseInt(request.getParameter("pnr")),request);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
				session.setAttribute("array", a);
				session.setAttribute("arraysize", a.size());
				
				RequestDispatcher rd = request.getRequestDispatcher("seat.jsp");
				session.setAttribute("activepnr", Integer.parseInt(request.getParameter("pnr")));
				rd.include(request, response);
		
	}

}
