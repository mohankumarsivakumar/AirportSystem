<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="Book">
<h1 align=center >Booking page</h1>
<p><%out.println("contactnumber:"+session.getAttribute("contact")); %></p>
<p><%out.println("type:"+session.getAttribute("type")); %></p>
<p><%out.println("noofseats:"+session.getAttribute("number")); %></p>
<label>schedule number</label>
<input type="number" name="schedulenumber" required/><br>
<%for(int i=1;i<=(int)session.getAttribute("number");i++){
out.println("<label>passenger name"+i+":</label><input type=text name="+i+" required/><br>");
//out.println(session.getAttribute("noofseats"));
}
	%>

<input type="submit" value="book&pay" /><br>
</form>
</body>
</html>