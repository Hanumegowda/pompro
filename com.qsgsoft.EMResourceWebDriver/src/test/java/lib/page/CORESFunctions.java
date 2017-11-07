package lib.page;

import static org.testng.Assert.*;

import org.openqa.selenium.WebDriver;

import qaframework.lib.WaitTimeConstants;
import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;

public class CORESFunctions extends PageObject {
	
	WebDriver driver;
	WaitForElement objWaitForElement;
	
	private String courseUsername = "#username",
			       notRegisterd = "Not Registered?",			 
			       password = "#password",
			       confirmPassword = "#confirm_password",
			       secretQuestionDropDown = "secret_question_list_id",
			       secretAnswer = "#secret_answer",
			       termsOfService = "tos_yes",
			       informationPledge = "pledge_consent_yes",
			       firstName = "first_name",
			       lastName = "last_name",
			       address1 = "legal_residence_line1",
			       city = "city",
			       state = "state_list_id",
			       zipcode = "zip",
			       contactMethod1 = "contact_method_list_id_1",
			       occupationType = "discipline_question",
			       occupation = "discipline_list_id",
			       statusForOccupation = "employment_status_list_id",
			       numberToAttempt1 = "areacode_contact_number_1",
			       numberToAttempt2 = "exchange_contact_number_1",
			       numberToAttempt3 = "number_contact_number_1",
			       nextButton = "submit_agreement",
			       homePage = "//div[@class='panelhead']/h3[text()='Home']",
			       logout = "logout_link",
			       close = "close",
			       loginToLinkedAcc = "//a[@href='sso_login.php?idp=credence-qa']",
			       login = "input[value='Log In']",
			       changeApp = "#change_app",
			       missionTab="//div/a/span[text()='Missions']",
			       myAvailability="//div[@class='panelhead']/h3[text()='My Availability']";

	public CORESFunctions(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
	}
	
	/***********************************************************************************
	 * Description	: This function is to launch the application URL
	 * Arguments	: none
	 * Date			: 14-10-2014
	 * Author		: Sowmya
	 * *********************************************************************************
	 */
	public CORESFunctions launchCORESUrl() throws Exception {
		driver.get("https://dots-sso.demo.collaborativefusion.com/");
		objWaitForElement.waitForElements(courseUsername, "css");
		assertTrue(this.page.element(courseUsername, "css").isElementPresent());
		return this;
	}
	
	/***********************************************************************************
	 * Description	: This function is to click on 'Not Registered?' link
	 * Arguments	: none
	 * Date			: 14-10-2014
	 * Author		: Sowmya
	 * *********************************************************************************
	 */
	public CORESFunctions clickOnNotRegistered() throws Exception {
		objWaitForElement.waitForElements(notRegisterd, "linktext");
		this.page.element(notRegisterd, "linktext").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is to enter Username while creating a user
	 * Arguments	: strUsername
	 * Date			: 14-10-2014
	 * Author		: Sowmya
	 **********************************************************************************
	 */
	public CORESFunctions enterUsername(String strUsername) throws Exception {
		objWaitForElement.waitForElements(courseUsername, "css");
		this.page.element(courseUsername, "css").clearInputValue()
				.sendKeys(strUsername);
		assertEquals(strUsername, this.page.element(courseUsername, "css")
				.getOne().getAttribute("value"));
		return this;
	}

	/**********************************************************************************
	 * Description	: This function is to enter password while creating a user
	 * Arguments	: strPassword
	 * Date			: 14-10-2014
	 * Author		: Sowmya
	 * ********************************************************************************/
	public CORESFunctions enterPassword(String strPassword) throws Exception {
		this.page.element(password, "css").clearInputValue()
				.sendKeys(strPassword);
		assertEquals(strPassword, this.page.element(password, "css").getOne()
				.getAttribute("value"));
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is to enter confirm password while creating a user
	 * Arguments	: strConfirmPassword
	 * Date			: 14-10-2014
	 * Author		: Sowmya
	 * ********************************************************************************/
	public CORESFunctions enterConfirmPassword(String strConfirmPassword)
			throws Exception {
		objWaitForElement.waitForElements(confirmPassword, "css");
		this.page.element(confirmPassword, "css").clearInputValue()
				.sendKeys(strConfirmPassword);
		assertEquals(strConfirmPassword, this.page.element(confirmPassword, "css")
				.getOne().getAttribute("value"));
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is to select 'Secret Question'
	 * Arguments	: strQuestion
	 * Date			: 14-10-2014
	 * Author		: Sowmya
	 * ********************************************************************************/
	public CORESFunctions selectSecretQuestion(String strQuestion)
			throws Exception {
		this.page.element(secretQuestionDropDown, "id").isElementPresent();
		this.page.element(secretQuestionDropDown, "id").webElementToSelect()
				.selectByVisibleText(strQuestion);
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is to enter 'Secret answer'
	 * Arguments	: strAnswer
	 * Date			: 14-10-2014
	 * Author		: Sowmya
	 * ********************************************************************************/
	public CORESFunctions enterSecretAnswer(String strAnswer) throws Exception {
		this.page.element(secretAnswer, "css").clearInputValue()
				.sendKeys(strAnswer);
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is to click on 'Terms of service' checkbox
	 * Arguments	: none
	 * Date			: 14-10-2014
	 * Author		: Sowmya
	 * ********************************************************************************/
	public CORESFunctions selectTermsOfServiceCheckbox() throws Exception {
		this.page.element(termsOfService, "id").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is to click on 'Information pledge' checkbox
	 * Arguments	: none
	 * Date			: 14-10-2014
	 * Author		: Sowmya
	 * ********************************************************************************/
	public CORESFunctions selectInformationPledgeCheckbox() throws Exception {
		this.page.element(informationPledge, "id").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is to enter 'First name'
	 * Arguments	: strFirstName
	 * Date			: 14-10-2014
	 * Author		: Sowmya
	 * ********************************************************************************/
	public CORESFunctions enterFirstName(String strFirstName) throws Exception {
		this.page.element(firstName, "id").clearInputValue()
				.sendKeys(strFirstName);
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is to enter 'Last name'
	 * Arguments	: strLastName
	 * Date			: 14-10-2014
	 * Author		: Sowmya
	 * ********************************************************************************/
	public CORESFunctions enterLastName(String strLastName) throws Exception {
		this.page.element(lastName, "id").clearInputValue()
				.sendKeys(strLastName);
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is to enter 'Address Line 1'
	 * Arguments	: strAddressLine1
	 * Date			: 14-10-2014
	 * Author		: Sowmya
	 * ********************************************************************************/
	public CORESFunctions enterAddressLine1(String strAddressLine1)
			throws Exception {
		this.page.element(address1, "id").clearInputValue()
				.sendKeys(strAddressLine1);
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is to enter 'City'
	 * Arguments	: strCity
	 * Date			: 14-10-2014
	 * Author		: Sowmya
	 * ********************************************************************************/
	public CORESFunctions enterCity(String strCity) throws Exception {
		this.page.element(city, "id").clearInputValue().sendKeys(strCity);
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is to select 'State'
	 * Arguments	: strState
	 * Date			: 14-10-2014
	 * Author		: Sowmya
	 * ********************************************************************************/
	public CORESFunctions selectState(String strState) throws Exception {
		this.page.element(state, "id").isElementPresent();
		this.page.element(state, "id").webElementToSelect()
				.selectByVisibleText(strState);
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is to enter 'Zipcode'
	 * Arguments	: strZipcode
	 * Date			: 14-10-2014
	 * Author		: Sowmya
	 * ********************************************************************************/
	public CORESFunctions enterZipCode(String strZipcode) throws Exception {
		this.page.element(zipcode, "id").clearInputValue().sendKeys(strZipcode);
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is to select 'Contact Method'
	 * Arguments	: strContactMethod
	 * Date			: 14-10-2014
	 * Author		: Sowmya
	 * ********************************************************************************/
	public CORESFunctions selectContactMethod1(String strContactMethod) throws Exception {
		this.page.element(contactMethod1, "id").isElementPresent();
		this.page.element(contactMethod1, "id").webElementToSelect()
				.selectByVisibleText(strContactMethod);
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is to enter 'Number To Attempt' first inbox
	 * Arguments	: strNumber
	 * Date			: 14-10-2014
	 * Author		: Sowmya
	 * ********************************************************************************/
	public CORESFunctions enterNumberToAttempt1(String strNumber)
			throws Exception {
		this.page.element(numberToAttempt1, "id").clearInputValue()
				.sendKeys(strNumber);
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is to enter 'Number To Attempt' second inbox
	 * Arguments	: strNumber2
	 * Date			: 14-10-2014
	 * Author		: Sowmya
	 * ********************************************************************************/
	public CORESFunctions enterNumberToAttempt2(String strNumber2)
			throws Exception {
		this.page.element(numberToAttempt2, "id").clearInputValue()
				.sendKeys(strNumber2);
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is to enter 'Number To Attempt' third inbox
	 * Arguments	: strNumber2
	 * Date			: 14-10-2014
	 * Author		: Sowmya
	 * ********************************************************************************/
	public CORESFunctions enterNumberToAttempt3(String strNumber3)
			throws Exception {
		this.page.element(numberToAttempt3, "id").clearInputValue()
				.sendKeys(strNumber3);
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is to select 'Occupation type'
	 * Arguments	: strOccupationType
	 * Date			: 14-10-2014
	 * Author		: Sowmya
	 * ********************************************************************************/
	public CORESFunctions selectOccupationType(String strOccupationType)
			throws Exception {
		this.page.element(occupationType, "id").isElementPresent();
		this.page.element(occupationType, "id").webElementToSelect()
				.selectByVisibleText(strOccupationType);
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is to select 'Occupation'
	 * Arguments	: strOccupation
	 * Date			: 14-10-2014
	 * Author		: Sowmya
	 * ********************************************************************************/
	public CORESFunctions selectOccupation(String strOccupation)
			throws Exception {
		this.page.element(occupation, "id").isElementPresent();
		this.page.element(occupation, "id").webElementToSelect()
				.selectByVisibleText(strOccupation);
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is to select 'Status for Occupation'
	 * Arguments	: strStatusForOccupation
	 * Date			: 14-10-2014
	 * Author		: Sowmya
	 * ********************************************************************************/
	public CORESFunctions selectStatusForOccupation(String strStatusForOccupation)
			throws Exception {
		this.page.element(statusForOccupation, "id").isElementPresent();
		this.page.element(statusForOccupation, "id").webElementToSelect()
				.selectByVisibleText(strStatusForOccupation);
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is to click on 'Next' button
	 * Arguments	: none
	 * Date			: 14-10-2014
	 * Author		: Sowmya
	 * ********************************************************************************/
	public CORESFunctions clickOnNextButton() throws Exception {
		this.page.element(nextButton, "id").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is to click on 'Next' button
	 * Arguments	: none
	 * Date			: 14-10-2014
	 * Author		: Sowmya
	 * ********************************************************************************/
	public CORESFunctions verifyHomePage() throws Exception {
		objWaitForElement.waitForElements(homePage, "xpath");
		assertTrue(this.page.element(homePage, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is to click on 'logout' 
	 * Arguments	: none
	 * Date			: 14-10-2014
	 * Author		: Sowmya
	 * ********************************************************************************/
	public CORESFunctions clickOnLogout() throws Exception {
		objWaitForElement.waitForElements(logout, "id");
		this.page.element(logout, "id").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is to create a user
	 * Arguments	: none
	 * Date			: 14-10-2014
	 * Author		: Sowmya
	 * ********************************************************************************/
	public CORESFunctions createUser(String strUsername, String strPassword,
			String strConfirmPassword, String strQuestion, String strAnswer,
			String strFirstName, String strLastName, String strAddressLine1,
			String strCity, String strState, String strZipcode,
			String strContactMethod, String strNumber, String strNumber2,
			String strNumber3, String strOccupationType, String strOccupation,
			String strStatusForOccupation) throws Exception {
		this.clickOnNotRegistered();
		this.enterUsername(strUsername);
		this.enterPassword(strPassword);
		this.enterConfirmPassword(strConfirmPassword);
		this.selectSecretQuestion(strQuestion);
		this.enterSecretAnswer(strAnswer);
		this.selectTermsOfServiceCheckbox();
		this.selectInformationPledgeCheckbox();
		this.enterFirstName(strFirstName);
		this.enterLastName(strLastName);
		this.enterAddressLine1(strAddressLine1);
		this.enterCity(strCity);
		this.selectState(strState);
		this.enterZipCode(strZipcode);
		this.selectContactMethod1(strContactMethod);
		this.enterNumberToAttempt1(strNumber);
		this.enterNumberToAttempt2(strNumber2);
		this.enterNumberToAttempt3(strNumber3);
		this.selectOccupationType(strOccupationType);
		this.selectOccupation(strOccupation);
		this.selectStatusForOccupation(strStatusForOccupation);
		this.clickOnNextButton();
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is to click on 'logout' 
	 * Arguments	: none
	 * Date			: 14-10-2014
	 * Author		: Sowmya
	 * ********************************************************************************/
	public CORESFunctions clickOnAttentionRequiredClosebtn() throws Exception {
		objWaitForElement.waitForElements(close, "id");
		this.page.element(close, "id").getOne().click();
		return this;
	}
	
	/***********************************************************************************
	 * Description	: This function is to click on 'Log in to Linked Accounts (QA)?' link
	 * Arguments	: none
	 * Date			: 17-10-2014
	 * Author		: Renushree
	 * *********************************************************************************
	 */
	public CORESFunctions clickOnLoginInToLinkedAcc() throws Exception {
		objWaitForElement.waitForElements(loginToLinkedAcc, "xpath");
		this.page.element(loginToLinkedAcc, "xpath").getOne().click();
		return this;
	}
	
	/***********************************************************************************
	 * Description	: This function is to click on 'Login' link
	 * Arguments	: none
	 * Date			: 17-10-2014
	 * Author		: Renushree
	 * *********************************************************************************
	 */
	public CORESFunctions clickOnLogin() throws Exception {
		objWaitForElement.waitForElements(login, "css");
		this.page.element(login, "css").getOne().click();
		return this;
	}
	
	/***********************************************************************************
	 * Description	: This function is to click on 'change app' link
	 * Arguments	: none
	 * Date			: 17-10-2014
	 * Author		: Renushree
	 * *********************************************************************************
	 */
	public CORESFunctions clickOnChangeApp() throws Exception {
		objWaitForElement.waitForElements(changeApp, "css");
		this.page.element(changeApp, "css").getOne().click();
		return this;
	}
	
	/***********************************************************************************
	 * Description	: This function is to verify that products under change system 
	 * Arguments	: none
	 * Date			: 17-10-2014
	 * Author		: Renushree
	 * *********************************************************************************
	 */
	public CORESFunctions verProductsUnderChangeApp(String strCores,
			String strEmresource) throws Exception {
		objWaitForElement.waitForElements(strCores, "linktext");
		assertTrue(this.page.element(strCores, "linktext").isElementPresent());
		assertTrue(this.page.element(strEmresource, "linktext")
				.isElementPresent());
		return this;
	}
	
	/***********************************************************************************
	 * Description	: This function is to click on 'change app' link
	 * Arguments	: none
	 * Date			: 17-10-2014
	 * Author		: Renushree
	 * *********************************************************************************
	 */
	public CORESFunctions clickOnEmresourceUnderChangeApp(String strEmresource)
			throws Exception {
		objWaitForElement.waitForElements(strEmresource, "linktext");
		this.page.element(strEmresource, "linktext").getOne().click();
		return this;
	}
	
	/***********************************************************************************
	 * Description	: This function is to verify product is not listed under change system 
	 * Arguments	: none
	 * Date			: 20-10-2014
	 * Author		: Renushree
	 * *********************************************************************************
	 */
	public CORESFunctions verProductsIsNotListedUnderChangeApp(
			String strEmresource) throws Exception {
		assertFalse(this.page.element(strEmresource, "linktext")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}

	/***********************************************************************************
	 * Description	: This function is to click on 'Mission' Tab
	 * Arguments	: none
	 * Date			: 17-10-2014
	 * Author		: Renushree
	 * *********************************************************************************
	 */
	public CORESFunctions clickOnMission() throws Exception {
		objWaitForElement.waitForElements(missionTab, "xpath");
		this.page.element(missionTab, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is to verify mission page
	 * Arguments	: none
	 * Date			: 14-10-2014
	 * Author		: Anitha
	 * ********************************************************************************/
	public CORESFunctions verifyMissionPage() throws Exception {
		objWaitForElement.waitForElements(myAvailability, "xpath");
		assertTrue(this.page.element(myAvailability, "xpath").isElementPresent());
		return this;
	}
}