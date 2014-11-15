<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<title>eOutletz - Partner Details</title>
	</head>
	<body>
	  <div class="container">
	  	<div class="body-wrapper">
		  	  
	  		  <h4>Welcome ${partner.name}</h4>
		  	  
		  	  <h5 class="addproduct"><a href="/product">Add a product</a></h5>
			  <div class="panel-body prodlist-body" >
				  <c:if test="${not empty message}">
				  	<p class="success">${message}</p>
				  </c:if>
				  
			  <!-- Order list -->
			  <c:if test="${not empty orders}">	
			  	<div class="table-wrapper">
					  <div class="Table">
					    <div class="Title">
					    	<h5>Your order list</h5>
					    </div>
					    <div class="Heading">
					        <div class="Cell">
					            <p>OrderId</p>
					        </div>
					        <div class="Cell">
				            	<p>Status</p>
				            </div>
				           <div class="Cell">
			            		<p>Details</p>
			            	</div>
					        <div class="Cell">
					            <p>Action</p>
					        </div>
					    </div>
							<c:forEach var="order" items="${orders}">
								<div class="Row">
							        <div class="Cell">
							            <p>${order.id}</p>
							        </div>
							        <div class="Cell">
							        	<p>${order.orderStatus.status}</p>
						            </div>
						            <div class="Cell">
						            	<p><a href="/order/${order.id}">See Order</a></p>
						            </div>
							        <div class="Cell">
							        	<!-- show this only if status eq ordered-->
							            <p><a href="/order/status/${order.id}">Update Status</a></p>
							        </div>
						        </div>
							</c:forEach>		 
						</div>
					</div>
				</c:if> 
				
				<!-- Products list-->
			  <c:if test="${not empty products}">
			  	<div class="table-wrapper">
					 <div class="Table">
					    <div class="Title">
					    	<h5>Your product catelog</h5>
					    </div>
					    <div class="Heading">
					        <div class="Cell">
					            <p>Product Name</p>
					        </div>
					        <div class="Cell">
					            <p>Action</p>
					        </div>
					    </div>
							<c:forEach var="product" items="${products}">
								<!-- href to prod edit page-->
								<!--<a href="/product/${product.id}"><li>${product.name}</li></a>-->
								<div class="Row">
							        <div class="Cell">
							            <p>${product.name}</p>
							        </div>
							        <div class="Cell">
							            <p><a href="/product/${product.id}">Edit</a> &nbsp;
							            <a href="/clone/${product.id}">Clone</a> &nbsp;
							            <a href="/sale/${product.id}">Add To Sale</a></p>
							        </div>
						        </div>
							</c:forEach>		 
						</div>
					</div>
				</c:if> 
			 </div>
		 </div>
      </div>
	</body>
</html>