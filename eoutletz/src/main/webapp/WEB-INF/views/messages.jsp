<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div id="productuploadbox" style="margin-top: 50px"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<div class="panel panel-info">
				<div class="panel-body">
				<h4>Message details</h4>
				<h5>${message.subject }</h5>
				<p class="message-wrapper">
					${message.message}
				</p>
				<h6><a href="/message/reply/${message.id }">Reply</a></h6>
				<!-- TODO:display message history -->
				</div>
			</div>
		</div>
	</div>
</body>
</html>