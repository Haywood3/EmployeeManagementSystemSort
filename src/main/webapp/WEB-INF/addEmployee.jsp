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
<title>Add Employee</title>
</head>
<body>
	<div class="container mt-5">
		<div class="d-flex justify-content-center align-items-center">
			<h2>Central Data Management System - CDMS</h2>
		</div>
		<div class="d-flex justify-content-between">
			<h6 style = "color:red">You are logged in as, ${userName}</h6>
		</div>
		<div class="d-flex justify-content-between align-items-center">
			<h4>Employee (New) Information Form - NEIF</h4>
			<h5>
				<a href="/employees">Home</a>
				</h5>
		</div>
		<div>

			<form:form class="form-control d-flex justify-content-around" action="/employees/process"
				method="POST" modelAttribute="addEmployee">
				<div>
					<h5>Employee Information</h5>
					<p>
						<form:label path="employeeNumber" class="form-label">Employee Number</form:label>
						<form:input path="employeeNumber" class="form-control" />
						<form:errors path="employeeNumber" style="color:darkorange" />
					</p>
					<p>
						<form:label path="firstName" class="form-label">First Name</form:label>
						<form:input path="firstName" class="form-control" />
						<form:errors path="firstName" style="color:darkorange" />
					</p>
					<p>
						<form:label path="middleName" class="form-label">Middle Name</form:label>
						<form:input path="middleName" class="form-control" />
						<form:errors path="middleName" style="color:darkorange" />
					</p>
					<p>
						<form:label path="lastName" class="form-label">Last Name</form:label>
						<form:input path="lastName" class="form-control" />
						<form:errors path="lastName" style="color:darkorange" />
					</p>
					<p>
						<form:label path="socialSecurity" class="form-label">Social Security Number</form:label>
						<form:input path="socialSecurity" class="form-control" />
						<form:errors path="socialSecurity" style="color:darkorange" />
					</p>
					<p>
						<form:label path="birthDate" class="form-label">Birthday</form:label>
						<form:input type="date" path="birthDate" class="form-control" />
						<form:errors path="birthDate" style="color:darkorange" />
					</p>
					<p>
						<form:label path="email" class="form-label">Email</form:label>
						<form:input path="email" class="form-control" />
						<form:errors path="email" style="color:darkorange" />
					</p>
					<p>
						<form:label path="phone" class="form-label">Phone</form:label>
						<form:input path="phone" class="form-control" />
						<form:errors path="phone" style="color:darkorange" />
					</p>
					<p>
						<form:label path="addressNumber" class="form-label">Address Number</form:label>
						<form:input path="addressNumber" class="form-control" />
						<form:errors path="addressNumber" style="color:darkorange" />
					</p>
					<p>
						<form:label path="addressStreet" class="form-label">Address Street</form:label>
						<form:input path="addressStreet" class="form-control" />
						<form:errors path="addressStreet" style="color:darkorange" />
					</p>
					<p>
						<form:label path="city" class="form-label">City</form:label>
						<form:input path="city" class="form-control" />
						<form:errors path="city" style="color:darkorange" />
					</p>
					<p>
						<form:label path="state" class="form-label">State</form:label>
						<form:input path="state" class="form-control" />
						<form:errors path="state" style="color:darkorange" />
					</p>
					<p>
						<form:label path="zipCode" class="form-label">Zip Code</form:label>
						<form:input path="zipCode" class="form-control" />
						<form:errors path="zipCode" style="color:darkorange" />
					</p>
				</div>
				<div>
					<h5>Employment Information</h5>
					<p>
						<form:label path="department" class="form-label">Department</form:label>
						<form:input path="department" class="form-control" />
						<form:errors path="department" style="color:darkorange" />
					</p>
					<p>
						<form:label path="jobTitle" class="form-label">Job Title</form:label>
						<form:input path="jobTitle" class="form-control" />
						<form:errors path="jobTitle" style="color:darkorange" />
					</p>
					<p>
						<form:label path="manager" class="form-label">Manager</form:label>
						<form:input path="manager" class="form-control" />
						<form:errors path="manager" style="color:darkorange" />
					</p>
					<p>
						<form:label path="salary" class="form-label">Salary</form:label>
						<form:input path="salary" class="form-control" />
						<form:errors path="salary" style="color:darkorange" />
					</p>
					<p>
						<form:label path="hireDate" class="form-label">Hire Date</form:label>
						<form:input type="date" path="hireDate" class="form-control" />
						<form:errors path="hireDate" style="color:darkorange" />
					</p>
					<p>
						<form:label path="status" class="form-label">Status</form:label>
						<form:select path="status" class="form-control"></>
						<option>${editEmployee.status }</option>
							<option>Employed</option>
							<option>Owner</option>
							<option>Short-Term Disability</option>
							<option>Family Medical Leave</option>
							<option>Medical Leave</option>
							<option>Vacation</option>
							<option>Involuntarily Dismissed*</option>
							<option>Voluntarily Resigned*</option>
							<option>Retired*</option>
						</form:select>
						<form:errors path="status" style="color:darkorange" />
					</p>
					<p>
						<form:label path="lastDate" class="form-label">Return Date or Last Day*</form:label>
						<form:input type="date" path="lastDate" class="form-control" />
						<form:errors path="lastDate" style="color:darkorange" />
					</p>
					<p>
						<form:label path="notes" class="form-label">Additional Notes</form:label>
						<form:textarea path="notes" class="form-control"></form:textarea>
						<form:errors path="notes" style="color:darkorange" />
					</p>
					<div class="d-flex justify-content-around align-items-center">
						<form:hidden path="job" value="${userId }"></form:hidden>
						<button class="btn btn-success" type="submit">Submit</button>
						<a href="/employees">Cancel</a>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>