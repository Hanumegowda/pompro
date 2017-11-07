package lib.page;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import qaframework.lib.WaitTimeConstants;
import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;

public class Login extends PageObject {

	WebDriver driver;
	WaitForElement objWaitForElement ;
	//Locators
	private String username = "input[name='loginName']",
				   password = "input[name='password']",
				   loginBtn = "input[value='Log In']",
				   currentPassword = "#currentPassword",
				   newPassword = "#newPassword",
				   confirmPassword = "#confirmPassword",
				   submitButton = "submitButton",
				   logout = "//ul[@id='subNavList']/li/a[contains(text(),'Log')]",//"//a[contains(@href,'logout')]",
				   invalidUserNameMsg = "//div[@id='login']/table/tbody/tr[3]/td[1]/span[text()='Invalid Username and/or Password']",
				   oldPassword = "#oldpassword",
				   proceed = "input[value='Proceed']",
				   webeocURL = "https://emresource.qa.intermedix.com/DL?key=4zcruexolvyjexnLaqGYEStPnIgtdI01&rid=1965",
				   setupnewpasswordPage="div[id='headingTitle']",
				   errorMsg="//div[@id='formErrors'][@class='errorBox']",
	               securityQuestion="//div[@id='headingTitle'][text()='Security Question and Answer']",
	               saveButton="input[value='Save']",
	               cancelButton="input[value='Cancel']",
	               tBAjexWindow="TB_ajaxWindowTitle",
	               helpLink = "Help",
	               intermedixLink = "www.intermedix.com",
	               forgotPasswordLink = "//a[@class='lowerLink'][contains(text(),'forgot password?')]",
	               warningMessage="//div[@class='web-service-user-error']",
	               clickHereToContinueLink="//a[text()='here']",
	               primaryEmail = "#username",
	               forgotUserNameLink = "//a[@class='lowerLink'][contains(text(),'forgot username?')]";
	
	
	public Login(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement =  new WaitForElement(this.driver);
	}

	/**********************************************************************************
	  * Description : This function is to click on 'Login' button
	  * Date        : 09/06/2014
	  * Author      : Anil
	  **********************************************************************************/
	public Login clickLogin() throws Exception {
		objWaitForElement.waitForElements(loginBtn, "css");
		this.page.element(loginBtn, "css").getOne().click();
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to enter username
	  * Date        : 09/06/2014
	  * Author      : Anil
	  **********************************************************************************/
	public Login enterUserName(String strusername) throws Exception {
		objWaitForElement.waitForElements(username, "css");
		this.page.element(username, "css").clearInputValue().sendKeys(strusername);
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to enter password
	  * Date        : 09/06/2014
	  * Author      : Anil
	  **********************************************************************************/
	public Login enterPassword(String strPassword) throws Exception {
		objWaitForElement.waitForElements(password, "css");
		this.page.element(password, "css").clearInputValue().sendKeys(strPassword);
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to enter new password
	  * Date        : 09/06/2014
	  * Author      : Anil
	  **********************************************************************************/
	public Login enterNewPassword(String strPassword) throws Exception {
		objWaitForElement.waitForElements(newPassword, "css");
		this.page.element(newPassword, "css").clearInputValue().sendKeys(strPassword);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter current password
	  * Date        : 23/02/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public Login enterCurrentPassword(String strPassword) throws Exception {
		objWaitForElement.waitForElements(currentPassword, "css");
		this.page.element(currentPassword, "css").clearInputValue().sendKeys(strPassword);
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to enter confirm password
	  * Date        : 09/06/2014
	  * Author      : Anil
	  **********************************************************************************/
	public Login enterConfirmPassword(String strPassword) throws Exception {
		objWaitForElement.waitForElements(confirmPassword, "css");
		this.page.element(confirmPassword, "css").clearInputValue().sendKeys(strPassword);
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to click on 'Submit' button
	  * Date        : 09/06/2014
	  * Author      : Anil
	  **********************************************************************************/
	public Login clickSubmit() throws Exception {
		objWaitForElement.waitForElements(submitButton, "name");
	    this.page.element(submitButton, "name").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to login to the application
	  * Date        : 09/06/2014
	  * Author      : Anil
	  **********************************************************************************/	
	public SelectRegion loginToApplication(String strUsername,
			String strPassword) throws Exception {
		driver.get("https://emresource.qa.intermedix.com/login");
		this.enterUserName(strUsername);
		this.enterPassword(strPassword);
		this.clickLogin();
		int intCount = 0;
		/*while (!((this.page.element("response", "id").isElementPresent())
				|| (this.page.element("regionID", "id")
						.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE))
				|| (this.page.element("//frame[@name='Data']", "xpath")
						.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE)) || intCount < 5)) {
			Thread.sleep(1000);
			intCount++;
		}*/
		try {
			if (this.page.element("response", "id").isElementPresent(WaitTimeConstants.WAIT_TIME_TOO_SMALL)) {
				objWaitForElement.waitForElements("response", "id");		
				this.page.element("input[value='Cancel']", "css").getOne()
						.click();
				Thread.sleep(5000);
			}
		} catch (Exception e) {

		}
		return new SelectRegion(this.driver);
	}

	/**********************************************************************************
	  * Description : This function is to login to the application as a new user
	  * Date        : 09/06/2014
	  * Author      : Anil
	  **********************************************************************************/	
	public SelectRegion loginAsNewUser(String strUsername, String strPassword)
			throws Exception {
		//driver.get("https://emresource.qa.intermedix.com/login");
		driver.navigate().to("https://emresource.qa.intermedix.com/login.jsp");
		this.enterUserName(strUsername);
		this.enterPassword("Abcd@1234");
		this.clickLogin();
		this.enterCurrentPassword("Abcd@1234");
		this.enterNewPassword(strPassword);
		this.enterConfirmPassword(strPassword);
		this.clickSubmit();
		this.verifySecurityQuestionAndAnswerPageAndClickOnCancel();
		return new SelectRegion(this.driver);
	}
	/**********************************************************************************
	  * Description : This function is to logout from the application 
	  * Date        : 09/06/2014
	  * Author      : Anil
	  **********************************************************************************/	

	public Login clickLogOut() throws Exception {
		objWaitForElement.waitForElements(logout, "xpath");
		this.page.element(logout, "xpath").getOne().click();
		return new Login(this.driver);
	}
	
	/**********************************************************************************
	  * Description : This function is to click on 'Login' button
	  * Date        : 09/06/2014
	  * Author      : Anil
	  **********************************************************************************/
	public Login clickLoginByNeewUSer() throws Exception {
		objWaitForElement.waitForElements(loginBtn, "name");
		this.page.element(loginBtn, "name").getOne().click();
		objWaitForElement.waitForElements(newPassword, "css");
		assertTrue(this.page.element(newPassword, "css").isElementPresent());
		return this;
	}

	/**********************************************************************************
	  * Description : This function is used to verify invalid username and password error message. 
	  * Date        : 05/08/2014
	  * Author      : Renushree
	 **********************************************************************************/	
	public Login verifyInvalidUsernameAndPwdError() throws Exception {
		objWaitForElement.waitForElements(invalidUserNameMsg, "xpath");
		assertTrue(this.page.element(invalidUserNameMsg, "xpath")
				.isElementPresent(),
				"Invalid Username and/or Password is not displayed.");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter old password
	  * Date        : 19/08/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public Login enterOldPassword(String strPassword) throws Exception {
		objWaitForElement.waitForElements(oldPassword, "css");
		this.page.element(oldPassword, "css").clearInputValue().sendKeys(strPassword);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on proceed.
	  * Date        : 19/08/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public Login clickOnProceed() throws Exception {
		objWaitForElement.waitForElements(proceed, "css");
		this.page.element(proceed, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to login to the application as a new user
	  * Date        : 25/09/2014
	  * Author      : Renushree
	  **********************************************************************************/	
	public SelectRegion loginAsNewUserToWebeoc(String strUsername, String strPassword)
			throws Exception {
		driver.get(webeocURL);
		this.enterUserName(strUsername);
		this.enterPassword("Abcd@1234");
		this.clickLogin();
		this.enterCurrentPassword("Abcd@1234");
		this.enterNewPassword(strPassword);
		this.enterConfirmPassword(strPassword);
		this.clickSubmit();this.verifySecurityQuestionAndAnswerPageAndClickOnCancel();
		return new SelectRegion(this.driver);
	}
	
	/**********************************************************************************
	  * Description : This function is to verify username
	  * Date        : 20/10/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public Login verifyUserName() throws Exception {
		objWaitForElement.waitForElements(username, "css");
		this.page.element(username, "css").isElementPresent();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify "Set Up Your Password" page is Displayed 
	  * Date        : 13/11/2014
	  * Author      : sangappa.k
	  **********************************************************************************/
	 public Login verifySetUpYourPasswordPage() throws Exception {
		 objWaitForElement.waitForElements(setupnewpasswordPage, "css");
		assertEquals("Password Setup",
				this.page.element(setupnewpasswordPage, "css").getOne()
						.getText());
		return this;
	}
	 
	 /**********************************************************************************
	  * Description : This function is to verify "New Passowrd" box is Displayed 
	  * Date        : 13/11/2014
	  * Author      : sangappa.k
	  **********************************************************************************/
	public Login verifyNewPasswordField() throws Exception {
		objWaitForElement.waitForElements(newPassword, "css");
		this.page.element(newPassword, "css").isElementPresent();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify "Verify Passowrd" box is Displayed 
	  * Date        : 13/11/2014
	  * Author      : sangappa.k
	  **********************************************************************************/
	public Login verifyVerifyPasswordField() throws Exception {
		objWaitForElement.waitForElements(confirmPassword, "css");
		this.page.element(confirmPassword, "css").isElementPresent();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify"the passwords you entered do not match" 
	                  comment after entering the new  password under change password in
	                  Preferences
	  * Date        : 13/11/2014
	  * Author      : sangappa.k
	  *******************************************************************************/
	 public Login verifyDonotMatchPasswordMsg() throws Exception {
		 objWaitForElement.waitForElements(errorMsg, "css");
		assertEquals("Invalid current password.", this.page
				.element(errorMsg, "xpath").getOne().getText());
		return this;
	}
	 
	/**********************************************************************************
	  * Description : This function is to login to the application
	  * Date        : 09/06/2014
	  * Author      : Anil
	  **********************************************************************************/	
	public SelectRegion loginToApplicationNew(String strUsername, String strPassword)
			throws Exception {
		driver.get("https://emresource.qa.intermedix.com/login");
		this.enterUserName(strUsername);
		this.enterPassword(strPassword);
		this.clickLogin();

		return new SelectRegion(this.driver);
	}

	/**********************************************************************************
	  * Description : This function is to login to the application
	  * Date        : 09/06/2014
	  * Author      : Anil
	  **********************************************************************************/	
	public SelectRegion loginToApplicationSecondTime(String strUsername,
			String strPassword, String strEmailID) throws Exception {
		driver.get("https://emresource.qa.intermedix.com/login");
		this.enterUserName(strUsername);
		this.enterPassword(strPassword);
		this.clickLogin();
		objWaitForElement.waitForElements(securityQuestion, "xpath");
		this.page.element("response", "id").clearInputValue().sendKeys("1234");
		String str = this.page.element("email", "id").getOne().getAttribute("value");
		if (str.equals(strEmailID)) {
			this.page.element(saveButton, "css").getOne().click();
			Thread.sleep(5000);
		}
		return new SelectRegion(this.driver);
	}
	
	/**********************************************************************************
	  * Description : This function is to launch EMResource URL
	  * Date        : 24-Apr-2015
	  * Author      : Pallavi
	  *******************************************************************************/
	 public Login launchEMRurl() throws Exception {
		 driver.get("https://emresource.qa.intermedix.com/login");
			//driver.get("javascript:document.getElementById('overridelink').click();");
		objWaitForElement.waitForElements(username, "css");
		return this;
	}
	 
		/**********************************************************************************
	  * Description : This function is to login to the application
	  * Date        : 09/06/2014
	  * Author      : Anil
	  **********************************************************************************/	
	public Login enterAnswer() throws Exception {
			objWaitForElement.waitForElements("response", "id");
			this.page.element("response", "id").clearInputValue()
			.sendKeys("1234");
			if((this.page.element("email", "id").getOne().getText()).equals("")){
				this.page.element("email", "id").clearInputValue()
				.sendKeys("autoemr@qsgsoft.com");
			}
			this.page.element("input[value='Save']", "css").getOne().click();
			Thread.sleep(5000);
			return this;
		
	}
	 /**********************************************************************************
	  * Description : This function is to login to the application
	  * Date        : 09/06/2014
	  * Author      : Anil
	  **********************************************************************************/	
	public SelectRegion loginSecondTimeAndCancel(String strUsername,
			String strPassword) throws Exception {
		driver.get("https://emresource.qa.intermedix.com/login");
		//driver.get("javascript:document.getElementById('overridelink').click();");
		this.enterUserName(strUsername);
		this.enterPassword(strPassword);
		this.clickLogin();
		objWaitForElement.waitForElements(securityQuestion, "xpath");
			this.page.element(cancelButton, "css").getOne().click();
			Thread.sleep(5000);
		return new SelectRegion(this.driver);
	}
	
	/**********************************************************************************
	 * Description : This function is to verify refine visible status types window is displayed.
	 * Date        : 12/08/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public Login verSecurityQuestionWindowIsNotDisplayed() throws Exception {
		assertFalse(this.page.element(tBAjexWindow, "id")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify password field.
	  * Date        : 24/June/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public Login verPasswordField() throws Exception {
		objWaitForElement.waitForElements(password, "css");
		assertTrue(this.page.element(password, "css").isElementPresent(),
				"Password field is not present.");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Login' button
	  * Date        : 24/June/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public Login verLoginButton() throws Exception {
		objWaitForElement.waitForElements(loginBtn, "css");
		assertTrue(this.page.element(loginBtn, "css").isElementPresent(),
				"Login button is not present.");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Help link
	  * Date        : 24/June/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public Login verHelpLink() throws Exception {
		objWaitForElement.waitForElements(helpLink, "linktext");
		assertTrue(this.page.element(helpLink, "linktext").isElementPresent(),
				"Help link is not present.");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify intermedix link
	  * Date        : 24/June/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public Login verIntermedixLink() throws Exception {
		objWaitForElement.waitForElements(intermedixLink, "linktext");
		assertTrue(this.page.element(intermedixLink, "linktext").isElementPresent(),
				"IntermedixLink link is not present.");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify copy right edition.
	  * Date        : 24/June/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public Login verCopyRightEdition(String strYear) throws Exception {
		objWaitForElement.waitForElements("//div[@id='footer']", "xpath");
		String strFooterInLoginPage = this.page.element("//div[@id='footer']", "xpath").getOne().getText();
		assertTrue(strFooterInLoginPage.contains("www.intermedix.com  © "+strYear+" Intermedix / EMSystems  All rights reserved"));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on 'Forgot password?' link
	  * Date        : 06/Aug/2015
	  * Author      : Sowmya
	  **********************************************************************************/
	public Login clkOnForgotPwdLink() throws Exception {
		objWaitForElement.waitForElements(forgotPasswordLink, "xpath");
		this.page.element(forgotPasswordLink, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on 'Forgot password?' link
	  * Date        : 06/Aug/2015
	  * Author      : Sowmya
	  **********************************************************************************/
	public Login clkOnForgotUserNameLink() throws Exception {
		objWaitForElement.waitForElements(forgotUserNameLink, "xpath");
		this.page.element(forgotUserNameLink, "xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	  * Description : This function is used to verify that a warning message is displayed when a web service 
	                  user logs into the application 
	  * Date        : 27/08/2015
	  * Author      : Sandhya M B
	 **********************************************************************************/	
	public Login verWebServiceAccountWarning() throws Exception {
		String actualMsg=this.page.element(warningMessage, "xpath").getOne().getText();
		String warningMsg = "Error\nWeb service accounts are not allowed to log in to EMResource. To obtain an account or for login assistance contact the Support Center by sending an email to support@intermedix.com or calling 1-888-735-9559, then press 1 for Client Application Support and 6 for EMSystems.\nNOTE: This will not affect the ability for web service accounts to programmatically interact with EMResource.\nClick here to return to the login page.";
		assertTrue(actualMsg.equals(warningMsg));
		return this;
	}

	/**********************************************************************************
	  * Description : This function is used to verify that user can proceed to application even though he 
	                  receives web service account warning 
	  * Date        : 31/08/2015
	  * Author      : Sandhya M B
	 * @return 
	 **********************************************************************************/	
	public Login verWebServiceUserProceedToAppln() throws Exception {
		this.page.element(clickHereToContinueLink, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to login to the application as a new user
	  * Date        : 09/06/2014
	  * Author      : Anil
	  **********************************************************************************/	
	public SelectRegion loginAsNewUserForPasswordChange(String strUsername, String strPassword)
			throws Exception {
		driver.get("https://emresource.qa.intermedix.com/login");
		this.enterUserName(strUsername);
		this.enterPassword(strPassword);
		this.clickLogin();
		this.enterCurrentPassword(strPassword);
		this.enterNewPassword(strPassword);
		this.enterConfirmPassword(strPassword);
		this.clickSubmit();
		return new SelectRegion(this.driver);
	}
	/**********************************************************************************
	  * Description : This function is to enter old password
	  * Date        : 19/08/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public Login enterPrimaryEmail(String strPrimaryEmail) throws Exception {
		objWaitForElement.waitForElements(primaryEmail, "css");
		this.page.element(primaryEmail, "css").clearInputValue().sendKeys(strPrimaryEmail);
		return this;
	}
	/**********************************************************************************
	  * Description : This function is to click on cancel button
	  * Date        : 19/08/2014
	  * Author      : Anil
	  **********************************************************************************/
	public Login clickOnCancel() throws Exception {
		objWaitForElement.waitForElements(cancelButton, "css");
		this.page.element(cancelButton, "css").getOne().click();
		return this;
	}

	public Login verifySecurityQuestionAndAnswerPageAndClickOnCancel() throws Exception {
		Thread.sleep(2000);
		try {
			if (this.page.element("response", "id").isElementPresent(WaitTimeConstants.WAIT_TIME_TOO_SMALL)) {
				assertTrue(this.page.element("//div[@id='headingTitle'][text()='Security Question and Answer']", "xpath").isElementPresent());
				objWaitForElement.waitForElements("response", "id");		
				this.page.element("input[value='Cancel']", "css").getOne()
				.click();
				Thread.sleep(5000);
			}
		} catch (Exception e) {

		}
		return this;
	}
	
	public Login verifyAndAnswerSecurityQuestion() throws Exception {
		Thread.sleep(2000);
		try {
			if (this.page.element("response", "id").isElementPresent(WaitTimeConstants.WAIT_TIME_TOO_SMALL)) {
				assertTrue(this.page.element("//div[@id='headingTitle'][text()='Security Question and Answer']", "xpath").isElementPresent());
				objWaitForElement.waitForElements("response", "id");
				this.page.element("response", "id").clearInputValue().sendKeys("1234");
				this.page.element("input[value='Save']", "css").getOne().click();
				Thread.sleep(5000);
			}
		} catch (Exception e) {

		}
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to login to the application as a new user by answering security question
	  * Date        : 26-Sept-2016
	  * Author      : Pallavi
	  **********************************************************************************/	
	public SelectRegion loginAsNewUserAndAnswerSecurityQuestion(String strUsername, String strPassword)
			throws Exception {
		driver.get("https://emresource.qa.intermedix.com/login");
		this.enterUserName(strUsername);
		this.enterPassword("Abcd@1234");
		this.clickLogin();
		this.enterCurrentPassword("Abcd@1234");
		this.enterNewPassword(strPassword);
		this.enterConfirmPassword(strPassword);
		this.clickSubmit();
		this.verifyAndAnswerSecurityQuestion();
		return new SelectRegion(this.driver);
	}
	
	
	/**********************************************************************************
	  * Description : This function is to verify Login page
	  * Date        : 3-Oct-2016
	  * Author      : Sangappa k
	  **********************************************************************************/
	public Login verifyLoginPage() throws Exception {
		this.verifyUserName();
		this.verifyVerifyPasswordField();
		this.verLoginButton();
		return this;
	}
}