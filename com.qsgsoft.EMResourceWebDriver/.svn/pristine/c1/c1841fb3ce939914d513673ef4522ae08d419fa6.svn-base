package requirementGroup.SettingUpStatusTypes;

import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.NavigationToSubMenus;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Regions;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UpdateStatus;
import lib.page.UsersList;
import lib.page.ViewsList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class HappyDayCreateTextStatusType extends TestNG_UI_EXTENSIONS {
	
	public HappyDayCreateTextStatusType() throws Exception {
		super();
	}

	
	/*************************************************************************************
	'Description :Verify that a Text status type can be created.  
	'Precondition:
	'Date	 	 : 18-May-2015
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that a Text status type can be created. ")
	public void testHappyDay83388() throws Exception {

		gstrTCID = "83388";
		gstrTO = "Verify that a Text status type can be created. ";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		
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
		StatusTypeList objStatusTypeList1 = new StatusTypeList(this.driver1);
		
		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectSetupStatusTypesOption()
				.clickSaveButton();
		
		objLogin.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
						objUserdata.strNewPassword);
		System.out.println(objUserdata.strNewUserName);
		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToStatusTypesInSetup();
		
		objStatusTypeList1.verifyStatusTypeListPage()
						  .clickCreateNewStatusTypeButton()
						  .verifySelectStatusTypePage()
						  .selectStatusType(
								  objStatusTypes_data.strTextStatusType)
						  .clickNextButton()
						  .verifyCreateTextStatusTypePage()
						  .enterStatusTypeName(
								  objStatusTypes_data.strTSTStatusTypeName);
					System.out.println(objStatusTypes_data.strTSTStatusTypeName);			  
					objStatusTypeList1.enterStatusTypeDescription(
								  objStatusTypes_data.strStatusDescription)
						  .clickOnSaveButton()
						  .verCreatedStatusInStatusListForMulti(
								  objStatusTypes_data.strTSTStatusTypeName)
						  .verifyActionColumnForNumberAndTextST(objStatusTypes_data.strTSTStatusTypeName, 
								  objStatusTypes_data.strTextStatusType)
						  .verifyNameColumnForST(objStatusTypes_data.strTSTStatusTypeName)
						  .verifyTypeColumnForST(objStatusTypes_data.strTextStatusType, 
								  objStatusTypes_data.strTSTStatusTypeName)
						  .verifyDescriptionColumnForST(objStatusTypes_data.strStatusDescription,
								  objStatusTypes_data.strTSTStatusTypeName)
						  .verifyEventOnlyColumnForST(objStatusTypes_data.strTSTStatusTypeName, 
								  objStatusTypes_data.eventOnlyNo)
						  .verifyStandardTypeColumnForST(objStatusTypes_data.strTSTStatusTypeName,
								  " ")
						  .verifySectionColumnForST(objStatusTypes_data.noSectionAssigned, 
								  objStatusTypes_data.strTSTStatusTypeName)
						  .verifyStatusesColumnForST(objStatusTypes_data.strTSTStatusTypeName, 
								  objStatusTypes_data.strTextStatusType, "");
				
		objLogin1.clickLogOut();
						  
		
		gstrResult = "PASS";
	}
	
	
	/*************************************************************************************
	'Description : Verify that the option to trace the user can be selected for a text status type. 
	'Precondition: 
	'Date : 17-May-2015
	'Author : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that the option to trace the user can be selected for a text status type.")
	public void testHappyDay68660() throws Exception {

		gstrTCID = "68660";
		gstrTO = "Verify that the option to trace the user can be selected for a text status type.";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		View_data objView_data = new View_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Regions Regions_Page = new Regions(this.driver1);
		
		String strstatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		
		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objnNavigationToSubMenus.navigateToRegions();
		
		Regions_Page.clickOnEditRegions(objTest_data.strRegionName)
					.selectStatusChangeNameTrace()
					.clickSaveButton();
		
		objStatusTypeList.navigateToStatusTypeListNew();

		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatuTypes_data.strTextStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatuTypes_data.strTSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatuTypes_data.strStatusDescription)
				.selTraceUserchkBox().clickOnSaveButton();
		
		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		// Resource type creation
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
				.selectFirstRole()
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickSaveButton();

		objnNavigationToSubMenus.navigateToViews();

		String[] strStatusTypeNames = {
		objStatuTypes_data.strTSTStatusTypeName };
		
//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);
//
//
//
//		for (int i = 0; i < strStatusTypeNames.length; i++) {
//
//			objViewsList.selectStatusType(strStatusTypeNames[i]);
//		}
//
//		objViewsList.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();
		
		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc, 
							objResource_data.strResourceName, strStatusTypeNames);
		
		objLogin.clickLogOut();

		System.out.println(objUser_data.strNewUserName);

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
						objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objnNavigationToSubMenus1.clickOnViewMenu();

		objnNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);
		
		objViewsList1.clickOnIndividualUpdateStatus(strResourceValue[0], strstatusTypeValues[0]);

		objUpdateStatus1
				.verInstructionForTraceUser(strstatusTypeValues[0])
				.verUserVerificationForTraceUser()
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[0],
						objView_data.strValueForTST)
				.clickOnSaveButton()
				.verErrorWhenNameAndPwdNotGiven()
				.enterNSTAndTSTUpdateValueISRetained(strstatusTypeValues[0],
						objView_data.strValueForTST)
				.enterValInYourNameField(objUser_data.strNewUserName)
				.enterValInPasswordField(objUser_data.strUserPwd)
				.clickOnSaveButton()
				.verErrorWhenWrongPwdEntered()
				.enterNSTAndTSTUpdateValueISRetained(strstatusTypeValues[0],
						objView_data.strValueForTST)
				.enterValInYourNameField(objUser_data.strNewUserName1)
				.enterValInPasswordField(objUser_data.strNewPassword)
				.clickOnSaveButton()
				.verifyUpdatedStatusValues(strResourceValue[0],
						strstatusTypeValues[0],
						objView_data.strValueForTST);

		objViewsList1.clickOnIndividualUpdateStatus(strResourceValue[0], strstatusTypeValues[0]);

		objUpdateStatus1
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[0],
						objView_data.strValueForTST1)
				.enterValInYourNameField(objUser_data.strNewUserName)
				.enterValInPasswordField(objUser_data.strNewPassword)
				.clickOnSaveButton()
				.verifyUpdatedStatusValues(strResourceValue[0],
						strstatusTypeValues[0],
						objView_data.strValueForTST1);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

}
