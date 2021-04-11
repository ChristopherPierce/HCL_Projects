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
table, th, td {
  border: 1px solid black;
}
     .container-fluid
    {
      
      border-top:1px solid rgb(0, 0, 0);
      border-bottom:1px solid rgb(0, 0, 0);
     width: 1200px;
      
      
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
        <h2>Our Available Albums</h2>
        <p>Please use the search bars if you want to find something specific</p>
        <a href="/readuser">
          <input type="submit" value="Display All"/>
         </a><br>   
      </div>
   
    <div class="container-fluid" align="center">
        <div class="row">
          
          <div class="col">
              
            
    <form action="/search" method="post">
      
        <label for="value">Search by Album</label><br /><input type="text" id="value" name="value" required/>
        <input type="hidden" id="column" name="column" value="name">
  
  <input type="submit" value="Search" />
</form>
          </div>
          <div class="col">
              
            
            <form action="/search" method="post">
              
                <label for="value">Search by Artist</label><br /><input type="text" id="value" name="value" required/>
                <input type="hidden" id="column" name="column" value="artist">
                
                
          
          <input type="submit" value="Search" />
        </form>
    </div>
          <div class="col">
              
           
            <form action="/search" method="post">
              
                <label for="value">Search by Genre</label><br /><input type="text" id="value" name="value" required/>
                <input type="hidden" id="column" name="column" value="genre_name">
          
          <input type="submit" value="Search" />
        </form>
    </div>
        </div>
      </div>
 

    


</div>
<div class="table">
<div class="container-fluid" align="center">
  <div class="row">
    <div class="col"><h5>Picture</h5></div>
    <div class="col"><h5>Album ID</h5></div>
    <div class="col"><h5>Name</h5></div>
    <div class="col"><h5>Artist</h5></div>
    <div class="col"><h5>Price</h5></div>
    <div class="col"><h5>Release Date</h5></div>
    <div class="col"><h5>Genre</h5></div>
    <div class="col"><h5>Buy Now</h5></div>
  </div>
</div>

<c:forEach items="${albums}" var="albums"> 
<div class="container-fluid" align="center">
  <div class="row">
    <div class="col">
      <img src="images/album.jpg" alt="album" width="100" height="100">
    </div>
    <div class="col">${albums.id}</div>
    <div class="col">${albums.name}</div>
    <div class="col">${albums.artist}</div>
    <div class="col">${albums.price}</div>
    <div class="col">${albums.release_date}</div>
    <div class="col">${albums.genre_name}</div>
    <div class="col">
      <a href="">
        <input type="submit" value="Add to Cart"/>
       </a><br>
       
    </div>
  
  </div>
</div>
</c:forEach>
</div>
  
    
</body>
</html>