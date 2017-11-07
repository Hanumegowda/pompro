package page;



import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;


import org.openqa.selenium.WebElement;

import module.Frames;
import qaframework.lib.pageObject.PageObject;
import qaframework.lib.userDefinedFunctions.WaitForElement;
import static org.testng.Assert.assertTrue;

public class TemplatesList extends PageObject{
	WebDriver driver;
	WaitForElement objWaitForElement;
	Frames objFrames;
	
	private String templateList = "//b[text()='Templates List']",
			       partNo = "//input[@name='f_name']",
			       templateGroupTextField = "//input[@name='f_templategroup']",
			       templateGroupTextFieldInModifyTmplt = "//input[@name='TEMPLATE_GROUP']",
			       search = "//a[text()='Search']",
			       addTemplate = "//a[text()='Add Template']",
			       deleteTemplates = "//img[@src='/.cobalt/images/delete.gif'][@title='Remove Selected Templates']",
			       browse = "//input[@name='importfile']",
			       selectTempType = "//select[@name='template_type']",
			       clearLog = "//a[text()='Clear Log']",
			       importButton = "//a[text()='Import Template']",
			       tempSuccessfullyImportedMsg = "//font[contains(text(),'The file has been imported successfully.')]",
			       back = "//a[text()='Back']",
			       bodyPart = "BODY_PART",
			       orientation = "//input[@name='ORIENTATION']",
			       size = "//input[@name='SIZE']",
			       partNo1 = "//td[contains(text(),'PartNo')]/..//input[@name='PARTNO']",
			       noEntry = "//i[text()='No entries']",
			       selOrUnselectAll = "CHECKALL",
			       modifySelectedTemplates = "//img[@src='/.cobalt/images/modify.gif'][@alt='Modify Selected Templates']",
			       modifySelectedTemplatesPage = "//b[text()='Modify Selected Templates']",
			       templatesDataCheckBoxes = "//input[@type='CHECKBOX']",
			       mirroredPN = "PARTNO_R",
			       calibFactor = "CALIB_FACTOR",
			       rotation_Point_X = "ROTATION_POINT_X",
			       rotation_Point_Y = "ROTATION_POINT_Y",
			       description = "DESCRIPTION";
	     
	
	public TemplatesList(WebDriver _driver) throws Exception {
		super(_driver);
	this.driver = _driver;
	objWaitForElement = new WaitForElement(this.driver);
	objFrames = new Frames(this.driver);
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Templates List' page is displayed.
	* Date 		  : 07-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public TemplatesList verTemplatesListPageIsDisplayed()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(templateList, "xpath");
		assertTrue(this.page.element(templateList, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Part No' text field.
	* Date 		  : 07-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public TemplatesList enterTextInPartNoField(String file)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(partNo, "xpath");
		this.page.element(partNo, "xpath").getOne().clear();
		this.page.element(partNo, "xpath").getOne().sendKeys(file);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Template group' text field.
	* Date 		  : 07-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public TemplatesList enterTextInTemplateGroupField(String file)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(templateGroupTextField, "xpath");
		this.page.element(templateGroupTextField, "xpath").getOne().clear();
		this.page.element(templateGroupTextField, "xpath").getOne().sendKeys(file);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on search button in 'Templates List' page.
	* Date 		  : 07-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public TemplatesList clickOnSearch()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(search, "xpath");
		this.page.element(search, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on AddTemplate button in 'Templates List' page.
	* Date 		  : 07-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public TemplatesList clickOnAddTemplate()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(addTemplate, "xpath");
		this.page.element(addTemplate, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select templates.
	* Date 		  : 07-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public boolean selectTemplates(String temp) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		String str1 = "//td[contains(text(),'" + temp
				+ "')]/..//input[@name='BATCH']";
		try {
			List<WebElement> elements = driver.findElements(By.xpath(str1));
			for (WebElement all : elements) {
				all.click();
			}
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}

	}
	
	/**********************************************************************************
	* Description : This function is to select templates.
	* Date 		  : 07-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public boolean selectTemplates1(String temp) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		String str1 = "//td[contains(text(),'" + temp
				+ "')]/..//input[@name='BATCH']";
		if(this.page.element(noEntry, "xpath").isElementPresent()==true){
			return false;
		}
		else{
			List<WebElement> elements = driver.findElements(By.xpath(str1));
			for (WebElement all : elements) {
				all.click();
		}
			this.deleteAllSelectedTemplates();
			return true;
		}
	}


	/**********************************************************************************
	* Description : This function is to delete all the selected templates.
	* Date 		  : 07-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public boolean deleteAllSelectedTemplates() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		try {
			objWaitForElement.waitForElements(deleteTemplates, "xpath");
			this.page.element(deleteTemplates, "xpath").getOne().click();
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}
	
	/**********************************************************************************
	* Description : This function is to delete a selected templates.
	* Date 		  : 07-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public TemplatesList deleteATemplates(String template) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		String str = "//td[text()='"
				+ template
				+ "']//following-sibling::td//a//img[@src='/.cobalt/images/delete.gif']";
		objWaitForElement.waitForElements(str, "xpath");
		this.page.element(str, "xpath").getOne().click();

		return this;

	}
	
	/**********************************************************************************
	* Description : This function is to click on browse button.
	* Date 		  : 07-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public TemplatesList clickOnBrowse(String file)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(browse, "xpath");
		this.page.element(browse, "xpath").getOne().sendKeys(file);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select Template Type.
	* Date 		  : 07-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public TemplatesList selTemplateType(String temptype)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(selectTempType, "xpath");
		this.page.element(selectTempType, "xpath").webElementToSelect().selectByVisibleText(temptype);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on clear log button.
	* Date 		  : 07-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public TemplatesList clickOnClearLog()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(clearLog, "xpath");
		this.page.element(clearLog, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on import button.
	* Date 		  : 07-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public TemplatesList clickOnImport()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(importButton, "xpath");
		this.page.element(importButton, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Template Successfully Imported' message is displayed.
	* Date 		  : 07-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public TemplatesList verTemplateSuccessfullyImportedMsg()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMessageInRightFrame();
		objWaitForElement.waitForElements(tempSuccessfullyImportedMsg, "xpath");
		assertTrue(this.page.element(tempSuccessfullyImportedMsg, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on back button.
	* Date 		  : 07-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public TemplatesList clickOnBack()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(back, "xpath");
		this.page.element(back, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify template is displayed in 'template list' page.
	* Date 		  : 07-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public TemplatesList verTemplateIsPresent(String template)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements("//td[text()='"+template+"']", "xpath");
		assertTrue(this.page.element("//td[text()='"+template+"']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on modify button of a template.
	* Date 		  : 08-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public TemplatesList clickOnModifyTemplate(String template)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements("//td[text()='"+template+"']/..//img[@src='/.cobalt/images/modify.gif']", "xpath");
		this.page.element("//td[text()='"+template+"']/..//img[@src='/.cobalt/images/modify.gif']", "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Body Part' text field.
	* Date 		  : 08-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public TemplatesList enterTextInBodyPart(String str)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(bodyPart, "name");
		WebElement ele = this.page.element(bodyPart, "name").getOne();
		((JavascriptExecutor)this.driver).executeScript("arguments[0].value='"+str+"';",ele);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Template Group' text field in template list page .
	* Date 		  : 08-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public TemplatesList enterTextInTemplateGroup(String str)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(templateGroupTextField, "xpath");
		this.page.element(templateGroupTextField, "xpath").clearInputValue().sendKeys(str);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Template Group' text field in modify template page .
	* Date 		  : 08-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public TemplatesList enterTextInTemplateGroupInModifyTemplatePage(String str)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(templateGroupTextFieldInModifyTmplt, "xpath");
		WebElement ele = this.page.element(templateGroupTextFieldInModifyTmplt, "xpath").getOne();
		((JavascriptExecutor)this.driver).executeScript("arguments[0].value='"+str+"';",ele);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Orientation' text field.
	* Date 		  : 08-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public TemplatesList enterTextInOrientation(String str)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(orientation, "xpath");
		WebElement ele = this.page.element(orientation, "xpath").getOne();
		((JavascriptExecutor)this.driver).executeScript("arguments[0].value='"+str+"';",ele);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Size' text field.
	* Date 		  : 08-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public TemplatesList enterTextInSize(String str)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(size, "xpath");
		WebElement ele = this.page.element(size, "xpath").getOne();
		((JavascriptExecutor)this.driver).executeScript("arguments[0].value='"+str+"';", ele);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify modified template is displayed.
	* Date 		  : 08-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public TemplatesList verModifiedTemplate(String str, String str1,String str2)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements("//td[contains(text(),'"+str+"')]/preceding-sibling::td[text()='"+str1+"']/following-sibling::td[text()='"+str2+"']", "xpath");
		assertTrue(this.page.element("//td[text()='"+str+"']/preceding-sibling::td[text()='"+str1+"']/following-sibling::td[text()='"+str2+"']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'no entry' error message is displayed in template list page.
	* Date 		  : 08-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public TemplatesList verTemplateIsNotPresentErrMsg()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(noEntry, "xpath");
		assertTrue(this.page.element(noEntry, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'PartNo' text field in modify template page.
	* Date 		  : 08-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public TemplatesList enterTextInPartNoInModifyPage(String str)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(partNo1, "xpath");
		WebElement ele = this.page.element(partNo1, "xpath").getOne();
		((JavascriptExecutor)this.driver).executeScript("arguments[0].value='"+str+"';", ele);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on a delete icon of particular template.
	* Date 		  : 08-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public TemplatesList clickOnDeleteTemplate(String str) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements("//td[text()='" + str
				+ "']/..//img[@src='/.cobalt/images/delete.gif']", "xpath");
		this.page
				.element(
						"//td[text()='"
								+ str
								+ "']/..//img[@src='/.cobalt/images/delete.gif']",
						"xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'view template' icon in 'template list' page.
	* Date 		  : 27-Oct-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public TemplatesList clickOnViewTemplateIcon(String tmplt)
			throws Exception {
		String str = "//td[text()='"+tmplt+"']/following-sibling::td/a/img[@src='/.cobalt/images/search_icon_small.gif']";
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(str, "xpath");
		this.page.element(str, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'select/unselect all' checkbox in 'Templates List' page.
	* Date 		  : 28-Oct-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public TemplatesList selSelectOrUnselectAllCheckbox()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(selOrUnselectAll, "name");
		if(this.page.element(selOrUnselectAll, "name").getOne().isSelected()==false){
		this.page.element(selOrUnselectAll, "name").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'modify selected templates' icon in 'Templates List' page.
	* Date 		  : 28-Oct-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public TemplatesList clickOnModifySelectedTemplatesIcon()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(modifySelectedTemplates, "xpath");
		this.page.element(modifySelectedTemplates, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Modify Selected Templates' page is displaying.
	* Date 		  : 28-Oct-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public TemplatesList verModifySelectedTemplatesPage() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(modifySelectedTemplatesPage, "xpath");
		assertTrue(this.page.element(modifySelectedTemplatesPage, "xpath")
				.getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select all checkboxes under 'Templates Data' section
	*               in 'Modify Selected Templates' page.
	* Date 		  : 28-Oct-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public TemplatesList selAllTemplatesDataCheckBoxes() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		for (WebElement ele : this.page.element(templatesDataCheckBoxes, "xpath").get()) {
			ele.click();

		}
		Thread.sleep(3000);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Mirrored PartNo' text field in modify template page.
	* Date 		  : 28-Oct-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public TemplatesList enterTextInMirroredPartNo(String str)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(mirroredPN, "name");
		this.page.element(mirroredPN, "name").clearInputValue().sendKeys(str);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Calib Factor' text field in modify template page.
	* Date 		  : 28-Oct-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public TemplatesList enterTextInCalibFactor(String str)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(calibFactor, "name");
		this.page.element(calibFactor, "name").clearInputValue().sendKeys(str);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Rotation_Point_X' text field in modify template page.
	* Date 		  : 28-Oct-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public TemplatesList enterTextInRotation_Point_X(String str)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(rotation_Point_X, "name");
		this.page.element(rotation_Point_X, "name").clearInputValue().sendKeys(str);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Rotation_Point_Y' text field in modify template page.
	* Date 		  : 28-Oct-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public TemplatesList enterTextInRotation_Point_Y(String str)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(rotation_Point_Y, "name");
		this.page.element(rotation_Point_Y, "name").clearInputValue().sendKeys(str);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Description' text field in modify template page.
	* Date 		  : 28-Oct-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public TemplatesList enterTextInDescription(String str)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(description, "name");
		this.page.element(description, "name").clearInputValue().sendKeys(str);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify all modified template is displayed in Templates List page.
	* Date 		  : 28-Oct-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public TemplatesList verAllModifiedTemplateFields(String strBodypart,
			String tempgrp, String orient, String size, String partNo,
			String RPN, String tempnum) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		String str = "(//td[text()='" + strBodypart
				+ "']/following-sibling::td[text()='" + tempgrp + "']"
				+ "/following-sibling::td[text()='" + orient
				+ "']/following-sibling::td[text()='" + size
				+ "']/following-sibling::td[text()='" + partNo + "']"
				+ "/following-sibling::td[text()='" + RPN + "'])[" + tempnum
				+ "]";
		System.out.println(str+" required xpath");
		objWaitForElement.waitForElements(str, "xpath");
		assertTrue(this.page.element(str, "xpath").getOne().isDisplayed());
		return this;
	}

}
