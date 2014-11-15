<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>eOutletz - Update order status</title>
</head>
<body>
	<div class="container">
		 <div id="productuploadbox" style="margin-top:50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
            <div class="panel panel-info">
                <div class="panel-body" >
                	<h3>Update order status</h3>
                    <form:form commandName="orderCommand" id="orderUpdateform" action="/order" class="form-horizontal" role="form" method="post">

                        <div class="form-group">
                            <label for="trackingNumber" class="col-md-3 control-label">Tracking Number</label>
                            <div class="col-md-9">
                                <form:input type="text" class="form-control" path="trackingNumber" placeholder="Order Tracking Number" />
                                <span class="help-block field-error"><form:errors path="trackingNumber" /></span>
                            </div>
                        </div>
                        <div class="form-group">
	                        <label for="orderStatus" class="col-md-3 control-label">Order Status</label>
	                        <div class="col-md-9">
	                            <form:select items="${statuses}" class="form-control" path="orderStatus" itemValue="id" itemLabel="status"/>
	                            <span class="help-block field-error"><form:errors path="orderStatus" /></span>
	                        </div>
                        </div>
                        <div class="form-group">
                            <!-- Button -->                                        
                            <div class="col-md-offset-3 col-md-9">
                                <input type="submit" id="btn-save" class="btn btn-info" value="&nbsp Save" /> 
                            </div>
                        </div>
                    </form:form>
                 </div>
            </div>
         </div>  	
	</div>
</body>
</html>