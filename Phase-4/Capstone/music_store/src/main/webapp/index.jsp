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
<title>Homepage</title>
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
.bg-cover {
	min-height: 100vh;
}

.title {
	padding-top: 50px;
	padding-bottom: 50px;
	color: aliceblue;
}

.carousel-inner img {
	width: 100%;
	height: 100%;
}

.carousel
  .carousel-item img {
	height: 400px;
	width: 800px;
	object-fit: cover;
}

.navbar {
	background: #000;
}

.cta {
	padding-top: 50px;
}

.btn {
	border: black;
	background-color: red;
	color: rgb(255, 255, 255);
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
				<li class="nav-item"><a class="nav-link" href="/readuser">Products</a>
				</li>

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

	<div style="background: url(images/backround2.jpg)"
		class="page-holder bg-cover">



		<div align="center" class="title">
			<h2>Welcome to the Music Store!</h2>
			<p>Purchase top albums at the lowest price!</p>

		</div>

		<div id="music" class="carousel slide"
			style="width: 800px; height: 400px; margin: 0 auto"
			data-ride="carousel">

			<!-- Indicators -->
			<ul class="carousel-indicators">
				<li data-target="#music" data-slide-to="0" class="active"></li>
				<li data-target="#music" data-slide-to="1"></li>
				<li data-target="#music" data-slide-to="2"></li>
			</ul>

			<!-- The slideshow -->
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img src="images/concert1.jpg" alt="crt1">
				</div>
				<div class="carousel-item">
					<img src="images/concert2.jpg" alt="crt2">
				</div>
				<div class="carousel-item">
					<img src="images/band.jpg" alt="band">
				</div>
			</div>

			<!-- Left and right controls -->
			<a class="carousel-control-prev" href="#music" data-slide="prev">
				<span class="carousel-control-prev-icon"></span>
			</a> <a class="carousel-control-next" href="#music" data-slide="next">
				<span class="carousel-control-next-icon"></span>
			</a>
		</div>

		<div class=cta align="center">
			<a href='/readuser'><buttontype
					="button" class="btn btn-primary btn-lg">Buy Now!
				</button></a>
		</div>


	</div>








</body>
</html>