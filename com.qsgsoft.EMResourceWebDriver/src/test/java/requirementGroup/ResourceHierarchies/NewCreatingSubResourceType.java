package requirementGroup.ResourceHierarchies;

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

public class NewCreatingSubResourceType extends TestNG_UI_EXTENSIONS{

	public NewCreatingSubResourceType() throws Exception {
		super();
	}
	
	/***********************************************************************************************
	'Description : Verify that a sub-resource type can be created.
	'Precondition:
	'Date	 	 : 05-Aug-2015
	'Author		 : Sowmya
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*************************************************************************************************/
	@Test(description = "Verify that a sub-resource type can be created.")
	public void testHappyDay103913() throws Exception {

		gstrTCID = "103913";
		gstrTO = "Verify that a sub-resource type can be created.";

		Login_data objLogindata = new Login_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		ResourceType objResourceType1 = new ResourceType(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strSubResourceTypeValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault.selectFrame();

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// Create Role based status types
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);
		
		objLogin.clickLogOut();
		
		System.out.println("------------------Precondition ends--------------------");
		
		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();
		
		objRegionDefault1.verifyRegionDefaultPage();

		// create Sub-Resources
		String[] strStatusTypeValuesForRT = { strStatusTypeValues[0] };

		objResourceType1.navigateToResourceTypePageNew()
				.verResourceTypeListPageIsDisplayed()
				.verCreateNewResourceTypeButtonIsPresent()
				.clickOnCreateNewResourceTypeButton()
				.verCreateNewResourceTypePageIsDisplayed()
				.verResourceTypeNameInputField()
				.verResourceTypeDescriptionInputField()
				.verActiveCheckBoxIsChecked()
				.verSubResourceTypeCheckBox()
				.verStatusTypeField(strStatusTypeValues[0])
				.verDefaultStatusTypeDropdown()
				.verResourceTypeNameCheckboxIsChecked()
				.verContactNameCheckboxIsChecked()
				.verContactTitleCheckboxIsChecked()
				.verPhone1CheckboxIsChecked()
				.verPhone2CheckboxIsChecked()
				.verFaxCheckboxIsChecked()
				.verEmailCheckboxIsChecked();

		objResourceType1
				.enterResourceTypeName(
						objResourceType_data.strSubResourceTypeName)
				.selectSubResourceTypeCheckBox()
				.clickStatusType(strStatusTypeValuesForRT)
				.clickOnSaveButton();

		strSubResourceTypeValue[0] = objResourceType1
				.getResourceTypeValue(objResourceType_data.strSubResourceTypeName);

		objResourceType1.verResourceTypeListPageIsDisplayed()
				.selectIncludeInActiveCheckBox()
				.verActionHeader()
				.verNameHeader()
				.verSubResourceHeader()
				.verActiveHeader()
				.verDescriptionHeader();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

	/***********************************************************************************************
	'Description : Verify that a resource type can be edited to make it a sub resource type.
	'Precondition:
	'Date	 	 : 14-Aug-2015
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*************************************************************************************************/
	@Test(description = "Verify that a resource type can be edited to make it a sub resource type.")
	public void testHappyDay104004() throws Exception {

		gstrTCID = "104004";
		gstrTO = "Verify that a resource type can be edited to make it a sub resource type.";

		Login_data objLogindata = new Login_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType_Page = new ResourceType(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		ResourceType objResourceType_Page1 = new ResourceType(this.driver1);
		
		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		
		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault.selectFrame();

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// Create Role based status types
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);
		

		objNavigationToSubmenus.navigateToResourceInSetup();

		// Resource type creation
		objResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);
		
		objLogin.clickLogOut();
		
		System.out.println("------------------Precondition ends--------------------");
		
		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();
		
		objRegionDefault1.verifyRegionDefaultPage();

		objResourceType_Page1.navigateToResourceTypePageNew();
		
		objResourceType_Page1.verResourceTypeListPageIsDisplayed();
		
		objResourceType_Page1.verActionHeader();
		
		objResourceType_Page1.verifyEditLinkOfResourceType(objResourceType_data.strResourceTypeName);
		
		objResourceType_Page1.clickOnEditLinkOfResourceType(objResourceType_data.strResourceTypeName);
		
		objResourceType_Page1.verEditResourceTypeListPageIsDisplayed();
		
		objResourceType_Page1.verSubResourceTypeCheckBoxIsDeselected();
		
		objResourceType_Page1.verifyResourceTypeNameIsRetained(objResourceType_data.strResourceTypeName);
		
		objResourceType_Page1.verifyStatusTypeIsSelected(strStatusTypeValues);
		
		objResourceType_Page1.selectSubResourceTypeCheckBox();
		
		objResourceType_Page1.clickOnSaveButton();
		
		objResourceType_Page1.verSubResourceInList(objResourceType_data.strResourceTypeName, objResourceType_data.strSubResStatus);
			
		objResourceType_Page1.verResourceTypeListPageIsDisplayed();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

	/***********************************************************************************************
	'Description :  Verify that a sub resource type can be edited to make it a resource type.
	'Precondition:
	'Date	 	 : 14-Aug-2015
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*************************************************************************************************/
	@Test(description = " Verify that a sub resource type can be edited to make it a resource type.")
	public void testHappyDay104005() throws Exception {

		gstrTCID = "104005";
		gstrTO = " Verify that a sub resource type can be edited to make it a resource type.";

		Login_data objLogindata = new Login_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType_Page = new ResourceType(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		ResourceType objResourceType_Page1 = new ResourceType(this.driver1);
		
		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		
		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault.selectFrame();

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		// Create Role based status types
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);
		

		objNavigationToSubmenus.navigateToResourceInSetup();

		// Resource type creation
		objResourceType_Page.navigateToResourceTypePage()

		.createSubResourceType(objResourceType_data.strSubResourceTypeName,
				strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType_Page
				.getResourceTypeValue(objResourceType_data.strSubResourceTypeName);
		
		objLogin.clickLogOut();
		
		System.out.println("------------------Precondition ends--------------------");
		
		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();
		
		objRegionDefault1.verifyRegionDefaultPage();

		objResourceType_Page1.navigateToResourceTypePageNew();
		
		objResourceType_Page1.verResourceTypeListPageIsDisplayed();
		
		objResourceType_Page1.verActionHeader();
		
		objResourceType_Page1.verifyEditLinkOfResourceType(objResourceType_data.strSubResourceTypeName);
		
		objResourceType_Page1.clickOnEditLinkOfResourceType(objResourceType_data.strSubResourceTypeName);
		
		objResourceType_Page1.verEditResourceTypeListPageIsDisplayed();
		
		objResourceType_Page1.verSubResourceTypeCheckBoxIsSelected();
		
		objResourceType_Page1.verifyResourceTypeNameIsRetained(objResourceType_data.strSubResourceTypeName);
		
		objResourceType_Page1.verifyStatusTypeIsSelected(strStatusTypeValues);
		
		objResourceType_Page1.deselectSubResourceTypeCheckBox();
		
		objResourceType_Page1.clickOnSaveButton();
		
		objResourceType_Page1.verSubResourceInList(objResourceType_data.strSubResourceTypeName, objResourceType_data.strSubResNoStatus);
			
		objResourceType_Page1.verResourceTypeListPageIsDisplayed();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}


}