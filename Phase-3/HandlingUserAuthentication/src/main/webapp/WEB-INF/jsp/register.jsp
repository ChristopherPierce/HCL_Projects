<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
</head>
<body>

<h2>Please register your email and password.</h2>
<form action="/register" method="POST">
  <p>Email: <input type="text" name="email" id="email"/></p>
  <p>Password: <input type="text" name="password" id="password"/></p>
  <p>Confirm Password: <input type="text" name="confirm_password" id="confirm_password"/></p>
  <input type="submit" value="Submit">
</form> 

</body>
</html>