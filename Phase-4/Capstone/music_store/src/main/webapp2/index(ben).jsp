<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="create" method="post">
    <label for="name">Album Name: </label><br>
  	<input type="text" id="name" name="name"><br>
 	<label for="artist">Artist: </label><br>
  	<input type="text" id="artist" name="artist"><br>
  	<label for="price">Price: </label><br>
  	<input type="text" id="price" name="price"><br>
  	<label for="release_date">Release Date: </label><br>
  	<input type="date" id="release_date" name="release_date"><br>
  	<label for="genre">Genre: </label><br>
  	<input type="text" id="genre" name="genre_name"><br>
  	<input type="submit" value="Add Album">
  	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
</form><br>
<form action="read" method="post">
  	<input type="submit" value="Submit">
  	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>  	
</form><br>
<form action="update" method="post">
	<label for="id">ID: </label><br>
  	<input type="number" id="id" name="id"><br>
    <label for="name">Album Name: </label><br>
  	<input type="text" id="name" name="name"><br>
 	<label for="artist">Artist: </label><br>
  	<input type="text" id="artist" name="artist"><br>
  	<label for="price">Price: </label><br>
  	<input type="text" id="price" name="price"><br>
  	<label for="release_date">Release Date: </label><br>
  	<input type="date" id="release_date" name="release_date"><br>
  	<label for="genre">Genre: </label><br>
  	<input type="text" id="genre" name="genre_name"><br>
  	<input type="submit" value="Add Album">
  	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
  	<input type="hidden" name="column" value="album"/>	
</form><br>
<form action="delete" method="post">
	<p>Select your desired view.</p>
	<input type="radio" id="album" name="viewType" value="albums">
  	<label for="album">Albums</label><br>
  	<input type="radio" id="genre" name="viewType" value="genres">
  	<label for="genre">Genres</label><br>
  	<input type="radio" id="music" name="viewType" value="music">
  	<label for="music">Music</label>
  	<input type="submit" value="Submit">
  	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>  	
</form><br>

</body>
</html>