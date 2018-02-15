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

import global.coda.airport.bean.History;
import global.coda.airport.delegate.Delegate;

/**
 * Servlet implementation class ViewHistory
 */
@WebServlet("/customer/ViewHistory")
public class ViewHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewHistory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		 HttpSession session=request.getSession(false);
		String contact=(String) session.getAttribute("contact");
		Delegate i=new Delegate();
		ArrayList<History> search = new ArrayList<History>();
			try {
				search = i.viewHistory(contact);
			//	out.println(cancel);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			if(search==null) {
				out.println("there is no history available for this account");
				out.println("<a href=customerhome.jsp>home</a>");
				}
			else {
				 request.setAttribute("historyres", search);
					RequestDispatcher rd = request.getRequestDispatcher("historyresult.jsp");
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
