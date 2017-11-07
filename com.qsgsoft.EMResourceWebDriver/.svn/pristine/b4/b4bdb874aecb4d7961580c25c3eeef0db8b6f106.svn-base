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

public class NewEditBulletinMessage extends TestNG_UI_EXTENSIONS {

	public NewEditBulletinMessage() throws Exception {
		super();
	}

	/******************************************************************
	'Description : Verify that a message can be edited. 
	'Precondition:
	'Date	 	 : 26-Jun-2015
	'Author		 : Rensuhree
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Verify that a message can be edited. ")
	public void testHappyDay171() throws Exception {

		gstrTCID = "171";
		gstrTO = "Verify that a message can be edited. ";

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
		String strMsgDate1 = dts.AddDaytoExistingDate(strMsgDate, 1,
				"MM/dd/yyyy");
		String strVerifyMsgDate = dts.converDateFormat(strMsgDate,
				"MM/dd/yyyy", "yyyy-MM-dd");
		String strVerifyMsgDate1 = dts.converDateFormat(strMsgDate1,
				"MM/dd/yyyy", "yyyy-MM-dd");

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToCalendarInRegionalInfo();

		objCalendar1
				.verMessageBulletinBoardPgeIsDispalyed(
						objLogindata.strCurrentYear)
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

		objCalendar1
				.clickOnEditMsg(objCalendar_data.strTitle)
				.verEditMessageBulletinPgeIsDispalyed()
				.verAllDetailsRetained(objCalendar_data.strTitle,
						objCalendar_data.strMessage,
						objCalendar_data.strContact, strMsgDate)
				.createMessgae(strMsgDate1, objCalendar_data.strTitle1,
						objCalendar_data.strMessage1,
						objCalendar_data.strContact1);

		objCalendar1
				.verMessageBulletinBoardPgeIsDispalyed(
						objLogindata.strCurrentYear).verActionColumn()
				.verTitleOfMessage(objCalendar_data.strTitle1)
				.verDateOfMessage(strVerifyMsgDate1)
				.verMessage(objCalendar_data.strMessage1)
				.verContactOfMessage(objCalendar_data.strContact1);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
}
