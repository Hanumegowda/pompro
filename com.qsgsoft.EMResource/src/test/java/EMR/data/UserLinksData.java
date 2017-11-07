package EMR.data;
import qaFramework.UserDefinedFunctions.Date_Time_settings;
import qaFramework.UserDefinedFunctions.ReadAndWriteFromXMLFile;

public class UserLinksData {
	
	public UserLinksData() throws Exception {
		
	}
	ReadAndWriteFromXMLFile xml = new ReadAndWriteFromXMLFile();
	static final String FILEPATH = "UsersDataXml";
	
	public static final String INITIAL_PASSWORD	= "abc123",
			IMAGE_TO_UPLOAD_PATH= "ImageToUploadForUserLinks",
			SHOWAS_HIDE			= "(Hide)",
			SHOWAS_USER_LINK	= "User Link",
			SHOWAS_QUICK_LINK	= "Quick Link",
			IMAGE_SIZE			= "53x30",
			FILE_SIZE			= "2.26 kb",
			USER_LINK_URL		= "www.qsgsoft.com",
			QUICK_LINK_URL		= "www.intermedix.com",
			USER_LINK_TITLE		= "Independent Software testing | Test Automation Services",
			QUICK_LINK_TITLE	= "Intermedix | Global Health and Emergency Response";
	        
	public class UserLinksCreateData {
		
	Date_Time_settings dts = new Date_Time_settings();
	String timeText = dts.getCurrentDate("MM-dd-yyyy-hhmmss"),
			timeStamp = "" + System.currentTimeMillis();
 
	public void writeUsersDataToXml(String value, String node) throws Exception {
		xml.write(FILEPATH, value, node);
	}
	
	public String label = "Label"  + timeText,
			label1 = "User1" + timeText;
	}
	
	public static class UserLinksTags {
	
	}

}