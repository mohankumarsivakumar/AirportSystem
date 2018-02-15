<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adding Language</title>
<script type="text/javascript">
function validate(){
	var a=$("input[name='language']:checked").length;
	if(a>=1)
		return true;
	else{
		alert("you have to select atleast one language ");
		return false;
	}
		
}
</script>
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
<h2 align=center>Add Language</h2>
</br>
<form method=post action=AddLanguage class="form-control" onsubmit='return validate()'>
<table class="table"><tr><td style="border-top:0" >
<label>Crew Id</label><br></td><td style="border-top:0" >
<input type=number name="crewid" required/><br></td></tr><tr><td style="border-top:0"  >
<input type="checkbox" name="language" value="tamil" >Tamil</input><br>
<input type="checkbox" name="language" value="english">English</input><br>
<input type="checkbox" name="language" value="hindi">Hindi</input><br>
<input type="checkbox" name="language" value="latin">Latin</input><br>
<input type="checkbox" name="language" value="french">French</input><br>
<input type="checkbox" name="language" value="german">German</input><br>
<input type="checkbox" name="language" value="telugu">Telugu</input><br>
</td></tr><tr><td style="border-top:0" >
<input type=submit value=submit class="btn btn-info"></td></tr></table></form>
<c:if test="${languagestatus!=null}">
				<p>
					<c:out value="${languagestatus}" />
				<p>
			</c:if>
</body>
</html>