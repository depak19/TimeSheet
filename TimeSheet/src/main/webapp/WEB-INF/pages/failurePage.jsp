<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<title>Access Denied !!</title>
<body>
	<h2>Login Failure , BAD Credentials !!</h2>
	<a href="<c:url value='/secured/mypage'/>">Login Again</a>
</body>
</html>