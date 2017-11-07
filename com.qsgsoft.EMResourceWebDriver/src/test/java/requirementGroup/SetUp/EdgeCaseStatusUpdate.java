package requirementGroup.SetUp;

import org.testng.annotations.Test;

import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
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
import lib.page.ViewsList;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class EdgeCaseStatusUpdate extends TestNG_UI_EXTENSIONS {

	public EdgeCaseStatusUpdate() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/***********************************************************************************
	 * 'Description 	: Verify that 'Any date should be accepted' option is selected by default under 'Valid values for this status type' section while creating 'Date' status type. 
	 * 'Precondition	: None
	 * 'Date 	        : 30-Oct-2014 
	 * 'Author 			: sangappa.k
	 ************************************************************************************/
	@Test(description = "Verify that 'Any date should be accepted' option is selected by default under 'Valid values for this status type' section while creating 'Date' status type.")
	public void testEdgeCase146887() throws Exception {
		
		gstrTCID = "146887";
		gstrTO = " Verify that 'Any date should be accepted' option is selected by default under 'Valid values for this status type' section while creating 'Date' status type.";
	
		Login login_page = new Login(this.driver1);
		Login_data login_data = new Login_data();
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		RegionDefault RegionDefault_Page1 = new RegionDefault(this.driver1);
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();

		login_page.loginToApplication(login_data.strUserName,
				login_data.strPassword);
		
		RegionDefault_Page1.selectFrame();

		SelectRegion_page.selectRegionAndNavigate(login_data.strRegionName);

		RegionDefault_Page1.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.clickCreateNewStatusTypeButton();

		objStatusTypeList
				.selectStatusType(objStatuTypes_data.strDateStatusType);
		
		objStatusTypeList.clickNextButton();

		objStatusTypeList.verifyAnyDateShouldAcceptedIsSelected();

		login_page.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/***********************************************************************************
	 * 'Description 	: Verify that appropriate validation message is displayed when date status type created selecting 'Date range between 'X' and 'Y' is updated with other value. 
	 * 'Precondition	: None
	 * 'Date 	        : 07-Nov-2014 
	 * 'Author 			: Renushree
	 ************************************************************************************/
	@Test(description = "Verify that appropriate validation message is displayed when date status type created selecting 'Date range between 'X' and 'Y' is updated with other value.")
	public void testEdgeCase146888() throws Exception {

		gstrTCID = "146888";
		gstrTO = "Verify that appropriate validation message is displayed when date status type created selecting 'Date range between 'X' and 'Y' is updated with other value.";

		Login objLogin = new Login(this.driver1);
		Login_data login_data = new Login_data();
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		RegionDefault RegionDefault_Page = new RegionDefault(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);
		Map objMap1 = new Map(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);

		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		User_data objUser_data = new User_data();
		View_data objView_data = new View_data();

		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(login_data.strUserName,
				login_data.strPassword);

		RegionDefault_Page.selectFrame();

		SelectRegion_page.selectRegionAndNavigate(login_data.strRegionName);

		RegionDefault_Page.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatuTypes_data.strDateStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatuTypes_data.strDateStatusTypeName)
				.enterStatusTypeDescription(
						objStatuTypes_data.strStatusDescription)
				.selectDateRange(objStatuTypes_data.strDateFromRange,
						objStatuTypes_data.strDateToRange).clickOnSaveButton();

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strDateStatusTypeName);

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

		// User creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickSaveButton();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubMenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		objUpdateStatus1
				.selectStatusTypes(strStatusTypeValues[0])
				.enterNSTAndTSTUpdateValue(strStatusTypeValues[0],
						objView_data.strDateUpdateFutureValue)
				.clickOnSaveButton()
				.verErrorIfDateIsOutOfGivenRange(
						objStatuTypes_data.strDateFromRange,
						objStatuTypes_data.strDateToRange,
						objStatuTypes_data.strDateStatusTypeName);

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/***********************************************************************************************
	 * 'Description :  Verify that appropriate validation message is displayed when date status type created selecting 'Past dates only 
	 *                 (excluding today)'is updated with other value. 
	 * 'Date		: 4-Dec-2014 
	 * 'Author 		: sangappa.k
	 ************************************************************************************************/

	@Test(description = " Verify that appropriate validation message is displayed when date status type "
			        + "created selecting Past dates only (excluding today)is updated with other value")
	public void testEdgeCase146892() throws Exception {

		gstrTCID = "146892";
		gstrTO = " Verify that user can update the status values after clicking on 'Stay on Page' "
				+ " on 'Save changes' prompt";

		Login_data login_data = new Login_data();
		Login login_page1 = new Login(this.driver1);// ie
		Login login_page2 = new Login(this.driver1);// fire

		// objects
		RegionDefault objRegionDefault_page1 = new RegionDefault(this.driver1);
		RegionDefault objRegionDefault_page2 = new RegionDefault(this.driver1);

		SelectRegion objSelectRegion_page1 = new SelectRegion(this.driver1);

		StatusTypeList objStatusTypeList1_page1 = new StatusTypeList(driver);
		ResourceType objResourceType_page1 = new ResourceType(driver);
		Resource objResource_page1 = new Resource(driver);
		UsersList objUsersList_page1 = new UsersList(driver);

		NavigationToSubMenus objNavigationToSubMenus_page2 = new NavigationToSubMenus(
				driver1);

		ViewsList objviewsList_page1 = new ViewsList(driver);
		ViewsList objviewsList_page2 = new ViewsList(driver1);
		UpdateStatus objUpdateStatus_page2 = new UpdateStatus(driver1);
		// data

		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		User_data objUser_data = new User_data();

		String strStatusTypeValues1[] = new String[1];

		login_page1.loginToApplication(login_data.strUserName,
				login_data.strPassword);

		objSelectRegion_page1.selectRegionAndNavigate(login_data.strRegionName);

		objRegionDefault_page1.selectFrame();

		objStatusTypeList1_page1.navigateToStatusTypeList();

		// date
		objStatusTypeList1_page1.clickCreateNewStatusTypeButton()
	                          .selectStatusType(objStatusTypes_data.strDateStatusType)
	                          .clickNextButton()
	                          .enterStatusTypeName(objStatusTypes_data.strDateStatusTypeName1)
	                          .enterStatusTypeDescription(objStatusTypes_data.strStatusDescription)
	                          .clickOnPastDateOnlyRadioButton()
	                          .clickOnSaveButton();
		
		strStatusTypeValues1[0] = objStatusTypeList1_page1
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName1);
		
		// resource Type
		objResourceType_page1.navigateToResourceTypePage();

		objResourceType_page1.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues1);

		// resource
		objResource_page1.navigateToResourceListPage().createResource(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation1,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		// view creation
		objviewsList_page1.navigateToViewsList().createView(
				objView_data.strViewName2, objView_data.strViewDesc,
				objResource_data.strResourceName,
				objStatusTypes_data.strDateStatusTypeName1);

		// User creation
		objUsersList_page1
				.navigateToUsersNew()
				.clickCreateNewUserButton()

				.enterUserDetails(objUser_data.strNewUserName2,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectFirstRole().clickSaveButton();

		login_page1.clickLogOut();

		// login with new user
		login_page2.loginAsNewUser(objUser_data.strNewUserName2,
				objUser_data.strNewPassword);

		objRegionDefault_page2.selectFrame();

		objNavigationToSubMenus_page2
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName2);
		objviewsList_page2
				.clickOnUpdateStatus(objResource_data.strResourceName);

		// future date
		objUpdateStatus_page2.enterNSTAndTSTUpdateValue(
				strStatusTypeValues1[0], objView_data.strDateUpdateFutureValue)

		.clickOnSaveButton();
		// ver validation text
		
		objUpdateStatus_page2
				.verErrorTextForPastDate(objStatusTypes_data.strDateStatusTypeName1);

		// current date
		objUpdateStatus_page2.enterNSTAndTSTUpdateValue(
				strStatusTypeValues1[0], objView_data.strDateUpdateValue);

		objUpdateStatus_page2.clickOnSaveButton();

		// ver validation text

		objUpdateStatus_page2
				.verErrorTextForPastDate(objStatusTypes_data.strDateStatusTypeName1);
		// past date
		objUpdateStatus_page2.enterNSTAndTSTUpdateValue(
				strStatusTypeValues1[0], objView_data.strDateUpdatePastValue);

		objUpdateStatus_page2.clickOnSaveButton();

		login_page2.clickLogOut();
		
		gstrResult = "PASS";
	}
}
