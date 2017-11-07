package requirementGroup.SmokeTestSuite;

import java.util.Iterator;
import java.util.Set;

import lib.dataObject.EventSetUp_data;
import lib.dataObject.Event_data;
import lib.dataObject.InterfaceInSetUp_data;
import lib.dataObject.Label_data;
import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.NavigationToSubMenus;
import lib.module.UserFunctions;
import lib.page.CustomUnderView;
import lib.page.EventManagement;
import lib.page.EventSetUp;
import lib.page.EventStatus;
import lib.page.InterfacesInSetUp;
import lib.page.Login;
import lib.page.Map;
import lib.page.RegionDefault;
import lib.page.RegionalInfo;
import lib.page.Regions;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SecurityQuestion;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UpdateUserInfo;
import lib.page.UserLinks;
import lib.page.UsersList;
import lib.page.Views;
import lib.page.ViewsList;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class SmokeSetup extends TestNG_UI_EXTENSIONS {

	public SmokeSetup() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/*************************************************************************************
	'Description : Verify that a user can be edited.
	'Precondition:
	'Date	 	 : 30-Jul-2014
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that a user can be edited.")
	public void testSmoke97754() throws Exception {
		gstrTCID = "97754";
		gstrTO	 = "Verify that a user can be edited.";
		
		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		RegionalInfo objRegionalInfo1 = new RegionalInfo(this.driver1);
		UserFunctions objUserFunctions1 = new UserFunctions(this.driver1);
		UpdateUserInfo objUpdateUserInfo1 = new UpdateUserInfo(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(this.driver1);
		
		objLogin.loginToApplication(objLogindata.strUserName,objLogindata.strPassword);
		
		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strQuickLinkRegion);

		objRegionDefault.selectFrame();
		
		objNavigationToSubmenus.navigateToUsers();
		
		objUsersList.clickCreateNewUserButton()
					.enterAllUserDetails(objUserdata.strNewUserName,
							objUserdata.strNewPassword, objUserdata.strFullName, 
							objUserdata.strFirstName, objUserdata.strMiddleName, 
							objUserdata.strLastName, objUserdata.strOrganization, 
							objUserdata.strPhone, objUserdata.strPrimaryMailId, 
							objUserdata.strPrimaryMailId, objUserdata.strPrimaryMailId)
					.selectFirstRole()
					.clickSaveButton()
					.enterUsernameInSearchInputField(objUserdata.strNewUserName)
					.clickSearchButton()
					.verUserDetails(objUserdata.strNewUserName, objUserdata.strFullName, objUserdata.strOrganization);
		
		objLogin.clickLogOut();
		
		System.out.println("-----Precondition ends and test execution starts-------");
		
		objLogin1.loginToApplication(objLogindata.strUserName,objLogindata.strPassword);
		
		objRegionDefault1.selectFrame();
		
		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strQuickLinkRegion);
		
		objRegionDefault1.selectFrame()
						 .verifyRegionDefaultPage();
		
		objUsersList1.navigateToUsers();
		
		objUsersList1.enterUsernameInSearchInputField(objUserdata.strNewUserName)
					 .clickSearchButton()
					 .editUserDetails(objUserdata.strNewUserName)
					 .enterFullName(objUserdata.strEditedFullName)
					 .enterFirstName(objUserdata.strEditedFirstName)
					 .enterMiddleName(objUserdata.strEditedMiddleName)
					 .enterLastName(objUserdata.strEditedLastName)
					 .enterOrganization(objUserdata.strEditedOrganization)
					 .enterPhone(objUserdata.strEditedPhone)
					 .enterPrimaryEmailId(objUserdata.strEmail)
					 .enterEmail(objUserdata.strEmail)
					 .entertextPagerId(objUserdata.strEmail)
					 .clickSaveButton()
					 .verUserDetails(objUserdata.strNewUserName, objUserdata.strEditedFullName, 
							 	objUserdata.strEditedOrganization);
		
		objNavigationToSubmenus1.navigateToUsersInRegionalInfo();
		
		objUserFunctions1.enterUsernameInSearchInputField(objUserdata.strNewUserName)
		 			     .clickSearchButton();
		
		 objRegionalInfo1.verUserDetailsInUserListPgeOfRegionalInfo(objUserdata.strNewUserName, 
		 					 objUserdata.strEditedFullName, objUserdata.strEditedOrganization,
		 					 objUserdata.strEditedPhone, objUserdata.strEmail, objUserdata.strEmail);
		
		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName, objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame()
						 .verifyUserNameInFooter(objUserdata.strEditedFullName);
		
		objNavigationToSubmenus1.navigateToUsersInfoInPreferences();
		
		objUpdateUserInfo1.verifyUserDetailsAreRetrieved(objUserdata.strEditedFullName, 
				objUserdata.strEditedFirstName, objUserdata.strEditedMiddleName, 
				objUserdata.strEditedLastName, objUserdata.strEditedOrganization, 
				objUserdata.strEditedPhone, objUserdata.strEmail, objUserdata.strEmail, objUserdata.strEmail);
		
		objLogin1.clickLogOut();
		gstrResult = "PASS";
	}
	
	/****************************************************************************************************
	'Description : Verify that options 'User Has Role', 'User Can Assign Role' and 'Administer Users' are 
	               available for users only in regions in which 'DELEGATED
	'Precondition:
	'Date	 	 : 01-Aug-2014
	'Author		 : Sowmya
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	****************************************************************************************************/
	@Test (description = "Verify that options 'User Has Role', 'User Can Assign Role' and 'Administer Users' are available "
			+ "for users only in regions in which 'DELEGATED")
	public void testSmoke142235() throws Exception {
		gstrTCID = "142235";
		gstrTO	 = "Verify that options 'User Has Role', 'User Can Assign Role' and 'Administer Users' are" 
	              +"available for users only in regions in which 'DELEGATED";
		
		Login_data login_data = new Login_data();
		User_data objUser_data = new User_data();
		Login objLogin = new Login(this.driver1);	
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);	
		
		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
	
		objLogin.loginToApplication(login_data.strUserName, login_data.strPassword);
	    
	    objSelectRegion.selectRegionAndNavigate(login_data.strQuickLinkRegion);
	       
	    objRegionDefault.selectFrame();
	    
	    objUsersList.navigateToUsers()
	    	          .clickCreateNewUserButton()
	                  .enterUserDetails(objUser_data.strNewUserName, objUser_data.strNewPassword, objUser_data.strFullName)
	                  .clickSaveButton()
	                  .searchUserName(objUser_data.strNewUserName, objUser_data.strRole, objUser_data.strResourceType, 
	                		  objUser_data.strUsername, objUser_data.strEquals); 
	    
	    objLogin.clickLogOut();
	    
	    System.out.println("-----Precondition ends and test execution starts-------");
	    
	    objLogin1.loginToApplication(login_data.strUserName, login_data.strPassword);
	    
	    objRegionDefault1.selectFrame();
	     	    
	     objSelectRegion1.selectRegionAndNavigate(login_data.strQuickLinkRegion);
	     
	     objRegionDefault1.selectFrame();
	     
	     objUsersList1.navigateToUsers()
	                  .searchUserName(objUser_data.strNewUserName, objUser_data.strRole, objUser_data.strResourceType, 
	   		                          objUser_data.strUsername, objUser_data.strEquals)
	   		          .editUserDetails(objUser_data.strNewUserName)
	   		          .verUserHasRoleIsPresent()
	   		          .verUserCanAssignRoleIsPresent()
	   		          .verAdministerUsersIsPresent();
	     	    
	     objSelectRegion1.selectRegionAndNavigate(login_data.strRegionName);
	     
         objRegionDefault1.selectFrame();
	     
	     objUsersList1.navigateToUsers()
	                  .clickCreateNewUserButton()
				      .verUserHasRoleIsNotPresent()
				      .verUserCanAssignRoleIsNotPresent()
				      .verAdministerUsersIsNotPresent()
				      .verRolesIsPresent();
	     
	     objLogin1.clickLogOut();
	     gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Verify that a region interface can be created.
	'Precondition: None
	'Date	 	 : 04-Aug-2014
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that a region interface can be created.")
	public void testSmoke91700() throws Exception {
		gstrTCID = "91700";
		gstrTO	 = "Verify that a region interface can be created.";
		
		Login objLogin = new Login(this.driver1);
		Login_data objLogin_data = new Login_data();
		InterfaceInSetUp_data objInterfaceInSetUp_data = new InterfaceInSetUp_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
		InterfacesInSetUp objInterfacesInSetUp = new InterfacesInSetUp(this.driver1);
		
		String[] strInterfaceTypes = {objInterfaceInSetUp_data.strInterfaceType1,objInterfaceInSetUp_data.strInterfaceType2,
				objInterfaceInSetUp_data.strInterfaceType3,
				objInterfaceInSetUp_data.strInterfaceType4,
				objInterfaceInSetUp_data.strInterfaceType5,
				objInterfaceInSetUp_data.strInterfaceType6,
				objInterfaceInSetUp_data.strInterfaceType7,
				objInterfaceInSetUp_data.strInterfaceType8,
				objInterfaceInSetUp_data.strInterfaceType9,
				objInterfaceInSetUp_data.strInterfaceType10,
				objInterfaceInSetUp_data.strInterfaceType11,
				objInterfaceInSetUp_data.strInterfaceType12
				};
		
		objLogin.loginToApplication(objLogin_data.strUserName,objLogin_data.strPassword);
		
		objRegionDefault.selectFrame();
		
		objSelectRegionpage.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault.selectFrame();
		
		objNavigationToSubmenus.navigateToInterfaces();
		
		objInterfacesInSetUp.verifyInterfaceListScreen()
							.clickOnCreateNewInterfaceBtn()
							.verifySelInterfaceTypeScreen(strInterfaceTypes)
							.selInterfaceType(objInterfaceInSetUp_data.strInterfaceType3)
							.clickOnNext()
							.verifyCreateInterfaceScreen()
							.provideDetailsForInterface(objInterfaceInSetUp_data.strInterfaceName, 
									objInterfaceInSetUp_data.strInterfaceDesc, objInterfaceInSetUp_data.strContInfo);
		
		String strWebServAction = objInterfacesInSetUp.getWebServiceAction();
		
		objInterfacesInSetUp.selActiveChkbox()
							.clickOnSave()
							.verifyCreatedInterfaceInList(objInterfaceInSetUp_data.strInterfaceName,
									objInterfaceInSetUp_data.strInterfaceDesc,objInterfaceInSetUp_data.strInterfaceType3,
									strWebServAction,objInterfaceInSetUp_data.strInterfaceActiveStatus)
							.clickOnEditLink(objInterfaceInSetUp_data.strInterfaceName)
							.selActiveChkbox()
							.clickOnSave()
							.verCreatedInterfaceStatus(objInterfaceInSetUp_data.strInterfaceName, objInterfaceInSetUp_data.strInterfaceDisabledStatus);
		
		objLogin.clickLogOut();
		gstrResult = "PASS";
	}
	
	/*******************************************************************************************
	'Description : Verify that user with 'Resource Admin' right can create / edit users who have 
	               affiliated right on his/her resources.
	'Precondition:
	'Date	 	 : 04-Aug-2014
	'Author		 : Sowmya
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that user with 'Resource Admin' right can create / edit users who have affiliated "
			+ "right on his/her resources.")
	public void testSmoke142236() throws Exception {
		gstrTCID = "142236";
		gstrTO	 = "Verify that user with 'Resource Admin' right can create / edit users who have affiliated "
			+ "right on his/her resources.";
		
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		ResourceType_data objResourceType_data=new ResourceType_data();
		Resource_data objResource_data=new Resource_data();
		StatusTypes_data objStatuTypes_data =new StatusTypes_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType =new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		String strstatusTypeValues[]=new String[5];
		String strResourceValue[]=new String[2];
	
		Login objLogin1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1); 
		UsersList objUsersList1 = new UsersList(this.driver1);
		
		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);
	
		objSelectRegion.selectRegionAndNavigate(objTest_data.strQuickLinkRegion);
	
		objRegionDefault.selectFrame();
	
		objStatusTypeList.navigateToStatusTypeList()
	
		//RoleBased statustypes		
		.createStatusType(
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
		
		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);
		
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);
		
		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);
		
		//Resource type creation 
		objResourceType .navigateToResourceTypePage()
	
		.createResourceType(objResourceType_data.strResourceTypeName,
				strstatusTypeValues);
		
		//Resource creation 	
		objResource.navigateToResourceListPage()
	
		.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);
		
		strResourceValue[0]=objResource.getResourceValue(objResource_data.strResourceName);
		
		objResource.createResource(objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);
		
		strResourceValue[1]=objResource.getResourceValue(objResource_data.strResourceName1);
		
		//User creation	
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectFirstUserCanAssignRole()
				.selectAssociateWithOfResource(objResource_data.strResourceName)
				.selectAdministerUsersOfResource(
						objResource_data.strResourceName)
				.selectAssociateWithOfResource(
						objResource_data.strResourceName1)
				.selectAdministerUsersOfResource(
						objResource_data.strResourceName1)
				.clickSaveButton()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectAssociateWithOfResource(objResource_data.strResourceName)
				.selectAssociateWithOfResource(
						objResource_data.strResourceName1)
				.clickSaveButton();

		objLogin.clickLogOut();

		System.out.println(objUser_data.strNewUserName);

		System.out.println(objUser_data.strNewUserName1);

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		objUsersList1
				.navigateToUsers()
				.searchUserName(objUser_data.strNewUserName1,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals)
				.verEditLink(objUser_data.strNewUserName1)
				.verPasswordLink(objUser_data.strNewUserName1)
				.clickCreateNewUserButton()
				.VerifyNoOfRowsForResources()
				.verResourceName(objResource_data.strResourceName)
				.verResourceName(objResource_data.strResourceName1)
				.verViewResourceIsNotPresent()
				.enterUserDetails(objUser_data.strNewUserName2,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectAssociateWithOfResource(objResource_data.strResourceName)
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName2,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals)
				.verEditLink(objUser_data.strNewUserName2)
				.verPasswordLink(objUser_data.strNewUserName2)
				.searchUserName(objUser_data.strNewUserName1,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals)
				.editUserDetails(objUser_data.strNewUserName1)
				.enterFullName(objUser_data.strEditedFullName)
				.enterOrganization(objUser_data.strEditedOrganization)
				.clickSaveButton()
				.verFullName(objUser_data.strNewUserName1,
						objUser_data.strEditedFullName)
				.verOrganiZation(objUser_data.strNewUserName1,
						objUser_data.strEditedOrganization);
		
		objLogin1.clickLogOut();
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Verify that a user can be deactivated and then reactivated.
	'Precondition:
	'Date	 	 : 05-Aug-2014
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that a user can be deactivated and then reactivated.")
	public void testSmoke99633() throws Exception {
		gstrTCID = "99633";
		gstrTO	 = "Verify that a user can be deactivated and then reactivated.";
				
		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(this.driver1);
		
		objLogin.loginToApplication(objLogindata.strUserName,objLogindata.strPassword);
		
		objRegionDefault.selectFrame();
		
		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
		
		objNavigationToSubmenus.navigateToUsers();
		
		objUsersList.clickCreateNewUserButton()
					.enterAllUserDetails(objUserdata.strNewUserName,
							objUserdata.strNewPassword, objUserdata.strFullName, 
							objUserdata.strFirstName, objUserdata.strMiddleName, 
							objUserdata.strLastName, objUserdata.strOrganization, 
							objUserdata.strPhone, objUserdata.strPrimaryMailId, 
							objUserdata.strPrimaryMailId, objUserdata.strPrimaryMailId)
					.selectFirstRole()
					.clickSaveButton()
					.enterUsernameInSearchInputField(objUserdata.strNewUserName)
					.clickSearchButton()
					.verUserDetails(objUserdata.strNewUserName, objUserdata.strFullName, objUserdata.strOrganization);
		
		objLogin.clickLogOut();
		
		System.out.println("-----Precondition ends and test execution starts-------");
		
		objLogin1.loginToApplication(objLogindata.strUserName,objLogindata.strPassword);
		
		objRegionDefault1.selectFrame();
		
		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);
		
		objRegionDefault1.selectFrame()
						 .verifyRegionDefaultPage();
		
		objNavigationToSubmenus1.navigateToUsers();
		
		objUsersList1.enterUsernameInSearchInputField(objUserdata.strNewUserName)
					 .clickSearchButton()
					 .editUserDetails(objUserdata.strNewUserName)
					 .clickOnUserDeactivateChkBox()
					 .clickSaveButton()
					 .verifyWarningPage(objUserdata.strNewUserName, objUserdata.strFullName)
					 .clickOnYesDeactivateThisUserBtn()
					 .verifyDeactivationConfirmPage(objUserdata.strNewUserName, objUserdata.strFullName)
					 .clickOnReturnToListBtn()
					 .clickOnIncludeInactiveChkBox()
					 .verifyInactiveUserIsPresent(objUserdata.strNewUserName, objUserdata.strFullName);
		
		objLogin1.clickLogOut();			 
					 
		objLogin1.enterUserName(objUserdata.strNewUserName);
		objLogin1.enterPassword(objUserdata.strNewPassword);
		objLogin1.clickLogin();
		
		objLogin1.verifyInvalidUsernameAndPwdError()
				 .loginToApplication(objLogindata.strUserName,objLogindata.strPassword);
		
		objRegionDefault1.selectFrame();
		
		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);
		
		objRegionDefault1.selectFrame()
						 .verifyRegionDefaultPage();
		
		objNavigationToSubmenus1.navigateToUsers();
		
		objUsersList1.clickOnIncludeInactiveChkBox()
					 .enterUsernameInSearchInputField(objUserdata.strNewUserName)
					 .clickSearchButton()
					 .editUserDetails(objUserdata.strNewUserName)
					 .clickOnUserActivateChkBox()
					 .clickSaveButton()
					 .verifyReactivatedConfmMsg(objUserdata.strNewUserName, objUserdata.strFullName)
					 .clickOnReturnToListBtn()
					 .verFullName(objUserdata.strNewUserName, objUserdata.strFullName);
		
		objLogin1.clickLogOut();		
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName, objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame()
		 				 .verifyRegionDefaultPage();
		
		objLogin1.clickLogOut();
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Verify that a user-link can be created.
	'Precondition:
	'Date	 	 : 30-Jul-2014
	'Author		 : Sowmya
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that a user-link can be created.")
	public void testSmoke97760() throws Exception {
		
		gstrTCID = "97760";
		gstrTO	 = "Verify that a user-link can be created.";
		
		Login_data login_data = new Login_data();
		Label_data objLabel_data = new Label_data();
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		UserLinks objUserLinks = new UserLinks(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		
		objLogin.loginToApplication(login_data.strUserName,
				login_data.strPassword);
		
		objRegionDefault.selectFrame();

		objSelectRegion
				.selectRegionAndNavigate(login_data.strRegionName);

		objRegionDefault.selectFrame();
		
		objUsersList.clickOnSetUp();
		
	    objUserLinks.navigateToUserLinks()
	                .clkCreateNewUserLinkBtn()
					.vfyLabelTextInputOptipnIsPresent()
					.vfyImageFileOptipnIsPresent()
					.vfyselectTypeOfLinkToCreateOptipnIsPresent()
					.vfyUrlForAnExternalSiteInputOptipnIsPresent()
					.radioBtnOfURLForAnExternalSiteIsChecked()
					.vfyEMResourceFormInputOptipnIsPresent()
					.vfyQuickLinkOptipnIsPresent()
					.enterLabelText(objLabel_data.strLabelName)
	                .uploadFile(objLabel_data.strPathOfTheFile)
		            .enterURL(objLabel_data.strURL)
		            .clkOnSaveBtn()
	                .vfyEditOptionIsPresent(objLabel_data.strLabelName)
		            .vfyDeleteOptionIsPresent(objLabel_data.strLabelName)
					.vfyShowOptionIsPresent(objLabel_data.strLabelName)
					.vfyUpOptionIsPresent(objLabel_data.strLabelName)
					.vfyLinkNameInUserLinkList(objLabel_data.strLabelName)
					.vfyShowAs(objLabel_data.strLabelName, objLabel_data.strShowAsHide)
					.vfyDestinationURL(objLabel_data.strURL, objLabel_data.strLabelName)
	                .vfyImageSize(objLabel_data.strLabelName, objLabel_data.strImageSize)
		            .vfyFileSize(objLabel_data.strLabelName, objLabel_data.strFileSize);

		//Option 'User links' is not displayed at the top right of the screen 
		
		objUserLinks.clkShowLink(objLabel_data.strLabelName)
		            .vfyHideOptionIsPresent(objLabel_data.strLabelName)
		            .vfyShowAs(objLabel_data.strLabelName, objLabel_data.strShowAsUserLink);
		
		//The image is not displayed at the top of the screen (as a 'Quick Link'). 
		
		objUserLinks.mouseOverOnUserLinksInHeader().vfyAndClickCreatedLink(objLabel_data.strLabelName);
		
		String mainWindowHandle = driver1.getWindowHandle();

		Set<String> a = driver1.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		objSelectRegion.verTilte("Google");
		
		driver1.close();

		driver1.switchTo().window(mainWindowHandle);
		
		objRegionDefault.selectFrame();
		
		objUsersList.clickOnSetUp();
		
		objUserLinks.navigateToUserLinks()
		            .clkOnHideLink(objLabel_data.strLabelName)
		            .vfyShowOptionIsPresent(objLabel_data.strLabelName)
	                .vfyShowAs(objLabel_data.strLabelName, objLabel_data.strShowAsHide);
		
		//Option 'User links' is not displayed at the top right of the screen 
		
		objLogin.clickLogOut();
		gstrResult = "PASS";
	}
		
	/*******************************************************************************************
	'Description : Verify that RegAdmin can remove access from regions for a user who currently 
	               have access to multiple regions.
	'Precondition:
	'Date	 	 : 05-Aug-2014
	'Author		 : Sowmya
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = " Verify that RegAdmin can remove access from regions for a user who currently have "
			+ "access to multiple regions.")
	public void testSmoke91699() throws Exception {
		gstrTCID = "91699";
		gstrTO	 = "Verify that RegAdmin can remove access from regions for a user who currently have "
			+ "access to multiple regions.";
		
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(this.driver1);
		Regions objRegions = new Regions(this.driver1);
		String strRegionValue[] = new String[3];
	
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1); 
		UsersList objUsersList1 = new UsersList(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		
		
		String[] strRegionNames = {objTest_data.strQuickLinkRegion, objTest_data.strRegionName1, objTest_data.strRegionName};
		
		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(strRegionNames[0]);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToRegions();

		strRegionValue[0] = objRegions.getRegionValue(strRegionNames[0]);

		System.out.println(strRegionValue[0]);

		strRegionValue[1] = objRegions.getRegionValue(strRegionNames[1]);

		System.out.println(strRegionValue[1]);

		strRegionValue[2] = objRegions.getRegionValue(strRegionNames[2]);

		System.out.println(strRegionValue[2]);

		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals)
				.clickRegionsLinkForUser(objUser_data.strNewUserName)
				.selectRegion(strRegionValue[1])
				.selectRegion(strRegionValue[2])
				.clickSaveButton();

		objLogin.clickLogOut();

		System.out.println(objUser_data.strNewUserName);

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegion1.selectRegionAndNavigate(strRegionNames[0]);

		objRegionDefault1.selectFrame();

		objUsersList1
				.navigateToUsers()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals)
				.clickRegionsLinkForUser(objUser_data.strNewUserName)
				.verUserProfileInEditUserRegions()
				.verFullNameInEditUserRegions()
				.verOrganizationInEditUserRegions()
				.verUserRegionsInEditUserRegions()
				.verRegionsCheckBoxIsSelectd(strRegionValue[0])
				.verRegionsCheckBoxIsSelectd(strRegionValue[1])
				.verRegionsCheckBoxIsSelectd(strRegionValue[2]);

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame()
						 .clickRegionLink();

		objSelectRegion1.verSelectRegionPage();
                      //  .verRegionNameInDropdown(strRegionNames);

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault1.selectFrame();

		objUsersList1
				.navigateToUsers()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals)
				.clickRegionsLinkForUser(objUser_data.strNewUserName)
				.deselectRegion(strRegionValue[1])
				.deselectRegion(strRegionValue[2])
				.clickSaveButton();

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame().clickRegionLink();

		objSelectRegion1.verSelectRegionPageIsNotPresent();

		objLogin1.clickLogOut();
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Verify that while creating a new status type section can be selected.
	'Precondition:
	'Date	 	 : 06-Aug-2014
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that while creating a new status type section can be selected.")
	public void testSmoke126267() throws Exception {

		gstrTCID = "126267";
		gstrTO = "Verify that while creating a new status type section can be selected.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList1 = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		View_data objView_data = new View_data();
		ResourceType objResourceType1 = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource1 = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();
		Views objViews1 = new Views(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		String strstatusTypeValues[] = new String[5];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectConfigureRegionalUserAccessOption()
				.selectConfigureRegionViewsOption()
				.selectSetupStatusTypesOption()
				.selectSetupResourceTypesOption().selectSetupResourceOption()
				.clickSaveButton();

		// Modification done by sandhya
		objNavigationToSubmenus.navigateToViews();

		objViewsList.clickOncustomizeResourceDetailView()
				.enterSectionName(objView_data.strSectionName)
				.clickOnCreateSection()
				.verCreatedSection(objView_data.strSectionName)
				.clickOnSaveButton();
		// Modification done by sandhya

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame().verifyRegionDefaultPage();

		objNavigationToSubmenus1.navigateToStatusTypesInSetup();

		objStatusTypeList1.verCreateNewStatusTypeAndStandardStatusTypeLabels()
				.createStatusTypeWithSection(
						objStatusTypes_data.strNumberStatusType,
						objStatusTypes_data.strNSTStatusTypeName,
						objStatusTypes_data.strStatusDescription,
						objView_data.strSectionName);
		// .createStatusType(objStatusTypes_data.strNumberStatusType,
		// objStatusTypes_data.strNSTStatusTypeName,
		// objStatusTypes_data.strStatusDescription);
		strstatusTypeValues[0] = objStatusTypeList1
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList1
				.verStatusTypeAndSectionValInList(
						objStatusTypes_data.strNSTStatusTypeName,
						objView_data.strSectionName)
				.createStatusTypeWithSection(
						objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription,
						objView_data.strSectionName)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
				.clickOnReturnToStatusTypeList();

		strstatusTypeValues[1] = objStatusTypeList1
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList1.verStatusTypeAndSectionValInList(
				objStatusTypes_data.strMSTStatusTypeName,
				objView_data.strSectionName);

		objNavigationToSubmenus1.navigateToViews();

		String[] strNSTAndMST = { objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName };
		String[] strNSTAndMSTVal = { strstatusTypeValues[0],
				strstatusTypeValues[1] };

		objViewsList1.clickOncustomizeResourceDetailView();
		// .clickOnUncategorized()
		// .verStatusTypesInList(strNSTAndMST, strNSTAndMSTVal)
		// .enterSectionName(objView_data.strSectionName)
		// .clickOnCreateSection()
		// .verCreatedSection(objView_data.strSectionName)
		// .clickOnUncategorized()
		// .dragAndDropStatusType(objStatusTypes_data.strNSTStatusTypeName,
		// objView_data.strSectionName)
		// .clickOnUncategorized()
		// .dragAndDropStatusType(objStatusTypes_data.strMSTStatusTypeName,
		// objView_data.strSectionName)
		// .clickOnSection(objView_data.strSectionName);

		objViewsList1
				.verCountInSection(objView_data.strSectionName,
						strNSTAndMSTVal.length)
				.verStatusTypesInList(strNSTAndMST, strNSTAndMSTVal)
				.enterSectionName(objView_data.strSectionName1)
				.clickOnCreateSection()
				.verCreatedSection(objView_data.strSectionName1)
				.verCountInSection(objView_data.strSectionName1,
						objView_data.strDefaultCount).clickOnSaveButton();

		objNavigationToSubmenus1.navigateToStatusTypesInSetup();

		String[] strSectionNames = { objView_data.strSectionName,
				objView_data.strSectionName1 };

		objStatusTypeList1
				.clickCreateNewStatusTypeButton()
				.selectStatusType(
						objStatusTypes_data.strSaturationScoreStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strSSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription)
				.verSectionNamesInDropDown(strSectionNames)
				.selectSectionName(objView_data.strSectionName1)
				.clickOnSaveButton();

		strstatusTypeValues[2] = objStatusTypeList1
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList1.verStatusTypeAndSectionValInList(
				objStatusTypes_data.strSSTStatusTypeName,
				objView_data.strSectionName1).createStatusTypeWithSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName1);

		strstatusTypeValues[3] = objStatusTypeList1
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList1.verStatusTypeAndSectionValInList(
				objStatusTypes_data.strTSTStatusTypeName,
				objView_data.strSectionName1).createStatusTypeWithSection(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName1);

		strstatusTypeValues[4] = objStatusTypeList1
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objStatusTypeList1.verStatusTypeAndSectionValInList(
				objStatusTypes_data.strNDSTStatusTypeName,
				objView_data.strSectionName1);

		objNavigationToSubmenus1.navigateToViews();

		objViewsList1.clickOncustomizeResourceDetailView().clickOnSection(
				objView_data.strSectionName1);

		String[] strStatusTypesInSec1 = {
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName };
		String[] strSSTNDSTTSTVal = { strstatusTypeValues[2],
				strstatusTypeValues[3], strstatusTypeValues[4] };

		objViewsList1.verCountInSection(objView_data.strSectionName1,
				strSSTNDSTTSTVal.length).verStatusTypesInList(
				strStatusTypesInSec1, strSSTNDSTTSTVal);

		objNavigationToSubmenus1.navigateToResourceTypesInSetup();

		objResourceType1.createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType1
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objResourceType1
				.verResourceTypeInList(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus1.navigateToResourceInSetup();

		objResource1
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
		strResourceValue[0] = objResource1
				.getResourceValue(objResource_data.strResourceName);

		objResource1.verResourceInList(objResource_data.strResourceName);

		objNavigationToSubmenus1.navigateToViews();

		String[] strAllStatausTypes = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName };

		// objViewsList1.clickCreateNewViewButton()
		// .enterViewName(objView_data.strViewName)
		// .enterViewDesc(objView_data.strViewDesc);
		//
		// for (int i = 0; i < strAllStatausTypes.length; i++) {
		//
		// objViewsList1.selectStatusType(strAllStatausTypes[i]);
		// }
		//
		// objViewsList1.selectResource(objResource_data.strResourceName)
		// .clickOnSaveOfCreateNewView()
		// .verViewInList(objView_data.strViewName);

		objViewsList1.createView(objView_data.strViewName,
				objView_data.strViewDesc, objResource_data.strResourceName,
				strAllStatausTypes);

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViews1
				.verViewScreenIsDisplayed(objView_data.strViewName)
				.clickOnResource(objResource_data.strResourceName)
				.verResourceScreenDisplayed(objResource_data.strResourceName)
				.verStatusTypesUnderSection(
						objStatusTypes_data.strNSTStatusTypeName,
						objView_data.strSectionName)
				.verStatusTypesUnderSection(
						objStatusTypes_data.strMSTStatusTypeName,
						objView_data.strSectionName)
				.verStatusTypesUnderSection(
						objStatusTypes_data.strSSTStatusTypeName,
						objView_data.strSectionName1)
				.verStatusTypesUnderSection(
						objStatusTypes_data.strTSTStatusTypeName,
						objView_data.strSectionName1)
				.verStatusTypesUnderSection(
						objStatusTypes_data.strNDSTStatusTypeName,
						objView_data.strSectionName1);

		objLogin1.clickLogOut();
		gstrResult = "PASS";
	}
	
	/****************************************************************************************************************
	'Description : Verify that user with ‘Override Viewing restrictions’ right can view all the refined status 
	               type on 1. Region View screen 2. View Resource Detail screen 3. Map screen 4. Event Status screen
	'Precondition:
	'Date	 	 : 06-Aug-2014
	'Author		 : Sowmya
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	******************************************************************************************************************/
	@Test(description = " Verify that user with ‘Override Viewing restrictions’ right can view all the refined status "
			+ "type on 1. Region View screen 2. View Resource Detail screen 3. Map screen 4. Event Status screen")
	public void testSmoke99786() throws Exception {
		
		gstrTCID = "99786";
		gstrTO	 = " Verify that user with ‘Override Viewing restrictions’ right can view all the refined status "
			+ "type on 1. Region View screen 2. View Resource Detail screen 3. Map screen 4. Event Status screen";
		
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();

		ViewsList objViewsList = new ViewsList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		String strstatusTypeValues[] = new String[15];
		String strResourceValue[] = new String[2];
		String strResourceTypeValue[] = new String[2];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		Views objViews1 = new Views(this.driver1);
		Map objMap1 = new Map(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);
		
		String strViewName = objView_data.strViewName;

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		objStatusTypeList.navigateToStatusTypeListNew()

		// RoleBased statustypes
				.createStatusTypeWithSection(
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

		// Shared statustypes
		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName1);

		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[6] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName1);

		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		objStatusTypeList.navigateToStatusTypeListNew();

		strstatusTypeValues[7] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName1);

		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[8] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName1);

		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[9] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName1);

		// Private statustypes
		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName2,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[10] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName2);

		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName2,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[11] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName2);

		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName2,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		objStatusTypeList.navigateToStatusTypeListNew();

		strstatusTypeValues[12] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName2);

		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName2,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[13] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName2);

		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName2,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[14] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName2);

		// Resource type creation
		objResourceType.navigateToResourceTypePage()
		               .createResourceType(
				            objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName1, strstatusTypeValues);

		strResourceTypeValue[1] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName1);

		// create resource with address

		objResource.navigateToResourceListPage()
		           .createResourceWithAddress(
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

		objResource.createResourceWithAddress(
				objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName1,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);

		strResourceValue[1] = objResource
				.getResourceValue(objResource_data.strResourceName1);

		// create view
		String[] strStatusTypeNames = {
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strNSTStatusTypeName1,
				objStatuTypes_data.strTSTStatusTypeName1,
				objStatuTypes_data.strMSTStatusTypeName1,
				objStatuTypes_data.strSSTStatusTypeName1,
				objStatuTypes_data.strNDSTStatusTypeName1,
				objStatuTypes_data.strNSTStatusTypeName2,
				objStatuTypes_data.strTSTStatusTypeName2,
				objStatuTypes_data.strMSTStatusTypeName2,
				objStatuTypes_data.strSSTStatusTypeName2,
				objStatuTypes_data.strNDSTStatusTypeName2 },
			strAllResourceName = {objResource_data.strResourceName, 
				objResource_data.strResourceName1 };

		objNavigationToSubMenus.navigateToViews();

//		objViewsList.clickCreateNewViewButton()
//		            .enterViewName(strViewName)
//				    .enterViewDesc(objView_data.strViewDesc);
//
//		for (int i = 0; i < strStatusTypeNames.length; i++) {
//
//			objViewsList.selectStatusType(strStatusTypeNames[i]);
//		}
//
//		objViewsList.selectResource(objResource_data.strResourceName)
//				    .selectResource(objResource_data.strResourceName1)
//				    .clickOnSaveOfCreateNewView();
		
		objViewsList.createViewForMultipleResourcesAndStatusTypes(
				strViewName, objView_data.strViewDesc,
				strAllResourceName, strStatusTypeNames);
		
		// create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strstatusTypeValues);


		// User creation
		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.deselectViewResourceCheckBox(objResource_data.strResourceName)
				.deselectViewResourceCheckBox(objResource_data.strResourceName1)
				.clickSaveButton();

		// User creation
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName1)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton();

		objLogin.clickLogOut();
		objLogin.loginAsNewUser(objUser_data.strNewUserName1,
						objUser_data.strNewPassword);

		objRegionDefault.selectFrame();

		// Event creation
		objEventManagement.navigateToEventManagement()
						  .clickOnCreateNewEvent()
						  .clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
						  .enterAdHocEventName(objEvent_data.strEventName)
						  .enterAdHocEventDescription(objEvent_data.strEventDescription);

		objResource.clickResource(strResourceValue);

		objEventManagement.clickOnSaveButton();
		
		objLogin.clickLogOut();
		
		System.out.println(objUser_data.strNewUserName);

		System.out.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();

		objUsersList1
				.navigateToUsers()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals)
				.editUserDetails(objUser_data.strNewUserName)
				.clickRefineLinkOfViewResource(objResource_data.strResourceName)
				.selectFrameOfRefineVisibleStatusTypes();

		String[] strstatusTypeValue = { strstatusTypeValues[0],
				strstatusTypeValues[2], strstatusTypeValues[6],
				strstatusTypeValues[8] };

		objUsersList1.deselectStatusTypesInRefine(strstatusTypeValue)
				     .clickSaveChangesButtonInRefine().selectFrame();

		Thread.sleep(5000);

		objUsersList1.clickAdvancedOptionAndExpand()
				     .selectOverrideViewingRestrictionOption().clickSaveButton();

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(strViewName);

		objViews1
				.verViewScreenIsDisplayed(objView_data.strViewName)
				.verResource(objResource_data.strResourceName)
				.verResourceTypeAndResourceName(
						objResourceType_data.strResourceTypeName,
						objResource_data.strResourceName);

		for (int i = 0; i < strStatusTypeNames.length; i++) {

			objViews1.verStatusTypes(objResourceType_data.strResourceTypeName,
					strStatusTypeNames[i]);
		}

		objViews1.clickOnResource(objResource_data.strResourceName)
				 .verResourceScreenDisplayed(objResource_data.strResourceName);

		for (int i = 0; i < strStatusTypeNames.length; i++) {
			objViews1.verStatusTypesUnderSection(strStatusTypeNames[i],
					objView_data.strSectionName);
		}

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verResourceNameInPopupWindow(objResource_data.strResourceName)
				.verStatusTypesInPopupWindow(strStatusTypeNames)
				.selectResourceNameInFindResourceDropdown(
						objResource_data.strResourceName1)
				.verResourceNameInPopupWindow(objResource_data.strResourceName1)
				.verStatusTypesInPopupWindow(strStatusTypeNames);

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int i = 0; i < strStatusTypeNames.length; i++) {
			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strStatusTypeNames[i]);
		}

		objLogin1.clickLogOut();
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Verify that section can be selected while editing a status type
	'Precondition:
	'Date	 	 : 11-Aug-2014
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = " Verify that section can be selected while editing a status type")
	public void testSmoke126268() throws Exception {

		gstrTCID = "126268";
		gstrTO = " Verify that section can be selected while editing a status type";

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
		StatusTypeList objStatusTypeList1 = new StatusTypeList(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		Map objMap1 = new Map(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[5];
		String strSharedAndPrivateStatusTypeValues[] = new String[2];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName2);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName)
				.createNewSection(objView_data.strSectionName1)
				.createNewSection(objView_data.strSectionName2);

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strPNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strSharedAndPrivateStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strPNSTStatusTypeName);

		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strSharedAndPrivateStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSSTStatusTypeName);

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
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

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

		objResource
				.verResourceInList(objResource_data.strResourceName)
				.clickOnStatusTypeLinkInResourcePage(
						objResource_data.strResourceName)
				.selectStatusType(strSharedAndPrivateStatusTypeValues)
				.clickOnSaveButton();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectConfigureRegionalUserAccessOption()
				.selectConfigureRegionViewsOption()
				.selectSetupStatusTypesOption()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickSaveButton()
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton();

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame().verifyRegionDefaultPage();

		objNavigationToSubmenus1.navigateToStatusTypesInSetup();

		objStatusTypeList1
				.verStatusTypeAndSectionValInList(
						objStatusTypes_data.strPNSTStatusTypeName,
						objView_data.strSectionName)
				.verStatusTypeAndSectionValInList(
						objStatusTypes_data.strSSSTStatusTypeName,
						objView_data.strSectionName)
				.verStatusTypeAndSectionValInList(
						objStatusTypes_data.strNSTStatusTypeName,
						objStatusTypes_data.strUncategorizedValInSection)
				.verStatusTypeAndSectionValInList(
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strUncategorizedValInSection)
				.verStatusTypeAndSectionValInList(
						objStatusTypes_data.strTSTStatusTypeName,
						objStatusTypes_data.strUncategorizedValInSection)
				.verStatusTypeAndSectionValInList(
						objStatusTypes_data.strSSTStatusTypeName,
						objStatusTypes_data.strUncategorizedValInSection)
				.verStatusTypeAndSectionValInList(
						objStatusTypes_data.strNDSTStatusTypeName,
						objStatusTypes_data.strUncategorizedValInSection)
				.clickOnEditOfStatusType(
						objStatusTypes_data.strNSTStatusTypeName)
				.selectSectionName(objView_data.strSectionName1)
				.clickOnSaveButton()
				.verStatusTypeAndSectionValInList(
						objStatusTypes_data.strNSTStatusTypeName,
						objView_data.strSectionName1)
				.clickOnEditOfStatusType(
						objStatusTypes_data.strMSTStatusTypeName)
				.selectSectionName(objView_data.strSectionName1)
				.clickOnSaveButton()
				.verStatusTypeAndSectionValInList(
						objStatusTypes_data.strMSTStatusTypeName,
						objView_data.strSectionName1)
				.clickOnEditOfStatusType(
						objStatusTypes_data.strTSTStatusTypeName)
				.selectSectionName(objView_data.strSectionName1)
				.clickOnSaveButton()
				.verStatusTypeAndSectionValInList(
						objStatusTypes_data.strTSTStatusTypeName,
						objView_data.strSectionName1)
				.clickOnEditOfStatusType(
						objStatusTypes_data.strSSTStatusTypeName)
				.selectSectionName(objView_data.strSectionName1)
				.clickOnSaveButton()
				.verStatusTypeAndSectionValInList(
						objStatusTypes_data.strSSTStatusTypeName,
						objView_data.strSectionName1)
				.clickOnEditOfStatusType(
						objStatusTypes_data.strNDSTStatusTypeName)
				.selectSectionName(objView_data.strSectionName1)
				.clickOnSaveButton()
				.verStatusTypeAndSectionValInList(
						objStatusTypes_data.strNDSTStatusTypeName,
						objView_data.strSectionName1);

		objNavigationToSubmenus1.navigateToMap();

		String[] strStatusTypeNames = {
				objStatusTypes_data.strPNSTStatusTypeName,
				objStatusTypes_data.strSSSTStatusTypeName };
		String[] strStatusTypeNamesUnderSec1 = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName };

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verResourceNameInPopupWindow(objResource_data.strResourceName)
				.verViewInfoInPopupWindow()
				.verUpdateStatusInPopupWindow()
				.clickOnViewInfoInPopupWindow()
				.verViewResDetailScreenIsDisplayedWithResName(
						objResource_data.strResourceName)
				.verStatusTypesUnderSection(strStatusTypeNames,
						objView_data.strSectionName)
				.verStatusTypesUnderSection(strStatusTypeNamesUnderSec1,
						objView_data.strSectionName1);

		objNavigationToSubmenus1.navigateToViews();

		objViewsList1.clickOncustomizeResourceDetailView().clickOnSection(
				objView_data.strSectionName);

		objViewsList1
				.verStatusTypesInList(strStatusTypeNames,
						strSharedAndPrivateStatusTypeValues)
				.verCountInSection(objView_data.strSectionName,
						strSharedAndPrivateStatusTypeValues.length)
				.clickOnSection(objView_data.strSectionName1);

		objViewsList1
				.verStatusTypesInList(strStatusTypeNamesUnderSec1,
						strStatusTypeValues)
				.verCountInSection(objView_data.strSectionName1,
						strStatusTypeValues.length)
				.clickOnSection(objView_data.strSectionName2);

		// modification done by sandhya

		objViewsList1
				.verCountInSection(objView_data.strSectionName2,
						objView_data.strDefaultCount)
				.editSectionName(objView_data.strSectionName,
						objView_data.strEditedSectionName).clickOnSaveButton();

		objNavigationToSubmenus1.navigateToStatusTypesInSetup();

		objStatusTypeList1
				.clickOnEditOfStatusType(
						objStatusTypes_data.strSSSTStatusTypeName)
				.selectSectionName(objView_data.strSectionName2)
				.clickOnSaveButton();
		// .dragAndDropStatusType(objStatusTypes_data.strSSSTStatusTypeName,
		// objView_data.strSectionName2)

		objNavigationToSubmenus1.navigateToViews();

		// modification done by sandhya

		objViewsList1
				.verRegionViewListPageIsDisplayed()
				.clickOncustomizeResourceDetailView()
				.clickOnSection(objView_data.strEditedSectionName)
				.verStatusTypesInList(
						objStatusTypes_data.strPNSTStatusTypeName,
						strSharedAndPrivateStatusTypeValues[0])
				.clickOnSection(objView_data.strSectionName1)
				.verStatusTypesInList(strStatusTypeNamesUnderSec1,
						strStatusTypeValues)
				.clickOnSection(objView_data.strSectionName2)
				.verStatusTypesInList(
						objStatusTypes_data.strSSSTStatusTypeName,
						strSharedAndPrivateStatusTypeValues[1]);

		objNavigationToSubmenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.clickOnViewInfoInPopupWindow()
				.verViewResDetailScreenIsDisplayedWithResName(
						objResource_data.strResourceName)
				.verStatusTypesUnderSection(
						objStatusTypes_data.strPNSTStatusTypeName,
						objView_data.strEditedSectionName)
				.verStatusTypesUnderSection(strStatusTypeNamesUnderSec1,
						objView_data.strSectionName1)
				.verStatusTypesUnderSection(
						objStatusTypes_data.strSSSTStatusTypeName,
						objView_data.strSectionName2);

		objLogin1.clickLogOut();
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : For a user U1, deselect a status type in the 'Refine Visible Status Types' window 
					for a resource and save, verify that the user cannot view the deselected status type from all the view 
					screens for that particular resource
	'Precondition:
	'Date	 	 : 12-Aug-2014
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "For a user U1, deselect a status type in the 'Refine Visible Status Types' window for a "
			+ "resource and save, verify that the user cannot view the deselected status type from all the view "
			+ "screens for that particular resource.")
	public void testSmoke99742() throws Exception {
		
		gstrTCID = "99742";
		gstrTO	 = "For a user U1, deselect a status type in the 'Refine Visible Status Types' window for a resource"
				+ " and save, verify that the user cannot view the deselected status type from all the view screens "
				+ "for that particular resource";
		
		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		View_data objView_data = new View_data();
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data =new Resource_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		CustomUnderView objCustomUnderView = new CustomUnderView(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		Views objViews = new Views(this.driver1);
		Map objMap1 = new Map(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);

		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;
		
		boolean blnTest = false;
		
		String strStatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[2];
		
		objLogin.loginToApplication(objLogindata.strUserName,objLogindata.strPassword);
		
		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName2);

		objRegionDefault.selectFrame();
		
		objNavigationToSubmenus.navigateToViews();
		
		objViewsList.createNewSection(objView_data.strSectionName);
		
		objNavigationToSubmenus.navigateToStatusTypesInSetup();
		
		objStatusTypeList.createStatusTypeWithSection(objStatusTypes_data.strNumberStatusType,
				  objStatusTypes_data.strNSTStatusTypeName,
				  objStatusTypes_data.strStatusDescription,objView_data.strSectionName);
		
		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);
		
		objStatusTypeList.createStatusTypeWithSection(objStatusTypes_data.strTextStatusType,
				  objStatusTypes_data.strTSTStatusTypeName,
				  objStatusTypes_data.strStatusDescription,objView_data.strSectionName);
		
		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);
		
		objNavigationToSubmenus.navigateToResourceTypesInSetup();
		
		objResourceType.createResourceType(objResourceType_data.strResourceTypeName, strStatusTypeValues);
		
		strResourceTypeValue[0] = objResourceType.getResourceTypeValue(objResourceType_data.strResourceTypeName);
		
		objNavigationToSubmenus.navigateToResourceInSetup();
		
		objResource.createResourceWithAddress(objResource_data.strResourceName, objResource_data.strResourceAbbrivation, 
				objResourceType_data.strResourceTypeName, objResource_data.strStandardResourceTypename, 
				objResource_data.strResourceFirstName, objResource_data.strResourceLastName, 
				objResource_data.strStreetAddress, objResource_data.strCity, objResource_data.strState, 
				objResource_data.strCounty, objResource_data.strZipcode);
		
		strResourceValue[0]=objResource.getResourceValue(objResource_data.strResourceName);
		
		objResource.createResourceWithAddress(objResource_data.strResourceName1, objResource_data.strResourceAbbrivation, 
				objResourceType_data.strResourceTypeName, objResource_data.strStandardResourceTypename, 
				objResource_data.strResourceFirstName, objResource_data.strResourceLastName, 
				objResource_data.strStreetAddress, objResource_data.strCity, objResource_data.strState, 
				objResource_data.strCounty, objResource_data.strZipcode);
		
		strResourceValue[1]=objResource.getResourceValue(objResource_data.strResourceName1);
		
		objNavigationToSubmenus.navigateToViews();
		
		String[] strAllStatausTypes = {objStatusTypes_data.strNSTStatusTypeName, objStatusTypes_data.strTSTStatusTypeName};
	    String[] strAllResourceName = {objResource_data.strResourceName, objResource_data.strResourceName1};
	    
//		objViewsList.clickCreateNewViewButton()
//					 .enterViewName(objView_data.strViewName)
//					 .enterViewDesc(objView_data.strViewDesc);
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
//		objViewsList.clickOnSaveOfCreateNewView()
//					 .verViewInList(objView_data.strViewName);
		
		objViewsList.createViewForMultipleResourcesAndStatusTypes(
				objView_data.strViewName, objView_data.strViewDesc,
				strAllResourceName, strAllStatausTypes);
		
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strStatusTypeValues);

		objNavigationToSubmenus.navigateToUsers();
		
		objUsersList.clickCreateNewUserButton()
					.enterUserDetails(objUserdata.strNewUserName,objUserdata.strNewPassword, objUserdata.strFullName)
					.selectFirstRole()
					.selectUpdateStatusOfResource(objResource_data.strResourceName)
					.selectUpdateStatusOfResource(objResource_data.strResourceName1)
					.clickAdvancedOptionAndExpand()
					.selectMaintainEventsOption()
					.selectViewcustomViewOption()
					.clickSaveButton();
		
		objLogin.clickLogOut();
		
		objLogin.loginAsNewUser(objUserdata.strNewUserName, objUserdata.strNewPassword);
		
		objRegionDefault.selectFrame()
		 				 .verifyRegionDefaultPage();
		
		objEventManagement.navigateToEventManagement()
		  				  .clickOnCreateNewEvent()
		  				  .clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
		  				  .enterAdHocEventName(objEvent_data.strEventName)
		  				  .enterAdHocEventDescription(objEvent_data.strEventDescription);
		
		objResource.clickResource(strResourceValue);

		objEventManagement.clickOnSaveButton();
		
		objNavigationToSubmenus.navigateToCustomInView();
		
		String[] strResource1Val = {strResourceValue[0]};
		String[] strResource2Val = {strResourceValue[1]};
		
		objCustomUnderView.clickOnSetupCustomViewLink()
						  .clickOnAddMoreResources()
						  .enterResNameInWhatField(objResource_data.strResourceName)
						  .clickOnSearch()
						  .selectResource(strResource1Val)
						  .enterResNameInWhatField(objResource_data.strResourceName1)
						  .clickOnSearch()
						  .selectResource(strResource2Val)
						  .clickOnAddToCustomView()
						  .clickOnOptions()
						  .selectAllChkBoxInOptions()
						  .selectStatusTypes(strStatusTypeValues)
						  .clickOnSave();
		
		objLogin.clickLogOut();
		
		System.out.println("-----Precondition ends and test execution starts-------");
		
		objLogin1.loginToApplication(objLogindata.strUserName,objLogindata.strPassword);

		objRegionDefault1.selectFrame();
		
		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName2);
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToUsers();
		
		String[] strStatusType1 = {strStatusTypeValues[0]};
		
		objUsersList1.enterUsernameInSearchInputField(objUserdata.strNewUserName)
		 			 .clickSearchButton()
		 			 .editUserDetails(objUserdata.strNewUserName)
					 .clickRefineLinkOfViewResource(objResource_data.strResourceName)
					 .verRefineVisiblesttausTypesWinIsDisplayed()
					 .selectFrameOfRefineVisibleStatusTypes()
					 .deselectStatusTypesInRefine(strStatusType1)
					 .clickSaveChangesButtonInRefine()
					 .selectFrame()
					 .clickSaveButton();
		
		objLogin1.clickLogOut();
		
		objLogin1.loginToApplication(objUserdata.strNewUserName, objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToParticularViewUnderViewMenu(objView_data.strViewName);
		
		objViews.verST1ForResource(objResource_data.strResourceName, objStatusTypes_data.strNSTStatusTypeName,objStatusTypes_data.strNotApllicable)
		        .verST2ForResource(objResource_data.strResourceName, objStatusTypes_data.strTSTStatusTypeName, objStatusTypes_data.strDashStatusTypes)
		        .verST1ForResource(objResource_data.strResourceName1, objStatusTypes_data.strNSTStatusTypeName,objStatusTypes_data.strDashStatusTypes)
		        .verST2ForResource(objResource_data.strResourceName1, objStatusTypes_data.strTSTStatusTypeName,objStatusTypes_data.strDashStatusTypes);
	
		objNavigationToSubmenus1.navigateToMap();
		
		String[] strStatusType2 = {objStatusTypes_data.strTSTStatusTypeName};
		
		objMap1.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName)
			   .verResourceNameInPopupWindow(objResource_data.strResourceName)
			   .verStatusTypesInPopupWindow(strStatusType2)
			   .selectResourceNameInFindResourceDropdown(objResource_data.strResourceName1)
			   .verStatusTypesInPopupWindow(strAllStatausTypes);
		
		objEventManagement1.clickOnEventNameInEventBanner(objEvent_data.strEventName);
		
		objViews.verST1ForResource(objResource_data.strResourceName, objStatusTypes_data.strNSTStatusTypeName,objStatusTypes_data.strNotApllicable)
        		.verST2ForResource(objResource_data.strResourceName, objStatusTypes_data.strTSTStatusTypeName, objStatusTypes_data.strDashStatusTypes)
        		.verST1ForResource(objResource_data.strResourceName1, objStatusTypes_data.strNSTStatusTypeName,objStatusTypes_data.strDashStatusTypes)
        		.verST2ForResource(objResource_data.strResourceName1, objStatusTypes_data.strTSTStatusTypeName,objStatusTypes_data.strDashStatusTypes)
				.clickOnResource(objResource_data.strResourceName)
				.verStatusTypesUnderSection(objStatusTypes_data.strTSTStatusTypeName, objView_data.strSectionName);
		
		objEventManagement1.clickOnEventNameInEventBanner(objEvent_data.strEventName);
			
		objViews.clickOnResource(objResource_data.strResourceName1)
				.verStatusTypesUnderSection(objStatusTypes_data.strNSTStatusTypeName, objView_data.strSectionName)
				.verStatusTypesUnderSection(objStatusTypes_data.strTSTStatusTypeName, objView_data.strSectionName);
		
		blnTest = true;

		if (blnTest) {
			String[] strTestData = {
					"99742",
					Login_data.strBuildName,
					objUserdata.strNewUserName + "/" + objLogindata.strPassword,
					objLogindata.strRegionName2, objEvent_data.strEventName,
					objEventSetUp_data.strEventTemplate,
					strAllResourceName[0] + "," + strAllResourceName[1],
					objResourceType_data.strResourceTypeName,
					strAllStatausTypes[0] + "," + strAllStatausTypes[1],
					"Verify mobile end condition", objView_data.strSectionName };

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "SmokeEvents");
		}
		gstrResult = "PASS";
	}
	
	/**********************************************************************************************
	 * 'Description : Verify that user who hasn't set 'Security Question' is prompted to set up 
	 * 				  'Security Question' after second login.
	 * 'Date        : 24-Apr-2015
	 * 'Author      : Pallavi
	 **********************************************************************************************/

	@Test(description = "Verify that user who hasn't set 'Security Question' is prompted to set up "
			+ "'Security Question' after second login.")
	public void testSmoke158845() throws Exception {
		
		gstrTCID = "158845";
		gstrTO = "Verify that user who hasn't set 'Security Question' is prompted to set up 'Security Question' "
					+ "after second login.";

		Login_data objTest_data = new Login_data();
		User_data objUserdata = new User_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		SecurityQuestion objSecurityQuestion = new SecurityQuestion(this.driver1);

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();

		// User creation
		objUsersList.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId)
				.clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId)
				.clickSaveButton();

		login_page.clickLogOut();

		System.out.println("-----------------Test execution starts---------------");

		login_page1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objSecurityQuestion.verifySecurityQuestionPageNotDisplayed();

		RegionDefault_page1.selectFrame()
						   .switchToDefaultFrame()
						   .selectFrame()
						   .verifyRegionDefaultPage();
		
		login_page1.clickLogOut()
				   .loginAsNewUser(objUserdata.strNewUserName1,
							objUserdata.strNewPassword);
		
		RegionDefault_page1.selectFrame()
						   .verifyRegionDefaultPage();
		
		objNavigationToSubMenus.navigateToSecurityQuestionsInPreferences();

		RegionDefault_page1.verWebNotificationframe();

		objSecurityQuestion.verifySecurityQuestionAndAnswerHeading()
						   .selectSecurityQuestion(objTest_data.strQuestionLast4DigitsOfDL)
						   .enterSecurityAnswer(objTest_data.strAnswerLast4DigitsOfDL)
						   .verifyEmailAddress(objUserdata.strPrimaryMailId)
						   .clickOnSave();

		RegionDefault_page1.switchToDefaultFrame().selectFrame();

		objSecurityQuestion.clickOnClose();

		login_page1.clickLogOut()
				   .launchEMRurl()
				   .enterUserName(objUserdata.strNewUserName)
				   .enterPassword(objUserdata.strNewPassword)
				   .clickLogin();
		
		objSecurityQuestion.verifySecurityQuestionAndAnswerHeading()
						   .selectSecurityQuestion(objTest_data.strQuestionLast4DigitsOfDL)
						   .enterSecurityAnswer(objTest_data.strAnswerLast4DigitsOfDL)
						   .verifyEmailAddress(objUserdata.strPrimaryMailId)
						   .clickOnSave();

		RegionDefault_page1.selectFrame()
						   .switchToDefaultFrame()
						   .selectFrame()
						   .verifyRegionDefaultPage();

		objNavigationToSubMenus.navigateToSecurityQuestionsInPreferences();

		RegionDefault_page1.verWebNotificationframe();
		
		objSecurityQuestion.verifySecurityQuestionAndAnswerHeading()
						   .verifySecurityQuestion(objTest_data.strQuestionLast4DigitsOfDL)
						   .verifySecurityAnswer(objTest_data.strAnswerLast4DigitsOfDL)
						   .verifyEmailAddress(objUserdata.strPrimaryMailId);

		gstrResult = "PASS";
	}
}