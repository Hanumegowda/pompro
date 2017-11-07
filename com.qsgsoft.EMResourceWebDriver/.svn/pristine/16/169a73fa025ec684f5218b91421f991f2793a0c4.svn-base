package lib.page;

import static org.testng.Assert.*;
import static org.testng.AssertJUnit.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import qaframework.lib.WaitTimeConstants;
import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;

public class InstantMessaging extends PageObject{
	
	WebDriver driver;
	WaitForElement objWaitForElement;
	
	private String newPrivateChat = "//input[@value='New Private Chat']",
			       newConference = "//input[@type='button'][@value='New Conference']",
			       ListAllUsers = "//div[@id='createNewPrivateChatDialog_step1']/div[2]/input[@type='radio'][@value='listAll']",
			       findUser    = "//div[@id='createNewPrivateChatDialog_step1']/div[4]/input[@type='radio'][@value='findUsers']",
			       findUserForResource = "//div[@id='createNewPrivateChatDialog_step1']/div[6]/input[@type='radio'][@value='findResourceUsers']",
			       CancelPrivateChat = "//input[@id='createNewPrivateChatDialog_buttons_cancel'][@value='Cancel']",
			       roomName = "//div[contains(text(),'Room Name:')]/..//input[@type='text']",
			       description = "//div[contains(text(),'Description:')]/..//textarea ",
			       CancelConference = "//input[@id='createNewConferenceDialog_buttons_cancel'][@value='Cancel']",
			       strNewConferancs="//div[@id='createNewConferenceDialog']/div/div[2]",
			       nextButton = "input[value='Next >']",
			       findUserType = "searchField",
			       containsText = "searchText",
			       chatErrorMessage="div[id='createNewPrivateChatDialog_step2_noResults']";
				  

	public InstantMessaging(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
	} 
	
	/**********************************************************************************
	 * Description : This function is to verify 'New Private Chat' button is displayed.
	 * Date 	   : 04-Jun-2015
	 * Author 	   : Hanumegowda
	 **********************************************************************************/
	public InstantMessaging verNewPrivateChatButtonIsDisplayed()
			throws Exception {
		objWaitForElement.waitForElements(newPrivateChat, "xpath");
		assertTrue(this.page.element(newPrivateChat, "xpath").getOne()
				.isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'NewConference' button is displayed.
	 * Date 	   : 04-Jun-2015
	 * Author 	   : Hanumegowda
	 **********************************************************************************/
	public InstantMessaging verNewConferenceButtonIsDisplayed()
			throws Exception {
		objWaitForElement.waitForElements(newConference, "xpath");
		assertTrue(this.page.element(newConference, "xpath").getOne()
				.isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'New Private Chat' Button.
	 * Date 	   : 04-Jun-2015
	 * Author 	   : Hanumegowda
	 **********************************************************************************/
	public InstantMessaging clickOnNewPrivateChatButton() throws Exception {
		objWaitForElement.waitForElements(newPrivateChat, "xpath");
		this.page.element(newPrivateChat, "xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on 'New Conference' Button.
	 * Date 	   : 04-Jun-2015
	 * Author 	   : Hanumegowda
	 **********************************************************************************/
	public InstantMessaging clickOnNewConferenceButton() throws Exception {
		objWaitForElement.waitForElements(newConference, "xpath");
		this.page.element(newConference, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Create New Chat (1 of 2)' window is popped up. 
	 * Date 	   : 07-Jan-2016
	 * Author 	   : Sangappa K
	 **********************************************************************************/
	public InstantMessaging verCreateNewChatOneOfTwoWindow() throws Exception {

		objWaitForElement.waitForElements("//div[@class='title']", "xpath");
		String strCreateNewChat = this.page
				.element("//div[@class='title']", "xpath").getOne().getText();

		assertTrue(strCreateNewChat.equals("Create New Chat (1 of 2)"),
				"No'Create New Chat (1 of 2)' window is popped up displayed");

		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify List All Users Radio Button Is Displayed in PrivateChat window.
	 * Date 	   : 04-Jun-2015
	 * Author 	   : Hanumegowda
	 **********************************************************************************/
	public InstantMessaging verListAllUsersRadioButtonIsDisplayed()
			throws Exception {
		objWaitForElement.waitForElements(ListAllUsers, "xpath");
		assertTrue(this.page.element(ListAllUsers, "xpath").getOne()
				.isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify FindUser Radio Button Is Displayed in PrivateChat window.
	 * Date 	   : 04-Jun-2015
	 * Author 	   : Hanumegowda
	 **********************************************************************************/
	public InstantMessaging verFindUserRadioButtonIsDisplayed()
			throws Exception {
		objWaitForElement.waitForElements(findUser, "xpath");
		assertTrue(this.page.element(findUser, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify FindUser ForResource Radio Button Is Displayed in PrivateChat window.
	 * Date 	   : 04-Jun-2015
	 * Author 	   : Hanumegowda
	 **********************************************************************************/
	public InstantMessaging verFindUserForResourceRadioButtonIsDisplayed()
			throws Exception {
		objWaitForElement.waitForElements(findUserForResource, "xpath");
		assertTrue(this.page.element(findUserForResource, "xpath").getOne()
				.isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click On Cancel Button In PrivateChat Window.
	 * Date 	   : 04-Jun-2015
	 * Author 	   : Hanumegowda
	 **********************************************************************************/
	public InstantMessaging clickOnCancelButtonInPrivateChatWindow()
			throws Exception {
		objWaitForElement.waitForElements(CancelPrivateChat, "xpath");
		this.page.element(CancelPrivateChat, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Room Name Field is displayed in Conference Window.
	 * Date 	   : 04-Jun-2015
	 * Author 	   : Hanumegowda
	 **********************************************************************************/
	public InstantMessaging verRoomNameFieldIsDisplayed() throws Exception {
		objWaitForElement.waitForElements(roomName, "xpath");
		assertTrue(this.page.element(roomName, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Description Field is displayed in Conference Window.
	 * Date 	   : 04-Jun-2015
	 * Author 	   : Hanumegowda
	 **********************************************************************************/
	public InstantMessaging verDescriptionFieldIsDisplayed() throws Exception {
		objWaitForElement.waitForElements(description, "xpath");
		assertTrue(this.page.element(description, "xpath").getOne()
				.isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click On Cancel Button In Conference Window.
	 * Date 	   : 04-Jun-2015
	 * Author 	   : Hanumegowda
	 **********************************************************************************/
	public InstantMessaging clickOnCancelButtonInConferenceWindow()
			throws Exception {
		objWaitForElement.waitForElements(CancelConference, "xpath");
		this.page.element(CancelConference, "xpath").getOne().click();
		return this;
	}
	
	
	/**********************************************************************************
	  * Description : This function is to select switch to Instant Messaging Frame
	  * Date        : 07/Jan/2016
	  * Author      : Sangappa K
	  **********************************************************************************/
	public InstantMessaging switchToInstantMessagingFrame() throws Exception {

		Thread.sleep(3000);
		try {
			if (this.page.element("//frame[@name='messagingFrame']", "xpath")
					.getOne().isDisplayed()) {
				WebDriverWait wait = new WebDriverWait(this.driver,
						WaitTimeConstants.WAIT_TIME_LONG);
				wait.until(ExpectedConditions
						.frameToBeAvailableAndSwitchToIt("messagingFrame"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return this;

	}
	/**********************************************************************************
	 * Description : This function is to verify Create New Conference' window 
	 * Date 	   : 07-Jan-2015
	 * Author 	   : Sangappa K
	 **********************************************************************************/
	public InstantMessaging verCreateNewConferenceWindow() throws Exception {

		objWaitForElement.waitForElements(strNewConferancs, "xpath");
		String strNewConferces = this.page.element(strNewConferancs, "xpath")
				.getOne().getText();

		assertTrue(strNewConferces.equals("Create New Conference"),
				"No'Create New Conference' window  displayed");

		return this;
	}
	/**********************************************************************************
	  * Description : This function is to click on 'Next' button
	  * Date        : 09/06/2014
	  * Author      : Anil
	  **********************************************************************************/
	public InstantMessaging clickNextButton() throws Exception {
		objWaitForElement.waitForElements(nextButton, "css");
		this.page.element(nextButton, "css").getOne().click();
		Thread.sleep(8000);
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to select Region name
	  * Date        : 09/06/2014
	  * Author      : Anil
	  **********************************************************************************/
	public InstantMessaging selectFindUserType(String strUserType)
			throws Exception {
		objWaitForElement.waitForElements(findUserType, "name");
		this.page.element(findUserType, "name").webElementToSelect()
				.selectByVisibleText(strUserType);
		return this;
	}
	 /**********************************************************************************
	   * Description : This function is to enter resourceType Name
	   * Date        : 11/06/2014
	   * Author      : Anitha
	   **********************************************************************************/
	public InstantMessaging enterContainsText(String strText) throws Exception {
		objWaitForElement.waitForElements(containsText, "name");
		this.page.element(containsText, "name").clearInputValue()
				.sendKeys(strText);
		return this;
	}
	/**********************************************************************************
	  * Description : This function is to verify error Message in find resource screen 
	  * Date        : 1/July/2015
	  * Author      : Anil
	  **********************************************************************************/	
	public InstantMessaging verifyErrorMsgInCreateNewChatPage(String strTextName)
			throws Exception {

		Thread.sleep(5000);
		String strText = this.page.element(chatErrorMessage, "css").getOne()
				.getText();
		assertEquals("No users found where Role (Type of Users) contains '"
				+ strTextName + "'", strText);

		return this;
	}
}
