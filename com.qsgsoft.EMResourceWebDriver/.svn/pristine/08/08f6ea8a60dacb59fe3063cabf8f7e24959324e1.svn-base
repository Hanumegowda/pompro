package requirementGroup.ResourceHierarchies;

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

public class HappyDayNewCreatingSubResource extends TestNG_UI_EXTENSIONS{

	public HappyDayNewCreatingSubResource() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/*************************************************************************************
	'Description 	:Verify that all sub-resource types created in a region are displayed while creating a sub-resource in a region.
	'Precondition	: 
	'Date 			: 14-Aug-2015 
	'Author 		: Sangappa.k
	'------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description ="Verify that all sub-resource types created in a region are displayed while creating a sub-resource in a region.")
	public void testHappyDay105642() throws Exception {

		gstrTCID = "105642";
		gstrTO = "Verify that all sub-resource types created in a region are displayed while creating a sub-resource in a region.";
		
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		Login_data objTest_data = new Login_data();
		
		Login objLogin = new Login(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1=new NavigationToSubMenus(driver1);

		String strStatusTypeValues[] = new String[2];

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion
				.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList()

		.createStatusType(objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);
		
		// First resource type creation
		objResourceType.navigateToResourceTypePage()
				.createResourceType(objResourceType_data.strResourceTypeName,
						strStatusTypeValues);
		
		String[] strstatusType1={strStatusTypeValues[0]};
		String[] strstatusType2={strStatusTypeValues[1]};  

		objResourceType.createSubResourceType(objResourceType_data.strSubResourceTypeName, strstatusType1)
		               .createSubResourceType(objResourceType_data.strSubResourceTypeName1, strstatusType2)
		               .verResourceTypeInList(objResourceType_data.strSubResourceTypeName)
		               .verResourceTypeInList(objResourceType_data.strSubResourceTypeName1);
		              
		// Resource creation
		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		objLogin.clickLogOut();
		
		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion1
				.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubMenus1.navigateToResourceInSetup();
		
		objResource1.verifyStatusTypeLink(objResource_data.strResourceName)
		           .verifyEditLink(objResource_data.strResourceName) 
		           .verifyDemoteLink(objResource_data.strResourceName)
		           .verResourceInList(objResource_data.strResourceName)
		           .clickOnSubResourcesLink(objResource_data.strResourceName)
		           .clickOnCreateNewSubResourceButton()
		           .enterResourceName(objResource_data.strSubResourceName)
		           .enterResourceAbbrivation(objResource_data.strResourceAbbrivation1)
		           .verSubResTypeIsListedUnderResTypDropDown(objResourceType_data.strSubResourceTypeName)
		           .verSubResTypeIsListedUnderResTypDropDown(objResourceType_data.strSubResourceTypeName1)
		           .selectResourceTypename(objResourceType_data.strSubResourceTypeName1)
		           .selectStandardResourceTypename(objResource_data.strStandardResourceTypename1)
		           .enterResourceFirstName(objResource_data.strResourceFirstName)
		           .enterResourceLastName(objResource_data.strResourceLastName)
		           .clickOnSaveButton()
		           .verSubResourceAbbInSubResPage(objResource_data.strSubResourceName, objResource_data.strResourceAbbrivation1)
		           .verSubResourceInSubResPage(objResource_data.strSubResourceName)
		           .verSubResTypeForSubResourInSubResPage(objResource_data.strSubResourceName,objResourceType_data.strSubResourceTypeName1);
		       
		objLogin1.clickLogOut();       
		     
		gstrResult = "PASS";
	}

	/*************************************************************************************
	'Description 	: Verify that sub-resource can be created selecting a sub-resource type.
	'Precondition	: 
	'Date 			: 14-Aug-2015 
	'Author 		: Anil
	'------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description =" Verify that sub-resource can be created selecting a sub-resource type.")
	public void testHappyDay105623() throws Exception {

		gstrTCID = "105623";
		gstrTO = " Verify that sub-resource can be created selecting a sub-resource type.";
		
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		Login_data objTest_data = new Login_data();
		
		Login objLogin = new Login(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1=new NavigationToSubMenus(driver1);

		String strStatusTypeValues[] = new String[2];

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion
				.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList()

		.createStatusType(objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);
		
		// First resource type creation
		objResourceType.navigateToResourceTypePage()
				.createResourceType(objResourceType_data.strResourceTypeName,
						strStatusTypeValues);
		
		String[] strstatusType1={strStatusTypeValues[0]};
		String[] strstatusType2={strStatusTypeValues[1]};  

		objResourceType.createSubResourceType(objResourceType_data.strSubResourceTypeName, strstatusType1)
		               .verResourceTypeInList(objResourceType_data.strSubResourceTypeName);
		              
		// Resource creation
		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		objLogin.clickLogOut();
		
		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion1
				.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubMenus1.navigateToResourceInSetup();
		
		objResource1.verifyStatusTypeLink(objResource_data.strResourceName)
		           .verifyEditLink(objResource_data.strResourceName) 
		           .verifyDemoteLink(objResource_data.strResourceName)
		           .verResourceInList(objResource_data.strResourceName)
		           .clickOnSubResourcesLink(objResource_data.strResourceName)
		           .clickOnCreateNewSubResourceButton()
		           .verifySubResourceFields()
		           .verifySubResourceTypeNotDisplayedInDropDown(objResourceType_data.strResourceTypeName)	
		           		.enterResourceName(objResource_data.strSubResourceName)
						.enterResourceAbbrivation(objResource_data.strResourceAbbrivation)
						.selectResourceTypename(objResourceType_data.strSubResourceTypeName)
						.selectStandardResourceTypename(objResource_data.strStandardResourceTypename)
						.enterResourceFirstName(objResource_data.strResourceFirstName)
						.enterResourceLastName(objResource_data.strResourceLastName)
						.clickOnSaveButton()
		           .verSubResourceAbbInSubResPage(objResource_data.strSubResourceName, objResource_data.strResourceAbbrivation)
		           .verSubResourceInSubResPage(objResource_data.strSubResourceName)
		           .verSubResTypeForSubResourInSubResPage(objResource_data.strSubResourceName,objResourceType_data.strSubResourceTypeName);
		       
		objLogin1.clickLogOut();       
		     
		gstrResult = "PASS";
	}


}
