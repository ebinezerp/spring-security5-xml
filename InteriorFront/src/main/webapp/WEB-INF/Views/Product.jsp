<%@include file="Header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<h3 align="center" >Product Page</h3>

<c:if test="${product!=null}">
<form:form action="InsertProduct" method="post" commandName="product">
	<table align="center">
		
		<tr>
			<td>Product Name</td><td><form:input path="productName"/></td>
		</tr>
		<tr>
			<td>Product Price</td><td><form:input path="productPrice"/></td>
		</tr>
		<tr>
		<td>Product Desc</td><td><form:input path="productDesc"/></td>
		</tr>
		<tr><td>
			Category
		</td>
		<td><form:select path="categoryId" itemLabel="categoryName"/></td><!-- check -->
		</tr>
		<tr>
			<div><td colspan="2"><input type="submit" value="SUBMIT" /> <input type="reset" value="RESET" /></div></td>
		</tr>
	</table>
</form:form>
</c:if>
<table align="center" border="2" >
	<tr>
		<td>Product ID</td> 
		<td>Product Name</td> 
		<td>Product Price</td>
		<td>Product Desc</td> 
		<td>Operation</td> 
	</tr>
	<c:forEach items="${listProducts}" var="product">
		<tr>
			<td>${product.productId}</td>
			<td>${product.productName}</td>
			<td>${product.productPrice}</td>
			<td>${product.productDesc}</td>
			<td><!--  a href="<c:url value="/updateProduct/${product.productId}"/>">Update</a>-->/
				<a href="<c:url value="/deleteProduct/${product.productId}"/>">Delete</a>
			</td>
		</tr>
	</c:forEach>

</table>

</body>
</html>














