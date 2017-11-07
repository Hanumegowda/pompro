package lib.page;

import static org.testng.Assert.*;

import org.openqa.selenium.WebDriver;

import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;

public class HaveBed extends PageObject{
	
	WebDriver driver;
	WaitForElement objWaitForElement ;

	public HaveBed(WebDriver _driver) throws Exception {
		super(_driver);
		// TODO Auto-generated constructor stub
	}
	
	//Locators
	private String nextBtn = "input[value='Next']",
			       headerPage = "//div[@id='topSubNav']/h1",
			       StateList = "stateAbbrev";

	/**********************************************************************************
	  * Description : This function is verify 'Select Bed Reporting State' page
	  * Date        : 05/08/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public HaveBed verSelectBedReportingStatePage() throws Exception {
		Thread.sleep(5000);
		String strText = this.page.element(headerPage, "xpath").getOne()
				.getText();
		assertEquals("Select Bed Reporting State", strText);
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to select Region name
	  * Date        : 09/06/2014
	  * Author      : Anil
	  **********************************************************************************/
	public HaveBed selectState(String strStateName) throws Exception {
		this.page.element(StateList, "name").webElementToSelect()
				.selectByVisibleText(strStateName);
		return this;
	}
	/**********************************************************************************
	  * Description : This function is to click on 'Next' button
	  * Date        : 09/06/2014
	  * Author      : Anil
	  **********************************************************************************/
	public HaveBed clickNextButton() throws Exception {
		this.page.element(nextBtn, "css").getOne().click();
		return this;
	}
	/**********************************************************************************
	  * Description : This function is verify 'Select Bed Reporting State' page
	  * Date        : 05/08/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public HaveBed verHavBedReportingSchedulePage() throws Exception {
         Thread.sleep(5000);
		String strText = this.page.element(headerPage, "xpath").getOne()
				.getText();
		assertEquals("HAvBED Reporting Schedule", strText);
		return this;

	}
}
