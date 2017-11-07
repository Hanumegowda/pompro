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
import lib.page.FormConfiguration;
import lib.page.Login;
import lib.page.Map;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.Roles;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UpdateStatus;
import lib.page.UsersList;
import lib.page.Views;
import lib.page.ViewsList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewHappyDayEditSaturationStatusType extends TestNG_UI_EXTENSIONS {

	public NewHappyDayEditSaturationStatusType() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/*************************************************************************************
	'Description : Verify that a saturation score status type can be edited.
	'Precondition:
	'Date	 	 : 26-May-2015
	'Author		 : Pallavi
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that a saturation score status type can be edited.")
	public void testHappyDay99002() throws Exception {

		gstrTCID = "99002";
		gstrTO = "Verify that a saturation score status type can be edited.";

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
		EventManagement objEventManagementPage = new EventManagement(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		StatusTypeList objStatusTypeList1 = new StatusTypeList(this.driver1);
		ResourceType objResourceType1 = new ResourceType(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		Roles objRoles1 = new Roles(this.driver1);
		EventManagement objEventManagementPage1 = new EventManagement(this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);
		CustomUnderView objCustomUnderView1 = new CustomUnderView(this.driver1);
		Views objViews1 = new Views(this.driver1);
		Map objMap1 = new Map(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectSetupStatusTypesOption()
				.selectViewcustomViewOption()
				.selectMaintainEventsOption()
				.clickSaveButton();
		
		objUsersList
		.clickCreateNewUserButton()
		.enterUserDetails(objUserdata.strNewUserName1,
				objUserdata.strNewPassword, objUserdata.strFullName1)
		.selectFirstRole()
		.clickAdvancedOptionAndExpand()
		.selectMaintainEventsOption()
		.clickSaveButton();
		
		System.out.println(objUserdata.strNewUserName);
		System.out.println(objView_data.strSectionName);
		
		objNavigationToSubmenus.navigateToViews();

		objViewsList.createNewSection(objView_data.strSectionName);
		
		objLogin.clickLogOut()
				.loginAsNewUser(objUserdata.strNewUserName,
						objUserdata.strNewPassword);
		
		objRegionDefault.selectFrame();
		
		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList
		.createStatusTypeWithSection(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objLogin.clickLogOut()
				.loginToApplication(objLogindata.strUserName,
						objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToResourceTypesInSetup();
		
		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource.navigateToResourceListPage()
				   .createResourceWithAddress(
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

		objUsersList.enterUsernameInSearchInputField(objUserdata.strNewUserName)
					.clickSearchButton()
					.editUserDetails(objUserdata.strNewUserName)
					.selectViewResourceRights(
							objResource_data.strResourceName)
					.selectUpdateStatusOfResource(
							objResource_data.strResourceName)
					.clickSaveButton();

		objNavigationToSubmenus.navigateToViews();

//		objViewsList.clickCreateNewViewButton()
//					.enterViewName(objView_data.strViewName)
//					.enterViewDesc(objView_data.strViewDesc);
//
//		objViewsList.selectStatusType(objStatusTypes_data.strSSTStatusTypeName)
//					.selectResource(objResource_data.strResourceName)
//					.clickOnSaveOfCreateNewView();

		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc,
								objResource_data.strResourceName, objStatusTypes_data.strSSTStatusTypeName);
		
		// create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
								objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
								strStatusTypeValues)
					 .deselectSelectAllWebOption();		
		
		objLogin.clickLogOut();
		
		objLogin.loginAsNewUser(objUserdata.strNewUserName1,
						objUserdata.strNewPassword);
		
		objRegionDefault.selectFrame();
		
		objEventManagementPage.navigateToEventManagement()
						      .clickOnCreateNewEvent()
						      .clickOnCreateEvent(
						    		  objEventSetUp_data.strEventTemplate)
						      .enterAdHocEventName(
						    		  objEvent_data.strEventName)
						      .enterAdHocEventDescription(
						    		  objEvent_data.strEventDescription)
						      .selectResource(strResourceValue)
						      .clickOnSaveButton();
		
		objLogin.clickLogOut();
		
		objLogin1.loginToApplication(objUserdata.strNewUserName,
						objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.clickOnViewMenu()
								.navigateToParticularViewUnderViewMenu(
										objView_data.strViewName);
		
		objViewsList1.clickOnStatusHeader(strStatusTypeValues[0]);
		
		objRegionDefault1.verWebNotificationframe();
		
		objViewsList1.verifyNameAndDefinitionOnDefnScreen(objStatusTypes_data.strSSTStatusTypeName,
	 			objStatusTypes_data.strStatusDescription);
		
		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objNavigationToSubmenus1.clickOnSnooze();

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus1.verifyStatusNameAndDefinitionUpdateStatusScreen(
							strStatusTypeValues[0], objStatusTypes_data.strSSTStatusTypeName,
							objStatusTypes_data.strStatusDescription)
						.enterUpdateSSTValues(strStatusTypeValues[0],
								objView_data.strValueForSST)
						.clickOnSaveButton()
						.verifyUpdatedStatusValues(strResourceValue[0],
								strStatusTypeValues[0],
								objView_data.strUpdatedValForSST);
		
		objNavigationToSubmenus1.navigateToCustomInView();
		
		objCustomUnderView1.clickOnSetupCustomViewLink()
						   .clickOnAddMoreResources()
						   .enterResNameInWhatField(
								   objResource_data.strResourceName)
						   .clickOnSearch()
						   .selectResource(strResourceValue)
						   .clickOnAddToCustomView()
						   .clickOnOptions()
						   .selectStatusTypes(strStatusTypeValues)
						   .selectAllChkBoxInOptions()
						   .clickOnSave();
		
		objLogin1.clickLogOut()
				 .loginToApplication(objLogindata.strUserName,
							objLogindata.strPassword);

		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();
		
		objStatusTypeList1.navigateToStatusTypeList();
		
		objStatusTypeList1
				.clickOnEditOfStatusType(
						objStatusTypes_data.strSSTStatusTypeName)
				.enterStatusTypeName(
						"Edt" + objStatusTypes_data.strSSTStatusTypeName)
				.enterStatusTypeDescription(
						"Edt" + objStatusTypes_data.strStatusDescription)
				.clickOnSaveButton();

		System.out.println("Edt" + objStatusTypes_data.strSSTStatusTypeName);

		objNavigationToSubmenus1.navigateToViews();

		objViewsList1.clickCreateNewViewButton()
					 .enterViewName(objView_data.strViewName2)
					 .enterViewDesc(objView_data.strViewDesc)
					 .clickNextButton()
					 .selectRegionName(objLogindata.strRegionName)
					 .clickNextButton()
					 .selectResource(objResource_data.strResourceName)
					 .clickNextButton()
					 .verifyStatusTypeUnderSelectSTSection("Edt" + 
							 objStatusTypes_data.strSSTStatusTypeName)
					 .clickOnCancelButton()
					 .clickOncustomizeResourceDetailView()
					 .clickOnSection(objView_data.strSectionName)
					 .verStatusTypesInList("Edt" + 
							 objStatusTypes_data.strSSTStatusTypeName, 
							 strStatusTypeValues[0]);
		
		objNavigationToSubmenus1.navigateToResourceTypesInSetup();
		
		objResourceType1.clickOnCreateNewResourceTypeButton()
						.verifyStatusTypeIsRetrieved(
								"Edt" + objStatusTypes_data.strSSTStatusTypeName,
								objStatusTypes_data.strSaturationScoreStatusType);
		
		objNavigationToSubmenus1.navigateToResourceInSetup();
		
		objResource1.clickOnStatusTypeLinkInResourcePage(
							objResource_data.strResourceName)
					.verifyStatusTypeIsDisplayedUnderEditResLevelST(
							"Edt" + objStatusTypes_data.strSSTStatusTypeName);
		
		objNavigationToSubmenus1.navigateToRoles();
		
		objRoles1.clickOnCreateNewRoleBtn()
				 .verifyStatusTypeNameWithUpdateAndViewRightChkBox("Edt" + 
							 objStatusTypes_data.strSSTStatusTypeName);
		
		objEventManagementPage1.clickOnEventNameInEventBanner(objEvent_data.strEventName)
							   .verStatusTypes(objResourceType_data.strResourceTypeName, 
									   "Edt" + objStatusTypes_data.strSSTStatusTypeName);
		
		String[] arrStatusTypeName = { "Edt" + objStatusTypes_data.strSSTStatusTypeName };
	
		
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
				.selectFormActivation(objFormConfiguration_data.strAsCertainStatusChanges)
				.clickOnNextButton()
				.verifyStatusTypeIsDisplayed("Edt" 
								+ objStatusTypes_data.strSSTStatusTypeName);
		
		objEventSetUp1.navigateToEventSetUp();

		objEventSetUp1.clickOncreateEventTemplate()
					 .enterEventTemplateName(objEventSetUp_data.strEventTemplate)
					 .verifyStatusTypeIsDispInCreateNewEventTemp(
							 "Edt" + objStatusTypes_data.strSSTStatusTypeName);
		
		objLogin1.clickLogOut()
				 .loginToApplication(objUserdata.strNewUserName,
						objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
		objEventManagementPage1.navigateToEventManagement()
		   .clickOnEditLink(objEvent_data.strEventName)
		   .verifyStatusTypesNameInSelectStausTypePage(arrStatusTypeName)
		   .verifyStatusTypeIsSelectedAndChecked(strStatusTypeValues);
		
		objNavigationToSubmenus1.clickOnViewMenu()
								.navigateToParticularViewUnderViewMenu(
										objView_data.strViewName);

		objViewsList1.clickOnStatusHeader(strStatusTypeValues[0]);
		
		objRegionDefault1.verWebNotificationframe();
		
		objViewsList1.verifyNameAndDefinitionOnDefnScreen("Edt" + objStatusTypes_data.strSSTStatusTypeName,
										objStatusTypes_data.strStatusDescription);
		
		objRegionDefault1.switchToDefaultFrame().selectFrame();

		objNavigationToSubmenus1.clickOnSnooze();
		
		objViewsList1.clickOnResourceAndNavigateToResourceDetail(objResource_data.strResourceName)
					 .verifyStatusTypeUnderSectionsInResourceDetailPage("Edt" + objStatusTypes_data.strSSTStatusTypeName,
							 	objView_data.strSectionName);
		
		objNavigationToSubmenus1.navigateToCustomInView();
		
		objCustomUnderView1.verStatusTypeInCustomViewTablePage(arrStatusTypeName);
		
		objViews1.clickOnCustomizeLink();
		
		objCustomUnderView1.clickOnOptions()
						   .verifySTAndSecAreDispUnderEdtCustomViewPage(objView_data.strSectionName,
								   	"Edt" + objStatusTypes_data.strSSTStatusTypeName);
		
		objNavigationToSubmenus1.navigateToMap();
		
		objMap1.selectResourceNameInFindResourceDropdown(
						objResource_data.strResourceName)
			   .verStatusTypesInPopupWindow(arrStatusTypeName);
		
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
}
