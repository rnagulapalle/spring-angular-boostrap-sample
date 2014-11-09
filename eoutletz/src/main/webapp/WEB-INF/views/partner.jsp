<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Login</title>
	</head>
	<body>
	  <div class="container">
	  	
		  <div class="panel-body prodlist-body" >
		  <c:if test="${not empty message}">
		  	<p class="success">${message}</p>
		  </c:if>
		  <h2>Welcome ${partner.name}, your product list</h2>
			  <div class="prodlist">
				  <c:if test="${not empty partner.products}">
				  
					<ul>
						<c:forEach var="product" items="${partner.products}">
							<!-- href to prod edit page-->
							<a href="/product/${product.id}"><li>${product.name}</li></a>
						</c:forEach>
					</ul>
			 
				</c:if>
			  <div>
			  
		  </div>
      </div>
	</body>
</html>