<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-gb" dir="ltr" class="uk-height-1-1">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Application Login Page</title>
	<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
	<link rel="apple-touch-icon-precomposed" href="images/apple-touch-icon.png">
	<link rel="stylesheet" type="text/css" href="css/uikit.css" />
    <script type="text/javascript" src="js/jquery-3.0.0.js"></script>
    <script type="text/javascript" src="js/uikit.js"></script>
    <script type="text/javascript" src="js/custom.js"></script>
</head>
<body class="uk-height-1-1">
	<div class="uk-vertical-align uk-text-center uk-height-1-1">
		<div class="uk-vertical-align-middle" style="width: 250px;">
			<img class="uk-margin-bottom" width="140" height="120" src="" alt="">
			<form class="uk-panel uk-panel-box uk-form" name="login" id="login" action="login" method="post" accept-charset="utf-8">
					<c:if test="${'fail' eq param.auth}">
						<div style="color:red">
					              Login Failed!!!<br />
					              Reason : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
					    </div>
					</c:if>
					<div class="uk-form-row">
						<input class="uk-width-1-1 uk-form-large" type="text" id ="username" name="username" placeholder="Username">
					</div>
					<div class="uk-form-row">
						<input class="uk-width-1-1 uk-form-large" type="password" id ="password" name="password"  placeholder="Password">
					</div>
					<div class="uk-form-row">
						<input class="uk-width-1-1 uk-button uk-button-primary uk-button-large" type="Submit"  Value="login">
					</div>
					<div class="uk-form-row uk-text-small">
						<label class="uk-float-left"><input type="checkbox"> Remember Me</label>
						<a class="uk-float-center uk-link uk-link-muted" href="#">Forgot Password?</a>
						<a class="uk-float-right uk-link uk-link-muted" href="registration.do">Registration</a>
					</div>
			</form>
		</div>
	</div>
</body>
</html>
