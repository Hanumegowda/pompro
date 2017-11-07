package lib.page;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;

public class EMTrackLogin extends PageObject {
	
	WebDriver driver;
	WaitForElement objWaitForElement;
	//Locators
	private String url = "https://emtrack.qa.intermedix.com/",
			username = "#name",
			password = "#password",
			loginBtn = "//input[@name='loginBttn']",
			patientLink = "//a[contains(text(),'Patient')]",
			addDailyPatientID = "triageTagField",
			evacueePatientId = "triageTagFindableField",
			mciPatient = "//a[contains(text(),'MCI Triage')]",
			evacueePatient = "//a[contains(text(),'Add Evacuee')]",
			destinationLocationDropDown = "propertySelection",
			destinationLocationDropDownInMci = "#propertySelection_0",
			providerDropDownInMci = "#propertySelection_1",
			providerDropDown = "#propertySelection_0",
			unitInputField = "#transportUnitField",
			ETAField = "#etaTextField",
			saveBtn = "#saveSubmit",
			logOutLink = "Log Out",
			addDailyPatientLink = "Add Daily Patient",
			genderDropDown = "#genderGroup",
		    divisionLink = "a.divisionLink",
		    selLocWindowTitle = "#ui-dialog-title-divisionTreeDialog",
		    configureButton = "#button-1024",
		    age = "#ageField_2",
		    redTriageCategory = "span.triageCategoryOption.triageCategory_red>input",
		    vaccinationPatientLink = "Vaccination",
		    PatientIDTextField = "#triageTagFindableField",
		    PatientIDField = "#triageTagFindableField",
		    vaccDestinationLocationDropDown = "#propertySelection_0",
		    vaccProviderDropDown = "#propertySelection_1";
					
	public EMTrackLogin(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
	}

	/**********************************************************************************
	  * Description : This function is to login to the application
	  * Date        : 09/06/2014
	  * Author      : Anil
	  **********************************************************************************/	
	public EMTrackLogin loginToApplication(String strUsername, String strPassword)
			throws Exception {
		driver.get(url);
		this.enterUserName(strUsername);
		this.enterPassword(strPassword);
		this.clickLogin();
		return this;
	}
	

	/**********************************************************************************
	  * Description : This function is to enter username
	  * Date        : 09/06/2014
	  * Author      : Anil
	  **********************************************************************************/
	public EMTrackLogin enterUserName(String strusername) throws Exception {
		objWaitForElement.waitForElements(username, "css");
		this.page.element(username, "css").clearInputValue().sendKeys(strusername);
		return this;
	}
	

	/**********************************************************************************
	  * Description : This function is to enter password
	  * Date        : 09/06/2014
	  * Author      : Anil
	  **********************************************************************************/
	public EMTrackLogin enterPassword(String strPassword) throws Exception {
		objWaitForElement.waitForElements(password, "css");
		this.page.element(password, "css").clearInputValue().sendKeys(strPassword);
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to click on 'Login' button
	  * Date        : 09/06/2014
	  * Author      : Anil
	  **********************************************************************************/
	public EMTrackLogin clickLogin() throws Exception {
		objWaitForElement.waitForElements(loginBtn, "xpath");
		this.page.element(loginBtn, "xpath").getOne().click();
		return this;
	}
	

	/**********************************************************************************
	  * Description : This function is to click on 'Login' button
	  * Date        : 09/06/2014
	  * Author      : Anil
	  **********************************************************************************/
	public EMTrackLogin navigateToPatientPage() throws Exception {
		objWaitForElement.waitForElements(patientLink, "xpath");
		this.page.element(patientLink, "xpath").getOne().click();
		Thread.sleep(5000);
		return this;
	}
	
	/****************************************************
	' Description  : Function to navigate to Filters Page
	' Arguments    : this.element
	' Date         : 16/12/2013
	' Author       : Manasa 
	*****************************************************/
	public void navToMCITriagePage() throws Exception {
		objWaitForElement.waitForElements(mciPatient, "xpath");
		this.page.element(mciPatient, "xpath").getOne().click();
		Thread.sleep(5000);
	}
	
	
	/**********************************************
	' Description  : Function to enter patient ID.
	' Arguments    : pStrPatientID
	' Date         : 18-09-2014
	' Author       : Anil 
	***********************************************/
	public void enterPatientID(String pStrPatientID)
			throws Exception {
		objWaitForElement.waitForElements(addDailyPatientID, "id");
		this.page.element(addDailyPatientID, "id").clearInputValue().sendKeys(pStrPatientID);
	}
	

	/********************************************************
	' Description  : Function to select Destination Location.
	' Arguments    : pStrDestination
	' Date         : 18-09-2014
	' Author       : Anil 
	********************************************************/
	public void selDestinationLocation( String pStrDestination)
			throws Exception {
		objWaitForElement.waitForElements(destinationLocationDropDown, "id");
		this.page.element(destinationLocationDropDown, "id").webElementToSelect().selectByVisibleText(pStrDestination);

	}
	
	/********************************************************
	' Description  : Function to select Destination Location.
	' Arguments    : pStrDestination
	' Date         : 18-09-2014
	' Author       : Anil 
	********************************************************/
	public void selDestinationLocationForMci( String pStrDestination)
			throws Exception {
		objWaitForElement.waitForElements(destinationLocationDropDownInMci, "css");
		this.page.element(destinationLocationDropDownInMci, "css").webElementToSelect().selectByVisibleText(pStrDestination);

	}
	
	/*****************************************************
	' Description  : Function to select Provider Facility.
	' Arguments    : pStrProvider
	' Date         : 18-09-2014
	' Author       : Anil 
	*****************************************************/
	public void selProvider( String pStrProvider)
			throws Exception {
		objWaitForElement.waitForElements(providerDropDown, "css");
		this.page.element(providerDropDown, "css").webElementToSelect().selectByVisibleText(pStrProvider);

	}
	
	/*****************************************************
	' Description  : Function to select Provider Facility.
	' Arguments    : pStrProvider
	' Date         : 18-09-2014
	' Author       : Anil 
	*****************************************************/
	public void selProviderForMci( String pStrProvider)
			throws Exception {
		objWaitForElement.waitForElements(providerDropDownInMci, "css");
		this.page.element(providerDropDownInMci, "css").webElementToSelect().selectByVisibleText(pStrProvider);

	}
	
	/**********************************************
	' Description  : Function to enter Unit value.
	' Arguments    : pStrUnit
	' Date         : 18-09-2014
	' Author       : Anil 
	***********************************************/
	public void enterUnitValue(String pStrUnit)
			throws Exception {
		objWaitForElement.waitForElements(unitInputField, "css");
		this.page.element(unitInputField, "css").clearInputValue().sendKeys(pStrUnit);
	}
	
	/**********************************************
	' Description  : Function to enter ETA value.
	' Arguments    : pStrETA
	' Date         : 18-09-2014
	' Author       : Anil 
	***********************************************/
	public void enterETAValue( String pStrETA)
			throws Exception {
		objWaitForElement.waitForElements(ETAField, "css");
		this.page.element(ETAField, "css").clearInputValue().sendKeys(pStrETA);
	}
	
	
	/**************************************************
  	' Description  : Function click 'Add label' button 
  	' Arguments    : this.element
  	' Date         : 18-09-2014
  	' Author       : Anil 
  	***************************************************/
	public void clkSaveBtn() throws Exception {
		objWaitForElement.waitForElements(saveBtn, "css");
		this.page.element(saveBtn, "css").getOne().click();
	}
	
	/**************************************************
  	' Description  : Function click 'Log Out' link 
  	' Arguments    : this.element
  	' Date         : 18-09-2014
  	' Author       : Anil 
  	***************************************************/
	public void clickLogOutLink() throws Exception {
		objWaitForElement.waitForElements(logOutLink, "linktext");
		this.page.element(logOutLink, "linktext").getOne().click();
	}
	
	/***********************************************************
	' Description  : Function to navigate to daily patient Page
	' Arguments    : this.element
	' Date         : 20/10/2014
	' Author       : Sowmya
	***********************************************************/
	public void navToAddDailyPatientPage() throws Exception {
		objWaitForElement.waitForElements(addDailyPatientLink, "linktext");
		this.page.element(addDailyPatientLink, "linktext").getOne().click();
//		objWaitForElement.waitForElements(addDailyPatientID, "id");
//		this.page.element(addDailyPatientID, "id").isElementPresent();
	}
	
	/*******************************************
	' Description  : Function to select Gender.
	' Arguments    : pStrGender
	' Date         : 20/10/2014
	' Author       : Sowmya 
	*******************************************/
	public void selGender(String pStrGender) throws Exception {
		objWaitForElement.waitForElements(genderDropDown, "css");
		this.page.element(genderDropDown, "css").webElementToSelect()
				.selectByVisibleText(pStrGender);
	}
	
	/*************************************************************
	' Description  : Function to click on Division navigator link
	' Arguments    : 
	' Date         : 20/10/2014
	' Author       : Sowmya 
	**************************************************************/
	public void clkOnDivisionLink() throws Exception {
		objWaitForElement.waitForElements(divisionLink, "css");
		this.page.element(divisionLink, "css").getOne().click();
		objWaitForElement.waitForElements(selLocWindowTitle, "css");
		assertTrue(this.page.element(selLocWindowTitle, "css")
				.isElementPresent());
	}
	
	/**************************************************************************************
	' Description  : Function to navigate to other Division by selecting required Location
	' Arguments    : pStrLocationName
	' Date         : 20/10/2014
	' Author       : Sowmya 
	***************************************************************************************/
	public void selSubDivision(String pStrLocationName) throws Exception {
		objWaitForElement.waitForElements("//div[@id='navigatorTree']/ul/li/ul/li/a[text()='"
				+ pStrLocationName + "']", "xpath");
		this.page
				.element(
						"//div[@id='navigatorTree']/ul/li/ul/li/a[text()='"
								+ pStrLocationName + "']", "xpath").getOne()
				.click();
		Thread.sleep(15000);
//		objWaitForElement.waitForElements(configureButton, "css");
//		this.page.element_wait(configureButton, "css");
	}

	/*************************************************************************************
	' Description  : Function to click on Division link and navigate to required Location 
	' Arguments    : pStrLocationName
	' Date         : 20/10/2014
	' Author       : Sowmya 
	**************************************************************************************/
	public void changeLocation( String pStrLocationName)
			throws Exception {
		clkOnDivisionLink();
		selSubDivision(pStrLocationName);
	}
	
	/*******************************************************
  	' Description  : Function to fetch the application time only hours
  	' Arguments    : this.element
  	' Date         : 13/03/2014
  	' Author       : Sowmya 
  	********************************************************/
	public String getApplcnTime() throws Exception {
		objWaitForElement.waitForElements("td.footerRight", "css");
		String time = this.page.element("td.footerRight", "css").getOne()
				.getText();
		
		String[] strTime = time.split(" ");		
		String strTime1 = strTime[4];		
		String strTime2 = strTime[5];	
		String strTime4 = strTime[7];
		
		String[] strTime5 = strTime4.split(":");
		
		String strTime6 = strTime5[0];
		String strTime7 = strTime5[1];
		
		
		String strApplicationTime = strTime1 + " " + strTime2 + " " + strTime6 + ":" + strTime7;
		
		return strApplicationTime;
	}
	
	/*******************************************************
  	' Description  : Function to fetch the application time only hours
  	' Arguments    : this.element
  	' Date         : 13/03/2014
  	' Author       : Sowmya 
  	********************************************************/
	public String convertApplcnTimeFromCDTtoMDT() throws Exception {
		objWaitForElement.waitForElements("td.footerRight", "css");
		String time = this.page.element("td.footerRight", "css").getOne()
				.getText();
		
		String[] strTime = time.split(" ");		
		String strTime1 = strTime[4];		
		String strTime2 = strTime[5];	
		String strTime4 = strTime[7];
		
		String[] strTime5 = strTime4.split(":");
		
		String strTime6 = strTime5[0];
		
		int strTime7 = Integer.parseInt(strTime6);
		
		 strTime7 = strTime7 - 1;
		 
		 String strTime8 = "" + strTime7;
		
		String strTime9 = strTime5[1];
		
		
		String strApplicationTime = strTime1 + " " + strTime2 + " " + strTime8 + ":" + strTime9;
		
		return strApplicationTime;
	}
	
	
	
	/**********************************************
	' Description  : Function to enter age
	' Arguments    : pStrETA
	' Date         : 27-11-2014
	' Author       : Anil 
	***********************************************/
	public void enterPatientAge( String strAge)
			throws Exception {
		objWaitForElement.waitForElements(age, "css");
		this.page.element(age, "css").clearInputValue().sendKeys(strAge);
	}
	
	/*************************************************************
	' Description  : Function to select the 'Red triage category'.
	' Arguments    : this.element
	' Date         : 10-03-2015
	' Author       : Rahul 
	**************************************************************/
	public void selRedTriageCategory()
			throws Exception {
		objWaitForElement.waitForElements(redTriageCategory, "css");
		this.page.element(redTriageCategory, "css").getOne().click();
	}
	
	/*****************************************************************
  	' Description  : Function to navigate to 'Vaccination' Patient page
  	' Arguments    : this.element 
  	' Date         : 18-03-2015
  	' Author       : Sowmya
  	*******************************************************************/
	public void navToVaccinationPatientPage() throws Exception {
		objWaitForElement.waitForElements(vaccinationPatientLink, "linktext");
		this.page.element(vaccinationPatientLink, "linktext").getOne().click();
		Thread.sleep(5000);
		objWaitForElement.waitForElements(PatientIDTextField, "css");
		this.page.element_wait(PatientIDTextField, "css");
	}
	
	/********************************************************
	' Description  : Function to enter Vaccination patient ID.
	' Arguments    : pStrPatientID
	' Date         : 18-03-2015
	' Author       : Sowmya
	*********************************************************/
	public void enterVaccinationPatientID(String pStrPatientID)
			throws Exception {
		objWaitForElement.waitForElements(PatientIDField, "css");
		this.page.element(PatientIDField, "css").getOne()
				.sendKeys(pStrPatientID);
	}
	
	/*******************************************************************
	' Description  : Function to select Vaccination Destination Location.
	' Arguments    : pStrDestination
	' Date         : 18-03-2015
	' Author       : Sowmya
	********************************************************************/
	public void selVaccDestinationLocation(String pStrDestination)
			throws Exception {
		objWaitForElement.waitForElements(vaccDestinationLocationDropDown, "css");
		this.page.element(vaccDestinationLocationDropDown, "css")
				.webElementToSelect().selectByVisibleText(pStrDestination);
	}
	
	/*****************************************************************
	' Description  : Function to select Vaccination Provider Facility.
	' Arguments    : pStrProvider
	' Date         : 18-03-2015
	' Author       : Sowmya
	******************************************************************/
	public void selVaccProvider(String pStrProvider) throws Exception {
		objWaitForElement.waitForElements(vaccProviderDropDown, "css");
		this.page.element(vaccProviderDropDown, "css").webElementToSelect()
				.selectByVisibleText(pStrProvider);
	}
	
	/********************************************
	' Description  : Function to select Incident.
	' Arguments    : pStrIncident
	' Date         : 18-03-2015
	' Author       : Rahul 
	********************************************/
	public void selIncident(String pStrIncident) throws Exception {
		objWaitForElement.waitForElements("//div[@class='scrollableMultipleCheckBoxesComponent field scrollableMultipleCheckBoxes']/div[@class='input']/label[text()='"
				+ pStrIncident + "']/input", "xpath");
		this.page
				.element(
						"//div[@class='scrollableMultipleCheckBoxesComponent field scrollableMultipleCheckBoxes']/div[@class='input']/label[text()='"
								+ pStrIncident + "']/input", "xpath").getOne()
				.click();
	}
	
	/********************************************************************
	' Description  : Function to navigate to 'Add Evacuee' patient Page.
	' Arguments    : None
	' Date         : 18/12/2015
	' Author       : Rahul 
	**********************************************************************/
	public void navToAddEvacueePage() throws Exception {
		objWaitForElement.waitForElements(evacueePatient, "xpath");
		this.page.element(evacueePatient, "xpath").getOne().click();
		Thread.sleep(5000);
	}
	
	/**************************************************************
	' Description  : Function to enter patient ID in Evacuee page.
	' Arguments    : pStrPatientID
	' Date         : 18-09-2015
	' Author       : Rahul 
	***************************************************************/
	public void enterPatientIDForEvacuee(String pStrPatientID)
			throws Exception {
		objWaitForElement.waitForElements(evacueePatientId, "id");
		this.page.element(evacueePatientId, "id").clearInputValue().sendKeys(pStrPatientID);
	}
}