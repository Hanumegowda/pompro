package requirementGroup.MultiRegion;

import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.Roles_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.LinksAtTopRightCorners;
import lib.module.NavigationToSubMenus;
import lib.page.CustomUnderView;
import lib.page.Login;
import lib.page.Map;
import lib.page.RegionDefault;
import lib.page.Regions;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.Roles;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UsersList;
import lib.page.Views;
import lib.page.ViewsList;

import org.apache.commons.lang3.ArrayUtils;
import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewMultiRegionView extends TestNG_UI_EXTENSIONS{

	public NewMultiRegionView() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/*************************************************************************************
	'Description :   Verify that user without "Configure Multi-Region Views" and with "Configure region view" right can view/delete/demote/assigns users to a multi region view
	'Precondition:
	'Date	 	 : 08-Aug-2014
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = " Verify that user without Configure Multi-Region Views and with Configure region view right can view/delete/demote/assigns users to a multi region view")
	public void testHappyDay130617() throws Exception {

		gstrTCID = "130617";
		gstrTO = " Verify that user without Configure Multi-Region Views and with Configure region view right can view/delete/demote/assigns users to a multi region view";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		CustomUnderView objCustomUnderView = new CustomUnderView(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		View_data objView_data = new View_data();

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];

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
				.selectConfigureRegionViewsOption()
				.clickSaveButton()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectConfigureRegionViewsOption()
				.selectConfigureMultiRegionViewsOption()
				.selectViewcustomViewOption().clickSaveButton();

		
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

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);
		System.out.println(objUserdata.strNewUserName1);
		System.out.println(objResource_data.strResourceName);
		System.out.println(strStatusTypeValues[0] + " " + objStatusTypes_data.strNSTStatusTypeName);
		System.out.println(strResourceValue[0]+ " " + objResource_data.strResourceName);

		objLogin.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToCustomInView();

		objCustomUnderView.clickOnSetupCustomViewLink()
				.enterCustomViewDetails(objView_data.strCustomView)
				.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch().selectResource(strResourceValue)
				.clickOnAddToCustomView().clickOnOptions()
				.selectAllChkBoxInOptions()
				.selectStatusTypes(strStatusTypeValues).clickOnSave()
				.clickOnPromote();

		objViewsList.verRegionViewListPageIsDisplayed().verViewInList(
				objView_data.strCustomView);

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToViews();

		System.out.println(objView_data.strCustomView);
		objViewsList1
				.verViewInList(objView_data.strCustomView)
				.verDeleteAssociatedWithMulRegView(objView_data.strCustomView)
				.verUsersAssociatedWithMulRegView(objView_data.strCustomView)
				.clickOnUsersAssociatedWithMulRegView(
						objView_data.strCustomView)
				.verAssgnUserToViewCustomPgeIsDisplayed(
						objView_data.strCustomView)
				.selectUserInEveSecutityPage(objUserdata.strNewUserName)
				.selectUserInEveSecutityPage(objUserdata.strNewUserName1)
				.clickOnSave()
				.verViewInList(objView_data.strCustomView)
				.verDemoteLinkAssociatedWithMulRegViewIsNotDisplayed(
								objView_data.strCustomView);

		objViewsList1
				.clickOnDeleteAssociatedWithMulRegView(
						objView_data.strCustomView)
				.verDelViewConfPgeIsDisplayed()
				.verDelViewConfirmationPge()
				.clickOnDelete()
				.verViewIsNotListed(objView_data.strCustomView);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Verify that only System admin can assign Configure Multi-Region Views right to a user.
	'Precondition:
	'Date	 	 : 28-Oct-2015
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that only System admin can assign Configure Multi-Region Views right to a user.")
	public void testHappyDay129637() throws Exception {

		gstrTCID = "129637";
		gstrTO = "Verify that only System admin can assign Configure Multi-Region Views right to a user.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList1 = new UsersList(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);

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
				.clickSaveButton();

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToUsers();

		objUsersList1
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectConfigureMultiRegionViewsOption().clickSaveButton();

		objUsersList1
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName)
				.clickAdvancedOptionAndExpand()
				.selectConfigureMultiRegionViewsOption().clickSaveButton();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Verify that user with "Configure Multi-Region Views" right can promote custom view to a multi region view 
	'Precondition:
	'Date	 	 : 02-Nov-2015
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that user with Configure Multi-Region Views right can promote custom view to a multi region view ")
	public void testHappyDay129634() throws Exception {

		gstrTCID = "129634";
		gstrTO = "Verify that user with Configure Multi-Region Views right can promote custom view to a multi region view ";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		View_data objView_data = new View_data();
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[6];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

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
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
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

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.streDateStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streDateStatusTypeName);

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

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectConfigureRegionViewsOption()
				.selectConfigureMultiRegionViewsOption()
				.selectViewcustomViewOption().clickSaveButton();

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToCustomInView();

		objCustomUnderView1.verCustomViewTableScreenIsDisplayed()
				.verPageWhenCustomViewNotCreated();

		objLinksAtTopRightCorners1.verCustomizeLink();

		objCustomUnderView1.clickOnSetupCustomViewLink()
	    .enterCustomViewDetails(objView_data.strCustomView)
		.clickOnAddMoreResources()
		.enterResNameInWhatField(objResource_data.strResourceName)
		.clickOnSearch().selectResource(strResourceValue)
		.clickOnAddToCustomView().clickOnOptions()
		.selectAllChkBoxInOptions()
		.selectStatusTypes(strStatusTypeValues).clickOnSave();
		
		objCustomUnderView1.clickOnPromote();

		objViewsList1.verRegionViewListPageIsDisplayed().verViewInList(
				objView_data.strCustomView);

		objNavigationToSubmenus1.navigateToCustomInView();

		objCustomUnderView1.verCustomViewTableScreenIsDisplayed()
				.verPageWhenCustomViewNotCreated();

		objLinksAtTopRightCorners1.verCustomizeLink();

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/**********************************************************************************
	'Description 	: Verify that user with "Configure Multi-Region Views" right can 
	                  demote a multi region view to his/her custom view.
	'Date 			: 29-June-2015 
	'Author 		: Anitha
	'----------------------------------------------------------------------------------
	'Modified Date			                        	                Modified By
	'Date					                                            Name
	***********************************************************************************/
	@Test(description = "Verify that user with Configure Multi-Region Views right can demote a multi"
			+ " region view to his/her custom view.")
	public void testHappyDay163501() throws Exception {

		gstrTCID = "163501";
		gstrTO = "Verify that user with Configure Multi-Region Views right can demote a multi"
				+ " region view to his/her custom view.";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		View_data objView_data = new View_data();
		User_data objUserdata = new User_data();
		Roles_data objRoles_data = new Roles_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		CustomUnderView objCustomUnderView = new CustomUnderView(this.driver1);
		Resource objResource = new Resource(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		Views objViews1 = new Views(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		String strRoleValue[] = new String[1];
		String strStatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		objStatusTypeList.navigateToStatusTypeListNew();

		// RoleBased statustypes
		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);
		objStatusTypeList.createNewStatus(
				objStatuTypes_data.strStatusNameInMulti,
				objStatuTypes_data.strStatusColor)

			  .createNewStatus(objStatuTypes_data.strStatusNameInMulti1,
					  objStatuTypes_data.strStatusColor);
	
		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strDateStatusType,
				objStatuTypes_data.strDateStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strDateStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

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


		String[] strStatusTypeNames = {
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strDateStatusTypeName };
		
		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc, objResource_data.strResourceName, strStatusTypeNames);
		
		objViewsList.navigateToViewsList();
//		.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc)
//				.selectStatusTypeForView(strStatusTypeValues)
//				.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();

		objNavigationToSubmenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRoles_data.strRoleName)
				.clickStatusTypeInRoleMayUpdateSection(strStatusTypeValues)
				.clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRoles_data.strRoleName);
		System.out.println(objRoles_data.strRoleName);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectViewcustomViewOption()
				.selectConfigureMultiRegionViewsOption()
				.selectConfigureRegionViewsOption().clickSaveButton();

		objLogin.clickLogOut();
		
		objLogin.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToCustomInView();

		objCustomUnderView.clickOnSetupCustomViewLink()
				.enterCustomViewDetails(objView_data.strCustomView)
				.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch().selectResource(strResourceValue)
				.clickOnAddToCustomView().clickOnOptions()
				.selectAllChkBoxInOptions()
				.selectStatusTypes(strStatusTypeValues)
				.clickOnSave();
		
		objLogin.clickLogOut();
		
		System.out.println("---------Precondition ends and test execution starts--------");

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToCustomInView();

		objCustomUnderView1.clickOnPromote();

		objViewsList1
				.verRegionViewListPageIsDisplayed()
				.verViewInList(objView_data.strCustomView)

				.clickOnUsersAssociatedWithMulRegView(
						objView_data.strCustomView)
				.selectUsersCheckBoxinAssigUsers(objUserdata.strNewUserName)
				.clickOnSave()
				.clickOnDemoteAssociatedWithMulRegView(
						objView_data.strCustomView)
				.verRegionViewListPageIsDisplayed()
				.verViewIsNotListedInRegionViewList(objView_data.strCustomView);

		objNavigationToSubmenus1.navigateToCustomInView();

		objViews1.verResourceTypeAndResourceNameInCustomTable(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int j = 0; j < strStatusTypeNames.length; j++) {
			objViews1.verStatusTypesInCustomViewTable(
					objResourceType_data.strResourceTypeName,
					strStatusTypeNames[j]);
		}

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************************
	'Description 	:  Verify that user who is assigned a role in which "Configure Multi-Region Views"
	                   right is selected can demote multi region view to his/her custom view
	'Date 			: 29-June-2015 
	'Author 		: Anitha
	'-------------------------------------------------------------------------------------------------
	'Modified Date			                        	                Modified By
	'Date					                                            Name
	**************************************************************************************************/
	@Test(description = "Verify that user who is assigned a role in which Configure Multi-Region Views"
			+ " right is selected can demote multi region view to his/her custom view.")
	public void testHappyDay163502() throws Exception {

		gstrTCID = "163502";
		gstrTO = "Verify that user who is assigned a role in which 'Configure Multi-Region Views' right "
				+ "is selected can demote multi region view to his/her custom view.";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		View_data objView_data = new View_data();
		User_data objUserdata = new User_data();
		Roles_data objRoles_data = new Roles_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		CustomUnderView objCustomUnderView = new CustomUnderView(this.driver1);
		Resource objResource = new Resource(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		Views objViews1 = new Views(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		String strRoleValue[] = new String[1];
		String strStatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		objStatusTypeList.navigateToStatusTypeListNew();

		// RoleBased statustypes
		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);
		
		objStatusTypeList
				.createNewStatus(objStatuTypes_data.strStatusNameInMulti,
						objStatuTypes_data.strStatusColor)

				.createNewStatus(objStatuTypes_data.strStatusNameInMulti1,
						objStatuTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatuTypes_data.strStatusNameInMulti)
				.verCreatedStatusInStatusListForMulti(
						objStatuTypes_data.strStatusNameInMulti1)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strDateStatusType,
				objStatuTypes_data.strDateStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strDateStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

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

		objViewsList.navigateToViewsList().clickCreateNewViewButton()
				.enterViewName(objView_data.strViewName)
				.enterViewDesc(objView_data.strViewDesc)
				.selectStatusTypeForView(strStatusTypeValues)
				.selectResource(objResource_data.strResourceName)
				.clickOnSaveOfCreateNewView();

		objNavigationToSubmenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn().enterRoleName(
				objRoles_data.strRoleName);

		objUsersList.selectConfigureMultiRegionViewsOption();

		objRoles.clickStatusTypeInRoleMayUpdateSection(strStatusTypeValues)
				.clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRoles_data.strRoleName);
		System.out.println(objRoles_data.strRoleName);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectViewcustomViewOption()
				.selectConfigureRegionViewsOption().clickSaveButton();

		objLogin.clickLogOut();
		
		objLogin.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToCustomInView();

		objCustomUnderView.clickOnSetupCustomViewLink()
				.enterCustomViewDetails(objView_data.strCustomView)
				.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch().selectResource(strResourceValue)
				.clickOnAddToCustomView().clickOnOptions()
				.selectAllChkBoxInOptions()
				.selectStatusTypes(strStatusTypeValues)
				.clickOnSave();
		
		objLogin.clickLogOut();
		
		System.out.println("---------Precondition ends and test execution starts--------");

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToCustomInView();

		objCustomUnderView1.clickOnPromote();

		objViewsList1
				.verRegionViewListPageIsDisplayed()
				.verViewInList(objView_data.strCustomView)
				.clickOnDemoteAssociatedWithMulRegView(
						objView_data.strCustomView)
				.verRegionViewListPageIsDisplayed()
				.verViewIsNotListedInRegionViewList(objView_data.strCustomView);

		objNavigationToSubmenus1.navigateToCustomInView();

		String[] strStatusTypeNames = {
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strDateStatusTypeName };

		objViews1.verResourceTypeAndResourceNameInCustomTable(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int j = 0; j < strStatusTypeNames.length; j++) {
			objViews1.verStatusTypesInCustomViewTable(
					objResourceType_data.strResourceTypeName,
					strStatusTypeNames[j]);
		}

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Verify that user who is assigned a role in which "Configure Multi-Region Views" right is selected can promote custom view to a multi region view  
	'Precondition:
	'Date	 	 : 03-Nov-2015
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that user who is assigned a role in which Configure Multi-Region Views right is selected can promote custom view to a multi region view ")
	public void testHappyDay129639() throws Exception {

		gstrTCID = "129639";
		gstrTO = "Verify that user who is assigned a role in which Configure Multi-Region Views right is selected can promote custom view to a multi region view ";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		Roles_data objRolesData = new Roles_data();
		
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		Roles objRoles = new Roles(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		View_data objView_data = new View_data();
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[6];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strRoleValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);
		
		objRegionDefault.selectFrame();
		
		objNavigationToSubmenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName)
				.selectConfigureMultiRegionViews()
				.selectConfigureRegionViews().clickOnSaveBtn()
		.verifyCreatedRoleInRolesList(objRolesData.strRoleName);
		
		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

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
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
						objStatusTypes_data.strStatusColor)		
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1)		
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

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.streDateStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streDateStatusTypeName);

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

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectRoleCheckBox(strRoleValue[0]).clickAdvancedOptionAndExpand()
				.selectViewcustomViewOption().clickSaveButton();

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToCustomInView();

		objCustomUnderView1.verCustomViewTableScreenIsDisplayed()
				.verPageWhenCustomViewNotCreated();

		objLinksAtTopRightCorners1.verCustomizeLink();

		objCustomUnderView1.clickOnSetupCustomViewLink()
	    .enterCustomViewDetails(objView_data.strCustomView)
		.clickOnAddMoreResources()
		.enterResNameInWhatField(objResource_data.strResourceName)
		.clickOnSearch().selectResource(strResourceValue)
		.clickOnAddToCustomView().clickOnOptions()
		.selectAllChkBoxInOptions()
		.selectStatusTypes(strStatusTypeValues).clickOnSave();
		
		objCustomUnderView1.clickOnPromote();

		objViewsList1.verRegionViewListPageIsDisplayed().verViewInList(
				objView_data.strCustomView);

		objNavigationToSubmenus1.navigateToCustomInView();

		objCustomUnderView1.verCustomViewTableScreenIsDisplayed()
				.verPageWhenCustomViewNotCreated();

		objLinksAtTopRightCorners1.verCustomizeLink();

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/**********************************************************************************************
	'Description : Verify that user with "Configure Multi-Region Views" right and without Configure  
	               region view right cannot promote custom view to a multi region view
	'Date	 	 : 04-Nov-2015
	'Author		 : Anitha
	'----------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	***********************************************************************************************/
	@Test(description = "Verify that user with 'Configure Multi-Region Views' right and without 'Configure"
			+ " region view' right cannot promote custom view to a multi region view.")
	public void testHappyDay130611() throws Exception {

		gstrTCID = "130611";
		gstrTO = "Verify that user with 'Configure Multi-Region Views' right and without 'Configure region view' "
				+ "right cannot promote custom view to a multi region view.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		Roles_data objRolesData = new Roles_data();
		
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		Roles objRoles = new Roles(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		View_data objView_data = new View_data();

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[2];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strRoleValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);
		
		objRegionDefault.selectFrame();
		
		objNavigationToSubmenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRolesData.strRoleName).clickOnSaveBtn();
		
		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

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

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectRoleCheckBox(strRoleValue[0]).clickAdvancedOptionAndExpand()
				.selectViewcustomViewOption()
				.selectConfigureMultiRegionViewsOption()
				.clickSaveButton();

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);
		
		System.out.println("---Precondition ends and test execution starts---");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToCustomInView();

		objCustomUnderView1.clickOnSetupCustomViewLink()
				.enterCustomViewDetails(objView_data.strCustomView)
				.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch().selectResource(strResourceValue)
				.clickOnAddToCustomView().clickOnOptions()
				.selectAllChkBoxInOptions()
				.selectStatusTypes(strStatusTypeValues).clickOnSave();

		objCustomUnderView1.clickOnPromote();
		
		objViewsList1.verEMRWarningMsg();
		
		Thread.sleep(60000);
		
		objRegionDefault1.verifyRegionDefaultPage();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

	
	
	
	

	
	/*************************************************************************************
	'Description : Verify that multiple users can be selected in a region to view the multi region view when there exists a mutual agreement between the regions  
	'Precondition:
	'Date	 	 : 04-Nov-2015
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that multiple users can be selected in a region to view the multi region view when there exists a mutual agreement between the regions ")
	public void testHappyDay163503() throws Exception {

		gstrTCID = "163503";
		gstrTO = "Verify that multiple users can be selected in a region to view the multi region view when there exists a mutual agreement between the regions ";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		View_data objView_data = new View_data();
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[6];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strFlowridaReg2);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createSharedStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.createSharedStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1)	
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createSharedStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createSharedStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createSharedStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createSharedStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

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
				.clickOnshareWithOtherReg()
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton().clickOnViewResChkBox().clickOnSaveButton();

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectConfigureRegionViewsOption()
				.selectConfigureMultiRegionViewsOption()
				.selectViewcustomViewOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName2,
						objUserdata.strNewPassword, objUserdata.strFullName2)
				.selectFirstRole().clickSaveButton();

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToCustomInView();

		objCustomUnderView1.verCustomViewTableScreenIsDisplayed()
				.verPageWhenCustomViewNotCreated();

		objLinksAtTopRightCorners1.verCustomizeLink();

		objCustomUnderView1.clickOnSetupCustomViewLink()
				.enterCustomViewDetails(objView_data.strCustomView)
				.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch().selectResource(strResourceValue)
				.clickOnAddToCustomView().clickOnOptions()
				.selectAllChkBoxInOptions()
				.selectStatusTypes(strStatusTypeValues).clickOnSave();

		objCustomUnderView1.clickOnPromote();

		objViewsList1.verRegionViewListPageIsDisplayed().verViewInList(
				objView_data.strCustomView);

		objViewsList1
				.clickOnUsersAssociatedWithMulRegView(
						objView_data.strCustomView)
				.verAssgnUserToViewCustomPgeIsDisplayed(
						objView_data.strCustomView)
				.selectUserInEveSecutityPage(objUserdata.strNewUserName)
				.selectUserInEveSecutityPage(objUserdata.strNewUserName1)
				.selectUserInEveSecutityPage(objUserdata.strNewUserName2)
				.clickOnSave().verViewInList(objView_data.strCustomView);

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strCustomView);

		String strAllStatusTypeNames[] = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strDateStatusTypeName };

		String[] strRegName = { objResource_data.strResourceName };

		objCustomUnderView1
				.verCustomTableWithCustomName(objView_data.strCustomView)
				.verResourceAndResTypeInCustomViewTablePage(strRegName,
						objResourceType_data.strResourceTypeName)
				.verStatusTypeInCustomViewTablePage(strAllStatusTypeNames);

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strCustomView);

		objCustomUnderView1
		.verCustomTableWithCustomName(objView_data.strCustomView)
				.verResourceAndResTypeInCustomViewTablePage(strRegName,
						objResourceType_data.strResourceTypeName)
				.verStatusTypeInCustomViewTablePage(strAllStatusTypeNames);

		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName2,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strCustomView);

		objCustomUnderView1
				.verCustomTableWithCustomName(objView_data.strCustomView)
				.verResourceAndResTypeInCustomViewTablePage(strRegName,
						objResourceType_data.strResourceTypeName)
				.verStatusTypeInCustomViewTablePage(strAllStatusTypeNames);

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	/****************************************************************************************************************
	'Description :  Verify that user can access multi-region view created in the logged in region when user has access to two regions.
	'Precondition:
	'Date	 	 : 6-Nov-2015
	'Author		 : Sangappa K
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	******************************************************************************************************************/
	@Test(description =" Verify that user can access multi-region view created in the logged in region when user has access to two regions.")
	public void testHappyDay163516() throws Exception {

		gstrTCID ="163516";
		gstrTO = "Verify that user can access multi-region view created in the logged in region when user has access to two regions.";
		
		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		View_data objView_data = new View_data();

		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		Regions objRegions_page = new Regions(this.driver1);

		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(
				this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		Views objViews1 = new Views(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[6];
		String strStatusTypeValues1[] = new String[6];
		String strResourceValue[] = new String[1];
		String strResourceValue1[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strRegionValue[] = new String[2];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions_page
				.getRegionValue(objLogindata.strRegionName);

		System.out.println(strRegionValue[0]);

		strRegionValue[1] = objRegions_page
				.getRegionValue(objLogindata.strRegionName1);

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

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
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1)		
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

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		System.out.println(objResourceType_data.strResourceTypeName);

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

		System.out.println(objResource_data.strResourceName);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionViewsOption()
				.selectConfigureMultiRegionViewsOption()
				.selectViewcustomViewOption().clickSaveButton()
				.clickRegionsLinkForUser(objUserdata.strNewUserName)
				.selectRegion(strRegionValue[1]).clickSaveButton();

		// 2Reg Login

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName1);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName1);

		objStatusTypeList
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName1,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti2,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti2)			
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues1[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName1);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues1[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName1);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues1[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName1);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues1[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName1);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues1[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName1);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType
				.createResourceType(objResourceType_data.strResourceTypeName1,
						strStatusTypeValues1);

		System.out.println(objResourceType_data.strResourceTypeName1);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource
				.clickOnCreateNewResourceButton()
				.enterResourceName(objResource_data.strResourceName1)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strResourceTypeName1)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton().clickOnViewResChkBox().clickOnSaveButton();

		strResourceValue1[0] = objResource
				.getResourceValue(objResource_data.strResourceName1);

		System.out.println(objResource_data.strResourceName1);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.enterUsernameInSearchInputField(objUserdata.strNewUserName)
				.clickSearchButton()
				.editUserDetails(objUserdata.strNewUserName).selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionViewsOption()
				.selectConfigureMultiRegionViewsOption()
				.selectViewcustomViewOption().clickSaveButton();
		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);

		// 1St custom view creation

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToCustomInView();

		objCustomUnderView1.verCustomViewTableScreenIsDisplayed();

		objLinksAtTopRightCorners1.verCustomizeLink();

		objCustomUnderView1.clickOnSetupCustomViewLink()
				.enterCustomViewDetails(objView_data.strCustomView)
				.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch().selectResource(strResourceValue)
				.clickOnAddToCustomView().clickOnOptions()
				.selectAllChkBoxInOptions()
				.selectStatusTypes(strStatusTypeValues).clickOnSave();
		objCustomUnderView1.clickOnPromote();

		objViewsList1
				.verRegionViewListPageIsDisplayed()
				.verViewInList(objView_data.strCustomView)

				.clickOnUsersAssociatedWithMulRegView(
						objView_data.strCustomView)
				.selectUsersCheckBoxinAssigUsers(objUserdata.strNewUserName)
				.clickOnSave().verRegionViewListPageIsDisplayed();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strCustomView);

		String[] strStatusTypeNames = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strDateStatusTypeName };

		objViews1.verResourceTypeAndResourceNameInCustomTable(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int j = 0; j < strStatusTypeNames.length; j++) {
			objViews1.verStatusTypesInCustomViewTable(
					objResourceType_data.strResourceTypeName,
					strStatusTypeNames[j]);
		}

		// 2nd custom view creation

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName1);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToCustomInView();

		objCustomUnderView1.verCustomViewTableScreenIsDisplayed();

		objLinksAtTopRightCorners1.verCustomizeLink();

		objCustomUnderView1.clickOnSetupCustomViewLink()
				.enterCustomViewDetails(objView_data.strCustomView1)
				.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName1)
				.clickOnSearch().selectResource(strResourceValue1)
				.clickOnAddToCustomView().clickOnOptions()
				.selectAllChkBoxInOptions()
				.selectStatusTypes(strStatusTypeValues1).clickOnSave();
		objCustomUnderView1.clickOnPromote();
		objViewsList1
				.verRegionViewListPageIsDisplayed()
				.verViewInList(objView_data.strCustomView1)

				.clickOnUsersAssociatedWithMulRegView(
						objView_data.strCustomView1)
				.selectUsersCheckBoxinAssigUsers(objUserdata.strNewUserName)
				.clickOnSave().verRegionViewListPageIsDisplayed();
		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strCustomView1);

		objViews1.verResourceTypeAndResourceNameInCustomTable(
				objResourceType_data.strResourceTypeName1,
				objResource_data.strResourceName1);

		String[] strStatusTypeNames1 = {
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strMSTStatusTypeName1,
				objStatusTypes_data.strTSTStatusTypeName1,
				objStatusTypes_data.strSSTStatusTypeName1,
				objStatusTypes_data.strNDSTStatusTypeName1,
				objStatusTypes_data.strDateStatusTypeName1 };

		for (int j = 0; j < strStatusTypeNames.length; j++) {
			objViews1.verStatusTypesInCustomViewTable(
					objResourceType_data.strResourceTypeName1,
					strStatusTypeNames1[j]);
		}

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

	/**********************************************************************************
	'Description 	:  Verify that user with Configure Multi-Region Views right can not edit the multi region view.
	'Date 			: 3-Nov-2015 
	'Author 		: Anil
	'----------------------------------------------------------------------------------
	'Modified Date			                        	                Modified By
	'Date					                                            Name
	***********************************************************************************/
	@Test(description = " Verify that user with Configure Multi-Region Views right can not edit the multi region view.")
	public void testHappyDay163513() throws Exception {

		gstrTCID = "163513";
		gstrTO = " Verify that user with Configure Multi-Region Views right can not edit the multi region view.";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		View_data objView_data = new View_data();
		User_data objUserdata = new User_data();
		Roles_data objRoles_data = new Roles_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		CustomUnderView objCustomUnderView = new CustomUnderView(this.driver1);
		Resource objResource = new Resource(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		Views objViews1 = new Views(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRoleValue[] = new String[1];
		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		objStatusTypeList.navigateToStatusTypeListNew();

		// RoleBased statustypes
		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);
		
		objStatusTypeList.createNewStatus(
			     objStatuTypes_data.strStatusNameInMulti,
			     objStatuTypes_data.strStatusColor)

			  .createNewStatus(objStatuTypes_data.strStatusNameInMulti1,
			      objStatuTypes_data.strStatusColor)

			  .verCreatedStatusInStatusListForMulti(
			      objStatuTypes_data.strStatusNameInMulti)
			  .verCreatedStatusInStatusListForMulti(
			      objStatuTypes_data.strStatusNameInMulti1)

			.clickOnReturnToStatusTypeList();

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strDateStatusType,
				objStatuTypes_data.strDateStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strDateStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

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

		objViewsList.navigateToViewsList().clickCreateNewViewButton()
				.enterViewName(objView_data.strViewName)
				.enterViewDesc(objView_data.strViewDesc)
				.selectStatusTypeForView(strStatusTypeValues)
				.selectResource(objResource_data.strResourceName)
				.clickOnSaveOfCreateNewView();

		objNavigationToSubmenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRoles_data.strRoleName)
				.clickStatusTypeInRoleMayUpdateSection(strStatusTypeValues)
				.clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRoles_data.strRoleName);
		System.out.println(objRoles_data.strRoleName);
		
		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectViewcustomViewOption()
				.selectConfigureMultiRegionViewsOption()
				.selectConfigureRegionViewsOption().clickSaveButton();
System.out.println(objUserdata.strNewUserName);

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectRoleCheckBox(strRoleValue)
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectConfigureMultiRegionViewsOption()
				.clickSaveButton();
		
		objUsersList
		.clickCreateNewUserButton()
		.enterUserDetails(objUserdata.strNewUserName2,
				objUserdata.strNewPassword, objUserdata.strFullName2)
		.selectRoleCheckBox(strRoleValue)
		.selectViewResourceCheckBox(objResource_data.strResourceName)
		.clickAdvancedOptionAndExpand()
		.selectConfigureMultiRegionViewsOption()
		.clickSaveButton();
		objLogin.clickLogOut();
		
		objLogin.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToCustomInView();

		objCustomUnderView.clickOnSetupCustomViewLink()
				.enterCustomViewDetails(objView_data.strCustomView)
				.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch().selectResource(strResourceValue)
				.clickOnAddToCustomView().clickOnOptions()
				.selectAllChkBoxInOptions()
				.selectStatusTypes(strStatusTypeValues)
				.clickOnSave();
		Thread.sleep(3000);
		
		objLogin.clickLogOut();
		
		System.out.println("---------Precondition ends and test execution starts--------");

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToCustomInView();

		objCustomUnderView1.clickOnPromote();

		objViewsList1
				.verRegionViewListPageIsDisplayed()
				.verViewInList(objView_data.strCustomView)

				.clickOnUsersAssociatedWithMulRegView(
						objView_data.strCustomView)
				.selectUsersCheckBoxinAssigUsers(objUserdata.strNewUserName)
				.selectUsersCheckBoxinAssigUsers(objUserdata.strNewUserName1)
				.selectUsersCheckBoxinAssigUsers(objUserdata.strNewUserName2)
				.selectUsersCheckBoxinAssigUsers(objUserdata.strNewUserName)
				.clickOnSave();
		
		objNavigationToSubmenus1.navigateToParticularViewUnderViewMenu(objView_data.strCustomView);
		
		String[] strStatusTypeNames = {
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strDateStatusTypeName };

		objViews1.verResourceTypeAndResourceNameInCustomTable(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int j = 0; j < strStatusTypeNames.length; j++) {
			objViews1.verStatusTypesInCustomViewTable(
					objResourceType_data.strResourceTypeName,
					strStatusTypeNames[j]);
		}
		objViews1.verifyCustomizeLinkIsDispalyed();
		
		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);
		
		objNavigationToSubmenus1.navigateToCustomInView();

		objViews1.verResourceTypeAndResourceNameInCustomTable(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int j = 0; j < strStatusTypeNames.length; j++) {
			objViews1.verStatusTypesInCustomViewTable(
					objResourceType_data.strResourceTypeName,
					strStatusTypeNames[j]);
		}
		objViews1.verifyCustomizeLinkIsNotDispalyed();
		objLogin1.clickLogOut();
		
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName2,
				objUserdata.strNewPassword);
		
		objNavigationToSubmenus1.navigateToParticularViewUnderViewMenu(objView_data.strCustomView);

		objViews1.verResourceTypeAndResourceNameInCustomTable(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int j = 0; j < strStatusTypeNames.length; j++) {
			objViews1.verStatusTypesInCustomViewTable(
					objResourceType_data.strResourceTypeName,
					strStatusTypeNames[j]);
		}
		objViews1.verifyCustomizeLinkIsNotDispalyed();
		
		objLogin1.clickLogOut();
		gstrResult = "PASS";
	}
	
	/**********************************************************************************
	'Description 	:  	Verify that demoted multi region view cannot be viewed by multiple users 
	'Date 			: 29-June-2015 
	'Author 		: Anil
	'----------------------------------------------------------------------------------
	'Modified Date			                        	                Modified By
	'Date					                                            Name
	***********************************************************************************/
	@Test(description = " 	Verify that demoted multi region view cannot be viewed by multiple users ")
	public void testHappDay163509() throws Exception {

		gstrTCID = "163509";
		gstrTO = " 	Verify that demoted multi region view cannot be viewed by multiple users ";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		View_data objView_data = new View_data();
		User_data objUserdata = new User_data();
		Roles_data objRoles_data = new Roles_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		CustomUnderView objCustomUnderView = new CustomUnderView(this.driver1);
		Resource objResource = new Resource(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		Views objViews1 = new Views(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		String strRoleValue[] = new String[1];
		String strStatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		objStatusTypeList.navigateToStatusTypeListNew();

		// RoleBased statustypes
		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		objStatusTypeList.createNewStatus(
			     objStatuTypes_data.strStatusNameInMulti,
			     objStatuTypes_data.strStatusColor)

			  .createNewStatus(objStatuTypes_data.strStatusNameInMulti1,
			      objStatuTypes_data.strStatusColor)

			  .verCreatedStatusInStatusListForMulti(
			      objStatuTypes_data.strStatusNameInMulti)
			  .verCreatedStatusInStatusListForMulti(
			      objStatuTypes_data.strStatusNameInMulti1)

			.clickOnReturnToStatusTypeList();

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strDateStatusType,
				objStatuTypes_data.strDateStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strDateStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

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

		objViewsList.navigateToViewsList().clickCreateNewViewButton()
				.enterViewName(objView_data.strViewName)
				.enterViewDesc(objView_data.strViewDesc)
				.selectStatusTypeForView(strStatusTypeValues)
				.selectResource(objResource_data.strResourceName)
				.clickOnSaveOfCreateNewView();

		objNavigationToSubmenus.navigateToRoles();

		objRoles.clickOnCreateNewRoleBtn()
				.enterRoleName(objRoles_data.strRoleName)
				.clickStatusTypeInRoleMayUpdateSection(strStatusTypeValues)
				.clickOnSaveBtn();

		strRoleValue[0] = objRoles.getRoleValue(objRoles_data.strRoleName);
		System.out.println(objRoles_data.strRoleName);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectViewcustomViewOption()
				.selectConfigureMultiRegionViewsOption()
				.selectConfigureRegionViewsOption().clickSaveButton();

		objUsersList
		.clickCreateNewUserButton()
		.enterUserDetails(objUserdata.strNewUserName1,
				objUserdata.strNewPassword, objUserdata.strFullName1)
		.selectRoleCheckBox(strRoleValue)
		.selectViewResourceCheckBox(objResource_data.strResourceName)
		.clickSaveButton();
		
		objUsersList
		.clickCreateNewUserButton()
		.enterUserDetails(objUserdata.strNewUserName2,
				objUserdata.strNewPassword, objUserdata.strFullName2)
		.selectRoleCheckBox(strRoleValue)
		.selectViewResourceCheckBox(objResource_data.strResourceName)
		.clickSaveButton();
		objLogin.clickLogOut();
		
		objLogin.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToCustomInView();

		objCustomUnderView.clickOnSetupCustomViewLink()
				.enterCustomViewDetails(objView_data.strCustomView)
				.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch().selectResource(strResourceValue)
				.clickOnAddToCustomView().clickOnOptions()
				.selectAllChkBoxInOptions()
				.selectStatusTypes(strStatusTypeValues)
				.clickOnSave();
		
		objLogin.clickLogOut();
		
		System.out.println("---------Precondition ends and test execution starts--------");

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToCustomInView();

		objCustomUnderView1.clickOnPromote();

		objViewsList1
				.verRegionViewListPageIsDisplayed()
				.verViewInList(objView_data.strCustomView)

				.clickOnUsersAssociatedWithMulRegView(
						objView_data.strCustomView)
				.selectUsersCheckBoxinAssigUsers(objUserdata.strNewUserName)
				.selectUsersCheckBoxinAssigUsers(objUserdata.strNewUserName1)
				.selectUsersCheckBoxinAssigUsers(objUserdata.strNewUserName2)
				.selectUsersCheckBoxinAssigUsers(objUserdata.strNewUserName)
				.clickOnSave();
		
		objNavigationToSubmenus1.navigateToParticularViewUnderViewMenu(objView_data.strCustomView);

		String[] strStatusTypeNames = {
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strDateStatusTypeName };

		objViews1.verResourceTypeAndResourceNameInCustomTable(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int j = 0; j < strStatusTypeNames.length; j++) {
			objViews1.verStatusTypesInCustomViewTable(
					objResourceType_data.strResourceTypeName,
					strStatusTypeNames[j]);
		}
		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
				
		objNavigationToSubmenus1.navigateToParticularViewUnderViewMenu(objView_data.strCustomView);

		objViews1.verResourceTypeAndResourceNameInCustomTable(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int j = 0; j < strStatusTypeNames.length; j++) {
			objViews1.verStatusTypesInCustomViewTable(
					objResourceType_data.strResourceTypeName,
					strStatusTypeNames[j]);
		}
		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName2,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
				
		objNavigationToSubmenus1.navigateToParticularViewUnderViewMenu(objView_data.strCustomView);

		objViews1.verResourceTypeAndResourceNameInCustomTable(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int j = 0; j < strStatusTypeNames.length; j++) {
			objViews1.verStatusTypesInCustomViewTable(
					objResourceType_data.strResourceTypeName,
					strStatusTypeNames[j]);
		}
		objLogin1.clickLogOut();
		
		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToViews();
		
		objViewsList1.clickOnDemoteAssociatedWithMulRegView(
						objView_data.strCustomView);
		objViewsList1.clickOnView();
		objViewsList1.verViewIsNotListed(objView_data.strCustomView);

		
		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objViewsList1.clickOnView();
		
		objViewsList1.verViewIsNotListed(objView_data.strCustomView);
		
		objLogin1.clickLogOut();
		
		objLogin1.loginToApplication(objUserdata.strNewUserName2,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objViewsList1.clickOnView();
		
		objViewsList1.verViewIsNotListed(objView_data.strCustomView);
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}

}
