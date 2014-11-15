	  <div class="container"> 
	  	 <div id="productuploadbox" style="margin-top:50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
            <div class="panel panel-info">
                <div class="panel-body" >
                	<h3>${message}</h3>
                    <form:form commandName="prodCommand" enctype="multipart/form-data" id="productform" action="/product" class="form-horizontal" role="form" method="post">
                    	
	                    <div class="form-group">
		                    <label for="Sale" class="col-md-3 control-label">Sale Percentage</label>
		                    <div class="col-md-9">
		                        <form:select items="${salePercentages}" class="form-control" path="sale" itemValue="id" itemLabel="percentage"/>
		                        <span class="help-block field-error"><form:errors path="sale" /></span>
		                    </div>
	                    </div>
                        <div class="form-group">
                            <label for="name" class="col-md-3 control-label">Name</label>
                            <div class="col-md-9">
                                <form:input readonly="true" type="text" class="form-control" path="name" placeholder="Product Name" />
                                <span class="help-block field-error"><form:errors path="name" /></span>
                            </div>
                        </div>
                        
                        <div class="form-group">
	                        <label for="price" class="col-md-3 control-label">Price</label>
	                        <div class="col-md-9">
	                            <form:input readonly="true" type="text" class="form-control" path="price" placeholder="Product Price" />
	                            <span class="help-block field-error"><form:errors path="price" /></span>
	                        </div>
                        </div>
                        <div class="form-group">
	                        <label for="description" class="col-md-3 control-label">Description</label>
	                        <div class="col-md-9">
	                            <form:textarea readonly="true" class="form-control" path="description" placeholder="Product Description" />
	                            <span class="help-block field-error"><form:errors path="description" /></span>
	                        </div>
                        </div>
                        <div class="form-group">
	                        <label for="quantity" class="col-md-3 control-label">Quantity</label>
	                        <div class="col-md-9">
	                            <form:input type="text" readonly="true" class="form-control" path="quantity" placeholder="Product Quantity" />
	                            <span class="help-block field-error"><form:errors path="quantity" /></span>
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
