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
	                        <label for="price" class="col-md-3 control-label">Price</label>
	                        <div class="col-md-9">
	                            <form:input type="text" class="form-control" path="price" placeholder="Product Price" />
	                            <span class="help-block field-error"><form:errors path="price" /></span>
	                        </div>
                        </div>
                        <div class="form-group">
	                        <label for="description" class="col-md-3 control-label">Description</label>
	                        <div class="col-md-9">
	                            <form:input type="text" class="form-control" path="description" placeholder="Product Description" />
	                            <span class="help-block field-error"><form:errors path="description" /></span>
	                        </div>
                        </div>
                        <div class="form-group">
	                        <label for="quantity" class="col-md-3 control-label">Quantity</label>
	                        <div class="col-md-9">
	                            <form:input type="text" class="form-control" path="quantity" placeholder="Product Quantity" />
	                            <span class="help-block field-error"><form:errors path="quantity" /></span>
	                        </div>
                        </div>
                        <div class="form-group">
	                        <label for="size" class="col-md-3 control-label">Size</label>
	                        <div class="col-md-9">
	                            <form:input type="text" class="form-control" path="size" placeholder="Product Size" />
	                            <span class="help-block field-error"><form:errors path="size" /></span>
	                        </div>
                        </div>
                        <div class="form-group">
	                        <label for="msrp" class="col-md-3 control-label">MSRP</label>
	                        <div class="col-md-9">
	                            <form:input type="text" class="form-control" path="msrp" placeholder="Product MSRP" />
	                            <span class="help-block field-error"><form:errors path="msrp" /></span>
	                        </div>
                        </div>
                        <div class="form-group">
	                        <label for="sku" class="col-md-3 control-label">SKU</label>
	                        <div class="col-md-9">
	                            <form:input type="text" class="form-control" path="sku" placeholder="Product SKU" />
	                            <span class="help-block field-error"><form:errors path="sku" /></span>
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