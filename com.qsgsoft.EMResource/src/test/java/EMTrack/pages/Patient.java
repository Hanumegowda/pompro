package EMTrack.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import qaFramework.WaitTimeConstants;
import qaFramework.pageObject.PageObject;
import static org.testng.Assert.*;
import qaFramework.UserDefinedFunctions.Date_Time_settings;
import EMTrack.Locators.Patient.Locators;
import qaFramework.UserDefinedFunctions.WaitForElement;

public class Patient extends PageObject {
	WebDriver driver;
	WaitForElement waitForElement ;

	Date_Time_settings dts = new Date_Time_settings();

	public Patient(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver=_driver;
		waitForElement = new WaitForElement(this.driver);
	}

	public Patient clickAddDailyPatient() throws Exception {
		waitForElement.waitForElements(Locators.ADDDAILYPATIENT, "linktext");
		this.page.element(Locators.ADDDAILYPATIENT, "linktext").getOne()
		.click();
		boolean waitForPage = false;
		int count = 0;
		while (waitForPage == false && count <= 8) {
			waitForElement.waitForElements(Locators.CHIEFCOMPLAINT, "xpath");
			count++;
			if (this.page.element(Locators.CHIEFCOMPLAINT, "xpath").isElementPresent()) {
				waitForPage = true;
			}
		}
		return this;
	}

	public void enterPatientID(String patientID)throws Exception {
		waitForElement.waitForElements(Locators.PATIENTID, "id");
		this.page.element(Locators.PATIENTID, "id").clearInputValue().sendKeys(patientID);

	}

	public void selectGender(String gender) throws Exception {
		waitForElement.waitForElements(Locators.GENDER, "css");
		this.page.element(Locators.GENDER, "css").webElementToSelect()
		.selectByVisibleText(gender);
	}

	public void enterPatientAge(String age)throws Exception {
		waitForElement.waitForElements(Locators.AGE, "css");
		this.page.element(Locators.AGE, "css").clearInputValue().sendKeys(age);
	}

	public void selectHospital(String hospital)throws Exception {
		waitForElement.waitForElements(Locators.DESTINATION, "css");
		this.page.element(Locators.DESTINATION, "css").mouseOver();
		this.page.element(Locators.DESTINATION, "css").webElementToSelect().selectByVisibleText(hospital);
		String slectedHospital=this.page.element(Locators.DESTINATION, "css").webElementToSelect().getFirstSelectedOption().getText();
		assertEquals(slectedHospital, hospital);
	}

	public void selectProvider( String provider)throws Exception {
		waitForElement.waitForElements(Locators.ADD_DAILY_PATIENT_PROVIDER, "css");
		this.page.element(Locators.ADD_DAILY_PATIENT_PROVIDER, "css").mouseOver();
		this.page.element(Locators.ADD_DAILY_PATIENT_PROVIDER, "css").webElementToSelect().selectByVisibleText(provider);
		String slectedProvider=this.page.element(Locators.ADD_DAILY_PATIENT_PROVIDER, "css").webElementToSelect().getFirstSelectedOption().getText();
		assertEquals(slectedProvider, provider);

	}

	public void enterUnitValue(String unit)throws Exception {
		waitForElement.waitForElements(Locators.UNIT, "css");
		this.page.element(Locators.UNIT, "css").clearInputValue().sendKeys(unit);
	}

	public void enterEmsUnit(String emsUnit)throws Exception {
		waitForElement.waitForElements(Locators.EMSUNIT, "css");
		this.page.element(Locators.EMSUNIT, "css").clearInputValue().sendKeys(emsUnit);
	}

	public void enterETAValue( String eta)throws Exception {
		waitForElement.waitForElements(Locators.ETA, "css");
		this.page.element(Locators.ETA, "css").clearInputValue().sendKeys(eta);
	}

	public void selectRedTriageCategory()throws Exception {
		waitForElement.waitForElements(Locators.IMMEDIATETRIAGECATEGORY, "css");
		this.page.element(Locators.IMMEDIATETRIAGECATEGORY, "css").getOne().click();
	}

	public void clickOnSave() throws Exception {
		waitForElement.waitForElements(Locators.SAVE, "css");
		this.page.element(Locators.SAVE, "css").getOne().click();
		waitForElement.waitForPageToLoad();
	}

	public Patient addPatientDetailes(String patientID,String gender,String age,String hospital,String provider,String unit,String eta) throws Exception {
		clickAddDailyPatient();
		enterPatientID(patientID);
		enterPatientAge(age);
		selectGender(gender);
		selectRedTriageCategory();
		selectHospital(hospital);
		selectProvider(provider);
		enterUnitValue(unit);
		enterETAValue(eta);
		clickOnSave();
		return this;
	}

	public String getApplcnTime() throws Exception {
		waitForElement.waitForElements(Locators.APPLICATIONTIME, "css");
		String time = this.page.element(Locators.APPLICATIONTIME, "css").getOne()
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

	public Patient searchPatientId(String patientId) throws Exception {
		String patientSearch=Locators.PATIENTDETAILES+patientId+Locators.CLOSING_BRACKETS;
		waitForElement.waitForElements(Locators.SEARCHID, "id");
		this.page.element(Locators.SEARCHID, "id").clearInputValue().sendKeys(patientId);
		waitForElement.waitForElements(Locators.VIEWALLCONTACTS, "css");
		this.page.element(Locators.SEARCH, "id").getOne().click();
		waitForElement.waitForElements(patientSearch, "xpath");
		assertTrue(this.page.element(patientSearch, "xpath").isElementPresent());	
		return this;
	}

	public Patient verifyPatientDetails(String patientId,String hospital,String provider)throws Exception {
		String patientDetails=Locators.PATIENTDETAILES+patientId+Locators.CLOSING_BRACKETS+Locators.PATIENTDETAILES1+hospital+Locators.PATIENTDETAILES2+" "+provider+Locators.CLOSING_BRACKETS;
		System.out.println("patientDetails"+ patientDetails);
		System.out.println(patientDetails);
		waitForElement.waitForElements(patientDetails, "xpath");
		assertTrue(this.page.element(patientDetails, "xpath").isElementPresent());
		assertTrue(this.page.element(patientDetails, "xpath").getOne().isDisplayed());
		return this;
	}

	public String getArrivelDateAndTime(String patientId,String eta) throws Exception {
		String arrival = Locators.PATIENTDETAILES + patientId
				+ Locators.CLOSING_BRACKETS + Locators.ETADATEANDTIME;

		waitForElement.waitForElements(arrival, "xpath");
		String arrivalTime1 = this.page.element(arrival, "xpath").getOne()
				.getText();
		String currentMonth = dts.getCurrentDate("MM");
		String[] arrivalTime3 = arrivalTime1.split(" ");
		String sentTime = currentMonth + "/" + arrivalTime3[0]
				+ "/" + arrivalTime3[2] + " " + arrivalTime3[3];
		String	arrivalTime=dts.addTimetoExisting(sentTime, Integer.valueOf(eta),
				"MM/dd/yyyy HH:mm");
		arrivalTime=arrivalTime+" "+"CDT";
		System.out.println("arrivalTime" + " "  +arrivalTime);
		return arrivalTime;
	}

	public Patient navigateToMCITriagePatient() throws Exception {
		waitForElement.waitForElements(Locators.MCI_TRIAGE, "linktext");
		if(this.page.element(Locators.TAB_SELECTED + Locators.MCI_TRIAGE_XPATH, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE)==false) {
			this.page.element(Locators.MCI_TRIAGE, "linktext").clickUsingJSE();
		}
		boolean waitForPage = false;
		int count = 0;
		while (waitForPage == false && count <= 8) {
			waitForElement.waitForElements(Locators.PATIENTID, "id");
			count++;
			if (this.page.element(Locators.PATIENTID, "id").isElementPresent()) {
				waitForPage = true;
			}
		}
		return this;
	}

	public void selectCurrentLocationOfMCITriage(String location)throws Exception {
		waitForElement.waitForElements(Locators.DESTINATION, "css");
		this.page.element(Locators.DESTINATION, "css").mouseOver();
		this.page.element(Locators.DESTINATION, "css").webElementToSelect().selectByVisibleText(location);
		String selectedHospital=this.page.element(Locators.DESTINATION, "css").webElementToSelect().getFirstSelectedOption().getText();
		assertEquals(selectedHospital, location);
	}

	public void selectDestinationLocationOfMCITriage(String location)throws Exception {
		waitForElement.waitForElements(Locators.ADD_DAILY_PATIENT_PROVIDER, "css");
		this.page.element(Locators.ADD_DAILY_PATIENT_PROVIDER, "css").mouseOver();
		this.page.element(Locators.ADD_DAILY_PATIENT_PROVIDER, "css").webElementToSelect().selectByVisibleText(location);
		String selectedHospital=this.page.element(Locators.ADD_DAILY_PATIENT_PROVIDER, "css").webElementToSelect().getFirstSelectedOption().getText();
		assertEquals(selectedHospital, location);
	}

	public void selectProviderOfMCITriage(String location)throws Exception {
		waitForElement.waitForElements(Locators.MCI_TRIAGE_PROVIDER, "css");
		this.page.element(Locators.MCI_TRIAGE_PROVIDER, "css").mouseOver();
		this.page.element(Locators.MCI_TRIAGE_PROVIDER, "css").webElementToSelect().selectByVisibleText(location);
		String selectedHospital=this.page.element(Locators.MCI_TRIAGE_PROVIDER, "css").webElementToSelect().getFirstSelectedOption().getText();
		assertEquals(selectedHospital, location);
	}

	public Patient addMCITriagePatient(String patientID,String age,String currentLocation,String destinationLocation,String provider,String unit,String eta) throws Exception {
		this.navigateToMCITriagePatient();
		this.enterPatientID(patientID);
		this.enterPatientAge(age);
		this.selectRedTriageCategory();
		this.selectCurrentLocationOfMCITriage(currentLocation);
		this.selectDestinationLocationOfMCITriage(destinationLocation);
		this.selectProviderOfMCITriage(provider);
		this.enterUnitValue(unit);
		this.enterETAValue(eta);
		this.clickOnSave();
		return this;
	}

	public Patient selectForm(String formName) throws Exception {
		waitForElement.waitForElements(Locators.SELECT_FORM, "xpath");
		this.page.element(Locators.SELECT_FORM, "xpath").webElementToSelect().selectByVisibleText(formName);
		assertEquals(this.page.element(Locators.SELECT_FORM, "xpath").webElementToSelect().getFirstSelectedOption().getText(), formName);
		return this;
	}
	
	public Patient enterPatientId_Form(String patientId) throws Exception {
		waitForElement.waitForPageLoad();
		waitForElement.waitForElements(Locators.PATIENT_ID_FORM, "xpath");
		this.page.element(Locators.PATIENT_ID_FORM, "xpath").clearInputValue().sendKeys(patientId);
		assertEquals(this.page.element(Locators.PATIENT_ID_FORM, "xpath").getOne().getAttribute("value"), patientId);
		System.out.println(patientId);
		return this;
	}
	
	public Patient selectGender_Form(String gender) throws Exception {
		try{
			if(!this.page.element(Locators.SPAN_WITH_TEXT + gender + Locators.CLOSING_BRACKETS + Locators.PRECEDING_SIBLING_INPUT, "xpath").getOne().isSelected()) {
				this.page.element(Locators.SPAN_WITH_TEXT + gender + Locators.CLOSING_BRACKETS + Locators.PRECEDING_SIBLING_INPUT, "xpath").getDisplayedOne().sendKeys(Keys.SPACE);
			}
			if(!this.page.element(Locators.SPAN_WITH_TEXT + gender + Locators.CLOSING_BRACKETS + Locators.PRECEDING_SIBLING_INPUT, "xpath").getOne().isSelected()) {
				this.page.element(Locators.SPAN_WITH_TEXT + gender + Locators.CLOSING_BRACKETS + Locators.PRECEDING_SIBLING_INPUT, "xpath").getDisplayedOne().sendKeys(Keys.ENTER);
			}
			if(!this.page.element(Locators.SPAN_WITH_TEXT + gender + Locators.CLOSING_BRACKETS + Locators.PRECEDING_SIBLING_INPUT, "xpath").getOne().isSelected()) {
				this.page.element(Locators.SPAN_WITH_TEXT + gender + Locators.CLOSING_BRACKETS + Locators.PRECEDING_SIBLING_INPUT, "xpath").clickUsingJSE();
			}
			assertTrue(this.page.element(Locators.SPAN_WITH_TEXT + gender + Locators.CLOSING_BRACKETS + Locators.PRECEDING_SIBLING_INPUT, "xpath").getOne().isSelected(), gender + " required gender is not selected.");
		} catch(Exception e) {
			if(!this.page.element(Locators.SPAN_WITH_TEXT + gender + Locators.CLOSING_BRACKETS + Locators.PRECEDING_SIBLING_INPUT, "xpath").getOne().isSelected()) {
				this.page.element(Locators.SPAN_WITH_TEXT + gender + Locators.CLOSING_BRACKETS + Locators.PRECEDING_SIBLING_INPUT, "xpath").clickUsingJSE();
			}
			assertTrue(this.page.element(Locators.SPAN_WITH_TEXT + gender + Locators.CLOSING_BRACKETS + Locators.PRECEDING_SIBLING_INPUT, "xpath").getOne().isSelected(), gender + " required gender is not selected.");
		}
		return this;
	}
	
	public Patient enterPatientAge_Form(String age)throws Exception {
		waitForElement.waitForElements(Locators.AGE_FORM, "xpath");
		this.page.element(Locators.AGE_FORM, "xpath").clearInputValue().sendKeys(age);
		assertEquals(this.page.element(Locators.AGE_FORM, "xpath").getOne().getAttribute("value"), age);
		return this;
	}
	

	public Patient selectDestinationLocation_Form(String destinationLocation)
			throws Exception {
		waitForElement.waitForElements(Locators.DESTINATION_LOCATION_FORMS, "xpath");
		this.page.element(Locators.DESTINATION_LOCATION_FORMS, "xpath").webElementToSelect().selectByVisibleText(destinationLocation);
		assertEquals(this.page.element(Locators.DESTINATION_LOCATION_FORMS, "xpath").webElementToSelect().getFirstSelectedOption().getText(), destinationLocation);
		return this;
	}
	
	public Patient selectMobilProvider_Form(String mobilProvider) throws Exception {
		waitForElement.waitForElements(Locators.PROVIDER_FORMS, "xpath");
		this.page.element(Locators.PROVIDER_FORMS, "xpath").webElementToSelect().selectByVisibleText(mobilProvider);
		assertEquals(this.page.element(Locators.PROVIDER_FORMS, "xpath").webElementToSelect().getFirstSelectedOption().getText(), mobilProvider);
		return this;
	}
	
	public Patient enterUnit_Form(String unit) throws Exception {
		waitForElement.waitForElements(Locators.UNIT_FORMS, "xpath");
		this.page.element(Locators.UNIT_FORMS, "xpath").getDisplayedOne().clear();
		this.page.element(Locators.UNIT_FORMS, "xpath").getDisplayedOne().sendKeys(unit);
		assertEquals(this.page.element(Locators.UNIT_FORMS, "xpath").getDisplayedOne().getAttribute("value"), unit);
		return this;
	}
	
	public Patient enterETA_Form(String eta) throws Exception {
		waitForElement.waitForElements(Locators.ETA_FORMS, "xpath");
		this.page.element(Locators.ETA_FORMS, "xpath").getDisplayedOne().clear();
		this.page.element(Locators.ETA_FORMS, "xpath").getDisplayedOne().sendKeys(eta);
		assertEquals(this.page.element(Locators.ETA_FORMS, "xpath").getDisplayedOne().getAttribute("value"), eta);
		return this;
	}
	
	public Patient clickSave() throws Exception {
		this.page.element(Locators.SAVE_FORM, "xpath").getOne().click();
		this.page.element_wait(Locators.SAVE_FORM, "xpath").waitForInvisibilityOfElement();
		return this;
	}
	
	public Patient addPatient_UsingForm(String formName, String patientId, String gender, String age, String destinationLocation, String mobilProvider, String unit, String eta) throws Exception {
		this.selectForm(formName);
		this.enterPatientId_Form(patientId);
		this.selectGender_Form(gender);
		this.enterPatientAge_Form(age);
		this.selectDestinationLocation_Form(destinationLocation);
		this.selectMobilProvider_Form(mobilProvider);
		this.enterUnit_Form(unit);
		this.enterETA_Form(eta);
		this.clickSave();
		return this;
	}
}