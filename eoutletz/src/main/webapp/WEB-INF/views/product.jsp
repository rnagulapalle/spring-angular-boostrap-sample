<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<!DOCTYPE html>
<html>
	<head>
		<title>Product Upload Page</title>
	</head>

	<body>
	  <div class="container"> 
	  	  	
	  	 <div id="productuploadbox" style="margin-top:50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
            <div class="panel panel-info">
                <div class="panel-body" >
                    <form:form commandName="prodCommand" id="productform" action="/product" class="form-horizontal" role="form" method="post">

                        <div class="form-group">
                            <label for="name" class="col-md-3 control-label">Name</label>
                            <div class="col-md-9">
                                <form:input type="text" class="form-control" path="name" placeholder="Product Name" />
                                <span class="help-block field-error"><form:errors path="name" /></span>
                            </div>
                        </div>
                            
                        <div class="form-group">
                            <!-- Button -->                                        
                            <div class="col-md-offset-3 col-md-9">
                                <input type="submit" id="btn-upload" class="btn btn-info" value="&nbsp Upload" /> 
                            </div>
                        </div>
                    </form:form>
                 </div>
            </div>
         </div>  	
        
      </div>
      
	</body>

</html>