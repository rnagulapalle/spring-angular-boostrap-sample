<!DOCTYPE html>
<html>  
  <head>  
	<jsp:include page="head-fragment.jsp"/>
	
	<title><sitemesh:write property='title'/></title> 
	     
    <sitemesh:write property='head'/>  
  </head>  
    
  <body>  
  
  	<header>
      <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
          <div class="navbar-header">
             <a class="navbar-brand" href="/">
             	<img src="/images/pandoEdLogo.gif" style="margin-top: -15px;width:200px;height:55px"  />
             	<%-- IPG Telecom --%>
             </a>
             <!-- Displays the toggle button in mobile mode -->
          </div>
        </div>
      </div> 
    </header>   

    <div class="container">
    	<div class="">
    		<sitemesh:write property='body'/>  
    	</div>
	</div>
	
	<jsp:include page="footer-fragment.jsp"/>
	
  </body>  
    
</html>