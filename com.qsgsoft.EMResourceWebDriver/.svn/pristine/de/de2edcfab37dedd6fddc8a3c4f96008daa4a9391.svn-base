package lib.page;

import static org.testng.Assert.*;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

import qaframework.lib.WaitTimeConstants;
import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;

public class ActivateForms extends PageObject{
	
	WebDriver driver;
	WaitForElement objWaitForElement;
	private String activateForm = "input[value='Activate Form']";

	public ActivateForms(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
	}
	
	/**********************************************************************************
	* Description : This function is to click on send form link
	* Arguments   : strForm
	* Date 		  : 15/12/2014
	* Author 	  : Renushree
	**********************************************************************************/
	public ActivateForms clickOnSendForm(String strForm) throws Exception {
		objWaitForElement.waitForElements("//table/tbody/tr/td[text()='"
				+ strForm + "']/preceding-sibling::td/a[text()='Send Form']",
				"xpath");
		this.page
				.element(
						"//table/tbody/tr/td[text()='"
								+ strForm
								+ "']/preceding-sibling::td/a[text()='Send Form']",
						"xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on send form link
	* Arguments   : strUserName
	* Date 		  : 15/12/2014
	* Author 	  : Renushree
	**********************************************************************************/
	public ActivateForms selUserToFillOutForm(String strUserName) throws Exception {
		objWaitForElement.waitForElements("input[name='fillUserID'][value='"+strUserName+"']",
						"css");
		this.page
				.element(
						"input[name='fillUserID'][value='"+strUserName+"']",
						"css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on Activate Form
	* Arguments   : None
	* Date 		  : 15/12/2014
	* Author 	  : Renushree
	**********************************************************************************/
	public ActivateForms clickOnActivateForm() throws Exception {
		objWaitForElement.waitForElements(activateForm, "css");
		this.page.element(activateForm, "css").getOne().click();
		return this;
	}
	
	
	/**********************************************************************************
	* Description : This function is to click on Resource check box
	* Arguments   : strResVal
	* Date 		  : 15/12/2014
	* Author 	  : Anil
	**********************************************************************************/
	public ActivateForms selResourceToFillOutForm(String strResVal)
			throws Exception {
		String strResourceCheckBox = "input[name='fillResourceID'][value='"
				+ strResVal + "']";
		objWaitForElement.waitForElements(strResourceCheckBox, "css");
		this.page.element(strResourceCheckBox, "css").getOne().click();
		return this;
	}

	/**********************************************************************************
	* Description : This function is to click on send form link
	* Arguments   : strForm
	* Date 		  : 15/12/2014
	* Author 	  : Renushree
	**********************************************************************************/
	public ActivateForms clickOnFillForm(String strForm) throws Exception {
		String strResourceCheckBox = "//table/tbody/tr/td[text()='" + strForm
				+ "']/preceding-sibling::td/a[text()='Fill Form']";
		objWaitForElement.waitForElements(strResourceCheckBox, "xpath");
		this.page.element(strResourceCheckBox, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on send form link
	* Arguments   : strForm
	* Date 		  : 15/12/2014
	* Author 	  : Renushree
	**********************************************************************************/
	public ActivateForms clickOnFillOut(String strForm) throws Exception {
		String strResourceCheckBox = "//table/tbody/tr/td[text()='" + strForm
				+ "']/preceding-sibling::td/a[text()='Fill Out']";
		objWaitForElement.waitForElements(strResourceCheckBox, "xpath");
		this.page.element(strResourceCheckBox, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on send form link
	* Arguments   : strForm
	* Date 		  : 15/12/2014
	* Author 	  : Anil
	**********************************************************************************/
	public ActivateForms verifyFillFormOption(String strForm) throws Exception {
		String strFillFormOption = "//table/tbody/tr/td[text()='" + strForm
				+ "']/preceding-sibling::td/a[text()='Fill Out']";
		objWaitForElement.waitForElements(strFillFormOption, "xpath");
		assertTrue(this.page.element(strFillFormOption, "xpath").getOne()
				.isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on send form link
	* Arguments   : strForm
	* Date 		  : 15/12/2014
	* Author 	  : Anil
	**********************************************************************************/
	public ActivateForms verifyDeleteOptionIsNotDisplayed(String strForm)
			throws Exception {
		String strDeleteFormOption = "//table/tbody/tr/td[text()='" + strForm
				+ "']/preceding-sibling::td/a[text()='delete']";
		assertFalse(this.page.element(strDeleteFormOption, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}

	/**********************************************************************************
	* Description : This function is to click on send form link
	* Arguments   : strForm
	* Date 		  : 15/12/2014
	* Author 	  : Anil
	**********************************************************************************/
	public ActivateForms verifyPendingForms(String strFormNumber)
			throws Exception {
		String strPendingFormCount = "//div[@id='alertForms']/a[contains(text(),'pending forms(')]/span[text()='"
				+ strFormNumber + "']";
		objWaitForElement.waitForElements(strPendingFormCount, "xpath");
		assertTrue(this.page.element(strPendingFormCount, "xpath").getOne()
				.isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify user to fill out form is displayed
	* Arguments   : strUserName
	* Date 		  : 15/12/2014
	* Author 	  : Anil
	**********************************************************************************/
	public ActivateForms verifyUserToFillOutForm(String strUserName) throws Exception {
		objWaitForElement.waitForElements("input[name='fillUserID'][value='"+strUserName+"']",
						"css");
		assertTrue(this.page
				.element(
						"input[name='fillUserID'][value='"+strUserName+"']",
						"css").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify user to fill out form is not displayed
	* Arguments   : strUserName
	* Date 		  : 15/12/2014
	* Author 	  : Anil
	**********************************************************************************/
	public ActivateForms verifyUserToFillOutFormIsNotDisplayed(String strUserName) throws Exception {
		assertFalse(this.page
				.element(
						"input[name='fillUserID'][value='"+strUserName+"']",
						"css").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on verify Fill Form is displayed
	* Arguments   : strForm
	* Date 		  : 15/12/2014
	* Author 	  : Anil
	**********************************************************************************/
	public ActivateForms verifyFillFormIsDisplayed(String strForm) throws Exception {
		String strResourceCheckBox = "//table/tbody/tr/td[text()='" + strForm
				+ "']/preceding-sibling::td/a[text()='Fill Form']";
		objWaitForElement.waitForElements(strResourceCheckBox, "xpath");
		assertTrue(this.page.element(strResourceCheckBox, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify resources to fill out form is displayed
	* Arguments   : strResourceName
	* Date 		  : 08/May/2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public ActivateForms verifyResourcesToFillOutForm(String strResourceName) throws Exception {
		String Res="//table[@id='tbl_fillResourceID']/tbody/tr/td[contains(text(),'"+strResourceName+"')]";
	    objWaitForElement.waitForElements(Res,"xpath");	
		assertTrue(this.page.element(Res, "xpath").getOne().isDisplayed());				
		return this;
	}	
	/**********************************************************************************
	* Description : This function is to verify resources to fill out form is not displayed
	* Arguments   : strResourceName
	* Date 		  : 08/May/2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public ActivateForms verifyResourcesToFillOutFormIsNotDisplaed(String strResourceName) throws Exception {
		String Res="//table[@id='tbl_fillResourceID']/tbody/tr/td[contains(text(),'"+strResourceName+"')]";
	    objWaitForElement.waitForElements(Res,"xpath");	
		assertFalse(this.page.element(Res, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));			
		return this;
	}	
	
	/**********************************************************************************
	* Description : This function is to click on Resource check box
	* Arguments   : strResVal
	* Date 		  : 15/12/2014
	* Author 	  : Sangappa K
	**********************************************************************************/
	public ActivateForms selResourceToFillOutFormInIE(String strResVal)
			throws Exception {
		String strResourceCheckBox ="//td[text()='"+strResVal+"']/preceding-sibling::td/input";
		objWaitForElement.waitForElements(strResourceCheckBox, "xpath");
		this.page.element(strResourceCheckBox, "xpath").getOne().click();
		if(!this.page.element(strResourceCheckBox, "xpath").getOne().isSelected())
		{
			this.page.element(strResourceCheckBox, "xpath").getOne().sendKeys(Keys.ENTER);
		}
		if(!this.page.element(strResourceCheckBox, "xpath").getOne().isSelected())
		{
			this.page.element(strResourceCheckBox, "xpath").getOne().sendKeys(Keys.SPACE);
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify configured  Form is not displayed under Activte forms page
	* Arguments   : strUserName
	* Date 		  : 10/2/2016
	* Author 	  : Sangappa K
	**********************************************************************************/
	public ActivateForms verifyFormIsNotAvailbaleUnderActivtFormsPage(String strForm) throws Exception {
		
		objWaitForElement.waitForElement("//h1[text()='Activate Forms']",
				"xpath");

		assertTrue(this.page.element("//h1[text()='Activate Forms']", "xpath")
				.isElementPresent());

		assertFalse(this.page.element(
				"//table/tbody/tr/td[text()='" + strForm
						+ "']/preceding-sibling::td/a[text()='Send Form']",
				"xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on send form link
	* Arguments   : strForm
	* Date 		  : 11/2/2015
	* Author 	  : Sangappa K
	**********************************************************************************/
	public ActivateForms verifyDeleteLink(String strForm)
			throws Exception {
		String strdelete = "//table/tbody/tr/td[text()='"+strForm+"']/preceding-sibling::td/a[text()='Delete']";
		objWaitForElement.waitForElements(strdelete, "xpath");
		assertTrue(this.page.element(strdelete, "xpath").getOne()
				.isDisplayed());
		return this;
	}

}
