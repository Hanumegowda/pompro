package requirementGroup.SetUp;

import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.Roles_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Regions;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.Roles;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class EdgeCaseDelegatedUserManagement extends TestNG_UI_EXTENSIONS {

	public EdgeCaseDelegatedUserManagement() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/***************************************************************************************
	'Description : Verify that 'Administer Users' check box is available only for the user
	 			   with 'Configure Regional User Access' right.
	'Date	 	 : 17-June-2014
	'Author		 : Yugender
	***************************************************************************************/
	
	@Test(description = "Verify that 'Administer Users' check box is available only for the user "
	 			   + "with 'Configure Regional User Access' right.")
	public void testEdgeCase139704() throws Exception {
		gstrTCID= "139704";
		
		Login login_page = new Login(this.driver1);	
		Login_data login_data = new Login_data();
		User_data objUser_data = new User_data();
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		
		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		UsersList UsersList_page1 = new UsersList(this.driver1);

	    login_page.loginToApplication(login_data.strUserName, login_data.strPassword);
	    	    
	    SelectRegion_page.selectRegionAndNavigate(login_data.strQuickLinkRegion);
	    
	    RegionDefault_page.selectFrame();
	    
	    UsersList_page.navigateToUsers()
	    			  .clickCreateNewUserButton()
	    			  .enterUserDetails(objUser_data.strNewUserName, objUser_data.strNewPassword, objUser_data.strFullName)
	    			  .selectFirstRole()
	    			  .clickAdvancedOptionAndExpand()
	    			  .selectConfigureRegionalUserAccessOption()
	    			  .clickSaveButton();
	    
	    System.out.println(objUser_data.strNewUserName);
	    
	    UsersList_page.clickCreateNewUserButton()
	    			  .enterUserDetails(objUser_data.strSecNewUserName,	objUser_data.strNewPassword, objUser_data.strFullName)
	    			  .selectFirstRole()
	    			  .clickSaveButton();
	    
	    System.out.println(objUser_data.strSecNewUserName);
	    
	    login_page.clickLogOut();
	   
System.out.println("-----Precondition ends and test execution starts-----");
	       	    
	    login_page1.loginAsNewUser(objUser_data.strNewUserName, objUser_data.strNewPassword);
	    
	    RegionDefault_page1.selectFrame();
	    
	    UsersList_page1.navigateToUsers()
	    			   .clickCreateNewUserButton()
	    			   .verAdministerUsersIsPresent();
	    
	    login_page1.clickLogOut()
	    		   .loginAsNewUser(objUser_data.strSecNewUserName, objUser_data.strNewPassword);
	    
	    RegionDefault_page1.selectFrame();
	    
	    UsersList_page1.verSetUpIsNotPresent();
	    
	    login_page1.clickLogOut();
	    gstrResult="PASS";
	}
	
	/***************************************************************************************
	'Description : Verify that options 'User Has Role', 'User Can Assign Role' are not available
	' 			   for 'Res Admin' while creating / editing a user.
	'Date	 	 : 19-June-2014
	'Author		 : Yugender
	***************************************************************************************/
	@Test (description = "Verify that options 'User Has Role', 'User Can Assign Role' are not available for 'Res Admin' while creating / editing a user.")
	public void testEdgeCase139705() throws Exception{

		gstrTCID = "139705";
		gstrTO	 = "Verify that options 'User Has Role', 'User Can Assign Role' are not available for 'Res Admin' while creating / editing a user.";

		//Objects for data
		ResourceType_data objResourceType_data=new ResourceType_data();
		Resource_data objResource_data=new Resource_data();
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		StatusTypes_data objStatusTypes_data=new StatusTypes_data();
		
		//Objects of Page for Fire fox Browser 
		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);
		ResourceType ResourceType_Page=new ResourceType(this.driver1);
		Resource Resource_Page =new Resource(this.driver1);
	    UsersList UsersList_page = new UsersList(this.driver1);
	    
	    //Objects of Page for IE Browser
	    Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		UsersList UsersList_page1 = new UsersList(this.driver1);
	    
		String strstatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResource = objResource_data.strResourceName;
		
		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strQuickLinkRegion);
	    
	    RegionDefault_page.selectFrame();
		
		StatusTypeList_page.navigateToStatusTypeList()
						   .createEventStatusTypeWithExpirationTime(
								   objStatusTypes_data.strNumberStatusType,
								   objStatusTypes_data.strNSTStatusTypeName,
								   objStatusTypes_data.strStatusDescription,
								   objStatusTypes_data.strStatusExpirationTime);
		
		strstatusTypeValues[0] = StatusTypeList_page.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		//Resource type creation 
		ResourceType_Page.navigateToResourceTypePage()
						 .createResourceType(objResourceType_data.strResourceTypeName, strstatusTypeValues);
		
		//Resource creation 
		Resource_Page.navigateToResourceListPage()
					 .createResource(strResource,
							 objResource_data.strResourceAbbrivation,
							 objResourceType_data.strResourceTypeName,
							 objResource_data.strStandardResourceTypename,
							 objResource_data.strResourceFirstName,
							 objResource_data.strResourceLastName);

		strResourceTypeValue[0]=Resource_Page.getResourceValue(objResource_data.strResourceName);
		
		//User creation
		UsersList_page.navigateToUsersNew()
					  .clickCreateNewUserButton()
	    			  .enterUserDetails(objUser_data.strNewUserName, objUser_data.strNewPassword, objUser_data.strFullName)
					  .selectFirstRole()
					  .selectFirstUserCanAssignRole()
					  .selectAdministerUsersOfResource(strResource)
					  .selectUpdateStatusOfResource(strResource)
					  .clickSaveButton();
		
		System.out.println(objUser_data.strNewUserName);
		
		UsersList_page.clickCreateNewUserButton()
					  .enterUserDetails(objUser_data.strSecNewUserName,	objUser_data.strNewPassword, objUser_data.strFullName)
					  .selectFirstRole()
					  .selectUpdateStatusOfResource(strResource)
					  .clickSaveButton();
		
		System.out.println(objUser_data.strNewUserName);
		
		login_page.clickLogOut();
		
		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		
		RegionDefault_page1.selectFrame();
		
		UsersList_page1.navigateToUsers()
					   .clickCreateNewUserButton()
	    			   .verifyUserTypeAndRolesIsDisplayed(strResource)
	    			   .verUserHasRoleIsNotPresent()
	    			   .verUserCanAssignRoleIsNotPresent()
	    			   .clickCancelButton()
	    			   .searchUserName(objUser_data.strSecNewUserName, objUser_data.strRole, objUser_data.strResourceType, objUser_data.strUsername, objUser_data.strsearchOption)
	    			   .editUserDetails(objUser_data.strSecNewUserName)
	    			   .verUserHasRoleIsNotPresent()
	    			   .verUserCanAssignRoleIsNotPresent();
	    
	    login_page1.clickLogOut();
	    gstrResult="PASS";
	}
	
	
	/***************************************************************************************
	 * 'Description : Verify that user with both'Configure Regional User Access'
	 *                and 'Resource Admin' right can deactivate any users in region. 
	 * 'Date        : 23-July-2014
	 * 'Author      : Anitha
	 ***************************************************************************************/
	@Test(description = "Verify that user with both'Configure Regional User Access' and 'Resource"
			+ " Admin' right can deactivate any users in region.")
	public void testEdgeCase141613() throws Exception {

		gstrTCID = "141613";
		gstrTO	 = "Verify that user with both'Configure Regional User Access' and 'Resource"
			+ " Admin' right can deactivate any users in region.";

		
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

		String strstatusTypeValues[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResource = objResource_data.strResourceName;

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page
				.selectRegionAndNavigate(objTest_data.strQuickLinkRegion);

		RegionDefault_page.selectFrame();

		// Status type creation
		StatusTypeList_page.navigateToStatusTypeList()
		                   .createStatusType(objStatusTypes_data.strNumberStatusType,
		                		   objStatusTypes_data.strNSTStatusTypeName,
		                		   objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[0] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		// Resource type creation
		ResourceType_Page.navigateToResourceTypePage()
		                 .createResourceType(objResourceType_data.strResourceTypeName,
		                		 strstatusTypeValues);

		// Resource creation
		Resource_Page.navigateToResourceListPage().createResource(strResource,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName);

		// User creation
		// User U1
		UsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserMandatoryDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole().selectFirstUserCanAssignRole()
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionalUserAccessOption()
				.selectAdministerUsersOfResource(strResource)
				.selectUpdateStatusOfResource(strResource)
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		// User U2
		UsersList_page
				.clickCreateNewUserButton()
				.enterUserMandatoryDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName1)
				.selectFirstRole()
				.selectUpdateStatusOfResource(strResource)
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName1);

		// User U3
		UsersList_page
				.clickCreateNewUserButton()
				.enterUserMandatoryDetails(objUser_data.strNewUserName2,
						objUser_data.strNewPassword, objUser_data.strFullName2)
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName2);

		login_page.clickLogOut();
		
		System.out.println("----Precondition ends and Testcase execution starts----");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		UsersList_page1
				.navigateToUsers()

				.searchUserName(objUser_data.strNewUserName1,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)

				.editUserDetails(objUser_data.strNewUserName1)

				.clickOnUserDeactivateChkBox()

				.clickSaveButton()

				.clickOnYesDeactivateThisUserBtn()

				.clickOnReturnToListBtn()
				
				.clickOnIncludeInactiveChkBox()
				
				.verifyInactiveUserIsPresent(objUser_data.strNewUserName1, objUser_data.strFullName1)
				
				.clickOnIncludeInactiveChkBox()

				.searchUserName(objUser_data.strNewUserName2,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)

				.editUserDetails(objUser_data.strNewUserName2)

				.deactivateUser()

				.clickSaveButton()

				.clickOnYesDeactivateThisUserBtn()

				.clickOnReturnToListBtn()
				
				.clickOnIncludeInactiveChkBox()
				
				.verifyInactiveUserIsPresent(objUser_data.strNewUserName2, objUser_data.strFullName2)
				
				.clickOnIncludeInactiveChkBox();

		login_page1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/***************************************************************************************
	 * 'Description : Verify that user with both' Configure Regional User Access' and 'Resource
	 *                 Admin' right can reactivate any of the deactivated users in region. 
	 * 'Date        : 24-July-2014
	 * 'Author      : Anitha
	 ***************************************************************************************/
	@Test(description = "Verify that user with both' Configure Regional User Access' and 'Resource"
			+ " Admin' right can reactivate any of the deactivated users in region..")
	public void testEdgeCase141614() throws Exception {

		gstrTCID = "141614";
		gstrTO	 = "Verify that user with both' Configure Regional User Access' and 'Resource"
			+ " Admin' right can reactivate any of the deactivated users in region..";
		
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

		String strstatusTypeValues[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResource = objResource_data.strResourceName;

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page
				.selectRegionAndNavigate(objTest_data.strQuickLinkRegion);

		RegionDefault_page.selectFrame();

		// Status type creation
		StatusTypeList_page.navigateToStatusTypeList()
		                   .createStatusType(objStatusTypes_data.strNumberStatusType,
		                		   objStatusTypes_data.strNSTStatusTypeName,
		                		   objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[0] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		// Resource type creation
		ResourceType_Page.navigateToResourceTypePage()
		                 .createResourceType(objResourceType_data.strResourceTypeName,
		                		 strstatusTypeValues);

		// Resource creation
		Resource_Page.navigateToResourceListPage().createResource(strResource,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName);

		// User creation
		// User U1
		UsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserMandatoryDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole().selectFirstUserCanAssignRole()
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionalUserAccessOption()
				.selectAdministerUsersOfResource(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		// User U2
		UsersList_page
				.clickCreateNewUserButton()
				.enterUserMandatoryDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName1)
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName1);
		
		UsersList_page
				.searchUserName(objUser_data.strNewUserName1,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)

				.editUserDetails(objUser_data.strNewUserName1)
				
				.deactivateUser()

				.clickSaveButton()

				.clickOnYesDeactivateThisUserBtn()

				.clickOnReturnToListBtn();
		
		login_page.clickLogOut();

		System.out.println("----Precondition ends and Testcase execution starts----");
		
		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		UsersList_page1
				.navigateToUsers()

				.clickOnIncludeInactiveChkBox()
				
				.searchUserName(objUser_data.strNewUserName1,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)

				.editUserDetails(objUser_data.strNewUserName1)

				.reactivateUser()

				.clickSaveButton()

				.clickOnReturnToListBtn()
				
				.clickOnIncludeInactiveChkBox();

		login_page1.clickLogOut();
		
		login_page1.loginAsNewUser(objUser_data.strNewUserName1,
				objUser_data.strNewPassword);
		
		RegionDefault_page1.selectFrame()
		
		.verifyRegionDefaultPage();
		gstrResult = "PASS";
	}
	
	/***************************************************************************************
	 * 'Description : Verify that user with 'Resource Admin' right can not change password of
	 *                users who do not have affiliated right on resources upon search. 
	 * 'Date        : 24-July-2014
	 * 'Author      : Anitha
	 ***************************************************************************************/
	@Test(description = "Verify that user with 'Resource Admin' right can not change password of users who"
			+ " do not have affiliated right on resources upon search.")
	public void testEdgeCase139719() throws Exception {

		gstrTCID = "139719";
		gstrTO	 = "Verify that user with 'Resource Admin' right can not change password of users who"
			+ " do not have affiliated right on resources upon search.";
		
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

		String strstatusTypeValues[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResource = objResource_data.strResourceName;

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page
				.selectRegionAndNavigate(objTest_data.strQuickLinkRegion);

		RegionDefault_page.selectFrame();

		// Status type creation
		StatusTypeList_page.navigateToStatusTypeList()
		                   .createStatusType(objStatusTypes_data.strNumberStatusType,
		                		   objStatusTypes_data.strNSTStatusTypeName,
		                		   objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[0] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		// Resource type creation
		ResourceType_Page.navigateToResourceTypePage()
		                 .createResourceType(objResourceType_data.strResourceTypeName,
		                		 strstatusTypeValues);

		// Resource creation
		Resource_Page.navigateToResourceListPage().createResource(strResource,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName);

		// User creation
		// User U1
		UsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserMandatoryDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectFirstUserCanAssignRole()
				.selectAdministerUsersOfResource(objResource_data.strResourceName)
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		// User U2
		UsersList_page
				.clickCreateNewUserButton()
				.enterUserMandatoryDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName1)
				.selectFirstRole()
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName1);

		System.out.println("----Precondition ends and Testcase execution starts----");
		
		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		UsersList_page1
				.navigateToUsers()
				
				.searchUserName(objUser_data.strNewUserName1,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
						
				.verifyEditAndPasswordLinksAreNotPresentforUser(objUser_data.strNewUserName1);
		
		gstrResult = "PASS";
						
	}

	
	/***************************************************************************************
	 * 'Description : Verify that 'User - Setup User Accounts' right is no longer available 
	 * 				while creating or editing user. 
	 * 'Date        : 24-July-2014
	 * 'Author      : Anil
	 ***************************************************************************************/
	@Test(description = "Verify that 'User - Setup User Accounts' right is no longer available"+
						" while creating or editing user.")
	public void testEdgeCase138767() throws Exception {

		gstrTCID = "138767";
		gstrTO	 = "Verify that 'User - Setup User Accounts' right is no longer available"+
				" while creating or editing user.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();

		// Objects of Page for IE Browser
		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		UsersList UsersList_page1 = new UsersList(this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);
		
		login_page1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page1
				.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page1.selectFrame();
		// User creation
		// User U1
		UsersList_page1
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserMandatoryDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.verifyRightsNameIsNotDisplayed(objUser_data.strSetUpUsersAccountsRight)
				.clickSaveButton()
				.enterUsernameInSearchInputField(objUser_data.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUser_data.strNewUserName)
				.clickAdvancedOptionAndExpand()
				.verifyRightsNameIsNotDisplayed(objUser_data.strSetUpUsersAccountsRight);

		login_page1.clickLogOut();
		
		gstrResult = "PASS";
						
	}

	/******************************************************************************************
	 * 'Description : Verify that roles are not cleared upon validation message on 'Create New User' screen
	 * 'Date        : 02-Mar-2016
	 * 'Author      : Anil
	 ******************************************************************************************/

	@Test(description = " Verify that roles are not cleared upon validation message on 'Create New User' screen")
	public void testEdgeCase138902() throws Exception {
		
		gstrTCID = "138902";
		gstrTO = " Verify that roles are not cleared upon validation message on 'Create New User' screenr";

		// Objects for data
		
		User_data objUser_data = new User_data();
		Login_data objLogindata = new Login_data();
		Roles_data objRolesData = new Roles_data();
		
		Roles objRoles1 = new Roles(this.driver1);
		// Objects for Page
		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		UsersList UsersList_page1 = new UsersList(this.driver1);
		NavigationToSubMenus NavigationToSubMenus_page1 = new NavigationToSubMenus(
				this.driver1);
		
		String strRoleValue[] = new String[2];
		
		login_page.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);
	
		SelectRegion_page1.selectRegionAndNavigate(objLogindata.strQuickLinkRegion);

		RegionDefault_page.selectFrame();
	
		NavigationToSubMenus_page1.navigateToRoles();
		
		objRoles1.createRole(objRolesData.strRoleName);
		
		strRoleValue[0] = objRoles1.getRoleValue(objRolesData.strRoleName);
		
		objRoles1.createRole(objRolesData.strRoleName1);
		
		strRoleValue[1] = objRoles1.getRoleValue(objRolesData.strRoleName1);
		
		UsersList_page1.navigateToUsersNew();
		
		UsersList_page1
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue[0])
				.selectUserCanAssignRoleCheckBox(strRoleValue[1])
				.clickSaveButton();
		System.out.println(objUser_data.strNewUserName);
	
		UsersList_page1.verifyRoleIsSelected(strRoleValue[0])
						.verifyUserCanAssignRoleIsSelected(strRoleValue[1])
						.verErrorHeading()
						.verErrorMsgWhenUserCanAssignRoleIsSelected();
          login_page.clickLogOut();
					
		gstrResult = "PASS";

	}
	/*******************************************************************************************
	'Description :  Verify that user with 'Resource Admin' right cannot 'Edit' his/her details
	'Precondition:
	'Date	 	 : 23-Sep-2014
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = " Verify that user with 'Resource Admin' right cannot 'Edit' his/her details")
	public void testEdgeCase139659() throws Exception {
		gstrTCID = "139659";
		gstrTO = " Verify that user with 'Resource Admin' right cannot 'Edit' his/her details";

		Login_data objTest_data = new Login_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		User_data objUser_data = new User_data();

		ResourceType objResourceType = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);

		String strstatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[2];
		

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		
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

		// Create Resource Type
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

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

		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectFirstUserCanAssignRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName1)
				.selectAdministerUsersOfResource(objResource_data.strResourceName)
				.selectAdministerUsersOfResource(objResource_data.strResourceName1)
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionViewsOption()
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		objLogin.clickLogOut();

		System.out.println("-----Precondition ends and test execution starts-------");


		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objUsersList1.navigateToUsers()
		.enterUsernameInSearchInputField(objUser_data.strNewUserName)
		.clickSearchButton()
		.verUserInList(objUser_data.strNewUserName)
		.verifyEditAndPasswordLinksAreNotPresentforUser(objUser_data.strNewUserName);

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	
	/*******************************************************************************************
	'Description :   Verify that user with both'Configure Regional User Access' and 'Resource Admin' right can edit all the users in region.
	'Precondition:
	'Date	 	 : 23-Sep-2014
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = " Verify that user with both'Configure Regional User Access' and 'Resource Admin'"+
						" right can edit all the users in region.")
	public void testEdgeCase141143() throws Exception {
		gstrTCID = "141143";
		gstrTO =" Verify that user with both'Configure Regional User Access' and 'Resource Admin'"+
				" right can edit all the users in region.";

		Login_data objTest_data = new Login_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		User_data objUser_data = new User_data();

		ResourceType objResourceType = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		
		String strstatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[2];
		

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		
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

		// Create Resource Type
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

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

		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectFirstUserCanAssignRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName1)
				.selectAdministerUsersOfResource(objResource_data.strResourceName)
				.selectAdministerUsersOfResource(objResource_data.strResourceName1)
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionalUserAccessOption()
				.clickSaveButton();

		objUsersList
		.clickCreateNewUserButton()
		.enterAllUserDetails(objUser_data.strNewUserName1,
				objUser_data.strNewPassword, objUser_data.strFullName1,
				objUser_data.strFirstName, objUser_data.strMiddleName,
				objUser_data.strLastName, objUser_data.strOrganization,
				objUser_data.strPhone, objUser_data.strPrimaryMailId,
				objUser_data.strPrimaryMailId,
				objUser_data.strPrimaryMailId)
		.selectFirstRole()
		.selectViewResourceRights(objResource_data.strResourceName)
		.selectViewResourceRights(objResource_data.strResourceName1)
		.selectUpdateStatusOfResource(objResource_data.strResourceName)
		.selectUpdateStatusOfResource(objResource_data.strResourceName1)
		.clickSaveButton();
		
		objUsersList
		.clickCreateNewUserButton()
		.enterAllUserDetails(objUser_data.strNewUserName2,
				objUser_data.strNewPassword, objUser_data.strFullName2,
				objUser_data.strFirstName, objUser_data.strMiddleName,
				objUser_data.strLastName, objUser_data.strOrganization,
				objUser_data.strPhone, objUser_data.strPrimaryMailId,
				objUser_data.strPrimaryMailId,
				objUser_data.strPrimaryMailId)
		.selectFirstRole()
		.selectViewResourceRights(objResource_data.strResourceName)
		.selectViewResourceRights(objResource_data.strResourceName1)
		.clickSaveButton();
		
		System.out.println(objUser_data.strNewUserName);

		objLogin.clickLogOut();

		System.out.println("-----Precondition ends and test execution starts-------");


		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objUsersList1.navigateToUsers()
		.clickOnShowAllUsersIfPresent()

		.verUserInList(objUser_data.strNewUserName)
		.verUserInList(objUser_data.strNewUserName2)
		.verifyEditAndPasswordLinkIsDisplayed(objUser_data.strNewUserName2)
		.verifyEditAndPasswordLinkIsDisplayed(objUser_data.strNewUserName)
		.verUserInList(objUser_data.strNewUserName1)
		.verifyEditAndPasswordLinkIsDisplayed(objUser_data.strNewUserName1)
		.editUserDetails(objUser_data.strNewUserName1)
		.verEditUserPageisDisplayed()
		.enterFullName(objUser_data.strEditedFullName)
		.clickSaveButton()
		.enterUsernameInSearchInputField(objUser_data.strNewUserName1)
		.clickSearchButton()
		.verUserInList(objUser_data.strNewUserName1)
		.verUserDetailsInUserList(objUser_data.strNewUserName1, objUser_data.strEditedFullName, objUser_data.strOrganization);
		
		objNavigationToSubmenus1.navigateToUsersInfoInPreferences();
		
		objUsersList1.enterOrganization(objUser_data.strEditedOrganization)
				.clickSaveButton()
				.navigateToUsers()
				.clickOnShowAllUsersIfPresent()
				.verUserInList(objUser_data.strNewUserName)
				.verUserDetailsInUserList(objUser_data.strNewUserName, objUser_data.strFullName, objUser_data.strEditedOrganization)
				.editUserDetails(objUser_data.strNewUserName2)
				.verEditUserPageisDisplayed()
				.enterOrganization(objUser_data.strEditedOrganization1)
				.clickSaveButton()
				.verUserInList(objUser_data.strNewUserName2)
				.verUserDetailsInUserList(objUser_data.strNewUserName2, objUser_data.strFullName2, objUser_data.strEditedOrganization1);
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/*******************************************************************************************
	'Description :  Verify that for 'Res Admin' while creating / editing an user under roles section only
	                the roles that are selected for res admin under 'User Can Assign' are available.
	'Precondition:
	'Date	 	 : 08-Mar-2016
	'Author		 : Sangappa K
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that for 'Res Admin' while creating / editing an user under roles section only"
			    + " the roles that are selected for res admin under 'User Can Assign' are available.")
	public void testEdgeCase143151() throws Exception {
		gstrTCID ="143151";
		gstrTO ="Verify that for 'Res Admin' while creating / editing an user under roles section only "
				+ "the roles that are selected for res admin under 'User Can Assign' are available.";

		Login_data objTest_data = new Login_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		User_data objUser_data = new User_data();
		Roles_data objRolesData = new Roles_data();

		ResourceType objResourceType = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		Roles objRoles = new Roles(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		
		String strstatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String[] strRoleValue = new String[2];

		
		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion
				.selectRegionAndNavigate(objTest_data.strQuickLinkRegion);

		objRegionDefault.selectFrame();
		
		objNavigationToSubmenus.navigateToRoles();
		
		objRoles.createRole(objRolesData.strRoleName);
		
		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);
		
		objRoles.createRole(objRolesData.strRoleName1);
		
		strRoleValue[1] = objRoles.getRoleValue(objRolesData.strRoleName1);
		
		objNavigationToSubmenus.navigateToStatusTypesInSetup();
	
	
		// create status types
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);


		// Create Resource Type
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

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

		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectRoleCheckBox(strRoleValue[0])
		        .selectUserCanAssignRoleCheckBox(strRoleValue[1])
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectAssosciateResourceRight(objResource_data.strResourceName)
				.selectAdministerUsersOfResource(objResource_data.strResourceName)
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		objLogin.clickLogOut();

		System.out.println("-----Precondition ends and test execution starts-------");


		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objUsersList1.navigateToUsers()

				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName)
			     .verifyRoleNameIsNotListed(strRoleValue[0])
		         .verifyRoleNameIsListed(strRoleValue[1])
				.selectRoleCheckBox(strRoleValue[1])
				.selectAssosciateResourceRight(objResource_data.strResourceName)
				.clickSaveButton()
				.enterUsernameInSearchInputField(objUser_data.strNewUserName1)
		        .clickSearchButton()
		        .verUserInList(objUser_data.strNewUserName1)
		        .editUserDetails(objUser_data.strNewUserName1)
		        .verifyRoleNameIsNotListed(strRoleValue[0])
		        .verifyRoleNameIsListed(strRoleValue[1])
		        .clickSaveButton();
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/*******************************************************************************************
	'Description : Verify that 'Resource Admin' can not deactivate a user who have access to multiple regions and do
	               not have role,have affiliated right on his/her resources.
	'Precondition:
	'Date	 	 : 09-March-2016
	'Author		 : Sangappa K
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that 'Resource Admin' can not deactivate a user who have access to multiple regions and "
			           + "do not have role,have affiliated right on his/her resources.")
	public void testEdgeCase139085() throws Exception {
		
		gstrTCID = "139085";
		gstrTO ="Verify that 'Resource Admin' can not deactivate a user who have access to multiple regions and do not"
				+ " have role,have affiliated right on his/her resources.";

		Login_data objTest_data = new Login_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		User_data objUser_data = new User_data();

		ResourceType objResourceType = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		Regions objRegions = new Regions(this.driver1);

		String strstatusTypeValues1[] = new String[1];
		String strstatusTypeValues2[] = new String[1];
		String strResourceTypeValue[] = new String[2];
		String strResourceValue[] = new String[4];
		String strRegionValue[] = new String[2];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion
				.selectRegionAndNavigate(objTest_data.strQuickLinkRegion);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions
				.getRegionValue(objTest_data.strQuickLinkRegion);

		System.out.println(strRegionValue[0]);

		strRegionValue[1] = objRegions
				.getRegionValue(objTest_data.strRegionName2);

		System.out.println(strRegionValue[1]);

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// create status types
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues2[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		// Create Resource Type1
		objResourceType.navigateToResourceTypePage()
				.createResourceType(objResourceType_data.strResourceTypeName1,
						strstatusTypeValues1);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName1);

		// Create Resource Type2

		objResourceType.navigateToResourceTypePage()
				.createResourceType(objResourceType_data.strResourceTypeName2,
						strstatusTypeValues2);

		strResourceTypeValue[1] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName2);

		// Resource creation
		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName1,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName1);

		// Resource creation
		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName2,
				objResource_data.strResourceAbbrivation1,
				objResourceType_data.strResourceTypeName1,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[1] = objResource
				.getResourceValue(objResource_data.strResourceName2);

		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName3,
				objResource_data.strResourceAbbrivation2,
				objResourceType_data.strResourceTypeName2,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[2] = objResource
				.getResourceValue(objResource_data.strResourceName3);

		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName4,
				objResource_data.strResourceAbbrivation3,
				objResourceType_data.strResourceTypeName2,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[3] = objResource
				.getResourceValue(objResource_data.strResourceName4);

		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectFirstUserCanAssignRole()
				.selectViewResourceRights(objResource_data.strResourceName1)
				.selectViewResourceRights(objResource_data.strResourceName2)
				.selectViewResourceRights(objResource_data.strResourceName3)
				.selectAdministerUsersOfResource(
						objResource_data.strResourceName1)
				.selectAdministerUsersOfResource(
						objResource_data.strResourceName2)
				.selectAdministerUsersOfResource(
						objResource_data.strResourceName3).clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName1)
				.selectViewResourceRights(objResource_data.strResourceName1)
				.selectViewResourceRights(objResource_data.strResourceName2)
				.clickSaveButton()
				.enterUsernameInSearchInputField(objUser_data.strNewUserName1);
		objUsersList.clickSearchButton();
		Thread.sleep(2000);
		objUsersList.clickRegionsLinkForUser(objUser_data.strNewUserName1)
				.selectRegion(strRegionValue[1]).clickSaveButton();

		System.out.println(objUser_data.strNewUserName);
		System.out.println(objUser_data.strNewUserName1);
		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objUsersList1.navigateToUsers().verifyUserListPageIsDisplayed()
				.enterUsernameInSearchInputField(objUser_data.strNewUserName1)
				.clickSearchButton();
		Thread.sleep(2000);

		objUsersList1.verUserInList(objUser_data.strNewUserName1)
				.verifyEditAndPasswordLinksAreNotPresentforUser(
						objUser_data.strNewUserName1);
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	/*******************************************************************************************
	'Description :  Verify that 'Advanced Option' is not available for 'Resource Admin' while creating / editing a user.
	'Precondition:
	'Date	 	 : 23-Sep-2014
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "  Verify that 'Advanced Option' is not available for 'Resource Admin' while creating / editing a user.")
	public void testEdgeCase138912() throws Exception {
		gstrTCID = "138912";
		gstrTO =" Verify that 'Advanced Option' is not available for 'Resource Admin' while creating / editing a user.";

		Login_data objTest_data = new Login_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		User_data objUser_data = new User_data();

		ResourceType objResourceType = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		
		String strstatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[2];
		

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		
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

		// Create Resource Type
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

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

		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectFirstUserCanAssignRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName1)
				.selectAdministerUsersOfResource(objResource_data.strResourceName)
				.selectAdministerUsersOfResource(objResource_data.strResourceName1)
				.clickSaveButton();
		
		// User creation
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName2,
						objUser_data.strNewPassword, objUser_data.strFullName2)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName1)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName1)
				.clickSaveButton();
		
		System.out.println(objUser_data.strNewUserName);

		objLogin.clickLogOut();

		System.out.println("-----Precondition ends and test execution starts-------");


		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objUsersList1.navigateToUsers()
		.verifyUserListPageIsDisplayed()
		.clickOnShowAllUsersIfPresent()

		.verUserInList(objUser_data.strNewUserName)
		.verifyEditAndPasswordLinkIsDisplayed(objUser_data.strNewUserName2)
		.clickCreateNewUserButton()
		.verifyCreateUserPageIsDisplayed()
		.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName1)
		.selectFirstRole()
		.verAdvancedOptionIsNotPresent()	
		.verAdvancedOptionsTextIsNotPresent()
		.selectUpdateStatusOfResource(objResource_data.strResourceName)
		.selectUpdateStatusOfResource(objResource_data.strResourceName1)
		.clickSaveButton()		
		.clickOnShowAllUsersIfPresent()
		.verifyEditAndPasswordLinkIsDisplayed(objUser_data.strNewUserName1)
		.editUserDetails(objUser_data.strNewUserName1)
		.verEditUserPageisDisplayed()
		.verAdvancedOptionIsNotPresent()	
		.verAdvancedOptionsTextIsNotPresent();
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	

	/*******************************************************************************************
	'Description :Verify that user with 'Resource Admin' right can edit users who have access to 
					multiple regions and have affiliated right on his/her resources.
	'Precondition:
	'Date	 	 : 23-Sep-2014
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that user with 'Resource Admin' right can edit users "+
			"who have access to multiple regions and have affiliated right on his/her resources.")
	public void testEdgeCase139058() throws Exception {
		gstrTCID = "139058";
		gstrTO ="Verify that user with 'Resource Admin' right can edit users "+
		"who have access to multiple regions and have affiliated right on his/her resources.";

		Login_data objTest_data = new Login_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		User_data objUser_data = new User_data();

		ResourceType objResourceType = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus NavigationToSubMenus_page = new NavigationToSubMenus(this.driver1);
		Regions Regions_page = new Regions(this.driver1);
		
		String strstatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[2];
		String strstatusTypeValues1[] = new String[1];
		String strResourceTypeValue1[] = new String[1];
		String strResourceValue1[] = new String[2];
		String strRegionValue[]= new String[2];
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		
		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion
				.selectRegionAndNavigate(objTest_data.strQuickLinkRegion);

		objRegionDefault.selectFrame();

		NavigationToSubMenus_page.navigateToRegions();
		
		strRegionValue[0] = Regions_page.getRegionValue(objTest_data.strQuickLinkRegion);
		System.out.println(strRegionValue[0]);
		
		strRegionValue[1] = Regions_page.getRegionValue(objTest_data.strRegionName);

		System.out.println(strRegionValue[1]);
		
		objStatusTypeList.navigateToStatusTypeListNew();

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


		// Create Resource Type
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName1, strstatusTypeValues1);

		strResourceTypeValue1[0] = objResourceType
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

		// Resource creation
		objResource.createResource(
				objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[1] = objResource
				.getResourceValue(objResource_data.strResourceName1);

		// Resource creation
		objResource.createResource(
				objResource_data.strResourceName2,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName1,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue1[0] = objResource
				.getResourceValue(objResource_data.strResourceName2);

		// Resource creation
		objResource.createResource(
				objResource_data.strResourceName3,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName1,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue1[1] = objResource
				.getResourceValue(objResource_data.strResourceName3);
		
		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectFirstUserCanAssignRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName1)
				.selectViewResourceRights(objResource_data.strResourceName2)
				.selectAdministerUsersOfResource(objResource_data.strResourceName)
				.selectAdministerUsersOfResource(objResource_data.strResourceName1)
				.selectAdministerUsersOfResource(objResource_data.strResourceName2)
				.clickSaveButton();
		
		// User creation
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName1)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName1)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName1)
				.clickSaveButton();
		
		// User creation
		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName2,
						objUser_data.strNewPassword, objUser_data.strFullName2)
				.enterOrganization(objUser_data.strOrganization)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName2)
				.selectUpdateStatusOfResource(objResource_data.strResourceName2)
				.clickSaveButton();
		objUsersList.clickOnShowAllUsersIfPresent()
		.clickRegionsLinkForUser(objUser_data.strNewUserName)
		.selectRegion(strRegionValue[0])
		.clickSaveButton();
		
		objUsersList.clickOnShowAllUsersIfPresent()
		.clickRegionsLinkForUser(objUser_data.strNewUserName2)
		.selectRegion(strRegionValue[0])
		.clickSaveButton();
		
		System.out.println(objUser_data.strNewUserName);

		objLogin.clickLogOut();

		System.out.println("-----Precondition ends and test execution starts-------");


		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objUsersList1.navigateToUsers()
		.verifyUserListPageIsDisplayed()
		.clickOnShowAllUsersIfPresent()

		.verUserInList(objUser_data.strNewUserName)
		.verifyEditAndPasswordLinkIsDisplayed(objUser_data.strNewUserName1)
		.verifyEditAndPasswordLinkIsDisplayed(objUser_data.strNewUserName2)
		.editUserDetails(objUser_data.strNewUserName2)
		.verEditUserPageisDisplayed()
		.enterFullName(objUser_data.strEditedFullName)
		.enterOrganization(objUser_data.strEditedOrganization)
		.clickSaveButton()
		.verUserDetailsInUserList(objUser_data.strNewUserName2, objUser_data.strEditedFullName, objUser_data.strEditedOrganization)
		.clickOnShowAllUsersIfPresent()
		.editUserDetails(objUser_data.strNewUserName1)
		.verEditUserPageisDisplayed();
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/*******************************************************************************************
	'Description : Verify that user with 'Resource Admin' right cannot change password of users who do not have affiliated right on resources.
	'Precondition:
	'Date	 	 : 09-March-2016
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that user with 'Resource Admin' right cannot change password of users who do not have affiliated right on resources.")
	public void testEdgeCase139636() throws Exception {

		gstrTCID = "139636";
		gstrTO = "Verify that user with 'Resource Admin' right cannot change password of users who do not have affiliated right on resources.";

		Login_data objTest_data = new Login_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		User_data objUser_data = new User_data();

		ResourceType objResourceType = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		
		String strstatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[2];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion
				.selectRegionAndNavigate(objTest_data.strQuickLinkRegion);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// create status types
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		// Create Resource Type1
		objResourceType.navigateToResourceTypePage()
				.createResourceType(objResourceType_data.strResourceTypeName1,
						strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName1);

		// Resource creation
		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName1,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName1);

		// Resource creation
		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName2,
				objResource_data.strResourceAbbrivation1,
				objResourceType_data.strResourceTypeName1,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[1] = objResource
				.getResourceValue(objResource_data.strResourceName2);

		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectAdministerUsersOfResource(
						objResource_data.strResourceName1)
				.selectAdministerUsersOfResource(
						objResource_data.strResourceName2).clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName1)
				.selectFirstRole().clickSaveButton();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objUsersList1.navigateToUsers()
				.enterUsernameInSearchInputField(objUser_data.strNewUserName1)
				.verEditLinkIsNotPresent(objUser_data.strNewUserName1)
				.verPasswordLinkIsNotPresent(objUser_data.strNewUserName1);

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
}
