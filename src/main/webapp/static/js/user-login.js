function checkLoginForm() {

	document.getElementById("login-message").innerHTML = "";
	var uname = document.getElementById("email").value;
	var pswd = document.getElementById("pwd").value;

	if (uname == "" || pswd == "" || uname == null || pswd == null) {
		document.getElementById("login-message").innerHTML = "Please Enter the User Login Credentials...!";
		return false;
	} else if (!validateEmail(uname)) {
		document.getElementById("login-message").innerHTML = "Invalied Email Address...!";
		return false;
	} else if (pswd.length <= 7) {
		document.getElementById("login-message").innerHTML = "Password must be more than  8 characters long...!";
		return false;
	} else {
		loginData = {
			"email" : uname,
			"password" : pswd
		}
		var lgdata = JSON.stringify(loginData);
		$.ajax({
					type : "POST",
					contentType : "application/json",
					url : "logUser",
					data : JSON.stringify(loginData),
					dataType : 'json',
					success : function(response) {
						if (true == response) {
							window.location.href = "/index";
						} else {
							document.getElementById("login-message").innerHTML = "Invalied Login Credentials...!";
						}

					}
				});
	}
}

function cancelLoginForm() {
	window.location.href = "/index";
}

function validateEmail(mail) {
	if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(mail)) {
		return true;
	}
	return false;
}
