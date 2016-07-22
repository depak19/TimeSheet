<%@ include file="../include.jsp" %>
<table width="1100px" border="0" cellpadding="1" cellspacing="1"
	id="tblDate">
	<tbody>
		<tr>
			<td height="7" class="style1"></td>
		</tr>
		<tr class="tablehead" height="28">
			<td class="style8" align="center">Status</td>
			<td class="style10">Task No : Task Details</td>
			<td class="style9">Start Date</td>
			<td class="style12">End Date</td>
			<td class="style11" align="center" valign="middle">Sat</td>
			<td class="style11" align="center">Sun</td>
			<td class="style111" align="center">Mon</td>
			<td class="style11" align="center">Tue</td>
			<td class="smallfont" width="59" align="center">Wed</td>
			<td class="smallfont" width="59" align="center">Thu</td>
			<td class="smallfont" width="60" align="center">Fri</td>
			<td class="style112" align="center">Total Hrs</td>
			<td class="txt" align="center" width="20">&nbsp;</td>
		</tr>
		<tr class="tablebody">
			<td class="style8" align="center" id="billable_td2">&nbsp;</td>
			<td class="style10" align="center" id="projectSite_td2">&nbsp;</td>
			<td class="style9" align="center" id="effortType_td2">&nbsp;</td>
			<td class="style12" align="center">&nbsp;</td>
			<td class="" align="center" id="Saturday"><input
				class="InputColHead1" type="text" name="txtSatDate"
				style="width: 58px; height =20px; left: 0; top: 0; right: 0"
				readonly="" tabindex="-1" value="16-Jul-16"></td>
			<td class="" align="center" id="Td1"><input
				class="InputColHead1" type="text" name="txtSunDate"
				style="width: 58px; height =20px; left: 0; top: 0; right: 0"
				readonly="" tabindex="-1" value="17-Jul-16"></td>
			<td class="" align="center" id="Td2"><input
				class="InputColHead1" type="text" name="txtMonDate"
				style="width: 58px; height =20px; left: 0; top: 0; right: 0"
				readonly="" tabindex="-1" value="18-Jul-16"></td>
			<td class="" align="center" id="Tuesday"><input
				class="InputColHead1" type="text" name="txtTueDate"
				style="width: 58px; height =20px; left: 0; top: 0; right: 0"
				readonly="" tabindex="-1" value="19-Jul-16"></td>
			<td class="" align="center" id="Wednesday"><input
				class="InputColHead1" type="text" name="txtWedDate"
				style="width: 58px; height =20px; left: 0; top: 0; right: 0"
				readonly="" tabindex="-1" value="20-Jul-16"></td>
			<td class="" align="center" id="Thursday"><input
				class="InputColHead1" type="text" name="txtThuDate"
				style="width: 58px; height =20px; left: 0; top: 0; right: 0"
				readonly="" tabindex="-1" value="21-Jul-16"></td>
			<td class="" align="center" id="Td3"><input
				class="InputColHead1" type="text" name="txtFriDate"
				style="width: 58px; height =20px; left: 0; top: 0; right: 0"
				readonly="" tabindex="-1" value="22-Jul-16"></td>
			<td class="style112" align="center">&nbsp;</td>
			<td class="smallfont" align="center">&nbsp;</td>
		</tr>
		<tr class="tablebody">
			<td class="smallfont" align="center" width="28" id="billable_td3">&nbsp;</td>
			<td class="smallfont" nowrap="" width="200">Total hrs by day
				across projects</td>
			<td class="smallfont" align="center" width="52">&nbsp;</td>
			<td class="smallfont" align="center" width="51">&nbsp;</td>
			<td class="txt" align="center" width="40"><input type="text"
				name="txtTotSatHrs" id="txtTotSatHrs"
				style="width: 38px; height =20px; left: 0; top: 0; right: 0"
				readonly="" class="InputColHead1" tabindex="-1"></td>
			<td class="txt" align="right" width="40"><input type="text"
				name="txtTotSunHrs" id="txtTotSunHrs"
				style="width: 38px; height =20px; left: 0; top: 0; right: 0"
				readonly="" class="InputColHead1" tabindex="-1" align="middle">
			</td>
			<td class="txt" align="center" width="40"><input type="text"
				name="txtTotMonHrs" id="txtTotMonHrs" value=""
				style="width: 38px; height =20px; left: 0; top: 0; right: 0"
				readonly="" class="InputColHead1" tabindex="-1"></td>
			<td class="txt" align="center" width="40"><input type="text"
				name="txtTotTueHrs" id="txtTotTueHrs"
				style="width: 38px; height =20px; left: 0; top: 0; right: 0"
				readonly="" class="InputColHead1" tabindex="-1"></td>
			<td class="txt" align="center" width="40"><input type="text"
				name="txtTotWedHrs" id="txtTotWedHrs"
				style="width: 38px; height =20px; left: 0; top: 0; right: 0"
				readonly="" class="InputColHead1" tabindex="-1"></td>
			<td class="txt" align="center" width="40"><input type="text"
				name="txtTotThuHrs" id="txtTotThuHrs"
				style="width: 38px; height =20px; left: 0; top: 0; right: 0"
				readonly="" class="InputColHead1" tabindex="-1"></td>
			<td class="txt" align="center" width="40"><input type="text"
				name="txtTotFriHrs" id="txtTotFriHrs"
				style="width: 38px; height =20px; left: 0; top: 0; right: 0"
				readonly="" class="InputColHead1" tabindex="-1"></td>
			<td class="style113" align="center">
					<input type="text" name="txtTotalHrs"
				id="txtTotalHrs"
				style="width: 40px; height =20px; left: 0; top: 0; right: 0"
				readonly="" class="InputColHead1" tabindex="-1">
			</td>
			<td class="txt" align="center" width="20">&nbsp;</td>
		</tr>
		 <c:forEach items="${taskList}" var="task">
			<tr class="tablebody">
				<td class="smallfont" align="center" width="28" id="billable_td3">&nbsp;</td>
				<td><c:out value="${task.tkId}:${task.taskName}" /></td>
				<td><c:out value="${task.startDate}" /></td>
				<td><c:out value="${task.endDate}" /></td>
				<td><c:out value="${task.timeSheet.satDay}" /></td>
			</tr>
		</c:forEach>
	</tbody>
</table>