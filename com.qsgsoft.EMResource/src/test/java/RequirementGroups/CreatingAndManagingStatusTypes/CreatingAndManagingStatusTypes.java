package RequirementGroups.CreatingAndManagingStatusTypes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import qaFramework.Configurations.Configuration;
import qaFramework.Configurations.Configuration_Mails;
import EMR.data.EventData;
import EMR.data.EventData.EventCreateData;
import EMR.data.EventSetUpData;
import EMR.data.EventSetUpData.EventSetUpCreateData;
import EMR.data.LoginData;
import EMR.data.RegionData;
import EMR.data.RegionData.RegionCreateData;
import EMR.data.ResourceData;
import EMR.data.ResourceData.ResourceCreateData;
import EMR.data.ResourceTypeData;
import EMR.data.ResourceTypeData.ResourceTypeCreateData;
import EMR.data.RolesData;
import EMR.data.RolesData.RolesCreateData;
import EMR.data.StatusReasonData;
import EMR.data.StatusReasonData.StatusReasonCreateData;
import EMR.data.StatusTypeData;
import EMR.data.StatusTypeData.StatusTypeCreateData;
import EMR.data.UsersData;
import EMR.data.UsersData.UsersCreateData;
import EMR.data.ViewData;
import EMR.data.ViewData.ViewCreateData;
import EMR.pages.ConfigureNewRelationship;
import EMR.pages.EventManagement;
import EMR.pages.EventSetUp;
import EMR.pages.Login;
import EMR.pages.Mails;
import EMR.pages.OtherRegionList;
import EMR.pages.RegionDefault;
import EMR.pages.RegionList;
import EMR.pages.ResourceTypes;
import EMR.pages.Resources;
import EMR.pages.RolesList;
import EMR.pages.SelectRegion;
import EMR.pages.Shared;
import EMR.pages.StatusChangePreferences;
import EMR.pages.StatusReasonList;
import EMR.pages.StatusTypes;
import EMR.pages.UpdateStatus;
import EMR.pages.UsersList;
import EMR.pages.View;
import EMR.pages.ViewsUnderSetup;

public class CreatingAndManagingStatusTypes extends Configuration_Mails {

	LoginData loginData;
	ResourceTypeData resourceTypeData;
	ResourceTypeCreateData resourceTypeDataCreation;
	StatusTypeData statusTypeData;
	StatusTypeCreateData statusTypeDataCreation;
	ResourceCreateData resourceDataCreation;
	UsersCreateData userDataCreation;
	UsersData usersData;
	RolesData rolesData;
	RolesCreateData rolesDataCreation;
	ResourceData resourceData;
	ViewData viewData;
	ViewCreateData viewDataCreation;
	RegionData  regionData;
	RegionCreateData regionCreateData;
	EventSetUpData eventSetUpData;
	EventSetUpCreateData eventSetupDataCreation;
	StatusReasonData StatusReasonData;
	StatusReasonCreateData creatStatusReasonData;
	EventData eventData;
	EventCreateData  eventDataCreation;

	Login login;
	UsersList usersList;
	SelectRegion selectRegion;
	RegionDefault regionDefault;
	Shared navigateTo;
	RegionList regionList;
	StatusChangePreferences statusChangePreferences;
	RolesList rolesList; 
	ViewsUnderSetup viewUnderSetup;
	OtherRegionList otherRegionList;
	ConfigureNewRelationship configurRelationShip;
	EventSetUp eventSetUp;
	EventManagement eventManagement;
	StatusTypes statusTypes;
	ResourceTypes resourceTypes;
	Resources resources;
	StatusReasonList statusReasonList;
	ViewsUnderSetup view;
	UpdateStatus updateStatus;
	View views;
	Mails mail;

	public CreatingAndManagingStatusTypes() throws Exception {
		super();
	}

	@Test(groups = {"HappyDay"," Creating and Managing Status types", "HappyDay168826"})
	public void HappyDay168826() throws Exception {

		TCID ="168826";
		TC_DESCRIPTION ="Verify that status reasons selected while updating multi status type are displayed on status change notifications(Web,email and pager)";

		viewData = new ViewData();
		viewDataCreation = viewData.new ViewCreateData();
		statusTypeData=new StatusTypeData();
		statusTypeDataCreation = statusTypeData.new StatusTypeCreateData();
		resourceTypeData=new ResourceTypeData();
		resourceTypeDataCreation=resourceTypeData.new ResourceTypeCreateData();
		resourceData=new ResourceData();
		resourceDataCreation=resourceData.new ResourceCreateData();
		usersData=new UsersData();
		userDataCreation=usersData.new UsersCreateData();
		eventSetUpData = new EventSetUpData();
		eventSetupDataCreation = eventSetUpData.new EventSetUpCreateData();
		StatusReasonData = new StatusReasonData();
		creatStatusReasonData = StatusReasonData.new StatusReasonCreateData();
		eventData = new EventData();
		eventDataCreation = eventData.new EventCreateData();

		login = new Login(this.driver); 
		statusTypes = new StatusTypes(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		viewUnderSetup = new ViewsUnderSetup(this.driver);
		usersList = new UsersList(this.driver);
		resourceTypes = new ResourceTypes(this.driver);
		resources = new Resources(this.driver);
		configurRelationShip = new ConfigureNewRelationship(this.driver);
		eventSetUp = new EventSetUp(this.driver);
		statusReasonList = new StatusReasonList(this.driver);
		eventManagement = new EventManagement(this.driver);
		updateStatus = new UpdateStatus(this.driver);
		statusChangePreferences = new StatusChangePreferences(this.driver);
		view = new ViewsUnderSetup(this.driver);
		views= new View(this.driver);
		regionDefault = new RegionDefault(this.driver);
		mail = new Mails(this.driver1);

		String reasonValues[] = new String[3];
		String[] mstStatusTypesValues = new String[4];
		String[] statusesValues = new String[8];
		String[] resourceTypeValue = new String[1];
		String[] resourceValue = new String[1];

		login.loginToApplication(
				LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD);

		selectRegion.selectRegionAndClickOnNext(RegionData.REGIONNAME);

		navigateTo.views();
		viewUnderSetup.createNewSection(viewDataCreation.section);
		navigateTo.statusReasons();

		statusReasonList.createStatusReason(creatStatusReasonData.name, creatStatusReasonData.definition)
		.createStatusReason(creatStatusReasonData.name1, creatStatusReasonData.definition1)
		.createStatusReason(creatStatusReasonData.name2, creatStatusReasonData.definition)
		.verifyCreatedStatusReasonInList(creatStatusReasonData.name)
		.verifyCreatedStatusReasonInList(creatStatusReasonData.name1)
		.verifyCreatedStatusReasonInList(creatStatusReasonData.name2);

		reasonValues[0]=statusReasonList.getStatusReasonValue(creatStatusReasonData.name);
		reasonValues[1]=statusReasonList.getStatusReasonValue(creatStatusReasonData.name1);
		reasonValues[2]=statusReasonList.getStatusReasonValue(creatStatusReasonData.name2);

		List<String> allReasonValues= new ArrayList<String>(Arrays.asList(reasonValues[0],reasonValues[1],reasonValues[2]));
		String[] reasonNames={creatStatusReasonData.name,creatStatusReasonData.name1,creatStatusReasonData.name2};

		navigateTo.statusTypes();
		//shared mst
		statusTypes.createSharedStatusTypeWithReasons(StatusTypeData.MULTITYPE, statusTypeDataCreation.sharedMST, statusTypeDataCreation.description, viewDataCreation.section,allReasonValues);
		statusTypes.createNewStatusWithReasons(statusTypeDataCreation.statusesName, StatusTypeData.STATUS_PURPLE_COLOR, allReasonValues);
		statusesValues[0] =	statusTypes.getStatusesValue(statusTypeDataCreation.statusesName);
		statusTypes.createNewStatusWithReasons(statusTypeDataCreation.statusesName1, StatusTypeData.STATUS_PURPLE_COLOR, allReasonValues);		
		statusesValues[1]=statusTypes.getStatusesValue(statusTypeDataCreation.statusesName1);
		statusTypes.clickOnReturnToStatusTypeList();
		mstStatusTypesValues[0]=statusTypes.getStatusTypeValue(statusTypeDataCreation.sharedMST);

		//private mst
		statusTypes.createPrivateStatusTypeWithReasons(StatusTypeData.MULTITYPE, statusTypeDataCreation.privateMST, statusTypeDataCreation.description, viewDataCreation.section,allReasonValues);
		statusTypes.createNewStatusWithReasons(statusTypeDataCreation.statusesName2, StatusTypeData.STATUS_PURPLE_COLOR, allReasonValues);
		statusesValues[2] =statusTypes.getStatusesValue(statusTypeDataCreation.statusesName2);
		statusTypes.createNewStatusWithReasons(statusTypeDataCreation.statusesName3, StatusTypeData.STATUS_PURPLE_COLOR, allReasonValues);			
		statusesValues[3] =statusTypes.getStatusesValue(statusTypeDataCreation.statusesName3);
		statusTypes.clickOnReturnToStatusTypeList();
		mstStatusTypesValues[1]=statusTypes.getStatusTypeValue(statusTypeDataCreation.privateMST);

		//event mst
		statusTypes.createEventStatusTypeWithReasons(StatusTypeData.MULTITYPE, statusTypeDataCreation.eventMst, statusTypeDataCreation.description, viewDataCreation.section,allReasonValues);
		statusTypes.createNewStatusWithReasons(statusTypeDataCreation.statusesName4, StatusTypeData.STATUS_PURPLE_COLOR, allReasonValues);
		statusesValues[4] =statusTypes.getStatusesValue(statusTypeDataCreation.statusesName4);
		statusTypes.createNewStatusWithReasons(statusTypeDataCreation.statusesName5, StatusTypeData.STATUS_PURPLE_COLOR, allReasonValues);			
		statusesValues[5] =statusTypes.getStatusesValue(statusTypeDataCreation.statusesName5);
		statusTypes.clickOnReturnToStatusTypeList();
		mstStatusTypesValues[2]=statusTypes.getStatusTypeValue(statusTypeDataCreation.eventMst);

		//roled mst	
		statusTypes.createStatusTypeWithReasons(StatusTypeData.MULTITYPE, statusTypeDataCreation.mstName, statusTypeDataCreation.description, viewDataCreation.section,allReasonValues);
		statusTypes.createNewStatusWithReasons(statusTypeDataCreation.statusesName6, StatusTypeData.STATUS_PURPLE_COLOR, allReasonValues);
		statusesValues[6] = statusTypes.getStatusesValue(statusTypeDataCreation.statusesName6);
		statusTypes.createNewStatusWithReasons(statusTypeDataCreation.statusesName7, StatusTypeData.STATUS_PURPLE_COLOR, allReasonValues);			
		statusesValues[7] =	statusTypes.getStatusesValue(statusTypeDataCreation.statusesName7);
		statusTypes.clickOnReturnToStatusTypeList();
		mstStatusTypesValues[3]=statusTypes.getStatusTypeValue(statusTypeDataCreation.mstName);

		List<String> multiStatusTypeValues= new ArrayList<String>(Arrays.asList(mstStatusTypesValues[0],mstStatusTypesValues[1],mstStatusTypesValues[2],mstStatusTypesValues[3]));
		String[] statusTypeValues= {mstStatusTypesValues[0],mstStatusTypesValues[1],mstStatusTypesValues[2],mstStatusTypesValues[3]};	
		String[] statusTypesNames= {statusTypeDataCreation.sharedMST,statusTypeDataCreation.privateMST,statusTypeDataCreation.eventMst,statusTypeDataCreation.mstName};	

		navigateTo.resourceType();
		resourceTypes.createResourceType(resourceTypeDataCreation.name, multiStatusTypeValues);
		resourceTypeValue[0] = resourceTypes.getResourceTypeValue(resourceTypeDataCreation.name);

		navigateTo.resources();
		resources.createResourceWithAddress(
				resourceDataCreation.name, resourceDataCreation.abbrevation1,
				resourceTypeDataCreation.name, ResourceData.STANDARDRESOURCETYPE,
				ResourceData.FIRSTNAME, ResourceData.LASTNAME, ResourceData.STREETADDRESS, 
				ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE, ResourceData.COUNTY);
		resourceValue[0] = resources.getResourceValue(resourceDataCreation.name);

		System.out.println(resourceDataCreation.name);

		navigateTo.eventSetUp();
		eventSetUp.createEventTemplate(eventSetupDataCreation.name, eventSetupDataCreation.definition, resourceTypeValue[0], statusTypeValues);

		navigateTo.users();
		usersList.enterUserDetailsWithEMailAndPager(userDataCreation.name, UsersData.INITIAL_PASSWORD, userDataCreation.fullName, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID)
		.provideMaintainEventsRight()
		.provideStatusSnapShotRight()
		.provideEventSnapShotRight()
		.provideUpdateRightOnResourceAndSave(resourceDataCreation.name);

		usersList.searchUser(userDataCreation.name)
		.clickOnStatusChangeNotificationPreferences();

		statusChangePreferences.assignUserToStatusChangeNotifications(resourceDataCreation.name,resourceValue[0], userDataCreation.name, resourceTypeDataCreation.name)
		.expandAndverifyStatusTypesUnderUncategorizedSection(statusTypesNames)
		.provideReceiveStatusChangeNotificationsToStatusUnderMultiStatusType(resourceValue[0], mstStatusTypesValues[0], statusesValues[0], statusesValues[1])
		.provideReceiveStatusChangeNotificationsToStatusUnderMultiStatusType(resourceValue[0], mstStatusTypesValues[1], statusesValues[2], statusesValues[3])
		.provideReceiveStatusChangeNotificationsToStatusUnderMultiStatusType(resourceValue[0], mstStatusTypesValues[2], statusesValues[4], statusesValues[5])
		.provideReceiveStatusChangeNotificationsToStatusUnderMultiStatusType(resourceValue[0], mstStatusTypesValues[3], statusesValues[6], statusesValues[7]).clickOnSave()
		.verifyStatusTypesUnderResourceInStatusChangePreferncsPage(resourceDataCreation.name, statusTypesNames);
		navigateTo.views();   
		view.createView(viewDataCreation.name, viewDataCreation.description, resourceDataCreation.name, statusTypesNames);
		login.logOut();

		login.loginAsNewUser(userDataCreation.name, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);

		navigateTo.eventManagment();
		eventManagement.createEvent(eventSetupDataCreation.name, eventDataCreation.name, eventDataCreation.description, resourceDataCreation.name);
		eventManagement.verifyEventInformation(eventDataCreation.name, eventDataCreation.description);

		navigateTo.particularView(viewDataCreation.name);
		regionDefault.verifyResourceAndCorrespondingStatusTypes(
				resourceTypeDataCreation.name,
				resourceDataCreation.name,statusTypesNames);

		String shararedMstUpdatedValueBeforeUpdate= updateStatus.getUpdatedValueOfMultiStatusTypes(mstStatusTypesValues[0]);
		String privateMstUpdatedValueBeforeUpdate= updateStatus.getUpdatedValueOfMultiStatusTypes(mstStatusTypesValues[1]);
		String eventMstUpdatedValueBeforeUpdate= updateStatus.getUpdatedValueOfMultiStatusTypes(mstStatusTypesValues[2]);
		String roledMstUpdatedValueBeforeUpdate= updateStatus.getUpdatedValueOfMultiStatusTypes(mstStatusTypesValues[3]);

		regionDefault.clickOnUpdateStatusKeyAndNavigateToUpdateStatusPage(resourceDataCreation.name);
		updateStatus.verifyUpdateStatusPageAndSelectAllToUpdate();

		updateStatus.updateMultiStatusTypesWithReasons( mstStatusTypesValues[0],
				statusTypeDataCreation.statusesName, statusTypeDataCreation.statusesName1,
				statusesValues[0],statusesValues[1],shararedMstUpdatedValueBeforeUpdate,reasonValues[0]);

		updateStatus.updateMultiStatusTypesWithReasons( mstStatusTypesValues[1],
				statusTypeDataCreation.statusesName2, statusTypeDataCreation.statusesName3,
				statusesValues[2],statusesValues[3],privateMstUpdatedValueBeforeUpdate,reasonValues[1]);

		updateStatus.updateMultiStatusTypesWithReasons( mstStatusTypesValues[2],
				statusTypeDataCreation.statusesName4, statusTypeDataCreation.statusesName5,
				statusesValues[4],statusesValues[5],eventMstUpdatedValueBeforeUpdate,reasonValues[2]);

		updateStatus.updateMultiStatusTypesWithReasons( mstStatusTypesValues[3],
				statusTypeDataCreation.statusesName6, statusTypeDataCreation.statusesName7,
				statusesValues[6],statusesValues[7],roledMstUpdatedValueBeforeUpdate,reasonValues[0]);
		updateStatus.saveAndNavigateToUpdatedPage();

		String shararedMstUpdatedValueAfterUpdate= updateStatus.getUpdatedValueOfMultiStatusTypes(mstStatusTypesValues[0]);
		String privateMstUpdatedValueAfterUpdate= updateStatus.getUpdatedValueOfMultiStatusTypes(mstStatusTypesValues[1]);
		String eventMstUpdatedValueAfterUpdate= updateStatus.getUpdatedValueOfMultiStatusTypes(mstStatusTypesValues[2]);
		String roledMstUpdatedValueAfterUpdate= updateStatus.getUpdatedValueOfMultiStatusTypes(mstStatusTypesValues[3]);

		String[] updatedValues = {shararedMstUpdatedValueAfterUpdate,privateMstUpdatedValueAfterUpdate,eventMstUpdatedValueAfterUpdate,roledMstUpdatedValueAfterUpdate};

		updateStatus.verifyUpdatedStatusesValuesWithReasons(resourceValue[0], resourceDataCreation.name, reasonNames, statusTypeValues, updatedValues);
		String updatedDateAndTime = updateStatus.getUpdatedDateAndTimeForStatuUpdate(resourceValue[0]);

		String[] priveousUpdatedStatuses={shararedMstUpdatedValueBeforeUpdate,privateMstUpdatedValueBeforeUpdate,eventMstUpdatedValueBeforeUpdate,roledMstUpdatedValueBeforeUpdate};
		String[] newUpdatedStatuses={shararedMstUpdatedValueAfterUpdate,privateMstUpdatedValueAfterUpdate,eventMstUpdatedValueAfterUpdate,roledMstUpdatedValueAfterUpdate};
		String[] updatedReasons = {creatStatusReasonData.name,creatStatusReasonData.name1,creatStatusReasonData.name2,creatStatusReasonData.name};

		updateStatus.verifyWebNotificationForStatusUpdateWithStatusReasonsAndAcknowledge(
				resourceDataCreation.name, statusTypesNames,
				newUpdatedStatuses, priveousUpdatedStatuses,
				updatedDateAndTime, updatedReasons);

		mail.loginToMail(UsersData.PRIMARY_EMAILID, UsersData.EMAILPASSWORD);
		mail.verifyMailAndPagerNotificationsForStatusChangeNotificationsWithReasons(
				resourceDataCreation.abbrevation1, userDataCreation.fullName,
				updatedDateAndTime, resourceDataCreation.name,
				statusTypesNames, priveousUpdatedStatuses, newUpdatedStatuses,
				updatedReasons, RegionData.REGIONNAME,
				resourceTypeDataCreation.name).logoutMail();

		login.logOut();
		Result = "PASS";	
		/*String date =  updateStatus.getDateFormatForViewSnapShotReport();
		String[] updatedHourAndMin = updateStatus.getUpdatedHourAndMiniute(updatedDateAndTime);

		updateStatus.generateViewSnapShot(date, updatedHourAndMin[0], updatedHourAndMin[1]);

		List<String> updatedDetails = new ArrayList<String>(Arrays.asList(
										shararedMstUpdatedValueAfterUpdate,
										privateMstUpdatedValueAfterUpdate,
										eventMstUpdatedValueAfterUpdate,
										roledMstUpdatedValueAfterUpdate, creatStatusReasonData.name,
										creatStatusReasonData.name1, creatStatusReasonData.name2,
										creatStatusReasonData.name, userDataCreation.fullName));

		List<String> snapShotHeaders = new ArrayList<String>(Arrays.asList(
				                       statusTypeDataCreation.sharedMST,
									   statusTypeDataCreation.privateMST,
									   statusTypeDataCreation.eventMst,
									   statusTypeDataCreation.mstName));

		String mainWindowHandle = driver.getWindowHandle();
		updateStatus.switchToEventSnapShotWindow(mainWindowHandle);
		views.verifyViewSnapShotDetailesAndClose(viewDataCreation.name, resourceDataCreation.name, resourceTypeDataCreation.name,snapShotHeaders,updatedDetails);
		updateStatus.switchToMainWindow(mainWindowHandle);
		 */


	}
}
