package lib.dataObject;

import java.util.Properties;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.PathsProperties;

public class Login_data {
	Date_Time_settings objDate_Time_settings = new Date_Time_settings();
	String strTimeText = objDate_Time_settings.getCurrentDate("MM/dd/yyyy-hhmmss");
	public static String strTestDataPath, strPartialAutoResultsPath, strBuildName;
	String strYear = objDate_Time_settings.getCurrentDate("yyyy");
	
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
	
	public String strUserName = "qsgtester",			 	  
			      strPassword = "Abc@1234",
			      strNewPassword = "Abc@1234",
			      strQSGFullName = "QSG Tester",
			      strRegionName ="Z_Auto_BQSPatch_rel12",
			      strQuickLinkRegion = "Z_QuickLink_Region",		
			      strRegionName8="Z_BQS2-rel10-27Jul",
			      strRegionName1 = "Z_Automation_Region1",
			      strRegionName2 = "Z_Automation_Region2",
			      strRegionName3 = "Statewide Florida",
			      strRegionName4 = "Florida RDSTF 5 ",
			      strRegionName5 = "Colorado",
			      strArkansasReg = "Arkansas",
			      strSetracReg ="SETRAC",
			      strIMXSystemAdmin="IMX System Admin",
			      strFlowridaReg2="Florida RDSTF 2",
			      strArkansasRegVal = "2219",
			      strSetracRegVal = "2220",
			      timeZone = "CDT",
			      strStateOfMissouri = "State of Missouri",
	    		  strAdminUser = "qsgtester",
			      strAdminUserPwd = "Abc@1234",
			      strSpringfieldReg = "New Mexico", /*"Springfield, USA",    SpringField, USA region not to be used as per the mail received by CHUCK*/
			      strNewMexicoReg = "New Mexico",
			      strEicsAdminUser = "qsgtester",
			      strEicsAdminPwd = "Abc@1234",
			      strStateOfMissouriValue = "2218",
			      strComment = "Comment", 
			      strLastUpdate = "Last Update",
			      strUpdatedBy = "By User",
			      strSummary = "Summary",
			      strRegionDefaultSnapShot= "Region Region Default snapshot",
			      strStatusTypes = "Status Type",
			      strStatus = "Status",
			      strIconName="/icon/eventics.png",
			      strStateWideReg = "Statewide Oklahoma",
			      strArkansasRegVal2 = "2155",
			      strRegionName7="Z_Smoke_Build_9278",
			      strStateWideOklahomaVal = "2153",
			      strAmariloTXReg = "Amarillo, TX",
			      strSouthTexasReg = "South Texas",
			      strAmariloTXRegVal = "1817",
			      strQuestionLast4DigitsOfDL = "What are the last 4 digits of your driver license?",
			      strAnsForLast4DigitsOfDL = "1234",
			      strAnswerLast4DigitsOfDL = "5429",
			      strSystemNoticeTitle = "System Notice "+strTimeText,
			      strSystemNoticeTitle1 = "System Notice1 "+strTimeText,
			      strDescription = "Description "+strTimeText,
			      strOklahomaReg = "Oklahoma",
			      strCurrentYear = strYear,
			      strEMRVersion = "3.28.4",
			      strEMRBuild = "11385",
			      strEMRServer = "01",
			      strDomainName = "TEST",
			      strRegionStatewideFlorida = "Statewide Florida",
			      strRegionkansas = "Kansas",
                  RegionNames[] = {"Z_BQS_build_11376", "Z_BQS_build_11385",
					"Z_BQS_build_11808", "Z_BQS_build_11817",
					"Z_BQS_Build_9630", "Z_BQS_build_9675", "Z_FTS2_Build_116",
					"Z_FTS_Build_116", "Z_Smoke_build_11376",
					"Z_Smoke_build_11376" },
	              strQuestion = "What is the last name of your favorite high school teacher?",
                  strAnswer = "Andrius",
                  strEmTSetracREg="SETRAC Region",
                  strAbileneRegion="Abilene, TX",
                  strTexacBracRegion="Texas BRAC",
                  strTexacBracOtherRegionValue="1694",
                  strStOklahomaOtherRegValFromAmrillo= "2212",
                  strIMXSystemAdminRegion = "IMX System Admin",
                  strNewRegionName = "Z_BQS_build_Code20";
	
}
