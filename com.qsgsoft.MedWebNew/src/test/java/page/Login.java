package page;

import static org.testng.Assert.assertTrue;
import module.Frames;

import org.openqa.selenium.WebDriver;

import qaframework.lib.userDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;

public class Login extends PageObject{
	
	WebDriver driver;
	WaitForElement objWaitForElement ;
	Frames objFrames;
	private String loginBtn = "//input[@type='submit'][@value='Login']",
			       userNameField = "//input[@type='text'][@name='credential_0']",
			       passWordField = "//input[@type='password'][@name='credential_1']",
			       InvalidCredentialErrMsg = "//tr/td[text()='invalid credentials']",
			       accountLockedErrMsg = "//td[text()='account locked']",
			       invalidGroup = "//td[text()='invalid group']",
			       accountLockedFor5MinErrMsg = "//td[text()='invalid credentials, account blocked for 5 min']",
			       accountLockedFor5MinErrMsg1 = "//td[text()='account blocked for 5 min']",
			       accountLockedInvalidCredErrMsg = "//td[text()='invalid credentials, account locked']",
			       changePwdErrMsg = "//td[contains(text(),'According to the security settings you are required to change your password.')]",
			       sessionsLimitErrorMsg = "//td[contains(text(),'number of sessions limit exceeded')]";
				  
	
	public Login(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement =  new WaitForElement(this.driver);
	    objFrames = new Frames(this.driver);
	}
	
	/**********************************************************************************
	  * Description : This function is to login to application as admin.
	  * Date        : 15-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public Login login(String userName, String passWord)
			throws Exception {
//		objFrames.switchToDefaultFrame().switchToRightFrame()
//		.switchToMainInRightFrame();
		enterUserName(userName);
		enterPassWord(passWord);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to login to application as admin.
	  * Date        : 15-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public Login loginAsUser(String userName, String passWord)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		enterUserName(userName);
		enterPassWord(passWord);
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to click on 'Login' button.
	  * Date        : 15-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public Login clickLogin() throws Exception {
		objWaitForElement.waitForElements(loginBtn, "xpath");
		this.page.element(loginBtn, "xpath").getOne().click();
		Thread.sleep(3000);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to check if login page is displayed.
	  * Date        : 15-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public boolean checkLoginPageIsDisplayed(String reqtitle) throws Exception {
		objWaitForElement.waitForElements(loginBtn, "xpath");
		String strtitle = driver.getTitle();
		if(strtitle.equals(reqtitle)){
			return true;
		}
		else {
		return false;
		}
	}
	
	/**********************************************************************************
	  * Description : This function is to enter text in user name field.
	  * Date        : 15-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public Login enterUserName(String userName) throws Exception {
		objWaitForElement.waitForElements(userNameField, "xpath");
		this.page.element(userNameField, "xpath").clearInputValue()
				.sendKeys(userName);
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to enter text in password field.
	  * Date        : 15-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public Login enterPassWord(String passWord) throws Exception {
		objWaitForElement.waitForElements(passWordField, "xpath");
		this.page.element(passWordField, "xpath").clearInputValue()
				.sendKeys(passWord);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to check 'Invalid Credential' Error Message is displayed.
	  * Date        : 17-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public Login verifyInvalidCredentialErrMsg() throws Exception {
		objWaitForElement.waitForElements(InvalidCredentialErrMsg, "xpath");
		assertTrue(this.page.element(InvalidCredentialErrMsg, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Account Locked' error message is displayed.
	  * Date        : 30-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public Login verAccountLockedErrMsg() throws Exception {
		objWaitForElement.waitForElements(accountLockedErrMsg, "xpath");
		this.page.element(accountLockedErrMsg, "xpath").getOne().isDisplayed();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Invalid Group' error message is displayed when, 
	  *               user from other than administrator group is try to login to administrator site.
	  * Date        : 06-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public Login verInvalidGroupErrMsg() throws Exception {
		objWaitForElement.waitForElements(invalidGroup, "xpath");
		assertTrue(this.page.element(invalidGroup, "xpath").getOne()
				.isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'invalid credentials, account blocked for 5 min' error message is displayed.
	  * Date        : 28-Jul-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public Login verErrMsgInvalidCredentialsAccountBlockedFor5Min() throws Exception {
		objWaitForElement.waitForElements(accountLockedFor5MinErrMsg, "xpath");
		assertTrue(this.page.element(accountLockedFor5MinErrMsg, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'account blocked for 5 min' error message is displayed.
	  * Date        : 28-Jul-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public Login verErrMsgAccountBlockedFor5Min() throws Exception {
		objWaitForElement.waitForElements(accountLockedFor5MinErrMsg1, "xpath");
		assertTrue(this.page.element(accountLockedFor5MinErrMsg1, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'invalid credentials, account locked' error message is displayed.
	  * Date        : 29-Jul-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public Login verErrMsgInvalidCredentialsAccountlLocked() throws Exception {
		objWaitForElement.waitForElements(accountLockedInvalidCredErrMsg, "xpath");
		assertTrue(this.page.element(accountLockedInvalidCredErrMsg, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is verify password change error message is displayed after password is expired.
	  * Date        : 29-Jul-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public Login verChangePwdErrMsg() throws Exception {
		objWaitForElement.waitForElements(changePwdErrMsg, "xpath");
		assertTrue(this.page.element(changePwdErrMsg, "xpath").getOne()
				.isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is verify number of sessions limit exceeded error message is displayed.
	  * Date        : 04-Aug-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public Login verSessionLimitExceededErrMsg() throws Exception {
		objWaitForElement.waitForElements(sessionsLimitErrorMsg, "xpath");
		assertTrue(this.page.element(sessionsLimitErrorMsg, "xpath").getOne()
				.isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to check 'Login Prompt Warning Banner' Message is displayed.
	  * Date        : 03-Aug-2016
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public Login verifyLoginPromptWarningBannerMsg(String mesg) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		String str = "//td[contains(text(),'"+mesg+"')]";
		objWaitForElement.waitForElements(str, "xpath");
		assertTrue(this.page.element(str, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify login page is displaying.
	  * Date        : 12-Oct-2016
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public Login verifyLoginPageIsDisplaying() throws Exception {
		objWaitForElement.waitForElements(userNameField, "xpath");
		objWaitForElement.waitForElements(passWordField, "xpath");
		assertTrue(this.page.element(userNameField, "xpath").isElementPresent());
		assertTrue(this.page.element(passWordField, "xpath").isElementPresent());
		return this;
	}

}
