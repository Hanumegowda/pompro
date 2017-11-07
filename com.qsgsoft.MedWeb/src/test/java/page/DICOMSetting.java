package page;

import module.Frames;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import qaframework.lib.pageObject.PageObject;
import qaframework.lib.userDefinedFunctions.WaitForElement;

public class DICOMSetting extends PageObject{
	WebDriver driver;
	WaitForElement objWaitForElement;
	Frames objFrames;
	
	public String dicomSettings = "//b[text()='Local DICOM Settings']",
			      destinations = "//a[text()='Destinations']",
			      add1 = "//a[text()='Add Alias']",
			      devicesChecker = "//a[text()='Device Checker']",
			      devicesChecker1 = "//img[@src='/.cobalt/images/a_top_dcm_checker_r.gif']",
			      aliases = "//td[contains(text(),'AeTitle:')]//a[text()='Aliases...']",
			      aliasName = "//input[@name='ANAME']",
			      proxyQRchkbx = "//input[@type='CHECKBOX'][@value='PROXY_QR']",
			      markStudySTATchkbx = "//input[@type='CHECKBOX'][@value='MARK_STAT']",
			      anonymizeStudychkbx = "//input[@type='CHECKBOX'][@value='ANONYMIZE']",
			      raq49chkbx = "//input[@type='CHECKBOX'][@value='raq49']",
			      dicomRemapping = "//a[text()='Dicom Remapping']",
			      htmlReportEditor = "//input[@name='USE_HTML_REPORT']",
			      expressTranscription = "//input[@name='USE_ET_REPORT_DEFAULT']",
			      pauseTheDeliveryOfNewStudiesChkBox = "//input[@type='CHECKBOX'][@name='DCM_HOLDSTUDIES']",
			      markStudyAsRead = "//input[@name='SET_READ_STATUS']",
			      addDigitalSignatureBlock = "//input[@name='ADD_SIGNATURE_BLOCK']",
			      assignUniquAccessionNumber = "//input[@name='fix_empty_accnum'][@value='1']",
			      ACCNUMTemplate = "//input[@name='fix_template_accnum']",
			      mtfField = "//input[@name='MTF_CODE']",
			      addMTFToAccession = "//input[@name='MTF_MODE'][@value='both']",
			      medwebDICOMFieldOnly = "//input[@name='MTF_MODE'][@value='only_dicom']",
			      disableMTF = "//input[@name='MTF_MODE'][@value='disabled']",
			      importTemplatePage = "//a[text()='Import Template Page']",
			      aeTitleRouting = "//a[text()='AEtitle Routing']",
			      dICOMDevicesCheckerResults = "//b[text()='DICOM Devices Checker Results']",
			      aETitleClmn = "//td[text()='AE Title']",
			      iPAddressClmn = "//td[text()='IP Address']",
			      portClmn = "//td[text()='Port']",
				  latestSuccessfulResponseClmn = "//td[text()='Latest successful response']",
				  retainStudyStatStatus = "//input[@type='checkbox'][@name='RETAIN_STUDY_STAT_STATUS']",
				  releaseStudiesFromTraumaSandboxCheckBox = "//input[@type='CHECKBOX'][@name='QC_AUTORELEASENEWDATA']",
				  saveChanges = "//a[text()='Save Changes']",
				  stationName = "//input[@name='STATION']",
				  aeTitle = "//input[@name='AETITLE']",
				  institutionName = "//input[@name='INSTITUTE']",
				  reportTemplatesManagement = "//a[text()='Report Templates Management']",
				  releaseStudiesFromQCSandboxAfterXXXMinutes = "//input[@type='CHECKBOX'][@name='QC_AUTORELEASE']",
				  releaseStudiesFromQCSandboxAfterXXXMinutesTextField = "//input[@type='TEXT'][@name='QC_AUTORELEASEINTERVAL']",
				  convertImagesToJPEG2000BeforeAutoForwardingCheckbx = "router_compress_before_forward";
	
	public DICOMSetting(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
		objFrames = new Frames(this.driver);
	}
	
	/**********************************************************************************
	* Description : This function is to verify Local DICOM Settings page is displayed.
	* Date 		  : 05-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMSetting verLocalDICOMSettingsPage() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(dicomSettings, "xpath");
		assertTrue(this.page.element(dicomSettings, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Destinations' tab.
	* Date 		  : 05-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMSetting clickOnDestinations() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToSubMenuInRightFrame();
		objWaitForElement.waitForElements(destinations, "xpath");
		this.page.element(destinations, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Devices checker' tab.
	* Date 		  : 12-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMSetting clickOnDevicesCheckerTab() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToSubMenuInRightFrame();
		objWaitForElement.waitForElements(devicesChecker, "xpath");
		this.page.element(devicesChecker, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Devices checker' tab.
	* Date 		  : 12-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMSetting clickOnDevicesCheckerTab1() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToSubMenuInRightFrame();
		objWaitForElement.waitForElements(devicesChecker1, "xpath");
		this.page.element(devicesChecker1, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify DICOM Devices Checker Result page with latest
	*               response with the DICOM device is displayed .
	* Date 		  : 12-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMSetting verDICOMDevicesCheckerResultPageWithLatestResponse(String date,String server) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements("//tr/td[contains(text(),'"+date+"')]/..//td[contains(text(),'"+server+"')]", "xpath");
		assertTrue(this.page.element("//tr/td[contains(text(),'"+date+"')]/..//td[contains(text(),'"+server+"')]", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on aliases link of AeTitle field.
	* Date 		  : 26-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMSetting clickOnAliasesLinkOfAeTitle() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(aliases, "xpath");
		this.page.element(aliases, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Add' button in 'DICOM Aliases' page.
	* Date 		  : 26-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMSetting clickOnAddInDICOMAliases() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(add1, "xpath");
		this.page.element(add1, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter alias name.
	* Date 		  : 26-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMSetting enterAliasName(String aliasname) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(aliasName, "xpath");
		this.page.element(aliasName, "xpath").getOne().click();
		this.page.element(aliasName, "xpath").clearInputValue().sendKeys(aliasname);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Mark Study as STAT' checkbox.
	* Date 		  : 26-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMSetting selMarkStudySTATCheckBox() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(markStudySTATchkbx, "xpath");
		if(this.page.element(markStudySTATchkbx, "xpath").getOne().isSelected()==false){
			this.page.element(markStudySTATchkbx, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Anonymize Study' checkbox.
	* Date 		  : 26-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMSetting selAnonymizeStudyCheckBox() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(anonymizeStudychkbx, "xpath");
		if(this.page.element(anonymizeStudychkbx, "xpath").getOne().isSelected()==false){
			this.page.element(anonymizeStudychkbx, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Proxy Q/R requests to' checkbox.
	* Date 		  : 26-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMSetting selProxyQRRequestsToCheckBox() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(proxyQRchkbx, "xpath");
		if(this.page.element(proxyQRchkbx, "xpath").getOne().isSelected()==false){
			this.page.element(proxyQRchkbx, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Raq49' server checkbox.
	* Date 		  : 26-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMSetting selProxyQRRequestServerCheckBox(String aetitle) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		String str = "//input[@type='CHECKBOX'][@value='"+aetitle+"']";
		objWaitForElement.waitForElements(str, "xpath");
		if(this.page.element(str, "xpath").getOne().isEnabled()){
			this.page.element(str, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'destination aetitle' server checkbox in
	*               'Add new alias' page.
	* Date 		  : 26-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMSetting selDestinationAetitleCheckBox(String aetitle) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		String str = "//input[@type='CHECKBOX'][@value='"+aetitle+"']";
		objWaitForElement.waitForElements(str, "xpath");
		if((this.page.element(str, "xpath").getOne().isSelected())==false){
			this.page.element(str, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Dicom Remapping' link.
	* Date 		  : 27-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMSetting clickOnDicomRemapping() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(dicomRemapping, "xpath");
		this.page.element(dicomRemapping, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Use HTML Report Editor (for Internet Explorer)' checkbox.
	* Date 		  : 28-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMSetting selHTMLReportEditorCheckBox () throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(htmlReportEditor, "xpath");
		if(this.page.element(htmlReportEditor, "xpath").getOne().isSelected()==false){
			this.page.element(htmlReportEditor, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to deselect 'Use HTML Report Editor (for Internet Explorer)' checkbox.
	* Date 		  : 28-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMSetting deSelHTMLReportEditorCheckBox () throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(htmlReportEditor, "xpath");
		if(this.page.element(htmlReportEditor, "xpath").getOne().isSelected()==true){
			this.page.element(htmlReportEditor, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Use Express Transcription as default report editor' checkbox.
	* Date 		  : 29-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMSetting selExpressTranscriptionCheckBox() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(expressTranscription, "xpath");
		if (this.page.element(expressTranscription, "xpath").getOne().isSelected() == false) {
			this.page.element(expressTranscription, "xpath").getOne().click();
		}
		return this;

	}
	
	/**********************************************************************************
	* Description : This function is to deselect 'Use Express Transcription as default report editor' checkbox.
	* Date 		  : 29-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMSetting deSelExpressTranscriptionCheckBox() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(expressTranscription, "xpath");
		if (this.page.element(expressTranscription, "xpath").getOne().isSelected() == true) {
			this.page.element(expressTranscription, "xpath").getOne().click();
		}
		return this;

	}
	
	/**********************************************************************************
	* Description : This function is to deselect 'Pause the delivery of new studies for minutes' checkbox.
	* Date 		  : 29-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMSetting dePauseTheDeliveryOfNewStudiesCheckBox() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(pauseTheDeliveryOfNewStudiesChkBox, "xpath");
		if (this.page.element(pauseTheDeliveryOfNewStudiesChkBox, "xpath").getOne().isSelected() == true) {
			this.page.element(pauseTheDeliveryOfNewStudiesChkBox, "xpath").getOne().click();
		}
		return this;

	}
	
	/**********************************************************************************
	* Description : This function is to select 'Mark study as "Read" when the report is 
	*               signed' checkbox.
	* Date 		  : 29-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMSetting selMarkStudyAsReadCheckBox() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(markStudyAsRead, "xpath");
		if (this.page.element(markStudyAsRead, "xpath").getOne().isSelected() == false) {
			this.page.element(markStudyAsRead, "xpath").getOne().click();
		}
		return this;
}
	
	
	/**********************************************************************************
	* Description : This function is to select 'Add Digital Signature block to Signed reports' checkbox.
	* Date 		  : 01-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMSetting selAddDigitalSignatureBlockCheckBox() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(addDigitalSignatureBlock, "xpath");
		if (this.page.element(addDigitalSignatureBlock, "xpath").getOne().isSelected() == false) {
			this.page.element(addDigitalSignatureBlock, "xpath").getOne().click();
		}
	
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Assign unique Accession number to the study
	*               if this field is not set' radiobutton.
	* Date 		  : 01-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMSetting selAssignUniqueAccessionNumberRadioButton() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(assignUniquAccessionNumber, "xpath");
		if (this.page.element(assignUniquAccessionNumber, "xpath").getOne().isSelected() == false) {
			this.page.element(assignUniquAccessionNumber, "xpath").getOne().click();
		}
	
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'ACCNUM template:' field.
	* Date 		  : 01-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMSetting enterTextInACCNUMTemplate(String labelname) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(ACCNUMTemplate, "xpath");
		this.page.element(ACCNUMTemplate, "xpath").clearInputValue().sendKeys(labelname);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to clear the text in 'MTF code' field.
	* Date 		  : 03-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMSetting clearMTFCode() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(mtfField, "xpath");
		this.page.element(mtfField, "xpath").getOne().clear();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter the text in 'MTF code' field.
	* Date 		  : 03-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMSetting enterTextInMTFCode(String mtfcode) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(mtfField, "xpath");
		this.page.element(mtfField, "xpath").clearInputValue().sendKeys(mtfcode);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Add MTF to Accession number and Medweb DICOM
	*               field' radio button.
	* Date 		  : 03-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMSetting selAddMTFToAccessionNumberRadioButton() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(addMTFToAccession, "xpath");
		if(this.page.element(addMTFToAccession, "xpath").getOne().isSelected()==false){
			this.page.element(addMTFToAccession, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Add MTF to Medweb DICOM field only (7deb:0103)'
	*               radio button.
	* Date 		  : 04-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMSetting selAddMTFToMedwebDicomFieldOnlyRadioButton() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(medwebDICOMFieldOnly, "xpath");
		if(this.page.element(medwebDICOMFieldOnly, "xpath").getOne().isSelected()==false){
			this.page.element(medwebDICOMFieldOnly, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Disable MTF' radio button.
	* Date 		  : 04-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMSetting selDisableMTFRadioButton() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(disableMTF, "xpath");
		if(this.page.element(disableMTF, "xpath").getOne().isSelected()==false){
			this.page.element(disableMTF, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Import Template Page' link.
	* Date 		  : 07-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMSetting clickOnImportTemplatePageLink() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(importTemplatePage, "xpath");
		this.page.element(importTemplatePage, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'AETitle Routing' tab.
	* Date 		  : 15-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMSetting clickOnAETitleRouting() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToSubMenuInRightFrame();
		objWaitForElement.waitForElements(aeTitleRouting, "xpath");
		this.page.element(aeTitleRouting, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'AETitle Routing' tab.
	* Date 		  : 15-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMSetting clickOnAETitleRouting1() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToSubMenuInRightFrame();
		objWaitForElement.waitForElements("//img[@src='/.cobalt/images/a_top_aetitle_r.gif']", "xpath");
		this.page.element("//img[@src='/.cobalt/images/a_top_aetitle_r.gif']", "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'DICOM Devices Checker Results' page is displayed.
	* Date 		  : 08-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMSetting verDICOMDevicesCheckerResultsPage() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(dICOMDevicesCheckerResults, "xpath");
		assertTrue(this.page.element(dICOMDevicesCheckerResults, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'AE Title' column is displayed.
	* Date 		  : 08-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMSetting verAETitleColumn() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(aETitleClmn, "xpath");
		assertTrue(this.page.element(aETitleClmn, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'IP Address' column is displayed.
	* Date 		  : 08-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMSetting verIPAddressColumn() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(iPAddressClmn, "xpath");
		assertTrue(this.page.element(iPAddressClmn, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Port' column is displayed.
	* Date 		  : 08-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMSetting verPortColumn() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(portClmn, "xpath");
		assertTrue(this.page.element(portClmn, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Latest successful response' column is displayed.
	* Date 		  : 08-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMSetting verLatestSuccessfulResponseColumn(String reqdate) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements("//td[contains(text(),'"+reqdate+"')]/../..//td[contains(text(),'Latest successful response')]", "xpath");
		assertTrue(this.page.element("//td[contains(text(),'"+reqdate+"')]/../..//td[contains(text(),'Latest successful response')]", "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Retain Study STAT status' checkbox.
	* Date 		  : 03-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMSetting selRetainStudySTATStatusCheckBox() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(retainStudyStatStatus, "xpath");
		if (this.page.element(retainStudyStatStatus, "xpath").getOne().isSelected() == false) {
			this.page.element(retainStudyStatStatus, "xpath").getOne().click();
		}
		return this;
}
	
	/**********************************************************************************
	* Description : This function is to select 'Release studies from Trauma Sandbox when new 
	*               data was added to the DICOM fields ' checkbox.
	* Date 		  : 14-Apr-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMSetting selReleaseStudiesFromTraumaSandboxCheckBox() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(releaseStudiesFromTraumaSandboxCheckBox, "xpath");
		if(this.page.element(releaseStudiesFromTraumaSandboxCheckBox, "xpath").getOne().isSelected()==false){
			this.page.element(releaseStudiesFromTraumaSandboxCheckBox, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on SaveChanges button in dicom settings page.
	* Date 		  : 14-Apr-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMSetting clickOnSaveChanges() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(saveChanges, "xpath");
		this.page.element(saveChanges, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter the text in 'Station Name' field.
	* Date 		  : 20-Apr-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMSetting enterTextInStationName(String station) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(stationName, "xpath");
		this.page.element(stationName, "xpath").clearInputValue().sendKeys(station);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to get text from AeTitle text field.
	* Date 		  : 28-Apr-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public String getAeTitleText() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(aeTitle, "xpath");
		String actual = this.page.element(aeTitle, "xpath").getOne().getAttribute("value");
		System.out.println(actual+" this is the current aetitle");
		return actual;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text to AeTitle text field.
	* Date 		  : 28-Apr-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMSetting enterTextInAeTitleTextField(String aet) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(aeTitle, "xpath");
		this.page.element(aeTitle, "xpath").clearInputValue().sendKeys(aet);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to get text from Institution Name text field.
	* Date 		  : 02-May-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public String getInstitutionNameText() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(institutionName, "xpath");
		String actual = this.page.element(institutionName, "xpath").getOne().getAttribute("value");
		System.out.println(actual+" this is the current aetitle");
		return actual;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text to 'Institution Name' text field.
	* Date 		  : 02-May-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMSetting enterTextInInstitutionNameTextField(String instn) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(institutionName, "xpath");
		this.page.element(institutionName, "xpath").clearInputValue().sendKeys(instn);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Report Templates Management' link.
	* Date 		  : 27-May-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMSetting clickOnReportTemplatesManagementLink() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(reportTemplatesManagement, "xpath");
		this.page.element(reportTemplatesManagement, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Release studies from QC Sandbox after xxx minutes' checkbox.
	* Date 		  : 23-Jun-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMSetting selReleaseStudiesFromQCSandboxAfterXXXMinutesCheckBox() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(releaseStudiesFromQCSandboxAfterXXXMinutes, "xpath");
		if(this.page.element(releaseStudiesFromQCSandboxAfterXXXMinutes, "xpath").getOne().isSelected()==false){
			this.page.element(releaseStudiesFromQCSandboxAfterXXXMinutes, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Release studies from QC Sandbox after xxx minutes' textbox.
	* Date 		  : 23-Jun-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMSetting enterTextReleaseStudiesFromQCSandboxAfterXXXMinutesField(String time) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(releaseStudiesFromQCSandboxAfterXXXMinutesTextField, "xpath");
		this.page.element(releaseStudiesFromQCSandboxAfterXXXMinutesTextField, "xpath").clearInputValue().sendKeys(time);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Convert images to JPEG2000 before auto-forwarding' checkbox.
	* Date 		  : 30-Aug-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMSetting selConvertImagesToJPEG2000BeforeAutoForwardingCheckBox() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(convertImagesToJPEG2000BeforeAutoForwardingCheckbx, "name");
		if (this.page.element(convertImagesToJPEG2000BeforeAutoForwardingCheckbx, "name").getOne().isSelected() == false) {
			this.page.element(convertImagesToJPEG2000BeforeAutoForwardingCheckbx, "name").getOne().click();
		}
		return this;

	}
	

}
