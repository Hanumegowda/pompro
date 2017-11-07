package lib.module;

import org.openqa.selenium.WebDriver;
import static org.testng.Assert.*;
import qaframework.lib.WaitTimeConstants;
import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;

public class LinksAtTopRightCorners extends PageObject{
	
	WebDriver driver;
	WaitForElement objWaitForElement ;
	
	private String search = "Search",
				   showmap = "show map",
				   refresh = "refresh",
				   reloadingText = "//span[@id='reloadingText']",
				   solution="Solutions",
				   customize = "customize",
	               showtable = "show table",
	               print = "print",
	               export = "export",
	               help = "help";

	public LinksAtTopRightCorners(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement =  new WaitForElement(this.driver);
	}
	
	/**********************************************************************************
	* Description 	: This function is to click on search link at top right corner.
	* Date 			: 09/09/2014
	* Author 		: Renushree
	**********************************************************************************/
	public LinksAtTopRightCorners clickOnSearch() throws Exception {
		objWaitForElement.waitForElements(search, "linktext");
		this.page.element(search, "linktext").getOne().click();
		return this;
	}
	/**********************************************************************************
	* Description 	: This function is to click on Custom View at top right corner.
	* Date 			: 24/09/2014
	* Author 		: Prasanna Lakshmi
	**********************************************************************************/
	public LinksAtTopRightCorners clickOnShowMap() throws Exception {
		objWaitForElement.waitForElements(showmap, "linktext");
		this.page.element(showmap, "linktext").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to click on refresh link at top right corner.
	* Date 			: 21/10/2014
	* Author 		: Renushree
	**********************************************************************************/
	public LinksAtTopRightCorners clickOnRefresh() throws Exception {
		objWaitForElement.waitForElements(refresh, "linktext");
		this.page.element(refresh, "linktext").getOne().click();
		this.page.element_wait(reloadingText, "xpath").waitForInvisibilityOfElement();
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to click on solution  link at top right corner.
	* Date 			: 23/06/2015
	* Author 		: Sangappa.k
	**********************************************************************************/
	public LinksAtTopRightCorners clickOnSolutions() throws Exception {
		objWaitForElement.waitForElements(solution, "linktext");
		this.page.element(solution, "linktext").getOne().click();
		this.page.element_wait(solution, "linktext").waitForInvisibilityOfElement();
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to click on customize link at top right corner.
	* Date 			: 02/Jul/2015
	* Author 		: Renushree
	**********************************************************************************/
	public LinksAtTopRightCorners clickOnCustomize() throws Exception {
		objWaitForElement.waitForElements(customize, "linktext");
		this.page.element(customize, "linktext").getOne().click();
		this.page.element_wait(reloadingText, "xpath").waitForInvisibilityOfElement();
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to click on show table link at top right corner.
	* Date 			: 02/Jul/2015
	* Author 		: Sangappa.k
	**********************************************************************************/
	public LinksAtTopRightCorners clickOnShowTable() throws Exception {
		objWaitForElement.waitForElements(showtable, "linktext");
		this.page.element(showtable, "linktext").getOne().click();
		this.page.element_wait(reloadingText, "xpath").waitForInvisibilityOfElement();
		return this;
	}	
	/**********************************************************************************
	* Description 	: This function is to click on    Return to Self link at top right corner.
	* Date 			: 02/Jul/2015
	* Author 		: Sangappa.k
	**********************************************************************************/
	public LinksAtTopRightCorners clickOnReturnToSelf() throws Exception {
		objWaitForElement.waitForElements("Return to Self", "linktext");
		this.page.element("Return to Self", "linktext").getOne().click();
		this.page.element_wait("Return to Self", "linktext").waitForInvisibilityOfElement();
		return this;
	}	
	
	/**********************************************************************************
	* Description 	: This function is to click on    Return to Self link at top right corner.
	* Date 			: 02/Jul/2015
	* Author 		: Sangappa.k
	**********************************************************************************/
	public LinksAtTopRightCorners verReturnToSelfOptionAtTopRightCorner()
			throws Exception {
		objWaitForElement.waitForElements("Return to Self", "linktext");
		assertTrue(this.page.element("Return to Self", "linktext")
				.isElementPresent());
		return this;
	}

	/**********************************************************************************
	* Description 	: This function is to click on    Return to Self link at top right corner.
	* Date 			: 02/Jul/2015
	* Author 		: Sangappa.k
	**********************************************************************************/
	public LinksAtTopRightCorners verReturnToSelfOptionAtTopRightCornerNotPrestnt()
			throws Exception {
		objWaitForElement.waitForElements("Return to Self", "linktext");
		assertFalse(this.page.element("Return to Self", "linktext")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_TOO_SMALL));
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to verify customize link at top right corner.
	* Date 			: 02/Nov/2015
	* Author 		: Renushree
	**********************************************************************************/
	public LinksAtTopRightCorners verCustomizeLink() throws Exception {
		objWaitForElement.waitForElements(customize, "linktext");
		assertTrue(this.page.element(customize, "linktext").getOne()
				.isDisplayed(), "Customize link is not displyed");
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to click on refresh link at top right corner.
	* Date 			: 21/10/2014
	* Author 		: Sangappa K
	**********************************************************************************/
	public LinksAtTopRightCorners doubleclickOnRefresh() throws Exception {
		objWaitForElement.waitForElements(refresh, "linktext");
		this.page.element(refresh, "linktext").doubleClick();
		this.page.element_wait(reloadingText, "xpath").waitForInvisibilityOfElement();
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to verify Print link is displayed at top right corner.
	* Date 			: 26/feb/2016
	* Author 		: sandhya
	**********************************************************************************/
	public LinksAtTopRightCorners verPrintLink() throws Exception {
		objWaitForElement.waitForElements(print, "linktext");
		assertTrue(this.page.element(print, "linktext").getOne()
				.isDisplayed(), "print link is not displyed");
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to verify export link is displayed at top right corner.
	* Date 			: 26/feb/2016
	* Author 		: sandhya
	**********************************************************************************/
	public LinksAtTopRightCorners verExportLink() throws Exception {
		objWaitForElement.waitForElements(export, "linktext");
		assertTrue(this.page.element(export, "linktext").getOne()
				.isDisplayed(), "export link is not displyed");
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to verify help link is displayed at top right corner.
	* Date 			: 26/feb/2016
	* Author 		: sandhya
	**********************************************************************************/
	public LinksAtTopRightCorners verHelpLink() throws Exception {
		objWaitForElement.waitForElements(help, "linktext");
		assertTrue(this.page.element(help, "linktext").getOne()
				.isDisplayed(), "help link is not displyed");
		return this;
	}
	
}
