package page;

import java.util.ArrayList;
import java.util.List;

import module.Frames;

import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;
import qaframework.lib.pageObject.PageObject;
import qaframework.lib.userDefinedFunctions.WaitForElement;

public class RISSettings extends PageObject{
	WebDriver driver;
	WaitForElement objWaitForElement;
	Frames objFrames;
	
	private String clinicsAndMachines = "//a[text()='Clinics & Machines']",
			       clinicsAndMachines1 = "//img[@src='/.cobalt/images/a_top_RIS_machine_list.gif']",
			       mtf = "//input[@name='mtf']",
			       name = "//input[@name='code']",
			       address = "//input[@name='address']",
			       state = "//input[@name='state']",
			       phone = "//input[@name='phone']",
			       email = "//input[@name='email']",
			       add = "(//img[@src='/.cobalt/images/add_but.gif'])[2]",
			       machineId = "//input[@type='TEXT'][@name='MACHINE_ID']",
			       modality = "mod_list",
			       alwaysAvailableRadioBtn = "//input[@type='RADIO'][@name='SCHEDULE'][@value='1']",
			       risConfigurationSettings = "//b[text()='RIS Configuration Settings']",
			       description = "//input[@type='TEXT'][@name='descr']",
			       city = "//input[@type='TEXT'][@name='city']",
			       zip = "//input[@type='TEXT'][@name='zip']",
			       contact = "//input[@type='TEXT'][@name='contact']",
			       fax = "//input[@type='TEXT'][@name='fax']",
			       web = "//input[@type='TEXT'][@name='web']",
			       phoneAddMachine = "//input[@type='TEXT'][@name='PHONE']",
			       info = "//input[@type='TEXT'][@name='INFO']",
			       location = "//input[@type='TEXT'][@name='LOCATION']",
			       saveChanges = "//img[@src='/.cobalt/images/save_but.gif']",
			       clinicProcedure = "//a[text()='Clinic Procedure']",
			       clinicProcedure1 = "//img[@src='/.cobalt/images/a_top_RIS_clinic_proc.gif']",
			       openPageServiceLocations = "//td[contains(text(),'Service Locations')]/following-sibling::td/a[text()='Open Page']",
			       serviceLocation = "//b[text()='Service Location']",
			       locationNameTextField = "//input[@name='name']",
			       locationShortNameTextField = "//input[@name='stat_name']",
			       add1 = "//img[@src='/.cobalt/images/add_but.gif']",
			       openPageGeneralRISSettings = "//td[contains(text(),'General RIS settings')]/following-sibling::td/a[text()='Open Page']",
			       patientIDPrefix = "//input[@type='TEXT'][@name='patient_id_prefix']",
			       openPageMandatoryFields = "//td[contains(text(),'Mandatory Fields')]/following-sibling::td/a",
			       setDefault = "//a[text()='Set default']",
			       patientRegistrationLink = "reg_item",
			       enterOrderLink = "ord_item",
			       openPagePatientLocations = "//td[contains(text(),'Patient Locations')]//following-sibling::td/a[text()='Open Page']",
			       patientLocationPage = "//b[text()='Patient Location']",
			       pLShortName = "//input[@name='worklist_name']",
			       openPageDoctors = "//td[contains(text(),'Doctors')]/following-sibling::td/a[text()='Open Page']",
			       doctorLastName = "//input[@name='name_l']",
			       doctorFirstName = "//input[@name='name_f']",
			       UPIN = "//input[@name='upin']",
			       openPageInsuranceCompanies = "//td[contains(text(),'Insurance companies')]/following-sibling::td/a[text()='Open Page']",
			       companyIDTxtFld = "comp_id";
	
	public RISSettings(WebDriver _driver) throws Exception{
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
		objFrames = new Frames(this.driver);
		
	}
	
	/**********************************************************************************
	  * Description : This function is to click on 'save changes' button.
	  * Date        : 15-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public RISSettings clickOnSaveChanges() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(saveChanges, "xpath");
		this.page.element(saveChanges, "xpath").getOne().click();
		Thread.sleep(3000);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'clinics And Machines' tab.
	* Date 		  : 21-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public RISSettings clickClinicsAndMachines()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToSubMenuInRightFrame();
		objWaitForElement.waitForElements(clinicsAndMachines, "xpath");
		this.page.element(clinicsAndMachines, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'clinics And Machines' tab.
	* Date 		  : 21-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public RISSettings clickClinicsAndMachines1()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToSubMenuInRightFrame();
		objWaitForElement.waitForElements(clinicsAndMachines1, "xpath");
		this.page.element(clinicsAndMachines1, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter the text in 'MTF' text field.
	* Date 		  : 21-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public RISSettings enterTextInMTF(String strmtf)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(mtf, "xpath");
		this.page.element(mtf, "xpath").clearInputValue().sendKeys(strmtf);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter the text in 'Name' text field.
	* Date 		  : 21-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public RISSettings enterTextInName(String strname)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(name, "xpath");
		this.page.element(name, "xpath").clearInputValue().sendKeys(strname);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter the text in 'ADDRESS' text field.
	* Date 		  : 21-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public RISSettings enterTextInAddress(String straddress)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(address, "xpath");
		this.page.element(address, "xpath").clearInputValue().sendKeys(straddress);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter the text in 'State' text field.
	* Date 		  : 21-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public RISSettings enterTextInState(String strstate)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(state, "xpath");
		this.page.element(state, "xpath").clearInputValue().sendKeys(strstate);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter the text in 'State' text field.
	* Date 		  : 21-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public RISSettings enterTextInPhone(String strphone)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(phone, "xpath");
		this.page.element(phone, "xpath").clearInputValue().sendKeys(strphone);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter the text in 'email' text field.
	* Date 		  : 21-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public RISSettings enterTextInEmail(String stremail)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(email, "xpath");
		this.page.element(email, "xpath").clearInputValue().sendKeys(stremail);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify saved clinic in clinic list page.
	* Date 		  : 21-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public RISSettings verClinic(String clinic)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements("//a[contains(text(),'"+clinic+"')]", "xpath");
		assertTrue(this.page.element("//a[contains(text(),'"+clinic+"')]", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on clinic link in clinic list page.
	* Date 		  : 29-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public RISSettings clickOnClinicLink(String clinic) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements("//a[contains(text(),'" + clinic
				+ "')]", "xpath");
		this.page.element("//a[contains(text(),'" + clinic + "')]", "xpath")
				.mouseOver();
		this.page.element("//a[contains(text(),'" + clinic + "')]", "xpath")
				.getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on second add button in clinic list page.
	* Date 		  : 29-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public RISSettings clickOnSecAddButton()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(add, "xpath");
		this.page.element(add, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter the text in 'Machine ID' text field.
	* Date 		  : 29-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public RISSettings enterTextInMachineID(String strMachineid)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(machineId, "xpath");
		this.page.element(machineId, "xpath").getOne().click();
		this.page.element(machineId, "xpath").clearInputValue().sendKeys(strMachineid);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select Modality.
	* Date 		  : 29-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public RISSettings selModality(String strModality)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(modality, "id");
		this.page.element(modality, "id").webElementToSelect().selectByVisibleText(strModality);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Always Available' radio button in add new machine page.
	* Date 		  : 29-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public RISSettings selAlwaysAvailableRadioButton()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(alwaysAvailableRadioBtn, "xpath");
		if(this.page.element(alwaysAvailableRadioBtn, "xpath").getOne().isSelected()==false){
			this.page.element(alwaysAvailableRadioBtn, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'RIS Configuration Settings' page is displayed.
	* Date 		  : 14-Dec-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public RISSettings verRISConfigurationSettingsPage()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(risConfigurationSettings, "xpath");
		assertTrue(this.page.element(risConfigurationSettings, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter the text in 'Description' text field.
	* Date 		  : 17-Dec-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public RISSettings enterTextInDescription(String strdes)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(description, "xpath");
		this.page.element(description, "xpath").clearInputValue().sendKeys(strdes);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter the text in 'City' text field.
	* Date 		  : 17-Dec-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public RISSettings enterTextInCity(String strcity)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(city, "xpath");
		this.page.element(city, "xpath").clearInputValue().sendKeys(strcity);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter the text in 'Zip' text field.
	* Date 		  : 17-Dec-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public RISSettings enterTextInZip(String strzip)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(zip, "xpath");
		this.page.element(zip, "xpath").clearInputValue().sendKeys(strzip);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter the text in 'contact' text field.
	* Date 		  : 17-Dec-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public RISSettings enterTextInContact(String strcontact)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(contact, "xpath");
		this.page.element(contact, "xpath").clearInputValue().sendKeys(strcontact);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter the text in 'fax' text field.
	* Date 		  : 17-Dec-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public RISSettings enterTextInFax(String strfax)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(fax, "xpath");
		this.page.element(fax, "xpath").clearInputValue().sendKeys(strfax);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter the text in 'web' text field.
	* Date 		  : 17-Dec-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public RISSettings enterTextInWeb(String strweb)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(web, "xpath");
		this.page.element(web, "xpath").clearInputValue().sendKeys(strweb);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter the text in 'Add new machine' text field.
	* Date 		  : 17-Dec-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public RISSettings enterTextInPhoneAddMachine(String strphone)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(phoneAddMachine, "xpath");
		this.page.element(phoneAddMachine, "xpath").clearInputValue().sendKeys(strphone);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter the text in 'info' text field.
	* Date 		  : 17-Dec-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public RISSettings enterTextInInfo(String strinfo)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(info, "xpath");
		this.page.element(info, "xpath").clearInputValue().sendKeys(strinfo);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter the text in 'Location' text field.
	* Date 		  : 17-Dec-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public RISSettings enterTextInLocation(String strloc)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(location, "xpath");
		this.page.element(location, "xpath").clearInputValue().sendKeys(strloc);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'clinic procedure' tab.
	* Date 		  : 24-May-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public RISSettings clickOnClinicProcedure()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToSubMenuInRightFrame();
		objWaitForElement.waitForElements(clinicProcedure, "xpath");
		this.page.element(clinicProcedure, "xpath").getOne().click();
		return this;
	}
	/**********************************************************************************
	* Description : This function is to click on 'clinic procedure' tab.
	* Date 		  : 24-May-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public RISSettings clickOnClinicProcedure1()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToSubMenuInRightFrame();
		objWaitForElement.waitForElements(clinicProcedure1, "xpath");
		this.page.element(clinicProcedure1, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select clinic procedure checkbox.
	* Date 		  : 24-May-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public List<String> selClinicProcedureCheckbox()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		String value;
		List<String> list = new ArrayList<String>();
		for(int i=1; i<=4;i++){
		String str1 = "(//input[@type='CHECKBOX']/../following-sibling::td/font[contains(text(),'70')])["+i+"]";
		String str	= "(//td/font[contains(text(),'70')]/../preceding-sibling::td[1]/input[@type='CHECKBOX'])["+i+"]";
		objWaitForElement.waitForElements(str, "xpath");
		if((this.page.element(str, "xpath")).getOne().isSelected()==false){
			this.page.element(str, "xpath").getOne().click();
		}
		 value = (this.page.element(str1, "xpath")).getOne().getText();
		 list.add(value);
		}
		System.out.println(list.size()+" this is the pro lnth");
		return list;
	}
	
	/**********************************************************************************
	* Description : This function is to click on Open page link of Service Locations.
	* Date 		  : 09-Jun-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public RISSettings clickOnOpenPageOfServiceLocations()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(openPageServiceLocations, "xpath");
		this.page.element(openPageServiceLocations, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify Service Location page is displayed.
	* Date 		  : 09-Jun-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public RISSettings verServiceLocationPage()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(serviceLocation, "xpath");
		assertTrue(this.page.element(serviceLocation, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter the text in location name text field.
	* Date 		  : 09-Jun-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public RISSettings enterTextInLocationName(String loc)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(locationNameTextField, "xpath");
		this.page.element(locationNameTextField, "xpath").getOne().clear();
		this.page.element(locationNameTextField, "xpath").getOne().sendKeys(loc);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter the text in location name text field.
	* Date 		  : 09-Jun-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public RISSettings enterTextInLocationShortName(String loc)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(locationShortNameTextField, "xpath");
		this.page.element(locationShortNameTextField, "xpath").getOne().clear();
		this.page.element(locationShortNameTextField, "xpath").getOne().sendKeys(loc);
		return this;
	}
	/**********************************************************************************
	* Description : This function is to click on Add in Service Locations page.
	* Date 		  : 09-Jun-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public RISSettings clickOnAdd()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(add1, "xpath");
		this.page.element(add1, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on Open page link of 'General RIS settings'.
	* Date 		  : 15-Jun-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public RISSettings clickOnOpenPageOfGeneralRISSettings()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(openPageGeneralRISSettings, "xpath");
		this.page.element(openPageGeneralRISSettings, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter the text in 'Patient ID Prefix' text field.
	* Date 		  : 15-Jun-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public RISSettings enterTextInPatientIDPrefix(String strPatientid)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(patientIDPrefix, "xpath");
		this.page.element(patientIDPrefix, "xpath").getOne().click();
		this.page.element(patientIDPrefix, "xpath").clearInputValue().sendKeys(strPatientid);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on Open page link of 'Mandatory Fields'.
	* Date 		  : 12-Sep-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public RISSettings clickOnOpenPageOfMandatoryFields()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(openPageMandatoryFields, "xpath");
		this.page.element(openPageMandatoryFields, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Set default' link in 'Mandatory Fields' page.
	* Date 		  : 12-Sep-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public RISSettings clickOnSetDefault()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(setDefault, "xpath");
		this.page.element(setDefault, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Patient Registration' link.
	* Date 		  : 22-Sep-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public RISSettings clickOnPatientRegistrationLink()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(patientRegistrationLink, "id");
		this.page.element(patientRegistrationLink, "id").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Enter Order' link.
	* Date 		  : 22-Sep-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public RISSettings clickOnEnterOrderLink()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(enterOrderLink, "id");
		this.page.element(enterOrderLink, "id").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on Open page link of Patient Locations.
	* Date 		  : 15-Dec-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public RISSettings clickOnOpenPageOfPatientLocations()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(openPagePatientLocations, "xpath");
		this.page.element(openPagePatientLocations, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify Patient Location page is displayed.
	* Date 		  : 15-Dec-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public RISSettings verPatientLocationPage()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(patientLocationPage, "xpath");
		assertTrue(this.page.element(patientLocationPage, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter the text in Short Name text field in Patient Location page.
	* Date 		  : 15-Dec-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public RISSettings enterTextPLShortName(String sn)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(pLShortName, "xpath");
		this.page.element(pLShortName, "xpath").getOne().clear();
		this.page.element(pLShortName, "xpath").getOne().sendKeys(sn);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on Open page link of Doctors.
	* Date 		  : 15-Dec-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public RISSettings clickOnOpenPageOfDoctors()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(openPageDoctors, "xpath");
		this.page.element(openPageDoctors, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter the text in last Name text field in DOCTORS page.
	* Date 		  : 15-Dec-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public RISSettings enterTextInDoctorLastName(String ln)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(doctorLastName, "xpath");
		this.page.element(doctorLastName, "xpath").getOne().clear();
		this.page.element(doctorLastName, "xpath").getOne().sendKeys(ln);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter the text in first Name text field in DOCTORS page.
	* Date 		  : 15-Dec-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public RISSettings enterTextInDoctorFirstName(String fn)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(doctorFirstName, "xpath");
		this.page.element(doctorFirstName, "xpath").getOne().clear();
		this.page.element(doctorFirstName, "xpath").getOne().sendKeys(fn);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter the text in 'UPIN' text field in DOCTORS page.
	* Date 		  : 15-Dec-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public RISSettings enterTextInUPIN(String str)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(UPIN, "xpath");
		this.page.element(UPIN, "xpath").getOne().clear();
		this.page.element(UPIN, "xpath").getOne().sendKeys(str);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on Open page link of Insurance companies.
	* Date 		  : 16-Dec-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public RISSettings clickOnOpenPageOfInsuranceCompanies()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(openPageInsuranceCompanies, "xpath");
		this.page.element(openPageInsuranceCompanies, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter the text in 'Company ID' text field in INSURANCE COMPANY page.
	* Date 		  : 16-Dec-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public RISSettings enterTextInCompanyID(String compid)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(companyIDTxtFld, "name");
		this.page.element(companyIDTxtFld, "name").getOne().clear();
		this.page.element(companyIDTxtFld, "name").getOne().sendKeys(compid);
		return this;
	}

}
