package lib.page;

import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;

import lib.module.LinksAtTopRightCorners;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import qaframework.lib.WaitTimeConstants;
import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;

public class UpdateStatus extends PageObject {

	WebDriver driver;
	WaitForElement objWaitForElement ;
	EventManagement objEventManagement;
	LinksAtTopRightCorners objLinksAtTopRightCorners;
	
	// Locators
	private String saveButton = "input[value='Save']",
			       selectAll = "//span[@id='selectAll']/b",
			       acknowlwdgeNotification = "//button[text()='Acknowledge All Notifications']",
			       strFrame = "Data",
			       calculate = "input[value='Calculate']",
			       header = "div#topSubNav > h1",
			       errortext1="//span[@class='emsErrorTitle']",
			       errortext2="//div[@align='center']/ul[1]",
			       pastdate ="//div[@id='mainContainer']/div[3]",
			       resuiredText = "//span[@class='emsText IndicatesRequiredText']",
			       remindMeIn10Min = "input[value='Remind me in 10 minutes']",
			       showAllStatuses = "//span/b[text()='Show All Statuses']",
			       cancelButton = "input[value='Cancel']",
			       nEDOCSHelpDocLink = "//div[@class='formElemLong']/a[text()='NEDOCS Help Document']",
			       emResourceHelpLink = "//a[@class='whtbtnshow'][text()='EMResource Help']",
				   selectAll1 = "//div[@class='left']/span[@id='selectAll']/b",
				   showAllStatuses1 = "//div[@class='left']/span[@class='selectionLink showAll']",
				   clearAll = "//div[@class='left']/span[@id='clearAll']/b",
				   updatedValueDisplayInGreen = "color: rgb(0, 153, 0)";

	public UpdateStatus(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
		objEventManagement = new EventManagement(this.driver);
		objLinksAtTopRightCorners = new LinksAtTopRightCorners(this.driver);
	}

	/**********************************************************************************
	 * Description : This function is to click on status type Date : 08/07/2014
	 * Author : Anil
	 **********************************************************************************/
	public UpdateStatus clickOnStatusType(String strStatusTypeValue)
			throws Exception {
		objWaitForElement.waitForElements("#st_" + strStatusTypeValue, "css");
		this.page.element("#st_" + strStatusTypeValue, "css").mouseOver();
		Thread.sleep(1000);
		this.page.element("#st_" + strStatusTypeValue, "css").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to update Number and Text status type Date
	 * : 08/07/2014 Author : Anil
	 **********************************************************************************/
	public UpdateStatus enterNSTAndTSTUpdateValue(String strStatusTypeValue,
			String strUpdateValue) throws Exception {
		objWaitForElement.waitForElements("status_value_" + strStatusTypeValue, "name");
		this.page.element("status_value_" + strStatusTypeValue, "name")
				.clearInputValue().sendKeys(strUpdateValue);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to update Number and Text status type Date
	 * : 08/07/2014 Author : Anil
	 **********************************************************************************/
	public UpdateStatus enterUpdateSSTValues(String strStatusTypeValue,
			String[] strUpdateValue) throws Exception {
		this.enterEdBedsOccupied(strStatusTypeValue, strUpdateValue[0]);
		this.enterlobbyPatients(strStatusTypeValue, strUpdateValue[1]);
		this.enterambulancePatients(strStatusTypeValue, strUpdateValue[2]);
		this.enteradmitsGeneral(strStatusTypeValue, strUpdateValue[3]);
		this.enteradmitsIcu(strStatusTypeValue, strUpdateValue[4]);
		this.enteroneOnOnePatients(strStatusTypeValue, strUpdateValue[5]);
		this.entershortStaffRn(strStatusTypeValue, strUpdateValue[6]);
		this.enterEdBedsAssigned(strStatusTypeValue, strUpdateValue[7]);
		this.enterlobbyCapacity(strStatusTypeValue, strUpdateValue[8]);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to update SST ED beds occupied Date :
	 * 08/07/2014 Author : Anil
	 **********************************************************************************/
	public UpdateStatus enterEdBedsOccupied(String strStatusTypeValue,
			String strUpdateValue) throws Exception {
		objWaitForElement.waitForElements("#edBedsOccupied" + strStatusTypeValue, "css");
		this.page.element("#edBedsOccupied" + strStatusTypeValue, "css")
				.clearInputValue().sendKeys(strUpdateValue);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to update SST lobby beds Date : 08/07/2014
	 * Author : Anil
	 **********************************************************************************/
	public UpdateStatus enterlobbyPatients(String strStatusTypeValue,
			String strUpdateValue) throws Exception {
		objWaitForElement.waitForElements("#lobbyPatients" + strStatusTypeValue, "css");
		this.page.element("#lobbyPatients" + strStatusTypeValue, "css")
				.clearInputValue().sendKeys(strUpdateValue);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to update SST ambulance patients Date :
	 * 08/07/2014 Author : Anil
	 **********************************************************************************/
	public UpdateStatus enterambulancePatients(String strStatusTypeValue,
			String strUpdateValue) throws Exception {
		objWaitForElement.waitForElements("#ambulancePatients" + strStatusTypeValue, "css");
		this.page.element("#ambulancePatients" + strStatusTypeValue, "css")
				.clearInputValue().sendKeys(strUpdateValue);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to update SST admit general Date :
	 * 08/07/2014 Author : Anil
	 **********************************************************************************/
	public UpdateStatus enteradmitsGeneral(String strStatusTypeValue,
			String strUpdateValue) throws Exception {
		objWaitForElement.waitForElements("#admitsGeneral" + strStatusTypeValue, "css");
		this.page.element("#admitsGeneral" + strStatusTypeValue, "css")
				.clearInputValue().sendKeys(strUpdateValue);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to update SST admit ICU Date : 08/07/2014
	 * Author : Anil
	 **********************************************************************************/
	public UpdateStatus enteradmitsIcu(String strStatusTypeValue,
			String strUpdateValue) throws Exception {
		objWaitForElement.waitForElements("#admitsIcu" + strStatusTypeValue, "css");
		this.page.element("#admitsIcu" + strStatusTypeValue, "css")
				.clearInputValue().sendKeys(strUpdateValue);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to update SST one to one patients Date :
	 * 08/07/2014 Author : Anil
	 **********************************************************************************/
	public UpdateStatus enteroneOnOnePatients(String strStatusTypeValue,
			String strUpdateValue) throws Exception {
		objWaitForElement.waitForElements("#oneOnOnePatients" + strStatusTypeValue, "css");
		this.page.element("#oneOnOnePatients" + strStatusTypeValue, "css")
				.clearInputValue().sendKeys(strUpdateValue);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to update SST Short Staff Date :
	 * 08/07/2014 Author : Anil
	 **********************************************************************************/
	public UpdateStatus entershortStaffRn(String strStatusTypeValue,
			String strUpdateValue) throws Exception {
		objWaitForElement.waitForElements("#shortStaffRn" + strStatusTypeValue, "css");
		this.page.element("#shortStaffRn" + strStatusTypeValue, "css")
				.clearInputValue().sendKeys(strUpdateValue);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to update SST ED beds assigned Date :
	 * 08/07/2014 Author : Anil
	 **********************************************************************************/
	public UpdateStatus enterEdBedsAssigned(String strStatusTypeValue,
			String strUpdateValue) throws Exception {
		objWaitForElement.waitForElements("#edBedsAssigned" + strStatusTypeValue, "css");
		this.page.element("#edBedsAssigned" + strStatusTypeValue, "css")
				.clearInputValue().sendKeys(strUpdateValue);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to update SST Lobby capacity Date :
	 * 08/07/2014 Author : Anil
	 **********************************************************************************/
	public UpdateStatus enterlobbyCapacity(String strStatusTypeValue,
			String strUpdateValue) throws Exception {
		objWaitForElement.waitForElements("#lobbyCapacity" + strStatusTypeValue, "css");
		this.page.element("#lobbyCapacity" + strStatusTypeValue, "css")
				.clearInputValue().sendKeys(strUpdateValue);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to update SST Lobby capacity Date :
	 * 08/07/2014 Author : Anil
	 **********************************************************************************/
	public UpdateStatus enterNedocsUpdateValue(String strStatusTypeValue,
			String[] strUpdateValue) throws Exception {
		// Enter the values for fields

		this.enterEdPatients(strStatusTypeValue, strUpdateValue[0]);
		this.enterEdAdmits(strStatusTypeValue, strUpdateValue[1]);
		this.enterlastDoorToBedTime(strStatusTypeValue, strUpdateValue[2]);
		this.entercriticalCarePatients(strStatusTypeValue, strUpdateValue[3]);
		this.enterlongestEdAdmit(strStatusTypeValue, strUpdateValue[4]);
		this.enterEdNumber(strStatusTypeValue, strUpdateValue[5]);
		this.enterIpNumber(strStatusTypeValue, strUpdateValue[6]);

		return this;
	}

	/**********************************************************************************
	 * Description : This function is to update Nedocs Ed Patients Date :
	 * 08/07/2014 Author : Anil
	 **********************************************************************************/
	public UpdateStatus enterEdPatients(String strStatusTypeValue,
			String strUpdateValue) throws Exception {
		objWaitForElement.waitForElements("#edPatients" + strStatusTypeValue, "css");
		this.page.element("#edPatients" + strStatusTypeValue, "css")
				.clearInputValue().sendKeys(strUpdateValue);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to update Nedocs Ed Admits Date :
	 * 08/07/2014 Author : Anil
	 **********************************************************************************/
	public UpdateStatus enterEdAdmits(String strStatusTypeValue,
			String strUpdateValue) throws Exception {
		objWaitForElement.waitForElements("#edAdmits" + strStatusTypeValue, "css");
		this.page.element("#edAdmits" + strStatusTypeValue, "css")
				.clearInputValue().sendKeys(strUpdateValue);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to update Nedocs last door to bed time
	 * Date : 08/07/2014 Author : Anil
	 **********************************************************************************/
	public UpdateStatus enterlastDoorToBedTime(String strStatusTypeValue,
			String strUpdateValue) throws Exception {
		objWaitForElement.waitForElements("#lastDoorToBedTime" + strStatusTypeValue, "css");
		this.page.element("#lastDoorToBedTime" + strStatusTypeValue, "css")
				.clearInputValue().sendKeys(strUpdateValue);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to update Nedocs critical Care Patients
	 * Date : 08/07/2014 Author : Anil
	 **********************************************************************************/
	public UpdateStatus entercriticalCarePatients(String strStatusTypeValue,
			String strUpdateValue) throws Exception {
		this.page.element("#criticalCarePatients" + strStatusTypeValue, "css")
				.clearInputValue().sendKeys(strUpdateValue);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to update Nedocs longest Ed Admit Date :
	 * 08/07/2014 Author : Anil
	 **********************************************************************************/
	public UpdateStatus enterlongestEdAdmit(String strStatusTypeValue,
			String strUpdateValue) throws Exception {
		objWaitForElement.waitForElements("#longestEdAdmit" + strStatusTypeValue, "css");
		this.page.element("#longestEdAdmit" + strStatusTypeValue, "css")
				.clearInputValue().sendKeys(strUpdateValue);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to update Nedocs Ed Number Date :
	 * 08/07/2014 Author : Anil
	 **********************************************************************************/
	public UpdateStatus enterEdNumber(String strStatusTypeValue,
			String strUpdateValue) throws Exception {
		objWaitForElement.waitForElements("#edNumber" + strStatusTypeValue, "css");
		this.page.element("#edNumber" + strStatusTypeValue, "css")
				.clearInputValue().sendKeys(strUpdateValue);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to update Nedocs ipNumber Date :
	 * 08/07/2014 Author : Anil
	 **********************************************************************************/
	public UpdateStatus enterIpNumber(String strStatusTypeValue,
			String strUpdateValue) throws Exception {
		objWaitForElement.waitForElements("#ipNumber" + strStatusTypeValue, "css");
		this.page.element("#ipNumber" + strStatusTypeValue, "css")
				.clearInputValue().sendKeys(strUpdateValue);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to update Multi status type :
	 * 08/07/2014 Author : Anil
	 **********************************************************************************/
	public UpdateStatus selectMSTUpdateValue(String strStatusTypeValue,
			String strUpdateValue) throws Exception {
		objWaitForElement.waitForElements("input[value='" + strUpdateValue
				+ "'][name='status_value_" + strStatusTypeValue
				+ "']", "css");
		this.page
				.element(
						"input[value='" + strUpdateValue
								+ "'][name='status_value_" + strStatusTypeValue
								+ "']", "css").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on save button Date : 08/07/2014
	 * Author : Anil
	 **********************************************************************************/
	public UpdateStatus clickOnSaveButton() throws Exception {
		objWaitForElement.waitForElements(saveButton, "css");
		this.page.element(saveButton, "css").getOne().click();
		Thread.sleep(5000);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify the updated value of ststua types.
	  * Arguments	: strResourceValue, strStatusTypeValue, strUpdatedValue
	  * Date        : 03/09/2014
	  * Author      : Renushree
	  **********************************************************************************/	
	public UpdateStatus verifyUpdatedStatusValues(String strResourceValue,
			String strStatusTypeValue, String strUpdatedValue) throws Exception {
		objWaitForElement.waitForElements("//td[@id='v_" + strResourceValue + "_"
				+ strStatusTypeValue + "'][text()='"
				+ strUpdatedValue + "']", "xpath");
		assertTrue(
				this.page.element(
						"//td[@id='v_" + strResourceValue + "_"
								+ strStatusTypeValue + "'][text()='"
								+ strUpdatedValue + "']", "xpath")
						.isElementPresent(), "Updated values are not displayed");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on 'Select All' link
	  * Date        : 12/09/2014
	  * Author      : Sowmya
	  **********************************************************************************/	
	public UpdateStatus clickOnSelectAll() throws Exception {
		objWaitForElement.waitForElements(selectAll, "xpath");
		this.page.element(selectAll, "xpath").getOne().click();
		Thread.sleep(2000);
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to select status reason.
	 * Date 		: 15/09/2014 
	 * Author 		: Renushree
	 **********************************************************************************/
	public UpdateStatus selectMSTReasonValue(String strReasonValValue,
			String strStatusTypeVal, String strStatusVal) throws Exception {
		Thread.sleep(3000);
		objWaitForElement.waitForElements("input[value='" + strReasonValValue
				+ "'][name='status_reason_id_"
				+ strStatusTypeVal + "_" + strStatusVal + "']",
		"css");
		this.page
				.element(
						"input[value='" + strReasonValValue
								+ "'][name='status_reason_id_"
								+ strStatusTypeVal + "_" + strStatusVal + "']",
						"css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to select status types
	 * Date 		: 15/09/2014 
	 * Author 		: Renushree
	 **********************************************************************************/
	public UpdateStatus selectStatusTypes(String strStatusTypeValue) throws Exception {
		objWaitForElement.waitForElements("input[value='" + strStatusTypeValue
				+ "']", "css");
		this.page
		.element(
				"input[value='" + strStatusTypeValue
						+ "']", "css").mouseOver();
		this.page
				.element(
						"input[value='" + strStatusTypeValue
								+ "']", "css").getOne().click();
		Thread.sleep(1000);
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify web notification frame Banner
	 * Date 		: 23/09/2014 
	 * Author 		: Renushree
	 **********************************************************************************/
	public UpdateStatus verWebNotificationframe() throws Exception {
		WebDriverWait wait = new WebDriverWait(this.driver,
				WaitTimeConstants.WAIT_TIME_LONG);
		wait.until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt("TB_iframeContent"));
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify web notification for the status types which set above and below values notificaion refernces. 
	 * Date			: 23/09/2014 
	 * Author 		: Renushree
	 **********************************************************************************/
	public UpdateStatus verWebNotificationForStatusUpdateOfAboveAndBeowValForSubRes(
			String strResourceName, String strSubResName,
			String strStatusTypeName, String strUpdatedVal,
			String strUpdatedDateAndTime) throws Exception {
		objWaitForElement.waitForElements("dt.othr", "css");	
		assertEquals("Status Change for " + strResourceName + ": "
				+ strSubResName + "", this.page.element("dt.othr", "css")
				.getOne().getText());
		assertTrue(this.page
				.element(
						"//dl/dd[@class='desc'][text()='On "
								+ strUpdatedDateAndTime + " " + strResourceName
								+ ": " + strSubResName + " changed "
								+ strStatusTypeName + " status from 0 to "
								+ strUpdatedVal + ".']", "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify web notification for the status types which set above and below values notificaion refernces. 
	 * Date			: 23/09/2014 
	 * Author 		: Renushree
	 **********************************************************************************/
	public UpdateStatus verWebNotificationForStatusUpdate(
			String strResourceName, String strStatusTypeName,
			String strUpdatedVal, String strUpdatedDateAndTime)
			throws Exception {
		objWaitForElement.waitForElements("dt.othr", "css");
		assertEquals("Status Change for " + strResourceName + "", this.page
				.element("dt.othr", "css").getOne().getText());
		assertTrue(this.page.element(
				"//dl/dd[@class='desc'][text()='On " + strUpdatedDateAndTime
						+ "  changed " + strStatusTypeName
						+ " status from -- to " + strUpdatedVal + ".']",
				"xpath").isElementPresent());

		return this;
	}

	/**********************************************************************************
	 * Description 	: This function is to click on acknowledge nootification 
	 * Date			: 23/09/2014 
	 * Author 		: Renushree
	 **********************************************************************************/
	public UpdateStatus clickAcknowledgeAllNotifications() throws Exception {
		objWaitForElement.waitForElements(acknowlwdgeNotification, "xpath");
		this.page.element(acknowlwdgeNotification, "xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description 	: This function is to click on acknowledge nootification 
	 * Date			: 23/09/2014 
	 * Author 		: Renushree
	 **********************************************************************************/
	public UpdateStatus selectFrame() throws Exception {
		driver.switchTo().window("");
		WebDriverWait wait = new WebDriverWait(this.driver,
				WaitTimeConstants.WAIT_TIME_LONG);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(strFrame));
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify error if date is entered out of given date range
	 * Date			: 07/11/2014 
	 * Author 		: Renushree
	 **********************************************************************************/
	public UpdateStatus verErrorIfDateIsOutOfGivenRange(String strDateFrom , String strDateTo, String strDateStatusType) throws Exception {
		objWaitForElement.waitForElements("//span[@class='emsErrorTitle'][text()='The following error occurred on this page:']",
				"xpath");
		assertTrue(this.page
				.element(
						"//span[@class='emsErrorTitle'][text()='The following error occurred on this page:']",
						"xpath").isElementPresent());
		assertEquals("Date must be between "+strDateFrom+" and "+strDateTo+" for \'"+strDateStatusType+"\'.", this.page
				.element(
						"//div[@id='mainContainer']/div[3]/ul/li","xpath").getOne().getText());
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to click on calculate
	 * Date			: 23/09/2014 
	 * Author 		: Renushree
	 **********************************************************************************/
	public UpdateStatus clickOnCalculate() throws Exception {
		objWaitForElement.waitForElements(calculate, "css");
		this.page.element(calculate, "css").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description 	: This function is to verify update status page
	 * Date			: 20/11/2014 
	 * Author 		: Renushree
	 **********************************************************************************/
	public UpdateStatus verUpdateStatusPge() throws Exception {
		objWaitForElement.waitForElements("//div[@id='topSubNav']/h1[text()='Update Status']", "xpath");
		assertTrue(this.page.element("//div[@id='topSubNav']/h1[text()='Update Status']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify Error text when enter the past date in 
	                 date status types
	 * Date			: 4-Dec-2014 
	 * Author 		: sangappa.k
	 **********************************************************************************/
	public UpdateStatus verErrorTextForPastDate(String StatusTypename)
			throws Exception {
		objWaitForElement.waitForElements(pastdate, "xpath");
		assertEquals("The following error occurred on this page:", this.page
				.element(errortext1, "xpath").getOne().getText());
		String str = this.page.element(errortext2, "xpath").getOne().getText();
		System.out.println(str);
		assertEquals("Please enter a date in past for '" + StatusTypename
				+ "'.", this.page.element(errortext2, "xpath")

		.getOne().getText());
		return this;
	}
	/**********************************************************************************
	 * Description 	: This function is to verify status value after event ended
	 * Date			: 03-Feb-2015 
	 * Author 		: Hanumegowda
	 **********************************************************************************/
	public UpdateStatus verifyUpdatedStatusValues1(String strResourceValue,
			String strStatusTypeValue) throws Exception {
		objWaitForElement.waitForElements("//td[@id='v_" + strResourceValue + "_"
				+ strStatusTypeValue + "'][text()='--']", "xpath");
		assertTrue(
				this.page.element(
						"//td[@id='v_" + strResourceValue + "_"
								+ strStatusTypeValue + "'][text()='--']", "xpath")
						.isElementPresent(), "Updated values are not displayed");
		return this;
	}
	/**********************************************************************************
	 * Description 	: This function is to verify validate message when we attempt to edit status when event ended
	 * Date			: 06-Feb-2015 
	 * Author 		: Hanumegowda
	 **********************************************************************************/
	public UpdateStatus verifyValidateMessage() throws Exception {
		objWaitForElement.waitForElements("//span[text()='The following status types were not updated because "
				+ "the associated event has ended:']","xpath");
		assertTrue(this.page.element("//span[text()='The following status types were not updated because "
				+ "the associated event has ended:']","xpath").isElementPresent(),"Message Displayed");
		Thread.sleep(5000);
		this.page.element("//input[@value='OK']", "xpath").getOne().click();
		return this;
	}
		
	/**********************************************************************************
	 * Description : This function is to enter comments
	 * : 08/07/2014 Author : Anil
	 **********************************************************************************/
	public UpdateStatus enterComments(String strStatusTypeValue,
			String strComments) throws Exception {
		objWaitForElement.waitForElements("comment_" + strStatusTypeValue, "name");
		this.page.element("comment_" + strStatusTypeValue, "name")
				.clearInputValue().sendKeys(strComments);
		return this;
	}
		
	/**********************************************************************************
	  * Description : This function is to verify instruction for trace user
	  * Arguments	: strStatusValue
	  * Date        : 18/May/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public UpdateStatus verInstructionForTraceUser(String strStatusValue)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='st_" + strStatusValue
				+ "section']/span", "xpath");
		assertEquals(
				"Please note: You must enter your name and password below, when changing this status",
				this.page
						.element(
								"//div[@id='st_" + strStatusValue
										+ "section']/span", "xpath").getOne()
						.getText());
		return this;
	}
		
	/**********************************************************************************
	  * Description : This function is to verify user verification message for trace user
	  * Date        : 18/May/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public UpdateStatus verUserVerificationForTraceUser()
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='userVerification']/div/h1", "xpath");
		assertEquals(
				"User Verification *required to complete edits",
				this.page
						.element(
								"//div[@id='userVerification']/div/h1", "xpath").getOne()
						.getText());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter value in your name field
	  * Arguments	: strUserName
	  * Date        : 18/May/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public UpdateStatus enterValInYourNameField(String strUserName)
			throws Exception {
		objWaitForElement.waitForElements(
				"//div[@id='userVerificationpass']/input[@name='trace']",
				"xpath");
		assertTrue(this.page.element(
				"//div[@id='userVerificationpass']/input[@name='trace']",
				"xpath").isElementPresent());
		this.page
				.element(
						"//div[@id='userVerificationpass']/input[@name='trace']",
						"xpath").clearInputValue().sendKeys(strUserName);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter value in your name field
	  * Arguments	: strUserName
	  * Date        : 18/May/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public UpdateStatus enterValInPasswordField(String strPassword)
			throws Exception {
		objWaitForElement.waitForElements(
				"//div[@id='userVerificationpass']/input[@name='password']",
				"xpath");
		assertTrue(this.page.element(
				"//div[@id='userVerificationpass']/input[@name='password']",
				"xpath").isElementPresent());
		this.page
				.element(
						"//div[@id='userVerificationpass']/input[@name='password']",
						"xpath").clearInputValue().sendKeys(strPassword);
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify error when name and password not entered
	 * Date			: 18/May/2015 
	 * Author 		: Renushree
	 **********************************************************************************/
	public UpdateStatus verErrorWhenNameAndPwdNotGiven() throws Exception {
		objWaitForElement
				.waitForElements(
						"//span[@class='emsErrorTitle'][text()='The following error occurred on this page:']",
						"xpath");
		assertTrue(this.page
				.element(
						"//span[@class='emsErrorTitle'][text()='The following error occurred on this page:']",
						"xpath").isElementPresent());
		assertEquals(
				"Name and password are required.",
				this.page
						.element("//div[@id='mainContainer']/div[3]/ul/li",
								"xpath").getOne().getText());
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify error when name and password not entered
	 * Date			: 18/May/2015 
	 * Author 		: Renushree
	 **********************************************************************************/
	public UpdateStatus verErrorWhenWrongPwdEntered() throws Exception {
		assertTrue(this.page
				.element(
						"//span[@class='emsErrorTitle'][text()='The following error occurred on this page:']",
						"xpath").isElementPresent());
		objWaitForElement
		.waitForElements(
				"//div[@id='mainContainer']/div[3]/ul/li[text()='Incorrect password.']",
				"xpath");
		assertEquals(
				"Incorrect password.",
				this.page
						.element("//div[@id='mainContainer']/div[3]/ul/li",
								"xpath").getOne().getText());
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify entered MST value is retained
	 * Arguments	: strStatusTypeValue, strUpdateValue
	 * Date			: 18/May/2015 
	 * Author 		: Renushree
	 **********************************************************************************/
	public UpdateStatus verMSTUpdateValueRetained(String strStatusTypeValue,
			String strUpdateValue) throws Exception {
		assertTrue(this.page
				.element(
						"input[value='" + strUpdateValue
								+ "'][name='status_value_" + strStatusTypeValue
								+ "']", "css").getOne().isSelected());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to update Number and Text status type value is retained
	 * Date		   : 08/07/2014 
	 * Author	   : Anil
	 **********************************************************************************/
	public UpdateStatus enterNSTAndTSTUpdateValueISRetained(
			String strStatusTypeValue, String strUpdateValue) throws Exception {
		objWaitForElement.waitForElements("status_value_" + strStatusTypeValue,
				"name");
		String strValue = this.page
				.element("status_value_" + strStatusTypeValue, "name").getOne()
				.getAttribute("value");
		assertEquals(strValue, strUpdateValue);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to update Number and Text status type Date
	 * : 08/07/2014 Author : Anil
	 **********************************************************************************/
	public UpdateStatus verifyUpdatedSSTValues(String strStatusTypeValue,
			String[] strUpdateValue) throws Exception {
		this.verifyEnterEdBedsOccupied(strStatusTypeValue, strUpdateValue[0]);
		this.verifyEnterlobbyPatients(strStatusTypeValue, strUpdateValue[1]);
		this.verifyEnterambulancePatients(strStatusTypeValue, strUpdateValue[2]);
		this.verifyEnteradmitsGeneral(strStatusTypeValue, strUpdateValue[3]);
		this.verifyEnteradmitsIcu(strStatusTypeValue, strUpdateValue[4]);
		this.verifyEnteroneOnOnePatients(strStatusTypeValue, strUpdateValue[5]);
		this.verifyEntershortStaffRn(strStatusTypeValue, strUpdateValue[6]);
		this.verifyEnterEdBedsAssigned(strStatusTypeValue, strUpdateValue[7]);
		this.verifyEnterlobbyCapacity(strStatusTypeValue, strUpdateValue[8]);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to update SST ED beds occupied Date :
	 * 08/07/2014 Author : Anil
	 **********************************************************************************/
	public UpdateStatus verifyEnterEdBedsOccupied(String strStatusTypeValue,
			String strUpdateValue) throws Exception {
		objWaitForElement.waitForElements("#edBedsOccupied" + strStatusTypeValue, "css");
		String strValue = this.page.element("#edBedsOccupied" + strStatusTypeValue, "css").getOne().getAttribute("value");
		assertEquals(strValue, strUpdateValue);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to update SST lobby beds Date : 08/07/2014
	 * Author : Anil
	 **********************************************************************************/
	public UpdateStatus verifyEnterlobbyPatients(String strStatusTypeValue,
			String strUpdateValue) throws Exception {		
		objWaitForElement.waitForElements("#lobbyPatients" + strStatusTypeValue, "css");
		String strValue = this.page.element("#lobbyPatients" + strStatusTypeValue, "css").getOne().getAttribute("value");
		assertEquals(strValue, strUpdateValue);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to update SST ambulance patients Date :
	 * 08/07/2014 Author : Anil
	 **********************************************************************************/
	public UpdateStatus verifyEnterambulancePatients(String strStatusTypeValue,
			String strUpdateValue) throws Exception {
		objWaitForElement.waitForElements("#ambulancePatients" + strStatusTypeValue, "css");
		String strValue = this.page.element("#ambulancePatients" + strStatusTypeValue, "css").getOne().getAttribute("value");
		assertEquals(strValue, strUpdateValue);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to update SST admit general Date :
	 * 08/07/2014 Author : Anil
	 **********************************************************************************/
	public UpdateStatus verifyEnteradmitsGeneral(String strStatusTypeValue,
			String strUpdateValue) throws Exception {
		objWaitForElement.waitForElements("#admitsGeneral" + strStatusTypeValue, "css");
		String strValue = this.page.element("#admitsGeneral" + strStatusTypeValue, "css").getOne().getAttribute("value");
		assertEquals(strValue, strUpdateValue);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to update SST admit ICU Date : 08/07/2014
	 * Author : Anil
	 **********************************************************************************/
	public UpdateStatus verifyEnteradmitsIcu(String strStatusTypeValue,
			String strUpdateValue) throws Exception {
		objWaitForElement.waitForElements("#admitsIcu" + strStatusTypeValue, "css");
		String strValue = this.page.element("#admitsIcu" + strStatusTypeValue, "css").getOne().getAttribute("value");
		assertEquals(strValue, strUpdateValue);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to update SST one to one patients Date :
	 * 08/07/2014 Author : Anil
	 **********************************************************************************/
	public UpdateStatus verifyEnteroneOnOnePatients(String strStatusTypeValue,
			String strUpdateValue) throws Exception {
		objWaitForElement.waitForElements("#oneOnOnePatients" + strStatusTypeValue, "css");
		String strValue = this.page.element("#oneOnOnePatients" + strStatusTypeValue, "css").getOne().getAttribute("value");
		assertEquals(strValue, strUpdateValue);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to update SST Short Staff Date :
	 * 08/07/2014 Author : Anil
	 **********************************************************************************/
	public UpdateStatus verifyEntershortStaffRn(String strStatusTypeValue,
			String strUpdateValue) throws Exception {		
		objWaitForElement.waitForElements("#shortStaffRn" + strStatusTypeValue, "css");
		String strValue = this.page.element("#shortStaffRn" + strStatusTypeValue, "css").getOne().getAttribute("value");
		assertEquals(strValue, strUpdateValue);
		return this;
	}
	

	/**********************************************************************************
	 * Description : This function is to update SST ED beds assigned Date :
	 * 08/07/2014 Author : Anil
	 **********************************************************************************/
	public UpdateStatus verifyEnterEdBedsAssigned(String strStatusTypeValue,
			String strUpdateValue) throws Exception {
		
		objWaitForElement.waitForElements("#edBedsAssigned" + strStatusTypeValue, "css");
		String strValue = this.page.element("#edBedsAssigned" + strStatusTypeValue, "css").getOne().getAttribute("value");
		assertEquals(strValue, strUpdateValue);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to update SST Lobby capacity Date :
	 * 08/07/2014 Author : Anil
	 **********************************************************************************/
	public UpdateStatus verifyEnterlobbyCapacity(String strStatusTypeValue,
			String strUpdateValue) throws Exception {
		objWaitForElement.waitForElements("#lobbyCapacity" + strStatusTypeValue, "css");
		String strValue = this.page.element("#lobbyCapacity" + strStatusTypeValue, "css").getOne().getAttribute("value");
		assertEquals(strValue, strUpdateValue);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify Status type Name and Definition (description)
	  * 			  on 'Update Status' screen
	 * Date		   : 19-May-2015 
	 * Author	   : Pallavi
	 **********************************************************************************/
	public UpdateStatus verifyStatusNameAndDefinitionUpdateStatusScreen(
			String strStatusTypeValue, String strStatusTypeName,
			String strDescription) throws Exception {
		String strSTAndDefinition = "//label[@for='st_" + strStatusTypeValue
				+ "'][contains(text(),'" + strStatusTypeName
				+ "')]/span[text()='" + strDescription + "']";
		objWaitForElement.waitForElements(strSTAndDefinition, "xpath");
		assertTrue(this.page.element(strSTAndDefinition, "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify status type expanded.
	 * Date 		: 25/May/2015
	 * Author 		: Renushree
	 **********************************************************************************/
	public UpdateStatus verStatusTypeExpanded(String strStatusTypeValue)
			throws Exception {
		objWaitForElement.waitForElements("input[value='" + strStatusTypeValue
				+ "'][name='status_type_id']", "css");
		assertTrue(
				this.page
						.element(
								"input[value='" + strStatusTypeValue
										+ "'][name='status_type_id']", "css")
						.getOne().isSelected(),
				"Status type is not expanded to update");
		Thread.sleep(1000);
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify status type expanded.
	 * Date 		: 25/May/2015
	 * Author 		: Renushree
	 **********************************************************************************/
	public UpdateStatus waitUntilShiftTime(String strShiftTime)
			throws Exception {
		String strAppTime = objEventManagement.getApplicationTime();
		String strApp[] = strAppTime.split(" ");
		String strHourMin[] = strApp[2].split(":");
		String strShiftHourMin[] = strShiftTime.split(":");
		int intAppTime1 = Integer.parseInt(strHourMin[1]);
		int intShiftTime1 = Integer.parseInt(strShiftHourMin[1]);
		int intMin = (intShiftTime1-intAppTime1);
		TimeUnit.MINUTES.sleep(intMin+1);
		return this;
	}
	
	
	/**********************************************************************************
	 * Description : This function is to verify updated date and time 
	 * Date :
	 * 08/07/2014 Author : Anil
	 **********************************************************************************/
	public UpdateStatus verifyLastUpdatedTime(String strResourcName,
			String strUpdateTime) throws Exception {	
		objWaitForElement.waitForElements("//table/tbody/tr/td/a[text()='"+strResourcName+"']/ancestor::tr/td[last()-1]", "xpath");
		String strValue = this.page.element("//table/tbody/tr/td/a[text()='"+strResourcName+"']/ancestor::tr/td[last()-1]", "xpath").getOne().getText();
		System.out.println(strValue);
		assertTrue(strValue.contains(strUpdateTime));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify updated date and time in tool tip
	 * Date :
	 * 08/07/2014 Author : Anil
	 **********************************************************************************/
	public UpdateStatus verifyLastUpdatedTimeInToolTip(String strResourceValue,String strStatusTypeValue,String strUpdatedValue, 
			String strUpdateTime, String strUserFullName) throws Exception {
		objWaitForElement.waitForElements("//td[@id='v_" + strResourceValue + "_"
				+ strStatusTypeValue + "'][text()='"
				+ strUpdatedValue + "']", "xpath");
		this.page.element("//td[@id='v_" + strResourceValue + "_"
				+ strStatusTypeValue + "'][text()='"
				+ strUpdatedValue + "']", "xpath").mouseOver();
		objWaitForElement.waitForElements("//div[@id='theToolTip']/h1", "xpath");
		String strValue1 = this.page.element("//div[@id='theToolTip']/h1", "xpath").getOne().getText();
		String strValue2 = this.page.element("//div[@id='theToolTip']/p", "xpath").getOne().getText();
		System.out.println(strValue1);
		System.out.println(strValue2);
		assertEquals(strValue1, strUpdateTime);
		assertEquals(strValue2, strUserFullName);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify updated date and time in tool tip
	 * Date :
	 * 08/07/2014 Author : Anil
	 **********************************************************************************/
	public UpdateStatus verifyLastUpdatedTimeInToolTipAfterOverDue(String strResourceValue,String strStatusTypeValue,String strUpdatedValue, 
			String strUpdateTime, String strUserFullName) throws Exception {
		objWaitForElement.waitForElements("//td[@id='v_" + strResourceValue + "_"
				+ strStatusTypeValue + "'][text()='"
				+ strUpdatedValue + "']", "xpath");
		this.page.element("//td[@id='v_" + strResourceValue + "_"
				+ strStatusTypeValue + "'][text()='"
				+ strUpdatedValue + "']", "xpath").mouseOver();
		objWaitForElement.waitForElements("//div[@id='theToolTip']/h1[@class='overdue']", "xpath");
		String strValue1 = this.page.element("//div[@id='theToolTip']/h1[@class='overdue']", "xpath").getOne().getText();
		String strValue2 = this.page.element("//div[@id='theToolTip']/p", "xpath").getOne().getText();
		System.out.println(strValue1);
		System.out.println(strValue2);
		assertEquals(strValue1, strUpdateTime);
		assertEquals(strValue2, strUserFullName);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is toverify updated date and time 
	 * Date :
	 * 08/07/2014 Author : Anil
	 **********************************************************************************/
	public UpdateStatus verifyLastUpdatedTime(String strResourcName,
			String strUpdateTime, String strUpdatedTime1) throws Exception {	
		objWaitForElement.waitForElements("//table/tbody/tr/td/a[text()='"+strResourcName+"']/ancestor::tr/td[last()]", "xpath");
		String strValue = this.page.element("//table/tbody/tr/td/a[text()='"+strResourcName+"']/ancestor::tr/td[last()]", "xpath").getOne().getText();
		System.out.println(strValue);
		assertTrue((strValue.contains(strUpdateTime))||(strValue.contains(strUpdatedTime1)));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify updated date and time in tool tip
	 * Date :
	 * 08/07/2014 Author : Anil
	 **********************************************************************************/
	public UpdateStatus verifyLastUpdatedTimeInToolTipAfterOverDue(String strResourceValue,String strStatusTypeValue,String strUpdatedValue, String strUpdateTime,
			String strUpdateTime1, String strUserFullName) throws Exception {
		objWaitForElement.waitForElements("//td[@id='v_" + strResourceValue + "_"
				+ strStatusTypeValue + "'][text()='"
				+ strUpdatedValue + "']", "xpath");
		this.page.element("//td[@id='v_" + strResourceValue + "_"
				+ strStatusTypeValue + "'][text()='"
				+ strUpdatedValue + "']", "xpath").mouseOver();
		objWaitForElement.waitForElements("//div[@id='theToolTip']/h1[@class='overdue']", "xpath");
		String strValue1 = this.page.element("//div[@id='theToolTip']/h1[@class='overdue']", "xpath").getOne().getText();
		String strValue2 = this.page.element("//div[@id='theToolTip']/p", "xpath").getOne().getText();
		System.out.println(strValue1);
		System.out.println(strValue2);
		assertTrue((strValue1.equals(strUpdateTime))||(strValue1.equals(strUpdateTime1)));
		assertEquals(strValue2, strUserFullName);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify the updated value of ststua types.
	  * Date        : 27/05/2014
	  * Author      : Anitha
	  **********************************************************************************/	
	public UpdateStatus verifyUpdatedStatusreason(String strStatusReason) throws Exception {
		objWaitForElement.waitForElements("//table/thead/tr/th[text()='Comment']", "xpath");
		assertTrue(
				this.page.element("//table/tbody/tr/td[text()='"+strStatusReason+"']", "xpath")
						.isElementPresent(), "Updated values are not displayed");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify the updated value of ststua types.
	  * Date        : 27/05/2014
	  * Author      : Anitha
	  **********************************************************************************/	
	public UpdateStatus verifyUpdatedSRInUpadteStatusPage(
			String strStatusReason, String strSRDesc) throws Exception {
		objWaitForElement.waitForElements("//div/label[text()='"
				+ strStatusReason + " ']/span[text()='-- " + strSRDesc + "']",
				"xpath");
		assertTrue(
				this.page.element(
						"//div/label[text()='" + strStatusReason
								+ " ']/span[text()='-- " + strSRDesc + "']",
						"xpath").isElementPresent(),
				"Updated values are not displayed");
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify status type expanded.
	 * Argument		: strStatusName
	 * Date 		: 27/May/2015
	 * Author 		: Renushree
	 **********************************************************************************/
	public UpdateStatus verStatusReasonInstruction(String strStatusName)
			throws Exception {
		objWaitForElement.waitForElements(resuiredText, "xpath");
		String strInstructionMsg = this.page.element(resuiredText, "xpath")
				.getOne().getText();
		assertEquals(
				"Please note: You must select one or more from this list when choosing \""
						+ strStatusName + "\" status:", strInstructionMsg);
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify error when status reason not selected.
	 * Arguments	: strStatusType, strStatus
	 * Date			: 27/May/2015 
	 * Author 		: Renushree
	 **********************************************************************************/
	public UpdateStatus verErrorWhenStatusReasonNotSelected(
			String strStatusType, String strStatus) throws Exception {
		objWaitForElement
				.waitForElements(
						"//span[@class='emsErrorTitle'][text()='The following error occurred on this page:']",
						"xpath");
		assertTrue(this.page
				.element(
						"//span[@class='emsErrorTitle'][text()='The following error occurred on this page:']",
						"xpath").isElementPresent());
		assertEquals(
				"" + strStatusType + " status " + strStatus
						+ " must have status reason.",
				this.page
						.element("//div[@id='mainContainer']/div[3]/ul/li",
								"xpath").getOne().getText());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify the updatedcomments
	  * Arguments	: strResourceValue, strStatusTypeValue, strUpdatedValue,strComments
	  * Date        : 27/May/2015
	  * Author      : Renushree
	  **********************************************************************************/	
	public UpdateStatus verifyUpdatedComments(String strResourceValue,
			String strComments) throws Exception {
		objWaitForElement.waitForElements("//td[@id='c_" + strResourceValue
				+ "']", "xpath");
		assertEquals(
				strComments,
				this.page
						.element("//td[@id='c_" + strResourceValue + "']",
								"xpath").getOne().getText());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify updated comment is displayed
	 * Date :
	 * 08/07/2014 Author : Anil
	 **********************************************************************************/
	public UpdateStatus verifyUpdatedComment(String strResourcName,
			String strComment) throws Exception {	
		objWaitForElement.waitForElements("//table/tbody/tr/td/a[text()='"+strResourcName+"']/ancestor::tr/td[last()-2]", "xpath");
		String strValue = this.page.element("//table/tbody/tr/td/a[text()='"+strResourcName+"']/ancestor::tr/td[last()-2]", "xpath").getOne().getText();
		System.out.println(strValue);
		assertEquals(strValue,strComment);
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to click on remind me in qo min button
	 * Date			: 12/06/2015 
	 * Author 		: Renushree
	 **********************************************************************************/
	public UpdateStatus clickOnRemindMeIn10MinBtn() throws Exception {
		objWaitForElement.waitForElements(remindMeIn10Min, "css");
		this.page.element(remindMeIn10Min, "css")
				.getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to click on Show all statusses
	 * Date			: 12/06/2015 
	 * Author 		: Renushree
	 **********************************************************************************/
	public UpdateStatus clickOnShowAllStatuses() throws Exception {
		objWaitForElement.waitForElements(showAllStatuses, "xpath");
		assertTrue(this.page.element(showAllStatuses, "xpath").isElementPresent());
		this.page.element(showAllStatuses, "xpath")
				.getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify status type expanded.
	 * Arguments	: strStatusTypeValue, strStatusTypeName
	 * Date 		: 12/06/2015 
	 * Author 		: Renushree
	 **********************************************************************************/
	public UpdateStatus verStatusTypeDisplayed(String strStatusTypeValue,
			String strStatusTypeName) throws Exception {
		objWaitForElement.waitForElements("//input[@id='st_"
				+ strStatusTypeValue + "']/parent::div/label[text()='"
				+ strStatusTypeName + ": ']", "xpath");
		assertTrue(
				this.page.element(
						"//input[@id='st_" + strStatusTypeValue
								+ "']/parent::div/label[text()='"
								+ strStatusTypeName + ": ']", "xpath")
						.isElementPresent(), "Status type is not present");
		Thread.sleep(1000);
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify web notification frame not displayed
	 * Date 		: 18/Jun/2015 
	 * Author 		: Renushree
	 **********************************************************************************/
	public UpdateStatus verWebNotificationframeNotDisplyad() throws Exception {
		assertFalse(this.page.element("TB_iframeContent", "id")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify update overdue status page is displayed
	 * Date 		: 18/Jun/2015 
	 * Author 		: Anil
	 **********************************************************************************/
	public UpdateStatus verifyOverDueStatusIsDisplayed(String strStatusValue) throws Exception {
		objWaitForElement.waitForElements("//label[@for='st_"+strStatusValue+"']/span[@class='overdue'][text()='(Required/Overdue)']", "xpath");
		assertTrue(
				this.page.element("//label[@for='st_"+strStatusValue+"']/span[@class='overdue'][text()='(Required/Overdue)']", "xpath")
						.getOne().isDisplayed(), "Status type is not present");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on cancel button Date : 08/07/2014
	 * Author : Anil
	 **********************************************************************************/
	public UpdateStatus clickOnCancelButton() throws Exception {
		objWaitForElement.waitForElements(cancelButton, "css");
		this.page.element(cancelButton, "css").getOne().click();
		Thread.sleep(5000);
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify update overdue status page is not displayed
	 * Date 		: 18/Jun/2015 
	 * Author 		: Renushree
	 **********************************************************************************/
	public UpdateStatus verifyOverDueStatusIsNotDisplayed(String strStatusValue) throws Exception {
		assertFalse(
				this.page.element("//input[@name='status_type_id'][@id='st_"+strStatusValue+"']", "xpath")
						.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify status type not displayed.
	 * Arguments	: strStatusTypeValue, strStatusTypeName
	 * Date 		: 22/07/2015 
	 * Author 		: Renushree
	 **********************************************************************************/
	public UpdateStatus verStatusTypeNotDisplayed(String strStatusTypeValue,
			String strStatusTypeName) throws Exception {
		assertFalse(
				this.page
						.element(
								"//input[@id='st_" + strStatusTypeValue
										+ "']/parent::div/label[text()='"
										+ strStatusTypeName + ": ']", "xpath")
						.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE),
				"Status type is not present");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'NEDOCS Help Document' link
	 * Date        : 29/07/2015
	 * Author      : Sowmya
	 **********************************************************************************/
	public UpdateStatus clickOnNEDOCShelpDocLink() throws Exception {
		objWaitForElement.waitForElements(nEDOCSHelpDocLink, "xpath");
		this.page.element(nEDOCSHelpDocLink, "xpath").getOne().click();
		Thread.sleep(15000);
		return this;
	}
	
	/********************************************************************************************************************************************
	 * Description : This function is to verify 'EMResource Help' link is present in new window (when you click on 'NEDOCS Help Document' link)
	 * Date        : 29/07/2015
	 * Author      : Sowmya
	 *********************************************************************************************************************************************/
	public UpdateStatus verEMResourceHelpLinkInNewWindow() throws Exception {
		objWaitForElement.waitForElements(emResourceHelpLink, "xpath");
		assertTrue(this.page.element(emResourceHelpLink, "xpath")
				.isElementPresent());
		Thread.sleep(5000);
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify web notification for the status types which set above and below values notificaion refernces. 
	 * Date			: 23/09/2014 
	 * Author 		: Anil
	 **********************************************************************************/
	public UpdateStatus verWebNotificationForStatusUpdateForNST(
			String strResourceName, String strStatusTypeName,
			String strUpdatedVal, String strUpdatedDateAndTime)
			throws Exception {
		objWaitForElement.waitForElements("dt.othr", "css");
		assertEquals("Status Change for " + strResourceName + "", this.page
				.element("dt.othr", "css").getOne().getText());
		assertTrue(this.page.element(
				"//dl/dd[@class='desc'][text()='On " + strUpdatedDateAndTime
						+ "  changed " + strStatusTypeName
						+ " status from 0 to " + strUpdatedVal + ".']",
				"xpath").isElementPresent());
		return this;
	}
	
	/********************************************************************************************************************************************
	 * Description : This function is to verify nedoc score calculated only after click on calculate button.
	 * Date        : 05/10/2015
	 * Author      : Renushree
	 *********************************************************************************************************************************************/
	public UpdateStatus verNedocScoreCalculatedOnlyAfterClickOnCalcute(
			String strNedocSTVal, String strUpdatedVal) throws Exception {
		objWaitForElement.waitForElements("span#saturationScoreDisplay"
				+ strNedocSTVal + "", "css");
		assertEquals(
				"--",
				this.page
						.element(
								"span#saturationScoreDisplay" + strNedocSTVal
										+ "", "css").getOne().getText());
		this.clickOnCalculate();
		assertEquals(
				"" + strUpdatedVal + " :",
				this.page
						.element(
								"span#saturationScoreDisplay" + strNedocSTVal
										+ "", "css").getOne().getText());
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify web notification for the Multi St with selected status & corresponding reasons . 
	 * Date			: 23/09/2014 
	 * Author 		:Sangappa.K
	 **********************************************************************************/
	public UpdateStatus verWebNotificationForStatusUpdateWithSTReasons(
			String strResourceName, String strStatusTypeName,
			String strUpdatedVal, String strUpdatedDateAndTime,
			String strReasons)
			throws Exception {
		objWaitForElement.waitForElements("dt.othr", "css");
		assertEquals("Status Change for " + strResourceName + "", this.page
				.element("dt.othr", "css").getOne().getText());
		assertTrue(this.page.element(
				"//dl/dd[@class='desc'][text()='On " + strUpdatedDateAndTime
						+ "  changed " + strStatusTypeName
						+ " status from -- to " + strUpdatedVal + ". Reasons: "+
						strReasons+ ".']", "xpath").isElementPresent());
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to verify the updated value of ststua types.
	  * Date        : 27/05/2014
	  * Author      :Sangappa K
	  **********************************************************************************/	
	public UpdateStatus verifyUpdatedStatusreasons(String strRes,
			String strStatusReasons) throws Exception {
		String strReasonId = "//table/tbody/tr/td/a[text()='" + strRes
				+ "']/following::td[contains(text(),'" + strStatusReasons
				+ "')]";
		System.out.println(strReasonId);
		objWaitForElement.waitForElements(strReasonId, "xpath");
		assertTrue(this.page.element(strReasonId, "xpath").isElementPresent(),
				"Updated values are not displayed");
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to click on Show all statusses
	 * Date			: 12/06/2015 
	 * Author 		: Anitha
	 **********************************************************************************/
	public UpdateStatus verifyUpdateLinks() throws Exception {
		objWaitForElement.waitForElements(showAllStatuses, "xpath");
		assertTrue(this.page.element(showAllStatuses1, "xpath").isElementPresent());
		assertTrue(this.page.element(selectAll1, "xpath").isElementPresent());
		assertTrue(this.page.element(clearAll, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on cancel button Date : 08/07/2014
	 * Author : Anil
	 **********************************************************************************/
	public UpdateStatus clickOnClearAllButton() throws Exception {
		objWaitForElement.waitForElements(clearAll, "xpath");
		this.page.element(clearAll, "xpath").getOne().click();
		Thread.sleep(5000);
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify status type expanded.
	 * Date 		: 25/May/2015
	 * Author 		: Renushree
	 **********************************************************************************/
	public UpdateStatus verStatusTypeNotExpanded(String strStatusTypeValue)
			throws Exception {
		objWaitForElement.waitForElements("input[value='" + strStatusTypeValue
				+ "'][name='status_type_id']", "css");
		assertFalse(
				this.page
						.element(
								"input[value='" + strStatusTypeValue
										+ "'][name='status_type_id']", "css")
						.getOne().isSelected(),
				"Status type is expanded to update");
		Thread.sleep(1000);
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to click on Show all statusses
	 * Date			: 12/06/2015 
	 * Author 		: Anitha
	 **********************************************************************************/
	public UpdateStatus verifyUpdateLinks1() throws Exception {
		objWaitForElement.waitForElements(selectAll1, "xpath");
		assertTrue(this.page.element(selectAll1, "xpath").isElementPresent());
		assertTrue(this.page.element(clearAll, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify updated status value is green in color
	 * Date			: 12/06/2015 
	 * Author 		: Anil
	 **********************************************************************************/
	public UpdateStatus verifyUpdatedValueGreenColor(String strUpdatedValue) throws Exception {
		objWaitForElement.waitForElements("//span[contains(text(),'"+strUpdatedValue+"')]", "xpath");
		assertTrue(this.page.element("//span[contains(text(),'"+strUpdatedValue+"')]", "xpath").getOne().isDisplayed());
		String str = this.page.element("//span[contains(text(),'"+strUpdatedValue+"')]", "xpath").getOne().getAttribute("style");
		assertTrue(str.contains(updatedValueDisplayInGreen));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify update status pop up wothout saving the ST
	  * Date        : 18/Jan/2015
	  * Author      : Sangappa K
	  **********************************************************************************/
	public UpdateStatus verAndAcceptUpdateStatusPromptWithoutSavingSt() throws Exception {
		
		Alert alert = driver.switchTo().alert();
		String strVar = alert.getText();
		System.out.println(strVar);
		alert.accept();
		Thread.sleep(3000);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Disaster' text is not dispalyed In Update status page while updating the nedocs St 
	  * Date        : 25/Jan/2016
	  * Author      : Sangappa K
	 **********************************************************************************/
	public UpdateStatus verDisasterTextIsNotDispWhileCalculataingNedocs(
			String strUpdatedValue) throws Exception {

		assertFalse(this.page.element(
				"//div[@class='formElemLong']/span[text()='" + strUpdatedValue
						+ "']", "xpath").isElementPresent(
				WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	/**********************************************************************************
	* Description : This function is to verify 'Disaster' text is not dispalyed In View page while updating the nedocs St 
	  * Date        : 25/Jan/2016
	  * Author      : Sangappa K
	 **********************************************************************************/
	public UpdateStatus verUpdatedNedocsDoesNotIncludesDisasterTextInViewPage(String strST,
			String strUpdatedValue) throws Exception {

		assertFalse(this.page.element(
				"//th/a[text()='"+strST+"']/ancestor::thead/following-sibling::tbody/tr/td[text()='"+strUpdatedValue+"']","xpath").isElementPresent(
				WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify web notification does not contain status
	 * 				  change notification for a particular status type. 
	 * Date			: 09-Feb-2016 
	 * Author 		: Pallavi
	 **********************************************************************************/
	public UpdateStatus verWebNotificationDoesNotContainParticularST(
			String strResourceName, String strStatusTypeName,
			String strUpdatedVal, String strUpdatedDateAndTime)
			throws Exception {
		objWaitForElement.waitForElements("dt.othr", "css");
		String strWebNotification = "//dl/dt[text()='Status Change for  "
				+ strResourceName
				+ "']/following-sibling::dd[@class='desc'][text()='On "
				+ strUpdatedDateAndTime + "  changed  " + strStatusTypeName
				+ " status from 0 " + strUpdatedVal + ".']";
		System.out.println(strWebNotification + "Should not be present");
		assertFalse(this.page.element(strWebNotification, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify web notification does not contain status
	 * 				  change notification for a particular MST. 
	 * Date			: 09-Feb-2016 
	 * Author 		: Pallavi
	 **********************************************************************************/
	public UpdateStatus verWebNotificationDoesNotContainMST(
			String strResourceName, String strStatusTypeName,
			String strUpdatedStatus, String strUpdatedDateAndTime)
			throws Exception {
		objWaitForElement.waitForElements("dt.othr", "css");
		String strWebNotification = "//dl/dt[text()='Status Change for  "
				+ strResourceName
				+ "']/following-sibling::dd[@class='desc'][text()='On "
				+ strUpdatedDateAndTime + "  changed  " + strStatusTypeName
				+ " status from -- to " + strUpdatedStatus + ".']";
		System.out.println(strWebNotification + "Should not be present");
		assertFalse(this.page.element(strWebNotification, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	/**********************************************************************************
	 * Description 	: This function is to verify web notification for the MST notificaion refernces. 
	 * Date			: 23/09/2014 
	 * Author 		: Renushree
	 **********************************************************************************/
	public UpdateStatus verWebNotificationForStatusUpdateOfMSTForSubRes(
			String strResourceName, String strSubResName,
			String strStatusTypeName, String strUpdatedVal,
			String strUpdatedDateAndTime) throws Exception {
		objWaitForElement.waitForElements("dt.othr", "css");
		assertEquals("Status Change for " + strResourceName + ": "
				+ strSubResName + "", this.page.element("dt.othr", "css")
				.getOne().getText());
		assertTrue(this.page.element(
				"//dl/dd[@class='desc'][text()='On " + strUpdatedDateAndTime
						+ " " + strResourceName + ": " + strSubResName
						+ " changed " + strStatusTypeName
						+ " status from -- to " + strUpdatedVal + ".']",
				"xpath").isElementPresent());
		return this;
	}
	
	
	/**********************************************************************************
	 * Description 	: This function is to verify web notification for the status types which set above and below values notificaion refernces. 
	 * Date			: 23/09/2014 
	 * Author 		: Pallavi
	 **********************************************************************************/
	public UpdateStatus verWebNotificationForStatusUpdateOfAboveAndBeowValForSubRes(
			String strResourceName, String strSubResName,
			String strStatusTypeName, String strPreviousVal,String strUpdatedVal,
			String strUpdatedDateAndTime) throws Exception {
		assertEquals("Status Change for " + strResourceName + ": "
				+ strSubResName + "", this.page.element("dt.othr", "css")
				.getOne().getText());
		assertTrue(this.page
				.element(
						"//dl/dd[@class='desc'][text()='On "
								+ strUpdatedDateAndTime + " " + strResourceName
								+ ": " + strSubResName + " changed "
								+ strStatusTypeName + " status from "+strPreviousVal+" to "
								+ strUpdatedVal + ".']", "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify web notification for the status types which set above and below values notificaion refernces. 
	 * Date			: 18/02/2014 
	 * Author 		: Renushree
	 **********************************************************************************/
	public UpdateStatus verWebNotificationForStatusUpdateOfAboveAndBeowValForRes(
			String strResourceName,
			String strStatusTypeName, String strPreviousVal,String strUpdatedVal,
			String strUpdatedDateAndTime) throws Exception {
		assertEquals("Status Change for " + strResourceName + "", this.page.element("dt.othr", "css")
				.getOne().getText());
		assertTrue(this.page
				.element(
						"//dl/dd[@class='desc'][text()='On "
								+ strUpdatedDateAndTime + " changed "
								+ strStatusTypeName + " status from "+strPreviousVal+" to "
								+ strUpdatedVal + ".']", "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Disaster' text is dispalyed In Update status page while updating the nedocs St 
	  * Date        : 25/Jan/2016
	  * Author      : Anil
	 **********************************************************************************/
	public UpdateStatus verDisasterTextIsDispWhileCalculataingNedocs(
			String strUpdatedValue) throws Exception {

		assertTrue(this.page.element(
				"[text()='" + strUpdatedValue
						+ "']", "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on calculate button
	  * Date        : 25/Jan/2016
	  * Author      : Anil
	 **********************************************************************************/
	public UpdateStatus clickOnCalculateButton(String strSTValue) throws Exception {
		objWaitForElement.waitForElements("//div[@id='st_"+strSTValue+"section']//input[@value='Calculate']", "xpath");
		this.page.element("//div[@id='st_"+strSTValue+"section']//input[@value='Calculate']", "xpath").getOne().click();
		return this;
	}
}