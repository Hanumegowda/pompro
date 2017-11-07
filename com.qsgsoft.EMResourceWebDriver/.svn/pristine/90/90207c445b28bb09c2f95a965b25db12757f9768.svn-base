package requirementGroup.SmokeTestSuite;

import java.io.File;
import java.util.Properties;

import lib.dataObject.Calendar_data;
import lib.dataObject.Login_data;
import lib.dataObject.RegionalInfo_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.Calendar;
import lib.page.EventManagement;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.RegionalInfo;
import lib.page.SelectRegion;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.PathsProperties;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class SmokeRegionalInfo extends TestNG_UI_EXTENSIONS {

	public SmokeRegionalInfo() throws Exception {
		super();
	}
	
	/******************************************************************
	'Description : Verify that a document can be added in a folder.
	'Precondition:
	'Date	 	 : 09-Sep-2014
	'Author		 : Sinchana
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Verify that a document can be added in a folder.")
	public void testSmoke124382() throws Exception {

		gstrTCID = "124382";
		gstrTO = " Verify that a document can be added in a folder. ";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		RegionalInfo_data objRegionalInfo_data = new RegionalInfo_data();
		Date_Time_settings objDts = new Date_Time_settings();

		Login objLogin = new Login(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigateToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		RegionalInfo objRegionalInfo1 = new RegionalInfo(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);

		String fileDownloadPath = pathProps
				.getProperty(objRegionalInfo_data.strFileUpload);

		File file = new File(System.getProperty("user.dir") + fileDownloadPath);
		String strPath = file.toString();

		objLogin.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault.selectFrame();

		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selecMaintainDocumentLibraryOption()
				.selectEditRegionalMessageBulletinBoard().clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		objLogin.clickLogOut();

		System.out.println(objUser_data.strNewUserName);
		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigateToSubMenus1.navigateToDocumentLibraryInRegionalInfo();

		objRegionalInfo1.clickOnCreateNewFolder()
				.enterFolderName(objRegionalInfo_data.strFolderName)
				.clickOnCreateInAllFoldersRadioBtn();

		objEventManagement1.clickOnSaveButton();

		objRegionalInfo1.verFolderName(objRegionalInfo_data.strFolderName);

		objRegionalInfo1.clickOnAddNewDocument()
				.enterDocumentName(objRegionalInfo_data.strDocumentTitle)
				.clickOnBrowse(strPath).clickOnCreateInAllFoldersRadioBtn();

		objEventManagement1.clickOnSaveButton();

		objRegionalInfo1
				.verifyDocumentName(objRegionalInfo_data.strDocumentTitle);

		String strFetchDateTime = objEventManagement1.getApplicationTime();

		String[] strDate = strFetchDateTime.split(" ");

		String strCurYear = objDts.getTimeOfParticularTimeZone("CST", "yyyy");

		String StrReqDate = strDate[0] + " " + strDate[1] + " " + strCurYear
				+ " " + strDate[2];

		objRegionalInfo1.verifyStartDateAndTimeInDL(
				objUser_data.strNewUserName, StrReqDate);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

	/******************************************************************
	'Description : Verify that a new message can be created
	'Precondition:
	'Date	 	 : 10-Sep-2014
	'Author		 : Rensuhree
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Verify that a new message can be created")
	public void testSmoke122767() throws Exception {

		gstrTCID = "122767";
		gstrTO = "Verify that a new message can be created";

		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Login_data objLogindata = new Login_data();
		Calendar objCalendar1 = new Calendar(this.driver1);
		Date_Time_settings dts = new Date_Time_settings();
		Calendar_data objCalendar_data = new Calendar_data();

		String strMsgDate = dts.timeNow("MM/dd/yyyy");
		String strVerifyMsgDate = dts.converDateFormat(strMsgDate,
				"MM/dd/yyyy", "yyyy-MM-dd");

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToCalendarInRegionalInfo();

		objCalendar1
				.clickOnCreateNewMessage()

				.verCreateBulletinMessagePgeIsDispalyed()

				.createMessgae(strMsgDate, objCalendar_data.strTitle,
						objCalendar_data.strMessage,
						objCalendar_data.strContact).verActionColumn()
				.verTitleOfMessage(objCalendar_data.strTitle)
				.verDateOfMessage(strVerifyMsgDate)
				.verMessage(objCalendar_data.strMessage)
				.verContactOfMessage(objCalendar_data.strContact);

		objLogin1.clickLogOut();
		gstrResult = "PASS";
	}
}