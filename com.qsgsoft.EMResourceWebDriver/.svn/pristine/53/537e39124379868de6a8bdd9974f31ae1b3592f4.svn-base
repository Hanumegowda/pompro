package requirementGroup.CreatingAndManagingEvents;

import java.util.ArrayList;

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
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UsersList;

import org.apache.commons.lang3.ArrayUtils;
import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class HappyDayCreatingAndManagingEvents extends TestNG_UI_EXTENSIONS{

	public HappyDayCreatingAndManagingEvents() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/******************************************************************************************************************
	'Description	:Verify that 'Save' and 'Cancel' buttons are available at the top and bottom of the Edit Event page
	'Date	 		:1-Dec-2014
	'Author			:Anitha 
	*******************************************************************************************************************/
	
	@Test(description = "Verify that 'Save' and 'Cancel' buttons are available at the top and bottom of the Edit Event page.")
	public void testHappyDay149764() throws Exception {

		gstrTCID = "149764";
		gstrTO = "Verify that 'Save' and 'Cancel' buttons are available at the top and bottom of the Edit Event page.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		Login login_page1 = new Login(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(this.driver1);

		System.out.println("-----Precondition execution starts-------");

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();

		UsersList_page.navigateToUsers();

		UsersList_page.clickCreateNewUserButton();

		UsersList_page.enterUserDetails(objUser_data.strNewUserName,
				objUser_data.strNewPassword, objUser_data.strFullName);

		UsersList_page.clickAdvancedOptionAndExpand();

		UsersList_page.selectMaintainEventsOption();

		UsersList_page.clickSaveButton();
		
		System.out.println(objUser_data.strNewUserName);

		// create Event template
		objEventSetUp.navigateToEventSetUp();

		String[] strstatusTypeValues = {};
		String[] strResourceTypeValue = {};
		
		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strstatusTypeValues)
				
		.deselectSelectAllWebOption();
	    
	    System.out.println("-----Precondition ends and test execution starts-------");
	    
	    login_page1.loginAsNewUser(objUser_data.strNewUserName, objUser_data.strNewPassword);
	
	    RegionDefault_page1.selectFrame();
	
	    EventManagement_page1.navigateToEventManagement()
	    
	    .clickOnCreateNewEvent()
	    
	    .clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
	    
	    .enterAdHocEventName(objEvent_data.strEventName)
		
		.enterAdHocEventDescription(objEvent_data.strEventDescription)
	    
	    .verifySaveAndCancelButtons()
		
		.clickOnSaveButton()
		
		.verifyEventName(objEvent_data.strEventName)
		
		.clickOnEditLink(objEvent_data.strEventName)
		
		.verifySaveButtonInTopOfEventManagementPage()
	    
	    .verifyCancelButtonInTopOfEventManagementPage()
	    
	    .verifySaveButtonInBottomOfEventManagementPage()
	    
	    .verifyCancelButtonInBottomOfEventManagementPage()
		
		.clickOnCancelButton()
		
		.verifyEventManagementPage();
	    	    
	    gstrResult = "PASS";	
	}
	
	/*************************************************************************************
	'Description 	: Verify that event details are updated appropriately upon 'Saving'
	'Precondition	: 
	'Date 			: 01-Dec-2014 
	'Author 		: Renushree
	'------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that event details are updated appropriately upon 'Saving'")
	public void testHappyDay149765() throws Exception {

		gstrTCID = "149765";
		gstrTO = "Verify that event details are updated appropriately upon 'Saving'";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();

		String strStatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

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

		objStatusTypeList
				.createStatusType(objStatusTypes_data.strMultiStatusType,
						objStatusTypes_data.strMSTStatusTypeName,
						objStatusTypes_data.strStatusDescription)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti,
						objStatusTypes_data.strStatusColor)
				.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,objStatusTypes_data.strStatusColor)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti)
				.verCreatedStatusInStatusListForMulti(
						objStatusTypes_data.strStatusNameInMulti1)
				.clickOnReturnToStatusTypeList();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

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
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption().clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.createEventTemplate(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strTemplateDefinition,
						strResourceTypeValue, strStatusTypeValues)
				.deselectSelectAllWebOption()
				.verEveTemplateInList(objEventSetUp_data.strEventTemplate);
		
		objLogin.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue).clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName)
				.clickOnEditLink(objEvent_data.strEventName)
				.verifyEditEventScreenIsDisplayed()
				.enterAdHocEventName(objEvent_data.strEditedEventName)
				.clickOnSaveButton();

		String strEventName = "Update 1: " + objEvent_data.strEditedEventName;

		objEventManagement1
				.verifyEventName(objEvent_data.strEditedEventName)
				.verifyEventNameInEventBanner(strEventName)
				.clickOnEditLink(objEvent_data.strEditedEventName)
				.enterAdHocEventDescription(
						objEvent_data.strEditedEventDescription)
				.clickOnSaveButton();

		strEventName = "Update 2: " + objEvent_data.strEditedEventName;

		objEventManagement1.verifyEventName(objEvent_data.strEditedEventName)
				.verifyEventNameInEventBanner(strEventName);

		objLogin1.clickLogOut();
		
		 gstrResult = "PASS";	
	}
	
	/*************************************************************************************
	'Description 	: Verify that Status Type is retrieved when searched providing its name in 
						Create/Edit Ad Hoc Event -> Select Status Types (requires filtering by resource ids)page. 
	'Precondition	: 
	'Date 			: 31-Dec-2014 
	'Author 		: Renushree
	'------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = " 	Verify that Status Type is retrieved when searched providing its name in "
			+ "Create/Edit Ad Hoc Event -> Select Status Types (requires filtering by resource ids)page. ")
	public void testHappyDay151416() throws Exception {

		gstrTCID = "151416";
		gstrTO = " 	Verify that Status Type is retrieved when searched providing its name in "
				+ "Create/Edit Ad Hoc Event -> Select Status Types (requires filtering by resource ids)page. ";

		Login_data objLogindata = new Login_data();
		Event_data objEvent_data = new Event_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		
		Login objLogin = new Login(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		
		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		Resource objResource1 = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();

		String strStatusTypeValues;
		ArrayList<String> a = new ArrayList<String>();
		String strNewStatusTypeValues[] = new String[2];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objRegionDefault.selectFrame();
		
		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();
		
		objStatusTypeList.verAndCreate15StatusTypes();
		
		String[] strStatusTypesNames = objStatusTypeList.getStatusTypeNames();
		
		for(int i = 0 ; i<strStatusTypesNames.length ; i++){
			strStatusTypeValues = objStatusTypeList.getStatusValue(strStatusTypesNames[i]);
			a.add(strStatusTypeValues);
		}

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strNewStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strNewStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);
		
		objNavigationToSubmenus.navigateToResourceTypesInSetup();
		
		String[] strValues = a.toArray(new String[a.size()]);
		String[] strAllStatusVal = ArrayUtils.addAll(strNewStatusTypeValues, strValues);

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strAllStatusVal);

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
		
		String[] resourceName = { objResource_data.strResourceName};
		
		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.selectMaintainAdHocEventsOption().clickSaveButton();

		objLogin.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
						objUserdata.strNewPassword);
		
		objRegionDefault1.selectFrame();
		
		objEventManagement1.navigateToEventManagement()
						  .clickOnCreateAdHocEventButton()
						  .enterAdHocEventName(objEvent_data.strEventName)
						  .enterAdHocEventDescription(objEvent_data.strEventDescription)
						  .clickOnNextButton().verifySelectResourcesDisplayed()
						  .verifyResourceNameInSelectResourcePage(resourceName);
		
		objResource1.clickResource(strResourceValue);

		String [] strStatusTypes1 ={objStatusTypes_data.strNSTStatusTypeName};
		String [] strStatusTypes2 ={objStatusTypes_data.strTSTStatusTypeName};
		
		objEventManagement1.clickOnNextButton()
				.verifySelectStatusTypesDisplayed()
				.enterStatusTypeInSearchField(objStatusTypes_data.strNSTStatusTypeName)
				.clickOnSearchButton()
				.verifyStatusTypesNameInSelectStausTypePage(strStatusTypes1)
				.enterStatusTypeInSearchField(objStatusTypes_data.strTSTStatusTypeName)
				.clickOnSearchButton()
				.verifyStatusTypesNameInSelectStausTypePage(strStatusTypes2);
		
		objLogin1.clickLogOut();
		
		 gstrResult = "PASS";	
	}
	
	/*************************************************************************************
	'Description 	: Verify that Status Type is retrieved when searched providing its 
					  name in Create New/Edit Event Template page. 
	'Precondition	: 
	'Date 			: 30-Dec-2014 
	'Author 		: Deepa
	'------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that Status Type is retrieved when searched providing its name in Create New/Edit Event Template page. ")
	public void testHappyDay151414() throws Exception {

		gstrTCID = "151414";
		gstrTO = "Verify that Status Type is retrieved when searched providing its name in Create New/Edit Event Template page. ";
		
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		Login_data objTest_data = new Login_data();
		
		Login objLogin = new Login(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		String strStatusTypeValues[] = new String[3];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion
				.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList()

		.createStatusType(objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);
		
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		objStatusTypeList.createNewStatus(objStatuTypes_data.strStatusNameInMulti,
				objStatuTypes_data.strStatusColor)
	.createNewStatus(objStatuTypes_data.strStatusNameInMulti1,objStatuTypes_data.strStatusColor)
	.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameInMulti)
	.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameInMulti1)
.clickOnReturnToStatusTypeList();
		
		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);
		
		// First resource type creation
		objResourceType.navigateToResourceTypePage()
				.createResourceType(objResourceType_data.strResourceTypeName,
						strStatusTypeValues);

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

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);
		
		objLogin.clickLogOut();
		
		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

	
		objSelectRegion1
				.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();
		
		objEventSetUp.navigateToEventSetUp();
		
		objEventSetUp
					.clickOncreateEventTemplate()
					.verifyTheFields()
					.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
					.enterEventTemplateDefintion(
							objEventSetUp_data.strTemplateDefinition)
					.selectResourceType(strResourceTypeValue[0])
					.searchStatusType(objStatuTypes_data.strTSTStatusTypeName);
		Thread.sleep(5000);
		
		System.out.println("hfjvg");
		
		objEventSetUp.selectStatusType(strStatusTypeValues[1])
					.clickSaveButton()
					.clickSaveButton()
				    .clickOnEditTempLink(objEventSetUp_data.strEventTemplate)
				    .searchStatusType(objStatuTypes_data.strMSTStatusTypeName);
		Thread.sleep(5000);
		objEventSetUp.selectStatusType(strStatusTypeValues[2])
				    .clickSaveButton();
		
		 gstrResult = "PASS";	
	}
	

	/*************************************************************************************
	'Description 	: Verify that Status Type is retrieved when searched providing its name in Edit Event (requires filtering by resource ids)page. 
	'Precondition	: 
	'Date 			: 31-Dec-2014 
	'Author 		: Anil
	'------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that Status Type is retrieved when searched providing its name in Edit Event (requires filtering by resource ids)page. ")
	public void testHappyDay151415() throws Exception {

		gstrTCID = "151415";
		gstrTO = "Verify that Status Type is retrieved when searched providing its name in Edit Event (requires filtering by resource ids)page. ";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		Resource_data objResource_data = new Resource_data();
		User_data objUserdata = new User_data();

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strNewStatusTypeValues[] = new String[2];
		
		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);
		
		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName2);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.verAndCreate15StatusTypes();
		
		String[] strStatusTypesNames = objStatusTypeList.getStatusTypeNames();
		
		String[] strStatusTypeValues = new String[strStatusTypesNames.length];
		for(int i = 0 ; i<strStatusTypesNames.length ; i++){
			strStatusTypeValues[i] = objStatusTypeList.getStatusValue(strStatusTypesNames[i]);
		}
		
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strNewStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strNewStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);
	
		Thread.sleep(5000);
		
		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		String[] strAllStatusVal = ArrayUtils.addAll(strNewStatusTypeValues, strStatusTypeValues);
		
		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strAllStatusVal);

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
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption().clickSaveButton();

		objEventSetUp.navigateToEventSetUp();

		objEventSetUp
				.createEventTemplate(objEventSetUp_data.strEventTemplate,
						objEventSetUp_data.strTemplateDefinition,
						strResourceTypeValue, strAllStatusVal)
				.deselectSelectAllWebOption()
				.verEveTemplateInList(objEventSetUp_data.strEventTemplate);

		objLogin.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
						objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objEventManagement1.navigateToEventManagement()
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue).clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);
		
		String [] strStatusTypes1 ={objStatusTypes_data.strNSTStatusTypeName};
		String [] strStatusTypes2 ={objStatusTypes_data.strTSTStatusTypeName};
		
		objEventManagement1
				.clickOnEditLink(objEvent_data.strEventName)
				.verifyEditEventScreenIsDisplayed()
				.verifySelectAllCheckBoxIsSelected()
				.enterStatusTypeNameInSearchField(objStatusTypes_data.strNSTStatusTypeName)
				.clickOnSearchButton()
				.verifyStatusTypesNameInSelectStausTypePage(strStatusTypes1)
				.enterStatusTypeNameInSearchField(objStatusTypes_data.strTSTStatusTypeName)
				.clickOnSearchButton()
		.verifyStatusTypesNameInSelectStausTypePage(strStatusTypes2);
		objLogin1.clickLogOut();
		
		 gstrResult = "PASS";	
	}

}
