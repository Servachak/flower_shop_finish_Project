<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>update flower</title>
</head>
<body>
<form action="/updateFlower/${flowers.id}" method="post">
	<input name="flowerName" value="${flowers.name}">
	<br>
	<input name="flowerColor" value="${flowers.color}">
	<br>
	<input name="flowerPrice" value="${flowers.price}">
	<br>
	<br>
	<button>update flower</button>
	




</form>

</body>
</html>