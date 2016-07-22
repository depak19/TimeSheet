<%@ include file="../include.jsp" %>

<div id="TableNav" class="wrapperMain" align="center">
	<div class="topBar">
		<div class="clearfix">
			<div class="signinLt1">
				<div id="HeaderLoggedIn">				
					<a href="javascript:doAjaxOpCountry('ADD')" style="font-size: 0.9em;"><img src="images/add.png" border="0" width="20" height="20" title="Add">Add</a><span/>
					<a href="javascript:doAjaxOpCountry('EDIT')" style="font-size: 0.9em;"><img src="images/user_add.gif" border="0"  width="16" height="16" title="Edit">Edit</a><span/>
					<a href="javascript:doAjaxOpCountry('DELETE')" style="font-size: 0.9em;"><img src="images/delete.png" border="0"  width="16" height="16" title="Delete">Delete</a>
				</div>
			</div>
			<div class="signinRt" align="right" style="z-index:2">
				<c:if test="${currentPage != 1}">
					<a onclick="doNavigateU('PREVIOUS',${currentPage-1});" style="color:#fff">Previous<img style="margin-left: 5px;" src="images/arrow-left-white.gif" title="Previous" alt="Search Messages"></a>
				</c:if>
				|
				<c:if test="${currentPage != noOfPages}">
					<a onclick="doNavigateU('NEXT',${currentPage+1});" style="color:#fff">Next<img style="margin-left: 5px;" src="images/arrow-right-white.gif" title="Next" alt="Search Messages"></a>
				</c:if>
			</div>
			<div class="signinRt"  style="z-index:2">
				Showing 
			  <select class="ActMenu" onchange="doNavigateU('NAV',this[selectedIndex].value)">
				<c:forEach var="i" begin="1" end="${noOfPages}">
						<c:choose>
							<c:when test="${currentPage == i}">
								<c:choose>
									<c:when test="${i*recordsPerPage >= noOfRecords}">
										<option value="${i}" selected="">${i*recordsPerPage-recordsPerPage+1} - ${noOfRecords}</option>
									</c:when>
									<c:otherwise>
						   				<option value="${i}" selected="">${i*recordsPerPage-recordsPerPage+1} - ${i*recordsPerPage}</option>
						   			</c:otherwise>
						   		</c:choose>
							</c:when>
							<c:when test="${i*recordsPerPage >= noOfRecords}">
								<option value="${i}">${i*recordsPerPage-recordsPerPage+1} - ${noOfRecords}</option>
							</c:when>
					   		<c:otherwise>
					   			<option value="${i}">${i*recordsPerPage-recordsPerPage+1} - ${i*recordsPerPage}</option>
					   		</c:otherwise>
					   	</c:choose>
				   </c:forEach>
				</select> of ${noOfRecords} Messages&nbsp;&nbsp;&nbsp;
			</div>
			
		</div>
	</div>
</div>
<table class="uk-table uk-table-striped uk-table-condensed" style="margin-top: 0px;">
    <thead>
        <tr style="background-color: #D1D0CE;">
			<th></th>
			<th>ID</th>
			<th>County</th>
			<th>City</th>
			<th>Show Details</th>
		</tr>
    </thead>
    <tbody>
	    <c:forEach items="${cityList}" var="city">
	        <tr>
				<td><input type="radio" name="radio" value="${city.id}"></td>
				<td><c:out value="${city.id}" /></td>
				<td><c:out value="${city.countryName}" /></td>
				<td><c:out value="${city.cityName}" /></td>
				<td>
					<!--<button class="uk-button uk-button-primary uk-button-mini" name="ShowDetails" id="ShowDetails" onclick="doAjaxPostW('${city.countryName}','${city.cityName}');">SHOW</button> -->
					<a href="javascript:doAjaxPostW('${city.countryName}','${city.cityName}');" style="font-size: 0.9em;"><img src="images/user_add.gif" border="0"  width="16" height="16" title="Edit">Edit</a>
					<a href="javascript:doAjaxOpCountry('DELETE')" style="font-size: 0.9em;"><img src="images/delete.png" border="0"  width="16" height="16" title="Delete">Delete</a>
				</td>
			</tr>
		</c:forEach>
    </tbody>
</table>