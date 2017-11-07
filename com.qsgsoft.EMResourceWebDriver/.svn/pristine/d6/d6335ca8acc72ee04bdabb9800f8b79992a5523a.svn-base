package requirementGroup.ViewingAndmanagingEMResourceEntitiesOnTheViewInterface;

import java.util.concurrent.TimeUnit;

import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.LinksAtTopRightCorners;
import lib.module.NavigationToSubMenus;
import lib.page.CustomUnderView;
import lib.page.Login;
import lib.page.Map;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UpdateStatus;
import lib.page.UsersList;
import lib.page.Views;
import lib.page.ViewsList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewUpdateStatusScreen extends TestNG_UI_EXTENSIONS {

	public NewUpdateStatusScreen() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/*************************************************************************************
	'Description : Verify that a user can snooze the update status prompt. 
	'Precondition:
	'Date	 	 : 12-Jun-2015
	'Author		 : Rensuhree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that a user can snooze the update status prompt. ")
	public void testHappyDay70158() throws Exception {

		gstrTCID = "70158";
		gstrTO = "Verify that a user can snooze the update status prompt. ";

		// Objects for data
		Login_data objTest_data = new Login_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();

		UsersList UsersList_page = new UsersList(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);

		String strResourceValue[] = new String[1];
		String strstatusTypeValues[] = new String[6];
		String strstatusesValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(
				this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(this.driver1);

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		objStatusTypeList.navigateToStatusTypeListNew();

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList
				.createStatusTypeWithSection(
						objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription,
						objView_data.strSectionName)

				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti);

		strstatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1);

		strstatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		objNavigationToSubMenus.navigateToResourceInSetup();

		// Resource type creation
		ResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strstatusTypeValues);

		strResourceTypeValue[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		Resource_Page.navigateToResourceListPage()

		.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName);

		objNavigationToSubMenus.navigateToViews();

		String[] strAllStatausTypes = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName };

		objViewsList.verRegionViewListPageIsDisplayed()
//				.clickCreateNewViewButton().verCreateNewViewPageIsDisplayed()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);
//
//		for (int i = 0; i < strAllStatausTypes.length; i++) {
//
//			objViewsList.selectStatusType(strAllStatausTypes[i]);
//		}
//
//		objViewsList.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView()
//				.verViewInList(objView_data.strViewName);
				.createView(objView_data.strViewName, objView_data.strViewDesc,
						objResource_data.strResourceName, strAllStatausTypes);
		
		UsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMustUpdateOverdueStatusOption()
				.selectConfigureRegionViewsOption().clickSaveButton();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objUpdateStatus1.verUpdateStatusPge().clickOnRemindMeIn10MinBtn();

		objRegionDefault1.verifyRegionDefaultPage();

		// Wait for 10 min
		TimeUnit.MINUTES.sleep(11);

		objLinksAtTopRightCorners1.clickOnRefresh();
		
		Thread.sleep(2000);

		objUpdateStatus1
				.verUpdateStatusPge()
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[0],
						objView_data.strValueForUpdate)
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[2],
						objView_data.strValueForUpdate)
				.enterUpdateSSTValues(strstatusTypeValues[4],
						objView_data.strValueForSST)
				.selectMSTUpdateValue(strstatusTypeValues[3],
						strstatusesValues[0])
				.enterNedocsUpdateValue(strstatusTypeValues[1],
						objView_data.strValueForNDST)
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[5],
						objView_data.strDateUpdateValue).clickOnSaveButton();

		objNavigationToSubmenus1
		.navigateToParticularViewUnderViewMenu(objView_data.strViewName);
		
		objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[0], objView_data.strValueForUpdate);
		
		objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[3],
				objStatusTypes_data.strStatusNameInMulti);

		objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[2], objView_data.strValueForUpdate);
		
		objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[4], objView_data.strUpdatedValForSST);

		objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[1], objView_data.strNEDOCValue);

		objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[5], objView_data.strDateUpdateValue);
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Verify that clicking on the 'Show all statuses' option displays all the status types to which the user has update right to.
	'Precondition:
	'Date	 	 : 12-Jun-2015
	'Author		 : Rensuhree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that clicking on the 'Show all statuses' option displays all the status types to which the user has update right to.")
	public void testHappyDay69946() throws Exception {

		gstrTCID = "69946";
		gstrTO = "Verify that clicking on the 'Show all statuses' option displays all the status types to which the user has update right to.";

		// Objects for data
		Login_data objTest_data = new Login_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();

		UsersList UsersList_page = new UsersList(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		Views objViews1 = new Views(this.driver1);
		
		String strResourceValue[] = new String[1];
		String strstatusTypeValues[] = new String[6];
		String strstatusesValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		objStatusTypeList.navigateToStatusTypeListNew();

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList
				.createStatusTypeWithSection(
						objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription,
						objView_data.strSectionName)

				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti);

		strstatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1);

		strstatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		objNavigationToSubMenus.navigateToResourceInSetup();

		// Resource type creation
		ResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strstatusTypeValues);

		strResourceTypeValue[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		Resource_Page.navigateToResourceListPage()

		.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName);

		objNavigationToSubMenus.navigateToViews();

		String[] strAllStatausTypes = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName};

		objViewsList.verRegionViewListPageIsDisplayed()
//				.clickCreateNewViewButton().verCreateNewViewPageIsDisplayed()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);
//
//		for (int i = 0; i < strAllStatausTypes.length; i++) {
//
//			objViewsList.selectStatusType(strAllStatausTypes[i]);
//		}
//
//		objViewsList.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView()
//				.verViewInList(objView_data.strViewName);
				.createView(objView_data.strViewName, objView_data.strViewDesc,
						objResource_data.strResourceName, strAllStatausTypes);
		
		UsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionViewsOption().clickSaveButton();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToParticularViewUnderViewMenu(objView_data.strViewName);
		
		objViews1.clickOnUpdateStatusKeyInViewResDetailPage(objResource_data.strResourceName);
		
		objUpdateStatus1.verUpdateStatusPge()
		.verStatusTypeDisplayed(strstatusTypeValues[0], objStatusTypes_data.strNSTStatusTypeName)
		.verStatusTypeDisplayed(strstatusTypeValues[3], objStatusTypes_data.strMSTStatusTypeName)
		.clickOnShowAllStatuses();
	
		objUpdateStatus1
		.clickOnSelectAll()
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[0],
						objView_data.strValueForUpdate)
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[2],
						objView_data.strValueForUpdate)
				.enterUpdateSSTValues(strstatusTypeValues[4],
						objView_data.strValueForSST)
				.selectMSTUpdateValue(strstatusTypeValues[3],
						strstatusesValues[0])
				.enterNedocsUpdateValue(strstatusTypeValues[1],
						objView_data.strValueForNDST)
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[5],
						objView_data.strDateUpdateValue).clickOnSaveButton();
		
		objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[0], objView_data.strValueForUpdate);
		
		objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[3],
				objStatusTypes_data.strStatusNameInMulti);
		
		objViews1.clickOnResource(objResource_data.strResourceName);

		objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[2], objView_data.strValueForUpdate);
		
		objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[4], objView_data.strUpdatedValForSST);

		objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[1], objView_data.strNEDOCValue);

		objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0],
				strstatusTypeValues[5], objView_data.strDateUpdateValue);
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/******************************************************************************************
	'Description : Verify that "Select all" links are left aligned on the update status screen.
	'Date	 	 : 31-Dec-2015
	'Author		 : Anitha
	'------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	******************************************************************************************/
	@Test(description = "Verify that 'Select all' links are left aligned on the update status screen.")
	public void testHappyDay123929() throws Exception {

		gstrTCID = "123929";
		gstrTO = "Verify that 'Select all' links are left aligned on the update status screen.";

		// Objects for data
		Login_data objTest_data = new Login_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();

		UsersList UsersList_page = new UsersList(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		CustomUnderView objCustomUnderView = new CustomUnderView(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		Views objViews1 = new Views(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		Map objMap1 = new Map(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		
		String strResourceValue[] = new String[1];
		String strstatusTypeValues[] = new String[3];
		String strResourceTypeValue[] = new String[1];

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		objStatusTypeList.navigateToStatusTypeListNew();

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objNavigationToSubMenus.navigateToResourceInSetup();

		// Resource type creation
		ResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strstatusTypeValues);

		strResourceTypeValue[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		Resource_Page.navigateToResourceListPage().createResourceWithAddress(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);

		strResourceValue[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName);

		objNavigationToSubMenus.navigateToViews();

		String[] strAllStatausTypes = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName };

		objViewsList.verRegionViewListPageIsDisplayed();
//				.clickCreateNewViewButton().verCreateNewViewPageIsDisplayed()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);
//
//		for (int i = 0; i < strAllStatausTypes.length; i++) {
//			objViewsList.selectStatusType(strAllStatausTypes[i]);
//		}
//
//		objViewsList.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();

		objViewsList.createView(objView_data.strViewName,
				objView_data.strViewDesc, objResource_data.strResourceName,
				strAllStatausTypes);
		
		UsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectViewcustomViewOption()
				.clickSaveButton();

		System.out.println(objUserdata.strNewUserName);
		
		objLogin.clickLogOut();

		objLogin.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToCustomizedViewInPrefrences();

		objCustomUnderView.verEditCustomViewScreenIsDisplayed()
				.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch().selectResource(strResourceValue)
				.clickOnAddToCustomView().clickOnOptions()
				.selectStatusTypes(strstatusTypeValues).clickOnSave();
		
		objLogin.clickLogOut();
		
		System.out.println("----Precondition ends and test execution starts----");

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViews1
				.clickOnUpdateStatusKeyInViewResDetailPage(objResource_data.strResourceName);

		objUpdateStatus1
				.verifyUpdateLinks()
				.clickOnSelectAll()
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[0],
						objView_data.strValueForUpdate)
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[2],
						objView_data.strValueForUpdate)
				.enterNedocsUpdateValue(strstatusTypeValues[1],
						objView_data.strValueForNDST).clickOnSaveButton();

		objNavigationToSubMenus1.navigateToCustomInView();

		objViews1
				.clickOnUpdateStatusKeyInViewResDetailPage(objResource_data.strResourceName);

		objUpdateStatus1.verifyUpdateLinks().clickOnSelectAll()
				.verStatusTypeExpanded(strstatusTypeValues[0])
				.verStatusTypeExpanded(strstatusTypeValues[1])
				.verStatusTypeExpanded(strstatusTypeValues[2])
				.clickOnClearAllButton()
				.verStatusTypeNotExpanded(strstatusTypeValues[0])
				.verStatusTypeNotExpanded(strstatusTypeValues[1])
				.verStatusTypeNotExpanded(strstatusTypeValues[2])
				.clickOnSelectAll()
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[0],
						objView_data.strValueForUpdate1)
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[2],
						objView_data.strValueForUpdate1)
				.enterNedocsUpdateValue(strstatusTypeValues[1],
						objView_data.strValueForNDST1).clickOnSaveButton();

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus1.verifyUpdateLinks1().clickOnCancelButton();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
}
