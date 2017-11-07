package lib.page;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;

public class SystemNotifications extends PageObject{

	WebDriver driver;
	WaitForElement objWaitForElement ;
	
	    //Locators
	    private String preferences = "//a[@class='mainLink'][text()='Preferences']";
		private String systemNotification = "//td/a[text()='System Notification']";
		private String expiredNotificationsEmail = "//td/span[text()='Expired Status Notifications']/parent::td/parent::tr/td/input[@name='emailInd']";
		private String expiredNotificationsPager = "//td/span[text()='Expired Status Notifications']/parent::td/parent::tr/td/input[@name='pagerInd']";
		private String statusPreferSaveButton = "input[value='Save'][type='submit']";
		private String expiredStatusWebNotification = "//td/span[text()='Expired Status Notifications']/parent::td/following-sibling::td[3]/input[@title='Web notification are not available'][@disabled]";	
		private String IPNEmail = "//td/span[text()='Incoming Patient Notifications']/parent::td/parent::tr/td/input[@name='emailInd']";
		private String IPNPager = "//td/span[text()='Incoming Patient Notifications']/parent::td/parent::tr/td/input[@name='pagerInd']";
		private String systemNotificationEmail = "//td/span[text()='System Notifications']/parent::td/parent::tr/td/input[@name='emailInd']";
		private String systemNotificationTextPager = "//td/span[text()='System Notifications']/parent::td/parent::tr/td/input[@name='pagerInd']";
		private String systemNotificationWebPage = "//td/span[text()='System Notifications']/parent::td/parent::tr/td/input[@name='webInd']";
	
	public SystemNotifications(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
	}

	  /**********************************************************************************
	   * Description : This function is to navigate to Status Preferences page
	   * Date        : 11/06/2014
	   * Author      : Anil
	   **********************************************************************************/
	public SystemNotifications navigateToStatusPreferences() throws Exception {
		objWaitForElement.waitForElements(preferences, "xpath");
		this.page.element(preferences, "xpath").getOne().click();
		objWaitForElement.waitForElements(systemNotification, "xpath");
		this.page.element(systemNotification, "xpath").getOne().click();
		return this;
	}
	
	  /**********************************************************************************
	   * Description : This function is to select Expired Notifications Email
	   * Date        : 11/06/2014
	   * Author      : Anil
	   **********************************************************************************/
	public SystemNotifications selectExpiredNotificationsEmail() throws Exception {
		objWaitForElement.waitForElements(expiredNotificationsEmail, "xpath");
		this.page.element(expiredNotificationsEmail, "xpath").getOne().click();
		return this;
	}
	
	  /**********************************************************************************
	   * Description : This function is to select Expired Notifications Pager
	   * Date        : 11/06/2014
	   * Author      : Anil
	   **********************************************************************************/
	public SystemNotifications selectExpiredNotificationsPager() throws Exception {
		objWaitForElement.waitForElements(expiredNotificationsPager, "xpath");
		this.page.element(expiredNotificationsPager, "xpath").getOne().click();
		return this;
	}
	
	  /**********************************************************************************
	   * Description : This function is to click on Save Button
	   * Date        : 11/06/2014
	   * Author      : Anil
	   **********************************************************************************/
	public SystemNotifications clickOnSaveButton() throws Exception {
		objWaitForElement.waitForElements(statusPreferSaveButton, "css");
		this.page.element(statusPreferSaveButton, "css").getOne().click();
		Thread.sleep(5000);  
		Alert alert = driver.switchTo().alert();
		  alert.accept();
		  Thread.sleep(5000); 
//		Actions action = new Actions(this.driver);
//		action.keyDown(Keys.CONTROL).sendKeys(Keys.ENTER).perform();
//		action.keyDown(Keys.ENTER).build().perform();	
		return this;
	}
	
	  /**********************************************************************************
	   * Description : This function is to select Notification Preferences and Save
	   * Date        : 11/06/2014
	   * Author      : Anil
	   **********************************************************************************/
	public SystemNotifications selectAndSaveExpiredStatusNotification() throws Exception {
		this.selectExpiredNotificationsEmail();
		this.selectExpiredNotificationsPager();
		this.clickOnSaveButton();
		Thread.sleep(8000);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Expired status notification for web is disabled
	 * Date        : 15/09/2014
	 * Author      : Anil
	 **********************************************************************************/
	public SystemNotifications verifyExpiredStatusWebNotificationDisabled() throws Exception {
		objWaitForElement.waitForElements(expiredStatusWebNotification, "xpath");
		assertTrue(this.page.element(expiredStatusWebNotification, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to select Notification Preferences and Save
	   * Date        : 18/sep/2014
	   * Author      : Anitha
	   **********************************************************************************/
	public SystemNotifications selectEmailIncomingPatientNotification()
			throws Exception {
		objWaitForElement.waitForElements(IPNEmail, "xpath");
		this.page.element(IPNEmail, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to select Notification Preferences and Save
	   * Date        : 18/sep/2014
	   * Author      : Anitha
	   **********************************************************************************/
	public SystemNotifications selectPagerIncomingPatientNotification()
			throws Exception {
		objWaitForElement.waitForElements(IPNPager, "xpath");
		this.page.element(IPNPager, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to deselect Notification Preferences and Save
	   * Date        : 27/sep/2014
	   * Author      : Sowmya
	   **********************************************************************************/
	public SystemNotifications deselectEmailIncomingPatientNotification()
			throws Exception {
		objWaitForElement.waitForElements(IPNEmail, "xpath");
		if(this.page.element(IPNEmail, "xpath").getOne().isSelected() == true){
		this.page.element(IPNEmail, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to select Email System Notifications CheckBox
	   * Date        : 22/sep/2015
	   * Author      : Sandhya
	   **********************************************************************************/
	public SystemNotifications selectEmailSystemNotificationChkBx()
			throws Exception {
		objWaitForElement.waitForElements(systemNotificationEmail, "xpath");
		this.page.element(systemNotificationEmail, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to select Text Pager System Notifications CheckBox
	   * Date        : 22/sep/2015
	   * Author      : Sandhya
	   **********************************************************************************/
	public SystemNotifications selectTextPagerSystemNotificationChkBx()
			throws Exception {
		objWaitForElement.waitForElements(systemNotificationTextPager, "xpath");
		this.page.element(systemNotificationTextPager, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to select WebPage System Notifications CheckBox
	   * Date        : 22/sep/2015
	   * Author      : Sandhya
	   **********************************************************************************/
	public SystemNotifications selectWebPageSystemNotificationChkBx()
			throws Exception {
		objWaitForElement.waitForElements(systemNotificationWebPage, "xpath");
		this.page.element(systemNotificationWebPage, "xpath").getOne().click();
		return this;
	}
}