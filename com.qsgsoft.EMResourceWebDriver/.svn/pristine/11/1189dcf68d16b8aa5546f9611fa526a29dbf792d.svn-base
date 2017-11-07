package requirementGroup.HAvBED;

import lib.dataObject.Login_data;
import lib.dataObject.Roles_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Roles;
import lib.page.SelectRegion;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class SendingAggregateDataToHHS extends TestNG_UI_EXTENSIONS{

	public SendingAggregateDataToHHS() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/***********************************************************************************************
	'Description :  	Verify that "May schedule and activate the HAvBED Interface " right is not 
						available under the 'Advanced right' section for a user with 'Setup User accounts' 
						right while creating/editing a user 
	'Date	 	 : 20-Oct-2014
	'Author		 : Anil
	************************************************************************************************/
	
	@Test(description ="Verify that 'May schedule and activate the HAvBED Interface ' right is not "+
						"available under the 'Advanced right' section for a user with 'Setup User accounts' "+
						"right while creating/editing a user ")
	public void testEdgeCase131425() throws Exception {
	
		gstrTCID = "131425";
		gstrTO = "Verify that 'May schedule and activate the HAvBED Interface ' right is not "+
				"available under the 'Advanced right' section for a user with 'Setup User accounts' "+
				"right while creating/editing a user ";

		Login_data login_data = new Login_data();	
		User_data objUser_data = new User_data();
		
		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);
		NavigationToSubMenus NavigationToSubMenus_page1=new NavigationToSubMenus(this.driver1);
		UsersList UsersList_page1 = new UsersList(this.driver1);
		
		login_page1.loginToApplication(login_data.strUserName, login_data.strPassword);
		
		SelectRegion_page1.selectRegionAndNavigate(login_data.strRegionName);
	    
	    RegionDefault_page1.selectFrame();
	    
	    NavigationToSubMenus_page1.navigateToUsers();
	    
	    UsersList_page1
				.clickCreateNewUserButton()	
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionalUserAccessOption()
				.clickSaveButton();
		
	    login_page1.clickLogOut();

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
	    
	    RegionDefault_page1.selectFrame();
	    
	    NavigationToSubMenus_page1.navigateToUsers();
	    
	    UsersList_page1
				.clickCreateNewUserButton()
  				.clickAdvancedOptionAndExpand()
  				.verHavBedScheduleAndActivateHaavBedInterfaceIsNotDisplayed()
  				.verifyRightsNameIsNotDisplayed(objUser_data.strHavBedRight)
  				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.clickSaveButton()
				.enterUsernameInSearchInputField(objUser_data.strNewUserName1)
				.clickSearchButton()
				.editUserDetails(objUser_data.strNewUserName1)
				.clickAdvancedOptionAndExpand()
				.verifyRightsNameIsNotDisplayed(objUser_data.strHavBedRight)
  				.verHavBedScheduleAndActivateHaavBedInterfaceIsNotDisplayed();
	    
	    login_page1.clickLogOut();

	    gstrResult = "PASS";
	}
	
	/***********************************************************************************************
	'Description :  	Verify that user with 'Setup Roles' right does not have "May schedule and 
						activate the HAvBED Interface " listed while creating/editing a role 
	'Date	 	 : 20-Oct-2014
	'Author		 : Anil
	************************************************************************************************/
	
	@Test(description ="Verify that user with 'Setup Roles' right does not have 'May schedule and "+
						"activate the HAvBED Interface ' listed while creating/editing a role")
	public void testEdgeCase131426() throws Exception {
	
		gstrTCID = "131426";
		gstrTO = "Verify that user with 'Setup Roles' right does not have 'May schedule and "+
				"activate the HAvBED Interface ' listed while creating/editing a role";

		Login_data login_data = new Login_data();	
		User_data objUser_data = new User_data();
		Roles_data objRoles_data = new Roles_data();
		
		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);
		NavigationToSubMenus NavigationToSubMenus_page1=new NavigationToSubMenus(this.driver1);
		UsersList UsersList_page1 = new UsersList(this.driver1);
		Roles objRoles1 = new Roles(this.driver1);
		
		login_page1.loginToApplication(login_data.strUserName, login_data.strPassword);
		
		SelectRegion_page1.selectRegionAndNavigate(login_data.strRegionName);
	    
	    RegionDefault_page1.selectFrame();
	    
	    NavigationToSubMenus_page1.navigateToUsers();
	    
	    UsersList_page1
				.clickCreateNewUserButton()	
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectSetUpRolesRight()
				.clickSaveButton();
		
	    login_page1.clickLogOut();

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
	    
	    RegionDefault_page1.selectFrame();
	    
	    NavigationToSubMenus_page1.navigateToRoles();
	    
	    objRoles1.clickOnCreateNewRoleBtn()
	    		.enterRoleName(objRoles_data.strRoleName)
			.verifyRightsNameIsNotDisplayed(objUser_data.strHavBedRight);
  		UsersList_page1.verHavBedScheduleAndActivateHaavBedInterfaceIsNotDisplayed();
	    objRoles1.clickOnSaveBtn();
	    
	    objRoles1.clickOnEditLinkOfRole(objRoles_data.strRoleName)
	    			.verifyRightsNameIsNotDisplayed(objUser_data.strHavBedRight);
	    UsersList_page1
  				.verHavBedScheduleAndActivateHaavBedInterfaceIsNotDisplayed();
	    
	    login_page1.clickLogOut();

	    gstrResult = "PASS";
	}

}
