package lib.page;

import java.util.concurrent.TimeUnit;
import static org.testng.Assert.*;
import org.openqa.selenium.WebDriver;
import qaframework.lib.WaitTimeConstants;
import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;

public class CredenceLoginPage extends PageObject {
	
	WebDriver driver;
	WaitForElement objWaitForElement;

	private String 
			   username = "input[id='username']",	
			   password = "input[name='password']",
			   loginBtn = "input[value='Log In']",				  
			   newPassword = "#password",
			   confirmPassword = "#rpassword",
			   resetPwd = "#submitbutton",
			   oldPassword = "#oldpassword",
			   linkTo = "system",
			   createLink = "input[class='btn submit'][value='Create Link']",
			   procedeToApplication = "input[class='btn submit-grey'][value='Proceed to Application']",
			   successMsg = "//div[@class='alert alert-block alert-success']/h4[text()='Success!']/following-sibling::p[text()='Account has been successfully linked.']";

	public CredenceLoginPage(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
	}
	
	/**********************************************************************************
	  * Description : This function is to enter username
	  * Date        : 14/10/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public CredenceLoginPage enterUserName(String strusername) throws Exception {
		objWaitForElement.waitForElements(username, "css");
		this.page.element(username, "css").clearInputValue().sendKeys(strusername);
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to enter password
	  * Date        : 14/10/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public CredenceLoginPage enterPassword(String strPassword) throws Exception {
		this.page.element(password, "css").clearInputValue().sendKeys(strPassword);
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to enter new password
	  * Date        : 14/10/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public CredenceLoginPage enterNewPassword(String strPassword) throws Exception {
		objWaitForElement.waitForElements(newPassword, "css");
		assertTrue(this.page.element(newPassword, "css").isElementPresent());
		this.page.element(newPassword, "css").clearInputValue().sendKeys(strPassword);
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to enter confirm password
	  * Date        : 14/10/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public CredenceLoginPage enterConfirmPassword(String strPassword) throws Exception {
		this.page.element(confirmPassword, "css").clearInputValue().sendKeys(strPassword);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on 'Login' button
	  * Date        : 14/10/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public CredenceLoginPage clickLogin() throws Exception {
		this.page.element(loginBtn, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter old password
	  * Date        : 14/10/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public CredenceLoginPage enterOldPassword(String strPassword) throws Exception {
		this.page.element(oldPassword, "css").clearInputValue().sendKeys(strPassword);
		return this;
	}
		
	/**********************************************************************************
	  * Description : This function is to login to the application
	  * Date        : 14/10/2014
	  * Author      : Sowmya
	  **********************************************************************************/	
	public SelectRegion loginToCredenceApplication(String strUsername,
			String strPassword) throws Exception {
		driver.get("https://emresource.qa.intermedix.com/login.jsp?ssoLink=true");
		objWaitForElement.waitForElements(
				"//table[@id='passwordForgiveness']/tbody/tr/td[3]/a", "xpath");
		assertTrue(this.page.element(
				"//table[@id='passwordForgiveness']/tbody/tr/td[3]/a", "xpath")
				.isElementPresent());
		this.page
				.element("//table[@id='passwordForgiveness']/tbody/tr/td[3]/a",
						"xpath").getOne().click();
		this.enterUserName(strUsername);
		this.enterPassword(strPassword);
		this.clickLogin();
		return new SelectRegion(this.driver);
	}
	
	/**********************************************************************************
	  * Description : This function is to login to the application as a new user
	  * Date        : 14/10/2014
	  * Author      : Sowmya
	  **********************************************************************************/	
	public SelectRegion loginAsNewUser(String strUsername, String strPassword)
			throws Exception {
		driver.get("https://emresource.qa.intermedix.com/login?ssoLink=true");
		objWaitForElement.waitForElements(
				"//table[@id='passwordForgiveness']/tbody/tr/td[3]/a", "xpath");
		assertTrue(this.page.element(
				"//table[@id='passwordForgiveness']/tbody/tr/td[3]/a", "xpath")
				.isElementPresent());
		this.page
				.element("//table[@id='passwordForgiveness']/tbody/tr/td[3]/a",
						"xpath").getOne().click();
		this.enterUserName(strUsername);
		this.enterPassword("abc123");
		this.clickLogin();
		this.driver
				.manage()
				.timeouts()
				.implicitlyWait(WaitTimeConstants.WAIT_TIME_LONG,
						TimeUnit.SECONDS);
		int intCnt = 0;
		do {
			try {
				if (this.page.element("//div[@id='ucchar']", "xpath").getOne()
						.isDisplayed() == false) {
					break;
				} else {
					Thread.sleep(1000);
					intCnt++;
				}
			} catch (Exception e) {
				Thread.sleep(1000);
				intCnt++;
			}
		} while (intCnt < 10);

		this.enterOldPassword("abc123");
		this.enterNewPassword(strPassword);
		this.enterConfirmPassword(strPassword);
		this.page.element(resetPwd, "css").getOne().click();
		return new SelectRegion(this.driver);
	}
	
	/**********************************************************************************
	  * Description : This function is to select Link to
	  * Date        : 14/10/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public CredenceLoginPage selectLinkTo(String strLinkName) throws Exception {
		objWaitForElement.waitForElements(linkTo, "id");
		assertTrue(this.page.element(linkTo, "id").isElementPresent());
		this.page.element(linkTo, "id").webElementToSelect()
				.selectByVisibleText(strLinkName);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on 'Proceed to application' button
	  * Date        : 14/10/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public CredenceLoginPage clickOnProceedToApplication() throws Exception {
		this.page.element(procedeToApplication, "css").isElementPresent();
		this.page.element(procedeToApplication, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on 'Create link' button
	  * Date        : 14/10/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public CredenceLoginPage clickOnCreateLink() throws Exception {
		objWaitForElement.waitForElements(createLink, "css");
		this.page.element(createLink, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on 'Create link' button
	  * Date        : 14/10/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public CredenceLoginPage verCurrentlyLinkedAcc(String strLinkedProducts)
			throws Exception {
		objWaitForElement
				.waitForElements(
						"//div[@class='linkedlistbox']/h5[text()='Currently Linked Accounts:']",
						"xpath");
		assertTrue(this.page
				.element(
						"//div[@class='linkedlistbox']/h5[text()='Currently Linked Accounts:']",
						"xpath").isElementPresent());
		assertTrue(this.page.element(
				"//div[@class='linkedlistbox']/ul/li[text()='"
						+ strLinkedProducts + "']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify success msg
	  * Date        : 15/10/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public CredenceLoginPage verifySuccessMsg() throws Exception {
		objWaitForElement.waitForElements(successMsg, "xpath");
		this.page.element(successMsg, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify username
	  * Date        : 22/10/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public CredenceLoginPage verUserName() throws Exception {
		assertTrue(this.page.element(username, "css").isElementPresent());
		return this;
	}
}