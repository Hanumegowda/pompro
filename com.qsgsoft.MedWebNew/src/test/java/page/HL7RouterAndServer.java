package page;

import module.Frames;

import org.openqa.selenium.WebDriver;
import static org.testng.Assert.assertTrue;

import qaframework.lib.pageObject.PageObject;
import qaframework.lib.userDefinedFunctions.WaitForElement;

public class HL7RouterAndServer extends PageObject{
	WebDriver driver;
	WaitForElement objWaitForElement;
	Frames objFrames;
	 private String enableHL7Service  = "//input[@name='HL7_ROUTER']",
			        enableHL7Service1 = "//input[@type='CHECKBOX'][@name='HL7_SERVICE_ENABLED']",
			        statusRunning = "//td[contains(text(),'Status: ')]//font[text()='Running']",
			        HLServerStatusRunning = "//td[contains(text(),'HL7 Server status:')]//font[text()='Running']";
	 
	 public HL7RouterAndServer(WebDriver _driver) throws Exception {
		 super(_driver);
		 this.driver = _driver;
		 objWaitForElement = new WaitForElement(this.driver);
		 objFrames = new Frames(this.driver);
		 
	 }
	 
	/**********************************************************************************
     * Description  : This function is to select 'Enable HL7 service' checkbox.
     * Date 		: 13-Aug-2015
     * Author 	    : Hanumegowda
     **********************************************************************************/
	public HL7RouterAndServer selectEnableHL7ServiceCheckbox() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(enableHL7Service, "xpath");
		if (this.page.element(enableHL7Service, "xpath").getOne().isSelected() == false) {
			this.page.element(enableHL7Service, "xpath").getOne().click();
		}
		return this;
	}
		
    /**********************************************************************************
	 * Description : This function is to verify 'HL7 Router Services' status is running.
	 * Date 		: 13-Aug-2015
	 * Author 	    : Hanumegowda
	 **********************************************************************************/
	public HL7RouterAndServer verRunningStatus() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(statusRunning, "xpath");
		assertTrue(this.page.element(statusRunning, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
     * Description  : This function is to select 'Enable HL7 service' checkbox in 'HL7 Server' page.
     * Date 		: 17-Aug-2015
     * Author 	    : Hanumegowda
     **********************************************************************************/
	public HL7RouterAndServer selectEnableHL7ServiceCheckboxInHL7ServerPage() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(enableHL7Service1, "xpath");
		if (this.page.element(enableHL7Service1, "xpath").getOne().isSelected() == false) {
			this.page.element(enableHL7Service1, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'HL7 Server Services' status is running.
	 * Date 		: 17-Aug-2015
	 * Author 	    : Hanumegowda
	 **********************************************************************************/
	public HL7RouterAndServer verHL7ServerRunningStatus() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(HLServerStatusRunning, "xpath");
		assertTrue(this.page.element(HLServerStatusRunning, "xpath").isElementPresent());
		return this;
	}

}
