<%@ include file="../include.jsp" %>
<div style="width: 1100px; height: 20px;">
	<table border="0" cellspacing="0" cellpadding="0" align="left"
		style="width: 100%">
		<tbody>
			<tr class="pgheadback">
				<td class="PageHeading">
					<div align="center">
						<b>Time Sheet</b>
					</div>
				</td>
			</tr>
		</tbody>
	</table>
</div>
<div style="width: 1100px; height: 20px;">
	<table border="0" cellspacing="0" cellpadding="1" border="0" align="left">
		<tbody>
			<tr>
				<td class="txtbold" width="250" align="center">Week Start Date</td>
				<td><select name="DropDownList1"
					onchange="JavaScript:checkSave1();" id="DropDownList1" tabindex="0"
					style="visibility: visible;">
						<option value="30-Jul-16">30-Jul-16</option>
						<option value="23-Jul-16">23-Jul-16</option>
						<option selected="selected" value="16-Jul-16">16-Jul-16</option>
						<option value="09-Jul-16">09-Jul-16</option>
						<option value="02-Jul-16">02-Jul-16</option>
						<option value="25-Jun-16">25-Jun-16</option>
						<option value="18-Jun-16">18-Jun-16</option>
						<option value="11-Jun-16">11-Jun-16</option>
				</select></td>
			</tr>
		</tbody>
	</table>
</div>
<div style="width: 1100px; height: 150px; overflow: scroll">
	<table cellspacing="0" rules="all" border="1" id="dgProjects"
		style="border-color: Black; border-width: 1px; border-style: solid; width: 1100px; border-collapse: collapse;">
		<thead class="tablehead">
			<tr>
				<td>ID</td>
				<td class="style18">Project Details</td>
				<td class="style18">Approver</td>
			</tr>
		</thead>
		<tbody>
			 <c:forEach items="${projectList}" var="project">
				<tr class="tablebody"
					style="border-color: black; background-color: rgb(211, 211, 211);">
					<td><c:out value="${project.pId}" /></td>
					<td class="smallfont" align="left" style="width: 600px;"><a
						id="bProjects" class="ProjectLinks" name="bProjects"
						onclick="javascript:getDetails(this, &#39;15162&#39;,&#39;ICR&#39;)"
						href="javascript:doGetTask(${project.pId});" tabindex="0"><c:out value="${project.pId}:${project.projectName}" /></a></td>
					<td><c:out value="${project.approverId}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>