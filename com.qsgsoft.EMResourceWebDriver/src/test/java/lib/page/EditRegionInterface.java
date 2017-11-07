package lib.page;

import org.openqa.selenium.WebDriver;
import static org.testng.Assert.assertEquals;

import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;

public class EditRegionInterface extends PageObject{
	WebDriver driver;
	WaitForElement objWaitForElement;
	
	public String editRegionInterface = "//body//div/h1[text()='Edit Region Interface']",
			name	= "regionInterfaceName",
		    description = "description",
		    contInfo = "contactInfo";

	public EditRegionInterface(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Edit Region Interface' Page is displayed.
	* Date 		  : 01-Jun-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public EditRegionInterface verEditRegionInterfacePageIsDisplayed(
			String strForm) throws Exception {
		objWaitForElement.waitForElements(editRegionInterface, "xpath");
		this.page.element(editRegionInterface, "xpath").getOne().isDisplayed();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify Name Of Interface In 'Edit Region Interface' Page while editing the interface.
	* Date 		  : 01-Jun-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public EditRegionInterface verNameOfInterfaceInEditRegionInterfacePage(
			String interfacename) throws Exception {
		objWaitForElement.waitForElements(name, "name");
		String st1 = this.page.element(name, "name").getOne()
				.getAttribute("value");
		assertEquals(st1, interfacename);
		return this;
	}

	/**********************************************************************************
	* Description : This function is to verify Description Of Interface In 'Edit Region Interface' Page while editing the interface.
	* Date 		  : 01-Jun-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public EditRegionInterface verDescriptionOfInterfaceInEditRegionInterfacePage(
			String interfacedeacription) throws Exception {
		objWaitForElement.waitForElements(description, "name");
		assertEquals(
				(this.page.element(description, "name").getOne()
						.getAttribute("value")),
				interfacedeacription);
		return this;
	}

	/**********************************************************************************
	* Description : This function is to verify Contact Information Of Interface In 'Edit Region Interface' Page while editing the interface.
	* Date 		  : 01-Jun-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public EditRegionInterface verContactInformationOfInterfaceInEditRegionInterfacePage(
			String ContactInformation) throws Exception {
		objWaitForElement.waitForElements(contInfo, "name");
		assertEquals(
				(this.page.element(contInfo, "name").getOne()
						.getAttribute("value")),
				ContactInformation);
		return this;
	}

}
