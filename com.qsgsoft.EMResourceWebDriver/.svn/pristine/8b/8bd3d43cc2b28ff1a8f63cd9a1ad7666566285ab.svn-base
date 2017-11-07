package requirementGroup.MultiRegion;

import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.CustomUnderView;
import lib.page.Login;
import lib.page.Map;
import lib.page.RegionDefault;
import lib.page.Regions;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UsersList;
import lib.page.ViewsList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewDirectAccessToMultipleRegions extends TestNG_UI_EXTENSIONS{

	public NewDirectAccessToMultipleRegions() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/**********************************************************************************
	 * 'Description : Verify that the resource of RG1 cannot be edited from RG2 when the user has access to both RG1 and RG2.
	 * 'Date        :15-Jun-2015
	 * 'Author      :Anil
	 **********************************************************************************/

	@Test(description = " Verify that the resource of RG1 cannot be edited from RG2 when the user has access to both RG1 and RG2.")
	public void testHappyDay84668() throws Exception {
		gstrTCID = "84668";
		gstrTO = " Verify that the resource of RG1 cannot be edited from RG2 when the user has access to both RG1 and RG2.";

		// Objects for data
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		
		// Objects for Page
		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		Regions objRegions_page = new Regions(this.driver1);
		
		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus_page1 = new NavigationToSubMenus(this.driver1);
		CustomUnderView ObjCustomUnderView1 = new CustomUnderView(this.driver1);
		Map objMap1 = new Map(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		
		String strstatusesValues[] = new String[1];
		String strstatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strRegionValue[] = new String[2];
		
		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions_page
				.getRegionValue(objTest_data.strRegionName);

		System.out.println(strRegionValue[0]);

		strRegionValue[1] = objRegions_page
				.getRegionValue(objTest_data.strRegionName1);

		System.out.println(strRegionValue[1]);
		
		StatusTypeList_page
				.navigateToStatusTypeListNew()
				.createSharedStatusType(objStatuTypes_data.strMultiStatusType, objStatuTypes_data.strMSTStatusTypeName, objStatuTypes_data.strStatusDescription)
				
				.createNewStatus(objStatuTypes_data.strStatusNameInMulti,
						objStatuTypes_data.strStatusColor)
						.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameInMulti);
	
						
		strstatusesValues[0] = StatusTypeList_page
			.getStatusesValue(objStatuTypes_data.strStatusNameInMulti);

	StatusTypeList_page.createNewStatus(objStatuTypes_data.strStatusNameInMulti1,objStatuTypes_data.strStatusColor)
	.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameInMulti1)
	.clickOnReturnToStatusTypeList();

	strstatusTypeValues[0] = StatusTypeList_page
			.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

	// Resource type creation
	ResourceType_Page.navigateToResourceTypePage();

	ResourceType_Page.createResourceType(
			objResourceType_data.strResourceTypeName, strstatusTypeValues);

	strResourceTypeValue[0] = ResourceType_Page.getResourceTypeValue(objResourceType_data.strResourceTypeName);
	
	// Resource creation
	Resource_Page.navigateToResourceListPage();

	Resource_Page.createSharedResourceWithAddress(objResource_data.strResourceName,
			objResource_data.strResourceAbbrivation,
			objResourceType_data.strResourceTypeName,
			objResource_data.strStandardResourceTypename,
			objResource_data.strResourceFirstName,
			objResource_data.strResourceLastName,
			objResource_data.strStreetAddress,
			objResource_data.strCity, objResource_data.strState,
			objResource_data.strCounty, objResource_data.strZipcode);

	strResourceValue[0] = Resource_Page
			.getResourceValue(objResource_data.strResourceName);

	
		// User creation
		UsersList_page.navigateToUsersNew();

		System.out.println(objUser_data.strNewUserName);

		UsersList_page
				.clickCreateNewUserButton()

				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)

				.selectFirstRole()

				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				
				.clickAdvancedOptionAndExpand()

				.selectSetupResourceOption()

				.clickSaveButton()
				
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.clickRegionsLinkForUser(objUser_data.strNewUserName)
				.selectRegion(strRegionValue[1]).clickSaveButton();

		login_page.clickLogOut();
		
		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName1);

		RegionDefault_page.selectFrame();

		// User creation
		UsersList_page.navigateToUsers();

		System.out.println(objUser_data.strNewUserName);

		UsersList_page.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
						
				.editUserDetails(objUser_data.strNewUserName)
				.selectFirstRole()
				
				.clickAdvancedOptionAndExpand()

				.selectSetupResourceOption()

				.selectViewcustomViewOption()
				
				.clickSaveButton();
		
		login_page.clickLogOut();
		
		System.out.println("----------------Precodition execution ends---------");

		System.out.println("-----------------Test execution starts---------------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		SelectRegion_page1.selectRegionAndNavigate(objTest_data.strRegionName1);

		RegionDefault_page1.selectFrame();

		objNavigationToSubmenus_page1.navigateToCustomizedViewInPrefrences();
		
		String[] strResource = {objResource_data.strResourceName};
		String[] strStatusTypes = {objStatuTypes_data.strMSTStatusTypeName};
		
		ObjCustomUnderView1.verEditCustomViewScreenIsDisplayed()
						  .clickOnAddMoreResources()
						  .enterResNameInWhatField(objResource_data.strResourceName)
						  .clickOnSearch().selectResource(strResourceValue)
						  .clickOnAddToCustomView().clickOnOptions()
						  .selectStatusTypes(strstatusTypeValues)
						  .clickOnSave()
						  .verResourceAndResTypeInCustomViewTablePage(strResource, objResourceType_data.strResourceTypeName);
		objViewsList1.verifyUpdateStatusKeyIsNotDisplayed(objResource_data.strResourceName);
		ObjCustomUnderView1.verStatusTypeInCustomViewTablePage(strStatusTypes)
						  .clickOnCustomeViewMap()
						  .verCustomViewMapScreenIsDisplayed()
						  .selectResourceName(objResource_data.strResourceName);
		objMap1.verfyEditInfoLinkNotPresent()
		.clickOnViewInfoInPopupWindow();
		
		objViewsList1.verifyEditResourceDetailsLinkIsNotPresent();

		login_page1.clickLogOut();

		gstrResult = "PASS";
	}
}
