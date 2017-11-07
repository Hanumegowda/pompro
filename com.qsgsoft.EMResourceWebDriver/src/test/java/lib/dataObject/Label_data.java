package lib.dataObject;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;

public class Label_data {
	
	Date_Time_settings objDate_Time_settings = new Date_Time_settings();
	String strTimeText = objDate_Time_settings.getCurrentDate("MM/dd/yyyy-hhmmss");
	
	public String strLabelName = "Label" +strTimeText,
			strURL = "https://google.com",
			strPathOfTheFile = "D:\\SeleniumPracticeCode\\com.qsgsoft.EMResourceWebDriver\\src\\test\\resources\\UploadFiles\\GetLinkImage42.jpg",
			strShowAsHide = "(Hide)",
			strShowAsUserLink = "User Link",
			strImageSize = "53x30",
			strFileSize = "2.26 kb";
}
