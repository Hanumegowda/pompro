package page;

import static org.testng.Assert.assertTrue;
import module.Frames;

import org.openqa.selenium.WebDriver;

import qaframework.lib.pageObject.PageObject;
import qaframework.lib.userDefinedFunctions.WaitForElement;

public class AuditLogs extends PageObject{
	WebDriver driver;
	WaitForElement objWaitForElement;
	Frames objFrames;
	
	private String auditlog = "//b[text()='Audit Logs']";
	
	public AuditLogs(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
		objFrames = new Frames(this.driver);
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Audit Logs' page is displayed.
	* Date 		  : 25-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public AuditLogs verAuditLogsPage() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(auditlog, "xpath");
		assertTrue(this.page.element(auditlog, "xpath").isElementPresent());
		return this;
	}

}
