// VARIABLE DECLARATIONS
var digits = "0123456789";
// whitespace characters
var whitespace = " \t\n\r";
// decimal point character differs by language and culture
var decimalPointDelimiter = "."
var defaultEmptyOK = false;

function PictureString(Picture) {

	MsgStr="Only ";
	var thisChar, CurMsg, SplChar="";
	var firsttime=true, SplTerm=false;

	for(i=0; i < Picture.length; i++) {
		thisChar = Picture.substring(i, i+1);
		SplTerm = false;
		if (thisChar == "A")
			CurMsg=" Alphabets";
		else if (thisChar == "9")
			CurMsg=" Numbers";
		else if (thisChar == " ")
			CurMsg = " Whitespaces";
		else {
			SplChar += thisChar;
			SplTerm = true;
		}

		if (!SplTerm) {
			if (firsttime) {
				firsttime=false;
				MsgStr += CurMsg;
			}
			else
				MsgStr += ", " + CurMsg;
		}

		SplTerm=false;
		CurMsg = "";

	}
	
	if (!IsEmpty(SplChar)) {
		if (firsttime)
			MsgStr += SplChar;
		else
			MsgStr += " and " + SplChar;
	}

	return MsgStr + " are allowed in ";
}


/*This functions checks whether value passed as parameter to this
  is a number or not. It it is a number it returns true otherwise returns
  false */

function IsNumber(data) {

	var numStr="0123456789";
	var thisChar;
	var Counter=0;
	for (var i=0; i < data.length; i++) {
		thisChar = data.substring(i, i+1);
		if (numStr.indexOf(thisChar) != -1)
			Counter++;
	}
	if (Counter == data.length)
		return true;
	else
		return false;

}



/*This functions checks whether value passed as parameter to this
  is alphabets or not. It it is alpabets it returns true otherwise returns
  false */

function IsAlpha(data) {

	 var numStr="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	 var thisChar;
	 for (var i=0; i < data.length; i++) {
 		thisChar = data.substring(i, i+1);
		if (numStr.indexOf(thisChar) == -1)
			return (false);
	 }
	 return (true);

}

function Shiftonfocus(sControl){
	sControl.focus();
	return;
}

function GetSelectedIndex(sControl,sArray) 
{
/********This function is used for setting the index of the combo control.
sControl is the combo name and sArray is the value which is to be set in the combo***/

for (icount=0;icount<sControl.length;icount++)
{   
	
	if (sControl.options[icount].value == sArray)		
	break;
}	
	
	if (icount == sControl.length)
			sControl.options[0].selected = true;
	else
			sControl.options[icount].selected = true;
}

function retFmtStr(srcStr){
	
	 var resStr = "";
	 var AExists = false;
	 var NExists = false;

	 for (var i=0; i < srcStr.length; i++) {
		if ((srcStr.substring(i, i+1) == "A") && (!AExists)) 
		{
			resStr = 			resStr+"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOQPRSTUVWXYZ";
			AExists = true;
		}
		else if ((srcStr.substring(i, i+1) == "9") && (!NExists)) 
		{
			resStr = resStr+"0123456789";
			NExists = true;
		}
		else 
			resStr = resStr+srcStr.substring(i, i+1);
	 }

	 return (resStr);

}
function IsExistsInStr(data, Sourcestr)
 {
 //function validates the project description  and code by calling function retFmtStr
     var num=0;
	 var resStr = retFmtStr(Sourcestr);
	 var thisChar;
	 for (var i=0; i < data.length; i++)
	  {
 		thisChar = data.substring(i, i+1);
 		if ((thisChar==" ") && (num!=0))
 		break;
		if (resStr.indexOf(thisChar, 0) == -1)
			return (false);
			num=1;
		
	 }
	 return (true);

}
function IsExistsapo(data, Sourcestr)
 {
 //function validates the methodology description  and code by calling function retFmtStr
   var num=0;
	 var resStr = retFmtStr(Sourcestr);

	 var thisChar;
	 for (var i=0; i < data.length; i++)
	  {
 		thisChar = data.substring(i, i+1);
 		if ((thisChar=="") )
 		
			return (false);
	 }
	 return (true);

}
// Trims Left trailing purposes
function LTrim(str)
 /* PURPOSE: Remove leading blanks from our string. 
IN: str - the string we want to Ltrim
RETVAL: An LTrimmed string!
*/ 
{
	 var whitespace = new String(" \t\n\r");
	 var s = new String(str); 
	if (whitespace.indexOf(s.charAt(0)) != -1) { 
	// We have a string with leading blank(s)...
	 var j=0, i = s.length; // Iterate from the far left of string until we 
	// don't have any more whitespace... 
	while (j < i && whitespace.indexOf(s.charAt(j)) != -1) 
	j++;
	 // Get the substring from the first non-whitespace
	 // character to the end of the string... 
	s = s.substring(j, i); 
	} 
	return s; 
}

// Trims Right trailing purposes
function RTrim(str)
/*PURPOSE: Remove trailing blanks from our string.
IN: str - the string we want to Rtrim
RETVAL: An RTrimmed string!*/
{
// We don't want to trip JUST spaces, but also tabs, 
  // line feeds, etc. Add anything else you want to
 // "trim" here in Whitespace
	var whitespace = new String(" \t\n\r");
	var s = new String(str);
	if (whitespace.indexOf(s.charAt(s.length-1)) != -1) {
	// We have a string with trailing blank(s)... 
	var i = s.length - 1; // Get length of string
	// Iterate from the far right of string until we
	// don't have any more whitespace... 
	while (i >= 0 && whitespace.indexOf(s.charAt(i)) != -1)
	i=i-1; 
	// Get the substring from the front of the string to 
	// where the last non-whitespace character is... 
	s = s.substring(0, i+1); } 
	return s; 
}
function Trim(str)
{
/*
        PURPOSE: Remove trailing and leading blanks from our string.
        IN: str - the string we want to Trim

        RETVAL: A Trimmed string!
*/

        return RTrim(LTrim(str));
}

// Check on key press
function check(e) 
{ 
	if ( navigator.appName == "Netscape" ) 
	{ 
		var key = e.which; 		
		if ( key == 32 || key == 34 || key == 39 ) 
		return false; 
	} 
	else 
	{ 
		var key = window.event.keyCode; 		
		if ( key == 32 ||key == 34 || key == 39 ) 
		{ 
			window.event.keyCode = 0; 
			window.event.srcElement.focus(); 
			return false; 
		} 
	} 
} 
// Check on key press
function check1(e)
{
 if ( navigator.appName == "Netscape")
 	{
					
 		var key = e.which;

 		if(  key == 34 )
 		return false;
 	}
 else
 	{
 		var key = window.event.keyCode ; 

 		if(  key == 34  )
 		{
 		window.event.keyCode = 0;
 		window.event.srcElement.focus(); 
 		return false;
 		}
 	}
}  

//function to remove all the trailing and leading spaces in a string, returns the string with no //leading and trailing spaces
function trim(obj)
{		
	if (typeof(obj)=='object') obj=obj.value
	for(i=obj.length-1;i>=0;i--)
		if(obj.charAt(i)!=' ') break		
	obj=obj.substring(0,i+1)
	for(j=0;j<=i+1;j++)
		if(obj.charAt(j)!=' ') break
	return obj.substring(j,i+1)
}

//function to check for null values, returns true or false
function isNull(obj)
{
	if (typeof(obj)=='object') obj=obj.value
	//alert('obj=' + obj)
	obj=trim(obj);	
	return obj.length == 0 ? true:false;
}


//function to check if the value entered is a number, returns true or false
function isNum(obj)
{		
	if (typeof(obj)=='object') obj=obj.value
	obj=trim(obj);	
	retstatus=true;
	if (obj.length!=0)
	{
		for ( i = 0 ; i < obj.length ; i++ )
			if ( obj.charAt(i) < '0' || obj.charAt(i) > '9' ) retstatus= false;
	}
	else
		retstatus= false	
	return retstatus;
}

//function to check for a valid email ID, returns true or false
function chkEmail(obj)
{
	strEmail=trim(obj);
	if (strEmail.search(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z]+$/) != -1)
	{
		return true;
	}
	else
	return false;	
}

//function to chech for valid url
function chkUrl(obj)
{
	strEmail=trim(obj);
if (strEmail.search(/^(((WWW\.)|(HTTPS\:\/\/)|(HTTP\:\/\/)|(http\:\/\/)|(https\:\/\/)|(www\.))+)([A-Za-z0-9]+)((((\-)[A-Za-z0-9]+)|((\.)[A-Za-z]+))*)((\.)[A-Za-z]+$)/) != -1)	{
	return true;
	}
	else
	return false;	
}

//function to compare two strings, returns true or false
function strCmp(obj1,obj2)
{
	if (typeof(obj1)=='object') obj1=obj1.value
	if (typeof(obj2)=='object') obj2=obj2.value
	if (obj1.length==0 && obj2.length==0) return false;
	return obj1==obj2 ? true:false
}

//t0 check combo is blank
function isComboBlank(obj)
{
	return (obj.options[obj.selectedIndex].value=='') ? true:false;
}

//function to check if the date value passed is a number, returns true or false
function isNumDt(obj)
{	
	
	var str1 = obj.toString();	
	len = str1.length;
	retstatus=true;
	for ( i = 0 ; i < len ; i++ )
	{		
		if ( str1.charAt(i) < '0' || str1.charAt(i) > '9' )
		retstatus= false ;
	}
	 return retstatus;
}


function isValidChar(obj,schr,flg)
{
	if (typeof(obj)=='object') obj=obj.value
	if (flg==1) 
		sarr1='ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz';
	else if (flg==2) 
		sarr1='ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
	else if (flg==3) 
		sarr1='0123456789';

	sarr1=sarr1 + schr;	
	for(var i=0;i <=obj.length-1;i++)	
	{	
		spflag=(sarr1.indexOf(obj.charAt(i))!=-1)==true ? true:false
		if (spflag==false) return false
	}
	return true;	
}

function isSpecialChar(obj,schr)
{
	sval=trim(obj);
	sarr='~`@#$%^&*+={}:;?/<>|\\"!,.[]-_()'
	sarr1=schr;
	retstatus=true;
	for(var i=0;i <= sval.length;i++)
	{
		var sval1=sarr.indexOf(sval.charAt(i));
		var sval2=sarr1.indexOf(sval.charAt(i));
		//alert(sval1);
		if((sval1!=-1) && (sval2==-1))
		{
			retstatus=false;
			break;
		}
	}
	return retstatus;	
}

//Added by Anish on 22-07-2008 for SCF 9IT98/GSUP08/03
// function to validate for a string, returns true/false.
function isString(obj)
{			
			var numaric = obj.toString();	
		    var flag;  
			for(var j=0; j<numaric.length; j++)
			{
				var alphaa = numaric.charAt(j);
				var hh = alphaa.charCodeAt(0);
				if((hh >64 && hh<91) || (hh > 96 && hh<123))
				{
					flag=false;
				}
				else
				{
					flag=true;
				}
			}			
			return (flag);
}

function comboset(obj,cmbname,setcmbvalue)
{
	objcmb=eval(obj + "." +cmbname);
	
	for (i=0;i<=(objcmb.length-1);i++)
	{
		//alert(objcmb[i].value + ' : ' + setcmbvalue )
		if ((objcmb[i].value)==setcmbvalue)
		{
			objcmb.selectedIndex=i
		//	alert("set")
			break;
		}
	}
}


function multiComboSet(obj,cmbName,setStr)
{
	var i,j,ln;
	ln=obj[cmbName].length
	splitStr=setStr.split(',')
	obj[cmbName][0].selected=false;
	for (i=0; i<=splitStr.length-1;i++)
	{
		//alert ('[' + trimStr(splitStr[i]) + ']')
		for (j=0; j<=ln-1;j++)
		{
				if (obj[cmbName][j].value==trimStr(splitStr[i]))
				{
					obj[cmbName][j].selected=true;
				//	alert('is set [' + splitStr[i] + ']')
					break;
				}
		}
	}
}

function trimStr(str)
{		
	str1=str.length;
	for(i=str1-1;i>=0;i--)
	{			
		if(str.charAt(i)!=' ') break;		
	}

	str2=str.substring(0,i+1)

	for(j=0;j<=i+1;j++)
	{	
		if(str2.charAt(j)!=' ') break;
	}

	str2=str2.substring(j,i+1);
	return str2;
}

function allZeros(obj)
{
	if (typeof(obj)=='object') obj=obj.value
	for (i=0;i<obj.length;i++)
		if (obj.charAt(i) !='0') return false;
	return true;
}

function ValidateDate(dpart) {
	var numStr = dpart;
	var SplChar = "";
	var vdates = " Valid date formats are DD/MM/YYYY or DD-MM-YYYY";

	/* Checking for valid date formats. Allowed date part separators are
	'/' and '-' only. Both are not allowed in same date.
	Date format allowed are DD-MM-YYYY or DD/MM/YYYY*/

	/* Check for special characters other than /, - and numbers*/

	if (IsExistsInStr(numStr, "9/"))
		SplChar = "/";
	else if (IsExistsInStr(numStr, "9-"))
		SplChar = "-";
	else {
		alert("Date format is invalid in " + numStr + ". " + vdates);
		return false;
	}

	/* Check for no. of appearences of / or - whatever is appeared */

	AppearCount = 0;
	for (var i=0; i < numStr.length; i++)
		numStr.substring(i, i+1) == SplChar ? AppearCount++ : AppearCount;

	if (AppearCount != 2) {
		alert("Date format is invalid in " + numStr + ". " + vdates);
		return false;
	}

	//Getting position of first appearence of date separator
	var FirstDiv = numStr.indexOf(SplChar);

	//Getting position of first appearence of date separator
	var SecondDiv = numStr.indexOf(SplChar, FirstDiv+1);

	//Getting day from the date value
					
	var month = numStr.substring(0, FirstDiv);
	var day   = numStr.substring(FirstDiv+1,SecondDiv);
	if ((day.substring(0,1) == "0") && (day.length == 2))
			day = day.substring(1,2);

	//Getting month from the date value
					
	if ((month.substring(0,1) == "0")  && (month.length == 2))
			month = month.substring(1,2);
					
	//Getting year from the date value
	var year = numStr.substring(SecondDiv+1,numStr.length);
	if (year.length > 4) {
		alert("Year is invalid in " + numStr + ". "+ vdates);
		return false;
	}

		if (parseInt(day) < 1 || parseInt(day) > 31) {
		alert("Day is invalid " + numStr + ". " + vdates);
		return false;
	}

	if (parseInt(month) < 1 || parseInt(month) > 12) {
		alert("Month is invalid in " + numStr + ". " + vdates);
		return false;
	}

					
	if ((year.length != 4) || parseInt(year) < 1) {
		alert("Year is invalid in " + numStr + ". " + vdates);
		return false;
	}
				 
				 
	MonDays = parseInt(MaxDaysInMonth(month, year)); 
	if (parseInt(day) > parseInt(MonDays)) {
		alert("Day is invalid in " + numStr + ". Maximum possible value for day " + MonDays);
		return false;
	}

	//alert(" your dateparts are \n day = " + day + " \n month = " + month + " \n year = " +year);
	return true;

}

function DateDiff(FDate,TDate)
{
	FDiff=Date.parse(FDate);
	TDiff=Date.parse(TDate);
	Diff=TDiff-FDiff;
	Days=Diff/86400000;
	return (Days);
}
/*This functions checks whether value passed as parameter to this
  is empty or not. It it is empty it returns true otherwise returns
  false */

function IsEmpty(data) {

	for (var i=0; i < data.length; i++) {
		if (data.substring(i, i+1) != " ")
			return (false);
		}
	return (true);

}

function IsLeapYear(Year) {
	return ((parseInt(Year)-parseInt(parseInt(Year)/4)*4) == 0);
}

function MaxDaysInMonth(Month, Year) {
	
	var MaxDays=0;
	var Str31="12010305070810";
	var Str30="04060911";

	if (Month.substring(0,1) != "0" && Month.length < 2)
		Month = "0"+Month;

	MaxDays = 28;
	if (Str31.indexOf(Month) != -1)
		MaxDays = 31;
	else if (Str30.indexOf(Month) != -1)
		MaxDays = 30;
	else if (IsLeapYear(Year))
			MaxDays = 29;

	return MaxDays;
}

function GetMonth(DateVal) {
	if (IsDateValid(DateVal)) {

		var numStr = DateVal;
		if (IsExistsInStr(numStr, "9/"))
			SplChar = "/";
		else if (IsExistsInStr(numStr, "9-"))
			SplChar = "-";

		var FirstDiv = numStr.indexOf(SplChar);
		var SecondDiv = numStr.indexOf(SplChar, FirstDiv+1);
		
		//Getting month from the date value
		var month = numStr.substring(FirstDiv+1,SecondDiv);
		if ((month.substring(0,1) == "0")  && (month.length == 2))
				month = month.substring(1,2);
		
		alert(month);
		return month;

	}
	else
		return -1;

}


function GetYear(DateVal) {
	if (IsDateValid(DateVal)) {
		var SplChar = "";
		var numStr = DateVal;
		if (IsExistsInStr(numStr, "9/"))
			SplChar = "/";
		else if (IsExistsInStr(numStr, "9-"))
			SplChar = "-";

		var FirstDiv = numStr.indexOf(SplChar);
		var SecondDiv = numStr.indexOf(SplChar, FirstDiv+1);
		
		//Getting month from the date value
		alert(numStr.substring(SecondDiv+1,numStr.length));
	
	}
	else
		return -1;

}

function GetDay(DateVal) {
	if (IsDateValid(DateVal)) {

		var numStr = DateVal;
		var SplChar = "";

		if (IsExistsInStr(numStr, "9/"))
			SplChar = "/";
		else if (IsExistsInStr(numStr, "9-"))
			SplChar = "-";
		
		var FirstDiv = numStr.indexOf(SplChar);
		var SecondDiv = numStr.indexOf(SplChar, FirstDiv+1);

		//Getting day from the date value
		var day = numStr.substring(0, FirstDiv);
		if ((day.substring(0,1) == "0") && (day.length == 2))
				day = day.substring(1,2);

		alert(day);
		return day; 
	}
	else
		return -1;
}



function IsFloatValid(FloatData) {

	var AppearCnt=0;

	if (IsExistsInStr(FloatData, "9.")) {
		for (var i=0; i < FloatData.length; i++) {
			if (FloatData.substring(i, i+1) == ".")
				AppearCnt++;
		}
	}
	else
		AppearCnt=2;

	return (AppearCnt > 1)? false : true;
}

	
function makeArray(arraySize){
	this.length=arraySize;
	for (var x=0;x<=arraySize;x++)
	{
	this[x]=0;
	}
	return this;
}


function makeArray2D(rows,cols){
	var arraySize=rows*cols;
	this.length=arraySize;
	this.rows=rows;
	this.cols=cols;
	for (var x=1;x<=arraySize;x++)
		{
		this[x]=0;
		}
		return this;		
	}

function getarrayvalue(ob,rowpos,colpos)
{
	
	if ((rowpos>ob.rows)||(rowpos<1))
	{
		alert("Error! Row out of bound");
		return false;
	}
	if ((colpos>ob.cols)||(colpos<1))
	{
		alert("Error! Cols out of bound");
		return false;
	}
	position=(rowpos-1)*ob.cols+colpos;
	return ob[position];
}

function setarrayvalue(ob,rowpos,colpos,posval)
{
	if ((rowpos>ob.rows)||(rowpos<1))
	{
		alert("Error! Row out of bound");
		return false;
	}
	if ((colpos>ob.cols)||(colpos<1))
	{
		alert("Error! Cols out of bound");
		return false;
	}
	position=(rowpos-1)*ob.cols+colpos;
	ob[position]=posval;
}



function Split(SpStr)
{
	var rowcount=0;
	var colcount=0;
	for (i=0;i< Concatenate.length;i++)
	{
		if  (Concatenate.charAt(i)=="|")
			rowcount=rowcount+1;
	}
	for (i=0;i< Concatenate.length;i++)
	{
		if  (Concatenate.charAt(i)==":")
			colcount=colcount+1;
		if  (Concatenate.charAt(i)=="|")
			{
			colcount=colcount+1;
			break;
			}
	}
	currentval="";
	count=1;
	resarray=new makeArray2D(rowcount,colcount);
	for (i=0;i< Concatenate.length;i++)
	{
		if  (Concatenate.charAt(i)==":"||Concatenate.charAt(i)=="|")
			{
				resarray[count]=currentval;
				count=count+1;
				currentval="";
			}
		else	
			{
				currentval=currentval+Concatenate.charAt(i);
			}
		
	}
	return (resarray);
}

function Right(str, n)
 /*	IN: str - the string we are RIGHTing 
n - the number of characters we want to return
RETVAL: n characters from the right side of the string
*/ 
{
 if (n <= 0) // Invalid bound, return blank string
 	return ""; 
else if (n > String(str).length) // Invalid bound, return 
return str; // entire string
 else { // Valid bound, return appropriate substring 
var iLen = String(str).length;
 	return String(str).substring(iLen, iLen - n); 
}
}

 function Len(str)
 /*
         IN: str - the string whose length we are interested in
         RETVAL: The number of characters in the string
*/
 {return String(str).length;}



 function Mid(str, start, len)
 /*
         IN: str - the string we are LEFTing
             start - our string's starting position (0 based!!)
             len - how many characters from start we want to get
            RETVAL: The substring from start to start+len
 */
 {
         // Make sure start and len are within proper bounds
         if (start < 0 || len < 0) return "";
         var iEnd, iLen = String(str).length;
         if (start + len > iLen)
                 iEnd = iLen;
         else
                 iEnd = start + len;
         return String(str).substring(start,iEnd);
 }
 
 // from here functions are added for the promotr8
 function hasSpecialCharacters(field, errorMsg){   
	var SpecialCharacters="`~!@#$%^&*()_-=+><{}[]|=?':;\\/,'.\"";
	if (field.value.length >= 0)	{
		for(i=0; i<SpecialCharacters.length; i++)	{
			if(field.value.indexOf(SpecialCharacters.substr(i, 1))>= 0)	{ 
				alert (errorMsg);
				field.focus();
				return true;
			}
		}
		return false;
	}	
	return false;
}

/*
function trim(inputString) {
   // Removes leading and trailing spaces from the passed string. Also removes
   // consecutive spaces and replaces it with one space. If something besides
   // a string is passed in (null, custom object, etc.) then return the input.
   if (typeof inputString != "string") { return inputString; }
   var retValue = inputString;
   var ch = retValue.substring(0, 1);
   while (ch == " ") { // Check for spaces at the beginning of the string
      retValue = retValue.substring(1, retValue.length);
      ch = retValue.substring(0, 1);
   }
   ch = retValue.substring(retValue.length-1, retValue.length);
   while (ch == " ") { // Check for spaces at the end of the string
      retValue = retValue.substring(0, retValue.length-1);
      ch = retValue.substring(retValue.length-1, retValue.length);
   }
   while (retValue.indexOf("  ") != -1) { // Note that there are two spaces in the string - look for multiple spaces within the string
      retValue = retValue.substring(0, retValue.indexOf("  ")) + retValue.substring(retValue.indexOf("  ")+1, retValue.length); // Again, there are two spaces in each of the strings
   }
   return retValue; // Return the trimmed string back to the user
} // Ends the "trim" function
*/

function isemail (s) {
	if (isemptyNet(s)) 
       if (isemail.arguments.length == 1) return defaultEmptyOK;
       else return (isemail.arguments[1] == true);
   
    // is s whitespace?
    if (isWhitespace(s)) return false;
    
    // there must be >= 1 character before @, so we
    // start looking at character position 1 
    // (i.e. second character)
    var i = 1;
    var sLength = s.length;

    // look for @
    while ((i < sLength) && (s.charAt(i) != "@")){
		i++;
    }

    if ((i >= sLength) || (s.charAt(i) != "@")) return false;
    else i += 2;

    // look for .
    while ((i < sLength) && (s.charAt(i) != ".")){
		i++;
    }

    // there must be at least one character after the .
    if ((i >= sLength - 1) || (s.charAt(i) != ".")) return false;
    else return true;
}

// Returns true if string s is empty or 
// whitespace characters only.

function isWhitespace (s){   

   var i;

    // Is s empty?
    if (isemptyNet(s)) return true;

    // Search through string's characters one by one
    // until we find a non-whitespace character.
    // When we do, return false; if we don't, return true.

    for (i = 0; i < s.length; i++)
    {   
        // Check that current character isn't whitespace.
        var c = s.charAt(i);

        if (whitespace.indexOf(c) == -1) return false;
    }

    // All characters are whitespace.
    return true;
}


// Check whether string s is empty.
//name for ismepty to isemptyNet is changed for promotr8
function isemptyNet(s){   
   return ((s == null) || (s.length == 0))
}


// (0 .. 9).// Returns true if character c is a digit 
function isDigit (c){   
   return ((c >= "0") && (c <= "9"))
}


//This function moves the elements from one select box to another
	
	function moveSelectedOptions(from,to) {
		var blnisSelected = false;
		for (var i=0; i<from.options.length; i++) {
			var o = from.options[i];
			if (o.selected) {
				blnisSelected = true;
				if (!hasOptions(to)) { var index = 0; } else { var index=to.options.length; }
					to.options[index] = new Option( o.text, o.value, false, false);
			}
		}
		// Delete them from original
		for (var i=(from.options.length-1); i>=0; i--) {
			var o = from.options[i];
			if (o.selected) {
				from.options[i] = null;
			}
		}
		if (blnisSelected == false) {
			alert("Select an item.");
			return;
		}
		from.selectedIndex = -1;
		to.selectedIndex = -1;
	}
	
	
	function hasOptions(obj) {
		if (obj!=null && obj.options!=null) { return true; }
		return false;
	}

function disableCopyPaste() {
		var pressedKey = String.fromCharCode(event.keyCode).toLowerCase();
		if (event.ctrlKey && (pressedKey == "v")) {
			event.returnValue = false;
		}
	}

 function space(data,noofspace){   
	var Space=" ";
	for (i=0; i<noofspace;i++) {
			data=data + Space;
	}	
	return data;
}
function paddingZeros(data){ 
  
	var strtotal=String(data);
	if (strtotal.indexOf(".") == -1 )
		strtotal=strtotal +".00"
	else{
		var strtemp=strtotal.substring(strtotal.indexOf(".")+1);
		if (strtemp.length==1)
			strtotal=strtotal +"0"
	}
	return strtotal;
}
function Validatetest1() {
    alert('Test');
}

// repalce the string with specified string
function stringReplace(whichstr,findstring,replacestring)
 
{
   var s = new String(whichstr); 
   var newstr="";
   if (s.indexOf(findstring) != -1) { 
      var fromwhere=0;;
      while (s.indexOf(findstring) != -1) {
         fromwhere=s.indexOf(findstring);
         newstr= newstr + s.substring(0,fromwhere) +  replacestring;
         s=s.substring(fromwhere+1);
      }//while
   } //if
   newstr= newstr + s;
   return newstr; 
}
// Creation of XMLHTTP object

function createXMLHTTP() {
    var aVersions = [   
    //  "MSXML2.XMLHTTP.7.0",
      //"MSXML2.XMLHTTP.6.0",
      "MSXML2.XMLHttp.5.0",
      "MSXML2.XMLHttp.4.0",
      "MSXML2.XMLHttp.3.0",
      "MSXML2.XMLHttp",
      "Microsoft.XMLHttp"];
    for (var i = 0; i < aVersions.length; i++) {
        try {
            var oXmlHttp
            if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
                oXmlHttp = new XMLHttpRequest();
            }
            
            else{
           oXmlHttp = new ActiveXObject(aVersions[i]);
           }
            return oXmlHttp;
        } catch (oError) {
           //Do nothing
        }
    }
    //throw new Error("MSXML is not installed.");
}