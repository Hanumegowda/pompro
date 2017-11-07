package requirementGroup.SettingUpResources;

import java.util.Arrays;
import lib.dataObject.EventSetUp_data;
import lib.dataObject.Event_data;
import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.EventManagement;
import lib.page.EventSetUp;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Regions;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewEdgeCaseEditResource extends TestNG_UI_EXTENSIONS {

	public NewEdgeCaseEditResource() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/*************************************************************************************
	 * 'Description 	: Verify that when a resource is opened for editing all the previously saved values are retained.
	 * 'Precondition	: 
	 * 'Date 			: 29-Feb-2016 
	 * 'Author 			: Sangappa K
	 * '---------------------------------------------------------------
	 * 'Modified Date 			Modified By 
	 * 'Date Name
	 **************************************************************************************/
	@Test(description = "Verify that when a resource is opened for editing all the previously saved values are retained.")
	public void testEdgeCase112474() throws Exception {

		gstrTCID ="112474";
		gstrTO = "Verify that when a resource is opened for editing all the previously saved values are retained.";

		Login_data objLogindata = new Login_data();
		Resource_data objResource_data = new Resource_data();
		

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		

		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		Resource objResource1 = new Resource(this.driver1);

		String strStatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strLattitude, strLongitude;

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createEventStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strsSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strsSSTStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);
		System.out.println(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource
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
				.enterStreetAddress(objResource_data.strStreetAddress)
				.selectState(objResource_data.strState)
				.enterCity(objResource_data.strCity)
				.enterzipCode(objResource_data.strZipcode)
				.selectCounty(objResource_data.strCounty)
				.clickOnLookupAddressBtn().verMap();

		strLattitude = objResource.getLatitudeWithFraction();
		strLongitude = objResource.getLongitudeWithFraction();
		
		String str6DigitLaT = objResource
				.getDecimalFormatUpToSixDigits(strLattitude);
		String str6DigitLonG = objResource
				.getDecimalFormatUpToSixDigits(strLongitude);


		System.out.println("Captured Lat" + strLattitude);

		System.out.println("Captured Long" + strLongitude);

		objResource.clickOnSaveButton().clickOnSaveButton();

		System.out.println(objResource_data.strResourceName);

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToResourceInSetup();

		objResource1
				.verResourceInList(objResource_data.strResourceName)
				.clickOnEditLinkInResourcePage(objResource_data.strResourceName)
				.verEditResourcePageisDisplayed()
				.verifyResourceNameInEditResource(
						objResource_data.strResourceName)
				.verResourceTypenameInEditResource(
						objResourceType_data.strResourceTypeName)
				.verifyResourceAbbrivationInEditResource(
						objResource_data.strResourceAbbrivation)
				.verStandardResourceTypenameInEditResource(
						objResource_data.strStandardResourceTypename)
				.verifyResourceFirstNameInEditResource(
						objResource_data.strResourceFirstName)
				.verifyResourceLastNameInEditResource(
						objResource_data.strResourceLastName)
				.verifyStreetInEditResource(objResource_data.strStreetAddress)
				.verifyZipInEditResource(objResource_data.strZipcode)
				.verifyCityInEditResource(objResource_data.strCity)
				.verLongitudeAndLattudeInEditResPage(str6DigitLonG, str6DigitLaT)
				.verifyStateInEditResource(objResource_data.strCaliforniaCode)
				.clickOnSaveButton();
		objLogin1.clickLogOut();
		gstrResult = "PASS";

	}

}
