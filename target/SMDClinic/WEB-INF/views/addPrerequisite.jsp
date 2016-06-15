<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:sec="http://www.springframework.org/security/tags">
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springForm"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!-- other meta down this tag -->
<meta name="description" content="" />
<meta name="author" content="" />
<link rel="icon" href="../../favicon.ico" />

<title>SMDClinic</title>

<!-- Bootstrap CSS -->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet" />
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.2/css/bootstrap.min.css">-->



<!-- Prefetching pages... -->
<link rel="${pageContext.request.contextPath}prefetch" href="home.html" />
<link rel="${pageContext.request.contextPath}prefetch"
	href="theClinic.html" />

<!-- AngularJS -->
<script
	src="//ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular.min.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-animate.min.js"></script>

<!-- navbar and carousel behaviour -->
<script src="${pageContext.request.contextPath}/js/app/homeNav.js"></script>

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/css/carousel.css"
	rel="stylesheet" />
</head>
<body>

	<div class="form-group">
		<springForm:form action="updatePrerequisite" method="POST"
			commandName="prerequisite" cssClass="form container-fluid">
			<table style="width: 100%">
				<tr>
					<td><form:input path="name" cssClass="form-control"
							placeholder="Name" /></td>
					<td><springForm:errors path="name"
							cssClass="alert alert-danger" /></td>
				</tr>
				<tr>
					<td><form:input path="description" cssClass="form-control"
							placeholder="Description" /></td>
					<td><springForm:errors path="description"
							cssClass="alert alert-danger" /></td>
				</tr>
			</table>
			<input type="submit" value="Insert" class="btn btn-danger"/>
		</springForm:form>
	</div>


</body>
</html>