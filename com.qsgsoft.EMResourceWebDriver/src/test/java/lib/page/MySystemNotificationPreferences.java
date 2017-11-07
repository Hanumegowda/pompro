package lib.page;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.*;
import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;

public class MySystemNotificationPreferences extends PageObject {

	WebDriver driver;
	WaitForElement objWaitForElement;
	
	private String headerName = "div#topSubNav > h1",
				   icsEmail = "input[name='emailInd'][value='ICS']",
				   icsPager = "input[name='pagerInd'][value='ICS']",
				   icsWeb = "input[name='webInd'][value='ICS']",
				   saveButton = "input[value='Save']";
			
	public MySystemNotificationPreferences(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
	}
	
	/**********************************************************************************
	  * Description : This function is to verify my system notification preference page is displayed
	  * Date        : 10/10/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public MySystemNotificationPreferences verMySystemNotPreferncePgeDisplayed()
			throws Exception {
		objWaitForElement.waitForElements(headerName, "css");
		assertEquals("My System Notification Preferences",
				this.page.element(headerName, "css").getOne().getText());
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to select email checkbox for ics notifications
	  * Date        : 10/10/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public MySystemNotificationPreferences selEmailForICSNotifications()
			throws Exception {
		objWaitForElement.waitForElements(icsEmail, "css");
		if(this.page.element(icsEmail, "css").getOne().isSelected()==false){
		this.page.element(icsEmail, "css").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select pager checkbox for ics notifications
	  * Date        : 10/10/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public MySystemNotificationPreferences selPagerForICSNotifications()
			throws Exception {
		objWaitForElement.waitForElements(icsPager, "css");
		if(this.page.element(icsPager, "css").getOne().isSelected()==false){
		this.page.element(icsPager, "css").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select web checkbox for ics notifications
	  * Date        : 10/10/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public MySystemNotificationPreferences selWebForICSNotifications()
			throws Exception {
		objWaitForElement.waitForElements(icsWeb, "css");
		if(this.page.element(icsWeb, "css").getOne().isSelected()==false){
		this.page.element(icsWeb, "css").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select email, pager,web checkbox for ics notifications
	  * Date        : 10/10/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public MySystemNotificationPreferences selEmailPagerWebForICSNotifications()
			throws Exception {
		this.selEmailForICSNotifications();
		this.selPagerForICSNotifications();
		this.selWebForICSNotifications();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on save button
	  * Date        : 10/10/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public MySystemNotificationPreferences clickOnSaveButton() throws Exception {
		objWaitForElement.waitForElements(saveButton, "css");
		this.page.element(saveButton, "css").getOne().click();
		Thread.sleep(5000);  
		Alert alert = driver.switchTo().alert();
		  alert.accept();
		  Thread.sleep(5000); 
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify pager checkbox for ics notifications is selected
	  * Date        : 10/10/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public MySystemNotificationPreferences verPagerForICSNotificationsIsSelected()
			throws Exception {
		objWaitForElement.waitForElements(icsPager, "css");
		assertTrue(this.page.element(icsPager, "css").getOne().isSelected());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify email checkbox for ics notifications is selected
	  * Date        : 10/10/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public MySystemNotificationPreferences verEmailForICSNotificationsIsSelected()
			throws Exception {
		objWaitForElement.waitForElements(icsEmail, "css");
		assertTrue(this.page.element(icsEmail, "css").getOne().isSelected());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify web checkbox for ics notifications is selected
	  * Date        : 10/10/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public MySystemNotificationPreferences verWebForICSNotificationsIsSelected()
			throws Exception {
		objWaitForElement.waitForElements(icsWeb, "css");
		assertTrue(this.page.element(icsWeb, "css").getOne().isSelected());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify email, pager, web checkbox for ics notifications is selected
	  * Date        : 10/10/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public MySystemNotificationPreferences verEmailPagerWebForICSNotifications()
			throws Exception {
		this.verEmailForICSNotificationsIsSelected();
		this.verEmailForICSNotificationsIsSelected();
		this.verWebForICSNotificationsIsSelected();
		return this;
	}
}
