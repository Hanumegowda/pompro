package EMR.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import qaFramework.UserDefinedFunctions.WaitForElement;
import qaFramework.pageObject.PageObject;
import EMR.Locators.Reports.Locators;

public class Reports extends PageObject {
		WebDriver driver;
		WaitForElement waitForElement ;

		public Reports(WebDriver _driver) throws Exception {
			super(_driver);
			this.driver = _driver;
			waitForElement = new WaitForElement(this.driver);
		}
		
		public Reports verifyIncomingPatientNotificationDeatailsReportPage() throws Exception {
			waitForElement.waitForElements(Locators.INCOMING_PATIENT_NOTIFICATION_DETAILS_REPORT, "xpath");
			assertTrue(this.page.element(Locators.INCOMING_PATIENT_NOTIFICATION_DETAILS_REPORT, "xpath").isElementPresent());
			return this;
		}
		public Reports enterStartDate(String startDate) throws Exception {
			waitForElement.waitForElements(Locators.START_DATE, "id");
			this.page.element(Locators.START_DATE, "id").clearInputValue().sendKeys(startDate);
			return this;
		}
			
		public Reports enterEndDate(String endDate) throws Exception {
			waitForElement.waitForElements(Locators.END_DATE, "id");
			this.page.element(Locators.END_DATE, "id").clearInputValue().sendKeys(endDate);
			return this;
		}
		
		public Reports clickGenerateReport() throws Exception {
			waitForElement.waitForElements(Locators.GENERATE_REPORT, "id");
			this.page.element(Locators.GENERATE_REPORT, "id").clickUsingJSE();
			return this;
		}
		
		public Reports enterStartDateAndEndDate(String startDate,String endDate) throws Exception {
			this.enterStartDate(startDate);
			this.enterEndDate(endDate);
			this.clickGenerateReport();
			return this;
		}
		
		public Reports verifyStatusReportMenu() throws Exception {
			waitForElement.waitForElements(Locators.STATUS_REPORT_MENU, "xpath");
			assertTrue(this.page.element(Locators.STATUS_REPORT_MENU, "xpath").isElementPresent());
			assertTrue(this.page.element(Locators.STATUS_REPORT_MENU, "xpath").getOne().isDisplayed());
			return this;
		}
		
		public Reports verifyStatusSummaryLink() throws Exception {
			waitForElement.waitForElements(Locators.STATUS_SUMMARY, "linktext");
			assertTrue(this.page.element(Locators.STATUS_SUMMARY, "linktext").isElementPresent());
			assertTrue(this.page.element(Locators.STATUS_SUMMARY, "linktext").getOne().isDisplayed());
			return this;
		}
}
