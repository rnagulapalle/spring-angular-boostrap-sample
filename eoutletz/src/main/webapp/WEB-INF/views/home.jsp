<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>

	<head>
		<title>Home Page</title>
	</head>

	<body>
	
		Logged in user name: <sec:authentication property="principal" /> 
	
	</body>
	
</html>	