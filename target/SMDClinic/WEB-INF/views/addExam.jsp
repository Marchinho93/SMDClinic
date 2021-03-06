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
<!-- NAVBAR -->
<body ng-app="homeNav">
	<div class="{{bodyClass}}">
		<div class="navbar-wrapper">
			<div class="container">
				<nav class="navbar navbar-inverse navbar-static-top">
					<div class="container">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle collapsed"
								data-toggle="collapse" data-target="#navbar"
								aria-expanded="false" aria-controls="navbar">
								<span class="sr-only">Toggle navigation</span> <span
									class="icon-bar"></span> <span class="icon-bar"></span> <span
									class="icon-bar"></span>
							</button>
							<div class="navbar-brand">SMDClinic</div>
						</div>
						<div id="navbar" ng-controller="homeNavController"
							class="navbar-collapse collapse">
							<div>
								<ul class="nav navbar-nav">
										<li
											ng-class="{'active':urlActive === '${pageContext.request.contextPath}/adminArea'}"><a
											href=""
											ng-click="href('${pageContext.request.contextPath}/adminArea');">Home</a></li>
										<li
											ng-class="{'active':urlActive === '${pageContext.request.contextPath}/examsByDoctor'}">
											<a href=""
											ng-click="href('${pageContext.request.contextPath}/index');">Exit</a>
										</li>
									</ul>
							</div>
							<ul class="nav navbar-nav navbar-right">
								<li class="dropdown"><a href="" class="dropdown-toggle"
									data-menuid="navig" data-toggle="dropdown" role="button"
									aria-haspopup="true" aria-expanded="false">${loginString}<span
										class="caret"></span></a>
									<div id="navig" class="dropdown-menu collapse">
										<f:view>
											<c:choose>
												<c:when test="${role eq 'admin'}">
													<jsp:include page="/WEB-INF/templates/adminMenu.jsp" />
												</c:when>
												<c:otherwise>
													<h4>ERROR</h4>
												</c:otherwise>
											</c:choose>
										</f:view>
									</div></li>
							</ul>
						</div>
					</div>
				</nav>
			</div>
		</div>



		<!-- AdminPanels -->
		<div id="HTMLContainer" class="container marketing">
			<div class="container">
				<h2 class="featurette-heading">Add New Exam</h2>
				<div class="row featurette">
					<div class="col-md-12 col-sm-7">
						<springForm:form action="updateExam" method="POST"
							commandName="exam">
							<p class="lead">
								<b>Choose an exam typology:</b>
							</p>
								<div class="row featurette">
									<a class="btn btn-success btn-lg" data-toggle="collapse"
										href="#examTyp" aria-expanded="false" aria-controls="examTyp">

										<font class="lead">Exam Typology</font><span class="caret"></span>
									</a>
								</div>
							<div class="collapse" id="examTyp">
								<div class="card card-block">
									<div class="row featurette">
										<p></p>
										<div class="card card-block">
											<table style="width: 100%">
								<tr>
									<th><b> </b></th>
									<th><b>Code</b></th>
									<th><b>Name</b></th>
									<th><b>Description</b></th>
									<th><b>Price</b></th>
									<th><b>Select</b></th>
								</tr>
								<c:forEach var="examTypology" items="${examTypologiesList}"
									varStatus="status">
									<tr>
										<td><b>${status.index + 1}</b></td>
										<td>${examTypology.code}</td>
										<td>${examTypology.name}</td>
										<td>${examTypology.description}</td>
										<td>${examTypology.price}</td>
										<td><form:radiobutton path="examTypology"
												value="${examTypology.code}" /> <springForm:errors
												path="examTypology" cssClass="error" /></td>
									</tr>
								</c:forEach>
							</table>
										</div>
									</div>
								</div>
							</div>
							
							<p class="lead">
								<b>Choose a doctor:</b>
							</p>
							<div class="row featurette">
									<a class="btn btn-success btn-lg" data-toggle="collapse"
										href="#doc" aria-expanded="false" aria-controls="doc">

										<font class="lead">Doctor</font><span class="caret"></span>
									</a>
								</div>
							<div class="collapse" id="doc">
								<div class="card card-block">
									<div class="row featurette">
										<p></p>
										<div class="card card-block">
							<table style="width: 100%">
								<tr>
									<th><b> </b></th>
									<th><b>Code</b></th>
									<th><b>Name</b></th>
									<th><b>Surname</b></th>
									<th><b>Select</b></th>
								</tr>
								<c:forEach var="doctor" items="${doctorsList}"
									varStatus="status">
									<tr>
										<td><b>${status.index + 1}</b></td>
										<td>${doctor.code}</td>
										<td>${doctor.name}</td>
										<td>${doctor.surname}</td>
										<td><form:radiobutton path="doctor"
												value="${doctor.code}" /> <springForm:errors path="doctor"
												cssClass="error" /></td>
									</tr>
								</c:forEach>
							</table>
							</div></div></div></div>
							<p class="lead">
								<b>Choose a patient:</b>
							</p>
							<div class="row featurette">
									<a class="btn btn-success btn-lg" data-toggle="collapse"
										href="#pat" aria-expanded="false" aria-controls="pat">

										<font class="lead">Patient</font><span class="caret"></span>
									</a>
								</div>
							<div class="collapse" id="pat">
								<div class="card card-block">
									<div class="row featurette">
										<p></p>
										<div class="card card-block">
							<table style="width: 100%">
								<tr>
									<th><b> </b></th>
									<th><b>Code</b></th>
									<th><b>Name</b></th>
									<th><b>Surname</b></th>
									<th><b>Select</b></th>
								</tr>
								<c:forEach var="patient" items="${patientsList}"
									varStatus="status">
									<tr>
										<td><b>${status.index + 1}</b></td>
										<td>${patient.code}</td>
										<td>${patient.name}</td>
										<td>${patient.surname}</td>
										<td><form:radiobutton path="patient"
												value="${patient.code}" /> <springForm:errors
												path="patient" cssClass="error" /></td>
									</tr>
								</c:forEach>
							</table>
							</div></div></div></div>
							<p class="lead">
								<b>Insert the exam's date:</b>
							</p>
							<form:input type="date" path="examDate" value="MM/DD/YYYY" />
							<springForm:errors path="examDate" cssClass="error" />
							<br>
							<br>
							<input type="submit" value="Submit" class="btn btn-default" />
						</springForm:form>
					</div>
				</div>
			</div>

		</div>
		<!-- /.container -->

		<!-- Bootstrap core JavaScript -->
		<script
			src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.2.3.min.js"></script>
		<script>
			//<![CDATA[
			window.jQuery
					|| document
							.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')
			//]]>
		</script>
		<script src="js/bootstrap.js"></script>
		<script src="js/holder.min.js"></script>

	</div>
</body>
</html>