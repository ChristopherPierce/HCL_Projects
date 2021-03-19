<%@page import="java.util.Date" %> 
<%long ts = (new Date()).getTime(); %>
<!DOCTYPE html>
<html>
<head>

<script src="feedback_helper.js?<%=ts %>">
</script>

</head>

<body>

<h2>Recent feedback:</h2>
<table></table>

</body>
</html>