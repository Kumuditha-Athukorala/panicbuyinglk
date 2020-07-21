
<%@page import="com.panicbuyinglk.springmvc.entity.User"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a href="index" class="navbar-brand">PanicBuyingLK</a>
	<button class="navbar-toggler" data-toggle="collapse"
		data-target="#navbarMenu">
		<span class="navbar-toggler-icon"> </span>
	</button>

	<div class="collaps navbar-collapse" id="navbarMenu">
		<ul class="navbar-nav ml-auto">

			<%
				User u = (User) request.getSession().getAttribute("loggedUser");
				if (null != u) {
			%>
			<li class="nav-item"><a href="#" class="nav-link">Hi <%  out.print(u.getFirstName()); %></a></li>
			<li class="nav-item"><a href="logout" class="nav-link">Logout</a></li>
			<%
				} else {
			%>
			<li class="nav-item"><a href="register" class="nav-link">Register</a></li>
			<li class="nav-item"><a href="login" class="nav-link">log-In</a></li>

			<%
				}
			%>
			<li class="nav-item"><a href="#" class="nav-link">Products</a></li>
			<li class="nav-item"><a href="#" class="nav-link">Cart</a></li>
		</ul>
	</div>
</nav>