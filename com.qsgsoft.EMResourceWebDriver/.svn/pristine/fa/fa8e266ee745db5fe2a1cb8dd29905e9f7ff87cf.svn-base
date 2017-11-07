package lib.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import static org.testng.Assert.*;
import static org.testng.AssertJUnit.assertTrue;
import qaframework.lib.WaitTimeConstants;
import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;

public class Regions extends PageObject {

	WebDriver driver;
	WaitForElement objWaitForElement;
	//Locators
	private String IPNCheckBox = "//span[text()='Incoming Patient Notifications']/preceding-sibling::input[1]";
	private String regionSaveButton = "input[value='Save']",
			       accountLinkingCheckbox = "//span[@title='Allow account linking']/preceding-sibling::input",
			       manageSysNotification = "input[value='Manage System Notification']",
			       activeChkbox = "input[name='activeFlag']",
			       header = "div#topSubNav>h1",
			       description = "textarea[name='description']",
			       title = "input[name='title']",
			       statusChangeNameTrace= "input[name='setup_option_id']",
			       headerName = "div#topSubNav > h1",
			       interFaceKey	= "input[name='interfaceKey']",
	    		   createRegion = "input[value='Create New Region']",
			       regionName = "input[name='regionName']",
			       timezone = "select[name='timeZone']",
			       firstName = "input[name='contactFirst']",
			       lastName = "input[name='contactLast']",
			       regionOrg = "input[name='contactOrg']",
			       regionContactAdd="textarea[name='contactAddr']",
			       regionPhone1="input[name='contactPhone1']",
			       regionPhone2="input[name='contactPhone2']",
			       regionFax="input[name='contactFax']",
			       regionEmail="input[name='contactEMail']",
			       regionDomain="input[name='customerDomain']",
			       frequencyAlert = "select[name='nagEmailFrequency']",
			       audioAlert="select[name='audioAlertFrequency']",
			       regionList = "//div[@id='topSubNav']/h1[text()='Region List']",
			       systemNoticeLink = "//a[@title='System Notice']",
			       InstantMessaging = "//span[text()='Instant Messaging']/preceding-sibling::input[1]",
			       strLastUpdate="//input[@value='80']",
			       strInterval1	= "//table[@summary='Data Input Form']/tbody/tr/td[@class='emsLabel'][text()='View Refresh Interval (minutes):']",
			       strInterval2="//table[@summary='Data Input Form']/tbody/tr/td[@class='emsLabel'][text()='View Refresh Interval (minutes):']/following-sibling::td/input[@type='text']",
			       lastUpdateYearsChkbox = "//span[@title='Include year in Last Update timestamp']/preceding-sibling::input[1]",
			       HoverText = "input[name='hoverText']",
			       regionCancelButton = "input[value='Cancel']",
			       accountLinking = "//span[text()='Account Linking']/preceding-sibling::input[1]",
			       iMWebSockets = "//span[text()='IM WebSockets']/preceding-sibling::input[1]",
			       instantMessaging = "//span[text()='Instant Messaging']/preceding-sibling::input[1]";

	
	public Regions(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
	}

	/**********************************************************************************
	  * Description : This function is to get Region value
	  * Date        : 09/06/2014
	  * Author      : Anil
	  **********************************************************************************/
	public String getRegionValue(String strRegionName) throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']"
				+ "/table/tbody/tr/td[2][text()='" + strRegionName
				+ "']/parent::" + "tr/td[1]/a", "xpath");
		String strRegionValue = this.page.dynamicElement(strRegionName, "//div[@id='mainContainer']"
				+ "/table/tbody/tr/td[2][text()='" + strRegionName
				+ "']/parent::" + "tr/td[1]/a", "xpath").getOne().getAttribute("href");
		
		String strResValueArr[] = strRegionValue.split("=");		
		strRegionValue = strResValueArr[4];
		return strRegionValue;
	}

	/**********************************************************************************
	  * Description : This function is to click on edit link of Region.
	  * Date        : 18/Sep/2014
	  * Author      : Anitha
	  **********************************************************************************/
	public Regions clickOnEditRegions(String strRegionName) throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table/tbody/"
				+ "tr/td[2][text()='" + strRegionName
				+ "']/parent::tr/" + "td[1]/a[text()='Edit']",
		"xpath");
		this.page
		.element(
				"//div[@id='mainContainer']/table/tbody/"
						+ "tr/td[2][text()='" + strRegionName
						+ "']/parent::tr/" + "td[1]/a[text()='Edit']",
				"xpath").mouseOver();
		this.page
				.element(
						"//div[@id='mainContainer']/table/tbody/"
								+ "tr/td[2][text()='" + strRegionName
								+ "']/parent::tr/" + "td[1]/a[text()='Edit']",
						"xpath").getOne().click();
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to deselect IPN checkbox
	 * Date        : 19/06/2014
	 * Author      : Yugender
	 **********************************************************************************/

	public Regions deselectIncomingPatientNotification() throws Exception {
		objWaitForElement.waitForElements(IPNCheckBox, "xpath");
		if (this.page.element(IPNCheckBox, "xpath").getOne().isSelected()) {
			this.page.element(IPNCheckBox, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select IPN checkbox
	 * Date        : 19/06/2014
	 * Author      : Yugender
	 **********************************************************************************/

	public Regions selectIncomingPatientNotification() throws Exception {
		objWaitForElement.waitForElements(IPNCheckBox, "xpath");
		if (this.page.element(IPNCheckBox, "xpath").getOne().isSelected()==false) {
			this.page.element(IPNCheckBox, "xpath").getOne().click();
		}
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on 'Save' button
	 * Date        : 09/06/2014
	 * Author      : Anil
	 **********************************************************************************/
	public Regions clickSaveButton() throws Exception {
		objWaitForElement.waitForElements(regionSaveButton, "css");
		this.page.element(regionSaveButton, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select Account linking checkbox
	 * Date        : 14/10/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public Regions selectAccountLinkingCheckbox() throws Exception {
		objWaitForElement.waitForElements(accountLinkingCheckbox, "xpath");
		if (this.page.element(accountLinkingCheckbox, "xpath").getOne()
				.isSelected() == false) {
			this.page.element(accountLinkingCheckbox, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'ManageSystemNotification' button
	 * Date        : 05/12/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public Regions clickManageSysNotification() throws Exception {
		objWaitForElement.waitForElements(manageSysNotification, "css");
		this.page.element(manageSysNotification, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select active check box
	 * Date        : 05/12/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public Regions selActivechkbox() throws Exception {
		objWaitForElement.waitForElements(activeChkbox, "css");
		if (this.page.element(activeChkbox, "css").getOne().isSelected()==false) {
			this.page.element(activeChkbox, "css").getOne().click();
		}		
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify edit system notification page is displayed
	 * Date        : 05/12/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public Regions verEditSystemNotificationPage() throws Exception {
		objWaitForElement.waitForElements("//div[@id='topSubNav']/h1[text()='Edit System Notification']", "xpath");
		assertTrue(this.page.element("//div[@id='topSubNav']/h1[text()='Edit System Notification']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to get description message
	 * Date        : 05/12/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public String getDescriptionMessage() throws Exception {
		objWaitForElement.waitForElements(description, "css");
		String strMessage = this.page.element(description, "css").getOne().getText();
		return strMessage;
	}
	
	/**********************************************************************************
	 * Description : This function is to get description message
	 * Date        : 05/12/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public String getTitleMessage() throws Exception {
		objWaitForElement.waitForElements(title, "css");
		String strMessage = this.page.element(title, "css").getOne().getText();
		return strMessage;
	}
	
	/**********************************************************************************
	 * Description : This function is to get region time zone
	 * Date        : 06/01/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public String getRegTimeZone(String strRegionName) throws Exception {
		String strTimeZone = "//div[@id='mainContainer']"
				+ "/table/tbody/tr/td[2][text()='" + strRegionName
				+ "']/following-sibling::td[1]";
		objWaitForElement.waitForElements(strTimeZone, "xpath");
		strTimeZone = this.page.element(strTimeZone, "xpath").getOne()
				.getText();
		return strTimeZone;
	}
	
	/**********************************************************************************
	 * Description : This function is to select Status Change Name Trace checkbox
	 * Date        : 18/May/2015
	 * Author      : Rensuhree
	 **********************************************************************************/

	public Regions selectStatusChangeNameTrace () throws Exception {
		objWaitForElement.waitForElements(statusChangeNameTrace, "css");
		if (this.page.element(statusChangeNameTrace, "css").getOne().isSelected()==false) {
			this.page.element(statusChangeNameTrace, "css").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Edit Region page is displayed
	  * Date        : 01/06/2014
	  * Author      : Anitha
	  **********************************************************************************/
	public Regions verEditRegiontPageIsDisplayed() throws Exception {
		objWaitForElement.waitForElements(headerName, "css");
		assertEquals("Edit Region", this.page.element(headerName, "css").getOne().getText(),
				"Edit Region page is not displayed.");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to provide InterfaceKey to region
	  * Date        : 01/06/2014
	  * Author      : Anitha
	  **********************************************************************************/
	public Regions provideInterfaceKeyForRegion(String strInterfaceKey) throws Exception {
		objWaitForElement.waitForElements(interFaceKey, "css");
		this.page.element(interFaceKey, "css").clearInputValue()
		.sendKeys(strInterfaceKey);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify verify InterFace Key Is Disabeled
	 * Date        : 01/06/2014
	 * Author      : Anitha
	 **********************************************************************************/
	public Regions verifyInterFaceKeyIsDisabeled(String strInterfaceKey)
			throws Exception {
		objWaitForElement.waitForElements(
				"input[disabled='disabled'][name='interfaceKey'][value='"
						+ strInterfaceKey + "']", "css");
		assertTrue(this.page
				.element(
						"input[disabled='disabled'][name='interfaceKey'][value='"
								+ strInterfaceKey + "']", "css").getOne()
				.isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Create New Region' button
	 * Date        : 01/Jun/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public Regions clickCreateNewRegionButton() throws Exception {
		objWaitForElement.waitForElements(createRegion, "css");
		this.page.element(createRegion, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify create new region page is dispalyed
	 * Date        : 01/Jun/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public Regions verCreateNewRegionPage() throws Exception {
		objWaitForElement.waitForElements("//div[@id='topSubNav']/h1[text()='Create New Region']", "xpath");
		assertTrue(this.page.element("//div[@id='topSubNav']/h1[text()='Create New Region']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify region list page is dispalyed
	 * Date        : 01/Jun/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public Regions verRegionListPage() throws Exception {
		objWaitForElement.waitForElements("//div[@id='topSubNav']/h1[text()='Region List']", "xpath");
		assertTrue(this.page.element("//div[@id='topSubNav']/h1[text()='Region List']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify edit system notification page is displayed
	 * Argument	   : strRegionName
	 * Date        : 01/Jun/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public Regions enterRegionName(String strRegionName) throws Exception {
		objWaitForElement.waitForElements(regionName, "css");

		this.page.element(regionName, "css").clearInputValue().sendKeys(strRegionName);

		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select time zone
	 * Argument	   : strTimeZone
	 * Date        : 01/Jun/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public Regions selectTimeZone(String strTimeZone) throws Exception {
		objWaitForElement.waitForElements(timezone, "css");
		this.page.element(timezone, "css").getOne().sendKeys(strTimeZone);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter first name
	 * Argument	   : strFirstName
	 * Date        : 01/Jun/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public Regions enterFirstName(String strFirstName) throws Exception {
		objWaitForElement.waitForElements(firstName, "css");
		this.page.element(firstName, "css").clearInputValue().sendKeys(strFirstName);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter last name
	 * Argument	   : strLastName
	 * Date        : 01/Jun/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public Regions enterLastName(String strLastName) throws Exception {
		objWaitForElement.waitForElements(lastName, "css");

		this.page.element(lastName, "css").clearInputValue()
		.sendKeys(strLastName);

		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify region in region list page
	 * Argument	   : strRegionName
	 * Date        : 01/Jun/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public Regions verRegionInRegionListPage(String strRegionName)
			throws Exception {
		objWaitForElement.waitForElements(
				"//div[@id='mainContainer']/table/tbody/" + "tr/td[2][text()='"
						+ strRegionName + "']", "xpath");
		assertTrue(this.page.element(
				"//div[@id='mainContainer']/table/tbody/" + "tr/td[2][text()='"
						+ strRegionName + "']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter region organization is displayed
	 * Date        : 01/Jun/2015
	 * Author      : Anitha
	 **********************************************************************************/
	public Regions enterRegionOrg(String strRegionOrg) throws Exception {
		objWaitForElement.waitForElements(regionOrg, "css");
		this.page.element(regionOrg, "css").clearInputValue().sendKeys(strRegionOrg);
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to enter region Contact Address 
	 * Date        : 01/Jun/2015
	 * Author      : Anitha
	 **********************************************************************************/
	public Regions enterRegionContactAdd(String strRegionAdd) throws Exception {
		objWaitForElement.waitForElements(regionContactAdd, "css");
		this.page.element(regionContactAdd, "css").clearInputValue().sendKeys(strRegionAdd);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter region Contact Address
	 * Date        : 01/Jun/2015
	 * Author      : Anitha
	 **********************************************************************************/
	public Regions enterRegionPhone1(String strRegionPhone1) throws Exception {
		objWaitForElement.waitForElements(regionPhone1, "css");
		this.page.element(regionPhone1, "css").clearInputValue().sendKeys(strRegionPhone1);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter region Contact Address
	 * Date        : 01/Jun/2015
	 * Author      : Anitha
	 **********************************************************************************/
	public Regions enterRegionPhone2(String strRegionPhone2) throws Exception {
		objWaitForElement.waitForElements(regionPhone2, "css");
		this.page.element(regionPhone2, "css").clearInputValue().sendKeys(strRegionPhone2);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter region Contact Address
	 * Date        : 01/Jun/2015
	 * Author      : Anitha
	 **********************************************************************************/
	public Regions enterRegionFax(String strRegionFax) throws Exception {
		objWaitForElement.waitForElements(regionFax, "css");
		this.page.element(regionFax, "css").clearInputValue().sendKeys(strRegionFax);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter region Email 
	 * Date        : 01/Jun/2015
	 * Author      : Anitha
	 **********************************************************************************/
	public Regions enterRegionEmail(String strRegionEmail) throws Exception {
		objWaitForElement.waitForElements(regionEmail, "css");
		this.page.element(regionEmail, "css").clearInputValue().sendKeys(strRegionEmail);
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to enter region Email 
	 * Date        : 01/Jun/2015
	 * Author      : Anitha
	 **********************************************************************************/
	public Regions enterRegionDomain(String strRegionDomain) throws Exception {
		objWaitForElement.waitForElements(regionDomain, "css");
		this.page.element(regionDomain, "css").clearInputValue().sendKeys(strRegionDomain);
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to select time zone
	 * Date        : 01/Jun/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public Regions selectFrequency(String strfrequencyAlert) throws Exception {
		objWaitForElement.waitForElements(frequencyAlert, "css");
		this.page.element(frequencyAlert, "css").getOne().sendKeys(strfrequencyAlert);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select time zone
	 * Date        : 01/Jun/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public Regions selectAudioAlert(String strAudioAlert) throws Exception {
		objWaitForElement.waitForElements(audioAlert, "css");
		this.page.element(audioAlert, "css").getOne().sendKeys(strAudioAlert);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify region in region list page
	 * Date        : 01/Jun/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public Regions verTimeZoneInRegionListPage(String strRegionName,
			String strTimeZone) throws Exception {
		objWaitForElement.waitForElements(
				"//div[@id='mainContainer']/table/tbody/tr/td[2][text()='"
						+ strRegionName + "']/following-sibling::td[text()='"
						+ strTimeZone + "']", "xpath");
		assertTrue(this.page.element(
				"//div[@id='mainContainer']/table/tbody/tr/td[2][text()='"
						+ strRegionName + "']/following-sibling::td[text()='"
						+ strTimeZone + "']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify region in region list page
	 * Date        : 01/Jun/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public Regions verDomainInRegionListPage(String strRegionName,
			String strDomainName) throws Exception {
		objWaitForElement.waitForElements(
				"//div[@id='mainContainer']/table/tbody/tr/td[2][text()='"
						+ strRegionName + "']/following-sibling::td[text()='"
						+ strDomainName + "']", "xpath");
		assertTrue(this.page.element(
				"//div[@id='mainContainer']/table/tbody/tr/td[2][text()='"
						+ strRegionName + "']/following-sibling::td[text()='"
						+ strDomainName + "']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify region in region list page
	 * Date        : 01/Jun/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public Regions verinterFaceKeyInRegionListPage(String strRegionName,
			String strInterfacekey)
			throws Exception {
		objWaitForElement.waitForElements(
				"//div[@id='mainContainer']/table/tbody/tr/td[2][text()='"
						+ strRegionName + "']/following-sibling::td[text()='"
						+ strInterfacekey + "']", "xpath");
		assertTrue(this.page.element(
				"//div[@id='mainContainer']/table/tbody/tr/td[2][text()='"
						+ strRegionName + "']/following-sibling::td[text()='"
						+ strInterfacekey + "']", "xpath").isElementPresent());
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify data is retained in edit region page
	 * Date        : 01/Jun/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public Regions verRegionDetailsAreRetained(String strRegionName, String strFN,
			String strLN, String strOrg, String strContactAdd,
			String strPhone1, String strPhone2, String strFax, String strEmail,
			String strDomain) throws Exception {
		
		objWaitForElement.waitForElements(regionName, "css");
		assertEquals(strRegionName, this.page.element(regionName, "css")
				.getOne().getAttribute("value"));
		assertEquals(strFN, this.page.element(firstName, "css").getOne()
				.getAttribute("value"));
		assertEquals(strLN, this.page.element(lastName, "css").getOne()
				.getAttribute("value"));
		assertEquals(strOrg, this.page.element(regionOrg, "css").getOne()
				.getAttribute("value"));
		assertEquals(strContactAdd,
				this.page.element(regionContactAdd, "css").getOne()
						.getAttribute("value"));
		assertEquals(strPhone1, this.page.element(regionPhone1, "css")
				.getOne().getAttribute("value"));
		assertEquals(strPhone2, this.page.element(regionPhone2, "css")
				.getOne().getAttribute("value"));
		assertEquals(strFax, this.page.element(regionFax, "css").getOne()
				.getAttribute("value"));
		assertEquals(strEmail, this.page.element(regionEmail, "css")
				.getOne().getAttribute("value"));
		assertEquals(strDomain, this.page.element(regionDomain, "css")
				.getOne().getAttribute("value"));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Region list is displayed
	  * Date        : 09/06/2014
	  * Author      : Anil
	  **********************************************************************************/
	public Regions verifyRegionListPage() throws Exception {
		objWaitForElement.waitForElements(regionList, "xpath");		
		assertTrue(this.page.element(regionList, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter title
	 * Date        : 05/12/2014
	 * Author      : Anil
	 **********************************************************************************/
	public Regions enterSystemNoticeTitle(String strTitle) throws Exception {
		objWaitForElement.waitForElements(title, "css");
		this.page.element(title, "css").clearInputValue().sendKeys(strTitle);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter description
	 * Date        : 05/12/2014
	 * Author      : Anil
	 **********************************************************************************/
	public Regions enterSystemNoticeDescription(String strDescription) throws Exception {
		objWaitForElement.waitForElements(description, "css");
		this.page.element(description, "css").clearInputValue().sendKeys(strDescription);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on edit link of Region.
	  * Date        : 18/Sep/2014
	  * Author      : Anitha
	  **********************************************************************************/
	public Regions clickOnSystemNoticeLink() throws Exception {
		objWaitForElement.waitForElements(systemNoticeLink,
		"xpath");
		this.page
				.element(systemNoticeLink,
						"xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify web notification Banner 
	 * Date : 10/06/2014 
	 * Author : Anil
	 **********************************************************************************/
	public Regions verifySystemNoticeTitleAndDescription(
			String strTitle, String strDescription) throws Exception {
		objWaitForElement.waitForElements("//h1[text()='"+strTitle+"']", "xpath");
		objWaitForElement.waitForElements("//p[text()='"+strDescription+"']", "xpath");
		assertTrue(this.page.element("//h1[text()='"+strTitle+"']", "xpath").getOne().isDisplayed());
		assertTrue(this.page.element("//p[text()='"+strDescription+"']", "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to deselect active check box
	 * Date        : 05/12/2014
	 * Author      : Anil
	 **********************************************************************************/
	public Regions deSelActivechkbox() throws Exception {
		objWaitForElement.waitForElements(activeChkbox, "css");
		if (this.page.element(activeChkbox, "css").getOne().isSelected()==true) {
			this.page.element(activeChkbox, "css").getOne().click();
		}		
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'System Notice' link is not displayed
	  * Date        : 01/Jun/2015
	  * Author      : Anil
	  **********************************************************************************/
	public Regions verifySystemNoticeLinkNotDisplayed() throws Exception {
		this.driver
		.manage()
		.timeouts()
		.implicitlyWait(WaitTimeConstants.WAIT_TIME_TOO_SMALL,
				TimeUnit.SECONDS);
		assertFalse(this.page.element(systemNoticeLink, "xpath").getOne().isDisplayed());
		return this;
	}
	
   /**********************************************************************************
    * Description : This function is to select Instant Messaging  checkbox.
	* Date        : 04-Jun-2015
	* Author      : Hanumegowda
	**********************************************************************************/
	public Regions selectInstantMessagingCheckbox() throws Exception {
		objWaitForElement.waitForElements(InstantMessaging, "xpath");
		if (this.page.element(InstantMessaging, "xpath").getOne().isSelected() == false) {
			this.page.element(accountLinkingCheckbox, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select active check box
	 * Date        : 28/08/2015
	 * Author      : Sowmya
	 **********************************************************************************/
	public Regions clickOnActivechkbox() throws Exception {
		objWaitForElement.waitForElements(activeChkbox, "css");
		this.page.element(activeChkbox, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to Last Update Years checkbox
	 * Date        : 05/10/2015
	 * Author      : Sangappa.k
	 **********************************************************************************/

	public Regions selectstrLastUpdateChkBox() throws Exception {
		objWaitForElement.waitForElements(strLastUpdate, "xpath");
		if (!this.page.element(strLastUpdate, "xpath").getOne().isSelected()) {
			this.page.element(strLastUpdate, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to Verify and entere "View Refresh Interval (minutes):"
	 * Date        : 05/10/2015
	 * Author      : Sangappa.k
	 **********************************************************************************/

	public Regions verAndEntereViewRefreshIntervalField(String strTExt)
			throws Exception {
		objWaitForElement.waitForElements(strInterval1, "xpath");
		assertTrue(this.page.element(strInterval1, "xpath").isElementPresent(),
				"View Refresh Interval (minutes): not exist in edit  region page");
		this.page.element(strInterval2, "xpath").clearInputValue()
				.sendKeys(strTExt);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to Verify and entered "View Refresh Interval (minutes):" value is retained
	 * Date        : 05/10/2015
	 * Author      : Sangappa.k
	 **********************************************************************************/
	public Regions verViewRefreshIntervalValueRetained(String strInterval)
			throws Exception {
		objWaitForElement.waitForElements(strInterval1, "xpath");
		assertTrue(this.page.element(strInterval1, "xpath").isElementPresent(),
				"View Refresh Interval (minutes): not exist in edit  region page");
		System.out.println(this.page.element(strInterval2, "xpath").getOne()
				.getAttribute("value"));
		assertTrue(this.page.element(strInterval2, "xpath").getOne()
				.getAttribute("value").equals(strInterval),
				"Entered Interval value is not retained");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to Verify and entere "View Refresh Interval (minutes):"
	 * Date        : 05/10/2015
	 * Author      : Sangappa.k
	 **********************************************************************************/

	public Regions verViewRefreshIntervalFieldIsNotPresnt()
			throws Exception {
		objWaitForElement.waitForElements(strInterval1, "xpath");
		assertFalse(this.page.element(strInterval1, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_TOO_SMALL),
				"View Refresh Interval (minutes): exist in edit  region page");
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify 'Last Update Years' check box option is available under 
	 *               'Available Options' section and is enabled.  
	 * Date        : 15/09/2015
	 * Author      : Sandhya M B
	 **********************************************************************************/
	public Regions verLastUpdateYearsChkboxIsPresentAndIsEnabled()
			throws Exception {
		objWaitForElement.waitForElements(lastUpdateYearsChkbox, "xpath");
		assertTrue(this.page.element(lastUpdateYearsChkbox, "xpath")
				.isElementPresent());

		objWaitForElement.waitForElements(lastUpdateYearsChkbox, "xpath");
		assertTrue(this.page.element(lastUpdateYearsChkbox, "xpath").getOne()
				.isEnabled());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter Hover Text
	  * Date        : 22/09/2015
	  * Author      : Sandhya
	  **********************************************************************************/
	public Regions enterSystemNoticeHoverText(String strHoverText)
			throws Exception {
		objWaitForElement.waitForElements(HoverText, "css");
		this.page.element(HoverText, "css").clearInputValue()
				.sendKeys(strHoverText);
		return this;
	}
	 
	 /**********************************************************************************
	  * Description : This function is to deselect and select active check box
	  * Date        : 22/09/2015
	  * Author      : Sandhya
	  **********************************************************************************/
	public Regions deselAndSelActivechkbox() throws Exception {
		objWaitForElement.waitForElements(activeChkbox, "css");
		if (this.page.element(activeChkbox, "css").getOne().isSelected() == false) {

			this.selActivechkbox();
			this.clickSaveButton();
		} else if (this.page.element(activeChkbox, "css").getOne().isSelected() == true) {
			this.deSelActivechkbox();
			this.clickSaveButton();
			this.clickManageSysNotification();
			this.selActivechkbox();
			this.clickSaveButton();
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify region is not present in region list page
	 * Argument	   : strRegionName
	 * Date        : 22-Feb2016
	 * Author      : Pallavi
	 **********************************************************************************/
	public Regions verRegionNotInRegionListPage(String strRegionName)
			throws Exception {
		objWaitForElement.waitForElements(
				"//div[@id='mainContainer']/table/tbody/" + "tr/td[2][text()='"
						+ strRegionName + "']", "xpath");
		assertFalse(this.page.element(
				"//div[@id='mainContainer']/table/tbody/" + "tr/td[2][text()='"
						+ strRegionName + "']", "xpath").isElementPresent(
				WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Cancel' button
	 * Date        : 22-Feb-2016
	 * Author      : Pallavi
	 **********************************************************************************/
	public Regions clickCancelButton() throws Exception {
		objWaitForElement.waitForElements(regionCancelButton, "css");
		this.page.element(regionCancelButton, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify IM websocket is not displayed
	 * Date        : 22-Feb-2016
	 * Author      : Anil
	 **********************************************************************************/
	public Regions verifyIMWebsocketsCheckBoxIsNotDisplayed() throws Exception {
		objWaitForElement.waitForElements(iMWebSockets, "xpath");
		assertFalse(this.page.element(iMWebSockets, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify account linking is not displayed
	 * Date        : 22-Feb-2016
	 * Author      : Anil
	 **********************************************************************************/
	public Regions verifyAccountLinkingCheckBoxIsNotDisplayed() throws Exception {
		objWaitForElement.waitForElements(accountLinking, "xpath");
		assertFalse(this.page.element(accountLinking, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify instant Messaging is not displayed
	 * Date        : 22-Feb-2016
	 * Author      : Anil
	 **********************************************************************************/
	public Regions verifyInstantMessagingCheckBoxIsNotDisplayed() throws Exception {
		objWaitForElement.waitForElements(instantMessaging, "xpath");
		assertFalse(this.page.element(instantMessaging, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify IM websocket is displayed
	 * Date        : 22-Feb-2016
	 * Author      : Anil
	 **********************************************************************************/
	public Regions verifyIMWebsocketsCheckBoxIsDisplayed() throws Exception {
		objWaitForElement.waitForElements(iMWebSockets, "xpath");
		assertTrue(this.page.element(iMWebSockets, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify account linking is displayed
	 * Date        : 22-Feb-2016
	 * Author      : Anil
	 **********************************************************************************/
	public Regions verifyAccountLinkingCheckBoxIsDisplayed() throws Exception {
		objWaitForElement.waitForElements(accountLinking, "xpath");
		assertTrue(this.page.element(accountLinking, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify instant Messaging is displayed
	 * Date        : 22-Feb-2016
	 * Author      : Anil
	 **********************************************************************************/
	public Regions verifyInstantMessagingCheckBoxIsDisplayed() throws Exception {
		objWaitForElement.waitForElements(instantMessaging, "xpath");
		assertTrue(this.page.element(instantMessaging, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to Verify and entere "View Refresh Interval (minutes):"
	 * Date        : 05/10/2015
	 * Author      : Sangappa.k
	 **********************************************************************************/

	public Regions entereViewRefreshIntervalField(String strTExt)
			throws Exception {
		objWaitForElement.waitForElements(strInterval1, "xpath");
		assertTrue(this.page.element(strInterval1, "xpath").isElementPresent(),
				"View Refresh Interval (minutes): not exist in edit  region page");
		this.page.element(strInterval2, "xpath").clearInputValue()
				.sendKeys(strTExt);
		return this;
	}
}