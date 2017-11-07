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

public class NewCreateBulletinMessage extends TestNG_UI_EXTENSIONS {

	public NewCreateBulletinMessage() throws Exception {
		super();
	}

	/******************************************************************
	'Description : Verify that a new message can be created by entering mandatory data only. 
	'Precondition:
	'Date	 	 : 26-Jun-2015
	'Author		 : Rensuhree
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Verify that a new message can be created by entering mandatory data only. ")
	public void testHappyDay165() throws Exception {

		gstrTCID = "165";
		gstrTO = "Verify that a new message can be created by entering mandatory data only. ";

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

		objCalendar1.verMessageBulletinBoardPgeIsDispalyed(objLogindata.strCurrentYear)
				.clickOnCreateNewMessage()
				.verCreateBulletinMessagePgeIsDispalyed()
				.createMessgae(strMsgDate, objCalendar_data.strTitle,
						objCalendar_data.strMessage,
						objCalendar_data.strContact);

		objCalendar1.verActionColumn()
				.verTitleOfMessage(objCalendar_data.strTitle)
				.verDateOfMessage(strVerifyMsgDate)
				.verMessage(objCalendar_data.strMessage)
				.verContactOfMessage(objCalendar_data.strContact);

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
}
