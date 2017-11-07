package requirementGroup.CreatingAndManagingEvents;

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
import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewCreatePrivateEvent extends TestNG_UI_EXTENSIONS{

	public NewCreatePrivateEvent() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/*********************************************************************************************
	'Description 	: Verify that a user with 'View all resources in private event' right can view 
	                  the event related status types of resources associated with private event. 
	'Date 			: 22-Jun-2015 
	'Author 		: Renushree
	'---------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************************/
	@Test(description = "Verify that a user with 'View all resources in private event' right can view the event"
			+ " related status types of resources associated with private event. ")
	public void testHappyDay68347() throws Exception {

		gstrTCID = "68347";
		gstrTO = "Verify that a user with 'View all resources in private event' right can view the event related "
				+ "status types of resources associated with private event. ";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		View_data objView_data = new View_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);

		String strStatusTypeValues[] = new String[6];
		String strPrivateStatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Map objMap1 = new Map(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		
		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		objStatusTypeList.navigateToStatusTypeListNew();

		// RoleBased statustypes
		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName)
			.createNewStatus(objStatuTypes_data.strStatusNameInMulti,
						objStatuTypes_data.strStatusColor)
			.createNewStatus(objStatuTypes_data.strStatusNameInMulti1,	objStatuTypes_data.strStatusColor)
			.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameInMulti)
			.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameInMulti1)
	        .clickOnReturnToStatusTypeList();

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strDateStatusType,
				objStatuTypes_data.strDateStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strDateStatusTypeName);

		// Create event status type
		objStatusTypeList.createEventStatusTypeWithSection(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.streNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strPrivateStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.streNSTStatusTypeName);

		objStatusTypeList.createEventStatusTypeWithSection(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.streTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strPrivateStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.streTSTStatusTypeName);

		objStatusTypeList.createEventStatusTypeWithSection(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.streMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName)
			.createNewStatus(objStatuTypes_data.strStatusNameInMulti,
					objStatuTypes_data.strStatusColor)
			.createNewStatus(objStatuTypes_data.strStatusNameInMulti1,	objStatuTypes_data.strStatusColor)
			.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameInMulti)
			.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameInMulti1)
	.clickOnReturnToStatusTypeList();

		strPrivateStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.streMSTStatusTypeName);

		objStatusTypeList.createEventStatusTypeWithSection(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.streSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strPrivateStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.streSSTStatusTypeName);

		objStatusTypeList.createEventStatusTypeWithSection(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.streNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strPrivateStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.streNDSTStatusTypeName);

		objStatusTypeList.createEventStatusTypeWithSection(
				objStatuTypes_data.strDateStatusType,
				objStatuTypes_data.streDateStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strPrivateStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.streDateStatusTypeName);

		String[] strAllStatusTypesValues = ArrayUtils.addAll(
				strStatusTypeValues, strPrivateStatusTypeValues);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName,
				strAllStatusTypesValues);

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

		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectMaintainEventsOption()
				.selectMaintainEventTemplateOption()
				.selectConfigureRegionalUserAccessOption().clickSaveButton();

		System.out.println(objUser_data.strNewUserName);
		System.out.println(objStatuTypes_data.strNSTStatusTypeName);

		// create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strAllStatusTypesValues).deselectSelectAllWebOption();

		objLogin.clickLogOut();

		System.out.println(objEventSetUp_data.strEventTemplate);

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.clickPrivateCheckBox();

		objResource1.clickResource(strResourceValue);

		objEventManagement1.clickOnSaveButton();

		objNavigationToSubMenus1.navigateToUsers();

		objUsersList1
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals)
				.editUserDetails(objUser_data.strNewUserName)
				.clickAdvancedOptionAndExpand()
				.selectOverrideViewingRestrictionOption().clickSaveButton();

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		String[] strStatusTypeNames = {
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strDateStatusTypeName,
				objStatuTypes_data.streNSTStatusTypeName,
				objStatuTypes_data.streNDSTStatusTypeName,
				objStatuTypes_data.streTSTStatusTypeName,
				objStatuTypes_data.streMSTStatusTypeName,
				objStatuTypes_data.streSSTStatusTypeName,
				objStatuTypes_data.streDateStatusTypeName, };

		for (int i = 0; i < strStatusTypeNames.length; i++) {

			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strStatusTypeNames[i]);
		}

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verResourceNameInPopupWindow(objResource_data.strResourceName)
				.verStatusTypesInPopupWindow(strStatusTypeNames)
				.clickOnViewInfoInPopupWindow()
				.verViewResDetailScreenIsDisplayedWithResName(
						objResource_data.strResourceName)
				.verStatusTypesUnderSection(strStatusTypeNames,
						objView_data.strSectionName);

		objLogin1.clickLogOut();
		
		String[] strTestData = {
				Login_data.strBuildName,
				gstrTCID,
				objUser_data.strNewUserName + "/" + objUser_data.strNewPassword,
				objEventSetUp_data.strEventTemplate,
				objEvent_data.strEventName,
				"Verify mobile end condition with event name ,resources and all status types displayed",
				objStatuTypes_data.strNSTStatusTypeName + ", "
						+ objStatuTypes_data.strMSTStatusTypeName + ", "
						+ objStatuTypes_data.strSSTStatusTypeName + ", "
						+ objStatuTypes_data.strTSTStatusTypeName + ", "
						+ objStatuTypes_data.strNDSTStatusTypeName + ", "
						+ objStatuTypes_data.strDateStatusTypeName + ", "
						+ objStatuTypes_data.streNSTStatusTypeName + ", "
						+ objStatuTypes_data.streMSTStatusTypeName + ", "
						+ objStatuTypes_data.streSSTStatusTypeName + ", "
						+ objStatuTypes_data.streTSTStatusTypeName + ", "
						+ objStatuTypes_data.streNDSTStatusTypeName + ", "
						+ objStatuTypes_data.streDateStatusTypeName,
				objResource_data.strResourceName,
				objResourceType_data.strResourceTypeName,
				objTest_data.strRegionName, objView_data.strSectionName};

		objOffCommonFunc.writeResultData(strTestData,
				strPartialAutoResultsPath, "Events");
		
		gstrResult = "PASS";
	}
	
	/***********************************************************************************************
	 * 'Description 	: Verify that a user with 'Update status' right on the resource can view the 
	 *                    event related status types of the resource associated with private event.
	 * 'Date 			: 22-June-2014 
	 * 'Author 			: Anitha
	 * '--------------------------------------------------------------------------------------------
	 * 'Modified Date 			                                             Modified By 
	 * 'Date                                                                 Name
	 ***********************************************************************************************/
	@Test(description = "Verify that a user with 'Update status' right on the resource can view the event related "
			+ "status types of the resource associated with private event.")
	public void testHappyDay68367() throws Exception {

		gstrTCID = "68367";
		gstrTO = "Verify that a user with 'Update status' right on the resource can view the event related status "
				+ "types of the resource associated with private event.";

		boolean blnTest = false;
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		Event_data objEvent_data = new Event_data();
		View_data objView_data = new View_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		Map objMap1 = new Map(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[6];
		String strEventStatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToViews();

		objViewsList.clickOncustomizeResourceDetailView()
				.enterSectionName(objView_data.strSectionName)
				.clickOnCreateSection()
				.verCreatedSection(objView_data.strSectionName)
				.clickOnSaveButton();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createEventStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.streNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strEventStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streNSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName)
			.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
			.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,						objStatusTypes_data.strStatusColor)
			.verCreatedStatusInStatusListForMulti(
							objStatusTypes_data.strStatusNameInMulti)
			.verCreatedStatusInStatusListForMulti(
							objStatusTypes_data.strStatusNameInMulti1)
	.clickOnReturnToStatusTypeList();
		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createEventStatusTypeWithSection(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.streMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName)
			.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
			.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,						objStatusTypes_data.strStatusColor)
			.verCreatedStatusInStatusListForMulti(
							objStatusTypes_data.strStatusNameInMulti)
			.verCreatedStatusInStatusListForMulti(
							objStatusTypes_data.strStatusNameInMulti1)
	.clickOnReturnToStatusTypeList();
		strEventStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streMSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createEventStatusTypeWithSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.streTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strEventStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streTSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createEventStatusTypeWithSection(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.streSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strEventStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streSSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createEventStatusTypeWithSection(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.streNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strEventStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streNDSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		objStatusTypeList.createEventStatusTypeWithSection(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.streDateStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strEventStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streDateStatusTypeName);

		String[] strAllStatusTypes = ArrayUtils.addAll(strStatusTypeValues,
				strEventStatusTypeValues);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strAllStatusTypes);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource.createResourceWithAddress(objResource_data.strResourceName,
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

		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.selectMaintainEventTemplateOption()
				.selectConfigureRegionalUserAccessOption().clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strAllStatusTypes).deselectSelectAllWebOption();

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objResource_data.strResourceName);

		System.out.println("--------Precondition ends and test execution starts---------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.clickPrivateCheckBox().selectResource(strResourceValue)
				.clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);

		objUsersList1
				.navigateToUsers()
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strEquals)
						.editUserDetails(objUserdata.strNewUserName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickSaveButton();

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		String[] strStatusTypeNames = {
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName };

		String[] strEventStatusTypeNames = {
				objStatusTypes_data.streDateStatusTypeName,
				objStatusTypes_data.streNDSTStatusTypeName, 
				objStatusTypes_data.streNSTStatusTypeName,
				objStatusTypes_data.streMSTStatusTypeName,
				objStatusTypes_data.streTSTStatusTypeName,
				objStatusTypes_data.streSSTStatusTypeName };

		String[] strAllStatusTypeNames = ArrayUtils.addAll(strStatusTypeNames,
				strEventStatusTypeNames);

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int i = 0; i < strAllStatusTypeNames.length; i++) {
			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strAllStatusTypeNames[i]);
		}

		objNavigationToSubmenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verResourceNameInPopupWindow(objResource_data.strResourceName)
				.verStatusTypesInPopupWindow(strAllStatusTypeNames);
		
		objMap1.clickOnViewInfoInPopupWindow()
				.verViewResDetailScreenIsDisplayedWithResName(
						objResource_data.strResourceName)
				.verStatusTypesUnderSection(strAllStatusTypeNames,
						objView_data.strSectionName);

		objLogin1.clickLogOut();
		
		blnTest = true;

		if (blnTest) {

			String[] strTestData = {
					Login_data.strBuildName,
					gstrTCID,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objEventSetUp_data.strEventTemplate,
					objEvent_data.strEventName,
					"Verify mobile end condition with event name ,resources and all status types displayed",
					objStatusTypes_data.strNSTStatusTypeName + ", "
							+ objStatusTypes_data.strMSTStatusTypeName + ", "
							+ objStatusTypes_data.strSSTStatusTypeName + ", "
							+ objStatusTypes_data.strTSTStatusTypeName + ", "
							+ objStatusTypes_data.strNDSTStatusTypeName + ", "
							+ objStatusTypes_data.strDateStatusTypeName + ", "
							+ objStatusTypes_data.streNSTStatusTypeName + ", "
							+ objStatusTypes_data.streMSTStatusTypeName + ", "
							+ objStatusTypes_data.streSSTStatusTypeName + ", "
							+ objStatusTypes_data.streTSTStatusTypeName + ", "
							+ objStatusTypes_data.streNDSTStatusTypeName + ", "
							+ objStatusTypes_data.streDateStatusTypeName,
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objLogindata.strRegionName, objView_data.strSectionName };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "Events");
		}

		gstrResult = "PASS";

	}
	
	/***********************************************************************************************
	 * 'Description 	: Verify that a user with 'Run report' right on the resource can view the 
	 *                    event related status types of the resource associated with private event.
	 * 'Date 			: 22-June-2014 
	 * 'Author 			: Anitha
	 * '--------------------------------------------------------------------------------------------
	 * 'Modified Date 			                                             Modified By 
	 * 'Date                                                                 Name
	 ***********************************************************************************************/
	@Test(description = "Verify that a user with 'Run report' right on the resource can view the event related "
			+ "status types of the resource associated with private event.")
	public void testHappyDay68368() throws Exception {

		gstrTCID = "68368";
		gstrTO = "Verify that a user with 'Run report' right on the resource can view the event related status "
				+ "types of the resource associated with private event.";

		boolean blnTest = false;
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		Event_data objEvent_data = new Event_data();
		View_data objView_data = new View_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		Map objMap1 = new Map(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[6];
		String strEventStatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToViews();

		objViewsList.clickOncustomizeResourceDetailView()
				.enterSectionName(objView_data.strSectionName)
				.clickOnCreateSection()
				.verCreatedSection(objView_data.strSectionName)
				.clickOnSaveButton();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createEventStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.streNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strEventStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streNSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName)
			.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
			.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,						objStatusTypes_data.strStatusColor)
			.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti)
			.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti1)
	        .clickOnReturnToStatusTypeList();
		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createEventStatusTypeWithSection(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.streMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName)
			.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
			.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,						objStatusTypes_data.strStatusColor)
			.verCreatedStatusInStatusListForMulti(
							objStatusTypes_data.strStatusNameInMulti)
			.verCreatedStatusInStatusListForMulti(
							objStatusTypes_data.strStatusNameInMulti1)
	        .clickOnReturnToStatusTypeList();
		strEventStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streMSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createEventStatusTypeWithSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.streTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strEventStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streTSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createEventStatusTypeWithSection(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.streSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strEventStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streSSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createEventStatusTypeWithSection(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.streNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strEventStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streNDSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		objStatusTypeList.createEventStatusTypeWithSection(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.streDateStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strEventStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streDateStatusTypeName);

		String[] strAllStatusTypes = ArrayUtils.addAll(strStatusTypeValues,
				strEventStatusTypeValues);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strAllStatusTypes);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource.createResourceWithAddress(objResource_data.strResourceName,
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

		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.selectMaintainEventTemplateOption()
				.selectConfigureRegionalUserAccessOption().clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strAllStatusTypes).deselectSelectAllWebOption();

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objResource_data.strResourceName);

		System.out.println("--------Precondition ends and test execution starts---------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.clickPrivateCheckBox().selectResource(strResourceValue)
				.clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);

		objUsersList1
				.navigateToUsers()
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strEquals)
						.editUserDetails(objUserdata.strNewUserName)
				.selectRunReportRight(objResource_data.strResourceName)
				.clickSaveButton();

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		String[] strStatusTypeNames = {
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName };

		String[] strEventStatusTypeNames = {
				objStatusTypes_data.streDateStatusTypeName,
				objStatusTypes_data.streNDSTStatusTypeName, 
				objStatusTypes_data.streNSTStatusTypeName,
				objStatusTypes_data.streMSTStatusTypeName,
				objStatusTypes_data.streTSTStatusTypeName,
				objStatusTypes_data.streSSTStatusTypeName };

		String[] strAllStatusTypeNames = ArrayUtils.addAll(strStatusTypeNames,
				strEventStatusTypeNames);

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int i = 0; i < strAllStatusTypeNames.length; i++) {
			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strAllStatusTypeNames[i]);
		}

		objNavigationToSubmenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verResourceNameInPopupWindow(objResource_data.strResourceName)
				.verStatusTypesInPopupWindow(strAllStatusTypeNames);
		
		objMap1.clickOnViewInfoInPopupWindow()
				.verViewResDetailScreenIsDisplayedWithResName(
						objResource_data.strResourceName)
				.verStatusTypesUnderSection(strAllStatusTypeNames,
						objView_data.strSectionName);

		objLogin1.clickLogOut();
		
		blnTest = true;

		if (blnTest) {

			String[] strTestData = {
					Login_data.strBuildName,
					gstrTCID,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objEventSetUp_data.strEventTemplate,
					objEvent_data.strEventName,
					"Verify mobile end condition with event name ,resources and all status types displayed",
					objStatusTypes_data.strNSTStatusTypeName + ", "
							+ objStatusTypes_data.strMSTStatusTypeName + ", "
							+ objStatusTypes_data.strSSTStatusTypeName + ", "
							+ objStatusTypes_data.strTSTStatusTypeName + ", "
							+ objStatusTypes_data.strNDSTStatusTypeName + ", "
							+ objStatusTypes_data.strDateStatusTypeName + ", "
							+ objStatusTypes_data.streNSTStatusTypeName + ", "
							+ objStatusTypes_data.streMSTStatusTypeName + ", "
							+ objStatusTypes_data.streSSTStatusTypeName + ", "
							+ objStatusTypes_data.streTSTStatusTypeName + ", "
							+ objStatusTypes_data.streNDSTStatusTypeName + ", "
							+ objStatusTypes_data.streDateStatusTypeName,
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objLogindata.strRegionName, objView_data.strSectionName };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "Events");
		}

		gstrResult = "PASS";

	}
	
	/***********************************************************************************************
	 * 'Description 	: Verify that a user with 'Associated with' right on the resource cannot view 
	 *                  the event related status types of the resource associated with private event.
	 * 'Date 			: 22-June-2014 
	 * 'Author 			: Anitha
	 * '--------------------------------------------------------------------------------------------
	 * 'Modified Date 			                                             Modified By 
	 * 'Date                                                                 Name
	 ***********************************************************************************************/
	@Test(description = "Verify that a user with 'Associated with' right on the resource cannot view the "
			+ "event related status types of the resource associated with private event.")
	public void testHappyDay68369() throws Exception {

		gstrTCID = "68369";
		gstrTO = "Verify that a user with 'Associated with' right on the resource cannot view the event"
				+ " related status types of the resource associated with private event.";

		boolean blnTest = false;
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		Event_data objEvent_data = new Event_data();
		View_data objView_data = new View_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		Map objMap1 = new Map(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[6];
		String strEventStatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToViews();

		objViewsList.clickOncustomizeResourceDetailView()
				.enterSectionName(objView_data.strSectionName)
				.clickOnCreateSection()
				.verCreatedSection(objView_data.strSectionName)
				.clickOnSaveButton();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createEventStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.streNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strEventStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streNSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName)
			.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
			.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,						objStatusTypes_data.strStatusColor)
			.verCreatedStatusInStatusListForMulti(
							objStatusTypes_data.strStatusNameInMulti)
			.verCreatedStatusInStatusListForMulti(
							objStatusTypes_data.strStatusNameInMulti1)
	.clickOnReturnToStatusTypeList();
		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createEventStatusTypeWithSection(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.streMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName)
			.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
			.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,						objStatusTypes_data.strStatusColor)
			.verCreatedStatusInStatusListForMulti(
							objStatusTypes_data.strStatusNameInMulti)
			.verCreatedStatusInStatusListForMulti(
							objStatusTypes_data.strStatusNameInMulti1)
	        .clickOnReturnToStatusTypeList();
		strEventStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streMSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createEventStatusTypeWithSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.streTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strEventStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streTSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createEventStatusTypeWithSection(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.streSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strEventStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streSSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createEventStatusTypeWithSection(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.streNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strEventStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streNDSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		objStatusTypeList.createEventStatusTypeWithSection(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.streDateStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strEventStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streDateStatusTypeName);

		String[] strAllStatusTypes = ArrayUtils.addAll(strStatusTypeValues,
				strEventStatusTypeValues);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strAllStatusTypes);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource.createResourceWithAddress(objResource_data.strResourceName,
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

		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.selectMaintainEventTemplateOption()
				.selectConfigureRegionalUserAccessOption().clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strAllStatusTypes).deselectSelectAllWebOption();

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objResource_data.strResourceName);

		System.out.println("--------Precondition ends and test execution starts---------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.clickPrivateCheckBox().selectResource(strResourceValue)
				.clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);

		objUsersList1
				.navigateToUsers()
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strEquals)
						.editUserDetails(objUserdata.strNewUserName)
				.selectAssosciateResourceRight(objResource_data.strResourceName)
				.clickSaveButton();

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		String[] strStatusTypeNames = {
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName };

		String[] strEventStatusTypeNames = {
				objStatusTypes_data.streDateStatusTypeName,
				objStatusTypes_data.streNDSTStatusTypeName, 
				objStatusTypes_data.streNSTStatusTypeName,
				objStatusTypes_data.streMSTStatusTypeName,
				objStatusTypes_data.streTSTStatusTypeName,
				objStatusTypes_data.streSSTStatusTypeName };

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1.verifyErrorMessageDisplayed();

		objNavigationToSubmenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verResourceNameInPopupWindow(objResource_data.strResourceName)
				.verStatusTypesInPopupWindow(strStatusTypeNames)
		        .verStatusTypesNotInPopupWindow(strEventStatusTypeNames);
		
		objMap1.clickOnViewInfoInPopupWindow()
				.verViewResDetailScreenIsDisplayedWithResName(
						objResource_data.strResourceName)
				.verStatusTypesUnderSection(strStatusTypeNames,
						objView_data.strSectionName)
			    .verStatusTypesNotUnderSection(strEventStatusTypeNames,
						objView_data.strSectionName);

		objLogin1.clickLogOut();
		
		blnTest = true;

		if (blnTest) {

			String[] strTestData = {
					Login_data.strBuildName,
					gstrTCID,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objEventSetUp_data.strEventTemplate,
					objEvent_data.strEventName,
					"Verify mobile end condition with event name ,resources and status types displayed",
					objStatusTypes_data.strNSTStatusTypeName + ", "
							+ objStatusTypes_data.strMSTStatusTypeName + ", "
							+ objStatusTypes_data.strSSTStatusTypeName + ", "
							+ objStatusTypes_data.strTSTStatusTypeName + ", "
							+ objStatusTypes_data.strNDSTStatusTypeName + ", "
							+ objStatusTypes_data.strDateStatusTypeName + ", "
							+ objStatusTypes_data.streNSTStatusTypeName + ", "
							+ objStatusTypes_data.streMSTStatusTypeName + ", "
							+ objStatusTypes_data.streSSTStatusTypeName + ", "
							+ objStatusTypes_data.streTSTStatusTypeName + ", "
							+ objStatusTypes_data.streNDSTStatusTypeName + ", "
							+ objStatusTypes_data.streDateStatusTypeName,
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objLogindata.strRegionName, objView_data.strSectionName };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "Events");
		}

		gstrResult = "PASS";

	}
	
	/***********************************************************************************************
	 * 'Description 	: Verify that a user with 'View Resource' right on the resource cannot view 
	 *                  the event related status types of the resource associated with private event.
	 * 'Date 			: 22-June-2014 
	 * 'Author 			: Anitha
	 * '--------------------------------------------------------------------------------------------
	 * 'Modified Date 			                                             Modified By 
	 * 'Date                                                                 Name
	 ***********************************************************************************************/
	@Test(description = "Verify that a user with 'View Resource' right on the resource cannot view the "
			+ "event related status types of the resource associated with private event.")
	public void testHappyDay68370() throws Exception {

		gstrTCID = "68370";
		gstrTO = "Verify that a user with 'View Resource' right on the resource cannot view the event"
				+ " related status types of the resource associated with private event.";

		boolean blnTest = false;
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		Event_data objEvent_data = new Event_data();
		View_data objView_data = new View_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		Map objMap1 = new Map(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[6];
		String strEventStatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToViews();

		objViewsList.clickOncustomizeResourceDetailView()
				.enterSectionName(objView_data.strSectionName)
				.clickOnCreateSection()
				.verCreatedSection(objView_data.strSectionName)
				.clickOnSaveButton();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createEventStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.streNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strEventStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streNSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName)
			.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
			.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,						objStatusTypes_data.strStatusColor)
			.verCreatedStatusInStatusListForMulti(
							objStatusTypes_data.strStatusNameInMulti)
			.verCreatedStatusInStatusListForMulti(
							objStatusTypes_data.strStatusNameInMulti1)
	        .clickOnReturnToStatusTypeList();
		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createEventStatusTypeWithSection(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.streMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName)
			.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
			.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,						objStatusTypes_data.strStatusColor)
			.verCreatedStatusInStatusListForMulti(
							objStatusTypes_data.strStatusNameInMulti)
			.verCreatedStatusInStatusListForMulti(
							objStatusTypes_data.strStatusNameInMulti1)
	        .clickOnReturnToStatusTypeList();
		strEventStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streMSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createEventStatusTypeWithSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.streTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strEventStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streTSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createEventStatusTypeWithSection(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.streSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strEventStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streSSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createEventStatusTypeWithSection(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.streNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strEventStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streNDSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		objStatusTypeList.createEventStatusTypeWithSection(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.streDateStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strEventStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streDateStatusTypeName);

		String[] strAllStatusTypes = ArrayUtils.addAll(strStatusTypeValues,
				strEventStatusTypeValues);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strAllStatusTypes);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource.createResourceWithAddress(objResource_data.strResourceName,
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

		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.selectMaintainEventTemplateOption()
				.selectConfigureRegionalUserAccessOption().clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strAllStatusTypes).deselectSelectAllWebOption();

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objResource_data.strResourceName);

		System.out.println("--------Precondition ends and test execution starts---------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.clickPrivateCheckBox().selectResource(strResourceValue)
				.clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);

		objUsersList1
				.navigateToUsers()
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strEquals)
						.editUserDetails(objUserdata.strNewUserName)
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickSaveButton();

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		String[] strStatusTypeNames = {
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName };

		String[] strEventStatusTypeNames = {
				objStatusTypes_data.streDateStatusTypeName,
				objStatusTypes_data.streNDSTStatusTypeName, 
				objStatusTypes_data.streNSTStatusTypeName,
				objStatusTypes_data.streMSTStatusTypeName,
				objStatusTypes_data.streTSTStatusTypeName,
				objStatusTypes_data.streSSTStatusTypeName };

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1.verifyErrorMessageDisplayed();

		objNavigationToSubmenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verResourceNameInPopupWindow(objResource_data.strResourceName)
				.verStatusTypesInPopupWindow(strStatusTypeNames)
		        .verStatusTypesNotInPopupWindow(strEventStatusTypeNames);
		
		objMap1.clickOnViewInfoInPopupWindow()
				.verViewResDetailScreenIsDisplayedWithResName(
						objResource_data.strResourceName)
				.verStatusTypesUnderSection(strStatusTypeNames,
						objView_data.strSectionName)
			    .verStatusTypesNotUnderSection(strEventStatusTypeNames,
						objView_data.strSectionName);

		objLogin1.clickLogOut();
		
		blnTest = true;

		if (blnTest) {

			String[] strTestData = {
					Login_data.strBuildName,
					gstrTCID,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objEventSetUp_data.strEventTemplate,
					objEvent_data.strEventName,
					"Verify mobile end condition with event name ,resources and status types displayed",
					objStatusTypes_data.strNSTStatusTypeName + ", "
							+ objStatusTypes_data.strMSTStatusTypeName + ", "
							+ objStatusTypes_data.strSSTStatusTypeName + ", "
							+ objStatusTypes_data.strTSTStatusTypeName + ", "
							+ objStatusTypes_data.strNDSTStatusTypeName + ", "
							+ objStatusTypes_data.strDateStatusTypeName + ", "
							+ objStatusTypes_data.streNSTStatusTypeName + ", "
							+ objStatusTypes_data.streMSTStatusTypeName + ", "
							+ objStatusTypes_data.streSSTStatusTypeName + ", "
							+ objStatusTypes_data.streTSTStatusTypeName + ", "
							+ objStatusTypes_data.streNDSTStatusTypeName + ", "
							+ objStatusTypes_data.streDateStatusTypeName,
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objLogindata.strRegionName, objView_data.strSectionName };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "Events");
		}
		
		gstrResult = "PASS";
	}
}
