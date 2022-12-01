<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.css">
<meta charset="UTF-8">
<title>Employee Details</title>
</head>
<body>
	<div class="container mt-5">
		<div class="d-flex justify-content-center">
			<h2>Central Data Management System - CDMS</h2>
		</div>
		<div class="d-flex justify-content-between">
			<h6 style = "color:red">You are logged in as, ${userName}</h6>
		</div>
		<div class="d-flex justify-content-center">
		<h4 style = "color:red">Review Information before returning to Home Page</h4>
		</div>
		<div class="d-flex justify-content-around">
			<div>
				<h5>Employee Information</h5>
				<ul class="list-unstyled">
					<li>${employee.socialSecurity }</li>
					<li><fmt:formatDate value="${employee.birthDate }"/></li>
					<li>${employee.lastName }, ${employee.firstName }</li>
					<li>${employee.addressNumber } ${employee.addressStreet }</li>
					<li>${employee.city }, ${employee.state } ${employee.zipCode }</li>
					<li>${employee.email }</li>
					<li>${employee.phone }</li>
				</ul>
			</div>
			<div>
				<h5>Employment Information</h5>
				<ul class="list-unstyled">
					<li>${employee.employeeNumber }</li>
					<li>${employee.department }</li>
					<li>${employee.jobTitle }</li>
					<li>${employee.manager }</li>
					<li><fmt:formatNumber value="${employee.salary }" type="currency"/></li>
					<li><fmt:formatDate value="${employee.hireDate }"/></li>
					<li>${employee.status }</li>
					<li><fmt:formatDate value="${employee.lastDate }"/></li>
					<li>${employee.notes }</li>
				</ul>
			</div>
		</div>
		<div class="d-flex justify-content-around">
			<form action="/employees/">
				<button class="btn btn-primary" type="submit">Home</button>
			</form>
			<form action="/employees/edit/${employee.id }">
				<button class="btn btn-secondary" type="submit">Edit</button>
			</form>
			<form action="/employees/delete/${id }" method="POST">
				<input type="hidden" name="_method" value="delete">
				<button class="btn btn-danger" type="submit">Delete</button>
			</form>
		</div>
	</div>
</body>
</html>