<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Donations - LogInReg - Full Spring</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.css">
</head>
<body>
<h1 class="text-center">Central Data Systems</h1>
	<div class="container mt-5 d-flex justify-content-around">
		<div>
		<h3 class="text-center">Registration</h3>
		<form:form class="form-control" action="/register" method="POST" modelAttribute="newUser">
			<div class="form-group">
				<form:label path="userName">User Name:</form:label>
				<form:input path="userName" class="form-control" />
				<form:errors path="userName" class="text-danger" />
			</div>
			<div class="form-group">
				<form:label path="email">Email:</form:label>
				<form:input path="email" class="form-control" />
				<form:errors path="email" class="text-danger" />
			</div>
			<div class="form-group">
				<form:label path="password">Password:</form:label>
				<form:input path="password" class="form-control" type="password" />
				<form:errors path="password" class="text-danger" />
			</div>
			<div class="form-group">
				<form:label path="confirm">Confirm Password:</form:label>
				<form:input path="confirm" class="form-control" type="password" />
				<form:errors path="confirm" class="text-danger" />
			</div>
			<button type="submit" class="btn btn-success">Register</button>
		</form:form>
		</div>
		<div>
		<h3 class="text-center">Login</h3>
		<form:form class="form-control" action="/login" method="POST" modelAttribute="newLogin">
			<div class="form-group">
				<form:label path="email">Email:</form:label>
				<form:input path="email" class="form-control" />
				<form:errors path="email" class="text-danger" />
			</div>
			<div class="form-group">
				<form:label path="password">Password:</form:label>
				<form:input path="password" class="form-control" type="password" />
				<form:errors path="password" class="text-danger" />
			</div>
			<button type="submit" class="btn btn-success">Login</button>
		</form:form>
		</div>
	</div>
</body>
</html>