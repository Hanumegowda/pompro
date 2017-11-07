package lib.page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import qaframework.lib.WaitTimeConstants;
import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;
import static org.junit.Assert.*;

public class MyEventNotificationPreferences extends PageObject {

	WebDriver driver;
	WaitForElement objWaitForElement;
	//Locators
	private String eventNotification = "Event Notification",
			saveButton = "input[value='Save']",
			textMessage= "//div[@class='smallLeftMarginLabel']",
			eventNotificationPref = "//div[@id='topSubNav']/h1[text()='My Event Notification Preferences']";

	
	public MyEventNotificationPreferences(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
	}

	/**********************************************************************************
	  * Description : This function is to click on 'Event Notification' link
	  * Date        : 31/07/2014
	  * Author      : Anil
	  **********************************************************************************/
	public MyEventNotificationPreferences clickOnEventNotification() throws Exception {
		objWaitForElement.waitForElements(eventNotification, "linktext");
		this.page.element(eventNotification, "linktext").getOne().click();
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to select Email notification for an event template
	  * Date        : 31/07/2014
	  * Author      : Anil
	  **********************************************************************************/
	public MyEventNotificationPreferences selectEmailNotification(String strTemplateName) throws Exception {	
		objWaitForElement.waitForElements( "//table/tbody/tr/td[1][text()='"+strTemplateName+"']/following-sibling::td[1]/input[@name='eMailInd']", "xpath");
		this.page.dynamicElement(strTemplateName, "//table/tbody/tr/td[1][text()='"+strTemplateName+"']/following-sibling::td[1]/input[@name='eMailInd']", "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select textPagerInd notification for an event template
	  * Date        : 31/07/2014
	  * Author      : Anil
	  **********************************************************************************/
	public MyEventNotificationPreferences selectTextPagerIndNotification(String strTemplateName) throws Exception {	
		objWaitForElement.waitForElements("//table/tbody/tr/td[1][text()='"+strTemplateName+"']/following-sibling::td[2]/input[@name='textPagerInd']", "xpath");
		this.page.dynamicElement(strTemplateName, "//table/tbody/tr/td[1][text()='"+strTemplateName+"']/following-sibling::td[2]/input[@name='textPagerInd']", "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select webInd notification for an event template
	  * Date        : 31/07/2014
	  * Author      : Anil
	  **********************************************************************************/
	public MyEventNotificationPreferences selectWebIndNotification(String strTemplateName) throws Exception {	
		objWaitForElement.waitForElements( "//table/tbody/tr/td[1][text()='"+strTemplateName+"']/following-sibling::td[3]/input[@name='webInd']", "xpath");
		this.page.dynamicElement(strTemplateName, "//table/tbody/tr/td[1][text()='"+strTemplateName+"']/following-sibling::td[3]/input[@name='webInd']", "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select myResourcesOnly notification for an event template
	  * Date        : 31/07/2014
	  * Author      : Anil
	  **********************************************************************************/
	public MyEventNotificationPreferences selectMyResourcesNotification(String strTemplateName) throws Exception {	
		objWaitForElement.waitForElements("//table/tbody/tr/td[1][text()='"+strTemplateName+"']/following-sibling::td[4]/input[@name='myResourcesOnly']", "xpath");
		this.page.dynamicElement(strTemplateName, "//table/tbody/tr/td[1][text()='"+strTemplateName+"']/following-sibling::td[4]/input[@name='myResourcesOnly']", "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select all notification for an event template
	  * Date        : 31/07/2014
	  * Author      : Anil
	  **********************************************************************************/
	public MyEventNotificationPreferences selectAllNotificationForEventTemplate(String strTemplateName) throws Exception {	
		this.selectMyResourcesNotification(strTemplateName);
		this.selectWebIndNotification(strTemplateName);
		this.selectTextPagerIndNotification(strTemplateName);
		this.selectEmailNotification(strTemplateName);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify myResourcesOnly notification for an event template
	  * Date        : 31/07/2014
	  * Author      : Anil
	  **********************************************************************************/
	public MyEventNotificationPreferences verifyMyResourcesNotification(String strTemplateName) throws Exception {	
		objWaitForElement.waitForElements("//table/tbody/tr/td[1][text()='"+strTemplateName+"']/following-sibling::td[4]/input[@name='myResourcesOnly']", "xpath");
		assertTrue(this.page.dynamicElement(strTemplateName, "//table/tbody/tr/td[1][text()='"+strTemplateName+"']/following-sibling::td[4]/input[@name='myResourcesOnly']", "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify web notification for an event template
	  * Date        : 31/07/2014
	  * Author      : Anil
	  **********************************************************************************/
	public MyEventNotificationPreferences verifytWebIndNotification(String strTemplateName) throws Exception {	
		objWaitForElement.waitForElements("//table/tbody/tr/td[1][text()='"+strTemplateName+"']/following-sibling::td[3]/input[@name='webInd']", "xpath");
		assertTrue(this.page.dynamicElement(strTemplateName, "//table/tbody/tr/td[1][text()='"+strTemplateName+"']/following-sibling::td[3]/input[@name='webInd']", "xpath").getOne().isDisplayed());
		return this;
	}
	
	
	/**********************************************************************************
	  * Description : This function is to verify TextPager notification for an event template
	  * Date        : 31/07/2014
	  * Author      : Anil
	  **********************************************************************************/
	public MyEventNotificationPreferences verifyTextPagerIndNotification(String strTemplateName) throws Exception {	
		objWaitForElement.waitForElements( "//table/tbody/tr/td[1][text()='"+strTemplateName+"']/following-sibling::td[2]/input[@name='textPagerInd']", "xpath");
		assertTrue(this.page.dynamicElement(strTemplateName, "//table/tbody/tr/td[1][text()='"+strTemplateName+"']/following-sibling::td[2]/input[@name='textPagerInd']", "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Email notification for an event template
	  * Date        : 31/07/2014
	  * Author      : Anil
	  **********************************************************************************/
	public MyEventNotificationPreferences verifyEmailNotification(String strTemplateName) throws Exception {
		objWaitForElement.waitForElements( "//table/tbody/tr/td[1][text()='"+strTemplateName+"']/following-sibling::td[1]/input[@name='eMailInd']", "xpath");
		assertTrue(this.page.dynamicElement(strTemplateName, "//table/tbody/tr/td[1][text()='"+strTemplateName+"']/following-sibling::td[1]/input[@name='eMailInd']", "xpath").getOne().isDisplayed());
		return this;
	}
	
	
	/**********************************************************************************
	  * Description : This function is to verify Email notification for an event template
	  * Date        : 31/07/2014
	  * Author      : Anil
	  **********************************************************************************/
	public MyEventNotificationPreferences verifyAllNotificationForEventTemplate(String strTemplateName) throws Exception {	
		this.verifyEmailNotification(strTemplateName);
		this.verifyMyResourcesNotification(strTemplateName);
		this.verifyTextPagerIndNotification(strTemplateName);
		this.verifytWebIndNotification(strTemplateName);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on save button
	  * Date        : 31/07/2014
	  * Author      : Anil
	  **********************************************************************************/
	public MyEventNotificationPreferences clickOnSaveButton() throws Exception {
		objWaitForElement.waitForElements(saveButton, "css");
		this.page.element(saveButton, "css").getOne().click();
		Thread.sleep(5000);  
		Alert alert = driver.switchTo().alert();
		  alert.accept();
		  Thread.sleep(5000); 
		return this;
	}
	
	
	/**********************************************************************************
	  * Description : This function is to verify text message displayed in MyEventNotificationPreferences page
	  * Date        : 31/07/2014
	  * Author      : Anil
	  **********************************************************************************/
	public MyEventNotificationPreferences verifyTextMessage() throws Exception {
		objWaitForElement.waitForElements(textMessage, "xpath");
		assertEquals(this.page.element(textMessage, "xpath").getOne().getText(),"*** Select this option if you want to limit notifications to those events that involve your resources. This option is not applicable to all types of events.");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify email notification not checked.
	  * Date        : 12/12/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public MyEventNotificationPreferences verEmailNotificationNotChecked(
			String strTemplateName) throws Exception {
		assertFalse(this.page
				.dynamicElement(
						strTemplateName,
						"//table/tbody/tr/td[1][text()='"
								+ strTemplateName
								+ "']/following-sibling::td[1]/input[@name='eMailInd']",
						"xpath").getOne().isSelected());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify textPagerInd notification not checked.
	  * Date        : 12/12/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public MyEventNotificationPreferences verTextPagerNotChecked(
			String strTemplateName) throws Exception {
		assertFalse(this.page
				.dynamicElement(
						strTemplateName,
						"//table/tbody/tr/td[1][text()='"
								+ strTemplateName
								+ "']/following-sibling::td[2]/input[@name='textPagerInd']",
						"xpath").getOne().isSelected());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select webInd notification for an event template
	  * Date        : 12/12/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public MyEventNotificationPreferences verWebNotificationNotChecked(
			String strTemplateName) throws Exception {
		assertFalse(this.page
				.dynamicElement(
						strTemplateName,
						"//table/tbody/tr/td[1][text()='"
								+ strTemplateName
								+ "']/following-sibling::td[3]/input[@name='webInd']",
						"xpath").getOne().isSelected());
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to verify 'My Event Notification Preferences' Page is displayed
	  * Date        : 29-Apr-2015
	  * Author      : Pallavi
	  **********************************************************************************/
	public MyEventNotificationPreferences verifyMyEventNotificationPrefPageIsDisp()
			throws Exception {
		objWaitForElement.waitForElements(eventNotificationPref, "xpath");
		assertTrue(this.page.element(eventNotificationPref, "xpath")
				.isElementPresent());
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to verify web notification is selected for an event template
	  * Date        : 29-Apr-2015
	  * Author      : Pallavi
	  **********************************************************************************/
	public MyEventNotificationPreferences verifytWebNotificationIsSelected(
			String strTemplateName) throws Exception {
		objWaitForElement.waitForElements("//table/tbody/tr/td[1][text()='"
				+ strTemplateName
				+ "']/following-sibling::td[3]/input[@name='webInd']", "xpath");
		assertTrue(this.page
				.element(
						"//table/tbody/tr/td[1][text()='"
								+ strTemplateName
								+ "']/following-sibling::td[3]/input[@name='webInd']",
						"xpath").getOne().isSelected());
		return this;
	}
	/**********************************************************************************
	  * Description : This function is to verify email notification is checked.
	  * Date        : 29/04/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public MyEventNotificationPreferences verEmailNotificationChecked(
			String strTemplateName) throws Exception {
		assertTrue(this.page
				.dynamicElement(
						strTemplateName,
						"//table/tbody/tr/td[1][text()='"
								+ strTemplateName
								+ "']/following-sibling::td[1]/input[@name='eMailInd']",
						"xpath").getOne().isSelected());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify textPagerInd notification is checked.
	  * Date        : 29/04/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public MyEventNotificationPreferences verTextPagerChecked(
			String strTemplateName) throws Exception {
		assertTrue(this.page
				.dynamicElement(
						strTemplateName,
						"//table/tbody/tr/td[1][text()='"
								+ strTemplateName
								+ "']/following-sibling::td[2]/input[@name='textPagerInd']",
						"xpath").getOne().isSelected());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify webInd notification for an event template is checked
	  * Date        : 29/04/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public MyEventNotificationPreferences verWebNotificationChecked(
			String strTemplateName) throws Exception {
		assertTrue(this.page
				.dynamicElement(
						strTemplateName,
						"//table/tbody/tr/td[1][text()='"
								+ strTemplateName
								+ "']/following-sibling::td[3]/input[@name='webInd']",
						"xpath").getOne().isSelected());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify event template is displayed.
	  * Date        : 29/04/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public MyEventNotificationPreferences verEveTemplateIsDisplayed(
			String strTemplateName) throws Exception {
		objWaitForElement.waitForElements("//table/tbody/tr/td[1][text()='"
				+ strTemplateName + "']", "xpath");
		assertTrue(this.page.dynamicElement(strTemplateName,
				"//table/tbody/tr/td[1][text()='" + strTemplateName + "']",
				"xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify event template is displayed.
	  * Date        : 29/04/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public MyEventNotificationPreferences verEveTemplateNotDisplayed(
			String strTemplateName) throws Exception {
		assertFalse(this.page.dynamicElement(strTemplateName,
				"//table/tbody/tr/td[1][text()='" + strTemplateName + "']",
				"xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to deselect textPagerInd notification for an event template
	  * Date        : 29/04/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public MyEventNotificationPreferences deselectPagerForEveTemplate(
			String strTemplateName) throws Exception {
		if (this.page
				.element(
						"//table/tbody/tr/td[1][text()='"
								+ strTemplateName
								+ "']/following-sibling::td[2]/input[@name='textPagerInd']",
						"xpath").getOne().isSelected() == true) {
			this.page
					.dynamicElement(
							strTemplateName,
							"//table/tbody/tr/td[1][text()='"
									+ strTemplateName
									+ "']/following-sibling::td[2]/input[@name='textPagerInd']",
							"xpath").getOne().click();
		}
		return this;
	}
	
	/********************************************************************************
	  * Description : This function is to check myResourcesOnly notification selected
	  * Date        : 09/Nov/2014
	  * Author      : Anitha
	  *******************************************************************************/
	public MyEventNotificationPreferences verMyResourcesOnlyChkBoxChecked(
			String strTemplateName) throws Exception {
		assertTrue(this.page
				.dynamicElement(
						strTemplateName,
						"//table/tbody/tr/td[1][text()='"
								+ strTemplateName
								+ "']/following-sibling::td[4]/input[@name='myResourcesOnly']",
						"xpath").getOne().isSelected());
		return this;
	}
}