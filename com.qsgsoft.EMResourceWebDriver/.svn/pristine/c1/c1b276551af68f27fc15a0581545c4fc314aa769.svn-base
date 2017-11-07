package requirementGroup.CreatingAndManagingUsers;

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
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewProvideMultiRegionEventRightsForUser  extends TestNG_UI_EXTENSIONS {

	public NewProvideMultiRegionEventRightsForUser() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/*************************************************************************************************************
	 * 'Description : Select Region B in 'Edit Multi-Region Event Rights' screen when editing user account of user  
	 *                U1 from region A and verify that the user U1 can create multi region event in region B.
	 * 'Date        : 31-Dec-2015
	 * 'Author      : Anitha
	 *************************************************************************************************************/
	@Test(description = "Select Region B in 'Edit Multi-Region Event Rights' screen when editing user account of"
			+ " user U1 from region A and verify that the user U1 can create multi region event in region B.")
	public void testHappyDay69094() throws Exception {

		gstrTCID = "69094";
		gstrTO = "Select Region B in 'Edit Multi-Region Event Rights' screen when editing user account of user U1"
				+ " from region A and verify that the user U1 can create multi region event in region B.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data=new EventSetUp_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		EventSetUp EventSetUp_page = new EventSetUp(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		Regions objRegions_page = new Regions(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);
		UsersList UsersList_page1 = new UsersList(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);

		String strRegionValue[] = new String[2];

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName1);

		RegionDefault_page.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions_page.getRegionValue(objTest_data.strRegionName1);

		System.out.println(strRegionValue[0]);

		strRegionValue[1] = objRegions_page.getRegionValue(objTest_data.strRegionName2);

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
				.selectRegion(strRegionValue[1]).clickSaveButton();

		EventSetUp_page.navigateToEventSetUp();

		EventSetUp_page
		        .clickOncreateEventTemplate()
		        .enterEventTemplateName(objEventSetUp_data.strEventTemplate1)
		        .enterEventTemplateDefintion(objEventSetUp_data.strTemplateDefinition)
		        .selectMultiRegionOption()
		        .clickSaveButton()
				.deselectSelectAllWebOptionOnly().clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		login_page.clickLogOut();

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		RegionDefault_page.selectFrame();

		RegionDefault_page.clickRegionLink();

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName2);

		RegionDefault_page.selectFrame();

		// User creation
		UsersList_page
				.navigateToUsers()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName).selectFirstRole()
				.clickAdvancedOptionAndExpand().selectMaintainEventsOption()
				.clickSaveButton();

		EventSetUp_page.navigateToEventSetUp();
		EventSetUp_page
				.clickOncreateEventTemplate()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate2)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition)
				.selectMultiRegionOption().clickSaveButton()
				.deselectSelectAllWebOptionOnly().clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		login_page.clickLogOut();

		System.out.println("--Precondition ends and test execution starts--");

		login_page1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		RegionDefault_page1.selectFrame();

		RegionDefault_page1.clickRegionLink();

		SelectRegion_page1.selectRegionAndNavigate(objTest_data.strRegionName1);

		RegionDefault_page1.selectFrame();

		UsersList_page1
				.navigateToUsers()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName)
				.clickMultiRegionEventRights()
				.selectUserRegion(strRegionValue[0])
				.selectUserRegion(strRegionValue[1]).clickSaveButton()
				.verifyEditUserPageIsDisplayed().clickSaveButton()
				.verifyUserListPageIsDisplayed();

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		SelectRegion_page1.selectRegionAndNavigate(objTest_data.strRegionName1);

		RegionDefault_page1.selectFrame();

		// Event creation
		EventManagement_page1
				.navigateToEventManagement()
				.createNewMultiEventButton()
				.verifyCreateMultiRegionEventPage()
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectEventTemplateForMRE(strRegionValue[0], objEventSetUp_data.strEventTemplate1)
				.selectEventTemplateForMRE(strRegionValue[1], objEventSetUp_data.strEventTemplate2)
				.clickOnNextButton().clickOnYesButton()
				.verifyEventNameInEventBanner(objEvent_data.strEventName);

		SelectRegion_page1.selectRegionAndNavigate(objTest_data.strRegionName2);

		RegionDefault_page1.selectFrame();

		EventManagement_page1
				.navigateToEventManagement()
				.verifyEventNameInEventBanner(objEvent_data.strEventName)
				.verifyCreateNewMultiRegionEventButtonIsDisplayed()
				.createNewMultiEventButton()
				.verifyCreateMultiRegionEventPage()
				.enterAdHocEventName(objEvent_data.strEventName1)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectEventTemplateForMRE(strRegionValue[0], objEventSetUp_data.strEventTemplate1)
				.selectEventTemplateForMRE(strRegionValue[1], objEventSetUp_data.strEventTemplate2)
				.clickOnNextButton().clickOnYesButton()
				.verifyEventNameInEventBanner(objEvent_data.strEventName1);

		SelectRegion_page1.selectRegionAndNavigate(objTest_data.strRegionName1);

		RegionDefault_page1.selectFrame();

		EventManagement_page1
				.verifyEventNameInEventBanner(objEvent_data.strEventName1);

		login_page1.clickLogOut();

		gstrResult = "PASS";
	}
}
