package requirementGroup.CreatingAndManagingEvents;

import static org.testng.AssertJUnit.assertTrue;
import lib.dataObject.EventSetUp_data;
import lib.dataObject.Event_data;
import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.EventManagement;
import lib.page.EventSetUp;
import lib.page.EventStatus;
import lib.page.Login;
import lib.page.MailVerificationFunctions;
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

public class EdgeCaseEditEvent extends TestNG_UI_EXTENSIONS{

	public EdgeCaseEditEvent() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/*************************************************************************************
	'Description : 	Create a future event from event template in which 'Mandatory address'
	 				is not selected, edit the template and select mandatory address and
	 				 verify that address fields are required when event is opened for editing 
	'Precondition: 
	'Date        : 02-Sep-2014 
	'Author      : Anil
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Create a future event from event template in which 'Mandatory address' "
			+ "is not selected, edit the template and select mandatory address and verify that"
			+ " address fields are required when event is opened for editing")
	public void testEdgeCase117278() throws Exception {

		gstrTCID = "117278";
		gstrTO =  "Create a future event from event template in which 'Mandatory address' "
				+ "is not selected, edit the template and select mandatory address and verify that"
				+ " address fields are required when event is opened for editing";

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
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		
		Resource_data objResource_data = new Resource_data();
		Date_Time_settings objDts = new Date_Time_settings();

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		EventManagement objEventManagement1 = new EventManagement(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
		
		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

			objResourceType.navigateToResourceTypePage();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource
				.clickOnCreateNewResourceButton()
				.enterResourceName(objResource_data.strResourceName)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strResourceTypeName)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton().clickOnViewResChkBox().clickOnSaveButton();

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.clickOncreateEventTemplate()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition);

		for (int intCount = 0; intCount < strResourceTypeValue.length; intCount++) {
			objEventSetUp.selectResourceType(strResourceTypeValue[intCount]);
		}

		for (int intCount = 0; intCount < strStatusTypeValues.length; intCount++) {
			objEventSetUp.selectStatusType(strStatusTypeValues[intCount]);
		}
		objEventSetUp.clickSaveButton()
		.deselectSelectAllWebOption()
		.verEveTemplateInList(objEventSetUp_data.strEventTemplate);
		
		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption().clickSaveButton();
		
		System.out.println(objUserdata.strNewUserName);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame().verifyRegionDefaultPage();

		objEventManagement1
				.navigateToEventManagement()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue);
			
		String strEventStartTime = objEventManagement1
				.getEventStartDateAndTime();

		objEvent_data.strEventStartTime = objDts.converDateFormat(
				strEventStartTime, "yyyy-MMM-dd HH:mm", "yyyy-MM-dd HH:mm");

		objEvent_data.strGetEventStartTime = objDts
				.AddTimeToExistingTimeHourAndMin(
						objEvent_data.strEventStartTime, 0, 10,
						"yyyy-MM-dd HH:mm");

		String strEventStartTimeTime = objDts.converDateFormat(
				objEvent_data.strGetEventStartTime, "yyyy-MM-dd HH:mm",
				"yyyy MMM dd HH mm");

		String strStartTime[] = strEventStartTimeTime.split(" ");

		objEventManagement1.selectEventStartDateAndTime(strStartTime);
		
		objEventManagement1.clickOnSaveButton();
		
		objEventManagement1.verifyEventName(objEvent_data.strEventName);
		
		objEventSetUp1.navigateToEventSetUp();

		objEventSetUp1.clickOnEditTempLink(objEventSetUp_data.strEventTemplate);
		
		objEventSetUp1.selMandatoryAddInCreateTemplatePage();

		objEventSetUp1.clickSaveButton();
		
		objEventManagement1.navigateToEventManagementNew();
		
		objEventManagement1
				.clickOnEditLink(objEvent_data.strEventName)
				.verAddressFieldsAreMandatory()
				.enterAddress(objEventSetUp_data.strCity,
						objEventSetUp_data.strState,
						objEventSetUp_data.strCountry,
						objEventSetUp_data.strZipCode)
				.clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

	/*************************************************************************************
	'Description : Create a future event from event template in which 'Mandatory address' 
					is selected, edit the template and deselect mandatory address and verify 
					that address fields are not required when event is opened for editing
	'Precondition: 
	'Date        : 02-Sep-2014 
	'Author      : Anil
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Create a future event from event template in which"
			+ " 'Mandatory address' is selected, edit the template and "
			+ "deselect mandatory address and verify that address fields"
			+ " are not required when event is opened for editing")
	public void testEdgeCase117279() throws Exception {

		gstrTCID = "117279";
		gstrTO =  "Create a future event from event template in which"
				+ " 'Mandatory address' is selected, edit the template and "
				+ "deselect mandatory address and verify that address fields"
				+ " are not required when event is opened for editing";

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
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		
		Resource_data objResource_data = new Resource_data();
		Date_Time_settings objDts = new Date_Time_settings();

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		EventManagement objEventManagement1 = new EventManagement(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
		
		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

			objResourceType.navigateToResourceTypePage();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource
				.clickOnCreateNewResourceButton()
				.enterResourceName(objResource_data.strResourceName)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strResourceTypeName)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton().clickOnViewResChkBox().clickOnSaveButton();

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.clickOncreateEventTemplate()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.selMandatoryAddInCreateTemplatePage()
				
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition);

		for (int intCount = 0; intCount < strResourceTypeValue.length; intCount++) {
			objEventSetUp.selectResourceType(strResourceTypeValue[intCount]);
		}

		for (int intCount = 0; intCount < strStatusTypeValues.length; intCount++) {
			objEventSetUp.selectStatusType(strStatusTypeValues[intCount]);
		}
		objEventSetUp.clickSaveButton()
		.deselectSelectAllWebOption()
		.verEveTemplateInList(objEventSetUp_data.strEventTemplate);
		
		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption().clickSaveButton();
		
		System.out.println(objUserdata.strNewUserName);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame().verifyRegionDefaultPage();

		objEventManagement1
				.navigateToEventManagement()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue);
			
		String strEventStartTime = objEventManagement1
				.getEventStartDateAndTime();

		objEvent_data.strEventStartTime = objDts.converDateFormat(
				strEventStartTime, "yyyy-MMM-dd HH:mm", "yyyy-MM-dd HH:mm");

		objEvent_data.strGetEventStartTime = objDts
				.AddTimeToExistingTimeHourAndMin(
						objEvent_data.strEventStartTime, 0, 10,
						"yyyy-MM-dd HH:mm");

		String strEventStartTimeTime = objDts.converDateFormat(
				objEvent_data.strGetEventStartTime, "yyyy-MM-dd HH:mm",
				"yyyy MMM dd HH mm");

		String strStartTime[] = strEventStartTimeTime.split(" ");

		objEventManagement1.selectEventStartDateAndTime(strStartTime);
		objEventManagement1.verAddressFieldsAreMandatory()
							.enterAddress(objEventSetUp_data.strCity,
									objEventSetUp_data.strState,
									objEventSetUp_data.strCountry,
									objEventSetUp_data.strZipCode);
									
		objEventManagement1.clickOnSaveButton();
		
		objEventManagement1.verifyEventName(objEvent_data.strEventName);
		
		objEventSetUp1.navigateToEventSetUp();

		objEventSetUp1.clickOnEditTempLink(objEventSetUp_data.strEventTemplate);
		
		objEventSetUp1.deselMandatoryAddInCreateTemplatePage();

		objEventSetUp1.clickSaveButton();
		
		objEventManagement1.navigateToEventManagementNew();
		
		objEventManagement1
				.clickOnEditLink(objEvent_data.strEventName)
				.verAddressFieldsAreNotMandatory()
				.clickOnCancelButton()
				.verifyEventName(objEvent_data.strEventName);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description :  Edit the title of the event and verify that user who edited the event
	 title is displayed in the Event notification received for a user.
	'Precondition: 
	'Date : 19-Aug-2014 
	'Author : Anil
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Edit the title of the event and verify that user"
			+ " who edited the event title is displayed in the Event"
			+ " notification received for a user.")
	public void testEdgeCase117336() throws Exception {

		gstrTCID = "117336";
		gstrTO =  "Edit the title of the event and verify that user"
				+ " who edited the event title is displayed in the Event"
				+ " notification received for a user.";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		Resource_data objResource_data = new Resource_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		
		Login objLogin = new Login(this.driver1);
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
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
				
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		
		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
		
		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

			objResourceType.navigateToResourceTypePage();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource
				.clickOnCreateNewResourceButton()
				.enterResourceName(objResource_data.strResourceName)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strResourceTypeName)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton().clickOnViewResChkBox().clickOnSaveButton();

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);
		
		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId)
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption().clickSaveButton();
		
		System.out.println(objUserdata.strNewUserName);

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.clickOncreateEventTemplate()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition);

		for (int intCount = 0; intCount < strResourceTypeValue.length; intCount++) {
			objEventSetUp.selectResourceType(strResourceTypeValue[intCount]);
		}

		for (int intCount = 0; intCount < strStatusTypeValues.length; intCount++) {
			objEventSetUp.selectStatusType(strStatusTypeValues[intCount]);
		}
		objEventSetUp.clickSaveButton()
		.deselectSelectAllWebOptionOnly()
		.clickOnEmailNotification(objUserdata.strNewUserName, true)
		.clickOnPagerNotification(objUserdata.strNewUserName, true)
		.clickOnWebNotification(objUserdata.strNewUserName, true)
		.clickSaveButton()
		.verEveTemplateInList(objEventSetUp_data.strEventTemplate);
		
		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame().verifyRegionDefaultPage();

		objEventManagement1
				.navigateToEventManagement()
				.creatEvent(objEventSetUp_data.strEventTemplate, objEvent_data.strEventName, objEvent_data.strEventDescription, strResourceValue[0]);

		objEventManagement1
				.verWebNotificationframe()
				.verWebNotificationAndAcknowledge(objEvent_data.strEventName,
						objEvent_data.strEventDescription)
				.clickAcknowledgeAllNotifications().selectFrame();
		
		objEventManagement1
		.clickOnEditLink(objEvent_data.strEventName)
		.enterAdHocEventName(objEvent_data.strEditedEventName);
		objEventManagement1.clickOnSaveButton();

		objEventManagement1
		.verWebNotificationframe()
		.verWebNotificationAndAcknowledge(objEvent_data.strUpdatedEditEventName,
				objEvent_data.strEventDescription)
		.clickAcknowledgeAllNotifications().selectFrame();
		
		objEventManagement1.verUpdateInEveBanner(objEvent_data.strUpdatedEditEventName);
		
		objLogin1.clickLogOut();

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		String strMsgBody1 = objMailVerificationFunctions.getEventEmailBody(objUserdata.strFullName, objUserdata.strFullName,
				objLogindata.strRegionName, objEvent_data.strEventDescription);
		
	
		String strMsgBody2 = objMailVerificationFunctions.getEventPagerBody(objUserdata.strFullName,
				objLogindata.strRegionName, objEvent_data.strEventDescription);
		
		objMailVerificationFunctions.NavToInbox(objEvent_data.strUpdatedEditEventName);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;

		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					objEvent_data.strUpdatedEditEventName);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody1);
			}

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody2);
			}
			objMailVerificationFunctions.backToMailInbox();

		}
		assertTrue(blnMsg1 && blnMsg2);

		objMailVerificationFunctions.logoutMail();
		
		gstrResult = "PASS";
	}

	/*************************************************************************************
	'Description :  Edit the title of the event and verify that user who edited the event
	 title is displayed in the Event notification received for a user.
	'Precondition: 
	'Date : 19-Aug-2014 
	'Author : Anil
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Edit both the title and information of an event"
			+ " and verify that user who edited the event is displayed "
			+ "in the Event notification received for a user. ")
	public void testEdgeCase117338() throws Exception {

		gstrTCID = "117338";
		gstrTO =  "Edit both the title and information of an event"
				+ " and verify that user who edited the event is displayed "
				+ "in the Event notification received for a user. ";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		Resource_data objResource_data = new Resource_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		
		Login objLogin = new Login(this.driver1);
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
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
				
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		
		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
		
		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

			objResourceType.navigateToResourceTypePage();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource
				.clickOnCreateNewResourceButton()
				.enterResourceName(objResource_data.strResourceName)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strResourceTypeName)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton().clickOnViewResChkBox().clickOnSaveButton();

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);
		
		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId)
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption().clickSaveButton();
		
		System.out.println(objUserdata.strNewUserName);

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.clickOncreateEventTemplate()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition);

		for (int intCount = 0; intCount < strResourceTypeValue.length; intCount++) {
			objEventSetUp.selectResourceType(strResourceTypeValue[intCount]);
		}

		for (int intCount = 0; intCount < strStatusTypeValues.length; intCount++) {
			objEventSetUp.selectStatusType(strStatusTypeValues[intCount]);
		}
		objEventSetUp.clickSaveButton()
		.deselectSelectAllWebOptionOnly()
		.clickOnEmailNotification(objUserdata.strNewUserName, true)
		.clickOnPagerNotification(objUserdata.strNewUserName, true)
		.clickOnWebNotification(objUserdata.strNewUserName, true)
		.clickSaveButton()
		.verEveTemplateInList(objEventSetUp_data.strEventTemplate);
		
		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame().verifyRegionDefaultPage();

		objEventManagement1
				.navigateToEventManagement()
				.creatEvent(objEventSetUp_data.strEventTemplate, objEvent_data.strEventName, objEvent_data.strEventDescription, strResourceValue[0]);

		objEventManagement1
				.verWebNotificationframe()
				.verWebNotificationAndAcknowledge(objEvent_data.strEventName,
						objEvent_data.strEventDescription)
				.clickAcknowledgeAllNotifications().selectFrame();
		
		objEventManagement1
		.clickOnEditLink(objEvent_data.strEventName)
		.enterAdHocEventName(objEvent_data.strEditedEventName);
		objEventManagement1.enterAdHocEventDescription(objEvent_data.strEditedEventDescription);
		objEventManagement1.clickOnSaveButton();

		objEventManagement1
		.verWebNotificationframe()
		.verWebNotificationAndAcknowledge(objEvent_data.strUpdatedEditEventName,
				objEvent_data.strEditedEventDescription)
		.clickAcknowledgeAllNotifications().selectFrame();
		
		objEventManagement1.verUpdateInEveBanner(objEvent_data.strUpdatedEditEventName);
		
		objLogin1.clickLogOut();

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		String strMsgBody1 = objMailVerificationFunctions.getEventEmailBody(objUserdata.strFullName, objUserdata.strFullName,
				objLogindata.strRegionName, objEvent_data.strEditedEventDescription);
		
	
		String strMsgBody2 = objMailVerificationFunctions.getEventPagerBody(objUserdata.strFullName,
				objLogindata.strRegionName, objEvent_data.strEditedEventDescription);
		
		objMailVerificationFunctions.NavToInbox(objEvent_data.strUpdatedEditEventName);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;

		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					objEvent_data.strUpdatedEditEventName);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody1);
			}

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody2);
			}
			objMailVerificationFunctions.backToMailInbox();

		}
		assertTrue(blnMsg1 && blnMsg2);


		objMailVerificationFunctions.logoutMail();
		
		gstrResult = "PASS";
	}

	/*************************************************************************************
	'Description : 	Edit the information for an event and verify that user who edited the 
					information of an event is displayed in the Event notification received for a user. 
	'Precondition: 
	'Date : 19-Aug-2014 
	'Author : Anil
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = " Edit the information for an event and verify"
			+ " that user who edited the information of an event is "
			+ "displayed in the Event notification received for a user. ")
	public void testEdgeCase117337() throws Exception {

		gstrTCID = "117337";
		gstrTO =  " Edit the information for an event and verify"
				+ " that user who edited the information of an event is "
				+ "displayed in the Event notification received for a user. ";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		Resource_data objResource_data = new Resource_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		
		Login objLogin = new Login(this.driver1);
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
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
				
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		
		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
		
		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

			objResourceType.navigateToResourceTypePage();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource
				.clickOnCreateNewResourceButton()
				.enterResourceName(objResource_data.strResourceName)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strResourceTypeName)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton().clickOnViewResChkBox().clickOnSaveButton();

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);
		
		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterAllUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName,
						objUserdata.strFirstName, objUserdata.strMiddleName,
						objUserdata.strLastName, objUserdata.strOrganization,
						objUserdata.strPhone, objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId,
						objUserdata.strPrimaryMailId)
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption().clickSaveButton();
		
		System.out.println(objUserdata.strNewUserName);

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.clickOncreateEventTemplate()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition);

		for (int intCount = 0; intCount < strResourceTypeValue.length; intCount++) {
			objEventSetUp.selectResourceType(strResourceTypeValue[intCount]);
		}

		for (int intCount = 0; intCount < strStatusTypeValues.length; intCount++) {
			objEventSetUp.selectStatusType(strStatusTypeValues[intCount]);
		}
		objEventSetUp.clickSaveButton()
		.deselectSelectAllWebOptionOnly()
		.clickOnEmailNotification(objUserdata.strNewUserName, true)
		.clickOnPagerNotification(objUserdata.strNewUserName, true)
		.clickOnWebNotification(objUserdata.strNewUserName, true)
		.clickSaveButton()
		.verEveTemplateInList(objEventSetUp_data.strEventTemplate);
		
		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame().verifyRegionDefaultPage();

		objEventManagement1
				.navigateToEventManagement()
				.creatEvent(objEventSetUp_data.strEventTemplate, objEvent_data.strEventName, objEvent_data.strEventDescription, strResourceValue[0]);

		objEventManagement1
				.verWebNotificationframe()
				.verWebNotificationAndAcknowledge(objEvent_data.strEventName,
						objEvent_data.strEventDescription)
				.clickAcknowledgeAllNotifications().selectFrame();
		
		objEventManagement1
		.clickOnEditLink(objEvent_data.strEventName);
		objEventManagement1.enterAdHocEventDescription(objEvent_data.strEditedEventDescription);
		objEventManagement1.clickOnSaveButton();

		objEventManagement1
		.verWebNotificationframe()
		.verWebNotificationAndAcknowledge(objEvent_data.strUpdateEventName,
				objEvent_data.strEditedEventDescription)
		.clickAcknowledgeAllNotifications().selectFrame();
		
		objEventManagement1.verUpdateInEveBanner(objEvent_data.strUpdateEventName);
		
		objLogin1.clickLogOut();

		objMailVerificationFunctions.loginToMail(objUserdata.strPrimaryMailId,
				objUserdata.strPrimaryPwsd);

		String strMsgBody1 = objMailVerificationFunctions.getEventEmailBody(objUserdata.strFullName, objUserdata.strFullName,
				objLogindata.strRegionName, objEvent_data.strEditedEventDescription);
		
	
		String strMsgBody2 = objMailVerificationFunctions.getEventPagerBody(objUserdata.strFullName,
				objLogindata.strRegionName, objEvent_data.strEditedEventDescription);
		
		objMailVerificationFunctions.NavToInbox(objEvent_data.strUpdateEventName);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;

		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(objUserdata.strPrimaryMailId,
					objEvent_data.strUpdateEventName);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailContainsBody(strMsgBody1);
			}

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody2);
			}
			objMailVerificationFunctions.backToMailInbox();

		}
		assertTrue(blnMsg1 && blnMsg2);


		objMailVerificationFunctions.logoutMail();
		
		gstrResult = "PASS";
	}

	/*************************************************************************************
	'Description : 	Create an event providin address via a template for which ‘Mandatory Address’
	 				was not selected and verify that address is not displayed on the event banner
	 				 for that event even after ‘Mandatory Address’ is selected for that template. 
	'Precondition: 
	'Date        : 02-Sep-2014 
	'Author      : Anil
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Create an event providin address via a template "
			+ "for which ‘Mandatory Address’ was not selected and verify "
			+ "that address is not displayed on the event banner for that"
			+ " event even after ‘Mandatory Address’ is selected for that template. ")
	public void testEdgeCase118982() throws Exception {

		gstrTCID = "118982";
		gstrTO =  "Create an event providin address via a template "
				+ "for which ‘Mandatory Address’ was not selected and verify "
				+ "that address is not displayed on the event banner for that"
				+ " event even after ‘Mandatory Address’ is selected for that template. ";


		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		
		Login objLogin = new Login(this.driver1);
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
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		
		Resource_data objResource_data = new Resource_data();

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		
		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
		
		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

			objResourceType.navigateToResourceTypePage();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource
				.clickOnCreateNewResourceButton()
				.enterResourceName(objResource_data.strResourceName)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strResourceTypeName)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton().clickOnViewResChkBox().clickOnSaveButton();

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.clickOncreateEventTemplate()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition);

		for (int intCount = 0; intCount < strResourceTypeValue.length; intCount++) {
			objEventSetUp.selectResourceType(strResourceTypeValue[intCount]);
		}

		for (int intCount = 0; intCount < strStatusTypeValues.length; intCount++) {
			objEventSetUp.selectStatusType(strStatusTypeValues[intCount]);
		}
		objEventSetUp.clickSaveButton()
		.deselectSelectAllWebOption()
		.verEveTemplateInList(objEventSetUp_data.strEventTemplate);
		
		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption().clickSaveButton();
		
		System.out.println(objUserdata.strNewUserName);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1
				.navigateToEventManagement()
				.creatEvent(objEventSetUp_data.strEventTemplate, objEvent_data.strEventName, objEvent_data.strEventDescription, strResourceValue[0]);
		
		objEventManagement1.verifyEventName(objEvent_data.strEventName);
		
		objEventManagement1.clickOnEventNameInEventBanner(objEvent_data.strEventName);
		
		objEventStatus1.verifyAddressIsNotDisplayedInEventBanner(objEventSetUp_data.strCity,
				objEventSetUp_data.strCountry,
				objEventSetUp_data.strZipCode,
				objEventSetUp_data.strCountrycode);
		
		objEventSetUp1.navigateToEventSetUp();

		objEventSetUp1.clickOnEditTempLink(objEventSetUp_data.strEventTemplate);
		
		objEventSetUp1.selMandatoryAddInCreateTemplatePage();

		objEventSetUp1.clickSaveButton();
		
		objEventManagement1.navigateToEventManagementNew();
		
		objEventManagement1
				.clickOnEditLink(objEvent_data.strEventName)
				.verAddressFieldsAreNotMandatory()
				.clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);

		objEventManagement1.clickOnEventNameInEventBanner(objEvent_data.strEventName);
		
		objEventStatus1.verifyAddressIsNotDisplayedInEventBanner(objEventSetUp_data.strCity,
				objEventSetUp_data.strCountry,
				objEventSetUp_data.strZipCode,
				objEventSetUp_data.strCountrycode);
		
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

	/*************************************************************************************
	'Description : Create an event selecting a template for which ‘Mandatory Address’ was 
					selected and verify that address is retained on the event banner for 
					the event even after ‘Mandatory Address’ is deselected for that template. 
	'Precondition: 
	'Date        : 02-Sep-2014 
	'Author      : Anil
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Create an event selecting a template for which "
			+ "‘Mandatory Address’ was selected and verify that address is "
			+ "retained on the event banner for the event even after "
			+ "‘Mandatory Address’ is deselected for that template.")
	public void testEdgeCase118983() throws Exception {

		gstrTCID = "118983";
		gstrTO =  "Create an event selecting a template for which "
				+ "‘Mandatory Address’ was selected and verify that address is "
				+ "retained on the event banner for the event even after "
				+ "‘Mandatory Address’ is deselected for that template.";


		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		
		Login objLogin = new Login(this.driver1);
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
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		
		Resource_data objResource_data = new Resource_data();

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		
		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
		
		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

			objResourceType.navigateToResourceTypePage();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource
				.clickOnCreateNewResourceButton()
				.enterResourceName(objResource_data.strResourceName)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strResourceTypeName)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(objResource_data.strResourceFirstName)
				.enterResourceLastName(objResource_data.strResourceLastName)
				.clickOnSaveButton().clickOnViewResChkBox().clickOnSaveButton();

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.clickOncreateEventTemplate()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition)
				.selMandatoryAddInCreateTemplatePage();

		for (int intCount = 0; intCount < strResourceTypeValue.length; intCount++) {
			objEventSetUp.selectResourceType(strResourceTypeValue[intCount]);
		}

		for (int intCount = 0; intCount < strStatusTypeValues.length; intCount++) {
			objEventSetUp.selectStatusType(strStatusTypeValues[intCount]);
		}
		objEventSetUp.clickSaveButton()
		.deselectSelectAllWebOption()
		.verEveTemplateInList(objEventSetUp_data.strEventTemplate);
		
		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption().clickSaveButton();
		
		System.out.println(objUserdata.strNewUserName);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1
				.navigateToEventManagement()
		.clickOnCreateNewEvent()
		.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
		.enterAdHocEventName(objEvent_data.strEventName)
		.enterAdHocEventDescription(objEvent_data.strEventDescription)
		.selectResource( strResourceValue[0])
		.verAddressFieldsAreMandatory()
		.enterAddress(objEventSetUp_data.strCity,
						objEventSetUp_data.strState,
						objEventSetUp_data.strCountry,
						objEventSetUp_data.strZipCode)					
		.clickOnSaveButton();
		
		objEventManagement1.verifyEventName(objEvent_data.strEventName);
		
		String strEventStartDateAndTime = objEventManagement1
				.getEventStartTime(objEvent_data.strEventName);
		
		objEventManagement1.clickOnEventNameInEventBanner(objEvent_data.strEventName);
		
		objEventStatus1.verifyCreatedByDescAndAdd(objUserdata.strFullName,
				strEventStartDateAndTime,
				objEvent_data.strEventDescription,
				objEventSetUp_data.strCity,
				objEventSetUp_data.strCountry,
				objEventSetUp_data.strZipCode,objEventSetUp_data.strCountrycode);
		
		objEventSetUp1.navigateToEventSetUp();

		objEventSetUp1.clickOnEditTempLink(objEventSetUp_data.strEventTemplate);
		
		objEventSetUp1.deselMandatoryAddInCreateTemplatePage();

		objEventSetUp1.clickSaveButton();
		
		objEventManagement1.navigateToEventManagementNew();
		
		objEventManagement1
				.clickOnEditLink(objEvent_data.strEventName)
				.verAddressFieldsAreMandatory()
				.clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);
		
		objEventManagement1.clickOnEventNameInEventBanner(objEvent_data.strEventName);
		
		objEventStatus1.verifyCreatedByDescAndAdd(objUserdata.strFullName,
				strEventStartDateAndTime,
				objEvent_data.strEventDescription,
				objEventSetUp_data.strCity,
				objEventSetUp_data.strCountry,
				objEventSetUp_data.strZipCode,objEventSetUp_data.strCountrycode);
		
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	'Description : Verify that updated address is displayed when user edits the address 
				   provided for an event created selecting a template with ‘Mandatory Address’
	'Precondition: 
	'Date        : 15-Mar-2016 
	'Author      : Pallavi
	'-------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	********************************************************************/
	@Test(description = "Verify that updated address is displayed when user "
			+ "edits the address provided for an event created selecting a "
			+ "template with ‘Mandatory Address’")
	public void testEdgeCase118984() throws Exception {

		gstrTCID = "118984";
		gstrTO =  "Verify that updated address is displayed when "
				+ "user edits the address provided for an event created "
				+ "selecting a template with ‘Mandatory Address’";

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
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		
		Resource_data objResource_data = new Resource_data();

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		EventManagement objEventManagement1 = new EventManagement(this.driver1);

		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
		
		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

			objResourceType.navigateToResourceTypePage();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource
				.clickOnCreateNewResourceButton()
				.enterResourceName(objResource_data.strResourceName)
				.enterResourceAbbrivation(
						objResource_data.strResourceAbbrivation)
				.selectResourceTypename(
						objResourceType_data.strResourceTypeName)
				.selectStandardResourceTypename(
						objResource_data.strStandardResourceTypename)
				.enterResourceFirstName(
						objResource_data.strResourceFirstName)
				.enterResourceLastName(
						objResource_data.strResourceLastName)
				.clickOnSaveButton()
				.clickOnViewResChkBox()
				.clickOnSaveButton();

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.clickOncreateEventTemplate()
				.enterEventTemplateName(
						objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition);

		for (int intCount = 0; intCount < strResourceTypeValue.length; intCount++) {
			objEventSetUp.selectResourceType(strResourceTypeValue[intCount]);
		}

		for (int intCount = 0; intCount < strStatusTypeValues.length; intCount++) {
			objEventSetUp.selectStatusType(strStatusTypeValues[intCount]);
		}
		
		objEventSetUp.selMandatoryAddInCreateTemplatePage()
					 .clickSaveButton()
					 .deselectSelectAllWebOption()
					 .verEveTemplateInList(
							 objEventSetUp_data.strEventTemplate);
		
		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption()
				.clickSaveButton();
		
		System.out.println(objUserdata.strNewUserName);

		objLogin.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame().verifyRegionDefaultPage();

		objEventManagement1
				.navigateToEventManagement()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.verAddressFieldsAreMandatory()
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue)
				.enterAddress(objEventSetUp_data.strCity,
						objEventSetUp_data.strState,
						objEventSetUp_data.strCountry,
						objEventSetUp_data.strZipCode);
			
		objEventManagement1.clickOnSaveButton();
		
		objEventManagement1.verifyEventName(objEvent_data.strEventName);
		
		String strEventStartDateAndTime = objEventManagement1
				.getEventStartTime(objEvent_data.strEventName);
		
		objEventManagement1.clickOnEventNameInEventBanner(
								   objEvent_data.strEventName)
						   .verifyCreatedByDescAndAdd(objUserdata.strFullName,
									strEventStartDateAndTime,
									objEvent_data.strEventDescription,
									objEventSetUp_data.strCity,
									objEventSetUp_data.strCountry,
									objEventSetUp_data.strZipCode,
									objEventSetUp_data.strCountrycode);
		
		objEventManagement1.navigateToEventManagement();
		
		objEventManagement1
				.clickOnEditLink(objEvent_data.strEventName)
				.verAddressFieldsAreMandatory()
				.enterAddress(objEventSetUp_data.strEditCity,
						objEventSetUp_data.strEditState,
						objEventSetUp_data.strEditCounty,
						objEventSetUp_data.strEditZipCode)
				.clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName)
				.clickOnEventNameInEventBanner(
								   objEvent_data.strEventName)
				.verifyCreatedByDescAndAdd(objUserdata.strFullName,
									strEventStartDateAndTime,
									objEvent_data.strEventDescription,
									objEventSetUp_data.strEditCity,
									objEventSetUp_data.strEditCounty,
									objEventSetUp_data.strEditZipCode,
									objEventSetUp_data.strEditCountrycode);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*******************************************************************************************************************
	 * Description	: Edit the title/information of multi region event and verify that user who edited the event 
	 * 				  title/information is displayed in the Event notification received for a user.
	 * Date			: 15-Mar-2016
	 * Author		: Pallavi
	 ********************************************************************************************************************/
	@Test(description = "Edit the title/information of multi region event and"
			+ " verify that user who edited the event title/information is "
			+ "displayed in the Event notification received for a user.")
	public void testEdgeCase117564() throws Exception {
		
		gstrTCID = "117564";
		gstrTO	 = "Edit the title/information of multi region event and "
				+ "verify that user who edited the event title/information "
				+ "is displayed in the Event notification received for a user.";

		Login_data objTest_data = new Login_data();
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);
		String strRegionValue[] = new String[2];
		String strRegionNames[] = new String[2];

		String strFilePath = Login_data.strTestDataPath;
		
		strRegionNames[0] = objOffCommonFunc.readInfoExcel("MultiRegionEvent",
				2, 2, strFilePath);
		strRegionNames[1] = objOffCommonFunc.readInfoExcel("MultiRegionEvent",
				2, 3, strFilePath);
		
		strRegionValue[0] = objOffCommonFunc.readInfoExcel("MultiRegionEvent",
				3, 2, strFilePath);
		strRegionValue[1] = objOffCommonFunc.readInfoExcel("MultiRegionEvent",
				3, 3, strFilePath);

		String strResourceName = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 16, strFilePath);
		String strResourceName1 = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 17, strFilePath);

		String strEventTemplate = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 18, strFilePath);
		String strEventTemplate1 = objOffCommonFunc.readInfoExcel(
				"MultiRegionEvent", 2, 19, strFilePath);
		
		String strstatusTypeNames[] = new String[10];
		
		String strAllStatusTypeNames[] = new String[5];
		
		String strAllStatusTypeNames1[] = new String[5];

		for (int intCount = 0; intCount < 10; intCount++) {
			strstatusTypeNames[intCount] = objOffCommonFunc.readInfoExcel(
					"MultiRegionEvent", 2, 4 + intCount, strFilePath);
		}

		for (int intCount = 0; intCount < 5; intCount++) {
			strAllStatusTypeNames[intCount] = objOffCommonFunc.readInfoExcel(
					"MultiRegionEvent", 2, 4 + intCount, strFilePath);
		}
		
		for (int intCount = 0; intCount < 5; intCount++) {
			strAllStatusTypeNames1[intCount] = objOffCommonFunc.readInfoExcel(
					"MultiRegionEvent", 2, 9 + intCount, strFilePath);
		}

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(strRegionNames[0]);

		RegionDefault_page.selectFrame();
		
		// User creation
		UsersList_page
		.navigateToUsers()
		.clickCreateNewUserButton()
		.enterUserDetails(objUser_data.strNewUserName,
				objUser_data.strNewPassword, objUser_data.strFullName)
		.selectFirstRole()
		.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
		.enterEmail(objUser_data.strPrimaryMailId)
		.entertextPagerId(objUser_data.strPrimaryMailId)
		.selectUpdateStatusOfResource(strResourceName)
		.clickAdvancedOptionAndExpand()
		.selectMaintainEventsOption()
		.clickSaveButton()
		.searchUserName(objUser_data.strNewUserName,
				objUser_data.strRole, objUser_data.strResourceType,
				objUser_data.strUsername, objUser_data.strsearchOption)
		.clickRegionsLinkForUser(objUser_data.strNewUserName)
		.selectRegion(strRegionValue[1])
		.clickSaveButton();

		RegionDefault_page.clickRegionLink();

		SelectRegion_page.selectRegionAndNavigate(strRegionNames[1]);

		RegionDefault_page.selectFrame();

		UsersList_page
				.navigateToUsers()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(strResourceName1)
				.selectViewResourceRights(strResourceName1)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName)
				.clickMultiRegionEventRights()
				.verifyEditMultiRegionEventRights()
				.verifyRegionName(strRegionValue[0])
				.verifyRegionName(strRegionValue[1])
				.verifySaveButton()
				.selectUserRegion(strRegionValue[0])
				.selectUserRegion(strRegionValue[1])
				.clickSaveButton()
				.verifyEditUserPageIsDisplayed()
				.clickSaveButton()
				.verifyUserListPageIsDisplayed();
		
		System.out.println(objUser_data.strNewUserName);
		System.out.println(strEventTemplate1);
		System.out.println(strEventTemplate);
		
		objEventSetUp.navigateToEventSetUp();
		
		objEventSetUp.clickOnNotificationsLinkOfET(
							strEventTemplate1)
					 .deselectSelectAllWebOptionOnly()
					 .deselectSelectAllEmailOption()
					 .deselectSelectAllPagerOption()
					 .clickOnEmailCheckBox(
						objUser_data.strNewUserName)
					 .clickOnPagerCheckBox(
						objUser_data.strNewUserName)
					 .clickOnWebCheckBox(
							 objUser_data.strNewUserName)
					 .clickSaveButton();

		SelectRegion_page.selectRegionAndNavigate(strRegionNames[0]);

		RegionDefault_page.selectFrame();
		
		objEventSetUp.navigateToEventSetUp();
		
		objEventSetUp.clickOnNotificationsLinkOfET(
							strEventTemplate)
					 .deselectSelectAllWebOptionOnly()
					 .deselectSelectAllEmailOption()
					 .deselectSelectAllPagerOption()
					 .clickOnEmailCheckBox(
						objUser_data.strNewUserName)
					 .clickOnPagerCheckBox(
						objUser_data.strNewUserName)
					 .clickOnWebCheckBox(
						objUser_data.strNewUserName)
					 .clickSaveButton();
		
		login_page.clickLogOut();
		
		System.out
		.println("-----Precondition ends and test execution starts-------");
		
		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		SelectRegion_page1
				.selectRegionAndNavigate(strRegionNames[0]);

		RegionDefault_page1.selectFrame();

		EventManagement_page1
				.navigateToEventManagement()
				.createNewMultiEventButton()
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(
						objEvent_data.strEventDescription)
				.selectEventTemplateForMRE(strRegionValue[0],
						strEventTemplate)
				.selectEventTemplateForMRE(strRegionValue[1],
						strEventTemplate1)
				.clickOnNextButton()
				.verifyMultiRegionEventConfirmationPage()
				.verifyConfirmationMessage()
				.clickOnYesButton()
				.verWebNotificationframe()
				.verWebNotificationAndAcknowledge(objEvent_data.strEventName,
						objEvent_data.strEventDescription)
				.clickAcknowledgeAllNotifications();
				
		RegionDefault_page1.switchToDefaultFrame().selectFrame();
		
		EventManagement_page1
				.verifyEventName(objEvent_data.strEventName)
				.clickOnEditLink(objEvent_data.strEventName)
				.enterAdHocEventName(objEvent_data.strEditedEventName)
				.enterAdHocEventDescription(
						objEvent_data.strEditedEventDescription)
				.clickOnNextButton()
				.clickOnNextButton()
				.clickOnNextButton()
				.verifyMultiRegionEventConfirmationPage()
				.clickOnYesButton()
				.verWebNotificationframe()
				.verWebNotificationAndAcknowledge(objEvent_data.strUpdatedEditEventName,
						objEvent_data.strEditedEventDescription)
				.clickAcknowledgeAllNotifications();
		
		RegionDefault_page1.switchToDefaultFrame().selectFrame();
		
		EventManagement_page1
		.verifyEventName(objEvent_data.strEditedEventName);
		
		String strSubject = objEvent_data.strUpdatedEditEventName;
		
		String strEmailMessage = objMailVerificationFunctions
				.getEmailBodyForMRE(objUser_data.strFullName,
						objUser_data.strFullName, strRegionNames[0],
						strRegionNames[1], objEvent_data.strEditedEventDescription);
		
		String strPagerMessage = objMailVerificationFunctions
				.getPagerBodyForMRE(objUser_data.strFullName,
						strRegionNames[0], strRegionNames[1],
						objEvent_data.strEditedEventDescription);
		
		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId,
				objUser_data.strPrimaryPwsd);

		objMailVerificationFunctions.NavToInbox(strSubject);

		boolean blnMsg1 = false;
		boolean blnMsg2 = false;

		for (int intCount = 0; intCount < 2; intCount++) {

			objMailVerificationFunctions.verEmail(
					objUser_data.strPrimaryMailId, strSubject);

			if (blnMsg1 == false) {
				blnMsg1 = objMailVerificationFunctions
						.verifyMailContainsBody(strEmailMessage);
			}

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailContainsBody(strPagerMessage);
			}
			objMailVerificationFunctions.backToMailInbox();
		}

		assertTrue(blnMsg1 && blnMsg2);

		objMailVerificationFunctions.logoutMail();
		
		gstrResult = "PASS";
	}
}
