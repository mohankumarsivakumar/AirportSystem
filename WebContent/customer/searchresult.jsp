<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fetch Leave</title>
</head>
<body>
<form method=post action=book.jsp>
<table border=1>
<tr><td><c:out value="scheduleno"></c:out></td><td> <c:out value="airline"></c:out></td><td> <c:out value="boardingplace"></c:out></td>
<td> <c:out value="destinationplace"></c:out></td><td> <c:out value="date"></c:out></td><td> <c:out value="departuretime"></c:out></td><td> <c:out value="fare"></c:out></td>
<td> <c:out value="seats"></c:out></td></tr>
<c:forEach items="${searchres}" var="item">
<tr>
 <td> <c:out value="${item.flight_schedule_no}"></c:out></td>
  <td>  <c:out value="${item.airline }"></c:out></td>
    <td><c:out value="${item.boarding_place }"></c:out></td>
    <td><c:out value="${item.destination }"></c:out></td>
  <td><c:out value="${item.date }"></c:out></td>
   <td><c:out value="${item.departure}"></c:out></td>
    <td><c:out value="${item.fare}"></c:out></td>
     <td><c:out value="${item.seats}"></c:out></td>
</tr>

</c:forEach>
</table>
</br><input type="submit" value="book"/>
</br></form>
<button  onclick='window.location.href = "customerhome.jsp"' >back</button>
</body>
</html>