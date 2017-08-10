<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/country.css" type="text/css">
</head>
<body>

 
<div class="form" style="text-align: center; margin-top:  5%">

	<form action="/country" method="post">
	 <div class="countryName">
		 <span STYLE="color: red">${countryException}</span>
		<input type="text" name="countryName" placeholder=" Enter Country">
		</div>
		<div class="login">
			 <p><input type="submit" value="Save Country"></p>
			 </div>
			</form>
</div>
<ol>
	<c:forEach var="countryId" items="${countries}">
	<li>${country.name}
		<a href= "/deleteCountry/${countryId.id}">delete </a>
		<a href="/updateCountry/${countryId.id}"> update</a>
	</li>
	</c:forEach>

</ol>
</body>
</html>