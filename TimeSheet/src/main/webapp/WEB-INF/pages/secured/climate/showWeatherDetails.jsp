<%@ include file="../include.jsp" %>
<!--Weather Details Form -->
<h3 class="uk-h3" align="center">Weather Details</h3>
<hr style="margin: 5px 0"/>
<form class="uk-form uk-form-icon" action="#">
	 <fieldset data-uk-margin>
		<div class="uk-form-row"><label class="uk-form-label">Location :</label><c:out value="${weather.location}"/></div>
		<div class="uk-form-row"><label>Time :</label><c:out value="${weather.time}"/></div>
		<div class="uk-form-row"><label>Wind :</label><c:out value="${weather.wind}"/></div>
		<div class="uk-form-row"><label>Visibility :</label><c:out value="${weather.visibility}"/></div>
		<div class="uk-form-row"><label>SkyConditions :</label><c:out value="${weather.skyConditions}"/></div>
		<div class="uk-form-row"><label>Temperature :</label><c:out value="${weather.temperature}"/></div>
		<div class="uk-form-row"><label>DewPoint :</label><c:out value="${weather.dewPoint}"/></div>
		<div class="uk-form-row"><label>RelativeHumidity :</label><c:out value="${weather.relativeHumidity}"/></div>
		<div class="uk-form-row"><label>Pressure :</label><c:out value="${weather.pressure}"/></div>
  </fieldset>
</form>
<hr style="margin: 5px 0"/>
<div class="uk-container uk-container-center uk-margin-large-left uk-margin-small-bottom uk-width-7-10" align="center">
	<button class="uk-button uk-button-primary " style="align:center" name="cancel" id="cancel" onclick="cancel('popUpDiv')">OK</button>
</div>