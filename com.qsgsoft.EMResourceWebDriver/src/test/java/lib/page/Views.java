package lib.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.*;
import qaframework.lib.WaitTimeConstants;
import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;

public class Views extends PageObject {
			
	WebDriver driver;
	WaitForElement objWaitForElement ;

	private String resourceName = "r_name",
			subResource = "//div[@class='clearFix']/h1[contains(text(),'Sub-Resources')]",
			strCustomize = "div[id='link_customize']>a",
			createNewSubResourceBtn = "//input[@value='Create New Sub-Resource'][@type='button']",
			createNewSubResBtnUnderSubResourceSection = "//div[@id='mainContainer']//div[@class='clearFix']/h1[@class='sectionTitle left'][contains(text(),'Sub-Resources')]/ancestor::div//input[@value='Create New Sub-Resource']",
			headerName = "div#topSubNav > h1",
			promoteLink = "div[id='link_promote']",
			customError="#viewContainer > h1",
			errorMessage="p",
			noResourceErrorMessage = "//div[@id='viewContainer'][text()='There are no resources to display in this view.']",
			subResourceSectionInViewResDetailPage = "//h1[contains(text(),'Sub-Resources')]",
			detailView= "//h1[text()='Detail View']";
			
	
	public Views(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement =  new WaitForElement(this.driver);
		
	}
	
	/**********************************************************************************
	  * Description : This function is to click on resource
	  * Arguments	: strResource
	  * Date        : 06/08/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public Views clickOnResource(String strResource) throws Exception {
		objWaitForElement.waitForElements(strResource, "linktext");
		this.page.element(strResource, "linktext").getOne().click();
		Thread.sleep(8000);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify particular view screen is displayed
	  * Arguments	: strViewName
	  * Date        : 06/08/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public Views verViewScreenIsDisplayed(String strViewName) throws Exception {
		objWaitForElement.waitForElements(headerName, "css");
		assertEquals(strViewName, this.page.element(headerName, "css")
				.getOne().getText());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on resource
	  * Arguments	: strResource
	  * Date        : 06/08/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public Views verResourceScreenDisplayed(String strResource)
			throws Exception {
		objWaitForElement.waitForElements(resourceName, "id");
		assertEquals(strResource, this.page.element(resourceName, "id")
				.getOne().getText());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify status types under section
	  * Arguments	: strstatusType, strSection
	  * Date        : 06/08/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public Views verStatusTypesUnderSection(String strStatusType,
			String strSection) throws Exception {
		objWaitForElement.waitForElements("//a[text()='"
				+ strStatusType
				+ "']//ancestor::tbody/ancestor::table/thead/tr/th[2]/a[text()='"
				+ strSection + "']", "xpath");
		assertTrue(
				this.page
						.element(
								"//a[text()='"
										+ strStatusType
										+ "']//ancestor::tbody/ancestor::table/thead/tr/th[2]/a[text()='"
										+ strSection + "']", "xpath")
						.isElementPresent(),
				"Status type is not present under corresponding section.");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify resource name in View Resource Detail page
	  * Arguments	: strResource
	  * Date        : 07/08/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public Views verResource(String strResource) throws Exception {
		objWaitForElement.waitForElements(strResource, "linktext");
		assertTrue(this.page.element(strResource, "linktext")
				.isElementPresent(), "Resource name is not present");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Resource Name' and 'Resource Type' in after
	  *               clicking particular view page
	  * Arguments	: strResource
	  * Date        : 07/08/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public Views verResourceTypeAndResourceName(String strResourceTypeName,
			String strResourceName) throws Exception {
		objWaitForElement.waitForElements("//div[@id='viewContainer']//table/thead/tr/th[2]/a[text()='"
				+ strResourceTypeName
				+ "']/ancestor::table/tbody/tr/td/a[text()='"
				+ strResourceName + "']", "xpath");
		assertTrue(this.page.element(
				"//div[@id='viewContainer']//table/thead/tr/th[2]/a[text()='"
						+ strResourceTypeName
						+ "']/ancestor::table/tbody/tr/td/a[text()='"
						+ strResourceName + "']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Resource Name' and 'Resource Type' is not present in after
	  *               clicking perticular view page
	  * Arguments	: strResource
	  * Date        : 07/08/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public Views verResourceTypeAndResourceName1(String strResourceTypeName,
			String strResourceName) throws Exception {
		assertFalse(this.page.element(
				"//div[@id='viewContainer']//table/thead/tr/th[2]/a[text()='"
						+ strResourceTypeName
						+ "']/ancestor::table/tbody/tr/td/a[text()='"
						+ strResourceName + "']", "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify status types under section
	  * Arguments	: strstatusType, strSection
	  * Date        : 06/08/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public Views verStatusTypesNotUnderSection(String strStatusType,
			String strSection) throws Exception {
		assertFalse(this.page
				.element(
						"//a[text()='"
								+ strStatusType
								+ "']//ancestor::tbody/ancestor::table/thead/tr/th[2]/a[text()='"
								+ strSection + "']", "xpath").isElementPresent(
						WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	/**********************************************************************************
	  * Description : This function is to verify 'Status type' in after
	  *               clicking perticular view page
	  * Arguments	: strResource
	  * Date        : 07/08/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public Views verStatusTypes(String strResourceTypeName,
			String strStatusTypeName) throws Exception {
		objWaitForElement.waitForElements("//div[@id='viewContainer']//table/thead/tr/th[2]/a[text()='"
				+ strResourceTypeName
				+ "']/parent::th/following-sibling::th/a[text()='"
				+ strStatusTypeName + "']", "xpath");
		assertTrue(this.page.element(
				"//div[@id='viewContainer']//table/thead/tr/th[2]/a[text()='"
						+ strResourceTypeName
						+ "']/parent::th/following-sibling::th/a[text()='"
						+ strStatusTypeName + "']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify not N/A is displayed under ST for RS.
	  * Arguments	: strResource,strStatusTypeName
	  * Date        : 12/08/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public Views verST1ForResource(String strResource, String strStatusTypeName, String strStatus)
			throws Exception {
		objWaitForElement.waitForElements("//a[text()='"
				+ strResource
				+ "']/parent::td/following-sibling::td[1][text()='"+strStatus+"']/ancestor::table/thead/tr/th[3]/a[text()='"
				+ strStatusTypeName + "']", "xpath");
		assertTrue(this.page
				.element(
						"//a[text()='"
								+ strResource
								+ "']/parent::td/following-sibling::td[1][text()='"+strStatus+"']/ancestor::table/thead/tr/th[3]/a[text()='"
								+ strStatusTypeName + "']", "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify not N/A is displayed under ST for RS.
	  * Arguments	: strResource,strStatusTypeName
	  * Date        : 12/08/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public Views verST2ForResource(String strResource, String strStatusTypeName, String strStatus)
			throws Exception {
		objWaitForElement.waitForElements("//a[text()='"
				+ strResource
				+ "']/parent::td/following-sibling::td[2][text()='"+strStatus+"']/ancestor::table/thead/tr/th[4]/a[text()='"
				+ strStatusTypeName + "']", "xpath");
		assertTrue(this.page
				.element(
						"//a[text()='"
								+ strResource
								+ "']/parent::td/following-sibling::td[2][text()='"+strStatus+"']/ancestor::table/thead/tr/th[4]/a[text()='"
								+ strStatusTypeName + "']", "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify view resource detail screen is displayed.
	 * Date 		: 09/09/2014  
	 * Author 		: Renushree
	 **********************************************************************************/
	public Views verViewResourceDetailsPgeIsDisplayed()
			throws Exception {
		objWaitForElement.waitForElements(detailView, "xpath");
		assertTrue(this.page.element(detailView, "xpath").isElementPresent());
//		assertEquals("View Resource Detail", this.page.element(headerName, "css")
//				.getOne().getText());
		return this;
	}
	/**********************************************************************************
	  * Description : This function is to verify 'Status type' in after
	  *               clicking perticular view page
	  * Arguments	: strResource
	  * Date        : 07/08/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public Views verStatusTypesInUserViewScreen(String strResourceTypeName,
			String[] strStatusTypeName) throws Exception {
		objWaitForElement.waitForElements("//table/thead" + "/tr/th[2]/a[text()='"
				+ strResourceTypeName + "']/ancestor::tr/th["
				+ (0 + 3) + "]/a[text()='"
				+ strStatusTypeName[0] + "']", "xpath");
		for (int intCol = 0; intCol < strStatusTypeName.length; intCol++) {
			assertTrue(this.page.element(
					"//table/thead" + "/tr/th[2]/a[text()='"
							+ strResourceTypeName + "']/ancestor::tr/th["
							+ (intCol + 3) + "]/a[text()='"
							+ strStatusTypeName[intCol] + "']", "xpath")
					.isElementPresent());
		}
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Sub-Resource' section is displayed
	  * Arguments	: 
	  * Date        : 23/09/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public Views verSubResourcesSectionIsDisplayed() throws Exception {
		objWaitForElement.waitForElements(subResource, "xpath");
		assertTrue(this.page.element(subResource, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Sub-Resource' section is not displayed
	  * Arguments	: 
	  * Date        : 23/09/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public Views verSubResourcesSectionIsNotDisplayed() throws Exception {
		assertFalse(this.page.element(subResource, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to verify 'Resource Name' and 'Resource Type' in 
	  *              View Resource detail page
	  * Arguments	: strResource
	  * Date        : 23/09/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public Views verResourceTypeAndResourceNameInViewResDetailPage(
			String strResourceTypeName, String strResourceName)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']//table/thead/tr/th[2]/a[text()='"
				+ strResourceTypeName
				+ "']/ancestor::table/tbody/tr/td/a[text()='"
				+ strResourceName + "']", "xpath");
		assertTrue(this.page.element(
				"//div[@id='mainContainer']//table/thead/tr/th[2]/a[text()='"
						+ strResourceTypeName
						+ "']/ancestor::table/tbody/tr/td/a[text()='"
						+ strResourceName + "']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Update Status' key is present in View Resource detail page
	  * Date        : 23/09/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public Views verUpdateStatusKeyInViewResDetailPage(String strResourceName)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']//table/tbody/tr/td[2]/a[text()='"
				+ strResourceName
				+ "']/parent::td/preceding-sibling::td/a/img[@title='Update Status']",
		"xpath");
		assertTrue(this.page
				.dynamicElement(
						strResourceName,
						"//div[@id='mainContainer']//table/tbody/tr/td[2]/a[text()='"
								+ strResourceName
								+ "']/parent::td/preceding-sibling::td/a/img[@title='Update Status']",
						"xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on 'Customize' link
	  * Arguments	: 
	  * Date        : 23/09/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public Views clickOnCustomizeLink() throws Exception {
		objWaitForElement.waitForElements(strCustomize, "css");
		this.page.element(strCustomize, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Create new sub resource' button
	  * Arguments	: 
	  * Date        : 24/09/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public Views verifyCreateNewSubResourceBtnUnderSubResourceSection()
			throws Exception {
		objWaitForElement.waitForElements(createNewSubResBtnUnderSubResourceSection, "xpath");
		assertTrue(this.page.element(createNewSubResBtnUnderSubResourceSection, "xpath")
				.isElementPresent());
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to click on 'Create new sub resource' button
	  * Arguments	: 
	  * Date        : 24/09/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public Views clickOnCreateNewSubResourceBtn()
			throws Exception {
		objWaitForElement.waitForElements(createNewSubResourceBtn, "css");
		this.page.element(createNewSubResourceBtn, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Edit Resource Detail View Sections Page is displayed 
	  * Date        : 24/09/2014
	  * Author      : Prasanna Lakshmi
	  **********************************************************************************/
	 public Views verEditResDetailPageisDisplayed() throws Exception {
		 objWaitForElement.waitForElements(headerName, "css");
	  	  assertEquals("Edit Resource Detail View Sections", this.page.element(headerName, "css").getOne().getText());
	  return this;
	 }
	 /**********************************************************************************
	  * Description : This function is to verify Edit Sub Resource Detail View Sections Page is displayed 
	  * Date        : 24/09/2014
	  * Author      : Prasanna Lakshmi
	  **********************************************************************************/
	 public Views verEditSubResDetailPageisDisplayed() throws Exception {
		 objWaitForElement.waitForElements(headerName, "css");
	  	  assertEquals("Edit Sub Resource Detail View Sections", this.page.element(headerName, "css").getOne().getText());
	  return this;
	 }
	 /**********************************************************************************
	  * Description : This function is to verify 'Status type' in Custom View Table
	  * Arguments	: strResource
	  * Date        : 07/08/2014
	  * Author      : Prasanna Lakshmi
	  **********************************************************************************/
	public Views verStatusTypesInCustomViewTable(String strResourceTypeName,
			String strStatusTypeName) throws Exception {
		objWaitForElement.waitForElements("//div[@id='viewContainer']//table/thead/tr/th[2][text()='"
						+ strResourceTypeName
						+ "']/following-sibling::th/a[text()='"
						+ strStatusTypeName + "']", "xpath");
		assertTrue(this.page.element(
				"//div[@id='viewContainer']//table/thead/tr/th[2][text()='"
						+ strResourceTypeName
						+ "']/following-sibling::th/a[text()='"
						+ strStatusTypeName + "']", "xpath").isElementPresent());
		return this;
	}
	/**********************************************************************************
	  * Description : This function is to verify 'Resource Name' and 'Resource Type' in custom View Table
	  *              
	  * Arguments	: strResource
	  * Date        : 07/08/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public Views verResourceTypeAndResourceNameInCustomTable(String strResourceTypeName,
			String strResourceName) throws Exception {
		objWaitForElement.waitForElements("//div[@id='viewContainer']//table/thead/tr/th[2][text()='"
				+ strResourceTypeName
				+ "']/ancestor::table/tbody/tr/td/a[text()='"
				+ strResourceName + "']", "xpath");
		assertTrue(this.page.element(
				"//div[@id='viewContainer']//table/thead/tr/th[2][text()='"
						+ strResourceTypeName
						+ "']/ancestor::table/tbody/tr/td/a[text()='"
						+ strResourceName + "']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify status types
	  * Arguments	: strStatusTypes
	  * Date        : 25/09/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public Views verStatusTypes(String strStatusTypes) throws Exception {
		objWaitForElement.waitForElements("//table[@summary='Status']/tbody/tr/td/a[text()='"
				+ strStatusTypes + "']", "xpath");
		assertTrue(this.page.element(
				"//table[@summary='Status']/tbody/tr/td/a[text()='"
						+ strStatusTypes + "']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify event icon with the resource
	  * Arguments	: strResource, strEvent
	  * Date        : 07/10/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public Views verEventIconWithResource(String strEvent, String strResource)
			throws Exception {
		objWaitForElement.waitForElementByxpathSelector("//img[@alt='" + strEvent
						+ "']/parent::a/preceding-sibling::a[text()='"
						+ strResource + "']");
		assertTrue(this.page.element(
				"//img[@alt='" + strEvent
						+ "']/parent::a/preceding-sibling::a[text()='"
						+ strResource + "']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on event icon with the resource
	  * Arguments	: strResource, strEvent
	  * Date        : 07/10/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public Views clickOnEventIconWithResource(String strEvent,
			String strResource) throws Exception {
		objWaitForElement.waitForElements("//a[text()='" + strResource
				+ "']/following-sibling::a/img[@alt='"
				+ strEvent + "']", "xpath");
		this.page
				.element(
						"//a[text()='" + strResource
								+ "']/following-sibling::a/img[@alt='"
								+ strEvent + "']", "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Custom View - Table Page is displayed 
	  * Date        : 07/10/2014
	  * Author      : Prasanna Lakshmi
	  **********************************************************************************/
	public Views verCustomViewTableisDisplayed() throws Exception {
		Thread.sleep(10000);
		objWaitForElement.waitForElementBycssSelector(headerName);
		assertEquals("Custom View - Table", this.page
				.element(headerName, "css").getOne().getText());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify traffic button in map
	  * Arguments	: None
	  * Date        : 11/11/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public Views verTrafficBtnInMap() throws Exception {
		objWaitForElement.waitForElements("//div[@id='map']/div/div[@class='gmap-control-container gmnoprint']/div[text()='Traffic']",
				"xpath");
		assertTrue(
				this.page
						.element(
								"//div[@id='map']/div/div[@class='gmap-control-container gmnoprint']/div[text()='Traffic']",
								"xpath").isElementPresent(),
				"Traffic button is not present");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Map and satellite button in map
	  * Arguments	: None
	  * Date        : 11/11/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public Views verMapAndSatelliteBtnInMap() throws Exception {
		objWaitForElement.waitForElements("//div[@id='map']/div/div[@class='gmnoprint']/div/div[text()='Map']",
				"xpath");
		assertTrue(
				this.page
						.element(
								"//div[@id='map']/div/div[@class='gmnoprint']/div/div[text()='Map']",
								"xpath").isElementPresent(),
				"Map button is not present");
		assertTrue(
				this.page
						.element(
								"//div[@id='map']/div/div[@class='gmnoprint']/div/div[text()='Satellite']",
								"xpath").isElementPresent(),
				"Satellite button is not present");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on Sub-Resource under the Resource
	  * Date        : 11/11/2014
	  * Author      : sangappa.k
	  **********************************************************************************/
	public Views clickOnSubResources(String strSubresource) throws Exception {
		objWaitForElement.waitForElements(strSubresource, "linktext");
		this.page.element(strSubresource, "linktext").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify updated status values 
	  * Date        : 12/02/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public Views verUpdatedStatus(String strStatusTypeVal, String strUpdatedVal)
			throws Exception {
		objWaitForElement.waitForElements("//td[text()='" + strUpdatedVal
				+ "']/preceding-sibling::td/a[@class='st_"
				+ strStatusTypeVal + "']", "xpath");
		assertTrue(this.page.element(
				"//td[text()='" + strUpdatedVal
						+ "']/preceding-sibling::td/a[@class='st_"
						+ strStatusTypeVal + "']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on 'Update Status' key is present in View Resource detail page
	  * Date        : 12/02/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public Views clickOnUpdateStatusKeyInViewResDetailPage(String strResourceName)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']//table/tbody/tr/td[2]/a[text()='"
				+ strResourceName
				+ "']/parent::td/preceding-sibling::td/a/img[@title='Update Status']",
		"xpath");
		assertTrue(this.page
				.dynamicElement(
						strResourceName,
						"//div[@id='mainContainer']//table/tbody/tr/td[2]/a[text()='"
								+ strResourceName
								+ "']/parent::td/preceding-sibling::td/a/img[@title='Update Status']",
						"xpath").isElementPresent());
		this.page
		.dynamicElement(
				strResourceName,
				"//div[@id='mainContainer']//table/tbody/tr/td[2]/a[text()='"
						+ strResourceName
						+ "']/parent::td/preceding-sibling::td/a/img[@title='Update Status']",
				"xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Status Type' is not displayed
	  * Arguments	: strResource
	  * Date        : 24/03/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public Views verStatusTypesNotDisplayed(String strResourceTypeName,
			String strStatusTypeName) throws Exception {
		assertFalse(this.page.element(
				"//div[@id='viewContainer']//table/thead/tr/th[2]/a[text()='"
						+ strResourceTypeName
						+ "']/parent::th/following-sibling::th/a[text()='"
						+ strStatusTypeName + "']", "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Resource Name' and 'Resource Type' in after
	  *               clicking perticular view page
	  * Arguments	: strResource
	  * Date        : 07/08/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public Views verResourceTypeAndResourceNameNotInView(String strResourceTypeName,
			String strResourceName) throws Exception {
		assertFalse(this.page.element(
				"//div[@id='viewContainer']//table/thead/tr/th[2]/a[text()='"
						+ strResourceTypeName
						+ "']/ancestor::table/tbody/tr/td/a[text()='"
						+ strResourceName + "']", "xpath").isElementPresent(
				WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	/**********************************************************************************
	  * Description : This function is to verify error message in custom view screen
	  * Date        : 29/05/2014
	  * Author      : Anitha
	  **********************************************************************************/
	public Views vererrorMsgInCustomView() throws Exception {
		objWaitForElement.waitForElementBycssSelector(customError);
		assertEquals("No Statuses in Custom View", this.page
				.element(customError, "css").getOne().getText());
		assertEquals(
				"There are no statuses (columns) to display in your custom view.",
				 this.page
					.element(errorMessage, "css").getOne().getText());
		assertTrue(this.page
				.element(
						"//p/a[text()='Click here to add status columns to your custom view']",
						"xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Resource Name' not present in view screen
	  * Arguments	: strResource
	  * Date        : 02/Jul/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public Views verResourceNameNotInView(String strResourceName) throws Exception {
		assertFalse(this.page.element(
				"//div[@id='viewContainer']//table/tbody/tr/td/a[text()='"
						+ strResourceName + "']", "xpath").isElementPresent(
				WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify error message in  view screen
	  * Date        : 29/05/2014
	  * Author      : Anil
	  **********************************************************************************/
	public Views vererrorMsgInViewPage() throws Exception {
		objWaitForElement.waitForElements(noResourceErrorMessage, "xpath");
		assertTrue(this.page.element(noResourceErrorMessage, "xpath").getOne().isDisplayed());
		return this;
	}
	
	  /**********************************************************************************
	   * Description : This function is to verify Sub resource type and Sub-Resource under 
	   * 				'Sub-Resource' Section in View Resource detail screen
	   * Arguements  : strResourceName
	   * Date        : 08-Sept-2015
	   * Author      : Pallavi
	   **********************************************************************************/
	public Views verSubResourceInViewResDetailPage(
			String strSubResourceName, String strSubResourceValue,
			String strSubResourceTypeName, String strSubResourceTypeValue)
			throws Exception {
		objWaitForElement.waitForElements(
				subResourceSectionInViewResDetailPage, "xpath");
		assertTrue(this.page.element(
				"//table[@id='rtt_" + strSubResourceTypeValue
						+ "']/thead/tr/th/a[@id='rt_" + strSubResourceTypeValue
						+ "'][text()='" + strSubResourceTypeName + "']",
				"xpath").isElementPresent());
		assertTrue(this.page.element(
				"//table[@id='rtt_" + strSubResourceTypeValue
						+ "']/tbody/tr/td/a[@id='r_" + strSubResourceValue
						+ "'][text()='" + strSubResourceName + "']", "xpath")
				.isElementPresent());
		return this;
	}

	  /**********************************************************************************
	   * Description : This function is to verify Sub resource type and Sub-Resource under 
	   * 				'Sub-Resource' Section in View Resource detail screen
	   * Arguements  : strResourceName
	   * Date        : 08-Sept-2015
	   * Author      : Pallavi
	   **********************************************************************************/
	public Views verSTUnderSubResourceSection(
			String strSubResourceTypeValue, String strStatusTypeValue)
			throws Exception {
		objWaitForElement.waitForElements(
				subResourceSectionInViewResDetailPage, "xpath");
		assertTrue(this.page.element(
				"//table[@id='rtt_" + strSubResourceTypeValue
						+ "']/thead//th/a[@class='st_" + strStatusTypeValue
						+ "']", "xpath").isElementPresent());
		return this;
	}

	  /**********************************************************************************
	   * Description : This function is to verify Sub resource type and Sub-Resource under 
	   * 				'Sub-Resource' Section in View Resource detail screen
	   * Arguements  : strResourceName
	   * Date        : 08-Sept-2015
	   * Author      : Pallavi
	   **********************************************************************************/
	public Views clickOnSubResourceNameLinkUnderSubResSection(
			String strSubResourceValue, String strSubResourceTypeValue)
			throws Exception {
		objWaitForElement.waitForElements(
				subResourceSectionInViewResDetailPage, "xpath");
		this.page.element("//table[@id='rtt_" + strSubResourceTypeValue
						+ "']/tbody/tr/td/a[@id='r_" + strSubResourceValue
						+ "']", "xpath").getOne().click();
		return this;
	}

	  /**********************************************************************************
	   * Description : This function is to verify Sub resource name, Sub-Resource Type, 
	   * 				First Name, Last Name in View Resource detail screen
	   * Arguements  : strResourceName
	   * Date        : 08-Sept-2015
	   * Author      : Pallavi
	   **********************************************************************************/
	public Views verSubResourceNameAndItsDetails(String strSubResourceName,
			String strSubResourceTypeName, String strResFN, String strResLN)
			throws Exception {
		objWaitForElement.waitForElements(
				subResourceSectionInViewResDetailPage, "xpath");
		assertTrue(this.page.element(
				"//h1[text()='" + strSubResourceName + "']", "xpath")
				.isElementPresent());
		assertTrue(this.page.element(
				"//td[text()='Type:']/following-sibling::td[text()='"
						+ strSubResourceTypeName + "']", "xpath")
				.isElementPresent());
		assertTrue(this.page.element(
				"//td[text()='Contact:']/following-sibling::td[text()='"
						+ strResFN + " " + strResLN + "']", "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify on 'Customize' link
	  * Arguments	: 
	  * Date        : 23/09/2014
	  * Author      : Anil
	  **********************************************************************************/
	public Views verifyCustomizeLinkIsDispalyed() throws Exception {
		objWaitForElement.waitForElements(strCustomize, "css");
		assertTrue(this.page.element(strCustomize, "css").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify on 'Customize' link is not displayed
	  * Arguments	: 
	  * Date        : 23/09/2014
	  * Author      : Anil
	  **********************************************************************************/
	public Views verifyCustomizeLinkIsNotDispalyed() throws Exception {
		objWaitForElement.waitForElements(strCustomize, "css");
		assertFalse(this.page.element(strCustomize, "css").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
}