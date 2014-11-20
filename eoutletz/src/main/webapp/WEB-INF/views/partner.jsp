<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>eOutletz - Partner Details</title>
</head>
<body>
	<div class="container">
		<div id="productuploadbox" style="margin-top: 50px"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<div class="panel panel-info">
				<div class="panel-body">

					<h4>Welcome ${partner.name}</h4>

					<h5 class="addproduct">
						<a href="/product">Add a product</a>
					</h5>
					<div class="panel-body prodlist-body">
						<c:if test="${not empty message}">
							<div id="logout-alert" class="alert alert-success">
								${message} 
	                		</div>
						</c:if>
						
						<!-- display incoming messages to seller-->
							<c:if test="${not empty inbox}">
							<div class="table-wrapper">
								<div class="Table">
									<div class="Title">
										<h5>Your messages list</h5>
									</div>
									<div class="Heading">
										<div class="Cell">
											<p>From</p>
										</div>
										<div class="Cell">
											<p>Subject</p>
										</div>
										<div class="Cell">
											<p>Action</p>
										</div>
									</div>
									<c:forEach var="message" items="${inbox}">
										<div class="Row">
											<div class="Cell">
												<p>${message.userFrom.firstName} ${message.userFrom.lastName}</p>
											</div>
											<div class="Cell">
												<p>${message.subject}</p>
											</div>
											
											<div class="Cell">
												<!-- show this only not read flag-->
												<c:choose>
											      <c:when test="${message.read == 'Y'}">
													<p>
														<a href="#">Read already</a>
													</p>
													</c:when>
											      <c:otherwise>
											     	<p>
														<a href="/message/${message.id}">Read and Reply</a>
													</p>
											      </c:otherwise>
												</c:choose>
											</div>
										</div>
									</c:forEach>
								</div>
							</div>
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
												<p>
													<a href="/order/${order.id}">See Order</a>
												</p>
											</div>
											<div class="Cell">
												<!-- show this only if status eq ordered-->
												<p>
													<a href="/order/status/${order.id}">Update Status</a>
												</p>
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
												<p>
													<a href="/product/${product.id}">Edit</a> &nbsp; <a
														href="/clone/${product.id}">Clone</a> &nbsp; <a
														href="/sale/${product.id}">Add To Sale</a>
												</p>
											</div>
										</div>
									</c:forEach>
								</div>
							</div>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>