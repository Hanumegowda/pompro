package requirementGroup.ViewingAndmanagingEMResourceEntitiesOnTheViewInterface;

import lib.dataObject.EventSetUp_data;
import lib.dataObject.Event_data;
import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.LinksAtTopRightCorners;
import lib.module.NavigationToSubMenus;
import lib.page.CustomUnderView;
import lib.page.EventManagement;
import lib.page.EventSetUp;
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

import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewSettingUpOfRegionViews extends TestNG_UI_EXTENSIONS {

	public NewSettingUpOfRegionViews() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/*************************************************************************************
	'Description : Verify that a view can be created. 
	'Precondition:
	'Date	 	 : 11-Jun-2015
	'Author		 : Rensuhree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that a view can be created.")
	public void testHappyDay69780() throws Exception {

		gstrTCID = "69780";
		gstrTO = "Verify that a view can be created.";

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
		
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		
		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;
		boolean blnTest = false;

		String strResourceValue[] = new String[1];
		String strstatusTypeValues[] = new String[6];
		String strstatusesValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		Views objViews1 = new Views(this.driver1);

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

		UsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionViewsOption().clickSaveButton();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToViews();

		String[] strAllStatausTypes = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName };

		objViewsList1.verRegionViewListPageIsDisplayed()
//				.clickCreateNewViewButton().verCreateNewViewPageIsDisplayed()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);
//
//		for (int i = 0; i < strAllStatausTypes.length; i++) {
//
//			objViewsList1.selectStatusType(strAllStatausTypes[i]);
//		}
//
//		objViewsList1.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView()
				.createView(objView_data.strViewName, objView_data.strViewDesc,
						objResource_data.strResourceName, strAllStatausTypes)
				.verViewInList(objView_data.strViewName);

		objNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViews1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int i = 0; i < strAllStatausTypes.length; i++) {

			objViews1.verStatusTypes(objResourceType_data.strResourceTypeName,
					strAllStatausTypes[i]);
		}

		objLogin1.clickLogOut();

		blnTest = true;

		if (blnTest) {

			String[] strTestData1 = {
					gstrTCID,
					objTest_data.strRegionName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objStatusTypes_data.strNSTStatusTypeName + ","
							+ objStatusTypes_data.strMSTStatusTypeName + ","
							+ objStatusTypes_data.strTSTStatusTypeName + ","
							+ objStatusTypes_data.strNDSTStatusTypeName + ","
							+ objStatusTypes_data.strDateStatusTypeName + ","
							+ objStatusTypes_data.strSSTStatusTypeName,
					objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName, objView_data.strViewName };

			objOffCommonFunc.writeResultData(strTestData1,
					strPartialAutoResultsPath, "MobileTestData");
		}
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Verify that a view can be edited from Setup module.
	'Date	 	 : 12-Jun-2015
	'Author		 : Anitha
	'-------------------------------------------------------------------------------------
	'Modified Date			                        	              Modified By
	'Date					                                          Name
	**************************************************************************************/
	@Test(description = "Verify that a view can be edited from Setup module.")
	public void testHappyDay69803() throws Exception {

		gstrTCID = "69803";
		gstrTO = "Verify that a view can be edited from Setup module.";

		// Objects for data
		Login_data objTest_data = new Login_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();		
		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;
		boolean blnTest = false;

		UsersList UsersList_page = new UsersList(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		Views objViews1 = new Views(this.driver1);
		
		String strResourceValue[] = new String[1];
		String strstatusTypeValues[] = new String[6];
		String strstatusesValues[] = new String[2];
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

		UsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionViewsOption().clickSaveButton();
		
		String[] /*strstatusTypeValues1 = { strstatusTypeValues[0],
				strstatusTypeValues[1], strstatusTypeValues[2],
				strstatusTypeValues[3] },*/
		strStatusTypeNames1 = { objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName, 
				objStatusTypes_data.strTSTStatusTypeName, 
				objStatusTypes_data.strMSTStatusTypeName },
		strStatusTypeNames2 = {objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strDateStatusTypeName};
		
		objViewsList.navigateToViewsList()
//				.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc)
//				.selectStatusTypeForView(strstatusTypeValues1)
//				.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();
				.createView(objView_data.strViewName,
						objView_data.strViewDesc, 
						objResource_data.strResourceName, 
						strStatusTypeNames1);
		
		objLogin.clickLogOut();
		
		System.out.println("-------Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToViews();

//		String[] strstatusTypeValues2 = { strstatusTypeValues[4],
//				strstatusTypeValues[5] };
		objViewsList1.clickOnEditLinkOfView(objView_data.strViewName)
				.verEditViewPageIsDisplayed()
				.enterViewName(objView_data.strViewName2)
				.clickOnSTTab();
		
		for(int i = 0; i<strStatusTypeNames2.length; i++) {
			objViewsList1.selectStatusType(strStatusTypeNames2[i]);
		}
		
		objViewsList1.clickOnSaveOfCreateNewView()
					.verViewInList(objView_data.strViewName2);

		String[] strAllStatausTypes = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName };

		objNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName2);

		objViews1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int i = 0; i < strAllStatausTypes.length; i++) {

			objViews1.verStatusTypes(objResourceType_data.strResourceTypeName,
					strAllStatausTypes[i]);
		}

		objLogin1.clickLogOut();

		blnTest = true;

		if (blnTest) {

			String[] strTestData1 = {
					gstrTCID,
					objTest_data.strRegionName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objStatusTypes_data.strNSTStatusTypeName + ","
							+ objStatusTypes_data.strMSTStatusTypeName + ","
							+ objStatusTypes_data.strTSTStatusTypeName + ","
							+ objStatusTypes_data.strNDSTStatusTypeName + ","
							+ objStatusTypes_data.strDateStatusTypeName + ","
							+ objStatusTypes_data.strSSTStatusTypeName,
					objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName, objView_data.strViewName2 };

			objOffCommonFunc.writeResultData(strTestData1,
					strPartialAutoResultsPath, "MobileTestData");
		}
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Verify that a view can be edited from the view screen.
	'Date	 	 : 12-Jun-2015
	'Author		 : Anitha
	'-------------------------------------------------------------------------------------
	'Modified Date			                        	              Modified By
	'Date					                                          Name
	**************************************************************************************/
	@Test(description = "Verify that a view can be edited from the view screen.")
	public void testHappyDay69805() throws Exception {

		gstrTCID = "69805";
		gstrTO = "Verify that a view can be edited from the view screen.";

		// Objects for data
		Login_data objTest_data = new Login_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();		
		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;
		boolean blnTest = false;

		UsersList UsersList_page = new UsersList(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		Views objViews1 = new Views(this.driver1);
		
		String strResourceValue[] = new String[1];
		String strstatusTypeValues[] = new String[6];
		String strstatusesValues[] = new String[2];
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

		UsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionViewsOption().clickSaveButton();
		
		String[] /*strstatusTypeValues1 = { strstatusTypeValues[0],
				strstatusTypeValues[1], strstatusTypeValues[2],
				strstatusTypeValues[3] }, */
		strSTNames1 = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName };
		
		objViewsList.navigateToViewsList()
//				.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc)
//				.selectStatusTypeForView(strstatusTypeValues1)
//				.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView()
				.createView(objView_data.strViewName, objView_data.strViewDesc,
						objResource_data.strResourceName, strSTNames1);

		objLogin.clickLogOut();
		
		System.out.println("-------Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		String[] strstatusTypeValues2 = { strstatusTypeValues[4],
				strstatusTypeValues[5] },
				strSTNames2 = {objStatusTypes_data.strSSTStatusTypeName,
							   objStatusTypes_data.strDateStatusTypeName};

		objViews1.clickOnCustomizeLink();

		objViewsList1.verEditViewPageIsDisplayed()
				.enterViewName(objView_data.strViewName2)
				.clickOnSTTab();
		
		for(int i=0; i<strSTNames2.length;i++){
			objViewsList1.selectStatusType(strSTNames2[i]);
		}
		
		objViewsList1
				.clickOnSaveOfCreateNewView();
		
		objNavigationToSubMenus1.navigateToViews();

		objViewsList1.verViewInList(objView_data.strViewName2);

		String[] strAllStatausTypes = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName };

		objNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName2);

		objViews1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int i = 0; i < strAllStatausTypes.length; i++) {

			objViews1.verStatusTypes(objResourceType_data.strResourceTypeName,
					strAllStatausTypes[i]);
		}

		objLogin1.clickLogOut();

		blnTest = true;

		if (blnTest) {

			String[] strTestData1 = {
					gstrTCID,
					objTest_data.strRegionName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objStatusTypes_data.strNSTStatusTypeName + ","
							+ objStatusTypes_data.strMSTStatusTypeName + ","
							+ objStatusTypes_data.strTSTStatusTypeName + ","
							+ objStatusTypes_data.strNDSTStatusTypeName + ","
							+ objStatusTypes_data.strDateStatusTypeName + ","
							+ objStatusTypes_data.strSSTStatusTypeName,
					objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName, objView_data.strViewName2 };

			objOffCommonFunc.writeResultData(strTestData1,
					strPartialAutoResultsPath, "MobileTestData");
		}
		
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description :Verify that resources can be added/removed from a view.
	'Date	 	 : 12-Jun-2015
	'Author		 : Anil
	'-------------------------------------------------------------------------------------
	'Modified Date			                        	              Modified By
	'Date					                                          Name
	**************************************************************************************/
	@Test(description = "Verify that resources can be added/removed from a view.")
	public void testHappyDay69809() throws Exception {

		gstrTCID = "69809";
		gstrTO = "Verify that resources can be added/removed from a view.";

		// Objects for data
		Login_data objTest_data = new Login_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();		
		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;
		boolean blnTest = false;

		UsersList UsersList_page = new UsersList(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		Views objViews1 = new Views(this.driver1);
		
		String strResourceValue[] = new String[2];
		String strstatusTypeValues[] = new String[6];
		String strstatusesValues[] = new String[2];
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

		Resource_Page.createResource(objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[1] = Resource_Page
				.getResourceValue(objResource_data.strResourceName);
		
		UsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(
						objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionViewsOption()
				.clickSaveButton();
		
		String[] strAllStatausTypes = {
			    objStatusTypes_data.strNSTStatusTypeName,
			    objStatusTypes_data.strNDSTStatusTypeName,
			    objStatusTypes_data.strTSTStatusTypeName,
			    objStatusTypes_data.strMSTStatusTypeName,
			    objStatusTypes_data.strSSTStatusTypeName,
			    objStatusTypes_data.strDateStatusTypeName };
		
		objViewsList.navigateToViewsList()
//				.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc)
//				.selectStatusTypeForView(strstatusTypeValues)
//				.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();
				.createView(objView_data.strViewName, objView_data.strViewDesc,
						objResource_data.strResourceName, strAllStatausTypes);

		objLogin.clickLogOut();
		System.out.println(objUserdata.strNewUserName);
		System.out.println("-------Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViews1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		objViews1.verResourceTypeAndResourceName1(objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName1);
		
		for (int i = 0; i < strAllStatausTypes.length; i++) {

			objViews1.verStatusTypes(objResourceType_data.strResourceTypeName,
					strAllStatausTypes[i]);
		}

		objViewsList1.navigateToViewsListNew()
					.clickOnEditLinkOfView(objView_data.strViewName)
					.clickOnResourcesTab()
					.selectResource(objResource_data.strResourceName1)
					.deselectResource(objResource_data.strResourceName)
					.clickOnSTTab();
		
		for(int i =0; i<strAllStatausTypes.length; i++) {
			objViewsList1.selectStatusType(strAllStatausTypes[i]);
		}
		objViewsList1.clickOnSaveOfCreateNewView()
					.verRegionViewListPageIsDisplayed();
					
		objNavigationToSubMenus1
		.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViews1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName1);

		objViews1.verResourceTypeAndResourceName1(objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);
		
		for (int i = 0; i < strAllStatausTypes.length; i++) {

			objViews1.verStatusTypes(objResourceType_data.strResourceTypeName,
					strAllStatausTypes[i]);
		}
		
		objLogin1.clickLogOut();

		blnTest = true;

		if (blnTest) {

			String[] strTestData1 = {
					gstrTCID,
					objTest_data.strRegionName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objStatusTypes_data.strNSTStatusTypeName + ","
							+ objStatusTypes_data.strMSTStatusTypeName + ","
							+ objStatusTypes_data.strTSTStatusTypeName + ","
							+ objStatusTypes_data.strNDSTStatusTypeName + ","
							+ objStatusTypes_data.strDateStatusTypeName + ","
							+ objStatusTypes_data.strSSTStatusTypeName,
					objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName+", "+objResource_data.strResourceName1, objView_data.strViewName };

			objOffCommonFunc.writeResultData(strTestData1,
					strPartialAutoResultsPath, "MobileTestData");
		}
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description :Verify that status types can be added/removed from a view.
	'Date	 	 : 12-Jun-2015
	'Author		 : Anil
	'-------------------------------------------------------------------------------------
	'Modified Date			                        	              Modified By
	'Date					                                          Name
	**************************************************************************************/
	@Test(description = "Verify that status types can be added/removed from a view.")
	public void testHappyDay69810() throws Exception {

		gstrTCID = "69810";
		gstrTO = "Verify that status types can be added/removed from a view.";

		// Objects for data
		Login_data objTest_data = new Login_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();		
		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;
		boolean blnTest = false;

		UsersList UsersList_page = new UsersList(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		Views objViews1 = new Views(this.driver1);
		
		String strResourceValue[] = new String[2];
		String strstatusTypeValues[] = new String[6];
		String strstatusesValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);
System.out.println(objUserdata.strNewUserName);
System.out.println(objStatusTypes_data.strNSTStatusTypeName);
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

		UsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionViewsOption().clickSaveButton();
		
		String[] strstatusTypeValues1 = { strstatusTypeValues[0],
				strstatusTypeValues[1], strstatusTypeValues[2] },
				strStatausTypes1 = {
						objStatusTypes_data.strNSTStatusTypeName,
						objStatusTypes_data.strNDSTStatusTypeName,
						objStatusTypes_data.strTSTStatusTypeName},
				strStatsuTypes2 = {
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strSSTStatusTypeName,
						objStatusTypes_data.strDateStatusTypeName};
		
		String[] strstatusTypeValue2 = { strstatusTypeValues[3],
				strstatusTypeValues[4], strstatusTypeValues[5] };
		
		objViewsList.navigateToViewsList()
//				.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc)
//				.selectStatusTypeForView(strstatusTypeValues1)
//				.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();
				.createView(objView_data.strViewName, objView_data.strViewDesc,
						objResource_data.strResourceName, strStatausTypes1);

		objLogin.clickLogOut();
		System.out.println(objUserdata.strNewUserName);
		System.out.println("-------Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViews1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);
		
		for (int i = 0; i < strStatausTypes1.length; i++) {

			objViews1.verStatusTypes(objResourceType_data.strResourceTypeName,
					strStatausTypes1[i]);
		}

		for (int i = 0; i < strStatsuTypes2.length; i++) {

			objViews1.verStatusTypesNotDisplayed(objResourceType_data.strResourceTypeName, strStatsuTypes2[i]);
		}
		
		objViewsList1.navigateToViewsListNew()
					.clickOnEditLinkOfView(objView_data.strViewName)
					.clickOnSTTab();
		
		for(int i=0;i<strStatsuTypes2.length;i++){
			
			objViewsList1.selectStatusType(strStatsuTypes2[i]);
			
		}
		
		for (int i = 0; i < strStatausTypes1.length; i++) {

			objViewsList1.deSelectStatusType(strStatausTypes1[i]);

		}
		
		objViewsList1
//					.selectStatusTypeForView(strstatusTypeValue2)
//					.deselectStatusTypeForView(strstatusTypeValues1)
					.clickOnSaveOfCreateNewView()
					.verRegionViewListPageIsDisplayed();
					
		objNavigationToSubMenus1
		.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViews1.verResourceTypeAndResourceName(objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);
		
		for (int i = 0; i < strStatsuTypes2.length; i++) {

			objViews1.verStatusTypes(objResourceType_data.strResourceTypeName,
					strStatsuTypes2[i]);
		}
		
		for (int i = 0; i < strStatausTypes1.length; i++) {
			objViews1.verStatusTypesNotDisplayed(objResourceType_data.strResourceTypeName, strStatausTypes1[i]);
		}
		
		objLogin1.clickLogOut();

		blnTest = true;

		if (blnTest) {

			String[] strTestData1 = {
					gstrTCID,
					objTest_data.strRegionName,
					objUserdata.strNewUserName + "/"
							+ objUserdata.strNewPassword,
					objStatusTypes_data.strNSTStatusTypeName + ","
							+ objStatusTypes_data.strMSTStatusTypeName + ","
							+ objStatusTypes_data.strTSTStatusTypeName + ","
							+ objStatusTypes_data.strNDSTStatusTypeName + ","
							+ objStatusTypes_data.strDateStatusTypeName + ","
							+ objStatusTypes_data.strSSTStatusTypeName,
					objResourceType_data.strResourceTypeName,
					objResource_data.strResourceName, objView_data.strViewName };

			objOffCommonFunc.writeResultData(strTestData1,
					strPartialAutoResultsPath, "MobileTestData");
		}
		gstrResult = "PASS";
	}

	/*************************************************************************************
	'Description : Verify that users can be assigned to access region views.
	'Date	 	 : 15-Jun-2015
	'Author		 : Anitha
	'-------------------------------------------------------------------------------------
	'Modified Date			                        	              Modified By
	'Date					                                          Name
	**************************************************************************************/
	@Test(description = "Verify that users can be assigned to access region views.")
	public void testHappyDay186191() throws Exception {

		gstrTCID = "186191";//Old TC ID 69868 is deactivated 
		gstrTO = "Verify that users can be assigned to access region views.";

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
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		Views objViews1 = new Views(this.driver1);
		
		String strResourceValue[] = new String[1];
		String strstatusTypeValues[] = new String[6];
		String strstatusesValues[] = new String[2];
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

		System.out.println(objUserdata.strNewUserName);
		UsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionViewsOption().clickSaveButton();
		
		System.out.println(objUserdata.strNewUserName);
		
		UsersList_page.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName1)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionViewsOption().clickSaveButton();
		System.out.println(objUserdata.strNewUserName1);
		UsersList_page
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName2,
						objUserdata.strNewPassword, objUserdata.strFullName2)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectConfigureRegionViewsOption().clickSaveButton();
		System.out.println(objUserdata.strNewUserName2);
		String[] strStatusTypeNames = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strDateStatusTypeName };
		
		objViewsList.navigateToViewsList()
//				.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc)
//				.selectStatusTypeForView(strstatusTypeValues)
//				.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView()
				.createView(objView_data.strViewName, objView_data.strViewDesc,
						objResource_data.strResourceName, strStatusTypeNames);

		objLogin.clickLogOut();
		
		System.out.println("-------Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToViews();
//modified 		
		objViewsList1.clickOnEditLinkOfView(objView_data.strViewName)
		             .clickOnUsersTab()
		             .verifySecurityChkBoxInUsersTabisSelected()
		             .verifyUserIsNotListedInUsersTab(objUserdata.strNewUserName1)
		             .verifyUserIsNotListedInUsersTab(objUserdata.strNewUserName2)
				     .deselectSecurityChkBoxInUsersTab()
				     .verifyUsersCheckBoxIsEnabled(objUserdata.strNewUserName1)
				     .verifyUsersCheckBoxIsEnabled(objUserdata.strNewUserName2)
				     .selectUsersCheckBoxinAssigUsers(objUserdata.strNewUserName1)
				     .clickOnSaveButton()
				     .verRegionViewListPageIsDisplayed()
				     .verViewInList(objView_data.strViewName);
		
		objNavigationToSubMenus1.clickOnViewMenu();
		
		Thread.sleep(5000);
		
		objViewsList1.verViewIsNotInMenuDroDown(objView_data.strViewName);

		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName1,
				objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
		String[] strAllStatausTypes = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName };

		objNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViews1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

		for (int i = 0; i < strAllStatausTypes.length; i++) {

			objViews1.verStatusTypes(objResourceType_data.strResourceTypeName,
					strAllStatausTypes[i]);
		}
		
		objNavigationToSubMenus1.navigateToViews();
		
		objViewsList1.verViewInList(objView_data.strViewName);

		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName2,
				objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubMenus1.clickOnViewMenu();
		
		Thread.sleep(5000);
		
		objViewsList1.verViewIsNotInMenuDroDown(objView_data.strViewName);
		
        objNavigationToSubMenus1.navigateToViews();
		
		objViewsList1.verViewInList(objView_data.strViewName);
		
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Verify that nedoc status types can be updated from View screens
	'Date	 	 : 18-Jan-2016
	'Author		 : Renushree
	'-------------------------------------------------------------------------------------
	'Modified Date			                        	              Modified By
	'Date					                                          Name
	**************************************************************************************/
	@Test(description = "Verify that nedoc status types can be updated from View screens")
	public void testHappyDay119077() throws Exception {

		gstrTCID = "119077";
		gstrTO = "Verify that nedoc status types can be updated from View screens";

		// Objects for data
		Login_data objTest_data = new Login_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();

		UsersList UsersList_page = new UsersList(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(
				this.driver1);
		Map objMap1 = new Map(this.driver1);

		String strResourceValue[] = new String[1];
		String strStatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strSubResourceTypeValue[] = new String[1];
		String strSubResourceValue[] = new String[1];

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		objStatusTypeList.navigateToStatusTypeListNew();

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createEventStatusTypeWithSection(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.streNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streNDSTStatusTypeName);

		objStatusTypeList.createSharedStatusTypeWithSection(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName1);

		objStatusTypeList.createSharedStatusTypeWithEventSection(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.streNDSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streNDSTStatusTypeName1);

		objStatusTypeList.createPrivateStatusTypeWithSection(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strpNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strpNDSTStatusTypeName);

		objStatusTypeList.createPrivateStatusTypeWithEventSection(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.streNDSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.streNDSTStatusTypeName2);

		// Resource type creation
		ResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strStatusTypeValues);

		strResourceTypeValue[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		String strOtherThanEveSTVal[] = { strStatusTypeValues[0],
				strStatusTypeValues[2], strStatusTypeValues[4] };

		// Create Sub-Resource Type
		ResourceType_Page
				.navigateToResourceTypePage()
				.createResourceType(
						objResourceType_data.strSubResourceTypeName,
						strOtherThanEveSTVal)
				.clickOnEditLinkOfResourceType(
						objResourceType_data.strSubResourceTypeName)
				.enterResourceTypeDescription(
						objResourceType_data.strResTypeDescription)
				.selectSubResourceTypeCheckBox().clickOnSaveButton();

		System.out.println(objResourceType_data.strSubResourceTypeName);

		strSubResourceTypeValue[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strSubResourceTypeName);

		// Resource creation
		Resource_Page.navigateToResourceListPage()

		.createResourceWithAddress(objResource_data.strResourceName,
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

		// Sub-Resource creation
		Resource_Page.clickOnSubResourcesLink(objResource_data.strResourceName)
				.createSubResourceForResource(
						objResource_data.strSubResourceName,
						objResource_data.strResourceAbbrivation,
						objResourceType_data.strSubResourceTypeName,
						objResource_data.strStandardResourceTypename,
						objResource_data.strResourceFirstName,
						objResource_data.strResourceLastName);

		strSubResourceValue[0] = Resource_Page
				.getSubResourceValue(objResource_data.strSubResourceName);

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.clickOncreateEventTemplate()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition)
				.selectResourceType(strResourceTypeValue[0]);

		for (int i = 0; i < strStatusTypeValues.length; i++) {
			objEventSetUp.selectStatusType(strStatusTypeValues[i]);
		}

		objEventSetUp.clickSaveButton().deselectSelectAllWebOption()
				.verEveTemplateInList(objEventSetUp_data.strEventTemplate);

		objNavigationToSubMenus.navigateToUsers();

		UsersList_page
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectViewcustomViewOption()
				.selectMaintainEventsOption().clickSaveButton();

		String strOtherThanEveStatusTypeNames[] = {
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName1,
				objStatusTypes_data.strpNDSTStatusTypeName };

		objNavigationToSubMenus.navigateToViews();

		objViewsList.clickOnEditOfRegDefault()
					.clickOnResourcesTab()
					.selectResource(
							objResource_data.strResourceName)
					.clickOnSTTab();

		for (int i = 0; i < strOtherThanEveStatusTypeNames.length; i++) {

			objViewsList.selectStatusType(strOtherThanEveStatusTypeNames[i]);
		}

		objViewsList
				.clickOnSaveOfCreateNewView();

		objViewsList
				.createView(objView_data.strViewName, objView_data.strViewDesc,
						objResource_data.strResourceName,
						strOtherThanEveStatusTypeNames);
//				.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);
//
//		for (int i = 0; i < strOtherThanEveStatusTypeNames.length; i++) {
//
//			objViewsList.selectStatusType(strOtherThanEveStatusTypeNames[i]);
//
//		}
//
//		objViewsList.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();

		objViewsList.clickOncustomizeResourceDetailView()
				.clickSubResourceButton()
				.verEditSubResourceDetailViewSectionsPageIsDisplayed();

		objViewsList.clickOnSubResourceTypeName(
				objResourceType_data.strSubResourceTypeName)
				.selectSubResourceTypeCheckBox(strSubResourceTypeValue[0]);

		for (int i = 0; i < strOtherThanEveSTVal.length; i++) {
			objViewsList.selectSubResourceCheckBox(strOtherThanEveSTVal[i]);
		}

		objViewsList.clickOnSaveButton();

		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToCustomInView();

		objCustomUnderView1.clickOnSetupCustomViewLink()
				.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch().selectResource(strResourceValue)
				.clickOnAddToCustomView().clickOnOptions()
				.selectAllChkBoxInOptions()
				.selectStatusTypes(strOtherThanEveSTVal).clickOnSave();
		System.out.println(objView_data.strCustomView);

		objEventManagement1.navigateToEventManagement().clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue[0])
				.clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);

		objNavigationToSubMenus1.navigateToRegDefault();

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus1
				.clickOnSelectAll()
				.enterNedocsUpdateValue(strStatusTypeValues[0],
						objView_data.strValueForNDST)
				.enterNedocsUpdateValue(strStatusTypeValues[2],
						objView_data.strValueForNDST1)
				.enterNedocsUpdateValue(strStatusTypeValues[4],
						objView_data.strValueForNDST2).clickOnSaveButton();

		objUpdateStatus1
				.verifyUpdatedStatusValues(strResourceValue[0],
						strStatusTypeValues[0], objView_data.strNEDOCValue)
				.verifyUpdatedStatusValues(strResourceValue[0],
						strStatusTypeValues[2], objView_data.strNEDOCValue2)
				.verifyUpdatedStatusValues(strResourceValue[0],
						strStatusTypeValues[4], objView_data.strNEDOCValue3);

		objNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus1
				.clickOnSelectAll()
				.enterNedocsUpdateValue(strStatusTypeValues[0],
						objView_data.strValueForNDST1)
				.enterNedocsUpdateValue(strStatusTypeValues[2],
						objView_data.strValueForNDST2)
				.enterNedocsUpdateValue(strStatusTypeValues[4],
						objView_data.strValueForNDST).clickOnSaveButton();

		objUpdateStatus1
				.verifyUpdatedStatusValues(strResourceValue[0],
						strStatusTypeValues[0], objView_data.strNEDOCValue2)
				.verifyUpdatedStatusValues(strResourceValue[0],
						strStatusTypeValues[2], objView_data.strNEDOCValue3)
				.verifyUpdatedStatusValues(strResourceValue[0],
						strStatusTypeValues[4], objView_data.strNEDOCValue);

		objViewsList1
				.clickOnResourceAndNavigateToResourceDetail(objResource_data.strResourceName);

		objViewsList1.clickOnIndividualUpdateStatus(strResourceValue[0],
				strStatusTypeValues[0]);

		objUpdateStatus1.enterNedocsUpdateValue(strStatusTypeValues[0],
				objView_data.strValueForNDST2)
				.enterComments(strStatusTypeValues[0], objView_data.strComment).clickOnSaveButton();

		objViewsList1.verifyUpdatedValueAndComments(
				objStatusTypes_data.strNDSTStatusTypeName,
				objView_data.strNEDOCValue3, objView_data.strComment);

		objViewsList1.clickOnIndividualUpdateStatus(strResourceValue[0],
				strStatusTypeValues[1]);

		objUpdateStatus1.enterNedocsUpdateValue(strStatusTypeValues[1],
				objView_data.strValueForNDST)
				.enterComments(strStatusTypeValues[1], objView_data.strComment1).clickOnSaveButton();

		objViewsList1.verifyUpdatedValueAndComments(
				objStatusTypes_data.streNDSTStatusTypeName,
				objView_data.strNEDOCValue, objView_data.strComment1);

		objViewsList1.clickOnIndividualUpdateStatus(strResourceValue[0],
				strStatusTypeValues[2]);

		objUpdateStatus1.enterNedocsUpdateValue(strStatusTypeValues[2],
				objView_data.strValueForNDST1)
				.enterComments(strStatusTypeValues[2], objView_data.strComment2).clickOnSaveButton();

		objViewsList1.verifyUpdatedValueAndComments(
				objStatusTypes_data.strNDSTStatusTypeName1,
				objView_data.strNEDOCValue2, objView_data.strComment2);

		objViewsList1.clickOnIndividualUpdateStatus(strResourceValue[0],
				strStatusTypeValues[3]);

		objUpdateStatus1.enterNedocsUpdateValue(strStatusTypeValues[3],
				objView_data.strValueForNDST5)
				.enterComments(strStatusTypeValues[3], objView_data.strComment3).clickOnSaveButton();

		objViewsList1.verifyUpdatedValueAndComments(
				objStatusTypes_data.streNDSTStatusTypeName1,
				objView_data.strNEDOCValue5, objView_data.strComment3);

		objViewsList1.clickOnIndividualUpdateStatus(strResourceValue[0],
				strStatusTypeValues[4]);

		objUpdateStatus1.enterNedocsUpdateValue(strStatusTypeValues[4],
				objView_data.strValueForNDST6)
				.enterComments(strStatusTypeValues[4], objView_data.strComment4).clickOnSaveButton();

		objViewsList1.verifyUpdatedValueAndComments(
				objStatusTypes_data.strpNDSTStatusTypeName,
				objView_data.strNEDOCValue6, objView_data.strComment4);

		objViewsList1.clickOnIndividualUpdateStatus(strResourceValue[0],
				strStatusTypeValues[5]);

		objUpdateStatus1.enterNedocsUpdateValue(strStatusTypeValues[5],
				objView_data.strValueForNDST7)
				.enterComments(strStatusTypeValues[5], objView_data.strComment5).clickOnSaveButton();

		objViewsList1.verifyUpdatedValueAndComments(
				objStatusTypes_data.streNDSTStatusTypeName2,
				objView_data.strNEDOCValue7, objView_data.strComment5);

		objViewsList1
				.clickOnUpdateStatusOfSubResource(objResource_data.strSubResourceName);

		objUpdateStatus1
				.clickOnSelectAll()
				.enterNedocsUpdateValue(strStatusTypeValues[0],
						objView_data.strValueForNDST1)
				.enterNedocsUpdateValue(strStatusTypeValues[2],
						objView_data.strValueForNDST2)
				.enterNedocsUpdateValue(strStatusTypeValues[4],
						objView_data.strValueForNDST).clickOnSaveButton();

		objViewsList1
				.verifyUpdatedValue(strSubResourceValue[0],
						strStatusTypeValues[0], objView_data.strNEDOCValue2)
				.verifyUpdatedValue(strSubResourceValue[0],
						strStatusTypeValues[2], objView_data.strNEDOCValue3)
				.verifyUpdatedValue(strSubResourceValue[0],
						strStatusTypeValues[4], objView_data.strNEDOCValue);

		objNavigationToSubMenus1.navigateToCustomInView();

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus1
				.clickOnSelectAll()
				.enterNedocsUpdateValue(strStatusTypeValues[0],
						objView_data.strValueForNDST)
				.enterNedocsUpdateValue(strStatusTypeValues[2],
						objView_data.strValueForNDST1)
				.enterNedocsUpdateValue(strStatusTypeValues[4],
						objView_data.strValueForNDST2).clickOnSaveButton();

		objUpdateStatus1
				.verifyUpdatedStatusValues(strResourceValue[0],
						strStatusTypeValues[0], objView_data.strNEDOCValue)
				.verifyUpdatedStatusValues(strResourceValue[0],
						strStatusTypeValues[2], objView_data.strNEDOCValue2)
				.verifyUpdatedStatusValues(strResourceValue[0],
						strStatusTypeValues[4], objView_data.strNEDOCValue3);

		objLinksAtTopRightCorners1.clickOnShowMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus1
				.clickOnSelectAll()
				.enterNedocsUpdateValue(strStatusTypeValues[0],
						objView_data.strValueForNDST7)
				.enterNedocsUpdateValue(strStatusTypeValues[1],
						objView_data.strValueForNDST6)
				.enterNedocsUpdateValue(strStatusTypeValues[2],
						objView_data.strValueForNDST5)
				.enterNedocsUpdateValue(strStatusTypeValues[3],
						objView_data.strValueForNDST2)
				.enterNedocsUpdateValue(strStatusTypeValues[4],
						objView_data.strValueForNDST1)
				.enterNedocsUpdateValue(strStatusTypeValues[5],
						objView_data.strValueForNDST).clickOnSaveButton();

		objMap1.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);

		objMap1.verUpdateValuesInPopupWindow(objView_data.strNEDOCValue7)
				.verUpdateValuesInPopupWindow(objView_data.strNEDOCValue6)
				.verUpdateValuesInPopupWindow(objView_data.strNEDOCValue5)
				.verUpdateValuesInPopupWindow(objView_data.strNEDOCValue3)
				.verUpdateValuesInPopupWindow(objView_data.strNEDOCValue2)
				.verUpdateValuesInPopupWindow(objView_data.strNEDOCValue);

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus1
				.clickOnSelectAll()
				.enterNedocsUpdateValue(strStatusTypeValues[0],
						objView_data.strValueForNDST)
				.enterNedocsUpdateValue(strStatusTypeValues[1],
						objView_data.strValueForNDST1)
				.enterNedocsUpdateValue(strStatusTypeValues[2],
						objView_data.strValueForNDST2)
				.enterNedocsUpdateValue(strStatusTypeValues[3],
						objView_data.strValueForNDST5)
				.enterNedocsUpdateValue(strStatusTypeValues[4],
						objView_data.strValueForNDST6)
				.enterNedocsUpdateValue(strStatusTypeValues[5],
						objView_data.strValueForNDST7).clickOnSaveButton();

		objMap1.selectResourceNameInFindResourceDropdown(objResource_data.strResourceName);

		objMap1.verUpdateValuesInPopupWindow(objView_data.strNEDOCValue7)
				.verUpdateValuesInPopupWindow(objView_data.strNEDOCValue6)
				.verUpdateValuesInPopupWindow(objView_data.strNEDOCValue5)
				.verUpdateValuesInPopupWindow(objView_data.strNEDOCValue3)
				.verUpdateValuesInPopupWindow(objView_data.strNEDOCValue2)
				.verUpdateValuesInPopupWindow(objView_data.strNEDOCValue);

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus1
				.clickOnSelectAll()
				.enterNedocsUpdateValue(strStatusTypeValues[0],
						objView_data.strValueForNDST)
				.enterNedocsUpdateValue(strStatusTypeValues[1],
						objView_data.strValueForNDST1)
				.enterNedocsUpdateValue(strStatusTypeValues[2],
						objView_data.strValueForNDST2)
				.enterNedocsUpdateValue(strStatusTypeValues[3],
						objView_data.strValueForNDST5)
				.enterNedocsUpdateValue(strStatusTypeValues[4],
						objView_data.strValueForNDST6)
				.enterNedocsUpdateValue(strStatusTypeValues[5],
						objView_data.strValueForNDST7).clickOnSaveButton();

		objUpdateStatus1
				.verifyUpdatedStatusValues(strResourceValue[0],
						strStatusTypeValues[0], objView_data.strNEDOCValue)
				.verifyUpdatedStatusValues(strResourceValue[0],
						strStatusTypeValues[1], objView_data.strNEDOCValue2)
				.verifyUpdatedStatusValues(strResourceValue[0],
						strStatusTypeValues[2], objView_data.strNEDOCValue3)
				.verifyUpdatedStatusValues(strResourceValue[0],
						strStatusTypeValues[3], objView_data.strNEDOCValue5)
				.verifyUpdatedStatusValues(strResourceValue[0],
						strStatusTypeValues[4], objView_data.strNEDOCValue6)
				.verifyUpdatedStatusValues(strResourceValue[0],
						strStatusTypeValues[5], objView_data.strNEDOCValue7);

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
}
