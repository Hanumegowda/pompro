package lib.module;


import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import java.util.concurrent.TimeUnit;
import lib.page.StatusTypeList;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import qaframework.lib.WaitTimeConstants;
import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;

public class NavigationToSubMenus extends PageObject{
	
	WebDriver driver;
	WaitForElement objWaitForElement ;
	
	private String setUpLink 	= "Setup",
			   usersText 		= "Users",
			   regionalInfo 	= "Regional Info",
			   preferences 		= "Preferences",
			   userInfo 		= "User Info",
			   createNewUserButton = "input[value='Create New User']",
			   searchInputField = "tblUsers_SEARCH_TEXT",
			   updateUserInfo 	= "//div[@id='topSubNav']/h1[text()='Update User Info']",
			   userInRegionalInfo = "Users",
			   interfacesInSetUp = "Interfaces",
			   createNewInterface = "//input[@value='Create New Interface']",
			   regionsText 		= "Regions",
			   createNewRegion = "input[value='Create New Region']",
			   views = "Views",
			   customizeResourceDetailView = "input[value='Customize Resource Detail View']",
			   statusTypes     	= "//td/a[text()='Status Types']",
			   resourceTypes	= "Resource Types",
			   resources		= "//div[@id='mainContainer']/table/tbody/tr/td/a[text()='Resources']",
			   createNewStatusTypes = "input[value='Create New Status Type']",
			   createNewResourceTypes = "input[value='Create New Resource Type']",
			   createNewResources 	= "input[value='Create New Resource']",
			   viewMainMenu = "View",
			   map = "//table[@summary='Menu Options']/tbody/tr/td/a[text()='Map']",
			   custom = "Custom",
			   rolesText = "Roles",
			   createNewRoleBtn = "input[value='Create New Role']",
			   eventLink = "//a[@href='/EMSystem?uc=GENERAL&nextStep=menuItemList&nextStepDetail=EVENT'][text()='Event']",
			   reportMenu = "Report",
			   statusReport = "Status Reports",
			   calendar = "Calendar",
			   documentLibraryInRegionalInfo = "Document Library",
			   eventReports = "Event Reports",
			   viewTab = "//a[@class='mainLink selected'][text()='View']",
			   resourceReports = "Resource Reports",
			   statusReasons = "Status Reasons",
			   statusChangePrefereces = "Status Change Prefs",
			   uploadLink = "Upload",
			   otherRegions = "Other Regions",
			   changePassword = "Change Password",
			   systemNotification = "System Notification",
			   appSwitcher = "//div[@id='header-selectApplication']/span[text()='EMResource']",
			   linkMyAccounts = "Link My Accounts",
			   conFigureFormsunderForm="Configure Forms",
			   form  = "Form",
			   eventMenu = "//h1[text()='Event Menu']",
			   snoozeLink = "#TB_closeWindowButton",
			   eventNotification = "Event Notification",
			   formActivation = "Activate Form",
			   formSecurity = "Form Security",
			   otherRegionText    = "//div[@id='mainContainer']/table/tbody/tr/td/a[text()='Other Regions']",
			   shareStausTypes = "input[value='Share Status Types']",
			   formReport = "Form Reports",
			   adminReport = "Admin Reports",
			   formList = "//table/tbody/tr/td/a[text()='Form List']",
			   regionDefault = "//table[@summary='Menu Options']/tbody/tr/td/a[text()='Region Default (my default)']",
			   incomingPatientNotifications = "Incoming Patient Notifications",
			   sendIncomingpatientNotification="Send Incoming Patient Notification",
			   securityQuestion = "//td/a[text()='Security Question']",
			   applicationUsageReports=  "Application Usage Reports",
			   adminReports="Admin Reports",
			   custumizedViewOfPref = "Customized View",
			   imTab = "IM",
			   menuOptions = "//table[@summary='Menu Options']/tbody/tr",
			   eventList="Event List",
			   incomingPatients="Incoming Patients",
			   haveBed= "HAvBED",
			  viewsLink = "//td/a[text()='Views']",
			   reports = "//a[text()='Report']",
			   createNewIncomingPatientNotifnbutton = "//input[@class='emsButtonText']" ,
			   incomingPatientNotificationsInLast24HoursPg = "//div[@id='topSubNav']/h1[text()='Incoming Patient Notifications In Last 24 Hours']",
			   setUpLink1 = "//a[@class='mainLink selected'][text()='Setup']",
			   strUlink="//table[@class='displayTable striped border sortable']/tbody/tr[6]/td[1]";
			
			   

		

	public NavigationToSubMenus(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
	}
	
	/**********************************************************************************
	* Description 	: This function is to navigate to 'Users' 
	* Date 			: 30/07/2014
	* Author 		: Renushree
	**********************************************************************************/
	public NavigationToSubMenus clickOnSetUp() throws Exception {
		objWaitForElement.waitForElements(setUpLink, "linktext");
		this.page.element(setUpLink, "linktext").clickUsingJSE();
		Thread.sleep(3000);
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to click on 'Regional Info' 
	* Date 			: 30/07/2014
	* Author 		: Renushree
	**********************************************************************************/
	public NavigationToSubMenus clickOnRegionalInfo() throws Exception {
		objWaitForElement.waitForElements(regionalInfo, "linktext");
		this.page.element(regionalInfo, "linktext").clickUsingJSE();
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to click on 'Preferences' 
	* Date 			: 30/07/2014
	* Author 		: Renushree
	**********************************************************************************/
	public NavigationToSubMenus clickOnPreferences() throws Exception {
		objWaitForElement.waitForElements(preferences, "linktext");
		this.page.element(preferences, "linktext").clickUsingJSE();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to navigate to 'Users' 
	* Date 		  : 30/07/2014
	* Author 	  : Rensuhree
	**********************************************************************************/
	public NavigationToSubMenus navigateToUsers() throws Exception {
		this.clickOnSetUp();
		objWaitForElement.waitForElements(usersText, "linktext");
		this.page.element(usersText, "linktext").mouseOver();
		this.page.element(usersText, "linktext").clickUsingJSE();
		/*if(this.page.element(usersText, "linktext").isElementPresent()==true){
			this.page.element(usersText, "linktext").getOne().sendKeys(Keys.ENTER);
		}*/
		objWaitForElement.waitForElements(createNewUserButton, "css");
		return this;
	}
	
	/**********************************************************************************
	* Description  	: This function is to navigate to 'Users' in 'Regional Info'
	* Date 			: 30/07/2014
	* Author 		: Rensuhree
	**********************************************************************************/
	public NavigationToSubMenus navigateToUsersInRegionalInfo()
			throws Exception {
		this.clickOnRegionalInfo();
		objWaitForElement.waitForElements(userInRegionalInfo, "linktext");
		this.page.element(userInRegionalInfo, "linktext").clickUsingJSE();
		objWaitForElement.waitForElements(searchInputField, "id");
		return this;
	}
	
	/**********************************************************************************
	* Description  	: This function is to navigate to 'UsersInfo' in 'Preferences'
	* Date 			: 30/07/2014
	* Author 		: Rensuhree
	**********************************************************************************/
	public NavigationToSubMenus navigateToUsersInfoInPreferences()
			throws Exception {
		this.clickOnPreferences();
		objWaitForElement.waitForElements(userInfo, "linktext");
		this.page.element(userInfo, "linktext").getOne().click();
		objWaitForElement.waitForElements(updateUserInfo, "xpath");
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to navigate to 'Interface' 
	* Date 		  : 04/08/2014
	* Author 	  : Rensuhree
	**********************************************************************************/
	public NavigationToSubMenus navigateToInterfaces() throws Exception {
		this.clickOnSetUp();
		objWaitForElement.waitForElements(interfacesInSetUp, "linktext");
		this.page.element(interfacesInSetUp, "linktext").clickUsingJSE();
		objWaitForElement.waitForElements(createNewInterface, "xpath");
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to navigate to 'Regions' 
	* Date 		  : 04/08/2014
	* Author 	  : Anil
	**********************************************************************************/
	public NavigationToSubMenus navigateToRegions() throws Exception {
		this.clickOnSetUp();
		objWaitForElement.waitForElements(regionsText, "linktext");
		this.page.element(regionsText, "linktext").clickUsingJSE();
		objWaitForElement.waitForElements(createNewRegion, "css");
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to navigate to 'Users' 
	* Date 		  : 30/07/2014
	* Author 	  : Rensuhree
	**********************************************************************************/
	public NavigationToSubMenus navigateToViews() throws Exception {
		this.clickOnSetUp();
		objWaitForElement.waitForElements(views, "linktext");
		this.page.element(views, "linktext").clickUsingJSE();
		objWaitForElement.waitForElements(customizeResourceDetailView, "css");
		this.page.element(customizeResourceDetailView, "css").isElementPresent();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to navigate to 'Status Types' in setup 
	* Date 		  : 06/08/2014
	* Author 	  : Renushree
	**********************************************************************************/
	public NavigationToSubMenus navigateToStatusTypesInSetup() throws Exception {
		this.clickOnSetUp();
		objWaitForElement.waitForElements(statusTypes, "xpath");
		this.page.element(statusTypes, "xpath").clickUsingJSE();
		objWaitForElement.waitForElements(createNewStatusTypes, "css");
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to navigate to 'Resource Types' in setup 
	* Date 		  : 06/08/2014
	* Author 	  : Renushree
	**********************************************************************************/
	public NavigationToSubMenus navigateToResourceTypesInSetup() throws Exception {
		this.clickOnSetUp();
		objWaitForElement.waitForElements(resourceTypes, "linktext");
		this.page.element(resourceTypes, "linktext").clickUsingJSE();
		objWaitForElement.waitForElements(createNewResourceTypes, "css");
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to navigate to 'Resource' in setup 
	* Date 		  : 06/08/2014
	* Author 	  : Renushree
	**********************************************************************************/
	public NavigationToSubMenus navigateToResourceInSetup() throws Exception {
		this.clickOnSetUp();
		objWaitForElement.waitForElements(resources, "xpath");
		this.page.element(resources, "xpath").clickUsingJSE();
		objWaitForElement.waitForElements(createNewResources, "css");
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to click on 'Views' 
	* Date 			: 30/07/2014
	* Author 		: Renushree
	**********************************************************************************/
	public NavigationToSubMenus clickOnViews() throws Exception {
		objWaitForElement.waitForElements(views, "linktext");
		this.page.element(views, "linktext").clickUsingJSE();
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to click on 'Views' 
	* Date 			: 30/07/2014
	* Author 		: Renushree
	**********************************************************************************/
	public NavigationToSubMenus clickOnViewMenu() throws Exception {
		objWaitForElement.waitForElements(viewMainMenu, "linktext");
		this.page.element(viewMainMenu, "linktext").clickUsingJSE();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to navigate to 'View' under view menu
	* Arguments	  : strViewName
	* Date 		  : 06/08/2014
	* Author 	  : Renushree
	**********************************************************************************/
	public NavigationToSubMenus navigateToParticularViewUnderViewMenu(String strViewName) throws Exception {
		this.clickOnViewMenu();
		objWaitForElement.waitForElements("//table/tbody/tr/td/a[text()='"+strViewName+"']", "xpath");
		this.page.element("//table/tbody/tr/td/a[text()='"+strViewName+"']", "xpath").mouseOver();
		this.page.element("//table/tbody/tr/td/a[text()='"+strViewName+"']", "xpath").getOne().sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to navigate to 'Map' under view menu
	* Date 		  : 11/08/2014
	* Author 	  : Renushree
	**********************************************************************************/
	public NavigationToSubMenus navigateToMap() throws Exception {
		this.clickOnViewMenu();
		objWaitForElement.waitForElements(map, "xpath");
		WebElement element = driver.findElement(By.xpath(map));
		this.page.element(map, "xpath").scrollDownTillElement(element);
		this.page.element(map, "xpath").mouseOver();
		this.page.element(map, "xpath").getOne().sendKeys(Keys.ENTER);
		Thread.sleep(10000);
		return this;
	}

	/**********************************************************************************
	* Description : This function is to navigate to 'Custom' under view menu
	* Date 		  : 12/08/2014
	* Author 	  : Renushree
	**********************************************************************************/
	public NavigationToSubMenus navigateToCustomInView() throws Exception {
		this.clickOnViewMenu();
		objWaitForElement.waitForElements("//table/tbody/tr/td/a[text()='Custom']", "xpath");
		this.page.element("//table/tbody/tr/td/a[text()='Custom']", "xpath").mouseOver();
		this.page.element("//table/tbody/tr/td/a[text()='Custom']", "xpath").getOne().sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to navigate to 'Roles' 
	* Date 		  : 13/08/2014
	* Author 	  : Sowmya
	**********************************************************************************/
	public NavigationToSubMenus navigateToRoles() throws Exception {
		this.clickOnSetUp();
		objWaitForElement.waitForElements(rolesText, "linktext");
		this.page.element(rolesText, "linktext").clickUsingJSE();
		objWaitForElement.waitForElements(createNewRoleBtn, "css");
		this.page.element(createNewRoleBtn, "css").isElementPresent();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to navigate to 'Custom' under view menu
	* Date 		  : 12/08/2014
	* Author 	  : Renushree
	**********************************************************************************/
	public NavigationToSubMenus navigateToEventMenu() throws Exception {
		objWaitForElement.waitForElements(eventLink, "xpath");
		this.page.element(eventLink, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to click on 'Status report' 
	* Date 			: 09/09/2014
	* Author 		: sowmya
	**********************************************************************************/
	public NavigationToSubMenus clickOnStatusReports() throws Exception {
		objWaitForElement.waitForElements(reportMenu, "linktext");
		this.page.element(reportMenu, "linktext").getOne().click();
		objWaitForElement.waitForElements(statusReport, "linktext");
		this.page.element(statusReport, "linktext").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description  	: This function is to navigate to 'Calendar' in 'Regional Info'
	* Date 			: 10/09/2014
	* Author 		: Rensuhree
	**********************************************************************************/
	public NavigationToSubMenus navigateToCalendarInRegionalInfo()
			throws Exception {
		this.clickOnRegionalInfo();
		objWaitForElement.waitForElements(calendar, "linktext");
		this.page.element(calendar, "linktext").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description  	: This function is to navigate to 'Document Library' in 'Regional Info'
	* Date 			: 10/09/2014
	* Author 		: Sinchana
	**********************************************************************************/
	public NavigationToSubMenus navigateToDocumentLibraryInRegionalInfo()
			throws Exception {
		this.clickOnRegionalInfo();
		objWaitForElement.waitForElements(documentLibraryInRegionalInfo, "linktext");
		this.page.element(documentLibraryInRegionalInfo, "linktext").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to click on 'Status report' 
	* Date 			: 09/09/2014
	* Author 		: sowmya
	**********************************************************************************/
	public NavigationToSubMenus clickOnResourceReports() throws Exception {
		objWaitForElement.waitForElements(reports, "xpath");
		this.page.element(reports, "xpath").getOne().click();
		objWaitForElement.waitForElements(resourceReports, "linktext");
		this.page.element(resourceReports, "linktext").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to click on 'Event report' 
	* Date 			: 11/09/2014
	* Author 		: Renushree
	**********************************************************************************/
	public NavigationToSubMenus navigateToEventReports() throws Exception {
		objWaitForElement.waitForElements(reportMenu, "linktext");
		this.page.element(reportMenu, "linktext").getOne().click();
		objWaitForElement.waitForElements(eventReports, "linktext");
		this.page.element(eventReports, "linktext").getOne().click();
		return this;
	}
	/**********************************************************************************
	* Description 	: This function is to click on 'Views' 
	* Date 			: 11/09/2014
	* Author 		: Anitha
	**********************************************************************************/
	public NavigationToSubMenus clickOnViewMenuNew() throws Exception {
		objWaitForElement.waitForElements(viewTab, "xpath");
		this.page.element(viewTab, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to navigate to 'Map' under view menu
	* Date 		  : 11/09/2014
	* Author 	  : Anil
	**********************************************************************************/
	public NavigationToSubMenus navigateToMapNew() throws Exception {
		this.clickOnViewMenuNew();
		objWaitForElement.waitForElements(map, "xpath");
		this.page.element(map, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to navigate to 'StatusReasons' 
	* Date 		  : 15/09/2014
	* Author 	  : Rensuhree
	**********************************************************************************/
	public NavigationToSubMenus navigateToStatusReasons() throws Exception {
		this.clickOnSetUp();
		objWaitForElement.waitForElements(statusReasons, "linktext");
		this.page.element(statusReasons, "linktext").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description  	: This function is to navigate to 'Statsu change prefernce' in 'Preferences'
	* Date 			: 23/09/2014
	* Author 		: Rensuhree
	**********************************************************************************/
	public NavigationToSubMenus navigateStatusChangeInPreferences()
			throws Exception {
		this.clickOnPreferences();
		objWaitForElement.waitForElements(statusChangePrefereces, "linktext");
		this.page.element(statusChangePrefereces, "linktext").getOne().sendKeys(Keys.ENTER);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to navigate to 'Users'
	  * Date        : 09/06/2014
	  * Author      : Anil
	  **********************************************************************************/
	public StatusTypeList navigateToUpload() throws Exception {
		this.clickOnSetUp();
		objWaitForElement.waitForElements(uploadLink, "linktext");
		this.page.element(uploadLink, "linktext").getOne().click();
		return new StatusTypeList(this.driver);
	}
	
	/**********************************************************************************
	  * Description : This function is to navigate to Region under other regions menu
	  * Date        : 07/10/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public NavigationToSubMenus navigateToRegUnderOtherRegions(String strRegionName) throws Exception {
		objWaitForElement.waitForElements(otherRegions, "linktext");
		this.page.element(otherRegions, "linktext").getOne().click();
		objWaitForElement.waitForElements(strRegionName, "linktext");
		this.page.element(strRegionName, "linktext").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description  	: This function is to navigate to 'Change Password' in 'Preferences'
	* Date 			: 30/07/2014
	* Author 		: Rensuhree
	**********************************************************************************/
	public NavigationToSubMenus navigateToChangePasswordInPreferences()
			throws Exception {
		this.clickOnPreferences();
		objWaitForElement.waitForElements(changePassword, "linktext");
		this.page.element(changePassword, "linktext").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description  	: This function is to navigate to 'System Notification' in 'Preferences'
	* Date 			: 30/07/2014
	* Author 		: Rensuhree
	**********************************************************************************/
	public NavigationToSubMenus navigateToSystemNotificationInPreferences()
			throws Exception {
		this.clickOnPreferences();
		objWaitForElement.waitForElements(systemNotification, "linktext");
		this.page.element(systemNotification, "linktext").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'App switcher'
	* Date 		  : 15/10/2014
	* Author 	  : Sowmya
	**********************************************************************************/
	public NavigationToSubMenus clickOnAppSwitcher() throws Exception {
		objWaitForElement.waitForElements(appSwitcher, "xpath");
		this.page.element(appSwitcher, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description  	: This function is to click on 'Link My Accounts' in 'App Switcher'
	* Date 			: 15/10/2014
	* Author 		: Sowmya
	**********************************************************************************/
	public NavigationToSubMenus navigateToLinkMyAccounts()
			throws Exception {
		this.clickOnAppSwitcher();
		objWaitForElement.waitForElements(linkMyAccounts, "linktext");
		this.page.element(linkMyAccounts, "linktext").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description  	: This function is to click on 'Link My Accounts' in 'App Switcher'
	* Date 			: 15/10/2014
	* Author 		: Sowmya
	**********************************************************************************/
	public NavigationToSubMenus selectProductUnderAppSwitcher(String strProdName)
			throws Exception {
		this.clickOnAppSwitcher();
		objWaitForElement.waitForElements(strProdName, "linktext");
		this.page.element(strProdName, "linktext").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify link name in App Switcher
	* Date 		  : 15/10/2014
	* Author 	  : Sowmya
	**********************************************************************************/
	public NavigationToSubMenus verifyLinkNameInAppSwitch(String strLinkName)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='header-selectApplication-menu']/a[text()='"
				+ strLinkName + "']", "xpath");
		assertTrue(this.page
				.element(
						"//div[@id='header-selectApplication-menu']/a[text()='"
								+ strLinkName + "']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click 'Link name' in App switcher
	* Date 		  : 15/10/2014
	* Author 	  : Sowmya
	**********************************************************************************/
	public NavigationToSubMenus clickLinkNameInAppSwitch(String strLinkName)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='header-selectApplication-menu']/a[text()='"
				+ strLinkName + "']", "xpath");
		this.page
				.element(
						"//div[@id='header-selectApplication-menu']/a[text()='"
								+ strLinkName + "']", "xpath").getOne().click();
		this.driver
				.manage()
				.timeouts()
				.implicitlyWait(WaitTimeConstants.WAIT_TIME_LONG,
						TimeUnit.SECONDS);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on configure Form under Form
	* Date 		  : 15/10/2014
	* Author 	  : sangappa.k
	**********************************************************************************/
	public NavigationToSubMenus clickOnConfigureForm() throws Exception {
		this.navigateToFormMenu();
		objWaitForElement.waitForElements(conFigureFormsunderForm, "linktext");
		this.page.element(conFigureFormsunderForm, "linktext").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to navigate to Form menu
	* Date 		  : 15/10/2014
	* Author 	  : sangappa.k
	**********************************************************************************/
	public NavigationToSubMenus navigateToFormMenu() throws Exception {
		objWaitForElement.waitForElements(form, "linktext");
		this.page.element(form, "linktext").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description  	: This function is to verify event menu page is displayed
	* Date 			: 22/10/2014
	* Author 		: Anil
	**********************************************************************************/
	public NavigationToSubMenus verifyEventMenuPage()
			throws Exception {
		objWaitForElement.waitForElements(eventMenu, "xpath");
		assertTrue(this.page.element(eventMenu, "xpath").isElementPresent());
		return this;
	}
	/**********************************************************************************
	* Description : This function is to navigate to 'View' under view menu
	* Arguments	  : strViewName
	* Date 		  : 06/08/2014
	* Author 	  : Renushree
	**********************************************************************************/
	public NavigationToSubMenus navigateToUserView(String strViewName)
			throws Exception {
		this.clickOnViewMenu();
		objWaitForElement.waitForElements("//table[@summary='Menu Options']/tbody/tr/td/a[text()='"
				+ strViewName + "']", "xpath");
		assertTrue(this.page.element(
				"//table[@summary='Menu Options']/tbody/tr/td/a[text()='"
						+ strViewName + "']", "xpath").isElementPresent());
		this.page
				.element(
						"//table[@summary='Menu Options']/tbody/tr/td/a[text()='"
								+ strViewName + "']", "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to click on snooze link
	 * 					displayed 
	 * Date 		: 26/11/2014 
	 * Author 		: Anil
	 **********************************************************************************/
	public NavigationToSubMenus clickOnSnooze()
			throws Exception {
		objWaitForElement.waitForElements(snoozeLink, "css");
		this.page.element(snoozeLink, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to click on 'Report' 
	* Date 			: 26/11/2014 
	* Author 		: Anil
	**********************************************************************************/
	public NavigationToSubMenus clickOnReports() throws Exception {
		objWaitForElement.waitForElements(reportMenu, "linktext");
		this.page.element(reportMenu, "linktext").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to click on 'Resource reports' 
	* Date 			: 26/11/2014 
	* Author 		: Anil
	**********************************************************************************/
	public NavigationToSubMenus clickOnResourceReportsLink() throws Exception {		
		objWaitForElement.waitForElements(resourceReports, "linktext");
		this.page.element(resourceReports, "linktext").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description  	: This function is to navigate to 'Event Prefernces' in 'Preferences'
	* Date 			: 12/12/2014
	* Author 		: Rensuhree
	**********************************************************************************/
	public NavigationToSubMenus navigateToEventNotificationInPreferences()
			throws Exception {
		this.clickOnPreferences();
		objWaitForElement.waitForElements(eventNotification, "linktext");
		this.page.element(eventNotification, "linktext").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to navigate to form activation page
	* Date 		  : 15/12/2014
	* Author 	  : Renushree
	**********************************************************************************/
	public NavigationToSubMenus navigateToActivateForm() throws Exception {
		this.navigateToFormMenu();
		objWaitForElement.waitForElements(formActivation, "linktext");
		this.page.element(formActivation, "linktext").getOne().click();
		return this;
	}
	
	/**********************************************************************************
     * Description : This function is to navigate to form security page
     * Date        : 15/12/2014
     * Author      : Pallavi
     **********************************************************************************/
     public NavigationToSubMenus navigateToFormSecurityPage() throws Exception {
            this.navigateToFormMenu();
    		objWaitForElement.waitForElements(formSecurity, "linktext");
            this.page.element(formSecurity, "linktext").getOne().click();
            return this;
     }
     /**********************************************************************************
 	* Description : This function is to navigate to 'Users' 
 	* Date 		  : 30/07/2014
 	* Author 	  : Rensuhree
 	**********************************************************************************/
 	public NavigationToSubMenus navigateToOtherRegions() throws Exception {
 		this.clickOnSetUp();
 		objWaitForElement.waitForElements(otherRegionText, "xpath");
 		this.page.element(otherRegionText, "xpath").clickUsingJSE();
 		objWaitForElement.waitForElements(shareStausTypes, "css");
 		return this;
 	}

     /**********************************************************************************
 	* Description : This function is to navigate to form report page
 	* Date 		  : 05/01/2015
 	* Author 	  : Renushree
 	**********************************************************************************/
 	public NavigationToSubMenus navigateToFormReport() throws Exception {
 		objWaitForElement.waitForElements(reportMenu, "linktext");
 		this.page.element(reportMenu, "linktext").getOne().click();
 		objWaitForElement.waitForElements(formReport, "linktext");
		this.page.element(formReport, "linktext").getOne().click();
 		return this;
 	}
 	
 	/**********************************************************************************
 	 * Description  : This function is to click on 'Admin report' 
 	 * Date    : 09/09/2014
 	 * Author   : Anitha
 	 **********************************************************************************/
 	 public NavigationToSubMenus clickOnAdminReports() throws Exception {
 		objWaitForElement.waitForElements(reportMenu, "linktext");
 	  this.page.element(reportMenu, "linktext").getOne().click();
 	 objWaitForElement.waitForElements(adminReport, "linktext");
 	  this.page.element(adminReport, "linktext").getOne().click();
 	  return this;
 	 }
 	 
 	/**********************************************************************************
   	* Description : This function is to navigate to form list page
   	* Date 		  : 14/01/2015
   	* Author 	  : Renushree
   	**********************************************************************************/
   	public NavigationToSubMenus navigateToFormList() throws Exception {
   		this.navigateToFormMenu();
		objWaitForElement.waitForElements(formList, "xpath");
  		this.page.element(formList, "xpath").getOne().click();
   		return this;
   	}
   	
   	/**********************************************************************************
   	* Description : This function is to navigate to form list page
   	* Date 		  : 14/01/2015
   	* Author 	  : Renushree
   	**********************************************************************************/
   	public NavigationToSubMenus clickOnFormList() throws Exception {
		objWaitForElement.waitForElements(formList, "xpath");
  		this.page.element(formList, "xpath").getOne().click();
   		return this;
   	}
   	
   	/**********************************************************************************
	* Description : This function is to navigate to 'Region default' under view menu
	* Date 		  : 12/02/2015
	* Author 	  : Renushree
	**********************************************************************************/
	public NavigationToSubMenus navigateToRegDefault() throws Exception {
		this.clickOnViewMenu();
		objWaitForElement.waitForElements(regionDefault, "xpath");
		this.page.element(regionDefault, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to click on 'Report' 
	* Date 			: 26/11/2014 
	* Author 		: Anil
	**********************************************************************************/
	public NavigationToSubMenus verifyReportsIsNotDisplayed() throws Exception {
		assertFalse(this.page.element(reportMenu, "linktext").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to navigate to Incoming Patient Notifications page
	* Date 		  : 11/03/2015
	* Author 	  : Sowmya
	**********************************************************************************/
	public NavigationToSubMenus navigateToIncomingPatientNotifications()
			throws Exception {
		this.navigateToFormMenu();
		objWaitForElement.waitForElements(incomingPatientNotifications, "linktext");
		this.page.element(incomingPatientNotifications, "linktext").getOne()
				.click();
		return this;
	}
	
	/**********************************************************************************
	* Description  	: This function is to navigate to 'Security Question' in 'Preferences'
	* Date 			: 24-Apr-2015
	* Author 		: Pallavi
	**********************************************************************************/
	public NavigationToSubMenus navigateToSecurityQuestionsInPreferences()
			throws Exception {
		this.clickOnPreferences();
		objWaitForElement.waitForElements("//div[@id='topSubNav']/h1[text()='Preferences Menu']",
				"xpath");
		assertTrue(this.page
				.element(
						"//div[@id='topSubNav']/h1[text()='Preferences Menu']",
						"xpath").isElementPresent());
		objWaitForElement.waitForElements(securityQuestion, "xpath");
		this.page.element(securityQuestion, "xpath").getOne().click();
		return this;
	}
	/**********************************************************************************
	* Description 	: This function is to navigate to Application Usage Reports under Reports
	* Date 			: 26/11/2014 
	* Author 		: Sangappa.k
	**********************************************************************************/
	public NavigationToSubMenus navigateToApplicationUsageReports()
			throws Exception {
		this.clickOnReports();
		objWaitForElement.waitForElements(applicationUsageReports, "linktext");
		assertTrue(this.page.element(applicationUsageReports, "linktext")
				.isElementPresent());
		this.page.element(applicationUsageReports, "linktext").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to navigate to 'Map' under view menu
	* Date 		  : 11/09/2014
	* Author 	  : Anitha
	**********************************************************************************/
	public NavigationToSubMenus navigateToMapPage() throws Exception {
		this.clickOnViewMenuNew();
		objWaitForElement.waitForElements(map, "xpath");
		this.page.element(map, "xpath").mouseOver();
		this.page.element(map, "xpath").getOne().sendKeys(Keys.ENTER);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to navigate to 'Customized View' under Preferences View
	* Date 		  : 03-Jun-2015
	* Author 	  : Pallavi
	**********************************************************************************/
	public NavigationToSubMenus navigateToCustomizedViewInPrefrences()
			throws Exception {
		this.clickOnPreferences();
		objWaitForElement.waitForElements(custumizedViewOfPref, "linktext");
		this.page.element(custumizedViewOfPref, "linktext").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to click on 'Instant Message' tab. 
	* Date 			: 04-Jun-2015
	* Author 		: Hanumegowda
	**********************************************************************************/
	public NavigationToSubMenus clickOnIM() throws Exception {
		objWaitForElement.waitForElements(imTab, "linktext");
		this.page.element(imTab, "linktext").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to verify setup tab is not displayed.
	* Date 			: 05-Jun-2015
	* Author 		: Hanumegowda
	**********************************************************************************/
	public NavigationToSubMenus verSetUpTabIsNotDisplayed() throws Exception {
		assertFalse(this.page.element(setUpLink, "linktext").isElementPresent(
				WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify that only Users link is displayed under 'Setup' 
	* Date 		  : 08-Jun-2015
	* Author 	  : Pallavi
	**********************************************************************************/
	public NavigationToSubMenus verifyOnlyUsersIsDispUnderSetup()
			throws Exception {
		this.clickOnSetUp();
		objWaitForElement.waitForElements(menuOptions, "xpath");
		int intCount = this.page.element(menuOptions, "xpath").getXpathCount();
		assertTrue(this.page.element(menuOptions + "/td/a", "xpath").getOne()
				.getText().equals(usersText));
		assertTrue(intCount == 1);
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to verify setup tab is displayed.
	* Date 			: 10-Jun-2015
	* Author 		: Renushree
	**********************************************************************************/
	public NavigationToSubMenus verSetUpTabIsDisplayed() throws Exception {
		objWaitForElement.waitForElements(setUpLink, "linktext");
		assertTrue(this.page.element(setUpLink, "linktext").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to verify Configure your personal status view is not displayeds
	* Date 			: 15/Jun/2015
	* Author 		: Renushree
	**********************************************************************************/
	public NavigationToSubMenus verCustumizedViewOfPrefNotDisplayed() throws Exception {
		assertFalse(
				this.page.element(custumizedViewOfPref, "linktext").isElementPresent(
						WaitTimeConstants.WAIT_TIME_FOR_FALSE),
				"Add to custom view button displayed.");
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to verify custom is not displayeds
	* Date 			: 15/Jun/2015
	* Author 		: Renushree
	**********************************************************************************/
	public NavigationToSubMenus verCustomNotDisplayed() throws Exception {
		assertFalse(
				this.page.element(custom, "linktext").isElementPresent(
						WaitTimeConstants.WAIT_TIME_FOR_FALSE),
				"Custom is displayed.");
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to mouse hover on 'Preferences' 
	* Date 			: 15/Jun/2015
	* Author 		: Renushree
	**********************************************************************************/
	public NavigationToSubMenus mouseHoverOnPreferences() throws Exception {
		objWaitForElement.waitForElements(preferences, "linktext");
		this.page.element(preferences, "linktext").mouseOver();
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to mouse hover on 'View' 
	* Date 			: 15/Jun/2015
	* Author 		: Renushree
	**********************************************************************************/
	public NavigationToSubMenus mouseHoverOnViewMenu() throws Exception {
		objWaitForElement.waitForElements(viewMainMenu, "linktext");
		this.page.element(viewMainMenu, "linktext").mouseOver();
		return this;
	}
	/**********************************************************************************
	* Description 	: This function is to navigate to Admin reports under reports
	* Date 			: 19/Jun/2015
	* Author 		: Sangappa.k
	**********************************************************************************/
	public NavigationToSubMenus navigateToAdminReports()
			throws Exception {
		this.clickOnReports();
		objWaitForElement.waitForElements(adminReports, "linktext");
		assertTrue(this.page.element(adminReports, "linktext")
				.isElementPresent());
		this.page.element(adminReports, "linktext").getOne().click();
		return this;
	}	
	
	/**********************************************************************************
	* Description 	: This function is to navigate to Admin reports under reports
	* Date 			: 19/Jun/2015
	* Author 		: Sangappa.k
	**********************************************************************************/
	public NavigationToSubMenus verAdminReportsNotExistUnderReports()
			throws Exception {
		this.clickOnReports();
		objWaitForElement.waitForElements(adminReports, "linktext");
		assertFalse(this.page.element(adminReports, "linktext")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		
		return this;
	}		
	
	/**********************************************************************************
	* Description 	: This function is to navigate to Admin reports under reports
	* Date 			: 19/Jun/2015
	* Author 		: Sangappa.k
	**********************************************************************************/
	public NavigationToSubMenus navigateToEventList()
			throws Exception {
		this.navigateToEventMenu(); 
		this.page.element(eventList, "linktext").getOne().click();
		return this;
	}		
	/**********************************************************************************
	* Description 	: This function is to click on Admin reports 
	* Date 			: 8/July/2015
	* Author 		: Sangappa.k
	**********************************************************************************/
	public NavigationToSubMenus clickOnActivateForms()
			throws Exception {
		this.navigateToEventMenu(); 
		this.page.element(eventList, "linktext").getOne().click();
		return this;
	}				
	
	/**********************************************************************************
	* Description : This function is to verify configure form is not displayed
	* Date 		  : 15/10/2014
	* Author 	  : Anil
	**********************************************************************************/
	public NavigationToSubMenus verifyConfigureFormIsNotDisplayed() throws Exception {
		assertFalse(this.page.element(conFigureFormsunderForm, "linktext").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify configure form is not displayed
	* Date 		  : 15/10/2014
	* Author 	  : Anitha
	**********************************************************************************/
	public int getXpathCount() throws Exception {
		objWaitForElement.waitForElements(
				"//div[@id='mainContainer']/table/tbody/tr[@class='odd']",
				"xpath");
		int intCount = this.page.element(
				"//div[@id='mainContainer']/table/tbody/tr[@class='odd']",
				"xpath").getXpathCount();
		System.out.println(intCount);

		return intCount;
	}
	/**********************************************************************************
	* Description : This function is to navigate to 'Incoming pation' in setup 
	* Date 		  : 23/07/2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public NavigationToSubMenus navigateToIncomingPationt() throws Exception {
		this.clickOnSetUp();
		objWaitForElement.waitForElements(incomingPatients, "linktext");
		this.page.element(incomingPatients, "linktext").getOne().click();
		return this;
	}
	/**********************************************************************************
	* Description : This function is to navigate to Add Incoming Patient Notification
	* Date 		  : 11/03/2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public NavigationToSubMenus navigateToSendIncomingPatientNotifications()
			throws Exception {
		this.navigateToFormMenu();
		objWaitForElement.waitForElements(sendIncomingpatientNotification, "linktext");
		this.page.element(sendIncomingpatientNotification, "linktext").getOne()
				.click();
		return this;
	}	
	
	/**********************************************************************************
	* Description 	: This function is to verify Upload sub menu is not displayed.
	* Date 			: 05-Jul-2015
	* Author 		: Deepa
	**********************************************************************************/
	public NavigationToSubMenus verUploadSubMenuIsNotDisplayed() throws Exception {
		assertFalse(this.page.element(uploadLink, "linktext").isElementPresent(
				WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	/**********************************************************************************
	* Description : This function is to navigate to 'Resource' in setup 
	* Date 		  : 06/08/2014
	* Author 	  : Renushree
	**********************************************************************************/
	public NavigationToSubMenus navigateToHaveBedInSetup() throws Exception {
		this.clickOnSetUp();
		objWaitForElement.waitForElements(haveBed, "linktext");
		this.page.element(haveBed, "linktext").getOne().click();
		return this;
	}

	
	/**********************************************************************************
	* Description : This function is to navigate to Form menu
	* Date 		  : 15/10/2014
	* Author 	  : sangappa.k
	**********************************************************************************/
	public NavigationToSubMenus navigateToFormListNew() throws Exception {
		objWaitForElement.waitForElements("//a[text()='Form']", "xpath");
		this.page.element("//a[text()='Form']", "xpath").mouseOver();
		this.page.element("//a[text()='Form']", "xpath").getOne().click();
		objWaitForElement.waitForElements(formList, "xpath");
  		this.page.element(formList, "xpath").getOne().click();
		return this;
	}	
	
	
	/**********************************************************************************
	* Description 	: This function is to verify 'Create new incoming patient notification' button is not available.
	* Date 			: 09-sep-2015
	* Author 		: Sandhya M B
	**********************************************************************************/
	public NavigationToSubMenus verCreateNewIncomingPatientNotifnbuttonIsNotDisplayed() throws Exception {
		assertFalse(this.page.element(createNewIncomingPatientNotifnbutton, "xpath").isElementPresent(
				WaitTimeConstants.WAIT_TIME_FOR_FALSE));
				return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to verify IPN details are available under 
	*                 'Incoming Patient Notifications In Last 24 Hours' page 
	* Date 			: 09-sep-2015
	* Author 		: Sandhya M B
	**********************************************************************************/
	public NavigationToSubMenus verIPNDetails()	throws Exception {
		assertTrue(this.page.element(incomingPatientNotificationsInLast24HoursPg, "xpath")
				.isElementPresent());
		return this;


      }
	
	/**********************************************************************************
	 * Description : This function is to verify view submenu is not present Date
	 * : 21/12/2015 Author : Renushree
	 **********************************************************************************/
	public NavigationToSubMenus verViewSubMenuNotPresent() throws Exception {
		assertFalse(this.page.element(viewsLink, "xpath").isElementPresent(
				WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify view submenu is present Date :
	 * 21/12/2015 Author : Renushree
	 **********************************************************************************/
	public NavigationToSubMenus verViewSubMenuPresent() throws Exception {
		this.clickOnSetUp();
		assertTrue(this.page.element(viewsLink, "xpath").isElementPresent());
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to verify view  submenu is not present
	  * Date        : 21/12/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public NavigationToSubMenus verResourceSubMenuNotPresent() throws Exception {
		assertFalse(this.page.element(resources, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	/**********************************************************************************
	* Description : This function is to navigate to 'Roles' 
	* Date 		  : 13/08/2014
	* Author 	  : Sowmya
	**********************************************************************************/
	public NavigationToSubMenus navigateToRolesNew() throws Exception {
		this.clickOnSetUp1();
		objWaitForElement.waitForElements(rolesText, "linktext");
		this.page.element(rolesText, "linktext").getOne().click();
		objWaitForElement.waitForElements(createNewRoleBtn, "css");
		this.page.element(createNewRoleBtn, "css").isElementPresent();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to navigate to 'setup'
	 * Date        : 09/06/2014
	 * Author      : Anil
	 **********************************************************************************/
	public NavigationToSubMenus clickOnSetUp1() throws Exception {
		objWaitForElement.waitForElements(setUpLink1, "xpath");
		this.page.element(setUpLink1, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to verify custom is not displayeds
	* Date 			: 15/Jun/2015
	* Author 		: Renushree
	**********************************************************************************/
	public NavigationToSubMenus verCustomIsDisplayed() throws Exception {
		objWaitForElement.waitForElements(custom, "linktext");
		assertTrue(this.page.element(custom, "linktext").isElementPresent(),
				"Custom is Not displayed.");
		return this;
	}
	/**********************************************************************************
	* Description 	: This function is to click on 'Instant Message' tab. 
	* Date 			: 04-Jun-2015
	* Author 		: Anitha
	**********************************************************************************/
	public NavigationToSubMenus clickOnIMTab() throws Exception {
		objWaitForElement
				.waitForElements(
						"//div[@class='mainNavigation subNav']/a[text()='IM']",
						"xpath");
		this.page
				.element(
						"//div[@class='mainNavigation subNav']/a[text()='IM']",
						"xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to navigate to 'Incoming pation' in setup 
	* Date 		  : 2/Feb/2016
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public NavigationToSubMenus verIncomingPationtOption() throws Exception {
		
		objWaitForElement.waitForElements(incomingPatients, "linktext");
		assertTrue(this.page.element(incomingPatients, "linktext").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to navigate to Add Incoming Patient Notification &
	*                Incmonig patient Notification section under Form
	* Date 		  : 2/Feb/2016
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public NavigationToSubMenus verIncmoingPatientNotificationSectionUnderForm()
			throws Exception {
		
		objWaitForElement.waitForElements(sendIncomingpatientNotification, "linktext");
		assertTrue(this.page.element(sendIncomingpatientNotification, "linktext").isElementPresent());
		assertTrue(this.page.element(incomingPatientNotifications, "linktext").isElementPresent());
		return this;
	}	
	
	/**********************************************************************************
	* Description : This function is to navigate to Add Incoming Patient Notification &
	*                Incmonig patient Notification section under Form
	* Date 		  : 2/Feb/2016
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public NavigationToSubMenus verIncmoingPatientNotificationSectionNotUnderForm()
			throws Exception {

		objWaitForElement.waitForElements(sendIncomingpatientNotification,
				"linktext");
		assertFalse(this.page.element(sendIncomingpatientNotification,
				"linktext").isElementPresent(
				WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		assertFalse(this.page.element(incomingPatientNotifications, "linktext")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to navigate  'User Link' in setup 
	* Date 		  : 08/02/2016
	* Author 	  : Sangappa K
	**********************************************************************************/
	public NavigationToSubMenus navigateToUserLinkInSetUpInIE() throws Exception {
		this.clickOnSetUp();
		objWaitForElement.waitForElements(strUlink, "xpath");
		this.page.element(strUlink, "xpath").mouseOver();
		this.page.element(strUlink, "xpath").getOne().sendKeys(Keys.SHIFT);
		this.page.element(strUlink, "xpath").getOne().sendKeys(Keys.SPACE);
		return this;
	}	

}
