package page;

import static org.testng.Assert.assertTrue;
import module.Frames;

import org.openqa.selenium.WebDriver;

import qaframework.lib.pageObject.PageObject;
import qaframework.lib.userDefinedFunctions.WaitForElement;

public class Destinations extends PageObject{
	WebDriver driver;
	WaitForElement objWaitForElement;
	Frames objFrames;
	
	private String 
			  add = "//img[@src='/cobalt-images/add_but.gif']",
		      destinEditor = "//font[contains(text(),'Destination')][contains(text(),'editor')]",
		      medwebDevice = "is_medweb",
		      genericStorageSCP = "device_type_ssc_scp",
		      genericStorageSCU = "device_type_ssc_scu",
		      retrievePatientRootSCP = "device_type_query_patient_root_scp",
		      retrieveStudyRootSCP = "device_type_query_study_root_scp",
		      retrievePatientStudyRootSCP = "device_type_query_patientstudy_root_scp",
		      retrievePatientRootSCU = "device_type_query_patient_root_scu",
		      retrieveStudyRootSCU = "device_type_query_study_root_scu",
		      retrievePatientStudyRootSCU = "device_type_query_patientstudy_root_scu",
		      receiveDSME = "device_receive_dstm",
		      placeStudiesSandbox = "device_sandbox",
		      mitraReportSCP = "device_type_mitra_report_query_scp",
		      mitraReportSCU = "device_type_mitra_report_query_scu",
		      aETitle = "//font[contains(text(),'AE')][contains(text(),'Title')]/../..//input[@name='ae_title']",
		      ipAddress = "//font[contains(text(),'IP')][contains(text(),'Address')]/../..//input[@name='tcp_address']",
		      dICOMipPort = "//font[contains(text(),'DICOM ')][contains(text(),'port')]/../..//input[@name='tcp_port']",
		      label = "//font[contains(text(),'Label')]/../..//input[@name='label']",
		      saveChanges = "//img[@src='/cobalt-images/save_but.gif']",
		      dICOMProtocol = "//input[@name='send_method'][@value='0']",
		      fTPOverSecureTunnel = "//input[@name='send_method'][@value='2']",
		      dICOMOverSecureTunnel = "//input[@name='send_method'][@value=1]",
		      routeEngine = "//select[@name='route_engine']",
		      deliverimagesimmediately = "(//input[@name='send_immediately'])[1]";
	
	public Destinations(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
		objFrames = new Frames(this.driver);
	}
	
	/**********************************************************************************
	* Description : This function is to click modify button of respective server.
	* Date 		  : 26-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Destinations clickOnModifyServer(String server) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		String str = "//font[contains(text(),'"+server+"')]/../../..//a//img[@src='/cobalt-images/modify.gif']";
		objWaitForElement.waitForElements(str, "xpath");
		this.page.element(str, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Add' button.
	* Date 		  : 05-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Destinations clickOnAdd() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(add, "xpath");
		this.page.element(add, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Destination editor' page is displayed.
	* Date 		  : 05-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Destinations verDestinationEditorPage() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(destinEditor, "xpath");
		assertTrue(this.page.element(destinEditor, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Medweb device' checkbox.
	* Date 		  : 05-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Destinations selectMedwebDeviceCheckBox() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(medwebDevice, "name");
		if(this.page.element(medwebDevice, "name").getOne().isSelected()==false){
			this.page.element(medwebDevice, "name").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Generic Storage Service Class/SCP' checkbox.
	* Date 		  : 05-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Destinations selectGenericStorageSCPCheckBox() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(genericStorageSCP, "name");
		if(this.page.element(genericStorageSCP, "name").getOne().isSelected()==false){
			this.page.element(genericStorageSCP, "name").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Generic Storage Service Class/SCU' checkbox.
	* Date 		  : 05-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Destinations selectGenericStorageSCUCheckBox() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(genericStorageSCU, "name");
		if(this.page.element(genericStorageSCU, "name").getOne().isSelected()==false){
			this.page.element(genericStorageSCU, "name").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Query/Retrieve - Patient Root/SCP' checkbox.
	* Date 		  : 05-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Destinations selectRetrievePatientSCPCheckBox() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(retrievePatientRootSCP, "name");
		if(this.page.element(retrievePatientRootSCP, "name").getOne().isSelected()==false){
			this.page.element(retrievePatientRootSCP, "name").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Query/Retrieve - Study Root/SCP' checkbox.
	* Date 		  : 05-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Destinations selectRetrieveStudySCPCheckBox() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(retrieveStudyRootSCP, "name");
		if(this.page.element(retrieveStudyRootSCP, "name").getOne().isSelected()==false){
			this.page.element(retrieveStudyRootSCP, "name").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Query/Retrieve - Patient/Study Root/SCP' checkbox.
	* Date 		  : 05-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Destinations selectRetrievePatientStudySCPCheckBox() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(retrievePatientStudyRootSCP, "name");
		if(this.page.element(retrievePatientStudyRootSCP, "name").getOne().isSelected()==false){
			this.page.element(retrievePatientStudyRootSCP, "name").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select ' Query/Retrieve - Patient Root/SCU' checkbox.
	* Date 		  : 05-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Destinations selectRetrievePatientSCUCheckBox() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(retrievePatientRootSCU, "name");
		if(this.page.element(retrievePatientRootSCU, "name").getOne().isSelected()==false){
			this.page.element(retrievePatientRootSCU, "name").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select ' Query/Retrieve - Study Root/SCU ' checkbox.
	* Date 		  : 05-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Destinations selectRetrieveStudySCUCheckBox() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(retrieveStudyRootSCU, "name");
		if(this.page.element(retrieveStudyRootSCU, "name").getOne().isSelected()==false){
			this.page.element(retrieveStudyRootSCU, "name").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Query/Retrieve - Patient/Study Root/SCU' checkbox.
	* Date 		  : 05-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Destinations selectRetrievePatientStudySCUCheckBox() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(retrievePatientStudyRootSCU, "name");
		if(this.page.element(retrievePatientStudyRootSCU, "name").getOne().isSelected()==false){
			this.page.element(retrievePatientStudyRootSCU, "name").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Mitra Report Query Class/SCP' checkbox.
	* Date 		  : 05-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Destinations selectMitraReportSCPCheckBox() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(mitraReportSCP, "name");
		if(this.page.element(mitraReportSCP, "name").getOne().isSelected()==false){
			this.page.element(mitraReportSCP, "name").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select ' Mitra Report Query Class/SCU' checkbox.
	* Date 		  : 05-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Destinations selectMitraReportSCUCheckBox() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(mitraReportSCU, "name");
		if(this.page.element(mitraReportSCU, "name").getOne().isSelected()==false){
			this.page.element(mitraReportSCU, "name").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Receive Detached Study Management events 
	*               (create study, read, etc)' checkbox.
	* Date 		  : 05-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Destinations selectReceiveDSMECheckBox() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(receiveDSME, "name");
		if(this.page.element(receiveDSME, "name").getOne().isSelected()==false){
			this.page.element(receiveDSME, "name").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select ' Place studies from this aetitle into the 
	*               Trauma sandbox ' checkbox.
	* Date 		  : 05-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Destinations selectPlaceStudiesSandboxCheckBox() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(placeStudiesSandbox, "name");
		if(this.page.element(placeStudiesSandbox, "name").getOne().isSelected()==false){
			this.page.element(placeStudiesSandbox, "name").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'AE Title' field.
	* Date 		  : 05-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Destinations enterTextInAETitleField(String aetitle) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(aETitle, "xpath");
		this.page.element(aETitle, "xpath").clearInputValue().sendKeys(aetitle);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in ' IP Address' field.
	* Date 		  : 05-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Destinations enterTextInIPAddressField(String ipaddress) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(ipAddress, "xpath");
		this.page.element(ipAddress, "xpath").clearInputValue().sendKeys(ipaddress);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'DICOM IP port' field.
	* Date 		  : 05-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Destinations enterTextInDICOMIPPortField(String dicomipport) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(dICOMipPort, "xpath");
		this.page.element(dICOMipPort, "xpath").clearInputValue().sendKeys(dicomipport);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Label' field.
	* Date 		  : 05-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Destinations enterTextInLabelField(String labelname) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(label, "xpath");
		this.page.element(label, "xpath").clearInputValue().sendKeys(labelname);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on 'save changes' button.
	  * Date        : 05-Aug-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public Destinations clickOnSaveChanges() throws Exception {
		objWaitForElement.waitForElements(saveChanges, "xpath");
		this.page.element(saveChanges, "xpath").mouseOver();
		this.page.element(saveChanges, "xpath").getOne().click();
		//Thread.sleep(5000);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'DICOM protocol' radio button.
	* Date 		  : 09-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Destinations selDICOMProtocolRadioButton() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(dICOMProtocol, "xpath");
		if (this.page.element(dICOMProtocol, "xpath").getOne().isSelected() == false) {
			this.page.element(dICOMProtocol, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select Route engine type.
	* Date 		  : 09-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Destinations selRouteEngineType(String routeengine) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(routeEngine, "xpath");
		this.page.element(routeEngine, "xpath").webElementToSelect().selectByVisibleText(routeengine);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'FTP over Secure Tunnel' radio button.
	* Date 		  : 10-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Destinations selFTPOverSecureTunnelRadioButton() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(fTPOverSecureTunnel, "xpath");
		if (this.page.element(fTPOverSecureTunnel, "xpath").getOne().isSelected() == false) {
			this.page.element(fTPOverSecureTunnel, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'DICOM over Secure Tunnel (TCP packets compression
	*               level )' radio button.
	* Date 		  : 14-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Destinations selDICOMOverSecureTunnelRadioButton() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(dICOMOverSecureTunnel, "xpath");
		if (this.page.element(dICOMOverSecureTunnel, "xpath").getOne().isSelected() == false) {
			this.page.element(dICOMOverSecureTunnel, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify added destination is displaying in 'Current 
	*               dicom image destinations' page.
	* Date 		  : 24-Nov-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Destinations verAddedDestination(String aetitle, String ip,
			String port, String label) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		String str = "//font[contains(text(),'"
				+ aetitle
				+ "')]/ancestor::td/following-sibling::td//font[contains(text(),'"
				+ ip
				+ "')]/ancestor::td/following-sibling::td//font[contains(text(),'"
				+ port
				+ "')]/ancestor::td/following-sibling::td//font[contains(text(),'"
				+ label + "')]";
		objWaitForElement.waitForElements(str, "xpath");
		assertTrue(this.page.element(str, "xpath").getOne().isDisplayed());
		return this;
	}

	/**********************************************************************************
	* Description : This function is to select 'deliver images immediately ' radio button.
	* Date 		  : 02-Dec-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Destinations selDeliverImagesImmediatelyRadioButton() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(deliverimagesimmediately, "xpath");
		if (this.page.element(deliverimagesimmediately, "xpath").getOne().isSelected() == false) {
			this.page.element(deliverimagesimmediately, "xpath").getOne().click();
		}
		return this;
	}

}
