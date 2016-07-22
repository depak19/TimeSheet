function displaySearch(div,sso) {
		 $(document).ready(function() {
			 $("#"+div).show();
			  }); 
		if(getPageName()=='userLanding.do' || getPageName()=='adminPage.do' )
		 	doAjaxPost();
		else if (getPageName()=='weather.do')
			doAjaxPostU();
		else if (getPageName()=='userProfile.do')
			doAjaxPostUser(sso);
		getDate();
	};
		 
function doAjaxPost() {
	var empid="empid="+document.getElementById('empid').value;
	var empname="&&empname="+document.getElementById('empname').value;
	var salary="&&salary="+document.getElementById('salary').value;
	var phno="&&phno="+document.getElementById('phno').value;
	var page="&&page="+document.getElementById('page').value;
	jQuery.ajax({
        url: "showAllEmployees.do?"+empid+empname+salary+phno+page,
        type: "GET",
        success: function (data) {
            $('#displayGridTable').html(data);
            $('table').scrollTableBody({rowsToDisplay:10});
        },
        error: function (data) {
            alert(data + "error");
        }
    });
};


function doAjaxPostU() {
	var countryName="countryName="+document.getElementById('countryName').value;
	var cityName="&&cityName="+document.getElementById('cityName').value;
	var page="&&page="+document.getElementById('page').value;
	var loading = $("#loading");
	loading.show();
	jQuery.ajax({
        url: "showAllCountries.do?"+countryName+cityName+page,
        type: "GET",
        success: function (data) {
            $('#displayGridTableCountry').html(data);
            $('table').scrollTableBody({rowsToDisplay:10});
            loading.hide();
        },
        error: function (data) {
            alert(data + "error");
        }
    });
};

function doAjaxPostW(countryName,cityName) {
	var loading = $("#loading");
	loading.show();
	jQuery.ajax({
        url: "showWeatherDetails.do?"+"countryName="+countryName+"&&cityName="+cityName,
        type: "GET",
        success: function (data) {
        	$("#popUpDiv").css("display", "block");
            $('#popUpDiv').html(data);
            loading.hide();
        },
        error: function (data) {
            alert(data + "error");
        }
    });
};


function doAjaxPostUser(sso) {
	var ssoid="ssoid="+sso;
	jQuery.ajax({
        url: "userDetails.do?"+ssoid,
        type: "GET",
        success: function (data) {
            $('#displayUserDetails').html(data);
        },
        error: function (data) {
            alert(data + "error");
        }
    });
};

function doClearForm(type){
	if(type=='clear') {
		document.getElementById('empid').value="";
		document.getElementById('empname').value="";
		document.getElementById('salary').value="";
		document.getElementById('phno').value="";
		document.getElementById('countryName').value="";
		document.getElementById('cityName').value="";
	}	
	document.getElementById('page').value=1;
};

function doNavigate(call,X){
	if(call=="PREVIOUS")
		document.getElementById('page').value=X;
	else if(call=="NEXT")
		document.getElementById('page').value=X;
	else
		document.getElementById('page').value=X;
	doAjaxPost();
};

function doNavigateU(call,X){
	if(call=="PREVIOUS")
		document.getElementById('page').value=X;
	else if(call=="NEXT")
		document.getElementById('page').value=X;
	else
		document.getElementById('page').value=X;
	doAjaxPostU();
};

function getPageName() {
        var a = window.location.href,
            b = a.lastIndexOf("/");
        return a.substr(b + 1);
    };

function popup(div) {
	$("#"+div).css("display", "block");
};
/*$("#onclick").click(function() {
	$("#popUpDiv").css("display", "block");
});*/
function cancel(div) {
	$("#"+div).hide();
};


function getDate(){
	var months = new Array(12);
	months[0] = "January";
	months[1] = "February";
	months[2] = "March";
	months[3] = "April";
	months[4] = "May";
	months[5] = "June";
	months[6] = "July";
	months[7] = "August";
	months[8] = "September";
	months[9] = "October";
	months[10] = "November";
	months[11] = "December";
	var day = new Array(7);
	day[0] = "Sunday";
	day[1] = "Monday";
	day[2] = "Tuesday";
	day[3] = "Wednesday";
	day[4] = "Thursday";
	day[5] = "Friday";
	day[6] = "Saturday";
	var today = new Date();
	today = day[today.getDay()] + ", "
			+ months[today.getMonth()] + " "
			+ today.getDate() + ", " + today.getFullYear();
	document.getElementById("showDate").innerHTML=today;
}

function doAjaxOpEmp(event){
	var arr = $('table').find('input[type="radio"]:checked').map(function () {
        return $(this).closest('tr').find('td:eq(1)').text() + ':' + this.value;
    }).get().join();
	if(event=="ADD"){
		alert("Add Operation Successful");
	}
	else if(event=="EDIT"){
		alert("Edit Operation Successful"+arr);
	}
	else if(event=="DELETE"){
		alert("Delete Operation Successful"+arr);
	}
};

function doAjaxOpCountry(event){
	if(event=="ADD"){
		alert("Add Operation Successful");
	}
	else if(event=="EDIT"){
		alert("Edit Operation Successful");
	}
	else if(event=="DELETE"){
		alert("Delete Operation Successful");
	}
};

function doGetProjects() {
	empid="empid="+"DEPAK19";
	jQuery.ajax({
        url: "showProjects.do?"+empid,
        type: "GET",
        success: function (data) {
            $('#projectGrid').html(data);
            $('table').scrollTableBody({rowsToDisplay:10});
        },
        error: function (data) {
            alert(data + "error");
        }
    });
};


function doGetTask(p_id) {
	empid="empid="+"DEPAK19";
	pid="&&pid="+p_id;
	jQuery.ajax({
		url: "showTasks.do?"+empid+pid,
        type: "GET",
        success: function (data) {
            $('#taskGrid').html(data);
            $('table').scrollTableBody({rowsToDisplay:10});
        },
        error: function (data) {
            alert(data + "error");
        }
    });
};