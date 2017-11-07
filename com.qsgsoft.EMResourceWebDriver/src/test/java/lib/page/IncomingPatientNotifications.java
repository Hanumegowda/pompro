package lib.page;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.*;
import lib.module.NavigationToSubMenus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import qaframework.lib.WaitTimeConstants;
import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;

public class IncomingPatientNotifications extends PageObject {

	WebDriver driver;
	WaitForElement objWaitForElement;
	private String strage ="#age",
			       strcomplaint="#complaint",
			       strEMS="#transportBy",
			       strEMSUnit="#unitNumber",
			       strETA="#eta",
			       save="#saveButton",
			       strIPNBtn=".emsButtonText",
			       strCancel="//input[@name='cancelButton']",
			       strenabledCheckBox = "enabled",
			       saveButtonInConfigureIPN = "input[value='Save']",
			       strManualEntryCheckBox = "manualEntry",
			       strTransportingToListbox = "//select[@id='transportTo']",
			   	   strText = "Columbus Community*",
			   	   strText1 = "Icon Hospital*",
			   	   strText2 = "Bellville St. Joseph Health Center*",
			   	   sentMessage = "//div[contains(text(),'Incoming Patient Notification has been sent.')]",
			   	   IPN="//div[@id='topSubNav']/h1[text()='Manual IPN Entry']",
			   	   strNotify="//div[@class='centerSuccessBox'][contains(text(),'Incoming Patient Notification has been sent.')]",
	   			createNewIncomingPatientNotifnbutton = "//input[@class='emsButtonText']" ,
				   incomingPatientNotificationsInLast24HoursPg = "//div[@id='topSubNav']/h1[text()='Incoming Patient Notifications In Last 24 Hours']",
				   IPNpage="//div[@id='topSubNav']/h1[text()='Configure Incoming Patient Notifications']",
				   strManaulChkBox="//td[text()='Allow Manual Entry?']/following::td/input[@name='manualEntry']",
	              strEnabled="//td[text()='Enabled?']/following::td/input[@name='enabled']",
	       			incomingPatientNotifications = "//td/a[text()='Incoming Patient Notifications']",
	       			sendincomingpatientNotification="//td/a[text()='Send Incoming Patient Notification']";
	       			
	       			
	       			
			   	
	
	
	public IncomingPatientNotifications(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
	}

	/***************************************************************************************************
	 * Description : This function is to verify 'Incoming patient notification'
	 * details of 'Complaint', 'Triage', 'Gender', 'Resource', 'Region',
	 * 'Acknowledged By', 'Acknowledgement Date' Date : 07/10/2014 Author :
	 * Sowmya
	 **************************************************************************************************/
	public IncomingPatientNotifications verifIncomingPatientNotificationDetails(
			String strData[], String AcknowledgementDate,
			String AcknowledgementDateOneMinAdded) throws Exception {

		for (int i = 1; i < strData.length; i++) {
			String j = strData[0];
			objWaitForElement.waitForElements(
					"//div[@id='mainContainer']/table/tbody/tr/td[text()='" + j
							+ "']/following-sibling::td[" + i + "][text()='"
							+ strData[i] + "']", "xpath");
			assertTrue(this.page
					.element(
							"//div[@id='mainContainer']/table/tbody/tr/td[text()='"
									+ j + "']/following-sibling::td[" + i
									+ "][text()='" + strData[i] + "']", "xpath")
					.getOne().isDisplayed());
		}

		String strActualTime = this.page
				.element(
						"//div[@id='mainContainer']/table/tbody/tr/td[text()='"
								+ strData[0] + "']/following-sibling::td[7]",
						"xpath").getOne().getText();
		assertTrue((strActualTime.equals(AcknowledgementDate))
				|| (strActualTime.equals(AcknowledgementDateOneMinAdded)));

		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify 'Incoming patient notification'
	 * details of 'sent by' and 'Age' Date : 07/10/2014 Author : Sowmya
	 **********************************************************************************/
	public IncomingPatientNotifications verifIncomingPatientNotificationDetails1(
			String strData[]) throws Exception {
		for (int k = 1; k < strData.length; k++) {
			String l = strData[0];
			objWaitForElement.waitForElements(
					"//div[@id='mainContainer']/table/tbody/tr/td[text()='" + l
							+ "']/preceding-sibling::td[" + k + "][text()='"
							+ strData[k] + "']", "xpath");
			assertTrue(this.page
					.element(
							"//div[@id='mainContainer']/table/tbody/tr/td[text()='"
									+ l + "']/preceding-sibling::td[" + k
									+ "][text()='" + strData[k] + "']", "xpath")
					.getOne().isDisplayed());
		}
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to select gender Date : 23/07/2015 Author
	 * : Sangappa.k
	 **********************************************************************************/
	public IncomingPatientNotifications selectGenderRdBtn(String strGender)
			throws Exception {

		String gender = "//input[@value='" + strGender + "']";
		objWaitForElement.waitForElements(gender, "xpath");
		this.page.element(gender, "xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to eneter age Date : 23/07/2015 Author :
	 * Sangappa.k
	 **********************************************************************************/
	public IncomingPatientNotifications enterAge(String strAges)
			throws Exception {

		objWaitForElement.waitForElements(strage, "css");
		this.page.element(strage, "css").clearInputsValue();
		this.page.element(strage, "css").getOne().sendKeys(strAges);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to enter Cheaf Complaint Date : 23/07/2015
	 * Author : Sangappa.k
	 **********************************************************************************/
	public IncomingPatientNotifications enterCheafComplaint(String strComplaint)
			throws Exception {

		objWaitForElement.waitForElements(strcomplaint, "css");
		this.page.element(strcomplaint, "css").clearInputsValue();
		this.page.element(strcomplaint, "css").getOne().sendKeys(strComplaint);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to select Triage Category Rd Btn Date :
	 * 23/07/2015 Author : Sangappa.k
	 **********************************************************************************/
	public IncomingPatientNotifications selectTriageCategoryRdBtn(
			String strClolour) throws Exception {

		String clour = "//input[@value='" + strClolour + "']";
		objWaitForElement.waitForElements(clour, "xpath");
		this.page.element(clour, "xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to select Level Of Categoery Rd Btn Date :
	 * 23/07/2015 Author : Sangappa.k
	 **********************************************************************************/
	public IncomingPatientNotifications selectLevelOfCategoeryRdBtn(
			String strLevelOfcare) throws Exception {

		String care = "//input[@value='" + strLevelOfcare + "']";
		objWaitForElement.waitForElements(care, "xpath");
		this.page.element(care, "xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to eneter EMS agency Date : 23/07/2015
	 * Author : Sangappa.k
	 **********************************************************************************/
	public IncomingPatientNotifications enterEMSAgency(String strEMSAgency)
			throws Exception {

		objWaitForElement.waitForElements(strEMS, "css");
		this.page.element(strEMS, "css").clearInputsValue();
		this.page.element(strEMS, "css").getOne().sendKeys(strEMSAgency);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to eneter EMS unit Date : 23/07/2015
	 * Author : Sangappa.k
	 **********************************************************************************/
	public IncomingPatientNotifications enterEMSUnit(String strEMSUnits)
			throws Exception {

		objWaitForElement.waitForElements(strEMSUnit, "css");
		this.page.element(strEMSUnit, "css").clearInputValue()
				.sendKeys(strEMSUnits);

		return this;
	}

	/**********************************************************************************
	 * Description : This function is to enter ETA Date : 23/07/2015 Author :
	 * Sangappa.k
	 **********************************************************************************/
	public IncomingPatientNotifications enterETA(String strETAs)
			throws Exception {

		objWaitForElement.waitForElements(strETA, "css");
		this.page.element(strETA, "css").clearInputsValue();
		this.page.element(strETA, "css").getOne().sendKeys(strETAs);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on save Date : 23/07/2015 Author
	 * : Sangappa.k
	 **********************************************************************************/
	public IncomingPatientNotifications clickOnSave() throws Exception {
		objWaitForElement.waitForElements(save, "css");
		this.page.element(save, "css").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on creat new IPN btn Date :
	 * 23/07/2015 Author : Sangappa.k
	 **********************************************************************************/
	public IncomingPatientNotifications clickOnCreateNewIPNBtn()
			throws Exception {
		objWaitForElement.waitForElements(strIPNBtn, "css");
		this.page.element(strIPNBtn, "css").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to create new IPN Date : 23/07/2015 Author
	 * : Sangappa.k
	 **********************************************************************************/
	public IncomingPatientNotifications creatNewIncomingPationtNotification(
			String strGender, String strAges, String strComplaint,
			String strClolour, String strLevelOfcare, String strEMSAgency,
			String strEMSUnits, String strETAs) throws Exception {
		this.selectGenderRdBtn(strGender);
		this.enterAge(strAges);
		this.enterCheafComplaint(strComplaint);
		this.selectTriageCategoryRdBtn(strClolour);
		this.selectLevelOfCategoeryRdBtn(strLevelOfcare);
		this.enterEMSAgency(strEMSAgency);
		this.enterEMSUnit(strEMSUnits);
		this.enterETA(strETAs);
		this.clickOnSave();

		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on save Date : 23/07/2015 Author
	 * : Sangappa.k
	 **********************************************************************************/
	public IncomingPatientNotifications verResourcesUnderTransportDropDown(
			String strResName) throws Exception {
		String Res = "//select[@id='transportTo']/option[text()='" + strResName
				+ "']";
		objWaitForElement.waitForElements(Res, "xpath");
		this.page.element("//select[@id='transportTo']", "xpath").getOne()
				.click();
		assertTrue(this.page.element(Res, "xpath").isElementPresent());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on creat new IPN btn Date :
	 * 23/07/2015 Author : Sangappa.k
	 **********************************************************************************/
	public IncomingPatientNotifications clickOnCancel() throws Exception {
		objWaitForElement.waitForElements(strCancel, "xpath");
		this.page.element(strCancel, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description :  This function is to deselect enabled checkbox
	* Date 		  : 23/07/2015
	* Author 	  : Anil
	***********************************************************************************/
	public IncomingPatientNotifications deselectEnabledCheckBox() throws Exception {
		
		objWaitForElement.waitForElements(strenabledCheckBox, "name");
		if(this.page.element(strenabledCheckBox, "name").getOne().isSelected()==true){
			this.page.element(strenabledCheckBox, "name").getOne().click();
		}	
		return this;
	}
	
	/**********************************************************************************
	* Description :  This function is to click on save button in Configure Incoming Patient Notifications page
	* Date 		  : 23/07/2015
	* Author 	  : Anil
	***********************************************************************************/
	public IncomingPatientNotifications clickOnSaveButton() throws Exception {	
		objWaitForElement.waitForElements(saveButtonInConfigureIPN, "css");
		this.page.element(saveButtonInConfigureIPN, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description :  This function is to deselect manual entry checkbox
	* Date 		  : 23/07/2015
	* Author 	  : Anil
	***********************************************************************************/
	public IncomingPatientNotifications deselectManualEntryCheckBox() throws Exception {
		
		objWaitForElement.waitForElements(strManualEntryCheckBox, "name");
		if(this.page.element(strManualEntryCheckBox, "name").getOne().isSelected()==true){
			this.page.element(strManualEntryCheckBox, "name").getOne().click();
		}	
		return this;
	}
	
	/**********************************************************************************
	* Description :  This function is to select manual entry checkbox
	* Date 		  : 23/07/2015
	* Author 	  : Anil
	***********************************************************************************/
	public IncomingPatientNotifications selectManualEntryCheckBox() throws Exception {
		
		objWaitForElement.waitForElements(strManualEntryCheckBox, "name");
		if(this.page.element(strManualEntryCheckBox, "name").getOne().isSelected()==false){
			this.page.element(strManualEntryCheckBox, "name").getOne().click();
		}	
		return this;
	}
	
	/**********************************************************************************
	* Description :  This function is to select enabled checkbox
	* Date 		  : 23/07/2015
	* Author 	  : Anil
	***********************************************************************************/
	public IncomingPatientNotifications selectEnabledCheckBox() throws Exception {
		
		objWaitForElement.waitForElements(strenabledCheckBox, "name");
		if(this.page.element(strenabledCheckBox, "name").getOne().isSelected()==false){
			this.page.element(strenabledCheckBox, "name").getOne().click();
		}	
		return this;
	}
	

/**********************************************************************************
	* Description : This function is to click on Transporting to listbox
	* Date 		  : 2/09/2015
	* Author 	  : Sandhya M B
	**********************************************************************************/
	public IncomingPatientNotifications clickOnTransportingToListbox(String strResource) throws Exception {
		objWaitForElement.waitForElements(strTransportingToListbox, "xpath");
		this.page.element(strTransportingToListbox, "xpath").webElementToSelect().selectByVisibleText(strResource);
		return this;		
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Incoming Patient Notification has been sent'. validation message is displayed 
	* Date 		  : 3/09/2015
	* Author 	  : Sandhya M B
	**********************************************************************************/
	public IncomingPatientNotifications verIncomingPatientNotificationIsSent()
			throws Exception {
		String actualMsg = this.page.element(sentMessage, "xpath").getOne()
				.getText();
		String expectedMsg = "Incoming Patient Notification has been sent.";
		assertTrue(actualMsg.equals(expectedMsg));
		return this;
	}
	/**********************************************************************************
	* Description :  This function is to verify "Manual IPN Entry" screen
	* Date 		  : 23/07/2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public IncomingPatientNotifications verManualIPNEntrySceen()
			throws Exception {
		objWaitForElement.waitForElements(IPN, "xpath");
		assertTrue(this.page.element(IPN, "xpath").isElementPresent(),
				"no IPN page present");
		return this;
	}

	/**********************************************************************************
	* Description : This function is to select resources from transporting drop down
	* Date 		  : 28-Aug-2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public IncomingPatientNotifications selectTransportingTo(
			String strRes) throws Exception {

		objWaitForElement.waitForElements("transportTo", "id");
		Select selectByVisibleText = new Select(driver.findElement(By
				.id("transportTo")));
		selectByVisibleText.selectByVisibleText(strRes);
		Thread.sleep(5000);
		String selectedOption = selectByVisibleText.getFirstSelectedOption()
				.getText();
		System.out.println(selectedOption);
		assertEquals(strRes, selectedOption,
				"resources not found in drop down");
		return this;

	}
	/**********************************************************************************
	* Description :  This function is to enter ETA
	* Date 		  : 23/07/2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public IncomingPatientNotifications enterETA(int strETR)
			throws Exception {
		String ETR=String.valueOf(strETR);
		objWaitForElement.waitForElements(strETA, "css");
		this.page.element(strETA, "css").clearInputValue().sendKeys(ETR);
		
		return this;
	}	
	/**********************************************************************************
	* Description :  This function is to verify "Incoming Patient Notification has been sent" notification
	* Date 		  : 23/07/2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public IncomingPatientNotifications verIPNnotification() throws Exception {
		objWaitForElement.waitForElements(strNotify, "xpath");
		assertTrue(this.page.element(strNotify, "xpath").isElementPresent(),
				"no Notification present");
		return this;
	}

	/**********************************************************************************
	* Description :  This function is to verify "Incoming Patient Notification has been sent" notification
	* Date 		  : 23/07/2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public IncomingPatientNotifications verIPNDetailesAreNotDispayedInIPNLast24HrPage(
			String strAckBy) throws Exception {

		String ackBy = "//table[@summary='Incoming Patient Notifications In Last 24 Hours']/tbody/tr/td[text()='"
				+ strAckBy + "']";
		objWaitForElement.waitForElements(ackBy, "xpath");
		assertFalse(
				this.page.element(ackBy, "xpath").isElementPresent(
						WaitTimeConstants.WAIT_TIME_TOO_SMALL),
				"Patient detailes dispalyed in IPNpage");
		return this;
	}

	/**********************************************************************************
	* Description :  This function is to verify "Incoming Patient Notification has been sent" notification
	* Date 		  : 23/07/2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public IncomingPatientNotifications verIPNDetailesInIPNLast24HrPage(
			String strAckBy, String[] strPatientData) throws Exception {
		
		String atrDetailes = "//table[@summary='Incoming Patient Notifications In Last 24 Hours']/tbody/tr/td[text()='"
				+ strAckBy + "']";
		objWaitForElement.waitForElements(atrDetailes, "xpath");

		for (int i = 0; i <= strPatientData.length - 1; i++) {
			String ackBy = "//table[@summary='Incoming Patient Notifications In Last 24 Hours']/tbody/tr/td[text()='"
					+ strAckBy
					+ "']/preceding-sibling::td[text()='"
					+ strPatientData[i] + "']";
			
			System.out.println(ackBy);

			assertTrue(
					this.page.element(ackBy, "xpath").getOne().isDisplayed(),
					"Patient detaile " + strPatientData[i]
							+ " is not dispalyed in IPNpage");
		}

		return this;

	}
	
	/**********************************************************************************
	* Description :  This function is to verify "Incoming Patient Notification has been sent" notification
	* Date 		  : 23/07/2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public String getETADateAndTime(String strAckBy) throws Exception {

		String atrDetailes = "//table[@summary='Incoming Patient Notifications In Last 24 Hours']/tbody/tr/td[text()='"
				+ strAckBy + "']";
		objWaitForElement.waitForElements(atrDetailes, "xpath");

		String ackBy = "//table[@summary='Incoming Patient Notifications In Last 24 Hours']/tbody/tr/td[text()='"
				+ strAckBy + "']/preceding-sibling::td[8]";
		String strExactETA = this.page.element(ackBy, "xpath").getOne()
				.getText();
		return strExactETA;

	}

	
	
	/**********************************************************************************
	* Description 	: This function is to verify ETA details in 
	*                 'Incoming Patient Notifications In Last 24 Hours' page 
	* Date 			: 09-sep-2015
	* Author 		: Sandhya M B
	**********************************************************************************/
	public IncomingPatientNotifications verETAInIPN(String sentBy, String ETA)
			throws Exception {

		String ETAEle="//table[@class='displayTable striped border sortable']/tbody/tr/td[1][contains(text(),'" + sentBy +"')]/parent::tr/td[3][contains(text(),'"+ ETA +"')]";

		assertTrue(this.page.element(ETAEle, "xpath").isElementPresent());

		return this;

	}
	
	/**********************************************************************************
	* Description 	: This function is to verify complaint details in 
	*                 'Incoming Patient Notifications In Last 24 Hours' page 
	* Date 			: 09-sep-2015
	* Author 		: Sandhya M B
	**********************************************************************************/
	public IncomingPatientNotifications vercomplaintInIPN(String sentBy,
			String complaint) throws Exception {

		String complaintEle = "//table[@class='displayTable striped border sortable']/tbody/tr/td[1][contains(text(),'"
				+ sentBy
				+ "')]/parent::tr/td[4][contains(text(),'"
				+ complaint
				+ "')]";

		assertTrue(this.page.element(complaintEle, "xpath").isElementPresent());

		return this;

	}
	
	/**********************************************************************************
	* Description 	: This function is to verify triage details in 
	*                 'Incoming Patient Notifications In Last 24 Hours' page 
	* Date 			: 09-sep-2015
	* Author 		: Sandhya M B
	**********************************************************************************/
	public IncomingPatientNotifications verTriageInIPN(String sentBy, String triage)
			throws Exception {

		String triageEle = "//table[@class='displayTable striped border sortable']/tbody/tr/td[1][contains(text(),'"
				+ sentBy
				+ "')]/parent::tr/td[5][contains(text(),'"
				+ triage
				+ "')]";

		assertTrue(this.page.element(triageEle, "xpath").isElementPresent());

		return this;

	}
	
	/**********************************************************************************
	* Description 	: This function is to verify gender details in 
	*                 'Incoming Patient Notifications In Last 24 Hours' page 
	* Date 			: 09-sep-2015
	* Author 		: Sandhya M B
	**********************************************************************************/
	public IncomingPatientNotifications verGenderInIPN(String sentBy, String gender)
			throws Exception {

		String genderEle = "//table[@class='displayTable striped border sortable']/tbody/tr/td[1][contains(text(),'"
				+ sentBy
				+ "')]/parent::tr/td[6][contains(text(),'"
				+ gender
				+ "')]";

		assertTrue(this.page.element(genderEle, "xpath").isElementPresent());

		return this;

	}
	
	/**********************************************************************************
	* Description 	: This function is to verify resource details in
	*                 'Incoming Patient Notifications In Last 24 Hours' page 
	* Date 			: 09-sep-2015
	* Author 		: Sandhya M B
	**********************************************************************************/
	public IncomingPatientNotifications verResourceInIPN(String sentBy, String resource)
			throws Exception {

		String resourceEle = "//table[@class='displayTable striped border sortable']/tbody/tr/td[1][contains(text(),'"
				+ sentBy
				+ "')]/parent::tr/td[7][contains(text(),'"
				+ resource
				+ "')]";

		assertTrue(this.page.element(resourceEle, "xpath").isElementPresent());

		return this;

	}
	
	/**********************************************************************************
	* Description 	: This function is to verify region details in 
	*                 'Incoming Patient Notifications In Last 24 Hours' page 
	* Date 			: 09-sep-2015
	* Author 		: Sandhya M B
	**********************************************************************************/
	public IncomingPatientNotifications verRegionInIPN(String sentBy, String region)
			throws Exception {

		String regionEle = "//table[@class='displayTable striped border sortable']/tbody/tr/td[1][contains(text(),'"
				+ sentBy
				+ "')]/parent::tr/td[8][contains(text(),'"
				+ region
				+ "')]";

		assertTrue(this.page.element(regionEle, "xpath").isElementPresent());

		return this;

	}
	
	/**********************************************************************************
	* Description 	: This function is to verify acknowledgedBy details in
	*                 'Incoming Patient Notifications In Last 24 Hours' page 
	* Date 			: 09-sep-2015
	* Author 		: Sandhya M B
	**********************************************************************************/
	public IncomingPatientNotifications verAcknowledgedByInIPN(String sentBy, String acknowledgedBy) throws Exception {

		String acknowledgedByEle = "//table[@class='displayTable striped border sortable']/tbody/tr/td[1][contains(text(),'"
				+ sentBy
				+ "')]/parent::tr/td[9][contains(text(),'"
				+ acknowledgedBy + "')]";

		assertTrue(this.page.element(acknowledgedByEle, "xpath")
				.isElementPresent());

		return this;

	}
	
	/**********************************************************************************
	* Description 	: This function is to verify acknowledgementDate details in 
	*                 'Incoming Patient Notifications In Last 24 Hours' page 
	* Date 			: 09-sep-2015
	* Author 		: Sandhya M B
	**********************************************************************************/
	public IncomingPatientNotifications verAcknowledgementDateInIPN(String sentBy,
			String acknowledgementDate, String acknowledgementDate1)
			throws Exception {

		String acknowledgementDateEle = "//table[@class='displayTable striped border sortable']/tbody/tr/td[1][contains(text(),'"
				+ sentBy
				+ "')]/parent::tr/td[10][contains(text(),'"
				+ acknowledgementDate + "')]";
		String acknowledgementDateEle1 = "//table[@class='displayTable striped border sortable']/tbody/tr/td[1][contains(text(),'"
				+ sentBy
				+ "')]/parent::tr/td[10][contains(text(),'"
				+ acknowledgementDate1 + "')]";

		assertTrue(this.page.element(acknowledgementDateEle, "xpath")
				.isElementPresent()
				|| this.page.element(acknowledgementDateEle1, "xpath")
						.isElementPresent());
		return this;

	}	
	
	/**********************************************************************************
	* Description 	: This function is to verify 'Create new incoming patient notification' button is not available.
	* Date 			: 09-sep-2015
	* Author 		: Sandhya M B
	**********************************************************************************/
	public IncomingPatientNotifications verCreateNewIncomingPatientNotifnbuttonIsNotDisplayed()
			throws Exception {
		assertFalse(this.page.element(createNewIncomingPatientNotifnbutton,
				"xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to verify IPN details in 
	*                 'Incoming Patient Notifications In Last 24 Hours' page 
	* Date 			: 09-sep-2015
	* Author 		: Sandhya M B
	**********************************************************************************/
	public IncomingPatientNotifications verDetailsInIncomingPatientNotification(
			String sentBy, String age, String ETA, String complaint,
			String triage, String gender, String resource, String region,
			String acknowledgedBy, String acknowledgementDate,
			String acknowledgementDate1) throws Exception {
		assertTrue(this.page.element(
				incomingPatientNotificationsInLast24HoursPg, "xpath")
				.isElementPresent());
		verSentByInIPN(sentBy);
		verAgeInIPN(sentBy, age);
		verETAInIPN(sentBy, ETA);
		vercomplaintInIPN(sentBy, complaint);
		verTriageInIPN(sentBy, triage);
		verGenderInIPN(sentBy, gender);
		verResourceInIPN(sentBy, resource);
		verRegionInIPN(sentBy, region);
		verAcknowledgedByInIPN(sentBy, acknowledgedBy);
		verAcknowledgementDateInIPN(sentBy, acknowledgementDate,
				acknowledgementDate1);
		return this;

	}

	/**********************************************************************************
	* Description 	: This function is to verify sentby details in 
	*                 'Incoming Patient Notifications In Last 24 Hours' page 
	* Date 			: 09-sep-2015
	* Author 		: Sandhya M B
	**********************************************************************************/
	public IncomingPatientNotifications verSentByInIPN(String sentBy) throws Exception {
		String sentByEle = "//table[@class='displayTable striped border sortable']/tbody/tr/td[1][contains(text(),'"
				+ sentBy + "')]";
		assertTrue(this.page.element(sentByEle, "xpath").isElementPresent());
		return this;

	}
	
	/**********************************************************************************
	* Description 	: This function is to verify age details in 
	*                 'Incoming Patient Notifications In Last 24 Hours' page 
	* Date 			: 09-sep-2015
	* Author 		: Sandhya M B
	**********************************************************************************/
	public IncomingPatientNotifications verAgeInIPN(String sentBy, String age)
			throws Exception {

		String ageEle = "//table[@class='displayTable striped border sortable']/tbody/tr/td[1][contains(text(),'"
				+ sentBy
				+ "')]/parent::tr/td[2][contains(text(),'"
				+ age
				+ "')]";

		assertTrue(this.page.element(ageEle, "xpath").isElementPresent());

		return this;

	}
	
	/**********************************************************************************
	* Description :  This function is to Get ETA DAte & time for 2nd time
	* Date 		  : 23/07/2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public String getETADateAndTimeFor2NdTime(String strAckBy) throws Exception {

		String atrDetailes = "//table[@summary='Incoming Patient Notifications In Last 24 Hours']/tbody/tr/td[text()='"
				+ strAckBy + "']";
		objWaitForElement.waitForElements(atrDetailes, "xpath");

		String ackBy = "//table[@summary='Incoming Patient Notifications In Last 24 Hours']/tbody/tr/td[text()='"
				+ strAckBy
				+ "']/following::tr/td[text()='"
				+ strAckBy
				+ "']/preceding-sibling::td[6]";
		String strExactETA = this.page.element(ackBy, "xpath").getOne()
				.getText();
		return strExactETA;

	}
	
	/**********************************************************************************
	* Description 	: This function is to verify Configure Incoming Patient Notifications page 
	* Date 			: 09-sep-2015
	* Author 		:Sangappa k
	**********************************************************************************/
	public IncomingPatientNotifications verConfigureIncomingPatientNotificationsPage()
			throws Exception {
		objWaitForElement.waitForElements(IPNpage, "xpath");
		assertTrue(this.page.element(IPNpage, "xpath").isElementPresent());
		assertEquals(this.page.element(IPNpage, "xpath").getOne().getText(),
				"Configure Incoming Patient Notifications");
		return this;

	}
	
	/**********************************************************************************
	* Description 	: This function is to verify Manually Allow & enabled chk boxes 
	* Date 			: 02-Feb-2016
	* Author 		:Sangappa k
	**********************************************************************************/
	public IncomingPatientNotifications verManualAllowEntryAndEnabledChkBoxes()
			throws Exception {
		objWaitForElement.waitForElements(strManaulChkBox, "xpath");
		assertTrue(this.page.element(strManaulChkBox, "xpath").isElementPresent());
		assertTrue(this.page.element(strEnabled, "xpath").isElementPresent());
		return this;

	}
	
	/**********************************************************************************
	* Description :  This function is to Deselect IPN enabled checkbox is not selected
	* Date 		  : 2/5/2016
	* Author 	  : Sangappa K
	***********************************************************************************/
	public IncomingPatientNotifications deSelectEnabledCheckBox() throws Exception {
		
		objWaitForElement.waitForElements(strenabledCheckBox, "name");
		if(this.page.element(strenabledCheckBox, "name").getOne().isSelected()==true){
			this.page.element(strenabledCheckBox, "name").getOne().click();
		}	
		return this;
	}
	/**********************************************************************************
	* Description :  This function is to Deselect manual entry checkbox
	* Date 		  : 2/5/2016
	* Author 	  : Sangappa K
	***********************************************************************************/
	public IncomingPatientNotifications deSelectManualEntryCheckBox() throws Exception {
		
		objWaitForElement.waitForElements(strManualEntryCheckBox, "name");
		if(this.page.element(strManualEntryCheckBox, "name").getOne().isSelected()==true){
			this.page.element(strManualEntryCheckBox, "name").getOne().click();
		}	
		return this;
	}
	
	
	
	/**********************************************************************************
	* Description :  This function is to verify IPN Detailes not dispaled in last 24 Hr page
	* Date 		  : 23/07/2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public IncomingPatientNotifications verIPNDetailesAreNotDisplayedInIPNLast24HrPage(
			String strSentBy, String strSentAtTime,String strSentAtTime1)throws Exception {
		
		String strSentBYId = "//table[@summary='Incoming Patient Notifications In Last 24 Hours']/tbody/tr/td[text()='"
				+ strSentBy
				+ "']/preceding-sibling::td[text()='"
				+ strSentAtTime + "']";
		
		String strSentBYId1 = "//table[@summary='Incoming Patient Notifications In Last 24 Hours']/tbody/tr/td[text()='"
				+ strSentBy
				+ "']/preceding-sibling::td[text()='"
				+ strSentAtTime1 + "']";

		assertFalse(this.page.element(strSentBYId, "xpath").isElementPresent(
				WaitTimeConstants.WAIT_TIME_FOR_FALSE)||this.page.element(strSentBYId1, "xpath").isElementPresent(
						WaitTimeConstants.WAIT_TIME_FOR_FALSE));

		return this;

	}
	
	/**********************************************************************************
	* Description :  This function is to verify "Incoming Patient Notification has been sent" notification
	* Date 		  : 23/07/2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public IncomingPatientNotifications verIPNDetailesInIPNLast24HrPage1(
			String strSentBy, String[] strPatientData, String strSentAt, String strSentAt1,String strETA,String strETA1) throws Exception {
		
		String atrDetailes = "//table[@summary='Incoming Patient Notifications In Last 24 Hours']/tbody/tr/td[text()='"
				+ strSentBy + "']";
		objWaitForElement.waitForElements(atrDetailes, "xpath");

		for (int i = 0; i <= strPatientData.length - 1; i++) {
			String strIPNdata = "//table[@summary='Incoming Patient Notifications In Last 24 Hours']/tbody/tr/td[text()='"
					+ strSentBy
					+ "']/following-sibling::td[text()='"
					+ strPatientData[i] + "']";

			System.out.println(strIPNdata);

			assertTrue(this.page.element(strIPNdata, "xpath").getOne()
					.isDisplayed(), "Patient detaile " + strPatientData[i]
					+ " is not dispalyed in IPNpage");
		}

		String strETATime = "//table[@summary='Incoming Patient Notifications In Last 24 Hours']/tbody/tr/td[text()='"
				+ strSentBy + "']/following-sibling::td[1]";

		String strSentTime1 = "//table[@summary='Incoming Patient Notifications In Last 24 Hours']/tbody/tr/td[text()='"
				+ strSentBy + "']/preceding-sibling::td[1]";

		String sent = this.page.element(strSentTime1, "xpath").getOne()
				.getText();
		String eta = this.page.element(strETATime, "xpath").getOne().getText();

		assertTrue(eta.equals(strETA) || eta.equals(strETA1));
		assertTrue(sent.equals(strSentAt) || sent.equals(strSentAt1));
		
		return this;

	}
	
	/**********************************************************************************
	* Description :  This function is to verify incoming Patient Notifications
	* Date 		  : 2/5/2016
	* Author 	  : Anil
	***********************************************************************************/
	public IncomingPatientNotifications verifyIncomingPatientNotificationsLinkIsDisplayed() throws Exception {
		objWaitForElement.waitForElements(incomingPatientNotifications, "xpath");
		assertTrue(this.page.element(incomingPatientNotifications, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description :  This function is to verify add incoming patient Notification is displayed
	* Date 		  : 2/5/2016
	* Author 	  : Anil
	***********************************************************************************/
	public IncomingPatientNotifications verifyaddincomingpatientNotificationIsDisplayed() throws Exception {
		objWaitForElement.waitForElements(sendincomingpatientNotification, "xpath");
		assertTrue(this.page.element(sendincomingpatientNotification, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description :  This function is to get Arrival and sent timings for patient
	* Date 		  : 2/5/2016
	* Author 	  : Sangappa K
	***********************************************************************************/
	public String[] getArrivalAndSentTime(String strChiefComplnt ) throws Exception {
		String[] IPNTimes = new String[3];
		IPNTimes[0] = this.page.element("//td[text()='"+strChiefComplnt+"']/preceding-sibling::td[4]", "xpath").getOne().getText();
		IPNTimes[1] = this.page.element("//td[text()='"+strChiefComplnt+"']/preceding-sibling::td[2]", "xpath").getOne().getText();
		IPNTimes[2] = this.page.element("//td[text()='"+strChiefComplnt+"']/following-sibling::td[5]", "xpath").getOne().getText();
		return IPNTimes;
	}
	
}