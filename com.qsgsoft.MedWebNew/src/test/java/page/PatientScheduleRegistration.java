package page;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import module.Frames;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import qaframework.lib.pageObject.PageObject;
import qaframework.lib.userDefinedFunctions.WaitForElement;
import qaframework.lib.webElements.WebElements;
import static org.testng.Assert.assertTrue;

public class PatientScheduleRegistration extends PageObject{
	WebDriver driver;
	WaitForElement objWaitForElement;
	Frames objFrames;
	UserManagement objUserManagement;
	
	private String patientRegistration = "//td[contains(text(),'Patient Registration')]",
			       lastName = "LAST_NAME",
			       PatientNameIdSSN = "//input[@name='f']",
			       firstName = "FIRST_NAME",
			       address = "ADDRESS",
			       city = "CITY",
			       race = "RACE",
			       language = "LANGUAGE",
			       ethnicGroup = "ETHNIC_GROUP",
			       religion = "RELIGION",
			       zip = "ZIP",
			       severity = "ALLERGY_SEVER",
			       reaction = "//input[@title='Allergy Reaction']",
			       strDescription = "//input[@title='Allergy Description']",
			       veteransMilitaryStatus = "VET_MIL_STATUS",
			       allergyType = "ALLERGY_TYPE",
			       country = "COUNTRY",
			       lastNameAlias = "LAST_NAME_ALIAS",
			       firstNameAlias = "FIRST_NAME_ALIAS",
			       dob = "DATE_OF_BIRTH",
			       homePhone = "HOME_PHONE",
			       businessPhone = "BUSINESS_PHONE",
			       strEMail = "EMAIL",
			       ssn = "SSN_NUMBER",
			       state = "STATE",
			       sex = "SEX",
			       maritalStatus = "MARITAL_STATUS",
			       savePatientData = "(//a[contains(text(),'Save Patient Data')])[1]",
			       scheduler = "//img[@src='/wavelet/gifs.new/ris_sched1.gif']",
			       registration = "//img[@src='/wavelet/gifs.new/ris_reg1.gif']",
			       enterOrder = "//td[@id='MainMenu']//img[@src='/wavelet/gifs.new/ris_exam1.gif']",
			       selModality = "//select[@name='MODALITY_LIST']",
			       selModality1 = "//select[@name='modality']",
			       selClinic = "//select[@name='clinic']",
			       selMachine = "//select[@name='MACHINE_ID']",
			       patientlastName = "PATIENT_NAME_L",
			       lastName1 = "//input[@name='LAST_NAME']",
			       createTheOrder = "(//a[text()='Create the Order'])[1]",
			       statCheckbox = "//input[@type='checkbox'][@name='STAT']",
			       save = "//a[text()='Save']",
			       middleName = "MIDDLE_NAME",
			       alternatePatientID = "ALT_PATIENT_ID",
			       searchOrders = "//img[@src='/wavelet/gifs.new/ris_worklist1.gif']",
			       searchOrders1 = "//a[text()='Search Orders']",
			       time = "//select[@name='sel_time']",
			       getCount = "(//tr[@valign='CENTER'])[2]/td[1]",
			       searchReports = "//td[@id='MainMenu']/img[@src='/wavelet/gifs.new/ris_search_icon.gif']",
			       event = "//select[@name='time_event']",
			       searchReports1 = "//a[text()='Search Reports']",
			       logout = "//a[text()='Logout']",
			       allMachinesChkbx = "//input[@type='CHECKBOX']",
			       searchServiceLocation = "//img[@src='/wavelet/gifs.new/ris_search_icon.gif'][@title='Service Location']",
			       patientID = "PATIENT_ID_PREFIX",
			       deletePatient = "//td[contains(text(),'Delete Patient')]",
			       selMachineInSearchOrder = "//select[@name='machine']",
			       orderScheduler = "//td[contains(text(),'Order Scheduler')]",
			       reportSearch = "//td[contains(text(),'Report search')]",
			       procedureLength = "time_slot",
			       insuranceTab = "reg_menu1",
			       patientTab = "reg_menu0",
			       insurancePlanID = "ins1_plan_id",
			       compIdSearchIcon = "//td/input[@id='ins1_comp_id']/../following-sibling::td/img[@src='/wavelet/gifs.new/ris_search_icon.gif']",
			       planTypeSearchIcon = "//td/input[@id='ins1_plan_type']/../following-sibling::td/img[@src='/wavelet/gifs.new/ris_search_icon.gif']",
			       patientClass = "PATIENT_CLASS",
			       patientLocationSearchIcon = "//font[text()='Patient Location']/..//img[@src='/wavelet/gifs.new/ris_search_icon.gif']",
			       referringPhysicianSearchIcon = "//font[text()='Referring Physician']/..//img[@src='/wavelet/gifs.new/ris_search_icon.gif']",
			       assignProviderSearchIcon = "//font[text()='Assign Provider']/..//img[@src='/wavelet/gifs.new/ris_search_icon.gif']",
			       attendingDoctorSearchIcon = "//font[text()='Attending Doctor']/..//img[@src='/wavelet/gifs.new/ris_search_icon.gif']",
			       insuranceCompanySearchIcon = "//font[contains(text(),'Insurance Company:')]/../following-sibling::td//img[@src='/wavelet/gifs.new/ris_search_icon.gif']";
	String reqtabs[] = {"/wavelet/gifs.new/ris_reg1.gif","/wavelet/gifs.new/ris_exam1.gif","/wavelet/gifs.new/ris_sched1.gif",
			        "/wavelet/gifs.new/ris_worklist1.gif","/wavelet/gifs.new/ris_search_icon.gif","/wavelet/mini-ris/help/help.htm"};
	
	public PatientScheduleRegistration(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
		objFrames = new Frames(this.driver);
		objUserManagement = new UserManagement(this.driver);
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Patient Registration' page is displayed.
	* Date 		  : 06-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration verPatientRegistrationPage()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(patientRegistration, "xpath");
		assertTrue(this.page.element(patientRegistration, "xpath").getOne()
				.isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Last Name' text field.
	* Date 		  : 06-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration enterTextInLastName(String strlastname)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(lastName, "id");
		this.page.element(lastName, "id").clearInputValue().sendKeys(strlastname);
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Patient Name/Id/SSN' text field in 
	*               order search page.
	* Date 		  : 06-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration enterTextInPatientNameIdSSN(String strlastname)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(PatientNameIdSSN, "xpath");
		this.page.element(PatientNameIdSSN, "xpath").clearInputValue().sendKeys(strlastname);
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'First Name' text field.
	* Date 		  : 06-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration enterTextInFirstName(String strfirstname)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(firstName, "id");
		this.page.element(firstName, "id").clearInputValue().sendKeys(strfirstname);
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Middle Name' text field.
	* Date 		  : 06-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration enterTextInMiddleName(String strmiddlename)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(middleName, "id");
		this.page.element(middleName, "id").clearInputValue().sendKeys(strmiddlename);
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Address' text field.
	* Date 		  : 06-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration enterTextInAddress(String straddress)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(address, "id");
		this.page.element(address, "id").clearInputValue().sendKeys(straddress);
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Alternate Patient ID' text field.
	* Date 		  : 06-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration enterTextInAlternatePatientID(String strpatientid)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(alternatePatientID, "id");
		this.page.element(alternatePatientID, "id").clearInputValue().sendKeys(strpatientid);
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'City' text field.
	* Date 		  : 06-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration enterTextInCity(String strcity)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(city, "id");
		this.page.element(city, "id").clearInputValue().sendKeys(strcity);
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Race' text field.
	* Date 		  : 06-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration enterTextInRace(String strace)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(race, "id");
		this.page.element(race, "id").clearInputValue().sendKeys(strace);
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Religion' text field.
	* Date 		  : 06-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration enterTextInReligion(String strreligion)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(religion, "id");
		this.page.element(religion, "id").clearInputValue().sendKeys(strreligion);
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Ethnic Group' text field.
	* Date 		  : 06-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration enterTextInEthnicGroup(String strethnicgroup)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(ethnicGroup, "id");
		this.page.element(ethnicGroup, "id").clearInputValue().sendKeys(strethnicgroup);
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Language' text field.
	* Date 		  : 06-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration enterTextInLanguage(String strlanguage)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(language, "id");
		this.page.element(language, "id").clearInputValue().sendKeys(strlanguage);
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Zip' text field.
	* Date 		  : 06-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration enterTextInZip(String strzip)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(zip, "id");
		this.page.element(zip, "id").clearInputValue().sendKeys(strzip);
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Allergy Type' text field.
	* Date 		  : 06-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration enterTextInAllergyType(String strallergytype)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(allergyType, "id");
		this.page.element(allergyType, "id").clearInputValue().sendKeys(strallergytype);
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Severity' text field.
	* Date 		  : 06-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration enterTextInSeverity(String strseverity)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(severity, "id");
		this.page.element(severity, "id").clearInputValue().sendKeys(strseverity);
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Code/Description' text field.
	* Date 		  : 06-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration enterTextInCodeOrDescription(String strdescription)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(strDescription, "xpath");
		this.page.element(strDescription, "xpath").clearInputValue().sendKeys(strdescription);
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Reaction' text field.
	* Date 		  : 06-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration enterTextInReaction(String strreaction)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(reaction, "xpath");
		this.page.element(reaction, "xpath").clearInputValue().sendKeys(strreaction);
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Veterans Military Status' text field.
	* Date 		  : 06-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration enterTextInVeteransMilitaryStatus(String strveteransmilitarystatus)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(veteransMilitaryStatus, "id");
		this.page.element(veteransMilitaryStatus, "id").clearInputValue().sendKeys(strveteransmilitarystatus);
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Country' text field.
	* Date 		  : 06-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration enterTextInCountry(String strcountry)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(country, "id");
		this.page.element(country, "id").clearInputValue().sendKeys(strcountry);
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Last Name Alias' text field.
	* Date 		  : 06-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration enterTextInLastNameAlias(String strLastnamealias)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(lastNameAlias, "id");
		this.page.element(lastNameAlias, "id").clearInputValue().sendKeys(strLastnamealias);
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'First Name Alias' text field.
	* Date 		  : 06-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration enterTextInFirstNameAlias(String strFirstnamealias)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(firstNameAlias, "id");
		this.page.element(firstNameAlias, "id").clearInputValue().sendKeys(strFirstnamealias);
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Date of Birth' text field.
	* Date 		  : 06-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration enterTextInDateOfBirth(String strDOB)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(dob, "id");
		this.page.element(dob, "id").clearInputValue().sendKeys(strDOB);
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Home Phone' text field.
	* Date 		  : 06-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration enterTextInHomePhone(String strHomePhone)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(homePhone, "id");
		this.page.element(homePhone, "id").clearInputValue().sendKeys(strHomePhone);
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Business Phone' text field.
	* Date 		  : 06-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration enterTextInBusinessPhone(String strBusinessPhone)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(businessPhone, "id");
		this.page.element(businessPhone, "id").clearInputValue().sendKeys(strBusinessPhone);
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'E-Mail' text field.
	* Date 		  : 06-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration enterTextInEMail(String strEmail)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(strEMail, "id");
		this.page.element(strEMail, "id").clearInputValue().sendKeys(strEmail);
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'SSN number' text field.
	* Date 		  : 06-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration enterTextInSSN(String strSSN)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(ssn, "id");
		this.page.element(ssn, "id").clearInputValue().sendKeys(strSSN);
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'state' from dropdown menu.
	* Date 		  : 06-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration selState(String strstate)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(state, "id");
		this.page.element(state, "id").webElementToSelect().selectByVisibleText(strstate);
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'sex' from dropdown menu.
	* Date 		  : 06-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration selSex(String strsex)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(sex, "id");
		this.page.element(sex, "id").webElementToSelect().selectByVisibleText(strsex);
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select date from calender window.
	* Date 		  : 06-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration selDateFromCalenderWindow(String req)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		String str = "(//td[contains(text(),'"+req+"')]//following-sibling::td/img[@src='/wavelet/gifs.new/ris_calendar_icon.gif'])[2]";
		objWaitForElement.waitForElements(str, "xpath");
		this.page.element(str, "xpath").getOne().click();
		String mainwindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> itr = allwindows.iterator();
		while(itr.hasNext()){
			String childwindow = itr.next().toString();
			if(!childwindow.contains(mainwindow)){
				driver.switchTo().window(childwindow);
				this.page.element("//td/font[@color='blue']", "xpath").getOne().click();
			}
		}
		driver.switchTo().window(mainwindow);
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Marital Status' from dropdown menu.
	* Date 		  : 06-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration selMaritalStatus(String strMaritalStatus)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(maritalStatus, "id");
		this.page.element(maritalStatus, "id").webElementToSelect().selectByVisibleText(strMaritalStatus);
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Save Patient Data' button.
	* Date 		  : 06-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration clickOnSavePatientData()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(savePatientData, "xpath");
		this.page.element(savePatientData, "xpath").getOne().click();
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Scheduler' tab.
	* Date 		  : 06-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration clickOnScheduler()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(scheduler, "xpath");
		this.page.element(scheduler, "xpath").getOne().click();
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Registration' button.
	* Date 		  : 06-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration clickOnRegistration()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(registration, "xpath");
		this.page.element(registration, "xpath").getOne().click();
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify patient registration.
	* Date 		  : 06-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration verPatientRegistration(String str1)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements("//div[@class='ac_results']/ul/li",
				"xpath");
		this.page.element("//div[@class='ac_results']/ul/li", "xpath").getOne()
				.click();
		try{
		String actual = this.page.element(lastName, "id").getOne()
				.getAttribute("value");
		System.out.println(actual + " a1");
		assertTrue(actual.equals(str1));
		}
		catch(NoSuchElementException ele){
			String actual = this.page.element(patientlastName, "id").getOne()
					.getAttribute("value");
			System.out.println(actual + " a1");
			assertTrue(actual.equals(str1));
			
		}

		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'EnterOrder' button.
	* Date 		  : 29-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration clickOnEnterOrder()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(enterOrder, "xpath");
		this.page.element(enterOrder, "xpath").getOne().click();
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select modality from modality dropdown.
	* Date 		  : 29-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration selModality(String strmodality)
			throws Exception {
		Thread.sleep(3000);
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(selModality, "xpath");
		this.page.element(selModality, "xpath").webElementToSelect().selectByVisibleText(strmodality);		
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select Clinic from dropdown or to verify clinic is present.
	* Date 		  : 29-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration selClinic(String strclinic)
			throws Exception {
//		objFrames.switchToDefaultFrame().switchToRightFrame()
//				.switchToMainInRightFrame();
		objUserManagement.clickOnOkInAlertPopUp();
		objWaitForElement.waitForElements(selClinic, "xpath");
		objUserManagement.clickOnOkInAlertPopUp();
		this.page.element(selClinic, "xpath").webElementToSelect().selectByVisibleText(strclinic);
		Thread.sleep(5000);
		objUserManagement.clickOnOkInAlertPopUp();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select machine from machine dropdown or to verify machine is present.
	* Date 		  : 29-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration selMachine(String strmachine)
			throws Exception {
//		objFrames.switchToDefaultFrame().switchToRightFrame()
//				.switchToMainInRightFrame();
		objUserManagement.clickOnOkInAlertPopUp();
		objWaitForElement.waitForElements(selMachine, "xpath");
		this.page.element(selMachine, "xpath").webElementToSelect().selectByVisibleText(strmachine);
		objUserManagement.clickOnOkInAlertPopUp();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Patient Last Name' text field.
	* Date 		  : 03-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration enterTextInPatientsLastName(String strlastname)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(patientlastName, "id");
		this.page.element(patientlastName, "id").clearInputValue().sendKeys(strlastname);
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Last Name' text field.
	* Date 		  : 03-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration enterTextInLastName1(String strlastname)
			throws Exception {
		objWaitForElement.waitForElements(lastName1, "xpath");
		this.page.element(lastName1, "xpath").clearInputValue().sendKeys(strlastname);
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Save Patient Data' button.
	* Date 		  : 06-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration clickOnSavePatientData1()
			throws Exception {
		objWaitForElement.waitForElements(savePatientData, "xpath");
		this.page.element(savePatientData, "xpath").getOne().click();
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'create the order' button.
	* Date 		  : 05-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration clickOnCreateTheOrder()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(createTheOrder, "xpath");
		this.page.element(createTheOrder, "xpath").getOne().click();
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select Stat check box in 'Enter Order' page.
	* Date 		  : 05-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration selStatCheckbox()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(statCheckbox, "xpath");
		if(this.page.element(statCheckbox, "xpath").getOne().isSelected()==false){
			this.page.element(statCheckbox, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on save in enter order page.
	* Date 		  : 05-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration clickOnSave()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(save, "xpath");
			this.page.element(save, "xpath").getOne().click();
		
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify order is marked as stat in 'Order Scheduler' page.
	* Date 		  : 05-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration verOrderIsMarkedAsStat(String order)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements("//b[contains(text(),'"+order+"')]/ancestor::td/preceding-sibling::td/img[@src='/wavelet/gifs.new/stat_or.gif']", "xpath");
			this.page.element("//b[contains(text(),'"+order+"')]/ancestor::td/preceding-sibling::td/img[@src='/wavelet/gifs.new/stat_or.gif']", "xpath").getOne().click();
		
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Machines And Clinics' link.
	* Date 		  : 17-Dec-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration clickOnMachinesAndClinics(String clinic)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements("//table/tbody//tr//td/a[contains(text(),'"+clinic+"')]", "xpath");
		this.page.element("//table/tbody//tr//td/a[contains(text(),'"+clinic+"')]", "xpath").getOne().click();
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Clinics and Machines' is displayed in scheduler page.
	* Date 		  : 17-Dec-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration verClinicsAndMachines(String clinic,String machine)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		String str = "//b[text()='"+clinic+"']/../../following-sibling::tr[1]//a[contains(text(),'"+machine+"')]";
		objWaitForElement.waitForElements(str, "xpath");
		this.page.element(str, "xpath").getOne().isDisplayed();
		assertTrue((this.page.element(str, "xpath")).isElementPresent());
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Search Orders' tab in Patient Registration page.
	* Date 		  : 13-Apr-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration clickOnSearchOrders()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(searchOrders, "xpath");
		this.page.element(searchOrders, "xpath").getOne().click();
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select time from time period dropdown in order search page.
	* Date 		  : 13-Apr-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration selTimePeriod(String strtime)
			throws Exception {
//		objFrames.switchToDefaultFrame().switchToRightFrame()
//				.switchToMainInRightFrame();
		objUserManagement.clickOnOkInAlertPopUp();
		objWaitForElement.waitForElements(time, "xpath");
		this.page.element(time, "xpath").webElementToSelect().selectByVisibleText(strtime);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to get total orders count.
	* Date 		  : 13-Apr-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public String getOrderCount() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(getCount,
				"xpath");
		String tx = this.page
				.element(getCount, "xpath").getOne()
				.getText();
		String str[] = tx.split(":");
		System.out.println(str[0]);
		System.out.println(str[1]);
		System.out.println(str[1].trim());

		return str[1].trim();
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Search Orders' button in 'Order search' page.
	* Date 		  : 13-Apr-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration clickOnSearchOrdersInOrderSearchPage()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(searchOrders1, "xpath");
		this.page.element(searchOrders1, "xpath").getOne().click();
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Reports' link of a order.
	* Date 		  : 13-Apr-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration clickOnReportsLinkOfAOrder(String order)
			throws Exception {
		String str = "//td[contains(text(),'"+order+"')]/..//a[text()='Reports']";
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(str, "xpath");
		this.page.element(str, "xpath").getOne().click();
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify orders Count.
	* Date 		  : 13-Apr-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration verOrdersCount(int str1, int str2)
			throws Exception {
		assertTrue(str1 < str2);

		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify orders is displayed.
	* Date 		  : 13-Apr-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration verOrdersDisplayed(String ord)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements("//td[contains(text(),'"+ord+"')]",
				"xpath");
		assertTrue((this.page
				.element("//td[contains(text(),'"+ord+"')]", "xpath")).getOne()
				.isDisplayed());

		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Search Reports' tab in Patient Registration page.
	* Date 		  : 15-Apr-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration clickOnSearchReports()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(searchReports, "xpath");
		this.page.element(searchReports, "xpath").getOne().click();
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select event option.
	* Date 		  : 15-Apr-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration selEventOption(String strevent)
			throws Exception {
//		objFrames.switchToDefaultFrame().switchToRightFrame()
//				.switchToMainInRightFrame();
		objUserManagement.clickOnOkInAlertPopUp();
		objWaitForElement.waitForElements(event, "xpath");
		this.page.element(event, "xpath").webElementToSelect().selectByVisibleText(strevent);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Search Reports' button in 'Report search' page.
	* Date 		  : 15-Apr-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration clickOnSearchReportsInReportSearchPage()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(searchReports1, "xpath");
		this.page.element(searchReports1, "xpath").getOne().click();
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select Start date/end date from calender window.
	* Date 		  : 21-Apr-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration selStartOrEndDateFromCalenderWindow(String req)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		String str = "//td[contains(text(),'"+req+"')]//following-sibling::td/img[@src='/wavelet/gifs.new/ris_calendar_icon.gif']";
		objWaitForElement.waitForElements(str, "xpath");
		this.page.element(str, "xpath").getOne().click();
		String mainwindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> itr = allwindows.iterator();
		while(itr.hasNext()){
			String childwindow = itr.next().toString();
			if(!childwindow.contains(mainwindow)){
				driver.switchTo().window(childwindow);
				this.page.element("//td/font[@color='blue']", "xpath").getOne().click();
			}
		}
		driver.switchTo().window(mainwindow);
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on logout button.
	* Date 		  : 16-May-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration clickOnLogOut()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToMainMenuFrame();
		objWaitForElement.waitForElements(logout, "xpath");
			this.page.element(logout, "xpath").getOne().click();
		
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select all machines checkbox in 'Scheduler' page.
	* Date 		  : 23-May-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration selAllMachines() throws Exception {
		// objFrames.switchToDefaultFrame().switchToRightFrame()
		// .switchToMainInRightFrame();
		List<WebElement> all = this.page.element(allMachinesChkbx, "xpath")
				.get();
		for (WebElement a : all) {
			if (a.isSelected() == false) {
				a.click();

			}
			System.out.println(" a");

		}

		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify orders is displayed in Scheduler page.
	* Date 		  : 23-May-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration verOrdersDisplayedInSchedulerPage(String ord)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements("//b[contains(text(),'"+ord+"')]",
				"xpath");
		assertTrue((this.page
				.element("//b[contains(text(),'"+ord+"')]", "xpath")).getOne()
				.isDisplayed());

		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Procedure code' text field.
	* Date 		  : 25-May-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public List<String> enterTextInProcedureCode(List<String> code)
			throws Exception {
		List<String> txt = new ArrayList<String>();
		for(int i=1; i<=4; i++){
			objFrames.switchToDefaultFrame().switchToRightFrame()
			.switchToMainInRightFrame();
		String str = "//input[@id='UNISERID"+i+"']";
		String str1 = "//form[@name='FRM']//td[text()='"+code.get(i-1)+"']";
		String str2 = "//td[contains(text(),'"+code.get(i-1)+"')]/following-sibling::td";
		objWaitForElement.waitForElements(str, "xpath");
		this.page.element(str, "xpath").getOne().click();
		this.page.element(str, "xpath").clearInputValue().sendKeys(code.get(i-1));
		objFrames.switchToIFrame("myFrame");
		String proc = (this.page.element(str2, "xpath")).getOne().getText();
		txt.add(proc);
		this.page.element(str1, "xpath").mouseOver();
		this.page.element(str1, "xpath").getOne().click();
		}
				
		return txt;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Search icon' of service location tab in 
	*               enter order page.
	* Date 		  : 09-Jun-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration clickOnSearchIconOfServiceLocation()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(searchServiceLocation, "xpath");
		this.page.element(searchServiceLocation, "xpath").getOne().click();
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select service location in enter order page.
	* Date 		  : 09-Jun-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration selServiceLocation(String sloc)
			throws Exception {
		String str = "//a[contains(text(),'"+sloc+"')]";
		objWaitForElement.waitForElements(str, "xpath");
		this.page.element(str, "xpath").getOne().click();
		Thread.sleep(3000);
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Patient ID Prefix.
	* Date 		  : 15-Jun-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration verPatientIdPrefix(String pidprfx)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(patientID, "id");
		String actual = (this.page.element(patientID, "id")).getOne().getAttribute("value");
		System.out.println(actual);
		assertTrue(actual.equals(pidprfx));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on delete patient tab.
	* Date 		  : 29-Jun-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration clickOnDeletePatient()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(deletePatient, "xpath");
		this.page.element(deletePatient, "xpath").getOne().click();
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify all the tabs('Registration','Enter Order','Scheduler',
	*               'Search Orders','Search Reports','') displaying in 'Patient Schedule Page' page.
	* Date 		  : 09-Nov-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration verAllTabsDisplaying() throws Exception {
		for (int i = 0; i < reqtabs.length-1; i++) {
			objFrames.switchToDefaultFrame().switchToRightFrame()
					.switchToMainInRightFrame();
			String str = "//td[@id='MainMenu']//img[@src='" + reqtabs[i] + "']";
			String str1 = "//img[@src='/wavelet/gifs.new/ris_help_menu.gif']";
			objWaitForElement.waitForElements(str, "xpath");
			assertTrue(this.page.element(str, "xpath").getOne().isDisplayed());
			System.out.println(i+str);
			assertTrue(this.page.element(str1, "xpath").getOne().isDisplayed());

		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select modality from modality dropdown in 'search order' page.
	* Date 		  : 10-Nov-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration selModalityInSearchOrder(String strmodality)
			throws Exception {
		Thread.sleep(3000);
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(selModality1, "xpath");
		this.page.element(selModality1, "xpath").webElementToSelect().selectByVisibleText(strmodality);		
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select Machine from Machine dropdown in 'search order' page.
	* Date 		  : 11-Nov-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration selMachineInSearchOrder(String strmodality)
			throws Exception {
		Thread.sleep(3000);
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(selMachineInSearchOrder, "xpath");
		this.page.element(selMachineInSearchOrder, "xpath").webElementToSelect().selectByVisibleText(strmodality);		
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on Scheduler link of a order in Order Search page.
	* Date 		  : 14-Nov-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration clickOnSchedulerLinkOfOrder(String ord)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		String str = "//td[contains(text(),'" + ord
				+ "')]//following-sibling::td/a[text()='Scheduler']";
		objWaitForElement.waitForElements(str, "xpath");
		this.page.element(str, "xpath").getOne().click();

		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Order Scheduler' page is displaying.
	* Date 		  : 14-Nov-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration verOrderSchedulerPage()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(orderScheduler, "xpath");
		assertTrue((this.page.element(orderScheduler, "xpath")).getOne()
				.isDisplayed());

		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify Scheduled order in 'Order Scheduler' page.
	* Date 		  : 14-Nov-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration verScheduledOrder(String ord)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		String str = "//b[contains(text(),'" + ord
				+ "')]/ancestor::td/following-sibling::td[text()='Scheduled']";
		objWaitForElement.waitForElements(str, "xpath");
		assertTrue((this.page.element(str, "xpath")).getOne().isDisplayed());

		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Report Search' page is displayed.
	* Date 		  : 15-Nov-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration verReportSearchPage() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(reportSearch, "xpath");
		assertTrue(this.page.element(reportSearch, "xpath").getOne()
				.isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Procedure length' in enter order page.
	* Date 		  : 14-Dec-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration selProcedureLength(String strpl)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(procedureLength, "ïd");
		this.page.element(procedureLength, "id").webElementToSelect().selectByVisibleText(strpl);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to get procedure time from time column in 'Order Scheduler' page.
	* Date 		  : 14-Dec-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public String getProcedureTime(String order)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		String pt = "//b[contains(text(),'"+order+"')]/ancestor::table[1]/../preceding-sibling::td[1]/b";
		objWaitForElement.waitForElements(pt, "xpath");
		String req = (this.page.element(pt, "xpath").getOne().getText());
		
		return req;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Insurance' tab in Patient Registration page.
	* Date 		  : 15-Dec-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration clickOnInsuranceTab()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(insuranceTab, "id");
		this.page.element(insuranceTab, "id").getOne().click();
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Insurance Plan ID' text field in 'Patient Registration' page.
	* Date 		  : 16-Dec-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration enterTextInInsurancePlanID(String insuranceid)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(insurancePlanID, "id");
		this.page.element(insurancePlanID, "id").clearInputValue().sendKeys(insuranceid);
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on search icon of 'company id' in 'Patient Registration' page.
	* Date 		  : 16-Dec-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration clickOnSearchIconOfCompanyId()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(compIdSearchIcon, "xpath");
		this.page.element(compIdSearchIcon, "xpath").getOne().click();
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select Insurance company in 'Select Insurance company' page.
	* Date 		  : 16-Dec-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration selInsuranceCompany(String insurancecmp)
			throws Exception {
		String str = "//a[contains(text(),'"+insurancecmp+"')]";
		objWaitForElement.waitForElements(str, "xpath");
		this.page.element(str, "xpath").getOne().click();
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on search icon of 'Plan Type' in 'Patient Registration' page.
	* Date 		  : 16-Dec-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration clickOnSearchIconOfPlanType()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(planTypeSearchIcon, "xpath");
		this.page.element(planTypeSearchIcon, "xpath").getOne().click();
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select Insurance plan in 'Select of Insurance plan' page.
	* Date 		  : 16-Dec-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration selInsurancePlan()
			throws Exception {
		String str = "(//a)[1]";
		objWaitForElement.waitForElements(str, "xpath");
		this.page.element(str, "xpath").getOne().click();
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Patient Class' from dropdown menu in enter order page.
	* Date 		  : 16-Dec-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration selPatientClass(String ptncls)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(patientClass, "id");
		this.page.element(patientClass, "id").webElementToSelect().selectByVisibleText(ptncls);
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on search icon of 'Patient Location' in 'enter order' page.
	* Date 		  : 16-Dec-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration clickOnSearchIconOfPatientLocation()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(patientLocationSearchIcon, "xpath");
		this.page.element(patientLocationSearchIcon, "xpath").getOne().click();
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select Patient Location in 'Select Patient Location' page.
	* Date 		  : 16-Dec-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration selPatientLocation(String patnloc)
			throws Exception {
		String str = "//a[contains(text(),'"+patnloc+"')]";
		objWaitForElement.waitForElements(str, "xpath");
		this.page.element(str, "xpath").getOne().click();
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on search icon of 'Referring Physician' in 'enter order' page.
	* Date 		  : 16-Dec-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration clickOnSearchIconOfReferringPhysician()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(referringPhysicianSearchIcon, "xpath");
		this.page.element(referringPhysicianSearchIcon, "xpath").getOne().click();
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select doctor/refering physician in 'Select Doctor' page.
	* Date 		  : 16-Dec-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration selDoctorOrRefPhy(String refphy)
			throws Exception {
		String str = "//a[contains(text(),'"+refphy+"')]";
		objWaitForElement.waitForElements(str, "xpath");
		this.page.element(str, "xpath").getOne().click();
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on search icon of 'Assign Provider' in 'enter order' page.
	* Date 		  : 16-Dec-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration clickOnSearchIconOfAssignProvider()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(assignProviderSearchIcon, "xpath");
		this.page.element(assignProviderSearchIcon, "xpath").getOne().click();
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on search icon of 'Attending Doctor' in 'enter order' page.
	* Date 		  : 16-Dec-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration clickOnSearchIconOfAttendingDoctor()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(attendingDoctorSearchIcon, "xpath");
		this.page.element(attendingDoctorSearchIcon, "xpath").getOne().click();
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on search icon of 'Insurance Company' in 'enter order' page.
	* Date 		  : 16-Dec-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration clickOnSearchIconOfInsuranceCompany()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(insuranceCompanySearchIcon, "xpath");
		this.page.element(insuranceCompanySearchIcon, "xpath").getOne().click();
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Patient' tab in Patient Registration page.
	* Date 		  : 16-Dec-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public PatientScheduleRegistration clickOnPatientTab()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(patientTab, "id");
		this.page.element(patientTab, "id").getOne().click();
				
		return this;
	}
	

}
