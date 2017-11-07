package page;

import java.util.concurrent.TimeUnit;

import module.Frames;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import qaframework.lib.WaitTimeConstants;
import qaframework.lib.pageObject.PageObject;
import qaframework.lib.userDefinedFunctions.WaitForElement;

public class MailVerificationFunctions extends PageObject{
	WebDriver driver;
	WaitForElement objWaitForElement;
	Frames objFrames;
	WebDriverWait wait;
	
	private static String url = "https://192.232.238.154:2096/",
			              username = "user",
			              password = "pass",
			              loginButton  = "login_submit",
			              horde = "hordePreview",
			              //search = "horde-search-dropdown",
			              search  ="//span[@id='horde-search-dropdown']/span[@class='iconImg horde-popdown']",
			              subj  ="ctx_qsearchopts_subject",
			             // subj = "a:contains('Subject')",
			              searchTxtField = "horde-search-input",
			              searchIcon = "horde-search-icon",
			              
			              mail = "//img[@src='/horde/imp/themes/graphics/imp.png']",
			              htmlfile = "//img[@src='/horde/imp/themes/graphics/mime/html.png']",
			              mwwfile = "//img[@src='/horde/themes/graphics/mime/text.png']",
			              lastPage = "//img[@src='/horde/themes/graphics/nav/last-grey.png']",
			              logout = "lblLogout";
			              
			              /*url = "https://webmail.opentransfer.com/",
					      username = "//input[@type='text'][@name='imapuser']",
					      password = "//input[@type='password'][@name='pass']",
					      loginButton  = "//input[@class='button'][@name='loginButton']",
					      mail = "//img[@src='/horde/imp/themes/graphics/imp.png']",
					      htmlfile = "//img[@src='/horde/imp/themes/graphics/mime/html.png']",
					      pdffile = "//img[@src='/horde/themes/graphics/mime/pdf.png']",
					      mwwfile = "//img[@src='/horde/themes/graphics/mime/text.png']",
					      lastPage = "//img[@src='/horde/themes/graphics/nav/last-grey.png']"*/;
	
	public MailVerificationFunctions(WebDriver _driver) throws Exception{
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
		objFrames = new Frames(this.driver);
		wait = new WebDriverWait(this.driver,WaitTimeConstants.WAIT_TIME_LONG);
		
	}
	
	/**********************************************************************************
	* Description : This function is to login to the mail.
	* Date 		  : 23-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public MailVerificationFunctions loginToMail(String un,String pwd)
			throws Exception {
		driver.manage().timeouts().implicitlyWait(WaitTimeConstants.WAIT_TIME_LONG, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(WaitTimeConstants.WAIT_TIME_LONG, TimeUnit.SECONDS);
		driver.get(url);
		try{
			Thread.sleep(5000);
		driver.get("javascript:document.getElementById('overridelink').click();");
		}
		catch(NoSuchElementException ne){
		}
		Thread.sleep(10000);
		objWaitForElement.waitForElements(username, "id");
		this.page.element(username, "id").clearInputValue().sendKeys(un);
		objWaitForElement.waitForElements(password, "id");
		this.page.element(password, "id").clearInputValue().sendKeys(pwd);
		Thread.sleep(5000);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id(loginButton)));
		objWaitForElement.waitForElements(loginButton, "id");
		this.page.element(loginButton, "id").getOne().click();
		/*this.page.element(loginButton, "id").mouseOver();
		this.page.element(loginButton, "id").doubleClick();*/
		return this;
		
	}
	
	/**********************************************************************************
	* Description : This function is to navigate to the inbox.
	* Date 		  : 23-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public MailVerificationFunctions navigateToInbox1(String sub)
			throws Exception {
		driver.manage().timeouts().implicitlyWait(WaitTimeConstants.WAIT_TIME_LONG, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(this.driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(horde)));
		objWaitForElement.waitForElements(horde, "id");
		//this.page.element(horde, "xpath").mouseOver();
		this.page.element(horde, "id").getOne().click();
		
		
		//objFrames.switchToDefaultFrame().switchToHordeMainFrame();
		Thread.sleep(5000);
		//driver.get("javascript:document.getElementById('horde-search').click();");
		//((JavascriptExecutor)driver).executeScript("arguments[0].click();", search);
		driver.switchTo().defaultContent();
		objFrames.switchToMailFrame()/*switchToIFrame("mailFrame")*/;
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(search)));
		this.page.element(search, "xpath").mouseOver();
		this.page.element(search, "xpath").getOne().click();
		//objWaitForElement.waitForElements(lastPage, "xpath");
		//if(this.page.element(lastPage, "xpath").isElementPresent()==true){
		this.page.element(subj, "id").mouseOver();
		this.page.element(subj, "id").getOne().click();
		this.page.element(searchTxtField, "id").clearInputValue().sendKeys(sub);
		this.page.element(searchIcon, "id").getOne().click();
		//}
		//objFrames.switchToDefaultFrame().switchToHordeMainFrame();
		
		return this;
	}

	
	/**********************************************************************************
	* Description : This function is to navigate to the inbox.
	* Date 		  : 23-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public MailVerificationFunctions navigateToInbox(String sub)
			throws Exception {
		driver.manage().timeouts().implicitlyWait(WaitTimeConstants.WAIT_TIME_LONG, TimeUnit.SECONDS);
		objFrames.switchToDefaultFrame().switchToHordeMainFrame();
		objWaitForElement.waitForElements(mail, "xpath");
		this.page.element(mail, "xpath").mouseOver();
		this.page.element(mail, "xpath").doubleClick();
		objFrames.switchToDefaultFrame().switchToHordeMainFrame();
		objWaitForElement.waitForElements(lastPage, "xpath");
		if(this.page.element(lastPage, "xpath").isElementPresent()==true){
		this.page.element(lastPage, "xpath").mouseOver();
		this.page.element(lastPage, "xpath").getOne().click();
		}
		objFrames.switchToDefaultFrame().switchToHordeMainFrame();
		try{
		objWaitForElement.waitForElements("//b[contains(text(),'"+ sub +"')]", "xpath");
		this.page.element("//b[contains(text(),'"+ sub +"')]", "xpath").mouseOver();
		this.page.element("//b[contains(text(),'"+ sub +"')]", "xpath").getOne()
				.click();
		}
		catch(NoSuchElementException e){
			objWaitForElement.waitForElements("//a[contains(text(),'"+ sub +"')]", "xpath");
			this.page.element("//a[contains(text(),'"+ sub +"')]", "xpath").mouseOver();
			this.page.element("//a[contains(text(),'"+ sub +"')]", "xpath").getOne()
					.click();
		}
		objFrames.switchToDefaultFrame().switchToHordeMainFrame();
		String str = "//td[contains(text(),'"
				+ sub
				+ "')]/preceding-sibling::td//strong[contains(text(),'Subject:')]";
		objWaitForElement.waitForElements(str, "xpath");
		assertTrue(this.page.element(str, "xpath").isElementPresent());
		return this;
	}

	/**********************************************************************************
	* Description : This function is to verify html file is present.
	* Date 		  : 25-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public MailVerificationFunctions verHtmlFile() throws Exception {
		objFrames.switchToDefaultFrame().switchToHordeMainFrame();
		objWaitForElement.waitForElements(htmlfile, "css");
		assertTrue(this.page.element(htmlfile, "css").isElementPresent());
		return this;

	}
	
	/**********************************************************************************
	* Description : This function is to verify html file is present.
	* Date 		  : 25-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public MailVerificationFunctions verHtmlFile(String subject) throws Exception {
		//objFrames.switchToDefaultFrame().switchToHordeMainFrame();
		String str = "span:contains('"+subject+"')";
		objWaitForElement.waitForElements(str, "css");
		assertTrue(this.page.element(str, "css").isElementPresent());
		return this;

	}

	/**********************************************************************************
	* Description : This function is to verify pdf file is present.
	* Date 		  : 25-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public MailVerificationFunctions verPdfFile(String sub) throws Exception {
		//String str = "span:contains('"+sub+"')";
		String str = "//span[text()='"+sub+"']";
		objWaitForElement.waitForElements(str, "xpath");
		assertTrue(this.page.element(str, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify mww file is present.
	* Date 		  : 28-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public MailVerificationFunctions verMwwFile() throws Exception {
		objFrames.switchToDefaultFrame().switchToHordeMainFrame();
		objWaitForElement.waitForElements(mwwfile, "xpath");
		assertTrue(this.page.element(mwwfile, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on mail and to verify.
	* Date 		  : 05-Oct-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public MailVerificationFunctions clickOnMail(String mail, String mail1) throws Exception {
		objFrames.switchToDefaultFrame().switchToMailFrame();
		String str = "//span[text()='"+mail+"']";
		String str1 = "//span/a[contains(text(),'"+mail1+"')]";
		objWaitForElement.waitForElements(str, "xpath");
		this.page.element(str, "xpath").getOne().click();
		objWaitForElement.waitForElements(str1, "xpath");
		assertTrue((this.page.element(str1, "xpath")).isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'logout' button in mail.
	* Date 		  : 05-Oct-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public MailVerificationFunctions clickOnMailLogout() throws Exception {
		objFrames.switchToDefaultFrame();
		objWaitForElement.waitForElements(logout, "id");
		this.page.element(logout, "id").getOne().click();
		return this;
	}
}
