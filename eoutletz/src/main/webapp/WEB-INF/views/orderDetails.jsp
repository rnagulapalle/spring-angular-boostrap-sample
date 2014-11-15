<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>eOutletz - Order details</title>
</head>
<body>
	<div class="container">
		<div class="body-wrapper">
			<h4>Order details</h4>
			<div class="table-wrapper">
				<div class="table">
					<div class="tRow C">
						<p>
							<label>ID:</label>
						</p>
						<div class="tCell">
							<label>${order.id }</label>
						</div>
					</div>
					<div class="tRow B">
						<p>
							<label>Products:</label>
						</p>
						<div class="tCell">
							<c:if test="${not empty order.products}">
								<c:forEach var="product" items="${order.products}">
									<label>${product.name}</label>
									<br />
								</c:forEach>
							</c:if>
						</div>
					</div>
					<div class="tRow B">
						<p>
							<label>Shipping Address:</label>
						</p>
						<div class="tCell">
							<label>${order.address.address1},
								${order.address.address2}</label> <br /> <label>${order.address.city},
								${order.address.state}, ${order.address.postalCode}</label> <br /> <label>${order.address.country}</label>
						</div>
					</div>
					<div class="tRow C">
						<p>
							<label>Amount Paid:</label>
						</p>
						<div class="tCell">
							<label>${order.amount }</label>
						</div>
					</div>
					<div class="tRow C">
						<p>
							<label>Status:</label>
						</p>
						<div class="tCell">
							<label>${order.orderStatus.status}</label>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>