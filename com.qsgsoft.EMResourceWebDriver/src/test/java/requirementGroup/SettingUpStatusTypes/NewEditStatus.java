package requirementGroup.SettingUpStatusTypes;

import lib.dataObject.EventSetUp_data;
import lib.dataObject.Event_data;
import lib.dataObject.FormConfigeration_data;
import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.NavigationToSubMenus;
import lib.page.CustomUnderView;
import lib.page.EventManagement;
import lib.page.EventSetUp;
import lib.page.EventStatus;
import lib.page.FormConfiguration;
import lib.page.Login;
import lib.page.Map;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UpdateStatus;
import lib.page.UsersList;
import lib.page.ViewsList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewEditStatus extends TestNG_UI_EXTENSIONS {

	public NewEditStatus() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/*************************************************************************************
	'Description : Verify that a status can be edited. 
	'Precondition:
	'Date	 	 : 28-May-2015
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that a status can be edited. ")
	public void testHappyDay84453() throws Exception {

		gstrTCID = "84453";
		gstrTO = "Verify that a status can be edited. ";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		View_data objView_data = new View_data();
		Resource_data objResource_data = new Resource_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();

		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		EventManagement objEventManagementPage = new EventManagement(
				this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		StatusTypeList objStatusTypeList1 = new StatusTypeList(this.driver1);
		EventManagement objEventManagementPage1 = new EventManagement(
				this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);
		Map objMap1 = new Map(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strStatusesValues[] = new String[2];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		System.out.println(objView_data.strSectionName);

		objNavigationToSubmenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);

		objStatusTypeList.navigateToStatusTypeListNew();

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

		objStatusTypeList.createNewStatus(
				objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor);

		strStatusesValues[1] = objStatusTypeList
				.getStatusesValue(objStatusTypes_data.strStatusNameInMulti1);

		objStatusTypeList.navigateToStatusTypeListNew();

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

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

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectViewcustomViewOption()
				.selectMaintainEventsOption()
				.selectFormUserMayActivateAndModifyFormsOption()
				.selectConfigureRegionalUserAccessOption().clickSaveButton();

		System.out.println(objUserdata.strNewUserName);
		objNavigationToSubmenus.navigateToViews();

		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc,
							objResource_data.strResourceName, objStatusTypes_data.strMSTStatusTypeName);
//		
//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc);
//
//		objViewsList.selectStatusType(objStatusTypes_data.strMSTStatusTypeName)
//				.selectResource(objResource_data.strResourceName)
//				.clickOnSaveOfCreateNewView();

		// create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strStatusTypeValues).deselectSelectAllWebOption();


		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objEventManagementPage1.navigateToEventManagement()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue).clickOnSaveButton();

		objNavigationToSubmenus1
				.clickOnViewMenu()
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1.clickOnStatusHeader(strStatusTypeValues[0]);

		objRegionDefault1.verWebNotificationframe();

		objViewsList1.verifyNameAndDefinitionOnDefnScreen(
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objNavigationToSubmenus1.clickOnSnooze();

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus1
				.verifyStatusNameAndDefinitionUpdateStatusScreen(
						strStatusTypeValues[0],
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.selectMSTUpdateValue(strStatusTypeValues[0],
						strStatusesValues[0])
				.clickOnSaveButton()
				.verifyUpdatedStatusValues(strResourceValue[0],
						strStatusTypeValues[0],
						objStatusTypes_data.strStatusNameInMulti);

		objNavigationToSubmenus1.navigateToCustomInView();

		objCustomUnderView1.clickOnSetupCustomViewLink()
				.clickOnAddMoreResources()
				.enterResNameInWhatField(objResource_data.strResourceName)
				.clickOnSearch().selectResource(strResourceValue)
				.clickOnAddToCustomView().clickOnOptions()
				.selectStatusTypes(strStatusTypeValues).clickOnSave();

		System.out.println(objLogindata.strUserName);

		objLogin1.clickLogOut().loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objStatusTypeList1.navigateToStatusTypeList();

		objStatusTypeList1
				.clickOnStatusesOfStatusType(
						objStatusTypes_data.strMSTStatusTypeName)
				.editStatusForMultiStatusType(
						objStatusTypes_data.strStatusNameInMulti)
				.enterStatusName(objStatusTypes_data.strEdStatusNameInMulti)
				.clickOnSaveButton();
		objStatusTypeList1
				.verCreatedStatusInStatusListForMulti(objStatusTypes_data.strEdStatusNameInMulti);

		System.out.println(objStatusTypes_data.strEdStatusNameInMulti);
		System.out.println(objView_data.strViewName);
		
		objLogin1.loginToApplication(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1
				.clickOnViewMenu()
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1.clickOnStatusHeader(strStatusTypeValues[0]);

		objRegionDefault1.verWebNotificationframe();

		objViewsList1.verifyNameAndStatusesOnDefnScreen(
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strEdStatusNameInMulti);

		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objNavigationToSubmenus1.clickOnSnooze();

		objViewsList1.clickOnResourceAndNavigateToResourceDetail(
				objResource_data.strResourceName)
				.verifyStatuessInResourceDetailPage(
						objStatusTypes_data.strMSTStatusTypeName,
						objView_data.strSectionName,
						objStatusTypes_data.strEdStatusNameInMulti);

		objNavigationToSubmenus1.navigateToMap();

		objMap1.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName).verUpdateValuesInPopupWindow(
				objStatusTypes_data.strEdStatusNameInMulti);

		objEventManagementPage1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1.verifyUpdatedStatus(objResource_data.strResourceName,
				objStatusTypes_data.strEdStatusNameInMulti);

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.verFormConfigurePage()
				.createNewFormTempltete()
				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strFormName,
						objFormConfiguration_data.strDiscriptiveName)
				.selectOptionInFormActivationDropDown(
						objFormConfiguration_data.strFormActivatnUIOTFO)
				.selCompletedFormDelivery(
						objFormConfiguration_data.strComptdFormDelvry)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaWeb)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaEmail)
				.selHowToNotify(objFormConfiguration_data.strNotifyViaPager)
				.selectFormActivation(
						objFormConfiguration_data.strAsCertainStatusChanges)
				.clickOnNextButton()
				.verifyStatusesIsDisplayed(
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strEdStatusNameInMulti);

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strCustom);

		objCustomUnderView1.verifyUpdatedStatusValues(strResourceValue[0],
				strStatusTypeValues[0],
				objStatusTypes_data.strEdStatusNameInMulti);
		
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
}
