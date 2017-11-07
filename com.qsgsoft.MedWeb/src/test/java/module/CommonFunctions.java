package module;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import static org.testng.Assert.assertTrue;
import qaframework.lib.WaitTimeConstants;
import qaframework.lib.pageObject.PageObject;
import qaframework.lib.userDefinedFunctions.WaitForElement;

public class CommonFunctions extends PageObject{
	WebDriver driver;
	WaitForElement objWaitForElement;
	Frames objFrames;
	
	private String continueToThisWebsite = "//a[contains(text(),'Continue to this website (not recommended).')]";
	
	public CommonFunctions(WebDriver _driver) throws Exception{
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
		objFrames = new Frames(this.driver);
		
	}
	
	/**********************************************************************************
	* Description : This function is to click on Continue to this website (not recommended) link.
	* Date 		  : 14-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public boolean clickOnContinueToThisWebsiteLink()
			throws Exception {
		Capabilities cap = ((RemoteWebDriver) this.driver).getCapabilities();
		String browser = cap.getBrowserName().toLowerCase();
		System.out.println("this is " + browser);
		if (browser.equalsIgnoreCase("internet explorer")) {
			objWaitForElement.waitForElements(continueToThisWebsite, "xpath");

		if(this.page.element(continueToThisWebsite, "xpath").isElementPresent()/*.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE1)*/==true){

		this.page.element(continueToThisWebsite, "xpath").clickUjse();
		return true;
		}
		else {
		return false;	
		}
		}
		else{
			return false;
		}
		
	}
	
	/**********************************************************************************
	* Description : This function is to click on Continue to this website (not recommended) link.
	* Date 		  : 14-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************//*
	public boolean clickOnContinueToThisWebsiteLink1()
			throws Exception {
		Capabilities cap = ((RemoteWebDriver) this.driver).getCapabilities();
		String browser = cap.getBrowserName().toLowerCase();
		System.out.println("this is " + browser);
		if (browser.equalsIgnoreCase("internet explorer")) {
			objWaitForElement.waitForElements(continueToThisWebsite, "xpath");

		if(this.page.element(continueToThisWebsite, "xpath").isElementPresent().isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE1)==true){

		this.page.element(continueToThisWebsite, "xpath").clickUjse();
		return true;
		}
		else {
		return false;	
		}
		}
		else{
			return false;
		}
		
	}*/
	
	/**********************************************************************************
	* Description : This function is to verify downloaded file is exists.
	* Date 		  : 15-Apr-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public CommonFunctions verDownloadedFile(String filepath)
			throws Exception {
	File file = new File(filepath);
	assertTrue(file.exists());
	return this;
		
	}
	
	/**********************************************************************************
	* Description : This function is to verify downloaded file is exists.
	* Date 		  : 15-Apr-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public CommonFunctions setClipBoardData(String fileName)throws Exception{
		StringSelection ss =new StringSelection(fileName);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to get the browser name.
	* Date 		  : 23-Sep-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public String getBrowserName()throws Exception{
		Capabilities cp = ((RemoteWebDriver)this.driver).getCapabilities();
		String bn = cp.getBrowserName();
		return bn;
	}
	
	/**********************************************************************************
	* Description : This function is to verify downloaded file is exists.
	* Date 		  : 15-Apr-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	
	
	public CommonFunctions downloadFileInIE(String fileNameToChange)throws Exception{
		
		setClipBoardData(fileNameToChange);;

		Robot robot = new Robot();
			
		Thread.sleep(2000);
				
		robot.keyPress(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_N);
		robot.keyRelease(KeyEvent.VK_N);
		robot.keyRelease(KeyEvent.VK_ALT);
		
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
		Thread.sleep(2000);
		
		robot.keyPress(KeyEvent.VK_UP);
		robot.keyRelease(KeyEvent.VK_UP);
		
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(2000);

		robot.keyPress(KeyEvent.VK_CONTROL);    
		robot.keyPress(KeyEvent.VK_V);
		     
		robot.keyRelease(KeyEvent.VK_V);    
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		Thread.sleep(2000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		return this;
		
	}
	
	
}
