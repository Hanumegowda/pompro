package requirementGroup.ViewingAndmanagingEMResourceEntitiesOnTheViewInterface;

import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.NavigationToSubMenus;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UsersList;
import lib.page.ViewsList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSThreeBrowser;

public class EdgeCaseDeleteRegionView3Browser extends TestNG_UI_EXTENSIONSThreeBrowser {

	public EdgeCaseDeleteRegionView3Browser() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/*****************************************************************************************************
	'Description 	: Verify that if a user (User A), who has access to View 1, is logged in to the system 
	                  and another user deletes View 1, then when User A clicks on ‘View 1’ in the menu, he 
	                  is taken to the region's default view
	'Date 			: 29-Apr-2015 
	'Author 		: Anil
	'-----------------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	******************************************************************************************************/
	@Test(description = "Verify that if a user (User A), who has access to View 1, is logged in to the system and "
			+ "another user deletes View 1, then when User A clicks on ‘View 1’ in the menu, he is taken"
			+ " to the region's default view.")
	public void testHappyDay156055() throws Exception {

		gstrTCID = "156055";
		gstrTO = "Verify that if a user (User A), who has access to View 1, is logged in to the system and "
				+ "another user deletes View 1, then when User A clicks on ‘View 1’ in the menu, he is taken"
				+ " to the region's default view.";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		View_data objView_data = new View_data();
		User_data objUserdata = new User_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus = new NavigationToSubMenus(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		
		Login objLogin2 = new Login(this.driver2);
		RegionDefault objRegionDefault2 = new RegionDefault(this.driver2);
		ViewsList objViewsList2 = new ViewsList(this.driver2);
		
		String strStatusTypeValues [] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue    [] = new String[1];

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();
		
		objnNavigationToSubMenus.navigateToStatusTypesInSetup();

		// RoleBased statustypes
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource.navigateToResourceListPage().createResourceWithAddress(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);
		
		String[] strSTNames = { objStatuTypes_data.strNSTStatusTypeName };
		
		objViewsList.navigateToViewsList()
//				.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc)
//				.selectStatusTypeForView(strStatusTypeValues)
//				.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();
				.createView(objView_data.strViewName, objView_data.strViewDesc,
						objResource_data.strResourceName, strSTNames);
		
		System.out.println(objView_data.strViewName);
		
		objnNavigationToSubMenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickSaveButton();

		objLogin.clickLogOut();
		
		System.out.println("---------Precondition ends and test execution starts--------");
		
		//User
		objLogin2.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault2.selectFrame();
		
		objViewsList2.clickOnView();
		
		//RegAdmin

		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);
		
		objRegionDefault1.selectFrame();

		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();
		
		objViewsList1
				.navigateToViewsListNew()

				.verViewInList(objView_data.strViewName)
				
				.clickOnDeleteAssociatedWithMulRegView(objView_data.strViewName)
				
				.verDelViewConfPgeIsDisplayed()
				
				.verDelViewConfirmationPge()
				
				.clickOnDelete();
				
		objViewsList2.navigateToCreatedViewNew(objView_data.strViewName)
		
		             .verViewIsNotListedMessage();
		
		objViewsList1.verViewIsNotListed(objView_data.strCustomView);
		
		gstrResult = "PASS";
	}
}
