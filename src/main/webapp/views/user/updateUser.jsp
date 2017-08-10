<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>update User</title>
</head>
<body>
	<form action="/updateUser/${users.id}" method="post">
		<span style="color: red">${userNameExeption}</span>
	<input name="name" value="${users.name}">
	<br>
		<span style="color: red">${userEmailExeption}</span>
	<input type="email" name="email" value="${users.email}">
		<br>
		<span style="color: red">${userPasswordExeption}</span>
		<input type="password" name="password" value="${users.password}">
		<br>
		<span style="color: red">${userSexdExeption}</span>
		<input name="sex" value="${users.sex}">
		<br>
		<br>
	<button>update user</button>
	</form>
</body>
</html>