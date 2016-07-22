<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<title>Logout Page</title>
<body>
	<h2>You have been successfully logged out.</h2>
	<a href="<c:url value='/secured/hello'/>">Login to My Secured Page</a>
</body>
</html>