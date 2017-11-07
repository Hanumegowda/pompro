package lib.page;

import org.openqa.selenium.WebDriver;

import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;
import static org.testng.Assert.*;

public class SolutionsForHealthCareEnterprises extends PageObject {
	
	WebDriver driver;	
	WaitForElement objWaitForElement;
  public String  interMedixLogo=  "//a[@title='Back to Intermedix.com']/div[@class='minilogo']",
		          solutionpage="//h1/strong/span[text()='HEALTHCARE ENTERPRISES']/parent::strong/parent::h1",
		          solution="//a[text()='Solutions']",
		         clientLogin="//ul/li/a[text()='Login']",
		         contactUs="//ul/li/a[text()='Contact']";

	public SolutionsForHealthCareEnterprises(WebDriver _driver)
			throws Exception {
		super(_driver);
	this.driver = _driver;
	objWaitForElement = new WaitForElement(this.driver);
	}
	
	/**********************************************************************************
	* Description : This function is to verify Solutions for HEALTH CARE ENTERPRISES page 
	                after click on solution link at top right corner of the app
	* Date 		  : 23/Jun/2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public SolutionsForHealthCareEnterprises verSolutionsForHealthCareEnteprisesPage()
			throws Exception {
		objWaitForElement.waitForElements(solutionpage, "xpath");
		assertTrue(this.page.element(solutionpage , "xpath").isElementPresent());
		return this;
	}
		
	/**********************************************************************************
	* Description : This function is to verify  solutions option in Enteprises Page
	* Date 		  : 23/Jun/2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public SolutionsForHealthCareEnterprises verSolutionsOption()
			throws Exception {
		objWaitForElement.waitForElements(solution, "xpath");
		assertTrue(this.page.element(solution , "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify  Client login option in Enteprises Page
	* Date 		  : 23/Jun/2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public SolutionsForHealthCareEnterprises verClientLoginOption()
			throws Exception {
		objWaitForElement.waitForElements(clientLogin, "xpath");
		assertTrue(this.page.element(clientLogin , "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify contact us option in Enteprises Page
	* Date 		  : 23/Jun/2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public SolutionsForHealthCareEnterprises verContactUsOption()
			throws Exception {
		objWaitForElement.waitForElements(contactUs, "xpath");
		assertTrue(this.page.element(contactUs , "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify contact us option in Enteprises Page
	* Date 		  : 23/Jun/2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public SolutionsForHealthCareEnterprises verInterMedixLogo()
			throws Exception {
		objWaitForElement.waitForElements(interMedixLogo, "xpath");
		assertTrue(this.page.element(interMedixLogo , "xpath").isElementPresent());
		return this;
	}
	
	}


