<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    <!-- THIS JSP IS FOR THE ADMIN ONLY IT ENABLES CRUD FUNCTIONALITY -->
    
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



 
        <!-- FORWARD AND BACKWARD WITH THE IMAGE IN THE MIDDLE-->
 <div align=center>
<form action="GetNextPhoto.do" method="POST"> 

  	<button name="navigate" value="back" class="btn btn-default btn-circle btn-lg"><i class="glyphicon glyphicon-menu-left"></i></button>
	<img src= "${photo.imgURL}" width="${photo.size}">
	<button name="navigate" value="forward" class="btn btn-default btn-circle btn-lg"><i class="glyphicon glyphicon-menu-right"></i></button>
	
</form>
</div>

<!-- DISPLAYS PHOTO INDEX-->
<c:choose>
    <c:when test="${! empty photo}">
    
     
      <h3>${photo.index}</h3>
      
       </c:when>
    <c:otherwise>
      <p>No photo found</p>
    </c:otherwise>
  </c:choose>
  
  </form>
  
  <!-- TAKES IN INFO TO CHANGE IMG SRC WIDTH-->
  
 <form action="size.do" method="GET">
  <div class="form-group" >
    <label for="formGroupExampleInput">Enter Image Width</label>
    <input type="hidden" name="index" value="${photo.index}">
    <input type="text" name="size" class="form-control" id="formGroupExampleInput"><br>
    <button type="submit" class="btn btn-primary">Submit</button>
  </div>
</form>

 <!-- TAKES IN A URL TO REPLACE THE IMG DISPLAYED ON THE SCREEN-->
<form action="updatePhoto.do" method="GET">
  <div class="form-group" >
    <label for="formGroupExampleInput">Enter URL to Replace Current Image</label>
    <input type="hidden" name="index" value="${photo.index}">
	<input type="text" name="URL" class="form-control" id="formGroupExampleInput"><br>
    <button type="submit" class="btn btn-primary">Submit</button>
  </div>
</form>


 <!-- TAKES AN INDEX AND AN IMG SRC TO INSERT A PHOTO INTO THE LIST-->
<a href="addPhoto.jsp">Add Image</a>
<form action="deletePhoto.do" method="GET">
<button type="submit" class="btn btn-primary" name="index" value="${photo.index}">Remove Image</button>
</form>



 <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>



</body>


</html>