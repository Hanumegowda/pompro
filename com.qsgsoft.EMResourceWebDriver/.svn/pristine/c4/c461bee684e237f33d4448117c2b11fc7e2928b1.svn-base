package lib.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.*;
import qaframework.lib.WaitTimeConstants;
import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;

public class UserLinks extends PageObject {
	
	WebDriver driver;
	WaitForElement objWaitForElement ;
	
	//Locators
	private String userLinks = "//div[@id='mainContainer']/table/tbody//tr/td/a[text()='User Links']",
			createNewUserLinkBtn = "//div[@id='mainContainer']/input[@value='Create New User Link']",
			labelTextInput = "//div[@id='mainContainer']/form/table/tbody/tr/td[text()='Label Text:']/following-sibling::td/input",
			imageFile = "//div[@id='mainContainer']/form/table/tbody/tr/td[text()='Image File:']/following-sibling::td/input[@type='file']",
			selectTypeOfLinkToCreate = "//div[@id='mainContainer']/form/table/tbody/tr/td[text()='Select type of link to create:']",
			urlForAnExternalSiteInput = "//div[@id='mainContainer']/form/table/tbody/tr[3]/td[2][text()='URL for an external site']/input[@name='destinationUrl']",
			emResourceFormInput = "//div[@id='mainContainer']/form/table/tbody/tr[3]/td[2][text()='EMResource Form']/select[@name='questionaireID']",
			quickLink = "//div[@id='mainContainer']/form/table/tbody/tr/td[text()='Quick Link:']",
			radioBtnOfURLForAnExternalSite = "//div[@id='mainContainer']/form/table/tbody/tr/td/input[@value='EXTERNAL'][@checked='checked']",
		    saveBtn = "//div[@id='mainContainer']/form/table/tbody/tr/td/input[@value='Save']",
		    userLinksInUserLinkList = "//div[@id='topNav']/div/a[text()='User Links']",
		    strIPn="//td[@class='emsLabel'][text()='Select type of link to create:']/following::td/input[@value='IPN']",
		    strUlink="//h1[text()='Create New User Link']",
		    strQuickLinkChkBox="//input[@name='quickLink']";
	
	public UserLinks(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
	}

	/**********************************************************************************
	 * Description : This function is to navigate to 'User Links'
	 * Date        : 30/07/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UserLinks navigateToUserLinks() throws Exception {
		objWaitForElement.waitForElements(userLinks, "xpath");
		this.page.element(userLinks, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Create new user link' button
	 * Date        : 30/07/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UserLinks clkCreateNewUserLinkBtn() throws Exception {
		objWaitForElement.waitForElements(createNewUserLinkBtn, "xpath");
		this.page.element(createNewUserLinkBtn, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Label text' option is present
	 * Date        : 30/07/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UserLinks vfyLabelTextInputOptipnIsPresent() throws Exception {
		objWaitForElement.waitForElements(labelTextInput, "xpath");
		assertTrue(this.page.element(labelTextInput, "xpath")
				.getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Image file' option is present
	 * Date        : 30/07/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UserLinks vfyImageFileOptipnIsPresent() throws Exception {
		objWaitForElement.waitForElements(imageFile, "xpath");
		assertTrue(this.page.element(imageFile, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/*******************************************************************************************
	 * Description : This function is to verify 'Select type of link to create' option is present
	 * Date        : 30/07/2014
	 * Author      : Sowmya
	 ******************************************************************************************/
	public UserLinks vfyselectTypeOfLinkToCreateOptipnIsPresent()
			throws Exception {
		objWaitForElement.waitForElements(selectTypeOfLinkToCreate, "xpath");
		assertTrue(this.page.element(selectTypeOfLinkToCreate, "xpath")
				.getOne().isDisplayed());
		return this;
	}
	
	/****************************************************************************************
	 * Description : This function is to verify 'URL for an external site' option is present
	 * Date        : 30/07/2014
	 * Author      : Sowmya
	 ****************************************************************************************/
	public UserLinks vfyUrlForAnExternalSiteInputOptipnIsPresent()
			throws Exception {
		objWaitForElement.waitForElements(urlForAnExternalSiteInput, "xpath");
		assertTrue(this.page.element(urlForAnExternalSiteInput, "xpath")
				.getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'EMResource Form' option is present
	 * Date        : 30/07/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UserLinks vfyEMResourceFormInputOptipnIsPresent() throws Exception {
		objWaitForElement.waitForElements(emResourceFormInput, "xpath");
		assertTrue(this.page.element(emResourceFormInput, "xpath")
				.getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Quick link' option is present
	 * Date        : 30/07/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UserLinks vfyQuickLinkOptipnIsPresent() throws Exception {
		objWaitForElement.waitForElements(quickLink, "xpath");
		assertTrue(this.page.element(quickLink, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/*****************************************************************************************************
	 * Description : This function is to verify radio button of the 'URL for an external site' is checked 
	 * Date        : 30/07/2014
	 * Author      : Sowmya
	 ****************************************************************************************************/
	public UserLinks radioBtnOfURLForAnExternalSiteIsChecked() throws Exception {
		objWaitForElement.waitForElements(radioBtnOfURLForAnExternalSite, "xpath");
		assertTrue(this.page.element(radioBtnOfURLForAnExternalSite, "xpath")
				.getOne().isDisplayed());
		return this;
	}
	
	/************************************************************************************
	 * Description : This function is to enter the label name in 'Label text' input field 
	 * Date        : 30/07/2014
	 * Author      : Sowmya
	 ************************************************************************************/
	public UserLinks enterLabelText(String strLabelName) throws Exception {
		objWaitForElement.waitForElements(labelTextInput, "xpath");
		this.page.element(labelTextInput, "xpath").clearInputValue()
				.sendKeys(strLabelName);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to 'Upload a file'
	 * Date        : 30/07/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UserLinks uploadFile(String strPathOfTheFile)
			throws Exception {
		objWaitForElement.waitForElements(imageFile, "xpath");
		this.page.element(imageFile, "xpath").getOne().sendKeys(strPathOfTheFile);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter URL in 'URL for an external site' field
	 * Date        : 30/07/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UserLinks enterURL(String strURL) throws Exception {
		objWaitForElement.waitForElements(urlForAnExternalSiteInput, "xpath");
		this.page.element(urlForAnExternalSiteInput, "xpath").clearInputValue()
				.sendKeys(strURL);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Save' button
	 * Date        : 30/07/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UserLinks clkOnSaveBtn() throws Exception {
		objWaitForElement.waitForElements(saveBtn, "xpath");
		this.page.element(saveBtn, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Edit' option is present
	 * Date        : 30/07/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UserLinks vfyEditOptionIsPresent(String strLabelName)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table/thead/tr/th[1][text()='Action']/ancestor::table//tbody/tr/td[2][text()='"
				+ strLabelName
				+ "']/parent::tr/td[1]/a[text()='Edit']",
		"xpath");
		assertTrue(this.page
				.element(
						"//div[@id='mainContainer']/table/thead/tr/th[1][text()='Action']/ancestor::table//tbody/tr/td[2][text()='"
								+ strLabelName
								+ "']/parent::tr/td[1]/a[text()='Edit']",
						"xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Delete' option is present
	 * Date        : 30/07/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UserLinks vfyDeleteOptionIsPresent(String strLabelName)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table/thead/tr/th[1][text()='Action']/ancestor::table//tbody/tr/td[2][text()='"
				+ strLabelName
				+ "']/parent::tr/td[1]/a[text()='Delete']",
		"xpath");
		assertTrue(this.page
				.element(
						"//div[@id='mainContainer']/table/thead/tr/th[1][text()='Action']/ancestor::table//tbody/tr/td[2][text()='"
								+ strLabelName
								+ "']/parent::tr/td[1]/a[text()='Delete']",
						"xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Show' option is present
	 * Date        : 30/07/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UserLinks vfyShowOptionIsPresent(String strLabelName)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table/thead/tr/th[1][text()='Action']/ancestor::table//tbody/tr/td[2][text()='"
				+ strLabelName
				+ "']/parent::tr/td[1]/a[text()='Show']",
		"xpath");
		assertTrue(this.page
				.element(
						"//div[@id='mainContainer']/table/thead/tr/th[1][text()='Action']/ancestor::table//tbody/tr/td[2][text()='"
								+ strLabelName
								+ "']/parent::tr/td[1]/a[text()='Show']",
						"xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Up' option is present
	 * Date        : 30/07/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UserLinks vfyUpOptionIsPresent(String strLabelName) throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table/thead/tr/th[1][text()='Action']/ancestor::table//tbody/tr/td[2][text()='"
				+ strLabelName
				+ "']/parent::tr/td[1]/a[text()='Up']", "xpath");
		assertTrue(this.page
				.element(
						"//div[@id='mainContainer']/table/thead/tr/th[1][text()='Action']/ancestor::table//tbody/tr/td[2][text()='"
								+ strLabelName
								+ "']/parent::tr/td[1]/a[text()='Up']", "xpath")
				.getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Link name'in User link list
	 * Date        : 30/07/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UserLinks vfyLinkNameInUserLinkList(String strLabelName)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table/thead/tr/th[2][text()='Link']/ancestor::table//tbody/tr/td[2][text()='"
				+ strLabelName + "']", "xpath");
		assertTrue(this.page
				.element(
						"//div[@id='mainContainer']/table/thead/tr/th[2][text()='Link']/ancestor::table//tbody/tr/td[2][text()='"
								+ strLabelName + "']", "xpath")
				.getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Show as' options in User link list
	 * Date        : 30/07/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UserLinks vfyShowAs(String strLabelName, String strShowAS)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table/thead/tr/th/ancestor::table//tbody/tr/td[2][text()='"
				+ strLabelName
				+ "']/parent::tr/td[3][text()='"
				+ strShowAS + "']", "xpath");
		assertTrue(this.page
				.element(
						"//div[@id='mainContainer']/table/thead/tr/th/ancestor::table//tbody/tr/td[2][text()='"
								+ strLabelName
								+ "']/parent::tr/td[3][text()='"
								+ strShowAS + "']", "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Image size' 
	 * Date        : 30/07/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UserLinks vfyImageSize(String strLabelName, String strImageSize)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table/thead/tr/th/ancestor::table//tbody/tr/td[2][text()='"
				+ strLabelName + "']/parent::tr/td[6][text()='" +strImageSize + "']",
		"xpath");
		assertTrue(this.page
				.element(
						"//div[@id='mainContainer']/table/thead/tr/th/ancestor::table//tbody/tr/td[2][text()='"
								+ strLabelName + "']/parent::tr/td[6][text()='" +strImageSize + "']",
						"xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'File size' 
	 * Date        : 30/07/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UserLinks vfyFileSize(String strLabelName, String strFileSize)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table/thead/tr/th/ancestor::table//tbody/tr/td[2][text()='"
				+ strLabelName + "']/parent::tr/td[7][text()='" +strFileSize + "']",
		"xpath");
		assertTrue(this.page
				.element(
						"//div[@id='mainContainer']/table/thead/tr/th/ancestor::table//tbody/tr/td[2][text()='"
								+ strLabelName + "']/parent::tr/td[7][text()='" +strFileSize + "']",
						"xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Destination URL' 
	 * Date        : 30/07/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UserLinks vfyDestinationURL(String strURL, String strLabelName)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table/thead/tr/th/ancestor::table//tbody/tr/td[2][text()='" + strLabelName + "']/parent::tr/td[5]", "xpath");
		assertEquals(strURL, this.page.element("//div[@id='mainContainer']/table/thead/tr/th/ancestor::table//tbody/tr/td[2][text()='" + strLabelName + "']/parent::tr/td[5]", "xpath").getOne().getText());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Show' link
	 * Date        : 30/07/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UserLinks clkShowLink(String strLabelName)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table/thead/tr/th[1][text()='Action']/ancestor::table//tbody/tr/td[2][text()='"
				+ strLabelName
				+ "']/parent::tr/td[1]/a[text()='Show']",
		"xpath");
		this.page
				.element(
						"//div[@id='mainContainer']/table/thead/tr/th[1][text()='Action']/ancestor::table//tbody/tr/td[2][text()='"
								+ strLabelName
								+ "']/parent::tr/td[1]/a[text()='Show']",
						"xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Hide' option is present
	 * Date        : 30/07/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UserLinks vfyHideOptionIsPresent(String strLabelName)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table/thead/tr/th[1][text()='Action']/ancestor::table//tbody/tr/td[2][text()='"
				+ strLabelName
				+ "']/parent::tr/td[1]/a[text()='Hide']",
		"xpath");
		assertTrue(this.page
				.element(
						"//div[@id='mainContainer']/table/thead/tr/th[1][text()='Action']/ancestor::table//tbody/tr/td[2][text()='"
								+ strLabelName
								+ "']/parent::tr/td[1]/a[text()='Hide']",
						"xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to mouse over on the 'User links' in User link list page
	 * Date        : 30/07/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UserLinks mouseOverOnUserLinksInHeader()
			throws Exception {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.linkText("User Links"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		executor.executeScript("return $(\"a:contains('User Links')\").mouseover();");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify the 'Label name' and that 'image'
	 *               after mouse over on the 'User links' in User link list page
	 * Date        : 30/07/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UserLinks vfyAndClickCreatedLink(String strLabelName) throws Exception {
		Thread.sleep(1000);
		assertTrue(this.page.element(
				"//div[@id='topNav']//span[text()='" + strLabelName
						+ "']/parent::a/img", "xpath").getOne().isDisplayed());
		this.page
		.element(
				"//div[@id='topNav']//span[text()='" + strLabelName
						+ "']", "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Link' after mouse over on the 'User links' in User link list page
	 * Date        : 30/07/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UserLinks clkOnCreatedLink(String strLabelName) throws Exception {
		objWaitForElement.waitForElements("//div[@id='topNav']//span[text()='" + strLabelName
				+ "']", "xpath");
		this.page
				.element(
						"//div[@id='topNav']//span[text()='" + strLabelName
								+ "']", "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Hide' option is present
	 * Date        : 30/07/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public UserLinks clkOnHideLink(String strLabelName)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table/thead/tr/th[1][text()='Action']/ancestor::table//tbody/tr/td[2][text()='"
				+ strLabelName
				+ "']/parent::tr/td[1]/a[text()='Hide']",
		"xpath");

		this.page
				.element(
						"//div[@id='mainContainer']/table/thead/tr/th[1][text()='Action']/ancestor::table//tbody/tr/td[2][text()='"
								+ strLabelName
								+ "']/parent::tr/td[1]/a[text()='Hide']",
						"xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Incoming patient radio Btn option is present
	 * Date        : 5/2/2016
	 * Author      : Sangappa K
	 **********************************************************************************/
	public UserLinks vfyIncomingPatientRadionBtn() throws Exception {
		objWaitForElement.waitForElements(strIPn, "xpath");
		assertTrue(this.page.element(strIPn, "xpath").getOne().isDisplayed());
		return this;
	}
	

	/**********************************************************************************
	 * Description : This function is to verify Incoming patient radio Btn option is  not present
	 * Date        : 5/2/2016
	 * Author      : Sangappa K
	 **********************************************************************************/
	public UserLinks vfyIncomingPatientRadionBtnIsNotPresent() throws Exception {
		objWaitForElement.waitForElements(strIPn, "xpath");
		assertFalse(this.page.element(strIPn, "xpath").isElementPresent(
				WaitTimeConstants.WAIT_TIME_SMALL));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Incoming patient radio Btn option is present
	 * Date        : 5/2/2016
	 * Author      : Sangappa K
	 **********************************************************************************/
	public UserLinks vfyCreateUserLinkPage() throws Exception {
		objWaitForElement.waitForElements(strUlink, "xpath");
		assertTrue(this.page.element(strUlink, "xpath").getOne().isDisplayed());
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to select Quick link check box
	 * Date        : 08/02/2016
	 * Author      : Sangappa K
	 **********************************************************************************/
	public UserLinks selectQuickLinkChkBox() throws Exception {
		objWaitForElement.waitForElements(strQuickLinkChkBox, "xpath");
		this.page.element(strQuickLinkChkBox, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Incoming patient radio Btn option is present
	 * Date        : 5/2/2016
	 * Author      : Sangappa K
	 **********************************************************************************/
	public UserLinks selIncomingPatientRadionBtn() throws Exception {
		objWaitForElement.waitForElements(strIPn, "xpath");
		this.page.element(strIPn, "xpath").getOne().click();
		return this;
	}
	
}