package requirementGroup.SmokeTestSuite;

import static org.testng.AssertJUnit.assertTrue;
import lib.dataObject.*;
import lib.module.LinksAtTopRightCorners;
import lib.module.NavigationToSubMenus;
import lib.page.*;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class SmokeResourceHierarchies extends TestNG_UI_EXTENSIONS {

	public SmokeResourceHierarchies() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/*******************************************************************************************
	'Description : Verify that user can create a sub resource type.
	'Precondition:
	'Date	 	 : 12-Sep-2014
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(enabled=false,description = "Verify that user can create a sub resource type.")
	public void testSmoke109209() throws Exception {
		gstrTCID = "109209";
		gstrTO = "Verify that user can create a sub resource type.";

		Login_data objTest_data = new Login_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		
		String strStatusTypeValues[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		ResourceType objResourceType1 = new ResourceType(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion
				.selectRegionAndNavigate(objTest_data.strQuickLinkRegion);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList()

		.createStatusType(objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		RegionDefault_page1.selectFrame();

		objSelectRegion1
				.selectRegionAndNavigate(objTest_data.strQuickLinkRegion);

		RegionDefault_page1.selectFrame();

		objNavigationToSubMenus1.navigateToResourceTypesInSetup();

		objResourceType1.createResourceType(objResourceType_data.strResourceTypeName, strStatusTypeValues)
						.clickOnEditLinkOfResourceType(objResourceType_data.strResourceTypeName)
						.enterResourceTypeDescription(objResourceType_data.strResTypeDescription)
						.selectSubResourceTypeCheckBox()
						.clickOnSaveButton();				

		objResourceType1
				.verResourceTypeInList(objResourceType_data.strResourceTypeName)
				.verSubResourceInList(objResourceType_data.strResourceTypeName,
						objResourceType_data.strSubResStatus)
						.verActionHeader()
				.verResourceTypeDescInList(
						objResourceType_data.strResourceTypeName,
						objResourceType_data.strResTypeDescription);
		
		objLogin1.clickLogOut();
		gstrResult = "PASS";
	}
	
	/*******************************************************************************************
	'Description : Verify that user can create a sub resource.
	'Precondition:
	'Date	 	 : 22-Sep-2014
	'Author		 : Sowmya
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that user can create a sub resource.")
	public void testSmoke109210() throws Exception {
		gstrTCID = "109210";
		gstrTO = "Verify that user can create a sub resource.";

		Login_data objTest_data = new Login_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();

		ResourceType objResourceType = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		Resource objResource = new Resource(this.driver1);

		String strStatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[2];
		String strResourceValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion
				.selectRegionAndNavigate(objTest_data.strQuickLinkRegion);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList()

		.createStatusType(objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		String[] strNSTStatusTypeNames = { strStatusTypeValues[0] };
		String[] strTSTStatusTypeNames = { strStatusTypeValues[1] };

		// First resource type creation
		objResourceType.navigateToResourceTypePage()
				.createResourceType(objResourceType_data.strResourceTypeName,
						strNSTStatusTypeNames);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

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

		// Second resource type creation
		objResourceType.navigateToResourceTypePage()
		               .createSubResourceType(
				objResourceType_data.strResourceTypeName1,
				strTSTStatusTypeNames);

		strResourceTypeValue[1] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName1);

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegion1
				.selectRegionAndNavigate(objTest_data.strQuickLinkRegion);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToResourceInSetup();

		objResource1
				.verifyEditLink(objResource_data.strResourceName)
				.verifyStatusTypeLink(objResource_data.strResourceName)
				.verifyUsersLink(objResource_data.strResourceName)
				.verifySubResourcesLink(objResource_data.strResourceName)
				.verifyDemoteLink(objResource_data.strResourceName)
				.clickOnSubResourcesLink(objResource_data.strResourceName)
				.verSubResourceListPageIsDisplayed(
						objResource_data.strResourceName);

		objResource1
				.clickOnCreateNewSubResourceButton()
				
				//Create New Sub-Resource' screen is displayed
				.enterResourceName(objResource_data.strSubResourceName)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strResourceTypeName1)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton();

		objResource1.verSubResourceInResourceListPage(objResource_data.strSubResourceName);

		objUsersList1.navigateToUsersNew()
		             .clickCreateNewUserButton();
		
		objUsersList1.verResourceNameIsNotPresent(objResource_data.strSubResourceName);

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/*******************************************************************************************
	'Description : Verify that sub-resources can be added to the resource detail view.
	'Precondition:
	'Date	 	 : 23-Sep-2014
	'Author		 : Sowmya
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that sub-resources can be added to the resource detail view.")
	public void testSmoke129447() throws Exception {
		gstrTCID = "129447";
		gstrTO = "Verify that sub-resources can be added to the resource detail view.";

		Login_data objTest_data = new Login_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		Roles_data objRoles_data = new Roles_data();
		User_data objUser_data = new User_data();

		ResourceType objResourceType = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		Resource objResource = new Resource(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);

		String strstatusTypeValues[] = new String[6];
		String strstatusTypeValues1[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strSubResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strSubResourceValue[] = new String[1];
		String strRoleValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Views objViews1 = new Views(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion
				.selectRegionAndNavigate(objTest_data.strQuickLinkRegion);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		objStatusTypeList.navigateToStatusTypeListNew();

		// create status types
		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		objStatusTypeList.navigateToStatusTypeListNew();

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strDateStatusType,
				objStatuTypes_data.strDateStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strDateStatusTypeName);

		// Other statusTypes
		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName1);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues1[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName1);

		// Create Resource Type
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Create Sub-Resource Type
		objResourceType
				.navigateToResourceTypePage()
				.createResourceType(objResourceType_data.strResourceTypeName1,
						strstatusTypeValues1)
				.clickOnEditLinkOfResourceType(
						objResourceType_data.strResourceTypeName1)
				.enterResourceTypeDescription(
						objResourceType_data.strResTypeDescription)
				.selectSubResourceTypeCheckBox().clickOnSaveButton();

		strSubResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName1);

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
						objResourceType_data.strResourceTypeName1,
						objResource_data.strStandardResourceTypename,
						objResource_data.strResourceFirstName,
						objResource_data.strResourceLastName);

		strSubResourceValue[0] = objResource
				.getSubResourceValue(objResource_data.strSubResourceName);

		// Create role
		objNavigationToSubMenus.navigateToRoles();

		objRoles.createRole(objRoles_data.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRoles_data.strRoleName);

		// create view
		String[] strStatusTypeNames = {
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strDateStatusTypeName };

		objNavigationToSubMenus.navigateToViews();

//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);
//
//		for (int i = 0; i < strStatusTypeNames.length; i++) {
//
//			objViewsList.selectStatusType(strStatusTypeNames[i]);
//		}
//
//		objViewsList.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();

		objViewsList.createView(objView_data.strViewName,
				objView_data.strViewDesc, objResource_data.strResourceName,
				strStatusTypeNames);

		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionViewsOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption);

		System.out.println(objUser_data.strNewUserName);

		objLogin.clickLogOut();

		System.out.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViews1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int i = 0; i < strStatusTypeNames.length; i++) {

			objViews1.verStatusTypes(objResourceType_data.strResourceTypeName,
					strStatusTypeNames[i]);
		}

		objViews1
				.clickOnResource(objResource_data.strResourceName)
				.verResourceScreenDisplayed(objResource_data.strResourceName)
				.verStatusTypesUnderSection(
						objStatuTypes_data.strNSTStatusTypeName,
						objView_data.strSectionName)
				.verStatusTypesUnderSection(
						objStatuTypes_data.strMSTStatusTypeName,
						objView_data.strSectionName)
				.verStatusTypesUnderSection(
						objStatuTypes_data.strSSTStatusTypeName,
						objView_data.strSectionName)
				.verStatusTypesUnderSection(
						objStatuTypes_data.strTSTStatusTypeName,
						objView_data.strSectionName)
				.verStatusTypesUnderSection(
						objStatuTypes_data.strNDSTStatusTypeName,
						objView_data.strSectionName)
				.verStatusTypesUnderSection(
						objStatuTypes_data.strDateStatusTypeName,
						objView_data.strSectionName);

		objViews1.verSubResourcesSectionIsNotDisplayed();

		objNavigationToSubMenus1.navigateToViews();

		objViewsList1.clickOncustomizeResourceDetailView()
				.verEditResourceDetailViewSectionsPageIsDisplayed()
				.verifySaveButton().verifyCancelButton()
				.verifySubResourceButton().verifySortAllButton()
				.clickSubResourceButton()
				.verEditSubResourceDetailViewSectionsPageIsDisplayed();

		objViewsList1
				.clickOnSubResourceTypeName(
						objResourceType_data.strResourceTypeName1)
				.selectSubResourceTypeCheckBox(strSubResourceTypeValue[0])
				.selectSubResourceCheckBox(strstatusTypeValues1[0])
				.verSubResourceTypeNameIsNotPresentInEditSubResPage(
						objResourceType_data.strResourceTypeName)
				.clickOnSaveButton().verRegionViewListPageIsDisplayed();

		objNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViews1
				.clickOnResource(objResource_data.strResourceName)
				.verViewResourceDetailsPgeIsDisplayed()
				.verStatusTypesUnderSection(
						objStatuTypes_data.strNSTStatusTypeName,
						objView_data.strSectionName)
				.verStatusTypesUnderSection(
						objStatuTypes_data.strMSTStatusTypeName,
						objView_data.strSectionName)
				.verStatusTypesUnderSection(
						objStatuTypes_data.strSSTStatusTypeName,
						objView_data.strSectionName)
				.verStatusTypesUnderSection(
						objStatuTypes_data.strTSTStatusTypeName,
						objView_data.strSectionName)
				.verStatusTypesUnderSection(
						objStatuTypes_data.strNDSTStatusTypeName,
						objView_data.strSectionName)
				.verStatusTypesUnderSection(
						objStatuTypes_data.strDateStatusTypeName,
						objView_data.strSectionName);

		objViews1
				.verSubResourcesSectionIsDisplayed()
				.verResourceTypeAndResourceNameInViewResDetailPage(
						objResourceType_data.strResourceTypeName1,
						objResource_data.strSubResourceName)
				.verUpdateStatusKeyInViewResDetailPage(
						objResource_data.strSubResourceName);

		objViews1
				.clickOnResource(objResource_data.strSubResourceName)
				.verViewResourceDetailsPgeIsDisplayed()
				.verStatusTypesUnderSection(
						objStatuTypes_data.strNSTStatusTypeName1,
						objView_data.strSectionName)
				.verStatusTypesUnderSection(
						objStatuTypes_data.strTSTStatusTypeName1,
						objView_data.strSectionName).clickOnCustomizeLink();

		objViewsList1.clickSubResourceButton();

		objViewsList1
				.verEditSubResourceDetailViewSectionsPageIsDisplayed()
				.clickOnSubResourceTypeName(
						objResourceType_data.strResourceTypeName1)
				.verSubResourceTypeCheckBoxIsSelected(
						strSubResourceTypeValue[0])
				.verSubResourceCheckBoxIsSelected(strstatusTypeValues1[0])
				.verSubResourceCheckBoxIsNotSelected(strstatusTypeValues1[1]);

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/*******************************************************************************************
	'Description : Verify that user can set status change preferences for status types associated with a sub resource.
	'Precondition:
	'Date	 	 : 23-Sep-2014
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that user can set status change preferences for status types associated with a sub resource.")
	public void testSmoke109212() throws Exception {
		gstrTCID = "109212";
		gstrTO = "Verify that user can set status change preferences for status types associated with a sub resource.";

		Login_data objTest_data = new Login_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		Login objLogin = new Login(this.driver1);
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		View_data objView_data = new View_data();
		ViewsList objViewsList = new ViewsList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource_data objResource_data = new Resource_data();
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NotificationValues objNotificationValues = new NotificationValues();
		Date_Time_settings dts = new Date_Time_settings();

		String strStatusTypeValues[] = new String[3];
		String strStatusTypeValues2[] = new String[3];
		String strStatusesValues[] = new String[1];
		String strResourceTypeValue[] = new String[2];
		String strResourceValue[] = new String[2];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault_page1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Views objViews1 = new Views(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		StatusChangePreference objStatusChangePreference = new StatusChangePreference(
				this.driver1);

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion
				.selectRegionAndNavigate(objTest_data.strQuickLinkRegion);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList()

		.createStatusType(objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti, objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues2[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName1);

		objStatusTypeList
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName1,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1, objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues2[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName1);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues2[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName1);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objResourceType.createResourceType(
				objResourceType_data.strSubResourceTypeName,
				strStatusTypeValues2);

		strResourceTypeValue[1] = objResourceType
				.getResourceTypeValue(objResourceType_data.strSubResourceTypeName);

		objResourceType
				.clickOnEditLinkOfResourceType(
						objResourceType_data.strSubResourceTypeName)
				.selectSubResourceTypeCheckBox().clickOnSaveButton();

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource
				.clickOnCreateNewResourceButton()
				.enterResourceName(objResource_data.strResourceName)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strResourceTypeName)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton().clickOnViewResChkBox().clickOnSaveButton();

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objResource.clickOnSubResourcesLink(objResource_data.strResourceName)
				.clickOnCreateNewSubResourceButton()
				.enterResourceName(objResource_data.strResourceName1)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strSubResourceTypeName)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton()
				.verSubResourceInResourceListPage(
						objResource_data.strResourceName1);

		strResourceValue[1] = objResource
				.getSubResourceValue(objResource_data.strResourceName1);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId).selectFirstRole()
				//.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionViewsOption()
				.selectEditStatusChangeNotPrefernceOption().clickSaveButton();

		objNavigationToSubmenus.navigateToViews();

		String[] strStatausTypesNames = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName };

//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);
//
//		for (int i = 0; i < strStatausTypesNames.length; i++) {
//
//			objViewsList.selectStatusType(strStatausTypesNames[i]);
//		}

		objViewsList
//				.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView()
				.createView(objView_data.strViewName, objView_data.strViewDesc,
						objResource_data.strResourceName, strStatausTypesNames)
				.verViewInList(objView_data.strViewName)
				.clickOncustomizeResourceDetailView()
				.clickSubResourceButton()
				.clickOnSubResourceTypeName(
						objResourceType_data.strSubResourceTypeName)
				.selectSubResourceTypeCheckBox(strResourceTypeValue[1]);

		for (int i = 0; i < strStatusTypeValues2.length; i++) {

			objViewsList.selectSubResourceCheckBox(strStatusTypeValues2[i]);
		}

		objViewsList.clickOnSaveButton();

		objLogin.clickLogOut();
		
		System.out.println(objUserdata.strNewUserName);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault_page1.selectFrame();

		objNavigationToSubMenus1.navigateStatusChangeInPreferences();

		String strResAndSubRes = objResource_data.strResourceName + ": "
				+ objResource_data.strResourceName1;

		String[] strStatausTypesNames2 = {
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strMSTStatusTypeName1,
				objStatusTypes_data.strSSTStatusTypeName1 };

		objStatusChangePreference
				.verMyStatusChangePreferncePgeDisplayed()
				.clickOnAdd()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch()
				.verResourceDisplayedInFindResScreen(
						objResource_data.strResourceName)
				.verResourceDisplayedInFindResScreen(strResAndSubRes)
				.selectResource(strResourceValue[1])
				.clickOnNotifications()
				.verEditMyStatusChangePrefPgeDisplayed()
				.verSubRTAndResSubResIsDisplayedAsSubHeader(
						objResourceType_data.strSubResourceTypeName,
						objResource_data.strResourceName,
						objResource_data.strResourceName1)
				.expandUncategorizedSec();

		for (int i = 0; i < strStatausTypesNames2.length; i++) {
			objStatusChangePreference
					.verStatusTypesUnderUncategorizedSec(strStatausTypesNames2[i]);
		}

		objStatusChangePreference
				.enterAboveValues(strResourceValue[1], strStatusTypeValues2[0],
						objNotificationValues.strAboveVal)
				.enterBelowValues(strResourceValue[1], strStatusTypeValues2[0],
						objNotificationValues.strBelowVal)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(strResourceValue[1],
						strStatusTypeValues2[0])
				.enterAboveValues(strResourceValue[1], strStatusTypeValues2[2],
						objNotificationValues.strAboveVal)
				.enterBelowValues(strResourceValue[1], strStatusTypeValues2[2],
						objNotificationValues.strBelowVal)
				.selEmailPagerWebChkBoxesForAboveAndBelowVal(strResourceValue[1],
						strStatusTypeValues2[2]).clickOnSave();

		objNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViews1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int i = 0; i < strStatausTypesNames.length; i++) {
			objViews1.verStatusTypes(objResourceType_data.strResourceTypeName,
					strStatausTypesNames[i]);
		}

		objViews1.clickOnResource(objResource_data.strResourceName);

		objViewsList1
				.clickOnUpdateStatusOfSubResource(objResource_data.strResourceName1);

		objUpdateStatus1
				.clickOnSelectAll()
				.selectMSTUpdateValue(strStatusTypeValues2[1],
						strStatusesValues[0])
				.enterNSTAndTSTUpdateValue(strStatusTypeValues2[0],
						objView_data.strAboveValueForUpdate)
				.enterUpdateSSTValues(strStatusTypeValues2[2],
						objView_data.strValueForSST).clickOnSaveButton();
		
		String strFetchAppDateTime = objEventManagement1.getApplicationTime();
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strAppTime = strFetchAppDateTime.split(" ");

		String strUpdatedTime = dts.converDateFormat(strAppTime[0]
				+ strAppTime[1] + strCurYear + " " + strAppTime[2],
				"ddMMMyyyy HH:mm", "dd MMM yyyy HH:mm");
		
		System.out.println(strUpdatedTime);

		String[] strStatausTypesNames2InWebNot = {
				objStatusTypes_data.strSSTStatusTypeName1,
				objStatusTypes_data.strNSTStatusTypeName1 };

		String[] strUpdatedVlaues = { objView_data.strUpdatedValForSST,
				objView_data.strAboveValueForUpdate };

		objUpdateStatus1.verWebNotificationframe();
		
		for (int i = 0; i < strStatausTypesNames2InWebNot.length; i++) {
			objUpdateStatus1
					.verWebNotificationForStatusUpdateOfAboveAndBeowValForSubRes(
							objResource_data.strResourceName,
							objResource_data.strResourceName1,
							strStatausTypesNames2InWebNot[i],
							strUpdatedVlaues[i], strUpdatedTime);
		}
		objUpdateStatus1.clickAcknowledgeAllNotifications().selectFrame();

		objLogin1.clickLogOut();

		String strSubject = "Status Change for "
				+ objResource_data.strResourceName + ": "
				+ objResource_data.strResourceName1 + "";
		String strSubjectForPager = "Change for "
				+ objResource_data.strResourceAbbrivation;

		String strMsgBody1 = "Status Update for " + objUserdata.strFullName
				+ ":" + "\nOn " + strUpdatedTime + " " + strResAndSubRes + " "
				+ "changed " + objStatusTypes_data.strSSTStatusTypeName1
				+ " status from 0 " + "to " + objView_data.strUpdatedValForSST
				+ ".\n\nComments:\n\nReasons:\n\nRegion: " + ""
				+ objTest_data.strQuickLinkRegion
				+ "\n\n\n\nPlease do not reply to this email message."
				+ " You must log into EMResource to take any action that may"
				+ " be required.";

		String strMsgBody2 = objStatusTypes_data.strSSTStatusTypeName1
				+ " from 0 to " + objView_data.strUpdatedValForSST + "; "
				+ "Reasons:\nSummary at " + strUpdatedTime + "\n"
				+ "Region: " + objTest_data.strQuickLinkRegion + "";

		String strMsgBody3 = "Status Update for " + objUserdata.strFullName
				+ ":" + "\nOn " + strUpdatedTime + " " + strResAndSubRes + " "
				+ "changed " + objStatusTypes_data.strNSTStatusTypeName1
				+ " status from 0 " + "to "
				+ objView_data.strAboveValueForUpdate
				+ ".\n\nComments:\n\nReasons:\n\nRegion: " + ""
				+ objTest_data.strQuickLinkRegion
				+ "\n\n\n\nPlease do not reply to this email message."
				+ " You must log into EMResource to take any action that may"
				+ " be required.";

		String strMsgBody4 = objStatusTypes_data.strNSTStatusTypeName1
				+ " from 0 to " + objView_data.strAboveValueForUpdate + "; "
				+ "Reasons:\nSummary at " + strUpdatedTime + "\n"
				+ "Region: " + objTest_data.strQuickLinkRegion + "";
		
		System.out.println(strMsgBody1);
		System.out.println(strMsgBody2);
		System.out.println(strMsgBody3);
		System.out.println(strMsgBody4);

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;
		boolean blnMsg3 = false;
		boolean blnMsg4 = false;

		for (int intCount = 0; intCount < 4; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubject);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody1);
			}

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody3);
			}
			objMailVerificationFunctions.backToMailInbox();
		}

		assertTrue(blnMsg1 && blnMsg2);

		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubjectForPager);

			if (blnMsg3 == false) {
				blnMsg3 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody2);
			}

			if (blnMsg4 == false) {
				blnMsg4 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody4);
			}
			objMailVerificationFunctions.backToMailInbox();
		}

		assertTrue(blnMsg3 && blnMsg4);

		objMailVerificationFunctions.logoutMail();

		gstrResult = "PASS";
	}
	
	/*******************************************************************************************
	'Description : Verify that user with appropriate right and update right on a resource can 
	               create /edit sub-resources for their facility
	'Precondition:
	'Date	 	 : 24-Sep-2014
	'Author		 : Sowmya
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(enabled=false,description = "Verify that user with appropriate right and update right on a resource can"
			+ " create /edit sub-resources for their facility")
	public void testSmoke122711() throws Exception {
		gstrTCID = "122711";
		gstrTO = "Verify that user with appropriate right and update right on a resource can "
				+ "create /edit sub-resources for their facility";

		Login_data objTest_data = new Login_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		Roles_data objRoles_data = new Roles_data();
		User_data objUser_data = new User_data();

		ResourceType objResourceType = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		Resource objResource = new Resource(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);

		String strstatusTypeValues[] = new String[3];
		String strstatusTypeValues1[] = new String[3];
		String strResourceTypeValue[] = new String[1];
		String strSubResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[2];
		String strRoleValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Views objViews1 = new Views(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion
				.selectRegionAndNavigate(objTest_data.strQuickLinkRegion);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

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

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		objStatusTypeList.navigateToStatusTypeListNew();

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		
		strstatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues1[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strDateStatusType,
				objStatuTypes_data.strDateStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues1[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strDateStatusTypeName);

		// Create Resource Type
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Create Sub-Resource Type
		objResourceType
				.navigateToResourceTypePage()
				.createResourceType(
						objResourceType_data.strSubResourceTypeName,
						strstatusTypeValues1)
				.clickOnEditLinkOfResourceType(
						objResourceType_data.strSubResourceTypeName)
				.enterResourceTypeDescription(
						objResourceType_data.strResTypeDescription)
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

		// Resource creation
		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[1] = objResource
				.getResourceValue(objResource_data.strResourceName1);

		// Create role
		objNavigationToSubMenus.navigateToRoles();

		objRoles.createRole(objRoles_data.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRoles_data.strRoleName);

		// create view
		String[] strStatusTypeNames = {
						objStatuTypes_data.strNSTStatusTypeName,
						objStatuTypes_data.strTSTStatusTypeName,
						objStatuTypes_data.strMSTStatusTypeName },
				strAllResources = {objResource_data.strResourceName,
						objResource_data.strResourceName1 };
		
		objNavigationToSubMenus.navigateToViews();

//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);
//
//		for (int i = 0; i < strStatusTypeNames.length; i++) {
//
//			objViewsList.selectStatusType(strStatusTypeNames[i]);
//		}
//
//		objViewsList.selectResource(objResource_data.strResourceName)
//				.selectResource(objResource_data.strResourceName1)
//				.clickOnSaveOfCreateNewView();

		objViewsList.createViewForMultipleResourcesAndStatusTypes(
				objView_data.strViewName, objView_data.strViewDesc,
				strAllResources, strStatusTypeNames);
		
		// User-1 creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName1)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectEditResourcesOnlyOption()
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		// User-2 creation
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName1)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName1)
				.clickAdvancedOptionAndExpand().selectSetupResourceOption()
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName1);

		// User-3 creation
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName2,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName1)
				.clickAdvancedOptionAndExpand().selectSetupResourceOption()
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName2);

		// User-4 creation
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName3,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName1)
				.clickAdvancedOptionAndExpand().selectEditResourcesOnlyOption()
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName3);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objResource1
				.navigateToResourceListPageNew()
				.verResourceInList(objResource_data.strResourceName)
				.verResourceNotInList(objResource_data.strResourceName1)
				.clickOnSubResourcesLink(objResource_data.strResourceName)
				.verSubResourceListPageIsDisplayed(
						objResource_data.strResourceName)
				.clickOnCreateNewSubResourceButton()
				.verCreateNewSubResourceForPageIsDisplayed(
						objResource_data.strResourceName)
				.enterResourceName(objResource_data.strSubResourceName)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strSubResourceTypeName)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton()
				.verSubResourceListPageIsDisplayed(
						objResource_data.strResourceName);

		objResource1
				.navigateToResourceListPage()
				.verSubResources1LinkInResourceList(
						objResource_data.strResourceName)
				.clickOnSubResources1LinkInResourceList(
						objResource_data.strResourceName)
				.clickOnEditLinkInSubResourceListPage(
						objResource_data.strSubResourceName)
				.verEditSubResourceOfPageIsDisplayed(
						objResource_data.strResourceName)
				.enterResourceName(objResource_data.strSubResourceName1)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation1)
				.clickOnSaveButton()
				.verSubResourceListPageIsDisplayed(
						objResource_data.strResourceName)
				.verSubResourceInResourceListPage(
						objResource_data.strSubResourceName1);

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName1,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objResource1
				.navigateToResourceListPageNew()
				.verResourceInList(objResource_data.strResourceName)
				.verResourceInList(objResource_data.strResourceName1)
				.clickOnSubResourcesLink(objResource_data.strResourceName1)
				.verSubResourceListPageIsDisplayed(
						objResource_data.strResourceName1);

		objNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViews1.clickOnResource(objResource_data.strResourceName1)
				.verViewResourceDetailsPgeIsDisplayed()
				.verifyCreateNewSubResourceBtnUnderSubResourceSection();

		objResource1
				.clickOnCreateNewSubResourceButton()
				.verCreateNewSubResourceForPageIsDisplayed(
						objResource_data.strResourceName1)
				.enterResourceName(objResource_data.strSubResourceName1)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strSubResourceTypeName)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton();

		objViews1.verViewResourceDetailsPgeIsDisplayed();

		objResource1
				.navigateToResourceListPageNew()
				.verSubResources1LinkInResourceList(
						objResource_data.strResourceName)
				.clickOnSubResources1LinkInResourceList(
						objResource_data.strResourceName)
				.clickOnEditLinkInSubResourceListPage(
						objResource_data.strSubResourceName1)
				.verEditSubResourceOfPageIsDisplayed(
						objResource_data.strResourceName)
				.enterResourceName(objResource_data.strSubResourceName)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation1)
				.clickOnSaveButton()
				.verSubResourceListPageIsDisplayed(
						objResource_data.strResourceName)
				.verSubResourceInResourceListPage(
						objResource_data.strSubResourceName);

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName2,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objResource1
				.navigateToResourceListPageNew()
				.verResourceInList(objResource_data.strResourceName)
				.verResourceInList(objResource_data.strResourceName1)
				.verifyEditLink(objResource_data.strResourceName)
				.verifyEditLink(objResource_data.strResourceName1)
				.verSubResources1LinkInResourceList(
						objResource_data.strResourceName)
				.verSubResources1LinkInResourceList(
						objResource_data.strResourceName1)
				.clickOnSubResources1LinkInResourceList(
						objResource_data.strResourceName)
				.verSubResourceListPageIsDisplayed(
						objResource_data.strResourceName)
				.verEditLinkInSubResourceListPage(
						objResource_data.strSubResourceName)
				.verCreateNewSubResourceButtonIsPresent();

		objResource1
				.navigateToResourceListPage()
				.clickOnSubResources1LinkInResourceList(
						objResource_data.strResourceName1)
				.verSubResourceListPageIsDisplayed(
						objResource_data.strResourceName1)
				.verEditLinkInSubResourceListPage(
						objResource_data.strSubResourceName1)
				.verCreateNewSubResourceButtonIsPresent();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName3,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objResource1.navigateToResourceListPageNew()
				.verResourceNotInList(objResource_data.strResourceName)
				.verResourceNotInList(objResource_data.strResourceName1);

		objNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViews1.clickOnResource(objResource_data.strResourceName);

		objResource1.verCreateNewSubResourceButtonIsNotPresent();

		objNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViews1.clickOnResource(objResource_data.strResourceName1);

		objResource1.verCreateNewSubResourceButtonIsNotPresent();

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/*******************************************************************************************
	'Description : Verify that user provided with appropriate right in a role and with update status
	               right on a resource can create/edit a sub-resource under it.
	'Precondition:
	'Date	 	 : 25-Sep-2014
	'Author		 : Sowmya
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(enabled=false,description = "Verify that user provided with appropriate right in a role and with update status "
			+ "right on a resource can create/edit a sub-resource under it.")
	public void testSmoke122712() throws Exception {
		gstrTCID = "122712";
		gstrTO = "Verify that user provided with appropriate right in a role and with update status"
				+ " right on a resource can create/edit a sub-resource under it.";

		Login_data objTest_data = new Login_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		Roles_data objRoles_data = new Roles_data();
		User_data objUser_data = new User_data();

		ResourceType objResourceType = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		Resource objResource = new Resource(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);

		String strstatusTypeValues[] = new String[3];
		String strstatusTypeValues1[] = new String[3];
		String strResourceTypeValue[] = new String[1];
		String strSubResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[2];
		String strRoleValue[] = new String[3];

		Login objLogin1 = new Login(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Views objViews1 = new Views(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion
				.selectRegionAndNavigate(objTest_data.strQuickLinkRegion);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

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

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		objStatusTypeList.navigateToStatusTypeListNew();

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		//
		strstatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues1[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strDateStatusType,
				objStatuTypes_data.strDateStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues1[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strDateStatusTypeName);

		// Create Resource Type
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Create Sub-Resource Type
		objResourceType
				.navigateToResourceTypePage()
				.createResourceType(
						objResourceType_data.strSubResourceTypeName,
						strstatusTypeValues1)
				.clickOnEditLinkOfResourceType(
						objResourceType_data.strSubResourceTypeName)
				.enterResourceTypeDescription(
						objResourceType_data.strResTypeDescription)
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

		// Resource creation
		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[1] = objResource
				.getResourceValue(objResource_data.strResourceName1);

		// Create role With Edit right
		objNavigationToSubMenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn().enterRoleName(
				objRoles_data.strRoleName1);

		objUsersList.selectEditResourcesOnlyOption();

		objRoles.clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRoles_data.strRoleName1);

		// Create role with setup right
		objNavigationToSubMenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn().enterRoleName(
				objRoles_data.strRoleName2);

		objUsersList.selectSetupResourceOption();

		objRoles.clickOnSaveBtn();

		strRoleValue[1] = objRoles.getRoleValue(objRoles_data.strRoleName2);

		// Create role
		objNavigationToSubMenus.navigateToRoles();

		objRoles.createRole(objRoles_data.strRoleName);

		strRoleValue[2] = objRoles.getRoleValue(objRoles_data.strRoleName);

		// create view
		String[] strStatusTypeNames = {
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strMSTStatusTypeName },
				 strAllResources = {objResource_data.strResourceName, objResource_data.strResourceName1 };

		objNavigationToSubMenus.navigateToViews();

//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);
//
//		for (int i = 0; i < strStatusTypeNames.length; i++) {
//
//			objViewsList.selectStatusType(strStatusTypeNames[i]);
//		}
//
//		objViewsList.selectResource(objResource_data.strResourceName)
//				.selectResource(objResource_data.strResourceName1)
//				.clickOnSaveOfCreateNewView();

		objViewsList.createViewForMultipleResourcesAndStatusTypes(
				objView_data.strViewName, objView_data.strViewDesc,
				strAllResources, strStatusTypeNames);
		
		String[] strRoleValu1 = { strRoleValue[0] };
		String[] strRoleValu2 = { strRoleValue[1] };
		String[] strRoleValu = { strRoleValue[2] };

		// User-1 creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValu1)
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName1)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		// User-2 creation
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValu2)
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName1)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName1)
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName1);

		// User-3 creation
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName2,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValu)
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName1)
				.clickAdvancedOptionAndExpand().selectSetupResourceOption()
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName2);

		// User-4 creation
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName3,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValu)
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName1)
				.clickAdvancedOptionAndExpand().selectEditResourcesOnlyOption()
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName3);

		objLogin.clickLogOut();

		System.out.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objResource1
				.navigateToResourceListPageNew()
				.verResourceInList(objResource_data.strResourceName)
				.verResourceNotInList(objResource_data.strResourceName1)
				.clickOnSubResourcesLink(objResource_data.strResourceName)
				.verSubResourceListPageIsDisplayed(
						objResource_data.strResourceName)
				.clickOnCreateNewSubResourceButton()
				.verCreateNewSubResourceForPageIsDisplayed(
						objResource_data.strResourceName)
				.enterResourceName(objResource_data.strSubResourceName)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strSubResourceTypeName)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton()
				.verSubResourceListPageIsDisplayed(
						objResource_data.strResourceName);

		objResource1
				.navigateToResourceListPage()
				.verSubResources1LinkInResourceList(
						objResource_data.strResourceName)
				.clickOnSubResources1LinkInResourceList(
						objResource_data.strResourceName)
				.clickOnEditLinkInSubResourceListPage(
						objResource_data.strSubResourceName)
				.verEditSubResourceOfPageIsDisplayed(
						objResource_data.strResourceName)
				.enterResourceName(objResource_data.strSubResourceName1)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation1)
				.clickOnSaveButton()
				.verSubResourceListPageIsDisplayed(
						objResource_data.strResourceName)
				.verSubResourceInResourceListPage(
						objResource_data.strSubResourceName1);

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName1,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objResource1
				.navigateToResourceListPageNew()
				.verResourceInList(objResource_data.strResourceName)
				.verResourceInList(objResource_data.strResourceName1)
				.clickOnSubResourcesLink(objResource_data.strResourceName1)
				.verSubResourceListPageIsDisplayed(
						objResource_data.strResourceName1);

		objNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViews1.clickOnResource(objResource_data.strResourceName1)
				.verViewResourceDetailsPgeIsDisplayed()
				.verifyCreateNewSubResourceBtnUnderSubResourceSection();

		objResource1
				.clickOnCreateNewSubResourceButton()
				.verCreateNewSubResourceForPageIsDisplayed(
						objResource_data.strResourceName1)
				.enterResourceName(objResource_data.strSubResourceName1)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strSubResourceTypeName)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton();

		objViews1.verViewResourceDetailsPgeIsDisplayed();

		objResource1
				.navigateToResourceListPageNew()
				.verSubResources1LinkInResourceList(
						objResource_data.strResourceName)
				.clickOnSubResources1LinkInResourceList(
						objResource_data.strResourceName)
				.clickOnEditLinkInSubResourceListPage(
						objResource_data.strSubResourceName1)
				.verEditSubResourceOfPageIsDisplayed(
						objResource_data.strResourceName)
				.enterResourceName(objResource_data.strSubResourceName)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation1)
				.clickOnSaveButton()
				.verSubResourceListPageIsDisplayed(
						objResource_data.strResourceName)
				.verSubResourceInResourceListPage(
						objResource_data.strSubResourceName);

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName2,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objResource1
				.navigateToResourceListPageNew()
				.verResourceInList(objResource_data.strResourceName)
				.verResourceInList(objResource_data.strResourceName1)
				.verifyEditLink(objResource_data.strResourceName)
				.verifyEditLink(objResource_data.strResourceName1)
				.verSubResources1LinkInResourceList(
						objResource_data.strResourceName)
				.verSubResources1LinkInResourceList(
						objResource_data.strResourceName1)
				.clickOnSubResources1LinkInResourceList(
						objResource_data.strResourceName)
				.verSubResourceListPageIsDisplayed(
						objResource_data.strResourceName)
				.verEditLinkInSubResourceListPage(
						objResource_data.strSubResourceName)
				.verCreateNewSubResourceButtonIsPresent();

		objResource1
				.navigateToResourceListPage()
				.clickOnSubResources1LinkInResourceList(
						objResource_data.strResourceName1)
				.verSubResourceListPageIsDisplayed(
						objResource_data.strResourceName1)
				.verEditLinkInSubResourceListPage(
						objResource_data.strSubResourceName1)
				.verCreateNewSubResourceButtonIsPresent();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName3,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objResource1.navigateToResourceListPageNew()
				.verResourceNotInList(objResource_data.strResourceName)
				.verResourceNotInList(objResource_data.strResourceName1);

		objNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViews1.clickOnResource(objResource_data.strResourceName);

		objResource1.verCreateNewSubResourceButtonIsNotPresent();

		objNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViews1.clickOnResource(objResource_data.strResourceName1);

		objResource1.verCreateNewSubResourceButtonIsNotPresent();

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Verify that RegAdmin can demote a resource to be a sub resource of another resource..
	'Precondition: 
	'Date : 22-Sep-2014 
	'Author : Prasanna Lakshmi
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(enabled=false,description = "Verify that RegAdmin can demote a resource to be a sub resource of another resource")
	public void testSmoke109211() throws Exception {

		gstrTCID = "109211";
		gstrTO = "Verify that RegAdmin can demote a resource to be a sub resource of another resource";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		String strStatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[2];
		String strResourceValue[] = new String[2];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName2);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();
		String strStatusTypeArray[] = { strStatusTypeValues[0] };

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeArray);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource
				.clickOnCreateNewResourceButton()
				.enterResourceName(objResource_data.strResourceName)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strResourceTypeName)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton().clickOnViewResChkBox().clickOnSaveButton();

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objResource
				.clickOnCreateNewResourceButton()
				.enterResourceName(objResource_data.strResourceName1)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strResourceTypeName)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton().clickOnViewResChkBox().clickOnSaveButton();

		strResourceValue[1] = objResource
				.getResourceValue(objResource_data.strResourceName1);
		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName1, strStatusTypeArray);

		strResourceTypeValue[1] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName1);
		objResourceType
				.clickOnEditLinkOfResourceType(objResourceType_data.strResourceTypeName1);

		objResourceType.selectSubResourceTypeCheckBox();
		objResource.clickOnSaveButton();
		objNavigationToSubmenus.navigateToUsers();
		objUsersList.clickCreateNewUserButton();

		objUsersList
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickSaveButton();
		objLogin.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);
		objRegionDefault1.selectFrame();
		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName2);

		objRegionDefault1.selectFrame();
		objNavigationToSubmenus1.navigateToResourceInSetup();
		objResource1
				.clickOnDemoteLink(objResource_data.strResourceName)
				.selectResourceTypename(
						objResourceType_data.strResourceTypeName1)
				.clickOnChkBoxForResource(objResource_data.strResourceName1)
				.clickOnSaveButton()
				.verResourceInNotInList(objResource_data.strResourceName)
				.clickOnSubResourcesLink(objResource_data.strResourceName1)
				.verSubResourceListPageisDisplayed(
						objResource_data.strResourceName1)
				.verSubResourceinSubResPage(objResource_data.strResourceName);
		objNavigationToSubmenus1.navigateToUsers();
		objUsersList1
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName)
				.verResourceNameNotDispalyed(objResource_data.strResourceName)
				.verResourceName(objResource_data.strResourceName1);
		
		gstrResult = "PASS";
	}
	
	
	/*************************************************************************************
	'Description 	:Verify that sub resources created are not listed on the following screens
						1. Region view
	    				2. Custom view
						3. Map view
						4. Create/Edit Event
	'Precondition	: None
	'Date		 	: 23-Sep-2014 
	'Author 		: Prasanna Lakshmi
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test( description = "Verify that sub resources created are not listed on the following screens")
	public void testSmoke109214() throws Exception {

		gstrTCID = "109214";
		gstrTO = "Verify that sub resources created are not listed on the following screens";

		ResourceType objResourceType = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		Resource objResource = new Resource(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		Roles_data objRolesData = new Roles_data();
		UsersList objUsersList = new UsersList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objViewData = new View_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUserdata = new User_data();
		EventSetUp_data objEventSetUpdata = new EventSetUp_data();
		Event_data objEventdata = new Event_data();
		EventManagement objEventManagement = new EventManagement(this.driver1);
		EventSetUp ObjEventSetUp = new EventSetUp(this.driver1);
		CustomUnderView ObjCustomUnderView = new CustomUnderView(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Views ObjViews1 = new Views(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(
				this.driver1);
		Map objMap1 = new Map(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);

		String strstatusTypeValues[] = new String[6];
		String strstatusTypeValues1[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strSubResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strSubResourceValue[] = new String[1];
		String strRoleValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegion
				.selectRegionAndNavigate(objLogindata.strQuickLinkRegion);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToViews();

		objViewsList.createNewSection(objViewData.strSectionName);

		objStatusTypeList.navigateToStatusTypeListNew();

		// create status types

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objViewData.strSectionName);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objViewData.strSectionName);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objViewData.strSectionName);

		objStatusTypeList.navigateToStatusTypeListNew();

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objViewData.strSectionName);

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objViewData.strSectionName);

		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		/*
		 * objStatusTypeList.createStatusTypeWithSection(
		 * objStatusTypes_data.strDateStatusType,
		 * objStatusTypes_data.strDateStatusTypeName,
		 * objStatusTypes_data.strStatusDescription,
		 * objViewData.strSectionName);
		 * 
		 * strstatusTypeValues[5] = objStatusTypeList
		 * .getStatusValue(objStatusTypes_data.strDateStatusTypeName);
		 */

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objViewData.strSectionName);

		strstatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		// Other statusTypes

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objViewData.strSectionName);

		strstatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName1);
		System.out.println(strstatusTypeValues1[0]);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objViewData.strSectionName);

		strstatusTypeValues1[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName1);
		System.out.println(strstatusTypeValues1[1]);

		// Create Resource Type
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Create Sub-Resource Type
		objResourceType
				.navigateToResourceTypePage()
				.createResourceType(objResourceType_data.strResourceTypeName1,
						strstatusTypeValues1)
				.clickOnEditLinkOfResourceType(
						objResourceType_data.strResourceTypeName1)
				.enterResourceTypeDescription(
						objResourceType_data.strResTypeDescription)
				.selectSubResourceTypeCheckBox().clickOnSaveButton();

		strSubResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName1);

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

		// Sub-Resource creation
		objResource.clickOnSubResourcesLink(objResource_data.strResourceName)
				.createSubResourceForResource(
						objResource_data.strSubResourceName,
						objResource_data.strResourceAbbrivation,
						objResourceType_data.strResourceTypeName1,
						objResource_data.strStandardResourceTypename,
						objResource_data.strResourceFirstName,
						objResource_data.strResourceLastName);

		strSubResourceValue[0] = objResource
				.getSubResourceValue(objResource_data.strSubResourceName);

		// Create role
		objNavigationToSubMenus.navigateToRoles();

		objRoles.createRole(objRolesData.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);

		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionViewsOption()
				.selectViewcustomViewOption()
				.selectMaintainEventsOption()
				.clickSaveButton()
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption);

		objUsersList
		.clickCreateNewUserButton()
		.enterUserDetails(objUserdata.strNewUserName1,
				objUserdata.strNewPassword, objUserdata.strFullName1)
		.selectRoleCheckBox(strRoleValue)
		.clickAdvancedOptionAndExpand()
		.selectMaintainEventsOption()
		.clickSaveButton();;
		
		System.out.println(objUserdata.strNewUserName);

		ObjEventSetUp.navigateToEventSetUp();

		ObjEventSetUp.createEventTemplate(objEventSetUpdata.strEventTemplate,
				objEventSetUpdata.strTemplateDefinition, strResourceTypeValue,
				strstatusTypeValues);


		objNavigationToSubMenus.navigateToViews();

		// create view
		String[] strStatusTypeNames = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strDateStatusTypeName };

		objNavigationToSubMenus.navigateToViews();

//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objViewData.strViewName)
//				.enterViewDesc(objViewData.strViewDesc);
//
//		for (int i = 0; i < strStatusTypeNames.length; i++) {
//
//			objViewsList.selectStatusType(strStatusTypeNames[i]);
//		}
//
//		objViewsList.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();
		
		objViewsList.createView(objViewData.strViewName,
				objViewData.strViewDesc, objResource_data.strResourceName,
				strStatusTypeNames);
		
		objLogin.clickLogOut();

		objLogin.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault.selectFrame();
		
		objEventManagement.navigateToEventManagement()
		.clickOnCreateNewEvent()
		.clickOnCreateEvent(objEventSetUpdata.strEventTemplate)
		.enterAdHocEventName(objEventdata.strEventName)
		.enterAdHocEventDescription(objEventdata.strEventDescription)
		.selectResource(strResourceValue).clickOnSaveButton()
		.verifyEventName(objEventdata.strEventName);
		
		objLogin.clickLogOut();
		
		objLogin.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		objEventManagement.selectFrame();
		objEventManagement
				.verWebNotificationframe()
				.verWebNotificationAndAcknowledge(objEventdata.strEventName,
						objEventdata.strEventDescription)
				.clickAcknowledgeAllNotifications().selectFrame();

		// Custom View
		Thread.sleep(3000);
		objNavigationToSubMenus.navigateToCustomInView();
		String[] strResource1Val = { strResourceValue[0] };
		ObjCustomUnderView.clickOnSetupCustomViewLink()
				.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch().selectResource(strResource1Val)
				.clickOnAddToCustomView().clickOnOptions()
				.selectAllChkBoxInOptions()
				.selectStatusTypes(strstatusTypeValues).clickOnSave();

		objLogin.clickLogOut();
		// 2nd step

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToViews();
		objViewsList1.clickOncustomizeResourceDetailView();
		ObjViews1.verEditResDetailPageisDisplayed();
		
		objViewsList1.clickSubResourceButton();
		
		ObjViews1.verEditSubResDetailPageisDisplayed();
		
		objViewsList1
				.clickOnSubResourceTypeName(objResourceType_data.strResourceTypeName1)
				.selectSubResourceTypeCheckBox(strSubResourceTypeValue[0])
				.selectSubResourceCheckBox(strstatusTypeValues1[0])
				.selectSubResourceCheckBox(strstatusTypeValues1[1]);

		objResource1.clickOnSaveButton();
		
		objNavigationToSubMenus1.navigateToViews()
								.navigateToParticularViewUnderViewMenu(objViewData.strViewName);

		ObjViews1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);
		for (int j = 0; j < strStatusTypeNames.length; j++) {
			ObjViews1.verStatusTypes(objResourceType_data.strResourceTypeName,
					strStatusTypeNames[j]);
		}
		objResource1.verifySubResourceIsNotDisplayed(objResource_data.strSubResourceName);
		
		objNavigationToSubMenus1.navigateToCustomInView();

		

		ObjViews1.verResourceTypeAndResourceNameInCustomTable(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);
		for (int j = 0; j < strStatusTypeNames.length; j++) {
			ObjViews1.verStatusTypesInCustomViewTable(
					objResourceType_data.strResourceTypeName,
					strStatusTypeNames[j]);
		}
		objResource1
				.verifySubResourceIsNotDisplayed(objResource_data.strSubResourceName);
		
		objLinksAtTopRightCorners1.clickOnShowMap();
		
		objMap1.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName)
			   .verStatusTypesInPopupWindow(strStatusTypeNames);
		
		objResource1.verifySubResourceIsNotDisplayed(objResource_data.strSubResourceName);
		
		objNavigationToSubMenus1.navigateToViews()
								.navigateToMap();
		
		objMap1.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName)
			   .verStatusTypesInPopupWindow(strStatusTypeNames);	
		
		objResource1
				.verifySubResourceIsNotDisplayed(objResource_data.strSubResourceName);

		objEventManagement1.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUpdata.strEventTemplate);
		
		objResource1
				.verifySubResourceIsNotDisplayed(objResource_data.strSubResourceName);
		objEventManagement1
		
				.verifyResourceInSelectResourcePage(strResourceValue)
				.clickOnCancelButton()
				.clickOnEditLink(objEventdata.strEventName);
		objResource1.verifySubResourceIsNotDisplayed(objResource_data.strSubResourceName);
		
		objEventManagement1.verifyResourceInSelectResourcePage(strResourceValue);
		
		gstrResult = "PASS";

	}
}