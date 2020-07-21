<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<!--Flex Slider Css-->
<link rel="stylesheet" type="text/css" href="static/css/flexslider.css">
<!--Main CSS-->
<link rel="stylesheet" type="text/css" href="static/css/main.css">
</head>
<body>

	<%@include file="menubar.jsp"%>

	<div class="row" style="margin: 0; padding: 0; padding-bottom: 10px;"
		xmlns="">
		<div class="col-sm-4"></div>
		<div class="col-sm-4">
			<h2 style="text-align: center;">User Login</h2>
			<form method="POST">
				<div class="form-group">
					<label for="email">Email:</label> <input type="email"
						class="form-control" id="email" placeholder="Enter email"
						name="email">
				</div>
				<div class="form-group">
					<label for="pwd">Password:</label> <input type="password"
						class="form-control" id="pwd" placeholder="Enter password"
						name="pwd">
				</div>
				<div class="message">
					<label id="login-message" style="color: red;"></label>
				</div>

				<button type="button" class="btn btn-primary"
					onclick="return checkLoginForm();">Login</button>
				<button type="button" class="btn btn-danger"
					onclick="cancelLoginForm();">Cancel</button>
				
			</form>

		</div>
		<div class="col-sm-4"></div>
	</div>


	<%@include file="footer.jsp"%>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous" type="text/javascript"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous" type="text/javascript"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous" type="text/javascript"></script>

	<!-- Flex Slider Scripts-->
	<script src="static/js/jquery-1.11.0.min.js" type="text/javascript"></script>
	<script src="static/js/jquery.gmap3.min.js" type="text/javascript"></script>
	<script src="static/js/main.js" type="text/javascript"></script>
	<script src="static/js/plugins.js" type="text/javascript"></script>

	<script src="static/js/user-login.js" type="text/javascript"> </script>
</body>
</html>