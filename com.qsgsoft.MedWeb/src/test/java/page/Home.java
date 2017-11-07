package page;

import static org.testng.Assert.assertTrue;
import module.CommonFunctions;
import module.Frames;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import dataObject.Login_data;
import qaframework.lib.pageObject.PageObject;
import qaframework.lib.userDefinedFunctions.WaitForElement;

public class Home extends PageObject {
	WebDriver driver;
	WaitForElement objWaitForElement;
	Frames objFrames;
	Login objLogin;
	Login_data objLogin_data;
	CommonFunctions objCommonFunctions;

	private String homePageLogo = "//img[@src='/cobalt-images/a_top_logo.gif']",
			adminSite = "//a[text()='Admin Site']",
			adminSite1 = "//img[@src='/cobalt-images/p_admin_but_on.gif']",
			viewPatients	= "//a[text()='View Patients']",
			viewPatients11 = "//img[@src='/cobalt-images/p_view_patients_but_off.gif']",
			viewPatients1 = "img[src='/cobalt-images/p_view_patients_but_on.gif']",
			Continuetothiswebsite = "//a[contains(text(),'Continue to this website (not recommended).')]",
			Consent = "//input[@value='I Consent']",
			groups = "//a[text()='Groups']",
			groups1 = "//img[@src='/.cobalt/images/a_group_but_off.gif']",
			logout = "//a[text()='Logout']",
		    personalProfile = "//a[text()='Personal Profile']",
		    statistics = "//a[text()='Statistics']",
		    statistics1 = "//img[@src='/cobalt-images/statistics_on.gif']",
		    thisPageCantDisplayed = "//div[contains(text(),'This page can’t be displayed')]",
		    patientSchedule = "//a[text()='Patient Schedule']",
		    patientSchedule1 = "//img[@src='/cobalt-images/schedule_on.gif']",
		    admit = "//button[text()='Admit']",
		    monitor = "//a[text()='Monitor']",
		    serverInformation = "//b[text()='Server Information']",
		    homeButton = "//a[text()='Home']",
		    cloudConsult = "//button[text()='Cloud Consult']";

	public Home(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
		objFrames = new Frames(this.driver);
		objLogin = new Login(this.driver);
		objLogin_data = new Login_data();
		objCommonFunctions = new CommonFunctions(this.driver);
	}
	
	/**********************************************************************************
	* Description : This function is to verify home page of application
	* Date 		  : 15-Jun-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Home verHomePage() throws Exception {
		try{
		objFrames.switchToDefaultFrame().switchToMainMenuFrame();
		objWaitForElement.waitForElements(homePageLogo, "xpath");
		assertTrue(this.page.element(homePageLogo, "xpath").isElementPresent(),
				"Home page is not displayed");
		}
		catch(AssertionError ae){
			objLogin.login("admin", "medweb09").clickLogin();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'admin site' button
	* Date 		  : 15-Jun-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Home clickOnAdminSite() throws Exception {
		//Thread.sleep(3000);
		objFrames.switchToDefaultFrame().switchToMainMenuInLeftFrame();
		objWaitForElement.waitForElements(adminSite, "xpath");
		this.page.element_wait(adminSite, "xpath").waitForElementEnable();
		this.page.element(adminSite, "xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	* Description : This function is to click on 'admin site' button
	* Date 		  : 15-Jun-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Home clickOnAdminSite1() throws Exception {
		Thread.sleep(3000);
		objFrames.switchToDefaultFrame().switchToMainMenuInLeftFrame();
		objWaitForElement.waitForElements(adminSite, "xpath");
		this.page.element(adminSite, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'admin site' button
	* Date 		  : 15-Jun-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Home clickOnAdminSiteForSecTime() throws Exception {
		//Thread.sleep(3000);
		objFrames.switchToDefaultFrame().switchToMainMenuInLeftFrame();
		objWaitForElement.waitForElements(adminSite1, "xpath");
		this.page.element(adminSite1, "xpath").getOne().click();
		return this;
	}

	/*************************************************************************
	 * Description : This function is to click on view patients button
	 * Date        : 15-Jun-2015
	 * Author      : Hanumegowda
	 *************************************************************************/
	public Home clickOnViewPatients() throws Exception {
		objFrames.switchToDefaultFrame().switchToMainMenuInLeftFrame();
		objWaitForElement.waitForElements(viewPatients, "xpath");
		this.page.element(viewPatients, "xpath").mouseOver();
		this.page.element(viewPatients, "xpath").getOne().click();
		return this;
	}
	
	/*************************************************************************
	 * Description : This function is to click on view patients button
	 * Date        : 15-Jun-2015
	 * Author      : Hanumegowda
	 *************************************************************************/
	public Home clickOnViewPatients11() throws Exception {
		objFrames.switchToDefaultFrame().switchToMainMenuInLeftFrame();
		objWaitForElement.waitForElements(viewPatients11, "xpath");
		this.page.element(viewPatients11, "xpath").mouseOver();
		this.page.element(viewPatients11, "xpath").getOne().click();
		return this;
	}
	
	/*************************************************************************
	 * Description : This function is to click on Continue to this website link
	 * Date        : 15-Jun-2015
	 * Author      : Hanumegowda
	 *************************************************************************/
	public Home clickOnContinuetothiswebsite() throws Exception {
		objWaitForElement.waitForElements(Continuetothiswebsite, "xpath");
		this.page.element(Continuetothiswebsite, "xpath").getOne().click();
		return this;
	}
	
	/*************************************************************************
	 * Description : This function is to click on I Consent button
	 * Date        : 15-Jun-2015
	 * Author      : Hanumegowda
	 *************************************************************************/
	public Home clickOnIConsent() throws Exception {
		objWaitForElement.waitForElements(Consent, "xpath");
		this.page.element(Consent, "xpath").getOne().click();
		return this;
	}
	
	/*************************************************************************
	 * Description : This function is to launch the application
	 * Date        : 15-Jun-2015
	 * Author      : Hanumegowda
	 *************************************************************************/
	public Home launchApplication(String str) throws Exception {
		this.driver.get(str);
		/*if(str.equals(objLogin_data.strAppURL1)){
			objCommonFunctions.clickOnContinueToThisWebsiteLink();
			Thread.sleep(1000);
		}*/
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Groups' button
	* Date 		  : 22-Jun-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Home clickOnGroups() throws Exception {
		objFrames.switchToDefaultFrame().switchToLeftFrame()
		.switchToMainMenuInLeftFrame();
		objWaitForElement.waitForElements(groups, "xpath");
		this.page.element(groups, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Groups' button
	* Date 		  : 22-Jun-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Home clickOnGroups1() throws Exception {
		objFrames.switchToDefaultFrame().switchToLeftFrame()
		.switchToMainMenuInLeftFrame();
		objWaitForElement.waitForElements(groups1, "xpath");
		this.page.element(groups1, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'logout' button
	* Date 		  : 24-Jun-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Home clickOnLogOut() throws Exception {
		objFrames.switchToDefaultFrame().switchToLeftFrame()
		.switchToMainMenuInLeftFrame();
		objWaitForElement.waitForElements(logout, "xpath");
		this.page.element(logout, "xpath").getOne().click();
		Thread.sleep(3000);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'logout' button
	* Date 		  : 24-Jun-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Home clickOnLogOut92() throws Exception {
		objFrames.switchToDefaultFrame().switchToLeftFrame()
		.switchToMainMenuInLeftFrame();
		objWaitForElement.waitForElements("//img[@src='/.cobalt/images/a_logout_but_off.gif']", "xpath");
		this.page.element("//img[@src='/.cobalt/images/a_logout_but_off.gif']", "xpath").getOne().click();
		return this;
	}
	
	/*************************************************************************
	 * Description : This function is to launch the application
	 * Date        : 15-Jun-2015
	 * Author      : Hanumegowda
	 *************************************************************************/
	public Home launchApplicationInSecondWindow() throws Exception {
		driver = new InternetExplorerDriver();
		//((JavascriptExecutor)driver).executeScript("window.open();");
		this.driver.get("http://192.168.27.93/cobalt/");
		return this;
	}
	
	/*************************************************************************
	 * Description : This function is to click on Personal Profile button.
	 * Date        : 30-Jul-2015
	 * Author      : Hanumegowda
	 *************************************************************************/
	public Home clickOnPersonalProfile() throws Exception {
		objFrames.switchToDefaultFrame().switchToMainMenuInLeftFrame();
		this.page.element(personalProfile, "xpath").getOne().click();
		return this;
	}
	
	/*************************************************************************
	 * Description : This function is to click on Statistics button
	 * Date        : 14-Aug-2015
	 * Author      : Hanumegowda
	 *************************************************************************/
	public Home clickOnStatistics() throws Exception {
		objFrames.switchToDefaultFrame().switchToMainMenuInLeftFrame();
		try{
		objWaitForElement.waitForElements(statistics, "xpath");
		this.page.element(statistics, "xpath").getOne().click();
		}
		catch(NoSuchElementException ele){
			objWaitForElement.waitForElements(statistics1, "xpath");
			this.page.element(statistics1, "xpath").getOne().click();
		}
		return this;
	}
	
	/*************************************************************************
	 * Description : This function is to click on Statistics button for second time.
	 * Date        : 14-Aug-2015
	 * Author      : Hanumegowda
	 *************************************************************************/
	public Home clickOnStatisticsForSecTime() throws Exception {
		objFrames.switchToDefaultFrame().switchToMainMenuInLeftFrame();
			objWaitForElement.waitForElements(statistics1, "xpath");
			this.page.element(statistics1, "xpath").getOne().click();
		return this;
	}
	
	/*************************************************************************
	 * Description : This function is to click on view patients button
	 * Date        : 15-Jun-2015
	 * Author      : Hanumegowda
	 *************************************************************************/
	public Home clickOnViewPatients1() throws Exception {
		objFrames.switchToDefaultFrame().switchToMainMenuInLeftFrame();
		this.page.element(viewPatients1, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'This page can’t be displayed' error message.
	* Date 		  : 05-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Home verThisPageCantDisplayedErrMsg() throws Exception {
		objWaitForElement.waitForElements(thisPageCantDisplayed, "xpath");
		assertTrue(this.page.element(thisPageCantDisplayed, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Patient Schedule' button
	* Date 		  : 06-Oct-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Home clickOnPatientSchedule() throws Exception {
		//Thread.sleep(3000);
		objFrames.switchToDefaultFrame().switchToMainMenuInLeftFrame();
		objWaitForElement.waitForElements(patientSchedule, "xpath");
		this.page.element(patientSchedule, "xpath").getOne().click();
		return this;
	}
	
	/*************************************************************************
	 * Description : This function is to click on 'Admit' button.
	 * Date        : 03-Nov-2015
	 * Author      : Hanumegowda
	 *************************************************************************/
	public Home clickOnAdmit() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(admit, "xpath");
		this.page.element(admit, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Patient Schedule' button for second time.
	* Date 		  : 13-Apr-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Home clickOnPatientScheduleForSecTime() throws Exception {
		//Thread.sleep(3000);
		objFrames.switchToDefaultFrame().switchToMainMenuInLeftFrame();
		objWaitForElement.waitForElements(patientSchedule1, "xpath");
		this.page.element(patientSchedule1, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Monitor' button
	* Date 		  : 25-May-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Home clickOnMonitor() throws Exception {
		//Thread.sleep(3000);
		objFrames.switchToDefaultFrame().switchToMainMenuInLeftFrame();
		objWaitForElement.waitForElements(monitor, "xpath");
		this.page.element(monitor, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on Medweb logo.
	* Date 		  : 16-Sep-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Home clickOnMedwebLogo() throws Exception {
		objFrames.switchToMainMenuFrame();
		objWaitForElement.waitForElements(homePageLogo, "xpath");
		this.page.element(homePageLogo, "xpath").mouseOver();
		this.page.element(homePageLogo, "xpath").getOne().click();
		return this;
		
}
	
	/**********************************************************************************
	* Description : This function is to verify 'Server Information' page is displaying.
	* Date 		  : 16-Sep-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Home verServerInformationPage() throws Exception {
		//objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(serverInformation, "xpath");
		assertTrue(this.page.element(serverInformation, "xpath").isElementPresent());
		return this;
		
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Server Information' message is displaying.
	* Date 		  : 16-Sep-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Home verServerInformationMessage(String msg) throws Exception {
		//objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		String str = "//p[text()='"+msg+"']";
		objWaitForElement.waitForElements(str, "xpath");
		assertTrue(this.page.element(str, "xpath").isElementPresent());
		return this;
		
	}
	
	/**********************************************************************************
	* Description : This function is to verify home button is displaying in application home page 
	* Date 		  : 18-Oct-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public Home verHomeButton() throws Exception {
		objFrames.switchToMainMenuFrame();
		objWaitForElement.waitForElements(homeButton, "xpath");
		assertTrue(this.page.element(homeButton, "xpath").isElementPresent(),
				"Home page is not displayed");

		return this;
	}
	
	/*************************************************************************
	 * Description : This function is to click on 'Cloud Consult' button.
	 * Date        : 01-Dec-2016
	 * Author      : Hanumegowda
	 *************************************************************************/
	public Home clickOnCloudConsult() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(cloudConsult, "xpath");
		this.page.element(cloudConsult, "xpath").getOne().click();
		return this;
	}
}
