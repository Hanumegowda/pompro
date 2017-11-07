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

public class NewCreateStatusReason extends TestNG_UI_EXTENSIONS {

	public NewCreateStatusReason() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/*************************************************************************************
	'Description : Verify that a status reason can be created and can be made mandatory for a status. 
	'Precondition:
	'Date	 	 : 27-May-2015
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that a status reason can be created and can be made mandatory for a status.")
	public void testHappyDay68890() throws Exception {

		gstrTCID = "68890";
		gstrTO = "Verify that a status reason can be created and can be made mandatory for a status.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		StatusReason_data objStatusReason_data = new StatusReason_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		View_data objView_data = new View_data();

		Login objLogin = new Login(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		StatusReasonList objStatusReasonList1 = new StatusReasonList(
				this.driver1);
		StatusTypeList objStatusTypeList1 = new StatusTypeList(this.driver1);
		ResourceType objResourceType_Page1 = new ResourceType(this.driver1);
		Resource objResource_Page1 = new Resource(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strResourceValue[] = new String[1];
		String strStatusesValues[] = new String[1];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectSetupStatusTypesOption().selectSetupStatusReasonOption()
				.selectSetupResourceTypesOption().selectSetupResourceOption()
				.selectConfigureRegionViewsOption()
				.selectConfigureRegionalUserAccessOption().clickSaveButton();

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToStatusReasons();
		
		objStatusReasonList1
				.clickOnCreateStatusReason()
				.enterReasonName(objStatusReason_data.strReasonName)
				.enterReasonDesc(objStatusReason_data.strReasonDesc)
				.enterReasonAbb(objStatusReason_data.strReasonAbb)
				.verDisplayReasonInCommentSectionOptionSelected()
				.clickOnSave()
				.verStatusReasonInList(objStatusReason_data.strReasonName,
						objStatusReason_data.strReasonAbb,
						objStatusReason_data.strReasonDesc);

		String strReasonVal = objStatusReasonList1
				.getStatusReasonVal(objStatusReason_data.strReasonName);

		objStatusTypeList1
				.navigateToStatusTypeListNew()
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti);

		strStatusesValues[0] = objStatusTypeList1
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);

		objStatusTypeList1
			  .createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
			      objStatusTypes_data.strStatusColor)
			  .verCreatedStatusInStatusListForMulti(
			      objStatusTypes_data.strStatusNameInMulti1)
			.clickOnReturnToStatusTypeList();
		
		strStatusTypeValues[0] = objStatusTypeList1
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);
		
		objStatusTypeList1.clickOnEditOfStatusType(
						objStatusTypes_data.strMSTStatusTypeName)
				.selectStatusReason(strReasonVal)
				.clickOnSaveButton()
				.clickOnStatusesOfStatusType(
						objStatusTypes_data.strMSTStatusTypeName)
				.editStatusForMultiStatusType(
						objStatusTypes_data.strStatusNameInMulti)
				.selectStatusReasonForStatus(strReasonVal)
				.selectStatusReasonRequired().clickOnSaveButton();

		// Resource type creation
		objNavigationToSubmenus1.navigateToResourceTypesInSetup();

		objResourceType_Page1.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		// Resource creation
		objNavigationToSubmenus1.navigateToResourceInSetup();

		objResource_Page1.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource_Page1
				.getResourceValue(objResource_data.strResourceName);

		objResource_Page1
				.selectUsersLinkInResourceList(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objUserdata.strNewUserName)
				.clickOnSaveButton();

		objNavigationToSubmenus1.navigateToViews();

		String[] strAllStatausTypes = { objStatusTypes_data.strMSTStatusTypeName };

		objViewsList1.createView(objView_data.strViewName, objView_data.strViewDesc, 
									objResource_data.strResourceName, strAllStatausTypes);
		
//		objViewsList1.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);
//
//		for (int i = 0; i < strAllStatausTypes.length; i++) {
//
//			objViewsList1.selectStatusType(strAllStatausTypes[i]);
//		}
//
//		objViewsList1.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView()
//				.verViewInList(objView_data.strViewName);

		objLogin1.clickLogOut();

		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus1
				.selectMSTUpdateValue(strStatusTypeValues[0],
						strStatusesValues[0])
				.verStatusReasonInstruction(
						objStatusTypes_data.strStatusNameInMulti)
				.selectMSTUpdateValue(strStatusTypeValues[0],
						strStatusesValues[0])
				.clickOnSaveButton()
				.verErrorWhenStatusReasonNotSelected(
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusNameInMulti)
				.selectMSTReasonValue(strReasonVal, strStatusTypeValues[0],
						strStatusesValues[0])
				.enterComments(strStatusTypeValues[0], objView_data.strComment)
				.clickOnSaveButton();

		objUpdateStatus1.verifyUpdatedStatusValues(strResourceValue[0],
				strStatusTypeValues[0],
				objStatusTypes_data.strStatusNameInMulti);

		String strComments = objStatusReason_data.strReasonName + ", "
				+ objView_data.strComment;

		objUpdateStatus1
				.verifyUpdatedComments(strResourceValue[0], strComments);

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}

}
