package EMR.pages;

import org.openqa.selenium.WebDriver;
import EMR.Locators.IncomingPatientNotificationDetailsReport.Locators;
import qaFramework.UserDefinedFunctions.WaitForElement;
import qaFramework.pageObject.PageObject;
import static org.testng.Assert.*;
public class IncomingPatientNotificationDetailsReport extends PageObject {
	
	WebDriver driver;
	WaitForElement waitForElement ;
	
	public IncomingPatientNotificationDetailsReport(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		waitForElement = new WaitForElement(this.driver);
	}
		public IncomingPatientNotificationDetailsReport verifyIncomingPatientNotificationDeatailsReportPage() throws Exception {
			waitForElement.waitForElements(Locators.INCOMING_PATIENT_NOTIFICATION_DETAILS_REPORT, "xpath");
			assertTrue(this.page.element(Locators.INCOMING_PATIENT_NOTIFICATION_DETAILS_REPORT, "xpath").isElementPresent());
			return this;
		}
		public IncomingPatientNotificationDetailsReport enterStartDate(String startDate) throws Exception {
			waitForElement.waitForElements(Locators.START_DATE, "id");
			this.page.element(Locators.START_DATE, "id").clearInputValue().sendKeys(startDate);
			return this;
		}
			
		public IncomingPatientNotificationDetailsReport enterEndDate(String endDate) throws Exception {
			waitForElement.waitForElements(Locators.END_DATE, "id");
			this.page.element(Locators.END_DATE, "id").clearInputValue().sendKeys(endDate);
			return this;
		}
		
		public IncomingPatientNotificationDetailsReport clickGenerateReport() throws Exception {
			waitForElement.waitForElements(Locators.GENERATE_REPORT, "id");
			this.page.element(Locators.GENERATE_REPORT, "id").clickUsingJSE();
			return this;
		}
		
		public IncomingPatientNotificationDetailsReport enterIncomingPatientNotificationDetailsReport(String startDate,String endDate) throws Exception {
			this.enterStartDate(startDate);
			this.enterEndDate(endDate);
			this.clickGenerateReport();
			return this;
		}
		
	}
	
	


