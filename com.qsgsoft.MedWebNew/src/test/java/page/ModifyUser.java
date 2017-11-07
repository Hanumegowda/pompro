package page;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import qaframework.lib.pageObject.PageObject;
import qaframework.lib.userDefinedFunctions.WaitForElement;

public class ModifyUser extends PageObject {
	WebDriver driver;
	WaitForElement objWaitForElement;
	
	public String location = "//select[@name='location']",
			      expirePasswordNow = "//td[text()='Expire password now:']/..//input[@type='CHECKBOX'][@name='expirenow']",
			      selLocation = "//select[@name='location']//option[@selected='']";
	
	public ModifyUser(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement (this.driver);
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'modify user' page of corresponding user is displayed or not.
	  * Date        : 25-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public ModifyUser verModifyUserPage(String username) throws Exception {
		String str = "//div[text()='Modify user "+username+"']";
		objWaitForElement.waitForElements(str, "xpath");
		assertTrue(this.page.element(str, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify required option is present in location dropdown.
	  * Date        : 25-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public ModifyUser selectLocation(String option)
			throws Exception {
		objWaitForElement
				.waitForElements(location, "xpath");
		this.page.element(location, "xpath").webElementToSelect().selectByVisibleText(option);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify required option is present in location dropdown.
	  * Date        : 25-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public boolean selectLocation()
			throws Exception {
		objWaitForElement
				.waitForElements(location, "xpath");
		try{
		this.page.element(location, "xpath").webElementToSelect().selectByIndex(2);
		return true;
		}
		catch(NoSuchElementException e){
			
		}
		return false;
	}
	
	/**********************************************************************************
	  * Description : This function is to get text of selected location.
	  * Date        : 25-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public String getSelectedLocation()
			throws Exception {
		objWaitForElement
				.waitForElements(selLocation, "xpath");
		String actual = this.page.element(selLocation, "xpath").getOne().getText();
		return actual;
	}
	
	/**********************************************************************************
	  * Description : This function is to select Expire password now checkbox.
	  * Date        : 31-Jul-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public ModifyUser selectExpirePasswordNowCheckbox()
			throws Exception {
		objWaitForElement
				.waitForElements(expirePasswordNow, "xpath");
		assertTrue(this.page.element(expirePasswordNow, "xpath").getOne().isSelected()==false);
		this.page.element(expirePasswordNow, "xpath").getOne().click();
		return this;
	}

}
