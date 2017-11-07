package EMR.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import EMR.pages.Shared;
import qaFramework.WaitTimeConstants;
import qaFramework.UserDefinedFunctions.WaitForElement;
import qaFramework.pageObject.PageObject;
import EMR.Locators.RegionDefault.Locators;
import EMTrack.data.EMTrackData;

public class RegionDefault extends PageObject {

	WebDriver driver;
	WaitForElement waitForElement;
	WebDriverWait wait;
	Login login;
	Shared navigateTo;

	public RegionDefault(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		waitForElement = new WaitForElement(this.driver);
		wait = new WebDriverWait(this.driver, WaitTimeConstants.WAIT_TIME_SMALL);
		login = new Login(this.driver);
		navigateTo= new Shared(this.driver);
	}

	public RegionDefault verifyRegionName(String _regionName) throws Exception {
		waitForElement.waitForElements(Locators.REGION_NAME + _regionName + Locators.CLOSING_BRACES, "xpath");
		assertTrue(this.page.element(Locators.REGION_NAME + _regionName + Locators.CLOSING_BRACES, "xpath").isElementPresent());
		return this;
	}

	public RegionDefault verifyResourceTypeAndStatusType(String _resourceType, String _statusType) throws Exception {
		waitForElement.waitForElements(Locators.RESOURCETYPE_AND_STATUSTYPE_PART1 +_resourceType+ Locators.RESOURCETYPE_AND_STATUSTYPE_PART2 +_statusType+ Locators.CLOSING_BRACKET, "xpath");
		assertTrue(this.page.element(Locators.RESOURCETYPE_AND_STATUSTYPE_PART1 +_resourceType+ Locators.RESOURCETYPE_AND_STATUSTYPE_PART2 +_statusType+ Locators.CLOSING_BRACKET, "xpath").isElementPresent());
		return this;
	}

	public RegionDefault verifyResourceTypeAndResource(String _resourceType, String _resource) throws Exception {
		waitForElement.waitForElements(Locators.RESOURCETYPE_AND_STATUSTYPE_PART1  + _resourceType+ Locators.RESOURCETYPE_AND_RESOURCE_PART2 + _resource + Locators.CLOSING_BRACKET, "xpath");
		assertTrue(this.page.element(Locators.RESOURCETYPE_AND_STATUSTYPE_PART1  + _resourceType+ Locators.RESOURCETYPE_AND_RESOURCE_PART2 + _resource + Locators.CLOSING_BRACKET, "xpath").isElementPresent());
		return this;
	}

	public RegionDefault verifyResourceTypeAndStatusType(String _resourceType, String _statusType[]) throws Exception {
		waitForElement.waitForElements(Locators.RESOURCETYPE_AND_STATUSTYPE_PART1 + _resourceType + Locators.CLOSING_BRACKET, "xpath");

		for(int intCount=0; intCount<_statusType.length; intCount++){
			assertTrue(this.page.element(Locators.RESOURCETYPE_AND_STATUSTYPE_PART1 + _resourceType + Locators.RESOURCETYPE_AND_STATUSTYPE_PART2 +_statusType[intCount] + Locators.CLOSING_BRACKET, "xpath").isElementPresent());
		}
		return this;
	}

	public RegionDefault verifyResourceTypeAndResource(String _resourceType, String _resource[]) throws Exception {
		waitForElement.waitForElements(Locators.RESOURCETYPE_AND_STATUSTYPE_PART1  + _resourceType + Locators.CLOSING_BRACKET, "xpath");
		for(int intCount=0; intCount<_resource.length; intCount++){
			assertTrue(this.page.element(Locators.RESOURCETYPE_AND_STATUSTYPE_PART1  + _resourceType+ Locators.RESOURCETYPE_AND_RESOURCE_PART2 + _resource[intCount] + Locators.CLOSING_BRACKET, "xpath").isElementPresent());
		}
		return this;
	}

	public RegionDefault verifyRegionDefaultPage() throws Exception {
		waitForElement.waitForElements(Locators.REGION_DEFAULT, "xpath");		
		assertTrue(this.page.element(Locators.REGION_DEFAULT, "xpath").isElementPresent());		
		assertTrue(this.page.element(Locators.REGION_DEFAULT, "xpath").getOne().isDisplayed());
		return this;
	}

	public RegionDefault verifyRegionDefaultPageWithDefaultInBrackets() throws Exception {
		waitForElement.waitForElements(Locators.REGION_DEFAULT_1, "xpath");		
		assertTrue(this.page.element(Locators.REGION_DEFAULT_1, "xpath").isElementPresent());		
		assertTrue(this.page.element(Locators.REGION_DEFAULT_1, "xpath").getOne().isDisplayed());
		return this;
	}

	public RegionDefault clickOnAppSwitcher() throws Exception {
		waitForElement.waitForElements(Locators.APP_SWITCHER, "xpath");		
		assertTrue(this.page.element(Locators.APP_SWITCHER, "xpath").isElementPresent());		
		this.page.element(Locators.APP_SWITCHER, "xpath").Click();
		return this;
	}

	public RegionDefault clickOnEicsInAppSwitcher() throws Exception {
		waitForElement.waitForElements(Locators.EICS_UNDER_APP_SWITCHER, "xpath");		
		assertTrue(this.page.element(Locators.EICS_UNDER_APP_SWITCHER, "xpath").isElementPresent());		
		this.page.element(Locators.EICS_UNDER_APP_SWITCHER, "xpath").Click();
		return this;
	}

	public RegionDefault switchToEicsApplication() throws Exception {
		this.clickOnAppSwitcher();
		this.clickOnEicsInAppSwitcher();
		return this;
	}

	public RegionDefault verifyWebNotificationframe() throws Exception {
		try{
			waitForElement.waitForElements(Locators.WEB_NOTIFICATION_FRAME, "id");
			this.driver.switchTo().frame(Locators.WEB_NOTIFICATION_FRAME);
			System.out.println("switched to notification frame");
		}catch(Exception e) {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(Locators.WEB_NOTIFICATION_FRAME));
			System.out.println("switched after waiting");
		}
		return this;
	}

	public RegionDefault verifyIPNWebNotifaication(String subject,String sentBy,String age,String complaint, String triage,String gender,String region,String levelOfCare,String emsAgency,String emsUnit)throws Exception {

		String[] answers = {sentBy,age, complaint, triage, gender,region,levelOfCare,emsAgency,emsUnit};
		String[] headers =EMTrackData.IPN_PATIENT_HEADERS;
		waitForElement.waitForElementBycssSelector(Locators.WEBNOTIFICATION_FRAME);
		assertEquals(Locators.WEBNOTIFICATION_SUBJECT+subject,this.page.element(Locators.WEBNOTIFICATION_FRAME, "css").getOne().getText());
		for (int i = 0; i <= (answers.length - 1); i++) {
			String ipnWebcontent =Locators.WEBNOTIFICATION+headers[i]+Locators.CLOSING_BRACKET+Locators.WEBNOTIFICATION_1+answers[i]+Locators.CLOSING_BRACES;
			System.out.println("ipnWebcontent" + ipnWebcontent);
			assertTrue(this.page.element(ipnWebcontent, "xpath").isElementPresent(), headers[i] + " : "
					+ answers[i] + " is not present");
			assertTrue(this.page.element(ipnWebcontent, "xpath").getOne().isDisplayed(), headers[i] + " : "
					+ answers[i] + " is not dispalyed");
		}
		return this;
	}

	public RegionDefault clickOnAcknowledgeAllNotifications() throws Exception {
		waitForElement.waitForElements(Locators.ACKNOWLEDGE_ALL_NOTIFICATIONS, "xpath");
		this.page.element(Locators.ACKNOWLEDGE_ALL_NOTIFICATIONS, "xpath").mouseOver();
		this.page.element(Locators.ACKNOWLEDGE_ALL_NOTIFICATIONS, "xpath").getOne().click();
		//assertTrue(this.page.element_wait(Locators.ACKNOWLEDGE_ALL_NOTIFICATIONS, "css").waitForInvisibilityOfElement());
		return this;
	}

	public String getArrivalTimeFromIpnWebNotification() throws Exception {
		waitForElement.waitForElements(Locators.ETA_IN_IPN_WEBNOTIFICATION, "xpath");
		String eta= this.page.element(Locators.ETA_IN_IPN_WEBNOTIFICATION, "xpath").getOne().getText();
		return eta;
	}

	public String verifyIPNWebNotifaicationContentAndAcknowledge(String subject
			,String sentBy,String age,String complaint, String triage,String gender,String region,String levelOfCare,String emsAgency,String emsUnit) throws Exception{
		verifyWebNotificationframe();
		verifyIPNWebNotifaication(subject,sentBy,age,complaint,triage,gender,region,levelOfCare,emsAgency,emsUnit);
		String eta=getArrivalTimeFromIpnWebNotification();
		clickOnAcknowledgeAllNotifications();
		login.switchToDefaultWindow();
		login.selectFrame();
		return eta;	
	} 

	public RegionDefault verifyResourceAndCorrespondingStatusTypes(String _resourceType,String _resource, String _statusTypes[]) throws Exception {
		this.verifyResourceTypeAndResource(_resourceType, _resource);
		this.verifyResourceTypeAndStatusType(_resourceType, _statusTypes);
		return this;
	}	

	public String getWebNotificationForOneQuestionnaire(
			String userFullName, String regionName, String labelName1,
			String labelValue1) throws Exception {
		String messageBody = "Submitted by " + userFullName + "\n"
				+ "Region: " + regionName + "\n" + "Summary: | "
				+ labelName1 + ": " + labelValue1;
		System.out.println("Formed web notification:" + messageBody);
		return messageBody;
	}

	public String getWebNotificationForThreeQuestionnaire(String userFullName, String regionName, 
			String labelName1, String labelValue1, String labelName2, String labelValue2, String labelName3, String labelValue3) throws Exception {
		String msgBody = "Submitted by " + userFullName + "\n"
				+ "Region: " + regionName + "\n" + "Summary: | "
				+ labelName1 + ": " + labelValue1
				+ "| " + labelName2 + ": " + labelValue2
				+ "| " + labelName3 + ": " + labelValue3;
		System.out.println("Formed web notification:" + msgBody);
		return msgBody;
	}

	public RegionDefault acknowledgeAllForms() throws Exception {
		waitForElement.waitForElements(Locators.ACKNOWLEDGE_ALL_FORMS, "xpath");
		this.page.element(Locators.ACKNOWLEDGE_ALL_FORMS, "xpath").mouseOver();
		this.page.element(Locators.ACKNOWLEDGE_ALL_FORMS, "xpath").getOne().click();
		//		this.page.element_wait(Locators.ACKNOWLEDGE_ALL_FORMS, "xpath").waitForInvisibilityOfElement();
		return this;
	}

	public RegionDefault clickOnResourceToNavigateResourceDetailPage(String resource) throws Exception {
		waitForElement.waitForElements(Locators.RESOURCE_LINK+resource+Locators.CLOSING_BRACKET, "xpath");
		this.page.element(Locators.RESOURCE_LINK+resource+Locators.CLOSING_BRACKET, "xpath").mouseOver();
		this.page.element(Locators.RESOURCE_LINK+resource+Locators.CLOSING_BRACKET, "xpath").getOne().click();
		return this;
	}

	public RegionDefault clickOnUpdateStatusKeyAndNavigateToUpdateStatusPage(String resource) throws Exception {
		waitForElement.waitForElements(Locators.UPDATE_KEY+resource+Locators.CLOSING_BRACKET+Locators.UPDATE_KEY_PART1, "xpath");
		this.page.element(Locators.UPDATE_KEY+resource+Locators.CLOSING_BRACKET+Locators.UPDATE_KEY_PART1, "xpath").clickUsingJSE();
		return this;
	}

	public RegionDefault verifyWebNotificationIsNotReceived() throws Exception {
		waitForElement.waitForElements("dt.othr", "css");
		assertFalse(this.page.element("dt.othr", "css").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL),"Web notification frame is availble");
		assertFalse(this.page.element(Locators.WEB_NOTIFICATION_FRAME, "id").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL),"Web notification frame is availble");
		return this;
	}

	public RegionDefault verifyUsernameAtFooter(String username, String userFullname, String adminUsername) throws Exception {
		waitForElement.waitForElements(Locators.FOOTER_RIGHT_SIDE_USENAME_DETAILS, "xpath");
		String usernameAtFooter = this.page.element(Locators.FOOTER_RIGHT_SIDE_USENAME_DETAILS, "xpath").getDisplayedOne().getText();
		System.out.println(usernameAtFooter);
		String footerData = userFullname + " (" + adminUsername + " as " + username + ")";
		assertTrue(usernameAtFooter.contains(footerData));
		return this;
	}
	
	public RegionDefault verifyRegionName_AccessToMultipleRegions(String _regionName) throws Exception {
		waitForElement.waitForElements(Locators.REGION_NAME_2 + _regionName + Locators.CLOSING_BRACES, "xpath");
		assertTrue(this.page.element(Locators.REGION_NAME_2 + _regionName + Locators.CLOSING_BRACES, "xpath").isElementPresent());
		return this;
	}
	
	public RegionDefault verifyUsernameAtFooter(String username, String userFullname) throws Exception {
		waitForElement.waitForElements(Locators.FOOTER_RIGHT_SIDE_USENAME_DETAILS, "xpath");
		String usernameAtFooter = this.page.element(Locators.FOOTER_RIGHT_SIDE_USENAME_DETAILS, "xpath").getDisplayedOne().getText();
		System.out.println(usernameAtFooter);
		String footerData = userFullname + " (" + username + ")";System.out.println(footerData);
		assertTrue(usernameAtFooter.contains(footerData), usernameAtFooter + "does not contains " + footerData);
		return this;
	}
	
	public RegionDefault switchToDefaultFrame() throws Exception {
		driver.switchTo().defaultContent();
		return this;
	}

}