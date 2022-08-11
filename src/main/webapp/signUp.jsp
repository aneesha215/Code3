<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
</head>
<body>
<h2> User Sign Up</h2>
	<form action="registerUser" method="post">
	    <label> Name </label>
		<input type="text" name="name"> </br>
		<label> Age </label>
		<input type="number" name="age"> </br>
		<p> Please Select your Gender</p>
		<span>
		<input type="radio" id="women" name="gender" value="W">
�       <label for="women">W</label>
�       <input type="radio" id="men" name="gender" value="M">
�       <label for="men">M</label><br>
         </span>
		<label> Email Id </label>
		<input type="email" name="email"> </br>
		<label> Password </label>
		 <input type="password" name="password"> </br>
		 <input type="submit" value="submit"> 
		 <input type="reset" value="reset">  
		</from>
</body>
</html>