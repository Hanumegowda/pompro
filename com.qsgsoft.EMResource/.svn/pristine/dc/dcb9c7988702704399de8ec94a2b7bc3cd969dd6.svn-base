package EMR.pages;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import qaFramework.WaitTimeConstants;
import qaFramework.UserDefinedFunctions.WaitForElement;
import qaFramework.pageObject.PageObject;
import EMR.Locators.Shared.Locators;
import EMR.Locators.Views;

public class Shared extends PageObject{

	WebDriver driver;
	WaitForElement waitForElement ;

	public Shared(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		waitForElement = new WaitForElement(this.driver);
	}

	public Shared clickOnSetUp() throws Exception {
		waitForElement.waitForElements(Locators.SETUPLINK, "linktext");
		this.page.element(Locators.SETUPLINK, "linktext").clickUsingJSE();
		try{
			this.page.element(Locators.SETUPLINK, "linktext").getDisplayedOne().click();
			waitForElement.waitForElements(Locators.SETUPMENU_PAGE,"xpath");
			if (this.page.element(Locators.SETUPMENU_PAGE,"xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL) == false) {
				this.page.element(Locators.SETUPLINK, "linktext").clickUsingJSE();
				waitForElement.waitForElements(Locators.SETUPMENU_PAGE,"xpath" );
			}
			if(this.page.element(EMR.Locators.Shared.Locators.SETUPMENU_PAGE, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL)==false) {
				this.page.element(Locators.SETUPLINK, "linktext").getOne().sendKeys(Keys.ENTER);
			}
			waitForElement.waitForElements(Locators.SETUPMENU_PAGE,"xpath");
			assertTrue(this.page.element(EMR.Locators.Shared.Locators.SETUPMENU_PAGE, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL));
		} catch(Exception e) { }
		assertTrue(this.page.element(EMR.Locators.Shared.Locators.SETUPMENU_PAGE, "xpath").isElementPresent());
		return this;
	}
	
	public Shared clickOnAppSwitcher() throws Exception {
		waitForElement.waitForElements(Locators.APPSWITCHER, "xpath");
		Actions actions = new Actions(driver);
		WebElement appSwither= driver.findElement(By.xpath(Locators.APPSWITCHER));
		actions.clickAndHold(appSwither);
		this.page.element(Locators.APPSWITCHER, "xpath").getOne().click();
		return this;
	}

	public Shared selectProductUnderAppSwitcher(String prodName)
			throws Exception {
		this.clickOnAppSwitcher();
		waitForElement.waitForElements(prodName, "linktext");
		this.page.element(prodName, "linktext").getOne().click();
		return this;
	}

	public Shared users() throws Exception {
		this.clickOnSetUp();
		waitForElement.waitForElements(Locators.USERSTEXT, "xpath");		
		try{
			this.page.element(Locators.USERSTEXT, "xpath").getOne().click();
			waitForElement.waitForElements(Locators.USERSLIST_PAGE, "xpath");
			if (this.page.element(Locators.USERSLIST_PAGE, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE) == false) {
				this.page.element(Locators.USERSTEXT, "xpath").clickUsingJSE();
			}
		} catch(Exception e) {

		}
		return this;			
	}

	public Shared clickOnEvents() throws Exception {
		waitForElement.waitForElements(Locators.EVENTLINK, "xpath");
		this.page.element(Locators.EVENTLINK, "xpath").clickUsingJSE();
		try{
			if (this.page.element(Locators.EVENTMENU_PAGE, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL) == false) {
				this.page.element(Locators.EVENTLINK, "xpath").getOne().click();
				waitForElement.waitForElements(Locators.EVENTMENU_PAGE,"xpath");
			}
			if(this.page.element(EMR.Locators.Shared.Locators.EVENTMENU_PAGE, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL)==false) {
				this.page.element(Locators.EVENTLINK, "xpath").getOne().sendKeys(Keys.ENTER);
			}
			waitForElement.waitForElements(Locators.EVENTMENU_PAGE,"xpath");
			assertTrue(this.page.element(EMR.Locators.Shared.Locators.EVENTMENU_PAGE, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL));
		} catch(Exception e) {

		}
		return this;
	}

	public Shared clickOnEventManagment() throws Exception {
		waitForElement.waitForElements(Locators.EVENTMANAGEMENT, "xpath");
		this.page.element(Locators.EVENTMANAGEMENT, "xpath").clickUsingJSE();
		try{
			this.page.element(Locators.EVENTMANAGEMENT, "xpath").clickUsingJSE();

			if (this.page.element(Locators.EVENTMANAGEMENT_PAGE, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL) == false) {
				this.page.element(Locators.EVENTMANAGEMENT, "xpath").getOne().click();
				waitForElement.waitForElements(Locators.EVENTMANAGEMENT_PAGE,"xpath" );
			}
			if(this.page.element(EMR.Locators.Shared.Locators.EVENTMANAGEMENT_PAGE, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL)==false) {
				this.page.element(Locators.EVENTMANAGEMENT, "xpath").getOne().sendKeys(Keys.ENTER);
			}
			waitForElement.waitForElements(Locators.EVENTMANAGEMENT_PAGE,"xpath" );
			assertTrue(this.page.element(EMR.Locators.Shared.Locators.EVENTMANAGEMENT_PAGE, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL));
		} catch(Exception e) {

		}
		return this;
	}

	public Shared eventManagment() throws Exception {
		this.clickOnEvents();
		this.clickOnEventManagment();
		return this;
	}

	public Shared statusTypes() throws Exception {
		this.clickOnSetUp();
		waitForElement.waitForElements(Locators.STATUSTYPES, "xpath");
		this.page.element(Locators.STATUSTYPES, "xpath").getOne().click();
		return this;
	}

	public Shared resourceType() throws Exception {
		this.clickOnSetUp();
		waitForElement.waitForElements(Locators.RESOURCETYPES, "xpath");
		this.page.element(Locators.RESOURCETYPES, "xpath").getDisplayedOne().click();
		try{
			if(!this.page.element(EMR.Locators.ResourceTypes.Locators.RESOURCE_TYPE_LIST_PAGE, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE)) {
				this.page.element(Locators.RESOURCETYPES, "xpath").clickUsingJSE();
			}
		} catch (Exception e) { }
		assertTrue(this.page.element(EMR.Locators.ResourceTypes.Locators.RESOURCE_TYPE_LIST_PAGE, "xpath").isElementPresent(), "'Resource Type List' page is not displayed.");
		return this;
	}

	public Shared resources() throws Exception {
		this.clickOnSetUp();
		waitForElement.waitForElements(Locators.RESOURCES, "xpath");
		this.page.element(Locators.RESOURCES, "xpath").getOne().click();
		return this;
	}

	public Shared clickOnEventSetUp() throws Exception {
		waitForElement.waitForElements(Locators.EVENTSETUP, "xpath");
		this.page.element(Locators.EVENTSETUP, "xpath").getOne().click();
		return this;
	}

	public Shared eventSetUp() throws Exception {
		this.clickOnEvents();
		this.clickOnEventSetUp();
		return this;
	}

	public Shared views() throws Exception {
		this.clickOnSetUp();
		waitForElement.waitForElements(Locators.VIEWS, "xpath");
		this.page.element(Locators.VIEWS, "xpath").getDisplayedOne().click();
		return this;
	}

	public Shared clickOnView() throws Exception {
		waitForElement.waitForElements(Locators.VIEW, "xpath");
		this.page.element(Locators.VIEW, "xpath").clickUsingJSE();
		try{
			if(!this.page.element(Locators.VIEW_MENU, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE)){
				this.page.element(Locators.VIEW, "xpath").getDisplayedOne().click();
			}
			if(!this.page.element(Locators.VIEW_MENU, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE)){
				this.page.element(Locators.VIEW, "xpath").getDisplayedOne().sendKeys(Keys.ENTER);
			}
		}catch(Exception e) {
			this.page.element(Locators.VIEW, "xpath").clickUsingJSE();
		}
		waitForElement.waitForElements(Locators.VIEW_MENU, "xpath");
		assertTrue(this.page.element(Locators.VIEW_MENU, "xpath").isElementPresent(), "view list page is not displayed.");
		return this;
	}

	public Shared regionDefault() throws Exception {
		this.clickOnView();
		waitForElement.waitForElements(Locators.REGIONDEFAULT, "xpath");
		this.page.element(Locators.REGIONDEFAULT, "xpath").getOne().click();
		return this;
	}

	public Shared regions() throws Exception {
		this.clickOnSetUp();
		waitForElement.waitForElements(Locators.REGIONS, "linktext");
		this.page.element(Locators.REGIONS, "linktext").getOne().click();
		return this;
	}

	public Shared roles() throws Exception {
		this.clickOnSetUp();
		waitForElement.waitForElements(Locators.ROLES, "linktext");
		this.page.element(Locators.ROLES, "linktext").getDisplayedOne().click();
		return this;
	}

	public Shared otherRegion() throws Exception {
		this.clickOnSetUp();
		waitForElement.waitForElements(Locators.OTHERREGION, "xpath");
		this.page.element(Locators.OTHERREGION, "xpath").clickUsingJSE();
		return this;
	}

	public Shared configureForm() throws Exception {
		this.formMenu();
		try{
			waitForElement.waitForElements(Locators.CONFIGUREFORMS, "linktext");
			this.page.element(Locators.CONFIGUREFORMS, "linktext").getOne().click();
			waitForElement.waitForElements(Locators.FORM_CONFIGURATION_PAGE, "xpath");
			if(this.page.element(Locators.FORM_CONFIGURATION_PAGE, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE)==false){
				this.page.element(Locators.CONFIGUREFORMS, "linktext").getOne().sendKeys(Keys.ENTER);
				waitForElement.waitForElements(Locators.FORM_CONFIGURATION_PAGE, "xpath");
			}
			if(this.page.element(Locators.FORM_CONFIGURATION_PAGE, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE)==false){
				this.page.element(Locators.CONFIGUREFORMS, "linktext").clickUsingJSE();
				waitForElement.waitForElements(Locators.FORM_CONFIGURATION_PAGE, "xpath");
			}
		} catch(Exception e) {

		}
		return this;
	}

	public Shared formMenu() throws Exception {
		try{
			waitForElement.waitForElements(Locators.FORM, "linktext");
			this.page.element(Locators.FORM, "linktext").getOne().click();
			waitForElement.waitForElements(Locators.FORM_MENU_PAGE, "xpath");
			if(this.page.element(Locators.FORM_MENU_PAGE, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE)==false){
				this.page.element(Locators.FORM, "linktext").getOne().sendKeys(Keys.ENTER);
				waitForElement.waitForElements(Locators.FORM_MENU_PAGE, "xpath");
			}
			if(this.page.element(Locators.FORM_MENU_PAGE, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE)==false){
				this.page.element(Locators.FORM, "linktext").clickUsingJSE();
				waitForElement.waitForElements(Locators.FORM_MENU_PAGE, "xpath");
			}
		} catch(Exception e) {

		}
		return this;
	}

	public Shared activateForms() throws Exception {
		this.formMenu();
		waitForElement.waitForElements(Locators.ACTIVATEFORMS, "linktext");
		this.page.element(Locators.ACTIVATEFORMS, "linktext").getOne().click();
		return this;
	}

	public Shared particularView(String _view) throws Exception {
		this.clickOnView();
		try{
			waitForElement.waitForElements(Locators.PARTICULAR_VIEW_PART1+_view+ Locators.CLOSING_BRACKETS, "xpath");
			this.page.element(Locators.PARTICULAR_VIEW_PART1+_view+ Locators.CLOSING_BRACKETS, "xpath").mouseOver();
			this.page.element(Locators.PARTICULAR_VIEW_PART1+_view+ Locators.CLOSING_BRACKETS, "xpath").getOne().click();
		} catch (Exception e) {
			waitForElement.waitForElements(Locators.PARTICULAR_VIEW_PART1+_view+ Locators.CLOSING_BRACKETS, "xpath");
			this.page.element(Locators.PARTICULAR_VIEW_PART1+_view+ Locators.CLOSING_BRACKETS, "xpath").mouseOver();
			this.page.element(Locators.PARTICULAR_VIEW_PART1+_view+ Locators.CLOSING_BRACKETS, "xpath").clickUsingJSE();
		}
		return this;
	}

	public Shared map() throws Exception {
		this.clickOnView();
		try{
			this.page.element(Locators.MAP, "xpath").getOne().click();
			if(!this.page.element(Locators.MAP_PAGE, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE)){
				this.page.element(Locators.MAP, "xpath").getDisplayedOne().sendKeys(Keys.ENTER);
			}
			if(!this.page.element(Locators.MAP_PAGE, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE)){
				this.page.element(Locators.MAP, "xpath").clickUsingJSE();
			}
		} catch(Exception e) {
			this.page.element(Locators.MAP, "xpath").clickUsingJSE();
		}
		waitForElement.waitForElements(Locators.MAP_PAGE, "xpath");
		assertTrue(this.page.element(Locators.MAP_PAGE, "xpath").isElementPresent());
		return this;
	}

	public Shared userLinks() throws Exception {
		this.clickOnSetUp();
		waitForElement.waitForElements(Locators.USERLINKS, "xpath");
		try{
			this.page.element(Locators.USERLINKS, "xpath").getOne().click();
			waitForElement.waitForElements(Locators.USER_LINKS_LIST_PAGE, "xpath");
			if (this.page.element(Locators.USER_LINKS_LIST_PAGE, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL) == false) {
				this.page.element(Locators.USERLINKS, "xpath").clickUsingJSE();
				waitForElement.waitForElements(Locators.USER_LINKS_LIST_PAGE,"xpath" );
			}
			if(this.page.element(EMR.Locators.Shared.Locators.USER_LINKS_LIST_PAGE, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL)==false) {
				this.page.element(Locators.USERLINKS, "xpath").getOne().sendKeys(Keys.ENTER);
				waitForElement.waitForElements(Locators.USER_LINKS_LIST_PAGE,"xpath" );
			}
			assertTrue(this.page.element(Locators.USER_LINKS_LIST_PAGE, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL));
		} catch(Exception e) {
		}	
		return this;
	}

	public String getApplicationTimeWithCSTCDT() throws Exception {
		waitForElement.waitForElements(Locators.APPLICATIONTIME, "xpath");
		String strApplicationTime = this.page.element(Locators.APPLICATIONTIME, "xpath")
				.getOne().getText();
		return strApplicationTime;
	}

	public Shared incomingPatient() throws Exception {
		this.clickOnSetUp();
		waitForElement.waitForElements(Locators.INCOMINGPATIENT, "linktext");
		this.page.element(Locators.INCOMINGPATIENT, "linktext").getOne().click();
		return this;
	}

	public Shared clickOnPreferences() throws Exception {
		waitForElement.waitForElements(Locators.PREFERENCES_LINK, "xpath");
		this.page.element(Locators.PREFERENCES_LINK, "xpath").clickUsingJSE();
		try{
			this.page.element(Locators.PREFERENCES_LINK, "xpath").getDisplayedOne().click();
			waitForElement.waitForElements(Locators.PREFERENCES_MENU_PAGE,"xpath" );

			if (this.page.element(Locators.PREFERENCES_MENU_PAGE,"xpath" ).isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL) == false) {
				this.page.element(Locators.PREFERENCES_LINK, "xpath").clickUsingJSE();
				waitForElement.waitForElements(Locators.PREFERENCES_MENU_PAGE,"xpath" );
			}
			if(this.page.element(EMR.Locators.Shared.Locators.PREFERENCES_MENU_PAGE, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL)==false) {
				this.page.element(Locators.PREFERENCES_LINK, "xpath").getDisplayedOne().sendKeys(Keys.ENTER);
				waitForElement.waitForElements(Locators.PREFERENCES_MENU_PAGE,"xpath" );
			}
			assertTrue(this.page.element(EMR.Locators.Shared.Locators.PREFERENCES_MENU_PAGE, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL));
		} catch(Exception e) {
			assertTrue(this.page.element(EMR.Locators.Shared.Locators.PREFERENCES_MENU_PAGE, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL));
		}

		return this;
	}

	public Shared UserInfoUnderPreferences() throws Exception {
		this.clickOnPreferences();
		waitForElement.waitForElements(Locators.USER_INFO, "xpath");
		this.page.element(Locators.USER_INFO, "xpath").getOne().click();
		return this;
	}

	public Shared clickOnHomeButton() throws Exception {
		waitForElement.waitForElements(Locators.HOME, "xpath");
		this.page.element(Locators.HOME, "xpath").getOne().sendKeys(Keys.ENTER);

		return this;
	}

	public Shared clickOnOtherRegions() throws Exception {
		waitForElement.waitForElements(Locators.OTHER_REGIONS_LINK, "xpath");
		this.page.element(Locators.OTHER_REGIONS_LINK, "xpath").clickUsingJSE();
		return this;
	}

	public Shared regionUnderOtherRegion(String regionName) throws Exception {
		this.clickOnOtherRegions();
		waitForElement.waitForElements(Locators.PARTICULAR_VIEW_PART1 + regionName + Locators.CLOSING_BRACKETS, "xpath");
		assertTrue(this.page.element(regionName,"linktext").isElementPresent());
		this.page.element(Locators.PARTICULAR_VIEW_PART1 + regionName + Locators.CLOSING_BRACKETS, "xpath").getDisplayedOne().click();
		return this;
	}

	public Shared viewUnderSetup() throws Exception {
		this.clickOnSetUp();
		waitForElement.waitForElements(Locators.VIEWS_UNDER_SETUP, "xpath");
		this.page.element(Locators.VIEWS_UNDER_SETUP, "xpath").getDisplayedOne().click();
		if(this.page.element(Locators.REGION_VIEWS_LIST_PAGE, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE)==false) {
			this.page.element(Locators.VIEWS_UNDER_SETUP, "xpath").clickUsingJSE();
		}
		return this;
	}

	public Shared interfaces() throws Exception {
		this.clickOnSetUp();
		waitForElement.waitForElements(Locators.INTERFACES, "xpath");		
		try{
			this.page.element(Locators.INTERFACES, "xpath").getOne().click();
			waitForElement.waitForElements(Locators.INTERFACELIST_PAGE, "xpath");
			if (this.page.element(Locators.INTERFACELIST_PAGE, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL) == false) {
				this.page.element(Locators.INTERFACES, "xpath").getOne().sendKeys(Keys.ENTER);
			}
		} catch(Exception e) {

		}
		if (this.page.element(Locators.INTERFACELIST_PAGE, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE) == false) {
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", this.page.element(Locators.INTERFACES, "xpath").getOne());
		}
		return this;		
	}

	public Shared clickOnCustomUnderView() throws Exception {
		waitForElement.waitForElements(Locators.CUSTOM_VIEW, "xpath");
		this.page.element(Locators.CUSTOM_VIEW, "xpath").clickUsingJSE();
		try{
			if (this.page.element(Locators.CUSTOM_VIEW_TABLE_PAGE, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE) == false) 
			{
				this.page.element(Locators.CUSTOM_VIEW, "xpath").getDisplayedOne().sendKeys(Keys.ENTER);
				waitForElement.waitForElements(Locators.CUSTOM_VIEW_TABLE_PAGE, "xpath");
			}
			
		}catch(Exception e){}
		assertTrue(this.page.element(Locators.CUSTOM_VIEW_TABLE_PAGE, "xpath").isElementPresent());
		return this;
	}

	public Shared customView() throws Exception {
		this.clickOnView();
		this.clickOnCustomUnderView();
		return this;
	}

	public Shared selectFrame() throws Exception {
		Thread.sleep(8000);
		this.driver.switchTo().defaultContent();
		try{
			waitForElement.waitForElements(Locators.FRAME_DATA, "xpath");
			WebDriverWait wait = new WebDriverWait(this.driver, WaitTimeConstants.COUNT);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(Locators.FRAME));
			System.out.println("switched");
		} catch (Exception e) {
			if(this.page.element(Locators.FRAME_DATA, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL)){
				this.driver.switchTo().frame(Locators.FRAME);
				System.out.println("switched in catch block");
			}
		}
		//waitForElement.waitForElements(EMR.Locators.Login.Locators.LOGOUT, "xpath");
		//	assertTrue(this.page.element(EMR.Locators.Login.Locators.LOGOUT, "xpath").isElementPresent());
		//		System.out.println("verified logout button");
		return this;
	}

	public String getApplicationTime() throws Exception {
		waitForElement.waitForElements(Locators.APPLICATIONTIME, "xpath");
		String time = this.page.element(Locators.APPLICATIONTIME, "xpath").getOne()
				.getText();
		String applicationTime = time.replace(" CDT", "");
		applicationTime = applicationTime.replace(" CST", "");
		return applicationTime;
	}

	public Shared naviagteToSendIncomingPatientNotification() throws Exception {
		formMenu();
		waitForElement.waitForElements(Locators.SEND_INCOMING_PATIENT_NOTIFICATION, "linktext");
		this.page.element(Locators.SEND_INCOMING_PATIENT_NOTIFICATION, "linktext").clickUsingJSE();
		return this;
	}

	public Shared clickOnReport() throws Exception {
		waitForElement.waitForElements(Locators.REPORT, "linktext");
		this.page.element(Locators.REPORT, "linktext").clickUsingJSE();
		return this;
	}

	public Shared navigateToResourceReports() throws Exception {
		this.clickOnReport();
		waitForElement.waitForElements(Locators.RESOURCE_REPORTS, "linktext");
		this.page.element(Locators.RESOURCE_REPORTS, "linktext").clickUsingJSE();
		return this;
	}

	public Shared navigateToIncomingPatientNotificationDetails() throws Exception {
		waitForElement.waitForElements(Locators.INCOMING_PATIENT_NOTIFICATION_DETAILS, "linktext");
		this.page.element(Locators.INCOMING_PATIENT_NOTIFICATION_DETAILS, "linktext").clickUsingJSE();
		return this;
	}

	public Shared naviagteToIncomingPatientNotification() throws Exception {
		this.formMenu();
		waitForElement.waitForElements(Locators.INCOMING_PATIENT_NOTIFICATIONS, "linktext");
		this.page.element(Locators.INCOMING_PATIENT_NOTIFICATIONS, "linktext").clickUsingJSE();
		return this;
	}

	public Shared clickOnCustomize() throws Exception {
		waitForElement.waitForElements(Locators.CUSTOMIZE_LINK_AT_TOP, "css");
		this.page.element(Locators.CUSTOMIZE_LINK_AT_TOP, "css").clickUsingJSE();
		waitForElement.waitForElements(Views.Locators.OPTIONS_BUTTON, "css");
		return this;
	}

	public String getApplicationTimeWithTimeZone() throws Exception {
		waitForElement.waitForElements(Locators.APPLICATION_TIME_FROM_FOOTER, "xpath");
		String applicationTime = this.page.element(Locators.APPLICATION_TIME_FROM_FOOTER, "xpath").getOne().getText();
		return applicationTime;
	}

	public Shared clickOnSearchInToolBar() throws Exception {
		waitForElement.waitForElements(Locators.SEARCH_LINK_IN_TOOL_BAR, "xpath");
		this.page.element(Locators.SEARCH_LINK_IN_TOOL_BAR, "xpath").clickUsingJSE();
		waitForElement.waitForElements(Views.Locators.FIND_RESOURCES_PAGE, "xpath");
		return this;
	}

	public Shared customizedViewUnderPreferences() throws Exception {
		this.clickOnPreferences();
		waitForElement.waitForElements(Locators.CUSTOMIZED_VIEW, "xpath");
		this.page.element(Locators.CUSTOMIZED_VIEW, "xpath").clickUsingJSE();
		waitForElement.waitForElements(Views.Locators.EDIT_CUSTOM_VIEW_PAGE, "xpath");
		return this;
	}

	public Shared verifySendIncomingPatientNotification() throws Exception {
		waitForElement.waitForElements(Locators.SEND_INCOMING_PATIENT_NOTIFICATION, "linktext");
		assertTrue(this.page.element(Locators.SEND_INCOMING_PATIENT_NOTIFICATION, "linktext").isElementPresent());
		assertTrue(this.page.element(Locators.SEND_INCOMING_PATIENT_NOTIFICATION, "linktext").getOne().isDisplayed());
		return this;
	}

	public Shared verifySendIncomingPatientNotificationInIPNLast24HoursPage() throws Exception {
		waitForElement.waitForElements(Locators.SEND_INCOMING_PATIENT_NOTIFICATION_BUTTON, "css");
		assertTrue(this.page.element(Locators.SEND_INCOMING_PATIENT_NOTIFICATION_BUTTON, "css").isElementPresent());
		assertTrue(this.page.element(Locators.SEND_INCOMING_PATIENT_NOTIFICATION_BUTTON, "css").getOne().isDisplayed());
		return this;
	}

	public Shared clickOnShowMap() throws Exception {

		waitForElement.waitForElements(Locators.SHOW_MAP, "xpath");
		this.page.element(Locators.SHOW_MAP, "xpath").mouseOver();
		this.page.element(Locators.SHOW_MAP, "xpath").clickUsingJSE();	
		return this;
	}

	public Shared statusReasons() throws Exception {
		this.clickOnSetUp();
		waitForElement.waitForElements(Locators.STATUS_REASON, "linktext");
		this.page.element(Locators.STATUS_REASON, "linktext").getOne().click();
		return this;
	}

	public Shared waitForSpecificMinutes(int minutes) throws Exception {
		System.out.println("As per TC requirement, sleep has been called");
		TimeUnit.MINUTES.sleep(minutes);
		return this;
	}

	public Shared clickOnPrint()throws Exception {
		waitForElement.waitForElements(Locators.PRINT_LINK,"xpath");
		this.page.element(Locators.PRINT_LINK, "xpath").getOne().click();
		return this;
	}

	public Shared selectSpecificDateAndTimeUnderPrintOPtion()throws Exception {
		waitForElement.waitForElements(Locators.SPECIFIC_DATE_TIME_UNDER_PRINT_OPTION,"xpath");
		this.page.element(Locators.SPECIFIC_DATE_TIME_UNDER_PRINT_OPTION,"xpath").getOne().click();	
		return this;
	}

	public Shared enterSnapShotDate(String date)throws Exception {
		waitForElement.waitForElements(Locators.SNAPSHOT_DATE,"xpath");
		this.page.element(Locators.SNAPSHOT_DATE, "xpath").clearInputValue().sendKeys(date);	
		return this;
	}

	public Shared selectSnapShotHour(String hour)throws Exception {
		waitForElement.waitForElements(Locators.SNAPSHOT_HOUR,"xpath");
		this.page.element(Locators.SNAPSHOT_HOUR, "xpath").getOne().click();
		this.page.element(Locators.SNAPSHOT_HOUR, "xpath").webElementToSelect().selectByVisibleText(hour);
		return this;
	}

	public Shared selectSnapShotMinutes(String minutes)throws Exception {
		waitForElement.waitForElements(Locators.SNAPSHOT_MINUTE,"xpath");
		this.page.element(Locators.SNAPSHOT_MINUTE, "xpath").getOne().click();
		this.page.element(Locators.SNAPSHOT_MINUTE, "xpath").webElementToSelect().selectByVisibleText(minutes);
		return this;
	}

	public Shared clickOnGenerateReport()throws Exception {
		waitForElement.waitForElements(Locators.GENERATTE_REPORT,"xpath");
		this.page.element(Locators.GENERATTE_REPORT, "xpath").getOne().click();
		return this;
	}

	public Shared navigateToStatusChangePrefsUnderPreferences() throws Exception {
		this.clickOnPreferences();
		waitForElement.waitForElements(Locators.STATUS_CHANGE_PREFS, "xpath");
		this.page.element(Locators.STATUS_CHANGE_PREFS, "xpath").getOne().click();
		return this;
	}

	public Shared verifyViewName(String viewName) throws Exception {
		waitForElement.waitForElements(Locators.HEADER_PART + viewName + Locators.CLOSING_BRACKETS, "xpath");
		assertTrue(this.page.element(Locators.HEADER_PART + viewName + Locators.CLOSING_BRACKETS, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.HEADER_PART + viewName + Locators.CLOSING_BRACKETS, "xpath").getDisplayedOne().isDisplayed());
		return this;
	}

	public Shared editViewFromCustomizeLink() throws Exception {
		waitForElement.waitForElements(Locators.CUSTOMIZE_LINK_AT_TOP, "css");
		this.page.element(Locators.CUSTOMIZE_LINK_AT_TOP, "css").clickUsingJSE();
		waitForElement.waitForElements(Locators.EDIT_VIEW_SCREEN_WITHOUT_VIEW_NAME, "xpath");
		return this;
	}

	public Shared verifySubMenuIsNotPresent(String menuItemName) throws Exception {
		assertFalse(this.page.element(Locators.SUB_MENU_UNDER_MENU_TABS_PART1 + menuItemName + Locators.CLOSING_BRACKETS, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}

	public Shared securityQuestionUnderPreferences() throws Exception {
		this.clickOnPreferences();
		waitForElement.waitForElements(Locators.SECURITY_QUESTION_UNDER_PREFERENCES, "xpath");
		this.page.element(Locators.SECURITY_QUESTION_UNDER_PREFERENCES, "xpath").clickUsingJSE();
		waitForElement.waitForElements(Locators.WEB_NOTIFICATION_FRAME, "id");
		return this;
	}

	public Shared verifyErrorTitle() throws Exception {
		waitForElement.waitForElements(Locators.ERROR_TITLE, "class");
		assertTrue(this.page.element(Locators.ERROR_TITLE, "class").getDisplayedOne().getText().equals("EMResource Warning — Not Authorized"));
		return this;
	}

	public Shared verifyValidationMessage_UnauthorizedAccessLogged() throws Exception {
		waitForElement.waitForElements(Locators.NOT_AUTHORIZED_TO_PERFORM_ACTION, "xpath");
		assertTrue(this.page.element(Locators.NOT_AUTHORIZED_TO_PERFORM_ACTION, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.REGIONAL_ADMINISTRATOR_LINK, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.CLICK_HERE_TO_RETURN_TO_STATUS_VIEW, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.UNAUTHORIZED_ACESS_LOGGED, "xpath").getDisplayedOne().getText().contains("All unauthorized access is logged."));
		assertTrue(this.page.element(Locators.UNAUTHORIZED_ACESS_LOGGED, "xpath").getDisplayedOne().getText().contains("If you feel you have reached this page in error, contact your "));
		return this;
	}

	public Shared launchUrl(String UrlLink) throws Exception {
		driver.get(UrlLink);
		return this;
	}

	public Shared eventNotificationUnderPreferences() throws Exception {
		this.clickOnPreferences();
		waitForElement.waitForElements(Locators.EVENT_NOTIFICATION, "xpath");
		this.page.element(Locators.EVENT_NOTIFICATION, "xpath").getDisplayedOne().click();
		waitForElement.waitForElements(Locators.MY_EVENT_NOTIFICATION_PREFERENCES, "xpath");
		return this;
	}

	public Shared verifyEmailNotificationMethod(String eventTemplate) throws Exception {
		waitForElement.waitForElements(Locators.TABLE_CELL_TEXT + eventTemplate + Locators.CLOSING_BRACKETS + Locators.EMAIL_ID_OF_EVENT_TEMPLATE, "xpath");
		assertTrue(this.page.element(Locators.TABLE_CELL_TEXT + eventTemplate + Locators.CLOSING_BRACKETS + Locators.EMAIL_ID_OF_EVENT_TEMPLATE, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.TABLE_CELL_TEXT + eventTemplate + Locators.CLOSING_BRACKETS + Locators.EMAIL_ID_OF_EVENT_TEMPLATE, "xpath").getDisplayedOne().isDisplayed());
		return this;
	}

	public Shared verifyTextPagerNotificationMethod(String eventTemplate) throws Exception {
		waitForElement.waitForElements(Locators.TABLE_CELL_TEXT + eventTemplate + Locators.CLOSING_BRACKETS + Locators.TEXT_PAGER_ID_OF_EVENT_TEMPLATE, "xpath");
		assertTrue(this.page.element(Locators.TABLE_CELL_TEXT + eventTemplate + Locators.CLOSING_BRACKETS + Locators.TEXT_PAGER_ID_OF_EVENT_TEMPLATE, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.TABLE_CELL_TEXT + eventTemplate + Locators.CLOSING_BRACKETS + Locators.TEXT_PAGER_ID_OF_EVENT_TEMPLATE, "xpath").getDisplayedOne().isDisplayed());
		return this;
	}

	public Shared verifyWebNotificationMethod(String eventTemplate) throws Exception {
		waitForElement.waitForElements(Locators.TABLE_CELL_TEXT + eventTemplate + Locators.CLOSING_BRACKETS + Locators.WEB_ID_OF_EVENT_TEMPLATE, "xpath");
		assertTrue(this.page.element(Locators.TABLE_CELL_TEXT + eventTemplate + Locators.CLOSING_BRACKETS + Locators.WEB_ID_OF_EVENT_TEMPLATE, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.TABLE_CELL_TEXT + eventTemplate + Locators.CLOSING_BRACKETS + Locators.WEB_ID_OF_EVENT_TEMPLATE, "xpath").getDisplayedOne().isDisplayed());
		return this;
	}

	public Shared verifyMyResourcesOnlyNotificationMethod(String eventTemplate) throws Exception {
		waitForElement.waitForElements(Locators.TABLE_CELL_TEXT + eventTemplate + Locators.CLOSING_BRACKETS + Locators.MY_RESOURCE_ONLY_OF_EVENT_TEMPLATE, "xpath");
		assertTrue(this.page.element(Locators.TABLE_CELL_TEXT + eventTemplate + Locators.CLOSING_BRACKETS + Locators.MY_RESOURCE_ONLY_OF_EVENT_TEMPLATE, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.TABLE_CELL_TEXT + eventTemplate + Locators.CLOSING_BRACKETS + Locators.MY_RESOURCE_ONLY_OF_EVENT_TEMPLATE, "xpath").getDisplayedOne().isDisplayed());
		return this;
	}

	public Shared verifyMessageUnderMyEventNotificationPreferencesPage() throws Exception {
		waitForElement.waitForElements(Locators.MESSAGE_ON_MY_EVENT_NOTIFICATION_PREFERENCES_SCREEN, "xpath");
		assertEquals(this.page.element(Locators.MESSAGE_ON_MY_EVENT_NOTIFICATION_PREFERENCES_SCREEN, "xpath").getOne().getText(),"*** Select this option if you want to limit notifications to those events that involve your resources. This option is not applicable to all types of events.");
		return this;
	}

	public Shared verifyAllNotificationMethods(String eventTemplate) throws Exception {
		this.verifyEmailNotificationMethod(eventTemplate);
		this.verifyTextPagerNotificationMethod(eventTemplate);
		this.verifyWebNotificationMethod(eventTemplate);
		this.verifyMyResourcesOnlyNotificationMethod(eventTemplate);
		this.verifyMessageUnderMyEventNotificationPreferencesPage();
		return this;
	}

	public Shared selectEmailNotificationMethod(String eventTemplate) throws Exception {
		waitForElement.waitForElements(Locators.TABLE_CELL_TEXT + eventTemplate + Locators.CLOSING_BRACKETS + Locators.EMAIL_ID_OF_EVENT_TEMPLATE, "xpath");
		this.page.element(Locators.TABLE_CELL_TEXT + eventTemplate + Locators.CLOSING_BRACKETS + Locators.EMAIL_ID_OF_EVENT_TEMPLATE, "xpath").getDisplayedOne().click();
		assertTrue(this.page.element(Locators.TABLE_CELL_TEXT + eventTemplate + Locators.CLOSING_BRACKETS + Locators.EMAIL_ID_OF_EVENT_TEMPLATE, "xpath").getDisplayedOne().isSelected());
		return this;
	}

	public Shared selectMyResourcesOnlyNotificationMethod(String eventTemplate) throws Exception {
		waitForElement.waitForElements(Locators.TABLE_CELL_TEXT + eventTemplate + Locators.CLOSING_BRACKETS + Locators.MY_RESOURCE_ONLY_OF_EVENT_TEMPLATE, "xpath");
		this.page.element(Locators.TABLE_CELL_TEXT + eventTemplate + Locators.CLOSING_BRACKETS + Locators.MY_RESOURCE_ONLY_OF_EVENT_TEMPLATE, "xpath").getDisplayedOne().click();
		assertTrue(this.page.element(Locators.TABLE_CELL_TEXT + eventTemplate + Locators.CLOSING_BRACKETS + Locators.MY_RESOURCE_ONLY_OF_EVENT_TEMPLATE, "xpath").getDisplayedOne().isSelected());
		return this;
	}

	public Shared clickOnSaveOfNotifications() throws Exception {
		waitForElement.waitForElements(Locators.SAVE, "css");
		this.page.element(Locators.SAVE, "css").getOne().click();
		Alert alert = driver.switchTo().alert();
		String notificationMessage = alert.getText();
		assertEquals(notificationMessage,"Your changes have been saved.");
		alert.accept();
		return this;
	}

	public Shared selectMyResourcesOnlyEmailNotificationMethod(String eventTemplate) throws Exception {
		this.selectEmailNotificationMethod(eventTemplate);
		this.selectMyResourcesOnlyNotificationMethod(eventTemplate);
		this.clickOnSaveOfNotifications();
		return this;
	}

	public Shared clickOnShowTable() throws Exception {
		waitForElement.waitForElements(Locators.SHOW_TABLE, "xpath");
		this.page.element(Locators.SHOW_TABLE, "xpath").mouseOver();
		this.page.element(Locators.SHOW_TABLE, "xpath").clickUsingJSE();
		return this;
	}

	public Shared customizeViewResourceDetailScreen() throws Exception {
		waitForElement.waitForElements(Locators.CUSTOMIZE_LINK_AT_TOP, "css");
		this.page.element(Locators.CUSTOMIZE_LINK_AT_TOP, "css").clickUsingJSE();
		waitForElement.waitForElements(Locators.EDIT_RESOURCE_DETAIL_VIEW_SECTIONS_SCREEN, "xpath");
		return this;
	}
	 
	public Shared navigateToEventList() throws Exception {
		waitForElement.waitForElements(Locators.EVENT_LIST, "xpath");
		this.page.element(Locators.EVENT_LIST, "xpath").clickUsingJSE();
		try {
			if (this.page.element(Locators.EVENT_LIST_PAGE, "xpath")
					.isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL) == false) {
				this.page.element(Locators.EVENT_LIST, "xpath").getOne()
						.click();
				waitForElement.waitForElements(Locators.EVENT_LIST_PAGE,
						"xpath");
			}
			if (this.page.element(EMR.Locators.Shared.Locators.EVENT_LIST_PAGE,
					"xpath")
					.isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL) == false) {
				this.page.element(Locators.EVENT_LIST, "xpath").getOne()
						.sendKeys(Keys.ENTER);
			}
			waitForElement.waitForElements(Locators.EVENT_LIST_PAGE, "xpath");
			assertTrue(this.page.element(
					EMR.Locators.Shared.Locators.EVENT_LIST_PAGE, "xpath")
					.isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL));
		} catch (Exception e) {

		}
		return this;
	}

	public Shared eventList() throws Exception {
		this.clickOnEvents();
		this.navigateToEventList();
		return this;
	}

	public Shared selectTextPagerNotificationMethod(String eventTemplate)
			throws Exception {
		waitForElement.waitForElements(Locators.TABLE_CELL_TEXT + eventTemplate
				+ Locators.CLOSING_BRACKETS
				+ Locators.TEXT_PAGER_ID_OF_EVENT_TEMPLATE, "xpath");
		this.page
				.element(
						Locators.TABLE_CELL_TEXT + eventTemplate
								+ Locators.CLOSING_BRACKETS
								+ Locators.TEXT_PAGER_ID_OF_EVENT_TEMPLATE,
						"xpath").getDisplayedOne().click();
		assertTrue(this.page
				.element(
						Locators.TABLE_CELL_TEXT + eventTemplate
								+ Locators.CLOSING_BRACKETS
								+ Locators.TEXT_PAGER_ID_OF_EVENT_TEMPLATE,
						"xpath").getDisplayedOne().isSelected());
		return this;
	}

	public Shared selectWebNotificationMethod(String eventTemplate)
			throws Exception {
		waitForElement.waitForElements(
				Locators.TABLE_CELL_TEXT + eventTemplate
						+ Locators.CLOSING_BRACKETS
						+ Locators.WEB_ID_OF_EVENT_TEMPLATE, "xpath");
		this.page
				.element(
						Locators.TABLE_CELL_TEXT + eventTemplate
								+ Locators.CLOSING_BRACKETS
								+ Locators.WEB_ID_OF_EVENT_TEMPLATE, "xpath")
				.getDisplayedOne().click();
		assertTrue(this.page
				.element(
						Locators.TABLE_CELL_TEXT + eventTemplate
								+ Locators.CLOSING_BRACKETS
								+ Locators.WEB_ID_OF_EVENT_TEMPLATE, "xpath")
				.getDisplayedOne().isSelected());
		return this;
	}

	public Shared selectAllNotificationMethod(
			String eventTemplate) throws Exception {
		this.selectEmailNotificationMethod(eventTemplate);
		this.selectTextPagerNotificationMethod(eventTemplate);
		this.selectWebNotificationMethod(eventTemplate);
		this.selectMyResourcesOnlyNotificationMethod(eventTemplate);
		this.clickOnSaveOfNotifications();
		return this;
	}
	
	public Shared selectTextPagerAndWebNotificationMethod(String eventTemplate) throws Exception {
		this.selectTextPagerNotificationMethod(eventTemplate);
		this.selectWebNotificationMethod(eventTemplate);
		this.clickOnSaveOfNotifications();
		return this;
	}
	
	public Shared verifySubMenuIsPresent(String menuItemName) throws Exception {
		waitForElement.waitForElements(Locators.SUB_MENU_UNDER_MENU_TABS_PART1 + menuItemName + Locators.CLOSING_BRACKETS, "xpath");
		assertTrue(this.page.element(Locators.SUB_MENU_UNDER_MENU_TABS_PART1 + menuItemName + Locators.CLOSING_BRACKETS, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	public Shared selectWebPagerAndMailNotificationMethod(String eventTemplate) throws Exception {
		this.selectEmailNotificationMethod(eventTemplate);
		this.selectTextPagerNotificationMethod(eventTemplate);
		this.selectWebNotificationMethod(eventTemplate);
		this.clickOnSaveOfNotifications();
		return this;
	}
	
	public Shared verifyAppSwitcher_Disabled() throws Exception {
		assertFalse(this.page.element(Locators.APP_SWITCHER, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE), "App switcher is available");
		return this;
	}
	
	public Shared verifySubMenu_NotPresent(String menuItemName) throws Exception {
		assertFalse(this.page.element(Locators.SUB_MENU_UNDER_MENU_TABS_PART1 + menuItemName + Locators.CLOSING_BRACKETS, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}

	public Shared showOnMap() throws Exception {
		this.clickOnShowMap();
		return this;
	}
	
	public Shared clickOnRegionalInfo() throws Exception {
		waitForElement.waitForElements(Locators.REGIONAL_INFO, "xpath");
		this.page.element(Locators.REGIONAL_INFO, "xpath").clickUsingJSE();
		try{
			if (this.page.element(Locators.REGIONAL_INFO, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL) == false) {
				this.page.element(Locators.REGIONAL_INFO, "xpath").getOne().click();
				waitForElement.waitForElements(Locators.REGIONAL_INFO,"xpath");
			}
			if(this.page.element(EMR.Locators.Shared.Locators.REGIONAL_INFO, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL)==false) {
				this.page.element(Locators.REGIONAL_INFO, "xpath").getOne().sendKeys(Keys.ENTER);
			}
			waitForElement.waitForElements(Locators.REGIONAL_INFO,"xpath");
			assertTrue(this.page.element(EMR.Locators.Shared.Locators.REGIONAL_INFO, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL));
		} catch(Exception e) {

		}
		return this;
	}
	
	public Shared usersUnderRegionalInfo() throws Exception{
		this.clickOnRegionalInfo();
		waitForElement.waitForElements(Locators.USERSTEXT, "xpath");		
		try{
			this.page.element(Locators.USERSTEXT, "xpath").getOne().click();
			waitForElement.waitForElements(Locators.USERSLIST_PAGE, "xpath");
			if (this.page.element(Locators.USERSLIST_PAGE, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE) == false) {
				this.page.element(Locators.USERSTEXT, "xpath").clickUsingJSE();
			}
		} catch(Exception e) {

		}
		return this;
	}
	
	public Shared instantMessaging() throws Exception{
		waitForElement.waitForElements(Locators.INSTANT_MESSAGING, "xpath");
		this.page.element(Locators.INSTANT_MESSAGING, "xpath").clickUsingJSE();
		try{
			if (this.page.element(Locators.INSTANT_MESSAGING, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL) ) {
				this.page.element(Locators.INSTANT_MESSAGING, "xpath").getOne().click();
				waitForElement.waitForElements(Locators.INSTANT_MESSAGING,"xpath");
			}
			if(this.page.element(EMR.Locators.Shared.Locators.INSTANT_MESSAGING, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL)) {
				this.page.element(Locators.INSTANT_MESSAGING, "xpath").getOne().sendKeys(Keys.ENTER);
			}
			waitForElement.waitForElements(Locators.INSTANT_MESSAGING,"xpath");
			assertTrue(this.page.element(EMR.Locators.Shared.Locators.INSTANT_MESSAGING, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL));
		} catch(Exception e) {

		}
		return this;
	}
	
	public Shared navigateToCustomViewTable() throws Exception {
		this.clickOnView();
		waitForElement.waitForElements(Locators.CUSTOM_VIEW, "xpath");
		this.page.element(Locators.CUSTOM_VIEW, "xpath").clickUsingJSE();
		if (this.page.element(Locators.CUSTOM_VIEW_MAP_PAGE, "xpath").isElementPresent()) 
		{
			this.clickOnShowTable();	
			waitForElement.waitForElements(Locators.CUSTOM_VIEW_MAP_PAGE, "xpath");
		}
		assertTrue(this.page.element(Locators.CUSTOM_VIEW_TABLE_PAGE, "xpath").isElementPresent());
		return this;
	}
	
	public Shared navigateToStatusReports() throws Exception {
		this.clickOnReport();
		waitForElement.waitForElements(Locators.STATUS_REPORTS, "xpath");
		this.page.element(Locators.STATUS_REPORTS, "xpath").clickUsingJSE();
		return this;
		
	}
}