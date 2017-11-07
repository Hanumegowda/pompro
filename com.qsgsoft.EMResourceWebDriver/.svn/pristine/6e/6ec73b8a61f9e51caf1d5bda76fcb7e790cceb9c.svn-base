package lib.page;

import static org.testng.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import qaframework.lib.WaitTimeConstants;
import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;

public class SelectRegion extends PageObject {

	WebDriver driver;
	WaitForElement objWaitForElement;
	
	public SelectRegion(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
		// TODO Auto-generated constructor stub
	}

	//Locators
	private String nextBtn = "input[value='Next']";
	private String regionList = "regionID",
			regionDefaultPage = "//div[@id='topSubNav']/h1",
			regionName = "//a[@id='regionName']",
			appSwitcher = "#header-selectApplication",
			intermedixLogo = "//img[@id='emLogo'][@src='/image/EMSystemsLogo.png']",
			accountManagement = "Account Management";

	/**********************************************************************************
	  * Description : This function is to click on 'Next' button
	  * Date        : 09/06/2014
	  * Author      : Anil
	  **********************************************************************************/
	public SelectRegion clickNextButton() throws Exception {
		objWaitForElement.waitForElements(nextBtn, "css");
		this.page.element(nextBtn, "css").getOne().click();
		Thread.sleep(8000);
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to select Region name
	  * Date        : 09/06/2014
	  * Author      : Anil
	  **********************************************************************************/
	public SelectRegion selectRegionName(String strRegionName) throws Exception {
		objWaitForElement.waitForElements(regionList, "id");
		this.page.element(regionList, "id").webElementToSelect().selectByVisibleText(strRegionName);
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to select Region name and click on 'Next' button
	  * Date        : 09/06/2014
	  * Author      : Anil
	  **********************************************************************************/	
	public SelectRegion selectRegionAndNavigate(String strRegionName)
			throws Exception {
		if (this.page.element("//frame[@name='Data']", "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_TOO_SMALL)) {
			WebDriverWait wait = new WebDriverWait(this.driver,
					WaitTimeConstants.WAIT_TIME_LONG);
			wait.until(ExpectedConditions
					.frameToBeAvailableAndSwitchToIt("Data"));
		}
		if (!this.page.element(regionDefaultPage, "xpath").getOne()
			     .getText().equals("Select Region")) {
			  this.clickRegionLink();
		}
		this.selectRegionName(strRegionName);
		this.clickNextButton();
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to click on 'Region' link
	  * Date		: 24/06/2014
	  * Author		: Yugender
	  **********************************************************************************/
	public SelectRegion clickRegionLink() throws Exception {
		objWaitForElement.waitForElements(regionName, "xpath");
		this.page.element(regionName, "xpath").clickUsingJSE();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is verify 'Select Region' page
	  * Date        : 05/08/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public SelectRegion verSelectRegionPage() throws Exception {
		objWaitForElement.waitForElements(regionDefaultPage, "xpath");
		String strText = this.page.element(regionDefaultPage, "xpath").getOne().getText();
		assertEquals("Select Region", strText);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is verify 'Select Region' page
	  * Date        : 05/08/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public SelectRegion verSelectRegionPageIsNotPresent() throws Exception {
		objWaitForElement.waitForElements(regionDefaultPage, "xpath");
		String strText = this.page.element(regionDefaultPage, "xpath").getOne().getText();
		assertNotEquals("Select Region", strText);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Region names
	  * Date        : 05/08/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public SelectRegion verRegionNameInDropdown(String[] regions)
			throws Exception {
		objWaitForElement.waitForElements(regionList, "id");
		List<WebElement> dropdown = this.page.element(regionList, "id")
				.webElementToSelect().getOptions();
		ArrayList<String> l1 = new ArrayList<String>(Arrays.asList(regions));
		Collections.sort(l1);
		ArrayList<String> l2 = new ArrayList<String>();
		for (WebElement webElement : dropdown) {
			String temp = webElement.getText();
			l2.add(temp);
		}
		assertTrue(l1.equals(l2), "Region are not found.");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select Region name 
	  * Date        : 08/06/2015
	  * Author      : Renushree
	  **********************************************************************************/	
	public SelectRegion selectRegion(String strRegionName)
			throws Exception {
		if (this.page.element("//frame[@name='Data']", "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_TOO_SMALL)) {
			WebDriverWait wait = new WebDriverWait(this.driver,
					WaitTimeConstants.WAIT_TIME_LONG);
			wait.until(ExpectedConditions
					.frameToBeAvailableAndSwitchToIt("Data"));
		}
		if (!this.page.element(regionDefaultPage, "xpath").getOne()
			     .getText().equals("Select Region")) {
			  this.clickRegionLink();
		}
		this.selectRegionName(strRegionName);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify instructions in select region page.
	  * Date        : 24/June/2015
	  * Author      : Renushree
	  **********************************************************************************/	
	public SelectRegion verInstructionInSelectRegPage() throws Exception {
		objWaitForElement
				.waitForElements(
						"//form/p[@class='emsInstructions'][contains(text(),'You have access to multiple regions. Please select which one you would like to view.')]",
						"xpath");
		assertTrue(
				this.page
						.element(
								"//form/p[@class='emsInstructions'][contains(text(),'You have access to multiple regions. Please select which one you would like to view.')]",
								"xpath").isElementPresent(),
				"Instruction not present");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Next' button
	  * Date        : 24/June/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public SelectRegion verNextButton() throws Exception {
		objWaitForElement.waitForElements(nextBtn, "css");
		assertTrue(this.page.element(nextBtn, "css").isElementPresent(), "Next button is not displayed");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify EMR version, build is dispalyed
	  * Date        : 24/June/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public SelectRegion verEMRBuildAndVersion(String strVersion, String strBuild)
			throws Exception {
		objWaitForElement.waitForElements(
				"//table[@summary='footer']/tbody/tr/td[2][contains(text(),'EMResource ® "
						+ strVersion + "-" + strBuild + "')]", "xpath");
		assertTrue(
				this.page.element(
						"//table[@summary='footer']/tbody/tr/td[2][contains(text(),'EMResource ® "
								+ strVersion + "-" + strBuild + "')]", "xpath")
						.isElementPresent(),
				"EMR version, build is not displayed");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify copy right,terms and conditions and privacy policy
	  * Date        : 24/June/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public SelectRegion verEMRCopyRightTermsAndConditions(String strYear)
			throws Exception {
		objWaitForElement.waitForElements(
				"//table[@summary='footer']/tbody/tr/td[1][text()='© "
						+ strYear + " Intermedix / EMSystems (']", "xpath");
		assertTrue(
				this.page.element(
						"//table[@summary='footer']/tbody/tr/td[1][text()='© "
								+ strYear + " Intermedix / EMSystems (']",
						"xpath").isElementPresent(),
				"Copy right is not displayed");
		assertTrue(
				this.page
						.element(
								"//table[@summary='footer']/tbody/tr/td[1]/a[text()='Terms & Conditions']",
								"xpath").isElementPresent(),
				"Terms and conditions is not displayed");
		assertTrue(
				this.page
						.element(
								"//table[@summary='footer']/tbody/tr/td[1]/a[text()='Privacy Policy']",
								"xpath").isElementPresent(),
				"Privacy policy is not displayed");
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to verify Intermedix logo
	  * Date        : 24/June/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public SelectRegion verEMRLogo() throws Exception {
		objWaitForElement.waitForElements(intermedixLogo, "xpath");
		assertTrue(this.page.element(intermedixLogo, "xpath")
				.isElementPresent(), "Intermedix logo is not displayed");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Intermedix logo
	  * Date        : 24/June/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public SelectRegion verAppSwitcher() throws Exception {
		objWaitForElement.waitForElements(appSwitcher, "css");
		assertTrue(this.page.element(appSwitcher, "css").isElementPresent(),
				"App switcher is not displayed");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Intermedix logo
	  * Date        : 24/June/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public SelectRegion clickOnAppSwitcherAndVerAccManagement()
			throws Exception {
		objWaitForElement.waitForElements(appSwitcher, "css");
		this.page.element(appSwitcher, "css").getOne().click();
		assertTrue(this.page.element(accountManagement, "linktext").isElementPresent(), "Account management not listed");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on Intermedix logo
	  * Date        : 24/June/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public SelectRegion clickOnEMRLogo() throws Exception {
		objWaitForElement.waitForElements(intermedixLogo, "xpath");
		this.page.element(intermedixLogo, "xpath").mouseOver();
		this.page.element(intermedixLogo, "xpath").getOne().sendKeys(Keys.RETURN);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on Intermedix logo
	  * Date        : 24/June/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public SelectRegion clickOnTermsAndConditions() throws Exception {
		objWaitForElement.waitForElements(intermedixLogo, "xpath");
		this.page.element(
				"//table[@summary='footer']/tbody/tr/td[1]/a[text()='Terms & Conditions']", "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on Intermedix logo
	  * Date        : 24/June/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public SelectRegion verTileOfIntermedix() throws Exception {
		String strTitleName = driver.getTitle();
		assertEquals("Technology and Analytics for Health and Safety | Intermedix", strTitleName);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on Intermedix logo
	  * Date        : 24/June/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public SelectRegion verTileOfTermsandServiceWin() throws Exception {
		String strTitleName = driver.getTitle();
		assertEquals("Intermedix | Terms and Conditions", strTitleName);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify region name field
	  * Date        : 24/June/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public SelectRegion verRegionNameField()
			throws Exception {
		objWaitForElement.waitForElements(regionList, "id");
		assertTrue(this.page.element(regionList, "id").isElementPresent(),
				"Region dropdown field not present");
		return this;
	}
	
	 /**********************************************************************************
	   * Description : This function is to get region name field
	   * Date        : 24/June/2015
	   * Author      : Anil
	   **********************************************************************************/
	 public String getRegionName()
	   throws Exception {
	  objWaitForElement.waitForElements(regionName, "xpath");
	  String strRegionName = this.page.element(regionName, "xpath").getOne()
	     .getText();
	  return strRegionName;
	 }
	 
	 /**********************************************************************************
	  * Description : This function is to verify title of window
	  * Date        : 15/Feb/2016
	  * Author      : Renushree
	  **********************************************************************************/
	public SelectRegion verTilte(String strTitle) throws Exception {
		String strTitleName = driver.getTitle();
		assertEquals(strTitle, strTitleName);
		return this;
	}
}