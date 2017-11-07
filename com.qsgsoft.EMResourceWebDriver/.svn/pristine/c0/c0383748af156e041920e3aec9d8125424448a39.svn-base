package requirementGroup.SetUp;

import lib.dataObject.IncomingPationtNotificationData;
import lib.dataObject.InterfaceInSetUp_data;
import lib.dataObject.Label_data;
import lib.dataObject.Login_data;
import lib.dataObject.Resource_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.EventManagement;
import lib.page.IncomingPatientNotifications;
import lib.page.InterfacesInSetUp;
import lib.page.Login;
import lib.page.MailVerificationFunctions;
import lib.page.RegionDefault;
import lib.page.SelectRegion;
import lib.page.SystemNotifications;
import lib.page.UserLinks;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewHappyDayCreatingAndManagingUserLinks extends TestNG_UI_EXTENSIONS

	{

	public NewHappyDayCreatingAndManagingUserLinks() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/****************************************************************************************************************
	'Description    : Verify that ‘Incoming patient’ option under create/edit user link is available only in the regions in which Manual IPN is enabled.
	'Author		    : Sangappa K
	'Date	 	    : 5-Feb-2016
	'----------------------------------------------------------------------------------------------------------------
	'Modified Date			                                                            	Modified By
	'Date					                                                                Name
	*****************************************************************************************************************/

	@Test(description = "Verify that ‘Incoming patient’ option under create/edit user link is available only in the regions in which Manual IPN is enabled.")
	public void testSmoke175998() throws Exception {

		gstrTCID ="175998";
		gstrTO = "Verify that ‘Incoming patient’ option under create/edit user link is available only in the regions in which Manual IPN is enabled.";
			Login_data objLogin_data = new Login_data();

	
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);

		Login objLogin1 = new Login(this.driver1);

		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);

		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		UserLinks objUserLinks1 = new UserLinks(this.driver1);
		UsersList UsersList_page1 = new UsersList(this.driver1);

		IncomingPatientNotifications objIncomingPatientNotifications1 = new IncomingPatientNotifications(
				this.driver1);

		objLogin1.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogin_data.strSetracReg);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToIncomingPationt();

		objIncomingPatientNotifications1.selectEnabledCheckBox()
				.selectManualEntryCheckBox().clickOnSaveButton();
		
      UsersList_page1.clickOnSetUp();
		
	    objUserLinks1.navigateToUserLinks();
		

		objUserLinks1.clkCreateNewUserLinkBtn()
				.vfyCreateUserLinkPage().vfyIncomingPatientRadionBtn();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToIncomingPationt();

		objIncomingPatientNotifications1.deSelectEnabledCheckBox()
				.deSelectManualEntryCheckBox().clickOnSaveButton();
		
		   UsersList_page1.clickOnSetUp();
		   objUserLinks1.navigateToUserLinks()
		
		.clkCreateNewUserLinkBtn()
				.vfyCreateUserLinkPage()
				.vfyIncomingPatientRadionBtnIsNotPresent();
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";	

	}
	
	
	/****************************************************************************************************************
	'Description    : Verify that quick links created selecting ‘Incoming patient’ are available only for the user with ‘IPN - Create Incoming Patient Notifications’ right.
	'Author		    : Sangappa K
	'Date	 	    : 5-Feb-2016
	'----------------------------------------------------------------------------------------------------------------
	'Modified Date			                                                            	Modified By
	'Date					                                                                Name
	*****************************************************************************************************************/

	@Test(description =" Verify that quick links created selecting ‘Incoming patient’ are available only for the user with ‘IPN - Create Incoming Patient Notifications’ right.")
	public void testSmoke176001() throws Exception {

		gstrTCID ="176001";
		gstrTO = " Verify that quick links created selecting ‘Incoming patient’ are available only for the user with ‘IPN - Create Incoming Patient Notifications’ right.";
			
		Login_data objLogin_data = new Login_data();
			Label_data objLabel_data = new Label_data();
		User_data objUser_data = new User_data();

	
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UsersList UsersList_page1 = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		UserLinks objUserLinks1 = new UserLinks(this.driver1);
		IncomingPatientNotifications objIncomingPatientNotifications1 = new IncomingPatientNotifications(
				this.driver1);
	

		objLogin1.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogin_data.strSetracReg);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToIncomingPationt();

		objIncomingPatientNotifications1
				.selectManualEntryCheckBox().clickOnSaveButton();
		
		UsersList_page1.clickOnSetUp();
		
	    objUserLinks1.navigateToUserLinks();
		
		objUserLinks1.clkCreateNewUserLinkBtn()
		                 .vfyCreateUserLinkPage()
		                 .enterLabelText(objLabel_data.strLabelName)
                         .uploadFile(objLabel_data.strPathOfTheFile)
                         .vfyIncomingPatientRadionBtn()
                         .selIncomingPatientRadionBtn()
                         .selectQuickLinkChkBox() 
                         .clkOnSaveBtn()
                         .vfyShowOptionIsPresent(objLabel_data.strLabelName)
                         .clkShowLink(objLabel_data.strLabelName)
		                 .vfyHideOptionIsPresent(objLabel_data.strLabelName);
		   UsersList_page1.navigateToUsers()
		    
		    .clickCreateNewUserButton()
		    .enterUserMandatoryDetails(objUser_data.strNewUserName, objUser_data.strNewPassword, objUser_data.strFullName)
		    .selectFirstRole()
		    .clickAdvancedOptionAndExpand()
		    .selectCreateIncomingPatientNotificationsOption()
		    .clickSaveButton()
		    .clickCreateNewUserButton()
		    .enterUserMandatoryDetails(objUser_data.strNewUserName1, objUser_data.strNewPassword, objUser_data.strFullName1)
		    .selectFirstRole()
		    .clickSaveButton();
		   System.out.println(objUser_data.strNewUserName);
		   System.out.println(objUser_data.strNewUserName1);
		   System.out.println(objLabel_data.strLabelName);
		    
		   objLogin1.loginAsNewUser(objUser_data.strNewUserName, objUser_data.strNewPassword);
		     objRegionDefault1.selectFrame();
		     
		     objRegionDefault1.verQuickLink(objLabel_data.strLabelName);
		     
		     objLogin1.clickLogOut();
		     
		     objLogin1.loginAsNewUser(objUser_data.strNewUserName1, objUser_data.strNewPassword);
		     objRegionDefault1.selectFrame();
		     
		     objRegionDefault1.verQuickLinkNotDisplayed(objLabel_data.strLabelName);
		     
		     objLogin1.clickLogOut();
		 	gstrResult = "PASS";	
		   
	}	
}