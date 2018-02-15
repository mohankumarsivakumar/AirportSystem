package global.coda.airport.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import global.coda.airport.bean.ScheduleSearch;
import global.coda.airport.delegate.Delegate;

/**
 * Servlet implementation class Search
 */
@WebServlet("/customer/Search")
public class Search extends HttpServlet {
	DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	response.setContentType("text/html");
		Delegate i=new Delegate();
		ArrayList<ScheduleSearch> res = new ArrayList<ScheduleSearch>();
			try {
				
			res=i.search(request.getParameter("source"), request.getParameter("destination"), df.parse((String)request.getParameter("date")),request.getParameter("type"),Integer.parseInt((String)request.getParameter("number")),request.getParameter("filter"));
			}  catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 HttpSession session=request.getSession(false);  
		        session.setAttribute("number",Integer.parseInt((String)request.getParameter("number")));  
		        try {
					session.setAttribute("date",df.parse((String)request.getParameter("date")));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		       session.setAttribute("source",request.getParameter("source"));
		       session.setAttribute("destination",request.getParameter("destination"));
		      session.setAttribute("type",request.getParameter("type"));
		      session.setAttribute("searchres", res);
			RequestDispatcher rd = request.getRequestDispatcher("searchresult.jsp");
			rd.forward(request, response);
				}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
