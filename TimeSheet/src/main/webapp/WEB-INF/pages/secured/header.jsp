<!DOCTYPE html>
<head>
	<link rel="stylesheet" type="text/css" href="css/uikit.css" />
	<link rel="stylesheet" type="text/css" href="css/webmail.css" />
    <script type="text/javascript" src="js/jquery-3.0.0.js"></script>
    <script type="text/javascript" src="js/uikit.js"></script>
    <script type="text/javascript" src="js/custom.js"></script>
    <script type="text/javascript" src="js/jquery.scrollTableBody-1.0.0.js"></script>
</head>
<div class="uk-container">
	<div class="wrapperMain">
		<center>
			<div class="topBar">
				<div class="leftside"/>
				<div class="rightside"/>
				<div class="clearfix">
					<div class="signinLt">
						<!-- signed -->
						<div id="HeaderLoggedIn">
							<span>Hello, <span id="usernamePlaceholder">${pageContext.request.userPrincipal.name}</span></span> 				
							<a href="logout">
								<img src="images/btn_signout.gif" align="absmiddle" alt="Sign Out" title="Sign Out">
							</a>
						</div>
					</div>
					<!-- current date -->
					<div class="signinRt" style="z-index:2" id="showDate"></div>
				</div>
			</div>
		</center>
	</div>
</div>
<div class="uk-container uk-margin-small-bottom" >
    <nav class="uk-navbar uk-margin-small-bottom">
        <ul class="uk-navbar-nav uk-hidden-small">
        	<li>
               <a href="ote.do">TimeSheet</a>
            </li>
            <li>
                <a href="userLanding.do">Home</a>
            </li>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
	            <li>
	                <a href="adminPage.do">Admin</a>
	            </li>
            </sec:authorize>
            <li>
                <a href="weather.do">Weather</a>
            </li>
             <li>
               <a href="userProfile.do">Profile</a>
            </li>
            
            <li>
                <a href="#">Contact</a>
            </li>
            <!--<li>
                <a><i>Welcome :</i>${pageContext.request.userPrincipal.name}</a>
             </li>
             <li>
                <a href="logout">Logout</a>
            </li>-->
        </ul>
    </nav>
</div>
<input type="hidden" id="page" name="page" value=1>
<div id="loading" align="center" style="display: none"><img class="uk-icon-spin" alt="loading" src="images/large-loading.gif" style="color: gray;">Loading..</div>