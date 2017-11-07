package DatabaseRefresh_DataCreation.HappyDay;

import org.apache.commons.lang3.ArrayUtils;
import org.testng.annotations.Test;

import EMR.data.EventSetUpData;
import EMR.data.LoginData;
import EMR.data.RegionData;
import EMR.data.ResourceData;
import EMR.data.ResourceTypeData;
import EMR.data.StatusTypeData;
import EMR.data.UsersData;
import EMR.data.UsersData.UsersTags;
import EMR.data.ViewData;
import EMR.data.EventSetUpData.EventSetUpCreateData;
import EMR.data.EventSetUpData.EventSetUpTags;
import EMR.data.ResourceData.ResourceCreateData;
import EMR.data.ResourceData.ResourceTags;
import EMR.data.ResourceTypeData.ResourceTypeCreateData;
import EMR.data.ResourceTypeData.ResourceTypeTags;
import EMR.data.StatusTypeData.StatusTypeCreateData;
import EMR.data.StatusTypeData.StatusTypeTags;
import EMR.data.UsersData.UsersCreateData;
import EMR.data.ViewData.ViewCreateData;
import EMR.data.ViewData.ViewTags;
import EMR.pages.EventSetUp;
import EMR.pages.Login;
import EMR.pages.RegionList;
import EMR.pages.ResourceTypes;
import EMR.pages.Resources;
import EMR.pages.SelectRegion;
import EMR.pages.Shared;
import EMR.pages.StatusTypes;
import EMR.pages.UsersList;
import EMR.pages.ViewsUnderSetup;
import qaFramework.Configurations.Configuration;

public class MultiRegionEvent extends Configuration{

	public MultiRegionEvent() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	ViewData viewData;
	ViewCreateData viewDataCreation;
	StatusTypeData statusTypeData;
	StatusTypeCreateData statusTypeDataCreation;
	ResourceTypeData resourceTypeData;
	ResourceTypeCreateData resourceTypeDataCreation;
	ResourceCreateData resourceDataCreation;
	EventSetUpData eventSetUpData;
	EventSetUpCreateData eventSetupDataCreation;
	UsersData usersData;
	UsersCreateData userDataCreation;
	ResourceData resourceData;
	
	Login login;
	SelectRegion selectRegion;
	Shared navigateTo;
	ViewsUnderSetup viewUnderSetup;
	StatusTypes statusTypes;
	ResourceTypes resourceTypes;
	Resources resources;
	EventSetUp eventSetUp;
	UsersList usersList;
	RegionList regionList;
	
	@Test(description ="Precondition for Multi Region Event")
	public void PreconditionForMultiRegionEvent() throws Exception {

		TCID = "PreconditionForMultiRegionEvent";
	    TC_DESCRIPTION = "Precondition for Multi Region Event";
	    
	    /****
		 * Login as Admin to Region (Z_NewSmokeSuite_Region)
		 * NavigatetoviewUnderSetup
		 * create section 'Section4'
		 * NavigatetostatusTypes
		 * create all 6 SharedStatusTypes and 6 EventRelatedSharedStatusTypes under section 'Section2'
		 * create all 6 PrivateStatusTypes and 6 EventRelatedPrivateStatusTypes under section 'Section2'
		 * create all 6 roleBasedStatusTypes and 6 EventRelatedroleBasedStatusTypes under section 'Section2'
		 * NavigatetoResourceTypes 
		 * Create ResourceType (RT) by selecting all 36 the status types
		 * NavigatetoResource
		 * Create Resource (RS1) by selecting resource type RT
		 * Create Resource (RS2) by selecting resource type RT
		 * NavigatetoeventSetUp
		 * Create event template (ET1) by selecting notifications for user
		 * Create event template (ET2) by deselecting notifications for user
		 * Create event template (ET3) by providing address
		 * Read the event template which is created in multi region and select notification(done in MultiRegion) 
		 * Navigatetousers
		 * Create only 1user(U1) by providing 'Maintain Events' right and give access to other 3 regions
		 * Create another user(U2) by providing 'Setup other Region view' right
		 * Create shared resource by selecting shared status types and add it to 'Region Default page.
		 ****/
	    
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
	    
	    login = new Login(this.driver); 
	    statusTypes = new StatusTypes(this.driver);
	    selectRegion = new SelectRegion(this.driver);
	    navigateTo = new Shared(this.driver);
	    viewUnderSetup = new ViewsUnderSetup(this.driver);
	    usersList = new UsersList(this.driver);
	    resourceTypes = new ResourceTypes(this.driver);
	    resources = new Resources(this.driver);
	    eventSetUp = new EventSetUp(this.driver);
	    regionList = new RegionList(this.driver);
	    
	    
	  //Region (Z_NewSmokeSuite_Region)
	    
	    String roleSTValue[] = new String[6];
		String roleStatusValues[]= new String[3];
	    
	    String eventRoleSTValue[] = new String[6];
		String eventRoleStatusValues[]= new String[3];
		
	    String privateSTValue[] = new String[6];
		String privateStatusValues[]= new String[3];
		
		String eventPrivateSTValue[] = new String[6];
		String eventPrivateStatusValues[]= new String[3];
		
	    String sharedSTValue[] = new String[6];
		String sharedStatusValues[]= new String[3];
		
		String eventSharedSTValue[] = new String[6];
		String eventSharedStatusValues[]= new String[3];
		
		String resourceTypeValue[] = new String[1];
		
		String resourceValues[] = new String[3];
	    
	    login.loginToApplication(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD);
	    selectRegion.selectRegionAndClickOnNext(RegionData.REGIONNAME);
	    navigateTo.viewUnderSetup();
	    viewUnderSetup.createNewSection(viewDataCreation.section_4);
	    navigateTo.statusTypes();
	    statusTypes.createStatusType(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.MRE_nstName3, statusTypeDataCreation.description1, viewDataCreation.section_4);
	    statusTypes.createStatusType(StatusTypeData.MULTITYPE, statusTypeDataCreation.MRE_mstName3, statusTypeDataCreation.description1, viewDataCreation.section_4);
		statusTypes.createNewStatus(statusTypeDataCreation.statusesName27, StatusTypeData.STATUS_PURPLE_COLOR)
				   .createNewStatus(statusTypeDataCreation.statusesName28, StatusTypeData.STATUS_PURPLE_COLOR)
				   .createNewStatus(statusTypeDataCreation.statusesName29, StatusTypeData.STATUS_PURPLE_COLOR);
		
		roleStatusValues[0] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName27);
		roleStatusValues[1] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName28);
		roleStatusValues[2] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName29);
		
	    statusTypes.clickOnReturnToStatusTypeList()
	               .createStatusType(StatusTypeData.SATURATIONSCORETYPE, statusTypeDataCreation.MRE_sstName3, statusTypeDataCreation.description1, viewDataCreation.section_4)
	    		   .createStatusType(StatusTypeData.TEXTTYPE, statusTypeDataCreation.MRE_tstName3, statusTypeDataCreation.description1, viewDataCreation.section_4)
	    		   .createStatusType(StatusTypeData.DATETYPE, statusTypeDataCreation.MRE_dstName3, statusTypeDataCreation.description1, viewDataCreation.section_4)
	    		   .createStatusType(StatusTypeData.NEDOCSTYPE, statusTypeDataCreation.MRE_nedocstName3, statusTypeDataCreation.description1, viewDataCreation.section_4);
	    
	    roleSTValue[0] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_nstName3);
	    roleSTValue[1] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_mstName3);
	    roleSTValue[2] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_sstName3);
	    roleSTValue[3] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_tstName3);
	    roleSTValue[4] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_dstName3);
	    roleSTValue[5] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_nedocstName3);
	    
	    String[] roleStatusesNames = {statusTypeDataCreation.statusesName27, statusTypeDataCreation.statusesName28, statusTypeDataCreation.statusesName29};
	    String[] roleSTNames = {statusTypeDataCreation.MRE_nstName3,statusTypeDataCreation.MRE_mstName3,statusTypeDataCreation.MRE_sstName3,statusTypeDataCreation.MRE_tstName3,statusTypeDataCreation.MRE_dstName3,statusTypeDataCreation.MRE_nedocstName3};
	    
	    statusTypes.createEventStatusType(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.MRE_eventNst3, statusTypeDataCreation.description1, viewDataCreation.section_4);
	    statusTypes.createEventStatusType(StatusTypeData.MULTITYPE, statusTypeDataCreation.MRE_eventMst3, statusTypeDataCreation.description1, viewDataCreation.section_4);
		statusTypes.createNewStatus(statusTypeDataCreation.statusesName30, StatusTypeData.STATUS_PURPLE_COLOR)
				   .createNewStatus(statusTypeDataCreation.statusesName31, StatusTypeData.STATUS_PURPLE_COLOR)
				   .createNewStatus(statusTypeDataCreation.statusesName32, StatusTypeData.STATUS_PURPLE_COLOR);
		
		eventRoleStatusValues[0] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName30);
		eventRoleStatusValues[1] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName31);
		eventRoleStatusValues[2] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName32);
		
	    statusTypes.clickOnReturnToStatusTypeList()
	               .createEventStatusType(StatusTypeData.SATURATIONSCORETYPE, statusTypeDataCreation.MRE_eventSst3, statusTypeDataCreation.description1, viewDataCreation.section_4)
	    		   .createEventStatusType(StatusTypeData.TEXTTYPE, statusTypeDataCreation.MRE_eventTst3, statusTypeDataCreation.description1, viewDataCreation.section_4)
	    		   .createEventStatusType(StatusTypeData.DATETYPE, statusTypeDataCreation.MRE_eventDst3, statusTypeDataCreation.description1, viewDataCreation.section_4)
	    		   .createEventStatusType(StatusTypeData.NEDOCSTYPE, statusTypeDataCreation.MRE_eventNdst3, statusTypeDataCreation.description1, viewDataCreation.section_4);
	    		   
	    eventRoleSTValue[0] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_eventNst3);
	    eventRoleSTValue[1] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_eventMst3);
	    eventRoleSTValue[2] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_eventSst3);
	    eventRoleSTValue[3] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_eventTst3);
	    eventRoleSTValue[4] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_eventDst3);
	    eventRoleSTValue[5] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_eventNdst3);
	    
	    String[] eventRoleStatusesNames = {statusTypeDataCreation.statusesName30, statusTypeDataCreation.statusesName31, statusTypeDataCreation.statusesName32};
	    String[] eventRoleSTNames={statusTypeDataCreation.MRE_eventNst3,statusTypeDataCreation.MRE_eventMst3,statusTypeDataCreation.MRE_eventSst3,statusTypeDataCreation.MRE_eventTst3,statusTypeDataCreation.MRE_eventDst3,statusTypeDataCreation.MRE_eventNdst3};
	    
	    statusTypes.createPrivateStatusType(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.MRE_privateNST_1, statusTypeDataCreation.description1, viewDataCreation.section_4);
	    statusTypes.createPrivateStatusType(StatusTypeData.MULTITYPE, statusTypeDataCreation.MRE_privateMST_1, statusTypeDataCreation.description1, viewDataCreation.section_4);
		statusTypes.createNewStatus(statusTypeDataCreation.statusesName33, StatusTypeData.STATUS_PURPLE_COLOR)
				   .createNewStatus(statusTypeDataCreation.statusesName34, StatusTypeData.STATUS_PURPLE_COLOR)
				   .createNewStatus(statusTypeDataCreation.statusesName35, StatusTypeData.STATUS_PURPLE_COLOR);
		
		privateStatusValues[0] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName33);
		privateStatusValues[1] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName34);
		privateStatusValues[2] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName35);
		
		
	    statusTypes.clickOnReturnToStatusTypeList()
	               .createPrivateStatusType(StatusTypeData.SATURATIONSCORETYPE, statusTypeDataCreation.MRE_privateSST_1, statusTypeDataCreation.description1, viewDataCreation.section_4)
	    		   .createPrivateStatusType(StatusTypeData.TEXTTYPE, statusTypeDataCreation.MRE_privateTST_1, statusTypeDataCreation.description1, viewDataCreation.section_4)
	    		   .createPrivateStatusType(StatusTypeData.DATETYPE, statusTypeDataCreation.MRE_privateDST_1, statusTypeDataCreation.description1, viewDataCreation.section_4)
	    		   .createPrivateStatusType(StatusTypeData.NEDOCSTYPE, statusTypeDataCreation.MRE_privateNEDOCST_1, statusTypeDataCreation.description1, viewDataCreation.section_4);
	    
	    privateSTValue[0] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_privateNST_1);
	    privateSTValue[1] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_privateMST_1);
	    privateSTValue[2] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_privateSST_1);
	    privateSTValue[3] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_privateTST_1);
	    privateSTValue[4] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_privateDST_1);
	    privateSTValue[5] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_privateNEDOCST_1);
	    
	    String[] privateStatusesNames = {statusTypeDataCreation.statusesName33, statusTypeDataCreation.statusesName34, statusTypeDataCreation.statusesName35};
	    String[] privateSTNames = {statusTypeDataCreation.MRE_privateNST_1,statusTypeDataCreation.MRE_privateMST_1,statusTypeDataCreation.MRE_privateSST_1,statusTypeDataCreation.MRE_privateTST_1,statusTypeDataCreation.MRE_privateDST_1,statusTypeDataCreation.MRE_privateNEDOCST_1};
	    
	    statusTypes.createEventPrivateStatusType(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.MRE_privateNST_2, statusTypeDataCreation.description1, viewDataCreation.section_4);
	    statusTypes.createEventPrivateStatusType(StatusTypeData.MULTITYPE, statusTypeDataCreation.MRE_privateMST_2, statusTypeDataCreation.description1, viewDataCreation.section_4);
		statusTypes.createNewStatus(statusTypeDataCreation.statusesName36, StatusTypeData.STATUS_PURPLE_COLOR)
				   .createNewStatus(statusTypeDataCreation.statusesName37, StatusTypeData.STATUS_PURPLE_COLOR)
				   .createNewStatus(statusTypeDataCreation.statusesName38, StatusTypeData.STATUS_PURPLE_COLOR);
		
		eventPrivateStatusValues[0] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName36);
		eventPrivateStatusValues[1] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName37);
		eventPrivateStatusValues[2] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName38);
		
	    statusTypes.clickOnReturnToStatusTypeList()
	               .createEventPrivateStatusType(StatusTypeData.SATURATIONSCORETYPE, statusTypeDataCreation.MRE_privateSST_2, statusTypeDataCreation.description1, viewDataCreation.section_4)
	    		   .createEventPrivateStatusType(StatusTypeData.TEXTTYPE, statusTypeDataCreation.MRE_privateTST_2, statusTypeDataCreation.description1, viewDataCreation.section_4)
	    		   .createEventPrivateStatusType(StatusTypeData.DATETYPE, statusTypeDataCreation.MRE_privateDST_2, statusTypeDataCreation.description1, viewDataCreation.section_4)
	    		   .createEventPrivateStatusType(StatusTypeData.NEDOCSTYPE, statusTypeDataCreation.MRE_privateNEDOCST_2, statusTypeDataCreation.description1, viewDataCreation.section_4);
	    
	    eventPrivateSTValue[0] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_privateNST_2);
	    eventPrivateSTValue[1] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_privateMST_2);
	    eventPrivateSTValue[2] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_privateSST_2);
	    eventPrivateSTValue[3] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_privateTST_2);
	    eventPrivateSTValue[4] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_privateDST_2);
	    eventPrivateSTValue[5] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_privateNEDOCST_2);
	    
	    String[] eventPrivateStatusesNames = {statusTypeDataCreation.statusesName36, statusTypeDataCreation.statusesName37, statusTypeDataCreation.statusesName38};
	    String[] eventPrivateSTNames={statusTypeDataCreation.MRE_privateNST_2,statusTypeDataCreation.MRE_privateMST_2,statusTypeDataCreation.MRE_privateSST_2,statusTypeDataCreation.MRE_privateTST_2,statusTypeDataCreation.MRE_privateDST_2,statusTypeDataCreation.MRE_privateNEDOCST_2};
	    
	    statusTypes.createSharedStatusType(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.MRE_sharedNST_5, statusTypeDataCreation.description1, viewDataCreation.section_4);
	    statusTypes.createSharedStatusType(StatusTypeData.MULTITYPE, statusTypeDataCreation.MRE_sharedMST_5, statusTypeDataCreation.description1, viewDataCreation.section_4);
		statusTypes.createNewStatus(statusTypeDataCreation.statusesName39, StatusTypeData.STATUS_PURPLE_COLOR)
				   .createNewStatus(statusTypeDataCreation.statusesName40, StatusTypeData.STATUS_PURPLE_COLOR)
				   .createNewStatus(statusTypeDataCreation.statusesName41, StatusTypeData.STATUS_PURPLE_COLOR);
		
		sharedStatusValues[0]	=statusTypes .getStatusesValue(statusTypeDataCreation.statusesName39);
		sharedStatusValues[1]	=statusTypes .getStatusesValue(statusTypeDataCreation.statusesName40);
		sharedStatusValues[2]	=statusTypes .getStatusesValue(statusTypeDataCreation.statusesName41);
		
	    statusTypes.clickOnReturnToStatusTypeList()
	               .createSharedStatusType(StatusTypeData.SATURATIONSCORETYPE, statusTypeDataCreation.MRE_sharedSST_5, statusTypeDataCreation.description1, viewDataCreation.section_4)
	    		   .createSharedStatusType(StatusTypeData.TEXTTYPE, statusTypeDataCreation.MRE_sharedTST_5, statusTypeDataCreation.description1, viewDataCreation.section_4)
	    		   .createSharedStatusType(StatusTypeData.DATETYPE, statusTypeDataCreation.MRE_sharedDST_5, statusTypeDataCreation.description1, viewDataCreation.section_4)
	    		   .createSharedStatusType(StatusTypeData.NEDOCSTYPE, statusTypeDataCreation.MRE_sharedNEDOCST_5, statusTypeDataCreation.description1, viewDataCreation.section_4);
	    
	    sharedSTValue[0] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_sharedNST_5);
	    sharedSTValue[1] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_sharedMST_5);
	    sharedSTValue[2] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_sharedSST_5);
	    sharedSTValue[3] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_sharedTST_5);
	    sharedSTValue[4] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_sharedDST_5);
	    sharedSTValue[5] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_sharedNEDOCST_5);
	    
	    String[] sharedStatusesNames = {statusTypeDataCreation.statusesName39, statusTypeDataCreation.statusesName40, statusTypeDataCreation.statusesName41};
	    String[] sharedSTNames={statusTypeDataCreation.MRE_sharedNST_5,statusTypeDataCreation.MRE_sharedMST_5,statusTypeDataCreation.MRE_sharedSST_5,statusTypeDataCreation.MRE_sharedTST_5,statusTypeDataCreation.MRE_sharedDST_5,statusTypeDataCreation.MRE_sharedNEDOCST_5};
	    
	    statusTypes.createEventSharedStatusType(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.MRE_sharedNST_6, statusTypeDataCreation.description1, viewDataCreation.section_4);
	    statusTypes.createEventSharedStatusType(StatusTypeData.MULTITYPE, statusTypeDataCreation.MRE_sharedMST_6, statusTypeDataCreation.description1, viewDataCreation.section_4);
		statusTypes.createNewStatus(statusTypeDataCreation.statusesName42, StatusTypeData.STATUS_PURPLE_COLOR)
				   .createNewStatus(statusTypeDataCreation.statusesName43, StatusTypeData.STATUS_PURPLE_COLOR)
				   .createNewStatus(statusTypeDataCreation.statusesName44, StatusTypeData.STATUS_PURPLE_COLOR);
		
		eventSharedStatusValues[0]	=statusTypes .getStatusesValue(statusTypeDataCreation.statusesName42);
		eventSharedStatusValues[1]	=statusTypes .getStatusesValue(statusTypeDataCreation.statusesName43);
		eventSharedStatusValues[2]	=statusTypes .getStatusesValue(statusTypeDataCreation.statusesName44);
		
	    statusTypes.clickOnReturnToStatusTypeList()
	    		   .createEventSharedStatusType(StatusTypeData.SATURATIONSCORETYPE, statusTypeDataCreation.MRE_sharedSST_6, statusTypeDataCreation.description1, viewDataCreation.section_4)
	    		   .createEventSharedStatusType(StatusTypeData.TEXTTYPE, statusTypeDataCreation.MRE_sharedTST_6, statusTypeDataCreation.description1, viewDataCreation.section_4)
	    		   .createEventSharedStatusType(StatusTypeData.DATETYPE, statusTypeDataCreation.MRE_sharedDST_6, statusTypeDataCreation.description1, viewDataCreation.section_4)
	    		   .createEventSharedStatusType(StatusTypeData.NEDOCSTYPE, statusTypeDataCreation.MRE_sharedNEDOCST_6, statusTypeDataCreation.description1, viewDataCreation.section_4);
	    
	    eventSharedSTValue[0] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_sharedNST_6);
	    eventSharedSTValue[1] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_sharedMST_6);
	    eventSharedSTValue[2] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_sharedSST_6);
	    eventSharedSTValue[3] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_sharedTST_6);
	    eventSharedSTValue[4] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_sharedDST_6);
	    eventSharedSTValue[5] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_sharedNEDOCST_6);
	    
	    String[] eventSharedStatusesNames = {statusTypeDataCreation.statusesName42, statusTypeDataCreation.statusesName43, statusTypeDataCreation.statusesName44};
	    String[] eventSharedSTNames={statusTypeDataCreation.MRE_sharedNST_6,statusTypeDataCreation.MRE_sharedMST_6,statusTypeDataCreation.MRE_sharedSST_6,statusTypeDataCreation.MRE_sharedTST_6,statusTypeDataCreation.MRE_sharedDST_6,statusTypeDataCreation.MRE_sharedNEDOCST_6};
	    
	    String[] statusTypeValues = ArrayUtils.addAll(roleSTValue, eventRoleSTValue);
	    statusTypeValues = ArrayUtils.addAll(statusTypeValues, privateSTValue);
	    statusTypeValues = ArrayUtils.addAll(statusTypeValues, eventPrivateSTValue);
	    statusTypeValues = ArrayUtils.addAll(statusTypeValues, sharedSTValue);
	    statusTypeValues = ArrayUtils.addAll(statusTypeValues, eventSharedSTValue);
	    
	    String[] STNames =  ArrayUtils.addAll(roleSTNames, eventRoleSTNames);
	    STNames = ArrayUtils.addAll(STNames, privateSTNames);
	    STNames = ArrayUtils.addAll(STNames, eventPrivateSTNames);
	    STNames = ArrayUtils.addAll(STNames, sharedSTNames);
	    STNames = ArrayUtils.addAll(STNames, eventSharedSTNames);
	    
	    String[] allRoleST=ArrayUtils.addAll(roleSTNames, roleStatusesNames);
	    String[] allEventRoleST = ArrayUtils.addAll(eventRoleSTNames, eventRoleStatusesNames);
	    String[] allPrivateST=ArrayUtils.addAll(privateSTNames, privateStatusesNames);
	    String[] allEventPrivateST = ArrayUtils.addAll(eventPrivateSTNames, eventPrivateStatusesNames);
	    String[] allSharedST = ArrayUtils.addAll(sharedSTNames, sharedStatusesNames);
	    String[] allEventSharedST = ArrayUtils.addAll(eventSharedSTNames, eventSharedStatusesNames);
	    
	    String[] All36STsOfRGName = ArrayUtils.addAll(allRoleST,allEventRoleST );
	    All36STsOfRGName = ArrayUtils.addAll(All36STsOfRGName, allPrivateST);
	    All36STsOfRGName = ArrayUtils.addAll(All36STsOfRGName, allEventPrivateST);
	    All36STsOfRGName = ArrayUtils.addAll(All36STsOfRGName, allSharedST);
	    All36STsOfRGName = ArrayUtils.addAll(All36STsOfRGName, allEventSharedST);
	    
	    String[] All36STsOfRGNodes = {StatusTypeTags.ROLE_NST_IN_REGION,StatusTypeTags.ROLE_MST_IN_REGION,
	    		StatusTypeTags.ROLE_SST_IN_REGION,StatusTypeTags.ROLE_TST_IN_REGION,
	    		StatusTypeTags.ROLE_DST_IN_REGION,StatusTypeTags.ROLE_NEDOCST_IN_REGION,
	    		StatusTypeTags.ROLE_STATUSES_NAMES1_IN_REGION,StatusTypeTags.ROLE_STATUSES_NAMES2_IN_REGION,StatusTypeTags.ROLE_STATUSES_NAMES3_IN_REGION,
	    		StatusTypeTags.EVENT_ROLE_NST_IN_REGION,StatusTypeTags.EVENT_ROLE_MST_IN_REGION,
	    		StatusTypeTags.EVENT_ROLE_SST_IN_REGION,StatusTypeTags.EVENT_ROLE_TST_IN_REGION,
	    		StatusTypeTags.EVENT_ROLE_DST_IN_REGION,StatusTypeTags.EVENT_ROLE_NEDOCST_IN_REGION,
	    		StatusTypeTags.EVENT_ROLE_STATUSES_NAMES1_IN_REGION,StatusTypeTags.EVENT_ROLE_STATUSES_NAMES2_IN_REGION,StatusTypeTags.EVENT_ROLE_STATUSES_NAMES3_IN_REGION,
	    		StatusTypeTags.PRIVATE_NST_IN_REGION,StatusTypeTags.PRIVATE_MST_IN_REGION,
	    		StatusTypeTags.PRIVATE_SST_IN_REGION,StatusTypeTags.PRIVATE_TST_IN_REGION,
	    		StatusTypeTags.PRIVATE_DST_IN_REGION,StatusTypeTags.PRIVATE_NEDOCST_IN_REGION,
	    		StatusTypeTags.PRIVATE_STATUSES_NAMES1_IN_REGION,StatusTypeTags.PRIVATE_STATUSES_NAMES2_IN_REGION,StatusTypeTags.PRIVATE_STATUSES_NAMES3_IN_REGION,
	    		StatusTypeTags.EVENT_PRIVATE_NST_IN_REGION,StatusTypeTags.EVENT_PRIVATE_MST_IN_REGION,
	    		StatusTypeTags.EVENT_PRIVATE_SST_IN_REGION,StatusTypeTags.EVENT_PRIVATE_TST_IN_REGION,
	    		StatusTypeTags.EVENT_PRIVATE_DST_IN_REGION,StatusTypeTags.EVENT_PRIVATE_NEDOCST_IN_REGION,
	    		StatusTypeTags.EVENT_PRIVATE_STATUSES_NAMES1_IN_REGION,StatusTypeTags.EVENT_PRIVATE_STATUSES_NAMES2_IN_REGION,StatusTypeTags.EVENT_PRIVATE_STATUSES_NAMES3_IN_REGION,
	    		StatusTypeTags.SHARED_NST_IN_REGION,StatusTypeTags.SHARED_MST_IN_REGION,
	    		StatusTypeTags.SHARED_SST_IN_REGION,StatusTypeTags.SHARED_TST_IN_REGION,
	    		StatusTypeTags.SHARED_DST_IN_REGION,StatusTypeTags.SHARED_NEDOCST_IN_REGION,
	    		StatusTypeTags.SHARED_STATUSES_NAMES1_IN_REGION,StatusTypeTags.SHARED_STATUSES_NAMES2_IN_REGION,StatusTypeTags.SHARED_STATUSES_NAMES3_IN_REGION,
	    		StatusTypeTags.EVENT_SHARED_NST_IN_REGION,StatusTypeTags.EVENT_SHARED_MST_IN_REGION,
	    		StatusTypeTags.EVENT_SHARED_SST_IN_REGION,StatusTypeTags.EVENT_SHARED_TST_IN_REGION,
	    		StatusTypeTags.EVENT_SHARED_DST_IN_REGION,StatusTypeTags.EVENT_SHARED_NEDOCST_IN_REGION,
	    		StatusTypeTags.EVENT_SHARED_STATUSES_NAMES1_IN_REGION,StatusTypeTags.EVENT_SHARED_STATUSES_NAMES2_IN_REGION,StatusTypeTags.EVENT_SHARED_STATUSES_NAMES3_IN_REGION};
	    
	    String[] allRoleSTValue = ArrayUtils.addAll(roleSTValue, roleStatusValues);
	    String[] allEventRoleSTValue = ArrayUtils.addAll(eventRoleSTValue, eventRoleStatusValues);
	    String[] allPrivateSTValue = ArrayUtils.addAll(privateSTValue, privateStatusValues);
	    String[] allEventPrivateSTValue = ArrayUtils.addAll(eventPrivateSTValue, eventPrivateStatusValues);
	    String[] allSharedSTValue = ArrayUtils.addAll(sharedSTValue, sharedStatusValues);
	    String[] allEventSharedSTValue = ArrayUtils.addAll(eventSharedSTValue, eventSharedStatusValues);
	    
	    String[] All36STsOfRG_Value = ArrayUtils.addAll(allRoleSTValue, allEventRoleSTValue);
	    All36STsOfRG_Value = ArrayUtils.addAll(All36STsOfRG_Value, allPrivateSTValue);
	    All36STsOfRG_Value = ArrayUtils.addAll(All36STsOfRG_Value, allEventPrivateSTValue);
	    All36STsOfRG_Value = ArrayUtils.addAll(All36STsOfRG_Value, allSharedSTValue);
	    All36STsOfRG_Value = ArrayUtils.addAll(All36STsOfRG_Value, allEventSharedSTValue);
	    
	    String[] All36STsValueOfRGNodes = {StatusTypeTags.ROLE_NST_VALUE_IN_REGION,StatusTypeTags.ROLE_MST_VALUE_IN_REGION,
	    		StatusTypeTags.ROLE_SST_VALUE_IN_REGION,StatusTypeTags.ROLE_TST_VALUE_IN_REGION,
	    		StatusTypeTags.ROLE_DST_VALUE_IN_REGION,StatusTypeTags.ROLE_NEDOCST_VALUE_IN_REGION,
	    		StatusTypeTags.ROLE_STATUSES_VALUES1_IN_REGION,StatusTypeTags.ROLE_STATUSES_VALUES2_IN_REGION,StatusTypeTags.ROLE_STATUSES_VALUES3_IN_REGION,
	    		StatusTypeTags.EVENT_ROLE_NST_VALUE_IN_REGION,StatusTypeTags.EVENT_ROLE_MST_VALUE_IN_REGION,
	    		StatusTypeTags.EVENT_ROLE_SST_VALUE_IN_REGION,StatusTypeTags.EVENT_ROLE_TST_VALUE_IN_REGION,
	    		StatusTypeTags.EVENT_ROLE_DST_VALUE_IN_REGION,StatusTypeTags.EVENT_ROLE_NEDOCST_VALUE_IN_REGION,
	    		StatusTypeTags.EVENT_ROLE_STATUSES_VALUES1_IN_REGION,StatusTypeTags.EVENT_ROLE_STATUSES_VALUES2_IN_REGION,StatusTypeTags.EVENT_ROLE_STATUSES_VALUES3_IN_REGION,
	    		StatusTypeTags.PRIVATE_NST_VALUE_IN_REGION,StatusTypeTags.PRIVATE_MST_VALUE_IN_REGION,
	    		StatusTypeTags.PRIVATE_SST_VALUE_IN_REGION,StatusTypeTags.PRIVATE_TST_VALUE_IN_REGION,
	    		StatusTypeTags.PRIVATE_DST_VALUE_IN_REGION,StatusTypeTags.PRIVATE_NEDOCST_VALUE_IN_REGION,
	    		StatusTypeTags.PRIVATE_STATUSES_VALUES1_IN_REGION,StatusTypeTags.PRIVATE_STATUSES_VALUES2_IN_REGION,StatusTypeTags.PRIVATE_STATUSES_VALUES3_IN_REGION,
	    		StatusTypeTags.EVENT_PRIVATE_NST_VALUE_IN_REGION,StatusTypeTags.EVENT_PRIVATE_MST_VALUE_IN_REGION,
	    		StatusTypeTags.EVENT_PRIVATE_SST_VALUE_IN_REGION,StatusTypeTags.EVENT_PRIVATE_TST_VALUE_IN_REGION,
	    		StatusTypeTags.EVENT_PRIVATE_DST_VALUE_IN_REGION,StatusTypeTags.EVENT_PRIVATE_NEDOCST_VALUE_IN_REGION,
	    		StatusTypeTags.EVENT_PRIVATE_STATUSES_VALUES1_IN_REGION,StatusTypeTags.EVENT_PRIVATE_STATUSES_VALUES2_IN_REGION,StatusTypeTags.EVENT_PRIVATE_STATUSES_VALUES3_IN_REGION,
	    		StatusTypeTags.SHARED_NST_VALUE_IN_REGION,StatusTypeTags.SHARED_MST_VALUE_IN_REGION,
	    		StatusTypeTags.SHARED_SST_VALUE_IN_REGION,StatusTypeTags.SHARED_TST_VALUE_IN_REGION,
	    		StatusTypeTags.SHARED_DST_VALUE_IN_REGION,StatusTypeTags.SHARED_NEDOCST_VALUE_IN_REGION,
	    		StatusTypeTags.SHARED_STATUSES_VALUES1_IN_REGION,StatusTypeTags.SHARED_STATUSES_VALUES2_IN_REGION,StatusTypeTags.SHARED_STATUSES_VALUES3_IN_REGION,
	    		StatusTypeTags.EVENT_SHARED_NST_VALUE_IN_REGION,StatusTypeTags.EVENT_SHARED_MST_VALUE_IN_REGION,
	    		StatusTypeTags.EVENT_SHARED_SST_VALUE_IN_REGION,StatusTypeTags.EVENT_SHARED_TST_VALUE_IN_REGION,
	    		StatusTypeTags.EVENT_SHARED_DST_VALUE_IN_REGION,StatusTypeTags.EVENT_SHARED_NEDOCST_VALUE_IN_REGION,
	    		StatusTypeTags.EVENT_SHARED_STATUSES_VALUES1_IN_REGION,StatusTypeTags.EVENT_SHARED_STATUSES_VALUES2_IN_REGION,StatusTypeTags.EVENT_SHARED_STATUSES_VALUES3_IN_REGION};
	    
	    statusTypeDataCreation.writeStatusTypesDataToXml(All36STsOfRGName, All36STsOfRGNodes);
	    statusTypeDataCreation.writeStatusTypesDataToXml(All36STsOfRG_Value, All36STsValueOfRGNodes);
	    navigateTo.resourceType();
	    resourceTypes.createResourceType(resourceTypeDataCreation.MRE_name3, statusTypeValues);
	    resourceTypeValue[0] = resourceTypes.getResourceTypeValue(resourceTypeDataCreation.MRE_name3);
	    
	    resourceTypeDataCreation.writeResourceTypeDataToXml(resourceTypeDataCreation.MRE_name3, ResourceTypeTags.RT_NAME_IN_REGION);
	    resourceTypeDataCreation.writeResourceTypeDataToXml(resourceTypeValue[0], ResourceTypeTags.RT_VALUE_IN_REGION);
	    
	    navigateTo.resources();
	    resources.createResourceWithAddress(resourceDataCreation.MRE_name4, resourceDataCreation.abbrevation7, resourceTypeDataCreation.MRE_name3, 
	    		ResourceData.STANDARDRESOURCETYPE, ResourceData.FIRSTNAME, 
	    		ResourceData.LASTNAME, ResourceData.STREETADDRESS,
	    		ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE, ResourceData.COUNTY)
	    		.createResourceWithAddress(resourceDataCreation.MRE_name5, resourceDataCreation.abbrevation8, resourceTypeDataCreation.MRE_name3, 
	    		ResourceData.STANDARDRESOURCETYPE, ResourceData.FIRSTNAME, 
	    		ResourceData.LASTNAME, ResourceData.STREETADDRESS,
	    		ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE, ResourceData.COUNTY)
	    		.createSharedResourceWithAddress(resourceDataCreation.SharedRS_Name4, resourceDataCreation.abbrevation9, resourceTypeDataCreation.MRE_name3, ResourceData.STANDARDRESOURCETYPE, ResourceData.FIRSTNAME, ResourceData.LASTNAME, ResourceData.STREETADDRESS, ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE, ResourceData.COUNTY);
	    resourceValues[0] = resources.getResourceValue(resourceDataCreation.MRE_name4);
	    resourceValues[1] = resources.getResourceValue(resourceDataCreation.MRE_name5);
	    resourceValues[2] = resources.getResourceValue(resourceDataCreation.SharedRS_Name4);
	    
	    String[] resourceNames={resourceDataCreation.SharedRS_Name4};
	    
	    navigateTo.viewUnderSetup();
	    viewUnderSetup.addResourceAndStatusTypesToRegionDefaultView(RegionData.REGIONNAME, resourceNames, STNames);
	    viewDataCreation.writeViewDataToXml(viewDataCreation.section_4, ViewTags.SECTION_IN_REGION_NAME);
	    
	    resourceDataCreation.writeResourceDataToXml(resourceDataCreation.MRE_name4, ResourceTags.RESOURCE_NAME1_IN_REGION);
	    resourceDataCreation.writeResourceDataToXml(resourceValues[0], ResourceTags.RESOURCE_NAME1_VALUE_IN_REGION);
	     
	    resourceDataCreation.writeResourceDataToXml(resourceDataCreation.MRE_name5, ResourceTags.RESOURCE_NAME2_IN_REGION);
	    resourceDataCreation.writeResourceDataToXml(resourceValues[1], ResourceTags.RESOURCE_NAME2_VALUE_IN_REGION);
	    
	    resourceDataCreation.writeResourceDataToXml(resourceDataCreation.SharedRS_Name4, ResourceTags.SHARED_RESOURCE_NAME_IN_REGION);
	    resourceDataCreation.writeResourceDataToXml(resourceValues[2], ResourceTags.SHARED_RESOURCE_NAME_VALUE_IN_REGION);
	    
	    String regionName2 = regionList.getRegionValue(RegionData.REGION_NAME_2);
	    String regionWithMutualAgreementRegion3 = regionList.getRegionValue(RegionData.REGION_WITH_MUTUAL_AGREEMENT3);
	    String regionValues[] = {regionName2, regionWithMutualAgreementRegion3};
	    
	    navigateTo.users();
	    usersList.createUserWithMandatoryDetailsBySelectingFirstRoleWithoutSave(userDataCreation.MRE_name5, UsersData.INITIAL_PASSWORD, userDataCreation.MRE_fullName5, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID)
	             .provideMaintainEventsRightAndSave()
	             .searchUserName(userDataCreation.MRE_name5)
	             .provideMultiRegionAccessToUser(userDataCreation.MRE_name5, regionValues)
	             .createUserWithMandatoryDetailsBySelectingFirstRoleWithoutSave(userDataCreation.name5, UsersData.INITIAL_PASSWORD, userDataCreation.fullName5, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID)
	             .provideSetupOtherRegionViewsRightAndSetupResourcesAddAndEditRight();
	    
	    userDataCreation.writeUsersDataToXml(userDataCreation.MRE_name5, UsersTags.MULTI_REGION_EVENT_USER);
	    userDataCreation.writeUsersDataToXml(userDataCreation.MRE_fullName5, UsersTags.MULTI_REGION_EVENT_USER_FULLNAME);
	    userDataCreation.writeUsersDataToXml(userDataCreation.name5, UsersTags.USER_WITH_SETUP_OTHER_REGION_VIEW_RIGHT_IN_REGION);
	    userDataCreation.writeUsersDataToXml(userDataCreation.fullName5, UsersTags.USER_FULLNAME_WITH_SETUP_OTHER_REGION_VIEW_RIGHT_IN_REGION);
        
	    navigateTo.eventSetUp();
	    eventSetUp.createEventTemplate(eventSetupDataCreation.name1, eventSetupDataCreation.definition1, resourceTypeValue[0], statusTypeValues)
	    		  .createEventTemplateSelectingWebOption(eventSetupDataCreation.name2, eventSetupDataCreation.definition2, resourceTypeValue[0], statusTypeValues, userDataCreation.MRE_name5)
	    		  .createMultiRegionEventTemplate(eventSetupDataCreation.name3, eventSetupDataCreation.definition3, EventSetUpData.AMBULANCE_ICON, EventSetUpData.RED_COLOUR, resourceTypeValue[0], statusTypeValues)
	              .createMultiRegionEventTemplateSelectingWebOption(eventSetupDataCreation.name4, eventSetupDataCreation.definition4, EventSetUpData.DOCTOR_ICON, EventSetUpData.GREEN_COLOUR, resourceTypeValue[0], statusTypeValues, userDataCreation.MRE_name5)
	              .createMultiRegionEventTemplateWithAddress(eventSetupDataCreation.name5, eventSetupDataCreation.definition5, EventSetUpData.HELICOPTER_ICON, EventSetUpData.ORANGE_COLOUR,resourceTypeValue[0], statusTypeValues, userDataCreation.MRE_name5);
	    
	    eventSetupDataCreation.writeEventDataToXml(eventSetupDataCreation.name1, EventSetUpTags.EVENT_TEMPLATE1_WITHOUT_NOTIFICATION_IN_REGION);
	    eventSetupDataCreation.writeEventDataToXml(eventSetupDataCreation.name2, EventSetUpTags.EVENT_TEMPLATE2_WITH_NOTIFICATION_IN_REGION);
	    eventSetupDataCreation.writeEventDataToXml(eventSetupDataCreation.name3, EventSetUpTags.MULTI_REGION_EVENT_TEMPLATE1_WITHOUT_NOTIFICATION_IN_REGION);
	    eventSetupDataCreation.writeEventDataToXml(eventSetupDataCreation.name4, EventSetUpTags.MULTI_REGION_EVENT_TEMPLATE2_WITH_NOTIFICATION_IN_REGION);
	    eventSetupDataCreation.writeEventDataToXml(eventSetupDataCreation.name5, EventSetUpTags.MULTI_REGION_EVENT_TEMPLATE_WITH_ADDRESS);
	    
	    selectRegion.selectRegionAndClickOnNext(RegionData.REGION_NAME_2);
	    navigateTo.users();
	    usersList.searchUser(userDataCreation.MRE_name5)
	             .selectFirstRole().selectAllViewResourceRight()
	             .provideMaintainEventsRightAndSave();
	    
	    selectRegion.selectRegionAndClickOnNext(RegionData.REGION_WITH_MUTUAL_AGREEMENT3);
	    navigateTo.users();
	    usersList.searchUser(userDataCreation.MRE_name5)
	             .selectFirstRole().selectAllViewResourceRight()
	             .provideMaintainEventsRightAndSave();
	    
	    String regionName = regionList.getRegionValue(RegionData.REGIONNAME);
	    String regionValues1[] = {regionName, regionName2, regionWithMutualAgreementRegion3};
	    
	    selectRegion.selectRegionAndClickOnNext(RegionData.REGIONNAME);
	    navigateTo.users();
	    usersList.editUserAndProvideMultiRegionEventsRight(userDataCreation.MRE_name5, regionValues1);
	    
	    /****
		 * Login as Admin to Region (Z_Auto_BQSPatch_rel12)
		 * NavigatetoviewUnderSetup
		 * create section 'Section5'
		 * NavigatetostatusTypes
		 * create all 6 SharedStatusTypes and 6 EventRelatedSharedStatusTypes under section 'Section3'
		 * create all 6 PrivateStatusTypes and 6 EventRelatedPrivateStatusTypes under section 'Section3'
		 * create all 6 roleBasedStatusTypes and 6 EventRelatedroleBasedStatusTypes under section 'Section3'
		 * NavigatetoResourceTypes 
		 * Create ResourceType (RT1) by selecting all 36 the status types
		 * NavigatetoResource
		 * Create Resource (RS1) by selecting resource type RT1
		 * Create Resource (RS2) by selecting resource type RT1
		 * NavigatetoeventSetUp
		 * Create event template (ET1) by selecting notifications for user
		 * Create event template (ET2) by deselecting notifications for user
		 ****/
	    
//Region (Z_Auto_BQSPatch_rel12)
	    
	    String roleSTValue_In_RG1[] = new String[6];
		String roleStatusValues_In_RG1[]= new String[3];
	    
	    String eventRoleSTValue_In_RG1[] = new String[6];
		String eventRoleStatusValues_In_RG1[]= new String[3];
		
	    String privateSTValue_In_RG1[] = new String[6];
		String privateStatusValues_In_RG1[]= new String[3];
		
		String eventPrivateSTValue_In_RG1[] = new String[6];
		String eventPrivateStatusValues_In_RG1[]= new String[3];
		
	    String sharedSTValue_In_RG1[] = new String[6];
		String sharedStatusValues_In_RG1[]= new String[3];
		
		String eventSharedSTValue_In_RG1[] = new String[6];
		String eventSharedStatusValues_In_RG1[]= new String[3];
		
		String resourceTypeValue_In_RG1[] = new String[1];
		
		String resourceValues_In_RG1[] = new String[2];
	    
	    selectRegion.selectRegionAndClickOnNext(RegionData.REGION_NAME_2);
	    navigateTo.viewUnderSetup();
	    viewUnderSetup.createNewSection(viewDataCreation.section_5);
	    navigateTo.statusTypes();
	    statusTypes.createStatusType(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.MRE_nstName4, statusTypeDataCreation.description2, viewDataCreation.section_5);
	    statusTypes.createStatusType(StatusTypeData.MULTITYPE, statusTypeDataCreation.MRE_mstName4, statusTypeDataCreation.description2, viewDataCreation.section_5);
		statusTypes.createNewStatus(statusTypeDataCreation.statusesName45, StatusTypeData.STATUS_PURPLE_COLOR)
				   .createNewStatus(statusTypeDataCreation.statusesName46, StatusTypeData.STATUS_PURPLE_COLOR)
				   .createNewStatus(statusTypeDataCreation.statusesName47, StatusTypeData.STATUS_PURPLE_COLOR);
		
		roleStatusValues_In_RG1[0] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName45);
		roleStatusValues_In_RG1[1] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName46);
		roleStatusValues_In_RG1[2] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName47);
		
	    statusTypes.clickOnReturnToStatusTypeList()
	               .createStatusType(StatusTypeData.SATURATIONSCORETYPE, statusTypeDataCreation.MRE_sstName4, statusTypeDataCreation.description2, viewDataCreation.section_5)
	    		   .createStatusType(StatusTypeData.TEXTTYPE, statusTypeDataCreation.MRE_tstName4, statusTypeDataCreation.description2, viewDataCreation.section_5)
	    		   .createStatusType(StatusTypeData.DATETYPE, statusTypeDataCreation.MRE_dstName4, statusTypeDataCreation.description2, viewDataCreation.section_5)
	    		   .createStatusType(StatusTypeData.NEDOCSTYPE, statusTypeDataCreation.MRE_nedocstName4, statusTypeDataCreation.description2, viewDataCreation.section_5);
	    
	    roleSTValue_In_RG1[0] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_nstName4);
	    roleSTValue_In_RG1[1] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_mstName4);
	    roleSTValue_In_RG1[2] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_sstName4);
	    roleSTValue_In_RG1[3] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_tstName4);
	    roleSTValue_In_RG1[4] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_dstName4);
	    roleSTValue_In_RG1[5] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_nedocstName4);
	    
	    String[] roleStatusesNames_In_RG1 = {statusTypeDataCreation.statusesName45, statusTypeDataCreation.statusesName46, statusTypeDataCreation.statusesName47};
	    String[] roleSTNames_In_RG1 = {statusTypeDataCreation.MRE_nstName4,statusTypeDataCreation.MRE_mstName4,statusTypeDataCreation.MRE_sstName4,statusTypeDataCreation.MRE_tstName4,statusTypeDataCreation.MRE_dstName4,statusTypeDataCreation.MRE_nedocstName4};
	    
	    statusTypes.createEventStatusType(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.MRE_eventNst4, statusTypeDataCreation.description2, viewDataCreation.section_5);
	    statusTypes.createEventStatusType(StatusTypeData.MULTITYPE, statusTypeDataCreation.MRE_eventMst4, statusTypeDataCreation.description2, viewDataCreation.section_5);
		statusTypes.createNewStatus(statusTypeDataCreation.statusesName48, StatusTypeData.STATUS_PURPLE_COLOR)
				   .createNewStatus(statusTypeDataCreation.statusesName49, StatusTypeData.STATUS_PURPLE_COLOR)
				   .createNewStatus(statusTypeDataCreation.statusesName50, StatusTypeData.STATUS_PURPLE_COLOR);
		
		eventRoleStatusValues_In_RG1[0] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName48);
		eventRoleStatusValues_In_RG1[1] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName49);
		eventRoleStatusValues_In_RG1[2] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName50);
		
	    statusTypes.clickOnReturnToStatusTypeList()
	               .createEventStatusType(StatusTypeData.SATURATIONSCORETYPE, statusTypeDataCreation.MRE_eventSst4, statusTypeDataCreation.description2, viewDataCreation.section_5)
	    		   .createEventStatusType(StatusTypeData.TEXTTYPE, statusTypeDataCreation.MRE_eventTst4, statusTypeDataCreation.description2, viewDataCreation.section_5)
	    		   .createEventStatusType(StatusTypeData.DATETYPE, statusTypeDataCreation.MRE_eventDst4, statusTypeDataCreation.description2, viewDataCreation.section_5)
	    		   .createEventStatusType(StatusTypeData.NEDOCSTYPE, statusTypeDataCreation.MRE_eventNdst4, statusTypeDataCreation.description2, viewDataCreation.section_5);
	    		   
	    eventRoleSTValue_In_RG1[0] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_eventNst4);
	    eventRoleSTValue_In_RG1[1] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_eventMst4);
	    eventRoleSTValue_In_RG1[2] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_eventSst4);
	    eventRoleSTValue_In_RG1[3] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_eventTst4);
	    eventRoleSTValue_In_RG1[4] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_eventDst4);
	    eventRoleSTValue_In_RG1[5] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_eventNdst4);
	    
	    String[] eventRoleStatusesNames_In_RG1 = {statusTypeDataCreation.statusesName48, statusTypeDataCreation.statusesName49, statusTypeDataCreation.statusesName50};
	    String[] eventRoleSTNames_In_RG1={statusTypeDataCreation.MRE_eventNst4,statusTypeDataCreation.MRE_eventMst4,statusTypeDataCreation.MRE_eventSst4,statusTypeDataCreation.MRE_eventTst4,statusTypeDataCreation.MRE_eventDst4,statusTypeDataCreation.MRE_eventNdst4};
	    
	    statusTypes.createPrivateStatusType(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.MRE_privateNST_3, statusTypeDataCreation.description2, viewDataCreation.section_5);
	    statusTypes.createPrivateStatusType(StatusTypeData.MULTITYPE, statusTypeDataCreation.MRE_privateMST_3, statusTypeDataCreation.description2, viewDataCreation.section_5);
		statusTypes.createNewStatus(statusTypeDataCreation.statusesName51, StatusTypeData.STATUS_PURPLE_COLOR)
				   .createNewStatus(statusTypeDataCreation.statusesName52, StatusTypeData.STATUS_PURPLE_COLOR)
				   .createNewStatus(statusTypeDataCreation.statusesName53, StatusTypeData.STATUS_PURPLE_COLOR);
		
		privateStatusValues_In_RG1[0] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName51);
		privateStatusValues_In_RG1[1] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName52);
		privateStatusValues_In_RG1[2] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName53);
		
		
	    statusTypes.clickOnReturnToStatusTypeList()
	               .createPrivateStatusType(StatusTypeData.SATURATIONSCORETYPE, statusTypeDataCreation.MRE_privateSST_3, statusTypeDataCreation.description2, viewDataCreation.section_5)
	    		   .createPrivateStatusType(StatusTypeData.TEXTTYPE, statusTypeDataCreation.MRE_privateTST_3, statusTypeDataCreation.description2, viewDataCreation.section_5)
	    		   .createPrivateStatusType(StatusTypeData.DATETYPE, statusTypeDataCreation.MRE_privateDST_3, statusTypeDataCreation.description2, viewDataCreation.section_5)
	    		   .createPrivateStatusType(StatusTypeData.NEDOCSTYPE, statusTypeDataCreation.MRE_privateNEDOCST_3, statusTypeDataCreation.description2, viewDataCreation.section_5);
	    
	    privateSTValue_In_RG1[0] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_privateNST_3);
	    privateSTValue_In_RG1[1] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_privateMST_3);
	    privateSTValue_In_RG1[2] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_privateSST_3);
	    privateSTValue_In_RG1[3] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_privateTST_3);
	    privateSTValue_In_RG1[4] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_privateDST_3);
	    privateSTValue_In_RG1[5] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_privateNEDOCST_3);
	    
	    String[] privateStatusesNames_In_RG1 = {statusTypeDataCreation.statusesName51, statusTypeDataCreation.statusesName52, statusTypeDataCreation.statusesName53};
	    String[] privateSTNames_In_RG1 = {statusTypeDataCreation.MRE_privateNST_3,statusTypeDataCreation.MRE_privateMST_3,statusTypeDataCreation.MRE_privateSST_3,statusTypeDataCreation.MRE_privateTST_3,statusTypeDataCreation.MRE_privateDST_3,statusTypeDataCreation.MRE_privateNEDOCST_3};
	    
	    statusTypes.createEventPrivateStatusType(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.MRE_privateNST_4, statusTypeDataCreation.description2, viewDataCreation.section_5);
	    statusTypes.createEventPrivateStatusType(StatusTypeData.MULTITYPE, statusTypeDataCreation.MRE_privateMST_4, statusTypeDataCreation.description2, viewDataCreation.section_5);
		statusTypes.createNewStatus(statusTypeDataCreation.statusesName54, StatusTypeData.STATUS_PURPLE_COLOR)
				   .createNewStatus(statusTypeDataCreation.statusesName55, StatusTypeData.STATUS_PURPLE_COLOR)
				   .createNewStatus(statusTypeDataCreation.statusesName56, StatusTypeData.STATUS_PURPLE_COLOR);
		
		eventPrivateStatusValues_In_RG1[0] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName54);
		eventPrivateStatusValues_In_RG1[1] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName55);
		eventPrivateStatusValues_In_RG1[2] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName56);
		
	    statusTypes.clickOnReturnToStatusTypeList()
	               .createEventPrivateStatusType(StatusTypeData.SATURATIONSCORETYPE, statusTypeDataCreation.MRE_privateSST_4, statusTypeDataCreation.description2, viewDataCreation.section_5)
	    		   .createEventPrivateStatusType(StatusTypeData.TEXTTYPE, statusTypeDataCreation.MRE_privateTST_4, statusTypeDataCreation.description2, viewDataCreation.section_5)
	    		   .createEventPrivateStatusType(StatusTypeData.DATETYPE, statusTypeDataCreation.MRE_privateDST_4, statusTypeDataCreation.description2, viewDataCreation.section_5)
	    		   .createEventPrivateStatusType(StatusTypeData.NEDOCSTYPE, statusTypeDataCreation.MRE_privateNEDOCST_4, statusTypeDataCreation.description2, viewDataCreation.section_5);
	    
	    eventPrivateSTValue_In_RG1[0] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_privateNST_4);
	    eventPrivateSTValue_In_RG1[1] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_privateMST_4);
	    eventPrivateSTValue_In_RG1[2] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_privateSST_4);
	    eventPrivateSTValue_In_RG1[3] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_privateTST_4);
	    eventPrivateSTValue_In_RG1[4] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_privateDST_4);
	    eventPrivateSTValue_In_RG1[5] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_privateNEDOCST_4);
	    
	    String[] eventPrivateStatusesNames_In_RG1 = {statusTypeDataCreation.statusesName54, statusTypeDataCreation.statusesName55, statusTypeDataCreation.statusesName56};
	    String[] eventPrivateSTNames_In_RG1={statusTypeDataCreation.MRE_privateNST_4,statusTypeDataCreation.MRE_privateMST_4,statusTypeDataCreation.MRE_privateSST_4,statusTypeDataCreation.MRE_privateTST_4,statusTypeDataCreation.MRE_privateDST_4,statusTypeDataCreation.MRE_privateNEDOCST_4};
	    
	    statusTypes.createSharedStatusType(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.MRE_sharedNST_7, statusTypeDataCreation.description2, viewDataCreation.section_5);
	    statusTypes.createSharedStatusType(StatusTypeData.MULTITYPE, statusTypeDataCreation.MRE_sharedMST_7, statusTypeDataCreation.description2, viewDataCreation.section_5);
		statusTypes.createNewStatus(statusTypeDataCreation.statusesName57, StatusTypeData.STATUS_PURPLE_COLOR)
				   .createNewStatus(statusTypeDataCreation.statusesName58, StatusTypeData.STATUS_PURPLE_COLOR)
				   .createNewStatus(statusTypeDataCreation.statusesName59, StatusTypeData.STATUS_PURPLE_COLOR);
		
		sharedStatusValues_In_RG1[0]	=statusTypes .getStatusesValue(statusTypeDataCreation.statusesName57);
		sharedStatusValues_In_RG1[1]	=statusTypes .getStatusesValue(statusTypeDataCreation.statusesName58);
		sharedStatusValues_In_RG1[2]	=statusTypes .getStatusesValue(statusTypeDataCreation.statusesName59);
		
	    statusTypes.clickOnReturnToStatusTypeList()
	               .createSharedStatusType(StatusTypeData.SATURATIONSCORETYPE, statusTypeDataCreation.MRE_sharedSST_7, statusTypeDataCreation.description2, viewDataCreation.section_5)
	    		   .createSharedStatusType(StatusTypeData.TEXTTYPE, statusTypeDataCreation.MRE_sharedTST_7, statusTypeDataCreation.description2, viewDataCreation.section_5)
	    		   .createSharedStatusType(StatusTypeData.DATETYPE, statusTypeDataCreation.MRE_sharedDST_7, statusTypeDataCreation.description2, viewDataCreation.section_5)
	    		   .createSharedStatusType(StatusTypeData.NEDOCSTYPE, statusTypeDataCreation.MRE_sharedNEDOCST_7, statusTypeDataCreation.description2, viewDataCreation.section_5);
	    
	    sharedSTValue_In_RG1[0] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_sharedNST_7);
	    sharedSTValue_In_RG1[1] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_sharedMST_7);
	    sharedSTValue_In_RG1[2] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_sharedSST_7);
	    sharedSTValue_In_RG1[3] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_sharedTST_7);
	    sharedSTValue_In_RG1[4] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_sharedDST_7);
	    sharedSTValue_In_RG1[5] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_sharedNEDOCST_7);
	    
	    String[] sharedStatusesNames_In_RG1 = {statusTypeDataCreation.statusesName57, statusTypeDataCreation.statusesName58, statusTypeDataCreation.statusesName59};
	    String[] sharedSTNames_In_RG1={statusTypeDataCreation.MRE_sharedNST_7,statusTypeDataCreation.MRE_sharedMST_7,statusTypeDataCreation.MRE_sharedSST_7,statusTypeDataCreation.MRE_sharedTST_7,statusTypeDataCreation.MRE_sharedDST_7,statusTypeDataCreation.MRE_sharedNEDOCST_7};
	    
	    statusTypes.createEventSharedStatusType(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.MRE_sharedNST_8, statusTypeDataCreation.description2, viewDataCreation.section_5);
	    statusTypes.createEventSharedStatusType(StatusTypeData.MULTITYPE, statusTypeDataCreation.MRE_sharedMST_8, statusTypeDataCreation.description2, viewDataCreation.section_5);
		statusTypes.createNewStatus(statusTypeDataCreation.statusesName60, StatusTypeData.STATUS_PURPLE_COLOR)
				   .createNewStatus(statusTypeDataCreation.statusesName61, StatusTypeData.STATUS_PURPLE_COLOR)
				   .createNewStatus(statusTypeDataCreation.statusesName62, StatusTypeData.STATUS_PURPLE_COLOR);
		
		eventSharedStatusValues_In_RG1[0]	=statusTypes .getStatusesValue(statusTypeDataCreation.statusesName60);
		eventSharedStatusValues_In_RG1[1]	=statusTypes .getStatusesValue(statusTypeDataCreation.statusesName61);
		eventSharedStatusValues_In_RG1[2]	=statusTypes .getStatusesValue(statusTypeDataCreation.statusesName62);
		
	    statusTypes.clickOnReturnToStatusTypeList()
	    		   .createEventSharedStatusType(StatusTypeData.SATURATIONSCORETYPE, statusTypeDataCreation.MRE_sharedSST_8, statusTypeDataCreation.description2, viewDataCreation.section_5)
	    		   .createEventSharedStatusType(StatusTypeData.TEXTTYPE, statusTypeDataCreation.MRE_sharedTST_8, statusTypeDataCreation.description2, viewDataCreation.section_5)
	    		   .createEventSharedStatusType(StatusTypeData.DATETYPE, statusTypeDataCreation.MRE_sharedDST_8, statusTypeDataCreation.description2, viewDataCreation.section_5)
	    		   .createEventSharedStatusType(StatusTypeData.NEDOCSTYPE, statusTypeDataCreation.MRE_sharedNEDOCST_8, statusTypeDataCreation.description2, viewDataCreation.section_5);
	    
	    eventSharedSTValue_In_RG1[0] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_sharedNST_8);
	    eventSharedSTValue_In_RG1[1] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_sharedMST_8);
	    eventSharedSTValue_In_RG1[2] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_sharedSST_8);
	    eventSharedSTValue_In_RG1[3] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_sharedTST_8);
	    eventSharedSTValue_In_RG1[4] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_sharedDST_8);
	    eventSharedSTValue_In_RG1[5] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_sharedNEDOCST_8);
	    
	    String[] eventSharedStatusesNames_In_RG1 = {statusTypeDataCreation.statusesName60, statusTypeDataCreation.statusesName61, statusTypeDataCreation.statusesName62};
	    String[] eventSharedSTNames_In_RG1={statusTypeDataCreation.MRE_sharedNST_8,statusTypeDataCreation.MRE_sharedMST_8,statusTypeDataCreation.MRE_sharedSST_8,statusTypeDataCreation.MRE_sharedTST_8,statusTypeDataCreation.MRE_sharedDST_8,statusTypeDataCreation.MRE_sharedNEDOCST_8};
	    
	    String[] statusTypeValues_In_RG1 = ArrayUtils.addAll(roleSTValue_In_RG1, eventRoleSTValue_In_RG1);
	    statusTypeValues_In_RG1 = ArrayUtils.addAll(statusTypeValues_In_RG1, privateSTValue_In_RG1);
	    statusTypeValues_In_RG1 = ArrayUtils.addAll(statusTypeValues_In_RG1, eventPrivateSTValue_In_RG1);
	    statusTypeValues_In_RG1 = ArrayUtils.addAll(statusTypeValues_In_RG1, sharedSTValue_In_RG1);
	    statusTypeValues_In_RG1 = ArrayUtils.addAll(statusTypeValues_In_RG1, eventSharedSTValue_In_RG1);
	    
	    navigateTo.resourceType();
	    resourceTypes.createResourceType(resourceTypeDataCreation.MRE_name4, statusTypeValues_In_RG1);
	    resourceTypeValue_In_RG1[0] = resourceTypes.getResourceTypeValue(resourceTypeDataCreation.MRE_name4);
	    
	    navigateTo.resources();
	    resources.createResourceWithAddress(resourceDataCreation.MRE_name6, resourceDataCreation.abbrevation10, resourceTypeDataCreation.MRE_name4, 
	    		ResourceData.STANDARDRESOURCETYPE, ResourceData.FIRSTNAME, 
	    		ResourceData.LASTNAME, ResourceData.STREETADDRESS,
	    		ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE, ResourceData.COUNTY)
	    		.createResourceWithAddress(resourceDataCreation.MRE_name7, resourceDataCreation.abbrevation11, resourceTypeDataCreation.MRE_name4, 
	    		ResourceData.STANDARDRESOURCETYPE, ResourceData.FIRSTNAME, 
	    		ResourceData.LASTNAME, ResourceData.STREETADDRESS,
	    		ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE, ResourceData.COUNTY);
	    resourceValues_In_RG1[0] = resources.getResourceValue(resourceDataCreation.MRE_name6);
	    resourceValues_In_RG1[1] = resources.getResourceValue(resourceDataCreation.MRE_name7);
	    
	    navigateTo.eventSetUp();
	    eventSetUp.createMultiRegionEventTemplate(eventSetupDataCreation.name6, eventSetupDataCreation.definition6, EventSetUpData.CHEMICAL_ICON, EventSetUpData.PURPLE_COLOUR, resourceTypeValue_In_RG1[0], statusTypeValues_In_RG1)
	              .createMultiRegionEventTemplateSelectingWebOption(eventSetupDataCreation.name7, eventSetupDataCreation.definition7,EventSetUpData.ENVELPOE_ICON, EventSetUpData.AMBER_COLOUR, resourceTypeValue_In_RG1[0], statusTypeValues_In_RG1, userDataCreation.MRE_name5);
	    
	    String[] allRoleST_In_RG1=ArrayUtils.addAll(roleSTNames_In_RG1, roleStatusesNames_In_RG1);
	    String[] allEventRoleST_In_RG1 = ArrayUtils.addAll(eventRoleSTNames_In_RG1, eventRoleStatusesNames_In_RG1);
	    String[] allPrivateST_In_RG1=ArrayUtils.addAll(privateSTNames_In_RG1, privateStatusesNames_In_RG1);
	    String[] allEventPrivateST_In_RG1 = ArrayUtils.addAll(eventPrivateSTNames_In_RG1, eventPrivateStatusesNames_In_RG1);
	    String[] allSharedST_In_RG1 = ArrayUtils.addAll(sharedSTNames_In_RG1, sharedStatusesNames_In_RG1);
	    String[] allEventSharedST_In_RG1 = ArrayUtils.addAll(eventSharedSTNames_In_RG1, eventSharedStatusesNames_In_RG1);
	    
	    String[] All36STsOfRGName_In_RG1 = ArrayUtils.addAll(allRoleST_In_RG1,allEventRoleST_In_RG1);
	    All36STsOfRGName_In_RG1 = ArrayUtils.addAll(All36STsOfRGName_In_RG1, allPrivateST_In_RG1);
	    All36STsOfRGName_In_RG1 = ArrayUtils.addAll(All36STsOfRGName_In_RG1, allEventPrivateST_In_RG1);
	    All36STsOfRGName_In_RG1 = ArrayUtils.addAll(All36STsOfRGName_In_RG1, allSharedST_In_RG1);
	    All36STsOfRGName_In_RG1 = ArrayUtils.addAll(All36STsOfRGName_In_RG1, allEventSharedST_In_RG1);
	    
	    String[] All36STsOfRGNodes_In_RG1 = {StatusTypeTags.ROLE_NST_IN_REGION1,StatusTypeTags.ROLE_MST_IN_REGION1,
	    		StatusTypeTags.ROLE_SST_IN_REGION1,StatusTypeTags.ROLE_TST_IN_REGION1,
	    		StatusTypeTags.ROLE_DST_IN_REGION1,StatusTypeTags.ROLE_NEDOCST_IN_REGION1,
	    		StatusTypeTags.ROLE_STATUSES_NAMES1_IN_REGION1,StatusTypeTags.ROLE_STATUSES_NAMES2_IN_REGION1,StatusTypeTags.ROLE_STATUSES_NAMES3_IN_REGION1,
	    		StatusTypeTags.EVENT_ROLE_NST_IN_REGION1,StatusTypeTags.EVENT_ROLE_MST_IN_REGION1,
	    		StatusTypeTags.EVENT_ROLE_SST_IN_REGION1,StatusTypeTags.EVENT_ROLE_TST_IN_REGION1,
	    		StatusTypeTags.EVENT_ROLE_DST_IN_REGION1,StatusTypeTags.EVENT_ROLE_NEDOCST_IN_REGION1,
	    		StatusTypeTags.EVENT_ROLE_STATUSES_NAMES1_IN_REGION1,StatusTypeTags.EVENT_ROLE_STATUSES_NAMES2_IN_REGION1,StatusTypeTags.EVENT_ROLE_STATUSES_NAMES3_IN_REGION1,
	    		StatusTypeTags.PRIVATE_NST_IN_REGION1,StatusTypeTags.PRIVATE_MST_IN_REGION1,
	    		StatusTypeTags.PRIVATE_SST_IN_REGION1,StatusTypeTags.PRIVATE_TST_IN_REGION1,
	    		StatusTypeTags.PRIVATE_DST_IN_REGION1,StatusTypeTags.PRIVATE_NEDOCST_IN_REGION1,
	    		StatusTypeTags.PRIVATE_STATUSES_NAMES1_IN_REGION1,StatusTypeTags.PRIVATE_STATUSES_NAMES2_IN_REGION1,StatusTypeTags.PRIVATE_STATUSES_NAMES3_IN_REGION1,
	    		StatusTypeTags.EVENT_PRIVATE_NST_IN_REGION1,StatusTypeTags.EVENT_PRIVATE_MST_IN_REGION1,
	    		StatusTypeTags.EVENT_PRIVATE_SST_IN_REGION1,StatusTypeTags.EVENT_PRIVATE_TST_IN_REGION1,
	    		StatusTypeTags.EVENT_PRIVATE_DST_IN_REGION1,StatusTypeTags.EVENT_PRIVATE_NEDOCST_IN_REGION1,
	    		StatusTypeTags.EVENT_PRIVATE_STATUSES_NAMES1_IN_REGION1,StatusTypeTags.EVENT_PRIVATE_STATUSES_NAMES2_IN_REGION1,StatusTypeTags.EVENT_PRIVATE_STATUSES_NAMES3_IN_REGION1,
	    		StatusTypeTags.SHARED_NST_IN_REGION1,StatusTypeTags.SHARED_MST_IN_REGION1,
	    		StatusTypeTags.SHARED_SST_IN_REGION1,StatusTypeTags.SHARED_TST_IN_REGION1,
	    		StatusTypeTags.SHARED_DST_IN_REGION1,StatusTypeTags.SHARED_NEDOCST_IN_REGION1,
	    		StatusTypeTags.SHARED_STATUSES_NAMES1_IN_REGION1,StatusTypeTags.SHARED_STATUSES_NAMES2_IN_REGION1,StatusTypeTags.SHARED_STATUSES_NAMES3_IN_REGION1,
	    		StatusTypeTags.EVENT_SHARED_NST_IN_REGION1,StatusTypeTags.EVENT_SHARED_MST_IN_REGION1,
	    		StatusTypeTags.EVENT_SHARED_SST_IN_REGION1,StatusTypeTags.EVENT_SHARED_TST_IN_REGION1,
	    		StatusTypeTags.EVENT_SHARED_DST_IN_REGION1,StatusTypeTags.EVENT_SHARED_NEDOCST_IN_REGION1,
	    		StatusTypeTags.EVENT_SHARED_STATUSES_NAMES1_IN_REGION1,StatusTypeTags.EVENT_SHARED_STATUSES_NAMES2_IN_REGION1,StatusTypeTags.EVENT_SHARED_STATUSES_NAMES3_IN_REGION1};
	    
	    String[] allRoleSTValue_In_RG1 = ArrayUtils.addAll(roleSTValue_In_RG1, roleStatusValues_In_RG1);
	    String[] allEventRoleSTValue_In_RG1 = ArrayUtils.addAll(eventRoleSTValue_In_RG1, eventRoleStatusValues_In_RG1);
	    String[] allPrivateSTValue_In_RG1 = ArrayUtils.addAll(privateSTValue_In_RG1, privateStatusValues_In_RG1);
	    String[] allEventPrivateSTValue_In_RG1 = ArrayUtils.addAll(eventPrivateSTValue_In_RG1, eventPrivateStatusValues_In_RG1);
	    String[] allSharedSTValue_In_RG1 = ArrayUtils.addAll(sharedSTValue_In_RG1, sharedStatusValues_In_RG1);
	    String[] allEventSharedSTValue_In_RG1 = ArrayUtils.addAll(eventSharedSTValue_In_RG1, eventSharedStatusValues_In_RG1);
	    
	    String[] All36STsOfRG1_Value = ArrayUtils.addAll(allRoleSTValue_In_RG1, allEventRoleSTValue_In_RG1);
	    All36STsOfRG1_Value = ArrayUtils.addAll(All36STsOfRG1_Value, allPrivateSTValue_In_RG1);
	    All36STsOfRG1_Value = ArrayUtils.addAll(All36STsOfRG1_Value, allEventPrivateSTValue_In_RG1);
	    All36STsOfRG1_Value = ArrayUtils.addAll(All36STsOfRG1_Value, allSharedSTValue_In_RG1);
	    All36STsOfRG1_Value = ArrayUtils.addAll(All36STsOfRG1_Value, allEventSharedSTValue_In_RG1);
	    
	    String[] All36STsValueOfRG1Nodes = {StatusTypeTags.ROLE_NST_VALUE_IN_REGION1,StatusTypeTags.ROLE_MST_VALUE_IN_REGION1,
	    		StatusTypeTags.ROLE_SST_VALUE_IN_REGION1,StatusTypeTags.ROLE_TST_VALUE_IN_REGION1,
	    		StatusTypeTags.ROLE_DST_VALUE_IN_REGION1,StatusTypeTags.ROLE_NEDOCST_VALUE_IN_REGION1,
	    		StatusTypeTags.ROLE_STATUSES_VALUES1_IN_REGION1,StatusTypeTags.ROLE_STATUSES_VALUES2_IN_REGION1,StatusTypeTags.ROLE_STATUSES_VALUES3_IN_REGION1,
	    		StatusTypeTags.EVENT_ROLE_NST_VALUE_IN_REGION1,StatusTypeTags.EVENT_ROLE_MST_VALUE_IN_REGION1,
	    		StatusTypeTags.EVENT_ROLE_SST_VALUE_IN_REGION1,StatusTypeTags.EVENT_ROLE_TST_VALUE_IN_REGION1,
	    		StatusTypeTags.EVENT_ROLE_DST_VALUE_IN_REGION1,StatusTypeTags.EVENT_ROLE_NEDOCST_VALUE_IN_REGION1,
	    		StatusTypeTags.EVENT_ROLE_STATUSES_VALUES1_IN_REGION1,StatusTypeTags.EVENT_ROLE_STATUSES_VALUES2_IN_REGION1,StatusTypeTags.EVENT_ROLE_STATUSES_VALUES3_IN_REGION1,
	    		StatusTypeTags.PRIVATE_NST_VALUE_IN_REGION1,StatusTypeTags.PRIVATE_MST_VALUE_IN_REGION1,
	    		StatusTypeTags.PRIVATE_SST_VALUE_IN_REGION1,StatusTypeTags.PRIVATE_TST_VALUE_IN_REGION1,
	    		StatusTypeTags.PRIVATE_DST_VALUE_IN_REGION1,StatusTypeTags.PRIVATE_NEDOCST_VALUE_IN_REGION1,
	    		StatusTypeTags.PRIVATE_STATUSES_VALUES1_IN_REGION1,StatusTypeTags.PRIVATE_STATUSES_VALUES2_IN_REGION1,StatusTypeTags.PRIVATE_STATUSES_VALUES3_IN_REGION1,
	    		StatusTypeTags.EVENT_PRIVATE_NST_VALUE_IN_REGION1,StatusTypeTags.EVENT_PRIVATE_MST_VALUE_IN_REGION1,
	    		StatusTypeTags.EVENT_PRIVATE_SST_VALUE_IN_REGION1,StatusTypeTags.EVENT_PRIVATE_TST_VALUE_IN_REGION1,
	    		StatusTypeTags.EVENT_PRIVATE_DST_VALUE_IN_REGION1,StatusTypeTags.EVENT_PRIVATE_NEDOCST_VALUE_IN_REGION1,
	    		StatusTypeTags.EVENT_PRIVATE_STATUSES_VALUES1_IN_REGION1,StatusTypeTags.EVENT_PRIVATE_STATUSES_VALUES2_IN_REGION1,StatusTypeTags.EVENT_PRIVATE_STATUSES_VALUES3_IN_REGION1,
	    		StatusTypeTags.SHARED_NST_VALUE_IN_REGION1,StatusTypeTags.SHARED_MST_VALUE_IN_REGION1,
	    		StatusTypeTags.SHARED_SST_VALUE_IN_REGION1,StatusTypeTags.SHARED_TST_VALUE_IN_REGION1,
	    		StatusTypeTags.SHARED_DST_VALUE_IN_REGION1,StatusTypeTags.SHARED_NEDOCST_VALUE_IN_REGION1,
	    		StatusTypeTags.SHARED_STATUSES_VALUES1_IN_REGION1,StatusTypeTags.SHARED_STATUSES_VALUES2_IN_REGION1,StatusTypeTags.SHARED_STATUSES_VALUES3_IN_REGION1,
	    		StatusTypeTags.EVENT_SHARED_NST_VALUE_IN_REGION1,StatusTypeTags.EVENT_SHARED_MST_VALUE_IN_REGION1,
	    		StatusTypeTags.EVENT_SHARED_SST_VALUE_IN_REGION1,StatusTypeTags.EVENT_SHARED_TST_VALUE_IN_REGION1,
	    		StatusTypeTags.EVENT_SHARED_DST_VALUE_IN_REGION1,StatusTypeTags.EVENT_SHARED_NEDOCST_VALUE_IN_REGION1,
	    		StatusTypeTags.EVENT_SHARED_STATUSES_VALUES1_IN_REGION1,StatusTypeTags.EVENT_SHARED_STATUSES_VALUES2_IN_REGION1,StatusTypeTags.EVENT_SHARED_STATUSES_VALUES3_IN_REGION1};
	    
	    statusTypeDataCreation.writeStatusTypesDataToXml(All36STsOfRGName_In_RG1, All36STsOfRGNodes_In_RG1);
	    statusTypeDataCreation.writeStatusTypesDataToXml(All36STsOfRG1_Value, All36STsValueOfRG1Nodes);
	    
	    resourceTypeDataCreation.writeResourceTypeDataToXml(resourceTypeDataCreation.MRE_name4, ResourceTypeTags.RT_NAME_IN_REGION1);
	    resourceTypeDataCreation.writeResourceTypeDataToXml(resourceTypeValue_In_RG1[0], ResourceTypeTags.RT_VALUE_IN_REGION1);
	    
	    resourceDataCreation.writeResourceDataToXml(resourceDataCreation.MRE_name6, ResourceTags.RESOURCE_NAME1_IN_REGION1);
	    resourceDataCreation.writeResourceDataToXml(resourceValues_In_RG1[0], ResourceTags.RESOURCE_NAME1_VALUE_IN_REGION1);
	     
	    resourceDataCreation.writeResourceDataToXml(resourceDataCreation.MRE_name7, ResourceTags.RESOURCE_NAME2_IN_REGION1);
	    resourceDataCreation.writeResourceDataToXml(resourceValues_In_RG1[1], ResourceTags.RESOURCE_NAME2_VALUE_IN_REGION1);
	    
	    eventSetupDataCreation.writeEventDataToXml(eventSetupDataCreation.name6, EventSetUpTags.MULTI_REGION_EVENT_TEMPLATE3_WITHOUT_NOTIFICATION_IN_REGION1);
	    eventSetupDataCreation.writeEventDataToXml(eventSetupDataCreation.name7, EventSetUpTags.MULTI_REGION_EVENT_TEMPLATE4_WITH_NOTIFICATION_IN_REGION1);
	    
	    viewDataCreation.writeViewDataToXml(viewDataCreation.section_5, ViewTags.SECTION_IN_REGION_NAME_2);
	    
	    /****
		 * Login as Admin to Region (Z_NewBQSSuite_MutualAid_Reg1)
		 * NavigatetoviewUnderSetup
		 * create section 'Section6'
		 * NavigatetostatusTypes
		 * create all 6 SharedStatusTypes and 6 EventRelatedSharedStatusTypes under section 'Section3'
		 * create all 6 PrivateStatusTypes and 6 EventRelatedPrivateStatusTypes under section 'Section3'
		 * create all 6 roleBasedStatusTypes and 6 EventRelatedroleBasedStatusTypes under section 'Section3'
		 * NavigatetoResourceTypes 
		 * Create ResourceType (RT1) by selecting all 36 the status types
		 * NavigatetoResource
		 * Create Resource (RS1) by selecting resource type RT1
		 * Create Resource (RS2) by selecting resource type RT1
		 * NavigatetoeventSetUp
		 * Create event template (ET1) by selecting notifications for user
		 * Create event template (ET2) by deselecting notifications for user
		 ****/
	    
//Region (Z_NewBQSSuite_MutualAid_Reg1)
	    
	    String roleSTValue_In_RG2[] = new String[6];
		String roleStatusValues_In_RG2[]= new String[3];
	    
	    String eventRoleSTValue_In_RG2[] = new String[6];
		String eventRoleStatusValues_In_RG2[]= new String[3];
		
	    String privateSTValue_In_RG2[] = new String[6];
		String privateStatusValues_In_RG2[]= new String[3];
		
		String eventPrivateSTValue_In_RG2[] = new String[6];
		String eventPrivateStatusValues_In_RG2[]= new String[3];
		
	    String sharedSTValue_In_RG2[] = new String[6];
		String sharedStatusValues_In_RG2[]= new String[3];
		
		String eventSharedSTValue_In_RG2[] = new String[6];
		String eventSharedStatusValues_In_RG2[]= new String[3];
		
		String resourceTypeValue_In_RG2[] = new String[1];
		
		String resourceValues_In_RG2[] = new String[2];
	    
	    selectRegion.selectRegionAndClickOnNext(RegionData.REGION_WITH_MUTUAL_AGREEMENT3);
	    navigateTo.viewUnderSetup();
	    viewUnderSetup.createNewSection(viewDataCreation.section_6);
	    navigateTo.statusTypes();
	    statusTypes.createStatusType(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.MRE_nstName5, statusTypeDataCreation.description, viewDataCreation.section_6);
	    statusTypes.createStatusType(StatusTypeData.MULTITYPE, statusTypeDataCreation.MRE_mstName5, statusTypeDataCreation.description, viewDataCreation.section_6);
		statusTypes.createNewStatus(statusTypeDataCreation.statusesName63, StatusTypeData.STATUS_PURPLE_COLOR)
				   .createNewStatus(statusTypeDataCreation.statusesName64, StatusTypeData.STATUS_PURPLE_COLOR)
				   .createNewStatus(statusTypeDataCreation.statusesName65, StatusTypeData.STATUS_PURPLE_COLOR);
		
		roleStatusValues_In_RG2[0] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName63);
		roleStatusValues_In_RG2[1] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName64);
		roleStatusValues_In_RG2[2] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName65);
		
	    statusTypes.clickOnReturnToStatusTypeList()
	               .createStatusType(StatusTypeData.SATURATIONSCORETYPE, statusTypeDataCreation.MRE_sstName5, statusTypeDataCreation.description, viewDataCreation.section_6)
	    		   .createStatusType(StatusTypeData.TEXTTYPE, statusTypeDataCreation.MRE_tstName5, statusTypeDataCreation.description, viewDataCreation.section_6)
	    		   .createStatusType(StatusTypeData.DATETYPE, statusTypeDataCreation.MRE_dstName5, statusTypeDataCreation.description, viewDataCreation.section_6)
	    		   .createStatusType(StatusTypeData.NEDOCSTYPE, statusTypeDataCreation.MRE_nedocstName5, statusTypeDataCreation.description, viewDataCreation.section_6);
	    
	    roleSTValue_In_RG2[0] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_nstName5);
	    roleSTValue_In_RG2[1] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_mstName5);
	    roleSTValue_In_RG2[2] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_sstName5);
	    roleSTValue_In_RG2[3] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_tstName5);
	    roleSTValue_In_RG2[4] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_dstName5);
	    roleSTValue_In_RG2[5] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_nedocstName5);
	    
	    String[] roleStatusesNames_In_RG2 = {statusTypeDataCreation.statusesName63, statusTypeDataCreation.statusesName64, statusTypeDataCreation.statusesName65};
	    String[] roleSTNames_In_RG2 = {statusTypeDataCreation.MRE_nstName5,statusTypeDataCreation.MRE_mstName5,statusTypeDataCreation.MRE_sstName5,statusTypeDataCreation.MRE_tstName5,statusTypeDataCreation.MRE_dstName5,statusTypeDataCreation.MRE_nedocstName5};
	    
	    statusTypes.createEventStatusType(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.MRE_eventNst5, statusTypeDataCreation.description, viewDataCreation.section_6);
	    statusTypes.createEventStatusType(StatusTypeData.MULTITYPE, statusTypeDataCreation.MRE_eventMst5, statusTypeDataCreation.description, viewDataCreation.section_6);
		statusTypes.createNewStatus(statusTypeDataCreation.statusesName66, StatusTypeData.STATUS_PURPLE_COLOR)
				   .createNewStatus(statusTypeDataCreation.statusesName67, StatusTypeData.STATUS_PURPLE_COLOR)
				   .createNewStatus(statusTypeDataCreation.statusesName68, StatusTypeData.STATUS_PURPLE_COLOR);
		
		eventRoleStatusValues_In_RG2[0] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName66);
		eventRoleStatusValues_In_RG2[1] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName67);
		eventRoleStatusValues_In_RG2[2] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName68);
		
	    statusTypes.clickOnReturnToStatusTypeList()
	               .createEventStatusType(StatusTypeData.SATURATIONSCORETYPE, statusTypeDataCreation.MRE_eventSst5, statusTypeDataCreation.description, viewDataCreation.section_6)
	    		   .createEventStatusType(StatusTypeData.TEXTTYPE, statusTypeDataCreation.MRE_eventTst5, statusTypeDataCreation.description, viewDataCreation.section_6)
	    		   .createEventStatusType(StatusTypeData.DATETYPE, statusTypeDataCreation.MRE_eventDst5, statusTypeDataCreation.description, viewDataCreation.section_6)
	    		   .createEventStatusType(StatusTypeData.NEDOCSTYPE, statusTypeDataCreation.MRE_eventNdst5, statusTypeDataCreation.description, viewDataCreation.section_6);
	    		   
	    eventRoleSTValue_In_RG2[0] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_eventNst5);
	    eventRoleSTValue_In_RG2[1] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_eventMst5);
	    eventRoleSTValue_In_RG2[2] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_eventSst5);
	    eventRoleSTValue_In_RG2[3] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_eventTst5);
	    eventRoleSTValue_In_RG2[4] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_eventDst5);
	    eventRoleSTValue_In_RG2[5] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_eventNdst5);
	    
	    String[] eventRoleStatusesNames_In_RG2 = {statusTypeDataCreation.statusesName66, statusTypeDataCreation.statusesName67, statusTypeDataCreation.statusesName68};
	    String[] eventRoleSTNames_In_RG2 = {statusTypeDataCreation.MRE_eventNst5,statusTypeDataCreation.MRE_eventMst5,statusTypeDataCreation.MRE_eventSst5,statusTypeDataCreation.MRE_eventTst5,statusTypeDataCreation.MRE_eventDst5,statusTypeDataCreation.MRE_eventNdst5};
	    
	    statusTypes.createPrivateStatusType(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.MRE_privateNST_5, statusTypeDataCreation.description, viewDataCreation.section_6);
	    statusTypes.createPrivateStatusType(StatusTypeData.MULTITYPE, statusTypeDataCreation.MRE_privateMST_5, statusTypeDataCreation.description, viewDataCreation.section_6);
		statusTypes.createNewStatus(statusTypeDataCreation.statusesName69, StatusTypeData.STATUS_PURPLE_COLOR)
				   .createNewStatus(statusTypeDataCreation.statusesName70, StatusTypeData.STATUS_PURPLE_COLOR)
				   .createNewStatus(statusTypeDataCreation.statusesName71, StatusTypeData.STATUS_PURPLE_COLOR);
		
		privateStatusValues_In_RG2[0] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName69);
		privateStatusValues_In_RG2[1] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName70);
		privateStatusValues_In_RG2[2] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName71);
		
		
	    statusTypes.clickOnReturnToStatusTypeList()
	               .createPrivateStatusType(StatusTypeData.SATURATIONSCORETYPE, statusTypeDataCreation.MRE_privateSST_5, statusTypeDataCreation.description, viewDataCreation.section_6)
	    		   .createPrivateStatusType(StatusTypeData.TEXTTYPE, statusTypeDataCreation.MRE_privateTST_5, statusTypeDataCreation.description, viewDataCreation.section_6)
	    		   .createPrivateStatusType(StatusTypeData.DATETYPE, statusTypeDataCreation.MRE_privateDST_5, statusTypeDataCreation.description, viewDataCreation.section_6)
	    		   .createPrivateStatusType(StatusTypeData.NEDOCSTYPE, statusTypeDataCreation.MRE_privateNEDOCST_5, statusTypeDataCreation.description, viewDataCreation.section_6);
	    
	    privateSTValue_In_RG2[0] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_privateNST_5);
	    privateSTValue_In_RG2[1] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_privateMST_5);
	    privateSTValue_In_RG2[2] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_privateSST_5);
	    privateSTValue_In_RG2[3] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_privateTST_5);
	    privateSTValue_In_RG2[4] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_privateDST_5);
	    privateSTValue_In_RG2[5] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_privateNEDOCST_5);
	    
	    String[] privateStatusesNames_In_RG2 = {statusTypeDataCreation.statusesName69, statusTypeDataCreation.statusesName70, statusTypeDataCreation.statusesName71};
	    String[] privateSTNames_In_RG2 = {statusTypeDataCreation.MRE_privateNST_5,statusTypeDataCreation.MRE_privateMST_5,statusTypeDataCreation.MRE_privateSST_5,statusTypeDataCreation.MRE_privateTST_5,statusTypeDataCreation.MRE_privateDST_5,statusTypeDataCreation.MRE_privateNEDOCST_5};
	    
	    statusTypes.createEventPrivateStatusType(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.MRE_privateNST_6, statusTypeDataCreation.description, viewDataCreation.section_6);
	    statusTypes.createEventPrivateStatusType(StatusTypeData.MULTITYPE, statusTypeDataCreation.MRE_privateMST_6, statusTypeDataCreation.description, viewDataCreation.section_6);
		statusTypes.createNewStatus(statusTypeDataCreation.statusesName72, StatusTypeData.STATUS_PURPLE_COLOR)
				   .createNewStatus(statusTypeDataCreation.statusesName73, StatusTypeData.STATUS_PURPLE_COLOR)
				   .createNewStatus(statusTypeDataCreation.statusesName74, StatusTypeData.STATUS_PURPLE_COLOR);
		
		eventPrivateStatusValues_In_RG2[0] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName72);
		eventPrivateStatusValues_In_RG2[1] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName73);
		eventPrivateStatusValues_In_RG2[2] = statusTypes .getStatusesValue(statusTypeDataCreation.statusesName74);
		
	    statusTypes.clickOnReturnToStatusTypeList()
	               .createEventPrivateStatusType(StatusTypeData.SATURATIONSCORETYPE, statusTypeDataCreation.MRE_privateSST_6, statusTypeDataCreation.description, viewDataCreation.section_6)
	    		   .createEventPrivateStatusType(StatusTypeData.TEXTTYPE, statusTypeDataCreation.MRE_privateTST_6, statusTypeDataCreation.description, viewDataCreation.section_6)
	    		   .createEventPrivateStatusType(StatusTypeData.DATETYPE, statusTypeDataCreation.MRE_privateDST_6, statusTypeDataCreation.description, viewDataCreation.section_6)
	    		   .createEventPrivateStatusType(StatusTypeData.NEDOCSTYPE, statusTypeDataCreation.MRE_privateNEDOCST_6, statusTypeDataCreation.description, viewDataCreation.section_6);
	    
	    eventPrivateSTValue_In_RG2[0] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_privateNST_6);
	    eventPrivateSTValue_In_RG2[1] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_privateMST_6);
	    eventPrivateSTValue_In_RG2[2] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_privateSST_6);
	    eventPrivateSTValue_In_RG2[3] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_privateTST_6);
	    eventPrivateSTValue_In_RG2[4] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_privateDST_6);
	    eventPrivateSTValue_In_RG2[5] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_privateNEDOCST_6);
	    
	    String[] eventPrivateStatusesNames_In_RG2 = {statusTypeDataCreation.statusesName72, statusTypeDataCreation.statusesName73, statusTypeDataCreation.statusesName74};
	    String[] eventPrivateSTNames_In_RG2={statusTypeDataCreation.MRE_privateNST_6,statusTypeDataCreation.MRE_privateMST_6,statusTypeDataCreation.MRE_privateSST_6,statusTypeDataCreation.MRE_privateTST_6,statusTypeDataCreation.MRE_privateDST_6,statusTypeDataCreation.MRE_privateNEDOCST_6};
	    
	    statusTypes.createSharedStatusType(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.MRE_sharedNST_9, statusTypeDataCreation.description, viewDataCreation.section_6);
	    statusTypes.createSharedStatusType(StatusTypeData.MULTITYPE, statusTypeDataCreation.MRE_sharedMST_9, statusTypeDataCreation.description, viewDataCreation.section_6);
		statusTypes.createNewStatus(statusTypeDataCreation.statusesName75, StatusTypeData.STATUS_PURPLE_COLOR)
				   .createNewStatus(statusTypeDataCreation.statusesName76, StatusTypeData.STATUS_PURPLE_COLOR)
				   .createNewStatus(statusTypeDataCreation.statusesName77, StatusTypeData.STATUS_PURPLE_COLOR);
		
		sharedStatusValues_In_RG2[0]	=statusTypes .getStatusesValue(statusTypeDataCreation.statusesName75);
		sharedStatusValues_In_RG2[1]	=statusTypes .getStatusesValue(statusTypeDataCreation.statusesName76);
		sharedStatusValues_In_RG2[2]	=statusTypes .getStatusesValue(statusTypeDataCreation.statusesName77);
		
	    statusTypes.clickOnReturnToStatusTypeList()
	               .createSharedStatusType(StatusTypeData.SATURATIONSCORETYPE, statusTypeDataCreation.MRE_sharedSST_9, statusTypeDataCreation.description, viewDataCreation.section_6)
	    		   .createSharedStatusType(StatusTypeData.TEXTTYPE, statusTypeDataCreation.MRE_sharedTST_9, statusTypeDataCreation.description, viewDataCreation.section_6)
	    		   .createSharedStatusType(StatusTypeData.DATETYPE, statusTypeDataCreation.MRE_sharedDST_9, statusTypeDataCreation.description, viewDataCreation.section_6)
	    		   .createSharedStatusType(StatusTypeData.NEDOCSTYPE, statusTypeDataCreation.MRE_sharedNEDOCST_9, statusTypeDataCreation.description, viewDataCreation.section_6);
	    
	    sharedSTValue_In_RG2[0] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_sharedNST_9);
	    sharedSTValue_In_RG2[1] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_sharedMST_9);
	    sharedSTValue_In_RG2[2] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_sharedSST_9);
	    sharedSTValue_In_RG2[3] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_sharedTST_9);
	    sharedSTValue_In_RG2[4] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_sharedDST_9);
	    sharedSTValue_In_RG2[5] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_sharedNEDOCST_9);
	    
	    String[] sharedStatusesNames_In_RG2 = {statusTypeDataCreation.statusesName75, statusTypeDataCreation.statusesName76, statusTypeDataCreation.statusesName77};
	    String[] sharedSTNames_In_RG2={statusTypeDataCreation.MRE_sharedNST_9,statusTypeDataCreation.MRE_sharedMST_9,statusTypeDataCreation.MRE_sharedSST_9,statusTypeDataCreation.MRE_sharedTST_9,statusTypeDataCreation.MRE_sharedDST_9,statusTypeDataCreation.MRE_sharedNEDOCST_9};
	    
	    statusTypes.createEventSharedStatusType(StatusTypeData.NUMBERTYPE, statusTypeDataCreation.MRE_sharedNST_10, statusTypeDataCreation.description, viewDataCreation.section_6);
	    statusTypes.createEventSharedStatusType(StatusTypeData.MULTITYPE, statusTypeDataCreation.MRE_sharedMST_10, statusTypeDataCreation.description, viewDataCreation.section_6);
		statusTypes.createNewStatus(statusTypeDataCreation.statusesName78, StatusTypeData.STATUS_PURPLE_COLOR)
				   .createNewStatus(statusTypeDataCreation.statusesName79, StatusTypeData.STATUS_PURPLE_COLOR)
				   .createNewStatus(statusTypeDataCreation.statusesName80, StatusTypeData.STATUS_PURPLE_COLOR);
		
		eventSharedStatusValues_In_RG2[0]	=statusTypes .getStatusesValue(statusTypeDataCreation.statusesName78);
		eventSharedStatusValues_In_RG2[1]	=statusTypes .getStatusesValue(statusTypeDataCreation.statusesName79);
		eventSharedStatusValues_In_RG2[2]	=statusTypes .getStatusesValue(statusTypeDataCreation.statusesName80);
		
	    statusTypes.clickOnReturnToStatusTypeList()
	    		   .createEventSharedStatusType(StatusTypeData.SATURATIONSCORETYPE, statusTypeDataCreation.MRE_sharedSST_10, statusTypeDataCreation.description, viewDataCreation.section_6)
	    		   .createEventSharedStatusType(StatusTypeData.TEXTTYPE, statusTypeDataCreation.MRE_sharedTST_10, statusTypeDataCreation.description, viewDataCreation.section_6)
	    		   .createEventSharedStatusType(StatusTypeData.DATETYPE, statusTypeDataCreation.MRE_sharedDST_10, statusTypeDataCreation.description, viewDataCreation.section_6)
	    		   .createEventSharedStatusType(StatusTypeData.NEDOCSTYPE, statusTypeDataCreation.MRE_sharedNEDOCST_10, statusTypeDataCreation.description, viewDataCreation.section_6);
	    
	    eventSharedSTValue_In_RG2[0] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_sharedNST_10);
	    eventSharedSTValue_In_RG2[1] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_sharedMST_10);
	    eventSharedSTValue_In_RG2[2] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_sharedSST_10);
	    eventSharedSTValue_In_RG2[3] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_sharedTST_10);
	    eventSharedSTValue_In_RG2[4] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_sharedDST_10);
	    eventSharedSTValue_In_RG2[5] = statusTypes.getStatusTypeValue(statusTypeDataCreation.MRE_sharedNEDOCST_10);
	    
	    String[] eventSharedStatusesNames_In_RG2 = {statusTypeDataCreation.statusesName78, statusTypeDataCreation.statusesName79, statusTypeDataCreation.statusesName80};
	    String[] eventSharedSTNames_In_RG2={statusTypeDataCreation.MRE_sharedNST_10,statusTypeDataCreation.MRE_sharedMST_10,statusTypeDataCreation.MRE_sharedSST_10,statusTypeDataCreation.MRE_sharedTST_10,statusTypeDataCreation.MRE_sharedDST_10,statusTypeDataCreation.MRE_sharedNEDOCST_10};
	    
	    String[] statusTypeValues_In_RG2 = ArrayUtils.addAll(roleSTValue_In_RG2, eventRoleSTValue_In_RG2);
	    statusTypeValues_In_RG2 = ArrayUtils.addAll(statusTypeValues_In_RG2, privateSTValue_In_RG2);
	    statusTypeValues_In_RG2 = ArrayUtils.addAll(statusTypeValues_In_RG2, eventPrivateSTValue_In_RG2);
	    statusTypeValues_In_RG2 = ArrayUtils.addAll(statusTypeValues_In_RG2, sharedSTValue_In_RG2);
	    statusTypeValues_In_RG2 = ArrayUtils.addAll(statusTypeValues_In_RG2, eventSharedSTValue_In_RG2);
	    
	    navigateTo.resourceType();
	    resourceTypes.createResourceType(resourceTypeDataCreation.MRE_name5, statusTypeValues_In_RG2);
	    resourceTypeValue_In_RG2[0] = resourceTypes.getResourceTypeValue(resourceTypeDataCreation.MRE_name5);
	    
	    navigateTo.resources();
	    resources.createResourceWithAddress(resourceDataCreation.MRE_name8, resourceDataCreation.abbrevation, resourceTypeDataCreation.MRE_name5, 
	    		ResourceData.STANDARDRESOURCETYPE, ResourceData.FIRSTNAME, 
	    		ResourceData.LASTNAME, ResourceData.STREETADDRESS,
	    		ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE, ResourceData.COUNTY)
	    		.createResourceWithAddress(resourceDataCreation.MRE_name9, resourceDataCreation.abbrevation, resourceTypeDataCreation.MRE_name5, 
	    		ResourceData.STANDARDRESOURCETYPE, ResourceData.FIRSTNAME, 
	    		ResourceData.LASTNAME, ResourceData.STREETADDRESS,
	    		ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE, ResourceData.COUNTY);
	    resourceValues_In_RG2[0] = resources.getResourceValue(resourceDataCreation.MRE_name8);
	    resourceValues_In_RG2[1] = resources.getResourceValue(resourceDataCreation.MRE_name9);
	    
	    navigateTo.eventSetUp();
	    eventSetUp.createMultiRegionEventTemplate(eventSetupDataCreation.name8, eventSetupDataCreation.definition, EventSetUpData.LANDSLIDE_ICON, EventSetUpData.SILVER_COLOUR, resourceTypeValue_In_RG2[0], statusTypeValues_In_RG2)
	              .createMultiRegionEventTemplateSelectingWebOption(eventSetupDataCreation.name9, eventSetupDataCreation.definition, EventSetUpData.VOLCANO_ICON, EventSetUpData.BLUE_COLOUR, resourceTypeValue_In_RG2[0], statusTypeValues_In_RG2, userDataCreation.MRE_name5);
	    
	    String[] allRoleST_In_RG2=ArrayUtils.addAll(roleSTNames_In_RG2, roleStatusesNames_In_RG2);
	    String[] allEventRoleST_In_RG2 = ArrayUtils.addAll(eventRoleSTNames_In_RG2, eventRoleStatusesNames_In_RG2);
	    String[] allPrivateST_In_RG2=ArrayUtils.addAll(privateSTNames_In_RG2, privateStatusesNames_In_RG2);
	    String[] allEventPrivateST_In_RG2 = ArrayUtils.addAll(eventPrivateSTNames_In_RG2, eventPrivateStatusesNames_In_RG2);
	    String[] allSharedST_In_RG2 = ArrayUtils.addAll(sharedSTNames_In_RG2, sharedStatusesNames_In_RG2);
	    String[] allEventSharedST_In_RG2 = ArrayUtils.addAll(eventSharedSTNames_In_RG2, eventSharedStatusesNames_In_RG2);
	    
	    String[] All36STsOfRGName_In_RG2 = ArrayUtils.addAll(allRoleST_In_RG2,allEventRoleST_In_RG2);
	    All36STsOfRGName_In_RG2 = ArrayUtils.addAll(All36STsOfRGName_In_RG2, allPrivateST_In_RG2);
	    All36STsOfRGName_In_RG2 = ArrayUtils.addAll(All36STsOfRGName_In_RG2, allEventPrivateST_In_RG2);
	    All36STsOfRGName_In_RG2 = ArrayUtils.addAll(All36STsOfRGName_In_RG2, allSharedST_In_RG2);
	    All36STsOfRGName_In_RG2 = ArrayUtils.addAll(All36STsOfRGName_In_RG2, allEventSharedST_In_RG2);
	    
	    String[] All36STsOfRGNodes_In_RG2 = {StatusTypeTags.ROLE_NST_IN_MUTUAL_AID_REGION3,StatusTypeTags.ROLE_MST_IN_MUTUAL_AID_REGION3,
	    		StatusTypeTags.ROLE_SST_IN_MUTUAL_AID_REGION3,StatusTypeTags.ROLE_TST_IN_MUTUAL_AID_REGION3,
	    		StatusTypeTags.ROLE_DST_IN_MUTUAL_AID_REGION3,StatusTypeTags.ROLE_NEDOCST_IN_MUTUAL_AID_REGION3,
	    		StatusTypeTags.ROLE_STATUSES_NAMES1_IN_MUTUAL_AID_REGION3,StatusTypeTags.ROLE_STATUSES_NAMES2_IN_MUTUAL_AID_REGION3,StatusTypeTags.ROLE_STATUSES_NAMES3_IN_MUTUAL_AID_REGION3,
	    		StatusTypeTags.EVENT_ROLE_NST_IN_MUTUAL_AID_REGION3,StatusTypeTags.EVENT_ROLE_MST_IN_MUTUAL_AID_REGION3,
	    		StatusTypeTags.EVENT_ROLE_SST_IN_MUTUAL_AID_REGION3,StatusTypeTags.EVENT_ROLE_TST_IN_MUTUAL_AID_REGION3,
	    		StatusTypeTags.EVENT_ROLE_DST_IN_MUTUAL_AID_REGION3,StatusTypeTags.EVENT_ROLE_NEDOCST_IN_MUTUAL_AID_REGION3,
	    		StatusTypeTags.EVENT_ROLE_STATUSES_NAMES1_IN_MUTUAL_AID_REGION3,StatusTypeTags.EVENT_ROLE_STATUSES_NAMES2_IN_MUTUAL_AID_REGION3,StatusTypeTags.EVENT_ROLE_STATUSES_NAMES3_IN_MUTUAL_AID_REGION3,
	    		StatusTypeTags.PRIVATE_NST_IN_MUTUAL_AID_REGION3,StatusTypeTags.PRIVATE_MST_IN_MUTUAL_AID_REGION3,
	    		StatusTypeTags.PRIVATE_SST_IN_MUTUAL_AID_REGION3,StatusTypeTags.PRIVATE_TST_IN_MUTUAL_AID_REGION3,
	    		StatusTypeTags.PRIVATE_DST_IN_MUTUAL_AID_REGION3,StatusTypeTags.PRIVATE_NEDOCST_IN_MUTUAL_AID_REGION3,
	    		StatusTypeTags.PRIVATE_STATUSES_NAMES1_IN_MUTUAL_AID_REGION3,StatusTypeTags.PRIVATE_STATUSES_NAMES2_IN_MUTUAL_AID_REGION3,StatusTypeTags.PRIVATE_STATUSES_NAMES3_IN_MUTUAL_AID_REGION3,
	    		StatusTypeTags.EVENT_PRIVATE_NST_IN_MUTUAL_AID_REGION3,StatusTypeTags.EVENT_PRIVATE_MST_IN_MUTUAL_AID_REGION3,
	    		StatusTypeTags.EVENT_PRIVATE_SST_IN_MUTUAL_AID_REGION3,StatusTypeTags.EVENT_PRIVATE_TST_IN_MUTUAL_AID_REGION3,
	    		StatusTypeTags.EVENT_PRIVATE_DST_IN_MUTUAL_AID_REGION3,StatusTypeTags.EVENT_PRIVATE_NEDOCST_IN_MUTUAL_AID_REGION3,
	    		StatusTypeTags.EVENT_PRIVATE_STATUSES_NAMES1_IN_MUTUAL_AID_REGION3,StatusTypeTags.EVENT_PRIVATE_STATUSES_NAMES2_IN_MUTUAL_AID_REGION3,StatusTypeTags.EVENT_PRIVATE_STATUSES_NAMES3_IN_MUTUAL_AID_REGION3,
	    		StatusTypeTags.SHARED_NST_IN_MUTUAL_AID_REGION3,StatusTypeTags.SHARED_MST_IN_MUTUAL_AID_REGION3,
	    		StatusTypeTags.SHARED_SST_IN_MUTUAL_AID_REGION3,StatusTypeTags.SHARED_TST_IN_MUTUAL_AID_REGION3,
	    		StatusTypeTags.SHARED_DST_IN_MUTUAL_AID_REGION3,StatusTypeTags.SHARED_NEDOCST_IN_MUTUAL_AID_REGION3,
	    		StatusTypeTags.SHARED_STATUSES_NAMES1_IN_MUTUAL_AID_REGION3,StatusTypeTags.SHARED_STATUSES_NAMES2_IN_MUTUAL_AID_REGION3,StatusTypeTags.SHARED_STATUSES_NAMES3_IN_MUTUAL_AID_REGION3,
	    		StatusTypeTags.EVENT_SHARED_NST_IN_MUTUAL_AID_REGION3,StatusTypeTags.EVENT_SHARED_MST_IN_MUTUAL_AID_REGION3,
	    		StatusTypeTags.EVENT_SHARED_SST_IN_MUTUAL_AID_REGION3,StatusTypeTags.EVENT_SHARED_TST_IN_MUTUAL_AID_REGION3,
	    		StatusTypeTags.EVENT_SHARED_DST_IN_MUTUAL_AID_REGION3,StatusTypeTags.EVENT_SHARED_NEDOCST_IN_MUTUAL_AID_REGION3,
	    		StatusTypeTags.EVENT_SHARED_STATUSES_NAMES1_IN_MUTUAL_AID_REGION3,StatusTypeTags.EVENT_SHARED_STATUSES_NAMES2_IN_MUTUAL_AID_REGION3,StatusTypeTags.EVENT_SHARED_STATUSES_NAMES3_IN_MUTUAL_AID_REGION3};
	    
	    String[] allRoleSTValue_In_RG2 = ArrayUtils.addAll(roleSTValue_In_RG2, roleStatusValues_In_RG2);
	    String[] allEventRoleSTValue_In_RG2 = ArrayUtils.addAll(eventRoleSTValue_In_RG2, eventRoleStatusValues_In_RG2);
	    String[] allPrivateSTValue_In_RG2 = ArrayUtils.addAll(privateSTValue_In_RG2, privateStatusValues_In_RG2);
	    String[] allEventPrivateSTValue_In_RG2 = ArrayUtils.addAll(eventPrivateSTValue_In_RG2, eventPrivateStatusValues_In_RG2);
	    String[] allSharedSTValue_In_RG2 = ArrayUtils.addAll(sharedSTValue_In_RG2, sharedStatusValues_In_RG2);
	    String[] allEventSharedSTValue_In_RG2 = ArrayUtils.addAll(eventSharedSTValue_In_RG2, eventSharedStatusValues_In_RG2);
	    
	    String[] All36STsOfRG2_Value = ArrayUtils.addAll(allRoleSTValue_In_RG2, allEventRoleSTValue_In_RG2);
	    All36STsOfRG2_Value = ArrayUtils.addAll(All36STsOfRG2_Value, allPrivateSTValue_In_RG2);
	    All36STsOfRG2_Value = ArrayUtils.addAll(All36STsOfRG2_Value, allEventPrivateSTValue_In_RG2);
	    All36STsOfRG2_Value = ArrayUtils.addAll(All36STsOfRG2_Value, allSharedSTValue_In_RG2);
	    All36STsOfRG2_Value = ArrayUtils.addAll(All36STsOfRG2_Value, allEventSharedSTValue_In_RG2);
	    
	    String[] All36STsValueOfRG2Nodes = {StatusTypeTags.ROLE_NST_VALUE_IN_MUTUAL_AID_REGION3,StatusTypeTags.ROLE_MST_VALUE_IN_MUTUAL_AID_REGION3,
	    		StatusTypeTags.ROLE_SST_VALUE_IN_MUTUAL_AID_REGION3,StatusTypeTags.ROLE_TST_VALUE_IN_MUTUAL_AID_REGION3,
	    		StatusTypeTags.ROLE_DST_VALUE_IN_MUTUAL_AID_REGION3,StatusTypeTags.ROLE_NEDOCST_VALUE_IN_MUTUAL_AID_REGION3,
	    		StatusTypeTags.ROLE_STATUSES_VALUES1_IN_MUTUAL_AID_REGION3,StatusTypeTags.ROLE_STATUSES_VALUES2_IN_MUTUAL_AID_REGION3,StatusTypeTags.ROLE_STATUSES_VALUES3_IN_MUTUAL_AID_REGION3,
	    		StatusTypeTags.EVENT_ROLE_NST_VALUE_IN_MUTUAL_AID_REGION3,StatusTypeTags.EVENT_ROLE_MST_VALUE_IN_MUTUAL_AID_REGION3,
	    		StatusTypeTags.EVENT_ROLE_SST_VALUE_IN_MUTUAL_AID_REGION3,StatusTypeTags.EVENT_ROLE_TST_VALUE_IN_MUTUAL_AID_REGION3,
	    		StatusTypeTags.EVENT_ROLE_DST_VALUE_IN_MUTUAL_AID_REGION3,StatusTypeTags.EVENT_ROLE_NEDOCST_VALUE_IN_MUTUAL_AID_REGION3,
	    		StatusTypeTags.EVENT_ROLE_STATUSES_VALUES1_IN_MUTUAL_AID_REGION3,StatusTypeTags.EVENT_ROLE_STATUSES_VALUES2_IN_MUTUAL_AID_REGION3,StatusTypeTags.EVENT_ROLE_STATUSES_VALUES3_IN_MUTUAL_AID_REGION3,
	    		StatusTypeTags.PRIVATE_NST_VALUE_IN_MUTUAL_AID_REGION3,StatusTypeTags.PRIVATE_MST_VALUE_IN_MUTUAL_AID_REGION3,
	    		StatusTypeTags.PRIVATE_SST_VALUE_IN_MUTUAL_AID_REGION3,StatusTypeTags.PRIVATE_TST_VALUE_IN_MUTUAL_AID_REGION3,
	    		StatusTypeTags.PRIVATE_DST_VALUE_IN_MUTUAL_AID_REGION3,StatusTypeTags.PRIVATE_NEDOCST_VALUE_IN_MUTUAL_AID_REGION3,
	    		StatusTypeTags.PRIVATE_STATUSES_VALUES1_IN_MUTUAL_AID_REGION3,StatusTypeTags.PRIVATE_STATUSES_VALUES2_IN_MUTUAL_AID_REGION3,StatusTypeTags.PRIVATE_STATUSES_VALUES3_IN_MUTUAL_AID_REGION3,
	    		StatusTypeTags.EVENT_PRIVATE_NST_VALUE_IN_MUTUAL_AID_REGION3,StatusTypeTags.EVENT_PRIVATE_MST_VALUE_IN_MUTUAL_AID_REGION3,
	    		StatusTypeTags.EVENT_PRIVATE_SST_VALUE_IN_MUTUAL_AID_REGION3,StatusTypeTags.EVENT_PRIVATE_TST_VALUE_IN_MUTUAL_AID_REGION3,
	    		StatusTypeTags.EVENT_PRIVATE_DST_VALUE_IN_MUTUAL_AID_REGION3,StatusTypeTags.EVENT_PRIVATE_NEDOCST_VALUE_IN_MUTUAL_AID_REGION3,
	    		StatusTypeTags.EVENT_PRIVATE_STATUSES_VALUES1_IN_MUTUAL_AID_REGION3,StatusTypeTags.EVENT_PRIVATE_STATUSES_VALUES2_IN_MUTUAL_AID_REGION3,StatusTypeTags.EVENT_PRIVATE_STATUSES_VALUES3_IN_MUTUAL_AID_REGION3,
	    		StatusTypeTags.SHARED_NST_VALUE_IN_MUTUAL_AID_REGION3,StatusTypeTags.SHARED_MST_VALUE_IN_MUTUAL_AID_REGION3,
	    		StatusTypeTags.SHARED_SST_VALUE_IN_MUTUAL_AID_REGION3,StatusTypeTags.SHARED_TST_VALUE_IN_MUTUAL_AID_REGION3,
	    		StatusTypeTags.SHARED_DST_VALUE_IN_MUTUAL_AID_REGION3,StatusTypeTags.SHARED_NEDOCST_VALUE_IN_MUTUAL_AID_REGION3,
	    		StatusTypeTags.SHARED_STATUSES_VALUES1_IN_MUTUAL_AID_REGION3,StatusTypeTags.SHARED_STATUSES_VALUES2_IN_MUTUAL_AID_REGION3,StatusTypeTags.SHARED_STATUSES_VALUES3_IN_MUTUAL_AID_REGION3,
	    		StatusTypeTags.EVENT_SHARED_NST_VALUE_IN_MUTUAL_AID_REGION3,StatusTypeTags.EVENT_SHARED_MST_VALUE_IN_MUTUAL_AID_REGION3,
	    		StatusTypeTags.EVENT_SHARED_SST_VALUE_IN_MUTUAL_AID_REGION3,StatusTypeTags.EVENT_SHARED_TST_VALUE_IN_MUTUAL_AID_REGION3,
	    		StatusTypeTags.EVENT_SHARED_DST_VALUE_IN_MUTUAL_AID_REGION3,StatusTypeTags.EVENT_SHARED_NEDOCST_VALUE_IN_MUTUAL_AID_REGION3,
	    		StatusTypeTags.EVENT_SHARED_STATUSES_VALUES1_IN_MUTUAL_AID_REGION3,StatusTypeTags.EVENT_SHARED_STATUSES_VALUES2_IN_MUTUAL_AID_REGION3,StatusTypeTags.EVENT_SHARED_STATUSES_VALUES3_IN_MUTUAL_AID_REGION3};
	    
	    statusTypeDataCreation.writeStatusTypesDataToXml(All36STsOfRGName_In_RG2, All36STsOfRGNodes_In_RG2);
	    statusTypeDataCreation.writeStatusTypesDataToXml(All36STsOfRG2_Value, All36STsValueOfRG2Nodes);
	    
	    resourceTypeDataCreation.writeResourceTypeDataToXml(resourceTypeDataCreation.MRE_name5, ResourceTypeTags.MRE_RT_NAME_IN_MUTUAL_AGREEMENT_RG3);
	    resourceTypeDataCreation.writeResourceTypeDataToXml(resourceTypeValue_In_RG1[0], ResourceTypeTags.MRE_RT_VALUE_IN_MUTUAL_AGREEMENT_RG3);
	    
	    resourceDataCreation.writeResourceDataToXml(resourceDataCreation.MRE_name8, ResourceTags.RESOURCE_NAME1_IN_MUTUAL_AID_REGION3);
	    resourceDataCreation.writeResourceDataToXml(resourceValues_In_RG1[0], ResourceTags.RESOURCE_NAME1_VALUE_IN_MUTUAL_AID_REGION3);
	     
	    resourceDataCreation.writeResourceDataToXml(resourceDataCreation.MRE_name9, ResourceTags.RESOURCE_NAME2_IN_IN_MUTUAL_AID_REGION3);
	    resourceDataCreation.writeResourceDataToXml(resourceValues_In_RG1[1], ResourceTags.RESOURCE_NAME2_VALUE_IN_MUTUAL_AID_REGION3);
	    
	    eventSetupDataCreation.writeEventDataToXml(eventSetupDataCreation.name8, EventSetUpTags.EVENT_TEMPLATE1_WITHOUT_NOTIFICATION_IN_MUTUAL_AGREEMENT_REGION3);
	    eventSetupDataCreation.writeEventDataToXml(eventSetupDataCreation.name9, EventSetUpTags.EVENT_TEMPLATE2_WITH_NOTIFICATION_IN_MUTUAL_AGREEMENT_REGION3);
	    
	    viewDataCreation.writeViewDataToXml(viewDataCreation.section_6, ViewTags.SECTION_IN_REGION_WITH_MUTUAL_AGREEMENT3);
	    
	    login.logOut();
	    
	    login.loginAsNewUser(userDataCreation.MRE_name5, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD)
	    .logOut()
	    .loginAsNewUser(userDataCreation.name5, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD)
	    .logOut();
	    
		Result = "PASS";
	}
}
