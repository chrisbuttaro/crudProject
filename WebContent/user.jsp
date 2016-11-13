<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    <!-- THIS JSP LOADS THE IMAGE LIST FOR USERS THERE IS NO CRUD CONTROL FROM THIS JSP -->
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
    rel="stylesheet">
   <link type="text/css" rel= "stylesheet" href="stylesheet.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Photos</title>
</head>
<body>
<h3>Shruti Arora</h3>



 
      
 <div align=center>
<form action="GetNextUser.do" method="POST">
  	<button name="navigate" value="back" class="btn btn-default btn-circle btn-lg"><i class="glyphicon glyphicon-menu-left"></i></button>
	<img src= "${photo.imgURL}" width="${photo.size}">
	<button name="navigate" value="forward" class="btn btn-default btn-circle btn-lg"><i class="glyphicon glyphicon-menu-right"></i></button>
</form>
</div>

 <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>



</body>


</html>