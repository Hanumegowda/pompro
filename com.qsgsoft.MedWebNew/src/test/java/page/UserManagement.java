package page;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;

import module.Frames;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import qaframework.lib.WaitTimeConstants;
import qaframework.lib.pageObject.PageObject;
import qaframework.lib.userDefinedFunctions.WaitForElement;

public class UserManagement extends PageObject {

	WebDriver driver;
	
	WaitForElement objWaitForElement;
	Frames objFrames;
	

	private String addUser = "//a[text()='Add User']",
			addUser1 = "//img[@src='/.cobalt/images/a_users_but_off.gif']",
			errmsgfordeleteAdminUser = "//font[text()='Only the original admin user can delete other administrators.']",
			administratortab = "//img[@src='/.cobalt/images/a_top_usr_admn.gif']",
			delAdminUsers = "//tr//td//div[text()='Administrator']/../../..//a/img[@src='/.cobalt/images/unlocked.gif']/../../..//td/input[@type='CHECKBOX']",
			removeUser = "ACTION",
			apply = "//a[text()='Apply']",
			lockUsers = "//div[text()='Administrator']/../../..//a/img[@src='/.cobalt/images/unlocked.gif']",
			setUserDefaults = "//a[text()='Set User Defaults']",
			onlyAdminUserAccessThisPage = "//font/i18n[contains(text(),'Only the original admin user can access this page.')]",
			onlyAdminUserAccessThisPage1 = "//font[contains(text(),'Only the original admin user can access this page.')]",
			usernameTextField = "//input[@name='username_search']",
			search = "//a[text()='Search']",
			userNotFound = "//td[contains(text(),'There are no users matching your search criteria')]",
			aclGroup = "f_group",
			location = "f_location",
			importFromCSV = "//a[text()='Import from CSV']",
			downloadCSVTemplate = "//a[text()='Download CSV template']",
			userFName = "//input[@name='fullname_first']",
			userMName = "//input[@name='fullname_middle']",
			userLName = "//input[@name='fullname_last']",
			clearLog = "//a[text()='Clear Log']",
			phone = "//input[@type='TEXT'][@name='phone']",
			fax = "//input[@type='TEXT'][@name='fax']",
			doctorID = "//input[@type='TEXT'][@name='doctor_id']",
			email = "//input[@type='TEXT'][@name='email']",
			addEmail = "additional_emails",
			withActiveX = "(//td[contains(text(),'with ActiveX')]/input[@type='radio'][@name='use_telemedicine_ui_with_activex'])[2]",
			webViewerRadioBtn ="//input[@type='radio'][@name='viewer_type'][2]",
			receiveReferralsOpenRadiBtn = "//input[@name='receivereferrals'][@value='open']",
			byReferringTxtField = "allowed_by_referring",
		    byConsultingTxtField = "allowed_by_consulting",
		    byServiceLocation = "allowed_by_servicelocation",
		    specialists = "specialists";
			

	public UserManagement(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
		objFrames = new Frames(this.driver);
		
	}
	

	/**********************************************************************************
	 * Description : This function is to click on 'Add User' button.
     * Date        : 15-Jun-2015
     * Author      : Hanumegowda
	 **********************************************************************************/
	public UserManagement clickOnAddUser() throws Exception {
		objFrames.switchToDefaultFrame();
		objFrames.switchToRightFrame();
		objFrames.switchToMainInRightFrame();
		//objFrames.switchToFrame("main");
		objWaitForElement.waitForElements(addUser, "xpath");
		this.page.element(addUser, "xpath").mouseOver();
		this.page.element(addUser, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Add User' button.
     * Date        : 15-Jun-2015
     * Author      : Hanumegowda
	 **********************************************************************************/
	public UserManagement clickOnAddUser1() throws Exception {
		objFrames.switchToDefaultFrame().switchToLeftFrame().switchToMainMenuInLeftFrame();
		objWaitForElement.waitForElements(addUser1, "xpath");
		this.page.element(addUser1, "xpath").mouseOver();
		this.page.element(addUser1, "xpath").getOne().click();
		return this;
	}

	/*************************************************************************
	 * Description : This function is to verify 'red ball' symbol and 'user never logged in' message in front of user.
	 * Date        : 15-Jun-2015
	 * Author      : Hanumegowda
	 *************************************************************************/
	public UserManagement verifyUserWithRedBallandUserNeverLoggedIn(
			String strUsername) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		assertTrue(
				this.page.element(
						"//img[@alt='User never logged in'][@src='/.cobalt/images/ris_red_ball.gif']"
								+ "/../..//td//div[contains(text(),'" + strUsername
								+ "')]", "xpath").isElementPresent(),
				"Verified red ball and user is never logged in message");
		return this;
	}
	
	/*************************************************************************
	 * Description : This function is to verify 'red ball' symbol and 'user never logged in' message in front of user.
	 * Date        : 15-Jun-2015
	 * Author      : Hanumegowda
	 *************************************************************************/
	public UserManagement verifyUserWithRedBallandUserNeverLoggedInForNonMandatoryFieldsFilled(
			String strUsername) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		assertTrue(
				this.page.element(
						"//img[@src='/.cobalt/images/ris_red_ball.gif']"
								+ "/../..//td[contains(text(),'" + strUsername
								+ "')]", "xpath").isElementPresent(),
				"Verified red ball and user is never logged in message");
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify user with 'ACL Group' in the user list.
	 * Date        : 18-Jun-2015
     * Author      : Hanumegowda
     **********************************************************************************/
	public UserManagement verUserWithACLGroup(String userName,String aclgroup) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		String str = "//font[contains(text(),'ACL Group')]/../../../following-sibling::tr//div[text()='"+aclgroup+"']/../../..//td[text()='"
				+ userName + "']";
		objWaitForElement.waitForElements(str, "xpath");
		assertTrue(this.page.element(str, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on modify user button.
	 * Date        : 19-Jun-2015
     * Author      : Hanumegowda
     **********************************************************************************/
	public UserManagement clickOnModifyUser(String userName) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		// String str = "//td[text()='"+ userName
		// +"']/following-sibling::td//a[1]";
		String str = "//img[@title='Modify " + userName
				+ "'][@src='/.cobalt/images/modify.gif']";
		// WebDriverWait wait = new
		// WebDriverWait(this.driver,WaitTimeConstants.WAIT_TIME_LONG);
		// WebElement element =
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(str)));
		// element.click();
		objWaitForElement.waitForElements(str, "xpath");
		this.page.element(str, "xpath").isElementPresent();
		//this.page.element(str, "xpath").getOne().isEnabled();
		this.page.element(str, "xpath").mouseOver();
		this.page.element(str, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Remove User' button.
	 * Date        : 26-Jun-2015
     * Author      : Hanumegowda
     **********************************************************************************/
	public UserManagement clickOnRemoveUser(String username) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements("//td[text()='" + username
				+ "']/..//a/img[@src='/.cobalt/images/delete.gif']", "xpath");
		this.page
				.element(
						"//td[text()='"
								+ username
								+ "']/..//a/img[@src='/.cobalt/images/delete.gif']",
						"xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on OK in alert popup.
	 * Date        : 26-Jun-2015
     * Author      : Hanumegowda
     **********************************************************************************/
	public boolean clickOnOkInAlertPopUp() throws Exception {
		try{
		Alert alert = driver.switchTo().alert();
		alert.accept();
		return true;
		}
		catch(NoAlertPresentException ex) {
			return false;
			
		}
		
	}
	
	/**********************************************************************************
	 * Description : This function is to click on OK in alert popup and to verify alert text.
	 * Date        : 26-Jun-2015
     * Author      : Hanumegowda
     **********************************************************************************/
	public UserManagement clickOnOkInAlertPopUpAndGetText(String errmsg) throws Exception {
		Alert alert = driver.switchTo().alert();
		String str = alert.getText();
		System.out.println(str);
		assertTrue(str.contains(errmsg));
		alert.accept();
		return this;
		
	}
	/**********************************************************************************
	 * Description : This function is to verify error message displayed when admin group 
	 *               user attempt to delete/remove another admin group user.
     * Date        : 26-Jun-2015
     * Author      : Hanumegowda
     **********************************************************************************/
	public UserManagement verAdminUserDeleteErrorMsg() throws Exception {
		objWaitForElement.waitForElements(errmsgfordeleteAdminUser, "xpath");
		assertTrue(this.page.element(errmsgfordeleteAdminUser, "xpath").getOne().isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify error message is not displayed when admin group 
	 *               user attempt to delete/remove user from other than admin ACL group user.
     * Date        : 29-Jun-2015
     * Author      : Hanumegowda
     **********************************************************************************/
	public UserManagement verAdminUserDeleteErrorMsgNotDisplayed()
			throws Exception {
		assertFalse(this.page.element(errmsgfordeleteAdminUser, "xpath")
				.isElementPresent(), "error msg displayed");
		return this;
	}
	
	/*************************************************************************
	 * Description : This function is to verify user is not displayed in user list.
	 * Date        : 29-Jun-2015
	 * Author      : Hanumegowda
	 *************************************************************************/
	public UserManagement verifyUserWithRedBallandUserNeverLoggedInIsNotDisplayed(
			String strUsername) throws Exception {
		assertFalse(this.page
				.element(
						"//img[@alt='User never logged in'][@src='/.cobalt/images/ris_red_ball.gif']"
								+ "/../..//td[contains(text(),'" + strUsername
								+ "')]", "xpath").isElementPresent(
						WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on Administrator tab.
	 * Date        : 30-Jun-2015
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public UserManagement clickOnAdministratorTab() throws Exception {
		objWaitForElement.waitForElements(administratortab, "xpath");
		this.page.element(administratortab, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select all admin users.
	 * Date        : 01-Jul-2015
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public boolean selAllAdminUsers() throws Exception {
		objFrames.switchToDefaultFrame();
		objFrames.switchToRightFrame();
		objFrames.switchToMainInRightFrame();
		objWaitForElement.waitForElements(delAdminUsers, "xpath");
		if (this.page.element(delAdminUsers, "xpath").isElementPresent()) {
			List<WebElement> list = driver
					.findElements(By.xpath(delAdminUsers));
			for (WebElement element : list) {
				element.click();
			}
			return true;
		}
		else{
		return false;
		}
	}
	
	/**********************************************************************************
	* Description : This function is to select option in 'Apply for selected' Drop Down.
	* Date 		  : 01-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public UserManagement selectOptionInApplyForSelectedDropDown(String option)
			throws Exception {
		objWaitForElement.waitForElements(removeUser, "id");
		this.page.element(removeUser, "id").webElementToSelect()
				.selectByVisibleText(option);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on apply button.
	 * Date        : 01-Jul-2015
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public UserManagement clickOnApply() throws Exception {
		objWaitForElement.waitForElements(apply, "xpath");
		this.page.element(apply, "xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to lock all admin users.
	 * Date        : 01-Jul-2015
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public UserManagement lockAllAdminUsers() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(lockUsers, "xpath");
		if (this.page.element(lockUsers, "xpath").isElementPresent()) {
			List<WebElement> list = driver.findElements(By.xpath(lockUsers));
			for (WebElement element : list) {
//				WebDriverWait wait = new WebDriverWait(this.driver,
//						WaitTimeConstants.WAIT_TIME_LONG);
//				 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(lockUsers)));
//				wait.until(ExpectedConditions.elementToBeClickable(element));
				boolean unfound = true;
				int a = 0;
				while(unfound && a<5){
					a++;
					try{
						element.click();
						unfound = false;
						}
					catch(StaleElementReferenceException exe){
						unfound = true;
						
					}
					catch(org.openqa.selenium.TimeoutException t){
						unfound = true;
					}
					
				}
				
			}
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to lock all admin users.
	 * Date        : 01-Jul-2015
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public boolean lockAllAdminUsers1() throws Exception {
		objFrames.switchToDefaultFrame();
		objFrames.switchToRightFrame();
		objFrames.switchToMainInRightFrame();
		objWaitForElement.waitForElements(lockUsers, "xpath");
		if((this.page.element(lockUsers, "xpath")).isElementPresent()==true){
			this.page.element(lockUsers, "xpath").mouseOver();
			this.page.element(lockUsers, "xpath").getOne().click();
			return true;
			
		}
		else{
			return false;
		}
	}
	
	/**********************************************************************************
	 * Description : This function is to verify message displayed after a user is locked.
	 * Date        : 01-Jul-2015
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public UserManagement verLockUserMsg(String username) throws Exception {
		objWaitForElement.waitForElements(
				"//font[text()='Action completed for user" + username + "']",
				"xpath");
		assertTrue(this.page.element(
				"//font[text()='Action completed for user" + username + "']",
				"xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select all user created by script.
	 * Date        : 01-Jul-2015
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public UserManagement selectAllAutoUsers() throws Exception {
		String str = "//div[contains(text(),'autouser')]/../../..//td/input[@type='CHECKBOX']";
		objWaitForElement.waitForElements(str, "xpath");
		if(this.page.element(str, "xpath").isElementPresent()){
		List<WebElement> list = driver.findElements(By.xpath(str));
		for(WebElement ele:list){
			ele.click();
		}
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Set User Defaults' button.
     * Date        : 28-Jul-2015
     * Author      : Hanumegowda
	 **********************************************************************************/
	public UserManagement clickOnSetUserDefaults() throws Exception {
		objFrames.switchToDefaultFrame();
		objFrames.switchToRightFrame();
		//objFrames.switchToMainInRightFrame();
		objFrames.switchToFrame("main");
		objWaitForElement.waitForElements(setUserDefaults, "xpath");
		this.page.element(setUserDefaults, "xpath").mouseOver();
		this.page.element(setUserDefaults, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to unlock a user.
	 * Date        : 29-Jul-2015
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public UserManagement unlockUser(String user) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToFrame("main");
		String str = "//div[text()='"+user+"']/../../..//a/img[@src='/.cobalt/images/locked.gif']";
		objWaitForElement.waitForElements(str, "xpath");
		this.page.element(str, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify user is unlocked.
	 * Date        : 29-Jul-2015
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public UserManagement verUserIsUnlocked(String user) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToFrame("main");
		String str = "//div[text()='" + user
				+ "']/../../..//a/img[@src='/.cobalt/images/unlocked.gif']";
		objWaitForElement.waitForElements(str, "xpath");
		assertTrue(this.page.element(str, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Only the original admin user can access this
	  *               page' error message is displayed.
	  * Date        : 17-Aug-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public UserManagement verOnlyAdminUserAccessThisPageErrMsg()
			throws Exception {
		objWaitForElement.waitForElements(onlyAdminUserAccessThisPage, "xpath");
		assertTrue(this.page.element(onlyAdminUserAccessThisPage, "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Only the original admin user can access this
	  *               page' error message is displayed.
	  * Date        : 17-Aug-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public UserManagement verOnlyAdminUserAccessThisPageErrMsg1()
			throws Exception {
		objWaitForElement.waitForElements(onlyAdminUserAccessThisPage1, "xpath");
		assertTrue(this.page.element(onlyAdminUserAccessThisPage1, "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify user is not displayed in the user list.
	 * Date        : 01-Oct-2015
     * Author      : Hanumegowda
     **********************************************************************************/
	public UserManagement verUserWithACLGroupIsNotPresent(String userName,String aclgroup) throws Exception {
		Thread.sleep(2000);
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		String str = "//font[contains(text(),'ACL Group')]/../../../following-sibling::tr//div[text()='"+aclgroup+"']/../../..//td[text()='"
				+ userName + "']";
		assertFalse(this.page.element(str, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter the text in username search field.
	  * Date        : 05-Oct-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public UserManagement enterTextInUserNameSearchField(String user)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(usernameTextField, "xpath");
		this.page.element(usernameTextField, "xpath").getOne();
		this.page.element(usernameTextField, "xpath").clearInputValue().sendKeys(user);		
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on search button.
	  * Date        : 05-Oct-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public UserManagement clickOnSearch()
			throws Exception {
		objWaitForElement.waitForElements(search, "xpath");
//		boolean clicked = false;
//		int i = 0;
//		while(i<5 || clicked==false){
//		try{
		this.page.element(search, "xpath").getOne().click();
//		clicked = true;
//		}
//		catch(NoSuchElementException e){
//			clicked = false;
//		}
//		}
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify user not found error message is displayed.
	  * Date        : 05-Oct-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public UserManagement verUserNotFoundErrMsg()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(userNotFound, "xpath");
		assertTrue(this.page.element(userNotFound, "xpath").isElementPresent());		
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select option in 'ACL group' Drop Down.
	* Date 		  : 11-Dec-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public UserManagement selectOptionInACLGroupDropDown(String option)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(aclGroup, "id");
		this.page.element(aclGroup, "id").webElementToSelect()
				.selectByVisibleText(option);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select option in 'Location' Drop Down.
	* Date 		  : 11-Dec-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public UserManagement selectOptionInLocationDropDown(String option)
			throws Exception {
		objWaitForElement.waitForElements(location, "id");
		this.page.element(location, "id").webElementToSelect()
				.selectByVisibleText(option);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Import From CSV' button.
     * Date        : 07-Jun-2016
     * Author      : Hanumegowda
	 **********************************************************************************/
	public UserManagement clickOnImportFromCSV() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(importFromCSV, "xpath");
		this.page.element(importFromCSV, "xpath").mouseOver();
		this.page.element(importFromCSV, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Download CSV template' link.
     * Date        : 07-Jun-2016
     * Author      : Hanumegowda
	 **********************************************************************************/
	public UserManagement clickOnDownloadCSVTemplate() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(downloadCSVTemplate, "xpath");
		this.page.element(downloadCSVTemplate, "xpath").getOne().sendKeys(Keys.RETURN);
		//this.page.element(downloadCSVTemplate, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify user first name is displayed in modify user page.
     * Date        : 20-Jun-2016
     * Author      : Hanumegowda
	 **********************************************************************************/
	public UserManagement verUserFirstName(String req) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(userFName, "xpath");
		String act = this.page.element(userFName, "xpath").getOne().getAttribute("value");
		System.out.println(act+" aaabbbccc "+ req);
		assertTrue(req.equals(act));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify user first name is displayed in modify user page.
     * Date        : 20-Jun-2016
     * Author      : Hanumegowda
	 **********************************************************************************/
	public UserManagement verUserMiddleName(String req) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(userMName, "xpath");
		String act = this.page.element(userMName, "xpath").getOne().getAttribute("value");
		System.out.println(act+" aaabbbccc "+ req);
		assertTrue(req.equals(act));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify user first name is displayed in modify user page.
     * Date        : 20-Jun-2016
     * Author      : Hanumegowda
	 **********************************************************************************/
	public UserManagement verUserLastName(String req) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(userLName, "xpath");
		String act = this.page.element(userLName, "xpath").getOne().getAttribute("value");
		System.out.println(act+" aaabbbccc "+ req);
		assertTrue(req.equals(act));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Unable to add this user from admin group. 
	  *               Only the original admin user can add users from the Administrator groups'.
	  * Date        : 21-Jun-2016
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public UserManagement verCannotImportAdministratorErrorMsg(String user)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame().switchToIFrame("log");
		String str = "//pre[contains(text(),'"+user+" - Unable to add this user from admin group. Only the original admin user can add users from the Administrator groups')]";
		System.out.println(str);
		objWaitForElement.waitForElements(str, "xpath");
		assertTrue(this.page.element(str, "xpath").isElementPresent());		
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'clear log' button.
     * Date        : 21-Jun-2016
     * Author      : Hanumegowda
	 **********************************************************************************/
	public UserManagement clickOnClearLog() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(clearLog, "xpath");
		this.page.element(clearLog, "xpath").mouseOver();
		this.page.element(clearLog, "xpath").getOne().click();
		Thread.sleep(3000);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'phone num' in Profile Information of modify user page.
     * Date        : 08-Sep-2016
     * Author      : Hanumegowda
	 **********************************************************************************/
	public UserManagement verPhone(String phonenum) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(phone, "xpath");
		String act = this.page.element(phone, "xpath").getOne().getAttribute("value");
		System.out.println(act+" aaabbbccc "+ phonenum);
		assertTrue(phonenum.equals(act));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'fax' in Profile Information of modify user page.
     * Date        : 08-Sep-2016
     * Author      : Hanumegowda
	 **********************************************************************************/
	public UserManagement verFax(String faxnum) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(fax, "xpath");
		String act = this.page.element(fax, "xpath").getOne().getAttribute("value");
		System.out.println(act+" aaabbbccc "+ faxnum);
		assertTrue(faxnum.equals(act));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Doctor ID' in Profile Information of modify user page.
     * Date        : 08-Sep-2016
     * Author      : Hanumegowda
	 **********************************************************************************/
	public UserManagement verDoctorID(String doctorid) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(doctorID, "xpath");
		String act = this.page.element(doctorID, "xpath").getOne().getAttribute("value");
		System.out.println(act+" aaabbbccc "+ doctorid);
		assertTrue(doctorid.equals(act));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Email ID' in Profile Information of modify user page.
     * Date        : 08-Sep-2016
     * Author      : Hanumegowda
	 **********************************************************************************/
	public UserManagement verEmailID(String emailid) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(email, "xpath");
		String act = this.page.element(email, "xpath").getOne().getAttribute("value");
		System.out.println(act+" aaabbbccc "+ emailid);
		assertTrue(emailid.equals(act));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'with ActiveX' radio button is selected in Other section of modify user page.
     * Date        : 08-Sep-2016
     * Author      : Hanumegowda
	 **********************************************************************************/
	public UserManagement verWithActiveXFreeRadioBtnSelected() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(withActiveX, "xpath");
		assertTrue((this.page.element(withActiveX, "xpath")).getOne().isSelected()==true);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Web Viewer' radio button is selected in Other section of modify user page.
     * Date        : 08-Sep-2016
     * Author      : Hanumegowda
	 **********************************************************************************/
	public UserManagement verWebViewerRadioBtnSelected() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(webViewerRadioBtn, "xpath");
		assertTrue((this.page.element(webViewerRadioBtn, "xpath")).getOne().isSelected()==true);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify user with 'Location' in the user list.
	 * Date        : 21-Sep-2016
     * Author      : Hanumegowda
     **********************************************************************************/
	public UserManagement verUserWithLocation(String userName,String loc) throws Exception {
		String str = "//div[text()='"+loc+"']/../../preceding-sibling::td[3]//div[text()='"+userName+"']";
		objWaitForElement.waitForElements(str, "xpath");
		assertTrue(this.page.element(str, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify users full name field in users list page.
     * Date        : 22-Sep-2016
     * Author      : Hanumegowda
	 **********************************************************************************/
	public UserManagement verUserFullName(String fullname) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		String str = "//div[text()='"+fullname+"']";
		objWaitForElement.waitForElements(str, "xpath");
		assertTrue(this.page.element(str, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify user location and Referral conditions/location
	 *               dropdowns value is displayed in modify user page.
     * Date        : 06-Oct-2016
     * Author      : Hanumegowda
	 **********************************************************************************/
	public UserManagement verLocationAndRefLoc(String req) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		String str = "//select/option[contains(text(),'"+req+"')][@selected='']";
		objWaitForElement.waitForElements(str, "xpath");
		assertTrue((this.page.element(str, "xpath")).isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Additional Email IDs' in Profile Information of modify user page.
     * Date        : 06-Oct-2016
     * Author      : Hanumegowda
	 **********************************************************************************/
	public UserManagement verAdditionalEmailIDs(String emailid) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(addEmail, "id");
		String act = this.page.element(addEmail, "id").getOne().getAttribute("value");
		System.out.println(act+" aaabbbccc "+ emailid);
		assertTrue(emailid.equals(act));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Will receive referrals' open radio button 
	 *               is selected in modify user page.
     * Date        : 07-Oct-2016
     * Author      : Hanumegowda
	 **********************************************************************************/
	public UserManagement verReceiveReferralsOpenRadioButtonIsSelected() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(receiveReferralsOpenRadiBtn, "xpath");
		assertTrue((this.page.element(receiveReferralsOpenRadiBtn, "xpath")).getOne().isSelected());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'By Referring' in Profile Information of modify user page.
     * Date        : 07-Oct-2016
     * Author      : Hanumegowda
	 **********************************************************************************/
	public UserManagement verByReferring(String byref) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(byReferringTxtField, "id");
		String act = this.page.element(byReferringTxtField, "id").getOne().getAttribute("value");
		System.out.println(act+" aaabbbccc "+ byref);
		assertTrue(byref.equals(act));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'By Consulting' in Profile Information of modify user page.
     * Date        : 07-Oct-2016
     * Author      : Hanumegowda
	 **********************************************************************************/
	public UserManagement verByConsulting(String bycons) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(byConsultingTxtField, "id");
		String act = this.page.element(byConsultingTxtField, "id").getOne().getAttribute("value");
		System.out.println(act+" aaabbbccc "+ bycons);
		assertTrue(bycons.equals(act));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'By Service Location' in Profile Information of modify user page.
     * Date        : 07-Oct-2016
     * Author      : Hanumegowda
	 **********************************************************************************/
	public UserManagement verByServiceLocation(String byserloc) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(byServiceLocation, "id");
		String act = this.page.element(byServiceLocation, "id").getOne().getAttribute("value");
		System.out.println(act+" aaabbbccc "+ byserloc);
		assertTrue(byserloc.equals(act));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Specialists' in Profile Information of modify user page.
     * Date        : 07-Oct-2016
     * Author      : Hanumegowda
	 **********************************************************************************/
	public UserManagement verSpecialists(String speclst) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(specialists, "id");
		String act = this.page.element(specialists, "id").getOne().getAttribute("value");
		System.out.println(act+" aaabbbccc "+ speclst);
		assertTrue(speclst.equals(act));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Allowed Consult Types' and 'e-Mail Notifications'
	 *               checkboxes are select in modify user page.
     * Date        : 07-Oct-2016
     * Author      : Hanumegowda
	 **********************************************************************************/
	public UserManagement verAllowedConsultTypesAndEMailNotificationsCheckboxesIsSelected(String checkbxname) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		String str = "//td[text()='"+checkbxname+"']/following-sibling::td/input";
		objWaitForElement.waitForElements(str, "xpath");
		assertTrue((this.page.element(str, "xpath")).getOne().isSelected());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Allowed Consult Types' and 'e-Mail Notifications'
	 *               checkboxes are not select in modify user page.
     * Date        : 07-Oct-2016
     * Author      : Hanumegowda
	 **********************************************************************************/
	public UserManagement verAllowedConsultTypesAndEMailNotificationsCheckboxesIsNotSelected(String checkbxname) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		String str = "//td[text()='"+checkbxname+"']/following-sibling::td/input";
		objWaitForElement.waitForElements(str, "xpath");
		assertTrue(!((this.page.element(str, "xpath")).getOne()).isSelected());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Case has not been opened by consulting MD in'
	 *               dropdowns value in modify user page.
     * Date        : 07-Oct-2016
     * Author      : Hanumegowda
	 **********************************************************************************/
	public UserManagement verCaseNotOpenedDropdownValue(String req) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		String str = "//select[@name='notify_tm_ref_case_not_opened_in_x']/option[contains(text(),'"+req+"')]";
		objWaitForElement.waitForElements(str, "xpath");
		assertTrue((this.page.element(str, "xpath")).getOne().isSelected());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Signed report has not been generated in'
	 *               dropdowns value in modify user page.
     * Date        : 07-Oct-2016
     * Author      : Hanumegowda
	 **********************************************************************************/
	public UserManagement verSignedReportNotGeneratedDropdownValue(String req) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		String str = "//select[@name='notify_tm_ref_no_signed_report_in_x']/option[contains(text(),'"+req+"')][@selected='']";
		objWaitForElement.waitForElements(str, "xpath");
		assertTrue((this.page.element(str, "xpath")).isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Response to a reply has not been added in'
	 *               dropdowns value in modify user page.
     * Date        : 07-Oct-2016
     * Author      : Hanumegowda
	 **********************************************************************************/
	public UserManagement verResponseNotAddedDropdownValue(String req) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		String str = "//select[@name='notify_tm_ref_no_response_to_reply_in_x']/option[contains(text(),'"+req+"')][@selected='']";
		objWaitForElement.waitForElements(str, "xpath");
		assertTrue((this.page.element(str, "xpath")).isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'When case has remained in draft state for'
	 *               dropdowns value in modify user page.
     * Date        : 07-Oct-2016
     * Author      : Hanumegowda
	 **********************************************************************************/
	public UserManagement verCaseRemainedDraftDropdownValue(String req) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		//select[@name='notify_tm_ref_remained_draft_for_x']/option[contains(text(),'1 month')][@selected='']
		
		String str = "//select[@name='notify_tm_ref_remained_draft_for_x']";
		Select s = new Select((this.page.element(str, "xpath")).getOne());
		String actual = s.getFirstSelectedOption().getText();
		System.out.println(actual+" new first selected value");
		assertTrue(actual.equals(req));
		return this;
	}

}
