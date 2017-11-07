package requirementGroup.SetUp;

import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.ChangePassword;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Regions;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UpdateUserInfo;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class HappyDayDelegatedUserManagement extends TestNG_UI_EXTENSIONS {

	public HappyDayDelegatedUserManagement() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/******************************************************************************************
	 * 'Description : Verify that user with 'Resource Admin' right can change password of users
	 *                who have affiliated right on resources.
	 * 'Date        : 4-Dec-2015
	 * 'Author      : Anil
	 ******************************************************************************************/
	@Test(description = "Verify that user with 'Resource Admin' right can change password of users"
			+ " who have affiliated right on resources.")
	public void testHappyDay139635() throws Exception {

		gstrTCID = "139635";
		gstrTO = "Verify that user with 'Resource Admin' right can change password of users who have "
				+ "affiliated right on resources.";

		// Objects for data
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();

		// Objects of Page for Fire fox Browser
		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);

		// Objects of Page for IE Browser
		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		UsersList UsersList_page1 = new UsersList(this.driver1);
		ChangePassword objChangePassword1 = new ChangePassword(this.driver1);

		String strstatusTypeValues[] = new String[5];
		String strResourceValue[] = new String[4];
		String strstatusesValue[] = new String[1];

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page
				.selectRegionAndNavigate(objTest_data.strQuickLinkRegion);

		RegionDefault_page.selectFrame();

		// Status type creation
		StatusTypeList_page.navigateToStatusTypeList().createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[0] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		// Status type creation
		StatusTypeList_page.createStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		StatusTypeList_page.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusColor);

		strstatusesValue[0] = StatusTypeList_page
				.getMSTStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		StatusTypeList_page.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
			      				objStatusTypes_data.strStatusColor)
			      			.verCreatedStatusInStatusListForMulti(
			      						objStatusTypes_data.strStatusNameInMulti1)
			      			.clickOnReturnToStatusTypeList();

		strstatusTypeValues[1] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		// Status type creation
		StatusTypeList_page.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[2] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		// Status type creation
		StatusTypeList_page.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[3] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		// Status type creation
		StatusTypeList_page.createStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[4] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		String strstatusTypeValues1[] = { strstatusTypeValues[0],
				strstatusTypeValues[1], strstatusTypeValues[4] };
		String strstatusTypeValues2[] = { strstatusTypeValues[2],
				strstatusTypeValues[3] };

		// Resource type creation
		ResourceType_Page.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues1);

		// Resource type creation
		ResourceType_Page
				.createResourceType(objResourceType_data.strResourceTypeName1,
						strstatusTypeValues2);

		// Resource creation
		Resource_Page.navigateToResourceListPage().createResource(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName);

		// Resource creation
		Resource_Page.createResource(objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[1] = Resource_Page
				.getResourceValue(objResource_data.strResourceName1);

		// Resource creation
		Resource_Page.createResource(objResource_data.strResourceName2,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName1,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[2] = Resource_Page
				.getResourceValue(objResource_data.strResourceName2);

		// Resource creation
		Resource_Page.createResource(objResource_data.strResourceName3,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName1,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[3] = Resource_Page
				.getResourceValue(objResource_data.strResourceName3);
		// User creation

		// User U1
		UsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserMandatoryDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectFirstUserCanAssignRole()
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionalUserAccessOption()
				.selectAdministerUsersOfResource(
						objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectAdministerUsersOfResource(
						objResource_data.strResourceName1)
				.selectUpdateStatusOfResource(objResource_data.strResourceName1)
				.selectAdministerUsersOfResource(
						objResource_data.strResourceName2)
				.selectUpdateStatusOfResource(objResource_data.strResourceName2)
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		// User U2
		UsersList_page
				.clickCreateNewUserButton()
				.enterUserMandatoryDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName1)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName1)
				.selectUpdateStatusOfResource(objResource_data.strResourceName2)
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName1);

		login_page.clickLogOut();

		System.out
				.println("----Precondition ends and Testcase execution starts----");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		UsersList_page1
				.navigateToUsers()

				.clickOnIncludeInactiveChkBox()

				.searchUserName(objUser_data.strNewUserName1,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.verifyEditAndPasswordLinkIsDisplayed(
						objUser_data.strNewUserName1)
				.clickOnPasswordLink(objUser_data.strNewUserName1);

		objChangePassword1
				.switchTochangePwdFrame()
				.verChangePwdWindow()
				.changePassword(objUser_data.strNewPassword1,
						objUser_data.strNewPassword1)
				.verPasswordStatusScreenIsDisplayedNew().clickOnClose();

		login_page1.clickLogOut();

		login_page1.loginToApplication(objUser_data.strNewUserName1,
				objUser_data.strNewPassword);

		login_page1.verifyInvalidUsernameAndPwdError();

		login_page1.loginAsNewUserForPasswordChange(
				objUser_data.strNewUserName1, objUser_data.strNewPassword1);

		RegionDefault_page1.selectFrame()

		.verifyRegionDefaultPage();
		
		login_page1.clickLogOut();
		
		gstrResult = "PASS";
	}
	/***********************************************************************************************
	 * 'Description : Verify that user with 'Configure Regional User Access' right can create users.
	 * 'Date        : 10-Dec-2015
	 * 'Author      : Anitha
	 ***********************************************************************************************/
	@Test(description = "Verify that user with 'Configure Regional User Access' right can create users.")
	public void testHappyDay138768() throws Exception {

		gstrTCID = "138768";
		gstrTO = "Verify that user with 'Configure Regional User Access' right can create users.";

		// Objects for data
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();

		// Objects of Page for Fire fox Browser
		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);

		// Objects of Page for IE Browser
		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		UsersList UsersList_page1 = new UsersList(this.driver1);

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page
				.selectRegionAndNavigate(objTest_data.strQuickLinkRegion);

		RegionDefault_page.selectFrame();

		// User U1 creation
		UsersList_page
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserMandatoryDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionalUserAccessOption()
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		login_page.clickLogOut();

		System.out
				.println("----Precondition ends and Testcase execution starts----");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		UsersList_page1
				.navigateToUsers()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.verifyEditAndPasswordLinkIsDisplayed(
						objUser_data.strNewUserName)
				.clickCreateNewUserButton()
				.enterUserMandatoryDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName1)
				.selectFirstRole()
				.verAdvancedOptionIsPresent()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName1,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.verifyEditAndPasswordLinkIsDisplayed(
						objUser_data.strNewUserName1);

		login_page1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/**************************************************************************
	 * 'Description :Verify that user with 'Configure Regional User Access' right can edit users.
	 * 'Date        : 10-Dec-2015
	 * 'Author      : Sangappa K
	 **************************************************************************/
	@Test(description ="Verify that user with 'Configure Regional User Access' right can edit users.")
	public void testHappyDay138904() throws Exception {

		gstrTCID ="138904";
		gstrTO = "Verify that user with 'Configure Regional User Access' right can edit users.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		UpdateUserInfo objUpdateUserInfo1 = new UpdateUserInfo(this.driver1);

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

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
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionalUserAccessOption().clickSaveButton();

		System.out.println(objUserdata.strNewUserName);

		objLogin.clickLogOut();

		System.out
				.println("------precondtion ends and test execution starts-------");
		
	

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		objNavigationToSubmenus1.navigateToUsers();
		objUsersList1
				.verifyUserListPageIsDisplayed()
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.verUserDetails(objUserdata.strNewUserName,
						objUserdata.strFullName, objUserdata.strOrganization)
				.verifyEditAndPasswordLinkIsDisplayed(
						objUserdata.strNewUserName)
				.editUserDetails(objUserdata.strNewUserName)
				.verifyEditUserPageIsDisplayed()
				.enterOrganization(objUserdata.strEditedOrganization1)
				.enterPhone(objUserdata.strEditedPhone1)
				.enterFullName(objUserdata.strEditedFullName1)
				.enterEmail(objUserdata.strEmail)
				.enterPrimaryEmailId(objUserdata.strEmail)
				.entertextPagerId(objUserdata.strEmail)
				.clickSaveButton()
				.verifyUserListPageIsDisplayed()
				.verUserDetails(objUserdata.strNewUserName,
						objUserdata.strEditedFullName1,
						objUserdata.strEditedOrganization1);

		objNavigationToSubmenus1.navigateToUsersInfoInPreferences();

		objUpdateUserInfo1
				.verUpdateUserInfoIsDisplayed()

				.verifyUserDetailsAreRetrieved(objUserdata.strEditedFullName1,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName,
						objUserdata.strEditedOrganization1,
						objUserdata.strEditedPhone1, objUserdata.strEmail,
						objUserdata.strEmail, objUserdata.strEmail)
				.clickOnSaveButton();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	/***********************************************************************************************************
	 * 'Description : Verify that options 'User Has Role', 'User Can Assign Role' and 'Administer Users' are
	 *                available for users only in regions in which 'DELEGATED USER MANAGEMENT' option is enabled.
	 * 'Date        : 10-Dec-2015
	 * 'Author      : Anitha
	 ***********************************************************************************************************/
	@Test(description = "Verify that options 'User Has Role', 'User Can Assign Role' and 'Administer Users' are "
			+ "available for users only in regions in which 'DELEGATED USER MANAGEMENT' option is enabled.")
	public void testHappyDay138752() throws Exception {

		gstrTCID = "138752";
		gstrTO = "Verify that options 'User Has Role', 'User Can Assign Role' and 'Administer Users' are "
				+ "available for users only in regions in which 'DELEGATED USER MANAGEMENT' option is enabled.";

		// Objects for data
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();

		// Objects of Page for Fire fox Browser
		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);

		// Objects of Page for IE Browser
		Login login_page1 = new Login(this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		UsersList UsersList_page1 = new UsersList(this.driver1);

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page
				.selectRegionAndNavigate(objTest_data.strQuickLinkRegion);

		RegionDefault_page.selectFrame();

		// User U1 creation
		UsersList_page
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserMandatoryDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		login_page.clickLogOut();

		System.out
				.println("----Precondition ends and Testcase execution starts----");

		login_page1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page1
				.selectRegionAndNavigate(objTest_data.strQuickLinkRegion);

		RegionDefault_page1.selectFrame();

		UsersList_page1
				.navigateToUsers()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName)
				.verUserHasRoleIsPresent().verUserCanAssignRoleIsPresent()
				.verAdministerUsersIsPresent();

		SelectRegion_page1.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page1.selectFrame();

		UsersList_page1.navigateToUsers().clickCreateNewUserButton()
				.verUserHasRoleIsNotPresent()
				.verUserCanAssignRoleIsNotPresent()
				.verAdministerUsersIsNotPresent().verRolesIsPresent();

		login_page1.clickLogOut();

		gstrResult = "PASS";
	}
	/******************************************************************************************
	 * 'Description :  Verify that user with 'Resource Admin' right can deactivate users for his/her resources.
	 * 'Date        : 11-Dec-2015
	 * 'Author      : Sangappa k
	 ******************************************************************************************/
	@Test(description ="Verify that user with 'Resource Admin' right can deactivate users for his/her resources.")
	public void testHappyDay138909() throws Exception {

		gstrTCID ="138909";
		gstrTO ="Verify that user with 'Resource Admin' right can deactivate users for his/her resources.";
		
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		UsersList UsersList_page1 = new UsersList(this.driver1);
		

		String strstatusTypeValues[] = new String[2];
		String strResourceValue[] = new String[4];
		String strstatusesValue[] = new String[1];

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page
				.selectRegionAndNavigate(objTest_data.strQuickLinkRegion);

		RegionDefault_page.selectFrame();

		// Status type creation
		StatusTypeList_page.navigateToStatusTypeList().createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[0] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		StatusTypeList_page.createStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		StatusTypeList_page.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusColor);

		strstatusesValue[0] = StatusTypeList_page
				.getMSTStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		StatusTypeList_page.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
						      	objStatusTypes_data.strStatusColor)
						   .verCreatedStatusInStatusListForMulti(
						          objStatusTypes_data.strStatusNameInMulti1)
			          	   .clickOnReturnToStatusTypeList();

		strstatusTypeValues[1] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		// RT
		ResourceType_Page.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		// RS1
		Resource_Page.navigateToResourceListPage().createResource(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName);

		// RS2
		Resource_Page.createResource(objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[1] = Resource_Page
				.getResourceValue(objResource_data.strResourceName1);

		// User creation

		// User U1
		UsersList_page
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserMandatoryDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectFirstUserCanAssignRole()
				.selectAdministerUsersOfResource(
						objResource_data.strResourceName)
				.selectAdministerUsersOfResource(
						objResource_data.strResourceName1)
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		// User U2
		UsersList_page
				.clickCreateNewUserButton()
				.enterUserMandatoryDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName1)
				.selectFirstRole()
				.selectAssosciateResourceRight(objResource_data.strResourceName)
				.selectViewResourceCheckBox(objResource_data.strResourceName)

				.selectAssosciateResourceRight(
						objResource_data.strResourceName1)
				.selectViewResourceCheckBox(objResource_data.strResourceName1)
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName1);

		// User U2
		UsersList_page
				.clickCreateNewUserButton()
				.enterUserMandatoryDetails(objUser_data.strNewUserName2,
						objUser_data.strNewPassword, objUser_data.strFullName2)
				.selectFirstRole().clickSaveButton();

		login_page.clickLogOut();

		System.out
				.println("----Precondition ends and Testcase execution starts----");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		UsersList_page1
				.navigateToUsers()
				
				.enterUsernameInSearchInputField(objUser_data.strNewUserName2)
				.clickSearchButton()

				.verifyEditAndPasswordLinksAreNotPresentforUser(
						objUser_data.strNewUserName2)

				.searchUserName(objUser_data.strNewUserName1,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.verifyEditAndPasswordLinkIsDisplayed(
						objUser_data.strNewUserName1)

				.editUserDetails(objUser_data.strNewUserName1)

				.clickOnUserDeactivateChkBox()
				.clickSaveButton()

				.verifyWarningPage(objUser_data.strNewUserName1,
						objUser_data.strFullName1)
				.clickOnYesDeactivateThisUserBtn()
				.verifyDeactivationConfirmPage(objUser_data.strNewUserName1,
						objUser_data.strFullName1).clickOnReturnToListBtn()

				.enterUsernameInSearchInputField(objUser_data.strNewUserName1)
				.clickSearchButton()

				.verUserNotInList(objUser_data.strNewUserName1)
				.clickOnIncludeInactiveChkBox();

		Thread.sleep(5000);

		UsersList_page1.searchUserName(objUser_data.strNewUserName1,
				objUser_data.strRole, objUser_data.strResourceType,
				objUser_data.strUsername, objUser_data.strsearchOption)

		.verifyInactiveUserIsPresent(objUser_data.strNewUserName1,
				objUser_data.strFullName1);

		login_page1.clickLogOut();

		gstrResult = "PASS";
	}	
	
	/************************************************************************************************
	 * 'Description : Verify that user with access to multiple regions and having 'Configure Regional 
	 *                User Access' right in one region can create users in his/her region.
	 * 'Date        : 10-Dec-2015
	 * 'Author      : Anitha
	 *************************************************************************************************/
	@Test(description = "Verify that user with access to multiple regions and having 'Configure Regional"
			+ " User Access' right in one region can create users in his/her region.")
	public void testHappyDay138905() throws Exception {

		gstrTCID = "138905";
		gstrTO = "Verify that user with access to multiple regions and having 'Configure Regional User "
				+ "Access' right in one region can create users in his/her region.";

		// Objects for data
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();

		// Objects of Page for Fire fox Browser
		Login login_page = new Login(this.driver1);
		Regions objRegions_page = new Regions(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		// Objects of Page for IE Browser
		Login login_page1 = new Login(this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		UsersList UsersList_page1 = new UsersList(this.driver1);

		String strRegionValue[] = new String[1];

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page
				.selectRegionAndNavigate(objTest_data.strQuickLinkRegion);

		RegionDefault_page.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions_page
				.getRegionValue(objTest_data.strRegionName);

		System.out.println(strRegionValue[0]);

		RegionDefault_page.selectFrame();

		// User U1 creation
		UsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserMandatoryDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionalUserAccessOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.clickRegionsLinkForUser(objUser_data.strNewUserName)
				.selectRegion(strRegionValue[0]).clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		login_page.clickLogOut();

		System.out
				.println("----Precondition ends and Testcase execution starts----");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		SelectRegion_page1
				.selectRegionAndNavigate(objTest_data.strQuickLinkRegion);

		RegionDefault_page1.selectFrame();

		UsersList_page1
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserMandatoryDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName1,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.verifyEditAndPasswordLinkIsDisplayed(
						objUser_data.strNewUserName1);

		SelectRegion_page1.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page1.selectFrame();
		
		UsersList_page1.verSetUpIsNotPresent();

		login_page1.clickLogOut();

		gstrResult = "PASS";
	}
	/******************************************************************************************
	 * 'Description : Verify that user with 'Resource Admin' right can reactivate a deactivated users for his/her resources.
	 * 'Date        : 14-Dec-2015
	 * 'Author      : Sangappa k
	 ******************************************************************************************/
	@Test(description ="Verify that user with 'Resource Admin' right can reactivate a deactivated users for his/her resources. ")
	public void testHappyDay138910() throws Exception {

		gstrTCID ="138910";
		gstrTO ="Verify that user with 'Resource Admin' right can reactivate a deactivated users for his/her resources.";

		
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		UsersList UsersList_page1 = new UsersList(this.driver1);

		String strstatusTypeValues[] = new String[2];
		String strResourceValue[] = new String[4];
		String strstatusesValue[] = new String[1];

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page
				.selectRegionAndNavigate(objTest_data.strQuickLinkRegion);

		RegionDefault_page.selectFrame();

		// Status type creation
		StatusTypeList_page.navigateToStatusTypeList().createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[0] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		StatusTypeList_page.createStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		StatusTypeList_page.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusColor);

		strstatusesValue[0] = StatusTypeList_page
				.getMSTStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		StatusTypeList_page.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
						      objStatusTypes_data.strStatusColor)
						   .verCreatedStatusInStatusListForMulti(
						          objStatusTypes_data.strStatusNameInMulti1)
			               .clickOnReturnToStatusTypeList();

		strstatusTypeValues[1] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		// RT
		ResourceType_Page.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		// RS1
		Resource_Page.navigateToResourceListPage().createResource(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName);

		// RS2
		Resource_Page.createResource(objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[1] = Resource_Page
				.getResourceValue(objResource_data.strResourceName1);

		// User creation

		// User U1
		UsersList_page
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserMandatoryDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectFirstUserCanAssignRole()
				.selectAdministerUsersOfResource(
						objResource_data.strResourceName)
				.selectAdministerUsersOfResource(
						objResource_data.strResourceName1).clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		// User U2
		UsersList_page
				.clickCreateNewUserButton()
				.enterUserMandatoryDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName1)
				.selectFirstRole()
				.selectAssosciateResourceRight(objResource_data.strResourceName)
				.selectViewResourceCheckBox(objResource_data.strResourceName)

				.selectAssosciateResourceRight(
						objResource_data.strResourceName1)
				.selectViewResourceCheckBox(objResource_data.strResourceName1)
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName1);
		UsersList_page
				.searchUserName(objUser_data.strNewUserName1,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.verifyEditAndPasswordLinkIsDisplayed(
						objUser_data.strNewUserName1)

				.editUserDetails(objUser_data.strNewUserName1)

				.clickOnUserDeactivateChkBox()
				.clickSaveButton()

				.verifyWarningPage(objUser_data.strNewUserName1,
						objUser_data.strFullName1)
				.clickOnYesDeactivateThisUserBtn()
				.verifyDeactivationConfirmPage(objUser_data.strNewUserName1,
						objUser_data.strFullName1).clickOnReturnToListBtn()
				.enterUsernameInSearchInputField(objUser_data.strNewUserName1)
				.clickSearchButton()
				.verUserNotInList(objUser_data.strNewUserName1);

		login_page.clickLogOut();

		System.out
				.println("----Precondition ends and Testcase execution starts----");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		UsersList_page1.navigateToUsers()
				.enterUsernameInSearchInputField(objUser_data.strNewUserName1)
				.clickSearchButton()
				.verUserNotInList(objUser_data.strNewUserName1)
				.clickOnIncludeInactiveChkBox();

		Thread.sleep(5000);

		UsersList_page1
				.searchUserName(objUser_data.strNewUserName1,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)

				.verifyInactiveUserIsPresent(objUser_data.strNewUserName1,
						objUser_data.strFullName1)

				.editUserDetails(objUser_data.strNewUserName1)
				.verDeactivatedToReactivationHeaderMsg()
				.clickOnUserActivateChkBox()
				.clickSaveButton()
				.verifyReactivatedConfmMsg(objUser_data.strNewUserName1,
						objUser_data.strFullName1).clickOnReturnToListBtn()
				.clickOnIncludeInactiveChkBox();
		Thread.sleep(5000);
		UsersList_page1.searchUserName(objUser_data.strNewUserName1,
				objUser_data.strRole, objUser_data.strResourceType,
				objUser_data.strUsername, objUser_data.strsearchOption)

		.verFullName(objUser_data.strNewUserName1, objUser_data.strFullName1);
		login_page1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/************************************************************************************************
	 * 'Description : Verify that user with access to multiple regions and having 'Configure Regional
	 *                 User Access' right in one region can edit users in his/her region.
	 * 'Date        : 10-Dec-2015
	 * 'Author      : Anitha
	 *************************************************************************************************/
	@Test(description = "Verify that user with access to multiple regions and having 'Configure Regional"
			+ " User Access' right in one region can edit users in his/her region.")
	public void testHappyDay138906() throws Exception {

		gstrTCID = "138906";
		gstrTO = "Verify that user with access to multiple regions and having 'Configure Regional User "
				+ "Access' right in one region can edit users in his/her region.";

		// Objects for data
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();

		// Objects of Page for Fire fox Browser
		Login login_page = new Login(this.driver1);
		Regions objRegions_page = new Regions(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		// Objects of Page for IE Browser
		Login login_page1 = new Login(this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		UsersList UsersList_page1 = new UsersList(this.driver1);

		String strRegionValue[] = new String[1];

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page
				.selectRegionAndNavigate(objTest_data.strQuickLinkRegion);

		RegionDefault_page.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions_page
				.getRegionValue(objTest_data.strRegionName);

		System.out.println(strRegionValue[0]);

		RegionDefault_page.selectFrame();

		// User U1 creation
		UsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserMandatoryDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionalUserAccessOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.clickRegionsLinkForUser(objUser_data.strNewUserName)
				.selectRegion(strRegionValue[0]).clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		UsersList_page
				.clickCreateNewUserButton()
				.enterUserMandatoryDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName1,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.clickRegionsLinkForUser(objUser_data.strNewUserName1)
				.selectRegion(strRegionValue[0]).clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		login_page.clickLogOut();

		System.out
				.println("----Precondition ends and Testcase execution starts----");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		SelectRegion_page1
				.selectRegionAndNavigate(objTest_data.strQuickLinkRegion);

		RegionDefault_page1.selectFrame();

		UsersList_page1
				.navigateToUsers()
				.searchUserName(objUser_data.strNewUserName1,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.verifyEditAndPasswordLinkIsDisplayed(
						objUser_data.strNewUserName1)
				.editUserDetails(objUser_data.strNewUserName1)
				.enterOrganization(objUser_data.strEditedOrganization1)
				.enterFullName(objUser_data.strEditedFullName1)
				.clickSaveButton()
				.verifyUserListPageIsDisplayed()
				.verUserDetails(objUser_data.strNewUserName1,
						objUser_data.strEditedFullName1,
						objUser_data.strEditedOrganization1);

		SelectRegion_page1.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page1.selectFrame();
		
		UsersList_page1.verSetUpIsNotPresent();

		login_page1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/******************************************************************************************
	 * 'Description : Verify that 'Resource Admin' can deactivate a user who have access to multiple regions
	 *                 and have affiliated right on his/her resources.
	 * 'Date        : 15-Dec-2015
	 * 'Author      : Sangappa k
	 ******************************************************************************************/
	@Test(description ="Verify that 'Resource Admin' can deactivate a user who have access to multiple regions"
			          + "and have affiliated right on his/her resources.")
	public void testHappyDay139059() throws Exception {

		gstrTCID ="139059";
		gstrTO = "Verify that 'Resource Admin' can deactivate a user who have access to multiple regions"
				+ "and have affiliated right on his/her resources.";

		
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				driver);
		Regions objRegions = new Regions(driver);

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		UsersList UsersList_page1 = new UsersList(this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);

		String strstatusTypeValues1[] = new String[2];

		String strstatusTypeValues2[] = new String[2];

		String strResourceValue[] = new String[4];
		String strstatusesValue[] = new String[1];

		String strRegionValue[] = new String[2];

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page
				.selectRegionAndNavigate(objTest_data.strQuickLinkRegion);

		RegionDefault_page.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions
				.getRegionValue(objTest_data.strRegionName);

		System.out.println(strRegionValue[0]);

		strRegionValue[1] = objRegions
				.getRegionValue(objTest_data.strRegionName1);

		System.out.println(strRegionValue[1]);

		// Status type creation
		StatusTypeList_page.navigateToStatusTypeListNew().createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues1[0] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		StatusTypeList_page.createStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		StatusTypeList_page.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusColor);

		strstatusesValue[0] = StatusTypeList_page
				.getMSTStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		StatusTypeList_page.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
						      objStatusTypes_data.strStatusColor)
						    .verCreatedStatusInStatusListForMulti(
						    			objStatusTypes_data.strStatusNameInMulti1)
						    .clickOnReturnToStatusTypeList();

		strstatusTypeValues1[1] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		StatusTypeList_page.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues2[0] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		StatusTypeList_page.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strsSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues2[1] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strsSSTStatusTypeName);

		ResourceType_Page
				.navigateToResourceTypePage()
				.createResourceType(objResourceType_data.strResourceTypeName,
						strstatusTypeValues1)

				.createResourceType(objResourceType_data.strResourceTypeName1,
						strstatusTypeValues2);

		Resource_Page.navigateToResourceListPage().createResource(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName);

		Resource_Page.createResource(objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[1] = Resource_Page
				.getResourceValue(objResource_data.strResourceName1);
		
		Resource_Page.navigateToResourceListPage().createResource(
				objResource_data.strResourceName2,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName1,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		Resource_Page.navigateToResourceListPage().createResource(
				objResource_data.strResourceName3,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName1,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);


		// User U1
		UsersList_page
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserMandatoryDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectFirstUserCanAssignRole()
				.selectAdministerUsersOfResource(
						objResource_data.strResourceName)
				.selectAdministerUsersOfResource(
						objResource_data.strResourceName1)
				.selectAdministerUsersOfResource(
						objResource_data.strResourceName2).clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		// User U2
		UsersList_page
				.clickCreateNewUserButton()
				.enterUserMandatoryDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName1)
				.selectFirstRole()
				.selectAssosciateResourceRight(objResource_data.strResourceName)
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectAssosciateResourceRight(
						objResource_data.strResourceName1)
				.selectViewResourceCheckBox(objResource_data.strResourceName1)
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName1);

		UsersList_page
				.navigateToUsers()

				.searchUserName(objUser_data.strNewUserName1,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.clickRegionsLinkForUser(objUser_data.strNewUserName1)
				.selectRegion(strRegionValue[1]).clickSaveButton();
		System.out
				.println("----Precondition ends and Testcase execution starts----");
		login_page.clickLogOut();

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		UsersList_page1
				.navigateToUsers()
				.searchUserName(objUser_data.strNewUserName1,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.verifyEditAndPasswordLinkIsDisplayed(
						objUser_data.strNewUserName1)

				.editUserDetails(objUser_data.strNewUserName1)

				.clickOnUserDeactivateChkBox()
				.clickSaveButton()

				.verifyWarningPage(objUser_data.strNewUserName1,
						objUser_data.strFullName1)
				.clickOnYesDeactivateThisUserBtn()
				.verifyDeactivationConfirmPage(objUser_data.strNewUserName1,
						objUser_data.strFullName1).clickOnReturnToListBtn()
				.enterUsernameInSearchInputField(objUser_data.strNewUserName1)
				.clickSearchButton()
				.verUserNotInList(objUser_data.strNewUserName1)
				.clickOnIncludeInactiveChkBox();
		Thread.sleep(1000);

		UsersList_page1.searchUserName(objUser_data.strNewUserName1,
				objUser_data.strRole, objUser_data.strResourceType,
				objUser_data.strUsername, objUser_data.strsearchOption)

		.verifyInactiveUserIsPresent(objUser_data.strNewUserName1,
				objUser_data.strFullName1);
		login_page1.clickLogOut();

		login_page1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page1.selectRegionAndNavigate(objTest_data.strRegionName1);

		RegionDefault_page1.selectFrame();

		UsersList_page1.navigateToUsers()
				.enterUsernameInSearchInputField(objUser_data.strNewUserName1)
				.clickSearchButton()
				.verUserNotInList(objUser_data.strNewUserName1);

		login_page1.clickLogOut();

		gstrResult = "PASS";
	}

	

	/******************************************************************************************
	 * 'Description : Verify that user with 'Resource Admin' right can edit users who have 
	 *                affiliated right on his/her resources.
	 * 'Date        : 16-Dec-2015
	 * 'Author      : Anitha
	 ******************************************************************************************/
	@Test(description = " Verify that user with 'Resource Admin' right can edit users who have "
			+ "affiliated right on his/her resources.")
	public void testHappyDay138908() throws Exception {

		gstrTCID = "138908";
		gstrTO = " Verify that user with 'Resource Admin' right can edit users who have"
				+ " affiliated right on his/her resources.";

		// Objects for data
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();

		// Objects of Page for Fire fox Browser
		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);

		// Objects of Page for IE Browser
		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		UsersList UsersList_page1 = new UsersList(this.driver1);

		String strstatusTypeValues[] = new String[5];
		String strResourceValue[] = new String[4];
		String strstatusesValue[] = new String[1];

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page
				.selectRegionAndNavigate(objTest_data.strQuickLinkRegion);

		RegionDefault_page.selectFrame();

		// Status type creation
		StatusTypeList_page.navigateToStatusTypeList().createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[0] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		// Status type creation
		StatusTypeList_page.createStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		StatusTypeList_page.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusColor);

		strstatusesValue[0] = StatusTypeList_page
				.getMSTStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		StatusTypeList_page.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
								objStatusTypes_data.strStatusColor)
					       .verCreatedStatusInStatusListForMulti(
					          objStatusTypes_data.strStatusNameInMulti1)
					       .clickOnReturnToStatusTypeList();

		strstatusTypeValues[1] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		// Status type creation
		StatusTypeList_page.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[2] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		// Status type creation
		StatusTypeList_page.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[3] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		// Status type creation
		StatusTypeList_page.createStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[4] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		String strstatusTypeValues1[] = { strstatusTypeValues[0],
				strstatusTypeValues[1], strstatusTypeValues[4] };
		String strstatusTypeValues2[] = { strstatusTypeValues[2],
				strstatusTypeValues[3] };

		// Resource type creation
		ResourceType_Page.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues1);

		// Resource type creation
		ResourceType_Page
				.createResourceType(objResourceType_data.strResourceTypeName1,
						strstatusTypeValues2);

		// Resource creation
		Resource_Page.navigateToResourceListPage().createResource(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName);

		// Resource creation
		Resource_Page.createResource(objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[1] = Resource_Page
				.getResourceValue(objResource_data.strResourceName1);

		// Resource creation
		Resource_Page.createResource(objResource_data.strResourceName2,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName1,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[2] = Resource_Page
				.getResourceValue(objResource_data.strResourceName2);

		// Resource creation
		Resource_Page.createResource(objResource_data.strResourceName3,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName1,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[3] = Resource_Page
				.getResourceValue(objResource_data.strResourceName3);
		// User creation

		// User U1
		UsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserMandatoryDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectFirstUserCanAssignRole()
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionalUserAccessOption()
				.selectAdministerUsersOfResource(
						objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectAdministerUsersOfResource(
						objResource_data.strResourceName1)
				.selectUpdateStatusOfResource(objResource_data.strResourceName1)
				.selectAdministerUsersOfResource(
						objResource_data.strResourceName2)
				.selectUpdateStatusOfResource(objResource_data.strResourceName2)
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		// User U2
		UsersList_page
				.clickCreateNewUserButton()
				.enterUserMandatoryDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName1)
				.selectFirstRole()
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectViewResourceCheckBox(objResource_data.strResourceName1)
				.selectViewResourceCheckBox(objResource_data.strResourceName2)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName1)
				.selectUpdateStatusOfResource(objResource_data.strResourceName2)
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName1);

		login_page.clickLogOut();

		System.out
				.println("----Precondition ends and Testcase execution starts----");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		UsersList_page1
				.navigateToUsers()
				.searchUserName(objUser_data.strNewUserName1,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.verifyEditAndPasswordLinkIsDisplayed(
						objUser_data.strNewUserName1)
				.editUserDetails(objUser_data.strNewUserName1)
				.enterOrganization(objUser_data.strEditedOrganization1)
				.enterFullName(objUser_data.strEditedFullName1)
				.clickSaveButton()
				.verifyUserListPageIsDisplayed()
				.verUserDetails(objUser_data.strNewUserName1,
						objUser_data.strEditedFullName1,
						objUser_data.strEditedOrganization1);
		
		login_page1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/******************************************************************************************
	 * 'Description : Verify that user with 'Resource Admin' right can create users for his/her resources only.
	 * 'Date        : 16-Dec-2015
	 * 'Author      : Sangappa k
	 ******************************************************************************************/
	@Test(description ="Verify that user with 'Resource Admin' right can create users for his/her resources only.")
	public void testHappyDay138907() throws Exception {

		gstrTCID ="138907";
		gstrTO = "Verify that user with 'Resource Admin' right can create users for his/her resources only.";

		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				driver);
		Regions objRegions = new Regions(driver);

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		UsersList UsersList_page1 = new UsersList(this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);

		String strstatusTypeValues1[] = new String[2];

		String strstatusTypeValues2[] = new String[2];

		String strResourceValue[] = new String[4];
		String strstatusesValue[] = new String[1];

		String strRegionValue[] = new String[2];

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page
				.selectRegionAndNavigate(objTest_data.strQuickLinkRegion);

		RegionDefault_page.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions
				.getRegionValue(objTest_data.strRegionName);

		System.out.println(strRegionValue[0]);

		strRegionValue[1] = objRegions
				.getRegionValue(objTest_data.strRegionName1);

		System.out.println(strRegionValue[1]);

		// Status type creation
		StatusTypeList_page.navigateToStatusTypeListNew().createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues1[0] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		StatusTypeList_page.createStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		StatusTypeList_page.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusColor);

		strstatusesValue[0] = StatusTypeList_page
				.getMSTStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		StatusTypeList_page.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
								objStatusTypes_data.strStatusColor)
					       .verCreatedStatusInStatusListForMulti(
					          objStatusTypes_data.strStatusNameInMulti1)
					       .clickOnReturnToStatusTypeList();

		strstatusTypeValues1[1] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		StatusTypeList_page.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues2[0] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		StatusTypeList_page.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strsSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues2[1] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strsSSTStatusTypeName);

		ResourceType_Page
				.navigateToResourceTypePage()
				.createResourceType(objResourceType_data.strResourceTypeName,
						strstatusTypeValues1)

				.createResourceType(objResourceType_data.strResourceTypeName1,
						strstatusTypeValues2);

		Resource_Page.navigateToResourceListPage().createResource(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName);

		Resource_Page.createResource(objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[1] = Resource_Page
				.getResourceValue(objResource_data.strResourceName1);
		
		Resource_Page.navigateToResourceListPage().createResource(
				objResource_data.strResourceName2,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName1,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		Resource_Page.navigateToResourceListPage().createResource(
				objResource_data.strResourceName3,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName1,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);


		// User U1
		UsersList_page
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserMandatoryDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectFirstUserCanAssignRole()
				.selectAdministerUsersOfResource(
						objResource_data.strResourceName)
				.selectAdministerUsersOfResource(
						objResource_data.strResourceName1)
				.selectAdministerUsersOfResource(
						objResource_data.strResourceName2).clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		// User U2
		UsersList_page
				.clickCreateNewUserButton()
				.enterUserMandatoryDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName1)
				.selectFirstRole()
				.selectAssosciateResourceRight(objResource_data.strResourceName)
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectAssosciateResourceRight(
						objResource_data.strResourceName1)
				.selectViewResourceCheckBox(objResource_data.strResourceName1)
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName1);
		System.out
				.println("----Precondition ends and Testcase execution starts----");
		login_page.clickLogOut();

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		UsersList_page1
				.navigateToUsers()
				.searchUserName(objUser_data.strNewUserName1,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.verifyEditAndPasswordLinkIsDisplayed(
						objUser_data.strNewUserName1)	
				.clickCreateNewUserButton()		
				
				 .enterUserMandatoryDetails(objUser_data.strNewUserName2,
						objUser_data.strNewPassword, objUser_data.strFullName2)
				.selectFirstRole()
				.verResourceNameNotDispalyed(objResource_data.strResourceName3)
				.verResourceName(objResource_data.strResourceName)
				.verResourceName(objResource_data.strResourceName1)
				.verResourceName(objResource_data.strResourceName2)
				.verViewResourceIsNotPresent()
				.selectAssosciateResourceRight(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickSaveButton();
		
		          System.out.println(objUser_data.strNewUserName2);
				
				UsersList_page1.searchUserName(objUser_data.strNewUserName2,
				objUser_data.strRole, objUser_data.strResourceType,
				objUser_data.strUsername, objUser_data.strsearchOption)
				
		        .verUserInList(objUser_data.strNewUserName2)
		        .verifyEditAndPasswordLinkIsDisplayed(
						 objUser_data.strNewUserName2);	
		     
	      	login_page1.clickLogOut();

		gstrResult = "PASS";
		
	}
	
}
