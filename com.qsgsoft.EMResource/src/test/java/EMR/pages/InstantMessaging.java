package EMR.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import EMR.Locators.InstantMessaging.Locators;
import qaFramework.WaitTimeConstants;
import qaFramework.UserDefinedFunctions.WaitForElement;
import qaFramework.pageObject.PageObject;


	public class InstantMessaging extends PageObject {

		WebDriver driver;
		WaitForElement waitForElement ;
		
	public InstantMessaging(WebDriver _driver)throws Exception{
		super(_driver);
		this.driver=_driver;
		waitForElement = new WaitForElement(this.driver);
	}

	public InstantMessaging navigateToCreateNewChat() throws Exception{
//		waitForElement.waitForElements(Locators.CREATE_PRIVATE_CHAT, "css");
//		this.page.element(Locators.CREATE_PRIVATE_CHAT, "css").getDisplayedOne().click();
//		return this;
		
		waitForElement.waitForElements(Locators.CREATE_PRIVATE_CHAT, "css");
		try{
			this.page.element(Locators.CREATE_PRIVATE_CHAT, "css").clickUsingJSE();

			if (this.page.element(Locators.CREATE_PRIVATE_CHAT, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL) == false) {
				this.page.element(Locators.CREATE_PRIVATE_CHAT, "css").getDisplayedOne().click();
				waitForElement.waitForElements(Locators.CREATE_PRIVATE_CHAT,"xpath" );
			}
			if(this.page.element(Locators.CREATE_PRIVATE_CHAT, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL)==false) {
				this.page.element(Locators.CREATE_PRIVATE_CHAT, "xpath").getDisplayedOne().sendKeys(Keys.ENTER);
			}
			waitForElement.waitForElements(Locators.CREATE_PRIVATE_CHAT, "xpath");
			assertTrue(this.page.element(Locators.CREATE_PRIVATE_CHAT, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL));
		} catch(Exception e) {

		}
		return this;
	}

	public InstantMessaging selectFindUserType(String userType) throws Exception{
		waitForElement.waitForElements(Locators.SEARCH_ROLE_ON_CREATE_NEW_CHAT, "name");
		this.page.element(Locators.SEARCH_ROLE_ON_CREATE_NEW_CHAT, "name").webElementToSelect().selectByVisibleText(userType);
		return this;
	}
	
	public InstantMessaging searchContentText(String roleName)throws Exception{
		waitForElement.waitForElements(Locators.CONTENT_TEXT_ON_CREATE_NEW_CHAT, "name");
		this.page.element(Locators.CONTENT_TEXT_ON_CREATE_NEW_CHAT, "name").clearInputValue().sendKeys(roleName);
		return this;
	}
	
	public InstantMessaging clickOnNext()throws Exception{
		waitForElement.waitForElements(Locators.NEXT_BUTTON, "xpath");
		try{
			this.page.element(Locators.NEXT_BUTTON, "xpath").clickUsingJSE();

			if (this.page.element(Locators.NEXT_BUTTON, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL) ) {
				this.page.element(Locators.NEXT_BUTTON, "xpath").getDisplayedOne().click();
				waitForElement.waitForElements(Locators.ERROR_MESSAGE,"id" );
			}
			if(this.page.element(Locators.NEXT_BUTTON, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL)) {
				this.page.element(Locators.NEXT_BUTTON, "xpath").getDisplayedOne().sendKeys(Keys.ENTER);
			}
			waitForElement.waitForElements(Locators.NEXT_BUTTON, "xpath");
			assertTrue(this.page.element(Locators.NEXT_BUTTON, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL));
			waitForElement.waitForElements(Locators.ERROR_MESSAGE,"id" );
		} catch(Exception e) {
		
		}
	return this;
		
	}
	
	public InstantMessaging verifyErrorMessageInCreateNewChatPage(String roleName)throws Exception{
		String strText = this.page.element(Locators.ERROR_MESSAGE, "id").getOne().getText();
		assertEquals("No users found where Role (Type of Users) contains '"
				+ roleName + "'", strText);

		return this;
	}
	
	public InstantMessaging switchToInstantMessagingFrame() throws Exception {
		WebDriverWait wait = new WebDriverWait(this.driver,
				WaitTimeConstants.COUNT);
		wait.until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(Locators.SWITCH_TO_INSTANT_MESSAGE));
		
		return this;
	}
	
	public InstantMessaging clickOncancel() throws Exception{
		waitForElement.waitForElements(Locators.CANCEL, "id");
		this.page.element(Locators.CANCEL, "id").getDisplayedOne().click();
		return this;
	}
}
