package requirementGroup.CreatingAndManagingUsers;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import lib.dataObject.Calendar_data;
import lib.dataObject.EventSetUp_data;
import lib.dataObject.Event_data;
import lib.dataObject.Login_data;
import lib.dataObject.Report_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.LinksAtTopRightCorners;
import lib.module.NavigationToSubMenus;
import lib.page.AutoIT;
import lib.page.Calendar;
import lib.page.EventManagement;
import lib.page.EventSetUp;
import lib.page.Login;
import lib.page.Map;
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

import qaframework.lib.UserDefinedFunctions.CSVFunctions;
import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.UserDefinedFunctions.PathsProperties;
import qaframework.lib.UserDefinedFunctions.ReadAutoItProperty;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewForEMR315NotToForceStatusUpdate extends TestNG_UI_EXTENSIONS {

	public NewForEMR315NotToForceStatusUpdate() throws Exception {
		super();
	}
	
	/*********************************************************************************
	'Description : Verify that user is required to update status of only the status types which are created without selecting 'Exempt from Must Update' when there are multiple status types with the resource.
	'Precondition:
	'Date	 	 : 03-Mar-2014
	'Author		 : Anil
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************/
	@Test(description = "Verify that user is required to update status of only the status types which are created without selecting 'Exempt from Must Update' when there are multiple status types with the resource.")
	public void testHappyDay23665() throws Exception {
		gstrTCID = "23665";
		gstrTO = "Verify that user is required to update status of only the status types which are created without selecting 'Exempt from Must Update' when there are multiple status types with the resource.";
		
		Login_data objTest_data = new Login_data();

		UsersList objUsersList_page = new UsersList(this.driver1);

		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		
		ResourceType objResourceType_Page = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Resource objResource_Page = new Resource(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Login objLogin1 = new Login(this.driver1);
		UpdateStatus UpdateStatus_Page1 = new UpdateStatus(
				this.driver1);
		LinksAtTopRightCorners objLinksAtTopRightCorners1 = new LinksAtTopRightCorners(
				this.driver1);
		
		String strResourceValue[] = new String[1];
		String strStatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		
		System.out.println("-----Precondtion execution starts------");

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// RoleBased statustypes

		objStatusTypeList
		.createStatusType(objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.clickCreateNewStatusTypeButton();
		objStatusTypeList.selectStatusType(objStatusTypes_data.strTextStatusType);
		objStatusTypeList.clickNextButton();
		objStatusTypeList.enterStatusTypeName(objStatusTypes_data.strTSTStatusTypeName);
		objStatusTypeList.enterStatusTypeDescription(objStatusTypes_data.strStatusDescription);
		objStatusTypeList.selectExemptFromMustUpdate();
		objStatusTypeList.clickOnSaveButton();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);	
		
		objNavigationToSubMenus.navigateToResourceInSetup();

		// Resource type creation
		objResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource_Page.navigateToResourceListPage()

		.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource_Page
				.getResourceValue(objResource_data.strResourceName);

		objUsersList_page
		.navigateToUsersNew()
		.clickCreateNewUserButton()

		.enterUserDetails(objUserdata.strNewUserName,
				objUserdata.strNewPassword, objUserdata.strFullName)
		.selectUpdateStatusOfResource(objResource_data.strResourceName)
		.selectFirstRole()
		.selectUpdateStatusOfResource(objResource_data.strResourceName)
		.selectViewResourceCheckBox(objResource_data.strResourceName)
		.clickAdvancedOptionAndExpand()
		.selectMustUpdateOverdueStatusOption()
		.clickSaveButton();

		objNavigationToSubmenus.navigateToViews();
		
		String strStatusTypeNames[] = {objStatusTypes_data.strNSTStatusTypeName, objStatusTypes_data.strTSTStatusTypeName};
		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc, objResource_data.strResourceName, strStatusTypeNames);
//		objViewsList.clickCreateNewViewButton()
//		.enterViewName(objView_data.strViewName)
//		.enterViewDesc(objView_data.strViewDesc);
//
//		objViewsList.selectStatusType(objStatusTypes_data.strNSTStatusTypeName);
//		objViewsList.selectStatusType(objStatusTypes_data.strTSTStatusTypeName);
//		
//		objViewsList.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();
		
		objLogin.clickLogOut();
		System.out.println(objUserdata.strNewUserName);
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);
		objRegionDefault1.selectFrame();
			
		objRegionDefault1.verifyUpdateStatusPage();
		
		UpdateStatus_Page1.verifyOverDueStatusIsDisplayed(strStatusTypeValues[0]);
		UpdateStatus_Page1.verifyOverDueStatusIsNotDisplayed(strStatusTypeValues[1]);
		UpdateStatus_Page1.clickOnCancelButton();
		
		
		UpdateStatus_Page1.verifyOverDueStatusIsDisplayed(strStatusTypeValues[0]);
		UpdateStatus_Page1.verifyOverDueStatusIsNotDisplayed(strStatusTypeValues[1]);
		
		objRegionDefault1.verifyUpdateStatusPage();
		
		UpdateStatus_Page1.clickOnRemindMeIn10MinBtn();
		
		objRegionDefault1.verifyRegionDefaultPage();

		objRegionDefault1.verifyUpdateStatusPageNotDisplayed();
		
		// Wait for 10 min
		TimeUnit.MINUTES.sleep(11);

		objLinksAtTopRightCorners1.clickOnRefresh();
		
		objRegionDefault1.verifyUpdateStatusPage();
		
		UpdateStatus_Page1.verifyOverDueStatusIsDisplayed(strStatusTypeValues[0]);
		UpdateStatus_Page1.verifyOverDueStatusIsNotDisplayed(strStatusTypeValues[1]);
	
		objLogin1.clickLogOut();
		gstrResult = "PASS";
	}
}
		
