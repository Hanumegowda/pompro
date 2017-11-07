package lib.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.*;
import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;

public class ApplicationUsageReportsMenu extends PageObject {
	WebDriver driver;
	WaitForElement objWaitForElement;
	private String ApplicationUsageReports = "//div[@id='topSubNav']/h1[text()='Application Usage Reports Menu']",
			NormalUsage = "//div[@id='mainContainer']//tbody//a[text()='Normal Usage']",
			ApplicationUsageReportNonAdministrative = "//div[@id='topSubNav']/h1[text()='Application Usage Report - Non-Administrative']",
			startDate = "//input [@id='StartDate'][@class='hasDatepicker']",
			endDate = "//input [@id='EndDate'][@class='hasDatepicker']",
			EndDateRequired = "//div//ul/li[text()='End date is required.']",
			StartDateRequired = "//div//ul/li[text()='Start date is required.']",
			StartDateMayNotBeLaterThanToday = "//div//ul/li[text()='Start date may not be later than today.']";

	public ApplicationUsageReportsMenu(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
	}
	
	/**********************************************************************************
	* Description : This function is to verify Application Usage Reports Page Is Displayed.
	* Date 		  : 15/May/2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ApplicationUsageReportsMenu verApplicationUsageReportsPageIsDisplayed()
			throws Exception {
		objWaitForElement.waitForElements(ApplicationUsageReports, "xpath");
		assertTrue(this.page.element(ApplicationUsageReports, "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on Normal Usage link.
	* Date 		  : 15/May/2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ApplicationUsageReportsMenu clickOnNormalUsage() throws Exception {
		objWaitForElement.waitForElements(NormalUsage, "xpath");
		this.page.element(NormalUsage, "xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	* Description : This function is to verify 'Application Usage Report - Non-Administrative'
	*               page is displayed
	* Date 		  : 15/May/2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ApplicationUsageReportsMenu verApplicationUsageReportNonAdministrativePageIsDisplayed()
			throws Exception {
		objWaitForElement.waitForElements(
				ApplicationUsageReportNonAdministrative, "xpath");
		assertTrue(this.page.element(ApplicationUsageReportNonAdministrative,
				"xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter the text in 'Start Date' field.
	 * Date        : 15/May/2015 
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public ApplicationUsageReportsMenu enterStartDate(String strDate) throws Exception {
		objWaitForElement.waitForElements(startDate, "xpath");
		this.page.element(startDate, "xpath").clearInputValue().sendKeys(strDate);
		this.page.element(startDate, "xpath").getOne().sendKeys(Keys.ENTER);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter the text in 'End Date' field.
	 * Date        : 15/May/2015 
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public ApplicationUsageReportsMenu enterEndDate(String strDate) throws Exception {
		objWaitForElement.waitForElements(endDate, "xpath");
		this.page.element(endDate, "xpath").clearInputValue().sendKeys(strDate);
		this.page.element(endDate, "xpath").getOne().sendKeys(Keys.ENTER);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'End Date Required' Error Msg is displayed.
	* Date 		  : 18/May/2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ApplicationUsageReportsMenu verEndDateRequiredErrorMsg()
			throws Exception {
		objWaitForElement.waitForElements(EndDateRequired, "xpath");
		assertTrue(this.page.element(EndDateRequired, "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Start Date Required' Error Msg is displayed.
	* Date 		  : 19/May/2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ApplicationUsageReportsMenu verStartDateRequiredErrorMsg()
			throws Exception {
		objWaitForElement.waitForElements(StartDateRequired, "xpath");
		assertTrue(this.page.element(StartDateRequired, "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Start date may not be later than today' Error Msg is displayed.
	* Date 		  : 20/May/2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ApplicationUsageReportsMenu verStartDateMayNotBeLaterThanTodayErrorMsg()
			throws Exception {
		objWaitForElement.waitForElements(StartDateMayNotBeLaterThanToday,
				"xpath");
		assertTrue(this.page.element(StartDateMayNotBeLaterThanToday, "xpath")
				.isElementPresent());
		return this;
	}
}
