package page;

import static org.testng.Assert.assertTrue;



import java.util.List;

import module.Frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import qaframework.lib.pageObject.PageObject;
import qaframework.lib.userDefinedFunctions.WaitForElement;

public class Network extends PageObject{
	WebDriver driver;
	WaitForElement objWaitForElement;
	Frames objFrames;
	
	public String portChecker = "//a[text()='Port Checker']",
			      portChecker1 = "//img[@src='/.cobalt/images/port_check_off.gif']",
			      selectDestination = "//select[@name='HOST']",
			      checkPort = "//a[text()='Check port']",
			      dicomService = "//td[contains(text(),'DICOM')]/..//img[@src='/cobalt-images/port_available.gif']",
			      SSHService = "//td[contains(text(),'SSH')]/..//img[@src='/cobalt-images/port_available.gif']",
			      SecureTunnelService = "//td[contains(text(),'Secure')][contains(text(),'Tunnel')]/..//img[@src='/cobalt-images/port_available.gif']",
			      hostName = "//input[@name='hostname']";
	
	public Network(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
		objFrames = new Frames(this.driver);
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'port checker' tab.
	* Date 		  : 05-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Network clickOnPortChecker() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToSubMenuInRightFrame();
		objWaitForElement.waitForElements(portChecker, "xpath");
		this.page.element(portChecker, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'port checker' tab.
	* Date 		  : 05-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Network clickOnPortChecker1() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToSubMenuInRightFrame();
		objWaitForElement.waitForElements(portChecker1, "xpath");
		this.page.element(portChecker1, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select destination from dropdown.
	* Date 		  : 05-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Network selectDestination(String option) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(selectDestination, "xpath");
		this.page.element(selectDestination, "xpath").webElementToSelect().selectByVisibleText(option);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'CheckPort' button.
	* Date 		  : 05-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Network clickOnCheckPort() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(checkPort, "xpath");
		this.page.element(checkPort, "xpath").getOne().click();
		Thread.sleep(5000);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify Availability Of DICOM Service.
	* Date 		  : 05-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Network verAvailabilityOfDICOMService() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(dicomService, "xpath");
		assertTrue(this.page.element(dicomService, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify Availability Of SSH Service.
	* Date 		  : 05-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Network verAvailabilityOfSSHService() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(SSHService, "xpath");
		assertTrue(this.page.element(SSHService, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify Availability Of Secure Tunnel Service.
	* Date 		  : 05-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Network verAvailabilityOfSecureTunnelService() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(SecureTunnelService, "xpath");
		assertTrue(this.page.element(SecureTunnelService, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select destination from dropdown.
	* Date 		  : 05-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Network selectDestination1(String option) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(selectDestination, "xpath");
		WebElement str = this.driver.findElement(By.xpath(selectDestination));
		List<WebElement> options = str.findElements(By.tagName("option"));
		for(WebElement alloption:options){
			if((alloption.getText()).contains(option)){
				System.out.println(alloption);
				alloption.click();
			}
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to get host name of the server.
	* Date 		  : 07-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public String getHostName() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(hostName, "xpath");
		String str = this.page.element(hostName, "xpath").getOne().getAttribute("value");
		return str;
	}

}
