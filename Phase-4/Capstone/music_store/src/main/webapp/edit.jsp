<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  
<title>Edit Form</title>
<style>
  .bg-cover{
    min-height: 110vh;
  }

  .title
  {
      padding-top: 50px;
    padding-bottom: 50px;
    color: white;
    
  }

</style>
</head>
<body>
  <div style="background: url(images/backround2.jpg)" class="page-holder bg-cover">
 <div align="center" class=title>
<h2>Edit Album</h2>
<h3>Please fill in the information</h3>
<p>Note: Information is pre-filled with the existing album info</p>
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
</div>
</body>
</html>