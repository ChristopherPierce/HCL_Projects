<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body onload='document.loginForm.username.focus();'>
	<h2>Please login to proceed.</h2>
	<p>For testing purposes, the default login is 'user' and
		'password'.</p>
	<c:if test="${not empty loginError}">
		<div style="color: red; font-weight: bold;">${loginError}</div>
	</c:if>
	<form name='login' action="/login" method='POST'>
		<table>
			<tr>
				<td>Username:</td>
				<td><input type='text' name='username' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="Submit" /></td>
			</tr>
		</table>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<p>
		Click <a href="/index">here</a> to return to the index page.
	</p>
</body>
</html>