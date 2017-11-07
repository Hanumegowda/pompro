package requirementGroup.CreatingAndManagingEvents;

import lib.dataObject.EventSetUp_data;
import lib.dataObject.Event_data;
import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.page.EventManagement;
import lib.page.EventSetUp;
import lib.page.EventStatus;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewEditEventTemplate extends TestNG_UI_EXTENSIONS{

	public NewEditEventTemplate() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/*******************************************************************************************
	'Description 	:  Verify that an event template can be edited.
	'Date 			: 15-June-2014 
	'Author 		: Anil
	'-------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = " Verify that an event template can be edited.")
	public void testHappyDay68110() throws Exception {

		gstrTCID = "68110";
		gstrTO = " Verify that an event template can be edited.";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);
		
		String strStatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		
		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;
		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// RoleBased statustypes
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusType(objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription)
			.createNewStatus(objStatuTypes_data.strStatusNameInMulti,
					objStatuTypes_data.strStatusColor)
			.createNewStatus(objStatuTypes_data.strStatusNameInMulti1, objStatuTypes_data.strStatusColor)
			.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameInMulti)
			.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameInMulti1)
	        .clickOnReturnToStatusTypeList();

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strDateStatusType,
				objStatuTypes_data.strDateStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strDateStatusTypeName);

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

		// User1 creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectMaintainEventTemplateOption()
				.selectMaintainEventsOption()
				.clickSaveButton();

		// create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strStatusTypeValues)				
				.deselectSelectAllWebOptionOnly()
				.clickSaveButton();

		objLogin.clickLogOut();

		System.out
				.println("---------Precondition ends and test execution starts---------");


		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement()
		.clickOnCreateNewEvent()
		.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
		.enterAdHocEventName(objEvent_data.strEventName)
		.enterAdHocEventDescription(objEvent_data.strEventDescription);
		
		objResource1.clickResource(strResourceValue);
		objEventManagement1.clickOnSaveButton()
		.clickOnEventNameInEventBanner(objEvent_data.strEventName);
			
		
		String strStatusTypes[] ={objStatuTypes_data.strNSTStatusTypeName, objStatuTypes_data.strMSTStatusTypeName, objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strTSTStatusTypeName, objStatuTypes_data.strNDSTStatusTypeName, objStatuTypes_data.strDateStatusTypeName};
		
		for (int i = 0; i < strStatusTypes.length; i++) {
			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strStatusTypes[i]);
		}
		
		objEventSetUp1.navigateToEventSetUp();
		objEventSetUp1.clickOnEditTempLink(objEventSetUp_data.strEventTemplate)
						.enterEventTemplateName(objEventSetUp_data.strEDITEventTemplate)
						.enterEventTemplateDefintion(objEventSetUp_data.strEDITemplateDefn)
						.selectETColor(objEventSetUp_data.strETBlueColor)
						.selectETIcon(objEventSetUp_data.strETAmbulance)
						.clickSaveButton()
						.verEveTemplateDescription(objEventSetUp_data.strEDITEventTemplate,
								objEventSetUp_data.strEDITemplateDefn)
						.verEveTemplateIcon(objEventSetUp_data.strEDITEventTemplate,
								objEventSetUp_data.strAmbulanceIcon);
		
		objEventManagement1.navigateToEventManagementNew()
		.clickOnCreateNewEvent()
		.verifyEventTemplateIsDisplayed(objEventSetUp_data.strEDITEventTemplate)
		.verifyEventTemplateDesctiption(objEventSetUp_data.strEDITEventTemplate, objEventSetUp_data.strEDITemplateDefn);
		objEventManagement1.navigateToEventListNew()
		.verifyEventNameAndTemplate(objEvent_data.strEventName, objEventSetUp_data.strEDITEventTemplate)
		.verifyEventColorInEventBanner(objEvent_data.strEventName, objEventSetUp_data.strETBlueColor);
		
		objLogin1.clickLogOut();

		String[] strTestData = {
				Login_data.strBuildName,
				gstrTCID,
				objUser_data.strNewUserName + "/" + objUser_data.strNewPassword,
				objEventSetUp_data.strEDITEventTemplate,
				objEvent_data.strEventName,
				"Verify mobile end condition event colour "+objEventSetUp_data.strETBlueColor+", event template image"+ objEventSetUp_data.strETAmbulance, 
				objStatuTypes_data.strNSTStatusTypeName+", "+objStatuTypes_data.strMSTStatusTypeName+", "+objStatuTypes_data.strSSTStatusTypeName+", "+
				objStatuTypes_data.strTSTStatusTypeName+", "+ objStatuTypes_data.strNDSTStatusTypeName+", "+ objStatuTypes_data.strDateStatusTypeName,
				objResource_data.strResourceName,objResourceType_data.strResourceTypeName,
				objTest_data.strRegionName };

		objOffCommonFunc.writeResultData(strTestData,
				strPartialAutoResultsPath, "Events");

		gstrResult = "PASS";
	}

	/*******************************************************************************************
	'Description 	: Verify that an event template can be re-activated.
	'Date 			: 15-June-2014 
	'Author 		: Anitha
	'-------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = " Verify that an event template can be re-activated.")
	public void testHappyDay68113() throws Exception {

		gstrTCID = "68113";
		gstrTO = " Verify that an event template can be re-activated.";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);
		
		String strStatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
	
		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// RoleBased statustypes
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription)
			.createNewStatus(objStatuTypes_data.strStatusNameInMulti,
					objStatuTypes_data.strStatusColor)
			.createNewStatus(objStatuTypes_data.strStatusNameInMulti1,	objStatuTypes_data.strStatusColor)
			.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameInMulti)
			.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameInMulti1)
	        .clickOnReturnToStatusTypeList();

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strDateStatusType,
				objStatuTypes_data.strDateStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strDateStatusTypeName);

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

		// User1 creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectMaintainEventTemplateOption()
				.selectMaintainEventsOption()
				.clickSaveButton();

		// create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.createEventTemplate(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strTemplateDefinition,
						strResourceTypeValue, strStatusTypeValues)
				.deselectSelectAllWebOptionOnly().clickSaveButton();
		
		objLogin.clickLogOut();

		System.out.println("---------Precondition ends and test execution starts---------");

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objEventManagement1.navigateToEventManagement();
		
		objEventManagement.clickOnCreateNewEvent()
		.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
		.enterAdHocEventName(objEvent_data.strEventName)
		.enterAdHocEventDescription(objEvent_data.strEventDescription);

		objResource.clickResource(strResourceValue);
		
		objEventManagement.clickOnSaveButton();
		
		objEventSetUp1.navigateToEventSetUp();
		
		objEventSetUp1
				.verEveTemplateListScreenIsDisplayed()
				.clickOnEditTempLink(objEventSetUp_data.strEventTemplate)
				.inactiveEveTemplate()
				.clickSaveButton()
				.selectInactiveEventTemplateCheckBox()
				.verifyActionHeader()
				.verEveTemplateInList(objEventSetUp_data.strEventTemplate)
				.verEveTemplateIsActive(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strEventTempDisabled)
						
				.clickOnEditTempLink(objEventSetUp_data.strEventTemplate)
				.activateEveTemplate()
				.clickSaveButton()
				.verEveTemplateInList(objEventSetUp_data.strEventTemplate)
				.verifyActionHeader()
				.verEveTemplateIsActive(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strEventTempActive)
				.deSelectInactiveEventTemplateCheckBox();
		
		objEventManagement1
				.navigateToEventManagementNew()
				.verifyEventName(objEvent_data.strEventName)
				.clickOnCreateNewEvent()
				.verifyEventTemplateIsDisplayed(
						objEventSetUp_data.strEventTemplate);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*******************************************************************************************
	'Description 	: Verify that an event template can be deactivated. 
	'Date 			: 18-Jun-2015 
	'Author 		: Renushree
	'-------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = " Verify that an event template can be deactivated. ")
	public void testHappyDay68112() throws Exception {
		
		gstrTCID = "68112";
		gstrTO = "Verify that an event template can be deactivated. ";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);

		String strStatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;
		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// RoleBased statustypes
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNedocCalculationStatusType,
				objStatuTypes_data.strNDSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusType(objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription)
			.createNewStatus(objStatuTypes_data.strStatusNameInMulti,
					objStatuTypes_data.strStatusColor)
			.createNewStatus(objStatuTypes_data.strStatusNameInMulti1,objStatuTypes_data.strStatusColor)
			.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameInMulti)
			.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameInMulti1)
	        .clickOnReturnToStatusTypeList();

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strSaturationScoreStatusType,
				objStatuTypes_data.strSSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strDateStatusType,
				objStatuTypes_data.strDateStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strDateStatusTypeName);

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

		// User1 creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption().clickSaveButton();

		// create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.createEventTemplate(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strTemplateDefinition,
						strResourceTypeValue, strStatusTypeValues)
				.deselectSelectAllWebOptionOnly().clickSaveButton();


		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objEventManagement1
				.navigateToEventManagement()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.enterAddress(objEventSetUp_data.strCity,
						objEventSetUp_data.strState,
						objEventSetUp_data.strCountry,
						objEventSetUp_data.strZipCode)
				.selectResource(strResourceValue).clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);

		objRegionDefault1.clickOnHomeButton();
		
		objEventSetUp1.navigateToEventSetUp();

		objEventSetUp1
				.clickOnEditTempLink(objEventSetUp_data.strEventTemplate)
				.inactiveEveTemplate()
				.clickSaveButton()
				.verEveTemplateNotInList(objEventSetUp_data.strEventTemplate)
				.selectInactiveEventTemplateCheckBox()
				.verEveTemplateInList(objEventSetUp_data.strEventTemplate)
				.verEveTemplateIsActive(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strEventTempDisabled);

		objEventManagement1.navigateToEventManagementNew()
				.verifyEditEventLink(objEvent_data.strEventName)
				.verifyEndEventLink(objEvent_data.strEventName)
				.clickOnCreateNewEvent()
				.verETNotDisplayad(objEventSetUp_data.strEventTemplate);

		objLogin1.clickLogOut();

		String[] strTestData = {
				Login_data.strBuildName,
				gstrTCID,
				objUser_data.strNewUserName + "/" + objUser_data.strNewPassword,
				objEventSetUp_data.strEventTemplate,
				objEvent_data.strEventName,
				"Verify mobile end condition event name and resource name",
				objStatuTypes_data.strNSTStatusTypeName + ", "
						+ objStatuTypes_data.strMSTStatusTypeName + ", "
						+ objStatuTypes_data.strSSTStatusTypeName + ", "
						+ objStatuTypes_data.strTSTStatusTypeName + ", "
						+ objStatuTypes_data.strNDSTStatusTypeName + ", "
						+ objStatuTypes_data.strDateStatusTypeName,
				objResource_data.strResourceName,
				objResourceType_data.strResourceTypeName,
				objTest_data.strRegionName };

		objOffCommonFunc.writeResultData(strTestData,
				strPartialAutoResultsPath, "Events");

		gstrResult = "PASS";
	}
	
	/*******************************************************************************************
	'Description 	: Edit the event template, select/deselect resource types, status types and verify that the already created events are not affected.
	'Date 			: 15-June-2014 
	'Author 		: Anil
	'-------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Edit the event template, select/deselect resource types, status types and verify that the already created events are not affected.")
	public void testHappyDay68111() throws Exception {

		gstrTCID = "68111";
		gstrTO = "Edit the event template, select/deselect resource types, status types and verify that the already created events are not affected.";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);
		
		String strStatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[2];
		String strResourceValue[] = new String[1];
		String strResourceValue1[] = new String[1];
		
		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;
		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// RoleBased statustypes
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName1,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName1);

		String[] strValue1 = {strStatusTypeValues[0]};
		String[] strValue2 = {strStatusTypeValues[1]};
		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strValue1);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName1, strValue2);

		strResourceTypeValue[1] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName1);
		
		// Resource creation
		objResource.navigateToResourceListPage().createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		// Resource creation
		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName1,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue1[0] = objResource
				.getResourceValue(objResource_data.strResourceName1);
		
		// User1 creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName1)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.selectMaintainEventTemplateOption()
				.clickSaveButton();
System.out.println(objUser_data.strNewUserName);
		// create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.clickOncreateEventTemplate()
		.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
		.enterEventTemplateDefintion(objEventSetUp_data.strTemplateDefinition)
		.selectResourceType(strResourceTypeValue[0])
		.selectStatusType(strStatusTypeValues[0])
		.clickSaveButton()			
		.deselectSelectAllWebOptionOnly()
		.clickSaveButton();


		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objEventManagement1.navigateToEventManagement()
		.clickOnCreateNewEvent()
		.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
		.enterAdHocEventName(objEvent_data.strEventName)
		.enterAdHocEventDescription(objEvent_data.strEventDescription);		
		objResource1.clickResource(strResourceValue);
		objEventManagement1.clickOnSaveButton();
		
		objRegionDefault1.clickOnHomeButton();
		
		System.out
				.println("---------Precondition ends and test execution starts---------");


		Thread.sleep(5000);
		
		objEventSetUp1.navigateToEventSetUp();
		objEventSetUp1.clickOnEditTempLink(objEventSetUp_data.strEventTemplate)
						.deselectResourceType(strResourceTypeValue[0])
						.deselectStatusType(strStatusTypeValues[0])
						.selectResourceType(strResourceTypeValue[1])
						.selectStatusType(strStatusTypeValues[1])
						.clickSaveButton()
						.verEveTemplateDescription(objEventSetUp_data.strEventTemplate,
								objEventSetUp_data.strTemplateDefinition);
	
		objEventManagement1
		.clickOnEventNameInEventBanner(objEvent_data.strEventName);
		
			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					objStatuTypes_data.strNSTStatusTypeName);
		objEventStatus1.verResourceTypeAndResourceName(objResourceType_data.strResourceTypeName, objResource_data.strResourceName);
			

		objEventManagement1.navigateToEventManagement()
		.clickOnCreateNewEvent()
		.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
		.enterAdHocEventName(objEvent_data.strEventName1)
		.enterAdHocEventDescription(objEvent_data.strEventDescription);		
		objResource1.clickResource(strResourceValue1);
		objEventManagement1.clickOnSaveButton();
		
		objEventManagement1
		.clickOnEventNameInEventBanner(objEvent_data.strEventName1);
		
			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName1,
					objStatuTypes_data.strNSTStatusTypeName1);
		objEventStatus1.verResourceTypeAndResourceName(objResourceType_data.strResourceTypeName1, objResource_data.strResourceName1);

		
		objLogin1.clickLogOut();

		String[] strTestData = {
				Login_data.strBuildName,
				gstrTCID,
				objUser_data.strNewUserName + "/" + objUser_data.strNewPassword,
				objEventSetUp_data.strEventTemplate,
				objEvent_data.strEventName+", "+objEvent_data.strEventName1,
				"Verify mobile event1 contains RS1, RT1, ST1 and event2 contains RS2, RT2, ST2", 
				objStatuTypes_data.strNSTStatusTypeName+", "+objStatuTypes_data.strNSTStatusTypeName1,
				objResource_data.strResourceName+", "+objResource_data.strResourceName1,objResourceType_data.strResourceTypeName+", "+objResourceType_data.strResourceTypeName1,
				objTest_data.strRegionName };

		objOffCommonFunc.writeResultData(strTestData,
				strPartialAutoResultsPath, "Events");

		gstrResult = "PASS";
	}
	
	/*******************************************************************************************
	'Description 	:  Verify that event template can be edited and saved by selecting 50 status types 
	'Date 			: 15-June-2014 
	'Author 		: Anil
	'-------------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************************************/
	@Test(description = "Verify that event template can be edited and saved by selecting 50 status types ")
	public void testHappyDay162664() throws Exception {

		gstrTCID = "162664";
		gstrTO = "Verify that event template can be edited and saved by selecting 50 status types ";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Date_Time_settings objDate_Time_settings = new Date_Time_settings();
		String strTimeText = objDate_Time_settings.getCurrentDate("MM/dd/yyyy-hhmmss");
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		
		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceTypeValue1[] = new String[1];

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();
		
		int intCount = objStatusTypeList.getStatusTypeCount();
		
		if(intCount<50){
			
			for(int intCount1 = 0; intCount1<(50-intCount); intCount++){
				String strNSTStatusTypeName = "NST1" +intCount1+ strTimeText;
				objStatusTypeList.createStatusType(
						objStatuTypes_data.strNumberStatusType,
						strNSTStatusTypeName,
						objStatuTypes_data.strStatusDescription);
			}
		}
	
		String strStatusTypeValues1[] = new String[50];
		String strStatusTypeNames[] = objStatusTypeList
				.getStatusTypeNames(50);
		for(int intCount1 = 0; intCount1<50; intCount1++){
			strStatusTypeValues1[intCount1] = objStatusTypeList
					.getStatusValue(strStatusTypeNames[intCount1]);
	}
	
		// RoleBased statustypes
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

	
		// Resource type creation
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName1, strStatusTypeValues1);

		strResourceTypeValue1[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName1);

		
		// Resource type creation
		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);


		// create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strStatusTypeValues)				
				.deselectSelectAllWebOptionOnly()
				.clickSaveButton();

		objLogin.clickLogOut();

		System.out
				.println("---------Precondition ends and test execution starts---------");


		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault1.selectFrame();
		
		objSelectRegion1.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();

		// create Event template
		objEventSetUp1.navigateToEventSetUp();
		Thread.sleep(3000);
		objEventSetUp1.clickOnEditTempLink(objEventSetUp_data.strEventTemplate)
		.selectResourceType(strResourceTypeValue1[0]);
		
		for(int intCount1=0; intCount1<strStatusTypeValues1.length-1;intCount1++){
			objEventSetUp1.selectStatusType(strStatusTypeValues1[intCount1]);
		}
		
		objEventSetUp1.verifySelectedStatusTypeCount("50");
		objEventSetUp1.clickSaveButton();
		
		objEventSetUp1.verifyEventTempName(objEventSetUp_data.strEventTemplate);
		
		objLogin1.clickLogOut();
		gstrResult = "PASS";
	}

}
