package EMR.pages;

import static org.testng.Assert.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import qaFramework.WaitTimeConstants;
import qaFramework.UserDefinedFunctions.WaitForElement;
import qaFramework.pageObject.PageObject;
import EMR.Locators.Login.Locators;

public class Login extends PageObject {

	WebDriver driver;
	WaitForElement waitForElement ;
	WebDriverWait wait;
	SelectRegion selectRegion;
	Shared shared;
	
	public Login(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		waitForElement =  new WaitForElement(this.driver);
		selectRegion = new SelectRegion(this.driver);
		shared = new Shared(this.driver);
		wait = new WebDriverWait(this.driver, WaitTimeConstants.WAIT_TIME_LONG);
	}

	public Login clickOnLogin() throws Exception {
		waitForElement.waitForElements(Locators.LOGIN, "css");
		this.page.element(Locators.LOGIN, "css").getOne().click();
		return this;
	}

	public Login enterUserName(String _username) throws Exception {
		waitForElement.waitForElements(Locators.USERNAME, "css");
		this.page.element(Locators.USERNAME, "css").clearInputValue().sendKeys(_username);
		assertEquals(this.page.element(Locators.USERNAME, "css").getOne().getAttribute("value"),_username);
		return this;
	}

	public Login enterPassword(String _password) throws Exception {
		waitForElement.waitForElements(Locators.PASSWORD, "css");
		this.page.element(Locators.PASSWORD, "css").clearInputValue().sendKeys(_password);
		return this;
	}

	public Login enterNewPassword(String password) throws Exception {
		waitForElement.waitForElements(Locators.NEWPASSWORD, "css");
		this.page.element(Locators.NEWPASSWORD, "css").clearInputValue().sendKeys(password);
		return this;
	}
	
	public Login enterCurrentPassword(String password) throws Exception {
		waitForElement.waitForElements(Locators.CURRENTPASSWORD, "css");
		this.page.element(Locators.CURRENTPASSWORD, "css").clearInputValue().sendKeys(password);
		return this;
	}

	public Login enterConfirmPassword(String password) throws Exception {
		waitForElement.waitForElements(Locators.CONFIRMPASSWORD, "css");
		this.page.element(Locators.CONFIRMPASSWORD, "css").clearInputValue().sendKeys(password);
		return this;
	}

	public Login clickOnSubmit() throws Exception {
		waitForElement.waitForElements(Locators.SUBMIT, "name");
	    this.page.element(Locators.SUBMIT, "name").getOne().click();
		return this;
	}
	
	public Login selectFrame() throws Exception {
		this.driver.switchTo().defaultContent();
		Thread.sleep(5000);
		try{
			waitForElement.waitForElements(Locators.FRAME_DATA, "xpath");
			if(this.page.element(Locators.FRAME_DATA, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL)){
				this.driver.switchTo().frame(Locators.FRAME);
				System.out.println("switched");
				waitForElement.waitForElements(Locators.LOGOUT, "xpath");
			}
		}catch (Exception e) {
			WebDriverWait wait = new WebDriverWait(this.driver, WaitTimeConstants.COUNT);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(Locators.FRAME));
			System.out.println("switched in catch block");
		}
		assertTrue(this.page.element(Locators.LOGOUT, "xpath").isElementPresent());
		System.out.println("verified logout button");
		return this;
	}
	
	public Login resetPassword(String currentPassword, String newPassword) throws Exception {
		this.enterCurrentPassword(currentPassword);
		this.enterNewPassword(newPassword);
		this.enterConfirmPassword(newPassword);
		this.clickOnSubmit();
		this.clickOnCancelOfSecurityQuestionPage();
		this.selectFrame();
		return this;
	}
	
	public Login loginAsUserAndAcknowledgeWebNotification(
			String username, String password) throws Exception {
		this.launchUrlAndVerifyUsernameField();
		this.enterUserName(username);
		this.enterPassword(password);
		this.clickOnLogin();
		this.clickOnCancelOfSecurityQuestionPage();
		this.acknowledgeWebNotification();
		return this;
	}
	
	public Login clickOnCancelOfSecurityQuestionPage()
			throws Exception {
		try {
			if (this.page.element(Locators.RESPONSE, "css").isElementPresent()) {
				waitForElement.waitForElements(Locators.RESPONSE, "css");
				this.page.element(Locators.CANCEL, "css").getOne().click();
				if(this.page.element(Locators.FRAME_DATA, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL)==false) {
					this.page.element(Locators.CANCEL, "css").clickUsingJSE();
				}
				this.selectFrame();
				assertTrue(this.page.element(EMR.Locators.RegionDefault.Locators.REGION_DEFAULT, "xpath").isElementPresent());
			}
		} catch (Exception e) {
			assertTrue(this.page.element(EMR.Locators.RegionDefault.Locators.REGION_DEFAULT, "xpath").isElementPresent());
		}
		return this;
	}

	public Login logOut() throws Exception {
		waitForElement.waitForElements(Locators.LOGOUT, "xpath");
		try{
			this.page.element(Locators.LOGOUT, "xpath").clickUsingJSE();
			waitForElement.waitForElements(Locators.USERNAME, "css");
			if (this.page.element(Locators.USERNAME, "css").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE) == false) {
				this.page.element(Locators.LOGOUT, "xpath").getOne().sendKeys(Keys.ENTER);
				waitForElement.waitForElements(Locators.USERNAME, "css");
			}
		} catch(Exception e) {
			this.page.element(Locators.LOGOUT, "xpath").clickUsingJSE();
			waitForElement.waitForElements(Locators.USERNAME, "css");
		}
		if (this.page.element(Locators.USERNAME, "css").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE) == false) {
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", this.page.element(Locators.LOGOUT, "xpath").getOne());
			waitForElement.waitForElements(Locators.USERNAME, "css");
		}
		return new Login(this.driver);
	}
	
	public Login loginToApplication(String username, String password)
			throws Exception {
		this.launchUrlAndVerifyUsernameField();
		this.enterUserName(username);
		this.enterPassword(password);
		this.clickOnLogin();
		return this;
	}
	
	public Login launchUrlAndVerifyUsernameField() throws Exception {
		driver.get("https://emresource.qa.intermedix.com/");
		//driver.navigate().to("https://emresource.qa.intermedix.com/");
		try{
			waitForElement.waitForElements(Locators.USERNAME, "css");
			assertTrue(this.page.element(Locators.USERNAME, "css").isElementPresent(), "UserName FIELD is not displayed");
		} catch (AssertionError ae) {
			if(this.page.element(Locators.LOGOUT, "xpath").getOne().isDisplayed()){
				this.logOut();
			}
		}
		return this;
	}
	
	public Login switchToDefaultWindow() throws Exception {
		driver.switchTo().defaultContent();
		return this;
	}
	
	public Login acknowledgeWebNotification() throws Exception {
		if (this.page.element(Locators.WEBNOTIFICATIONFRAME, "id").isElementPresent(
				WaitTimeConstants.WAIT_TIME_FOR_FALSE)) {
			wait.until(ExpectedConditions
					.frameToBeAvailableAndSwitchToIt(Locators.WEBNOTIFICATIONFRAME));
			waitForElement.waitForElements(Locators.ACKNOWLWDGENOTIFICATION, "xpath");
			this.page.element(Locators.ACKNOWLWDGENOTIFICATION, "xpath").mouseOver();
			this.page.element(Locators.ACKNOWLWDGENOTIFICATION, "xpath").getDisplayedOne().click();
			this.page.element_wait(Locators.ACKNOWLWDGENOTIFICATION, "xpath").waitForInvisibilityOfElement();
			this.switchToDefaultWindow();
			Thread.sleep(4000);
			shared.selectFrame();
		}
		return this;
	}
	
	public Login loginAsNewUser(String username, String password, String resetPassword)
			throws Exception {
		this.loginToApplication(username, password);
		this.resetPassword(password, resetPassword);
		return this;
	}
	
	public Login loginAsUser(String username, String password)
			throws Exception {
		this.loginToApplication(username, password);
		this.clickOnCancelOfSecurityQuestionPage();
		return this;
	}
	
	public Login loginAsAdmin(String username, String password, String RegionName) throws Exception {
		this.launchUrlAndVerifyUsernameField();
		this.enterUserName(username);
		this.enterPassword(password);
		this.clickOnLogin();
		selectRegion.selectRegionAndClickOnNext(RegionName);
		return this;
	}
	
	public Login verifyWebNotificationIsNotReceived() throws Exception {
		assertFalse(this.page.element(Locators.WEBNOTIFICATIONS_TITLE, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE),
				"web notification is present");
		return this;
	}
	
	public Login cancelSecurityQuestion()
			throws Exception {
		try {
			if (this.page.element(Locators.RESPONSE, "css").isElementPresent()) {
				waitForElement.waitForElements(Locators.RESPONSE, "css");
				this.page.element(Locators.CANCEL, "css").getOne().click();
				if(this.page.element(Locators.FRAME_DATA, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL)==false) {
					this.page.element(Locators.CANCEL, "css").clickUsingJSE();
				}
			}
		} catch (Exception e) {
		}
		return this;
	}
	
	public Login loginToRegionAsUser(String username, String password, String regionName)
			throws Exception {
		this.loginToApplication(username, password);
		this.cancelSecurityQuestion();
		this.acknowledgeWebNotification();
		selectRegion.selectRegionAndClickOnNext(regionName);
		this.acknowledgeWebNotification();
		return this;
	}
	
	public Login switchToWebNotificationFrame() throws Exception {
		try {
			wait.until(ExpectedConditions
					.frameToBeAvailableAndSwitchToIt(Locators.WEBNOTIFICATIONFRAME));
		} catch (Exception e) {
			
		}
		return this;
	}
	
	public Login answerToSecurityQuestion(String answer) throws Exception {
		try {
			if (this.page.element(Locators.RESPONSE, "css").isElementPresent()) {
				waitForElement.waitForElements(Locators.RESPONSE, "css");
				this.page.element(Locators.RESPONSE, "css").getDisplayedOne().sendKeys(answer);
				this.page.element(Locators.SUBMIT, "id").clickUsingJSE();
			}
		} catch (Exception e) {
		}
		return this;
	}
	
	public Login answerSecurityQuestionAndSubmit(String answer) throws Exception {
		this.switchToWebNotificationFrame();
		this.answerToSecurityQuestion(answer);
		this.clickOnSubmit();
		this.verifySuccessMessageOnSavigSecurityQuestion();
		return this;
	}
	
	public Login clickOnCloseOfWebNotification() throws Exception {
		waitForElement.waitForElements(Locators.CLOSE_OF_WEB_NOTIFICATION, "id");
	    this.page.element(Locators.CLOSE_OF_WEB_NOTIFICATION, "id").getDisplayedOne().click();
		return this;
	}
	
	public Login verifySuccessMessageOnSavigSecurityQuestion() throws Exception {
		waitForElement.waitForElements(Locators.SUCCESS_MESSAGE_SAVING_SECURITY_QUEST, "xpath");
	    assertTrue(this.page.element(Locators.SUCCESS_MESSAGE_SAVING_SECURITY_QUEST, "xpath").isElementPresent());
		return this;
	}
	
	public Login answerSecurityQuestionAndClose(String answer) throws Exception {
		this.answerSecurityQuestionAndSubmit(answer);
		this.selectFrame();
		this.clickOnCloseOfWebNotification();
		return this;
	}
	
	public Login launchWebEOC_Url() throws Exception {
		driver.navigate().to("https://emresource.qa.intermedix.com/EMSystem?uc=VIEWSTATUS&nextStep=VIEW_RSD&nextStepDetail=1965");
		return this;
	}
	
	public Login verifyUsernameField() throws Exception {
		waitForElement.waitForElements(Locators.USERNAME, "css");
		assertTrue(this.page.element(Locators.USERNAME, "css").isElementPresent());
		assertTrue(this.page.element(Locators.PASSWORD, "css").isElementPresent());
		return this;
	}
}