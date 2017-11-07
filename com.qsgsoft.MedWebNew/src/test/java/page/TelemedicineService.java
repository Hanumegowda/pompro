package page;

import static org.testng.Assert.assertTrue;
import module.Frames;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import qaframework.lib.WaitTimeConstants;
import qaframework.lib.pageObject.PageObject;
import qaframework.lib.userDefinedFunctions.WaitForElement;

public class TelemedicineService extends PageObject{
	WebDriver driver;
	WaitForElement objWaitForElement;
	Frames objFrames;
	
	public String general = "//span[text()='General']",
			      consMdDropdown = "m_ConsultingMD",
			      ln = "m_LastName",
			      fn = "m_FirstName",
			      monthDropdown = "m_DOB_month",
			      dayDropdown = "m_DOB_day",
			      yearDropdown = "m_DOB_year",
			      dataFiles = "li_TabHeader_DataFiles",
			      selImageSource = "select_DataFilesSource_gen",
			      acquireButton = "button_OtherDataFileCapture_gen",
			      submit = "//div[@id='div_AllTabs']//div[@class='buttons-navig']//button[text()='Submit']",
			      okbutton = "//span[text()='OK']",
			      insurance = "m_SSN",
			      logOut = "//a[text()='Logout']";
	
	public TelemedicineService(WebDriver _driver) throws Exception{
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
		objFrames = new Frames(this.driver);
	}
	
	/**********************************************************************************
	 * Description : This function is to click on general.
	 * Date        : 11-Aug-2016
     * Author      : Hanumegowda
     **********************************************************************************/
	public TelemedicineService clickOnGeneral() throws Exception {
		objWaitForElement.waitForElements(general, "xpath");
		this.page.element(general, "xpath").getOne().click();
		
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select consulting MD from dropdown menu.
	 * Date        : 11-Aug-2016
     * Author      : Hanumegowda
     **********************************************************************************/
	public TelemedicineService selConsultingMDFromDropdown(String consMd) throws Exception {
		objWaitForElement.waitForElements(consMdDropdown, "id");
		this.page.element(consMdDropdown, "id").webElementToSelect().selectByVisibleText(consMd);
		
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter text in last name text field.
	 * Date        : 11-Aug-2016
     * Author      : Hanumegowda
     **********************************************************************************/
	public TelemedicineService enterLastName(String casenamel) throws Exception {
		objWaitForElement.waitForElements(ln, "id");
		this.page.element(ln, "id").clearInputValue().sendKeys(casenamel);
		
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter text in first name text field.
	 * Date        : 11-Aug-2016
     * Author      : Hanumegowda
     **********************************************************************************/
	public TelemedicineService enterFirstName(String casenamef) throws Exception {
		objWaitForElement.waitForElements(fn, "id");
		this.page.element(fn, "id").clearInputValue().sendKeys(casenamef);
		
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select consulting MD from dropdown menu.
	 * Date        : 11-Aug-2016
     * Author      : Hanumegowda
     **********************************************************************************/
	public TelemedicineService selMonthFromDropdown(String mon) throws Exception {
		objWaitForElement.waitForElements(monthDropdown, "id");
		this.page.element(monthDropdown, "id").webElementToSelect().selectByIndex(5);
		
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select consulting MD from dropdown menu.
	 * Date        : 11-Aug-2016
     * Author      : Hanumegowda
     **********************************************************************************/
	public TelemedicineService selDayFromDropdown(String day) throws Exception {
		objWaitForElement.waitForElements(dayDropdown, "id");
		this.page.element(dayDropdown, "id").webElementToSelect().selectByIndex(5);
		
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select consulting MD from dropdown menu.
	 * Date        : 11-Aug-2016
     * Author      : Hanumegowda
     **********************************************************************************/
	public TelemedicineService selYearFromDropdown(String year) throws Exception {
		objWaitForElement.waitForElements(yearDropdown, "id");
		this.page.element(yearDropdown, "id").webElementToSelect().selectByIndex(7);;
		
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on data files tab.
	 * Date        : 11-Aug-2016
     * Author      : Hanumegowda
     **********************************************************************************/
	public TelemedicineService clickOnDataFiles() throws Exception {
		objWaitForElement.waitForElements(dataFiles, "id");
		this.page.element(dataFiles, "id").getOne().click();
		
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select 'Select image source' option from dropdown menu.
	 * Date        : 08-Dec-2016
     * Author      : Hanumegowda
     **********************************************************************************/
	public TelemedicineService selImageSourceDropdownOption(String date) throws Exception {
		objWaitForElement.waitForElements(selImageSource, "id");
		this.page.element(selImageSource, "id").webElementToSelect().selectByVisibleText(date);
		
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on acquire button.
	 * Date        : 08-Dec-2016
     * Author      : Hanumegowda
     **********************************************************************************/
	public TelemedicineService clickOnAcquireButton() throws Exception {
		objWaitForElement.waitForElements(acquireButton, "id");
		this.page.element(acquireButton, "id").getOne().click();
		
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on submit.
	  * Date        : 08-Dec-2016
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public TelemedicineService clickOnSubmit() throws Exception {
		objWaitForElement.waitForElements(submit, "xpath");
		this.page.element(submit, "xpath").clickUjse();
		Thread.sleep(3000);
		this.page.element(okbutton, "xpath").getOne().click();
		Thread.sleep(3000);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on ok button.
	 * Date        : 08-Dec-2016
     * Author      : Hanumegowda
     **********************************************************************************/
	public TelemedicineService clickOnOkButton() throws Exception {
		objWaitForElement.waitForElements("//div[@class='ui-dialog-buttonset']//span[text()='OK']", "xpath");
		this.page.element("//div[@class='ui-dialog-buttonset']//span[text()='OK']", "xpath").doubleClick();
		/*WebElement ele = driver.findElement(By.xpath(okbutton));
		JavascriptExecutor jse = (JavascriptExecutor)this.driver;
		jse.executeScript("var elem=arguments[0]; setTimeout(function() {elem.click();}, 100)", ele);*/
		Thread.sleep(5000);
		
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter text in Insurance text field.
	 * Date        : 09-Dec-2016
     * Author      : Hanumegowda
     **********************************************************************************/
	public TelemedicineService enterInsurance(String casenamef) throws Exception {
		objWaitForElement.waitForElements(insurance, "id");
		this.page.element(insurance, "id").clearInputValue().sendKeys(casenamef);
		
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify the case is displaying.
	 * Date        : 09-Dec-2016
     * Author      : Hanumegowda
     **********************************************************************************/
	public TelemedicineService verCase(String casee) throws Exception {
		String str = "//span[contains(text(),'"+casee+"')]";
		objWaitForElement.waitForElements(str, "xpath");
		assertTrue(this.page.element(str, "xpath").isElementPresent());
		
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on logout.
	  * Date        : 09-Dec-2016
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public TelemedicineService clickOnLogOut() throws Exception {
		objWaitForElement.waitForElements(logOut, "xpath");
		this.page.element(logOut, "xpath").getOne().click();
		return this;
	}
	
}
