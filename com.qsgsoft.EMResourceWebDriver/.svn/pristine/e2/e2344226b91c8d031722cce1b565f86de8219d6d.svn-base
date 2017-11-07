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

public class EdgeCaseCreateResourceType extends TestNG_UI_EXTENSIONS {

	public EdgeCaseCreateResourceType() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	

	/*************************************************************************************
	'Description : Verify that process of creating a Resource Type can be cancelled.
	'Precondition:
	'Date	 	 : 15-Feb-2016
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that process of creating a Resource Type can be cancelled.")
	public void testEdgeCase108076() throws Exception {

		gstrTCID = "108076";
		gstrTO = "Verify that process of creating a Resource Type can be cancelled.";

		Login_data objLogindata = new Login_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();

		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList1 = new StatusTypeList(this.driver1);
		ResourceType objResourceType_Page1 = new ResourceType(this.driver1);

		String strStatusTypeValues[] = new String[1];

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToStatusTypesInSetup();

		objStatusTypeList1.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList1
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		// Resource type creation
		objNavigationToSubmenus1.navigateToResourceTypesInSetup();

		objResourceType_Page1.clickOnCreateNewResourceTypeButton()
							.verCreateNewResourceTypePageIsDisplayed()
							.enterResourceTypeName(objResourceType_data.strResourceTypeName)
							.clickStatusType(strStatusTypeValues)
							.clickOnCancelButton()
							.verResourceTypeListPageIsDisplayed()
							.verResourceTypeNotInList(objResourceType_data.strResourceTypeName);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Verify that an active resource type cannot be created without selecting any status type. 
	'Precondition:
	'Date	 	 : 15-Feb-2016
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that an active resource type cannot be created without selecting any status type. ")
	public void testEdgeCase108074() throws Exception {

		gstrTCID = "108074";
		gstrTO = "Verify that an active resource type cannot be created without selecting any status type. ";

		Login_data objLogindata = new Login_data();
		ResourceType_data objResourceType_data = new ResourceType_data();

		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ResourceType objResourceType_Page1 = new ResourceType(this.driver1);

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		// Resource type creation
		objNavigationToSubmenus1.navigateToResourceTypesInSetup();

		objResourceType_Page1
				.clickOnCreateNewResourceTypeButton()
				.enterResourceTypeName(objResourceType_data.strResourceTypeName)
				.clickOnSaveButton().verErrWhenRTCreatedWithoutST();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

	
	/*************************************************************************************
	'Description : Verify that a resource type with more than one multi status types with same standard status type cannot be created.
	'Precondition:
	'Date	 	 : 1-Mar-2016
	'Author		 : Sangappa K
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description ="Verify that a resource type with more than one multi status types with same standard status type cannot be created.")
	public void testEdgeCase108077() throws Exception {

		gstrTCID ="108077";
		gstrTO = "Verify that a resource type with more than one multi status types with same standard status type cannot be created.";

		Login_data objLogindata = new Login_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType_Page = new ResourceType(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);

		ResourceType objResourceType_Page1 = new ResourceType(this.driver1);

		String strStatusTypeValues[] = new String[2];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);
		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatusTypes_data.strMultiStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strMSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription)
				.selectStandardStatusTypename(
						objStatusTypes_data.strStandardStatusTypename4)
				.clickOnSaveButton()

				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)

				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
						objStatusTypes_data.strStatusColor);

		objStatusTypeList.clickOnReturnToStatusTypeList();
		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatusTypes_data.strMultiStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strMSTStatusTypeName1)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription)
				.selectStandardStatusTypename(
						objStatusTypes_data.strStandardStatusTypename4)
				.clickOnSaveButton()

				.createNewStatus(objStatusTypes_data.strStatusNameInMulti2,
						objStatusTypes_data.strStatusColor)

				.createNewStatus(objStatusTypes_data.strStatusNameInMulti3,
						objStatusTypes_data.strStatusColor);

		objStatusTypeList.clickOnReturnToStatusTypeList();
		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName1);

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();
		// Resource type creation
		objNavigationToSubmenus1.navigateToResourceTypesInSetup();

		objResourceType_Page1
				.clickOnCreateNewResourceTypeButton()

				.enterResourceTypeName(objResourceType_data.strResourceTypeName)
				.enterResourceTypeDescription(
						objResourceType_data.strResTypeDescription)
				.clickStatusType(strStatusTypeValues).clickOnSaveButton()
				.verErrWhenRTCreatedWithSameStanderedSType();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

}
