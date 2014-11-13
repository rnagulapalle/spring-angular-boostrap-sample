<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Login</title>
	</head>
	<body>
	  <div class="container">
	  	<div class="body-wrapper">
		  	  <h1>Welcome ${partner.name}</h1>
		  	  <h2><a href="/product">Add a product</a></h2>
			  <div class="panel-body prodlist-body" >
			  <c:if test="${not empty message}">
			  	<p class="success">${message}</p>
			  </c:if>
			  <c:if test="${not empty partner.products}">	
			  <div class="Table">
			    <div class="Title">
			    	<h2>Your product catelog</h2>
			    </div>
			    <div class="Heading">
			        <div class="Cell">
			            <p>Product Name</p>
			        </div>
			        <div class="Cell">
			            <p>Action</p>
			        </div>
			    </div>
					<c:forEach var="product" items="${partner.products}">
						<!-- href to prod edit page-->
						<!--<a href="/product/${product.id}"><li>${product.name}</li></a>-->
						<div class="Row">
					        <div class="Cell">
					            <p>${product.name}</p>
					        </div>
					        <div class="Cell">
					            <p><a href="/product/${product.id}">Edit</a></p>
					            <p><a href="/clone/${product.id}">Clone</a></p>
					            <p><a href="/sale/${product.id}">Add To Sale</a></p>
					        </div>
				        </div>
					</c:forEach>		 
				</div>
				</c:if> 
			 </div>
		 </div>
      </div>
	</body>
</html>