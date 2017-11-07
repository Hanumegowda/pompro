package page;

import module.Frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import static org.testng.Assert.assertTrue;
import qaframework.lib.pageObject.PageObject;
import qaframework.lib.userDefinedFunctions.WaitForElement;

public class Statistics extends PageObject{
	WebDriver driver;
	WaitForElement objWaitForElement;
	Frames objFrames;
	
	private String remoteClinics = "//a[contains(text(),'Remote Clinics')]",
			       studiesReceivedbyModalityandDate = "//a[text()='Studies Received by Modality and Date']",
			       selectAll = "//a[text()='Select All']",
			       next = "//input[@type='BUTTON'][@name='NextButton']",
			       date = "INP_DATE",
			       EndDateCalendarIcon = "(//img[@src='/wavelet/gifs.new/ris_calendar_icon.gif'])[2]",
			       next1 = "//input[@type='BUTTON'][@value='Next >>']",
			       today = "//a[contains(text(),'Today')]",
			       studiesReceivedbyMTFandDate = "//a[text()='Studies Received by MTF and Date']",
			       studiesArchivedbyMTFandDate = "//a[text()='Studies Archived by MTF and Date']",
			       listOfStudiesWithoutReports = "//a[text()='List of studies without reports']",
			       timePeriod = "//select[@name='sel_time']",
			       search = "//a[text()='Search']",
			       radiology = "//a[text()='Radiology']",
			       find = "//input[@type='TEXT'][@name='f']",
			       studyEventsAudit = "//a[text()='Study Events Audit']",
			       status = "//select[@name='read_status']",
			       limit = "//select[@name='on_page']",
			       studiesOrImagesReceivedByStationNameModalityAndDate = "//a[text()='Studies/Images Received by Station name, Modality and Date']",
			       patientReview = "//a[text()='Patient Review']",
			       dailyPatientReviewLog = "//b[text()='Daily Patient Review Log']",
			       totals = "//b[contains(text(),'TOTALS:')]",
			       studiesOrImagesSentByAddressAndDate = "//a[text()='Studies/Images Sent by Address and Date']",
			       studiesReceivedByAeTitleAndDate = "//a[text()='Studies Received by AETITLE and Date']",
			       selectAETITLEPage = "//b[contains(text(),'Select AETITLE')]",
			       studiesReceivedByClinicAndDate = "//a[text()='Studies/Images Received by Clinic and Date']",
			       selectInstitutions = "//b[contains(text(),'Select Institutions')]",
			       billingReport = "//a[text()='Billing report']",
			       reportsCreatedByDoctorAndDate = "//a[text()='Reports Created by Doctor and Date']",
			       selectDoctors = "//b[contains(text(),'Select Doctors')]",
			       reportsCreatedByDoctorAndDatePage = "//td[contains(text(),'REPORTS CREATED BY DOCTOR AND DATE')]",
			       studiesReceivedByReferringDoctorModalityAndDate = "//a[text()='Studies Received by Referring Doctor, Modality and Date']",
			       selectReferringDoctors = "//b[contains(text(),'Select Referring Doctors')]",
			       studiesReceivedInRemoteClinicsByModalityAndDate = "//a[text()='Studies Received  in Remote Clinics (by Modality and Date)']",
			       selectClinic = "//b[contains(text(),'Select clinic')]",
			       reportsCreatedByMTFDoctorsAndDate = "//a[text()='Reports Created by MTF, Doctors and Date']",
			       reportsCreatedInRemoteClinicsByModalityAndDate = "//a[text()='Reports Created in Remote Clinics (by Modality and Date)']",
			       ordersScheduledInRemoteClinicsByModalityAndDate = "//a[text()='Orders Scheduled in Remote Clinics (by Modality and Date)']",
			       ordersByModalityAndDate = "//a[text()='Orders by Modality and Date']",
			       turnaroundTimeReportExternalReads = "//a[text()='Turnaround Time Report (External reads)']",
			       responseTime = "//td[11][text()='RESPONSE TIME']/../following-sibling::tr/td[11]",
			       listOfNonSentStudies = "//a[text()='List of non-sent studies']",
			       ordersCreatedByDoctorAndDate = "//a[text()='Orders created by Doctor and Date']",
			       orderCreatedByDoctorAndDatePage = "//td[contains(text(),'Orders created by Doctor and Date')]",
			       studiesReceivedByServiceLocationAndDate = "//a[text()='Studies Received by Service Location and Date']",
			       eventsLog = "//a[text()='Events Log']",
			       event = "//select[@name='read_status']",
			       turnaroundTimeReportLocalReads = "//a[text()='Turnaround Time Report (Local reads)']",
			       responseTimeForLocalReads = "//td[10][text()='RESPONSE TIME']/../following-sibling::tr/td[10]",
			       scheduledOrdersReport = "Scheduled Orders Report",
			       totalStatCount = "//td[contains(text(),'Total:')]",
			       acquisitionTimeReport = "//a[text()='Acquisition Time Report']",
			       executionTime = "//td[11][text()='EXECUTION TIME']/../following-sibling::tr/td[11]",
			       studiesReadByDoctorAndDate = "//a[text()='Studies Read by Doctor and Date']"; 
			       
	
	public Statistics(WebDriver _driver) throws Exception{
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
		objFrames = new Frames(this.driver);
		
	}
	
	/**********************************************************************************
	 * Description : This function is to click on any Remote Clinics links.
	 * Date        : 14-Aug-2015
	 * Author      : Hanumegowda--
	 **********************************************************************************/
	public Statistics clickOnRemoteClinicsLinks() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(remoteClinics, "xpath");
		this.page.element(remoteClinics, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify required server link is present.
	 * Date        : 14-Aug-2015
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics verServerLinkIsPresent(String server) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements("//a[contains(text(),'" + server + "')]",
				"xpath");
		assertTrue(this.page.element("//a[contains(text(),'" + server + "')]", "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Studies Received by Modality and Date' link.
	 * Date        : 13-Oct-2015
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics clickOnStudiesReceivedByModalityAndDate() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(studiesReceivedbyModalityandDate, "xpath");
		this.page.element(studiesReceivedbyModalityandDate, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on Radology button.
	 * Date        : 13-Oct-2015
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics clickOnRadiology() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(radiology, "xpath");
		this.page.element(radiology, "xpath").mouseOver();
		this.page.element(radiology, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter text in find field.
	 * Date        : 13-Oct-2015
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics enterTextInFindField(String study) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(find, "xpath");
		this.page.element(find, "xpath").clearInputValue().sendKeys(study);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Select all' link.
	 * Date        : 13-Oct-2015
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics clickOnSelectAll() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(selectAll, "xpath");
		this.page.element(selectAll, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on next button.
	 * Date        : 13-Oct-2015
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics clickOnNext() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(next, "xpath");
		this.page.element(next, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to get current date.
	 * Date        : 13-Oct-2015
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public String getCurrentDate() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(date, "id");
		String str = this.page.element(date, "id").getOne().getAttribute("value");
		return str;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on end date calendar icon.
	 * Date        : 13-Oct-2015
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics clickOnEndDateCalendarIcon() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(EndDateCalendarIcon, "xpath");
		this.page.element(EndDateCalendarIcon, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to get current date.
	 * Date        : 13-Oct-2015
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics pickDate(int dt) throws Exception {
		objWaitForElement.waitForElements("//font[text()='"+dt+"']", "xpath");
		this.page.element("//font[text()='"+dt+"']", "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on next button.
	 * Date        : 13-Oct-2015
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics clickOnNext1() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(next1, "xpath");
		this.page.element_wait(next1, "xpath").waitForElementEnable();
		this.page.element(next1, "xpath").clickUjse();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on today link.
	 * Date        : 13-Oct-2015
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics clickOnToday() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(today, "xpath");
		this.page.element(today, "xpath").clickUjse();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify the study received by different Statistics.
	 * Date        : 13-Oct-2015
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics verStudyReceivedByDifferentStatistics(String modality, int a) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements("//td[contains(text(),'"+modality+"')]/following-sibling::td[last()]", "xpath");
		String str = this.page.element("//td[contains(text(),'"+modality+"')]/following-sibling::td[last()]", "xpath").getOne().getText();
		String str1 = str.trim();
		int i = Integer.parseInt(str1);
		System.out.println(i);
		assertTrue(i>a);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to get initial Statistics count.
	 * Date        : 13-Oct-2015
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public int getInitialCount(String modality) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements("//td[contains(text(),'"+modality+"')]/following-sibling::td[last()]", "xpath");
		String str = this.page.element("//td[contains(text(),'"+modality+"')]/following-sibling::td[last()]", "xpath").getOne().getText();
		String str1 = str.trim();
		int i = Integer.parseInt(str1);
		System.out.println(i);
		return i;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify the study received by different Statistics.
	 * Date        : 13-Oct-2015
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public int getInitialCount1(String modality) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements("//td[contains(text(),'"+modality+"')]/following-sibling::td[1]", "xpath");
		String str = this.page.element("//td[contains(text(),'"+modality+"')]/following-sibling::td[1]", "xpath").getOne().getText();
		System.out.println(str.trim());
		String strr[] = str.split("\\(");
		System.out.println(strr[0]);
		int i = Integer.parseInt(strr[0].trim());
		System.out.println(i+" tis is after trimmed");
		return i;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify the study received by different Statistics.
	 * Date        : 13-Oct-2015
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics verStudyReceivedByDifferentStatistics1(String modality, int a) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements("//td[contains(text(),'"+modality+"')]/following-sibling::td[1]", "xpath");
		String str = this.page.element("//td[contains(text(),'"+modality+"')]/following-sibling::td[1]", "xpath").getOne().getText();
		System.out.println(str.trim());
		String strr[] = str.split("\\(");
		System.out.println(strr[0]);
		int i = Integer.parseInt(strr[0].trim());
		System.out.println(i+" tis is after trimmed");
		assertTrue(i>a);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify the study received by different Statistics.
	 * Date        : 13-Oct-2015
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public int getStatisticsCountOfParticularModality(String modality) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements("//td[contains(text(),'"+modality+"')]/following-sibling::td[2]", "xpath");
		String str = this.page.element("//td[contains(text(),'"+modality+"')]/following-sibling::td[2]", "xpath").getOne().getText();
		String str1 = str.trim();
		System.out.println(str);
		int i = Integer.parseInt(str1);
		return i;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Studies Received by MTF and Date' link.
	 * Date        : 13-Oct-2015
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics clickOnStudiesReceivedByMTFAndDate() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(studiesReceivedbyMTFandDate, "xpath");
		this.page.element(studiesReceivedbyMTFandDate, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Studies Received by MTF and Date' link.
	 * Date        : 15-Oct-2015
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics clickOnStudiesArchivedByMTFAndDate() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(studiesArchivedbyMTFandDate, "xpath");
		this.page.element(studiesArchivedbyMTFandDate, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'List of studies without reports' link.
	 * Date        : 16-Oct-2015
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics clickOnListOfStudiesWithoutReports() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(listOfStudiesWithoutReports, "xpath");
		this.page.element(listOfStudiesWithoutReports, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select option in 'Time period of arrival studies' dropdown.
	 * Date        : 16-Oct-2015
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics selTimePeriod(String period) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(timePeriod, "xpath");
		this.page.element(timePeriod, "xpath").webElementToSelect().selectByVisibleText(period);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on search button.
	 * Date        : 13-Oct-2015
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics clickOnSearch() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(search, "xpath");
		this.page.element(search, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify study is present.
	 * Date        : 16-Oct-2015
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics verStudyIsPresent(String study) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements("//td[contains(text(),'"+study+"')]",
				"xpath");
		assertTrue(this.page.element("//td[contains(text(),'"+study+"')]", "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select 'SC' modality checkbox in select modality page.
	 * Date        : 07-Dec-2015
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics selAModalityCheckBox(String modality) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		String str = "//input[@type='CHECKBOX'][@name='modality'][@value='"+modality+"']";
		objWaitForElement.waitForElements(str, "xpath");
		if (this.page.element(str, "xpath").getOne().isSelected() == false) {
			this.page.element(str, "xpath").getOne().click();

		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'StudyEventsAudit' link.
	 * Date        : 19-Apr-2016
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics clickOnStudyEventsAuditLink() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(studyEventsAudit, "xpath");
		this.page.element(studyEventsAudit, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select option in 'Status' dropdown.
	 * Date        : 19-Apr-2016
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics selStatusDropdownOption(String period) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(status, "xpath");
		this.page.element(status, "xpath").webElementToSelect().selectByVisibleText(period);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select option in 'Limit' dropdown.
	 * Date        : 19-Apr-2016
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics selLimitDropdownOption(String period) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(limit, "xpath");
		this.page.element(limit, "xpath").webElementToSelect().selectByVisibleText(period);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Studies/Images Received by Station name, 
	 *               Modality and Date' link.
	 * Date        : 20-Apr-2016
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics clickOnStudiesOrImagesReceivedByStationNameModalityAndDate() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(studiesOrImagesReceivedByStationNameModalityAndDate, "xpath");
		this.page.element(studiesOrImagesReceivedByStationNameModalityAndDate, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify statistics of 'Studies/Images Received by Station
	 *               name, Modality and Date'.
	 * Date        : 20-Apr-2016
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics verStatisticsOfStudiesReceivedByStationNameModalityAndDate(String station) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements("//tr/td[text()='"+station+"']/following-sibling::td[@nowrap='']", "xpath");
		String str = this.page.element("//tr/td[text()='"+station+"']/following-sibling::td[@nowrap='']", "xpath").getOne().getText();
		String str1 = str.trim();
		System.out.println(str);
		int i = Integer.parseInt(str1);
		assertTrue(i>=1);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Patient Review' link.
	 * Date        : 21-Apr-2016
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics clickOnPatientReviewLink() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(patientReview, "xpath");
		this.page.element(patientReview, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Daily Patient Review Log' page is displayed.
	 * Date        : 21-Apr-2016
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics verDailyPatientReviewLogPage() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(dailyPatientReviewLog, "xpath");
		assertTrue(this.page.element(dailyPatientReviewLog, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify total count.
	 * Date        : 21-Apr-2016
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics verTotalCount() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(totals,
				"xpath");
		String str = this.page.element(totals, "xpath").getOne().getText();
		String str1[] = str.split(":");
		int i = Integer.parseInt((str1[1]).trim());
		System.out.println(i+" i value");
		assertTrue(i>0);
				
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Studies/Images Sent by Address and Date' link.
	 * Date        : 27-Apr-2016
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics clickOnStudiesImagesSentByAddressAndDate () throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(studiesOrImagesSentByAddressAndDate, "xpath");
		this.page.element(studiesOrImagesSentByAddressAndDate, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Studies Received by AETITLE and Date' link.
	 * Date        : 28-Apr-2016
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics clickOnStudiesReceivedByAETITLEAndDate() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(studiesReceivedByAeTitleAndDate, "xpath");
		this.page.element(studiesReceivedByAeTitleAndDate, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Select AETITLE ' page is displayed.
	 * Date        : 28-Apr-2016
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics verSelectAETITLEPage() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(selectAETITLEPage, "xpath");
		assertTrue(this.page.element(selectAETITLEPage, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Studies Received by Clinic and Date' link.
	 * Date        : 02-May-2016
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics clickOnStudiesReceivedByClinicAndDate() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(studiesReceivedByClinicAndDate, "xpath");
		this.page.element(studiesReceivedByClinicAndDate, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Select Institutions' page is displayed.
	 * Date        : 02-May-2016
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics verSelectInstitutionsPage() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(selectInstitutions, "xpath");
		assertTrue(this.page.element(selectInstitutions, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Billing report' link.
	 * Date        : 03-May-2016
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics clickOnBillingReport() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(billingReport, "xpath");
		this.page.element(billingReport, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Reports Created by Doctor and Date' link.
	 * Date        : 04-May-2016
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics clickOnReportsCreatedByDoctorAndDate() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(reportsCreatedByDoctorAndDate, "xpath");
		this.page.element(reportsCreatedByDoctorAndDate, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Select Doctors' page is displayed.
	 * Date        : 04-May-2016
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics verSelectDoctorsPage() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(selectDoctors, "xpath");
		assertTrue(this.page.element(selectDoctors, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select a doctor/MTF checkbox.
	 * Date        : 04-May-2015
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics selDoctor(String doc) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		String str = "//input[@type='CHECKBOX'][@value='"+doc+"']";
		objWaitForElement.waitForElements(str, "xpath");
		this.page.element(str, "xpath").mouseOver();
		if (this.page.element(str, "xpath").getOne().isSelected() == false) {
			this.page.element(str, "xpath").getOne().click();

		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'REPORTS CREATED BY DOCTOR AND DATE' page is displayed.
	 * Date        : 04-May-2016
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics verReportsCreatedByDoctorAndDatePage() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(reportsCreatedByDoctorAndDatePage, "xpath");
		assertTrue(this.page.element(reportsCreatedByDoctorAndDatePage, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Studies Received by Referring Doctor, Modality and Date' link.
	 * Date        : 05-May-2016
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics clickOnStudiesReceivedByReferringDoctorModalityAndDate() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(studiesReceivedByReferringDoctorModalityAndDate, "xpath");
		this.page.element(studiesReceivedByReferringDoctorModalityAndDate, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Select Referring Doctors' page is displayed.
	 * Date        : 05-May-2016
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics verSelectReferringDoctorsPage() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(selectReferringDoctors, "xpath");
		assertTrue(this.page.element(selectReferringDoctors, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Studies Received in Remote Clinics (by Modality 
	 *               and Date)' link.
	 * Date        : 09-May-2016
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics clickOnStudiesReceivedInRemoteClinicsByModalityAndDate() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(studiesReceivedInRemoteClinicsByModalityAndDate, "xpath");
		this.page.element(studiesReceivedInRemoteClinicsByModalityAndDate, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Select clinic' page is displayed.
	 * Date        : 09-May-2016
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics verSelectClinicPage() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(selectClinic, "xpath");
		assertTrue(this.page.element(selectClinic, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select a clinic checkbox.
	 * Date        : 09-May-2016
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics selectClinicCheckBox(String clnc) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		String str = "//a[text()='"+clnc+"']/../preceding-sibling::td/input[@type='CHECKBOX']";
		if((this.page.element(str, "xpath")).getOne().isSelected()==false){
		objWaitForElement.waitForElements(str, "xpath");
		this.page.element(str, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select a clinic checkbox.
	 * Date        : 09-May-2016
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics selectClinicCheckBox1(String clnc) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		String str = "//input[@type='CHECKBOX'][@value='"+clnc+"']";
		if((this.page.element(str, "xpath")).getOne().isSelected()==false){
		objWaitForElement.waitForElements(str, "xpath");
		this.page.element(str, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Reports Created by MTF, Doctors and Date' link.
	 * Date        : 12-May-2016
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics clickOnReportsCreatedByMTFDoctorsAndDate() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(reportsCreatedByMTFDoctorsAndDate, "xpath");
		this.page.element(reportsCreatedByMTFDoctorsAndDate, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Reports Created in Remote Clinics (by Modality 
	 *               and Date) ' link.
	 * Date        : 13-May-2016
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics clickOnReportsCreatedInRemoteClinicsByModalityAndDate() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(reportsCreatedInRemoteClinicsByModalityAndDate, "xpath");
		this.page.element(reportsCreatedInRemoteClinicsByModalityAndDate, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Orders Scheduled in Remote Clinics (by 
	 *               Modality and Date)' link.
	 * Date        : 16-May-2016
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics clickOnOrdersScheduledInRemoteClinicsByModalityAndDate() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(ordersScheduledInRemoteClinicsByModalityAndDate, "xpath");
		this.page.element(ordersScheduledInRemoteClinicsByModalityAndDate, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Orders by Modality and Date' link.
	 * Date        : 17-May-2016
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics clickOnOrdersByModalityAndDate() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(ordersByModalityAndDate, "xpath");
		this.page.element(ordersByModalityAndDate, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Turnaround Time Report (External reads)' link.
	 * Date        : 18-May-2016
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics clickOnTurnaroundTimeReportExternalReads() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(turnaroundTimeReportExternalReads, "xpath");
		this.page.element(turnaroundTimeReportExternalReads, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'REPORT RECEIVE TIME'.
	 * Date        : 18-May-2016
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics verReportReceiveTime(String time) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		String str = "//td[10][text()='REPORT RECEIVE TIME']/../following-sibling::tr/td[10][contains(text(),'"+time+"')]";
		objWaitForElement.waitForElements(str, "xpath");
		assertTrue(this.page.element(str, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'RESPONSE TIME'.
	 * Date        : 18-May-2016
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics verResponseTime() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(responseTime, "xpath");
		String actual = this.page.element(responseTime, "xpath").getOne().getText();
		String str[] = actual.split(":");
		int i = Integer.parseInt(str[1]);
		System.out.println(i);
		assertTrue(i>0);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'List of non-sent studies' link.
	 * Date        : 19-May-2016
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics clickOnListOfNonSentStudies() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(listOfNonSentStudies, "xpath");
		this.page.element(listOfNonSentStudies, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Orders created by Doctor and Date' link.
	 * Date        : 26-May-2016
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics clickOnOrdersCreatedByDoctorAndDate() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(ordersCreatedByDoctorAndDate, "xpath");
		this.page.element(ordersCreatedByDoctorAndDate, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on expand arrow of a group.
	 * Date        : 26-May-2016
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics clickOnExpandArrowOfAGroup(String gp) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		String str = "//label[contains(text(),'"+gp+"')]/preceding-sibling::div[@class='arrow collapsed']";
		objWaitForElement.waitForElements(str, "xpath");
		this.page.element(str, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select a doctor checkbox in collapsed group.
	 * Date        : 26-May-2015
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics selDoctor1(String doc) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		String str = "//label[text()='"+doc+"']/preceding-sibling::div[@class='checkbox']";
		objWaitForElement.waitForElements(str, "xpath");
		this.page.element(str, "xpath").mouseOver();
		if (this.page.element(str, "xpath").getOne().isSelected() == false) {
			this.page.element(str, "xpath").getOne().click();

		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'ORDER CREATED BY DOCTOR AND DATE' page is displayed.
	 * Date        : 24-May-2016
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics verOrderCreatedByDoctorAndDatePage() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(orderCreatedByDoctorAndDatePage, "xpath");
		assertTrue(this.page.element(orderCreatedByDoctorAndDatePage, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Studies Received by Service Location and Date' link.
	 * Date        : 09-Jun-2016
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics clickOnStudiesReceivedByServiceLocationAndDate() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(studiesReceivedByServiceLocationAndDate, "xpath");
		this.page.element(studiesReceivedByServiceLocationAndDate, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Events Log' link.
	 * Date        : 30-Jun-2016
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics clickOnEventsLogLink() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(eventsLog, "xpath");
		this.page.element(eventsLog, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select option in 'Event' dropdown.
	 * Date        : 30-Jun-2016
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics selEventDropdownOption(String strevent) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(event, "xpath");
		this.page.element(event, "xpath").webElementToSelect().selectByVisibleText(strevent);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Turnaround Time Report (Local reads)' link.
	 * Date        : 26-Sep-2016
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics clickOnTurnaroundTimeReportLocalReads() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(turnaroundTimeReportLocalReads, "xpath");
		this.page.element(turnaroundTimeReportLocalReads, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'RESPONSE TIME' for local reads.
	 * Date        : 26-Sep-2016
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics verResponseTimeForLocalReads() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(responseTimeForLocalReads, "xpath");
		String actual = this.page.element(responseTimeForLocalReads, "xpath").getOne().getText();
		String str[] = actual.split(":");
		int i = Integer.parseInt(str[1]);
		System.out.println(i);
		assertTrue(i>0);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Scheduled Orders Report' link.
	 * Date        : 30-Sep-2016
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics clickOnScheduledOrdersReport() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(scheduledOrdersReport, "linktext");
		this.page.element(scheduledOrdersReport, "linktext").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to get the total statistics count and to verify.
	 * Date        : 30-Sep-2016
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics getTotalStatisticsCountAndVerify(int req) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(totalStatCount, "xpath");
		String str = this.page.element(totalStatCount, "xpath").getOne().getText();
		String[] str1 = str.split(":");
		int i = Integer.parseInt((str1[1]).trim());
		System.out.println(i+ " this is d total count");
		assertTrue(i>req);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Acquisition Time Report' link.
	 * Date        : 13-Oct-2016
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics clickOnAcquisitionTimeReport() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(acquisitionTimeReport, "xpath");
		this.page.element(acquisitionTimeReport, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'EXECUTION TIME' in 'Acquisition Time Report'
	 *               statistics page.
	 * Date        : 13-Oct-2016
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics verExecutionTime() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(executionTime, "xpath");
		String actual = this.page.element(executionTime, "xpath").getOne().getText();
		String str[] = actual.split(":");
		int i = Integer.parseInt(str[1]);
		System.out.println(i);
		assertTrue(i>0);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify the study date and time in events log page.
	 * Date        : 23-Nov-2016
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics verStudyDateAndTime(String datetime,String datetime1,String datetime2) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		String str = "//tr/td[4][text()='Date']/../following-sibling::tr//td[4][text()='"+datetime+"']";
		String str1 = "//tr/td[4][text()='Date']/../following-sibling::tr//td[4][text()='"+datetime1+"']";
		String str2 = "//tr/td[4][text()='Date']/../following-sibling::tr//td[4][text()='"+datetime2+"']";
		objWaitForElement.waitForElements(str,
				"xpath");
		assertTrue(this.page.element(str, "xpath").isElementPresent()||this.page.element(str1, "xpath").isElementPresent()||this.page.element(str2, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Studies Read by Doctor and Date' link.
	 * Date        : 28-Nov-2016
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics clickOnStudiesReadByDoctorAndDate() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(studiesReadByDoctorAndDate, "xpath");
		this.page.element(studiesReadByDoctorAndDate, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify the 'Create date' of study in 'details' 
	 *               section in events log page.
	 * Date        : 12-Dec-2016
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics verStudyCreateDate(String datetime,String datetime1,String datetime2) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		String str = "//td[contains(text(),'Create date:"+datetime+"')]";
		String str1 = "//td[contains(text(),'Create date:"+datetime1+"')]";
		String str2 = "//td[contains(text(),'Create date:"+datetime2+"')]";
		objWaitForElement.waitForElements(str,
				"xpath");
		assertTrue(this.page.element(str, "xpath").isElementPresent()||this.page.element(str1, "xpath").isElementPresent()||this.page.element(str2, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify the 'Study date' of study in 'details' 
	 *               section in events log page.
	 * Date        : 12-Dec-2016
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Statistics verStudyDate(String datetime,String datetime1,String datetime2) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		String str = "//td[contains(text(),'Study date:"+datetime+"')]";
		String str1 = "//td[contains(text(),'Study date:"+datetime1+"')]";
		String str2 = "//td[contains(text(),'Study date:"+datetime2+"')]";
		objWaitForElement.waitForElements(str,
				"xpath");
		assertTrue(this.page.element(str, "xpath").isElementPresent()||this.page.element(str1, "xpath").isElementPresent()||this.page.element(str2, "xpath").isElementPresent());
		return this;
	}
	
}
