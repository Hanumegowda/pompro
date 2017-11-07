package page;

import module.Frames;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import qaframework.lib.pageObject.PageObject;
import qaframework.lib.userDefinedFunctions.WaitForElement;

public class SecurityDefaults extends PageObject{
	WebDriver driver;
	WaitForElement objWaitForElement;
	Frames objFrames;
	
	private String securityDefaults = "//b[text()='Security Defaults']",
			       accountLocks = "accountlocks",
			       lockfor5min = "//input[@type='RADIO'][@value='5min']",
			       adminShouldUnlock = "//input[@type='RADIO'][@value='lock']",
			       passwordObvious = "password_obvious",
			       enablePasswordExpiration = "password_expiration",
			       usersPasswordExpiresInDays = "//input[@type='TEXT'][@name='passwordexpires']",
			       newUsersWithExpiredPasswords = "expire_all_new",
			       passwords = "passwd_history",
			       days = "passwd_aging",
			       automaticallyLogout = "idletime",
			       limitSessions = "sessions_allowed",
			       strongSecurityPolicyChkbx = "strong_passwd";
	
	public SecurityDefaults(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
		objFrames = new Frames(this.driver);
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Security Defaults' page is displayed.
	* Date 		  : 28-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public SecurityDefaults verSecurityDefaultsPage()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(securityDefaults, "xpath");
		assertTrue(this.page.element(securityDefaults, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter number in 'Number of User Authentication failures before lock' textbox.
	* Date 		  : 28-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public SecurityDefaults enterAccountlocks(String locknum)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(accountLocks, "name");
		this.page.element(accountLocks, "name").clearInputValue().sendKeys(locknum);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Lock for 5 min' radio button.
	* Date 		  : 28-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public SecurityDefaults selectLockfor5min()
			throws Exception {
		objWaitForElement.waitForElements(lockfor5min, "xpath");
		if(this.page.element(lockfor5min, "xpath").getOne().isSelected()==false){
			this.page.element(lockfor5min, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Admin should unlock' radio button.
	* Date 		  : 29-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public SecurityDefaults selectAdminShouldUnlock()
			throws Exception {
		objWaitForElement.waitForElements(adminShouldUnlock, "xpath");
		if(this.page.element(adminShouldUnlock, "xpath").getOne().isSelected()==false){
			this.page.element(adminShouldUnlock, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Check if password is obvious' checkbox.
	* Date 		  : 29-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public SecurityDefaults selectPasswordObvious ()
			throws Exception {
		objWaitForElement.waitForElements(passwordObvious, "name");
		if(this.page.element(passwordObvious, "name").getOne().isSelected()==false){
			this.page.element(passwordObvious, "name").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to deselect 'Check if password is obvious' checkbox.
	* Date 		  : 29-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public SecurityDefaults deSelectPasswordObvious ()
			throws Exception {
		objWaitForElement.waitForElements(passwordObvious, "name");
		if(this.page.element(passwordObvious, "name").getOne().isSelected()==true){
			this.page.element(passwordObvious, "name").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Enable password expiration' checkbox.
	* Date 		  : 29-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public SecurityDefaults selectEnablePasswordExpirationCheckBox ()
			throws Exception {
		objWaitForElement.waitForElements(enablePasswordExpiration, "name");
		if(this.page.element(enablePasswordExpiration, "name").getOne().isSelected()==false){
			this.page.element(enablePasswordExpiration, "name").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to deselect 'Enable password expiration' checkbox.
	* Date 		  : 29-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public SecurityDefaults deSelectEnablePasswordExpirationCheckBox ()
			throws Exception {
		objWaitForElement.waitForElements(enablePasswordExpiration, "name");
		if(this.page.element(enablePasswordExpiration, "name").getOne().isSelected()==true){
			this.page.element(enablePasswordExpiration, "name").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in ' User's password expires in' field.
	* Date 		  : 29-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public SecurityDefaults enterTextInUsersPasswordExpiresInField (String days)
			throws Exception {
		objWaitForElement.waitForElements(usersPasswordExpiresInDays, "xpath");
			this.page.element(usersPasswordExpiresInDays, "xpath").clearInputValue().sendKeys(days);
		
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Create all new users with expired passwords ' checkbox.
	* Date 		  : 30-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public SecurityDefaults selectCreateNewUsersWithExpiredPwdsCheckBox ()
			throws Exception {
		objWaitForElement.waitForElements(newUsersWithExpiredPasswords, "name");
		if(this.page.element(newUsersWithExpiredPasswords, "name").getOne().isSelected()==false){
			this.page.element(newUsersWithExpiredPasswords, "name").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to deselect 'Create all new users with expired passwords ' checkbox.
	* Date 		  : 30-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public SecurityDefaults deSelectCreateNewUsersWithExpiredPwdsCheckBox ()
			throws Exception {
		objWaitForElement.waitForElements(newUsersWithExpiredPasswords, "name");
		if(this.page.element(newUsersWithExpiredPasswords, "name").getOne().isSelected()==true){
			this.page.element(newUsersWithExpiredPasswords, "name").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'How many new passwords a user must create
	*               before they can reuse an old password' field.
	* Date 		  : 03-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public SecurityDefaults enterNumInNewPasswordsField(String newpwdnum)
			throws Exception {
		objWaitForElement.waitForElements(passwords, "name");
		this.page.element(passwords, "name").clearInputValue().sendKeys(newpwdnum);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Minimum number of days a password must be in effect' field.
	* Date 		  : 03-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public SecurityDefaults enterNumInDaysField(String day)
			throws Exception {
		objWaitForElement.waitForElements(days, "name");
		this.page.element(days, "name").clearInputValue().sendKeys(day);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Automatically logout after specified idle time' field.
	* Date 		  : 03-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public SecurityDefaults enterTextInAutoLogoutIdleField(String days)
			throws Exception {
		objWaitForElement.waitForElements(automaticallyLogout, "name");
			this.page.element(automaticallyLogout, "name").clearInputValue().sendKeys(days);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Limit number of sessions that user can
	*               open simultaneously' field.
	* Date 		  : 04-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public SecurityDefaults enterTextInLimitNumberOfSessionsField(String sessions)
			throws Exception {
		objWaitForElement.waitForElements(limitSessions, "name");
			this.page.element(limitSessions, "name").clearInputValue().sendKeys(sessions);
		return this;
	}
	
   /**********************************************************************************
	* Description : This function is to select 'Strong security policy' checkbox.
	* Date 		  : 23-Sep-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public SecurityDefaults selectStrongSecurityPolicyChkbox() throws Exception {
		objWaitForElement.waitForElements(strongSecurityPolicyChkbx, "name");
		if (this.page.element(strongSecurityPolicyChkbx, "name").getOne()
				.isSelected() == false) {
			this.page.element(strongSecurityPolicyChkbx, "name").getOne()
					.click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to deselect 'Strong security policy' checkbox.
	* Date 		  : 23-Sep-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public SecurityDefaults deSelectStrongSecurityPolicyChkbox() throws Exception {
		objWaitForElement.waitForElements(strongSecurityPolicyChkbx, "name");
		if (this.page.element(strongSecurityPolicyChkbx, "name").getOne()
				.isSelected() == true) {
			this.page.element(strongSecurityPolicyChkbx, "name").getOne()
					.click();
		}
		return this;
	}

}
