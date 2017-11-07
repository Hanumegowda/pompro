package requirementGroup.RegionalInfoCalendar;

import lib.dataObject.Calendar_data;
import lib.dataObject.Login_data;
import lib.module.NavigationToSubMenus;
import lib.page.Calendar;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.SelectRegion;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewDeleteBulletinMessage  extends TestNG_UI_EXTENSIONS {

	public NewDeleteBulletinMessage() throws Exception {
		super();
	}

	/******************************************************************
	'Description : Verify that a message can be deleted.  
	'Precondition:
	'Date	 	 : 29-Jun-2015
	'Author		 : Rensuhree
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Verify that a message can be deleted.")
	public void testHappyDay175() throws Exception {

		gstrTCID = "175";
		gstrTO = "Verify that a message can be deleted.";

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

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToCalendarInRegionalInfo();

		objCalendar1.verMessageBulletinBoardPgeIsDispalyed(objLogindata.strCurrentYear)
				.clickOnCreateNewMessage()
				.verCreateBulletinMessagePgeIsDispalyed()
				.createMessgae(strMsgDate, objCalendar_data.strTitle,
						objCalendar_data.strMessage,
						objCalendar_data.strContact);

		objCalendar1.verTitleOfMessage(objCalendar_data.strTitle)
		.clickOnDeleteMsg(objCalendar_data.strTitle)
		.verTitleOfMessageIsNotDispalyed(objCalendar_data.strTitle);
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
}
