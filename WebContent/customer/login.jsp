<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<form method="post" action='CustomerLogin' >
<h2 align=center>Login page</h2>
<table>
<tr><td><label>phone</label></td><td>
<input type="number" name="contact" required/>
</td>
</tr>
<tr>
<td>
<label>password:</label></td>
</td>
<td>
<input type="password" name="password" id="password"   required/>
</td>
</tr>
<tr><td><input type="submit" value="login" /></td><td><button  onclick='window.location.href = "register.jsp"' >Register</button></td></tr>
</table>

</form>
<% 
if(request.getAttribute("status")!=null)
	out.print("INVALID USERNAME OR PASSWORD");%>
</body>
</html>