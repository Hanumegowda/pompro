package requirementGroup.SettingUpStatusTypes;

import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.UpdateStatus_data;
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

public class HappyDayCreateNumberStatusType  extends TestNG_UI_EXTENSIONS {
	
	public HappyDayCreateNumberStatusType() throws Exception {
		super();
	}

	/*************************************************************************************
	'Description : Verify that user can create a Number Status Type. 
	'Precondition:
	'Date	 	 : 18-May-2015
	'Author		 : Pallavi
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that user can create a Number Status Type.")
	public void testHappyDay66024() throws Exception {

		gstrTCID = "66024";
		gstrTO = "Verify that user can create a Number Status Type.";

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
		
		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

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
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToStatusTypesInSetup();
		
		objStatusTypeList1.verifyStatusTypeListPage()
						  .clickCreateNewStatusTypeButton()
						  .selectStatusType(
								  objStatusTypes_data.strNumberStatusType)
						  .clickNextButton()
						  .verifyCreateNumberStatusTypePage()
						  .enterStatusTypeName(
								  objStatusTypes_data.streNSTStatusTypeName)
						  .enterStatusTypeDescription(
								  objStatusTypes_data.strStatusDescription)
						  .clickOnSaveButton()
						  .verifyActionColumnForNumberAndTextST(objStatusTypes_data.streNSTStatusTypeName, 
								  objStatusTypes_data.strNumberStatusType)
						  .verifyNameColumnForST(objStatusTypes_data.streNSTStatusTypeName)
						  .verifyTypeColumnForST(objStatusTypes_data.strNumberStatusType, 
								  objStatusTypes_data.streNSTStatusTypeName)
						  .verifyDescriptionColumnForST(objStatusTypes_data.strStatusDescription,
								  objStatusTypes_data.streNSTStatusTypeName)
						  .verifyEventOnlyColumnForST(objStatusTypes_data.streNSTStatusTypeName, 
								  objStatusTypes_data.eventOnlyNo)
						  .verifyStandardTypeColumnForST(objStatusTypes_data.streNSTStatusTypeName,
								  " ")
						  .verifySectionColumnForST(objStatusTypes_data.noSectionAssigned, 
								  objStatusTypes_data.streNSTStatusTypeName)
						  .verifyStatusesColumnForST(objStatusTypes_data.streNSTStatusTypeName, 
								  objStatusTypes_data.strNumberStatusType, "");
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}

	/*************************************************************************************
	'Description : Verify that the option to trace the user can be selected for a number status type.
	'Precondition:
	'Date	 	 : 18-May-2015
	'Author		 : Pallavi
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that the option to trace the user can be selected for a number status type.")
	public void testHappyDay66090() throws Exception {

		gstrTCID = "66090";
		gstrTO = "Verify that the option to trace the user can be selected for a number status type.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		Regions objRegions = new Regions(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();
		ViewsList objViewsList = new ViewsList(this.driver1);
		View_data objView_data = new View_data();

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		objRegions.clickOnEditRegions(objLogindata.strRegionName)
				.selectStatusChangeNameTrace().clickSaveButton();

		objStatusTypeList.navigateToStatusTypeListNew();

		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatusTypes_data.strNumberStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strNSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription)
				.selTraceUserchkBox()
				.clickOnSaveButton();

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();
		
		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

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

		objNavigationToSubmenus.navigateToViews();

//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);
//
//		objViewsList.selectStatusType(objStatusTypes_data.strNSTStatusTypeName)
//					.selectResource(objResource_data.strResourceName)
//					.clickOnSaveOfCreateNewView();

		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc, 
						objResource_data.strResourceName, objStatusTypes_data.strNSTStatusTypeName);
		
		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectSetupStatusTypesOption()
				.clickSaveButton();
		
		System.out.println(objUserdata.strNewUserName);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnViewMenu();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1.clickOnIndividualUpdateStatus(strResourceValue[0], strStatusTypeValues[0]);

		objUpdateStatus1
				.verInstructionForTraceUser(strStatusTypeValues[0])
				.verUserVerificationForTraceUser()
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
						objView_data.strValueForUpdate)
				.clickOnSaveButton()
				.verErrorWhenNameAndPwdNotGiven()
				.enterValInYourNameField(objUserdata.strNewUserName)
				.enterValInPasswordField(objUserdata.strUserPwd)
				.clickOnSaveButton()
				.verErrorWhenWrongPwdEntered()
				.enterNSTAndTSTUpdateValueISRetained(strStatusTypeValues[0],
						objView_data.strValueForUpdate)
				.enterValInYourNameField(objUserdata.strNewUserName1)
				.enterValInPasswordField(objUserdata.strNewPassword)
				.clickOnSaveButton()
				.verifyUpdatedStatusValues(strResourceValue[0],
						strStatusTypeValues[0],
						objView_data.strValueForUpdate);

		objViewsList1.clickOnIndividualUpdateStatus(strResourceValue[0], strStatusTypeValues[0]);

		objUpdateStatus1
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
						objView_data.strValueForUpdate1)
				.enterValInYourNameField(objUserdata.strNewUserName)
				.enterValInPasswordField(objUserdata.strNewPassword)
				.clickOnSaveButton()
				.verifyUpdatedStatusValues(strResourceValue[0],
						strStatusTypeValues[0],
						objView_data.strValueForUpdate1);

		gstrResult = "PASS";
	}

	/*************************************************************************************
	'Description : Verify that a number status type can be associated with a standard status type. 
	'Precondition:
	'Date	 	 : 19-May-2015
	'Author		 : Pallavi
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that a number status type can be associated with a standard status type.")
	public void testHappyDay66091() throws Exception {

		gstrTCID = "66091";
		gstrTO = "Verify that a number status type can be associated with a standard status type.";

		Login_data objLogindata = new Login_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList1 = new StatusTypeList(this.driver1);
		
		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToStatusTypesInSetup();
		
		objStatusTypeList1.verifyStatusTypeListPage()
						  .clickCreateNewStatusTypeButton()
						  .selectStatusType(
								  objStatusTypes_data.strNumberStatusType)
						  .clickNextButton()
						  .verifyCreateNumberStatusTypePage()
						  .enterStatusTypeName(
								  objStatusTypes_data.streNSTStatusTypeName)
						  .selectStandardStatusTypename(
								  objStatusTypes_data.strStandardStatusTypename)
						  .enterStatusTypeDescription(
								  objStatusTypes_data.strStatusDescription)
						  .clickOnSaveButton()
						  .verifyNameColumnForST(objStatusTypes_data.streNSTStatusTypeName)
						  .verifyDescriptionColumnForST(objStatusTypes_data.strStatusDescription,
								  objStatusTypes_data.streNSTStatusTypeName)
						  .verifyStandardTypeColumnForST(objStatusTypes_data.streNSTStatusTypeName,
								  objStatusTypes_data.strStandardStatusTypename);
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
}
