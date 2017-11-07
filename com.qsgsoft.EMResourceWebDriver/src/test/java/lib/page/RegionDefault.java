package lib.page;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import qaframework.lib.WaitTimeConstants;
import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;
import qaframework.lib.webElements.WebElements;

public class RegionDefault extends PageObject {

	WebDriver driver;
	WebElements element;
	WaitForElement objWaitForElement;
	
	//Locators
	private String regionName = "regionName";	
	private String regionDefault = "//div[@id='topSubNav']/h1[text()='Region Default']";
	private String strFrame = "Data",
			userNameInFooter = "//div[@id='footer']/table/tbody/tr/td[3]",
			updateStatus = "//div[@id='topSubNav']/h1[text()='Update Status']",
			acknowlwdgeNotification = "//button[text()='Acknowledge All Notifications']",
			header = "//div[@id='topSubNav']/h1",
			homeButton="//div/a/img[@src='/image/home.gif']",
			excelLink = "//a[@title='Excel snapshots']",
			generateReportLink = "//input[@id='submitSnapshot']",
			selectDateAndTimeLink = "//input[@id='snapshotDateSelectRadio_selected']",
			snapShotDate = "//input[@id='snapshotDate']",
			snapShotHour = "//select[@id='snapshotHours']",
			snapShotMinute = "//select[@id='snapshotMinutes']",
			snapshotWindow="//div[@id='snapshotDateForm']/form[@name='snapshotForm']",
			printLink="//div[@id='link_print']",
			close="//div[@class='sideButtons noprint']",
			errorMsg2 ="//div[2]",
			acknowlwdgeForms = "//button[text()='Acknowledge All Forms']",
			reviewForms = "//button[text()='Review Form']",
			acknowledge = "// button[text()='Acknowledge']",
			dispatchForm = "//button[text()='Send Form']",
			acknowledgeButton = "//button[text()='Acknowledge']",
			reviewButton = "//button[text()='Review']",
			securityQuestion="//div[@id='headingTitle'][text()='Security Question and Answer']",
			saveButton="input[value='Save']",
			closeInSecQuestPopUp = "#TB_closeWindowButton",
			headingtitle = "#headingTitle",
			subTitle = "#headingSubtitle",
			printForm = "//button[text()='Print Form']",
			question = "#question",
			answer = "#response",
			email = "email",
			cancelButton = "input[value='Cancel']",
			appSwitcher="//div[@id='header-selectApplication']/span[text()='EMResource']",
		    appSwitcherLink="Account Management",
		    notAuthorizedHeader = "//div[@id='topSubNav']/h1[text()='EMResource Warning - Not Authorized']",
		    notAuthorized = "//h1[@class='emsErrorTitle'][text()='EMResource Warning — Not Authorized']",
		    webServiceAccountError = "//h1[text()='Web Service Account Error']",
		    errorMessage = "//p[contains(text(),'Error')]",
		    clickHereLink = "//a[text()='here']",
		    seurityPage="//div[@id='headingTitle'][text()='Security Question and Answer']";
			
	
	public RegionDefault(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
	}

	/**********************************************************************************
	  * Description : This function is to click on 'Region' link
	  * Date        : 09/06/2014
	  * Author      : Anil
	  **********************************************************************************/
	public RegionDefault clickRegionLink() throws Exception {
		objWaitForElement.waitForElements(regionName, "id");
		this.page.element(regionName, "id").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select frame
	  * Date        : 09/06/2014
	  * Author      : Anil
	  **********************************************************************************/
	public RegionDefault selectFrame() throws Exception {
		Thread.sleep(3000);
		try{
			if(this.page.element("//frame[@name='Data']", "xpath").getOne().isDisplayed()){
				WebDriverWait wait = new WebDriverWait(this.driver, WaitTimeConstants.WAIT_TIME_LONG);
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(strFrame));
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Region Default is displayed
	  * Date        : 09/06/2014
	  * Author      : Anil
	  **********************************************************************************/
	public RegionDefault verifyRegionDefaultPage() throws Exception {
		objWaitForElement.waitForElements(regionDefault, "xpath");		
		assertTrue(this.page.element(regionDefault, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify user name in the footer.
	  * Date		: 22/07/2014
	  * Author		: Rensuhree
	  **********************************************************************************/
	public RegionDefault verifyUserNameInFooter(String strUserName)
			throws Exception {
		objWaitForElement.waitForElements(userNameInFooter, "xpath");
		assertTrue(this.page.element(userNameInFooter, "xpath").isElementPresent(), "User name footer element is not present.");
		this.page.element(userNameInFooter, "xpath").getOne().getText().contains(strUserName);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Update Status' is displayed
	  * Date        : 09/06/2014
	  * Author      : Anil
	  **********************************************************************************/
	public RegionDefault verifyUpdateStatusPage() throws Exception {
		objWaitForElement.waitForElements(updateStatus, "xpath");
		assertTrue(this.page.element(updateStatus, "xpath").getOne().isDisplayed());
		return this;
	}
	

	/**********************************************************************************
	 * Description : This function is to click on acknowledge nootification Date
	 * : 10/06/2014 Author : Anil
	 **********************************************************************************/
	public RegionDefault clickAcknowledgeAllNotifications() throws Exception {
		objWaitForElement.waitForElements(acknowlwdgeNotification, "xpath");
		this.page.element(acknowlwdgeNotification, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify web notification frame Banner
	 * Date : 10/06/2014 Author : Anil
	 **********************************************************************************/
	public RegionDefault verWebNotificationframe() throws Exception {
		WebDriverWait wait = new WebDriverWait(this.driver,
				WaitTimeConstants.WAIT_TIME_LONG);
		wait.until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt("TB_iframeContent"));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify particular region is displayed
	  * Date        : 07/10/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public RegionDefault verifyParticularRegPageIsDisplayed(String strRegion)
			throws Exception {
		objWaitForElement.waitForElements(header, "xpath");
		assertEquals(strRegion, this.page.element(header, "xpath").getOne()
				.getText());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify eics icon to the facility
	  * Date        : 10/10/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public RegionDefault verEICSIconInRegDefault(String strIconName,
			String strResVal, String strResName) throws Exception {
		objWaitForElement.waitForElements("//a[1][@id='r_" + strResVal + "'][text()='" + strResName + "']",
				"xpath");
		assertTrue(this.page.element(
				"//a[1][@id='r_" + strResVal + "'][text()='" + strResName + "']",
				"xpath").isElementPresent());
		assertTrue(this.page.element(
				"//a[2][@id='r_" + strResVal + "']/img[@src='"+strIconName+"']",
				"xpath").isElementPresent());
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to verify web notification message
	  * Date        : 10/10/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public RegionDefault verWebNotificationMsg(String strSubject,
			String strNotificationMsg) throws Exception{
		objWaitForElement.waitForElementBycssSelector("dt.othr");
			this.page.element("dt.othr", "css").getOne().isDisplayed();
			this.page.element("dd.desc", "css").getOne().isDisplayed();
			assertEquals(strSubject, this.page.element("dt.othr", "css").getOne()
					.getText());
			assertEquals(strNotificationMsg, this.page.element("dd.desc", "css").getOne()
					.getText());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify web notification frame is not present Banner
	 * Date : 10/06/2014 Author : Shradda
	 **********************************************************************************/
	public RegionDefault verWebNotificationframeIsNotPresent() throws Exception {
		assertFalse(this.page.element("TB_iframeContent", "id").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/*********************************************************************************
	   * Description : This function is to click home button
	   * Date        : 11/06/2014
	   * Author      : Anitha
	   *******************************************************************************/
	public RegionDefault clickOnHomeButton() throws Exception {
		objWaitForElement.waitForElements(homeButton,
				"xpath");
		this.page.element(homeButton, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on excel link
	  * Date		: 12/11/2014
	  * Author		: Anil
	  **********************************************************************************/
	public RegionDefault clickExcelOption()
			throws Exception {
		objWaitForElement.waitForElements(excelLink,
				"xpath");
			this.page.element_wait(excelLink, "xpath").waitForVisibilityOfElement();	
		  Actions moveTO = new Actions(driver);
		  moveTO.moveToElement(driver.findElement(By.xpath(excelLink))).click()
		    .build().perform();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on generate option
	  * Date		: 12/11/2014
	  * Author		: Anil
	  **********************************************************************************/
	public RegionDefault clickOnGenerateReportOption()
			throws Exception {
		objWaitForElement.waitForElements(generateReportLink,
				"xpath");
		this.page.element(generateReportLink, "xpath").getOne().click();	
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on select date and time option
	  * Date		: 12/11/2014
	  * Author		: Anil
	  **********************************************************************************/
	public RegionDefault clickOnSelectDateAndTimeOption()
			throws Exception {
		objWaitForElement.waitForElements(selectDateAndTimeLink,
				"xpath");
		this.page.element(selectDateAndTimeLink, "xpath").getOne().click();	
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter snapshot date
	  * Date		: 12/11/2014
	  * Author		: Anil
	  **********************************************************************************/
	public RegionDefault enterSnapShotDate(String strDate)
			throws Exception {
		Thread.sleep(2000);
		objWaitForElement.waitForElements(snapShotDate,
				"xpath");
		this.page.element(snapShotDate, "xpath").clearInputValue().sendKeys(strDate);	
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select hour
	  * Date		: 12/11/2014
	  * Author		: Anil
	  **********************************************************************************/
	public RegionDefault selectSnapShotHour(String strHour)
			throws Exception {
		objWaitForElement.waitForElements(snapShotHour,
				"xpath");
		this.page.element(snapShotHour, "xpath").getOne().click();
		this.page.element(snapShotHour, "xpath").webElementToSelect().selectByVisibleText(strHour);
		return this;
	}
	
	
	/**********************************************************************************
	  * Description : This function is to select hour
	  * Date		: 12/11/2014
	  * Author		: Anil
	  **********************************************************************************/
	public RegionDefault selectSnapShotMinutes(String strMinutes)
			throws Exception {
		objWaitForElement.waitForElements(snapShotMinute,
				"xpath");
		this.page.element(snapShotMinute, "xpath").getOne().click();
		this.page.element(snapShotMinute, "xpath").webElementToSelect().selectByVisibleText(strMinutes);
		return this;
	}
	
	
	/**********************************************************************************
	  * Description : This function is to select and enter date and time option
	  * Date		: 12/11/2014
	  * Author		: Anil
	  **********************************************************************************/
	public RegionDefault selectAndEnterDateAndTime(String strDate, String strHour, String strMinutes)
			throws Exception {
		this.clickOnSelectDateAndTimeOption();
		this.selectSnapShotHour(strHour);
		this.selectSnapShotMinutes(strMinutes);
		this.enterSnapShotDate(strDate);
		this.clickOnSelectDateAndTimeOption();
		Thread.sleep(2000);
		this.clickOnGenerateReportOption();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify snapshot window is displayed
	  * Date		: 17/11/2014
	  * Author		: Sangappa
	  **********************************************************************************/
	public RegionDefault verSnapshotWindowDisplayed() throws Exception {
		objWaitForElement.waitForElements(snapshotWindow,
				"xpath");
		   assertTrue(this.page.element(snapshotWindow, "xpath").getOne().isDisplayed(),
		     "Window is not DiWindowsplayed");
		   return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify snapshot window is Not displayed
	  * Date		: 17/11/2014
	  * Author		: Sangappa
	  **********************************************************************************/
	public RegionDefault verSnapshotWindowNotDisplayed() throws Exception {
		   assertFalse(this.page.element(snapshotWindow, "xpath")
		     .isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE), "Window is  displayed");
		   return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on print link
	  * Date		: 12/11/2014
	  * Author		: Anil
	  **********************************************************************************/
	public RegionDefault clickPrintOption()
			throws Exception {
/*		objWaitForElement.waitForElements(printLink,
				"xpath");
		this.page.element(printLink, "xpath").getOne().click();
		return this;*/
		objWaitForElement.waitForElements(printLink,
				"xpath");
		WebElement element = driver.findElement(By.xpath(printLink));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", element);
		objWaitForElement.waitForElements(selectDateAndTimeLink,
				"xpath");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify snapshot window is Not displayed
	  * Date		: 17/11/2014
	  * Author		: Sangappa
	  **********************************************************************************/
	public RegionDefault verSnapShotWindowErrorPage() throws Exception {
		objWaitForElement.waitForElements(errorMsg2,
				"xpath");
		  assertTrue(this.page.element(errorMsg2, "xpath").getOne().isDisplayed(),
		    "no error msg");
		  assertEquals(
		    "You cannot specify a future date or time for this snapshot report.",
		    this.page.element(errorMsg2, "xpath").getOne().getText());

		  return this;
		 }
	
	/**********************************************************************************
	  * Description : This function is to click on close snap shot window error
	  * Date		: 17/11/2014
	  * Author		: Sangappa
	  **********************************************************************************/
	public RegionDefault clickOnCloseSnapShotWindowError() throws Exception {
		objWaitForElement.waitForElements(close, "xpath");
		this.page.element(close, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to switch to default frame
	  * Date		: 03/12/2014
	  * Author		: Renushree
	  **********************************************************************************/
	public RegionDefault switchToDefaultFrame() throws Exception {
		driver.switchTo().defaultContent();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on excel link
	  * Date		: 12/11/2014
	  * Author		: Anil
	  **********************************************************************************/
	public RegionDefault verifyExcelOptionNotDisplayed() throws Exception {
		assertFalse(this.page.element(excelLink, "xpath").isElementPresent(
				WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to verify web notification message
	  * Date        : 10/10/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public RegionDefault verWebNotificationMsgForForms(String strSubject,
			String strNotificationMsg) throws Exception{
		Thread.sleep(5000);
		objWaitForElement.waitForElementBycssSelector("dt.form");
		this.page.element("dt.form", "css").getOne().isDisplayed();
		this.page.element("dd.desc", "css").getOne().isDisplayed();
			
		assertEquals(strSubject, this.page.element("dt.form", "css").getOne()
					.getText());
		String str =  this.page.element("dd.desc", "css").getOne()
					.getText();
		System.out.println("msg on web:" + str);
		assertTrue(str.contains(strNotificationMsg), str + " is not same as :" + strNotificationMsg);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on acknowledge Forms Date
	 * : 16/12/2014 Author : Renushree
	 **********************************************************************************/
	public RegionDefault clickAcknowledgeAllForms() throws Exception {
		objWaitForElement.waitForElementByxpathSelector(acknowlwdgeForms);
		this.page.element(acknowlwdgeForms, "xpath").getOne().sendKeys(Keys.ENTER);
		return this;
	}
	
    /**********************************************************************************
     * Description : This function is to click on Review Forms Button.
     * Date        : 16/12/2014 
     * Author      : Pallavi
     **********************************************************************************/
	public RegionDefault clickReviewForm() throws Exception {
		objWaitForElement.waitForElementByxpathSelector(reviewForms);
		this.page.element(reviewForms, "xpath").getOne().click();
		return this;
	}
    
	/**********************************************************************************
	  * Description : This function is to verify web notification message does not contain
	  * 			  some message.
	  * Date        : 22-Dec-2014
	  * Author      : Pallavi
	  **********************************************************************************/
	public RegionDefault verWebNotificationMsgDoesNotContainGivenMsg(String strSubject,
			String strNotificationMsg) throws Exception{
		objWaitForElement.waitForElements("dt.form", "css");
			this.page.element("dt.form", "css").getOne().isDisplayed();
			this.page.element("dd.desc", "css").getOne().isDisplayed();
			assertEquals(strSubject, this.page.element("dt.form", "css").getOne()
					.getText());
			String str =  this.page.element("dd.desc", "css").getOne()
					.getText();
			assertFalse(str.contains(strNotificationMsg));
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to click on acknowledge Forms 
	 * Date			: 20/01/2015 
	 * Author 		: Renushree
	 **********************************************************************************/
	public RegionDefault clickAcknowledgeInReadReciept() throws Exception {
		objWaitForElement.waitForElementByxpathSelector(acknowledge);
		this.page.element(acknowledge, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify web notification having multiple message
	  * Date        : 20/1/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public RegionDefault verWebNotificationMultipleMsgformsForms(
			String strSubject, String strNotificationMsg) throws Exception {
		boolean bln;
		objWaitForElement.waitForElementBycssSelector("dt.form");
		this.page.element("dt.form", "css").getOne().isDisplayed();
		this.page.element("dd.desc", "css").getOne().isDisplayed();
		String strFrm = this.page.element("//dl/dt[@class='form']", "xpath").getOne()
				.getText();
		String strFrm1 = this.page.element("//dl[2]/dt[@class='form']", "xpath").getOne()
				.getText();
		if(strFrm.contains(strSubject)){
			bln = true;
		}else if (strFrm1.contains(strSubject)) {
			bln = true;
		}
//		assertEquals(strSubject, this.page.element("dt.form", "css").getOne()
//				.getText());
		String str = this.page.element(
				"//dl/dd[@class='desc']","xpath").getOne().getText();
		String str2 = this.page.element(
				"//dl[2]/dd[@class='desc']","xpath").getOne().getText();
		if(str.contains(strNotificationMsg)){
			bln = true;
		}else if (str2.contains(strNotificationMsg)) {
			bln = true;
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to click on dispatch form 
	 * Date			: 30/01/2015 
	 * Author 		: Renushree
	 **********************************************************************************/
	public RegionDefault clickDispatchForm() throws Exception {
		objWaitForElement.waitForElements(dispatchForm, "xpath");
		this.page.element(dispatchForm, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to close the form acknowledgement
	 * Date			: 02/02/2015 
	 * Author 		: Renushree
	 **********************************************************************************/
	public RegionDefault closeFormAcknowledgement() throws Exception {
		objWaitForElement.waitForElement("//div[@id='TB_closeAjaxWindow']");
		this.page.element("//div[@id='TB_closeAjaxWindow']", "xpath").getOne().click();
		return this;
	}
	/**********************************************************************************
	 * Description 	: This function is to verify snapshot window of event
	 * Date			: 04/03/2015 
	 * Author 		: Hanumegowda
	 **********************************************************************************/
	public RegionDefault verSnapShotWindowOfEvent(String strEventName,
			String strApplicationTime) throws Exception {
		objWaitForElement
				.waitForElementByxpathSelector("//div[@class='sideButtons noprint']/following-sibling::h2[text()='"
						+ strApplicationTime  + " " + strEventName + "']");
		assertTrue(this.page.element(
				"//div[@class='sideButtons noprint']/following-sibling::h2[text()='"
						+ strApplicationTime  + " " + strEventName + "']",
				"xpath").isElementPresent());
		return this;
	}
	
	/****************************************************************************
	 * Description 	: This function is to click on 'Acknowledge' button in Forms.
	 * Date			: 09/03/2015 
	 * Author 		: Rahul
	 ****************************************************************************/
	public RegionDefault clickAcknowledgeButton() throws Exception {
		objWaitForElement.waitForElementBycssSelector(acknowledgeButton);
		this.page.element(acknowledgeButton, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
     * Description       : This function is to verify web notification frame Banner for 'Read Receipts'
     * Date              : 09-Mar-2015
     * Author            : Pallavi
     **********************************************************************************/
    public RegionDefault verWebNotificationForReadReceipt() throws Exception {
//           assertTrue(this.page.element(
//                        "//div[@id='TB_title']/div[text()='Read Receipts']", "xpath")
//                        .isElementPresent());
          // assertEquals(this.page.element("//div[@id='TB_ajaxWindowTitle']", "xpath").getOne().getText(), "Read Receipts");
           WebDriverWait wait = new WebDriverWait(this.driver,
                        WaitTimeConstants.WAIT_TIME_LONG);
           wait.until(ExpectedConditions
                        .frameToBeAvailableAndSwitchToIt("TB_iframeContent"));
//           assertTrue(this.page.element(
//                   "//div[@id='TB_title']/div[text()='Read Receipts']", "xpath")
//                   .isElementPresent());
           return this;
    }

    /**********************************************************************************
	  * Description : This function is to verify IPN web notification message
	  * Date        : 10/10/2014
	  * Author      : Rahul
	  **********************************************************************************/
	public RegionDefault verIncomingPatientNotificationMsg(String strSubject,
			String[] arrHeaderNames, String[] arrAnswers ,String strArrivalTime)
			throws Exception {
		Thread.sleep(5000);
		objWaitForElement.waitForElementBycssSelector("dt.ipn");
		assertEquals(strSubject, this.page.element("dt.ipn", "css").getOne()
				.getText());

		for (int i = 0; i < (arrHeaderNames.length - 1); i++) {
			System.out.println(arrHeaderNames[i]+", "+arrAnswers[i]);
			if(arrHeaderNames[i]!="ETA:"){
			assertTrue(
					this.page
							.element(
									"//table//td[text()='"
											+ arrHeaderNames[i]
											+ "']/following-sibling::td[contains(text(),'"
											+ arrAnswers[i] + "')]", "xpath")
							.isElementPresent(), arrHeaderNames[i] + " : "
							+ arrAnswers[i] + " is not present");
		}

		}

	/*	assertTrue(
				this.page.element(
						"//table//span[text()='ETA']/parent::td/following-sibling::td[text()='"
								+ strArrivalTime + "']", "xpath").isElementPresent(), "ETA : " + strArrivalTime
						+ " is not present");
*/

		return this;
	}
	
    /*************************************************************************************************
	  * Description : This function is to verify IPN web notification message in 'Review popup window'
	  * Date        : 12/10/2014
	  * Author      : sowmya
	  ************************************************************************************************/
	public RegionDefault verIncomingPatientNotificationMsgReviewPopupWindow(
			String strSubject, String strSubmittedtime,
			String[] arrHeaderNames, String[] arrAnswers, String strArrivalTime)
			throws Exception {
		objWaitForElement.waitForElements("dt.form", "css");
		objWaitForElement.waitForElementBycssSelector("dt.form");
		this.page.element("dt.form", "css").getOne().isDisplayed();
		assertEquals(strSubject, this.page.element("dt.form", "css").getOne()
				.getText());

		objWaitForElement.waitForElementBycssSelector("dd.ts");
		this.page.element("dd.ts", "css").getOne().isDisplayed();
		assertEquals(strSubmittedtime, this.page.element("dd.ts", "css")
				.getOne().getText());

		for (int i = 0; i <= (arrHeaderNames.length - 1); i++) {
			assertTrue(
					this.page
							.element(
									"//table//td[text()='"
											+ arrHeaderNames[i]
											+ "']/following-sibling::td[contains(text(),'"
											+ arrAnswers[i] + "')]", "xpath")
							.isElementPresent(), arrHeaderNames[i] + " : "
							+ arrAnswers[i] + " is not present");
		}
		assertTrue(
				this.page.element(
						"//table//span[text()='ETA']/parent::td/following-sibling::td[text()='"
								+ strArrivalTime + "']", "xpath")
						.isElementPresent(), "ETA : " + strArrivalTime
						+ " is not present");

		return this;
	}
	
    /***************************************************************
     * Description : This function is to click on Review Button.
     * Date        : 12/03/2014 
     * Author      : Sowmya
     **************************************************************/
	public RegionDefault clickReviewButton() throws Exception {
		objWaitForElement.waitForElementByxpathSelector(reviewForms);
		this.page.element(reviewButton, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify snapshot window of other region views
	 * Date			: 23/03/2015 
	 * Author 		: Hanumegowda
	 **********************************************************************************/
	public RegionDefault verSnapShotWindowOfOtherRegionView(String strApplicationTime) throws Exception {
		objWaitForElement.waitForElementByxpathSelector("//h2[contains(text(),'Region Default" + " " + strApplicationTime + "')]");
		assertTrue(this.page.element("//h2[contains(text(),'Region Default" + " " + strApplicationTime + "')]", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify eics icon is not displayed to the facility
	  * Date        : 10/10/2014
	  * Author      : Anil
	  **********************************************************************************/
	public RegionDefault verEICSIconNotDisplayedInRegDefault(String strIconName,
			String strResVal, String strResName) throws Exception {
		objWaitForElement.waitForElements("//a[1][@id='r_" + strResVal + "'][text()='" + strResName + "']",
				"xpath");
		assertTrue(this.page.element(
				"//a[1][@id='r_" + strResVal + "'][text()='" + strResName + "']",
				"xpath").isElementPresent());
		assertFalse(this.page.element(
				"//a[2][@id='r_" + strResVal + "']/img[@src='"+strIconName+"']",
				"xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify and answer security question and answer
	  * Arguments	: strEmailID
	  * Date        : 27/04/2015
	  * Author      : Renushree
	  **********************************************************************************/	
	public RegionDefault verAndAnswerSecurityQuesAndAnswerPopUp(String strEmailID) throws Exception {
		objWaitForElement.waitForElements(securityQuestion, "xpath");
		assertTrue(this.page.element(securityQuestion, "xpath").isElementPresent());
		this.page.element("response", "id").clearInputValue().sendKeys("1234");
		String str = this.page.element("email", "id").getOne().getAttribute("value");
		if (str.equals(strEmailID)) {
			this.page.element(saveButton, "css").getOne().click();
			Thread.sleep(5000);
		}
		return new RegionDefault(this.driver);
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify security question saved screen is displayed.
	 * Date 		: 27/04/2015   
	 * Author 		: Renushree
	 **********************************************************************************/
	public RegionDefault verSecQuestSavedPage() throws Exception {
		this.driver
				.manage()
				.timeouts()
				.implicitlyWait(WaitTimeConstants.WAIT_TIME_SMALL,
						TimeUnit.SECONDS);
		objWaitForElement.waitForElements(headingtitle, "css");
		assertEquals("Security Question", this.page.element(headingtitle, "css")
				.getOne().getText());
		assertEquals("Your security question and answer have been saved.", this.page
				.element(subTitle, "css").getOne().getText());
		driver.switchTo().defaultContent();
		return this;
	}
		
	/**********************************************************************************
	 * Description 	: This function is to click on close on Security question ans answer window
	 * Date 		: 27/04/2015  
	 * Author 		: Renushree
	 **********************************************************************************/
	public RegionDefault clickOnCloseOnSecQuesAndAnswWind() throws Exception {
		WebDriverWait wait = new WebDriverWait(this.driver,
				WaitTimeConstants.WAIT_TIME_LONG);
		wait.until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(strFrame));
		this.page.element(closeInSecQuestPopUp, "css").getOne().click();
		return this;
	}

    /**********************************************************************************
     * Description : This function Review Forms Button is displayed
     * Date        : 08-May-2015 
     * Author      : Pallavi
     **********************************************************************************/
	public RegionDefault verifyReviewFormButtonIsDisplayed() throws Exception {
		objWaitForElement.waitForElementByxpathSelector(reviewForms);
		assertTrue(this.page.element(reviewForms, "xpath").isElementPresent());
		return this;
	}

    /**********************************************************************************
     * Description : This function Print Form Button is displayed
     * Date        : 08-May-2015 
     * Author      : Pallavi
     **********************************************************************************/
	public RegionDefault verifyPrintFormButtonIsDisplayed() throws Exception {
		objWaitForElement.waitForElementByxpathSelector(printForm);
		assertTrue(this.page.element(printForm, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify web notification having multiple message
	  * Date        : 20/1/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public RegionDefault verWebNotificationMultipleMsg(
			String strSubject, String strNotificationMsg) throws Exception {
		boolean bln;
		objWaitForElement.waitForElementBycssSelector("dt.othr");
		this.page.element("dt.othr", "css").getOne().isDisplayed();
		this.page.element("dd.desc", "css").getOne().isDisplayed();
		
		String str3 = this.page.element(
				"//dl/dt[@class='othr']","xpath").getOne().getText();
		String str4 = this.page.element(
				"//dl[2]/dt[@class='othr']","xpath").getOne().getText();
		if(str3.contains(strSubject)){
			bln = true;
		}else if (str4.contains(strSubject)) {
			bln = true;
		}		
		String str = this.page.element(
				"//dl/dd[@class='desc']","xpath").getOne().getText();
		String str2 = this.page.element(
				"//dl[2]/dd[@class='desc']","xpath").getOne().getText();
		if(str.contains(strNotificationMsg)){
			bln = true;
		}else if (str2.contains(strNotificationMsg)) {
			bln = true;
		}
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to veridy region name
	  * Date        : 30/Jun/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public RegionDefault verRegionName(String strRegionName, String strDomainName) throws Exception {
		objWaitForElement.waitForElements(regionName, "id");
		assertEquals(strRegionName+" ("+strDomainName+")", this.page.element(regionName, "id")
				.getOne().getText());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Update Status' is not displayed
	  * Date        : 09/06/2014
	  * Author      : Anil
	  **********************************************************************************/
	public RegionDefault verifyUpdateStatusPageNotDisplayed() throws Exception {
		assertFalse(this.page.element(updateStatus, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Status is Overdue' is displayed for resource
	  * Date        : 09/06/2014
	  * Author      : Anil
	  **********************************************************************************/
	public RegionDefault verifyResourceStatusOverDueStatus(String strResourceName) throws Exception {
		objWaitForElement.waitForElements("//h1[contains(text(),'"+strResourceName+"')]/span[text()='Status is Overdue']", "xpath");
		assertTrue(this.page.element("//h1[contains(text(),'"+strResourceName+"')]/span[text()='Status is Overdue']", "xpath").getOne().isDisplayed());
		return this;
	}
	
	/************************************************************************************************
	  * Description : This function is to select Question from 'Security Question and Answer' window
	  * Date		: 24/08/2015
	  * Author		: Sowmya
	  ***********************************************************************************************/
	public RegionDefault selectQuestionFromSecurityQuestnAndAnswerWin(
			String strQuestion) throws Exception {
		objWaitForElement.waitForElements(question, "css");
		this.page.element(question, "css").webElementToSelect()
				.selectByVisibleText(strQuestion);
		return this;
	}
	
	/************************************************************************************************
	  * Description : This function is to enter Answer in 'Security Question and Answer' window
	  * Date		: 24/08/2015
	  * Author		: Sowmya
	  ***********************************************************************************************/
	public RegionDefault enterAnswerInSecurityQuestnAndAnswerWin(
			String strAnswer) throws Exception {
		objWaitForElement.waitForElements(answer, "css");
		this.page.element(answer, "css").getOne().sendKeys(strAnswer);
		return this;
	}
	
	/************************************************************************************************
	  * Description : This function is to enter Email ID in 'Security Question and Answer' window
	  * Date		: 24/08/2015
	  * Author		: Sowmya
	  ***********************************************************************************************/
	public RegionDefault enterEmailInSecurityQuestnAndAnswerWin(String strEmail)
			throws Exception {
		objWaitForElement.waitForElements(email, "id");
		this.page.element(email, "id").clearInputValue().sendKeys(strEmail);
		return this;
	}
	
	/************************************************************************************************
	  * Description : This function is to click on Save button in 'Security Question and Answer' window
	  * Date		: 24/08/2015
	  * Author		: Sowmya
	  ***********************************************************************************************/
	public RegionDefault clkOnSaveBtnInSecurityQuestnAndAnswerWin()
			throws Exception {
		objWaitForElement.waitForElements(saveButton, "css");
		this.page.element(saveButton, "css").getOne().click();
		return this;
	}
	
	/************************************************************************************************
	  * Description : This function is to verify selected Question from 'Security Question and Answer' window
	  * Date		: 25/08/2015
	  * Author		: Sowmya
	  ***********************************************************************************************/
	public RegionDefault verSelectedQuestionFromSecurityQuestnAndAnswerWin(
			String strQuestion) throws Exception {
		objWaitForElement.waitForElements(question, "css");
		String strText = this.page.element(question, "css")
				.webElementToSelect().getFirstSelectedOption().getText();
		assertEquals(strQuestion, strText);
		return this;
	}
	
	/************************************************************************************************
	  * Description : This function is to verify entered Answer in 'Security Question and Answer' window
	  * Date		: 25/08/2015
	  * Author		: Sowmya
	  ***********************************************************************************************/
	public RegionDefault verEnteredAnswerInSecurityQuestnAndAnswerWin(
			String strAnswer) throws Exception {
		objWaitForElement.waitForElements(answer, "css");
		String strText = this.page.element(answer, "css").getOne().getAttribute("value");
		assertEquals(strAnswer, strText);
		return this;
	}
	
	/************************************************************************************************
	  * Description : This function is to verify entered Email ID in 'Security Question and Answer' window
	  * Date		: 25/08/2015
	  * Author		: Sowmya
	  ***********************************************************************************************/
	public RegionDefault verEnteredEmailInSecurityQuestnAndAnswerWin(
			String strEmail) throws Exception {
		objWaitForElement.waitForElements(email, "id");
		String strText = this.page.element(email, "id").getOne().getAttribute("value");
		assertEquals(strEmail, strText);
		return this;
	}
	
	/************************************************************************************************
	  * Description : This function is to click on Save button in 'Security Question and Answer' window
	  * Date		: 24/08/2015
	  * Author		: Sowmya
	  ***********************************************************************************************/
	public RegionDefault clkOnCancelBtnInSecurityQuestnAndAnswerWin()
			throws Exception {
		objWaitForElement.waitForElements(cancelButton, "css");
		this.page.element(cancelButton, "css").getOne().click();
		return this;
	}
	
  /************************************************************************************************
   * Description : This function is to click on Save button in 'Security Question and Answer' window
   * Date  : 24/08/2015
   * Author  : Anil
   ***********************************************************************************************/
	public String getETATime() throws Exception {
		String strETA = this.page
				.element(
						"//table//span[text()='ETA']/parent::td/following-sibling::td",
						"xpath").getOne().getText();
		System.out.println(strETA);
		return strETA;
	}

   /**********************************************************************************
   * Description : This function is to verify IPN web notification message
   * Date        : 10/10/2014
   * Author      : Anil
   **********************************************************************************/
	public RegionDefault verIncomingPatientNotificationMsgForOtherTime(
			String strSubject, String[] arrHeaderNames, String[] arrAnswers,
			String strArrivalTime) throws Exception {
		Thread.sleep(5000);
		objWaitForElement.waitForElementBycssSelector("dt.ipn");
		assertEquals(strSubject, this.page.element("dt.ipn", "css").getOne()
				.getText());

		for (int i = 0; i <= (arrHeaderNames.length - 1); i++) {
			assertTrue(
					this.page
							.element(
									"//table//td[text()='"
											+ arrHeaderNames[i]
											+ "']/following-sibling::td[contains(text(),'"
											+ arrAnswers[i] + "')]", "xpath")
							.isElementPresent(), arrHeaderNames[i] + " : "
							+ arrAnswers[i] + " is not present");
		}

		assertTrue((this.page.element(
				"//table//span[text()='ETA']/parent::td/following-sibling::td[text()='"
						+ strArrivalTime + "']", "xpath").isElementPresent()),
				"ETA : " + strArrivalTime + " is not present");

		return this;
	}
	 /**********************************************************************************
	  * Description : This function is to verify IPN web notification message
	  * Date        : 9/9/2015
	  * Author      : Sangappa.k
	  **********************************************************************************/
	public RegionDefault verIPNWebNotifaicationContent(String strSubject,
			String[] arrHeaderNames, String[] arrAnswers, String strArrivalTime,String strArrivalTime1)
			throws Exception {
		Thread.sleep(5000);
		objWaitForElement.waitForElementBycssSelector("dt.ipn");
		assertEquals(strSubject, this.page.element("dt.ipn", "css").getOne()
				.getText());

		for (int i = 0; i <= (arrHeaderNames.length - 1); i++) {
			assertTrue(
					this.page
							.element(
									"//table//td[text()='"
											+ arrHeaderNames[i]
											+ "']/following-sibling::td[contains(text(),'"
											+ arrAnswers[i] + "')]", "xpath")
							.isElementPresent(), arrHeaderNames[i] + " : "
							+ arrAnswers[i] + " is not present");
		}
		assertTrue(
				this.page.element(
						"//table//span[text()='ETA']/parent::td/following-sibling::td[text()='"
								+ strArrivalTime + "']", "xpath")
						.isElementPresent()||this.page.element(
								"//table//span[text()='ETA']/parent::td/following-sibling::td[text()='"
										+ strArrivalTime1 + "']", "xpath")
								.isElementPresent(), "ETA : " + strArrivalTime
						+ " is not present or "+strArrivalTime1+"is not present");

		return this;
	}
	
	 /*************************************************************************************************
	  * Description : This function is to verify IPN web notification not displayed
	  * Date        : 9/9/2015
	  * Author      : Sangappa.k
	  ************************************************************************************************/
	public RegionDefault verIPNWebNotificationIsNotDisplayed() throws Exception {
		objWaitForElement.waitForElements("dt.form", "css");
		objWaitForElement.waitForElementBycssSelector("dt.form");
		assertFalse(this.page.element("dt.form", "css").isElementPresent(WaitTimeConstants.WAIT_TIME_TOO_SMALL));
		return this;	
	
}
	
	 /***************************************************************
     * Description : This function is to click on Review Button.
     * Date        : 12/03/2014 
     * Author      : Sangappa.k
     **************************************************************/
	public RegionDefault clickReviewButtonOfIPN() throws Exception {
		objWaitForElement.waitForElementByxpathSelector(reviewButton);
		this.page.element(reviewButton, "xpath").getOne().click();
		return this;
	}
	
	
	/**********************************************************************************
	 * Description 	: This function is to verify snapshot window of event
	 * Date			: 16/10/2015 
	 * Author 		: Renushree
	 **********************************************************************************/
	public RegionDefault verSnapShotWinOfEvent(String strEventName,
			String strApplicationTime) throws Exception {
		objWaitForElement
				.waitForElementByxpathSelector("//h2[text()='" + strApplicationTime + "  " + strEventName
				+ "']");
		assertTrue(this.page.element(
				"//h2[text()='" + strApplicationTime + "  " + strEventName
				+ "']",
				"xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify snapshot window of event
	 * Date			: 04/03/2015 
	 * Author 		: Sangappa K
	 **********************************************************************************/
	public RegionDefault verEventSnapShotWindow(String strEventName,
			String strApplicationTime) throws Exception {
		String strEvent="//h2[text()='"+strApplicationTime+" "+strEventName+"']";
		System.out.println(strEvent);
		objWaitForElement
				.waitForElement(strEvent,"xpath");
		assertTrue(this.page.element(strEvent,"xpath").getOne().isDisplayed());
		return this;
	}
	
	   /**********************************************************************************
	  * Description : This function is to verify IPN web notification message
	  * Date        : 10/10/2014
	  * Author      : Rahul
	  **********************************************************************************/
	public RegionDefault verIncomingPatientNotificationMsgs(String strSubject,
			String[] arrHeaderNames, String[] arrAnswers,
			String strArrivalTime, String strArrivalTime1,
			String strArrivalTime2) throws Exception {
		Thread.sleep(5000);
		objWaitForElement.waitForElementBycssSelector("dt.ipn");
		assertEquals(strSubject, this.page.element("dt.ipn", "css").getOne()
				.getText());

		for (int i = 0; i <= (arrHeaderNames.length - 1); i++) {
			System.out.println(arrHeaderNames[i] + ", " + arrAnswers[i]);
			if (arrHeaderNames[i] != "ETA:") {
				assertTrue(this.page.element("//table//td[text()='"
												+ arrHeaderNames[i]
												+ "']/following-sibling::td[contains(text(),'"
												+ arrAnswers[i] + "')]","xpath").isElementPresent(),
						arrHeaderNames[i] + " : " + arrAnswers[i]
								+ " is not present");
			}
		}
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on 'Region' link
	  * Date        : 09/06/2014
	  * Author      : Anitha
	 **********************************************************************************/
	public RegionDefault clickOnAppSwitcher() throws Exception {
		objWaitForElement.waitForElements(appSwitcher, "xpath");
		this.page.element(appSwitcher, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on 'Region' link
	  * Date        : 09/06/2014
	  * Author      : Anitha
	 **********************************************************************************/
	public RegionDefault verifyAppSwitcherIsDisabled() throws Exception {
		assertFalse(this.page.element(appSwitcherLink, "linktext")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is used to form the Web notification for a single Question added
	 * Date 		: 25-Jan-2016
	 * Author 		: Pallavi
	 * *******************************************************************************/
	public String getWebNotificationForOneQuestionnaire(
			String strUserFullName, String strRegionName, String strLabelName1,
			String strLabelValue1) throws Exception {
		String strMsgBody = "Submitted by " + strUserFullName + "\n"
				+ "Region: " + strRegionName + "\n" + "Summary: | "
				+ strLabelName1 + ": " + strLabelValue1;
		System.out.println("Formed web notification:" + strMsgBody);
		return strMsgBody;
	}
	
	/**********************************************************************************
	 * Description 	: This function is used to form the Web notification for a two Questions added
	 * Date 		: 25-Jan-2016
	 * Author 		: Pallavi
	 * *******************************************************************************/
	public String getWebNotificationForTwoQuestionnaire(
			String strUserFullName, String strRegionName, String strLabelName1,
			String strLabelValue1, String strLabelName2,
			String strLabelValue2) throws Exception {
		String strMsgBody = "Submitted by " + strUserFullName + "\n"
				+ "Region: " + strRegionName + "\n" + "Summary: | "
				+ strLabelName1 + ": " + strLabelValue1
				+ "| " + strLabelName2 + ": " + strLabelValue2;
		System.out.println("Formed web notification:" + strMsgBody);
		return strMsgBody;
	}
	
	/**********************************************************************************
	 * Description 	: This function is used to form the Web notification for a two 
	 * 				  Questions added and completed form received by resource.
	 * Date 		: 25-Jan-2016
	 * Author 		: Pallavi
	 * *******************************************************************************/
	public String getWebNotificationForResourceWithOneQuest(
			String strUserFullName, String strResourceName,
			String strRegionName, String strLabelName1, String strLabelValue1) throws Exception {
		String strMsgBody = "Submitted by " + strUserFullName + " for "
				+ strResourceName + "\n" + "Region: " + strRegionName + "\n"
				+ "Summary: | " + strLabelName1 + ": " + strLabelValue1;
		System.out.println("Formed web notification:" + strMsgBody);
		return strMsgBody;
	}
	
	/**********************************************************************************
	 * Description 	: This function is used to form the Web notification for a two 
	 * 				  Questions added and completed form received by resource.
	 * Date 		: 25-Jan-2016
	 * Author 		: Pallavi
	 * *******************************************************************************/
	public String getWebNotificationForResourceWith2Quest(
			String strUserFullName, String strResourceName,
			String strRegionName, String strLabelName1, String strLabelValue1,
			String strLabelName2, String strLabelValue2) throws Exception {
		String strMsgBody = "Submitted by " + strUserFullName + " for "
				+ strResourceName + "\n" + "Region: " + strRegionName + "\n"
				+ "Summary: | " + strLabelName1 + ": " + strLabelValue1 + "| "
				+ strLabelName2 + ": " + strLabelValue2;
		System.out.println("Formed web notification:" + strMsgBody);
		return strMsgBody;
	}
	
	/**********************************************************************************
	 * Description 	: This function is used to form the Web notification for two
	 * 				  Questions added and verify read receipts
	 * Date 		: 25-Jan-2016
	 * Author 		: Pallavi
	 * *******************************************************************************/
	public String getWebNotificationForReadReceipts(String strUserFullName,
			String strRegion, String strLabelName1, String strLabelValue1,
			String strLabelName2, String strLabelValue2) throws Exception {
		String strMsgBody = "Acknowledged by " + strUserFullName + "\nRegion: "
				+ strRegion + "\nSummary: | " + strLabelName1 + ": "
				+ strLabelValue1 + "| " + strLabelName2 + ": " + strLabelValue2;
		System.out.println("Formed web notification:" + strMsgBody);
		return strMsgBody;
	}
	
	/**********************************************************************************
	 * Description 	: This function is used to form the Web notification for two
	 * 				  Questions added and verify read receipts
	 * Date 		: 25-Jan-2016
	 * Author 		: Pallavi
	 * *******************************************************************************/
	public String getWebNotificationForReadReceiptForResource(
			String strUserFullName, String strResourceName, String strRegion,
			String strLabelName1, String strLabelValue1, String strLabelName2,
			String strLabelValue2) throws Exception {
		String strMsgBody = "Acknowledged by " + strUserFullName + " for "
				+ strResourceName + "\nRegion: " + strRegion + "\nSummary: | " + strLabelName1 + ": "
				+ strLabelValue1 + "| " + strLabelName2 + ": " + strLabelValue2;
		System.out.println("Formed web notification:" + strMsgBody);
		return strMsgBody;
	}
	
	/**********************************************************************************
	 * Description 	: This function is used to form the Web notification to send the completed form
	 * Date 		: 27-Jan-2016
	 * Author 		: Pallavi
	 * *******************************************************************************/
	public String getNotificationToSendCompletedForm() throws Exception {
		String strMsgBody = "You need to send this completed form";
		System.out.println("Formed web notification:" + strMsgBody);
		return strMsgBody;
	}
	
	/**********************************************************************************
	 * Description 	: This function is used to form the Web notification for a  
	 * 				  Questions added and completed form received by resource.
	 * Date 		: 25-Jan-2016
	 * Author 		: Pallavi
	 * *******************************************************************************/
	public String getWebNotificationWhenResourceFillsForm(
			String strUserFullName, String strResourceName,
			String strRegionName, String strLabelName1, String strLabelValue1) throws Exception {
		String strMsgBody = "Submitted by " + strUserFullName + " at "
				+ strResourceName + "\n" + "Region: " + strRegionName + "\n"
				+ "Summary: | " + strLabelName1 + ": " + strLabelValue1;
		System.out.println("Formed web notification:" + strMsgBody);
		return strMsgBody;
	}
	
	/**********************************************************************************
	 * Description 	: This function is used to form the Web notification for FOUR Questions added
	 * Date 		: 28-Jan-2016
	 * Author 		: Pallavi
	 * *******************************************************************************/
	public String getWebNotificationForFourQuestionnaire(
			String strUserFullName, String strRegionName, String strLabelName1,
			String strLabelValue1, String strLabelName2, String strLabelValue2
			, String strLabelName3,
			String strLabelValue3, String strLabelName4, String strLabelValue4) throws Exception {
		String strMsgBody = "Submitted by " + strUserFullName + "\n"
				+ "Region: " + strRegionName + "\n" + "Summary: | "
				+ strLabelName1 + ": " + strLabelValue1
				+ "| " + strLabelName2 + ": " + strLabelValue2
				+ "| " + strLabelName3 + ": " + strLabelValue3
				+ "| " + strLabelName4 + ": " + strLabelValue4;
		System.out.println("Formed web notification:" + strMsgBody);
		return strMsgBody;
	}
	
	/**********************************************************************************
	 * Description 	: This function is used to form the Web notification for one
	 * 				  Question added and verify read receipts
	 * Date 		: 25-Jan-2016
	 * Author 		: Pallavi
	 * *******************************************************************************/
	public String getWebNotificationForReadReceipts(String strUserFullName,
			String strRegion, String strLabelName1, String strLabelValue1)
			throws Exception {
		String strMsgBody = "Acknowledged by " + strUserFullName + "\nRegion: "
				+ strRegion + "\nSummary: | " + strLabelName1 + ": "
				+ strLabelValue1;
		System.out.println("Formed web notification:" + strMsgBody);
		return strMsgBody;
	}
	
	/**********************************************************************************
	 * Description 	: This function is used to form the Web notification for two
	 * 				  Questions added and verify read receipts
	 * Date 		: 25-Jan-2016
	 * Author 		: Pallavi
	 * *******************************************************************************/
	public String getWebNotificationForReadReceiptForResource(
			String strUserFullName, String strResourceName, String strRegion,
			String strLabelName1, String strLabelValue1) throws Exception {
		String strMsgBody = "Acknowledged by " + strUserFullName + " for "
				+ strResourceName + "\nRegion: " + strRegion + "\nSummary: | "
				+ strLabelName1 + ": " + strLabelValue1;
		System.out.println("Formed web notification:" + strMsgBody);
		return strMsgBody;
	}
	
	/**********************************************************************************
	 * Description 	: This function is used to form the Web notification for FOUR Questions added
	 * Date 		: 28-Jan-2016
	 * Author 		: Pallavi
	 * *******************************************************************************/
	public String getWebNotificationForThreeQuestionnaire(
			String strUserFullName, String strRegionName, String strLabelName1,
			String strLabelValue1, String strLabelName2, String strLabelValue2
			, String strLabelName3,
			String strLabelValue3) throws Exception {
		String strMsgBody = "Submitted by " + strUserFullName + "\n"
				+ "Region: " + strRegionName + "\n" + "Summary: | "
				+ strLabelName1 + ": " + strLabelValue1
				+ "| " + strLabelName2 + ": " + strLabelValue2
				+ "| " + strLabelName3 + ": " + strLabelValue3;
		System.out.println("Formed web notification:" + strMsgBody);
		return strMsgBody;
	}
	
	/**********************************************************************************
	 * Description 	: This function is used to form the Web notification for a two 
	 * 				  Questions added and completed form received by resource.
	 * Date 		: 01-Feb-2016
	 * Author 		: Renushree
	 * *******************************************************************************/
	public String getWebNotificationWhenResourceFillsFormForTwoQuest(
			String strUserFullName, String strResourceName,
			String strRegionName, String strLabelName1, String strLabelValue1,
			String strLabelName2, String strLabelValue2) throws Exception {
		String strMsgBody = "Submitted by " + strUserFullName + " at "
				+ strResourceName + "\n" + "Region: " + strRegionName + "\n"
				+ "Summary: | " + strLabelName1 + ": " + strLabelValue1 + "| "
				+ strLabelName2 + ": " + strLabelValue2;
		System.out.println("Formed web notification:" + strMsgBody);
		return strMsgBody;
	}
	
	/**********************************************************************************
	 * Description 	: This function is used to form the Web notification Table questionnaire
	 * 					1 ROW 1 COLUMN
	 * Date 		: 03-Feb-2016
	 * Author 		: Pallavi
	 * *******************************************************************************/
	public String getWebNotificationForTable(String strUserFullName,
			String strRegionName, String strRowName1, String strColumnName1,
			String strValue1) throws Exception {
		String strMsgBody = "Submitted by " + strUserFullName + "\n"
				+ "Region: " + strRegionName + "\n" + "Summary: | "
				+ strRowName1 + ":" + strColumnName1 + ": " + strValue1;
		System.out.println("Formed web notification:" + strMsgBody);
		return strMsgBody;
	}
	
	/**********************************************************************************
	 * Description 	: This function is used to form the Web notification Table questionnaire
	 * 					2 ROWS 2 COLUMNS
	 * Date 		: 03-Feb-2016
	 * Author 		: Pallavi
	 * *******************************************************************************/
	public String getWebNotificationForTable(String strUserFullName,
			String strRegionName, String strRowName1, String strColumnName1,
			String strR1C1Value, String strColumnName2, String strR1C2Value,
			String strRowName2, String strR2C1Value, String strR2C2Value)
			throws Exception {
		String strMsgBody = "Submitted by " + strUserFullName + "\n"
				+ "Region: " + strRegionName + "\n" + "Summary: | "
				+ strRowName1 + ":" + strColumnName1 + ": " + strR1C1Value
				+ "| " + strRowName1 + ":" + strColumnName2 + ": " + strR1C2Value
				+ "| " + strRowName2 + ":" + strColumnName1 + ": " + strR2C1Value
				+ "| " + strRowName2 + ":" + strColumnName2 + ": " + strR2C2Value;
		System.out.println("Formed web notification:" + strMsgBody);
		return strMsgBody;
	}
	
	/**********************************************************************************
	 * Description 	: This function is used to form the Web notification Table questionnaire
	 * 					3 ROWS 2 COLUMNS
	 * Date 		: 03-Feb-2016
	 * Author 		: Pallavi
	 * *******************************************************************************/
	public String getWebNotificationForTable(String strUserFullName,
			String strRegionName, String strRowName1, String strColumnName1,
			String strR1C1Value, String strColumnName2, String strR1C2Value,
			String strRowName2, String strR2C1Value, String strR2C2Value, String strRowName3,
			String strR3C1Value, String strR3C2Value)
			throws Exception {
		String strMsgBody = "Submitted by " + strUserFullName + "\n"
				+ "Region: " + strRegionName + "\n" + "Summary: | "
				+ strRowName1 + ":" + strColumnName1 + ": " + strR1C1Value
				+ "| " + strRowName1 + ":" + strColumnName2 + ": " + strR1C2Value
				+ "| " + strRowName2 + ":" + strColumnName1 + ": " + strR2C1Value
				+ "| " + strRowName2 + ":" + strColumnName2 + ": " + strR2C2Value
				+ "| " + strRowName3 + ":" + strColumnName1 + ": " + strR3C1Value
				+ "| " + strRowName3 + ":" + strColumnName2 + ": " + strR3C2Value;
		System.out.println("Formed web notification:" + strMsgBody);
		return strMsgBody;
	}
	
	/**********************************************************************************
	 * Description 	: This function is used to form the Web notification Table questionnaire
	 * 					3 ROWS 5 COLUMNS
	 * Date 		: 03-Feb-2016
	 * Author 		: Pallavi
	 * *******************************************************************************/
	public String getWebNotificationForTable(String strUserFullName,
			String strRegionName, String strRowName1, String strRowName2,
			String strRowName3, String strColumnName1, String strColumnName2,
			String strColumnName3, String strColumnName4,
			String strColumnName5, String strR1C1Value, String strR1C2Value,
			String strR1C3Value, String strR1C4Value, String strR1C5Value,
			String strR2C1Value, String strR2C2Value, String strR2C3Value,
			String strR2C4Value, String strR2C5Value, String strR3C1Value,
			String strR3C2Value, String strR3C3Value, String strR3C4Value,
			String strR3C5Value) throws Exception {
		String strMsgBody = "Submitted by " + strUserFullName + "\n"
				+ "Region: " + strRegionName + "\n" + "Summary: | "
					   + strRowName1 + ":" + strColumnName1 + ": " + strR1C1Value
				+ "| " + strRowName1 + ":" + strColumnName2 + ": " + strR1C2Value
				+ "| " + strRowName1 + ":" + strColumnName3 + ": " + strR1C3Value
				+ "| " + strRowName1 + ":" + strColumnName4 + ": " + strR1C4Value
				+ "| " + strRowName1 + ":" + strColumnName5 + ": " + strR1C5Value
				+ "| " + strRowName2 + ":" + strColumnName1 + ": " + strR2C1Value
				+ "| " + strRowName2 + ":" + strColumnName2 + ": " + strR2C2Value
				+ "| " + strRowName2 + ":" + strColumnName3 + ": " + strR2C3Value
				+ "| " + strRowName2 + ":" + strColumnName4 + ": " + strR2C4Value
				+ "| " + strRowName2 + ":" + strColumnName5 + ": " + strR2C5Value
				+ "| " + strRowName3 + ":" + strColumnName1 + ": " + strR3C1Value
				+ "| " + strRowName3 + ":" + strColumnName2 + ": " + strR3C2Value
				+ "| " + strRowName3 + ":" + strColumnName3 + ": " + strR3C3Value
				+ "| " + strRowName3 + ":" + strColumnName4 + ": " + strR3C4Value
				+ "| " + strRowName3 + ":" + strColumnName5 + ": " + strR3C5Value;
		System.out.println("Formed web notification:" + strMsgBody);
		return strMsgBody;
	}
	
	/**********************************************************************************
	 * Description 	: This function is used to form the Web notification Table questionnaire
	 * 					3 ROWS 3 COLUMNS
	 * Date 		: 03-Feb-2016
	 * Author 		: Pallavi
	 * *******************************************************************************/
	public String getWebNotificationForTable(String strUserFullName,
			String strRegionName, String strRowName1, String strRowName2,
			String strRowName3, String strColumnName1, String strColumnName2,
			String strColumnName3, String strR1C1Value, String strR1C2Value,
			String strR1C3Value, String strR2C1Value, String strR2C2Value,
			String strR2C3Value, String strR3C1Value, String strR3C2Value,
			String strR3C3Value) throws Exception {
		String strMsgBody = "Submitted by " + strUserFullName + "\n"
				+ "Region: " + strRegionName + "\n" + "Summary: | "
					   + strRowName1 + ":" + strColumnName1 + ": " + strR1C1Value
				+ "| " + strRowName1 + ":" + strColumnName2 + ": " + strR1C2Value
				+ "| " + strRowName1 + ":" + strColumnName3 + ": " + strR1C3Value
				+ "| " + strRowName2 + ":" + strColumnName1 + ": " + strR2C1Value
				+ "| " + strRowName2 + ":" + strColumnName2 + ": " + strR2C2Value
				+ "| " + strRowName2 + ":" + strColumnName3 + ": " + strR2C3Value
				+ "| " + strRowName3 + ":" + strColumnName1 + ": " + strR3C1Value
				+ "| " + strRowName3 + ":" + strColumnName2 + ": " + strR3C2Value
				+ "| " + strRowName3 + ":" + strColumnName3 + ": " + strR3C3Value;
		System.out.println("Formed web notification:" + strMsgBody);
		return strMsgBody;
	}
	
	/**********************************************************************************
	 * Description 	: This function is used to form the Web notification for EIGHT Questions added
	 * Date 		: 03-Feb-2016
	 * Author 		: Pallavi
	 * *******************************************************************************/
	public String getWebNotificationForEightQuestionnaire(
			String strUserFullName, String strRegionName, String strLabelName1,
			String strLabelValue1, String strLabelName2, String strLabelValue2,
			String strLabelName3, String strLabelValue3, String strLabelName4,
			String strLabelValue4, String strLabelName5, String strLabelValue5,
			String strLabelName6, String strLabelValue6, String strLabelName7,
			String strLabelValue7, String strLabelName8, String strLabelValue8)
			throws Exception {
		String strMsgBody = "Submitted by " + strUserFullName + "\n"
				+ "Region: " + strRegionName + "\n" + "Summary: | "
				+ strLabelName1 + ": " + strLabelValue1
				+ "| " + strLabelName2 + ": " + strLabelValue2
				+ "| " + strLabelName3 + ": " + strLabelValue3
				+ "| " + strLabelName4 + ": " + strLabelValue4
				+ "| " + strLabelName5 + ": " + strLabelValue5
				+ "| " + strLabelName6 + ": " + strLabelValue6
				+ "| " + strLabelName7 + ": " + strLabelValue7
				+ "| " + strLabelName8 + ": " + strLabelValue8;
		System.out.println("Formed web notification:" + strMsgBody);
		return strMsgBody;
	}
	
	/**********************************************************************************
	 * Description 	: This function is used to form the Web notification for two
	 * 				  Questions added and verify read receipts
	 * Date 		: 4-Feb-2016
	 * Author 		: Pallavi
	 * *******************************************************************************/
	public String getWebNotificationForReadReceipts(String strUserFullName,
			String strRegion, String strLabelName1, String strLabelValue1,
			String strLabelName2, String strLabelValue2,
			String strLabelName3, String strLabelValue3,
			String strLabelName4, String strLabelValue4) throws Exception {
		String strMsgBody = "Acknowledged by " + strUserFullName + "\nRegion: "
				+ strRegion + "\nSummary: | " + strLabelName1 + ": "
				+ strLabelValue1 + "| " + strLabelName2 + ": " + strLabelValue2
				+ "| " + strLabelName3 + ": " + strLabelValue3
				+ "| " + strLabelName4 + ": " + strLabelValue4;
		System.out.println("Formed web notification:" + strMsgBody);
		return strMsgBody;
	}
	/**********************************************************************************
	 * Description 	: This function is Quick link Link at
	 * Date			: 08/02/2016 
	 * Author 		: Sangappa K
	 **********************************************************************************/
	public RegionDefault verQuickLink(String strTittlename) throws Exception {
		
		String strEvent="//div[@id='quickUserLinks-in']/a/img[@title='"+strTittlename+"'][@alt='"+strTittlename+"']";
		objWaitForElement
				.waitForElement(strEvent,"xpath");
		assertTrue(this.page.element(strEvent,"xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is Quick link Link at
	 * Date			: 08/02/2016 
	 * Author 		: Sangappa K
	 **********************************************************************************/
	public RegionDefault verQuickLinkNotDisplayed(String strTittlename) throws Exception {
		
		String strEvent = "//div[@id='quickUserLinks-in']/a/img[@title='"
				+ strTittlename + "'][@alt='" + strTittlename + "']";
		objWaitForElement.waitForElement(strEvent, "xpath");
		assertFalse(this.page.element(strEvent, "xpath").isElementPresent(
				WaitTimeConstants.WAIT_TIME_SMALL));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify IPN web notification message
	  * Date        : 9/9/2015
	  * Author      : Sangappa.k
	  **********************************************************************************/
	public RegionDefault verIPNWebNotifaication(String strSubject,
			String[] arrHeaderNames, String[] arrAnswers, String strArrivalTime,String strArrivalTime1)
			throws Exception {
		Thread.sleep(5000);
		objWaitForElement.waitForElementBycssSelector("dt.ipn");
		assertTrue(
				this.page.element(
						"//dt[@class='ipn'][text()='" + strSubject + "']",
						"xpath").isElementPresent(), " "+strSubject+" No headers match");
	  
		for (int i = 0; i <= (arrHeaderNames.length - 1); i++) {
			assertTrue(
					this.page
							.element(
									"//table//td[text()='"
											+ arrHeaderNames[i]
											+ "']/following-sibling::td[contains(text(),'"
											+ arrAnswers[i] + "')]", "xpath")
							.isElementPresent(), arrHeaderNames[i] + " : "
							+ arrAnswers[i] + " is not present");
		}
		assertTrue(
				this.page.element(
						"//table//span[text()='ETA']/parent::td/following-sibling::td[text()='"
								+ strArrivalTime + "']", "xpath")
						.isElementPresent()||this.page.element(
								"//table//span[text()='ETA']/parent::td/following-sibling::td[text()='"
										+ strArrivalTime1 + "']", "xpath")
								.isElementPresent(), "ETA : " + strArrivalTime
						+ " is not present or "+strArrivalTime1+"is not present");

		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify the 'EMResource Warning — Not Authorized' screen.
	  * Date        : 2-Mar-2016
	  * Author      : Pallavi
	  **********************************************************************************/
	public RegionDefault verNotAuthorizedScreenOnLogin() throws Exception {
		objWaitForElement.waitForElements(notAuthorizedHeader, "xpath");
		assertTrue(this.page.element(notAuthorizedHeader, "xpath")
				.isElementPresent());
		assertTrue(this.page.element(notAuthorizedHeader, "xpath").getOne()
				.isDisplayed());
		assertTrue(this.page.element(notAuthorized, "xpath").getOne()
				.isDisplayed());
		assertTrue(this.page
				.element(
						"//div[@class='emsLevel1']/b[text()='You are not authorized to perform this action.']",
						"xpath").isElementPresent());
		String strErrMsg = this.page
				.element("//div[@class='emsLevel2']", "xpath").getOne()
				.getText();
		assertTrue(strErrMsg.contains("All unauthorized access is logged."));
		assertTrue(strErrMsg
				.contains("If you feel you have reached this page in error, contact your"));
		assertTrue(this.page.element("//div[@class='emsLevel2']/a", "xpath")
				.getOne().getText().contains("regional administrator"));
		assertTrue(this.page
				.element(
						"//div[@class='emsLevel3']/a[text()='Click here to return to the status view.']",
						"xpath").getOne().isDisplayed());
		return this;
	}

		/**********************************************************************************
		 * Description 	: This function is verify web service account error is displayed
		 * Date			: 08/02/2016 
		 * Author 		: Anil
		 **********************************************************************************/
		public RegionDefault verifyWebServiceAccountError() throws Exception {		
			objWaitForElement.waitForElement(webServiceAccountError, "xpath");
			assertTrue(this.page.element(webServiceAccountError, "xpath").getOne().isDisplayed());
			return this;
		}
		
		/**********************************************************************************
		 * Description 	: This function is verify error Message
		 * Date			: 08/02/2016 
		 * Author 		: Anil
		 **********************************************************************************/
		public RegionDefault verifyErrorMessage() throws Exception {		
			objWaitForElement.waitForElement(errorMessage, "xpath");
			assertTrue(this.page.element(errorMessage, "xpath").getOne().isDisplayed());
			return this;
		}
		
		/**********************************************************************************
		 * Description 	: This function is click on click here link
		 * Date			: 08/02/2016 
		 * Author 		: Anil
		 **********************************************************************************/
		public RegionDefault clickOnClickHereLink() throws Exception {		
			objWaitForElement.waitForElement(clickHereLink, "xpath");
			this.page.element(clickHereLink, "xpath").getOne().click();
			return this;
		}
		

		/**********************************************************************************
		 * Description 	: This function is click on click here link
		 * Date			: 08/02/2016 
		 * Author 		: Sangappa
		 **********************************************************************************/
	public RegionDefault verSecurityQuationPageNotDispalyed() throws Exception {

		assertFalse(
				this.page.element(seurityPage, "xpath").isElementPresent(
						WaitTimeConstants.WAIT_TIME_FOR_FALSE),
				"security page is displayed");

		return this;

	}

}
	