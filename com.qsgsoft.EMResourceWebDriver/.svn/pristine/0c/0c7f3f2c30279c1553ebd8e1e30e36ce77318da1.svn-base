package lib.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.*;
import static org.testng.AssertJUnit.assertTrue;
import qaframework.lib.WaitTimeConstants;
import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;

public class ResourceType extends PageObject{

	WebDriver driver;
	WaitForElement objWaitForElement ;
	    //Locators
	    private String setUpLink1 = "//a[@class='mainLink selected'][text()='Setup']";
	    private String setUpLink = "//a[@class='mainLink'][text()='Setup']";
		private String resourceType = "//div[@id='mainContainer']/table/tbody/tr/td/a[text()='Resource Types']";
		private String createNewResourceType = "//input[@value='Create New Resource Type'][@type='button']";
		private String resourceTypeName = "resourceTypeName";
		private String resourceTypeDescription = "description";
		private String resTypeSaveButton = "input[value='Save'][type='submit']";
		private String subResourceTypeButton = "input[name='subResource']",
					   searchButton = "input.searchButton[value='Search']",
					   headerName = "div#topSubNav > h1",
					   activeCheckBox = "//input[@name='active'][@class='checkbox']",
					   inactiveCheckBox="//input[@name='inactive_rt'][@class='checkbox']",
					   statusTypeField = "//td[@class='emsLabel'][text()='Status Types:']",
					   selectAllStatusCheckbox = "//th[@class='nosort checkbox-column']/input",
					   defaultStatusTypeDropdown = "//td[@class='emsLabel'][text()='Default Status Type:']/parent::tr/td/select[@name='defaultStatusTypeID']",
					   resourceTypeNameCheckbox = "//td[@class='emsLabel'][text()='Select the displayable info fields for this resource type:']/parent::tr/td[2][contains(text(),'Resource Type Name')]/input[@name='typeInd']",
					   contactNameCheckbox = "//td[@class='emsLabel'][text()='Select the displayable info fields for this resource type:']/parent::tr/td[2][text()='Contact Name']/input[@name='contactName'][@class='checkbox']",
					   contactTitleCheckbox = "//td[@class='emsLabel'][text()='Select the displayable info fields for this resource type:']/parent::tr/td[2][text()='Contact Title']/input[@name='contactTitle'][@class='checkbox']",
					   phone1Checkbox = "//td[@class='emsLabel'][text()='Select the displayable info fields for this resource type:']/parent::tr/td[2][text()='Phone 1']/input[@name='phone1'][@class='checkbox']",
					   phone2Checkbox = "//td[@class='emsLabel'][text()='Select the displayable info fields for this resource type:']/parent::tr/td[2][text()='Phone 2']/input[@name='phone2'][@class='checkbox']",
					   faxCheckbox = "//td[@class='emsLabel'][text()='Select the displayable info fields for this resource type:']/parent::tr/td[2][text()='Fax']/input[@name='fax'][@class='checkbox']",
					   emailCheckbox = "//td[@class='emsLabel'][text()='Select the displayable info fields for this resource type:']/parent::tr/td[2][text()='Email']/input[@name='email'][@class='checkbox']",
					   nameInHeader = "//div[@id='mainContainer']/table[2]/thead/tr/th[2]/a[text()='Name']",
					   subResourceInHeader = "//div[@id='mainContainer']/table[2]/thead/tr/th[3]/a[text()='Sub-Resource']",
					   activeInHeader = "//div[@id='mainContainer']/table[2]/thead/tr/th[4]/a[text()='Active']",
					   descriptionInHeader = "//div[@id='mainContainer']/table[2]/thead/tr/th[5]/a[text()='Description']",
					   errorTitle = "//span[@class='emsErrorTitle']",
					   errorMsg1 = "//div[@class='emsError']/ul/li",
					   defaultStatusTypeID  = "//select[@name='defaultStatusTypeID']",
					   cancelButton = "input[value='Cancel'][type='button']";
		
	public ResourceType(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
	}

	  /**********************************************************************************
	   * Description : This function is to navigate to Resource type screen
	   * Date        : 11/06/2014
	   * Author      : Anitha
	   **********************************************************************************/
	public ResourceType navigateToResourceTypePage() throws Exception {
		objWaitForElement.waitForElements(setUpLink1, "xpath");
		this.page.element(setUpLink1, "xpath").getOne().click();
		objWaitForElement.waitForElements(resourceType, "xpath");
		this.page.element(resourceType, "xpath").getOne().click();
		return this;
	}
	
	 /**********************************************************************************
	   * Description : This function is to navigate to Resource type screen
	   * Date        : 11/06/2014
	   * Author      : Anitha
	   **********************************************************************************/
	public ResourceType navigateToResourceTypePageNew() throws Exception {
		objWaitForElement.waitForElements(setUpLink, "xpath");
		this.page.element(setUpLink, "xpath").getOne().click();
		objWaitForElement.waitForElements(resourceType, "xpath");
		this.page.element(resourceType, "xpath").getOne().click();
		return this;
	}
	  /**********************************************************************************
	   * Description : This function is to Click resourceType button
	   * Date        : 11/06/2014
	   * Author      : Anitha
	   **********************************************************************************/
	public ResourceType clickOnCreateNewResourceTypeButton() throws Exception {
		objWaitForElement.waitForElements(createNewResourceType, "xpath");
		this.page.element(createNewResourceType, "xpath").getDisplayedOne().click();
		return this;
	}

	  /**********************************************************************************
	   * Description : This function is to enter resourceType Name
	   * Date        : 11/06/2014
	   * Author      : Anitha
	   **********************************************************************************/
	public ResourceType enterResourceTypeName(String strResourceTypeName)
			throws Exception {
		objWaitForElement.waitForElements(resourceTypeName, "name");
		this.page.element(resourceTypeName, "name").clearInputValue()
				.sendKeys(strResourceTypeName);
		return this;
	}

	  /**********************************************************************************
	   * Description : This function is to enter resourceType Description
	   * Date        : 11/06/2014
	   * Author      : Anitha
	   **********************************************************************************/
	public ResourceType enterResourceTypeDescription(
			String strResTypeDescription) throws Exception {
		objWaitForElement.waitForElements(resourceTypeDescription, "name");
		this.page.element(resourceTypeDescription, "name").getOne().sendKeys(strResTypeDescription);;
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to click statustypes
	   * Date        : 11/06/2014
	   * Author      : Anitha
	   **********************************************************************************/
	public ResourceType clickStatusType(String[] strStatusTypeValues)
			throws Exception {
		for (int i = 0; i < strStatusTypeValues.length; i++) {
			objWaitForElement.waitForElements("//input[@value='"
					+ strStatusTypeValues[i] + "'][@name='statusTypeID']",
					"xpath");
			this.page.dynamicElement(
					"StatusTypeValues",
					"//input[@value='" + strStatusTypeValues[i]
							+ "'][@name='statusTypeID']", "xpath").mouseOver();

			this.page
					.dynamicElement(
							"StatusTypeValues",
							"//input[@value='" + strStatusTypeValues[i]
									+ "'][@name='statusTypeID']", "xpath")
					.getOne().sendKeys(Keys.SPACE);
		}
		return this;
	}

	  /**********************************************************************************
	   * Description : This function is to click save button
	   * Date        : 11/06/2014
	   * Author      : Anitha
	   **********************************************************************************/

	public ResourceType clickOnSaveButton() throws Exception {
		objWaitForElement.waitForElements(resTypeSaveButton, "css");
		this.page.element(resTypeSaveButton, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to create status type
	  * Date        : 11/06/2014
	  * Author      : Anitha
	  **********************************************************************************/
	public ResourceType createResourceType(String strResourceTypeName,
			String[] strStatusTypeValue) throws Exception {
		this.clickOnCreateNewResourceTypeButton();
		this.enterResourceTypeName(strResourceTypeName);
		this.clickStatusType(strStatusTypeValue);
		this.clickOnSaveButton();
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to get resource type value
	   * Date        : 28/07/2014
	   * Author      : Anil
	   **********************************************************************************/

	public String getResourceTypeValue(String strResourceType) throws Exception {
		/*this.navigateToResourceTypePage();*/
		String strRTValue = "";
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table[2]/thead/tr/th/a[contains(text(),'Name')]"
				+ "/ancestor::table/tbody/tr/td[2][text()='"
				+ strResourceType + "']/parent::tr/td[1]"
				+ "/a", "xpath");
		String strRTValueArr[] = this.page.dynamicElement("ResourceName", "//div[@id='mainContainer']/table[2]/thead/tr/th/a[contains(text(),'Name')]"
						+ "/ancestor::table/tbody/tr/td[2][text()='"
						+ strResourceType + "']/parent::tr/td[1]"
						+ "/a", "xpath").getOne().getAttribute("href").split("resourceTypeID=");
	
		strRTValue = strRTValueArr[1];
		return strRTValue;
	}
	/**********************************************************************************
	   * Description : This function is to deselect statustypes
	   * Date        : 11/06/2014
	   * Author      : Anitha
	   **********************************************************************************/
	public ResourceType deselectStatusType(String[] strStatusTypeValues)
			throws Exception {
		objWaitForElement.waitForElements("//input[@value='" + strStatusTypeValues[0]
				+ "'][@name='statusTypeID']", "xpath");
		for (int i = 0; i < strStatusTypeValues.length; i++) {
			if (this.page
					.dynamicElement(
							"StatusTypeValues",
							"//input[@value='" + strStatusTypeValues[i]
									+ "'][@name='statusTypeID']", "xpath")
					.getOne().isSelected() == true) {
				this.page
						.dynamicElement(
								"StatusTypeValues",
								"//input[@value='" + strStatusTypeValues[i]
										+ "'][@name='statusTypeID']", "xpath")
						.getOne().click();
			}
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify resource type in list
	 * Date        : 06/08/2014
	 * Author      : Renushree
	**********************************************************************************/
	public ResourceType verResourceTypeInList(String strResourceType)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table[2]/thead/tr/th[2]/a[text()='Name']/ancestor::table/tbody/tr/td[2][text()='"
				+ strResourceType + "']", "xpath");
		assertTrue(this.page
				.element(
						"//div[@id='mainContainer']/table[2]/thead/tr/th[2]/a[text()='Name']/ancestor::table/tbody/tr/td[2][text()='"
								+ strResourceType + "']", "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify resource type in list
	 * Date        : 06/08/2014
	 * Author      : Renushree
	**********************************************************************************/
	public ResourceType verResourceTypeIsActive(String strResourceType)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table/tbody/tr/td[text()='"
				+strResourceType+"']/following-sibling::td[text()='Active']", "xpath");
		assertTrue(this.page
				.element("//div[@id='mainContainer']/table/tbody/tr/td[text()='"
						+strResourceType+"']/following-sibling::td[text()='Active']", "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Edit' link of resource type
	 * Date        : 19/06/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public ResourceType clickOnEditLinkOfResourceType(String strResourceTypeName)
			throws Exception {

		String editRT = "//div[@id='mainContainer']/table[@class='displayTable "
				+ "striped border sortable']/tbody/tr/td[2][text()='"
				+ strResourceTypeName
				+ "']/"
				+ "parent::tr/td[1]/a[text()='Edit']";

		this.page.element(editRT, "xpath").mouseOver();

		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				driver.findElement(By.xpath(editRT)));

		/*
		 * objWaitForElement.waitForElements(editRT, "xpath");
		 * this.page.element(editRT, "xpath").getOne().click();
		 */

		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to Select SubResourceType CheckBox
	   * Date        : 12/09/2014
	   * Author      : Anitha
	   **********************************************************************************/
	public ResourceType selectSubResourceTypeCheckBox() throws Exception {
		objWaitForElement.waitForElements(subResourceTypeButton, "css");
		this.page.element(subResourceTypeButton, "css").getOne().click();
		return this;
	}
	/**********************************************************************************
	  * Description : This function is to create subResource type
	  * Date        : 12/09/2014
	  * Author      : Anitha
	  **********************************************************************************/
	public ResourceType createSubResourceType(String strResourceTypeName,
			String[] strStatusTypeValue) throws Exception {
		this.clickOnCreateNewResourceTypeButton();
		this.enterResourceTypeName(strResourceTypeName);
		this.selectSubResourceTypeCheckBox();
		this.clickStatusType(strStatusTypeValue);
		this.clickOnSaveButton();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify sub resource status resource type in list
	 * Date        : 12/09/2014
	 * Author      : Renushree
	**********************************************************************************/
	public ResourceType verSubResourceInList(String strResourceType,
			String strSubResStatus) throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table[2]/thead/tr/th[3]/a[text()='Sub-Resource']/ancestor::table/tbody/tr/td[2][text()='"
				+ strResourceType
				+ "']/following-sibling::td[1][text()='"
				+ strSubResStatus + "']", "xpath");
		assertTrue(this.page
				.element(
						"//div[@id='mainContainer']/table[2]/thead/tr/th[3]/a[text()='Sub-Resource']/ancestor::table/tbody/tr/td[2][text()='"
								+ strResourceType
								+ "']/following-sibling::td[1][text()='"
								+ strSubResStatus + "']", "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify resource type description
	 * Date        : 12/09/2014
	 * Author      : Renushree
	**********************************************************************************/
	public ResourceType verResourceTypeDescInList(String strResourceType,
			String strDescription) throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table[2]/thead/tr/th[4]/a[text()='Description']/ancestor::table/tbody/tr/td[2][text()='"
				+ strResourceType
				+ "']/following-sibling::td[2][text()='"
				+ strDescription + "']", "xpath");
		assertTrue(this.page
				.element(
						"//div[@id='mainContainer']/table[2]/thead/tr/th[4]/a[text()='Description']/ancestor::table/tbody/tr/td[2][text()='"
								+ strResourceType
								+ "']/following-sibling::td[2][text()='"
								+ strDescription + "']", "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify action header
	 * Date        : 12/09/2014
	 * Author      : Renushree
	**********************************************************************************/
	public ResourceType verActionHeader() throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table[2]/thead/tr/th[1][text()='Action']",
				"xpath");
		assertTrue(this.page
				.element(
						"//div[@id='mainContainer']/table[2]/thead/tr/th[1][text()='Action']",
						"xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to verify status type listed
	   * Date        : 26/09/2014
	   * Author      : Anitha
	   **********************************************************************************/
	public ResourceType verifyStatusTypeIsListed(String[] strStatusTypeValues)
			throws Exception {
		objWaitForElement.waitForElements("//input[@value='" + strStatusTypeValues[0]
				+ "'][@name='statusTypeID']", "xpath");
		for (int i = 0; i < strStatusTypeValues.length; i++) {
			assertTrue(this.page
					.dynamicElement(
							"StatusTypeValues",
							"//input[@value='" + strStatusTypeValues[i]
									+ "'][@name='statusTypeID']", "xpath")
					.getOne().isDisplayed());
		}
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to verify status type listed
	   * Date        : 26/09/2014
	   * Author      : Anitha
	   **********************************************************************************/
	public ResourceType verifyStatusTypeNameIsListed(String strStatusTypenames)
			throws Exception {
		objWaitForElement.waitForElements(
						"//div[@class='selectorData']/table/tbody/tr/td[2]/a"
						+ "[contains(text(),'"+strStatusTypenames+"')]",
						"xpath");
		assertTrue(this.page.element(
						"//div[@class='selectorData']/table/tbody/tr/td[2"
						+ "]/a[contains(text(),'"+strStatusTypenames+"')]","xpath").isElementPresent());

		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to click statustypes
	   * Date        : 11/06/2014
	   * Author      : Anitha
	   **********************************************************************************/
	public ResourceType clickStatusTypeNew(String[] strStatusTypeValues)
			throws Exception {
		objWaitForElement.waitForElements("//input[@value='" + strStatusTypeValues[0]
				+ "'][@name='statusTypeID']", "xpath");
		for (int i = 0; i < strStatusTypeValues.length; i++) {
			this.page.element(
					"//input[@value='" + strStatusTypeValues[i]
							+ "'][@name='statusTypeID']", "xpath").mouseOver();
			this.page
					.element(
							"//input[@value='" + strStatusTypeValues[i]
									+ "'][@name='statusTypeID']", "xpath")
					.getOne().sendKeys(Keys.SPACE);
		}
		return this;
	}

	/**********************************************************************************
	   * Description : This function is to click on Search button in Create New Resource Type page
	   * Date        : 31-Dec-2014
	   * Author      : Pallavi
	   **********************************************************************************/
	public ResourceType clickOnSearchButton() throws Exception {
		objWaitForElement.waitForElements(searchButton, "css");
		this.page.element(searchButton, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to verify status type is retrieved.
	   * Date        : 31-Dec-2014
	   * Author      : Pallavi
	   **********************************************************************************/
	public ResourceType verifyStatusTypeIsRetrieved(String strStatusTypeName,
			String strStatusType) throws Exception {
		objWaitForElement.waitForElements("//div[@class='selectorData']//tr/td/a[contains(text(),'"
				+ strStatusTypeName
				+ "')]/parent::td/following-sibling::td[text()='"
				+ strStatusType + "']", "xpath");
		assertTrue(this.page.element(
				"//div[@class='selectorData']//tr/td/a[contains(text(),'"
						+ strStatusTypeName
						+ "')]/parent::td/following-sibling::td[text()='"
						+ strStatusType + "']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Resource Type list page is displayed
	  * Date        : 28/05/2014
	  * Author      : Anitha
	  **********************************************************************************/
	public ResourceType verResourceTypeListPageIsDisplayed() throws Exception {
		objWaitForElement.waitForElements("//div[@id='topSubNav']/h1[text()='Resource Type List']", "xpath");
		assertEquals("Resource Type List", this.page.element(headerName, "css").getOne().getText(),
				"Resource Type List page is not displayed.");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify edit Resource Type list page is displayed
	  * Date        : 28/05/2014
	  * Author      : Anitha
	  **********************************************************************************/
	public ResourceType verEditResourceTypeListPageIsDisplayed() throws Exception {
		objWaitForElement.waitForElements("//div[@id='topSubNav']/h1[text()='Edit Resource Type']", "xpath");
		assertEquals("Edit Resource Type", this.page.element(headerName, "css").getOne().getText(),
				"Edit Resource Type page is not displayed.");
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to deselect resource type active checkbox
	   * Date        : 31-Dec-2014
	   * Author      : Anil
	   **********************************************************************************/
	public ResourceType deselectActiveCheckBox() throws Exception {
		objWaitForElement.waitForElements(activeCheckBox, "xpath");
		if(this.page.element(activeCheckBox, "xpath").getOne().isSelected()==true){
			this.page.element(activeCheckBox, "xpath").getOne().click();
		}		
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify resource type in list
	 * Date        : 06/08/2014
	 * Author      : Anitha
	**********************************************************************************/
	public ResourceType verResourceTypeNotInList(String strResourceType)
			throws Exception {
		assertFalse(this.page
				.element(
						"//div[@id='mainContainer']/table[2]/thead/tr/th[2]/a[text()='Name']/ancestor::table/tbody/tr/td[2][text()='"
								+ strResourceType + "']", "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	/**********************************************************************************
	   * Description : This function is to deselect resource type active checkbox
	   * Date        : 31-Dec-2014
	   * Author      : Anil
	   **********************************************************************************/
	public ResourceType selectActiveCheckBox() throws Exception {
		objWaitForElement.waitForElements(activeCheckBox, "xpath");
		if(this.page.element(activeCheckBox, "xpath").getOne().isSelected()==false){
			this.page.element(activeCheckBox, "xpath").getOne().click();
		}		
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to deselect resource type active checkbox
	   * Date        : 31-Dec-2014
	   * Author      : Anil
	   **********************************************************************************/
	public ResourceType selectIncludeInActiveCheckBox() throws Exception {
		objWaitForElement.waitForElements(inactiveCheckBox, "xpath");
		if(this.page.element(inactiveCheckBox, "xpath").getOne().isSelected()==false){
			this.page.element(inactiveCheckBox, "xpath").getOne().click();
		}		
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to deselect resource type active checkbox
	   * Date        : 31-Dec-2014
	   * Author      : Anil
	   **********************************************************************************/
	public ResourceType deselectIncludeInActiveCheckBox() throws Exception {
		objWaitForElement.waitForElements(inactiveCheckBox, "xpath");
		if(this.page.element(inactiveCheckBox, "xpath").getOne().isSelected()==true){
			this.page.element(inactiveCheckBox, "xpath").getOne().click();
		}		
		return this;
	}
	
	  /**********************************************************************************
	   * Description : This function is to verify resourceType button is present
	   * Date        : 05/08/2015
	   * Author      : Sowmya
	   **********************************************************************************/
	public ResourceType verCreateNewResourceTypeButtonIsPresent()
			throws Exception {
		objWaitForElement.waitForElements(createNewResourceType, "xpath");
		assertTrue(this.page.element(createNewResourceType, "xpath")
				.isElementPresent());
		return this;
	}
	
	  /**********************************************************************************
	   * Description : This function is to verify 'ResourceType Name' input field
	   * Date        : 05/08/2015
	   * Author      : Sowmya
	   **********************************************************************************/
	public ResourceType verResourceTypeNameInputField() throws Exception {
		objWaitForElement.waitForElements(resourceTypeName, "name");
		assertTrue(this.page.element(resourceTypeName, "name")
				.isElementPresent());
		return this;
	}

	  /**********************************************************************************
	   * Description : This function is to verify 'ResourceType Description' input field
	   * Date        : 05/08/2015
	   * Author      : Sowmya
	   **********************************************************************************/
	public ResourceType verResourceTypeDescriptionInputField() throws Exception {
		objWaitForElement.waitForElements(resourceTypeDescription, "name");
		assertTrue(this.page.element(resourceTypeDescription, "name")
				.isElementPresent());
		return this;
	}
	
	/*****************************************************************************************
	   * Description : This function is to verify 'Resource type active checkbox' is checked
	   * Date        : 05/08/2015
	   * Author      : Sowmya
	   **************************************************************************************/
	public ResourceType verActiveCheckBoxIsChecked() throws Exception {
		objWaitForElement.waitForElements(activeCheckBox, "xpath");
		assertTrue((this.page.element(activeCheckBox, "xpath").getOne()
				.isSelected() == true));
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to verify 'SubResourceType CheckBox' is present
	   * Date        : 05/08/2015
	   * Author      : Sowmya
	   **********************************************************************************/
	public ResourceType verSubResourceTypeCheckBox() throws Exception {
		objWaitForElement.waitForElements(subResourceTypeButton, "css");
		assertTrue(this.page.element(subResourceTypeButton, "css")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to verify statustype field
	   * Date        : 05/08/2015
	   * Author      : Sowmya
	   **********************************************************************************/
	public ResourceType verStatusTypeField(String strStatusTypeValues)
			throws Exception {
		objWaitForElement.waitForElements("//input[@value='"
				+ strStatusTypeValues + "'][@name='statusTypeID']", "xpath");
		assertTrue(this.page.element(selectAllStatusCheckbox, "xpath")
				.isElementPresent());
		assertTrue(this.page.element(statusTypeField, "xpath")
				.isElementPresent());
		assertTrue(this.page.element(
				"//input[@value='" + strStatusTypeValues
						+ "'][@name='statusTypeID']", "xpath")
				.isElementPresent());
		return this;

	}
	
	/**********************************************************************************
	   * Description : This function is to verify 'Default status type' dropdown is present
	   * Date        : 05/08/2015
	   * Author      : Sowmya
	   **********************************************************************************/
	public ResourceType verDefaultStatusTypeDropdown() throws Exception {
		objWaitForElement.waitForElements(defaultStatusTypeDropdown, "xpath");
		assertTrue(this.page.element(defaultStatusTypeDropdown, "xpath")
				.isElementPresent());
		return this;
	}
	
	/************************************************************************************
	   * Description : This function is to verify 'Resource Type Name' checkbox is checked
	   * Date        : 05/08/2015
	   * Author      : Sowmya
	   **********************************************************************************/
	public ResourceType verResourceTypeNameCheckboxIsChecked() throws Exception {
		objWaitForElement.waitForElements(resourceTypeNameCheckbox, "xpath");
		assertTrue(this.page.element(resourceTypeNameCheckbox, "xpath")
				.getOne().isSelected() == true);
		return this;
	}
	
	/************************************************************************************
	   * Description : This function is to verify 'Contact Name' checkbox is checked
	   * Date        : 05/08/2015
	   * Author      : Sowmya
	   **********************************************************************************/
	public ResourceType verContactNameCheckboxIsChecked() throws Exception {
		objWaitForElement.waitForElements(contactNameCheckbox, "xpath");
		assertTrue(this.page.element(contactNameCheckbox, "xpath").getOne()
				.isSelected() == true);
		return this;
	}
	
	/************************************************************************************
	   * Description : This function is to verify 'Contact Title' checkbox is checked
	   * Date        : 05/08/2015
	   * Author      : Sowmya
	   **********************************************************************************/
	public ResourceType verContactTitleCheckboxIsChecked() throws Exception {
		objWaitForElement.waitForElements(contactTitleCheckbox, "xpath");
		assertTrue(this.page.element(contactTitleCheckbox, "xpath").getOne()
				.isSelected() == true);
		return this;
	}
	
	/************************************************************************************
	   * Description : This function is to verify 'Phone1' checkbox is checked
	   * Date        : 05/08/2015
	   * Author      : Sowmya
	   **********************************************************************************/
	public ResourceType verPhone1CheckboxIsChecked() throws Exception {
		objWaitForElement.waitForElements(phone1Checkbox, "xpath");
		assertTrue(this.page.element(phone1Checkbox, "xpath").getOne()
				.isSelected() == true);
		return this;
	}
	
	/************************************************************************************
	   * Description : This function is to verify 'Phone2' checkbox is checked
	   * Date        : 05/08/2015
	   * Author      : Sowmya
	   **********************************************************************************/
	public ResourceType verPhone2CheckboxIsChecked() throws Exception {
		objWaitForElement.waitForElements(phone2Checkbox, "xpath");
		assertTrue(this.page.element(phone2Checkbox, "xpath").getOne()
				.isSelected() == true);
		return this;
	}
	
	/************************************************************************************
	   * Description : This function is to verify 'Fax' checkbox is checked
	   * Date        : 05/08/2015
	   * Author      : Sowmya
	   **********************************************************************************/
	public ResourceType verFaxCheckboxIsChecked() throws Exception {
		objWaitForElement.waitForElements(faxCheckbox, "xpath");
		assertTrue(this.page.element(faxCheckbox, "xpath").getOne()
				.isSelected() == true);
		return this;
	}
	
	/************************************************************************************
	   * Description : This function is to verify 'Email' checkbox is checked
	   * Date        : 05/08/2015
	   * Author      : Sowmya
	   **********************************************************************************/
	public ResourceType verEmailCheckboxIsChecked() throws Exception {
		objWaitForElement.waitForElements(emailCheckbox, "xpath");
		assertTrue(this.page.element(emailCheckbox, "xpath").getOne()
				.isSelected() == true);
		return this;
	}
	
	/*****************************************************************************************
	  * Description : This function is to verify 'Create New Resource Type' page is displayed
	  * Date        : 05/08/2015
	  * Author      : Sowmya
	  *****************************************************************************************/
	public ResourceType verCreateNewResourceTypePageIsDisplayed()
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='topSubNav']/h1[text()='Create New Resource Type']", "xpath");
		assertEquals("Create New Resource Type",
				this.page.element(headerName, "css").getOne().getText(),
				"Create New Resource Type page is not displayed.");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Name in header
	 * Date        : 05/08/2015
	 * Author      : Sowmya
	**********************************************************************************/
	public ResourceType verNameHeader() throws Exception {
		objWaitForElement.waitForElements(nameInHeader, "xpath");
		assertTrue(this.page.element(nameInHeader, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Sub-Resource in header
	 * Date        : 05/08/2015
	 * Author      : Sowmya
	**********************************************************************************/
	public ResourceType verSubResourceHeader() throws Exception {
		objWaitForElement.waitForElements(subResourceInHeader, "xpath");
		assertTrue(this.page.element(subResourceInHeader, "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Active in header
	 * Date        : 05/08/2015
	 * Author      : Sowmya
	**********************************************************************************/
	public ResourceType verActiveHeader() throws Exception {
		objWaitForElement.waitForElements(activeInHeader, "xpath");
		assertTrue(this.page.element(activeInHeader, "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Description in header
	 * Date        : 05/08/2015
	 * Author      : Sowmya
	**********************************************************************************/
	public ResourceType verDescriptionHeader() throws Exception {
		objWaitForElement.waitForElements(descriptionInHeader, "xpath");
		assertTrue(this.page.element(descriptionInHeader, "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify'Edit' link of resource type
	 * Date        : 19/06/2014
	 * Author      : Anil
	 **********************************************************************************/
	public ResourceType verifyEditLinkOfResourceType(String strResourceTypeName)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table[@class='displayTable "
				+ "striped border sortable']/tbody/tr/td[2][text()='"
				+ strResourceTypeName + "']/"
				+ "parent::tr/td[1]/a[text()='Edit']", "xpath");
		assertTrue(this.page.element("//div[@id='mainContainer']/table[@class='displayTable "
				+ "striped border sortable']/tbody/tr/td[2][text()='"
				+ strResourceTypeName + "']/"
				+ "parent::tr/td[1]/a[text()='Edit']", "xpath")
				.getOne().isDisplayed());
		return this;
	}
	
	
	/**********************************************************************************
	   * Description : This function is to verify 'SubResourceType CheckBox' is deselected
	   * Date        : 05/08/2015
	   * Author      : Anil
	   **********************************************************************************/
	public ResourceType verSubResourceTypeCheckBoxIsDeselected() throws Exception {
		objWaitForElement.waitForElements(subResourceTypeButton, "css");
		assertTrue(this.page.element(subResourceTypeButton, "css")
				.getOne().isSelected()==false);
		return this;
	}
	
	  /**********************************************************************************
	   * Description : This function is to verify resourceType Name is retained
	   * Date        : 11/06/2014
	   * Author      : Anil
	   **********************************************************************************/
	public ResourceType verifyResourceTypeNameIsRetained(String strResourceTypeName)
			throws Exception {
		objWaitForElement.waitForElements(resourceTypeName, "name");
		String strValue = this.page.element(resourceTypeName, "name").getOne().getAttribute("value");
		assertEquals(strValue, strResourceTypeName);
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to click statustypes
	   * Date        : 11/06/2014
	   * Author      : Anil
	   **********************************************************************************/
	public ResourceType verifyStatusTypeIsSelected(String[] strStatusTypeValues)
			throws Exception {
		for (int i = 0; i < strStatusTypeValues.length; i++) {
			objWaitForElement.waitForElements("//input[@value='"
					+ strStatusTypeValues[i] + "'][@name='statusTypeID']",
					"xpath");

			assertTrue(this.page
					.dynamicElement(
							"StatusTypeValues",
							"//input[@value='" + strStatusTypeValues[i]
									+ "'][@name='statusTypeID']", "xpath")
					.getOne().isSelected());
		}
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to verify 'SubResourceType CheckBox' is deselected
	   * Date        : 27/Aug/2015
	   * Author      : Renushree
	   **********************************************************************************/
	public ResourceType verErrWhenEventRelatedSTIsSelectedForSubRT(
			String strStatusType) throws Exception {
		objWaitForElement.waitForElements(errorTitle, "xpath");
		assertEquals("The following error occurred on this page:", this.page
				.element(errorTitle, "xpath").getOne().getText());
		assertEquals("Sub-Resource Types may not use Event only Status Types ("
				+ strStatusType + ")", this.page.element(errorMsg1, "xpath")
				.getOne().getText());
		return this;
	}
	

	/**********************************************************************************
	   * Description : This function is to verify 'SubResourceType CheckBox' is selected
	   * Date        : 05/08/2015
	   * Author      : Anil
	   **********************************************************************************/
	public ResourceType verSubResourceTypeCheckBoxIsSelected() throws Exception {
		objWaitForElement.waitForElements(subResourceTypeButton, "css");
		assertTrue(this.page.element(subResourceTypeButton, "css")
				.getOne().isSelected());
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to deSelect SubResourceType CheckBox
	   * Date        : 12/09/2014
	   * Author      : Anil
	   **********************************************************************************/
	public ResourceType deselectSubResourceTypeCheckBox() throws Exception {
		objWaitForElement.waitForElements(subResourceTypeButton, "css");
		if(this.page.element(subResourceTypeButton, "css").getOne().isSelected()==true){
		this.page.element(subResourceTypeButton, "css").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to select defaultStatusType from the dropdown
	   * Date        : 12/09/2014
	   * Author      : Anil
	   **********************************************************************************/
	public ResourceType selectDefaultStatusType(String strStatusTypeName) throws Exception {
		objWaitForElement.waitForElements(defaultStatusTypeID, "xpath");
		this.page.element(defaultStatusTypeID, "xpath").webElementToSelect().selectByVisibleText(strStatusTypeName);
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to click on cancel button
	   * Date        : 12/09/2014
	   * Author      : Anil
	   **********************************************************************************/
	public ResourceType clickOnCancelButton() throws Exception {
		objWaitForElement.waitForElements(cancelButton, "css");
		this.page.element(cancelButton, "css").getOne().click();
		return this;
	}
	
	 /**********************************************************************************
	    * Description : This function is to verify status types are not selected for a RT
	    * Date        : 15-Feb-2016
	    * Author      : Pallavi
	    **********************************************************************************/
	public ResourceType verifyStatusTypeIsNotSelected(
			String[] strStatusTypeValues) throws Exception {
		for (int i = 0; i < strStatusTypeValues.length; i++) {
			String strElement = "//input[@value='" + strStatusTypeValues[i]
					+ "'][@name='statusTypeID']";
			objWaitForElement.waitForElements(strElement, "xpath");
			assertFalse(this.page.element(strElement, "xpath").getOne()
					.isSelected());
		}
		return this;
	}
	 
   /**********************************************************************************
    * Description : This function is to verify RT is not present in RT List Screen
    * Date        : 15-Feb-2016
    * Author      : Pallavi
    **********************************************************************************/
	public ResourceType verRTIsNotDisplayed(String strResTypeName)
			throws Exception {
		String strRTElement = "//div[@id='mainContainer']/table[@class='displayTable "
				+ "striped border sortable']/tbody/tr/td[2][text()='"
				+ strResTypeName + "']";
		objWaitForElement.waitForElements(strRTElement, "xpath");
		assertFalse(this.page.element(strRTElement, "xpath").isElementPresent(
				WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	

	/**********************************************************************************
	   * Description : This function is to verify error when resource type is cretaed without selecting status type
	   * Date        : 15/Feb/2016
	   * Author      : Renushree
	   **********************************************************************************/
	public ResourceType verErrWhenRTCreatedWithoutST() throws Exception {
		objWaitForElement.waitForElements(errorTitle, "xpath");
		assertEquals("The following error occurred on this page:", this.page
				.element(errorTitle, "xpath").getOne().getText());
		assertEquals("At least one status types must be selected when "
				+ "\"active\"" + " is checked.",
				this.page.element(errorMsg1, "xpath").getOne().getText());
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to verify 'More than one multi status type with the 
	   *                same standard status type may not be selected for a single resource type.'
	   *                error
	   * Date        : 1-Mar-2016
	   * Author      : Sangappa k
	   **********************************************************************************/
	public ResourceType verErrWhenRTCreatedWithSameStanderedSType() throws Exception {
		objWaitForElement.waitForElements(errorTitle, "xpath");
		assertEquals("The following error occurred on this page:", this.page
				.element(errorTitle, "xpath").getOne().getText());
		assertEquals(
				"More than one multi status type with the same standard status type may not be selected for a single resource type.",
				this.page.element(errorMsg1, "xpath").getOne().getText());
		return this;
	}
	
	
	
}