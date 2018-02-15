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

import global.coda.airport.bean.Crew;
import global.coda.airport.delegate.Delegate;

/**
 * Servlet implementation class FetchSlotRequest
 */
@WebServlet("/admin/FetchSlotRequest")
public class FetchSlotRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchSlotRequest() {
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
		HttpSession session = request.getSession(false);
		Delegate i = new Delegate();
		int sid=Integer.parseInt(request.getParameter("schedule"));
		session.setAttribute("sid", sid);
		ArrayList<Crew> a = new ArrayList<Crew>();
			a = i.fetchSlotRequest(sid);
		
		if(a.size()==0)
		{
			out.print("Error occurred");
		}
		else
		{
			request.setAttribute("slotreq", a);
			RequestDispatcher rd = request.getRequestDispatcher("fetchslot.jsp");
			rd.forward(request, response);
		}
	
	}

}
