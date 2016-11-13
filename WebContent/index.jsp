<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Photos</title>
</head>
<body>
<h3>Photos</h3>
<form action="GetNextPhoto.do" method="POST">
	<button name="navigate" value="back">Back</button>
	<button name="navigate" value="forward">Forward</button>
</form>



<form action="deletePhoto.do" method="GET">
	<button name="index" value="${photo.index}">Remove Image</button>
</form>


<c:choose>
    <c:when test="${! empty photo}">
    
      <img src= "${photo.imgURL}" width="${photo.size}">
      <h3>${photo.index}</h3>
      
       </c:when>
    <c:otherwise>
      <p>No photo found</p>
    </c:otherwise>
  </c:choose>
  
  </form>

<a href="addPhoto.jsp">Add Image</a>

<form action="size.do" method="GET">
	Enter Image Width<br />
	<input type="hidden" name="index" value="${photo.index}">
    <input type="text" name="size"><br>
	
	<input type="submit">
</form>


<form action="updatePhoto.do" method="GET">
	Edit Current Image<br />
	
	<input type="hidden" name="index" value="${photo.index}">
	Enter New URL: <input type="text" name="URL"><br>
	
	<input type="submit">
</form>

</body>


</html>