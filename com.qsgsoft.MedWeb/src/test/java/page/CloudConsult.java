package page;

import module.Frames;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import qaframework.lib.pageObject.PageObject;
import qaframework.lib.userDefinedFunctions.WaitForElement;

public class CloudConsult extends PageObject{
	WebDriver driver;
	WaitForElement objWaitForElement;
	Frames objFrames;
	
	private String strFirstName = "text_first_name",
			       strLastName  =  "text_last_name",
			       strDOB = "text_dob",
			       strConsultingMDEmail = "select_cons_email",
			       strFileCapture = "button_file",
			       strSubmit = "button_submit";
	
	
	public CloudConsult(WebDriver _driver) throws Exception{
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
		objFrames = new Frames(this.driver);
		
	}
	
	/**********************************************************************************
	* Description : This function is to enter the text in first name text field in cloud consult page.
	* Date 		  : 01-Dec-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public CloudConsult enterFirstName(String fn)
			throws Exception {
		objWaitForElement.waitForElements(strFirstName, "id");
		this.page.element(strFirstName, "id").clearInputValue().sendKeys(fn);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter the text in last name text field in cloud consult page.
	* Date 		  : 01-Dec-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public CloudConsult enterLastName(String ln)
			throws Exception {
		objWaitForElement.waitForElements(strLastName, "id");
		this.page.element(strLastName, "id").clearInputValue().sendKeys(ln);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select the date from calander pop up.
	* Date 		  : 01-Dec-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public CloudConsult selDOB()
			throws Exception {
		objWaitForElement.waitForElements(strDOB, "id");
		this.page.element(strDOB, "id").getOne().click();
		/*String str = "//div[@id='ui-datepicker-div']//table[@class='ui-datepicker-calendar']//tbody//tr//td[@class=' ui-datepicker-days-cell-over ui-datepicker-today']//a[@class='ui-state-default ui-state-highlight']";
		this.page.element(str, "xpath").mouseOver();
		this.page.element(str, "xpath").getOne().click();*/
		this.page.element(strDOB, "id").getOne().sendKeys(Keys.ENTER);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select 'Consulting MD E-mail' dropdown option.
	* Date 		  : 01-Dec-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public CloudConsult selConsultingMDEmail()
			throws Exception {
		objWaitForElement.waitForElements(strConsultingMDEmail, "id");
		this.page.element(strConsultingMDEmail, "id").webElementToSelect().selectByIndex(1);
		
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'file capture' button.
	* Date 		  : 01-Dec-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public CloudConsult clickOnFileCapture()
			throws Exception {
		objWaitForElement.waitForElements(strFileCapture, "id");
		this.page.element(strFileCapture, "id").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'submit' button.
	* Date 		  : 01-Dec-2016
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public CloudConsult clickOnSubmit()
			throws Exception {
		objWaitForElement.waitForElements(strSubmit, "id");
		this.page.element(strSubmit, "id").getOne().click();
		return this;
	}
	
	
}
