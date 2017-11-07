package EMR.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.ui.WebDriverWait;

import qaFramework.WaitTimeConstants;
import qaFramework.UserDefinedFunctions.WaitForElement;
import qaFramework.pageObject.PageObject;
import EMR.Locators.RegionList.Locators;

public class RegionList extends PageObject {
	
	WebDriver driver;
	WaitForElement waitForElement ;
	WebDriverWait wait;
	Shared navigateTo;
	
	public RegionList(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		waitForElement = new WaitForElement(this.driver);
		navigateTo = new Shared(this.driver);
	}
	
	public RegionList clickCreateNewRegionButton() throws Exception {
		waitForElement.waitForElements(Locators.CREATEREGION, "css");
		this.page.element(Locators.CREATEREGION, "css").getOne().click();
		return this;
	}
	
	public RegionList enterRegionName(String _regionName) throws Exception {
		waitForElement.waitForElements(Locators.REGIONNAME, "css");
		this.page.element(Locators.REGIONNAME, "css").clearInputValue().sendKeys(_regionName);
		return this;
	}
	
	public RegionList selectTimeZone(String _timeZone) throws Exception {
		waitForElement.waitForElements(Locators.TIMEZONE, "css");
		this.page.element(Locators.TIMEZONE, "css").getOne().sendKeys(_timeZone);
		return this;
	}
	
	public RegionList enterFirstName(String _firstName) throws Exception {
		waitForElement.waitForElements(Locators.FIRSTNAME, "css");
		this.page.element(Locators.FIRSTNAME, "css").clearInputValue().sendKeys(_firstName);
		return this;
	}
	
	public RegionList enterLastName(String _lastName) throws Exception {
		waitForElement.waitForElements(Locators.LASTNAME, "css");
		this.page.element(Locators.LASTNAME, "css").clearInputValue()
				.sendKeys(_lastName);
		return this;
	}
	
	public RegionList clickOnSave() throws Exception {
		waitForElement.waitForElements(Locators.SAVE, "css");
		this.page.element(Locators.SAVE, "css").getOne().click();
		return this;
	}
	
	public RegionList createRegion(String regionName, String firstName,
			String lastName, String timezone) throws Exception {
		enterRegionName(regionName);
		enterFirstName(firstName);
		enterLastName(lastName);
		selectTimeZone(timezone);
		//clickOnSave();
		return this;
	}

	public RegionList clickOnEdit(String _regionName) throws Exception {
		waitForElement.waitForElements(Locators.TABLECELLWITHTEXT + _regionName + Locators.EDITLINK, "xpath");
		this.page.element(Locators.TABLECELLWITHTEXT + _regionName + Locators.EDITLINK, "xpath") .mouseOver();
		this.page.element(Locators.TABLECELLWITHTEXT + _regionName + Locators.EDITLINK, "xpath").getOne().click();
		try{
			
		if(this.page.element(Locators.REGION_LIST_HEADER,"xpath").isElementPresent()){
			
		this.page.element(Locators.TABLECELLWITHTEXT + _regionName + Locators.EDITLINK, "xpath").clickUsingJSE();		
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return this;
	}
	
	public RegionList selectDisplayTimezone() throws Exception {
		waitForElement.waitForElements(Locators.DISPLAYTIMEZONE, "css");
		if (this.page.element(Locators.DISPLAYTIMEZONE, "css").getOne().isSelected()==false) {
			this.page.element(Locators.DISPLAYTIMEZONE, "css").getOne().click();
		}
		return this;
	}
	
	public RegionList selectIncomingPatientNotification() throws Exception {
		waitForElement.waitForElements(Locators.INCOMINGPATIENTNOTIFICATIONS, "css");
		if (this.page.element(Locators.INCOMINGPATIENTNOTIFICATIONS, "css").getOne().isSelected()==false) {
			this.page.element(Locators.INCOMINGPATIENTNOTIFICATIONS, "css").getOne().click();
		}
		return this;
	}
	
	public RegionList selectIpFilter() throws Exception {
		waitForElement.waitForElements(Locators.IPFILTER, "css");
		if (this.page.element(Locators.IPFILTER, "css").getOne().isSelected()==false) {
			this.page.element(Locators.IPFILTER, "css").getOne().click();
		}
		return this;
	}
	
	public RegionList selectInstantMessaging() throws Exception {
		waitForElement.waitForElements(Locators.INSTANTMESSAGING, "css");
		if (this.page.element(Locators.INSTANTMESSAGING, "css").getOne().isSelected()==false) {
			this.page.element(Locators.INSTANTMESSAGING, "css").getOne().click();
		}
		return this;
	}
	
	public RegionList selectStatusChangeNameTrace() throws Exception {
		waitForElement.waitForElements(Locators.STATUSCHANGENAMETRACE, "css");
		if (this.page.element(Locators.STATUSCHANGENAMETRACE, "css").getOne().isSelected()==false) {
			this.page.element(Locators.STATUSCHANGENAMETRACE, "css").getOne().click();
		}
		return this;
	}
	
	public RegionList selectNecessaryRights() throws Exception {
		selectDisplayTimezone();
		selectInstantMessaging();
		selectIncomingPatientNotification();
		selectIpFilter();
		selectStatusChangeNameTrace();
		clickOnSave();
		return this;
	}
	
	public String editRegionAndEnterInterfaceKeyIfNotFound(String region,String interfaceKey) throws Exception {
		String existingInterfaceKey = "";
		this.clickOnEdit(region);
		if (!this.page.element(Locators.INTERFACEKEY_DISABLED, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE)) {
			this.page.element(Locators.INTERFACEKEY_DISABLED, "xpath").clearInputValue().sendKeys(interfaceKey);
			existingInterfaceKey = interfaceKey;
		} else {
			assertTrue(this.page.element(Locators.INTERFACEKEY_DISABLED, "xpath")
					.isElementPresent(), "Interface key is not entered");
			existingInterfaceKey = this.page.element(Locators.INTERFACEKEY_DISABLED, "xpath").getOne().getAttribute("value");
		}
		this.clickOnSave();
		return existingInterfaceKey;
	}
	
	public String getRegionValue(String regionName) throws Exception {
		navigateTo.regions();
		String region=Locators.TABLECELLWITHTEXT+regionName+Locators.REGION_VALUE;
		waitForElement.waitForElements(region, "xpath");
		String regionValue = this.page.element(region, "xpath").getOne().getAttribute("href");
		String regionArray[] = regionValue.split("=");		
		regionValue = regionArray[4];
		return regionValue;
	}

	public RegionList verifyIncomingPatientNotificationsIsSelected()throws Exception {
		waitForElement.waitForElements(Locators.INCOMINGPATIENTNOTIFICATIONS, "css");
		if(this.page.element(Locators.INCOMINGPATIENTNOTIFICATIONS, "css").getOne().isSelected() == false){
			this.page.element(Locators.INCOMINGPATIENTNOTIFICATIONS, "css").getOne().sendKeys(Keys.SPACE);
			assertTrue(this.page.element(Locators.INCOMINGPATIENTNOTIFICATIONS, "css").getOne().isSelected());
		}
		if(this.page.element(Locators.INCOMINGPATIENTNOTIFICATIONS, "css").getOne().isSelected() == false){
			this.page.element(Locators.INCOMINGPATIENTNOTIFICATIONS, "css").clickUsingJSE();
			assertTrue(this.page.element(Locators.INCOMINGPATIENTNOTIFICATIONS, "css").getOne().isSelected());
		}
		return this;
	}	
	
	public RegionList clickOnCancel() throws Exception {
		waitForElement.waitForElements(Locators.CANCEL, "css");
		this.page.element(Locators.CANCEL, "css").clickUsingJSE();
		return this;
	}
	
	public RegionList verifyIncomingPatientNotificationsIsEnabledForRegion(String regionName)throws Exception {
		this.clickOnEdit(regionName);
		this.verifyIncomingPatientNotificationsIsSelected();
		this.clickOnCancel();
		return this;
	}
}
