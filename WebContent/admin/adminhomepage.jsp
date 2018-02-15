<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
#left{
position:relative;
float:left;
height:650px;
width:15%;
background-color: #17a2b8;
border-color: #17a2b8;
}
#point{
list-style-type:none;
}
#backcolor{
color:black;
}
.frameprop{
border:2px;
}
.back{
width:100%; 
border: 2px solid black;
}
.pos{
position:relative;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
    $("a").click(function(){
      var id=$(this).attr('id');
      $("a").css('color','#fff');
      $("a").css('background-color','#17a2b8');
      $("a").css('border-color','#17a2b8');
      $("#" + this.id).css('background-color','#138496');
      $("#" + this.id).css(' border-color','#117a8b');
    });
});
</script>
<title>AdminHome</title>
</head>
<body > 
<jsp:include page="../bootstrp.jsp"></jsp:include>
<c:if test="${aid!=null}"> 
<nav class="navbar navbar-default" style="background-color:#696969">
  <div class="container-fluid"  >
    <div class="navbar-header" style="color: white">
      Admin DashBoard<img alt="hi" src="../image/logo.png" height=30px width=30px />
    </div>
    <ul class="nav navbar-nav">
      <li>  <a href='AdminLogout' class="btn btn-info back" role="button" id="logout">Logout</a></li>
    </ul>
  </div>
</nav>
  <div id="left">
    <ul>
      <li id=backcolor>Flight</li>
      <li id=point>
       <a href='addflight.jsp'  class="btn btn-info back" role="button" id="newflight" target="iframe_a">Add</a>
      </li>
      <li id=point>
        <a href='addschedule.jsp' class="btn btn-info back" role="button" id="schedule" target="iframe_a">Schedule</a>
      </li>
      <li id=point>
       <a href='addseat.jsp' class="btn btn-info back" role="button" id="addseat" target="iframe_a">Add Seat</a>
      </li>
      <li id=backcolor>Crew</li>
      <li id=point>
        <a href='addcrew.jsp' class="btn btn-info back" role="button" id="addcrew" target="iframe_a">Add</a>
      </li>
       <li id=point>
        <a href='addlanguage.jsp' class="btn btn-info back" role="button" id="addlanguage" target="iframe_a">Language</a>
      </li>
       <li id=point>
        <a href='FetchLeave' class="btn btn-info back" role="button" id="fetchleave" target="iframe_a">Leave Requests</a>
      </li>
       <li id=point>
       <a href='viewslotrequest.jsp' class="btn btn-info back" role="button" id="slotrequest" target="iframe_a">Slot Requests</a>
      </li>
    </ul>
  </div>
  <div class="pos">
<iframe src="addflight.jsp" name="iframe_a" width="85%" height="650px" align="right">
<p>Your browser does not support iframes.</p>
</iframe>
</div>
</c:if>
</body>
</html>