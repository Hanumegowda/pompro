package lib.page;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import qaframework.lib.WaitTimeConstants;
import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;

public class ChangePassword extends PageObject{

	WebDriver driver;
	WaitForElement objWaitForElement;
	
	private String headerName = "div#topSubNav > h1",
				   strFrame = "TB_iframeContent",
				   here = "here",
				   headingtitle = "#headingTitle",
				   subTitle = "#headingSubtitle",
				   newPassword = "#newPassword",
				   confirmPassword = "#confirmPassword",
				   submit = "#submitButton",
				   close = "#TB_closeWindowButton",
				   strMainFrame = "Data",
				   popUpErrorMsg="formErrors",
				   resetYourPwdPage = "//div[@id='headingTitle'][text()='Reset Your Password']",
				   usernameInputInResetYourPwdPage = "username",
				   submitBtnInResetYourPwdPage = "submitButton",
				   verificationStatusPage = "//div[@id='maintenance']/div[text()='Verification Status']/following-sibling::div[text()='Your username has been verified. Check your email for more information.']",
				   securityQuestionPage = "//div[@id='headingTitle'][text()='Security Question']",
				   question = "headingSubtitle",
				   answerInputField = "response",
				   passwordStatusPage = "//div[@id='headingTitle'][text()='Password Status']/following-sibling::div[text()='Password set or changed successfully.']",
				   currentPassword = "#currentPassword",
				   setUpQuestionTextDetails = "//div[@id='headingSubtitle'][text()='Set up a question and answer to help verify your identity should you forget your password.']",
				   cancel = "input[value='Cancel']";
	
	public ChangePassword(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
	}

	/**********************************************************************************
	 * Description 	: This function is to verify change password screen is displayed.
	 * Date 		: 09/10/2014  
	 * Author 		: Renushree
	 **********************************************************************************/
	public ChangePassword verChangePasswordScreenIsDisplayed()
			throws Exception {
		objWaitForElement.waitForElements(headerName, "css");
		assertEquals("Change Password", this.page.element(headerName, "css")
				.getOne().getText());
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify change password screen is displayed.
	 * Date 		: 09/10/2014  
	 * Author 		: Renushree
	 **********************************************************************************/
	public ChangePassword verChangePwdScreenWithClickHere() throws Exception {
		assertTrue(this.page
				.element(
						"//div[@id='mainContainer']/table/tbody/tr/td[contains(text(),'If the Change Password dialog box did not open automatically, change your password by clicking')]",
						"xpath").isElementPresent());
		assertTrue(this.page.element(here, "linktext").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to switch to the change password frame.
	 * Date 		: 09/10/2014  
	 * Author 		: Renushree
	 **********************************************************************************/
	public ChangePassword switchTochangePwdFrame() throws Exception {
		WebDriverWait wait = new WebDriverWait(this.driver, WaitTimeConstants.WAIT_TIME_LONG);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(strFrame));
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify change password window.
	 * Date 		: 09/10/2014  
	 * Author 		: Renushree
	 **********************************************************************************/
	public ChangePassword verChangePwdWindow() throws Exception {
		objWaitForElement.waitForElements(headingtitle, "css");
		assertEquals("Password Setup", this.page.element(headingtitle, "css")
				.getOne().getText());
		assertEquals("Enter and confirm a new password.", this.page.element(subTitle, "css")
				.getOne().getText());
		assertTrue(this.page.element(newPassword, "css").isElementPresent());
		assertTrue(this.page.element(confirmPassword, "css").isElementPresent());
		assertTrue(this.page.element(submit, "css").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to enter new password
	 * Arguments	: strNewPassword
	 * Date 		: 09/10/2014  
	 * Author 		: Renushree
	 **********************************************************************************/
	public ChangePassword enterNewPassword(String strNewPassword) throws Exception {
		objWaitForElement.waitForElements(newPassword, "css");
		this.page.element(newPassword, "css").clearInputValue().sendKeys(strNewPassword);
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to enter new password
	 * Arguments	: strConfirmPassword
	 * Date 		: 09/10/2014  
	 * Author 		: Renushree
	 **********************************************************************************/
	public ChangePassword enterConfirmPassword(String strConfirmPassword) throws Exception {
		this.page.element(confirmPassword, "css").clearInputValue().sendKeys(strConfirmPassword);
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to enter new password
	 * Date 		: 09/10/2014  
	 * Author 		: Renushree
	 **********************************************************************************/
	public ChangePassword clickOnSubmit() throws Exception {
		objWaitForElement.waitForElements(submit, "css");
		this.page.element(submit, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to enter new password
	 * Date 		: 09/10/2014  
	 * Author 		: Renushree
	 **********************************************************************************/
	public ChangePassword changePassword(String strNewPassword,
			String strConfirmPassword) throws Exception {
		this.enterNewPassword(strNewPassword);
		this.enterConfirmPassword(strConfirmPassword);
		this.clickOnSubmit();
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify password status screen is displayed.
	 * Date 		: 09/10/2014  
	 * Author 		: Renushree
	 **********************************************************************************/
	public ChangePassword verPasswordStatusScreenIsDisplayed() throws Exception {
		this.driver
				.manage()
				.timeouts()
				.implicitlyWait(WaitTimeConstants.WAIT_TIME_SMALL,
						TimeUnit.SECONDS);
		objWaitForElement.waitForElements(headingtitle, "css");
		assertEquals("Set Up Your Password", this.page.element(headingtitle, "css")
				.getOne().getText());
		assertEquals("Password set or changed successfully.", this.page
				.element(subTitle, "css").getOne().getText());
		driver.switchTo().defaultContent();
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to click on close 
	 * Date 		: 09/10/2014  
	 * Author 		: Renushree
	 **********************************************************************************/
	public ChangePassword clickOnClose() throws Exception {
		WebDriverWait wait = new WebDriverWait(this.driver,
				WaitTimeConstants.WAIT_TIME_LONG);
		wait.until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(strMainFrame));
		this.page.element(close, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verfiy error message the passwords you entered do    
	                  not match  in Pop Up when mismatch in new password & confirm password
	  * Date        : 13/11/2014
	  * Author      : sangappa.k
	  **********************************************************************************/
	public ChangePassword verifyDonotMatchPasswordMsgInPopUp() throws Exception {
		objWaitForElement.waitForElements(popUpErrorMsg, "id");
		assertTrue(this.page.element(popUpErrorMsg, "id").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify password status screen is displayed.
	 * Date 		: 09/10/2014  
	 * Author 		: Anil
	 **********************************************************************************/
	public ChangePassword verPasswordStatusScreenIsDisplayedNew() throws Exception {
		this.driver
				.manage()
				.timeouts()
				.implicitlyWait(WaitTimeConstants.WAIT_TIME_SMALL,
						TimeUnit.SECONDS);
		objWaitForElement.waitForElements(headingtitle, "css");
		assertEquals("Password Status", this.page.element(headingtitle, "css")
				.getOne().getText());
		driver.switchTo().defaultContent();
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify change password screen is not displayed.
	 * Date 		: 27/04/2015  
	 * Author 		: Renushree
	 **********************************************************************************/
	public ChangePassword verChangePasswordScreenIsNotDisplayed()
			throws Exception {
		objWaitForElement.waitForElements(headerName, "css");
		assertNotEquals("Change Password", this.page.element(headerName, "css")
				.getOne().getText());
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify change password screen is not displayed immediately after login
	 * Date 		: 04-Jun-2015  
	 * Author 		: Pallavi
	 **********************************************************************************/
	public ChangePassword verSetUpYourPswdScreenIsNotDisplayed()
			throws Exception {
		assertFalse(this.page.element(headingtitle, "css")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify 'Reset Your Password' page is displayed
	 * Date 		: 06-Aug-2015  
	 * Author 		: Sowmya
	 **********************************************************************************/
	public ChangePassword verResetYourPwdPageIsDisplayed() throws Exception {
		objWaitForElement.waitForElements(resetYourPwdPage, "xpath");
		assertTrue(this.page.element(resetYourPwdPage, "xpath")
				.isElementPresent());
		return this;
	}
	
	/************************************************************************************
	 * Description 	: This function is to enter 'Username' in 'Reset Your Password' page 
	 * Date 		: 06-Aug-2015  
	 * Author 		: Sowmya
	 ************************************************************************************/
	public ChangePassword enterUserNameInResetYourPwdPage(String strUsername)
			throws Exception {
		objWaitForElement
				.waitForElements(usernameInputInResetYourPwdPage, "id");
		this.page.element(usernameInputInResetYourPwdPage, "id").getOne()
				.sendKeys(strUsername);
		return this;
	}
	
	/*******************************************************************************************
	 * Description 	: This function is to click on 'Submit' button in 'Reset Your Password' page 
	 * Date 		: 06-Aug-2015  
	 * Author 		: Sowmya
	 ******************************************************************************************/
	public ChangePassword clkOnSubmitBtnInResetYourPwdPage() throws Exception {
		objWaitForElement.waitForElements(submitBtnInResetYourPwdPage, "id");
		this.page.element(submitBtnInResetYourPwdPage, "id").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify 'Verificaiton Status' page is displayed
	 * Date 		: 06-Aug-2015  
	 * Author 		: Sowmya
	 **********************************************************************************/
	public ChangePassword verVerificationStatusPage() throws Exception {
		objWaitForElement.waitForElements(verificationStatusPage, "xpath");
		assertTrue(this.page.element(verificationStatusPage, "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to answer for the sequrity question
	  * Arguments	: strQuestion
	  * Date        : 06/08/2015
	  * Author      : Sowmya
	  **********************************************************************************/	
	public RegionDefault verQuestionAndEnterAnswerInSecurityQuesPage(
			String strQuestion, String strAnswer) throws Exception {
		objWaitForElement.waitForElements(securityQuestionPage, "xpath");
		assertTrue(this.page.element(securityQuestionPage, "xpath")
				.isElementPresent());
		String str = this.page.element(question, "id").getOne()
				.getText();
		System.out.println("Question: " + str);
		if (str.equals(strQuestion)) {
			this.page.element(answerInputField, "id").clearInputValue()
					.sendKeys(strAnswer);
			this.page.element(submitBtnInResetYourPwdPage, "id").getOne()
					.click();
			Thread.sleep(5000);
		}
		return new RegionDefault(this.driver);
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify 'Password Status' page is displayed
	 * Date 		: 06-Aug-2015  
	 * Author 		: Sowmya
	 **********************************************************************************/
	public ChangePassword verPasswordStatusPage() throws Exception {
		objWaitForElement.waitForElements(passwordStatusPage, "xpath");
		assertTrue(this.page.element(passwordStatusPage, "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter current password
	  * Date        : 23/02/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public ChangePassword enterCurrentPassword(String strPassword) throws Exception {
		objWaitForElement.waitForElements(currentPassword, "css");
		this.page.element(currentPassword, "css").clearInputValue().sendKeys(strPassword);
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to change password under Preferences>>Change password
	 * Date 		: 10/15/2015
	 * Author 		: Sangappa.K
	 **********************************************************************************/
	public ChangePassword changePasswordUnderPref(String strCurrentPassword,String strNewPassword,
			String strConfirmPassword) throws Exception {
		this.enterCurrentPassword(strCurrentPassword);
		this.enterNewPassword(strNewPassword);
		this.enterConfirmPassword(strConfirmPassword);
		this.clickOnSubmit();
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify change password screen is displayed.
	 * Date 		: 09/10/2014  
	 * Author 		: Renushree
	 **********************************************************************************/
	public ChangePassword verChangePwdScreenWithClickHere(String strUserName,
			String strUserFullName) throws Exception {
		assertTrue(this.page
				.element(
						"//div[@id='mainContainer']/table/tbody/tr/td[contains(text(),'If the Change Password dialog box did not open automatically, change the password for "
								+ strUserFullName
								+ " ("
								+ strUserName
								+ ") by clicking ')]", "xpath")
				.isElementPresent());
		assertTrue(this.page.element(here, "linktext").isElementPresent());
		return this;
	}

	/**********************************************************************************
	 * Description 	: This function is to click on here link
	 * Date 		: 17/02/2016  
	 * Author 		: Renushree
	 **********************************************************************************/
	public ChangePassword clickOnHere() throws Exception {
		this.page.element(here, "linktext").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify change password screen is displayed.
	 * Date 		: 09/10/2014  
	 * Author 		: Renushree
	 **********************************************************************************/
	public ChangePassword clickOnResetYourPasswordText()
			throws Exception {
		this.page.element(headerName, "css")
		.getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to answer for the security question page details
	  * Arguments	: 
	  * Date        : 19-Dec-2016
	  * Author      : Pallavi
	  **********************************************************************************/	
	public ChangePassword verQuestionAndEnterAnswerInSecurityQuesPage() throws Exception {
		objWaitForElement.waitForElements(securityQuestionPage, "xpath");
		assertTrue(this.page.element(securityQuestionPage, "xpath")
				.isElementPresent());
		assertTrue(this.page.element(setUpQuestionTextDetails, "xpath").isElementPresent(), setUpQuestionTextDetails+" text was not present.");
		driver.switchTo().defaultContent();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to answer for the security question page details
	  * Arguments	: 
	  * Date        : 19-Dec-2016
	  * Author      : Pallavi
	  **********************************************************************************/	
	public ChangePassword clickOnCancel() throws Exception {
		objWaitForElement.waitForElements(cancel, "css");
		assertTrue(this.page.element(cancel, "css").isElementPresent());
		this.page.element(cancel, "css").getDisplayedOne().click();
		return this;
	}
}