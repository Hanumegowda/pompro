package requirementGroup.Reports;

import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.NavigationToSubMenus;
import lib.page.EventManagement;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Report;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UpdateStatus;
import lib.page.UsersList;
import lib.page.ViewsList;
import org.testng.annotations.Test;
import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class HappyDayMonthlyStatusAssessmentReport extends TestNG_UI_EXTENSIONS {

	public HappyDayMonthlyStatusAssessmentReport() throws Exception {
		super();
	}

	/***************************************************************************************************************
	 * 'Description : Verify that sub-resources are not available while generating 'Monthly Status Assessment report' 
	 * 'Date        : 11-Nov-2014 
	 * 'Author      : Anil
	 ***************************************************************************************************************/

	@Test(description = "Verify that sub-resources are not available while generating 'Monthly Status Assessment report' ")
	public void testHappyDay151046() throws Exception {
		gstrTCID = "151046";
		gstrTO = "Verify that sub-resources are not available while generating 'Monthly Status Assessment report' ";

		// Objects for data
		Login_data objTest_data = new Login_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		Date_Time_settings dts = new Date_Time_settings();
		
		UsersList UsersList_page = new UsersList(this.driver1);	
		ResourceType ResourceType_Page = new ResourceType(this.driver1);		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus = new NavigationToSubMenus(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		
		String strResourceValue[] = new String[1];
		String strstatusTypeValues[] = new String[3];
		String strstatusesValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strSubResourceTypeValue[] = new String[1];
		String strSubResourceValue[] = new String[1];
		
		Login objLogin1 = new Login(this.driver1);		
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objnNavigationToSubMenus1 = new NavigationToSubMenus(this.driver1);
		UpdateStatus UpdateStatus_page1 = new UpdateStatus(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		Report objReport1 = new Report(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		
		System.out.println("-----Precondtion execution starts------");
		
		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion
				.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// RoleBased statustypes
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription)
				
		.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti);	
		
		strstatusesValues[0] = objStatusTypeList.getStatusesValue(
				objStatusTypes_data.strStatusNameInMulti);
				
		
		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti);	
		
		strstatusesValues[1] = objStatusTypeList.getStatusesValue(
				objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);
						
		// Private status types
		objStatusTypeList.createPrivateStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strpMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription)
				
		.createNewStatus(objStatusTypes_data.strStatusNameInMulti2,
				objStatusTypes_data.strStatusColor)
				
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti2);	
		
		strstatusesValues[2] = objStatusTypeList.getStatusesValue(
				objStatusTypes_data.strStatusNameInMulti2);
				
		
		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti3,
				objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti3);	
		
		strstatusesValues[3] = objStatusTypeList.getStatusesValue(
				objStatusTypes_data.strStatusNameInMulti3);

		
		objStatusTypeList.clickOnReturnToStatusTypeList();

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strpMSTStatusTypeName);
		
		// Shared status types
		objStatusTypeList.createSharedStatusType(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName2,
				objStatusTypes_data.strStatusDescription)
				
		.createNewStatus(objStatusTypes_data.strStatusNameInMulti4,
				objStatusTypes_data.strStatusColor)
				
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti4);	
		
		strstatusesValues[4] = objStatusTypeList.getStatusesValue(
				objStatusTypes_data.strStatusNameInMulti4);
				
		
		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti5,
				objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti5);	
		
		strstatusesValues[5] = objStatusTypeList.getStatusesValue(
				objStatusTypes_data.strStatusNameInMulti5);

		
		objStatusTypeList.clickOnReturnToStatusTypeList();

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName2);
		
		objnNavigationToSubMenus.navigateToResourceInSetup();
		
		// Resource type creation		
		ResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strstatusTypeValues);

		strResourceTypeValue[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Create Sub-Resource Type
		ResourceType_Page
				.navigateToResourceTypePage()
				.createResourceType(
						objResourceType_data.strSubResourceTypeName,
						strstatusTypeValues)
				.clickOnEditLinkOfResourceType(
						objResourceType_data.strSubResourceTypeName)
				.enterResourceTypeDescription(
						objResourceType_data.strResTypeDescription)
				.selectSubResourceTypeCheckBox().clickOnSaveButton();

		strSubResourceTypeValue[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strSubResourceTypeName);
		
		// Resource creation
		Resource_Page.navigateToResourceListPage()

		.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName);

		Resource_Page.clickOnSubResourcesLink(objResource_data.strResourceName)
		.verSubResourceListPageIsDisplayed(
				objResource_data.strResourceName);

		Resource_Page
		.clickOnCreateNewSubResourceButton()
		
		//Create New Sub-Resource' screen is displayed
		.enterResourceName(objResource_data.strSubResourceName)
		.enterResourceAbbrivation(
				objResource_data.strResourceAbbrivation)
		.selectResourceTypename(
				objResourceType_data.strSubResourceTypeName)
		.selectStandardResourceTypename(
				objResource_data.strStandardResourceTypename)
		.enterResourceFirstName(objResource_data.strResourceFirstName)
		.enterResourceLastName(objResource_data.strResourceLastName)
		.clickOnSaveButton();

		Resource_Page.verSubResourceInResourceListPage(objResource_data.strSubResourceName);
		
		strSubResourceValue[0]= Resource_Page.getSubResourceValue(objResource_data.strSubResourceName);
		
		UsersList_page
		.navigateToUsersNew()

		.clickCreateNewUserButton()

		.enterUserDetails(objUserdata.strNewUserName,
				objUserdata.strNewPassword, objUserdata.strFullName)
		
		.selectFirstRole()
						
		.selectUpdateStatusOfResource(objResource_data.strResourceName)

		.selectRunReportRight(objResource_data.strResourceName)
		
		.clickAdvancedOptionAndExpand()
		
		.selectMonthlyStatusAssignmentOption()
		
		.clickSaveButton()
		.verifyUserListPageIsDisplayed();

		objnNavigationToSubMenus.navigateToViews();
		
		String[] strStatusTypeNames = {
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strpMSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName2};
		
		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc, objResource_data.strResourceName, strStatusTypeNames);
//		objViewsList.clickCreateNewViewButton()
//		.enterViewName(objView_data.strViewName)
//		.enterViewDesc(objView_data.strViewDesc);
//
//
//		
//		for (int i = 0; i < strStatusTypeNames.length; i++) {
//		
//			objViewsList.selectStatusType(strStatusTypeNames[i]);
//		}
//
//		objViewsList.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();
	
		objLogin.clickLogOut();

		System.out.println(objUserdata.strNewUserName);

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objnNavigationToSubMenus1
		.navigateToParticularViewUnderViewMenu(objView_data.strViewName);
		
		objViewsList1
		.clickOnUpdateStatus(objResource_data.strResourceName);
				
		UpdateStatus_page1.clickOnSelectAll();
				
		Thread.sleep(3000);
		    
	    UpdateStatus_page1.selectMSTUpdateValue(strstatusTypeValues[0], strstatusesValues[0]);
	 
		
	    UpdateStatus_page1.selectMSTUpdateValue(strstatusTypeValues[1], strstatusesValues[2]);
	    
	    UpdateStatus_page1.selectMSTUpdateValue(strstatusTypeValues[2], strstatusesValues[4]);
	    
	    UpdateStatus_page1.clickOnSaveButton();

		String strApplicationTime = objEventManagement1.getApplicationTime();
		
		String strCurrentYear = dts.timeNow("yyyy");
		
		strApplicationTime = strApplicationTime+" "+strCurrentYear;
		
		strApplicationTime = dts.converDateFormat(strApplicationTime, "dd MMM HH:mm yyyy", "MM/dd/yyyy");
		
	    objnNavigationToSubMenus1.clickOnStatusReports();
	    
		objReport1.clickOnMonthlyStatusSummaryLink();
		
		objReport1.verifyResourceIsDisplayed(strResourceValue[0]);
		
		objReport1.verifyResourceNameNotDisplayed(strSubResourceValue[0]);
		
		objReport1.selectCSVRadioBtn();
		 
		objReport1.selectResources(strResourceValue[0]).clickOnNextBtn()
		  .selStatusType(objStatusTypes_data.strMSTStatusTypeName)
		  .clickOnNextBtn()
		  .selStatuses(strstatusesValues[0])
		  .clickOnGenerateReportBtn();

		gstrResult = "PASS";
	}
	
	}
