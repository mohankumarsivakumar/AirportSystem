package global.coda.airport.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import global.coda.airport.bean.History;
import global.coda.airport.delegate.Delegate;

/**
 * Servlet implementation class ViewStatus
 */
@WebServlet("/customer/ViewStatus")
public class ViewStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		 Delegate i=new Delegate();
		// out.println(request.getParameter("pnr"));
			History h=new History();
			try {
			h = i.status(Integer.parseInt(request.getParameter("pnr")));
			//	out.println(cancel);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(h==null) {
				out.println("enter valid pnr number");
				out.println("<a href=cancel.jsp>tryagain</a>");
				out.println("<a href=customerhome.jsp>home</a>");
				}
			else {
				 request.setAttribute("statusres", h);
					RequestDispatcher rd = request.getRequestDispatcher("statusresult.jsp");
					rd.forward(request, response);

				}
				out.println("<a href=customerhome.jsp>home</a>");
				}
	}



