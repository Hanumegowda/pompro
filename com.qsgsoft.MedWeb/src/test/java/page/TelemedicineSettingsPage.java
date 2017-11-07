package page;

import module.Frames;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;
import qaframework.lib.pageObject.PageObject;
import qaframework.lib.userDefinedFunctions.WaitForElement;

public class TelemedicineSettingsPage extends PageObject{
	
	WebDriver driver;
	WaitForElement objWaitForElement;
	Frames objFrames;
	
	private String telemedicineSettingsPage = "//b[text()='Telemedicine Settings Page']",
			       displayUnassignedCasesChekbx = "//td[contains(text(),'Display Unassigned cases')]/input",
			       saveChanges = "//a[text()='Save Changes']";
	
	public TelemedicineSettingsPage(WebDriver _driver) throws Exception{
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
		objFrames = new Frames(this.driver);
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Telemedicine Settings Page' is displayed.
	* Date 		  : 09-Dec-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public TelemedicineSettingsPage verTelemedicineSettingsPage()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(telemedicineSettingsPage, "xpath");
		assertTrue(this.page.element(telemedicineSettingsPage, "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to deselect 'Display Unassigned cases' checkbox.
	* Date 		  : 09-Dec-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public TelemedicineSettingsPage deSelectDisplayUnassignedCases()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(displayUnassignedCasesChekbx, "xpath");
		if(this.page.element(displayUnassignedCasesChekbx, "xpath").getOne().isSelected()==true){
			this.page.element(displayUnassignedCasesChekbx, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'save changes' button.
     * Date        : 09-Dec-2016
     * Author      : Hanumegowda
     **********************************************************************************/
	public TelemedicineSettingsPage clickOnSaveChanges() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(saveChanges, "xpath");
		this.page.element(saveChanges, "xpath").clickUjse();
		
		return this;
	}

}
