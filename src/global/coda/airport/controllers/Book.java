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
 * Servlet implementation class book
 */
@WebServlet("/customer/Book")
public class Book extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Book() {
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
		 HttpSession session=request.getSession(false);   
		 String name[]=new String[9];
		 for(int j=1;j<=(int)session.getAttribute("number");j++) {
			 name[j]=request.getParameter(String.valueOf(j));
		 }
		String contact = (String) session.getAttribute("contact");
		int noofseats=(int) session.getAttribute("number");
		String type=(String) session.getAttribute("type");
		Delegate i=new Delegate();
		float[] a=new float[3];
		try {
			a=i.book(contact,Integer.parseInt(request.getParameter("schedulenumber")),type,noofseats,name);
		} catch (NumberFormatException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(a[0]==-1)
			out.print("your seats are not booked");
		else {
			out.println("booking is over and your pnr is :"+(int)a[0]);
			session.setAttribute("amnt", a[1]);
			out.print("you have to pay an amount of:"+a[1]);
			out.print("<html><body><a href=customerhome.jsp>click here to go home</a></body></html>");
		}
		
	}

}
