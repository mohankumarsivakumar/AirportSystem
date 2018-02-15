<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 align=center>Registration page</h2>
<form method="post" action='CustomerRegistration'>
<table>
<tr><td><label>phone</label></td><td>
<input type="number" name="phone" required/>
</td>
</tr>
<tr>
<td>
<label>name:</label></td>
<td>
<input type="text" name="name" required />
</td>
</tr>
<tr>
<td>
<label>gender:</label></td>
</td>
<td>
 <input type="radio" name="gender" value="male" checked> Male<br>
  <input type="radio" name="gender" value="female"> Female<br>
  <input type="radio" name="gender" value="other"> Other  
</td>
</tr>
<tr>
<td>
<label>password:</label></td>
</td>
<td>
<input type="password" name="password" required/>
</td>
</tr>
</table>
<input type="submit" value="Register"/>
</form>
<% 
if(request.getAttribute("stat")!=null)
	out.print("registration is not successfull!!!");%>
</body>
</html>