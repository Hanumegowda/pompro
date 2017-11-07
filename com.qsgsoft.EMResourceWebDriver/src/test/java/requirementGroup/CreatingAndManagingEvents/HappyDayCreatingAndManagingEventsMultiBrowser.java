package requirementGroup.CreatingAndManagingEvents;

import lib.dataObject.EventSetUp_data;
import lib.dataObject.Event_data;
import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.UpdateStatus_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.NavigationToSubMenus;
import lib.page.EventManagement;
import lib.page.EventSetUp;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UpdateStatus;
import lib.page.UsersList;
import lib.page.ViewsList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSThreeBrowser;

public class HappyDayCreatingAndManagingEventsMultiBrowser extends TestNG_UI_EXTENSIONSThreeBrowser {
	
	public HappyDayCreatingAndManagingEventsMultiBrowser() throws Exception {
		super();
	}
	
	/***********************************************************************************
	 * 'Description :Validation message 'The following status types were not updated because
	                the associated event has ended: < status type name >' is displayed when user
	                saves the update status screen of a resource which contains event only status types.  
	 * 'Date      	:06-Feb-2015 
	 * 'Author      :Hanumegowda
	 ************************************************************************************/
	@Test(description = "Validation message 'The following status types were not updated because"
			+ "the associated event has ended: < status type name >' is displayed when user"
			+ "saves the update status screen of a resource which contains event only status types.")
	public void HappyDay152554() throws Exception {
		gstrTCID = "152554";
		gstrTO = "Validation message 'The following status types were not updated because"
				+ "the associated event has ended: < status type name >' is displayed when user"
				+ "saves the update status screen of a resource which contains event only status types.";
		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		Login objLogin = new Login(this.driver1);
		Login objLogin1 = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		String strstatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strStatusesValues[] = new String[1];
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Login objLogin2 = new Login(this.driver2);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		EventManagement objEventManagement2 = new EventManagement(this.driver2);
		RegionDefault objRegionDefault2 = new RegionDefault(this.driver2);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		UpdateStatus_data objUpdateStatus_data = new UpdateStatus_data();
		View_data objView_data = new View_data();

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);
		objRegionDefault1.selectFrame();

		objNavigationToSubMenus.navigateToViews();
		objViewsList.clickOncustomizeResourceDetailView()
				.enterSectionName(objView_data.strSectionName)
				.clickOnCreateSection().clickOnSaveButton();

		objStatusTypeList.navigateToStatusTypeListNew();

		// RoleBased statustypes
		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createEventStatusTypeWithSection(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strMultiStatusType,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);
		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti,
				objStatusTypes_data.strStatusColor);

		strStatusesValues[0] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti);
		
		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,						objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
		.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1)
        .clickOnReturnToStatusTypeList();
		
		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createEventStatusTypeWithSection(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createEventStatusTypeWithSection(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);
		Thread.sleep(10000);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		// User1 creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals)
		.clickCreateNewUserButton()
		.enterUserDetails(objUser_data.strNewUserName1,
				objUser_data.strNewPassword, objUser_data.strFullName1)
		.selectFirstRole()
		.clickAdvancedOptionAndExpand()
		.selectMaintainEventsOption()
		.clickSaveButton();
		// create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objESetUp_data.strEventTemplate,
				objESetUp_data.strTemplateDefinition, strResourceTypeValue,
				strstatusTypeValues);
		objEventSetUp.deselectSelectAllWebOption();

		System.out.println("templet " + objESetUp_data.strEventTemplate);
		objLogin.clickLogOut();
		
		
		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		objRegionDefault.selectFrame();
		
		objEventManagement1.navigateToEventManagement()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objESetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue[0]).clickOnSaveButton();

		objEventManagement1.clickOnEventNameInEventBanner(
				objEvent_data.strEventName).clickOnUpdateStatusKey(
				objResource_data.strResourceName);
		objUpdateStatus1
				.clickOnSelectAll()
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[0],
						objUpdateStatus_data.strNSTUpdateValue)
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[2],
						objUpdateStatus_data.strNSTUpdateValue)
				.enterNedocsUpdateValue(strstatusTypeValues[1],
						objUpdateStatus_data.strNDSTUpdateValue)
				.enterUpdateSSTValues(strstatusTypeValues[4],
						objUpdateStatus_data.strSSTUpdateValue)
				.selectMSTUpdateValue(strstatusTypeValues[3],
						strStatusesValues[0])
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[5],
						objView_data.strDateUpdateValue);
		objLogin2.loginAsNewUser(objUser_data.strNewUserName1,
				objUser_data.strNewPassword);
		objRegionDefault2.selectFrame();
		objEventManagement2.navigateToEventManagement().clickOnEndEvent(
				objEvent_data.strEventName);
		objLogin2.clickLogOut();
		objUpdateStatus1.clickOnSaveButton().verifyValidateMessage();
		objLogin1.clickLogOut();
		gstrResult = "PASS";

	}

}


