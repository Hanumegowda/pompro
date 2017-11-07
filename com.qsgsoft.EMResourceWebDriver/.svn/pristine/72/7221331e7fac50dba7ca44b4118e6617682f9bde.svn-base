package requirementGroup.ResourceHierarchies;

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
import lib.page.EventStatus;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewCreatingAndManagingEvents extends TestNG_UI_EXTENSIONS{

	public NewCreatingAndManagingEvents() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/*********************************************************************************************
	'Description : Verify that sub-resource types are not listed while creating an event template. 
	'Date	 	 : 05-Aug-2015
	'Author		 : Anitha
	'---------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************************/
	@Test(description = "Verify that sub-resource types are not listed while creating an event template. ")
	public void testHappyDay107402() throws Exception {

		gstrTCID = "107402";
		gstrTO = "Verify that sub-resource types are not listed while creating an event template. ";

		Login_data objLogindata = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		User_data objUser_data = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		Resource objResource = new Resource(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);

		String strstatusTypeValues[] = new String[1];
		String strstatusTypeValues1[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strSubResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strSubResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault.selectFrame();

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// create status types
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		// Create Resource Type
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Create Sub-Resource Type
		objResourceType
				.clickOnCreateNewResourceTypeButton()
				.enterResourceTypeName(
						objResourceType_data.strSubResourceTypeName)
				.clickStatusType(strstatusTypeValues1)
				.selectSubResourceTypeCheckBox().clickOnSaveButton();

		strSubResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strSubResourceTypeName);

		// Resource creation
		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		// Sub-Resource creation
		objResource.clickOnSubResourcesLink(objResource_data.strResourceName)
				.createSubResourceForResource(
						objResource_data.strSubResourceName,
						objResource_data.strResourceAbbrivation,
						objResourceType_data.strSubResourceTypeName,
						objResource_data.strStandardResourceTypename,
						objResource_data.strResourceFirstName,
						objResource_data.strResourceLastName);

		strSubResourceValue[0] = objResource
				.getSubResourceValue(objResource_data.strSubResourceName);

		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventTemplateOption().clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		objLogin.clickLogOut();
		
		System.out.println("------------------Precondition ends--------------------");
		
		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventSetUp1.navigateToEventSetUp();

		objEventSetUp1
				.clickOncreateEventTemplate()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition)
				.verifySubRTNotDisplayed(strSubResourceTypeValue[0])
				.selectResourceType(strResourceTypeValue[0])
				.selectStatusType(strstatusTypeValues[0]).clickSaveButton()
				.verEveTemplateInList(objEventSetUp_data.strEventTemplate);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	/*********************************************************************************************
	'Description : Verify that sub-resource types are not listed while creating an event template. 
	'Date	 	 : 05-Aug-2015
	'Author		 : Anitha
	'---------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************************/
	@Test(description = "Verify that sub-resources are not listed while creating an event.")
	public void testHappyDay107403() throws Exception {

		gstrTCID = "107403";
		gstrTO = "Verify that sub-resources are not listed while creating an event.";

		Login_data objLogindata = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		Resource objResource = new Resource(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		
		String strstatusTypeValues[] = new String[1];
		String strstatusTypeValues1[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strSubResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strSubResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault.selectFrame();

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// create status types
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		// Create Resource Type
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Create Sub-Resource Type
		objResourceType
				.clickOnCreateNewResourceTypeButton()
				.enterResourceTypeName(
						objResourceType_data.strSubResourceTypeName)
				.clickStatusType(strstatusTypeValues1)
				.selectSubResourceTypeCheckBox().clickOnSaveButton();

		strSubResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strSubResourceTypeName);

		// Resource creation
		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		// Sub-Resource creation
		objResource.clickOnSubResourcesLink(objResource_data.strResourceName)
				.createSubResourceForResource(
						objResource_data.strSubResourceName,
						objResource_data.strResourceAbbrivation,
						objResourceType_data.strSubResourceTypeName,
						objResource_data.strStandardResourceTypename,
						objResource_data.strResourceFirstName,
						objResource_data.strResourceLastName);

		strSubResourceValue[0] = objResource
				.getSubResourceValue(objResource_data.strSubResourceName);

		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption()
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		objLogin.clickLogOut();
		
		System.out.println("------------------Precondition ends--------------------");
		
		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventSetUp1.navigateToEventSetUp();

		objEventSetUp1
				.clickOncreateEventTemplate()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition)
				.verifySubRTNotDisplayed(strSubResourceTypeValue[0])
				.selectResourceType(strResourceTypeValue[0])
				.selectStatusType(strstatusTypeValues[0]).clickSaveButton()
				.verEveTemplateInList(objEventSetUp_data.strEventTemplate);
		
		objEventManagement1.navigateToEventManagementNew()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.verifyResource(strResourceValue)
				.verifySubResourceNotPresent(strSubResourceValue[0]);
		
	   objResource1.clickResource(strResourceValue);
	   
	   objEventManagement1.clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);
	   
		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);
		
		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName)
				.verResourceTypeAndResourceNameIsNotDisplayed(
						objResourceType_data.strSubResourceTypeName,
						objResource_data.strSubResourceName);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
}
