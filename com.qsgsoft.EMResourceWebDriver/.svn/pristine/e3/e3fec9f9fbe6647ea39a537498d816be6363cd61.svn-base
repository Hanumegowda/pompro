package lib.page;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import qaframework.lib.WaitTimeConstants;
import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;

public class Map extends PageObject {
	
	WebDriver driver;
	WaitForElement objWaitForElement;
	
	//Locators
	private String findResourceDropDown = "resourceFinder",
				   viewInfo = "View Info",
				   updateStatus = "Update Status",
				   headerName = "div#topSubNav > h1",
				   resourceName = "r_name",
				   refreshLink = "//a[@title='Refresh this page']",
				   eicsSecFrame = "hicsframe",
				   editInfo ="Edit Info",
				   strSaveAsReg="input[value='Save as Region Default']",
				   strEventRes="eventSelector",
				   detailView = "//h1[text()='Detail View']";

	public Map(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
	}
	
	/**********************************************************************************
	  * Description : This function is to select Resource name in Find resource dropdown
	  * Date        : 07/08/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public Map selectResourceNameInFindResourceDropdown(String strResourceName)
			throws Exception {
		objWaitForElement.waitForElements(findResourceDropDown, "id");
		this.page.element(findResourceDropDown, "id").webElementToSelect()
				.selectByVisibleText(strResourceName);
		Thread.sleep(3000);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify resource name in popup window
	  * Arguments	: strResource
	  * Date        : 07/08/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public Map verResourceNameInPopupWindow(String strResourceName)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='map']//div[@class='emsCenteredLabel'][text()='"
				+ strResourceName + "']", "xpath");
		assertTrue(
				this.page.element(
						"//div[@id='map']//div[@class='emsCenteredLabel'][text()='"
								+ strResourceName + "']", "xpath")
						.getOne().isDisplayed(), "Resource name is not present");
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to verify Status type names in popup window
	   * Date        : 07/08/2014
	   * Author      : Sowmya
	   **********************************************************************************/
	public Map verStatusTypesInPopupWindow(String[] strStatusTypesValue)
			throws Exception {
		objWaitForElement.waitForElements("div[class='emsText maxheight']", "css");
		
		String strStatusTypeNam = this.page
				.element("div[class='emsText maxheight']", "css").getOne()
				.getText();
		System.out.println("Data in popup: "+strStatusTypeNam);
		for (int i = 0; i < strStatusTypesValue.length; i++) {
			assertTrue(strStatusTypeNam.contains(strStatusTypesValue[i]));
		}
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify view info link in popup window
	  * Date        : 11/08/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public Map verViewInfoInPopupWindow()
			throws Exception {
		objWaitForElement.waitForElements(viewInfo, "linktext");
		assertTrue(
				this.page.element(
						viewInfo, "linktext")
						.getOne().isDisplayed(), "View Info is not present in pop window.");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify update status link in popup window
	  * Date        : 11/08/2014
	  * Author      : Renushree
	**********************************************************************************/
	public Map verUpdateStatusInPopupWindow()
			throws Exception {
		objWaitForElement.waitForElements(updateStatus, "linktext");
		assertTrue(
				this.page.element(
						updateStatus, "linktext")
						.getOne().isDisplayed(), "Update status is not present in pop window.");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on view info link in popup window
	  * Date        : 11/08/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public Map clickOnViewInfoInPopupWindow()
			throws Exception {
		objWaitForElement.waitForElements(viewInfo, "linktext");
		this.page.element(viewInfo, "linktext").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify view resource detail screen is displayed.
	  * Date        : 11/08/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public Map verViewResDetailScreenIsDisplayedWithResName(
			String strResourceName) throws Exception {
		objWaitForElement.waitForElements(detailView, "xpath");
		assertEquals("View Resource Detail",
				this.page.element(detailView, "xpath").getOne().getText());
		assertEquals(strResourceName, this.page.element(resourceName, "id")
				.getOne().getText(), "Resource name not displayed");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify status types under section
	  * Arguments	: strstatusType, strSection
	  * Date        : 11/08/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public Map verStatusTypesUnderSection(String[] strStatusType,
			String strSection) throws Exception {
		for (int i = 0; i < strStatusType.length; i++) {
			objWaitForElement.waitForElements("//a[text()='"
					+ strStatusType[i]
					+ "']/parent::td/parent::tr/parent::tbody/parent::table/thead/tr/th[2]/a[text()='"
					+ strSection + "']", "xpath");
		assertTrue(
				this.page
						.element(
								"//a[text()='"
										+ strStatusType[i]
										+ "']/parent::td/parent::tr/parent::tbody/parent::table/thead/tr/th[2]/a[text()='"
										+ strSection + "']", "xpath")
						.isElementPresent(),
				"Status type is not present under corresponding section.");
		}
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify status types under section
	  * Arguments	: strstatusType, strSection
	  * Date        : 11/08/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public Map verStatusTypesNotUnderSection(String[] strStatusType,
			String strSection) throws Exception {
		for (int i = 0; i < strStatusType.length; i++) {
			assertFalse(this.page
					.element(
							"//a[text()='"
									+ strStatusType[i]
									+ "']/parent::td/parent::tr/parent::tbody/parent::table/thead/tr/th[2]/a[text()='"
									+ strSection + "']", "xpath")
					.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		}
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify status types under section
	  * Arguments	: strstatusType, strSection
	  * Date        : 11/08/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public Map verStatusTypesUnderSection(String strStatusType,
			String strSection) throws Exception {
		objWaitForElement.waitForElements("//a[text()='"
				+ strStatusType
				+ "']/parent::td/parent::tr/parent::tbody/parent::table/thead/tr/th[2]/a[text()='"
				+ strSection + "']", "xpath");
		assertTrue(
				this.page
						.element(
								"//a[text()='"
										+ strStatusType
										+ "']/parent::td/parent::tr/parent::tbody/parent::table/thead/tr/th[2]/a[text()='"
										+ strSection + "']", "xpath")
						.isElementPresent(),
				"Status type is not present under corresponding section.");
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to click update status link in popup window 
	 * Date 		: 15/09/2014 
	 * Author 		: Renushree
	 **********************************************************************************/
	public Map clickUpdateStatusInPopupWindow() throws Exception {
		objWaitForElement.waitForElements(updateStatus, "linktext");
		this.page.element(updateStatus, "linktext").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to get update time
	 * Date 		: 15/09/2014 
	 * Author 		: Renushree
	 **********************************************************************************/
	public String getUpdatedTime(String strUpdatedVal) throws Exception {
		objWaitForElement.waitForElements("//div[@class='emsText maxheight']/span[text()='"
				+ strUpdatedVal
				+ "']/following-sibling::span[1]", "xpath");
		String strTime = this.page
				.element(
						"//div[@class='emsText maxheight']/span[text()='"
								+ strUpdatedVal
								+ "']/following-sibling::span[1]", "xpath")
				.getOne().getText();
		return strTime;
	}
	
	/**********************************************************************************
	* Description 	: This function is to verify 'Regional map view' page is displayed.
	* Date 			: 18/09/2014
	* Author 		: Sowmya
	**********************************************************************************/
	public Map verifyRegionalMapViewPgeIsDisplayed() throws Exception {
		objWaitForElement.waitForElements(headerName, "css");
		assertEquals("Regional Map View", this.page.element(headerName, "css")
				.getOne().getText());
		return this;
	}

	/**********************************************************************************
	 * Description 	: This function is to verify update time in first row
	 * Date 		: 18/09/2014 
	 * Author 		: Sowmya
	 **********************************************************************************/
	public String verifyUpdatedTimeInPopupWindow(String strUpdatedVal,
			String strUpdatedtime) throws Exception {
		Date_Time_settings objDate_Time_settings = new Date_Time_settings();

		String strUpdateTime = this.getUpdatedTime(strUpdatedVal);

		String strTime[] = strUpdateTime.split(" ");

		String strUpdatedTimeAddedOneMin = objDate_Time_settings
				.addTimetoExisting(strTime[2], 1, "HH:mm");

		String strUpdatedTime1 = strTime[0] + " " + strTime[1] + " "
				+ strUpdatedTimeAddedOneMin + " " + strTime[3];

		assertTrue(strUpdateTime.equals(strUpdatedtime)
				|| strUpdateTime.equals(strUpdatedTime1));

		if(strUpdateTime.equals(strUpdatedtime)){
			return strUpdatedtime;
		}else{
			return strUpdatedTime1;
		}
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify incident command section is displayed in view resource detail scrren
	 * Date 		: 20/10/2014 
	 * Author 		: Renushree
	 **********************************************************************************/
	public Map verIncidentCommandSystemSecIsDisplayed() throws Exception {
		objWaitForElement.waitForElements("//div[@id='hics']/div[2]/h1", "xpath");
		assertEquals("Incident Command System",
				this.page.element("//div[@id='hics']/div[2]/h1", "xpath")
						.getOne().getText());
		return this;
	}

	/**********************************************************************************
	 * Description 	: This function is to verify incident is displayed in view resource detail scrren
	 * Arguments	: strIncident,strIncDesc
	 * Date 		: 20/10/2014 
	 * Author 		: Renushree
	 **********************************************************************************/
	public Map verIncidentInViewResourceDetailScreen(String strIncident,
			String strIncDesc) throws Exception {
		WebDriverWait wait = new WebDriverWait(this.driver, WaitTimeConstants.WAIT_TIME_LONG);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(eicsSecFrame));
		objWaitForElement.waitForElements("//form[@id='form1']/div/h2[text()='" + strIncident
				+ "']/following-sibling::div[text()='" + strIncDesc
				+ "']", "xpath");
		assertTrue(this.page.element(
				"//form[@id='form1']/div/h2[text()='" + strIncident
						+ "']/following-sibling::div[text()='" + strIncDesc
						+ "']", "xpath").getOne().isDisplayed());
		driver.switchTo().defaultContent();
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify incident is not displayed in view resource detail scrren
	 * Arguments	: strIncident,strIncDesc
	 * Date 		: 20/10/2014 
	 * Author 		: Anil
	 **********************************************************************************/
	public Map verIncidentInViewResourceDetailScreenNotDisplayed(String strIncident,
			String strIncDesc) throws Exception {
		WebDriverWait wait = new WebDriverWait(this.driver, WaitTimeConstants.WAIT_TIME_LONG);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("hicsframe"));
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//form[@id='form1']/div/h2[text()='" + strIncident
						+ "']/following-sibling::div"), strIncDesc));
		assertFalse(this.page.element(
				"//form[@id='form1']/div/h2[text()='" + strIncident
						+ "']/following-sibling::div[text()='" + strIncDesc
						+ "']", "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		driver.switchTo().defaultContent();
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to click refresh link
	 * Date 		: 20/09/2014 
	 * Author 		: Anil
	 **********************************************************************************/
	public Map clickOnRefreshLink() throws Exception {
		this.page.element(refreshLink, "xpath").getOne().click();
		WebDriverWait wait = new WebDriverWait(this.driver, WaitTimeConstants.WAIT_TIME_LONG);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@id='reloadingText'][text()='reloading information']")));
		Thread.sleep(2000);
		while(this.page.element("//span[@id='reloadingText'][text()='reloading information']", "xpath").getOne().isDisplayed()==true){
			Thread.sleep(1000);
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify incident is displayed in view resource detail scrren
	 * Arguments	: strIncident,strIncDesc
	 * Date 		: 20/10/2014 
	 * Author 		: Anil
	 **********************************************************************************/
	public Map verIncidentInViewResourceDetailScreenNew(String[] strIncident,
			String[] strIncDesc) throws Exception {
		WebDriverWait wait = new WebDriverWait(this.driver, WaitTimeConstants.WAIT_TIME_LONG);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("hicsframe"));
		for(int intCount = 0;intCount<strIncident.length;intCount++){
			objWaitForElement.waitForElements("//form[@id='form1']/div/h2[text()='" + strIncident[intCount]
					+ "']/following-sibling::div[text()='" + strIncDesc[intCount]
					+ "']", "xpath");
		assertTrue(this.page.element(
				"//form[@id='form1']/div/h2[text()='" + strIncident[intCount]
						+ "']/following-sibling::div[text()='" + strIncDesc[intCount]
						+ "']", "xpath").isElementPresent());
		}
		driver.switchTo().defaultContent();
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify incident position and contact is displayed in view resource detail screen
	 * Arguments	: strIncident,strIncDesc
	 * Date 		: 03/11/2014 
	 * Author 		: Renushree
	 **********************************************************************************/
	public Map verIncidentPosAndContInViewResourceDetailScreen(
			String strIncident, String strPosition, String strContact)
			throws Exception {
		WebDriverWait wait = new WebDriverWait(this.driver,
				WaitTimeConstants.WAIT_TIME_LONG);
		wait.until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(eicsSecFrame));
		objWaitForElement.waitForElements("//form[@id='form1']/div/h2[text()='" + strIncident
				+ "']/parent::div/table/tbody/tr/td[1][text()='"
				+ strPosition + "']/following-sibling::td[text()='"
				+ strContact + "']", "xpath");
		assertTrue(this.page.element(
				"//form[@id='form1']/div/h2[text()='" + strIncident
						+ "']/parent::div/table/tbody/tr/td[1][text()='"
						+ strPosition + "']/following-sibling::td[text()='"
						+ strContact + "']", "xpath").getOne().isDisplayed());
		driver.switchTo().defaultContent();
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify incident position and contact is displayed in view resource detail screen is not diaplyed
	 * Arguments	: strIncident,strIncDesc
	 * Date 		: 05/11/2014 
	 * Author 		: Renushree
	 **********************************************************************************/
	public Map verIncidentPosAndContInViewResourceDetailScreenIsNotDisplayed(
			String strIncident, String strPosition, String strContact)
			throws Exception {
		WebDriverWait wait = new WebDriverWait(this.driver,
				WaitTimeConstants.WAIT_TIME_LONG);
		wait.until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(eicsSecFrame));
		assertFalse(this.page.element(
				"//form[@id='form1']/div/h2[text()='" + strIncident
						+ "']/parent::div/table/tbody/tr/td[1][text()='"
						+ strPosition + "']/following-sibling::td[text()='"
						+ strContact + "']", "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		driver.switchTo().defaultContent();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify updated values in popup window
	  * Date        : 12/02/2015
	  * Author      : Renushree
	**********************************************************************************/
	public Map verUpdateValuesInPopupWindow(String strUpdatedVal)
			throws Exception {
		objWaitForElement.waitForElements(
				"//span[text()='"
						+ strUpdatedVal
						+ "']", "xpath");
		assertTrue(this.page
				.element(
						"//span[text()='"
								+ strUpdatedVal
								+ "']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify incident is displayed in view resource detail scrren
	 * Arguments	: strIncident,strIncDesc
	 * Date 		: 20/10/2014 
	 * Author 		: Renushree
	 **********************************************************************************/
	public Map verIncidentInViewResourceDetailScreenOne(String strIncident,
			String strIncDesc) throws Exception {
//		driver.switchTo().defaultContent();
//		WebDriverWait wait = new WebDriverWait(this.driver, WaitTimeConstants.WAIT_TIME_LONG);
//		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(eicsSecFrame));
		objWaitForElement.waitForElements("//form[@id='form1']/div/h2[text()='" + strIncident
				+ "']/following-sibling::div[text()='" + strIncDesc
				+ "']", "xpath");
		assertTrue(this.page.element(
				"//form[@id='form1']/div/h2[text()='" + strIncident
						+ "']/following-sibling::div[text()='" + strIncDesc
						+ "']", "xpath").isElementPresent());
		driver.switchTo().defaultContent();
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify incident is not displayed in view resource detail scrren
	 * Arguments	: strIncident,strIncDesc
	 * Date 		: 20/10/2014 
	 * Author 		: Anil
	 **********************************************************************************/
	public Map verIncidentInViewResourceDetailScreenNotDisplayed() throws Exception {

		assertFalse(this.page.element(
				"//div[@class='title']/h1[text()='Incident Command System']", "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	/**********************************************************************************
	 * Description 	: This function is to verify incident is not displayed in view resource detail scrren
	 * Arguments	: strIncident,strIncDesc
	 * Date 		: 20/10/2014 
	 * Author 		: Anil
	 **********************************************************************************/
	public Map verIncidentInViewResourceDetailScreenNotPresent()
			throws Exception {
		try {
			assertFalse(this.page
					.element(
							"//div[@class='title']/h1[text()='Incident Command System']",
							"xpath").isElementPresent(
							WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		} catch (AssertionError e) {
			assertFalse(this.page
					.element(
							"//div[@class='title']/h1[text()='Incident Command System']",
							"xpath").getOne().isDisplayed());
		}
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to verify Status type names not in popup window
	   * Date        : 28/05/2014
	   * Author      : Anitha
	   **********************************************************************************/
	public Map verStatusTypesNotInPopupWindow(String[] strStatusTypesValue)
			throws Exception {
		objWaitForElement.waitForElements("div[class='emsText maxheight']", "css");
		String strStatusTypeNam = this.page
				.element("div[class='emsText maxheight']", "css").getOne()
				.getText();
		for (int i = 0; i < strStatusTypesValue.length; i++) {
			assertFalse(strStatusTypeNam.contains(strStatusTypesValue[i]));
		}
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify resource name in popup window
	  * Arguments	: strResource
	  * Date        : 07/08/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public Map verResourceNotInFindResourceDropDown(String strResourceName)
			throws Exception {		
		objWaitForElement.waitForElements("//select[@id='resourceFinder']", "xpath");
		assertFalse(this.page.element(
				"//select[@id='resourceFinder']/option[text()='"
						+ strResourceName + "']", "xpath").isElementPresent(
				WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on edit info
	  * Date        : 02/Jun/2015
	  * Author      : Anitha
	**********************************************************************************/
	public Map verfyEditInfoLinkNotPresent() throws Exception {
		assertFalse(this.page.element(editInfo, "linktext").isElementPresent(
				WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to click on edit info
	  * Date        : 02/Jun/2015
	  * Author      : Renushree
	**********************************************************************************/
	public Map clickOnEditInfo() throws Exception {
		objWaitForElement.waitForElements(editInfo, "linktext");
		this.page.element(editInfo, "linktext").getOne().click();
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to click on save Date : 23/07/2015 Author
	 * : Sangappa.k
	 **********************************************************************************/
	public Map verEventOnMap(
			String strEventName) throws Exception {
		String Res = "//select[@id='eventSelector']/option[text()='" + strEventName
				+ "']";
		objWaitForElement.waitForElements(Res, "xpath");
		this.page.element("//select[@id='eventSelector']", "xpath").getOne()
				.click();
		assertTrue(this.page.element(Res, "xpath").isElementPresent());
		return this;
	}
	
	
	/**********************************************************************************
	 * Description 	: This function is to verify Save As region button
	 * Date 		: 17-Dec-2015
	 * Author 		: Sangappa K
	 **********************************************************************************/
	public Map verAndClickSaveAsRegionBtn() throws Exception {
		objWaitForElement.waitForElements(strSaveAsReg, "css");
		assertTrue(
				"Save As region button  is not present in Regional map view",
				this.page.element(strSaveAsReg, "css").isElementPresent());
		this.page.element(strSaveAsReg, "css").getOne().click();
		Thread.sleep(10000);
		try {
			Alert alert = driver.switchTo().alert();
			assertTrue(
					alert.getText()
							.equals("The default region map view has been updated successfully."),
					"No pop up apears");
			alert.accept();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to verify resource name in popup window
	  * Arguments	: strResource
	  * Date        : 27/01/2016
	  * Author      : Renushree
	  **********************************************************************************/
	public Map verSTNotInStatusTypeDropDown(String strSTName)
			throws Exception {		
		assertFalse(this.page.element(
				"//select[@id='statusType']/option[text()='"
						+ strSTName + "']", "xpath").isElementPresent(
				WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify resource name in popup window
	  * Arguments	: strResource
	  * Date        : 27/01/2016
	  * Author      : Renushree
	  **********************************************************************************/
	public Map verSTInStatusTypeDropDown(String strSTName)
			throws Exception {		
		objWaitForElement.waitForElements("//select[@id='statusType']", "xpath");
		assertTrue(this.page.element(
				"//select[@id='statusType']/option[text()='"
						+ strSTName + "']", "xpath").isElementPresent(
				WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	/**********************************************************************************
	  * Description : This function is to verify status types under section
	  * Arguments	: strstatusType, strSection
	  * Date        : 11/08/2014
	  * Author      : Anitha
	  **********************************************************************************/
	public Map verStatusTypesNotUnderSectionNew(String[] strStatusType,
			String strSection) throws Exception {
		for (int i = 0; i < strStatusType.length; i++) {
			assertFalse(this.page.element(
					"//a[text()='" + strSection
							+ "']/ancestor::table/tbody/tr/td/a[text()='"
							+ strStatusType + "']", "xpath").isElementPresent(
					WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		}
		return this;
	}
		
		/**********************************************************************************
		  * Description : This function is to select Resource name in Find resource dropdown
		  * Date        : 15/3/2015
		  * Author      : Sangappa K
		  **********************************************************************************/
	public Map selectEventNameInEventResourceDropdown(String strEventName)
			throws Exception {
		objWaitForElement.waitForElements(strEventRes, "id");
		this.page.element(strEventRes, "id").webElementToSelect()
				.selectByVisibleText(strEventName);
		assertEquals(this.page.element(strEventRes, "id").webElementToSelect()
				.getFirstSelectedOption().getText(), strEventName);
		Thread.sleep(3000);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify resource name select resource drop down
	  * Arguments	: strResource
	  * Date        : 15/3/2015
	  * Author      : Sangappa K
	  **********************************************************************************/
	public Map verResourceInFindResourceDropDown(String strResourceName)
			throws Exception {		
		objWaitForElement.waitForElements("//select[@id='resourceFinder']", "xpath");
		assertTrue(this.page.element(
				"//select[@id='resourceFinder']/option[text()='"
						+ strResourceName + "']", "xpath").getOne().isDisplayed());
				
		return this;
	}
}