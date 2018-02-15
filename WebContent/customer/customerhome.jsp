<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>customer home page</title>
<c:if test="${contact!=null}"> 
<h2 align=center>customer home </h2>
<a href=search.jsp>search</a>
<a href=book.jsp>book</a>
<a href=cancel.jsp>cancel</a>
<a href=checkin.jsp>checkin</a>
<a href=viewstatus.jsp>viewstatus</a>
<a href=ViewHistory>viewhistory</a>
<a href=Logout>logout</a>
</c:if>
</head>
<body>

</body>
</html>