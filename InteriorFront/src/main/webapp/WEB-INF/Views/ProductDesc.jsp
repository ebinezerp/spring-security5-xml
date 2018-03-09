<%@include file="Header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h3 align="center">Product Page</h3>

<table  align="center" width="40%" height="40%" border="2" >
	<tr align="center" bgcolor="#7e57c2" >
		<td colspan="2" >Product Details</td></tr>
	<tr bgcolor="cyan">
		<td>Price</td>
		<td>${ProductInfo.productPrice}</td>
	</tr>
	<tr bgcolor="pink">
		<td>Product Name</td>
		<td>${ProductInfo.productName}</td>
	</tr>
	<tr bgcolor="pink">
		<td>Category ID</td>
		<td>${categoryName}</td>
	</tr>
	<tr bgcolor="pink">
		<td>Supplier ID</td>
		<td>${ProductInfo.supplierId}</td>
	</tr>
	<tr bgcolor="pink">
		<td>Product Description</td>
		<td>${ProductInfo.prodDesc}</td>
	</tr>
	<tr>
		<td>Quantity</td>
		<td>
		<select name="quantity">
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
		</select>
		</td>
	</tr>
</table>


</body>
</html>