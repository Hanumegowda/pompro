package lib.page;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;
import static org.testng.Assert.*;

public class StatusReasonList extends PageObject{
	WebDriver driver;
	WaitForElement objWaitForElement ;
	
	private String createStatusReason = "input[value='Create Status Reason']",
				   reasonName = "input[name='reasonName']",
				   description = "textarea[name='description']",
				   abbreviation = "input[name='abbreviation']",
				   save = "input[value='Save']",
				   displayReasonInCommentSection = "input[name='display']";
	
	public StatusReasonList(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
	}

	/**********************************************************************************
	  * Description : This function is to click on create status reason button
	  * Date        : 15/09/2014
	  * Author      : Renushree
	 **********************************************************************************/
	public StatusReasonList clickOnCreateStatusReason() throws Exception {
		objWaitForElement.waitForElements(createStatusReason, "css");
		this.page.element(createStatusReason, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter status reason name
	  * Arguments	: strReasonName
	  * Date        : 15/09/2014
	  * Author      : Renushree
	 **********************************************************************************/
	public StatusReasonList enterReasonName(String strReasonName) throws Exception {
		objWaitForElement.waitForElements(reasonName, "css");
		this.page.element(reasonName, "css").clearInputValue().sendKeys(strReasonName);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter status reason description
	  * Arguments	: strReasonDesc
	  * Date        : 15/09/2014
	  * Author      : Renushree
	 **********************************************************************************/
	public StatusReasonList enterReasonDesc(String strReasonDesc) throws Exception {
		objWaitForElement.waitForElements(description, "css");
		this.page.element(description, "css").clearInputValue().sendKeys(strReasonDesc);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter status reason abbreviation
	  * Arguments	: strReasonAbb
	  * Date        : 15/09/2014
	  * Author      : Renushree
	 **********************************************************************************/
	public StatusReasonList enterReasonAbb(String strReasonAbb) throws Exception {
		objWaitForElement.waitForElements(abbreviation, "css");
		this.page.element(abbreviation, "css").clearInputValue().sendKeys(strReasonAbb);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on save
	  * Date        : 15/09/2014
	  * Author      : Renushree
	 **********************************************************************************/
	public StatusReasonList clickOnSave() throws Exception {
		objWaitForElement.waitForElements(save, "css");
		this.page.element(save, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to create status reason
	  * Date        : 15/09/2014
	  * Author      : Renushree
	 **********************************************************************************/
	public StatusReasonList createStatusReason(String strReasonName,
			String strReasonDesc, String strReasonAbb) throws Exception {
		this.clickOnCreateStatusReason();
		this.enterReasonName(strReasonName);
		this.enterReasonDesc(strReasonDesc);
		this.enterReasonAbb(strReasonAbb);
		this.clickOnSave();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to create status reason
	  * Date        : 15/09/2014
	  * Author      : Renushree
	 **********************************************************************************/
	public String getStatusReasonVal(String strReasonName) throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']"
				+ "/table/tbody/tr/td[2][text()='"
				+ strReasonName + "']/parent::"
				+ "tr/td[1]/a", "xpath");
		String strReasonVal = this.page
				.element(
						"//div[@id='mainContainer']"
								+ "/table/tbody/tr/td[2][text()='"
								+ strReasonName + "']/parent::"
								+ "tr/td[1]/a", "xpath").getOne()
				.getAttribute("href");
		String[] strVal = strReasonVal.split("nextStepDetail=");
		return strVal[1];
	}
	
	/**********************************************************************************
	  * Description : This function is to click on edit link of status type.
	  * Date        : 27/05/2014
	  * Author      : Anitha
	  **********************************************************************************/
	public StatusReasonList clickOnEditStatusReason(String strStatusReason)
			throws Exception {
		objWaitForElement.waitForElements(
				"//div[@id='mainContainer']/table/tbody/tr/td[2][text()='"
						+ strStatusReason
						+ "']/preceding-sibling::td/a[text()='Edit']", "xpath");
		this.page
				.element(
						"//div[@id='mainContainer']/table/tbody/tr/td[2][text()='"
								+ strStatusReason
								+ "']/preceding-sibling::td/a[text()='Edit']",
						"xpath").getOne().sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify created status in list for particular MST.
	  * Date        : 27/05/2014
	  * Author      : Anitha
	  **********************************************************************************/
	public StatusReasonList verCreatedStatusReasonInList(String strStatusReason)
			throws Exception {
		objWaitForElement.waitForElements(
				"//div[@id='mainContainer']/table/tbody/tr/td[2][text()='"
						+ strStatusReason + "']", "xpath");
		assertTrue(
				this.page.element(
						"//div[@id='mainContainer']/table/tbody/tr/td[2][text()='"
								+ strStatusReason + "']", "xpath")
						.isElementPresent(), "Created Status Reason is not present.");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Display reason in comment section option is selected
	  * Date        : 27/May/2015
	  * Author      : Renushree
	 **********************************************************************************/
	public StatusReasonList verDisplayReasonInCommentSectionOptionSelected()
			throws Exception {
		objWaitForElement.waitForElements(displayReasonInCommentSection, "css");
		assertTrue(this.page.element(displayReasonInCommentSection, "css")
				.getOne().isSelected());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify status reason is listed in status reason list
	  * Arguments	: strStatusReason
	  * Date        : 27/May/2015
	  * Author      : Renushree
	 **********************************************************************************/
	public StatusReasonList verStatusReasonInList(String strStatusReason,
			String strAbbreviation, String strDescription) throws Exception {
		objWaitForElement.waitForElements(
				"//table[@summary='Status Reasons']/tbody/tr/td[2][text()='"
						+ strStatusReason + "']", "xpath");
		assertTrue(this.page.element(
				"//table[@summary='Status Reasons']/tbody/tr/td[2][text()='"
						+ strStatusReason
						+ "']/following-sibling::td[1][text()='"
						+ strAbbreviation
						+ "']/following-sibling::td[1][text()='"
						+ strDescription + "']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify status reason name is retained and field is disabled
	  * Arguments	: strReasonName
	  * Date        : 02/Jun/2015
	  * Author      : Renushree
	 **********************************************************************************/
	public StatusReasonList verReasonFieldIsDisabled(String strReasonName)
			throws Exception {
		objWaitForElement.waitForElements("input[name='reasonName'][value='"
				+ strReasonName + "'][disabled='disabled']", "css");
		assertTrue(this.page.element(
				"input[name='reasonName'][value='" + strReasonName
						+ "'][disabled='disabled']", "css").isElementPresent(), "Reason feild is not disabled.");
		return this;
	}
	
}
