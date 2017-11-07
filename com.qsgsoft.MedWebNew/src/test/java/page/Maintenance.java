package page;

import module.Frames;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import qaframework.lib.pageObject.PageObject;
import qaframework.lib.userDefinedFunctions.WaitForElement;
import static org.testng.Assert.assertTrue;

public class Maintenance extends PageObject{
	WebDriver driver;
	WaitForElement objWaitForElement;
	Frames objFrames;
	
	static String transport = "//select[@name='TRANSPORT_TYPE']",
			      numOfBackups = "TRANSPORT_TYPE_2_STORAGE",
			      startBackup = "//a[text()='Start Backup']",
			      restore = "//a[text()='Restore']",
			      remoteServerAddress = "//input[@name='TRANSPORT_TYPE_3_SERVER']",
			      selectUnselectAll = "//input[@name='CHECKALL']",
			      browse = "//input[@type='file'][@name='backupfile']",
			      restoreBackUpFile = "//a[text()='Restore a Backup File']",
			      startRestore = "//img[@src='/.cobalt/images/start_restore.gif']",
			      backupSettings = "//b[text()='Backup Settings']",
			      medwebSpecificConfigurationChkBox = "DATA_MEDWEB",
			      medwebDatabaseDumpChkBox = "DATA_DB_DUMP";
			  
	
	public Maintenance(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
		objFrames = new Frames(this.driver);
	}
	
	/**********************************************************************************
	* Description : This function is to select option from 'Type of transport' Drop Down.
	* Date 		  : 29-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Maintenance selectOptionInTypeOfTransportDropDown(String option)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(transport, "xpath");
		this.page.element(transport, "xpath").webElementToSelect()
				.selectByVisibleText(option);
		//Thread.sleep(3000);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter the text in 'Number of backups' text field.
	* Date 		  : 29-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Maintenance enterTextInNumberOfBackups(String num)
			throws Exception {
		objWaitForElement.waitForElements(numOfBackups, "id");
		this.page.element(numOfBackups, "id").clearInputValue().sendKeys(num);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Start Backup' button.
	* Date 		  : 29-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Maintenance clickOnStartBackUpButton()
			throws Exception {
		objWaitForElement.waitForElements(startBackup, "xpath");
		this.page.element(startBackup, "xpath").mouseOver();
		this.page.element(startBackup, "xpath").getOne().sendKeys(Keys.ENTER);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Restore' button.
	* Date 		  : 29-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Maintenance clickOnRestoreButton()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToSubMenuInRightFrame();
		objWaitForElement.waitForElements(restore, "xpath");
		this.page.element(restore, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify backup file from host.
	* Date 		  : 29-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Maintenance verBackUpFileFromHost(String date,String date1)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		String ele = "(//b[text()='Backup Files from the Host']/../following::table/tbody/tr//td[contains(text(),'"+date+"')])[1]";
		System.out.println(ele);
		String ele1 = "(//b[text()='Backup Files from the Host']/../following::table/tbody/tr//td[contains(text(),'"+date1+"')])[1]";
		System.out.println(ele1);
		this.page.element("//b[text()='Backup Files from the Host']", "xpath").getOne().click();
		objWaitForElement.waitForElements(ele, "xpath");
		assertTrue((this.page.element(ele, "xpath").isElementPresent())||(this.page.element(ele1, "xpath").isElementPresent()));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify backup file from Remote servers.
	* Date 		  : 29-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Maintenance verBackUpFileFromRemoteServers(String date, String date1)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		String ele = "//b[text()='Backup Files from the Remote servers']/../following::table/tbody/tr//td[contains(text(),'"+date+"')]";
		System.out.println(ele);
		String ele1 = "//b[text()='Backup Files from the Remote servers']/../following::table/tbody/tr//td[contains(text(),'"+date1+"')]";
		System.out.println(ele1);
		objWaitForElement.waitForElements(ele, "xpath");
		 assertTrue((this.page.element(ele, "xpath").isElementPresent())||this.page.element(ele1, "xpath").isElementPresent());

		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter the text in 'Remote Server address' text field.
	* Date 		  : 30-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Maintenance enterTextInRemoteServerAddress(String num)
			throws Exception {
		objWaitForElement.waitForElements(remoteServerAddress, "xpath");
		this.page.element(remoteServerAddress, "xpath").sendkeysUJSE(num);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Select/Unselect All' checkbox.
	* Date 		  : 01-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Maintenance selSelectUnselectAllCheckBox()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(selectUnselectAll, "xpath");
		if(this.page.element(selectUnselectAll, "xpath").getOne().isSelected()==false){
			this.page.element(selectUnselectAll, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'browse' button.
	* Date 		  : 01-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Maintenance clickOnBrowseButton(String path)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(browse, "xpath");
		this.page.element(browse, "xpath").getOne().sendKeys(path);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Restore back up file' button.
	* Date 		  : 01-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Maintenance clickOnRestoreBackUpFileButton()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(restoreBackUpFile, "xpath");
		this.page.element(restoreBackUpFile, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Restore' button.
	* Date 		  : 01-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Maintenance clickOnStartRestoreButton()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(startRestore, "xpath");
		this.page.element(startRestore, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Restore configuration from backup file'
	*               icon next to the required backup file.
	* Date 		  : 05-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Maintenance clickOnRestoreConfiguration(String backupfile)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		String str = "//td[contains(text(),'"+backupfile+"')]/../..//img[@src='/.cobalt/images/restore_but.gif']";
		objWaitForElement.waitForElements(str, "xpath");
		this.page.element(str, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Backup Settings' page is displayed.
	* Date 		  : 14-Dec-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Maintenance verBackupSettingsPage()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(backupSettings, "xpath");
		this.page.element(backupSettings, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Medweb Specific Configuration' checkbox.
	* Date 		  : 25-Aug-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Maintenance selMedwebSpecificConfigurationCheckBox()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(medwebSpecificConfigurationChkBox, "name");
		if(this.page.element(medwebSpecificConfigurationChkBox, "name").getOne().isSelected()==false){
			this.page.element(medwebSpecificConfigurationChkBox, "name").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Medweb Database Dump' checkbox.
	* Date 		  : 25-Aug-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Maintenance selMedwebDatabaseDumpCheckBox()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(medwebDatabaseDumpChkBox, "name");
		if(this.page.element(medwebDatabaseDumpChkBox, "name").getOne().isSelected()==false){
			this.page.element(medwebDatabaseDumpChkBox, "name").getOne().click();
		}
		return this;
	}

}
