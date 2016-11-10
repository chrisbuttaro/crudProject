<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Photos</h3>
<form action="GetNextPhoto.do" method="GET">
	<button name="navigate" value="back">Back</button>
	<button name="navigate" value="forward">Forward</button>
</form>

<c:choose>
    <c:when test="${! empty photos}">
        ${photo.imgURL}
       </c:when>
    <c:otherwise>
      <p>No Photo Found</p>
    </c:otherwise>
  </c:choose>
</body>


</html>