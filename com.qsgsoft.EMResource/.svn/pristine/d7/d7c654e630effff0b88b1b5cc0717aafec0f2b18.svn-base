package EMR.pages;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import EMR.Locators.ConfigureIncomingPatientNotifications.Locators;
import qaFramework.WaitTimeConstants;
import qaFramework.UserDefinedFunctions.WaitForElement;
import qaFramework.pageObject.PageObject;

public class ConfigureIncomingPatientNotifications extends PageObject{
	
	WaitForElement waitForElement;
	WebDriverWait wait;
	
	public ConfigureIncomingPatientNotifications(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		waitForElement = new WaitForElement(this.driver);
		wait = new WebDriverWait(this.driver, WaitTimeConstants.WAIT_TIME_LONG);
	}

	public ConfigureIncomingPatientNotifications verifyAllowIPNIsEnabled()throws Exception {
		waitForElement.waitForElements(Locators.CONFIGURE_INCOMING_PATIENT_NOTIFICATIONS, "xpath");
		if(this.page.element(Locators.ENABLED_CHECKBOX, "css").getOne().isSelected() == false) {
			this.page.element(Locators.ENABLED_CHECKBOX, "css").getOne().sendKeys(Keys.SPACE);
			assertTrue(this.page.element(Locators.ENABLED_CHECKBOX, "css").getOne().isSelected());
		}
		if(this.page.element(Locators.ENABLED_CHECKBOX, "css").getOne().isSelected() == false) {
			this.page.element(Locators.ENABLED_CHECKBOX, "css").clickUsingJSE();
			assertTrue(this.page.element(Locators.ENABLED_CHECKBOX, "css").getOne().isSelected());
		}
		return this;
	}
	
	public ConfigureIncomingPatientNotifications verifyAllowManualEntryOfIPNIsSelected()throws Exception {
		waitForElement.waitForElements(Locators.CONFIGURE_INCOMING_PATIENT_NOTIFICATIONS, "xpath");
		if(this.page.element(Locators.ALLOW_MANUAL_ENTRY_CHECKBOX, "css").getOne().isSelected() == false){
			this.page.element(Locators.ALLOW_MANUAL_ENTRY_CHECKBOX, "css").getOne().sendKeys(Keys.SPACE);
			assertTrue(this.page.element(Locators.ALLOW_MANUAL_ENTRY_CHECKBOX, "css").getOne().isSelected());
		}
		if(this.page.element(Locators.ALLOW_MANUAL_ENTRY_CHECKBOX, "css").getOne().isSelected() == false){
			this.page.element(Locators.ALLOW_MANUAL_ENTRY_CHECKBOX, "css").clickUsingJSE();
			assertTrue(this.page.element(Locators.ALLOW_MANUAL_ENTRY_CHECKBOX, "css").getOne().isSelected());
		}
		return this;
	}
	
	public ConfigureIncomingPatientNotifications verifyAllowIPNEnabledIsNotSelected()throws Exception {
		waitForElement.waitForElements(Locators.CONFIGURE_INCOMING_PATIENT_NOTIFICATIONS, "xpath");
		if(this.page.element(Locators.ENABLED_CHECKBOX, "css").getOne().isSelected())
			{
			this.page.element(Locators.ENABLED_CHECKBOX, "css").getOne().sendKeys(Keys.SPACE);
			assertTrue(this.page.element(Locators.ENABLED_CHECKBOX, "css").getOne().isSelected()==false);
			}
		if(this.page.element(Locators.ENABLED_CHECKBOX, "css").getOne().isSelected())
		{
		this.page.element(Locators.ENABLED_CHECKBOX, "css").clickUsingJSE();
		assertTrue(this.page.element(Locators.ENABLED_CHECKBOX, "css").getOne().isSelected()==false);
		}
		return this;
	}
	
	public ConfigureIncomingPatientNotifications verifyAllowManualEntryOfIPNIsNotSelected()throws Exception {
		waitForElement.waitForElements(Locators.CONFIGURE_INCOMING_PATIENT_NOTIFICATIONS, "xpath");
		if(this.page.element(Locators.ALLOW_MANUAL_ENTRY_CHECKBOX, "css").getOne().isSelected())
		{
			this.page.element(Locators.ALLOW_MANUAL_ENTRY_CHECKBOX, "css").getOne().sendKeys(Keys.SPACE);
			assertTrue(this.page.element(Locators.ALLOW_MANUAL_ENTRY_CHECKBOX, "css").getOne().isSelected()==false);
		}
		if(this.page.element(Locators.ALLOW_MANUAL_ENTRY_CHECKBOX, "css").getOne().isSelected())
		{
			this.page.element(Locators.ALLOW_MANUAL_ENTRY_CHECKBOX, "css").clickUsingJSE();
			assertTrue(this.page.element(Locators.ALLOW_MANUAL_ENTRY_CHECKBOX, "css").getOne().isSelected()==false);
		}
		return this;
	}
	
	public ConfigureIncomingPatientNotifications clickOnSave() throws Exception {
		waitForElement.waitForElements(Locators.SAVE, "css");
		this.page.element(Locators.SAVE, "css").clickUsingJSE();
		return this;
	}
	
	public ConfigureIncomingPatientNotifications verifyAllowIPNEnabledAndAllowManualEntryOfIPNIsDeselected()throws Exception {
		this.verifyAllowIPNEnabledIsNotSelected();
		this.verifyAllowManualEntryOfIPNIsNotSelected();
		this.clickOnSave();
		return this;
	}
	
	public ConfigureIncomingPatientNotifications verifyAllowIPNEnabledAndAllowManualEntryOfIPNIsSelected()throws Exception {
		this.verifyAllowIPNIsEnabled();
		this.verifyAllowManualEntryOfIPNIsSelected();
		this.clickOnSave();
		return this;
	}
}
