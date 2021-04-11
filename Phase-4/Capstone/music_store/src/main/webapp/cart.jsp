<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Cart</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<style>
   .bg-cover{
      min-height: 200vh;
    }

table, th, td {
  border: 1px solid black;
}
     .container-fluid
    {
      
      border-top:1px solid rgb(0, 0, 0);
      border-bottom:1px solid rgb(0, 0, 0);
     width: 1200px;
     background-color: rgb(185, 185, 185);
      
    }
   
      .col
    {
      padding-top: 20px;
      padding-bottom: 20px;
      border-left:1px solid rgb(0, 0, 0) ;
      border-right:1px solid rgb(0, 0, 0) ;
      
    }
    .table
    {
        
      padding-bottom: 50px;
      
      
    }
    .title
    {
        padding-top: 50px;
      padding-bottom: 50px;
      color: white;
      
    }
    .navbar{
  background: #000;
}
</style>
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-sm navbar-dark">
			<!-- Brand -->
			<a class="navbar-brand" href="#"> <img
				src="images/whiteGuitar.jpg" alt="Logo" style="width: 60px;">
			</a>

			<!-- Links -->
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="/">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="/readuser">Products</a></li>
			</ul>
			<ul class="navbar-nav ml-auto">
				<security:authorize access="isAuthenticated()">
					<li class="nav-item"><a class="nav-link" href="#">
						User: <b><security:authentication property="principal.username" /></b>	
					</a></li>
					<li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
					<li class="nav-item"><a class="nav-link" href="/cart">Your Cart</a></li>
					<li class="nav-item">
					   <a class="nav-link dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></a>
					   <div class="dropdown-menu" aria-labelledby="dropdownMenuLink" style="
					      right: 0;
					      width: 40%;
					      float: right;
					      margin-left: auto;
					      z-index: 999;
					      background-color: #343a40;
					      ">
					      <span style="
					         margin-left: 10px;
					         font-weight: bolder;
					         color: white;
					         ">Items in Cart:</span>            
					      <table class="table table-striped table-dark" style="
					         margin-top: 10px;
					         ">
					         <thead>
					            <tr>
					               <th scope="col">Album</th>
					               <th scope="col">Artist</th>
					               <th scope="col">Price</th>
					            </tr>
					         </thead>
					         <tbody>
					           <c:forEach items="${cart}" var="cart"> 
					             <tr>
					                <td>${cart.name}</td>
					                <td>${cart.artist}</td>
					                <th scope="row">${cart.price}</th>
					             </tr>
					           </c:forEach>
					         </tbody>
					      </table>
					   </div>
					</li>
				</security:authorize>
				<security:authorize access="!isAuthenticated()">
					<li class="nav-item"><a class="nav-link" href="/login">Login</a></li>
					<li class="nav-item"><a class="nav-link" href="/register">Register</a></li>
				</security:authorize>
			</ul>
		</nav>
	</header>




  <div style="background: url(images/backround2.jpg)" class="page-holder bg-cover">



	<div align="center" class="title">
		<h2>Items in Your Cart:</h2>
	</div>




	<div class="table">
		<div class="container-fluid" align="center">
			<div class="row">
				<div class="col">
					<h5>Picture</h5>
				</div>
				<div class="col">
					<h5>Album ID</h5>
				</div>
				<div class="col">
					<h5>Name</h5>
				</div>
				<div class="col">
					<h5>Artist</h5>
				</div>
				<div class="col">
					<h5>Release Date</h5>
				</div>
				<div class="col">
					<h5>Genre</h5>
				</div>
				<div class="col">
					<h5>Price</h5>
				</div>
				<div class="col">
					<h5>Edit Cart</h5>
				</div>
			</div>
		</div>

		<c:forEach items="${albums}" var="album">
			<div class="container-fluid" align="center">
				<div class="row">
					<div class="col">
						<img src="images/album.jpg" alt="album" width="100" height="100">
					</div>
					<div class="col">${album.id}</div>
					<div class="col">${album.name}</div>
					<div class="col">${album.artist}</div>
					<div class="col">${album.release_date}</div>
					<div class="col">${album.genre_name}</div>
					<div name="price" class="col">${album.price}</div>
					<div class="col">
						<form action="/removeFromCart" method="post">
							<input type="hidden" id="id" name="id" value="${album.id}">
							<input class="btn btn-primary btn-lg" type="submit" value="Remove" />
						</form>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	<div align="center" class="title">
		<h2 id="subtotal">Subtotal: %SUBTOTAL%</h2>
		<br> <a href="/checkout"> <input type="submit"
			value="Proceed to Checkout" />
		</a>

	</div>
	<script>
	var subtotal = 0;
	$("[name='price']").each(function() {
		subtotal += parseFloat(this.innerHTML);
	});
	$("#subtotal").html($("#subtotal").html().replace("%SUBTOTAL%", "$"+subtotal));
	</script>

</div>

</body>
</html>