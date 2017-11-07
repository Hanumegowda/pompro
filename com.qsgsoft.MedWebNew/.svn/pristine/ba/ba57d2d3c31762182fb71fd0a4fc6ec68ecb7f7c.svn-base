package page;

import module.Frames;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.assertTrue;

import qaframework.lib.WaitTimeConstants;
import qaframework.lib.pageObject.PageObject;
import qaframework.lib.userDefinedFunctions.WaitForElement;

public class AdministratorSite extends PageObject {
	
	WebDriver driver;
	WaitForElement objWaitForElement;
	Frames objFrames;
	
	private String   administratorSite = "//b[text()='Administrator Site']",
	                 //administratorSite = "//img[@src='/cobalt-images/p_title_dot.gif']/..//b[contains(text(),'Administrator Site')]",
			         userManagement = "//a[text()='User Management']",
			         userManagement1 = "//img[@src='/.cobalt/images/a_top_usr_mgmt1.gif']",
			         administratortab = "//img[@src='/.cobalt/images/a_top_usr_admn.gif']",
			         activeMonitor = "//img[@src='/.cobalt/images/a_monitor_left.gif']";
			         
		
	public AdministratorSite(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement =  new WaitForElement(this.driver);
	    objFrames = new Frames(this.driver);
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Administrator Site' page.
	  * Date        : 15-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AdministratorSite verAdministratorSitePage() throws Exception {
		objFrames.switchToDefaultFrame();
		Thread.sleep(2000);
		objFrames.switchToRightFrame();
		objFrames.switchToSubMenuInRightFrame();
		objWaitForElement.waitForElements(administratorSite, "xpath");
		WebDriverWait wait = new WebDriverWait(this.driver,WaitTimeConstants.WAIT_TIME_LONG);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(administratorSite)));
		assertTrue(this.page.element(administratorSite, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify user management page.
	  * Date        : 15-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AdministratorSite verUserManagementPage() throws Exception {
		objFrames.switchToDefaultFrame();
		objFrames.switchToRightFrame();
		objFrames.switchToSubMenuInRightFrame();
		objWaitForElement.waitForElements(userManagement, "xpath");
		assertTrue(this.page.element(userManagement, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify user management page.
	  * Date        : 15-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AdministratorSite verUserManagementPage1() throws Exception {
		objFrames.switchToDefaultFrame();
		objFrames.switchToRightFrame();
		objFrames.switchToSubMenuInRightFrame();
		objWaitForElement.waitForElements(userManagement1, "xpath");
		assertTrue(this.page.element(userManagement1, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on Administrator tab.
	  * Date        : 30-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public AdministratorSite clickOnAdministratorTab() throws Exception {
		objFrames.switchToDefaultFrame();
		objFrames.switchToRightFrame();
		objFrames.switchToSubMenuInRightFrame();
		objWaitForElement.waitForElements(administratortab, "xpath");
		this.page.element(administratortab, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on Active Monitor' button.
	 * Date        : 05-Oct-2015
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public AdministratorSite clickOnActiveMonitor() throws Exception {
		objFrames.switchToDefaultFrame().switchToLeftFrame()
		.switchToAlertInLeftFrame();
		objWaitForElement.waitForElements(activeMonitor, "xpath");
		this.page.element(activeMonitor, "xpath").getOne().click();
		return this;
	}

}
