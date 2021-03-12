<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = " java.util.* " %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Create a sample login and registration application.</title>
    </head>
    <body>
        <p>Login:</p>
        <form name="login" action="WebApp3" method="POST">
           Username:
           <input type="text" name="login_username">
           <br>
           Password:
           <input type="password" name="login_password">
           <br>
           <input type="submit" name="login_submit" value="Submit" />
        </form>
        <br>
        <p>Register:</p>
        <form name="register" action="WebApp3" method="POST">
           Username:
           <input type="text" name="register_username">
           <br>
           Password:
           <input type="password" name="register_password">
           <br>
           Repeat Password:
           <input type="password" name="register_repeat_password">
           <br>
           <input type="submit" name="register_submit" value="Submit" />
        </form>
    </body>
</html>