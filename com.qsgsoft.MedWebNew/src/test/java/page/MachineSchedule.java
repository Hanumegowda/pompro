package page;

import module.Frames;

import org.openqa.selenium.WebDriver;

import qaframework.lib.pageObject.PageObject;
import qaframework.lib.userDefinedFunctions.WaitForElement;
import static org.testng.Assert.assertTrue;

public class MachineSchedule extends PageObject{
	WebDriver driver;
	WaitForElement objWaitForElement;
	Frames objFrames;
	
	private String machineSchedule = "//td[contains(text(),'Machine Schedule')]",
			       availableTimeSlot = "//a[@title='Edit event']",
			       newMachineEvent = "//td[contains(text(),'New machine event')]",
			       dateDropDown = "//select[@name='DAY']",
			       dateDropDown1 = "//select[@name='DAY_E']",
			       searchDoctor = "//img[@src='/wavelet/gifs.new/ris_search_icon.gif']",
			       beginHour = "//select[@name='HOUR']",
			       selectAll = "//a[text()='Select All']",
			       anyDoctor = "(//a)[1]",
			       saveAndBack = "//a[text()='Save & Back']",
			       createNewEvent = "//a[text()='Create New Event']";
	
	public MachineSchedule(WebDriver _driver) throws Exception{
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
		objFrames = new Frames(this.driver);
	}
	
	/**********************************************************************************
	* Description : This function is to verify Machine Schedule page is displayed.
	* Date 		  : 22-Apr-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public MachineSchedule verMachineSchedulePage()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(machineSchedule, "xpath");
		assertTrue(this.page.element(machineSchedule, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on required machine link.
	* Date 		  : 22-Apr-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public MachineSchedule clickOnMachineLink(String machine)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements("//a[contains(text(),'"+machine+"')]", "xpath");
        this.page.element("//a[contains(text(),'"+machine+"')]", "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on available time slot link.
	* Date 		  : 22-Apr-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public MachineSchedule clickOnAvailableTimeSlot()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(availableTimeSlot, "xpath");
        this.page.element(availableTimeSlot, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'New machine event' page is displayed.
	* Date 		  : 22-Apr-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public MachineSchedule verNewMachineEventPage()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(newMachineEvent, "xpath");
		assertTrue(this.page.element(newMachineEvent, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select date from the dropdown.
	* Date 		  : 22-Apr-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public MachineSchedule selDateFromDropDown(String date)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(dateDropDown, "xpath");
		this.page.element(dateDropDown, "xpath").webElementToSelect().selectByVisibleText(date);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select date from the dropdown under repeated mode section.
	* Date 		  : 22-Apr-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public MachineSchedule selDateFromDropDown1(String date)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(dateDropDown1, "xpath");
		this.page.element(dateDropDown1, "xpath").webElementToSelect().selectByVisibleText(date);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on search doctor icon.
	* Date 		  : 22-Apr-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public MachineSchedule clickOnSearchDoctorIcon()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(searchDoctor, "xpath");
		this.page.element(searchDoctor, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select hour from begin drop down.
	* Date 		  : 22-Apr-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public MachineSchedule selBeginTimeHour(String hour)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(beginHour, "xpath");
		this.page.element(beginHour, "xpath").webElementToSelect().selectByVisibleText(hour);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on select all link.
	* Date 		  : 22-Apr-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public MachineSchedule clickOnSelectAllLink()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(selectAll, "xpath");
		this.page.element(selectAll, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select any doctor.
	* Date 		  : 22-Apr-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public String selAnyDoctor()
			throws Exception {
		objWaitForElement.waitForElements(anyDoctor, "xpath");
		String str = this.page.element(anyDoctor, "xpath").getOne().getText();
		this.page.element(anyDoctor, "xpath").getOne().click();
		String s[] = str.split(" ");
		System.out.println(str+" selected doctor");
		System.out.println(s[0]+" 1");
		System.out.println(s[1]+" 2");
		//System.out.println(s[2]+" 3");
		return s[1];
	}
	
	/**********************************************************************************
	* Description : This function is to click on save and back button.
	* Date 		  : 22-Apr-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public MachineSchedule clickOnSaveAndBackButton()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(saveAndBack, "xpath");
		this.page.element(saveAndBack, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on required date from calendar.
	* Date 		  : 22-Apr-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public MachineSchedule clickOnRequiredDate(String reqdate)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements("//tbody//a[text()='"+reqdate+"']", "xpath");
		this.page.element("//tbody//a[text()='"+reqdate+"']", "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify scheduled event is displayed.
	* Date 		  : 22-Apr-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public MachineSchedule verScheduledEvent(String rd1, String rd2)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		String epath = "//td[contains(text(),'"+rd1+"')]/following-sibling::td/img[@src='/wavelet/gifs.new/mr_repeat.gif']/../following-sibling::td/a[contains(text(),'Doctor:')]";
		objWaitForElement.waitForElements(epath, "xpath");
		String actual = this.page.element(epath, "xpath").getOne().getText();
		System.out.println(actual+" getted text");
		assertTrue(actual.contains(rd2));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify Clinic is displaying in 'Machine Schedule' page.
	* Date 		  : 16-Nov-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public MachineSchedule verClinicInMachineSchedulePage(String clinic)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements("//b[text()='"+clinic+"']", "xpath");
		assertTrue(this.page.element("//b[text()='"+clinic+"']",
				"xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify Machine is displaying in 'Machine Schedule' page.
	* Date 		  : 16-Nov-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public MachineSchedule verMachineInMachineSchedulePage(String machine)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements("//a[contains(text(),'" + machine
				+ "')]", "xpath");
		assertTrue(this.page.element("//a[contains(text(),'" + machine + "')]",
				"xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Create New Event' button.
	* Date 		  : 17-Nov-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public MachineSchedule clickOnCreateNewEventButton()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(createNewEvent, "xpath");
        this.page.element(createNewEvent, "xpath").getOne().click();
		return this;
	}

}
