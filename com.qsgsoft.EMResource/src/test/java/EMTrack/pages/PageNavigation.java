package EMTrack.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import EMTrack.Locators.DashBoard.Locators;
import qaFramework.UserDefinedFunctions.WaitForElement;
import qaFramework.pageObject.PageObject;

public class PageNavigation extends PageObject {
	WebDriver driver;
	WaitForElement waitForElement ;
	

	public PageNavigation(WebDriver _driver) throws Exception {
		super(_driver);
	this.driver=_driver;
	waitForElement = new WaitForElement(this.driver);
	}
	
	public PageNavigation navigateToPatientPage() throws Exception {
		waitForElement.waitForElements(Locators.PATIENT, "linktext");
		this.page.element(Locators.PATIENT, "linktext").getOne().click();
		boolean waitForPage = false;
		int count = 0;

		while (waitForPage == false && count <= 5) {
			waitForElement
					.waitForElements(Locators.ADDDAILYPATIENT, "linktext");
			count++;
			if (this.page.element(Locators.ADDDAILYPATIENT, "linktext")
					.isElementPresent()) {
				waitForPage = true;
			}
		}
		return this;
	}
	
	public PageNavigation patients() throws Exception {
		waitForElement.waitForElements(Locators.PATIENT, "linktext");
		try {
			this.page.element(Locators.PATIENT, "linktext").getOne().click();
			try{
				Alert alert = driver.switchTo().alert();
				alert.accept();
				if(this.page.element(EMTrack.Locators.Patient.Locators.PAGE_LOAD, "xpath").isElementPresent()==false){
					this.page.element(Locators.PATIENT, "linktext").clickUsingJSE();	
				}
			} catch(Exception e) {
				this.page.element(Locators.PATIENT, "linktext").getOne().click();
			}
		} catch(Exception e) {
			this.page.element(Locators.PATIENT, "linktext").getOne().click();
		}
		return this;
	}
}
