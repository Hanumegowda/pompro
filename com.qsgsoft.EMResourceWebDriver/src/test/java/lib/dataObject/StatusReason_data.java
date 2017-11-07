package lib.dataObject;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;

public class StatusReason_data {
	
	Date_Time_settings objDate_Time_settings = new Date_Time_settings();
	String strTimeText = objDate_Time_settings.getCurrentDate("MM/dd/yyyy-hhmmss");
	
	public String strReasonName = "Reason" + strTimeText,
			      strReasonName1 = "Reason1" + strTimeText,
			      strReasonName2 = "Reason2" + strTimeText,
			      strReasonName3 = "Reason3" + strTimeText,
				  strReasonDesc = "ReasonDesc",
				  strReasonAbb = "Abb",
				  strEditReasonName= "SR" + strTimeText,
				  strEditReasonDesc = "Testing",
				   strEditReasonAbb = "EAbb";
}
