<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Login</title>
	</head>

	<body>
	  <div class="container"> 
	  		
	  		<div id="logoutbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">   
		  		<c:if test="${param.logout != null}">  
	            	<div id="logout-alert" class="alert alert-success">
	                	You have successfully logged out of the application.
	                </div>
	            </c:if>
            </div>
                        
        	<div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
            	<div class="panel panel-info" >
                    <div class="panel-heading">
                        <div class="panel-title">Sign In</div>
                        <div style="float:right; font-size: 80%; position: relative; top:-10px"><%-- TODO: <a href="#">Forgot password?</a> --%></div>
                    </div>     
					
                    <div style="padding-top:30px" class="panel-body" >

                        <form id="loginform" class="form-horizontal" role="form" action='/login' method='POST'>
  							<c:if test="${param.error != null}">        
	                            <div id="signupalert" class="alert alert-danger col-sm-12">
									<p>Invalid username and/or password</p>
	                            </div> 
	                            <br /><br />
                        	</c:if>                      	     
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />       
                            <div style="margin-bottom: 25px" class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                        <input id="login-username" type="text" class="form-control" name="username" value="" placeholder="email">                                        
                                    </div>
                                
                            <div style="margin-bottom: 25px" class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                        <input id="login-password" type="password" class="form-control" name="password" placeholder="password">
                                    </div>
                                    

                          	<%--      
                            <div class="input-group">
                                      <div class="checkbox">
                                        <label>
                                          <input id="login-remember" type="checkbox" name="remember" value="1"> Remember me
                                        </label>
                                      </div>
                                    </div>
							 --%>	

                                <div style="margin-top:10px" class="form-group">
                                    <!-- Button -->

                                    <div class="col-sm-12 controls">
                                    	<input type="submit" value="Login" class="btn btn-success" id="btn-login" />
                                    </div>
                                </div>


                                <div class="form-group">
                                    <div class="col-md-12 control">
                                        <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
                                            Don't have an account! 
                                        <a href="/signup"> Sign Up Here</a>
                                        </div>
                                    </div>
                                </div>    
                            </form>     



                        </div>                     
                    </div>  
        	</div>
        
      </div>
	
	</body>

</html>