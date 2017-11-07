package requirementGroup.CreatingAndManagingEvents;

import lib.dataObject.EventSetUp_data;
import lib.dataObject.Event_data;
import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.EventManagement;
import lib.page.EventSetUp;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewEdgeCaseProvidingSecurityToEventTemplat  extends TestNG_UI_EXTENSIONS{

	public NewEdgeCaseProvidingSecurityToEventTemplat() throws Exception {
		super();
		// TODO Auto-generated constructor stub
		
		}
	/*************************************************************************************
	 * 'Description 	:Verify that providing security for an event template can be cancelled
	 * 'Precondition	: 
	 * 'Date 			: 25-Feb-2016
	 * 'Author 			: Sangappa K
	 * '---------------------------------------------------------------
	 * 'Modified Date 			Modified By 
	 * 'Date Name
	 **************************************************************************************/
	@Test(description ="Verify that providing security for an event template can be cancelled")
	public void testEdgeCase109404() throws Exception {

		gstrTCID ="109404";
		gstrTO = "Verify that providing security for an event template can be cancelled";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[3];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToStatusTypesInSetup();

		// RoleBased statustypes
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		System.out.println(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource.navigateToResourceListPage().createResourceWithAddress(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		// User1 creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption()
				.selectConfigureRegionalUserAccessOption().clickSaveButton();

		// User1 creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName1)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption().clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		System.out.println(objUser_data.strNewUserName1);

		// create Event template

		objLogin.clickLogOut();

		System.out
				.println("---------Precondition ends and test execution starts---------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventSetUp1.navigateToEventSetUp();

		System.out.println(objEventSetUp_data.strEventTemplate);

		objEventSetUp1
				.clickOncreateEventTemplate()

				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition)
				.selectSecurityOption()
				.selectResourceType(strResourceTypeValue[0])
				.selectStatusType(strStatusTypeValues[0])
				.selectStatusType(strStatusTypeValues[1])
				.selectStatusType(strStatusTypeValues[2])
				.clickSaveButton()
				.deselectSelectAllWebOptionOnly()
				.clickSaveButton()
				.verEveTemplateDescription(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strTemplateDefinition)
				.verifyEditTempLinkIsDisplayed(
						objEventSetUp_data.strEventTemplate)
				.verifySecurityLinkForTempIsDisplayed(
						objEventSetUp_data.strEventTemplate)
				.clickOnSecurityOfEveTemp(objEventSetUp_data.strEventTemplate)
				.verUsersListedInEveSecurityPage(objUser_data.strNewUserName)
				.verUsersListedInEveSecurityPage(objUser_data.strNewUserName1)
				.selectUserInEveSecutityPage(objUser_data.strNewUserName1)
				.clickSaveButton()
				.clickOnSecurityOfEveTemp(objEventSetUp_data.strEventTemplate)
				.selectUserInEveSecutityPage(objUser_data.strNewUserName)
				.clickCancelButton();

		objRegionDefault1.clickOnHomeButton();
		objEventManagement1.navigateToEventManagement().clickOnCreateNewEvent()
				.verETNotDisplayad(objEventSetUp_data.strEventTemplate);

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName1,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame().clickOnHomeButton();

		objEventManagement1.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription);
		objResource1.clickResource(strResourceValue);
		objEventManagement1.clickOnSaveButton()
				.verifyEndEventLink(objEvent_data.strEventName)
				.verifyEditEventLink(objEvent_data.strEventName);
		objRegionDefault1.clickOnHomeButton();
		objNavigationToSubMenus1.navigateToEventList();
		objEventManagement1.verifyEventName(objEvent_data.strEventName);
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
}
