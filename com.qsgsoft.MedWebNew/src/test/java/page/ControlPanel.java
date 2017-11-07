package page;

import static org.testng.Assert.assertTrue;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import module.Frames;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import qaframework.lib.userDefinedFunctions.Date_Time_settings;
import qaframework.lib.pageObject.PageObject;
import qaframework.lib.userDefinedFunctions.WaitForElement;
import qaframework.lib.webElements.WebdriverWait;

public class ControlPanel extends PageObject {
	
	WebDriver driver;
	WaitForElement objWaitForElement;
	Frames objFrames;
	
	private String serviceSettings = "//font/b[text()='Service Settings']",
			       localSiteInfo = "//a[text()='Local Site Info']",
			       localSiteInfo1 = "//img[@src='/.cobalt/images/a_top_local_site_info.gif']",
			       time = "//a[text()='Time']",
			       time1 = "//img[@src='/.cobalt/images/a_top_control_time.gif']",
			       month = "//select[@name='month']//option[@selected='']",
			       hour = "//select[@name='hour']//option[@selected='']",
			       minute = "//select[@name='minute']//option[@selected='']",
			       date = "//select[@name='date']//option[@selected='']",
			       selMonth = "//select[@name='month']",
			       selDate = "//select[@name='date']",
			       nTPServerAddress = "//input[@name='ntpserver']",
			       synchronizeNow = "//a[text()='Synchronize Now']",
			       devicesChecker = "//td[contains(text(),'DICOM Devices Checker')]/..//a[text()='Parameters...']",
			       dICOMDevicesCheckerSettings = "//b[contains(text(),'Devices Checker Settings')]",
			       enableDICOMDevicesChecker = "//input[@type='CHECKBOX'][@name='SERVICE_ENABLE']",
			       year = "//select[@name='year']//option[@selected='']",
			       workflowProxy = "//td[contains(text(),'Workflow proxy')]/..//a[text()='Parameters...']",
			       workflowProxyConfiguration = "//b[text()='Workflow proxy configuration']",
			       addRule = "//a[text()='Add Rule']",
			       workflowProxyAddNewRule = "//b[text()='Workflow proxy - Add new rule']",
			       listenToPort = "SPORT",
			       function = "//select[@name='FUNC']",
			       forwardToHost = "HOST",
			       port = "DPORT",  
			       HL7Router = "//td[contains(text(),'HL7 Router')]/..//a[text()='Parameters...']",
			       medwebStatistics = "//td[contains(text(),'Medweb Statistics')]/..//a[text()='Parameters...']",
			       statisticsServersTab = "//a[text()='Statistics Servers']",
			       add = "//a[text()='Add New Public Key']",
			       addNewServer = "//a[text()='Add New Server']",
			       medwebSecureTunnel = "//td[contains(text(),'Medweb Secure Tunnel')]/..//a[text()='Parameters...']",
			       HL7Server = "//td[contains(text(),'HL7 Server')]/..//a[text()='Parameters...']",
			       accessRights = "//a[text()='Access Rights']",
			       accessRights1 = "//img[@src='/.cobalt/images/a_top_control_access.gif']",
			       restrictedRadioBtnUserAddRemove = "//td[contains(text(),'Restricted')]//input[@name='usermanage']",
			       openRadioBtnUserAddRemove = "//td[contains(text(),'Open')]//input[@name='usermanage']",
			       timeSettings = "//font/b[text()='Time Settings']",
			       selYear = "//select[@name='year']",
			       selHour = "//select[@name='hour']",
			       selMinutes = "//select[@name='minute']",
			       getMonth = "//select[@name='month']/option[@selected='']",
			       getDate = "//select[@name='date']/option[@selected='']",
			       getYear = "//select[@name='year']/option[@selected='']",
			       getHour = "//select[@name='hour']/option[@selected='']",
			       getMinute = "//select[@name='minute']/option[@selected='']",
			       auditLogs = "//img[@src='/.cobalt/images/a_top_audit_log.gif']",
			       serverNameDropDown = "//td[contains(text(),'Server name')]/..//select",
			       saveChanges = "//a[text()='Save Changes']",
			       patientsPageLayout = "//td[contains(text(),'Patients Page Layout')]/..//a[text()='Parameters...']",
			       clone = "img[src='/.cobalt/images/ris_tmpl_clone.gif']",
			       restrictedRadioBtnOfPublicSiteAccess  = "//td[contains(text(),'Restricted')]//input[@name='cobalthomeaccess']",
			       openRadioBtnOfPublicSiteAccess = "//td[contains(text(),'Open')]//input[@name='cobalthomeaccess']",
			       telemedicineSettingsPage = "//td[text()='Telemedicine settings page']/following-sibling::td//a[text()='Parameters...']";
			       
	
	public ControlPanel(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver= _driver;
		objWaitForElement = new WaitForElement(this.driver);
		objFrames = new Frames(this.driver);
	}
	
	Date_Time_settings objDate_Time_settings = new Date_Time_settings();
	
	/**********************************************************************************
	* Description : This function is to verify Service Settings page is displayed.
	* Date 		  : 19-Jun-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel verServiceSettings() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(serviceSettings, "xpath");
		this.page.element(serviceSettings, "xpath").getOne().isDisplayed();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on local site info field.
	* Date 		  : 19-Jun-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel clickOnLocalSiteInfo() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToSubMenuInRightFrame();
		objWaitForElement.waitForElements(localSiteInfo, "xpath");
		this.page.element(localSiteInfo, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on local site info field.
	* Date 		  : 19-Jun-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel clickOnLocalSiteInfo1() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToSubMenuInRightFrame();
		objWaitForElement.waitForElements(localSiteInfo1, "xpath");
		this.page.element(localSiteInfo1, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on Time field.
	* Date 		  : 19-Jun-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel clickOnTime() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToSubMenuInRightFrame();
		objWaitForElement.waitForElements(time, "xpath");
		this.page.element(time, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on Time field.
	* Date 		  : 19-Jun-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel clickOnTime1() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToSubMenuInRightFrame();
		objWaitForElement.waitForElements(time1, "xpath");
		this.page.element(time1, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to get current month.
	* Date 		  : 29-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public String getCurrentMonth() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(month, "xpath");
		String str = this.page.element(month, "xpath").getOne().getText();
		System.out.println(str);
		return str;
	}
	
	/**********************************************************************************
	* Description : This function is to get current date.
	* Date 		  : 29-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public String getCurrentDate() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(date, "xpath");
		String str = this.page.element(date, "xpath").getOne().getText();
		if((Integer.parseInt(str))<10){
			str="0"+str;
		}
		System.out.println(str);
		return str;
	}
	
	/*************************************************************************
	 * Description : This function is to select Future Date
	 * Date        : 29-Jul-2015
	 * Author 	   : Hanumegowda
	 *************************************************************************/
	public String selectFutureDate(String strNumberOfDays) throws Exception {
		String strDate = "";
		String strTimeText = objDate_Time_settings.getCurrentDate("yyyy MMM dd");
		int noOfDays = Integer.parseInt(strNumberOfDays);
		String str = objDate_Time_settings.AddDaytoExistingDate(strTimeText,noOfDays,"yyyy MMM dd");
		String[] strMDY = str.split(" ");
		String strYear = strMDY[0];
		String strMonth = strMDY[1];
		String str1 = strMDY[2];
		if (str1.startsWith("0")){
			strMDY = str1.split("0");	
			strDate = strMDY[1];			
		}
		else {
			strDate = strMDY[2];		
		}		
		String strFutureDate = strYear+" "+strMonth+" "+strDate;
//		this.selectDate(strDate);		
//		this.selectMonth(strMonth);			
//		this.selectYear(strYear);		
		return strFutureDate;
	}
	
	/**********************************************************************************
	* Description : This function is to click on Time field.
	* Date 		  : 29-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel selectRequiredMonth(String reqmonth) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(selMonth, "xpath");
		this.page.element(selMonth, "xpath").webElementToSelect().selectByVisibleText(reqmonth);
		return this;
		
	}
	
	/**********************************************************************************
	* Description : This function is to click on Time field.
	* Date 		  : 29-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel selectRequiredDate(String reqdate) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(selDate, "xpath");
		this.page.element(selDate, "xpath").webElementToSelect().selectByVisibleText(reqdate);
		return this;
		
	}
	
	/**********************************************************************************
	* Description : This function is to click on Time field.
	* Date 		  : 29-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel enterTextInNTPServerAddressField(String str) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(nTPServerAddress, "xpath");
		this.page.element(nTPServerAddress, "xpath").clearInputValue().sendKeys(str);
		return this;
		
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Synchronize Now' button.
	* Date 		  : 29-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel clickOnSynchronizeNowButton() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(synchronizeNow, "xpath");
		this.page.element(synchronizeNow, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on parameters link of DICOM Devices Checker.
	* Date 		  : 12-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel clickOnDICOMDevicesCheckerParametersLink() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(devicesChecker, "xpath");
		this.page.element(devicesChecker, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'DICOM Devices Checker Settings' page is displayed.
	* Date 		  : 12-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel verDICOMDevicesCheckerSettingsPage() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(dICOMDevicesCheckerSettings, "xpath");
		assertTrue(this.page.element(dICOMDevicesCheckerSettings, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Enable DICOM Devices Checker' checkbox.
	* Date 		  : 12-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel selEnableDICOMDevicesCheckerCheckbox() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(enableDICOMDevicesChecker, "xpath");
		if(this.page.element(enableDICOMDevicesChecker, "xpath").getOne().isSelected()==false){
			this.page.element(enableDICOMDevicesChecker, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to get current year.
	* Date 		  : 12-Jul-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public String getCurrentYear() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(year, "xpath");
		String str = this.page.element(year, "xpath").getOne().getText();
		System.out.println(str);
		return str;
	}
	
	/**********************************************************************************
	* Description : This function is to click on parameters link of 'Workflow proxy'.
	* Date 		  : 13-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel clickOnWorkflowProxyParametersLink() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(workflowProxy, "xpath");
		this.page.element(workflowProxy, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Workflow proxy configuration' page is displayed.
	* Date 		  : 13-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel verWorkflowProxyConfigurationPage() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(workflowProxyConfiguration, "xpath");
		assertTrue(this.page.element(workflowProxyConfiguration, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on addrule button.
	* Date 		  : 13-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel clickOnAddRule() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(addRule, "xpath");
		this.page.element(addRule, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Workflow proxy Add new rule' page is displayed.
	* Date 		  : 13-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel verWorkflowProxyAddNewRulePage() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(workflowProxyAddNewRule, "xpath");
		assertTrue(this.page.element(workflowProxyAddNewRule, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Listen to port' text field.
	* Date 		  : 13-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel enterTextInListenToPortField(String str) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(listenToPort, "id");
		this.page.element(listenToPort, "id").getOne().click();
		this.page.element(listenToPort, "id").clearInputValue().sendKeys(str);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select the option from 'Function' dropdown menu.
	* Date 		  : 13-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel selFunction(String str) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(function, "xpath");
		this.page.element(function, "xpath").webElementToSelect().selectByVisibleText(str);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in ' Forward to host' text field.
	* Date 		  : 13-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel enterTextInForwardToHostField(String str) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(forwardToHost, "id");
		this.page.element(forwardToHost, "id").clearInputValue().sendKeys(str);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Port' text field.
	* Date 		  : 13-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel enterTextInPortField(String str) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(port, "id");
		this.page.element(port, "id").clearInputValue().sendKeys(str);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on parameters link of 'HL7 Router'.
	* Date 		  : 13-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel clickOnHL7RouterParametersLink() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(HL7Router, "xpath");
		this.page.element(HL7Router, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on parameters link of ' Medweb Statistics'.
	* Date 		  : 14-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel clickOnMedwebStatisticsParametersLink() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(medwebStatistics, "xpath");
		this.page.element(medwebStatistics, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Statistics Servers' tab.
	* Date 		  : 14-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel clickOnStatisticsServersTab() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(statisticsServersTab, "xpath");
		this.page.element(statisticsServersTab, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Statistics Servers' tab.
	* Date 		  : 14-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel delExistingStatisticServer(String server) throws Exception {
		//Thread.sleep(5000);
		boolean b;
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame().switchToIFrame1("tabs-2")/*.switchToForm("index_serv.cgi")*/;
		String str1 = "//td[contains(text(),'"+server+"')]/following-sibling::td//a[last()]/img[@src='/.cobalt/images/delete.gif']";
		System.out.println(str1);
		do{
			if ((this.page.element(str1, "xpath")).isElementPresent() == true) {
				objWaitForElement.waitForElements(str1, "xpath");
				WebElement ele = this.page.element(str1, "xpath").getOne();
				((JavascriptExecutor)this.driver).executeScript("var elem=arguments[0]; setTimeout(function() {elem.click();}, 100)", ele);
				Thread.sleep(5000);
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_ENTER);
				r.keyRelease(KeyEvent.VK_ENTER);
				//Alert alert = this.driver.switchTo().alert();
				//alert.accept();
				Thread.sleep(10000);
				b = true;
			}
				else{
					b = false;
				}
			
		}while(b);
			return this;
		} 
	
	/**********************************************************************************
	* Description : This function is to click on 'Statistics Servers' tab.
	* Date 		  : 14-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel delExistingStatisticServer1(String server) throws Exception {
		Thread.sleep(10000);
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame().switchToIFrame1("tabs-2").switchToForm("index_serv.cgi");
		String str1 = "//td[contains(text(),'"+server+"')]/following-sibling::td//a[last()]/img[@src='/.cobalt/images/delete.gif']";
		System.out.println(str1);
			objWaitForElement.waitForElements(str1, "xpath");
				System.out.println(" hee aug 10");
				WebElement ele = driver.findElement(By.xpath(str1));
				JavascriptExecutor jse = (JavascriptExecutor)this.driver;
				//jse.executeScript("arguments[0].click();", ele);
				jse.executeScript("var elem=arguments[0]; setTimeout(function() {elem.click();}, 100)", ele);
				
				
			return this;
		} 
	
	
	/**********************************************************************************
	* Description : This function is to click on Add button.
	* Date 		  : 14-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel clickOnAdd() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(add, "xpath");
		this.page.element(add, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on Add new server button.
	* Date 		  : 14-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel clickOnAddNewServer() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame().switchToIFrame1("tabs-2");
		objWaitForElement.waitForElements(addNewServer, "xpath");
		((JavascriptExecutor)this.driver).executeScript("arguments[0].click()", this.page.element(addNewServer, "xpath").getOne());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify available status of a server.
	* Date 		  : 14-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel verAvailableStatus(String server) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame().switchToIFrame1("tabs-2");
		String str = "//td[contains(text(),'" + server
				+ "')]/following-sibling::td//b[text()='Available']";
		objWaitForElement.waitForElements(str, "xpath");
		assertTrue((this.page.element(str, "xpath")).isElementPresent());
		System.out.println("yes verified the avoilability status");
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on parameters link of ' Medweb Secure Tunnel'.
	* Date 		  : 14-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel clickOnMedwebSecureTunnelParametersLink() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(medwebSecureTunnel, "xpath");
		this.page.element(medwebSecureTunnel, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select option from 'Server name' dropdown.
	* Date 		  : 14-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel selServerName(String server) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame().switchToIFrame1("tabs-2");
		objWaitForElement.waitForElements(serverNameDropDown, "xpath");
		this.page.element("HOST", "id").clearInputValue().sendKeys(server);
		//this.page.element(serverNameDropDown, "xpath").webElementToSelect().selectByVisibleText(server);
		//this.page.element(serverNameDropDown, "xpath").webElementToSelect().selectByValue("172.16.27.92|172.16.27.92");
		Thread.sleep(5000);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on click on save changes in 'statistics servers' page.
	* Date 		  : 14-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel clickOnSaveChanges() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame()/*.switchToIFrame1("tabs-2")*/;
		objWaitForElement.waitForElements(saveChanges, "xpath");
		//this.page.element(saveChanges, "xpath").clickUjse();
		((JavascriptExecutor)this.driver).executeScript("arguments[0].click();", (this.page.element(saveChanges, "xpath")).getOne());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on parameters link of 'HL7 Server'.
	* Date 		  : 17-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel clickOnHL7ServerParametersLink() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(HL7Server, "xpath");
		this.page.element(HL7Server, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on AccessRights field.
	* Date 		  : 17-Jun-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel clickOnAccessRights() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToSubMenuInRightFrame();
		objWaitForElement.waitForElements(accessRights, "xpath");
		this.page.element(accessRights, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on AccessRights field.
	* Date 		  : 17-Jun-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel clickOnAccessRights1() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToSubMenuInRightFrame();
		objWaitForElement.waitForElements(accessRights1, "xpath");
		this.page.element(accessRights1, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select Restricted radio button of 'User Add and Remove' section.
	* Date 		  : 17-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel selRestrictedRadioBtnOfUserAddAndRemoveSection() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(restrictedRadioBtnUserAddRemove, "xpath");
		if(this.page.element(restrictedRadioBtnUserAddRemove, "xpath").getOne().isSelected()==false){
			this.page.element(restrictedRadioBtnUserAddRemove, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Open' radio button of 'User Add and Remove' section.
	* Date 		  : 19-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel selOpenRadioBtnOfUserAddAndRemoveSection() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(openRadioBtnUserAddRemove, "xpath");
		if(this.page.element(openRadioBtnUserAddRemove, "xpath").getOne().isSelected()==false){
			this.page.element(openRadioBtnUserAddRemove, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Time Settings' page is displayed.
	* Date 		  : 24-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel verTimeSettingsPage() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(timeSettings, "xpath");
		this.page.element(timeSettings, "xpath").getOne().isDisplayed();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select required year.
	* Date 		  : 24-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel selectRequiredYear(String reqyear) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(selYear, "xpath");
		this.page.element(selYear, "xpath").webElementToSelect().selectByVisibleText(reqyear);
		return this;
		
	}
	
	/**********************************************************************************
	* Description : This function is to select required hour.
	* Date 		  : 24-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel selectRequiredHour(String reqhour) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(selHour, "xpath");
		this.page.element(selHour, "xpath").webElementToSelect().selectByVisibleText(reqhour);
		return this;
		
	}
	
	/**********************************************************************************
	* Description : This function is to select required minutes.
	* Date 		  : 24-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel selectRequiredMinutes(String reqminutes) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(selMinutes, "xpath");
		this.page.element(selMinutes, "xpath").webElementToSelect().selectByVisibleText(reqminutes);
		return this;
		
	}
	
	/**********************************************************************************
	* Description : This function is to verify the month selected in dropdown.
	* Date 		  : 24-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel verMonth(String reqmonth) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(getMonth, "xpath");
		assertTrue((this.page.element(getMonth, "xpath").getOne().getText().contains(reqmonth)));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify the date selected in dropdown.
	* Date 		  : 24-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel verDate(String reqdate) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(getDate, "xpath");
		assertTrue((this.page.element(getDate, "xpath").getOne().getText().contains(reqdate)));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify the year selected in dropdown.
	* Date 		  : 24-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel verYear(String reqyear) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(getYear, "xpath");
		assertTrue((this.page.element(getYear, "xpath").getOne().getText().contains(reqyear)));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify the hour selected in dropdown.
	* Date 		  : 24-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel verHour(String reqhour) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(getHour, "xpath");
		assertTrue((this.page.element(getHour, "xpath").getOne().getText().contains(reqhour)));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify the minutes selected in dropdown.
	* Date 		  : 24-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel verMinutes(String reqminute) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(getMinute, "xpath");
		assertTrue((this.page.element(getMinute, "xpath").getOne().getText().contains(reqminute)));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Audit Log' field.
	* Date 		  : 25-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel clickOnAuditLogs() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToSubMenuInRightFrame();
		objWaitForElement.waitForElements(auditLogs, "xpath");
		this.page.element(auditLogs, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to get current hour time.
	* Date 		  : 05-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public String getCurrentHour() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(hour, "xpath");
		String str = this.page.element(hour, "xpath").getOne().getText();
		System.out.println(str);
		String str1 = str.substring(0, (str.length()-2));
		System.out.println(str1);
		return str1;
	}
	
	/**********************************************************************************
	* Description : This function is to get current hour time.
	* Date 		  : 05-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public String getCurrentHourIn24HrFrmt() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(hour, "xpath");
		String str = this.page.element(hour, "xpath").getOne().getAttribute("value");
		//String str1 = str.substring(0, (str.length()-2));
		System.out.println(str+" 24hr");
		return str;
	}
	
	/**********************************************************************************
	* Description : This function is to get current minute.
	* Date 		  : 13-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public String getCurrentMinute() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(minute, "xpath");
		String str = this.page.element(minute, "xpath").getOne().getText();
		System.out.println(str);
		return str;
	}
	
	/**********************************************************************************
	* Description : This function is to click on parameters link of 'Patients Page Layout'.
	* Date 		  : 03-Oct-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel clickOnPatientsPageLayoutParametersLink() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(patientsPageLayout, "xpath");
		this.page.element(patientsPageLayout, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on clone button.
	* Date 		  : 03-Oct-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel clickOnClone() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(clone, "css");
		this.page.element(clone, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter the text in new layout field.
	* Date 		  : 03-Oct-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel enterLayoutText(String layout) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements("//textarea", "xpath");
		this.page.element("//textarea", "xpath").getOne().clear();
		this.page.element("//textarea", "xpath").clearInputValue().sendKeys(layout);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select Restricted radio button of 'Public Site Access' section.
	* Date 		  : 12-Oct-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel selRestrictedRadioBtnOfPublicSiteAccessSection() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(restrictedRadioBtnOfPublicSiteAccess, "xpath");
		if(this.page.element(restrictedRadioBtnOfPublicSiteAccess, "xpath").getOne().isSelected()==false){
			this.page.element(restrictedRadioBtnOfPublicSiteAccess, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select Open radio button of 'Public Site Access' section.
	* Date 		  : 12-Oct-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel selOpenRadioBtnOfPublicSiteAccessSection() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(openRadioBtnOfPublicSiteAccess, "xpath");
		if(this.page.element(openRadioBtnOfPublicSiteAccess, "xpath").getOne().isSelected()==false){
			this.page.element(openRadioBtnOfPublicSiteAccess, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on parameters link of 'Telemedicine settings page'.
	* Date 		  : 09-Dec-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public ControlPanel clickOnTelemedicineSettingsPageParametersLink() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(telemedicineSettingsPage, "xpath");
		this.page.element(telemedicineSettingsPage, "xpath").getOne().click();
		return this;
	}
	
	
}
	
	