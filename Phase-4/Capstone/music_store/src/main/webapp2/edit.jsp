<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Form</title>
</head>
<body>
 <div align="center">
<h2>Edit Album</h2>
<h3>Please fill in the information</h3>
<form:form method="post" action="/update" modelAttribute = "album">
  <form:hidden path="id"/>
    <form:label path="name">Album Name</form:label><br>
  <form:input path="name" required="required"/><br>
  <h6> </h6>
  <form:label path="artist">Artist</form:label><br>
  <form:input path="artist" required="required"/><br>
   <h6> </h6>
   <form:label path="price">Price</form:label><br>
  <form:input type="number" min=".01" step=".01" path="price" required="required"/><br>
   <h6> </h6>
   <form:label path="release_date">Release Date</form:label><br>
  <form:input type = "date" path="release_date" required="required"/><br>
   <h6> </h6>
   <form:label path="genre_name">Genre Name</form:label><br>
   <form:input path="genre_name" required="required"/><br>
   <h6> </h6>
   
   <h6> </h6>
 <input type="submit" value="Submit">
 </form:form>
<h6> </h6>
 <form action="/readadmin" method="get">
    
  <h6> </h6>
 

      <input type="submit" value="Cancel"/>
    
</form>


</div>
</body>
</html>