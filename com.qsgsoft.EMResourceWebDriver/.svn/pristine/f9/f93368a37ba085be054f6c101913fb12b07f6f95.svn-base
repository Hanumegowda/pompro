package requirementGroup.CreatingAndManagingEvents;

import java.util.Arrays;

import lib.dataObject.EventSetUp_data;
import lib.dataObject.Event_data;
import lib.dataObject.Login_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.EventManagement;
import lib.page.EventSetUp;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Regions;
import lib.page.SelectRegion;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class EdgeCaseEndMultiRegionEvent extends TestNG_UI_EXTENSIONS{

	public EdgeCaseEndMultiRegionEvent() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/******************************************************************************************
	'Description	 Verify that multi region event cannot be created providing past end date.
	'Date	 		:06-Aug-2014
	'Author			:QSG
	*******************************************************************************************/
	@Test(description = " Verify that multi region event cannot be created providing past end date.")
	public void testEdgeCase133989() throws Exception {

		gstrTCID = "133989";
		gstrTO = "Verify that multi region event cannot be created providing past end date.";
		
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Date_Time_settings objDts = new Date_Time_settings();
		Event_data objEvent_data = new Event_data();

		NavigationToSubMenus NavigationToSubMenus_page = new NavigationToSubMenus(this.driver1);
		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		EventSetUp EventSetUp_page = new EventSetUp(this.driver1);
		Regions Regions_page = new Regions(this.driver1);
		
		String strRegionValue[] = new String[2];
		
		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(this.driver1);
		
		String strRegionNames[] = {objTest_data.strRegionName, objTest_data.strRegionName1};
		Arrays.sort(strRegionNames);
		
		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(strRegionNames[0]);
		
		RegionDefault_page.selectFrame();
		
		NavigationToSubMenus_page.navigateToRegions();
		
		strRegionValue[0] = Regions_page.getRegionValue(strRegionNames[0]);
		System.out.println(strRegionValue[0]);
		
		strRegionValue[1] = Regions_page.getRegionValue(strRegionNames[1]);

		System.out.println(strRegionValue[1]);
		

		// User creation
		UsersList_page
				.navigateToUsersNew()

				.clickCreateNewUserButton()

				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)

				.selectFirstRole()

				.clickAdvancedOptionAndExpand()

				.selectMaintainEventsOption()

				.clickSaveButton()
	
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
					
				.clickRegionsLinkForUser(objUser_data.strNewUserName)
				
				.selectRegion(strRegionValue[1])
				
				.clickSaveButton();
		
		System.out.println(objUser_data.strNewUserName);

		// Event Template creation
		EventSetUp_page.navigateToEventSetUp();

		EventSetUp_page.clickOncreateEventTemplate()

		.enterEventTemplateName(objEventSetUp_data.strEventTemplate)

		.enterEventTemplateDefintion(objEventSetUp_data.strTemplateDefinition)
		
		.selectMultiRegionOption()
		
		.clickSaveButton()

		.deselectSelectAllWebOption();

		System.out.println(objEventSetUp_data.strEventTemplate);
		
		login_page.clickLogOut();
		
		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		RegionDefault_page.selectFrame();
		
		RegionDefault_page.clickRegionLink();
		
		SelectRegion_page.selectRegionAndNavigate(strRegionNames[1]);
		
		RegionDefault_page.selectFrame();
		// User creation
		UsersList_page
				.navigateToUsers()

				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)

				.editUserDetails(objUser_data.strNewUserName)

				.selectFirstRole()
				
				.clickAdvancedOptionAndExpand()

				.selectMaintainEventsOption()

				.clickSaveButton()
		
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
		
				.editUserDetails(objUser_data.strNewUserName)
						
				.clickMultiRegionEventRights()
				
				.selectUserRegion(strRegionValue[0])
				
				.selectUserRegion(strRegionValue[1])
				
				.clickSaveButton()
				
				.clickSaveButton();
		
		System.out.println(objUser_data.strNewUserName);

		// Event Template creation
		EventSetUp_page.navigateToEventSetUp();

		EventSetUp_page.clickOncreateEventTemplate()

		.enterEventTemplateName(objEventSetUp_data.strEventTemplate1)

		.enterEventTemplateDefintion(objEventSetUp_data.strTemplateDefinition)
		
		.selectMultiRegionOption()
		
		.clickSaveButton()

		.deselectSelectAllWebOption();

		login_page.clickLogOut();
		
		String strApplTimeD1 = objDts.getPastDayNew(1,"M/d/yyyy");
		
	    String[] strDate=strApplTimeD1.split("/");
	    
	    System.out.println(strDate[1]);
	    
		System.out
				.println("-----Precondition ends and test execution starts-------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		
		RegionDefault_page1.selectFrame();
				
		// Event  creation		
		EventManagement_page1.navigateToEventManagement()

		.createNewMultiEventButton()

		.enterAdHocEventName(objEvent_data.strEventName)

		.enterAdHocEventDescription(objEvent_data.strEventDescription)

		.selectEventTemplateForMRE(strRegionValue[0], objEventSetUp_data.strEventTemplate)
		
		.selectEventTemplateForMRE(strRegionValue[1], objEventSetUp_data.strEventTemplate1)
		
		.clickEventEndRadioButton()
		
        .selectEventEndDay(strDate[1])
		
	    .clickOnNextButton()
		
		.verifyErrorMessageTitle()

		.verifyPastTimeErrorMessageInCreateAdhocEventPage()
		
		.verifyCreateMultiRegionEventPage();
		gstrResult = "PASS";
	}
	
	/*******************************************************************************************************************
	 * Description	: Verify that canceling the process of ending a multi-region event does not end the event.
	 * Date			: 03-Mar-2016
	 * Author		: Pallavi
	 ********************************************************************************************************************/
	@Test(description = "Verify that canceling the process of ending a multi-region event does not end the event.")
	public void testEdgeCase133941() throws Exception {
		
		gstrTCID = "133941";
		gstrTO	 = "Verify that canceling the process of ending a multi-region event does not end the event.";

		Login_data objTest_data = new Login_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);
		String strRegionValue[] = new String[2];
		String strRegionNames[] = new String[2];

		String strFilePath = Login_data.strTestDataPath;
		
		strRegionNames[0] = objOffCommonFunc.readInfoExcel("MultiRegionEvent",
				2, 2, strFilePath);
		strRegionNames[1] = objOffCommonFunc.readInfoExcel("MultiRegionEvent",
				2, 3, strFilePath);
		
		strRegionValue[0] = objOffCommonFunc.readInfoExcel("MultiRegionEvent",
				3, 2, strFilePath);
		strRegionValue[1] = objOffCommonFunc.readInfoExcel("MultiRegionEvent",
				3, 3, strFilePath);

		String strResourceName = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 16, strFilePath);
		String strResourceName1 = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 17, strFilePath);

		String strEventTemplate = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 18, strFilePath);
		String strEventTemplate1 = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 19, strFilePath);

		String strstatusTypeNames[] = new String[10];
		
		String strAllStatusTypeNames[] = new String[5];
		
		String strAllStatusTypeNames1[] = new String[5];

		for (int intCount = 0; intCount < 10; intCount++) {
			strstatusTypeNames[intCount] = objOffCommonFunc.readInfoExcel(
					"MultiRegionEvent", 2, 4 + intCount, strFilePath);
		}

		for (int intCount = 0; intCount < 5; intCount++) {
			strAllStatusTypeNames[intCount] = objOffCommonFunc.readInfoExcel(
					"MultiRegionEvent", 2, 4 + intCount, strFilePath);
		}
		
		for (int intCount = 0; intCount < 5; intCount++) {
			strAllStatusTypeNames1[intCount] = objOffCommonFunc.readInfoExcel(
					"MultiRegionEvent", 2, 9 + intCount, strFilePath);
		}

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(strRegionNames[0]);

		RegionDefault_page.selectFrame();
		
		// User creation
		UsersList_page
		.navigateToUsers()
		.clickCreateNewUserButton()
		.enterUserDetails(objUser_data.strNewUserName,
				objUser_data.strNewPassword, objUser_data.strFullName)
		.selectFirstRole()
		.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
		.enterEmail(objUser_data.strPrimaryMailId)
		.entertextPagerId(objUser_data.strPrimaryMailId)
		.selectUpdateStatusOfResource(strResourceName)
		.clickAdvancedOptionAndExpand()
		.selectMaintainEventsOption()
		.clickSaveButton()
		.searchUserName(objUser_data.strNewUserName,
				objUser_data.strRole, objUser_data.strResourceType,
				objUser_data.strUsername, objUser_data.strsearchOption)
		.clickRegionsLinkForUser(objUser_data.strNewUserName)
		.selectRegion(strRegionValue[1])
		.clickSaveButton();

		RegionDefault_page.clickRegionLink();

		SelectRegion_page.selectRegionAndNavigate(strRegionNames[1]);

		RegionDefault_page.selectFrame();

		UsersList_page
				.navigateToUsers()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(strResourceName1)
				.selectViewResourceRights(strResourceName1)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName)
				.clickMultiRegionEventRights()
				.verifyEditMultiRegionEventRights()
				.verifyRegionName(strRegionValue[0])
				.verifyRegionName(strRegionValue[1])
				.verifySaveButton()
				.selectUserRegion(strRegionValue[0])
				.selectUserRegion(strRegionValue[1])
				.clickSaveButton()
				.verifyEditUserPageIsDisplayed()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();
		
		System.out.println(objUser_data.strNewUserName);
		System.out.println(strEventTemplate1);
		System.out.println(strEventTemplate);
		
		objEventSetUp.navigateToEventSetUp();
		
		objEventSetUp.clickOnNotificationsLinkOfET(
							strEventTemplate1)
					 .deselectSelectAllWebOptionOnly()
					 .deselectSelectAllEmailOption()
					 .deselectSelectAllPagerOption()
					 .clickOnEmailCheckBox(
						objUser_data.strNewUserName)
					 .clickOnPagerCheckBox(
						objUser_data.strNewUserName)
					 .clickSaveButton();

		SelectRegion_page.selectRegionAndNavigate(strRegionNames[0]);

		RegionDefault_page.selectFrame();
		
		objEventSetUp.navigateToEventSetUp();
		
		objEventSetUp.clickOnNotificationsLinkOfET(
							strEventTemplate)
					 .deselectSelectAllWebOptionOnly()
					 .deselectSelectAllEmailOption()
					 .deselectSelectAllPagerOption()
					 .clickOnEmailCheckBox(
						objUser_data.strNewUserName)
					 .clickOnPagerCheckBox(
						objUser_data.strNewUserName)
					 .clickSaveButton();
		
		login_page.clickLogOut();
		
		System.out
		.println("-----Precondition ends and test execution starts-------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		SelectRegion_page1
				.selectRegionAndNavigate(strRegionNames[0]);

		RegionDefault_page1.selectFrame();

		EventManagement_page1
				.navigateToEventManagement()
				.createNewMultiEventButton()
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(
						objEvent_data.strEventDescription)
				.selectEventTemplateForMRE(strRegionValue[0],
						strEventTemplate)
				.selectEventTemplateForMRE(strRegionValue[1],
						strEventTemplate1)
				.clickOnNextButton()
				.verifyMultiRegionEventConfirmationPage()
				.verifyConfirmationMessage()
				.clickOnYesButton()
				.verifyEventName(objEvent_data.strEventName)
				.cancelEndEvent(objEvent_data.strEventName)
				.verifyEventNameInEventBanner(objEvent_data.strEventName)
				.verifyEventStatus(objEvent_data.strEventName,
						objEvent_data.strOngoing)
				.verifyEditEventLink(objEvent_data.strEventName)
				.verifyEndEventLink(objEvent_data.strEventName);
		
		gstrResult = "PASS";
	}
}
