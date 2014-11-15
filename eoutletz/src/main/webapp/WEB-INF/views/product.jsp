<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<!DOCTYPE html>
<html>
	<head>
		<title>eOutletz - Product Page</title>
	</head>
	<body>
		<c:if test="${action == 'add'}">
			<%@include file="addProduct.jsp"%>
		</c:if>
		<c:if test="${action == 'sale'}">
			<%@include file="saleProduct.jsp"%>
		</c:if>  
		<c:if test="${action == 'copy'}">
			<%@include file="copyProduct.jsp"%>
		</c:if> 
		<c:if test="${action == 'update'}">
			<%@include file="editProduct.jsp"%>
		</c:if>   
	</body>
</html>