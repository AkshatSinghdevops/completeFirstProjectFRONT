<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="resource/css/mystyle.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>



	<div class="container">

		<ul class="nav nav-pills" role="tablist">
			<c:forEach items="${categoryList}" var="category">
				<li class="dropdown">
				<a class="dropdown-toggle" data-toggle="dropdown" href="#">
				${category.name}
				<span class="caret"></span></a>


					<ul class="dropdown-menu" role="menu">
						<c:forEach items="${category.products}" var="product">
							<%-- <li><a href="manage_product/get/${product.id}">${product.name}</a></li><li></li> --%>
							   <li><a href="<c:url value= '/NavigationPro/${product.id }'/>">${product.name}</a></li><li></li>
						</c:forEach>
					</ul></li>
			</c:forEach>

		</ul>
	</div>
	<hr color="blue" width="100" >
	${category.products}


</body>
</html>