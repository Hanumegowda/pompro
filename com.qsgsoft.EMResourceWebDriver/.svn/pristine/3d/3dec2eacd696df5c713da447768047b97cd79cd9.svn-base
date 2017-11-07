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

public class NewEdgeCaseCreateBulletinMessage extends TestNG_UI_EXTENSIONS {

	public NewEdgeCaseCreateBulletinMessage() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/******************************************************************
	'Description : Verify that a message can be created for previous year.
	'Precondition:
	'Date	 	 : 25-Feb-2016
	'Author		 : Pallavi
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Verify that a message can be created for previous year.")
	public void testEdgeCase168() throws Exception {

		gstrTCID = "168";
		gstrTO = "Verify that a message can be created for previous year.";

		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Login_data objLogindata = new Login_data();
		Calendar objCalendar1 = new Calendar(this.driver1);
		Date_Time_settings dts = new Date_Time_settings();
		Calendar_data objCalendar_data = new Calendar_data();

		String strMsgDate = dts.timeNow("MM/dd");
		String strPrevYear = dts.getFutureYear(-1, "yyyy");
		strMsgDate = strMsgDate + "/" + strPrevYear;
		System.out.println(strMsgDate);
		String strVerifyMsgDate = dts.converDateFormat(strMsgDate,
				"MM/dd/yyyy", "yyyy-MM-dd");

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToCalendarInRegionalInfo();

		objCalendar1
				.verMessageBulletinBoardPgeIsDispalyed(
						objLogindata.strCurrentYear)
				.clickOnCreateNewMessage()
				.verCreateBulletinMessagePgeIsDispalyed()
				.enterTitle(objCalendar_data.strTitle)
				.enterMessage(objCalendar_data.strMessage)
				.enterContact(objCalendar_data.strContact)
				.selectYear(strPrevYear)
				.enterDate(strMsgDate)
				.clickOnSave();

		objCalendar1.clickOnPreviousYearLink()
					.verMessageBulletinBoardPgeIsDispalyed(strPrevYear)
					.verActionColumn()
					.verTitleOfMessage(objCalendar_data.strTitle)
					.verDateOfMessage(strVerifyMsgDate)
					.verMessage(objCalendar_data.strMessage)
					.verContactOfMessage(objCalendar_data.strContact);

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/******************************************************************
	'Description : Cancel the process of creating a message and verify that message is not created.
	'Precondition:
	'Date	 	 : 25-Feb-2016
	'Author		 : Pallavi
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Cancel the process of creating a message and verify that message is not created.")
	public void testEdgeCase170() throws Exception {

		gstrTCID = "170";
		gstrTO = "Cancel the process of creating a message and verify that message is not created.";

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
		System.out.println(strMsgDate);

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToCalendarInRegionalInfo();

		objCalendar1
				.verMessageBulletinBoardPgeIsDispalyed(
						objLogindata.strCurrentYear)
				.clickOnCreateNewMessage()
				.verCreateBulletinMessagePgeIsDispalyed()
				.enterTitle(objCalendar_data.strTitle)
				.enterMessage(objCalendar_data.strMessage)
				.enterDate(strMsgDate).clickOnCancel()
				.verTitleIsNotPresent(objCalendar_data.strTitle);
				
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
}
