<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>search flight</title>
</head>
<body>
	<h2 align=center>Search page</h2>
	<form method="get" action="Search">
		<label>source</label><br> <select name=source>
			<option value="ch">ch</option>
			<option value="coimbatore">coimbatore</option>
		</select><br> <label>destination</label> <br> <select
			name=destination>
			<option value="china">china</option>
			<option value="singapore">singapore</option>
			<option value="cbt">cbt</option>
		</select><br> <label>date of journey</label> <input type="date"
			name="date" required><br> <label>type</label> <select
			name="type">
			<option value="e" selected>economy</option>
			<option value="b">business</option>
		</select><br> <label>no of seats</label> <input type="number"
			name="number" required><br> <label>filter</label> <select
			name="filter">
			<option value="flight.flight_no" selected>nofilter</option>
			<option value="flight_schedule.departure" selected>departure
				earlier</option>
			<option value="flight_schedule.departure desc" selected>departure
				later</option>
		</select><br> <input type="submit" value="search" /><br>

	</form>
</body>
</html>