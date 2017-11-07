package requirementGroup.SettingUpStatusTypes;

import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.LinksAtTopRightCorners;
import lib.module.NavigationToSubMenus;
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

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSThreeBrowser;

public class NewHappyDayInactiveNumberStatusType extends TestNG_UI_EXTENSIONSThreeBrowser {

	public NewHappyDayInactiveNumberStatusType() throws Exception {
		super();
	}

	/*************************************************************************************
	'Description : Verify that deactivated status types are no longer available on view-map screen
	'Precondition: 
	'Date        : 02-Sep-2014 
	'Author      : Anil
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test( description = " Verify that deactivated status types are no longer available on view-map screen")
	public void testHappyDay176738() throws Exception {

		gstrTCID = "176738";
		gstrTO = "Verify that deactivated status types are no longer available on view-map screen";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Map objMap1 = new Map(this.driver1);
		
		Login objLogin2 = new Login(this.driver2);
		RegionDefault objRegionDefault2 = new RegionDefault(this.driver2);
		SelectRegion objSelectRegionpage2 = new SelectRegion(this.driver2);
		StatusTypeList objStatusTypeList2 = new StatusTypeList(this.driver2);


		String strStatusTypeValues[] = new String[5];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
		
		objStatusTypeList.navigateToStatusTypeList();

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
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti, objStatusTypes_data.strStatusColor)
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
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName1);

		objResourceType.navigateToResourceTypePage();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

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

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName).selectFirstRole()
						.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.clickSaveButton();
		
		System.out.println(objUserdata.strNewUserName);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubMenus1.navigateToMap();
		String strStatusTypeNames[] = {objStatusTypes_data.strNSTStatusTypeName, objStatusTypes_data.strMSTStatusTypeName, objStatusTypes_data.strTSTStatusTypeName, objStatusTypes_data.strSSTStatusTypeName};
		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.verStatusTypesInPopupWindow(strStatusTypeNames);
		
		objLogin2.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage2
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault2.selectFrame();
		
		objStatusTypeList2.navigateToStatusTypeList();
	
		for(int intCount = 0; intCount<strStatusTypeNames.length; intCount++){
		objStatusTypeList2.deActivateStatusType(strStatusTypeNames[intCount]);
		}

		objMap1.clickOnRefreshLink();

		objMap1.verStatusTypesNotInPopupWindow(strStatusTypeNames);

		objLogin2.clickLogOut();
		
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Verify that reactivated status types are available on view-map screen
	'Precondition: 
	'Date        : 16-Feb-2016 
	'Author      : Pallavi
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test( description = "Verify that reactivated status types are available on view-map screen")
	public void testHappyDay176741() throws Exception {

		gstrTCID = "176741";
		gstrTO = "Verify that reactivated status types are available on view-map screen";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Map objMap1 = new Map(this.driver1);
		
		Login objLogin2 = new Login(this.driver2);
		RegionDefault objRegionDefault2 = new RegionDefault(this.driver2);
		SelectRegion objSelectRegionpage2 = new SelectRegion(this.driver2);
		StatusTypeList objStatusTypeList2 = new StatusTypeList(this.driver2);


		String strStatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
		
		objStatusTypeList.navigateToStatusTypeList();

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
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,	objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strStatusNameInMulti1)
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
		
		objResourceType.navigateToResourceTypePage();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource.navigateToResourceListPage()
				   .createResourceWithAddress(
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

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(
						objResource_data.strResourceName)
				.selectViewResourceCheckBox(
						objResource_data.strResourceName)
				.clickSaveButton();
		
		System.out.println(objUserdata.strNewUserName);

		objNavigationToSubmenus.navigateToStatusTypesInSetup();
		
		String strStatusTypeNames[] = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName };
		
		String strDateStatusTypeName[] = {
				objStatusTypes_data.strDateStatusTypeName };
				
		for (int intCount = 0; intCount < strStatusTypeNames.length; intCount++) {
			objStatusTypeList
					.deActivateStatusType(strStatusTypeNames[intCount]);
		}
		
		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubMenus1.navigateToMap();
		
		objMap1.selectResourceNameInFindResourceDropdown(
					objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.verStatusTypesInPopupWindow(strDateStatusTypeName)
				.verStatusTypesNotInPopupWindow(strStatusTypeNames);
		
		objLogin2.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage2
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault2.selectFrame();
		
		objStatusTypeList2.navigateToStatusTypeList()
						  .selectInactiveStatusTypesCheckBox();
	
		for (int intCount = 0; intCount < strStatusTypeNames.length; intCount++) {
			objStatusTypeList2
					.reActivateStatusType(strStatusTypeNames[intCount]);
		}

		objStatusTypeList2.deSelectInactiveStatusTypesCheckBox();
		
		for (int intCount = 0; intCount < strStatusTypeNames.length; intCount++) {
			objStatusTypeList2
					.verifyStatusTypeInList(strStatusTypeNames[intCount]);
		}
		
		objMap1.clickOnRefreshLink();
		
		objMap1.selectResourceNameInFindResourceDropdown(
					objResource_data.strResourceName)
			   .verUpdateStatusInPopupWindow()
			   .verStatusTypesInPopupWindow(strStatusTypeNames);
		
		objLogin2.clickLogOut();
		
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/**********************************************************************************************************
	'Description : Verify that deactivated status types are no longer available on View resource detail screen.
	'Date        : 18-Feb-2016 
	'Author      : Anitha
	'----------------------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	***********************************************************************************************************/
	@Test(description = "Verify that deactivated status types are no longer available on View resource detail screen.")
	public void testHappyDay176739() throws Exception {

		gstrTCID = "176739";
		gstrTO = "Verify that deactivated status types are no longer available on View resource detail screen.";
		
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		View_data objView_data = new View_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		Resource objResource = new Resource(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		Map objMap1 = new Map(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(
				this.driver1);
		
		Login objLogin2 = new Login(this.driver2);
		RegionDefault objRegionDefault2 = new RegionDefault(this.driver2);
		SelectRegion objSelectRegionpage2 = new SelectRegion(this.driver2);
		StatusTypeList objStatusTypeList2 = new StatusTypeList(this.driver2);

		String strStatusTypeValues[] = new String[5];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
		
		objNavigationToSubmenus.navigateToViews();
		
		objViewsList.clickOncustomizeResourceDetailView()
				.enterSectionName(objView_data.strSectionName)
				.clickOnCreateSection().clickOnSaveButton();
		
		objStatusTypeList.navigateToStatusTypeListNew();

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.createStatusTypeWithSection(
						objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription,
						objView_data.strSectionName)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
				      objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
				      objStatusTypes_data.strStatusNameInMulti1)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);		
			
		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);	

		objResourceType.navigateToResourceTypePage();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

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

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName).selectFirstRole()
						.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickSaveButton();
		
		System.out.println(objUserdata.strNewUserName);

		objLogin.clickLogOut();

		System.out.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		String strStatusTypeNames[] = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName };

		objNavigationToSubMenus1.navigateToMap();
		
		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.clickOnViewInfoInPopupWindow()
				.verViewResDetailScreenIsDisplayedWithResName(
						objResource_data.strResourceName)
				.verStatusTypesUnderSection(strStatusTypeNames,
						objView_data.strSectionName);

		objLogin2.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage2
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault2.selectFrame();

		objStatusTypeList2.navigateToStatusTypeList();

		for (int intCount = 0; intCount < strStatusTypeNames.length; intCount++) {
			objStatusTypeList2
					.deActivateStatusType(strStatusTypeNames[intCount]);
		}
		
		objLinksAtTopRightCorners1.clickOnRefresh();
		
		Thread.sleep(5000);

		objMap1.verStatusTypesNotUnderSectionNew(strStatusTypeNames,
						objView_data.strSectionName);

		objLogin2.clickLogOut();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	
	/**********************************************************************************************************
	'Description :  Verify that reactivated status types are available on View resource detail screen.
	'Date        : 18-Feb-2016 
	'Author      : Anil
	'----------------------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	***********************************************************************************************************/
	@Test(description = " Verify that reactivated status types are available on View resource detail screen.")
	public void testHappyDay176742() throws Exception {

		gstrTCID = "176742";
		gstrTO = " Verify that reactivated status types are available on View resource detail screen.";
		
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		View_data objView_data = new View_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		Resource objResource = new Resource(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		Map objMap1 = new Map(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(
				this.driver1);

		String strStatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		
		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
		
		objNavigationToSubmenus.navigateToViews();
		
		objViewsList.clickOncustomizeResourceDetailView()
				.enterSectionName(objView_data.strSectionName)
				.clickOnCreateSection().clickOnSaveButton();
		
		objStatusTypeList.navigateToStatusTypeListNew();

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.createStatusTypeWithSection(
						objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription,
						objView_data.strSectionName)
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

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);		
			
		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);	

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName1);
		
		objResourceType.navigateToResourceTypePage();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

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

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName).selectFirstRole()
						.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickSaveButton();
		
		System.out.println(objUserdata.strNewUserName);

		String strStatusTypeNames[] = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName};
		
		objStatusTypeList.navigateToStatusTypeListNew();

		for (int intCount = 0; intCount < strStatusTypeNames.length; intCount++) {
			objStatusTypeList
					.deActivateStatusType(strStatusTypeNames[intCount]);
		}

		System.out.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToMap();
		
		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.clickOnViewInfoInPopupWindow()
				.verViewResDetailScreenIsDisplayedWithResName(
						objResource_data.strResourceName);
		
		Thread.sleep(5000);

		objMap1.verStatusTypesNotUnderSectionNew(strStatusTypeNames,
						objView_data.strSectionName);

		objStatusTypeList.selectInactiveStatusTypesCheckBox();
		
		for (int intCount = 0; intCount < strStatusTypeNames.length; intCount++) {
			objStatusTypeList
					.reActivateStatusType(strStatusTypeNames[intCount]);
		}
		
		objLinksAtTopRightCorners1.clickOnRefresh();
		
		objMap1.verStatusTypesUnderSection(strStatusTypeNames,
				objView_data.strSectionName);

		objLogin.clickLogOut();
		
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}	
	
	/*************************************************************************************
	 * 'Description 	: Verify that deactivated status types are no longer available on view screen.
	 * 'Date 			: 18-Mar-2016 
	 * 'Author 			: Sandhya
	 * '---------------------------------------------------------------
	 * 'Modified Date 			Modified By 
	 * 'Date Name
	 **************************************************************************************/
	@Test(description = "Verify that deactivated status types are no longer available on view screen.")
	public void testHappyDay176737() throws Exception {

		gstrTCID = "176737";
		gstrTO = " Verify that deactivated status types are no longer available on view screen.";

		Login_data objLogin_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();

		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList1 = new StatusTypeList(this.driver1);

		Login objLogin2 = new Login(this.driver2);
		RegionDefault objRegionDefault2 = new RegionDefault(this.driver2);
		StatusTypeList objStatusTypeList2 = new StatusTypeList(this.driver2);
		NavigationToSubMenus objNavigationToSubMenus2 = new NavigationToSubMenus(
				this.driver2);
		LinksAtTopRightCorners objLinksAtTopRightCorners2 = new LinksAtTopRightCorners(
				this.driver2);
		Views objViews2 = new Views(this.driver2);
		ViewsList objViewsList2 = new ViewsList(this.driver2);

		String strstatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strstatusesValues[] = new String[1];

		objLogin.loginToApplication(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd);

		objSelectRegion.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault.selectFrame();

		// Section creation

		objNavigationToSubMenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		// RoleBased status types creation

		objStatusTypeList.navigateToStatusTypeListNew();

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.createStatusTypeWithSection(
						objStatuTypes_data.strMultiStatusType,
						objStatuTypes_data.strMSTStatusTypeName,
						objStatuTypes_data.strStatusDescription,
						objView_data.strSectionName)
				.clickOnCreateNewStatus()
				.enterStatusName(objStatuTypes_data.strStatusNameInMulti)
				.clickOnSaveButton()
				.verCreatedStatusInStatusListForMulti(
						objStatuTypes_data.strStatusNameInMulti);

		strstatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
		      objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
		      objStatusTypes_data.strStatusNameInMulti1)
		.clickOnReturnToStatusTypeList();

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strDateStatusType,
				objStatuTypes_data.strDateStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strDateStatusTypeName);

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

		// Create User

		objNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickSaveButton();

		// Create views

		String[] strStatusTypeNames = {
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName };

		objNavigationToSubMenus.navigateToViews();

		objViewsList.createView(objView_data.strViewName,
				objView_data.strViewDesc, objResource_data.strResourceName,
				strStatusTypeNames);

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd);

		objSelectRegion1.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault1.selectFrame();

		objStatusTypeList1.navigateToStatusTypeList()
				.verifyStatusTypeListPage();

		for (int intCount = 0; intCount < strStatusTypeNames.length; intCount++) {
			objStatusTypeList1
					.verifyStatusTypeInList(strStatusTypeNames[intCount]);
		}
//doubt
		objLogin2.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault2.selectFrame();

		objNavigationToSubMenus2
				.clickOnViewMenu()
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		for (int i = 0; i < strStatusTypeNames.length; i++) {
			objViewsList2.verifyStatusTypeNameInView(strResourceTypeValue[0],
					strStatusTypeNames[i]);
		}
				
		for (int intCount = 0; intCount < strStatusTypeNames.length; intCount++) {
			objStatusTypeList1
					.deActivateStatusType(strStatusTypeNames[intCount]);
		}

		objLinksAtTopRightCorners2.clickOnRefresh();

		for (int intCount = 0; intCount < strStatusTypeNames.length; intCount++) {
			objStatusTypeList2
					.verifyStatusTypeIsNotListed(strStatusTypeNames[intCount]);
		}

		objViews2.vererrorMsgInViewPage();

		objLogin1.clickLogOut();

		objLogin2.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	 * 'Description 	: Verify that reactivated status types are available on view screen.
	 * 'Date 			: 21-Mar-2016 
	 * 'Author 			: Sandhya
	 * '---------------------------------------------------------------
	 * 'Modified Date 			Modified By 
	 * 'Date Name
	 **************************************************************************************/
	@Test(description = " Verify that reactivated status types are available on view screen.")
	public void testHappyDay176740() throws Exception {

		gstrTCID = "176740";
		gstrTO = " Verify that reactivated status types are available on view screen.";

		Login_data objLogin_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();

		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList1 = new StatusTypeList(this.driver1);
		Views objViews1 = new Views(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);

		Login objLogin2 = new Login(this.driver2);
		RegionDefault objRegionDefault2 = new RegionDefault(this.driver2);
		StatusTypeList objStatusTypeList2 = new StatusTypeList(this.driver2);
		SelectRegion objSelectRegion2 = new SelectRegion(this.driver2);

		String strstatusTypeValues[] = new String[7];
		String strstatusesValues[] = new String[1];

		objLogin.loginToApplication(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd);

		objSelectRegion.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegionDefault.selectFrame();

		// Section creation

		objNavigationToSubMenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		// RoleBased status types creation

		objStatusTypeList.navigateToStatusTypeListNew();

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.createStatusTypeWithSection(
						objStatuTypes_data.strMultiStatusType,
						objStatuTypes_data.strMSTStatusTypeName,
						objStatuTypes_data.strStatusDescription,
						objView_data.strSectionName)
				.clickOnCreateNewStatus()
				.enterStatusName(objStatuTypes_data.strStatusNameInMulti)
				.clickOnSaveButton()
				.verCreatedStatusInStatusListForMulti(
						objStatuTypes_data.strStatusNameInMulti);

		strstatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
		      objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
		      objStatusTypes_data.strStatusNameInMulti1)
		.clickOnReturnToStatusTypeList();

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strDateStatusType,
				objStatuTypes_data.strDateStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strDateStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[6] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName1);
		
		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		// Create User

		objNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickSaveButton();

		// Create views

		String[] strStatusTypeNames = {
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName1,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName };
		
		String[] strStatusTypeNames1 = {
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName };

		objNavigationToSubMenus.navigateToViews();

		objViewsList.createView(objView_data.strViewName,
				objView_data.strViewDesc, objResource_data.strResourceName,
				strStatusTypeNames);

		objStatusTypeList.navigateToStatusTypeListNew();

		for (int i = 0; i < strStatusTypeNames1.length; i++) {
			objStatusTypeList.deActivateStatusType(strStatusTypeNames1[i]);
		}

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		for (int i = 0; i < strStatusTypeNames1.length; i++) {
			objViews1.verStatusTypesNotDisplayed(objResourceType_data.strResourceTypeName, strStatusTypeNames1[i]);
		}
		
		objLogin2.loginToApplication(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd);

		objSelectRegion2.selectRegionAndNavigate(objLogin_data.strRegionName);
		
		objRegionDefault2.selectFrame();

		objStatusTypeList2.navigateToStatusTypeList()
				.verifyStatusTypeListPage();

		for (int i = 0; i < strStatusTypeNames1.length; i++) {
			objStatusTypeList2
					.verifyStatusTypeIsNotListed(strStatusTypeNames1[i]);
		}
		objStatusTypeList2.selectInactiveStatusTypesCheckBox();

		for (int intCount = 0; intCount < strStatusTypeNames1.length; intCount++) {
			objStatusTypeList2
					.verifyStatusTypeInList(strStatusTypeNames1[intCount]);
		}

		for (int i = 0; i < strStatusTypeNames1.length; i++) {
			objStatusTypeList2.verDisabledIsDisplayed(strStatusTypeNames1[i]);
		}

		for (int i = 0; i < strStatusTypeNames1.length; i++) {
			objStatusTypeList2.reActivateStatusType(strStatusTypeNames1[i]);
		}

		objStatusTypeList2.verifyStatusTypeListPage();

		for (int i = 0; i < strStatusTypeNames1.length; i++) {
			objStatusTypeList2.verActiveIsDisplayed(strStatusTypeNames1[i]);
		}

		objNavigationToSubMenus1
		.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		for (int intCount = 0; intCount < strStatusTypeNames1.length; intCount++) {
			/*objStatusTypeList1
					.verifyStatusTypeInList(strStatusTypeNames1[intCount]);*/
			objViews1.verStatusTypes(objResourceType_data.strResourceTypeName, strStatusTypeNames1[intCount]);
		}
		gstrResult = "PASS";
	}
}
