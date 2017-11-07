package page;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

import java.awt.Robot;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import module.Frames;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.event.KeyEvent;

import qaframework.lib.WaitTimeConstants;
import qaframework.lib.pageObject.PageObject;
import qaframework.lib.userDefinedFunctions.WaitForElement;

public class ViewPatients extends PageObject{
	WebDriver driver;
	WaitForElement objWaitForElement ;
	Frames objFrames;
	UserManagement objUserManagement;
	
	private String veruser = "//b[text()='User:']/..",
			       //logOut = "//img[@src='/cobalt-images/p_logout_but_off.gif']",
			       logOut = "//a[text()='Logout']",
			       search = "//img[@src='gifs.new/btn_sl_search.gif']",
			       refferingPhysicianName = "//tbody//th[text()='Ref MD']/../following-sibling::tr/td[4]",
			       consultingPhysicianName = "//tbody//th[text()='Ref MD']/../following-sibling::tr/td[5]",
			       next = "//button[text()='Next']",
			       preferences = "//a[contains(text(),'Preferences')]",
			       newLink = "//a[contains(text(),'New Study')]",
			       uploadZip = "//a[contains(text(),'Upload Zip')]",
			       saveChanges1 = "//a[text()='Save Changes']",
			       //ViewPatients = "//img[@src='/cobalt-images/p_view_patients_but_on.gif']",
			       viewPatients	= "//a[text()='View Patients']",
			       advancedViewerIE = "//input[@name='viewer_type'][@value='2']",
			       uploadZipPage = "//b[contains(text(),'Upload Zip file(s)')]",
			       browse1 = "//input[@type='FILE'][@name='file0']",
			       browse2 = "//input[@type='FILE'][@name='file1']",
			       browse3 = "//input[@type='FILE'][@name='file2']",
			       browse4 = "//input[@type='FILE'][@name='file3']",
			       browse5 = "//input[@type='FILE'][@name='file4']",
			       find = "//input[@type='text'][@name='substring']",
			       uploadButton = "//img[@src='/cobalt-images/upload_but.gif']",
			       back = "//img[@src='/cobalt-images/back_but.gif']",
			       ModifyWebReport = "//img[@src='gifs.new/reportf.gif']",
			       ModifyWebReport2 = "//img[@src='gifs.new/report.gif']",
			       attachDocument = "//img[@src='/wavelet/gifs.new/rep_attach.gif']",
			       browse = "//input[@name='up_file'][@type='file']",
			       uploadButton1 = "//a[text()='Upload']",
			       add = "//a[text()='Add']",
			       getDateTimeOfUnSignedrpt = "//a/img[@src='/wavelet/gifs.new/sign_doc_but.gif']/../../preceding-sibling::td/b/a",
			       patient = "//b[text()='Patient']/../..//td[text()='Other Patient']",
			       saveReport = "//a[@title='Save Report']",
			       saveReport1 = "//a[text()='Save report']",
			       storageDeviceRadioBtn = "//input[@type='radio'][@value='storage']",
			       next1 = "//img[@src='/cobalt-images/next_but.gif']",
			       storageDevice = "//select[@name='dicom_target']",
			       finish = "//img[@src='/cobalt-images/finish_but.gif']",
			       lastHour = "//select[@name='last_hours']",
			       study = "//a[contains(text(),'DN_')]/../..//td[contains(text(),'DP.')]/..//img[@src='gifs.new/stat_0.gif']",
			       studyDel = "//a[contains(text(),'DN_')]/../..//td[contains(text(),'DP.')]/..//img[@src='gifs.new/stat_0.gif']/../..//img[@src='gifs.new/delete.gif']",
			       viewModifyStudy = "//img[@src='gifs.new/report.gif']",
			       viewModifyStudy1 = "//img[@src='gifs.new/reportf.gif']",
			       viewModifyStudy2 = "//img[@src='gifs.new/reportex.gif']",
			       radiologyReport = "//h3[text()='RADIOLOGY REPORT']",
			       getId = " (//img[@src='gifs.new/report.gif']//ancestor::tr[1]//td/input)[1]//ancestor::tr[1]//td[3]",
			       additionaRemarks = "//td[@valign='top']",
			       saveSignReport = "//a[text()='Save & Sign Report']",
			       saveSignReport1 = "//a[text()='Save and sign report']",
			       //saveSignReport = "save_sign_button1",
			       signReport = "//a[text()='Sign report']",
			       sigFile = "//img[@src='/wavelet/signatures/admin.jpg']",
			       deleteAllStudy = "//tr[@class='tlistman']//img[@src='gifs.new/delete.gif']",
			       continueToThisWebsite = "//a[contains(text(),'Continue to this website (not recommended).')]",
			       ok = "//input[@name='delete']",
			       ok1 = "//input[@type='button'][@name='ok']",
			       signedReport = "//div[contains(text(),'SIGNED BY')]",
			       savedReport = "(//a[contains(text(),'- admin')])[1]",
			       delReport = "//div[contains(text(),'SIGNED BY')]/../..//img[@src='/wavelet/gifs.new/delete.gif']",
			       status = "//select[@name='only_read']",
			       where = "//select[@name='find_where']",
			       modalityOption = "//select[@name='modality_type']",
			       limitOption = "//select[@name='page_size']",
			       change = "//input[@value='Change']",
			       htmlReport = "//input[@type='radio'][@value='report']",
			       strTo = "to",
			       strSubject = "//input[@type='text'][@name='subject']",
			       strSubject1 = "//input[@type='text'][@name='subj']",
			       pdfReport = "//input[@type='radio'][@value='fax']",
			       mwwReport = "//input[@type='radio'][@value='plugin']",
			       modifyStudy = "//img[@src='/cobalt-images/modify.gif']",
			       mtfCode = "//td[contains(text(),'MTF')]/following-sibling::td/input",
			       refPhyName = "(//td[contains(text(),'Referring Physician')])[1]/following-sibling::td/input",
			       modality = "//td[contains(text(),'Modality')]/following-sibling::td/input",
			       institutionName = "//td[contains(text(),'Institution Name')]/..//input",
			       site = "//nobr[contains(text(),'Site:')]/b",
			       changeStatStatusOfStudy = "//img[@src='gifs.new/stat_1.gif']",
			       close = "//a[text()='Close']",
			       attachment = "btn_attach",
			       attachBrowse = "//input[@name='up_file']",
			       browseUp = "//input[@type='file']",
			       sendTo1 = "//tr/td/div/table/tbody/tr/td/table/tbody/tr//td/input[@name='mail_to']",
			       localpc = "//input[@type='radio'][@value='pc_storage']",
			       localpath = "//input[@name='local_path'][@type='text']",
			       uploadDCM = "//a[contains(text(),'Upload DCM')]",
			       uploadDICOMFile = "//b[text()='Upload DICOM file(s)']",
			       layout = "//select[@name='group_by']",
			       studyRoutingHistory = "//h3[text()='Study routing history']",
			       version = "//td[@class='ttitalic']",
			       aseries = "//input[@type='radio'][@value='a.series']",
			       proceed = "bNext",
			       selectAll = "bSelectAll",
			       move = "bMove",
			       newStudy = "bNewStudy",
			       okInSpiltMoveWizard = "bOK",
			       selImageChkbx = "(//input[@type='checkbox'][@name='ser_num'])[1]",
			       delSelected = "bDelete",
			       yesInSplitMoveWizard = "bYes",
			       doneInSplitMoveWizard = "bDone",
			       copyInSplitMoveWizard = "bCopy",
			       releaseNewStudyFromQCSandbox = "release_ck",
			       individualImages = "//input[@type='radio'][@value='b.images']",
			       selImageChkbx1 = "(//input[@type='checkbox'][@name='img_id'])[1]",
			       existingStudy = "bExistingStudy",
			       searchForOption = "sName",
			       searchForOptionTextField = "//input[@type='text'][@name='tValue']",
			       go = "//input[@type='submit'][@name='bGo']",
			       selStudyRadioBtn = "//input[@type='radio'][@name='sid']",
			       copySelectedSeriesWhere = "//td[contains(text(),'Step 3: Copy selected series where?')]",
			       sendSelectedStudies = "//tr[@class='tlistman']//img[@src='gifs.new/route_to.gif']",
			       mergeReports = "//img[@src='gifs.new/merge.gif']",
			       moveReports = "(//input[@type='radio'][@name='move'])[1]",
			       yes = "//input[@type='submit'][@value='Yes']",
			       close1 = "//input[@type='button'][@value='Close']",
			       copyReports = "(//input[@type='radio'][@name='move'])[2]",
			       templateEditor = "btn_edit_templ1",
			       clearDocument = "btn_new",
			       addTemplate = "btn_add_template",
			       templateName = "//input[@name='tmpl_name']",
			       selTemplateType = "//select[@name='tmpl_type']",
			       selTemplatePackage = "//select[@name='tmpl_package']",
			       selTemplateField = "//select[@name='fld_1001']",
			       templatematch = "//input[@name='match_1001'][@type='TEXT']",
			       saveChanges = "//img[@src='/wavelet/mini-ris/html_editor/images/save_but.gif']",
			       selTemplate = "oTemplateList",
			       substitutionFieldsManagement = "btn_studyvalue",
			       smartTags = "mode_valuesU",
			       tagField = "tag_999",
			       personalPhraseField = "value_999",
			       uploadTemplate = "btn_upload_templ",
				   downloadTemplate = "btn_download_templ",
				   deleteTemplate = "btn_del_templ",
				   uploadButtonInTemplateEditor = "//input[@type='button'][@value='Upload']",
				   advanced = "//img[@src='gifs.new/btn_sm_advanced.gif']",
				   flip = "//form[@name='thesearch']/table//tr//b[text()='FLIP']",
				   type = "//form[@name='thesearch']//input[@type='text'][@name='adv_stud_type']",
				   refPhysician = "//form[@name='thesearch']//input[@type='text'][@name='adv_stud_phys']",
				   station = "//form[@name='thesearch']//input[@type='text'][@name='adv_stud_station']",
				   instName = "//form[@name='thesearch']//input[@type='text'][@name='adv_stud_inst']",
				   studyName = "//form[@name='thesearch']//input[@type='text'][@name='adv_pat_name']",
				   studyId = "//form[@name='thesearch']//input[@type='text'][@name='adv_pat_id']",
				   birthDate = "//form[@name='thesearch']//input[@type='text'][@name='adv_pat_birthdate']",
				   sex = "//form[@name='thesearch']//select[@name='adv_pat_sex']",
				   statusInAdvancedSearch = "//form[@name='thesearch']//select[@name='adv_status']",
				   advancedSearch = "//form[@name='thesearch']//input[@id='image1']",
				   signedBy = "//div[contains(text(),'SIGNED BY')]",
				   stationName = "//nobr[contains(text(),'Station name:')]/b",
				   stationInAdvancedSearch = "//form[@name='thesearch']//input[@type='text'][@name='adv_stud_station']",
				   selAllStudychckbox = "//input[@type='checkbox'][@name='selst_all']",
				   destination = "//select[@name='ae_title']",
				   releaseStudyFromQc = "//img[@src='gifs.new/qc_release.gif']",
				   okInReleaseStudy = "//input[@name='release']",
				   saveTemplate = "btn_save",
				   selTemplateSubType = "//select[@name='tmpl_subtype']",
				   aclLink = "//a[text()='ACL']",
				   privateRadBtn = "shared_private",
				   deleteTemplateField = "//img[@src='/wavelet/mini-ris/html_editor/images/delete.gif']",
				   ownerDropdown = "//select[@name='tmpl_owner']",
				   sharedRadBtn = "shared_shared",
				   radiologistChkBox = "//input[@type='CHECKBOX'][@value='ophthalmologist']",
				   templateProperties = "btn_edit_templ",
				   nominateChkBx = "//input[@type='checkbox'][@name='tmpl_nominated']",
				   studyColumnHeaders = "//th[text()='Name']/following-sibling::th[text()='ID']/following-sibling"
				   		                 + "::th[text()='Type']/following-sibling::th[text()='Imgs']/following-sibling"
				   		                 + "::th[text()='Rpts']/following-sibling::th[text()='Mgmt']",
				   editDicom = "//input[@type='button'][@name='bEditDicom']",
				   idModalityTextField = "//td[contains(text(),'ID Modality')]/following-sibling::td/input",
				   saveDcm = "//input[@type='checkbox'][@name='write_dcm']",
				   modifyStudyIcon = "//img[@src='gifs.new/qc_modify.gif']",
				   clickHereToDownloadSelectedStudiesReportsIcon = "//tr[@class='tlistman']//img[@src='gifs.new/reportex.gif']",
				   downloadReportsAsZipFile = "//input[@type='submit'][@value='Download reports as Zip file']",
				   updateLicense = "//img[@src='gifs.new/updatelicense_normal.gif']",
				   daysLeft = "//td[contains(text(),'Days left')]/following-sibling::td",
				   enterNewLicense = "//textarea[@name='license']",
				   licenseErrorMsg = "//td[contains(text(),'wrong lic serial')]",
				   cdIcon = "//img[@src='gifs.new/cdrom.gif']/../following-sibling::b[text()='All']",
				   imagesLeftToSendPlusIcon = "//td[contains(text(),'images left to send')]/a",
				   delIconInDicomSpooler = "//img[@src='/wavelet/gifs.new/delete.gif']",
				   postReplyIcon = "img[src='/wavelet/gifs.new/rep_reply.gif']",
				   postReplyPage = "oDiv",
				   postReplyNoteLink = "//b[text()='NOTES:']/../following-sibling::div//a",
				   alignCenter = "btn_centeralign",
				   insertImage = "btn_image",
				   browseInInsertImage = "input[name='img_file']",
				   insertBtnInUploadImgWindow = "//input[@type='button'][@value='Insert']",
				   headerTemplate = "oHeaderList",
				   logoImage = "//img",
				   logoImage1 = "(//img)[2]",
				   addendumIcon = "//div[contains(text(),'SIGNED BY:')]/../following-sibling::td//a/img[@src='/wavelet/gifs.new/rep_addendum.gif']",
				   refPhyTxtFldInAddendumReportEdtrPage = "//td/b[text()='REFERRING PHYSICIAN']/../following-sibling::td",
				   saveAndSignAddendum = "//table[@id='maintable']//tbody//a[contains(text(),'Save & Sign Addendum')]",
				   removeAddendum = "//b[text()='ADDENDUMS:']/../following-sibling::div//a[text()='remove']",
				   getLatestPlugins = "img[src='gifs.new/getplugin_normal.gif']",
				   refreshLink = "Refresh",
				   cloudConsultType = "//tr/th[4][text()='Type']/..//following-sibling::tr/td[4][text()='cloud consult']",
				   plusIcon = "//a[text()'[+]']",
				   general = "//span[text()='General']";				   
			      
			       
	public ViewPatients(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement =  new WaitForElement(this.driver);
	    objFrames = new Frames(this.driver);
	    objUserManagement = new UserManagement(this.driver);
	}
	
	/**********************************************************************************
	  * Description : This function is to verify the user in view patients page
	  * Date        : 15-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public ViewPatients verifyUser(String username) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(veruser, "xpath");
		String str = this.page.element(veruser, "xpath").getOne().getText();
		assertTrue(str.contains(username));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on logout button in view patients page
	  * Date        : 15-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public ViewPatients clickOnLogout() throws Exception {
		objFrames.switchToDefaultFrame().switchToMainMenuFrame();
		objWaitForElement.waitForElements(logOut, "xpath");
		/*this.page.element(logOut, "xpath").mouseOver();
		this.page.element(logOut, "xpath").doubleClick();*/
		this.page.element(logOut, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on logout button in view patients page
	  * Date        : 15-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public ViewPatients clickOnLogout1() throws Exception {
		objFrames.switchToDefaultFrame().switchToMainMenuFrame();
		objWaitForElement.waitForElements("//img[@src='/cobalt-images/p_logout_but_off.gif']", "xpath");
		this.page.element("//img[@src='/cobalt-images/p_logout_but_off.gif']", "xpath").mouseOver();
		this.page.element("//img[@src='/cobalt-images/p_logout_but_off.gif']", "xpath").doubleClick();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on search button in view patients page
	  * Date        : 22-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public ViewPatients clickOnSearch() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		WebDriverWait wait = new WebDriverWait(this.driver, WaitTimeConstants.WAIT_TIME_LONG);
		objWaitForElement.waitForElements(search, "xpath");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(search)));
		this.page.element(search, "xpath").getOne().click();
		Thread.sleep(2000);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on search button in view patients page
	  * Date        : 22-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public ViewPatients clickOnSearch1() throws Exception {
		Thread.sleep(5000);
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		WebDriverWait wait = new WebDriverWait(this.driver, WaitTimeConstants.WAIT_TIME_LONG);
		objWaitForElement.waitForElements(search, "xpath");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(search)));
		this.page.element(search, "xpath").getOne().click();
		Thread.sleep(3000);
		boolean a;
		do{
		if(this.page.element("//td[contains(text(),'0 images left to compress')]", "xpath").isElementPresent()==false){
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(search)));
			this.page.element(search, "xpath").getOne().click();
			Thread.sleep(2000);
			a = true;
		}
		else{
			a = false;
		}
		}while(a);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify reffering physician name in view patients page
	  * Date        : 22-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public ViewPatients verRefferingPhysicianName(String expected) throws Exception {
		objWaitForElement.waitForElements(refferingPhysicianName, "xpath");
		List<WebElement> all = driver.findElements(By.xpath(refferingPhysicianName));
		for(WebElement eachele:all){
		assertTrue(expected.contains((eachele.getText()).toLowerCase()));
		System.out.println("count");
		}
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify consulting physician name in view patients page
	  * Date        : 26-Oct-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public ViewPatients verConsultingPhysicianName(String expected) throws Exception {
		objWaitForElement.waitForElements(consultingPhysicianName, "xpath");
		List<WebElement> all = driver.findElements(By.xpath(consultingPhysicianName));
		for(WebElement eachele:all){
		assertTrue(expected.contains((eachele.getText()).toLowerCase()));
		System.out.println("count");
		}
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on next button.
	  * Date        : 23-Jun-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public ViewPatients clickOnNext() throws Exception {
		objWaitForElement.waitForElements(next, "xpath");
		this.page.element(next, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on Preferences link in view patients page
	  * Date        : 03-Aug-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public ViewPatients clickOnPreferences() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(preferences, "xpath");
		this.page.element(preferences, "xpath").getOne().click();
		Thread.sleep(3000);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Advanced Viewer (Internet Explorer)' radio button.
	* Date 		  : 10-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients selAdvancedViewerIERadioButton() throws Exception {
		/*objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();*/
		objWaitForElement.waitForElements(advancedViewerIE, "xpath");
		if((this.page.element(advancedViewerIE, "xpath")).getOne().isSelected()==false){
		this.page.element(advancedViewerIE, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On New Study link.
	* Date 		  : 07-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnNewStudy() throws Exception {
		this.clickOnPreferences();
		this.selAdvancedViewerIERadioButton().clickOnSaveChanges()
				.clickOnViewPatients();
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(newLink, "xpath");
		this.page.element(newLink, "xpath").clickUjse();
		Thread.sleep(WaitTimeConstants.WAIT_TIME_SMALL);
		Capabilities cap = ((RemoteWebDriver) this.driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName + " this is the current browser");
		if ((browserName).equalsIgnoreCase("chrome")) {
			System.out.println(browserName + " this is the current browser");
			Robot rr = new Robot();
			rr.keyPress(KeyEvent.VK_LEFT);
			rr.keyRelease(KeyEvent.VK_LEFT);
			rr.delay(3000);
			rr.keyPress(KeyEvent.VK_ENTER);
			rr.keyRelease(KeyEvent.VK_ENTER);
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On 'Upload Zip' link.
	* Date 		  : 10-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnUploadZipLink() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(uploadZip, "xpath");
		this.page.element(uploadZip, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On save changes button.
	* Date 		  : 10-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnSaveChanges() throws Exception {
		/*objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();*/
		objWaitForElement.waitForElements(saveChanges1, "xpath");
		this.page.element(saveChanges1, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On save changes button.
	* Date 		  : 10-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnViewPatients() throws Exception {
		objFrames.switchToDefaultFrame().switchToMainMenuFrame();
		objWaitForElement.waitForElements(viewPatients, "xpath");
		this.page.element(viewPatients, "xpath").mouseOver();
		this.page.element(viewPatients, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify upload zip files page is displayed.
	* Date 		  : 10-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verUploadZipFilesPage() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(uploadZipPage, "xpath");
		assertTrue(this.page.element(uploadZipPage, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click On first Browse button In Upload Zip file(s) page.
	  * Date        : 10-Aug-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public ViewPatients clickOnBrowse1(String path) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(browse1, "xpath");
		this.page.element(browse1, "xpath").getOne()
		.sendKeys(path);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click On first Browse button In Upload Zip file(s) page.
	  * Date        : 10-Aug-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public ViewPatients clickOnBrowse2(String path) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(browse2, "xpath");
		this.page.element(browse2, "xpath").getOne()
		.sendKeys(path);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click On first Browse button In Upload Zip file(s) page.
	  * Date        : 10-Aug-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public ViewPatients clickOnBrowse3(String path) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(browse3, "xpath");
		this.page.element(browse3, "xpath").getOne()
		.sendKeys(path);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click On first Browse button In Upload Zip file(s) page.
	  * Date        : 10-Aug-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public ViewPatients clickOnBrowse4(String path) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(browse4, "xpath");
		this.page.element(browse4, "xpath").getOne()
		.sendKeys(path);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click On first Browse button In Upload Zip file(s) page.
	  * Date        : 10-Aug-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public ViewPatients clickOnBrowse5(String path) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(browse5, "xpath");
		this.page.element(browse5, "xpath").getOne()
		.sendKeys(path);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter text in find field.
	  * Date        : 10-Aug-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public ViewPatients enterTextInFind(String str) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(find, "xpath");
		this.page.element(find, "xpath").clearInputValue().sendKeys(str);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify upload zip files is displayed.
	* Date 		  : 10-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verUploadZipFile(String file) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements("//th[text()='Name']/../..//td[contains(text(),'"+file+"')]", "xpath");
		assertTrue(this.page.element("//th[text()='Name']/../..//td[contains(text(),'"+file+"')]", "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On Upload button.
	* Date 		  : 10-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnUploadButton() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(uploadButton, "xpath");
		this.page.element(uploadButton, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On back button.
	* Date 		  : 10-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnBackButton() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(back, "xpath");
		this.page.element(back, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On 'View/Modify Web Report' icon ' icon.
	* Date 		  : 11-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnViewOrModifyWebReportIcon() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		if((this.page.element(ModifyWebReport, "xpath")).isElementPresent()==true){
			objWaitForElement.waitForElements(ModifyWebReport, "xpath");
			this.page.element(ModifyWebReport, "xpath").getOne().click();
			
		}
		else{
			objWaitForElement.waitForElements(ModifyWebReport2, "xpath");
			this.page.element(ModifyWebReport2, "xpath").getOne().click();
			
		}
	/*	try{
		objWaitForElement.waitForElements(ModifyWebReport, "xpath");
		this.page.element(ModifyWebReport, "xpath").getOne().click();
		}
//		catch(NoSuchElementException exe){
//			objWaitForElement.waitForElements(ModifyWebReport1, "xpath");
//			this.page.element(ModifyWebReport1, "xpath").getOne().click();
//			
//		}
		catch(NoSuchElementException exe){
			objWaitForElement.waitForElements(ModifyWebReport2, "xpath");
			this.page.element(ModifyWebReport2, "xpath").getOne().click();
			
		}*/
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify web reporter page is displayed.
	* Date 		  : 11-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verWebReporterPage(String expected) throws Exception {
		String actual = driver.getTitle();
		System.out.println(actual+" aaaaa");
		assertTrue(actual.contains(expected));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify web report displayed.
	* Date 		  : 11-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verWebReport(String struser) throws Exception {
		objWaitForElement.waitForElements("//td[text()='"+struser+"']/..//a[contains(text(),'"+struser+"')]", "xpath");
		String str = "//td[text()='"+struser+"']/..//a[contains(text(),'"+struser+"')]";
		System.out.println(str);
		assertTrue(this.page.element("//td[text()='"+struser+"']/..//a[contains(text(),'"+struser+"')]", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify signed web report displayed.
	* Date 		  : 11-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verSignedByWebReport() throws Exception {
		objWaitForElement.waitForElements(signedBy, "xpath");
		assertTrue(this.page.element(signedBy, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On Attach Document icon.
	* Date 		  : 11-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnAttachDocumentIcon() throws Exception {
		objWaitForElement.waitForElements(attachDocument, "xpath");
		this.page.element(attachDocument, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On browse button and to enter file path.
	* Date 		  : 11-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnBrowseButton(String path) throws Exception {
		objWaitForElement.waitForElements(browse, "xpath");
		this.page.element(browse, "xpath").getOne().sendKeys(path);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On Upload button.
	* Date 		  : 11-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnUploadButton1() throws Exception {
		objWaitForElement.waitForElements(uploadButton1, "xpath");
		this.page.element(uploadButton1, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify uploaded document is displayed.
	* Date 		  : 11-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verUploadedDocument(String file) throws Exception {
		objWaitForElement.waitForElements("//a[contains(text(),'"+file+"')]", "xpath");
		assertTrue(this.page.element("//a[contains(text(),'"+file+"')]", "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On add button in web reporter page.
	* Date 		  : 12-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnAddButton() throws Exception {
		objWaitForElement.waitForElements(add, "xpath");
		this.page.element(add, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On add button.
	* Date 		  : 12-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public String getDateTimeOfUnSignedReport() throws Exception {
		objWaitForElement.waitForElements(getDateTimeOfUnSignedrpt, "xpath");
		String str = this.page.element(getDateTimeOfUnSignedrpt, "xpath").getOne().getText();
		String[] s = str.split("-");
		return s[0].trim();
	}
	
	/**********************************************************************************
	* Description : This function is to enter the text in patient text field.
	* Date 		  : 12-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients enterTextInPatientField() throws Exception {
		objWaitForElement.waitForElements(patient, "xpath");
		this.page.element(patient, "xpath").clearInputValue().sendKeys("abc");
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On 'save report' button.
	* Date 		  : 12-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnSaveReport() throws Exception {
		if(this.page.element(saveReport, "xpath").isElementPresent()==true){
		this.page.element(saveReport, "xpath").getOne().click();
		}
		else{
			objWaitForElement.waitForElements(saveReport1, "xpath");
			this.page.element(saveReport1, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On 'save report' button.
	* Date 		  : 12-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnSaveReport1() throws Exception {	
			objWaitForElement.waitForElements(saveReport1, "xpath");
			this.page.element(saveReport1, "xpath").getOne().click();
	
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify add button is not displayed.
	* Date 		  : 12-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verAddButtonNotDisplayed() throws Exception {
		assertFalse(this.page.element(add, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On 'send this study to DICOM storage device' button.
	* Date 		  : 26-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnSendThisStudyToDICOMStorageDevice(String str) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
//		String str = "//a[contains(text(),'Autostudy')]/../..//a[@onmouseover=\"status='Send this study to ...'; showInfo"
//				+ "('Click here to send this study to DICOM storage device, to printer or recipient by e-mail/e-fax'); return true;\"]";
		String str1 = "//a[contains(text(),'"+str+"')]/../..//img[@src='gifs.new/route_to.gif']";
		String str2 = "//td[contains(text(),'"+str+"')]/../..//img[@src='gifs.new/route_to.gif']";
		objWaitForElement.waitForElements(str1, "xpath");
		try {
		objWaitForElement.waitForElements(str1, "xpath");
		this.page.element(str1, "xpath").getOne().click();
		}
		catch(NoSuchElementException ne){
			objWaitForElement.waitForElements(str2, "xpath");
			this.page.element(str2, "xpath").getOne().click();
			
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On 'send this study to DICOM storage device' button.
	* Date 		  : 26-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnSendThisStudyToDICOMStorageDevice1(String str) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		String str2 = "//td[contains(text(),'"+str+"')]/../..//img[@src='gifs.new/route_to.gif']";	
			objWaitForElement.waitForElements(str2, "xpath");
			this.page.element(str2, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On 'send this report to' icon in add web report page.
	* Date 		  : 26-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnSendThisReportTo() throws Exception {
		//objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		String str2 = "//img[@src='gifs.new/route_to.gif']";	
			objWaitForElement.waitForElements(str2, "xpath");
			this.page.element(str2, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select DICOM storage device radio button.
	* Date 		  : 26-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients selDICOMStorageDeviceRadioButton() throws Exception {
		objWaitForElement.waitForElements(storageDeviceRadioBtn, "xpath");
		if(this.page.element(storageDeviceRadioBtn, "xpath").getOne().isSelected()==false){
			this.page.element(storageDeviceRadioBtn, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on next in 'Send study to Wizard' page.
	* Date 		  : 26-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnNextInSendStudyWizard() throws Exception {
		objWaitForElement.waitForElements(next1, "xpath");
			this.page.element(next1, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select storage device from dropdown menu.
	* Date 		  : 26-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients selStorageDevice(String device) throws Exception {
		objWaitForElement.waitForElements(storageDevice, "xpath");
			this.page.element(storageDevice, "xpath").webElementToSelect().selectByVisibleText(device);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on finish button.
	* Date 		  : 26-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnFinishButton() throws Exception {
		objWaitForElement.waitForElements(finish, "xpath");
		this.page.element(finish, "xpath").getOne();
		this.page.element(finish, "xpath").mouseOver();
			this.page.element(finish, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select last hours option from dropdown menu.
	* Date 		  : 26-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients selInLastOption(String hour) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(lastHour, "xpath");
			this.page.element(lastHour, "xpath").webElementToSelect().selectByVisibleText(hour);
			Thread.sleep(3000);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify incomming study and verify patient name starts
	*               with dn and patient id start with dp.
	* Date 		  : 26-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verIncommingStudy() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(study, "xpath");
			assertTrue(this.page.element(study, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to delete all old studies.
	* Date 		  : 26-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients delOldIncommingStudy() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(studyDel, "xpath");
			while(this.page.element(studyDel, "xpath").isElementPresent()==true){
				this.page.element(studyDel, "xpath").getOne().click();
				String mainWindow = driver.getWindowHandle();
				Set<String> str = driver.getWindowHandles();
				Iterator<String> itr = str.iterator();
				while (itr.hasNext()) {
					String childwindow = itr.next().toString();
					if (!childwindow.contains(mainWindow)) {
						driver.switchTo().window(childwindow);
						objWaitForElement.waitForElements("//input[@type='button'][@name='delete']", "xpath");
						this.page.element("//input[@type='button'][@name='delete']", "xpath").getOne().click();
						objWaitForElement.waitForElements("//input[@type='button'][@name='ok']", "xpath");
						this.page.element("//input[@type='button'][@name='ok']", "xpath").getOne().click();
						driver.switchTo().window(mainWindow);
						objWaitForElement.waitForElements("//img[@src='gifs.new/btn_sl_search.gif']", "xpath");
						this.page.element("//img[@src='gifs.new/btn_sl_search.gif']", "xpath").getOne().click();
						Thread.sleep(3000);
					}
				}

			}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify incomming study has changed its modality to CT.
	* Date 		  : 27-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verChangedModalityOfIncommingStudyToCT(String str) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements("//a[contains(text(),'"+str+"')]/../../preceding-sibling::tr[1]//nobr[contains(text(),'Modality:')]//b[text()='CT']", "xpath");
			assertTrue(this.page.element("//a[contains(text(),'"+str+"')]/../../preceding-sibling::tr[1]//nobr[contains(text(),'Modality:')]//b[text()='CT']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to delete study.
	* Date 		  : 27-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************//*
	public ViewPatients delStudy(String str) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements("//a[contains(text(),'"+str+"')]/../..//img[@src='gifs.new/delete.gif']", "xpath");
			while(this.page.element("//a[contains(text(),'"+str+"')]/../..//img[@src='gifs.new/delete.gif']", "xpath").isElementPresent()==true){
				this.page.element("//a[contains(text(),'"+str+"')]/../..//img[@src='gifs.new/delete.gif']", "xpath").mouseOver();
				this.page.element("//a[contains(text(),'"+str+"')]/../..//img[@src='gifs.new/delete.gif']", "xpath").getOne().click();
				
				String mainWindow = driver.getWindowHandle();
				Set<String> str1 = driver.getWindowHandles();
				Iterator<String> itr = str1.iterator();
				while (itr.hasNext()) {
					String childwindow = itr.next().toString();
					if (!childwindow.contains(mainWindow)) {
						driver.switchTo().window(childwindow);
						objWaitForElement.waitForElements("//input[@type='button'][@name='delete']", "xpath");
						this.page.element("//input[@type='button'][@name='delete']", "xpath").getOne().click();
						objWaitForElement.waitForElements("//input[@type='button'][@name='ok']", "xpath");
						this.page.element("//input[@type='button'][@name='ok']", "xpath").getOne().click();
						driver.switchTo().window(mainWindow);
			}
				}
			}
		return this;
	}
	*/
	/**********************************************************************************
	* Description : This function is to click On 'view or modify study' icon.
	* Date 		  : 28-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnViewOrModifyIcon() throws Exception {
		if (this.page.element(viewModifyStudy, "xpath").isElementPresent() == true) {

			this.page.element(viewModifyStudy, "xpath").getOne().click();
		} else if (this.page.element(viewModifyStudy1, "xpath")
				.isElementPresent() == true) {
			objWaitForElement.waitForElements(viewModifyStudy1, "xpath");
			this.page.element(viewModifyStudy1, "xpath").getOne().click();
		}

		else {
			objWaitForElement.waitForElements(viewModifyStudy2, "xpath");
			this.page.element(viewModifyStudy2, "xpath").getOne().click();

		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'RADIOLOGY REPORT' page is displayed.
	* Date 		  : 28-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verRadiologyReportPageIsDisplayed(String req) throws Exception {
		objWaitForElement.waitForElements(radiologyReport, "xpath");
		String str = driver.getTitle();
		assertTrue(str.equals(req));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'RADIOLOGY REPORT' page is not displayed.
	* Date 		  : 28-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verRadiologyReportPageIsNotDisplayed() throws Exception {
		objWaitForElement.waitForElements(radiologyReport, "xpath");
		assertFalse(this.page.element(radiologyReport, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Express Transcription' page is displayed.
	* Date 		  : 31-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verExpressTranscriptionPageIsDisplayed(String expected) throws Exception {
		String actual = driver.getTitle();
		assertTrue(actual.contains(expected));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to get id of a any study.
	* Date 		  : 31-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public String getIdOfAnyStudy() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		try{
		objWaitForElement.waitForElements(getId, "xpath");
		String str = this.page.element(getId, "xpath").getOne().getText();
		return str;
		}
		catch(NoSuchElementException ele){
			this.selInLastOption("8 hours");
			this.clickOnSearch().clickOnSearch().clickOnSearch().clickOnSearch();
			objWaitForElement.waitForElements(getId, "xpath");
			String str = this.page.element(getId, "xpath").getOne().getText();
			return str;
		}
	}
	
	/**********************************************************************************
	* Description : This function is to disable 'click to mark this study as read/unread' checkbox.
	* Date 		  : 31-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients deSelThisStudyReadCheckBox(String id) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements("//td[contains(text(),'"+id+"')]//preceding-sibling::td//input", "xpath");
		if(this.page.element("//td[contains(text(),'"+id+"')]//preceding-sibling::td//input", "xpath").getOne().isSelected()==true){
			this.page.element("//td[contains(text(),'"+id+"')]//preceding-sibling::td//input", "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter the text in 'Additional Remarks' field.
	* Date 		  : 31-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients enterTextInAdditionalRemarksField() throws Exception {
		objWaitForElement.waitForElements(additionaRemarks, "xpath");
		this.page.element(additionaRemarks, "xpath").clearInputValue().sendKeys("report");
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on save and sign report button.
	* Date 		  : 31-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnSaveSignReport() throws Exception {
		try{
		objWaitForElement.waitForElements(saveSignReport, "xpath");
		this.page.element(saveSignReport, "xpath").getOne().click();
		}
		catch (NoSuchElementException e){
			objWaitForElement.waitForElements(saveSignReport1, "xpath");
			this.page.element(saveSignReport1, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on sign report button.
	* Date 		  : 31-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnSignReport() throws Exception {
		objWaitForElement.waitForElements(signReport, "xpath");
		this.page.element(signReport, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'click to mark this study as read/unread' checkbox
	*               is enabled.
	* Date 		  : 31-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verThisStudyReadCheckBoxIsEnabled(String study)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements("//a[contains(text(),'"+study+"')]/..//preceding-sibling::td//input", "xpath");
		assertTrue(this.page
				.element(
						"//a[contains(text(),'"+study+"')]/..//preceding-sibling::td//input", "xpath")
				.getOne().isSelected() == true);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on study link in webreporter page.
	* Date 		  : 01-Sep-2015 (mod)
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnStudyInWebReporterPage() throws Exception {
		objWaitForElement.waitForElements("//a[contains(text(),'admin:')]", "xpath");
		this.page.element("//a[contains(text(),'admin:')]", "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify uploaded signature file in webreporter page.
	* Date 		  : 01-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verUploadedSigFileInWebReporterPage() throws Exception {
		objFrames.switchToIFrame();
		objWaitForElement.waitForElements(sigFile, "xpath");
		assertTrue(this.page.element(sigFile, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On 'modify study field(green pencil icon)' of a particular study.
	* Date 		  : 01-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnModifyStudyFieldsOfAStudy(String strstudy) throws Exception {
		objWaitForElement.waitForElements("//a[contains(text(),'"+strstudy+"')]/ancestor::tr[1]//img[@src='/cobalt-images/modify.gif']", "xpath");
		this.page.element("//a[contains(text(),'"+strstudy+"')]/ancestor::tr[1]//img[@src='/cobalt-images/modify.gif']", "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify the study coming from another server.
	* Date 		  : 09-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verStudyFromOtherServer(String study) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements("//a[contains(text(),'" + study
				+ "')]", "xpath");
		if (this.page.element("//a[contains(text(),'" + study + "')]", "xpath")
				.isElementPresent() == true) {
			assertTrue(this.page.element(
					"//a[contains(text(),'" + study + "')]", "xpath")
					.isElementPresent());
		}

		else {
			objWaitForElement.waitForElements("//td[contains(text(),'" + study
					+ "')]", "xpath");
			assertTrue(this.page.element(
					"//td[contains(text(),'" + study + "')]", "xpath")
					.isElementPresent());

		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify blank report icon displayed in front of a study.
	* Date 		  : 09-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verBlankReportIconOfAStudy(String study)
			throws Exception {
		String str = "//a[contains(text(),'"
				+ study
				+ "')]/../following-sibling::td//a/img[@src='gifs.new/report.gif']";
		objWaitForElement.waitForElements(str, "xpath");
		assertTrue(this.page.element(str, "xpath").isElementPresent());

		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify the study coming from another server.
	* Date 		  : 09-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verStudyFromOtherServer1(String study) throws Exception {
			objWaitForElement.waitForElements("//a[contains(text(),'" + study
					+ "')]", "xpath");
			assertTrue(this.page.element(
					"//a[contains(text(),'" + study + "')]", "xpath")
					.isElementPresent());

		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select study.
	* Date 		  : 09-Sep-2015
	* Author 	  : Hanumegowda
	 * @return 
	**********************************************************************************/
	public boolean selStudy(String str) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		String xp = "//a[contains(text(),'"+str+"')]/../..//nobr//input";
		objWaitForElement.waitForElements(xp, "xpath");
		try{
			if(this.page.element(xp, "xpath").isElementPresent()==true){
		List<WebElement> ele = driver.findElements(By.xpath(xp));
		for(WebElement ele1:ele){
			ele1.click();	
		}
			}
		return true;
		}
		catch (NoSuchElementException e){
			return false;
			
		}
	}
	
	/**********************************************************************************
	* Description : This function is to select select all studies checkbox.
	* Date 		  : 09-Sep-2015
	* Author 	  : Hanumegowda
	 * @return 
	**********************************************************************************/
	public boolean selSelectAllStudyCheckbox() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(selAllStudychckbox, "xpath");
		try{
			if(this.page.element(selAllStudychckbox, "xpath").getOne().isSelected()==false){
				this.page.element(selAllStudychckbox, "xpath").getOne().click();
		
		}
			return true;
			}
		
		catch (NoSuchElementException e){
			return false;
			
		}
	}
	
	/**********************************************************************************
	* Description : This function is to delete all the selected studies.
	* Date 		  : 09-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients delAllSelectedStudies() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(deleteAllStudy, "xpath");
		if(this.page.element(deleteAllStudy, "xpath").isElementPresent()==true){
			Thread.sleep(10000);
		this.page.element(deleteAllStudy, "xpath").getOne().click();
		String mainWindow = driver.getWindowHandle();
		Set<String> str1 = driver.getWindowHandles();
		Iterator<String> itr = str1.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!childwindow.contains(mainWindow)) {
				driver.switchTo().window(childwindow);
				if(this.page.element(continueToThisWebsite, "xpath").isElementPresent()==true){
					objWaitForElement.waitForElements(continueToThisWebsite, "xpath");
				this.page.element(continueToThisWebsite, "xpath").getOne().click();
				}
				objWaitForElement.waitForElements(ok, "xpath");
				this.page.element(ok, "xpath").getOne().click();
				objWaitForElement.waitForElements(ok1, "xpath");
				this.page.element(ok1, "xpath").getOne().click();
				
	}
		}
		driver.switchTo().window(mainWindow);
		}
		
		else{
			System.out.println("there is no study");
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to delete all the selected studies when there is no 
	*               'Continue to this website (not recommended).' secrity link.
	* Date 		  : 09-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients delAllSelectedStudiesWithoutSecurityLink() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(deleteAllStudy, "xpath");
			Thread.sleep(5000);
		this.page.element(deleteAllStudy, "xpath").getOne().click();
		objUserManagement.clickOnOkInAlertPopUp();
		String mainWindow = driver.getWindowHandle();
		Set<String> str1 = driver.getWindowHandles();
		Iterator<String> itr = str1.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!childwindow.contains(mainWindow)) {
				driver.switchTo().window(childwindow);
				objWaitForElement.waitForElements(ok, "xpath");
				this.page.element(ok, "xpath").getOne().click();
				objWaitForElement.waitForElements(ok1, "xpath");
				this.page.element(ok1, "xpath").getOne().click();
				
	}
		}
		driver.switchTo().window(mainWindow);
		return this;
	}
	
	
	/**********************************************************************************
	* Description : This function is to delete a particular study.
	* Date 		  : 09-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients delAPerticularStudy(String strstudy) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		String stu = "//a[contains(text(),'"+strstudy+"')]/../..//td//a/img[@src='gifs.new/delete.gif']";
		objWaitForElement.waitForElements(stu, "xpath");
		Thread.sleep(5000);
		this.page.element(stu, "xpath").mouseOver();
		this.page.element(stu, "xpath").getOne().click();
		Thread.sleep(5000);
		String mainWindow = driver.getWindowHandle();
		Set<String> str1 = driver.getWindowHandles();
		Iterator<String> itr = str1.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!childwindow.contains(mainWindow)) {
				driver.switchTo().window(childwindow);
//				objWaitForElement.waitForElements(continueToThisWebsite, "xpath");
//				this.page.element(continueToThisWebsite, "xpath").getOne().click();
				objWaitForElement.waitForElements(ok, "xpath");
				this.page.element(ok, "xpath").getOne().click();
				objWaitForElement.waitForElements(ok1, "xpath");
				this.page.element(ok1, "xpath").getOne().click();
				driver.switchTo().window(mainWindow);
	}
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On View/Modify Web Reports icon of a Study.
	* Date 		  : 18-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnViewModifyWebReportsOfAStudy(String study) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		if(this.page.element("//a[contains(text(),'"+study+"')]/../..//img[@src='gifs.new/report.gif']", "xpath").isElementPresent()==true){
		objWaitForElement.waitForElements("//a[contains(text(),'"+study+"')]/../..//img[@src='gifs.new/report.gif']", "xpath");
		this.page.element("//a[contains(text(),'"+study+"')]/../..//img[@src='gifs.new/report.gif']", "xpath").mouseOver();
		this.page.element("//a[contains(text(),'"+study+"')]/../..//img[@src='gifs.new/report.gif']", "xpath").getOne().click();
		}
		else if(this.page.element("//a[contains(text(),'"+study+"')]/../..//img[@src='gifs.new/reportex.gif']", "xpath").isElementPresent()==true){
			objWaitForElement.waitForElements("//a[contains(text(),'"+study+"')]/../..//img[@src='gifs.new/reportex.gif']", "xpath");
			this.page.element("//a[contains(text(),'"+study+"')]/../..//img[@src='gifs.new/reportex.gif']", "xpath").getOne().click();
			}
		else{
			objWaitForElement.waitForElements("//a[contains(text(),'"+study+"')]/../..//img[@src='gifs.new/reportf.gif']", "xpath");
			this.page.element("//a[contains(text(),'"+study+"')]/../..//img[@src='gifs.new/reportf.gif']", "xpath").getOne().click();
			
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On View/Modify Web Reports icon of a Study that is created by other user.
	* Date 		  : 18-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnViewModifyWebReportsOfAStudyAsOtherUser(String study) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		String str = "//td[contains(text(),'"+study+"')]/..//a/img[@src='gifs.new/report.gif']";
		objWaitForElement.waitForElement(str, "xpath");
		this.page.element(str, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On View/Modify Web Reports icon of a Study that contains signed report.
	* Date 		  : 18-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnViewModifyWebReportsOfAStudyContainsSignedReport(
			String study) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		try{

		objWaitForElement.waitForElements("//td[contains(text(),'" + study
				+ "')]/../..//img[@src='gifs.new/reportf.gif']", "xpath");
		this.page
				.element(
						"//td[contains(text(),'" + study
								+ "')]/../..//img[@src='gifs.new/reportf.gif']",
						"xpath").getOne().click();
		}
		catch(NoSuchElementException e){
			objWaitForElement.waitForElements("//a[contains(text(),'" + study
					+ "')]/../..//img[@src='gifs.new/reportf.gif']", "xpath");
			this.page
					.element(
							"//a[contains(text(),'" + study
									+ "')]/../..//img[@src='gifs.new/reportf.gif']",
							"xpath").getOne().click();
		}

		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify signed report is displayed.
	* Date 		  : 18-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verSignedReport() throws Exception {
		objWaitForElement.waitForElements(signedReport, "xpath");
		assertTrue(this.page.element(signedReport, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify saved report is not displayed.
	* Date 		  : 18-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verSavedReportNotDisplayed() throws Exception {
		objWaitForElement.waitForElements(savedReport, "xpath");
		assertFalse(this.page.element(savedReport, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE1));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify saved report is not displayed.
	* Date 		  : 18-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verSavedReportNotDisplayed1(String req) throws Exception {
		String savedReport1 = "//a[contains(text(),'"+req+"')]/../../following-sibling::td//a/img[@src='/wavelet/gifs.new/sign_doc_but.gif']";
		System.out.println(savedReport1);
		objWaitForElement.waitForElements(savedReport1, "xpath");
		assertFalse(this.page.element(savedReport1, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE1));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to delete report in web reporter page.
	* Date 		  : 18-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients delReport() throws Exception {
		objWaitForElement.waitForElements(delReport, "xpath");
		this.page.element(delReport, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify saved report is displayed.
	* Date 		  : 21-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verSavedReportIsDisplayed() throws Exception {
		objWaitForElement.waitForElements(savedReport, "xpath");
		assertTrue(this.page.element(savedReport, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify saved report is displayed.
	* Date 		  : 21-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verSavedReportIsDisplayed1(String req) throws Exception {
		String savedReport1 = "//a[contains(text(),'"+req+"')]/../../following-sibling::td//a/img[@src='/wavelet/gifs.new/sign_doc_but.gif']";
		System.out.println(savedReport1);
		objWaitForElement.waitForElements(savedReport1, "xpath");
		assertTrue(this.page.element(savedReport1, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Status' option from dropdown menu.
	* Date 		  : 22-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients selStatusOption(String option) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(status, "xpath");
			this.page.element(status, "xpath").webElementToSelect().selectByVisibleText(option);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Modality' option from dropdown menu.
	* Date 		  : 22-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients selModalityOption(String option) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(modalityOption, "xpath");
			this.page.element(modalityOption, "xpath").webElementToSelect().selectByVisibleText(option);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Limit' option from dropdown menu.
	* Date 		  : 22-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients selLimitOption(String option) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(limitOption, "xpath");
			this.page.element(limitOption, "xpath").webElementToSelect().selectByVisibleText(option);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Where' option from dropdown menu.
	* Date 		  : 22-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients selWhereOption(String option) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(where, "xpath");
			this.page.element(where, "xpath").webElementToSelect().selectByVisibleText(option);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'acess permission' key icon of a study.
	* Date 		  : 23-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnAccessPermissionKey(String study) throws Exception {
		objWaitForElement.waitForElements("//a[contains(text(),'"+study+"')]/../..//img[@src='gifs.new/allow_for.gif']", "xpath");
		this.page.element("//a[contains(text(),'"+study+"')]/../..//img[@src='gifs.new/allow_for.gif']", "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select a check box corresponding to a user.
	  * Date        : 23-Sep-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public ViewPatients selUserCheckBox(String user) throws Exception {
		objWaitForElement.waitForElements("//input[@name='USERS'][@value='"+user+"']", "xpath");
		this.page.element("//input[@name='USERS'][@value='"+user+"']", "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on 'Change' in user list page.
	  * Date        : 23-Sep-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public ViewPatients clickOnChange() throws Exception {
		objWaitForElement.waitForElements(change, "xpath");
		this.page.element(change, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'recipient as HTML report by E-Mail' radio button.
	* Date 		  : 24-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients selRecipientHTMLReportEMailRadioButton() throws Exception {
		objWaitForElement.waitForElements(htmlReport, "xpath");
		if(this.page.element(htmlReport, "xpath").getOne().isSelected()==false){
			this.page.element(htmlReport, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter the text in to field.
	* Date 		  : 24-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients enterTextInToField(String mailid) throws Exception {
		objWaitForElement.waitForElements(strTo, "id");
		this.page.element(strTo, "id").clearInputValue().sendKeys(mailid);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter the text in subject field.
	* Date 		  : 24-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients enterTextInSubField(String sub) throws Exception {
		if(this.page.element(strSubject, "xpath").isElementPresent()==true){
		objWaitForElement.waitForElements(strSubject, "xpath");
		this.page.element(strSubject, "xpath").clearInputValue().sendKeys(sub);
		}
		else{
			objWaitForElement.waitForElements(strSubject1, "xpath");
			this.page.element(strSubject1, "xpath").clearInputValue().sendKeys(sub);
			System.out.println("ele not there");
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'recipient as PDF report by E-Fax' radio button.
	* Date 		  : 25-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients selRecipientPDFReportByEFaxRadioButton() throws Exception {
		objWaitForElement.waitForElements(pdfReport, "xpath");
		if(this.page.element(pdfReport, "xpath").getOne().isSelected()==false){
			this.page.element(pdfReport, "xpath").mouseOver();
			this.page.element(pdfReport, "xpath").getOne().click();
			Thread.sleep(5000);
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'recipient as MWW attachment by E-Mail' radio button.
	* Date 		  : 28-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients selRecipientMWWAttachmentByEMailRadioButton() throws Exception {
		objWaitForElement.waitForElements(mwwReport, "xpath");
		if(this.page.element(mwwReport, "xpath").getOne().isSelected()==false){
			this.page.element(mwwReport, "xpath").mouseOver();
			this.page.element(mwwReport, "xpath").getOne().click();
			Thread.sleep(5000);
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify the study is not displayed in study list page.
	* Date 		  : 01-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verStudyIsNotDisplayed(String study) throws Exception {
		objWaitForElement.waitForElements("//a[contains(text(),'"+study+"')]", "xpath");
		assertFalse(this.page.element("//a[contains(text(),'"+study+"')]", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'No studies available' error message in study list page.
	* Date 		  : 01-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verNoStudiesAvailableErrorMessage() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements("//h2[text()='No studies available/selected']", "xpath");
		assertTrue(this.page.element("//h2[text()='No studies available/selected']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On 'modify study fields' icon of any study.
	* Date 		  : 19-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnModifyStudyFieldsIconOfAnyStudy() throws Exception {
		objWaitForElement.waitForElements(modifyStudy, "xpath");
		this.page.element(modifyStudy, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify MTF code.
	* Date 		  : 19-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verMTFCode(String strmtf) throws Exception {
		objWaitForElement.waitForElements(mtfCode, "xpath");
		String actual = this.page.element(mtfCode, "xpath").getOne().getAttribute("value");
		assertTrue(actual.equals(strmtf));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify Referring Physician's Name.
	* Date 		  : 19-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verReferringPhysicianName(String strRp) throws Exception {
		objWaitForElement.waitForElements(refPhyName, "xpath");
		String actual = this.page.element(refPhyName, "xpath").getOne().getAttribute("value");
		assertTrue(actual.equals(strRp));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify Modality of a study in modify study window.
	* Date 		  : 20-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verModality(String strmodality) throws Exception {
		objWaitForElement.waitForElements(modality, "xpath");
		String actual = this.page.element(modality, "xpath").getOne().getAttribute("value");
		assertTrue(actual.equals(strmodality));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify any Modality of a study in modify study window.
	* Date 		  : 20-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verAnyModality(String strmodality) throws Exception {
		objWaitForElement.waitForElements(modality, "xpath");
		String actual = this.page.element(modality, "xpath").getOne().getAttribute("value");
		try{
		assertTrue(actual.equals(strmodality));
		}
		catch(AssertionError a){
			assertTrue(!(actual.equals(strmodality)));
			System.out.println("abcd");
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify Institution Name in modify study page.
	* Date 		  : 21-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verInstitutionName(String strmtf) throws Exception {
		objWaitForElement.waitForElements(institutionName, "xpath");
		String actual = this.page.element(institutionName, "xpath").getOne().getAttribute("value");
		System.out.println(actual);
		assertTrue(actual.equalsIgnoreCase(strmtf));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Site' in view patient page.
	* Date 		  : 27-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verSite(String strmtf) throws Exception {
		objWaitForElement.waitForElements(site, "xpath");
		List<WebElement> ae = driver.findElements(By.xpath(site));
		for (WebElement ee : ae) {
			String str = ee.getText();
			assertTrue(str.equalsIgnoreCase(strmtf));
			System.out.println("count");
			System.out.println(str);

		}

		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify Institution Name of all studies in modify study page.
	* Date 		  : 27-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verInstitutionNameOfAllStudies(String strmtf,String str)
			throws Exception {
		objWaitForElement.waitForElements(modifyStudy, "xpath");
		List<WebElement> allele = driver.findElements(By.xpath(modifyStudy));
		this.page.element(modifyStudy, "xpath").isElementPresent();
		String mw = driver.getWindowHandle();
		for (WebElement ele : allele) {
			objFrames.switchToDefaultFrame().switchToRightFrame()
					.switchToMainInRightFrame();
			ele.click();
			Set<String> aw = driver.getWindowHandles();
			Iterator<String> itr = aw.iterator();
			while (itr.hasNext()) {
				String cw = itr.next().toString();
				if (!mw.contains(cw)) {
					driver.switchTo().window(cw);
					if(str.equals("Institue")){
					this.verInstitutionName(strmtf);
					System.out.println("count");
					}
				}
			}
			driver.close();
			driver.switchTo().window(mw);
			Thread.sleep(10000);
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify mtf of all studies.
	* Date 		  : 27-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verMtfOfAllStudies(String strmtf)
			throws Exception {
		objWaitForElement.waitForElements(modifyStudy, "xpath");
		List<WebElement> allele = driver.findElements(By.xpath(modifyStudy));
		String mw = driver.getWindowHandle();
		for (WebElement ele : allele) {
			objFrames.switchToDefaultFrame().switchToRightFrame()
					.switchToMainInRightFrame();
			ele.click();
			Set<String> aw = driver.getWindowHandles();
			Iterator<String> itr = aw.iterator();
			while (itr.hasNext()) {
				String cw = itr.next().toString();
				if (!mw.contains(cw)) {
					driver.switchTo().window(cw);
					this.verMTFCode(strmtf);
				}
			}
			driver.close();
			driver.switchTo().window(mw);
			Thread.sleep(10000);
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify mtf of all studies.
	* Date 		  : 27-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verRefPhysicianOfAllStudies(String strrp)
			throws Exception {
		objWaitForElement.waitForElements(modifyStudy, "xpath");
		List<WebElement> allele = driver.findElements(By.xpath(modifyStudy));
		String mw = driver.getWindowHandle();
		for (WebElement ele : allele) {
			objFrames.switchToDefaultFrame().switchToRightFrame()
					.switchToMainInRightFrame();
			ele.click();
			Set<String> aw = driver.getWindowHandles();
			Iterator<String> itr = aw.iterator();
			while (itr.hasNext()) {
				String cw = itr.next().toString();
				if (!mw.contains(cw)) {
					driver.switchTo().window(cw);
					this.verReferringPhysicianName(strrp);
				}
			}
			driver.close();
			driver.switchTo().window(mw);
			Thread.sleep(10000);
		}
		return this;
	}



	/**********************************************************************************
	* Description : This function is to verify Institution Name of all studies in modify study page.
	* Date 		  : 27-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verInstitutionNameOfAllStudies1(String strmtf) throws Exception {
		objWaitForElement.waitForElements(modifyStudy, "xpath");
		//List<WebElement> allele = driver.findElements(By.xpath(modifyStudy));
		String mw = driver.getWindowHandle();
		for(int i=1;i<=10;i++){
			objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		this.page.element("(//img[@src='/cobalt-images/modify.gif'])["+i+"]", "xpath").getOne().click();
			Set<String> aw = driver.getWindowHandles();
			Iterator<String> itr = aw.iterator();
			while(itr.hasNext()){
				String cw = itr.next().toString();
				if(!mw.contains(cw)){
					driver.switchTo().window(cw);
					this.verInstitutionName(strmtf);
				}
			}
			driver.close();
			driver.switchTo().window(mw);
			Thread.sleep(10000);
		}
		
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify only selected station studies are displayed.
	* Date 		  : 27-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verSelectedStation(String strmtf) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		String ele = "(//nobr[contains(text(),'Station name:')])/b";
		List<WebElement> all = driver.findElements(By.xpath(ele));
		for(WebElement e1 : all){
			String req = e1.getText();
			assertTrue(req.equals(strmtf));
			System.out.println(strmtf+" stareq");
			System.out.println(req+" staactu");
		}
		/*objWaitForElement.waitForElements(
				"(//nobr[contains(text(),'Station name:')])[1]/b[text()='"
						+ strmtf + "']", "xpath");
		assertTrue((this.page.element(
				"(//nobr[contains(text(),'Station name:')])[1]/b[text()='"
						+ strmtf + "']", "xpath")).isElementPresent());
		assertFalse((this.page.element(
				"(//nobr[contains(text(),'Station name:')])[2]", "xpath"))
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));*/
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify only one station is displayed.
	* Date 		  : 27-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verSecondStationNotPresent() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		String ele = "((//nobr[contains(text(),'Station name:')])/b)[2]";
		assertFalse(this.page.element(ele, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Change Stat Status Of a Study'
	 * Date        : 03-Nov-2015
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public ViewPatients clickOnChangeStatStatusOfStudy() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(changeStatStatusOfStudy, "xpath");
		this.page.element(changeStatStatusOfStudy, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On close link.
	* Date 		  : 03-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnCloseLink() throws Exception {
		objWaitForElement.waitForElements(close, "xpath");
		this.page.element(close, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Mark Study As Read' Checkbox.
	* Date 		  : 03-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients selMarkStudyAsReadCheckbox(String study) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		String str = "//a[contains(text(),'"+study+"')]/../preceding-sibling::td//input";
		objWaitForElement.waitForElements(str, "xpath");
		if( (this.page.element("//a[contains(text(),'"+study+"')]/../preceding-sibling::td//input", "xpath").getOne().isSelected())==false){
			this.page.element("//a[contains(text(),'"+study+"')]/../preceding-sibling::td//input", "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify stat status of the study.
	* Date 		  : 03-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verStatStatus(String study) throws Exception {
		objWaitForElement.waitForElements("//a[contains(text(),'"+study+"')]/../..//img[@src='gifs.new/stat_0.gif']", "xpath");
		assertTrue(this.page.element("//a[contains(text(),'"+study+"')]/../..//img[@src='gifs.new/stat_0.gif']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On Attachment in edit report page.
	* Date 		  : 05-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnAttachmentInEditReportPage() throws Exception {
		objWaitForElement.waitForElements(attachment, "id");
		this.page.element(attachment, "id").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click On browse in attach file window.
	  * Date        : 05-Nov-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public ViewPatients clickOnBrowseInAttachFileWindow(String path) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(attachBrowse, "xpath");
		this.page.element(attachBrowse, "xpath").getOne()
		.sendKeys(path);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify attached file.
	* Date 		  : 05-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verAttachedFile(String file) throws Exception {
		objWaitForElement.waitForElements("//b[text()='ATTACHMENT:']/../following-sibling::div//a[contains(text(),'"+file+"')]", "xpath");
		assertTrue(this.page.element("//b[text()='ATTACHMENT:']/../following-sibling::div//a[contains(text(),'"+file+"')]", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on attached file.
	* Date 		  : 05-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnAttachedFile(String file) throws Exception {
		objWaitForElement.waitForElements("//b[text()='ATTACHMENT:']/../following-sibling::div//a[contains(text(),'"+file+"')]", "xpath");
		this.page.element("//b[text()='ATTACHMENT:']/../following-sibling::div//a[contains(text(),'"+file+"')]", "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify stat status of the study with red circle is displayed.
	* Date 		  : 05-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verStatStatusWithRedCircle(String study) throws Exception {
		objWaitForElement.waitForElements("//a[contains(text(),'"+study+"')]/../..//img[@src='gifs.new/stat_or.gif']", "xpath");
		assertTrue(this.page.element("//a[contains(text(),'"+study+"')]/../..//img[@src='gifs.new/stat_or.gif']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter the text in 'send to' field in edit report page.
	* Date 		  : 06-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients enterTextInSendToFieldInEditReportPage(String mailid) throws Exception {
		objWaitForElement.waitForElements(sendTo1, "xpath");
		this.page.element(sendTo1, "xpath").clearInputValue().sendKeys(mailid);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'local PC storage device (Local HD, USB Storage, CD-RW, ...)' radio button.
	* Date 		  : 09-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients sellocalpcRadioButton() throws Exception {
		objWaitForElement.waitForElements(localpc, "xpath");
		if(this.page.element(localpc, "xpath").getOne().isSelected()==false){
			this.page.element(localpc, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter the text in 'local path' field in 'Save study to
	*               local PC storage Wizard (Step 2)' page.
	* Date 		  : 09-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients enterTextInLocalPath(String path) throws Exception {
		objWaitForElement.waitForElements(localpath, "xpath");
		this.page.element(localpath, "xpath").getOne().click();
			this.page.element(localpath, "xpath").clearInputValue().sendKeys(path);
		
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Save DCM' chechbox in "Save study to local PC
	*               storage" Wizard (Step 2) page.
	* Date 		  : 09-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients selSaveDcmCheckbox() throws Exception {
		objWaitForElement.waitForElements(saveDcm, "xpath");
		if(this.page.element(saveDcm, "xpath").getOne().isSelected()==false){
			this.page.element(saveDcm, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On 'Upload DCM' link.
	* Date 		  : 09-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnUploadDCMLink() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(uploadDCM, "xpath");
		this.page.element(uploadDCM, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify Upload DICOM file page is displayed.
	* Date 		  : 09-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verUploadDICOMFilePage() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(uploadDICOMFile, "xpath");
		assertTrue(this.page.element(uploadDICOMFile, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select study by login as user.
	* Date 		  : 09-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public boolean selStudyAsUser(String str) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		String xp1 = "//td[contains(text(),'"+str+"')]/../..//nobr//input";
		objWaitForElement.waitForElements(xp1, "xpath");
		try{
			if(this.page.element(xp1, "xpath").isElementPresent()==true){
		List<WebElement> ele = driver.findElements(By.xpath(xp1));
		for(WebElement ele1:ele){
			ele1.click();	
		}
			}
		return true;
		}
		catch (NoSuchElementException e){
			return false;
			
		}
	}
	
	/**********************************************************************************
	* Description : This function is to deselect 'Mark Study As Read' Checkbox.
	* Date 		  : 09-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients deSelMarkStudyAsReadCheckbox(String study) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		String str = "//a[contains(text(),'"+study+"')]/../preceding-sibling::td//input";
		objWaitForElement.waitForElements(str, "xpath");
		if( (this.page.element("//a[contains(text(),'"+study+"')]/../preceding-sibling::td//input", "xpath").getOne().isSelected())==true){
			this.page.element("//a[contains(text(),'"+study+"')]/../preceding-sibling::td//input", "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select layout option from dropdown menu.
	* Date 		  : 09-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients selLayout(String strlayout) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(layout, "xpath");
			this.page.element(layout, "xpath").webElementToSelect().selectByVisibleText(strlayout);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On 'green' square box of a study.
	* Date 		  : 13-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnGreenSquareBoxOfAStudy(String strstudy) throws Exception {
		String str = "//a[contains(text(),'"+strstudy+"')]/../..//td//div[@title='SUCCESS,COMPLETE']";
		objWaitForElement.waitForElements(str, "xpath");
		this.page.element(str, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Study routing history' page is displayed.
	* Date 		  : 13-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verStudyRoutingHistoryPageIsDisplayed() throws Exception {
		objWaitForElement.waitForElements(studyRoutingHistory, "xpath");
		assertTrue(this.page.element(studyRoutingHistory, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Study routing history'.
	* Date 		  : 13-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verStudyRoutingHistory(String[] clumn, String[] rows, String estr) throws Exception {
		int i = clumn.length;
		System.out.println(i+": array lngth");
		for(int k=1;k<=i;k++){
		objWaitForElement.waitForElements("//th["+k+"][text()='"+clumn[k-1]+"']/../following-sibling::tr/td["+k+"]", "xpath");
		String actual = (this.page.element("//th["+k+"][text()='"+clumn[k-1]+"']/../following-sibling::tr/td["+k+"]", "xpath").getOne().getText());
		System.out.println(actual);
		if(k<5){
		assertTrue(actual.contains(rows[k-1]));
			}
			else {
				assertTrue((actual.contains(rows[k-1])) | (actual.contains(estr)));
			}
				
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Remove Link Infront of Uploaded Attachment' is displayed.
	* Date 		  : 16-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verRemoveLinkInUploadedAttachment(String file)
			throws Exception {
		objWaitForElement.waitForElements(
				"//a[text()='remove']/preceding-sibling::b//a[contains(text(),'"
						+ file + "')]", "xpath");
		assertTrue(this.page
				.element(
						"//a[text()='remove']/preceding-sibling::b//a[contains(text(),'"
								+ file + "')]", "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Remove Link Infront of Uploaded Attachment' is not displayed.
	* Date 		  : 16-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verRemoveLinkInUploadedAttachmentIsNotPresent(
			String file) throws Exception {
		String str = "//a[text()='remove']/preceding-sibling::b//a[contains(text(),'"
				+ file + "')]";
		System.out.println(str);
		assertFalse(this.page.element(str, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE1));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Remove Link Infront of Uploaded Attachment'.
	* Date 		  : 16-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickRemoveLinkInUploadedAttachment(String file)
			throws Exception {
		objWaitForElement.waitForElements(
				"//a[contains(text(),'"+file+"')]/..//following-sibling::a[text()='remove']", "xpath");
		this.page
				.element(
						"//a[contains(text(),'"+file+"')]/..//following-sibling::a[text()='remove']", "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to get the version of the application.
	* Date 		  : 13-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public String getVersionOfTheApp() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(version, "xpath");
		String str = this.page.element(version, "xpath").getOne().getText();
		String[] str1 = str.split("Version");
		String[] str2 = str1[1].split("--");
		String str3 = str2[0].trim();
		System.out.println(str3);
		return str3;
	}
	
	/**********************************************************************************
	* Description : This function is to click On 'QC modify study' icon of a particular study.
	* Date 		  : 17-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnModifyStudyIconOfAStudy(String strstudy) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements("//a[contains(text(),'"+strstudy+"')]/ancestor::tr[1]//img[@src='gifs.new/qc_modify.gif']", "xpath");
		this.page.element("//a[contains(text(),'"+strstudy+"')]/ancestor::tr[1]//img[@src='gifs.new/qc_modify.gif']", "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'One or more complete series in this study' radio button.
	* Date 		  : 17-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients selOneOrMoreCompleteSeriesInThisStudyRadioButton() throws Exception {
		objWaitForElement.waitForElements(aseries, "xpath");
		if(this.page.element(aseries, "xpath").getOne().isSelected()==false){
			this.page.element(aseries, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On 'proceed' button.
	* Date 		  : 17-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnProceedButton() throws Exception {
		objWaitForElement.waitForElements(proceed, "id");
		this.page.element(proceed, "id").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On 'select all' button in 'Split Merge and Move Wizard' page.
	* Date 		  : 17-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnSelAllInSplitMergeMoveWizard() throws Exception {
		objWaitForElement.waitForElements(selectAll, "name");
		this.page.element(selectAll, "name").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On 'move' button in 'Split Merge and Move Wizard' page.
	* Date 		  : 17-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnMoveInSplitMergeMoveWizard() throws Exception {
		objWaitForElement.waitForElements(move, "name");
		this.page.element(move, "name").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On 'New Study' button in 'Split Merge and Move Wizard' page.
	* Date 		  : 17-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnNewStudyInSplitMergeMoveWizard() throws Exception {
		objWaitForElement.waitForElements(newStudy, "name");
		this.page.element(newStudy, "name").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On 'OK' button in 'Split Merge and Move Wizard' page.
	* Date 		  : 17-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnOKInSplitMergeMoveWizard() throws Exception {
		objWaitForElement.waitForElements(okInSpiltMoveWizard, "name");
		this.page.element(okInSpiltMoveWizard, "name").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to get the count of images of study.
	* Date 		  : 17-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public String getCountOfImagesOfStudy(String stdy) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements("//th[5][text()='Imgs']/../following-sibling::tr[@id='str1']//a[contains(text(),'"+stdy+"')]/../../td[5]", "xpath");
		String str = this.page.element("//th[5][text()='Imgs']/../following-sibling::tr[@id='str1']//a[contains(text(),'"+stdy+"')]/../../td[5]", "xpath").getOne().getText();
		return str;
	}
	
	/**********************************************************************************
	* Description : This function is to select image in 'Split Merge and Move Wizard' page.
	* Date 		  : 17-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients selImageInSplitMergeMoveWizard() throws Exception {
		objWaitForElement.waitForElements(selImageChkbx, "xpath");
			this.page.element(selImageChkbx, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On 'Delete Selected' button in 'Split Merge and Move Wizard' page.
	* Date 		  : 17-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnDeleteSelectedInSplitMergeMoveWizard() throws Exception {
		objWaitForElement.waitForElements(delSelected, "id");
		this.page.element(delSelected, "id").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On 'Yes' button in 'Split Merge and Move Wizard' page.
	* Date 		  : 17-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnYesInSplitMergeMoveWizard() throws Exception {
		objWaitForElement.waitForElements(yesInSplitMoveWizard, "id");
		this.page.element(yesInSplitMoveWizard, "id").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On 'Done' button in 'Split Merge and Move Wizard' page.
	* Date 		  : 17-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnDoneInSplitMergeMoveWizard() throws Exception {
		objWaitForElement.waitForElements(doneInSplitMoveWizard, "name");
		this.page.element(doneInSplitMoveWizard, "name").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On 'copy' button in 'Split Merge and Move Wizard' page.
	* Date 		  : 17-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnCopyInSplitMergeMoveWizard() throws Exception {
		objWaitForElement.waitForElements(copyInSplitMoveWizard, "id");
		this.page.element(copyInSplitMoveWizard, "id").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select 'Release new study from QC sandbox' check box.
	  * Date        : 17-Nov-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public ViewPatients selReleaseNewStudyFromQCSandboxCheckBox() throws Exception {
		objWaitForElement.waitForElements(releaseNewStudyFromQCSandbox, "id");
		this.page.element(releaseNewStudyFromQCSandbox, "id").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify copy of a study is not displayed.
	* Date 		  : 17-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verCopyOfAStudyNotDisplayed(String study) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		assertFalse(this.page.element("(//a[contains(text(),'"+study+"')])[2]", "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to get the count of images of a second study.
	* Date 		  : 17-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public String getCountOfImagesOfSecondStudy(String stdy) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements("//th[5][text()='Imgs']/../following-sibling::tr[@id='str2']//a[contains(text(),'"+stdy+"')]/../../td[5]", "xpath");
		String str = this.page.element("//th[5][text()='Imgs']/../following-sibling::tr[@id='str2']//a[contains(text(),'"+stdy+"')]/../../td[5]", "xpath").getOne().getText();
		return str;
	}
	
	/**********************************************************************************
	* Description : This function is to verify copy of a study is not displayed.
	* Date 		  : 17-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verStudyAndCopyOfAStudyIsDisplayed(String study,String strid) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		assertTrue(this.page.element("(//a[contains(text(),'"+study+"')])[1]/../..//td[3][contains(text(),'"+strid+"')]", "xpath").isElementPresent());
		assertTrue(this.page.element("(//a[contains(text(),'"+study+"')])[1]/../..//td[3][contains(text(),'"+strid+"')]", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to get id of a particular study.
	* Date 		  : 18-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public String getIdOfParticularStudy(String study) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		assertTrue(this.page.element("//a[contains(text(),'"+study+"')]", "xpath").isElementPresent());
		objWaitForElement.waitForElements("//a[contains(text(),'"+study+"')]/../..//td[3]", "xpath");
		 String str = this.page.element("//a[contains(text(),'"+study+"')]/../..//td[3]", "xpath").getOne().getText();
		 System.out.println(str);
		return str;
		
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Individual images in this study' radio button.
	* Date 		  : 18-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients selIndividualImagesInThisStudyRadioButton() throws Exception {
		objWaitForElement.waitForElements(individualImages, "xpath");
		if(this.page.element(individualImages, "xpath").getOne().isSelected()==false){
			this.page.element(individualImages, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select image in 'Split Merge and Move Wizard' page For 
	*               Individual Images RadioButton.
	* Date 		  : 18-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients selImageInSplitMergeMoveWizardForIndividualImagesRadioButton() throws Exception {
		objWaitForElement.waitForElements(selImageChkbx1, "xpath");
			this.page.element(selImageChkbx1, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify non qc study is displayed.
	* Date 		  : 18-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verNonQCStudyIsDisplayed(String study) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		assertFalse(this.page.element("(//a[contains(text(),'"+study+" ')])[1]/../..//img[@src='gifs.new/qc_release.gif']", "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify non qc study is displayed.
	* Date 		  : 18-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verNonQCStudyIsDisplayed1(String study) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		assertFalse(this.page.element("(//a[contains(text(),'"+study+" ')])[2]/../..//img[@src='gifs.new/qc_release.gif']", "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On 'existing study' button in 'Split Merge and Move Wizard' page.
	* Date 		  : 24-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnExistingStudyInSplitMergeMoveWizard() throws Exception {
		objWaitForElement.waitForElements(existingStudy, "id");
		this.page.element(existingStudy, "id").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select Search For option In Split,Merge,Move Wizard window.
     * Date        : 24-Nov-2015
     * Author      : Hanumegowda
     **********************************************************************************/
	public ViewPatients selSearchForOptionInSplitMergeMoveWizard(String option)
			throws Exception {
		objWaitForElement.waitForElements(searchForOption, "name");
		this.page.element(searchForOption, "name").webElementToSelect()
				.selectByVisibleText(option);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter text in Search For option In Split,Merge,Move Wizard window.
     * Date        : 24-Nov-2015
     * Author      : Hanumegowda
     **********************************************************************************/
	public ViewPatients enterSearchForOptionFieldInSplitMergeMoveWizard(String strStudy)
			throws Exception {
		objWaitForElement.waitForElements(searchForOptionTextField, "xpath");
		this.page.element(searchForOptionTextField, "xpath").clearInputValue().sendKeys(strStudy);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on go In Split,Merge,Move Wizard window.
     * Date        : 24-Nov-2015
     * Author      : Hanumegowda
     **********************************************************************************/
	public ViewPatients clickOnGoInSplitMergeMoveWizard()
			throws Exception {
		objWaitForElement.waitForElements(go, "xpath");
		this.page.element(go, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select study In Split,Merge,Move Wizard window.
     * Date        : 24-Nov-2015
     * Author      : Hanumegowda
     **********************************************************************************/
	public ViewPatients selStudyInSplitMergeMoveWizard()
			throws Exception {
		objWaitForElement.waitForElements(selStudyRadioBtn, "xpath");
		if(this.page.element(selStudyRadioBtn, "xpath").getOne().isSelected()==false){
			this.page.element(selStudyRadioBtn, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Copy selected series where' page is displayed.
	* Date 		  : 25-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verCopySelectedSeriesWherePageIsDisplayed() throws Exception {
		objWaitForElement.waitForElements(copySelectedSeriesWhere, "xpath");
		assertTrue(this.page.element(copySelectedSeriesWhere, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on Click Here To Send Selected Studies Icon(batch of studies).
	  * Date        : 27-Nov-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public ViewPatients clickOnClickHereToSendSelectedStudiesIcon() throws Exception {
		objWaitForElement.waitForElements(sendSelectedStudies, "xpath");
		this.page.element(sendSelectedStudies, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On 'Click here to merge reports for selected 
	*               studies' icon.
	* Date 		  : 01-Dec-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnMergeReportsIcon() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(mergeReports, "xpath");
		this.page.element(mergeReports, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select study in 'merge reports page'.
	* Date 		  : 01-Dec-2015
	* Author 	  : Hanumegowda
	 * @return 
	**********************************************************************************/
	public ViewPatients selStudyInMergeReportsPage(String strstudy) throws Exception {
		String xp = "//td[contains(text(),'" + strstudy
				+ "')]/..//input[@type='RADIO']";
		objWaitForElement.waitForElements(xp, "xpath");
		if (this.page.element(xp, "xpath").getOne().isSelected() == false) {
			this.page.element(xp, "xpath").getOne().click();

		}
		return this;

	}
	
	/**********************************************************************************
	* Description : This function is to select 'Move reports' raadio button in merge reports radio button.
	* Date 		  : 01-Dec-2015
	* Author 	  : Hanumegowda
	 * @return 
	**********************************************************************************/
	public ViewPatients selMoveReportsRadioButtonInMergeReportsPage() throws Exception {
		objWaitForElement.waitForElements(moveReports, "xpath");
		if (this.page.element(moveReports, "xpath").getOne().isSelected() == false) {
			this.page.element(moveReports, "xpath").getOne().click();

		}
		return this;

	}
	
	/**********************************************************************************
	* Description : This function is to click on yes button in merge reports radio button.
	* Date 		  : 01-Dec-2015
	* Author 	  : Hanumegowda
	 * @return 
	**********************************************************************************/
	public ViewPatients clickOnYesInMergeReportsPage() throws Exception {
		objWaitForElement.waitForElements(yes, "xpath");
			this.page.element(yes, "xpath").getOne().click();
		return this;

	}
	
	/**********************************************************************************
	* Description : This function is to click on close button in merge reports radio button.
	* Date 		  : 01-Dec-2015
	* Author 	  : Hanumegowda
	 * @return 
	**********************************************************************************/
	public ViewPatients clickOnCloseInMergeReportsPage() throws Exception {
		objWaitForElement.waitForElements(close1, "xpath");
			this.page.element(close1, "xpath").getOne().click();
		return this;

	}
	
	/**********************************************************************************
	* Description : This function is to verify second saved report is displayed.
	* Date 		  : 01-Dec-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verSecondSavedReportIsDisplayed() throws Exception {
		objWaitForElement.waitForElements("(//a[contains(text(),'- a admin:')])[2]", "xpath");
		assertTrue(this.page.element("(//a[contains(text(),'- a admin:')])[2]", "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Copy reports' raadio button in merge reports radio button.
	* Date 		  : 02-Dec-2015
	* Author 	  : Hanumegowda
	 * @return 
	**********************************************************************************/
	public ViewPatients selCopyReportsRadioButtonInMergeReportsPage() throws Exception {
		objWaitForElement.waitForElements(copyReports, "xpath");
		if (this.page.element(copyReports, "xpath").getOne().isSelected() == false) {
			this.page.element(copyReports, "xpath").getOne().click();

		}
		return this;

	}
	
  /**********************************************************************************
   * Description : This function is to click on template editor icon.
   * Date        : 03-Dec-2015
   * Author      : Hanumegowda
   **********************************************************************************/
	public ViewPatients clickOnTemplateEditorIcon() throws Exception {
		objWaitForElement.waitForElements(templateEditor, "id");
		this.page.element(templateEditor, "id").mouseOver();
		this.page.element(templateEditor, "id").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on clear document icon.
     * Date        : 03-Dec-2015
     * Author      : Hanumegowda
     **********************************************************************************/
	public ViewPatients clickOnClearDocumentIcon() throws Exception {
		objWaitForElement.waitForElements(clearDocument, "id");
		this.page.element(clearDocument, "id").mouseOver();
		this.page.element(clearDocument, "id").getOne().click();
		return this;
	}

    /**********************************************************************************
     * Description : This function is to enter text in template editor page.
     * Date        : 03-Dec-2015
     * Author      : Hanumegowda
     **********************************************************************************/
	public ViewPatients enterTextInTemplateEditorPage(String text)
			throws Exception {
		objWaitForElement.waitForElements("oDiv", "id");
		this.page.element("oDiv", "id").getOne().sendKeys(text);
		return this;
	}
	
	 /**********************************************************************************
     * Description : This function is to enter text in template editor page.
     * Date        : 03-Dec-2015
     * Author      : Hanumegowda
     **********************************************************************************/
	public ViewPatients enterTextInReportEditorPage(String text)
			throws Exception {
		String str = "//p/strong[contains(text(),'History')]";
		String str2 = "//td/strong[contains(text(),'Exam Type:')]/..//following-sibling::td";
		String str3 = "//td[@valign='top']/strong[contains(text(),'History')]";
		
		objWaitForElement.waitForElements(str2, "xpath");
		this.page.element(str2, "xpath").getOne().click();
		this.page.element(str2, "xpath").getOne().sendKeys(Keys.ENTER);
		this.page.element(str2, "xpath").getOne().sendKeys(Keys.ENTER);
		this.page.element(str2, "xpath").getOne().sendKeys(Keys.ENTER);
		this.page.element(str2, "xpath").getOne().sendKeys(text);
		return this;
	}
	
	 /**********************************************************************************
     * Description : This function is to enter text in template editor page.
     * Date        : 03-Dec-2015
     * Author      : Hanumegowda
     **********************************************************************************/
	public ViewPatients enterTextInReportEditorPage1(String text)
			throws Exception {
		String str4 = "//td/strong[contains(text(),'Reason for Visit:')]/..//following-sibling::td";		
		objWaitForElement.waitForElements(str4, "xpath");
		this.page.element(str4, "xpath").getOne().click();
		this.page.element(str4, "xpath").getOne().sendKeys(Keys.ENTER);
		this.page.element(str4, "xpath").getOne().sendKeys(Keys.ENTER);
		this.page.element(str4, "xpath").getOne().sendKeys(Keys.ENTER);
		this.page.element(str4, "xpath").getOne().sendKeys(text);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on add template icon.
     * Date        : 03-Dec-2015
     * Author      : Hanumegowda
     **********************************************************************************/
	public ViewPatients clickOnAddTemplateIcon() throws Exception {
		objWaitForElement.waitForElements(addTemplate, "id");
		this.page.element(addTemplate, "id").mouseOver();
		this.page.element(addTemplate, "id").getOne().click();
		return this;
	}
	
	/**********************************************************************************
     * Description : This function is to enter text in 'template name, text field in add template page.
     * Date        : 03-Dec-2015
     * Author      : Hanumegowda
     **********************************************************************************/
	public ViewPatients enterTextInTemplateNameTextField(String template)
			throws Exception {
		objWaitForElement.waitForElements(templateName, "xpath");
		this.page.element(templateName, "xpath").clearInputValue().sendKeys(template);
		return this;
	}
	
	/**********************************************************************************
     * Description : This function is to select template type in add template page.
     * Date        : 03-Dec-2015
     * Author      : Hanumegowda
     **********************************************************************************/
	public ViewPatients selTemplateType(String templatetype)
			throws Exception {
		try{
		objWaitForElement.waitForElements(selTemplateType, "xpath");
		this.page.element(selTemplateType, "xpath").webElementToSelect().selectByVisibleText(templatetype);
		}
		catch(NoSuchElementException e){
			objWaitForElement.waitForElements(selTemplateType, "xpath");
			this.page.element(selTemplateType, "xpath").webElementToSelect().selectByIndex(1);
		}
		return this;
	}
	
	/**********************************************************************************
     * Description : This function is to select template package in add template page.
     * Date        : 03-Dec-2015
     * Author      : Hanumegowda
     **********************************************************************************/
	public ViewPatients selTemplatePackage(String templatepackage)
			throws Exception {
		objWaitForElement.waitForElements(selTemplatePackage, "xpath");
		this.page.element(selTemplatePackage, "xpath").webElementToSelect().selectByVisibleText(templatepackage);
		return this;
	}
	
	/**********************************************************************************
     * Description : This function is to select field in add template page.
     * Date        : 03-Dec-2015
     * Author      : Hanumegowda
     **********************************************************************************/
	public ViewPatients selTemplateField(String templatefield)
			throws Exception {
		objWaitForElement.waitForElements(selTemplateField, "xpath");
		this.page.element(selTemplateField, "xpath").webElementToSelect().selectByVisibleText(templatefield);
		return this;
	}
	
	/**********************************************************************************
     * Description : This function is to enter text in match text field in add template page.
     * Date        : 03-Dec-2015
     * Author      : Hanumegowda
     **********************************************************************************/
	public ViewPatients enterTextInMatchTextField()
			throws Exception {
		objWaitForElement.waitForElements(templatematch, "xpath");
		this.page.element(templatematch, "xpath").clearInputValue().sendKeys("*");
		return this;
	}
	
	/**********************************************************************************
     * Description : This function is to click on 'save changes' in add template page.
     * Date        : 03-Dec-2015
     * Author      : Hanumegowda
     **********************************************************************************/
	public ViewPatients clickOnSaveChangesInAddTemplatePage()
			throws Exception {
		objWaitForElement.waitForElements(saveChanges, "xpath");
		this.page.element(saveChanges, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
     * Description : This function is to select template from drop down in edit template page.
     * Date        : 03-Dec-2015
     * Author      : Hanumegowda
     **********************************************************************************/
	public ViewPatients selTemplateFromDropdown(String template)
			throws Exception {
		/*objWaitForElement.waitForElements(selTemplate, "id");
		this.page.element(selTemplate, "id").webElementToSelect().selectByVisibleText(template);*/
		objWaitForElement.waitForElements("//select[@name='TemplateList'][@id='oTemplateList']", "xpath");
		this.page.element("//select[@name='TemplateList'][@id='oTemplateList']", "xpath").webElementToSelect().selectByVisibleText(template);
		return this;
	}
	
	/**********************************************************************************
     * Description : This function is to select template from drop down in edit template page.
     * Date        : 03-Dec-2015
     * Author      : Hanumegowda
     **********************************************************************************/
	public ViewPatients selTemplateFromDropdown1(String template)
			throws Exception {
		String str = "//option[contains(text(),'"+template+"')]";
		objWaitForElement.waitForElements(selTemplate, "id");
		this.page.element(selTemplate, "id").getOne().click();
		this.page.element(str, "xpath").doubleClick();
		return this;
	}
	
	/**********************************************************************************
     * Description : This function is to verify selected template is displayed in edit template page.
     * Date        : 03-Dec-2015
     * Author      : Hanumegowda
     **********************************************************************************/
	public ViewPatients verSelectedTemplateDisplayed(String template)
			throws Exception {
		objWaitForElement.waitForElements("//div[contains(text(),'"+template+"')]", "xpath");
		String str = this.page.element("oDiv", "id").getOne().getText();
		System.out.println(str);
		assertTrue(str.contains(template));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Substitution Fields Management' icon.
	 * Date        : 04-Dec-2015
	 * Author      : Hanumegowda
	 **********************************************************************************/
		public ViewPatients clickOnSubstitutionFieldsManagementIcon() throws Exception {
			objWaitForElement.waitForElements(substitutionFieldsManagement, "id");
			this.page.element(substitutionFieldsManagement, "id").mouseOver();
			this.page.element(substitutionFieldsManagement, "id").getOne().click();
			return this;
		}
		
		
	/**********************************************************************************
     * Description : This function is to select smart tags radio button.
	 * Date        : 04-Dec-2015
	 * Author      : Hanumegowda
   	 **********************************************************************************/
	public ViewPatients selSmartTagRadioButton() throws Exception {
		objWaitForElement.waitForElements(smartTags, "id");
		if (this.page.element(smartTags, "id").getOne().isSelected() == false) {
			this.page.element(smartTags, "id").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
     * Description : This function is to enter text in 'Tag' text field.
     * Date        : 04-Dec-2015
     * Author      : Hanumegowda
     **********************************************************************************/
	public ViewPatients enterTextInTagField(String text)
			throws Exception {
		objWaitForElement.waitForElements(tagField, "id");
		this.page.element(tagField, "id").mouseOver();
		this.page.element(tagField, "id").getOne().sendKeys(text);
		return this;
	}
	
	/**********************************************************************************
     * Description : This function is to enter text in 'Personal Phrase' text field.
     * Date        : 04-Dec-2015
     * Author      : Hanumegowda
     **********************************************************************************/
	public ViewPatients enterTextInPersonalPhraseField(String text)
			throws Exception {
		objWaitForElement.waitForElements(personalPhraseField, "id");
		this.page.element(personalPhraseField, "id").getOne().sendKeys(text);
		return this;
	}
	
	/**********************************************************************************
     * Description : This function is to move the cursor onto tagname link.
     * Date        : 04-Dec-2015
     * Author      : Hanumegowda
     **********************************************************************************/
	public ViewPatients moveCursorOntoTagName(String reqtext)
			throws Exception {
		objWaitForElement.waitForElements("//a[text()='"+reqtext+"']", "xpath");
		this.page.element("//a[text()='"+reqtext+"']", "xpath").mouseOver();
		return this;
	}
	
	/**********************************************************************************
     * Description : This function is to select tagname from tool tip.
     * Date        : 04-Dec-2015
     * Author      : Hanumegowda
     **********************************************************************************/
	public ViewPatients selTagNameFromToolTip(String tagname)
			throws Exception {
		objWaitForElement.waitForElements("//a[text()='"+tagname+"']", "xpath");
		/*this.page.element("//a[text()='"+tagname+"']", "xpath").mouseOver();
		Thread.sleep(5000);*/
		this.page.element("//a[text()='"+tagname+"']", "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
     * Description : This function is to verify the value of tagname is displayed in report editor page.
     * Date        : 04-Dec-2015
     * Author      : Hanumegowda
     **********************************************************************************/
	public ViewPatients verValueOfTagNameIsDisplayed(String tagvalue)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToIFrame();
		String str1 = "//p[contains(text(),'"+tagvalue+"')]";
		objWaitForElement.waitForElements(str1, "xpath");
		assertTrue(this.page.element(str1, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
     * Description : This function is to verify the tagname is displayed in tool tip.
     * Date        : 04-Dec-2015
     * Author      : Hanumegowda
     **********************************************************************************/
	public ViewPatients verTagNameIsPresentInToolTip(String tagname)
			throws Exception {
		objWaitForElement.waitForElements("//td/a[text()='"+tagname+"']", "xpath");
		assertTrue(this.page.element("//td/a[text()='"+tagname+"']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On Upload template icon in template editor page.
	* Date 		  : 08-Dec-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnUploadTemplateIcon(String filepath) throws Exception {
		objWaitForElement.waitForElements(uploadTemplate, "id");
		this.page.element(uploadTemplate, "id").mouseOver();
		this.page.element(uploadTemplate, "id").doubleClick();
		this.page.element(uploadTemplate, "id").getOne().sendKeys(filepath);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On Download template icon in template editor page.
	* Date 		  : 08-Dec-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnDownloadTemplateIcon() throws Exception {
		objWaitForElement.waitForElements(downloadTemplate, "id");
		this.page.element(downloadTemplate, "id").mouseOver();
		this.page.element(downloadTemplate, "id").doubleClick();
		System.out.println(" click dowload is completed");
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On Delete template icon in template editor page.
	* Date 		  : 08-Dec-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnDeleteTemplateIcon() throws Exception {
		objWaitForElement.waitForElements(deleteTemplate, "id");
		this.page.element(deleteTemplate, "id").getOne().click();
		return this;
	}
	
	/**********************************************************************************
     * Description : This function is to verify template is not present in template drop down.
     * Date        : 08-Dec-2015
     * Author      : Hanumegowda
     **********************************************************************************/
	public ViewPatients verTemplateNotPresentInDropdown(String template)
			throws Exception {
		objWaitForElement.waitForElements(selTemplate, "id");
		List<WebElement> ele = this.page.element(selTemplate, "id").webElementToSelect().getOptions();
		System.out.println(ele.size()+" no of options");
		for(WebElement opt : ele){
			assertFalse(opt.equals(template));
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On Upload button in template editor page.
	* Date 		  : 08-Dec-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnUploadInTemplateEditor() throws Exception {
		objWaitForElement.waitForElements(uploadButtonInTemplateEditor, "xpath");
		this.page.element(uploadButtonInTemplateEditor, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on advanced button.
	  * Date        : 09-Dec-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public ViewPatients clickOnAdvanced() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(advanced, "xpath");
		this.page.element(advanced, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on flip link.
	  * Date        : 09-Dec-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public ViewPatients clickOnFlip() throws Exception {
		objFrames.switchToDefaultFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(flip, "xpath");
		this.page.element(flip, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select required modality checkbox.
	  * Date        : 09-Dec-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public ViewPatients selReqModalityCheckbox(String strmodality) throws Exception {
		objFrames.switchToDefaultFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements("//form[@name='thesearch']//input[@type='checkbox'][@name='adv_mod_"+strmodality+"']", "xpath");
		if((this.page.element("//input[@type='checkbox'][@name='adv_mod_"+strmodality+"']", "xpath")).getOne().isSelected()==false){
			this.page.element("//input[@type='checkbox'][@name='adv_mod_"+strmodality+"']", "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter the text in 'type' text field in advanced search page.
	  * Date        : 09-Dec-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public ViewPatients enterTextInTypeField(String des) throws Exception {
		objFrames.switchToDefaultFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(type, "xpath");
		this.page.element(type, "xpath").clearInputValue().sendKeys(des);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter the text in 'Ref. Physician' text field in advanced search page.
	  * Date        : 09-Dec-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public ViewPatients enterTextInRefPhysicianField(String refphy) throws Exception {
		objFrames.switchToDefaultFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(refPhysician, "xpath");
		this.page.element(refPhysician, "xpath").clearInputValue().sendKeys(refphy);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter the text in 'station' text field in advanced search page.
	  * Date        : 09-Dec-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public ViewPatients enterTextInStationField(String strstation) throws Exception {
		objFrames.switchToDefaultFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(station, "xpath");
		this.page.element(station, "xpath").clearInputValue().sendKeys(strstation);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter the text in 'Institution' text field in advanced search page.
	  * Date        : 09-Dec-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public ViewPatients enterTextInInstitutionTextField(String strinst) throws Exception {
		objFrames.switchToDefaultFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(instName, "xpath");
		this.page.element(instName, "xpath").clearInputValue().sendKeys(strinst);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter the text in 'Institution' text field in advanced search page.
	  * Date        : 09-Dec-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public ViewPatients enterTextInStationTextField(String strstation) throws Exception {
		objFrames.switchToDefaultFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(stationInAdvancedSearch, "xpath");
		this.page.element(stationInAdvancedSearch, "xpath").clearInputValue().sendKeys(strstation);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter the text in 'Name' text field in advanced search page.
	  * Date        : 09-Dec-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public ViewPatients enterTextInNameTextField(String strstudyname) throws Exception {
		objFrames.switchToDefaultFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(studyName, "xpath");
		this.page.element(studyName, "xpath").clearInputValue().sendKeys(strstudyname);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter the text in 'Id' text field in advanced search page.
	  * Date        : 09-Dec-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public ViewPatients enterTextInIdTextField(String strstudyid) throws Exception {
		objFrames.switchToDefaultFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(studyId, "xpath");
		this.page.element(studyId, "xpath").clearInputValue().sendKeys(strstudyid);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter the text in 'Birth Date' text field in advanced search page.
	  * Date        : 09-Dec-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public ViewPatients enterTextInBirthDateTextField(String strdob) throws Exception {
		objFrames.switchToDefaultFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(birthDate, "xpath");
		this.page.element(birthDate, "xpath").clearInputValue().sendKeys(strdob);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select sex in advanced search page.
	  * Date        : 09-Dec-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public ViewPatients selSex(String strsex) throws Exception {
		objFrames.switchToDefaultFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(sex, "xpath");
		this.page.element(sex, "xpath").webElementToSelect().selectByVisibleText(strsex);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select status in advanced search page.
	  * Date        : 09-Dec-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public ViewPatients selStatus(String strstatus) throws Exception {
		objFrames.switchToDefaultFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(statusInAdvancedSearch, "xpath");
		this.page.element(statusInAdvancedSearch, "xpath").webElementToSelect().selectByVisibleText(strstatus);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on search button in in advanced search page.
	  * Date        : 09-Dec-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public ViewPatients clickOnSearchInAdvancedSearch() throws Exception {
		objFrames.switchToDefaultFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(advancedSearch, "xpath");
		this.page.element(advancedSearch, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify study in advanced search page.
	  * Date        : 09-Dec-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public ViewPatients verStudyInAdvancedSearch(String study) throws Exception {
		objFrames.switchToDefaultFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements("//form[@name='theform']//b[contains(text(),'"+study+"')]/../a/img[@src='gifs.new/blue.gif']", "xpath");
		assertTrue(this.page.element("//form[@name='theform']//b[contains(text(),'"+study+"')]/../a/img[@src='gifs.new/blue.gif']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to get station name of the study.
	* Date 		  : 14-Dec-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public String getStationNameOfAStudy() throws Exception {
		objWaitForElement.waitForElements(stationName, "xpath");
		String str = this.page.element(stationName, "xpath").getOne().getText();
		System.out.println(str+" station");
		return str;
	}
	
	/**********************************************************************************
	* Description : This function is to verify default web report of a study is displayed.
	* Date 		  : 21-Mar-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verDefaultReportOfStudy(String struser) throws Exception {
		String str = "//a[contains(text(),'DEMOGRAPHICS:  Patient Information')]/../../..//td[text()='"+struser+"']";
		String str1 = "//a[contains(text(),'DEMOGRAPHICS:  Patient Information')]";
		objWaitForElement.waitForElements(str1, "xpath");
		System.out.println(str1);
		assertTrue(this.page.element(str1, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click On browse in upload file window.
	  * Date        : 18-Apr-2016
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public ViewPatients clickOnBrowse(String path) throws Exception {
		objWaitForElement.waitForElements(browseUp, "xpath");
		this.page.element(browseUp, "xpath").getOne()
		.sendKeys(path);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select destination server in Send report to the Medweb server page.
	* Date 		  : 18-May-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients selDestination(String device) throws Exception {
		objWaitForElement.waitForElements(destination, "xpath");
			this.page.element(destination, "xpath").webElementToSelect().selectByVisibleText(device);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On 'Release study from QC' icon.
	* Date 		  : 20-May-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnReleaseStudyFromQc() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(releaseStudyFromQc, "xpath");
		this.page.element(releaseStudyFromQc, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On ok button in 'Release study from QC' window.
	* Date 		  : 20-May-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnOkInReleaseStudyFromQcWindow() throws Exception {
		objWaitForElement.waitForElements(okInReleaseStudy, "xpath");
		Thread.sleep(3000);
		this.page.element(okInReleaseStudy, "xpath").getOne();
		this.page.element(okInReleaseStudy, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On 'save template' icon in template editor page.
	* Date 		  : 31-May-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnSaveTemplate() throws Exception {
		objWaitForElement.waitForElements(saveTemplate, "id");
		this.page.element(saveTemplate, "id").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify alert message.
	* Date 		  : 31-May-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verAlertMessage(String msg) throws Exception {
	Alert alert = driver.switchTo().alert();
	String str = alert.getText();
	System.out.println(str+" actual");
	System.out.println(msg+ " required");
	assertTrue(str.contains(msg));
	alert.accept();
		return this;
	}
	
	/**********************************************************************************
     * Description : This function is to select template subtype in Template properties page.
     * Date        : 01-Jun-2016
     * Author      : Hanumegowda
     **********************************************************************************/
	public ViewPatients selTemplateSubType(String templatetype)
			throws Exception {
		try{
		objWaitForElement.waitForElements(selTemplateSubType, "xpath");
		this.page.element(selTemplateSubType, "xpath").webElementToSelect().selectByVisibleText(templatetype);
		}
		catch(NoSuchElementException e){
			objWaitForElement.waitForElements(selTemplateSubType, "xpath");
			this.page.element(selTemplateSubType, "xpath").webElementToSelect().selectByIndex(1);
		}
		return this;
	}
	
	/**********************************************************************************
     * Description : This function is to select owner in Template properties page.
     * Date        : 01-Jun-2016
     * Author      : Hanumegowda
     **********************************************************************************/
	public ViewPatients selOwner(String owner)
			throws Exception {
		objWaitForElement.waitForElements(ownerDropdown, "xpath");
		this.page.element(ownerDropdown, "xpath").webElementToSelect().selectByValue(owner);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on ACL link in Template properties page.
	  * Date        : 01-Jun-2016
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public ViewPatients clickOnAclLink() throws Exception {
		objWaitForElement.waitForElements(aclLink, "xpath");
		this.page.element(aclLink, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select private radio button in Select ACL page.
	  * Date        : 01-Jun-2016
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public ViewPatients selPrivateRadioButton() throws Exception {
		objWaitForElement.waitForElements(privateRadBtn, "id");
		if((this.page.element(privateRadBtn, "id")).getOne().isSelected()==false){
		this.page.element(privateRadBtn, "id").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On Delete template field in Template properties page.
	* Date 		  : 01-Jun-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnDeleteTemplateField() throws Exception {
		objWaitForElement.waitForElements(deleteTemplateField, "xpath");
		this.page.element(deleteTemplateField, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select shared radio button in Select ACL page.
	 * Date        : 02-Jun-2016
     * Author      : Hanumegowda
     **********************************************************************************/
	public ViewPatients selSharedRadioButton() throws Exception {
		objWaitForElement.waitForElements(sharedRadBtn, "id");
		if ((this.page.element(sharedRadBtn, "id")).getOne().isSelected() == false) {
			this.page.element(sharedRadBtn, "id").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select Radiologist Checkbox in Select ACL page.
	 * Date        : 02-Jun-2016
     * Author      : Hanumegowda
     **********************************************************************************/
	public ViewPatients selOphthalmologistCheckBox() throws Exception {
		objWaitForElement.waitForElements(radiologistChkBox, "xpath");
		if ((this.page.element(radiologistChkBox, "xpath")).getOne().isSelected() == false) {
			this.page.element(radiologistChkBox, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on template properties icon in template editor page.
     * Date        : 02-Jun-2016
     * Author      : Hanumegowda
     **********************************************************************************/
	public ViewPatients clickOnTemplatePropertiesIcon() throws Exception {
		objWaitForElement.waitForElements(templateProperties, "id");
		this.page.element(templateProperties, "id").mouseOver();
		this.page.element(templateProperties, "id").getOne().click();
		return this;
	}
		
	/**********************************************************************************
     * Description : This function is to verify 'Save changes' button is not displaying in
	 *               Template properties page.
     * Date        : 02-Jun-2015
     * Author      : Hanumegowda
     **********************************************************************************/
	public ViewPatients verSaveChangesNotDisplayed() throws Exception {
		// objFrames.switchToDefaultFrame().switchToFRMFrame();
		//objWaitForElement.waitForElements(saveChanges, "xpath");
		assertFalse((this.page.element(saveChanges, "xpath"))
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE1));
		return this;
	}
		
	/**********************************************************************************
     * Description : This function is to verify cannot modify template error message is not displaying in
     *               Template properties page.
     * Date        : 02-Jun-2015
     * Author      : Hanumegowda
     **********************************************************************************/
	public ViewPatients verCannotModifyTemplateErrorMsg(String errmsg)
			throws Exception {
		String rt = this.page.element("//form[@name='FRM']//center", "xpath")
				.getOne().getText();
		System.out.println(rt + "  rrrqqtt");
		assertTrue(rt.contains(errmsg));
		return this;
	}

	/**********************************************************************************
     * Description : This function is to select 'Nominate' in Template properties  page.
     * Date        : 02-Jun-2016
     * Author      : Hanumegowda
     **********************************************************************************/
	public ViewPatients selNominateCheckBox() throws Exception {
		objWaitForElement.waitForElements(nominateChkBx, "xpath");
		if (this.page.element(nominateChkBx, "xpath").getOne().isSelected() == false) {
			this.page.element(nominateChkBx, "xpath").getOne().click();
		}
		return this;
	}
		
	/**********************************************************************************
     * Description : This function is to click on study.
     * Date        : 02-Jun-2016
	 * Author      : Hanumegowda
     **********************************************************************************/
	public ViewPatients clickOnStudy(String study) throws Exception {
		String str = "//a[contains(text(),'" + study.toUpperCase() + "')]";
		objWaitForElement.waitForElements(str, "xpath");
		this.page.element(str, "xpath").clickUjse();
		Thread.sleep(WaitTimeConstants.WAIT_TIME_SMALL);
		Capabilities cap = ((RemoteWebDriver) this.driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName + " this is the current browser");
		if ((browserName).equalsIgnoreCase("chrome")) {
			System.out.println(browserName + " this is the current browser");
			Robot rr = new Robot();
			rr.keyPress(KeyEvent.VK_LEFT);
			rr.keyRelease(KeyEvent.VK_LEFT);
			rr.delay(3000);
			rr.keyPress(KeyEvent.VK_ENTER);
			rr.keyRelease(KeyEvent.VK_ENTER);
		}
		return this;
	}
		
	/**********************************************************************************
	 * Description : This function is to click on 'Add' icon in Editor properties page.
	 * Date        : 22-Jun-2016
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public ViewPatients clickOnAddIconInEditorPropertiesPage() throws Exception {
		objFrames.switchToDefaultFrame().switchToIFrame("oFrame1");
		objWaitForElement
				.waitForElements(
						"//img[@src='/wavelet/mini-ris/html_editor/images/smallest_plus_but.gif']",
						"xpath");
		this.page
				.element(
						"//img[@src='/wavelet/mini-ris/html_editor/images/smallest_plus_but.gif']",
						"xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify 'Release study from QC' green arrow icon is diaplaying.
	 * Date 	   : 04-Jul-2016
	 * Author 	   : Hanumegowda
	 **********************************************************************************/
	public ViewPatients verReleaseStudyFromQCGreenArrowIconIsDisplayed(
			String study) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		String str = "(//a[contains(text(),'" + study
				+ "')]/ancestor::tr//img[@src='gifs.new/qc_release.gif'])[1]";
		objWaitForElement.waitForElements(str, "xpath");
		assertTrue(this.page.element(str, "xpath").isElementPresent());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify 'New Study' link is displayed.
	 * Date 	   : 05-Jul-2016
	 * Author 	   : Hanumegowda
	 **********************************************************************************/
	public ViewPatients verNewStudyLinkIsDisplayed() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(newLink, "xpath");
		assertTrue(this.page.element(newLink, "xpath").isElementPresent());
		return this;
	}
		
	/**********************************************************************************
	 * Description : This function is to verify a study column headers is displayed.
	 * Date 	   : 05-Jul-2016
	 * Author 	   : Hanumegowda
	 **********************************************************************************/
	public ViewPatients verAStudyColumnHeadersIsDisplayed() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(studyColumnHeaders, "xpath");
		assertTrue(this.page.element(studyColumnHeaders, "xpath")
				.isElementPresent());
		return this;
	}
		
	/**********************************************************************************
	 * Description : This function is to click on 'Edit DICOM...' button in 'Step 2: Select one 
	 *               or more series to manipulate'.
	 * Date 	   : 07-Jul-2016
	 * Author 	   : Hanumegowda
	 **********************************************************************************/
	public ViewPatients clickOnEditDicom() throws Exception {
		objWaitForElement.waitForElements(editDicom, "xpath");
		this.page.element(editDicom, "xpath").getOne().click();
		return this;
	}
		
	/**********************************************************************************
	 * Description : This function is to enter text in 'ID Modality' text field in dicom edit page.
	 * Date 	   : 07-Jul-2016
	 * Author 	   : Hanumegowda
	 **********************************************************************************/
	public ViewPatients enterTextInIdModalityField(String modality)
			throws Exception {
		objWaitForElement.waitForElements(idModalityTextField, "xpath");
		this.page.element(idModalityTextField, "xpath").clearInputValue()
				.sendKeys(modality);
		return this;
	}
		
	 /**********************************************************************************
	  * Description : This function is to verify modify Study Icon is displayed infront of study.
	  * Date 		: 08-Jul-2016
	  * Author 	    : Hanumegowda
	  **********************************************************************************/
	public ViewPatients verModifyStudyIconDisplayed(String study)
			throws Exception {
		String str = "//a[contains(text(),'"
				+ study
				+ "')]/../following-sibling::td//img[@src='gifs.new/qc_modify.gif']";
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		assertTrue(this.page.element(str, "xpath").isElementPresent());
		return this;
	}
		
	/**********************************************************************************
	 * Description : This function is to verify modify Study Icon is not displayed infront of study.
	 * Date 	   : 08-Jul-2016
	 * Author 	   : Hanumegowda
	 **********************************************************************************/
	public ViewPatients verModifyStudyIconNotDisplayed() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		assertTrue(!(this.page.element(modifyStudyIcon, "xpath")
				.isElementPresent()));
		return this;
	}
		
	/**********************************************************************************
     * Description : This function is to click on 'Click here to download selected studies 
     *               reports' Icon.
	 * Date        : 11-Jul-2016
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public ViewPatients clickOnClickHereToDownloadSelectedStudiesReportsIcon()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(
				clickHereToDownloadSelectedStudiesReportsIcon, "xpath");
		this.page
				.element(clickHereToDownloadSelectedStudiesReportsIcon, "xpath")
				.getOne().click();
		return this;
	}
		
	/**********************************************************************************
     * Description : This function is to click on 'Download reports as Zip file' button.
	 * Date        : 11-Jul-2016
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public ViewPatients clickOnDownloadReportsAsZipFileButton()
			throws Exception {
		Thread.sleep(3000);
		objWaitForElement.waitForElements(downloadReportsAsZipFile, "xpath");
		//this.page.element_wait(downloadReportsAsZipFile, "xpath").waitForElementEnable();
		this.page.element(downloadReportsAsZipFile, "xpath").doubleClick();
		Thread.sleep(5000);
		return this;
	}
		
	/**********************************************************************************
	 * Description : This function is to click On 'Update license' button.
	 * Date 	   : 12-Jul-2016
	 * Author 	   : Hanumegowda
	 **********************************************************************************/
	public ViewPatients clickOnUpdateLicense() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(updateLicense, "xpath");
		this.page.element(updateLicense, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to get days left count in add new license page.
	 * Date 	   : 12-Jul-2016
	 * Author 	   : Hanumegowda
	 **********************************************************************************/
	public String getDaysLeftCount() throws Exception {
		/*objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();*/
		objWaitForElement.waitForElements(daysLeft, "xpath");
		String str = this.page.element(daysLeft, "xpath").getOne().getText();
		System.out.println(str.trim());
		return str.trim();
	}
	
	/**********************************************************************************
	 * Description : This function is to enter text in 'enter new license' text field of add new
	 *               license page.
	 * Date 	   : 12-Jul-2016
	 * Author 	   : Hanumegowda
	 **********************************************************************************/
	public ViewPatients enterTextInEnterNewLicenseField(String lic) throws Exception {
		/*objWaitForElement.waitForElements(enterNewLicense, "xpath");
		this.page.element(enterNewLicense, "xpath").clearInputValue().sendKeys(lic);*/
		WebElement ele = this.page.element(enterNewLicense, "xpath").getOne();
		JavascriptExecutor js = ((JavascriptExecutor)this.driver);
		js.executeScript("arguments[0].value='"+lic+"';",ele);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter text in 'enter new license' text field of add new
	 *               license page.
	 * Date 	   : 12-Jul-2016
	 * Author 	   : Hanumegowda
	 **********************************************************************************/
	public ViewPatients verLicenseErrorMsg() throws Exception {
		objWaitForElement.waitForElements(licenseErrorMsg, "xpath");
		assertTrue(this.page.element(licenseErrorMsg, "xpath").isElementPresent());
		return this;
	}
	
	 /**********************************************************************************
	  * Description : This function is to verify CD Icon is displayed infront of particular study.
	  * Date 		: 13-Jul-2016
	  * Author 	    : Hanumegowda
	  **********************************************************************************/
	public ViewPatients verCDIconDisplayedInfrontOfAStudy(String study)
			throws Exception {
		String str = "//a[contains(text(),'"+study+"')]/../..//img[@src='gifs.new/cdrom.gif']";
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		System.out.println(str);
		assertTrue(this.page.element(str, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify CD Icon is displayed at bottom of view patient page.
	  * Date 		: 13-Jul-2016
	  * Author 	    : Hanumegowda
	  **********************************************************************************/
	public ViewPatients verCDIconDisplayedAtBottomOfPage()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		assertTrue(this.page.element(cdIcon, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
     * Description : This function is to verify Phrases displayed in tool tip.
     * Date        : 27-Jul-2016
     * Author      : Hanumegowda
     **********************************************************************************/
	public ViewPatients verPhrasesAreDisplayed(String tagname)
			throws Exception {
		objWaitForElement.waitForElements("//a[text()='"+tagname+"']", "xpath");
		assertTrue(this.page.element("//a[text()='"+tagname+"']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on a delete tag icon.
	* Date        : 02-Aug-2016
    * Author      : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnDelTags(String tag) throws Exception {
		String str = "//input[@value='"+tag+"']/../..//img[@src='/wavelet/mini-ris/html_editor/images/delete.gif']";
		objWaitForElement.waitForElements(str, "xpath");
		this.page.element(str, "xpath").getOne().click();
		objUserManagement.clickOnOkInAlertPopUp();
		Thread.sleep(3000);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify the green sqare box(SUCCESS,COMPLETE) is not displaying.
	* Date 		  : 05-Aug-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verGreenSqaureBoxNotDisplaying(String study) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		String str = "//a[contains(text(),'"+study+"')]/../following-sibling::td//div[@title='SUCCESS,COMPLETE']";
			assertFalse(this.page.element(
					str, "xpath")
					.isElementPresent(WaitTimeConstants.WAIT_TIME_TOO_SMALL));

		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on plus icon of 'images left to send field'.
	 * Date        : 23-Aug-2016
     * Author      : Hanumegowda
     **********************************************************************************/
	public ViewPatients clickOnImagesLeftToSendPlusIcon() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(imagesLeftToSendPlusIcon, "xpath");
		this.page.element(imagesLeftToSendPlusIcon, "xpath").getOne().click();

		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify the study in the 'Dicom spooler' window.
	 * Date        : 23-Aug-2016
     * Author      : Hanumegowda
     **********************************************************************************/
	public ViewPatients VerifyStudyInDicomSpooler(String study) throws Exception {
		String str = "//b[contains(text(),'"+study+"')]";
		objWaitForElement.waitForElements(str, "xpath");
		assertTrue(this.page.element(str, "xpath").isElementPresent());

		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on delete icon in the 'Dicom spooler' window.
	 * Date        : 23-Aug-2016
     * Author      : Hanumegowda
     **********************************************************************************/
	public ViewPatients clickOnDeleteInDicomSpooler() throws Exception {
		objWaitForElement.waitForElements(delIconInDicomSpooler, "xpath");
		this.page.element(delIconInDicomSpooler, "xpath").getOne().click();
		driver.switchTo().alert().accept();
		Thread.sleep(5000);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify the study is not displaying in the 'Dicom spooler' window.
	 * Date        : 24-Aug-2016
     * Author      : Hanumegowda
     **********************************************************************************/
	public ViewPatients VerifyStudyNotDisplayedInDicomSpooler(String study) throws Exception {
		String str = "//b[contains(text(),'"+study+"')]";
		assertFalse(this.page.element(str, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE1));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On 'red' square box of a study.
	* Date 		  : 26-Aug-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnRedSquareBoxOfAStudy(String strstudy) throws Exception {
		String str = "//a[contains(text(),'"+strstudy+"')]/../..//td//div[@title='FAIL,IN PROGRESS']";
		objWaitForElement.waitForElements(str, "xpath");
		this.page.element(str, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On 'post reply' icon.
	* Date 		  : 29-Aug-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnPostReplyIcon() throws Exception {
		objWaitForElement.waitForElements(postReplyIcon, "css");
		this.page.element(postReplyIcon, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter the text in post reply note page.
	* Date 		  : 29-Aug-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients enterTextInPostReplyPage(String postreplynote) throws Exception {
		objWaitForElement.waitForElements(postReplyPage, "id");
		WebElement ele = this.page.element(postReplyPage, "id").getOne();
		ele.clear();
		ele.sendKeys(postreplynote);
		
		//this.page.element(postReplyPage, "id").clearInputValue();
		Thread.sleep(5000);
		//this.page.element(postReplyPage, "id")
		//this.page.element(postReplyPage, "id").getOne().sendKeys(postreplynote);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On post reply note link in web reporter page.
	* Date 		  : 29-Aug-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnPostReplyNoteLink() throws Exception {	
			objWaitForElement.waitForElements(postReplyNoteLink, "xpath");
			this.page.element(postReplyNoteLink, "xpath").getOne().click();
	
		return this;
	}
	
	/**********************************************************************************
     * Description : This function is to verify post reply text is displaying after click 
     *               on post reply link.
     * Date        : 29-Aug-2016
     * Author      : Hanumegowda
     **********************************************************************************/
	public ViewPatients verPostReplyTextIsDisplayed(String postreplyTxt)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToIFrame("iFrameResizer0");
		String str = "//body[contains(text(),'"+postreplyTxt+"')]";
		System.out.println(str);
		objWaitForElement.waitForElements(str, "xpath");
		assertTrue((this.page.element(str, "xpath")).isElementPresent()==true);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify the green sqare box(SUCCESS,COMPLETE) is displaying.
	* Date 		  : 30-Aug-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verGreenSqaureBoxIsDisplaying(String study) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		String str = "//a[contains(text(),'"+study+"')]/../following-sibling::td//div[@title='SUCCESS,COMPLETE']";
			assertTrue(this.page.element(
					str, "xpath")
					.isElementPresent());

		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify modified study fields(name,id,date,time) in view patien page.
	* Date 		  : 31-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verModifiedStudyFields(String study,String id,String date,String time) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		String str = "//a[text()='"+study+"']/../..//td[text()='"+id+"']/..//td[text()='"+date+"']/..//td[text()='"+time+"']";
		System.out.println(str);
		objWaitForElement.waitForElements(str, "xpath");
		assertTrue(this.page.element(str, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Align center' icon in template editor page.
     * Date        : 02-Sep-2016
     * Author      : Hanumegowda
     **********************************************************************************/
	public ViewPatients clickOnAlignCenterIcon() throws Exception {
		objWaitForElement.waitForElements(alignCenter, "id");
		this.page.element(alignCenter, "id").mouseOver();
		this.page.element(alignCenter, "id").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Insert image' icon in template editor page.
     * Date        : 02-Sep-2016
     * Author      : Hanumegowda
     **********************************************************************************/
	public ViewPatients clickOnInsertImageIcon() throws Exception {
		objWaitForElement.waitForElements(insertImage, "id");
		this.page.element(insertImage, "id").mouseOver();
		this.page.element(insertImage, "id").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on browse button after click on insert image icon 
	 *               in template editor page.
     * Date        : 02-Sep-2016
     * Author      : Hanumegowda
     **********************************************************************************/
	public ViewPatients clickOnBrowseButtonWhileInsertImage(String img) throws Exception {
		objWaitForElement.waitForElements(browseInInsertImage, "css");
		this.page.element(browseInInsertImage, "css").getOne().sendKeys(img);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on insert button after uploading the image 
	 *               in template editor page.
     * Date        : 02-Sep-2016
     * Author      : Hanumegowda
     **********************************************************************************/
	public ViewPatients clickOnInsertButton() throws Exception {
		objWaitForElement.waitForElements(insertBtnInUploadImgWindow, "xpath");
		this.page.element(insertBtnInUploadImgWindow, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select 'select header template' option.
	  * Date        : 02-Sep-2016
      * Author      : Hanumegowda
	  **********************************************************************************/
	public ViewPatients selHeaderTemplateOption(String option) throws Exception {
		objWaitForElement.waitForElements(headerTemplate, "id");
		this.page.element(headerTemplate, "id").webElementToSelect()
				.selectByVisibleText(option);
		return this;
	}
	
	/**********************************************************************************
     * Description : This function is to verify Clinic Header Text is displaying.
     * Date        : 02-Sep-2016
     * Author      : Hanumegowda
     **********************************************************************************/
	public ViewPatients verClinicHeaderText(String postreplyTxt)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToIFrame("iFrameResizer0");
		String str = "//p[contains(text(),'"+postreplyTxt+"')]";
		String str1 = "//div[contains(text(),'"+postreplyTxt+"')]";
		System.out.println(str);
		objWaitForElement.waitForElements(str, "xpath");
		assertTrue(((this.page.element(str, "xpath")).isElementPresent()==true)||(this.page.element(str1, "xpath")).isElementPresent()==true);
		return this;
	}
	
	/**********************************************************************************
     * Description : This function is to verify Clinic Header logo is displaying.
     * Date        : 02-Sep-2016
     * Author      : Hanumegowda
     **********************************************************************************/
	public ViewPatients verClinicHeaderLogo()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToIFrame("iFrameResizer0");
		List<WebElement> l = driver.findElements(By.xpath(logoImage));
		System.out.println(l.size()+" this many images");
		objWaitForElement.waitForElements(logoImage, "xpath");
		assertTrue((this.page.element(logoImage, "xpath")).isElementPresent()==true);
		assertFalse(this.page.element(logoImage1, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE1));
		return this;
	}
	
	/**********************************************************************************
     * Description : This function is to verify 'addendum icon' is displaying infront of signed report.
     * Date        : 20-Sep-2016
     * Author      : Hanumegowda
     **********************************************************************************/
	public ViewPatients verAddendumIconOfSignedReport()
			throws Exception {
		objWaitForElement.waitForElements(addendumIcon, "xpath");
		assertTrue((this.page.element(addendumIcon, "xpath")).isElementPresent()==true);
		return this;
	}
	
	/**********************************************************************************
     * Description : This function is to verify 'addendum icon' is not displaying for saved report.
     * Date        : 20-Sep-2016
     * Author      : Hanumegowda
     **********************************************************************************/
	public ViewPatients verAddendumIconNotDisplayingForSavedReport(String date)
			throws Exception {
		String str = "//a[contains(text(),'"+date+"')]/../../following-sibling::td//a/img[@src='/wavelet/gifs.new/sign_doc_but.gif']"
				+ "/../..//a/img[@src='/wavelet/gifs.new/rep_addendum.gif']";
		objWaitForElement.waitForElements(str, "xpath");
		assertFalse(this.page.element(str, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE1));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click On 'new addendum' icon in web reporter page.
	* Date 		  : 28-Sep-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnNewAddEndumIcon() throws Exception {
		objWaitForElement.waitForElements(addendumIcon, "xpath");
		this.page.element(addendumIcon, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter the text in Referring Physician text field in 
	*               addendum report editor page.
	* Date 		  : 28-Sep-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients enterTextInReferringPhysicianFieldInAddendumReportEditorPage(String refphy) throws Exception {
		objWaitForElement.waitForElements(refPhyTxtFldInAddendumReportEdtrPage, "xpath");
		this.page.element(refPhyTxtFldInAddendumReportEdtrPage, "xpath").getOne().click();
	    this.page.element(refPhyTxtFldInAddendumReportEdtrPage, "xpath").getOne().sendKeys(refphy);
		
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Save & Sign Addendum'  button.
	* Date 		  : 28-Sep-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnSaveAndSignAddendum() throws Exception {
		objWaitForElement.waitForElements(saveAndSignAddendum, "xpath");
		this.page.element(saveAndSignAddendum, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'remove' link is displayed in front of addendum report.
	* Date 		  : 28-Sep-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verRemoveLinkOfAddendumReportIsDisplayed() throws Exception {
		objWaitForElement.waitForElements(removeAddendum, "xpath");
		assertTrue(this.page.element(removeAddendum, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on remove link of addendum report.
	* Date 		  : 28-Sep-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients clickOnRemoveAddendum() throws Exception {
		objWaitForElement.waitForElements(removeAddendum, "xpath");
		this.page.element(removeAddendum, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'remove' link is not displaying in front of addendum report.
	* Date 		  : 28-Sep-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verRemoveLinkOfAddendumReportIsNotDisplayed() throws Exception {
		assertFalse(this.page.element(removeAddendum, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE1));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click On 'Get Latest Plugins' button.
	 * Date 	   : 29-Sep-2016
	 * Author 	   : Hanumegowda
	 **********************************************************************************/
	public ViewPatients clickOnGetLatestPlugins() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(getLatestPlugins, "css");
		this.page.element(getLatestPlugins, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click On download link of required software in  
	 *               download software page.
	 * Date 	   : 29-Sep-2016
	 * Author 	   : Hanumegowda
	 **********************************************************************************/
	public ViewPatients clickOnDownloadLinkOfRequiredSoftware(String software) throws Exception {
		Thread.sleep(5000);
		String str = "//b[text()='"+software+"']/following-sibling::table//a/img[@src='download_button.gif']";
		objWaitForElement.waitForElements(str, "xpath");
		this.page.element(str, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on refresh link in dicom spooler page.
	 * Date        : 17-Oct-2016
     * Author      : Hanumegowda
     **********************************************************************************/
	public ViewPatients clickOnRefreshLinkInDicomSpooler() throws Exception {
		objWaitForElement.waitForElements(refreshLink, "linktext");
		this.page.element(refreshLink, "linktext").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on search button till the study is sent to 
	  *               another server in view patients page
	  * Date        : 25-Oct-2016
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public ViewPatients clickOnSearchTillStudySent() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		WebDriverWait wait = new WebDriverWait(this.driver, WaitTimeConstants.WAIT_TIME_LONG);
		objWaitForElement.waitForElements(search, "xpath");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(search)));
		this.page.element(search, "xpath").getOne().click();
		Thread.sleep(3000);
		boolean a;
		do{
		if(this.page.element("//td[contains(text(),'0 images left to send')]", "xpath").isElementPresent()==false){
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(search)));
			this.page.element(search, "xpath").getOne().click();
			Thread.sleep(2000);
			a = true;
		}
		else{
			a = false;
		}
		}while(a);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify cloud consult type is displaying.
	* Date 		  : 01-Dec-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verCloudConsultType() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(cloudConsultType, "xpath");
		assertTrue(this.page.element(cloudConsultType, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'plus icon of images to send' in view patients page.
	 * Date        : 02-Dec-2016
     * Author      : Hanumegowda
     **********************************************************************************/
	public boolean clickOnPlusIconOfImagesToSend() throws Exception {
		objFrames.switchToDefaultFrame().switchToMainMenuFrame();
		objWaitForElement.waitForElements(plusIcon, "xpath");
		try {
			this.page.element(plusIcon, "xpath").getOne().click();
			return true;
		} catch (NoSuchElementException ne) {
			return false;

		}
	}
	
	/**********************************************************************************
	  * Description : This function is to verify the selected compression level taking modality 
	  *               as reference in view patients page.
	  * Date        : 07-Dec-2016
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public ViewPatients verSelectedCompressionLevel(String modality, String ex) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		String str = "//nobr[contains(text(),'Modality')]/b[text()='"+modality+"']/ancestor::td[1]//following-sibling::td/select";
		objWaitForElement.waitForElements(str, "xpath");
		assertTrue((this.page.element(str, "xpath")).isElementPresent());
        String actual = (this.page.element(str, "xpath")).webElementToSelect().getFirstSelectedOption().getText();
        System.out.println(actual+" selected option");
        assertTrue(ex.equals(actual.trim()));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on General tab.
	  * Date        : 08-Dec-2016
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public ViewPatients clickOnGeneral() throws Exception {
		Thread.sleep(2000);
		objWaitForElement.waitForElements(general, "xpath");
		this.page.element(general, "xpath").mouseOver();
		this.page.element(general, "xpath").getOne().click();
		//driver.navigate().refresh();
		
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify only one study is displaying in view patients page.
	* Date 		  : 19-Dec-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ViewPatients verSecondStudyIsNotPresent() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		String ele = "(//img[@src='/cobalt-images/modify.gif'])[2]";
		assertFalse(this.page.element(ele, "xpath").isElementPresent());
		return this;
	}

}
