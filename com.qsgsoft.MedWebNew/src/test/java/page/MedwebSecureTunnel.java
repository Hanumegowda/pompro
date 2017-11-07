package page;

import module.Frames;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertTrue;
import qaframework.lib.pageObject.PageObject;
import qaframework.lib.userDefinedFunctions.WaitForElement;
import qaframework.lib.webElements.WebdriverWait;

public class MedwebSecureTunnel extends PageObject{
	WebDriver driver;
	WaitForElement objWaitForElement;
	Frames objFrames;
	
	private String generate = "//a[text()='Generate New Key']",
			      localPublicKeySection = "//b[text()='Localhost Public Key']/../../../../..//tt",
			      hostPublicKeySection = "//b[text()='Remote Host Public Key']/../../../../..//textarea[@name='KEY']",
			      delHostName = "//img[@src='/.cobalt/images/delete.gif']";
	
	public MedwebSecureTunnel(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
		objFrames = new Frames(this.driver);
		
	}
	
	/**********************************************************************************
	* Description : This function is to click on generate button.
	* Date 		  : 14-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public MedwebSecureTunnel clickOnGenerateButton()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(generate, "xpath");
	   this.page.element_wait(generate, "xpath").waitForElementEnable();
		this.page.element(generate, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to get text from 'Localhost Public Key' section.
	* Date 		  : 14-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public String getTextFromLocalhostPublicKeySection()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(localPublicKeySection, "xpath");
		String str = this.page.element(localPublicKeySection, "xpath").getOne().getText();
		System.out.println(str);
		return str;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Remote Host Public Key' section.
	* Date 		  : 14-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public MedwebSecureTunnel enterTextInRemoteHostPublicKeySection(String str)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(hostPublicKeySection, "xpath");
		this.page.element(hostPublicKeySection, "xpath").getOne().click();
		this.page.element(hostPublicKeySection, "xpath").clearInputValue().sendKeys(str);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Remote Host Public Key' section.
	* Date 		  : 14-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public MedwebSecureTunnel enterTextInRemoteHostPublicKeySection1(String str)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(hostPublicKeySection, "xpath");
		this.page.element(hostPublicKeySection, "xpath").sendkeysUJSE(str);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to delete host name of the server from 'Known hosts table'.
	* Date 		  : 07-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public boolean delHostNameOfServer()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(delHostName, "xpath");
		if(this.page.element(delHostName, "xpath").isElementPresent()==true){
		this.page.element(delHostName, "xpath").getOne().click();
		try{
			Alert alert = driver.switchTo().alert();
			alert.accept();
			return true;
			}
			catch(NoAlertPresentException ex) {
				return false;
				
			}
		
	}
		else{
			return false;
		}
	}
	
	/**********************************************************************************
	* Description : This function is to verify host name of server under 'Known hosts table'.
	* Date 		  : 07-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public MedwebSecureTunnel verHostNameOfServer(String str)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		String ele = "//b[contains(text(),'Known hosts table')]//ancestor ::tr/following-sibling::tr//td[contains(text(),'"+str+"')]";
		objWaitForElement.waitForElements(ele, "xpath");
		assertTrue(this.page.element(ele, "xpath").getOne().isDisplayed());
		return this;
	}


}
