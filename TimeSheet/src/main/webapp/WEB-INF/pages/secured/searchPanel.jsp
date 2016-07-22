<div class="uk-flex uk-flex-middle uk-flex-space-between">
	<div class="uk-container uk-margin-small-top uk-margin-small-bottom" id="Search_Criteria"  style="display: none">
		<form class="uk-form" id="form_H" method="GET">
			<fieldset data-uk-margin>
				<div class="uk-form-row">
					<input type="number" id="empid" name="empid" placeholder="Employee ID" min="0">
					<input type="text" id="empname" name="empname" placeholder="Employee Name">
				</div>
				<div class="uk-form-row">
					<input type="number" id="salary" name="salary" placeholder="Salary" min="0">
					<input type="text" id="phno" name="phno" placeholder="Phone Number">
				</div>
			</fieldset>			
		</form>
		<div class="uk-container uk-container-center uk-margin-top uk-margin-large-left uk-margin-small-bottom uk-width-7-10" align="center">
			<button class="uk-button uk-button-primary" name="Search" id="Search" value="Search" onclick="doClearForm();doAjaxPost();">Search</button>
			<button class="uk-button uk-button-primary" name="Clear" id="Clear" value="Clear" onclick="doClearForm('clear');doAjaxPost();">Clear</button>		
		</div>
	</div>
	<div class="uk-container uk-margin-small-top uk-margin-small-bottom" id="Search_Criteria_U"  style="display: none">
		<form class="uk-form" id="form_U" method="GET">
			<fieldset data-uk-margin>
				<div class="uk-form-row">
					<input type="text" id="countryName" name="countryName" placeholder="Country Name">
					<input type="text" id="cityName" name="cityName" placeholder="City Name">
					
				</div>
			</fieldset>			
		</form>
		<div class="uk-container uk-container-center uk-margin-top uk-margin-large-left uk-margin-small-bottom uk-width-7-10" align="center">
			<button class="uk-button uk-button-primary" name="Search" id="Search_U" value="Search" onclick="doClearForm();doAjaxPostU();">Search</button>
			<button class="uk-button uk-button-primary" name="Clear" id="Clear_U" value="Clear" onclick="doClearForm('clear');doAjaxPostU();">Clear</button>
		</div>
	</div>
</div>