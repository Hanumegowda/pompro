package page;

import java.util.List;
import static org.testng.Assert.assertTrue;

import module.Frames;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import qaframework.lib.pageObject.PageObject;
import qaframework.lib.userDefinedFunctions.WaitForElement;
import qaframework.lib.webElements.WebElements;

public class Monitor extends PageObject{
	
	WebDriver driver;
	WaitForElement objWaitForElement;
	Frames objFrames;
	
	private String machineChckBxes = "//input[@type='CHECKBOX']",
			       openCentralRadiologyMonitor = "//a[text()='Open Central Radiology Monitor']",
			       centralRadiology = "//b[contains(text(),'Central Radiology')]";
	String[] timeRangesMsgAndDiffTimeRanges = {"Please indicate time range for viewing Central Radiology monitor:","4","6","8"};
	
	public Monitor(WebDriver _driver) throws Exception{
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
		objFrames = new Frames(this.driver);
	}
	
	/**********************************************************************************
	  * Description : This function is to deselect all machines checkboxes in 'Central Radiology' page.
	  * Date        : 25-May-2016
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public Monitor deSelectAllMachinesCheckbox() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElement(machineChckBxes);
		List<WebElement> l = (this.page.element(machineChckBxes, "xpath"))
				.get();
		for (WebElement all : l) {
			if (all.isSelected() == true) {
				all.click();
			}

		}
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select particular machine checkbox in 'Central Radiology' page.
	  * Date        : 25-May-2016
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public Monitor selectAMachineCheckbox(String machine) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		String str = "//td[contains(text(),'"+machine+"')]/preceding-sibling::td/input[@type='CHECKBOX']";
		objWaitForElement.waitForElement(str);
		if((this.page.element(str, "xpath")).getOne().isSelected()==false){
			this.page.element(str, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on 'Open Central Radiology Monitor' button 
	  *               in 'Central Radiology' page.
	  * Date        : 25-May-2016
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public Monitor clickOnOpenCentralRadiologyMonitorButton() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElement(openCentralRadiologyMonitor);
		this.page.element(openCentralRadiologyMonitor, "xpath").getOne()
				.click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify machine description and patient name is displayed in 
	  *               in 'Central Radiology' page.
	  * Date        : 25-May-2016
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public Monitor verMachineDescriptionIsDisplayed(List<String> code, List<String> proc,String pn) throws Exception {
		for(int i=1; i<=2;i++){
		String str = "//td[contains(text(),'"+code.get(i-1)+"-"+proc.get(i-1)+"')]";
		String str1 = "//td[contains(text(),'"+pn+"')]";
		//String str1 = "//td[contains(text(),'"+pn.toUpperCase()+"')]";
		System.out.println(str1+" reqxpath");
		objWaitForElement.waitForElement(str);
		System.out.println(str+" element "+i);
		assertTrue(this.page.element(str, "xpath").isElementPresent());
		assertTrue(this.page.element(str1, "xpath").isElementPresent());
		}
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Central Radiology' page is displaying.
	  * Date        : 17-Nov-2016
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public Monitor verCentralRadiologyPage() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		objWaitForElement.waitForElement(centralRadiology);
		assertTrue(this.page.element(centralRadiology, "xpath")
				.isElementPresent());

		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify different time ranges for viewing Central
	  *               Radiology monitor is displaying in 'Central Radiology' page.
	  * Date        : 18-Nov-2016
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public Monitor verDiffTimeRangesForCentralRadiologyMonitorIsDisplaying() throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		assertTrue(this.page.element("//font[contains(text(),'"+timeRangesMsgAndDiffTimeRanges[0]+"')]", "xpath")
				.isElementPresent());
		assertTrue(this.page.element("//center/input[@type='RADIO'][@name='hour'][@value='"+timeRangesMsgAndDiffTimeRanges[1]+"']", "xpath")
				.isElementPresent());
		assertTrue(this.page.element("//center/input[@type='RADIO'][@name='hour'][@value='"+timeRangesMsgAndDiffTimeRanges[2]+"']", "xpath")
				.isElementPresent());
		assertTrue(this.page.element("//center/input[@type='RADIO'][@name='hour'][@value='"+timeRangesMsgAndDiffTimeRanges[3]+"']", "xpath")
				.isElementPresent());

		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify the machine is displaying in'Central Radiology' page.
	  * Date        : 21-Nov-2016
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public Monitor verMachineInCentralRadiologyPage(String machine) throws Exception {
		objFrames.switchToDefaultFrame().switchToRightFrame()
				.switchToMainInRightFrame();
		String str = "//td[contains(text(),'"+machine+"')]/preceding-sibling::td/input[@type='CHECKBOX']";
		objWaitForElement.waitForElement(str);
		assertTrue(this.page.element(str, "xpath")
				.isElementPresent());

		return this;
	}

}
