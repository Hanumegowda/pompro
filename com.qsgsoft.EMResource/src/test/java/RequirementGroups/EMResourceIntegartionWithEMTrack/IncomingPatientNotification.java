package RequirementGroups.EMResourceIntegartionWithEMTrack;

import org.testng.annotations.Test;

import EMR.data.IncomingPatientNotificationData;
import EMR.data.IncomingPatientNotificationData.IncomingPatientNotificationCreateData;
import EMR.data.LoginData;
import EMR.data.MailsData;
import EMR.data.ManualIPNEntryData;
import EMR.data.ManualIPNEntryData.ManualIPNEntryCreateData;
import EMR.data.RegionData;
import EMR.data.ReportsData;
import EMR.data.ReportsData.ReportsCreateData;
import EMR.data.ResourceData;
import EMR.data.RolesData;
import EMR.data.UsersData;
import EMR.data.UsersData.UsersCreateData;
import EMR.pages.ConfigureIncomingPatientNotifications;
import EMR.pages.IncominPatientNotification;
import EMR.pages.Login;
import EMR.pages.Mails;
import EMR.pages.ManualIPNEntry;
import EMR.pages.RegionDefault;
import EMR.pages.Reports;
import EMR.pages.RolesList;
import EMR.pages.SelectRegion;
import EMR.pages.Shared;
import EMR.pages.UsersList;
import EMTrack.data.DashBoardData;
import EMTrack.data.EMTrackData;
import EMTrack.data.EMTrackData.EMTrackCreateData;
import EMTrack.data.EMTrackLoginData;
import EMTrack.pages.DashBoard;
import EMTrack.pages.EMTrackLogin;
import EMTrack.pages.PageNavigation;
import EMTrack.pages.Patient;
import qaFramework.Configurations.Configuration;
import qaFramework.Configurations.Configuration_Mails;

public class IncomingPatientNotification extends Configuration_Mails{
	
	RolesData rolesData;
	UsersData usersData;
	ManualIPNEntryData manualIPNEntryData;
	ManualIPNEntryCreateData manualIPNEntryCreatedata;
	ReportsData reportsData;
	ReportsCreateData reportsCreateData;
	
	Login login;
	Shared navigateTo;
	ManualIPNEntry manualIPNEntry;
	Reports reports;
	IncominPatientNotification incomingPatientNotification;
	RegionDefault regionDefault;
	RolesList rolesList;
	IncomingPatientNotificationData incomingPatientNotificationData;
	IncomingPatientNotificationCreateData incomingPatientNotificationCreateData;
	
	static String arrivalTime="";
	
	public IncomingPatientNotification() throws Exception {
		super();
	}
	EMTrackData emtrackData;
	EMTrackCreateData patientDataCreation;
	UsersCreateData usersDataCreation;
	
	SelectRegion selectRegion;
	ConfigureIncomingPatientNotifications incomingPatientNotifications;
	UsersList usersList;
	
	EMTrackLogin emtrackLogin;
	DashBoard dashBoard;
	PageNavigation pageNavigation;
	Patient patient;
	Mails mails;

	@Test (groups = {"HappyDay", "Setup", "HappyDay144032"})
	public void HappyDay144032() throws Exception {

		TCID = "144032";
		TC_DESCRIPTION = "Verify that user incoming patient notification is not received by the user if the Incoming patient notification option is not enabled for that region";

		/****
		 * LoginAsAdmin
		 * Navigate To Incoming Patients
		 * disableAllowManualEntryIPN
		 * Create user(U1) with affiliated right on resource and provide email address
		 * LoginToEMTrackAsAdmin
		 * AddPatient(MCI) 
		 * LoginAsUser(U1)
		 * verifyWebNotificationReceived
		 * verifyEmailAndPagerNotificationReceived
		 ****/
		usersData = new UsersData();
		usersDataCreation = usersData.new UsersCreateData();
		emtrackData = new EMTrackData();
		patientDataCreation = emtrackData.new EMTrackCreateData();
		
		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		incomingPatientNotifications = new ConfigureIncomingPatientNotifications(this.driver);
		usersList = new UsersList(this.driver);
		
		emtrackLogin = new EMTrackLogin(this.driver);
		dashBoard= new DashBoard(this.driver);
		pageNavigation = new PageNavigation(this.driver);
		patient = new Patient(this.driver);
		
		mails = new Mails(this.driver1);
		
		login.loginToApplication(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD);
	    selectRegion.selectRegionAndClickOnNext(RegionData.WISCONSIN_REGION);
	    navigateTo.incomingPatient();
	    incomingPatientNotifications.verifyAllowIPNEnabledAndAllowManualEntryOfIPNIsDeselected();
	    navigateTo.users();
	    usersList.createUserWithMandatoryDetailsBySelectingFirstRoleWithoutSave(usersDataCreation.name1, UsersData.INITIAL_PASSWORD, usersDataCreation.fullName1, UsersData.EMAILID1, UsersData.EMAILID1)
        .selectUpdateStatusOfResource(ResourceData.WISCONSIN_COLUMBUS_COMMUNITY_HOSPITAL)
        .provideReceiveIncomingPatientNotificationsRightAndSave()
        .enableUserToReceivePagerAndMailNotifiactionsOfIPN(usersDataCreation.name1);  
	    login.logOut();
	    
	    emtrackLogin.loginToEMTrack(EMTrackLoginData.EMTRACKADMINUSER, EMTrackLoginData.EMTRACKPASSWORD);
	    dashBoard.selectLocation(DashBoardData.WISCONSIN_REGION);
	    pageNavigation.navigateToPatientPage();

		patient.addMCITriagePatient(patientDataCreation.patientId,patientDataCreation.age, EMTrackData.AURORA_MEDICAL_CENTER_SUMMIT, EMTrackData.WISCONSIN_REGION_COLUMBUS_COMMUNITY_HOSPITAL, EMTrackData.ASMC_BUS_PROVIDER, EMTrackData.PROVIDERUNIT, EMTrackData.ETA);
		emtrackLogin.logOut();
		
		login.loginAsNewUser(usersDataCreation.name1, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD)
		     .verifyWebNotificationIsNotReceived()
		     .logOut();
		
		mails.loginToMail(UsersData.EMAILID1, UsersData.EMAILPASSWORD);
		String subject = MailsData.IPN_MAIL_SUBJECT + ResourceData.WISCONSIN_COLUMBUS_COMMUNITY_HOSPITAL;
		mails.NavToInboxAndVerEmailIsNotPresent(subject)
		     .logoutMail();
		
		login.loginToApplication(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD);
	    selectRegion.selectRegionAndClickOnNext(RegionData.WISCONSIN_REGION);
	    navigateTo.incomingPatient();
	    incomingPatientNotifications.verifyAllowIPNEnabledAndAllowManualEntryOfIPNIsSelected();
	    login.logOut();
		     
		Result = "PASS";
	}
    
	
		@Test (groups ={"HappyDay", "Incoming Patient Notification", "HappyDay144049"})
		public void HappyDay144049() throws Exception{
			
			TCID = "144049";
			TC_DESCRIPTION = "Verify that acknowledge column is updated in IPN report once user acknowledges the notification";
			
			/*********
			*Login to the application from user U1
			
			*Navigate to form
			*Click on 'Send Incoming Patient Notification'
			*Enter the data in manual IPN Entry page
			*Verify Web notification.
			*Login to the application from user U2 and Acknowledge the notification
			*Navigate to Report
			*Click on Incoming Patient Notification Details
			*Enter the data in Incoming Notification Details Report page.
			*Click on Generate report
			*verify that all the details are retained in the generated report.   
			*/
			login = new Login(this.driver);
			navigateTo = new Shared(this.driver);
			usersData =new UsersData();
			navigateTo = new Shared(this.driver);
			manualIPNEntry =new ManualIPNEntry(this.driver);
			manualIPNEntryData = new ManualIPNEntryData();
			manualIPNEntryCreatedata = manualIPNEntryData.new ManualIPNEntryCreateData();
			reports = new Reports(this.driver);
			reportsData = new ReportsData();
			reportsCreateData =reportsData.new ReportsCreateData();
			
			login.loginAsUser(usersData.SetracUserWithSendIncomingPatientNotificationsRight, UsersData.PASSWORD);
			navigateTo.naviagteToSendIncomingPatientNotification();
			manualIPNEntry.enterManualIPNEntryData(ManualIPNEntryData.MALE, ManualIPNEntryData.AGE, ManualIPNEntryData.CHEIF_COMPLAINT, ManualIPNEntryData.TRAIAGE_CATEGORY, ManualIPNEntryData.LEVEL_OF_CARE, manualIPNEntryCreatedata.emsAgency, manualIPNEntryCreatedata.emsUnit, ManualIPNEntryData.TANSPORTING_TO, ManualIPNEntryData.ETA);
			manualIPNEntry.verifyIncomingPatientNotificationMessage();			  
			login.logOut();
			
			login.loginAsUserAndAcknowledgeWebNotification(UsersData.USER, UsersData.PASSWORD);
			navigateTo.navigateToResourceReports()
			.navigateToIncomingPatientNotificationDetails();
			reports.verifyIncomingPatientNotificationDeatailsReportPage();
			reports.enterStartDateAndEndDate(reportsCreateData.startDate, reportsCreateData.endDate);
			Result = "PASS";
			
		}

	@Test (groups = {"HappyDay", "Incoming Patient Notification", "HappyDay144045"})
	public void HappyDay144045() throws Exception {

		TCID = "144045";
		TC_DESCRIPTION = "Verify that user with appropriate right and without affiliated right on resource do not "
				+ "receive IPN notification when a patient is added in EMTrack.";

		/****
		* Create user (U1) with IPN - Receive Incoming Patient Notifications right and without affiliated right on resource.
		* LoginEMTrackAsAdmin
		* AddPatient(MCI) 
		* LoginAsUser(U1)
		* verifyWebNotificationNotReceived.
		* verifyEmailAndPagerNotificationNotReceived
		 ****/
		
		Result = "PASS";
	}

	@Test (groups = {"HappyDay", "Incoming Patient Notification", "HappyDay144034"})
	public void HappyDay144034() throws Exception {

		TCID = "144034";
		TC_DESCRIPTION = "Verify that user receives the IPN notifications to the updated notification method when "
				+ "a patient is added / submitted from EMTrack.";


		/****
		* Create user (U1) with 'IPN - Receive Incoming Patient Notifications' right and affiliated right on resource and user is subscribed to receive only 'web' notification.
		* loginEMTrackAsAdmin
		* addPatient(MCI) 
		* loginAsUser(U1)
		* verifyOnlyWebNotificationReceived
		* verifyEmailAndPagerNotificationNotReceived
		* loginAsAdmin
		* Navigate  to Users
		* updateIPNSubscription(U1)  (remove web subscription and subscribe for e-mail)
		* loginEMTrackAsAdmin
		* addPatient(MCI) 
		* loginAsUser(U1)
		* verifyOnlyEmailNotificationReceived
		 ****/
		
		Result = "PASS";
	}
	
	@Test (groups = {"HappyDay", "Incoming Patient Notification", "HappyDay144052"})
	public void HappyDay144052() throws Exception {

		TCID = "144052";
		TC_DESCRIPTION = "Verify that user who have �Receive Incoming Patient Notifications� and affiliated right on"
				+ " resources is able to receive IPN notification";

		/****
		* Create user (U1) with 'IPN - Receive Incoming Patient Notifications' right and affiliated right on resource
		* Create user (U2) without 'IPN - Receive Incoming Patient Notifications' right and affiliated right on resource
		* loginEMTrackAsAdmin
		* addPatient(MCI) 
		* loginAsUser(U1)
		* verifyWebNotificationReceived
		* verifyEmailAndPagerNotificationReceived
		* loginAsUser(U2)
		* verifyWebNotificationNotReceived
		* verifyEmailAndPagerNotificationNotReceived

		 ****/
		
		login = new Login (this.driver);
		selectRegion = new SelectRegion(this.driver); 
		navigateTo = new Shared(this.driver);
		usersList = new UsersList(this.driver);
		dashBoard= new DashBoard(this.driver);
		pageNavigation = new PageNavigation(this.driver);
		
		login.loginToApplication(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD);
		selectRegion.selectRegionAndClickOnNext(RegionData.WISCONSIN_REGION);
		navigateTo.users();
		usersList.createUserWithMandatoryDetailsBySelectingFirstRoleWithoutSave(usersDataCreation.name3, UsersData.PASSWORD, usersDataCreation.fullName3, UsersData.EMAILID1, UsersData.EMAILID1)
		.selectUpdateStatusOfResource(ResourceData.WISCONSIN_COLUMBUS_COMMUNITY_HOSPITAL)
		.provideReceiveIncomingPatientNotificationsRight();
		usersList.createUserWithMandatoryDetailsAndEMailPager(usersDataCreation.name4, UsersData.PASSWORD, usersDataCreation.fullName3, UsersData.EMAILID1, UsersData.EMAILID1)
		.clickOnSave();
		login.loginToApplication(EMTrackLoginData.EMTRACKADMINUSER, EMTrackLoginData.EMTRACKPASSWORD);
		dashBoard.selectLocation(DashBoardData.WISCONSIN_REGION);
		pageNavigation.navigateToPatientPage();
		patient.addMCITriagePatient(patientDataCreation.patientId2, patientDataCreation.age2, EMTrackData.AURORA_MEDICAL_CENTER_SUMMIT, EMTrackData.WISCONSIN_REGION_COLUMBUS_COMMUNITY_HOSPITAL, EMTrackData.ASMC_BUS_PROVIDER, EMTrackData.PROVIDERUNIT, EMTrackData.ETA);
		Result = "PASS";
	}
	
	@Test (groups = {"HappyDay", "Incoming Patient Notification", "HappyDay144277"})
	public void HappyDay144277() throws Exception {

		TCID = "144277";
		TC_DESCRIPTION = "Verify that user receives previous unacknowledged IPN notifications when �Receive "
				+ "Incoming Patient Notifications� and affiliated right on resources is provided.";


		/****
		* Create user (U1) with 'IPN - Receive Incoming Patient Notifications' right and affiliated right on resource
		* loginEMTrackAsAdmin
		* addPatient(MCI) 
		* loginAsUser(U1)
		* verifyWebNotificationReceived
		* verifyEmailAndPagerNotificationReceived
		* loginEMTrackAsAdmin
		* addPatient(MCI) 
		* loginAsUser(U1)
		* verifyWebNotificationReceived 
		* verifyPreviousNotificationReceived.
		* verifyEmailAndPagerNotificationReceived
		 ****/
		
		Result = "PASS";
	}
	
	@Test (groups = {"HappyDay", "Incoming Patient Notification", "HappyDay144051"})
	public void HappyDay144051() throws Exception {

		TCID = "144051";
		TC_DESCRIPTION = "Verify that acknowledge column is updated in �Form >> Incoming patient Notification� once"
				+ " user acknowledges the notification.";
		
		/****
		* Create user (U1) with 'IPN - Receive Incoming Patient Notifications' right and affiliated right on resource
		* loginEMTrackAsAdmin
		* addPatient(MCI) 
		* loginAsUser(User11472465968177)
		* verifyWebNotificationReceived
		* acknowledgeWebNotification
		* Navigate to Incoming Patient Notifications
		* verifyAcknowledgeColumnsUpdated

		 ****/
		login = new Login(this.driver);
		usersData = new UsersData();
		usersDataCreation = usersData.new UsersCreateData();
		emtrackLogin = new EMTrackLogin(this.driver);
		dashBoard= new DashBoard(this.driver);
		pageNavigation = new PageNavigation(this.driver);
		patient = new Patient(this.driver);
		selectRegion = new SelectRegion(this.driver);
		usersList = new UsersList(this.driver);
		navigateTo = new Shared(this.driver);
		emtrackLogin = new EMTrackLogin(this.driver);
		emtrackData = new EMTrackData();
		patientDataCreation = emtrackData.new EMTrackCreateData();
		
		incomingPatientNotification = new IncominPatientNotification(this.driver);
		regionDefault = new RegionDefault(this.driver);
		incomingPatientNotificationData = new IncomingPatientNotificationData(); 
		incomingPatientNotificationCreateData =incomingPatientNotificationData. new IncomingPatientNotificationCreateData();
		
		login.loginToApplication(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD);
	    selectRegion.selectRegionAndClickOnNext(RegionData.WISCONSIN_REGION);
	    navigateTo.users();
	    usersList.createUserWithMandatoryDetailsBySelectingFirstRoleWithoutSave(usersDataCreation.name2, UsersData.INITIAL_PASSWORD, usersDataCreation.fullName2, UsersData.EMAILID1, UsersData.EMAILID1)
	    .selectUpdateStatusOfResource(ResourceData.WISCONSIN_COLUMBUS_COMMUNITY_HOSPITAL)
	    .provideReceiveIncomingPatientNotificationsRightAndSave();
	    login.logOut();
		
	    emtrackLogin.loginToEMTrack(EMTrackLoginData.EMTRACKADMINUSER, EMTrackLoginData.EMTRACKPASSWORD);
		dashBoard.selectLocation(DashBoardData.WISCONSIN_REGION);
		pageNavigation.navigateToPatientPage();
		patient.addMCITriagePatient(patientDataCreation.patientId1,patientDataCreation.age1, EMTrackData.AURORA_MEDICAL_CENTER_SUMMIT, EMTrackData.WISCONSIN_REGION_COLUMBUS_COMMUNITY_HOSPITAL, EMTrackData.ASMC_BUS_PROVIDER, EMTrackData.PROVIDERUNIT, EMTrackData.ETA);
		emtrackLogin.logOut();
		
		login.loginAsNewUser(usersDataCreation.name2, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
		regionDefault.verifyIPNWebNotifaicationContentAndAcknowledge(EMTrackData.WISCONSIN_REGION_COLUMBUS_COMMUNITY_HOSPITAL, EMTrackLoginData.EMTRACKADMINUSER, patientDataCreation.age1, EMTrackData.CHIEFCOMPLAINT, EMTrackData.TRIAGE, EMTrackData.GENDER_FEMALE, EMTrackData.WISCONSIN_REGION_COLUMBUS_COMMUNITY_HOSPITAL, EMTrackData.LEVELOFCARE, EMTrackData.EMSAGENCY, EMTrackData.EMSUNIT);
		navigateTo.naviagteToIncomingPatientNotification();
		incomingPatientNotification.verifyIncomingPatientNotificationsInLast24Hourspage();
//		.verifyIncomingPAtientNotificationDetails(EMTrackData.WISCONSIN_REGION_COLUMBUS_COMMUNITY_HOSPITAL, SentAt, SentBy, IncomingPatientNotificationData.ETA, incomingPatientNotificationCreateData.age, IncomingPatientNotificationData.COMPLAINT, IncomingPatientNotificationData.TRAIGE, IncomingPatientNotificationData.GENDER, IncomingPatientNotificationData.REGION, AcknowledgeAt, AcknowledgeBy);
		
		Result = "PASS";
	}
	
	@Test (groups = {"HappyDay", "Incoming Patient Notification", "HappyDay144536"})
	public void HappyDay144536() throws Exception {

		TCID = "144536";
		TC_DESCRIPTION = "Verify that user cannot generate IPN report when 'Run Report' right on resource is not given.";

		/****
		* Create user (U1) with 'IPN - Receive Incoming Patient Notifications' right and affiliated right on resource
		* Create user (U2) with 'Report - Incoming Patient Notification Detail' right and without 'Run Report' right on resource
		* loginEMTrackAsAdmin
		* addPatient(MCI) 
		* loginAsUser(U1)
		* acknowledgeWebNotification
		* loginAsUser(U2)
		* cannotGenerateReport

		 ****/
		
		Result = "PASS";
	}

	@Test (groups = {"HappyDay", "Incoming Patient Notification", "HappyDay163711"})
	public void HappyDay163711() throws Exception {

		TCID = "163711";
		TC_DESCRIPTION = "Verify that only users with 'Receive Incoming Patient Notification' are able to receive"
				+ " IPN notifications.";


		/****
		* Create user (U1) with only  'IPN - Receive Incoming Patient Notifications' right
		* Create user (U2) with 'IPN - Receive Incoming Patient Notifications' right and affiliated right on resource
		* Create user (U3) without 'IPN - Receive Incoming Patient Notifications' right
		* loginEMTrackAsAdmin
		* addPatient(MCI) 
		* loginAsUser(U1)
		* verifyWebNotificationNotReceived
		* loginAsUser(U2)
		* verifyWebNotificationReceived
		* loginAsUser(U3)
		* verifyWebNotificationNotReceived
		
		 ****/
		
		Result = "PASS";
	}
	
	@Test (groups = {"HappyDay", "Incoming Patient Notification", "HappyDay163631"})
	public void HappyDay163631() throws Exception {

		TCID = "163631";
		TC_DESCRIPTION = "Verify that user with 'Create Incoming Patient Notifications' right can manually setup"
				+ " IPN entry from Form >> Add Incoming Patient Notifications�.(If enabled for region)";

		/****
		* Create user (U1) with 'IPN - Send Incoming Patient Notifications' right
		* Create user (U2) with 'IPN - Receive Incoming Patient Notifications' right and affiliated right on resource
		* loginAsUser(U1)
		* Navigate to Send Incoming Patient Notification
		* fillPatientDetailsAndSend
		* loginAsUser(U2)
		* verifyWebNotificationReceived

		 ****/
		
		Result = "PASS";
	}
	
	@Test (groups = {"HappyDay", "Incoming Patient Notification", "HappyDay165604"})
	public void HappyDay165604() throws Exception {

		TCID = "165604";
		TC_DESCRIPTION = "Verify that only admin user can access / configure IPN fields from 'Form >> "
				+ "Incoming Patient' section.";

		/****
		* Create user (U1) with 'IPN - Send Incoming Patient Notifications' right
		* Create user (U2) with 'IPN - Receive Incoming Patient Notifications' right
		* loginAsUser(U1)
		* verifyIncomingPatientsOptionUnavailableForUser
		* loginAsUser(U2)
		* verifyIncomingPatientsOptionUnavailableForUser
		* LoginAsAdmin
		* verifyIncomingPatientsOptionAvailable
		
		 ****/
		
		Result = "PASS";
	}
	
	@Test (groups = {"HappyDay", "Incoming Patient Notification", "HappyDay175970"})
	public void HappyDay175970() throws Exception {

		TCID = "175970";
		TC_DESCRIPTION = "Verify that a user with �IPN - Receive Incoming Patient Notifications� / "
				+ "�IPN - Create Incoming Patient Notifications� right can view Patients added from EMResource "
				+ "or EMtrack on �Incoming Patient Notifications In Last 24 Hours� page";


		/****
		* Create user (U1) with 'IPN - Send Incoming Patient Notifications' right
		* Create user (U2) with 'IPN - Receive Incoming Patient Notifications' right
		* loginEMTrackAsAdmin
		* addPatient(MCI) 
		* loginAsUser(U1)
		* addPatientEMResource(U1)
		* verifyWebNotificationReceived
		* acknowledgeWebNotification
		* verifyPatientsAddedFromEMResourceListed
		* loginAsUser(U2)
		* acknowledgeWebNotification
		* verifyPatientsAddedFromEMResourceAndEMTrackListed

		 ****/
		
		Result = "PASS";
	}
	
	@Test (groups = {"HappyDay", "Incoming Patient Notification", "HappyDay176775"})
	public void HappyDay176775() throws Exception {

		TCID = "176775";
		TC_DESCRIPTION = " Verify that only the patients which are added by user ‘U1 (IPN - Create Incoming "
				+ "Patient Notifications’ right)’ ‘are listed under ‘Incoming Patient Notifications in Last "
				+ "24 Hours’ page.";

		/****
		* Create user (U1) with 'IPN - Send Incoming Patient Notifications' right
		* Create user (U2) with 'IPN - Send Incoming Patient Notifications / IPN - Receive Incoming Patient Notifications' right and affiliated right on resource
		* loginEMTrackAsAdmin
		* addPatient(MCI) 
		* loginAsUser(U1)
		* addPatientEMResource(U1)
		* verifyWebNotificationReceived
		* acknowledgeWebNotification
		* verifyPatientsAddedFromEMResourceListed
		* loginEMTrackAsAdmin
		* addPatient(MCI) 
		* loginAsUser(U2)
		* addPatientEMResource(U2)
		* verifyWebNotificationReceived
		* acknowledgeWebNotification
		* verifyPatientsAddedFromEMResourceAndEMTrackListed
		 ****/
		
		Result = "PASS";
	}
	
	
	@Test (groups = {"HappyDay", "Incoming Patient Notification", "HappyDay183894"})
	public void HappyDay183894() throws Exception {

		TCID = "183894";
		TC_DESCRIPTION = "Verify that 'Add Incoming Patient Notification' is renamed to 'Send Incoming Patient Notification' on all 'Menu' items and user rights section. ";

		/****
		* LoginAsAdmin
		* verifySendIncomingPatientNotificationIsDisplayedInAdvancedOptionsList
		* Navigate to role >> edit the role (SetracRegionRoleWithoutAnyRight) and verify 'IPN - Send Incoming Patient Notifications' is displayed
		* loginAsUser(SetracUserWithSendIncomingPatientNotificationsRight)
		* verifySendIncomingPatientNotificationIsDisplayedInFormList
		* verifySendIncomingPatientNotificationIsDisplayedInIncomingPatientNotificationsInLast24HoursPage
		 ****/
		rolesData = new RolesData();
		usersData = new UsersData();
		usersDataCreation = usersData.new UsersCreateData();
		
		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		usersList = new UsersList(this.driver);
		rolesList = new RolesList(this.driver);
		
		login.loginToApplication(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD);
		selectRegion.selectRegionAndClickOnNext(RegionData.SETRACREGION);
		navigateTo.users();
		usersList.verifySendIPNUnderAdvancedOption();
		
		navigateTo.roles();
		rolesList.editRoleAndVerifyIPNSendIncomingPatientNotifications(rolesData.setrac_Region_Role_Without_Rights);
		login.logOut();
		
		login.loginAsUser(usersData.SetracUserWithSendIncomingPatientNotificationsRight, UsersData.PASSWORD);
		navigateTo.formMenu()
		          .verifySendIncomingPatientNotification()
		          .naviagteToIncomingPatientNotification()
		          .verifySendIncomingPatientNotificationInIPNLast24HoursPage();
		login.logOut();
		Result = "PASS";
	}
	
	@Test (groups = {"HappyDay", "Incoming Patient Notification", "HappyDay147972"})
	public void HappyDay147972() throws Exception {

		TCID = "147972";
		TC_DESCRIPTION = "Verify that user with appropriate right receives web mail notification when patient is submitted from EMTrack";

		/****
		* Add patient from EMTrack.
		* Login as user 'SetracUserWithReceiveIncomingPatientNotificationsRight'
		* Verify web notification is received by user 'SetracUserWithReceiveIncomingPatientNotificationsRight'
		* Verify e-mail notification is received by user 'SetracUserWithReceiveIncomingPatientNotificationsRight'
		
		 ****/
		emtrackData = new EMTrackData();
		patientDataCreation = emtrackData.new EMTrackCreateData();
		usersData = new UsersData();
		
		emtrackLogin = new EMTrackLogin(this.driver);
		dashBoard= new DashBoard(this.driver);
		pageNavigation = new PageNavigation(this.driver);
		patient = new Patient(this.driver);
		
		mails = new Mails(this.driver1);
		
		login = new Login(this.driver);
		regionDefault = new RegionDefault(this.driver);
		
		emtrackLogin.loginToEMTrack(EMTrackLoginData.EMTRACKADMINUSER, EMTrackLoginData.EMTRACKPASSWORD);
	    dashBoard.selectLocation(DashBoardData.SETRAC_REGION);
	    pageNavigation.navigateToPatientPage();

		patient.addPatientDetailes(patientDataCreation.patientId, EMTrackData.GENDER_FEMALE, patientDataCreation.age, EMTrackData.SETRAC_REGION_COLUMBUS_COMMUNITY, EMTrackData.DISASTER_EMS_UNIT_PROVIDER, EMTrackData.PROVIDERUNIT, EMTrackData.ETA);
		emtrackLogin.logOut();
		
		login.loginAsUser(usersData.SetracUserWithReceiveIncomingPatientNotificationsRight, UsersData.PASSWORD);
		regionDefault.verifyRegionName(RegionData.SETRACREGION);
		arrivalTime = regionDefault.verifyIPNWebNotifaicationContentAndAcknowledge(ResourceData.SETRAC_RESOURCE_COLUMBUS_COMMUNITY, EMTrackLoginData.EMTRACKADMINUSER, patientDataCreation.age, EMTrackData.CHIEFCOMPLAINT, EMTrackData.TRIAGE, EMTrackData.GENDER_FEMALE, RegionData.SETRACREGION, EMTrackData.LEVELOFCARE,
								EMTrackData.EMSAGENCY, EMTrackData.EMSUNIT);
		login.logOut();
		
		mails.loginToMail(UsersData.EMAILID1, UsersData.EMAILPASSWORD);
		mails.verifyMailAndPagerNotificationsForPatientAddedInEMTrack(
				EMTrackLoginData.EMTRACKADMINUSER, RegionData.SETRACREGION,
				arrivalTime, EMTrackData.GENDER_FEMALE,
				patientDataCreation.age, EMTrackData.CHIEFCOMPLAINT,
				EMTrackData.TRIAGE, EMTrackData.LEVELOFCARE,
				EMTrackData.EMSAGENCY, EMTrackData.EMSUNIT,
				UsersData.EMAILID1,ResourceData.SETRAC_RESOURCE_COLUMBUS_COMMUNITY)
				.logoutMail();
		
		Result = "PASS";
	}
	}
	

