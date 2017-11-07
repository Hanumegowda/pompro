package lib.page;

import org.openqa.selenium.WebDriver;
import qaframework.lib.WaitTimeConstants;
import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;
import static org.testng.Assert.*;
public class SecurityQuestion extends PageObject {

	WebDriver driver;
	WaitForElement objWaitForElement ;

	private String headingTitle = "#headingTitle",
				   headingSubtitle = "#headingSubtitle",
				   securityQuestion = "//tr/td/label[contains(text(), '*Question')]/parent::td/following-sibling::td/span/select",
				   securityAnswer = "//tr/td/label[contains(text(), '*Answer')]/parent::td/following-sibling::td/span/input",
				   securityEmail = "//tr/td/label[contains(text(), '*Email Address')]/parent::td/following-sibling::td/span/input",
				   saveButton = "#submitButton",
				   closeButton = "//a[@title='Close']",
				   cancelButton = "input[value='Cancel']",
				   emailAddress = "email",
				   securityQuestionLink = "//td/a[text()='Security Question']",
				   challengeSetupLink = "//td/a[text()='Challenge Setup']";
	
	public SecurityQuestion(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement =  new WaitForElement(this.driver);
	}

	/**********************************************************************************
	  * Description : This function is to verify 'Security Question and Answer' pop up
	  * Date        : 24-Apr-2015
	  * Author      : Pallavi
	  **********************************************************************************/
	public SecurityQuestion verifySecurityQuestionAndAnswerHeading() throws Exception {
		objWaitForElement.waitForElements(headingTitle, "css");
		assertEquals(this.page.element(headingTitle, "css").getOne().getText(),
				"Security Question and Answer");
		assertEquals(
				this.page.element(headingSubtitle, "css").getOne().getText(),
				"Set up a question and answer to help verify your identity should you forget your password.");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Security Question and Answer' page is not displayed
	  * Date        : 24-Apr-2015
	  * Author      : Pallavi
	  **********************************************************************************/
	public SecurityQuestion verifySecurityQuestionPageNotDisplayed()
			throws Exception {
		assertFalse(this.page.element(headingTitle, "css").isElementPresent(
				WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select Security Question
	  * Date        : 24-Apr-2015
	  * Author      : Pallavi
	  **********************************************************************************/
	public SecurityQuestion selectSecurityQuestion(String strQuestion)
			throws Exception {
		objWaitForElement.waitForElements(securityQuestion, "xpath");
		this.page.element(securityQuestion, "xpath").webElementToSelect().selectByVisibleText(strQuestion);
		assertTrue(this.page.element(securityQuestion, "xpath")
				.webElementToSelect().getFirstSelectedOption().getText()
				.equals(strQuestion));
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to enter Security Answer
	  * Date        : 24-Apr-2015
	  * Author      : Pallavi
	  **********************************************************************************/
	public SecurityQuestion enterSecurityAnswer(String strAnswer)
			throws Exception {
		objWaitForElement.waitForElements(securityAnswer, "xpath");
		this.page.element(securityAnswer, "xpath").getOne()
				.sendKeys(strAnswer);
		assertTrue(this.page.element(securityAnswer, "xpath").getOne()
				.getAttribute("value").equals(strAnswer));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter Security Email on pop up
	  * Date        : 24-Apr-2015
	  * Author      : Pallavi
	  **********************************************************************************/
	public SecurityQuestion enterEmailAddress(String strEmail)
			throws Exception {
		objWaitForElement.waitForElements(securityEmail, "xpath");
		this.page.element(securityEmail, "xpath").getOne()
				.sendKeys(strEmail);
		assertTrue(this.page.element(securityEmail, "xpath").getOne()
				.getAttribute("value").equals(strEmail));
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to verify Security Question pop up
	  * Date        : 24-Apr-2015
	  * Author      : Pallavi
	  **********************************************************************************/
	public SecurityQuestion verifySecurityQuestion(String strQuestion)
			throws Exception {
		objWaitForElement.waitForElements(securityQuestion, "xpath");
		assertTrue(this.page.element(securityQuestion, "xpath")
				.webElementToSelect().getFirstSelectedOption().getText()
				.equals(strQuestion));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Security Answer pop up
	  * Date        : 24-Apr-2015
	  * Author      : Pallavi
	  **********************************************************************************/
	public SecurityQuestion verifySecurityAnswer(String strAnswer)
			throws Exception {
		objWaitForElement.waitForElements(securityAnswer, "xpath");
		assertTrue(this.page.element(securityAnswer, "xpath").getOne()
				.getAttribute("value").equals(strAnswer));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Security Email provided on pop up
	  * Date        : 24-Apr-2015
	  * Author      : Pallavi
	  **********************************************************************************/
	public SecurityQuestion verifyEmailAddress(String strEmail)
			throws Exception {
		objWaitForElement.waitForElements(securityEmail, "xpath");
		assertTrue(this.page.element(securityEmail, "xpath").getOne()
				.getAttribute("value").equals(strEmail));
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to click on save button
	  * Date        : 24-Apr-2015
	  * Author      : Pallavi
	  **********************************************************************************/
	public SecurityQuestion clickOnSave() throws Exception {
		objWaitForElement.waitForElements(saveButton, "css");
		assertTrue(this.page.element(saveButton, "css").isElementPresent());
		this.page.element(saveButton, "css").getOne().click();
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to verify confirmation after saving the security Question and Answer
	  * Date        : 24-Apr-2015
	  * Author      : Pallavi
	  **********************************************************************************/
	public SecurityQuestion verifyConfirmationAfterSaving() throws Exception {
		objWaitForElement.waitForElements(headingSubtitle, "css");
		assertTrue(this.page.element(headingSubtitle, "css").isElementPresent());
		assertTrue(this.page.element(headingTitle, "css").getOne().getText()
				.equals("Security Question"));
		assertTrue(this.page.element(headingSubtitle, "css").getOne().getText()
				.equals("Your security question and answer have been saved."));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify confirmation after saving the security Question and Answer
	  * Date        : 24-Apr-2015
	  * Author      : Pallavi
	  **********************************************************************************/
	public SecurityQuestion clickOnClose() throws Exception {
		objWaitForElement.waitForElements(closeButton, "xpath");
		this.page.element(closeButton, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify validation message when screen is kept idle for 5 minutes
	  * Date        : 27-Apr-2015
	  * Author      : Pallavi
	  **********************************************************************************/
	public SecurityQuestion verifyValidationMsgWhenScreenIsIdleFor5Mins()
			throws Exception {
		objWaitForElement.waitForElements(headingSubtitle, "css");
		assertTrue(this.page.element(headingSubtitle, "css").isElementPresent());
		assertTrue(this.page.element(headingTitle, "css").getOne().getText()
				.equals("Timed Out"));
		assertTrue(this.page
				.element(headingSubtitle, "css")
				.getOne()
				.getText()
				.equals("The Security Question page has timed out. Access your account or profile to set or change your security question."));
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to click on cancel button
	  * Date        : 28-Apr-2015
	  * Author      : Pallavi
	  **********************************************************************************/
	public SecurityQuestion clickOnCancel() throws Exception {
		objWaitForElement.waitForElements(cancelButton, "css");
		assertTrue(this.page.element(cancelButton, "css").isElementPresent());
		this.page.element(cancelButton, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Email Address text field is empty in 'Security Question and Answer' alert pop up.
	  * Date        : 27-Apr-2015
	  * Author      : Hanumegowda
	  *******************************************************************************/
	public SecurityQuestion verEmailAddressTextFiledIsEmpty() throws Exception {
		objWaitForElement.waitForElements(emailAddress, "id");
		String str = this.page.element(emailAddress, "id").getOne()
				.getAttribute("value");
		assertEquals(str, "");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Security Question' Link is displayed under preferences.
	  * Date        : 28-Apr-2015
	  * Author      : Hanumegowda
	  *******************************************************************************/
	public SecurityQuestion verSecurityQuestionLinkIsDisplayedUnderPreferences()
			throws Exception {
		objWaitForElement.waitForElements(securityQuestionLink, "xpath");
		assertTrue(this.page.element(securityQuestionLink, "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'challenge Setup' Link is displayed under preferences.
	  * Date        : 28-Apr-2015
	  * Author      : Hanumegowda
	  *******************************************************************************/
	public SecurityQuestion verChallengeSetupLinkIsNotDisplayedUnderPreferences()
			throws Exception {
		assertFalse(this.page.element(challengeSetupLink, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
}

