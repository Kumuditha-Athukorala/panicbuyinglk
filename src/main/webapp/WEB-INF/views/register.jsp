<%@page import="com.panicbuyinglk.springmvc.entity.UserType"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
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
	
		<div class="row" style="margin: 0; padding: 0;">
			<div class="col-sm-4"></div>
    <div class="col-sm-4">
        <h2 style="text-align: center;">Register with PanicBuying-LK</h2>
        <form>
            <div class="form-group">
                <label for="fname">First Name:</label>
                <input type="text" class="form-control" id="fname" placeholder="Enter First Name" name="fname" required>
            </div>

            <div class="form-group">
                <label for="lname">Last Name:</label>
                <input type="text" class="form-control" id="lname" placeholder="Enter Last Name" name="lname" required>
            </div>

            <div class="form-group">
                <label for="gender">Gender:</label>
                <select class="form-control" id="sel1" name="gender" required>
                    <option value="Male">Male</option>
                    <option value="Female">Female</option>
                </select>
            </div>
            
            <div class="form-group">
                <label for="usertype">User Type:</label>
                <select class="form-control" id="sel2" name="usertype" required>
                <%
                ArrayList<UserType> userTypeList = (ArrayList<UserType>)request.getAttribute("userTypes");                
                for(UserType ut:userTypeList){           
                %>
                 <option value="<% out.write(ut.getType()); %>"><% out.write(ut.getType()); %></option>            
                 <% } %>   
                </select>
            </div>
            

            <div class="form-group">
                <label for="cnumber">Contact Number:</label>
                <input type="number" class="form-control" id="cnumber" placeholder="Enter Contact Number" name="cnumber"
                    required>
            </div>

            <div class="form-group">
                <label for="address">Address:</label>
                <textarea class="form-control" rows="5" id="address" placeholder="Enter Address" name="addr" required></textarea>
            </div>

            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control" id="email" placeholder="Enter Email" name="email" required>
            </div>
            <div class="form-group">
                <label for="pwd">Password:</label>
                <input type="password" class="form-control" id="pwd" placeholder="Enter Password" name="pwd" required>
            </div>
            <div class="form-group">
                <label for="rpwd">Reenter Password:</label>
                <input type="password" class="form-control" id="repwd" placeholder="Reenter Password" name="repwd"
                    required>
            </div>
            <div class="form-group">
                <label id="register-message" style="color: red;"></label>
            </div>
            <button type="button" class="btn btn-primary" onclick="return checkCustomerRegistration()">Submit</button>
            <button type="button" class="btn btn-danger" onclick="cancelRegisterForm()">Cancel</button>
        </form>
    </div>
    <div class="col-sm-4"> </div>
		</div>
	
	<%@include file="footer.jsp"%>
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

<script src="static/js/user-registration.js" type="text/javascript"></script>
</html>