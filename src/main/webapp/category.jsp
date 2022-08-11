<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Categories</title>
</head>
<body>
<h2>Add Categories</h2>
<form action="addCategory" method="post">
		<label> Category name</label>
		<input type="text" name="cname" value=${cname}> </br></br>
		 <input type="submit" value="submit"> 
		 <input type="reset" value="reset">  
		</from>
</body>
</html>