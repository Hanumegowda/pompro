package requirementGroup.SettingUpUsers;

import lib.dataObject.EventSetUp_data;
import lib.dataObject.Event_data;
import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.NavigationToSubMenus;
import lib.page.EventManagement;
import lib.page.EventSetUp;
import lib.page.EventStatus;
import lib.page.Login;
import lib.page.Map;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UsersList;
import lib.page.ViewsList;

import org.apache.commons.lang3.ArrayUtils;
import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class BQSRightsToViewOrUpdatePrivateStatusTypes  extends TestNG_UI_EXTENSIONS{
	
	public BQSRightsToViewOrUpdatePrivateStatusTypes() throws Exception {
		super();
	}
	
	/****************************************************************************************************************
	'Description :  Provide a user the ‘View Resource’ right on resource RS and verify that a private status type 
				    associated with RS can be viewed on all the view screens only if the user has any of the resource 
				    rights on resource RS.
	'Precondition:
	'Date	 	 : 21-Jul-2015
	'Author		 : Deepa
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	******************************************************************************************************************/
	@Test(description = " Provide a user the ‘View Resource’ right on resource RS and verify that a private status type associated with RS can be viewed on all the view screens only if the user has any of the resource rights on resource RS.")
	public void testHappyDay45737() throws Exception {

		gstrTCID = "45737";
		gstrTO = " Provide a user the ‘View Resource’ right on resource RS and verify that a private status type associated with RS can be viewed on all the view screens only if the user has any of the resource rights on resource RS.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();
		
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		
		String strstatusTypeValues[] = new String[1];
		String strstatusTypeValues1[] = new String[1];
		String strstatusTypeValues2[] = new String[2];
		String strstatusTypeNames[] = new String[2];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		Map objMap1 = new Map(this.driver1);
		
		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		objStatusTypeList.navigateToStatusTypeListNew();

		// RoleBased statustypes
		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,objView_data.strSectionName);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription, objView_data.strSectionName);

		strstatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		// Resource type creation
		objNavigationToSubMenus.navigateToResourceTypesInSetup();
		
		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);
		
		// Resource creation
		
		objResource.navigateToResourceListPage().createResourceWithAddress(objResource_data.strResourceName,
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
	
		objResource.clickOnStatusTypeLinkInResourcePage(objResource_data.strResourceName);
		
		objResource.verEditResourceLevelStatusTypesPageisDisplayed();
		
		String[] strOneStatus = {strstatusTypeValues1[0]};
		
		objResource.selectStatusType(strOneStatus)
				   .clickOnSaveButton();
		
		objNavigationToSubMenus.navigateToViews();

		String strSTNames[] = { objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName };

		objViewsList.createView(objView_data.strViewName,
				objView_data.strViewDesc, objResource_data.strResourceName,
				strSTNames);
		/*objViewsList.clickCreateNewViewButton()
				.enterViewName(objView_data.strViewName)
				.enterViewDesc(objView_data.strViewDesc);
	
		objViewsList.selectStatusType(objStatuTypes_data.strNSTStatusTypeName);

		objViewsList.selectStatusType(objStatuTypes_data.strTSTStatusTypeName);
		
		
		objViewsList.selectResource(objResource_data.strResourceName)
				.clickOnSaveOfCreateNewView();*/
		strstatusTypeNames[0]=objStatuTypes_data.strNSTStatusTypeName;
		strstatusTypeNames[1]=objStatuTypes_data.strTSTStatusTypeName;
		
		objViewsList.clickOnEditLinkOfView(objView_data.strViewName)
					.clickOnResourcesTab()
					.selectResource(objResource_data.strResourceName)
					.clickOnSaveOfCreateNewView();
		
		strstatusTypeNames[0]=objStatuTypes_data.strNSTStatusTypeName;
		strstatusTypeNames[1]=objStatuTypes_data.strTSTStatusTypeName;

		System.out.println(objView_data.strViewName);

		strstatusTypeValues2= ArrayUtils.addAll(strstatusTypeValues, strstatusTypeValues1);
		
		objEventSetUp.navigateToEventSetUp();
		
		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strstatusTypeValues2).deselectSelectAllWebOption();
		
		objUsersList
						.navigateToUsers()
						.clickCreateNewUserButton()
						.enterUserDetails(objUser_data.strNewUserName,
								objUser_data.strNewPassword, objUser_data.strFullName)
						.clickAdvancedOptionAndExpand()
						.selectMaintainEventsOption()
						.selectFirstRole()
						.selectConfigureRegionalUserAccessOption()
						.clickSaveButton();
		
		System.out.println(objUser_data.strNewUserName);
		
		objLogin.clickLogOut();
		
		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objEventManagement1.navigateToEventManagement()
	   	  .clickOnCreateNewEvent()
	   	  .clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
	   	  .enterAdHocEventName(objEvent_data.strEventName)
	   	  .enterAdHocEventDescription(objEvent_data.strEventDescription)
	   	  .selectResource(strResourceValue)
	   	  .clickOnSaveButton()
	   	  .verifyEventName(objEvent_data.strEventName);
		
		objNavigationToSubMenus1.navigateToUsers();
		
		objUsersList1
					.clickCreateNewUserButton()
					.enterUserDetails(objUser_data.strNewUserName1,
							objUser_data.strNewPassword, objUser_data.strFullName1)
					.clickAdvancedOptionAndExpand()
					.selectFirstRole()
					.selectUpdateStatusOfResource(objResource_data.strResourceName)
					.selectViewResourceRights(objResource_data.strResourceName)
					.clickSaveButton();
		
		//objNavigationToSubMenus.navigateToUsers();
		
		objUsersList1
					.clickCreateNewUserButton()
					.enterUserDetails(objUser_data.strNewUserName2,
							objUser_data.strNewPassword, objUser_data.strFullName2)
					.clickAdvancedOptionAndExpand()
					.selectFirstRole()
					.selectViewResourceRights(objResource_data.strResourceName)
					.selectRunReportRight(objResource_data.strResourceName)
					.clickSaveButton();
		
		//objNavigationToSubMenus.navigateToUsers();
		
		objUsersList1
					.clickCreateNewUserButton()
					.enterUserDetails(objUser_data.strNewUserName3,
							objUser_data.strNewPassword, objUser_data.strFullName3)
					.clickAdvancedOptionAndExpand()
					.selectFirstRole()
					.selectViewResourceRights(objResource_data.strResourceName)
					.selectAssosciateResourceRight(objResource_data.strResourceName)
					.clickSaveButton();
		
		//objNavigationToSubMenus.navigateToUsers();
		
		objUsersList1
					.clickCreateNewUserButton()
					.enterUserDetails(objUser_data.strNewUserName4,
							objUser_data.strNewPassword, objUser_data.strFullName4)
					.clickAdvancedOptionAndExpand()
					.selectFirstRole()
					.selectViewResourceRights(objResource_data.strResourceName)
					.clickSaveButton();
		
		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUser_data.strNewUserName1,
									objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToUserView(objView_data.strViewName);

		objViewsList1.verifyStatusTypeNameInView(strResourceTypeValue[0],
				objStatuTypes_data.strNSTStatusTypeName);

		objViewsList1.verifyStatusTypeNameInView(strResourceTypeValue[0],
				objStatuTypes_data.strTSTStatusTypeName);

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1
				.verResourceTypeAndResourceName(objResourceType_data.strResourceTypeName,
						objResource_data.strResourceName)
				.verStatusTypes(objResourceType_data.strResourceTypeName,
						objStatuTypes_data.strNSTStatusTypeName)
				.verStatusTypes(objResourceType_data.strResourceTypeName,
						objStatuTypes_data.strTSTStatusTypeName)
				.clickOnResource(strResourceValue[0]);

		objViewsList1.verifyStatusTypeUnderSectionsInResourceDetailPage(
				objStatuTypes_data.strNSTStatusTypeName,
				objView_data.strSectionName)
				.verifyStatusTypeUnderSectionsInResourceDetailPage(
						objStatuTypes_data.strTSTStatusTypeName,
						objView_data.strSectionName);

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName).verStatusTypesInPopupWindow(
						strstatusTypeNames);

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName2,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToUserView(objView_data.strViewName);

		objViewsList1.verifyStatusTypeNameInView(strResourceTypeValue[0],
				objStatuTypes_data.strNSTStatusTypeName);

		objViewsList1.verifyStatusTypeNameInView(strResourceTypeValue[0],
				objStatuTypes_data.strTSTStatusTypeName);

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1
				.verResourceTypeAndResourceName(
						objResourceType_data.strResourceTypeName,
						objResource_data.strResourceName)
				.verStatusTypes(objResourceType_data.strResourceTypeName,
						objStatuTypes_data.strNSTStatusTypeName)
				.verStatusTypes(objResourceType_data.strResourceTypeName,
						objStatuTypes_data.strTSTStatusTypeName)
				.clickOnResource(strResourceValue[0]);

		objViewsList1.verifyStatusTypeUnderSectionsInResourceDetailPage(
				objStatuTypes_data.strNSTStatusTypeName,
				objView_data.strSectionName)
				.verifyStatusTypeUnderSectionsInResourceDetailPage(
						objStatuTypes_data.strTSTStatusTypeName,
						objView_data.strSectionName);

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName).verStatusTypesInPopupWindow(
						strstatusTypeNames);

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName3,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToUserView(objView_data.strViewName);

		objViewsList1.verifyStatusTypeNameInView(strResourceTypeValue[0],
				objStatuTypes_data.strNSTStatusTypeName);

		objViewsList1.verifyStatusTypeNameInView(strResourceTypeValue[0],
				objStatuTypes_data.strTSTStatusTypeName);

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1
				.verResourceTypeAndResourceName(
						objResourceType_data.strResourceTypeName,
						objResource_data.strResourceName)
				.verStatusTypes(objResourceType_data.strResourceTypeName,
						objStatuTypes_data.strNSTStatusTypeName)
				.verStatusTypes(objResourceType_data.strResourceTypeName,
						objStatuTypes_data.strTSTStatusTypeName)
				.clickOnResource(strResourceValue[0]);

		objViewsList1.verifyStatusTypeUnderSectionsInResourceDetailPage(
				objStatuTypes_data.strNSTStatusTypeName,
				objView_data.strSectionName)
				.verifyStatusTypeUnderSectionsInResourceDetailPage(
						objStatuTypes_data.strTSTStatusTypeName,
						objView_data.strSectionName);

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName).verStatusTypesInPopupWindow(
						strstatusTypeNames);

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName4,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToUserView(objView_data.strViewName);

		objViewsList1.verifyStatusTypeNameIsNotInUserView(
				strResourceTypeValue[0],
				objStatuTypes_data.strNSTStatusTypeName);

		objViewsList1.verifyStatusTypeNameIsNotInUserView(
				strResourceTypeValue[0],
				objStatuTypes_data.strTSTStatusTypeName);

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1
				.verStatusTypeNotPresent(
						objResourceType_data.strResourceTypeName,
						objStatuTypes_data.strNSTStatusTypeName)
				.verStatusTypeNotPresent(
						objResourceType_data.strResourceTypeName,
						objStatuTypes_data.strTSTStatusTypeName);

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verStatusTypesNotInPopupWindow(strstatusTypeNames);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
}
