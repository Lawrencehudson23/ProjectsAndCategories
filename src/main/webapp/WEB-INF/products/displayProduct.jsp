<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Page</title>
</head>
<body>
	<h1>
		<c:out value="${product.name}" />

	</h1>

	<h2>Categories:</h2>

	<ul>
		<c:forEach items="${pc}" var="c">

			<li>${c.name}</li>


		</c:forEach>

	</ul>

		<form action="/products/${product.id}" method="post">

		<label>Add Category: 
		<select name="categoryId">
				<c:forEach items="${allCategories}" var="ac">
					<c:if test="${!pc.contains(ac)}">
						<option value="${ac.id}">${ac.name}${ac.id}</option>
					</c:if>
				</c:forEach>
		</select>
		
		</label>

	<button>Add</button>
	</form>
	<%-- 
		<c:forEach  items="${allCategories}" var="category">
				<tr>
					<c:out value="${category.name}"/>

				</tr>
			</c:forEach> --%>


</body>
</html>