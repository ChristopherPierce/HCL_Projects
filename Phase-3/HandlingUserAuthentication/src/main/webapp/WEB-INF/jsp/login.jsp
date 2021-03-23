<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
</head>
<body>

<h2>Please enter your email and password.</h2>
<form action="/login" method="POST">
  <p>Email: <input type="text" name="email" id="email"/></p>
  <p>Password: <input type="text" name="password" id="password"/></p>
  <input type="submit" value="Submit">
</form> 

</body>
</html>