
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Add Photo</title>
</head>
<body>
<form action="addPhoto.do" method="POST" modelAttribute="photo">
	Enter Image URL <input type="text" name="URL"><br/>
	Enter index     <input type="text" name="index"><br/>
	<input type="submit">
</form>
</body>
</html>