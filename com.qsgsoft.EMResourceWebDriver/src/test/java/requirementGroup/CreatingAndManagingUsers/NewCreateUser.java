package requirementGroup.CreatingAndManagingUsers;

import static org.testng.Assert.*;

import java.io.File;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import lib.dataObject.EventSetUp_data;
import lib.dataObject.Event_data;
import lib.dataObject.FormConfigeration_data;
import lib.dataObject.Login_data;
import lib.dataObject.NotificationValues;
import lib.dataObject.RegionalInfo_data;
import lib.dataObject.Report_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.Roles_data;
import lib.dataObject.StatusReason_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.LinksAtTopRightCorners;
import lib.module.NavigationToSubMenus;
import lib.module.UserFunctions;
import lib.page.ActivateForms;
import lib.page.AutoIT;
import lib.page.ChangePassword;
import lib.page.CustomUnderView;
import lib.page.EventManagement;
import lib.page.EventSetUp;
import lib.page.EventStatus;
import lib.page.FormConfiguration;
import lib.page.InstantMessaging;
import lib.page.Login;
import lib.page.MailVerificationFunctions;
import lib.page.Map;
import lib.page.MyEventNotificationPreferences;
import lib.page.OtherRegions;
import lib.page.RegionDefault;
import lib.page.RegionalInfo;
import lib.page.Regions;
import lib.page.Report;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.Roles;
import lib.page.SecurityQuestion;
import lib.page.SelectRegion;
import lib.page.StatusChangePreference;
import lib.page.StatusReasonList;
import lib.page.StatusTypeList;
import lib.page.UpdateStatus;
import lib.page.UsersList;
import lib.page.Views;
import lib.page.ViewsList;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.UserDefinedFunctions.PathsProperties;
import qaframework.lib.UserDefinedFunctions.ReadAutoItProperty;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewCreateUser extends TestNG_UI_EXTENSIONS{

	public NewCreateUser() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/**********************************************************************************************
	 * 'Description : Verify that a user can be provided the right to setup User accounts.
	 * 'Date        : 02-Jun-2015
	 * 'Author      : Pallavi
	 **********************************************************************************************/

	@Test(description = "Verify that a user can be provided the right to setup User accounts.")
	public void testHappyDay66669() throws Exception {
		
		gstrTCID = "66669";
		gstrTO = "Verify that a user can be provided the right to setup User accounts.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		UsersList UsersList_page1 = new UsersList(this.driver1);
		ChangePassword objChangePassword1 = new ChangePassword(this.driver1);

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();

		// User creation
		UsersList_page.navigateToUsers();

		System.out.println(objUser_data.strNewUserName);

		UsersList_page
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName1, 
						objUser_data.strNewPassword, 
						objUser_data.strFullName1)
				.clickSaveButton()
				.verifyUserListPageIsDisplayed()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName2, 
						objUser_data.strNewPassword, 
						objUser_data.strFullName2)
				.clickSaveButton()
				.verifyUserListPageIsDisplayed()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName3, 
						objUser_data.strNewPassword, 
						objUser_data.strFullName3)
				.clickSaveButton()
				.verifyUserListPageIsDisplayed()
				.enterUsernameInSearchInputField(objUser_data.strNewUserName3)
				.clickSearchButton()
				.editUserDetails(objUser_data.strNewUserName3)
				.clickOnUserDeactivateChkBox()
				.clickSaveButton()
				.verifyWarningPage(objUser_data.strNewUserName3,
							objUser_data.strFullName3)
				.clickOnYesDeactivateThisUserBtn()
				.verifyDeactivationConfirmPage(objUser_data.strNewUserName3,
						objUser_data.strFullName3)
				.clickOnReturnToListBtn()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName, 
						objUser_data.strNewPassword, 
						objUser_data.strFullName)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionalUserAccessOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();
		
		login_page.clickLogOut();
		
		login_page1.loginAsNewUser(objUser_data.strNewUserName, 
						objUser_data.strNewPassword);
		
		RegionDefault_page1.selectFrame();
		
		UsersList_page1.navigateToUsers()
					   .clickCreateNewUserButton()
					   .enterUserDetails(objUser_data.strNewUserName4, 
									objUser_data.strNewPassword, 
									objUser_data.strFullName4)
					   .clickSaveButton()
					   .verifyUserListPageIsDisplayed()
					   .clickOnShowAllUsersIfPresent()
					   .verUserInList(objUser_data.strNewUserName4)
					   .clickOnIncludeInactiveChkBox()
					   .clickOnShowAllUsersIfPresent()
					   .verUserInList(objUser_data.strNewUserName1)
					   .editUserDetails(objUser_data.strNewUserName1)
					   .enterFullName(objUser_data.strEditedFullName1)
					   .clickSaveButton()
					   .clickOnShowAllUsersIfPresent()
					   .verFullName(objUser_data.strNewUserName1, 
							   objUser_data.strEditedFullName1)
					   .editUserDetails(objUser_data.strNewUserName2)
					   .clickOnUserDeactivateChkBox()
					   .clickSaveButton()
					   .verifyWarningPage(objUser_data.strNewUserName2,
							objUser_data.strFullName2)
					   .clickOnYesDeactivateThisUserBtn()
					   .verifyDeactivationConfirmPage(objUser_data.strNewUserName2,
							objUser_data.strFullName2)
					   .clickOnReturnToListBtn()
					   .clickOnShowAllUsersIfPresent()
					   .verifyInactiveUserIsPresent(objUser_data.strNewUserName2,
							objUser_data.strFullName2)
					   .editUserDetails(objUser_data.strNewUserName3)
					   .clickOnUserActivateChkBox()
					   .clickSaveButton()
					   .verifyReactivatedConfmMsg(objUser_data.strNewUserName3,
							objUser_data.strFullName3)
					   .clickOnReturnToListBtn()
					   .verFullName(objUser_data.strNewUserName3, 
							objUser_data.strFullName3)
					.enterUsernameInSearchInputField(objUser_data.strNewUserName1)
				.clickSearchButton()
							
					   .clickOnPasswordLink(objUser_data.strNewUserName1);
		
		objChangePassword1.switchTochangePwdFrame()
					      .verChangePwdWindow()
					      .changePassword(objUser_data.strNewPassword1, 
					    		  objUser_data.strNewPassword1)
			    		  .verPasswordStatusScreenIsDisplayedNew()
					      .clickOnClose();
		
		login_page1.clickLogOut()
				   .enterUserName(objUser_data.strNewUserName1)
				   .enterPassword(objUser_data.strNewPassword1)
				   .clickLogin()
				   .enterCurrentPassword(objUser_data.strNewPassword1)
				   .enterNewPassword(objUser_data.strNewPassword)
				   .enterConfirmPassword(objUser_data.strNewPassword)
				   .clickSubmit()
				   .verifySecurityQuestionAndAnswerPageAndClickOnCancel();
		
		RegionDefault_page1.selectFrame()
						   .verifyRegionDefaultPage();
		
		login_page1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Verify that a user can be provided the right to setup resource types. 
	'Date	 	 : 02-June-2015
	'Author		 : Anitha
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that a user can be provided the right to setup resource types.")
	public void testHappyDay66152() throws Exception {

		gstrTCID = "66152";
		gstrTO = "Verify that a user can be provided the right to setup resource types.";

		Login_data objLogindata = new Login_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		User_data objUserdata = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();

		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		StatusTypeList objStatusTypeList1 = new StatusTypeList(this.driver1);
		ResourceType objResourceType_Page1 = new ResourceType(this.driver1);

		String strStatusTypeValues[] = new String[1];

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectSetupResourceTypesOption().clickSaveButton()
				.verifyUserListPageIsDisplayed();
		System.out.println(objUserdata.strNewUserName);

		objNavigationToSubmenus1.navigateToStatusTypesInSetup();

		objStatusTypeList1.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList1
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		// Resource type creation
		objNavigationToSubmenus1.navigateToResourceTypesInSetup();

		objResourceType_Page1
				.createResourceType(objResourceType_data.strResourceTypeName,
						strStatusTypeValues)
				.verResourceTypeInList(objResourceType_data.strResourceTypeName)
				.clickOnEditLinkOfResourceType(
						objResourceType_data.strResourceTypeName)
				.enterResourceTypeName(
						objResourceType_data.strEdResourceTypeName)
				.clickOnSaveButton()
				.verResourceTypeInList(
						objResourceType_data.strEdResourceTypeName);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Verify that a Web Service user can be created.
	'Date	 	 : 02-June-2015
	'Author		 : Anitha
	'-------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that a Web Service user can be created.")
	public void testHappyDay66025() throws Exception {

		gstrTCID = "66025";
		gstrTO = "Verify that a Web Service user can be created.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		
		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName,
						objUserdata.strUserPwd, objUserdata.strFullName, "",
						"", "", "Org1", "", objUserdata.strEmail,
						objUserdata.strEmail, objUserdata.strEmail)
				.selectWebServiceChkBox().clickSaveButton()
				.verifyUserListPageIsDisplayed();
		
		System.out.println(objUserdata.strNewUserName);

		objLogin1.clickLogOut();

		objLogin1.launchEMRurl()
				.enterUserName(objUserdata.strNewUserName)
				.enterPassword(objUserdata.strUserPwd).clickLogin();

		objRegionDefault1.selectFrame();
		
		objUsersList.verSetUpPasswordIsNotPresent();

		objRegionDefault1.verifyWebServiceAccountError();
		
		objRegionDefault1.verifyErrorMessage();
		
		objRegionDefault1.clickOnClickHereLink();
		
		objLogin1.verifyUserName();
		
		objLogin1.verPasswordField();
		
		objLogin1.verLoginButton();
		
		objLogin1.enterUserName(objUserdata.strNewUserName)
		.enterPassword(objUserdata.strUserPwd).clickLogin();

		objRegionDefault1.selectFrame();
		
		objUsersList.verSetUpPasswordIsNotPresent();
				
		objRegionDefault1.verifyWebServiceAccountError();
		
		objRegionDefault1.verifyErrorMessage();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Verify that a user can be provided the right to setup status reasons. 
	'Precondition:
	'Date	 	 : 02-Jun-2015
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that a user can be provided the right to setup status reasons. ")
	public void testHappyDay66661() throws Exception {

		gstrTCID = "66661";
		gstrTO = "Verify that a user can be provided the right to setup status reasons. ";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		StatusReason_data objStatusReason_data = new StatusReason_data();

		Login objLogin = new Login(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		StatusReasonList objStatusReasonList1 = new StatusReasonList(
				this.driver1);

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectSetupStatusReasonOption().clickSaveButton()
				.verifyUserListPageIsDisplayed()
				.verifyUserListPageIsDisplayed();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToStatusReasons();

		objStatusReasonList1
				.clickOnCreateStatusReason()
				.enterReasonName(objStatusReason_data.strReasonName)
				.enterReasonDesc(objStatusReason_data.strReasonDesc)
				.enterReasonAbb(objStatusReason_data.strReasonAbb)
				.verDisplayReasonInCommentSectionOptionSelected()
				.clickOnSave()
				.verStatusReasonInList(objStatusReason_data.strReasonName,
						objStatusReason_data.strReasonAbb,
						objStatusReason_data.strReasonDesc)
				.clickOnEditStatusReason(objStatusReason_data.strReasonName)
				.verReasonFieldIsDisabled(objStatusReason_data.strReasonName)
				.enterReasonDesc(objStatusReason_data.strEditReasonDesc)
				.enterReasonAbb(objStatusReason_data.strEditReasonAbb)
				.clickOnSave()
				.verStatusReasonInList(objStatusReason_data.strReasonName,
						objStatusReason_data.strEditReasonAbb,
						objStatusReason_data.strEditReasonDesc);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Verify that a user can be provided the right to setup resource. 
	'Precondition:
	'Date	 	 : 02-Jun-2015
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that a user can be provided the right to setup resource. ")
	public void testHappyDay66155() throws Exception {

		gstrTCID = "66155";
		gstrTO = "Verify that a user can be provided the right to setup resource. ";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		View_data objView_data = new View_data();
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		Map objMap1 = new Map(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		Views objViews1 = new Views(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[3];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName2);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

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

		objResource.createResourceWithAddress(
				objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);

		strResourceValue[1] = objResource
				.getResourceValue(objResource_data.strResourceName1);

		objNavigationToSubmenus.navigateToViews();

		String[] strAllStatausTypes = { objStatusTypes_data.strNSTStatusTypeName };
		String[] strAllResourceName = { objResource_data.strResourceName,
				objResource_data.strResourceName1 };

		objViewsList.createViewForMultipleResourcesAndStatusTypes(objView_data.strViewName, objView_data.strViewDesc, strAllResourceName, strAllStatausTypes);
//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);
//
//		for (int i = 0; i < strAllStatausTypes.length; i++) {
//
//			objViewsList.selectStatusType(strAllStatausTypes[i]);
//		}
//
//		for (int i = 0; i < strAllResourceName.length; i++) {
//
//			objViewsList.selectResource(strAllResourceName[i]);
//		}
//
//		objViewsList.clickOnSaveOfCreateNewView().verViewInList(
//				objView_data.strViewName);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectSetupResourceOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToResourceInSetup();

		objResource1
				.clickOnCreateNewResourceButton()
				.enterResourceName(objResource_data.strResourceName2)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strResourceTypeName)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton();

		strResourceValue[2] = objResource1
				.getResourceValue(objResource_data.strResourceName2);

		objResource1
				.clickOnEditLinkInResourcePage(objResource_data.strResourceName)
				.enterResourceName(objResource_data.strEditedResName)
				.enterResourceAbbrivation(objResource_data.strEditedResAbb)
				.clickOnSaveButton()
				.verResourceInList(objResource_data.strEditedResName);

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1.clickOnResourceAndNavigateToResourceDetail(
				objResource_data.strEditedResName)
				.clickOnEditResourceDetailsLink();

		String str2EdResName = "2" + objResource_data.strEditedResName;
		String str2EdResAbb = "2" + objResource_data.strEditedResAbb;

		objResource1.enterResourceName(str2EdResName)
				.enterResourceAbbrivation(str2EdResAbb).clickOnSaveButton();

		objViews1.verResourceScreenDisplayed(str2EdResName);

		objNavigationToSubmenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(str2EdResName)
				.verResourceNameInPopupWindow(str2EdResName).clickOnEditInfo();

		String str3EdResName = "3" + objResource_data.strEditedResName;
		String str3EdResAbb = "3" + objResource_data.strEditedResAbb;

		objResource1.enterResourceName(str3EdResName)
				.enterResourceAbbrivation(str3EdResAbb).clickOnSaveButton();

		objMap1.selectResourceNameInFindResourceDropdown(str3EdResName)
				.verResourceNameInPopupWindow(str3EdResName);

		objNavigationToSubmenus1.navigateToResourceInSetup();

		objResource1
				.clickOnEditLinkInResourcePage(
						objResource_data.strResourceName1)
				.enterResourceName(objResource_data.strEditedResName2)
				.enterResourceAbbrivation(objResource_data.strEditedResAbb2)
				.clickOnSaveButton()
				.verResourceInList(objResource_data.strEditedResName2);

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1.clickOnResourceAndNavigateToResourceDetail(
				objResource_data.strEditedResName2)
				.clickOnEditResourceDetailsLink();

		String str4EdResName = "2" + objResource_data.strEditedResName2;
		String str4EdResAbb = "2" + objResource_data.strEditedResAbb2;

		objResource1.enterResourceName(str4EdResName)
				.enterResourceAbbrivation(str4EdResAbb).clickOnSaveButton();

		objViews1.verResourceScreenDisplayed(str4EdResName);

		objNavigationToSubmenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(str4EdResName)
				.verResourceNameInPopupWindow(str4EdResName).clickOnEditInfo();

		String str5EdResName = "3" + objResource_data.strEditedResName2;
		String str5EdResAbb = "3" + objResource_data.strEditedResAbb2;

		objResource1.enterResourceName(str5EdResName)
				.enterResourceAbbrivation(str5EdResAbb).clickOnSaveButton();

		objMap1.selectResourceNameInFindResourceDropdown(str5EdResName)
				.verResourceNameInPopupWindow(str5EdResName);

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/*********************************************************************************
	'Description : Verify that a user can be provided the right to administer other region views. 
	'Precondition:
	'Date	 	 : 03-Mar-2014
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date:12-May-2016			                        	Modified By : Sangappa K
	'Date					                            Name
	**********************************************************************************/
	@Test(description = "Verify that a user can be provided the right to administer other region views.")
	public void testHappyDay184020() throws Exception {
		gstrTCID = "184020";
		gstrTO = "Verify that a user can be provided the right to administer other region views.";
		
		Login_data objTest_data = new Login_data();
		User_data objUserdata = new User_data();
		UsersList objUsersList_page1 = new UsersList(this.driver1);
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		OtherRegions objOtherRegions = new OtherRegions(this.driver1);
		
		System.out.println("-----Precondtion execution starts------");

		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault1.selectFrame();
		
		objSelectRegion1.selectRegionAndNavigate(objTest_data.strStateWideReg);

		objRegionDefault1.selectFrame();

		objUsersList_page1
		.navigateToUsers()

		.clickCreateNewUserButton()

		.enterUserDetails(objUserdata.strNewUserName,
				objUserdata.strNewPassword, objUserdata.strFullName1)
		.selectFirstRole()
		.clickAdvancedOptionAndExpand()
		.selectadministerOtherRegionViewsOption()
		.clickSaveButton()
		.verifyUserListPageIsDisplayed();
		
		System.out.println(objUserdata.strNewUserName);

		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToOtherRegions();
		
		objOtherRegions.verifyOtherRegionListPage()
		               .selRegionToManageUsers(objTest_data.strArkansasReg)
		               .verifyOtherRegionUsersPage(objTest_data.strArkansasReg)
		               .assgnUserToRegion(objUserdata.strNewUserName) 
		               .clickOnSave();
		
		objNavigationToSubmenus1
		.navigateToOtherRegions();
		objOtherRegions.clickSharedResources();
		objOtherRegions.verifyOtherRegionSharedResourcesPage()
		.verifyResourceTable()
		.clickBackButton()
		.verifyOtherRegionListPage();
		objOtherRegions.clickSharedStatusTypes()
		.verifyOtherRegionSharedStatusTypePage()
		.clickBackButton()
		.verifyOtherRegionListPage();
		objLogin1.clickLogOut();	
		
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Verify that a user can be provided the right to maintain events.
	'Precondition: 
	'Date : 03-Jun-2015 
	'Author : Anil
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Verify that a user can be provided the right to maintain events.")
	public void testHappyDay67054() throws Exception {

		gstrTCID = "67054";
		gstrTO = "Verify that a user can be provided the right to maintain events.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		
		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objEventSetUp.navigateToEventSetUp();
		
		objEventSetUp
		.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition,
				strResourceTypeValue, strStatusTypeValues)
		.verEveNotPreferenceScreenIsDisplayed(
				objEventSetUp_data.strEventTemplate)
		.deselectSelectAllWebOption()
		.navigateToEventNotificationPreferences(
				objEventSetUp_data.strEventTemplate)
		.clickSaveButton()
		.verEveTemplateInList(objEventSetUp_data.strEventTemplate);

		objLogin.clickLogOut();



		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToUsers();
		
		objUsersList1
		.verifyUserListPageIsDisplayed()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption().clickSaveButton()
				.verifyUserListPageIsDisplayed()
				.searchUserName(objUserdata.strNewUserName, objUserdata.strRole, objUserdata.strResourceType, objUserdata.strUsername, objUserdata.strsearchOption);

		objLogin1.clickLogOut();

		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1
				.navigateToEventManagement()
				.verifyEventManagementPage()
				.clickOnCreateNewEvent()
				.verifyEventTemplateIsDisplayed(objEventSetUp_data.strEventTemplate)
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName)
				.clickOnEditLink(objEvent_data.strEventName)
				.enterAdHocEventName(objEvent_data.strEditedEventName)
				.enterAdHocEventDescription(
						objEvent_data.strEditedEventDescription)
				.clickOnSaveButton()
				.verifyEventName(objEvent_data.strEditedEventName)
				.verifyEventInformation(objEvent_data.strEditedEventName, objEvent_data.strEditedEventDescription)
				.clickOnEndEvent(objEvent_data.strEditedEventName)
		        .verifyEventName(objEvent_data.strEditedEventName)
		        .verifyEventStatus(objEvent_data.strEditedEventName, objEvent_data.strEnded);   
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	/***************************************************************************************
	'Description : Verify that a user can be provided the right to maintain event templates.
	'Date	 	 : 02-Jun-2015
	'Author		 : Anitha
	'---------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	****************************************************************************************/
	@Test(description = "Verify that a user can be provided the right to maintain event templates.")
	public void testHappyDay68091() throws Exception {

		gstrTCID = "68091";
		gstrTO = "Verify that a user can be provided the right to maintain event templates.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();

		Login objLogin = new Login(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		EventSetUp objEventSetUp1=new EventSetUp(this.driver1);

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption().clickSaveButton()
				.verifyUserListPageIsDisplayed();
		
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName2,
						objUserdata.strNewPassword, objUserdata.strFullName2)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption().clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName3,
						objUserdata.strNewPassword, objUserdata.strFullName3)
				.selectFirstRole().clickSaveButton()
				.verifyUserListPageIsDisplayed();
		
		objLogin.clickLogOut();
		
		System.out.println("-------Prcondition ends and test execution starts-----");

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);
		
		objRegionDefault1.selectFrame();

		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectMaintainEventTemplateOption().clickSaveButton()
				.verifyUserListPageIsDisplayed();
		
		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame();

		objEventSetUp1.navigateToEventSetUp();
		
		String[] strstatusTypeValues = {};
		String[] strResourceTypeValue = {};
		
		objEventSetUp1.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strstatusTypeValues)
				
		.verEveTemplateInList(objEventSetUp_data.strEventTemplate);
		
		objEventSetUp1
				.clickOncreateEventTemplate()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate1)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition)
				.selectSecurityOption()
				.clickSaveButton()
				.verEveTemplateInList(objEventSetUp_data.strEventTemplate1)
		
				.clickOnEditTempLink(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateName(objEventSetUp_data.strEDITEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strEDITemplateDefn)
				.clickSaveButton()
				.verEveTemplateInList(objEventSetUp_data.strEDITEventTemplate)
				.verEveTemplateDescription(objEventSetUp_data.strEDITEventTemplate,
						objEventSetUp_data.strEDITemplateDefn)
						
				.clickOnSecurityOfEveTemplate(
						objEventSetUp_data.strEventTemplate1)
				.verUsersListedInEveSecurityPage(objUserdata.strNewUserName1)
				.verUsersListedInEveSecurityPage(objUserdata.strNewUserName2)
				.verUsersNotListedInEveSecurityPage(objUserdata.strNewUserName3)
				.selectUserInEveSecutityPage(objUserdata.strNewUserName1)
				.clickSaveButton().verEveTemplateListScreenIsDisplayed();

		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objEventManagement1
				.navigateToEventManagement()
				.clickOnCreateNewEvent()
				.verifyEventTemplateIsDisplayed(
						objEventSetUp_data.strEventTemplate1);

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName2,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1
				.navigateToEventManagement()
				.clickOnCreateNewEvent()
				.verifyEventTemplateIsNotDisplayed(
						objEventSetUp_data.strEventTemplate1);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/***************************************************************************************
	'Description : Verify that a user can be provided the right to view user information only.
	'Date	 	 : 02-Jun-2015
	'Author		 : Anitha
	'---------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	****************************************************************************************/
	@Test(description = "Verify that a user can be provided the right to view user information only.")
	public void testHappyDay69126() throws Exception {

		gstrTCID = "69126";
		gstrTO = "Verify that a user can be provided the right to view user information only.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();;

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		UserFunctions objUserFunctions1 = new UserFunctions(this.driver1);
		RegionalInfo objRegionalInfo1 = new RegionalInfo(this.driver1);

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);
		
		objRegionDefault1.selectFrame();

		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strStateWideReg);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectUserViewUserInformationOnlyOption().clickSaveButton()
				.verifyUserListPageIsDisplayed();
		
		System.out.println(objUserdata.strNewUserName);
		
		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToUsersInRegionalInfo();
		
		objUserFunctions1.enterUsernameInSearchInputField(
				objUserdata.strNewUserName)
		.clickSearchButton();
		
		objRegionalInfo1.verUserInUserListPgeOfRegionalInfo(
				objUserdata.strNewUserName, objUserdata.strFullName);
		
		objUsersList1.createNewUserButtonIsNotPresent()
		
		.verEditLinkIsNotPresent(objUserdata.strNewUserName)
		
		.verPasswordLinkIsNotPresent(objUserdata.strNewUserName)
		
		.verSetUpIsNotPresent();

		objLogin1.clickLogOut();	

		gstrResult = "PASS";
	}
	
	/***************************************************************************************
	'Description : Verify that a user can be provided the right to activate forms. 
	'Date	 	 : 03-Jun-2015
	'Author		 : Renushree
	'---------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	****************************************************************************************/
	@Test(description = "Verify that a user can be provided the right to activate forms.")
	public void testHappyDay68358() throws Exception {

		gstrTCID = "68358";
		gstrTO = "Verify that a user can be provided the right to activate forms. ";

		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();

		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.verFormConfigurePage()
				.createNewFormTempltete()
				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strFormName,
						objFormConfiguration_data.strDiscriptiveName)
				.selectOptionInFormActivationDropDown(
						objFormConfiguration_data.strFormActivatnUIOTFO)
				.selCompletedFormDelivery(
						objFormConfiguration_data.strUserToIndividualResources)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
				.clickOnNextButton().clickOnNextButton().clickOnNextButton()
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objFormConfiguration_data.strFormName);

		objFormConfiguration1
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle = driver1.getWindowHandle();

		Set<String> a = driver1.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration1
				.verTemplateDesignPage()
				.clickOnInsert()
				.clickOnGroupLink()
				.verifyEditGroupOrTable()
				.enterNewGroupName(objFormConfiguration_data.strGroupName)
				.clickOnGroupDoneButton()
				.clickOnAddButton(objFormConfiguration_data.strGroupName)
				.clickOnFieldSet(objFormConfiguration_data.strGroupName)
				.verifyEditFieldSetWindow()
				.enterAttributesLabelName(
						objFormConfiguration_data.strAttributeName)
				.clickOnEditFieldDoneButton()
				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strNumeric)
				.enterLabelName(objFormConfiguration_data.strLabelName)
				.clickOnAddToSummary()
				.clickOnDoneButton()
				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strText)
				.enterLabelName(objFormConfiguration_data.strLabelName1)
				.clickOnAddToSummary().clickOnDoneButton().clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(5000);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption().clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1.clickOnSecurityLinkOfForm(objFormConfiguration_data.strFormName)
		.selectActivateFormChkBox(objUserdata.strNewUserName)
		.clickOnSaveOfFormSecuritySetting();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();

		objActivateForms1
				.clickOnSendForm(objFormConfiguration_data.strFormName)
				.clickOnActivateForm();

		objRegionDefault1.verifyRegionDefaultPage();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/***************************************************************************************
	'Description : Verify that a user can be provided the right to configure form security. 
	'Date	 	 : 03-Jun-2015
	'Author		 : Renushree
	'---------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	****************************************************************************************/
	@Test(description = "Verify that a user can be provided the right to configure form security. ")
	public void testHappyDay68380() throws Exception {

		gstrTCID = "68380";
		gstrTO = "Verify that a user can be provided the right to configure form security. ";

		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();

		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		ActivateForms objActivateForms1 = new ActivateForms(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.verFormConfigurePage()
				.createNewFormTempltete()
				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strFormName,
						objFormConfiguration_data.strDiscriptiveName)
				.selectOptionInFormActivationDropDown(
						objFormConfiguration_data.strFormActivatnUIOTFO)
				.selCompletedFormDelivery(
						objFormConfiguration_data.strUserToIndividualResources)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
				.clickOnNextButton().clickOnNextButton().clickOnNextButton()
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);
		System.out.println(objFormConfiguration_data.strFormName);

		objFormConfiguration1
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle = driver1.getWindowHandle();

		Set<String> a = driver1.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		objFormConfiguration1
				.verTemplateDesignPage()
				.clickOnInsert()
				.clickOnGroupLink()
				.verifyEditGroupOrTable()
				.enterNewGroupName(objFormConfiguration_data.strGroupName)
				.clickOnGroupDoneButton()
				.clickOnAddButton(objFormConfiguration_data.strGroupName)
				.clickOnFieldSet(objFormConfiguration_data.strGroupName)
				.verifyEditFieldSetWindow()
				.enterAttributesLabelName(
						objFormConfiguration_data.strAttributeName)
				.clickOnEditFieldDoneButton()
				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strNumeric)
				.enterLabelName(objFormConfiguration_data.strLabelName)
				.clickOnAddToSummary()
				.clickOnDoneButton()
				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strText)
				.enterLabelName(objFormConfiguration_data.strLabelName1)
				.clickOnAddToSummary().clickOnDoneButton().clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(5000);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle);

		objRegionDefault1.switchToDefaultFrame()
		.selectFrame();
		
		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayConfigureFormSecurity().clickSaveButton()
				.verifyUserListPageIsDisplayed();
		
		objUsersList1
		.clickCreateNewUserButton()
		.enterUserDetails(objUserdata.strNewUserName1,
				objUserdata.strNewPassword, objUserdata.strFullName1)
		.selectFirstRole().clickAdvancedOptionAndExpand()
		.selectFormUserMayActivateFormsOption().clickSaveButton()
		.verifyUserListPageIsDisplayed();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1.clickOnSecurityLinkOfForm(objFormConfiguration_data.strFormName)
		.selUserInFormSecuritySettingPageForUser(objUserdata.strNewUserName1)
		.clickOnSaveOfFormSecuritySetting();
		
		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToActivateForm();

		objActivateForms1
				.clickOnSendForm(objFormConfiguration_data.strFormName)
				.clickOnActivateForm();

		objRegionDefault1.verifyRegionDefaultPage();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

	/**********************************************************************************************
	 * 'Description : Verify that a user can be provided the right to setup Roles.
	 * 'Date        : 03-Jun-2015
	 * 'Author      : Pallavi
	 **********************************************************************************************/

	@Test(description = "Verify that a user can be provided the right to setup Roles.")
	public void testHappyDay66918() throws Exception {
		
		gstrTCID = "66918";
		gstrTO = "Verify that a user can be provided the right to setup Roles.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		Roles_data objRoles_data = new Roles_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(this.driver1);
		Roles objRoles = new Roles(this.driver1);

		String strRoleValue[] = new String[1];
		
		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();

		// User creation
		UsersList_page.navigateToUsers();

		System.out.println(objUser_data.strNewUserName);

		UsersList_page
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName, 
						objUser_data.strNewPassword, 
						objUser_data.strFullName)
				.clickAdvancedOptionAndExpand()
				.selectSetUpRolesRight()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		login_page.clickLogOut();

		login_page1.loginAsNewUser(objUser_data.strNewUserName, 
				objUser_data.strNewPassword);
		
		RegionDefault_page1.selectFrame();
		
		objNavigationToSubMenus.clickOnSetUp()
							   .navigateToRoles();
		
		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRoles_data.strRoleName)
				.clickOnSaveBtn();
		
		System.out.println(objRoles_data.strRoleName);
		
		strRoleValue[0] = objRoles.getRoleValue(objRoles_data.strRoleName);
		
		objRoles.verifyCreatedRoleInRolesList(objRoles_data.strRoleName)
				.clickOnEditLinkOfRole(objRoles_data.strRoleName)
				.enterRoleName("Edt" + objRoles_data.strRoleName)
				.clickOnSaveBtn()
				.verifyCreatedRoleInRolesList("Edt" + objRoles_data.strRoleName);
		
		login_page1.clickLogOut();		
		
		gstrResult= "PASS";
	}

	/**********************************************************************************************
	 * 'Description : Verify that a user can be provided the right to view custom view.
	 * 'Date        : 03-Jun-2015
	 * 'Author      : Pallavi
	 **********************************************************************************************/

	@Test(description = "Verify that a user can be provided the right to view custom view.")
	public void testHappyDay66939() throws Exception {
		
		gstrTCID = "66939";
		gstrTO = "Verify that a user can be provided the right to view custom view.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		Roles_data objRoles_data = new Roles_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		Roles objRoles = new Roles(this.driver1);

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);
		CustomUnderView objCustomUnderView = new CustomUnderView(this.driver1);
		Views objViews = new Views(this.driver1);

		String strRoleValue[] = new String[1];
		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		
		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();

		objNavigationToSubMenus.clickOnSetUp()
		   					   .navigateToRoles();

		objRoles.createRole(objRoles_data.strRoleName);
		
		System.out.println(objRoles_data.strRoleName);
		
		strRoleValue[0] = objRoles.getRoleValue(objRoles_data.strRoleName);

		objNavigationToSubMenus.navigateToStatusTypesInSetup();
		
		// RoleBased statustypes
		System.out.println(objStatuTypes_data.strNumberStatusType);
		
		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatuTypes_data.strNumberStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatuTypes_data.strNSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatuTypes_data.strStatusDescription)
				.selectRoleUnderRolesWithViewRight(strRoleValue[0])
				.selectRoleUnderRolesWithUpdateRight(strRoleValue[0])
				.clickOnSaveButton();

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);
				
		// Resource type creation
		objResourceType.navigateToResourceTypePage()
					   .createResourceType(objResourceType_data.strResourceTypeName,
							   strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);
		
		System.out.println(objResourceType_data.strResourceTypeName);
		
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
		System.out.println(objResource_data.strResourceName);
		
		// User creation
		UsersList_page.navigateToUsersNew();

		System.out.println(objUser_data.strNewUserName);

		UsersList_page
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName, 
						objUser_data.strNewPassword, 
						objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.clickAdvancedOptionAndExpand()
				.selectViewcustomViewOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();
		
		login_page.clickLogOut();
		
		login_page1.loginAsNewUser(objUser_data.strNewUserName, 
						objUser_data.strNewPassword);
		
		RegionDefault_page1.selectFrame();
		
		objNavigationToSubMenus1.navigateToCustomizedViewInPrefrences();
		
		String arrResourceNames[] = { objResource_data.strResourceName };
		
		objCustomUnderView.verEditCustomViewScreenIsDisplayed()
						  .clickOnAddMoreResources()
						  .enterResNameInWhatField(objResource_data.strResourceName)
						  .clickOnSearch()
						  .selectResource(strResourceValue)
						  .clickOnAddToCustomView()
						  .clickOnOptions()
						  .selectStatusTypes(strStatusTypeValues)
						  .clickOnSave()
						  .verResourceAndResTypeInCustomViewTablePage(arrResourceNames,
								  objResourceType_data.strResourceTypeName);
		
		objNavigationToSubMenus1.navigateToCustomInView();
		
		objViews.verCustomViewTableisDisplayed();
		
		objCustomUnderView.verResourceAndResTypeInCustomViewTablePage(arrResourceNames,
				  objResourceType_data.strResourceTypeName);
		
		objViews.clickOnCustomizeLink();
		
		objCustomUnderView.verEditCustomViewScreenIsDisplayed();
		
		gstrResult = "PASS";
	}
	
	/**********************************************************************************************
	 * 'Description : Verify that user can be created by providing only mandatory data.
	 * 'Date        : 04-Jun-2015
	 * 'Author      : Pallavi
	 **********************************************************************************************/

	@Test(description = "Verify that user can be created by providing only mandatory data.")
	public void testHappyDay88053() throws Exception {
		
		gstrTCID = "88053";
		gstrTO = "Verify that user can be created by providing only mandatory data.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		UsersList UsersList_page1 = new UsersList(this.driver1);
		ChangePassword objChangePassword1 = new ChangePassword(this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(this.driver1);
		RegionalInfo objRegionalInfo = new RegionalInfo(this.driver1);
		SecurityQuestion objSecurityQuestion = new SecurityQuestion(this.driver1);

		login_page1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page1.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page1.selectFrame();

		// User creation
		UsersList_page1.navigateToUsers();

		System.out.println(objUser_data.strNewUserName);

		UsersList_page1
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName, 
						objUser_data.strNewPassword, 
						objUser_data.strFullName)
				.clickSaveButton()
				.verifyUserListPageIsDisplayed()
				.clickOnShowAllUsersIfPresent()
				.verUserInList(objUser_data.strNewUserName)
				.verFullName(objUser_data.strNewUserName, 
							objUser_data.strFullName);
		
		objNavigationToSubMenus.navigateToUsersInRegionalInfo();
		System.out.println(objUser_data.strNewUserName);
		UsersList_page1.clickOnShowAllUsersIfPresent()
					   .verifyUserListPageIsDisplayed();
		
		objRegionalInfo.verUserInUserListPgeOfRegionalInfo(objUser_data.strNewUserName, 
							objUser_data.strFullName);
		
		login_page1.clickLogOut()
				   .loginAsNewUser(objUser_data.strNewUserName, 
						objUser_data.strNewPassword);
		
		RegionDefault_page1.selectFrame()
		   				   .verifyRegionDefaultPage()
		   				   .verifyUserNameInFooter(objUser_data.strNewUserName);
		
		login_page1.clickLogOut()
				   .verifyUserName()
				   .enterUserName(objUser_data.strNewUserName)
				   .enterPassword(objUser_data.strNewPassword)
				   .clickLogin();
		
		objSecurityQuestion.clickOnCancel();
		
		objChangePassword1.verSetUpYourPswdScreenIsNotDisplayed();
		
		RegionDefault_page1.selectFrame()
		   				   .verifyRegionDefaultPage();
		
		login_page1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/***************************************************************************************************************
	 * 'Description : Verify that a user can be provided the right to generate Status Snapshot report. 
	 * 'Date        : 04-Jun-2015 
	 * 'Author      : Renushree
	 ***************************************************************************************************************/

	@Test(description = "Verify that a user can be provided the right to generate Status Snapshot report. ")
	public void testHappyDay68197() throws Exception {
		gstrTCID = "68197";
		gstrTO = "Verify that a user can be provided the right to generate Status Snapshot report. ";

		// Objects for data
		Login_data objTest_data = new Login_data();
		UsersList objUsersList_page = new UsersList(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		Date_Time_settings objDate_Time_settings = new Date_Time_settings();
		Report_data objReport_data = new Report_data();

		String strTimeText = objDate_Time_settings
				.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.reportFile;

		String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
		String strAutoItPath = ReadAutoItProperty
				.readDataFromAutoItPath(AutoIT_FILE_PATH);
		String strAutoITName = pathProps
				.getProperty(objReport_data.reportsDownloadAutoItName);
		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);

		String autoItFilesPath = pathProps
				.getProperty(objReport_data.autoItPath);

		File file = new File(System.getProperty("user.dir") + fileDownloadPath);

		File autoItFiles = new File(System.getProperty("user.dir")
				+ autoItFilesPath);

		String strDownloadName = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + fileType;
		String strCSVFileNameRenamed = "TC" + gstrTCID + "_" + strTimeText;

		String strCSVDownlRenamedPath = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		String strDownloadName1 = file + "\\" + "TC" + gstrTCID + "_"
				+ strTimeText + objReport_data.xlsFile;

		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		ResourceType objResourceType_Page = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Resource objResource_Page = new Resource(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Report objReport1 = new Report(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Map objMap1 = new Map(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);

		String strResourceValue[] = new String[1];
		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strStatusesValues[] = new String[2];

		System.out.println("-----Precondtion execution starts------");

		String filePath = file + "\\";

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// RoleBased statustypes

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusColor);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor);

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objNavigationToSubMenus.navigateToResourceInSetup();

		// Resource type creation
		objResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objNavigationToSubMenus.navigateToResourceInSetup();

		objResource_Page
				.navigateToResourceListPage()
				.createResourceWithAddress(objResource_data.strResourceName,
						objResource_data.strResourceAbbrivation,
						objResourceType_data.strResourceTypeName,
						objResource_data.strStandardResourceTypename,
						objResource_data.strResourceFirstName,
						objResource_data.strResourceLastName,
						objResource_data.strStreetAddress,
						objResource_data.strCity, objResource_data.strState,
						objResource_data.strCounty, objResource_data.strZipcode);

		strResourceValue[0] = objResource_Page
				.getResourceValue(objResource_data.strResourceName);

		objUsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().deselectAllViewResReightOption()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportRight(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectReportStatusSnapshotOption().clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objLogin.clickLogOut();
		System.out.println(objUserdata.strNewUserName);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus1.selectStatusTypes(strStatusTypeValues[0]);

		objUpdateStatus1.selectMSTUpdateValue(strStatusTypeValues[0],
				strStatusesValues[0]).clickOnSaveButton();

		String strEventStartTime = objEventManagement1.getApplicationTimeWithCSTCDT();

		String strStartTime[] = strEventStartTime.split(":");
		
		String strTimeZone[] = strStartTime[1].split(" ");

		String strStartTime1[] = strStartTime[0].split(" ");

		String strDate2 = strStartTime1[0];

		String strMonth = strStartTime1[1];

		strMonth = objDate_Time_settings
				.converDateFormat(strMonth, "MMM", "MM");

		String strYear = objDate_Time_settings.getFutureYear(0, "yyyy");

		String strHour = strStartTime1[2];

		String strMinute = strStartTime[1];

		String strMinute1 = objDate_Time_settings.addTimetoExisting(strMinute,
				1, "mm");

		String strCurrentDate = strMonth + "/" + strDate2 + "/" + strYear;

		String strTime = objDate_Time_settings.getCurrentDate("HH:mm");

		strCurrentDate = strCurrentDate + " " + strTime;

		String[] strDate = strCurrentDate.split(" ");

		System.out.println(strCurrentDate);
		String strLastUpdatedDateInReport = objDate_Time_settings
				.converDateFormat(strCurrentDate, "MM/dd/yyyy HH:mm",
						"dd MMM yyyy HH:mm");
		String str[] = strLastUpdatedDateInReport.split(" ");
		strLastUpdatedDateInReport = str[0] + " " + str[1] + " " + str[2] + " "
				+ strHour + ":" + strMinute;
		System.out.println(strLastUpdatedDateInReport);
		objNavigationToSubMenus1.clickOnStatusReports();
		
		Thread.sleep(60000);

		objReport1.clickOnStatusSnapshot().verifyStatusSnapShotPage().enterReportDate(strDate[0])
				.selectHour(strHour).selectMinute(strMinute1)
				.clickOnGenerateReportBtn();

		Thread.sleep(10000);

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);

		int intCount = 0;
		int intCount1 = 0;
		do {

			try {
				assertTrue(new File(strDownloadName).exists());
				Thread.sleep(10000);
				Runtime.getRuntime().exec(
						"wscript " + autoItFiles + filePath + " "
								+ strCSVFileNameRenamed);

				intCount1 = 0;
				do {
					try {
						assertTrue(new File(strCSVDownlRenamedPath).exists());
						break;
					} catch (AssertionError Ae) {
						Thread.sleep(1000);
						intCount1++;
					}

				} while (intCount1 < 60);

				break;
			} catch (AssertionError Ae) {
				Thread.sleep(1000);
				intCount++;
			}
		} while (intCount < 60);

		String strValue = objOffCommonFunc.readInfoExcel("Status Snapshot", 1,
				1, strDownloadName1);
		assertEquals("Status Snapshot - " + strDate[0] + " " + strHour + ":"
				+ strMinute1 + " "+strTimeZone[1]+"", strValue);

		String[] strHeaderNames = objReport_data.strStatusSnapshot;

		String[] strAnswers = { objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusNameInMulti, "", strLastUpdatedDateInReport };

		for (intCount = 1; intCount <= strHeaderNames.length; intCount++) {
			strValue = objOffCommonFunc.readInfoExcel("Status Snapshot", 2,
					intCount, strDownloadName1);
			assertEquals(strHeaderNames[intCount - 1], strValue);

			strValue = objOffCommonFunc.readInfoExcel("Status Snapshot", 3,
					intCount, strDownloadName1);
			assertTrue(strAnswers[intCount - 1].contains(strValue));
		}

		gstrResult = "PASS";
	}
	
	/*********************************************************************************
	'Description : Verify that a user can be provided the right to generate Status Reason Summary report. 
	'Precondition:
	'Date	 	 : 04-Jun-2015
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************/
	@Test(description = "Verify that a user can be provided the right to generate Status Reason Summary report. ")
	public void testHappyDay68159() throws Exception {

		gstrTCID = "68159";
		gstrTO = "Verify that a user can be provided the right to generate Status Reason Summary report. ";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Date_Time_settings dts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();
		StatusReason_data objStatusReason_data = new StatusReason_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		StatusReasonList objStatusReasonList = new StatusReasonList(this.driver1);

		String strstatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strReasonVal[] = new String[2];
		String strStatusesValues[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		UpdateStatus objUpdateStatus_Page1 = new UpdateStatus(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		Map objMap1 = new Map(this.driver1);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.pdfFile;
		String fileType1 = objReport_data.csvFile;

		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;

		// Auto it path
		String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
		String strAutoItPath = ReadAutoItProperty
				.readDataFromAutoItPath(AutoIT_FILE_PATH);

		String strAutoITName = pathProps
				.getProperty(objReport_data.reportsDownloadAutoItName);

		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);

		File file = new File(System.getProperty("user.dir") + fileDownloadPath);

		String strDownloadName = file + "\\" + "TCID91304" + "_" + strTimeText
				+ fileType;

		String strDownloadName2 = file + "\\" + "TC91304_CSV" + "_"
				+ strTimeText + fileType1;

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToStatusReasons();

		objStatusReasonList.createStatusReason(
				objStatusReason_data.strReasonName,
				objStatusReason_data.strReasonDesc,
				objStatusReason_data.strReasonAbb);

		strReasonVal[0] = objStatusReasonList
				.getStatusReasonVal(objStatusReason_data.strReasonName);

		objStatusReasonList.createStatusReason(
				objStatusReason_data.strReasonName1,
				objStatusReason_data.strReasonDesc,
				objStatusReason_data.strReasonAbb);

		strReasonVal[1] = objStatusReasonList
				.getStatusReasonVal(objStatusReason_data.strReasonName1);

		objStatusTypeList.navigateToStatusTypeListNew();

		// RoleBased statustypes with selecting Reason
		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatuTypes_data.strMultiStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatuTypes_data.strMSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatuTypes_data.strStatusDescription)
				.selectStatusReason(strReasonVal[0])
				.clickOnSaveButton()

				.clickOnCreateNewStatus()
				.enterStatusName(objStatuTypes_data.strStatusNameInMulti)
				.selectStatusReasonForStatus(strReasonVal[0])
				.clickOnSaveButton()

				.verCreatedStatusInStatusListForMulti(
						objStatuTypes_data.strStatusNameInMulti);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti);

		objStatusTypeList.createNewStatus(objStatuTypes_data.strStatusNameInMulti1,objStatuTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameInMulti1)
		.clickOnReturnToStatusTypeList();

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

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
		System.out.println(objResource_data.strResourceName);

		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectReportStatusReasonSummaryOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals);

		System.out.println("1u " + objUser_data.strNewUserName);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus_Page1
				.selectStatusTypes(strstatusTypeValues[0])
				.selectMSTUpdateValue(strstatusTypeValues[0],
						strStatusesValues[0])
				.selectMSTReasonValue(strReasonVal[0], strstatusTypeValues[0],
						strStatusesValues[0])
				.clickOnSaveButton();

		String strUpdatedTime = objEventManagement1.getApplicationTime();
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strTime = strUpdatedTime.split(" ");

		String strRequiredUpdatedTime = dts.converDateFormat(strTime[0]
				+ strTime[1] + strCurYear + " " + strTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		String strCurrentDate = dts.timeNow("MM/dd/yyyy");

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1.clickOnStatusReasonSummaryLink()
				.verifyStatusReasonSummaryPage1()
				.enterReportStartDate(strCurrentDate)
				.enterReportEndDate(strCurrentDate)
				.selectResources(strResourceValue[0]).clickOnNextBtn()
				.verifyStatusReasonSummaryPage2()
				.selStatusType(objStatuTypes_data.strMSTStatusTypeName)
				.clickOnNextBtn().verifyStatusReasonSummaryPage3()
				.selStatusReason(strReasonVal[0], strStatusesValues[0])
				.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);

		File file1 = new File(strDownloadName);
		boolean strPdf1 = file1.exists();

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1.clickOnStatusReasonSummaryLink()
				.verifyStatusReasonSummaryPage1()
				.enterReportStartDate(strCurrentDate)
				.enterReportEndDate(strCurrentDate)
				.selectDataFileCommaSepatatedCSVRadioBtn()
				.selectResources(strResourceValue[0]).clickOnNextBtn()
				.verifyStatusReasonSummaryPage2()
				.selStatusType(objStatuTypes_data.strMSTStatusTypeName)
				.clickOnNextBtn().verifyStatusReasonSummaryPage3()
				.selStatusReason(strReasonVal[0], strStatusesValues[0])
				.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName2,
				strAutoITName);

		File file3 = new File(strDownloadName2);
		boolean strCsv1 = file3.exists();

		if (strCsv1) {
			String[] strTestData2 = {
					gstrTCID,
					Login_data.strBuildName,
					objUser_data.strNewUserName + "/"
							+ objUser_data.strNewPassword,
					objTest_data.strRegionName,
					objStatuTypes_data.strMSTStatusTypeName,
					objStatuTypes_data.strStatusNameInMulti,
					objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName, "", "",
					objStatusReason_data.strReasonName, "",
					objReport_data.ExternalIP, strDownloadName2, "", "" };

			objOffCommonFunc.writeResultData(strTestData2,
					strPartialAutoResultsPath, "CSVDetails");
		}

		if (strPdf1) {
			String[] strTestData = {
					gstrTCID,
					Login_data.strBuildName,
					objUser_data.strNewUserName + "/"
							+ objUser_data.strNewPassword,
					objTest_data.strRegionName, "", "",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatuTypes_data.strMSTStatusTypeName, "", "",
					objReport_data.ExternalIP, "", "", strRequiredUpdatedTime,
					strDownloadName, "", objStatusReason_data.strReasonName,
					objStatuTypes_data.strStatusNameInMulti, "", "", "" };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");

		}
		objLogin1.clickLogOut();

		if (strPdf1 && strCsv1) {
			gstrResult = "PASS";
		} else {
			gstrResult = "FAIL";
		}
	}
	
	/***************************************************************************************************
	'Description : Verify that a user can be provided the right to edit event notification preferences.
	'Date	 	 : 04-June-2015
	'Author		 : Anitha
	'---------------------------------------------------------------------------------------------------
	'Modified Date			                        	                      Modified By
	'Date					                                                  Name
	****************************************************************************************************/
	@Test(description = " Verify that a user can be provided the right to edit event notification preferences.")
	public void testHappyDay98498() throws Exception {

		gstrTCID = "98498";
		gstrTO = " Verify that a user can be provided the right to edit event notification preferences.";

		Login_data objLogindata = new Login_data();
		EventSetUp_data objEventSetUp_data=new EventSetUp_data();
		User_data objUserdata = new User_data();
		Event_data objEvent_data = new Event_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(this.driver1);
		EventManagement objEventManagementPage1 = new EventManagement(this.driver1);
		MyEventNotificationPreferences objMyEventNotificationPreferences_page1 = new MyEventNotificationPreferences(
				this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		// create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.clickOncreateEventTemplate()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition)
				.clickSaveButton().deselectSelectAllWebOption();

		objLogin.clickLogOut();
		
		System.out.println("--------Precondition ends and test execution starts---------");

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.enterPrimaryEmailId(objUserdata.strPrimaryMailId)
				.enterEmail(objUserdata.strPrimaryMailId)
				.entertextPagerId(objUserdata.strPrimaryMailId)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.selectEditEventNotificationPreferencesOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		
		objEventManagementPage1.selectFrame();
		
		objNavigationToSubmenus1.navigateToEventNotificationInPreferences();

		objMyEventNotificationPreferences_page1.verifyMyEventNotificationPrefPageIsDisp()
				.selectWebIndNotification(objEventSetUp_data.strEventTemplate)
				.selectTextPagerIndNotification(
						objEventSetUp_data.strEventTemplate)
				.selectEmailNotification(objEventSetUp_data.strEventTemplate)
				.clickOnSaveButton()
				.verEmailNotificationChecked(objEventSetUp_data.strEventTemplate)
				.verTextPagerChecked(objEventSetUp_data.strEventTemplate)
				.verWebNotificationChecked(objEventSetUp_data.strEventTemplate);

		objEventManagementPage1
				.navigateToEventManagement()
				.verifyCreateEventButtonDisplayed()
				.clickOnCreateNewEvent()
				.verifySelectEventTemplatePage()
				.verifyEventTemplateIsDisplayed(
						objEventSetUp_data.strEventTemplate)
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);
		
		objEventManagementPage1.verWebNotificationframe()

				.verWebNotificationAndAcknowledge(objEvent_data.strEventName,
						objEvent_data.strEventDescription)

				.clickAcknowledgeAllNotifications();

		String strMsgBody1 = "Event Notice for: " + objUserdata.strFullName
				+ "\n" + "Information: " + objEvent_data.strEventDescription
				+ "\n\n" + "From: " + objUserdata.strFullName + "\n\n"
				+ "Regions: " + objLogindata.strRegionName
				+ "\n\nPlease do not reply to this email message. "
				+ "You must log into EMResource to take any "
				+ "action that may be required." + "\n" + objUserdata.MailURL;

		String strMsgBody2 = "Information: "
				+ objEvent_data.strEventDescription + "\nFrom: "
				+ objUserdata.strFullName + "\nRegions: "
				+ objLogindata.strRegionName;

		Thread.sleep(100000);

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);
		
		boolean blnMsg1 = false;
		boolean blnMsg2 = false;

		String strSubject = objEvent_data.strEventName;
		
		objMailVerificationFunctions.NavToInbox(strSubject);
		
		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(
					objUserdata.strPrimaryMailId, strSubject);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody1);
			}

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody2);
			}

			objMailVerificationFunctions.backToMailInbox();
		}

		assertTrue(blnMsg1 && blnMsg2);

		objMailVerificationFunctions.logoutMail();
		
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Verify that a user can be provided the right to configure region views.
	'Precondition: 
	'Date : 03-Jun-2015 
	'Author : Anil
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Verify that a user can be provided the right to configure region views.")
	public void testHappyDay66095() throws Exception {

		gstrTCID = "66095";
		gstrTO = "Verify that a user can be provided the right to configure region views.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		View_data objView_data = new View_data();
		Resource_data objResource_data = new Resource_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		CustomUnderView ObjCustomUnderView1 = new CustomUnderView(this.driver1);
		
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		LinksAtTopRightCorners objAtTopRightCorners1= new LinksAtTopRightCorners(this.driver1);
		
		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		
		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objViewsList.navigateToViewsListNew();
		
		objViewsList.createNewSection(objView_data.strSectionName);
		
		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

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
		objnNavigationToSubMenus.navigateToViews();
		
		//view v1
		
		objViewsList.createView(objView_data.strViewName,
				objView_data.strViewDesc, objResource_data.strResourceName,
				objStatusTypes_data.strNSTStatusTypeName);


		objLogin.clickLogOut();
		
		System.out.println(objResource_data.strResourceName);

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToUsers();
		
		objUsersList1
		.verifyUserListPageIsDisplayed()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionViewsOption()
				.selectViewcustomViewOption()
				.clickSaveButton()
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption);

		System.out.println(objUserdata.strNewUserName);
		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame()
		.verifyRegionDefaultPage();

		objNavigationToSubmenus1.navigateToViews();
		
		//view2
	
		objViewsList1.createView(objView_data.strViewName2,
				objView_data.strViewDesc, objResource_data.strResourceName,
				objStatusTypes_data.strNSTStatusTypeName).verViewInList(
				objView_data.strViewName2);

		objViewsList1.clickOnEditLinkOfView(objView_data.strViewName2)
		.enterViewName(objView_data.strEditedViewName)
		.enterViewDesc(objView_data.strEditedViewDesc)
		.clickOnSaveOfCreateNewView()
		.verViewInList(objView_data.strEditedViewName)
		.clickOnEditLinkOfView(objView_data.strEditedViewName)
		//.verifyViewName(objView_data.strEditedViewName)
		.verifyViewDescription(objView_data.strEditedViewDesc)
		.clickOnSaveOfCreateNewView();
		
		objViewsList1.clickOnEditLinkOfView(objView_data.strEditedViewName)
		
		.clickOnUsersTab()
		.deselectSecurityChkBoxInUsersTab()
		.searchUserUnderUsersTabOfView(objUserdata.strNewUserName)
		.verifyUsersCheckBoxIsEnabled(objUserdata.strNewUserName)
		//.selectUsersCheckBoxinAssigUsers(objUserdata.strNewUserName)
		.clickOnCancelButton()
		.verRegionViewListPageIsDisplayed();
		
		objViewsList1.navigateToCreatedViewNew(objView_data.strViewName);
		objAtTopRightCorners1.clickOnCustomize();
		
		objViewsList1.clickOnSaveOfCreateNewView()
		.verRegionViewListPageIsDisplayed();
		
		objNavigationToSubmenus1.navigateToViews();
		         objViewsList1.clickOnReorderViews()
		                  .verifyErrorMessage()
		                  .verifyErrorMessage2()
		                  .verifyOndoneReOrderingViews()
		                  .clickOnSave()
		                  .clickOncustomizeResourceDetailView();
		                
        String strViewNames[] = objViewsList1.dragAndDropLastTwoViews();
		    System.out.println(strViewNames[0]);
		      System.out.println(strViewNames[1]);
		
		      objViewsList1.navigateToCreatedViewNew(objView_data.strViewName)
		                   .clickOnResourceAndNavigateToResourceDetail(objResource_data.strResourceName);
		      
		      objAtTopRightCorners1.clickOnCustomize();
		      
		      objViewsList1.verEditResourceDetailViewSectionsPageIsDisplayed()
		                   .clickOnSaveButton();

		      objViewsList1.navigateToViewsListNew()
				.clickOnCopyLinkOfView(objView_data.strEditedViewName)
				.enterViewName(objView_data.strViewName3)
				.clickOnSaveOfCreateNewView()
				.verViewInList(objView_data.strViewName3)
				.clickOnDeleteLinkOfView(objView_data.strViewName3)
				.clickOnDelete();
				Thread.sleep(10000);
				objViewsList1.verViewIsNotListed(objView_data.strViewName3);
				
				objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	
	/*********************************************************************************
	'Description : Verify that a user can be provided the right to generate Status Reason Detail report.
	'Precondition:
	'Date	 	 : 15-Sep-2014
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************/
	@Test(description = "Verify that a user can be provided the right to generate Status Reason Detail report.")
	public void testHappyDay68196() throws Exception {

		gstrTCID = "68196";
		gstrTO = "Verify that a user can be provided the right to generate Status Reason Detail report.";

		Login_data objLogin_data = new Login_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		User_data objUserdata = new User_data();
		Date_Time_settings dts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();
		StatusReasonList objStatusReasonList = new StatusReasonList(this.driver1);
		StatusReason_data objStatusReason_data = new StatusReason_data();
		Map objMap = new Map(this.driver1);
		UpdateStatus objUpdateStatus = new UpdateStatus(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strStatusesValues[] = new String[2];

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.pdfFile;
		String fileType2 = objReport_data.csvFile;

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;

		// Auto it path
		String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
		String strAutoItPath = ReadAutoItProperty
				.readDataFromAutoItPath(AutoIT_FILE_PATH);
		String strAutoITName = pathProps
				.getProperty(objReport_data.reportsDownloadAutoItName);
		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);
		File file = new File(System.getProperty("user.dir") + fileDownloadPath);
		String strDownloadName = file + "\\" + "TC" + gstrTCID+"_" + strTimeText
				+ fileType;

		String strDownloadName1 = file + "\\" + "TC"+gstrTCID+"Excel" + "_"
				+ strTimeText + fileType2;

		objLogin.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToStatusReasons();

		objStatusReasonList.createStatusReason(
				objStatusReason_data.strReasonName,
				objStatusReason_data.strReasonDesc,
				objStatusReason_data.strReasonAbb);

		String strReasonVal = objStatusReasonList
				.getStatusReasonVal(objStatusReason_data.strReasonName);

		objStatusTypeList
				.navigateToStatusTypeListNew()
				.createStatusTypeWithReason(
						objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription, strReasonVal)
						
				.createNewStatusWithStatusReason(objStatusTypes_data.strStatusNameInMulti, objStatuTypes_data.strStatusColor, strReasonVal)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti);
		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList.createNewStatusWithStatusReason(
				objStatusTypes_data.strStatusNameInMulti1, objStatuTypes_data.strStatusColor, strReasonVal)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1);
		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

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
		objLogin.clickLogOut();
		
		objLogin1.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegion1.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubMenus1.navigateToUsers();

		objUsersList1
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectReportStatusReasonDetailOption().clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objLogin1.clickLogOut();

		objLogin.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToMap();

		objMap.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus
				.selectStatusTypes(strStatusTypeValues[0])
				.selectMSTUpdateValue(strStatusTypeValues[0],
						strStatusesValues[0])
				.selectMSTReasonValue(strReasonVal, strStatusTypeValues[0],
						strStatusesValues[0]).clickOnSaveButton();
		
		String strUpdatedTime = dts.timeNow("HH:mm:ss");
		
		objMap.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName);

		String strUpdatedDateTime = objMap.getUpdatedTime(objStatusTypes_data.strStatusNameInMulti);
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strTime = strUpdatedDateTime.split(" ");
		String[] strDate = strTime[0].split("\\(");

		String strRequiredUpdatedTime = dts.converDateFormat(strDate[0]
				+ strTime[1] + strCurYear + " " + strTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		String strRequiredUpdatedTimeForExcel = dts
				.converDateFormat(strRequiredUpdatedTime, "dd-MMM-yyyy HH:mm",
						"MM/dd/yyyy HH:mm");
		
		objLogin.clickLogOut();
		System.out.println(objUserdata.strNewUserName);
		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.clickOnStatusReports();

		String strCurrentDate = dts.timeNow("MM/dd/yyyy");
		String strStartAndEndDate = dts
				.converDateFormat(strCurrentDate, "MM/dd/yyyy",
						"dd-MMM-yyyy");

		objReport1.clickOnStatusReasonDetailsLink()
				.verStatusReasonDetailReportPgeIsDisplayed()
				.enterReportStartDate(strCurrentDate)
				.enterReportEndDate(strCurrentDate)
				.selectResources(strResourceValue[0]).clickOnNextBtn()
				.verStatusReasonDetailReportPge2IsDisplayed()
				.selStatusType(objStatuTypes_data.strMSTStatusTypeName)
				.clickOnNextBtn().verStatusReasonDetailReportPge3IsDisplayed()
				.selStatusReason(strReasonVal, strStatusesValues[0])
				.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);
		
		File file1 = new File(strDownloadName);
		boolean strPdf1 = file1.exists();
		
		String strReportGeneratedtime = dts.timeNow("HH:mm:ss");

		String strFetchAppDateTime = objEventManagement1.getApplicationTime();

		String[] strAppTime = strFetchAppDateTime.split(" ");

		String strRequiredAppEndTime = dts.converDateFormat(strAppTime[0]
				+ strAppTime[1] + strCurYear + " " + strAppTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		int intDurationDiff = dts.getTimeDiff1(strReportGeneratedtime,
				strUpdatedTime);

		double fltDurationDiff = (double) intDurationDiff / 3600;

		double dRounded = dts.roundTwoDecimals(fltDurationDiff);

		String strDurationDiffPDF = Double.toString(dRounded);
		System.out.println("PDF generation duration " + strDurationDiffPDF);

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1.clickOnStatusReasonDetailsLink()
				.verStatusReasonDetailReportPgeIsDisplayed()
				.enterReportStartDate(strCurrentDate)
				.enterReportEndDate(strCurrentDate)
				.selectResources(strResourceValue[0])
				.selectExcelReportRadioBtn().clickOnNextBtn()
				.verStatusReasonDetailReportPge2IsDisplayed()
				.selStatusType(objStatuTypes_data.strMSTStatusTypeName)
				.clickOnNextBtn().verStatusReasonDetailReportPge3IsDisplayed()
				.selStatusReason(strReasonVal, strStatusesValues[0])
				.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName1,
				strAutoITName);
		
		File file2 = new File(strDownloadName1);
		boolean strCsv1 = file2.exists();

		String strExcelReportGeneratedtime1 = dts.timeNow("HH:mm:ss");

		String strFetchAppDateTimeForExcel1 = objEventManagement1
				.getApplicationTime();

		String[] strAppTimeForExcel1 = strFetchAppDateTimeForExcel1.split(" ");

		String strRequiredAppEndTimeForExcel1 = dts.converDateFormat(
				strAppTimeForExcel1[0] + strAppTimeForExcel1[1] + strCurYear
						+ " " + strAppTimeForExcel1[2], "ddMMMyyyy HH:mm",
				"MM/dd/yyyy HH:mm");

		int intExcelDurationDiff1 = dts.getTimeDiff1(
				strExcelReportGeneratedtime1, strUpdatedTime);

		double fltExcelDurationDiff1 = (double) intExcelDurationDiff1 / 3600;

		double dExcelRounded1 = dts.roundTwoDecimals(fltExcelDurationDiff1);

		String strExcelDurationDiffPDF1 = Double.toString(dExcelRounded1);

		System.out.println("CSV generation duration "
				+ strExcelDurationDiffPDF1);

		String strVerUpdatedTime = strRequiredUpdatedTime;

		if (strPdf1) {
			String[] strTestData = {
					gstrTCID,
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword ,
					objLogin_data.strRegionName,
					"",
					"",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatusTypes_data.strMSTStatusTypeName,
					"",
					"",
					objReport_data.ExternalIP,
					"",
					"",
					strVerUpdatedTime,
					strDownloadName,
					strRequiredAppEndTime,
					objStatusReason_data.strReasonName,
					objStatusTypes_data.strStatusNameInMulti + ","
							+ objStatusTypes_data.strStatusNameInMulti1, strStartAndEndDate, strStartAndEndDate, strDurationDiffPDF, objStatusTypes_data.strStatusNameInMulti};

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}

		if (strCsv1) {
			String[] strTestDataForExcel = {
					gstrTCID,
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
							objLogin_data.strRegionName,
					objStatusTypes_data.strMSTStatusTypeName,
					objStatusTypes_data.strStatusNameInMulti + ","
							+ objStatusTypes_data.strStatusNameInMulti1,
					objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName, "", "",
					objStatusReason_data.strReasonName, strExcelDurationDiffPDF1,
					objReport_data.ExternalIP, strDownloadName1,
					strRequiredUpdatedTimeForExcel, strRequiredAppEndTimeForExcel1, objStatusTypes_data.strStatusNameInMulti};

			objOffCommonFunc.writeResultData(strTestDataForExcel,
					strPartialAutoResultsPath, "CSVDetails");
		}

		objLogin1.clickLogOut();

		if(strPdf1 &&  strCsv1){
			gstrResult = "PASS";
		}else{
			gstrResult = "FAIL";
		}
	}
	
	/******************************************************************************************
	'Description : Verify that a user can be provided the right 'Edit resources only'.
	'Date	 	 : 05-June-2015
	'Author		 : Anitha
	'------------------------------------------------------------------------------------------
	'Modified Date			                        	                  Modified By
	'Date					                                              Name
	*******************************************************************************************/
	@Test(description = " Verify that a user can be provided the right 'Edit resources only'.")
	public void testHappyDay66165() throws Exception {

		gstrTCID = "66165";
		gstrTO = " Verify that a user can be provided the right 'Edit resources only'.";

		Login_data objLogindata = new Login_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		View_data objView_data = new View_data();
		Roles_data objRolesData = new Roles_data();
		User_data objUserdata = new User_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);
		ResourceType objResourceType_Page = new ResourceType(this.driver1);
		Resource objResource_Page = new Resource(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		Views objViews1 = new Views(this.driver1);
		Map objMap1=new Map(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(this.driver1);

		String strStatusTypeValue[] = new String[1];
		String strResourceValue[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strRoleValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		StatusTypeList_page.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValue[0] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		// Resource type creation
		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType_Page
				.createResourceType(objResourceType_data.strResourceTypeName,
						strStatusTypeValue);
		
		strResourceTypeValue[0] = objResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource_Page.createResourceWithAddress(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);
		
		strResourceValue[0] = objResource_Page
				.getResourceValue(objResource_data.strResourceName);
		
		objResource_Page.createResourceWithAddress(
				objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);
		
		strResourceValue[1] = objResource_Page
				.getResourceValue(objResource_data.strResourceName1);
		
		System.out.println(objResource_data.strResourceName);
		
		// role
		objNavigationToSubmenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName)
				.clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);
		System.out.println(objRolesData.strRoleName);
		
		objNavigationToSubmenus.navigateToViews();
		
		String strResourceName[] = {objResource_data.strResourceName, objResource_data.strResourceName1};
		
		objViewsList.createViewForMultipleResources(objView_data.strViewName, objView_data.strViewDesc, strResourceName, objStatusTypes_data.strNSTStatusTypeName);
//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);
//
//		objViewsList.selectStatusType(objStatusTypes_data.strNSTStatusTypeName);
//
//		objViewsList.selectResourceType(strResourceTypeValue[0])
//				.clickOnSaveOfCreateNewView();

		objLogin.clickLogOut();
	
		System.out.println("---Precondition ends and test execution starts----");

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);
		
		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();
				
		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName1)
				.clickAdvancedOptionAndExpand()
				.selectEditResourcesOnlyOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();
		
		System.out.println(objUserdata.strNewUserName);
		
		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
		objResource1.navigateToResourceListPageNew()
				.verResourceInList(objResource_data.strResourceName)
				.verResourceNotInList(objResource_data.strResourceName1)
				.verCreateNewResourceButtonIsNotPresent()
				.clickOnEditLinkInResourcePage(objResource_data.strResourceName)
				.enterResourceName(objResource_data.strEditedResName)
				.enterResourceAbbrivation(objResource_data.strEditedResAbb)
				.clickOnSaveButton()
				.verResourceNameAndDetailsInResourceList(objResource_data.strEditedResName,
						objResource_data.strEditedResAbb, objResourceType_data.strResourceTypeName);

		//View
		objNavigationToSubmenus1.clickOnViewMenu();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);
		
		objViewsList1.clickOnResourceAndNavigateToResourceDetail(
				objResource_data.strEditedResName)
				.clickOnEditResourceDetailsLink();
			
		String str1EdResName = "1" + objResource_data.strEditedResName;
		String str1EdResAbb = "1" + objResource_data.strEditedResAbb;

		objResource1.enterResourceName(str1EdResName)
				.enterResourceAbbrivation(str1EdResAbb).clickOnSaveButton();

		objViews1.verResourceScreenDisplayed(str1EdResName);
		
		//View Map
		objNavigationToSubmenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(str1EdResName)
				.verResourceNameInPopupWindow(str1EdResName).clickOnEditInfo();

		String str2EdResName = "2" + objResource_data.strEditedResName;
		String str2EdResAbb = "2" + objResource_data.strEditedResAbb;
		System.out.println(str2EdResAbb);

		objResource1.enterResourceName(str2EdResName)
				.enterResourceAbbrivation(str2EdResName).clickOnSaveButton();

		objMap1.selectResourceNameInFindResourceDropdown(str2EdResName)
				.verResourceNameInPopupWindow(str2EdResName);
		
		objResource1.navigateToResourceListPageNew()

		.verResourceNotInList(objResource_data.strResourceName1);
		
		objNavigationToSubmenus1.clickOnViewMenu();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);
		
		objViews1.clickOnResource(objResource_data.strResourceName1);
		
		objViewsList1.verifyEditResourceDetailsLinkIsNotPresent();
		
		//View Map
		objNavigationToSubmenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName1)
				.verResourceNameInPopupWindow(objResource_data.strResourceName1)
				.verfyEditInfoLinkNotPresent();

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/***************************************************************************************
	'Description : Verify that a user can be provided the right to initiate chat session.
	'Date	 	 : 04-Jun-2015
	'Author		 : Hanumegowda
	'---------------------------------------------------------------------------------------
	'Modified Date:	07-Jan-2016		                        	Modified By: Sangappa K
	'Date					                                     Name
	****************************************************************************************/
	@Test(description = "Verify that a user can be provided the right to initiate chat session.")
	public void testHappyDay68420() throws Exception {

		gstrTCID = "68420";
		gstrTO = "Verify that a user can be provided the right to initiate chat session.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();

		Login objLogin = new Login(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		Regions objRegions = new Regions(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		InstantMessaging objInstantMessaging1 = new InstantMessaging(
				this.driver1);
		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
		objNavigationToSubmenus.navigateToRegions();
		objRegions.clickOnEditRegions(objLogindata.strRegionName)
				.selectInstantMessagingCheckbox().clickSaveButton();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectInstantMessagingInitiateChatSessionOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnIM();

		objRegionDefault1.switchToDefaultFrame();

		objInstantMessaging1.switchToInstantMessagingFrame()
				.verNewPrivateChatButtonIsDisplayed()
				.verNewConferenceButtonIsDisplayed()
				.clickOnNewPrivateChatButton().verCreateNewChatOneOfTwoWindow()
				.verListAllUsersRadioButtonIsDisplayed()
				.verFindUserRadioButtonIsDisplayed()
				.verFindUserForResourceRadioButtonIsDisplayed()
				.clickOnCancelButtonInPrivateChatWindow();
		Thread.sleep(5000);

		objInstantMessaging1.clickOnNewConferenceButton();
		objInstantMessaging1.verRoomNameFieldIsDisplayed()
				.verDescriptionFieldIsDisplayed()
				.clickOnCancelButtonInConferenceWindow();

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	/*********************************************************************************
	'Description : Verify that a user can be provided the right to generate Status Detail report.
	'Precondition:
	'Date	 	 : 05-Jun-2015
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************/
	@Test(description = "Verify that a user can be provided the right to generate Status Detail report.")
	public void testHappyDay68146() throws Exception {

		gstrTCID = "68146";
		gstrTO = "Verify that a user can be provided the right to generate Status Detail report.";

		Login_data objLogin_data = new Login_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		User_data objUserdata = new User_data();
		Date_Time_settings dts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();

		String strStatusTypeValues[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];

		String strStatusesValues[] = new String[2];
		
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.pdfFile;
		String fileType1 = objReport_data.csvFile;

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		Map objMap = new Map(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		UpdateStatus objUpdateStatus = new UpdateStatus(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;

		// Auto it path
		String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
		String strAutoItPath = ReadAutoItProperty
				.readDataFromAutoItPath(AutoIT_FILE_PATH);
		String strAutoITName = pathProps
				.getProperty(objReport_data.reportsDownloadAutoItName);
		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);
		
		File file = new File(System.getProperty("user.dir") + fileDownloadPath);
		String strDownloadName1 = file + "\\" + "TC"+gstrTCID+"_1" + "_" + strTimeText
				+ fileType;
		String strDownloadName2 = file + "\\" + "TC"+gstrTCID+"_2" + "_" + strTimeText
				+ fileType1;		
		
		objLogin.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList().createStatusType(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);
		
		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti, objStatuTypes_data.strStatusColor)
			.verCreatedStatusInStatusListForMulti(
					objStatusTypes_data.strStatusNameInMulti);
			strStatusesValues[0] = objStatusTypeList
			.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);
			
			objStatusTypeList.createNewStatus(
			objStatusTypes_data.strStatusNameInMulti1, objStatuTypes_data.strStatusColor)
			.verCreatedStatusInStatusListForMulti(
					objStatusTypes_data.strStatusNameInMulti1);
			strStatusesValues[1] = objStatusTypeList
			.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);
			
			objStatusTypeList.clickOnReturnToStatusTypeList();

			strStatusTypeValues[0] = objStatusTypeList
					.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);
			
		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);
		
		

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// create resource with address
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
		System.out.println(objResource_data.strResourceName);

		objLogin.clickLogOut();
		
		objLogin1.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegion1.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubMenus1.navigateToUsers();

		objUsersList1
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectReportStatusDetailOption().clickSaveButton()
				.verifyUserListPageIsDisplayed();
		
		System.out.println(objUserdata.strNewUserName);

		objLogin1.clickLogOut();
		
		System.out.println(objResource_data.strResourceName);
		System.out.println(objUserdata.strNewUserName);
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToMap();

		objMap.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus
				.selectStatusTypes(strStatusTypeValues[0])
				.selectMSTUpdateValue(strStatusTypeValues[0], strStatusesValues[0])
				.clickOnSaveButton();

		String strUpdatedTime = dts.timeNow("HH:mm:ss");

		objMap.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);

		String strUpdatedDateTime = objMap
				.getUpdatedTime(objStatusTypes_data.strStatusNameInMulti);
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strTime = strUpdatedDateTime.split(" ");
		String[] strDate = strTime[0].split("\\(");

		String strRequiredUpdatedTime = dts.converDateFormat(strDate[0]
				+ strTime[1] + strCurYear + " " + strTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		String strRequiredUpdatedTimeForExcel = dts
				.converDateFormat(strRequiredUpdatedTime, "dd-MMM-yyyy HH:mm",
						"M/dd/yyyy HH:mm");

		objNavigationToSubMenus1.clickOnStatusReports();

		String strReportDate = dts.timeNow("MM/dd/yyyy");
		String strStartAndEndDate = dts
		    .converDateFormat(strReportDate, "MM/dd/yyyy",
		      "dd-MMM-yyyy");

		objReport1
				.clickOnStatusDetail()
				.verStatusDetailReportPgeIsDisplayed()
				.enterReportStartDate(strReportDate)
				.enterReportEndDate(strReportDate)
				.selStatusType(objStatuTypes_data.strMSTStatusTypeName)
				.clickOnNextBtn()
				.verStatusDetailReportPge2IsDisplayed()		
				.verStatusTypeInStatusDetailReportPge2(
						objStatuTypes_data.strMSTStatusTypeName)
				.selectStatusCheckbox(strStatusesValues[0])
				.selectResources(strResourceValue[0])
				.clickOnGenerateReportBtn();

		String strReportGeneratedtime = dts.timeNow("HH:mm:ss");

		String strFetchAppDateTime = objEventManagement1.getApplicationTime();

		String[] strAppTime = strFetchAppDateTime.split(" ");

		String strRequiredAppEndTime = dts.converDateFormat(strAppTime[0]
				+ strAppTime[1] + strCurYear + " " + strAppTime[2],
				"ddMMMyyyy HH:mm", "dd-MMM-yyyy HH:mm");

		int intDurationDiff = dts.getTimeDiff1(strReportGeneratedtime,
				strUpdatedTime);

		double fltDurationDiff = (double) intDurationDiff / 3600;

		double dRounded = dts.roundTwoDecimals(fltDurationDiff);

		String strDurationDiffPDF = Double.toString(dRounded);
		System.out.println("PDF generation duration " + strDurationDiffPDF);

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName1,
				strAutoITName);
		 
		File file1 = new File(strDownloadName1);
		boolean strPdf1 = file1.exists();

		if (strPdf1) {
			String[] strTestData = {
					gstrTCID,
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objLogin_data.strRegionName2, "", "",
					objResource_data.strResourceName,
					objResourceType_data.strResourceTypeName,
					objStatusTypes_data.strNSTStatusTypeName, "", "",
					objReport_data.ExternalIP, "", "", strRequiredUpdatedTime,
					strDownloadName1, strRequiredAppEndTime, "", "",strStartAndEndDate,strStartAndEndDate,
					strDurationDiffPDF , objStatusTypes_data.strStatusNameInMulti};

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "PDFDetails");
		}
		
		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1
				.clickOnStatusDetail()
				.verStatusDetailReportPgeIsDisplayed()
				.enterReportStartDate(strReportDate)
				.enterReportEndDate(strReportDate)
				.selStatusType(objStatuTypes_data.strMSTStatusTypeName)
				.selectExcelReportRadioBtn()
				.clickOnNextBtn()
				.verStatusDetailReportPge2IsDisplayed()		
				.verStatusTypeInStatusDetailReportPge2(
						objStatuTypes_data.strMSTStatusTypeName)
				.selectStatusCheckbox(strStatusesValues[0])
				.selectResources(strResourceValue[0])
				.clickOnGenerateReportBtn();

		String strExcelReportGeneratedtime = dts.timeNow("HH:mm:ss");

		String strFetchAppDateTimeForExcel = objEventManagement1
				.getApplicationTime();

		String[] strAppTimeForExcel = strFetchAppDateTimeForExcel.split(" ");

		String strRequiredAppEndTimeForExcel = dts.converDateFormat(
				strAppTimeForExcel[0] + strAppTimeForExcel[1] + strCurYear
						+ " " + strAppTimeForExcel[2], "ddMMMyyyy HH:mm",
				"M/dd/yyyy HH:mm");

		System.out.println(strRequiredAppEndTimeForExcel);
		
		int intExcelDurationDiff = dts.getTimeDiff1(
				strExcelReportGeneratedtime, strUpdatedTime);

		double fltExcelDurationDiff = (double) intExcelDurationDiff / 3600;

		double dExcelRounded = dts.roundTwoDecimals(fltExcelDurationDiff);

		String strExcelDurationDiffPDF = Double.toString(dExcelRounded);

		System.out
				.println("CSV generation duration " + strExcelDurationDiffPDF);
		
		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName2,
				strAutoITName);
	
		File file2 = new File(strDownloadName2);
		boolean strCsv1 = file2.exists();
		
		if (strCsv1) {
			String[] strTestDataForExcel = {
					gstrTCID,
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					 objLogin_data.strRegionName2,
					objStatusTypes_data.strMSTStatusTypeName,
					"", objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName,
					"",
					"",
					"",
					strExcelDurationDiffPDF,
					objReport_data.ExternalIP,strDownloadName2,strRequiredUpdatedTimeForExcel,
					strRequiredAppEndTimeForExcel, objStatusTypes_data.strStatusNameInMulti};

			objOffCommonFunc.writeResultData(strTestDataForExcel,
					strPartialAutoResultsPath, "CSVDetails");
		}		
		objLogin1.clickLogOut();

		if(strPdf1&& strCsv1){
			gstrResult = "PASS";
		}else{
			gstrResult = "FAIL";
		}
	}
	
	/*********************************************************************************
	'Description : Verify that a user can be provided the right to setup status types.
	'Precondition:
	'Date	 	 : 05-Jun-2015
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date : 28-Sept-2016                      	Modified By: Pallavi
	'Date					                            Name
	**********************************************************************************/
	@Test(description = "Verify that a user can be provided the right to setup status types.")
	public void testHappyDay66134() throws Exception {

		gstrTCID = "66134";
		gstrTO = "Verify that a user can be provided the right to setup status types.";

		Login_data objLogin_data = new Login_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		User_data objUserdata = new User_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
	
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList1 = new StatusTypeList(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		
		String strStatusTypeValues[] = new String[1];
		String strStatusesValues[] = new String[3];	
		
		objLogin.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList().createStatusType(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);
		
		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti, objStatuTypes_data.strStatusColor)
			.verCreatedStatusInStatusListForMulti(
					objStatusTypes_data.strStatusNameInMulti);
			strStatusesValues[0] = objStatusTypeList
			.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);
			
			objStatusTypeList.createNewStatus(
			objStatusTypes_data.strStatusNameInMulti1, objStatuTypes_data.strStatusColor)
			.verCreatedStatusInStatusListForMulti(
					objStatusTypes_data.strStatusNameInMulti1);
			strStatusesValues[1] = objStatusTypeList
			.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);
			
			objStatusTypeList.createNewStatus(
			objStatusTypes_data.strStatusNameInMulti2, objStatuTypes_data.strStatusColor)
			.verCreatedStatusInStatusListForMulti(
					objStatusTypes_data.strStatusNameInMulti2);
			strStatusesValues[2] = objStatusTypeList
			.getStatusesValue(objStatusTypes_data.strStatusNameInMulti2);
			
			objStatusTypeList.clickOnReturnToStatusTypeList();

			strStatusTypeValues[0] = objStatusTypeList
					.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);
			
			objLogin.clickLogOut();

		
		objLogin1.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegion1.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubMenus1.navigateToUsers();

		objUsersList1
		.verifyUserListPageIsDisplayed()
				.clickCreateNewUserButton()
				.verifyCreateUserPageIsDisplayed()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.clickAdvancedOptionAndExpand()
				.selectSetupStatusTypesOption()
				.clickSaveButton()
				.searchUserName(objUserdata.strNewUserName,
							objUserdata.strRole, objUserdata.strResourceType,
							objUserdata.strUsername, objUserdata.strEquals);

		objLogin1.clickLogOut();
		
		System.out.println(objResource_data.strResourceName);
		System.out.println(objUserdata.strNewUserName);
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objStatusTypeList1.navigateToStatusTypeList()
						.verifyStatusTypeListPage()
						.createStatusType(
								objStatuTypes_data.strTextStatusType,
								objStatuTypes_data.strTSTStatusTypeName,
								objStatuTypes_data.strStatusDescription)
						.clickOnEditOfStatusType(objStatuTypes_data.strTSTStatusTypeName)
						.enterStatusTypeName(objStatuTypes_data.strTSTStatusTypeName1)
						.enterStatusTypeDescription(objStatuTypes_data.strStatusDescription2)
						.clickOnSaveButton()
						.verifyStatusTypeListPage()
						.verifyDescriptionColumnForST(objStatuTypes_data.strStatusDescription2, objStatuTypes_data.strTSTStatusTypeName1)
						.clickOnStatusesOfStatusType(objStatuTypes_data.strMSTStatusTypeName)
						.clickOnReorderStatuses()
						.reorderStatuses(objStatuTypes_data.strStatusNameInMulti, objStatuTypes_data.strStatusNameInMulti1)
						.reorderStatuses(objStatuTypes_data.strStatusNameInMulti, objStatuTypes_data.strStatusNameInMulti2)
						.reorderStatuses(objStatuTypes_data.strStatusNameInMulti1, objStatuTypes_data.strStatusNameInMulti2)
						.clickOnSaveButton()
						.clickOnReturnToStatusTypeList()
						.verifyMSTStatusesSort(objStatuTypes_data.strMSTStatusTypeName, objStatuTypes_data.strStatusNameInMulti, objStatuTypes_data.strOrder3)
						.verifyMSTStatusesSort(objStatuTypes_data.strMSTStatusTypeName, objStatuTypes_data.strStatusNameInMulti1, objStatuTypes_data.strOrder2)
						.verifyMSTStatusesSort(objStatuTypes_data.strMSTStatusTypeName, objStatuTypes_data.strStatusNameInMulti2, objStatuTypes_data.strOrder1)
						.clickOnStatusesOfStatusType(objStatuTypes_data.strMSTStatusTypeName)
						.createNewStatus(
								objStatusTypes_data.strStatusNameInMulti3, objStatuTypes_data.strStatusColor)
						.verCreatedStatusInStatusListForMulti(
								objStatusTypes_data.strStatusNameInMulti3)
						.clickOnReturnToStatusTypeList()
						.verifyStatusesColumnForST(objStatuTypes_data.strMSTStatusTypeName, objStatuTypes_data.strMultiStatusType, 
								objStatusTypes_data.strStatusNameInMulti3);
		objLogin1.clickLogOut();

			gstrResult = "PASS";

	}
	
	
	/*******************************************************************************
	'Description : Verify that a user can be provided the right to Maintain Document Library.
	'Precondition:
	'Date	 	 : 05-Jun-2015
	'Author		 : Sangappa.k
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************/
	@Test(description ="Verify that a user can be provided the right to Maintain Document Library.")
	public void testHappyDay68405() throws Exception {

		gstrTCID = "68405";
		gstrTO = " Verify that a user can be provided the right to Maintain Document Library.";
	
		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		RegionalInfo_data objRegionalInfo_data = new RegionalInfo_data();

		Login objLogin = new Login(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objNavigateToSubMenus = new NavigationToSubMenus(
				this.driver1);
		RegionalInfo objRegionalInfo = new RegionalInfo(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();

		Login objLogin2 = new Login(this.driver1);
		RegionDefault objRegionDefault2 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigateToSubMenus2 = new NavigationToSubMenus(
				this.driver1);
		RegionalInfo objRegionalInfo2 = new RegionalInfo(this.driver1);
		EventManagement objEventManagement2 = new EventManagement(this.driver1);

		String fileDownloadPath = pathProps
				.getProperty(objRegionalInfo_data.strFileUpload);

		String filePDFDownloadPath = pathProps
				.getProperty(objRegionalInfo_data.strPdfFileUpload);

		String fileHtmlDownloadPath = pathProps
				.getProperty(objRegionalInfo_data.strHtmlFileUpload);

		File file = new File(System.getProperty("user.dir") + fileDownloadPath);
		String strPath = file.toString();

		File Pdffile = new File(System.getProperty("user.dir")
				+ filePDFDownloadPath);
		String strPdfPath = Pdffile.toString();

		File HtMlfile = new File(System.getProperty("user.dir")
				+ fileHtmlDownloadPath);
		String strHtmlPath = HtMlfile.toString();

		objLogin.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigateToSubMenus.navigateToDocumentLibraryInRegionalInfo();
		objRegionalInfo.verDocumentLibraryPage().clickOnCreateNewFolder()
				.enterFolderName(objRegionalInfo_data.strFolderName)
				.clickOnCreateInAllFoldersRadioBtn();

		objEventManagement.clickOnSaveButton();
		
		String strFolderValue	= objRegionalInfo.getFolderValue(objRegionalInfo_data.strFolderName);


		objRegionalInfo.verFolderName(objRegionalInfo_data.strFolderName);

		// new user
		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selecMaintainDocumentLibraryOption().clickSaveButton()
				.verifyUserListPageIsDisplayed();
		objLogin.clickLogOut();

		objLogin2.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault2.selectFrame();

		objNavigateToSubMenus2.navigateToDocumentLibraryInRegionalInfo();
		objRegionalInfo2.verDocumentLibraryPage().clickOnCreateNewFolder()
				.enterFolderName(objRegionalInfo_data.strFolderName1)
				.clickOnCreateInAllFoldersRadioBtn();
		objEventManagement2.clickOnSaveButton();
		
		String strFolderValue1	= objRegionalInfo2.getFolderValue(objRegionalInfo_data.strFolderName1);

		objRegionalInfo2.verFolderName(objRegionalInfo_data.strFolderName1);
		//doc1
		objRegionalInfo2.clickOnAddNewDocument()
				.enterDocumentName(objRegionalInfo_data.strDocumentTitle)
				.selFolderForAddDoument(objRegionalInfo_data.strFolderName)
				.clickOnBrowse(strPath);
		objEventManagement2.clickOnSaveButton();

		objRegionalInfo2
				.expandCreatedFolder(objRegionalInfo_data.strFolderName)
				.verEditAndDeleteButtonsOfDocUnderFolder(
						objRegionalInfo_data.strFolderName);
		//doc2
		objRegionalInfo2.clickOnAddNewDocument()
				.enterDocumentName(objRegionalInfo_data.strDocumentTitle1)
				.selFolderForAddDoument(objRegionalInfo_data.strFolderName)
				.clickOnBrowse(strPdfPath);
		objEventManagement2.clickOnSaveButton();

		//doc3
		objRegionalInfo2.clickOnAddNewDocument()
				.enterDocumentName(objRegionalInfo_data.strDocumentTitle2)
				.selFolderForAddDoument(objRegionalInfo_data.strFolderName)
				.clickOnBrowse(strHtmlPath);
		objEventManagement2.clickOnSaveButton();

		objRegionalInfo2
				.expandCreatedFolder(objRegionalInfo_data.strFolderName);

		objRegionalInfo2
				.clickOnMoveBtnOfCorrespondingDoc(strFolderValue,
						objRegionalInfo_data.strDocumentTitle)

				.selRadioBtnForFolderToMoveDoc(
						objRegionalInfo_data.strFolderName1)
				.clcikOnMoveOfSelectedFolder()

				.expandCreatedFolder(objRegionalInfo_data.strFolderName)

				.verMovedDocIsNotDispayedInSourceFolder(
						objRegionalInfo_data.strFolderName,
						objRegionalInfo_data.strDocumentTitle)

				.expandCreatedFolder(objRegionalInfo_data.strFolderName1)

				.verMovedDocIsDispayedInDestinationFolder(strFolderValue1,
						objRegionalInfo_data.strDocumentTitle);

		objRegionalInfo2
				.deleteDocumentUnderFolder(strFolderValue,
						objRegionalInfo_data.strDocumentTitle1)
				.clickOnRename()
				.selRadioBtnForFolderToMoveDoc(
						objRegionalInfo_data.strFolderName).clickOnRenameBtn()
				.enterFolderName(objRegionalInfo_data.strRenamed);
		objEventManagement2.clickOnSaveButton();

		objRegionalInfo2
				.verFolderName(objRegionalInfo_data.strRenamed)
				.clickOnDeleteFolderBtn()
				.verDeleteDocumentsTooText()
				.selRadioBtnForFolderToMoveDoc(
						objRegionalInfo_data.strFolderName1)
				.selectDeleteDocumentsTooChkBox().clickOnDeleteOfFolder();
		objRegionalInfo2
				.verFolderNameIsNotDisplayedAfterDelete(objRegionalInfo_data.strFolderName1);
		objLogin2.clickLogOut();

		gstrResult = "PASS";
	}
	
	/****************************************************************************************************************
	'Description : Verify that a user can be provided the right to generate Event Snapshot report.
	'Precondition:
	'Date	 	 : 09-Jun-2015
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	******************************************************************************************************************/
	@Test(description = "Verify that a user can be provided the right to generate Event Snapshot report.")
	public void testHappyDay118731() throws Exception {

		gstrTCID = "118731";
		gstrTO = "Verify that a user can be provided the right to generate Event Snapshot report.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		Roles_data objRoles_data = new Roles_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		Date_Time_settings objDts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		Date_Time_settings dts = new Date_Time_settings();

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType1 = objReport_data.reportFile;

		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);

		String strstatusTypeValues[] = new String[6];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strRoleValue[] = new String[1];
		String strEveTemplateValue[] = new String[1];
		String strStatusesValues[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		UpdateStatus objUpdateStatus_Page1 = new UpdateStatus(this.driver1);
		
		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;

		// Auto it path
		String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
		String strAutoItPath = ReadAutoItProperty
				.readDataFromAutoItPath(AutoIT_FILE_PATH);
		String strAutoITName = pathProps
				.getProperty(objReport_data.reportsDownloadAutoItName);
		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);
		File file = new File(System.getProperty("user.dir") + fileDownloadPath);

		String strDownloadName1 = file + "\\" + gstrTCID + "_" + strTimeText
				+ fileType1;

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// RoleBased statustypes
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

		objStatusTypeList
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,	objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti1);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);
		
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);
		
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription);
				
		strstatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// create resource with address
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

		// Create role
		objNavigationToSubMenus.navigateToRoles();

		objRoles.createRole(objRoles_data.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRoles_data.strRoleName);

		// create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strstatusTypeValues);

		objEventManagement.clickOnSaveButton();

		strEveTemplateValue[0] = objEventManagement
				.getEventTemplateValue(objEventSetUp_data.strEventTemplate);

		// User creation
		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.selectReportEventSnapshotOption()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		System.out.println(objUser_data.strNewUserName);

		objLogin.clickLogOut();

		System.out.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		// create Event
		objEventManagement1.navigateToEventManagement()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue).clickOnSaveButton();

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);
		
		System.out.println(objResource_data.strResourceName);

		String[] strStatusTypeNames = {
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strDateStatusTypeName};

		for (int i = 0; i < strStatusTypeNames.length; i++) {

			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strStatusTypeNames[i]);
		}

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);
		System.out.println(objResource_data.strResourceName);

		objUpdateStatus_Page1
				.clickOnSelectAll()
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[0],
						objView_data.strValueForUpdate)
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[1],
						objView_data.strValueForUpdate)
				.enterUpdateSSTValues(strstatusTypeValues[3],
						objView_data.strValueForSST)
				.selectMSTUpdateValue(strstatusTypeValues[2],
						strStatusesValues[0])
				.enterNedocsUpdateValue(strstatusTypeValues[4],
						objView_data.strValueForNDST)
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[5],
						objView_data.strDateUpdateValue)		
				.clickOnSaveButton();

		String strEventStartTime = objEventManagement1.getApplicationTime();

		String strStartTime[] = strEventStartTime.split(":");

		String strStartTi[] = strEventStartTime.split(" ");

		String strStartTime1[] = strStartTime[0].split(" ");

		String strDate = strStartTime1[0];

		String strMonth = strStartTime1[1];

		String strHour = strStartTime1[2];

		String strMinute = strStartTime[1];

		String oneMinuteAdded = objDts.addTimetoExisting(strStartTi[2], 1,
				"HH:mm");

		String strStartTim1[] = oneMinuteAdded.split(":");

		String strHour1 = strStartTim1[0];

		String strMinute1 = strStartTim1[1];

		String strCurrentDate1 = objDts.getCurrentDate("MM/dd/yyyy HH:mm");

		String strStartTime2[] = strCurrentDate1.split(" ");

		String strCurrentDate = strStartTime2[0];

		String strYear[] = strCurrentDate.split("/");

		String strYear1 = strYear[2];

		String strTime = strDate + " " + strMonth + " " + strYear1;

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[0], objView_data.strValueForUpdate);

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[1], objView_data.strValueForUpdate);

		objUpdateStatus_Page1
				.verifyUpdatedStatusValues(strResourceValue[0],
						strstatusTypeValues[2],
						objStatuTypes_data.strStatusNameInMulti);

		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[3], objView_data.strUpdatedValForSST);
		
		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[4], objView_data.strNEDOCValue);
		
		objUpdateStatus_Page1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[5], objView_data.strDateUpdateValue);

		objNavigationToSubMenus1.navigateToEventReports();

		Thread.sleep(60000);

		objReport1.clickOnEventSnapshot()
		.selectExcelReportRadioBtn()
		.selectEventTemplate(strEveTemplateValue[0])
		.enterStartDate(strCurrentDate)
				.enterEndDate(strCurrentDate);

		objReport1.clickOnNextBtn()
				.selectEventRadioBtn(objEvent_data.strEventName)
				.enterSnapshotDate(strCurrentDate)
				.selectSnapshotTimeHour(strHour1)
				.selectSnapshotTimeMinutes(strMinute1)
				.clickOnGenerateReportBtn();
		
	

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName1,
				strAutoITName);
		
		File file2 = new File(strDownloadName1);
		boolean strCSV = file2.exists();

		objNavigationToSubMenus1.navigateToEventReports();

		objReport1.clickOnEventSnapshot().verifyEventSnapshotReport1stPage()
				.verifySearchStartDate().verifySearchEndDate()
				.enterStartDate(strCurrentDate).enterEndDate(strCurrentDate);

		objReport1.selectEventTemplate(strEveTemplateValue[0]);

		objReport1.clickOnNextBtn()
				.selectEventRadioBtn(objEvent_data.strEventName)
				.verifySnapshotDateAndTimeShouldFallBetweenOption()
				.verifySnapshotDateOption().verifySnapshotTimeHourOption()
				.verifySnapshotTimeMinutesOption()
				.enterSnapshotDate(strCurrentDate)
				.selectSnapshotTimeHour(strHour1)
				.selectSnapshotTimeMinutes(strMinute1);

		String mainWindowHandle = driver1.getWindowHandle();

		objReport1.clickOnGenerateReportBtn();

		System.out.println(objEvent_data.strEventName);

		Set<String> a = driver1.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		String TitleName = driver1.getTitle();
		assertTrue(TitleName.contains("Event Snapshot Report"));

		String strHeaderName[] = { objResourceType_data.strResourceTypeName,
				objStatuTypes_data.strDateStatusTypeName,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName, "Comment",
				"Last Update", "By User" };

		objReport1.verifyHeadersInHTMLEventSnapshotReport(strHeaderName);

		String[] strData = new String[] { objResource_data.strResourceName,
				strCurrentDate,
				objStatuTypes_data.strStatusNameInMulti,
				objView_data.strNEDOCVal,
				objView_data.strValueForUpdate,
				objView_data.strUpdatedValForSST,
				objView_data.strValueForUpdate, " ",
				strTime + " " + strHour + ":" + strMinute,
				objUser_data.strFullName };

		objReport1.verifDataInHTMLEventSnapshotReport(strData);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle);

		objRegionDefault1.selectFrame();

		if (strCSV) {
			String[] strTestDataForExcel = {
					gstrTCID,
					Login_data.strBuildName,
					objUser_data.strNewUserName + "/"
							+ objUser_data.strNewPassword,
					objTest_data.strRegionName,
					objStatuTypes_data.strNSTStatusTypeName,
					objStatuTypes_data.strTSTStatusTypeName + ","
							+ objStatuTypes_data.strMSTStatusTypeName + ", "
							+ objStatuTypes_data.strSSTStatusTypeName + ", "
							+ objStatuTypes_data.strNDSTStatusTypeName + ", "
							+ objStatuTypes_data.strDateStatusTypeName,
					objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName,
					"",
					"",
					"",
					"",
					objReport_data.ExternalIP,
					strDownloadName1,
					strTime + " " + strHour + ":" + strMinute,
					"",
					objStatuTypes_data.strStatusNameInMulti + ", "
							+ objView_data.strNEDOCVal + ", "
							+ objView_data.strValueForUpdate + ", "
							+ objView_data.strUpdatedValForSST + ", "
							+ objView_data.strValueForUpdate };

			objOffCommonFunc.writeResultData(strTestDataForExcel,
					strPartialAutoResultsPath, "CSVDetails");
		}

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	
	/*************************************************************************************
	'Description 	: Verify that a user can be provided the right to edit status change notification preferences. 
	'Precondition	: 
	'Date 			: 24-Nov-2014 
	'Author 		: Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that a user can be provided the right to edit status change notification preferences. ")
	public void testHappyDay69710() throws Exception {

		gstrTCID = "69710";
		gstrTO = "Verify that a user can be provided the right to edit status change notification preferences. ";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		View_data objView_data = new View_data();
		Date_Time_settings dts = new Date_Time_settings();
		NotificationValues objNotificationValues = new NotificationValues();
		
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
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		Map objMap1 = new Map(this.driver1);
		StatusChangePreference objStatusChangePreference1 = new StatusChangePreference(
				this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		
		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		
		objResourceType.navigateToResourceTypePage();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

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
		
		System.out.println(objResource_data.strResourceName);

		objNavigationToSubmenus.navigateToUsers();
		System.out.println(objUserdata.strNewUserName);
		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId).selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault1.selectFrame();
		
		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToUsers();
		
		objUsersList1
		.clickCreateNewUserButton()
		.enterAllUserDetails(objUserdata.strNewUserName1,
				objUserdata.strNewPassword, objUserdata.strFullName,
				objUserdata.strFirstName, objUserdata.strMiddleName,
				objUserdata.strLastName, objUserdata.strOrganization,
				objUserdata.strPhone, objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryMailId).selectFirstRole()
		.selectUpdateStatusOfResource(objResource_data.strResourceName)
		.clickAdvancedOptionAndExpand()
		.selectEditStatusChangeNotPrefernceOption().clickSaveButton()
		.verifyUserListPageIsDisplayed();
			
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateStatusChangeInPreferences();

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
				
		objStatusChangePreference1
					.verStatusTypesUnderUncategorizedSec(objStatusTypes_data.strNSTStatusTypeName)
					
		.enterAboveValues(strResourceValue[0], strStatusTypeValues[0],
				objNotificationValues.strAboveVal)
		.enterBelowValues(strResourceValue[0], strStatusTypeValues[0],
				objNotificationValues.strBelowVal)
		.selEmailPagerWebChkBoxesForAboveAndBelowVal(
				strResourceValue[0], strStatusTypeValues[0])	
		.clickOnSave();


		objLogin1.clickLogOut();
System.out.println(objUserdata.strNewUserName);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus1
				.selectStatusTypes(strStatusTypeValues[0])
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
						objView_data.strAboveValueForUpdate1)
				.clickOnSaveButton();

		String strFetchAppDateTime = objEventManagement1.getApplicationTime();
		String strCurYear = dts.getCurrentDate("yyyy");
		String[] strAppTime = strFetchAppDateTime.split(" ");

		String strUpdatedTime = dts.converDateFormat(strAppTime[0]
				+ strAppTime[1] + strCurYear + " " + strAppTime[2],
				"ddMMMyyyy HH:mm", "dd MMM yyyy HH:mm");

		System.out.println(strUpdatedTime);

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		objRegionDefault1.verWebNotificationframe();
		objUpdateStatus1
		.verWebNotificationForStatusUpdateForNST(
				objResource_data.strResourceName,
				objStatusTypes_data.strNSTStatusTypeName,objView_data.strAboveValueForUpdate1,
				strUpdatedTime);

		objUpdateStatus1.clickAcknowledgeAllNotifications().selectFrame();

		objLogin1.clickLogOut();

		String strSubject = "Status Change for "
				+ objResource_data.strResourceName;

		String strSubjectForPager = "Change for "
				+ objResource_data.strResourceAbbrivation;

		String strMsgBody1 = objMailVerificationFunctions
				.getStatusChangeEmailBodyForNST(objUserdata.strFullName,
						strUpdatedTime, objResource_data.strResourceName,
						objStatusTypes_data.strNSTStatusTypeName,
						objView_data.strAboveValueForUpdate1,
						objLogindata.strRegionName,objResourceType_data.strResourceTypeName);
		System.out.println(strMsgBody1);

		String strMsgBody2 = objMailVerificationFunctions
				.getStatusChangePagerBodyForNST(strUpdatedTime,
						objResource_data.strResourceName,
						objStatusTypes_data.strNSTStatusTypeName,
						objView_data.strAboveValueForUpdate1,
						objLogindata.strRegionName);
		System.out.println(strMsgBody2);


		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean boolCheck = false;
		boolean boolCheck1 = false;
		boolean boolCheck2 = false;
		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					strSubject);
			if (boolCheck == true) {
				boolCheck1 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody1);
			}
			
			if (boolCheck == false) {
				boolCheck = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody1);
			}
			objMailVerificationFunctions.backToMailInbox();
		}
		assertTrue(boolCheck && boolCheck1);

		objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
				strSubjectForPager);
		
		boolCheck2 = objMailVerificationFunctions
				.verifyMailBody(strMsgBody2);
		assertTrue(boolCheck2);
		objMailVerificationFunctions.logoutMail();
		gstrResult = "PASS";
	}

	/*************************************************************************************
	'Description 	: Verify that user with only 'Edit Resource' right and without update 
	                   right on resource cannot create sub-resources.
	'Date 			: 14-Aug-2015 
	'Author 		: Anitha
	'------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description ="Verify that user with only 'Edit Resource' right and without update"
			+ " right on resource cannot create sub-resources.")
	public void testHappyDay112141() throws Exception {

		gstrTCID = "112141";
		gstrTO = "Verify that user with only 'Edit Resource' right and without update "
				+ "right on resource cannot create sub-resources.";
		
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		Login_data objTest_data = new Login_data();
		View_data objView_data = new View_data();
		User_data objUser_data = new User_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();

		Login objLogin = new Login(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		Views objViews1 = new Views(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				driver1);

		String strStatusTypeValues[] = new String[2];

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

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

		String[] strstatusType1 = { strStatusTypeValues[0] };
		String[] strstatusType2 = { strStatusTypeValues[1] };

		// First resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusType1);

		objResourceType.createSubResourceType(
				objResourceType_data.strSubResourceTypeName, strstatusType2)
		               .verResourceTypeInList(objResourceType_data.strSubResourceTypeName);
		              
		// Resource creation
		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);
		
		objResource.clickOnStatusTypeLinkInResourcePage(objResource_data.strResourceName)
		.selectStatusType(strstatusType2)
		.clickOnSaveButton();

		// create view
		String[] strStatusTypeNames = {
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName };
		
		objResource.clickOnSubResourcesLink(objResource_data.strResourceName)
		.clickOnCreateNewSubResourceButton()
		.enterResourceName(objResource_data.strSubResourceName)
		.enterResourceAbbrivation(
				objResource_data.strResourceAbbrivation)
		.selectResourceTypename(
				objResourceType_data.strSubResourceTypeName)
		.enterResourceFirstName(objResource_data.strResourceFirstName)
		.enterResourceLastName(objResource_data.strResourceLastName)
		.clickOnSaveButton();

		objNavigationToSubMenus.navigateToViews();

		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc, objResource_data.strResourceName, strStatusTypeNames);
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

		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectEditResourcesOnlyOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		System.out.println(objUser_data.strNewUserName);

		objLogin.clickLogOut();

		System.out.println("------Precondiotion ends test execution starts-----");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objResource1.navigateToResourceListPageNew().verResourceInNotInList(
				objResource_data.strResourceName);

		objNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViews1.clickOnResource(objResource_data.strResourceName)
				.verViewResourceDetailsPgeIsDisplayed();

		objResource1.verCreateNewSubResourceButtonIsNotPresent();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	/*************************************************************************************
	'Description 	: Verify that user with only 'Edit Resource' right and without update 
	                   right on resource cannot create sub-resources.
	'Date 			: 14-Aug-2015 
	'Author 		: Anitha
	'------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description ="Verify that user with 'Setup Resources' right and update right on a "
			+ "resource can create sub-resources under it.")
	public void testHappyDay112140() throws Exception {

		gstrTCID = "112140";
		gstrTO = "Verify that user with 'Setup Resources' right and update right on a resource"
				+ " can create sub-resources under it.";
		
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();

		Login objLogin = new Login(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Resource objResource1 = new Resource(this.driver1);

		String strStatusTypeValues[] = new String[2];

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

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

		String[] strstatusType1 = { strStatusTypeValues[0] };
		String[] strstatusType2 = { strStatusTypeValues[1] };

		// First resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusType1);

		objResourceType.createSubResourceType(
				objResourceType_data.strSubResourceTypeName, strstatusType2)
		               .verResourceTypeInList(objResourceType_data.strSubResourceTypeName);
		              
		// Resource creation
		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName)
		
		.createResource(
				objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName1)
				.clickAdvancedOptionAndExpand().selectSetupResourceOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		System.out.println(objUser_data.strNewUserName);

		objLogin.clickLogOut();

		System.out.println("------Precondiotion ends test execution starts-----");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objResource1.navigateToResourceListPageNew()
				.verResourceInList(objResource_data.strResourceName)
				.verResourceInList(objResource_data.strResourceName1)
				.clickOnSubResourcesLink(objResource_data.strResourceName)
				.verSubResourceListPageIsDisplayed(
						objResource_data.strResourceName)
			    .verCreateNewSubResourceButtonIsPresent()
			    
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
						objResource_data.strResourceName)
				.verSubResourceInSubResPage(objResource_data.strSubResourceName)
				.verEditLinkForSubResource(objResource_data.strSubResourceName)
				.verIconForSubResource(objResource_data.strSubResourceName,
						objResource_data.strSubResourceIcon)
				.verSubResourceAbbInSubResPage(
						objResource_data.strSubResourceName,
						objResource_data.strResourceAbbrivation)
				.verSubResTypeForSubResourInSubResPage(
						objResource_data.strSubResourceName,
						objResourceType_data.strSubResourceTypeName);

		objResource1
				.navigateToResourceListPage()
				.verSubResources1LinkInResourceList(
						objResource_data.strResourceName)
				.clickOnSubResourcesLink(objResource_data.strResourceName1)
				.verSubResourceListPageIsDisplayed(
						objResource_data.strResourceName1)
				.verCreateNewSubResourceButtonIsPresent();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description 	: Verify that user with 'Edit Resource Only' right and update right on
	                  a resource can create sub-resources for their facility.
	'Date 			: 14-Aug-2015 
	'Author 		: Anitha
	'------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description ="Verify that user with 'Edit Resource Only' right and update right on a "
			+ "resource can create sub-resources for their facility.")
	public void testHappyDay112138() throws Exception {

		gstrTCID = "112138";
		gstrTO = "Verify that user with 'Edit Resource Only' right and update right on a resource can"
				+ " create sub-resources for their facility.";
		
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		Resource_data objResource_data = new Resource_data();
		View_data objView_data = new View_data();
		ResourceType_data objResourceType_data = new ResourceType_data();

		Login objLogin = new Login(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		Views objViews1 = new Views(this.driver1);
		ViewsList ViewsList1 = new ViewsList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[2];

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

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

		String[] strstatusType1 = { strStatusTypeValues[0] };
		String[] strstatusType2 = { strStatusTypeValues[1] };

		// First resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusType1);

		objResourceType.createSubResourceType(
				objResourceType_data.strSubResourceTypeName, strstatusType2)
		               .verResourceTypeInList(objResourceType_data.strSubResourceTypeName);
		              
		// Resource creation
		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName)
		
		.createResource(
				objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName1)
				.clickAdvancedOptionAndExpand().selectEditResourcesOnlyOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		System.out.println(objUser_data.strNewUserName);

		objNavigationToSubmenus.navigateToViews();

		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc, objResource_data.strResourceName, objStatuTypes_data.strNSTStatusTypeName);
//		objViewsList.clickCreateNewViewButton()	
//					.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);
//
//		objViewsList.selectStatusType(objStatuTypes_data.strNSTStatusTypeName);
//
//		objViewsList.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();
		
		objLogin.clickLogOut();

		System.out.println("------Precondiotion ends test execution starts-----");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objResource1
				.navigateToResourceListPageNew()
				.verResourceInList(objResource_data.strResourceName)
				.verResourceInNotInList(objResource_data.strResourceName1)
				.clickOnSubResourcesLink(objResource_data.strResourceName)
				.verSubResourceListPageIsDisplayed(
						objResource_data.strResourceName)
				.verCreateNewSubResourceButtonIsPresent();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViews1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		objViews1.verStatusTypes(objResourceType_data.strResourceTypeName,
				objStatuTypes_data.strNSTStatusTypeName);

		ViewsList1
				.clickOnResourceAndNavigateToResourceDetail(objResource_data.strResourceName);

		objViews1.verifyCreateNewSubResourceBtnUnderSubResourceSection();

		objResource1
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
				.clickOnSaveButton();

		objViews1.verViewResourceDetailsPgeIsDisplayed();

		objResource1.navigateToResourceListPageNew()
				.verSubResources1LinkInResourceList(
						objResource_data.strResourceName);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	/*************************************************************************************
	'Description 	: Verify that user with 'Setup Resources' right and without update right 
	                  on a resource can create sub-resources under it.
	'Date 			: 14-Aug-2015 
	'Author 		: Anitha
	'------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description ="Verify that user with 'Setup Resources' right and without update right "
			+ "on a resource can create sub-resources under it.")
	public void testHappyDay112339() throws Exception {

		gstrTCID = "112339";
		gstrTO = "Verify that user with 'Setup Resources' right and without update right on a "
				+ "resource can create sub-resources under it.";
		
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		Resource_data objResource_data = new Resource_data();
		View_data objView_data = new View_data();
		ResourceType_data objResourceType_data = new ResourceType_data();

		Login objLogin = new Login(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		Views objViews1 = new Views(this.driver1);
		ViewsList ViewsList1 = new ViewsList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[2];

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

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

		String[] strstatusType1 = { strStatusTypeValues[0] };
		String[] strstatusType2 = { strStatusTypeValues[1] };

		// First resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusType1);

		objResourceType.createSubResourceType(
				objResourceType_data.strSubResourceTypeName, strstatusType2)
		               .verResourceTypeInList(objResourceType_data.strSubResourceTypeName);
		              
		// Resource creation
		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);
				
		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectSetupResourceOption()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();

		System.out.println(objUser_data.strNewUserName);

		objNavigationToSubmenus.navigateToViews();

		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc, objResource_data.strResourceName, objStatuTypes_data.strNSTStatusTypeName);
//		objViewsList.clickCreateNewViewButton()	
//					.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);
//
//		objViewsList.selectStatusType(objStatuTypes_data.strNSTStatusTypeName);
//
//		objViewsList.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();
		
		objLogin.clickLogOut();

		System.out.println("------Precondiotion ends test execution starts-----");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objResource1
				.navigateToResourceListPageNew()
				.verResourceInList(objResource_data.strResourceName)
				.clickOnSubResourcesLink(objResource_data.strResourceName)
				.verSubResourceListPageIsDisplayed(
						objResource_data.strResourceName)
				.verCreateNewSubResourceButtonIsPresent();

		objResource1
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
						objResource_data.strResourceName)
				.verSubResourceInSubResPage(objResource_data.strSubResourceName)
				.verEditLinkForSubResource(objResource_data.strSubResourceName)
				.verIconForSubResource(objResource_data.strSubResourceName,
						objResource_data.strSubResourceIcon)
				.verSubResourceAbbInSubResPage(
						objResource_data.strSubResourceName,
						objResource_data.strResourceAbbrivation)
				.verSubResTypeForSubResourInSubResPage(
						objResource_data.strSubResourceName,
						objResourceType_data.strSubResourceTypeName);

		objResource1.navigateToResourceListPage()
				.verSubResources1LinkInResourceList(
						objResource_data.strResourceName);

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViews1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		objViews1.verStatusTypes(objResourceType_data.strResourceTypeName,
				objStatuTypes_data.strNSTStatusTypeName);

		ViewsList1
				.clickOnResourceAndNavigateToResourceDetail(objResource_data.strResourceName);

		objViews1.verifyCreateNewSubResourceBtnUnderSubResourceSection();

		objResource1
				.clickOnCreateNewSubResourceButton()
				.verCreateNewSubResourceForPageIsDisplayed(
						objResource_data.strResourceName)
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

		objResource1.navigateToResourceListPageNew()
				.verSubResources2LinkInResourceList(
						objResource_data.strResourceName);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	/*************************************************************************************
	'Description 	: Verify that a user can be provided the right to update region setup information.
	'Date 			: 17-Dec-2015 
	'Author 		: Sangappa K
	'------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description ="Verify that a user can be provided the right to update region setup information.")
	public void testHappyDay66072() throws Exception {

		gstrTCID ="66072";
		gstrTO = "Verify that a user can be provided the right to update region setup information.";
		
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();

		Login objLogin = new Login(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		Map objMap = new Map(this.driver1);
		Regions objRegions1 = new Regions(this.driver1);

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		// User creation
		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectMayUpdateRegionSetupInformationOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)

				.verFullName(objUser_data.strNewUserName,
						objUser_data.strFullName);
		System.out.println(objUser_data.strNewUserName);
		objLogin.clickLogOut();

		System.out
				.println("------Precondiotion ends test execution starts-----");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToRegions();

		objRegions1.verRegionInRegionListPage(objTest_data.strRegionName)
				.clickOnEditRegions(objTest_data.strRegionName)
				.verEditRegiontPageIsDisplayed()
				.enterRegionName(objTest_data.strRegionName)
				.enterFirstName(objUser_data.strEditedFirstName)
				.enterLastName(objUser_data.strEditedLastName)
				.clickSaveButton()

				.verRegionInRegionListPage(objTest_data.strRegionName);
		objNavigationToSubmenus1.navigateToMap();
		objMap.verifyRegionalMapViewPgeIsDisplayed()
				.verAndClickSaveAsRegionBtn();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	/***************************************************************************************************************
	 * 'Description : Verify that a user can be provided the right to generate Status Summary report.
	 * 'Date : 22-Dec-2015 
	 * 'Author : Sangappa.k
	 ***************************************************************************************************************/

	@Test(description ="Verify that a user can be provided the right to generate Status Summary report.")
	public void testHappyDay68131() throws Exception {
		
		gstrTCID ="68131";
		gstrTO ="Verify that a user can be provided the right to generate Status Summary report.";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Date_Time_settings dts = new Date_Time_settings();
		Report_data objReport_data = new Report_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);

		String strstatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strStatusesValues[] = new String[2];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Report objReport1 = new Report(this.driver1);
		UpdateStatus objUpdateStatus_Page1 = new UpdateStatus(this.driver1);
		AutoIT objAutoIT = new AutoIT(this.driver1);
		Map objMap1 = new Map(this.driver1);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();

		String strTimeText = dts.getCurrentDate(objReport_data.dateFormat1);
		String fileType = objReport_data.csvFile;

		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;

		// Auto it path
		String AutoIT_FILE_PATH = objReport_data.reportsDownloadAutoItPath;
		String strAutoItPath = ReadAutoItProperty
				.readDataFromAutoItPath(AutoIT_FILE_PATH);

		String strAutoITName = pathProps
				.getProperty(objReport_data.reportsDownloadAutoItName);

		String fileDownloadPath = pathProps
				.getProperty(objReport_data.reportsDownloadPath);

		File file = new File(System.getProperty("user.dir") + fileDownloadPath);

		String strDownloadName = file + "\\" + "TC68131" + "_" + strTimeText
				+ fileType;

		String strDownloadName1 = file + "\\" + "TC168131" + "_" + strTimeText
				+ fileType;

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// create RoleBased statustypes
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription)

		.createNewStatus(objStatuTypes_data.strStatusNameInMulti1,
				objStatuTypes_data.strStatusColor);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti1);

		objStatusTypeList.createNewStatus(
				objStatuTypes_data.strStatusNameInMulti2,
				objStatuTypes_data.strStatusColor);

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatuTypes_data.strStatusNameInMulti2);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

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
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectRunReportsCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectReportStatusSummaryOption().clickSaveButton()
				.verifyUserListPageIsDisplayed();

		System.out.println(objUser_data.strNewUserName);
		System.out.println(objResource_data.strResourceName);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		Thread.sleep(5000);

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus_Page1.selectStatusTypes(strstatusTypeValues[0])
				.selectMSTUpdateValue(strstatusTypeValues[0],
						strStatusesValues[0]);

		objUpdateStatus_Page1.clickOnSaveButton();

		String strAppTime = objEventManagement1.getApplicationTime();

		String updatedtime = "(" + strAppTime + " " + objTest_data.timeZone
				+ ")";

		System.out.println(updatedtime);

		String strCurrentDate = dts.timeNow("MM/dd/yyyy");

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1.clickOnStatusSummaryLink()
				.enterReportStartDate(strCurrentDate)
				.enterReportEndDate(strCurrentDate).selectCSVRadioBtn()
				.selectResources(strResourceValue[0]).clickOnNextStepBtn();

		Thread.sleep(5000);

		objReport1.selectStatusType(objStatuTypes_data.strMSTStatusTypeName)
				.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName,
				strAutoITName);

		Thread.sleep(50000);

		File file1 = new File(strDownloadName);
		boolean strCsv1 = file1.exists();

		if (strCsv1) {
			String[] strTestData = {
					"68131",
					Login_data.strBuildName,
					objUser_data.strNewUserName + "/"
							+ objUser_data.strNewPassword,
					objTest_data.strRegionName,
					objStatuTypes_data.strMSTStatusTypeName,
					objStatuTypes_data.strStatusNameInMulti1 + ","
							+ objStatuTypes_data.strStatusNameInMulti2,
					objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName, "", "", "", "",
					objReport_data.ExternalIP, strDownloadName,
					updatedtime + "/" + strCurrentDate };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "CSVDetails");
		}

		Thread.sleep(5000);

		objRegionDefault1.switchToDefaultFrame().selectFrame();

		Thread.sleep(5000);

		objNavigationToSubMenus1.clickOnStatusReports();

		objReport1.clickOnStatusSummaryLink()
				.enterReportStartDate(strCurrentDate)
				.enterReportEndDate(strCurrentDate)
				.selectResources(strResourceValue[0]).clickOnNextStepBtn()
				.selectStatusType(objStatuTypes_data.strMSTStatusTypeName)
				.clickOnGenerateReportBtn();

		objAutoIT.DownloadTheReports(strAutoItPath, strDownloadName1,
				strAutoITName);

		Thread.sleep(50000);

		File file2 = new File(strDownloadName1);
		boolean strCsv2 = file2.exists();

		if (strCsv2) {
			String[] strTestData1 = {
					"68131",
					Login_data.strBuildName,
					objUser_data.strNewUserName + "/"
							+ objUser_data.strNewPassword,
					objTest_data.strRegionName,
					objStatuTypes_data.strMSTStatusTypeName,
					objStatuTypes_data.strStatusNameInMulti1 + ","
							+ objStatuTypes_data.strStatusNameInMulti2,
					objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName, "", "", "", "",
					objReport_data.ExternalIP, strDownloadName1,
					updatedtime + "/" + strCurrentDate };

			objOffCommonFunc.writeResultData(strTestData1,
					strPartialAutoResultsPath, "PDFDetails");
		}

		objLogin1.clickLogOut();

		if (strCsv1 && strCsv2) {
			gstrResult = "PASS";
		} else {
			gstrResult = "FAIL";
		}
	}

}
