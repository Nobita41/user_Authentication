<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.userBeans.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Page</title>
<style>
* {
	margin: 0px;
	padding: 0px;
	border: border-box;
}

.outer {
	display: flex;
	justify-content: center;
	align-items: center;
	min-height: 100vh;
	width: 100%;
	background: url(/UserAuthentication/images/bg.jpg);
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}

.form {
	width: 450px;
	height: 450px;
	display: flex;
	align-items: center;
	justify-content: center;
	background: transparent;
	border: 2px solid rgba(255, 255, 255, 0.5);
	border-radius: 20px;
	backdrop-filter: blur(15px);
}

h2 {
	font-size: 2em;
	text-align: center;
	color: #fff;
}

.id {
	position: relative;
	width: 300px;
	margin: 30px 0;
	border-bottom: 2px solid white;
}

.id label {
	position: absolute;
	top: 50%;
	left: 5px;
	transform: translateY(-50%);
	color: white;
	font-size: 1em;
	pointer-events: none;
	transition: -5px;
}

input:focus ~ label, input:valid ~ label {
	top: -5px;
}

.id input {
	width: 100%;
	height: 50px;
	background-color: transparent;
	border: none;
	outline: none;
	font-size: 1em;
	padding: 0 35px 0 5px;
	color: white;
}

.forget {
	margin: -15px 0 15px;
	font-size: .9em;
	color: white;
	display: flex;
	justify-content: center;
}

.forget label input {
	margin-right: 3px;
}

.forget label a {
	color: white;
	text-decoration: none;
}

.forget label a:hover {
	text-decoration: underline;
}

button {
	width: 80px;
	height: 40px;
	border-radius: 50%;
	border: none;
	font-size: 1em;
	font-weight: 600;
	text-align: center;
	background: white;
}

.submit {
	display: float;
	justify-content: center;
	align-items: center;
}
</style>
</head>

<body>


<%
// data fetching from databases
UserRegistrationBeans mem=(UserRegistrationBeans)session.getAttribute("loginpass");
if(mem==null){
	
	response.sendRedirect("userLogin.jsp");
	
}
%>
<%
	String message= (String)request.getAttribute("msg");
	if(message!=null){
	%>
	<h1><%=message%></h1>
	<%} %>

	<form action="userEditProfile" method="post">

		<div class="outer">
			<div class="form">
				<div class="formelement">
					<div class="heading">
						<h2 style="color: #fff">Edit Profile</h2>
					</div>

					<div class="id">
						<input type="text" name="userName" value="<%=mem.getName()%>"> <label for="name" >Name</label>

					</div>
					<div class="id">
						<input type="text" name="userEmail" value="<%=mem.getEmail()%>"> <label for="email" >Email</label>

					</div>
					<div class="id">
						<input type="password" name="userPassword" value="<%=mem.getPassword()%>"> <label
							for="password">password</label>

					</div>

					<div class="submit">
						<button type="submit">Save</button>

					</div>

				</div>
			</div>
		</div>

	</form>
	
</body>
</html>