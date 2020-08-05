	<%@page import="org.apache.tomcat.util.codec.binary.Base64"%>
<%@page import="com.panicbuyinglk.springmvc.entity.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.panicbuyinglk.springmvc.service.ProductService"%>
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
					aria-controls="home">Shop All</a> 
				<a class="list-group-item list-group-item-action"
					id="list-profile-list" data-toggle="list" href="#list-profile"
					role="tab" aria-controls="profile">Fruits</a> 
				<a class="list-group-item list-group-item-action"
					id="list-messages-list" data-toggle="list" href="#list-messages"
					role="tab" aria-controls="messages">Vegetables</a> 
				<a class="list-group-item list-group-item-action"
					id="list-settings-list" data-toggle="list" href="#list-settings"
					role="tab" aria-controls="settings">Dairy Products</a> 
				<a class="list-group-item list-group-item-action"
					id="list-settings-list" data-toggle="list" href="#list-fassion"
					role="tab" aria-controls="settings">Fashion Accessories</a>
			</div>
		</div>
		<div class="col-sm-10">
		<div class="tab-content" id="nav-tabContent">
			<div class="tab-pane fade show active" id="list-home" role="tabpanel"
				aria-labelledby="list-home-list">	
				
				<div class="row">
				<% 
					ArrayList<Product> prlist = (ArrayList<Product>)request.getAttribute("productList"); 
					String url;
					int i=0;
					for(Product p : prlist){
						i++;
						url = "data:image/png;base64," + Base64.encodeBase64String(p.getImage());
						
				%>
					<div class="col">
					<table>
						<tbody style="text-align: center;">
						<br>
							<tr><img width="250px" height="200px" alt="#" src="<%=url%>"></tr> <br>
							<tr><%=p.getProductName() %></tr><br>
							<tr>&euro;<%=p.getUnitPrice() %></tr><br>
						</tbody>
					</table>
					
					</div>
					<% 
					if(i >= 4){
					%>
					<div class="w-100"></div>
					<% } %>
				<% } %>
				</div>	
			
			</div>
			<div class="tab-pane fade" id="list-profile" role="tabpanel"
				aria-labelledby="list-profile-list">
				<div class="row">
				<% 
					ArrayList<Product> fruits = (ArrayList<Product>)request.getAttribute("listOfFruits"); 
					int j=0;
					for(Product p : fruits){
						j++;
						url = "data:image/png;base64," + Base64.encodeBase64String(p.getImage());
						
				%>
					<div class="col">
					<table>
						<tbody style="text-align: center;">
						<br>
							<tr><img width="250px" height="200px" alt="#" src="<%=url%>"></tr> <br>
							<tr><%=p.getProductName() %></tr><br>
							<tr>&euro;<%=p.getUnitPrice() %></tr><br>
						</tbody>
					</table>
					
					</div>
					<% 
					if(j >= 4){
					%>
					<div class="w-100"></div>
					<% } %>
				<% } %>
				</div>
				
				</div>
			<div class="tab-pane fade" id="list-messages" role="tabpanel"
				aria-labelledby="list-messages-list">
				<div class="row">
				<% 
					ArrayList<Product> vegetables = (ArrayList<Product>)request.getAttribute("listOfVegitables"); 
					int k=0;
					for(Product p : vegetables){
						k++;
						url = "data:image/png;base64," + Base64.encodeBase64String(p.getImage());
						
				%>
					<div class="col">
					<table>
						<tbody style="text-align: center;">
						<br>
							<tr><img width="250px" height="200px" alt="#" src="<%=url%>"></tr> <br>
							<tr><%=p.getProductName() %></tr><br>
							<tr>&euro;<%=p.getUnitPrice() %></tr><br>
						</tbody>
					</table>
					
					</div>
					<% 
					if(k >= 4){
					%>
					<div class="w-100"></div>
					<% } %>
				<% } %>
				</div>				
				
				</div>
			<div class="tab-pane fade" id="list-settings" role="tabpanel"
				aria-labelledby="list-settings-list">
				
				<div class="row">
				<% 
					ArrayList<Product> diaryProducts = (ArrayList<Product>)request.getAttribute("listofDiaryProducts"); 
					int l = 0;
					for(Product p : diaryProducts){
						l++;
						url = "data:image/png;base64," + Base64.encodeBase64String(p.getImage());
						
				%>
					<div class="col">
					<table>
						<tbody style="text-align: center;">
						<br>
							<tr><img width="250px" height="200px" alt="#" src="<%=url%>"></tr> <br>
							<tr><%=p.getProductName() %></tr><br>
							<tr>&euro;<%=p.getUnitPrice() %></tr><br>
						</tbody>
					</table>
					
					</div>
					<% 
					if(l >= 4){
					%>
					<div class="w-100"></div>
					<% } %>
				<% } %>
				</div>				
				
				
				</div>
			<div class="tab-pane fade" id="list-fassion" role="tabpanel"
				aria-labelledby="list-settings-list"></div>
		</div>
	</div>
	</div>