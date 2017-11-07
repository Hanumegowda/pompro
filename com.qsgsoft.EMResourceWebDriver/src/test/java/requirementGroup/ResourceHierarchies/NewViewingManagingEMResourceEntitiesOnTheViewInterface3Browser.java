package requirementGroup.ResourceHierarchies;

import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.LinksAtTopRightCorners;
import lib.module.NavigationToSubMenus;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UsersList;
import lib.page.Views;
import lib.page.ViewsList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSThreeBrowser;

public class NewViewingManagingEMResourceEntitiesOnTheViewInterface3Browser extends TestNG_UI_EXTENSIONSThreeBrowser{

	public NewViewingManagingEMResourceEntitiesOnTheViewInterface3Browser()
			throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/*************************************************************************************
	 * 'Description 	: Verify that sub-resources are displayed accordingly when added/removed from view resource detail screen on refresh 
	 * 'Precondition	: 
	 * 'Date 			: 09-Feb-2016 
	 * 'Author 			: Renushree
	 * '---------------------------------------------------------------
	 * 'Modified Date 			Modified By 
	 * 'Date Name
	 **************************************************************************************/
	@Test(description = "Verify that sub-resources are displayed accordingly when added/removed from view resource detail screen on refresh")
	public void testHappyDay124976() throws Exception {

		gstrTCID = "124976";
		gstrTO = "Verify that sub-resources can be added to the resource detail view.";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();
		ViewsList objViewsList = new ViewsList(this.driver1);
		View_data objView_data = new View_data();

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		Views objViews1 = new Views(this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(this.driver1);
		
		Login objLogin2 = new Login(this.driver2);
		SelectRegion objSelectRegionpage2 = new SelectRegion(this.driver2);
		RegionDefault objRegionDefault2 = new RegionDefault(this.driver2);
		NavigationToSubMenus objNavigationToSubmenus2 = new NavigationToSubMenus(
				this.driver2);
		ViewsList objViewsList2 = new ViewsList(this.driver2);

		String strStatusTypeValues[] = new String[4];
		String strStatusTypeValues1[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strSubResourceTypeValue[] = new String[2];
		String strResourceValue[] = new String[1];
		String strSubResourceValue[] = new String[2];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault.selectFrame();

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToViews();

		objViewsList.clickOncustomizeResourceDetailView()
				.enterSectionName(objView_data.strSectionName)
				.clickOnCreateSection()
				.verCreatedSection(objView_data.strSectionName)
				.clickOnSaveButton();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.createStatusTypeWithSection(
						objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription,
						objView_data.strSectionName)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
						
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1)		
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues1[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);


		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Create Sub-Resource Type
		objResourceType
				.navigateToResourceTypePage()
				.createResourceType(
						objResourceType_data.strSubResourceTypeName,
						strStatusTypeValues1)
				.clickOnEditLinkOfResourceType(
						objResourceType_data.strSubResourceTypeName)
				.enterResourceTypeDescription(
						objResourceType_data.strResTypeDescription)
				.selectSubResourceTypeCheckBox().clickOnSaveButton();

		strSubResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strSubResourceTypeName);
		
		System.out.println(objResourceType_data.strSubResourceTypeName);

		String[] strSTVal ={strStatusTypeValues[0], strStatusTypeValues1[1]}; 
				
		objResourceType
				.navigateToResourceTypePage()
				.createResourceType(
						objResourceType_data.strSubResourceTypeName1,
						strSTVal)
				.clickOnEditLinkOfResourceType(
						objResourceType_data.strSubResourceTypeName1)
				.enterResourceTypeDescription(
						objResourceType_data.strResTypeDescription)
				.selectSubResourceTypeCheckBox().clickOnSaveButton();

		strSubResourceTypeValue[1] = objResourceType
				.getResourceTypeValue(objResourceType_data.strSubResourceTypeName1);

		// Resource creation
		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objResource.clickOnSubResourcesLink(objResource_data.strResourceName)
				.createSubResourceForResource(
						objResource_data.strResourceName1,
						objResource_data.strResourceAbbrivation,
						objResourceType_data.strSubResourceTypeName,
						objResource_data.strStandardResourceTypename,
						objResource_data.strResourceFirstName,
						objResource_data.strResourceLastName);

		strSubResourceValue[0] = objResource
				.getSubResourceValue(objResource_data.strResourceName1);
		
		objResource.navigateToResourceListPage().clickOnSubResourcesLink(objResource_data.strResourceName)
		.createSubResourceForResource(
				objResource_data.strResourceName2,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strSubResourceTypeName1,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strSubResourceValue[1] = objResource
				.getSubResourceValue(objResource_data.strResourceName2);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectAssosciateResourceRight(objResource_data.strResourceName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectConfigureRegionViewsOption()
				.clickSaveButton();

		objNavigationToSubmenus.navigateToViews();

		String[] strAllStatausTypes = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName};

		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc,
							objResource_data.strResourceName, strAllStatausTypes);
		
//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);
//
//		for (int i = 0; i < strAllStatausTypes.length; i++) {
//
//			objViewsList.selectStatusType(strAllStatausTypes[i]);
//		}
//
//		objViewsList.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView()
//				.verViewInList(objView_data.strViewName);

		objLogin.clickLogOut();
		
		System.out.println(objView_data.strViewName);
		System.out.println(objUserdata.strNewUserName);
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		for (int i = 0; i < strAllStatausTypes.length; i++) {

			objViewsList1.verResAndStatusTypes(strResourceTypeValue[0],
					objResource_data.strResourceName, strAllStatausTypes[i]);
		}

		objViews1.clickOnResource(objResource_data.strResourceName)
				.verViewResourceDetailsPgeIsDisplayed()
				.verResourceScreenDisplayed(objResource_data.strResourceName);

		for (int i = 0; i < strAllStatausTypes.length; i++) {
			objViews1.verStatusTypesUnderSection(strAllStatausTypes[i],
					objView_data.strSectionName);
		}

		objViewsList1
				.verSubResourceNotDisplayedInResourceDetailView(objResource_data.strResourceName1);
		objViewsList1
		.verSubResourceNotDisplayedInResourceDetailView(objResource_data.strResourceName2);

		objNavigationToSubmenus1.navigateToViews();

		objViewsList1.verRegionViewListPageIsDisplayed()
				.verCreateNewViewReorderAndCustomizeDetailViewButton();

		objViewsList1
				.clickOncustomizeResourceDetailView()
				.verEditResourceDetailViewSectionsPageIsDisplayed()
				.verifySubResourceButton()
				.verifyCancelButton()
				.verifySortAllButton()
				.verifySaveButton()
				.clickSubResourceButton()
				.verEditSubResourceDetailViewSectionsPageIsDisplayed()
				.clickOnSubResourceTypeName(
						objResourceType_data.strSubResourceTypeName)
				.selectSubResourceTypeCheckBox(strSubResourceTypeValue[0])
				.selectSubResourceCheckBoxWithSubRTValue(
						strStatusTypeValues1[0], strSubResourceTypeValue[0])
				.selectSubResourceCheckBoxWithSubRTValue(
						strStatusTypeValues1[1], strSubResourceTypeValue[0])

				.clickOnSubResourceTypeName(
						objResourceType_data.strSubResourceTypeName1)
				.selectSubResourceTypeCheckBox(strSubResourceTypeValue[1])
				.selectSubResourceCheckBoxWithSubRTValue(
						strStatusTypeValues1[1], strSubResourceTypeValue[1])
				.selectSubResourceCheckBoxWithSubRTValue(
						strStatusTypeValues[0], strSubResourceTypeValue[1])
				.clickOnSaveButton().verRegionViewListPageIsDisplayed();

		System.out.println(objView_data.strViewName);
		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		for (int i = 0; i < strAllStatausTypes.length; i++) {

			objViewsList1.verResAndStatusTypes(strResourceTypeValue[0],
					objResource_data.strResourceName, strAllStatausTypes[i]);
		}

		objViews1.clickOnResource(objResource_data.strResourceName)
				.verViewResourceDetailsPgeIsDisplayed()
				.verResourceScreenDisplayed(objResource_data.strResourceName);

		for (int i = 0; i < strAllStatausTypes.length; i++) {
			objViews1.verStatusTypesUnderSection(strAllStatausTypes[i],
					objView_data.strSectionName);
		}
		objViewsList1.verifyStatusTypeNameInView(strSubResourceTypeValue[0],
				objStatusTypes_data.strNDSTStatusTypeName)
				.verifyStatusTypeNameInView(strSubResourceTypeValue[0],
						objStatusTypes_data.strDateStatusTypeName);

		objViewsList1.verifyStatusTypeNameInView(strSubResourceTypeValue[1],
				objStatusTypes_data.strNSTStatusTypeName)
				.verifyStatusTypeNameInView(strSubResourceTypeValue[1],
						objStatusTypes_data.strDateStatusTypeName);

		objViewsList1.verUpdateStatusOfSubResource(
				objResource_data.strResourceName1)
				.verAssociatedUsrInContactTable(objUserdata.strFullName);
		
		objLogin2.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault2.selectFrame();

		objSelectRegionpage2
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault2.selectFrame();
		
		objNavigationToSubmenus2.navigateToViews();

		objViewsList2.verRegionViewListPageIsDisplayed()
				.verCreateNewViewReorderAndCustomizeDetailViewButton();

		objViewsList2
				.clickOncustomizeResourceDetailView()
				.verEditResourceDetailViewSectionsPageIsDisplayed()
				.clickSubResourceButton()
				.verEditSubResourceDetailViewSectionsPageIsDisplayed()
				.clickOnSubResourceTypeName(
						objResourceType_data.strSubResourceTypeName)
				.selectSubResourceTypeCheckBox(strSubResourceTypeValue[0])
				.deselectSubResourceCheckBox(strStatusTypeValues1[0],strSubResourceTypeValue[0])
				.deselectSubResourceCheckBox(strStatusTypeValues1[1], strSubResourceTypeValue[0])
				.clickOnSaveButton();
		
		objLinksAtTopRightCorners1.clickOnRefresh();
		
		for (int i = 0; i < strAllStatausTypes.length; i++) {
			objViews1.verStatusTypesUnderSection(strAllStatausTypes[i],
					objView_data.strSectionName);
		}
		
		objViewsList1.verifyStatusTypeNameInView(strSubResourceTypeValue[1],
				objStatusTypes_data.strNSTStatusTypeName)
				.verifyStatusTypeNameInView(strSubResourceTypeValue[1],
						objStatusTypes_data.strDateStatusTypeName);

		objViewsList1
		.verSubResourceTableNotDisplayedInResourceDetail(strSubResourceTypeValue[0]);
		
		objViewsList2
		.clickOncustomizeResourceDetailView()
		.clickSubResourceButton()
		.clickOnSubResourceTypeName(
				objResourceType_data.strSubResourceTypeName)
		.selectSubResourceTypeCheckBox(strSubResourceTypeValue[0])
		.selectSubResourceCheckBoxWithSubRTValue(
						strStatusTypeValues1[0], strSubResourceTypeValue[0])
				.selectSubResourceCheckBoxWithSubRTValue(
						strStatusTypeValues1[1], strSubResourceTypeValue[0])
		.clickOnSaveButton();

		objLinksAtTopRightCorners1.clickOnRefresh();
		
		for (int i = 0; i < strAllStatausTypes.length; i++) {
			objViews1.verStatusTypesUnderSection(strAllStatausTypes[i],
					objView_data.strSectionName);
		}
		objViewsList1.verifyStatusTypeNameInView(strSubResourceTypeValue[0],
				objStatusTypes_data.strNDSTStatusTypeName)
				.verifyStatusTypeNameInView(strSubResourceTypeValue[0],
						objStatusTypes_data.strDateStatusTypeName);

		objViewsList1.verifyStatusTypeNameInView(strSubResourceTypeValue[1],
				objStatusTypes_data.strNSTStatusTypeName)
				.verifyStatusTypeNameInView(strSubResourceTypeValue[1],
						objStatusTypes_data.strDateStatusTypeName);

		objLogin1.clickLogOut();
		
		objLogin2.clickLogOut();
		
		gstrResult = "PASS";
	}
}
