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

public class HappyDaySettingUpResourceTypes extends TestNG_UI_EXTENSIONS {

	public HappyDaySettingUpResourceTypes() throws Exception {
		super();
	}
	
	/********************************************************************************************************************************
	 *  Description : Verify that Status Type is retrieved when searched providing its name in create/edit Resource Type page.
	 *  Date        : 31-Dec-2014 
	 *  Author      : Pallavi
	 ********************************************************************************************************************************/
	@Test(description = "Verify that Status Type is retrieved when searched providing its name in create/edit Resource Type page.")
	public void testHappyDay151406() throws Exception {

		gstrTCID = "151406";
		gstrTO = "Verify that Status Type is retrieved when searched providing its name in create/edit Resource Type page.";

		Login_data objTest_data = new Login_data();
		ResourceType_data objResourceType_data = new ResourceType_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		ResourceType objResourceType1 = new ResourceType(this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);

		String strStatusTypeValues[] = new String[1],
				strStatusTypeValues1[] = new String[1],
				strResourceTypeValue[] = new String[1];

		System.out
				.println("-----Precondition starts-------");

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();

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

		strStatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);
		
		System.out.println(objStatusTypes_data.strTSTStatusTypeName);
		System.out.println(objStatusTypes_data.strNSTStatusTypeName);
		
		login_page.clickLogOut();
		
		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);
		
		objRegionDefault1.selectFrame();

		SelectRegion_page1.selectRegionAndNavigate(objTest_data.strRegionName);
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToResourceTypesInSetup();
		
		objResourceType1.clickOnCreateNewResourceTypeButton()
					   .enterResourceTypeName(objResourceType_data.strResourceTypeName);
		
		objResource1.verifySearchfieldsForStatusType()
					.verifySearchAndShowAllButtons()
					.enterStatusTypeName(objStatusTypes_data.strNSTStatusTypeName);
		
		objResourceType1.clickOnSearchButton()
						.verifyStatusTypeIsRetrieved(objStatusTypes_data.strNSTStatusTypeName,
													objStatusTypes_data.strNumberStatusType)
						.clickStatusType(strStatusTypeValues)
						.clickOnSaveButton();

		strResourceTypeValue[0] = objResourceType1
									.getResourceTypeValue(objResourceType_data.strResourceTypeName);
		
		objResourceType1.clickOnEditLinkOfResourceType(objResourceType_data.strResourceTypeName);
		
		objResource1.verifySearchfieldsForStatusType()
					.verifySearchAndShowAllButtons()
					.enterStatusTypeName(objStatusTypes_data.strTSTStatusTypeName);
		
		objResourceType1.clickOnSearchButton()
						.verifyStatusTypeIsRetrieved(objStatusTypes_data.strTSTStatusTypeName,
								objStatusTypes_data.strTextStatusType)
						.clickStatusType(strStatusTypeValues1)
						.clickOnSaveButton();
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
}
