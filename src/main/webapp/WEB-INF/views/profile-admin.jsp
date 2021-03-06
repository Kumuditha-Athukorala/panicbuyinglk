<%@page import="org.apache.tomcat.util.codec.binary.Base64"%>
<%@page import="com.panicbuyinglk.springmvc.entity.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Administrator Profile</title>
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

<div class="row" style="margin: 0; padding: 0;" xmlns="">
    <div class="col-sm-4"></div>
    <div class="col-sm-4">
    
        <h2 style="text-align: center;">Administrator Panel - <% out.write(u.getFirstName() + " " + u.getLastName()); %></h2>

    </div>
    <div class="col-sm-4"> </div>
</div>


<div class="container" style="padding-bottom: 10px;">
    <div id="accordion">
        <div class="card">
            <div class="card-header" id="headingTwo">
                <h5 class="mb-0">
                    <button class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapsemyorders"
                        aria-expanded="false" aria-controls="collapseTwo">
                        View All Products
                    </button>
                </h5>
            </div>
            <div id="collapsemyorders" class="collapse table-responsive" aria-labelledby="headingTwo"
                data-parent="#accordion">
                <div class="card-body">
               
                    <table class="table table-bordered table-responsive">
                        <thead>
                            <tr>
                                <th scope="col">Product Name</th>
                                <th scope="col">Unit Price - LKR</th>
                                <th scope="col">Quantity</th>
                                <th scope="col">Image</th>
                                <th scope="col">Description</th>
                                <th scope="col">Status</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% 
                           ArrayList<Product> prlist = (ArrayList<Product>)request.getAttribute("productList");
                           String url; 
                            for(Product p : prlist){
                            	 url = "data:image/png;base64," + Base64.encodeBase64String(p.getImage());
                            %>
                            <tr>
                                <td><% out.write(p.getProductName()); %></td>							
								<td><% out.write(Double.toString(p.getUnitPrice())); %></td>
								<td><% out.write(Integer.toString(p.getQty())); %></td>
								<td><img width="250px" height="200px" alt="#" src="<% out.write(url); %>"></td>
								<td><% out.write(p.getDescription()); %></td>
								<td><% 
								 if (0 == p.getStatus()){   %>  
								 
									 <button type="button" class="btn btn-secondary" onclick="changeProductStatus(<%= p.getProductId() %>,<%= p.getStatus()%>)">Active</button>
		                                                 
								<% }else if(1 == p.getStatus()){ %>
									  <button type="button" class="btn btn-secondary"  onclick="changeProductStatus(<%= p.getProductId() %>,<%= p.getStatus()%>)">Deactive</button>
								<%	} 	%>		
								</td>								
                            </tr>
                         <% } %>
                        </tbody>
                    </table>
                   
                </div>
            </div>
        </div>


        <div class="card">
            <div class="card-header" id="updateDetails">
                <h5 class="mb-0">
                    <button class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapseUpdateDetails"
                        aria-expanded="false" aria-controls="collapseTwo">
                        Update My Details
                    </button>
                </h5>
            </div>
            <div id="collapseUpdateDetails" class="collapse table-responsive" aria-labelledby="updateDetails"
                data-parent="#accordion">
                <div class="card-body">
                    <div class="row" style="margin: 0; padding: 0;" xmlns="">
                        <div class="col-sm-4"></div>
                        <div class="col-sm-4">
                            <h2 style="text-align: center;">Update Customer Details</h2>
                            <form method="POST">
                                <div class="form-group">
                                    <label for="fname">First Name:</label>
                                    <input type="text" class="form-control" id="fname" placeholder="Enter First Name"
                                        name="fname" required>
                                </div>

                                <div class="form-group">
                                    <label for="lname">Last Name:</label>
                                    <input type="text" class="form-control" id="lname" placeholder="Enter Last Name"
                                        name="lname" required>
                                </div>

                                <div class="form-group">
                                    <label for="gender">Gender:</label>
                                    <select class="form-control" id="sel1" name="gender" required>
                                        <option value="Male">Male</option>
                                        <option value="Female">Female</option>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <label for="cnumber">Contact Number:</label>
                                    <input type="number" class="form-control" id="cnumber"
                                        placeholder="Enter Contact Number" name="cnumber" required>
                                </div>

                                <div class="form-group">
                                    <label for="address">Address:</label>
                                    <textarea class="form-control" rows="5" id="address" placeholder="Address"
                                        name="addr" required></textarea>
                                </div>

                                <div class="form-group">
                                    <label id="update-message" style="color: red;"></label>
                                </div>
                                <button type="button" class="btn btn-primary"
                                    onclick="return checkCustomerUpdates()">Update </button>
                                <button type="button" class="btn btn-danger"
                                    onclick="cancelUpdateForm()">Cancel</button>
                            </form>
                        </div>
                        <div class="col-sm-4"> </div>
                    </div>
                </div>
            </div>
        </div>


        <div class="card">
            <div class="card-header" id="changePassword">
                <h5 class="mb-0">
                    <button class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapsechangePW"
                        aria-expanded="false" aria-controls="collapseTwo">
                        Change Password
                    </button>
                </h5>
            </div>
            <div id="collapsechangePW" class="collapse table-responsive" aria-labelledby="changePassword"
                data-parent="#accordion">
                <div class="card-body">
                    <div class="row" style="margin: 0; padding: 0;" xmlns="">
                        <div class="col-sm-4"></div>
                        <div class="col-sm-4">
                            <h2 style="text-align: center;">Change Password</h2>
                            <form method="POST">
                                <div class="form-group">
                                    <label for="email">Email:</label>
                                    <input type="email" class="form-control" id="email" placeholder="Enter email"
                                        value="<% out.write(u.getEmail()); %>" name="email" readonly>
                                </div>
                                <div class="form-group">
                                    <label for="pwd">New Password:</label>
                                    <input type="password" class="form-control" id="pwd" placeholder="Enter Password"
                                        name="pwd" required>
                                </div>
                                <div class="form-group">
                                    <label for="rpwd">Reenter New Password:</label>
                                    <input type="password" class="form-control" id="repwd"
                                        placeholder="Reenter Password" name="repwd" required>
                                </div>
                                <div class="message">
                                    <label id="change-pw-message" style="color: red;"></label>
                                </div>


                                <button type="button" class="btn btn-primary" onclick="return changePassword();">Change
                                    Password</button>
                                <button type="button" class="btn btn-danger"
                                    onclick="cancelChangePassword();">Cancel</button>
                            </form>
                        </div>
                        <div class="col-sm-4"></div>
                    </div>
                </div>
            </div>
        </div>

    </div>

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

<script src="static/js/profile.js" type="text/javascript"></script>

</html>