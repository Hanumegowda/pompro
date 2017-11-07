package dataObject;

import java.util.Properties;
import qaframework.lib.userDefinedFunctions.Date_Time_settings;
import qaframework.lib.userDefinedFunctions.PathsProperties;

public class Login_data {
	
	Date_Time_settings objDate_Time_settings = new Date_Time_settings();
	String strTimeText = objDate_Time_settings.getCurrentDate("MM/dd/yyyy-hhmmss");
	public static String strTestDataPath, strPartialAutoResultsPath, strBuildName;
	
	public Login_data() throws Exception  {
		// TODO Auto-generated constructor stub
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();
		String TestData_path = pathProps.getProperty("TestData_path");
		 strTestDataPath = System.getProperty("user.dir")+TestData_path;
		 String WriteResultPath = pathProps.getProperty("WriteResultPath");
		strPartialAutoResultsPath = System.getProperty("user.dir")+WriteResultPath;
		String Build_Id = pathProps.getProperty("Build_Id");
		strBuildName = Build_Id;
	}
	
	public String strAdminUser = "admin",
		          strAdminUserPwd = "medweb09",
		          strNewPwd = "qsg@2015",
		          strNewPwdAgain = "qsg@2015",
		          strAppURL = "http://172.16.27.93",
		          //strAppURL = "172.16.27.93",
		          strAppURL1 = "http://172.16.27.92",
		          strAppURLfor91 = "http://172.16.27.91",
		          strAppURLfor94 = "http://172.16.27.94",
		          server = "172.16.27.93",
		          serverInformation = "Medweb DICOM and all artwork herein are trademarks of Medweb and Nexsys Electronics Inc. All other products and companies referred to herein are trademarks or are registered trademarks of their respective companies or mark holders.",
	              serverInformation1 = "Copyright 1998-2013",
	              serverInformation2 = "Information in and about this product is subject to change without notice.";
		          
		          	          
}



