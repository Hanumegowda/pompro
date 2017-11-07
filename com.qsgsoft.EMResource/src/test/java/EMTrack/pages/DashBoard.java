package EMTrack.pages;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import EMTrack.Locators.DashBoard.Locators;
import qaFramework.UserDefinedFunctions.WaitForElement;
import qaFramework.pageObject.PageObject;

public class DashBoard extends PageObject {
	WebDriver driver;
	WaitForElement waitForElement ;
	

	public DashBoard(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver=_driver;
		waitForElement = new WaitForElement(this.driver);
	}
	
	public DashBoard clickOnDivision() throws Exception {
		waitForElement.waitForElements(Locators.DIVISION, "css");
		this.page.element(Locators.DIVISION, "css").getOne().click();
		waitForElement.waitForElements(Locators.DIVISION, "css");
		assertTrue(this.page.element(Locators.DIVISION, "css")
				.isElementPresent());
		return this;
	}
	
	public DashBoard selectSubDivision(String location) throws Exception {
	    String region=Locators.LOCATION+location+Locators.CLOSINGBRACKETS;
	    waitForElement.waitForElements(Locators.VIEWALLCONTACTS, "css");
	    this.page.element(region, "xpath").getOne().click();
	    waitForElement.waitForElements(location, "linktext");
	   // assertTrue(this.page.element(location, "linktext").isElementPresent());
	return this;
	}
		
	public	DashBoard selectLocation(String location) throws Exception {
		    clickOnDivision();
		    selectSubDivision(location);
	return this;
	}
	

}

