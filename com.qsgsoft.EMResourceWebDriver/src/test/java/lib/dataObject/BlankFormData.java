package lib.dataObject;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;

public class BlankFormData {
	
	Date_Time_settings objDate_Time_settings = new Date_Time_settings();
	String strTimeText = objDate_Time_settings.getCurrentDate("MM/dd/yyyy-hhmmss");
	
	public String strNumericAnswer = "5",
				strCurrentDate = objDate_Time_settings.getCurrentDate("MM/dd/yyyy"),
			    strTextAnswer="text",
			    strTextAnswer1="textOne",
			    strTextAnswer2="textTwo",
			    strTextAnswer3="This is sample text",
			    strTextAreaAnswer = "This is a Sample text " + strTimeText,
			    strTextAreaAnswer1 = "This is second Sample text " + strTimeText,
			    strTextAreaAnswer2 = "This is third Sample text " + strTimeText,
			    strTextAreaAnswer3 ="This is sample text",
			    strSinglelineTextAnswer="SingleLineText",
			    strNumericAnswer1 = "5%",
			    strMultiLineTextAnswer="MultiLineText",
			    strNumericAnswer2 = "$10",
			    strNumericAnswer3 = "8",
			    strNumericAnswer4="3",
			    strCurrentTime = objDate_Time_settings.timeNow("hh:mm"),
			    strCurrentDateTime = strCurrentDate + " " + strCurrentTime,
			    strBooleanAnswer="Yes",
			    srtrFormPageName = "Form Detail Report",
			    strBooleanNoAnswer="No",
			    num1="1",
			    num2="2",
			    num3="3",
			    strXDaysAgoCount="2",
			    strYDaysFromNowCount ="4";
			    
			    
}
