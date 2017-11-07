package page;

import java.util.List;

import module.Frames;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import qaframework.lib.pageObject.PageObject;
import qaframework.lib.userDefinedFunctions.WaitForElement;

public class DICOMRemapping extends PageObject{
	WebDriver driver;
	WaitForElement objWaitForElement;
	Frames objFrames;
	UserManagement objUserManagement;
	
	private String aeTitle = "//input[@name='remappings.1']",
			       dicomDictionaryDest = "//input[@name='remappings.1_HD']/..//img[@src='/.cobalt/images/counter_icon_small.gif']",
			       dicomOption = "//select[@name='DICOM_TAG']",
			       save = "//img[@src='/wavelet/gifs.new/ris_save.gif']",
			       dicomDictionarySrc = "//input[@name='remappings.1_HS']/..//img[@src='/.cobalt/images/counter_icon_small.gif']",
			       regexp = "//input[@name='remappings.1_M']",
			       delRemapping = "//img[@src='/.cobalt/images/delete.gif']";
	
  public DICOMRemapping(WebDriver _driver) throws Exception {
	  super(_driver);
	  this.driver = _driver;
	  objWaitForElement = new WaitForElement(this.driver);
	  objFrames = new Frames(this.driver);
	  objUserManagement = new UserManagement(this.driver);
	  
  }
  
  /**********************************************************************************
	* Description : This function is to enter the the text in 'AE Title' field.
	* Date 		  : 27-Jun-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMRemapping enterTextInAETitleField(String str) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(aeTitle, "xpath");
		this.page.element(aeTitle, "xpath").getOne().click();
		this.page.element(aeTitle, "xpath").clearInputValue().sendKeys(str);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Dicom dictionary' icon of Dicom dest field.
	* Date 		  : 27-Jun-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMRemapping clickOnDicomDictionaryIconOfDestField() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(dicomDictionaryDest, "xpath");
		this.page.element(dicomDictionaryDest, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'ID MODALITY' option in DICOM DICTIONARY.
	* Date 		  : 27-Jun-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMRemapping selIDMODALITYOption(String option) throws Exception {
		objWaitForElement.waitForElements(dicomOption, "xpath");
		this.page.element(dicomOption, "xpath").webElementToSelect().selectByValue(option);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on save.
	* Date 		  : 27-Jun-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMRemapping clickOnSave() throws Exception {
		objWaitForElement.waitForElements(save, "xpath");
		this.page.element(save, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Dicom dictionary' icon of Dicom src field.
	* Date 		  : 27-Jun-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMRemapping clickOnDicomDictionaryIconOfSrcField() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(dicomDictionarySrc, "xpath");
		this.page.element(dicomDictionarySrc, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Regexp' field.
	* Date 		  : 27-Jun-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public DICOMRemapping enterTextInRegexpField(String str) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(regexp, "xpath");
		this.page.element(regexp, "xpath").clearInputValue().sendKeys(str);
		return this;
	}
	
	
	/**********************************************************************************
	* Description : This function is to delete existing remappings.
	* Date 		  : 15-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public boolean delAllRemappings() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(delRemapping, "xpath");
		if (this.page.element(delRemapping, "xpath").isElementPresent(3) == true) {
			this.page.element(delRemapping, "xpath").getOne().click();
			objUserManagement.clickOnOkInAlertPopUp();
			Thread.sleep(3000);
		}
		if (this.page.element(delRemapping, "xpath").isElementPresent(3) == true) {
			return true;
		} else {
			return false;
		}

	}

}
