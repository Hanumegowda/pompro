package lib.page;

import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import qaframework.lib.WaitTimeConstants;
import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;

public class eICSFunction extends PageObject {
	
	WebDriver driver;
	WaitForElement objWaitForElement ;

	private String eICSusername = "#UserName",  
			   	   eICspassword = "#Password",        
			   	   eICSloginLink = "//input[@name='LoginBtn']", 
			   	   responseCreateIncident = "https://eics.qa.intermedix.com/web/pages/response/createincident.aspx",
			   	   cretaeIncident = "#navbar_Navigation2_contentTitle",
			   	   facility = "#body_createIncidentFacilities",
			   	   excerciseRadioBtn = "#typeExerciseRadio",
			   	   next = "#nextPage",
			   	   incidentName = "#incidentName",
			   	   incidentDescription = "#incidentDescription",
			   	   activateIncident = "#page2Start",
			   	   incidentNameDetail = "#body_incidentName1",
			   	   incidentDescNameDetail = "#body_incidentDesc",
			   	   logoutLink ="//div[@id='header']/table/tbody/tr/td[3]/ul/li[3]/a",
			   	   allowStateRegToView = "#body_visibilityCheck",
			   	   logoutConfirmation = "//div[@id='confirmDialog']/following-sibling::div/div/button/span[text()='Yes']/parent::button",
			   	   homePageLink="img[alt=\"Home\"]",
			   	   allowStateRegToViewInPopUp = "#body_visibilityCheck",
			   	   editIncidentButton = "#editIncidentButton",
			   	   OKButton = "//button[@type='button']/span[@class='ui-button-text'][text()='OK']",
			   	   updateMyInfo = "#updateMyInfo",
			   	   planningContact = "https://eics.qa.intermedix.com/web/pages/planning/contacts.aspx",
			   	   addContact = "#body_addContactButton",
			   	   contactsFor = "#navbar_Navigation2_defaultFacilityList",
			   	   addNewContactFor = "#contactName",
			   	   firstName = "#body_firstName",
			   	   middleName = "#body_middleName",
			  	   lastName = "#body_lastName",
			  	   phone = "#Text1",
			  	   email = "#Text3",
			  	   enableUserAccount = "#body_newSystemAccess",
			  	   create = "#pageNewNext",
			  	   newUserId = "#newUserId",
			  	   iCSChart = "//ul[@id='tabArea']/li[2]/a/span[text()='ICS Chart']",
			  	   showallActive = "#body_showActiveCommandCheck",
			  	   positionName = "//div[@id='positionName']",
			  	   resposeTracker = "//div[@id='detailsAccordion']/h3[@id='responseTracker']/a",
			  	   assign = "//input[@id='assignButton']",
			  	   assignPositionWindow = "//div[@aria-describedby='confirmDialog']/div/span",
			  	   assignPosConfirmText = "#confirmDialog",
			  	   yesOFAssignPositionWindow = "//div[@aria-describedby='confirmDialog']/div[3]/div[1]/button",
			  	   noOFAssignPositionWindow = "//div[@aria-describedby='confirmDialog']/div[3]/div[1]/button[2]",
			  	   assignPositionNotify = "//input[@id='assignPositionNotify']",
			  	   icsPosition = "ICS Positions",
			  	   addOrRemICSPos = "#positionsContents>a",
			  	   okOfICSPosDrawer = "//div[@aria-describedby='selectDepthChartDialog']/div[3]/div/button[1]/span[text()='OK']",
			  	   activate = "//input[@id='activateButton']",
			  	   generalInfo = "General Info",
			  	   waitMsg = "//div[@id='WaitMessage']",
			  	   unassign = "//input[@id='unassignButton']",
			  	   unassignPositionWindow = "//div[@aria-describedby='confirmDialog']/div/span",
			  	   unassignPositionWindowMessage = "//div[@aria-describedby='confirmDialog']/div[2]/span",
			  	   yesOfUnassignPositionWindow = "//div[@aria-describedby='confirmDialog']/div[3]/div/button",
			  	   noOfUnassignPositionWindow = "//div[@aria-describedby='confirmDialog']/div[3]/div/button[2]",
			  	   facilityStatus="//ul[@id='tabArea']/li[8]/a/span[text()='Facility Status']",
			  	   endIncident = "#EndIncident",
			  	   closeIncident = "//input[@id='CloseIncident']",
			  	   closeIncidentWindow = "//div[@aria-describedby='confirmDialog']/div/span",
			  	   closeIncidentWindowMessage = "#confirmMessage",
			  	   yesOfcloseIncidentWindow = "//div[@aria-describedby='confirmDialog']/div[3]/div/button",
			  	   notifyByVoiceMasterOption = "#notifyByVoiceMaster",
			  	   notifyByEmailMasterOption = "#notifyByEmailMaster",
			  	   okOfSelectNotificationMethodWindow = "//div[@aria-describedby='SelectNotificationMethodDialog']/div[3]/div/button",
			  	   homeButton = "//img[@alt='Home']",
			  	   yesButton = "//div[6]/div[3]/div/button[1]",
			  	   testIncident = "https://eics.qa.intermedix.com/web/pages/response/conductincidenttest.aspx",
			  	   startTestButton= "//input[@id='startTest']",
			  	   emailNotifyCheckBox = "//table[@id='SelectNotificationMethodList']/tbody/tr[2]/td/input[@class='notifyByEmail']",
			  	   allowStateRegToViewInPopUpInEditInc = "#visibilityCheck",
			  	   selectNotificationMethodButton = "selectNotificationMethodButton",
			  	   byVoiceCheckBox = "//input[@id='notifyByVoiceMaster']",
			  	   byEmailCheckBox = "//input[@id='notifyByEmailMaster']",
			  	    OKbutton= "//div[@id='SelectNotificationMethodDialog']/following-sibling::div/div/button/span[text()='OK']";

	public eICSFunction(WebDriver _driver) throws Exception {
		super(_driver);	
		this.driver = _driver;
		objWaitForElement =  new WaitForElement(this.driver);
	}

	/***********************************************************************************
	 * Description	: This function is to launch the application URL
	 * Arguments	: none
	 * Date			: 10-10-2014
	 * Author		: Renushree
	 * ********************************************************************************/
	public eICSFunction launchEICSUrl() throws Exception {
		driver.get("https://eics.qa.intermedix.com/Web/login.aspx");
		objWaitForElement.waitForElements(eICSusername, "css");
		return this;
	}

	/**********************************************************************************
	 * Description	: This function is to login to the application
	 * Arguments	: strUsername, strPassword
	 * Date			: 10-10-2014
	 * Author		: Renushree
	 * ********************************************************************************/
	public eICSFunction loginToEICS(String strUsername, String strPassword)
			throws Exception {
		enterEICSUsername(strUsername);
		enterEICSPassword(strPassword);
		clickLoginLink();
		return this;
	}

	/**********************************************************************************
	 * Description	: This function is to enter Username in eics application
	 * Arguments	: strUsername
	 * Date			: 10-10-2014
	 * Author		: Renushree
	 *********************************************************************************/
	public eICSFunction enterEICSUsername(String strUsername) throws Exception {
		objWaitForElement.waitForElements(eICSusername, "css");
		this.page.element(eICSusername, "css").clearInputValue()
				.sendKeys(strUsername);
		assertEquals(strUsername, this.page.element(eICSusername, "css")
				.getOne().getAttribute("value"));
		return this;
	}

	/*********************************************************************************
	 * Description	: This function is to enter password
	 * Arguments	: strPassword
	 * Date			: 10-10-2014
	 * Author		: Renushree
	 * *******************************************************************************/
	public eICSFunction enterEICSPassword(String strPassword) throws Exception {
		objWaitForElement.waitForElements(eICspassword, "css");
		this.page.element(eICspassword, "css").clearInputValue().sendKeys(strPassword);
		assertEquals(strPassword, this.page.element(eICspassword, "css").getOne()
				.getAttribute("value"));
		return this;
	}

	/**********************************************************************************
	 * Description	: This function is to click on login button
	 * Arguments	: none
	 * Date			: 10-10-2014
	 * Author		: Renushree
	 * ********************************************************************************/
	public eICSFunction clickLoginLink() throws Exception {
		objWaitForElement.waitForElements(eICSloginLink, "xpath");
		this.page.element(eICSloginLink, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is to navigate to Response >> Create Incident
	 * Arguments	: None
	 * Date			: 10-10-2014
	 * Author		: Renushree
	 **********************************************************************************/
	public eICSFunction navigateToResCreateIncident() throws Exception {
		driver.get(responseCreateIncident);
		this.page.element_wait(waitMsg, "xpath").waitForInvisibilityOfElement();
		this.page.element(cretaeIncident, "css").isElementPresent();
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is to select facility 
	 * Arguments	: strFacilityName
	 * Date			: 10-10-2014
	 * Author		: Renushree
	 *********************************************************************************/
	public eICSFunction selFacility(String strFacilityName)
			throws Exception {
		objWaitForElement.waitForElements(facility, "css");
		this.page.element(facility, "css").webElementToSelect().selectByVisibleText(strFacilityName);
		return this;
	}
	
	/*************************************************************************************************
	 * Description	: This function is to click on Exercise/Drill radio button in create incident page
	 * Arguments	: None
	 * Date			: 10-10-2014
	 * Author		: Renushree
	 *************************************************************************************************
	 */
	public eICSFunction clkExerciseRadioBtn() throws Exception {
		Thread.sleep(2000);
		objWaitForElement.waitForElements(excerciseRadioBtn, "css");
		if(!(this.page.element(excerciseRadioBtn, "css").getOne().isSelected())){
			this.page.element(excerciseRadioBtn, "css").getOne().click();
			this.page.element(excerciseRadioBtn, "css").getOne().isSelected();
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is to click on irg and click next 
	 * Arguments	: strIrgName
	 * Date			: 10-10-2014
	 * Author		: Renushree
	 **********************************************************************************/
	public eICSFunction selIrgAndClkNext(String strIrgName) throws Exception {
		objWaitForElement.waitForElements(
				"//div/table[@id='irgList']/tbody/tr/td[text()='" + strIrgName
						+ "']", "xpath");
		assertTrue(this.page.element(
				"//div/table[@id='irgList']/tbody/tr/td[text()='" + strIrgName
						+ "']", "xpath").isElementPresent());
		this.page
				.element(
						"//div/table[@id='irgList']/tbody/tr/td[text()='"
								+ strIrgName + "']", "xpath").getOne().click();
		objWaitForElement.waitForElements(next, "css");
		this.page.element(next, "css").getOne().click();
		objWaitForElement.waitForElements(incidentName, "css");
		return this;
	}

	/**********************************************************************************
	 * Description	: This function is to provide incident name and incident description 
	 * Arguments	: strIncidentName, strIncDesc
	 * Date			: 10-10-2014
	 * Author		: Renushree
	 **********************************************************************************
	 */
	public eICSFunction provideIncidentDetails(String strIncidentName,
			String strIncDesc) throws Exception {
		this.page.element_wait(waitMsg, "xpath").waitForInvisibilityOfElement();
		objWaitForElement.waitForElements(incidentName, "css");
		this.page.element(incidentName, "css").clearInputValue().sendKeys(strIncidentName);
		this.page.element(incidentDescription, "css").clearInputValue().sendKeys(strIncDesc);
		System.out.println(strIncidentName);
		return this;
	}

	/**********************************************************************************
	 * Description	: This function is to activate incident
	 * Arguments	: driver
	 * Date			: 10-10-2014
	 * Author		: Renushree
	 **********************************************************************************
	 */
	public eICSFunction activateIncident() throws Exception {
		objWaitForElement.waitForElements(activateIncident, "css");
		this.page.element(activateIncident, "css").getOne().click();
		return this;
	}
	
    /**********************************************************************************
     * Description  : This function is to verify created incident details
     * Arguments  	: strIncidentName, strIncDesc
     * Date       	: 10-10-2014
     * Author  		: Renushree
     **********************************************************************************
     */
    public eICSFunction verCreatedIncidentDetails(
                  String strIncidentName, String strIncDesc) throws Exception {
    	this.page.element_wait(waitMsg, "xpath").waitForInvisibilityOfElement();
    	objWaitForElement.waitForElements(incidentNameDetail, "css");
    	Thread.sleep(30000);
    	assertEquals(strIncidentName, this.page.element(incidentNameDetail, "css").getOne().getText());
    	assertEquals(strIncDesc, this.page.element(incidentDescNameDetail, "css").getOne().getText());
       return this;
    }

    /**********************************************************************************
     * Description   : This function is to logout from the application
     * Arguments  	 : None
     * Date          : 10-10-2014
     * Author      	 : Renushree
     * *********************************************************************************
     */
    public eICSFunction logoutWithConfirmation() throws Exception {
    	objWaitForElement.waitForElements(logoutLink, "xpath");
    	this.page.element(logoutLink, "xpath").mouseOver();
    	this.page.element(logoutLink, "xpath").getOne().sendKeys(Keys.ENTER);
    	clkYesInLogoutConfirmationWin();
    	return this;
    }
    
    /*************************************************************************************
     * Description		: This function is used to click yes in logout confirmation window
     * Arguments  		: None
     * Date             : 10-10-2014
     * Author           : Renushree
     * ***********************************************************************************
     */
    public eICSFunction clkYesInLogoutConfirmationWin() throws Exception {
    	this.page.element(logoutConfirmation, "xpath").mouseOver();
    	this.page.element(logoutConfirmation, "xpath").getOne().click();
    	this.driver
		.manage()
		.timeouts()
		.pageLoadTimeout(WaitTimeConstants.LOGIN_COUNT,
				TimeUnit.SECONDS);
//    	objWaitForElement.waitForElements(updateMyInfo, "css");
    	return this;
    }
    
    /*******************************************************************************************
     * Description		: This function is used to click allow state reg to view incident chkbox 
     * Arguments  		: None
     * Date             : 10-10-2014
     * Author           : Renushree
     * *****************************************************************************************
     */
	public eICSFunction clkOnAllowStateRegToViewInc() throws Exception {
		objWaitForElement.waitForElements(allowStateRegToView, "css");
		if(this.page.element(allowStateRegToView, "css").getOne().isSelected()==false){
			this.page.element(allowStateRegToView, "css").getOne().click();
		}
		return this;
	}
	/**********************************************************************************
     * Description   : This function is to logout from the application
     * Arguments  	 : None
     * Date          : 10-10-2014
     * Author      	 : Renushree
     * *********************************************************************************
     */
    public eICSFunction navigateToHomePageWithConfirmation() throws Exception {
    	objWaitForElement.waitForElements(homePageLink, "css");
    	this.page.element(homePageLink, "css").mouseOver();
    	this.page.element(homePageLink, "css").getOne().click();
    	clkYesInLogoutConfirmationWin();
    	return this;
    }
    
    /**********************************************************************************************
     * Description		: This function is used to deselect allow state reg to view incident chkbox 
     * Arguments  		: None
     * Date             : 20-10-2014
     * Author           : Anil
     * ********************************************************************************************
     */
	public eICSFunction deselectAllowStateRegToViewIncindent() throws Exception {
		objWaitForElement.waitForElements(allowStateRegToViewInPopUp, "css");
		if(this.page.element(allowStateRegToViewInPopUp, "css").getOne().isSelected()==true){
			this.page.element(allowStateRegToViewInPopUp, "css").getOne().click();
		}
		return this;
	}
	
    /**********************************************************************************
     * Description		: This function is used to click on edit incident button
     * Arguments  		: None
     * Date             : 20-10-2014
     * Author           : Anil
     * ********************************************************************************
     */
    public eICSFunction clickOnEditIncidentButton() throws Exception {
    	objWaitForElement.waitForElements(editIncidentButton, "css");
    	this.page.element(editIncidentButton, "css").getOne().click();
    	return this;
    }
    
	
    /**********************************************************************************
     * Description		: This function is used to click on OK button
     * Arguments  		: None
     * Date             : 20-10-2014
     * Author           : Anil
     * *********************************************************************************
     */
    public eICSFunction clickOnOKButton() throws Exception {
    	objWaitForElement.waitForElements(OKButton, "xpath");
    	this.page.element(OKButton, "xpath").mouseOver();
    	this.page.element(OKButton, "xpath").getOne().click();
    	return this;
    }
    
    /**********************************************************************************
	 * Description	: This function is to navigate to Planning >> Contacts
	 * Arguments	: None
	 * Date			: 03-Nov-2014
	 * Author		: Renushree
	 **********************************************************************************
	 */
	public eICSFunction navigateToContacts() throws Exception {
		driver.get(planningContact);
		objWaitForElement.waitForElements(addContact, "css");
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is used to select facility or domain
	 * Arguments	: strFacilityName
	 * Date			: 03-Nov-2014
	 * Author		: Renushree
	 ***********************************************************************************/
	public eICSFunction selFacilityOrDomain(String strFacilityName)
			throws Exception {
		objWaitForElement.waitForElements(contactsFor, "css");
		String strSelectedVal = this.page.element(contactsFor, "css").webElementToSelect().getFirstSelectedOption().getText();
		if (strSelectedVal.equals(strFacilityName)) {

		} else {
			this.page.element(contactsFor, "css").webElementToSelect()
					.selectByVisibleText(strFacilityName);
			this.driver
			.manage()
			.timeouts()
			.implicitlyWait(WaitTimeConstants.WAIT_TIME_LONG2,
					TimeUnit.SECONDS);
			strSelectedVal = this.page.element(contactsFor, "css").webElementToSelect().getFirstSelectedOption().getText();
			assertTrue(strSelectedVal.equals(strFacilityName));
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is used to click on add new contact
	 * Arguments	: driver
	 * Date			: 03-Nov-2014
	 * Author		: Renushree
	 *********************************************************************************/
	public eICSFunction clkOnAddNewContact() throws Exception {
		objWaitForElement.waitForElements(addContact, "css");
		assertTrue(this.page.element(addContact, "css").isElementPresent());
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.document.getElementById('body_addContactButton').click();");
		assertTrue(this.page.element(addNewContactFor, "css").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is used to create contact
	 * Arguments	: strContactName,strMidName,strLastName,strContactUserId
	 * 				  strPhNo,strEmailID
	 * Date			: 03-Nov-2014
	 * Author		: Renushree
	 **********************************************************************************/
	public eICSFunction addContact(String strContactName, String strMidName,
			String strLastName, String strContactUserId, String strPhNo,
			String strEmailID) throws Exception {
		String strDisplayedConName = strLastName + ", " + strContactName + " "
				+ strMidName;
		enterContName(strContactName);
		enterMiddleName(strMidName);
		enterLastName(strLastName);
		enterPhoneNumber(strPhNo);
		enterEmailID(strEmailID);
		enableUserAcc();
		enterUserID(strContactUserId);
		clkOnCreate();
		this.page.element_wait(waitMsg, "xpath").waitForInvisibilityOfElement();
		assertEquals("Details for " + strDisplayedConName + "", driver
				.findElement(By.cssSelector(addNewContactFor)).getText());
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is used to enter contact name
	 * Arguments	: driver
	 * Date			: 03-Nov-2014
	 * Author		: Renushree
	 ***********************************************************************************/
	public eICSFunction enterContName(String strContactName) throws Exception {
		objWaitForElement.waitForElements(firstName, "css");
		driver.findElement(By.cssSelector(firstName)).sendKeys(strContactName);
		assertEquals(
				strContactName,
				this.page.element(firstName, "css").getOne().getAttribute(
						"value"));
		return this;
	}
	/**********************************************************************************
	 * Description	: This function is used to enter middle name
	 * Arguments	: strMidName
	 * Date			: 03-Nov-2014
	 * Author		: Renushree
	 *********************************************************************************/
	public eICSFunction enterMiddleName(String strMidName) throws Exception {
		objWaitForElement.waitForElements(middleName, "css");
		this.page.element(middleName, "css").getOne().sendKeys(strMidName);
		assertEquals(strMidName,this.page.element(middleName, "css").getOne()
				.getAttribute("value"));
		return this;
	}

	/**********************************************************************************
	 * Description	: This function is used to enter last name
	 * Arguments	: strMidName
	 * Date			: 03-Nov-2014
	 * Author		: Renushree
	 **********************************************************************************/
	public eICSFunction enterLastName(String strlastName)
			throws Exception {
		objWaitForElement.waitForElements(lastName, "css");
		this.page.element(lastName, "css").getOne().sendKeys(strlastName);
		assertEquals(strlastName, this.page.element(lastName, "css").getOne()
				.getAttribute("value"));
		return this;
	}

	/**********************************************************************************
	 * Description	: This function is used to enter contact phone number
	 * Arguments	: strPhNo
	 * Date			: 03-Nov-2014
	 * Author		: Renushree
	 **********************************************************************************/
	public eICSFunction enterPhoneNumber(String strPhNo) throws Exception {
		objWaitForElement.waitForElements(phone, "css");
		this.page.element(phone, "css").getOne().sendKeys(strPhNo);
		assertEquals(strPhNo, this.page.element(phone, "css").getOne()
				.getAttribute("value"));
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is used to enter contact email ID
	 * Arguments	: strEmailID
	 * Date			: 03-Nov-2014
	 * Author		: Renushree
	 **********************************************************************************/
	public eICSFunction enterEmailID(String strEmailID) throws Exception {
		objWaitForElement.waitForElements(email, "css");
		this.page.element(email, "css").getOne().sendKeys(strEmailID);
		assertEquals(strEmailID, this.page.element(email, "css").getOne()
				.getAttribute("value"));
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is used to enable user account
	 * Arguments	: driver
	 * Date			: 03-Nov-2014
	 * Author		: Renushree
	 **********************************************************************************/
	public eICSFunction enableUserAcc() throws Exception {
		objWaitForElement.waitForElements(enableUserAccount, "css");
		this.page.element(enableUserAccount, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is used to click on create
	 * Arguments	: driver
	 * Date			: 03-Nov-2014
	 * Author		: Renushree
	 **********************************************************************************/
	public eICSFunction clkOnCreate() throws Exception {
		objWaitForElement.waitForElements(create, "css");
		this.page.element(create, "css").getOne().click();
		this.driver
		.manage()
		.timeouts()
		.implicitlyWait(WaitTimeConstants.WAIT_TIME_LONG2,
				TimeUnit.SECONDS);
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is used to enter user id
	 * Arguments	: driver
	 * Date			: 03-Nov-2014
	 * Author		: Renushree
	 **********************************************************************************/
	public eICSFunction enterUserID(String strContactUserId) throws Exception {
		objWaitForElement.waitForElements(newUserId, "css");
		this.page.element(newUserId, "css").getOne()
				.sendKeys(strContactUserId);
		assertEquals(
				strContactUserId,
				this.page.element(newUserId, "css").getOne().getAttribute(
						"value"));
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is used to click on ICS chart tab
	 * Arguments	: None
	 * Date			: 03-Nov-2014
	 * Author		: Renushree
	 **********************************************************************************/
	public eICSFunction clkOnICSChartTab() throws Exception {
		objWaitForElement.waitForElements(iCSChart, "xpath");
		this.page.element(iCSChart, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is used to select position on ICS chart page
	 * Arguments	: strPosition
	 * Date			: 03-Nov-2014
	 * Author		: Renushree
	 **********************************************************************************/
	public eICSFunction selPosition(String strPosition)
			throws Exception {
		objWaitForElement.waitForElements("//span[text()='" + strPosition
				+ "']", "xpath");
		assertTrue(this.page.element("//span[text()='" + strPosition
				+ "']", "xpath").isElementPresent());
		this.page.element("//span[text()='" + strPosition
				+ "']", "xpath").mouseOver();
		this.page.element("//span[text()='" + strPosition
				+ "']", "xpath").getOne().click();
		this.page.element_wait(waitMsg, "xpath").waitForInvisibilityOfElement();
		assertEquals(strPosition, this.page.element(positionName, "xpath").getOne()
				.getText());
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is used to click on contact of ResponseTracker frame.
	 * Arguments	: strContactName
	 * Date			: 03-Nov-2014
	 * Author		: Renushree
	 **********************************************************************************/
	public eICSFunction selContactOnResposeTracker(
			String strContactName, String strMidName, String strLastName)
			throws Exception {
		String strDisplayedConName = strLastName + ", " + strContactName + " "
				+ strMidName;
		this.page.element("//table[@id='responseTrackerList']/tbody/tr/td[1][@title='"
						+ strDisplayedConName + "']", "xpath").isElementPresent();
		this.page.element("//table[@id='responseTrackerList']/tbody/tr/td[1][@title='"
		+ strDisplayedConName + "']/parent::tr/td[2]", "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is used to click on assign of ResponseTracker frame.
	 * Arguments	: None
	 * Date			: 03-Nov-2014
	 * Author		: Renushree
	 **********************************************************************************/
	public eICSFunction clkOnAssign() throws Exception {
		objWaitForElement.waitForElements(assign, "xpath");
		assertTrue(this.page.element(assign, "xpath").isElementPresent());
		this.page.element(assign, "xpath").mouseOver();
		this.page.element(assign, "xpath").getOne().click();
		this.switchToDefaultPage();
		assertTrue(this.page.element(assignPositionWindow, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is used to click on assign of ResponseTracker frame.
	 * Arguments	: strContactName, strPosition
	 * Date			: 03-Nov-2014
	 * Author		: Renushree
	 **********************************************************************************/
	public eICSFunction verAssignContactWindow(
			String strContactName, String strMidName, String strLastName,
			String strPosition) throws Exception {
		objWaitForElement.waitForElements(assignPositionWindow, "xpath");
		assertEquals("Assign Position",
				this.page.element(assignPositionWindow, "xpath").getOne().getText());
		String strDisplayedMsg = this.page.element(assignPosConfirmText, "css").getOne().getText();
		String strExpectedMsg = "Assign '"
				+ strLastName
				+ ", "
				+ strContactName
				+ " "
				+ strMidName
				+ "' to '"
				+ strPosition
				+ "'?\n\nSend voice notification   * Email notification is always sent.";
		assertTrue(strExpectedMsg.equals(strDisplayedMsg));
		assertTrue(this.page.element(yesOFAssignPositionWindow, "xpath").isElementPresent());
		assertTrue(this.page.element(noOFAssignPositionWindow, "xpath").isElementPresent());
		return this;
	}
	
	/************************************************************************************************
	 * Description	: This function is used to click on assign position notify check box and click ok
	 * Arguments	: None
	 * Date			: 03-Nov-2014
	 * Author		: Renushree
	 ************************************************************************************************/
	public eICSFunction clkOnAssignpositionNotifyAndClkYes()
			throws Exception {
		objWaitForElement.waitForElements(assignPositionNotify, "xpath");
		assertTrue(this.page.element(assignPositionNotify, "xpath").isElementPresent());
		this.page.element(assignPositionNotify, "xpath").mouseOver();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.document.getElementById('assignPositionNotify').click();");
		this.page.element(yesOFAssignPositionWindow, "xpath").mouseOver();
		this.page.element(yesOFAssignPositionWindow, "xpath").getOne().sendKeys(Keys.ENTER);
		return this;
	}
	
	/******************************************************************************************
	 * Description	: This function is used to click on save of update improvement item window.
	 * Arguments	: None
	 * Date			: 03-Nov-2014
	 * Author		: Renushree
	 ******************************************************************************************/
	public void switchToDefaultPage() throws Exception {
		driver.switchTo().defaultContent();
	}
	
	/**********************************************************************************
	 * Description	: This function is used to add a position to the created contact
	 * Arguments	: strPosition
	 * Date			: 03-Nov-2014
	 * Author		: Renushree
	 **********************************************************************************/
	public eICSFunction addOrRemovePositionToContact(String strPosition)
			throws Exception {
		navigateToICSPositionsDrawer();
		clickOnAddOrRemovePositionLink();
		if (this.page.element("//li/a[text()='" + strPosition
				+ "']/ins[@class='jstree-checkbox']/"
				+ "ancestor::li[contains(@class,'jstree-unchecked')]", "xpath").isElementPresent()) {
			this.page.element("//a[text()='" + strPosition
							+ "']/ins[@class='jstree-checkbox']", "xpath").getOne().click();
			this.page.element(okOfICSPosDrawer, "xpath").getOne().click();
			this.driver
			.manage()
			.timeouts()
			.implicitlyWait(WaitTimeConstants.COUNT,
					TimeUnit.SECONDS);
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is used to navigate to ICS position drawer
	 * Arguments	: None
	 * Date			: 03-Nov-2014
	 * Author		: Renushree
	 **********************************************************************************/
	public eICSFunction navigateToICSPositionsDrawer() throws Exception {
		this.page.element(icsPosition, "linktext").getOne().sendKeys(Keys.ENTER);
		assertTrue(this.page.element(addOrRemICSPos, "css").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is used to click on add or remove position link
	 * Arguments	: None
	 * Date			: 03-Nov-2014
	 * Author		: Renushree
	 **********************************************************************************/
	public eICSFunction clickOnAddOrRemovePositionLink()
			throws Exception {
		this.page.element(addOrRemICSPos, "css").getOne().sendKeys(Keys.ENTER);
		this.driver
		.manage()
		.timeouts()
		.implicitlyWait(WaitTimeConstants.COUNT,
				TimeUnit.SECONDS);
		return this;
	}
	
	/************************************************************************************
	 * Description	: This function is used to click on ResponseTracker of ICS chart page
	 * Arguments	: None
	 * Date			: 03-Nov-2014
	 * Author		: Renushree
	 ************************************************************************************/
	public eICSFunction clkOnResponseTracker()
			throws Exception {
		objWaitForElement.waitForElements(resposeTracker, "xpath");
		assertTrue(this.page.element(resposeTracker, "xpath").isElementPresent());
		this.page.element(resposeTracker, "xpath").mouseOver();
		this.page.element(resposeTracker, "xpath").getOne().sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is used to assign contact to a position
	 * Arguments	: None
	 * Date			: 03-Nov-2014
	 * Author		: Renushree
	 **********************************************************************************/
	public eICSFunction assignContactToAPositionInResTracker(
			String strContactName, String strMidName, String strLastName,
			String strPosition) throws Exception {
		selContactOnResposeTracker(strContactName, strMidName, strLastName);
		clkOnAssign();
		verAssignContactWindow(strContactName, strMidName, strLastName,
				strPosition);
		clkOnAssignpositionNotifyAndClkYes();
		this.page.element_wait(waitMsg, "xpath").waitForInvisibilityOfElement();
		return this;
	}
	
	/************************************************************************************
	 * Description	: This function is used to verify assigned contact is displayed under 
	 *                corresponding position
	 * Arguments	: strContactName, strPosition, strMidName, strLastName
	 * Date			: 03-Nov-2014
	 * Author		: Renushree
	 ************************************************************************************/
	public eICSFunction verAssignedContact(
			String strContactName, String strPosition, String strMidName,
			String strLastName) throws Exception {
		switchToICSChartFrame();
		String strDisplayedConName = strContactName + " " + strMidName + " "
				+ strLastName;
		assertTrue(this.page.element("//span[text()='" + strPosition
				+ "']/a[text()='" + strDisplayedConName + "']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is used to switch to ICS chart frame
	 * Arguments	: None
	 * Date			: 03-Nov-2014
	 * Author		: Renushree
	 **********************************************************************************/
	public void switchToICSChartFrame() throws Exception {
        driver.switchTo().frame("iframe_1");
        this.page.element(activate, "xpath").isElementPresent();
        assertTrue(this.page.element(generalInfo, "linktext").isElementPresent());
	}
	
	/**********************************************************************************
	 * Description	: This function is used to verify on ICS chart page
	 * Arguments	: None
	 * Date			: 03-Nov-2014
	 * Author		: Renushree
	 **********************************************************************************/
	public eICSFunction verICSChartPage() throws Exception {
		switchToICSChartFrame();
		objWaitForElement.waitForElements(showallActive, "css");
		assertTrue(this.page.element(showallActive, "css").isElementPresent());
		return this;
	}

	/**********************************************************************************
	 * Description	: This function is used to click on un assign of ICS chart page
	 * Arguments	: None
	 * Date			: 05-Nov-2014
	 * Author		: Renushree
	 **********************************************************************************/
	public eICSFunction clkOnUnassign() throws Exception {
		objWaitForElement.waitForElements(unassign, "xpath");
		assertTrue(this.page.element(unassign, "xpath").isElementPresent());
		this.page.element(unassign, "xpath").getOne().sendKeys(Keys.ENTER);
		switchToDefaultPage();
		assertTrue(this.page.element(unassignPositionWindow, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is used to click on GeneralInfo of ICS chart page
	 * Arguments	: None
	 * Date			: 05-Nov-2014
	 * Author		: Renushree
	 **********************************************************************************/
	public eICSFunction clkOnGeneralInfo() throws Exception {
		switchToICSChartFrame();
		objWaitForElement.waitForElements(generalInfo, "linktext");
		assertTrue(this.page.element(generalInfo, "linktext").isElementPresent());
		this.page.element(generalInfo, "linktext").getOne().sendKeys(Keys.ENTER);
		assertTrue(this.page.element(unassign, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is used to click on yes of unassign position window
	 * Arguments	: strPosition
	 * Date			: 05-Nov-2014
	 * Author		: Renushree
	 **********************************************************************************/
	public eICSFunction verUnassignPositionWindow(
			String strPosition) throws Exception {
		objWaitForElement.waitForElements(unassignPositionWindow, "xpath");
		assertEquals("Unassign Position",
				this.page.element(unassignPositionWindow, "xpath").getOne().getText());
		assertEquals(
				"Are you sure you want to unassign '" + strPosition + "'?",
				this.page.element(unassignPositionWindowMessage, "xpath").getOne().getText());
		assertTrue(this.page.element(yesOfUnassignPositionWindow, "xpath").isElementPresent());
		assertTrue(this.page.element(noOfUnassignPositionWindow, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is used to click on GeneralInfo of ICS chart page
	 * Arguments	: strPosition
	 * Date			: 05-Nov-2014
	 * Author		: Renushree
	 **********************************************************************************/
	public eICSFunction clkOnYesOfUnassignPositionWindow()
			throws Exception {
		objWaitForElement.waitForElements(yesOfUnassignPositionWindow, "xpath");
		this.page.element(yesOfUnassignPositionWindow, "xpath").getOne().sendKeys(Keys.ENTER);
		this.page.element_wait(waitMsg, "xpath").waitForInvisibilityOfElement();
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is used to verify unassigned contact is NOT displayed 
	 *                under corresponding position
	 * Arguments	: strContactName, strPosition, strMidName, strLastName
	 * Date			: 05-Nov-2014
	 * Author		: Renushree
	 **********************************************************************************/
	public eICSFunction verUnAssignedContact(
			String strContactName, String strPosition, String strMidName,
			String strLastName) throws Exception {
		switchToICSChartFrame();
		String strDisplayedConName = strContactName + " " + strMidName + " "
				+ strLastName;
		assertFalse(this.page.element("//span[text()='" + strPosition + "']/a[text()='"
				+ strDisplayedConName + "']", "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/***************************************************************************************
	 * Description	: This function is used to click on view link of corresponding incident.
	 * Arguments	: strIncidentName
	 * Date			: 05-Nov-2014
	 * Author		: Renushree
	 ****************************************************************************************/
	public eICSFunction clkOnViewOfIncident(String strIncidentName)
			throws Exception {
		String strIncident = "//table[@id='incidentList']/tbody/tr/td[4][@title='"
				+ strIncidentName
				+ "']/parent::tr/td[@title='View']/a[text()='View']";
		objWaitForElement.waitForElements(strIncident, "xpath");
		this.page.element(strIncident, "xpath").mouseOver();
		this.page.element(strIncident, "xpath").getOne().click();
		this.page.element_wait(waitMsg, "xpath").waitForInvisibilityOfElement();
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is used to click on Facility status tab
	 * Arguments	: None
	 * Date			: 10-Nov-2014
	 * Author		: Anitha
	 **********************************************************************************/
	public eICSFunction clkOnFacilityStatusTab() throws Exception {
		objWaitForElement.waitForElements(facilityStatus, "xpath");
		this.page.element(facilityStatus, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is used to verify statuses value in section table
	 * Arguments	: None
	 * Date			: 10-Nov-2014
	 * Author		: Anitha
	 **********************************************************************************/
	public eICSFunction verifyupdateValueInIncidentPage(String strSecValue,
			String strStatTypeName, String strUpdateStatusValue)
			throws Exception {
		objWaitForElement.waitForElements("//table[@id='stGroup" + strSecValue + "']", "xpath");
		this.page
				.element(
						"//table[@id='stGroup" + strSecValue
								+ "']/tbody/tr/td/a[text()='" + strStatTypeName
								+ "']"
								+ "/parent::td/following-sibling::td[text()='"
								+ strUpdateStatusValue + "']", "xpath")
				.getOne().isDisplayed();
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is used to switch to Facility status frame
	 * Arguments	: None
	 * Date			: 03-Nov-2014
	 * Author		: Renushree
	 **********************************************************************************/
	public eICSFunction switchToFacStatusFrame() throws Exception {
        driver.switchTo().frame("iframe_7");
        return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is used to verify last updated for expired status types is displayed as red color after time expires
	 * Arguments	: None
	 * Date			: 03-Nov-2014
	 * Author		: Renushree
	 ***********************************************************************************/
	public eICSFunction verLastUpdateForExpiredStatusTypes(String strSecVal,
			String strStatusTypeName, String strUpdatedVal,
			String strUpdatedTime) throws Exception {
		objWaitForElement.waitForElements("//table[@id='stGroup" + strSecVal
				+ "']/tbody/tr/td/a[text()='" + strStatusTypeName
				+ "']/parent::td/following-sibling::td[text()='"
				+ strUpdatedVal
				+ "']/following-sibling::td[2][@class='overdue'][text()='"
				+ strUpdatedTime + "']", "xpath");
		assertTrue(
				this.page
						.element(
								"//table[@id='stGroup"
										+ strSecVal
										+ "']/tbody/tr/td/a[text()='"
										+ strStatusTypeName
										+ "']/parent::td/following-sibling::td[text()='"
										+ strUpdatedVal
										+ "']/following-sibling::td[2][@class='overdue'][text()='"
										+ strUpdatedTime + "']", "xpath")
						.isElementPresent(),
				"LastUpdated is not displayed in red color");
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is to verify home page
	 * Arguments	: None
	 * Date			: 13-Dec-2013
	 * Author		: Renushree
	 **********************************************************************************/
	public eICSFunction verHomePage() throws Exception {
		do {
			Thread.sleep(1000);
		} while ("Loading...".equals(driver.findElement(
				By.cssSelector("#NoData")).getText()));
		this.page.element_wait(updateMyInfo, "css");
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is used to click on Facility status tab
	 * Arguments	: None
	 * Date			: 10-Nov-2014
	 * Author		: Anitha
	 **********************************************************************************/
	public eICSFunction clickOnViewLink(String strFacilityName) throws Exception {
		Actions action = new Actions(driver);
		String facility = "//table[@id='incidentList']/tbody/tr/td[3]/div[text()='"+strFacilityName+"']/parent::td/preceding-sibling::td[2]/a[text()='View']";
		this.page.element(facility, "xpath").isElementPresent();
		action.moveToElement(driver.findElement(By.xpath(facility))).click().build().perform();
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is used to click on Facility status tab
	 * Arguments	: None
	 * Date			: 10-Nov-2014
	 * Author		: Anil
	 **********************************************************************************/
	public eICSFunction clickOnEndIncident() throws Exception {
		objWaitForElement.waitForElements(endIncident, "css");
		this.page.element(endIncident, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is used to verify incident is ended.
	 * Arguments	: driver
	 * Date			: 20-Nov-2014
	 * Author		: Anil
	 **********************************************************************************/
	public eICSFunction verIncidentIsEnded() throws Exception {
		objWaitForElement.waitForElements(closeIncident, "css");
		this.page.element_wait(closeIncident, "xpath").waitForElementEnable();
		assertTrue(this.page.element(closeIncident, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is used to click on close incident.
	 * Arguments	: driver
	 * Date			: 20-Nov-2014
	 * Author		: Anil
	 **********************************************************************************/
	public eICSFunction clkOnCloseIncident() throws Exception {
		objWaitForElement.waitForElements(closeIncident, "xpath");
		assertTrue(this.page.element(closeIncident, "xpath").getOne().isDisplayed());
		assertTrue(this.page.element(closeIncident, "xpath").getOne().isEnabled());	
		driver.findElement(By.xpath(closeIncident)).sendKeys(Keys.ENTER);
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is used to verify close incident window.
	 * Arguments	: driver
	 * Date			: 20-Nov-2014
	 * Author		: Anil
	 **********************************************************************************/
	public eICSFunction verCloseIncidentWindow()
			throws Exception {
		assertEquals("Close Incident",
				driver.findElement(By.xpath(closeIncidentWindow)).getText());		
		this.page.element_wait(closeIncidentWindowMessage, "css");
		assertEquals(
				"Closing an incident will prevent facility staff from making changes."
						+ "\n\nAre you sure you want to close the incident?",
				driver.findElement(By.cssSelector(closeIncidentWindowMessage))
						.getText());
		this.page.element_wait(closeIncidentWindowMessage, "css");
		
		this.page.element_wait(yesOfcloseIncidentWindow,"css");
		this.page.element_wait(yesOfcloseIncidentWindow,"css");
		return this;
	}
	
	
	/**********************************************************************************
	 * Description	: This function is used to verify close incident window.
	 * Arguments	: driver
	 * Date			: 20-Nov-2014
	 * Author		: Anil
	 **********************************************************************************/
	public eICSFunction clkYesOnCloseIncidentWindow() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(
				driver.findElement(By.xpath(yesOfcloseIncidentWindow))).click()
				.build().perform();
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is used to verify close incident window.
	 * Arguments	: driver
	 * Date			: 20-Nov-2014
	 * Author		: Anil
	 **********************************************************************************/
	public eICSFunction deselectAndClickOK() throws Exception {
		objWaitForElement.waitForElements(notifyByVoiceMasterOption, "css");
		this.page.element(notifyByVoiceMasterOption, "css").getOne().sendKeys(Keys.SPACE);
		this.page.element(notifyByEmailMasterOption, "css").getOne().sendKeys(Keys.SPACE);
		driver.findElement(By.xpath(okOfSelectNotificationMethodWindow))
		.click();
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is used to verify close incident window.
	 * Arguments	: driver
	 * Date			: 20-Nov-2014
	 * Author		: Anil
	 **********************************************************************************/
	public eICSFunction navigateToHomePage() throws Exception {
		  Actions moveTO = new Actions(driver);
		  moveTO.moveToElement(driver.findElement(By.xpath(homeButton))).click()
		    .build().perform();
		return this;
	}
	
	public eICSFunction clkYesToNavigateHomePage() throws Exception {
		  try {
			  this.page.element_wait(yesButton, "xpath");
		   driver.findElement(By.xpath(yesButton)).click();
		  }
		  catch (AssertionError e) {
		   navigateToHomePage();
		   clkYesToNavigateHomePage();
		  }
		  return this;
		 }
	/*****************************************************************************
     * Description		: This function is used to click on OK button
     * Arguments  		: None
     * Date             : 21-11-2014
     * Author           : Anil
     * ***************************************************************************/
	public eICSFunction clickOnICSIconForResource(String strResValue,
			String strResName, String strIconName) throws Exception {
		objWaitForElement.waitForElements(
				"//a[@id='r_" + strResValue + "']" + "[text()='"
						+ strResName
						+ "']/following-sibling::a[@id='r_"
						+ strResValue + "']/img[@src='" + strIconName
						+ "']", "xpath");
		this.page
		.element(
				"//a[@id='r_" + strResValue + "']" + "[text()='"
						+ strResName
						+ "']/following-sibling::a[@id='r_"
						+ strResValue + "']/img[@src='" + strIconName
						+ "']", "xpath").getOne().isDisplayed();
		this.page
				.element(
						"//a[@id='r_" + strResValue + "']" + "[text()='"
								+ strResName
								+ "']/following-sibling::a[@id='r_"
								+ strResValue + "']/img[@src='" + strIconName
								+ "']", "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is used to verify statuses value, its corresponding 
	 * 				  comments and Last Updated time under section table
	 * Arguments	: strSectionValue, strStatTypeName, strUpdateStatusValue, strComments,
	 * Date			: 25-Mar-2015
	 * Author		: Pallavi
	 **********************************************************************************/
	public eICSFunction verifyupdateValueInIncidentPage(String strSecValue,
			String strStatTypeName, String strUpdateStatusValue,
			String strComments, String strUpdatedTime) throws Exception {
		objWaitForElement.waitForElements("//table[@id='stGroup" + strSecValue + "']", "xpath");
		String strWebEle = "//table[@id='stGroup" + strSecValue
				+ "']/tbody/tr/td/a[text()='" + strStatTypeName + "']"
				+ "/parent::td/following-sibling::td";
		this.page
				.element(strWebEle + "[text()='" + strUpdateStatusValue + "']",
						"xpath").getOne().isDisplayed();
		this.page
				.element(strWebEle + "[text()='" + strComments + "']", "xpath")
				.getOne().isDisplayed();
		this.page
				.element(strWebEle + "[text()='" + strUpdatedTime + "']",
						"xpath").getOne().isDisplayed();
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is used to click on Facility status tab
	 * Arguments	: None
	 * Date			: 10-Nov-2014
	 * Author		: Anil
	 **********************************************************************************/
	public boolean verifyFacilityName(String strFacilityName) throws Exception {
		boolean boolCheck = false;
		String facility = "//table[@id='incidentList']/tbody/tr/td[3]/div[text()='"+strFacilityName+"']";
		boolCheck = this.page.element(facility, "xpath").isElementPresent();	
		return boolCheck;
	}
	

    /**********************************************************************************
     * Description   : This function is to logout from the application
     * Arguments  	 : None
     * Date          : 10-10-2014
     * Author      	 : Anil
     * ********************************************************************************/
    public eICSFunction logoutWithoutConfirmation() throws Exception {
    	objWaitForElement.waitForElements(logoutLink, "xpath");
    	this.page.element(logoutLink, "xpath").mouseOver();
    	this.page.element(logoutLink, "xpath").getOne().sendKeys(Keys.ENTER);
    	return this;
    }
    
	/**********************************************************************************
	 * Description	: This function is to navigate to Response >> Test Incident
	 * Arguments	: None
	 * Date			: 10-10-2014
	 * Author		: Anil
	 **********************************************************************************/
	public eICSFunction navigateToResCreateTestIncident() throws Exception {
		driver.get(testIncident);
		this.page.element_wait(waitMsg, "xpath").waitForInvisibilityOfElement();
		this.page.element(startTestButton, "xpath").isElementPresent();
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is used to verify close incident window.
	 * Arguments	: driver
	 * Date			: 20-Nov-2014
	 * Author		: Anil
	 *********************************************************************************/
	public eICSFunction deselectNotificationCheckBox() throws Exception {
		objWaitForElement.waitForElements(notifyByVoiceMasterOption, "css");
		this.page.element(notifyByVoiceMasterOption, "css").getOne().click();
		this.page.element(notifyByEmailMasterOption, "css").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description	: This function is used to clickon initiate test buttin
	 * Arguments	: driver
	 * Date			: 20-Nov-2014
	 * Author		: Anil
	 *********************************************************************************/
	public eICSFunction clickOnInitiateTest() throws Exception {
		objWaitForElement.waitForElements(startTestButton, "xpath");
		this.page.element(startTestButton, "xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description	: This function is used to select one email notify checkbox
	 * Arguments	: driver
	 * Date			: 20-Nov-2014
	 * Author		: Anil
	 *********************************************************************************/
	public eICSFunction selectOneemailNotifyCheckBox() throws Exception {
		objWaitForElement.waitForElements(emailNotifyCheckBox, "xpath");
		this.page.element(emailNotifyCheckBox, "xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description	: This function is used to verify close incident window.
	 * Arguments	: driver
	 * Date			: 20-Nov-2014
	 * Author		: Anil
	 ***********************************************************************************/
	public eICSFunction verifyTestIncidentFacilityName(String strFacilityName)
			throws Exception {
		String strElement = "//span[@id='body_headerFacilityName'][text()='"
				+ strFacilityName + " Test Incident Administration']";
		objWaitForElement.waitForElements(strElement, "xpath");
		assertTrue(this.page.element(strElement, "xpath").isElementPresent());
		return this;
	}

	/**********************************************************************************
	 * Description	: This function is used to verify close incident window.
	 * Arguments	: driver
	 * Date			: 20-Nov-2014
	 * Author		: Anil
	 **********************************************************************************/
	public boolean verifyTestIncidentIsDisplayed() throws Exception {
		String strElement = "//span[@id='body_headerFacilityName'][contains(text(),'Test Incident Administration')]";
		boolean boolcheck = this.page.element(strElement, "xpath")
				.isElementPresent();
		if (boolcheck == true) {
			this.page.element("//input[@id='endTest']", "xpath").getOne()
					.click();
			driver.findElement(By.xpath("//button[@type='button']")).click();
		}
		return boolcheck;
	}

	/***********************************************************************************
	 * Description	: This function is used to verify Incident summary page is displayed
	 * Arguments	: None
	 * Date			: 26-Mar-2015
	 * Author		: Pallavi
	 **********************************************************************************/
	public boolean verifyIncidentSummaryPageIsDisplayed() throws Exception {
		String strElement = "//span[@id='body_headerFacilityName']";
		boolean boolcheck = this.page.element(strElement, "xpath")
				.isElementPresent();
		return boolcheck;
	}

    /********************************************************************************************
     * Description		: This function is used to DeSelect 'Allow State/Region to view incident' 
     * 					  checkbox while creating incident 
     * Arguments  		: None
	 * Date				: 26-Mar-2015
	 * Author			: Pallavi
     * ******************************************************************************************/
	public eICSFunction deSelAllowStateRegToViewInc() throws Exception {
		objWaitForElement.waitForElements(allowStateRegToView, "css");
		if (this.page.element(allowStateRegToView, "css").getOne().isSelected() == true) {
			this.page.element(allowStateRegToView, "css").getOne().click();
		}
		return this;
	}

    /***************************************************************************************************
     * Description		: This function is used to Select 'Allow State/Region to view incident' checkbox 
     * Arguments  		: None
	 * Date				: 26-Mar-2015
	 * Author			: Pallavi
     * *************************************************************************************************/
	public eICSFunction selAllowStateRegToViewIncindent() throws Exception {
		objWaitForElement.waitForElements(allowStateRegToViewInPopUp, "css");
		if (this.page.element(allowStateRegToViewInPopUp, "css").getOne()
				.isSelected() == false) {
			this.page.element(allowStateRegToViewInPopUp, "css").getOne()
					.click();
		}
		return this;
	}
	
	
	/**********************************************************************************
	 * Description 	: This function is used to get ICS notification notification body
	 * Date 		: 24-Nov-2014
	 * Author 		: Anil
	 * *******************************************************************************/
	public String getICSNotificationBody(String strResourceName, String strIncidentName, String strIncidentDesc) throws Exception {
		String strMsgBody = "*** THIS IS AN ACTUAL INCIDENT *** This message is to inform you that "
				+ strResourceName
				+ " is experiencing "
				+ strIncidentName
				+ ". "
				+ strIncidentDesc
				+ ". * Contact your facility with any questions. Do not reply directly to this email. "
				+ "For information on how to unsubscribe from or change your EMResource system notifications, "
				+ "click on the following link "
				+ "https://emresource.qa.intermedix.com/resources/help/EMResourceNotificationPreferences.html";
			return strMsgBody;
	}
	
	/**********************************************************************************
	 * Description 	: This function is get ICS header name
	 * Date 		: 18-Jun-2014
	 * Author 		: Anil
	 * ********************************************************************************
	 */
	public String getICSNotificationSubject(String strResourceName) throws Exception {
		String  strSubjectName = "Incident Alert for "
				+ strResourceName;
		return strSubjectName;
	}
	
	/**********************************************************************************
	 * Description 	: This function is used to get ICS notification notification body for drill incident
	 * Date 		: 22-Oct-2015
	 * Author 		: Renushree
	 * *******************************************************************************/
	public String getICSNotificationBodyForDrilInc(String strResourceName, String strIncidentName, String strIncidentDesc) throws Exception {
		String strMsgBody = "*** THIS IS A DRILL *** The following message is"
				+ " a Exercise/Drill at "
				+ strResourceName
				+ " is experiencing"
				+ " "
				+ strIncidentName
				+ ". "
				+ strIncidentDesc
				+ "."
				+ " * Contact your facility with any questions. Do not reply directly to this email. "
				+ "For information on how to unsubscribe from or change your EMResource system notifications,"
				+ " click on the following link https://emresource.qa.intermedix.com/resources/help/EMResourceNotificationPreferences.html";
			return strMsgBody;
	}
	
	/**********************************************************************************************
     * Description		: This function is used to deselect allow state reg to view incident chkbox in edit incident window
     * Arguments  		: None
     * Date             : 12-11-2015
     * Author           : Renushree
     * ********************************************************************************************
     */
	public eICSFunction deselectAllowStateRegToViewIncindentInEditInc() throws Exception {
		objWaitForElement.waitForElements(allowStateRegToViewInPopUpInEditInc, "css");
		if(this.page.element(allowStateRegToViewInPopUpInEditInc, "css").getOne().isSelected()==true){
			this.page.element(allowStateRegToViewInPopUpInEditInc, "css").getOne().click();
		}
		return this;
	}
	
	/***************************************************************************************************
     * Description		: This function is used to Deselect 'Allow State/Region to view incident' checkbox 
     * Arguments  		: None
	 * Date				: 24-Nov-2015
	 * Author			: Renushree
     * *************************************************************************************************/
	public eICSFunction selAllowStateRegToViewIncindentInEditInc() throws Exception {
		objWaitForElement.waitForElements(allowStateRegToViewInPopUp, "css");
		if (this.page.element(allowStateRegToViewInPopUpInEditInc, "css").getOne()
				.isSelected() == false) {
			this.page.element(allowStateRegToViewInPopUpInEditInc, "css").getOne()
					.click();
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is to click on select Notification Method Button
	 * Arguments	: none
	 * Date			: 10-10-2014
	 * Author		: Anil
	 * ********************************************************************************/
	public eICSFunction clickOnselectNotificationMethodButton() throws Exception {
		objWaitForElement.waitForElements(selectNotificationMethodButton, "id");
		this.page.element(selectNotificationMethodButton, "id").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is to click on by Voice CheckBox
	 * Arguments	: none
	 * Date			: 10-10-2014
	 * Author		: Anil
	 * ********************************************************************************/
	public eICSFunction clickOnbyVoiceCheckBox() throws Exception {
		objWaitForElement.waitForElements(byVoiceCheckBox, "xpath");
		this.page.element(byVoiceCheckBox, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is to click on by Voice CheckBox
	 * Arguments	: none
	 * Date			: 10-10-2014
	 * Author		: Anil
	 * ********************************************************************************/
	public eICSFunction clickOnbyEmailCheckBox() throws Exception {
		objWaitForElement.waitForElements(byEmailCheckBox, "xpath");
		this.page.element(byEmailCheckBox, "xpath").getOne().click();
		return this;
	}
	
	
	/**********************************************************************************
	 * Description	: This function is to click on by Voice CheckBox
	 * Arguments	: none
	 * Date			: 10-10-2014
	 * Author		: Anil
	 * ********************************************************************************/
	public eICSFunction clickOnOKbutton() throws Exception {
		objWaitForElement.waitForElements(OKbutton, "xpath");
		this.page.element(OKbutton, "xpath").getOne().click();
		return this;
	}
	
	
	/**********************************************************************************
	 * Description	: This function is to click on by Voice CheckBox
	 * Arguments	: none
	 * Date			: 10-10-2014
	 * Author		: Anil
	 * ********************************************************************************/
	public eICSFunction deselectNotification() throws Exception {
		this.clickOnselectNotificationMethodButton();
		this.clickOnbyEmailCheckBox();
		this.clickOnbyVoiceCheckBox();
		this.clickOnOKbutton();	
		return this;
	}
}
