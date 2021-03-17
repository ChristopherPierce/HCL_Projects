<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
</head>
<body>
	<h2>Welcome, enter a user's ID to look them up.</h2>
	<form:form action="/lookup" modelAttribute="user" method="POST">
		<p>User ID: <form:input path="id" /></p>
		<input type="submit" value="Submit">
	</form:form>
</body>
</html>