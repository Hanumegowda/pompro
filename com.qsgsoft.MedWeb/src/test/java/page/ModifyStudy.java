package page;

import module.Frames;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import qaframework.lib.pageObject.PageObject;
import qaframework.lib.userDefinedFunctions.WaitForElement;

public class ModifyStudy extends PageObject {
	WebDriver driver;
	WaitForElement objWaitForElement;
	Frames objFrames;
	
	private String accessionNumber = "//td[contains(text(),'Accession Number')]/..//input",
			close = "//a[text()='CLOSE']",
			mtfField = "//td[contains(text(),'MTF')]/..//input",
			institutionName1 = "//td[contains(text(),'Institution Name')]/following-sibling::td/input",
			modalityInStudyEditorPage = "//td[contains(text(),'Modality')]/following-sibling::td/input",
			commentsTxtFld = "//td[contains(text(),'Comments')]/following-sibling::td/input",
			dob = "//td[contains(text(),'DOB')]/following-sibling::td/input",
			patientID = "//td[contains(text(),'Patient ID')]/following-sibling::td/input",
			patientName = "//td[contains(text(),'Patient Name')]/following-sibling::td/input",
			physicianName = "//td[contains(text(),\"Referring Physician's Name\")]/following-sibling::td/input",
			referringPhysicianAddress = "//td[contains(text(),\"Referring Physician's Address\")]/following-sibling::td/input",
			referringPhysicianTelephoneNumber = "//td[contains(text(),\"Referring Physician's Telephone Number\")]/following-sibling::td/input",
			description = "//td[contains(text(),'Study Description')]/following-sibling::td/input",
			patientSex = "//td[contains(text(),'Patient Sex')]/following-sibling::td/input",
			location = "//td[contains(text(),'Location')]/following-sibling::td/input",
			mtfTextField = "//td[contains(text(),'MTF')]/following-sibling::td/input",
			studyDate = "//td[contains(text(),'Study Date')]/following-sibling::td/input",
		    studyTime = "//td[contains(text(),'Study Time')]/following-sibling::td/input",
	        bodyPartExamined = "//td[contains(text(),'Body Part Examined')]/following-sibling::td/input",
	        protocolName = "//td[contains(text(),'Protocol Name')]/following-sibling::td/input";
	
	public ModifyStudy(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
		objFrames = new Frames(this.driver);
	}
	
	/**********************************************************************************
	* Description : This function is to clear text in 'Accession Number' text field.
	* Date 		  : 01-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ModifyStudy clearTextInAccessionNumber()
			throws Exception {
		objWaitForElement.waitForElements(accessionNumber, "xpath");
		this.page.element(accessionNumber, "xpath").clearInputValue();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on close link.
	* Date 		  : 01-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ModifyStudy clickOnClose()
			throws Exception {
		objWaitForElement.waitForElements(close, "xpath");
		this.page.element(close, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to get text in 'Accession Number' text field and to verify this text.
	* Date 		  : 02-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public String getTextInAccessionNumberAndVer(String reqd)
			throws Exception {
		objWaitForElement.waitForElements(accessionNumber, "xpath");
		String str = this.page.element(accessionNumber, "xpath").getOne().getAttribute("value");
		assertTrue(str.contains(reqd));
		return str;
	}
	
	/**********************************************************************************
	* Description : This function is to get text in 'Accession Number' text field and to verify 
	*               this text that is in the form 'web#MEDWEB254878'.
	* Date 		  : 02-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public String getTextInAccessionNumberAndVerWithNumber(String reqd)
			throws Exception {
		objWaitForElement.waitForElements(accessionNumber, "xpath");
		String str = this.page.element(accessionNumber, "xpath").getOne().getAttribute("value");
		assertTrue(str.contains(reqd));
		String[] str1 = str.split("B");
		assertTrue((Integer.parseInt(str1[1]))>0);
		return str;
	}
	
	/**********************************************************************************
	* Description : This function is to get text in ' MTF' text field and to verify this text.
	* Date 		  : 02-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ModifyStudy getTextInMTFFieldAndVer(String reqd)
			throws Exception {
		objWaitForElement.waitForElements(mtfField, "xpath");
		String str = this.page.element(mtfField, "xpath").getOne().getAttribute("value");
		assertTrue(str.contains(reqd));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to get text in 'Accession Number' text field and to
	*               verify text not contain MTF code.
	* Date 		  : 04-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public String getTextInAccessionNumberAndVerNotContainMtfCode(String reqd)
			throws Exception {
		objWaitForElement.waitForElements(accessionNumber, "xpath");
		String str = this.page.element(accessionNumber, "xpath").getOne().getAttribute("value");
		assertTrue(!(str.contains(reqd)));
		assertTrue(str.matches("[0-9]+")&&str.length()>2);
		return str;
	}
	
	/**********************************************************************************
	* Description : This function is to get text in 'MTF' text field and to verify it not
	*               contains MTF code.
	* Date 		  : 04-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ModifyStudy getTextInMTFFieldAndVerMtfCodeNotDisplayed(String reqd)
			throws Exception {
		objWaitForElement.waitForElements(mtfField, "xpath");
		String str = this.page.element(mtfField, "xpath").getOne().getAttribute("value");
		assertTrue(!(str.contains(reqd)));
		assertTrue(str.isEmpty());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to get Institution Name from Study Editor Page.
	* Date 		  : 09-Dec-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public String getInstitutionNameInStudyEditorPage() throws Exception {
		objWaitForElement.waitForElements(institutionName1, "xpath");
		String str = this.page.element(institutionName1, "xpath").getOne().getAttribute("value");
		return str;
	}
	
	/**********************************************************************************
	* Description : This function is to get modality of study from Study Editor Page.
	* Date 		  : 09-Dec-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public String getModalityInStudyEditorPage() throws Exception {
		objWaitForElement.waitForElements(modalityInStudyEditorPage, "xpath");
		String str = this.page.element(modalityInStudyEditorPage, "xpath").getOne().getAttribute("value");
		return str;
	}
	
	/**********************************************************************************
	* Description : This function is to get DOB from Study Editor Page.
	* Date 		  : 09-Dec-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public String getDOBInStudyEditorPage() throws Exception {
		objWaitForElement.waitForElements(dob, "xpath");
		String str = this.page.element(dob, "xpath").getOne().getAttribute("value");
		return str;
	}
	
	/**********************************************************************************
	* Description : This function is to get Patient ID from Study Editor Page.
	* Date 		  : 09-Dec-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public String getPatientIDInStudyEditorPage() throws Exception {
		objWaitForElement.waitForElements(patientID, "xpath");
		String str = this.page.element(patientID, "xpath").getOne().getAttribute("value");
		return str;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in Referring Physician's Name field in Study Editor Page.
	* Date 		  : 09-Dec-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ModifyStudy enterTextInReferringPhysicianName(String strphysician) throws Exception {
		objWaitForElement.waitForElements(physicianName, "xpath");
		this.page.element(physicianName, "xpath").clearInputValue().sendKeys(strphysician);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in  Referring Physician's Address field in Study Editor Page.
	* Date 		  : 09-Dec-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ModifyStudy enterTextInReferringPhysicianAddress(String strphysicianaddr) throws Exception {
		objWaitForElement.waitForElements(referringPhysicianAddress, "xpath");
		this.page.element(referringPhysicianAddress, "xpath").clearInputValue().sendKeys(strphysicianaddr);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in  Referring Physician's Telephone Number field in Study Editor Page.
	* Date 		  : 09-Dec-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ModifyStudy enterTextInReferringPhysicianTelephoneNumber(String strphysicianphnnum) throws Exception {
		objWaitForElement.waitForElements(referringPhysicianTelephoneNumber, "xpath");
		this.page.element(referringPhysicianTelephoneNumber, "xpath").clearInputValue().sendKeys(strphysicianphnnum);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Study Description' field in Study Editor Page.
	* Date 		  : 09-Dec-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ModifyStudy enterTextInStudyDescription(String strdescription) throws Exception {
		objWaitForElement.waitForElements(description, "xpath");
		this.page.element(description, "xpath").clearInputValue().sendKeys(strdescription);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Protocol Name' field in Study Editor Page.
	* Date 		  : 09-Dec-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ModifyStudy enterTextInProtocolName(String strprotocol) throws Exception {
		objWaitForElement.waitForElements(protocolName, "xpath");
		this.page.element(protocolName, "xpath").clearInputValue().sendKeys(strprotocol);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Body Part Examined' field in Study Editor Page.
	* Date 		  : 09-Dec-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ModifyStudy enterTextInBodyPartExamined(String str) throws Exception {
		objWaitForElement.waitForElements(bodyPartExamined, "xpath");
		this.page.element(bodyPartExamined, "xpath").clearInputValue().sendKeys(str);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Patient Sex' field in Study Editor Page.
	* Date 		  : 09-Dec-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ModifyStudy enterTextInPatientSex(String  strpatientsex) throws Exception {
		objWaitForElement.waitForElements(patientSex, "xpath");
		this.page.element(patientSex, "xpath").clearInputValue().sendKeys(strpatientsex);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Accession Number' field in Study Editor Page.
	* Date 		  : 09-Dec-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ModifyStudy enterTextInAccessionNumber(String  strpatientan) throws Exception {
		objWaitForElement.waitForElements(accessionNumber, "xpath");
		this.page.element(accessionNumber, "xpath").clearInputValue().sendKeys(strpatientan);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'location' field in Study Editor Page.
	* Date 		  : 09-Dec-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ModifyStudy enterTextInLocation(String  strlocation) throws Exception {
		objWaitForElement.waitForElements(location, "xpath");
		this.page.element(location, "xpath").clearInputValue().sendKeys(strlocation);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter the text in 'DOB' text field in Change study fields page.
	  * Date        : 14-Apr-2016
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public ModifyStudy enterTextInDOBTextField(String strdob) throws Exception {
		objWaitForElement.waitForElements(dob, "xpath");
		this.page.element(dob, "xpath").clearInputValue().sendKeys(strdob);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter the text in 'patient id' text field in Change study fields page.
	  * Date        : 14-Apr-2016
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public ModifyStudy enterTextInPatientIDTextField(String strpid) throws Exception {
		objWaitForElement.waitForElements(patientID, "xpath");
		this.page.element(patientID, "xpath").clearInputValue().sendKeys(strpid);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter the text in 'Patient Name' text field in Change study fields page.
	  * Date        : 14-Apr-2016
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public ModifyStudy enterTextInPatientNameTextField(String strpn) throws Exception {
		objWaitForElement.waitForElements(patientName, "xpath");
		this.page.element(patientName, "xpath").clearInputValue().sendKeys(strpn);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'MTF' text field in Study Editor Page.
	* Date 		  : 12-May-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ModifyStudy enterTextInMTF(String  mtf) throws Exception {
		objWaitForElement.waitForElements(mtfTextField, "xpath");
		this.page.element(mtfTextField, "xpath").clearInputValue().sendKeys(mtf);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter the text in 'Study Date' text field in Change study fields page.
	 * Date        : 31-Aug-2016
     * Author      : Hanumegowda
     **********************************************************************************/
	public ModifyStudy enterTextInStudyDateTextField(String strdate)
			throws Exception {
		objWaitForElement.waitForElements(studyDate, "xpath");
		this.page.element(studyDate, "xpath").clearInputValue()
				.sendKeys(strdate);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter the text in 'Study Time' text field in Change study fields page.
	 * Date        : 31-Aug-2016
     * Author      : Hanumegowda
     **********************************************************************************/
	public ModifyStudy enterTextInStudyTimeTextField(String strtime)
			throws Exception {
		objWaitForElement.waitForElements(studyTime, "xpath");
		this.page.element(studyTime, "xpath").clearInputValue()
				.sendKeys(strtime);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter the text in 'Modality' text field in Change study fields page.
	 * Date        : 31-Aug-2016
     * Author      : Hanumegowda
     **********************************************************************************/
	public ModifyStudy enterTextInModalityTextField(String strmodality)
			throws Exception {
		objWaitForElement.waitForElements(modalityInStudyEditorPage, "xpath");
		this.page.element(modalityInStudyEditorPage, "xpath").clearInputValue()
				.sendKeys(strmodality);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter the text in 'Comments' text field in Change study fields page.
	 * Date        : 31-Aug-2016
     * Author      : Hanumegowda
     **********************************************************************************/
	public ModifyStudy enterTextInCommentsTextField(String strcomments)
			throws Exception {
		objWaitForElement.waitForElements(commentsTxtFld, "xpath");
		this.page.element(commentsTxtFld, "xpath").clearInputValue()
				.sendKeys(strcomments);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter the text in 'Institution Name' text field in Change study fields page.
	 * Date        : 31-Aug-2016
     * Author      : Hanumegowda
     **********************************************************************************/
	public ModifyStudy enterTextInInstitutionNameTextField(String strinstname)
			throws Exception {
		objWaitForElement.waitForElements(institutionName1, "xpath");
		this.page.element(institutionName1, "xpath").clearInputValue()
				.sendKeys(strinstname);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify the text in 'Patient Name' text field in Change study fields page.
	  * Date        : 14-Sep-2016
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public ModifyStudy verTextInPatientNameTextField(String strpn) throws Exception {
		objWaitForElement.waitForElements(patientName, "xpath");
		String actual = this.page.element(patientName, "xpath").getOne().getAttribute("value");
		assertTrue(actual.equals(strpn));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify the text in 'patient id' text field in Change study fields page.
	  * Date        : 14-Sep-2016
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public ModifyStudy verTextInPatientIDTextField(String strpid) throws Exception {
		objWaitForElement.waitForElements(patientID, "xpath");
		String actual = this.page.element(patientID, "xpath").getOne().getAttribute("value");
		assertTrue(actual.equals(strpid));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify text in 'Patient Sex' field in Study Editor Page.
	* Date 		  : 14-Sep-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ModifyStudy verTextInPatientSex(String  strpatientsex) throws Exception {
		objWaitForElement.waitForElements(patientSex, "xpath");
		String actual = this.page.element(patientSex, "xpath").getOne().getAttribute("value");
		assertTrue(actual.equals(strpatientsex));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify text in 'Accession Number' field in Study Editor Page.
	* Date 		  : 14-Sep-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ModifyStudy verTextInAccessionNumber(String  strpatientan) throws Exception {
		objWaitForElement.waitForElements(accessionNumber, "xpath");
		String actual = this.page.element(accessionNumber, "xpath").getOne().getAttribute("value");
		assertTrue(actual.equals(strpatientan));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify the text in 'Study Date' text field in Change study fields page.
	 * Date        : 14-Sep-2016
     * Author      : Hanumegowda
     **********************************************************************************/
	public ModifyStudy verTextInStudyDateTextField(String strdate)
			throws Exception {
		objWaitForElement.waitForElements(studyDate, "xpath");
		String actual = this.page.element(studyDate, "xpath").getOne().getAttribute("value");
		assertTrue(actual.equals(strdate));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify the text in 'Study Time' text field in Change study fields page.
	 * Date        : 14-Sep-2016
     * Author      : Hanumegowda
     **********************************************************************************/
	public ModifyStudy verTextInStudyTimeTextField(String strtime)
			throws Exception {
		objWaitForElement.waitForElements(studyTime, "xpath");
		String actual = this.page.element(studyTime, "xpath").getOne().getAttribute("value");
		assertTrue(actual.equals(strtime));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify text in 'Study Description' field in Study Editor Page.
	* Date 		  : 14-Sep-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ModifyStudy verTextInStudyDescription(String strdescription) throws Exception {
		objWaitForElement.waitForElements(description, "xpath");
		String actual = this.page.element(description, "xpath").getOne().getAttribute("value");
		assertTrue(actual.equals(strdescription));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify text in 'Body Part Examined' field in Study Editor Page.
	* Date 		  : 14-Sep-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ModifyStudy verTextInBodyPartExamined(String str) throws Exception {
		objWaitForElement.waitForElements(bodyPartExamined, "xpath");
		String actual = this.page.element(bodyPartExamined, "xpath").getOne().getAttribute("value");
		assertTrue(actual.equals(str));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify text in 'Protocol Name' field in Study Editor Page.
	* Date 		  : 14-Sep-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ModifyStudy verTextInProtocolName(String strprotocol) throws Exception {
		objWaitForElement.waitForElements(protocolName, "xpath");
		String actual = this.page.element(protocolName, "xpath").getOne().getAttribute("value");
		assertTrue(actual.equals(strprotocol));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify the text in 'DOB' text field in Change study fields page.
	  * Date        : 14-Sep-2016
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public ModifyStudy verTextInDOBTextField(String strdob) throws Exception {
		objWaitForElement.waitForElements(dob, "xpath");
		String actual = this.page.element(dob, "xpath").getOne().getAttribute("value");
		assertTrue(actual.equals(strdob));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify the text in 'Modality' text field in Change study fields page.
	 * Date        : 14-Sep-2016
     * Author      : Hanumegowda
     **********************************************************************************/
	public ModifyStudy verTextInModalityTextField(String strmodality)
			throws Exception {
		objWaitForElement.waitForElements(modalityInStudyEditorPage, "xpath");
		String actual = this.page.element(modalityInStudyEditorPage, "xpath").getOne().getAttribute("value");
		assertTrue(actual.equals(strmodality));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify the text in 'Institution Name' text field in Change study fields page.
	 * Date        : 14-Sep-2016
     * Author      : Hanumegowda
     **********************************************************************************/
	public ModifyStudy verTextInInstitutionNameTextField(String strinstname)
			throws Exception {
		objWaitForElement.waitForElements(institutionName1, "xpath");
		String actual = this.page.element(institutionName1, "xpath").getOne().getAttribute("value");
		assertTrue(actual.equals(strinstname));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify text in Referring Physician's Name field in Study Editor Page.
	* Date 		  : 14-Sep-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ModifyStudy verTextInReferringPhysicianName(String strphysician) throws Exception {
		objWaitForElement.waitForElements(physicianName, "xpath");
		String actual = this.page.element(physicianName, "xpath").getOne().getAttribute("value");
		assertTrue(actual.equals(strphysician));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify text in  Referring Physician's Address field in Study Editor Page.
	* Date 		  : 14-Sep-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ModifyStudy verTextInReferringPhysicianAddress(String strphysicianaddr) throws Exception {
		objWaitForElement.waitForElements(referringPhysicianAddress, "xpath");
		String actual = this.page.element(referringPhysicianAddress, "xpath").getOne().getAttribute("value");
		assertTrue(actual.equals(strphysicianaddr));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify text in  Referring Physician's Telephone Number field in Study Editor Page.
	* Date 		  : 14-Sep-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ModifyStudy verTextInReferringPhysicianTelephoneNumber(String strphysicianphnnum) throws Exception {
		objWaitForElement.waitForElements(referringPhysicianTelephoneNumber, "xpath");
		String actual = this.page.element(referringPhysicianTelephoneNumber, "xpath").getOne().getAttribute("value");
		assertTrue(actual.equals(strphysicianphnnum));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify the text in 'Comments' text field in Change study fields page.
	 * Date        : 14-Sep-2016
     * Author      : Hanumegowda
     **********************************************************************************/
	public ModifyStudy verTextInCommentsTextField(String strcomments)
			throws Exception {
		objWaitForElement.waitForElements(commentsTxtFld, "xpath");
		String actual = this.page.element(commentsTxtFld, "xpath").getOne().getAttribute("value");
		assertTrue(actual.equals(strcomments));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify text in 'location' field in Study Editor Page.
	* Date 		  : 14-Sep-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ModifyStudy verTextInLocation(String  strlocation) throws Exception {
		objWaitForElement.waitForElements(location, "xpath");
		String actual = this.page.element(location, "xpath").getOne().getAttribute("value");
		assertTrue(actual.equals(strlocation));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify text in 'MTF' text field in Study Editor Page.
	* Date 		  : 14-Sep-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ModifyStudy verTextInMTF(String  mtf) throws Exception {
		objWaitForElement.waitForElements(mtfTextField, "xpath");
		String actual = this.page.element(mtfTextField, "xpath").getOne().getAttribute("value");
		assertTrue(actual.equals(mtf));
		return this;
	}
	
}
