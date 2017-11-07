package EMR.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import qaFramework.WaitTimeConstants;
import qaFramework.UserDefinedFunctions.Date_Time_settings;
import qaFramework.UserDefinedFunctions.WaitForElement;
import qaFramework.pageObject.PageObject;
import EMR.Locators.UpdateStatus.Locators;
import EMR.data.UpdateStatusData;

public class UpdateStatus extends PageObject {

	WebDriver driver;
	WaitForElement waitForElement ;
	Login login;
	Random randomGenerator;
	ViewResourceDetail viewResourceDetail;
	Date_Time_settings dts;
	RegionDefault regionDefault;
	Shared navigateTo;
	FormTemplateDesigner formTemplateDesigner;
	EventManagement eventManagement;
	Map map;
	WebDriverWait wait;
	public UpdateStatus(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		waitForElement = new WaitForElement(this.driver);
		viewResourceDetail=new ViewResourceDetail(this.driver);
		regionDefault= new RegionDefault(this.driver);
		dts= new Date_Time_settings();
		login= new Login(this.driver);
		navigateTo = new Shared(this.driver);
		formTemplateDesigner = new FormTemplateDesigner(this.driver);
		map = new Map(this.driver);
		eventManagement = new EventManagement(this.driver);
		wait = new WebDriverWait(this.driver, WaitTimeConstants.WAIT_TIME_TOO_SMALL);
	}

	public UpdateStatus clickOnSelectAll() throws Exception {
		waitForElement.waitForElements(Locators.SELECTALL, "id");
		this.page.element(Locators.SELECTALL, "id").getOne().click();
		return this;
	}

	public UpdateStatus enterNumberOrTextOrDateStatusTypesUpdateValue(String statusTypeValue, String updateValue) throws Exception {
		waitForElement.waitForElements(Locators.NSTORTSTUPDATEINPUT + statusTypeValue, "name");
		this.page.element(Locators.NSTORTSTUPDATEINPUT + statusTypeValue, "name").mouseOver();
		this.page.element(Locators.NSTORTSTUPDATEINPUT + statusTypeValue, "name").clearInputValue().sendKeys(updateValue);
		return this;
	}

	public UpdateStatus selectMSTUpdateValue(String statusTypeValue,
			String updateValue) throws Exception {
		waitForElement.waitForElements(Locators.MSTUPDATEVALUEPART1 + updateValue + Locators.MSTUPDATEVALUEPART2 + statusTypeValue + Locators.CLOSEBRACKETS, "css");
		this.page.element(Locators.MSTUPDATEVALUEPART1 + updateValue + Locators.MSTUPDATEVALUEPART2 + statusTypeValue + Locators.CLOSEBRACKETS, "css").mouseOver();
		this.page.element(Locators.MSTUPDATEVALUEPART1 + updateValue + Locators.MSTUPDATEVALUEPART2 + statusTypeValue + Locators.CLOSEBRACKETS, "css").getOne().click();
		return this;
	}

	public UpdateStatus clickOnSaveButton() throws Exception {
		waitForElement.waitForElements(Locators.SAVEBUTTON, "css");
		this.page.element(Locators.SAVEBUTTON, "css").getOne().click();
		return this;
	}

	public UpdateStatus verifyUpdateStatusPage() throws Exception {
		waitForElement.waitForElements(Locators.UPDATESTATUSPAGE, "xpath");
		this.page.element(Locators.UPDATESTATUSPAGE, "xpath").isElementPresent();
		this.page.element(Locators.UPDATESTATUSPAGE, "xpath").getOne().isDisplayed();
		return this;
	}

	public UpdateStatus enterUpdateSSTValues(String statusTypeValue,
			String[] updateValue) throws Exception {
		this.enterEdBedsOccupied(statusTypeValue, updateValue[0]);
		this.enterlobbyPatients(statusTypeValue, updateValue[1]);
		this.enterambulancePatients(statusTypeValue, updateValue[2]);
		this.enteradmitsGeneral(statusTypeValue, updateValue[3]);
		this.enteradmitsIcu(statusTypeValue, updateValue[4]);
		this.enterOneOnOnePatients(statusTypeValue, updateValue[5]);
		this.entershortStaffRn(statusTypeValue, updateValue[6]);
		this.enterEdBedsAssigned(statusTypeValue, updateValue[7]);
		this.enterlobbyCapacity(statusTypeValue, updateValue[8]);
		return this;
	}

	public UpdateStatus enterEdBedsOccupied(String statusTypeValue,
			String updateValue) throws Exception {
		waitForElement.waitForElements(Locators.EDBEDS + statusTypeValue, "css");
		this.page.element(Locators.EDBEDS + statusTypeValue, "css")
		.clearInputValue().sendKeys(updateValue);
		assertEquals(this.page.element(Locators.EDBEDS + statusTypeValue, "css").getOne().getAttribute("value"), updateValue);
		return this;
	}

	public UpdateStatus enterlobbyPatients(String statusTypeValue,
			String updateValue) throws Exception {
		waitForElement.waitForElements(Locators.LOBYPATIENT + statusTypeValue, "css");
		this.page.element(Locators.LOBYPATIENT + statusTypeValue, "css")
		.clearInputValue().sendKeys(updateValue);
		assertEquals(this.page.element(Locators.LOBYPATIENT + statusTypeValue, "css").getOne().getAttribute("value"), updateValue);
		return this;
	}

	public UpdateStatus enterambulancePatients(String statusTypeValue,
			String updateValue) throws Exception {
		waitForElement.waitForElements(Locators.AMBULANCEPATIENTS + statusTypeValue, "css");
		this.page.element(Locators.AMBULANCEPATIENTS + statusTypeValue, "css")
		.clearInputValue().sendKeys(updateValue);
		assertEquals(this.page.element(Locators.AMBULANCEPATIENTS + statusTypeValue, "css").getOne().getAttribute("value"), updateValue);
		return this;
	}

	public UpdateStatus enteradmitsGeneral(String statusTypeValue,
			String updateValue) throws Exception {
		waitForElement.waitForElements(Locators.ADMITSGENERAL+ statusTypeValue, "css");
		this.page.element(Locators.ADMITSGENERAL + statusTypeValue, "css")
		.clearInputValue().sendKeys(updateValue);
		assertEquals(this.page.element(Locators.ADMITSGENERAL + statusTypeValue, "css").getOne().getAttribute("value"), updateValue);
		return this;
	}

	public UpdateStatus enteradmitsIcu(String statusTypeValue,
			String updateValue) throws Exception {
		waitForElement.waitForElements(Locators.ADMITSICU + statusTypeValue, "css");
		this.page.element(Locators.ADMITSICU + statusTypeValue, "css")
		.clearInputValue().sendKeys(updateValue);
		assertEquals(this.page.element(Locators.ADMITSICU + statusTypeValue, "css").getOne().getAttribute("value"), updateValue);
		return this;
	}

	public UpdateStatus enterOneOnOnePatients(String statusTypeValue,
			String updateValue) throws Exception {
		waitForElement.waitForElements( Locators.ONEONONEPATIENTS+ statusTypeValue, "css");
		this.page.element(Locators.ONEONONEPATIENTS + statusTypeValue, "css")
		.clearInputValue().sendKeys(updateValue);
		assertEquals(this.page.element(Locators.ONEONONEPATIENTS + statusTypeValue, "css").getOne().getAttribute("value"), updateValue);
		return this;
	}

	public UpdateStatus entershortStaffRn(String statusTypeValue,
			String updateValue) throws Exception {
		waitForElement.waitForElements( Locators.SHORTSTAFFRN+ statusTypeValue, "css");
		this.page.element(Locators.SHORTSTAFFRN + statusTypeValue, "css").clearInputValue().sendKeys(updateValue);
		assertEquals(this.page.element(Locators.SHORTSTAFFRN + statusTypeValue, "css").getOne().getAttribute("value"), updateValue);
		return this;
	}

	public UpdateStatus enterEdBedsAssigned(String statusTypeValue,
			String updateValue) throws Exception {
		waitForElement.waitForElements(Locators.EDBEDSASSGINED + statusTypeValue, "css");
		this.page.element(Locators.EDBEDSASSGINED + statusTypeValue, "css").clearInputValue().sendKeys(updateValue);
		assertEquals(this.page.element(Locators.EDBEDSASSGINED + statusTypeValue, "css").getOne().getAttribute("value"), updateValue);
		return this;
	}

	public UpdateStatus enterlobbyCapacity(String statusTypeValue,
			String updateValue) throws Exception {
		waitForElement.waitForElements(Locators.LOBYCAPICITY + statusTypeValue, "css");
		this.page.element(Locators.LOBYCAPICITY + statusTypeValue, "css").clearInputValue().sendKeys(updateValue);
		assertEquals(this.page.element(Locators.LOBYCAPICITY + statusTypeValue, "css").getOne().getAttribute("value"), updateValue);
		return this;
	}

	public UpdateStatus enterNedocsUpdateValue(String statusTypeValue,
			String[] updateValue) throws Exception {
		this.enterEdPatients(statusTypeValue, updateValue[0]);
		this.enterEdAdmits(statusTypeValue, updateValue[1]);
		this.enterlastDoorToBedTime(statusTypeValue, updateValue[2]);
		this.entercriticalCarePatients(statusTypeValue, updateValue[3]);
		this.enterlongestEdAdmit(statusTypeValue, updateValue[4]);
		this.enterEdNumber(statusTypeValue, updateValue[5]);
		this.enterIpNumber(statusTypeValue, updateValue[6]);
		return this;
	}

	public UpdateStatus enterEdPatients(String statusTypeValue,
			String updateValue) throws Exception {
		waitForElement.waitForElements(Locators.EDPATIENTS + statusTypeValue, "css");
		this.page.element(Locators.EDPATIENTS  + statusTypeValue, "css").clearInputValue().sendKeys(updateValue);
		assertEquals(this.page.element(Locators.EDPATIENTS  + statusTypeValue, "css").getOne().getAttribute("value"), updateValue);
		return this;
	}

	public UpdateStatus enterEdAdmits(String statusTypeValue,
			String updateValue) throws Exception {
		waitForElement.waitForElements(Locators.EDADMITS + statusTypeValue, "css");
		this.page.element(Locators.EDADMITS + statusTypeValue, "css")
		.clearInputValue().sendKeys(updateValue);
		assertEquals(this.page.element(Locators.EDADMITS + statusTypeValue, "css").getOne().getAttribute("value"), updateValue);
		return this;
	}

	public UpdateStatus enterlastDoorToBedTime(String statusTypeValue,
			String updateValue) throws Exception {
		waitForElement.waitForElements(Locators.DOORTOBEDTIME+ statusTypeValue, "css");
		this.page.element(Locators.DOORTOBEDTIME + statusTypeValue, "css")
		.clearInputValue().sendKeys(updateValue);
		assertEquals(this.page.element(Locators.DOORTOBEDTIME + statusTypeValue, "css").getOne().getAttribute("value"), updateValue);
		return this;
	}

	public UpdateStatus entercriticalCarePatients(String statusTypeValue,
			String updateValue) throws Exception {
		this.page.element(Locators.CRITIACALCAREPATIENTS+ statusTypeValue, "css")
		.clearInputValue().sendKeys(updateValue);
		assertEquals(this.page.element(Locators.CRITIACALCAREPATIENTS+ statusTypeValue, "css").getOne().getAttribute("value"), updateValue);
		return this;
	}

	public UpdateStatus enterlongestEdAdmit(String statusTypeValue,
			String updateValue) throws Exception {
		waitForElement.waitForElements(Locators.LONGESTADMIT + statusTypeValue, "css");
		this.page.element(Locators.LONGESTADMIT + statusTypeValue, "css")
		.clearInputValue().sendKeys(updateValue);
		assertEquals(this.page.element(Locators.LONGESTADMIT + statusTypeValue, "css").getOne().getAttribute("value"), updateValue);
		return this;
	}

	public UpdateStatus enterEdNumber(String statusTypeValue,
			String updateValue) throws Exception {
		waitForElement.waitForElements(Locators.EDNUMBER + statusTypeValue, "css");
		this.page.element(Locators.EDNUMBER + statusTypeValue, "css")
		.clearInputValue().sendKeys(updateValue);
		assertEquals(this.page.element(Locators.EDNUMBER + statusTypeValue, "css").getOne().getAttribute("value"), updateValue);
		return this;
	}

	public UpdateStatus enterIpNumber(String statusTypeValue,
			String updateValue) throws Exception {
		waitForElement.waitForElements(Locators.IPNUMBER + statusTypeValue, "css");
		this.page.element(Locators.IPNUMBER + statusTypeValue, "css")
		.clearInputValue().sendKeys(updateValue);
		assertEquals(this.page.element(Locators.IPNUMBER + statusTypeValue, "css").getOne().getAttribute("value"), updateValue);
		return this;
	}

	public UpdateStatus clickOnSave() throws Exception {
		waitForElement.waitForElements(Locators.SAVE, "css");
		this.page.element(Locators.SAVE, "css").getOne().sendKeys(Keys.ENTER);
		return this;
	}

	public UpdateStatus clickOnUpdateStatusKey(String resourceName) throws Exception {
		String updateKey=Locators.UPDATEKEY+resourceName+Locators.CLOSEBRACKETS+Locators.UPADTEKEYPART1;
		waitForElement.waitForElements(updateKey, "xpath");
		this.page.element(updateKey, "xpath").getOne().click();
		waitForElement.waitForElements(Locators.SELECTALL, "id");
		return this;
	}

	public UpdateStatus updateAllSixStatusTypes(String numberStatausTypeValue,
			String multiStatausTypeValue, String saturationStatausTypeValue,
			String NedocsStatausTypeValue, String textStatausTypeValue,
			String dateStatausTypeValue, String numberUpdateValue,
			String multiStatusToUpdate, String saturationUpdateValues[],
			String nedocsUpdatevalues[], String date, String textUpdateValue)
					throws Exception {

		clickOnSelectAll();
		enterNedocsUpdateValue(NedocsStatausTypeValue, nedocsUpdatevalues);
		enterUpdateSSTValues(saturationStatausTypeValue, saturationUpdateValues);
		enterNumberOrTextOrDateStatusTypesUpdateValue(numberStatausTypeValue, numberUpdateValue);
		selectMSTUpdateValue(multiStatausTypeValue, multiStatusToUpdate);
		enterNumberOrTextOrDateStatusTypesUpdateValue(textStatausTypeValue, textUpdateValue);
		enterNumberOrTextOrDateStatusTypesUpdateValue(dateStatausTypeValue, date);
		clickOnSave();
		return this;
	}

	public UpdateStatus verifyUpdatedStatusValues(String resourceValue,
			String statusTypeValue[], String updatedValues[]) throws Exception {
		for(int i =0;i<statusTypeValue.length;i++){
			String updatedValue = Locators.UPDATEDVALUES + resourceValue+ Locators.UPDATEDVALUESPART1 + statusTypeValue[i]+ Locators.UPDATEDVALUESPART2 +updatedValues[i]+ Locators.CLOSEBRACKETS;
			waitForElement.waitForElements(updatedValue, "xpath");
			assertTrue(this.page.element(updatedValue, "xpath").isElementPresent(),"Updated values are not displayed");
			assertTrue(this.page.element(updatedValue, "xpath").getOne().isDisplayed(), "Updated values are not displayed");
		}
		return this;
	}

	public UpdateStatus clickOnCalculateButtonOfNedocs(String statusTypeValue) throws Exception {
		waitForElement.waitForElements(Locators.NEDOCS_CALCULATE_BUTTON_PART1+statusTypeValue+Locators.NEDOCS_CALCULATE_BUTTON_PART2, "xpath");
		this.page.element(Locators.NEDOCS_CALCULATE_BUTTON_PART1+statusTypeValue+Locators.NEDOCS_CALCULATE_BUTTON_PART2, "xpath").getOne().click();
		return this;
	}

	public String getUpdatedValueOfNumberStatusType(String resourceName) throws Exception {
		String saturationScore=Locators.GETUPDATEDSATURATIONSCOREVALUE+resourceName+Locators.CLOSEBRACKETS+Locators.GETUPDATEDNUMBERVALUE;
		waitForElement.waitForElements(saturationScore, "xpath");
		String UpdatedSaturationScoreValue=this.page.element(saturationScore, "xpath").getOne().getText();
		return UpdatedSaturationScoreValue;
	}

	public String getUpdatedValueOfTextStatusType(String resourceName) throws Exception {
		String saturationScore=Locators.GETUPDATEDSATURATIONSCOREVALUE+resourceName+Locators.CLOSEBRACKETS+Locators.GETUPDATEDTEXTVALUE;
		waitForElement.waitForElements(saturationScore, "xpath");
		String UpdatedSaturationScoreValue=this.page.element(saturationScore, "xpath").getOne().getText();
		return UpdatedSaturationScoreValue;
	}

	public String getUpdatedValueOfDateStatusType(String resourceName) throws Exception {
		String saturationScore=Locators.GETUPDATEDSATURATIONSCOREVALUE+resourceName+Locators.CLOSEBRACKETS+Locators.GETUPDATEDDATEVALUE;
		waitForElement.waitForElements(saturationScore, "xpath");
		String UpdatedSaturationScoreValue=this.page.element(saturationScore, "xpath").getOne().getText();
		return UpdatedSaturationScoreValue;
	}

	public String getUpdatedValueOfSaturationStatusType(String resourceName) throws Exception {
		String saturationScore=Locators.GETUPDATEDSATURATIONSCOREVALUE+resourceName+Locators.CLOSEBRACKETS+Locators.GETUPDATEDSATURATIONSCOREVALUEPART1;
		waitForElement.waitForElements(saturationScore, "xpath");
		String UpdatedSaturationScoreValue=this.page.element(saturationScore, "xpath").getOne().getText();
		return UpdatedSaturationScoreValue;
	}

	public String getUpdatedValueOfNedocsStatusType(String resourceName) throws Exception {
		String nedocsScore=Locators.GETUPDATEDSATURATIONSCOREVALUE+resourceName+Locators.CLOSEBRACKETS+Locators.GETUPDATEDNEDOCSVALUEPART1;
		waitForElement.waitForElements(nedocsScore, "xpath");
		String updatedNedocsScore=this.page.element(nedocsScore, "xpath").getOne().getText();
		return updatedNedocsScore;
	}

	public String getUpdatedValueOfMultiStatusType(String resourceName) throws Exception {
		String status=Locators.GETUPDATEDSATURATIONSCOREVALUE+resourceName+Locators.CLOSEBRACKETS+Locators.GETUPDATEDSTATUSVALUEPART;
		waitForElement.waitForElements(status, "xpath");
		String updatedStatus=this.page.element(status, "xpath").getOne().getText();
		return updatedStatus;
	}

	public String updateSaturationStatusTypeOtherThenPreviousUpdatedScore(
			String saturationStatausTypeValue,
			String saturationUpdateValues[], String saturationUpdateValues1[],
			String updatedSaturationScore,String updatedSaturationScore1,String previousUpdatedSaturationScore) throws Exception {
		String returnUpdatedSaturationScore="";
		if(previousUpdatedSaturationScore.equals(updatedSaturationScore)) {	  
			enterUpdateSSTValues(saturationStatausTypeValue, saturationUpdateValues1);
			returnUpdatedSaturationScore=updatedSaturationScore1;
		}
		else if(previousUpdatedSaturationScore.equals(updatedSaturationScore1)) {	  
			enterUpdateSSTValues(saturationStatausTypeValue, saturationUpdateValues);
			returnUpdatedSaturationScore=updatedSaturationScore;
		}
		else if(previousUpdatedSaturationScore.equals(updatedSaturationScore)==false && previousUpdatedSaturationScore.equals(updatedSaturationScore1)==false) {
			enterUpdateSSTValues(saturationStatausTypeValue, saturationUpdateValues);
			returnUpdatedSaturationScore=updatedSaturationScore;
		}
		return returnUpdatedSaturationScore;
	}


	public String updateNedocsStatusTypeOtherThenPreviousUpdatedScore(
			String nedocsStatausTypeValue,
			String nedocsUpdateValues[], String nedocsUpdateValues1[],
			String updatedNedocsScore,String updatedNedocsScore1,String previousUpdatedNedocsScore) throws Exception {

		String returnUpdatedNedocsScore="";
		if(previousUpdatedNedocsScore.equals(updatedNedocsScore))
		{	  
			enterNedocsUpdateValue(nedocsStatausTypeValue, nedocsUpdateValues1);
			returnUpdatedNedocsScore=updatedNedocsScore1;
		}
		else if(previousUpdatedNedocsScore.equals(updatedNedocsScore1))
		{	  
			enterNedocsUpdateValue(nedocsStatausTypeValue, nedocsUpdateValues);
			returnUpdatedNedocsScore=updatedNedocsScore;
		} else if(previousUpdatedNedocsScore.equals(updatedNedocsScore)==false && previousUpdatedNedocsScore.equals(updatedNedocsScore1)==false) {
			enterNedocsUpdateValue(nedocsStatausTypeValue, nedocsUpdateValues);
			returnUpdatedNedocsScore=updatedNedocsScore;
		}
		return returnUpdatedNedocsScore;
	}


	public String updateMultiStatusOtherThenPreviousUpdatedStatus(
			String multiStatusTypeValue,
			String updatedMultiStatus1,String updatedMultiStatus2,
			String status1Value,   String status2Value,
			String previousUpdatedMultiStatus) throws Exception {

		String returnUpdatedStatus = "";
		if(previousUpdatedMultiStatus.equals(updatedMultiStatus1))
		{	  
			selectMSTUpdateValue(multiStatusTypeValue, status2Value);
			returnUpdatedStatus=updatedMultiStatus2;
		}
		else if(previousUpdatedMultiStatus.equals(updatedMultiStatus2))
		{	  
			selectMSTUpdateValue(multiStatusTypeValue, status1Value);
			returnUpdatedStatus=updatedMultiStatus1;

		} 
		else if(previousUpdatedMultiStatus.equals(UpdateStatusData.NOT_UPDATED))
		{ 
			selectMSTUpdateValue(multiStatusTypeValue, status1Value);
			returnUpdatedStatus=updatedMultiStatus1;
		} 
		System.out.println("returnUpdatedStatus" + returnUpdatedStatus);
		return returnUpdatedStatus;
	}

	public String getUpdatedNedocsValueWithoutDisasterText(
			String updatedNedocsScore) throws Exception {

		String updatedNedocsScoreWithoutDisatertext[] = updatedNedocsScore
				.split("-");
		return updatedNedocsScoreWithoutDisatertext[0].trim();

	}

	public UpdateStatus clickOnShowAll() throws Exception {
		waitForElement.waitForElements(Locators.SHOW_ALL, "css");
		this.page.element(Locators.SHOW_ALL, "css").getOne().click();
		return this;
	}

	public UpdateStatus clickOnStatusTypeNavigateToUpdateStatusPageAndSelectAll(String statusType) throws Exception {
		viewResourceDetail.clickOnAnyStatusTypeLinkToUpdate(statusType);
		verifyUpdateStatusPage();
		clickOnShowAll();
		clickOnSelectAll();
		return this;

	}

	public UpdateStatus clickOnSelectAllToUpdate(String statusType) throws Exception {
		clickOnSelectAll();
		return this;

	}

	public String getApplicationTime() throws Exception {
		waitForElement.waitForElements(Locators.APPLICATIONTIME, "css");
		String applicationTime=this.page.element(Locators.APPLICATIONTIME, "css").getOne().getText();
		return applicationTime;	
	}

	public String getStatusUpdatedDateAndTimeWithoutTimeZone() throws Exception {
		String updatedTimeAndDate=getApplicationTime();
		String updatedTime[]= updatedTimeAndDate.split(" ");
		updatedTimeAndDate=updatedTime[0]+" "+updatedTime[1]+" "+dts.getCurrentDate("yyyy")+" "+updatedTime[2];
		return updatedTimeAndDate;			
	}

	public UpdateStatus verifyWebNotificationForStatusUpdate(  
			String resourceName, String statusTypeNames[],String previousUpdatedValues[],
			String currentUpdatedValues[], String currnetupdatedDateAndTime)
					throws Exception {
		waitForElement.waitForElements(Locators.WEBNOTIFIACTIONFRAME, "css");
		assertEquals("Status Change for " + resourceName + "", this.page
				.element(Locators.WEBNOTIFIACTIONFRAME, "css").getOne().getText());
		for(int i=0;i<=statusTypeNames.length-1;i++)
		{
			String updateStatusValue=Locators.UPDATESTATUSCHANGEVALUE+"On " + currnetupdatedDateAndTime+ "  changed " + statusTypeNames[i]+ " status from "+previousUpdatedValues[i]+" to " + currentUpdatedValues[i] + "."+Locators.CLOSEBRACKETS;
			System.out.println(updateStatusValue);
			assertTrue(this.page.element(updateStatusValue,"xpath").isElementPresent(),"status type " +statusTypeNames[i]+ " is not changed from "+previousUpdatedValues[i]+" to " + currentUpdatedValues[i]);	
		}
		return this;
	}

	public UpdateStatus verifyUpdateStatusWebNotificationAndAcknolewdge(
			String resourceName, String statusTypeNames[],
			String previousUpdatedValues[], String currentUpdatedValues[],
			String currnetupdatedDateAndTime) throws Exception {
		regionDefault.verifyWebNotificationframe();
		verifyWebNotificationForStatusUpdate(resourceName, statusTypeNames,
				previousUpdatedValues, currentUpdatedValues,
				currnetupdatedDateAndTime);
		regionDefault.clickOnAcknowledgeAllNotifications();
		login.switchToDefaultWindow();
		login.selectFrame();
		return this;
	}

	public String updateMultiStatusOtherThanPreviousUpdatedStatus(
			String multiStatusTypeValue, 
			String statusesName1, String statusesName2, String statusesName3,
			String statuses1Value, String statuses2Value, String statuses3Value,
			String previousUpdatedMultiStatus) throws Exception {

		String returnUpdatedStatus = "";
		if(previousUpdatedMultiStatus.equals(statusesName1))
		{	  
			this.selectMSTUpdateValue(multiStatusTypeValue, statuses3Value);
			returnUpdatedStatus=statusesName3;
		}
		else if(previousUpdatedMultiStatus.equals(statusesName2))
		{	  
			this.selectMSTUpdateValue(multiStatusTypeValue, statuses1Value);
			returnUpdatedStatus=statusesName1;
		}
		else if(previousUpdatedMultiStatus.equals(statusesName3))
		{	  
			this.selectMSTUpdateValue(multiStatusTypeValue, statuses2Value);
			returnUpdatedStatus=statusesName2;
		}
		else if(previousUpdatedMultiStatus.equals(UpdateStatusData.NOT_UPDATED))
		{ 
			this.selectMSTUpdateValue(multiStatusTypeValue, statuses2Value);
			returnUpdatedStatus=statusesName2;
		} 
		return returnUpdatedStatus;
	}

	public String enterDateStatusTypesUpdateValue(String statusTypeValue, String updateValue) throws Exception {
		waitForElement.waitForElements(Locators.NSTORTSTUPDATEINPUT + statusTypeValue, "name");
		this.page.element(Locators.NSTORTSTUPDATEINPUT + statusTypeValue, "name").mouseOver();
		String existingValue = this.page.element(Locators.NSTORTSTUPDATEINPUT + statusTypeValue, "name").getOne().getAttribute("value");
		if(existingValue.equals(updateValue)){
			updateValue = dts.getFutureDay(2, "MM/dd/yyyy");
			this.page.element(Locators.NSTORTSTUPDATEINPUT + statusTypeValue, "name").clearInputValue().sendKeys(updateValue);
		} else{
			this.page.element(Locators.NSTORTSTUPDATEINPUT + statusTypeValue, "name").clearInputValue().sendKeys(updateValue);
		}
		return updateValue;
	}

	public String getUpdatedValueOfMultiStatusTypes(String statusTypeValue) throws Exception {
		String status=Locators.MST_UPDATED_VALUES+statusTypeValue+Locators.CLOSINGTWOBRACES;
		waitForElement.waitForElements(status, "xpath");
		String updatedStatus=this.page.element(status, "xpath").getOne().getText();
		System.out.println("getUpdated updatedStatus"   + updatedStatus);
		return updatedStatus;
	}

	public UpdateStatus selectMSTReasonValue(String reasonValue,String statusTypeValue, String statusValue) throws Exception {

		String reason = Locators.MSTUPDATEVALUEPART1+reasonValue+Locators.CLOSEBRACKETS+Locators.STATUS_REASON+statusTypeValue+Locators.UNDER_SCORE+statusValue+Locators.CLOSEBRACKETS;
		waitForElement.waitForElements(reason,"css");
		this.page.element(reason,"css").mouseOver();
		this.page.element(reason,"css").getDisplayedOne().click();
		return this;
	}

	public String updateMultiStatusTypesWithReasons(
			String multiStatusTypeValue, String updatedMultiStatus1,
			String updatedMultiStatus2, String status1Value,
			String status2Value, String previousUpdatedMultiStatus,
			String reasonValue)
					throws Exception {

		String selectedStatus = this.updateMultiStatusOtherThenPreviousUpdatedStatus(
				multiStatusTypeValue, updatedMultiStatus1, updatedMultiStatus2,
				status1Value, status2Value, previousUpdatedMultiStatus);

		this.selectMSTReasonValue(reasonValue, multiStatusTypeValue, status1Value);

		return selectedStatus;
	}


	public UpdateStatus verifyUpdatedStatusesValuesWithReasons(String resourceValue,String resourceName,String reasonNames[],
			String statusTypeValue[], String updatedValues[]) throws Exception {

		this.verifyUpdatedStatusValues(resourceValue, statusTypeValue, updatedValues);
		for(int i =0;i<reasonNames.length;i++){
			String updatedValue = Locators.UPDATED_RESONS_PART1 + resourceName+ Locators.UPDATED_RESONS_PART2 + reasonNames[i]+ Locators.CLOSINGTWOBRACES;
			waitForElement.waitForElements(updatedValue, "xpath");
			assertTrue(this.page.element(updatedValue, "xpath").isElementPresent());
			assertTrue(this.page.element(updatedValue, "xpath").getOne().isDisplayed());
		}
		return this;
	}


	public String getUpdatedDateAndTimeForStatuUpdate(String resourceValue) throws Exception {
		String updatedDateTime=Locators.LAST_UPDATED_TIME+resourceValue+Locators.CLOSEBRACKETS;
		waitForElement.waitForElements(updatedDateTime, "css");
		String getUpdatedTime=this.page.element(updatedDateTime, "css").getOne().getText();
		String[] updatedTime=getUpdatedTime.split(" ");
		System.out.println(updatedTime[2]);
		String currentYear=dts.getCurrentDate("yyyy");
		String updatedDateAndTime = updatedTime[0]+" "+updatedTime[1]+" "+currentYear+" "+updatedTime[2];
		System.out.println("updatedDateAndTime "+  updatedDateAndTime);
		return updatedDateAndTime;
	}


	public UpdateStatus verifyWebNotificationForStatusUpdateWithSTReasons (
			String resourceName, String statusTypeName,
			String updatedValue,String previousUpdatedvalues, String updatedDateAndTime,
			String reasonsNames)
					throws Exception {
		waitForElement.waitForElements("dt.othr", "css");

		assertEquals("Status Change for " + resourceName + "", this.page
				.element("dt.othr", "css").getOne().getText());


		assertTrue(this.page.element(
				"//dl/dd[@class='desc'][text()='On " + updatedDateAndTime
				+ "  changed " + statusTypeName
				+ " status from "+previousUpdatedvalues+" to " + updatedValue + ". Reasons: "+
				reasonsNames+ ".']", "xpath").isElementPresent());
		return this;
	}

	public UpdateStatus verifyWebNotificationForStatusUpdateWithStatusReasonsAndAcknowledge(
			String resourceName, String statusTypeName[],
			String updatedValue[],String[] previousUpdatedvalues, String updateddateAndTime,
			String reasonsNames[])throws Exception {
		regionDefault.verifyWebNotificationframe();
		for(int i=0;i<statusTypeName.length;i++)
		{
			this.verifyWebNotificationForStatusUpdateWithSTReasons(resourceName, statusTypeName[i], updatedValue[i],previousUpdatedvalues[i], updateddateAndTime, reasonsNames[i]);
		}
		regionDefault.clickOnAcknowledgeAllNotifications();
		login.switchToDefaultWindow();
		login.selectFrame();
		return this;
	}

	public UpdateStatus saveAndNavigateToUpdatedPage()throws Exception{
		clickOnSaveButton();
		return this;
	}

	public String getDateFormatForViewSnapShotReport()throws Exception{

		String applicationTime = navigateTo.getApplicationTime();
		String currentYear = dts.getCurrentDate("yyyy");
		applicationTime = applicationTime + " " + currentYear;
		applicationTime = dts.converDateFormat(applicationTime,
				"dd MMM HH:mm yyyy", "MM/dd/YYYY");
		return applicationTime;
	}

	public String[] getUpdatedHourAndMiniute(String updatedDateAndTime)throws Exception{
		String hourAndMiniut=updatedDateAndTime.substring(12);
		String timeAndMinut = dts.addTimetoExisting(hourAndMiniut, 1, "hh:mm");
		return timeAndMinut.split(":");
	}

	public UpdateStatus generateViewSnapShot(String enterdate,String hour,String minutes)throws Exception{
		navigateTo.clickOnPrint()
		.selectSpecificDateAndTimeUnderPrintOPtion()
		.enterSnapShotDate(enterdate)
		.selectSnapShotHour(hour) 
		.selectSnapShotMinutes(minutes)
		.clickOnGenerateReport();
		return this;
	}

	public UpdateStatus switchToEventSnapShotWindow(String mainWindowHandle) throws Exception {
		formTemplateDesigner.switchToFormTemplateWindow(mainWindowHandle);
		return this;
	}

	public UpdateStatus switchToMainWindow(String mainWindowHandle) throws Exception {
		formTemplateDesigner.switchToMainWindow(mainWindowHandle);
		return this;
	}

	public UpdateStatus verifyUpdateStatusPageAndSelectAllToUpdate() throws Exception {
		this.verifyUpdateStatusPage();
		this.clickOnSelectAll();
		return this;
	}

	public UpdateStatus tryToUpdateWithoutSelectingReasonAndVerifyError(String statusType,String multiStatusTypeValue,String multiStatusToUpdate,String updatedStatus)throws Exception{
		this.selectMSTUpdateValue(multiStatusTypeValue, multiStatusToUpdate);
		this.clickOnSave();
		this.verifyErrorWhenStatusReasonNotSelected(statusType, updatedStatus);
		return this;
	}

	public UpdateStatus verifyErrorWhenStatusReasonNotSelected(
			String statusType, String status) throws Exception {
		waitForElement.waitForElements(Locators.FOLLOWING_ERROR_OCCURED_HEADER,"xpath");
		assertTrue(this.page
				.element(Locators.FOLLOWING_ERROR_OCCURED_HEADER,"xpath").isElementPresent());
		assertTrue(this.page
				.element(Locators.FOLLOWING_ERROR_OCCURED_HEADER,"xpath").getOne().isDisplayed());
		assertEquals("" + statusType + " status " + status+ " must have status reason.",
				this.page.element(Locators.ERROR_TEXT_TO_UPDATE_STATUS,"xpath").getOne().getText());
		return this;
	}

	public UpdateStatus updateWithReason(String multiStatusTypeValue,String statusValue,String reasonValue)throws Exception{
		this.selectMSTReasonValue(reasonValue, multiStatusTypeValue, statusValue);
		this.clickOnSave();
		return this;
	}

	public UpdateStatus verifyWebNotificationForStatusUpdate(  
			String resourceName, ArrayList<String> statusTypeNames,ArrayList<String> previousUpdatedValues,
			ArrayList<String> currentUpdatedValues, String currnetupdatedDateAndTime)
					throws Exception {
		waitForElement.waitForElements(Locators.WEBNOTIFIACTIONFRAME, "css");
		assertEquals("Status Change for " + resourceName + "", this.page
				.element(Locators.WEBNOTIFIACTIONFRAME, "css").getOne().getText());
		for(int i=0;i<statusTypeNames.size();i++)
		{
			String updateStatusValue=Locators.UPDATESTATUSCHANGEVALUE+"On " + currnetupdatedDateAndTime+ "  changed " + statusTypeNames.get(i)+ " status from "+previousUpdatedValues.get(i)+" to " + currentUpdatedValues.get(i) + "."+Locators.CLOSEBRACKETS;
			System.out.println(updateStatusValue);
			assertTrue(this.page.element(updateStatusValue,"xpath").isElementPresent(),"status type " +statusTypeNames.get(i)+ " is not changed from "+previousUpdatedValues.get(i)+" to " + currentUpdatedValues.get(i));	
		}
		return this;
	}

	public UpdateStatus verifyUpdateStatusWebNotificationAndAcknolewdge(
			String resourceName, ArrayList<String> statusTypeNames,ArrayList<String> previousUpdatedValues,
			ArrayList<String> currentUpdatedValues, String currnetupdatedDateAndTime) throws Exception {
		regionDefault.verifyWebNotificationframe();
		this.verifyWebNotificationForStatusUpdate(resourceName, statusTypeNames,previousUpdatedValues, currentUpdatedValues,currnetupdatedDateAndTime);
		regionDefault.clickOnAcknowledgeAllNotifications();
		login.switchToDefaultWindow();
		login.selectFrame();
		return this;
	}
	public UpdateStatus clickOnStatusType(String statusTypeValue)
			throws Exception {

		String statusType = Locators.SELECT_SINGLE_STAUS_TYPE+statusTypeValue+Locators.CLOSEBRACKETS;
		waitForElement.waitForElements(statusType,"xpath");

		if(!this.page.element(statusType, "xpath").getOne().isSelected()){
			this.page.element(statusType, "xpath").getOne().sendKeys(Keys.SPACE);
		}
		if(!this.page.element(statusType, "xpath").getOne().isSelected()){
			this.page.element(statusType, "xpath").Click();
		}
		if(!this.page.element(statusType, "xpath").getOne().isSelected()){
			this.page.element(statusType, "xpath").clickUsingJSE();
		}
		assertTrue(this.page.element(statusType, "xpath").getOne().isSelected(), statusType + "is not selected");

		return this;
	}


	public UpdateStatus verifyUpdatedValuePurpleColor(String updatedValue, String stauscolor) throws Exception {
		//		String updatedValueDisplayInPurple = "color: rgb(0, 153, 0)";
		String element = Locators.RESOURCE_COLOR_PART1+updatedValue+Locators.CLOSEBRACKETS+Locators.RESOURCE_COLOR_PART2+Locators.CLOSEBRACKETS+stauscolor+"')]";
		waitForElement.waitForElements(element, "xpath");
		assertTrue(this.page.element(element, "xpath").getOne().isDisplayed(), element + " is not present");
		//		String str = this.page.element(Locators.RESOURCE_COLOR+updatedValue+Locators.CLOSEBRACKETS,"xpath").getOne().getAttribute("style");
		//		assertTrue(str.contains(updatedValueDisplayInPurple), str + " does not contain " + updatedValueDisplayInPurple);
		return this;
	}

	public String getUpdatedValueOfStatusType(String resourceValue, String statusTypeValue) throws Exception {
		String updatedValue = Locators.UPDATED_VALUES + resourceValue + statusTypeValue;
		waitForElement.waitForElements(updatedValue, "id");
		String previousUpdatedValue = this.page.element(updatedValue, "id").getDisplayedOne().getText();
		return previousUpdatedValue;
	}

	public UpdateStatus selectMSTUpdateValue(ArrayList<String> statusTypeValue,
			ArrayList<String> updateValue) throws Exception {
		waitForElement.waitForElements(Locators.MSTUPDATEVALUEPART1 + updateValue + Locators.MSTUPDATEVALUEPART2 + statusTypeValue + Locators.CLOSEBRACKETS, "css");
		this.page.element(Locators.MSTUPDATEVALUEPART1 + updateValue + Locators.MSTUPDATEVALUEPART2 + statusTypeValue + Locators.CLOSEBRACKETS, "css").mouseOver();
		this.page.element(Locators.MSTUPDATEVALUEPART1 + updateValue + Locators.MSTUPDATEVALUEPART2 + statusTypeValue + Locators.CLOSEBRACKETS, "css").getOne().click();
		return this;
	}

	public UpdateStatus enterNedocsUpdateValue(String statusTypeValue,
			ArrayList<String> updateValue) throws Exception {
		this.enterEdPatients(statusTypeValue, updateValue.get(0));
		this.enterEdAdmits(statusTypeValue, updateValue.get(1));
		this.enterlastDoorToBedTime(statusTypeValue, updateValue.get(2));
		this.entercriticalCarePatients(statusTypeValue, updateValue.get(3));
		this.enterlongestEdAdmit(statusTypeValue, updateValue.get(4));
		this.enterEdNumber(statusTypeValue, updateValue.get(5));
		this.enterIpNumber(statusTypeValue, updateValue.get(6));
		return this;
	}

	public UpdateStatus upDateMultipleNedocsStatusTypes(ArrayList<String> statusTypeValue,ArrayList<String> updateValue) throws Exception {			

		Iterator<String> itrator = statusTypeValue.iterator();
		while(itrator.hasNext())
		{
			this.enterNedocsUpdateValue(itrator.next(), updateValue);
		}
		return this;
	}

	public UpdateStatus upDateMultipleTextStatusTypes(ArrayList<String> statusTypeValue,ArrayList<String> updateValues) throws Exception {			

		Iterator<String> itrator = statusTypeValue.iterator();
		Iterator<String> updateValue =updateValues.iterator();
		while(itrator.hasNext())
		{
			this.enterNumberOrTextOrDateStatusTypesUpdateValue(itrator.next(), updateValue.next());
		}
		return this;
	}

	public UpdateStatus clearAll() throws Exception {
		waitForElement.waitForElements(Locators.CLEAR_ALL, "css");
		this.page.element(Locators.CLEAR_ALL, "css").mouseOver();
		this.page.element(Locators.CLEAR_ALL, "css").getOne().click();
		return this;
	}

	public UpdateStatus clearAllAndSelectStatusTypesToUpdate(ArrayList<String> statusTypeValue) throws Exception {		
		this.clearAll();
		Iterator<String> itrator = statusTypeValue.iterator();
		while (itrator.hasNext()) {
			this.clickOnStatusType(itrator.next());
		}
		return this;
	}

	public UpdateStatus selectStatusTypesToUpdate(String statusTypeValue) throws Exception {		
		this.clickOnStatusType(statusTypeValue);
		return this;
	}

	public UpdateStatus verifyStatusTypesAreNotDisplayedToUpdate(String statusTypeValue) throws Exception {	
		String statusType = Locators.SELECT_SINGLE_STAUS_TYPE+statusTypeValue+Locators.CLOSEBRACKETS;
		assertFalse(this.page.element(statusType, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL));  
		return this;
	}

	public UpdateStatus verifyLabelIsDisplayedAfterClickOnCalculate(String statusTypeValue) throws Exception {	
		String statusType = Locators.SELECT_SINGLE_STAUS_TYPE+statusTypeValue+Locators.CLOSEBRACKETS;
		assertTrue(this.page.element(statusType, "xpath").isElementPresent());  
		return this;
	}

	public UpdateStatus verifyCalculatedNedocsScoreAfterClickOnCalculate(String statusTypeValue,String nedocsScoreWithDisasterLabel) throws Exception {	
		String calculatedScore = Locators.CALCULATED_NEDOCS_SCORE_PART1+statusTypeValue+Locators.CLOSEBRACKETS+Locators.CALCULATED_NEDOCS_SCORE_PART2+nedocsScoreWithDisasterLabel+Locators.CLOSINGTWOBRACES;
		assertTrue(this.page.element(calculatedScore, "xpath").isElementPresent());  
		assertTrue(this.page.element(calculatedScore, "xpath").getOne().isDisplayed());
		return this;
	}

	public UpdateStatus verifyDisasterLabelAfterClickOnCalculate(String statusTypeValue) throws Exception {
		this.clickOnCalculateButtonOfNedocs(statusTypeValue);
		this.verifyLabelIsDisplayedAfterClickOnCalculate(statusTypeValue);
		return this;
	}
	public UpdateStatus verifyNedocsScoresShouldBeCalculatedOnlyAfterClickingOnCalculateButton(String statusTypeValue,String nedocsScoreWithDisasterLabel) throws Exception {
		this.clickOnCalculateButtonOfNedocs(statusTypeValue);
		this.verifyCalculatedNedocsScoreAfterClickOnCalculate(statusTypeValue,nedocsScoreWithDisasterLabel);
		return this;
	}

	public UpdateStatus verifyCalculatedSaturationScoreAfterClickOnCalculate(String statusTypeValue,String nedocsScoreWithDisasterLabel) throws Exception {	
		String calculatedScore = Locators.CALCULATED_NEDOCS_SCORE_PART1+statusTypeValue+Locators.CLOSEBRACKETS+Locators.CALCULATED_NEDOCS_SCORE_PART2+nedocsScoreWithDisasterLabel+Locators.CLOSINGTWOBRACES;
		assertTrue(this.page.element(calculatedScore, "xpath").isElementPresent());  
		assertTrue(this.page.element(calculatedScore, "xpath").getOne().isDisplayed());
		return this;
	}


	public UpdateStatus clickOnCalculateButtonOfSaturation(String statusTypeValue) throws Exception {	
		String calculateButton = Locators.SATURATION_CALCULATE_BUTTON_PART1+statusTypeValue+Locators.SATURATION_CALCULATE_BUTTON_PART2;
		this.page.element(calculateButton, "xpath").Click();
		return this;
	}

	public UpdateStatus verifySaturationScoresShouldBeCalculatedOnlyAfterClickingOnCalculateButton(String statusTypeValue,String saturationScore) throws Exception {
		this.clickOnCalculateButtonOfSaturation(statusTypeValue);
		this.verifyCalculatedSaturationScoreAfterClickOnCalculate(statusTypeValue,saturationScore);
		return this;
	}

	public UpdateStatus selectStatustypeAndNavigateToUpdateStatusPageAndSelectToShowAll(String statusType) throws Exception {
		viewResourceDetail.clickOnAnyStatusTypeLinkToUpdate(statusType);
		verifyUpdateStatusPage();
		clickOnShowAll();
		return this;
	}	
	
	public UpdateStatus clickOnCancel() throws Exception {
		waitForElement.waitForElements(Locators.CANCEL, "css");
		this.page.element(Locators.CANCEL, "css").mouseOver();
		this.page.element(Locators.CANCEL, "css").getOne().click();
		return this;
	}
	
	public UpdateStatus navigateToOtherPageAndVerifyUserIsPromptedToSaveChanges() throws Exception {
		waitForElement.waitForElements(EMR.Locators.Shared.Locators.SETUPLINK, "linktext");
		this.page.element(EMR.Locators.Shared.Locators.SETUPLINK, "linktext").getDisplayedOne().click();
		wait.until(ExpectedConditions.alertIsPresent());
		int i=0;
		boolean alertPresnet=false;
		while(!alertPresnet&& i<5)
		{
			try{
				Alert alert = driver.switchTo().alert();
				System.out.println("alert content"+alert.getText());
				assertEquals("There are unsaved changes on this page. If you continue, the changes will be lost because you did not click Save.", alert.getText());
				alert.dismiss();
				System.out.println("switched to alert");
			}
			catch(NoAlertPresentException e){
				i++;
			}
		}	
		return this;
	}

	public UpdateStatus verifyNoAlertIsPromptedToSaveChanges() throws Exception {
		boolean isAlertPresent;
		String catchMessage="";
		try{
			driver.switchTo().alert();
			isAlertPresent =true;
		}catch(NoAlertPresentException ex){
			catchMessage=ex.toString();
			isAlertPresent =false;
		}
		assertTrue(catchMessage.contains("No alert is active"));
		assertFalse(isAlertPresent,"Alert present");
		return this;	
	}
	
	public UpdateStatus verifyYouAreNotAuthorizedToUpdateMessage() throws Exception {
		waitForElement.waitForElements(Locators.UNAUTHORIZED_TO_UPDATE_MESSAGE, "xpath");
		assertTrue(this.page.element(Locators.UNAUTHORIZED_TO_UPDATE_MESSAGE, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL));
		assertTrue(this.page.element(Locators.UNAUTHORIZED_TO_UPDATE_MESSAGE, "xpath").getDisplayedOne().isDisplayed());
		return this;	
	}
	
	
	public UpdateStatus clickOnReturnToView() throws Exception {
		waitForElement.waitForElements(Locators.RETURN_TO_VIEW, "linktext");
		this.page.element(Locators.RETURN_TO_VIEW, "linktext").getDisplayedOne().click();
		return this;	
	}
	
	public UpdateStatus returnToViewAndShowOnCustomViewMap() throws Exception {
		this.clickOnReturnToView();
		navigateTo.showOnMap();
		return this;	
	}
	
	
}
