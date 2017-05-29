<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
#Address
{
    width: 80%;
    margin-left: 102px;
}
.panel-info>.panel-heading {
    color: #3F51B5;
    background-color: #FFEB3B;
    border-color: #FFEB3B;
}
.panel-body {
    padding: 15px;
    width: 84%;
    margin-left: 71px;
}
.form-group {
    margin-bottom: 15px;
    color: brown;
}
#ad{
    font-weight: 700;
   font-size: 28px;
}
</style>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="resource/css/mystyle.css">
<link rel="stylesheet" href="resource/img/im.jpg">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
 
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>


<!-- ----------------------------------***********------------------------------------ -->	
						
	
<%-- <span><i class="fa fa-taxi" style="font-size:48px;color:red"></i></span><strong id="ad"> ADDRESS</strong>

<div class ="container-fluid  second_bar" style="background:#00ffff; solid; padding:20px;" >
<div class="container">







<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title ">Shipping Address</h3>
					</div>
					<div class="panel-body">
						
							</div>
<form action="CheckoutPage"  method="POST"  commandName="orders" >
		<fieldset>
		<div class="form-group">
         <input class="form-control" placeholder="Full-Name"
		type="text" id="full_name" name="id" autofocus>
	    </div>
	    
	    
	    <div class="form-group">
         <input class="form-control" placeholder="Address"
		type="text" id="address" name="name">
	    </div>
	    
	    <div class="form-group">
         <input class="form-control" placeholder="City"
		type="text" id="city" name="name">
	    </div>
	    
	    <div class="form-group">
         <input class="form-control" placeholder="State"
		type="text" id="state" name="name">
	    </div>
	    
	    <div class="form-group">
         <input class="form-control" placeholder="Country"
		type="text" id="country" name="name">
	    </div>
	    
	    <div class="form-group">
         <input class="form-control" placeholder="Zip-code/Pin-code"
		type="text" id="zip_code" name="name">
	    </div>
	    
	    <div class="form-group">
         <input class="form-control" placeholder="Phone-Number"
		type="text" id="phone_number" name="name">
	    </div>
	    
	    <div class="form-group">
         <input class="form-control" placeholder="Email-Address"
		type="text" id="email" name="name">
	    </div>
	    
	    
	    <!-- ================================================ -->
	    <!-- 
	    <span><i class="glyphicon glyphicon-lock"></i></span><strong id="ad"> Secure
							Payment</strong> -->
							
							
							
		                  <div class="form-group">
								<div class="col-md-12">
									<strong>Card Type:</strong>
								</div>
								<div class="col-md-12">
									<select id="CreditCardType" name="CreditCardType"
										class="form-control" id="card_type">
										<option value="5">Visa</option>
										<option value="6">MasterCard</option>
										<option value="7">American Express</option>
										<option value="8">Discover</option>
									</select>
								</div>
							</div>
							
							
							<div class="form-group">
								<div class="col-md-12">
									<strong>Credit Card Number:</strong>
								</div>
								<div class="col-md-12">
									<input type="text" class="form-control" name="car_number"
										value="" id="card_number"/>
								</div>
							</div>
							
							
							<div class="form-group">
								<div class="col-md-12">
									<strong>Card CVV:</strong>
								</div>
								<div class="col-md-12">
									<input type="text" class="form-control" name="car_code"
										value="" id="card_cvv"/>
								</div>
							</div>
							
							
							
							<div class="form-group">
								<div class="col-md-12">
									<strong>Expiration Date</strong>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<select class="form-control" name="" id="ex_month">
										<option value="">Month</option>
										<option value="01">01</option>
										<option value="02">02</option>
										<option value="03">03</option>
										<option value="04">04</option>
										<option value="05">05</option>
										<option value="06">06</option>
										<option value="07">07</option>
										<option value="08">08</option>
										<option value="09">09</option>
										<option value="10">10</option>
										<option value="11">11</option>
										<option value="12">12</option>
									</select>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<select class="form-control" name="" id="ex_year">
										<option value="">Year</option>
										<option value="2015">2015</option>
										<option value="2016">2016</option>
										<option value="2017">2017</option>
										<option value="2018">2018</option>
										<option value="2019">2019</option>
										<option value="2020">2020</option>
										<option value="2021">2021</option>
										<option value="2022">2022</option>
										<option value="2023">2023</option>
										<option value="2024">2024</option>
										<option value="2025">2025</option>
									</select>
								</div>
							</div>
							
							
							<div class="form-group">
								<div class="col-md-12">
									<span>Pay secure using your credit card.</span>
								</div>
								<div class="col-md-12">
									<ul class="cards">
										<li class="visa hand">Visa</li>
										<li class="mastercard hand">MasterCard</li>
										<li class="amex hand">Amex</li>
									</ul>
									<div class="clearfix"></div>
								</div>
							</div>					
	    
	    
	    <!-- ================================================= -->
	    
	    
	    <!-- <input class="btn btn-lg btn-success btn-block" type="submit" name="action" id="submit"  value="submit"> -->
	    
	    <a href="<c:url value= '/CheckoutPage'/>">
									<button  class="btn btn-success btn-submit-fix">Save & Next-Page
										
									</button>
								</a>


</fieldset></form>	    
</div></div>
</div></div>


 --%>





	
						
<!-- ----------------------------------***********------------------------------------ -->
	<!-- 					</div>
						</section>
					</div>
					
</section>

		<div class="row cart-footer"></div>
	</div> -->






<!-- for next page -->

                          <%-- <div class="form-group text-center">
								<div class="col-md-6 col-sm-6 col-xs-12">
								<a href="<c:url value= '/CheckoutPage'/>">
									<button  class="btn btn-success btn-submit-fix">Save & Next-Page
										
									</button>
								</a>	
								</div>
 --%>

<!-- end of next page -->


<h2>Please fill the details</h2>
     <!--  Before comming to this page, you have to add  userDetails in ModelAndView object-->
	<form:form action="Checkout" method="POST" commandName="orders">
		<table>
		
		<tr>
				<td>full_name<form:label path="full_name">
						<spring:message text="full_name" />
					</form:label></td>

				<td><form:input path="full_name" pattern="" required="true"
				        placeholder =" "
						title="id should contains 4 to 15 characters" /></td>
			</tr>
			<tr>
				<td>address<form:label path="address">
						<spring:message text="address" />
					</form:label></td>

				<td><form:input path="address" pattern="" required="true"
				        placeholder ="address"
						title="id should contains 4 to 15 characters" /></td>
			</tr>
			<tr>
				<td>email<form:label path="email">
						<spring:message text="email" />
					</form:label></td>

				<td><form:input path="email" required="true"
				placeholder ="enter your email" minlength="" maxlenth=""
						title="Street should not be empty" /></td>
			</tr>
			<tr>
				<td>city<form:label path="city">
						<spring:message text="city" />
					</form:label></td>

				<td><form:input type="city" path="city" pattern=""
						required="true" placeholder="enter you City"
						title="password should contains 1 to 45 characters" /></td>
			</tr>
			<tr>
				<td>State<form:label path="state">
						<spring:message text="state" />
					</form:label></td>

				<td><form:input type="tel" path="state" pattern="" required="true"
						title="Please enter State" /></td>
			</tr>

			<tr>
				<td> ZIP-PIncode :

				<td><form:input type="zip_code" path="zip_code" /></td>
			</tr>
			<tr>
			<td>country<form:label path="country">
						<spring:message text="country" />
					</form:label></td>

				<td><form:input type="tel" path="country" pattern="" required="true"
						title="Please enter country name" /></td>
			</tr>
			<tr>
			<td>phone_number<form:label path="phone_number">
						<spring:message text="phone_number" />
					</form:label></td>

				<td><form:input type="" path="phone_number" pattern="" required="true"
						title="Please enter phone_number" /></td>
			</tr>
			<tr>
			<td>card_type<form:label path="card_type">
						<spring:message text="card_type" />
					</form:label></td>

				<td><form:input type="" path="card_type" pattern="" required="true"
						title="Please enter valid contact number" /></td>
			</tr>
			<tr>
           <td>card_number<form:label path="card_number">
						<spring:message text="card_number" />
					</form:label></td>

				<td><form:input type="tel" path="card_number" pattern="" required="true"
						title="Please enter valid Card number" /></td>
			</tr>
			<tr>
			 <td>card_cvv<form:label path="card_cvv">
						<spring:message text="card_cvv" />
					</form:label></td>

				<td><form:input type="tel" path="card_cvv" pattern="" required="true"
						title="Please enter valid Cvv number" /></td>
			</tr>
			<tr>
			<td>ex_month<form:label path="ex_month">
						<spring:message text="ex_month" />
					</form:label></td>

				<td><form:input type="tel" path="ex_month" pattern="" required="true"
						title="Please enter ExpiryDate" /></td>
			</tr>
			<tr>
			<td>ex_year<form:label path="ex_year">
						<spring:message text="ex_year" />
					</form:label></td>

				<td><form:input type="tel" path="ex_year" pattern="" required="true"
						title="Please enter ExpiryDate" /></td>
			</tr>
		
			<tr>

				<td><input type="submit" id="submit" name="submit" 
					value="submit"/></td>
				<td><input type="reset" value="RESET"Reset"/>
				</td>
				
			
			</tr>

		</table>

	</form:form>

 


</body>
</html>