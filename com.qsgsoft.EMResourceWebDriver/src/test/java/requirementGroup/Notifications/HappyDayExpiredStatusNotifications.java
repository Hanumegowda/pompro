package requirementGroup.Notifications;

import static org.testng.Assert.assertTrue;
import lib.dataObject.EventSetUp_data;
import lib.dataObject.Event_data;
import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.UpdateStatus_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
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
import lib.page.SystemNotifications;
import lib.page.UpdateStatus;
import lib.page.UsersList;
import lib.page.ViewsList;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class HappyDayExpiredStatusNotifications extends TestNG_UI_EXTENSIONS {
	
	public HappyDayExpiredStatusNotifications() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/***************************************************************************************
	'Description : Verify that user does not receive expired status notification for event
	' 			   only status type when there are no active events involving the status type.
	'Date	 	 : 18-June-2014
	'Author		 : Yugender
	***************************************************************************************/
	@Test (description = "Verify that user does not receive expired status notification for event only status type when there are no active events involving the status type.")
	public void testHappyDay140993() throws Exception{
		
		gstrTCID = "140993";
		gstrTO = "Verify that user does not receive expired status notification for event only status type when there are no active events involving the status type.";
		
		//Objects for data
		ResourceType_data objResourceType_data=new ResourceType_data();
		Resource_data objResource_data=new Resource_data();
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		StatusTypes_data objStatusTypes_data=new StatusTypes_data();
		
		//Objects for Page
		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);
		ResourceType ResourceType_Page=new ResourceType(this.driver1);
		Resource Resource_Page =new Resource(this.driver1);
	    UsersList UsersList_page = new UsersList(this.driver1);
	    SystemNotifications SystemNotifications_page = new SystemNotifications(this.driver1);
	    MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(this.driver1);
	    
		String strstatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResource = objResource_data.strResourceName;
		String strSubject = "EMResource Expired Status Notification: "
			     + strResource;
		
		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		RegionDefault_page.selectFrame();
		
		RegionDefault_page.clickRegionLink();

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();
		
		StatusTypeList_page.navigateToStatusTypeList();

		StatusTypeList_page.createEventStatusTypeWithExpirationTime(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription, objStatusTypes_data.strStatusExpirationTime);
		
		strstatusTypeValues[0] = StatusTypeList_page
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		//Resource type creation 
		ResourceType_Page.navigateToResourceTypePage();
		
		ResourceType_Page.createResourceType(objResourceType_data.strResourceTypeName, strstatusTypeValues);
		
		//Resource creation 
		
		Resource_Page.navigateToResourceListPage();
		
		Resource_Page.createResource(strResource,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceTypeValue[0]=Resource_Page.getResourceValue(objResource_data.strResourceName);
		
		//User creation
		
		UsersList_page.navigateToUsersNew();
	    	    
	    UsersList_page.clickCreateNewUserButton();
	    
		UsersList_page.enterUserDetails(objUser_data.strNewUserName,
				objUser_data.strNewPassword, objUser_data.strFullName);

		System.out.println(objUser_data.strNewUserName);
		
		UsersList_page.enterPrimaryEmailId(objUser_data.strPrimaryMailId);
		
		UsersList_page.selectFirstRole();
		
		UsersList_page.clickSaveButton();
		
		UsersList_page.searchUserName(objUser_data.strNewUserName,
				objUser_data.strRole, objUser_data.strResourceType,
				objUser_data.strUsername, objUser_data.strsearchOption);
		 
		UsersList_page.editUserDetails(objUser_data.strNewUserName);
		
		UsersList_page.clickOnsystemNotifyPreferences();
		
		SystemNotifications_page.selectAndSaveExpiredStatusNotification();
		
		login_page.clickLogOut();
		
		System.out.println("Wait for 5 minutes");
		Thread.sleep(360000);
		System.out.println("Waiting is completed");
		
		objMailVerificationFunctions.loginToMail(
				objUser_data.strPrimaryMailId, objUser_data.strPrimaryPwsd);
		
		objMailVerificationFunctions.NavToInboxAndVerEmailIsNotPresent(strSubject);
		
		objMailVerificationFunctions.logoutMail();
		
		gstrResult = "PASS";
	}

	/***************************************************************************************
	'Description : Verify that user receive expired status notification for normal status type
	 			   when there are no active events involving the status type.
	'Date	 	 : 20-June-2014
	'Author		 : Yugender
	***************************************************************************************/
	@Test (description = "Verify that user receive expired status notification for normal status type when there are no active events involving the status type.")
	public void testHappyDay140628() throws Exception{
		
		gstrTCID = "140628";
		gstrTO = "Verify that user receive expired status notification for normal status type when there are no active events involving the status type.";
				
		//Objects for data
		ResourceType_data objResourceType_data=new ResourceType_data();
		Resource_data objResource_data=new Resource_data();
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		StatusTypes_data objStatusTypes_data=new StatusTypes_data();
		View_data objView_data = new View_data(); 
		
		//Objects for Page
		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);
		ResourceType ResourceType_Page=new ResourceType(this.driver1);
		Resource Resource_Page =new Resource(this.driver1);
	    UsersList UsersList_page = new UsersList(this.driver1);
	    SystemNotifications SystemNotifications_page = new SystemNotifications(this.driver1);
	    ViewsList objViewsList = new ViewsList(this.driver1);
	    MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(this.driver1);
	    
		String strstatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strResource = objResource_data.strResourceName;
		String strSubject = "Expired Status Notification: " + strResource;
		String strNumberStatusType = objStatusTypes_data.strNumberStatusType;
		String strNedocCalculationStatusType = objStatusTypes_data.strNedocCalculationStatusType;
		String strNSTStatusTypeName = objStatusTypes_data.strNSTStatusTypeName;
		String strNDSTStatusTypeName = objStatusTypes_data.strNDSTStatusTypeName;
		String strStatusDescription = objStatusTypes_data.strStatusDescription;
		String strStatusExpirationTime = objStatusTypes_data.strStatusExpirationTime;
		String strViewName = objView_data.strViewName;
		
		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		RegionDefault_page.selectFrame()
						  .clickRegionLink();

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();
		
		StatusTypeList_page.navigateToStatusTypeList();

		StatusTypeList_page.createStatusTypeWithExpirationTime(
				strNumberStatusType, strNSTStatusTypeName,
				strStatusDescription, strStatusExpirationTime);
		
		strstatusTypeValues[0] = StatusTypeList_page
				.getStatusValue(strNSTStatusTypeName);
		
		StatusTypeList_page.createStatusTypeWithExpirationTime(
				strNedocCalculationStatusType, strNDSTStatusTypeName,
				strStatusDescription, strStatusExpirationTime);

		strstatusTypeValues[1] = StatusTypeList_page
				.getStatusValue(strNDSTStatusTypeName);

		//Resource type creation 
		ResourceType_Page.navigateToResourceTypePage()
						 .createResourceType(objResourceType_data.strResourceTypeName, strstatusTypeValues);
		
		//Resource creation 
		Resource_Page.navigateToResourceListPage()
					 .createResource(strResource,
							 objResource_data.strResourceAbbrivation,
							 objResourceType_data.strResourceTypeName,
							 objResource_data.strStandardResourceTypename,
							 objResource_data.strResourceFirstName,
							 objResource_data.strResourceLastName);

		strResourceTypeValue[0]=Resource_Page.getResourceValue(objResource_data.strResourceName);
		
		//User creation
		UsersList_page.navigateToUsersNew()
					  .clickCreateNewUserButton()
					  .enterUserDetails(objUser_data.strNewUserName, objUser_data.strNewPassword, objUser_data.strFullName);

		System.out.println(objUser_data.strNewUserName);
		
		UsersList_page.enterPrimaryEmailId(objUser_data.strPrimaryMailId)
					  .selectFirstRole()
					  .selectUpdateStatusOfResource(strResource)
					  .clickSaveButton()
					  .searchUserName(objUser_data.strNewUserName, objUser_data.strRole, objUser_data.strResourceType, objUser_data.strUsername, objUser_data.strsearchOption)
					  .editUserDetails(objUser_data.strNewUserName)
					  .clickOnsystemNotifyPreferences();
		
		SystemNotifications_page.selectAndSaveExpiredStatusNotification();
		
String strStatusTypeNames[] = {strNSTStatusTypeName, strNDSTStatusTypeName};
		
		objViewsList.navigateToStatusTypeList()
					.createView(strViewName, objView_data.strViewDesc, strResource, strStatusTypeNames);
//					.clickCreateNewViewButton()
//					.enterViewName(strViewName)
//					.enterViewDesc(objView_data.strViewDesc)
//					.selectStatusType(strNSTStatusTypeName)
//					.selectStatusType(strNDSTStatusTypeName)
//					.selectResource(strResource)
//					.clickOnSaveOfCreateNewView();
		
		login_page.clickLogOut();
		
		login_page.loginAsNewUser(objUser_data.strNewUserName, objTest_data.strPassword);
		
		RegionDefault_page.selectFrame();
		
		objViewsList.navigateToCreatedView(strViewName)
					.clickOnUpdateStatus(strResource)
					.selectStatusToUpdate(strNDSTStatusTypeName)
					.updateNEDOCStatus(strNDSTStatusTypeName, objView_data.strValueForUpdate)
					.selectStatusToUpdate(strNSTStatusTypeName)
					.updateNSTStatus(strNSTStatusTypeName, objView_data.strValueForUpdate)
					.clickOnSaveOfUpdateStatus();
		
		login_page.clickLogOut();
		
		System.out.println("Wait for 6 minutes");
		Thread.sleep(360000);
		System.out.println("Waiting is completed");
		
		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId, objUser_data.strPrimaryPwsd);
		
		objMailVerificationFunctions.NavToInbox(strSubject);
		
		objMailVerificationFunctions.verEmail(objUser_data.strPrimaryMailId, strSubject);
		
		objMailVerificationFunctions.logoutMail();
		
		this.driver1.get("https://emresource.qa.intermedix.com/login.jsp");
		
		login_page.loginToApplication(objUser_data.strNewUserName, objTest_data.strPassword);

		RegionDefault_page.selectFrame();
		
		objViewsList.navigateToCreatedView(strViewName)
					.verifyNEDOCSUpdatedStatus(strNDSTStatusTypeName)
					.verifyNSTUpdatedStatus(strNSTStatusTypeName);
		
		login_page.clickLogOut();
		
		gstrResult = "PASS";
	}
	

	/***************************************************************************************
	'Description	:Verify that user does not receive expired status notification for event only status type when resource type of a resource is changed which is involved in active event.
	'Date	 		:27-June-2014
	'Author			:Anil
	***************************************************************************************/
	
	@Test (description = "Verify that user does not receive expired status notification for event only status type when resource type of a resource is changed which is involved in active event.")
	public void testHappyDay142316() throws Exception {
		gstrTCID = "142316";
		gstrTO = "Verify that user does not receive expired status notification for event only status type when resource type of a resource is changed which is involved in active event.";

		
		Login login_page = new Login(this.driver1);	
		Login_data login_data = new Login_data();
		User_data objUser_data = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		EventManagement EventManagement_page=new EventManagement(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);		
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);	
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType ResourceType_page = new ResourceType(this.driver1);
		String strStatusTypeValue[] = new String[5];
		Resource Resource_page = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();
		EventSetUp EventSetUp_page = new EventSetUp(this.driver1);
		SystemNotifications SystemNotifications_page = new SystemNotifications(this.driver1);
		
		UpdateStatus UpdateStatus_page1 = new UpdateStatus(this.driver1);
		Login login_page1 = new Login(this.driver1);
		EventStatus EventStatus_page1 = new EventStatus(this.driver1);
		MailVerificationFunctions objMailVerificationFunctions=new MailVerificationFunctions(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		
		EventManagement EventManagement_page1=new EventManagement(this.driver1);
		
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		String strResourceTypeValue[] = new String[2];
		String strResourceValue[] = new String[1];
		
		String strStatusesValue[] = new String[2];
		
		UpdateStatus_data objUpdateStatus_data = new UpdateStatus_data();
		
		Event_data objEvent_data = new Event_data();
		
		login_page.loginToApplication(login_data.strUserName, login_data.strPassword);
	    	    
	    SelectRegion_page.selectRegionAndNavigate(login_data.strRegionName);
	       
	    RegionDefault_page.selectFrame();
	    
	    StatusTypeList_page.navigateToStatusTypeList();
	    
	    StatusTypeList_page.createEventStatusTypeWithExpirationTime(objStatusTypes_data.strNumberStatusType, objStatusTypes_data.strNSTStatusTypeName, objStatusTypes_data.strStatusDescription, objStatusTypes_data.strStatusExpirationTime);
	    
	    strStatusTypeValue[0] = StatusTypeList_page.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);
	    
	    StatusTypeList_page.createEventStatusTypeWithExpirationTime(objStatusTypes_data.strSaturationScoreStatusType, objStatusTypes_data.strSSTStatusTypeName, objStatusTypes_data.strStatusDescription, objStatusTypes_data.strStatusExpirationTime);
 
	    strStatusTypeValue[1] = StatusTypeList_page.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);
	    
	    StatusTypeList_page.createStatusTypeWithExpirationTime(objStatusTypes_data.strTextStatusType, objStatusTypes_data.strTSTStatusTypeName, objStatusTypes_data.strStatusDescription, objStatusTypes_data.strStatusExpirationTime);

	    strStatusTypeValue[2] = StatusTypeList_page.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

	    StatusTypeList_page.createEventStatusTypeWithExpirationTime(objStatusTypes_data.strNedocCalculationStatusType, objStatusTypes_data.strNDSTStatusTypeName, objStatusTypes_data.strStatusDescription, objStatusTypes_data.strStatusExpirationTime);

	    strStatusTypeValue[3] = StatusTypeList_page.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

	    StatusTypeList_page.createStatusType(objStatusTypes_data.strMultiStatusType, objStatusTypes_data.strMSTStatusTypeName, objStatusTypes_data.strStatusDescription);
    
	    StatusTypeList_page.createMultiStatusTypesWithExpirationTime(objStatusTypes_data.strStatusNameInMulti, objStatusTypes_data.strStatusExpirationTime);
	    		
	    strStatusesValue[0] = StatusTypeList_page.getMSTStatusesValue(objStatusTypes_data.strStatusNameInMulti);
	    
	    StatusTypeList_page.createMultiStatusTypesWithExpirationTime(objStatusTypes_data.strStatusNameInMulti1, objStatusTypes_data.strStatusExpirationTime);

	    strStatusesValue[1] =  StatusTypeList_page.getMSTStatusesValue(objStatusTypes_data.strStatusNameInMulti1);
	    
	    StatusTypeList_page.navigateToStatusTypeListNew();
	    
	    strStatusTypeValue[4] = StatusTypeList_page.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

	    String strStatusTypeValue1[] = {strStatusTypeValue[2], strStatusTypeValue[1], strStatusTypeValue[3]};
	    
	    ResourceType_page.navigateToResourceTypePage();
	    
	    ResourceType_page.createResourceType(objResourceType_data.strResourceTypeName, strStatusTypeValue1);	    

	    strResourceTypeValue[0] = ResourceType_page.getResourceTypeValue(objResourceType_data.strResourceTypeName);
	    
	    String strStatusTypeValue2[] = {strStatusTypeValue[0], strStatusTypeValue[4]};
	    
	    ResourceType_page.createResourceType(objResourceType_data.strResourceTypeName1, strStatusTypeValue2);	    

	    strResourceTypeValue[1] = ResourceType_page.getResourceTypeValue(objResourceType_data.strResourceTypeName1);

	    Resource_page.navigateToResourceListPage();
	    
	    Resource_page.createResource(objResource_data.strResourceName, objResource_data.strResourceAbbrivation, objResourceType_data.strResourceTypeName, objResource_data.strStandardResourceTypename, objResource_data.strResourceFirstName, objResource_data.strResourceLastName);
	    
	    strResourceValue[0] = Resource_page.getResourceValue(objResource_data.strResourceName);
	    
	    EventSetUp_page.navigateToEventSetUp();
	    
	    EventSetUp_page.createEventTemplate(objEventSetUp_data.strEventTemplate, objEventSetUp_data.strTemplateDefinition, strResourceTypeValue, strStatusTypeValue);
	
	    EventSetUp_page.deselectSelectAllWebOption();
	    
	    UsersList_page.navigateToUsers();
	    
	    UsersList_page.clickCreateNewUserButton();
	    
	    UsersList_page.enterUserMandatoryDetails(objUser_data.strNewUserName, objUser_data.strNewPassword, objUser_data.strFullName);
	
	    UsersList_page.enterPrimaryEmailId(objUser_data.strPrimaryMailId);
	    
	    UsersList_page.selectUpdateStatusOfResource(objResource_data.strResourceName);
	    
	    UsersList_page.selectFirstRole();
	    
	    UsersList_page.clickAdvancedOptionAndExpand();
	    
	    UsersList_page.selectMaintainEventsOption();
	    
	    UsersList_page.clickSaveButton();
	    
	    Thread.sleep(2000);
	    
	    UsersList_page.searchUserName(objUser_data.strNewUserName,
				objUser_data.strRole, objUser_data.strResourceType,
				objUser_data.strUsername, objUser_data.strEquals);
	    
	    UsersList_page.editUserDetails(objUser_data.strNewUserName);
	    
	    UsersList_page.clickOnsystemNotifyPreferences();
	    
	    SystemNotifications_page.selectExpiredNotificationsEmail();
	    
	    SystemNotifications_page.selectExpiredNotificationsPager();
	    
	    SystemNotifications_page.clickOnSaveButton();

	    login_page1.loginAsNewUser(objUser_data.strNewUserName, objUser_data.strNewPassword);
	    
	    RegionDefault_page1.selectFrame();
	    
	    EventManagement_page.navigateToEventManagement();
	    
	    EventManagement_page.creatEvent(objEventSetUp_data.strEventTemplate, objEvent_data.strEventName, objEvent_data.strEventDescription, strResourceValue[0])
	    					.verifyEventNameInEventBanner(objEvent_data.strEventName);
	    
	    EventManagement_page1.clickOnEventNameInEventBanner(objEvent_data.strEventName);
	    
	    EventStatus_page1.clickOnUpdateStatusKey(objResource_data.strResourceName);
	    
	    UpdateStatus_page1.clickOnSelectAll();
	    
	    UpdateStatus_page1.enterNSTAndTSTUpdateValue(strStatusTypeValue[2], objUpdateStatus_data.strTSTUpdateValue);
	    
	    UpdateStatus_page1.enterUpdateSSTValues(strStatusTypeValue[1], objUpdateStatus_data.strSSTUpdateValue);
	    
	    UpdateStatus_page1.enterNedocsUpdateValue(strStatusTypeValue[3], objUpdateStatus_data.strNDSTUpdateValue);

	    UpdateStatus_page1.clickOnSaveButton();
	    
	    login_page1.clickLogOut()
	    		   .loginToApplication(login_data.strUserName, login_data.strPassword);
	    	    
	    SelectRegion_page.selectRegionAndNavigate(login_data.strRegionName);
	       
	    RegionDefault_page.selectFrame();
	    
	    Resource_page.navigateToResourceListPageNew();
	    
	    Resource_page.clickOnEditLinkInResourcePage(objResource_data.strResourceName);
	    
	    Resource_page.selectResourceTypename(objResourceType_data.strResourceTypeName1);
	    
	    Resource_page.clickOnSaveButton();
	    
	    Thread.sleep(300000);
	    
	    String strSubjName = "EMResource Expired Status Notification: "
				+ objResource_data.strResourceName;
	    System.out.println(strSubjName);
	    
		
		objMailVerificationFunctions.loginToMail(
				objUser_data.strPrimaryMailId, objUser_data.strPrimaryPwsd);
		
		objMailVerificationFunctions.NavToInboxAndVerEmailIsNotPresent(strSubjName);
		
		objMailVerificationFunctions.logoutMail();
		gstrResult = "PASS";
	}



	/***************************************************************************************
	'Description	:Verify that user does not receive expired status notification for event only status type when resource type of a resource is changed which is involved in active event.
	'Date	 		:10-July-2014
	'Author			:Anil
	***************************************************************************************/
	
	@Test (description = "Verify that user does not receive expired status notification for event only status type when the participating resource is removed from the event.")
	public void testHappyDay142314() throws Exception {

		gstrTCID = "142314";
		gstrTO = "Verify that user does not receive expired status notification for event only status type when the participating resource is removed from the event.";
		
		Login login_page = new Login(this.driver1);	
		Login_data login_data = new Login_data();
		User_data objUser_data = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		EventManagement EventManagement_page=new EventManagement(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);		
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);	
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType ResourceType_page = new ResourceType(this.driver1);
		String strStatusTypeValue[] = new String[4];
		Resource Resource_page = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();
		EventSetUp EventSetUp_page = new EventSetUp(this.driver1);
		SystemNotifications SystemNotifications_page = new SystemNotifications(this.driver1);
		Date_Time_settings objDts = new Date_Time_settings();
		
		UpdateStatus UpdateStatus_page1 = new UpdateStatus(this.driver1);
		Login login_page1 = new Login(this.driver1);
		EventStatus EventStatus_page1 = new EventStatus(this.driver1);
	    MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(this.driver1);
	    EventManagement EventManagement_page1=new EventManagement(this.driver1);
	    RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
	    
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		String strResourceTypeValue[] = new String[1];
		String strStatusesValue[] = new String[2];
		String strResourceValue[] = new String[1];
		
		UpdateStatus_data objUpdateStatus_data = new UpdateStatus_data();
		
		Event_data objEvent_data = new Event_data();

		String strMsgBody1 = "";
		String strMsgBody2 = "";
		String strMsgBody3 = "";
		String strMsgBody4 = "";
		String strApplicationTime= "";
		String strApplicationTime1 = "";
		String strCurrentYear = "";
		
		login_page.loginToApplication(login_data.strUserName, login_data.strPassword);
	    	    
	    SelectRegion_page.selectRegionAndNavigate(login_data.strRegionName);
	       
	    RegionDefault_page.selectFrame();
	    
	    StatusTypeList_page.navigateToStatusTypeList();
	    
	    StatusTypeList_page.createEventStatusTypeWithExpirationTime(objStatusTypes_data.strNumberStatusType, objStatusTypes_data.strNSTStatusTypeName, objStatusTypes_data.strStatusDescription, objStatusTypes_data.strStatusExpirationTime);
	    
	    strStatusTypeValue[0] = StatusTypeList_page.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);
	    
	    StatusTypeList_page.createStatusTypeWithExpirationTime(objStatusTypes_data.strSaturationScoreStatusType, objStatusTypes_data.strSSTStatusTypeName, objStatusTypes_data.strStatusDescription, objStatusTypes_data.strStatusExpirationTime);
 
	    strStatusTypeValue[1] = StatusTypeList_page.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);
	    
	    StatusTypeList_page.createEventStatusTypeWithExpirationTime(objStatusTypes_data.strNedocCalculationStatusType, objStatusTypes_data.strNDSTStatusTypeName, objStatusTypes_data.strStatusDescription, objStatusTypes_data.strStatusExpirationTime);

	    strStatusTypeValue[2] = StatusTypeList_page.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

	    StatusTypeList_page.createStatusType(objStatusTypes_data.strMultiStatusType, objStatusTypes_data.strMSTStatusTypeName, objStatusTypes_data.strStatusDescription);
    
	    StatusTypeList_page.createMultiStatusTypesWithExpirationTime(objStatusTypes_data.strStatusNameInMulti, objStatusTypes_data.strStatusExpirationTime);
	    		
	    strStatusesValue[0] = StatusTypeList_page.getMSTStatusesValue(objStatusTypes_data.strStatusNameInMulti);
	    
	    StatusTypeList_page.createMultiStatusTypesWithExpirationTime(objStatusTypes_data.strStatusNameInMulti1, objStatusTypes_data.strStatusExpirationTime);

	    strStatusesValue[1] =  StatusTypeList_page.getMSTStatusesValue(objStatusTypes_data.strStatusNameInMulti1);
	    
	    StatusTypeList_page.navigateToStatusTypeListNew();
	    
	    strStatusTypeValue[3] = StatusTypeList_page.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

	    String strStatusTypeValue1[] = {strStatusTypeValue[2], strStatusTypeValue[1], strStatusTypeValue[3], strStatusTypeValue[0]};
	    
	    ResourceType_page.navigateToResourceTypePage();
	    
	    ResourceType_page.createResourceType(objResourceType_data.strResourceTypeName, strStatusTypeValue1);	    

	    strResourceTypeValue[0] = ResourceType_page.getResourceTypeValue(objResourceType_data.strResourceTypeName);
	    
	    Resource_page.navigateToResourceListPage();
	    
	    Resource_page.createResource(objResource_data.strResourceName, objResource_data.strResourceAbbrivation, objResourceType_data.strResourceTypeName, objResource_data.strStandardResourceTypename, objResource_data.strResourceFirstName, objResource_data.strResourceLastName);
	    
	    strResourceValue[0]= Resource_page.getResourceValue(objResource_data.strResourceName);
	    
	    EventSetUp_page.navigateToEventSetUp();
	    
	    EventSetUp_page.createEventTemplate(objEventSetUp_data.strEventTemplate, objEventSetUp_data.strTemplateDefinition, strResourceTypeValue, strStatusTypeValue);
	    
	    EventSetUp_page.deselectSelectAllWebOption();
	    
	    UsersList_page.navigateToUsers();
	    
	    UsersList_page.clickCreateNewUserButton();
	    
	    UsersList_page.enterUserMandatoryDetails(objUser_data.strNewUserName, objUser_data.strNewPassword, objUser_data.strFullName);
	
	    UsersList_page.enterPrimaryEmailId(objUser_data.strPrimaryMailId);
	    
	    UsersList_page.selectUpdateStatusOfResource(objResource_data.strResourceName);
	    
	    UsersList_page.selectFirstRole();
	    
	    UsersList_page.clickAdvancedOptionAndExpand();
	    
	    UsersList_page.selectMaintainEventsOption();
	    
	    UsersList_page.clickSaveButton();
	    
	    Thread.sleep(2000);
		UsersList_page.searchUserName(objUser_data.strNewUserName,
				objUser_data.strRole, objUser_data.strResourceType,
				objUser_data.strUsername, objUser_data.strsearchOption);
		
	    UsersList_page.editUserDetails(objUser_data.strNewUserName);
	    
	    UsersList_page.clickOnsystemNotifyPreferences();
	    
	    SystemNotifications_page.selectExpiredNotificationsEmail();
	    
	    SystemNotifications_page.selectExpiredNotificationsPager();
	    
	    SystemNotifications_page.clickOnSaveButton();

	    login_page1.loginAsNewUser(objUser_data.strNewUserName, objUser_data.strNewPassword);
	    
	    RegionDefault_page1.selectFrame();
	    
	    EventManagement_page1.navigateToEventManagement();
	    
	    EventManagement_page1.creatEvent(objEventSetUp_data.strEventTemplate, objEvent_data.strEventName, objEvent_data.strEventDescription, strResourceValue[0]);
	    
	    EventManagement_page1.clickOnEventNameInEventBanner(objEvent_data.strEventName);
	    
	    EventStatus_page1.clickOnUpdateStatusKey(objResource_data.strResourceName);
	    
	    UpdateStatus_page1.clickOnSelectAll();
	    
	    UpdateStatus_page1.enterNSTAndTSTUpdateValue(strStatusTypeValue[0], objUpdateStatus_data.strNSTUpdateValue);
	    
	    UpdateStatus_page1.enterUpdateSSTValues(strStatusTypeValue[1], objUpdateStatus_data.strSSTUpdateValue);
	    
	    UpdateStatus_page1.enterNedocsUpdateValue(strStatusTypeValue[2], objUpdateStatus_data.strNDSTUpdateValue);

	    UpdateStatus_page1.selectMSTUpdateValue(strStatusTypeValue[3], strStatusesValue[0]);
	    
	    UpdateStatus_page1.clickOnSaveButton();
	    
	    strApplicationTime = EventManagement_page1.getApplicationTime();
	    
	    strCurrentYear = objDts.getCurrentDate("yyyy");
	    
	    strApplicationTime = strApplicationTime+" "+strCurrentYear;
	    
	    strApplicationTime = objDts.converDateFormat(strApplicationTime, "dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");

	    strApplicationTime = objDts.addTimetoExisting(strApplicationTime, 5, "MM/dd/yyyy HH:mm");
	    
	    strApplicationTime1 = objDts.addTimetoExisting(strApplicationTime, 1, "MM/dd/yyyy HH:mm");
	    
	    EventManagement_page.navigateToEventManagement();
	    
	    EventManagement_page.clickOnEditLink(objEvent_data.strEventName);
	    
	    EventManagement_page.deselectResource(strResourceValue);
	    
	    EventManagement_page.clickOnSaveButton();
	    
	    Thread.sleep(360000);
	    
	    String strSubjName = "Expired Status Notification: "
				+ objResource_data.strResourceName;
	    System.out.println(strSubjName);

	    strMsgBody1 = objMailVerificationFunctions.getExpiredStatusEmailBody(objUser_data.strFullName, login_data.strRegionName, objStatusTypes_data.strMSTStatusTypeName, objResource_data.strResourceName, strApplicationTime);

	    strMsgBody2 = objMailVerificationFunctions.getExpiredStatusEmailBody(objUser_data.strFullName, login_data.strRegionName, objStatusTypes_data.strMSTStatusTypeName, objResource_data.strResourceName, strApplicationTime1);

	    strMsgBody3 = objMailVerificationFunctions.getExpiredStatusEmailBody(objUser_data.strFullName, login_data.strRegionName, objStatusTypes_data.strSSTStatusTypeName, objResource_data.strResourceName, strApplicationTime);

	    strMsgBody4 = objMailVerificationFunctions.getExpiredStatusEmailBody(objUser_data.strFullName, login_data.strRegionName, objStatusTypes_data.strSSTStatusTypeName, objResource_data.strResourceName, strApplicationTime1);
		
		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId, objUser_data.strPrimaryPwsd);
		
		objMailVerificationFunctions.NavToInbox(strSubjName);
		boolean boolCheck= false;
		boolean boolCheck1 = false;
		for(int intCount = 0; intCount<2; intCount++){
			
			objMailVerificationFunctions.verEmail(objUser_data.strPrimaryMailId, strSubjName);
			
			if(boolCheck==false){
			boolCheck = objMailVerificationFunctions.verifyMailBody(strMsgBody1);
			}
			
			if(boolCheck==false){
			boolCheck = objMailVerificationFunctions.verifyMailBody(strMsgBody2);
			}
			
			if(boolCheck1==false){
			boolCheck1 = objMailVerificationFunctions.verifyMailBody(strMsgBody3);
			}
			
			if(boolCheck1==false){
			boolCheck1 = objMailVerificationFunctions.verifyMailBody(strMsgBody4);
			}
			
			objMailVerificationFunctions.backToMailInbox();
		}
		assertTrue(boolCheck && boolCheck1);
			
		objMailVerificationFunctions.NavToInboxAndVerEmailIsNotPresentNew(strSubjName);
				
		objMailVerificationFunctions.logoutMail();
		gstrResult = "PASS";
	}


	/***************************************************************************************
	'Description	:Verify that user does not receive expired status notification for event only status type after event ends.
	'Date	 		:10-July-2014
	'Author			:Anil
	***************************************************************************************/
	
	@Test (description = "Verify that user does not receive expired status notification for event only status type after event ends.")
	public void testHappyDay142363() throws Exception {

		gstrTCID = "142363";
		gstrTO = "Verify that user does not receive expired status notification for event only status type after event ends.";

		
		Login login_page = new Login(this.driver1);	
		Login_data login_data = new Login_data();
		User_data objUser_data = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		EventManagement EventManagement_page=new EventManagement(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);		
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);	
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType ResourceType_page = new ResourceType(this.driver1);
		String strStatusTypeValue[] = new String[4];
		Resource Resource_page = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();
		EventSetUp EventSetUp_page = new EventSetUp(this.driver1);
		SystemNotifications SystemNotifications_page = new SystemNotifications(this.driver1);
		Date_Time_settings objDts = new Date_Time_settings();
		
		UpdateStatus UpdateStatus_page1 = new UpdateStatus(this.driver1);
		Login login_page1 = new Login(this.driver1);
		EventStatus EventStatus_page1 = new EventStatus(this.driver1);
	    MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(this.driver1);
	    EventManagement EventManagement_page1=new EventManagement(this.driver1);
	    RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);	
	    
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		String strResourceTypeValue[] = new String[1];
		String strStatusesValue[] = new String[2];
		String strResourceValue[] = new String[1];
		
		UpdateStatus_data objUpdateStatus_data = new UpdateStatus_data();
		
		Event_data objEvent_data = new Event_data();
		String strMsgBody1 = "";
		String strMsgBody2 = "";
		String strMsgBody3 = "";
		String strMsgBody4 = "";
		String strApplicationTime= "";
		String strApplicationTime1 = "";
		String strCurrentYear = "";
		
		login_page.loginToApplication(login_data.strUserName, login_data.strPassword);
	    	    
	    SelectRegion_page.selectRegionAndNavigate(login_data.strRegionName);
	       
	    RegionDefault_page.selectFrame();
	    
	    StatusTypeList_page.navigateToStatusTypeList();
	    
	    StatusTypeList_page.createEventStatusTypeWithExpirationTime(objStatusTypes_data.strNumberStatusType, objStatusTypes_data.strNSTStatusTypeName, objStatusTypes_data.strStatusDescription, objStatusTypes_data.strStatusExpirationTime);
	    
	    strStatusTypeValue[0] = StatusTypeList_page.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);
	    
	    StatusTypeList_page.createStatusTypeWithExpirationTime(objStatusTypes_data.strSaturationScoreStatusType, objStatusTypes_data.strSSTStatusTypeName, objStatusTypes_data.strStatusDescription, objStatusTypes_data.strStatusExpirationTime);
 
	    strStatusTypeValue[1] = StatusTypeList_page.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);
	    
	    StatusTypeList_page.createEventStatusTypeWithExpirationTime(objStatusTypes_data.strNedocCalculationStatusType, objStatusTypes_data.strNDSTStatusTypeName, objStatusTypes_data.strStatusDescription, objStatusTypes_data.strStatusExpirationTime);

	    strStatusTypeValue[2] = StatusTypeList_page.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

	    StatusTypeList_page.createStatusType(objStatusTypes_data.strMultiStatusType, objStatusTypes_data.strMSTStatusTypeName, objStatusTypes_data.strStatusDescription);
    
	    StatusTypeList_page.createMultiStatusTypesWithExpirationTime(objStatusTypes_data.strStatusNameInMulti, objStatusTypes_data.strStatusExpirationTime);
	    		
	    strStatusesValue[0] = StatusTypeList_page.getMSTStatusesValue(objStatusTypes_data.strStatusNameInMulti);
	    
	    StatusTypeList_page.createMultiStatusTypesWithExpirationTime(objStatusTypes_data.strStatusNameInMulti1, objStatusTypes_data.strStatusExpirationTime);

	    strStatusesValue[1] =  StatusTypeList_page.getMSTStatusesValue(objStatusTypes_data.strStatusNameInMulti1);
	    
	    StatusTypeList_page.navigateToStatusTypeListNew();
	    
	    strStatusTypeValue[3] = StatusTypeList_page.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

	    String strStatusTypeValue1[] = {strStatusTypeValue[2], strStatusTypeValue[1], strStatusTypeValue[3], strStatusTypeValue[0]};
	    
	    ResourceType_page.navigateToResourceTypePage();
	    
	    ResourceType_page.createResourceType(objResourceType_data.strResourceTypeName, strStatusTypeValue1);	    

	    strResourceTypeValue[0] = ResourceType_page.getResourceTypeValue(objResourceType_data.strResourceTypeName);
	    
	    Resource_page.navigateToResourceListPage();
	    
	    Resource_page.createResource(objResource_data.strResourceName, objResource_data.strResourceAbbrivation, objResourceType_data.strResourceTypeName, objResource_data.strStandardResourceTypename, objResource_data.strResourceFirstName, objResource_data.strResourceLastName);
	    
	    strResourceValue[0] = Resource_page.getResourceValue(objResource_data.strResourceName);
	    
	    EventSetUp_page.navigateToEventSetUp();
	    
	    EventSetUp_page.createEventTemplate(objEventSetUp_data.strEventTemplate, objEventSetUp_data.strTemplateDefinition, strResourceTypeValue, strStatusTypeValue);
	
	    EventSetUp_page.deselectSelectAllWebOption();
	    
	    EventManagement_page.navigateToEventManagementNew();
	    
	    EventManagement_page.clickOnCreateNewEvent();
	    
	    EventManagement_page.clickOnCreateEvent(objEventSetUp_data.strEventTemplate);
	    
	    EventManagement_page.enterAdHocEventName(objEvent_data.strEventName);
	    
	    EventManagement_page.enterAdHocEventDescription(objEvent_data.strEventDescription);
	    	    
		objEvent_data.strEventStartTime = EventManagement_page
				.getEventStartDateAndTime();
		
		objEvent_data.strEventStartTime = objDts.converDateFormat(
				objEvent_data.strEventStartTime, "yyyy-MMM-dd HH:mm",
				"yyyy MMM dd HH mm");

		objEvent_data.strEventEndTime = objDts.AddTimeToExistingTimeHourAndMin(objEvent_data.strEventStartTime, 0, 6, "yyyy MMM dd HH mm");

		String strEndTime[] = objEvent_data.strEventEndTime.split(" ");
		
		EventManagement_page
				.selectEventEndDateAndTime(strEndTime);
	    
	    EventManagement_page.selectResource(strResourceValue[0]);
	    
	    EventManagement_page.clickOnSaveButton();
		
	    UsersList_page.navigateToUsers();
	    
	    UsersList_page.clickCreateNewUserButton();
	    
	    UsersList_page.enterUserMandatoryDetails(objUser_data.strNewUserName, objUser_data.strNewPassword, objUser_data.strFullName);
	
	    UsersList_page.enterPrimaryEmailId(objUser_data.strPrimaryMailId);
	    
	    UsersList_page.selectUpdateStatusOfResource(objResource_data.strResourceName);
	    
	    UsersList_page.selectFirstRole();
	    
	    UsersList_page.clickAdvancedOptionAndExpand();
	    
	    UsersList_page.selectMaintainEventsOption();
	    
	    UsersList_page.clickSaveButton();
	    
	    Thread.sleep(2000);
	    
		UsersList_page.searchUserName(objUser_data.strNewUserName,
				objUser_data.strRole, objUser_data.strResourceType,
				objUser_data.strUsername, objUser_data.strsearchOption);
		
	    UsersList_page.editUserDetails(objUser_data.strNewUserName);
	    
	    UsersList_page.clickOnsystemNotifyPreferences();
	    
	    SystemNotifications_page.selectExpiredNotificationsEmail();
	    
	    SystemNotifications_page.selectExpiredNotificationsPager();
	    
	    SystemNotifications_page.clickOnSaveButton();

	    login_page1.loginAsNewUser(objUser_data.strNewUserName, objUser_data.strNewPassword);
	    
	    RegionDefault_page1.selectFrame();
	    
	    EventManagement_page1.clickOnEventNameInEventBanner(objEvent_data.strEventName);
	    
	    EventStatus_page1.clickOnUpdateStatusKey(objResource_data.strResourceName);
	    
	    UpdateStatus_page1.clickOnSelectAll();
	    
	    UpdateStatus_page1.enterNSTAndTSTUpdateValue(strStatusTypeValue[0], objUpdateStatus_data.strNSTUpdateValue);
	    
	    UpdateStatus_page1.enterUpdateSSTValues(strStatusTypeValue[1], objUpdateStatus_data.strSSTUpdateValue);
	    
	    UpdateStatus_page1.enterNedocsUpdateValue(strStatusTypeValue[2], objUpdateStatus_data.strNDSTUpdateValue);

	    UpdateStatus_page1.selectMSTUpdateValue(strStatusTypeValue[3], strStatusesValue[0]);
	    
	    UpdateStatus_page1.clickOnSaveButton();
	    
	    strApplicationTime = EventManagement_page1.getApplicationTime();
	    
	    strCurrentYear = objDts.getCurrentDate("yyyy");
	    
	    strApplicationTime = strApplicationTime+" "+strCurrentYear;
	    
	    strApplicationTime = objDts.converDateFormat(strApplicationTime, "dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");

	    strApplicationTime = objDts.addTimetoExisting(strApplicationTime, 5, "MM/dd/yyyy HH:mm");
	    
	    strApplicationTime1 = objDts.addTimetoExisting(strApplicationTime, 1, "MM/dd/yyyy HH:mm");
	    
	    Thread.sleep(300000);

	    String strSubjName = "Expired Status Notification: "
				+ objResource_data.strResourceName;
	    
	    strMsgBody1 = objMailVerificationFunctions.getExpiredStatusEmailBody(objUser_data.strFullName, login_data.strRegionName, objStatusTypes_data.strMSTStatusTypeName, objResource_data.strResourceName, strApplicationTime);		
	    
	    strMsgBody2 = objMailVerificationFunctions.getExpiredStatusEmailBody(objUser_data.strFullName, login_data.strRegionName, objStatusTypes_data.strMSTStatusTypeName, objResource_data.strResourceName, strApplicationTime1);		
	
	    strMsgBody3 = objMailVerificationFunctions.getExpiredStatusEmailBody(objUser_data.strFullName, login_data.strRegionName, objStatusTypes_data.strSSTStatusTypeName, objResource_data.strResourceName, strApplicationTime);		
	    
	    strMsgBody4 = objMailVerificationFunctions.getExpiredStatusEmailBody(objUser_data.strFullName, login_data.strRegionName, objStatusTypes_data.strSSTStatusTypeName, objResource_data.strResourceName, strApplicationTime1);		

		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId, objUser_data.strPrimaryPwsd);
		
		objMailVerificationFunctions.NavToInbox(strSubjName);
		
		boolean boolCheck= false;
		boolean boolCheck1 = false;
		for(int intCount = 0; intCount<2; intCount++){
			
			objMailVerificationFunctions.verEmail(objUser_data.strPrimaryMailId, strSubjName);
			
			if(boolCheck==false){
			boolCheck = objMailVerificationFunctions.verifyMailBody(strMsgBody1);
			}
			
			if(boolCheck==false){
			boolCheck = objMailVerificationFunctions.verifyMailBody(strMsgBody2);
			}
			
			if(boolCheck1==false){
			boolCheck1 = objMailVerificationFunctions.verifyMailBody(strMsgBody3);
			}
			
			if(boolCheck1==false){
			boolCheck1 = objMailVerificationFunctions.verifyMailBody(strMsgBody4);
			}
			
			objMailVerificationFunctions.backToMailInbox();
		}
		assertTrue(boolCheck && boolCheck1);
		
		objMailVerificationFunctions.NavToInboxAndVerEmailIsNotPresentNew(strSubjName);
		
		objMailVerificationFunctions.logoutMail();
		gstrResult = "PASS";
	}


	/***************************************************************************************
	'Description	:Verify that user receive multiple expired status notification for event only status types that are associated with multiple resources participating in an event.
	'Date	 		:11-July-2014
	'Author			:Anil
	***************************************************************************************/
	
	@Test (description = "Verify that user receive multiple expired status notification for event only status types that are associated with multiple resources participating in an event.")
	public void testHappyDay142457() throws Exception {

		gstrTCID = "142457";
		gstrTO = "Verify that user receive multiple expired status notification for event only status types that are associated with multiple resources participating in an event.";
		
		
		Login login_page = new Login(this.driver1);	
		Login_data login_data = new Login_data();
		User_data objUser_data = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		EventManagement EventManagement_page=new EventManagement(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);		
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);	
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType ResourceType_page = new ResourceType(this.driver1);
		String strStatusTypeValue[] = new String[3];
		Resource Resource_page = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();
		EventSetUp EventSetUp_page = new EventSetUp(this.driver1);
		SystemNotifications SystemNotifications_page = new SystemNotifications(this.driver1);
		Date_Time_settings objDts = new Date_Time_settings();
		
		UpdateStatus UpdateStatus_page1 = new UpdateStatus(this.driver1);
		Login login_page1 = new Login(this.driver1);
		EventStatus EventStatus_page1 = new EventStatus(this.driver1);
	    MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(this.driver1);
	    EventManagement EventManagement_page1=new EventManagement(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);	
		
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[2];
		
		UpdateStatus_data objUpdateStatus_data = new UpdateStatus_data();
		
		Event_data objEvent_data = new Event_data();

		String strMsgBody[] = {"", "","","", "",""};

		String strApplicationTime= "";
		String strApplicationTime1 = "";
		String strCurrentYear = "";
		
		login_page.loginToApplication(login_data.strUserName, login_data.strPassword);
	    	    
	    SelectRegion_page.selectRegionAndNavigate(login_data.strRegionName);
	       
	    RegionDefault_page.selectFrame();
	    
	    StatusTypeList_page.navigateToStatusTypeList();
	    
	    StatusTypeList_page.createEventStatusTypeWithExpirationTime(objStatusTypes_data.strNumberStatusType, objStatusTypes_data.strNSTStatusTypeName, objStatusTypes_data.strStatusDescription, objStatusTypes_data.strStatusExpirationTime);
	    
	    strStatusTypeValue[0] = StatusTypeList_page.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);
	    
	    StatusTypeList_page.createStatusTypeWithExpirationTime(objStatusTypes_data.strSaturationScoreStatusType, objStatusTypes_data.strSSTStatusTypeName, objStatusTypes_data.strStatusDescription, objStatusTypes_data.strStatusExpirationTime);
 
	    strStatusTypeValue[1] = StatusTypeList_page.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);
	    
	    StatusTypeList_page.createEventStatusTypeWithExpirationTime(objStatusTypes_data.strNedocCalculationStatusType, objStatusTypes_data.strNDSTStatusTypeName, objStatusTypes_data.strStatusDescription, objStatusTypes_data.strStatusExpirationTime);

	    strStatusTypeValue[2] = StatusTypeList_page.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

	    String strStatusTypeValue1[] = {strStatusTypeValue[2], strStatusTypeValue[1], strStatusTypeValue[0]};
	    
	    ResourceType_page.navigateToResourceTypePage();
	    
	    ResourceType_page.createResourceType(objResourceType_data.strResourceTypeName, strStatusTypeValue1);	    

	    strResourceTypeValue[0] = ResourceType_page.getResourceTypeValue(objResourceType_data.strResourceTypeName);
	    
	    Resource_page.navigateToResourceListPage();
	    
	    Resource_page.createResource(objResource_data.strResourceName, objResource_data.strResourceAbbrivation, objResourceType_data.strResourceTypeName, objResource_data.strStandardResourceTypename, objResource_data.strResourceFirstName, objResource_data.strResourceLastName);
	        
	    strResourceValue[0] = Resource_page.getResourceValue(objResource_data.strResourceName);
	    
	    Resource_page.createResource(objResource_data.strResourceName1, objResource_data.strResourceAbbrivation, objResourceType_data.strResourceTypeName, objResource_data.strStandardResourceTypename, objResource_data.strResourceFirstName, objResource_data.strResourceLastName);
        
	    strResourceValue[1] = Resource_page.getResourceValue(objResource_data.strResourceName1);
    
	    EventSetUp_page.navigateToEventSetUp();
	    
	    EventSetUp_page.createEventTemplate(objEventSetUp_data.strEventTemplate, objEventSetUp_data.strTemplateDefinition, strResourceTypeValue, strStatusTypeValue);
	
	    EventSetUp_page.deselectSelectAllWebOption();
	    
	    UsersList_page.navigateToUsers();
	    
	    UsersList_page.clickCreateNewUserButton();
	    
	    UsersList_page.enterUserMandatoryDetails(objUser_data.strNewUserName, objUser_data.strNewPassword, objUser_data.strFullName);
	
	    UsersList_page.enterPrimaryEmailId(objUser_data.strPrimaryMailId);
	    
	    UsersList_page.selectUpdateStatusOfResource(objResource_data.strResourceName);
	    
	    UsersList_page.selectUpdateStatusOfResource(objResource_data.strResourceName1);
	    
	    UsersList_page.selectFirstRole();
	    
	    UsersList_page.clickAdvancedOptionAndExpand();
	    
	    UsersList_page.selectMaintainEventsOption();
	    
	    UsersList_page.clickSaveButton();
	    
	    Thread.sleep(2000);
	    
	    System.out.println(objUser_data.strResourceType);
	    
	    System.out.println(objUser_data.strUsername);
	    
		UsersList_page.searchUserName(objUser_data.strNewUserName,
				objUser_data.strRole, objUser_data.strResourceType,
				objUser_data.strUsername, objUser_data.strsearchOption);
		
	    UsersList_page.editUserDetails(objUser_data.strNewUserName);
	    
	    UsersList_page.clickOnsystemNotifyPreferences();
	    
	    SystemNotifications_page.selectExpiredNotificationsEmail();
	    
	    SystemNotifications_page.selectExpiredNotificationsPager();
	    
	    SystemNotifications_page.clickOnSaveButton();
	    
		login_page.clickLogOut();

	    login_page1.loginAsNewUser(objUser_data.strNewUserName, objUser_data.strNewPassword);
	    
	    RegionDefault_page1.selectFrame();
	    
	    EventManagement_page.navigateToEventManagement();
	    
	    EventManagement_page.clickOnCreateNewEvent();
	    
	    EventManagement_page.clickOnCreateEvent(objEventSetUp_data.strEventTemplate);
	    
	    EventManagement_page.enterAdHocEventName(objEvent_data.strEventName);
	    
	    EventManagement_page.enterAdHocEventDescription(objEvent_data.strEventDescription);
	    	    	    
	    EventManagement_page.selectResource(strResourceValue);
	    
	    EventManagement_page.clickOnSaveButton().verifyEventNameInEventBanner(objEvent_data.strEventName);
	    
	    EventManagement_page1.clickOnEventNameInEventBanner(objEvent_data.strEventName);
	    
	    EventStatus_page1.clickOnUpdateStatusKey(objResource_data.strResourceName);
	    
	    UpdateStatus_page1.clickOnSelectAll();
	    
	    UpdateStatus_page1.enterNSTAndTSTUpdateValue(strStatusTypeValue[0], objUpdateStatus_data.strNSTUpdateValue);
	    
	    UpdateStatus_page1.enterUpdateSSTValues(strStatusTypeValue[1], objUpdateStatus_data.strSSTUpdateValue);
	    
	    UpdateStatus_page1.enterNedocsUpdateValue(strStatusTypeValue[2], objUpdateStatus_data.strNDSTUpdateValue);
	    
	    UpdateStatus_page1.clickOnSaveButton();
	    
	    strApplicationTime = EventManagement_page1.getApplicationTime();
	    
	    strCurrentYear = objDts.getCurrentDate("yyyy");
	    
	    strApplicationTime = strApplicationTime+" "+strCurrentYear;
	    
	    strApplicationTime = objDts.converDateFormat(strApplicationTime, "dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");

	    strApplicationTime = objDts.addTimetoExisting(strApplicationTime, 5, "MM/dd/yyyy HH:mm");
	    
	    EventStatus_page1.clickOnUpdateStatusKey(objResource_data.strResourceName1);
	    
	    UpdateStatus_page1.clickOnSelectAll();
	    
	    UpdateStatus_page1.enterNSTAndTSTUpdateValue(strStatusTypeValue[0], objUpdateStatus_data.strNSTUpdateValue);
	    
	    UpdateStatus_page1.enterUpdateSSTValues(strStatusTypeValue[1], objUpdateStatus_data.strSSTUpdateValue);
	    
	    UpdateStatus_page1.enterNedocsUpdateValue(strStatusTypeValue[2], objUpdateStatus_data.strNDSTUpdateValue);
	    
	    UpdateStatus_page1.clickOnSaveButton();
	    
	    strApplicationTime1 = EventManagement_page1.getApplicationTime();
	    
	    strCurrentYear = objDts.getCurrentDate("yyyy");
	    
	    strApplicationTime1 = strApplicationTime1+" "+strCurrentYear;
	    
	    strApplicationTime1 = objDts.converDateFormat(strApplicationTime1, "dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");

	    strApplicationTime1 = objDts.addTimetoExisting(strApplicationTime1, 5, "MM/dd/yyyy HH:mm"); 
	    
	    System.out.println("waiting for 5 minutes");
	    
	    Thread.sleep(350000);

	    System.out.println("Waited for 5 minutes");
	    
		login_page1.clickLogOut();
		
	    String strSubjName = "Expired Status Notification: "
				+ objResource_data.strResourceName;
	    
		strMsgBody[0] = objMailVerificationFunctions.getExpiredStatusEmailBody(objUser_data.strFullName, login_data.strRegionName, objStatusTypes_data.strNSTStatusTypeName, objResource_data.strResourceName, strApplicationTime);

		strMsgBody[1] = objMailVerificationFunctions.getExpiredStatusEmailBody(objUser_data.strFullName, login_data.strRegionName, objStatusTypes_data.strSSTStatusTypeName, objResource_data.strResourceName, strApplicationTime);

		strMsgBody[2] = objMailVerificationFunctions.getExpiredStatusEmailBody(objUser_data.strFullName, login_data.strRegionName, objStatusTypes_data.strNDSTStatusTypeName, objResource_data.strResourceName, strApplicationTime);

		System.out.println(strSubjName);
		
		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId, objUser_data.strPrimaryPwsd);
		
		objMailVerificationFunctions.NavToInbox(strSubjName);
		
		boolean value[] = {false,false,false,false,false,false};

		
		for(int intCount = 0; intCount<3;intCount++){
			objMailVerificationFunctions.verEmail(objUser_data.strPrimaryMailId, strSubjName);
			
			if(value[0]==false){
				value[0] = objMailVerificationFunctions.verifyMailBody(strMsgBody[0]);
			}
			
			if(value[1]==false){
				value[1] = objMailVerificationFunctions.verifyMailBody(strMsgBody[1]);
			}
			
			if(value[2]==false){
				value[2] = objMailVerificationFunctions.verifyMailBody(strMsgBody[2]);
			}
			
			objMailVerificationFunctions.backToMailInbox();
		}
		
		
	    String strSubjName1 = "Expired Status Notification: "
				+ objResource_data.strResourceName1;
	    
		strMsgBody[3] = objMailVerificationFunctions.getExpiredStatusEmailBody(objUser_data.strFullName, login_data.strRegionName, objStatusTypes_data.strNSTStatusTypeName, objResource_data.strResourceName1, strApplicationTime1);

		strMsgBody[4] = objMailVerificationFunctions.getExpiredStatusEmailBody(objUser_data.strFullName, login_data.strRegionName, objStatusTypes_data.strSSTStatusTypeName, objResource_data.strResourceName1, strApplicationTime1);

		strMsgBody[5] = objMailVerificationFunctions.getExpiredStatusEmailBody(objUser_data.strFullName, login_data.strRegionName, objStatusTypes_data.strNDSTStatusTypeName, objResource_data.strResourceName1, strApplicationTime1);
		
		for(int intCount = 0; intCount<3;intCount++){
			objMailVerificationFunctions.verEmail(objUser_data.strPrimaryMailId, strSubjName1);
			
			if(value[3]==false){
				value[3] = objMailVerificationFunctions.verifyMailBody(strMsgBody[3]);
			}
			
			if(value[4]==false){
				value[4] = objMailVerificationFunctions.verifyMailBody(strMsgBody[4]);
			}
			
			if(value[5]==false){
				value[5] = objMailVerificationFunctions.verifyMailBody(strMsgBody[5]);
			}
			
			objMailVerificationFunctions.backToMailInbox();
		}
		
		assertTrue(value[0]&& value[1] && value[2] && value[3]&& value[4] && value[5]);
		
		objMailVerificationFunctions.logoutMail();

		gstrResult = "PASS";
	}


	/***************************************************************************************
	'Description	:Verify the user receives the expired status notification at the updated expiration time when a status type is edited and expiration time is changed after event creation.
	'Date	 		:16-July-2014
	'Author			:Anil
	***************************************************************************************/
	
	@Test (description = "Verify the user receives the expired status notification at the updated expiration time when a status type is edited and expiration time is changed after event creation.")
	public void testHappyDay142458() throws Exception {

		gstrTCID = "142458";
		gstrTO = "Verify the user receives the expired status notification at the updated expiration time when a status type is edited and expiration time is changed after event creation.";

		Login login_page = new Login(this.driver1);	
		Login_data login_data = new Login_data();
		User_data objUser_data = new User_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		EventManagement EventManagement_page=new EventManagement(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);		
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);	
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType ResourceType_page = new ResourceType(this.driver1);
		String strStatusTypeValue[] = new String[2];
		Resource Resource_page = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();
		EventSetUp EventSetUp_page = new EventSetUp(this.driver1);
		SystemNotifications SystemNotifications_page = new SystemNotifications(this.driver1);
		Date_Time_settings objDts = new Date_Time_settings();
		
		UpdateStatus UpdateStatus_page1 = new UpdateStatus(this.driver1);
		Login login_page1 = new Login(this.driver1);
		EventStatus EventStatus_page1 = new EventStatus(this.driver1);
	    MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(this.driver1);
	    EventManagement EventManagement_page1=new EventManagement(this.driver1);
	    RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		String strResourceTypeValue[] = new String[1];
		
		UpdateStatus_data objUpdateStatus_data = new UpdateStatus_data();
		
		Event_data objEvent_data = new Event_data();
		String strResourceValue[] = new String[1];
		String strMsgBody1 = "";
		String strMsgBody2 = "";
		String strApplicationTime= "";
		String strCurrentYear = "";
		
		login_page.loginToApplication(login_data.strUserName, login_data.strPassword);
	    	    
	    SelectRegion_page.selectRegionAndNavigate(login_data.strRegionName);
	       
	    RegionDefault_page.selectFrame();
	    
	    StatusTypeList_page.navigateToStatusTypeList();
	    
	    StatusTypeList_page.createEventStatusTypeWithExpirationTime(objStatusTypes_data.strNumberStatusType, objStatusTypes_data.strNSTStatusTypeName, objStatusTypes_data.strStatusDescription, objStatusTypes_data.strStatusExpirationTime);
	    
	    strStatusTypeValue[0] = StatusTypeList_page.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);
	    
	    StatusTypeList_page.createStatusTypeWithExpirationTime(objStatusTypes_data.strSaturationScoreStatusType, objStatusTypes_data.strSSTStatusTypeName, objStatusTypes_data.strStatusDescription, objStatusTypes_data.strStatusExpirationTime);
 
	    strStatusTypeValue[1] = StatusTypeList_page.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

	    String strStatusTypeValue1[] = {strStatusTypeValue[1],strStatusTypeValue[0]};
	    
	    ResourceType_page.navigateToResourceTypePage();
	    
	    ResourceType_page.createResourceType(objResourceType_data.strResourceTypeName, strStatusTypeValue1);	    

	    strResourceTypeValue[0] = ResourceType_page.getResourceTypeValue(objResourceType_data.strResourceTypeName);
	    
	    Resource_page.navigateToResourceListPage();
	    
	    Resource_page.createResource(objResource_data.strResourceName, objResource_data.strResourceAbbrivation, objResourceType_data.strResourceTypeName, objResource_data.strStandardResourceTypename, objResource_data.strResourceFirstName, objResource_data.strResourceLastName);
	    
	    strResourceValue[0] = Resource_page.getResourceValue(objResource_data.strResourceName);
	    
	    EventSetUp_page.navigateToEventSetUp();
	    
	    EventSetUp_page.createEventTemplate(objEventSetUp_data.strEventTemplate, objEventSetUp_data.strTemplateDefinition, strResourceTypeValue, strStatusTypeValue);
	
	    EventSetUp_page.deselectSelectAllWebOption();
	    
	    EventManagement_page.navigateToEventManagementNew();
	    
	    EventManagement_page.creatEvent(objEventSetUp_data.strEventTemplate, objEvent_data.strEventName, objEvent_data.strEventDescription, strResourceValue[0]);
	    
	    UsersList_page.navigateToUsers();
	    
	    UsersList_page.clickCreateNewUserButton();
	    
	    UsersList_page.enterUserMandatoryDetails(objUser_data.strNewUserName, objUser_data.strNewPassword, objUser_data.strFullName);
	
	    UsersList_page.enterPrimaryEmailId(objUser_data.strPrimaryMailId);
	    
	    UsersList_page.selectUpdateStatusOfResource(objResource_data.strResourceName);
	    
	    UsersList_page.selectFirstRole();
	    
	    UsersList_page.clickAdvancedOptionAndExpand();
	    
	    UsersList_page.selectMaintainEventsOption();
	    
	    UsersList_page.clickSaveButton();
	    
	    Thread.sleep(2000);
	    	
		UsersList_page.searchUserName(objUser_data.strNewUserName,
				objUser_data.strRole, objUser_data.strResourceType,
				objUser_data.strUsername, objUser_data.strsearchOption);
		
	    UsersList_page.editUserDetails(objUser_data.strNewUserName);
	    
	    UsersList_page.clickOnsystemNotifyPreferences();
	    
	    SystemNotifications_page.selectExpiredNotificationsEmail();
	    
	    SystemNotifications_page.selectExpiredNotificationsPager();
	    
	    SystemNotifications_page.clickOnSaveButton();

	    login_page1.loginAsNewUser(objUser_data.strNewUserName, objUser_data.strNewPassword);
	    
	    RegionDefault_page1.selectFrame();
	    
	    EventManagement_page1.clickOnEventNameInEventBanner(objEvent_data.strEventName);
	    
	    EventStatus_page1.clickOnUpdateStatusKey(objResource_data.strResourceName);
	    
	    UpdateStatus_page1.clickOnSelectAll();
	    
	    UpdateStatus_page1.enterNSTAndTSTUpdateValue(strStatusTypeValue[0], objUpdateStatus_data.strNSTUpdateValue);
	    
	    UpdateStatus_page1.enterUpdateSSTValues(strStatusTypeValue[1], objUpdateStatus_data.strSSTUpdateValue);
	    
	    UpdateStatus_page1.clickOnSaveButton();
	    
	    strApplicationTime = EventManagement_page1.getApplicationTime();
	    
	    strCurrentYear = objDts.getCurrentDate("yyyy");
	    
	    strApplicationTime = strApplicationTime+" "+strCurrentYear;
	    
	    strApplicationTime = objDts.converDateFormat(strApplicationTime, "dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");

	    strApplicationTime = objDts.addTimetoExisting(strApplicationTime, 10, "MM/dd/yyyy HH:mm");
	    
	    StatusTypeList_page.navigateToStatusTypeList();
	    
	    StatusTypeList_page.clickOnEditOfStatusType(objStatusTypes_data.strNSTStatusTypeName);
	    
	    StatusTypeList_page.selectExpirationMinute(objStatusTypes_data.strStatusExpirationTime1);
	    
	    StatusTypeList_page.clickOnSaveButton();
	    
	    StatusTypeList_page.clickOnEditOfStatusType(objStatusTypes_data.strSSTStatusTypeName);
	    
	    StatusTypeList_page.selectExpirationMinute(objStatusTypes_data.strStatusExpirationTime1);
	    
	    StatusTypeList_page.clickOnSaveButton();
	    
	    login_page.clickLogOut();
	    
	    Thread.sleep(300000);

	    String strSubjName = "Expired Status Notification: "
				+ objResource_data.strResourceName;
	    
		strMsgBody1 = objMailVerificationFunctions.getExpiredStatusEmailBody(objUser_data.strFullName, login_data.strRegionName, objStatusTypes_data.strNSTStatusTypeName, objResource_data.strResourceName, strApplicationTime);
		
		strMsgBody2 = objMailVerificationFunctions.getExpiredStatusEmailBody(objUser_data.strFullName, login_data.strRegionName, objStatusTypes_data.strSSTStatusTypeName, objResource_data.strResourceName, strApplicationTime);
		
		boolean value[] = {false, false};
		
		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId, objUser_data.strPrimaryPwsd);
		
		objMailVerificationFunctions.NavToInboxAndVerEmailIsNotPresent(strSubjName);
		
	objMailVerificationFunctions.logoutMail();
		
		System.out.println("Waiting for 5 minutes");
		Thread.sleep(360000);
		System.out.println("Waited for 5 minutes");
		
		objMailVerificationFunctions.loginToMail(objUser_data.strPrimaryMailId, objUser_data.strPrimaryPwsd);
		
		objMailVerificationFunctions.NavToInbox(strSubjName);
		
		for(int intCount = 0; intCount<2;intCount++){
			objMailVerificationFunctions.verEmail(objUser_data.strPrimaryMailId, strSubjName);
			
			if(value[0]==false){
				value[0] = objMailVerificationFunctions.verifyMailBody(strMsgBody1);
			}
			
			if(value[1]==false){
				value[1] = objMailVerificationFunctions.verifyMailBody(strMsgBody2);
			}

			objMailVerificationFunctions.backToMailInbox();
		}
		
		assertTrue(value[0]&& value[1]);
		
		objMailVerificationFunctions.logoutMail();

		gstrResult = "PASS";
	}

}
	