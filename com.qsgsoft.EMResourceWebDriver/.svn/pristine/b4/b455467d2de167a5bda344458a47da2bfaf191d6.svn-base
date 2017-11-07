package lib.page;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import lib.module.NavigationToSubMenus;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import qaframework.lib.WaitTimeConstants;
import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;

public class Report extends PageObject {

	WaitForElement objWaitForElement;
	Date_Time_settings objDT = new Date_Time_settings();
	
	public Report(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
	}
	
	private String reportDate = "snapshotDate",
			hour = "hour",
			minute = "minute",
			generateReportBtn = "//input[@class='emsButtonText'][@value='Generate Report']",
            statusSnapshot = "Status Snapshot",
            eventSnapshot = "//a[text()='Event Snapshot']",
    		eventSnapshotReport1stPage = "//div[@id='topSubNav']/h1[text()='Event Snapshot Report (Step 1 of 2)']",
            eventSnapshotReport2ndPage = "//div[@id='topSubNav']/h1[text()='Event Snapshot Report (Step 2 of 2)']",
            startDate = "//input[@name='searchStartDate'][@class='hasDatepicker']",
            endDate = "//input[@name='searchEndDate'][@class='hasDatepicker']",
            nextButton = "input[value='Next']",
            snapshotDateAndTimeShouldFallBetween = "//td[@class='emsLabel'][text()='Snapshot Date and Time should fall between:']",
            snapshotDate = "//td[@class='emsLabel'][text()='Snapshot Date (mm/dd/yyyy):']/parent::tr/td/input[@id='snapshotDate']",
            snapshotTimeHour = "//td[@class='emsLabel'][text()='Snapshot Time - Hour:']/parent::tr/td/select[@name='hour']",
            snapshotTimeMinutes = "//td[@class='emsLabel'][text()='Snapshot Time - Minutes:']/parent::tr/td/select[@name='minute']",
            reousrceReportMenuPage = "//div[@id='topSubNav']/h1[text()='Resource Reports Menu']",
            resourceDetails = "//a[text()='Resource Details']",
            resourceDetailReportPage = "//div[@id='topSubNav']/h1[text()='Resource Detail Report']",
            resourceSelectAllCheckbox = "//div[@id='mainContainer']//table/tbody/tr/td[@class='emsLabel'][text()='Resources:']/parent::tr/td/strong[text()='Select All']/preceding-sibling::input",            eventDetail = "Event Detail",
            headerName = "div#topSubNav > h1",
            excelReportRadioBtn = "input[name='reportFormat'][value='CSV']",
            reportStartDate = "input[id='StartDate'][class='hasDatepicker']",
            reportEndDate = "input[id='EndDate'][class='hasDatepicker']", 
            selectEvents = "//td[@class='emsCenteredLabel'][text()='Select Events']",
            resources = "//td[@class='emsLabel'][text()='Resources:']",
            startDateInStep2 = "input[id='searchStartDate']",
            endDateInStep2 = "input[id='searchEndDate']",
            statusReasonDetail = "Status Reason Detail",
            startDateLabel="//td[@class='emsLabel'][text()='Start Date (mm/dd/yyyy):']",
            endDateLabel = "//td[@class='emsLabel'][text()='End Date (mm/dd/yyyy):']",
            cancel = "input[value='Cancel']",
            statusTypeDropDown = "select[name='statusTypeID']",
            statusReasonSummary = "Status Reason Summary",
    		statewideResourceDetailReportPage = "//div[@id='topSubNav']/h1[text()='Statewide Resource Detail Report (Step 1 of 2)']",
            statewideResourceDetails = "Statewide Resource Details",
            nextButtonInResourceDetailPage = "input[value='Next...']",
            dataFileCommaSeparatedCSVRadioBtn = "//div[@id='mainContainer']//table/tbody/tr/td[text()='Adobe Acrobat (PDF)']/input[2]",
            statusDetail = "Status Detail",
    		statusSummary = "Status Summary",
            nextStepButton = "input[value='Next Step']",
            ipNotification= "//a[text()='Incoming Patient Notification Details']",
            incomingPatientNotificationPage = "//div[@id='topSubNav']/h1[text()='Incoming Patient Notification Details Report']",
            filterButton  = "//input[@value='Filter...']",
            excelOption= "input[value='XLS']",
            monthlyStatusAssessment = "Monthly Status Assessment",
            csvFormat = "//input[@name='reportFormat'][@value='CSV']",
            resourceTypeDropDown= "select[name='statusTypeID_filterResourceTypeID']",
            sectionDropDown= "select[name='statusTypeID_filterSection']",
            standardStatusTypeDropDown= "select[name='statusTypeID_filterStandardStatusType']",
            statusTypeName = "input[name='statusTypeID_filterText']",
            searchButton = "input[class='searchButton']",
            showAllButton = "input[class='showAllButton']",
            formDetail = "Form Detail",
            formDetailRepPge = "//div[@id='topSubNav']/h1[text()='Form Detail Report']",
            formDropDown = "select[name='questionaireID']",
            xlsxFormat = "input[name='reportFormat'][value='XLSX']",
            roleRightGrid = "Roles/Rights Grid",
            userWithNoRoleInRegion = "Users With No Role In Region",
            adminReportPage="//div[@id='topSubNav']/h1[text()='Admin Reports Menu']",
            usersWithNoRoleInRegionReportPge="//div[@id='topSubNav']/h1[text()='Users With No Role In Region Report']",
    		emsErrorTitle = "//div[@class='emsError']/span[text()='The following error occurred on this page:']",
            noFormsFoundMsg = "//div[@class='emsError']/ul/li[text()='No forms were found in the specified time frame.']",
            htmlFormat = "//input[@name='reportFormat'][@value='HTML']",
            formSummaryReport = "//a[text()='Form Summary']",
            formSummaryRepPage = "//div[@id='topSubNav']/h1[text()='Form Summary Report']",
            pdfOption = "input[value='PDF']",
            formDetailRepPgeStep2 = "//div[@id='topSubNav']/h1[text()='Form Detail Report - Step 2']",
            filterInFormRep = "input[value='Filter...']",
            errorTitle="//div[@class='emsError']/span[text()='The following error occurred on this page:']",
            errorMessage="//div[@class='emsError']/ul/li[text()='Form is required.']",
            cancelButton = "input[value='Cancel']",
            formReportsMenuPage = "//div[@id='topSubNav']/h1[text()='Form Reports Menu']",
            statusSummerypage="//div[@id='topSubNav']/h1",
	        allST="//div[@id='statusTypeID']/div[2]/table[1]/tbody/tr/th/input",
    		strApplicationUsageReportsMenu = "#topSubNav>h1",
            strNormalUsage  ="//a[contains(text(),'Normal Usage')]",
            strAppUsageRprtsNonAdm="//h1[contains(text(),'Application Usage Report - Non-Administrative')]", 
            startDate1="//td[contains(text(),'Start Date (mm/dd/yyyy):')]",
            endDate1="//td[contains(text(),'End Date (mm/dd/yyyy):')]",
            strError="//span[@class='emsErrorTitle']",
            strStrtDateText="//div[@id='mainContainer']/div[1]/ul/li[1]",
            strEndDateText="//div[@id='mainContainer']/div[1]/ul/li[2]",
            strReportBtn="//input[@value='Generate Report'] ",
            applicationUsageReports = "//table/tbody/tr/td/a[text()='Application Usage Reports']",
            noFormsFoundMsg1 = "//body//tbody/tr/td[text()='No forms found in specified date range.']",
            strError2="//li[text()='Start date may not be later than end date.']",
            statusSnapshotPage = "//div[@id='topSubNav']/h1[text()='Status Snapshot Report']",
            statusReasonSummaryRepPage1 = "//div[@id='topSubNav']/h1[text()='Status Reason Summary Report (Step 1 of 3)']",
            statusReasonSummaryRepPage2 = "//div[@id='topSubNav']/h1[text()='Status Reason Summary Report (Step 2 of 3)']",
            statusReasonSummaryRepPage3 = "//div[@id='topSubNav']/h1[text()='Status Reason Summary Report (Step 3 of 3)']",
            notificationHistory="Notification History",
            notificationStartDate="#notificationStartDate",
            notificationEnddate="#notificationEndDate",
            notificationHistorypage="//div[@id='topSubNav']/h1[text()='Notification History Report']",
            selectAllCheckBox = "//input[@value='resourceID'][@name='SELECT_ALL']/parent::td/preceding-sibling::td[1][contains(text(),'Resources')]",
            incomingPationpage="//div[@id='topSubNav']/h1[text()='Incoming Patient Notification Details Report']",
            iPNLink="Incoming Patient Notification Details",
            strAdminUsage="Admin Usage",
            strtext="//div[contains(text(),'** indicates the information is required.')]",
            strStart="//input[@id='StartDate']",
            strEnd="//input[@id='EndDate']",
            selectAllCheckBoxInStatusReasonSummary = "//input[@name='SELECT_ALL'][@type='checkbox']",
            regionalAggregrate = "//input[@name='pRegAggregate'][@type='checkbox']",
            resourceReports = "Resource Reports";
            
            
        
           
            
	
	/**********************************************************************************
	  * Description : This function is 
	  * Date        : 09/09/2014
	  * Author      : 
	  **********************************************************************************/
	public Report enterReportDate(String strDate) throws Exception {
		objWaitForElement.waitForElements(reportDate, "id");
		this.page.element(reportDate, "id").clearInputValue()
		.sendKeys(strDate);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select Hour 
	 * Date        : 09/09/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public Report selectHour(String strHour)
			throws Exception {
		objWaitForElement.waitForElements(hour, "name");
		this.page.element(hour, "name").webElementToSelect()
				.selectByVisibleText(strHour);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select Minute 
	 * Date        : 09/09/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public Report selectMinute(String strMinute)
			throws Exception {
		objWaitForElement.waitForElements(minute, "name");
		this.page.element(minute, "name").webElementToSelect()
				.selectByVisibleText(strMinute);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select Minute 
	 * Date        : 09/09/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public Report clickOnGenerateReportBtn()
			throws Exception {
		try{
			objWaitForElement.waitForElements(generateReportBtn, "xpath");
			this.page.element(generateReportBtn, "xpath").getOne().click();
		}catch(Exception e){
			
		}
		Thread.sleep(5000);//Page refreshes
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to click on 'Status snapshot' 
	* Date 			: 09/09/2014
	* Author 		: sowmya
	**********************************************************************************/
	public Report clickOnStatusSnapshot() throws Exception {
		objWaitForElement.waitForElements(statusSnapshot, "linktext");
		this.page.element(statusSnapshot, "linktext").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to click on 'Event snapshot' 
	* Date 			: 10/09/2014
	* Author 		: sowmya
	**********************************************************************************/
	public Report clickOnEventSnapshot() throws Exception {
		objWaitForElement.waitForElements(eventSnapshot, "xpath");
		this.page.element(eventSnapshot, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Event snapshot report 1st page is displayed
	 * Date        : 10/09/2014 
	 * Author      : Sowmya
	 **********************************************************************************/
	public Report verifyEventSnapshotReport1stPage() throws Exception {
		objWaitForElement.waitForElements(eventSnapshotReport1stPage, "xpath");
		assertTrue(this.page.element(eventSnapshotReport1stPage, "xpath")
				.getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Event snapshot report 2nd page is displayed
	 * Date        : 10/09/2014 
	 * Author      : Sowmya
	 **********************************************************************************/
	public Report verifyEventSnapshotReport2ndPage() throws Exception {
		objWaitForElement.waitForElements(eventSnapshotReport2ndPage, "xpath");
		assertTrue(this.page.element(eventSnapshotReport2ndPage, "xpath")
				.getOne().isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify Start date option is displayed
	 * Date        : 10/09/2014 
	 * Author      : Sowmya
	 **********************************************************************************/
	public Report verifyStartDate() throws Exception {
		objWaitForElement.waitForElements(reportStartDate, "css");
		assertTrue(this.page.element(reportStartDate, "css").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify End date option is displayed
	 * Date        : 10/09/2014 
	 * Author      : Sowmya
	 **********************************************************************************/
	public Report verifyEndDate() throws Exception {
		objWaitForElement.waitForElements(reportEndDate, "css");
		assertTrue(this.page.element(reportEndDate, "css").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select Event template
	 * Date        : 10/09/2014 
	 * Author      : Sowmya
	 **********************************************************************************/
	public Report selectEventTemplate(String strEveTemplateValue)
			throws Exception {
		objWaitForElement.waitForElements(
				"//div[@id='mainContainer']//table/tbody/tr/td/input[@value='"
						+ strEveTemplateValue + "']", "xpath");
		this.page.element(
				"//div[@id='mainContainer']//table/tbody/tr/td/input[@value='"
						+ strEveTemplateValue + "']", "xpath").mouseOver();
		this.page
				.element(
						"//div[@id='mainContainer']//table/tbody/tr/td/input[@value='"
								+ strEveTemplateValue + "']", "xpath").getOne()
				.sendKeys(Keys.SPACE);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on next button
	 * Date        : 10/09/2014 
	 * Author      : Sowmya
	 **********************************************************************************/
	public Report clickOnNextBtn() throws Exception {
		objWaitForElement.waitForElements(nextButton, "css");
		this.page.element(nextButton, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select Event radio button
	 * Date        : 10/09/2014 
	 * Author      : Sowmya
	 **********************************************************************************/
	public Report selectEventRadioBtn(String strEventName)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']//table/tbody/tr/td[4][text()='"
				+ strEventName
				+ "']/preceding-sibling::td/input", "xpath");
		this.page
				.element(
						"//div[@id='mainContainer']//table/tbody/tr/td[4][text()='"
								+ strEventName
								+ "']/preceding-sibling::td/input", "xpath")
				.getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Snapshot Date and Time should fall between' option
	 * Date        : 10/09/2014 
	 * Author      : Sowmya
	 **********************************************************************************/
	public Report verifySnapshotDateAndTimeShouldFallBetweenOption()
			throws Exception {
		objWaitForElement.waitForElements(snapshotDateAndTimeShouldFallBetween, "xpath");
		assertTrue(this.page
				.element(snapshotDateAndTimeShouldFallBetween, "xpath")
				.getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Snapshot Date' option
	 * Date        : 10/09/2014 
	 * Author      : Sowmya
	 **********************************************************************************/
	public Report verifySnapshotDateOption() throws Exception {
		objWaitForElement.waitForElements(snapshotDate, "xpath");
		assertTrue(this.page.element(snapshotDate, "xpath").getOne()
				.isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Snapshot Time - Hour' option
	 * Date        : 10/09/2014 
	 * Author      : Sowmya
	 **********************************************************************************/
	public Report verifySnapshotTimeHourOption() throws Exception {
		objWaitForElement.waitForElements(snapshotTimeHour, "xpath");
		assertTrue(this.page.element(snapshotTimeHour, "xpath").getOne()
				.isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Snapshot Time - Minutes' option
	 * Date        : 10/09/2014 
	 * Author      : Sowmya
	 **********************************************************************************/
	public Report verifySnapshotTimeMinutesOption() throws Exception {
		objWaitForElement.waitForElements(snapshotTimeMinutes, "xpath");
		assertTrue(this.page.element(snapshotTimeMinutes, "xpath").getOne()
				.isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter 'Snapshot Date' option
	 * Date        : 10/09/2014 
	 * Author      : Sowmya
	 **********************************************************************************/
	public Report enterSnapshotDate(String strSnapshotDate) throws Exception {
		objWaitForElement.waitForElements(snapshotDate, "xpath");
		this.page.element(snapshotDate, "xpath").clearInputValue()
				.sendKeys(strSnapshotDate);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select Snapshot Time - Hour 
	 * Date        : 09/09/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public Report selectSnapshotTimeHour(String strHour)
			throws Exception {
		objWaitForElement.waitForElements(snapshotTimeHour, "xpath");
		this.page.element(snapshotTimeHour, "xpath").webElementToSelect()
				.selectByVisibleText(strHour);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select Snapshot Time - Minute 
	 * Date        : 09/09/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public Report selectSnapshotTimeMinutes(String strMinute)
			throws Exception {
		objWaitForElement.waitForElements(snapshotTimeMinutes, "xpath");
		this.page.element(snapshotTimeMinutes, "xpath").webElementToSelect()
				.selectByVisibleText(strMinute);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Start date option is displayed
	 * Date        : 10/09/2014 
	 * Author      : Sowmya
	 **********************************************************************************/
	public Report enterStartDate(String strDate) throws Exception {
		objWaitForElement.waitForElements(startDate, "xpath");
		this.page.element(startDate, "xpath").clearInputValue().sendKeys(strDate);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify End date option is displayed
	 * Date        : 10/09/2014 
	 * Author      : Sowmya
	 **********************************************************************************/
	public Report enterEndDate(String strTime) throws Exception {
		objWaitForElement.waitForElements(endDate, "xpath");
		this.page.element(endDate, "xpath").clearInputValue().sendKeys(strTime);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Resource report menu' page is displayed
	 * Date        : 11/09/2014 
	 * Author      : Sowmya
	 **********************************************************************************/
	public Report verifyResourceReportMenuPage() throws Exception {
		objWaitForElement.waitForElements(reousrceReportMenuPage, "xpath");
		assertTrue(this.page.element(reousrceReportMenuPage, "xpath").getOne()
				.isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to click on 'Resource Details' 
	* Date 			: 11/09/2014
	* Author 		: sowmya
	**********************************************************************************/
	public Report clickOnResourceDetails() throws Exception {
		objWaitForElement.waitForElement(resourceDetails, "xpath");
		this.page.element(resourceDetails, "xpath").getOne().sendKeys(Keys.ENTER);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Resource Detail Report' page is displayed
	 * Date        : 11/09/2014 
	 * Author      : Sowmya
	 **********************************************************************************/
	public Report verifyResourceDetailReportPage() throws Exception {
		objWaitForElement.waitForElements(resourceDetailReportPage, "xpath");
		assertTrue(this.page.element(resourceDetailReportPage, "xpath")
				.getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Resources:Select All(Check box) ' is displayed
	 * Date        : 11/09/2014 
	 * Author      : Sowmya
	 **********************************************************************************/
	public Report verifyResourceSelectAllCheckbox() throws Exception {
		objWaitForElement.waitForElements(resourceSelectAllCheckbox, "xpath");
		assertTrue(this.page.element(resourceSelectAllCheckbox, "xpath")
				.getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select 'Resources'
	 * Date        : 10/09/2014 
	 * Author      : Sowmya
	 **********************************************************************************/
	public Report selectResources(String strResourceValue) throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']//table/tbody/tr/td/input[@value='"
				+ strResourceValue + "']", "xpath");
		this.page
				.element(
						"//div[@id='mainContainer']//table/tbody/tr/td/input[@value='"
								+ strResourceValue + "']", "xpath").getOne()
				.click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Web Browser (HTML)' radio button
	 * Date        : 11/09/2014 
	 * Author      : Sinchana
	 **********************************************************************************/
	public Report verifyWebBrowserAndExcelReport() throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']//table[@summary='Data Input Form']/tbody/tr[4]/td[2]/text()[4]", "xpath");
		String strText = this.page.element("//div[@id='mainContainer']//table[@summary='Data Input Form']/tbody/tr[4]/td[2]/text()[4]", "xpath")
				.getOne().getText();
		assertTrue(strText.contains("Web Browser (HTML)"
				+ "\nExcel Report (XLSX) "));
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to click on 'Event Detail' link 
	* Date 			: 09/09/2014
	* Author 		: Renushree
	**********************************************************************************/
	public Report clickOnEventDetailLink() throws Exception {
		objWaitForElement.waitForElements(eventDetail, "linktext");
		this.page.element(eventDetail, "linktext").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to verify event detail report is displayed.
	* Date 			: 09/09/2014
	* Author 		: Renushree
	**********************************************************************************/
	public Report verEventDetailReportPgeIsDisplayed() throws Exception {
		objWaitForElement.waitForElements("//div[@id='topSubNav']/h1[contains(text(),'Event Detail Report (Step 1 of 2)')]", "xpath");
		assertTrue(this.page.element("//div[@id='topSubNav']/h1[contains(text(),'Event Detail Report (Step 1 of 2)')]", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to verify event detail report is displayed.
	* Date 			: 09/09/2014
	* Author 		: Renushree
	**********************************************************************************/
	public Report verEventDetailReportPge2IsDisplayed() throws Exception {
		objWaitForElement.waitForElements("//div[@id='topSubNav']/h1[contains(text(),'Event Detail Report (Step 2 of 2)')]", "xpath");
		assertTrue(this.page.element("//div[@id='topSubNav']/h1[contains(text(),'Event Detail Report (Step 2 of 2)')]", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select 'Excel Report (XLSX) ' radio button
	 * Date        : 11/09/2014 
	 * Author      : Sowmya
	 **********************************************************************************/
	public Report selectExcelReportRadioBtn() throws Exception {
		objWaitForElement.waitForElements(excelReportRadioBtn, "css");
		assertTrue(this.page.element(excelReportRadioBtn, "css")
				.isElementPresent());
		this.page.element(excelReportRadioBtn, "css").getOne().click();
		return this;
	}

	/**********************************************************************************
	* Description 	: This function is to verify event detail report is displayed.
	* Date 			: 09/09/2014
	* Author 		: Renushree
	**********************************************************************************/
	public Report verEnteredDatesAndPgeDetails(String strDate) throws Exception {
		objWaitForElement.waitForElements(startDateInStep2, "css");
		assertEquals(strDate, this.page.element(startDateInStep2, "css")
				.getOne().getAttribute("value"));
		assertEquals(strDate, this.page.element(endDateInStep2, "css").getOne()
				.getAttribute("value"));
		assertTrue(this.page.element(reportStartDate, "css").getOne().isDisplayed());
		assertTrue(this.page.element(reportEndDate, "css").getOne().isDisplayed());
		assertTrue(this.page.element(selectEvents, "xpath").getOne().isDisplayed());
		assertTrue(this.page.element(resources, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to select event 
	* Date 			: 09/09/2014
	* Author 		: Renushree
	**********************************************************************************/
	public Report selectEvent(String strEvent) throws Exception {
		objWaitForElement.waitForElements("//input[@value='" + strEvent + "']", "xpath");
		this.page.element("//input[@value='" + strEvent + "']", "xpath")
				.getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to enter report start date 
	* Date 			: 11/09/2014
	* Author 		: Renushree
	**********************************************************************************/
	public Report enterReportStartDate(String strDate) throws Exception {
		objWaitForElement.waitForElements(reportStartDate, "css");               
		this.page.element(reportStartDate, "css").clearInputValue().sendKeys(strDate);
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to enter report end date 
	* Date 			: 11/09/2014
	* Author 		: Renushree
	**********************************************************************************/
	public Report enterReportEndDate(String strDate) throws Exception {
		objWaitForElement.waitForElements(reportEndDate, "css"); 
		this.page.element(reportEndDate, "css").clearInputValue().sendKeys(strDate);
		this.page.element(startDateLabel, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to click on 'Status Reason Details' link 
	* Date 			: 15/09/2014
	* Author 		: Renushree
	**********************************************************************************/
	public Report clickOnStatusReasonDetailsLink() throws Exception {
		objWaitForElement.waitForElements(statusReasonDetail, "linktext"); 
		this.page.element(statusReasonDetail, "linktext").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to verify start and end date labels
	* Date 			: 12/09/2014
	* Author 		: Renushree
	**********************************************************************************/
	public Report verStartEndLabels() throws Exception {
		objWaitForElement.waitForElements(startDateLabel, "css"); 
		assertTrue(this.page.element(startDateLabel, "css").getOne().isDisplayed());
		assertTrue(this.page.element(endDateLabel, "css").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to verify cancel button
	* Date 			: 12/09/2014
	* Author 		: Renushree
	**********************************************************************************/
	public Report verCancelButton() throws Exception {
		objWaitForElement.waitForElements(cancel, "css"); 
		assertTrue(this.page.element(cancel, "css").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to verify status reason detail report is displayed.
	* Date 			: 15/09/2014
	* Author 		: Renushree
	**********************************************************************************/
	public Report verStatusReasonDetailReportPgeIsDisplayed() throws Exception {
		objWaitForElement.waitForElements("//div[@id='topSubNav']/h1[contains(text(),'Status Reason Detail Report (Step 1 of 3)')]", "xpath"); 
		assertTrue(this.page.element("//div[@id='topSubNav']/h1[contains(text(),'Status Reason Detail Report (Step 1 of 3)')]", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to select status type
	* Arguments		: strStatusType
	* Date 			: 15/09/2014
	* Author 		: Renushree
	**********************************************************************************/
	public Report selStatusType(String strStatusType) throws Exception {
		objWaitForElement.waitForElements(statusTypeDropDown, "css"); 
		this.page.element(statusTypeDropDown, "css").webElementToSelect()
				.selectByVisibleText(strStatusType);
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to select status reason
	* Arguments		: strStatusTypeVal, strStatusVal
	* Date 			: 15/09/2014
	* Author 		: Renushree
	**********************************************************************************/
	public Report selStatusReason(String strReasonVal, String strStatusVal)
			throws Exception {
		objWaitForElement.waitForElements("input[value='" + strStatusVal + ":" + strReasonVal
				+ "'][name='statusReasonID']", "css"); 
		this.page
				.element(
						"input[value='" + strStatusVal + ":" + strReasonVal
								+ "'][name='statusReasonID']", "css").getOne()
				.click();
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to verify status reason detail report is displayed.
	* Date 			: 15/09/2014
	* Author 		: Renushree
	**********************************************************************************/
	public Report verStatusReasonDetailReportPge2IsDisplayed() throws Exception {
		objWaitForElement.waitForElements("//div[@id='topSubNav']/h1[contains(text(),'Status Reason Detail Report (Step 2 of 3)')]", "xpath");
		assertTrue(this.page.element("//div[@id='topSubNav']/h1[contains(text(),'Status Reason Detail Report (Step 2 of 3)')]", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to verify status reason detail report is displayed.
	* Date 			: 15/09/2014
	* Author 		: Renushree
	**********************************************************************************/
	public Report verStatusReasonDetailReportPge3IsDisplayed() throws Exception {
		objWaitForElement.waitForElements("//div[@id='topSubNav']/h1[contains(text(),'Status Reason Detail Report (Step 3 of 3)')]", "xpath");
		assertTrue(this.page.element("//div[@id='topSubNav']/h1[contains(text(),'Status Reason Detail Report (Step 3 of 3)')]", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to click on 'Status Reason Summary' link 
	* Date 			: 15/09/2014
	* Author 		: Sowmya
	**********************************************************************************/
	public Report clickOnStatusReasonSummaryLink() throws Exception {
		objWaitForElement.waitForElements(statusReasonSummary, "linktext"); 
		this.page.element(statusReasonSummary, "linktext").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to click on 'Statewide Resource Details' 
	* Date 			: 15/09/2014
	* Author 		: Sinchana
	**********************************************************************************/
	public Report clickOnStatewideResourceDetails() throws Exception {
		objWaitForElement.waitForElements(statewideResourceDetails, "linktext");
		this.page.element(statewideResourceDetails, "linktext").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select 'Hospital'
	 * Date        : 15/09/2014 
	 * Author      : Sinchana
	 **********************************************************************************/
	public Report selectStandardResources(String[] strStandardResourcesValues) throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']//table/tbody/tr/td/input[@value='"
				+ strStandardResourcesValues[0] + "']", "xpath");
		for (int i = 0; i < strStandardResourcesValues.length; i++) {
			this.page
			.element(
					"//div[@id='mainContainer']//table/tbody/tr/td/input[@value='"
							+ strStandardResourcesValues[i] + "']", "xpath").getOne()
							.click();
		}
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to select 'Hospital'
	 * Date        : 15/09/2014 
	 * Author      : Sinchana
	 **********************************************************************************/
	public Report selectStandardStatus(String[] strStandardStatusValues) throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']//table/tbody/tr/td/input[@value='"
				+ strStandardStatusValues[0] + "']", "xpath");
		for (int i = 0; i < strStandardStatusValues.length; i++) {
			this.page
			.element(
					"//div[@id='mainContainer']//table/tbody/tr/td/input[@value='"
							+ strStandardStatusValues[i] + "']", "xpath").getOne()
							.click();
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Statewide Resource Detail Report' page is displayed
	 * Date        : 11/09/2014 
	 * Author      : Sinchana
	 **********************************************************************************/
	public Report verifyStatewideResourceDetailReportPage() throws Exception {
		objWaitForElement.waitForElements(statewideResourceDetailReportPage, "xpath");
		assertTrue(this.page.element(statewideResourceDetailReportPage, "xpath")
				.getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Next' button in resource detail page
	 * Date : 16/09/2014 
	 * Author : Sinchana
	 **********************************************************************************/
	public Report clickOnNextButtonInResourceDetailPage() throws Exception {
		objWaitForElement.waitForElements(nextButtonInResourceDetailPage, "css");
		this.page.element_wait(nextButtonInResourceDetailPage, "css").waitForElementEnable();
		this.page.element(nextButtonInResourceDetailPage, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select 'Data File, Comma-separated (CSV)' radio button
	 * Date        : 11/09/2014 
	 * Author      : Sowmya
	 **********************************************************************************/
	public Report selectDataFileCommaSepatatedCSVRadioBtn() throws Exception {
		objWaitForElement.waitForElements(dataFileCommaSeparatedCSVRadioBtn, "xpath");
		this.page.element(dataFileCommaSeparatedCSVRadioBtn, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to click on 'Status Detail' 
	* Date 			: 18/09/2014
	* Author 		: Renushree
	**********************************************************************************/
	public Report clickOnStatusDetail() throws Exception {
		objWaitForElement.waitForElements(statusDetail, "linktext");
		this.page.element(statusDetail, "linktext").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to verify status detail report is displayed.
	* Date 			: 18/09/2014
	* Author 		: Renushree
	**********************************************************************************/
	public Report verStatusDetailReportPgeIsDisplayed() throws Exception {
		objWaitForElement.waitForElements("//div[@id='topSubNav']/h1[contains(text(),'Status Detail Report (Step 1 of 2)')]", "xpath");
		assertTrue(this.page.element("//div[@id='topSubNav']/h1[contains(text(),'Status Detail Report (Step 1 of 2)')]", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to verify status detail report is displayed.
	* Date 			: 18/09/2014
	* Author 		: Renushree
	**********************************************************************************/
	public Report verStatusDetailReportPge2IsDisplayed() throws Exception {
		objWaitForElement
				.waitForElements(
						"//div[@id='topSubNav']/h1[text()='Status Detail Report (Step 2 of 2)']",
						"xpath");
		assertTrue(this.page.element("//div[@id='topSubNav']/h1[text()='Status Detail Report (Step 2 of 2)']",
						"xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to verify sttaus type in status detail report of 2nd page.
	* Date 			: 18/09/2014
	* Author 		: Renushree
	**********************************************************************************/
	public Report verStatusTypeInStatusDetailReportPge2(String strStatusType)
			throws Exception {
		objWaitForElement.waitForElements("//table[@summary='Data Input Form']/tbody/tr/td[2][text()='"
				+ strStatusType + "']", "xpath");
		assertTrue(this.page.element(
				"//table[@summary='Data Input Form']/tbody/tr/td[2][text()='"
						+ strStatusType + "']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to click on 'Status Summary' link 
	* Date 			: 18/09/2014
	* Author 		: Sowmya
	**********************************************************************************/
	public Report clickOnStatusSummaryLink() throws Exception {
		objWaitForElement.waitForElements(statusSummary, "linktext");
		this.page.element(statusSummary, "linktext").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'next step' button
	 * Date        : 18/09/2014 
	 * Author      : Sowmya
	 **********************************************************************************/
	public Report clickOnNextStepBtn() throws Exception {
		objWaitForElement.waitForElements(nextStepButton, "css");
		this.page.element(nextStepButton, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select 'Status type checkbox'
	 * Date        : 18/09/2014 
	 * Author      : Sowmya
	 **********************************************************************************/
	public Report selectStatusTypeCheckbox(String strStatusTypeValue)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']//table/tbody/tr/td/input[@value='"
				+ strStatusTypeValue + "']", "xpath");
		this.page
				.element(
						"//div[@id='mainContainer']//table/tbody/tr/td/input[@value='"
								+ strStatusTypeValue + "']", "xpath").getOne()
				.click();
		return this;
	}
	
	
	/**********************************************************************************
	* Description 	: This function is to click on 'Incoming Patient Notification Details' link
	* Date 			: 18/09/2014
	* Author 		: Anil
	**********************************************************************************/
	public Report clickOnIPNLink() throws Exception {
		objWaitForElement.waitForElements(ipNotification, "xpath");
		this.page.element(ipNotification, "xpath").getOne().click();
		return this;
	}
	
	
	/**********************************************************************************
	 * Description : This function is to verify Incoming Patient Notification Details Report page is displayed
	 * Date        : 19/09/2014 
	 * Author      : Anil
	 **********************************************************************************/
	public Report verrifyIncomingPatientNotificationPage() throws Exception {
		objWaitForElement.waitForElements(incomingPatientNotificationPage, "xpath");
		assertTrue(this.page.element(incomingPatientNotificationPage, "xpath")
				.getOne().isDisplayed());
		return this;
	}
	
	
	/**********************************************************************************
	 * Description : This function is to verify resource name is displayed
	 * Date        : 19/09/2014 
	 * Author      : Anil
	 **********************************************************************************/
	public Report verifyResourceNameIsDisplayed(String strResourceName) throws Exception {
		objWaitForElement.waitForElements("//table[@id='tbl_resourceID']/tbody/tr/td[2][text()='"+strResourceName+"']", "xpath");
		assertTrue(this.page.dynamicElement(strResourceName, "//table[@id='tbl_resourceID']/tbody/tr/td[2][text()='"+strResourceName+"']", "xpath")
				.getOne().isDisplayed());
		return this;
	}
	
	
	/**********************************************************************************
	 * Description : This function is to verify resource name is displayed
	 * Date        : 19/09/2014 
	 * Author      : Anil
	 **********************************************************************************/
	public Report verifyResourceNameNotDisplayed(String strResourceName) throws Exception {
		this.driver
		.manage()
		.timeouts()
		.implicitlyWait(WaitTimeConstants.WAIT_TIME_TOO_SMALL,
				TimeUnit.SECONDS);
		assertFalse(this.page.element("//table[@id='tbl_resourceID']/tbody/tr/td[2][text()='"+strResourceName+"']", "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		this.driver
		.manage()
		.timeouts()
		.implicitlyWait(WaitTimeConstants.WAIT_TIME_LONG,
				TimeUnit.SECONDS);
		return this;
	}
	
	
	/**********************************************************************************
	* Description 	: This function is to click on 'Filter' button 
	* Date 			: 19/09/2014
	* Author 		: Anil
	**********************************************************************************/
	public Report clickOnFilterButton() throws Exception {		
		objWaitForElement.waitForElements(filterButton, "xpath");
		this.page.element(filterButton, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select 'Status checkbox'
	 * Date        : 18/09/2014 
	 * Author      : Sowmya
	 **********************************************************************************/
	public Report selectStatusCheckbox(String strStatusesValue)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']//table/tbody/tr/td/input[@value='"
				+ strStatusesValue + "']", "xpath");
		this.page
				.element(
						"//div[@id='mainContainer']//table/tbody/tr/td/input[@value='"
								+ strStatusesValue + "']", "xpath").getOne()
				.click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Event snapshot report header'
	 * Date        : 07/10/2014 
	 * Author      : Sowmya
	 **********************************************************************************/
	public Report verifyHeadersInHTMLEventSnapshotReport(String strHeaderName[])
			throws Exception {
		objWaitForElement.waitForElements("//table/tbody/tr[1]/th[1+" + 0 + "][text()='"
				+ strHeaderName[0] + "']", "xpath");
		for (int i = 0; i < strHeaderName.length; i++) {

			assertTrue(this.page.element(
					"//table/tbody/tr[1]/th[1+" + i + "][text()='"
							+ strHeaderName[i] + "']", "xpath")
					.getOne().isDisplayed());
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Event snapshot report header'
	 * Date        : 07/10/2014 
	 * Author      : Sowmya
	 **********************************************************************************/
	public Report verifDataInHTMLEventSnapshotReport(String strData[])
			throws Exception {
		objWaitForElement.waitForElements("//table/tbody/tr[2]/td[text()='" + strData[0] + "']", "xpath");
		for(int i=1; i<=strData.length; i++){
			String str1 = this.page.element(
					"//table/tbody/tr[2]/td["+i+"]", "xpath").getOne().getText();
			assertTrue(strData[i-1].equals(str1));
		Thread.sleep(100);
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select resource name
	 * Date        : 19/09/2014 
	 * Author      : Anil
	 **********************************************************************************/
	public Report selectResourceName(String strResourceName) throws Exception {
		objWaitForElement.waitForElements("//table[@id='tbl_resourceID']/tbody/tr/td[2][text()='"+strResourceName+"']/preceding-sibling::td/input", "xpath");
		this.page.element("//table[@id='tbl_resourceID']/tbody/tr/td[2][text()='"+strResourceName+"']/preceding-sibling::td/input", "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on excel radio button
	 * Date        : 26/11/2014 
	 * Author      : Anil
	 **********************************************************************************/
	public Report clickOnExcelOption() throws Exception {
		objWaitForElement.waitForElements(excelOption, "css");
		this.page.element(excelOption, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select 'Resources'
	 * Arguments   : strSubResourceValue
	 * Date        : 10/12/2014 
	 * Author      : Renushree
	 **********************************************************************************/
	public Report verSubResourceIsNotDisplayed(String strSubResourceValue) throws Exception {
		assertFalse(this.page
		.element(
				"//div[@id='mainContainer']//table/tbody/tr/td/input[@value='"
						+ strSubResourceValue + "']", "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify resource name is displayed
	 * Date        : 19/09/2014 
	 * Author      : Anil
	 **********************************************************************************/
	public Report verifyResourceIsDisplayed(String strResourceValue) throws Exception {
		objWaitForElement.waitForElementByxpathSelector("//input[@name='resourceID'][@value='"+strResourceValue+"']");
		assertTrue(this.page.element("//input[@name='resourceID'][@value='"+strResourceValue+"']", "xpath")
				.getOne().isDisplayed());
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify resource name is not displayed
	 * Date        : 19/09/2014 
	 * Author      : Anil
	 **********************************************************************************/
	public Report verifyResourceIsNotDisplayed(String strResourceValue) throws Exception {
		assertFalse(this.page.element("//input[@name='resourceID'][@value='"+strResourceValue+"']", "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to click on 'Monthly statusSummary' link 
	* Date 			: 15/09/2014
	* Author 		: Anil
	**********************************************************************************/
	public Report clickOnMonthlyStatusSummaryLink() throws Exception {
		objWaitForElement.waitForElements(monthlyStatusAssessment, "linktext");
		this.page.element(monthlyStatusAssessment, "linktext").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to select status reason
	* Arguments		: 
	* Date 			: 15/09/2014
	* Author 		: Anil
	**********************************************************************************/
	public Report selStatuses(String strStatusVal)
			throws Exception {
		objWaitForElement.waitForElements("input[value='" + strStatusVal +"'][name='statusID']", "css");
		this.page
				.element(
						"input[value='" + strStatusVal +"'][name='statusID']", "css").getOne()
				.click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select (CSV)' radio button
	 * Date        : 11/09/2014 
	 * Author      : Anil
	 **********************************************************************************/
	public Report selectCSVRadioBtn() throws Exception {
		objWaitForElement.waitForElements(csvFormat, "xpath");
		this.page.element(csvFormat, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select resource name
	 * Date        : 06/01/2014 
	 * Author      : Anil
	 **********************************************************************************/
	public Report selectResourceValue(String strResourceValue) throws Exception {
		WebElement element = driver.findElement(By.xpath("//input[@value='" + strResourceValue
				+ "'][@name='resourceID']"));
		objWaitForElement.waitForElements("//input[@name='resourceID'][@value='"+strResourceValue+"']", "xpath");
		this.page.element("//input[@name='resourceID'][@value='"+strResourceValue+"']", "xpath").scrollDownTillElement(element);
		this.page.element("//input[@name='resourceID'][@value='"+strResourceValue+"']", "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify  resource Type DropDown is displayed
	 * Date        : 10/09/2014 
	 * Author      : Anil
	 **********************************************************************************/
	public Report verifyresourceTypeDropDownIsDisplayed() throws Exception {
		objWaitForElement.waitForElements(resourceTypeDropDown, "css");
		assertTrue(this.page.element(resourceTypeDropDown, "css")
				.getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify section Drop Down is displayed
	 * Date        : 10/09/2014 
	 * Author      : Anil
	 **********************************************************************************/
	public Report verifysectionDropDownIsDisplayed() throws Exception {
		objWaitForElement.waitForElements(sectionDropDown, "css");
		assertTrue(this.page.element(sectionDropDown, "css")
				.getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify standard Status Type DropDown is displayed
	 * Date        : 10/09/2014 
	 * Author      : Anil
	 **********************************************************************************/
	public Report verifystandardStatusTypeIsDisplayed() throws Exception {
		objWaitForElement.waitForElements(standardStatusTypeDropDown, "css");
		assertTrue(this.page.element(standardStatusTypeDropDown, "css")
				.getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify statusTypeName is displayed
	 * Date        : 10/09/2014 
	 * Author      : Anil
	 **********************************************************************************/
	public Report verifyStatusTypeNameIsDisplayed() throws Exception {
		objWaitForElement.waitForElements(statusTypeName, "css");
		assertTrue(this.page.element(statusTypeName, "css")
				.getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify searchButton is displayed
	 * Date        : 10/09/2014 
	 * Author      : Anil
	 **********************************************************************************/
	public Report verifysearchButtonIsDisplayed() throws Exception {
		objWaitForElement.waitForElements(searchButton, "css");
		assertTrue(this.page.element(searchButton, "css")
				.getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify showAllButton is displayed
	 * Date        : 10/09/2014 
	 * Author      : Anil
	 **********************************************************************************/
	public Report verifyshowAllButtonIsDisplayed() throws Exception {
		objWaitForElement.waitForElements(showAllButton, "css");
		assertTrue(this.page.element(showAllButton, "css")
				.getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify showAllButton is displayed
	 * Date        : 10/09/2014 
	 * Author      : Anil
	 **********************************************************************************/
	public Report verifOptionsAreDisplayed() throws Exception {
		this.verifyresourceTypeDropDownIsDisplayed();
		this.verifyshowAllButtonIsDisplayed();
		this.verifysearchButtonIsDisplayed();
		this.verifyStatusTypeNameIsDisplayed();
		this.verifystandardStatusTypeIsDisplayed();
		this.verifysectionDropDownIsDisplayed();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on search Button
	 * Date        : 10/09/2014 
	 * Author      : Anil
	 **********************************************************************************/
	public Report clickOnSearchButton() throws Exception {
		objWaitForElement.waitForElements(searchButton, "css");
		this.page.element(searchButton, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Status type is displayed
	 * Date        : 10/09/2014 
	 * Author      : Anil
	 **********************************************************************************/
	public Report verifyStatusTypesIsDisplayed(String strStatusTypes) throws Exception {
		objWaitForElement.waitForElements("//table/tbody/tr/td/a[contains(text(),'"+strStatusTypes+"')]", "xpath");
		assertTrue(this.page.element("//table/tbody/tr/td/a[contains(text(),'"+strStatusTypes+"')]", "xpath")
				.getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to enter status type name
	* Date 			: 11/09/2014
	* Author 		: Anil
	**********************************************************************************/
	public Report enterStatusTypeName(String strStatusTypes) throws Exception {
		objWaitForElement.waitForElements(statusTypeName, "css");
		this.page.element(statusTypeName, "css").clearInputValue().sendKeys(strStatusTypes);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on search Button
	 * Date        : 10/09/2014 
	 * Author      : Anil
	 **********************************************************************************/
	public Report selectStatusType(String strStatusTypeName) throws Exception {
		objWaitForElement.waitForElements("//table/tbody/tr/td[2]/a[contains(text(),'"+strStatusTypeName+"')]/parent::td/preceding-sibling::td/input", "xpath");
		this.page.element("//table/tbody/tr/td[2]/a[contains(text(),'"+strStatusTypeName+"')]/parent::td/preceding-sibling::td/input", "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to click on 'Form Detail' 
	* Date 			: 05/01/2015
	* Author 		: Renushree
	**********************************************************************************/
	public Report clickOnFormDetail() throws Exception {
		objWaitForElement.waitForElements(formDetail, "linktext");
		this.page.element(formDetail, "linktext").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'form detail Report' page is displayed
	 * Date        : 05/01/2015 
	 * Author      : Renushree
	 **********************************************************************************/
	public Report verifyFormDetailReportPage() throws Exception {
		objWaitForElement.waitForElements(formDetailRepPge, "xpath");
		assertTrue(this.page.element(formDetailRepPge, "xpath")
				.getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select form
	 * Date        : 05/01/2015 
	 * Author      : Renushree
	 **********************************************************************************/
	public Report selForm(String strform) throws Exception {
		objWaitForElement.waitForElements(formDropDown, "css");
		this.page.element(formDropDown, "css").webElementToSelect().selectByVisibleText(strform);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select (Xlsx)' radio button
	 * Date        : 05/01/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public Report selectXlsxRadioBtn() throws Exception {
		objWaitForElement.waitForElements(xlsxFormat, "css");
		this.page.element(xlsxFormat, "css").getOne().click();
		if(!this.page.element(xlsxFormat, "css").getOne().isSelected()){
			this.page.element(xlsxFormat, "css").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'form detail Report' page is displayed
	  * Date        : 05/01/2015 
	  * Author      : Anitha
	  **********************************************************************************/
	 public Report verifyAdminReportPage() throws Exception {
		 objWaitForElement.waitForElements(adminReportPage, "xpath");
	  assertTrue(this.page.element(adminReportPage, "xpath")
	    .getOne().isDisplayed());
	  return this;
	 }
	 
	 /**********************************************************************************
	 * Description  : This function is verify Admin Reoprt Links 
	 * Date    : 05/01/2015
	 * Author   : Anitha
	 **********************************************************************************/
	 public Report verifyAdminReportLinks() throws Exception {
		 objWaitForElement.waitForElements(roleRightGrid, "linktext");
	 assertTrue(this.page.element(roleRightGrid, "linktext").getOne().isDisplayed());
	 objWaitForElement.waitForElements(userWithNoRoleInRegion, "linktext");
	 assertTrue(this.page.element(userWithNoRoleInRegion, "linktext").getOne().isDisplayed());
	  return this;
	 }
	 /**********************************************************************************
	 * Description  : This function is to click on 'RoleRightGri' 
	 * Date    : 05/01/2015
	 * Author   : Anitha
	 **********************************************************************************/
	 public Report clickOnRoleRightGrid() throws Exception {
		 objWaitForElement.waitForElements(roleRightGrid, "linktext");
	  this.page.element(roleRightGrid, "linktext").getOne().click();
	  return this;
	 }
	 
	 /**********************************************************************************
	 * Description  : This function is to click on 'Users With No Role In Region' 
	 * Date    		: 12/01/2015
	 * Author   	: Renushree
	 **********************************************************************************/
	 public Report clickOnUsersWithNoRoleInRegion() throws Exception {
		 objWaitForElement.waitForElements(userWithNoRoleInRegion, "linktext");
		 this.page.element(userWithNoRoleInRegion, "linktext").getOne().click();
	  	 return this;
	 }
	 
	 /**********************************************************************************
	  * Description : This function is to verify 'Users With No Role In Region' page is displayed
	  * Date        : 12/01/2015 
	  * Author      : Renushree
	  **********************************************************************************/
	 public Report verifyUsersWithNoRoleInRegionPge() throws Exception {
		 objWaitForElement.waitForElements(usersWithNoRoleInRegionReportPge, "xpath");
		 assertTrue(this.page.element(usersWithNoRoleInRegionReportPge, "xpath")
				 .getOne().isDisplayed());
		 return this;
	 }
	 
	 /**********************************************************************************
	  * Description : This function is to select region in 'Users With No Role In Region' page
	  * Date        : 12/01/2015 
	  * Author      : Renushree
	  **********************************************************************************/
	public Report selRegInUsersWithNoRoleInRegionReportPge(String strRegName)
			throws Exception {
		objWaitForElement.waitForElement("//td[text()='" + strRegName
				+ "']/preceding-sibling::td/input");
		this.page
				.element(
						"//td[text()='" + strRegName
								+ "']/preceding-sibling::td/input", "xpath")
				.mouseOver();
		while(!this.page
				.element(
						"//td[text()='" + strRegName
								+ "']/preceding-sibling::td/input", "xpath")
				.getOne().isSelected()){
			this.page
			.element(
					"//td[text()='" + strRegName
							+ "']/preceding-sibling::td/input", "xpath")
			.getOne().click();
		}
		return this;
	}
	
	 /**********************************************************************************
	  * Description : This function is verify 'No forms were found in the specified time frame'
	  *       			message in Form Detail Report Page.
	  * Date        : 12-Jan-015
	  * Author      : Pallavi
	  **********************************************************************************/
	 public Report verifyNoFormsFoundInSpecifiedTimeFrameMsg() throws Exception {
		objWaitForElement.waitForElements(emsErrorTitle, "xpath");
	  this.page.element_wait(emsErrorTitle, "xpath").waitForVisibilityOfElement();
	  assertTrue(this.page.element(emsErrorTitle, "xpath").getOne().isDisplayed());
	  objWaitForElement.waitForElements(noFormsFoundMsg, "xpath");
	  assertTrue(this.page.element(noFormsFoundMsg, "xpath").getOne().isDisplayed());
	  return this;
	 }
	 
	 /**********************************************************************************
	  * Description : This function is verify Form name, Start Date and End Date in the 
	  * 			  HTML report generated
	  * Date        : 13-Jan-015
	  * Author      : Pallavi
	  **********************************************************************************/
	public Report verifyFormNameStartDateAndEndDate(String strFormName,
			String strStartDate, String strEndDate) throws Exception {
		 objWaitForElement.waitForElements("//table/tbody/tr/td[contains(text(),'Form')]/following-sibling::td[contains(text(),'"
					+ strFormName + "')]", "xpath");
		assertTrue(this.page.element(
				"//table/tbody/tr/td[contains(text(),'Form')]/following-sibling::td[contains(text(),'"
						+ strFormName + "')]", "xpath").getOne().isDisplayed());
		assertTrue(this.page.element(
				"//tr/td[text()='Start Date']/following-sibling::td[text()='"
						+ strStartDate + "']", "xpath").getOne().isDisplayed());
		assertTrue(this.page.element(
				"//tr/td[text()='End Date']/following-sibling::td[text()='"
						+ strEndDate + "']", "xpath").getOne().isDisplayed());
		return this;
	}
	
	 /**********************************************************************************
	  * Description : This function is verify Activation User, Submitted User and DeliveredTo in the 
	  * 			  HTML report generated
	  * Date        : 13-Jan-015
	  * Author      : Pallavi
	  **********************************************************************************/
	public Report verifyActivationUsrSubmittedUsrDeliveredTo(
			String strActivationUser, String SubmittedUser,
			String strDeliveredTo) throws Exception {
		 objWaitForElement.waitForElements("//thead/tr/th[3][text()='Activated By']", "xpath");
		assertTrue(this.page.element(
				"//thead/tr/th[3][text()='Activated By']", "xpath")
				.getOne().isDisplayed());
		assertTrue(this.page
				.element(
						"//tbody/tr[1]/td[3][text()='" + strActivationUser + "']",
						"xpath").getOne().isDisplayed());
		assertTrue(this.page.element("//thead/tr/th[7][text()='Completed By']",
				"xpath").isElementPresent());
		assertTrue(this.page.element(
				"//tbody/tr[1]/td[7][text()='" + SubmittedUser + "']", "xpath")
				.getOne().isDisplayed());
		assertTrue(this.page.element("//thead/tr/th[4][text()='Delivered To']",
				"xpath").getOne().isDisplayed());
		assertTrue(this.page.element(
				"//tbody/tr[1]/td[4][text()='" + strDeliveredTo + "']", "xpath")
				.getOne().isDisplayed());
		return this;
	}
	
	 /**********************************************************************************
	  * Description : This function is verify Question Label and Answers in the 
	  * 			  HTML report generated
	  * Date        : 13-Jan-015
	  * Author      : Pallavi
	  **********************************************************************************/
	public Report verifyQuestionAndAnswer(String strQuestion, String strAnswer)
			throws Exception {
		objWaitForElement.waitForElements("//thead/tr/th[text()='" + strQuestion + "']", "xpath");
		assertTrue(this.page.element(
				"//thead/tr/th[text()='" + strQuestion + "']", "xpath")
				.getOne().isDisplayed());
		objWaitForElement.waitForElements("//tbody/tr/td[text()='" + strAnswer + "']", "xpath");
		assertTrue(this.page.element(
				"//tbody/tr/td[text()='" + strAnswer + "']", "xpath")
				.getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify only single resource is dispalyed.
	 * Date        : 5/02/2015 
	 * Author      : Renushree
	 **********************************************************************************/
	public Report verOnlySingleResIsDisplayed(String strResourceValue) throws Exception {
		objWaitForElement.waitForElements("//div[@class='selectorData']/table[1]/tbody/tr","xpath");
		int intRowCount = this.page
		.element(
				"//div[@class='selectorData']/table[1]/tbody/tr","xpath").getXpathCount();
		for(int i = 1; i <= (intRowCount-2); i++){
			assertTrue(this.page.element("//div[@class='selectorData']/table[1]/tbody/tr["+(i+1)+"]/td/input[@value='"
						+ strResourceValue + "']", "xpath").isElementPresent(), "Resources other than selected resources are diaplyed");
		}
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is verify html Form Deatils report table headers and answers.
	  * Arguments	: arrHeaderNames, arrAnswers
	  * Date        : 18-Feb-2015
	  * Author      : Pallavi
	  **********************************************************************************/
	public Report verHTMLFormHeadersAndAnswers(String[] arrHeaderNames,
			String[] arrAnswers) throws Exception {
		objWaitForElement.waitForElements("//table[@class='report']/thead/tr/th","xpath");
		for (int intCount = 0; intCount <= (arrHeaderNames.length-1); intCount++) {
			System.out.println("intCount = " + intCount + ": " + arrHeaderNames[intCount]);
			String strHeader = "//table[@class='report']/thead/tr/th[" + (intCount+1)
							+ "][text()='" + arrHeaderNames[intCount] + "']";
			objWaitForElement.waitForElements(strHeader, "xpath");
			assertTrue(this.page.element(strHeader, "xpath").getOne().isDisplayed());
			System.out.println(arrAnswers[intCount]);
			String strText = this.page
					.element(
							"//table[@class='report'][2]/tbody/tr/td["
									+ (intCount + 1) + "]", "xpath").getOne()
					.getText();
			if (intCount == 1 || intCount == 5) {
				String strTime = arrAnswers[intCount];
				String strTime1 = objDT.addTimetoExisting(strTime, -1, "HH:mm");
				String strTime2 = objDT.addTimetoExisting(strTime, 1, "HH:mm");
				String strTime3 = objDT.addTimetoExisting(strTime, 2, "HH:mm");
				assertTrue(strText.contains(strTime)||strText.contains(strTime1) || strText.contains(strTime2) || strText.contains(strTime3));
			} else {
				assertTrue(strText.equals(arrAnswers[intCount]));
			}
		}
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to verify Monthly Status Assessment Report (Step 1 of 3) report is displayed.
	* Date 			: 18/09/2014
	* Author 		: Anil
	**********************************************************************************/
	public Report verMonthlyStatusAssessmentReportPgeIsDisplayed() throws Exception {
		objWaitForElement.waitForElements("//div[@id='topSubNav']/h1[contains(text(),'Monthly Status Assessment Report (Step 1 of 3)')]", "xpath");
		assertTrue(this.page.element("//div[@id='topSubNav']/h1[contains(text(),'Monthly Status Assessment Report (Step 1 of 3)')]", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to verify Monthly Status Assessment Report (Step 2 of 3) report is displayed.
	* Date 			: 18/09/2014
	* Author 		: Anil
	**********************************************************************************/
	public Report verMonthlyStatusAssessmentReportPge2IsDisplayed() throws Exception {
		objWaitForElement.waitForElements("//div[@id='topSubNav']/h1[contains(text(),'Monthly Status Assessment Report (Step 2 of 3)')]", "xpath");
		assertTrue(this.page.element("//div[@id='topSubNav']/h1[contains(text(),'Monthly Status Assessment Report (Step 2 of 3)')]", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to verify Monthly Status Assessment Report (Step 2 of 3) report is displayed.
	* Date 			: 18/09/2014
	* Author 		: Anil
	**********************************************************************************/
	public Report verMonthlyStatusAssessmentReportPge3IsDisplayed() throws Exception {
		objWaitForElement.waitForElements("//div[@id='topSubNav']/h1[contains(text(),'Monthly Status Assessment Report (Step 3 of 3)')]", "xpath");
		assertTrue(this.page.element("//div[@id='topSubNav']/h1[contains(text(),'Monthly Status Assessment Report (Step 3 of 3)')]", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to verify current month is selected by default
	* Date 			: 18/09/2014
	* Author 		: Anil
	**********************************************************************************/
	public Report verDefaultMonthIsSelected(String strCurrentMonth) throws Exception {
		objWaitForElement.waitForElements("//td[@class='emsLabel'][contains(text(),'Month')]/following-sibling::td/select/option[@selected][@value='"+strCurrentMonth+"']", "xpath");
		assertTrue(this.page.element("//td[@class='emsLabel'][contains(text(),'Month')]/following-sibling::td/select/option[@selected][@value='"+strCurrentMonth+"']", "xpath").getOne().isDisplayed());
		return this;
	}
	
	
	/**********************************************************************************
	* Description 	: This function is to verify current Year is selected by default
	* Date 			: 18/09/2014
	* Author 		: Anil
	**********************************************************************************/
	public Report verDefaultYearIsSelected(String strCurrentYear) throws Exception {
		objWaitForElement.waitForElements("//td[@class='emsLabel'][contains(text(),'Year')]/following-sibling::td/select/option[@selected][text()='"+strCurrentYear+"']", "xpath");
		assertTrue(this.page.element("//td[@class='emsLabel'][contains(text(),'Year')]/following-sibling::td/select/option[@selected][text()='"+strCurrentYear+"']", "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to verify current Year is selected by default
	* Date 			: 18/09/2014
	* Author 		: Anil
	**********************************************************************************/
	public Report verReportFormatIsDisplayed() throws Exception {
		objWaitForElement.waitForElements("//td[@class='emsLabel'][contains(text(),'Report Format:')]", "xpath");
		assertTrue(this.page.element("//td[@class='emsLabel'][contains(text(),'Report Format:')]", "xpath").getOne().isDisplayed());
		return this;
	}
	
	
	/**********************************************************************************
	 * Description : This function is to verify CSV radio button is displayed
	 * Date        : 11/09/2014 
	 * Author      : Anil
	 **********************************************************************************/
	public Report verifyCSVRadioBtn() throws Exception {
		objWaitForElement.waitForElements(csvFormat, "xpath");
		assertTrue(this.page.element(csvFormat, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify HTML radio button is displayed
	 * Date        : 11/09/2014 
	 * Author      : Anil
	 **********************************************************************************/
	public Report verifyHTMLRadioBtn() throws Exception {
		objWaitForElement.waitForElements(htmlFormat, "xpath");
		assertTrue(this.page.element(htmlFormat, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to Monthly Assesment Report details in Page1
	 * Date        : 11/09/2014 
	 * Author      : Anil
	 **********************************************************************************/
	public Report verifyDetailsInMonthlyStatusAssesmentPage1(String strCurrentMonth, String strCurrentYear) throws Exception {
		if(strCurrentMonth.startsWith("0")){
			strCurrentMonth = strCurrentMonth.replace("0", "");
		}
		this.verMonthlyStatusAssessmentReportPgeIsDisplayed();
		this.verDefaultMonthIsSelected(strCurrentMonth);
		this.verDefaultYearIsSelected(strCurrentYear);
		this.verReportFormatIsDisplayed();
		this.verifyCSVRadioBtn();
		this.verifyHTMLRadioBtn();
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to select status reason
	* Arguments		: 
	* Date 			: 15/09/2014
	* Author 		: Anil
	**********************************************************************************/
	public Report verifyStatuses(String strStatusVal)
			throws Exception {
		objWaitForElement.waitForElements("input[value='" + strStatusVal +"'][name='statusID'][class='checkbox']", "css");
		assertTrue(this.page
				.element(
						"input[value='" + strStatusVal +"'][name='statusID'][class='checkbox']", "css")
				.getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Monthly assesment report'
	 * Date        : 07/10/2014 
	 * Author      : Anil
	 **********************************************************************************/
	public Report verifyHeadersInHTMLMonthlyAssesmentReport(String strHeaderName[])
			throws Exception {
		objWaitForElement.waitForElements("//html/body/h1[text()='"+strHeaderName[0]+"']", "xpath");
		for (int i = 0; i < strHeaderName.length; i++) {

			assertTrue(this.page.element(
					"//html/body/h1[text()='"+strHeaderName[i]+"']", "xpath")
					.isElementPresent());
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Monthly assesment report'
	 * Date        : 07/10/2014 
	 * Author      : Anil
	 **********************************************************************************/
	public Report verifyRSAndSTInHTMLMonthlyAssesmentReport(String strHeaderName[])
			throws Exception {
		objWaitForElement.waitForElements("//html/body/h2[text()='"+strHeaderName[0]+"']", "xpath");
		for (int i = 0; i < strHeaderName.length; i++) {

			assertTrue(this.page.element(
					"//html/body/h2[text()='"+strHeaderName[i]+"']", "xpath")
					.isElementPresent());
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Monthly assesment report'
	 * Date        : 07/10/2014 
	 * Author      : Anil
	 **********************************************************************************/
	public Report verifyFooterHTMLMonthlyAssesmentReport(String strTime, String strTime1)
			throws Exception {
		objWaitForElement.waitForElements("//div[@class='footer']/div[@class='left'][text()='EMResource']", "xpath");
		assertTrue(this.page.element(
				"//div[@class='footer']/div[@class='left'][text()='EMResource']", "xpath")
				.getOne().isDisplayed());
		assertTrue((this.page.element(
				"//div[@class='footer']/div[@class='right'][text()='Report Created: "+strTime+"']", "xpath")
				.getOne().isDisplayed())||((this.page.element(
						"//div[@class='footer']/div[@class='right'][text()='Report Created: "+strTime1+"']", "xpath")
						.getOne().isDisplayed())));
		return this;
	}
	
	 /**********************************************************************************
	  * Description : This function is verify view name in region view html report
	  * Date        : 03-Mar-2015
	  * Author      : Renushree
	  **********************************************************************************/
	public Report verifyViewNameInRegionViewHtmlReport(String strViewName,
			String strReportDateAndTime) throws Exception {
		objWaitForElement.waitForElements("//h2[text()='" + strReportDateAndTime + " " + strViewName
				+ "']", "xpath");
		assertTrue(this.page.element(
				"//h2[text()='" + strReportDateAndTime + " " + strViewName
				+ "']", "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is verify html Form Deatils report table headers and answers in region view report.
	  * Arguments	: arrHeaderNames, arrAnswers
	  * Date        : 03-Mar-2015
	  * Author      : Renushree
	  **********************************************************************************/
	public Report verHTMLFormHeadersAndAnswersInRegionViewRep(String[] arrHeaderNames,
			String[] arrAnswers) throws Exception {
		for (int intCount = 0; intCount <= (arrHeaderNames.length-1); intCount++) {
			System.out.println("intCount = " + intCount + ": " + arrHeaderNames[intCount]);			
			String strHeader = this.page.element("//div[@class='snapshotTable']/table/tbody/tr/th[" + (intCount+1)
					+ "]", "xpath").getOne().getText();
			assertTrue(strHeader.equals(arrHeaderNames[intCount]));
			System.out.println(arrAnswers[intCount]);
			
			String strText = this.page
					.element(
							"//div[@class='snapshotTable']/table/tbody/tr/td["
									+ (intCount + 1) + "]", "xpath").getOne()
					.getText();
			assertTrue(strText.equals(arrAnswers[intCount]));
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Event snapshot report header'
	 * Date        : 07/10/2014 
	 * Author      : Sowmya
	 **********************************************************************************/
	public Report verifSummaryInHTMLEventSnapshotReport(String strData[])
			throws Exception {
		objWaitForElement.waitForElements("//table/tbody/tr[3]/td[text()='" + strData[0] + "']", "xpath");
		for (String str : strData) {

			assertTrue(this.page.element(
					"//table/tbody/tr[3]/td[text()='" + str + "']", "xpath")
					.isElementPresent());
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Event snapshot report header'
	 * Date        : 07/10/2014 
	 * Author      : Sowmya
	 **********************************************************************************/
	public Report verifEventNameInHTMLEventSnapshotReport(String strEventName,
			String strmin) throws Exception {
		objWaitForElement.waitForElements("//html/body/h2[text()='" + strEventName + " " + strmin + "']",
				"xpath");
		assertTrue(this.page.element(
				"//html/body/h2[text()='" + strEventName + " " + strmin + "']",
				"xpath").getOne().isDisplayed());
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to verify html report for event snapshot.
	  * Arguments	: arrHeaderNames, arrAnswers, summaryRow
	  * Date        : 04-Mar-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public Report verHTMLFormHeadersAndAnswersInEventSnapshotReport(
			String[] arrHeaderNames, String[] arrAnswers, String[] summaryRow)
			throws Exception {
		objWaitForElement.waitForElements("//table/tbody/tr/th["
					+ (0 + 1) + "][contains(text(),'" + arrHeaderNames[0]
					+ "')]",
				"xpath");
		for (int intCount = 0; intCount <= (arrHeaderNames.length - 1); intCount++) {
			System.out.println("intCount = " + intCount + ": "
					+ arrHeaderNames[intCount]);
			String strHeader = "//table/tbody/tr/th["
					+ (intCount + 1) + "][contains(text(),'" + arrHeaderNames[intCount]
					+ "')]";
			assertTrue(this.page.element(strHeader, "xpath").isElementPresent());
			System.out.println(arrAnswers[intCount]);
			String strText = this.page
					.element(
							"//table/tbody/tr[2]/td["
									+ (intCount + 1) + "]", "xpath").getOne()
					.getText();
			assertTrue(strText.equals(arrAnswers[intCount]), strText + " & " + arrAnswers[intCount]
					+ " are not Equal");
			System.out.println(summaryRow[intCount]);
			String strText1 = this.page
					.element(
							"//table/tbody/tr[3]/td["
									+ (intCount + 1) + "]", "xpath").getOne()
					.getText();
			assertTrue(strText1.equals(summaryRow[intCount]), strText1 + " & " + summaryRow[intCount]
					+ " are not Equal");
		}
		return this;
	}
	
	/*********************************************************************************************************************
	  * Description : This function is verify html Form Deatils report table headers and answers in region default report.
	  * Arguments	: arrHeaderNames, arrAnswers
	  * Date        : 04-Mar-2015
	  * Author      : Sowmya
	  ********************************************************************************************************************/
	public Report verHTMLFormHeadersAndAnswersInRegionDefaultRep(
			String[] arrHeaderNames, String[] arrAnswers) throws Exception {
		for (int i = 1; i < arrHeaderNames.length; i++) {
			String j = arrHeaderNames[0];
			objWaitForElement
					.waitForElements(
							"//table/tbody/tr/th[contains(text(),'" + j
									+ "')]/following-sibling::th[" + i
									+ "][contains(text(),'" + arrHeaderNames[i]
									+ "')]", "xpath");
			assertTrue(this.page.element(
					"//table/tbody/tr/th[contains(text(),'" + j
							+ "')]/following-sibling::th[" + i
							+ "][contains(text(),'" + arrHeaderNames[i] + "')]",
					"xpath").isElementPresent());
		}
		for (int k = 1; k < arrAnswers.length; k++) {
			String l = arrAnswers[0];
			String strValue = this.page
					.element(
							"//table/tbody/tr/td[contains(text(),'" + l
									+ "')]/following-sibling::td[" + k + "]",
							"xpath").getOne().getText();
			assertEquals(arrAnswers[k].trim(), strValue.trim());
		}
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to click on 'Form Summary' link. 
	* Date 			: 05-Mar-2015
	* Author 		: Pallavi
	**********************************************************************************/
	public Report clickOnFormSummary() throws Exception {
		objWaitForElement.waitForElements(formSummaryReport, "xpath");
		assertTrue(this.page.element(formSummaryReport, "xpath").isElementPresent());
		this.page.element(formSummaryReport, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'form Summary Report' page is displayed
	 * Date        : 05-Mar-2015
	 * Author 	   : Pallavi
	 **********************************************************************************/
	public Report verifyFormSummaryReportPage() throws Exception {
		objWaitForElement.waitForElements(formSummaryRepPage, "xpath");
		assertTrue(this.page.element(formSummaryRepPage, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to verify 'Incoming Patient Notification Details' link is not displayed
	* Date 			: 18/09/2014
	* Author 		: Anil
	**********************************************************************************/
	public Report verifyIPNLinkIsNotDisplayed() throws Exception {
		assertFalse(this.page.element(ipNotification, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**************************************************************
	 * Description : This function is to click on PDF radio button.
	 * Date        : 12/03/2015 
	 * Author      : Rahul
	 **************************************************************/
	public Report clickOnPDFOption() throws Exception {
		objWaitForElement.waitForElements(pdfOption, "css");
		this.page.element(pdfOption, "css").getOne().click();
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify 'form detail Report- Step 2' page is displayed
	 * Date        : 13/03/2015 
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Report verifyFormDetailReportstep2Page() throws Exception {
		Thread.sleep(5000);
		objWaitForElement.waitForElements(formDetailRepPgeStep2, "xpath");
		assertTrue(this.page.element(formDetailRepPgeStep2, "xpath")
				.isElementPresent());
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify "Include forms with the following users" section in 'form detail Report- Step 2' page.
	 * Date        : 13/03/2015 
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Report verifyIncludeformswiththefollowingUsersSection() throws Exception {
		objWaitForElement.waitForElements("//tbody/tr/td[text()='Only include forms with the following users:']", "xpath");
		assertTrue(this.page.element("//tbody/tr/td[text()='Only include forms with the following users:']", "xpath")
				.getOne().isDisplayed());
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify "Include forms with the following resources" section in 'form detail Report- Step 2' page.
	 * Date        : 13/03/2015 
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Report verifyIncludeformswiththefollowingResourceSection() throws Exception {
		objWaitForElement.waitForElements("//tbody/tr/td[text()='Only include forms with the following resources:']", "xpath");
		assertTrue(this.page.element("//tbody/tr/td[text()='Only include forms with the following resources:']", "xpath")
				.getOne().isDisplayed());
		return this;
	}
	 /**********************************************************************************
	  * Description : This function is to select user in 'form detail Report- Step 2' page.
	  * Date        : 13/03/2015 
	 * Author       : Hanumegowda
	  **********************************************************************************/
	public Report selUserInFormDetailReportStep2(String strUserName)
			throws Exception {
		String elementID = "input[value='"+strUserName+"']";
		objWaitForElement.waitForElements(elementID, "css");
		this.page.element(elementID, "css").mouseOver();
		this.page.element(elementID, "css").getOne().click();
		return this;
	}
	
	/**************************************************************
	 * Description : This function is to click on filter in form report
	 * Date        : 13/03/2015 
	 * Author      : Renushree
	 **************************************************************/
	public Report clickOnFilterInFormRep() throws Exception {
		objWaitForElement.waitForElements(filterInFormRep, "css");
		assertTrue(this.page.element(filterInFormRep, "css").isElementPresent());
		this.page.element(filterInFormRep, "css").getOne().click();
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to verify html report of 'other region view' snapshot.
	  * Arguments	: arrHeaderNames, arrAnswers, summaryRow
	  * Date        : 23-Mar-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public Report verHTMLFormHeadersAndAnswersInOtherRegionViewSnapshotReport(
			String[] arrHeaderNames, String[] arrAnswers, String[] statustypes, String resource, String lastupdate)
			throws Exception {
		for (int intCount = 0; intCount <= (arrHeaderNames.length - 1); intCount++) {
			System.out.println("intCount = " + intCount + ": "
					+ arrHeaderNames[intCount]);
			String strHeader = "//th[contains(text(),'"+arrHeaderNames[0]+"')]/../th["
					+ (intCount + 1) + "][contains(text(),'" + arrHeaderNames[intCount]
					+ "')]";
			objWaitForElement.waitForElements(strHeader, "xpath");
			assertTrue(this.page.element(strHeader, "xpath").getOne().isDisplayed());
		}
		assertTrue(this.page.element("//table/tbody//td[contains(text(),'"+resource+"')]","xpath").getOne().isDisplayed());

		for(int intCount1 = 0; intCount1 <= (arrAnswers.length - 1); intCount1++ ) {
					String strText = this.page.element("//th[contains(text(),'"+arrHeaderNames[0]+"')]/../..//tr["+(intCount1+2)+"]/td[2]","xpath").getOne().getText();
					String strText1 = this.page.element("//th[contains(text(),'"+arrHeaderNames[0]+"')]/../..//tr["+(intCount1+2)+"]/td[3]","xpath").getOne().getText();
					String strText2 = this.page.element("//th[contains(text(),'"+arrHeaderNames[0]+"')]/../..//tr["+(intCount1+2)+"]/td[4]","xpath").getOne().getText();
					String strText3 = this.page.element("//th[contains(text(),'"+arrHeaderNames[0]+"')]/../..//tr["+(intCount1+2)+"]/td[5]","xpath").getOne().getText();
					assertTrue(strText.equals(statustypes[intCount1]));
					assertTrue(strText1.equals(arrAnswers[intCount1]));
					assertTrue(strText2.equals(""));
					assertTrue(strText3.contains(lastupdate));
					
				}
				
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is verify html Form Deatils report table headers and answers.
	  * Arguments	: arrHeaderNames, arrAnswers
	  * Date        : 18-Feb-2015
	  * Author      : Renushree
	  **********************************************************************************/
	public Report verHTMLFormHeadersAndAnswersForInvalidDateRange(String[] arrHeaderNames,
			String[] arrAnswers) throws Exception {
		
		for (int intCount = 0; intCount <= (arrHeaderNames.length-1); intCount++) {
			System.out.println("intCount = " + intCount + ": " + arrHeaderNames[intCount]);
			String strHeader = "//table[@class='report']/thead/tr/th[" + (intCount+1)
							+ "][text()='" + arrHeaderNames[intCount] + "']";
			objWaitForElement.waitForElements(strHeader, "xpath");
			assertTrue(this.page.element(strHeader, "xpath").isElementPresent());
			System.out.println(arrAnswers[intCount]);
			String strText = this.page
					.element(
							"//table[@class='report'][2]/tbody/tr/td["
									+ (intCount + 1) + "]", "xpath").getOne()
					.getText();
			assertTrue(strText.equals(arrAnswers[intCount]));
		}
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to verify current form is not displayed
	* Date 			: 18/09/2014
	* Author 		: Anil
	**********************************************************************************/
	public Report verifyFormIsNotDisplayed()
			throws Exception {
		assertFalse(this.page.element(
				"//select[@name='questionaireID']/option[2]", "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is verify view name in region view html report
	  * Date        : 03-Mar-2015
	  * Author      : sangappa.k
	  **********************************************************************************/
	public Report verifyRegionDefaultHtmlReport(String strReportDateAndTime)
			throws Exception {
		objWaitForElement.waitForElements(
				"//h2[contains(text(),'" + strReportDateAndTime
						+ " Region Default')]", "xpath");
		assertTrue(this.page
				.element(
						"//h2[contains(text(),'" + strReportDateAndTime
						+ " Region Default')]", "xpath")
				.getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is verify view name in region view html report
	  * Date        : 03-Mar-2015
	  * Author      : Anil
	  **********************************************************************************/
	public Report verifyErrorMessageInFormSummaryPage() throws Exception {
		objWaitForElement.waitForElements(errorTitle, "xpath");
		assertTrue(this.page.element(errorMessage, "xpath").isElementPresent());
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to click on next button
	 * Date        : 10/09/2014 
	 * Author      : Sowmya
	 **********************************************************************************/
	public Report clickOnCancelBtn() throws Exception {
		objWaitForElement.waitForElements(cancelButton, "css");
		this.page.element(cancelButton, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'form Summary Report' page is displayed
	 * Date        : 05-Mar-2015
	 * Author 	   : Pallavi
	 **********************************************************************************/
	public Report verifyFormReportsMenuPage() throws Exception {
		objWaitForElement.waitForElements(formReportsMenuPage, "xpath");
		assertTrue(this.page.element(formReportsMenuPage, "xpath").getOne().isDisplayed());
		return this;
	}

	/**********************************************************************************
	  * Description : This function is verify error message when future start and end dates are selected
	  * Arguments	: None
	  * Date        : 18-Feb-2015
	  * Author      : Renushree
	  **********************************************************************************/
	public Report verErrorWhenFutureStartAndEndDateSelected() throws Exception {
		assertTrue(
				this.page
						.element(
								"//div[@class='emsError']/ul/li[text()='Start date may not be later than today.']",
								"xpath").isElementPresent(),
				"Error message not displayed");
		assertTrue(
				this.page
						.element(
								"//div[@class='emsError']/ul/li[text()='End date may not be later than today.']",
								"xpath").isElementPresent(),
				"Error message not displayed");
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to verify Form detail report page elements.
	* Date 			: 09/09/2014
	* Author 		: Renushree
	**********************************************************************************/
	public Report verFormDetailPageElements() throws Exception {
		objWaitForElement.waitForElements(reportStartDate, "css");
		assertTrue(this.page.element(reportStartDate, "css").getOne().isDisplayed());
		assertTrue(this.page.element(reportEndDate, "css").getOne().isDisplayed());
		assertTrue(this.page.element(xlsxFormat, "css").isElementPresent());
		assertTrue(this.page.element(htmlFormat, "xpath").isElementPresent());
		assertTrue(this.page.element(filterButton, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to verify Form detail report page buttons.
	* Date 			: 09/09/2014
	* Author 		: Renushree
	**********************************************************************************/
	public Report verFormDetailPageButtons() throws Exception {
		objWaitForElement.waitForElements(generateReportBtn, "xpath");
		assertTrue(this.page.element(generateReportBtn, "xpath").isElementPresent());
		assertTrue(this.page.element(cancelButton, "css").isElementPresent());
		return this;
	}

	
	/**********************************************************************************
	* Description 	: This function is to verify status detail report is displayed.
	* Date 			: 18/09/2014
	* Author 		: Renushree
	**********************************************************************************/
	public Report verStatusSummeryReportPgeIsDisplayed() throws Exception {
		objWaitForElement.waitForElements(statusSummerypage, "xpath");
		assertTrue(this.page.element(statusSummerypage, "xpath").isElementPresent());
		return this;
	}	
	
	/**********************************************************************************
	* Description 	: This function is to click on select all status Typs cheack boxs in status summery page.
	* Date 			: 30/Apr/2015
	* Author 		: Sangappa.k
	**********************************************************************************/
	public Report selectAllStatustypesChkBox() throws Exception {
		objWaitForElement.waitForElements(allST, "xpath");
		this.page.element(allST, "xpath").getOne().click();
		return this;
	}		
	
	/**********************************************************************************
	 * Description : This function is to verifiy event status types not dispayed in report summery page
	 * Date        : 30/Apr/2015 
	 * Author      : Sangappa.k
	 **********************************************************************************/
	public Report verEventStatusTypeNotDisplayed(String strStatusTypeValue)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']//table/tbody/tr/td/input[@value='"
				+ strStatusTypeValue + "']", "xpath");
		assertFalse(this.page
				.element(
						"//div[@id='mainContainer']//table/tbody/tr/td/input[@value='"
								+ strStatusTypeValue + "']", "xpath").isElementPresent());	
		return this;
	}

	
	/**********************************************************************************
	 * Description : This function is to verify Event snapshot summary table status types
	 * Date        : 28/04/2015 
	 * Author      : Renushree
	 **********************************************************************************/
	public Report verifSummaryTable(String strStatusType, String strValue)
			throws Exception {
	objWaitForElement.waitForElements("//table[2]/tbody/tr/td[text()='" + strStatusType + "']", "xpath");
		assertTrue(this.page.element(
				"//table[2]/tbody/tr/td[text()='" + strStatusType + "']/parent::tr/td[2][text()='"+strValue+"']/parent::tr/preceding-sibling::tr/th[text()='Status Type Summary']", "xpath")
				.isElementPresent());
	return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Event snapshot summary table status types is not displayed
	 * Date        : 28/04/2015 
	 * Author      : Renushree
	 **********************************************************************************/
	public Report verifSTNotAvlInSummaryTable(String strData)
			throws Exception {
		assertFalse(this.page.element(
				"//table[2]/tbody/tr/td[text()='" + strData + "']/parent::tr/preceding-sibling::tr/th[text()='Status Type Summary']", "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
	return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify event is not displayed
	 * Date        : 30/04/2015 
	 * Author      : Renushree
	 **********************************************************************************/
	public Report verEventIsNotDisplayed(String strEventName) throws Exception {
		assertFalse(this.page.element(
				"//div[@id='mainContainer']//table/tbody/tr/td[4][text()='"
						+ strEventName + "']", "xpath").isElementPresent(
				WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify event is  displayed
	 * Date        : 30/04/2015 
	 * Author      : Renushree
	 **********************************************************************************/
	public Report verEventIsDisplayed(String strEventName) throws Exception {
		assertTrue(this.page.element(
				"//div[@id='mainContainer']//table/tbody/tr/td[4][text()='"
						+ strEventName + "']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify error message when mandatory data not provided.
	 * Date        : 11/05/2015 
	 * Author      : Renushree
	 **********************************************************************************/
	public Report verErrorWhenMandatoryDataNtProvided(String strErrorMsg)
			throws Exception {
		objWaitForElement.waitForElements(
				"//div[@class='emsError']/ul/li[text()='" + strErrorMsg + "']",
				"xpath");
		assertTrue(this.page.element(
				"//div[@class='emsError']/ul/li[text()='" + strErrorMsg + "']",
				"xpath").isElementPresent());
		return this;
	}
	/**********************************************************************************
	* Description : This function is to verify Application Usage Reports Menu Page
	* Date 		  : 5/15/2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public Report verifyApplicationUsageReportsMenuPage()
			throws Exception {
		objWaitForElement
				.waitForElements(strApplicationUsageReportsMenu, "css");
		assertEquals(this.page.element(strApplicationUsageReportsMenu, "css")
				.getOne().getText(), "Application Usage Reports Menu");
		return this;
	}

	/**********************************************************************************
	* Description : This function is to click on Normal Usage under Application Usage Reports Menu
	* Date 		  : 5/15/2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public Report clickOnNormalUsage()
			throws Exception {
		objWaitForElement.waitForElements(strNormalUsage,
				"xpath");
		assertTrue(this.page.element(strNormalUsage, "xpath")
				.isElementPresent());
		this.page.element(strNormalUsage, "xpath").getOne()
				.click();
		return this;
	}
	/**********************************************************************************
	* Description : This function is to verify Application Usage Reports Menu  
	*                Non-Administrative page
	* Date 		  : 5/15/2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public Report verifyAppUsgNonAdmPage()
			throws Exception {
		objWaitForElement.waitForElements(strAppUsageRprtsNonAdm, "xpath");

		assertEquals(this.page.element(strAppUsageRprtsNonAdm, "xpath")
				.getOne().getText(),
				"Application Usage Report - Non-Administrative");
		assertTrue(this.page.element(startDate1, "xpath").isElementPresent());
		assertTrue(this.page.element(endDate1, "xpath").isElementPresent());

		return this;
	}
	/**********************************************************************************
	* Description : This function is to verify Error Msg without entering the start and end dates
	* Date 		  : 5/15/2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public Report verErrorMsgWithoutSatrtAndEndDate()
			throws Exception {
		objWaitForElement.waitForElements(strError, "xpath");

		assertEquals(this.page.element(strError, "xpath").getOne().getText(),
				"The following errors occurred on this page:");
		assertEquals(this.page.element(strStrtDateText, "xpath").getOne()
				.getText(), "Start date is required.");
		assertEquals(this.page.element(strEndDateText, "xpath").getOne()
				.getText(), "End date is required.");

		return this;
	}
	/**********************************************************************************
	* Description : This function is to click on Generate Report 
	* Date 		  : 5/15/2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public Report clickOnGenerateReportBtn1()
			throws Exception {
		objWaitForElement.waitForElements(strReportBtn, "xpath");
		this.page.element(strReportBtn, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Application Usage Reports' is displayed.
	 * Date        : 15/05/2015 
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Report verApplicationUsageReportsIsDisplayed() throws Exception {
		objWaitForElement.waitForElements(applicationUsageReports, "xpath");
		assertTrue(this.page.element(applicationUsageReports, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Application Usage Reports' is not displayed.
	 * Date        : 15/05/2015 
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Report verApplicationUsageReportsIsNotDisplayed() throws Exception {
		assertFalse(this.page.element(applicationUsageReports, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Application Usage Reports' link.
	 * Date        : 15/05/2015 
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public Report clickOnApplicationUsageReports() throws Exception {
		objWaitForElement.waitForElements(applicationUsageReports, "xpath");
		this.page.element(applicationUsageReports, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on Generate Report 
	* Date 		  : 26/Feb/2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Report verNoformsfoundinspecifieddaterangeErrMsgInHtml()
			throws Exception {
		objWaitForElement.waitForElements(noFormsFoundMsg1, "xpath");
		this.page.element(noFormsFoundMsg1, "xpath").isElementPresent();
		return this;
	}
	/**********************************************************************************
	* Description : This function is to verify Error Msg "End date may not be later than today".
	* Date 		  : 5/19/2015
	* Author 	  : Sangapp.k
	**********************************************************************************/
	public Report verErrorTextStarDateMayNoteLaterThanToday()
			throws Exception {
		objWaitForElement.waitForElements(strError2, "xpath");

		assertEquals(this.page.element(strError2, "xpath").getOne().getText(),
				"Start date may not be later than end date.");
		
		return this;
	}	
	
	/**********************************************************************************
	 * Description : This function is to verify 'Status snapshot report' page is displayed
	 * Date        : 04-Jun-2015
	 * Author 	   : Renushree
	 **********************************************************************************/
	public Report verifyStatusSnapShotPage() throws Exception {
		objWaitForElement.waitForElements(statusSnapshotPage, "xpath");
		assertTrue(this.page.element(statusSnapshotPage, "xpath").getOne()
				.isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Status reason summary page 1 of 3' page is displayed
	 * Date        : 04-Jun-2015
	 * Author 	   : Renushree
	 **********************************************************************************/
	public Report verifyStatusReasonSummaryPage1() throws Exception {
		objWaitForElement.waitForElements(statusReasonSummaryRepPage1, "xpath");
		assertTrue(this.page.element(statusReasonSummaryRepPage1, "xpath").getOne()
				.isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Status reason summary page 2 of 3' page is displayed
	 * Date        : 04-Jun-2015
	 * Author 	   : Renushree
	 **********************************************************************************/
	public Report verifyStatusReasonSummaryPage2() throws Exception {
		objWaitForElement.waitForElements(statusReasonSummaryRepPage2, "xpath");
		assertTrue(this.page.element(statusReasonSummaryRepPage2, "xpath").getOne()
				.isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Status reason summary page 3 of 3' page is displayed
	 * Date        : 04-Jun-2015
	 * Author 	   : Renushree
	 **********************************************************************************/
	public Report verifyStatusReasonSummaryPage3() throws Exception {
		objWaitForElement.waitForElements(statusReasonSummaryRepPage3, "xpath");
		assertTrue(this.page.element(statusReasonSummaryRepPage3, "xpath").getOne()
				.isDisplayed());
		return this;
	}
	
	
	/**********************************************************************************
	 * Description : This function is to verify PDF option is selected by default
	 * Date        : 04-Jun-2015
	 * Author 	   : Anil
	 **********************************************************************************/
	public Report verifyPDFOptionIsSelected() throws Exception {
		objWaitForElement.waitForElements(pdfOption, "css");
		assertTrue(this.page.element(pdfOption, "css").getOne().isSelected());
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to get selected month
	* Date 			: 18/09/2014
	* Author 		: Anil
	**********************************************************************************/
	public String getSelectedMonth() throws Exception {
		objWaitForElement.waitForElements("//td[@class='emsLabel'][contains(text(),'Month')]/following-sibling::td/select", "xpath");
		String strValue = this.page.element("//td[@class='emsLabel'][contains(text(),'Month')]/following-sibling::td/select", "xpath").webElementToSelect().getFirstSelectedOption().getText();
		return strValue;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on Notification history
	 * Date        : 19/Jun/2015
	 * Author 	   : Sangappa.k
	 **********************************************************************************/
	public Report clickOnNotificationHistory() throws Exception {
		objWaitForElement.waitForElements(notificationHistory, "linktext");
		this.page.element(notificationHistory, "linktext").getOne()
				.click();
		return this;
	}	
	
	/**********************************************************************************
	 * Description : This function is to entere notification history start date
	 * Date        : 19/Jun/2015
	 * Author      : Sangappa.k
	 **********************************************************************************/
	public Report enterNotificationHistoryStartDate(String strTime) throws Exception {
		objWaitForElement.waitForElements(notificationStartDate, "css");
		this.page.element(notificationStartDate, "css").clearInputValue().sendKeys(strTime);
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to entere notification hostory end date
	 * Date        : 19/Jun/2015
	 * Author      : Sangappa.k
	 **********************************************************************************/
	public Report enterNotificationHistoryEndDate(String strTime) throws Exception {
		objWaitForElement.waitForElements(notificationEnddate, "css");
		this.page.element(notificationEnddate, "css").clearInputValue().sendKeys(strTime);
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify PDF option is selected by default
	 * Date        : 04-Jun-2015
	 * Author 	   : Anil
	 **********************************************************************************/
	public Report verifyNotificationHistoryPage() throws Exception {
		objWaitForElement.waitForElements(notificationHistorypage, "xpath");
		assertTrue(this.page.element(notificationHistorypage, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify select all check box is displayed for resources
	 * Date        : 04-Jun-2015
	 * Author 	   : Anil
	 **********************************************************************************/
	public Report verifySelectAllCheckBoxForResources() throws Exception {
		objWaitForElement.waitForElements(selectAllCheckBox, "xpath");
		assertTrue(this.page.element(selectAllCheckBox, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify next button
	 * Date        : 10/09/2014 
	 * Author      : Anil
	 **********************************************************************************/
	public Report verifyNextBtn() throws Exception {
		objWaitForElement.waitForElements(nextButton, "css");
		assertTrue(this.page.element(nextButton, "css").getOne().isDisplayed());
		return this;
	}
	
	
	/**********************************************************************************
	* Description 	: This function is to verify status type dropdown is displayed
	* Arguments		:
	* Date 			: 15/09/2015
	* Author 		: Anil
	**********************************************************************************/
	public Report verifyStatusTypeDropDownIsDisplayed() throws Exception {
		objWaitForElement.waitForElements(statusTypeDropDown, "css"); 
		assertTrue(this.page.element(statusTypeDropDown, "css").getOne().isDisplayed());
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify resource name is displayed
	 * Date        : 19/09/2014 
	 * Author      : Anil
	 **********************************************************************************/
	public Report verifyResourceValueDisplayed(String strResourceValue) throws Exception {
		objWaitForElement.waitForElementByxpathSelector("//input[@name='resourceIDs'][@value='"+strResourceValue+"']");
		assertTrue(this.page.element("//input[@name='resourceIDs'][@value='"+strResourceValue+"']", "xpath")
				.getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Incoming Patient Notification Details Report page is displayed
	 * Date        : 10/09/2014 
	 * Author      : Sangappa.k
	 **********************************************************************************/
	public Report verifyIncomingPatientNotificatioDetailsReportPage() throws Exception {
		objWaitForElement.waitForElements(incomingPationpage, "xpath");
		assertTrue(this.page.element(incomingPationpage, "xpath")
				.getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify PDF Option is not present in Incoming Patient Notification Details
	                Report page.
	 * Date        : 10/09/2014 
	 * Author      : Sangappa.k
	 **********************************************************************************/
	public Report verifyPDFReportFormatIsNotThierInIPNReportPage() throws Exception {
		objWaitForElement.waitForElements(pdfOption, "xpath");
		assertFalse(this.page.element(pdfOption, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
			
		return this;
	}		
	
	
	/**********************************************************************************
	 * Description : This function is to click on Incoming Patient Notification Details
	                Report page.
	 * Date        : 10/09/2014 
	 * Author      : Sangappa.k
	 **********************************************************************************/
	public Report clickOnIncomingPatientNotificationDetails() throws Exception {
		objWaitForElement.waitForElements(iPNLink, "linktext");
		this.page.element(iPNLink, "linktext").getOne().click();

		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on admin reports
	              
	 * Date        : 3/July/2015
	 * Author      : Sangappa.k
	 **********************************************************************************/
	public Report clickOnAdminUsage() throws Exception {
		objWaitForElement.waitForElements(strAdminUsage, "linktext");
		this.page.element(strAdminUsage, "linktext").getOne().click();

		return this;
	}
	
	

	/**********************************************************************************
	 * Description : This function is to click on admin reports
	              
	 * Date        : 3/July/2015
	 * Author      : Sangappa.k
	 **********************************************************************************/
	public Report clickOutSide() throws Exception {
		objWaitForElement.waitForElements(strtext, "xpath");
		this.page.element(strtext, "xpath").getOne().click();	
		return this;
	}

	/**********************************************************************************
	* Description 	: This function is to verify status type names dispalyed
	* Arguments		: strStatusTypeNames
	* Date 			: 03/Jul/2015
	* Author 		: Renushree
	**********************************************************************************/
	public Report verStatusTypeNamesInDropDown(String[] strStatusTypeNames) throws Exception {
		objWaitForElement.waitForElements(statusTypeDropDown, "css"); 
		List<WebElement> dropdown = this.page.element(statusTypeDropDown, "css").webElementToSelect().getOptions();
		ArrayList<String> l2 = new ArrayList<String>();
		for (WebElement webElement : dropdown) {
			String temp = webElement.getText();
			l2.add(temp);
		}
		for(int i=0; i<strStatusTypeNames.length; i++){
			assertTrue(l2.contains(strStatusTypeNames[i]), "ST names are not found.");
		}	
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Start date option is displayed
	 * Date        : 07/Jul/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public Report verifySearchStartDate() throws Exception {
		objWaitForElement.waitForElements(startDate, "xpath");
		assertTrue(this.page.element(startDate, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify End date option is displayed
	 * Date        : 07/Jul/2015 
	 * Author      : Renushree
	 **********************************************************************************/
	public Report verifySearchEndDate() throws Exception {
		objWaitForElement.waitForElements(endDate, "xpath");
		assertTrue(this.page.element(endDate, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify headers are not displayed in 
	  *         'Event snapshot report header'
	  * Date        : 13-Aug-2015
	  * Author      : Deepa
	  **********************************************************************************/
	 public Report verifyHeadersInHTMLEventSnapshotReportAreNotDis(
	   String strHeaderName[]) throws Exception {
	  for (int i = 0; i < strHeaderName.length; i++) {
	   String strColumnName = this.page
	     .element("//table/tbody/tr[1]/th[2]", "xpath").getOne()
	     .getText();
	   assertFalse(strColumnName.equals(strHeaderName[i]));
	  }
	  return this;
	 }
	 
	/**********************************************************************************
	* Description 	: This function is to verify 'Statewide Resource Details' link is not displayed
	* Date 			: 28/07/2015
	* Author 		: Renushree
	**********************************************************************************/
	public Report verStatewideResourceDetailsNotDisplayed() throws Exception {
		assertFalse(this.page.element(statewideResourceDetails, "linktext")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE),
				"Statewide Resource Details link displayed");
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify Start date option is displayed
	 * Date        : 8/18/2015
	 * Author      : Sangappa.k
	 **********************************************************************************/
	public Report enterStartDateOfAdminUsage(String strDate) throws Exception {
		objWaitForElement.waitForElements(strStart, "xpath");
		this.page.element(strStart, "xpath").clearInputValue().sendKeys(strDate);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify End date option is displayed
	 * Date        : 8/18/2015
	 * Author      : Sangappa.k
	 **********************************************************************************/
	public Report enterEndDateOfAdminUsage(String strTime) throws Exception {
		objWaitForElement.waitForElements(strEnd, "xpath");
		this.page.element(strEnd, "xpath").clearInputValue().sendKeys(strTime);
		return this;
	}	
	
	/**********************************************************************************
	 * Description : This function is to verify 'Status type checkbox' is not dispalyed
	 * Date        : 31/12/2015 
	 * Author      : Rensuhree
	 **********************************************************************************/
	public Report statusTypeCheckboxNotDisplayed(String strStatusTypeValue)
			throws Exception {
		assertFalse(
				this.page
						.element(
								"//div[@id='mainContainer']//table/tbody/tr/td/input[@value='"
										+ strStatusTypeValue + "']", "xpath")
						.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE),
				"Status type checkboxes are displayed");
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to click on select all checkbox
	              
	 * Date        : 3/July/2015
	 * Author      : Anil
	 **********************************************************************************/
	public Report clickSelectAllCheckBox() throws Exception {
		objWaitForElement.waitForElements(selectAllCheckBoxInStatusReasonSummary, "xpath");
		this.page.element(selectAllCheckBoxInStatusReasonSummary, "xpath").getOne().click();	
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on select all checkbox	              
	 * Date        : 3/July/2015
	 * Author      : Anil
	 **********************************************************************************/
	public Report clickregionalAggregrate() throws Exception {
		objWaitForElement.waitForElements(regionalAggregrate, "xpath");
		this.page.element(regionalAggregrate, "xpath").getOne().click();	
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify Resource report is not displayed
	 * Date        : 01/06/2016 
	 * Author      : Sandhya
	 **********************************************************************************/
	public Report verifyResourceReportLinkIsNotDisplayed() throws Exception {
		assertFalse(this.page.element(resourceReports, "linktext").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
}
	
	
	
