package EMR.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.*;
import qaFramework.WaitTimeConstants;
import qaFramework.UserDefinedFunctions.WaitForElement;
import qaFramework.pageObject.PageObject;
import EMR.Locators.SelectRegion.Locators;

public class SelectRegion extends PageObject {

	WebDriver driver;
	WaitForElement waitForElement ;
	WebDriverWait wait;
	Shared shared;

	public SelectRegion(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		waitForElement = new WaitForElement(this.driver);
		shared = new Shared(this.driver);
		wait = new WebDriverWait(this.driver, WaitTimeConstants.WAIT_TIME_LONG);
	}

	public SelectRegion clickNextButton() throws Exception {
		waitForElement.waitForElements(Locators.NEXTBTN, "css");
		this.page.element(Locators.NEXTBTN, "css").clickUsingJSE();
		Thread.sleep(8000);//In IE, it is taking time to switch
		waitForElement.waitForElements(EMR.Locators.Shared.Locators.FRAME_DATA, "xpath");
		return this;
	}

	public SelectRegion selectRegionName(String strRegionName) throws Exception {
		waitForElement.waitForElements(Locators.REGIONLIST, "id");
		this.page.element(Locators.REGIONLIST, "id").webElementToSelect().selectByVisibleText(strRegionName);
		return this;
	}

	public SelectRegion selectRegionAndClickOnNext(String strRegionName)
			throws Exception {
		this.selectRegion(strRegionName);
		this.clickNextButton();
		shared.selectFrame();
		return this;
	}

	public SelectRegion clickRegion() throws Exception {
		Thread.sleep(2000);
		waitForElement.waitForElements(Locators.REGIONNAME, "xpath");
		this.page.element(Locators.REGIONNAME, "xpath").clickUsingJSE();
		return this;	
	}

	public SelectRegion selectRegion(String strRegionName)
			throws Exception {
		driver.switchTo().defaultContent();
		if (this.page.element(Locators.FRAMEDATA, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_TOO_SMALL)) {
//			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(Locators.FRAME));
			driver.switchTo().frame(Locators.FRAME);
		}
		if (!this.page.element(Locators.SELECT_REGION_PAGE, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_TOO_SMALL)) {
			this.clickRegion();
		}
		this.selectRegionName(strRegionName);
		return this;
	}
	
	public SelectRegion verifyUserCannotSwitchRegions() throws Exception {
		assertFalse(this.page.element(Locators.REGION_LINK_NOT_PRESENT, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE), "user has access to multiple regions.");
		return this;
	}
}