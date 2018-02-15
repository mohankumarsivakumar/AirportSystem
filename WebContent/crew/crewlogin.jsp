<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>crew login</title>
</head>
<body>
<form method="post" action='CrewLogin' >
<h2 align=center>Crew Login page</h2>
<table>
<tr><td><label>Crewid</label></td><td>
<input type="number" name="cid" required/>
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
<tr><td><input type="submit" value="login" /></td></tr>
</table>
<c:if test="${employeestatus!=null}">  
   <p><c:out value="${employeestatus}"/><p>  
</c:if>  
</form>
</body>
</html>