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
<jsp:include page="../bootstrp.jsp"></jsp:include>
<h2 align=center>Add Seat</h2>
</br>

<form method=post action=AddSeat class="form-control">
<table class="table"><tr><td style="border-top:0">
<label>Id</label></td><td style="border-top:0">
<input type=number name="flid" required/><br></td></tr><tr><td style="border-top:0">
<label>Type</label></td><td style="border-top:0">
<select name="type">
<option value="e">economy</option>
<option value="b">business</option>
</select></td></tr><tr><td style="border-top:0">
<label>Start Seat</label></td><td style="border-top:0">
<input type=number name="startseat" required/></td></tr><tr><td style="border-top:0">
<label>End Seat</label></td><td style="border-top:0">
<input type=number name="endseat" required/></td></tr><tr><td style="border-top:0">
<input type=submit value=Seat class="btn btn-info"></td></tr></table>
<c:if test="${seatstatus!=null}">
				<p>
					<c:out value="${seatstatus}" />
				<p>
			</c:if>
</body>
</html>