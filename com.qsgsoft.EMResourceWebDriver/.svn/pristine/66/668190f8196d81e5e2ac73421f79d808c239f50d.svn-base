package requirementGroup.SettingUpStatusTypes;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

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
import lib.page.MailVerificationFunctions;
import lib.page.Map;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.SystemNotifications;
import lib.page.UpdateStatus;
import lib.page.UsersList;
import lib.page.ViewsList;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewHappyDayCommonScenariosForStatusTypes   extends TestNG_UI_EXTENSIONS {
	
	public NewHappyDayCommonScenariosForStatusTypes() throws Exception {
		super();
	}
	
	/*************************************************************************************
	'Description : Verify that the number status type of a resource can be updated from the following screens:
					1. View Screen
					2. Resource Detail Screen
					3. Map Screen
					4. Event Detail Screen 
	'Precondition:
	'Date	 	 : 19-May-2015
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that the number status type of a resource can be updated from the following screens:"+
			"1. View Screen"+
			"2. Resource Detail Screen"+
			"3. Map Screen"+
			"4. Event Detail Screen")
	
	public void testHappyDay66027() throws Exception {

		gstrTCID = "66027";
		gstrTO = "Verify that the number status type of a resource can be updated from the following screens:"+
			"1. View Screen"+
			"2. Resource Detail Screen"+
			"3. Map Screen"+
			"4. Event Detail Screen";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		View_data objView_data = new View_data();
		Event_data objEvent_data = new Event_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();
		ViewsList objViewsList = new ViewsList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Map objMap = new Map(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();


		objNavigationToSubMenus.navigateToViews();
		objViewsList.clickOncustomizeResourceDetailView()
				.enterSectionName(objView_data.strSectionName)
				.clickOnCreateSection().clickOnSaveButton();
		
		objStatusTypeList.navigateToStatusTypeListNew();

		objStatusTypeList.createStatusTypeWithSection(objStatusTypes_data.strNumberStatusType, objStatusTypes_data.strNSTStatusTypeName, 
				objStatusTypes_data.strStatusDescription, objView_data.strSectionName);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource
				.createResourceWithAddress(objResource_data.strResourceName, objResource_data.strResourceAbbrivation, objResourceType_data.strResourceTypeName, objResource_data.strStandardResourceTypename, objResource_data.strResourceFirstName, objResource_data.strResourceLastName, objResource_data.strStreetAddress, objResource_data.strCity, objResource_data.strState, objResource_data.strCounty, objResource_data.strZipcode);
		System.out.println(objResource_data.strResourceName);
		System.out.println(objResourceType_data.strResourceTypeName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objNavigationToSubmenus.navigateToViews();

		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc, objResource_data.strResourceName, objStatusTypes_data.strNSTStatusTypeName	);
		
//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);
//		objViewsList.selectViewType(objView_data.strResource);
//		objViewsList.selectStatusType(objStatusTypes_data.strNSTStatusTypeName)
//				.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();

		System.out.println(objView_data.strViewName);
		
		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton();
		
		System.out.println(objUserdata.strNewUserName);

		objEventSetUp.navigateToEventSetUp();
		objEventSetUp
		.clickOncreateEventTemplate()
		.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
		.enterEventTemplateDefintion(
				objEventSetUp_data.strTemplateDefinition)
		.selectResourceType(strResourceTypeValue[0])
		.selectStatusType(strStatusTypeValues[0])
		.clickSaveButton()
		.deselectSelectAllEmailOption()
		.deselectSelectAllPagerOption()
		.deselectSelectAllWebOption()
		.verEveTemplateListScreenIsDisplayed();
		
		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objEventManagement1.navigateToEventManagement()
		.clickOnCreateNewEvent()
		.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
		.enterAdHocEventName(objEvent_data.strEventName)
		.enterAdHocEventDescription(objEvent_data.strEventDescription)
		.selectResource(strResourceValue[0])
		.clickOnSaveButton()
		.verifyEventName(objEvent_data.strEventName);
		
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objEvent_data.strEventName);
		System.out.println(objView_data.strViewName);

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus1.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
				objView_data.strValueForUpdate)
				.enterComments(strStatusTypeValues[0], objView_data.strComment)
				.clickOnSaveButton();
		
		String strUpdatedTime = objEventManagement1
				.getApplicationTimeWithCSTCDT();

		objUpdateStatus1.verifyLastUpdatedTime(
				objResource_data.strResourceName, strUpdatedTime);
		String strLastUpdatedValue = "Last Update: " + strUpdatedTime;

		String strUpdatedBy = "Updated By: " + objUserdata.strFullName;

		objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0], strStatusTypeValues[0], objView_data.strValueForUpdate);
		
		objUpdateStatus1.verifyUpdatedComment(objResource_data.strResourceName, objView_data.strComment);
		
		String strComments = "Comment: "+objView_data.strComment;
		
		objViewsList1.verifyUserUpdatedValue(strResourceValue[0],
				strStatusTypeValues[0],strLastUpdatedValue, strUpdatedBy, strComments);
		
		objViewsList1.clickOnResourceAndNavigateToResourceDetail(objResource_data.strResourceName);
		
		objViewsList1.verifyUpdatedValueAndComments(objStatusTypes_data.strNSTStatusTypeName, objView_data.strValueForUpdate, objView_data.strComment);
		
		objViewsList1.clickOnIndividualUpdateStatus(strResourceValue[0],
				strStatusTypeValues[0]);
		
		objUpdateStatus1.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
				objView_data.strValueForUpdate1)
				.enterComments(strStatusTypeValues[0], objView_data.strComment2)
				.clickOnSaveButton();
		strUpdatedTime = objEventManagement1
				.getApplicationTimeWithCSTCDT();
		
		strLastUpdatedValue = "Last Update: " + strUpdatedTime;
		
		strComments = "Comment: "+objView_data.strComment2;
		
		objViewsList1.verifyUpdatedValueAndComments(objStatusTypes_data.strNSTStatusTypeName, objView_data.strValueForUpdate1, objView_data.strComment2);
	
		objViewsList1.verifyUpdatedTime(objStatusTypes_data.strNSTStatusTypeName, objView_data.strValueForUpdate1,strLastUpdatedValue, strUpdatedBy);
	
		objViewsList1.verifyUserUpdatedValue(strResourceValue[0],
				strStatusTypeValues[0],strLastUpdatedValue, strUpdatedBy, strComments);
		
		objNavigationToSubmenus1.navigateToMap();
		
		objMap.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName);
		
		objMap.verResourceNameInPopupWindow(objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();
		
		
		objUpdateStatus1.selectStatusTypes(strStatusTypeValues[0])
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
				objView_data.strValueForUpdate2)
				.enterComments(strStatusTypeValues[0], objView_data.strComment3)
				.clickOnSaveButton();
		
		strUpdatedTime = objEventManagement1
				.getApplicationTimeWithCSTCDT();
		
		objMap.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);
		
		objMap.verResourceNameInPopupWindow(objResource_data.strResourceName);
		
		String updatedtime1 = "("+strUpdatedTime+")";

		objMap.verifyUpdatedTimeInPopupWindow(objView_data.strValueForUpdate2, updatedtime1);
		
		objEventManagement1.clickOnEventNameInEventBanner(objEvent_data.strEventName);
		
		objEventStatus1.verifyEventStatus();
		
		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					objStatusTypes_data.strNSTStatusTypeName);
		
		objViewsList1.clickOnIndividualUpdateStatus(strResourceValue[0],
				strStatusTypeValues[0]);
		
		objUpdateStatus1.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
				objView_data.strValueForUpdate1)
				.enterComments(strStatusTypeValues[0], objView_data.strComment4)
				.clickOnSaveButton();

		strUpdatedTime = objEventManagement1
				.getApplicationTimeWithCSTCDT();
		
		objEventStatus1.verifyUpdatedTime(objResource_data.strResourceName, strUpdatedTime);
		
		objEventStatus1.verifyUpdatedUserFullName(objResource_data.strResourceName, objUserdata.strFullName);
		
		objEventStatus1.verifyUpdatedComments(objResource_data.strResourceName, objView_data.strComment4);
		
		strLastUpdatedValue = "Last Update: " + strUpdatedTime;
		
		strComments = "Comment: "+objView_data.strComment4;
		
		objViewsList1.verifyUserUpdatedValue(strResourceValue[0],
				strStatusTypeValues[0],strLastUpdatedValue, strUpdatedBy, strComments);
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	
	/*************************************************************************************
	'Description : Verify that the text  status type of a resource can be updated from the following screens:
					1. View Screen
					2. Resource Detail Screen
					3. Map Screen
					4. Event Detail Screen 
	'Precondition:
	'Date	 	 : 19-May-2015
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that the text  status type of a resource can be updated from the following screens:"+
			"1. View Screen"+
			"2. Resource Detail Screen"+
			"3. Map Screen"+
			"4. Event Detail Screen")
	
	public void testHappyDay66062() throws Exception {

		gstrTCID = "66062";
		gstrTO = "Verify that the text status type of a resource can be updated from the following screens:"+
			"1. View Screen"+
			"2. Resource Detail Screen"+
			"3. Map Screen"+
			"4. Event Detail Screen";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		View_data objView_data = new View_data();
		Event_data objEvent_data = new Event_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();
		ViewsList objViewsList = new ViewsList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Map objMap = new Map(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();


		objNavigationToSubMenus.navigateToViews();
		objViewsList.clickOncustomizeResourceDetailView()
				.enterSectionName(objView_data.strSectionName)
				.clickOnCreateSection().clickOnSaveButton();
		
		objStatusTypeList.navigateToStatusTypeListNew();

		objStatusTypeList.createStatusTypeWithSection(objStatusTypes_data.strTextStatusType, objStatusTypes_data.strTSTStatusTypeName, 
				objStatusTypes_data.strStatusDescription, objView_data.strSectionName);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource
				.createResourceWithAddress(objResource_data.strResourceName, objResource_data.strResourceAbbrivation, objResourceType_data.strResourceTypeName, objResource_data.strStandardResourceTypename, objResource_data.strResourceFirstName, objResource_data.strResourceLastName, objResource_data.strStreetAddress, objResource_data.strCity, objResource_data.strState, objResource_data.strCounty, objResource_data.strZipcode);


		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objNavigationToSubmenus.navigateToViews();

		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc, objResource_data.strResourceName, objStatusTypes_data.strTSTStatusTypeName);
		
//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);
//		objViewsList.selectViewType(objView_data.strResource);
//		objViewsList.selectStatusType(objStatusTypes_data.strTSTStatusTypeName)
//				.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton();

		objEventSetUp.navigateToEventSetUp();
		objEventSetUp
		.clickOncreateEventTemplate()
		.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
		.enterEventTemplateDefintion(
				objEventSetUp_data.strTemplateDefinition)
		.selectResourceType(strResourceTypeValue[0])
		.selectStatusType(strStatusTypeValues[0])
		.clickSaveButton()
		.deselectSelectAllEmailOption()
		.deselectSelectAllPagerOption()
		.deselectSelectAllWebOption()
		.verEveTemplateListScreenIsDisplayed();
		
		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objEventManagement1.navigateToEventManagement()
		.clickOnCreateNewEvent()
		.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
		.enterAdHocEventName(objEvent_data.strEventName)
		.enterAdHocEventDescription(objEvent_data.strEventDescription)
		.selectResource(strResourceValue[0])
		.clickOnSaveButton()
		.verifyEventName(objEvent_data.strEventName);
		
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objEvent_data.strEventName);
		System.out.println(objView_data.strViewName);


		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus1.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
				objView_data.strValueForTST)
				.enterComments(strStatusTypeValues[0], objView_data.strComment)
				.clickOnSaveButton();
		
		String strUpdatedTime = objEventManagement1
				.getApplicationTimeWithCSTCDT();

		objUpdateStatus1.verifyLastUpdatedTime(
				objResource_data.strResourceName, strUpdatedTime);
		String strLastUpdatedValue = "Last Update: " + strUpdatedTime;
//		String strLastUpdatedValue1 = "Last Update: " + strUpdatedTime
//				+ " (00:05)";
		String strUpdatedBy = "Updated By: " + objUserdata.strFullName;
//		objUpdateStatus1.verify
//		objUpdateStatus1.verifyLastUpdatedTimeInToolTip(strResourceValue[0],
//				strStatusTypeValues[0], objView_data.strValueForTST,
//				strLastUpdatedValue, strUpdatedBy);

		objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0], strStatusTypeValues[0], objView_data.strValueForTST);
		
		objUpdateStatus1.verifyUpdatedComment(objResource_data.strResourceName, objView_data.strComment);
		
		String strComments = "Comment: "+objView_data.strComment;
		
		objViewsList1.verifyUserUpdatedValue(strResourceValue[0],
				strStatusTypeValues[0],strLastUpdatedValue, strUpdatedBy, strComments);
		
		objViewsList1.clickOnResourceAndNavigateToResourceDetail(objResource_data.strResourceName);
		
		objViewsList1.verifyUpdatedValueAndComments(objStatusTypes_data.strTSTStatusTypeName, objView_data.strValueForTST, objView_data.strComment);
		
		objViewsList1.clickOnIndividualUpdateStatus(strResourceValue[0],
				strStatusTypeValues[0]);
		
		objUpdateStatus1.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
				objView_data.strValueForTST1)
				.enterComments(strStatusTypeValues[0], objView_data.strComment2)
				.clickOnSaveButton();
		strUpdatedTime = objEventManagement1
				.getApplicationTimeWithCSTCDT();
		
		strLastUpdatedValue = "Last Update: " + strUpdatedTime;
		
		strComments = "Comment: "+objView_data.strComment2;
		
		objViewsList1.verifyUpdatedValueAndComments(objStatusTypes_data.strTSTStatusTypeName, objView_data.strValueForTST1, objView_data.strComment2);
	
		objViewsList1.verifyUpdatedTime(objStatusTypes_data.strTSTStatusTypeName, objView_data.strValueForTST1,strLastUpdatedValue, strUpdatedBy);
	
		objViewsList1.verifyUserUpdatedValue(strResourceValue[0],
				strStatusTypeValues[0],strLastUpdatedValue, strUpdatedBy, strComments);
		
		objNavigationToSubmenus1.navigateToMap();
		
		objMap.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName);
		
		objMap.verResourceNameInPopupWindow(objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();
		
		
		objUpdateStatus1.selectStatusTypes(strStatusTypeValues[0])
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
				objView_data.strValueForTST2)
				.enterComments(strStatusTypeValues[0], objView_data.strComment3)
				.clickOnSaveButton();
		
		strUpdatedTime = objEventManagement1
				.getApplicationTimeWithCSTCDT();
		
		objMap.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);
		
		objMap.verResourceNameInPopupWindow(objResource_data.strResourceName);
		
		String updatedtime1 = "("+strUpdatedTime+")";

		objMap.verifyUpdatedTimeInPopupWindow(objView_data.strValueForTST2, updatedtime1);
		
		objEventManagement1.clickOnEventNameInEventBanner(objEvent_data.strEventName);
		
		objEventStatus1.verifyEventStatus();
		
		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					objStatusTypes_data.strTSTStatusTypeName);
		
		strLastUpdatedValue = "Last Update: " + strUpdatedTime;
		
		strComments = "Comment: "+objView_data.strComment3;
		
		objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0], strStatusTypeValues[0], objView_data.strValueForTST2);
		
		objViewsList1.verifyUserUpdatedValue(strResourceValue[0],
				strStatusTypeValues[0],strLastUpdatedValue, strUpdatedBy, strComments);
		
		objViewsList1.clickOnIndividualUpdateStatus(strResourceValue[0],
				strStatusTypeValues[0]);
		
		objUpdateStatus1.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
				objView_data.strValueForTST3)
				.enterComments(strStatusTypeValues[0], objView_data.strComment4)
				.clickOnSaveButton();

		strUpdatedTime = objEventManagement1
				.getApplicationTimeWithCSTCDT();
		
		objEventStatus1.verifyUpdatedTime(objResource_data.strResourceName, strUpdatedTime);
		
		objEventStatus1.verifyUpdatedUserFullName(objResource_data.strResourceName, objUserdata.strFullName);
		
		objEventStatus1.verifyUpdatedComments(objResource_data.strResourceName, objView_data.strComment4);
		
		strLastUpdatedValue = "Last Update: " + strUpdatedTime;
		
		strComments = "Comment: "+objView_data.strComment4;
		
		objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0], strStatusTypeValues[0], objView_data.strValueForTST3);
		
		objViewsList1.verifyUserUpdatedValue(strResourceValue[0],
				strStatusTypeValues[0],strLastUpdatedValue, strUpdatedBy, strComments);
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Verify that the multi  status type of a resource can be updated from the following screens:
					1. View Screen
					2. Resource Detail Screen
					3. Map Screen
					4. Event Detail Screen 
	'Precondition:
	'Date	 	 : 19-May-2015
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that the multi  status type of a resource can be updated from the following screens:"+
			"1. View Screen"+
			"2. Resource Detail Screen"+
			"3. Map Screen"+
			"4. Event Detail Screen")
	
	public void testHappyDay66053() throws Exception {

		gstrTCID = "66053";
		gstrTO = "Verify that the multi  status type of a resource can be updated from the following screens:"+
			"1. View Screen"+
			"2. Resource Detail Screen"+
			"3. Map Screen"+
			"4. Event Detail Screen";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		View_data objView_data = new View_data();
		Event_data objEvent_data = new Event_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();
		ViewsList objViewsList = new ViewsList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Map objMap = new Map(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strStatusesValues[] = new String[4];
		
		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToViews();
		objViewsList.clickOncustomizeResourceDetailView()
				.enterSectionName(objView_data.strSectionName)
				.clickOnCreateSection().clickOnSaveButton();
		
		objStatusTypeList.navigateToStatusTypeListNew();

		objStatusTypeList.createStatusTypeWithSection(objStatusTypes_data.strMultiStatusType, objStatusTypes_data.strMSTStatusTypeName, 
				objStatusTypes_data.strStatusDescription, objView_data.strSectionName);

		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti)
		.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti1)
		.createNewStatus(objStatusTypes_data.strStatusNameInMulti2,
				objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti2)
		.createNewStatus(objStatusTypes_data.strStatusNameInMulti3,
				objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti3);
		
		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);
		
		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);
		
		strStatusesValues[2] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti2);
	
		strStatusesValues[3] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti3);
		
		objStatusTypeList.clickOnReturnToStatusTypeList();
		
		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource
				.createResourceWithAddress(objResource_data.strResourceName, objResource_data.strResourceAbbrivation, objResourceType_data.strResourceTypeName, objResource_data.strStandardResourceTypename, objResource_data.strResourceFirstName, objResource_data.strResourceLastName, objResource_data.strStreetAddress, objResource_data.strCity, objResource_data.strState, objResource_data.strCounty, objResource_data.strZipcode);


		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objNavigationToSubmenus.navigateToViews();
//
//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);
//		objViewsList.selectViewType(objView_data.strResource);
//		objViewsList.selectStatusType(objStatusTypes_data.strMSTStatusTypeName)
//				.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();

		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc, 
							objResource_data.strResourceName, objStatusTypes_data.strMSTStatusTypeName);
		
		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton();

		objEventSetUp.navigateToEventSetUp();
		objEventSetUp
		.clickOncreateEventTemplate()
		.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
		.enterEventTemplateDefintion(
				objEventSetUp_data.strTemplateDefinition)
		.selectResourceType(strResourceTypeValue[0])
		.selectStatusType(strStatusTypeValues[0])
		.clickSaveButton()
		.deselectSelectAllEmailOption()
		.deselectSelectAllPagerOption()
		.deselectSelectAllWebOption()
		.verEveTemplateListScreenIsDisplayed();
		
		objLogin.clickLogOut();
		
		System.out.println(objUserdata.strNewUserName);
		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objEventManagement1.navigateToEventManagement()
		.clickOnCreateNewEvent()
		.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
		.enterAdHocEventName(objEvent_data.strEventName)
		.enterAdHocEventDescription(objEvent_data.strEventDescription)
		.selectResource(strResourceValue[0])
		.clickOnSaveButton()
		.verifyEventName(objEvent_data.strEventName);

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus1.selectMSTUpdateValue(strStatusTypeValues[0], strStatusesValues[0])
				.enterComments(strStatusTypeValues[0], objView_data.strComment)
				.clickOnSaveButton();
		
		String strUpdatedTime = objEventManagement1
				.getApplicationTimeWithCSTCDT();

		objUpdateStatus1.verifyLastUpdatedTime(
				objResource_data.strResourceName, strUpdatedTime);
		String strLastUpdatedValue = "Last Update: " + strUpdatedTime;

		String strUpdatedBy = "Updated By: " + objUserdata.strFullName;

		objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0], strStatusTypeValues[0], objStatusTypes_data.strStatusNameInMulti);
		
		objUpdateStatus1.verifyUpdatedComment(objResource_data.strResourceName, objView_data.strComment);
		
		String strComments = "Comment: "+objView_data.strComment;
		
		objViewsList1.verifyUserUpdatedValue(strResourceValue[0],
				strStatusTypeValues[0],strLastUpdatedValue, strUpdatedBy, strComments);
		
		objViewsList1.clickOnResourceAndNavigateToResourceDetail(objResource_data.strResourceName);
		
		objViewsList1.verifyUpdatedValueAndComments(objStatusTypes_data.strMSTStatusTypeName, objStatusTypes_data.strStatusNameInMulti, objView_data.strComment);
		
		objViewsList1.clickOnIndividualUpdateStatus(strResourceValue[0],
				strStatusTypeValues[0]);
		
		objUpdateStatus1.selectMSTUpdateValue(strStatusTypeValues[0], strStatusesValues[1])
		
				.enterComments(strStatusTypeValues[0], objView_data.strComment2)
				.clickOnSaveButton();
		strUpdatedTime = objEventManagement1
				.getApplicationTimeWithCSTCDT();
		
		strLastUpdatedValue = "Last Update: " + strUpdatedTime;
		
		strComments = "Comment: "+objView_data.strComment2;
		
		objViewsList1.verifyUpdatedValueAndComments(objStatusTypes_data.strMSTStatusTypeName, objStatusTypes_data.strStatusNameInMulti1, objView_data.strComment2);
	
		objViewsList1.verifyUpdatedTime(objStatusTypes_data.strMSTStatusTypeName, objStatusTypes_data.strStatusNameInMulti1,strLastUpdatedValue, strUpdatedBy);
	
		objViewsList1.verifyUserUpdatedValue(strResourceValue[0],
				strStatusTypeValues[0],strLastUpdatedValue, strUpdatedBy, strComments);
		
		objNavigationToSubmenus1.navigateToMap();
		
		objMap.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName);
		
		objMap.verResourceNameInPopupWindow(objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();
		
		
		objUpdateStatus1.selectStatusTypes(strStatusTypeValues[0])
				.selectMSTUpdateValue(strStatusTypeValues[0], strStatusesValues[2])
				.enterComments(strStatusTypeValues[0], objView_data.strComment3)
				.clickOnSaveButton();
		
		strUpdatedTime = objEventManagement1
				.getApplicationTimeWithCSTCDT();
		
		objMap.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);
		
		objMap.verResourceNameInPopupWindow(objResource_data.strResourceName);
		
		String updatedtime1 = "("+strUpdatedTime+")";

		objMap.verifyUpdatedTimeInPopupWindow(objStatusTypes_data.strStatusNameInMulti2, updatedtime1);
		
		objEventManagement1.clickOnEventNameInEventBanner(objEvent_data.strEventName);
		
		objEventStatus1.verifyEventStatus();
		
		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					objStatusTypes_data.strMSTStatusTypeName);
		
		strLastUpdatedValue = "Last Update: " + strUpdatedTime;
		
		strComments = "Comment: "+objView_data.strComment3;
		
		objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0], strStatusTypeValues[0], objStatusTypes_data.strStatusNameInMulti2);
		
		objViewsList1.verifyUserUpdatedValue(strResourceValue[0],
				strStatusTypeValues[0],strLastUpdatedValue, strUpdatedBy, strComments);
		
		objViewsList1.clickOnIndividualUpdateStatus(strResourceValue[0],
				strStatusTypeValues[0]);
		
		objUpdateStatus1.selectMSTUpdateValue(strStatusTypeValues[0], strStatusesValues[3])
				.enterComments(strStatusTypeValues[0], objView_data.strComment4)
				.clickOnSaveButton();

		strUpdatedTime = objEventManagement1
				.getApplicationTimeWithCSTCDT();
		
		objEventStatus1.verifyUpdatedTime(objResource_data.strResourceName, strUpdatedTime);
		
		objEventStatus1.verifyUpdatedUserFullName(objResource_data.strResourceName, objUserdata.strFullName);
		
		objEventStatus1.verifyUpdatedComments(objResource_data.strResourceName, objView_data.strComment4);
		
		strLastUpdatedValue = "Last Update: " + strUpdatedTime;
		
		strComments = "Comment: "+objView_data.strComment4;
		
		objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0], strStatusTypeValues[0],objStatusTypes_data.strStatusNameInMulti3);
		
		objViewsList1.verifyUserUpdatedValue(strResourceValue[0],
				strStatusTypeValues[0],strLastUpdatedValue, strUpdatedBy, strComments);
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}

	/*************************************************************************************
	'Description : Verify that saturation score status type of a resource can be updated from the following screens:
					1. View Screen
					2. Resource Detail Screen
					3. Map Screen
					4. Event Detail Screen 
	'Precondition:
	'Date	 	 : 28-May-2015
	'Author		 : Pallavi
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that saturation score status type of a resource can be updated from the following screens:"+
			"1. View Screen"+
			"2. Resource Detail Screen"+
			"3. Map Screen"+
			"4. Event Detail Screen")
	
	public void testHappyDay66063() throws Exception {

		gstrTCID = "66063";
		gstrTO = "Verify that saturation score status type of a resource can be updated from the following screens:"+
			"1. View Screen"+
			"2. Resource Detail Screen"+
			"3. Map Screen"+
			"4. Event Detail Screen";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		View_data objView_data = new View_data();
		Event_data objEvent_data = new Event_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();
		ViewsList objViewsList = new ViewsList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Map objMap = new Map(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();


		objNavigationToSubMenus.navigateToViews();
		objViewsList.clickOncustomizeResourceDetailView()
				.enterSectionName(objView_data.strSectionName)
				.clickOnCreateSection().clickOnSaveButton();
		
		objStatusTypeList.navigateToStatusTypeListNew();

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objResourceType.navigateToResourceTypePage();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource
				.createResourceWithAddress(objResource_data.strResourceName, 
						objResource_data.strResourceAbbrivation, 
						objResourceType_data.strResourceTypeName,
						objResource_data.strStandardResourceTypename, 
						objResource_data.strResourceFirstName, 
						objResource_data.strResourceLastName,
						objResource_data.strStreetAddress, 
						objResource_data.strCity,
						objResource_data.strState, 
						objResource_data.strCounty, 
						objResource_data.strZipcode);


		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objNavigationToSubmenus.navigateToViews();

//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc)
//				.selectViewType(objView_data.strResource)
//				.selectStatusType(objStatusTypes_data.strSSTStatusTypeName)
//				.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();
		
		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc, 
							objResource_data.strResourceName, objStatusTypes_data.strSSTStatusTypeName);
		
		System.out.println(objView_data.strViewName);
		
		System.out.println(objResource_data.strResourceName);
		
		System.out.println(objResourceType_data.strResourceTypeName);
		
		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton();

		objEventSetUp.navigateToEventSetUp();
		
		objEventSetUp
				.clickOncreateEventTemplate()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition)
				.selectResourceType(strResourceTypeValue[0])
				.selectStatusType(strStatusTypeValues[0])
				.clickSaveButton()
				.deselectSelectAllEmailOption()
				.deselectSelectAllPagerOption()
				.deselectSelectAllWebOption()
				.verEveTemplateListScreenIsDisplayed();
		
		
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objEvent_data.strEventName);
		System.out.println(objView_data.strViewName);
		
		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objEventManagement1.navigateToEventManagement()
						  .clickOnCreateNewEvent()
						  .clickOnCreateEvent(
								  objEventSetUp_data.strEventTemplate)
						  .enterAdHocEventName(
								  objEvent_data.strEventName)
						  .enterAdHocEventDescription(
								  objEvent_data.strEventDescription)
						  .selectResource(strResourceValue[0])
						  .clickOnSaveButton()
						  .verifyEventName(objEvent_data.strEventName);

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus1.enterUpdateSSTValues(strStatusTypeValues[0],
									objView_data.strValueForSST)
						.enterComments(strStatusTypeValues[0], objView_data.strComment)
						.clickOnSaveButton();
		
		String strUpdatedTime = objEventManagement1
					.getApplicationTimeWithCSTCDT();

		objUpdateStatus1.verifyLastUpdatedTime(
				objResource_data.strResourceName, strUpdatedTime);
		String strLastUpdatedValue = "Last Update: " + strUpdatedTime;
//		String strLastUpdatedValue1 = "Last Update: " + strUpdatedTime
//				+ " (00:05)";
		String strUpdatedBy = "Updated By: " + objUserdata.strFullName;
//		objUpdateStatus1.verify
//		objUpdateStatus1.verifyLastUpdatedTimeInToolTip(strResourceValue[0],
//				strStatusTypeValues[0], objView_data.strValueForTST,
//				strLastUpdatedValue, strUpdatedBy);

		objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0], 
									strStatusTypeValues[0], 
									objView_data.strUpdatedValForSST);
		
		objUpdateStatus1.verifyUpdatedComment(objResource_data.strResourceName, 
									objView_data.strComment);
		
		String strComments = "Comment: "+objView_data.strComment;
		
		objViewsList1.verifyUserUpdatedValue(strResourceValue[0],
				strStatusTypeValues[0],strLastUpdatedValue, strUpdatedBy, strComments);
		
		objViewsList1.clickOnResourceAndNavigateToResourceDetail(objResource_data.strResourceName);
		
		objViewsList1.verifyUpdatedValueAndComments(objStatusTypes_data.strSSTStatusTypeName, 
									objView_data.strUpdatedValForSST,
									objView_data.strComment);
		
		objViewsList1.clickOnIndividualUpdateStatus(strResourceValue[0],
				strStatusTypeValues[0]);
		
		objUpdateStatus1.enterUpdateSSTValues(strStatusTypeValues[0],
									objView_data.strValueForSST1)
						.enterComments(strStatusTypeValues[0], objView_data.strComment2)
						.clickOnSaveButton();
		
		strUpdatedTime = objEventManagement1
									.getApplicationTimeWithCSTCDT();
		
		strLastUpdatedValue = "Last Update: " + strUpdatedTime;
		
		strComments = "Comment: "+objView_data.strComment2;
		
		objViewsList1.verifyUpdatedValueAndComments(objStatusTypes_data.strSSTStatusTypeName, 
									objView_data.strUpdatedValForSST1,
									objView_data.strComment2);
	
		objViewsList1.verifyUpdatedTime(objStatusTypes_data.strSSTStatusTypeName,
										objView_data.strUpdatedValForSST1,
										strLastUpdatedValue, strUpdatedBy);
	
		objViewsList1.verifyUserUpdatedValue(strResourceValue[0],
				strStatusTypeValues[0], strLastUpdatedValue, strUpdatedBy, strComments);
		
		objNavigationToSubmenus1.navigateToMap();
		
		objMap.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName);
		
		objMap.verResourceNameInPopupWindow(objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();
		
		
		objUpdateStatus1.selectStatusTypes(strStatusTypeValues[0])
						.enterUpdateSSTValues(strStatusTypeValues[0],
								objView_data.strValueForSST2)
						.enterComments(strStatusTypeValues[0], objView_data.strComment3)
						.clickOnSaveButton();
		
		strUpdatedTime = objEventManagement1
				.getApplicationTimeWithCSTCDT();
		
		objMap.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);
		
		objMap.verResourceNameInPopupWindow(objResource_data.strResourceName);
		
		String updatedtime1 = "("+strUpdatedTime+")";

		objMap.verifyUpdatedTimeInPopupWindow(objView_data.strUpdatedValForSST2, updatedtime1);
		
		objEventManagement1.clickOnEventNameInEventBanner(objEvent_data.strEventName);
		
		objEventStatus1.verifyEventStatus();
		
		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					objStatusTypes_data.strSSTStatusTypeName);
		
		strLastUpdatedValue = "Last Update: " + strUpdatedTime;
		
		strComments = "Comment: "+objView_data.strComment3;
		
		objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0], 
												   strStatusTypeValues[0], 
												   objView_data.strUpdatedValForSST2);
		
		objViewsList1.verifyUserUpdatedValue(strResourceValue[0],
								strStatusTypeValues[0], strLastUpdatedValue,
								strUpdatedBy, strComments);
		
		objViewsList1.clickOnIndividualUpdateStatus(strResourceValue[0],
				strStatusTypeValues[0]);
		
		objUpdateStatus1.enterUpdateSSTValues(strStatusTypeValues[0],
				objView_data.strValueForSST3)
				.enterComments(strStatusTypeValues[0], objView_data.strComment4)
				.clickOnSaveButton();

		strUpdatedTime = objEventManagement1
				.getApplicationTimeWithCSTCDT();
		
		objEventStatus1.verifyUpdatedTime(objResource_data.strResourceName, strUpdatedTime);
		
		objEventStatus1.verifyUpdatedUserFullName(objResource_data.strResourceName, objUserdata.strFullName);
		
		objEventStatus1.verifyUpdatedComments(objResource_data.strResourceName, objView_data.strComment4);
		
		strLastUpdatedValue = "Last Update: " + strUpdatedTime;
		
		strComments = "Comment: "+objView_data.strComment4;
		
		objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0], 
												strStatusTypeValues[0], 
												objView_data.strUpdatedValForSST3);
		
		objViewsList1.verifyUserUpdatedValue(strResourceValue[0],
				strStatusTypeValues[0],strLastUpdatedValue, strUpdatedBy, strComments);
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}

	/*************************************************************************************
	'Description : Verify that user receives the following when an event related status of a resource expires: 
					1. Status update prompt.
					2. Expired status notification
	'Precondition:
	'Date	 	 : 28-May-2015
	'Author		 : Pallavi
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that user receives the following when an event related status of a resource expires:"
							+"1. Status update prompt."
							+"2. Expired status notification")
	public void testHappyDay69083() throws Exception {

		gstrTCID = "69083";
		gstrTO = "Verify that user receives the following when an event related status of a resource expires:"
							+"1. Status update prompt."
							+"2. Expired status notification";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		View_data objView_data = new View_data();
		Date_Time_settings objDts = new Date_Time_settings();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();

		Login objLogin = new Login(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);
		ResourceType objResourceType_Page = new ResourceType(this.driver1);
		Resource objResource_Page = new Resource(this.driver1);
		SystemNotifications objSystemNotifications_page = new SystemNotifications(
				this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		EventManagement objEventManagementPage = new EventManagement(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);

		String strStatusTypeValues[] = new String[6];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strStatusesValues[] = new String[2];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
		.clickCreateNewUserButton()
		.enterUserDetails(objUserdata.strNewUserName1,
				objUserdata.strNewPassword, objUserdata.strFullName1)
		.selectFirstRole()
		.clickAdvancedOptionAndExpand()
		.selectMaintainEventsOption()
		.clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectSetupStatusTypesOption()
				.selectSetupResourceTypesOption()
				.selectSetupResourceOption()
				.selectMustUpdateOverdueStatusOption()
				.selectConfigureRegionViewsOption()
				.selectConfigureRegionalUserAccessOption()
				.selectMaintainEventsOption()
				.selectMaintainEventTemplateOption()
				.clickSaveButton()
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUserdata.strNewUserName)
				.clickOnsystemNotifyPreferences();

		objSystemNotifications_page.selectAndSaveExpiredStatusNotification();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objResource_data.strResourceName);

		objLogin.clickLogOut();

		objLogin.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();
		
		StatusTypeList_page.createEventStatusTypeWithExpirationTime(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.streNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objStatusTypes_data.strStatusExpirationTime);

		strStatusTypeValues[0] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.streNSTStatusTypeName);

		StatusTypeList_page
		.clickCreateNewStatusTypeButton()
		.selectStatusType(objStatusTypes_data.strMultiStatusType)
		.clickNextButton()
		.enterStatusTypeName(objStatusTypes_data.streMSTStatusTypeName)
		.enterStatusTypeDescription(
				objStatusTypes_data.strStatusDescription)
		.selectEventOnlyOption()
		.clickOnSaveButton();

		StatusTypeList_page.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti)
				.selectStatusColor(objStatusTypes_data.strStatusColor)
				.selectEventExpirationOption()
				.selectExpirationMinute(objStatusTypes_data.strExpSec)
				.clickOnSaveButton();
		
		strStatusesValues[0] = StatusTypeList_page
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);
		
		StatusTypeList_page.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti1)
				.selectStatusColor(objStatusTypes_data.strStatusColor)
				.clickOnSaveButton();
		
		strStatusesValues[1] = StatusTypeList_page
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);
		
		StatusTypeList_page.clickOnReturnToStatusTypeList();
		
		strStatusTypeValues[1] = StatusTypeList_page
							.getStatusValue(objStatusTypes_data.streMSTStatusTypeName);
		
		StatusTypeList_page.createEventStatusTypeWithExpirationTime(
				objStatusTypes_data.strTextStatusType, 
				objStatusTypes_data.streTSTStatusTypeName, 
				objStatusTypes_data.strStatusDescription,
				objStatusTypes_data.strStatusExpirationTime);
		
		strStatusTypeValues[2] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.streTSTStatusTypeName);
		
		StatusTypeList_page.createEventStatusTypeWithExpirationTime(
				objStatusTypes_data.strSaturationScoreStatusType, 
				objStatusTypes_data.streSSTStatusTypeName, 
				objStatusTypes_data.strStatusDescription,
				objStatusTypes_data.strStatusExpirationTime);
		
		strStatusTypeValues[3] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.streSSTStatusTypeName);
		
		StatusTypeList_page.createEventStatusTypeWithExpirationTime(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.streNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objStatusTypes_data.strStatusExpirationTime);

		strStatusTypeValues[4] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.streNDSTStatusTypeName);
		
		StatusTypeList_page.createEventStatusTypeWithExpirationTime(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.streDateStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objStatusTypes_data.strStatusExpirationTime);

		strStatusTypeValues[5] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.streDateStatusTypeName);
		
		// Resource type creation
		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType_Page.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource_Page.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource_Page
				.getResourceValue(objResource_data.strResourceName);
		
		System.out.println(objResource_data.strResourceName);
		System.out.println(objUserdata.strNewUserName);

		objResource_Page
				.selectUsersLinkInResourceList(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objUserdata.strNewUserName)
				.clickOnSaveButton();

		String[] strAllStatausTypes = { objStatusTypes_data.streNSTStatusTypeName,
										objStatusTypes_data.streMSTStatusTypeName,
										objStatusTypes_data.streTSTStatusTypeName,
										objStatusTypes_data.streSSTStatusTypeName,
										objStatusTypes_data.streNDSTStatusTypeName,
										objStatusTypes_data.streDateStatusTypeName };

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
								objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
								strStatusTypeValues)
					 .deselectSelectAllWebOption();		
		
		objLogin.clickLogOut();
		
		objLogin.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);
		
		objRegionDefault.selectFrame();
		
		objEventManagementPage.navigateToEventManagement()
						      .clickOnCreateNewEvent()
						      .clickOnCreateEvent(
						    		  objEventSetUp_data.strEventTemplate)
						      .enterAdHocEventName(
						    		  objEvent_data.strEventName)
						      .enterAdHocEventDescription(
						    		  objEvent_data.strEventDescription)
						      .selectResource(strResourceValue)
						      .clickOnSaveButton();
		
		System.out.println(objEvent_data.strEventName);
		
		objLogin.clickLogOut();
		
		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
		String[] arrUpdatedValues = { objView_data.strValueForUpdate, objStatusTypes_data.strStatusNameInMulti,
									  objView_data.strValueForTST, objView_data.strUpdatedValForSST,
									  objView_data.strNEDOCValue, objView_data.strDateUpdateValue };
		
		objEventStatus1.clickOnShowAllStatuses();

		objUpdateStatus1
				.verUpdateStatusPge()
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[0], 
							objView_data.strValueForUpdate)
				.selectMSTUpdateValue(strStatusTypeValues[1],
						strStatusesValues[0])
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[2], 
							objView_data.strValueForTST)
				.enterUpdateSSTValues(strStatusTypeValues[3],
						objView_data.strValueForSST)
				.enterNedocsUpdateValue(strStatusTypeValues[4], 
						objView_data.strValueForNDST)
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[5],
								objView_data.strDateUpdateValue)
				.clickOnSaveButton();

		String strApplicationTime = objEventManagement1.getApplicationTime();

		String strCurrentYear = objDts.getCurrentDate("yyyy");

		strApplicationTime = strApplicationTime + " " + strCurrentYear;

		strApplicationTime = objDts.converDateFormat(strApplicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");

		strApplicationTime = objDts.addTimetoExisting(strApplicationTime, 5,
				"MM/dd/yyyy HH:mm");

		System.out.println(strApplicationTime);

		objEventManagement1.clickOnEventNameInEventBanner(objEvent_data.strEventName);
		
		for (int intCount = 0; intCount < strAllStatausTypes.length; intCount++) {
			objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0],
					strStatusTypeValues[intCount], arrUpdatedValues[intCount]);
		}

		// wait until expiration time
		TimeUnit.MINUTES.sleep(6);
		TimeUnit.SECONDS.sleep(30);

		objUpdateStatus1
				.verUpdateStatusPge();
		
		for(int i = 0; i < strAllStatausTypes.length; i++){
			objUpdateStatus1.verStatusTypeExpanded(strStatusTypeValues[i]);
		}
				
		objUpdateStatus1
				.verUpdateStatusPge()
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[0], 
							objView_data.strValueForUpdate1)
				.selectMSTUpdateValue(strStatusTypeValues[1],
						strStatusesValues[1])
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[2], 
							objView_data.strValueForTST1)
				.enterUpdateSSTValues(strStatusTypeValues[3],
						objView_data.strValueForSST1)
				.enterNedocsUpdateValue(strStatusTypeValues[4], 
						objView_data.strValueForNDST1)
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[5],
								objView_data.strDateUpdateFutureValue)
				.clickOnSaveButton();
		
		String[] arrSecUpdatedValues = { objView_data.strValueForUpdate1, objStatusTypes_data.strStatusNameInMulti1,
										  objView_data.strValueForTST1, objView_data.strUpdatedValForSST1,
										  objView_data.strNEDOCValue2, objView_data.strDateUpdateFutureValue };

		for(int intCount = 0; intCount < strAllStatausTypes.length; intCount++){
			objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0],
					strStatusTypeValues[intCount],
					arrSecUpdatedValues[intCount]);
		}

		objLogin1.clickLogOut();

		String strSubject = "EMResource Expired Status Notification: "
				+ objResource_data.strResourceName;
		
		String strSubject1 = "EMResource Expired Status: "+objResource_data.strResourceAbbrivation;
		
		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		objMailVerificationFunctions.NavToInbox(strSubject);

		String strMsgBodyNST = objMailVerificationFunctions
				.getExpiredStatusEmailBody(objUserdata.strFullName,
						objLogindata.strRegionName,
						strAllStatausTypes[0],
						objResource_data.strResourceName, strApplicationTime);
		
		String strMsgBodyMST = objMailVerificationFunctions
				.getExpiredStatusEmailBody(objUserdata.strFullName,
						objLogindata.strRegionName,
						strAllStatausTypes[1],
						objResource_data.strResourceName, strApplicationTime);
		
		String strMsgBodyTST = objMailVerificationFunctions
				.getExpiredStatusEmailBody(objUserdata.strFullName,
						objLogindata.strRegionName,
						strAllStatausTypes[2],
						objResource_data.strResourceName, strApplicationTime);
		
		String strMsgBodySSST = objMailVerificationFunctions
				.getExpiredStatusEmailBody(objUserdata.strFullName,
						objLogindata.strRegionName,
						strAllStatausTypes[3],
						objResource_data.strResourceName, strApplicationTime);
		
		String strMsgBodyNDST = objMailVerificationFunctions
				.getExpiredStatusEmailBody(objUserdata.strFullName,
						objLogindata.strRegionName,
						strAllStatausTypes[4],
						objResource_data.strResourceName, strApplicationTime);
		
		String strMsgBodyDST = objMailVerificationFunctions
				.getExpiredStatusEmailBody(objUserdata.strFullName,
						objLogindata.strRegionName,
						strAllStatausTypes[5],
						objResource_data.strResourceName, strApplicationTime);

		String strPagerBodyNST = objMailVerificationFunctions
				.getExpiredStatusPagerBody(
						strAllStatausTypes[0],
						objResource_data.strResourceName, strApplicationTime);
		
		String strPagerBodyMST = objMailVerificationFunctions
				.getExpiredStatusPagerBody(
						strAllStatausTypes[1],
						objResource_data.strResourceName, strApplicationTime);
		
		String strPagerBodyTST = objMailVerificationFunctions
				.getExpiredStatusPagerBody(
						strAllStatausTypes[2],
						objResource_data.strResourceName, strApplicationTime);
		
		String strPagerBodySSST = objMailVerificationFunctions
				.getExpiredStatusPagerBody(
						strAllStatausTypes[3],
						objResource_data.strResourceName, strApplicationTime);
		
		String strPagerBodyNDST = objMailVerificationFunctions
				.getExpiredStatusPagerBody(
						strAllStatausTypes[4],
						objResource_data.strResourceName, strApplicationTime);
		
		String strPagerBodyDST = objMailVerificationFunctions
				.getExpiredStatusPagerBody(
						strAllStatausTypes[5],
						objResource_data.strResourceName, strApplicationTime);
		
		int intCnt = 0;

		for (int intCount = 0; intCount < 12; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubject);

			String strMsgInWeb = objMailVerificationFunctions.getMailBody();

			if (strMsgInWeb.equals(strMsgBodyNST)) {
				intCnt++;
			}
			
			if (strMsgInWeb.equals(strMsgBodyMST)) {
				intCnt++;
			}
			
			if (strMsgInWeb.equals(strMsgBodyTST)) {
				intCnt++;
			}
			
			if (strMsgInWeb.equals(strMsgBodySSST)) {
				intCnt++;
			}
			
			if (strMsgInWeb.equals(strMsgBodyNDST)) {
				intCnt++;
			}
			
			if (strMsgInWeb.equals(strMsgBodyDST)) {
				intCnt++;
			}
			
			objMailVerificationFunctions.backToMailInbox();
		}
		
		int intCnt1 = 0;
		for(int i = 0; i < strAllStatausTypes.length; i++){
			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubject1);

			String strMsgInWeb = objMailVerificationFunctions.getMailBody();
			
			if (strMsgInWeb.equals(strPagerBodyNST)) {
				intCnt1++;
			}
			
			if (strMsgInWeb.equals(strPagerBodyMST)) {
				intCnt1++;
			}
			
			if (strMsgInWeb.equals(strPagerBodyTST)) {
				intCnt1++;
			}
			
			if (strMsgInWeb.equals(strPagerBodySSST)) {
				intCnt1++;
			}
			
			if (strMsgInWeb.equals(strPagerBodyNDST)) {
				intCnt1++;
			}
			
			if (strMsgInWeb.equals(strPagerBodyDST)) {
				intCnt1++;
			}
			
			objMailVerificationFunctions.backToMailInbox();
		}
		System.out.println(intCnt  + ", " + intCnt1);
		assertTrue(intCnt1 == 6 && intCnt == 12);

		objMailVerificationFunctions.logoutMail();

		gstrResult = "PASS";
	}
}
