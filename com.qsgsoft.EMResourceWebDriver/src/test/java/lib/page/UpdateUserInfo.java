package lib.page;

import org.openqa.selenium.WebDriver;

import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;
import static org.testng.Assert.*;

public class UpdateUserInfo extends PageObject {
	
	WebDriver driver;
	WaitForElement objWaitForElement ;
	
	private String fullName = "input[name='fullName']",
				   firstName = "input[name='firstName']",
				   middleName = "input[name='middleName']",
				   lastName = "input[name='lastName']",
				   organization = "input[name='organization']",
				   phone = "input[name='phone']",
				   email = "textarea[name='eMail']",
				   primaryEMail = "input[name='primaryEMail']",
				   pagerEmail = "textarea[name='textPager']",
				   headerName = "div#topSubNav > h1",
				   saveButton = "input[value='Save']",
				   defaultViewName ="//select[@name='defaultViewID']";
				   
				   
	public UpdateUserInfo(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
	}

	/**********************************************************************************
	 * Description 	: This function is to verify user details are retrieved
	 * Date 		: 22/07/2014
	 * Author 		: Renushree
	 **********************************************************************************/
	public UpdateUserInfo verifyUserDetailsAreRetrieved(String strFullName,String strFirstName,
			String strMiddleName, String strLastName, String strOrganization,
			String strPhone, String strPrimaryMailId, String strEmail,
			String strPagerMailId) throws Exception {
		objWaitForElement.waitForElements(fullName, "css");
		assertEquals(strFullName, this.page.element(fullName, "css").getOne().getAttribute("value"));
		assertEquals(strFirstName, this.page.element(firstName, "css").getOne().getAttribute("value"));
		assertEquals(strMiddleName, this.page.element(middleName, "css").getOne().getAttribute("value"));
		assertEquals(strLastName, this.page.element(lastName, "css").getOne().getAttribute("value"));
		assertEquals(strOrganization, this.page.element(organization, "css").getOne().getAttribute("value"));
		assertEquals(strPhone, this.page.element(phone, "css").getOne().getAttribute("value"));
		assertEquals(strPrimaryMailId, this.page.element(primaryEMail, "css").getOne().getAttribute("value"));
		assertEquals(strEmail, this.page.element(email, "css").getOne().getAttribute("value"));
		assertEquals(strPagerMailId, this.page.element(pagerEmail, "css").getOne().getAttribute("value"));
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify Update UserInfoScreen Is Displayed
	 * Date 		: 10/10/2014
	 * Author 		: shradha
	 **********************************************************************************/
	public UpdateUserInfo verUpdateUserInfoIsDisplayed() throws Exception
	{
		objWaitForElement.waitForElements(headerName, "css");
			assertEquals("Update User Info", this.page.element(headerName, "css")
					.getOne().getText());
			return this;
	}
	/**********************************************************************************
	 * Description 	: This function is to verify full name Update UserInfoScreen Is Displayed
	 * Date 		: 22/07/2014
	 * Author 		: shradha
	 **********************************************************************************/
	public UpdateUserInfo verFullnameUpdateUserInfoPage(String strFullName)
			throws Exception {
		objWaitForElement.waitForElements(fullName, "css");
		String strFileNameInApp = this.page.element(fullName, "css").getOne()
				.getAttribute("value");
		assertEquals(strFullName, strFileNameInApp);
		return this;
	}
	 /**********************************************************************************
	   * Description : This function is to EditFullName
	   * Date        : 10/10/2014
	   * Author      : shradha
	   **********************************************************************************/
	public UpdateUserInfo editFullName(String strEditedFullName)
			throws Exception {
		objWaitForElement.waitForElements(fullName, "css");
		this.page.element(fullName, "css").clearInputValue()
				.sendKeys(strEditedFullName);
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to click save  button
	   * Date        : 11/06/2014
	   * Author      : Anitha
	   **********************************************************************************/
	public UpdateUserInfo clickOnSaveButton() throws Exception {
		objWaitForElement.waitForElements(saveButton, "css");
		this.page.element(saveButton, "css").getOne().click();
		return this;
	}
	/**********************************************************************************
	 * Description 	: This function is to verify PrefrencesMenu page Is Displayed
	 * Date 		: 10/10/2014
	 * Author 		: shradha
	 **********************************************************************************/
	public UpdateUserInfo verPreferencesMenuPageIsDisplayed() throws Exception{
		objWaitForElement.waitForElements(headerName, "css");
		assertEquals("Preferences Menu", this.page.element(headerName, "css")
				.getOne().getText());
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to enter Default View Name
	   * Date        : 3/11/2014
	   * Author      : Sangappa.k
	   **********************************************************************************/
	public UpdateUserInfo selectDefaultViewName(String strCustom)
			throws Exception {
		objWaitForElement.waitForElements(defaultViewName, "xpath");
		this.page.element(defaultViewName, "xpath").webElementToSelect()
		.selectByVisibleText(strCustom);
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify primary email address Is Displayed in user info page of preference.
	 * Date 		: 28/04/2015
	 * Author 		: Hanumegowda
	 **********************************************************************************/
	public UpdateUserInfo verPrimaryMailAddressIsDisplayed(
			String primaryEMailAddress) throws Exception {
		objWaitForElement.waitForElements(primaryEMail, "css");
		assertEquals(primaryEMailAddress, this.page
				.element(primaryEMail, "css").getOne().getAttribute("value"));
		return this;
	}
}
