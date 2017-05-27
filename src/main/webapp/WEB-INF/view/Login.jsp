<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="resource/css/mystyle.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>



</head>
<body>


 
<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Please sign in</h3>
					</div>
					<div class="panel-body">
						
							<div class="alert alert-danger">
								<div class="text-center">
								Login Here
							</div></div>
							
						<%-- 	<c:url var="action" value="/validate"></c:url>
	                         <c:url var="action" value="j_spring_security_check"></c:url>
	                           <c:url var="action" value="/Login"></c:url>
	                           	<form name="Login" action="${action}" method="GET"> --%>
						
						<form action="validate" >
							<fieldset>
								<div class="form-group">
									<input class="form-control" placeholder="User Name"
										 type="text" id="id" name="id">
								</div>
 
								<div class="form-group">
									<input class="form-control" placeholder="Password"  type="password" value="" 
									 id="password" name ="password">
								</div>
 
								<input class="btn btn-lg btn-success btn-block" type="submit" value="Login">
 
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>


 
 
 
 
 
 <%-- <div class="col-md-6 col-md-offset-3">
				<div class="panel panel-login">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-6">
								<a href="#" class="active" id="login-form-link">Login</a>
							</div>
							<div class="col-xs-6">
								<a href="" id="register-form-link">Register</a>
							</div>
						</div>
						<hr>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
							<c:url var="addAction" value="j_spring_security_check?${_csrf.parameterName}=${_csrf.token}"></c:url>
								<form id="login-form" action="${addAction}" method="post" role="form" style="display: block;">
									<div class="form-group">
										<input type="text" name="id" id="id" tabindex="1" class="form-control" placeholder="Username" value="" required>
									</div>
									<div class="form-group">
										<input type="password" name="password" id="password" tabindex="2" class="form-control" placeholder="Password" required>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="Log In">
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="row">
										</div>
									</div>
								</form>
								<c:url var="addAction" value="register"></c:url>
	 									<form:form action="${addAction}" method="post" commandName="form-reg">
								<form id="register-form" action="${addAction}"  role="form" style="display: none;">
									<div class="form-group">
										<input type="text" name="id" id="id"  tabindex="1" class="form-control" placeholder="Userid" value="">
									</div>
									<div class="form-group">
										<input type="name" name="name" id="name" tabindex="1" class="form-control" placeholder="Name" value="">
									</div>
									<div class="form-group">
										<input type="password" name="password" id="password" tabindex="2" class="form-control" placeholder="Password">
									</div>
									<div class="form-group">
										<input type="text" name="contact"  tabindex="2" class="form-control" placeholder="Contact">
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="register-submit" id="register-submit" tabindex="4" class="form-control btn btn-register" value="Register Now">
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>


 --%>




	


</body>
</html>