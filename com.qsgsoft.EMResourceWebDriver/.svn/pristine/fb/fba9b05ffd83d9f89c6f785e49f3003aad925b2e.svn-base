package requirementGroup.SetUp;

import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UsersList;
import org.testng.annotations.Test;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class HappyDayEditStatusType extends TestNG_UI_EXTENSIONS{

	public HappyDayEditStatusType() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/**********************************************************************************
	 * 'Description :Verify that user can create Date status type.
	 * 'Date        :30-Sep-2014 
	 * 'Author      :Anitha
	 **********************************************************************************/

	@Test(description = "Verify that user can edit Date status type.")
	public void testHappyDay145761() throws Exception {
		gstrTCID = "145761";
		gstrTO = "Verify that user can edit Date status type.";

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

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus_page1 = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList StatusTypeList_page1 = new StatusTypeList(this.driver1);
		ResourceType ResourceType_page1 = new ResourceType(this.driver1);
		Resource Resource_page1 = new Resource(this.driver1);

		String strStatusTypeValues[] = new String[1];

		System.out
				.println("-----------------Precodition execution starts---------------");

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();

		// User creation
		UsersList_page.navigateToUsers();

		System.out.println(objUser_data.strNewUserName);

		UsersList_page
				.clickCreateNewUserButton()

				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)

				.selectFirstRole()

				.clickAdvancedOptionAndExpand()

				.selectSetupStatusTypesOption()

				.selectSetupResourceTypesOption()

				.selectSetupResourceOption()

				.clickSaveButton();

		login_page.clickLogOut();

		System.out.println("-----------------Precodition execution ends--------");

		System.out.println("-----------------Test execution ends---------------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		objNavigationToSubmenus_page1.navigateToStatusTypesInSetup();

		StatusTypeList_page1.createDateStatusType(
				objStatuTypes_data.strDateStatusType,
				objStatuTypes_data.strDateStatusTypeName,
				objStatuTypes_data.strStatusDescription);
	
		StatusTypeList_page1.clickOnEditOfStatusType(objStatuTypes_data.strDateStatusTypeName)
		
		.enterStatusTypeName(objStatuTypes_data.strDateStatusTypeName1)
		
		.clickOnSaveButton();
		
		strStatusTypeValues[0] = StatusTypeList_page1
				.getStatusValue(objStatuTypes_data.strDateStatusTypeName1);
		
		objNavigationToSubmenus_page1.navigateToResourceTypesInSetup();

		ResourceType_page1.clickOnCreateNewResourceTypeButton()

		.enterResourceTypeName(objResourceType_data.strResourceTypeName)
		
		.clickStatusTypeNew(strStatusTypeValues)

		.verifyStatusTypeNameIsListed(objStatuTypes_data.strDateStatusTypeName1)		

		.clickOnSaveButton();

		// Resource creation
		Resource_page1
				.navigateToResourceListPage()

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

				.clickOnSaveButton()

				.clickOnStatusTypeLinkInResourcePage(
						objResource_data.strResourceName)
						
				.verifyStatusTypeNameIsListedInEditResLevelPage(objStatuTypes_data.strDateStatusTypeName1);

		gstrResult = "PASS";
	}
	
}
