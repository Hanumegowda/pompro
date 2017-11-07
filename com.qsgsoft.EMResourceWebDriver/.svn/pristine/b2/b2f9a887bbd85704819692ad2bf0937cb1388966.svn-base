package requirementGroup.SetUp;

import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.module.NavigationToSubMenus;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import org.testng.annotations.Test;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class HappyDaySettingUpOfResources extends TestNG_UI_EXTENSIONS{

	public HappyDaySettingUpOfResources() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/********************************************************************************************************************************
	 *  Description : Verify that Status Type is retrieved when searched providing its name in Edit Resource-Level Status Types page.
	 *  Date        : 31-Dec-2014 
	 *  Author      : Anitha
	 ********************************************************************************************************************************/
	@Test(description = "Verify that Status Type is retrieved when searched providing its name in Edit Resource-Level Status Types page.")
	public void testHappyDay151412() throws Exception {

		gstrTCID = "151412";
		gstrTO = "Verify that Status Type is retrieved when searched providing its name in Edit Resource-Level Status Types page.";

		Login_data objTest_data = new Login_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		ResourceType objResourceType1=new ResourceType(this.driver1);

		String strStatusTypeValue1[] = new String[1];
		String strStatusTypeValue2[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		System.out
				.println("-----Precondition ends and test execution starts-------");

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValue1[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValue2[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValue1);

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

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

        objRegionDefault1.selectFrame();
		
		objSelectRegionpage1
				.selectRegionAndNavigate(objTest_data.strRegionName);
		
		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToResourceInSetup();

		objResource1
				.clickOnStatusTypeLinkInResourcePage(
						objResource_data.strResourceName)

				.verifySearchfieldsForStatusType()

				.verifySearchAndShowAllButtons()

				.enterStatusTypeName(objStatusTypes_data.strTSTStatusTypeName);

		objResourceType1.clickOnSearchButton()

		.verifyStatusTypeIsRetrieved(objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strTextStatusType);

		objResource1.selectStatusType(strStatusTypeValue2)

		.clickOnSaveButton();
		
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

}
