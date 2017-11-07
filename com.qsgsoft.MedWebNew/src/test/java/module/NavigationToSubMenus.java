package module;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import qaframework.lib.WaitTimeConstants;
import qaframework.lib.userDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;

public class NavigationToSubMenus extends PageObject {

	WebDriver driver;
	WaitForElement objWaitForElement;
	Frames objFrames;

	private String logout = "//img[@src='/.cobalt/images/a_logout_but_off.gif']",
			controlPanel = "//a[text()='Control Panel']",
			controlPanel11 = "//img[@src='/.cobalt/images/a_control_but_off.gif']",
			user = "//a[text()='Users']",
			user2 = "//img[@src='/.cobalt/images/a_users_but_on.gif']",
			user1 = "//img[@src='/.cobalt/images/a_users_but_off.gif']",
			publicSite = "//a[text()='Public Site']",
			groups = "//a[text()='Groups']",
			locations1 = "//img[@src='/.cobalt/images/a_locations_but_off.gif']",
			locations = "//a[text()='Locations']",
			dICOMSettings = "//a[text()='DICOM Settings']",
			dICOMSettings1 = "//img[@src='/.cobalt/images/a_DICOM_but_on.gif']",
			network = "//img[@src='/.cobalt/images/a_network_but_off.gif']",
			controlPanel1 = "//img[@src='/.cobalt/images/a_control_but_on.gif']",
			systemStatus = "//a[text()='System Status']",
			risSettings = "//a[text()='RIS Settings']",
			risSettings1 = "//img[@src='/.cobalt/images/a_RIS_settings_but_on.gif']",
			maintenance = "//a[text()='Maintenance']",
			serviceStatus = "//img[@src='/.cobalt/images/a_service_but_off.gif']",
			machineSchedule = "//a[text()='Machine Schedule']";

	public NavigationToSubMenus(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
		objFrames = new Frames(this.driver);
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'LogOut' button. 
	 * Date        : 15-Jun-2015 
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public NavigationToSubMenus clickOnLogout()
			throws Exception {
		objFrames.switchToDefaultFrame();
		objFrames.switchToLeftFrame().switchToMainMenuInLeftFrame();
		objWaitForElement.waitForElements(logout, "xpath");
		this.page.element(logout, "xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on 'LogOut' button. 
	 * Date        : 15-Jun-2015 
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public WebDriver clickOnLogout(boolean relaunch)
			throws Exception {
		objFrames.switchToDefaultFrame();
		objFrames.switchToLeftFrame().switchToMainMenuInLeftFrame();
		objWaitForElement.waitForElements(logout, "xpath");
		this.page.element(logout, "xpath").getOne().click();
		
		if (relaunch) 
		{
			WebDriver driver1;
			DesiredCapabilities dc = new DesiredCapabilities();
			dc = DesiredCapabilities.edge();
			dc.setJavascriptEnabled(true);

			// second instance
			System.setProperty("webdriver.edge.driver", System.getProperty(
					"webdriver.edge.driver",
					"./BrowserDrivers/MicrosoftWebDriver.exe"));
			driver1 = new EdgeDriver(dc);
			driver1.manage().window().maximize();
			driver1.manage()
					.timeouts()
					.implicitlyWait(WaitTimeConstants.WAIT_TIME_LONG,
							TimeUnit.SECONDS);
			driver1.manage()
					.timeouts()
					.pageLoadTimeout(WaitTimeConstants.WAIT_TIME_LONG,
							TimeUnit.SECONDS);
			
			System.out.println(this.driver.toString());
			
			System.out.println(driver1.toString());
			
			
			this.driver=driver1;
		}

		return driver;
	}

	/**********************************************************************************
	 * Description : This function is to click on 'ControlPanel' button. 
	 * Date        : 15-Jun-2015 
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public NavigationToSubMenus clickOnControlPanel() throws Exception {
		objFrames.switchToDefaultFrame().switchToLeftFrame()
				.switchToMainMenuInLeftFrame();
		objWaitForElement.waitForElements(controlPanel, "xpath");
		this.page.element(controlPanel, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'ControlPanel' button. 
	 * Date        : 15-Jun-2015 
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public NavigationToSubMenus clickOnControlPanel1() throws Exception {
		objFrames.switchToDefaultFrame().switchToLeftFrame()
				.switchToMainMenuInLeftFrame();
		objWaitForElement.waitForElements(controlPanel11, "xpath");
		this.page.element(controlPanel11, "xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on User button. 
	 * Date        : 19-Jun-2015
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public NavigationToSubMenus clickOnUser() throws Exception {
		objFrames.switchToDefaultFrame().switchToLeftFrame()
				.switchToMainMenuInLeftFrame();
			objWaitForElement.waitForElements(user, "xpath");
			this.page.element(user, "xpath").mouseOver();
			this.page.element(user, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on User button. 
	 * Date        : 19-Jun-2015
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public NavigationToSubMenus clickOnUser1() throws Exception {
		objFrames.switchToDefaultFrame().switchToLeftFrame()
				.switchToMainMenuInLeftFrame();
			objWaitForElement.waitForElements(user2, "xpath");
			this.page.element(user2, "xpath").mouseOver();
			this.page.element(user2, "xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on User button.
	 *  Date       : 19-Jun-2015 
	 *  Author     : Hanumegowda
	 **********************************************************************************/
	public NavigationToSubMenus clickOnUserForSecondTime() throws Exception {
		objFrames.switchToDefaultFrame().switchToLeftFrame()
				.switchToMainMenuInLeftFrame();
		objWaitForElement.waitForElements(user1, "xpath");
		this.page.element(user1, "xpath").mouseOver();
		this.page.element(user1, "xpath").getOne().click();

		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on Public Site button. Date :
	 * 19-Jun-2015 Author : Hanumegowda
	 **********************************************************************************/
	public NavigationToSubMenus clickOnPublicSite() throws Exception {
		objFrames.switchToDefaultFrame().switchToLeftFrame()
				.switchToMainMenuInLeftFrame();
		objWaitForElement.waitForElements(publicSite, "xpath");
		this.page.element(publicSite, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on Public Site button. Date :
	 * 19-Jun-2015 Author : Hanumegowda
	 **********************************************************************************/
	public NavigationToSubMenus clickOnPublicSite1() throws Exception {
		objFrames.switchToDefaultFrame().switchToLeftFrame()
				.switchToMainMenuInLeftFrame();
		objWaitForElement.waitForElements("//img[@src='/.cobalt/images/a_public_but_off.gif']", "xpath");
		this.page.element("//img[@src='/.cobalt/images/a_public_but_off.gif']", "xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on 'Groups' button Date :
	 * 22-Jun-2015 Author : Hanumegowda
	 **********************************************************************************/
	public NavigationToSubMenus clickOnGroups() throws Exception {
		objFrames.switchToDefaultFrame().switchToLeftFrame()
				.switchToMainMenuInLeftFrame();
		objWaitForElement.waitForElements(groups, "xpath");
		this.page.element(groups, "xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on Locations button. Date :
	 * 07-Jul-2015 Author : Hanumegowda
	 **********************************************************************************/
	public NavigationToSubMenus clickOnLocations() throws Exception {
		objFrames.switchToDefaultFrame();
		objFrames.switchToLeftFrame().switchToMainMenuInLeftFrame();
		objWaitForElement.waitForElements(locations, "xpath");
		this.page.element(locations, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on Locations button. Date :
	 * 07-Jul-2015 Author : Hanumegowda
	 **********************************************************************************/
	public NavigationToSubMenus clickOnLocations1() throws Exception {
		objFrames.switchToDefaultFrame();
		objFrames.switchToLeftFrame().switchToMainMenuInLeftFrame();
		objWaitForElement.waitForElements(locations1, "xpath");
		this.page.element(locations1, "xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on 'DICOM Settings' button. 
	 * Date        : 05-Aug-2015
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public NavigationToSubMenus clickOnDICOMSettings() throws Exception {
		objFrames.switchToDefaultFrame().switchToLeftFrame()
				.switchToMainMenuInLeftFrame();
		objWaitForElement.waitForElements(dICOMSettings, "xpath");
		this.page.element(dICOMSettings, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'DICOM Settings' button.
	 * Date        : 05-Aug-2015 
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public NavigationToSubMenus clickOnDICOMSettings1() throws Exception {
		objFrames.switchToDefaultFrame().switchToLeftFrame()
				.switchToMainMenuInLeftFrame();
		objWaitForElement.waitForElements("//img[@src='/.cobalt/images/a_DICOM_but_off.gif']", "xpath");
		this.page.element("//img[@src='/.cobalt/images/a_DICOM_but_off.gif']", "xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on 'DICOM Settings' button. Date
	 * : 05-Aug-2015 Author : Hanumegowda
	 **********************************************************************************/
	public NavigationToSubMenus clickOnDICOMSettingsForSecondTime()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToLeftFrame()
				.switchToMainMenuInLeftFrame();
		objWaitForElement.waitForElements(dICOMSettings1, "xpath");
		this.page.element(dICOMSettings1, "xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on 'Network' button. Date :
	 * 05-Aug-2015 Author : Hanumegowda
	 **********************************************************************************/
	public NavigationToSubMenus clickOnNetwork() throws Exception {
		objFrames.switchToDefaultFrame().switchToLeftFrame()
				.switchToMainMenuInLeftFrame();
		objWaitForElement.waitForElements(network, "xpath");
		this.page.element(network, "xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on 'ControlPanel' button for
	 * second time. Date : 15-Jun-2015 Author : Hanumegowda
	 **********************************************************************************/
	public NavigationToSubMenus clickOnControlPanelForSecondTime()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToLeftFrame()
				.switchToMainMenuInLeftFrame();
		objWaitForElement.waitForElements(controlPanel1, "xpath");
		this.page.element(controlPanel1, "xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on 'System Status' button. Date :
	 * 25-Aug-2015 Author : Hanumegowda
	 **********************************************************************************/
	public NavigationToSubMenus clickOnSystemStatus() throws Exception {
		objFrames.switchToDefaultFrame().switchToLeftFrame()
				.switchToMainMenuInLeftFrame();
		objWaitForElement.waitForElements(systemStatus, "xpath");
		this.page.element(systemStatus, "xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on 'RIS Settings' button. Date :
	 * 21-Sep-2015 Author : Hanumegowda
	 **********************************************************************************/
	public NavigationToSubMenus clickOnRISSettings() throws Exception {
		objFrames.switchToDefaultFrame().switchToLeftFrame()
				.switchToMainMenuInLeftFrame();
		objWaitForElement.waitForElements(risSettings, "xpath");
		this.page.element(risSettings, "xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on 'ControlPanel' button. Date :
	 * 15-Jun-2015 Author : Hanumegowda
	 **********************************************************************************/
	public NavigationToSubMenus clickOnMaintenance() throws Exception {
		objFrames.switchToDefaultFrame().switchToLeftFrame()
				.switchToMainMenuInLeftFrame();
		objWaitForElement.waitForElements(maintenance, "xpath");
		this.page.element(maintenance, "xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on 'Service Status' button. Date
	 * : 08-Oct-2015 Author : Hanumegowda
	 **********************************************************************************/
	public NavigationToSubMenus clickOnServiceStatus() throws Exception {
		objFrames.switchToDefaultFrame().switchToLeftFrame()
				.switchToMainMenuInLeftFrame();
		objWaitForElement.waitForElements(serviceStatus, "xpath");
		this.page.element(serviceStatus, "xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on Machine Schedule button. Date
	 * : 22-Apr-2016 Author : Hanumegowda
	 **********************************************************************************/
	public NavigationToSubMenus clickOnMachineSchedule() throws Exception {
		objFrames.switchToDefaultFrame().switchToMainMenuInLeftFrame();
		objWaitForElement.waitForElements(machineSchedule, "xpath");
		this.page.element(machineSchedule, "xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on 'RIS Settings' button for
	 * second time. Date : 09-Jun-2016 Author : Hanumegowda
	 **********************************************************************************/
	public NavigationToSubMenus clickOnRISSettingsForSecondTime()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToLeftFrame()
				.switchToMainMenuInLeftFrame();
		objWaitForElement.waitForElements(risSettings1, "xpath");
		this.page.element(risSettings1, "xpath").getOne().click();
		return this;
	}

}
