package EMR.pages;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import qaFramework.WaitTimeConstants;
import qaFramework.UserDefinedFunctions.Date_Time_settings;
import qaFramework.UserDefinedFunctions.WaitForElement;
import qaFramework.pageObject.PageObject;
import EMR.Locators.Mails.Locators;
import EMR.data.MailsData;

public class Mails extends PageObject{

	WebDriver driver;
	WaitForElement waitForElement;
	Date_Time_settings dateAndTime;

	public Mails(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		waitForElement = new WaitForElement(this.driver);
		dateAndTime = new Date_Time_settings();
	}

	public void loginToMail(String userName, String password) throws Exception {
		driver.navigate().to(Locators.URL);
		if(this.page.element(Locators.SIGN_IN, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE)) {
			this.clickOnSignIn();
		}
		this.enterUserId(userName);
		this.clickOnLogin();
		this.enterPassword(password);
		this.clickOnLogin();
		this.waitForInbox();	
	}

	public void enterUserId(String _userID) throws Exception {
		waitForElement.waitForElements(Locators.USERID, "css");
		this.page.element_wait(Locators.USERID, "css").waitForElementEnable();
		this.page.element(Locators.USERID, "css").mouseOver();
		this.page.element(Locators.USERID, "css").clearInputValue().sendKeys(_userID);
	}

	public void enterPassword(String _password) throws Exception {
		waitForElement.waitForElements(Locators.PASSWORD, "css");
		this.page.element_wait(Locators.PASSWORD, "css").waitForElementEnable();
		this.page.element(Locators.PASSWORD, "css").mouseOver();
		this.page.element(Locators.PASSWORD, "css").clearInputValue().sendKeys(_password);
	}

	public void clickOnLogin() throws Exception {
		waitForElement.waitForElements(Locators.LOGIN, "css");
		this.page.element(Locators.LOGIN, "css").clickUsingJSE();
	}
	
	public void clickOnSignIn() throws Exception {
		waitForElement.waitForElements(Locators.SIGN_IN, "xpath");
		this.page.element(Locators.SIGN_IN, "xpath").mouseOver();
		this.page.element(Locators.SIGN_IN, "xpath").clickUsingJSE();
		waitForElement.waitForElements(Locators.USERID, "css");
	}
	
	public void waitForInbox() throws Exception {
		waitForElement.waitForElements(Locators.INBOX, "css");
	}

	public void NavToInbox(String subject) throws Exception {
		subject = subject.replace("EMResource ", "");
		subject = "EMResource QA/Test " + subject;
		Actions action = new Actions(this.driver);
		boolean blnFound1 = false;
		int intCnt1 = 0;
		driver.manage()
		.timeouts()
		.implicitlyWait(WaitTimeConstants.WAIT_TIME_LONG,
				TimeUnit.SECONDS);
		while (blnFound1 == false && intCnt1 < 60) {
			try {
				waitForElement.waitForElements(Locators.INBOX, "xpath");
				action.moveToElement(this.page.element(Locators.INBOX, "xpath").getOne())
				.click().build().perform();
				waitForElement.waitForElements(
						Locators.SUBJECT_PART1 + subject + Locators.SUBJECT_PART2, "xpath");
				assertTrue(this.page.element(
						"//div[contains(@aria-label,'Unread, ')]/div/div/span[text()='"
								+ subject + Locators.CLOSING_BRACKETS, "xpath").isElementPresent(
										WaitTimeConstants.COUNT));
				blnFound1 = true;
			} catch (Exception e) {
				Thread.sleep(1000);
				intCnt1++;
			}
		}
	}

	/**********************************************************************************
	 * Description 	: This function is used to navigate to Inbox 
	 * Date 		: 18-Jun-2014
	 * Author 		: Yugender
	 * ******************************************************************
	 */
	public void NavToInboxNew(String subject) throws Exception {
		Actions action = new Actions(this.driver);
		boolean blnFound1 = false;
		int intCnt1 = 0;
		driver.manage()
		.timeouts()
		.implicitlyWait(WaitTimeConstants.WAIT_TIME_LONG,
				TimeUnit.SECONDS);
		while (blnFound1 == false && intCnt1 < 60) {
			try {
				waitForElement.waitForElements(Locators.INBOX, "xpath");
				action.moveToElement(this.page.element(Locators.INBOX, "xpath").getOne())
				.click().build().perform();
				waitForElement.waitForElements(Locators.SUBJECT_PART1 + subject + Locators.SUBJECT_PART2, "xpath");
				assertTrue(this.page.element(Locators.SUBJECT_PART1 + subject + Locators.SUBJECT_PART2, "xpath").isElementPresent(
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
	
	public void verifyEmail(String subject) throws Exception {
		subject = subject.replace("EMResource ", "");
		subject = "EMResource QA/Test " + subject;
		Actions action = new Actions(this.driver);
		String subjectElement = Locators.SUBJECT_PART1 + subject + Locators.SUBJECT_PART2;
		System.out.println(subject);
		waitForElement.waitForElements(subjectElement, "xpath");
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
		waitForElement.waitForElements(Locators.REPLY_ALL, "xpath");
//		assertTrue(this.page.element(Locators.MESSAGEBODY, "css").getOne().getText().contains("THIS MESSAGE IS FROM THE QA/TEST ENVIRONMENT."));
	}

	public void verEmailNew(String subject) throws Exception {
		String subjectElement = Locators.SUBJECT_PART1 + subject + Locators.SUBJECT_PART2;
		waitForElement.waitForElements(subjectElement, "xpath");
		assertTrue(this.page.element(subjectElement, "xpath")
				.isElementPresent());
		this.page.element(subjectElement, "xpath").getOne().click();
		waitForElement.waitForElements(
				Locators.READING_PANE 
						+ subject + Locators.CLOSING_BRACKETS, "xpath");
		Thread.sleep(5000);
	}

	public Mails NavToInboxAndVerEmailIsNotPresent(String subject)
			throws Exception {
		subject = subject.replace("EMResource ", "");
		subject = "EMResource QA/Test " + subject;
		String subjectElement = Locators.SUBJECT_PART1 + subject + Locators.SUBJECT_PART2;
		waitForElement.waitForElements(subjectElement, "xpath");
		assertFalse(this.page.element(subjectElement, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE), "Email is present");
		return this;
	}

	public void logoutMail() throws Exception {
		driver.switchTo().defaultContent();
		try{
		driver.navigate().to(Locators.SIGNOUT);
		} catch (Exception e) {
			
		}
	}

	public boolean verifyMailBody(String messageBody) throws Exception {
		boolean blnCheck = false;
		waitForElement.waitForElements(Locators.MESSAGEBODY, "css");
		String strMsg = this.page.element(Locators.MESSAGEBODY, "css").getOne().getText();
		System.out.println("CAPTURED: " + strMsg);
		System.out.println("FORMED: " + messageBody);
		if(strMsg.contains(messageBody)){
			blnCheck=true;
		}
		return blnCheck;
	}

	public boolean verifyMailBodyWithoutJunkCharacters(String _messageBody) throws Exception {
		boolean blnCheck = false;
		waitForElement.waitForElements(Locators.MESSAGEBODY, "css");
		String strMsg = this.page.element(Locators.MESSAGEBODY, "css").getOne()
				.getText();
    	System.out.println("CAPTURED: " + strMsg);
		System.out.println("messageBody" + _messageBody);
		if (strMsg.contains(_messageBody)) {
			blnCheck = true;
		}
		return blnCheck;
	}

	public void backToMailInbox() throws Exception {
		Actions action = new Actions(this.driver);
		waitForElement.waitForElements(Locators.CLOSE, "xpath");
		action.moveToElement(this.page.element(Locators.CLOSE, "xpath").getOne()).click().build().perform();
		try{
			Thread.sleep(7000);
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		}catch (NoAlertPresentException nae) {
			System.out.println("no alert");
		}
	}

	public boolean verifyMailContainsBody(String messageBody) throws Exception {

		boolean blnCheck = false;
		waitForElement.waitForElements(Locators.MESSAGEBODY, "css");
		String strMsg = this.page.element(Locators.MESSAGEBODY, "css").getOne().getText();
		System.out.println("CAPTURED: "+strMsg);
		System.out.println("FORMED: "+ messageBody);
		if(strMsg.contains(messageBody)){

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
	public void NavToInboxAndVerEmailIsNotPresentNew(String subject)
			throws Exception {
		subject = subject.replace("EMResource ", "");
		subject = "EMResource QA/Test " + subject;
		String subjectElement = Locators.SUBJECT_PART1 + subject + Locators.SUBJECT_PART2;
		waitForElement.waitForElements(subjectElement, "xpath");
		assertFalse(this.page.element(subjectElement, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE),
				"Email is present");
	}

	/********************************************************************
	 * Description 	: This function is used to fetch the URL link from the message body
	 * Date 		: 20-Aug-2014
	 * Author 		: Sowmya
	 * ******************************************************************/
	public String GetUrlLinkFromMsgBody(String to, String subject)
			throws Exception {
		String strURL = "";
		waitForElement.waitForElements(Locators.URLLINK, "xpath");
		if (this.page.element(Locators.URLLINK, "xpath").isElementPresent()) {
			strURL = this.page.element(Locators.URLLINK, "xpath").getOne().getText();
		}
		return strURL;
	}

	public int getTotalEMailCount(String subject)
			throws Exception {
		int intCount = 0;
		waitForElement.waitForElements(Locators.READING_PANE + subject + Locators.CLOSING_BRACKETS, "xpath");
		intCount = this.page.element(Locators.READING_PANE + subject + Locators.CLOSING_BRACKETS, "xpath").getXpathCount();
		return intCount;
	}

	public void clickOnNextButton() throws Exception {
		waitForElement.waitForElements("//a[@id='next']/img", "xpath");
		this.page.element("//a[@id='next']/img", "xpath").getOne().click();
	}

	public String getExpiredStatusEmailBody(String userFullName, String regionName, String statusTypeName, String resourceName, String applicationTime) throws Exception {
		String msgBody = "For "
				+ userFullName
				+ "\nRegion: "
				+ regionName
				+ "\n\nThe "
				+ statusTypeName
				+ " status for "
				+ resourceName
				+ " expired "
				+ applicationTime
				+ ".\n\nClick the link below to go to the EMResource login screen:"
				+

				"\n\n        "
				+ "https://emresource.qa.intermedix.com"
				+ "\n\nPlease do not reply to this email message. "
				+ "You must log into EMResource to take any action that may be required."
				+ "\n\n\nYou have signed up to receive expired "
				+ "status notifications. If you no longer"
				+ " want to receive expired status notifications,"
				+ " log onto EMResource and deselect the notification fields on the Preferences -> System Notification screen.";
		return msgBody;
	}


	public String getEventEmailBody(String userFullName, String fullName, String regionName, String eventDescription) throws Exception {
		String msgBody = 	  "Event Notice for: " + userFullName + "\n"
				+ "Information: " + eventDescription + "\n\n" + "From: "
				+ fullName + "\n\n" + "Regions: " + regionName
				+ "\n\nPlease do not reply to this email message. "
				+ "You must log into EMResource to take any "
				+ "action that may be required." + "\n"
				+ "https://emresource.qa.intermedix.com";
		return msgBody;
	}

	public String getEventPagerBody(String userFullName, String regionName, String eventDescription) throws Exception {
		String msgBody = "Information: " + eventDescription + "\nFrom: "
				+ userFullName + "\nRegions: " + regionName;
		return msgBody;
	}

	public String getStatusChangeEmailBody(String userFullName, String updatedTime, String resourceName, String statusTypeName, String updatedValues, String regions, String resourceType) throws Exception {
		String msgBody ="Status Update for " + userFullName
				+ ":" + "\nOn " + updatedTime + " " + resourceName + " "
				+ "changed " + statusTypeName
				+ " status from -- " + "to " + updatedValues
				+ ".\n\nComments:\n\nReasons:\n\nRegion: " + ""
				+ regions
				+ "\n\nOther "+resourceType+"s in the region report the following "+statusTypeName+" status:\n\n\nPlease do not reply to this email message."
				+ " You must log into EMResource to take any action that may"
				+ " be required.";
		return msgBody;
	}

	public String getStatusChangePagerBody(String updatedTime, String resourceName, String statusTypeName, String updatedValues, String regions) throws Exception {
		String msgBody = 	  statusTypeName
				+ " from -- to " + updatedValues + "; "
				+ "Reasons:\nSummary at " + updatedTime + "\n"
				+ "Region: " +  regions + "";
		return msgBody;
	}

	public String getFormMailBody(String userFullName, String regionName, String labelName, String labelValue) throws Exception {
		String msgBody ="Form submitted by "+userFullName+"\n\n"+
				labelName+": "+labelValue+"\n\n"
				+"Region: "+regionName;
		return msgBody;
	}

	public String getFormPagerBody(String userFullName, String regionName, String labelName, String labelValue) throws Exception {
		String msgBody ="Form submitted by "+ userFullName +"\n"+
				"| "+ labelName +": "+ labelValue +"\n"+
				"Region: "+ regionName;
		return msgBody;
	}

	public String getFormMailBody(String userFullName, String regionName, String labelName1, String labelValue1, String labelName2, String labelValue2 ) throws Exception {
		String msgBody ="Form submitted by "+userFullName+"\n\n"+
				labelName1+": "+ labelValue1 +"\n"+
				labelName2+": "+ labelValue2 +"\n\n"
				+"Region: "+ regionName;
		return msgBody;
	}

	public String getFormPagerBody(String userFullName, String regionName, String labelName, String labelValue, String labelName2, String labelValue2 ) throws Exception {
		String msgBody ="Form submitted by "+userFullName+"\n"+
				"| "+labelName+": "+labelValue+"| "+labelName2+": "+labelValue2+"\n"+
				"Region: "+regionName;
		return msgBody;
	}

	public String getFormMailBodyForTable(String userFullName,
			String regionName, String row1, String row2,
			String row3, String column1, String column2,
			String column1Answer1, String column1Answer2,
			String column1Answer3, String column2Answer1,
			String column2Answer2, String column2Answer3)
					throws Exception {
		String msgBody = "Form submitted by " + userFullName + "\n\n"
				+ row1 + ":" + column1 + ": " + column1Answer1 + "\n"
				+ row1 + ":" + column2 + ": " + column2Answer1 + "\n"
				+ row2 + ":" + column1 + ": " + column1Answer2 + "\n"
				+ row2 + ":" + column2 + ": " + column2Answer2 + "\n"
				+ row3 + ":" + column1 + ": " + column1Answer3 + "\n"
				+ row3 + ":" + column2 + ": " + column2Answer3
				+ "\n\n"
				+ "Region: " + regionName;
		return msgBody;
	}

	public String getFormPagerBodyForTable(String userFullName,
			String regionName, String row1, String row2,
			String row3, String column1, String column2,
			String column1Answer1, String column1Answer2,
			String column1Answer3, String column2Answer1,
			String column2Answer2, String column2Answer3)
					throws Exception {
		String msgBody ="Form submitted by "+userFullName+"\n"+ "| "
				+ row1 + ":" + column1 + ": " + column1Answer1 + "| "
				+ row1 + ":" + column2 + ": " + column2Answer1 + "| "
				+ row2 + ":" + column1 + ": " + column1Answer2 + "| "
				+ row2 + ":" + column2 + ": " + column2Answer2 + "| "
				+ row3 + ":" + column1 + ": " + column1Answer3 + "| "
				+ row3 + ":" + column2 + ": " + column2Answer3 + "\n"					
				+ "Region: "+ regionName;
		return msgBody;
	}

	public String getFormMailBodyWithResource(String userFullName, String regionName, String resource, String labelName1, String labelValue1, String labelName2, String labelValue2 ) throws Exception {
		String msgBody ="Form submitted by "+userFullName+" at "+resource+"\n\n"+
				labelName1+": "+labelValue1+"\n"+
				labelName2+": "+labelValue2+"\n\n"
				+"Region: "+regionName;
		return msgBody;
	}


	public String getFormPagerBodyWithResource(String userFullName, String regionName,String resource, String labelName, String labelValue, String labelName2, String labelValue2 ) throws Exception {
		String msgBody ="Form submitted by "+userFullName+" at "+resource+"\n"+
				"| "+labelName+": "+labelValue+"| "+labelName2+": "+labelValue2+"\n"+
				"Region: "+regionName;
		return msgBody;
	}

	public boolean verMailDoesNotContainGivenMsg(String messageBody) throws Exception {
		boolean blnCheck = false;
		String message = this.page.element(Locators.MESSAGEBODY, "css").getOne().getText();
		if(!(message.contains(messageBody))){
			blnCheck=true;
		}
		return blnCheck;
	}

	public String getFormMailBodyForTable(String userFullName,
			String regionName, String row1, String row2,
			String column1, String column2, String column1Answer1,
			String column1Answer2, String column2Answer1,
			String column2Answer2) throws Exception {
		String msgBody = "Form submitted by " + userFullName + "\n\n"
				+ row1 + ":" + column1 + ": " + column1Answer1 + "\n"
				+ row1 + ":" + column2 + ": " + column2Answer1 + "\n"
				+ row2 + ":" + column1 + ": " + column1Answer2 + "\n"
				+ row2 + ":" + column2 + ": " + column2Answer2
				+ "\n\n" + "Region: " + regionName;
		return msgBody;
	}

	public String getFormPagerBodyForTable(String userFullName,
			String regionName, String row1, String row2,
			String column1, String column2, String column1Answer1,
			String column1Answer2, String column2Answer1,
			String column2Answer2) throws Exception {
		String msgBody = "Form submitted by " + userFullName + "\n"
				+ "| " + row1 + ":" + column1 + ": " + column1Answer1
				+ "| " + row1 + ":" + column2 + ": " + column2Answer1
				+ "| " + row2 + ":" + column1 + ": " + column1Answer2
				+ "| " + row2 + ":" + column2 + ": " + column2Answer2
				+ "\n" + "Region: " + regionName;
		return msgBody;
	}

	public String getFormMailBodyForTableFor1Row(String userFullName,
			String regionName, String row1, String column1,
			String column1Answer1) throws Exception {
		String msgBody = "Form submitted by " + userFullName + "\n\n"
				+ row1 + ":" + column1 + ": " + column1Answer1 + "\n"
				+ "\n" + "Region: " + regionName;
		return msgBody;
	}

	public String getFormPagerBodyForTableFor1Coloumn(String userFullName,
			String regionName, String row1, String column1,
			String column1Answer1) throws Exception {

		String msgBody = "Form submitted by " + userFullName + "\n"
				+ "| " + row1 + ":" + column1 + ": " + column1Answer1
				+ "\n" + "Region: " + regionName;
		return msgBody;
	}

	public String getFormPagerBodyForThreeLabel(String userFullName, String regionName, String labelName, String labelValue,  String labelName2, String labelValue2,  String labelName3, String labelValue3) throws Exception {
		String msgBody ="Form submitted by "+userFullName+"\n"+
				"| "+labelName+": "+labelValue+"| "+labelName2+": "+labelValue2+"| "+labelName3+": "+labelValue3+"\n"+
				"Region: "+regionName;
		return msgBody;
	}

	public String getFormMailBodyForThreeLabel(String userFullName, String regionName, String labelName, String labelValue, String labelName2, String labelValue2, String labelName3, String labelValue3) throws Exception {
		String msgBody ="Form submitted by "+userFullName+"\n\n"+
				labelName+": "+labelValue+"\n"+
				labelName2+": "+labelValue2+"\n"+
				labelName3+": "+labelValue3+
				"\n\n"
				+"Region: "+regionName;
		return msgBody;
	}

	public String getFormMailBodyWithResource(String userFullName, String regionName, String resource, String labelName1, String labelValue1) throws Exception {
		String msgBody ="Form submitted by "+userFullName+" at "+resource+"\n\n"+
				labelName1+": "+labelValue1+"\n\n"
				+"Region: "+regionName;
		return msgBody;
	}

	public String getFormPagerBodyWithResource(String userFullName, String regionName,String resource, String labelName, String labelValue) throws Exception {
		String msgBody ="Form submitted by "+userFullName+" at "+resource+"\n"+
				"| "+labelName+": "+labelValue+"\n"+
				"Region: "+regionName;
		return msgBody;
	}

	public int verifyMailBodyWithValue(String messageBody) throws Exception {
		int blnCheck = 0;
		waitForElement.waitForElements(Locators.MESSAGEBODY, "css");
		String msg = this.page.element(Locators.MESSAGEBODY, "css").getOne().getText();
		if(msg.equals(messageBody)){
			blnCheck=1;
		}
		return blnCheck;
	}

	public String getFormMailBodyForChoices(String userFullName, String regionName, String labelName1, String labelValue1,String labelValue2, String labelValue3) throws Exception {
		String msgBody ="Form submitted by "+userFullName+"\n\n"+
				labelName1+": "+labelValue1+","+ labelValue2+","+labelValue3+"\n\n"+
				"Region: "+regionName;
		return msgBody;
	}

	public String getFormPagerBodyForChoices(String userFullName, String regionName, String labelName1, String labelValue1,String labelValue2, String labelValue3) throws Exception {
		String msgBody ="Form submitted by "+userFullName+"\n"+
				"| "+labelName1+": "+labelValue1+","+ labelValue2+","+labelValue3+"\n"+
				"Region: "+regionName;
		return msgBody;
	}

	public String getExpiredStatusPagerBody(String statusTypeName,
			String resourceName, String applicationTime) throws Exception {
		String msgBody = "EMResource expired status: " + resourceName
				+ ". " + statusTypeName + " status expired "
				+ applicationTime + ".";
		return msgBody;
	}

	public String getFormMailBodyFor2Choices(String userFullName, String regionName, String labelName1, String labelValue1,String labelValue2) throws Exception {
		String msgBody ="Form submitted by "+userFullName+"\n\n"+
				labelName1+": "+labelValue1+","+ labelValue2+"\n\n"+
				"Region: "+regionName;
		return msgBody;
	}

	public String getFormPagerBodyFor2Choices(String userFullName, String regionName, String labelName1, String labelValue1,String labelValue2) throws Exception {
		String msgBody ="Form submitted by "+userFullName+"\n"+
				"| "+labelName1+": "+labelValue1+","+ labelValue2+"\n"+
				"Region: "+regionName;
		return msgBody;
	}

	public String getMailBody() throws Exception {
		waitForElement.waitForElements(Locators.MESSAGEBODY, "css");
		String message = this.page.element(Locators.MESSAGEBODY, "css").getOne().getText();
		return message;
	}

	public String getEventEmailBodyForFileAttached1(String userFullName, String fullName, String regionName, String eventDescription) throws Exception {
		String msgBody = 	  "Event Notice for: " + userFullName + "\n"
				+ "Information: " + eventDescription + "\n\n" + "See attached document at "
				+ "https://emresource.qa.intermedix.com";
		return msgBody;
	}

	public String getEventEmailBodyForFileAttached2(String userFullName, String fullName, String regionName, String eventDescription) throws Exception {
		String msgBody = "From: "
				+ fullName + "\n\n" + "Regions: " + regionName
				+ "\n\nPlease do not reply to this email message. "
				+ "You must log into EMResource to take any "
				+ "action that may be required.";
		return msgBody;
	}

	public String getIPNMail(String fullName, String regionName, String applicationTime, String gender, String age, String chiefComplaint,
			String triageCategory, String levelOfCare, String EMSAgency, String EMSUnit) throws Exception {
		String msgBody = "Message from system"
				+ "\n\n"
				+ "Please do not reply to this email message. You must log into "
				+ "EMResource to take any action that may be required."
				+ "\n\n" + "Sent By: " + fullName
				+ "\nAge: " + age + "\nETA: "
				+ applicationTime + "\nChief Complaint: " + chiefComplaint
				+ "\nTriage Category: " + triageCategory + "\nGender: " + gender+"\nLevel Of Care: "+levelOfCare+"\nEMS Agency: "+EMSAgency+"\nEMS Unit: "+EMSUnit
				+ "\n\nRegion: " + regionName;
		return msgBody;
	}

	public String getIPNPager(String fullName, String regionName, String applicationTime, String gender, String age, String chiefComplaint,
			String triageCategory, String levelOfCare, String EMSAgency, String EMSUnit) throws Exception {
		String msgBody = "sent by: " + fullName
				+ " | age: " + age + " | ETA: " + applicationTime
				+ " | complaint: " + chiefComplaint + " | triage: " + triageCategory
				+ " | gender: " + gender 
				+ " | level of care: " + levelOfCare 
				+ " | ems agency: " + EMSAgency
				+ " | ems unit: " + EMSUnit
				+ " |\nregion: "
				+ regionName;
		return msgBody;
	}

	public String getEventMailWithAddress(String fullName,String fullName1, String regionName, String eventDescription, String city, 
			String countrycode,String zipCode, String country) throws Exception {
		String msgBody = 
				"THIS MESSAGE IS FROM THE QA/TEST ENVIRONMENT." 
			    +"\n\n" +
				"Event Notice for: " + fullName
				+ "\n" + "Information: " + eventDescription
				+ "\n\n" + "Location: " + city + ", "+countrycode+" "
				+ zipCode + " "
				+ country + "\n\n" + "From: "
				+ fullName1 + "\n\n" + "Regions: "
				+ regionName
				+ "\n\n"
				+ "Please do not reply to this email message. "
				+ "You must log into EMResource to take any "
				+ "action that may be required." + "\n"
				+ "https://emresource.qa.intermedix.com";
		return msgBody;
	}

	public String getEventPagerWithAddress(String fullName,String fullName1, String regionName, String eventDescription, String city, 
			String countrycode,String zipCode, String country ) throws Exception {
		String msgBody = "Information: "
				+ eventDescription + "\nLocation: "
				+ city + ", "+countrycode+" "
				+ zipCode + " "
				+ country + "\nFrom: "
				+ fullName1 + "\nRegions: "
				+ regionName;
		return msgBody;
	}

	public String getStatusChangeEmailBodyForNST(String userFullName, String updatedTime, String resourceName, String statusTypeName, String updatedValues, String regions, String resType) throws Exception {
		String msgBody ="Status Update for " + userFullName
				+ ":" + "\nOn " + updatedTime + " " + resourceName + " "
				+ "changed " + statusTypeName
				+ " status from 0 " + "to " + updatedValues
				+ ".\n\nComments:\n\nReasons:\n\nRegion: " + ""
				+ regions
				+ "\n\nOther "+resType+"s in the region report the following "+statusTypeName+" status:\n\n\nPlease do not reply to this email message."
				+ " You must log into EMResource to take any action that may"
				+ " be required.";
		return msgBody;
	}

	public String getStatusChangePagerBodyForNST(String updatedTime, String resourceName, String statusTypeName, String updatedValues, String regions) throws Exception {
		String msgBody = 	  statusTypeName
				+ " from 0 to " + updatedValues + "; "
				+ "Reasons:\nSummary at " + updatedTime + "\n"
				+ "Region: " +  regions + "";
		return msgBody;
	}


	public String getIPNEMailSubject(String resourceName) throws Exception {
		String  subjectName = "Incoming Patient Notification for "+resourceName;
		return subjectName;
	}


	public String getICSEMailSubject(String resourceName) throws Exception {
		String  subjectName = "Incident Alert for "
				+ resourceName;
		return subjectName;
	}

	public String getICSEMailBody(String resourceName, String incidentName, String incidentDesc) throws Exception {
		String msgBody = "*** THIS IS AN ACTUAL INCIDENT ***"
				+ "\n"
				+ " This message is to inform you that "
				+ resourceName
				+ " is experiencing "
				+ incidentName
				+ "."
				+ "\n"
				+ " "
				+ incidentDesc
				+ "."
				+ "\n"
				+ " * Contact your facility with any questions. Do not reply directly to this email.";
		return msgBody;
	}

	public String getStatusChangeEmailBodyForMultiStWith3Reasons(
			String userFullName, String updatedTime,
			String resourceName, String statusTypeName,
			String updatedValues, String regions, String resType,
			String reason, String reason1, String reason2)
					throws Exception {
		String msgBody ="Status Update for " + userFullName
				+ ":" + "\nOn " + updatedTime + " " + resourceName + " "
				+ "changed " + statusTypeName
				+ " status from -- " + "to " + updatedValues
				+ ".\n\nComments:\n\nReasons: "+reason+","+reason1+","+reason2+"\n\nRegion: " + ""
				+ regions
				+ "\n\nOther "+resType+"s in the region report the following "+statusTypeName+" status:\n\n\nPlease do not reply to this email message."
				+ " You must log into EMResource to take any action that may"
				+ " be required.";
		return msgBody;
	}

	public String getStatusChangePagerBodyForMultiStWith3Reasons(
			String updatedTime, String resourceName,
			String statusTypeName, String updatedValues,
			String regions, String reason, String reason1,
			String reason2) throws Exception {
		String msgBody = 	  statusTypeName
				+ " from -- to " + updatedValues + "; "
				+ "Reasons: "+reason+","+reason1+","+reason2+"\nSummary at " + updatedTime + "\n"
				+ "Region: " + regions + "";
		return msgBody;
	}

	public String getICSEMailBodyForDrillInc(String resourceName, String incidentName, String incidentDescription) throws Exception {
		String msgBody = "*** THIS IS A DRILL ***"
				+ "\n"
				+ " The following message is a Exercise/Drill at "
				+ resourceName
				+ " is "
				+ "experiencing "
				+ incidentName
				+ "."
				+ "\n"
				+ " "
				+ incidentDescription
				+ "."
				+ "\n"
				+ " * Contact your facility with any questions. Do not reply directly to this email.";
		return msgBody;
	}

	public String getEmailBodyForMRE(String userFullName, String fullName, String regionName1,String regionName2,  String eventDescription) throws Exception {
		String msgBody = "Event Notice for: " + fullName
				+ "\n" + "Information: " + eventDescription
				+ "\n\n" + "From: " + fullName + "\n\n"
				+ "Regions: " + regionName1
				+ ", " + regionName2
				+ "\n\nPlease do not reply to this email message. "
				+ "You must log into EMResource to take any "
				+ "action that may be required." + "\n" +  "https://emresource.qa.intermedix.com";
		return msgBody;
	}

	public String getPagerBodyForMRE( String fullName, String regionName1,String regionName2,  String eventDescription) throws Exception {
		String msgBody =  "Information: "
				+ eventDescription + "\nFrom: "
				+ fullName + "\nRegions: "
				+ regionName1
				+ ", " + regionName2;
		return msgBody;
	}


	public String getPagerBodyForMREAddingRegion( String fullName, String regionName1,String regionName2,  String eventDescription) throws Exception {
		String strMsgBody =  "Region: "+regionName1+" now participating"+
				"\nInformation: "
				+ eventDescription + "\nFrom: "
				+ fullName + "\nRegions: "
				+ regionName1
				+ ", " + regionName2;
		return strMsgBody;
	}

	public String getEmailBodyForMREAddingRegion(String userFullName, String fullName, String regionName1,String regionName2,  String eventDescription) throws Exception {
		String strMsgBody = "Event Notice for: " + fullName
				+"\n\nRegion: "+regionName1+" now participating"
				+ "\n\n" + "Information: " + eventDescription
				+ "\n\n" + "From: " + fullName + "\n\n"
				+ "Regions: " + regionName1
				+ ", " + regionName2
				+ "\n\nPlease do not reply to this email message. "
				+ "You must log into EMResource to take any "
				+ "action that may be required." + "\n" +  "https://emresource.qa.intermedix.com";
		return strMsgBody;
	}

	public String getStatusChangeEmailBodyWithAsstdRescrsForNST(String userFullName, String updatedTime, String resourceName, String statusTypeName, String updatedValues, String regions, String resType,String resourceName1) throws Exception {
		String strMsgBody ="Status Update for " + userFullName
				+ ":" + "\nOn " + updatedTime + " " +resourceName + " "
				+ "changed " + statusTypeName
				+ " status from 0 " + "to " + updatedValues
				+ ".\n\nComments:\n\nReasons:\n\nRegion: " + ""
				+ regions
				+ "\n\nOther "+ resType +"s in the region report the following "+ statusTypeName +" status:\n"+ resourceName1 +" = 0"+"\n\n\nPlease do not reply to this email message."
				+ " You must log into EMResource to take any action that may"
				+ " be required.";
		return strMsgBody;
	}

	public String getStatusChangeEmailBodyWithAssctdRescrsForMST(String userFullName, String updatedTime, String resourceName, String statusTypeName, String updatedValues, String regions, String resType,String resourceName1) throws Exception {
		String strMsgBody ="Status Update for " + userFullName
				+ ":" + "\nOn " + updatedTime + " " +resourceName + " "
				+ "changed " + statusTypeName
				+ " status from -- " + "to " + updatedValues
				+ ".\n\nComments:\n\nReasons:\n\nRegion: " + ""
				+ regions
				+ "\n\nOther "+ resType +"s in the region report the following "+statusTypeName+" status:\n"+ resourceName1 +" = --"+"\n\n\nPlease do not reply to this email message."
				+ " You must log into EMResource to take any action that may"
				+ " be required.";
		return strMsgBody;
	}

	public String getStatusChangePagerBodyForWithAsstdRescrsForNST(String updatedTime, String resourceName, String statusTypeName, String updatedValues, String regions,String otherResAbb) throws Exception {
		String msgBody = 	  statusTypeName
				+ " from 0 to " + updatedValues + "; "
				+ "Reasons:\nSummary at " + updatedTime +" "+ otherResAbb+"[0]"+"\n"
				+ "Region: " +  regions + "";
		return msgBody;
	}

	public String getStatusChangePagerBodyForWithAsstdRescrsForMST(String updatedTime, String resourceName, String statusTypeName, String updatedValues, String regions,String otherResAbb) throws Exception {
		String msgBody = 	  statusTypeName
				+ " from -- to " + updatedValues + "; "
				+ "Reasons:\nSummary at " + updatedTime +" --: "+otherResAbb+"\n"
				+ "Region: " +  regions + "";
		return msgBody;
	}


	public String getForgotUserEmailSubject() throws Exception {
		String subject = "forgot username email";
		return subject;
	}	

	public String getStatusChangeSubRSEmailBodyForNST(String userFullName, String updatedTime, String resourceName, String statusTypeName, String updatedValues, String regions) throws Exception {
		String msgBody ="Status Update for " + userFullName
				+ ":" + "\nOn " + updatedTime + " " + resourceName + " "
				+ "changed " + statusTypeName
				+ " status from 0 " + "to " + updatedValues
				+ ".\n\nComments:\n\nReasons:\n\nRegion: " + ""
				+ regions
				+ "\n\n\n\nPlease do not reply to this email message."
				+ " You must log into EMResource to take any action that may"
				+ " be required.";
		return msgBody;
	}

	public String getStatusChangeSubRSEmailBody(String userFullName, String updatedTime, String resourceName, String statusTypeName, String updatedValues, String regions) throws Exception {
		String strMsgBody ="Status Update for " + userFullName
				+ ":" + "\nOn " + updatedTime + " " + resourceName + " "
				+ "changed " + statusTypeName
				+ " status from -- " + "to " + updatedValues
				+ ".\n\nComments:\n\nReasons:\n\nRegion: " + ""
				+ regions
				+ "\n\n\n\nPlease do not reply to this email message."
				+ " You must log into EMResource to take any action that may"
				+ " be required.";
		return strMsgBody;
	}

	public String getStatusChangeSubRSEmailBody(String userFullName, String updatedTime, String resourceName, String statusTypeName, String previousValues, String updatedValues, String regions) throws Exception {
		String msgBody ="Status Update for " + userFullName
				+ ":" + "\nOn " + updatedTime + " " + resourceName + " "
				+ "changed " + statusTypeName
				+ " status from "+previousValues+" " + "to " + updatedValues
				+ ".\n\nComments:\n\nReasons:\n\nRegion: " + ""
				+ regions
				+ "\n\n\n\nPlease do not reply to this email message."
				+ " You must log into EMResource to take any action that may"
				+ " be required.";
		return msgBody;
	  }
		
	public void clickOnProfile() throws Exception {
		waitForElement.waitForElements(Locators.PROFILE, "xpath");
		assertTrue(this.page.element(Locators.PROFILE, "xpath").getOne().isDisplayed());
		this.page.element(Locators.PROFILE, "xpath").getOne().sendKeys(Keys.ENTER);
	}

	public void clickOnSignOut() throws Exception {
		driver.get(Locators.SIGNOUT);
	}

	public Mails verifyMailAndPagerNotificationsForAnEventCreated(String userFullName,
			String fullName, String regionName, String eventDescription, String subject) throws Exception {
		boolean blnMsg1 = false;
		boolean blnMsg2 = false;

		String emailBody = this.getEventEmailBody(userFullName, userFullName,
				regionName, eventDescription);
		String pagerBody = this.getEventPagerBody(userFullName, regionName,
				eventDescription);

		for (int intCount = 0; intCount < 2; intCount++) {

			this.verifyEmail(subject);

			if (blnMsg1 == false) {
				blnMsg1 = this.verifyMailBodyWithoutJunkCharacters(emailBody);
			}
			if (blnMsg2 == false) {
				blnMsg2 = this.verifyMailBody(pagerBody);
			}
			this.backToMailInbox();
		}
		assertTrue(blnMsg1 && blnMsg2);
		return this;
	}


	public String getIPNMailWhenPatientAddedInEmtrack(String sentBy, String region, String arrivalTime, String gender, String age, String chiefComplaint,
			String triageCategory, String levelOfCare, String eMSAgency, String eMSUnit) throws Exception {
		String mailBody;
		if(age.equals("1")) {
			mailBody = "Message from system"
					+ "\n\n"
					+ "Please do not reply to this email message. You must log into "
					+ "EMResource to take any action that may be required."
					+ "\n\n" + "Sent By: " + sentBy
					+ "\nAge: " +age+" "+"Year" + "\nETA: "
					+ arrivalTime + "\nChief Complaint: " + chiefComplaint
					+ "\nTriage Category: " + triageCategory + "\nGender: " + gender+"\nLevel Of Care: "+levelOfCare+"\nEMS Agency: "+eMSAgency+"\nEMS Unit: "+eMSUnit
					+ "\n\nRegion: " + region;
		} else {
			mailBody = "Message from system"
					+ "\n\n"
					+ "Please do not reply to this email message. You must log into "
					+ "EMResource to take any action that may be required."
					+ "\n\n" + "Sent By: " + sentBy
					+ "\nAge: " +age+" "+"Years" + "\nETA: "
					+ arrivalTime + "\nChief Complaint: " + chiefComplaint
					+ "\nTriage Category: " + triageCategory + "\nGender: " + gender+"\nLevel Of Care: "+levelOfCare+"\nEMS Agency: "+eMSAgency+"\nEMS Unit: "+eMSUnit
					+ "\n\nRegion: " + region;
		}
		System.out.println(mailBody);
		return mailBody ;
	}


	public String getIPNPagerWhenPatientAddedInEmtrack(String sentBy, String region, String arrivalTime, String gender, String age, String chiefComplaint,
			String triageCategory, String levelOfCare, String eMSAgency, String eMSUnit) throws Exception {
		String pagerBody = "";
		if(age.equals("1")) {
			pagerBody = "sent by: " + sentBy
					+ " | age: " +age+" "+"Year" + " | ETA: " + arrivalTime
					+ " | complaint: " + chiefComplaint + " | triage: " + triageCategory
					+ " | gender: " + gender 
					+ " | level of care: " + levelOfCare 
					+ " | ems agency: " + eMSAgency
					+ " | ems unit: " + eMSUnit
					+ " |\nregion: "
					+ region;
		} else {
			pagerBody = "sent by: " + sentBy
					+ " | age: " +age+" "+"Years" + " | ETA: " + arrivalTime
					+ " | complaint: " + chiefComplaint + " | triage: " + triageCategory
					+ " | gender: " + gender 
					+ " | level of care: " + levelOfCare 
					+ " | ems agency: " + eMSAgency
					+ " | ems unit: " + eMSUnit
					+ " |\nregion: "
					+ region;
		}
		return pagerBody;
	}

	public Mails verifyMailAndPagerNotificationsForPatientAddedInEMTrack(String sentBy, String region, String applicationTime, String gender, String age, String chiefComplaint,
			String triageCategory, String levelOfCare, String eMSAgency, String eMSUnit,String emailID, String resource) throws Exception {
		boolean blnMsg1 = false;
		boolean blnMsg2 = false;

		String mailSubject=	MailsData.IPN_MAIL_SUBJECT+" "+resource;

		String ipnMailBody = this.getIPNMailWhenPatientAddedInEmtrack( sentBy,  region,  applicationTime,  gender,  age,  chiefComplaint,
				triageCategory,  levelOfCare,  eMSAgency,  eMSUnit);
		System.out.println("ipnMailBody" + ipnMailBody);

		String ipnPagerBody = this.getIPNPagerWhenPatientAddedInEmtrack( sentBy,  region,  applicationTime,  gender,  age,  chiefComplaint,
				triageCategory,  levelOfCare,  eMSAgency,  eMSUnit);

		System.out.println("ipnPagerBody" + ipnPagerBody);

		for (int intCount = 0; intCount < 2; intCount++) {

			this.verifyEmail(mailSubject);

			if (blnMsg1 == false) {
				blnMsg1 = this.verifyMailBodyWithoutJunkCharacters(ipnMailBody);
				System.out.println("blnMsg1" + blnMsg1);
			}
			if (blnMsg2 == false) {
				blnMsg2 = this.verifyMailBody(ipnPagerBody);
				System.out.println("blnMsg2" + blnMsg2);
			}
			this.backToMailInbox();
		}
		assertTrue(blnMsg1 && blnMsg2);
		return this;
	}

	public Mails verifyMailAndPagerNotificationsForFormWithThreeQuestionnaire(String userFullName, String regionName, String formName,
			String labelName, String labelAnswer, String labelName1, String labelAnswer1, String labelName2, String labelAnswer2, String emailID) throws Exception {

		String mailBody = this.getFormMailBodyForThreeLabel(userFullName, regionName, labelName, labelAnswer, labelName1, labelAnswer1, labelName2, labelAnswer2);

		String pagerBody = this.getFormPagerBodyForThreeLabel(userFullName, regionName, labelName, labelAnswer, labelName1, labelAnswer1, labelName2, labelAnswer2);

		boolean mailBodySame1 = false, mailBodySame2 = false;;
		boolean pagerBodySame = false;

		for (int intCount = 0; intCount < 3; intCount++) {

			this.verifyEmail(formName);

			if (mailBodySame1 == false) {
				mailBodySame1 = this.verifyMailBody(mailBody);
				System.out.println("blnMsg1"+ mailBody);
			}

			if (mailBodySame2 == false) {
				mailBodySame2 = this.verifyMailBody(mailBody);
				System.out.println("blnMsg2"+ mailBody);
			}
			
			if (pagerBodySame == false) {
				pagerBodySame = this.verifyMailBody(pagerBody);
				System.out.println("blnMsg3"+ pagerBody);
			}

			this.backToMailInbox();
		}
		System.out.println("mailBody1 boolean: "+ mailBodySame1);
		System.out.println("mailBody2 boolean: "+ mailBodySame2);
		System.out.println("pagerBody boolean: "+pagerBodySame);
		assertTrue(mailBodySame1 && mailBodySame2 && pagerBodySame);
		return this;
	}
	
	public Mails verifyMailAndPagerNotificationsForAnEventEnded(String userFullName,
			String eventName, String regionName, String applicationDateAndTime,
			String emailID) throws Exception {
		boolean blnMsg1 = false;
		boolean blnMsg2 = false;

		String emailBody = this.getEventEndedEmailBody(userFullName, eventName, regionName, applicationDateAndTime);
		String pagerBody = this.getEventEndedPagerBody(userFullName, regionName, eventName, applicationDateAndTime);
		String subject = "Ended: " + eventName;
		
		for (int intCount = 0; intCount < 2; intCount++) {

			this.verifyEmail(subject);

			if (blnMsg1 == false) {
				blnMsg1 = this.verifyMailBodyWithoutJunkCharacters(emailBody);
			}
			if (blnMsg2 == false) {
				blnMsg2 = this.verifyMailBody(pagerBody);
			}
			this.backToMailInbox();
		}
		assertTrue(blnMsg1 && blnMsg2);
		return this;
	}
	
	public String getEventEndedEmailBody(String userFullName, String eventName, String regionName, String applicationDateAndTime) throws Exception {
		String[] dateAndTimeInApplication = applicationDateAndTime.split(" ");
		String time = dateAndTimeInApplication[1];
		applicationDateAndTime = dateAndTime.converDateFormat(applicationDateAndTime, "M/d/yyyy", "MM/dd/yyyy");
		applicationDateAndTime = applicationDateAndTime + " " + time; 
		String messageBody = 	  "Event Notice for: " + userFullName + "\n"
				+ eventName + " ended at " + applicationDateAndTime+"\n\n" 
				+ "From: "	+ userFullName + "\n" + "Regions: " + regionName
				+ "\n\nPlease do not reply to this email message. "
				+ "You must log into EMResource to take any "
				+ "action that may be required." + "\n"
				+ "https://emresource.qa.intermedix.com";
		return messageBody;
	}

	public String getEventEndedPagerBody(String userFullName, String regionName, String eventName, String applicationDateAndTime) throws Exception {
		String[] dateAndTimeInApplication = applicationDateAndTime.split(" ");
		String time = dateAndTimeInApplication[1];
		applicationDateAndTime = dateAndTime.converDateFormat(applicationDateAndTime, "M/d/yyyy", "MM/dd/yyyy");
		applicationDateAndTime = applicationDateAndTime + " " + time; 
		String messageBody = eventName + " ended at " + applicationDateAndTime + "\nFrom: "
				+ userFullName + "\nRegions: " + regionName;
		return messageBody;
	}
	
	
	public String getMailOrPagerBodyFromInbox() throws Exception {
		waitForElement.waitForElements(Locators.MESSAGEBODY, "css");
		String mailOrPagerBody = this.page.element(Locators.MESSAGEBODY, "css").getOne().getText();
		System.out.println("CAPTURED: " + mailOrPagerBody);
		return mailOrPagerBody;	
	}
	
	public String getStatusChangeEmailBody(String userFullName, String updatedTime, String resourceName, String statusTypeName, String previousValues, String updatedValues, String regions, String resourceType) throws Exception {
		String msgBody ="Status Update for " + userFullName
				+ ":" + "\nOn " + updatedTime + " " + resourceName + " "
				+ "changed " + statusTypeName
				+ " status from "+previousValues+" " + "to " + updatedValues
				+ ".\n\nComments:\n\nReasons:\n\nRegion: " + ""
				+ regions+"\n\nOther "+resourceType+"s in the region report the following "+statusTypeName+" status:"
				+ "\n\n\n\nPlease do not reply to this email message."
				+ " You must log into EMResource to take any action that may"
				+ " be required.";
		return msgBody;
		
	}
	
	public String getStatusChangePager(String updatedTime, String resourceName, String statusTypeName, String previousValues, String updatedValues, String regions) throws Exception {
		String msgBody = 	  statusTypeName
				+ " from "+previousValues+" to " + updatedValues + "; "
				+ "Reasons:\nSummary at " + updatedTime + "\n"
				+ "Region: " +  regions + "";
		return msgBody;
	}
	
	public boolean verifyStatusChangeMailContainsBody(String formedMail) throws Exception {
		boolean blnCheck = false;
		String mail=getMailOrPagerBodyFromInbox();
		String[] formedMailes=formedMail.split("\n\n\n\n");
		String[] splitedMail=mail.split("\n\n\n");
		if (splitedMail[0].contains(formedMailes[0])&&splitedMail[1].contains(formedMailes[1])) {
			blnCheck = true;
		  }
		return blnCheck;
	}
	
	public boolean verifyStatusChangePagerContainsBody(String formedPager) throws Exception {
		boolean blnCheck = false;
		String pager=getMailOrPagerBodyFromInbox();
		String[] formedPagers=formedPager.split("\nRegion: ");
		String[] pagerCapturedFromWeb=pager.split("\nRegion: ");
		if (pagerCapturedFromWeb[0].contains(formedPagers[0])&&pagerCapturedFromWeb[1].contains(formedPagers[1])) {
			blnCheck = true;
		      }
		return blnCheck;
	}
			
	public Mails verifyMailAndPagerNotificationsForStatusChangeNotifications(String resourceAbbrevation, String userFullName, String updatedTime, String resourceName, String statusTypeName[], String previousValues[], String updatedValues[], String region, String resourceType) throws Exception {
	
		String mailSubject=	MailsData.STATUS_CHANGE_MAIL_SUBJECT+" "+resourceName;
		String pagerSubject=MailsData.STATUS_CHANGE_PAGER_SUBJECT+" "+resourceAbbrevation;
		
	String saturationStatusTypeUpdatedMailBody = this.getStatusChangeEmailBody(userFullName, updatedTime, resourceName, statusTypeName[0], previousValues[0], updatedValues[0], region, resourceType);
	String nedocsStatusTypeUpdatedMailBody = this.getStatusChangeEmailBody(userFullName, updatedTime, resourceName, statusTypeName[1], previousValues[1], updatedValues[1], region, resourceType);
	String multiStatusTypeUpdatedMailBody = this.getStatusChangeEmailBody(userFullName, updatedTime, resourceName, statusTypeName[2], previousValues[2], updatedValues[2], region, resourceType);
	String textStatusTypeUpdatedMailBody = this.getStatusChangeEmailBody(userFullName, updatedTime, resourceName, statusTypeName[3], previousValues[3], updatedValues[3], region, resourceType);						
	String dateStatusTypeUpdatedMailBody = this.getStatusChangeEmailBody(userFullName, updatedTime, resourceName, statusTypeName[4], previousValues[4], updatedValues[4], region, resourceType);
    String numberStatusTypeUpdatedMailBody = this.getStatusChangeEmailBody(userFullName, updatedTime, resourceName, statusTypeName[5], previousValues[5], updatedValues[5], region, resourceType);
		
	String saturationStatusTypeUpdatedPagerBody=this.getStatusChangePager(updatedTime, resourceName, statusTypeName[0], previousValues[0], updatedValues[0], region);	
	String nedocsStatusTypeUpdatedPagerBody=	this.getStatusChangePager(updatedTime, resourceName, statusTypeName[1], previousValues[1], updatedValues[1], region);
	String multiStatusTypeUpdatedPagerBody=	this.getStatusChangePager(updatedTime, resourceName, statusTypeName[2], previousValues[2], updatedValues[2], region);	
	String textStatusTypeUpdatedPagerBody=	this.getStatusChangePager(updatedTime, resourceName, statusTypeName[3], previousValues[3], updatedValues[3], region);	
	String dateStatusTypeUpdatedPagerBody=	this.getStatusChangePager(updatedTime, resourceName, statusTypeName[4], previousValues[4], updatedValues[4], region);	
	String numberStatusTypeUpdatedPagerBody=	this.getStatusChangePager(updatedTime, resourceName, statusTypeName[5], previousValues[5], updatedValues[5], region);	
		
	boolean mailPresent1 = false;
	boolean mailPresent2 = false;
	boolean mailPresent3 = false;
	boolean mailPresent4 = false;
	boolean mailPresent5 = false;
	boolean mailPresent6 = false;
	
	boolean mailPresent7 = false;
	boolean mailPresent8 = false;
	boolean mailPresent9 = false;
	boolean mailPresent10 = false;
	boolean mailPresent11 = false;
	boolean mailPresent12 = false;
	
	boolean pagerPresent1 = false;
	boolean pagerPresent2 = false;
	boolean pagerPresent3 = false;
	boolean pagerPresent4 = false;
	boolean pagerPresent5 = false;
	boolean pagerPresent6 = false;

	for (int intCount = 0; intCount < 12; intCount++) {

		this.verifyEmail(mailSubject);

		if (mailPresent1 == false) {
			mailPresent1 = this.verifyStatusChangeMailContainsBody(numberStatusTypeUpdatedMailBody);
			System.out.println("mailPresent1"+ mailPresent1);
		}

		if (mailPresent2 == false) {
			mailPresent2 = this.verifyStatusChangeMailContainsBody(nedocsStatusTypeUpdatedMailBody);
			System.out.println("mailPresent2"+ mailPresent2);
		}
		
		if (mailPresent3 == false) {
			mailPresent3 = this.verifyStatusChangeMailContainsBody(saturationStatusTypeUpdatedMailBody);
			System.out.println("mailPresent3"+ mailPresent3);
		}
		
		if (mailPresent4 == false) {
			mailPresent4 = this.verifyStatusChangeMailContainsBody(multiStatusTypeUpdatedMailBody);
			System.out.println("mailPresent4"+ mailPresent4);
		}
		
		if (mailPresent5 == false) {
			mailPresent5 = this.verifyStatusChangeMailContainsBody(textStatusTypeUpdatedMailBody);
			System.out.println("mailPresent5"+ mailPresent5);
		}
		
		if (mailPresent6 == false) {
			mailPresent6 = this.verifyStatusChangeMailContainsBody(dateStatusTypeUpdatedMailBody);
			System.out.println("mailPresent6"+ mailPresent6);
		}

		if (mailPresent7 == false) {
			mailPresent7 = this.verifyStatusChangeMailContainsBody(numberStatusTypeUpdatedMailBody);
			System.out.println("mailPresent7"+ mailPresent7);
		}

		if (mailPresent8 == false) {
			mailPresent8 = this.verifyStatusChangeMailContainsBody(nedocsStatusTypeUpdatedMailBody);
			System.out.println("mailPresent8"+ mailPresent8);
		}
		
		if (mailPresent9 == false) {
			mailPresent9 = this.verifyStatusChangeMailContainsBody(saturationStatusTypeUpdatedMailBody);
			System.out.println("mailPresent9"+ mailPresent9);
		}
		
		if (mailPresent10 == false) {
			mailPresent10 = this.verifyStatusChangeMailContainsBody(multiStatusTypeUpdatedMailBody);
			System.out.println("mailPresent10"+ mailPresent10);
		}
		
		if (mailPresent11 == false) {
			mailPresent11 = this.verifyStatusChangeMailContainsBody(textStatusTypeUpdatedMailBody);
			System.out.println("mailPresent11"+ mailPresent11);
		}
		
		if (mailPresent12 == false) {
			mailPresent12 = this.verifyStatusChangeMailContainsBody(dateStatusTypeUpdatedMailBody);
			System.out.println("mailPresent12"+ mailPresent12);
		}
		this.backToMailInbox();
	}
	
	assertTrue(mailPresent1&&mailPresent2&&mailPresent3&&mailPresent4&&mailPresent5&&mailPresent6);
		
	for (int intCount = 0; intCount < 6; intCount++) {

		this.verifyEmail(pagerSubject);

		if (pagerPresent1 == false) {
			pagerPresent1 = this.verifyStatusChangePagerContainsBody(numberStatusTypeUpdatedPagerBody);
			System.out.println("pagerPresent1"+ pagerPresent1);
		}

		if (pagerPresent2 == false) {
			pagerPresent2 = this.verifyStatusChangePagerContainsBody(nedocsStatusTypeUpdatedPagerBody);
			System.out.println("pagerPresent2"+ pagerPresent2);
		}
		
		if (pagerPresent3 == false) {
			pagerPresent3 = this.verifyStatusChangePagerContainsBody(multiStatusTypeUpdatedPagerBody);
			System.out.println("pagerPresent3"+ pagerPresent3);
		}
		
		if (pagerPresent4 == false) {
			pagerPresent4 = this.verifyStatusChangePagerContainsBody(saturationStatusTypeUpdatedPagerBody);
			System.out.println("pagerPresent4"+ pagerPresent4);
		}
		
		if (pagerPresent5 == false) {
			pagerPresent5 = this.verifyStatusChangePagerContainsBody(textStatusTypeUpdatedPagerBody);
			System.out.println("pagerPresent5"+ pagerPresent5);
		}
		
		if (pagerPresent6 == false) {
			pagerPresent6 = this.verifyStatusChangePagerContainsBody(dateStatusTypeUpdatedPagerBody);
			System.out.println("pagerPresent6"+ pagerPresent6);
		}

		this.backToMailInbox();
	}
	
	assertTrue(pagerPresent1&&pagerPresent2&&pagerPresent3&&pagerPresent4&&pagerPresent5&&pagerPresent6);
	
	return this;
}
	
	public String getEventTemplateNoLongerParticipatingInRegionEmailBody(String userFullName, String regionName1, String regionName2, String eventInformation, String endedDate) throws Exception {
		String msgBody = "Event Notice for: " + userFullName + "\n\n"
				+ "Region: " + regionName1 + " no longer participating as of " 
				+ endedDate + " CST"
				+ "\n\n" + "Information: " + eventInformation + "\n\n" + "From: "
				+ userFullName + "\n\n" + "Regions: " + regionName2 + ", "  + regionName1
				+ "\n\nPlease do not reply to this email message. "
				+ "You must log into EMResource to take any "
				+ "action that may be required." + "\n"
				+ "https://emresource.qa.intermedix.com";
		return msgBody;
	}

	public String getEventTemplateNoLongerParticipatingInRegionPagerBody(String userFullName, String regionName1, String regionName2, String eventInformation, String endedDate) throws Exception {
		String msgBody =  "Region: " + regionName1 + " no longer participating as of " 
				+ endedDate + " CST" + "\n"
				+ "Information: " + eventInformation + "\nFrom: "
				+ userFullName + "\nRegions: " + regionName2 + ", "  + regionName1;
		return msgBody;
	}
	
	public Mails verifyMailAndPagerNotificationsForAnEventNoLongerParticipatingInRegion(String userFullName, 
			String regionName1, String regionName2, String eventInformation, String endedDate, String subject) throws Exception {
		boolean blnMsg1 = false;
		boolean blnMsg2 = false;

		String emailBody = this.getEventTemplateNoLongerParticipatingInRegionEmailBody(userFullName, regionName1, regionName2, eventInformation, endedDate);
		String pagerBody = this.getEventTemplateNoLongerParticipatingInRegionPagerBody(userFullName, regionName1, regionName2, eventInformation, endedDate);

		for (int intCount = 0; intCount < 2; intCount++) {

			this.verifyEmail(subject);

			if (blnMsg1 == false) {
				blnMsg1 = this.verifyMailBodyWithoutJunkCharacters(emailBody);
			}
			if (blnMsg2 == false) {
				blnMsg2 = this.verifyMailBody(pagerBody);
			}
			this.backToMailInbox();
		}
		assertTrue(blnMsg1 && blnMsg2);
		return this;
	}
	
	public String getEventWithAddressPagerBody(String eventDescription,String city,String state,String zipCode, String county, String userFullName, String regionName2,String regionName1) throws Exception {
		String msgBody = 
	            "Information: " + eventDescription + "\n"+
	    		"Location: " + city + "," + " " + state + " " + zipCode + " " + county + "\n"+
	            "From: " + userFullName + "\n"+
	            "Regions: " + regionName2 + "," + " " +regionName1 ;
		return msgBody;
	}
	
	public String getEventWithAddressEmailBody(String userFullName,String eventDescription,String city,String state,String zipCode, String county, String regionName2,String regionName1) throws Exception {
		String msgBody = 
//				"THIS MESSAGE IS FROM THE QA/TEST ENVIRONMENT." +"\n"+
	            "Event Notice for: " + userFullName + "\n" 
				+ "Information: " + eventDescription + "\n\n"
				+ "Location: " + city + "," + " " + state + " " + zipCode + " " + county + "\n\n" 
				+ "From: " + userFullName + "\n\n" 
				+ "Regions: " + regionName2 + "," + " "+ regionName1 + "\n\n"
				+ "Please do not reply to this email message. "
				+ "You must log into EMResource to take any "
				+ "action that may be required." + "\n"
				+ "https://emresource.qa.intermedix.com";
//				+ "\n\nFor information on how to unsubscribe from or change your EMResource event notifications, "
//				+ "click on the following link " ;
		return msgBody;
	}
	
	public Mails verifyMailAndPagerNotificationsForEventWithAddress(String eventDescription, 
			String city, String state, String zipCode, String county, String userFullName,String regionName2,String regionName1 ,String subject) throws Exception {
		boolean blnMsg1 = false;
		boolean blnMsg2 = false;

		String pagerBody = this.getEventWithAddressPagerBody(eventDescription, city, state, zipCode, county, userFullName, regionName2,regionName1);
		String emailBody = this.getEventWithAddressEmailBody(userFullName,eventDescription, city, state, zipCode, county, regionName2,regionName1);

		for (int intCount = 0; intCount < 2; intCount++) {

			this.verifyEmail(subject);

			if (blnMsg1 == false) {
				blnMsg1 = this.verifyMailBodyWithoutJunkCharacters(emailBody);
			}
			if (blnMsg2 == false) {
				blnMsg2 = this.verifyMailBody(pagerBody);
			}
			this.backToMailInbox();
		}
		assertTrue(blnMsg1 && blnMsg2);
		return this;
	}
	
	public String getMultiRegionEventEndedEmailBody(String userFullName, String eventName, String regionName1, String regionName2,String regionName3,String applicationDateAndTime) throws Exception {
		String[] dateAndTimeInApplication = applicationDateAndTime.split(" ");
		String time = dateAndTimeInApplication[1];
		applicationDateAndTime = dateAndTime.converDateFormat(applicationDateAndTime, "M/d/yyyy", "MM/dd/yyyy");
		applicationDateAndTime = applicationDateAndTime + " " + time; 
		String messageBody = 
//				"THIS MESSAGE IS FROM THE QA/TEST ENVIRONMENT." + "\n\n" +  
				"Event Notice for: " + userFullName + "\n"
				+ eventName + " ended at " + applicationDateAndTime+"\n\n" 
				+ "From: "	+ userFullName + "\nRegions: " + regionName1 + ", "  + regionName2 + ", "  + regionName3
				+ "\n\nPlease do not reply to this email message. "
				+ "You must log into EMResource to take any "
				+ "action that may be required." + "\n"
				+ "https://emresource.qa.intermedix.com" ;
//				+ "\n\n" 
//				+ "For information on how to unsubscribe from or change your EMResource event notifications, click on the following link "
//				+ "\n" + "https://emresource.qa.intermedix.com/resources/help/EMResourceNotificationPreferences.html";
		return messageBody;
	}

	public String getMultiRegionEventEndedPagerBody(String userFullName, String regionName1, String regionName2,String regionName3, String eventName, String applicationDateAndTime) throws Exception {
		String[] dateAndTimeInApplication = applicationDateAndTime.split(" ");
		String time = dateAndTimeInApplication[1];
		applicationDateAndTime = dateAndTime.converDateFormat(applicationDateAndTime, "M/d/yyyy", "MM/dd/yyyy");
		applicationDateAndTime = applicationDateAndTime + " " + time; 
		String messageBody = 
//				"THIS MESSAGE IS FROM THE QA/TEST ENVIRONMENT." + "\n\n" +
				eventName + " ended at " + applicationDateAndTime + "\nFrom: "
				+ userFullName + "\nRegions: " + regionName1 + ", "  + regionName2 + ", "  + regionName3;
		return messageBody;
	}
	
	public Mails verifyMailAndPagerNotificationsForMultiRegionEventEnded(String userFullName,
			String eventName, String regionName1, String regionName2, String regionName3, String applicationDateAndTime) throws Exception {
		boolean blnMsg1 = false;
		boolean blnMsg2 = false;

		String emailBody = this.getMultiRegionEventEndedEmailBody(userFullName, eventName, regionName1, regionName2, regionName3, applicationDateAndTime);
		String pagerBody = this.getMultiRegionEventEndedPagerBody(userFullName, regionName1, regionName2, regionName3, eventName, applicationDateAndTime);
		String subject = "Ended: " + eventName;
		
		for (int intCount = 0; intCount < 2; intCount++) {

			this.verifyEmail(subject);

			if (blnMsg1 == false) {
				blnMsg1 = this.verifyMailBodyWithoutJunkCharacters(emailBody);
			}
			if (blnMsg2 == false) {
				blnMsg2 = this.verifyMailBody(pagerBody);
			}
			this.backToMailInbox();
		}
		assertTrue(blnMsg1 && blnMsg2);
		return this;
	}
	
	public String getStatusChangeEmailBodyWithReasons(String userFullName, String updatedTime, String resourceName, String statusTypeName, String previousValues, String updatedValues,String reason, String regions, String resourceType) throws Exception {
		String msgBody ="Status Update for " + userFullName
				+ ":" + "\nOn " + updatedTime + " " + resourceName + " "
				+ "changed " + statusTypeName
				+ " status from "+previousValues+" " + "to " + updatedValues
				+ ".\n\nComments:\n\nReasons: "+reason+"\n\nRegion: " + ""
				+ regions+"\n\nOther "+resourceType+"s in the region report the following "+statusTypeName+" status:"
				+ "\n\n\nPlease do not reply to this email message."
				+ " You must log into EMResource to take any action that may"
				+ " be required.";
		return msgBody;
		
	}
	
	public String getStatusChangePagerWithReasons(String updatedTime, String resourceName, String statusTypeName, String previousValues, String updatedValues,String reason, String regions) throws Exception {
		String msgBody =statusTypeName
				+ " from "+previousValues+" to " + updatedValues + "; "
				+ "Reasons: "+reason+"\nSummary at " + updatedTime + "\n"
				+ "Region: " +  regions + "";
		return msgBody;
	}
	
	public Mails verifyMailAndPagerNotificationsForStatusChangeNotificationsWithReasons(String resourceAbbrevation, String userFullName, String updatedTime, String resourceName, String statusTypeName[], String previousValues[], String updatedValues[],String reasons[], String region, String resourceType) throws Exception {
		
	String mailSubject=	MailsData.STATUS_CHANGE_MAIL_SUBJECT+" "+resourceName;
	String pagerSubject=MailsData.STATUS_CHANGE_PAGER_SUBJECT+" "+resourceAbbrevation;
		
	String mail1 = this.getStatusChangeEmailBodyWithReasons(userFullName, updatedTime, resourceName, statusTypeName[0], previousValues[0], updatedValues[0], reasons[0],region, resourceType);
	String mail2 = this.getStatusChangeEmailBodyWithReasons(userFullName, updatedTime, resourceName, statusTypeName[1], previousValues[1], updatedValues[1],reasons[1], region, resourceType);
	String mail3 = this.getStatusChangeEmailBodyWithReasons(userFullName, updatedTime, resourceName, statusTypeName[2], previousValues[2], updatedValues[2],reasons[2], region, resourceType);
	String mail4 = this.getStatusChangeEmailBodyWithReasons(userFullName, updatedTime, resourceName, statusTypeName[3], previousValues[3], updatedValues[3],reasons[3], region, resourceType);						
	
	String pager1= this.getStatusChangePagerWithReasons(updatedTime, resourceName, statusTypeName[0], previousValues[0], updatedValues[0],reasons[0], region);	
	String pager2=	this.getStatusChangePagerWithReasons(updatedTime, resourceName, statusTypeName[1], previousValues[1], updatedValues[1], reasons[1],region);
	String pager3=	this.getStatusChangePagerWithReasons(updatedTime, resourceName, statusTypeName[2], previousValues[2], updatedValues[2],reasons[2], region);	
	String pager4=	this.getStatusChangePagerWithReasons(updatedTime, resourceName, statusTypeName[3], previousValues[3], updatedValues[3],reasons[3], region);	
	
	boolean mailPresent1 = false;
	boolean mailPresent2 = false;
	boolean mailPresent3 = false;
	boolean mailPresent4 = false;

	boolean pagerPresent1 = false;
	boolean pagerPresent2 = false;
	boolean pagerPresent3 = false;
	boolean pagerPresent4 = false;
	
	for (int intCount = 0; intCount < 4; intCount++) {

		this.verifyEmail(mailSubject);

		if (mailPresent1 == false) {
			mailPresent1 = this.verifyMailBodyWithoutJunkCharacters(mail1);
			System.out.println("mailPresent1"+ mailPresent1);
		}

		if (mailPresent2 == false) {
			mailPresent2 = this.verifyMailBodyWithoutJunkCharacters(mail2);
			System.out.println("mailPresent2"+ mailPresent2);
		}
		
		if (mailPresent3 == false) {
			mailPresent3 = this.verifyMailBodyWithoutJunkCharacters(mail3);
			System.out.println("mailPresent3"+ mailPresent3);
		}
		
		if (mailPresent4 == false) {
			mailPresent4 = this.verifyMailBodyWithoutJunkCharacters(mail4);
			System.out.println("mailPresent4"+ mailPresent4);
		}

		this.backToMailInbox();
	}
	assertTrue(mailPresent1&&mailPresent2&&mailPresent3&&mailPresent4);
		
	for (int intCount = 0; intCount < 4; intCount++) {

		this.verifyEmail(pagerSubject);

		if (pagerPresent1 == false) {
			pagerPresent1 = this.verifyMailBodyWithoutJunkCharacters(pager1);
			System.out.println("pagerPresent1"+ pagerPresent1);
		}

		if (pagerPresent2 == false) {
			pagerPresent2 = this.verifyMailBodyWithoutJunkCharacters(pager2);
			System.out.println("pagerPresent2"+ pagerPresent2);
		}
		
		if (pagerPresent3 == false) {
			pagerPresent3 = this.verifyMailBodyWithoutJunkCharacters(pager3);
			System.out.println("pagerPresent3"+ pagerPresent3);
		}
		
		if (pagerPresent4 == false) {
			pagerPresent4 = this.verifyMailBodyWithoutJunkCharacters(pager4);
			System.out.println("pagerPresent4"+ pagerPresent4);
		}

		this.backToMailInbox();
	}
	assertTrue(pagerPresent1&&pagerPresent2&&pagerPresent3&&pagerPresent4);
	return this;
   }
	
	public String getNormalStatusChangeEmailBody(String userFullName, String updatedTime, String resourceName, String statusTypeName, String previousValues, String updatedValues, String regions, String resourceType) throws Exception {
		String msgBody ="Status Update for " + userFullName
				+ ":" + "\nOn " + updatedTime + " " + resourceName + " "
				+ "changed " + statusTypeName
				+ " status from "+previousValues+" " + "to " + updatedValues
				+ ".\n\nComments:\n\nReasons:\n\nRegion: " + ""
				+ regions+"\n\nOther "+resourceType+"s in the region report the following "+statusTypeName+" status:"
				+ "\n\n\nPlease do not reply to this email message."
				+ " You must log into EMResource to take any action that may"
				+ " be required.";
		return msgBody;
		
	}
	
	public String getNormalStatusChangePager(String updatedTime, String resourceName, String statusTypeName, String previousValues, String updatedValues, String regions) throws Exception {
		String msgBody =statusTypeName
				+ " from "+previousValues+" to " + updatedValues + "; "
				+ "Reasons:\nSummary at " + updatedTime + "\n"
				+ "Region: " +  regions + "";
		return msgBody;
	}
	
	public Mails verifyMailAndPagerNotificationsForStatusChangeNotifications(String resourceAbbrevation, String userFullName, String updatedTime, String resourceName, ArrayList<String> statusTypeName,ArrayList<String> previousValues, ArrayList<String> updatedValues, String region, String resourceType) throws Exception {
		
		List<String> mailes = new ArrayList<String>();
		List<String> pagers = new ArrayList<String>();
		int count=0;
		String mailSubject=	MailsData.STATUS_CHANGE_MAIL_SUBJECT+" "+resourceName;
		String pagerSubject=MailsData.STATUS_CHANGE_PAGER_SUBJECT+" "+resourceAbbrevation;
	
		while(statusTypeName.size()>count)
		{
			mailes.add(getNormalStatusChangeEmailBody(userFullName, updatedTime, resourceName, statusTypeName.get(count), previousValues.get(count), updatedValues.get(count), region, resourceType));
			pagers.add(getNormalStatusChangePager(updatedTime, resourceName, statusTypeName.get(count), previousValues.get(count), updatedValues.get(count), region));
			count++;
		}
		
	boolean Mail1 = false;                          
	boolean Mail2= false;             
	boolean Mail3= false;
	
	boolean Pager1= false;   
	boolean Pager2= false; 
	boolean Pager3= false;
	 
	boolean mailPresent1 = false; 
	boolean mailPresent2 = false; 
	boolean mailPresent3 = false;
	
	boolean pagerPresent1 = false;
	boolean pagerPresent2 = false;
	boolean pagerPresent3 = false;
	
		for (int mailCount = 0; mailCount < statusTypeName.size(); mailCount++) {
			this.verifyEmail(mailSubject);
			
			mailPresent1 = this.verifyMailBodyWithoutJunkCharacters(mailes.get(0));
			mailPresent2 = this.verifyMailBodyWithoutJunkCharacters(mailes.get(1));
			mailPresent3 = this.verifyMailBodyWithoutJunkCharacters(mailes.get(2));
			
			if (mailPresent1 == true) {
				Mail1 = true;
			} else if (mailPresent2 == true) {
				Mail2 = true;
			} else if (mailPresent3 == true) {
				Mail3 = true;
			}

			this.backToMailInbox();
		}
		assertTrue(Mail1 && Mail2 && Mail3);

		for (int intCount = 0; intCount < statusTypeName.size(); intCount++) {
			this.verifyEmail(pagerSubject);
			pagerPresent1 = this.verifyStatusChangePagerContainsBody(pagers.get(0));
			pagerPresent2 = this.verifyStatusChangePagerContainsBody(pagers.get(1));
			pagerPresent3 = this.verifyStatusChangePagerContainsBody(pagers.get(2));
			
			if (pagerPresent1 == true) {
				Pager1 = true;
			} else if (pagerPresent2 == true) {
				Pager2 = true;
			} else if (pagerPresent3 == true) {
				Pager3 = true;
			}
			this.backToMailInbox();
		}
		assertTrue(Pager1 && Pager2 && Pager3);
		return this;
	}
	

	public Mails verifyNoNewEmailAndPagerNotificationsRecievedForStatusChange(String resource,String abbrevation) throws Exception {
	String	mail = "EMResource QA/Test Status Change for " + resource;
	String	pager= "EMResource QA/Test Change for " + abbrevation;
		
		String mailElement = Locators.SUBJECT_PART1 + mail + Locators.SUBJECT_PART2;
		String pagerElement = Locators.SUBJECT_PART1 + pager + Locators.SUBJECT_PART2;
		waitForElement.waitForElements(mailElement, "xpath");
		assertFalse(this.page.element(mailElement, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_TOO_SMALL), mailElement+ " is  present.");
		assertFalse(this.page.element(pagerElement, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_TOO_SMALL), pagerElement+ " is  present.");
		return this;
   }	
	
	public Mails verifyMailNotificationForAnEventCreated(ArrayList<String> userFullNames,
			String fullName, String regionName, String eventDescription, String subject) throws Exception {
		boolean boolCheck = false;
		boolean boolCheck1 = false;
		boolean boolCheck2 = false;
		ArrayList<String> email_Body = new ArrayList<>();
		Iterator<String> iterator = userFullNames.iterator();
		while(iterator.hasNext()){
			String userFullName = iterator.next();
			email_Body.add(this.getEventEmailBody(userFullName, fullName, regionName, eventDescription));
		}

		for (int intCount = 0; intCount < 3; intCount++) {
			this.verifyEmail(subject);
			String mailContent = this.getMailBody();
			if (mailContent.contains("Event Notice for: " + userFullNames.get(0))) {
				boolCheck = this.verifyMailContainsBody(email_Body.get(0));
			}
			if (mailContent.contains("Event Notice for: " + userFullNames.get(1))) {
				boolCheck1 = this.verifyMailContainsBody(email_Body.get(1));
			}
			if (mailContent.contains("Event Notice for: " + userFullNames.get(2))) {
				boolCheck2 = this.verifyMailContainsBody(email_Body.get(2));
			}
			this.backToMailInbox();
		}
		System.out.println(boolCheck);
		System.out.println(boolCheck1);
		System.out.println(boolCheck2);
		assertTrue(boolCheck && boolCheck1 && boolCheck2);
		return this;
	}
	
	public Mails verifyEditeStatusChangeMailAndPagerNotifications(
			String resourceAbbrevation, String userFullName,
			String updatedTime, String resourceName, String numberStatusType,
			String previousUpdatedNumberValue,
			String currentUpDatedNumberValue, String multiStatusType,
			String previousUpdatedStatus, String currentUpDatedStatus,
			String region, String resourceType) throws Exception {
		
	ArrayList<String> mailes = new ArrayList<String>();
	ArrayList<String> pagers = new ArrayList<String>();
		
	String mailSubject=	MailsData.STATUS_CHANGE_MAIL_SUBJECT+" "+resourceName;
	String pagerSubject=MailsData.STATUS_CHANGE_PAGER_SUBJECT+" "+resourceAbbrevation;
		
	mailes.add(getNormalStatusChangeEmailBody(userFullName, updatedTime, resourceName,numberStatusType , previousUpdatedNumberValue, currentUpDatedNumberValue, region, resourceType));
	pagers.add(getNormalStatusChangePager(updatedTime, resourceName, multiStatusType, previousUpdatedStatus,currentUpDatedStatus,region));
	
	boolean mailPresent1 = false; 
	boolean pagerPresent1 = false;
	
	this.verifyEmail(mailSubject);
	mailPresent1 = this.verifyMailBodyWithoutJunkCharacters(mailes.get(0));
	this.backToMailInbox();
	this.verifyEmail(pagerSubject);
	pagerPresent1 = this.verifyStatusChangePagerContainsBody(pagers.get(0));	
	this.backToMailInbox();
	assertTrue(mailPresent1&&pagerPresent1);
	return this;
	}
	
	
  public Mails verifyMailAndPagerNotificationsForStatusChangeNotification(String resourceAbbrevation, String userFullName, String updatedTime, String resourceName, ArrayList<String> statusTypeName,ArrayList<String> previousValues, ArrayList<String> updatedValues, String region, String resourceType) throws Exception {
		
		List<String> mailes = new ArrayList<String>();
		List<String> pagers = new ArrayList<String>();
		int count=0;
		int numberOfMailes=0;
		int numberOfPagers=0;
		String mailSubject=	MailsData.STATUS_CHANGE_MAIL_SUBJECT+" "+resourceName;
		String pagerSubject=MailsData.STATUS_CHANGE_PAGER_SUBJECT+" "+resourceAbbrevation;
	
		while(statusTypeName.size()>count)
		{
			mailes.add(getNormalStatusChangeEmailBody(userFullName, updatedTime, resourceName, statusTypeName.get(count), previousValues.get(count), updatedValues.get(count), region, resourceType));
			pagers.add(getNormalStatusChangePager(updatedTime, resourceName, statusTypeName.get(count), previousValues.get(count), updatedValues.get(count), region));
			count++;
		}
	
	boolean mailPresent = false; 
	boolean pagerPresent = false;
	
	//Mails
		for (int mailCount = 0; mailCount < statusTypeName.size()*2; mailCount++) {
		this.verifyEmail(mailSubject);	
		for (int mails = 0; mails < statusTypeName.size(); mails++) {	
		mailPresent = this.verifyMailBodyWithoutJunkCharacters(mailes.get(mails));
		if (mailPresent) {
		numberOfMailes++;
		break;
			}
		}
		this.backToMailInbox();
		}
		assertTrue(statusTypeName.size()*2==numberOfMailes);	
    //Pagers
		for (int pagersCount = 0; pagersCount < statusTypeName.size(); pagersCount++) {
		     this.verifyEmail(pagerSubject);
		for (int pager = 0; pager < statusTypeName.size(); pager++) {
		      pagerPresent = this.verifyStatusChangePagerContainsBody(pagers.get(pager));
		if (pagerPresent) {
		     numberOfPagers++;
		break;
		  }
	    }
		this.backToMailInbox();
		}
		assertTrue(statusTypeName.size()==numberOfPagers);
		return this;
	}
	
  public Mails verifyMailAndPagerNotificationsForAnEditedEvent(ArrayList<String> userFullNames,
			String fullName, String regionName, String eventDescription, String subject) throws Exception {
		boolean boolCheck1 = false;
		boolean boolCheck2 = false;
		boolean boolCheck3 = false;
		boolean boolCheck4 = false;

		ArrayList<String> email_Body = new ArrayList<>();
		Iterator<String> iterator = userFullNames.iterator();
		while(iterator.hasNext()){
			String userFullName = iterator.next();
			email_Body.add(this.getEventEmailBody(userFullName, fullName, regionName, eventDescription));
		}
		
		String pager_Body = this.getEventPagerBody(fullName, regionName, eventDescription);

		for (int intCount = 0; intCount < 4; intCount++) {
			this.verifyEmail(subject);
			String mailContent = this.getMailBody();
			if (mailContent.contains("Event Notice for: " + userFullNames.get(0))) {
				boolCheck1 = this.verifyMailContainsBody(email_Body.get(0));
			}
			if (mailContent.contains("Event Notice for: " + userFullNames.get(1))) {
				boolCheck2 = this.verifyMailContainsBody(email_Body.get(1));
			}

			if (boolCheck3 == false) {
				boolCheck3 = this.verifyMailBody(pager_Body);
			}
			if (boolCheck4 == false) {
				boolCheck4 = this.verifyMailBody(pager_Body);
			}
			this.backToMailInbox();
		}
		System.out.println("boolCheck1" + boolCheck1);
		System.out.println("boolCheck2" + boolCheck2);
		System.out.println("boolCheck3" + boolCheck3);
		System.out.println("boolCheck4" + boolCheck4);
		assertTrue(boolCheck1 && boolCheck2 && boolCheck3 && boolCheck4);
		return this;
	}
  
  public Mails verifyMailAndPagerNotificationForAnEventCreated(ArrayList<String> userFullNames,
			String fullName, String regionName, String eventDescription, String subject) throws Exception {
		boolean boolCheck = false;
		boolean boolCheck1 = false;
		boolean boolCheck2 = false;
		boolean boolCheck3 = false;
		boolean boolCheck4 = false;
		boolean boolCheck5 = false;
		
		ArrayList<String> email_Body = new ArrayList<>();
		Iterator<String> iterator = userFullNames.iterator();
		while(iterator.hasNext()){
			String userFullName = iterator.next();
			email_Body.add(this.getEventEmailBody(userFullName, fullName, regionName, eventDescription));
		}
		String pager_Body = this.getEventPagerBody(fullName, regionName, eventDescription);
		
		for (int intCount = 0; intCount < 6; intCount++) {
			this.verifyEmail(subject);
			String mailContent = this.getMailBody();
			if (mailContent.contains("Event Notice for: " + userFullNames.get(0))) {
				boolCheck = this.verifyMailContainsBody(email_Body.get(0));
			}
			if (mailContent.contains("Event Notice for: " + userFullNames.get(1))) {
				boolCheck1 = this.verifyMailContainsBody(email_Body.get(1));
			}
			if (mailContent.contains("Event Notice for: " + userFullNames.get(2))) {
				boolCheck2 = this.verifyMailContainsBody(email_Body.get(2));
			}
			if (boolCheck3 == false) {
				boolCheck3 = this.verifyMailBody(pager_Body);
			}
			if (boolCheck4 == false) {
				boolCheck4 = this.verifyMailBody(pager_Body);
			}
			if (boolCheck5 == false) {
				boolCheck5 = this.verifyMailBody(pager_Body);
			}
			this.backToMailInbox();
		}
		System.out.println(boolCheck);
		System.out.println(boolCheck1);
		System.out.println(boolCheck2);
		System.out.println(boolCheck3);
		System.out.println(boolCheck4);
		System.out.println(boolCheck5);
		assertTrue(boolCheck && boolCheck1 && boolCheck2 && boolCheck3 && boolCheck3 && boolCheck5);
		return this;
	}
  
  public String getMultiRegionEventEmailBody(String userFullName, String eventDescription,String fullName,String regionName1, String regionName2) throws Exception {
		String messageBody = 
//				"THIS MESSAGE IS FROM THE QA/TEST ENVIRONMENT." + "\n\n" +  
				"Event Notice for: " + userFullName + "\n"
				+ "Information: " + eventDescription +"\n\n" 
				+ "From: "	+ fullName + "\n\nRegions: " + regionName1 + ", "  + regionName2 
				+ "\n\nPlease do not reply to this email message. "
				+ "You must log into EMResource to take any "
				+ "action that may be required." + "\n"
				+ "https://emresource.qa.intermedix.com" ;
//				+ "\n\n" 
//				+ "For information on how to unsubscribe from or change your EMResource event notifications, click on the following link "
//				+ "\n" + "https://emresource.qa.intermedix.com/resources/help/EMResourceNotificationPreferences.html";
		return messageBody;
	}

	public String getMultiRegionEventPagerBody(String eventDescription, String userFullName,String regionName1, String regionName2) throws Exception {
		String messageBody = 
//				"THIS MESSAGE IS FROM THE QA/TEST ENVIRONMENT." + "\n\n" +
				"Information: " + eventDescription + "\nFrom: "
				+ userFullName + "\nRegions: " + regionName1 + ", "  + regionName2 ;
		return messageBody;
	}
	
	public Mails verifyMailAndPagerNotificationsForMultiRegionEvent(String userFullName, String eventDescription, String fullName, String regionName1, String regionName2, String subject) throws Exception {
		boolean blnMsg1 = false;
		boolean blnMsg2 = false;

		String emailBody = this.getMultiRegionEventEmailBody(userFullName, eventDescription, fullName, regionName1,  regionName2);
		String pagerBody = this.getMultiRegionEventPagerBody(eventDescription, userFullName, regionName1, regionName2);
		
		for (int intCount = 0; intCount < 2; intCount++) {

			this.verifyEmail(subject);

			if (blnMsg1 == false) {
				blnMsg1 = this.verifyMailBodyWithoutJunkCharacters(emailBody);
			}
			if (blnMsg2 == false) {
				blnMsg2 = this.verifyMailBody(pagerBody);
			}
			this.backToMailInbox();
		}
		System.out.println("blnMsg1"+blnMsg1);
		System.out.println("blnMsg2"+blnMsg2);
		assertTrue(blnMsg1 && blnMsg2);
		return this;
	}
	
	public Mails verifyMailAndPagerNotificationsOfSingleRegionEventWithAddress(String userFullName, String regionName,String eventDescription,String city,String countryCode,String zipCode,String country,String subject) throws Exception {
		boolean blnMsg1 = false;
		boolean blnMsg2 = false;
		
		String emailBody = this.getEventMailWithAddress(userFullName, userFullName, regionName, eventDescription, city, countryCode, zipCode, country);
		String pagerBody = this.getEventPagerWithAddress(userFullName, userFullName, regionName, eventDescription, city, countryCode, zipCode, country);

		for (int intCount = 0; intCount < 2; intCount++) {

			this.verifyEmail(subject);

			if (blnMsg1 == false) {
				blnMsg1 = this.verifyMailBodyWithoutJunkCharacters(emailBody);
			}
			if (blnMsg2 == false) {
				blnMsg2 = this.verifyMailBody(pagerBody);
			}
			this.backToMailInbox();
		}
		System.out.println(blnMsg1);
		System.out.println(blnMsg2);
		assertTrue(blnMsg1 && blnMsg2);
		return this;
	}
	
	 public String verifyMailAndPagerNotification(String userFullName,String regionName,String eventDescription,String to, String subject) throws Exception {
			
		    boolean blnMsg1 = false;
		    boolean blnMsg2 = false;
			
			String UrlLink = "";
			
			String emailBody = this.getEventEmailBody(userFullName, userFullName,regionName, eventDescription);
			String pagerBody = this.getEventPagerBody(userFullName, regionName, eventDescription);

			for (int intCount = 0; intCount < 2; intCount++) {

				this.verifyEmail(subject);

				if (blnMsg1 == false) {
					blnMsg1 = this.verifyMailContainsBody(emailBody);
					if (blnMsg1 == true) {
						UrlLink = this.GetUrlLinkFromMsgBody(to, subject);
						System.out.println(UrlLink);

					}
					if ( blnMsg2 == false) {
						blnMsg2 = this
						.verifyMailBody(pagerBody);
					}
				}

					this.backToMailInbox();
			}
			assertTrue(blnMsg1 && blnMsg2);
			return UrlLink;
			}
}

	


