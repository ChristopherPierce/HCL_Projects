<%@page import="java.util.Date" %> 
<%long ts = (new Date()).getTime(); %>
<!DOCTYPE html>
<html>
<head>

<script src="feedback_form.js?<%=ts %>">
</script>

</head>

<body>

<h2>Your feedback is appreciated!</h2>
<!--
<form onsubmit="SubmitTestForm()">
-->
<form method="post" th:object="${feedback}">
  <label for="user">Name:</label><br>
  <input type="text" id="user" name="user"><br>
  <label for="rating">Rating (1-10):</label><br>
  <input type="number" id="rating" name="rating" min="1" max="10" value="10"><br>
  <label for="comments">Comment:</label><br>
  <textarea id="comments" name="comments" rows="4" cols="50"></textarea><br><br>
  <input type="submit" value="Submit" >
</form> 

</body>
</html>