package global.coda.airport.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import global.coda.airport.delegate.Delegate;

/**
 * Servlet implementation class Compensation
 */
@WebServlet("/crew/Compensation")
public class Compensation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DateFormat df=new SimpleDateFormat("yyyy-MM-dd");   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Compensation() {
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
		int res=0;
		HttpSession session = request.getSession(false);
		Delegate i=new Delegate();
		Date dat[]=new Date[100];
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		for(int temp=0;temp<Integer.parseInt((String)session.getAttribute("count"));temp++) {
			try {
				dat[temp]=df.parse(request.getParameter(String.valueOf(temp)));
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//out.print(df.format(dat[temp]));
		}
		try {
			try {
				res = i.compensation((int) session.getAttribute("cid"),Integer.parseInt((String)session.getAttribute("count")),(Date)session.getAttribute("startdate"),dat);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (res==1) {
			out.println("your request has been recorded");
			
			
		} else {
			
			out.println("no your request has not been recorded");
		}
		out.println("<a href=crewhomepage.jsp>Home</a>");

	}

}
