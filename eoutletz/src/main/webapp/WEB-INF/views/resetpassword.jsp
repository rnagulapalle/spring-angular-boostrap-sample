<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Reset Password</title>
	</head>
	<body>
	  <div class="container">
	  		<div id="resetbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">   
		  		<c:if test="${param.reset != null}">  
	            	<div id="logout-alert" class="alert alert-success">
	                	You have successfully reset password.
	                </div>
	            </c:if>
            </div> 
        	<div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
            	<div class="panel panel-info" >
                    <div class="panel-heading">
                        <div class="panel-title">Reset Password</div>
                        <div style="float:right; font-size: 80%; position: relative; top:-10px"></div>
                    </div> 
                     <div style="padding-top:30px" class="panel-body" >
                        <form id="loginform" class="form-horizontal" role="form" action='/resetpassword' method='POST'>
  							<c:if test="${param.error != null}">        
	                            <div id="signupalert" class="alert alert-danger col-sm-12">
									<p>Error Reseting Password</p>
	                            </div> 
	                            <br /><br />
                        	</c:if>                      	     
                        	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />       
                            <input type="hidden" name="token" value="${token}" />       
                            <div style="margin-bottom: 25px" class="input-group">
                                  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                  <input id="newpassword" type="password" class="form-control" name="newpassword" value="" placeholder="New Password">                                        
                             </div>
                             <div style="margin-bottom: 25px" class="input-group">
                                  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                  <input id="reenterpassword" type="password" class="form-control" name="reenterpassword" value="" placeholder="Reenter Password">                                        
                             </div>
                             <div style="margin-top:10px" class="form-group">
                                    <!-- Button -->

                                    <div class="col-sm-12 controls">
                                    	<input type="submit" value="Submit" class="btn btn-success" id="btn-resetpassword" />
                                    </div>
                                </div>
                        </form>
                     </div>
                 </div>  
        	</div>
      </div>
	
	</body>

</html>