package requirementGroup.CreatingAndManagingUsers;

import lib.dataObject.Login_data;
import lib.dataObject.Roles_data;
import lib.dataObject.User_data;
import lib.module.LinksAtTopRightCorners;
import lib.module.NavigationToSubMenus;
import lib.page.EventManagement;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Regions;
import lib.page.Roles;
import lib.page.SelectRegion;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class HappyDayCreatingAndManagingUsers extends TestNG_UI_EXTENSIONS {

	public HappyDayCreatingAndManagingUsers() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/**************************************************************************
	 * 'Description : Verify that 'Save' and 'Cancel' buttons are available at 
	 *                the top and bottom of the Create/Edit user page.
	 * 'Date        : 19-Oct-2015
	 * 'Author      : Anitha
	 **************************************************************************/

	@Test(enabled = false,description = "Verify that 'Save' and 'Cancel' buttons are available at the top and bo"
			+ "ttom of the Create/Edit user page")
	public void testHappyDay131384() throws Exception {
		
		gstrTCID = "131384";
		gstrTO = "Verify that 'Save' and 'Cancel' buttons are available at the top and bottom of "
				+ "the Create/Edit user page";

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
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectConfigureRegionalUserAccessOption().clickSaveButton();

		System.out.println(objUserdata.strNewUserName);

		objLogin.clickLogOut();
		
		System.out.println("------precondtion ends and test execution starts-------");
		
		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.clickCreateNewUserButton()
				.verSaveAndCancelButtons()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.clickSaveButton()
				
				.searchUserName(objUserdata.strNewUserName1,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.editUserDetails(objUserdata.strNewUserName1)
				.verSaveAndCancelButtons().clickCancelButton()
				.verifyUserListPageIsDisplayed();
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/**************************************************************************
	 * 'Description :Verify that appropriate validation message is displayed when invalid
	 *                  ID is provided while creating/ editing user.
	 * 'Date        : 30-Oct-2015
	 * 'Author      : Sangappa K
	 **************************************************************************/
	@Test(description ="Verify that appropriate validation message is displayed when invalid ID "
			                             + "is provided while creating/ editing user.")
	public void testHappyDay169211() throws Exception {

		gstrTCID ="169211";
		gstrTO = "Verify that appropriate validation message is displayed when invalid ID is provided "
				+ "while creating/ editing user.";

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
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectConfigureRegionalUserAccessOption().clickSaveButton();

		System.out.println(objUserdata.strNewUserName1);

		objLogin.clickLogOut();

		System.out
				.println("------precondtion ends and test execution starts-------");

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.clickCreateNewUserButton()
				.verSaveAndCancelButtons()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.enterEmail(objUserdata.strInvalidPrimaryMailId)
				.enterPrimaryEmailId(objUserdata.strInvalidPrimaryMailId)
				.entertextPagerId(objUserdata.strInvalidPrimaryMailId)
				.clickSaveButton()
				.verApprptValidationMsgForInvalidMailPagerIds()
				.enterPassword(objUserdata.strNewPassword)
				.enterConfirmPassword(objUserdata.strNewPassword)
				.enterEmail(objUserdata.strPrimaryMailId)
				.enterPrimaryEmailId(objUserdata.strPrimaryMailId)
				.entertextPagerId(objUserdata.strPrimaryMailId)
				.enterOrganization(objUserdata.strOrganization)
				.selectFirstRole()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed()
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.verUserDetails(objUserdata.strNewUserName,
						objUserdata.strFullName, objUserdata.strOrganization);
		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.clickCreateNewUserButton()
				.verSaveAndCancelButtons()
				.enterUserDetails(objUserdata.strNewUserName2,
						objUserdata.strNewPassword, objUserdata.strFullName2)
				.enterEmail(objUserdata.strInvalidPrimaryMailId)
				.enterPrimaryEmailId(objUserdata.strInvalidPrimaryMailId)
				.entertextPagerId(objUserdata.strInvalidPrimaryMailId)
				.clickSaveButton()
				.verApprptValidationMsgForInvalidMailPagerIds()
				.enterPassword(objUserdata.strNewPassword)
				.enterConfirmPassword(objUserdata.strNewPassword)
				.enterEmail(objUserdata.strPrimaryMailId)
				.enterPrimaryEmailId(objUserdata.strPrimaryMailId)
				.entertextPagerId(objUserdata.strPrimaryMailId)
				.enterOrganization(objUserdata.strOrganization)
				.selectFirstRole()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed()
				.searchUserName(objUserdata.strNewUserName2,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.verUserDetails(objUserdata.strNewUserName2,
						objUserdata.strFullName2, objUserdata.strOrganization);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/**************************************************************************
	 * 'Description :Verify that clicking on 'Return to Self' link returns to the 
	 *               previously logged in user account.
	 * 'Date        : 11-NOv-2015
	 * 'Author      : Sangappa K
	 **************************************************************************/

	@Test(description ="Verify that clicking on 'Return to Self' link returns to the previously logged in user account.")
	public void testHappyDay169283() throws Exception {
		
		gstrTCID ="169283";
		gstrTO ="Verify that clicking on 'Return to Self' link returns to the previously logged in user account.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		LinksAtTopRightCorners objAtTopRightCorners1 = new LinksAtTopRightCorners(this.driver1);

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.enterOrganization(objUserdata.strOrganization)		
				.selectFirstRole().clickSaveButton();
		
		System.out.println(objUserdata.strNewUserName);
		
		objUsersList1
				.searchUserName(objUserdata.strNewUserName,
						objUserdata.strRole, objUserdata.strResourceType,
						objUserdata.strUsername, objUserdata.strsearchOption)
				.verUserDetails(objUserdata.strNewUserName,
						objUserdata.strFullName, objUserdata.strOrganization)
				.clickOnSwitchLink(objUserdata.strNewUserName)
				
				.verUserAndFullNameAtFooterOfAppWhenSwitched(
						objUserdata.strFullName, objUserdata.strNewUserName,
						objLogindata.strUserName);
		 objAtTopRightCorners1.verReturnToSelfOptionAtTopRightCorner();
		
		objNavigationToSubmenus1.navigateToCalendarInRegionalInfo();
		
		objUsersList1.verUserAndFullNameAtFooterOfAppWhenSwitched(
				objUserdata.strFullName, objUserdata.strNewUserName,
				objLogindata.strUserName);

		objAtTopRightCorners1.clickOnReturnToSelf();
		objUsersList1.verAdminUser(objLogindata.strQSGFullName,objLogindata.strUserName);
		objNavigationToSubmenus1.navigateToCalendarInRegionalInfo();
		objUsersList1.verAdminUser(objLogindata.strQSGFullName,objLogindata.strUserName);
		objAtTopRightCorners1.verReturnToSelfOptionAtTopRightCornerNotPrestnt();
		objLogin1.clickLogOut();
		gstrResult = "PASS";
	}	
	
	/**************************************************************************
	 * 'Description :  	Verify that 'SystemAdmin' cannot Create/Edit/End any events. 
	 * 'Date        : 19-Oct-2015
	 * 'Author      : Anil
	 **************************************************************************/

	@Test(description = " 	Verify that 'SystemAdmin' cannot Create/Edit/End any events. ")
	public void testHappyDay169342() throws Exception {
		
		gstrTCID = "169342";
		gstrTO = " 	Verify that 'SystemAdmin' cannot Create/Edit/End any events. ";

		Login_data objLogin_data = new Login_data();
		Login login_page1 = new Login(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);

		login_page1.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegionpage1.selectRegionAndNavigate(objLogin_data.strRegionName);
		
		RegionDefault_page1.selectFrame();

		EventManagement_page1.clickOnEventLink()
		
		.verifyEventManagementLinkIsNotDisplayed();
		
		gstrResult = "PASS";
	}
	
	/**************************************************************************
	 * 'Description : Verify that for user with 'May update region setup information'
	 * 				 right, options‘Account Linking’,‘Instant Messaging’ and ‘IM WebSocket’
						are not available on 'Edit Region' screen. 
	 * 'Date        : 19-Oct-2015
	 * 'Author      : Anil
	 **************************************************************************/

	@Test(description = "Verify that for user with 'May update region setup information'"+
			" right, options‘Account Linking’,‘Instant Messaging’ and ‘IM WebSocket’"+
			" are not available on 'Edit Region' screen. " )
	public void testHappyDay168755() throws Exception {
		
		gstrTCID = "168755";
		gstrTO ="Verify that for user with 'May update region setup information'"+
				" right, options‘Account Linking’,‘Instant Messaging’ and ‘IM WebSocket’"+
				" are not available on 'Edit Region' screen. " ;

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
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		Regions objRegion1 = new Regions(this.driver1);
		
		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectMayUpdateRegionSetupInformationOption().clickSaveButton();

		System.out.println(objUserdata.strNewUserName);

		objLogin.clickLogOut();
		
		System.out.println("------precondtion ends and test execution starts-------");
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
						objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToRegions();	

   	    objRegion1.clickOnEditRegions(objLogindata.strRegionName);  
		
   	    objRegion1.verEditRegiontPageIsDisplayed()
		        .verifyInstantMessagingCheckBoxIsNotDisplayed()
		        .verifyAccountLinkingCheckBoxIsNotDisplayed()
		        .verifyIMWebsocketsCheckBoxIsNotDisplayed();
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/**************************************************************************
	 * 'Description : Verify that options‘Account Linking’ and ‘Instant Messaging’
	 * 				 and ‘IM WebSocket’ are available on ‘Edit Region’ screen only 
	 * 				for system admin users. 
	 * 'Date        : 19-Oct-2015
	 * 'Author      : Anil
	 **************************************************************************/

	@Test(description = "Verify that options‘Account Linking’ and ‘Instant Messaging’"+
						"and ‘IM WebSocket’ are available on ‘Edit Region’ screen only "+
						 "for system admin users." )
	public void testHappyDay168754() throws Exception {
		
		gstrTCID = "168754";
		gstrTO ="Verify that options‘Account Linking’ and ‘Instant Messaging’"+
				"and ‘IM WebSocket’ are available on ‘Edit Region’ screen only "+
				 "for system admin users." ;

		Login_data objLogindata = new Login_data();

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		Regions objRegion1 = new Regions(this.driver1);
		
		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToRegions();	

   	    objRegion1.clickOnEditRegions(objLogindata.strRegionName);  
		
   	    objRegion1.verEditRegiontPageIsDisplayed()
		        .verifyInstantMessagingCheckBoxIsDisplayed()
		        .verifyAccountLinkingCheckBoxIsDisplayed()
		        .verifyIMWebsocketsCheckBoxIsDisplayed();
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/**************************************************************************
	 * 'Description :  	Verify that 'SystemAdmin' and 'HelpDesk' roles cannot be deleted from UI.  
	 * 'Date        : 19-Oct-2015
	 * 'Author      : Anil
	 **************************************************************************/

	@Test(description = "Verify that 'SystemAdmin' and 'HelpDesk' roles cannot be deleted from UI. " )
	public void testHappyDay169338() throws Exception {
		
		gstrTCID = "169338";
		gstrTO ="Verify that 'SystemAdmin' and 'HelpDesk' roles cannot be deleted from UI. " ;

		Login_data objLogindata = new Login_data();
		Roles_data objRoles_data = new Roles_data();
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		Roles objRoles1 = new Roles(this.driver1);
		
		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strIMXSystemAdminRegion);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToRoles();
		
		objRoles1.verifyDeleteOptionIsNotDisplayed(objRoles_data.strHelpDeskRole);
		
		objRoles1.verifyDeleteOptionIsNotDisplayed(objRoles_data.strSystemAdminRole);
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/**************************************************************************
	 * 'Description :  Verify that 'HelpDesk' role has following rights: 
	 * 'Date        : 19-Oct-2015
	 * 'Author      : Anil
	 **************************************************************************/

	@Test(description = " Verify that 'HelpDesk' role has following rights:" )
	public void testHappyDay169341() throws Exception {
		
		gstrTCID = "169341";
		gstrTO =" Verify that 'HelpDesk' role has following rights:" ;

		Login_data objLogindata = new Login_data();
		Roles_data objRoles_data = new Roles_data();
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		Roles objRoles1 = new Roles(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		
		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strIMXSystemAdminRegion);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToRoles();
		
		objRoles1.clickOnEditLinkOfRole(objRoles_data.strHelpDeskRole);
		
		objUsersList1.verConfigureRegionalUserAccessOptionIsSelected()
					.verPreferencesDontNotSendUserReminderMailsIsSelected()
					.verEditEventNotificationPreferencesOptionIsSelected()
					.verEditStatusChangeNotPrefernceOptionIsSelected()
					.verOverrideViewingRestrictionOptionIsSelected()
					.verUserViewUserInformationOnlyOptionIsSelected()
					.verViewcustomViewOptionIsSelected();
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/**************************************************************************
	 * 'Description :Verify that 'SystemAdmin' role has the following rights:
	 * 'Date        : 19-Oct-2015
	 * 'Author      : Anil
	 **************************************************************************/

	@Test(description = "Verify that 'SystemAdmin' role has the following rights:" )
	public void testHappyDay169340() throws Exception {
		
		gstrTCID = "169340";
		gstrTO ="Verify that 'SystemAdmin' role has the following rights:" ;

		Login_data objLogindata = new Login_data();
		Roles_data objRoles_data = new Roles_data();
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		Roles objRoles1 = new Roles(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		
		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strIMXSystemAdminRegion);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToRoles();
		
		objRoles1.clickOnEditLinkOfRole(objRoles_data.strSystemAdminRole);
		
		objUsersList1
		.veradministerOtherRegionViewsOptionIsSelected()
		.verConfigureRegionalUserAccessOptionIsSelected()
		.verConfigureRegionViewsOptionIsSelected()
		.verPreferencesDontNotSendUserReminderMailsIsSelected()
		.verEditEventNotificationPreferencesOptionIsSelected()
		.verEditRegionalMessageBulletinBoardIsSelected()
		.verEditStatusChangeNotPrefernceOptionIsSelected()
						.verFormDoNotParticipateInFormsForResourcesOptionIsSelected()	
							.verFormUserMayConfigureFormSecurityIsSelected()
		.verSelectFormUserMayActivateandModifyFormsOptionIsSelected()
						.verInstantMessagingInitiateChatSessionOptionIsSelected()
							.verMaintainDocumentLibraryOptionIsSelected()
									.verMaintainEventTemplateOptionIsSelected()			
		.verHavBedScheduleAndActivateHaavBedInterfaceIsSelected()					
		.verMayUpdateRegionSetupInformationOptionIsSelected()				
							.verOverrideViewingRestrictionOptionIsSelected()
							.verReporAuditResourceDetailIsSelected()
							.verReportEventDetailOptionIsSelected()
							.verReportEventSnapshotOptionIsSelected()
							.verReportformDetailIsSelected()
							.verReportIncomingPatientNotificationOptionIsSelected()
							.verReporMonthlyStatusAssessmentIsSelected()
							.verReportStatewideResourceDetail()	
							.verReportStatusDetailOptionIsSelected()
							.verReportStatusReasonDetailOptionIsSelected()			
							.verReportStatusReasonSummaryOptionIsSelected()	
							.verReportStatusSnapshotOptionIsSelected()	
							.verReportStatusSummaryOptionIsSelected()				
							.verSetupResourceOptionIsSelected()
							.verSetupResourceTypesOptionIsSelected()
							.verSetUpRolesRightIsSelected()
							.verSetupStatusReasonOptionIsSelected()
							.verSetupStatusTypesOptionIsSelected()		
							.verUserViewUserInformationOnlyOptionIsSelected()
							.verViewcustomViewOptionIsSelected();
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
}
