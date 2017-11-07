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

public class HappyDayCreateMultiStatusType extends TestNG_UI_EXTENSIONS {

	public HappyDayCreateMultiStatusType() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/*************************************************************************************
	'Description : Verify that a Multi status type can be created.
	'Precondition:
	'Date	 	 : 18-May-2015
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that a Multi status type can be created.")
	public void testHappyDay83386() throws Exception {

		gstrTCID = "83386";
		gstrTO = "Verify that a Multi status type can be created.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList1 = new StatusTypeList(this.driver1);
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
				.selectSetupStatusTypesOption().clickSaveButton();
        System.out.println(objUserdata.strNewUserName);
		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame().verifyRegionDefaultPage();

		objNavigationToSubmenus1.navigateToStatusTypesInSetup();

		objStatusTypeList1
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatusTypes_data.strMultiStatusType)
				.clickNextButton()
				.verifyCreateMultiStatusTypePage()
				.enterStatusTypeName(objStatusTypes_data.strMSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription)
				.clickOnSaveButton()
				.verifyCreateStatusPage(
						objStatusTypes_data.strMSTStatusTypeName)
				.createNewStatus(
				     objStatusTypes_data.strStatusNameInMulti,
				     objStatusTypes_data.strStatusColor)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
				      objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
				      objStatusTypes_data.strStatusNameInMulti)
				.verCreatedStatusInStatusListForMulti(
				      objStatusTypes_data.strStatusNameInMulti1)
				.clickOnReturnToStatusTypeList()
				.verifyActionColumnForMultiST(
						objStatusTypes_data.strMSTStatusTypeName)
				.verifyNameColumnForST(objStatusTypes_data.strMSTStatusTypeName)
				.verifyTypeColumnForST(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName)
				.verifySectionColumnForST(
						objStatusTypes_data.noSectionAssigned,
						objStatusTypes_data.strMSTStatusTypeName)
				.verifyDescriptionColumnForST(
						objStatusTypes_data.strStatusDescription,
						objStatusTypes_data.strMSTStatusTypeName)
				.verifyEventOnlyColumnForST(
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.eventOnlyNo)
				.verifyStandardTypeColumnForST(
						objStatusTypes_data.strMSTStatusTypeName, " ")
				.verifyStatusesColumnForST(
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strMultiStatusType, objStatusTypes_data.strStatusNameInMulti);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Verify that the option to trace the user can be selected for a multi status type.
	'Precondition:
	'Date	 	 : 18-May-2015
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that the option to trace the user can be selected for a multi status type.")
	public void testHappyDay66920() throws Exception {

		gstrTCID = "66920";
		gstrTO = "Verify that the option to trace the user can be selected for a multi status type.";

		
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		View_data objView_data = new View_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		Regions objRegions = new Regions(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strStatusesValues[] = new String[1];

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
				.selectStatusType(objStatusTypes_data.strMultiStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strMSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription)
				.selTraceUserchkBox().clickOnSaveButton();

		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusColor);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
						      objStatusTypes_data.strStatusColor)
						 .verCreatedStatusInStatusListForMulti(
						          objStatusTypes_data.strStatusNameInMulti1)
						 .clickOnReturnToStatusTypeList();

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

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
//		objViewsList.selectStatusType(objStatusTypes_data.strMSTStatusTypeName);
//
//		objViewsList.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();

		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc, objResource_data.strResourceName, objStatusTypes_data.strMSTStatusTypeName);
		
		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectSetupStatusTypesOption()
				.clickSaveButton();

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
				.selectMSTUpdateValue(strStatusTypeValues[0],
						strStatusesValues[0])
				.clickOnSaveButton()
				.verErrorWhenNameAndPwdNotGiven()
				.enterValInYourNameField(objUserdata.strNewUserName)
				.enterValInPasswordField(objUserdata.strUserPwd)
				.clickOnSaveButton()
				.verErrorWhenWrongPwdEntered()
				.verMSTUpdateValueRetained(strStatusTypeValues[0],
						strStatusesValues[0])
				.enterValInYourNameField(objUserdata.strNewUserName1)
				.enterValInPasswordField(objUserdata.strNewPassword)
				.clickOnSaveButton()
				.verifyUpdatedStatusValues(strResourceValue[0],
						strStatusTypeValues[0],
						objStatusTypes_data.strStatusNameInMulti);

		objViewsList1.clickOnIndividualUpdateStatus(strResourceValue[0], strStatusTypeValues[0]);

		objUpdateStatus1
				.selectMSTUpdateValue(strStatusTypeValues[0],
						strStatusesValues[0])		
				.enterValInYourNameField(objUserdata.strNewUserName)
				.enterValInPasswordField(objUserdata.strNewPassword)
				.clickOnSaveButton()
				.verifyUpdatedStatusValues(strResourceValue[0],
						strStatusTypeValues[0],
						objStatusTypes_data.strStatusNameInMulti);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Verify that a multi status type can be associated with a standard status type.
	'Precondition:
	'Date	 	 : 19-May-2015
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that a multi status type can be associated with a standard status type.")
	public void testHappyDay66921() throws Exception {

		gstrTCID = "66921";
		gstrTO = "Verify that a multi status type can be associated with a standard status type.";

		Login_data objLogindata = new Login_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();

		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList1 = new StatusTypeList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);
		
		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToStatusTypesInSetup();

		objStatusTypeList1.createStatusTypeWithStdStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objStatusTypes_data.strStandardStatusTypename4)
				.clickOnReturnToStatusTypeList()
				.verifyStandardTypeColumnForST(
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStandardStatusTypename4);

		objLogin1.clickLogOut();
		
		gstrResult="PASS";
	}
}
