package page;

import java.util.List;

import module.Frames;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertTrue;
import qaframework.lib.pageObject.PageObject;
import qaframework.lib.userDefinedFunctions.WaitForElement;

public class LocalSiteInformation extends PageObject {
	WebDriver driver;
	WaitForElement objWaitForElement;
	Frames objFrames;
	
	private String localSiteInfo = "//div/b[text()='Local Site Information']",
			       medicalLicenses = "//fieldset[@id='medical_licenses_list']//td[text()='Enable:']/..//input[@type='checkbox']",
			       warningBannerTextField = "//textarea[@name='BANNER']",
			       linkName = "//input[@name='LICENCES']",
			       loginPromptWarningBannerTextField = "//textarea[@name='BANNERLP']",
			       generalInformationTextField = "//textarea[@name='ANNOUNCMENTS']",
			       addressDrivingDirectionsTextField = "//textarea[@name='HOWTOREACH']",
			       resetPublicPage = "//a[text()='Reset Public Page']",
			       admit = "//input[@type='checkbox'][@name='admit']",
			       cloudConsult = "//input[@type='checkbox'][@name='cloud_consult']",
			       enableButtons = "//input[@type='checkbox'][@name='buttons']",
			       enableWrngBanr = "input[type='checkbox'][name='banner']",
			       enableLgnPrmptWrngBanr = "input[type='checkbox'][name='bannerlp']",
			       enableFacilityLogo = "input[type='checkbox'][name='logo']",
			       enableGenrlInfo = "input[type='checkbox'][name='general']",
			       enableAddrAndDrvngDirections = "input[type='checkbox'][name='driving']",
			       contacts = "input[type='text'][name='CONTACTS']",
			       businessHrs = "input[type='text'][name='BIZHOUR']",
			       announcement = "textarea[name='ANNOUNCMENTS']",
			       howToReach = "textarea[name='HOWTOREACH']",
			       streetAddress = "input[type='text'][name='STREET']",
			       cityState = "input[type='text'][name='CITY_ZIP']",
			       emailRequestTo = "input[type='text'][name='request_access_email']",
			       allCheckBoxOfButtonSection = "//legend[text()='Buttons']/following-sibling::table//input[@type='checkbox']",
			       country = "//select[@name='COUNTRY']",
			       browselogo = "//input[@type='file'][@name='FACILITY_FILE']";
	
	public LocalSiteInformation(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
		objFrames = new Frames(this.driver);
	}
	
	/**********************************************************************************
	* Description : This function is to verify  local site information page is displayed.
	* Date 		  : 19-Jun-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public LocalSiteInformation verLocalSiteInfoPage() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
		.switchToMainInRightFrame();
		objWaitForElement.waitForElements(localSiteInfo, "xpath");
		assertTrue(this.page.element(localSiteInfo, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select Medical Licenses List check box.
	* Date 		  : 19-Jun-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public LocalSiteInformation selMedicalLicensesListCheckBox() throws Exception {
		objWaitForElement.waitForElements(medicalLicenses, "xpath");
		if(!(this.page.element(medicalLicenses, "xpath").getOne().isSelected())){
		this.page.element(medicalLicenses, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Link Name' text field.
	* Date 		  : 19-Jun-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public LocalSiteInformation enterLinkName(String name) throws Exception {
		objWaitForElement.waitForElements(linkName, "xpath");
		this.page.element(linkName, "xpath").clearInputValue().sendKeys(name);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify the text present in 'Warning Banner' text field.
	* Date 		  : 24-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public LocalSiteInformation verTextInWarningBannerField(String txt) throws Exception {
		objWaitForElement.waitForElements(warningBannerTextField, "xpath");
		assertTrue(this.page.element(warningBannerTextField, "xpath").getOne().getText().contains(txt));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify the text present in 'Login Prompt Warning Banner' text field.
	* Date 		  : 24-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public LocalSiteInformation verTextInLoginPromptWarningBannerField(String txt) throws Exception {
		objWaitForElement.waitForElements(loginPromptWarningBannerTextField, "xpath");
		assertTrue(this.page.element(loginPromptWarningBannerTextField, "xpath").getOne().getText().contains(txt));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify the text present in 'General information' field.
	* Date 		  : 24-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public LocalSiteInformation verTextInGeneralInformationField(String txt) throws Exception {
		objWaitForElement.waitForElements(generalInformationTextField, "xpath");
		assertTrue(this.page.element(generalInformationTextField, "xpath").getOne().getText().contains(txt));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify the text present in 'Address and driving directions' field.
	* Date 		  : 24-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public LocalSiteInformation verTextInAddressDrivingDirectionsField(String txt) throws Exception {
		objWaitForElement.waitForElements(addressDrivingDirectionsTextField, "xpath");
		assertTrue(this.page.element(addressDrivingDirectionsTextField, "xpath").getOne().getText().contains(txt));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'Reset Public Page' button.
	* Date 		  : 24-Aug-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public LocalSiteInformation clickOnResetPublicPageButton() throws Exception {
		objWaitForElement.waitForElements(resetPublicPage, "xpath");
		this.page.element(resetPublicPage, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select Admit check box under buttons field.
	* Date 		  : 03-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public LocalSiteInformation selAdmitCheckBox() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(admit, "xpath");
		if(!(this.page.element(admit, "xpath").getOne().isSelected())){
		this.page.element(admit, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select Enable check box under buttons field.
	* Date 		  : 03-Nov-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public LocalSiteInformation selEnableCheckBox() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(enableButtons, "xpath");
		if(!(this.page.element(enableButtons, "xpath").getOne().isSelected())){
		this.page.element(enableButtons, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select Enable checkbox of 'Warning Banner' field.
	* Date 		  : 29-Jul-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public LocalSiteInformation selWarningBannerEnableCheckBox() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(enableWrngBanr, "css");
		if(!(this.page.element(enableWrngBanr, "css").getOne().isSelected())){
		this.page.element(enableWrngBanr, "css").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select Enable checkbox of 'Login Prompt Warning Banner' field.
	* Date 		  : 29-Jul-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public LocalSiteInformation selLoginPromptWarningBannerEnableCheckBox() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(enableLgnPrmptWrngBanr, "css");
		if(!(this.page.element(enableLgnPrmptWrngBanr, "css").getOne().isSelected())){
		this.page.element(enableLgnPrmptWrngBanr, "css").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select Enable checkbox of 'Facility Logo' field.
	* Date 		  : 29-Jul-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public LocalSiteInformation selFacilityLogoEnableCheckBox() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(enableFacilityLogo, "css");
		if(!(this.page.element(enableFacilityLogo, "css").getOne().isSelected())){
		this.page.element(enableFacilityLogo, "css").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select Enable checkbox of 'General information' field.
	* Date 		  : 29-Jul-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public LocalSiteInformation selGeneralInformationEnableCheckBox() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(enableGenrlInfo, "css");
		if(!(this.page.element(enableGenrlInfo, "css").getOne().isSelected())){
		this.page.element(enableGenrlInfo, "css").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select Enable checkbox of 'Address and driving directions' field.
	* Date 		  : 29-Jul-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public LocalSiteInformation selAddressAndDrivingDirectionsEnableCheckBox() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(enableAddrAndDrvngDirections, "css");
		if(!(this.page.element(enableAddrAndDrvngDirections, "css").getOne().isSelected())){
		this.page.element(enableAddrAndDrvngDirections, "css").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Warning Banner' text field.
	* Date 		  : 29-Jul-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public LocalSiteInformation enterTextInWarningBanner(String name) throws Exception {
		objWaitForElement.waitForElements(warningBannerTextField, "xpath");
		this.page.element(warningBannerTextField, "xpath").clearInputValue().sendKeys(name);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Login Prompt Warning Banner' text field.
	* Date 		  : 29-Jul-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public LocalSiteInformation enterTextInLoginPromptWarningBanner(String name) throws Exception {
		objWaitForElement.waitForElements(loginPromptWarningBannerTextField, "xpath");
		this.page.element(loginPromptWarningBannerTextField, "xpath").clearInputValue().sendKeys(name);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'contacts' text field of 'General information'
	*               section.
	* Date 		  : 29-Jul-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public LocalSiteInformation enterTextInContacts(String strcontact) throws Exception {
		objWaitForElement.waitForElements(contacts, "css");
		this.page.element(contacts, "css").clearInputValue().sendKeys(strcontact);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Business hours' text field of 'General information'
	*               section.
	* Date 		  : 29-Jul-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public LocalSiteInformation enterTextInBusinessHours(String bhr) throws Exception {
		objWaitForElement.waitForElements(businessHrs, "css");
		this.page.element(businessHrs, "css").clearInputValue().sendKeys(bhr);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Announcements' text field of 'General information'
	*               section.
	* Date 		  : 29-Jul-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public LocalSiteInformation enterTextInAnnouncements(String announce) throws Exception {
		objWaitForElement.waitForElements(announcement, "css");
		this.page.element(announcement, "css").clearInputValue().sendKeys(announce);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'How to reach' text field of 'Address and driving directions'
	*               section.
	* Date 		  : 29-Jul-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public LocalSiteInformation enterTextInHowToReach(String reach) throws Exception {
		objWaitForElement.waitForElements(howToReach, "css");
		this.page.element(howToReach, "css").clearInputValue().sendKeys(reach);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'Street address' text field of 'Address and driving directions'
	*               section.
	* Date 		  : 29-Jul-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public LocalSiteInformation enterTextInStreetAddress(String strtaddr) throws Exception {
		objWaitForElement.waitForElements(streetAddress, "css");
		this.page.element(streetAddress, "css").clearInputValue().sendKeys(strtaddr);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'City, State (or ZIP code)' text field of 
	*               'Address and driving directions' section.
	* Date 		  : 29-Jul-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public LocalSiteInformation enterTextInCityState(String ctystate) throws Exception {
		objWaitForElement.waitForElements(cityState, "css");
		this.page.element(cityState, "css").clearInputValue().sendKeys(ctystate);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter text in 'E-mail requests to' text field of 
	*               'Buttons' section.
	* Date 		  : 29-Jul-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public LocalSiteInformation enterTextInEmailRequestsTo(String emailreq) throws Exception {
		objWaitForElement.waitForElements(emailRequestTo, "css");
		this.page.element(emailRequestTo, "css").clearInputValue().sendKeys(emailreq);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select all the checkboxes present under 'Buttons' section.
	* Date 		  : 29-Jul-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public LocalSiteInformation selAllCheckBoxUnderButtons()
			throws Exception {
		List<WebElement> ae = (this.page.element(allCheckBoxOfButtonSection,
				"xpath")).get();
		for (WebElement all : ae) {
			if (all.isSelected() == false) {
				all.click();
			}
		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select country from country dropdown of 'Address and 
	*               driving directions' section.
	* Date 		  : 29-Jul-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public LocalSiteInformation selCountry(String strcountry) throws Exception {
		objWaitForElement.waitForElements(country, "xpath");
		this.page.element(country, "xpath").webElementToSelect().selectByVisibleText(strcountry);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on browse button of logo image in 'Facility Logo' section
	* Date 		  : 29-Jul-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public LocalSiteInformation clickOnBrowseOfLogoImage(String logopath) throws Exception {
		objWaitForElement.waitForElements(browselogo, "xpath");
		this.page.element(browselogo, "xpath").getOne().sendKeys(logopath);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Cloud Consult' check box under buttons field.
	* Date 		  : 01-Dec-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public LocalSiteInformation selCloudConsultCheckBox() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame().switchToMainInRightFrame();
		objWaitForElement.waitForElements(cloudConsult, "xpath");
		if(!(this.page.element(cloudConsult, "xpath").getOne().isSelected())){
		this.page.element(cloudConsult, "xpath").getOne().click();
		}
		return this;
	}

}
