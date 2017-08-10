<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Country</title>
</head>
<body>
<form action="/updateCountry/${countries.id}" method="post">
	<input name="name" value="${countries.name}">
	<br>
	<br>
	<button > update Country</button>

</form>

</body>
</html>