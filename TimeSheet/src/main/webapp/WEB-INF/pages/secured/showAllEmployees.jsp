<%@ include file="include.jsp" %>
<div id="TableNav" class="wrapperMain" align="center">
	<div class="topBar">
		<div class="clearfix">
			<div class="signinLt1">
				<div id="HeaderLoggedIn">				
					<a href="javascript:doAjaxOpEmp('ADD')" style="font-size: 0.9em;"><img src="images/add.png" border="0" width="20" height="20" title="Add">Add</a><span/>
					<a href="javascript:doAjaxOpEmp('EDIT')" style="font-size: 0.9em;"><img src="images/user_add.gif" border="0"  width="16" height="16" title="Edit" >Edit</a><span/>
					<a href="javascript:doAjaxOpEmp('DELETE')" style="font-size: 0.9em;"><img src="images/delete.png" border="0"  width="16" height="16" title="Delete">Delete</a>
				</div>
			</div>
			<div class="signinRt" align="right" style="z-index:2">
				<c:if test="${currentPage != 1}">
					<a onclick="doNavigate('PREVIOUS',${currentPage-1});" style="color:#fff">Previous<img style="margin-left: 5px;" src="images/arrow-left-white.gif" title="Previous" alt="Search Messages"></a>
				</c:if>
				|
				<c:if test="${currentPage != noOfPages}">
					<a onclick="doNavigate('NEXT',${currentPage+1});" style="color:#fff">Next<img style="margin-left: 5px;" src="images/arrow-right-white.gif" title="Next" alt="Search Messages"></a>
				</c:if>
			</div>
			<div class="signinRt"  style="z-index:2">
				Showing 
			  <select class="ActMenu" onchange="doNavigate('NAV',this[selectedIndex].value)">
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
<table class="uk-table uk-table-hover uk-table-striped uk-table-condensed" style="margin-top: 0px;">
    <thead>
        <tr style="background-color: #D1D0CE;">
			<th></th>
			<th>Employee Id</th>
			<th>Name</th>
			<th>Salary</th>
			<th>Phone No</th>
			<th>Date of Joining</th>
			<th>Email</th>
		</tr>
    </thead>
    <tbody>
	    <c:forEach items="${employeeList}" var="emp">
	        <tr>
				<td><input type="radio" name="radio" value="${emp.employeeId}" /></td>
				<td><c:out value="${emp.employeeId}" /></td>
				<td><c:out value="${emp.firstName} ${emp.lastName}" /></td>
				<td><c:out value="${emp.salary}" /></td>
				<td><c:out value="(${fn:substring(emp.phoneNumber, 0, 3)}) - ${fn:substring(emp.phoneNumber, 4, 7)} -
	                                                    ${fn:substring(emp.phoneNumber, 8, fn:length(emp.phoneNumber))} " /></td>
				<td><fmt:formatDate value="${emp.hireDate}" type="date" pattern="dd-MMM-yyyy" /></td>
				<td><c:out value="${emp.email}" /></td>
			</tr>
		</c:forEach>
    </tbody>
</table>