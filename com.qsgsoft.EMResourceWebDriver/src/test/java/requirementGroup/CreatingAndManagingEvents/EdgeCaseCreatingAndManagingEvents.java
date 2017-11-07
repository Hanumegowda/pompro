package requirementGroup.CreatingAndManagingEvents;

//import javax.annotation.Resource;

import lib.dataObject.EventSetUp_data;
import lib.dataObject.Event_data;
import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.UpdateStatus_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.NavigationToSubMenus;
import lib.page.EventManagement;
import lib.page.EventSetUp;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Regions;
import lib.page.ResourceType;
import lib.page.Resource;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UpdateStatus;
import lib.page.UsersList;
import lib.page.ViewsList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class EdgeCaseCreatingAndManagingEvents extends TestNG_UI_EXTENSIONS{

	public EdgeCaseCreatingAndManagingEvents() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/***********************************************************************************
	'Description	:Verify that event details are not updated when clicked on 'Cancel'.
	'Date	 		:2-Dec-2014
	'Author			:Anil 
	************************************************************************************/
	
	@Test(description = "Verify that event details are not updated when clicked on 'Cancel'.")
	public void testEdgeCase150137() throws Exception {

		gstrTCID = "150137";
		gstrTO = "Verify that event details are not updated when clicked on 'Cancel'.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		EventManagement EventManagement_page = new EventManagement(this.driver1);

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
		
		.clickOnSaveButton()
	    
	    .verifyEventName(objEvent_data.strEventName)
	    
		.clickOnEditLink(objEvent_data.strEventName)
		
		.verifySaveButtonInTopOfEventManagementPage()
	    
	    .verifyCancelButtonInTopOfEventManagementPage()
	    
	    .verifySaveButtonInBottomOfEventManagementPage()
	    
	    .verifyCancelButtonInBottomOfEventManagementPage()
	    
	    .enterAdHocEventName(objEvent_data.strEditedEventName)
	    
		.enterAdHocEventDescription(objEvent_data.strEditedEventDescription)
		
		.clickOnCancelButton()
		
		.verifyEventManagementPage()
		
		.verifyEventName(objEvent_data.strEventName)
		
		.verifyEventInformation(objEvent_data.strEventName, objEvent_data.strEventDescription)
		
		.verifyEventNameInEventBanner(objEvent_data.strEventName);
	    
	    login_page.clickLogOut();
	    	    
	    gstrResult = "PASS";	
	}
	
	/*********************************************************************************
	'Description	: Verify that 'Save' and 'Cancel' buttons are not available at the 
	                  top and bottom of the Edit Event page of an 'Adhoc Event'.
	'Date	 		:2-Dec-2014
	'Author			:Anil 
	**********************************************************************************/
	
	@Test(description = " Verify that 'Save' and 'Cancel' buttons are not available at the "
			+ "top and bottom of the Edit Event page of an 'Adhoc Event'.")
	public void testEdgeCase150145() throws Exception {

		gstrTCID = "150145";
		gstrTO = " Verify that 'Save' and 'Cancel' buttons are not available at the top and"
				+ " bottom of the Edit Event page of an 'Adhoc Event'.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		EventManagement EventManagement_page = new EventManagement(this.driver1);

		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		Login login_page1 = new Login(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(this.driver1);

		System.out.println("-----Precondition execution starts-------");

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();

		UsersList_page.navigateToUsers()

		.clickCreateNewUserButton()

		.enterUserDetails(objUser_data.strNewUserName,
				objUser_data.strNewPassword, objUser_data.strFullName)

		.clickAdvancedOptionAndExpand()

		.selectMaintainEventsOption()
		
		.selectMaintainAdHocEventsOption()

		.clickSaveButton();
		
		System.out.println(objUser_data.strNewUserName);		

		login_page.clickLogOut();
		
	   System.out.println("-----Precondition ends and test execution starts-------");
	    
	    login_page1.loginAsNewUser(objUser_data.strNewUserName, objUser_data.strNewPassword);
	
	    RegionDefault_page1.selectFrame();
	
	    EventManagement_page1.navigateToEventManagement()    
	    
	    .clickOnCreateAdHocEventButton()
	    
	    .enterAdHocEventName(objEvent_data.strEventName)
		
		.enterAdHocEventDescription(objEvent_data.strEventDescription)
		
		.clickOnNextButton()
		
		.clickOnNextButton()
	     
	    .clickOnNextButton()
	     
	    .clickOnYesButton()
	    
	    .verifyEventName(objEvent_data.strEventName)
	    
		.clickOnEditLink(objEvent_data.strEventName)
		
		.verifyEditAdHocEventScreenIsDisplayed()
		
		.verifySaveAndCancelButtonsNotDisplayed()
		
		.clickOnCancelButton()
		
		.verifyEventManagementPage();
	    
	    login_page1.clickLogOut();
	    	    
	    gstrResult = "PASS";	
	}
	
	/*********************************************************************************
	'Description	: Verify that 'Save' and 'Cancel' buttons are not available at the
	                  top and bottom of the Edit Event page of a 'Multi Region' event.
	'Date	 		:2-Dec-2014
	'Author			:Anil 
	**********************************************************************************/
	
	@Test(description = "Verify that 'Save' and 'Cancel' buttons are not available at the"
			+ " top and bottom of the Edit Event page of a 'Multi Region' event.")
	public void testEdgeCase150146() throws Exception {

		gstrTCID = "150146";
		gstrTO = "Verify that 'Save' and 'Cancel' buttons are not available at the top and"
				+ " bottom of the Edit Event page of a 'Multi Region' event.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
		Regions objRegions_page = new Regions(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);
		
		String strRegionValue[] = new String[2];

		System.out.println("-----Precondition execution starts-------");

		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName1);

		RegionDefault_page.selectFrame();

		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions_page
				.getRegionValue(objTest_data.strRegionName1);

		System.out.println(strRegionValue[0]);

		strRegionValue[1] = objRegions_page
				.getRegionValue(objTest_data.strRegionName2);

		System.out.println(strRegionValue[1]);
		

		objEventSetUp.navigateToEventSetUp();
		
		objEventSetUp.clickOncreateEventTemplate();
		
		objEventSetUp.enterEventTemplateName(objEventSetUp_data.strEventTemplate);
		
		objEventSetUp.enterEventTemplateDefintion(objEventSetUp_data.strTemplateDefinition);
		
		objEventSetUp.selectMultiRegionOption();
		
		objEventSetUp.clickSaveButton();
		
		objEventSetUp.deselectSelectAllWebOption();
		
		//New user
		UsersList_page
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton();
		System.out.println(objUser_data.strNewUserName);
		
		UsersList_page	.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.clickRegionsLinkForUser(objUser_data.strNewUserName)
				.selectRegion(strRegionValue[1])
				.clickSaveButton();

		//Another Region
		
		SelectRegion_page
				.selectRegionAndNavigate(objTest_data.strRegionName2);
	     
		RegionDefault_page.selectFrame();
		
		objEventSetUp.navigateToEventSetUp();

        objEventSetUp.clickOncreateEventTemplate();
		
		objEventSetUp.enterEventTemplateName(objEventSetUp_data.strEventTemplate1);
		
		objEventSetUp.enterEventTemplateDefintion(objEventSetUp_data.strTemplateDefinition);
		
		objEventSetUp.selectMultiRegionOption();
		
		objEventSetUp.clickSaveButton();
		
		objEventSetUp.deselectSelectAllWebOption();
		
		//Multi region rights
				
		UsersList_page
		.navigateToUsers()
		.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName)				
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton()
				
				.editUserDetails(objUser_data.strNewUserName)
				.clickMultiRegionEventRights()
				.selectUserRegion(strRegionValue[0])
				.selectUserRegion(strRegionValue[1])
				.clickSaveButton()	
		        .clickSaveButton();		
		
		 login_page.clickLogOut();
	         
	   System.out.println("-----Precondition ends and test execution starts-------");
	    
	    login_page1.loginAsNewUser(objUser_data.strNewUserName, objUser_data.strNewPassword);
	
	    RegionDefault_page1.selectFrame();
	    	    
	    SelectRegion_page1.selectRegionAndNavigate(objTest_data.strRegionName1);
	    
	    RegionDefault_page1.selectFrame();
	    
	    EventManagement_page1.navigateToEventManagement()
	    
		.createNewMultiEventButton()
		
		.enterAdHocEventName(objEvent_data.strEventName)
		
		.enterAdHocEventDescription(objEvent_data.strEventDescription)
		
		.selectEventTemplateForMRE(strRegionValue[0],
						objEventSetUp_data.strEventTemplate)
		.selectEventTemplateForMRE(strRegionValue[1],
						objEventSetUp_data.strEventTemplate1)
		.clickOnNextButton()
	
		.clickOnYesButton()
		
		.clickOnEditLink(objEvent_data.strEventName)
		
		.verifySaveAndCancelButtonsNotDisplayedInMRE()
		
		.clickOnCancelButton();
			    
	    login_page1.clickLogOut();

	    gstrResult = "PASS";	
	}
	/*********************************************************************************
	'Description	:  	Verify that message stating ‘Check to show event in the colored event banner near top of page. 
	                    This option must be selected for events with no resources.’ Is displayed corresponding to the
	                    ‘Display in Event Banner?’ check box while creating an 'AdHoc' event. 
	'Date	 		:28-Jan-2015
	'Author			:Hanumegowda
	**********************************************************************************/
	@Test(description = "Verify that message stating ‘Check to show event in the colored event banner near top of page."
			+ " This option must be selected for events with no resources.’"
			+ " Is displayed corresponding to the ‘Display in Event Banner?’ check box while creating an 'AdHoc' event.")
	public void testEdgeCase152322() throws Exception {

		gstrTCID = "152322";
		gstrTO = "Verify that message stating ‘Check to show event in the colored event banner near top of page."
				+ " This option must be selected for events with no resources.’"
				+ " Is displayed corresponding to the ‘Display in Event Banner?’ check box while creating an 'AdHoc' event.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();

		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		Login login_page1 = new Login(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);

		UsersList UsersList_page1 = new UsersList(this.driver1);

		System.out.println("-----Precondition execution starts-------");

		login_page1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		RegionDefault_page1.selectFrame();

		UsersList_page1.navigateToUsers();

		UsersList_page1.clickCreateNewUserButton();

		UsersList_page1.enterUserDetails(objUser_data.strNewUserName,
				objUser_data.strNewPassword, objUser_data.strFullName);
		UsersList_page1.selectFirstRole();
		UsersList_page1.clickAdvancedOptionAndExpand();
		UsersList_page1.selectMaintainAdHocEventsOption();
		UsersList_page1.selectMaintainEventsOption();
		Thread.sleep(10000);
		UsersList_page1.clickSaveButton();
		
		System.out.println(objUser_data.strNewUserName);
		login_page1.clickLogOut();

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();
		EventManagement_page1.navigateToEventManagement()
				.clickOnCreateAdHocEventButton()
				.confirmCheckBoxOfDisplayInEventBannerMessage()
				.checkDisplyInEveBannerCheckBoxispresent().clickOnCancelButton();
		login_page1.clickLogOut();
		gstrResult = "PASS";
	}
	/*********************************************************************************
	'Description	:  	Verify that message stating ‘Check to show event in the colored event banner near top of page. 
	                    This option must be selected for events with no resources.’ Is displayed corresponding to the
	                    ‘Display in Event Banner?’ check box while creating an event. 
	'Date	 		:29-Jan-2015
	'Author			:Hanumegowda
	**********************************************************************************/
	@Test(description = "Verify that message stating ‘Check to show event in the colored event banner near top of page."
			+ " This option must be selected for events with no resources.’"
			+ " Is displayed corresponding to the ‘Display in Event Banner?’ check box while creating an event.")
	public void testEdgeCase152324() throws Exception {

		gstrTCID = "152324";
		gstrTO = "Verify that message stating ‘Check to show event in the colored event banner near top of page."
				+ " This option must be selected for events with no resources.’"
				+ " Is displayed corresponding to the ‘Display in Event Banner?’ check box while creating an event.";
		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		EventManagement EventManagement_page = new EventManagement(this.driver1);

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

		objEventSetUp.navigateToEventSetUp();
		String[] strstatusTypeValues = {};
		String[] strResourceTypeValue = {};

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strstatusTypeValues)
		
		.deselectSelectAllWebOption();		
		
	    login_page.clickLogOut();
	    
		    login_page1.loginAsNewUser(objUser_data.strNewUserName, objUser_data.strNewPassword);
		
		    RegionDefault_page1.selectFrame();
		
		    EventManagement_page1.navigateToEventManagement()  
		    .clickOnCreateNewEvent()
		    
		    .clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
		    
		    .enterAdHocEventName(objEvent_data.strEventName)
			
			.enterAdHocEventDescription(objEvent_data.strEventDescription)
			
			.confirmCheckBoxOfDisplayInEventBannerMessage()
			.checkDisplyInEveBannerCheckBoxispresent()
			.clickOnCancelButton();
		    login_page1.clickLogOut();
		    gstrResult = "PASS";

	}
	/*********************************************************************************
	'Description	:  	Verify that message stating ‘Check to show event in the colored event banner near top of page. 
	                    This option must be selected for events with no resources.’ Is displayed corresponding to the
	                    ‘Display in Event Banner?’ check box while creating an 'Multi region event'.
	'Date	 		:02-Feb-2015
	'Author			:Hanumegowda
	**********************************************************************************/

	@Test(description = "Verify that message stating ‘Check to show event in the colored event banner near top of page."
			+ " This option must be selected for events with no resources.’"
			+ " Is displayed corresponding to the ‘Display in Event Banner?’ check box while creating an 'Multi region event'.")
	public void testEdgeCase152323() throws Exception {

		gstrTCID = "152323";
		gstrTO = "Verify that message stating ‘Check to show event in the colored event banner near top of page."
				+ " This option must be selected for events with no resources.’"
				+ " Is displayed corresponding to the ‘Display in Event Banner?’ check box while creating an 'Multi region event'.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();

		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		Regions objRegions_page = new Regions(this.driver1);

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(
				this.driver1);

		System.out.println("-----Precondition execution starts-------");
		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName);

		RegionDefault_page.selectFrame();
		String strRegionValue[] = new String[2];

		objNavigationToSubmenus.navigateToRegions();

		strRegionValue[0] = objRegions_page
				.getRegionValue(objTest_data.strRegionName);

		System.out.println(strRegionValue[0]);

		strRegionValue[1] = objRegions_page
				.getRegionValue(objTest_data.strRegionName1);

		System.out.println(strRegionValue[1]);

		UsersList_page.navigateToUsersNew();

		UsersList_page.clickCreateNewUserButton();

		UsersList_page
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption().clickSaveButton();
		System.out.println(objUser_data.strNewUserName);
		UsersList_page
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.clickRegionsLinkForUser(objUser_data.strNewUserName)
				.selectRegion(strRegionValue[1]).clickSaveButton();
		Thread.sleep(10000);
		SelectRegion_page.selectRegionAndNavigate(objTest_data.strRegionName1);

		RegionDefault_page.selectFrame();
		UsersList_page
				.navigateToUsers()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
				.editUserDetails(objUser_data.strNewUserName).selectFirstRole()
				.clickAdvancedOptionAndExpand().selectMaintainEventsOption()
				.clickSaveButton().editUserDetails(objUser_data.strNewUserName)
				.clickMultiRegionEventRights()
				.selectUserRegion(strRegionValue[0])
				.selectUserRegion(strRegionValue[1]).clickSaveButton()
				.clickSaveButton();
		login_page.clickLogOut();
		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		RegionDefault_page1.selectFrame();
		Thread.sleep(10000);

		EventManagement_page1.navigateToEventManagement()
				.createNewMultiEventButton()

				.enterAdHocEventName(objEvent_data.strEventName)

				.enterAdHocEventDescription(objEvent_data.strEventDescription)

				.confirmCheckBoxOfDisplayInEventBannerMessage()
				.checkDisplyInEveBannerCheckBoxispresent()
				.clickOnCancelButton();
		login_page1.clickLogOut();
		gstrResult = "PASS";

	}
	
	/*********************************************************************************
	 * 'Description :Verify that updates done for event related status types are
	 *               cleared when the event ends.
	 *    'Date     :03-Feb-2015 
	 *   'Author    :Hanumegowda
	 **********************************************************************************/
	@Test(description = "Verify that updates done for event related status types are cleared when the event ends.")
	public void testEdgeCase152559() throws Exception {

		gstrTCID = "152559";
		gstrTO = "Verify that updates done for event related status types are cleared when the event ends.";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		Event_data objEvent_data = new Event_data();
		EventSetUp_data objESetUp_data = new EventSetUp_data();
		View_data objView_data = new View_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		String strstatusTypeValues[] = new String[6];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];
		String strStatusesValues[] = new String[1];
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Login objLogin1 = new Login(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);
		UpdateStatus_data objUpdateStatus_data = new UpdateStatus_data();

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();
		objNavigationToSubMenus.navigateToViews();
		objViewsList.clickOncustomizeResourceDetailView()
				.enterSectionName(objView_data.strSectionName)
				.clickOnCreateSection().clickOnSaveButton();

		objStatusTypeList.navigateToStatusTypeListNew();

		// RoleBased statustypes
		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strNumberStatusType,
				objStatusTypes_data.strNSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createEventStatusTypeWithSection(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithSection(
				objStatusTypes_data.strTextStatusType,
				objStatusTypes_data.strTSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strTSTStatusTypeName);

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
		
		objStatusTypeList.createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
				objStatusTypes_data.strStatusColor)
						.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti)
						.verCreatedStatusInStatusListForMulti(
				objStatusTypes_data.strStatusNameInMulti1)
				.clickOnReturnToStatusTypeList();

		objStatusTypeList.navigateToStatusTypeListNew();

		strstatusTypeValues[3] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.createEventStatusTypeWithSection(
				objStatusTypes_data.strSaturationScoreStatusType,
				objStatusTypes_data.strSSTStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[4] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.createEventStatusTypeWithSection(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName,
				objStatusTypes_data.strStatusDescription,
				objView_data.strSectionName);

		strstatusTypeValues[5] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName);
		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strstatusTypeValues);

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

		// User1 creation
		objUsersList
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand()
				.selectMaintainEventsOption()
				.clickSaveButton()
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strEquals);
		System.out.println(objUser_data.strNewUserName);
		
		objUsersList
		.clickCreateNewUserButton()
		.enterUserDetails(objUser_data.strNewUserName1,
				objUser_data.strNewPassword, objUser_data.strFullName1)
		.selectFirstRole()
		.selectUpdateStatusOfResource(objResource_data.strResourceName)
		.clickAdvancedOptionAndExpand()
		.selectMaintainEventsOption()
		.clickSaveButton();
		
		// create Event template
		objEventSetUp.navigateToEventSetUp();

		objEventSetUp.createEventTemplate(objESetUp_data.strEventTemplate,
				objESetUp_data.strTemplateDefinition, strResourceTypeValue,
				strstatusTypeValues);
		objEventSetUp.deselectSelectAllWebOption();

		objLogin.clickLogOut();
		
		System.out.println("templet " + objESetUp_data.strEventTemplate);

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		RegionDefault_page1.selectFrame();
		
		objEventManagement1.navigateToEventManagement()
		.clickOnCreateNewEvent()
		.clickOnCreateEvent(objESetUp_data.strEventTemplate)
		.enterAdHocEventName(objEvent_data.strEventName)
		.enterAdHocEventDescription(objEvent_data.strEventDescription)
		.selectResource(strResourceValue[0]).clickOnSaveButton();
		objEventManagement1.verifyEventName(objEvent_data.strEventName);
		
		objEventManagement1.clickOnEventNameInEventBanner(
				objEvent_data.strEventName).clickOnUpdateStatusKey(
				objResource_data.strResourceName);
		objUpdateStatus1
				.clickOnSelectAll()
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[0],
						objUpdateStatus_data.strNSTUpdateValue)
				.enterNSTAndTSTUpdateValue(strstatusTypeValues[2],
						objUpdateStatus_data.strNSTUpdateValue)
				.enterNedocsUpdateValue(strstatusTypeValues[1],
						objUpdateStatus_data.strNDSTUpdateValue)
				.enterUpdateSSTValues(strstatusTypeValues[4],
						objUpdateStatus_data.strSSTUpdateValue)
				.selectMSTUpdateValue(strstatusTypeValues[3],
						strStatusesValues[0])

				.clickOnSaveButton();

		objLogin1.clickLogOut();
		
		objLogin.loginAsNewUser(objUser_data.strNewUserName1,
				objUser_data.strNewPassword);
		
		objRegionDefault.selectFrame();
		
		objEventManagement.navigateToEventManagement().clickOnEndEvent(
				objEvent_data.strEventName)
	
				.clickOnCreateNewEvent()
				.clickOnCreateEvent(objESetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName1)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResourceValue[0]).clickOnSaveButton();
		objLogin.clickLogOut();
		
		objLogin1.loginToApplication(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		RegionDefault_page1.selectFrame();
		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName1);
		objUpdateStatus1
				.verifyUpdatedStatusValues1(strResourceValue[0],
						strstatusTypeValues[1])
				.verifyUpdatedStatusValues1(strResourceValue[0],
						strstatusTypeValues[4])
				.verifyUpdatedStatusValues1(strResourceValue[0],
						strstatusTypeValues[5]);
		objLogin1.clickLogOut();
		gstrResult = "PASS";

	}
}


