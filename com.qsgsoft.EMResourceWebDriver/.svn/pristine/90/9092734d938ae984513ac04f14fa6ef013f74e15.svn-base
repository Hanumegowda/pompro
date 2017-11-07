package lib.page;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.*;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import qaframework.lib.WaitTimeConstants;
import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;

public class MailVerificationFunctions extends PageObject {

	WebDriver driver;
	WaitForElement objWaitForElement;
	//Locators
	private static String strOLUrl = "https://webmail.opentransfer.com/",
			strUserName = "//input[@name='imapuser']",
			strPswd = "//input[@name='pass']",
			strLoginWin = "//form[@name='imp_login']/table/tbody/tr/td/table/tbody/tr[1]/td[1]/strong",
			strLoginBtn = "//input[@name='loginButton']",
			logout = "//a[contains(text(),'Log')]",
			//			messageBody = "div.fixed.leftAlign",
			urlLink = "//div[@class='PlainText']/a",
			username = "input[name='loginName']",
			clickedIinbox = "//a[@class='current'][@href='/horde/imp/mailbox.php?mailbox=INBOX']",
			Subject_On_Inbox = "//div[contains(@aria-label,'Unread, ')]/div/div/span[text()='",
			Subject_On_Inbox_1 = "//div[@class='_lvv2_s _lvv2_e']/span[@class='ms-fwt-sb ms-fcl-tp']/preceding-sibling::span[text()='";



	//	private static String url = "https://192.232.238.154:2096/logout/?locale=en",		              
	//						  userID = "input#user",						  
	//						  password = "input#pass",						  
	//						  login = "button#login_submit",
	//						  searchField = "input#horde-search-input",
	//						  searchIcon = "input#horde-search-icon",
	//						  mailFrame = "mailFrame",
	//						  logoutMail = "button#lnkHeaderLogout",

	private static String url = "http://www.outlook.com",
			userID = "input[id='i0116'][type='email']",
			password = "input[id='i0118'][type='password']",
			login = "input[id='idSIButton9'][type='submit']",
			inbox = "//span[@title='Inbox']",
			messageBody = "div[class='PlainText']",
			profile = "//div[@id='O365_TopMenu']/div/div/div[1]/div[14]/button",
			signOut = "//span[text()='Sign out']",
			close = "//button[@title='Close']",
			signIn	= "//div[@class='buttonLargeBlue']";


	public MailVerificationFunctions(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver=_driver;
		objWaitForElement = new WaitForElement(this.driver);
	}

	/**********************************************************************************
	 * Description 	: This function is used to login outlook
	 * Date 		: 18-Jun-2014
	 * Author 		: Yugender
	 * ******************************************************************
	 */
	public void loginToMail(String strOLUserName,
			String strOLPswd) throws Exception {

		/*	Actions action = new Actions(this.driver);
		boolean blnFound = false;
		int intCnt = 0;
		driver.get(strOLUrl);
		while (blnFound == false && intCnt < 60) {
			try {
				objWaitForElement.waitForElements(strLoginWin, "xpath");
				objWaitForElement.waitForElements(strUserName, "xpath");
				this.page.element(strUserName, "xpath").clearInputValue().sendKeys(strOLUserName);
				objWaitForElement.waitForElements(strPswd, "xpath");
				this.page.element(strPswd, "xpath").clearInputValue().sendKeys(strOLPswd);
				objWaitForElement.waitForElements(strLoginBtn, "xpath");
				action.moveToElement(this.page.element(strLoginBtn, "xpath").getOne())
						.click().build().perform();
				blnFound = true;
				Thread.sleep(10000);
			} catch (Exception e) {
				Thread.sleep(1000);
				intCnt++;
			}
		}*/

		driver.get(url);
		driver.navigate().to(url);
		if(this.page.element(signIn, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE)) {
			this.clickOnSignIn();
		}
		this.enterUserId(strOLUserName);
		this.clickOnLogin();
		Thread.sleep(5000);
		this.enterPassword(strOLPswd);
		this.clickOnLogin();
		Thread.sleep(5000);
		this.waitForInbox();
	}

	/**********************************************************************************
	 * Description 	: This function is used to enter user id
	 * Date 		: 18-May-2016
	 * Author 		: Renushree
	 * ******************************************************************
	 */
	public void enterUserId(String _userID) throws Exception {
		objWaitForElement.waitForElements(userID, "css");
		this.page.element(userID, "css").clearInputValue().sendKeys(_userID);
	}

	/**********************************************************************************
	 * Description 	: This function is used to enter password
	 * Date 		: 18-May-2016
	 * Author 		: Renushree
	 * ******************************************************************
	 */
	public void enterPassword(String _password) throws Exception {
		objWaitForElement.waitForElements(password, "css");
		this.page.element(password, "css").clearInputValue().sendKeys(_password);
	}

	/**********************************************************************************
	 * Description 	: This function is used to click on login
	 * Date 		: 18-May-2016
	 * Author 		: Renushree
	 * ******************************************************************
	 */
	public void clickOnLogin() throws Exception {
		objWaitForElement.waitForElements(login, "css");
		this.page.element(login, "css").getOne().click();
		Thread.sleep(4000);
	}

	/**********************************************************************************
	 * Description 	: This function is used to click on login
	 * Date 		: 18-May-2016
	 * Author 		: Renushree
	 * ******************************************************************
	 */
	public void switchToMailFrame() throws Exception {
		//		WebDriverWait wait = new WebDriverWait(this.driver,
		//				WaitTimeConstants.WAIT_TIME_LONG);
		//		wait.until(ExpectedConditions
		//				.frameToBeAvailableAndSwitchToIt(mailFrame));
	}

	/**********************************************************************************
	 * Description 	: This function is used to enter subject 
	 * Date 		: 18-May-2016
	 * Author 		: Renushree
	 * ******************************************************************
	 */
	//	public void enterSubjectInSearch(String subject) throws Exception {
	//		objWaitForElement.waitForElements(searchField, "css");
	//		this.page.element(searchField, "css").clearInputValue().sendKeys(subject);
	//	}

	/**********************************************************************************
	 * Description 	: This function is used to enter subject 
	 * Date 		: 18-May-2016
	 * Author 		: Renushree
	 * ******************************************************************
	 */
	//	public void clickOnSearchIcon() throws Exception {
	//		objWaitForElement.waitForElements(searchIcon, "css");
	//		this.page.element(searchIcon, "css").getOne().click();
	//	}

	/**********************************************************************************
	 * Description 	: This function is used to navigate to Inbox 
	 * Date 		: 18-Jun-2014
	 * Author 		: Yugender
	 * ******************************************************************
	 */
	public void NavToInbox(String strSubject) throws Exception {
		strSubject = strSubject.replace("EMResource ", "");
		strSubject = "EMResource QA/Test " + strSubject;
		Actions action = new Actions(this.driver);
		boolean blnFound1 = false;
		int intCnt1 = 0;
		driver.manage()
		.timeouts()
		.implicitlyWait(WaitTimeConstants.WAIT_TIME_LONG,
				TimeUnit.SECONDS);
		while (blnFound1 == false && intCnt1 < 60) {
			try {
				objWaitForElement.waitForElements(inbox, "xpath");
				action.moveToElement(this.page.element(inbox, "xpath").getOne())
				.click().build().perform();
				objWaitForElement.waitForElements(
						Subject_On_Inbox_1 + strSubject + "']", "xpath");
				//				assertTrue(this.page.element(
				//						"//div[contains(@aria-label,'Unread, ')]/div/div/span[text()='"
				//								+ strSubject + "']", "xpath").isElementPresent(
				//						WaitTimeConstants.COUNT));
				assertTrue(this.page.element(
						Subject_On_Inbox_1 + strSubject + "']", "xpath").isElementPresent(
								WaitTimeConstants.COUNT), strSubject+" mail is not present");
				blnFound1 = true;
			} catch (Exception e) {
				Thread.sleep(1000);
				intCnt1++;
			}
			// } catch (NoSuchElementException e) {
			// action.moveToElement(
			// this.page.element(inbox, "css").getOne())
			// .click().build().perform();
			// }
			// Thread.sleep(15000);
			// if((this.page.element("//form[@name='messages']/table/tbody/tr/td[5]/a",
			// "xpath").isElementPresent())==false){
			// action.moveToElement(
			// this.page.element("//div[@class='rightFloat']/ul/li[4]/a",
			// "xpath").getOne())
			// .click().build().perform();
			// }
			// driver.switchTo().defaultContent();
			// driver.switchTo().frame("horde_main");
			// while (!(this.page.dynamicElement(
			// "strSubject",
			// "//form[@name='messages']/table/tbody/tr/td[5]/a/b[text()='"
			// + strSubject + "']", "xpath").isElementPresent())
			// && this.page.element("//a[@id='next']/img",
			// "xpath").isElementPresent())
			// {
			// objWaitForElement.waitForElements("//a[@id='next']/img",
			// "xpath");
			// action.moveToElement(
			// this.page.element("//a[@id='next']/img", "xpath")
			// .getOne()).click().build().perform();
			// Thread.sleep(5000);
			// }
			// objWaitForElement.waitForElements(
			// "//form[@name='messages']/table/tbody/tr/td[5]/a/b[text()='"
			// + strSubject + "']", "xpath");
			// this.page.dynamicElement("strSubject",
			// "//form[@name='messages']/table/tbody/tr/td[5]/a/b[text()='"
			// + strSubject + "']", "xpath").getOne().isDisplayed();
			// driver.switchTo().defaultContent();
			// blnFound1 = true;
			// }
			// catch (AssertionFailedError e) {
			// Thread.sleep(1000);
			// intCnt1++;
			// }
		}
	}

	/**********************************************************************************
	 * Description 	: This function is used to navigate to Inbox 
	 * Date 		: 18-Jun-2014
	 * Author 		: Yugender
	 * ******************************************************************
	 */
	public void NavToInboxNew(String strSubject) throws Exception {
		/*Actions action = new Actions(this.driver);
		boolean blnFound1 = false;
		int intCnt1 = 0;
		driver.manage().timeouts()
		.implicitlyWait(WaitTimeConstants.WAIT_TIME_LONG,
				TimeUnit.SECONDS);
		while (blnFound1 == false && intCnt1 < 60) {
			try {
				WebDriverWait wait = new WebDriverWait(this.driver, WaitTimeConstants.WAIT_TIME_LONG);
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("horde_main"));
				driver.switchTo().window("");
				driver.switchTo().frame("horde_main");
				Thread.sleep(5000);
				try {
					objWaitForElement.waitForElements("//div[@class='rightFloat']/ul/li[4]/a", "xpath");
					action.moveToElement(
							this.page.element("//div[@class='rightFloat']/ul/li[4]/a", "xpath").getOne())
							.click().build().perform();
				} catch (NoSuchElementException e) {
					action.moveToElement(
							this.page.element("//div[@class='rightFloat']/ul/li[4]/a", "xpath").getOne())
							.click().build().perform();
				}
				Thread.sleep(15000);
				if((this.page.element("//form[@name='messages']/table/tbody/tr/td[5]/a", "xpath").isElementPresent())==false){
					action.moveToElement(
							this.page.element("//div[@class='rightFloat']/ul/li[4]/a", "xpath").getOne())
							.click().build().perform();
				}
				driver.switchTo().defaultContent();
				driver.switchTo().frame("horde_main");
				while (!(this.page.dynamicElement(
						"strSubject",
						"//form[@name='messages']/table/tbody/tr/td[5]/a/b[text()='"
								+ strSubject + "']", "xpath").isElementPresent())
						&& this.page.element("//a[@id='next']/img", "xpath").isElementPresent()) 
				{
					objWaitForElement.waitForElements("//a[@id='next']/img", "xpath");
					action.moveToElement(
							this.page.element("//a[@id='next']/img", "xpath")
									.getOne()).click().build().perform();
					Thread.sleep(5000);
				}
				objWaitForElement.waitForElements( "//form[@name='messages']/table/tbody/tr/td[5]/a/b[text()='"
						+ strSubject + "']", "xpath");
				this.page.dynamicElement("strSubject", "//form[@name='messages']/table/tbody/tr/td[5]/a/b[text()='"
						+ strSubject + "']", "xpath").getOne().isDisplayed();
				driver.switchTo().defaultContent();
				blnFound1 = true;
			} catch (AssertionFailedError e) {
				Thread.sleep(1000);
				intCnt1++;
			}
		}*/
		Actions action = new Actions(this.driver);
		boolean blnFound1 = false;
		int intCnt1 = 0;
		driver.manage()
		.timeouts()
		.implicitlyWait(WaitTimeConstants.WAIT_TIME_LONG,
				TimeUnit.SECONDS);
		while (blnFound1 == false && intCnt1 < 60) {
			try {
				objWaitForElement.waitForElements(inbox, "xpath");
				action.moveToElement(this.page.element(inbox, "xpath").getOne())
				.click().build().perform();
				objWaitForElement.waitForElements(Subject_On_Inbox_1+ strSubject + "']", "xpath");
				assertTrue(this.page.element(Subject_On_Inbox_1 + strSubject + "']", "xpath").isElementPresent(
						WaitTimeConstants.COUNT));
				blnFound1 = true;
			} catch (Exception e) {
				Thread.sleep(1000);
				intCnt1++;
			}
		}
	}

	/**********************************************************************************
	 * Description 	: This function is used to verify mail contents
	 * Arguments 	: strTo, strSubject
	 * Date 		: 18-Jun-2014
	 * Author 		: Yugendeer
	 * ********************************************************************************
	 */
	public void verEmail(String strTo, String strSubject) throws Exception {
		strSubject = strSubject.replace("EMResource ", "");
		strSubject = "EMResource QA/Test " + strSubject;
		Actions action = new Actions(this.driver);
		String subjectElement = Subject_On_Inbox_1 + strSubject + "']";
		objWaitForElement.waitForElements(subjectElement, "xpath");
		assertTrue(this.page.element(subjectElement, "xpath")
				.isElementPresent(), subjectElement+ " is not present.");
		action.moveToElement(this.page.element(subjectElement, "xpath").getDisplayedOne()).click().build().perform();
		try{
			Thread.sleep(7000);
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		}catch (NoAlertPresentException nae) {
			System.out.println("no alert");
		}
		try {
			if(this.page.element("//button[@title='Expand messages']", "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE)) {
				action.moveToElement(this.page.element("//button[@title='Expand messages']", "xpath").getOne()).click().build().perform();
			}
		} catch(Exception e) {

		}
		objWaitForElement.waitForElements("//button[@title='Reply all']/span[text()='Reply all']", "xpath");
		Thread.sleep(5000);
	}

	/**********************************************************************************
	 * Description 	: This function is used to verify mail contents
	 * Arguments 	: strTo, strSubject
	 * Date 		: 18-Jun-2014
	 * Author 		: Yugendeer
	 * ********************************************************************************
	 */
	public void verEmailNew(String strTo, String strSubject) throws Exception {
		String subjectElement = Subject_On_Inbox_1 +  strSubject + "']";
		objWaitForElement.waitForElements(subjectElement, "xpath");
		assertTrue(this.page.element(subjectElement, "xpath")
				.isElementPresent());
		this.page.element(subjectElement, "xpath").getOne().click();
		objWaitForElement.waitForElements(
				"//div[@aria-label='Reading Pane']//div/span[text()='"
						+ strSubject + "']", "xpath");
		Thread.sleep(5000);
	}

	/**********************************************************************************
	 * Description 	: This function is used to verify mail contents
	 * Arguments 	: strSubject
	 * Date 		: 19-Jun-2014
	 * Author 		: Yugender
	 * ********************************************************************************
	 */
	public void NavToInboxAndVerEmailIsNotPresent(String strSubject)
			throws Exception {
		strSubject = "EMResource QA/Test " + strSubject;
		String subjectElement = Subject_On_Inbox_1 + strSubject + "']";
		objWaitForElement.waitForElements(subjectElement, "xpath");
		assertFalse(this.page.element(subjectElement, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE),
				"Email is present");

	}

	/**********************************************************************************
	 * Description 	: This function is used to logout from mail
	 * Date 		: 18-Jun-2014
	 * Author 		: Yugender
	 * ********************************************************************************
	 */
	public void logoutMail() throws Exception {
		driver.switchTo().defaultContent();
		//driver.switchTo().frame("horde_menu");
		//		objWaitForElement.waitForElements(logoutMail, "xpath");
		//		assertTrue(this.page.element(logoutMail, "xpath").getOne().isDisplayed());
		//		this.page.element(logoutMail, "xpath").getOne().sendKeys(Keys.ENTER);

		//		this.clickOnProfile();
		//		this.clickOnSignOut();
		this.clickOnProfile();
		this.clickOnSignOut();
		driver.navigate().to("https://outlook.live.com/owa/logoff.owa");
		objWaitForElement.waitForElements(userID, "css");

	}

	/********************************************************************
	 * Description 	: This function is used to verify mail body is displayed
	 * Date 		: 29-Jul-2014
	 * Author 		: Anil
	 * ******************************************************************/
	public boolean verifyMailBody(String strMessageBody) throws Exception {
		boolean blnCheck = false;
		objWaitForElement.waitForElements(messageBody, "css");
		String strMsg = this.page.element(messageBody, "css").getOne().getText();
		System.out.println("CAPTURED" + strMsg);
		System.out.println("formed: " + strMessageBody);
		if(strMsg.contains( strMessageBody)){
			blnCheck=true;
		}
		System.out.println(blnCheck);
		return blnCheck;
	}
	/**********************************************************************************
	 * Description 	: This function is used navigate back to inbox
	 * Date 		: 18-Jun-2014
	 * Author 		: Yugender
	 * *******************************************************************************/
	public void backToMailInbox() throws Exception {
		Actions action = new Actions(this.driver);
		objWaitForElement.waitForElements("//button[@title='Close']/span[1]", "xpath");
		action.moveToElement(this.page.element("//button[@title='Close']/span[1]", "xpath").getOne()).doubleClick().build().perform();
	}

	/********************************************************************
	 * Description 	: This function is used to verify mail body contains message body is displayed
	 * Date 		: 29-Jul-2014
	 * Author 		: Anil
	 * ******************************************************************/
	public boolean verifyMailContainsBody(String strMessageBody) throws Exception {

		boolean blnCheck = false;
		objWaitForElement.waitForElements(messageBody, "css");
		String strMsg = this.page.element(messageBody, "css").getOne().getText();
		System.out.println("CAPTURED: "+strMsg);
		System.out.println("FORMED: "+ strMessageBody);
		if(strMsg.contains(strMessageBody)){

			blnCheck=true;
		}

		return blnCheck;
	}
	/**********************************************************************************
	 * Description 	: This function is used to verify mail contents
	 * Arguments 	: strSubject
	 * Date 		: 19-Jun-2014
	 * Author 		: Yugender
	 * ********************************************************************************
	 */
	public void NavToInboxAndVerEmailIsNotPresentNew(String strSubject)
			throws Exception {
		strSubject = strSubject.replace("EMResource ", "");
		strSubject = "EMResource QA/Test " + strSubject;
		String subjectElement = Subject_On_Inbox_1 + strSubject + "']";
		objWaitForElement.waitForElements(subjectElement, "xpath");
		assertFalse(this.page.element(subjectElement, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE),
				"Email is present");
	}

	/********************************************************************
	 * Description 	: This function is used to fetch the URL link from the message body
	 * Date 		: 20-Aug-2014
	 * Author 		: Sowmya
	 * ******************************************************************/
	public String GetUrlLinkFromMsgBody(String strTo, String strSubject)
			throws Exception {
		String strURL = "";
		objWaitForElement.waitForElements(urlLink, "xpath");
		if (this.page.element(urlLink, "xpath").isElementPresent()) {
			strURL = this.page.element(urlLink, "xpath").getOne().getText();
		}
		return strURL;
	}

	/*********************************************************************
	 * Description 	: This function is used to lauch the URL
	 * Date 		: 20-Aug-2014
	 * Author 		: Sowmya
	 * *******************************************************************/
	public void launchUrl(String strUrl) throws Exception {
		driver.get(strUrl);
		objWaitForElement.waitForElements(username, "css");
	}

	/********************************************************************
	 * Description 	: This function is used to fetch the URL link from the message body
	 * Date 		: 20-Aug-2014
	 * Author 		: Sowmya
	 * ******************************************************************/
	public int getTotalEMailCount(String strSubject)
			throws Exception {
		int intCount = 0;
		objWaitForElement.waitForElements("//div[@aria-label='Reading Pane']//div/span[text()='"+ strSubject + "']", "xpath");
		intCount = this.page.element("//div[@aria-label='Reading Pane']//div/span[text()='"+ strSubject + "']", "xpath").getXpathCount();
		return intCount;
	}


	/**********************************************************************************
	 * Description 	: This function is used navigate back to inbox
	 * Date 		: 18-Jun-2014
	 * Author 		: Yugender
	 * *******************************************************************************/
	public void clickOnNextButton() throws Exception {
		//		objWaitForElement.waitForElements("//a[@id='next']/img", "xpath");
		//		this.page.element("//a[@id='next']/img", "xpath").getOne().click();
	}

	/**********************************************************************************
	 * Description 	: This function is used to get mail body
	 * Date 		: 18-Jun-2014
	 * Author 		: Yugender
	 * *******************************************************************************/
	public String getExpiredStatusEmailBody(String strUserFullName, String strRegionName, String strStatusTypeName, String strResourceName, String strApplicationTime) throws Exception {
		String strMsgBody = "For "
				+ strUserFullName
				+ "\nRegion: "
				+ strRegionName
				+ "\n\nThe "
				+ strStatusTypeName
				+ " status for "
				+ strResourceName
				+ " expired "
				+strApplicationTime
				+ ".\n\nClick the link below to go to the EMResource login screen:"
				+

				"\n\n        "
				+ "https://emresource.qa.intermedix.com";
		//				+ "\n\nPlease do not reply to this email message. "
		//				+ "You must log into EMResource to take any action that may be required."
		//				+ "\n\n\nYou have signed up to receive expired "
		//				+ "status notifications. If you no longer"
		//				+ " want to receive expired status notifications,"
		//				+ " log onto EMResource and deselect the notification fields on the Preferences -> System Notification screen.";
		return strMsgBody;
	}


	/**********************************************************************************
	 * Description 	: This function is used to get event  mail body
	 * Date 		: 19-Nov-2014
	 * Author 		: Anil
	 * *******************************************************************************/
	public String getEventEmailBody(String strUserFullName, String strFullName, String strRegionName, String strEventDescription) throws Exception {
		String strMsgBody = 	  "Event Notice for: " + strUserFullName + "\n"
				+ "Information: " + strEventDescription + "\n\n" + "From: "
				+ strFullName + "\n\n" + "Regions: " + strRegionName
				+ "\n\nPlease do not reply to this email message. "
				+ "You must log into EMResource to take any "
				+ "action that may be required." + "\n"
				+ "https://emresource.qa.intermedix.com";
		return strMsgBody;
	}

	/**********************************************************************************
	 * Description 	: This function is used to get event page body
	 * Date 		: 19-Nov-2014
	 * Author 		: Anil
	 * *******************************************************************************/
	public String getEventPagerBody(String strUserFullName, String strRegionName, String strEventDescription) throws Exception {
		String strMsgBody = "Information: " + strEventDescription + "\nFrom: "
				+ strUserFullName + "\nRegions: " + strRegionName;
		return strMsgBody;
	}

	/**********************************************************************************
	 * Description 	: This function is used to get status change mail body
	 * Date 		: 24-Nov-2014
	 * Author 		: Renushree
	 * *******************************************************************************/
	public String getStatusChangeEmailBody(String strUserFullName, String strUpdatedTime, String strResourceName, String strStatusTypeName, String strUpdatedValues, String strRegions, String strResType) throws Exception {
		String strMsgBody ="Status Update for " + strUserFullName
				+ ":" + "\nOn " + strUpdatedTime + " " + strResourceName + " "
				+ "changed " + strStatusTypeName
				+ " status from -- " + "to " + strUpdatedValues
				+ ".\n\nComments:\n\nReasons:\n\nRegion: " + ""
				+ strRegions
				+ "\n\nOther "+strResType+"s in the region report the following "+strStatusTypeName+" status:\n\n\nPlease do not reply to this email message."
				+ " You must log into EMResource to take any action that may"
				+ " be required.";
		return strMsgBody;
	}

	/**********************************************************************************
	 * Description 	: This function is used to get status change pager body
	 * Date 		: 24-Nov-2014
	 * Author 		: Renushree
	 * *******************************************************************************/
	public String getStatusChangePagerBody(String strUpdatedTime, String strResourceName, String strStatusTypeName, String strUpdatedValues, String strRegions) throws Exception {
		String strMsgBody = 	  strStatusTypeName
				+ " from -- to " + strUpdatedValues + "; "
				+ "Reasons:\nSummary at " + strUpdatedTime + "\n"
				+ "Region: " +  strRegions + "";
		return strMsgBody;
	}


	/**********************************************************************************
	 * Description 	: This function is used to get Form mail body
	 * Date 		: 16-Dec-2014
	 * Author 		: Anil
	 * *******************************************************************************/
	public String getFormMailBody(String strUserFullName, String strRegionName, String strLabelName, String strLabelValue) throws Exception {
		String strMsgBody ="Form submitted by "+strUserFullName+"\n\n"+
				strLabelName+": "+strLabelValue+"\n\n"
				+"Region: "+strRegionName;
		return strMsgBody;
	}

	/**********************************************************************************
	 * Description 	: This function is used to get Form mail body
	 * Date 		: 16-Dec-2014
	 * Author 		: Anil
	 * *******************************************************************************/
	public String getFormPagerBody(String strUserFullName, String strRegionName, String strLabelName, String strLabelValue) throws Exception {
		String strMsgBody ="Form submitted by "+strUserFullName+"\n"+
				"| "+strLabelName+": "+strLabelValue+"\n"+
				"Region: "+strRegionName;
		return strMsgBody;
	}


	/**********************************************************************************
	 * Description 	: This function is used to get Form mail body
	 * Date 		: 16-Dec-2014
	 * Author 		: Anil
	 * *******************************************************************************/
	public String getFormMailBody(String strUserFullName, String strRegionName, String strLabelName1, String strLabelValue1, String strLabelName2, String strLabelValue2 ) throws Exception {
		String strMsgBody ="Form submitted by "+strUserFullName+"\n\n"+
				strLabelName1+": "+strLabelValue1+"\n"+
				strLabelName2+": "+strLabelValue2+"\n\n"
				+"Region: "+strRegionName;
		return strMsgBody;
	}

	/**********************************************************************************
	 * Description 	: This function is used to get Form mail body
	 * Date 		: 16-Dec-2014
	 * Author 		: Anil
	 * *******************************************************************************/
	public String getFormPagerBody(String strUserFullName, String strRegionName, String strLabelName, String strLabelValue, String strLabelName2, String strLabelValue2 ) throws Exception {
		String strMsgBody ="Form submitted by "+strUserFullName+"\n"+
				"| "+strLabelName+": "+strLabelValue+"| "+strLabelName2+": "+strLabelValue2+"\n"+
				"Region: "+strRegionName;
		return strMsgBody;
	}

	/**********************************************************************************
	 * Description 	: This function is used to get Form mail body for questionary type as Table
	 * Date 		: 18-Dec-2014
	 * Author 		: Pallavi
	 * *******************************************************************************/
	public String getFormMailBodyForTable(String strUserFullName,
			String strRegionName, String strRow1, String strRow2,
			String strRow3, String strColumn1, String strColumn2,
			String strColumn1Answer1, String strColumn1Answer2,
			String strColumn1Answer3, String strColumn2Answer1,
			String strColumn2Answer2, String strColumn2Answer3)
					throws Exception {
		String strMsgBody = "Form submitted by " + strUserFullName + "\n\n"
				+ strRow1 + ":" + strColumn1 + ": " + strColumn1Answer1 + "\n"
				+ strRow1 + ":" + strColumn2 + ": " + strColumn2Answer1 + "\n"
				+ strRow2 + ":" + strColumn1 + ": " + strColumn1Answer2 + "\n"
				+ strRow2 + ":" + strColumn2 + ": " + strColumn2Answer2 + "\n"
				+ strRow3 + ":" + strColumn1 + ": " + strColumn1Answer3 + "\n"
				+ strRow3 + ":" + strColumn2 + ": " + strColumn2Answer3
				+ "\n\n"
				+ "Region: " + strRegionName;
		return strMsgBody;
	}

	/**********************************************************************************
	 * Description 	: This function is used to get Form mail body for questionary type as Table
	 * Date 		: 16-Dec-2014
	 * Author 		: Anil
	 * *******************************************************************************/
	public String getFormPagerBodyForTable(String strUserFullName,
			String strRegionName, String strRow1, String strRow2,
			String strRow3, String strColumn1, String strColumn2,
			String strColumn1Answer1, String strColumn1Answer2,
			String strColumn1Answer3, String strColumn2Answer1,
			String strColumn2Answer2, String strColumn2Answer3)
					throws Exception {
		String strMsgBody ="Form submitted by "+strUserFullName+"\n"+ "| "
				+ strRow1 + ":" + strColumn1 + ": " + strColumn1Answer1 + "| "
				+ strRow1 + ":" + strColumn2 + ": " + strColumn2Answer1 + "| "
				+ strRow2 + ":" + strColumn1 + ": " + strColumn1Answer2 + "| "
				+ strRow2 + ":" + strColumn2 + ": " + strColumn2Answer2 + "| "
				+ strRow3 + ":" + strColumn1 + ": " + strColumn1Answer3 + "| "
				+ strRow3 + ":" + strColumn2 + ": " + strColumn2Answer3 + "\n"					
				+ "Region: "+strRegionName;
		return strMsgBody;
	}

	/**********************************************************************************
	 * Description 	: This function is used to get Form mail body
	 * Date 		: 16-Dec-2014
	 * Author 		: Anil
	 * *******************************************************************************/
	public String getFormMailBodyWithResource(String strUserFullName, String strRegionName, String strResource, String strLabelName1, String strLabelValue1, String strLabelName2, String strLabelValue2 ) throws Exception {
		String strMsgBody ="Form submitted by "+strUserFullName+" at "+strResource+"\n\n"+
				strLabelName1+": "+strLabelValue1+"\n"+
				strLabelName2+": "+strLabelValue2+"\n\n"
				+"Region: "+strRegionName;
		return strMsgBody;
	}


	/**********************************************************************************
	 * Description 	: This function is used to get Form mail body
	 * Date 		: 16-Dec-2014
	 * Author 		: Anil
	 * *******************************************************************************/
	public String getFormPagerBodyWithResource(String strUserFullName, String strRegionName,String strResource, String strLabelName, String strLabelValue, String strLabelName2, String strLabelValue2 ) throws Exception {
		String strMsgBody ="Form submitted by "+strUserFullName+" at "+strResource+"\n"+
				"| "+strLabelName+": "+strLabelValue+"| "+strLabelName2+": "+strLabelValue2+"\n"+
				"Region: "+strRegionName;
		return strMsgBody;
	}

	/********************************************************************
	 * Description 	: This function is used to verify mail body does not contain
	 * 				  particular message in the message body 
	 * Date 		: 29-Dec-2014
	 * Author 		: Pallavi
	 * ******************************************************************/
	public boolean verMailDoesNotContainGivenMsg(String strMessageBody) throws Exception {
		boolean blnCheck = false;
		String strMsg = this.page.element(messageBody, "css").getOne().getText();
		if(!(strMsg.contains(strMessageBody))){
			blnCheck=true;
		}
		return blnCheck;
	}

	/**********************************************************************************
	 * Description 	: This function is used to get Form mail body for questionnaire type as Table
	 * 				  with Two rows and Two columns.
	 * Date 		: 29-Dec-2014
	 * Author 		: Pallavi
	 * *******************************************************************************/
	public String getFormMailBodyForTable(String strUserFullName,
			String strRegionName, String strRow1, String strRow2,
			String strColumn1, String strColumn2, String strColumn1Answer1,
			String strColumn1Answer2, String strColumn2Answer1,
			String strColumn2Answer2) throws Exception {
		String strMsgBody = "Form submitted by " + strUserFullName + "\n\n"
				+ strRow1 + ":" + strColumn1 + ": " + strColumn1Answer1 + "\n"
				+ strRow1 + ":" + strColumn2 + ": " + strColumn2Answer1 + "\n"
				+ strRow2 + ":" + strColumn1 + ": " + strColumn1Answer2 + "\n"
				+ strRow2 + ":" + strColumn2 + ": " + strColumn2Answer2
				+ "\n\n" + "Region: " + strRegionName;
		return strMsgBody;
	}

	/**********************************************************************************
	 * Description 	: This function is used to get Form mail body for questionary type as Table
	 * 				  with two rows and Two columns.
	 * Date 		: 29-Dec-2014
	 * Author 		: Pallavi
	 * *******************************************************************************/
	public String getFormPagerBodyForTable(String strUserFullName,
			String strRegionName, String strRow1, String strRow2,
			String strColumn1, String strColumn2, String strColumn1Answer1,
			String strColumn1Answer2, String strColumn2Answer1,
			String strColumn2Answer2) throws Exception {
		String strMsgBody = "Form submitted by " + strUserFullName + "\n"
				+ "| " + strRow1 + ":" + strColumn1 + ": " + strColumn1Answer1
				+ "| " + strRow1 + ":" + strColumn2 + ": " + strColumn2Answer1
				+ "| " + strRow2 + ":" + strColumn1 + ": " + strColumn1Answer2
				+ "| " + strRow2 + ":" + strColumn2 + ": " + strColumn2Answer2
				+ "\n" + "Region: " + strRegionName;
		return strMsgBody;
	}

	/**********************************************************************************
	 * Description 	: This function is used to get Form mail body for questionary type as Table
	 * Date 		: 18-Dec-2014
	 * Author 		: Pallavi
	 * *******************************************************************************/
	public String getFormMailBodyForTableFor1Row(String strUserFullName,
			String strRegionName, String strRow1, String strColumn1,
			String strColumn1Answer1) throws Exception {
		String strMsgBody = "Form submitted by " + strUserFullName + "\n\n"
				+ strRow1 + ":" + strColumn1 + ": " + strColumn1Answer1 + "\n"
				+ "\n" + "Region: " + strRegionName;
		return strMsgBody;
	}
	/**********************************************************************************
	 * Description 	: This function is used to get Form mail body for questionary type as Table
	 * Date 		: 16-Dec-2014
	 * Author 		: Anil
	 * *******************************************************************************/
	public String getFormPagerBodyForTableFor1Coloumn(String strUserFullName,
			String strRegionName, String strRow1, String strColumn1,
			String strColumn1Answer1) throws Exception {

		String strMsgBody = "Form submitted by " + strUserFullName + "\n"
				+ "| " + strRow1 + ":" + strColumn1 + ": " + strColumn1Answer1
				+ "\n" + "Region: " + strRegionName;
		return strMsgBody;
	}

	/**********************************************************************************
	 * Description 	: This function is used to get Form mail body
	 * Date 		: 16-Dec-2014
	 * Author 		: Anil
	 * *******************************************************************************/
	public String getFormPagerBodyForThreeLabel(String strUserFullName, String strRegionName, String strLabelName, String strLabelValue,  String strLabelName2, String strLabelValue2,  String strLabelName3, String strLabelValue3) throws Exception {
		String strMsgBody ="Form submitted by "+strUserFullName+"\n"+
				"| "+strLabelName+": "+strLabelValue+"| "+strLabelName2+": "+strLabelValue2+"| "+strLabelName3+": "+strLabelValue3+"\n"+
				"Region: "+strRegionName;
		return strMsgBody;
	}

	/**********************************************************************************
	 * Description 	: This function is used to get Form mail body
	 * Date 		: 16-Dec-2014
	 * Author 		: Anil
	 * *******************************************************************************/
	public String getFormMailBodyForThreeLabel(String strUserFullName, String strRegionName, String strLabelName, String strLabelValue, String strLabelName2, String strLabelValue2, String strLabelName3, String strLabelValue3) throws Exception {
		String strMsgBody ="Form submitted by "+strUserFullName+"\n\n"+
				strLabelName+": "+strLabelValue+"\n"+
				strLabelName2+": "+strLabelValue2+"\n"+
				strLabelName3+": "+strLabelValue3+
				"\n\n"
				+"Region: "+strRegionName;
		return strMsgBody;
	}

	/**********************************************************************************
	 * Description 	: This function is used to get Form mail body
	 * Date 		: 16-Dec-2014
	 * Author 		: Anil
	 * *******************************************************************************/
	public String getFormMailBodyWithResource(String strUserFullName, String strRegionName, String strResource, String strLabelName1, String strLabelValue1) throws Exception {
		String strMsgBody ="Form submitted by "+strUserFullName+" at "+strResource+"\n\n"+
				strLabelName1+": "+strLabelValue1+"\n\n"
				+"Region: "+strRegionName;
		return strMsgBody;
	}

	/**********************************************************************************
	 * Description 	: This function is used to get Form mail body
	 * Date 		: 16-Dec-2014
	 * Author 		: Anil
	 * *******************************************************************************/
	public String getFormPagerBodyWithResource(String strUserFullName, String strRegionName,String strResource, String strLabelName, String strLabelValue) throws Exception {
		String strMsgBody ="Form submitted by "+strUserFullName+" at "+strResource+"\n"+
				"| "+strLabelName+": "+strLabelValue+"\n"+
				"Region: "+strRegionName;
		return strMsgBody;
	}


	/********************************************************************
	 * Description 	: This function is used to verify mail body is displayed
	 * Date 		: 29-Jul-2014
	 * Author 		: Anil
	 * ******************************************************************/
	public int verifyMailBodyWithValue(String strMessageBody) throws Exception {
		int blnCheck = 0;
		objWaitForElement.waitForElements(messageBody, "css");
		String strMsg = this.page.element(messageBody, "css").getOne().getText();
		if(strMsg.equals( strMessageBody)){
			blnCheck=1;
		}
		return blnCheck;
	}
	/**********************************************************************************
	 * Description 	: This function is used to get Form mail body for Choices(Chk BOX)
	 * Date 		: 16-Dec-2014
	 * Author 		: sangappa.k
	 * *******************************************************************************/
	public String getFormMailBodyForChoices(String strUserFullName, String strRegionName, String strLabelName1, String strLabelValue1,String strLabelValue2, String strLabelValue3) throws Exception {
		String strMsgBody ="Form submitted by "+strUserFullName+"\n\n"+
				strLabelName1+": "+strLabelValue1+","+ strLabelValue2+","+strLabelValue3+"\n\n"+
				"Region: "+strRegionName;
		return strMsgBody;
	}
	/**********************************************************************************
	 * Description 	: This function is used to get Form mail body
	 * Date 		: 16-Dec-2014
	 * Author 		: Anil
	 * *******************************************************************************/
	public String getFormPagerBodyForChoices(String strUserFullName, String strRegionName, String strLabelName1, String strLabelValue1,String strLabelValue2, String strLabelValue3) throws Exception {
		String strMsgBody ="Form submitted by "+strUserFullName+"\n"+
				"| "+strLabelName1+": "+strLabelValue1+","+ strLabelValue2+","+strLabelValue3+"\n"+
				"Region: "+strRegionName;
		return strMsgBody;
	}

	/**********************************************************************************
	 * Description 	: This function is used to get pager body
	 * Date 		: 26-May-2015
	 * Author 		: Renushree
	 * *******************************************************************************/
	public String getExpiredStatusPagerBody(String strStatusTypeName,
			String strResourceName, String strApplicationTime) throws Exception {
		String strMsgBody = "EMResource expired status: " + strResourceName
				+ ". " + strStatusTypeName + " status expired "
				+ strApplicationTime + ".";
		return strMsgBody;
	}
	/**********************************************************************************
	 * Description 	: This function is used to get Form mail body for Choices(Chk BOX)
	 * Date 		: 16-Dec-2014
	 * Author 		: sangappa.k
	 * *******************************************************************************/
	public String getFormMailBodyFor2Choices(String strUserFullName, String strRegionName, String strLabelName1, String strLabelValue1,String strLabelValue2) throws Exception {
		String strMsgBody ="Form submitted by "+strUserFullName+"\n\n"+
				strLabelName1+": "+strLabelValue1+","+ strLabelValue2+"\n\n"+
				"Region: "+strRegionName;
		return strMsgBody;
	}

	/**********************************************************************************
	 * Description 	: This function is used to get Form mail body
	 * Date 		: 16-Dec-2014
	 * Author 		: Anil
	 * *******************************************************************************/
	public String getFormPagerBodyFor2Choices(String strUserFullName, String strRegionName, String strLabelName1, String strLabelValue1,String strLabelValue2) throws Exception {
		String strMsgBody ="Form submitted by "+strUserFullName+"\n"+
				"| "+strLabelName1+": "+strLabelValue1+","+ strLabelValue2+"\n"+
				"Region: "+strRegionName;
		return strMsgBody;
	}

	/********************************************************************
	 * Description 	: This function is to get mail body
	 * Date 		: 02-Jun-2015
	 * Author 		: Pallavi
	 * ******************************************************************/
	public String getMailBody() throws Exception {
		objWaitForElement.waitForElements(messageBody, "css");
		String strMsg = this.page.element(messageBody, "css").getOne().getText();
		return strMsg;
	}

	/**********************************************************************************
	 * Description 	: This function is used to get event  mail body
	 * Date 		: 19-Nov-2014
	 * Author 		: Anil
	 * *******************************************************************************/
	public String getEventEmailBodyForFileAttached1(String strUserFullName, String strFullName, String strRegionName, String strEventDescription) throws Exception {
		String strMsgBody = 	  "Event Notice for: " + strUserFullName + "\n"
				+ "Information: " + strEventDescription + "\n\n" + "See attached document at "
				+ "https://emresource.qa.intermedix.com";
		return strMsgBody;
	}


	/**********************************************************************************
	 * Description 	: This function is used to get event  mail body
	 * Date 		: 19-Nov-2014
	 * Author 		: Anil
	 * *******************************************************************************/
	public String getEventEmailBodyForFileAttached2(String strUserFullName, String strFullName, String strRegionName, String strEventDescription) throws Exception {
		String strMsgBody = "From: "
				+ strFullName + "\n\n" + "Regions: " + strRegionName
				+ "\n\nPlease do not reply to this email message. "
				+ "You must log into EMResource to take any "
				+ "action that may be required.";
		return strMsgBody;
	}

	/**********************************************************************************
	 * Description 	: This function is used to enter page number
	 * Date 		: 23-Jun-2015
	 * Author 		: Renushree
	 * *******************************************************************************/
	public MailVerificationFunctions clickOnSelectedInbox() throws Exception {
		driver.switchTo().frame("horde_main");
		this.page.element(clickedIinbox, "xpath").getOne()
		.click();
		return this;
	}

	/**********************************************************************************
	 * Description 	: This function is used to get IPN  mail body
	 * Date 		: 19-Nov-2014
	 * Author 		: Anil
	 * *******************************************************************************/
	public String getIPNMail(String strFullName, String strRegionName, String strApplicationTime, String strGender, String strAge, String strChiefComplaint,
			String strTriageCategory, String strLevelOfCare, String strEMSAgency, String strEMSUnit) throws Exception {
		String strMsgBody = "Message from system"
				+ "\n\n"
				+ "Please do not reply to this email message. You must log into "
				+ "EMResource to take any action that may be required."
				+ "\n\n" + "Sent By: " + strFullName
				+ "\nAge: " + strAge + "\nETA: "
				+ strApplicationTime + "\nChief Complaint: " + strChiefComplaint
				+ "\nTriage Category: " + strTriageCategory + "\nGender: " + strGender+"\nLevel Of Care: "+strLevelOfCare+"\nEMS Agency: "+strEMSAgency+"\nEMS Unit: "+strEMSUnit
				+ "\n\nRegion: " + strRegionName;
		return strMsgBody;
	}

	/**********************************************************************************
	 * Description 	: This function is used to get IPN  pager body
	 * Date 		: 19-Nov-2014
	 * Author 		: Anil
	 * *******************************************************************************/
	public String getIPNPager(String strFullName, String strRegionName, String strApplicationTime, String strGender, String strAge, String strChiefComplaint,
			String strTriageCategory, String strLevelOfCare, String strEMSAgency, String strEMSUnit) throws Exception {
		String strMsgBody = "sent by: " + strFullName
				+ " | age: " + strAge + " | ETA: " + strApplicationTime
				+ " | complaint: " + strChiefComplaint + " | triage: " + strTriageCategory
				+ " | gender: " + strGender 
				+ " | level of care: " + strLevelOfCare 
				+ " | ems agency: " + strEMSAgency
				+ " | ems unit: " + strEMSUnit
				+ " |\nregion: "
				+ strRegionName;
		return strMsgBody;
	}

	/**********************************************************************************
	 * Description 	: This function is used to get Event mail body with address
	 * Date 		: 19-Nov-2014
	 * Author 		: Anil
	 * *******************************************************************************/
	public String getEventMailWithAddress(String strFullName,String strFullName1, String strRegionName, String strEventDescription, String strCity, 
			String strCountrycode,String strZipCode, String strCountry, String strUrl  ) throws Exception {
		String strMsgBody = "Event Notice for: " + strFullName
				+ "\n" + "Information: " + strEventDescription
				+ "\n\n" + "Location: " + strCity + ", "+strCountrycode+" "
				+ strZipCode + " "
				+ strCountry + "\n\n" + "From: "
				+ strFullName1 + "\n\n" + "Regions: "
				+ strRegionName
				+ "\n\nPlease do not reply to this email message. "
				+ "You must log into EMResource to take any "
				+ "action that may be required." + "\n" + strUrl;
		return strMsgBody;
	}

	/**********************************************************************************
	 * Description 	: This function is used to get Event pager body with address
	 * Date 		: 19-Nov-2014
	 * Author 		: Anil
	 * *******************************************************************************/
	public String getEventPagerWithAddress(String strFullName,String strFullName1, String strRegionName, String strEventDescription, String strCity, 
			String strCountrycode,String strZipCode, String strCountry ) throws Exception {
		String strMsgBody = "Information: "
				+ strEventDescription + "\nLocation: "
				+ strCity + ", "+strCountrycode+" "
				+ strZipCode + " "
				+ strCountry + "\nFrom: "
				+ strFullName1 + "\nRegions: "
				+ strRegionName;
		return strMsgBody;
	}

	/**********************************************************************************
	 * Description 	: This function is used to get status change mail body
	 * Date 		: 24-Nov-2014
	 * Author 		: Anil
	 * *******************************************************************************/
	public String getStatusChangeEmailBodyForNST(String strUserFullName, String strUpdatedTime, String strResourceName, String strStatusTypeName, String strUpdatedValues, String strRegions, String strResType) throws Exception {
		String strMsgBody ="Status Update for " + strUserFullName
				+ ":" + "\nOn " + strUpdatedTime + " " + strResourceName + " "
				+ "changed " + strStatusTypeName
				+ " status from 0 " + "to " + strUpdatedValues
				+ ".\n\nComments:\n\nReasons:\n\nRegion: " + ""
				+ strRegions
				+ "\n\nOther "+strResType+"s in the region report the following "+strStatusTypeName+" status:\n\n\nPlease do not reply to this email message."
				+ " You must log into EMResource to take any action that may"
				+ " be required.";
		return strMsgBody;
	}

	/**********************************************************************************
	 * Description 	: This function is used to get status change pager body
	 * Date 		: 24-Nov-2014
	 * Author 		: Anil
	 * *******************************************************************************/
	public String getStatusChangePagerBodyForNST(String strUpdatedTime, String strResourceName, String strStatusTypeName, String strUpdatedValues, String strRegions) throws Exception {
		String strMsgBody = 	  strStatusTypeName
				+ " from 0 to " + strUpdatedValues + "; "
				+ "Reasons:\nSummary at " + strUpdatedTime + "\n"
				+ "Region: " +  strRegions + "";
		return strMsgBody;
	}


	/**********************************************************************************
	 * Description 	: This function is get IPN subject name
	 * Date 		: 18-Jun-2014
	 * Author 		: Anil
	 * ********************************************************************************
	 */
	public String getIPNEMailSubject(String strResourceName) throws Exception {
		String  strSubjectName = "Incoming Patient Notification for "+strResourceName;
		return strSubjectName;
	}


	/**********************************************************************************
	 * Description 	: This function is get ICS subject name
	 * Date 		: 18-Jun-2014
	 * Author 		: Anil
	 * ********************************************************************************
	 */
	public String getICSEMailSubject(String strResourceName) throws Exception {
		String  strSubjectName = "Incident Alert for "
				+ strResourceName;
		return strSubjectName;
	}


	/**********************************************************************************
	 * Description 	: This function is used to get ICS notification email body
	 * Date 		: 24-Nov-2014
	 * Author 		: Anil
	 * *******************************************************************************/
	public String getICSEMailBody(String strResourceName, String strIncidentName, String strIncidentDesc) throws Exception {
		String strMsgBody = "*** THIS IS AN ACTUAL INCIDENT ***"
				+ "\n"
				+ " This message is to inform you that "
				+ strResourceName
				+ " is experiencing "
				+ strIncidentName
				+ "."
				+ "\n"
				+ " "
				+ strIncidentDesc
				+ "."
				+ "\n"
				+ " * Contact your facility with any questions. Do not reply directly to this email.";
		return strMsgBody;
	}

	/**********************************************************************************
	 * Description 	: This function is used to get status change mail body
	 * Date 		: 24-Nov-2014
	 * Author 		: Sangappa K
	 * *******************************************************************************/
	public String getStatusChangeEmailBodyForMultiStWith3Reasons(
			String strUserFullName, String strUpdatedTime,
			String strResourceName, String strStatusTypeName,
			String strUpdatedValues, String strRegions, String strResType,
			String strReason, String strReason1, String strReason2)
					throws Exception {
		String strMsgBody ="Status Update for " + strUserFullName
				+ ":" + "\nOn " + strUpdatedTime + " " + strResourceName + " "
				+ "changed " + strStatusTypeName
				+ " status from -- " + "to " + strUpdatedValues
				+ ".\n\nComments:\n\nReasons: "+strReason+","+strReason1+","+strReason2+"\n\nRegion: " + ""
				+ strRegions
				+ "\n\nOther "+strResType+"s in the region report the following "+strStatusTypeName+" status:\n\n\nPlease do not reply to this email message."
				+ " You must log into EMResource to take any action that may"
				+ " be required.";
		return strMsgBody;
	}

	/**********************************************************************************
	 * Description 	: This function is used to get status change pager body
	 * Date 		: 24-Nov-2014
	 * Author 		: Sangappa K
	 * *******************************************************************************/
	public String getStatusChangePagerBodyForMultiStWith3Reasons(
			String strUpdatedTime, String strResourceName,
			String strStatusTypeName, String strUpdatedValues,
			String strRegions, String strReason, String strReason1,
			String strReason2) throws Exception {
		String strMsgBody = 	  strStatusTypeName
				+ " from -- to " + strUpdatedValues + "; "
				+ "Reasons: "+strReason+","+strReason1+","+strReason2+"\nSummary at " + strUpdatedTime + "\n"
				+ "Region: " +  strRegions + "";
		return strMsgBody;
	}

	/**********************************************************************************
	 * Description 	: This function is used to get ICS notification email body for drill incident
	 * Date 		: 22-Oct-2015
	 * Author 		: Renushree
	 * *******************************************************************************/
	public String getICSEMailBodyForDrillInc(String strResourceName, String strIncidentName, String strIncidentDesc) throws Exception {
		String strMsgBody = "*** THIS IS A DRILL ***"
				+ "\n"
				+ " The following message is a Exercise/Drill at "
				+ strResourceName
				+ " is "
				+ "experiencing "
				+ strIncidentName
				+ "."
				+ "\n"
				+ " "
				+ strIncidentDesc
				+ "."
				+ "\n"
				+ " * Contact your facility with any questions. Do not reply directly to this email.";
		return strMsgBody;
	}

	/**********************************************************************************
	 * Description 	: This function is used to get event  mail body
	 * Date 		: 19-Nov-2014
	 * Author 		: Anil
	 * *******************************************************************************/
	public String getEmailBodyForMRE(String strUserFullName, String strFullName, String strRegionName1,String strRegionName2,  String strEventDescription) throws Exception {
		String strMsgBody = "Event Notice for: " + strFullName
				+ "\n" + "Information: " + strEventDescription
				+ "\n\n" + "From: " + strFullName + "\n\n"
				+ "Regions: " + strRegionName1
				+ ", " + strRegionName2
				+ "\n\nPlease do not reply to this email message. "
				+ "You must log into EMResource to take any "
				+ "action that may be required." + "\n" +  "https://emresource.qa.intermedix.com";
		return strMsgBody;
	}

	/**********************************************************************************
	 * Description 	: This function is used to get event  mail body
	 * Date 		: 19-Nov-2014
	 * Author 		: Anil
	 * *******************************************************************************/
	public String getPagerBodyForMRE( String strFullName, String strRegionName1,String strRegionName2,  String strEventDescription) throws Exception {
		String strMsgBody =  "Information: "
				+ strEventDescription + "\nFrom: "
				+ strFullName + "\nRegions: "
				+ strRegionName1
				+ ", " + strRegionName2;
		return strMsgBody;
	}


	/**********************************************************************************
	 * Description 	: This function is used to get event  mail body
	 * Date 		: 19-Nov-2014
	 * Author 		: Anil
	 * *******************************************************************************/
	public String getPagerBodyForMREAddingRegion( String strFullName, String strRegionName1,String strRegionName2,  String strEventDescription) throws Exception {
		String strMsgBody =  "Region: "+strRegionName1+" now participating"+
				"\nInformation: "
				+ strEventDescription + "\nFrom: "
				+ strFullName + "\nRegions: "
				+ strRegionName1
				+ ", " + strRegionName2;
		return strMsgBody;
	}

	/**********************************************************************************
	 * Description 	: This function is used to get event  mail body
	 * Date 		: 19-Nov-2014
	 * Author 		: Anil
	 * *******************************************************************************/
	public String getEmailBodyForMREAddingRegion(String strUserFullName, String strFullName, String strRegionName1,String strRegionName2,  String strEventDescription) throws Exception {
		String strMsgBody = "Event Notice for: " + strFullName
				+"\n\nRegion: "+strRegionName1+" now participating"
				+ "\n\n" + "Information: " + strEventDescription
				+ "\n\n" + "From: " + strFullName + "\n\n"
				+ "Regions: " + strRegionName1
				+ ", " + strRegionName2
				+ "\n\nPlease do not reply to this email message. "
				+ "You must log into EMResource to take any "
				+ "action that may be required." + "\n" +  "https://emresource.qa.intermedix.com";
		return strMsgBody;
	}

	/**********************************************************************************
	 * Description 	: This function is used to get status change mail body if Updated Rs is assosciatted with other Rs1
	 * Date 		: 12-Jan-2016
	 * Author 		:Sangappa K
	 * *******************************************************************************/
	public String getStatusChangeEmailBodyWithAsstdRescrsForNST(String strUserFullName, String strUpdatedTime, String strResourceName, String strStatusTypeName, String strUpdatedValues, String strRegions, String strResType,String strResourceName1) throws Exception {
		String strMsgBody ="Status Update for " + strUserFullName
				+ ":" + "\nOn " + strUpdatedTime + " " +strResourceName + " "
				+ "changed " + strStatusTypeName
				+ " status from 0 " + "to " + strUpdatedValues
				+ ".\n\nComments:\n\nReasons:\n\nRegion: " + ""
				+ strRegions
				+ "\n\nOther "+strResType+"s in the region report the following "+strStatusTypeName+" status:\n"+strResourceName1+" = 0"+"\n\n\nPlease do not reply to this email message."
				+ " You must log into EMResource to take any action that may"
				+ " be required.";
		return strMsgBody;
	}

	/**********************************************************************************
	 * Description 	: This function is used to get status change mail body if Updated Rs is assosciatted with other Rs1
	 * Date 		: 12-Jan-2016
	 * Author 		:Sangappa K
	 * *******************************************************************************/
	public String getStatusChangeEmailBodyWithAssctdRescrsForMST(String strUserFullName, String strUpdatedTime, String strResourceName, String strStatusTypeName, String strUpdatedValues, String strRegions, String strResType,String strResourceName1) throws Exception {
		String strMsgBody ="Status Update for " + strUserFullName
				+ ":" + "\nOn " + strUpdatedTime + " " +strResourceName + " "
				+ "changed " + strStatusTypeName
				+ " status from -- " + "to " + strUpdatedValues
				+ ".\n\nComments:\n\nReasons:\n\nRegion: " + ""
				+ strRegions
				+ "\n\nOther "+strResType+"s in the region report the following "+strStatusTypeName+" status:\n"+strResourceName1+" = --"+"\n\n\nPlease do not reply to this email message."
				+ " You must log into EMResource to take any action that may"
				+ " be required.";
		return strMsgBody;
	}


	/**********************************************************************************
	 * Description 	: This function is used to get status change pager body if Updated Rs is assosciatted with other Rs1
	 * Date 		: 12-Jan-2016
	 * Author 		:Sangappa K
	 * *******************************************************************************/
	public String getStatusChangePagerBodyForWithAsstdRescrsForNST(String strUpdatedTime, String strResourceName, String strStatusTypeName, String strUpdatedValues, String strRegions,String strOtherResAbb) throws Exception {
		String strMsgBody = 	  strStatusTypeName
				+ " from 0 to " + strUpdatedValues + "; "
				+ "Reasons:\nSummary at " + strUpdatedTime +" "+strOtherResAbb+"[0]"+"\n"
				+ "Region: " +  strRegions + "";
		return strMsgBody;
	}

	/**********************************************************************************
	 * Description 	: This function is used to get status change pager body if Updated Rs is assosciatted with other Rs1
	 * Date 		: 12-Jan-2016
	 * Author 		:Sangappa K
	 * *******************************************************************************/
	public String getStatusChangePagerBodyForWithAsstdRescrsForMST(String strUpdatedTime, String strResourceName, String strStatusTypeName, String strUpdatedValues, String strRegions,String strOtherResAbb) throws Exception {
		String strMsgBody = 	  strStatusTypeName
				+ " from -- to " + strUpdatedValues + "; "
				+ "Reasons:\nSummary at " + strUpdatedTime +" --: "+strOtherResAbb+"\n"
				+ "Region: " +  strRegions + "";
		return strMsgBody;
	}

	/**********************************************************************************
	 * Description 	: This function is used to get status change mail body if Updated Rs is assosciatted with other Rs1
	 * Date 		: 12-Jan-2016
	 * Author 		:Sangappa K
	 * *******************************************************************************/
	public String getStatusChangeEmailBodyNEDocsSt(String strUserFullName, String strUpdatedTime, String strResourceName, String strStatusTypeName, String strUpdatedValues, String strRegions, String strResType) throws Exception {
		String strMsgBody ="Status Update for " + strUserFullName
				+ ":" + "\nOn " + strUpdatedTime + " " +strResourceName + " "
				+ "changed " + strStatusTypeName
				+ " status from 0 " + "to " + strUpdatedValues
				+ ".\n\nComments:\n\nReasons:\n\nRegion: " + ""
				+ strRegions
				+ "\n\nOther "+strResType+"s in the region report the following "+strStatusTypeName+" status:"+"\n\n\nPlease do not reply to this email message."
				+ " You must log into EMResource to take any action that may"
				+ " be required.";
		return strMsgBody;
	}


	/**********************************************************************************
	 * Description 	: This function is used to getsubject name of forgot username email
	 * Date 		: 12-Jan-2016
	 * Author 		:Anil
	 * *******************************************************************************/
	public String getForgotUserEmailSubject() throws Exception {
		String strSubject = "forgot username email";
		return strSubject;
	}	

	/**********************************************************************************
	 * Description 	: This function is used to get status change mail body
	 * Date 		: 24-Nov-2014
	 * Author 		: Anil
	 * *******************************************************************************/
	public String getStatusChangeSubRSEmailBodyForNST(String strUserFullName, String strUpdatedTime, String strResourceName, String strStatusTypeName, String strUpdatedValues, String strRegions) throws Exception {
		String strMsgBody ="Status Update for " + strUserFullName
				+ ":" + "\nOn " + strUpdatedTime + " " + strResourceName + " "
				+ "changed " + strStatusTypeName
				+ " status from 0 " + "to " + strUpdatedValues
				+ ".\n\nComments:\n\nReasons:\n\nRegion: " + ""
				+ strRegions
				+ "\n\n\n\nPlease do not reply to this email message."
				+ " You must log into EMResource to take any action that may"
				+ " be required.";
		return strMsgBody;
	}

	/**********************************************************************************
	 * Description 	: This function is used to get status change mail body
	 * Date 		: 24-Nov-2014
	 * Author 		: Anil
	 * *******************************************************************************/
	public String getStatusChangeSubRSEmailBody(String strUserFullName, String strUpdatedTime, String strResourceName, String strStatusTypeName, String strUpdatedValues, String strRegions) throws Exception {
		String strMsgBody ="Status Update for " + strUserFullName
				+ ":" + "\nOn " + strUpdatedTime + " " + strResourceName + " "
				+ "changed " + strStatusTypeName
				+ " status from -- " + "to " + strUpdatedValues
				+ ".\n\nComments:\n\nReasons:\n\nRegion: " + ""
				+ strRegions
				+ "\n\n\n\nPlease do not reply to this email message."
				+ " You must log into EMResource to take any action that may"
				+ " be required.";
		return strMsgBody;
	}

	/**********************************************************************************
	 * Description 	: This function is used to get status change mail body
	 * Date 		: 24-Nov-2014
	 * Author 		: Anil
	 * *******************************************************************************/
	public String getStatusChangeSubRSEmailBody(String strUserFullName, String strUpdatedTime, String strResourceName, String strStatusTypeName, String strPreviousValues, String strUpdatedValues, String strRegions) throws Exception {
		String strMsgBody ="Status Update for " + strUserFullName
				+ ":" + "\nOn " + strUpdatedTime + " " + strResourceName + " "
				+ "changed " + strStatusTypeName
				+ " status from "+strPreviousValues+" " + "to " + strUpdatedValues
				+ ".\n\nComments:\n\nReasons:\n\nRegion: " + ""
				+ strRegions
				+ "\n\n\n\nPlease do not reply to this email message."
				+ " You must log into EMResource to take any action that may"
				+ " be required.";
		return strMsgBody;
	}


	/**********************************************************************************
	 * Description 	: This function is used to get status change pager body
	 * Date 		: 24-Nov-2014
	 * Author 		: Pallavi
	 * *******************************************************************************/
	public String getStatusChangePagerBody(String strUpdatedTime, String strResourceName, String strStatusTypeName, String strPreviousValues, String strUpdatedValues, String strRegions) throws Exception {
		String strMsgBody = 	  strStatusTypeName
				+ " from "+strPreviousValues+" to " + strUpdatedValues + "; "
				+ "Reasons:\nSummary at " + strUpdatedTime + "\n"
				+ "Region: " +  strRegions + "";
		return strMsgBody;
	}

	/**********************************************************************************
	 * Description 	: This function is used to get status change mail body for other reg
	 * Date 		: 18-Feb-2016
	 * Author 		: Renushree
	 * *******************************************************************************/
	public String getStatusChangeRSEmailBodyAndOtherReg(String strUserFullName, String strUpdatedTime, String strResourceName, String strStatusTypeName, String strPreviousValues, String strUpdatedValues, String strRegions, String strResType) throws Exception {
		String strMsgBody ="Status Update for " + strUserFullName
				+ ":" + "\nOn " + strUpdatedTime + " " + strResourceName + " "
				+ "changed " + strStatusTypeName
				+ " status from "+strPreviousValues+" " + "to " + strUpdatedValues
				+ ".\n\nComments:\n\nReasons:\n\nRegion: " + ""
				+ strRegions+"\n\nOther "+strResType+"s in the region report the following "+strStatusTypeName+" status:"
				+ "\n\n\n\nPlease do not reply to this email message."
				+ " You must log into EMResource to take any action that may"
				+ " be required.";
		return strMsgBody;
	}
	//sandhya
	public void clickOnProfile() throws Exception {
		objWaitForElement.waitForElements(profile, "xpath");
		assertTrue(this.page.element(profile, "xpath").getOne().isDisplayed());
		this.page.element(profile, "xpath").getOne().sendKeys(Keys.ENTER);
	}

	public void clickOnSignOut() throws Exception {
		objWaitForElement.waitForElements(signOut, "xpath");
		assertTrue(this.page.element(signOut, "xpath").getOne().isDisplayed());
		this.page.element(signOut, "xpath").getOne().sendKeys(Keys.ENTER);
	}

	public void waitForInbox() throws Exception {
		objWaitForElement.waitForElements(inbox, "css");
	}
	
	public void clickOnSignIn() throws Exception {
		objWaitForElement.waitForElements(signIn, "xpath");
		this.page.element(signIn, "xpath").mouseOver();
		this.page.element(signIn, "xpath").clickUsingJSE();
		objWaitForElement.waitForElements(userID, "css");
	}
}