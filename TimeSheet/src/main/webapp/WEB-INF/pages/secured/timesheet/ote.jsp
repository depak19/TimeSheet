<%@ include file="../include.jsp" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Time Sheet</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="bootstrap-3.3.6/css/bootstrap.css">
    <link rel="stylesheet" href="bootstrap-3.3.6/css/custom.css">
    <script type="text/javascript"  src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script type="text/javascript"  src="bootstrap-3.3.6/js/bootstrap.js"></script>
    <link rel="stylesheet" href="css/Promotr.css">
    <script type="text/javascript" src="js/custom.js"></script>
    
  </head>
	<body class="uk-height-1-1 uk-body" style="overflow:auto; height: 100%" onload="doGetProjects();">
    <table cellspacing="0" cellpadding="0" width="100%" border="0">
        <tbody>
        	<tr valign="bottom">
	            <td bgcolor="#D8E2E7" height="66" valign="middle" class="style16">
	                <font face="Verdana, Arial, Helvetica, sans-serif" size="2" class="Welcome" style="color: #0000CC"><b><span id="Label1">Welcome:</span>
	                    <span id="lblUsername">Deepak Sahoo</span>
	                                       
	                    </b></font>&nbsp;
	            </td>
	            <td bgcolor="#D8E2E7" height="66" valign="middle" class="style15" align="center" style="font-weight: bold; font-style: normal; color: #0000CC; font-size: xx-large;">
	                OFSS Time Entry System (OTE)
	            </td>
	            <td id="lgout" width="64" valign="middle" bgcolor="#D8E2E7" align="right">
	            <a href="logout" tabindex="0">
	                <img border="0" alt="Logout" src="images/Logout.gif"></a>
	            </td>
	
	        </tr>
    	</tbody>
    </table>
    <nav class="navbar navbar-default sidebar" role="navigation">
	    <%@ include file="menu.jsp" %>
	</nav>
	<nav class="navbar sidebar" role="navigation" id="projectDetails">
		<div id="projectGrid" class="smallfontRed">
		</div>
		<div id="taskGrid" class="smallfontRed">
		</div>
	</nav>
  </body>
</html>