<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Slot</title>
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
<h2 align=center>Slot Requests</h2>

<form method=post action=FetchSlotRequest class="form-control">
<table class="table"><tr><td style="border-top:0"><label>Enter Schedule number:</label></br></td><td style="border-top:0">
<input type=number name="schedule" required/></td></tr><tr><td style="border-top:0">
<input type=submit value=Allot  class="btn btn-info">
</td></tr></table></form>
</body>
</html>