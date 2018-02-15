<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>seat selection</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
function validate(count){
	var a=$("input[name='seats']:checked").length;
	if(a==count)
		return true;
	else{
		alert("you have to select"+count+" seats ");
		return false;
	}
		
}
</script>
</head>
<body>
<form action="Checked" method="post" >
<%
HttpSession session2=request.getSession(false);
ArrayList ab=(ArrayList)session2.getAttribute("array");
int count=(int)request.getAttribute("max");
for(int i=0;i<(int)session2.getAttribute("arraysize");i++){
	out.println("<input type='checkbox' name='seats' id='"+ab.get(i)+"' value='"+ab.get(i)+"'> "+ab.get(i)+"<br>");}
out.println("<input type=submit value=board onclick='return validate("+ count +")' />");
%>

</form>
</body>
</html>