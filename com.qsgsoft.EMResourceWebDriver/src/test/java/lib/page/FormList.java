package lib.page;

import static org.testng.Assert.*;

import org.openqa.selenium.WebDriver;

import qaframework.lib.WaitTimeConstants;
import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;

public class FormList extends PageObject{
	
	WebDriver driver;
	
	WaitForElement objWaitForElement ;
	
	private String regionDefault = "//div[@id='topSubNav']/h1[text()='My Forms List']",
				   myInProgressFormsTitle = "//div[@id='mainContainer']/form/h1[1][text()='My Pending Forms']";
	
	public FormList(WebDriver _driver) throws Exception {
		super(_driver);
		// TODO Auto-generated constructor stub
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Form list page is displayed
	  * Date        : 14/01/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public FormList verifyFormListPage() throws Exception {
		objWaitForElement.waitForElements(regionDefault, "xpath");	
		assertTrue(this.page.element(regionDefault, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
  	* Description : This function is to verify form is not listed in pending forms
  	* Date 		  : 14/01/2015
  	* Author 	  : Renushree
  	**********************************************************************************/
	public FormList verFormNotListedUnderPendingForms(String strForm)
			throws Exception {
		assertFalse(
				this.page.element(
						"//table[@summary='Pending Forms']/tbody/tr/td[2][text()='"
								+ strForm + "']", "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE),
				"Form is listed in pending forms");
		return this;
	}
	
	/**********************************************************************************
  	* Description : This function is to verify form is listed in my recent forms
  	* Date 		  : 14/01/2015
  	* Author 	  : Renushree
  	**********************************************************************************/
	public FormList verFormListedUnderMyRecentForms(String strForm)
			throws Exception {
		objWaitForElement.waitForElements("//table[@summary='Recent Forms']/tbody/tr/td[2][text()='"
				+ strForm + "']", "xpath");
		assertTrue(
				this.page.element(
						"//table[@summary='Recent Forms']/tbody/tr/td[2][text()='"
								+ strForm + "']", "xpath").getOne().isDisplayed(),
				"Form is not listed in my recent forms");
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify My In Progress Forms title.
	* Date 		  : 15-Jan-2015
	* Author 	  : Pallavi
	**********************************************************************************/
	public FormList verifyMyInProgressFormsTitle() throws Exception {
		objWaitForElement.waitForElements(myInProgressFormsTitle, "xpath");
		assertTrue(this.page.element(myInProgressFormsTitle, "xpath")
				.getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify form is displayed under 'My In Progress Forms'.
	* Date 		  : 15-Jan-2015
	* Author 	  : Pallavi
	**********************************************************************************/
	public FormList verifyFormIsListedUnderMyInProgressForm(String strFormName)
			throws Exception {
		objWaitForElement.waitForElements("//h1[1][text()='My Pending Forms']/following-sibling::table/tbody/tr/td[2][text()='"
				+ strFormName + "']", "xpath");
		assertTrue(this.page
				.element(
						"//h1[1][text()='My Pending Forms']/following-sibling::table[@summary='Pending Forms']/tbody/tr/td[2][text()='"
								+ strFormName + "']", "xpath")
				.getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify form is displayed under 'My In Progress Forms'.
	* Date 		  : 15-Jan-2015
	* Author 	  : Renushree
	**********************************************************************************/
	public FormList verifyDispatchLinkInMyUnreviewedForms(String strFormName)
			throws Exception {
		objWaitForElement.waitForElements("//table[@summary='Unsent Forms']/tbody/tr/td[2][text()='"
				+ strFormName
				+ "']/preceding-sibling::td/a[text()='Send']",
		"xpath");
		assertTrue(this.page.element(
				"//table[@summary='Unsent Forms']/tbody/tr/td[2][text()='"
						+ strFormName
						+ "']/preceding-sibling::td/a[text()='Send']",
				"xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify form is displayed under 'My In Progress Forms'.
	* Date 		  : 15-Jan-2015
	* Author 	  : Renushree
	**********************************************************************************/
	public FormList verifFormInMyUnreviewedForms(String strFormName)
			throws Exception {
		objWaitForElement.waitForElements("//table[@summary='Unsent Forms']/tbody/tr/td[2][text()='"
				+ strFormName
				+ "']",
		"xpath");
		assertTrue(this.page.element(
				"//table[@summary='Unsent Forms']/tbody/tr/td[2][text()='"
						+ strFormName
						+ "']",
				"xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
  	* Description : This function is to verify form is not listed in pending forms
  	* Date 		  : 14/01/2015
  	* Author 	  : Renushree
  	**********************************************************************************/
	public FormList verFormListedUnderPendingForms(String strForm)
			throws Exception {
		objWaitForElement.waitForElements("//table[@summary='My Pending Forms']/tbody/tr/td[2][text()='"
				+ strForm + "']", "xpath");
		assertTrue(
				this.page.element(
						"//table[@summary='Pending Forms']/tbody/tr/td[2][text()='"
								+ strForm + "']", "xpath").getOne().isDisplayed(),
				"Form is Not listed in pending forms");
		return this;
	}
	
	/**********************************************************************************
  	* Description : This function is to verify form is not listed in pending forms
  	* Date 		  : 14/01/2015
  	* Author 	  : Anitha
  	**********************************************************************************/
	public FormList clickOnAckLinkInMyRecentForms(String strForm)
			throws Exception {
		objWaitForElement.waitForElementByxpathSelector("//table/tbody/tr/td[text()='"+ strForm+"']"
				+ "/preceding-sibling::td/a[text()='Acknowledgements']");
		this.page
				.element("//table/tbody/tr/td[text()='"+ strForm+"']"
								+ "/preceding-sibling::td/a[text()='Acknowledgements']",
						"xpath").getOne().click();

		return this;
	}
	
	/**********************************************************************************
  	* Description : This function is to verify form is not listed in pending forms
  	* Date 		  : 14/01/2015
  	* Author 	  : Anitha
  	**********************************************************************************/
	public FormList verifyDeliverDetailsInResAcknowledgeList(String strResource) throws Exception {
		objWaitForElement
				.waitForElementByxpathSelector("//table/thead/tr/th[1]/a[text()='Delivered To']");
		assertTrue(this.page.element(
				"//table/thead/tr/th[1]/a[text()='Delivered To']/ancestor::"
						+ "table/tbody/tr/td[text()='" + strResource + "']",
				"xpath").isElementPresent());

		return this;
	}

	/**********************************************************************************
  	* Description : This function is to verify form is not listed in pending forms
  	* Date 		  : 14/01/2015
  	* Author 	  : Anitha
  	**********************************************************************************/
	public FormList verifyAckByDetailsInResAcknowledgeList(String strUserFullName) throws Exception {
		objWaitForElement
				.waitForElementByxpathSelector("//table/thead/tr/th[2]/a[text()='Acknowledged By']");
		assertTrue(this.page.element(
				"//table/thead/tr/th[2]/a[text()='Acknowledged By']/ancestor::"
						+ "table/tbody/tr/td[text()='" + strUserFullName + "']",
				"xpath").isElementPresent());

		return this;
	}
	
	/**********************************************************************************
  	* Description : This function is to verify form is not listed in pending forms
  	* Date 		  : 14/01/2015
  	* Author 	  : Anitha
  	**********************************************************************************/
	public FormList verifyAckOnDetailsInResAcknowledgeList(String strTime) throws Exception {
		Date_Time_settings dts = new Date_Time_settings();
		String add1Min = dts.addTimetoExisting(strTime, 1, "yyyy-MM-dd HH:mm");
		String add2Min = dts.addTimetoExisting(strTime, 2, "yyyy-MM-dd HH:mm");
		String less1Min = dts.addTimetoExisting(strTime, 11, "yyyy-MM-dd HH:mm");
		objWaitForElement
				.waitForElementByxpathSelector("//table/thead/tr/th[3]/a[text()='Acknowledged On']");
		assertTrue(this.page.element(
				"//table/thead/tr/th[3]/a[text()='Acknowledged On']/ancestor::"
				+ "table/tbody/tr/td[text()='" + strTime + "']", "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE)|| this.page.element(
				"//table/thead/tr/th[3]/a[text()='Acknowledged On']/ancestor::"
				+ "table/tbody/tr/td[text()='" + add1Min + "']", "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE) || this.page.element(
				"//table/thead/tr/th[3]/a[text()='Acknowledged On']/ancestor::"
				+ "table/tbody/tr/td[text()='" + add2Min + "']", "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE) || this.page.element(
						"//table/thead/tr/th[3]/a[text()='Acknowledged On']/ancestor::"
								+ "table/tbody/tr/td[text()='" + less1Min + "']", "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));

		return this;
	}
	/**********************************************************************************
  	* Description : This function is to verify form is listed in My unsent forms
  	* Date 		  : 20/03/2015
  	* Author 	  : Hanumegowda
  	**********************************************************************************/
	public FormList verFormListedUnderMyUnsentForms(String strForm)
			throws Exception {
		objWaitForElement
		.waitForElements("//table/thead/tr/th[3]/a[text()='Acknowledged On']", "xpath");
		assertTrue(
				this.page.element(
						"//table[@summary='Unsent Forms']/tbody/tr/td[contains(text(),'" + strForm + "')]", "xpath").getOne().isDisplayed(),
				"Form is listed in my unsent forms");
		return this;
	}
	
	/**********************************************************************************
  	* Description : This function is to verify form is NOT listed in my recent forms
  	* Date 		  : 20-Apr-2015
  	* Author 	  : Pallavi
  	**********************************************************************************/
	public FormList verFormNOTListedUnderMyRecentForms(String strForm)
			throws Exception {
		assertFalse(this.page.element(
				"//table[@summary='Recent Forms']/tbody/tr/td[2][text()='"
						+ strForm + "']", "xpath").isElementPresent(
				WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify form is NOT displayed under 'My Unsent Forms'.
	* Date 		  : 20-Apr-2015
	* Author 	  : Pallavi
	**********************************************************************************/
	public FormList verFormNotListedUnderMyUnsentForms(String strFormName)
			throws Exception {
		assertFalse(this.page.element(
				"//table[@summary='Unsent Forms']/tbody/tr/td[2][text()='"
						+ strFormName + "']", "xpath").isElementPresent(
				WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}

	/**********************************************************************************
	* Description : This function is to verify 'EMResource Automated Scheduling System'
	* 				under 'Activated By' column under ‘My Recent Forms’ section.
	* Date 		  : 07-May-2015
	* Author 	  : Pallavi
	**********************************************************************************/
	public FormList verEMRAutomatedSchedulingSysUnderActivatedColumn(
			String strFormName) throws Exception {
		String strWebEle = "//table[@summary='Recent Forms']/tbody/tr/td[text()='"
				+ strFormName
				+ "']/following-sibling::td[2][text()='EMResource Automated Scheduling System']";
		objWaitForElement.waitForElements(strWebEle, "xpath");
		assertTrue(this.page.element(strWebEle, "xpath").isElementPresent());
		return this;
	}
}