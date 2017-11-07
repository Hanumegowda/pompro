package lib.module;

import org.openqa.selenium.WebDriver;

import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;

public class UserFunctions extends PageObject{

	WebDriver driver;
	WaitForElement objWaitForElement ;
	
	private String searchInputField = "tblUsers_SEARCH_TEXT",
		     	   searchButton = "input[id='tblUsers_SEARCH']";
	
	public UserFunctions(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement =  new WaitForElement(this.driver);
	}

	/**********************************************************************************
	 * Description : This function is to enter Username in 'Search' input field
	 * Date        : 17/06/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UserFunctions enterUsernameInSearchInputField(String strUsername)
			throws Exception {
		objWaitForElement.waitForElements(searchInputField, "id");
		this.page.element(searchInputField, "id").clearInputValue()
		.sendKeys(strUsername);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on 'Search' button
	 * Date        : 17/06/2014
	 * Author      : Sowmya
	 **********************************************************************************/

	public UserFunctions clickSearchButton() throws Exception {
		objWaitForElement.waitForElements(searchButton, "css");
		this.page.element(searchButton, "css").getOne().click();
		return this;
	}
}
