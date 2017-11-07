package lib.page;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;

public class UploadList extends PageObject{

	WebDriver driver;
	WaitForElement objWaitForElement ;
	
	private String uploadResourceBtn 			= "input[value='Upload Resources']";
	
	public UploadList(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
	}
	
	/**********************************************************************************
	  * Description : This function is to verify uploaded file details in 'Upload List'
	  * Date        : 24-Sep-2014
	  * Author      : Deepa
	  **********************************************************************************/
	public UploadList verUploadedFileDetailsInUploadList(String strIsTest,
			String strTime, String strUsername) throws Exception {
		objWaitForElement.waitForElements(uploadResourceBtn, "css");
		verViewDetailsLinkOfUploadedFile();
		verIsTestOfUploadedFile(strIsTest);
		verTimeOfUploadedFile(strTime);
		verUserNameOfUploadedFile(strUsername);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify view details link of uploaded file in upload list
	  * Date        : 24-Sep-2014
	  * Author      : Deepa
	  **********************************************************************************/
	public UploadList verViewDetailsLinkOfUploadedFile() throws Exception {
		assertTrue(this.page
				.element(
						"//table[@class='displayTable striped border sortable']/tbody/tr[1]/td[1]/a[text()='View Details']",
						"xpath").getOne().isDisplayed());
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to verify test value of uploaded file in upload list
	  * Date        : 24-Sep-2014
	  * Author      : Deepa
	  **********************************************************************************/
	public UploadList verIsTestOfUploadedFile(String strIsTest)
			throws Exception {
		String strIsTestValue = this.page
				.element(
						"//table[@class='displayTable striped border sortable']/tbody/tr[1]/td[2]",
						"xpath").getOne().getText();
		assertTrue(strIsTestValue.equals(strIsTest));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify time value of uploaded file in upload list
	  * Date        : 24-Sep-2014
	  * Author      : Deepa
	  **********************************************************************************/
	public UploadList verTimeOfUploadedFile(String strTime) throws Exception {
		String strActualTime = this.page
				.element(
						"//table[@class='displayTable striped border sortable']/tbody/tr[1]/td[3]",
						"xpath").getOne().getText();
		assertTrue(strActualTime.equals(strTime));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify user name of uploaded file in upload list
	  * Date        : 24-Sep-2014
	  * Author      : Deepa
	  **********************************************************************************/
	public UploadList verUserNameOfUploadedFile(String strUsername)
			throws Exception {
		String strUN = this.page
				.element(
						"//table[@class='displayTable striped border sortable']/tbody/tr[1]/td[4]",
						"xpath").getOne().getText();
		assertTrue(strUN.equals(strUsername));
		return this;
	}
	
}
