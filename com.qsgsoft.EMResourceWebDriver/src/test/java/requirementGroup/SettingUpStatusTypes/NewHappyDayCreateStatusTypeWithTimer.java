package requirementGroup.SettingUpStatusTypes;

import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.NavigationToSubMenus;
import lib.page.EventManagement;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UpdateStatus;
import lib.page.UsersList;
import lib.page.ViewsList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewHappyDayCreateStatusTypeWithTimer extends TestNG_UI_EXTENSIONS {

	public NewHappyDayCreateStatusTypeWithTimer() throws Exception {
		super();
	}

	/*************************************************************************************
	 * 'Description : Verify that a timer can be associated with a number status
	 * type. 'Precondition: 'Date : 18-May-2015 'Author : Anil
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 **************************************************************************************/
	@Test(enabled=false,description = " Verify that a timer can be associated with a number status type.")
	public void testHappyDay69101() throws Exception {

		gstrTCID = "69101";
		gstrTO = "Verify that a timer can be associated with a number status type.";

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
		StatusTypeList objStatusTypeList1 = new StatusTypeList(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatusTypes_data.strNumberStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strNSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription)
				.selectEventExpirationOption()
				.selectExpirationMinute(
						objStatusTypes_data.strStatusExpirationTime)
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
//		objViewsList.selectViewType(objView_data.strResource);
//		objViewsList.selectStatusType(objStatusTypes_data.strNSTStatusTypeName)
//				.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();

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

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0],
				strStatusTypeValues[0], "--");

		objStatusTypeList1.navigateToStatusTypeList();

		objStatusTypeList1
				.clickOnEditOfStatusType(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList1
				.selectTimerType(objStatusTypes_data.countDownAndStopCounting);

		objStatusTypeList1.clickOnSaveButton();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1.clickOnIndividualUpdateStatus(strResourceValue[0],
				strStatusTypeValues[0]);

		objUpdateStatus1.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
				objView_data.strValueForUpdate).clickOnSaveButton();

		String strUpdatedTime = objEventManagement1
				.getApplicationTimeWithCSTCDT();

		objUpdateStatus1.verifyLastUpdatedTime(
				objResource_data.strResourceName, strUpdatedTime + " (00:04↓)");
		String strLastUpdatedValue = "Last Update: " + strUpdatedTime
				+ " (00:04↓)";
		String strLastUpdatedValue1 = "Last Update: " + strUpdatedTime
				+ " (00:00)";
		String strUpdatedBy = "Updated By: " + objUserdata.strFullName;

		objUpdateStatus1.verifyLastUpdatedTimeInToolTip(strResourceValue[0],
				strStatusTypeValues[0], objView_data.strValueForUpdate,
				strLastUpdatedValue, strUpdatedBy);

		Thread.sleep(420000);
		objUpdateStatus1.verifyLastUpdatedTime(
				objResource_data.strResourceName, strUpdatedTime + " (00:00)");

		objUpdateStatus1.verifyLastUpdatedTimeInToolTipAfterOverDue(
				strResourceValue[0], strStatusTypeValues[0],
				objView_data.strValueForUpdate, strLastUpdatedValue1,
				strUpdatedBy);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

	/*************************************************************************************
	 * 'Description : Verify that a timer can be associated with a text status
	 * type. 'Precondition: 'Date : 18-May-2015 'Author : Anil
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 **************************************************************************************/
	@Test(enabled=false,description = "Verify that a timer can be associated with a text status type. ")
	public void testHappyDay69148() throws Exception {

		gstrTCID = "69148";
		gstrTO = " 	Verify that a timer can be associated with a text status type. ";

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
		StatusTypeList objStatusTypeList1 = new StatusTypeList(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatusTypes_data.strTextStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strTSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription)
				.selectEventExpirationOption()
				.selectExpirationMinute(
						objStatusTypes_data.strStatusExpirationTime)
				.clickOnSaveButton();

		strStatusTypeValues[0] = objStatusTypeList
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

		objNavigationToSubmenus.navigateToViews();

		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc, 
							objResource_data.strResourceName, objStatusTypes_data.strTSTStatusTypeName);
		
//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);
//		objViewsList.selectViewType(objView_data.strResource);
//		objViewsList.selectStatusType(objStatusTypes_data.strTSTStatusTypeName)
//				.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();

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

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0],
				strStatusTypeValues[0], "--");

		objStatusTypeList1.navigateToStatusTypeList();

		objStatusTypeList1
				.clickOnEditOfStatusType(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList1
				.selectTimerType(objStatusTypes_data.countUptoExpThenStop);

		objStatusTypeList1.clickOnSaveButton();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1.clickOnIndividualUpdateStatus(strResourceValue[0],
				strStatusTypeValues[0]);

		objUpdateStatus1.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
				objView_data.strValueForTST).clickOnSaveButton();

		String strUpdatedTime = objEventManagement1
				.getApplicationTimeWithCSTCDT();

		objUpdateStatus1.verifyLastUpdatedTime(
				objResource_data.strResourceName, strUpdatedTime + " (00:00↑)");
		String strLastUpdatedValue = "Last Update: " + strUpdatedTime
				+ " (00:00↑)";
		String strLastUpdatedValue1 = "Last Update: " + strUpdatedTime
				+ " (00:05)";
		String strUpdatedBy = "Updated By: " + objUserdata.strFullName;

		objUpdateStatus1.verifyLastUpdatedTimeInToolTip(strResourceValue[0],
				strStatusTypeValues[0], objView_data.strValueForTST,
				strLastUpdatedValue, strUpdatedBy);

		Thread.sleep(420000);
		objUpdateStatus1.verifyLastUpdatedTime(
				objResource_data.strResourceName, strUpdatedTime + " (00:05)");

		objUpdateStatus1
				.verifyLastUpdatedTimeInToolTipAfterOverDue(
						strResourceValue[0], strStatusTypeValues[0],
						objView_data.strValueForTST, strLastUpdatedValue1,
						strUpdatedBy);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

	/*************************************************************************************
	 * 'Description : Verify that a timer can be associated with a saturation score status type. 
	 * type. 'Precondition: 
	 * 'Date : 18-May-2015 
	 * 'Author : Anil
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 **************************************************************************************/
	@Test(enabled=false,description = "Verify that a timer can be associated with a saturation score status type. ")
	public void testHappyDay69149() throws Exception {

		gstrTCID = "69149";
		gstrTO = " 	Verify that a timer can be associated with a saturation score status type. ";

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
		StatusTypeList objStatusTypeList1 = new StatusTypeList(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatusTypes_data.strSaturationScoreStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strSSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription)
				.selectEventExpirationOption()
				.selectExpirationMinute(
						objStatusTypes_data.strStatusExpirationTime)
				.clickOnSaveButton();

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

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
//		objViewsList.selectViewType(objView_data.strResource);
//		objViewsList.selectStatusType(objStatusTypes_data.strSSTStatusTypeName)
//				.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();

		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc,
						objResource_data.strResourceName, objStatusTypes_data.strSSTStatusTypeName);
		
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

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0],
				strStatusTypeValues[0], "--");

		objStatusTypeList1.navigateToStatusTypeList();

		objStatusTypeList1
				.clickOnEditOfStatusType(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList1
				.selectTimerType(objStatusTypes_data.countUptoExpThenStart);

		objStatusTypeList1.clickOnSaveButton();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1.clickOnIndividualUpdateStatus(strResourceValue[0],
				strStatusTypeValues[0]);

		objUpdateStatus1.enterUpdateSSTValues(strStatusTypeValues[0], objView_data.strValueForSST)
		
		.clickOnSaveButton();

		String strUpdatedTime = objEventManagement1
				.getApplicationTimeWithCSTCDT();

		objUpdateStatus1.verifyLastUpdatedTime(
				objResource_data.strResourceName, strUpdatedTime + " (00:00↑)");
		String strLastUpdatedValue = "Last Update: " + strUpdatedTime
				+ " (00:00↑)";
		String strLastUpdatedValue1 = "Last Update: " + strUpdatedTime
				+ " (00:00↑)";
		String strLastUpdatedValue2 = "Last Update: " + strUpdatedTime
				+ " (00:01↑)";
		String strUpdatedBy = "Updated By: " + objUserdata.strFullName;

		objUpdateStatus1.verifyLastUpdatedTimeInToolTip(strResourceValue[0],
				strStatusTypeValues[0], objView_data.strUpdatedValForSST,
				strLastUpdatedValue, strUpdatedBy);

		Thread.sleep(420000);
		objUpdateStatus1.verifyLastUpdatedTime(
				objResource_data.strResourceName, strUpdatedTime + " (00:00↑)", strUpdatedTime + " (00:01↑)");

		objUpdateStatus1
				.verifyLastUpdatedTimeInToolTipAfterOverDue(
						strResourceValue[0], strStatusTypeValues[0],
						objView_data.strUpdatedValForSST, strLastUpdatedValue1,strLastUpdatedValue2,
						strUpdatedBy);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	 * 'Description :Verify that a timer can be associated with a multi status type. 
	 * type. 'Precondition: 
	 * 'Date : 18-May-2015 
	 * 'Author : Anil
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 **************************************************************************************/
	@Test(enabled=false,description = "Verify that a timer can be associated with a multi status type. ")
	public void testHappyDay69147() throws Exception {

		gstrTCID = "69147";
		gstrTO = "Verify that a timer can be associated with a multi status type. ";

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
		StatusTypeList objStatusTypeList1 = new StatusTypeList(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strStatusesValue[] = new String[1];
		
		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatusTypes_data.strMultiStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strMSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription)
				.clickOnSaveButton();

		objStatusTypeList.createMultiStatusTypesWithExpirationTime(objStatusTypes_data.strStatusNameInMulti, objStatusTypes_data.strStatusExpirationTime);
		
		strStatusesValue[0] = objStatusTypeList.getMSTStatusesValue(objStatusTypes_data.strStatusNameInMulti);
		
		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti1)
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
//		objViewsList.selectViewType(objView_data.strResource);
//		objViewsList.selectStatusType(objStatusTypes_data.strMSTStatusTypeName)
//				.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();

		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc, objResource_data.strResourceName, objStatusTypes_data.strMSTStatusTypeName);
		
		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
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

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0],
				strStatusTypeValues[0], "--");

		objStatusTypeList1.navigateToStatusTypeList();

		objStatusTypeList1.clickOnStatusesOfStatusType(objStatusTypes_data.strMSTStatusTypeName);
		
		objStatusTypeList1
				.editStatusForMultiStatusType(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList1
				.selectTimerType(objStatusTypes_data.countDownToExpThenCountUp);

		objStatusTypeList1.clickOnSaveButton();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1.clickOnIndividualUpdateStatus(strResourceValue[0],
				strStatusTypeValues[0]);

		objUpdateStatus1.selectMSTUpdateValue(strStatusTypeValues[0], strStatusesValue[0])
						.clickOnSaveButton();

		String strUpdatedTime = objEventManagement1
				.getApplicationTimeWithCSTCDT();

		objUpdateStatus1.verifyLastUpdatedTime(
				objResource_data.strResourceName, strUpdatedTime + " (00:04↓)");
		String strLastUpdatedValue = "Last Update: " + strUpdatedTime
				+ " (00:04↓)";
		String strLastUpdatedValue1 = "Last Update: " + strUpdatedTime
				+ " (00:00↑)";
		String strLastUpdatedValue2 = "Last Update: " + strUpdatedTime
				+ " (00:01↑)";
		String strUpdatedBy = "Updated By: " + objUserdata.strFullName;

		objUpdateStatus1.verifyLastUpdatedTimeInToolTip(strResourceValue[0],
				strStatusTypeValues[0], objStatusTypes_data.strStatusNameInMulti,
				strLastUpdatedValue, strUpdatedBy);

		Thread.sleep(420000);
		objUpdateStatus1.verifyLastUpdatedTime(
				objResource_data.strResourceName, strUpdatedTime + " (00:00↑)", strUpdatedTime + " (00:01↑)");

		objUpdateStatus1
				.verifyLastUpdatedTimeInToolTipAfterOverDue(
						strResourceValue[0], strStatusTypeValues[0],
						objStatusTypes_data.strStatusNameInMulti, strLastUpdatedValue1,strLastUpdatedValue2,
						strUpdatedBy);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
}
