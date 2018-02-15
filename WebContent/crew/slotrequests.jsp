<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SlotRequest</title>
</head>
<body>
<h2 align=center>Request Slot Page</h2>
<label>Enter Destination</label></br>
<form method=post action=SlotRequests>
<input type=text name="destination" required/>
<input type=date name="date" required/>
<input type=submit value=requestSlot></form>
<br><button name="home" onclick="window.location.href='crewhomepage.jsp'">Back</button>
</body>
</html>