<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.example.bean.Cart"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="/Products">Home</a><br>


<h1>Cart </h1>
<table>
<tr>
 <th>#</th>
 <th>Product Name</th>
 <th>Product Quantity</th>
 <th>Product Price</th>
</tr>

<%
Object obj=request.getAttribute("cart");

 if(obj!=null)
 {
	 List<Cart> cartItems= (List<Cart>)obj;
	 
	 for(Cart item: cartItems)
	 {
		 %>
		<tr>
		<td><%=item.getId()%></td>
			<td><%=item.getProductName()%></td>
			<td><%=item.getProductQty()%></td>
			<td><%=item.getProductPrice()%></td>
		</tr>
	<%
	}			 
 }
 
%>

</table>

<c:if test = "${cartList.size()>0 }">
<a href="checkout">Checkout</a><br>
</c:if>

</body>
</html>