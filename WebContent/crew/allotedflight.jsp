<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>allotedflight</title>
</head>
<body>
<form method=post>
<table border=1>
<tr><td><c:out value="scheduleno"></c:out></td><td> <c:out value="flightid"></c:out></td><td> <c:out value="date"></c:out></td>
<td> <c:out value="departuretime"></c:out></td><td> <c:out value="arrivaltime"></c:out></td></tr>
<c:forEach items="${flight}" var="item">
<tr>
 <td> <c:out value="${item.scheduleNo}"></c:out></td>
  <td>  <c:out value="${item.flightNo }"></c:out></td>
    <td><c:out value="${item.date }"></c:out></td>
    <td><c:out value="${item.departureTime }"></c:out></td>
  <td><c:out value="${item.arrivalTime}"></c:out></td>
</tr>
</c:forEach>
</table>
</br></form>
<button  onclick='window.location.href = "crewhomepage.jsp"' >back</button>
</body>
</html>