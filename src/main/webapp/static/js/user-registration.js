function checkCustomerRegistration() {

    document.getElementById("register-message").innerHTML = "";
    var fname = document.getElementById("fname").value;
    var lname = document.getElementById("lname").value;
    var gender = document.getElementById("sel1").value;
    var utype = document.getElementById("sel2").value;
    var phone = document.getElementById("cnumber").value;
    var address = document.getElementById("address").value;
    var email = document.getElementById("email").value;
    var password = document.getElementById("pwd").value;
    var conpswd = document.getElementById("repwd").value;

    console.log(fname, lname, gender, utype ,phone, address, email,
        password, conpswd);

    if (fname == null || fname == "" || lname == null || lname == "" || gender == null || gender == "" || utype == "" || utype == null || phone == null || phone == "" ||
        address == null || address == "" || email == null || email == "" || password == null || password == "" || conpswd == null || conpswd == "") {

        document.getElementById("register-message").innerHTML = "Please Fill All the Details...!";
        return false;

    } else if (!alphanumeric(fname)) {
        document.getElementById("register-message").innerHTML = "First Name is invailed...!";
        return false;
    } else if (!alphanumeric(lname)) {
        document.getElementById("register-message").innerHTML = "Last Name is invailed...!";
        return false;
    } else if (fname.length > 25) {
        document.getElementById("register-message").innerHTML = "First Name is too long...!";
        return false;
    } else if (lname.length > 25) {
        document.getElementById("register-message").innerHTML = "Last Name is too long...!";
        return false;
    } else if (address.length > 250) {
        document.getElementById("register-message").innerHTML = "Address is too long...!";
        return false;
    } else if (!validatePhoneNumber(phone)) {
        document.getElementById("register-message").innerHTML = "Invalied Phone Number...!";
        return false;
    } else if (!validateEmail(email)) {
        document.getElementById("register-message").innerHTML = "Invalied Email Address...!";
        return false;
    } else if (password.length <= 7 || password.length >= 17) {
        document.getElementById("register-message").innerHTML = "Password must be 8-16 characters long...!";
        return false;
    } else if (password != conpswd) {
        document.getElementById("register-message").innerHTML = "Passwords are not matching...!";
        return false;
    } else { 
    	
    	  var registerData = {        		
    	    		"firstName":fname,
    	    		"lastName":lname,
    	    		"gender":gender,
    	    		"utype" : utype,
    	    		"phone":phone,
    	    		"address":address,
    	    		"email":email,
    	    		"password":password,
    	    		"conpassword":conpswd        		
    	    }

    	$.ajax({
    		type : "POST",
    		contentType : "application/json",
    		url : "checkEmail",
    		data : JSON.stringify(registerData),
    		dataType : 'json',				
    		success : function(response) {    			
    			console.log(response);
    			if(true == response){
    				registerUser(registerData);
    			}else{
    				document.getElementById("register-message").innerHTML = "Given Email is Already Exixting with a User Account...!";
    				return false;
    			}
    			
    		}    			
    		
    	}); 	
    	
               
    }
    
}


function registerUser(registerData){
	
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "registerUser",
		data : JSON.stringify(registerData),
		dataType : 'json',				
		success : function(response) {
			
			console.log(response);
			
			if(true == response){
				alert("You have sucessfully registterd with PanicbuyingLK");
				window.location.href = "/";
			}else{
				alert("User Registration is Unseccessful..!");
				window.location.href = "/register";
			}
			
		}    			
		
	});
}



function validatePhoneNumber(phone) {
    var phoneno = /^\+?([0-9]{2})\)?[-. ]?([0-9]{4})[-. ]?([0-9]{4})$/;
    if (phoneno.test(phone)) {
        return true;
    } else {
        return false;
    }
}

function validateEmail(mail) {
    if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(mail)) {
        return true;
    }
    return false;
}

function alphanumeric(input) {
    return /^[a-zA-Z-,]+(\s{0,1}[a-zA-Z-, ])*$/.test(input)
}


function cancelRegisterForm() {
    alert("Do You Want To Cancel The Registration?");
    window.location.href = "/";
}