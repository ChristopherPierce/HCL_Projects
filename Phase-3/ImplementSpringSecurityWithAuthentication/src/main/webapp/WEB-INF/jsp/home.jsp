<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<h2>Greetings, user! Welcome to the home page.</h2>
	<p>
		Click <a href="/index">here</a> to return to the index page.
	</p>
	<p>
		Or click the button on the right to logout:
		<button onclick="document.location='/logout'">Log Out</button>
	</p>
</body>
</html>