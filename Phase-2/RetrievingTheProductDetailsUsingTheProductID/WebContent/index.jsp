<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = " java.util.* " %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Retrieving the Product Details Using the Product ID.</title>
    </head>
    <body>
        <p>Use this tool to get a product's details by entering the product's ID in the form below!</p>
        <form name="product_id_form" action="WebApp" method="POST">
           Product ID:
           <input type="text" name="product_id">
           <input type="submit" value="Submit" />
        </form>
        <p>Product Details:</p>
        <textarea name="product_details" rows="10" cols="80" readonly><% 
		String productDetails = (String) request.getAttribute("productDetails");
		if(productDetails==null) productDetails = "";
		out.print(productDetails);
		%></textarea>
    </body>
</html>