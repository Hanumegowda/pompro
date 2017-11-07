package lib.page;

import static org.testng.Assert.*;

import org.openqa.selenium.WebDriver;

import qaframework.lib.WaitTimeConstants;
import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;

public class FindResources extends PageObject {

	WebDriver driver;
	WaitForElement objWaitForElement;
	
	public String 	findResourcesPage = "//div[@id='topSubNav']/h1[text()='Find Resources']",
					searchResourceField = "searchName",
					createdStatuaTypesInList = "//table[@id='tbl_resourceID']/tbody/tr/",
					addToCustomView = "input[value='Add to Custom View']",
					search = "input[value='Search']";
	
	public FindResources(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
	}

	/**********************************************************************************
	  * Description : This function is to verify find resource screen is displayed.
	  * Date        : 15/Jun/2015
	  * Author      : Renushree
	  **********************************************************************************/	
	public FindResources verifyFindResourcePageDisplayed() throws Exception {
		objWaitForElement.waitForElements(findResourcesPage, "xpath");
		assertTrue(this.page.element(findResourcesPage, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to enter resource name to search.
	 * Arguments	: strResource
	 * Date 		: 15/Jun/2015
	 * Author       : Renushree
	 **********************************************************************************/
	public FindResources enterResNameInSearchField(String strResource)
			throws Exception {
		objWaitForElement.waitForElements(searchResourceField, "id");
		this.page.element(searchResourceField, "id").clearInputValue()
				.sendKeys(strResource);
		return this;
	}
	
	/**********************************************************************************
	 * Description  : This function is to verify resource names in list
	 * Arguments	: strResourceNames
	 * Date 		: 15/Jun/2015
	 * Author       : Renushree
	 **********************************************************************************/
	public FindResources verResourceNamesInList(String strResourceNames) throws Exception {
		objWaitForElement.waitForElements(createdStatuaTypesInList
				+ "/td[2][text()='"+strResourceNames+"']", "xpath");
		assertTrue(
				this.page.element(
						createdStatuaTypesInList
						+ "/td[2][text()='"+strResourceNames+"']", "xpath").isElementPresent(),
				"Resources not displayed.");
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify add to custom view button not displayed
	 * Date 		: 15/Jun/2015
	 * Author       : Renushree
	 **********************************************************************************/
	public FindResources verAddToCustomViewNotdisplayed() throws Exception {
		assertFalse(
				this.page.element(addToCustomView, "css").isElementPresent(
						WaitTimeConstants.WAIT_TIME_FOR_FALSE),
				"Add to custom view button displayed.");
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to click on search button
	 * Date 		: 15/Jun/2015  
	 * Author 		: Renushree
	 **********************************************************************************/
	public FindResources clickOnSearch() throws Exception {
		objWaitForElement.waitForElements(search, "css");
		this.page.element(search, "css").getOne().click();
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to verify error Message in find resource screen 
	  * Date        : 1/July/2015
	  * Author      : Anitha
	  **********************************************************************************/	
	public FindResources verifyErrorMsgInFindResourcePage() throws Exception {
		objWaitForElement
				.waitForElements(
						"//table/tbody/tr/td/h2[text()='No resources match your criteria...']",
						"xpath");
		assertTrue(this.page
				.element(
						"//table/tbody/tr/td/h2[text()='No resources match your criteria...']",
						"xpath").getOne().isDisplayed());
		return this;
	}
}
