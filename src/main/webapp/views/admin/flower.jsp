<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/flower.css" type="text/css">
</head>
<body>

<div class="login" >
    <div class="login-triangle"></div>
    <h3 class="login-header">Add Flowers</h3>
  <form class="login-container" action="/flower" method="post">

        <span style="color: red">${flowerNameExeption}</span>
      <input type="text" name= "flowerName" placeholder= "Enter flower" >
    <br>
        <span style="color: red">${flowerColorExeption}</span>
     <input type="text" name= "flowerColor" placeholder= "Enter color">
   <br>
        <span style="color: red">${flowerPriceException}</span>
      <input type="text" name= "flowerPrice" placeholder= "Enter price">
   <br>
     <select name="countryId" style="text-align: center">
			<c:forEach var="countryId" items="${countries}">
			<option value="${countryId.id}">${countryId.name}</option>
			</c:forEach>
		</select>

      <br>
      <br>
      <input type="submit" value="Save Flower"></input>

  </form>
</div>
<div class="countryTabel">
<ol>
<c:forEach var="f" items="${flowers}">
   <li> ${f.name} ${f.color} ${f.price} 
   <c:forEach var="coun" items="${f.countrys}">${coun.name}
   </c:forEach>
       <a href="/deleteFlower/${f.id}">delete</a>
       <a href="/updateFlower/${f.id}"> update </a>
   </li>
</c:forEach>
</ol>
</div>
</body>
</html>