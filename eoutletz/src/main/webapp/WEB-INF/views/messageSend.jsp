<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>eOutletz - send message</title>
</head>
<body>
	<div class="container">
		<div class="container">
			<div id="messagereplybox" style="margin-top: 50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
				<div class="panel panel-info">
					<div class="panel-body">
						<h3>Send Message</h3>
						<form:form commandName="messageCommand" id="replyform" action="/message/send" class="form-horizontal" role="form" method="post">
							<div class="form-group">
								<label for="subject" class="col-md-3 control-label">Subject</label>
								<div class="col-md-9">
									<form:input readonly="true" rows="4" cols="50" type="text" class="form-control" path="subject" placeholder="Subject" />
									<span class="help-block field-error"><form:errors path="subject" /></span>
								</div>
							</div>
							<div class="form-group">
								<label for="message" class="col-md-3 control-label">Message</label>
								<div class="col-md-9">
									<form:textarea class="form-control" path="message" />
									<span class="help-block field-error"><form:errors path="message" /></span>
								</div>
							</div>
							<div class="form-group">
								<div class="col-md-offset-3 col-md-9">
									<input type="submit" id="btn-save" class="btn btn-info" value="&nbsp Save" />
								</div>
							</div> 
						</form:form>
					</div>
				</div>
			</div>

		</div>

	</div>
</body>
</html>