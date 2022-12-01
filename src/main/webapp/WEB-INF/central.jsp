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
<title>CDMS</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
	<div class="container mt-5">
		<div>
			<div class="d-flex justify-content-center">
				<h2>Central Data Management System - CDMS</h2>
			</div>
			<div class="d-flex justify-content-end">
				<h5>
					<a href="/logout">Log Out</a>
				</h5>
			</div>
			<div class="d-flex justify-content-between">
				<h6 style="color: red">Welcome, you are logged in as, ${userName}</h6>
				<h5 class="text-decoration: none">
					<a href="/employees/add">New Employee</a>
				</h5>
			</div>
		</div>
		<div id="employees">
			<c:forEach begin="1" end="${totalPages}" var="index">
				<a href="/pages/${index}">${index}</a>
			</c:forEach>
			<table class="table">
				<thead class="thead">
					<tr>
						<th>Number<a href="/page/1?sortField=employeeNumber&sortDir=asc">▲</a><a href="/page/1?sortField=employeeNumber&sortDir=desc">▼</a></th>
						<th>First Name</th>
						<th>Last Name<a href="/page/1?sortField=lastName&sortDir=asc">▲</a><a href="/page/1?sortField=lastName&sortDir=desc">▼</a></th>
						<th>Birthday<a href="/page/1?sortField=birthDate&sortDir=asc">▲</a><a href="/page/1?sortField=birthDate&sortDir=desc">▼</a></th>
						<th>EMail</th>
						<th>Primary Phone</th>
						<th>Department<a href="/page/1?sortField=department&sortDir=asc">▲</a><a href="/page/1?sortField=department&sortDir=desc">▼</a></th>
						<th>Job Title</th>
						<th>Manager<a href="/page/1?sortField=manager&sortDir=asc">▲</a><a href="/page/1?sortField=manager&sortDir=desc">▼</a></th>
						<th>Status<a href="/page/1?sortField=status&sortDir=asc">▲</a><a href="/page/1?sortField=status&sortDir=desc">▼</a></th>
						<th colspan=2>Actions</th>
					</tr>
				</thead>
				<tbody class="tbody">
					<c:forEach var="eachEmployee" items="${employeeList}">
							<tr>
								<td><a href="/employees/${eachEmployee.id }"> <c:out
											value="${eachEmployee.employeeNumber }" /></a></td>
								<td>${eachEmployee.firstName }</td>
								<td><c:out value="${eachEmployee.lastName }"></c:out></td>
								<td><fmt:formatDate value="${eachEmployee.birthDate }"/></td>
								<td>${eachEmployee.email }</td>
								<td>${eachEmployee.phone }</td>
								<td><c:out value="${eachEmployee.department }"></c:out></td>
								<td><c:out value="${eachEmployee.jobTitle }"></c:out></td>
								<td><c:out value="${eachEmployee.manager }"></c:out></td>
								<td><c:out value="${eachEmployee.status }"></c:out></td>
								<td><a href="/employees/${eachEmployee.id }">View</a> <a
									href="/employees/edit/${eachEmployee.id }">Edit</a></td>
							</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>