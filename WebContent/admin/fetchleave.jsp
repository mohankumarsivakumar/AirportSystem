<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Leave Requests</title>
<style>
#r {
	margin: 0;
	position: absolute;
	top: 50%;
	left: 50%;
	margin-right: -50%;
	transform: translate(-50%, -50%)
}</style>
<script type="text/javascript">
function validate(){
	var a=$("input[name='leaveno']:checked").length;
	if(a>=1)
		return true;
	else{
		alert("you have to select atleast one leave request to grant ");
		return false;
	}
		
}
</script>
</head>
<body id="r"> 
<jsp:include page="../bootstrp.jsp"></jsp:include>
<h2 align=center>Leave Requests</h2>
<form method=post action=ApproveLeave class="form-control">
<table class="table">
<tr><td style="border-top:0" ><c:out value="Check"></c:out></td><td style="border-top:0" > <c:out value="Number"></c:out></td><td style="border-top:0" > <c:out value="Id"></c:out></td>
<td style="border-top:0" > <c:out value="Days"></c:out></td><td style="border-top:0" > <c:out value="Start Date"></c:out></td></tr>
<c:forEach items="${leavereq}" var="item">
<tr>
<td><input type="checkbox" name="leaveno" value="${item.leaveno }" /></td>
 <td> <c:out value="${item.leaveno }"></c:out></td>
  <td>  <c:out value="${item.crewid }"></c:out></td>
    <td><c:out value="${item.noofdays }"></c:out></td>
    <td><c:out value="${item.leavedate }"></c:out></td>
</tr>
</c:forEach>
	<tr><td style="border-top:0" ><input type="submit" value="Permit" class="btn btn-info" onclick="return validate()" /> 
		</td></tr></table>
	</form>
</body>
</body>
</html>
