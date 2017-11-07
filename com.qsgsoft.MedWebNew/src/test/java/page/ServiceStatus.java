package page;

import module.Frames;

import org.openqa.selenium.WebDriver;

import qaframework.lib.pageObject.PageObject;
import qaframework.lib.userDefinedFunctions.WaitForElement;
import static org.testng.Assert.assertTrue;

public class ServiceStatus extends PageObject{
	WebDriver driver;
	WaitForElement objWaitForElement;
	Frames objFrames;
	
	private String medwebServerVer = "//blockquote",
			       SNMP = "//img[@src='/.cobalt/images/a_top_service_snmp.gif']",
			       ServiceStatusOfSNMP = "//b[text()='Simple Network Management Protocol (SNMP) Status']",
			       serviceStatus = "//b[text()='Software On The Medweb Server']";
	
	public ServiceStatus(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
		objFrames = new Frames(this.driver);
	}
	
	/**********************************************************************************
	* Description : This function is to verify Medweb Server version is displayed.
	* Date 		  : 08-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ServiceStatus verMedwebServerVersionDisplayed(String req)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(medwebServerVer, "xpath");
		String str = this.page.element(medwebServerVer, "xpath").getOne().getText();
		System.out.println(str);
		assertTrue(str.contains(req));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on SNMP button.
	* Date 		  : 13-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ServiceStatus clickOnSNMP()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToSubMenuInRightFrame();
		objWaitForElement.waitForElements(SNMP, "xpath");
		this.page.element(SNMP, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Service status of SNMP' is displayed.
	* Date 		  : 13-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ServiceStatus verServiceStatusSNMPIsDisplayed() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(ServiceStatusOfSNMP, "xpath");
		assertTrue(this.page.element(ServiceStatusOfSNMP, "xpath").getOne()
				.isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Service status' page is displayed.
	* Date 		  : 14-Dec-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ServiceStatus verServiceStatusPage()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToSubMenuInRightFrame();
		objWaitForElement.waitForElements(serviceStatus, "xpath");
		this.page.element(serviceStatus, "xpath").getOne().click();
		return this;
	}

}
