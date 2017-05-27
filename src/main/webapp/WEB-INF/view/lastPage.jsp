<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="resource/css/mystyle.css">
<link rel="stylesheet" href="resource/img/im.jpg">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
 
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>





<div class="container">
  <div class="jumbotron">
   <i class="fa fa-thumbs-up" style="font-size:118px;color:red"aria-hidden="true"></i> <h1>Success</h1>
    <h3>THANKYOU FOR SHOPPING WITH GreatBillon DEAl</h3>
    <h4>HAPPY TO HAVE YOU PLZS VISIT AGAIN</h4>
    
    <br>
    <br>
    
    
   <p>You Package is in Process</p>      
  <p>Expected Delivery in 10-15 working Days</p> 
   <a href="<c:url value= '/'/>">
						<button type="button" class="btn btn-default">
							<span class="glyphicon glyphicon-shopping-cart"></span> Continue
							Shopping
						</button>
	</a>
   
   
  </div>
       
</div>








</body>
</html>