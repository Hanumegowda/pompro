package requirementGroup.SettingUpResourceTypes;

import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.StatusTypes_data;
import lib.module.NavigationToSubMenus;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import org.testng.annotations.Test;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewEdgeCaseEditResourceType extends TestNG_UI_EXTENSIONS {

	public NewEdgeCaseEditResourceType() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/*************************************************************************************
	 * 'Description 	: Cancel the process of editing 'Resource Type' and verify that 
	 * 						details are not updated.
	 * 'Precondition	: 
	 * 'Date 			: 15-Feb-2016 
	 * 'Author 			: Pallavi
	 * '---------------------------------------------------------------
	 * 'Modified Date 			Modified By 
	 * 'Date Name
	 **************************************************************************************/
	@Test(description = "Cancel the process of editing 'Resource Type' and verify that details are not updated.")
	public void testEdgeCase108082() throws Exception {

		gstrTCID = "108082";
		gstrTO = "Cancel the process of editing 'Resource Type' and verify that details are not updated.";

		Login_data objLogindata = new Login_data();
		ResourceType_data objResourceType_data = new ResourceType_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ResourceType objResourceType1 = new ResourceType(this.driver1);

		String strResourceTypeValue[] = new String[1];
		String strSelectedStatusTypeValues[] = new String[1];
		String strUnSelectedStatusTypeValues[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strSelectedStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);
		
		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strUnSelectedStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);
		
		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strSelectedStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);
		
		objLogin.clickLogOut();
		
		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);
		
		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToResourceTypesInSetup();
		
		objResourceType1
				.clickOnEditLinkOfResourceType(
						objResourceType_data.strResourceTypeName)
				.verEditResourceTypeListPageIsDisplayed()
				.verifyResourceTypeNameIsRetained(
						objResourceType_data.strResourceTypeName)
				.verifyStatusTypeIsSelected(strSelectedStatusTypeValues)
				.verifyStatusTypeIsNotSelected(strUnSelectedStatusTypeValues)
				.enterResourceTypeName(
						objResourceType_data.strEdResourceTypeName)
				.deselectStatusType(strSelectedStatusTypeValues)
				.clickStatusTypeNew(strUnSelectedStatusTypeValues)
				.clickOnCancelButton()
				.verRTIsNotDisplayed(
						objResourceType_data.strEdResourceTypeName)
				.verResourceTypeInList(
						objResourceType_data.strResourceTypeName)
				.clickOnEditLinkOfResourceType(
						objResourceType_data.strResourceTypeName)
				.verEditResourceTypeListPageIsDisplayed()
				.verifyResourceTypeNameIsRetained(
						objResourceType_data.strResourceTypeName)
				.verifyStatusTypeIsSelected(strSelectedStatusTypeValues)
				.verifyStatusTypeIsNotSelected(strUnSelectedStatusTypeValues);
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	 * 'Description 	: Verify that resource type can be edited and saved by editing all the fields.
	 * 'Precondition	: 
	 * 'Date 			: 15-Feb-2016 
	 * 'Author 			: Pallavi
	 * '---------------------------------------------------------------
	 * 'Modified Date 			Modified By 
	 * 'Date Name
	 **************************************************************************************/
	@Test(description = "Verify that resource type can be edited and saved by editing all the fields.")
	public void testEdgeCase108081() throws Exception {

		gstrTCID = "108081";
		gstrTO = "Verify that resource type can be edited and saved by editing all the fields.";

		Login_data objLogindata = new Login_data();
		ResourceType_data objResourceType_data = new ResourceType_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ResourceType objResourceType1 = new ResourceType(this.driver1);

		String strResourceTypeValue[] = new String[1];
		String strSelectedStatusTypeValues[] = new String[1];
		String strUnSelectedStatusTypeValues[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strSelectedStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);
		
		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strUnSelectedStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);
		
		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strSelectedStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);
		
		System.out.println(objResourceType_data.strResourceTypeName);
		
		objLogin.clickLogOut();
		
		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);
		
		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToResourceTypesInSetup();
		
		objResourceType1
				.clickOnEditLinkOfResourceType(
						objResourceType_data.strResourceTypeName)
				.verEditResourceTypeListPageIsDisplayed()
				.verifyResourceTypeNameIsRetained(
						objResourceType_data.strResourceTypeName)
				.verifyStatusTypeIsSelected(strSelectedStatusTypeValues)
				.verifyStatusTypeIsNotSelected(strUnSelectedStatusTypeValues)
				.enterResourceTypeName(
						objResourceType_data.strEdResourceTypeName)
				.verResourceTypeNameCheckboxIsChecked()
				.verContactNameCheckboxIsChecked()
				.verContactTitleCheckboxIsChecked()
				.verPhone1CheckboxIsChecked()
				.verPhone2CheckboxIsChecked()
				.verFaxCheckboxIsChecked()
				.verEmailCheckboxIsChecked()
				.enterResourceTypeDescription(
						objResourceType_data.strEdResTypeDescription)
				.deselectStatusType(strSelectedStatusTypeValues)
				.clickStatusTypeNew(strUnSelectedStatusTypeValues)
				.clickOnSaveButton()
				.verResourceTypeInList(
						objResourceType_data.strEdResourceTypeName)
				.verRTIsNotDisplayed(
						objResourceType_data.strResourceTypeName)
				.clickOnEditLinkOfResourceType(
						objResourceType_data.strEdResourceTypeName)
				.verEditResourceTypeListPageIsDisplayed()
				.verifyResourceTypeNameIsRetained(
						objResourceType_data.strEdResourceTypeName)
				.verResourceTypeNameCheckboxIsChecked()
				.verContactNameCheckboxIsChecked()
				.verContactTitleCheckboxIsChecked()
				.verPhone1CheckboxIsChecked()
				.verPhone2CheckboxIsChecked()
				.verFaxCheckboxIsChecked()
				.verEmailCheckboxIsChecked()
				.verifyStatusTypeIsSelected(strUnSelectedStatusTypeValues)
				.verifyStatusTypeIsNotSelected(strSelectedStatusTypeValues);
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
	

	/*************************************************************************************
	 * 'Description 	: Verify that when a resource type is opened for editing all the previously saved values are retained.
	 * 'Precondition	: 
	 * 'Date 			: 15-Feb-2016 
	 * 'Author 			: Pallavi
	 * '---------------------------------------------------------------
	 * 'Modified Date 			Modified By 
	 * 'Date Name
	 **************************************************************************************/
	@Test(description = " Verify that when a resource type is opened for editing all the previously saved values are retained.")
	public void testEdgeCase108080() throws Exception {

		gstrTCID = "108080";
		gstrTO = " Verify that when a resource type is opened for editing all the previously saved values are retained.";

		Login_data objLogindata = new Login_data();
		ResourceType_data objResourceType_data = new ResourceType_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ResourceType objResourceType1 = new ResourceType(this.driver1);

		String strResourceTypeValue[] = new String[1];
		String strSelectedStatusTypeValues[] = new String[1];
		String strUnSelectedStatusTypeValues[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strSelectedStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);
		
		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strUnSelectedStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);
		
		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strSelectedStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);
		
		objLogin.clickLogOut();
		
		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);
		
		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.navigateToResourceTypesInSetup();
		
		objResourceType1
				.clickOnEditLinkOfResourceType(
						objResourceType_data.strResourceTypeName)
				.verEditResourceTypeListPageIsDisplayed()
				.verifyResourceTypeNameIsRetained(
						objResourceType_data.strResourceTypeName)
				.verifyStatusTypeIsSelected(strSelectedStatusTypeValues)
				.verifyStatusTypeIsNotSelected(strUnSelectedStatusTypeValues)
				.enterResourceTypeName(
						objResourceType_data.strEdResourceTypeName)
				.deselectStatusType(strSelectedStatusTypeValues)
				.clickStatusTypeNew(strUnSelectedStatusTypeValues)
				.clickOnSaveButton()
				
				.verResourceTypeInList(
						objResourceType_data.strEdResourceTypeName)
				.clickOnEditLinkOfResourceType(
						objResourceType_data.strEdResourceTypeName)
				.verEditResourceTypeListPageIsDisplayed()
				.verifyResourceTypeNameIsRetained(
						objResourceType_data.strEdResourceTypeName)
				.verifyStatusTypeIsSelected(strUnSelectedStatusTypeValues)
				.verifyStatusTypeIsNotSelected(strSelectedStatusTypeValues);
		
		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
}
