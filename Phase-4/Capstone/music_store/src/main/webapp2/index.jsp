<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<title>Search Our Products</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  
<style>

      
    
    .title
    {
        padding-top: 50px;
      padding-bottom: 50px;
      
      
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
    
</style>
</head>
<body>
  <header>
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
      <!-- Brand -->
      <a class="navbar-brand" href="#">
        <img src="images/whiteGuitar.jpg" alt="Logo" style="width:60px;">
      </a>
    
      <!-- Links -->
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="/">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/readuser">Products</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="">About</a>
          </li>
       </ul>
       <ul class="navbar-nav ml-auto">
        <li class="nav-item">
          <a class="nav-link" href="/login">Login</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="">Register</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="">Your Cart</a>
        </li>
       </ul>
    </nav>
  </header>
  <div align="center" class="title">
    <h2>Welcome to the Music Store!</h2>
    <p>Purchase top albums at the lowest price!</p>
       
  </div>

  <div id="music" class="carousel slide" style="width: 800px; height:400px;margin: 0 auto" data-ride="carousel">

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
    </a>
    <a class="carousel-control-next" href="#music" data-slide="next">
      <span class="carousel-control-next-icon"></span>
    </a>
  </div>

   
   
   
   
  


  
  
    
</body>
</html>