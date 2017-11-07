package page;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;
import module.Frames;

import org.openqa.selenium.WebDriver;

import qaframework.lib.WaitTimeConstants;
import qaframework.lib.pageObject.PageObject;
import qaframework.lib.userDefinedFunctions.WaitForElement;

public class ReportTemplatesManagement extends PageObject{
	WebDriver driver;
	WaitForElement objWaitForElement;
	Frames objFrames;
	
	private String reportTemplatesManagementPage = "//b[text()='Report Templates Management']",
			       templateNameTextField = "search_string",
			       startSearch = "//input[@src='/cobalt-images/start_search.gif']",
			       strMngntBtn = "//img[@src='/.cobalt/images/mgmt_proc.gif']",
			       strUploadZipfile = "//input[@type='radio'][@value='upload']",
			       run = "//input[@type='button'][@value='Run']",
			       setTemplates = "//input[@type='button'][@value='Set templates']",
			       close = "//input[@type='BUTTON'][@value='Close']",
			       editorProperty = "//a[text()='Editor Property']",
			       tempPack = "//input[@type='TEXT'][@value=''][@name='value_add']",
			       selPackage = "//select[@name='set_package']",
			       selType = "//select[@name='set_type']",
			       selOwner = "//select[@name='set_owner']",
			      // aclModify = "//input[@id='ACLGroupType']/following-sibling::a//img[@src='/.cobalt/images/modify.gif']",
			    		   aclModify = "//input[@id='ACLGroupType']/../..//a/img[@src='/.cobalt/images/modify.gif']",
			       allCheckbox = "//td[contains(text(),'ALL')]/input[@type='checkbox']",
			       deleteAll = "(//img[@src='/.cobalt/images/delete.gif'])[last()]",
			       downloadSelectedTemplates = "//input[@type='radio'][@value='download_cpt']";
	
	public ReportTemplatesManagement(WebDriver _driver) throws Exception{
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
		objFrames = new Frames(this.driver);
		
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Report Templates Management' page is displayed.
	* Date 		  : 27-May-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ReportTemplatesManagement verReportTemplatesManagementPage() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(reportTemplatesManagementPage, "xpath");
		assertTrue(this.page.element(reportTemplatesManagementPage, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Template Name/Owner:' text field.
	* Date 		  : 27-May-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ReportTemplatesManagement enterTextInTemplateNameTextField(String temp) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(templateNameTextField, "id");
		this.page.element(templateNameTextField, "id").clearInputValue().sendKeys(temp);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Start Search' button.
	* Date 		  : 27-May-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ReportTemplatesManagement clickOnStartSearch() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(startSearch, "xpath");
		this.page.element(startSearch, "xpath").getOne().click();
		Thread.sleep(5000);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify delete icon is not present infront of a template.
	* Date 		  : 27-May-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ReportTemplatesManagement verDelATemplateIconNotPresent(String temp) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		String str = "//font[text()='"+temp+"']/parent::a/../..//img[@src='/.cobalt/images/delete.gif']";
		objWaitForElement.waitForElements(str, "xpath");
		assertFalse(this.page.element(str, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE1));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'No order entries' error message is not displaying.
	* Date 		  : 27-May-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ReportTemplatesManagement verNoOrderMsg() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		String str = "//td[text()='No order entries']";
		objWaitForElement.waitForElements(str, "xpath");
		assertTrue(this.page.element(str, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE1));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'delete' icon of a template.
	* Date 		  : 30-May-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ReportTemplatesManagement clickOnDeleteATemplate(String template) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		String str = "//font[text()='"+template+"']/../../..//img[@src='/.cobalt/images/delete.gif']";
		objWaitForElement.waitForElements(str, "xpath");
		this.page.element(str, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify a template is not present.
	* Date 		  : 30-May-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ReportTemplatesManagement verATemplateNotPresent(String temp) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		String str = "//font[text()='"+temp+"']";
		objWaitForElement.waitForElements(str, "xpath");
		assertFalse(this.page.element(str, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE1));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on a template link.
	* Date 		  : 31-May-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ReportTemplatesManagement clickOnATemplateLink(String template) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		String str = "//font[text()='"+template+"']";
		objWaitForElement.waitForElements(str, "xpath");
		this.page.element(str, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Modify pencil icon' of a template.
	* Date 		  : 01-Jun-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ReportTemplatesManagement clickOnModifyIconOfTemplate(String template) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		String str = "//font[text()='"+template+"']/../../..//img[@src='/.cobalt/images/modify.gif']";
		objWaitForElement.waitForElements(str, "xpath");
		this.page.element(str, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify modified template details is displayed.
	* Date 		  : 01-Jun-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ReportTemplatesManagement verModifiedTemplateDetails(String packag,
			String tempname, String type, String acl, String owner, String filtr)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		String str = "//td[contains(text(),'" + packag
				+ "')]/following-sibling::td//font[text()='" + tempname
				+ "']/../../following-sibling::td[contains(text(),'" + type
				+ "')]/following-sibling::td[contains(text(),'" + acl
				+ "')]/following-sibling::td[contains(text(),'" + owner
				+ "')]/following-sibling::td//font[contains(text(),'" + filtr
				+ "')]";
		objWaitForElement.waitForElements(str,
				"xpath");
		assertTrue(this.page.element(str, "xpath")
				.getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'management' button.
	* Date 		  : 06-Jun-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ReportTemplatesManagement clickOnManagement() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(strMngntBtn, "xpath");
		this.page.element(strMngntBtn, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Upload templates from .ZIP file' radio button.
	* Date 		  : 06-Jun-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ReportTemplatesManagement selUploadTemplateRadioButton() throws Exception {
		objWaitForElement.waitForElements(strUploadZipfile, "xpath");
		if(this.page.element(strUploadZipfile, "xpath").getOne().isSelected()==false){
		this.page.element(strUploadZipfile, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Run' button.
	* Date 		  : 06-Jun-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ReportTemplatesManagement clickOnRun() throws Exception {
		objWaitForElement.waitForElements(run, "xpath");
		this.page.element(run, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Set Templates' button.
	* Date 		  : 06-Jun-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ReportTemplatesManagement clickOnSetTemplates() throws Exception {
		objWaitForElement.waitForElements(setTemplates, "xpath");
		this.page.element(setTemplates, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Close' button.
	* Date 		  : 06-Jun-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ReportTemplatesManagement clickOnClose() throws Exception {
		objWaitForElement.waitForElements(close, "xpath");
		this.page.element(close, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify a template is present.
	* Date 		  : 06-Jun-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ReportTemplatesManagement verATemplateIsPresent(String temp) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		String str = "//font[text()='"+temp+"']";
		objWaitForElement.waitForElements(str, "xpath");
		assertTrue(this.page.element(str, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Editor Property' link.
	* Date 		  : 22-Jun-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ReportTemplatesManagement clickOnEditorProperty() throws Exception {
		objWaitForElement.waitForElements(editorProperty, "xpath");
		this.page.element(editorProperty, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Template Packages' text field in Editor properties page.
	* Date 		  : 22-Jun-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ReportTemplatesManagement enterTextInTemplatePackagesTextField(String temppack) throws Exception {
		objFrames.switchToDefaultFrame().switchToIFrame("oFrame0")/*.switchToFRMFrame()*/;
		objWaitForElement.waitForElements(tempPack, "xpath");
		/*this.page.element(tempPack, "xpath").mouseOver();
		this.page.element(tempPack, "xpath").getOne().click();*/
		this.page.element(tempPack, "xpath").clearInputValue().sendKeys(temppack);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Template Packages' in Editor properties page.
	* Date 		  : 22-Jun-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ReportTemplatesManagement verTemplatePackages(String temppack) throws Exception {
		String str = "//input[@type='TEXT'][@value='"+temppack+"']";
		objWaitForElement.waitForElements(str, "xpath");
		assertTrue((this.page.element(str, "xpath")).isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select package from dropdown in batch modify section.
	* Date 		  : 22-Jun-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ReportTemplatesManagement selPackage(String str) throws Exception {
		objWaitForElement.waitForElements(selPackage, "xpath");
		this.page.element(selPackage, "xpath").webElementToSelect().selectByVisibleText(str);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select Type from dropdown in batch modify section.
	* Date 		  : 22-Jun-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ReportTemplatesManagement selType(String str) throws Exception {
		objWaitForElement.waitForElements(selType, "xpath");
		this.page.element(selType, "xpath").webElementToSelect().selectByVisibleText(str);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select Type from dropdown in batch modify section.
	* Date 		  : 22-Jun-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ReportTemplatesManagement selOwner(String str) throws Exception {
		objWaitForElement.waitForElements(selOwner, "xpath");
		this.page.element(selOwner, "xpath").webElementToSelect().selectByVisibleText(str);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on modify icon of acl in batch modify section.
	* Date 		  : 22-Jun-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ReportTemplatesManagement clickOnAclModifyIcon() throws Exception {
		objWaitForElement.waitForElements(aclModify, "xpath");
		this.page.element(aclModify, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select ACL in batch modify section.
	* Date 		  : 22-Jun-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ReportTemplatesManagement selAcl(String acl) throws Exception {
		String str = "//input[@type='CHECKBOX'][@value='"+acl+"']";
		objWaitForElement.waitForElements(str, "xpath");
		if((this.page.element(str, "xpath")).getOne().isSelected()==false){
		this.page.element(str, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 	ALL checkbox in batch modify section.
	* Date 		  : 22-Jun-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ReportTemplatesManagement selAllCheckbox() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(allCheckbox, "xpath");
		if((this.page.element(allCheckbox, "xpath")).getOne().isSelected()==false){
		this.page.element(allCheckbox, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on delete icon in batch modify section.
	* Date 		  : 22-Jun-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ReportTemplatesManagement clickOnDeleteIcon() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(deleteAll, "xpath");
		this.page.element(deleteAll, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select required template.
	* Date 		  : 27-Jun-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ReportTemplatesManagement selATemplate(String temp) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		String template = "//font[text()='"+temp+"']/ancestor::td/following-sibling::td//input[@type='checkbox']";
		objWaitForElement.waitForElements(template, "xpath");
		if(this.page.element(template, "xpath").getOne().isSelected()==false){
			this.page.element(template, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Download selected templates to .ZIP file' radio button.
	* Date 		  : 27-Jun-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ReportTemplatesManagement selDownloadSelectedTemplatesRadioButton() throws Exception {
		objWaitForElement.waitForElements(downloadSelectedTemplates, "xpath");
		if(this.page.element(downloadSelectedTemplates, "xpath").getOne().isSelected()==false){
		this.page.element(downloadSelectedTemplates, "xpath").getOne().click();
		}
		return this;
	}

}
