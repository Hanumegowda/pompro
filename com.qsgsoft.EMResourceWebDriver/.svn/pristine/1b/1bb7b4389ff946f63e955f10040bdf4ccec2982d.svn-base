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
import lib.page.Map;
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

public class EdgeCaseCreateEvent extends TestNG_UI_EXTENSIONS{

	public EdgeCaseCreateEvent() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/*****************************************************************************
	'Description	: Verify that user can cancel the process of creating an event.
	'Date	 		: 24-Feb-2016
	'Author			: Anitha 
	******************************************************************************/
	
	@Test(description = "Verify that user can cancel the process of creating an event.")
	public void testEdgeCase92367() throws Exception {

		gstrTCID = "92367";
		gstrTO = "Verify that user can cancel the process of creating an event.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		Event_data objEvent_data = new Event_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();

		Login login_page = new Login(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);

		String strResourceValue[] = new String[1];
		String strstatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];

		System.out.println("-----Precondition execution starts-------");

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objNavigationToSubMenus.navigateToResourceInSetup();

		// Resource type creation
		ResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strstatusTypeValues);

		strResourceTypeValue[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

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
		
		// create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.clickOncreateEventTemplate()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition)
			    .selectResourceType(strResourceTypeValue[0])
				.selectStatusType(strstatusTypeValues[0])
				.clickSaveButton()
				.deselectSelectAllWebOption();

		UsersList_page
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption().clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		login_page.clickLogOut();
		
	    System.out.println("-----Precondition ends and test execution starts-------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		EventManagement_page1
				.navigateToEventManagement()
				.clickOnCreateNewEvent()
				.verifySelectEventTemplatePage()
				.verifyEventTemplateIsDisplayed(
						objEventSetUp_data.strEventTemplate)
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue[0])
				.clickOnCancelButton()
				.verifyEventManagementPage()
				.verifyEventNameNotDisplayed(objEvent_data.strEventName)
				.verifyEventNameNotDisplayedInEventBanner(
						objEvent_data.strEventName);

		login_page1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************
	'Description	: Verify that event banner is not displayed when an event is 
	                  created by deselecting the option to display in banner.
	'Date	 		: 24-Feb-2016
	'Author			: Anitha 
	**************************************************************************/
	
	@Test(description = "Verify that event banner is not displayed when an event is "
			+ "created by deselecting the option to display in banner.")
	public void testEdgeCase92666() throws Exception {

		gstrTCID = "92666";
		gstrTO = "Verify that event banner is not displayed when an event is created by"
				+ " deselecting the option to display in banner.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		Event_data objEvent_data = new Event_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();

		Login login_page = new Login(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);

		String strResourceValue[] = new String[1];
		String strstatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];

		System.out.println("-----Precondition execution starts-------");

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objNavigationToSubMenus.navigateToResourceInSetup();

		// Resource type creation
		ResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strstatusTypeValues);

		strResourceTypeValue[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

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
		
		// create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.clickOncreateEventTemplate()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition)
			    .selectResourceType(strResourceTypeValue[0])
				.selectStatusType(strstatusTypeValues[0])
				.clickSaveButton()
				.deselectSelectAllWebOption();

		UsersList_page
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectMaintainEventsOption()
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		login_page.clickLogOut();
		
	    System.out.println("-----Precondition ends and test execution starts-------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();
		
		EventManagement_page1
				.navigateToEventManagement()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue[0])
				.clickOnSaveButton();

		EventManagement_page1
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName1)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.deSelectCheckBoxOfDisplayInEventBanner()
				.selectResource(strResourceValue[0])
				.clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName1)
				.verifyEventNameNotDisplayedInEventBanner(
						objEvent_data.strEventName1);
		
		objNavigationToSubMenus1.navigateToFormList();

		EventManagement_page1.verifyEventNameNotDisplayedInEventBanner(
				objEvent_data.strEventName1).clickOnEventNameInEventBanner(
				objEvent_data.strEventName);

		EventManagement_page1
				.verifyEventNameInEventBanner(objEvent_data.strEventName);

		objNavigationToSubMenus1.navigateToEventList();

		EventManagement_page1
				.verifyEventNameNotDisplayedInEventBanner(objEvent_data.strEventName1);

		login_page1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*****************************************************************************
	'Description	: Verify that unending event can be ended manually.
	'Date	 		: 24-Feb-2016
	'Author			: Pallavi 
	******************************************************************************/
	
	@Test(description = "Verify that unending event can be ended manually.")
	public void testEdgeCase118091() throws Exception {

		gstrTCID = "118091";
		gstrTO = "Verify that unending event can be ended manually.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		Event_data objEvent_data = new Event_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		Date_Time_settings objDts = new Date_Time_settings();

		Login login_page = new Login(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver1);
		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;
		OfficeCommonFunctions objOffCommonFunc = new OfficeCommonFunctions();

		String strResourceValue[] = new String[1];
		String strstatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];

		boolean blnTest = false;
		
		System.out.println("-----Precondition execution starts-------");

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objNavigationToSubMenus.navigateToResourceInSetup();

		// Resource type creation
		ResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strstatusTypeValues);

		strResourceTypeValue[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

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
		
		UsersList_page
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
				.enterEmail(objUser_data.strPrimaryMailId)
				.entertextPagerId(objUser_data.strPrimaryMailId)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);
		System.out.println(objEventSetUp_data.strEventTemplate);

		// create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.clickOncreateEventTemplate()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition)
			    .selectResourceType(strResourceTypeValue[0])
				.selectStatusType(strstatusTypeValues[0])
				.clickSaveButton()
				.deselectSelectAllWebOptionOnly()
				.clickOnWebCheckBox(
						objUser_data.strNewUserName)
				.clickOnEmailCheckBox(
						objUser_data.strNewUserName)
				.clickOnPagerCheckBox(
						objUser_data.strNewUserName)
				.clickSaveButton();
				
		login_page.clickLogOut();
		
	    System.out.println("-----Precondition ends and test execution starts-------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		EventManagement_page1
				.navigateToEventManagement()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue[0])
				.clickEventNeverEndRadioButton()
				.clickOnSaveButton();

		String strEventStartTime = EventManagement_page1.getApplicationTime();
		
		String strCurrentYear = objDts.getCurrentDate("yyyy");
		
		String[] strEveStrtTime = strEventStartTime.split(" ");
		
		strEventStartTime = strCurrentYear + "-" + strEveStrtTime[1] + "-" + strEveStrtTime[0] + " " + strEveStrtTime[2];
		
		strEventStartTime = objDts.converDateFormat(strEventStartTime,
				"yyyy-MMM-dd HH:mm", "yyyy-MM-dd HH:mm");
		
		Thread.sleep(5000);
		
		EventManagement_page1
				.verWebNotificationframe()
				.verWebNotificationAndAcknowledge(objEvent_data.strEventName,
						objEvent_data.strEventDescription)
				.clickAcknowledgeAllNotifications()
				.selectFrame()
				.verifyEventStatus(objEvent_data.strEventName,
						objEvent_data.strOngoing)
				.verifyEventEndTimeWhenItSetToNever(
						objEvent_data.strEventName, objEvent_data.strEndNever)
				.clickOnEndEventOnly(objEvent_data.strEventName)
				.verifyAndAcceptToEndNeverEndingEvent()
				.verifyEndedUnderStatusColumn(objEvent_data.strEventName)
				.verWebNotificationframe()
				.clickAcknowledgeAllNotifications()
				.selectFrame()
				.verEveNotPresentInEveBanner(objEvent_data.strEventName);
		
		String strEventEndTime = EventManagement_page1.getApplicationTime(); 
		
		login_page1.clickLogOut();

		String strSubject = objEvent_data.strEventName;

		String strMsgBody1 = objMailVerificationFunctions.getEventEmailBody(
				objUser_data.strFullName, objUser_data.strFullName,
				objTest_data.strRegionName, objEvent_data.strEventDescription);
		
		String strMsgBody2 = objMailVerificationFunctions.getEventPagerBody(
				objUser_data.strFullName, objTest_data.strRegionName,
				objEvent_data.strEventDescription);
		
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
						.verifyMailContainsBody(strMsgBody1);
			}

			if (blnMsg2 == false) {
				blnMsg2 = objMailVerificationFunctions
						.verifyMailBody(strMsgBody2);
			}
//			objMailVerificationFunctions.backToMailInbox();

		}
		assertTrue(blnMsg1 && blnMsg2);

		objMailVerificationFunctions.logoutMail();
		
		blnTest = true;

		if (blnTest) {
			String[] strTestData = {
					Login_data.strBuildName,
					gstrTCID,
					objUser_data.strNewUserName + "/" + objUser_data.strNewPassword,
					objEventSetUp_data.strEventTemplate,
					objEvent_data.strEventName,
					"Verify mobile end condition event","",""
					,"",
					objTest_data.strRegionName,strEventStartTime,  strEventEndTime};

			objOffCommonFunc.writeResultData(strTestData,
					strPartialAutoResultsPath, "Events");
		}
		gstrResult = "PASS";
	}
	
	/*****************************************************************************
	'Description	: Verify that event details displayed are appropriate when 
					  clicked on the event displayed on the event banner.
	'Date	 		: 24-Feb-2016
	'Author			: Pallavi 
	******************************************************************************/
	
	@Test(description = "Verify that event details displayed are appropriate when clicked on the"
			+ " event displayed on the event banner.")
	public void testEdgeCase92669() throws Exception {

		gstrTCID = "92669";
		gstrTO = "Verify that event details displayed are appropriate when clicked on the event"
				+ " displayed on the event banner.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		Event_data objEvent_data = new Event_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		Date_Time_settings objDts = new Date_Time_settings();

		Login login_page = new Login(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);

		String strResourceValue[] = new String[1];
		String strstatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];

		System.out.println("-----Precondition execution starts-------");

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objNavigationToSubMenus.navigateToResourceInSetup();

		// Resource type creation
		ResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strstatusTypeValues);

		strResourceTypeValue[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

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
		
		UsersList_page
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
				.enterEmail(objUser_data.strPrimaryMailId)
				.entertextPagerId(objUser_data.strPrimaryMailId)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);
		System.out.println(objEventSetUp_data.strEventTemplate);

		// create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.clickOncreateEventTemplate()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition)
			    .selectResourceType(strResourceTypeValue[0])
				.selectStatusType(strstatusTypeValues[0])
				.clickSaveButton()
				.deselectSelectAllWebOption();
				
		login_page.clickLogOut();
		
	    System.out.println("-----Precondition ends and test execution starts-------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		EventManagement_page1
				.navigateToEventManagement()
				.clickOnCreateNewEvent()
				.verifySelectEventTemplatePage()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue[0])
				.clickOnSaveButton();
		
		String strEventStartTime = EventManagement_page1
				.getApplicationTime();
		
		String strCurrentYear = objDts.getCurrentDate("yyyy");
		
		String[] strEveStrtTime = strEventStartTime.split(" ");
		
		strEventStartTime = strCurrentYear + "-" + strEveStrtTime[1] + "-" + strEveStrtTime[0] + " " + strEveStrtTime[2];
		
		strEventStartTime = objDts.converDateFormat(strEventStartTime,
				"yyyy-MMM-dd HH:mm", "yyyy-MM-dd HH:mm");
		
		strEventStartTime = objDts.converDateFormat(
				strEventStartTime, "yyyy-MMM-dd HH:mm", "yyyy-MM-dd HH:mm");

		EventManagement_page1.verifyEventStartTime(objEvent_data.strEventName,
									strEventStartTime)
							 .verifyEventNameInEventBanner(objEvent_data.strEventName)
							 .clickOnEventNameInEventBanner(objEvent_data.strEventName);
		
	  objEventStatus1.verifyCreatedByDesc(objUser_data.strFullName,
				strEventStartTime,
				objEvent_data.strEventDescription);
	  
		login_page1.clickLogOut();

		gstrResult = "PASS";
	}

	/*************************************************************************
	'Description	:Verify that event can be created by selecting multiple resources present under the same resource type.
	'Date	 		: 11-Mar-2016 
	'Author			: Sangappa K 
	**************************************************************************/
	
	@Test(description = "Verify that event can be created by selecting multiple resources present under the same resource type.")
	public void testEdgeCase92674() throws Exception {

		gstrTCID = "92674";
		gstrTO = "Verify that event can be created by selecting multiple resources present under the same resource type.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();

		Login login_page = new Login(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		Login login_page1 = new Login(this.driver1);
		EventSetUp objEventSetUp1 = new EventSetUp(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);

		String strstatusTypeValues1[] = new String[4];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[2];

		System.out.println("-----Precondition execution starts-------");

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues1[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strsSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues1[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strsSSTStatusTypeName);

		objStatusTypeList
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription);
						
	strstatusTypeValues1[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

	objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
		.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1)
		.clickOnReturnToStatusTypeList();

		objNavigationToSubMenus.navigateToResourceInSetup();

		// Resource type creation
		ResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strstatusTypeValues1);

		strResourceTypeValue[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

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

		Resource_Page.createResource(objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[1] = Resource_Page
				.getResourceValue(objResource_data.strResourceName1);

		UsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectAssosciateResourceRight(objResource_data.strResourceName)
				.selectViewResourceCheckBox(objResource_data.strResourceName1)
				.selectAssosciateResourceRight(
						objResource_data.strResourceName1)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption().clickSaveButton();
		System.out.println(objUser_data.strNewUserName);

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.verEveTemplateListScreenIsDisplayed()
				.clickOncreateEventTemplate()
				.verCreateNewTemplateScreenIsDisplayed()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition)
				.selectResourceType(strResourceTypeValue[0]);

		for (int i = 0; i <= strstatusTypeValues1.length - 1; i++) {
			objEventSetUp.selectStatusType(strstatusTypeValues1[i]);
		}
		objEventSetUp.clickSaveButton().deselectSelectAllWebOption();

		System.out.println(objEventSetUp_data.strEventTemplate);

		login_page.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		RegionDefault_page1.clickOnHomeButton();

		EventManagement_page1
				.navigateToEventManagement()
				.clickOnCreateNewEvent()
				.verifyEventTemplateIsDisplayed(
						objEventSetUp_data.strEventTemplate)
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.verifyResourceNameInCreateEventPage(
						objResource_data.strResourceName)
				.verifyResourceNameInCreateEventPage(
						objResource_data.strResourceName1)
				.selectResource(strResourceValue[0])
				.selectResource(strResourceValue[1]).clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);
		System.out.println(objEvent_data.strEventName);

		EventManagement_page1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName)

		.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName1);

		String[] strStTypesNames = { objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strsSSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName };

		for (int j = 0; j <= strStTypesNames.length - 1; j++) {
			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					strStTypesNames[j]);
		}
		login_page1.clickLogOut();

		gstrResult = "PASS";
	}

	/*************************************************************************
	'Description	: Verify that event banner is displayed on refresh when an 
					  event is created selecting the option to display in banner.
	'Date	 		: 14-Mar-2016
	'Author			: Pallavi 
	**************************************************************************/
	
	@Test(description = "Verify that event banner is displayed on refresh "
			+ "when an event is created selecting the option to display in banner.")
	public void testEdgeCase92665() throws Exception {

		gstrTCID = "92665";
		gstrTO = "Verify that event banner is displayed on refresh when an "
				+ "event is created selecting the option to display in banner.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		Event_data objEvent_data = new Event_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();

		Login login_page = new Login(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		EventManagement EventManagement_page = new EventManagement(
				this.driver1);

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);
		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);

		String strResourceValue[] = new String[1];
		String strstatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];

		System.out.println("-----Precondition execution starts-------");

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objNavigationToSubMenus.navigateToResourceInSetup();

		// Resource type creation
		ResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strstatusTypeValues);

		strResourceTypeValue[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

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
		
		// create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.clickOncreateEventTemplate()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition)
			    .selectResourceType(strResourceTypeValue[0])
				.selectStatusType(strstatusTypeValues[0])
				.clickSaveButton()
				.deselectSelectAllWebOption();

		UsersList_page
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName1,
						objUser_data.strNewPassword, objUser_data.strFullName1)
				.selectFirstRole()
				.selectViewResourceRights(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton();

		System.out.println(objUser_data.strNewUserName);

		login_page.clickLogOut();
		
		login_page1.loginAsNewUser(objUser_data.strNewUserName1,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();
		
		login_page.loginAsNewUser(objUser_data.strNewUserName,
						  objUser_data.strNewPassword);

		RegionDefault_page.selectFrame();
		
		EventManagement_page
				.navigateToEventManagement()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectCheckBoxOfDisplayInEventBanner()
				.selectResource(strResourceValue[0])
				.clickOnSaveButton();
	
	    System.out.println("-----Precondition ends and test execution starts-------");

	    RegionDefault_page1.clickOnHomeButton();
	    
		EventManagement_page1
				.verifyEventNameInEventBanner(objEvent_data.strEventName);
		
		gstrResult = "PASS";
	}
	
	/*************************************************************************
	'Description	:Verify that event can be created selecting multiple resources present under multiple resource types.
	'Date	 		: 15-Mar-2016 
	'Author			: Sangappa K 
	**************************************************************************/
	
	@Test(description = "Verify that event can be created selecting multiple resources present under multiple resource types.")
	public void testEdgeCase92675() throws Exception {

		gstrTCID = "92675";
		gstrTO = "Verify that event can be created selecting multiple resources present under multiple resource types.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();

		Login login_page = new Login(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);

		String strstatusTypeValues1[] = new String[2];
		String strstatusTypeValues2[] = new String[2];
		String strResourceTypeValue[] = new String[2];
		String strResourceValue[] = new String[2];

		System.out.println("-----Precondition execution starts-------");

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues1[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)

				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
						objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
		.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1)
				.clickOnReturnToStatusTypeList();

		strstatusTypeValues1[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues2[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strsSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues2[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strsSSTStatusTypeName);

		// Resource type creation
		ResourceType_Page.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues1);

		strResourceTypeValue[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		ResourceType_Page
				.createResourceType(objResourceType_data.strResourceTypeName1,
						strstatusTypeValues2);

		strResourceTypeValue[1] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName1);

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

		Resource_Page.createResource(objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName1,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[1] = Resource_Page
				.getResourceValue(objResource_data.strResourceName1);

		UsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectAssosciateResourceRight(objResource_data.strResourceName)
				.selectViewResourceCheckBox(objResource_data.strResourceName1)
				.selectAssosciateResourceRight(
						objResource_data.strResourceName1)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption().clickSaveButton();
		System.out.println(objUser_data.strNewUserName);

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.verEveTemplateListScreenIsDisplayed()
				.clickOncreateEventTemplate()
				.verCreateNewTemplateScreenIsDisplayed()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition)
				.selectResourceType(strResourceTypeValue[0])
				.selectResourceType(strResourceTypeValue[1]);

		for (int i = 0; i <= strstatusTypeValues1.length - 1; i++) {
			objEventSetUp.selectStatusType(strstatusTypeValues1[i]);
		}

		for (int j = 0; j <= strstatusTypeValues2.length - 1; j++) {
			objEventSetUp.selectStatusType(strstatusTypeValues2[j]);
		}
		objEventSetUp.clickSaveButton().deselectSelectAllWebOption();

		System.out.println(objEventSetUp_data.strEventTemplate);

		login_page.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		RegionDefault_page1.clickOnHomeButton();

		EventManagement_page1
				.navigateToEventManagement()
				.clickOnCreateNewEvent()
				.verifyEventTemplateIsDisplayed(
						objEventSetUp_data.strEventTemplate)
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.verifyResourceNameInCreateEventPage(
						objResource_data.strResourceName)
				.verifyResourceNameInCreateEventPage(
						objResource_data.strResourceName1)
				.selectResource(strResourceValue[0])
				.selectResource(strResourceValue[1]).clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);
		System.out.println(objEvent_data.strEventName);

		EventManagement_page1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName)

		.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName1,
				objResource_data.strResourceName1);

		objEventStatus1
				.verStatusTypes(objResourceType_data.strResourceTypeName,
						objStatusTypes_data.strNSTStatusTypeName)
				.verStatusTypes(objResourceType_data.strResourceTypeName,
						objStatusTypes_data.strMSTStatusTypeName)

				.verStatusTypes(objResourceType_data.strResourceTypeName1,
						objStatusTypes_data.strsSSTStatusTypeName)

				.verStatusTypes(objResourceType_data.strResourceTypeName1,
						objStatusTypes_data.strTSTStatusTypeName);

		login_page1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/*************************************************************************
	'Description	:  Verify that event can be created by selecting the resources with address and without providing address for the event.
	'Date	 		: 15-Mar-2016 
	'Author			: Sangappa K 
	**************************************************************************/
	
	@Test(description =" Verify that event can be created by selecting the resources with address and without providing address for the event.")
	public void testEdgeCase92677() throws Exception {

		gstrTCID ="92677";
		gstrTO = " Verify that event can be created by selecting the resources with address and without providing address for the event.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();

		Login login_page = new Login(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);
		Map objMap = new Map(this.driver1);

		NavigationToSubMenus objNavigationToSubMenus1 = new NavigationToSubMenus(
				this.driver1);

		String strstatusTypeValues[] = new String[4];

		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		System.out.println("-----Precondition execution starts-------");

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)

				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
						objStatusTypes_data.strStatusColor)
		.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
		.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1)
.clickOnReturnToStatusTypeList();

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strsSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strsSSTStatusTypeName);

		// Resource type creation
		ResourceType_Page.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

		strResourceTypeValue[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		System.out.println(objResourceType_data.strResourceTypeName);

		// Resource creation
		Resource_Page.navigateToResourceListPage()

		.createResourceWithAddress(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);

		strResourceValue[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName);

		System.out.println(objResource_data.strResourceName);

		UsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectViewResourceCheckBox(objResource_data.strResourceName)
				.selectAssosciateResourceRight(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventTemplateOption()
				.selectMaintainEventsOption().clickSaveButton();
		System.out.println(objUser_data.strNewUserName);

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.verEveTemplateListScreenIsDisplayed()
				.clickOncreateEventTemplate()
				.verCreateNewTemplateScreenIsDisplayed()
				.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
				.enterEventTemplateDefintion(
						objEventSetUp_data.strTemplateDefinition)
				.selectResourceType(strResourceTypeValue[0]);

		for (int i = 0; i <= strstatusTypeValues.length - 1; i++) {
			objEventSetUp.selectStatusType(strstatusTypeValues[i]);
		}

		objEventSetUp.clickSaveButton().deselectSelectAllWebOption();

		System.out.println(objEventSetUp_data.strEventTemplate);

		login_page.clickLogOut();

		System.out
				.println("-----Precondition ends and test execution starts-------");

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();

		RegionDefault_page1.clickOnHomeButton();

		EventManagement_page1
				.navigateToEventManagement()
				.clickOnCreateNewEvent()
				.verifyEventTemplateIsDisplayed(
						objEventSetUp_data.strEventTemplate)
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.verifyResourceNameInCreateEventPage(
						objResource_data.strResourceName)
				.selectResource(strResourceValue[0]).clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName)
				.verifyEventNameInEventBanner(objEvent_data.strEventName);
		System.out.println(objEvent_data.strEventName);

		objNavigationToSubMenus1.navigateToMap();

		String strStatusTypeName[] = {
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strMSTStatusTypeName,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strTSTStatusTypeName };

		objMap.selectEventNameInEventResourceDropdown(
				objEvent_data.strEventName)
				.verResourceInFindResourceDropDown(
						objResource_data.strResourceName)
				.selectResourceNameInFindResourceDropdown(
						objResource_data.strResourceName)
				.verViewInfoInPopupWindow()
				.verResourceNameInPopupWindow(objResource_data.strResourceName)
				.verStatusTypesInPopupWindow(strStatusTypeName);
		login_page1.clickLogOut();

		gstrResult = "PASS";
	}
}
