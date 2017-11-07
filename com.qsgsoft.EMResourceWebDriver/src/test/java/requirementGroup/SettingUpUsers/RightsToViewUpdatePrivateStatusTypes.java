package requirementGroup.SettingUpUsers;

import lib.dataObject.EventSetUp_data;
import lib.dataObject.Event_data;
import lib.dataObject.Login_data;
import lib.dataObject.NotificationValues;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.Roles_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.LinksAtTopRightCorners;
import lib.module.NavigationToSubMenus;
import lib.page.CustomUnderView;
import lib.page.EventManagement;
import lib.page.EventSetUp;
import lib.page.EventStatus;
import lib.page.Login;
import lib.page.Map;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.Roles;
import lib.page.SelectRegion;
import lib.page.StatusChangePreference;
import lib.page.StatusTypeList;
import lib.page.UsersList;
import lib.page.Views;
import lib.page.ViewsList;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class RightsToViewUpdatePrivateStatusTypes extends TestNG_UI_EXTENSIONS {

	public RightsToViewUpdatePrivateStatusTypes() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**************************************************************************************************
	'Description :  Provide a user the ‘View Resource’ right on resource RS and verify that a private 
	                status type associated with RS can be added to the custom view only if the user has
	                 any of the resource rights on resource RS.
	'Date	 	 : 20-July-2015
	'Author		 : Sangappa.k
	'--------------------------------------------------------------------------------------------------
	'Modified Date			                        	                      Modified By
	'Date					                                                  Name
	****************************************************************************************************/
	@Test(description = " Provide a user the ‘View Resource’ right on resource RS and verify that a private"
			+ " status type associated with RS can be added to the custom view only if the user has any of the"
			+ " resource rights on resource RS.")
	public void testHappyDay45738() throws Exception {

		gstrTCID = "45738";
		gstrTO = " Provide a user the ‘View Resource’ right on resource RS and verify that a private status type "
				+ "associated with RS can be added to the custom view only if the user has any of the resource "
				+ "rights on resource RS.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		Roles_data objRolesData = new Roles_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		NotificationValues objNotificationValues = new NotificationValues();
		View_data objView_data = new View_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		StatusChangePreference objStatusChangePreference = new StatusChangePreference(
				this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault_page1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);
		Map objMap1= new Map(driver1);
		LinksAtTopRightCorners objAtTopRightCorners1=new LinksAtTopRightCorners(this.driver1);
		OfficeCommonFunctions objOfficeCommonFunctions=new OfficeCommonFunctions();
		
		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;
	
		
		String strStatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		
		String[]	strResName={objResource_data.strResourceName};
		
		boolean blnTest = false;
		

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToViews();

		objViewsList.clickOncustomizeResourceDetailView()
				.enterSectionName(objView_data.strSectionName)
				.clickOnCreateSection()
				.verCreatedSection(objView_data.strSectionName)
				.clickOnSaveButton();

		objNavigationToSubMenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		String[] strstatusTypeValues1 = { strStatusTypeValues[0] };
		String[] strstatusTypeValues2 = { strStatusTypeValues[1] };
		
		String[] strStatusTypeNames={objStatuTypes_data.strNSTStatusTypeName,objStatuTypes_data.strTSTStatusTypeName};
		System.out.println(objStatuTypes_data.strNSTStatusTypeName);
		System.out.println(objStatuTypes_data.strTSTStatusTypeName);
		

		// Resource type creation
		objResourceType.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strstatusTypeValues1);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);
		System.out.println(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource.navigateToResourceListPage()

		.createResourceWithAddress(objResource_data.strResourceName,
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
		
		System.out.println(objResource_data.strResourceName);

		objResource
				.clickOnStatusTypeLinkInResourcePage(
						objResource_data.strResourceName)
				.selectStatusType(strstatusTypeValues2).clickOnSaveButton();
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectViewcustomViewOption().clickSaveButton();

		System.out.println(objUser_data.strNewUserName1);

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName2,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectViewcustomViewOption().clickSaveButton();

		System.out.println(objUser_data.strNewUserName2);

		objUsersList

				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName3,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectViewcustomViewOption().clickSaveButton();

		System.out.println(objUser_data.strNewUserName3);

		objUsersList

				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName4,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectViewcustomViewOption().clickSaveButton();

		System.out.println(objUser_data.strNewUserName4);

		// login user creation
		objUsersList

				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectConfigureRegionalUserAccessOption()
				.selectViewcustomViewOption().clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		objLogin.clickLogOut();

		// Login as User

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault_page1.selectFrame();

		objnNavigationToSubMenus1.navigateToUsers();

		objUsersList1
				.enterUsernameInSearchInputField(objUser_data.strNewUserName1)
				.clickSearchButton()
				.editUserDetails(objUser_data.strNewUserName1)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickSaveButton();

		objUsersList1
				.enterUsernameInSearchInputField(objUser_data.strNewUserName2)
				.clickSearchButton()
				.editUserDetails(objUser_data.strNewUserName2)
				.selectRunReportRight(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickSaveButton();

		objUsersList1
				.enterUsernameInSearchInputField(objUser_data.strNewUserName3)
				.clickSearchButton()
				.editUserDetails(objUser_data.strNewUserName3)
				.selectAssosciateResourceRight(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickSaveButton();

		objUsersList1
				.enterUsernameInSearchInputField(objUser_data.strNewUserName4)
				.clickSearchButton()
				.editUserDetails(objUser_data.strNewUserName4)
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickSaveButton();

		// Login as User1

		objLogin1.loginAsNewUser(objUser_data.strNewUserName1,
				objUser_data.strNewPassword);

		objRegionDefault_page1.selectFrame();

		objnNavigationToSubMenus1.navigateToCustomizedViewInPrefrences();

		objCustomUnderView1
				.clickOnAddMoreResources()

				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch()
				.selectResource(strResourceValue)
				.clickOnAddToCustomView()
				.clickOnOptions()
				.selectStatusTypes(strStatusTypeValues)
				.clickOnSave()

				.verResourceAndResTypeInCustomViewTablePage(strResName,
						objResourceType_data.strResourceTypeName)
				.verStatusTypeInCustomViewTablePage(strStatusTypeNames);

		objAtTopRightCorners1.clickOnShowMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verResourceNameInPopupWindow(objResource_data.strResourceName)
				.verStatusTypesInPopupWindow(strStatusTypeNames);
		objLogin1.clickLogOut();

		// Login as User2

		objLogin1.loginAsNewUser(objUser_data.strNewUserName2,
				objUser_data.strNewPassword);

		objRegionDefault_page1.selectFrame();

		objnNavigationToSubMenus1.navigateToCustomizedViewInPrefrences();

		objCustomUnderView1.clickOnAddMoreResources()

		.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch().selectResource(strResourceValue)
				.clickOnAddToCustomView().clickOnOptions()
				.selectStatusTypes(strStatusTypeValues).clickOnSave();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verResourceNameInPopupWindow(objResource_data.strResourceName)
				.verStatusTypesInPopupWindow(strStatusTypeNames);

		objAtTopRightCorners1.clickOnShowTable();

		objCustomUnderView1.verResourceAndResTypeInCustomViewTablePage(
				strResName, objResourceType_data.strResourceTypeName)
				.verStatusTypeInCustomViewTablePage(strStatusTypeNames);

		objLogin1.clickLogOut();

		// Login as User3

		objLogin1.loginAsNewUser(objUser_data.strNewUserName3,
				objUser_data.strNewPassword);

		objRegionDefault_page1.selectFrame();

		Thread.sleep(10000);

		objnNavigationToSubMenus1.navigateToCustomizedViewInPrefrences();

		objCustomUnderView1
				.clickOnAddMoreResources()

				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch()
				.selectResource(strResourceValue)
				.clickOnAddToCustomView()
				.clickOnOptions()
				.selectStatusTypes(strStatusTypeValues)
				.clickOnSave()
				.verResourceAndResTypeInCustomViewTablePage(strResName,
						objResourceType_data.strResourceTypeName)
				.verStatusTypeInCustomViewTablePage(strStatusTypeNames);

		objAtTopRightCorners1.clickOnShowMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verResourceNameInPopupWindow(objResource_data.strResourceName)
				.verStatusTypesInPopupWindow(strStatusTypeNames);
		objLogin1.clickLogOut();

		// Login as User4

		objLogin1.loginAsNewUser(objUser_data.strNewUserName4,
				objUser_data.strNewPassword);

		objRegionDefault_page1.selectFrame();

		objnNavigationToSubMenus1.navigateToCustomizedViewInPrefrences();

		objCustomUnderView1.clickOnAddMoreResources()

		.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch().selectResource(strResourceValue)
				.clickOnAddToCustomView().clickOnOptions()
				.verSTNotDisplayedInOptions(strStatusTypeValues).clickOnSave();
		objAtTopRightCorners1.clickOnShowTable();
		objCustomUnderView1
				.verResourceAndResTypeNotDisplayedInCustomViewTablePage(
						strResName, objResourceType_data.strResourceTypeName);
		objLogin1.clickLogOut();

		blnTest = true;

		if (blnTest) {

			String[] strTestData = {
					gstrTCID,
					Login_data.strBuildName,
					objUser_data.strNewUserName + "/"
							+ objUser_data.strNewPassword + ","
							+ objTest_data.strUserName + ","
							+ objTest_data.strRegionName,
					objUser_data.strNewUserName1,
					objUser_data.strNewUserName2,
					objUser_data.strNewUserName3,
					objUser_data.strNewUserName4,
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatuTypes_data.strNSTStatusTypeName + ","
							+ objStatuTypes_data.strTSTStatusTypeName + ", "
							+ objView_data.strSectionName };

			objOfficeCommonFunctions.writeResultData(strTestData,
					strPartialAutoResultsPath, "MobileTestData");

			gstrResult = "PASS";

		}

	}


	
	/**************************************************************************************************
	'Description :  Provide a user the ‘View Resource’ right on resource RS and verify that a private 
	                status type associated with RS can be added to the custom view only if the user has
	                 any of the resource rights on resource RS.
	'Date	 	 : 20-July-2015
	'Author		 : Anil
	'--------------------------------------------------------------------------------------------------
	'Modified Date			                        	                      Modified By
	'Date					                                                  Name
	****************************************************************************************************/
	@Test(description = "Verify that when the resource rights are removed for a user, the user cannot view a private status type for the respective resource. ")
	public void testHappyDay48405() throws Exception {

		gstrTCID = "48405";
		gstrTO = "Verify that when the resource rights are removed for a user, the user cannot view a private status type for the respective resource. ";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		CustomUnderView objCustomUnderView = new CustomUnderView(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault_page1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		Map objMap1=new Map(this.driver1);
		Views objViews1= new Views(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		
		LinksAtTopRightCorners objAtTopRightCorners1=new LinksAtTopRightCorners(this.driver1);
		OfficeCommonFunctions objOfficeCommonFunctions=new OfficeCommonFunctions();
		
		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;
	
		String strStatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToViews();

		objViewsList.clickOncustomizeResourceDetailView()
				.enterSectionName(objView_data.strSectionName)
				.clickOnCreateSection()
				.verCreatedSection(objView_data.strSectionName)
				.clickOnSaveButton();

		objNavigationToSubMenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		String[] strstatusTypeValues1 = { strStatusTypeValues[0] };
		String[] strstatusTypeValues2 = { strStatusTypeValues[1] };
		
		String[] strStatusTypeNames={objStatuTypes_data.strNSTStatusTypeName,objStatuTypes_data.strTSTStatusTypeName};
		System.out.println(objStatuTypes_data.strNSTStatusTypeName);
		System.out.println(objStatuTypes_data.strTSTStatusTypeName);
		

		// Resource type creation
		objResourceType.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strstatusTypeValues1);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);
		System.out.println(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource.navigateToResourceListPage()

		.createResourceWithAddress(objResource_data.strResourceName,
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
		
		System.out.println(objResource_data.strResourceName);

		objResource
				.clickOnStatusTypeLinkInResourcePage(
						objResource_data.strResourceName)
				.selectStatusType(strstatusTypeValues2).clickOnSaveButton();
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectViewcustomViewOption().clickSaveButton();

		System.out.println(objUser_data.strNewUserName1);

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName2,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectRunReportRight(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectViewcustomViewOption().clickSaveButton();

		System.out.println(objUser_data.strNewUserName2);

		objUsersList

				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName3,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectAssosciateResourceRight(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectViewcustomViewOption().clickSaveButton();

		System.out.println(objUser_data.strNewUserName3);
		// login user creation
		objUsersList

				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectConfigureRegionalUserAccessOption()
				.selectViewcustomViewOption().clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		objUsersList
		.clickCreateNewUserButton()
		.enterUserDetails(objUser_data.strNewUserName4,
				objUser_data.strNewPassword, objUser_data.strFullName4)
		.selectFirstRole()
		.clickAdvancedOptionAndExpand()
		.selectMaintainEventsOption().clickSaveButton();
		
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(
				objESetUp_data.strEventTemplate,
				objESetUp_data.strTemplateDefinition, strResourceTypeValue,
				strStatusTypeValues);
		objEventSetUp.deselectSelectAllWebOption();
		
		objNavigationToSubMenus.navigateToViews();
		
		objViewsList.createView(objView_data.strViewName,
				objView_data.strViewDesc, objResource_data.strResourceName,
				strStatusTypeNames);

		objLogin.clickLogOut();
		
		objLogin.loginAsNewUser(objUser_data.strNewUserName4,
				objUser_data.strNewPassword);
		
		objRegionDefault.selectFrame();
		
		objEventManagement.navigateToEventManagement();
		objEventManagement.clickOnCreateNewEvent();
		objEventManagement.clickOnCreateEvent(objESetUp_data.strEventTemplate);
		objEventManagement.enterAdHocEventName(
				objEvent_data.strEventName).enterAdHocEventDescription(
				objEvent_data.strEventDescription)
		.selectResource(strResourceValue)
		.clickOnSaveButton()
		.verifyEventName(objEvent_data.strEventName);
		
		objLogin.clickLogOut();
		// Login as User1

		objLogin.loginAsNewUser(objUser_data.strNewUserName1,
				objUser_data.strNewPassword);
		
		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToCustomizedViewInPrefrences();

		objCustomUnderView
				.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch()
				.selectResource(strResourceValue)
				.clickOnAddToCustomView()
				.clickOnOptions()
				.selectStatusTypes(strStatusTypeValues)
				.clickOnSave();

		objLogin.clickLogOut();

		// Login as User2


		objLogin.loginAsNewUser(objUser_data.strNewUserName2,
				objUser_data.strNewPassword);
		
		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToCustomizedViewInPrefrences();

		objCustomUnderView
				.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch()
				.selectResource(strResourceValue)
				.clickOnAddToCustomView()
				.clickOnOptions()
				.selectStatusTypes(strStatusTypeValues)
				.clickOnSave();

		objLogin.clickLogOut();

		// Login as User3

		objLogin.loginAsNewUser(objUser_data.strNewUserName3,
				objUser_data.strNewPassword);
		
		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToCustomizedViewInPrefrences();

		objCustomUnderView
				.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch()
				.selectResource(strResourceValue)
				.clickOnAddToCustomView()
				.clickOnOptions()
				.selectStatusTypes(strStatusTypeValues)
				.clickOnSave();

		objLogin.clickLogOut();
		
		// Login as User

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault_page1.selectFrame();

		objnNavigationToSubMenus1.navigateToUsers();

		objUsersList1
				.enterUsernameInSearchInputField(objUser_data.strNewUserName1)
				.clickSearchButton()
				.editUserDetails(objUser_data.strNewUserName1)
				.deselectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickSaveButton();

		objUsersList1
				.enterUsernameInSearchInputField(objUser_data.strNewUserName2)
				.clickSearchButton()
				.editUserDetails(objUser_data.strNewUserName2)
				.deselectRunReportRight(objResource_data.strResourceName)
				.clickSaveButton();

		objUsersList1
				.enterUsernameInSearchInputField(objUser_data.strNewUserName3)
				.clickSearchButton()
				.editUserDetails(objUser_data.strNewUserName3)
				.deselectAssociatedRightCheckBox(objResource_data.strResourceName)
				.clickSaveButton();

		objLogin1.clickLogOut();	
		
		objLogin1.loginToApplication(objUser_data.strNewUserName1, objUser_data.strNewPassword);
		
		objRegionDefault_page1.selectFrame();
		
		objnNavigationToSubMenus1
		.navigateToParticularViewUnderViewMenu(objView_data.strViewName);
		
		objViews1.vererrorMsgInViewPage();
				
		objnNavigationToSubMenus1.navigateToMap();
		
		objMap1.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);
		objMap1.verResourceNameInPopupWindow(objResource_data.strResourceName);

		objMap1.verStatusTypesNotInPopupWindow(strStatusTypeNames);
		objMap1.clickOnViewInfoInPopupWindow();
		
		for (int i = 0; i < strStatusTypeNames.length; i++) {
			objViews1.verStatusTypesNotUnderSection(
					strStatusTypeNames[i],
					objView_data.strSectionName);
			}
		
		objEventManagement1.clickOnEventNameInEventBanner(objEvent_data.strEventName);
		
		objEventStatus1.verifyMessageDisplayed();

		objnNavigationToSubMenus1.navigateToCustomInView();
	
		objViews1.vererrorMsgInCustomView();
		objAtTopRightCorners1.clickOnShowMap();
		objMap1.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName)
			   .verStatusTypesNotInPopupWindow(strStatusTypeNames);
		objAtTopRightCorners1.clickOnShowTable();
		objLogin1.clickLogOut();
		
		objLogin1.loginToApplication(objUser_data.strNewUserName2, objUser_data.strNewPassword);
		
		objRegionDefault_page1.selectFrame();
		
		objnNavigationToSubMenus1
		.navigateToParticularViewUnderViewMenu(objView_data.strViewName);
		
		objViews1.vererrorMsgInViewPage();
				
		objnNavigationToSubMenus1.navigateToMap();
		
		objMap1.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);
		objMap1.verResourceNameInPopupWindow(objResource_data.strResourceName);

		objMap1.verStatusTypesNotInPopupWindow(strStatusTypeNames);
		objMap1.clickOnViewInfoInPopupWindow();
		
		for (int i = 0; i < strStatusTypeNames.length; i++) {
			objViews1.verStatusTypesNotUnderSection(
					strStatusTypeNames[i],
					objView_data.strSectionName);
			}
		
		objEventManagement1.clickOnEventNameInEventBanner(objEvent_data.strEventName);
		
		objEventStatus1.verifyMessageDisplayed();

		objnNavigationToSubMenus1.navigateToCustomInView();
	
		objViews1.vererrorMsgInCustomView();
		objAtTopRightCorners1.clickOnShowMap();
		objMap1.verResourceNameInPopupWindow(objResource_data.strResourceName);

		objMap1.verStatusTypesNotInPopupWindow(strStatusTypeNames);
		objAtTopRightCorners1.clickOnShowTable();
		objLogin1.clickLogOut();
	
		objLogin1.loginToApplication(objUser_data.strNewUserName3, objUser_data.strNewPassword);
		
		objRegionDefault_page1.selectFrame();
		
		objnNavigationToSubMenus1
		.navigateToParticularViewUnderViewMenu(objView_data.strViewName);
		
		objViews1.vererrorMsgInViewPage();
				
		objnNavigationToSubMenus1.navigateToMap();
		
		objMap1.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);
		objMap1.verResourceNameInPopupWindow(objResource_data.strResourceName);

		objMap1.verStatusTypesNotInPopupWindow(strStatusTypeNames);
		objMap1.clickOnViewInfoInPopupWindow();
		
		for (int i = 0; i < strStatusTypeNames.length; i++) {
			objViews1.verStatusTypesNotUnderSection(
					strStatusTypeNames[i],
					objView_data.strSectionName);
			}
		
		objEventManagement1.clickOnEventNameInEventBanner(objEvent_data.strEventName);
		
		objEventStatus1.verifyMessageDisplayed();
		objnNavigationToSubMenus1.navigateToCustomInView();

		objViews1.vererrorMsgInCustomView();
		objAtTopRightCorners1.clickOnShowMap();
		objMap1.verResourceNameInPopupWindow(objResource_data.strResourceName);

		objMap1.verStatusTypesNotInPopupWindow(strStatusTypeNames);
		objAtTopRightCorners1.clickOnShowTable();
		objLogin1.clickLogOut();

			String[] strTestData = {
					gstrTCID,objTest_data.strRegionName,
					objUser_data.strNewUserName1+","+
					objUser_data.strNewUserName2+","+
					objUser_data.strNewUserName3+"/"+objUser_data.strNewPassword,
					objStatuTypes_data.strNSTStatusTypeName + ","
							+ objStatuTypes_data.strTSTStatusTypeName,
					objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName,
					 objView_data.strViewName+", "+objView_data.strSectionName };

			objOfficeCommonFunctions.writeResultData(strTestData,
					strPartialAutoResultsPath, "MobileTestData");

			gstrResult = "PASS";

	}

	/**************************************************************************************************
	'Description :   Provide a user the ‘View Resource’ right on resource RS and verify that for a private status type associated with RS, status change preferences can be set if the user has any of the resource rights on resource RS.
	'Date	 	 : 20-July-2015
	'Author		 : Anil
	'--------------------------------------------------------------------------------------------------
	'Modified Date			                        	                      Modified By
	'Date					                                                  Name
	****************************************************************************************************/
	@Test(description = " Provide a user the ‘View Resource’ right on resource RS and verify that for a private status type associated with RS, status change preferences can be set if the user has any of the resource rights on resource RS.")
	public void testHappyDay98661() throws Exception {

		gstrTCID = "98661";
		gstrTO = " Provide a user the ‘View Resource’ right on resource RS and verify that for a private status type associated with RS, status change preferences can be set if the user has any of the resource rights on resource RS.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault_page1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		StatusChangePreference objStatusChangePreference1 = new StatusChangePreference(
				this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
	
		String strStatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strStatusesValues[] = new String[1];

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToViews();

		objViewsList.clickOncustomizeResourceDetailView()
				.enterSectionName(objView_data.strSectionName)
				.clickOnCreateSection()
				.verCreatedSection(objView_data.strSectionName)
				.clickOnSaveButton();

		objNavigationToSubMenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		objStatusTypeList.createNewStatus(objStatuTypes_data.strStatusNameInMulti,
				objStatuTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatuTypes_data.strStatusNameInMulti);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti);

		objStatusTypeList.createNewStatus(objStatuTypes_data.strStatusNameInMulti1,
				      objStatuTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
				      objStatuTypes_data.strStatusNameInMulti1)
				.clickOnReturnToStatusTypeList();
		
		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		String[] strstatusTypeValues1 = { strStatusTypeValues[0] };
		String[] strstatusTypeValues2 = { strStatusTypeValues[1] };

		System.out.println(objStatuTypes_data.strMSTStatusTypeName);
		System.out.println(objStatuTypes_data.strTSTStatusTypeName);
		

		// Resource type creation
		objResourceType.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strstatusTypeValues1);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);
		System.out.println(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource.navigateToResourceListPage()

		.createResourceWithAddress(objResource_data.strResourceName,
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
		
		System.out.println(objResource_data.strResourceName);

		objResource
				.clickOnStatusTypeLinkInResourcePage(
						objResource_data.strResourceName)
				.selectStatusType(strstatusTypeValues2).clickOnSaveButton();
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.deselectAllViewResReightOption()
				.clickAdvancedOptionAndExpand()
				.selectEditStatusChangeNotPrefernceOption().clickSaveButton();

		System.out.println(objUser_data.strNewUserName1);

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName2,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.deselectAllViewResReightOption()
				.clickAdvancedOptionAndExpand()
				.selectEditStatusChangeNotPrefernceOption().clickSaveButton();

		System.out.println(objUser_data.strNewUserName2);

		objUsersList

				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName3,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.deselectAllViewResReightOption()
				.clickAdvancedOptionAndExpand()
				.selectEditStatusChangeNotPrefernceOption().clickSaveButton();

		System.out.println(objUser_data.strNewUserName3);
		
		objUsersList

		.clickCreateNewUserButton()
		.enterUserDetails(objUser_data.strNewUserName4,
				objUser_data.strNewPassword, objUser_data.strFullName)
		.selectFirstRole()
		.deselectAllViewResReightOption()
		.clickAdvancedOptionAndExpand()
		.selectEditStatusChangeNotPrefernceOption().clickSaveButton();

System.out.println(objUser_data.strNewUserName4);
		// login user creation
		objUsersList

				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectConfigureRegionalUserAccessOption()
				.selectViewcustomViewOption().clickSaveButton();

		System.out.println(objUser_data.strNewUserName);
		objLogin.clickLogOut();
		
		// Login as User

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault_page1.selectFrame();

		objnNavigationToSubMenus1.navigateToUsers();

		objUsersList1
				.enterUsernameInSearchInputField(objUser_data.strNewUserName1)
				.clickSearchButton()
				.editUserDetails(objUser_data.strNewUserName1)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickSaveButton();

		objUsersList1
				.enterUsernameInSearchInputField(objUser_data.strNewUserName2)
				.clickSearchButton()
				.editUserDetails(objUser_data.strNewUserName2)
				.selectRunReportRight(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickSaveButton();

		objUsersList1
				.enterUsernameInSearchInputField(objUser_data.strNewUserName3)
				.clickSearchButton()
				.editUserDetails(objUser_data.strNewUserName3)
				.selectAssosciateResourceRight(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickSaveButton();

		objUsersList1
		.enterUsernameInSearchInputField(objUser_data.strNewUserName4)
		.clickSearchButton()
		.editUserDetails(objUser_data.strNewUserName4)
		.selectViewResourceRights(objResource_data.strResourceName)
		.clickSaveButton();
		
		objLogin1.clickLogOut();	
		
		objLogin1.loginAsNewUser(objUser_data.strNewUserName1, objUser_data.strNewPassword);
		
		objRegionDefault_page1.selectFrame();
			
		objnNavigationToSubMenus1.navigateStatusChangeInPreferences();
		
		objStatusChangePreference1
		.verMyStatusChangePreferncePgeDisplayed()
		.clickOnAdd()
		.enterResNameInWhatField(objResource_data.strResourceName)
		.clickOnSearch()
		.verResourceDisplayedInFindResScreen(
						objResource_data.strResourceName)
		.selectResource(strResourceValue[0]).clickOnNotifications()
							.verEditMyStatusChangePrefPgeDisplayed()
				.expandUncategorizedSec();
		objStatusChangePreference1.verifyRTAndRS(objResourceType_data.strResourceTypeName, objResource_data.strResourceName);
		String[] strStatausTypesNames = {
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName };

		for (int i = 0; i < strStatausTypesNames.length; i++) {
			objStatusChangePreference1
					.verStatusTypesUnderUncategorizedSec(strStatausTypesNames[i]);
		}

		objStatusChangePreference1
				.selEmailWebPagerChkBoxForStatuses(strResourceValue[0],
						strStatusTypeValues[0], strStatusesValues[0])
				.selEmailPagerWebChkBoxes(strResourceValue[0],
						strStatusTypeValues[1])
				.clickOnSave();

		for (int i = 0; i < strStatausTypesNames.length; i++) {
			objStatusChangePreference1.verStatusTypeNotification(strStatausTypesNames[i]);
		}
			
		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName2, objUser_data.strNewPassword);
		
		objRegionDefault_page1.selectFrame();
			
		objnNavigationToSubMenus1.navigateStatusChangeInPreferences();
		
		objStatusChangePreference1
		.verMyStatusChangePreferncePgeDisplayed()
		.clickOnAdd()
		.enterResNameInWhatField(objResource_data.strResourceName)
		.clickOnSearch()
		.verResourceDisplayedInFindResScreen(
						objResource_data.strResourceName)
		.selectResource(strResourceValue[0]).clickOnNotifications()
							.verEditMyStatusChangePrefPgeDisplayed()
				.expandUncategorizedSec();
		objStatusChangePreference1.verifyRTAndRS(objResourceType_data.strResourceTypeName, objResource_data.strResourceName);
		for (int i = 0; i < strStatausTypesNames.length; i++) {
			objStatusChangePreference1
					.verStatusTypesUnderUncategorizedSec(strStatausTypesNames[i]);
		}

		objStatusChangePreference1
				.selEmailWebPagerChkBoxForStatuses(strResourceValue[0],
						strStatusTypeValues[0], strStatusesValues[0])
				.selEmailPagerWebChkBoxes(strResourceValue[0],
						strStatusTypeValues[1])
				.clickOnSave();

		for (int i = 0; i < strStatausTypesNames.length; i++) {
			objStatusChangePreference1.verStatusTypeNotification(strStatausTypesNames[i]);
		}
			
		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUser_data.strNewUserName3, objUser_data.strNewPassword);
		
		objRegionDefault_page1.selectFrame();
			
		objnNavigationToSubMenus1.navigateStatusChangeInPreferences();
		
		objStatusChangePreference1
		.verMyStatusChangePreferncePgeDisplayed()
		.clickOnAdd()
		.enterResNameInWhatField(objResource_data.strResourceName)
		.clickOnSearch()
		.verResourceDisplayedInFindResScreen(
						objResource_data.strResourceName)
		.selectResource(strResourceValue[0]).clickOnNotifications()
							.verEditMyStatusChangePrefPgeDisplayed()
				.expandUncategorizedSec();
		objStatusChangePreference1.verifyRTAndRS(objResourceType_data.strResourceTypeName, objResource_data.strResourceName);

		for (int i = 0; i < strStatausTypesNames.length; i++) {
			objStatusChangePreference1
					.verStatusTypesUnderUncategorizedSec(strStatausTypesNames[i]);
		}

		objStatusChangePreference1
				.selEmailWebPagerChkBoxForStatuses(strResourceValue[0],
						strStatusTypeValues[0], strStatusesValues[0])
				.selEmailPagerWebChkBoxes(strResourceValue[0],
						strStatusTypeValues[1])
				.clickOnSave();

		for (int i = 0; i < strStatausTypesNames.length; i++) {
			objStatusChangePreference1.verStatusTypeNotification(strStatausTypesNames[i]);
		}
			
		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUser_data.strNewUserName4, objUser_data.strNewPassword);
		
		objRegionDefault_page1.selectFrame();
			
		objnNavigationToSubMenus1.navigateStatusChangeInPreferences();
		
		objStatusChangePreference1
		.verMyStatusChangePreferncePgeDisplayed()
		.clickOnAdd()
		.enterResNameInWhatField(objResource_data.strResourceName)
		.clickOnSearch()
		.verResourceDisplayedInFindResScreen(
						objResource_data.strResourceName)
		.selectResource(strResourceValue[0]).clickOnNotifications();

		objStatusChangePreference1.verifyRTAndRS(objResourceType_data.strResourceTypeName, objResource_data.strResourceName)
				.verifyNoVisibilityMessage();
		objLogin1.clickLogOut();
			gstrResult = "PASS";

	}


}

