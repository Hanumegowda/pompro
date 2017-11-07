package page;

import module.Frames;

import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import qaframework.lib.WaitTimeConstants;
import qaframework.lib.pageObject.PageObject;
import qaframework.lib.userDefinedFunctions.WaitForElement;

public class AdministratorSettings extends PageObject {
	WebDriver driver;
	WaitForElement objWaitForElement;
	Frames objFrames;

	private String adminsettings = "//p/font/b[text()='Administrator Settings']",
			disableAdminAccount = "//a[text()='Click here to disable admin account']",
			enableAdminAccount = "//a[text()='Click here to enable admin account']",
			onlyOriginalAdminAccessThisPageMsg = "//font[contains(text(),'Only the original admin user can access this page.')]",
			enterNewPwd = "//input[@name='password1']",
			enterNewPwdAgain = "//input[@name='password2']",
			pwdChangesMessage = "//font[contains(text(),'Current password is required.')]",
			enterCurrentPwd = "//input[@name='passwordOld']";

	public AdministratorSettings(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
		objFrames =  new Frames(this.driver);
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Administrator Settings' page is displayed.
	* Date 		  : 30-Jun-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public AdministratorSettings verAdministratorSettingsPage()
			throws Exception {
		objFrames.switchToDefaultFrame();
		objFrames.switchToRightFrame();
		objFrames.switchToMainInRightFrame();
		objWaitForElement.waitForElements(adminsettings, "xpath");
		this.page.element(adminsettings, "xpath").isElementPresent();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'disable admin account' link.
	* Date 		  : 30-Jun-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public AdministratorSettings clickOnDisableAdminAccount() throws Exception {
		objWaitForElement.waitForElements(disableAdminAccount, "xpath");
		this.page.element(disableAdminAccount, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'enable admin account' link.
	* Date 		  : 30-Jun-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public AdministratorSettings clickOnEnableAdminAccount() throws Exception {
		objWaitForElement.waitForElements(enableAdminAccount, "xpath");
		this.page.element(enableAdminAccount, "xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	* Description : This function is to verify 'Only the original admin user can access this page' message 
	*               when admin group user click on administrator tab.
	* Date 		  : 30-Jun-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public AdministratorSettings verOnlyOriginalAdminAccessThisPageMsg()
			throws Exception {
		objFrames.switchToDefaultFrame();
		objFrames.switchToRightFrame();
		objFrames.switchToMainInRightFrame();
		objWaitForElement.waitForElements(onlyOriginalAdminAccessThisPageMsg,
				"xpath");
		this.page.element(onlyOriginalAdminAccessThisPageMsg, "xpath").getOne()
				.isDisplayed();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'disable admin account' link is absent.
	* Date 		  : 01-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public AdministratorSettings verDisableAdminAccountLinkIsAbsent()
			throws Exception {
		assertFalse(this.page.element(disableAdminAccount, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter password in 'Enter new password' field.
	* Date 		  : 02-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public AdministratorSettings enterNewPwd(String pwd) throws Exception {
		objWaitForElement.waitForElements(enterNewPwd, "xpath");
		this.page.element(enterNewPwd, "xpath").clearInputValue().sendKeys(pwd);
		return this;
	}

	/**********************************************************************************
	* Description : This function is to enter password in 'Enter new password again' field.
	* Date 		  : 02-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public AdministratorSettings enterNewPwdAgain(String pwd) throws Exception {
		objWaitForElement.waitForElements(enterNewPwdAgain, "xpath");
		this.page.element(enterNewPwdAgain, "xpath").clearInputValue()
				.sendKeys(pwd);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify error message displayed, when current password is not entered in admin settings page.
	* Date 		  : 02-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public AdministratorSettings verPwdMessage() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMessageInRightFrame();
		objWaitForElement.waitForElements(pwdChangesMessage, "xpath");
		assertTrue(this.page.element(pwdChangesMessage, "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter password in 'Enter current password' field.
	* Date 		  : 02-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public AdministratorSettings enterCurrentPwd(String pwd) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(enterCurrentPwd, "xpath");
		this.page.element(enterCurrentPwd, "xpath").clearInputValue()
				.sendKeys(pwd);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify error message not displayed, when current password is entered in admin settings page.
	* Date 		  : 02-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public AdministratorSettings verPwdMessageNotDisplayed() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMessageInRightFrame();
		objWaitForElement.waitForElements(pwdChangesMessage, "xpath");
		assertFalse(this.page.element(pwdChangesMessage, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}

}
