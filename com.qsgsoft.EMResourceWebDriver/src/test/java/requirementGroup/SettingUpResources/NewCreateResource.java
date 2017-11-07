package requirementGroup.SettingUpResources;

import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.module.NavigationToSubMenus;
import lib.page.Login;
import lib.page.Map;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewCreateResource extends TestNG_UI_EXTENSIONS {

	public NewCreateResource() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/*************************************************************************************
	'Description : Verify that a resource can be created. 
	'Precondition:
	'Date	 	 : 29-May-2015
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that a resource can be created. ")
	public void testHappyDay69613() throws Exception {

		gstrTCID = "69613";
		gstrTO = "Verify that a resource can be created. ";

		Login_data objLogindata = new Login_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();

		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList1 = new StatusTypeList(this.driver1);
		ResourceType objResourceType_Page1 = new ResourceType(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		Map objMap1 = new Map(this.driver1);
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		
		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;
		boolean blnTest = false;

		String strStatusTypeValues[] = new String[1];

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

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

		objResourceType_Page1
				.createResourceType(objResourceType_data.strResourceTypeName,
						strStatusTypeValues)
				.verResourceTypeInList(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus1.navigateToResourceInSetup();

		objResource1
				.clickOnCreateNewResourceButton()
				.verCreateNewResourcePageIsDisplayed()
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
				.clickOnLookupAddressBtn().verMap().verLattitudePopulated()
				.verLongitudePopulated();
		
		String strLattitude = objResource1.getLatitude();
		
		String strLongitude = objResource1.getLongitude();
		
		objResource1.clickOnSaveButton()
				.clickOnViewResChkBox().clickOnSaveButton();

		objNavigationToSubmenus1.navigateToMap();

		String strStatusTypeName[] = {objStatusTypes_data.strNSTStatusTypeName};
		
		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verViewInfoInPopupWindow()
				.verStatusTypesInPopupWindow(strStatusTypeName)
				.clickOnViewInfoInPopupWindow();

		objLogin1.clickLogOut();
		
		blnTest = true;

		if (blnTest) {
		
		String[] strTestData1 = { gstrTCID, objLogindata.strRegionName,objLogindata.strAdminUser+"/"+objLogindata.strAdminUserPwd,
				objStatusTypes_data.strNSTStatusTypeName, objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName, objResource_data.strStandardResourceTypename,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode, strLattitude, strLongitude};
		
		objOffCommonFunc.writeResultData(strTestData1,
				strPartialAutoResultsPath, "MobileTestData");
		}
		gstrResult = "PASS";
	}
}
