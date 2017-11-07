package requirementGroup.ResourceHierarchies;

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

public class HappyDayNewEditingSubResource extends TestNG_UI_EXTENSIONS{

	public HappyDayNewEditingSubResource() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/*************************************************************************************
	'Description 	: Verify that user can edit a sub-resource.
	'Precondition	: 
	'Date 			: 14-Aug-2015 
	'Author 		: Anil
	'------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description =" Verify that user can edit a sub-resource.")
	public void testHappyDay105692() throws Exception {

		gstrTCID = "105692";
		gstrTO = " Verify that user can edit a sub-resource.";
		
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		Login_data objTest_data = new Login_data();
		
		Login objLogin = new Login(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		User_data objUserdata = new User_data();
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
		Thread.sleep(5000);
		objResource.clickOnSubResourcesLink(objResource_data.strResourceName);
		objResource.createSubResourceForResource(objResource_data.strSubResourceName, objResource_data.strResourceAbbrivation, objResourceType_data.strSubResourceTypeName,objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);
		
		objUsersList
		.navigateToUsersNew()
		.clickCreateNewUserButton()
		.enterUserDetails(objUserdata.strNewUserName,
				objUserdata.strNewPassword, objUserdata.strFullName)
		.selectFirstRole()
		.selectUpdateStatusOfResource(objResource_data.strResourceName)
		.selectRunReportsCheckBox(objResource_data.strResourceName)
		.clickAdvancedOptionAndExpand()
		.selectEditResourcesOnlyOption()
		.clickSaveButton();
		
		objLogin.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objRegionDefault1.verifyRegionDefaultPage();
		
		objNavigationToSubMenus1.navigateToResourceInSetup();
		
		objResource1.verifyEditLink(objResource_data.strResourceName) 
		           .verResourceInList(objResource_data.strResourceName)
		           .clickOnSubResourcesLink(objResource_data.strResourceName);	
		
		
		objResource1.verSubResourceListPageisDisplayed(objResource_data.strResourceName);
		objResource1.clickOnEditLinkInSubResourceListPage(objResource_data.strSubResourceName)
					.verifySubResourceTypenameInEditSubResource(objResourceType_data.strSubResourceTypeName)
					.verifySubResourceTypenameInEditSubResourceIsDisabled(objResourceType_data.strSubResourceTypeName)
		           .enterResourceName(objResource_data.strSubResourceName1)
		           .enterResourceAbbrivation(objResource_data.strResourceAbbrivation1)
		           .clickOnSaveButton();
		objResource1.verSubResTypeForSubResourInSubResPage(objResource_data.strSubResourceName1,objResourceType_data.strSubResourceTypeName);
		objResource1.verSubResourceAbbInSubResPage(objResource_data.strSubResourceName1, objResource_data.strResourceAbbrivation1); 
		objLogin1.clickLogOut();       
		     
		gstrResult = "PASS";
	}

}
