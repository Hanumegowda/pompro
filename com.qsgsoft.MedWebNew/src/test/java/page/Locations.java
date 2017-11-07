package page;

import module.Frames;

import org.openqa.selenium.WebDriver;

import qaframework.lib.WaitTimeConstants;
import qaframework.lib.pageObject.PageObject;
import qaframework.lib.userDefinedFunctions.WaitForElement;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

public class Locations extends PageObject {
	WebDriver driver;
	WaitForElement objWaitForElement;
	Frames objFrames;
	
	public String locationlist = "//b[text()='Locations List']",
			      addLocation = "//a[text()='Add Location']",
			      addNewLocation = "//b[text()='Add new Location']",
			      facilityName = "//td[contains(text(),'Facility name:')]/..//input",
			      locationID = "//td[contains(text(),'Location ID:')]/..//input",
			      cityName = "//td[contains(text(),'City:')]/..//input",
			      countryName = "//td[contains(text(),'Country:')]/..//input",
			      importFromCSV = "//a[text()='Import from CSV']",
			      downloadCSVTemplate = "//a[text()='Download CSV template']",
			      importCSV = "//a[text()='Import CSV']",
			      back = "//a[text()='Back']",
			      addReferralLocation = "Add Referral Location",
			      refLoc = "REFERRAL_CONDITION";
	
	public Locations(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement =  new WaitForElement(this.driver);
		objFrames = new Frames(this.driver);
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Location List' page is displayed.
	  * Date        : 07-Jul-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public Locations verLocationListPage() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(locationlist, "xpath");
		assertTrue(this.page.element(locationlist, "xpath").getOne()
				.isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on 'Add Location' button.
	  * Date        : 07-Jul-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public Locations clickOnAddLocation() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(addLocation, "xpath");
		this.page.element(addLocation, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Add new Location' page is displayed.
	  * Date        : 07-Jul-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public Locations verAddnewLocationPage() throws Exception {
		objWaitForElement.waitForElements(addNewLocation, "xpath");
		assertTrue(this.page.element(addNewLocation, "xpath").getOne()
				.isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter text in 'Facility name:' field.
	  * Date        : 07-Jul-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public Locations enterTextInFacilityNameField(String facilityname) throws Exception {
		objWaitForElement.waitForElements(facilityName, "xpath");
		this.page.element(facilityName, "xpath").clearInputValue().click();
		this.page.element(facilityName, "xpath").getOne().sendKeys(facilityname);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter text in 'Location ID' field.
	  * Date        : 07-Jul-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public Locations enterTextInLocationIDField(String locationid) throws Exception {
		objWaitForElement.waitForElements(locationID, "xpath");
		this.page.element(locationID, "xpath").clearInputValue().click();
		this.page.element(locationID, "xpath").getOne().sendKeys(locationid);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter text in 'city' field.
	  * Date        : 07-Jul-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public Locations enterTextInCityField(String city) throws Exception {
		objWaitForElement.waitForElements(cityName, "xpath");
		this.page.element(cityName, "xpath").clearInputValue().click();
		this.page.element(cityName, "xpath").getOne().sendKeys(city);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter text in 'Country' field.
	  * Date        : 07-Jul-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public Locations enterTextInCountryField(String country) throws Exception {
		objWaitForElement.waitForElements(countryName, "xpath");
		this.page.element(countryName, "xpath").clearInputValue().click();
		this.page.element(countryName, "xpath").getOne().sendKeys(country);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on 'Import from CSV' button.
	  * Date        : 30-May-2016
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public Locations clickOnImportFromCSV() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(importFromCSV, "xpath");
		this.page.element(importFromCSV, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on 'Download CSV template' link.
	  * Date        : 30-May-2016
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public Locations clickOnDownloadCSVTemplateLink() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(downloadCSVTemplate, "xpath");
		this.page.element(downloadCSVTemplate, "xpath").mouseOver();
		this.page.element(downloadCSVTemplate, "xpath").doubleClick();
		Thread.sleep(5000);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on 'Import CSV' button.
	  * Date        : 08-Jun-2016
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public Locations clickOnImportCSV() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(importCSV, "xpath");
		this.page.element(importCSV, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on 'Back' button.
	  * Date        : 08-Jun-2016
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public Locations clickOnBack() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(back, "xpath");
		this.page.element(back, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify location is displayed.
	  * Date        : 08-Jun-2016
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public Locations verLocationIsDisplayed(String loc,String type) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		String str = "//td[text()='"+loc+"']//following-sibling::td[text()='"+type+"']";
		System.out.println(str);
		objWaitForElement.waitForElements(str, "xpath");
		assertTrue(this.page.element(str, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on 'modify Location' icon.
	  * Date        : 22-Jun-2016
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public Locations clickOnModifyLocation(String loc) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		String str = "//td[text()='"+loc+"']/following-sibling::td//img[@src='/.cobalt/images/modify.gif']";
		objWaitForElement.waitForElements(str, "xpath");
		this.page.element(str, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on 'delete Location' icon.
	  * Date        : 22-Jun-2016
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public Locations clickOnDeleteLocation(String loc) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		String str = "//td[text()='"+loc+"']/following-sibling::td//img[@src='/.cobalt/images/delete.gif']";
		objWaitForElement.waitForElements(str, "xpath");
		this.page.element(str, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify location is not displayed.
	  * Date        : 22-Jun-2016
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public Locations verLocationIsNotDisplayed(String loc,String type) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		String str = "//td[text()='"+loc+"']//following-sibling::td[text()='"+type+"']";
		System.out.println(str);
		objWaitForElement.waitForElements(str, "xpath");
		assertFalse(this.page.element(str, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE1));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on 'Add Referral Location' button.
	  * Date        : 06-Oct-2016
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public Locations clickOnAddReferralLocation() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(addReferralLocation, "linktext");
		this.page.element(addReferralLocation, "linktext").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter text in 'Refferal Conditions' field.
	  * Date        : 06-Oct-2016
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public Locations enterTextInRefferalConditionsField(String refloc) throws Exception {
		objWaitForElement.waitForElements(refLoc, "name");
		this.page.element(refLoc, "name").clearInputValue().click();
		this.page.element(refLoc, "name").getOne().sendKeys(refloc);
		return this;
	}

}
