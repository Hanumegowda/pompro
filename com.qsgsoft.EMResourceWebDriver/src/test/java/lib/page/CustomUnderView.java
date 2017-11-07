package lib.page;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import qaframework.lib.WaitTimeConstants;
import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;

public class CustomUnderView extends PageObject {

	WebDriver driver;
	WaitForElement objWaitForElement;

	private String addMoreResources = "input[value='Add More Resources']",
			searchResourceField = "searchName",
			search = "input[value='Search']",
			addToCustomView = "input[value='Add to Custom View']",
			options = "input[value='Options...']",
			displayCommentsChkBox = "showComments",
			displayLastUpdatedTime = "showUpdateTime",
			displayLastUpdatedUser = "showUpdateUser",
			showSummary = "showTotals", save = "input[value='Save']",
			createdStatuaTypesInList = "//div[@id='itemBox']/ul/li/div",
			promote = "//div[@id='link_promote']/a",
			headerName = "div#topSubNav > h1",
			customName = "input[name=viewName]",
			customViewMapLink = "//div[@id='link_show map']/a",
			resourceFinder = "resourceFinder",
			cancel = "input[value='Cancel']",
			findResourcesPage = "//div[@id='topSubNav']/h1[text()='Find Resources']",
			noCustomViewPage = "//div[@id='viewContainer']/h1[text()='No Custom View']",
			sortAll = "input[value='Sort All']",
			errorMsg = "//span[@class='emsErrorTitle']",
			errorMsg1 = "//div[@class='emsError']/ul/li";
					

	public CustomUnderView(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
	}

	/*************************************************************************
	 * Description 	: This function is to click on setup your custom view link 
	 * Date 		: 12/08/2014  
	 * Author 		: Renushree
	 *************************************************************************/
	public CustomUnderView clickOnSetupCustomViewLink() throws Exception {
		objWaitForElement.waitForElements(
				"Click here to setup your custom view", "linktext");
		this.page.element("Click here to setup your custom view", "linktext")
				.getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description 	: This function is to click on add more resources button
	 * Date 		: 12/08/2014  
	 * Author 		: Renushree
	 **********************************************************************************/
	public CustomUnderView clickOnAddMoreResources() throws Exception {
		objWaitForElement.waitForElements(addMoreResources, "css");
		this.page.element(addMoreResources, "css").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description 	: This function is to enter resource name to search.
	 * Arguments	: strResource
	 * Date 		: 12/08/2014  
	 * Author 		: Renushree
	 **********************************************************************************/
	public CustomUnderView enterResNameInWhatField(String strResource)
			throws Exception {
		objWaitForElement.waitForElements(searchResourceField, "id");
		this.page.element(searchResourceField, "id").clearInputValue()
				.sendKeys(strResource);
		return this;
	}

	/**********************************************************************************
	 * Description 	: This function is to click on search button
	 * Date 		: 12/08/2014  
	 * Author 		: Renushree
	 **********************************************************************************/
	public CustomUnderView clickOnSearch() throws Exception {
		objWaitForElement.waitForElements(search, "css");
		this.page.element(search, "css").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description 	: This function is to select resources.
	 * Arguments	: strResourceVal
	 * Date 		: 12/08/2014  
	 * Author 		: Renushree
	 **********************************************************************************/
	public CustomUnderView selectResource(String[] strResourceVal)
			throws Exception {
		for (int i = 0; i < strResourceVal.length; i++) {
			objWaitForElement.waitForElements(
					"//table[@id='tbl_resourceID']/tbody/tr/td/input[@value='"
							+ strResourceVal[i] + "']", "xpath");
			this.page
					.element(
							"//table[@id='tbl_resourceID']/tbody/tr/td/input[@value='"
									+ strResourceVal[i] + "']", "xpath")
					.getOne().click();
		}
		return this;
	}

	/**********************************************************************************
	 * Description 	: This function is to click on add to custom vieew button
	 * Date 		: 12/08/2014  
	 * Author 		: Renushree
	 **********************************************************************************/
	public CustomUnderView clickOnAddToCustomView() throws Exception {
		objWaitForElement.waitForElements(addToCustomView, "css");
		this.page.element(addToCustomView, "css").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description 	: This function is to click on options button
	 * Date 		: 12/08/2014  
	 * Author 		: Renushree
	 **********************************************************************************/
	public CustomUnderView clickOnOptions() throws Exception {
		objWaitForElement.waitForElements(options, "css");
		this.page.element(options, "css").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description 	: This function is to click on all checkboxes in options.
	 * Date 		: 12/08/2014  
	 * Author 		: Renushree
	 **********************************************************************************/
	public CustomUnderView selectAllChkBoxInOptions() throws Exception {
		objWaitForElement.waitForElements(displayCommentsChkBox, "name");
		this.page.element(displayCommentsChkBox, "name").getOne().click();
		this.page.element(displayLastUpdatedTime, "name").getOne().click();
		this.page.element(displayLastUpdatedUser, "name").getOne().click();
		this.page.element(showSummary, "name").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description 	: This function is to select status types
	 * Date 		: 12/08/2014  
	 * Author 		: Renushree
	 **********************************************************************************/
	public CustomUnderView selectStatusTypes(String[] strStatusTypesVal)
			throws Exception {
		for (int i = 0; i < strStatusTypesVal.length; i++) {
			objWaitForElement.waitForElements("//input[@value='st_"
					+ strStatusTypesVal[i] + "']", "xpath");
			this.page
					.element(
							"//input[@value='st_" + strStatusTypesVal[i] + "']",
							"xpath").getOne().click();
		}
		return this;
	}

	/**********************************************************************************
	 * Description 	: This function is to click on save button
	 * Date 		: 12/08/2014  
	 * Author 		: Renushree
	 **********************************************************************************/
	public CustomUnderView clickOnSave() throws Exception {
		objWaitForElement.waitForElements(save, "css");
		this.page.element(save, "css").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description 	: This function is to click on promote link
	 * Date 		: 12/08/2014  
	 * Author 		: Renushree
	 **********************************************************************************/
	public CustomUnderView clickOnPromote() throws Exception {
		objWaitForElement.waitForElements(promote, "xpath");
		this.page.element(promote, "xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description 	: This function is to verify edit custom view screen is displayed.
	 * Date 		: 09/09/2014  
	 * Author 		: Renushree
	 **********************************************************************************/
	public CustomUnderView verEditCustomViewScreenIsDisplayed()
			throws Exception {
		objWaitForElement
				.waitForElements(
						"//div[@id='topSubNav']/h1[text()='Edit Custom View']",
						"xpath");
		assertEquals("Edit Custom View", this.page.element(headerName, "css")
				.getOne().getText());
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to verify created status types in list
	  * Arguments	: strSectionName
	  * Date        : 09/09/2014  
	  * Author 		: Renushree
	 **********************************************************************************/
	public CustomUnderView verCreatedSection(String strSectionName)
			throws Exception {
		objWaitForElement.waitForElements(
				"//ul[@id='groups']/li/div/span[contains(text(),'"
						+ strSectionName + "')]", "xpath");
		assertTrue(
				this.page.element(
						"//ul[@id='groups']/li/div/span[contains(text(),'"
								+ strSectionName + "')]", "xpath")
						.isElementPresent(),
				"Created section is not displayed.");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify resource names in list
	  * Arguments	: strResourceNames
	  * Date        : 09/09/2014  
	  * Author 		: Renushree
	  **********************************************************************************/
	public CustomUnderView verResourceNamesInList(String[] strResourceNames,
			String strRegion, String strResourceType) throws Exception {
		for (int i = 0; i < strResourceNames.length; i++) {
			objWaitForElement.waitForElements(createdStatuaTypesInList
					+ "[text()='" + strResourceNames[i] + " [" + strResourceType
					+ " - " + strRegion + "]']", "xpath");
			assertTrue(
					this.page.element(
							createdStatuaTypesInList + "[text()='"
									+ strResourceNames[i] + " ["
									+ strResourceType + " - " + strRegion
									+ "]']", "xpath").isElementPresent(),
					"Resources not displayed.");
		}
		return this;
	}

	/***************************************************************************************************
	  * Description : This function is to verify resources and resource types in custom view table page.
	  * Arguments	: strResourceNames, strResourceType
	  * Date        : 10/09/2014  
	  * Author 		: Renushree
	  **************************************************************************************************/
	public CustomUnderView verResourceAndResTypeInCustomViewTablePage(
			String[] strResourceNames, String strResourceType) throws Exception {
		for (int i = 0; i < strResourceNames.length; i++) {
			objWaitForElement
			.waitForElements(
					"//td[@class='resourceName']/a[text()='"
							+ strResourceNames[i]
							+ "']/ancestor::tbody/ancestor::table/thead/tr/th[2][text()='"
							+ strResourceType + "']", "xpath");
			assertTrue(
					this.page
							.element(
									"//td[@class='resourceName']/a[text()='"
											+ strResourceNames[i]
											+ "']/ancestor::tbody/ancestor::table/thead/tr/th[2][text()='"
											+ strResourceType + "']", "xpath")
							.isElementPresent(), "Resources not displayed.");
		}
		return this;
	}
	
	/******************************************************************************************
	  * Description : This function is to verify resource type names in custom view table page.
	  * Arguments	: strstatusTypeNames
	  * Date        : 10/09/2014  
	  * Author 		: Renushree
	  *****************************************************************************************/
	public CustomUnderView verStatusTypeInCustomViewTablePage(
			String[] strStatusTypeNames) throws Exception {
		for (int i = 0; i < strStatusTypeNames.length; i++) {
			objWaitForElement.waitForElements("//a[text()='"
					+ strStatusTypeNames[i] + "']", "xpath");
			assertTrue(
					this.page.element(
							"//a[text()='" + strStatusTypeNames[i] + "']",
							"xpath").isElementPresent(),
					"Status types not displayed.");
		}
		return this;
	}

	/******************************************************************************************
	  * Description : This function is to verify resource type names in custom view table page.
	  * Arguments	: strstatusTypeNames
	  * Date        : 10/09/2014  
	  * Author 		: Renushree
	  *****************************************************************************************/
	public CustomUnderView selResourceInCustomViewTablePage(
			String strResourceName) throws Exception {
		objWaitForElement.waitForElements("//a[text()='" + strResourceName
				+ "']", "xpath");
		this.page.element("//a[text()='" + strResourceName + "']", "xpath")
				.getOne().click();
		return this;
	}

	/******************************************************************************************
	  * Description : This function is to verify resource type names in custom view table page.
	  * Arguments	: strstatusTypeNames
	  * Date        : 10/09/2014  
	  * Author 		: Renushree
	  *****************************************************************************************/
	public CustomUnderView enterCustomViewDetails(String strCustomName)
			throws Exception {
		objWaitForElement.waitForElements(customName, "css");
		this.page.element(customName, "css").clearInputValue()
				.sendKeys(strCustomName);
		return this;
	}

	/*************************************************************************
	 * Description 	: This function is to click on custom view Map link
	 * Date 		: 03/12/2014  
	 * Author 		: Anil
	 *************************************************************************/
	public CustomUnderView clickOnCustomeViewMap() throws Exception {
		objWaitForElement.waitForElements(customViewMapLink, "xpath");
		this.page.element(customViewMapLink, "xpath").getOne().click();
		return this;
	}

	/*************************************************************************
	 * Description 	: This function is to verify Status Type under Status Type Summary table
	 * Date 		: 25-May-2015  
	 * Author 		: Pallavi
	 *************************************************************************/
	public CustomUnderView verifySTUnderSTSummarySection(
			String strStatusTypeName) throws Exception {
		String strST = "//td[text()='" + strStatusTypeName + "']";
		objWaitForElement.waitForElements(strST, "xpath");
		assertTrue(this.page.element(strST, "xpath").isElementPresent());
		return this;
	}
	
	/*************************************************************************
	 * Description 	: This function is to verify Status Type under Edit Custom 
	 * 				  View Options (Columns) page
	 * Date 		: 25-May-2015  
	 * Author 		: Pallavi
	 *************************************************************************/
	public CustomUnderView verifySTAndSecAreDispUnderEdtCustomViewPage(
			String strSectionName, String strStatusTypeName) throws Exception {
		String strST = "//span[text()='" + strSectionName
				+ "']/parent::div/input/following-sibling::b[text()='"
				+ strStatusTypeName + "']";
		objWaitForElement.waitForElements(strST, "xpath");
		assertTrue(this.page.element(strST, "xpath").isElementPresent());
		return this;
	}
	
	/******************************************************************************************
	  * Description : This function is to verify ststau type not in custom view table page.
	  * Arguments	: strstatusTypeNames
	  * Date        : 28/May/2015  
	  * Author 		: Renushree
	  *****************************************************************************************/
	public CustomUnderView verStatusTypeNotInCustomViewTablePage(
			String strStatusTypeNames) throws Exception {
		assertFalse(
				this.page.element("//a[text()='" + strStatusTypeNames + "']",
						"xpath").isElementPresent(
						WaitTimeConstants.WAIT_TIME_FOR_FALSE),
				"Status types not displayed.");
		return this;
	}
	/**********************************************************************************
	  * Description : This function is to verify created status types in list
	  * Arguments	: strSectionName
	  * Date        : 09/09/2014  
	  * Author 		: Anitha
	 **********************************************************************************/
	public CustomUnderView verErrorMessgaeForResource()
			throws Exception {
		objWaitForElement.waitForElements(
				"//h2[text()='No resources match your criteria...']", "xpath");
		assertTrue(this.page.element(
				"//h2[text()='No resources match your criteria...']", "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify the updated value of ststua types.
	  * Arguments	: strResourceValue, strStatusTypeValue, strUpdatedValue
	  * Date        : 29/May/2015
	  * Author      : Renushree
	  **********************************************************************************/	
	public CustomUnderView verifyUpdatedStatusValues(String strResourceValue,
			String strStatusTypeValue, String strUpdatedValue) throws Exception {
		objWaitForElement.waitForElements("//td[@id='v_" + strResourceValue + "_"
				+ strStatusTypeValue + "'][text()='"
				+ strUpdatedValue + "']", "xpath");
		assertTrue(
				this.page.element(
						"//td[@id='v_" + strResourceValue + "_"
								+ strStatusTypeValue + "'][text()='"
								+ strUpdatedValue + "']", "xpath")
						.isElementPresent(), "Updated values are not displayed");
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify edit custom view options column is displayed.
	 * Date 		: 15/Jun/2015  
	 * Author 		: Renushree
	 **********************************************************************************/
	public CustomUnderView verEditCustomViewOptionsColumnIsDisplayed()
			throws Exception {
		objWaitForElement
				.waitForElements(
						"//div[@id='topSubNav']/h1[text()='Edit Custom View Options (Columns)']",
						"xpath");
		assertEquals("Edit Custom View Options (Columns)", this.page.element(headerName, "css")
				.getOne().getText());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select resource name
	  * Date        : 09/06/2014
	  * Author      : Anil
	  **********************************************************************************/
	public CustomUnderView selectResourceName(String strResourceName) throws Exception {
		objWaitForElement.waitForElements(resourceFinder, "id");
		this.page.element(resourceFinder, "id").webElementToSelect().selectByVisibleText(strResourceName);
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify Custom View - Map screen is displayed.
	 * Date 		: 09/09/2014  
	 * Author 		: Anil
	 **********************************************************************************/
	public CustomUnderView verCustomViewMapScreenIsDisplayed()
			throws Exception {
		objWaitForElement
				.waitForElements(
						"//div[@id='topSubNav']/h1[text()='Custom View - Map']",
						"xpath");
		assertEquals("Custom View - Map", this.page.element(headerName, "css")
				.getOne().getText());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify resource names in list
	  * Arguments	: strResourceNames
	  * Date        : 09/09/2014  
	  * Author 		: Renushree
	  **********************************************************************************/
	public CustomUnderView verResourceNamesNotInList(String strResourceNames,
			String strRegion, String strResourceType) throws Exception {
		assertFalse(
				this.page
						.element(
								createdStatuaTypesInList + "[text()='"
										+ strResourceNames + " ["
										+ strResourceType + " - " + strRegion
										+ "]']", "xpath")
						.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE),
				"Resources is displayed.");
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to click on cancel link
	 * Date 		: 12/08/2014  
	 * Author 		: Renushree
	 **********************************************************************************/
	public CustomUnderView clickOnCancel() throws Exception {
		objWaitForElement.waitForElements(cancel, "css");
		this.page.element(cancel, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify ST not displayed in option section
	 * Date 		: 02/Jul/2015  
	 * Author 		: Renushree
	 **********************************************************************************/
	public CustomUnderView verSTNotDisplayedInOptions(String[] strStatusTypesVal)
			throws Exception {
		for (int i = 0; i < strStatusTypesVal.length; i++) {
			assertFalse(
					this.page
							.element(
									"//input[@value='st_"
											+ strStatusTypesVal[i] + "']",
									"xpath").isElementPresent(
									WaitTimeConstants.WAIT_TIME_FOR_FALSE),
					"ST is displayed");
		}
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to verify Status type names in popup window
	   * Date        : 07/08/2014
	   * Author      : Anil
	   **********************************************************************************/
	public CustomUnderView verStatusTypesInPopupWindow(String[] strStatusTypeName)
			throws Exception {
		objWaitForElement.waitForElements("//div[text()='"+strStatusTypeName[0]+":']", "xpath");

		for (int i = 0; i < strStatusTypeName.length; i++) {
			assertTrue(this.page.element("//div[contains(text(),'"+strStatusTypeName[i]+"')]", "xpath").getOne().isDisplayed());
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify ST  displayed in option section
	 * Date 		: 14/Jul/2015  
	 * Author 		: Renushree
	 **********************************************************************************/
	public CustomUnderView verSTDisplayedAndCheckedInOptions(String[] strStatusTypesVal)
			throws Exception {
		for (int i = 0; i < strStatusTypesVal.length; i++) {
			assertTrue(
					this.page
							.element(
									"//input[@value='st_"
											+ strStatusTypesVal[i] + "'][@checked='checked']",
									"xpath").isElementPresent(),
					"ST is not displayed");
		}
		return this;
	}
	
	
	

	/***************************************************************************************************
	  * Description : This function is to verify resources and resource types not displayed in custom view table page.
	  * Arguments	: strResourceNames, strResourceType
	  * Date        : 10/09/2014  
	  * Author 		: Sangappa.k
	  **************************************************************************************************/
	public CustomUnderView verResourceAndResTypeNotDisplayedInCustomViewTablePage(
			String[] strResourceNames, String strResourceType) throws Exception {
		for (int i = 0; i < strResourceNames.length; i++) {
			objWaitForElement
			.waitForElements(
					"//td[@class='resourceName']/a[text()='"
							+ strResourceNames[i]
							+ "']/ancestor::tbody/ancestor::table/thead/tr/th[2][text()='"
							+ strResourceType + "']", "xpath");
			assertFalse(
					this.page
							.element(
									"//td[@class='resourceName']/a[text()='"
											+ strResourceNames[i]
											+ "']/ancestor::tbody/ancestor::table/thead/tr/th[2][text()='"
											+ strResourceType + "']", "xpath")
							.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE), "Resources displayed.");
		}
		return this;
	}	
	
	
	/**********************************************************************
	  * Description : This function is to verify StatusTypeNames
	  * Date        : 21/07/2015
	  * Author      : Renushree
	  **********************************************************************/	
	public CustomUnderView verResAndStatuaTypesWithValue(String strResTypeVal,
			String strResName, String strStatusTypeName, String strValue)
			throws Exception {
		assertTrue(
				this.page.element(
						"//table/thead/tr/th/a[text()='"
								+ strStatusTypeName
								+ "']/ancestor::table/tbody/tr/td[text()='"
								+ strValue
								+ "']/preceding-sibling::td/a[text()='"
								+ strResName + "']", "xpath")
						.isElementPresent(),
				"N/A is not displayed for status type.");
		return this;
	}
	/**********************************************************************
	  * Description : This function is to verify find resources page is displayed
	  * Date        : 21/07/2015
	  * Author      : Anil
	  **********************************************************************/	
	public CustomUnderView verifyFindResourcesPage()
			throws Exception {
		objWaitForElement
		.waitForElements(findResourcesPage, "xpath");
		assertTrue(
				this.page.element(findResourcesPage, "xpath")
						.getOne().isDisplayed(),
				"N/A is not displayed for status type.");
		return this;
	}
	
	/**********************************************************************
	  * Description : This function is to verify StatusTypeNames
	  * Date        : 21/07/2015
	  * Author      : Renushree
	  **********************************************************************/	
	public CustomUnderView verStatuaTypesCannotUpdate(String strResName, String strStatusTypeName)
			throws Exception {
		assertFalse(
				this.page.element(
						"//table/thead/tr/th/a[text()='"
								+ strStatusTypeName
								+ "']/ancestor::table/tbody/tr/td[@class='addToolTipText statusWhite editable']/preceding-sibling::td/a[text()='"
								+ strResName + "']", "xpath")
						.isElementPresent(),
				"ST can be update");
		return this;
	}
	
	/**************************************************************************
	 * Description 	: This function is to verify 'Search' button is present
	 * Date 		: 31/07/2015  
	 * Author 		: Sowmya
	 ***************************************************************************/
	public CustomUnderView verSearchButtonIsPresent() throws Exception {
		objWaitForElement.waitForElements(search, "css");
		assertTrue(this.page.element(search, "css").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify 'Cancel' button is present
	 * Date 		: 31/07/2015  
	 * Author 		: Sowmya
	 **********************************************************************************/
	public CustomUnderView verCancelButtonIsPresent() throws Exception {
		objWaitForElement.waitForElements(cancel, "css");
		assertTrue(this.page.element(cancel, "css").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify custom view table screen is displayed.
	 * Date 		: 28/08/2015  
	 * Author 		: Renushree
	 **********************************************************************************/
	public CustomUnderView verCustomViewTableScreenIsDisplayed()
			throws Exception {
		objWaitForElement
				.waitForElements(
						"//div[@id='topSubNav']/h1[text()='Custom View - Table']",
						"xpath");
		assertEquals("Custom View - Table", this.page.element(headerName, "css")
				.getOne().getText());
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify page when custom view is not created
	 * Date 		: 28/08/2015  
	 * Author 		: Renushree
	 **********************************************************************************/
	public CustomUnderView verPageWhenCustomViewNotCreated() throws Exception {
		objWaitForElement.waitForElements(noCustomViewPage, "xpath");
		assertTrue(this.page.element(noCustomViewPage, "xpath")
				.isElementPresent());
		assertTrue(this.page
				.element(
						"//div[@id='viewContainer']/p[text()='You have not yet created a Custom View configuration.']",
						"xpath").isElementPresent());
		assertTrue(this.page.element("Click here to setup your custom view",
				"linktext").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify save, cancel button in edit custom view page
	 * Date 		: 28/08/2015    
	 * Author 		: Renushree
	 **********************************************************************************/
	public CustomUnderView verSaveAndCancelButtonInEditCustomViewPage()
			throws Exception {
		objWaitForElement.waitForElements(save, "css");
		assertTrue(this.page.element(save, "css").isElementPresent(),
				"Save button is not present");
		assertTrue(this.page.element(cancel, "css").isElementPresent(),
				"Cancel button is not present");
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify add more resources, sortall and options buttons are available.
	 * Date 		: 28/08/2015  
	 * Author 		: Renushree
	 **********************************************************************************/
	public CustomUnderView verAddMoreResSortAllAndOptionsInEditCustomViewPage()
			throws Exception {
		objWaitForElement.waitForElements(addMoreResources, "css");
		assertTrue(this.page.element(addMoreResources, "css").isElementPresent(),
				"Add more resources is not present");
		assertTrue(this.page.element(sortAll, "css").isElementPresent(),
				"Sort All button is not present");
		assertTrue(this.page.element(options, "css").isElementPresent(),
				"Options button is not present");
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to select resources.
	 * Arguments	: strResourceVal
	 * Date 		: 12/08/2014  
	 * Author 		: Renushree
	 **********************************************************************************/
	public CustomUnderView verSubResource(String strResourceName,
			String strSubResourceName) throws Exception {
		objWaitForElement.waitForElements(
				"//table[@id='tbl_resourceID']/tbody/tr/td[text()='"
						+ strResourceName + ": " + strSubResourceName + "']",
				"xpath");
		assertTrue(
				this.page.element(
						"//table[@id='tbl_resourceID']/tbody/tr/td[text()='"
								+ strResourceName + ": " + strSubResourceName
								+ "']", "xpath").isElementPresent(),
				"Subresource name not displayed");
		return this;
	}

	/**********************************************************************************
	 * Description 	: This function is to select resources.
	 * Arguments	: strResourceVal
	 * Date 		: 12/08/2014  
	 * Author 		: Renushree
	 **********************************************************************************/
	public CustomUnderView verErrorWhenSubResourceSelected(
			String strResourceName, String strSubResourceName) throws Exception {
		objWaitForElement.waitForElements(errorMsg, "xpath");
		assertEquals("The following error occurred on this page:", this.page
				.element(errorMsg, "xpath").getOne().getText());
		assertEquals("You may not add Sub-Resources to your custom view. ("
				+ strResourceName + ": " + strSubResourceName + ")", this.page
				.element(errorMsg1, "xpath").getOne().getText());
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify custom view table screen is displayed.
	 * Date 		: 04/11/2015  
	 * Author 		: Renushree
	 **********************************************************************************/
	public CustomUnderView verCustomTableWithCustomName(String strCustomName)
			throws Exception {
		objWaitForElement
				.waitForElements(
						"//div[@id='topSubNav']/h1",
						"xpath");
		assertEquals(strCustomName, this.page.element(headerName, "css")
				.getOne().getText());
		return this;
	}
	
	/******************************************************************************************
	  * Description : This function is to verify resource name is retrieved
	  * Arguments	: strResourceName
	  * Date        : 10/09/2014  
	  * Author 		: Anil
	  *****************************************************************************************/
	public CustomUnderView verResourceNameInSearch(
			String strResourceName) throws Exception {
		objWaitForElement.waitForElements("//table[@id='tbl_resourceID']/tbody/tr/td[2][text()='"+strResourceName+"']", "xpath");
		assertTrue(this.page.element("//table[@id='tbl_resourceID']/tbody/tr/td[2][text()='"+strResourceName+"']", "xpath")
				.getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify status types are not displayed
	 * Date 		: 12/08/2014  
	 * Author 		: Anil
	 **********************************************************************************/
	public CustomUnderView verifyStatusTypesAreNotDisplayed(String[] strStatusTypeNames)
			throws Exception {
		for (int i = 0; i < strStatusTypeNames.length; i++) {
			assertFalse(this.page
					.element(
							"//input/following-sibling::b[text()='"+strStatusTypeNames[i]+"']",
							"xpath").isElementPresent(
									WaitTimeConstants.WAIT_TIME_FOR_FALSE),
					"Status types not displayed.");
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify status types are displayed
	 * Date 		: 12/08/2014  
	 * Author 		: Anil
	 **********************************************************************************/
	public CustomUnderView verifyStatusTypesAreDisplayed(String[] strStatusTypeNames)
			throws Exception {
		for (int i = 0; i < strStatusTypeNames.length; i++) {
			assertTrue(this.page
					.element(
							"//input/following-sibling::b[text()='"+strStatusTypeNames[i]+"']",
							"xpath").getOne().isDisplayed(),
					"Status types not displayed.");
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify resource nsme, resource type and region name is displayed
	 * Date 		: 12/08/2014  
	 * Author 		: Anil
	 **********************************************************************************/
	public CustomUnderView verifyRSRTAndRegionName(String strResourceName, String strResourceTypeName, String strRegionName)
			throws Exception {
		objWaitForElement.waitForElements(
				"//div[text()='"+strResourceName+" ["+strResourceTypeName+" - "+strRegionName+"]']",
				"xpath");
			assertTrue(this.page
					.element(
							"//div[text()='"+strResourceName+" ["+strResourceTypeName+" - "+strRegionName+"]']",
							"xpath").getOne().isDisplayed(),
					"Status types not displayed.");
		return this;
	}
}