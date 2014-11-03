<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<!DOCTYPE html>
<html>
	<head>
		<title>Signup Page</title>
	</head>

	<body>
	  <div class="container"> 
	  	  	
	  	 <div id="signupbox" style="margin-top:50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <div class="panel-title">Sign Up</div>
                    <div style="float:right; font-size: 85%; position: relative; top:-10px"><a id="signinlink" href="/login">Sign In</a></div>
                </div>  
                <div class="panel-body" >
                    <form:form commandName="userCommand" id="signupform" action="/signup" class="form-horizontal" role="form" method="post">

                        <div class="form-group">
                            <label for="email" class="col-md-3 control-label">Email</label>
                            <div class="col-md-9">
                                <form:input type="text" class="form-control" path="email" placeholder="Email Address" />
                                <span class="help-block field-error"><form:errors path="email" /></span>
                            </div>
                        </div>
                            
                        <div class="form-group">
                            <label for="firstName" class="col-md-3 control-label">First Name</label>
                            <div class="col-md-9">
                                <form:input type="text" class="form-control" path="firstName" placeholder="First Name" />
                                <span class="help-block field-error"><form:errors path="firstName" /></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lastName" class="col-md-3 control-label">Last Name</label>
                            <div class="col-md-9">
                                <form:input type="text" class="form-control" path="lastName" placeholder="Last Name" />
                                <span class="help-block field-error"><form:errors path="lastName" /></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-md-3 control-label">Password</label>
                            <div class="col-md-9">
                                <form:input type="password" class="form-control" path="password" placeholder="Password" />
                                <span class="help-block field-error"><form:errors path="password" /></span>
                            </div>
                        </div>
                            
                        <div class="form-group">
                            <!-- Button -->                                        
                            <div class="col-md-offset-3 col-md-9">
                                <input type="submit" id="btn-signup" class="btn btn-info" value="&nbsp Sign Up" /> 
                            </div>
                        </div>
                    </form:form>
                 </div>
            </div>
         </div>  	
        
      </div>
      
	</body>

</html>