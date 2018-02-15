<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FetchSlotRequest</title>
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
	var a=$("input[name='crewid']:checked").length;
	if(a>=1)
		return true;
	else{
		alert("you have to select atleast one crew to be assigned ");
		return false;
	}
		
}
</script>
</head>
<body id="r"> 
<jsp:include page="../bootstrp.jsp"></jsp:include>

	<form method=post action=ApproveSlot class="form-control">
		<table class="table">
<tr><td style="border-top:0"><c:out value="Check"></c:out></td><td style="border-top:0"> <c:out value="Id"></c:out></td><td style="border-top:0"> <c:out value="Name"></c:out></td>
<td style="border-top:0"> <c:out value="Designation"></c:out></td><td style="border-top:0"> <c:out value="Contact"></c:out></td></tr>

			<c:forEach items="${slotreq}" var="item">
				<tr>
					    <td><input type="checkbox" name="crewid" value="${item.crewId }"></td>
						<td><c:out value="${item.crewId}"></c:out></td>
						<td><c:out value="${item.name}"></c:out></td>
						<td><c:out value="${item.designation }"></c:out></td>
						<td><c:out value="${item.contactno }"></c:out></td>
						</input>
				</tr>
		
		</c:forEach>
		<tr><td style="border-top:0"><input type="button" onclick='window.location.href = "viewslotrequest.jsp"' class="btn btn-light" value="Back">
		</td><td style="border-top:0"><input type="submit" value="Allot" class="btn btn-info" onclick="return validate()" /> 
		</td></tr></table>
	</form>
	
</body>
</html>