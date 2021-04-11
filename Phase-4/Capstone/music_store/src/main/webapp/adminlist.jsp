<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Admin</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  
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
    border-left:1px solid rgb(0, 0, 0) ;
    border-right:1px solid rgb(0, 0, 0) ;
    background-color: rgb(185, 185, 185);
  }
  
    .col
  {
    padding-top: 30px;
    padding-bottom: 30px;
    border-left:1px solid rgb(0, 0, 0) ;
    border-right:1px solid rgb(0, 0, 0) ;
    
  }
  .table
  {
    padding-bottom: 50px;
    
    
  }
  .addform
  {
    padding-top: 30px;
    padding-bottom: 30px; 
    color:white  
  }

  .title
    {
        padding-top: 50px;
      
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
  <div align="center" class=title>
<h2>Admin Page</h2>
<p>If you would like to add a new album, use the form below.</p>
<p>You can edit or delete in the generated table of albums</p>
</div>



<div class="addform" align="center">
    <h3>Add a Product</h3>
    <form action="/create" method="post">
     
        <label for="name">Album Name</label><br /><input type="text" id="name" name="name" required/><br />
      
        <label for="artist">Artist</label><br /><input type="text" id="artist" name="artist" required/><br />
     
        <label for="price">Price</label><br /><input type="number" min=".01" step=".01" id="price" name="price" required/><br />
      
        <label for= "release_date">Release Date</label><br /><input type="date" id="release_date" name="release_date" required/><br />
      
        <label for="genre_name">Genre</label><br /><input type="text" id="genre_name" name="genre_name" required/><br />
        <h6> </h6>
  <input type="submit" value="Add" />
</form>
</div> 



 
  
  
<h6><font color="green">${message}</font></h6>
    
   
   
 

    



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
    <div class="col"><h5>Admin</h5></div>
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
      <form action="/edit" method="get">

        <input type="hidden" id="id" name="id" value="${albums.id}">
      
      <input type="submit" value="Edit" />
      </form>
      <h6> </h6>
       <form action="/delete" method="post">

  <input type="hidden" id="id" name="id" value="${albums.id}">

<input type="submit" value="Delete" />
</form>
    </div>
  
  </div>
</div>
</c:forEach>
</div>
  

</div>
</body>
</html>