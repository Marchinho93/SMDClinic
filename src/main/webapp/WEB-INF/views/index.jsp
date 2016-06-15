<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
	<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" />
	
	<!-- Prefetching pages... -->
	<link rel="${pageContext.request.contextPath}prefetch" href="home.html" />
	<link rel="${pageContext.request.contextPath}prefetch" href="theClinic.html" />
	
	<!-- AngularJS -->
	<script
		src="//ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular.min.js"></script>
	<script
		src="//ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-animate.min.js"></script>
	
	<!-- navbar and carousel behaviour -->
	<script src="${pageContext.request.contextPath}/js/app/homeNav.js"></script>
	
	<!-- Custom styles for this template -->
	<link href="${pageContext.request.contextPath}/css/carousel.css" rel="stylesheet" />
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
							<ul class="nav navbar-nav">
								<li ng-class="{'active':urlActive === 'home'}"><a href=""
									ng-click="update('home');">Home</a></li>
								<li class="dropdown"><a href="" class="dropdown-toggle"
									data-menuid="1" data-toggle="dropdown" role="button"
									aria-haspopup="true" aria-expanded="false">Our Services<span
										class="caret"></span></a>
									<ul id="1" class="dropdown-menu collapse">
										<li ng-class="{'active':urlActive === 'exams'}"><a
											href="" ng-click="update('exams');">Exams</a></li>
										<li ng-class="{'active':urlActive === 'doctors'}"><a
											href="" ng-click="update('doctors');">Doctors</a></li>
										<li role="separator" class="divider"></li>
										<li class="dropdown-header">Our patients</li>
										<li ng-class="{'active':urlActive === 'feedbacks'}"><a
											href="" ng-click="update('feedbacks');">Feedbacks</a></li>
									</ul></li>
								<li ng-class="{'active':urlActive === 'contacts'}"><a
									href="" ng-click="update('contacts');">Contacts</a></li>
							</ul>
							<ul class="nav navbar-nav navbar-right">
								<li class="dropdown"><a href="" class="dropdown-toggle"
									data-menuid="navig" data-toggle="dropdown" role="button"
									aria-haspopup="true" aria-expanded="false">${empty loginString ? 'Login' : loginString}<span
										class="caret"></span></a>
									<div id="navig" class="dropdown-menu collapse">
										<c:choose>
											<c:when test="${role eq 'admin'}">
												<jsp:include page="/WEB-INF/templates/adminMenu.jsp" />
											</c:when>
											<c:when test="${role eq 'patient'}">
												<jsp:include page="/WEB-INF/templates/patientMenu.jsp" />
											</c:when>
											<c:otherwise>
												<jsp:include page="/WEB-INF/templates/login.jsp" />
											</c:otherwise>
										</c:choose>
									</div></li>
							</ul>
						</div>
					</div>
				</nav>
			</div>
		</div>


		<!-- Carousel -->
		<div id="myCarousel" ng-model="carousel"
			class="carousel slide carouselAnimDown" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img class="first-slide"
						src="http://www.microtraceminerals.com/fileadmin/_migrated/pics/head_blood_test02.jpg"
						alt="First slide" />
					<div class="container">
						<div class="carousel-caption">
							<h1>Hackaton - Free Blood Test</h1>
							<p>
								Free Blood Test for the firsts <code>three</code> hackers to put down this server.
							</p>
							<p>
								<button class="btn btn-lg btn-primary" role="button">Try Today</button>
							</p>
						</div>
					</div>
				</div>
				<div class="item">
					<img class="second-slide"
						src="http://www.bestliferates.org/wp-content/uploads/2015/04/life-insurance-blood-test-1024x289.jpg"
						alt="Second slide" />
					<div class="container">
						<div class="carousel-caption">
							<h1>Epic Blood Donation!</h1>
							<p>One of the bigger men in the world, provided the amazing value of 9 Liters of Blood!</p>
							<p>
								 
							</p>
						</div>
					</div>
				</div>
				<div class="item">
					<img class="third-slide"
						src="http://www.bayhillcathospital.com/uploads/2/7/1/9/27195259/8881826_orig.jpg"
						alt="Third slide" />
					<div class="container">
						<div class="carousel-caption">
							<h1>Cats to be put inside the Clinic to bring happiness</h1>
							<p>One of the best (of the worst, actually) ideas ever: What's better than a cat to bring happiness, and other virus inside? </p>
							<p>
								
							</p>
						</div>
					</div>
				</div>
			</div>
			<a class="left carousel-control" href="#myCarousel" role="button"
				data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel" role="button"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
		<!-- /.carousel -->


		<!-- Featurettes-->

		<div id="HTMLContainer" class="container marketing"></div>
		<!-- /.container -->
		<footer>
			<p class="pull-right">
				<a href="#">Back to top</a>
			</p>
			<p>
				2015 Company, Inc. <a href="#">Privacy</a> <a href="#">Terms</a>
			</p>
		</footer>

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
		<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
		<script src="${pageContext.request.contextPath}/js/holder.min.js"></script>
	</div>
</body>
</html>