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

				<h2 class="featurette-heading">Add New ExamTypology</h2>
				<div class="card card-block col-md-7">
					<div class="row featurette">
						<div class=" col-sm-7">
							<springForm:form action="updateExamTypology" method="POST"
								commandName="examTypology">
								<table style="width: 100%">
									<tr><td><p class="lead">Insert Name:</p></td>
										<td><springForm:input path="name" cssClass="form-control"
												placeholder="Name" /></td>
										<td><springForm:errors path="name"
												cssClass="alert alert-danger" /></td>
									</tr>
									<tr><td><p class="lead">Insert Description:</p></td>
										<td><springForm:input path="description"
												cssClass="form-control" placeholder="Description" /></td>
										<td><springForm:errors path="description"
												cssClass="alert alert-danger" /></td>
									</tr>

									<tr><td><p class="lead">Insert Price:</p></td>
										<td><springForm:input path="price"
												cssClass="form-control" placeholder="Price" /></td>
										<td><springForm:errors path="price" 
												cssClass="alert alert-danger" /></td>
									</tr>
								</table>
								<br>
								<div class="btn-group">
									<div><p class="lead">Choose or Insert new indicators:</p>
										<button type="button" class="btn btn-danger btn-lg"
											data-toggle="collapse" data-target="#resultIndicators"
											aria-expanded="false" aria-controls="resultIndicators">
											ResultIndicators</button>
										<button type="button" class="btn btn-danger btn-lg"
											data-toggle="collapse" data-target="#addResultIndicators"
											aria-expanded="false" aria-controls="addResultIndicators">
											<span class="caret"></span> <span class="sr-only">Toggle
												Dropdown</span>
										</button>
										<c:if test="${not empty resultIndicatorError}">
										<span><font class="alert alert-danger">${resultIndicatorError}</font></span></c:if>
										<span><springForm:errors path="resultIndicators" 
												cssClass="alert alert-danger" /></span>
									</div>

									<div class="collapse" id="resultIndicators">
										<div class="card card-block">
											<table >
											<tbody style="display:block; height: 300px; overflow-y: scroll">
												<tr>
													<th>Description</th>
													<th>Select</th>
												</tr>
												
												<c:forEach var="resultIndicator"
													items="${resultIndicatorsList}" varStatus="status">
													<tr>
														<td>${resultIndicator.description}</td>
														<td><springForm:checkbox path="resultIndicators"
																value="${resultIndicator.description}"
																cssClass="form-control" /></td>
													</tr>
												</c:forEach></tbody>
											</table>
										</div>
									</div>
								</div>
								<br>
								<br>
								<div class="btn-group">

									<div><p class="lead">Choose or Insert new prerequisites:</p>
										<button type="button" class="btn btn-danger btn-lg"
											data-toggle="collapse" data-target="#prerequisites"
											aria-expanded="false" aria-controls="prerequisites">
											Prerequisites</button>
										<button type="button" class="btn btn-danger btn-lg"
											data-toggle="collapse" data-target="#addPrerequisites"
											aria-expanded="false" aria-controls="addPrerequisites">
											<span class="caret"></span> <span class="sr-only">Toggle
												Dropdown</span>
										</button>
										<c:if test="${not empty prerequisiteError}">
										<span><font class="alert alert-danger">${prerequisiteError}</font></span></c:if>
										<span><springForm:errors path="prerequisites" 
												cssClass="alert alert-danger" /></span>
									</div>
									<div class="collapse" id="prerequisites">
										<div class="card card-block">
											<table>
											<tbody style="display:block; height: 300px; overflow-y: scroll">
												<tr>
													<th>Name</th>
													<th>Description</th>
													<th>Select</th>
												</tr>
												<c:forEach var="prerequisite" items="${prerequisitesList}"
													varStatus="status">
													<tr>
														<td>${prerequisite.name}</td>
														<td>${prerequisite.description}</td>
														<td><springForm:checkbox path="prerequisites"
																value="${prerequisite.name}" cssClass="form-control" /></td>
													</tr>
												</c:forEach></tbody>
											</table>
										</div>
									</div>
								</div>

								<br>
								<br>
								<input type="submit" value="Submit"
									class="btn btn-success btn-lg" />
							</springForm:form>
						</div>
					</div>
					<div id="addPrerequisites" class="collapse center-div">
						<div class="form-group">
							<p class="lead">Add Prerequisite</p>
							<springForm:form action="updatePrerequisite" method="POST"
								commandName="prerequisite" cssClass="form container-fluid">
								<table style="width: 100%">
									<tr>
										<td><form:input path="name" cssClass="form-control"
												placeholder="Name" /></td>
										<td><springForm:errors path="name"
												cssClass="error" /></td>
									</tr>
									<tr>
										<td><form:input path="description"
												cssClass="form-control" placeholder="Description" /></td>
										<td><springForm:errors path="description"
												cssClass="error" /></td>
									</tr>
								</table>
								<input type="submit" value="Insert" class="btn btn-danger" />
							</springForm:form>
						</div>
					</div>
					<div id="addResultIndicators" class="collapse center-div">
						<div class="form-group">
							<p class="lead">Add Result Indicator</p>
							<springForm:form action="updateResultIndicator" method="POST"
								commandName="resultIndicator" cssClass="form container-fluid">
								<table style="width: 100%">
									<tr>
										<td><form:input path="description"
												cssClass="form-control" placeholder="Description" /></td>
												<td><springForm:errors path="description"
												cssClass="error" /></td>
									</tr>
								</table>
								<input type="submit" value="Insert" class="btn btn-danger" />
							</springForm:form>
						</div>

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