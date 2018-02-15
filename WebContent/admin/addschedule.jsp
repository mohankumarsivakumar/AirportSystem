<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
<h2 align=center>Add Schedule</h2>
</br>
<jsp:include page="../bootstrp.jsp"></jsp:include>
<form method=post action=AddSchedule class="form-control">
<table class="table"><tr><td style="border-top:0">
<label>Id</label></td><td style="border-top:0">
<input type=number name="flid" required/><br></td></tr><tr><td style="border-top:0">
<label>Date</label></td><td style="border-top:0">
<input type=date name="journeydate" required/><br></td></tr><tr><td style="border-top:0">
<label>Departure Time</label></td><td style="border-top:0">
<input type=time name="departuretime" required/><br></td></tr><tr><td style="border-top:0">
<label>Arrival Time</label></td><td style="border-top:0">
<input type=time name="arrivaltime"  required/><br></td></tr><tr><td style="border-top:0">
<label>Economy Seats</label></td><td style="border-top:0">
<input type=number name="ecseats" required/><br></td></tr><tr><td style="border-top:0">
<label>Economy Cost</label></td><td style="border-top:0">
<input type=number name="eccost" required/><br></td></tr><tr><td style="border-top:0">
<label>Business Seats</label></td><td style="border-top:0">
<input type=number name="bsseats" required/><br></td></tr><tr><td style="border-top:0">
<label>Business Cost</label></td><td style="border-top:0">
<input type=number name="bscost" required/><br></td></tr><tr><td style="border-top:0">
<input type=submit value=Schedule class="btn btn-info">
</td></tr></table>
</form><br>
<c:if test="${schedulestatus!=null}">
				<p>
					<c:out value="${schedulestatus}" />
				<p>
			</c:if>
</body>
</html>