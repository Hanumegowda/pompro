package lib.page;

import static org.testng.Assert.*;

import org.openqa.selenium.WebDriver;

import qaframework.lib.WaitTimeConstants;
import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;

public class EventStatus extends PageObject {

	WebDriver driver;
	WaitForElement objWaitForElement;
	EventManagement objEventManagement;
	
	//Locators
	private String messageDisplayed = "//div[@id='viewContainer'][text()='Either there are no"
			+ " resources participating in this event, or you do not have viewing rights to any resources/status types involved in this event.']",
			eventStatus = "//div[@id='topSubNav']/h1[text()='Event Status']",
			errorMsg = "//div[@id='viewContainer'][text()='You do not have viewing rights to any resources participating in this event.']";
					
	public EventStatus(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objEventManagement = new EventManagement(this.driver);
		objWaitForElement = new WaitForElement(this.driver);
	}

	/**********************************************************************************
	  * Description : This function is to verify the message is displayed
	  * Date        : 10/06/2014
	  * Author      : Anil
	  **********************************************************************************/	
	public EventStatus verifyMessageDisplayed() throws Exception {
		objWaitForElement.waitForElements(messageDisplayed, "xpath");
		assertTrue(this.page.element(messageDisplayed, "xpath").getOne().isDisplayed());
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to verify the message is displayed
	  * Date        : 10/06/2014
	  * Author      : Anil
	  **********************************************************************************/	
	public EventStatus verifyEventStatus() throws Exception {
		objWaitForElement.waitForElements(eventStatus, "xpath");
		assertTrue(this.page.element(eventStatus, "xpath").getOne().isDisplayed());
		return this;
	}
	
	 /**********************************************************************************
	  * Description : This function is to verify the resource in event banner
	  * Date        : 08/Aug/2014
	  * Author      : Anitha
	  **********************************************************************************/	
	public EventStatus verifyResourceInEventBanner(String strResource)
			throws Exception {
		objWaitForElement.waitForElements("//table[starts-with(@id,'rtt')]/tbody/tr/td[2]/a[text()='"
				+ strResource + "']", "xpath");
		assertTrue(this.page
				.dynamicElement(
						"ResourceName",
						"//table[starts-with(@id,'rtt')]/tbody/tr/td[2]/a[text()='"
								+ strResource + "']", "xpath").getOne()
				.isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Resource Name' and 'Resource Type' 
	  * Arguments	: strResourceTypeName, strResourceTypeName
	  * Date        : 07/08/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public EventStatus verResourceTypeAndResourceName(String strResourceTypeName,
			String strResourceName) throws Exception {
		objWaitForElement.waitForElements("//div[@id='viewContainer']//table/thead/tr/th[2]/a[text()='"
				+ strResourceTypeName
				+ "']/ancestor::table/tbody/tr/td/a[text()='"
				+ strResourceName + "']", "xpath");
		assertTrue(this.page.element(
				"//div[@id='viewContainer']//table/thead/tr/th[2]/a[text()='"
						+ strResourceTypeName
						+ "']/ancestor::table/tbody/tr/td/a[text()='"
						+ strResourceName + "']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Status type'
	  * Arguments	: strResourceTypeName, strStatusTypeName
	  * Date        : 07/08/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public EventStatus verStatusTypes(String strResourceTypeName,
			String strStatusTypeName) throws Exception {
		objWaitForElement.waitForElements("//div[@id='viewContainer']//table/thead/tr/th[2]/a[text()='"
				+ strResourceTypeName
				+ "']/parent::th/following-sibling::th/a[text()='"
				+ strStatusTypeName + "']", "xpath");
		assertTrue(this.page.element(
				"//div[@id='viewContainer']//table/thead/tr/th[2]/a[text()='"
						+ strResourceTypeName
						+ "']/parent::th/following-sibling::th/a[text()='"
						+ strStatusTypeName + "']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Resource Name' and 'Resource Type' 
	  * Arguments	: strResourceTypeName, strResourceTypeName
	  * Date        : 07/08/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public EventStatus verResourceTypeAndResourceNameIsNotDisplayed(String strResourceTypeName,
			String strResourceName) throws Exception {
		assertFalse(this.page.element(
				"//div[@id='viewContainer']//table/thead/tr/th[2]/a[text()='"
						+ strResourceTypeName
						+ "']/ancestor::table/tbody/tr/td/a[text()='"
						+ strResourceName + "']", "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify the error message is displayed
	  * Date        : 14/08/2014
	  * Author      : Sowmya
	  **********************************************************************************/	
	public EventStatus verifyErrorMessageDisplayed() throws Exception {
		objWaitForElement.waitForElements(errorMsg, "xpath");
		assertTrue(this.page.element(errorMsg, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify the message is displayed
	  * Date        : 02/09/2014
	  * Author      : Renushree
	  **********************************************************************************/	
	public EventStatus verifyCreatedByDescAndAdd(String strUserFullName,
			String strDateAndTime, String strDesc, String strCity,
			String strCountry, String strZipCode, String strCountryCode) throws Exception {
		Date_Time_settings objDts = new Date_Time_settings();
		String[] str1 = strDateAndTime.split(" ");
		String str = objDts.converDateFormat(str1[0], "yyyy-mm-dd", "mm/dd/yy");
		String strDateAndTime1 = str + " " + str1[1];
		objWaitForElement.waitForElements("//div[contains(@style,'block;')]", "xpath");
		System.out.println(this.page.element("//div[contains(@style,'block;')]", "xpath")
						.getOne().getText());
		String strAppTime = objEventManagement.getApplicationTimeWithCSTCDT();
		String strApppTimeZone[] = strAppTime.split(" ");
		assertEquals("Created By: " + strUserFullName + " @ " + strDateAndTime1
				+ " "+strApppTimeZone[3]+"\n" + strDesc + " Location:  " + strCity + " "+strCountryCode+" "
				+ strZipCode + " " + strCountry,
				this.page.element("//div[contains(@style,'block;')]", "xpath")
						.getOne().getText());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify the message is displayed
	  * Date        : 03/09/2014
	  * Author      : Renushree
	  **********************************************************************************/	
	public EventStatus verifyCreatedByDesc(String strUserFullName,
			String strDateAndTime, String strDesc) throws Exception {
		Date_Time_settings objDts = new Date_Time_settings();
		String[] str1 = strDateAndTime.split(" ");
		String str = objDts.converDateFormat(str1[0], "yyyy-mm-dd", "mm/dd/yy");
		String strDateAndTime1 = str + " " + str1[1];
		objWaitForElement.waitForElements("//div[@style='display: block;']", "xpath");
		String strAppTime = objEventManagement.getApplicationTimeWithCSTCDT();
		String strApppTimeZone[] = strAppTime.split(" ");
		assertEquals("Created By: " + strUserFullName + " @ " + strDateAndTime1
				+ " "+strApppTimeZone[3]+"\n" + strDesc,
				this.page.element("//div[@style='display: block;']", "xpath")
						.getOne().getText());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify the message is displayed
	  * Date        : 10/06/2014
	  * Author      : Anil
	  **********************************************************************************/	
	public EventStatus clickOnUpdateStatusKey(String strResourceName) throws Exception {
		objWaitForElement.waitForElements("//table/tbody/tr/td/a[text()='" + strResourceName
				+ "']/ancestor::tr/td[1]/a/img", "xpath");
		this.page.element("//table/tbody/tr/td/a[text()='" + strResourceName
				+ "']/ancestor::tr/td[1]/a/img", "xpath").getOne().click();
		Thread.sleep(5000);
//		this.element.waitForPageToLoad(pageLoad);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Status type'
	  * Arguments	: strResourceTypeName, strStatusTypeName
	  * Date        : 28/11/2014
	  * Author      : Anil
	  **********************************************************************************/
	public EventStatus verStatusTypesInRows(String strResourceName,
			String strStatusTypeName) throws Exception {
		objWaitForElement.waitForElements("//div[@id='viewContainer']//table/tbody/tr/td[2]/a[text()='"+strResourceName+"']/parent::td/parent::tr/parent::tbody/tr/td[3]/a[text()='"+strStatusTypeName+"']", "xpath");
		assertTrue(this.page.element(
				"//div[@id='viewContainer']//table/tbody/tr/td[2]/a[text()='"+strResourceName+"']/parent::td/parent::tr/parent::tbody/tr/td[3]/a[text()='"+strStatusTypeName+"']", "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on resource name
	  * Arguments	: strResourceValue
	  * Date        : 10/12/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public EventStatus clickOnResource(String strResourceValue)
			throws Exception {
		objWaitForElement.waitForElements("a#r_" + strResourceValue + "", "css");
		this.page.element("a#r_" + strResourceValue + "", "css").getOne()
				.click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on back to view
	  * Date        : 10/12/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public EventStatus clickOnbackToView() throws Exception {
		objWaitForElement.waitForElements("back to view", "linktext");
		this.page.element("back to view", "linktext").getOne().click();
		return this;
	}
	/**********************************************************************************
	  * Description : This function is to click on show all statuses link
	  * Date        : 08/04/2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public EventStatus clickOnShowAllStatuses() throws Exception {
		objWaitForElement.waitForElements("//span[@class='selectionLink showAll']", "xpath");
		this.page.element("//span[@class='selectionLink showAll']", "xpath").getOne().click();
		return this;
	}
	
	
	/**********************************************************************************
	  * Description : This function is to verify updated time is displayed
	  * Date        : 14/08/2014
	  * Author      : Anil
	  **********************************************************************************/	
	public EventStatus verifyUpdatedTime(String strResourceName, String strUpdatedTime) throws Exception {
		objWaitForElement.waitForElements("//table/tbody/tr/td/a[text()='"+strResourceName+"']/parent::td/following-sibling::td[3][text()='"+strUpdatedTime+"']", "xpath");
		assertTrue(this.page.element("//table/tbody/tr/td/a[text()='"+strResourceName+"']/parent::td/following-sibling::td[3][text()='"+strUpdatedTime+"']", "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify updated time is displayed
	  * Date        : 14/08/2014
	  * Author      : Anil
	  **********************************************************************************/	
	public EventStatus verifyUpdatedUserFullName(String strResourceName, String strFulName) throws Exception {
		objWaitForElement.waitForElements("//table/tbody/tr/td/a[text()='"+strResourceName+"']/parent::td/following-sibling::td[4][text()='"+strFulName+"']", "xpath");
		assertTrue(this.page.element("//table/tbody/tr/td/a[text()='"+strResourceName+"']/parent::td/following-sibling::td[4][text()='"+strFulName+"']", "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify updated comment is displayed
	  * Date        : 14/08/2014
	  * Author      : Anil
	  **********************************************************************************/	
	public EventStatus verifyUpdatedComments(String strResourceName, String strComments) throws Exception {
		objWaitForElement.waitForElements("//table/tbody/tr/td/a[text()='"+strResourceName+"']/parent::td/following-sibling::td[2][text()='"+strComments+"']", "xpath");
		assertTrue(this.page.element("//table/tbody/tr/td/a[text()='"+strResourceName+"']/parent::td/following-sibling::td[2][text()='"+strComments+"']", "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Status type' in not displayed
	  * Arguments	: strResourceTypeName, strStatusTypeName
	  * Date        : 28/May/2015
	  * Author      : Rensuhree
	  **********************************************************************************/
	public EventStatus verStatusTypeNotPresent(String strResourceTypeName,
			String strStatusTypeName) throws Exception {
		assertFalse(this.page.element(
				"//div[@id='viewContainer']//table/thead/tr/th[2]/a[text()='"
						+ strResourceTypeName
						+ "']/parent::th/following-sibling::th/a[text()='"
						+ strStatusTypeName + "']", "xpath").isElementPresent(
				WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify updated comment is displayed
	  * Date        : 29/May/2015
	  * Author      : Rensuhree
	  **********************************************************************************/	
	public EventStatus verifyUpdatedStatus(String strResourceName,
			String strStatuses) throws Exception {
		objWaitForElement.waitForElements("//table/tbody/tr/td/a[text()='"
				+ strResourceName
				+ "']/parent::td/following-sibling::td[text()='"
				+ strStatuses + "']", "xpath");
		assertTrue(this.page
				.element(
						"//table/tbody/tr/td/a[text()='"
								+ strResourceName
								+ "']/parent::td/following-sibling::td[text()='"
								+ strStatuses + "']", "xpath").getOne()
				.isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Resource Name' not dispalyed in event status
	  * Arguments	: strResourceName
	  * Date        : 02/Jul/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public EventStatus verResourceNameIsNotDisplayed(String strResourceName)
			throws Exception {
		assertFalse(this.page.element(
				"//div[@id='viewContainer']//table/tbody/tr/td/a[text()='"
						+ strResourceName + "']", "xpath").isElementPresent(
				WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to verify address is not displayed under Event Banner
	  * 			   when we click on Event Banner
	  * Date        : 08-Sept-2015
	  * Author      : Pallavi
	  **********************************************************************************/	
	public EventStatus verifyAddressIsNotDisplayedInEventBanner(String strCity,
			String strCountry, String strZipCode, String strCountrycode)
			throws Exception {
		objWaitForElement.waitForElements("//div[contains(@style,'block;')]",
				"xpath");
		String strEveBannerDetails = this.page
				.element("//div[contains(@style,'block;')]", "xpath").getOne()
				.getText();
		assertFalse(strEveBannerDetails.contains(strCity ));
		assertFalse(strEveBannerDetails.contains(strCountrycode));
		assertFalse(strEveBannerDetails.contains(strZipCode ));
		assertFalse(strEveBannerDetails.contains(strCountry ));
		
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Resource Name' and 'Resource Type' are not present
	  * Arguments	: strResourceTypeName, strResourceTypeName
	  * Date        : 06-Oct-2016
	  * Author      : Pallavi
	  **********************************************************************************/
	public EventStatus verifyResourceTypeAndResourceNameIsNotDisplayed(String strResourceTypeName,
			String strResourceName) throws Exception {
		String RT_Element = "//div[@id='viewContainer']//table/thead/tr/th[2]/a[text()='" + strResourceTypeName + "']";
		String res_element = "/ancestor::table/tbody/tr/td/a[text()='" + strResourceName + "']";
		try{
			assertFalse(this.page.element(RT_Element + res_element, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		} catch(Exception e){
			assertFalse(this.page.element(RT_Element, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		}
		return this;
	}
}