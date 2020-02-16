<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Category Page</title>
</head>
<body>
	<h1>
		<c:out value="${category.name}" />

	</h1>

	<h2>Products:</h2>

	<ul>
		<c:forEach items="${cp}" var="p">

			<li>${p.name}</li>


		</c:forEach>

	</ul>

		<form action="/categories/${category.id}" method="post">

		<label>Add Product: 
		<select name="productId">
				<c:forEach items="${allProducts}" var="ap">
					<c:if test="${!cp.contains(ap)}">
						<option value="${ap.id}">${ap.name}${ap.id}</option>
					</c:if>
				</c:forEach>
		</select>
		
		</label>

	<button>Add</button>
	</form>
	<%-- 
		<c:forEach  items="${allProducts}" var="product">
				<tr>
					<c:out value="${product.name}"/>

				</tr>
			</c:forEach> --%>


</body>
</html>