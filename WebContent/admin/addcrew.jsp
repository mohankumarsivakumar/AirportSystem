<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Crew</title>
<style>
#r {
	margin: 0;
	position: absolute;
	top: 50%;
	left: 50%;
	margin-right: -50%;
	transform: translate(-50%, -50%)
}</style>
</head>
<body id="r"> 
<jsp:include page="../bootstrp.jsp"></jsp:include>
<h2 align=center>Add Crew</h2>
<br>
<form method=post action=AddCrew class="form-control">
<table class="table"><tr><td  style="border-top:0" >
<label>Name</label></td><td  style="border-top:0" >
<input type=text name="name" required/></td></tr><tr><td  style="border-top:0" >
<label>Designation</label></td><td  style="border-top:0" >
<select name="designation" class="dropdown">
<option value="air" class="dropdown-item">Air</option>
<option value="ground" >Ground</option>
<option value="pilot">Pilot</option>
</select></td></tr><tr><td  style="border-top:0" >
<br>
<label>Contact Number</label></td><td  style="border-top:0" >
<input type=text name="contact" required/><br></td></tr><tr><td  style="border-top:0" >
<label>Password</label></td><td  style="border-top:0" >
<input type=password name="password" required/><br></td></tr><tr><td  style="border-top:0" >
<label>Gender</label></td><td  style="border-top:0" >
<select name="gender" class="dropdown">
<option value="male">Male</option>
<option value="female">Female</option>
<option value="others">Others</option>
</select><br></td></tr><tr><td  style="border-top:0" >
<input type=submit value=Add class="btn btn-info"></td></tr></table></form><br>
<c:if test="${crewstatus!=null}">
				<p>
					<c:out value="${crewstatus}" />
				<p>
			</c:if>
</body>
</html>