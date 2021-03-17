<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<style>
table, th, td {
  border: 1px solid black;
}
</style>
</head>
<body>
<h2>User found.</h2>
<div>
	<table>
	  <tr><th>ID</th><th>Name</th><th>Email</th><th>Password</th></tr>
	  <tr>
	    <td>${user.getId()}</td>
	    <td>${user.getName()}</td>
	    <td>${user.getEmail()}</td>
	    <td>${user.getPassword()}</td>
	  </tr>
	</table>
</div><br>

<h4>Update User Details:</h4>
<form:form action="/update" modelAttribute="user" commandName="user" method="POST">
  <p>User's ID: <form:input path="id" readonly="true"/></p>
  <p>User's Name: <form:input path="name"/></p>
  <p>User's Email: <form:input path="email"/></p>
  <p>User's Password: <form:input path="password"/></p>
  <input type="submit" value="Submit">
</form:form> 

</body>
</html>