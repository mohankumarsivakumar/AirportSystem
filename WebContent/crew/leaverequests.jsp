<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>leave request</title>
</head>
<body>
<h2 align=center >Leave Request page</h2>
<br>
<form method=post action=LeaveRequests>
<label>enter the startdate:</label>
<input type=date name="leavedate" required/><br>
<label>enter the number of days:</label>
<input type=number name="number" required/><br>
<select name="type">
<option value="leave">leave</option>
<option value="compensation">compensation</option>
</select>
<br>
<label>type:</label>
<input type=submit value=submit></form>
</body>
</html>