package lib.dataObject;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;

public class InstantMessaging_data {

	Date_Time_settings objDate_Time_settings = new Date_Time_settings();
	String strTimeText = objDate_Time_settings
			.getCurrentDate("MM/dd/yyyy-hhmmss");

	public String strUserType = "Role (Type of Users)";
}
