package requirementGroup.CreatingAndManagingEvents;

import lib.dataObject.EventSetUp_data;
import lib.dataObject.Event_data;
import lib.dataObject.Login_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.EventManagement;
import lib.page.EventSetUp;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.SelectRegion;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewProvidingSecurityToEventTemplate extends TestNG_UI_EXTENSIONS {
	
	public NewProvidingSecurityToEventTemplate() throws Exception {
		super();
	}

	/*************************************************************************************
	 * 'Description 	: Verify that security can be provided for an event template.  
	 * 'Precondition	: 
	 * 'Date 			: 22-Jun-2015 
	 * 'Author 			: Renushree
	 * '---------------------------------------------------------------
	 * 'Modified Date 			Modified By 
	 * 'Date Name
	 **************************************************************************************/
	@Test(description = "Verify that security can be provided for an event template. ")
	public void testHappyDay68109() throws Exception {

		gstrTCID = "68109";
		gstrTO = "Verify that security can be provided for an event template. ";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectConfigureRegionalUserAccessOption()
				.selectMaintainEventsOption()
				.selectMaintainEventTemplateOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectConfigureRegionalUserAccessOption()
				.selectMaintainEventsOption()
				.selectMaintainEventTemplateOption().clickSaveButton();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventSetUp1.navigateToEventSetUp();

		objEventSetUp1
				.clickOncreateEventTemplate()
				.enterEventTemplateName(objESetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objESetUp_data.strTemplateDefinition)
				.selectSecurityOption().clickSaveButton()
				.deselectSelectAllWebOption()
				.verEveTemplateInList(objESetUp_data.strEventTemplate)
				.clickOnSecurityOfEveTemplate(objESetUp_data.strEventTemplate)
				.selectUserInEveSecutityPage(objUserdata.strNewUserName)
				.clickSaveButton();

		objEventManagement1.navigateToEventManagementNew().clickOnCreateNewEvent()
				.clickOnCreateEvent(objESetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);

		objLogin1.clickLogOut();

		System.out.println(objESetUp_data.strEventTemplate);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame().verifyRegionDefaultPage();

		objEventManagement1
				.navigateToEventManagement()
				.verifyEventManagementPage()
				.verifyEndEventIsNotDisplayed(objEvent_data.strEventName)
				.verifyEditEventIsNotDisplayed(objEvent_data.strEventName)
				.clickOnCreateNewEvent()
				.verifyEventTemplateIsNotDisplayed(
						objESetUp_data.strEventTemplate);

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame().verifyRegionDefaultPage();

		objEventManagement1
				.navigateToEventManagement()
				.clickOnEditLink(objEvent_data.strEventName)
				.enterAdHocEventName(objEvent_data.strEditedEventName)
				.enterAdHocEventDescription(
						objEvent_data.strEditedEventDescription)
				.clickOnSaveButton()
				.verifyEventName(objEvent_data.strEditedEventName)
				.verUpdateInEveBanner(
						"Update 1: " + objEvent_data.strEditedEventName + "")
				.clickOnEndEvent(objEvent_data.strEditedEventName);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
}
