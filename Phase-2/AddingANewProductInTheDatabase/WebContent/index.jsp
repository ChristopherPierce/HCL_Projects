<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = " java.util.* " %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Adding a New Product in the Database.</title>
    </head>
    <body>
        <p>Use this tool to add a new product to the database!</p>
        <form name="product_details_form" action="WebApp2" method="POST">
           Product Name:
           <input type="text" name="product_name">
           <br>
           Product Price:
           <input type="text" name="product_price">
           <br>
           Product Description:
           <input type="text" name="product_desc">
           <br>
           <input type="submit" value="Submit" />
        </form>
    </body>
</html>