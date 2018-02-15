package global.coda.airport.controllers;

import java.io.IOException;
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
 * Servlet implementation class SlotRequests
 */
@WebServlet("/crew/SlotRequests")
public class SlotRequests extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DateFormat df=new SimpleDateFormat("yyyy-MM-dd");   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SlotRequests() {
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
		Delegate i=new Delegate();
		 HttpSession session=request.getSession(false);  
		String res="";
			try {
				
			try {
				res=i.requestSlot((int)session.getAttribute("cid"),(String)request.getParameter("destination"), df.parse((String)request.getParameter("date")));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}  catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			RequestDispatcher rd = request.getRequestDispatcher("validschedule.jsp");
			if (res.equals("-1")) {
				request.setAttribute("availableschdl", "0");
				
			} else {
				
				request.setAttribute("availableschdl", res);
			}
			rd.include(request, response);
	}

}
