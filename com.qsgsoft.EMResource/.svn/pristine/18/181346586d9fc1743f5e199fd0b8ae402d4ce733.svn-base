package EMR.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import qaFramework.WaitTimeConstants;
import qaFramework.UserDefinedFunctions.Date_Time_settings;
import qaFramework.UserDefinedFunctions.WaitForElement;
import qaFramework.pageObject.PageObject;
import EMR.Locators.EventManagement.Locators;
import EMR.data.RegionData;

public class EventManagement extends PageObject {

	WebDriver driver;
	WaitForElement waitForElement;
	Login login;
	Alert alert;
	Date_Time_settings dts;
	Shared shared;
	View view;
	WebDriverWait wait;

	public EventManagement(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		waitForElement = new WaitForElement(this.driver);
		dts = new Date_Time_settings();
		login = new Login(this.driver);
		shared = new Shared(this.driver);
		view = new View(this.driver);
		wait = new WebDriverWait(this.driver, WaitTimeConstants.WAIT_TIME_LONG);
	}

	public EventManagement navigateToCreateNewEventScreen() throws Exception {
		waitForElement.waitForElements(Locators.CREATENEWEVENT, "css");
		this.page.element(Locators.CREATENEWEVENT, "css").getDisplayedOne().click();
		return this;
	}

	public EventManagement selectEventTemplate(String _eventTemplate)
			throws Exception {
		String eventTemplate = Locators.EVENTMANAGEMENTTABLE + Locators.TABLE_CELL_WITH_TEXT
				+ _eventTemplate + Locators.CLOSING_BRACKET
				+ Locators.SELECT_CREATE_OF_EVENT_TEMPLATE;
		waitForElement.waitForElements(eventTemplate, "xpath");
		this.page.element(eventTemplate, "xpath").clickUsingJSE();
		return this;
	}

	public EventManagement enterEventName(String _eventName) throws Exception {
		waitForElement.waitForElements(Locators.EVENTNAME, "name");
		this.page.element(Locators.EVENTNAME, "name").clearInputValue()
		.sendKeys(_eventName);
		assertTrue(this.page.element(Locators.EVENTNAME, "name").getOne().getAttribute("value").equals(_eventName));
		System.out.println(_eventName);
		return this;
	}

	public EventManagement enterEventDescription(String _eventDescription)
			throws Exception {
		waitForElement.waitForElements(Locators.EVENTDESCRIPTION, "name");
		this.page.element(Locators.EVENTDESCRIPTION, "name").clearInputValue()
		.sendKeys(_eventDescription);
		assertTrue(this.page.element(Locators.EVENTDESCRIPTION, "name").getOne().getAttribute("value").equals(_eventDescription));
		return this;
	}

	public EventManagement clickOnSave() throws Exception {
		waitForElement.waitForElements(Locators.SAVE, "css");
		this.page.element(Locators.SAVE, "css").getOne().click();
		return this;
	}

	public EventManagement verifyEventNameIsDisplayed(String eventName)
			throws Exception {
		waitForElement.waitForElements(Locators.EVENTMANAGEMENTTABLE
				+ Locators.TABLECELL + eventName + Locators.CLOSING_BRACKET, "xpath");
		assertTrue(this.page.element(Locators.EVENTMANAGEMENTTABLE
				+ Locators.TABLECELL + eventName + Locators.CLOSING_BRACKET, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.EVENTMANAGEMENTTABLE
				+ Locators.TABLECELL + eventName + Locators.CLOSING_BRACKET, "xpath").getOne()
				.isDisplayed());
		return this;
	}

	public EventManagement createEvent(String eventTemplate, String eventName,
			String eventDescription, String resourceName) throws Exception {
		this.navigateToCreateNewEventScreen();
		this.selectEventTemplate(eventTemplate);
		this.verifyCancelAndSaveButton();
		this.enterEventName(eventName);
		System.out.println(eventName);
		this.enterEventDescription(eventDescription);
		this.selectResource(resourceName);
		this.clickOnSave();
		return this;
	}
	
	public EventManagement endEvent(String eventName) throws Exception {
		boolean alertIsPresnt = false;
		boolean bln = false;
		int i = 0;
		String endEvent = Locators.EVENTMANAGEMENTTABLE + Locators.TABLECELL + eventName + Locators.ENDEVENTPART2;
		try {
			try {
				this.page.element(endEvent, "xpath").scrollDownTillElement(this.page.element(endEvent, "xpath").getOne());
				this.page.element(endEvent, "xpath").getOne().click();
				System.out.println("clicked with click method");
				while (!bln && i < 5) {
					try {
						System.out.println("trying to switch to alert");
						alert = driver.switchTo().alert();
						break;
					} catch (Exception e) {
						System.out.println("got exception");
						i = i++;
						Thread.sleep(1000);
						continue;
					}
				}
				alertIsPresnt = driver.switchTo().alert() != null;
				System.out.println("1: "+alertIsPresnt);
				assertTrue(alertIsPresnt);
			}catch(Exception e) {
				this.page.element(endEvent, "xpath").getOne().sendKeys(Keys.ENTER);
				System.out.println("clicked with sendkeys");
				alertIsPresnt = driver.switchTo().alert() != null;
				System.out.println("2: "+alertIsPresnt);
				assertTrue(alertIsPresnt);
			}
		} catch (Exception e) {
			this.page.element(endEvent, "xpath").mouseOver();
			this.page.element(endEvent, "xpath").Click();
			System.out.println("clicked with mouse hover and click");
			alertIsPresnt = driver.switchTo().alert() != null;
			System.out.println("3: "+alertIsPresnt);
			assertTrue(alertIsPresnt);
		}
		try {
			alert.accept();
			System.out.println("clicked on ok button");
		} catch (Exception e) {
			i++;
			Thread.sleep(1000);
		}
		return this;
	}

	public EventManagement clickOnAcceptOfAlert() throws Exception {
		boolean bln = false;
		int i = 0;
		while (!bln && i < 5) {
			try {
				alert = driver.switchTo().alert();
				alert.accept();
				System.out.println("clicked on ok button");
			} catch (Exception e) {
				i++;
				Thread.sleep(1000);
			}
		}
		return this;
	}

	public EventManagement verifyWebNotificationframe() throws Exception {
		WebDriverWait wait = new WebDriverWait(this.driver,
				WaitTimeConstants.COUNT);
		wait.until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(Locators.WEBNOTIFICATIONFRAME));
		return this;
	}

	public EventManagement verifyWebNotificationContent(String eventName,
			String eventDesc) throws Exception {
		waitForElement.waitForElements(Locators.HEADEROFNOTIFICATION, "css");
		this.page.element(Locators.HEADEROFNOTIFICATION, "css").getOne().isDisplayed();
		this.page.element(Locators.DESCRIPTIONOFNOTIFICATION, "css").getOne().isDisplayed();
		assertEquals(eventName,
				this.page.element(Locators.HEADEROFNOTIFICATION, "css").getOne().getText());
		assertEquals(eventDesc,
				this.page.element(Locators.DESCRIPTIONOFNOTIFICATION, "css").getOne().getText());
		return this;
	}

	public EventManagement clickOnAcknowledgeAllNotifications()
			throws Exception {
		waitForElement.waitForElements(Locators.ACKNOWLWDGENOTIFICATION,
				"xpath");
		this.page.element(Locators.ACKNOWLWDGENOTIFICATION, "xpath").clickUsingJSE();
		try{
			this.page.element_wait(Locators.ACKNOWLWDGENOTIFICATION, "xpath").waitForInvisibilityOfElement();
		}
		catch(Exception e) {
		}

		return this;
	}

	public EventManagement verifyWebNotificationAndClickOnAcknowledge(
			String eventName, String eventDesc) throws Exception {
		this.verifyWebNotificationframe();
		this.verifyWebNotificationContent(eventName, eventDesc);
		this.clickOnAcknowledgeAllNotifications();
		login.switchToDefaultWindow();
		login.selectFrame();
		return this;
	}

	public EventManagement selectResource(String resourceName) throws Exception {
		waitForElement.waitForElements(
				Locators.PARTICIPATINGRESOURCEINPUTPART1 + resourceName + "']"
						+ Locators.PARTICIPATINGRESOURCEINPUTPART2, "xpath");
		this.page
		.element(
				Locators.PARTICIPATINGRESOURCEINPUTPART1 + resourceName
				+ "']"
				+ Locators.PARTICIPATINGRESOURCEINPUTPART2,
				"xpath").getDisplayedOne().click();
		return this;
	}

	public EventManagement verifyEndedEventWebNotification(String eventName,
			String endedEventName, String endedEventDescription) throws Exception {
		this.verifyEventNameIsDisplayed(eventName);
		this.verifyWebNotificationframe();
		this.verifyWebNotificationContent(endedEventName, endedEventDescription);
		return this;
	}

	public String getTimeInWebNotification() throws Exception {
		waitForElement.waitForElements("dd.ts", "css");
		String dateAndTime = this.page.element("dd.ts", "css").getOne().getText();
		return dateAndTime;	
	}

	public EventManagement VerifyAndDeleteAllPreviouslyCreatedEvent(String eventTemplate) throws Exception {
		while(this.page.element(Locators.TABLECELLWITHTEXT + eventTemplate + Locators.EVENTTEMPLATEPART2 + "Ongoing" + Locators.CLOSEBRACKETS, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE)) {
			this.page.element(Locators.TABLECELLWITHTEXT + eventTemplate + Locators.EVENTTEMPLATEPART2 + "Ongoing" + Locators.EVENTTEMPLATEPART3 + "End"+ Locators.CLOSEBRACKETS, "xpath").getOne().click();
			this.clickOnAcceptOfAlert();
		}
		return this;
	}

	public EventManagement clickOnCreateNewMultiRegionEvent() throws Exception {
		waitForElement.waitForElements(Locators.CREATENEWMULTIREGIONEVENT, "css");
		this.page.element(Locators.CREATENEWMULTIREGIONEVENT, "css").clickUsingJSE();
		return this;
	}

	public EventManagement selectParticipatingRegion(String[] region, String[] eventTemplate) throws Exception{
		for(int intCount=0; intCount<region.length; intCount++)
		{
			waitForElement.waitForElements(Locators.PARTICIPATINGRESOURCEINPUTPART1+ region[intCount] + Locators.CLOSING_BRACKET + Locators.PARTICIPATING_REGION_PART1 , "xpath");
			this.page.element(Locators.PARTICIPATINGRESOURCEINPUTPART1+ region[intCount] + Locators.CLOSING_BRACKET + Locators.PARTICIPATING_REGION_PART1 , "xpath").webElementToSelect().selectByVisibleText(eventTemplate[intCount]);
			assertTrue(this.page.element(Locators.PARTICIPATINGRESOURCEINPUTPART1+ region[intCount] + Locators.CLOSING_BRACKET + Locators.PARTICIPATING_REGION_PART1 , "xpath").webElementToSelect().getFirstSelectedOption().getText().equals(eventTemplate[intCount]));
		}
		return this;
	}

	public EventManagement clickNext() throws Exception {
		waitForElement.waitForElements(Locators.NEXT, "css");
		try{
			this.page.element(Locators.NEXT, "css").clickUsingJSE();

			if (this.page.element(Locators.MULTIREGIONEVENTCONFIRMATION, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL) == false) {
				this.page.element(Locators.NEXT, "css").getDisplayedOne().click();
				waitForElement.waitForElements(Locators.MULTIREGIONEVENTCONFIRMATION,"xpath" );
			}
			if(this.page.element(EMR.Locators.EventManagement.Locators.MULTIREGIONEVENTCONFIRMATION, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL)==false) {
				this.page.element(Locators.NEXT, "css").getDisplayedOne().sendKeys(Keys.ENTER);
			}
			waitForElement.waitForElements(Locators.MULTIREGIONEVENTCONFIRMATION,"xpath" );
			assertTrue(this.page.element(EMR.Locators.EventManagement.Locators.MULTIREGIONEVENTCONFIRMATION, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL));
		} catch(Exception e) {

		}
		return this;
	}

	public EventManagement verifyMultiregionEventConfirmationPage() throws Exception {
		waitForElement.waitForElements(Locators.MULTIREGIONEVENTCONFIRMATION, "xpath");
		assertTrue(this.page.element(Locators.MULTIREGIONEVENTCONFIRMATION, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.MULTIREGIONEVENTCONFIRMATION, "xpath").getOne().isDisplayed());
		return this;
	}

	public EventManagement clickYes() throws Exception {
		waitForElement.waitForElements(Locators.YES, "css");
		try{
			this.page.element(Locators.YES, "css").clickUsingJSE();

			if (this.page.element(Locators.EVENT_MANAGEMENT, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL) == false) {
				this.page.element(Locators.YES, "css").getDisplayedOne().click();
			}
			if(this.page.element(EMR.Locators.EventManagement.Locators.EVENT_MANAGEMENT, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL)==false) {
				this.page.element(Locators.YES, "css").getDisplayedOne().sendKeys(Keys.ENTER);
			}
			assertTrue(this.page.element(EMR.Locators.EventManagement.Locators.EVENT_MANAGEMENT, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL));
		} catch(Exception e) {

		}
		return this;
	}

	public EventManagement createFutureMultiregionEvent(String eventName, String eventDescription,int startDate,int startHours,int endDate,int endHours, String[] regionNames, String[] eventTemplateNames) throws Exception {
		this.enterEventName(eventName);
		this.enterEventDescription(eventDescription);
		this.selectAndRetriveFutureStartEventDateAndTime(startDate, startHours);
		this.selectAndRetriveFutureEndEventDateAndTime(endDate, endHours);
		this.selectParticipatingRegion(regionNames, eventTemplateNames);
		this.clickNext();
		this.verifyMultiregionEventConfirmationPage();
		this.clickKeep();
		this.verifyMultiregionEventConfirmationPage();
		this.clickYes();
		return this;
	}

	public EventManagement enterStreetAdress(String streetAdress) throws Exception {
		waitForElement.waitForElements(Locators.STREET_ADDRESS, "id");
		this.page.element(Locators.STREET_ADDRESS, "id").clearInputValue().sendKeys(streetAdress);
		return this;
	}

	public EventManagement enterCity(String city) throws Exception {
		waitForElement.waitForElements(Locators.CITY, "id");
		this.page.element(Locators.CITY, "id").clearInputValue().sendKeys(city);
		return this;
	}

	public EventManagement selectState(String state) throws Exception {
		waitForElement.waitForElements(Locators.STATE, "id");
		this.page.element(Locators.STATE, "id").webElementToSelect().selectByVisibleText(state);
		assertTrue(this.page.element(Locators.STATE, "id").webElementToSelect().getFirstSelectedOption().getText().equals(state), state + "is not selected");
		return this;
	}

	public EventManagement enterZipcode(String zipCode) throws Exception {
		waitForElement.waitForElements(Locators.ZIPCODE, "id");
		this.page.element(Locators.ZIPCODE, "id").clearInputValue().sendKeys(zipCode);
		return this;
	}

	public EventManagement selectEventStartMonth(String eventStartMonth) throws Exception {
		waitForElement.waitForElements(Locators.EVENT_START_MONTH, "name");
		this.page.element(Locators.EVENT_START_MONTH, "name").webElementToSelect().selectByVisibleText(eventStartMonth);
		assertTrue(this.page.element(Locators.EVENT_START_MONTH, "name").webElementToSelect().getFirstSelectedOption().getText().equals(eventStartMonth), eventStartMonth + "is not selected");
		return this;
	}

	public EventManagement selectEventStartDay(String eventStartDay) throws Exception {
		waitForElement.waitForElements(Locators.EVENT_START_DAY, "name");
		if(eventStartDay.startsWith("0")){
			eventStartDay=eventStartDay.replace("0","");
		}
		this.page.element(Locators.EVENT_START_DAY, "name").webElementToSelect().selectByVisibleText(eventStartDay);
		assertTrue(this.page.element(Locators.EVENT_START_DAY, "name").webElementToSelect().getFirstSelectedOption().getText().equals(eventStartDay), eventStartDay+ "is not selected");
		return this;
	}

	public EventManagement selectEventStartYear(String eventStartYear) throws Exception {
		waitForElement.waitForElements(Locators.EVENT_START_YEAR, "name");
		this.page.element(Locators.EVENT_START_YEAR, "name").webElementToSelect().selectByVisibleText(eventStartYear);
		assertTrue(this.page.element(Locators.EVENT_START_YEAR, "name").webElementToSelect().getFirstSelectedOption().getText().equals(eventStartYear), eventStartYear+"is not selected.");
		return this;
	}

	public EventManagement selectEventStartHour(String eventStartHour) throws Exception {
		waitForElement.waitForElements(Locators.EVENT_START_HOUR, "name");
		this.page.element(Locators.EVENT_START_HOUR, "name").webElementToSelect().selectByVisibleText(eventStartHour);
		assertTrue(this.page.element(Locators.EVENT_START_HOUR, "name").webElementToSelect().getFirstSelectedOption().getText().equals(eventStartHour), eventStartHour+" is not selected.");
		return this;
	}

	public EventManagement selectEventStartMinute(String eventStartMinute) throws Exception {
		waitForElement.waitForElements(Locators.EVENT_START_MINUTE, "name");
		this.page.element(Locators.EVENT_START_MINUTE, "name").webElementToSelect().selectByVisibleText(eventStartMinute);
		assertTrue(this.page.element(Locators.EVENT_START_MINUTE, "name").webElementToSelect().getFirstSelectedOption().getText().equals(eventStartMinute), eventStartMinute+ " is not selected.");
		return this;
	}

	public String getEventStartMonth() throws Exception {
		String startMonth = this.page.element(Locators.GET_EVENT_START_MONTH, "xpath").getOne().getText();
		return startMonth;
	}

	public String getEventStartDay() throws Exception {
		String startDay = this.page.element(Locators.GET_EVENT_START_DAY, "xpath").getOne().getText();
		return startDay;
	}

	public String getEventStartYear() throws Exception {
		String startYear = this.page.element(Locators.GET_EVENT_START_YEAR, "xpath").getOne().getText();
		return startYear;
	}

	public String getEventStartHour() throws Exception {
		String startHour = this.page.element(Locators.GET_EVENT_START_HOUR, "xpath").getOne().getText();
		return startHour;
	}

	public String getEventStartMinute() throws Exception {
		String startMinute = this.page.element(Locators.GET_EVENT_START_MINUTE, "xpath").getOne().getText();
		return startMinute;
	}

	public String getEventStartDateAndTime() throws Exception {
		String strEventTime[] = new String[5];
		strEventTime[0] = this.getEventStartMonth();
		strEventTime[1]	= this.getEventStartDay();
		strEventTime[2]	= this.getEventStartYear();
		strEventTime[3]	= this.getEventStartHour();
		strEventTime[4]	= this.getEventStartMinute();
		String eventStartDateAndTime = strEventTime[0] + "-" 
				+ strEventTime[1] + "-" + strEventTime[2] + ""
				+ strEventTime[3] + ":" + strEventTime[4];
		return eventStartDateAndTime;
	}

	public EventManagement selectStartDateAndTime(String[] eventStartDateAndTime ) throws Exception {
		this.selectEventStartMonth(eventStartDateAndTime[0]);
		this.selectEventStartDay(eventStartDateAndTime[1]);
		this.selectEventStartYear(eventStartDateAndTime[2]);
		this.selectEventStartHour(eventStartDateAndTime[3]);
		this.selectEventStartMinute(eventStartDateAndTime[4]);
		return this;
	}

	public EventManagement clickKeep() throws Exception {
		waitForElement.waitForElements(Locators.KEEP_BUTTON, "css");
		this.page.element(Locators.KEEP_BUTTON, "css").clickUsingJSE();
		return this;
	}

	public EventManagement verifyEventStatus(String eventName,String status) throws Exception {
		waitForElement.waitForElements(Locators.PARTICIPATINGRESOURCEINPUTPART1 + eventName + Locators.CLOSING_BRACKET + Locators.PRECEDING_COLOUMN_OF_TITLE + status + Locators.CLOSING_BRACKET , "xpath");
		assertTrue(this.page.element(Locators.PARTICIPATINGRESOURCEINPUTPART1 + eventName + Locators.CLOSING_BRACKET + Locators.PRECEDING_COLOUMN_OF_TITLE + status + Locators.CLOSING_BRACKET , "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.PARTICIPATINGRESOURCEINPUTPART1 + eventName + Locators.CLOSING_BRACKET + Locators.PRECEDING_COLOUMN_OF_TITLE + status + Locators.CLOSING_BRACKET , "xpath").getOne().isDisplayed());
		return this;
	}

	public EventManagement verifyEventTemplate(String eventName, String template) throws Exception {
		waitForElement.waitForElements(Locators.PARTICIPATINGRESOURCEINPUTPART1 + eventName + Locators.CLOSING_BRACKET + Locators.FOLLOWING_COLOUMN_OF_TITLE + template + Locators.CLOSING_BRACKET, "xpath");
		assertTrue(this.page.element(Locators.PARTICIPATINGRESOURCEINPUTPART1 + eventName + Locators.CLOSING_BRACKET + Locators.FOLLOWING_COLOUMN_OF_TITLE + template + Locators.CLOSING_BRACKET, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.PARTICIPATINGRESOURCEINPUTPART1 + eventName + Locators.CLOSING_BRACKET + Locators.FOLLOWING_COLOUMN_OF_TITLE + template + Locators.CLOSING_BRACKET, "xpath").getOne().isDisplayed());
		return this;
	}

	public EventManagement verifyCreateMultiregionEventPage() throws Exception {
		waitForElement.waitForElements(Locators.CREATEMULTIREGIONEVENTPAGE, "xpath");
		assertTrue(this.page.element(Locators.CREATEMULTIREGIONEVENTPAGE, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.CREATEMULTIREGIONEVENTPAGE, "xpath").getOne().isDisplayed());
		return this;
	}

	public EventManagement verifyEventManagementPage() throws Exception {
		waitForElement.waitForElements(Locators.EVENT_MANAGEMENT, "xpath");
		assertTrue(this.page.element(Locators.EVENT_MANAGEMENT, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.EVENT_MANAGEMENT, "xpath").getOne().isDisplayed());
		return this;
	}

	public EventManagement selectCounty(String county) throws Exception {
		waitForElement.waitForElements(Locators.COUNTY, "id");
		this.page.element(Locators.COUNTY, "id").webElementToSelect().selectByVisibleText(county);
		assertTrue(this.page.element(Locators.COUNTY, "id").webElementToSelect().getFirstSelectedOption().getText().equals(county), county + "is not selected");
		return this;
	}

	public String[] addDaysAndTimeForFutureEvent(int days, int hours) throws Exception {
		String eventStartTime = shared.getApplicationTimeWithTimeZone();
		String[] applicationDateAndTime = eventStartTime.split(" ");
		String applicationDate = applicationDateAndTime[0]+" "+applicationDateAndTime[1]+ " "+ dts.getCurrentDate("yyyy");
		String applicationTime = applicationDateAndTime[2];
		String addedDate = dts.AddDaytoExistingDate(applicationDate, days, "d MMM yyyy");
		String addedTime = dts.addTimetoExistingHour(applicationTime, hours, "HH:mm");
		String addedDateAndTime = addedDate + " " + addedTime;
		String[] FutureDateAndTime = addedDateAndTime.split(" ");
		return FutureDateAndTime;
	}

	public EventManagement verifyEventManagementLinkNotPresent() throws Exception {
		assertFalse(this.page.element(Locators.EVENT_MANAGEMENT, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}

	public EventManagement enterAddress(String city,String state,String zipCode, String county)throws Exception{
		//	this.enterStreetAdress(streetAdress);
		this.enterCity(city);
		this.selectState(state);
		this.enterZipcode(zipCode);
		this.selectCounty(county);
		this.lookUpAddress();
		return this;
	}	

	public EventManagement verifyEventName() throws Exception {
		waitForElement.waitForElements(Locators.EVENTNAME, "name");
		assertTrue(this.page.element(Locators.EVENTNAME, "name").isElementPresent());
		assertTrue(this.page.element(Locators.EVENTNAME, "name").getOne().isDisplayed());
		return this;
	}

	public EventManagement verifyEventDescription() throws Exception {
		waitForElement.waitForElements(Locators.EVENTDESCRIPTION, "name");
		assertTrue(this.page.element(Locators.EVENTDESCRIPTION, "name").isElementPresent());
		assertTrue(this.page.element(Locators.EVENTDESCRIPTION, "name").getOne().isDisplayed());
		return this;
	}

	public EventManagement verifyStreetAddress() throws Exception {
		waitForElement.waitForElements(Locators.STREET_ADDRESS, "id");
		assertTrue(this.page.element(Locators.STREET_ADDRESS, "id").isElementPresent());
		assertTrue(this.page.element(Locators.STREET_ADDRESS, "id").getOne().isDisplayed());
		return this;
	}

	public EventManagement verifyCity() throws Exception {
		waitForElement.waitForElements(Locators.CITY, "id");
		assertTrue(this.page.element(Locators.CITY, "id").isElementPresent());
		assertTrue(this.page.element(Locators.CITY, "id").getOne().isDisplayed());
		return this;
	}

	public EventManagement verifyState() throws Exception {
		waitForElement.waitForElements(Locators.STATE, "id");
		assertTrue(this.page.element(Locators.STATE, "id").isElementPresent());
		assertTrue(this.page.element(Locators.STATE, "id").getOne().isDisplayed());
		return this;
	}

	public EventManagement verifyZipCode() throws Exception {
		waitForElement.waitForElements(Locators.ZIPCODE, "id");
		assertTrue(this.page.element(Locators.ZIPCODE, "id").isElementPresent());
		assertTrue(this.page.element(Locators.ZIPCODE, "id").getOne().isDisplayed());
		return this;
	}

	public EventManagement verifyCounty() throws Exception {
		waitForElement.waitForElements(Locators.COUNTY, "id");
		assertTrue(this.page.element(Locators.COUNTY, "id").isElementPresent());
		assertTrue(this.page.element(Locators.COUNTY, "id").getOne().isDisplayed());
		return this;
	}

	public EventManagement verifyEventAddress() throws Exception {
		this.verifyStreetAddress();
		this.verifyCity();
		this.verifyState();
		this.verifyZipCode();
		this.verifyCounty();
		this.verifyLatitudeAndLongitudeOption();
		return this;

	}

	public EventManagement verifyParticipatingRegion(String[] region) throws Exception {
		for(int intCount=0; intCount<region.length; intCount++)
		{
			waitForElement.waitForElements(Locators.PARTICIPATINGRESOURCEINPUTPART1+ region[intCount] + Locators.CLOSING_BRACKET + Locators.PARTICIPATING_REGION_PART1 , "xpath");
			assertTrue(this.page.element(Locators.PARTICIPATINGRESOURCEINPUTPART1+ region[intCount] + Locators.CLOSING_BRACKET + Locators.PARTICIPATING_REGION_PART1 , "xpath").isElementPresent());
			assertTrue(this.page.element(Locators.PARTICIPATINGRESOURCEINPUTPART1+ region[intCount] + Locators.CLOSING_BRACKET + Locators.PARTICIPATING_REGION_PART1 , "xpath").getOne().isDisplayed());
		}
		return this;
	}

	public EventManagement verifyEventStartImmediately() throws Exception {
		waitForElement.waitForElements(Locators.EVENTSTART_IMMEDIATELY, "xpath");
		assertTrue(this.page.element(Locators.EVENTSTART_IMMEDIATELY, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.EVENTSTART_IMMEDIATELY, "xpath").getOne().isDisplayed());
		return this;
	}

	public EventManagement verifyEventStartdate() throws Exception {
		waitForElement.waitForElements(Locators.EVENTSTART_DATE, "xpath");
		assertTrue(this.page.element(Locators.EVENTSTART_DATE, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.EVENTSTART_DATE, "xpath").getOne().isDisplayed());
		return this;
	}

	public EventManagement verifyEventEndHour() throws Exception {
		waitForElement.waitForElements(Locators.EVENTEND_HOUR, "xpath");
		assertTrue(this.page.element(Locators.EVENTEND_HOUR, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.EVENTEND_HOUR, "xpath").getOne().isDisplayed());
		return this;
	}

	public EventManagement verifyEventEndDate() throws Exception {
		waitForElement.waitForElements(Locators.EVENTEND_DATE, "css");
		assertTrue(this.page.element(Locators.EVENTEND_DATE, "css").isElementPresent());
		assertTrue(this.page.element(Locators.EVENTEND_DATE, "css").getOne().isDisplayed());
		return this;
	}

	public EventManagement verifyEventEndNever() throws Exception {
		waitForElement.waitForElements(Locators.EVENTEND_NEVER, "css");
		assertTrue(this.page.element(Locators.EVENTEND_NEVER, "css").isElementPresent());
		assertTrue(this.page.element(Locators.EVENTEND_NEVER, "css").getOne().isDisplayed());
		return this;
	}

	public EventManagement verifyEventStartOption() throws Exception {
		this.verifyEventStartImmediately();
		this.verifyEventStartdate();
		return this;
	}

	public EventManagement verifyEventEndOption() throws Exception {
		this.verifyEventEndHour();
		this.verifyEventEndDate();
		this.verifyEventEndNever();
		return this;
	}

	public EventManagement verifyDocumentUploadOptionIsPresent() throws Exception {
		waitForElement.waitForElements(Locators.BROWSE_OPTION, "name");
		assertTrue(this.page.element(Locators.BROWSE_OPTION, "name").isElementPresent());
		assertTrue(this.page.element(Locators.BROWSE_OPTION, "name").getOne().isDisplayed());
		return this;
	}

	public EventManagement verifyDisplayInEventBanner() throws Exception {
		waitForElement.waitForElements(Locators.DISPLAY_IN_EVENT_BANNER, "name");
		assertTrue(this.page.element(Locators.DISPLAY_IN_EVENT_BANNER, "name").isElementPresent());
		assertTrue(this.page.element(Locators.DISPLAY_IN_EVENT_BANNER, "name").getOne().isSelected());
		return this;
	}

	public EventManagement verifyPrivateOption() throws Exception {
		waitForElement.waitForElements(Locators.PRIVATE, "name");
		assertTrue(this.page.element(Locators.PRIVATE, "name").isElementPresent());
		assertTrue(this.page.element(Locators.PRIVATE, "name").getOne().isDisplayed());
		return this;
	}

	public EventManagement verifyDrillOption() throws Exception {
		waitForElement.waitForElements(Locators.DRILL, "name");
		assertTrue(this.page.element(Locators.DRILL, "name").isElementPresent());
		assertTrue(this.page.element(Locators.DRILL, "name").getOne().isDisplayed());
		return this;
	}

	public EventManagement verifyEndQuietly() throws Exception {
		waitForElement.waitForElements(Locators.END_QUIETLY, "name");
		assertTrue(this.page.element(Locators.END_QUIETLY, "name").isElementPresent());
		assertTrue(this.page.element(Locators.END_QUIETLY, "name").getOne().isDisplayed());
		return this;
	}

	public EventManagement verifyLatitudeAndLongitudeOption() throws Exception {
		waitForElement.waitForElements(Locators.LATITUDE, "id");
		assertTrue(this.page.element(Locators.LATITUDE, "id").isElementPresent());
		assertTrue(this.page.element(Locators.LATITUDE, "id").getOne().isDisplayed());
		assertTrue(this.page.element(Locators.LONGITUDE, "id").isElementPresent());
		assertTrue(this.page.element(Locators.LONGITUDE, "id").getOne().isDisplayed());
		assertTrue(this.page.element(Locators.LOOKUP_ADDRESS, "css").isElementPresent());
		assertTrue(this.page.element(Locators.LOOKUP_ADDRESS, "css").getOne().isDisplayed());
		assertTrue(this.page.element(Locators.VIEW_MAP, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.VIEW_MAP, "xpath").getOne().isDisplayed());
		return this;
	}

	public EventManagement clickLookUpAddress() throws Exception {
		waitForElement.waitForElements(Locators.LOOKUP_ADDRESS, "css");
		this.page.element(Locators.LOOKUP_ADDRESS, "css").clickUsingJSE();
		return this;
	}

	public EventManagement verifyAllFieldsInCreateEventsScreen(String[] regionName) throws Exception {
		this.clickOnCreateNewMultiRegionEvent();
		this.verifyCreateMultiregionEventPage();
		this.verifyEventName();
		this.verifyEventDescription();
		this.verifyEventStartOption();
		this.verifyEventEndOption();
		this.verifyDocumentUploadOptionIsPresent();
		this.verifyDisplayInEventBanner();
		this.verifyPrivateOption();
		this.verifyDrillOption();
		this.verifyEndQuietly();
		this.verifyEventAddress();
		this.verifyParticipatingRegion(regionName);
		this.verifyIncludeAllResourcesIsSelected();
		return this;
	}

	public EventManagement clickEditLink(String eventName) throws Exception{
		waitForElement.waitForElements(Locators.EVENT_NAME_IN_TABLE + eventName + Locators.CLOSING_BRACKET + Locators.EDIT_EVENT_NAME, "xpath");
		try{
			this.page.element(Locators.EVENT_NAME_IN_TABLE + eventName + Locators.CLOSING_BRACKET + Locators.EDIT_EVENT_NAME, "xpath").clickUsingJSE();

			if (this.page.element(Locators.EDIT_MULTI_REGION_EVENT_PAGE, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL) == false) {
				this.page.element(Locators.EVENT_NAME_IN_TABLE + eventName + Locators.CLOSING_BRACKET + Locators.EDIT_EVENT_NAME, "xpath").getOne().click();
				waitForElement.waitForElements(Locators.EDIT_MULTI_REGION_EVENT_PAGE,"xpath" );
			}
			if(this.page.element(EMR.Locators.EventManagement.Locators.EDIT_MULTI_REGION_EVENT_PAGE, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL)==false) {
				this.page.element(Locators.EVENT_NAME_IN_TABLE + eventName + Locators.CLOSING_BRACKET + Locators.EDIT_EVENT_NAME, "xpath").getOne().sendKeys(Keys.ENTER);
			}
			waitForElement.waitForElements(Locators.EDIT_MULTI_REGION_EVENT_PAGE,"xpath" );
			assertTrue(this.page.element(EMR.Locators.EventManagement.Locators.EDIT_MULTI_REGION_EVENT_PAGE, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL));
		} catch(Exception e) {

		}
		return this;
	}

	public EventManagement verifyEditLink(String eventName) throws Exception {
		waitForElement.waitForElements(Locators.EVENT_NAME_IN_TABLE + eventName + Locators.CLOSING_BRACKET + Locators.EDIT_EVENT_NAME, "xpath");
		assertTrue(this.page.element(Locators.EVENT_NAME_IN_TABLE + eventName + Locators.CLOSING_BRACKET + Locators.EDIT_EVENT_NAME, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.EVENT_NAME_IN_TABLE + eventName + Locators.CLOSING_BRACKET + Locators.EDIT_EVENT_NAME, "xpath").getOne().isDisplayed());
		return this;
	}

	public EventManagement verifyEventDetails(String eventName, String status, String template, String eventInformation, String startTime, String endTime) throws Exception {
		this.verifyEventStatus(eventName, status);
		this.verifyEventTemplate(eventName, template);
		this.verifyEventInformation(eventName, eventInformation);
		this.verifyEventStartDate(eventName, startTime);
		this.verifyEventEndDate(eventName, endTime);
		this.verifyEventManagementPage();
		return this;
	}

	public EventManagement verifyIncludeAllResourcesIsSelected()throws Exception {
		waitForElement.waitForElements(Locators.INCLUDE_ALL_RESOURCES_CHECKBOX, "css");
		assertTrue(this.page.element(Locators.INCLUDE_ALL_RESOURCES_CHECKBOX, "css").isElementPresent());
		assertTrue(this.page.element(Locators.INCLUDE_ALL_RESOURCES_CHECKBOX, "css").getOne().isSelected());
		return this;
	}

	public EventManagement enterEndAfterSpecificHoursOfAnEvent(String eventEndDate)
			throws Exception {
		waitForElement.waitForElements(Locators.END_DATE, "css");
		this.page.element(Locators.END_DATE, "css").clearInputValue()
		.sendKeys(eventEndDate);
		assertTrue(this.page.element(Locators.END_DATE, "css").getOne().getAttribute("value").equals(eventEndDate));
		return this;
	}

	public String[] createMultiRegionEventWithEndAtSpecificDate(String eventName, String eventDescription, String eventEndDate,String[] regionName, String[] eventTemplateName, int hour) throws Exception {
		this.enterEventName(eventName);
		this.enterEventDescription(eventDescription);
		this.enterEndAfterSpecificHoursOfAnEvent(eventEndDate);
		this.selectParticipatingRegion(regionName, eventTemplateName);
		this.clickNext();
		String applicationTime = shared.getApplicationTime();
		String currentYear = dts.getCurrentDate("yyyy");
		applicationTime = applicationTime + " " + currentYear;
		applicationTime = dts.converDateFormat(applicationTime,
				"dd MMM HH:mm yyyy", "yyyy-MM-dd HH:mm");
		System.out.println("converted time"+ applicationTime);
		String applicationTimePlusHour = dts.addTimetoExistingHour(applicationTime, hour, "yyyy-MM-dd HH:mm");
		this.clickYes();
		String[] dates= {applicationTime, applicationTimePlusHour};
		return dates;
	}

	public EventManagement navigateToEventStatusFromEventBanner(String eventName) throws Exception {
		waitForElement.waitForElements(Locators.EVENT_IN_EVENT_BANNER_PART1 + eventName + Locators.CLOSING_BRACKET, "xpath");
		assertTrue(this.page.element(Locators.EVENT_IN_EVENT_BANNER_PART1 + eventName + Locators.CLOSING_BRACKET, "xpath").isElementPresent());
		this.page.element(Locators.EVENT_IN_EVENT_BANNER_PART1 + eventName + Locators.CLOSING_BRACKET, "xpath").getOne().click();
		waitForElement.waitForElements(Locators.EVENT_STATUS_PAGE, "xpath");
		try{
			if(this.page.element(Locators.EVENT_STATUS_PAGE, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE)==false) {
				this.page.element(Locators.EVENT_IN_EVENT_BANNER_PART1 + eventName + Locators.CLOSING_BRACKET, "xpath").getOne().sendKeys(Keys.ENTER);
				waitForElement.waitForElements(Locators.EVENT_STATUS_PAGE, "xpath");
			}
			if(this.page.element(Locators.EVENT_STATUS_PAGE, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE)==false) {
				this.page.element(Locators.EVENT_IN_EVENT_BANNER_PART1 + eventName + Locators.CLOSING_BRACKET, "xpath").clickUsingJSE();
				waitForElement.waitForElements(Locators.EVENT_STATUS_PAGE, "xpath");
			}
		} catch(Exception e) {

		}
		return this;
	}

	public EventManagement enablePrivateOption() throws Exception {
		waitForElement.waitForElements(Locators.PRIVATE, "name");
		assertTrue(this.page.element(Locators.PRIVATE, "name").isElementPresent());
		this.page.element(Locators.PRIVATE, "name").getOne().sendKeys(Keys.SPACE);
		try{
			if(this.page.element(Locators.PRIVATE, "name").getOne().isSelected()==false) {
				this.page.element(Locators.PRIVATE, "name").getOne().click();
			}
			if(this.page.element(Locators.PRIVATE, "name").getOne().isSelected()==false) {
				this.page.element(Locators.PRIVATE, "name").getOne().sendKeys(Keys.ENTER);
			}
		} catch(Exception e) {

		}
		assertTrue(this.page.element(Locators.PRIVATE, "name").getOne().isSelected(), "Private check box is not enabled.");
		return this;
	}

	public EventManagement createPrivateEvent(String eventTemplate, String eventName,
			String eventDescription, String resourceName) throws Exception {
		this.navigateToCreateNewEventScreen();
		this.selectEventTemplate(eventTemplate);
		this.enterEventName(eventName);
		this.enterEventDescription(eventDescription);
		this.enablePrivateOption();
		this.selectResource(resourceName);
		this.clickOnSave();
		this.verifyEventNameIsDisplayed(eventName);
		return this;
	}

	public EventManagement selectFutureDateAndTimeToStartEvent(String eventStartMonth,String eventStartDay, String eventStartYear,String eventStartHour,String eventStartMinute)throws Exception {
		this.selectEventStartMonth(eventStartMonth);
		this.selectEventStartDay(eventStartDay);
		this.selectEventStartYear(eventStartYear);
		this.selectEventStartHour(eventStartHour);
		this.selectEventStartMinute(eventStartMinute);
		return this;
	}

	public EventManagement selectEventStartOption() throws Exception {
		waitForElement.waitForElements(Locators.EVENTSTART_DATE, "xpath");
		assertTrue(this.page.element(Locators.EVENTSTART_DATE, "xpath").isElementPresent());
		if(this.page.element(Locators.EVENTSTART_DATE, "xpath").getOne().isSelected() == false){
			this.page.element(Locators.EVENTSTART_DATE, "xpath").getOne().sendKeys(Keys.SPACE);
		}
		if(this.page.element(Locators.EVENTSTART_DATE, "xpath").getOne().isSelected() == false){
			this.page.element(Locators.EVENTSTART_DATE, "xpath").getOne().click();
		}
		assertTrue(this.page.element(Locators.EVENTSTART_DATE, "xpath").getOne().isSelected());
		return this;
	}

	public EventManagement selectAndRetriveFutureStartEventDateAndTime(int startDate,int startHours) throws Exception {
		this.selectEventStartOption();
		String [] dateFormat = this.addDaysAndTimeForFutureEvent(startDate, startHours);
		String [] timeFormat = dateFormat[3].split(":");
		this.selectFutureDateAndTimeToStartEvent(dateFormat[1], dateFormat[0], dateFormat[2], timeFormat[0], timeFormat[1]);
		return this;
	}

	public EventManagement selectEventEndMonth(String eventEndMonth) throws Exception {
		waitForElement.waitForElements(Locators.EVENT_END_MONTH, "name");
		this.page.element(Locators.EVENT_END_MONTH, "name").webElementToSelect().selectByVisibleText(eventEndMonth);
		assertTrue(this.page.element(Locators.EVENT_END_MONTH, "name").webElementToSelect().getFirstSelectedOption().getText().equals(eventEndMonth), eventEndMonth + "is not selected");
		return this;
	}

	public EventManagement selectEventEndDay(String eventEndDay) throws Exception {
		waitForElement.waitForElements(Locators.EVENT_END_DAY, "name");
		if(eventEndDay.startsWith("0")){
			eventEndDay=eventEndDay.replace("0","");
		}
		this.page.element(Locators.EVENT_END_DAY, "name").webElementToSelect().selectByVisibleText(eventEndDay);
		assertTrue(this.page.element(Locators.EVENT_END_DAY, "name").webElementToSelect().getFirstSelectedOption().getText().equals(eventEndDay), eventEndDay + "is not selected");
		return this;
	}

	public EventManagement selectEventEndYear(String eventEndYear) throws Exception {
		waitForElement.waitForElements(Locators.EVENT_END_YEAR, "name");
		this.page.element(Locators.EVENT_END_YEAR, "name").webElementToSelect().selectByVisibleText(eventEndYear);
		assertTrue(this.page.element(Locators.EVENT_END_YEAR, "name").webElementToSelect().getFirstSelectedOption().getText().equals(eventEndYear), eventEndYear+"is not selected.");
		return this;
	}

	public EventManagement selectEventEndHour(String eventEndHour) throws Exception {
		waitForElement.waitForElements(Locators.EVENT_END_HOUR, "name");
		this.page.element(Locators.EVENT_END_HOUR, "name").webElementToSelect().selectByVisibleText(eventEndHour);
		assertTrue(this.page.element(Locators.EVENT_END_HOUR, "name").webElementToSelect().getFirstSelectedOption().getText().equals(eventEndHour), eventEndHour+" is not selected.");
		return this;
	}

	public EventManagement selectEventEndMinute(String eventEndMinute) throws Exception {
		waitForElement.waitForElements(Locators.EVENT_END_MINUTE, "name");
		this.page.element(Locators.EVENT_END_MINUTE, "name").webElementToSelect().selectByVisibleText(eventEndMinute);
		assertTrue(this.page.element(Locators.EVENT_END_MINUTE, "name").webElementToSelect().getFirstSelectedOption().getText().equals(eventEndMinute), eventEndMinute+ " is not selected.");
		return this;
	}

	public EventManagement selectFutureDateAndTimeToEndEvent(String eventEndMonth,String eventEndDay, String eventEndYear,String eventEndHour,String eventEndMinute) throws Exception {
		this.selectEventEndMonth(eventEndMonth);
		this.selectEventEndDay(eventEndDay);
		this.selectEventEndYear(eventEndYear);
		this.selectEventEndHour(eventEndHour);
		this.selectEventEndMinute(eventEndMinute);
		return this;
	}

	public EventManagement selectEventEndOption() throws Exception {
		waitForElement.waitForElements(Locators.EVENTEND_DATE, "css");
		assertTrue(this.page.element(Locators.EVENTEND_DATE, "css").isElementPresent());
		if(this.page.element(Locators.EVENTEND_DATE, "css").getOne().isSelected() == false){
			this.page.element(Locators.EVENTEND_DATE, "css").getOne().sendKeys(Keys.SPACE);
		}
		if(this.page.element(Locators.EVENTEND_DATE, "css").getOne().isSelected() == false){
			this.page.element(Locators.EVENTEND_DATE, "css").getOne().click();
		}
		assertTrue(this.page.element(Locators.EVENTEND_DATE, "css").getOne().isSelected());
		return this;
	}

	public EventManagement selectAndRetriveFutureEndEventDateAndTime(int endDate,int endHours) throws Exception {
		this.selectEventEndOption();
		String [] dateFormat = this.addDaysAndTimeForFutureEvent(endDate, endHours);
		String [] timeFormat = dateFormat[3].split(":");
		this.selectFutureDateAndTimeToEndEvent(dateFormat[1], dateFormat[0], dateFormat[2], timeFormat[0], timeFormat[1]);
		return this;
	}

	public EventManagement verifyEventInformation(String eventName, String eventInformation) throws Exception {
		waitForElement.waitForElements(Locators.PARTICIPATINGRESOURCEINPUTPART1 + eventName + Locators.CLOSING_BRACKET + Locators.FOLLOWING_COLOUMN_OF_TITLE + eventInformation + Locators.CLOSING_BRACKET, "xpath");
		assertTrue(this.page.element(Locators.PARTICIPATINGRESOURCEINPUTPART1 + eventName + Locators.CLOSING_BRACKET + Locators.FOLLOWING_COLOUMN_OF_TITLE + eventInformation + Locators.CLOSING_BRACKET, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.PARTICIPATINGRESOURCEINPUTPART1 + eventName + Locators.CLOSING_BRACKET + Locators.FOLLOWING_COLOUMN_OF_TITLE + eventInformation + Locators.CLOSING_BRACKET, "xpath").getOne().isDisplayed());
		return this;
	}

	public EventManagement verifyEventStartDate(String eventName, String startTime) throws Exception {
		String StartTimePlus1Min = dts.addTimetoExisting(startTime, 1, "yyyy-MM-dd HH:mm");
		String element = Locators.PARTICIPATINGRESOURCEINPUTPART1 + eventName + Locators.CLOSING_BRACKET + Locators.PARENT_COLUMN_OF_TITLE + startTime + Locators.CLOSING_BRACKET;
		String elementWithOneMinAdded = Locators.PARTICIPATINGRESOURCEINPUTPART1 + eventName + Locators.CLOSING_BRACKET + Locators.PARENT_COLUMN_OF_TITLE + StartTimePlus1Min + Locators.CLOSING_BRACKET;
		waitForElement.waitForElements(Locators.PARTICIPATINGRESOURCEINPUTPART1 + eventName + Locators.CLOSING_BRACKET, "xpath");
		assertTrue(this.page.element(element, "xpath").isElementPresent()||this.page.element(elementWithOneMinAdded, "xpath").isElementPresent(), "StartTimePlus1Min" + StartTimePlus1Min);
		return this;
	}

	public EventManagement verifyEventEndDate(String eventName, String endTime) throws Exception {
		String endTimePlus1Min = dts.addTimetoExisting(endTime, 1, "yyyy-MM-dd HH:mm");
		String element = Locators.PARTICIPATINGRESOURCEINPUTPART1 + eventName + Locators.CLOSING_BRACKET + Locators.PARENT_COLUMN_OF_TITLE + endTime + Locators.CLOSING_BRACKET;
		String elementWithOneMinAdded = Locators.PARTICIPATINGRESOURCEINPUTPART1 + eventName + Locators.CLOSING_BRACKET + Locators.PARENT_COLUMN_OF_TITLE + endTimePlus1Min + Locators.CLOSING_BRACKET;
		waitForElement.waitForElements(Locators.PARTICIPATINGRESOURCEINPUTPART1 + eventName + Locators.CLOSING_BRACKET, "xpath");
		assertTrue(this.page.element(element, "xpath").isElementPresent()||this.page.element(elementWithOneMinAdded, "xpath").isElementPresent(), "endTimePlus1Min" + endTimePlus1Min);
		return this;
	}

	public EventManagement selectEventEndNeverOption() throws Exception {
		waitForElement.waitForElements(Locators.EVENTEND_NEVER, "css");
		if(this.page.element(Locators.EVENTEND_NEVER, "css").getOne().isSelected() == false){
			this.page.element(Locators.EVENTEND_NEVER, "css").getOne().click();
		}
		if(this.page.element(Locators.EVENTEND_NEVER, "css").getOne().isSelected() == false){
			this.page.element(Locators.EVENTEND_NEVER, "css").clickUsingJSE();
		}
		assertTrue(this.page.element(Locators.EVENTEND_NEVER, "css").getOne().isSelected());
		return this;
	}

	public EventManagement verifyConfirmationForEventEndedMoreThanThirtyDay() throws Exception {
		String actualMsg=this.page.element(Locators.MULTI_REGION_EVENT_CONFIRMATION_MESSAGE, "xpath").getOne().getText();
		String ConfirmationMsg = "The event's end date is more than 30 days after the start date.\n\nWould you like to keep this date as is or modify it?";
		assertTrue(actualMsg.equals(ConfirmationMsg));
		return this;
	}

	public EventManagement verifyEventIconAndColour(String colour, String icon, String eventName) throws Exception {
		waitForElement.waitForElements(Locators.EVENT_IN_EVENT_BANNER_PART2 + colour + Locators.CLOSING_BRACKET_WITH_QUOTE + Locators.TABLE_CELL_CONTAINS_TEXT + icon + Locators.CLOSING_BRACKET_WITH_QUOTE + Locators.TEXT_FUNCTION + eventName +Locators.CLOSING_BRACKET, "xpath");
		assertTrue(this.page.element(Locators.EVENT_IN_EVENT_BANNER_PART2 + colour + Locators.CLOSING_BRACKET_WITH_QUOTE + Locators.TABLE_CELL_CONTAINS_TEXT + icon + Locators.CLOSING_BRACKET_WITH_QUOTE + Locators.TEXT_FUNCTION + eventName +Locators.CLOSING_BRACKET, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.EVENT_IN_EVENT_BANNER_PART2 + colour + Locators.CLOSING_BRACKET_WITH_QUOTE + Locators.TABLE_CELL_CONTAINS_TEXT + icon + Locators.CLOSING_BRACKET_WITH_QUOTE + Locators.TEXT_FUNCTION + eventName +Locators.CLOSING_BRACKET, "xpath").getOne().isDisplayed());
		return this;
	}

	public String updateFutureStartDateAndTimeForEvent(int startDate,int startHours) throws Exception {
		this.selectEventStartOption();
		String [] dateFormat = this.addDaysAndTimeForFutureEvent(startDate, startHours);
		String [] timeFormat = dateFormat[3].split(":");
		this.selectFutureDateAndTimeToStartEvent(dateFormat[1], dateFormat[0], dateFormat[2], timeFormat[0], timeFormat[1]);
		String dateInEventManagement = dateFormat[2] + "-" + dateFormat[1] + "-" +dateFormat[0] + " " +dateFormat[3];
		dateInEventManagement = dts.converDateFormat(dateInEventManagement, "yyyy-MMM-d HH:mm", "yyyy-MM-dd HH:mm");
		return dateInEventManagement;
	}

	public String updateFutureEndDateAndTimeForEvent(int endDate, int endHours) throws Exception {
		this.selectEventEndOption();
		String [] dateFormat = this.addDaysAndTimeForFutureEvent(endDate, endHours);
		String [] timeFormat = dateFormat[3].split(":");
		this.selectFutureDateAndTimeToEndEvent(dateFormat[1], dateFormat[0], dateFormat[2], timeFormat[0], timeFormat[1]);
		String dateInEventmanagement = dateFormat[2] + "-" + dateFormat[1] + "-" + dateFormat[0] + " " + dateFormat[3];
		dateInEventmanagement = dts.converDateFormat(dateInEventmanagement, "yyyy-MMM-d HH:mm", "yyyy-MM-dd HH:mm");
		return dateInEventmanagement;
	}

	public ArrayList<String> createAndModifyMultiregionEventWithFutureStartAndEndDate(String eventName, String eventDescription,int startDate,int startHours,int endDate,int endHours, String[] regionNames, String[] eventTemplateNames,int editEnddDate, int editEndHours) throws Exception {
		ArrayList<String> dates = new ArrayList<String>();
		this.enterEventName(eventName);
		this.enterEventDescription(eventDescription);
		dates.add(this.updateFutureStartDateAndTimeForEvent(startDate, startHours));
		dates.add(this.updateFutureEndDateAndTimeForEvent(endDate, endHours));
		this.selectParticipatingRegion(regionNames, eventTemplateNames);
		this.clickNext();
		this.verifyMultiregionEventConfirmationPage();
		this.clickModify();
		this.verifyCreateMultiregionEventPage();
		dates.add(this.updateFutureEndDateAndTimeForEvent(editEnddDate, editEndHours));
		this.clickNext();
		this.verifyMultiregionEventConfirmationPage();
		this.clickYes();
		return dates;
	}

	public EventManagement clickModify() throws Exception {
		waitForElement.waitForElements(Locators.MODIFY_BUTTON, "css");
		this.page.element(Locators.MODIFY_BUTTON, "css").clickUsingJSE();
		return this;
	}
	public String createNeverEndMultiRegionEvent(String eventName, String eventDescription, String[] regionName, String[] eventTemplateName) throws Exception {
		this.enterEventName(eventName);
		this.enterEventDescription(eventDescription);
		this.selectEventEndNeverOption();
		this.selectParticipatingRegion(regionName, eventTemplateName);
		this.clickNext();
		this.verifyConfirmationForEventEndedMoreThanThirtyDay();
		this.clickKeep();
		String applicationTime = shared.getApplicationTime();
		String currentYear = dts.getCurrentDate("yyyy");
		applicationTime = applicationTime + " " + currentYear;
		applicationTime = dts.converDateFormat(applicationTime,
				"dd MMM HH:mm yyyy", "yyyy-MM-dd HH:mm");
		System.out.println("converted time"+ applicationTime);
		this.clickYes();
		return applicationTime;
	}

	public EventManagement verifyEventEndAsNever(String eventName, String eventEndAsNever) throws Exception {
		waitForElement.waitForElements(Locators.PARTICIPATINGRESOURCEINPUTPART1 + eventName + Locators.CLOSING_BRACKET + Locators.PRECEDING_COLOUMN_OF_TITLE + eventEndAsNever + Locators.CLOSING_BRACKET, "xpath");
		assertTrue(this.page.element(Locators.PARTICIPATINGRESOURCEINPUTPART1 + eventName + Locators.CLOSING_BRACKET + Locators.PRECEDING_COLOUMN_OF_TITLE + eventEndAsNever + Locators.CLOSING_BRACKET, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.PARTICIPATINGRESOURCEINPUTPART1 + eventName + Locators.CLOSING_BRACKET + Locators.PRECEDING_COLOUMN_OF_TITLE + eventEndAsNever + Locators.CLOSING_BRACKET, "xpath").getOne().isDisplayed());
		return this;
	}

	public EventManagement verifyEventDetailsWithNeverEnd(String eventName, String status, String template, String eventInformation, String startTime, String eventEndAsNever) throws Exception {
		this.verifyEventStatus(eventName, status);
		this.verifyEventTemplate(eventName, template);
		this.verifyEventInformation(eventName, eventInformation);
		this.verifyEventStartDate(eventName, startTime);
		this.verifyEventEndAsNever(eventName, eventEndAsNever);
		this.verifyEventManagementPage();
		return this;
	}

	public  ArrayList<String> createMultiRegionEventWithStartAtSpecificDateAndNeverEnds(String eventName, String eventDescription,int startDate,int startHours,String[] regionName,String[] eventTemplateName) throws Exception {
		ArrayList<String> dates = new ArrayList<String>();
		this.enterEventName(eventName);
		this.enterEventDescription(eventDescription);
		dates.add(this.updateFutureStartDateAndTimeForEvent(startDate, startHours));
		this.selectEventEndNeverOption();
		this.selectParticipatingRegion(regionName, eventTemplateName);
		this.clickNext();
		this.verifyConfirmationForEventEndedMoreThanThirtyDay();
		this.clickKeep();
		this.verifyMultiregionEventConfirmationPage();
		this.clickYes();
		return dates;
	}

	public EventManagement deselectDisplayEventBanner() throws Exception {
		waitForElement.waitForElements(Locators.DISPLAY_IN_EVENT_BANNER, "name");
		assertTrue(this.page.element(Locators.DISPLAY_IN_EVENT_BANNER, "name").isElementPresent());
		if(this.page.element(Locators.DISPLAY_IN_EVENT_BANNER, "name").getOne().isSelected()){
			this.page.element(Locators.DISPLAY_IN_EVENT_BANNER, "name").getOne().sendKeys(Keys.SPACE);
		}
		if (this.page.element(Locators.DISPLAY_IN_EVENT_BANNER, "name").getOne().isSelected()) {
			this.page.element(Locators.DISPLAY_IN_EVENT_BANNER, "name").getOne().click();
		}
		assertFalse(this.page.element(Locators.DISPLAY_IN_EVENT_BANNER, "name").getOne().isSelected(), "Display Event Banner check box is not deselected.");
		return this;
	}

	public String[] createMultiRegionEventWithEndAtSpecificDateAndDeselectDisplayEventBanner(String eventName, String eventDescription, String eventEndDate, String[] regionName, String[] eventTemplateName, int hour) throws Exception {
		this.enterEventName(eventName);
		this.enterEventDescription(eventDescription);
		this.enterEndAfterSpecificHoursOfAnEvent(eventEndDate);
		this.deselectDisplayEventBanner();
		this.selectParticipatingRegion(regionName, eventTemplateName);
		this.clickNext();
		String applicationTime = shared.getApplicationTime();
		String currentYear = dts.getCurrentDate("yyyy");
		applicationTime = applicationTime + " " + currentYear;
		applicationTime = dts.converDateFormat(applicationTime,
				"dd MMM HH:mm yyyy", "yyyy-MM-dd HH:mm");
		System.out.println("converted time"+ applicationTime);
		String applicationTimePlusHour = dts.addTimetoExistingHour(applicationTime, hour, "yyyy-MM-dd HH:mm");
		this.clickYes();
		String[] dates= {applicationTime, applicationTimePlusHour};
		return dates;
	}

	public EventManagement verifyDisplayInEventBannerNotPresent(String eventsName) throws Exception {
		waitForElement.waitForElements(Locators.DISPLAY_EVENT_BANNER_PART1 + eventsName + Locators.CLOSING_BRACKET, "xpath");
		assertFalse(this.page.element(Locators.DISPLAY_EVENT_BANNER_PART1 + eventsName + Locators.CLOSING_BRACKET, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE), eventsName + "event is displayed");
		return this;
	}

	public String createMultiregionEventWithSpecificStartAndEndDateTime(String eventName, String eventDescription,int startDate,int startHours,String eventEndDate, String[] regionNames, String[] eventTemplateNames) throws Exception {
		this.enterEventName(eventName);
		this.enterEventDescription(eventDescription);
		String dates = this.updateFutureStartDateAndTimeForEvent(startDate, startHours);
		this.enterEndAfterSpecificHoursOfAnEvent(eventEndDate);
		this.selectParticipatingRegion(regionNames, eventTemplateNames);
		this.clickNext();
		this.verifyMultiRegionEventConfirmationMessage();
		this.clickYes();
		return dates;
	}

	public String addTimeToExistingTime(String date, int hour) throws Exception {
		String addedTime = dts.addTimetoExistingHour(date, hour, "yyyy-MM-dd HH:mm");
		return addedTime;
	}

	public EventManagement verifyEventIcon(String eventName, String icon) throws Exception {
		waitForElement.waitForElements(Locators.TABLECELLWITHTEXT + eventName + Locators.CLOSING_BRACKET + Locators.EVENT_ICON + icon + Locators.CLOSING_BRACKET_WITH_QUOTE, "xpath");
		assertTrue(this.page.element(Locators.TABLECELLWITHTEXT + eventName + Locators.CLOSING_BRACKET + Locators.EVENT_ICON + icon + Locators.CLOSING_BRACKET_WITH_QUOTE, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.TABLECELLWITHTEXT + eventName + Locators.CLOSING_BRACKET + Locators.EVENT_ICON + icon + Locators.CLOSING_BRACKET_WITH_QUOTE, "xpath").getOne().isDisplayed());
		return this;
	}

	public String[] addDaysAndTimeForFutureEvent(int days, int hours, int minutes) throws Exception {
		String eventStartTime = shared.getApplicationTimeWithTimeZone();
		String[] applicationDateAndTime = eventStartTime.split(" ");
		String applicationDate = applicationDateAndTime[0]+" "+applicationDateAndTime[1]+ " "+ dts.getCurrentDate("yyyy");
		String applicationTime = applicationDateAndTime[2];
		String addedDate = dts.AddDaytoExistingDate(applicationDate, days, "d MMM yyyy");
		String addedTime = dts.AddTimeToExistingTimeHourAndMin(applicationTime, hours, minutes, "HH:mm");
		String addedDateAndTime = addedDate + " " + addedTime;
		String[] FutureDateAndTime = addedDateAndTime.split(" ");
		return FutureDateAndTime;
	}

	public String updateFutureStartDateAndTimeForEvent(int startDate,int startHours, int minutes) throws Exception {
		this.selectEventStartOption();
		String [] dateFormat = this.addDaysAndTimeForFutureEvent(startDate, startHours, minutes);
		String [] timeFormat = dateFormat[3].split(":");
		this.selectFutureDateAndTimeToStartEvent(dateFormat[1], dateFormat[0], dateFormat[2], timeFormat[0], timeFormat[1]);
		String dateInEventManagement = dateFormat[2] + "-" + dateFormat[1] + "-" +dateFormat[0] + " " +dateFormat[3];
		dateInEventManagement = dts.converDateFormat(dateInEventManagement, "yyyy-MMM-d HH:mm", "yyyy-MM-dd HH:mm");
		return dateInEventManagement;
	}

	public String createEventWithFutureStartDate(String eventTemplate, String eventName, String eventDescription,int startDate,int startHours,int startMinutes, String resourceName) throws Exception {
		String dates = "";
		this.navigateToCreateNewEventScreen();
		this.selectEventTemplate(eventTemplate);
		this.enterEventName(eventName);
		this.enterEventDescription(eventDescription);
		dates = this.updateFutureStartDateAndTimeForEvent(startDate, startHours, startMinutes);
		this.selectResource(resourceName);
		this.clickOnSave();
		return dates;
	}

	public EventManagement lookUpAddress() throws Exception {
		waitForElement.waitForElements(Locators.LOOKUP_ADDRESS, "css");
		this.page.element(Locators.LOOKUP_ADDRESS, "css").clickUsingJSE();
		return this;
	}

	public String[] createMultiregionEventWithMandatoryAddress(String eventName,String eventDescription,String city,String state,String zipCode,String county,String[] regionName,String[] eventTemplateName,int hour) throws Exception {
		this.enterEventName(eventName);
		this.enterEventDescription(eventDescription);
		this.enterAddress(city, state, zipCode, county);
		this.verifyParticipatingRegion(regionName);
		this.selectParticipatingRegion(regionName, eventTemplateName);
		this.clickNext();
		String applicationTime = shared.getApplicationTime();
		String currentYear = dts.getCurrentDate("yyyy");
		applicationTime = applicationTime + " " + currentYear;
		applicationTime = dts.converDateFormat(applicationTime,
				"dd MMM HH:mm yyyy", "yyyy-MM-dd HH:mm");
		System.out.println("converted time"+ applicationTime);
		String applicationTimePlusHour = dts.addTimetoExistingHour(applicationTime, hour, "yyyy-MM-dd HH:mm");
		String[] dates= {applicationTime, applicationTimePlusHour};
		this.clickYes();
		return dates;
	}

	public String[] createMultiregionEvent(String eventName,String eventDescription,String[] regionName,String[] eventTemplateName,int hour) throws Exception {
		this.enterEventName(eventName);
		this.enterEventDescription(eventDescription);
		this.selectParticipatingRegion(regionName, eventTemplateName);
		this.clickNext();
		String applicationTime = shared.getApplicationTime();
		String currentYear = dts.getCurrentDate("yyyy");
		applicationTime = applicationTime + " " + currentYear;
		applicationTime = dts.converDateFormat(applicationTime,
				"dd MMM HH:mm yyyy", "yyyy-MM-dd HH:mm");
		System.out.println("converted time"+ applicationTime);
		String applicationTimePlusHour = dts.addTimetoExistingHour(applicationTime, hour, "yyyy-MM-dd HH:mm");
		this.verifyMultiregionEventConfirmationPage();
		this.clickYes();
		String[] dates= {applicationTime, applicationTimePlusHour};
		return dates;
	}

	public EventManagement selectEventBanner(String eventsName) throws Exception {
		waitForElement.waitForElements(Locators.DISPLAY_EVENT_BANNER_PART1 + eventsName + Locators.CLOSING_BRACKET, "xpath");
		this.page.element(Locators.DISPLAY_EVENT_BANNER_PART1 + eventsName + Locators.CLOSING_BRACKET, "xpath").clickUsingJSE();
		return this;
	}

	public String editEventAndDeselectTemplateWithApplicationTime(String eventName,String[] region, String[] eventTemplate,String updatedEventName, String eventDesc, int hour) throws Exception {
		this.verifyEventManagementPage();
		this.clickEditLink(eventName);
		this.verifyEditMultiregionEventPage();
		this.selectParticipatingRegion(region, eventTemplate);
		this.clickOnNext();
		this.clickOnNext();
		this.clickYes();
		this.verifyWebNotificationAndClickOnAcknowledge(updatedEventName, eventDesc);
		this.verifyEventManagementPage();
		String applicationTime = shared.getApplicationTime();
		String currentYear = dts.getCurrentDate("yyyy");
		applicationTime = applicationTime + " " + currentYear;
		applicationTime = dts.converDateFormat(applicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");
		System.out.println("converted time"+ applicationTime);
		return applicationTime;
	}

	public EventManagement editEventAndSelectTemplate(String eventName,String[] region, String[] eventTemplate,String eventDesc ) throws Exception {
		this.clickEditLink(eventName);
		this.selectParticipatingRegion(region, eventTemplate);
		this.clickOnNext();
		this.clickNext();
		this.clickYes();
		this.verifyWebNotificationAndClickOnAcknowledge(eventName, eventDesc);
		return this;
	}

	public EventManagement verifyRegionAndItsEventTemplate(String[] regionName, String[] eventTemplate) throws Exception {
		for(int intCount=0; intCount<regionName.length; intCount++)
		{
			waitForElement.waitForElements(Locators.TABLECELLWITHTEXT+ regionName[intCount] + Locators.CLOSING_BRACKET + Locators.FOLLOWING_COLOUMN_OF_TITLE + eventTemplate[intCount] + Locators.CLOSING_BRACKET, "xpath");
			assertTrue(this.page.element(Locators.TABLECELLWITHTEXT+ regionName[intCount] + Locators.CLOSING_BRACKET + Locators.FOLLOWING_COLOUMN_OF_TITLE + eventTemplate[intCount] + Locators.CLOSING_BRACKET, "xpath").isElementPresent());
			assertTrue(this.page.element(Locators.TABLECELLWITHTEXT+ regionName[intCount] + Locators.CLOSING_BRACKET + Locators.FOLLOWING_COLOUMN_OF_TITLE + eventTemplate[intCount] + Locators.CLOSING_BRACKET, "xpath").getOne().isDisplayed());
		}
		return this;
	}

	public EventManagement verifyMultiRegionEventConfirmationMessage() throws Exception {
		String actualMsg=this.page.element(Locators.MULTI_REGION_EVENT_CONFIRMATION_MESSAGE, "xpath").getOne().getText();
		String ConfirmationMsg = "Are you sure you want to create this multi-region event?";
		assertTrue(actualMsg.equals(ConfirmationMsg));
		return this;
	}

	public EventManagement deselectIncludeAllResources() throws Exception {
		waitForElement.waitForElements(Locators.INCLUDEALLRESOURCES , "css");
		this.page.element(Locators.INCLUDEALLRESOURCES , "css").getOne().sendKeys(Keys.SPACE);
		if(this.page.element(Locators.INCLUDEALLRESOURCES , "css").getOne().isSelected()) {
			this.page.element(Locators.INCLUDEALLRESOURCES , "css").getOne().click();
		}
		if(this.page.element(Locators.INCLUDEALLRESOURCES, "css").getOne().isSelected()) {
			this.page.element(Locators.INCLUDEALLRESOURCES , "css").Click();
		}
		assertFalse(this.page.element(Locators.INCLUDEALLRESOURCES, "css").getOne().isSelected());
		return this;
	}

	public EventManagement verifySelectResourcePageIsDisplayed(String regionName) throws Exception {
		waitForElement.waitForElements(Locators.SELECTRESOURCEPAGEPART1
				+ regionName + Locators.CLOSEBRACKETS, "xpath");
		assertTrue(this.page.element(Locators.SELECTRESOURCEPAGEPART1 + regionName + Locators.CLOSEBRACKETS, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.SELECTRESOURCEPAGEPART1 + regionName + Locators.CLOSEBRACKETS , "xpath").getOne()
				.isDisplayed());
		return this;
	}

	public EventManagement verifyResourceIsDisplayedForParticularResourceType(String resourceTypeName, String resourceName) throws Exception {

		waitForElement.waitForElements(Locators.RESOURCELISTPART1 + resourceTypeName + Locators.RESOURCELISTPART2 + resourceName + Locators.CLOSEBRACKETS, "xpath");
		assertTrue(this.page.element(Locators.RESOURCELISTPART1 + resourceTypeName + Locators.RESOURCELISTPART2 + resourceName + Locators.CLOSEBRACKETS, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.RESOURCELISTPART1 + resourceTypeName + Locators.RESOURCELISTPART2 + resourceName + Locators.CLOSEBRACKETS, "xpath").getOne()
				.isDisplayed());
		System.out.println(resourceName +" resource displayed");
		return this;
	}

	public EventManagement navigateToSelectResourcePage() throws Exception {
		waitForElement.waitForElements(Locators.NEXT, "css");
		this.page.element(Locators.NEXT, "css").clickUsingJSE();
		return this;
	}

	public EventManagement verifyStatusTypePageIsNotDisplayedForParticularRegion() throws Exception {
		waitForElement.waitForElements(Locators.STATUSTYPEPAGE, "xpath");
		assertFalse(this.page.element(Locators.STATUSTYPEPAGE, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE),"Status Type page is displayed");
		return this;
	}

	public EventManagement verifyStatusTypePageIsNotDisplayedForMultiRegionEvent(String[] regionName,String eventName) throws Exception {
		this.clickEditLink(eventName);
		this.navigateToSelectResourcePage();
		this.verifySelectResourcePageIsDisplayed(RegionData.REGION_NAME_2);
		this.navigateToSelectResourcePage();
		this.verifyStatusTypePageIsNotDisplayedForParticularRegion();
		this.verifySelectResourcePageIsDisplayed(RegionData.REGIONNAME);
		this.navigateToSelectResourcePage();
		this.verifyStatusTypePageIsNotDisplayedForParticularRegion();
		this.clickYes();
		return this;
	}

	public EventManagement verifyEditMultiregionEventPage() throws Exception {
		waitForElement.waitForElements(Locators.EDIT_MULTI_REGION_EVENT_PAGE, "xpath");
		assertTrue(this.page.element(Locators.EDIT_MULTI_REGION_EVENT_PAGE, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.EDIT_MULTI_REGION_EVENT_PAGE, "xpath").getOne().isDisplayed());
		return this;
	}

	public ArrayList<String> createMultiregionEventWithFutureStartAndEndDate(String eventName, String eventDescription,int startDate,int startHours,int endDate,int endHours, String[] regionNames, String[] eventTemplateNames) throws Exception {
		ArrayList<String> dates = new ArrayList<String>();
		this.clickOnCreateNewMultiRegionEvent();
		this.enterEventName(eventName);
		this.enterEventDescription(eventDescription);
		dates.add(this.updateFutureStartDateAndTimeForEvent(startDate, startHours));
		dates.add(this.updateFutureEndDateAndTimeForEvent(endDate, endHours));
		this.selectParticipatingRegion(regionNames, eventTemplateNames);
		this.clickNext();
		this.verifyMultiregionEventConfirmationPage();
		this.verifyRegionAndItsEventTemplate(regionNames, eventTemplateNames);
		this.verifyMultiRegionEventConfirmationMessage();
		this.clickYes();
		return dates;
	}

	public EventManagement verifyCreateMultiregionEventOption() throws Exception {
		waitForElement.waitForElements(Locators.CREATE_MULTIREGION_EVENT_OPTION, "css");
		assertTrue(this.page.element(Locators.CREATE_MULTIREGION_EVENT_OPTION, "css").isElementPresent());
		assertTrue(this.page.element(Locators.CREATE_MULTIREGION_EVENT_OPTION, "css").getOne().isDisplayed());
		return this;
	}

	public ArrayList<String> createMultiregionEventWithFutureStartAndEndDate(String eventName, String eventDescription,int startDate,int startHours,int endDate,int endHours, String[] regionNames, String[] eventTemplateNames,int editEnddDate, int editEndHours) throws Exception {
		ArrayList<String> dates = new ArrayList<String>();
		this.enterEventName(eventName);
		this.enterEventDescription(eventDescription);
		dates.add(this.updateFutureStartDateAndTimeForEvent(startDate, startHours));
		dates.add(this.updateFutureEndDateAndTimeForEvent(endDate, endHours));
		this.selectParticipatingRegion(regionNames, eventTemplateNames);
		this.clickNext();
		this.verifyMultiregionEventConfirmationPage();
		this.clickModify();
		this.verifyCreateMultiregionEventPage();
		dates.add(this.updateFutureEndDateAndTimeForEvent(editEnddDate, editEndHours));
		this.clickNext();
		this.verifyMultiregionEventConfirmationPage();
		this.clickYes();
		return dates;
	}

	public EventManagement editEventAndUpdateTemplate(String eventName,String[] region, String[] eventTemplate,String updatedEventName, String eventDesc) throws Exception {
		this.verifyEventManagementPage();
		this.clickEditLink(eventName);
		this.verifyEditMultiregionEventPage();
		this.selectParticipatingRegion(region, eventTemplate);
		this.clickNext();
		this.clickYes();
		this.verifyWebNotificationAndClickOnAcknowledge(updatedEventName, eventDesc);
		this.verifyEventManagementPage();
		return this;
	}

	public EventManagement clickOnNext() throws Exception {
		waitForElement.waitForElements(Locators.NEXT, "css");
		this.page.element(Locators.NEXT, "css").getDisplayedOne().click();
		return this;
	}

	public String editEventSelectSpecificEndDateTime(String eventName,String editEventName,int endDateTime, int endHours) throws Exception {
		this.verifyEventManagementPage();
		this.clickEditLink(eventName);
		this.verifyEditMultiregionEventPage();
		this.enterEventName(editEventName);
		String endDate = this.updateFutureEndDateAndTimeForEvent(endDateTime, endHours);
		this.clickOnNext();
		this.clickNext();
		this.clickYes();
		return endDate;
	}

	public EventManagement editEventAndUpdateTemplateSecondTime(String eventName,String[] region, String[] eventTemplate,String updatedEventName, String eventDesc ) throws Exception {
		this.verifyEventManagementPage();
		this.clickEditLink(eventName);
		this.verifyEditMultiregionEventPage();
		this.selectParticipatingRegion(region, eventTemplate);
		this.selectAllResource();
		this.clickOnNext();
		this.clickNext();
		this.clickYes();
		this.verifyWebNotificationAndClickOnAcknowledge(updatedEventName, eventDesc);
		return this;
	}

	public ArrayList<String> editEventWithMandatoryData(String eventName,String editedEventName,String editedEventDescription,int startDate,int startHours,int endDate,int endHours ) throws Exception {
		ArrayList<String> dates = new ArrayList<String>();
		this.verifyEventManagementPage();
		this.clickEditLink(eventName);
		this.verifyEditMultiregionEventPage();
		this.enterEventName(editedEventName);
		this.enterEventDescription(editedEventDescription);
		dates.add(this.updateFutureStartDateAndTimeForEvent(startDate, startHours));
		dates.add(this.updateFutureEndDateAndTimeForEvent(endDate, endHours));
		this.clickOnNext();
		this.clickOnNext();
		this.clickNext();
		this.clickYes();
		return dates;
	}

	public EventManagement verifyEventIsNotPresentInEventBanner(String eventName) throws Exception {
		waitForElement.waitForElements(Locators.EVENT_IN_EVENT_BANNER_PART1 + eventName + Locators.CLOSING_BRACKET, "xpath");
		assertFalse(this.page.element(Locators.EVENT_IN_EVENT_BANNER_PART1 + eventName + Locators.CLOSING_BRACKET, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE), eventName + "event is displayed");
		return this;
	}

	public ArrayList<String> createMultiregionWithFutureDateAndTime(String eventName, String eventDescription,int startDate,int startHours,int endDate,int endHours, String[] regionNames, String[] eventTemplateNames) throws Exception {
		ArrayList<String> dates = new ArrayList<String>();
		this.enterEventName(eventName);
		this.enterEventDescription(eventDescription);
		dates.add(this.updateFutureStartDateAndTimeForEvent(startDate, startHours));
		dates.add(this.updateFutureEndDateAndTimeForEvent(endDate, endHours));
		this.selectParticipatingRegion(regionNames, eventTemplateNames);
		this.clickNext();
		this.clickYes();
		return dates;
	}

	public EventManagement navigateToCreateAdHocEventScreen() throws Exception {
		waitForElement.waitForElements(Locators.CREATE_ADHOC_EVENT, "css");
		this.page.element(Locators.CREATE_ADHOC_EVENT, "css").clickUsingJSE();
		return this;
	}

	public String[] createAdHocEventStartImmediatelyAndEndAtSpecificHour(String adHocEventName, String adHocEventDescription, String adHocEventEndDate,String resourceName,String statusTypeName) throws Exception {

		this.enterEventName(adHocEventName);
		this.enterEventDescription(adHocEventDescription);
		this.enterEndAfterSpecificHoursOfAnEvent(adHocEventEndDate);
		this.clickOnNext();
		this.verifySelectResourcesPageIsDisplayed();
		this.selectResource(resourceName);
		this.clickOnNext();
		this.verifySelectStatusTypesPageIsDisplayed();
		this.selectStatusType(statusTypeName);
		this.clickOnNext();
		this.verifyAdHocEventConfirmationPageIsDisplayed();
		this.clickYes();
		String applicationTime = shared.getApplicationTime();
		String currentYear = dts.getCurrentDate("yyyy");
		applicationTime = applicationTime + " " + currentYear;
		applicationTime = dts.converDateFormat(applicationTime,
				"dd MMM HH:mm yyyy", "yyyy-MM-dd HH:mm");
		System.out.println("converted time"+ applicationTime);
		int  hour= Integer.parseInt(adHocEventEndDate);
		String applicationTimePlusHour = dts.addTimetoExistingHour(applicationTime, hour, "yyyy-MM-dd HH:mm");
		String[] dates= {applicationTime, applicationTimePlusHour};
		return dates;
	}

	public EventManagement verifySelectStatusTypesPageIsDisplayed() throws Exception {
		waitForElement.waitForElements(Locators.STATUSTYPEPAGE, "xpath");
		assertTrue(this.page.element(Locators.STATUSTYPEPAGE, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE),"Status Type page is not displayed");
		return this;
	}

	public EventManagement verifySelectResourcesPageIsDisplayed() throws Exception {
		waitForElement.waitForElements(Locators.RESOURCEPAGE, "xpath");
		assertTrue(this.page.element(Locators.RESOURCEPAGE, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE),"Resource page is not displayed");
		return this;
	}

	public EventManagement selectStatusType(String statusTypeName) throws Exception {
		waitForElement.waitForElements(
				Locators.PARTICIPATING_STATUSTYPE_INPUT_PART1 + statusTypeName 
				+ Locators.PARTICIPATING_STATUSTYPE_INPUT_PART2, "xpath");
		this.page
		.element(
				Locators.PARTICIPATING_STATUSTYPE_INPUT_PART1 + statusTypeName

				+ Locators.PARTICIPATING_STATUSTYPE_INPUT_PART2,
				"xpath").getOne().click();
		return this;
	}

	public EventManagement verifyAdHocEventConfirmationPageIsDisplayed() throws Exception {
		waitForElement.waitForElements(Locators.AD_HOC_EVENT_CONFIRMATION_PAGE, "xpath");
		assertTrue(this.page.element(Locators.AD_HOC_EVENT_CONFIRMATION_PAGE, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE),"Ad Hoc Event Confirmation page is not displayed");
		return this;
	}

	public EventManagement enableEventEndAfterSpecificHours() throws Exception {
		waitForElement.waitForElements(Locators.END_EVENT_HOUR, "css");
		assertTrue(this.page.element(Locators.END_EVENT_HOUR, "css").isElementPresent());
		this.page.element(Locators.END_EVENT_HOUR, "css").getOne().sendKeys(Keys.SPACE);
		try{
			if(this.page.element(Locators.END_EVENT_HOUR, "css").getOne().isSelected()==false) {
				this.page.element(Locators.END_EVENT_HOUR, "css").getOne().click();
			}
			if(this.page.element(Locators.END_EVENT_HOUR, "css").getOne().isSelected()==false) {
				this.page.element(Locators.END_EVENT_HOUR, "css").getOne().sendKeys(Keys.ENTER);
			}
		} catch(Exception e) {

		}
		assertTrue(this.page.element(Locators.END_EVENT_HOUR, "css").getOne().isSelected(), "EventEndAfterSpecificHours radio button is not enabled.");
		return this;
	}

	public String editEventSelectSpecificHoursOfAnEvent(String eventName,String editEventName,String endHour, String eventStartTime,int hour) throws Exception {
		this.verifyEventManagementPage();
		this.clickEditLink(eventName);
		this.verifyEditMultiregionEventPage();
		this.enterEventName(editEventName);
		this.enableEventEndAfterSpecificHours();
		this.enterEndAfterSpecificHoursOfAnEvent(endHour);
		this.clickOnNext();
		this.clickOnNext();
		this.clickNext();
		String applicationTimePlusHour = dts.addTimetoExistingHour(eventStartTime, hour, "yyyy-MM-dd HH:mm");
		this.clickYes();
		return applicationTimePlusHour;
	}

	public EventManagement createMultiregionPrivateEvent(String eventName,String eventDescription,String[] regionNames,String[] eventTemplateNames ) throws Exception {
		this.clickOnCreateNewMultiRegionEvent();
		this.enterEventName(eventName);
		this.enterEventDescription(eventDescription);
		this.enablePrivateOption();
		this.selectParticipatingRegion(regionNames, eventTemplateNames);
		this.clickNext();
		this.clickYes();
		return this;
	}

	public EventManagement verifyEventAction(String eventName) throws Exception {
		waitForElement.waitForElements(Locators.TABLECELLWITHTEXT + eventName + Locators.CLOSING_BRACKET + Locators.TABLE_CELL_WITH_PRECEDING_SIBLING , "xpath");
		assertTrue(this.page.element(Locators.TABLECELLWITHTEXT + eventName + Locators.CLOSING_BRACKET + Locators.TABLE_CELL_WITH_PRECEDING_SIBLING , "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.TABLECELLWITHTEXT + eventName + Locators.CLOSING_BRACKET + Locators.TABLE_CELL_WITH_PRECEDING_SIBLING , "xpath").getOne().isDisplayed());
		assertTrue(this.page.element(Locators.TABLECELLWITHTEXT + eventName + Locators.CLOSING_BRACKET + Locators.TABLE_CELL_WITH_PRECEDING_SIBLING , "xpath").getOne().getText().equals("View History"));
		return this;
	}

	public EventManagement createEventWithMultipleResources(String eventTemplate, String eventName,
			String eventDescription, List<String> allResources) throws Exception {
		this.navigateToCreateNewEventScreen();
		this.selectEventTemplate(eventTemplate);
		this.enterEventName(eventName);
		this.enterEventDescription(eventDescription);
		this.selectResource1(allResources);
		this.clickOnSave();
		this.verifyEventNameIsDisplayed(eventName);
		return this;
	}

	public EventManagement selectResource1(List<String> allResources) throws Exception {

		for(int i=0;i<allResources.size();i++)
		{	
			waitForElement.waitForElements(Locators.PARTICIPATINGRESOURCEINPUTPART1 + allResources.get(i) + "']"+ Locators.PARTICIPATINGRESOURCEINPUTPART2, "xpath");
			this.page.element(Locators.PARTICIPATINGRESOURCEINPUTPART1 + allResources.get(i)+ "']"+ Locators.PARTICIPATINGRESOURCEINPUTPART2,"xpath").getOne().click();
		}
		return this;
	}

	public EventManagement selectStatusTypesWhileEditingEvent(List<String> statusTypeValues) throws Exception {
		for(int i=0;i<statusTypeValues.size();i++)
		{		
			waitForElement.waitForElements(Locators.SELECT_STATUS_TYPES + statusTypeValues.get(i) + Locators.CLOSEBRACKETS, "css");
			this.page.element(Locators.SELECT_STATUS_TYPES + statusTypeValues.get(i) + Locators.CLOSEBRACKETS, "css").mouseOver();
			this.page.element(Locators.SELECT_STATUS_TYPES + statusTypeValues.get(i) + Locators.CLOSEBRACKETS, "css").Click();

			if(this.page.element(Locators.SELECT_STATUS_TYPES + statusTypeValues.get(i) + Locators.CLOSEBRACKETS, "css").getOne().isSelected()==false)
			{
				waitForElement.waitForElements(Locators.SELECT_STATUS_TYPES + statusTypeValues.get(i) + Locators.CLOSEBRACKETS, "css");
				this.page.element(Locators.SELECT_STATUS_TYPES + statusTypeValues.get(i) + Locators.CLOSEBRACKETS, "css").mouseOver();
				this.page.element(Locators.SELECT_STATUS_TYPES + statusTypeValues.get(i) + Locators.CLOSEBRACKETS, "css").getOne().sendKeys(Keys.SPACE);
			}

			if(this.page.element(Locators.SELECT_STATUS_TYPES + statusTypeValues.get(i) + Locators.CLOSEBRACKETS, "css").getOne().isSelected()==false)
			{
				waitForElement.waitForElements(Locators.SELECT_STATUS_TYPES + statusTypeValues.get(i) + Locators.CLOSEBRACKETS, "css");
				this.page.element(Locators.SELECT_STATUS_TYPES + statusTypeValues.get(i) + Locators.CLOSEBRACKETS, "css").mouseOver();
				this.page.element(Locators.SELECT_STATUS_TYPES + statusTypeValues.get(i) + Locators.CLOSEBRACKETS, "css").clickUsingJSE();
			}
			assertTrue(this.page.element(Locators.SELECT_STATUS_TYPES + statusTypeValues.get(i) + Locators.CLOSEBRACKETS, "css").getOne().isSelected());
		}
		return this;

	}


	public EventManagement addStatusTypesToExistingEvent(String eventName,List<String> statusTypesValues) throws Exception {
		this.clickEditLink(eventName);
		this.selectStatusTypesWhileEditingEvent(statusTypesValues);
		this.clickOnSave();
		return this;
	}

	public String[] createMultiregionEventBydeselectingResource(String eventName,String eventDescription,String[] regionName,String[] eventTemplateName,int hour) throws Exception {
		this.enterEventName(eventName);
		this.enterEventDescription(eventDescription);
		this.deselectIncludeAllResources();
		this.selectParticipatingRegion(regionName, eventTemplateName);
		this.clickOnNext();
		this.selectAllResource();
		this.clickOnNext();
		this.selectAllResource();
		String applicationTime = shared.getApplicationTime();
		String currentYear = dts.getCurrentDate("yyyy");
		applicationTime = applicationTime + " " + currentYear;
		applicationTime = dts.converDateFormat(applicationTime,
				"dd MMM HH:mm yyyy", "yyyy-MM-dd HH:mm");
		System.out.println("converted time"+ applicationTime);
		String applicationTimePlusHour = dts.addTimetoExistingHour(applicationTime, hour, "yyyy-MM-dd HH:mm");
		this.clickNext();
		this.clickYes();
		String[] dates= {applicationTime, applicationTimePlusHour};
		return dates;
	}

	public EventManagement selectAllResource() throws Exception{
		waitForElement.waitForElements(Locators.ALL_RESOURCE ,"css");
		assertTrue(this.page.element(Locators.ALL_RESOURCE , "css").isElementPresent());
		if(this.page.element(Locators.ALL_RESOURCE , "css").getOne().isSelected() == false){
			this.page.element(Locators.ALL_RESOURCE , "css").getOne().sendKeys(Keys.SPACE);
		}
		if(this.page.element(Locators.ALL_RESOURCE , "css").getOne().isSelected() == false){
			this.page.element(Locators.ALL_RESOURCE , "css").getOne().click();
		}
		assertTrue(this.page.element(Locators.ALL_RESOURCE , "css").getOne().isSelected());
		return this;
	}

	public EventManagement clickOnEventBanner(String eventName) throws Exception {
		waitForElement.waitForElements(Locators.EVENT_BANNER + eventName + Locators.CLOSEBRACKETS, "xpath");
		this.page.element(Locators.EVENT_BANNER + eventName + Locators.CLOSEBRACKETS, "xpath").getOne().click();
		if(this.page.element(Locators.EVENT_STATUS_PAGE, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE)==false)
		{
			this.page.element(Locators.EVENT_BANNER + eventName + Locators.CLOSEBRACKETS, "xpath").clickUsingJSE();
		}
		return this;
	}	

	public EventManagement editEventAndVerifyResourceNameIsUpdated(String eventName,String resourceTypeName,String resourceName) throws Exception {
		this.clickEditLink(eventName);
		this.verifyResourceIsDisplayedForParticularResourceType(resourceTypeName, resourceName);
		this.clickOnSave();
		return this;
	}
	public EventManagement verWebNotificationWithAddress(String EventName,
			String EventDesc, String City, String County,
			String ZipCode, String State) throws Exception {
		waitForElement.waitForElements(Locators.HEADEROFNOTIFICATION, "css");
		this.page.element(Locators.HEADEROFNOTIFICATION, "css").getOne().isDisplayed();
		this.page.element(Locators.DESCRIPTIONOFNOTIFICATION, "css").getOne().isDisplayed();
		assertEquals(EventName, this.page.element(Locators.HEADEROFNOTIFICATION, "css").getOne()
				.getText());
		assertEquals(EventDesc + "\nLocation: " + City + " "+State+" "
				+ ZipCode + " " + County + "",
				this.page.element(Locators.DESCRIPTIONOFNOTIFICATION, "css").getOne().getText());
		return this;
	}

	public EventManagement verifyWebNotificationWithAddressAndClickOnAcknowledge(
			String EventName, String EventDesc,String City,String County,String ZipCode,String State) throws Exception {
		verifyWebNotificationframe();
		verWebNotificationWithAddress(EventName,EventDesc,City,County,ZipCode,State);
		clickOnAcknowledgeAllNotifications();
		login.switchToDefaultWindow();
		login.selectFrame();
		return this;
	}

	public EventManagement verifySaveButton() throws Exception {
		waitForElement.waitForElements(Locators.SAVE, "css");
		assertTrue(this.page.element(Locators.SAVE, "css").isElementPresent());
		assertTrue(this.page.element(Locators.SAVE, "css").getOne().isDisplayed());
		return this;
	}

	public EventManagement verifyCancelButton() throws Exception {
		waitForElement.waitForElements(Locators.CANCEL, "css");
		assertTrue(this.page.element(Locators.CANCEL, "css").isElementPresent());
		assertTrue(this.page.element(Locators.CANCEL, "css").getOne().isDisplayed());
		return this;
	}

	public EventManagement editSingleEvent(String eventName,String editEventName,String eventDescription) throws Exception {
		this.verifyEventManagementPage();
		this.clickEditLink(eventName);
		this.verifyCancelAndSaveButtonAfterEdit();
		this.enterEventName(editEventName);
		this.enterEventDescription(eventDescription);
		this.clickOnSave();
		return this;
	}

	public EventManagement verifyEventIsPresentInEventBanner(String eventName) throws Exception {
		waitForElement.waitForElements(Locators.EVENT_IN_EVENT_BANNER_PART1 + eventName + Locators.CLOSING_BRACKET, "xpath");
		assertTrue(this.page.element(Locators.EVENT_IN_EVENT_BANNER_PART1 + eventName + Locators.CLOSING_BRACKET, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE), eventName + "event is not displayed");
		return this;
	}

	public EventManagement verifySaveAtTopOfThePage() throws Exception {
		waitForElement.waitForElements(Locators.SAVE_BUTTON_IN_TOP_OF_PAGE, "xpath");
		assertTrue(this.page.element(Locators.SAVE_BUTTON_IN_TOP_OF_PAGE, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.SAVE_BUTTON_IN_TOP_OF_PAGE, "xpath").getOne().isDisplayed());
		return this;
	}

	public EventManagement verifySaveAtBottomOfThePage() throws Exception {
		waitForElement.waitForElements(Locators.SAVE_BUTTON_IN_BOTTOM_OF_PAGE, "xpath");
		assertTrue(this.page.element(Locators.SAVE_BUTTON_IN_BOTTOM_OF_PAGE, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.SAVE_BUTTON_IN_BOTTOM_OF_PAGE, "xpath").getOne().isDisplayed());
		return this;
	}

	public EventManagement verifyCancelAtBottomOfThePage() throws Exception {
		waitForElement.waitForElements(Locators.CANCEL_BUTTON_IN_BOTTOM_OF_PAGE, "xpath");
		assertTrue(this.page.element(Locators.CANCEL_BUTTON_IN_BOTTOM_OF_PAGE, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.CANCEL_BUTTON_IN_BOTTOM_OF_PAGE, "xpath").getOne().isDisplayed());
		return this;
	}

	public EventManagement verifyCancelAtTopOfThePage() throws Exception {
		waitForElement.waitForElements(Locators.CANCEL_BUTTON_IN_TOP_OF_PAGE, "xpath");
		assertTrue(this.page.element(Locators.CANCEL_BUTTON_IN_TOP_OF_PAGE, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.CANCEL_BUTTON_IN_TOP_OF_PAGE, "xpath").getOne().isDisplayed());
		return this;
	}

	public EventManagement verifyCancelAndSaveButton() throws Exception {
		this.verifySaveAtTopOfThePage();
		this.verifyCancelAtTopOfThePage();
		this.verifyCancelAtBottomOfThePage();
		this.verifySaveAtBottomOfThePage();
		return this;
	}

	public EventManagement NavigateToCancelAtOfTopOfThePage() throws Exception {
		waitForElement.waitForElements(Locators.CANCEL_BUTTON_IN_TOP_OF_PAGE, "xpath");
		this.page.element(Locators.CANCEL_BUTTON_IN_TOP_OF_PAGE, "xpath").getDisplayedOne().click();
		return this;
	}

	public EventManagement verifyEventStatusPage() throws Exception {
		waitForElement.waitForElements(Locators.EVENT_STATUS_PAGE, "xpath");
		assertTrue(this.page.element(Locators.EVENT_STATUS_PAGE, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.EVENT_STATUS_PAGE, "xpath").getOne().isDisplayed());
		return this;
	}

	public ArrayList<String> createFutureAdhocEventWithSpecificStartAndEndDateTime(String eventName,String eventDescription,int startDate,int startHours,int endDate,int endHours,String resourceName,ArrayList<String> statusTypeNames ) throws Exception{
		ArrayList<String> dates = new ArrayList<String>();
		this.navigateToCreateAdHocEventScreen();
		this.enterEventName(eventName);
		this.enterEventDescription(eventDescription);
		dates.add(this.updateFutureStartDateAndTimeForEvent(startDate, startHours));
		dates.add(this.updateFutureEndDateAndTimeForEvent(endDate, endHours));
		this.clickOnNext();
		this.verifySelectResourcesPageIsDisplayed();
		this.selectResource(resourceName);
		this.clickOnNext();
		this.verifySelectStatusTypesPageIsDisplayed();
		this.selectStatusTypes(statusTypeNames);
		this.clickOnNext();
		this.verifyAdHocEventConfirmationPageIsDisplayed();
		this.clickYes();
		return dates;
	}

	public ArrayList<String> createFutureAdhocEventWithSpecificStartAndEndNever(String eventName,String eventDescription,int startDate,int startHours,String resourceName,ArrayList<String> statusTypeNames ) throws Exception{
		ArrayList<String> dates = new ArrayList<String>();
		this.navigateToCreateAdHocEventScreen();
		this.enterEventName(eventName);
		this.enterEventDescription(eventDescription);
		dates.add(this.updateFutureStartDateAndTimeForEvent(startDate, startHours));
		this.selectEventEndNeverOption();
		this.clickOnNext();
		this.verifyAdHocEventConfirmationPageIsDisplayed();
		this.clickKeep();
		this.verifySelectResourcesPageIsDisplayed();
		this.selectResource(resourceName);
		this.clickOnNext();
		this.verifySelectStatusTypesPageIsDisplayed();
		this.selectStatusTypes(statusTypeNames);
		this.clickOnNext();
		this.verifyAdHocEventConfirmationPageIsDisplayed();
		this.clickYes();
		return dates;
	}

	public EventManagement verifyResourceTypeAndStatusTypesUnderEventStatus(String eventName, String _resourceType, ArrayList<String> _statusType) throws Exception {
		this.clickOnEventBanner(eventName);
		waitForElement.waitForElements(Locators.TABLE_HEADER_OF_EVENT_STATUS + _resourceType + Locators.CLOSING_BRACKETS, "xpath");
		Iterator<String> itr = _statusType.iterator();
		while(itr.hasNext()){
			String statusTypenames =itr.next();
			String StatusTypesInPerticulerView= Locators.TABLE_HEADER_OF_EVENT_STATUS + _resourceType + Locators.RESOURCETYPE_AND_STATUSTYPES_UNDER_EVENT_STATUS + statusTypenames + Locators.CLOSING_BRACKETS;
			assertTrue(this.page.element(StatusTypesInPerticulerView, "xpath").isElementPresent(), StatusTypesInPerticulerView+"was not present");
			assertTrue(this.page.element(StatusTypesInPerticulerView, "xpath").getOne().isDisplayed(), StatusTypesInPerticulerView+"was not present");
		}
		return this;		
	}	

	public String createAdhocEvent(String eventName,String eventDescription,String resourceName,ArrayList<String> statusTypeNames) throws Exception {
		this.navigateToCreateAdHocEventScreen();
		this.enterEventName(eventName);
		this.enterEventDescription(eventDescription);
		this.clickOnNext();
		this.verifySelectResourcesPageIsDisplayed();
		this.selectResource(resourceName);
		this.clickOnNext();
		this.verifySelectStatusTypesPageIsDisplayed();
		this.selectStatusTypes(statusTypeNames);
		this.clickOnNext();
		this.verifyAdHocEventConfirmationPageIsDisplayed();
		String applicationTime = shared.getApplicationTime();
		String currentYear = dts.getCurrentDate("yyyy");
		applicationTime = applicationTime + " " + currentYear;
		applicationTime = dts.converDateFormat(applicationTime,
				"dd MMM HH:mm yyyy", "yyyy-MM-dd HH:mm");
		System.out.println("converted time"+ applicationTime);
		this.clickYes();
		return applicationTime;
	}


	public EventManagement selectStatusTypes(ArrayList<String> statusTypeNames) throws Exception {
		Iterator<String> iterator = statusTypeNames.iterator();
		while(iterator.hasNext()) {
			String statusTypeName = iterator.next();
			String eleString = Locators.PARTICIPATING_STATUSTYPE_INPUT_PART1 + statusTypeName 
					+ Locators.PARTICIPATING_STATUSTYPE_INPUT_PART2;
			if(!this.page.element(eleString, "xpath").getDisplayedOne().isSelected()){
				this.page.element(eleString, "xpath").getDisplayedOne().sendKeys(Keys.SPACE);
			}
			if(!this.page.element(eleString, "xpath").getDisplayedOne().isSelected()){
				this.page.element(eleString, "xpath").Click();
			}
			if(!this.page.element(eleString, "xpath").getDisplayedOne().isSelected()){
				this.page.element(eleString, "xpath").clickUsingJSE();
			}
			assertTrue(this.page.element(eleString, "xpath").getDisplayedOne().isSelected(), eleString + "is not selected");
		}
		return this;
	}

	public String getApplicationTimeAndAddhour(String applicationTime,int hour) throws Exception {
		String applicationTimePlusHour = dts.addTimetoExistingHour(applicationTime, hour, "yyyy-MM-dd HH:mm");
		return applicationTimePlusHour;
	}

	public EventManagement verifyStatusTypesNotDisplayedUnderEventStatus(String eventName, String _resourceType, ArrayList<String> _statusType) throws Exception {
		this.clickOnEventBanner(eventName);
		waitForElement.waitForElements(Locators.TABLE_HEADER_OF_EVENT_STATUS + _resourceType + Locators.CLOSING_BRACKETS, "xpath");
		Iterator<String> itr = _statusType.iterator();
		while(itr.hasNext()){
			String statusTypenames =itr.next();
			String StatusTypesInPerticulerView= Locators.TABLE_HEADER_OF_EVENT_STATUS + _resourceType + Locators.RESOURCETYPE_AND_STATUSTYPES_UNDER_EVENT_STATUS + statusTypenames + Locators.CLOSING_BRACKETS;
			assertFalse(this.page.element(StatusTypesInPerticulerView, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_TOO_SMALL), StatusTypesInPerticulerView+"was  present");
		}
		return this;		
	}	

	public EventManagement verifyCreateNewEventOnEventManagementPage()
			throws Exception {
		this.verifyEventManagementPage();
		waitForElement.waitForElements(Locators.CREATENEWEVENT, "css");
		assertTrue(this.page.element(Locators.CREATENEWEVENT, "css").isElementPresent());
		assertTrue(this.page.element(Locators.CREATENEWEVENT, "css").getOne().isDisplayed());
		return this;
	}

	public EventManagement verifySelectEventTemplateScreen() throws Exception {
		waitForElement.waitForElements(Locators.SELECT_EVENT_TEMPLATE, "xpath");
		assertTrue(this.page.element(Locators.SELECT_EVENT_TEMPLATE, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.SELECT_EVENT_TEMPLATE, "xpath").getOne().isDisplayed());
		return this;
	}

	public EventManagement verifyEventTemplate(String eventTemplateName) throws Exception {
		waitForElement.waitForElements(Locators.TABLECELLWITHTEXT + eventTemplateName + Locators.CLOSING_BRACKET, "xpath");
		assertTrue(this.page.element(Locators.TABLECELLWITHTEXT + eventTemplateName + Locators.CLOSING_BRACKET, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.TABLECELLWITHTEXT + eventTemplateName + Locators.CLOSING_BRACKET, "xpath").getOne().isDisplayed());
		return this;
	}

	public EventManagement verifyEventTemplateOnSelectEventTemplateScreen(String eventTemplateName) throws Exception {
		this.verifySelectEventTemplateScreen();
		this.verifyEventTemplate(eventTemplateName);
		return this;
	}

	public EventManagement verifyCreateEventScreen() throws Exception {
		waitForElement.waitForElements(Locators.CREATE_EVENT_PAGE, "xpath");
		assertTrue(this.page.element(Locators.CREATE_EVENT_PAGE, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.CREATE_EVENT_PAGE, "xpath").getOne().isDisplayed());
		waitForElement.waitForElements(Locators.EVENTNAME, "name");
		return this;
	}

	public String createEvent(String eventName, String eventDescription, String resourceName) throws Exception {
		this.enterEventName(eventName);
		System.out.println(eventName);
		this.enterEventDescription(eventDescription);
		this.selectResource(resourceName);
		String applicationTime = shared.getApplicationTime();
		String currentYear = dts.getCurrentDate("yyyy");
		applicationTime = applicationTime + " " + currentYear;
		applicationTime = dts.converDateFormat(applicationTime,
				"dd MMM HH:mm yyyy", "yyyy-MM-dd HH:mm");
		System.out.println("converted time"+ applicationTime);
		this.clickOnSave();
		return applicationTime;
	}

	public EventManagement verifyEventListScreen() throws Exception {
		waitForElement.waitForElements(Locators.EVENT_LIST_PAGE, "xpath");
		assertTrue(this.page.element(Locators.EVENT_LIST_PAGE, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.EVENT_LIST_PAGE, "xpath").getOne().isDisplayed());
		return this;
	}

	public EventManagement verifyEventInEventBanner(String eventName) throws Exception {
		waitForElement.waitForElements(Locators.DISPLAY_EVENT_BANNER_PART1 + eventName + Locators.CLOSING_BRACKET, "xpath");
		assertTrue(this.page.element(Locators.DISPLAY_EVENT_BANNER_PART1 + eventName + Locators.CLOSING_BRACKET, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.DISPLAY_EVENT_BANNER_PART1 + eventName + Locators.CLOSING_BRACKET, "xpath").getOne().isDisplayed());
		return this;
	}

	public String createMultiRegionEvent(String eventName,String eventDescription,String[] regionName,String[] eventTemplateName) throws Exception {
		this.enterEventName(eventName);
		this.enterEventDescription(eventDescription);
		this.selectParticipatingRegion(regionName, eventTemplateName);
		this.clickNext();
		String applicationTime = shared.getApplicationTime();
		String currentYear = dts.getCurrentDate("yyyy");
		applicationTime = applicationTime + " " + currentYear;
		applicationTime = dts.converDateFormat(applicationTime,
				"dd MMM HH:mm yyyy", "yyyy-MM-dd HH:mm");
		System.out.println("converted time"+ applicationTime);
		this.verifyMultiregionEventConfirmationPage();
		this.clickYes();
		return applicationTime;
	}

	public EventManagement verifySaveAtBottomOfThePageAfterEdit() throws Exception {
		waitForElement.waitForElements(Locators.SAVE_BUTTON_IN_BOTTOM_OF_PAGE_AFTER_EDIT, "xpath");
		assertTrue(this.page.element(Locators.SAVE_BUTTON_IN_BOTTOM_OF_PAGE_AFTER_EDIT, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.SAVE_BUTTON_IN_BOTTOM_OF_PAGE_AFTER_EDIT, "xpath").getOne().isDisplayed());
		return this;
	}

	public EventManagement verifyCancelAtBottomOfThePageAfterEdit() throws Exception {
		waitForElement.waitForElements(Locators.CANCEL_BUTTON_IN_BOTTOM_OF_PAGE_AFTER_EDIT, "xpath");
		assertTrue(this.page.element(Locators.CANCEL_BUTTON_IN_BOTTOM_OF_PAGE_AFTER_EDIT, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.CANCEL_BUTTON_IN_BOTTOM_OF_PAGE_AFTER_EDIT, "xpath").getOne().isDisplayed());
		return this;
	}

	public EventManagement verifyCancelAndSaveButtonAfterEdit() throws Exception {
		this.verifySaveAtTopOfThePage();
		this.verifyCancelAtTopOfThePage();
		this.verifySaveAtBottomOfThePageAfterEdit();
		this.verifyCancelAtBottomOfThePageAfterEdit();
		return this;
	}

	public String createFutureAdhocEventWithSpecificStartDateTimeAndEndHours(String eventName,String eventDescription,int startDate,int startHours,String eventEndHour,String resourceName,ArrayList<String> statusTypeNames ) throws Exception{
		this.navigateToCreateAdHocEventScreen();
		this.enterEventName(eventName);
		this.enterEventDescription(eventDescription);
		String date = this.updateFutureStartDateAndTimeForEvent(startDate, startHours);
		this.enterEndAfterSpecificHoursOfAnEvent(eventEndHour);
		this.clickOnNext();
		this.verifySelectResourcesPageIsDisplayed();
		this.selectResource(resourceName);
		this.clickOnNext();
		this.verifySelectStatusTypesPageIsDisplayed();
		this.selectStatusTypes(statusTypeNames);
		this.clickOnNext();
		this.verifyAdHocEventConfirmationPageIsDisplayed();
		this.clickYes();
		return date;
	}

	public EventManagement verifyEventDetailsOnEventList(String eventName, String status, String template, String eventInformation, String startTime, String endTime) throws Exception {
		this.verifyEventListScreen();
		this.verifyEventStatus(eventName, status);
		this.verifyEventTemplate(eventName, template);
		this.verifyEventInformation(eventName, eventInformation);
		this.verifyEventStartDate(eventName, startTime);
		this.verifyEventEndDate(eventName, endTime);
		return this;
	}

	public EventManagement createEventWithOutSelectingResource(String eventTemplateName, String eventName, String eventDescription) throws Exception {
		this.navigateToCreateNewEventScreen();
		this.selectEventTemplate(eventTemplateName);
		this.enterEventName(eventName);
		this.enterEventDescription(eventDescription);
		this.clickOnSave();
		this.verifyEventManagementPage();
		return this;
	}

	public EventManagement verifyEditEventPage() throws Exception {
		waitForElement.waitForElements(Locators.EDIT_EVENT, "xpath");
		assertTrue(this.page.element(Locators.EDIT_EVENT, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.EDIT_EVENT, "xpath").getOne().isDisplayed());
		return this;
	}

	public EventManagement editEventSelectResource(String eventName, String resourceName) throws Exception {
		this.verifyEventManagementPage();
		this.clickEditLink(eventName);
		this.verifyEditEventPage();
		this.selectResource(resourceName);
		this.clickOnSave();
		return this;
	}

	public EventManagement selectParticipatingRegion(String regionName, String eventTemplateName) throws Exception{
		for(int intCount=0; intCount<regionName.length(); intCount++)
		{
			waitForElement.waitForElements(Locators.PARTICIPATINGRESOURCEINPUTPART1+ regionName + Locators.CLOSING_BRACKET + Locators.PARTICIPATING_REGION_PART1 , "xpath");
			this.page.element(Locators.PARTICIPATINGRESOURCEINPUTPART1+ regionName + Locators.CLOSING_BRACKET + Locators.PARTICIPATING_REGION_PART1 , "xpath").webElementToSelect().selectByVisibleText(eventTemplateName);
			assertTrue(this.page.element(Locators.PARTICIPATINGRESOURCEINPUTPART1+ regionName + Locators.CLOSING_BRACKET + Locators.PARTICIPATING_REGION_PART1 , "xpath").webElementToSelect().getFirstSelectedOption().getText().equals(eventTemplateName));
		}
		return this;
	}

	public String editEventAndDeselectTemplateWithApplicationTime(String eventName,String regionName, String eventTemplateName, String updatedEventName, String eventDesc, int hour) throws Exception {
		this.verifyEventManagementPage();
		this.clickEditLink(eventName);
		this.verifyEditMultiregionEventPage();
		this.selectParticipatingRegion(regionName, eventTemplateName);
		this.clickOnNext();
		this.clickOnNext();
		this.clickYes();
		this.verifyWebNotificationAndClickOnAcknowledge(updatedEventName, eventDesc);
		this.verifyEventManagementPage();
		String applicationTime = shared.getApplicationTime();
		String currentYear = dts.getCurrentDate("yyyy");
		applicationTime = applicationTime + " " + currentYear;
		applicationTime = dts.converDateFormat(applicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/yyyy HH:mm");
		System.out.println("converted time"+ applicationTime);
		return applicationTime;
	}

	public EventManagement selectParticipatingRegion(ArrayList<String> region, ArrayList<String> eventTemplate) throws Exception{
		for(int intCount=0; intCount<region.size(); intCount++)
		{
			waitForElement.waitForElements(Locators.PARTICIPATINGRESOURCEINPUTPART1+ region.get(intCount) + Locators.CLOSING_BRACKET + Locators.PARTICIPATING_REGION_PART1 , "xpath");
			this.page.element(Locators.PARTICIPATINGRESOURCEINPUTPART1+ region.get(intCount) + Locators.CLOSING_BRACKET + Locators.PARTICIPATING_REGION_PART1 , "xpath").webElementToSelect().selectByVisibleText(eventTemplate.get(intCount));
			assertTrue(this.page.element(Locators.PARTICIPATINGRESOURCEINPUTPART1+ region.get(intCount) + Locators.CLOSING_BRACKET + Locators.PARTICIPATING_REGION_PART1 , "xpath").webElementToSelect().getFirstSelectedOption().getText().equals(eventTemplate.get(intCount)));
		}
		return this;
	}

	public String createMultiregionEvent(String eventName,String eventDescription,ArrayList<String> regionName,ArrayList<String> eventTemplateName) throws Exception {
		this.clickOnCreateNewMultiRegionEvent();
		this.enterEventName(eventName);
		this.enterEventDescription(eventDescription);
		this.selectParticipatingRegion(regionName, eventTemplateName);
		this.clickNext();
		String applicationTime = shared.getApplicationTime();
		String currentYear = dts.getCurrentDate("yyyy");
		applicationTime = applicationTime + " " + currentYear;
		applicationTime = dts.converDateFormat(applicationTime,
				"dd MMM HH:mm yyyy", "yyyy-MM-dd HH:mm");
		System.out.println("converted time"+ applicationTime);
		this.verifyMultiregionEventConfirmationPage();
		this.clickYes();
		return applicationTime;
	}

	public EventManagement verifyAddressRequiredMessage() throws Exception {
		waitForElement.waitForElements(Locators.ADDRESS_REQUIRED_ERROR_MESSAGE, "xpath");
		assertTrue(this.page.element(Locators.ADDRESS_REQUIRED_ERROR_MESSAGE + Locators.NO_CITY_PROVIDED, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.ADDRESS_REQUIRED_ERROR_MESSAGE + Locators.NO_CITY_PROVIDED, "xpath").getOne().isDisplayed());
		assertTrue(this.page.element(Locators.ADDRESS_REQUIRED_ERROR_MESSAGE + Locators.NO_STATE_PROVIDED, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.ADDRESS_REQUIRED_ERROR_MESSAGE + Locators.NO_STATE_PROVIDED, "xpath").getOne().isDisplayed());
		assertTrue(this.page.element(Locators.ADDRESS_REQUIRED_ERROR_MESSAGE + Locators.NO_COUNTY_PROVIDED, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.ADDRESS_REQUIRED_ERROR_MESSAGE + Locators.NO_COUNTY_PROVIDED, "xpath").getOne().isDisplayed());
		return this;
	}

	public EventManagement verifyCityStateCountyAreMandatory() throws Exception {
		waitForElement.waitForElements(Locators.MANDATORY_SYMBOL, "xpath");
		assertTrue(this.page.element(Locators.MANDATORY_SYMBOL + Locators.CITY_MANDATORY, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.MANDATORY_SYMBOL + Locators.CITY_MANDATORY, "xpath").getOne().isDisplayed());
		assertTrue(this.page.element(Locators.MANDATORY_SYMBOL + Locators.STATE_MANDATORY, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.MANDATORY_SYMBOL + Locators.STATE_MANDATORY, "xpath").getOne().isDisplayed());
		assertTrue(this.page.element(Locators.MANDATORY_SYMBOL + Locators.COUNTY_MANDATORY, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.MANDATORY_SYMBOL + Locators.COUNTY_MANDATORY, "xpath").getOne().isDisplayed());
		return this;
	}

	public EventManagement createEventWithAddress(String eventName, String eventDescription, String city, String state, String zipCode, String county) throws Exception {
		this.enterEventName(eventName);
		this.enterEventDescription(eventDescription);
		this.enterAddress(city, state, zipCode, county);
		this.clickOnSave();
		return this;
	}

	public EventManagement verifyEventOnEventManagementPage(String eventName) throws Exception {
		this.verifyEventManagementPage();
		this.verifyEventNameIsDisplayed(eventName);
		return this;
	}

	public EventManagement selectEventFromBannerToUpdate(String eventName) throws Exception {
		this.clickOnEventBanner(eventName);
		return this;		
	}	

	public EventManagement createAdHocEvent(String adHocEventName, String adHocEventDescription) throws Exception {
		this.enterEventName(adHocEventName);
		this.enterEventDescription(adHocEventDescription);
		this.clickOnNext();
		this.verifySelectResourcesPageIsDisplayed();
		this.clickOnNext();
		this.verifySelectStatusTypesPageIsDisplayed();
		this.clickOnNext();
		this.verifyAdHocEventConfirmationPageIsDisplayed();
		this.clickYes();
		return this;
	}

	public EventManagement verifyEditAdhocEventPage() throws Exception {
		waitForElement.waitForElements(Locators.EDIT_ADHOC_EVENT, "xpath");
		assertTrue(this.page.element(Locators.EDIT_ADHOC_EVENT, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.EDIT_ADHOC_EVENT, "xpath").getOne().isDisplayed());
		return this;
	}

	public EventManagement editEventSelectResourceAndStatusType(String eventName, String editEventName, String editEventDescription, String resourceName, ArrayList<String> statusTypeNames) throws Exception {
		this.verifyEventManagementPage();
		this.clickEditLink(eventName);
		this.verifyEditAdhocEventPage();
		this.enterEventName(editEventName);
		this.enterEventDescription(editEventDescription);
		this.clickOnNext();
		this.verifySelectResourcesPageIsDisplayed();
		this.selectResource(resourceName);
		this.clickOnNext();
		this.verifySelectStatusTypesPageIsDisplayed();
		this.selectStatusTypes(statusTypeNames);
		this.clickOnNext();
		this.verifyAdHocEventConfirmationPageIsDisplayed();
		this.clickYes();
		return this;
	}

	public EventManagement createMultiregionEventSelectOneResource(String eventName,String eventDescription, ArrayList<String> regionNames,ArrayList<String> eventTemplateName, String resourceName) throws Exception {
		this.clickOnCreateNewMultiRegionEvent();
		this.enterEventName(eventName);
		this.enterEventDescription(eventDescription);
		this.deselectIncludeAllResources();
		this.selectParticipatingRegion(regionNames, eventTemplateName);
		this.clickOnNext();
		this.clickOnNext();
		this.selectResource(resourceName);
		this.clickNext();
		this.clickYes();
		return this;
	}

	public EventManagement verifyEndLink(String eventName) throws Exception {
		waitForElement.waitForElements(Locators.EVENT_NAME_IN_TABLE + eventName + Locators.CLOSING_BRACKET + Locators.END_EVENT_NAME, "xpath");
		assertTrue(this.page.element(Locators.EVENT_NAME_IN_TABLE + eventName + Locators.CLOSING_BRACKET + Locators.END_EVENT_NAME, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.EVENT_NAME_IN_TABLE + eventName + Locators.CLOSING_BRACKET + Locators.END_EVENT_NAME, "xpath").getOne().isDisplayed());
		return this;
	}

	public EventManagement verifyEditAndEndLink(String eventName) throws Exception {
		this.verifyEventManagementPage();
		this.verifyEditLink(eventName);
		this.verifyEndLink(eventName);
		return this;
	}

	public EventManagement editEventAndSelectResource(String eventName, String resourceName) throws Exception {
		this.clickEditLink(eventName);
		this.clickOnNext();
		this.selectResource(resourceName);
		this.clickOnNext();
		this.clickNext();
		this.clickYes();
		return this;
	}

	public String createEventStartImmediatelyAndEndAtSpecificHour(String eventTemplate, String eventName, String eventDescription, String eventEndDate, String resourceName) throws Exception {
		this.navigateToCreateNewEventScreen();
		this.selectEventTemplate(eventTemplate);                      
		this.enterEventName(eventName);
		this.enterEventDescription(eventDescription);
		this.enterEndAfterSpecificHoursOfAnEvent(eventEndDate);
		this.selectResource(resourceName);
		String applicationTime = shared.getApplicationTime();
		String currentYear = dts.getCurrentDate("yyyy");
		applicationTime = applicationTime + " " + currentYear;
		applicationTime = dts.converDateFormat(applicationTime,
				"dd MMM HH:mm yyyy", "yyyy-MM-dd HH:mm");
		System.out.println("converted time"+ applicationTime);
		this.clickOnSave();
		this.verifyEventNameIsDisplayed(eventName);
		return applicationTime;
	}

	public String createAdhocEventWithEndSpecificDateAndTime(String eventName, String eventDescription,String eventEndDate, String resourceName,ArrayList<String> statusTypeNames) throws Exception {
		this.navigateToCreateAdHocEventScreen();
		this.enterEventName(eventName);
		this.enterEventDescription(eventDescription);
		this.enterEndAfterSpecificHoursOfAnEvent(eventEndDate);
		this.clickOnNext();
		this.verifySelectResourcesPageIsDisplayed();
		this.selectResource(resourceName);
		this.clickOnNext();
		this.verifySelectStatusTypesPageIsDisplayed();
		this.selectStatusTypes(statusTypeNames);
		this.clickOnNext();
		this.verifyAdHocEventConfirmationPageIsDisplayed();
		this.clickYes();
		String applicationTime = shared.getApplicationTime();
		String currentYear = dts.getCurrentDate("yyyy");
		applicationTime = applicationTime + " " + currentYear;
		applicationTime = dts.converDateFormat(applicationTime,
				"dd MMM HH:mm yyyy", "yyyy-MM-dd HH:mm");
		System.out.println("converted time"+ applicationTime);

		return applicationTime;
	}

	public String createAdhocEventAndDeselectDisplayBanner(String eventName,String eventDescription,String resourceName,ArrayList<String> statusTypeNames) throws Exception {
		this.navigateToCreateAdHocEventScreen();
		this.enterEventName(eventName);
		this.enterEventDescription(eventDescription);
		this.deselectDisplayEventBanner();
		this.clickOnNext();
		this.verifySelectResourcesPageIsDisplayed();
		this.clickOnNext();
		this.verifySelectStatusTypesPageIsDisplayed();
		this.clickOnNext();
		this.verifyAdHocEventConfirmationPageIsDisplayed();
		this.clickOnYes();
		this.verifyValidationMessage_ResourceNotSelected();
		this.clickPrevious();
		this.clickPrevious();
		this.selectResource(resourceName);
		this.clickOnNext();
		this.selectStatusTypes(statusTypeNames);
		this.clickOnNext();
		this.verifyAdHocEventConfirmationPageIsDisplayed();
		String applicationTime = shared.getApplicationTime();
		String currentYear = dts.getCurrentDate("yyyy");
		applicationTime = applicationTime + " " + currentYear;
		applicationTime = dts.converDateFormat(applicationTime,
				"dd MMM HH:mm yyyy", "yyyy-MM-dd HH:mm");
		System.out.println("converted time"+ applicationTime);
		this.clickOnYes();
		return applicationTime;
	}

	public EventManagement clickPrevious() throws Exception {
		waitForElement.waitForElements(Locators.PREVIOUS_BUTTON, "xpath");
		try{
			this.page.element(Locators.PREVIOUS_BUTTON, "xpath").clickUsingJSE();

			if (this.page.element(Locators.PREVIOUS_BUTTON, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL) == false) {
				this.page.element(Locators.PREVIOUS_BUTTON, "xpath").getDisplayedOne().click();
			}
			if(this.page.element(EMR.Locators.EventManagement.Locators.PREVIOUS_BUTTON, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL)==false) {
				this.page.element(Locators.PREVIOUS_BUTTON, "xpath").getDisplayedOne().sendKeys(Keys.ENTER);
			}
			assertTrue(this.page.element(EMR.Locators.EventManagement.Locators.PREVIOUS_BUTTON, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL));
		} catch(Exception e) {

		}
		return this;
	}

	public EventManagement verifyValidationMessage_ResourceNotSelected() throws Exception {
		String actualMsg=this.page.element(Locators.VALIDATION_MSG_FOR_EVENTBANNER, "xpath").getOne().getText();
		String ConfirmationMsg = "At least one resource must be selected for an event that is not displayed in the event banner.";
		assertTrue(actualMsg.equals(ConfirmationMsg));
		return this;
	}

	public EventManagement clickOnYes() throws Exception {
		waitForElement.waitForElements(Locators.YES, "css");
		try{
			this.page.element(Locators.YES, "css").clickUsingJSE();

			if (this.page.element(Locators.YES, "css").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL) == false) {
				this.page.element(Locators.YES, "css").getDisplayedOne().click();
			}
			if(this.page.element(EMR.Locators.EventManagement.Locators.YES, "css").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL)==false) {
				this.page.element(Locators.YES, "css").getDisplayedOne().sendKeys(Keys.ENTER);
			}
			assertTrue(this.page.element(EMR.Locators.EventManagement.Locators.YES, "css").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL));
		} catch(Exception e) {

		}
		return this;
	}

	public EventManagement createEventWithAddress(String eventTemplateName, String eventName, String eventDescription, String city, String state, String zipCode, String county, String resourceName) throws Exception {
		this.navigateToCreateNewEventScreen();
		this.selectEventTemplate(eventTemplateName);
		this.verifyCancelAndSaveButton();
		this.enterEventName(eventName);
		this.enterEventDescription(eventDescription);
		this.enterAddress(city, state, zipCode, county);
		this.selectResource(resourceName);
		this.clickOnSave();
		return this;
	}

	public String getEventStartDate(String eventName) throws Exception {
		waitForElement.waitForElements(Locators.PARTICIPATINGRESOURCEINPUTPART1 + eventName + Locators.CLOSING_BRACKET + Locators.EVENT_START_DATE, "xpath");
		String eventStartDateAndTime = this.page.element(Locators.PARTICIPATINGRESOURCEINPUTPART1 + eventName + Locators.CLOSING_BRACKET + Locators.EVENT_START_DATE, "xpath").getOne().getText();
		return eventStartDateAndTime;
	}

	public EventManagement verifyAddressOnEventBanner(String eventName, String eventStartDateAndTime, String userFullName, String eventDescription, String city, String countyCode, String zipCode, String county) throws Exception {
		this.clickOnEventBanner(eventName);
		String[] startDateAndTime = eventStartDateAndTime.split(" ");
		String startDateAndTime1 = dts.converDateFormat(startDateAndTime[0], "yyyy-mm-dd", "mm/dd/yy");
		String startDateAndTime2 = startDateAndTime1 + " " + startDateAndTime[1];

		waitForElement.waitForElements(Locators.ADDRESS_ON_EVENT_BANNER, "xpath");
		System.out.println(this.page.element(Locators.ADDRESS_ON_EVENT_BANNER, "xpath").getOne().getText());

		String applicationTime = shared.getApplicationTimeWithCSTCDT();
		String applicationTime1[] = applicationTime.split(" ");
		assertEquals("Created By: " + userFullName + " @ " + startDateAndTime2
				+ " "+ applicationTime1[3]+"\n" + eventDescription + " Location:  " + city + " "+countyCode+" "
				+ zipCode + " " + county,
				this.page.element(Locators.ADDRESS_ON_EVENT_BANNER, "xpath")
				.getOne().getText());
		return this;
	}

	public EventManagement verifyAddressIsNotOnEventBanner(String eventName, String eventStartDateAndTime, String userFullName, String eventDescription, String city, String countyCode, String zipCode, String county) throws Exception {
		this.clickOnEventBanner(eventName);
		String[] startDateAndTime = eventStartDateAndTime.split(" ");
		String startDateAndTime1 = dts.converDateFormat(startDateAndTime[0], "yyyy-mm-dd", "mm/dd/yy");
		String startDateAndTime2 = startDateAndTime1 + " " + startDateAndTime[1];
		String applicationTime = shared.getApplicationTimeWithCSTCDT();
		String applicationTime1[] = applicationTime.split(" ");
		waitForElement.waitForElements(Locators.ADDRESS_ON_EVENT_BANNER, "xpath");
		String detailsOnEventBanner = this.page.element(Locators.ADDRESS_ON_EVENT_BANNER, "xpath").getOne().getText();
		assertFalse(detailsOnEventBanner.contains(city));
		assertFalse(detailsOnEventBanner.contains(countyCode));
		assertFalse(detailsOnEventBanner.contains(zipCode));
		assertFalse(detailsOnEventBanner.contains(county));
		assertEquals("Created By: " + userFullName + " @ " + startDateAndTime2
				+ " "+ applicationTime1[3]+"\n" + eventDescription ,
				this.page.element(Locators.ADDRESS_ON_EVENT_BANNER, "xpath")
				.getOne().getText());
		return this;
	}

	public String createNeverEndAdhocEvent(String eventName,String eventDescription,String resourceName,ArrayList<String> statusTypeNames ) throws Exception{
		this.navigateToCreateAdHocEventScreen();
		this.enterEventName(eventName);
		this.enterEventDescription(eventDescription);
		this.selectEventEndNeverOption();
		this.clickOnNext();
		this.verifyAdHocEventConfirmationPageIsDisplayed();
		this.clickKeep();
		this.verifySelectResourcesPageIsDisplayed();
		this.selectResource(resourceName);
		this.clickOnNext();
		this.verifySelectStatusTypesPageIsDisplayed();
		this.selectStatusTypes(statusTypeNames);
		this.clickOnNext();
		this.verifyAdHocEventConfirmationPageIsDisplayed();
		String applicationTime = shared.getApplicationTime();
		String currentYear = dts.getCurrentDate("yyyy");
		applicationTime = applicationTime + " " + currentYear;
		applicationTime = dts.converDateFormat(applicationTime,
				"dd MMM HH:mm yyyy", "yyyy-MM-dd HH:mm");
		System.out.println("converted time"+ applicationTime);
		this.clickYes();
		return applicationTime;
	}

	public ArrayList<String> createAndModifyAdhocEventWithFutureStartAndEndDate(String eventName,String eventDescription,int startDate,int startHours,int endDate,int  endHours,String resourceName,ArrayList<String> statusTypeNames,int editEndDate,int editEndHours ) throws Exception{
		ArrayList<String> dates = new ArrayList<String>();
		this.navigateToCreateAdHocEventScreen();
		this.enterEventName(eventName);
		this.enterEventDescription(eventDescription);
		dates.add(this.updateFutureStartDateAndTimeForEvent(startDate, startHours));
		dates.add(this.updateFutureEndDateAndTimeForEvent(endDate, endHours));
		this.selectEventEndNeverOption();
		this.clickOnNext();
		this.verifyAdHocEventConfirmationPageIsDisplayed();
		this.clickModify();
		dates.add(this.updateFutureEndDateAndTimeForEvent(editEndDate, editEndHours));
		this.clickOnNext();
		this.verifySelectResourcesPageIsDisplayed();
		this.selectResource(resourceName);
		this.clickOnNext();
		this.verifySelectStatusTypesPageIsDisplayed();
		this.selectStatusTypes(statusTypeNames);
		this.clickOnNext();
		this.verifyAdHocEventConfirmationPageIsDisplayed();
		this.clickYes();
		return dates;
	}

	public String createAdhocEventWithEndTimeAndDeselectResource(String eventName, String eventDescription) throws Exception {
		this.navigateToCreateAdHocEventScreen();
		this.enterEventName(eventName);
		this.enterEventDescription(eventDescription);
		this.clickOnNext();
		this.verifySelectResourcesPageIsDisplayed();
		this.clickOnNext();
		this.verifySelectStatusTypesPageIsDisplayed();
		this.clickOnNext();
		this.verifyAdHocEventConfirmationPageIsDisplayed();
		this.clickYes();
		String applicationTime = shared.getApplicationTime();
		String currentYear = dts.getCurrentDate("yyyy");
		applicationTime = applicationTime + " " + currentYear;
		applicationTime = dts.converDateFormat(applicationTime,
				"dd MMM HH:mm yyyy", "yyyy-MM-dd HH:mm");
		System.out.println("converted time"+ applicationTime);

		return applicationTime;
	}

	public EventManagement noAdhocEventButtonPresent() throws Exception {
		assertFalse(this.page.element(Locators.CREATE_ADHOC_EVENT, "css").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}

	public EventManagement editAdhocEvent(String eventName,String editEventName) throws Exception {
		this.clickEditLink(eventName);
		this.verifyEditAdhocEventPage();
		this.enterEventName(editEventName);
		this.clickOnNext();
		this.verifySelectResourcesPageIsDisplayed();
		this.clickOnNext();
		this.verifySelectStatusTypesPageIsDisplayed();
		this.clickOnNext();
		this.verifyAdHocEventConfirmationPageIsDisplayed();
		this.clickOnYes();
		return this;
	}

	public String editAdhocEventSelectSpecificEndDateTime(String eventName,String editEventName,int endDateTime, int endHours) throws Exception {
		this.verifyEventManagementPage();
		this.clickEditLink(eventName);
		this.verifyEditAdhocEventPage();
		this.enterEventName(editEventName);
		String endDate = this.updateFutureEndDateAndTimeForEvent(endDateTime, endHours);
		this.clickOnNext();
		this.clickOnNext();
		this.clickOnNext();
		this.clickYes();
		return endDate;
	}

	public EventManagement verifyResourceUnderResourcesToParticipateInThisEventSection(String resourceName) throws Exception {
		waitForElement.waitForElements(Locators.RESOURCE_TO_PARTICIPATE + resourceName + Locators.CLOSING_BRACKET, "xpath");
		assertTrue(this.page.element(Locators.RESOURCE_TO_PARTICIPATE + resourceName + Locators.CLOSING_BRACKET, "xpath").isElementPresent(),Locators.RESOURCE_TO_PARTICIPATE + resourceName + Locators.CLOSING_BRACKET +" is not displayed");
		assertTrue(this.page.element(Locators.RESOURCE_TO_PARTICIPATE + resourceName + Locators.CLOSING_BRACKET, "xpath").getDisplayedOne().isDisplayed(),Locators.RESOURCE_TO_PARTICIPATE + resourceName + Locators.CLOSING_BRACKET +" is not displayed");
		return this;
	}

	public EventManagement verifyResourceResourceTypeAndStatusTypesUnderEventStatus(String resourceTypeName, ArrayList<String> statusTypeNames, String resourceName) throws Exception {
		waitForElement.waitForElements(Locators.TABLE_HEADER_OF_EVENT_STATUS + resourceTypeName + Locators.CLOSING_BRACKETS  , "xpath");
		Iterator<String> itr = statusTypeNames.iterator();
		while(itr.hasNext()){
			String statusTypeName =itr.next();
			String StatusTypesInEventStatus= Locators.TABLE_HEADER_OF_EVENT_STATUS + resourceTypeName + Locators.RESOURCETYPE_AND_STATUSTYPES_UNDER_EVENT_STATUS + statusTypeName + Locators.CLOSING_BRACKETS + Locators.RESOURCE_UNDER_EVENT_STATUS + resourceName + Locators.CLOSING_BRACKET ;
			assertTrue(this.page.element(StatusTypesInEventStatus, "xpath").isElementPresent(), StatusTypesInEventStatus+"was not present");
			assertTrue(this.page.element(StatusTypesInEventStatus, "xpath").getOne().isDisplayed(), StatusTypesInEventStatus+"was not present");
		}
		return this;		
	}	

	public EventManagement verifyEventActionOnEventList(String eventName) throws Exception {
		this.verifyEventListScreen();
		waitForElement.waitForElements(Locators.TABLECELLWITHTEXT + eventName + Locators.CLOSING_BRACKET + Locators.TABLE_CELL_WITH_PRECEDING_SIBLING , "xpath");
		assertTrue(this.page.element(Locators.TABLECELLWITHTEXT + eventName + Locators.CLOSING_BRACKET + Locators.TABLE_CELL_WITH_PRECEDING_SIBLING , "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.TABLECELLWITHTEXT + eventName + Locators.CLOSING_BRACKET + Locators.TABLE_CELL_WITH_PRECEDING_SIBLING , "xpath").getOne().isDisplayed());
		assertTrue(this.page.element(Locators.TABLECELLWITHTEXT + eventName + Locators.CLOSING_BRACKET + Locators.TABLE_CELL_WITH_PRECEDING_SIBLING , "xpath").getOne().getText().equals("View"));
		return this;
	}

	public EventManagement verifyResourceAndResourcetypeIsNotDisplayedOnEventStatus(String resourceTypeName, String resourceName) throws Exception {
		assertFalse(this.page.element(Locators.RESOURCELISTPART1 + resourceTypeName + Locators.RESOURCELISTPART2 + resourceName + Locators.CLOSEBRACKETS, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE),resourceTypeName +"And"+ resourceName+" is displayed");
		return this;
	}

	public EventManagement verifyUpdatedStatusTypesValuesUnderEventStatus(String resourceTypeValue, String resourceValue,ArrayList<String> statusTypeValue, ArrayList<String> updatedStatusType) throws Exception {
		view.verifyUpdatedStatusTypeValue(resourceTypeValue, resourceValue, statusTypeValue, updatedStatusType);
		return this;
	}
	public String editAdhocEventSelectSpecificEndHour(String eventName,String editEventName,String eventEndHours,String eventStartTime,int hour) throws Exception {
		this.verifyEventManagementPage();
		this.clickEditLink(eventName);
		this.verifyEditAdhocEventPage();
		this.enterEventName(editEventName);
		this.enableEventEndAfterSpecificHours();
		this.enterEndAfterSpecificHoursOfAnEvent(eventEndHours);
		this.clickOnNext();
		this.clickOnNext();
		this.clickOnNext();
		String applicationTimePlusHour = dts.addTimetoExistingHour(eventStartTime, hour, "yyyy-MM-dd HH:mm");
		this.clickYes();
		return applicationTimePlusHour;
	}
	
	public EventManagement verifyEditLinkIsNotPresent(String eventName) throws Exception {
		waitForElement.waitForElements(Locators.EVENT_NAME_IN_TABLE + eventName + Locators.CLOSING_BRACKET + Locators.EDIT_EVENT_NAME, "xpath");
		assertFalse(this.page.element(Locators.EVENT_NAME_IN_TABLE + eventName + Locators.CLOSING_BRACKET + Locators.EDIT_EVENT_NAME, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE),eventName +" is displayed");
		return this;
	}
	
	public EventManagement verifyEndLinkIsNotPresent(String eventName) throws Exception {
		waitForElement.waitForElements(Locators.EVENT_NAME_IN_TABLE + eventName + Locators.CLOSING_BRACKET + Locators.END_EVENT_NAME, "xpath");
		assertFalse(this.page.element(Locators.EVENT_NAME_IN_TABLE + eventName + Locators.CLOSING_BRACKET + Locators.END_EVENT_NAME, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE),eventName +" is displayed");
		return this;
	}
	
	public EventManagement verifyEditAndEndLinkIsNotPresent(String eventName) throws Exception {
		this.verifyEventManagementPage();
		this.verifyEditLinkIsNotPresent(eventName);
		this.verifyEndLinkIsNotPresent(eventName);
		return this;
	}
	
	public EventManagement verifyEventTemplateNotPresent(String eventTemplateName) throws Exception {
		waitForElement.waitForElements(Locators.TABLECELLWITHTEXT + eventTemplateName + Locators.CLOSING_BRACKET, "xpath");
		assertFalse(this.page.element(Locators.TABLECELLWITHTEXT + eventTemplateName + Locators.CLOSING_BRACKET, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE),eventTemplateName +" is displayed");
		return this;
	}
	
	public EventManagement verifyEventTemplateIsNotOnSelectEventTemplateScreen(String eventTemplateName) throws Exception {
		this.verifySelectEventTemplateScreen();
		this.verifyEventTemplateNotPresent(eventTemplateName);
		return this;
	}
	
	public EventManagement verifyEventTemplateDescription(String eventTemplateName, String eventTemplateDescription) throws Exception {
		waitForElement.waitForElements(Locators.TABLECELLWITHTEXT + eventTemplateName + Locators.CLOSING_BRACKET + Locators.FOLLOWING_COLOUMN_OF_TITLE + eventTemplateDescription + Locators.CLOSING_BRACKET, "xpath");
		assertTrue(this.page.element(Locators.TABLECELLWITHTEXT + eventTemplateName + Locators.CLOSING_BRACKET + Locators.FOLLOWING_COLOUMN_OF_TITLE + eventTemplateDescription + Locators.CLOSING_BRACKET, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.TABLECELLWITHTEXT + eventTemplateName + Locators.CLOSING_BRACKET + Locators.FOLLOWING_COLOUMN_OF_TITLE + eventTemplateDescription + Locators.CLOSING_BRACKET, "xpath").getOne().isDisplayed());
		return this;
	}
	
	public EventManagement verifyEventTemplateNameDescriptionIconOnSelectEventTemplateScreen(String eventTemplateName, String eventTemplateDescription, String icon) throws Exception {
		this.verifySelectEventTemplateScreen();
		this.verifyEventTemplate(eventTemplateName);
		this.verifyEventTemplateDescription(eventTemplateName, eventTemplateDescription);
		this.verifyEventIcon(eventTemplateName, icon);
		return this;
	}

	public EventManagement verifyEventTemplateNameIconOneventManagement(String eventName, String eventTemplateName, String icon) throws Exception {
		this.verifyEventManagementPage();
		this.verifyEventTemplate(eventName, eventTemplateName);
		this.verifyEventIcon(eventName, icon);
		return this;
	}
	
	public EventManagement verifyResourceNotUnderResourcesToParticipateInThisEventSection(String resourceName) throws Exception {
		waitForElement.waitForElements(Locators.RESOURCE_TO_PARTICIPATE + resourceName + Locators.CLOSING_BRACKET, "xpath");
		assertFalse(this.page.element(Locators.RESOURCE_TO_PARTICIPATE + resourceName + Locators.CLOSING_BRACKET, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE), resourceName + "Resource is displayed");
		return this;
	}
	
	public ArrayList<String> editAdhocEventSelectSpecificStartAndEndDateAndTime(String eventName,String editEventName,int startDate,int startHours,int endDateTime, int endHours) throws Exception {
		ArrayList<String> dates = new ArrayList<String>();
		this.verifyEventManagementPage();
		this.clickEditLink(eventName);
		this.verifyEditAdhocEventPage();
		this.enterEventName(editEventName);
		dates.add(this.updateFutureStartDateAndTimeForEvent(startDate, startHours));
		dates.add(this.updateFutureEndDateAndTimeForEvent(endDateTime, endHours));
		this.clickOnNext();
		this.clickOnNext();
		this.clickOnNext();
		this.clickYes();
		return dates;
	}
	
	public ArrayList<String> editAdhocEventWithEndDateAndTime(String eventName,String editEventName,int endDateTime, int endHours) throws Exception {
		ArrayList<String> dates = new ArrayList<String>();
		this.verifyEventManagementPage();
		this.clickEditLink(eventName);
		this.verifyEditAdhocEventPage();
		this.enterEventName(editEventName);
		dates.add(this.updateFutureEndDateAndTimeForEvent(endDateTime, endHours));
		this.clickOnNext();
		this.clickOnNext();
		this.clickOnNext();
		this.clickYes();
		return dates;
	}
	
	public String getContentOfProtectedHealthInformation() throws Exception {
		String contentInPHI = "Under the US Health Insurance Portability and Accountability Act (HIPAA), PHI must be treated with special care."
				+ "\n"
				+ "Intermedix recommends you do not include any Protected Health Information (PHI) in any event you create in EMResource. "
				+ "As an information sharing and resource management tool, EMResource was never intended to be certified as a HIPAA-compliant solution." 
				+ "\n" 
	            + "PHI is any information that is linked to individuals, and is defined based on the following 18 identifiers:"
				+ "\n"
	            + "Names" 
				+ "\n"
				+ "All geographical identifiers smaller than a state, except for the initial three digits of a zip code if, " 
				 
				+ "according to the current publicly available data from the Bureau of the Census: the geographic unit formed by " 
				+ "combining all zip codes with the same three initial digits contains more than 20,000 people; and the initial "
				+ "three digits of a zip code for all such geographic units containing 20,000 or fewer people is changed to 000"
				+ "\n"
				+ "Dates (other than year) directly related to an individual"
				+ "\n" 
				+ "Phone numbers" 
				+ "\n" 
				+ "Fax numbers"
				+ "\n"
				+ "Email addresses"
				+ "\n"
				+ "Social Security numbers"
				+ "\n"
				+ "Medical record numbers"
				+ "\n"
				+ "Health insurance beneficiary numbers"
				+ "\n"
				+ "Account numbers"
				+ "\n"
				+ "Certificate/license numbers"
				+ "\n"
				+ "Vehicle identifiers and serial numbers, including license plate numbers;"
				+ "\n"
				+ "Device identifiers and serial numbers;"
				+ "\n"
				+ "Web Uniform Resource Locators (URLs)"
				+ "\n"
				+ "Internet Protocol (IP) address numbers"
				+ "\n"
				+ "Biometric identifiers, including finger, retinal and voice prints"
				+ "\n"
				+ "Full face photographic images and any comparable images"
				+ "\n"
				+ "Any other unique identifying number, characteristic, or code except the unique code assigned by the investigator to code the data";
		return contentInPHI;
	}
	
	public boolean verifyContentOnProtectedHealthInformation(String contentInPHI) throws Exception {
		boolean blnCheck = false;
		waitForElement.waitForElements(Locators.PROTECTED_HEALTH_INFORMATION, "xpath");
		String contentOnPHI = this.page.element(Locators.CONTENT_IN_PROTECTED_HEALTH_INFORMATION, "xpath").getOne().getText();
		System.out.println("Content on web" + contentOnPHI);
		System.out.println("FORMED: " + contentInPHI);
		if(contentOnPHI.contains(contentInPHI)){
			blnCheck=true;
			System.out.println(blnCheck);
			assertTrue(blnCheck);
		}
		return blnCheck;
	}
	
	public EventManagement closeProtectedHealthInformation() throws Exception {
		login.switchToDefaultWindow();
		login.selectFrame();
		waitForElement.waitForElements(Locators.CLOSE_PROTECTED_HEALTH_INFORMATION, "xpath");
		this.page.element(Locators.CLOSE_PROTECTED_HEALTH_INFORMATION, "xpath").mouseOver();
		this.page.element(Locators.CLOSE_PROTECTED_HEALTH_INFORMATION, "xpath").getDisplayedOne().click();
		this.page.element_wait(Locators.CLOSE_PROTECTED_HEALTH_INFORMATION, "xpath").waitForInvisibilityOfElement();
		login.switchToDefaultWindow();
		login.selectFrame();
		return this;
	}

	public EventManagement clickOnProtectedHealthInformation() throws Exception {
		waitForElement.waitForElements(Locators.PROTECTED_HEALTH_INFORMATION, "xpath");
		this.page.element(Locators.PROTECTED_HEALTH_INFORMATION, "xpath").getOne().click();
		return this;
	}
	
	public EventManagement navigateToProtectedHealthInformation(String eventTemplateName) throws Exception {
		this.navigateToCreateNewEventScreen();
		this.selectEventTemplate(eventTemplateName);
		this.verifyCancelAndSaveButton();
		this.clickOnProtectedHealthInformation();
		this.verifyWebNotificationframe();
		String contentInPHI = this.getContentOfProtectedHealthInformation();
		this.verifyContentOnProtectedHealthInformation(contentInPHI);
		this.closeProtectedHealthInformation();
		this.NavigateToCancelAtOfTopOfThePage();
		return this;
	}
	
	public EventManagement verifyCreateAdhocEventScreen() throws Exception {
		waitForElement.waitForElements(Locators.CREATE_ADHOC_EVENT_SCREEN, "xpath");
		assertTrue(this.page.element(Locators.CREATE_ADHOC_EVENT_SCREEN, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.CREATE_ADHOC_EVENT_SCREEN, "xpath").getOne().isDisplayed());
		return this;
	}
	
	public EventManagement clickCancel() throws Exception {
		waitForElement.waitForElements(Locators.CANCEL, "css");
		try{
			this.page.element(Locators.CANCEL, "css").clickUsingJSE();

			if (this.page.element(Locators.EVENT_MANAGEMENT, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL) == false) {
				this.page.element(Locators.CANCEL, "css").getDisplayedOne().click();
				waitForElement.waitForElements(Locators.EVENT_MANAGEMENT, "xpath");
			}
			if(this.page.element(EMR.Locators.EventManagement.Locators.EVENT_MANAGEMENT, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL)==false) {
				this.page.element(Locators.CANCEL, "css").getDisplayedOne().sendKeys(Keys.ENTER);
			}
			waitForElement.waitForElements(Locators.EVENT_MANAGEMENT,"xpath" );
			assertTrue(this.page.element(EMR.Locators.EventManagement.Locators.EVENT_MANAGEMENT, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL));
		} catch(Exception e) {

		}
		return this;
	}
	
	public EventManagement verifyEventTemplateNotOnSelectEventTemplateScreen(String eventTemplateName) throws Exception {
		this.verifySelectEventTemplateScreen();
		this.verifyEventTemplateNotPresent(eventTemplateName);
		return this;
	}
	
	public EventManagement verifyNotificationLink(String eventName) throws Exception {
		waitForElement.waitForElement(Locators.EVENT_NAME_IN_TABLE + eventName + Locators.CLOSING_BRACKET+Locators.EVENT_TEMPLATE_WITH_NOTIFICATION, "xpath");
		assertTrue(this.page.element(Locators.EVENT_NAME_IN_TABLE + eventName + Locators.CLOSING_BRACKET+Locators.EVENT_TEMPLATE_WITH_NOTIFICATION, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.EVENT_NAME_IN_TABLE + eventName + Locators.CLOSING_BRACKET+Locators.EVENT_TEMPLATE_WITH_NOTIFICATION, "xpath").getOne().isDisplayed());
		return this;
	}
	
	public EventManagement verifySecutityLinkIsNotPresent(String eventName)throws Exception {
		waitForElement.waitForElement(Locators.EVENT_NAME_IN_TABLE + eventName + Locators.CLOSING_BRACKET+ Locators.EVENT_TEMPLATE_WITH_SECURITY,"xpath");
		assertFalse(this.page.element(Locators.EVENT_NAME_IN_TABLE + eventName + Locators.CLOSING_BRACKET+ Locators.EVENT_TEMPLATE_WITH_SECURITY,"xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE), eventName + "SecurityLink is displayed");
		return this;
	}
	
	public EventManagement verifyEventOnEventList(String eventName) throws Exception {
		this.verifyEventListScreen();
		this.verifyEventNameIsDisplayed(eventName);
		return this;
	}
	
	public String getTimeInWebNotificationAndChangeDateFormat() throws Exception {
		waitForElement.waitForElements("dd.ts", "css");
		String dateAndTime = this.page.element("dd.ts", "css").getOne().getText();
		String currentYear = dts.getCurrentDate("yyyy");
		dateAndTime = dateAndTime + " " + currentYear;
		dateAndTime = dts.converDateFormat(dateAndTime,
				"MM/d/yyy HH:mm", "yyyy-MM-dd HH:mm");
		System.out.println("converted time"+ dateAndTime);
		return dateAndTime;	
	}
	
	public ArrayList<String> createEventStartImmediatelyAndEndAtSpecificDateAndTime(String eventTemplate, String eventName, String eventDescription, int eventEndDate, int eventEndHours, String resourceName) throws Exception {
		ArrayList<String> dates = new ArrayList<String>();
		this.navigateToCreateNewEventScreen();
		this.selectEventTemplate(eventTemplate);                      
		this.enterEventName(eventName);
		this.enterEventDescription(eventDescription);
		dates.add(this.updateFutureEndDateAndTimeForEvent(eventEndDate, eventEndHours));
		this.selectResource(resourceName);
		String applicationTime = shared.getApplicationTime();
		String currentYear = dts.getCurrentDate("yyyy");
		applicationTime = applicationTime + " " + currentYear;
		applicationTime = dts.converDateFormat(applicationTime,
				"dd MMM HH:mm yyyy", "yyyy-MM-dd HH:mm");
		System.out.println("converted time"+ applicationTime);
		dates.add(applicationTime);
		this.clickOnSave();
		this.verifyEventNameIsDisplayed(eventName);
		return dates;
	}
	
	public String createEventStartImmediatelyAndNeverEnd(String eventTemplate, String eventName, String eventDescription, String resourceName) throws Exception {
		this.navigateToCreateNewEventScreen();
		this.selectEventTemplate(eventTemplate);                      
		this.enterEventName(eventName);
		this.enterEventDescription(eventDescription);
		this.selectEventEndNeverOption();
		this.selectResource(resourceName);
		String applicationTime = shared.getApplicationTime();
		String currentYear = dts.getCurrentDate("yyyy");
		applicationTime = applicationTime + " " + currentYear;
		applicationTime = dts.converDateFormat(applicationTime,
				"dd MMM HH:mm yyyy", "yyyy-MM-dd HH:mm");
		System.out.println("converted time"+ applicationTime);
		this.clickOnSave();
		this.verifyEventNameIsDisplayed(eventName);
		return applicationTime;
	}
	
	public EventManagement verifyEventDetailsWithNeverEndOnEventListScreen(String eventName, String Status, String Template, String eventInformation, String startTime, String eventEndAsNever) throws Exception {
		this.verifyEventListScreen();
		this.verifyEventStatus(eventName, Status);
		this.verifyEventTemplate(eventName, Template);
		this.verifyEventInformation(eventName, eventInformation);
		this.verifyEventStartDate(eventName, startTime);
		this.verifyEventEndAsNever(eventName, eventEndAsNever);
		return this;
	}
	
	public EventManagement verifyStatusTypesDisplayedUnderEventStatus(String eventName, String _resourceType, ArrayList<String> _statusType) throws Exception {
		this.clickOnEventBanner(eventName);
		waitForElement.waitForElements(Locators.TABLE_HEADER_OF_EVENT_STATUS + _resourceType + Locators.CLOSING_BRACKETS, "xpath");
		Iterator<String> itr = _statusType.iterator();
		while(itr.hasNext()){
			String statusTypenames =itr.next();
			String eventStatusTypes= Locators.TABLE_HEADER_OF_EVENT_STATUS + _resourceType + Locators.RESOURCETYPE_AND_STATUSTYPES_UNDER_EVENT_STATUS + statusTypenames + Locators.CLOSING_BRACKETS;
			assertTrue(this.page.element(eventStatusTypes, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_TOO_SMALL), statusTypenames+"was not present");
			assertTrue(this.page.element(eventStatusTypes, "xpath").getOne().isDisplayed());
		}
		return this;		
	}
	
	public String createEventWithStartAtSpecificDateAndTimeAndEndAtSpecificHour(String eventTemplate, String eventName, String eventDescription, int startDate, int startHours, String eventEndDate, String resourceName) throws Exception {
		this.navigateToCreateNewEventScreen();
		this.selectEventTemplate(eventTemplate);                      
		this.enterEventName(eventName);
		this.enterEventDescription(eventDescription);
		String dates = this.updateFutureStartDateAndTimeForEvent(startDate, startHours);
		this.enterEndAfterSpecificHoursOfAnEvent(eventEndDate);
		this.selectResource(resourceName);
		this.clickOnSave();
		this.verifyEventNameIsDisplayed(eventName);
		return dates;
	}
	
	public EventManagement verifyCancelLink(String eventName) throws Exception {
		waitForElement.waitForElements(Locators.EVENT_NAME_IN_TABLE + eventName + Locators.CLOSING_BRACKET + Locators.CANCEL_EVENT_NAME, "xpath");
		assertTrue(this.page.element(Locators.EVENT_NAME_IN_TABLE + eventName + Locators.CLOSING_BRACKET + Locators.CANCEL_EVENT_NAME, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.EVENT_NAME_IN_TABLE + eventName + Locators.CLOSING_BRACKET + Locators.CANCEL_EVENT_NAME, "xpath").getOne().isDisplayed());
		return this;
	}
	
	public EventManagement verifyEditAndCancelLink(String eventName) throws Exception {
		this.verifyEventManagementPage();
		this.verifyEditLink(eventName);
		this.verifyCancelLink(eventName);
		return this;
	}
	
	public EventManagement verifyEventNameIsNotDisplayed(String eventName)
			throws Exception {
		waitForElement.waitForElements(Locators.EVENTMANAGEMENTTABLE
				+ Locators.TABLECELL + eventName + Locators.CLOSING_BRACKET, "xpath");
		assertFalse(this.page.element(Locators.EVENTMANAGEMENTTABLE
				+ Locators.TABLECELL + eventName + Locators.CLOSING_BRACKET, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE),eventName +" is displayed");
		return this;
	}
	
	public EventManagement verifyEventNotInEventList(String eventName) throws Exception {
		this.verifyEventListScreen();
		this.verifyEventNameIsNotDisplayed(eventName);
		return this;
	}
	
	public ArrayList<String> createEventStartAndEndAtSpecificDateAndTime(String eventTemplate, String eventName, String eventDescription, int startDate, int startHours, int endDate, int endHours, String resourceName) throws Exception {
		ArrayList<String> dates = new ArrayList<String>();
		this.navigateToCreateNewEventScreen();
		this.selectEventTemplate(eventTemplate);                      
		this.enterEventName(eventName);
		this.enterEventDescription(eventDescription);
		dates.add(this.updateFutureStartDateAndTimeForEvent(startDate, startHours));
		dates.add(this.updateFutureEndDateAndTimeForEvent(endDate, endHours));
		this.selectResource(resourceName);
		this.clickOnSave();
		this.verifyEventNameIsDisplayed(eventName);
		return dates;
	}
	
	public String createEventStartSpecificDateAndTimeAndNeverEnds(String eventTemplate, String eventName, String eventDescription, int startDate, int startHours, String resourceName) throws Exception {
		this.navigateToCreateNewEventScreen();
		this.selectEventTemplate(eventTemplate);                      
		this.enterEventName(eventName);
		this.enterEventDescription(eventDescription);
		String dates = this.updateFutureStartDateAndTimeForEvent(startDate, startHours);
		this.selectEventEndNeverOption();
		this.selectResource(resourceName);
		this.clickOnSave();
		this.verifyEventNameIsDisplayed(eventName);
		return dates;
	}
	
	public EventManagement verifyEventHeaderAndPosition(ArrayList<String> headerName) throws Exception {
		for(int i=0; i<headerName.size(); i++){
		if(headerName.get(i).equals("Action")||headerName.get(i).equals("Icon")){
			waitForElement.waitForElements(Locators.EVENT_POSITION + (i+1) + Locators.EVENT_HEADER_PART1 + headerName.get(i) + Locators.CLOSING_BRACKET, "xpath");
			System.out.println("headerName.get(i)" + headerName.get(i));
			System.out.println("(i+1)" + (i+1));
			System.out.println("size" + headerName.size());
			assertTrue(this.page.element(Locators.EVENT_POSITION + (i+1) + Locators.EVENT_HEADER_PART1 + headerName.get(i) + Locators.CLOSING_BRACKET, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_TOO_SMALL), headerName.get(i) + "is not present");
			assertTrue(this.page.element(Locators.EVENT_POSITION + (i+1) + Locators.EVENT_HEADER_PART1 + headerName.get(i) + Locators.CLOSING_BRACKET, "xpath").getOne().isDisplayed(), headerName.get(i) + "is not present");
		}
		else{
			waitForElement.waitForElements(Locators.EVENT_POSITION + (i+1) + Locators.EVENT_HEADER_PART2 + headerName.get(i) + Locators.CLOSING_BRACKET, "xpath");
			System.out.println("headerName.get(i)" + headerName.get(i));
			System.out.println("(i+1)" + (i+1));
			assertTrue(this.page.element(Locators.EVENT_POSITION + (i+1) + Locators.EVENT_HEADER_PART2 + headerName.get(i) + Locators.CLOSING_BRACKET, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_TOO_SMALL), headerName.get(i) + "is not present");
			assertTrue(this.page.element(Locators.EVENT_POSITION + (i+1) + Locators.EVENT_HEADER_PART2 + headerName.get(i) + Locators.CLOSING_BRACKET, "xpath").getOne().isDisplayed(), headerName.get(i) + "is not present");
		}
		}
		return this;
	}
	
	public EventManagement verifyEventRenotifyDisabled() throws Exception {
		waitForElement.waitForElements(Locators.EVENT_RENOTIFY_DISABLED, "xpath");
		assertTrue(this.page.element(Locators.EVENT_RENOTIFY_DISABLED, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.EVENT_RENOTIFY_DISABLED, "xpath").getOne().isDisplayed());
		return this;
	}
	
	public EventManagement verifyEventRenotifyEveryHour() throws Exception {
		waitForElement.waitForElements(Locators.EVENT_RENOTIFY_EVERY_HOUR, "xpath");
		assertTrue(this.page.element(Locators.EVENT_RENOTIFY_EVERY_HOUR, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.EVENT_RENOTIFY_EVERY_HOUR, "xpath").getOne().isDisplayed());
		return this;
	}
	
	public EventManagement verifyEventRenotifyAtSpecifiedTimes() throws Exception {
		waitForElement.waitForElements(Locators.EVENT_RENOTIFY_AT_SPECIFIED_TIMES, "xpath");
		assertTrue(this.page.element(Locators.EVENT_RENOTIFY_AT_SPECIFIED_TIMES, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.EVENT_RENOTIFY_AT_SPECIFIED_TIMES, "xpath").getOne().isDisplayed());
		return this;
	}
	
	public EventManagement verifyRenotify() throws Exception {
		this.verifyEventRenotifyDisabled();
		this.verifyEventRenotifyEveryHour();
		this.verifyEventRenotifyAtSpecifiedTimes();
		return this;
	}
	
	public EventManagement verifyAllFieldsOnCreateEventScreen(String resourceName) throws Exception {
		    this.verifyEventName();
			this.verifyEventDescription();
			this.verifyEventStartOption();
			this.verifyEventEndOption();
			this.verifyDocumentUploadOptionIsPresent();
			this.verifyDisplayInEventBanner();
			this.verifyPrivateOption();
			this.verifyDrillOption();
			this.verifyEndQuietly();
			this.verifyRenotify();
			this.verifyEventAddress();
			this.verifyResourceUnderResourcesToParticipateInThisEventSection(resourceName);
			return this;
	}
	
	public EventManagement verifyEditLinkUnderAction(String eventName) throws Exception {
		waitForElement.waitForElements(Locators.EVENT_ACTION + Locators.EVENT_NAME_IN_TABLE + eventName + Locators.CLOSING_BRACKET + Locators.EDIT_EVENT_NAME, "xpath");
		assertTrue(this.page.element(Locators.EVENT_ACTION + Locators.EVENT_NAME_IN_TABLE + eventName + Locators.CLOSING_BRACKET + Locators.EDIT_EVENT_NAME, "xpath").isElementPresent(), "Edit Link of" + eventName + "is not present");
		assertTrue(this.page.element(Locators.EVENT_ACTION + Locators.EVENT_NAME_IN_TABLE + eventName + Locators.CLOSING_BRACKET + Locators.EDIT_EVENT_NAME, "xpath").getOne().isDisplayed(), "Edit Link of" + eventName + "is not displayed");
		return this;
	}
	
	public EventManagement verifyEndLinkUnderAction(String eventName) throws Exception {
		waitForElement.waitForElements(Locators.EVENT_ACTION + Locators.EVENT_NAME_IN_TABLE + eventName + Locators.CLOSING_BRACKET + Locators.END_EVENT_NAME, "xpath");
		assertTrue(this.page.element(Locators.EVENT_ACTION + Locators.EVENT_NAME_IN_TABLE + eventName + Locators.CLOSING_BRACKET + Locators.END_EVENT_NAME, "xpath").isElementPresent(), "End Link of" + eventName + "is not present");
		assertTrue(this.page.element(Locators.EVENT_ACTION + Locators.EVENT_NAME_IN_TABLE + eventName + Locators.CLOSING_BRACKET + Locators.END_EVENT_NAME, "xpath").getOne().isDisplayed(), "End Link of" + eventName + "is not displayed");
		return this;
	}
	
	public EventManagement verifyEditAndEndLinkUnderAction(String eventName) throws Exception {
		this.verifyEventManagementPage();
		this.verifyEditLinkUnderAction(eventName);
		this.verifyEndLinkUnderAction(eventName);
		return this;
	}
	
	public EventManagement verifyEventUnderTitle(String eventName) throws Exception {
		waitForElement.waitForElements(Locators.EVENT_TITLE + Locators.EVENT_NAME_IN_TABLE + eventName + Locators.CLOSING_BRACKET, "xpath");
		assertTrue(this.page.element(Locators.EVENT_TITLE + Locators.EVENT_NAME_IN_TABLE + eventName + Locators.CLOSING_BRACKET, "xpath").isElementPresent(), eventName + "is not present");
		assertTrue(this.page.element(Locators.EVENT_TITLE + Locators.EVENT_NAME_IN_TABLE + eventName + Locators.CLOSING_BRACKET, "xpath").getOne().isDisplayed(), eventName + "is not displayed");
		return this;
	}
	
	public EventManagement verifyEventDrill(String eventName,String drill) throws Exception {
		waitForElement.waitForElements(Locators.TABLECELLWITHTEXT + eventName + Locators.CLOSING_BRACKET + Locators.FOLLOWING_COLOUMN_OF_TITLE + drill + Locators.CLOSING_BRACKET , "xpath");
		assertTrue(this.page.element(Locators.TABLECELLWITHTEXT + eventName + Locators.CLOSING_BRACKET + Locators.FOLLOWING_COLOUMN_OF_TITLE + drill + Locators.CLOSING_BRACKET , "xpath").isElementPresent(), eventName + "Drill column is" + drill);
		assertTrue(this.page.element(Locators.TABLECELLWITHTEXT + eventName + Locators.CLOSING_BRACKET + Locators.FOLLOWING_COLOUMN_OF_TITLE + drill + Locators.CLOSING_BRACKET , "xpath").getOne().isDisplayed(), eventName + "Drill column is" + drill);
		return this;
	}
	
	public EventManagement verifyEventDetails(String eventName, String icon, String status, String startTime, String endTime, String drill, String eventTemplate, String eventInformation) throws Exception {
		this.verifyEditAndEndLinkUnderAction(eventName);
        this.verifyEventIcon(eventName, icon);
        this.verifyEventStatus(eventName, status);
        this.verifyEventStartDate(eventName, startTime);
        this.verifyEventEndDate(eventName, endTime);
        this.verifyEventUnderTitle(eventName);
        this.verifyEventDrill(eventName, drill);
        this.verifyEventTemplate(eventName, eventTemplate);
        this.verifyEventInformation(eventName, eventInformation);
		return this;
	}
	
	public EventManagement verifyEventNameAndDescriptionOnEventBanner(String eventName, String eventStartDateAndTime, String userFullName, String eventDescription) throws Exception {
		this.clickOnEventBanner(eventName);
		String[] startDateAndTime = eventStartDateAndTime.split(" ");
		String startDateAndTime1 = dts.converDateFormat(startDateAndTime[0], "yyyy-mm-dd", "mm/dd/yy");
		String startDateAndTime2 = startDateAndTime1 + " " + startDateAndTime[1];

		waitForElement.waitForElements(Locators.ADDRESS_ON_EVENT_BANNER, "xpath");
		System.out.println(this.page.element(Locators.ADDRESS_ON_EVENT_BANNER, "xpath").getOne().getText());

		String applicationTime = shared.getApplicationTimeWithCSTCDT();
		String applicationTime1[] = applicationTime.split(" ");
		assertEquals("Created By: " + userFullName + " @ " + startDateAndTime2
				+ " "+ applicationTime1[3]+"\n" + eventDescription,
				this.page.element(Locators.ADDRESS_ON_EVENT_BANNER, "xpath")
				.getOne().getText());
		return this;
	}
	
	public EventManagement verifyViewHistoryLinkNotPresentOnBanner(String eventID) throws Exception {
		waitForElement.waitForElements(Locators.EVENT_ID + eventID + Locators.CLOSING_BRACKET + Locators.VIEW_HISTORY_ON_EVENT_BANNER, "xpath");
		assertFalse(this.page.element(Locators.EVENT_ID + eventID + Locators.CLOSING_BRACKET + Locators.VIEW_HISTORY_ON_EVENT_BANNER, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE), "ViewHistory link is displayed for " + eventID);
		return this;
	}
	
	public String getEventID(String eventName) throws Exception {
		waitForElement.waitForElements(Locators.DISPLAY_EVENT_BANNER_PART1 + eventName + Locators.CLOSING_BRACKET, "xpath");
		String eventId = this.page.element(Locators.DISPLAY_EVENT_BANNER_PART1 + eventName + Locators.CLOSING_BRACKET, "xpath").getOne().getAttribute("id");
		eventId = eventId.replace("t", "");
		return eventId;
	}
	
	public EventManagement verifyEventDetailsOnEventBanner(String eventName, String eventStartDateAndTime, String userFullName, String eventDescription) throws Exception {
		this.clickOnEventBanner(eventName);
		this.verifyEventNameAndDescriptionOnEventBanner(eventName, eventStartDateAndTime, userFullName, eventDescription);
        String eventID = this.getEventID(eventName);
		this.verifyViewHistoryLinkNotPresentOnBanner(eventID);
		return this;
	}
	
	public EventManagement selectEventStartImmediatelyOption() throws Exception {
		waitForElement.waitForElements(Locators.EVENTSTART_IMMEDIATELY, "xpath");
		if(this.page.element(Locators.EVENTSTART_IMMEDIATELY, "xpath").getOne().isSelected() == false){
			this.page.element(Locators.EVENTSTART_IMMEDIATELY, "xpath").getOne().click();
		}
		if(this.page.element(Locators.EVENTSTART_IMMEDIATELY, "xpath").getOne().isSelected() == false){
			this.page.element(Locators.EVENTSTART_IMMEDIATELY, "xpath").clickUsingJSE();
		}
		assertTrue(this.page.element(Locators.EVENTSTART_IMMEDIATELY, "xpath").getOne().isSelected(), "Event Start Immediately Option is not present");
		return this;
	}
	
	public String updateFutureEventStartDate(String eventName, String editedEventName, String editedEventDescription, int hour) throws Exception {
		this.verifyEventOnEventManagementPage(eventName);
		this.clickOnEditLink(eventName);
        this.enterEventName(editedEventName);
		this.enterEventDescription(editedEventDescription);
		String applicationTime = shared.getApplicationTime();
		String currentYear = dts.getCurrentDate("yyyy");
		applicationTime = applicationTime + " " + currentYear;
		applicationTime = dts.converDateFormat(applicationTime,
				"dd MMM HH:mm yyyy", "yyyy-MM-dd HH:mm");
		System.out.println("converted time"+ applicationTime);
		String startDateAndTime = dts.addTimetoExisting(applicationTime, hour, "yyyy-MM-dd HH:mm");
		String[] timeformat = applicationTime.split(" ");
		String[] timeformat1 = timeformat[1].split(":");
		String[] timeformat2 = timeformat[0].split("-");
		String[] timeformat3 = startDateAndTime.split(" ");
		String[] timeformat4 = timeformat3[1].split(":");
		this.selectEventStartDay(timeformat2[2]);
		this.selectEventStartHour(timeformat1[0]);
		this.selectEventStartMinute(timeformat4[1]);
		this.clickOnSave();
		this.verifyEventNameIsDisplayed(editedEventName);
		return startDateAndTime;
	}
	
	public String updateFutureEventEndDate(String eventName, String editedEventName, String editedEventDescription, int hour) throws Exception {
		this.verifyEventOnEventManagementPage(eventName);
		this.clickOnEditLink(eventName);
        this.enterEventName(editedEventName);
		this.enterEventDescription(editedEventDescription);
		String applicationTime = shared.getApplicationTime();
		String currentYear = dts.getCurrentDate("yyyy");
		applicationTime = applicationTime + " " + currentYear;
		applicationTime = dts.converDateFormat(applicationTime,
				"dd MMM HH:mm yyyy", "yyyy-MM-dd HH:mm");
		System.out.println("converted time"+ applicationTime);
		String endDateAndTime = dts.addTimetoExisting(applicationTime, hour, "yyyy-MM-dd HH:mm");
		String[] timeformat = applicationTime.split(" ");
		String[] timeformat1 = timeformat[1].split(":");
		String[] timeformat2 = timeformat[0].split("-");
		String[] timeformat3 = endDateAndTime.split(" ");
		String[] timeformat4 = timeformat3[1].split(":");
		System.out.println("timeformat2[2] "  + timeformat2[2]);
		System.out.println("timeformat1[0] "  + timeformat1[0]);
		System.out.println("timeformat4[1] "  + timeformat4[1]);
//		this.selectEventEndDay(timeformat2[2]);
//		this.selectEventEndHour(timeformat1[0]);
		this.selectEventEndMinute(timeformat4[1]);
		this.clickOnSave();
		this.verifyEventNameIsDisplayed(editedEventName);
		return endDateAndTime;
	}
	
	public EventManagement clickOnEditLink(String eventName) throws Exception{
		waitForElement.waitForElements(Locators.EVENT_NAME_IN_TABLE + eventName + Locators.CLOSING_BRACKET + Locators.EDIT_EVENT_NAME, "xpath");
		try{
			this.page.element(Locators.EVENT_NAME_IN_TABLE + eventName + Locators.CLOSING_BRACKET + Locators.EDIT_EVENT_NAME, "xpath").clickUsingJSE();

			if (this.page.element(Locators.EDIT_EVENT, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL) == false) {
				this.page.element(Locators.EVENT_NAME_IN_TABLE + eventName + Locators.CLOSING_BRACKET + Locators.EDIT_EVENT_NAME, "xpath").getOne().click();
				waitForElement.waitForElements(Locators.EDIT_EVENT, "xpath");
			}
			if(this.page.element(EMR.Locators.EventManagement.Locators.EDIT_EVENT, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL)==false) {
				this.page.element(Locators.EVENT_NAME_IN_TABLE + eventName + Locators.CLOSING_BRACKET + Locators.EDIT_EVENT_NAME, "xpath").getOne().sendKeys(Keys.ENTER);
			}
			waitForElement.waitForElements(Locators.EDIT_EVENT, "xpath");
			assertTrue(this.page.element(EMR.Locators.EventManagement.Locators.EDIT_EVENT, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL));
		} catch(Exception e) {

		}
		return this;
	}
	
	public ArrayList<String> createFutureEventStartWithSpecificDateTime(String eventTemplate, String eventName, String eventDescription, int startHour, String resourceName, int endHour) throws Exception {
		ArrayList<String> dates = new ArrayList<String>();
		this.navigateToCreateNewEventScreen();
		this.selectEventTemplate(eventTemplate);                      
		this.enterEventName(eventName);
		this.enterEventDescription(eventDescription);
		String applicationTime = shared.getApplicationTime();
		String currentYear = dts.getCurrentDate("yyyy");
		applicationTime = applicationTime + " " + currentYear;
		applicationTime = dts.converDateFormat(applicationTime,
				"dd MMM HH:mm yyyy", "yyyy-MM-dd HH:mm");
		System.out.println("converted time"+ applicationTime);
		String startDateAndTime = dts.addTimetoExisting(applicationTime, startHour, "yyyy-MM-dd HH:mm");
		String[] timeformat = applicationTime.split(" ");
		String[] timeformat1 = timeformat[1].split(":");
		String[] timeformat2 = timeformat[0].split("-");
		String[] timeformat3 = startDateAndTime.split(" ");
		String[] timeformat4 = timeformat3[1].split(":");
		this.selectEventStartOption();
//		this.selectEventStartDay(timeformat2[2]);
//		this.selectEventStartHour(timeformat1[0]);
		this.selectEventStartMinute(timeformat4[1]);
		String endDateAndTime = dts.addTimetoExisting(applicationTime, endHour, "yyyy-MM-dd HH:mm");
		String[] timeformat5 = timeformat[1].split(":");
		String[] timeformat6 = timeformat[0].split("-");
		String[] timeformat7 = endDateAndTime.split(" ");
		String[] timeformat8 = timeformat7[1].split(":");
		this.selectEventEndOption();
//		this.selectEventEndDay(timeformat6[2]);
//		this.selectEventEndHour(timeformat5[0]);
		this.selectEventEndMinute(timeformat8[1]);
		this.selectResource(resourceName);
		dates.addAll(Arrays.asList(startDateAndTime, endDateAndTime));
		this.clickOnSave();
		this.verifyEventNameIsDisplayed(eventName);
		System.out.println("timeformat4[1]"  + timeformat4[1]);
		System.out.println("timeformat8[1]"  + timeformat8[1]);
		return dates;
	}
	
	public int getApplicationTimeAndStartTimeDifference(String eventName) throws Exception {
		String applicationTime = shared.getApplicationTime();
		String currentYear = dts.getCurrentDate("yyyy");
		applicationTime = applicationTime + " " + currentYear;
		String[] timeformat = applicationTime.split(" ");
		String eventStartDateAndTime = this.getEventStartDate(eventName);
		String[] timeformat1 = eventStartDateAndTime.split(" ");
		int TimeDifference = dts.getTimeDiff(timeformat1[1], timeformat[2]);
		System.out.println("TimeDifference" + TimeDifference);
		return TimeDifference;
	}
	
	public EventManagement addResourceToExistingEvent(String eventName,String resourceName) throws Exception {
		 this.clickOnEditLink(eventName);
         this.selectResource(resourceName);
         this.clickOnSave();
         return this;
	}
	
	public EventManagement deSelectResource(String resourceName) throws Exception {
		waitForElement.waitForElements(Locators.PARTICIPATINGRESOURCEINPUTPART1 + resourceName + "']"
						+ Locators.PARTICIPATINGRESOURCEINPUTPART2, "xpath");
		if(this.page.element(Locators.PARTICIPATINGRESOURCEINPUTPART1 + resourceName + "']"
				+ Locators.PARTICIPATINGRESOURCEINPUTPART2,	"xpath").getOne().isSelected())
	   {
			this.page.element(Locators.PARTICIPATINGRESOURCEINPUTPART1 + resourceName + "']"
					+ Locators.PARTICIPATINGRESOURCEINPUTPART2,	"xpath").getDisplayedOne().click();
	   }
		return this;
	}
	
	public EventManagement editEventDeselectResource(String eventName,String editEventName,String editEventDescription,String resourceName) throws Exception {
		this.clickOnEditLink(eventName);
		this.enterEventName(editEventName);
		this.enterEventDescription(editEventDescription);
        this.deSelectResource(resourceName);
        this.clickOnSave();
        return this;
	}
}
