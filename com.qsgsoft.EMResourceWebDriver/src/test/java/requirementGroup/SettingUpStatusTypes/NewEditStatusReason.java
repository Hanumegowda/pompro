package requirementGroup.SettingUpStatusTypes;

import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusReason_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.NavigationToSubMenus;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusReasonList;
import lib.page.StatusTypeList;
import lib.page.UpdateStatus;
import lib.page.UsersList;
import lib.page.ViewsList;
import org.testng.annotations.Test;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewEditStatusReason extends TestNG_UI_EXTENSIONS{

	public NewEditStatusReason() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/******************************************************************************
	'Description : Verify that user can edit a status reason.
	'Date	 	 : 27-May-2015
	'Author		 : Anitha
	'------------------------------------------------------------------------------
	'Modified Date			                        	          Modified By
	'Date					                                      Name
	*******************************************************************************/
	@Test(description = "Verify that user can edit a status reason.")
	public void testHappyDay68940() throws Exception {

		gstrTCID = "68940";
		gstrTO = "Verify that user can edit a status reason.";

		Login_data objLogindata = new Login_data();
		User_data objUser_data = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		View_data objView_data = new View_data();
		StatusReason_data objStatusReason_data = new StatusReason_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		Resource Resource_page = new Resource(this.driver1);
		StatusReasonList objStatusReasonList = new StatusReasonList(this.driver1);
		ResourceType ResourceType_page = new ResourceType(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		StatusReasonList objStatusReasonList1 = new StatusReasonList(
				this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strStatusesValues[] = new String[1];
		String strResourceValue[] = new String[1];
		String strResourceTypeValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusReasons();

		objStatusReasonList.createStatusReason(
				objStatusReason_data.strReasonName,
				objStatusReason_data.strReasonDesc,
				objStatusReason_data.strReasonAbb);

		String strReasonVal = objStatusReasonList
				.getStatusReasonVal(objStatusReason_data.strReasonName);

		objStatusTypeList.navigateToStatusTypeListNew();

		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(objStatusTypes_data.strMultiStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strMSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription)
				.selectStatusReason(strReasonVal).clickOnSaveButton();

		objStatusTypeList.clickOnCreateNewStatus()
				.enterStatusName(objStatusTypes_data.strStatusNameInMulti)
				.selectStatusColor(objStatusTypes_data.strStatusColor)
				.selectStatusReasonForStatus(strReasonVal).clickOnSaveButton()
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
				      objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
				      objStatusTypes_data.strStatusNameInMulti1);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList.clickOnReturnToStatusTypeList();

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		ResourceType_page.navigateToResourceTypePage();

		ResourceType_page.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = ResourceType_page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		Resource_page.navigateToResourceListPage();

		Resource_page.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation2,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = Resource_page
				.getResourceValue(objResource_data.strResourceName);

		objNavigationToSubmenus.navigateToViews();

		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc,
								objResource_data.strResourceName, objStatusTypes_data.strMSTStatusTypeName);
		
//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);
//
//		objViewsList.selectStatusType(objStatusTypes_data.strMSTStatusTypeName);
//
//		objViewsList.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();

		System.out.println(objResource_data.strResourceName);

		objNavigationToSubmenus.navigateToUsers();

		UsersList_page
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		objLogin.clickLogOut();

		System.out.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1.clickOnIndividualUpdateStatus(strResourceValue[0],
				strStatusTypeValues[0]);

		objUpdateStatus1
				.verUpdateStatusPge()
				.selectMSTUpdateValue(strStatusTypeValues[0],
						strStatusesValues[0])
				.selectMSTReasonValue(strReasonVal, strStatusTypeValues[0],
						strStatusesValues[0]).clickOnSaveButton()
				.verifyUpdatedStatusreason(objStatusReason_data.strReasonName);

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault1.selectFrame();

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToStatusReasons();

		objStatusReasonList1
				.clickOnEditStatusReason(objStatusReason_data.strReasonName)
				.enterReasonName(objStatusReason_data.strEditReasonName)
		        .enterReasonDesc(objStatusReason_data.strEditReasonDesc)
		        .clickOnSave()
				.verCreatedStatusReasonInList(
						objStatusReason_data.strEditReasonName);

		objLogin1.clickLogOut();
		
		objLogin1.loginToApplication(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);
		
		objViewsList1.clickOnIndividualUpdateStatus(strResourceValue[0],
				strStatusTypeValues[0]);
		
		objUpdateStatus1
				.verifyUpdatedSRInUpadteStatusPage(
						objStatusReason_data.strEditReasonName,
						objStatusReason_data.strEditReasonDesc)
				.selectMSTReasonValue(strReasonVal, strStatusTypeValues[0],
						strStatusesValues[0])
				.clickOnSaveButton()

				.verifyUpdatedStatusreason(
						objStatusReason_data.strEditReasonName);

		gstrResult = "PASS";
	}
}
