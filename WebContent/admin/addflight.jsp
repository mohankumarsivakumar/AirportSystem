<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Flight</title>
<style>
#r {
	margin: 0;
	position: absolute;
	top: 50%;
	left: 50%;
	margin-right: -50%;
	transform: translate(-50%, -50%)
}

</style>
</head>
<body id="r">
<jsp:include page="../bootstrp.jsp"></jsp:include>
<h2 align=center>Add Flight</h2>
</br>
<form method=post action=AddFlight class="form-control">
<table class="table"><tr ><td style="border-top:0" >
<label>Number</label></td><td style="border-top:0" >
<input type=text name="flno" required/><br></td></tr><tr><td style="border-top:0" >
<label>Airline Name</label></td><td style="border-top:0" >
<input type=text name="airline" required/><br></td></tr><tr><td style="border-top:0" >
<label>Starting Place</label></td><td style="border-top:0" >
<input type=text name="startplace" required/><br></td></tr><tr><td style="border-top:0" >
<label>Ending Place</label></td><td style="border-top:0" >
<input type=text name="endplace" required/><br></td></tr><tr><td style="border-top:0" >
<input type=submit value=Add class="btn btn-info"></td></tr></table></form><br>
<c:if test="${flightstatus!=null}">
				<p>
					<c:out value="${flightstatus}" />
				<p>
			</c:if>
</body>
</html>