package lib.page;

import lib.module.NavigationToSubMenus;

import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;
import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;

public class ConfigureIncomingPatientNotifications extends PageObject{
	
	WebDriver driver;
	WaitForElement objWaitForElement;
	
private String IPN="//div[@id='topSubNav']/h1[text()='Configure Incoming Patient Notifications']",
	           enabled="//td[text()='Enabled?']/following-sibling::td/input[@class='checkbox'][@name='enabled']",
	          manualentry="//td[text()='Allow Manual Entry?']/following-sibling::td/input[@class='checkbox'][@name='manualEntry']",
	          
	          ageEnabled="//td[text()='Age']/following-sibling::td/input[@name='ipnFieldEnabled110'][@class='checkbox']",
	          ageReq="//td[text()='Age']/following-sibling::td/input[@name='ipnFieldRequired110'][@class='checkbox']",
	          
	          ageUnitsEnabled="//td[text()='Age Units']/following-sibling::td/input[@name='ipnFieldEnabled120'][@class='checkbox']",
	          ageUnitsReq="//td[text()='Age Units']/following-sibling::td/input[@name='ipnFieldRequired120'][@class='checkbox']",
	          
	          chfComplaintEnabled="//td[text()='Chief Complaint']/following-sibling::td/input[@name='ipnFieldEnabled130'][@class='checkbox']",
	          chfComplaintReq="//td[text()='Chief Complaint']/following-sibling::td/input[@name='ipnFieldRequired130'][@class='checkbox']",
	          
	          etaEnabled="//td[text()='ETA']/following-sibling::td/input[@name='ipnFieldEnabled140'][@class='checkbox']",
	          etaReq="//td[text()='ETA']/following-sibling::td/input[@name='ipnFieldRequired140'][@class='checkbox']",
	          
	          genderEnabled="//td[text()='Gender']/following-sibling::td/input[@name='ipnFieldEnabled150'][@class='checkbox']",
	          genderReq="//td[text()='Gender']/following-sibling::td/input[@name='ipnFieldRequired150'][@class='checkbox']",
	          
	          sentByEnabled="//td[text()='Sent By']/following-sibling::td/input[@name='ipnFieldEnabled160'][@class='checkbox']",
	          sentByReq="//td[text()='Sent By']/following-sibling::td/input[@name='ipnFieldRequired160'][@class='checkbox']",
	          
	          triageCategoryEnabled="//td[text()='Triage Category']/following-sibling::td/input[@name='ipnFieldEnabled170'][@class='checkbox']",
	          triageCategoryReq="//td[text()='Triage Category']/following-sibling::td/input[@name='ipnFieldRequired170'][@class='checkbox']", 
	          
	          levelOfCareEnabled="//td[text()='Level Of Care']/following-sibling::td/input[@name='ipnFieldEnabled210'][@class='checkbox']",
	          levelOfCareReq="//td[text()='Level Of Care']/following-sibling::td/input[@name='ipnFieldRequired210'][@class='checkbox']",
	          
	          eMSAgencyEnabled="//td[text()='EMS Agency']/following-sibling::td/input[@name='ipnFieldEnabled220'][@class='checkbox']",
	          eMSAgencyReq="//td[text()='EMS Agency']/following-sibling::td/input[@name='ipnFieldRequired220'][@class='checkbox']",
	          
	          eMSUnitEnabled="//td[text()='EMS Unit']/following-sibling::td/input[@name='ipnFieldEnabled230'][@class='checkbox']",
	          eMSUnitReq="//td[text()='EMS Unit']/following-sibling::td/input[@name='ipnFieldRequired230'][@class='checkbox']",
	          save="//input[@value='Save']";
	          
public ConfigureIncomingPatientNotifications(WebDriver _driver)
			throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
	}

/**********************************************************************************
* Description : This function is to navigate to 'Incoming pation' in setup 
* Date 		  : 23/07/2015
* Author 	  : Sangappa.k
**********************************************************************************/
	public ConfigureIncomingPatientNotifications verConfigureIncomingPatientNotificationsPage()
			throws Exception {
		objWaitForElement.waitForElements(IPN, "xpath");

		assertTrue(
				"Configure Incoming Patient Notifications Page is not displayed",
				this.page.element(IPN, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify enebled chk box is selected
	* Date 		  : 23/07/2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public ConfigureIncomingPatientNotifications verEnabledChkBoxIsSelected()
			throws Exception {
		objWaitForElement.waitForElements(enabled, "xpath");
		assertTrue(
				"Enabled Chk bos is not selected",
				this.page.element(enabled, "xpath").getOne().isSelected());
		return this;
	}
	
	/**********************************************************************************
	* Description :  This function is to verify allow Manual entry chk box is selected
	* Date 		  : 23/07/2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public ConfigureIncomingPatientNotifications verAllowManualEntryChkBosIsSelected()
			throws Exception {
		objWaitForElement.waitForElements(manualentry, "xpath");
		assertTrue(
				"Enabled Chk bos is not cheacked",
				this.page.element(manualentry, "xpath").getOne().isSelected());
		return this;
	}
	/**********************************************************************************
	* Description :  This function is to select age chk boxes
	* Date 		  : 23/07/2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public ConfigureIncomingPatientNotifications selAllChkBoxesForConfigIPNFields()
			throws Exception {
		objWaitForElement.waitForElements(ageEnabled, "xpath");

		String[] ElementArr = { ageEnabled, ageReq, ageUnitsEnabled,
				ageUnitsReq, chfComplaintEnabled, chfComplaintReq, etaEnabled,
				etaReq, genderEnabled, genderReq, sentByEnabled, sentByReq,
				triageCategoryEnabled, triageCategoryReq, levelOfCareEnabled,
				levelOfCareReq, eMSAgencyEnabled, eMSAgencyReq, eMSUnitEnabled,
				eMSUnitReq };
		int i = 0;

		for (i = 0; i <=(ElementArr.length-1); i++) {
			if (this.page.element(ElementArr[i], "xpath").getOne().isSelected() == false)
			{
				this.page.element(ElementArr[i], "xpath").getOne().click();
			}
		}
		return this;
	}
	
	/**********************************************************************************
	* Description :  This function is to clcik on save
	* Date 		  : 23/07/2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public ConfigureIncomingPatientNotifications clickOnSave() throws Exception {
		objWaitForElement.waitForElements(save, "xpath");
		this.page.element(save, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description :  This function is to deslelct ETA
	* Date 		  : 23/07/2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public ConfigureIncomingPatientNotifications deselectETA() throws Exception {
		objWaitForElement.waitForElements(etaEnabled, "xpath");
		if(this.page.element(etaEnabled, "xpath").getOne().isSelected())
		this.page.element(etaEnabled, "xpath").getOne().click();
		
		if(this.page.element(etaReq, "xpath").getOne().isSelected())
			this.page.element(etaReq, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description :  This function is to deselect Age units
	* Date 		  : 23/07/2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public ConfigureIncomingPatientNotifications deselectAgeUnits() throws Exception {
		objWaitForElement.waitForElements(ageUnitsEnabled, "xpath");
		if(this.page.element(ageUnitsEnabled, "xpath").getOne().isSelected())
		this.page.element(ageUnitsEnabled, "xpath").getOne().click();
		
		if(this.page.element(ageUnitsReq, "xpath").getOne().isSelected())
			this.page.element(ageUnitsReq, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description :  This function is to deselect Age units
	* Date 		  : 23/07/2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public ConfigureIncomingPatientNotifications deselectEMSUnit() throws Exception {
		objWaitForElement.waitForElements(eMSUnitEnabled, "xpath");
		if(this.page.element(eMSUnitEnabled, "xpath").getOne().isSelected())
		this.page.element(eMSUnitEnabled, "xpath").getOne().click();
		
		if(this.page.element(eMSUnitReq, "xpath").getOne().isSelected())
			this.page.element(eMSUnitReq, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description :  This function is to deselect EMS agency units
	* Date 		  : 23/07/2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public ConfigureIncomingPatientNotifications deselectEMSAgency() throws Exception {
		objWaitForElement.waitForElements(eMSAgencyEnabled, "xpath");
		if(this.page.element(eMSAgencyEnabled, "xpath").getOne().isSelected())
		this.page.element(eMSAgencyEnabled, "xpath").getOne().click();
		
		if(this.page.element(eMSAgencyReq, "xpath").getOne().isSelected())
			this.page.element(eMSAgencyReq, "xpath").getOne().click();
		return this;
	}
	/**********************************************************************************
	* Description :  This function is to deselect EMS agency units
	* Date 		  : 23/07/2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public ConfigureIncomingPatientNotifications deselectTriageCategoery() throws Exception {
		objWaitForElement.waitForElements(triageCategoryEnabled, "xpath");
		if(this.page.element(triageCategoryEnabled, "xpath").getOne().isSelected())
		this.page.element(triageCategoryEnabled, "xpath").getOne().click();
		
		if(this.page.element(triageCategoryReq, "xpath").getOne().isSelected())
			this.page.element(triageCategoryReq, "xpath").getOne().click();
		return this;
	}
		
		
	
	
}
