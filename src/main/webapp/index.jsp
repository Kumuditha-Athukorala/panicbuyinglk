<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<!-- Bootstrap CSS -->
	<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
	
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<!--Flex Slider Css-->
    <link rel="stylesheet" type="text/css" href="static/css/flexslider.css">
    <!--Main CSS-->
    <link rel="stylesheet" type="text/css" href="static/css/main.css">

</head>
<body>
	<%@include file="menubar.jsp"%>
	<%@include file="slider.jsp"%>
	<br>
	<div id="search-bar" class="input-group">
		<input class="form-control border-secondary py-2" type="search"
			value="search">
		<div class="input-group-append">
			<button class="btn btn-outline-secondary" type="button">
				<i class="fa fa-search"></i>
			</button>
		</div>
	</div>
	<hr/>
	<nav id="category-bar" class="navbar navbar-expand-lg navbar-dark bg-dark">	
		<a href="#" class="navbar-brand">Categories</a>
	</nav>

</body>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>

    <!-- Flex Slider Scripts-->
    <script src="static/js/jquery-1.11.0.min.js"></script>
    <script src="static/js/jquery.gmap3.min.js"></script>
    <script src="static/js/main.js"></script>
    <script src="static/js/plugins.js"></script>

</html>
