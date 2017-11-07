package page;



import java.util.List;

import module.Frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import qaframework.lib.WaitTimeConstants;
import qaframework.lib.pageObject.PageObject;
import qaframework.lib.userDefinedFunctions.WaitForElement;

public class AETitleRouting extends PageObject{
	WebDriver driver;
	WaitForElement objWaitForElement;
	Frames objFrames;
	UserManagement objUserManagement;
	
	private String allRoutes = "//tr//font[text()='Destination']/ancestor::tr/following-sibling::tr//img[@src='/cobalt-images/delete.gif']",
			       aeDestination = "//select[@name='route_ae']",
			       attribute1 = "//select[@name='tag']",
			       attribute2 = "//select[@name='tag2']",
			       attribute3 = "//select[@name='tag3']",
			       matchkey1 = "//input[@name='route_match']",
			       matchkey2 = "//input[@name='route_match2']",
			       matchkey3 = "//input[@name='route_match3']",
			       routeStudiesChkbx = "//input[@type='checkbox'][@name='route_studies']",
			       onlySignedReports = "//input[@type='radio'][@name='route_reports'][@value='1']",
			       allReports = "//input[@type='radio'][@name='route_reports'][@value='2']",
			       routingModeChkbx = "//input[@type='checkbox'][@name='route_transparent']";
			       
	
	public AETitleRouting(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
		objFrames = new Frames(this.driver);
		objUserManagement = new UserManagement(this.driver);
	}
	
	/**********************************************************************************
	* Description : This function is to delete existing route.
	* Date 		  : 15-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public boolean delAllExistingRoute() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		if (this.page.element(allRoutes, "xpath").isElementPresent() == true){
			objWaitForElement.waitForElements(allRoutes, "xpath");
			this.page.element(allRoutes, "xpath").getOne().click();
			objUserManagement.clickOnOkInAlertPopUp();
			Thread.sleep(3000);
		}
		if (this.page.element(allRoutes, "xpath").isElementPresent() == true){
			return true;
		}
		else {
			return false;
		}
		/*if (this.page.element(allRoutes, "xpath").isElementPresent() == true) {
			List<WebElement> allele = driver.findElements(By.xpath(allRoutes));
			for (WebElement ele : allele) {
				ele.click();
				objUserManagement.clickOnOkInAlertPopUp();
				Thread.sleep(10000);

			}
		}*/
	}
	
	/**********************************************************************************
	* Description : This function is to delete existing route.
	* Date 		  : 15-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public AETitleRouting delAllExistingRoute1() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		WebDriverWait wait = new WebDriverWait(this.driver, 20);
		objWaitForElement.waitForElements(allRoutes, "xpath");
		if ((this.page.element(allRoutes, "xpath")).isElementPresent() == true) {
			List<WebElement> ele = (this.page.element(allRoutes, "xpath"))
					.get();
			for (WebElement e : ele) {
				wait.until(ExpectedConditions.elementToBeClickable(e));
				e.click();
				objUserManagement.clickOnOkInAlertPopUp();
				Thread.sleep(10000);
			}
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to delete existing route.
	* Date 		  : 15-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public boolean delExistingRoute(String option) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		String str = "//font[contains(text(),'" + option
				+ "')]/../../..//img[@src='/cobalt-images/delete.gif']";
		objWaitForElement.waitForElements(str, "xpath");
		if (this.page.element(str, "xpath").isElementPresent() == true) {
			List<WebElement> allele = driver.findElements(By.xpath(str));
			for (WebElement ele : allele) {
				ele.click();
				objUserManagement.clickOnOkInAlertPopUp();
				Thread.sleep(10000);

			}
			return true;
		}
		else{
		return false;
		}
	}
	
	/**********************************************************************************
	* Description : This function is to select option in 'AE Destination for route' Drop Down.
	* Date 		  : 15-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public AETitleRouting selectAEDestinationInDropDown(String option)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(aeDestination, "xpath");
		this.page.element(aeDestination, "xpath").webElementToSelect()
				.selectByVisibleText(option);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select option in 'Attribute' of rule1 Drop Down.
	* Date 		  : 15-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public AETitleRouting selectAttributeInRule1DropDown(String option)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(attribute1, "xpath");
		this.page.element(attribute1, "xpath").webElementToSelect()
				.selectByVisibleText(option);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select option in 'Attribute' of rule2 Drop Down.
	* Date 		  : 15-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public AETitleRouting selectAttributeInRule2DropDown(String option)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(attribute2, "xpath");
		this.page.element(attribute2, "xpath").webElementToSelect()
				.selectByVisibleText(option);
		return this;
	}
	

	/**********************************************************************************
	* Description : This function is to select option in 'Attribute' of rule3 Drop Down.
	* Date 		  : 15-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public AETitleRouting selectAttributeInRule3DropDown(String option)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(attribute3, "xpath");
		this.page.element(attribute3, "xpath").webElementToSelect()
				.selectByVisibleText(option);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'match key' text field of rule1.
	* Date 		  : 15-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public AETitleRouting enterTextInMatchKeyOfRule1(String str)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(matchkey1, "xpath");
		this.page.element(matchkey1, "xpath").clearInputValue().sendKeys(str);
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'match key' text field of rule2.
	* Date 		  : 15-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public AETitleRouting enterTextInMatchKeyOfRule2(String str)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(matchkey2, "xpath");
		this.page.element(matchkey2, "xpath").clearInputValue().sendKeys(str);
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'match key' text field of rule3.
	* Date 		  : 15-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public AETitleRouting enterTextInMatchKeyOfRule3(String str)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(matchkey3, "xpath");
		this.page.element(matchkey3, "xpath").clearInputValue().sendKeys(str);
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on modify icon of a routing destination.
	* Date 		  : 18-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public AETitleRouting clickOnEditRoutingDestination(String str)
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements("//font[contains(text(),'" + str
				+ "')]/../../..//img[@src='/cobalt-images/modify.gif']",
				"xpath");
		this.page
				.element(
						"//font[contains(text(),'"
								+ str
								+ "')]/../../..//img[@src='/cobalt-images/modify.gif']",
						"xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to disable 'Route studies' checkbox.
	* Date 		  : 18-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public AETitleRouting disableRouteStudiesChechbox()
			throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(routeStudiesChkbx, "xpath");
		if(this.page.element(routeStudiesChkbx, "xpath").getOne().isSelected()==true){
			this.page.element(routeStudiesChkbx, "xpath").getOne().click();	
		}
				
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Route studies' checkbox.
	* Date 		  : 18-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public AETitleRouting selRouteStudiesChechbox() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(routeStudiesChkbx, "xpath");
		if (this.page.element(routeStudiesChkbx, "xpath").getOne().isSelected() == false) {
			this.page.element(routeStudiesChkbx, "xpath").getOne().click();
		}

		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Only signed reports' radio button in 'Route reports' field.
	* Date 		  : 18-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public AETitleRouting selOnlySignedReportsRadioButton() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(onlySignedReports, "xpath");
		if (this.page.element(onlySignedReports, "xpath").getOne().isSelected() == false) {
			this.page.element(onlySignedReports, "xpath").getOne().click();
		}

		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'All reports' radio button in 'Route reports' field.
	* Date 		  : 21-Sep-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public AETitleRouting selAllReportsRadioButton() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(allReports, "xpath");
		if (this.page.element(allReports, "xpath").getOne().isSelected() == false) {
			this.page.element(allReports, "xpath").getOne().click();
		}

		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Routing mode' checkbox.
	* Date 		  : 20-May-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public AETitleRouting selRoutingModeChechbox() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElements(routingModeChkbx, "xpath");
		if (this.page.element(routingModeChkbx, "xpath").getOne().isSelected() == false) {
			this.page.element(routingModeChkbx, "xpath").getOne().click();
		}

		return this;
	}
	

}
