package module;

import java.nio.file.NoSuchFileException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import qaframework.lib.WaitTimeConstants;
import qaframework.lib.userDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;

public class Frames extends PageObject{

	WebDriver driver;
	WaitForElement objWaitForElement ;
	
	public Frames(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement =  new WaitForElement(this.driver);
	}

	/*************************************************************************
	 * Description : This function is to switch to main Menu frame
	 * Date        : 15-Jun-2015
	 * Author      : Hanumegowda
	 *************************************************************************/
	public boolean  switchToMainMenuFrame() throws Exception {
		try{
		WebDriverWait wait = new WebDriverWait(this.driver,WaitTimeConstants.WAIT_TIME_LONG);
		driver.switchTo().frame("mainMenu");
		Thread.sleep(3000);
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("mainMenu"));
		return true;
		}
		catch(NoSuchFrameException nf){
			return false;
			
		}
	}
	
	/*************************************************************************
	 * Description : This function is to switch to right frame
	 * Date        : 15-Jun-2015
	 * Author      : Hanumegowda
	 *************************************************************************/
	public Frames switchToRightFrame() throws Exception {
		WebDriverWait wait = new WebDriverWait(this.driver,WaitTimeConstants.WAIT_TIME_LONG);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("right"));
		return this;
	}

	/*************************************************************************
	 * Description : This function is to switch to submenu frame in right frame
	 * Date        : 15-Jun-2015
	 * Author      : Hanumegowda
	 *************************************************************************/
	public Frames switchToSubMenuInRightFrame() throws Exception {

		WebDriverWait wait = new WebDriverWait(this.driver,
				WaitTimeConstants.WAIT_TIME_LONG);
		boolean unfound = true;
		int a = 0;
		while (unfound && a < 5) {
			a++;
			try {

				wait.until(ExpectedConditions
						.frameToBeAvailableAndSwitchToIt("subMenu"));
				unfound = false;

			} catch (StaleElementReferenceException exe) {
				unfound = true;
			} catch (org.openqa.selenium.TimeoutException t) {
				unfound = true;

			}
		}

		// wait.until(ExpectedConditions
		// .frameToBeAvailableAndSwitchToIt("subMenu"));

		// wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("\\frame[@src='menu0-0.html']")));
		// wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("subMenu"));
		return this;
	}

	/*************************************************************************
	 * Description : This function is to switch to main frame in right frame
	 * Date        : 15-Jun-2015
	 * Author      : Hanumegowda
	 *************************************************************************/
	public Frames switchToMainInRightFrame() throws Exception {
		WebDriverWait wait = new WebDriverWait(this.driver,WaitTimeConstants.WAIT_TIME_LONG);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("main"));
		return this;
	}
	
	/*************************************************************************
	 * Description : This function is to switch to left frame
	 * Date        : 15-Jun-2015
	 * Author      : Hanumegowda
	 *************************************************************************/
	public Frames switchToLeftFrame() throws Exception {
		WebDriverWait wait = new WebDriverWait(this.driver,WaitTimeConstants.WAIT_TIME_LONG);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("left"));
		return this;
	}
	
	/*************************************************************************
	 * Description : This function is to switch to mainMenu frame in left frame
	 * Date        : 15-Jun-2015
	 * Author      : Hanumegowda
	 *************************************************************************/
	public Frames switchToMainMenuInLeftFrame() throws Exception {
		WebDriverWait wait = new WebDriverWait(this.driver,WaitTimeConstants.WAIT_TIME_LONG);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("mainMenu"));
		return this;
	}
	
	/*************************************************************************
	 * Description : This function is to switch to Default Frame
	 * Date        : 15-Jun-2015
	 * Author      : Hanumegowda
	 *************************************************************************/
	public Frames switchToDefaultFrame() throws Exception {
		this.driver.switchTo().defaultContent();
		return this;
	}
	
	/*************************************************************************
	 * Description : This function is to switch to message frame in right frame
	 * Date        : 17-Jun-2015
	 * Author      : Hanumegowda
	 *************************************************************************/
	public Frames switchToMessageInRightFrame() throws Exception {
		WebDriverWait wait = new WebDriverWait(this.driver,WaitTimeConstants.WAIT_TIME_LONG);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("message"));
		return this;
	}
	
	/*************************************************************************
	 * Description : This function is to switch to submenu frame in right frame
	 * Date        : 15-Jun-2015
	 * Author      : Hanumegowda
	 *************************************************************************/
	public Frames switchToFrame(String frame) throws Exception {

		WebDriverWait wait = new WebDriverWait(this.driver,
				WaitTimeConstants.WAIT_TIME_LONG);
		boolean unfound = true;
		int a = 0;
		while (unfound && a < 2) {
			a++;
			try {

				wait.until(ExpectedConditions
						.frameToBeAvailableAndSwitchToIt(frame));
				unfound = false;

			} catch (StaleElementReferenceException exe) {
				unfound = true;
			} catch (org.openqa.selenium.TimeoutException t) {
				unfound = true;

			}
		}

		// wait.until(ExpectedConditions
		// .frameToBeAvailableAndSwitchToIt("subMenu"));

		// wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("\\frame[@src='menu0-0.html']")));
		// wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("subMenu"));
		return this;
	}
	
	/*************************************************************************
	 * Description : This function is to switch to left frame
	 * Date        : 15-Jun-2015
	 * Author      : Hanumegowda
	 *************************************************************************/
	public Frames switchToIFrame() throws Exception {
//		WebDriverWait wait = new WebDriverWait(this.driver,WaitTimeConstants.WAIT_TIME_LONG);
//		WebElement element = (WebElement) this.page.element("iFrameResizer0", "id");
		driver.switchTo().frame(driver.findElement(By.id("iFrameResizer0")));
		//wait.until(ExpectedConditions.)
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("left"));
		return this;
	}
	
	/*************************************************************************
	 * Description : This function is to switch to left frame
	 * Date        : 15-Jun-2015
	 * Author      : Hanumegowda
	 *************************************************************************/
	public Frames switchToIFrame1(String fm) throws Exception {
		driver.switchTo().frame(driver.findElement(By.id(fm)));
		return this;
	}
	
	/*************************************************************************
	 * Description : This function is to switch to horde_main frame in mail.
	 * Date        : 24-Sep-2015
	 * Author      : Hanumegowda
	 *************************************************************************/
	public Frames switchToHordeMainFrame() throws Exception {
		WebDriverWait wait = new WebDriverWait(this.driver,WaitTimeConstants.WAIT_TIME_LONG);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("horde_main"));
		return this;
	}
	
	/*************************************************************************
	 * Description : This function is to switch to 'mailFrame' frame in mail.
	 * Date        : 24-Sep-2015
	 * Author      : Hanumegowda
	 *************************************************************************/
	public Frames switchToMailFrame() throws Exception {
		WebDriverWait wait = new WebDriverWait(this.driver,WaitTimeConstants.WAIT_TIME_LONG);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("mailFrame"));
		return this;
	}
	
	/*************************************************************************
	 * Description : This function is to switch to horde_main frame in mail.
	 * Date        : 24-Sep-2015
	 * Author      : Hanumegowda
	 *************************************************************************/
	public Frames switchToIFrame(String str) throws Exception {
		WebDriverWait wait = new WebDriverWait(this.driver,WaitTimeConstants.WAIT_TIME_LONG);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(str));
		return this;
	}
	
	/*************************************************************************
	 * Description : This function is to switch to horde_main frame in mail.
	 * Date        : 24-Sep-2015
	 * Author      : Hanumegowda
	 *************************************************************************/
	public Frames switchToForm(String str) throws Exception {
		WebDriverWait wait = new WebDriverWait(this.driver,WaitTimeConstants.WAIT_TIME_LONG);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(str));
		return this;
	}
	
	/*************************************************************************
	 * Description : This function is to switch to alert frame in left frame
	 * Date        : 05-Oct-2015
	 * Author      : Hanumegowda
	 *************************************************************************/
	public Frames switchToAlertInLeftFrame() throws Exception {
		WebDriverWait wait = new WebDriverWait(this.driver,WaitTimeConstants.WAIT_TIME_LONG);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("alert"));
		return this;
	}
	
	/*************************************************************************
	 * Description : This function is to switch to search frame
	 * Date        : 09-Dec-2015
	 * Author      : Hanumegowda
	 *************************************************************************/
	public Frames switchToSearchFrame() throws Exception {
		WebDriverWait wait = new WebDriverWait(this.driver,WaitTimeConstants.WAIT_TIME_LONG);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("thesearch"));
		return this;
	}
	
	/*************************************************************************
	 * Description : This function is to switch to search frame
	 * Date        : 09-Dec-2015
	 * Author      : Hanumegowda
	 *************************************************************************/
	public Frames switchToFrameInAdvancedSearch() throws Exception {
		WebDriverWait wait = new WebDriverWait(this.driver,WaitTimeConstants.WAIT_TIME_LONG);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("theform"));
		return this;
	}
	
	/*************************************************************************
	 * Description : This function is to switch to 'FRM' frame
	 * Date        : 02-Jun-2016
	 * Author      : Hanumegowda
	 *************************************************************************/
	public Frames switchToFRMFrame() throws Exception {
		WebDriverWait wait = new WebDriverWait(this.driver,WaitTimeConstants.WAIT_TIME_LONG);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("FRM"));
		return this;
	}

}
