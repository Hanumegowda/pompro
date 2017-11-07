package lib.page;

import static org.testng.Assert.*;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import qaframework.lib.WaitTimeConstants;
import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;

public class DispatchForm extends PageObject{
	
	WebDriver driver;
	WaitForElement objWaitForElement ;
	private String dispatchForm = "input[value='Send Form']",
				   ResourceToRecCompletdFormHeader = "//td/h1[text()='Resources to Receive Completed Form']",
				   strDeleteForm="input[value='Delete Form']";

	public DispatchForm(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement =  new WaitForElement(this.driver);
	}

	/**********************************************************************************
	* Description : This function is to select user to receive completed form
	* Arguments   : strUserName
	* Date 		  : 15/12/2014
	* Author 	  : Renushree
	**********************************************************************************/
	public DispatchForm selUserToReceiveCompletedForm(String strUserName)
			throws Exception {
		objWaitForElement.waitForElements("input[name='userID'][value='"
				+ strUserName + "']", "css");
		this.page
				.element("input[name='userID'][value='" + strUserName + "']",
						"css").getOne().click();
		return this;
	}

	/**********************************************************************************
	* Description : This function is to verify Form title
	* Arguments   : strFormTitle
	* Date 		  : 15/12/2014
	* Author 	  : Renushree
	**********************************************************************************/
	public DispatchForm clickOnDispatchForm() throws Exception {
		objWaitForElement.waitForElements(dispatchForm, "css");
		this.page.element(dispatchForm, "css").getOne().click();
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to select resources check box
	  * Date        : 17/12/2014
	  * Author      : Anil
	  **********************************************************************************/
	public DispatchForm selectResourcesInDispatch(String strResourceName)
			throws Exception {
		objWaitForElement.waitForElements("//td[text()='" + strResourceName
				+ "']/preceding-sibling::td/input", "xpath");
		if (this.page
				.element(
						"//td[text()='" + strResourceName
								+ "']/preceding-sibling::td/input", "xpath")
				.getOne().isSelected() == false) {
			this.page
					.element(
							"//td[text()='" + strResourceName
									+ "']/preceding-sibling::td/input", "xpath")
					.getOne().click();
		}
		return this;
	}

	/**********************************************************************************
	* Description : This function is to verify dispatch form is not displayed
	* Arguments   : None
	* Date 		  : 13-Jan-2015
	* Author 	  : Deepa
	**********************************************************************************/
	public DispatchForm verDispatchFormIsNotDis() throws Exception {
		assertFalse(
				this.page.element(dispatchForm, "css").isElementPresent(
						WaitTimeConstants.WAIT_TIME_FOR_FALSE),
				"Dispatch Form is displayed");
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select user to receive completed form
	* Arguments   : strUserName
	* Date 		  : 15/12/2014
	* Author 	  : Renushree
	**********************************************************************************/
	public DispatchForm selUserToReceiveCompletedFormNew(String strUserName)
			throws Exception {
		objWaitForElement.waitForElements("input[name='userID'][value='" + strUserName + "']", "css");		
		this.page.element("input[name='userID'][value='" + strUserName + "']","css").mouseOver();
		this.page.element("input[name='userID'][value='" + strUserName + "']",
						"css").getOne().sendKeys(Keys.SPACE);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select resources check box
	  * Date        : 17/12/2014
	  * Author      : Anil
	  **********************************************************************************/
	public DispatchForm selectResourcesInDispatchNew(String strResourceName)
			throws Exception {
		objWaitForElement.waitForElements("//td[text()='" + strResourceName
				+ "']/preceding-sibling::td/input", "xpath");
		if (this.page
				.element(
						"//td[text()='" + strResourceName
								+ "']/preceding-sibling::td/input", "xpath")
				.getOne().isSelected() == false) {
		this.page.element(
					"//td[text()='" + strResourceName
							+ "']/preceding-sibling::td/input", "xpath")
			.mouseOver();
		this.page.element(
							"//td[text()='" + strResourceName
									+ "']/preceding-sibling::td/input", "xpath")
					.getOne().sendKeys(Keys.SPACE);
		}
		return this;
	}

	/**********************************************************************************
	* Description : This function is to verify user is displayed receive completed form
	* Arguments   : strUserName
	* Date 		  : 05/05/2015
	* Author 	  : Anil
	**********************************************************************************/
	public DispatchForm verifyUserIsDisplayedInReceiveCompletedForm(String strUserName)
			throws Exception {
		objWaitForElement.waitForElements("input[name='userID'][value='"
				+ strUserName + "']", "css");
		assertTrue(this.page
				.element("input[name='userID'][value='" + strUserName + "']",
						"css").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify user is not displayed receive completed form
	* Arguments   : strUserName
	* Date 		  : 05/05/2015
	* Author 	  : Anil
	**********************************************************************************/
	public DispatchForm verifyUserIsNotDisplayedInReceiveCompletedForm(String strUserName)
			throws Exception {
		assertFalse(this.page
				.element("input[name='userID'][value='" + strUserName + "']",
						"css").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}

	/**********************************************************************************
	* Description : This function is to verify that Resource sectiom is not displayed receive completed form
	* Arguments   : strResourceName
	* Date 		  : 12-May-2015
	* Author 	  : Pallavi
	**********************************************************************************/
	public DispatchForm verifyResourceSectionIsNotDisplayedInReceiveCompletedForm()
			throws Exception {
		assertFalse(this.page.element(ResourceToRecCompletdFormHeader, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	
	/**********************************************************************************
	* Description : This function is to Click on Delete Form
	* Arguments   : None
	* Date 		  : 11/2/2016
	* Author 	  : Sangappa K
	**********************************************************************************/
	public DispatchForm clickOnDeleteForm() throws Exception {
		objWaitForElement.waitForElements(strDeleteForm, "css");
		assertTrue(this.page.element(strDeleteForm, "css").isElementPresent());
		this.page.element(strDeleteForm, "css").getOne().click();
		return this;
	}
}
