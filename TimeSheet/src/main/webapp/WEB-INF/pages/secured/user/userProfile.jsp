<%@ include file="../include.jsp" %>
<!DOCTYPE html>
<html>
<body class="uk-height-1-1 uk-body" style="overflow:auto;" onload="displaySearch('edit_User','${pageContext.request.userPrincipal.name}')">
<%@ include file="../header.jsp" %>
<div class="uk-container uk-margin-small-top uk-margin-small-bottom" id="displayUserDetails"></div>
<%@ include file="../footer.jsp" %>
</body>
</html>