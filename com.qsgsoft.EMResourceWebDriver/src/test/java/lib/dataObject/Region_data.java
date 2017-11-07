package lib.dataObject;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;

public class Region_data {

	Date_Time_settings objDate_Time_settings = new Date_Time_settings();
	String strTimeText = objDate_Time_settings.getCurrentDate("MM/dd/yyyy-hhmmss");
	
	public String strRegionName = "Z_Auto_"+strTimeText,
			  strTimezone = "(GMT-06:00) Central Time (US, Canada)",
			  strFirstName = "FN"+ strTimeText,
			  strLastName = "LN"+ strTimeText,
			  strRegionFN = "Testing",
			  strInterFaceKey = objDate_Time_settings.getCurrentDate("HHmm"),
		      strRegionOrg ="qsg",
		      strRegionContactAdd = "qsgsoft",
		      strRegionPhone1 = "3456-678-565",
		      strRegionPhone2 = "2342-456-546",
		      strRegionFax = "676-575-5675",
		      strRegionEmail= "autoemr@qsgsoft.com",
		      strRegionDomain1="Test1",
		      strEmailFrequency = "Never",
		      strAlertFrequency = "15",
		      strEditRegionName = "Z_Edit"+strTimeText,
			  strEditTimezone = "(GMT-05:00) Eastern Time (US, Canada)",
			  strEditFirstName = "EditFN"+ strTimeText,
			  strEditLastName = "EditLN"+ strTimeText,
		      strEditEmailFrequency = "Never",
		      strEditAlertFrequency = "30",
			  strDisplayTimeZone="America/Chicago",
			  strViewRefreshInterval="4",
			  strTitle = "SN"+ strTimeText,
			  strDescription = "Des"+ strTimeText,
			  strHoverText = "Maintainanace team",
			  ThreeMinsViewRefreshInterval="3";	
}
