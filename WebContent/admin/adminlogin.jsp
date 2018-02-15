<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>crew login</title>
<style>
#r {
	margin: 0;
	position: absolute;
	top: 50%;
	left: 50%;
	margin-right: -50%;
	transform: translate(-50%, -50%)
}

.ima {

 background-repeat: no-repeat;
background-size: cover;
}
.labelprop
{
   color:black;
}
</style>
</head>
<body  class="ima" background="../image/plane.jpg">
	<jsp:include page="../bootstrp.jsp"></jsp:include>
	<div class="container" id="r">
		<form method="post" action='AdminLogin' align=center>
			<h2 align=center>Admin Login page</h2><br><br>
			<table class="table-bordered" align=center>
				<tr>
					<td><label class="labelprop" >Admin Id:</label></td>
					<td><input type="number" name="cid" required /></td>
				</tr>
				<tr>
					<td><label>Password:</label></td>
					</td>
					<td><input type="password" name="password" id="password"
						required /></td>
				</tr>
				<tr>
					
				
			</table>
			<br>
			<input type="submit" value="login" class="btn btn-success" />
			<c:if test="${adminstatus!=null}">
				<p style="color:red">
					<c:out value="${adminstatus}" />
				<p>
			</c:if>
		</form>
	</div>
</body>
</html>