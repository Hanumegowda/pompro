package lib.page;

import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;
import static org.testng.Assert.assertFalse;
import qaframework.lib.WaitTimeConstants;
import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;

public class FormSecurity extends PageObject {
	
	WebDriver driver;
	WaitForElement objWaitForElement;
	
	private String save = "input[value='Save']";
	
    public FormSecurity(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
	}

	/**********************************************************************************
	 * Description : This function is to click on 'Security' link corresponding to form template.
	 * Date 	   : 15/12/2014
	 * Author 	   : Pallavi
	 **********************************************************************************/
	public FormSecurity clickOnSecurityLink(String strFormTemplate)
			throws Exception {
		objWaitForElement.waitForElements("//td[2][text()='"
								+ strFormTemplate
								+ "']/preceding-sibling::td/a[text()='Security']",
						"xpath");
		this.page
				.element(
						"//td[2][text()='"
								+ strFormTemplate
								+ "']/preceding-sibling::td/a[text()='Security']",
						"xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select 'Activate Form' check box corresponding to user name.
	 * Date 	   : 15/12/2014
	 * Author 	   : Pallavi
	 **********************************************************************************/
	public FormSecurity selectActivateFormChkBox(String strUserName)
			throws Exception {
		String strChkBox = "//table[@id='tbl_userID']/tbody/tr/td[5][text()='"
							+ strUserName + "']/preceding-sibling::td[4]/input";
		objWaitForElement.waitForElements(strChkBox, "xpath");
		if (!(this.page.element(strChkBox, "xpath").getOne().isSelected())) {
			this.page.element(strChkBox, "xpath").getOne().click();
		}
		assertTrue(this.page.element(strChkBox, "xpath").getOne().isSelected());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Save' button.
	 * Date 	   : 15/12/2014
	 * Author 	   : Pallavi
	 **********************************************************************************/
	public FormSecurity clickOnSaveOfFormSecuritySetting()
			throws Exception {
		objWaitForElement.waitForElements(save, "css");
		this.page.element(save, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Security' link corresponding to form template.
	 * Date 	   : 15/12/2014
	 * Author 	   : Pallavi
	 **********************************************************************************/
	public FormSecurity clickOnSecurityLinkOfFirstForm()
			throws Exception {
		objWaitForElement.waitForElements(
				"//table[@class='displayTable striped border sortable']"
						+ "/tbody/tr[1]/td[1]/a[text()='Security']", "xpath");
		this.page
				.element(
						"//table[@class='displayTable striped border sortable']"
								+ "/tbody/tr[1]/td[1]/a[text()='Security']",
						"xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Create Ne
	 * w User' button
	 * Date        : 09/06/2014
	 * Author      : Anil
	 **********************************************************************************/
	public FormSecurity verRoleIsNotPresentInSearchDropDown(String strRoleName)
			throws Exception {
		assertFalse(this.page.element(
				"//select[@id='tbl_rUserID_ROLE']/option[text()='"
						+ strRoleName + "']", "xpath").isElementPresent(
				WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
}