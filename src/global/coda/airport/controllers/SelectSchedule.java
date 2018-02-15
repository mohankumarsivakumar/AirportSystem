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
 * Servlet implementation class SelectSchedule
 */
@WebServlet("/crew/SelectSchedule")
public class SelectSchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectSchedule() {
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
		 HttpSession session=request.getSession(false);  
		int res=0;
		
				
			try {
				res=i.selectSlot((int)session.getAttribute("cid"),Integer.parseInt((String)request.getParameter("scheduleno")));
			} 
		catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			if (res==1) {
				out.println("selected");
				
				
			} else {
				
				out.println("not selected");
			}
			out.println("<a href=crewhomepage.jsp>Home</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	// TODO Auto-generated method stub
		
	}

}
