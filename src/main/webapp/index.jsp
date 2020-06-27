<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

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
	<hr />
	<div id="category-bar">
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<a href="#" class="navbar-brand">Categories</a>
		</nav>
	</div>
	<div id="category-list" class="row">
		<div class="col-sm-2">
			<div class="list-group" id="list-tab" role="tablist">
				<a class="list-group-item list-group-item-action active"
					id="list-home-list" data-toggle="list" href="#list-home" role="tab"
					aria-controls="home">Shop All</a> <a
					class="list-group-item list-group-item-action"
					id="list-profile-list" data-toggle="list" href="#list-profile"
					role="tab" aria-controls="profile">Bakery Items</a> <a
					class="list-group-item list-group-item-action"
					id="list-messages-list" data-toggle="list" href="#list-messages"
					role="tab" aria-controls="messages">Grocery Items</a> <a
					class="list-group-item list-group-item-action"
					id="list-settings-list" data-toggle="list" href="#list-settings"
					role="tab" aria-controls="settings">Fast Food</a> <a
					class="list-group-item list-group-item-action"
					id="list-settings-list" data-toggle="list" href="#list-fassion"
					role="tab" aria-controls="settings">Fashion Accessories</a>
			</div>
		</div>
		<div class="col-sm-10">
			<div class="tab-content" id="nav-tabContent">
				<div class="tab-pane fade show active" id="list-home"
					role="tabpanel" aria-labelledby="list-home-list">...</div>
				<div class="tab-pane fade" id="list-profile" role="tabpanel"
					aria-labelledby="list-profile-list">...gggggg</div>
				<div class="tab-pane fade" id="list-messages" role="tabpanel"
					aria-labelledby="list-messages-list">...</div>
				<div class="tab-pane fade" id="list-settings" role="tabpanel"
					aria-labelledby="list-settings-list">kkkkkkkkkkkkkkkkkkk</div>
				<div class="tab-pane fade" id="list-fassion" role="tabpanel"
					aria-labelledby="list-settings-list">zzzzzzzzzzzzzzz</div>
			</div>
		</div>
	</div>

	<div id="about-us" class="row">
		<div class="col-sm-1"></div>
		<div class="col-sm-10">
		<h5>ABOUT PanicBuying-LK</h5>
        <p>
        Panicbuyinglk is one of the latest web application which is built by Alpha-Dev, 
        software Development Company in Sri Lanka. The purpose of this project is to provide the online purchasing ability
        for most of the grocery products such as beverages, fruits, vegetables, meat, grocery, household, and 
        pharmacy during this COVID-19 pandemic situation. Customers facilitate with variety of services 
        which generally available in an e-commerce application. They can easily create and manage their profiles
        and can order whatever the products as per their need. The web application panicbuyinglk is 
        capable of managing all the details of products and manage customer orders.
        </p>
        <h5>CONTACT US</h5>        
        <p>
            Alpha-Dev is located on 23-1, Temple Road, Colombo 11 near of Mahawila Gardens. Produce
            sourced from the best native suppliers, great food and ambience at PanicBuyingLK.
        </p>
        <h5> OUR ADDRESS </h5>
        <p>
            23-1, Temple Road, Colombo 11.
        </p>
        <h5> OUR PHONE</h5>
        <p>
            Office Telephone :+94 714811893
        </p>
        <h5>OUR EMAIL</h5>
        <p>
            Main Email : info@panicbuyinglk.com
        </p>	
        
		</div>
		
	</div>
	
	<div class=" footer">
    <div class="container f_container">
        <p id="footer-section" class="f_para">All Rights Reserved - Powered By PanicBuying-LK</p>
    </div>

</div>
</body>

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

</html>
