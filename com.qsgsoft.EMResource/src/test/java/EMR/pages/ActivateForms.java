package EMR.pages;

import org.openqa.selenium.WebDriver;
import qaFramework.UserDefinedFunctions.WaitForElement;
import qaFramework.pageObject.PageObject;
import EMR.Locators.ActivateForms.Locators;

public class ActivateForms extends PageObject {
	WebDriver driver;
	WaitForElement waitForElement ;
	
	public ActivateForms(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		waitForElement = new WaitForElement(this.driver);
	}

	public ActivateForms clickOnSendForm(String form) throws Exception {
		waitForElement.waitForElements(Locators.SENDFORMPART1 + form + Locators.SENDFORMPART2, "xpath");
		this.page.element(Locators.SENDFORMPART1 + form + Locators.SENDFORMPART2, "xpath").getOne().click();
		return this;
	}
	
	public ActivateForms selectUserToFillOutForm(String user) throws Exception {
		String fillOutForm = Locators.FILLOUTFORMPART1 + user + Locators.CLOSINGBRACKETS;
		waitForElement.waitForElements(fillOutForm, "css");
		this.page.element(fillOutForm, "css").getOne().click();
		return this;
	}
	
	public ActivateForms clickOnActivateForm() throws Exception {
		waitForElement.waitForElements(Locators.ACTIVATEFORM, "css");
		this.page.element(Locators.ACTIVATEFORM, "css").getOne().click();
		return this;
	}
	
	public ActivateForms selectUserToFillOutAndActivate(String form,
			String formUserToFillOut) throws Exception {
		clickOnSendForm(form);
		selectUserToFillOutForm(formUserToFillOut);
		clickOnActivateForm();
		return this;
	}
	
	public ActivateForms clickOnFillForm(String form) throws Exception {
		waitForElement.waitForElements(Locators.FILLFORMPART1 + form + Locators.FILLFORMPART2, "xpath");
		this.page.element(Locators.FILLFORMPART1 + form + Locators.FILLFORMPART2, "xpath").getOne().click();
		return this;
	}
	
}
