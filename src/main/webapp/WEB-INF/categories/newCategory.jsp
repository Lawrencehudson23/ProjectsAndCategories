<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Category</title>
</head>
<body>
	<h1>Create a new Category</h1>
	<h2 style="color: green;">
		<c:out value="${success }" />
	</h2>

	<form:form action="/categories/new" method="post"
		modelAttribute="newCategory">
		<p>
			<form:label path="name">Name</form:label>
			<form:errors style="red;" path="name" />
			<form:input path="name" />
		</p>

		<input type="submit" value="Create" />
	</form:form>
</body>
</html>