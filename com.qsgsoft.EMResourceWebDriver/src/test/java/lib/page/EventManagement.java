package lib.page;

import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;

import lib.dataObject.Login_data;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import qaframework.lib.WaitTimeConstants;
import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;
import qaframework.lib.webElements.WebElements;

public class EventManagement extends PageObject {

	WebDriver driver;
	Login_data login_data = new Login_data();
	Date_Time_settings objDts = new Date_Time_settings();
	WebElements WebElements_page = new WebElements(page, null);
	WaitForElement objWaitForElement ;
	// Locators
	private String eventLink = "//a[@href='/EMSystem?uc=GENERAL&nextStep=menuItemList&nextStepDetail=EVENT'][text()='Event']";
	private String eventManagement = "//td/a[text()='Event Management']";
	private String createAdHocEventButton = "//input[@value='Create Ad Hoc Event']";
	private String adHocEventName = "title";
	private String adHocEventDescription = "description";
	private String eventEndTimeInHours = "durationHours";
	private String nextButton = "input[value='Next']";
	private String yesButton = "input[value='Yes']";
	private String createNewEventButton = "//input[@value='Create New Event']";
	private String adHocEventConfirmation = "//div[@id='topSubNav']/h1[text()='Ad Hoc Event Confirmation']";
	private String errorMessageTitle = "//div[@id='mainContainer']/div/span[text()='The following error occurred on this page:']";
	private String adhocEventInfErrorMessage = "//div[@id='mainContainer']/div/ul/li[text()='No information was provided.']";
	private String adhocEventTitleErrorMessage = "//div[@id='mainContainer']/div/ul/li[text()='No title was provided.']";
	private String adhocEventPastTimeErrorMessage = "//div[@id='mainContainer']/div/ul/li[text()='The event end time must be in the future.']";
	private String header = "h1";
	private String selectStatusTypes = "//div[@id='topSubNav']/h1[text()='Select Status Types']";
	private String statusTypeNameHeader = "//table[@id='tbl_statusTypeID']/thead/tr/th/a[text()='Name']";
	private String statusTypeName = "//table[@id='tbl_statusTypeID']/tbody/tr[1]/td[2][text()]";
	private String selectResources = "//div[@id='topSubNav']/h1[text()='Select Resources']";
	private String resourceNameHeader = "//table[@id='tbl_resourceID']/thead/tr/th/a[text()='Resource Name']";
	private String resourceName = "//table[@id='tbl_resourceID']/tbody/tr[1]/td[2][text()]";
	private String eventEndRadioButton = "input[value='DATE'][name='eventEndType']";
	private String eventEndDate = "input[name='eventEndType'][value='DATE']";
	private String eventEndMonth = "select[name='endMonth']";
	private String eventEndDay = "endDay";
	private String eventEndYear = "endYear";
	private String eventEndHour = "endHour";
	private String eventEndMinute = "endMinute";
	private String eventStartDate = "//input[@name='startNow'][2]";
	private String eventStartMonth = "select[name='startMonth']";
	private String eventStartDay = "select[name='startDay']";
	private String eventStartYear = "select[name='startYear']";
	private String eventStartHour = "select[name='startHour']";
	private String eventStartMinute = "select[name='startMinute']";
	private String startMonth = "//select[@name='startMonth']/option[@selected]";
	private String startDay = "//select[@name='startDay']/option[@selected]";
	private String startYear = "//select[@name='startYear']/option[@selected]";
	private String startHour = "//select[@name='startHour']/option[@selected]";
	private String startMinute = "//select[@name='startMinute']/option[@selected]";
	private String messageForSameStartAndEndDate = "//div[@class='emsError']/ul/li[text()='Events may not be less than five minutes long.']";
	private String eventLink1 = "//a[@class='mainLink selected'][text()='Event']";
	private String eventNeverEndRadioButton = "input[value='NEVER'][name='eventEndType']";
	private String keepButton = "input[value='Keep']";
	private String errorMsgOfMaintainAdHocEvents = "//div[@id='mainContainer']/div/ul/li";
	private String checkBoxOfDisplayInEventBanner = "//input[@class='checkbox vtop'][@name='displayInEventBanner']";
	private String errorMsgForEventBanner = "//div[@id='mainContainer']/div/ul";
	private String previousButton = "//input[@class='emsButtonText'][@value='Previous']";
	private String modifyButton = "input[value='Modify']";
	private String endTypeInHours = "//input[@name='eventEndType'][@value='HOURS']";
	private String statusTypeIdTable = "#tbl_statusTypeID";
	private String searchResourceType = "#tbl_resourceID_RESOURCE_TYPE",
				   createNewEvent = "input[value='Create New Event']",
				   saveButton = "input[value='Save']",
					createNewEventPage = "//div[@id='topSubNav']/h1[text()='Create Event']",
					acknowlwdgeNotification = "//button[text()='Acknowledge All Notifications']",
					strFrame = "Data",
					eventManagementPage = "//div[@id='topSubNav']/h1[text()='Event Management']",
					selectEventTemplatePage = "//div[@id='topSubNav']/h1[text()='Select Event Template']",
					createNewMultiEvent = "//input[@value='Create New Multi-Region Event']",
					createMultiRegionEventButton = "input[value='Create New Multi-Region Event']",
					includeAllResources = "includeAllResources",
					confirmationMessage = "//center/strong",
					privateCheckBox = "input[name='privateEvent']", city = "#city",
					state = "#stateAbbrev", country = "#county", zipcode = "#zipCode",
					lookUpAdd = "input[value='Lookup Address']",
					eventList = "Event List",
					conformationMessage = "//div[@id='mainContainer']//center/strong[text()='Are you sure you want to create this multi-region event?']",
					noButton = "input[value='No']",
	                viewHistoryPopUp = "//h1[text()='Event History']",
	                closeButton = "#TB_closeWindowButton",
	                strEventHistoryFrame = "relative=up",
	                applicationTime = "//table[@class='footer']/tbody/tr/td[3]/span[@id='statusTime']",
	                multiEventsTitleField="//td[@class='emsLabel'][text()='Title for this multi-region event:']/following"
						+ "-sibling::td/input[@type='text']",
	                multiEventInformationField="//td[@class='emsLabel'][text()='Information for this multi-region event:']/following-sibling::td/textarea[@class='emsText']",
	                multiEventStartField1="//td[@class='emsLabel'][text()='Event Start:']/following-sibling::td/"
						+ "input[@type='radio'][@value='Y']",
	                multiEventStartField2="//td[@class='emsLabel'][text()='Event Start:']/following-sibling::td/"
						+ "input[@type='radio'][@value='N']",
	                multiEventEndField1="//td[@class='emsLabel'][text()='Event End:']/following-sibling::td/"
						+ "input[@type='radio'][@value='HOURS']",
					multiEventEndField2="//td[@class='emsLabel'][text()='Event End:']/following-sibling::td/"
						+ "input[@type='radio'][@value='DATE']",
					multiEventEndField3="//td[@class='emsLabel'][text()='Event End:']/following-sibling::td/"
						+ "input[@type='radio'][@value='NEVER']",
			        multiEventBannerField = "//td[@class='emsLabel'][text()='Display in Event Banner?']/following-sibling::td/"
						+ "input[@type='checkbox']",
			        multiEventPrivateField = "//td[@class='emsLabel'][text()='Private?']/following-sibling::td/input[@type='checkbox']",
			        multiEventDrillField = "//td[@class='emsLabel'][text()='Drill?']/following-sibling::td/input[@type='checkbox']",
			        multiEventEndQuitelyField = "//td[@class='emsLabel'][text()='End Quietly?']/following-sibling::td/input[@type='checkbox']",
			        multiEventRenotifyField1 = "//td[@class='emsLabel'][text()='Re-notify:']/following-sibling::td/input[@type='radio'][@value='0']",
					multiEventRenotifyField2="//td[@class='emsLabel'][text()='Re-notify:']/following-sibling::td/input[@type='radio'][@value='1']",
					multiEventRenotifyField3="//td[@class='emsLabel'][text()='Re-notify:']/following-sibling::td/input[@type='radio'][@value='2']",
			        multiEventStreetAddressField = "//td[@class='emsLabel'][text()='Street Address:']/following-sibling::td/input[@type='text']",
			        multiEventCityField = "//td[@class='emsLabel'][text()='City:']/following-sibling::td/input[@type='text']",
			        multiEventStateField = "//td[@class='emsLabel'][text()='State:']/following-sibling::td/select[@id='stateAbbrev']",
			        multiEventZipCodeField = "//td[@class='emsLabel'][text()='Zip Code:']/following-sibling::td/input[@type='text']",
			        multiEventCountyField = "//td[@class='emsLabel'][text()='County:']/following-sibling::td/select[@id='county']",
			        latitudeLogitudeText = "//td[text()='Latitude/Longitude:']",
			        latitude = "#latitude",
			        longitude = "#longitude",
			        browseButton = "//input[@name='document']",
			        clickOnCancelButton = "input[value='Cancel']",
			        textMessage1  = "//div[@id='mainContainer']/p/strong[contains(text(),'end date is more than 30 days after the start date.')]", 
	                textMessage2 = "//div[@id='mainContainer']/p/strong[contains(text()[2],'Would you like to keep this date as is or modify it?')]",
	                drillCheckBox = "input[name='drill']",
	                errorMessageForST = "//div[@class='emsError']/ul/li",
	                editMultiRegEventScreen = "//div[@id='topSubNav']/h1[text()='Edit Multi-Region Event']",
	                saveButtonInTopOfPage="//div[@id='mainContainer']/form/table/tbody/tr[1]/td/input[@value='Save']",
	                cancelButtonInTopOfPage="//div[@id='mainContainer']/form/table/tbody/tr[1]/td/input[@value='Cancel']",
	                saveButtonInBottomOfPage="//div[@id='mainContainer']/form/table/tbody/tr[18]/td/input[@value='Save']",
	    	        cancelButtonInBottomOfPage="//div[@id='mainContainer']/form/table/tbody/tr[18]/td/input[@value='Cancel']",
	    	        saveButton1="//div[@id='mainContainer']/form/table/tbody/tr[17]/td/input[@value='Save']",
	                cancelButton1="//div[@id='mainContainer']/form/table/tbody/tr[17]/td/input[@value='Cancel']",
	                errorMessageTitle1 = "//div[@id='mainContainer']/div/span[text()='The following errors occurred on this page:']",
	                editAdhocEvent = "//div[@id='topSubNav']/h1[text()='Edit Ad Hoc Event']",
	                editEventPage = "//div[@id='topSubNav']/h1[text()='Edit Event']",
	                saveButton2="//div[@id='mainContainer']/form/table/tbody/tr[19]/td/input[@value='Save']",
	                saveButton3="//div[@id='mainContainer']/form/table/tbody/tr[24]/td/input[@value='Save']",
	                searchField = "input[name='statusTypeID_filterText']",
	                searchButton = "input[value='Search']",
	                toggleCheckBox = "//div[@id='st']//table//input[@class='toggleAll']",
	                statusTypeNameSearchBox = "input[name='st_filterText']",
	                checkBoxOfDisplayInEventBanner1="//td[text()='Display in Event Banner?']/..//span[contains(text(),'Check to show event in the colored event banner near top of page.')]",
	                DisplayInEventBannercheckbox="//input[@class='checkbox vtop'][@name='displayInEventBanner']",
	                acknowledgementDate = "//div[@id='footer']/table/tbody/tr/td[3]/span[@id='statusTime']",
	                selectETError = "//div[@id='mainContainer']/div/ul/li[text()='No event template was selected from any region; you must choose at least one.']",
	                MREConfirmationPage = "//div[@id='topSubNav']/h1[text()='Multi-Region Event Confirmation']";
	
	static boolean  blnCheck =false;        
	public EventManagement(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
	}

	/**********************************************************************************
	 * Description : This function is to navigate To EventManagement Page Date :
	 * 09/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement navigateToEventManagement() throws Exception {
		//table[@class='footer']/tbody/tr/td[3][contains(text(),'Shruti')]
//		objWaitForElement.waitForElements("//table[@class='footer']/tbody/tr/td[3]", "xpath");
//		if(this.page.element("//table[@class='footer']/tbody/tr/td[3][contains(text(),'Shruti')]", "xpath").isElementPresent()==true){
//			
//		}
//		else{
		objWaitForElement.waitForElements(eventLink, "xpath");
		this.page.element(eventLink, "xpath").getOne().click();
		if((this.page.element(eventManagement, "xpath").isElementPresent())==false){
			this.page.element(eventLink, "xpath").getOne().click();
		}
		objWaitForElement.waitForElements(eventManagement, "xpath");
		this.page.element(eventManagement, "xpath").getOne().click();
//		}
		return new EventManagement(this.driver);
	}

	/**********************************************************************************
	 * Description : This function is to click on 'Create AdHoc Event' Button
	 * Date : 09/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement clickOnCreateAdHocEventButton() throws Exception {
//		if(this.page.element("//table[@class='footer']/tbody/tr/td[3][contains(text(),'Shruti')]", "xpath").isElementPresent()==true){
//			blnCheck = true;
//			Login login_page1 = new Login(this.driver);
//			UsersList UsersList_page = new UsersList(this.driver);
//			RegionDefault RegionDefault_page = new RegionDefault(this.driver);
//			SelectRegion objSelectRegion = new SelectRegion(this.driver);
//			User_data objUser_data = new User_data();
//			Login_data objTest_data = new Login_data();
//			//New user
//			String strNewUser = "Auto"+System.currentTimeMillis();
//			String strFNNewUser = "FN"+strNewUser;
//			
//			UsersList_page
//					.navigateToUsers()
//					.clickCreateNewUserButton();
//
//			UsersList_page.enterUserDetails(strNewUser,
//							objUser_data.strNewPassword, strFNNewUser)
//					.selectFirstRole()
//					.clickAdvancedOptionAndExpand()
//					.selectMaintainEventsOption()
//					.selectMaintainAdHocEventsOption()
//					.clickSaveButton();
//			Thread.sleep(3000);
//			String strRegionNAme = objSelectRegion.getRegionName();
//			
//			login_page1.clickLogOut();
//			
//			login_page1.loginAsNewUser(strNewUser, objUser_data.strNewPassword);
//			RegionDefault_page.selectFrame();
//			
//			this.navigateToEventManagement();
//		}
		objWaitForElement.waitForElements(createAdHocEventButton, "xpath");
		this.page.element(createAdHocEventButton, "xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to enter Event name Date : 09/06/2014
	 * Author : Anil
	 **********************************************************************************/
	public EventManagement enterAdHocEventName(String strEventName)
			throws Exception {
		objWaitForElement.waitForElements(adHocEventName, "name");
		this.page.element(adHocEventName, "name").clearInputValue()
				.sendKeys(strEventName);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to enter Event description Date :
	 * 09/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement enterAdHocEventDescription(String strEventDescription)
			throws Exception {
		objWaitForElement.waitForElements(adHocEventDescription, "name");
		this.page.element(adHocEventDescription, "name").clearInputValue()
				.sendKeys(strEventDescription);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on 'Next' button Date :
	 * 09/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement clickOnNextButton() throws Exception {
//		WebElement element = driver.findElement(By.cssSelector(nextButton));
//		this.page.element(nextButton, "css").scrollDownTillElement(element);
//		this.page.element_wait(nextButton, "css").waitForVisibilityOfElement();
		objWaitForElement.waitForElements(nextButton, "css");
		
		this.page.element(nextButton, "css").mouseOver();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				driver.findElement(By.cssSelector(nextButton)));
Thread.sleep(10000);
		//this.page.element(nextButton, "css").getOne().click();
		return this;
		
	}

	/**********************************************************************************
	 * Description : This function is to click on 'Yes' button Date : 09/06/2014
	 * Author : Anil
	 **********************************************************************************/
	public EventManagement clickOnYesButton() throws Exception {
		driver.manage().timeouts()
				.implicitlyWait(WaitTimeConstants.COUNT, TimeUnit.SECONDS);
		objWaitForElement.waitForElements(yesButton, "css");
		//this.page.element(yesButton, "css").getOne().click();
		this.page.element(yesButton, "css").mouseOver();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				driver.findElement(By.cssSelector(yesButton)));
		Thread.sleep(5000);
//		if(blnCheck==true){
//		Login login_page1 = new Login(this.driver);
//		RegionDefault RegionDefault_page = new RegionDefault(this.driver);
//		SelectRegion objSelectRegion = new SelectRegion(this.driver);
//		Login_data objTest_data = new Login_data();
//		
//		String strRegionNAme = this.page.element("//div[@id='regionName']", "xpath").getOne().getText();
//		strRegionNAme = strRegionNAme.replace("(TEST)", "");
//		strRegionNAme= strRegionNAme.trim();
//		login_page1.clickLogOut()
//		
//		.loginToApplication(objTest_data.strUserName,
//				objTest_data.strPassword);
//		RegionDefault_page.selectFrame();
//		objSelectRegion.selectRegionAndNavigate(strRegionNAme);
//		
//		RegionDefault_page.selectFrame();
//		this.navigateToEventList();
//		blnCheck = false;
//		}
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify 'Create AdHoc Event' Button is
	 * not displayed Date : 09/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifyAdHocEventButtonNotDisplayed()
			throws Exception {
		assertFalse(this.page.element(createAdHocEventButton, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to create an AdHoc Event Date : 09/06/2014
	 * Author : Anil
	 **********************************************************************************/
	public EventManagement createAdHocEvent(String strEventName,
			String strEventDescription) throws Exception {
		objWaitForElement.waitForElements("//table[@class='footer']/tbody/tr/td[3]", "xpath");
		if(this.page.element("//table[@class='footer']/tbody/tr/td[3][contains(text(),'Shruti')]", "xpath").isElementPresent()==true){
			
		}
		
		this.enterAdHocEventName(strEventName);
		this.enterAdHocEventDescription(strEventDescription);
		this.clickOnNextButton();
		this.clickOnNextButton();
		this.clickOnNextButton();
		this.clickOnYesButton();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to get event start time Date : 09/06/2014
	 * Author : Anil
	 **********************************************************************************/
	public String getEventStartTime(String strEventName) throws Exception {
		String strEventStartTime = this.page
				.element(
						"//table/tbody/tr/td[7][text()='" + strEventName
								+ "']/preceding-sibling::td[2]", "xpath")
				.getOne().getText();
		return strEventStartTime;
	}

	/**********************************************************************************
	 * Description : This function is to get event End time Date : 09/06/2014
	 * Author : Anil
	 **********************************************************************************/
	public String getEventEndTime(String strEventName) throws Exception {
		String strEventEndTime = this.page
				.element(
						"//table/tbody/tr/td[7][text()='" + strEventName
								+ "']/preceding-sibling::td[1]", "xpath")
				.getOne().getText();
		return strEventEndTime;
	}

	/**********************************************************************************
	 * Description : This function is to verify Event name is displayed in the
	 * list Date : 09/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifyEventName(String strEventName)
			throws Exception {
		objWaitForElement.waitForElements("//table/tbody/tr/td[7][text()='"
				+ strEventName + "']", "xpath");
		assertTrue(this.page
				.element(
						"//table/tbody/tr/td[7][text()='" + strEventName + "']",
						"xpath").getOne().isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify 'Edit' option is not displayed
	 * for an Event Date : 09/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifyEditEventIsNotDisplayed(String strEventName)
			throws Exception {
		assertFalse(this.page.dynamicElement(
				"EventEditLink",
				"//table/tbody/tr/td[7][text()='" + strEventName
						+ "']/preceding-sibling::td[6]/a[text()='Edit']",
				"xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify 'End' option is not displayed
	 * for an Event Date : 09/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifyEndEventIsNotDisplayed(String strEventName)
			throws Exception {
		assertFalse(this.page.dynamicElement(
				"EventEndLink",
				"//table/tbody/tr/td[7][text()='" + strEventName
						+ "']/preceding-sibling::td[6]/a[text()='End']",
				"xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify Start time is displayed for an
	 * Event Date : 09/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifyEventStartTime(String strEventName,
			String strEventStartTime) throws Exception {
		objWaitForElement.waitForElements("//table/tbody/tr/td[7][text()='" + strEventName
				+ "']/preceding-sibling::td[2]",
				"xpath");
		Date_Time_settings objDate_Time_settings = new Date_Time_settings();
		String strTime[] = strEventStartTime.split(" ");
		String strEventStartTimeAddedOneMin = objDate_Time_settings
				.addTimetoExisting(strTime[1], 1, "HH:mm");
		String strEventStartTime1 = strTime[0] + " "
				+ strEventStartTimeAddedOneMin;
		String strDisplayedEventStartTime = this.page
				.dynamicElement(
						"EventStartTime",
						"//table/tbody/tr/td[7][text()='" + strEventName
								+ "']/preceding-sibling::td[2]", "xpath")
				.getOne().getText();
		assertTrue(strDisplayedEventStartTime.equals(strEventStartTime)
				|| strDisplayedEventStartTime.equals(strEventStartTime1));
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify End time is displayed for an
	 * Event Date : 09/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifyEventEndTime(String strEventName,
			String strEventEndTime) throws Exception {
		Date_Time_settings objDate_Time_settings = new Date_Time_settings();
		String strTime[] = strEventEndTime.split(" ");
		String strEventEndTimeAddedOneMin = objDate_Time_settings
				.addTimetoExisting(strTime[1], 1, "HH:mm");
		String strEventEndTime1 = strTime[0] + " " + strEventEndTimeAddedOneMin;
		String strDisplayedEventStartTime = this.page
				.dynamicElement(
						"EventEndTime",
						"//table/tbody/tr/td[7][text()='" + strEventName
								+ "']/preceding-sibling::td[1]", "xpath")
				.getOne().getText();
		assertTrue(strDisplayedEventStartTime.equals(strEventEndTime)
				|| strDisplayedEventStartTime.equals(strEventEndTime1));
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify End time is displayed for an
	 * Event Date : 09/06/2014 Author : Renushree
	 **********************************************************************************/
	public EventManagement verifyEventEndTimeWhenItSetToNever(
			String strEventName, String strEventEndTime) throws Exception {
		String strDisplayedEventStartTime = this.page
				.dynamicElement(
						"EventEndTime",
						"//table/tbody/tr/td[7][text()='" + strEventName
								+ "']/preceding-sibling::td[1]", "xpath")
				.getOne().getText();
		assertTrue(strDisplayedEventStartTime.equals(strEventEndTime));
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify 'Create AdHoc Event', 'Create
	 * New Event' Button is displayed Date : 10/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifyCreateEventButtonsDisplayed() throws Exception {
		this.verifyAdHocEventButtonDisplayed();
		this.verifyCreateEventButtonDisplayed();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify 'Create AdHoc Event' Button is
	 * displayed Date : 09/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifyAdHocEventButtonDisplayed() throws Exception {
		objWaitForElement.waitForElements(createAdHocEventButton, "xpath");
		assertTrue(this.page.element(createAdHocEventButton, "xpath").getOne()
				.isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify 'Create New Event' Button is
	 * displayed Date : 09/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifyCreateEventButtonDisplayed() throws Exception {
		objWaitForElement.waitForElements(createNewEventButton, "xpath");
		assertTrue(this.page.element(createNewEventButton, "xpath").getOne()
				.isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify Error mesage Title Date :
	 * 11/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifyErrorMessageTitle() throws Exception {
		objWaitForElement.waitForElements(errorMessageTitle, "xpath");
		assertTrue(this.page.element(errorMessageTitle, "xpath").getOne()
				.isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify Error message in create adhoc
	 * event page Date : 11/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifyInfErrorMessageInCreateAdhocEventPage()
			throws Exception {
		objWaitForElement.waitForElements(adhocEventInfErrorMessage, "xpath");
		assertTrue(this.page.element(adhocEventInfErrorMessage, "xpath")
				.getOne().isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify title Error message in create
	 * adhoc event page Date : 11/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifyTitleErrorMessageInCreateAdhocEventPage()
			throws Exception {
		objWaitForElement.waitForElements(adhocEventTitleErrorMessage, "xpath");
		assertTrue(this.page.element(adhocEventTitleErrorMessage, "xpath")
				.getOne().isDisplayed());

		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify create adhoc event page Date :
	 * 11/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifyCreateAdhocEventPage() throws Exception {
		objWaitForElement.waitForElements(header, "css");
		assertEquals("Create Ad Hoc Event", this.page.element(header, "css")
				.getOne().getText());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify resource Date : 11/06/2014
	 * Author : Anil
	 **********************************************************************************/
	public EventManagement verifyResourceInSelectResourcePage(
			String[] strResourceValues) throws Exception {
		for (int i = 0; i < strResourceValues.length; i++) {
			objWaitForElement.waitForElements("//input[@value='" + strResourceValues[i]
					+ "'][@name='resourceID']", "xpath");
			assertTrue(this.page
					.dynamicElement(
							"ResourceValues",
							"//input[@value='" + strResourceValues[i]
									+ "'][@name='resourceID']", "xpath")
					.getOne().isDisplayed());
		}

		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify resource Date : 11/06/2014
	 * Author : Anil
	 **********************************************************************************/
	public EventManagement verifyStatusTypesInSelectStausTypePage(
			String[] strStatusTypeValues) throws Exception {
		for (int i = 0; i < strStatusTypeValues.length; i++) {
			objWaitForElement.waitForElements("//input[@value='" + strStatusTypeValues[i]
					+ "'][@name='statusTypeID']", "xpath");
			assertTrue(this.page
					.dynamicElement(
							"StatusTypeValues",
							"//input[@value='" + strStatusTypeValues[i]
									+ "'][@name='statusTypeID']", "xpath")
					.getOne().isDisplayed());
		}

		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify Error message in create adhoc
	 * event page Date : 11/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifyPastTimeErrorMessageInCreateAdhocEventPage()
			throws Exception {
		objWaitForElement.waitForElements(adhocEventPastTimeErrorMessage, "xpath");
		assertTrue(this.page.element(adhocEventPastTimeErrorMessage, "xpath")
				.getOne().isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click event end radio button Date :
	 * 11/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement clickEventEndRadioButton() throws Exception {
		objWaitForElement.waitForElements(eventEndRadioButton, "css");
		this.page.element(eventEndRadioButton, "css").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to select Event EndD ay Date : 11/06/2014
	 * Author : Anitha
	 **********************************************************************************/
	public EventManagement selectEventEndDay(String strEndDay) throws Exception {
		if(strEndDay.startsWith("0")){
			strEndDay = strEndDay.replace("0", "");
		}
		this.page.element(eventEndDay, "name").webElementToSelect()
				.selectByVisibleText(strEndDay);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to select strEndYear Date : 11/06/2014
	 * Author : Anitha
	 **********************************************************************************/
	public EventManagement selectEventEndYear(String strEndYear)
			throws Exception {
		this.page.element(eventEndYear, "name").webElementToSelect()
				.selectByVisibleText(strEndYear);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to select Event End Hour Date : 11/06/2014
	 * Author : Anitha
	 **********************************************************************************/
	public EventManagement selectEventEndHour(String strEndhour)
			throws Exception {
		this.page.element(eventEndHour, "name").webElementToSelect()
				.selectByVisibleText(strEndhour);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to select Event minuter Date : 11/06/2014
	 * Author : Anitha
	 **********************************************************************************/
	public EventManagement selectEventEndMinute(String strEndMinute)
			throws Exception {
		this.page.element(eventEndMinute, "name").webElementToSelect()
				.selectByVisibleText(strEndMinute);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify Event details Date : 09/06/2014
	 * Author : Anil
	 **********************************************************************************/
	public EventManagement verifyEventDetails(String strEventName,
			String strEventStartTime, String strEventEndTime) throws Exception {
		this.verifyEventName(strEventName);
		this.verifyEventStartTime(strEventName, strEventStartTime);
		this.verifyEventEndTime(strEventName, strEventEndTime);
		this.verifyEndEventIsNotDisplayed(strEventName);
		this.verifyEditEventIsNotDisplayed(strEventName);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to create an AdHoc Event Date : 09/06/2014
	 * Author : Anil
	 **********************************************************************************/
	public EventManagement enterAdHocEventDetails(String strEventName,
			String strEventDescription) throws Exception {
		this.enterAdHocEventName(strEventName);
		this.enterAdHocEventDescription(strEventDescription);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to get event start month Date : 09/06/2014
	 * Author : Anil
	 **********************************************************************************/
	public String getEventStartMonth() throws Exception {
		String strstartMonth = this.page.element(startMonth, "xpath").getOne()
				.getText();
		return strstartMonth;
	}

	/**********************************************************************************
	 * Description : This function is to get event start date Date : 09/06/2014
	 * Author : Anil
	 **********************************************************************************/
	public String getEventStartDay() throws Exception {
		String strstartDay = this.page.element(startDay, "xpath").getOne()
				.getText();
		return strstartDay;
	}

	/**********************************************************************************
	 * Description : This function is to get event start date88 Date :
	 * 09/06/2014 Author : Anil
	 **********************************************************************************/
	public String getEventStartYear() throws Exception {
		String strstartYear = this.page.element(startYear, "xpath").getOne()
				.getText();
		return strstartYear;
	}

	/**********************************************************************************
	 * Description : This function is to get event start hour Date : 09/06/2014
	 * Author : Anil
	 **********************************************************************************/
	public String getEventStartHour() throws Exception {
		String strstartHour = this.page.element(startHour, "xpath").getOne()
				.getText();
		return strstartHour;
	}

	/**********************************************************************************
	 * Description : This function is to get event start minute Date :
	 * 09/06/2014 Author : Anil
	 **********************************************************************************/
	public String getEventStartMinutes() throws Exception {
		String strstartMinute = this.page.element(startMinute, "xpath")
				.getOne().getText();
		return strstartMinute;
	}

	/**********************************************************************************
	 * Description : This function is to enter event end time in hours Date :
	 * 09/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement enterEventEndTime(String strEventEndTimeInHours)
			throws Exception {
		this.page.element(eventEndTimeInHours, "name").clearInputValue()
				.sendKeys(strEventEndTimeInHours);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to get event startDate and time Date :
	 * 09/06/2014 Author : Anil
	 **********************************************************************************/
	public String getEventStartDateAndTime() throws Exception {
		String strEventTime[] = new String[5];
		strEventTime[0] = this.getEventStartDay();
		strEventTime[1] = this.getEventStartMonth();
		strEventTime[2] = this.getEventStartYear();
		strEventTime[3] = this.getEventStartHour();
		strEventTime[4] = this.getEventStartMinutes();
		String strStartEventDateAndTime = strEventTime[2] + "-"
				+ strEventTime[1] + "-" + strEventTime[0] + " "
				+ strEventTime[3] + ":" + strEventTime[4];
		return strStartEventDateAndTime;
	}

	/**********************************************************************************
	 * Description : This function is to verify 'Select Resources' option is
	 * displayed Date : 10/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifySelectResourcesDisplayed() throws Exception {
		objWaitForElement.waitForElements(selectResources, "xpath");
		assertTrue(this.page.element(selectResources, "xpath").getOne()
				.isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify 'Select Resources' option is
	 * displayed Date : 10/06/2014 Author : Renushree
	 **********************************************************************************/
	public EventManagement verifySearchResourcesTypeDisplayed()
			throws Exception {
		objWaitForElement.waitForElements(searchResourceType, "css");
		assertTrue(this.page.element(searchResourceType, "css").getOne()
				.isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify 'Resource Name' Header option is
	 * displayed Date : 10/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifyResourceNameHeaderDisplayed() throws Exception {
		objWaitForElement.waitForElements(resourceNameHeader, "xpath");
		assertTrue(this.page.element(resourceNameHeader, "xpath").getOne()
				.isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify 'Resource Name' is displayed in
	 * the list Date : 10/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifyResourceNameDisplayed() throws Exception {
		objWaitForElement.waitForElements(resourceName, "xpath");
		assertTrue(this.page.element(resourceName, "xpath").getOne()
				.isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify first 'Resource Name' name is
	 * displayed Date : 10/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifyResourceDetails() throws Exception {
		// this.verifySelectResourcesDisplayed();
		this.verifySearchResourcesTypeDisplayed();
		this.verifyResourceNameDisplayed();
		this.verifyResourceNameHeaderDisplayed();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify 'Select Status Types' option is
	 * displayed Date : 10/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifySelectStatusTypesDisplayed() throws Exception {
		objWaitForElement.waitForElements(selectStatusTypes, "xpath");
		assertTrue(this.page.element(selectStatusTypes, "xpath").getOne()
				.isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify 'Select Status Types' option is
	 * displayed Date : 10/06/2014 Author : Renushree
	 **********************************************************************************/
	public EventManagement verifyStatusTypeTableDisplayed() throws Exception {
		objWaitForElement.waitForElements(statusTypeIdTable, "css");
		assertTrue(this.page.element(statusTypeIdTable, "css").getOne()
				.isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify 'Name' Header option is
	 * displayed Date : 10/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifyStatusTypeNameHeaderDisplayed()
			throws Exception {
		objWaitForElement.waitForElements(statusTypeNameHeader, "xpath");
		assertTrue(this.page.element(statusTypeNameHeader, "xpath").getOne()
				.isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify first 'Status type' name is
	 * displayed Date : 10/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifyStatusTypeNameDisplayed() throws Exception {
		assertTrue(this.page.element(statusTypeName, "xpath").getOne()
				.isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify first 'Status type' name is
	 * displayed Date : 10/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifyStatusTypeDetails() throws Exception {
		this.verifyStatusTypeTableDisplayed();
		this.verifyStatusTypeNameDisplayed();
		this.verifyStatusTypeNameHeaderDisplayed();
		this.verifySelectStatusTypesDisplayed();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify 'AdHoc Event Confirmation'
	 * header is displayed Date : 10/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifyAdHocEventConfirmationDisplayed()
			throws Exception {
		objWaitForElement.waitForElements(adHocEventConfirmation, "xpath");
		assertTrue(this.page.element(adHocEventConfirmation, "xpath").getOne()
				.isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on event mane present in Event
	 * Banner Date : 10/06/2014 Author : Anil
	 **********************************************************************************/
	public EventStatus clickOnEventNameInEventBanner(String strEventName)
			throws Exception {
		/*objWaitForElement.waitForElements("//div[@id='eventsBanner']/table[@class='events']//a[text()='"
				+ strEventName + "']", "xpath");
		this.page
		.element(
				"//div[@id='eventsBanner']/table[@class='events']//a[text()='"
						+ strEventName + "']", "xpath").mouseOver();
		this.page
				.element(
						"//div[@id='eventsBanner']/table[@class='events']//a[text()='"
								+ strEventName + "']", "xpath").getOne()
				.sendKeys(Keys.ENTER);
		return new EventStatus(this.driver);*/

		WebDriverWait wait = new WebDriverWait(driver,
				WaitTimeConstants.WAIT_TIME_LONG);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//div[@id='eventsBanner']/table[@class='events']//a[text()='"
						+ strEventName + "']")));

		this.page.element(
				"//div[@id='eventsBanner']/table[@class='events']//a[text()='"
						+ strEventName + "']", "xpath").mouseOver();
		this.page
				.element(
						"//div[@id='eventsBanner']/table[@class='events']//a[text()='"
								+ strEventName + "']", "xpath").getOne()
				.sendKeys(Keys.ENTER);
		return new EventStatus(this.driver);
	}

	/**********************************************************************************
	 * Description : This function is to select 'Event End' by selecting End
	 * Date Date : 10/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement selectEventEndDate() throws Exception {
		this.page.element(eventEndDate, "css").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to select 'Event End' by selecting End
	 * Month Date : 10/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement selectEventEndMonth(String strEventEndMonth)
			throws Exception {
		this.page.element(eventEndMonth, "css").webElementToSelect()
				.selectByVisibleText(strEventEndMonth);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to select 'Event End' and to select date
	 * and time from the dropdown Date : 10/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement selectEventEndDateAndTime(
			String[] strEventEndDateAndTime) throws Exception {
		this.selectEventEndDate();
		this.selectEventEndDay(strEventEndDateAndTime[2]);
		this.selectEventEndMonth(strEventEndDateAndTime[1]);
		this.selectEventEndYear(strEventEndDateAndTime[0]);
		this.selectEventEndHour(strEventEndDateAndTime[3]);
		this.selectEventEndMinute(strEventEndDateAndTime[4]);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to select 'Event Start' by selecting Start
	 * Date Date : 10/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement selectEventStartDate() throws Exception {
		this.page.element(eventStartDate, "xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to select 'Event Start' by selecting Start
	 * Month Date : 10/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement selectEventStartMonth(String strEventStartMonth)
			throws Exception {
		this.page.element(eventStartMonth, "css").webElementToSelect()
				.selectByVisibleText(strEventStartMonth);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to select 'Event Start' by selecting Start
	 * Day Date : 10/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement selectEventStartDay(String strEventStartDay)
			throws Exception {
		if(strEventStartDay.startsWith("0")){
			strEventStartDay = strEventStartDay.replace("0", "");
		}
		this.page.element(eventStartDay, "css").webElementToSelect()
				.selectByVisibleText(strEventStartDay);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to select 'Event Start' by selecting Start
	 * Year Date : 10/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement selectEventStartYear(String strEventStartYear)
			throws Exception {
		this.page.element(eventStartYear, "css").webElementToSelect()
				.selectByVisibleText(strEventStartYear);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to select 'Event Start' by selecting Start
	 * Hour Date : 10/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement selectEventStartHour(String strEventStartHour)
			throws Exception {
		this.page.element(eventStartHour, "css").webElementToSelect()
				.selectByVisibleText(strEventStartHour);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to select 'Event Start' by selecting Start
	 * Minute Date : 10/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement selectEventStartMinute(String strEventStartMinute)
			throws Exception {
		this.page.element(eventStartMinute, "css").webElementToSelect()
				.selectByVisibleText(strEventStartMinute);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to select 'Event Start' and to select date
	 * and time from the dropdown Date : 10/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement selectEventStartDateAndTime(
			String[] strEventStartDateAndTime) throws Exception {
		this.selectEventStartDate();
		this.selectEventStartDay(strEventStartDateAndTime[2]);
		this.selectEventStartMonth(strEventStartDateAndTime[1]);
		this.selectEventStartYear(strEventStartDateAndTime[0]);
		this.selectEventStartHour(strEventStartDateAndTime[3]);
		this.selectEventStartMinute(strEventStartDateAndTime[4]);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify error message is displayed for
	 * providing same start and end date. Date : 10/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifyErrorMessageForSameStartAndEndDate()
			throws Exception {
		objWaitForElement.waitForElements(messageForSameStartAndEndDate, "xpath");
		assertTrue(this.page.element(messageForSameStartAndEndDate, "xpath")
				.getOne().isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify 'Edit' option is not displayed
	 * for an Event Date : 09/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement clickOnEndEvent(String strEventName)
			throws Exception {
		
		objWaitForElement.waitForElements("//table/tbody/tr/td[7][text()='" + strEventName
				+ "']/preceding-sibling::td[6]/a[text()='End']", "xpath");
		this.page
		.dynamicElement(
				"EventEditLink",
				"//table/tbody/tr/td[7][text()='" + strEventName
						+ "']/preceding-sibling::td[6]/a[text()='End']",
				"xpath").mouseOver();
		this.page
				.dynamicElement(
						"EventEditLink",
						"//table/tbody/tr/td[7][text()='" + strEventName
								+ "']/preceding-sibling::td[6]/a[text()='End']",
						"xpath").getOne().sendKeys(Keys.ENTER);
		Thread.sleep(8000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(5000);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify 'View History' option is
	 * displayed for an Event Date : 09/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifyViewHistoryLink(String strEventName)
			throws Exception {
		Thread.sleep(10000);
		driver.manage().timeouts()
				.implicitlyWait(WaitTimeConstants.COUNT, TimeUnit.SECONDS);
		objWaitForElement.waitForElements("//table/tbody/tr/td[7][text()='"
				+ strEventName
				+ "']/preceding-sibling::td[6]/a[text()='View History']",
		"xpath");
		assertTrue(this.page
				.dynamicElement(
						"EventEditLink",
						"//table/tbody/tr/td[7][text()='"
								+ strEventName
								+ "']/preceding-sibling::td[6]/a[text()='View History']",
						"xpath").getOne().isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to navigate To EventManagement Page Date :
	 * 09/06/2014 Author : Anil
	 **********************************************************************************/

	public EventManagement navigateToEventManagementNew() throws Exception {
//		objWaitForElement.waitForElements("//table[@class='footer']/tbody/tr/td[3]", "xpath");
//		if(this.page.element("//table[@class='footer']/tbody/tr/td[3][contains(text(),'Shruti')]", "xpath").isElementPresent()==true){
//			
//		}
//		else{
		objWaitForElement.waitForElements(eventLink1, "xpath");
		this.page.element(eventLink1, "xpath").getOne().click();
		if(this.page.element(eventManagement, "xpath").isElementPresent()==false){
			this.page.element(eventLink1, "xpath").clickUsingJSE();
		}
		objWaitForElement.waitForElements(eventManagement, "xpath");
		this.page.element(eventManagement, "xpath").getOne().click();
//		}
		return new EventManagement(this.driver);
	}

	/**********************************************************************************
	 * Description : This function is to click event end radio button Date :
	 * 11/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement clickEventNeverEndRadioButton() throws Exception {
		objWaitForElement.waitForElements(eventNeverEndRadioButton, "css");
		this.page.element(eventNeverEndRadioButton, "css").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify Resource in event banner Date :
	 * 11/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifyResourcesInEventBanner(String strResourceName)
			throws Exception {
		objWaitForElement.waitForElements("//table[starts-with(@id,'rtt')]/tbody/tr/td[2]/a[text()='"
				+ strResourceName + "']", "xpath");
		assertTrue(this.page
				.dynamicElement(
						"StatusTypeValues",
						"//table[starts-with(@id,'rtt')]/tbody/tr/td[2]/a[text()='"
								+ strResourceName + "']", "xpath").getOne()
				.isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify resource Date : 11/06/2014
	 * Author : Anil
	 **********************************************************************************/
	public EventManagement verifyStatusTypesInEventBanner(
			String[] strStatusTypeNames, String strResourceTypeName)
			throws Exception {
		for (int i = 0; i < strStatusTypeNames.length; i++) {
			assertEquals(
					this.page
							.dynamicElement(
									"StatusTypeValues",
									"//table[starts-with(@id,'rtt')]/thead/tr/th[2]/a[text()='"
											+ strResourceTypeName
											+ "']/ancestor::tr/th[" + (i + 3)
											+ "]", "xpath").getOne().getText(),
					strStatusTypeNames[i]);
		}
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify Resource in event banner Date :
	 * 11/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifyResourceTypeInEventBanner(
			String strResourceTypeName) throws Exception {
		assertTrue(this.page
				.dynamicElement(
						"StatusTypeValues",
						"//table[starts-with(@id,'rtt')]/thead/tr/th[2]/a[text()='"
								+ strResourceTypeName + "']", "xpath").getOne()
				.isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on 'keep' button Date :
	 * 09/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement clickOnKeepButton() throws Exception {
		objWaitForElement.waitForElements(keepButton, "css");
		this.page.element(keepButton, "css").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify 'Create AdHoc Event' Button is
	 * not displayed Date : 18/06/2014 Author : Sowmya
	 **********************************************************************************/
	public EventManagement deSelectCheckBoxOfDisplayInEventBanner()
			throws Exception {
		objWaitForElement.waitForElements(checkBoxOfDisplayInEventBanner, "xpath");
		if (this.page.element(checkBoxOfDisplayInEventBanner, "xpath").getOne()
				.isSelected()) {
			this.page.element(checkBoxOfDisplayInEventBanner, "xpath").getOne()
					.click();
		}
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify resource name Date : 18/06/2014
	 * Author : Sowmya
	 **********************************************************************************/
	public EventManagement verifyResourceNameInSelectResourcePage(
			String[] strResourceName) throws Exception {
		for (int i = 0; i < strResourceName.length; i++) {
			objWaitForElement.waitForElements(
					"//table[@id='tbl_resourceID']/tbody/tr/td[2][text()='"
							+ strResourceName[i] + "']", "xpath");
			assertTrue(this.page
					.element(
							"//table[@id='tbl_resourceID']/tbody/tr/td[2][text()='"
									+ strResourceName[i] + "']", "xpath")
					.getOne().isDisplayed());
		}

		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify Start time is displayed for an
	 * Event Date : 18/06/2014 Author : Sowmya
	 **********************************************************************************/
	public String verifyEventStartTimeNew(String strEventName,
			String strEventStartTime) throws Exception {
		String strEventStartTimeAddOneMin = objDts
				.AddTimeToExistingTimeHourAndMin(strEventStartTime, 0, 1,
						"yyyy-MM-dd HH:mm");
		String strEventStartTimeAddTwoMin = objDts
				.AddTimeToExistingTimeHourAndMin(strEventStartTime, 0, 2,
						"yyyy-MM-dd HH:mm");
		String strActualTime = this.page
				.element(
						"//table/tbody/tr/td[7][text()='" + strEventName
								+ "']/preceding-sibling::td[2]", "xpath")
				.getOne().getText();
		assertTrue((strActualTime.equals(strEventStartTime))
				|| (strActualTime.equals(strEventStartTimeAddOneMin))
				|| (strActualTime.equals(strEventStartTimeAddTwoMin)));
		return strActualTime;
	}

	/**********************************************************************************
	 * Description : This function is to verify resource name Date : 18/06/2014
	 * Author : Sowmya
	 **********************************************************************************/
	public EventManagement verifyStatusTypesNameInSelectStausTypePage(
			String[] strStatusTypesName) throws Exception {
		for (int i = 0; i < strStatusTypesName.length; i++) {
			objWaitForElement.waitForElements("//a[contains(text(),'"
					+ strStatusTypesName[i] + "')]", "xpath");
			assertTrue(this.page.element(
					"//a[contains(text(),'"
							+ strStatusTypesName[i] + "')]", "xpath")
					.isElementPresent());
		}
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify error message is displayed for
	 * Maintain Ad Hoc Events Date : 17/06/2014 Author : Sowmya
	 **********************************************************************************/
	public EventManagement verifyErrorMsgForMaintainAdHocEvents()
			throws Exception {
		objWaitForElement.waitForElements(errorMsgOfMaintainAdHocEvents, "xpath");
		assertEquals(
				"A user with 'Maintain Ad Hoc Events' right must also have the 'Maintain Events' right!",
				this.page.element(errorMsgOfMaintainAdHocEvents, "xpath")
						.getOne().getText());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on 'Edit' link Date : 19/06/2014
	 * Author : Sowmya
	 **********************************************************************************/
	public EventManagement clickOnEditLink(String strEventName)
			throws Exception {
		objWaitForElement.waitForElements(
				"//div[@id='mainContainer']/table/tbody/tr/td[7][text()='"
						+ strEventName
						+ "']/parent::tr/td[1]/a[1][text()='Edit']", "xpath");
		this.page
				.element(
						"//div[@id='mainContainer']/table/tbody/tr/td[7][text()='"
								+ strEventName
								+ "']/parent::tr/td[1]/a[1][text()='Edit']",
						"xpath").getOne().sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify 'Edit' link Date : 19/06/2014
	 * Author : Sowmya
	 **********************************************************************************/
	public EventManagement verifyEditEventLink(String strEventName)
			throws Exception {

		objWaitForElement.waitForElements("//div[@id='mainContainer']/table/tbody/tr/td[7][text()='"
				+ strEventName
				+ "']/parent::tr/td[1]/a[1][text()='Edit']",
		"xpath");
		assertEquals(
				"Edit",
				this.page
						.element(
								"//div[@id='mainContainer']/table/tbody/tr/td[7][text()='"
										+ strEventName
										+ "']/parent::tr/td[1]/a[1][text()='Edit']",
								"xpath").getOne().getText());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify 'End' link Date : 19/06/2014
	 * Author : Sowmya
	 **********************************************************************************/
	public EventManagement verifyEndEventLink(String strEventName)
			throws Exception {

		objWaitForElement.waitForElements("//div[@id='mainContainer']/table/tbody/tr/td[7][text()='"
				+ strEventName
				+ "']/parent::tr/td[1]/a[2][text()='End']","xpath");
		assertEquals(
				"End",
				this.page
						.element(
								"//div[@id='mainContainer']/table/tbody/tr/td[7][text()='"
										+ strEventName
										+ "']/parent::tr/td[1]/a[2][text()='End']",
								"xpath").getOne().getText());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify 'Cancel' link Date : 19/06/2014
	 * Author : Sowmya
	 **********************************************************************************/
	public EventManagement verifyCancelEventLink(String strEventName)
			throws Exception {

		objWaitForElement.waitForElements(
				"//div[@id='mainContainer']/table/tbody/tr/td[7][text()='"
						+ strEventName
						+ "']/parent::tr/td[1]/a[2][text()='Cancel']", "xpath");
		assertEquals(
				"Cancel",
				this.page
						.element(
								"//div[@id='mainContainer']/table/tbody/tr/td[7][text()='"
										+ strEventName
										+ "']/parent::tr/td[1]/a[2][text()='Cancel']",
								"xpath").getOne().getText());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify error message is displayed for
	 * event banner Date : 18/06/2014 Author : Sowmya
	 **********************************************************************************/
	public EventManagement verifyErrorMsgForEventBanner() throws Exception {
		objWaitForElement.waitForElements(errorMsgForEventBanner, "xpath");
		assertEquals(
				"At least one resource must be selected for an event that is not displayed in the event banner.",
				this.page.element(errorMsgForEventBanner, "xpath").getOne()
						.getText());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on 'Previous' Button Date :
	 * 18/06/2014 Author : Sowmya
	 **********************************************************************************/
	public EventManagement clickOnPreviousButton() throws Exception {
		objWaitForElement.waitForElements(previousButton, "xpath");
		this.page.element(previousButton, "xpath").mouseOver();
		/*this.page.element(previousButton, "xpath").getOne()
				.sendKeys(Keys.RETURN);*/
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				driver.findElement(By.xpath(previousButton)));
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on 'Modify' button Date :
	 * 09/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement clickOnModifyButton() throws Exception {
		objWaitForElement.waitForElements(modifyButton, "css");
		this.page.element(modifyButton, "css").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to select 'Event End' by selecting End
	 * Date Date : 10/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement selectEventEndHourOption() throws Exception {
		objWaitForElement.waitForElements(endTypeInHours, "xpath");
		this.page.element(endTypeInHours, "xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on 'Create New Event' button Date
	 * Date : 28/07/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement clickOnCreateNewEvent() throws Exception {
		
//		if(this.page.element("//table[@class='footer']/tbody/tr/td[3][contains(text(),'Shruti')]", "xpath").isElementPresent()==true){
//			blnCheck = true;
//			Login login_page1 = new Login(this.driver);
//			UsersList UsersList_page = new UsersList(this.driver);
//			RegionDefault RegionDefault_page = new RegionDefault(this.driver);
//			SelectRegion objSelectRegion = new SelectRegion(this.driver);
//			User_data objUser_data = new User_data();
//			Login_data objTest_data = new Login_data();
//			//New user
//			String strNewUser = "Auto"+System.currentTimeMillis();
//			String strFNNewUser = "FN"+strNewUser;
//			
//			UsersList_page
//					.navigateToUsers()
//					.clickCreateNewUserButton();
//
//			UsersList_page.enterUserDetails(strNewUser,
//							objUser_data.strNewPassword, strFNNewUser)
//					.selectFirstRole()
//					.clickAdvancedOptionAndExpand()
//					.selectMaintainEventsOption()
//					.clickSaveButton();
//			Thread.sleep(3000);
//			String strRegionNAme = objSelectRegion.getRegionName();
//			
//			login_page1.clickLogOut();
//			
//			login_page1.loginAsNewUser(strNewUser, objUser_data.strNewPassword);
//			RegionDefault_page.selectFrame();
//			
//			this.navigateToEventManagement();
//		}
		objWaitForElement.waitForElements(createNewEvent, "css");
		this.page.element(createNewEvent, "css").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on 'Create' link of particular
	 * Event Template Button Banner Date : 08/07/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement clickOnCreateEvent(String strEveTemplate)
			throws Exception {
		
		String strCreateEventLink = "//div[@id='mainContainer']/table/tbody/tr/td[text()='"
				+ strEveTemplate
				+ "']/preceding-sibling::td/a[text()='Create']";
		objWaitForElement.waitForElements(strCreateEventLink,"xpath");
		
		WebElement element = driver.findElement(By.xpath(strCreateEventLink));
		
		this.page.element(strCreateEventLink,"xpath").scrollDownTillElement(element);

		this.page.dynamicElement(
				"Create link of ET " + strEveTemplate,strCreateEventLink,
				"xpath").mouseOver();
		this.page
		.element(strCreateEventLink,
				"xpath").getOne().click();
		if((this.page.element(adHocEventName, "name").isElementPresent())==false){
			Actions action = new Actions(driver);
			action.moveToElement(this.page.element(strCreateEventLink, "xpath").getOne()).perform();
			this.page
			.element(strCreateEventLink,
					"xpath").getOne().click();
		}
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on 'Save' button Date :28/07/2014
	 * Author : Anil
	 **********************************************************************************/
	public EventManagement clickOnSaveButton() throws Exception {
		objWaitForElement.waitForElements(saveButton, "css");
		this.page.element(saveButton, "css").getOne().click();
		
		if(blnCheck==true){
		Login login_page1 = new Login(this.driver);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver);
		SelectRegion objSelectRegion = new SelectRegion(this.driver);
		Login_data objTest_data = new Login_data();
		String strRegionNAme = this.page.element("//div[@id='regionName']", "xpath").getOne().getText();
		strRegionNAme = strRegionNAme.replace("(TEST)", "");
		strRegionNAme= strRegionNAme.trim();
		login_page1.clickLogOut()
		
		.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);
		RegionDefault_page.selectFrame();
		objSelectRegion.selectRegionAndNavigate(strRegionNAme);
		
		RegionDefault_page.selectFrame();
		this.navigateToEventList();
		blnCheck = false;
		}

		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify EventName is displayed in event
	 * banner Date : 28/07/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifyEventNameInEventBanner(String strEventName)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='eventsBanner']/table[@class='events']//a[text()='"
				+ strEventName + "']", "xpath");
		assertTrue(this.page
				.dynamicElement(
						strEventName + " is displayed in event banner",
						"//div[@id='eventsBanner']/table[@class='events']//a[text()='"
								+ strEventName + "']", "xpath").getOne()
				.isDisplayed());

		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify 'Create New Event' page is
	 * displayed Date : 28/07/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifyCreateEventPage() throws Exception {
		objWaitForElement.waitForElements(createNewEventPage, "xpath");
		assertTrue(this.page.element(createNewEventPage, "xpath").getOne()
				.isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify web notification frame Banner
	 * Date : 10/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verWebNotificationframe() throws Exception {
		WebDriverWait wait = new WebDriverWait(this.driver,
				WaitTimeConstants.WAIT_TIME_LONG);
		wait.until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt("TB_iframeContent"));
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify web notification Banner Date :
	 * 10/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verWebNotificationAndAcknowledge(
			String strEventName, String strEventDesc) throws Exception {
		objWaitForElement.waitForElements("dt.othr", "css");
		this.page.element("dt.othr", "css").getOne().isDisplayed();
		this.page.element("dd.desc", "css").getOne().isDisplayed();
		assertEquals(strEventName, this.page.element("dt.othr", "css").getOne()
				.getText());
		assertEquals(strEventDesc, this.page.element("dd.desc", "css").getOne()
				.getText());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on acknowledge nootification Date
	 * : 10/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement clickAcknowledgeAllNotifications() throws Exception {
		objWaitForElement.waitForElements(acknowlwdgeNotification, "xpath");
		this.page.element(acknowlwdgeNotification, "xpath").getOne().click();
		Thread.sleep(5000);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on acknowledge nootification Date
	 * : 10/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement selectFrame() throws Exception {
		driver.switchTo().window("");
		WebDriverWait wait = new WebDriverWait(this.driver,
				WaitTimeConstants.WAIT_TIME_LONG);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(strFrame));
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify on 'Create' link of particular
	 * Event Template Button Banner Date : 08/07/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifyEventTemplateIsDisplayed(String strEveTemplate)
			throws Exception {
		objWaitForElement.waitForElements(
				"//div[@id='mainContainer']/table/tbody/tr/td[text()='"
						+ strEveTemplate
						+ "']/preceding-sibling::td/a[text()='Create']",
				"xpath");
		assertTrue(this.page
				.dynamicElement(
						"Create link of ET " + strEveTemplate,
						"//div[@id='mainContainer']/table/tbody/tr/td[text()='"
								+ strEveTemplate
								+ "']/preceding-sibling::td/a[text()='Create']",
						"xpath").getOne().isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify Event management is displayed
	 * Date : 09/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifyEventManagementPage() throws Exception {
		objWaitForElement.waitForElements(eventManagementPage, "xpath");
		assertTrue(this.page.element(eventManagementPage, "xpath").getOne()
				.isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify select Event Template Page is
	 * displayed Date : 09/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifySelectEventTemplatePage() throws Exception {
		objWaitForElement.waitForElements(selectEventTemplatePage, "xpath");
		assertTrue(this.page.element(selectEventTemplatePage, "xpath").getOne()
				.isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on 'create New Multi Event'
	 * Button Date : 04/08/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement createNewMultiEventButton() throws Exception {
		objWaitForElement.waitForElements(createNewMultiEvent, "xpath");
		this.page.element(createNewMultiEvent, "xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to enter Event description Date :
	 * 09/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement selectEventTemplateForMRE(String strRegionValue,
			String strEventTemplate) throws Exception {
		objWaitForElement.waitForElement("//select[@name='region-" + strRegionValue + "']");
		this.page
				.element("//select[@name='region-" + strRegionValue + "']",
						"xpath").webElementToSelect()
				.selectByVisibleText(strEventTemplate);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify 'Create AdHoc Event' Button is
	 * not displayed Date : 09/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifyCreateNewMultiRegionEventButtonNotDisplayed()
			throws Exception {
		assertFalse(this.page.element(createMultiRegionEventButton, "css")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify create adhoc event page Date :
	 * 11/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifyCreateMultiRegionEventPage() throws Exception {
		objWaitForElement.waitForElements(
				"//div[@id='topSubNav']/h1[text()='Create Multi-Region Event']",
				"xpath");
		assertTrue(this.page
				.element(
						"//div[@id='topSubNav']/h1[text()='Create Multi-Region Event']",
						"xpath").isElementPresent());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to deselect on 'include All Resources'
	 * Button Date : 04/08/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement deselectIncludeAllResourcesOption() throws Exception {
		objWaitForElement.waitForElements(includeAllResources, "name");
		if (this.page.element(includeAllResources, "name").getOne()
				.isSelected()) {
			this.page.element(includeAllResources, "name").getOne().click();
		}
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify region name is displayed Date
	 * :07/08/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifyRegionName(String strRegionName)
			throws Exception {
		objWaitForElement.waitForElements(header, "css");
		assertEquals("Select Resources - " + strRegionName,
				this.page.element(header, "css").getOne().getText());
		Thread.sleep(7000);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify Resource name and resource type
	 * Date :07/08/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifyRSAndRTName(String strResourceName,
			String strResourceType) throws Exception {
		objWaitForElement.waitForElements(
				"//table[@id='tbl_resourceID']//td[2][text()='"
						+ strResourceName
						+ "']/following-sibling::td[1][text()='"
						+ strResourceType + "']", "xpath");
		assertTrue(this.page
				.dynamicElement(
						strResourceName,
						"//table[@id='tbl_resourceID']//td[2][text()='"
								+ strResourceName
								+ "']/following-sibling::td[1][text()='"
								+ strResourceType + "']", "xpath").getOne()
				.isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify Multi-Region Event Confirmation
	 * page Date : 06/08/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifyMultiRegionEventConfirmationPage()
			throws Exception {
		objWaitForElement.waitForElements(MREConfirmationPage, "xpath");
		assertTrue(this.page.element(MREConfirmationPage, "xpath")
				.isElementPresent());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify Multi-Region Event Confirmation
	 * page Date : 06/08/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifyRegionAndETName(String strRegionName,
			String strEventTemplate) throws Exception {
		objWaitForElement.waitForElements("//table//td[text()='" + strRegionName
				+ "']/following-sibling::td[text()='"
				+ strEventTemplate + "']", "xpath");
		assertTrue(this.page
				.dynamicElement(
						strRegionName,
						"//table//td[text()='" + strRegionName
								+ "']/following-sibling::td[text()='"
								+ strEventTemplate + "']", "xpath").getOne()
				.isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify Confirmation message is
	 * displayed Date : 06/08/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifyConfirmationMessage() throws Exception {
		objWaitForElement.waitForElements(confirmationMessage, "xpath");
		assertEquals(
				"Are you sure you want to create this multi-region event?",
				this.page.element(confirmationMessage, "xpath").getOne()
						.getText());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify 'Yes' button Date : 09/06/2014
	 * Author : Anil
	 **********************************************************************************/
	public EventManagement verifyYesButton() throws Exception {
		objWaitForElement.waitForElements(yesButton, "css");
		assertTrue(this.page.element(yesButton, "css").getOne().isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify Event name and status is
	 * displayed in the list Date : 09/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifyEventStatus(String strEventName,
			String strEventStatus) throws Exception {
		objWaitForElement.waitForElements("//table/tbody/tr/td[7][text()='" + strEventName
				+ "']/preceding-sibling::td[3][text()='"
				+ strEventStatus + "']", "xpath");
		assertTrue(this.page
				.dynamicElement(
						"EventName",
						"//table/tbody/tr/td[7][text()='" + strEventName
								+ "']/preceding-sibling::td[3][text()='"
								+ strEventStatus + "']", "xpath").getOne()
				.isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify Event name and template is
	 * displayed in the list Date : 09/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifyEventNameAndTemplate(String strEventName,
			String strEventTemplateName) throws Exception {
		objWaitForElement.waitForElements("//table/tbody/tr/td[7][text()='" + strEventName
				+ "']/following-sibling::td[2][text()='"
				+ strEventTemplateName + "']", "xpath");
		assertTrue(this.page
				.dynamicElement(
						"EventName",
						"//table/tbody/tr/td[7][text()='" + strEventName
								+ "']/following-sibling::td[2][text()='"
								+ strEventTemplateName + "']", "xpath")
				.getOne().isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify Event details displayed in the
	 * table Date : 09/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifyMultiRegionEventDetails(String strEventName,
			String strEventStatus, String strEventTemplateName,
			String strEventStartTime, String strEventEndTime,
			String stMultiStatus) throws Exception {
		this.verifyEventName(strEventName);
		this.verifyEventNameAndTemplate(strEventName, strEventTemplateName);
		this.verifyEventStatus(strEventName, strEventStatus);
		this.verifyEventStartTime(strEventName, strEventStartTime);
		if (strEventEndTime.equals("never")) {
			this.verifyEventEndTimeWhenItSetToNever(strEventName,
					strEventEndTime);
		} else {
			this.verifyEventEndTime(strEventName, strEventEndTime);
		}
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify Edit AdHoc Event Screen is
	 * displayed Date : 12/08/2014 Author : Sowmya
	 **********************************************************************************/
	public EventManagement verifyEditAdHocEventScreenIsDisplayed()
			throws Exception {
		objWaitForElement.waitForElements(editAdhocEvent, "xpath");
		assertTrue(this.page.element(editAdhocEvent, "xpath").getOne()
				.isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify event template is not present
	 * Date : 13/08/2014 Author : Renushree
	 **********************************************************************************/
	public EventManagement verifyEventTemplateIsNotDisplayed(
			String strEveTemplate) throws Exception {
		assertFalse(
				this.page.element(
						"//div[@id='mainContainer']/table/tbody/tr/td[text()='"
								+ strEveTemplate + "']", "xpath")
						.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE), "Event template is dispalyed");
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify update in event banner Date :
	 * 13/08/2014 Author : Renushree
	 **********************************************************************************/
	public EventManagement verUpdateInEveBanner(String strEventName)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='eventsBanner']/table[@class='events']//a[text()='"
				+ strEventName + "']", "xpath");
		assertTrue(this.page.element(
				"//div[@id='eventsBanner']/table[@class='events']//a[text()='"
						+ strEventName + "']", "xpath").isElementPresent());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on 'Private' Checkbox Date :
	 * 13/08/2014 Author : Sowmya
	 **********************************************************************************/
	public EventManagement clickPrivateCheckBox() throws Exception {
		objWaitForElement.waitForElements(privateCheckBox, "css");
		this.page.element(privateCheckBox, "css").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to select Event minuter Arguments :
	 * strResource Date : 18/08/2014 Author : Renushree
	 **********************************************************************************/
	public EventManagement selectResource(String[] strResource)
			throws Exception {
		objWaitForElement.waitForElements("//input[@name='resourceID'][@value='"
				+ strResource[0] + "']", "xpath");
		for (int i = 0; i < strResource.length; i++) {
			while(!this.page
					.element(
							"//input[@name='resourceID'][@value='"
									+ strResource[i] + "']", "xpath").getOne().isSelected()){
			this.page
			.element(
					"//input[@name='resourceID'][@value='"
							+ strResource[i] + "']", "xpath").mouseOver();
			this.page
					.element(
							"//input[@name='resourceID'][@value='"
									+ strResource[i] + "']", "xpath").getOne()
					.click();
			}
		}
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify adress fields (state, country,
	 * city) are mandatory Date : 02/09/2014 Author : Renushree
	 **********************************************************************************/
	public EventManagement verAddressFieldsAreMandatory() throws Exception {
		objWaitForElement.waitForElements("//span[@class='emsReqField']/parent::td/following-sibling::td/input[@id='city']",
				"xpath");
		assertTrue(this.page
				.element(
						"//span[@class='emsReqField']/parent::td/following-sibling::td/input[@id='city']",
						"xpath").getOne().isDisplayed());
		objWaitForElement.waitForElements("//span[@class='emsReqField']/parent::td/following-sibling::td/select[@id='stateAbbrev']",
				"xpath");
		assertTrue(this.page
				.element(
						"//span[@class='emsReqField']/parent::td/following-sibling::td/select[@id='stateAbbrev']",
						"xpath").getOne().isDisplayed());
		objWaitForElement.waitForElements("//span[@class='emsReqField']/parent::td/following-sibling::td/select[@id='county']",
				"xpath");
		assertTrue(this.page
				.element(
						"//span[@class='emsReqField']/parent::td/following-sibling::td/select[@id='county']",
						"xpath").getOne().isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to enter city Date : 02/09/2014 Author :
	 * Renushree
	 **********************************************************************************/
	public EventManagement enterCity(String strCity) throws Exception {
		objWaitForElement.waitForElements(city, "css");
		this.page.element(city, "css").clearInputValue().sendKeys(strCity);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to enter state Date : 02/09/2014 Author :
	 * Renushree
	 **********************************************************************************/
	public EventManagement enterState(String strState) throws Exception {
		objWaitForElement.waitForElements(state, "css");
		this.page.element(state, "css").webElementToSelect()
				.selectByVisibleText(strState);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to enter country Date : 02/09/2014 Author
	 * : Renushree
	 **********************************************************************************/
	public EventManagement enterCountry(String strCountry) throws Exception {
		objWaitForElement.waitForElements(country, "css");
		this.page.element(country, "css").webElementToSelect()
				.selectByVisibleText(strCountry);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to enter country Date : 02/09/2014 Author
	 * : Renushree
	 **********************************************************************************/
	public EventManagement enterZipCode(String strZipcode) throws Exception {
		objWaitForElement.waitForElements(zipcode, "css");
		this.page.element(zipcode, "css").clearInputValue()
				.sendKeys(strZipcode);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to enter country Date : 02/09/2014 Author
	 * : Renushree
	 **********************************************************************************/
	public EventManagement clickOnLookUpAdd() throws Exception {
		objWaitForElement.waitForElements(lookUpAdd, "css");
		this.page.element(lookUpAdd, "css").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to enter country Date : 02/09/2014 Author
	 * : Renushree
	 **********************************************************************************/
	public EventManagement enterAddress(String strCity, String strState,
			String strCountry, String strZipcode) throws Exception {
		this.enterCity(strCity);
		this.enterState(strState);
		this.enterCountry(strCountry);
		this.enterZipCode(strZipcode);
		this.clickOnLookUpAdd();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify web notification Banner with
	 * address Date : 02/09/2014 Author : Renushree
	 **********************************************************************************/
	public EventManagement verWebNotificationWithAddress(String strEventName,
			String strEventDesc, String strCity, String strCountry,
			String strZipCode, String strCountryCode) throws Exception {
		objWaitForElement.waitForElements("dt.othr", "css");
		this.page.element("dt.othr", "css").getOne().isDisplayed();
		this.page.element("dd.desc", "css").getOne().isDisplayed();
		assertEquals(strEventName, this.page.element("dt.othr", "css").getOne()
				.getText());
		assertEquals(strEventDesc + "\nLocation: " + strCity + " "+strCountryCode+" "
				+ strZipCode + " " + strCountry + "",
				this.page.element("dd.desc", "css").getOne().getText());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to navigate To Event List Page Date :
	 * 01/09/2014 Author : Sowmya
	 **********************************************************************************/
	public EventManagement navigateToEventList() throws Exception {
		objWaitForElement.waitForElements(eventLink, "xpath");
		this.page.element(eventLink, "xpath").getOne().click();
		objWaitForElement.waitForElements(eventList, "xpath");
		this.page.element(eventList, "linktext").getOne().click();
		return new EventManagement(this.driver);
	}

	/**********************************************************************************
	 * Description : This function is to navigate To Event List Page Date :
	 * 01/09/2014 Author : Sowmya
	 **********************************************************************************/
	public EventManagement navigateToEventListNew() throws Exception {
		objWaitForElement.waitForElements(eventLink1, "xpath");
		this.page.element(eventLink1, "xpath").getOne().sendKeys(Keys.ENTER);
		objWaitForElement.waitForElements(eventList, "xpath");
		this.page.element(eventList, "linktext").getOne().sendKeys(Keys.ENTER);
		return new EventManagement(this.driver);
	}

	/**********************************************************************************
	 * Description : This function is to verify Event name is not displayed list
	 * Date : 01/09/2014 Author : Sowmya
	 **********************************************************************************/
	public EventManagement verifyEventNameNotDisplayed(String strEventName)
			throws Exception {
		assertFalse(this.page.dynamicElement("EventName",
				"//table/tbody/tr/td[7][text()='" + strEventName + "']",
				"xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify 'View' link is displayed Date :
	 * 01/09/2014 Author : Sowmya
	 **********************************************************************************/
	public EventManagement verifyViewLinkIsDisplayed(String strEventName)
			throws Exception {
		objWaitForElement.waitForElements(
				"//div[@id='mainContainer']/table/tbody/tr/td[7][text()='"
						+ strEventName
						+ "']/parent::tr/td[1]/a[1][text()='View']", "xpath");
		assertEquals(
				"View",
				this.page
						.element(
								"//div[@id='mainContainer']/table/tbody/tr/td[7][text()='"
										+ strEventName
										+ "']/parent::tr/td[1]/a[1][text()='View']",
								"xpath").getOne().getText());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify EventName is not displayed in
	 * event banner Date : 01/09/2014 Author : Sowmya
	 **********************************************************************************/
	public EventManagement verifyEventNameNotDisplayedInEventBanner(
			String strEventName) throws Exception {
		assertFalse(this.page.dynamicElement(
				strEventName + " is displayed in event banner",
				"//div[@id='eventsBanner']/table[@class='events']//a[text()='"
						+ strEventName + "']", "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));

		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify adress fields (state, country,
	 * city) are not mandatory Date : 02/09/2014 Author : Renushree
	 **********************************************************************************/
	public EventManagement verAddressFieldsAreNotMandatory() throws Exception {
		assertFalse(this.page
				.element(
						"//span[@class='emsReqField']/parent::td/following-sibling::td/input[@id='city']",
						"xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		assertFalse(this.page
				.element(
						"//span[@class='emsReqField']/parent::td/following-sibling::td/select[@id='stateAbbrev']",
						"xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_TOO_SMALL));
		assertFalse(this.page
				.element(
						"//span[@class='emsReqField']/parent::td/following-sibling::td/select[@id='county']",
						"xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_TOO_SMALL));
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify Status type value is checked and
	 * is disabled page Date : 03/09/2014 Author : Sinchana
	 **********************************************************************************/
	public EventManagement verifyStatusTypeIsSelectedAndChecked(
			String[] strStatusTypeValues) throws Exception {

		for (int i = 0; i < strStatusTypeValues.length; i++) {
			objWaitForElement.waitForElements(
					"input[disabled='disabled'][checked='checked'][value='"
							+ strStatusTypeValues[i] + "']", "css");
			assertTrue(this.page
					.dynamicElement(
							"StatusTypeValues",
							"input[disabled='disabled'][checked='checked'][value='"
									+ strStatusTypeValues[i] + "']", "css")
					.getOne().isDisplayed());

		}
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify Status type value is not
	 * checked,checkbox is enabled and clicked page Date : 03/09/2014 Author :
	 * Sinchana
	 **********************************************************************************/
	public EventManagement verifyStatusTypeIsDeSelectedAndChecked(
			String[] strStatusTypeValues) throws Exception {
		objWaitForElement.waitForElements("input[value='" + strStatusTypeValues[0] + "']",
				"css");
		for (int i = 0; i < strStatusTypeValues.length; i++) {
			if (this.page
					.element("input[value='" + strStatusTypeValues[i] + "']",
							"css").getOne().isSelected() == false);
			this.page
					.element("input[value='" + strStatusTypeValues[i] + "']",
							"css").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Event tilte' in Multi-Region Event Confirmation page 
	 * list Date   : 01/09/2014 
	 * Author      : Sowmya
	 **********************************************************************************/
	public EventManagement verifyEventTitleInMREC(String strMultiRegionEveName)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']//table/tbody/tr[1]/td[1][contains(text(),'Event Title:')]/following-sibling::td[text()='"
				+ strMultiRegionEveName + "']", "xpath");
		assertTrue(this.page
				.dynamicElement(
						"MultiRegionEventName",
						"//div[@id='mainContainer']//table/tbody/tr[1]/td[1][contains(text(),'Event Title:')]/following-sibling::td[text()='"
								+ strMultiRegionEveName + "']", "xpath")
				.getOne().isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify 'Event Information' in Multi-Region Event Confirmation page 
	 * list Date   : 01/09/2014 
	 * Author      : Sowmya
	 **********************************************************************************/
	public EventManagement verifyEventInformationInMREC(
			String strMultiRegionEveDescription) throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']//table/tbody/tr[2]/td[1][contains(text(),'Event Information')]/following-sibling::td[text()='"
				+ strMultiRegionEveDescription + "']", "xpath");
		assertTrue(this.page
				.dynamicElement(
						"MultiRegionDescription",
						"//div[@id='mainContainer']//table/tbody/tr[2]/td[1][contains(text(),'Event Information')]/following-sibling::td[text()='"
								+ strMultiRegionEveDescription + "']", "xpath")
				.getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Event Start date and time' in Multi-Region 
	 *               Event Confirmation page 
	 * list Date   : 01/09/2014 
	 * Author      : Sowmya
	 **********************************************************************************/
	public String verifyStartDateAndTimeInMREC(String strStartDateAndTime)
			throws Exception {

		Date_Time_settings objDate_Time_settings = new Date_Time_settings();
		String strTime[] = strStartDateAndTime.split(" ");
		String strEventStartTimeAddedOneMin = objDate_Time_settings
				.addTimetoExisting(strTime[1], 1, "HH:mm");

		String strEventStartTime1 = strTime[0] + " "
				+ strEventStartTimeAddedOneMin;

		String strDisplayedEveStartTime = this.page
				.dynamicElement(
						"StartDateAndTime",
						"//div[@id='mainContainer']//table/tbody/tr[3]/td[1][contains(text(),'Start Date and Time')]/following-sibling::td",
						"xpath").getOne().getText();

		assertTrue(strDisplayedEveStartTime.equals(strStartDateAndTime)
				|| strDisplayedEveStartTime.equals(strEventStartTime1));
		return strDisplayedEveStartTime;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Event End date and time' in Multi-Region 
	 *               Event Confirmation page 
	 * list Date   : 01/09/2014 
	 * Author      : Sowmya
	 **********************************************************************************/
	public EventManagement verifyEndDateAndTimeInMREC(String strEndDateAndTime)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']//table/tbody/tr[4]/td[1][contains(text(),'End Date and Time')]/following-sibling::td[text()='"
				+ strEndDateAndTime + "']", "xpath");
		assertTrue(this.page
				.dynamicElement(
						"EndDateAndTime",
						"//div[@id='mainContainer']//table/tbody/tr[4]/td[1][contains(text(),'End Date and Time')]/following-sibling::td[text()='"
								+ strEndDateAndTime + "']", "xpath")
				.getOne().isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify 'Attached file' option in Multi-Region 
	 *               Event Confirmation page 
	 * list Date   : 01/09/2014 
	 * Author      : Sowmya
	 **********************************************************************************/
	public EventManagement verifyAttachedFileOptionInMREC() throws Exception {
		objWaitForElement
				.waitForElements(
						"//div[@id='mainContainer']//table/tbody/tr[5]/td[1][contains(text(),'Attached File:')]",
						"xpath");
		assertTrue(this.page
				.dynamicElement(
						"AttachedFile",
						"//div[@id='mainContainer']//table/tbody/tr[5]/td[1][contains(text(),'Attached File:')]",
						"xpath").getOne().isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify 'Drill' option in Multi-Region 
	 *               Event Confirmation page 
	 * list Date   : 01/09/2014 
	 * Author      : Sowmya
	 **********************************************************************************/
	public EventManagement verifyDrillOptionInMREC() throws Exception {
		objWaitForElement
				.waitForElements(
						"//div[@id='mainContainer']//table/tbody/tr[6]/td[1][contains(text(),'Drill?')]",
						"xpath");
		assertTrue(this.page
				.dynamicElement(
						"Drill",
						"//div[@id='mainContainer']//table/tbody/tr[6]/td[1][contains(text(),'Drill?')]",
						"xpath").getOne().isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify 'End Quietly' option in Multi-Region 
	 *               Event Confirmation page 
	 * list Date   : 01/09/2014 
	 * Author      : Sowmya
	 **********************************************************************************/
	public EventManagement verifyEndQuietlyOptionInMREC() throws Exception {
		objWaitForElement
				.waitForElements(
						"//div[@id='mainContainer']//table/tbody/tr[7]/td[1][contains(text(),'End Quietly?')]",
						"xpath");
		assertTrue(this.page
				.dynamicElement(
						"Quietly",
						"//div[@id='mainContainer']//table/tbody/tr[7]/td[1][contains(text(),'End Quietly?')]",
						"xpath").getOne().isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify 'conformation msg' in Multi-Region 
	 *               Event Confirmation page 
	 * list Date   : 01/09/2014 
	 * Author      : Sowmya
	 **********************************************************************************/
	public EventManagement verifyConformationMsgInMREC() throws Exception {
		objWaitForElement.waitForElements(conformationMessage, "xpath");
		assertTrue(this.page.dynamicElement(
				"Are you sure you want to create this multi-region event?",
				conformationMessage, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'No' button 
	 * Date        : 03/09/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public EventManagement verifyNoButton() throws Exception {
		objWaitForElement.waitForElements(noButton, "css");
		assertTrue(this.page.element(noButton, "css").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Event information is displayed in the list 
	 * Date        : 03/09/2014 
	 * Autho       : Sowmya
	 **********************************************************************************/
	public EventManagement verifyEventInformation(String strEventName,
			String strEventDescription) throws Exception {
		objWaitForElement.waitForElements("//table/tbody/tr/td[7][text()='" + strEventName
				+ "']/parent::tr/td[10][text()='"
				+ strEventDescription + "']", "xpath");
		assertTrue(this.page
				.dynamicElement(
						"EventDescription",
						"//table/tbody/tr/td[7][text()='" + strEventName
								+ "']/parent::tr/td[10][text()='"
								+ strEventDescription + "']", "xpath").getOne()
				.isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Drill is displayed in the list 
	 * Date        : 03/09/2014 
	 * Autho       : Sowmya
	 **********************************************************************************/
	public EventManagement verifyDrill(String strEventName,
			String strDrillOption) throws Exception {
		objWaitForElement.waitForElements("//table/tbody/tr/td[7][text()='" + strEventName
				+ "']/parent::tr/td[8][text()='"
				+ strDrillOption + "']", "xpath");
		assertTrue(this.page
				.dynamicElement(
						"EventDescription",
						"//table/tbody/tr/td[7][text()='" + strEventName
								+ "']/parent::tr/td[8][text()='"
								+ strDrillOption + "']", "xpath").getOne()
				.isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify Multi-Region Event Confirmation page screen with details
	 * Date 		: 04/09/2014  
	 * Author 		: Renushree
	 **********************************************************************************/
	public EventManagement verifyInfoInMultiRegionEventConfirmationPage(
			String strEventName, String strEventDesc, String strStartTime,
			String strEndTime) throws Exception {
		this.verifyEventTitleInMREC(strEventName);
		this.verifyEventInformationInMREC(strEventDesc);
		this.verifyStartDateAndTimeInMREC(strStartTime);
		this.verifyEndDateAndTimeInMREC(strEndTime);
		this.verifyAttachedFileOptionInMREC();
		this.verifyDrillOptionInMREC();
		this.verifyEndQuietlyOptionInMREC();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select Event minuter Arguments :
	 * strResource Date : 18/08/2014 Author : Renushree
	 **********************************************************************************/
	public EventManagement deselectResource(String[] strResource)
			throws Exception {
		objWaitForElement.waitForElements("//input[@name='resourceID'][@value='"
				+ strResource[0] + "']", "xpath");
		for (int i = 0; i < strResource.length; i++) {
			if (this.page
					.element(
							"//input[@name='resourceID'][@value='"
									+ strResource[i] + "']", "xpath").getOne()
					.isSelected()) {

				this.page
						.element(
								"//input[@name='resourceID'][@value='"
										+ strResource[i] + "']", "xpath")
						.getOne().click();
			}
		}
		return this;
	}
	
	/**********************************************************************************
     * Description : This function is to verify 'End' option is displayed
     * for an Event Date : 19/08/2014 Author : Sinchana
     **********************************************************************************/
    public EventManagement clickOnEndEventVeifyText(String strEventName)
            throws Exception {
		objWaitForElement.waitForElements("//table/tbody/tr/td[7][text()='" + strEventName
                + "']/preceding-sibling::td[6]/a[text()='End']",
                "xpath");
        this.page
        .dynamicElement(
                "EventEditLink",
                "//table/tbody/tr/td[7][text()='" + strEventName
                + "']/preceding-sibling::td[6]/a[text()='End']",
                "xpath").getOne().click();
        Thread.sleep(7000);
        Alert alert = driver.switchTo().alert();
        String strVar = alert.getText();
        assertEquals("Are you sure you want to end this event?\n\nPress OK to end the event. Press Cancel if you do NOT want to end the event.", strVar);
        alert.accept();
        Thread.sleep(5000);
        return this;
    }

    /**********************************************************************************
     * Description : This function is to Click on 'View History' link 
     * Date : 08/09/2014
     * Author : Sinchana
     **********************************************************************************/
    public EventManagement clickOnViewHistoryLink(String strEventName)
    		throws Exception {
		objWaitForElement.waitForElements("//table/tbody/tr/td[7][text()='"
				+ strEventName
				+ "']/preceding-sibling::td[6]/a[text()='View History']",
		"xpath");
    	this.page
    	.dynamicElement(
    			"EventEditLink",
    			"//table/tbody/tr/td[7][text()='"
    					+ strEventName
    					+ "']/preceding-sibling::td[6]/a[text()='View History']",
    			"xpath").getOne().click();
    	return this;
    }	

    /**********************************************************************************
     * Description : This function is to verify 'Event History' popup window is displayed 
     * with message ended.
     * Date : 08/09/2014
     * Author : Sinchana
     **********************************************************************************/
    public EventManagement verifyEventHistoryPopUp() 
    		throws Exception {
		objWaitForElement.waitForElements(viewHistoryPopUp, "xpath");
    	assertTrue(this.page.element(viewHistoryPopUp, "xpath").getOne().isDisplayed());
    	return this;
    }	

    /**********************************************************************************
     * Description : This function is to verify 'Event is Ended' in view hisory pop up
     * Date : 08/09/2014
     * Author : Sinchana
     **********************************************************************************/
    public EventManagement verifyEventEndedInViewHistoryPopUp(String strEventName)
    		throws Exception {
		objWaitForElement.waitForElements("//dl/dt[text()='Ended: " + strEventName + "']", "xpath");
    	assertTrue(this.page.dynamicElement("EventEndedInViewHistoryPopUp",
    			"//dl/dt[text()='Ended: " + strEventName + "']", "xpath").getOne().isDisplayed());
    	return this;
    }

    /**********************************************************************************
	  * Description : This function is to select frame
	  * Date        : 09/09/2014
	  * Author      : Sinchana
	  **********************************************************************************/
	public EventManagement clickOnCloseBtn() throws Exception {
		WebDriverWait wait = new WebDriverWait(this.driver, WaitTimeConstants.WAIT_TIME_LONG);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(strEventHistoryFrame));
		objWaitForElement.waitForElements(closeButton,
				"css");
    	this.page.element(closeButton, "css").getOne().click();
		return this;
	}
    
	 /**********************************************************************
	  * Description : This function is to verify status type is selected
	  * Date        : 09/09/2014
	  * Author      : Anil
	  **********************************************************************/	
	public EventManagement verifyStatusTypesIsSelected(
			String strStatusTypesValue) throws Exception {
		objWaitForElement.waitForElements("input[name='st'][value='" + strStatusTypesValue + "']",
				"css");
		assertTrue(this.page
				.dynamicElement(
						"statusType",
						"input[name='st'][value='" + strStatusTypesValue + "']",
						"css").getOne().isSelected());
		return this;
	}
	
	 /**********************************************************************
	  * Description : This function is to verify status type is selected
	  * Date        : 09/09/2014
	  * Author      : Anil
	  **********************************************************************/	
	public EventManagement selectStatusType(String strStatusTypesValue)
			throws Exception {
		objWaitForElement.waitForElements("input[value='"
				+ strStatusTypesValue + "']", "css");
		this.page
				.dynamicElement(
						"statusType",
						"input[value='"
								+ strStatusTypesValue + "']", "css").getOne()
				.click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to fetch application time
	 * Date        : 09/09/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public String getApplicationTime() throws Exception {
		objWaitForElement.waitForElements(applicationTime, "xpath");
		String time = this.page.element(applicationTime, "xpath").getOne()
				.getText();
		String strApplicationTime = time.replace(" CDT", "");
		strApplicationTime = strApplicationTime.replace(" CST", "");
		return strApplicationTime;
	}
	
	/**********************************************************************************
	  * Description : This function is to create status type
	  * Date        : 11/06/2014
	  * Author      : Anitha
	  **********************************************************************************/
	public String getEventTemplateValue(String strEveTemplateName)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']"
				+ "/table[2]/tbody/tr/td[3][text()='"
				+ strEveTemplateName + "']/parent::tr/td[1]/a", "xpath");
		String strStatValue = this.page
				.dynamicElement(
						"EveTemplateName",
						"//div[@id='mainContainer']"
								+ "/table[2]/tbody/tr/td[3][text()='"
								+ strEveTemplateName + "']/parent::tr/td[1]/a",
						"xpath").getOne().getAttribute("href");

		String strResValueArr[] = strStatValue.split("eventTypeID=");
		strStatValue = strResValueArr[1];

		return strStatValue;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to fetch event value
	 * Date 		: 11/06/2014 
	 * Author 		: Renushree
	 **********************************************************************************/
	public String getEventValue(String strEventName)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='eventsBanner']/table[@class='events']//a[text()='"
				+ strEventName + "']", "xpath");
		String strEveValue = this.page
				.element(
						"//div[@id='eventsBanner']/table[@class='events']//a[text()='"
								+ strEventName + "']", "xpath").getOne().getAttribute("id");
		String val = strEveValue.substring(1, strEveValue.length());
		return val;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to get event drill value 
	 * Date 		: 12/09/2014
	 * Author 		: Renushree
	 **********************************************************************************/
	public String getDrillVal(String strEventName) throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table/tbody/tr/td[7]"
				+ "[text()='"
				+ strEventName
				+ "']/following-sibling::td[1]", "xpath");
		String strEventDrill = this.page
				.element(
						"//div[@id='mainContainer']/table/tbody/tr/td[7]"
								+ "[text()='"
								+ strEventName
								+ "']/following-sibling::td[1]", "xpath")
				.getOne().getText();
		return strEventDrill;
	}
	/**********************************************************************************
	 * Description : This function is to verify web notification frame Not present
	 * Date        : 10/06/2014
	 * Author      : Anitha
	 **********************************************************************************/
	public EventManagement verWebNotificationframeNotPresent() throws Exception {
		assertFalse(this.page.element("//div[@id='TB_title']", "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify title of the event present
	 * Date        : 25/09/2014
	 * Author      : Anitha
	 **********************************************************************************/
	public EventManagement verifyMultiEventTitleField() throws Exception {
		objWaitForElement.waitForElements(multiEventsTitleField, "xpath");
		assertTrue(this.page.element(multiEventsTitleField, "xpath")
				.getOne().isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify Information the event present
	 * Date        : 25/09/2014
	 * Author      : Anitha
	 **********************************************************************************/
	public EventManagement verifyMultiEventInformationField() throws Exception {
		objWaitForElement.waitForElements(multiEventInformationField, "xpath");
		assertTrue(this.page.element(multiEventInformationField, "xpath")
				.getOne().isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify Event Start Radio Buttons
	 * Date        : 25/09/2014
	 * Author      : Anitha
	 **********************************************************************************/
	public EventManagement verifyMultiEventStartRadioButton() throws Exception {
		objWaitForElement.waitForElements(multiEventStartField1, "xpath");
		assertTrue(this.page.element(multiEventStartField1, "xpath")
				.getOne().isDisplayed());
		objWaitForElement.waitForElements(multiEventStartField2, "xpath");
		assertTrue(this.page.element(multiEventStartField2, "xpath")
				.getOne().isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify Event end Radio Buttons
	 * Date        : 25/09/2014
	 * Author      : Anitha
	 **********************************************************************************/
	public EventManagement verifyMultiEventEndRadioButton() throws Exception {
		objWaitForElement.waitForElements(multiEventEndField1, "xpath");
		assertTrue(this.page.element(multiEventEndField1, "xpath")
				.getOne().isDisplayed());
		objWaitForElement.waitForElements(multiEventEndField2, "xpath");
		assertTrue(this.page.element(multiEventEndField2, "xpath")
				.getOne().isDisplayed());
		objWaitForElement.waitForElements(multiEventEndField3, "xpath");
		assertTrue(this.page.element(multiEventEndField3, "xpath")
				.getOne().isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify Display in Event Banner?
	 * Date        : 25/09/2014
	 * Author      : Anitha
	 **********************************************************************************/
	public EventManagement verifyMultiEventDisplayBannerField()
			throws Exception {
		objWaitForElement.waitForElements(multiEventBannerField, "xpath");
		assertTrue(this.page.element(multiEventBannerField, "xpath")
				.getOne().isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify Priavte Field
	 * Date        : 25/09/2014
	 * Author      : Anitha
	 **********************************************************************************/
	public EventManagement verifyMultiEventPrivateField() throws Exception {
		objWaitForElement.waitForElements(multiEventPrivateField, "xpath");
		assertTrue(this.page.element(multiEventPrivateField, "xpath")
				.getOne().isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify Priavte Field
	 * Date        : 25/09/2014
	 * Author      : Anitha
	 **********************************************************************************/
	public EventManagement verifyMultiEventDrillField() throws Exception {
		objWaitForElement.waitForElements(multiEventDrillField, "xpath");
		assertTrue(this.page.element(multiEventDrillField, "xpath")
				.getOne().isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify EndQuitely Field
	 * Date        : 25/09/2014
	 * Author      : Anitha
	 **********************************************************************************/
	public EventManagement verifyMultiEventEndQuitelyField() throws Exception {
		objWaitForElement.waitForElements(multiEventEndQuitelyField, "xpath");
		assertTrue(this.page.element(multiEventEndQuitelyField, "xpath")
				.getOne().isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify Renotify Field
	 * Date        : 25/09/2014
	 * Author      : Anitha
	 **********************************************************************************/
	public EventManagement verifyMultiEventRenotifyField() throws Exception {
		objWaitForElement.waitForElements(multiEventRenotifyField1, "xpath");
		assertTrue(this.page.element(multiEventRenotifyField1, "xpath")
				.getOne().isDisplayed());
		objWaitForElement.waitForElements(multiEventRenotifyField2, "xpath");
		assertTrue(this.page.element(multiEventRenotifyField2, "xpath")
				.getOne().isDisplayed());
		objWaitForElement.waitForElements(multiEventRenotifyField3, "xpath");
		assertTrue(this.page.element(multiEventRenotifyField3, "xpath")
				.getOne().isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify street address field
	 * Date        : 25/09/2014
	 * Author      : Anitha
	 **********************************************************************************/
	public EventManagement verifyMultiEventStreetAddressField()
			throws Exception {
		objWaitForElement.waitForElements(multiEventStreetAddressField, "xpath");
		assertTrue(this.page.element(multiEventStreetAddressField, "xpath")
				.getOne().isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify city field
	 * Date        : 25/09/2014
	 * Author      : Anitha
	 **********************************************************************************/
	public EventManagement verifyMultiEventCityField() throws Exception {
		objWaitForElement.waitForElements(multiEventCityField, "xpath");
		assertTrue(this.page.element(multiEventCityField, "xpath")
				.getOne().isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify State field
	 * Date        : 25/09/2014
	 * Author      : Anitha
	 **********************************************************************************/
	public EventManagement verifyMultiEventStateField() throws Exception {
		objWaitForElement.waitForElements(multiEventStateField, "xpath");
		assertTrue(this.page.element(multiEventStateField, "xpath")
				.getOne().isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify ZipCode field
	 * Date        : 25/09/2014
	 * Author      : Anitha
	 **********************************************************************************/
	public EventManagement verifyMultiEventZipCOdeField() throws Exception {
		objWaitForElement.waitForElements(multiEventZipCodeField, "xpath");
		assertTrue(this.page.element(multiEventZipCodeField, "xpath")
				.getOne().isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify county field
	 * Date        : 25/09/2014
	 * Author      : Anitha
	 **********************************************************************************/
	public EventManagement verifyMultiEventCountyField() throws Exception {
		objWaitForElement.waitForElements(multiEventCountyField, "xpath");
		assertTrue(this.page.element(multiEventCountyField, "xpath")
				.getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'latitude' text field is displayed
	 * Date : 25/09/2014
	 * Author : Anil
	 **********************************************************************************/
	public EventManagement verifyLatitudeIsDisplayed() throws Exception {
		objWaitForElement.waitForElements(latitude, "css");
		assertTrue(this.page.element(latitude, "css").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'longitude' text field is displayed
	 * Date : 25/09/2014
	 * Author : Anil
	 **********************************************************************************/
	public EventManagement verifyLongitudeIsDisplayed() throws Exception {
		objWaitForElement.waitForElements(longitude, "css");
		assertTrue(this.page.element(longitude, "css").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'longitude' text field is displayed
	 * Date : 25/09/2014
	 * Author : Anil
	 **********************************************************************************/
	public EventManagement verifyLatitudeLongitudeTextIsDisplayed() throws Exception {
		objWaitForElement.waitForElements(latitudeLogitudeText, "xpath");
		assertTrue(this.page.element(latitudeLogitudeText, "xpath").getOne().isDisplayed());
		return this;
	}
	
	
	/**********************************************************************************
	 * Description : This function is to verify event template is displayed in region dropdown
	 * Date : 25/09/2014
	 * Author : Anil
	 **********************************************************************************/
	public EventManagement verifyRegionNameAndETName(String strRegionName, String strEventTemplateName) throws Exception {
		objWaitForElement.waitForElements("//td[text()='"+strRegionName+"']/following-sibling::td/select/option[text()='"+strEventTemplateName+"']", "xpath");
		assertTrue(this.page.element("//td[text()='"+strRegionName+"']/following-sibling::td/select/option[text()='"+strEventTemplateName+"']", "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Browse' button is displayed
	 * Date : 25/09/2014
	 * Author : Anil
	 **********************************************************************************/
	public EventManagement verifyBrowseButtonIsDisplayed() throws Exception {
		objWaitForElement.waitForElements(browseButton, "xpath");
		assertTrue(this.page.element(browseButton, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to click on 'Cancel' button 
	 * Date  		: 24/09/2014
	 *  Author 		: Prasanna Lakshmi
	 **********************************************************************************/
	public EventManagement clickOnCancelButton() throws Exception {
		objWaitForElement.waitForElements(clickOnCancelButton, "css");
		this.page.element(clickOnCancelButton, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'keep' button is displayed
	 * Date :
	 * 09/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifyKeepButtonIsDisplayed() throws Exception {
		objWaitForElement.waitForElements(keepButton, "css");
		assertTrue(this.page.element(keepButton, "css").getOne().isDisplayed());
		return this;
	}
	
	
	/**********************************************************************************
	 * Description : This function is to verify 'keep' button is displayed
	 * Date :
	 * 09/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifyModifyButtonIsDisplayed() throws Exception {
		objWaitForElement.waitForElements(modifyButton, "css");
		assertTrue(this.page.element(modifyButton, "css").getOne().isDisplayed());
		return this;
	}
	
	
	/**********************************************************************************
	 * Description : This function is to verify text message is displayed
	 * Date :
	 * 09/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifyTextMessageIsDisplayed() throws Exception {
		objWaitForElement.waitForElements(textMessage2, "xpath");
		objWaitForElement.waitForElements(textMessage1, "xpath");
		assertTrue(this.page.element(textMessage2, "xpath").getOne().isDisplayed());
		assertTrue(this.page.element(textMessage1, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Incoming patient notification
	 * Date        : 21/10/2014 
	 * Author      : Sowmya
	 **********************************************************************************/
	public EventManagement verIncomingPatientNotification(String strResourceName)
			throws Exception {
		objWaitForElement.waitForElements("//dt[@class='ipn'][text()='Incoming Patient Notification for "
				+ strResourceName + "']", "xpath");
		assertTrue(this.page.element(
				"//dt[@class='ipn'][text()='Incoming Patient Notification for "
						+ strResourceName + "']", "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter 'Event Description'
	 * Banner Date : 08/07/2014 
	 * Author : Anil
	 **********************************************************************************/
	public EventManagement creatEvent(String strEveTemplate, String strEventName, String strEventDescription, String strResource)
			throws Exception {
		this.clickOnCreateNewEvent();
		this.clickOnCreateEvent(strEveTemplate);
		this.enterAdHocEventName(strEventName);
		this.enterAdHocEventDescription(strEventDescription);
		this.selectResource(strResource);
		this.clickOnSaveButton();
		Thread.sleep(5000);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select Event minuter Arguments :
	 * strResource Date : 18/08/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement selectResource(String strResource)
			throws Exception {
		objWaitForElement.waitForElements("//input[@name='resourceID'][@value='"
				+ strResource + "']", "xpath");
			this.page
					.element(
							"//input[@name='resourceID'][@value='"
									+ strResource + "']", "xpath").getOne()
					.click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select Event minuter Arguments :
	 * strResource Date : 18/08/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement deselectResource(String strResource)
			throws Exception {
		objWaitForElement.waitForElements("//input[@name='resourceID'][@value='"
				+ strResource + "']", "xpath");
			if (this.page
					.element(
							"//input[@name='resourceID'][@value='"
									+ strResource + "']", "xpath").getOne()
					.isSelected()) {

				this.page
						.element(
								"//input[@name='resourceID'][@value='"
										+ strResource + "']", "xpath")
						.getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to fetch application time including CST and CDT
	 * Date        : 09/09/2014
	 * Author      : Anil 
	 **********************************************************************************/
	public String getApplicationTimeWithCSTCDT() throws Exception {
		objWaitForElement.waitForElements(applicationTime, "xpath");
		String strApplicationTime = this.page.element(applicationTime, "xpath").getOne()
				.getText();
		return strApplicationTime;
	}
	
	/**********************************************************************
	  * Description : This function is to select status type when creating adhoc event
	  * Date        : 14/11/2014
	  * Author      : Renushree
	  **********************************************************************/	
	public EventManagement selectStatusTypeDuringAdhocEvents(
			String strStatusTypesValue) throws Exception {
		objWaitForElement.waitForElements("input[name='statusTypeID'][value='"
				+ strStatusTypesValue + "']", "css");
		this.page
				.dynamicElement(
						"statusType",
						"input[name='statusTypeID'][value='"
								+ strStatusTypesValue + "']", "css").getOne()
				.click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select 'drill' checkbox               
	 * Date        : 25/06/2014 
	 * Author      : Sowmya
	 **********************************************************************************/
		public EventManagement selectDrillCheckBox() throws Exception {		
			objWaitForElement.waitForElements(drillCheckBox,"css");
			this.page
			.element(drillCheckBox, "css").getOne().click();
			return this;
		}
		
		/**********************************************************************************
		 * Description : This function is to verify error message displayed in Event confirmation page
		 * Date        : 24/06/2014
		 * Author      : Anil
		 **********************************************************************************/
		public EventManagement checkErrorMessageForStatusTypes()
				throws Exception {
			objWaitForElement.waitForElements(errorMessageForST,"xpath");
			assertEquals(
					this.page.element(errorMessageForST,"xpath").getOne().getText(),
					"Since no resources are selected you must not select any status types.");
			return this;
		}
		
		/**********************************************************************************
		 * Description : This function is to verify error message in adhocevent page 
		 * Date        : 24/06/2014
		 * Author      : Anitha
		 **********************************************************************************/
		public EventManagement chkErrMsgCreateAdHocEventPage(String strResource)
				throws Exception {
			objWaitForElement.waitForElements("//div[@class='emsError']/ul/li[text()='The following resources are not associated with any selected status types: "
					+ strResource+"']","xpath");
			assertEquals(
					this.page.element(errorMessageForST, "xpath").getOne().getText(),
					"Since at least one resource is selected you must also select at least one status type.");
			assertTrue(this.page.element(
					"//div[@class='emsError']/ul/li[text()='The following resources are not associated with any selected status types: "
							+ strResource+"']", "xpath").isElementPresent());
			return this;
		}
		
		/**********************************************************************************
		 * Description : This function is to verify 'Cancel' link Date : 19/06/2014
		 * Author : Sowmya
		 **********************************************************************************/
		public EventManagement clickCancelEventLink(String strEventName)
				throws Exception {
			objWaitForElement.waitForElements("//div[@id='mainContainer']/table/tbody/tr/td[7][text()='"
							+ strEventName
							+ "']/parent::tr/td[1]/a[2][text()='Cancel']",
					"xpath");
					this.page
							.element(
									"//div[@id='mainContainer']/table/tbody/tr/td[7][text()='"
											+ strEventName
											+ "']/parent::tr/td[1]/a[2][text()='Cancel']",
									"xpath").getOne().click();
			    Thread.sleep(7000);
			    Alert alert = driver.switchTo().alert();
			    String strVar = alert.getText();
			    assertEquals("Are you sure you want to end this event?\n\n"+

"Press OK to end the event. Press Cancel if you do NOT want to end the event.", strVar);
			    alert.accept();
			    Thread.sleep(5000);
			return this;
		}
		

		/**********************************************************************************
		 * Description : This function is to verify EventName is displayed in event
		 * banner Date : 28/07/2014 Author : Anil
		 **********************************************************************************/
		public EventManagement verifyEventNotDisplayedInBanner(String strEventName)
				throws Exception {
			assertFalse(this.page
					.dynamicElement(
							strEventName + " is displayed in event banner",
							"//div[@id='eventsBanner']/table[@class='events']//a[text()='"
									+ strEventName + "']", "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));

			return this;
		}
		/**********************************************************************************
		 * Description : This function is to verify event action
		 * Event Date : 09/06/2014 Author : Anil
		 **********************************************************************************/
		public EventManagement verifyEventAction(String strEventName,
				String strEventAction) throws Exception {
			objWaitForElement.waitForElements("//div[@id='mainContainer']/table[@class='displayTable"
							+ " striped border sortable']/tbody/tr/td[7][text()="
							+ "'" + strEventName
							+ "']/parent::tr/td[1]/a[text()='"+strEventAction+"']", "xpath");
			assertTrue(this.page.element(
					"//div[@id='mainContainer']/table[@class='displayTable"
							+ " striped border sortable']/tbody/tr/td[7][text()="
							+ "'" + strEventName
							+ "']/parent::tr/td[1]/a[text()='"+strEventAction+"']","xpath").isElementPresent());
			return this;
		}
		
		/**********************************************************************************
		 * Description 	: This function is to verify Confirmation message is
		 * 					displayed 
		 * Date 		: 26/Nov/2014 
		 * Author 		: Renushree
		 **********************************************************************************/
		public EventManagement verifyConfirmationMessageForChangesMade() throws Exception {
			objWaitForElement.waitForElements(confirmationMessage, "xpath");
			assertEquals(
					"Save your changes to this multi-region event?",
					this.page.element(confirmationMessage, "xpath").getOne()
							.getText());
			return this;
		}
		
		/**********************************************************************************
		 * Description 	: This function is to verify Edit Multi region Event Screen is
		 * 					displayed 
		 * Date 		: 26/11/2014 
		 * Author 		: Renushree
		 **********************************************************************************/
		public EventManagement verifyEditMultiRegEventScreenIsDisplayed()
				throws Exception {
			objWaitForElement.waitForElements(editMultiRegEventScreen, "xpath");
			assertTrue(this.page.element(editMultiRegEventScreen, "xpath").getOne()
					.isDisplayed());
			return this;
		}
		
		/***************************************************************************************
		 * Description    : This function is to verify Save Button In Top Of EventManagementPage
		 * displayed Date : 09/06/2014 
		 * Author         : Anitha
		 **************************************************************************************/
		public EventManagement verifySaveButtonInTopOfEventManagementPage() throws Exception {
			objWaitForElement.waitForElements(saveButtonInTopOfPage, "xpath");
			assertTrue(this.page.element(saveButtonInTopOfPage, "xpath").getOne()
					.isDisplayed());
			return this;
		}
		
		/***************************************************************************************
		 * Description    : This function is to verify Cancel Button In Top Of EventManagementPage
		 * displayed Date : 09/06/2014 
		 * Author         : Anitha
		 **************************************************************************************/
		public EventManagement verifyCancelButtonInTopOfEventManagementPage() throws Exception {
			objWaitForElement.waitForElements(cancelButtonInTopOfPage, "xpath");
			assertTrue(this.page.element(cancelButtonInTopOfPage, "xpath").getOne()
					.isDisplayed());
			return this;
		}
		
		/***************************************************************************************
		 * Description    : This function is to verify Save Button In Bottom Of EventManagementPage
		 * displayed Date : 09/06/2014 
		 * Author         : Anitha
		 **************************************************************************************/
		public EventManagement verifySaveButtonInBottomOfEventManagementPage() throws Exception {
			objWaitForElement.waitForElements(saveButtonInBottomOfPage, "xpath");
			assertTrue(this.page.element(saveButtonInBottomOfPage, "xpath").getOne()
					.isDisplayed());
			return this;
		}
		
		/***************************************************************************************
		 * Description    : This function is to verify Save Button In Bottom Of EventManagementPage
		 * displayed Date : 09/06/2014 
		 * Author         : Anitha
		 **************************************************************************************/
		public EventManagement verifyCancelButtonInBottomOfEventManagementPage() throws Exception {
			objWaitForElement.waitForElements(cancelButtonInBottomOfPage, "xpath");
			assertTrue(this.page.element(cancelButtonInBottomOfPage, "xpath").getOne()
					.isDisplayed());
			return this;
		}
		
		/***************************************************************************************
		 * Description    : This function is to verify Save Button In Bottom Of EventManagementPage
		 * displayed Date : 09/06/2014 
		 * Author         : Anitha
		 **************************************************************************************/
		public EventManagement verifySaveAndCancelButtons() throws Exception {
			objWaitForElement.waitForElements(saveButton, "css");
			assertTrue(this.page.element(saveButton, "css").getOne()
					.isDisplayed());
			objWaitForElement.waitForElements(clickOnCancelButton, "css");
			assertTrue(this.page.element(clickOnCancelButton, "css").getOne()
					.isDisplayed());
			return this;
		}
		
		/**********************************************************************************
		 * Description : This function is to verify 'Cancel' link 
		 * Date : 19/06/2014
		 * Author : Anil
		 **********************************************************************************/
		public EventManagement cancelEndEvent(String strEventName)
				throws Exception {
			objWaitForElement.waitForElements("//div[@id='mainContainer']/table/tbody/tr/td[7][text()='"
											+ strEventName
											+ "']/parent::tr/td[1]/a[2][text()='End']", "xpath");
					this.page
							.element(
									"//div[@id='mainContainer']/table/tbody/tr/td[7][text()='"
											+ strEventName
											+ "']/parent::tr/td[1]/a[2][text()='End']",
									"xpath").getOne().click();
			    Thread.sleep(7000);
			    Alert alert = driver.switchTo().alert();
			    String strVar = alert.getText();
			    assertEquals("Are you sure you want to end this event?\n\n"+

"Press OK to end the event. Press Cancel if you do NOT want to end the event.", strVar);
			    alert.dismiss();
			    Thread.sleep(5000);
			return this;
		}
		
	/**********************************************************************************
	 * Description	: This function is to verify Error mesage Title 
	 * Date			: 11/06/2014 
	 * Author 		: Anil
	 **********************************************************************************/
	public EventManagement verifyErrorMessageTitle1() throws Exception {
		objWaitForElement.waitForElements(errorMessageTitle1, "xpath");
		assertTrue(this.page.element(errorMessageTitle1, "xpath").getOne()
				.isDisplayed());
		return this;
	}
		
	/**********************************************************************************
	 * Description 	: This function is to verify Edit Event Screen is
	 * 					displayed 
	 * Date 		: 01/12/2014 
	 * Author 		: Renushree
	 **********************************************************************************/
	public EventManagement verifyEditEventScreenIsDisplayed()
			throws Exception {
		objWaitForElement.waitForElements(editEventPage, "xpath");
		assertTrue(this.page.element(editEventPage, "xpath").getOne()
				.isDisplayed());
		return this;
	}
		
	/***************************************************************************************
	 * Description    : This function is to verify Cancel Button In Top Of EventManagementPage
	 * displayed Date : 09/06/2014 
	 * Author         : Anitha
	 **************************************************************************************/
	public EventManagement verifySaveAndCancelButtonsNotDisplayed() throws Exception {
		assertFalse(this.page.element(saveButtonInTopOfPage, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		assertFalse(this.page.element(cancelButtonInTopOfPage, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_TOO_SMALL));
		assertFalse(this.page.element(saveButton2, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_TOO_SMALL));
		return this;
	}
	
	/***************************************************************************************
	 * Description    : This function is to verify Cancel Button In Top Of EventManagementPage
	 * displayed Date : 09/06/2014 
	 * Author         : Anitha
	 **************************************************************************************/
	public EventManagement verifySaveAndCancelButtonsNotDisplayedInMRE() throws Exception {
		assertFalse(this.page.element(saveButtonInTopOfPage, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		assertFalse(this.page.element(cancelButtonInTopOfPage, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_TOO_SMALL));
		assertFalse(this.page.element(saveButton3, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_TOO_SMALL));
		return this;
	}
		
	/**********************************************************************************
	 * Description : This function is to verify status types  Date : 11/06/2014
	 * Author : Renushree
	 **********************************************************************************/
	public EventManagement verStatusTypesInEventBanner(
			String[] strStatusTypeNames, String strResourceTypeName)
			throws Exception {
		objWaitForElement.waitForElements(
				"//table[starts-with(@id,'rtt')]/thead/tr/th[2]/a[text()='"
						+ strResourceTypeName + "']/ancestor::tr/th['"
						+ strStatusTypeNames[0] + "']", "xpath");
		for (int i = 0; i < strStatusTypeNames.length; i++) {
			assertTrue(this.page.dynamicElement(
					"StatusTypeValues",
					"//table[starts-with(@id,'rtt')]/thead/tr/th[2]/a[text()='"
							+ strResourceTypeName + "']/ancestor::tr/th['"
							+ strStatusTypeNames[i] + "']", "xpath")
					.isElementPresent());
		}
		return this;
	}
	
	/***************************************************************************************
	 * Description    : This function is to enter status type in search field
	 * Arguments	  : strStatusType
	 * Date 		  : 31/12/2014 
	 * Author         : Renushree
	 **************************************************************************************/
	public EventManagement enterStatusTypeInSearchField(String strStatusType) throws Exception {
		objWaitForElement.waitForElements(searchField, "css");
		assertTrue(this.page.element(searchField, "css").isElementPresent());
		this.page.element(searchField, "css").clearInputValue().sendKeys(strStatusType);
		return this;
	}
	
	/***************************************************************************************
	 * Description    : This function is to click on search button
	 * Arguments	  : Null
	 * Date 		  : 31/12/2014 
	 * Author         : Renushree
	 **************************************************************************************/
	public EventManagement clickOnSearchButton() throws Exception {
		objWaitForElement.waitForElements(searchButton, "css");
		assertTrue(this.page.element(searchButton, "css").isElementPresent());
		this.page.element(searchButton, "css").getOne().click();
		return this;
	}
	
	/***************************************************************************************
	 * Description    : This function is to verify 'Select All' checkbox is selected
	 * Arguments	  : strStatusType
	 * Date 		  : 02/01/2015 
	 * Author         : Anil
	 **************************************************************************************/
	public EventManagement verifySelectAllCheckBoxIsSelected() throws Exception {
		objWaitForElement.waitForElements(toggleCheckBox, "xpath");
		assertTrue(this.page.element(toggleCheckBox, "xpath").getOne().isSelected());
		return this;
	}
	
	/***************************************************************************************
	 * Description    : This function is to enter status type in search field for normal Event
	 * Arguments	  : strStatusType
	 * Date 		  : 31/12/2014 
	 * Author         : Anil
	 **************************************************************************************/
	public EventManagement enterStatusTypeNameInSearchField(String strStatusType) throws Exception {
		objWaitForElement.waitForElements(statusTypeNameSearchBox, "css");
		assertTrue(this.page.element(statusTypeNameSearchBox, "css").isElementPresent());
		this.page.element(statusTypeNameSearchBox, "css").clearInputValue().sendKeys(strStatusType);
		return this;
	}

	/***************************************************************************************
	 * 
	 * Description : This function is to verify checkbox displayed infront of DisplayInEventBannerMessage
	 *  Date : 28/01/2015
	 *  Author :Hanumegowda
	 **************************************************************************************/

	public EventManagement confirmCheckBoxOfDisplayInEventBannerMessage()
			throws Exception {
		objWaitForElement.waitForElements(checkBoxOfDisplayInEventBanner1, "xpath");
		assertTrue(this.page.element(checkBoxOfDisplayInEventBanner1, "xpath")
				.getOne().isDisplayed());

		return this;

	}
	/***************************************************************************************
	* Description : This function is to verify display in event banner checkbox is present
	* Date : 28/01/2015 
	* Author : Hanumegowda
    **************************************************************************************/
	public EventManagement checkDisplyInEveBannerCheckBoxispresent()
	 throws Exception {
		objWaitForElement.waitForElements(DisplayInEventBannercheckbox, "xpath");
		assertTrue(this.page.element(DisplayInEventBannercheckbox, "xpath")
				.getOne().isDisplayed());
             return this;
	}
	
	/***************************************************************************************
	 * Description    : This function is to verify 'Ended' under status column
	 * Arguments	  : strEventTitle
	 * Date 		  : 09-Jun-2015 
	 * Author         : Pallavi
	 **************************************************************************************/
	public EventManagement verifyEndedUnderStatusColumn(String strEventTitle)
			throws Exception {
		objWaitForElement.waitForElements(
				"//div[@id='mainContainer']/table/tbody/tr/td[text()='"
						+ strEventTitle
						+ "']/preceding-sibling::td[text()='Ended']", "xpath");
		assertTrue(this.page.element(
				"//div[@id='mainContainer']/table/tbody/tr/td[text()='"
						+ strEventTitle
						+ "']/preceding-sibling::td[text()='Ended']", "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify on 'Create' link of particular
	 * Event Template Button Banner Date : 08/07/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifyEventTemplateDesctiption(String strEveTemplate, String strETDescription)
			throws Exception {
		objWaitForElement.waitForElements(
				"//div[@id='mainContainer']/table/tbody/tr/td[text()='"
						+ strEveTemplate
						+ "']/following-sibling::td[2][text()='"+strETDescription+"']",
				"xpath");
		assertTrue(this.page
				.dynamicElement(
						"Create link of ET " + strEveTemplate,
						"//div[@id='mainContainer']/table/tbody/tr/td[text()='"
								+ strEveTemplate
								+ "']/following-sibling::td[2][text()='"+strETDescription+"']",
						"xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify event multi? status
	 * Event Date 	: 16/06/2015 
	 * Author 		: Renushree
	 **********************************************************************************/
	public EventManagement verifyEventMultiStatus(String strEventName,
			String strMultiStatus) throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table[@class='displayTable"
						+ " striped border sortable']/tbody/tr/td[7][text()="
						+ "'" + strEventName
						+ "']/parent::tr/td[3][text()='"+strMultiStatus+"']", "xpath");
		assertTrue(this.page.element(
				"//div[@id='mainContainer']/table[@class='displayTable"
						+ " striped border sortable']/tbody/tr/td[7][text()="
						+ "'" + strEventName
						+ "']/parent::tr/td[3][text()='"+strMultiStatus+"']","xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify event icon
	 * Event Date 	: 16/06/2015 
	 * Author 		: Renushree
	 **********************************************************************************/
	public EventManagement verifyEventIcon(String strEventName,
			String strIconVal) throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table[@class='displayTable"
						+ " striped border sortable']/tbody/tr/td[7][text()="
						+ "'" + strEventName
						+ "']/parent::tr/td[2]/img[@src='"+strIconVal+"']", "xpath");
		assertTrue(this.page.element(
				"//div[@id='mainContainer']/table[@class='displayTable"
						+ " striped border sortable']/tbody/tr/td[7][text()="
						+ "'" + strEventName
						+ "']/parent::tr/td[2]/img[@src='"+strIconVal+"']","xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to veridy event template not displayed 
	 * Date 		: 18/Jun/2015 
	 * Author 		: Renushree
	 **********************************************************************************/
	public EventManagement verETNotDisplayad(String strEveTemplate)
			throws Exception {
		assertFalse(this.page.element(
				"//div[@id='mainContainer']/table/tbody/tr/td[text()='"
				+ strEveTemplate
				+ "']","xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));		
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify event table header names and position
	 * Event Date 	: 16/06/2015 
	 * Author 		: Anil
	 **********************************************************************************/
	public EventManagement verifyEventHeaderAndPosition(String strHeaderName,
			int strPosition) throws Exception {
		if(strHeaderName.equals("Action")||strHeaderName.equals("Icon")){
			objWaitForElement.waitForElements("//table/thead/tr/th["+strPosition+"][text()='"+strHeaderName+"']", "xpath");
			assertTrue(this.page.element("//table/thead/tr/th["+strPosition+"][text()='"+strHeaderName+"']", "xpath").getOne().isDisplayed());
		}
		else{
			objWaitForElement.waitForElements("//table/thead/tr/th["+strPosition+"]/a[text()='"+strHeaderName+"']", "xpath");
			assertTrue(this.page.element("//table/thead/tr/th["+strPosition+"]/a[text()='"+strHeaderName+"']", "xpath").getOne().isDisplayed());
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter file path in browse button
	 * Date : 25/09/2014
	 * Author : Anil
	 **********************************************************************************/
	public EventManagement enterFilePath(String strFileNameAndPath) throws Exception {
		objWaitForElement.waitForElements(browseButton, "xpath");
		this.page.element(browseButton, "xpath").getOne().sendKeys(strFileNameAndPath);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Create' link of particular
	 * Event Template Button Banner Date : 08/07/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifyCreateEventLink(String strEveTemplate)
			throws Exception {
		
		String strCreateEventLink = "//div[@id='mainContainer']/table/tbody/tr/td[text()='"
				+ strEveTemplate
				+ "']/preceding-sibling::td/a[text()='Create']";
		objWaitForElement.waitForElements(strCreateEventLink,"xpath");
		assertTrue(this.page.element(strCreateEventLink, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to veify Event description Date :
	 * 09/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifyEventDescriptionIsDisplayed()
			throws Exception {
		objWaitForElement.waitForElements(adHocEventDescription, "name");
		assertTrue(this.page.element(adHocEventDescription, "name").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to veify Event title Date :
	 * 09/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifyEventTitleIsDisplayed()
			throws Exception {
		objWaitForElement.waitForElements(adHocEventName, "name");
		assertTrue(this.page.element(adHocEventName, "name").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter file path in browse button
	 * Date : 25/09/2014
	 * Author : Anil
	 **********************************************************************************/
	public EventManagement clickOnAttachedFileLink(String strEventId) throws Exception {
		objWaitForElement.waitForElements("//div[@id='ed"+strEventId+"']//a[@class='eventAttachment']", "xpath");
		this.page.element("//div[@id='ed"+strEventId+"']//a[@class='eventAttachment']", "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter file path in browse button
	 * Date : 25/09/2014
	 * Author : Anil
	 **********************************************************************************/
	public String getEventId(String strEventName) throws Exception {
		objWaitForElement.waitForElements("//div[@id='eventsBanner']/table[@class='events']//a[text()='"
				+ strEventName + "']", "xpath");
		String strEventId = this.page.element("//div[@id='eventsBanner']/table[@class='events']//a[text()='"
				+ strEventName + "']", "xpath").getOne().getAttribute("id");
		strEventId = strEventId.replace("t", "");
		return strEventId;
	}
	
	
	/**********************************************************************************
	 * Description : This function is to enter file path in browse button
	 * Date : 25/09/2014
	 * Author : Anil
	 **********************************************************************************/
	public EventManagement verifyAttachedText(String strAttachmentText) throws Exception {
		objWaitForElement.waitForElements("//pre[text()='"+strAttachmentText+"']", "xpath");
		assertTrue(this.page.element("//pre[text()='"+strAttachmentText+"']", "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter file path in browse button
	 * Date : 25/09/2014
	 * Author : Anil
	 **********************************************************************************/
	public EventManagement verifyHTMLAttachedFile(String strAttachmentText) throws Exception {
		objWaitForElement.waitForElements("//h1[text()='"+strAttachmentText+"']", "xpath");
		assertTrue(this.page.element("//h1[text()='"+strAttachmentText+"']", "xpath").getOne().isDisplayed());
		return this;
	}
	
	
	/**********************************************************************************
	 * Description : This function is to enter file path in browse button
	 * Date : 25/09/2014
	 * Author : Anil
	 **********************************************************************************/
	public EventManagement verifyAttachedFileLink(String strEventId) throws Exception {
		objWaitForElement.waitForElements("//div[@id='ed"+strEventId+"']//a[@class='eventAttachment']", "xpath");
		assertTrue(this.page.element("//div[@id='ed"+strEventId+"']//a[@class='eventAttachment']", "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify event not in event banner 
	 * Date 		: 23/June/2015 
	 * Author 		: Renushree
	 **********************************************************************************/
	public EventManagement verEveNotPresentInEveBanner(String strEventName)
			throws Exception {
		assertFalse(this.page.element(
				"//div[@id='eventsBanner']/table[@class='events']//a[text()='"
						+ strEventName + "']", "xpath").isElementPresent(
				WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	
	/**********************************************************************************
	 * Description : This function is to click on event mane present in Event
	 * Banner Date : 10/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifyEventColorInEventBanner(String strEventName, String strEventColor)
			throws Exception {
		strEventColor = strEventColor.toLowerCase();
		objWaitForElement.waitForElements("//td[@class='"+strEventColor+" eventNotSel']/a[text()='"+strEventName+"']", "xpath");
		assertTrue(this.page.element("//td[@class='"+strEventColor+" eventNotSel']/a[text()='"+strEventName+"']", "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to get Event end date
	 * for an Event Date : 09/06/2014 Author : Anil
	 **********************************************************************************/
	public String getEventStartDateAndTime(String strEventName) throws Exception {
		String strEnddate = "//table/tbody/tr/td[text()='" + strEventName
				+ "']/parent::tr/td[5]";
		objWaitForElement.waitForElements(strEnddate, "xpath");
		String endDate = this.page.element(strEnddate, "xpath").getOne()
				.getText();
		System.out.println("start date " + endDate);
		return endDate;

	}

	/**********************************************************************
	  * Description : This function is to verify status type is selected and disabled
	  * Date        : 30/Jun/2015
	  * Author      : Renushree
	  **********************************************************************/	
	public EventManagement verStatusTypeSelectedAndDisabled(
			String strStatusTypesValue) throws Exception {
		objWaitForElement.waitForElements("input[value='"
				+ strStatusTypesValue + "']", "css");
		assertTrue(
				this.page
						.element(
								"input[disabled='disabled'][value='"
										+ strStatusTypesValue + "']", "css")
						.getOne().isSelected(),
				"Status type not selected and enabled.");
		return this;
	}
	
	/**********************************************************************
	  * Description : This function is to verify status type is selected
	  * Date        : 09/09/2014
	  * Author      : Anil
	  **********************************************************************/	
	public EventManagement selectStatusTypeInEditEventPage(String strStatusTypesValue)
			throws Exception {
		objWaitForElement.waitForElements("input[name='st'][value='"
				+ strStatusTypesValue + "']", "css");
		this.page
				.dynamicElement(
						"statusType",
						"input[name='st'][value='"
								+ strStatusTypesValue + "']", "css").getOne()
				.click();
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to click Resource
	   * Date        : 11/06/2014
	   * Author      : Anitha
	   **********************************************************************************/
	public EventManagement verifyResource(String[] strResourceValues)
			throws Exception {
		for (int i = 0; i < strResourceValues.length; i++) {
			objWaitForElement.waitForElements("//input[@value='"
					+ strResourceValues[i] + "'][@name='resourceID']", "xpath");

			assertTrue(this.page.element(
					"//input[@value='" + strResourceValues[i]
							+ "'][@name='resourceID']", "xpath")
					.isElementPresent());
		}
		return this;
	}

	/**********************************************************************************
	   * Description : This function is to click Resource
	   * Date        : 11/06/2014
	   * Author      : Anitha
	   **********************************************************************************/
	public EventManagement verifySubResourceNotPresent(
			String strSubResourceValue) throws Exception {
		
		assertFalse(this.page.element(
				"//input[@value='" + strSubResourceValue
						+ "'][@name='resourceID']", "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify error message when mandatory address not given
	 * Date        : 09/09/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public EventManagement verErrorWhenMandatoryAddNotGiven() throws Exception {
		objWaitForElement.waitForElements(errorMessageForST, "xpath");
		assertEquals(this.page.element(errorMessageForST + "[1]", "xpath")
				.getOne().getText(), "No city was provided.");
		assertEquals(this.page.element(errorMessageForST + "[2]", "xpath")
				.getOne().getText(), "No state was provided.");
		assertEquals(this.page.element(errorMessageForST + "[3]", "xpath")
				.getOne().getText(), "No county was provided.");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to fetch Acknowledgement Date
	 * Date        : 11/09/2015
	 * Author      : Sandhya
	 **********************************************************************************/
	public String getAcknowledgementDate() throws Exception {
		objWaitForElement.waitForElements(acknowledgementDate, "xpath");
		String time = this.page.element(acknowledgementDate, "xpath").getOne()
				.getText();
		String stracknowledgementDate = time.replace(" CDT", "");
		stracknowledgementDate = stracknowledgementDate.replace(" CST", "");
		return stracknowledgementDate;
	}
	
	
	/**********************************************************************************
	 * Description : This function is to clcik on event link
	 * Date        : 11/09/2015
	 * Author      : Anil
	 **********************************************************************************/
	public EventManagement clickOnEventLink() throws Exception {
		objWaitForElement.waitForElements(eventLink, "xpath");
		this.page.element(eventLink, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to clcik on event link
	 * Date        : 11/09/2015
	 * Author      : Anil
	 **********************************************************************************/
	public EventManagement verifyEventManagementLinkIsNotDisplayed() throws Exception {
		objWaitForElement.waitForElements(eventManagement, "xpath");
		assertFalse(this.page.element(eventManagement, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to clcik on event link
	 * Date        : 11/20/2015
	 * Author      : Sangappa K
	 **********************************************************************************/
	public EventManagement clickOnEventManagement() throws Exception {
		objWaitForElement.waitForElements(eventManagement, "xpath");
		this.page.element(eventManagement, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to get the date and time in web notification
	 * Date 		: 23/11/2015 
	 * Author 		: Renushree
	 **********************************************************************************/
	public String getTimeInWebNotification() throws Exception {
		objWaitForElement.waitForElements("dd.ts", "css");
		this.page.element("dd.ts", "css").getOne().isDisplayed();
		String strDateAndTime = this.page.element("dd.ts", "css").getOne()
				.getText();
		return strDateAndTime;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify event management link is dispalyed
	 * Date         :  23/11/2015 
	 * Author 		: Renushree
	 **********************************************************************************/
	public EventManagement verifyEventManagementLinkIsDisplayed()
			throws Exception {
		objWaitForElement.waitForElements(eventManagement, "xpath");
		assertTrue(this.page.element(eventManagement, "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Create AdHoc Event' Button is
	 * not displayed Date : 09/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifyCreateNewMultiRegionEventButtonIsDisplayed()
			throws Exception {
		objWaitForElement.waitForElements(createMultiRegionEventButton, "css");
		assertTrue(this.page.element(createMultiRegionEventButton, "css")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify resource name is displayed in create/edit resource name
	 * not displayed Date : 09/06/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifyResourceNameInCreateEventPage(String strResourceName)
			throws Exception {
		objWaitForElement.waitForElements("//table[@id='tbl_resourceID']/tbody/tr/td[2][text()='"+strResourceName+"']", "xpath");
		assertTrue(this.page.element("//table[@id='tbl_resourceID']/tbody/tr/td[2][text()='"+strResourceName+"']", "xpath")
				.getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to select status types in edit event page
	 * Date 		: 28/01/2016
	 * Author 		: Renushree
	 **********************************************************************************/
	public EventManagement verifyStatusTypesInEditEvePage(
			String[] strStatusTypeValues) throws Exception {
		for (int i = 0; i < strStatusTypeValues.length; i++) {
			objWaitForElement.waitForElements("//input[@value='" + strStatusTypeValues[i]
					+ "'][@name='st']", "xpath");
			assertTrue(this.page
					.dynamicElement(
							"StatusTypeValues",
							"//input[@value='" + strStatusTypeValues[i]
									+ "'][@name='st']", "xpath")
					.getOne().isDisplayed());
		}

		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify status types in event banner
	 * Date 		: 28/01/2016
	 * Author 		: Anil
	 **********************************************************************************/
	public EventManagement verifyStatusTypesInEventBannerPage(String strResourceType, String[] strStatusTypeValues) throws Exception {
		for (int i = 0; i < strStatusTypeValues.length; i++) {
			objWaitForElement.waitForElements("//table[starts-with(@id,'rtt')]/thead/tr/th[2]/a[text()='"+strResourceType+"']//ancestor::tr/th/a[text()='"+strStatusTypeValues[i]+"']", "xpath");
			assertTrue(this.page
					.dynamicElement(
							"StatusTypeValues",
							"//table[starts-with(@id,'rtt')]/thead/tr/th[2]/a[text()='"+strResourceType+"']//ancestor::tr/th/a[text()='"+strStatusTypeValues[i]+"']", "xpath")
					.getOne().isDisplayed());
		}

		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify EventName is displayed in event banner
	 * Date        : 28/07/2014 
	 * Author      : Anil
	 **********************************************************************************/
	public EventManagement verifyEventNameInOtherRegion(String strRegionName,
			String strEventName) throws Exception {
		objWaitForElement
				.waitForElements(
						"//div[@id='eventsBanner']/h1[text()='"
								+ strRegionName
								+ "']/following-sibling::table[1]/tbody/tr/td/a[text()='"
								+ strEventName + "']", "xpath");
		assertTrue(this.page
				.dynamicElement(
						strEventName + " is displayed in event banner row-wise",
						"//div[@id='eventsBanner']/h1[text()='"
								+ strRegionName
								+ "']/following-sibling::table[1]/tbody/tr/td/a[text()='"
								+ strEventName + "']", "xpath").getOne()
				.isDisplayed());

		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select Priavte Field
	 * Date        : 25/09/2014
	 * Author      : Anil
	 **********************************************************************************/
	public EventManagement selectPrivateField() throws Exception {
		objWaitForElement.waitForElements(multiEventPrivateField, "xpath");
		this.page.element(multiEventPrivateField, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is to verify evnt color, event icon and event name for an event
	 * Date			: 23-Feb-2016 
	 * Author		: Pallavi
	 **********************************************************************************/
	public EventManagement verEventColorAndIconInEventBanner(
			String strEventName, String strEventColor, String strAssociatedIcon)
			throws Exception {
		strEventColor = strEventColor.toLowerCase();
		String strElemt = "//td[contains(@class,'" + strEventColor
				+ "')]/a[contains(@style,'" + strAssociatedIcon
				+ "')][text()='" + strEventName + "']";
		objWaitForElement.waitForElements(strElemt, "xpath");
		assertTrue(this.page.element(strElemt, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description	: This function is to click on 'End' corresponding to an Event
	 * Date			: 24-Feb-2016 
	 * Author		: Pallavi
	 **********************************************************************************/
	public EventManagement clickOnEndEventOnly(String strEventName)
			throws Exception {
		String strElement = "//table/tbody/tr/td[text()='" + strEventName
				+ "']/preceding-sibling::td/a[text()='End']";
		objWaitForElement.waitForElements(strElement, "xpath");
		this.page.element(strElement, "xpath").getOne().sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		return this;
	}
	
	/**********************************************************************************
	  * Description	: This function is to click on 'End' corresponding to an Event
	 * Date			: 24-Feb-2016 
	 * Author		: Pallavi
	 **********************************************************************************/
	public EventManagement verifyAndAcceptToEndNeverEndingEvent()
			throws Exception {
		boolean bln = false;
		int i = 0; String strAlertMsg = "";
		while (!bln && i < 10) {
			try {
				Alert alert = driver.switchTo().alert();
				strAlertMsg = alert.getText();
				assertTrue(strAlertMsg
						.equals("Warning! The event you selected has no end date. "
								+ "Are you sure you want to end this event?\n\nPress OK to end the event. "
								+ "Press Cancel if you do NOT want to end the event."));
				alert.accept();
				bln = true;
			} catch (Exception e) {
				i++;
				Thread.sleep(1000);
			}
		}
		System.out.println(strAlertMsg);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify sub Resource name is not displayed
	 * Date :07/08/2014 Author : Anil
	 **********************************************************************************/
	public EventManagement verifySRSNameIsNotDisplayed(String strSubResourceName) throws Exception {
		assertFalse(this.page
				.dynamicElement(
						strSubResourceName,
						"//table[@id='tbl_resourceID']//td[2][text()='"
								+ strSubResourceName
								+ "']", "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is to verify Error mesage when no ET is selected while creating MRE. 
	 * Date 		: 2-Mar-2016
	 * Author		: Pallavi
	 **********************************************************************************/
	public EventManagement verifySelectETErrorMessage() throws Exception {
		objWaitForElement.waitForElements(selectETError, "xpath");
		assertTrue(this.page.element(selectETError, "xpath").getOne()
				.isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify resource name is not displayed in create/edit resource name not displayed
	 *  Date : 03/03/2014 
	 *  Author : Sangappa K
	 **********************************************************************************/
	public EventManagement verifyResourceNameNotDisplayedInCreateEventPage(
			String strResourceName) throws Exception {
		objWaitForElement.waitForElements(
				"//table[@id='tbl_resourceID']/tbody/tr/td[2][text()='"
						+ strResourceName + "']", "xpath");
		assertFalse(
				this.page
						.element(
								"//table[@id='tbl_resourceID']/tbody/tr/td[2][text()='"
										+ strResourceName + "']", "xpath")
						.isElementPresent(WaitTimeConstants.WAIT_TIME_TOO_SMALL),
				"Res " + strResourceName + " is displayed");
		return this;
	}

	/**********************************************************************************
	 * Description	: This function is to verify Event name in Create new Event screen
	 * Date 		: 09/06/2014
	 * Author		: Pallavi
	 **********************************************************************************/
	public EventManagement verifyEventNameInCreateEventPage(String strEventName)
			throws Exception {
		objWaitForElement.waitForElements(adHocEventName, "name");
		String strDispEventName = this.page.element(adHocEventName, "name")
				.getOne().getAttribute("value");
		assertTrue(strDispEventName.equals(strEventName), strDispEventName
				+ "displayed event name is not as expected" + strEventName);
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is to verify Event Information in Create new Event screen
	 * Date 		: 09/06/2014
	 * Author		: Pallavi
	 **********************************************************************************/
	public EventManagement verifyEventInfoInCreateEventPage(String strEventInfo)
			throws Exception {
		objWaitForElement.waitForElements(adHocEventDescription, "name");
		String strDispEventInfo = this.page
				.element(adHocEventDescription, "name").getOne().getAttribute("value");
		assertTrue(strDispEventInfo.equals(strEventInfo), strDispEventInfo
				+ "displayed event name is not as expected" + strEventInfo);
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is to select 'Display Event Banner' check box
	 * Date 		: 11-Mar-2016
	 * Author		: Pallavi
	 **********************************************************************************/
	public EventManagement selectCheckBoxOfDisplayInEventBanner()
			throws Exception {
		objWaitForElement.waitForElements(checkBoxOfDisplayInEventBanner,
				"xpath");
		if (this.page.element(checkBoxOfDisplayInEventBanner, "xpath").getOne()
				.isSelected() == false) {
			this.page.element(checkBoxOfDisplayInEventBanner, "xpath").getOne()
					.click();
		}
		assertTrue(this.page.element(checkBoxOfDisplayInEventBanner, "xpath")
				.getOne().isSelected());
		return this;
	}
	/********************************************************************************
	 * Description 	: This function is to verify status types is not displayed in event banner
	 * Date 		: 28/01/2016
	 * Author 		: Anil
	 **********************************************************************************/
	public EventManagement verifyStatusTypesIsNotInEventBannerPage(String strResourceType, String strStatusTypeValues) throws Exception {
			assertFalse(this.page
					.element(
							"//table[starts-with(@id,'rtt')]/thead/tr/th[2]/a[text()='"+strResourceType+"']//ancestor::tr/th/a[text()='"+strStatusTypeValues+"']", "xpath")
					.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));

		return this;
	}
}
