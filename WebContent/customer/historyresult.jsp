<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
<form method=post action=customerhome.jsp>
<table border=1>
<tr><td><c:out value="pnr"></c:out></td><td> <c:out value="customerid"></c:out></td><td> <c:out value="scheduleno"></c:out></td>
<td> <c:out value="flightclass"></c:out></td><td> <c:out value="noofseats"></c:out></td><td> <c:out value="status"></c:out></td><td> <c:out value="fare"></c:out></td></tr>
<c:forEach items="${historyres}" var="item">
<tr>
 <td> <c:out value="${item.pnr}"></c:out></td>
  <td>  <c:out value="${item.customer_id }"></c:out></td>
    <td><c:out value="${item.flight_schedule_no }"></c:out></td>
    <td><c:out value="${item.flight_class }"></c:out></td>
  <td><c:out value="${item.no_of_seats }"></c:out></td>
   <td><c:out value="${item.status}"></c:out></td>
    <td><c:out value="${item.price}"></c:out></td>
</tr>
</c:forEach>
</table>
</br></form>
<button  onclick='window.location.href = "customerhome.jsp"' >back</button>
</body>
</html>