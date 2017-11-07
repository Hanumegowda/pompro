package lib.dataObject;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;

public class Calendar_data {
	
	Date_Time_settings objDate_Time_settings = new Date_Time_settings();
	String strTimeText = objDate_Time_settings.getCurrentDate("MM/dd/yyyy-hhmmss");
	
	public String strTitle = "Title" +strTimeText,
			      strTitle1="Title1" +strTimeText,
			      strEditTittle="Edit"+strTitle1,
			      strEditTittle1="Edit1"+strTitle1,
				  strMessage = "Automation",
				  strContact = "autoemr@qsgsoft.com",
				  strMessage1 = "Auto",
				  strContact1 = "autoemr_1@qsgsoft.com";
}
