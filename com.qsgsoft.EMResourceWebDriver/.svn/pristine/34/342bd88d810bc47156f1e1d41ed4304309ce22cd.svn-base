package requirementGroup.SettingUpStatusTypes;

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

public class NewCreateNEDOCScoreStatusTypes extends TestNG_UI_EXTENSIONS{

	public NewCreateNEDOCScoreStatusTypes() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/*****************************************************************************
	 * 'Description : Verify that user can create NEDOC Score status type.
	 * 'Date        :15-Jun-2015
	 * 'Author      :Anil
	 *****************************************************************************/

	@Test(description = "Verify that user can create NEDOC Score status type.")
	public void testHappyDay119620() throws Exception {
		gstrTCID = "119620";
		gstrTO = "Verify that user can create NEDOC Score status type.";
	
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList1 = new StatusTypeList(this.driver1);
		ResourceType objResourceType1 = new ResourceType(this.driver1);	
		Resource objResource1 = new Resource(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		String strStatusTypeValues[] = new String[1];
		
		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
				
		//User
		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectSetupStatusTypesOption()
				.selectSetupResourceOption()
				.selectSetupResourceTypesOption()
				.selectEditResourcesOnlyOption()
				.clickSaveButton();
		
		System.out.println(objUserdata.strNewUserName);
		
		objLogin.clickLogOut();

		System.out.println("----------------Precodition execution ends---------");

		System.out.println("-----------------Test execution starts---------------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToStatusTypesInSetup();
		
		objStatusTypeList1.createStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription)
				.verifyStatusTypeInList(objStatusTypes_data.strNDSTStatusTypeName);

		strStatusTypeValues[0] = objStatusTypeList1
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);
		
		objNavigationToSubmenus1.navigateToResourceTypesInSetup();
		
		objResourceType1.clickOnCreateNewResourceTypeButton()
				.enterResourceTypeName(objResourceType_data.strResourceTypeName)
				.verifyStatusTypeIsListed(strStatusTypeValues)
				.clickStatusType(strStatusTypeValues)
				.clickOnSaveButton();
		
		objNavigationToSubmenus1.navigateToResourceInSetup();
		
		objResource1
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
				.enterStreetAddress(objResource_data.strStreetAddress)
				.selectState(objResource_data.strState)
				.enterCity(objResource_data.strCity)
				.enterzipCode(objResource_data.strZipcode)
				.selectCounty(objResource_data.strCounty)
				.clickOnLookupAddressBtn().verMap().clickOnSaveButton();

		objResource1.clickOnStatusTypeLinkInResourcePage(
				objResource_data.strResourceName)

		.verifyStatusTypeIsDisplayedUnderEditResLevelST(
				objStatusTypes_data.strNDSTStatusTypeName);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
}
