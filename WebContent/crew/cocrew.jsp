<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Co Crew</title>
</head>
<body>
<form method=post>
<table border=1>
<tr><td><c:out value="id"></c:out></td><td> <c:out value="crewname"></c:out></td><td> <c:out value="designation"></c:out></td>
<td> <c:out value="conatctno"></c:out></td><td> <c:out value="password"></c:out></td><td> <c:out value="gender"></c:out></td>
<td> <c:out value="leavecount"></c:out></td><td> <c:out value="languages"></c:out></td></tr>
<c:forEach items="${cocrews}" var="item">
<tr>
<td> <c:out value="${item.id}"></c:out></td>
  <td>  <c:out value="${item.crew_name }"></c:out></td>
    <td><c:out value="${item.designation }"></c:out></td>
    <td><c:out value="${item.contact_no }"></c:out></td>
  <td><c:out value="${item.password }"></c:out></td>
   <td><c:out value="${item.gender}"></c:out></td>
    <td><c:out value="${item.leave_count}"></c:out></td>
     <td><c:out value="${item.language}"></c:out></td>
</tr>
</c:forEach>
</table>
</br></form>
<button  onclick='window.location.href = "crewhomepage.jsp"' >back</button>
</body>
</html>