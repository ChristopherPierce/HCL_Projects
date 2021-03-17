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
<h2>Changes made to the user have been saved.</h2>
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
<a href="/">Return</a>
</body>
</html>