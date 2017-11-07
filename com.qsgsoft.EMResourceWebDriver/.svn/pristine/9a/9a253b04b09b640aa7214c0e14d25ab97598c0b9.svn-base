package lib.page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.*;
import qaframework.lib.WaitTimeConstants;
import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;

public class StatusChangePreference extends PageObject {
	
	WebDriver driver;
	WaitForElement objWaitForElement ;
	
	private String headerName = "div#topSubNav > h1",
				   add = "input[value='Add']",
				   searchResourceField = "searchName",
				   search = "input[value='Search']",
				   notifications = "input[value='Notifications']",
				   subHeadingResName = "#r_name",
				   save = "input[value='Save']",
				   cancel = "tr.buttonRow > td > input[value='Cancel']",
				   cancel_1 = "input[value='Cancel']",
				   myStatusChangePreferences = "//div[@id='topSubNav']/h1[text()='My Status Change Preferences']",
				   noVisibleStatusTypeMessage =  "//td[@class='emsText'][text()='No visible status types are available.']",
				   editMyStatusChangePreferences = "//div[@id='topSubNav']/h1[text()='Edit My Status Change Preferences']";
	
	public StatusChangePreference(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
	}

	/**********************************************************************************
	  * Description : This function is to verify my status change preference page is displayed
	  * Date        : 23/09/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public StatusChangePreference verMyStatusChangePreferncePgeDisplayed()
			throws Exception {
		objWaitForElement.waitForElements(myStatusChangePreferences, "xpath");
		assertEquals("My Status Change Preferences",
				this.page.element(headerName, "css").getOne().getText());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on add button.
	  * Date        : 23/09/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public StatusChangePreference clickOnAdd() throws Exception {
		objWaitForElement.waitForElements(add, "css");
		this.page.element(add, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to enter resource name to search.
	 * Arguments	: strResource
	 * Date 		: 23/09/2014  
	 * Author 		: Renushree
	 **********************************************************************************/
	public StatusChangePreference enterResNameInWhatField(String strResource) throws Exception {
		objWaitForElement.waitForElements(searchResourceField, "id");
		this.page.element(searchResourceField, "id").clearInputValue().sendKeys(strResource);
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to click on search button
	 * Date 		: 23/09/2014  
	 * Author 		: Renushree
	 **********************************************************************************/
	public StatusChangePreference clickOnSearch() throws Exception {
		objWaitForElement.waitForElements(search, "css");
		this.page.element(search, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify resource displayed in find resource page
	 * Arguments	: strResource
	 * Date 		: 23/09/2014  
	 * Author 		: Renushree
	 **********************************************************************************/
	public StatusChangePreference verResourceDisplayedInFindResScreen(
			String strResource) throws Exception {
		objWaitForElement.waitForElements("//table[@id='tbl_resourceID']/tbody/tr/td[2][text()='"
				+ strResource + "']", "xpath");
		assertTrue(this.page
				.element(
						"//table[@id='tbl_resourceID']/tbody/tr/td[2][text()='"
								+ strResource + "']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to select resources.
	 * Arguments	: strResourceVal
	 * Date 		: 23/09/2014  
	 * Author 		: Renushree
	 **********************************************************************************/
	public StatusChangePreference selectResource(String strResourceVal)
			throws Exception {
		objWaitForElement.waitForElements("//table[@id='tbl_resourceID']/tbody/tr/td/input[@value='"
				+ strResourceVal+ "']", "xpath");
			this.page
					.element(
							"//table[@id='tbl_resourceID']/tbody/tr/td/input[@value='"
									+ strResourceVal+ "']", "xpath")
					.getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to click on notification
	 * Date 		: 23/09/2014  
	 * Author 		: Renushree
	 **********************************************************************************/
	public StatusChangePreference clickOnNotifications() throws Exception {
		objWaitForElement.waitForElements(notifications, "css");
		this.page.element(notifications, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify edit my status change preference page is displayed
	  * Date        : 23/09/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public StatusChangePreference verEditMyStatusChangePrefPgeDisplayed()
			throws Exception {
		objWaitForElement.waitForElements(editMyStatusChangePreferences, "xpath");
		assertEquals("Edit My Status Change Preferences",
				this.page.element(headerName, "css").getOne().getText());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify sub resource type, resource and sub resource is displayed as subheader
	  * Date        : 23/09/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public StatusChangePreference verSubRTAndResSubResIsDisplayedAsSubHeader(
			String strSubResType, String strResource, String strSubResource)
			throws Exception {
		objWaitForElement.waitForElements(subHeadingResName, "css");
		assertEquals("" + strSubResType + "—" + strResource + ": "
				+ strSubResource, this.page.element(subHeadingResName, "css")
				.getOne().getText());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to expand uncategorized section
	  * Date        : 23/09/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public StatusChangePreference expandUncategorizedSec() throws Exception {
		objWaitForElement.waitForElements("//img[@src='/img/icons/collapse_open.gif']", "xpath");
		this.page
				.element("//img[@src='/img/icons/collapse_open.gif']", "xpath")
				.getOne().click();
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to verify status types are listed under uncategorized.
	  * Date        : 23/09/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public StatusChangePreference verStatusTypesUnderUncategorizedSec(
			String strStatusTypesNames) throws Exception {
		objWaitForElement.waitForElements(
				"//form[@name='form1']/table/tbody/tr/td/div[text()='"
						+ strStatusTypesNames + "']", "xpath");
		assertTrue(this.page.element(
				"//form[@name='form1']/table/tbody/tr/td/div[text()='"
						+ strStatusTypesNames + "']", "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter above values.
	  * Date        : 23/09/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public StatusChangePreference enterAboveValues(String strResourceVal,
			String strStatusTypesValues, String strValues) throws Exception {
		objWaitForElement.waitForElements(
				"input[type='text'][name='above" + strResourceVal + "|"
						+ strStatusTypesValues + "|N|A']", "css");
		this.page
				.element(
						"input[type='text'][name='above" + strResourceVal + "|"
								+ strStatusTypesValues + "|N|A']", "css")
				.clearInputValue().sendKeys(strValues);

		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter above values.
	  * Date        : 23/09/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public StatusChangePreference enterBelowValues(String strResourceVal,
			String strStatusTypesValues, String strValues) throws Exception {
		objWaitForElement.waitForElements("input[type='text'][name='below" + strResourceVal
				+ "|" + strStatusTypesValues + "|N|B']", "css");
		this.page
				.element(
						"input[type='text'][name='below" + strResourceVal
								+ "|" + strStatusTypesValues + "|N|B']", "css")
				.clearInputValue().sendKeys(strValues);

		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select email check box.
	  * Date        : 23/09/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public StatusChangePreference selEmailChkBoxForAboveAndBelowVal(String strResourceVal,
			String strStatusTypesValues) throws Exception {
		objWaitForElement.waitForElements("input[name='emailInd'][value='" + strResourceVal + "|"
				+ strStatusTypesValues + "|N|A']", "css");
		this.page
				.element(
						"input[name='emailInd'][value='" + strResourceVal + "|"
								+ strStatusTypesValues + "|N|A']", "css")
				.getOne().click();
		objWaitForElement.waitForElements("input[name='emailInd'][value='" + strResourceVal + "|"
				+ strStatusTypesValues + "|N|B']", "css");
		this.page
				.element(
						"input[name='emailInd'][value='" + strResourceVal + "|"
								+ strStatusTypesValues + "|N|B']", "css")
				.getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select pager check box.
	  * Date        : 23/09/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public StatusChangePreference selPagerChkBoxForAboveAndBelowVal
	(String strResourceVal,
			String strStatusTypesValues) throws Exception {
		objWaitForElement.waitForElements("input[name='pagerInd'][value='" + strResourceVal + "|"
				+ strStatusTypesValues + "|N|A']", "css");
		this.page
				.element(
						"input[name='pagerInd'][value='" + strResourceVal + "|"
								+ strStatusTypesValues + "|N|A']", "css")
				.getOne().click();
		objWaitForElement.waitForElements("input[name='pagerInd'][value='" + strResourceVal + "|"
				+ strStatusTypesValues + "|N|B']", "css");
		this.page
				.element(
						"input[name='pagerInd'][value='" + strResourceVal + "|"
								+ strStatusTypesValues + "|N|B']", "css")
				.getOne().click();

		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select web check box.
	  * Date        : 23/09/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public StatusChangePreference selWebChkBoxForAboveAndBelowVal(String strResourceVal,
			String strStatusTypesValues) throws Exception {
		objWaitForElement.waitForElements("input[name='webInd'][value='" + strResourceVal + "|"
				+ strStatusTypesValues + "|N|A']", "css");
		this.page
				.element(
						"input[name='webInd'][value='" + strResourceVal + "|"
								+ strStatusTypesValues + "|N|A']", "css")
				.getOne().click();
		objWaitForElement.waitForElements("input[name='webInd'][value='" + strResourceVal + "|"
				+ strStatusTypesValues + "|N|B']", "css");
		this.page
				.element(
						"input[name='webInd'][value='" + strResourceVal + "|"
								+ strStatusTypesValues + "|N|B']", "css")
				.getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select email pager web chk boxes
	  * Date        : 23/09/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public StatusChangePreference selEmailPagerWebChkBoxesForAboveAndBelowVal(
			String strResourceVal, String strStatusTypesValues)
			throws Exception {
		this.selEmailChkBoxForAboveAndBelowVal(strResourceVal, strStatusTypesValues);
		this.selPagerChkBoxForAboveAndBelowVal(strResourceVal, strStatusTypesValues);
		this.selWebChkBoxForAboveAndBelowVal(strResourceVal, strStatusTypesValues);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on save
	  * Date        : 23/09/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public StatusChangePreference clickOnSave() throws Exception {
		objWaitForElement.waitForElements(save, "css");
		this.page.element(save, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select email check box.
	  * Date        : 23/09/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public StatusChangePreference selEmailChkBoxForNormalST(String strResourceVal,
			String strStatusTypesValues) throws Exception {
		objWaitForElement.waitForElements("input[name='emailInd'][value='" + strResourceVal + "|"
				+ strStatusTypesValues + "|T|']", "css");
		this.page
				.element(
						"input[name='emailInd'][value='" + strResourceVal + "|"
								+ strStatusTypesValues + "|T|']", "css")
				.getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select pager check box.
	  * Date        : 23/09/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public StatusChangePreference selPagerChkBoxForNormalST(String strResourceVal,
			String strStatusTypesValues) throws Exception {
		objWaitForElement.waitForElements("input[name='pagerInd'][value='" + strResourceVal + "|"
				+ strStatusTypesValues + "|T|']", "css");
		this.page
				.element(
						"input[name='pagerInd'][value='" + strResourceVal + "|"
								+ strStatusTypesValues + "|T|']", "css")
				.getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select web check box.
	  * Date        : 23/09/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public StatusChangePreference selWebChkBoxForNormalST(String strResourceVal,
			String strStatusTypesValues) throws Exception {
		objWaitForElement.waitForElements("input[name='webInd'][value='" + strResourceVal + "|"
				+ strStatusTypesValues + "|T|']", "css");
		this.page
				.element(
						"input[name='webInd'][value='" + strResourceVal + "|"
								+ strStatusTypesValues + "|T|']", "css")
				.getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select email pager web chk boxes
	  * Date        : 23/09/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public StatusChangePreference selEmailPagerWebChkBoxes(
			String strResourceVal, String strStatusTypesValues)
			throws Exception {
		this.selEmailChkBoxForNormalST(strResourceVal, strStatusTypesValues);
		this.selPagerChkBoxForNormalST(strResourceVal, strStatusTypesValues);
		this.selWebChkBoxForNormalST(strResourceVal, strStatusTypesValues);
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to click on cancel button
	 * Date 		: 09/12/2014  
	 * Author 		: Renushree
	 **********************************************************************************/
	public StatusChangePreference clickOnCancel() throws Exception {
		objWaitForElement.waitForElements(cancel, "css");
		this.page.element(cancel, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify sub resource type, resource is displayed as subheader
	  * Date        : 09/12/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public StatusChangePreference verRTAndResIsDisplayedAsSubHeader(
			String strResType, String strResource) throws Exception {
		objWaitForElement.waitForElements(subHeadingResName, "css");
		assertEquals("" + strResType + "—" + strResource + "", this.page
				.element(subHeadingResName, "css").getOne().getText());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify sub resource type, resource is NOT displayed as subheader
	  * Date        : 09/12/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public StatusChangePreference verRTAndResIsNotDisplayedAsSubHeader(
			String strResType, String strResource) throws Exception {
		assertFalse(
				this.page.element(
						"//h1[@id='r_name'][text()='" + strResType + "—"
								+ strResource + "']", "xpath")
						.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE), "Resource name is displayed");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Status Change Preferences for users page
	  * Date        : 17/Jun/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public StatusChangePreference verStatusChangePreferencesforUserPage(String strUserName)
			throws Exception {
		objWaitForElement.waitForElements(headerName, "css");
		assertEquals("Status Change Preferences for "+strUserName+"",
				this.page.element(headerName, "css").getOne().getText());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify edit my status change preference page for user is displayed
	  * Date        : 17/Jun/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public StatusChangePreference verEditMyStatusChangePrefForUserPgeDisplayed(String strUserName)
			throws Exception {
		objWaitForElement.waitForElements(headerName, "css");
		assertEquals("Edit Status Change Preferences for "+strUserName+"",
				this.page.element(headerName, "css").getOne().getText());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on edit in edit my status change preference page
	  * Date        : 17/Jun/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public StatusChangePreference clickOnEditInMyStatusChangePreferences(
			String strResName) throws Exception {
		objWaitForElement.waitForElements("//td[text()='" + strResName
				+ "']/preceding-sibling::td/a[text()='edit']", "xpath");
		this.page
				.element(
						"//td[text()='" + strResName
								+ "']/preceding-sibling::td/a[text()='edit']",
						"xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify above and below values
	  * Arguments	: strStatusTypeName, strAboveValue, strBelowValue
	  * Date        : 17/Jun/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public StatusChangePreference verAboveAndBelowValues(
			String strStatusTypeName, String strAboveValue, String strBelowValue)
			throws Exception {
		objWaitForElement.waitForElements("//td[text()='" + strStatusTypeName
				+ "']/following-sibling::td[text()='Above: " + strAboveValue
				+ "']", "xpath");
		assertTrue(
				this.page.element(
						"//td[text()='" + strStatusTypeName
								+ "']/following-sibling::td[text()='Above: "
								+ strAboveValue + "']", "xpath")
						.isElementPresent(), "Above value not present");
		assertTrue(
				this.page
						.element(
								"//td[text()='"
										+ strStatusTypeName
										+ "']/parent::tr/following-sibling::tr[1]/td[text()='Below: "
										+ strBelowValue + "']", "xpath")
						.isElementPresent(), "Above value not present");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select email check box.
	  * Date        : 23/09/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public StatusChangePreference selEmailChkBoxForStatuses(String strResourceVal,
			String strSTVal, String strStatusesVal) throws Exception {
		objWaitForElement.waitForElements("input[name='emailInd'][value='"+strResourceVal+"|"+strSTVal+"|S|"+strStatusesVal+"']", "css");
		this.page
				.element(
						"input[name='emailInd'][value='"+strResourceVal+"|"+strSTVal+"|S|"+strStatusesVal+"']", "css")
				.getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select email check box.
	  * Date        : 23/09/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public StatusChangePreference selWebChkBoxForStatuses(String strResourceVal,
			String strSTVal, String strStatusesVal) throws Exception {
		objWaitForElement.waitForElements("input[name='webInd'][value='"+strResourceVal+"|"+strSTVal+"|S|"+strStatusesVal+"']", "css");
		this.page
				.element(
						"input[name='webInd'][value='"+strResourceVal+"|"+strSTVal+"|S|"+strStatusesVal+"']", "css")
				.getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select email check box.
	  * Date        : 23/09/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public StatusChangePreference selEmailWebPagerChkBoxForStatuses(String strResourceVal,
			String strSTVal, String strStatusesVal) throws Exception {
		this.selEmailChkBoxForStatuses(strResourceVal, strSTVal, strStatusesVal);
		this.selWebChkBoxForStatuses(strResourceVal, strSTVal, strStatusesVal);
		this.selPagerChkBoxForStatuses(strResourceVal, strSTVal, strStatusesVal);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select email check box.
	  * Date        : 23/09/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public StatusChangePreference selPagerChkBoxForStatuses(String strResourceVal,
			String strSTVal, String strStatusesVal) throws Exception {
		objWaitForElement.waitForElements("input[name='pagerInd'][value='"+strResourceVal+"|"+strSTVal+"|S|"+strStatusesVal+"']", "css");
		this.page
				.element(
						"input[name='pagerInd'][value='"+strResourceVal+"|"+strSTVal+"|S|"+strStatusesVal+"']", "css")
				.getOne().click();
		return this;
	}
	/**********************************************************************************
	  * Description : This function is to verify above and below values
	  * Arguments	: strStatusTypeName, strStatusesName
	  * Date        : 17/Jun/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public StatusChangePreference verValueForMultiST(String strStatusTypeName,
			String strStatusesName) throws Exception {
		objWaitForElement.waitForElements("//td[text()='" + strStatusTypeName
				+ "']/following-sibling::td[text()='" + strStatusesName + "']",
				"xpath");
		assertTrue(
				this.page.element(
						"//td[text()='" + strStatusTypeName
								+ "']/following-sibling::td[text()='"
								+ strStatusesName + "']", "xpath")
						.isElementPresent(), "Value not updated for multi ST");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on delete notifications in edit my status change preference page
	  * Date        : 18/Jun/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public StatusChangePreference clickOnDeleteNotificationInMyStatusChangePreferences(
			String strResName) throws Exception {
		objWaitForElement.waitForElements("//td[text()='" + strResName
				+ "']/preceding-sibling::td/a[text()='delete notifications']", "xpath");
		this.page
				.element(
						"//td[text()='" + strResName
								+ "']/preceding-sibling::td/a[text()='delete notifications']",
						"xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to accept delete notifications pop up
	  * Date        : 18/Jun/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public StatusChangePreference acceptDeleteNotificationPopUp() throws Exception {
		Alert alert = driver.switchTo().alert();
		String strVar = alert.getText();
		System.out.println(strVar);
		assertEquals(
				"Are you sure you would like to delete all status notification preferences for the selected Resource?",
				strVar);
		alert.accept();
		Thread.sleep(3000);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify resource name not displayed in my status change preference page
	  * Date        : 18/Jun/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public StatusChangePreference verResNameNotDisplyadInMyStatusChangePreferences(
			String strResName) throws Exception {
		assertFalse(
				this.page
						.element("//td[text()='" + strResName + "']", "xpath")
						.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE),
				"Resource name is displayed");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify status type is not displayed
	  * Arguments	: strStatusTypeName, strResourceName
	  * Date        : 17/Jun/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public StatusChangePreference verStatusTypesNotDispalyed(
			String strStatusTypeName, String strResourceName) throws Exception {
		assertFalse(
				this.page
						.element(
								"//td[text()='" + strStatusTypeName
										+ "']/preceding-sibling::td[text()='"
										+ strResourceName + "']", "xpath")
						.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE),
				"Status types is displyed");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify status types Not listed under uncategorized.
	  * Date        : 23/09/2014
	  * Author      : Anitha
	  **********************************************************************************/
	public StatusChangePreference verStatusTypesNotDisplayed(
			String strStatusTypesNames) throws Exception {
		assertFalse(this.page.element(
				"//form[@name='form1']/table/tbody/tr/td/div[text()='"
						+ strStatusTypesNames + "']", "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to deselect email check box.
	  * Date        : 23/09/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public StatusChangePreference deselEmailChkBoxForStatuses(String strResourceVal,
			String strSTVal, String strStatusesVal) throws Exception {
		if(this.page
				.element(
						"input[name='emailInd'][value='"+strResourceVal+"|"+strSTVal+"|S|"+strStatusesVal+"']", "css").getOne().isSelected()==true){
			this.page
			.element(
					"input[name='emailInd'][value='"+strResourceVal+"|"+strSTVal+"|S|"+strStatusesVal+"']", "css")
			.getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to deselect email check box.
	  * Date        : 23/09/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public StatusChangePreference deselWebChkBoxForStatuses(String strResourceVal,
			String strSTVal, String strStatusesVal) throws Exception {
		if(this.page
				.element(
						"input[name='webInd'][value='"+strResourceVal+"|"+strSTVal+"|S|"+strStatusesVal+"']", "css").getOne().isSelected()==true){
		this.page
				.element(
						"input[name='webInd'][value='"+strResourceVal+"|"+strSTVal+"|S|"+strStatusesVal+"']", "css")
				.getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to deselect email check box.
	  * Date        : 23/09/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public StatusChangePreference deselPagerChkBoxForStatuses(String strResourceVal,
			String strSTVal, String strStatusesVal) throws Exception {
		if(this.page
				.element(
						"input[name='pagerInd'][value='"+strResourceVal+"|"+strSTVal+"|S|"+strStatusesVal+"']", "css").getOne().isSelected()==true){
		this.page
				.element(
						"input[name='pagerInd'][value='"+strResourceVal+"|"+strSTVal+"|S|"+strStatusesVal+"']", "css")
				.getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to deselect email check box.
	  * Date        : 23/09/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public StatusChangePreference deselEmailWebPagerChkBoxForStatuses(String strResourceVal,
			String strSTVal, String strStatusesVal) throws Exception {
		this.deselEmailChkBoxForStatuses(strResourceVal, strSTVal, strStatusesVal);
		this.deselWebChkBoxForStatuses(strResourceVal, strSTVal, strStatusesVal);
		this.deselPagerChkBoxForStatuses(strResourceVal, strSTVal, strStatusesVal);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify status type is not displayed
	  * Arguments	: strStatusTypeName, strResourceName
	  * Date        : 17/Jun/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public StatusChangePreference verStatusTypeIsDispalyed(
			String strStatusTypeName, String strResourceName) throws Exception {
		objWaitForElement.waitForElements("//td[text()='" + strStatusTypeName
				+ "']/preceding-sibling::td[text()='" + strResourceName + "']",
				"xpath");
		assertTrue(this.page.element(
				"//td[text()='" + strStatusTypeName
						+ "']/parent::tr/parent::tbody/tr/td[text()='" + strResourceName
						+ "']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify status type is not displayed
	  * Arguments	: strStatusTypeName, 
	  * Date        : 17/Jun/2015
	  * Author      : Anitha
	  **********************************************************************************/
	public StatusChangePreference verStatusTypeNotification(
			String strStatusTypeName) throws Exception {
		objWaitForElement.waitForElements("//table/tbody/tr/td[text()='"
				+ strStatusTypeName
				+ "']/following-sibling::td[2][contains(text(),'X')]", "xpath");
		assertTrue(this.page.element(
				"//table/tbody/tr/td[text()='" + strStatusTypeName
						+ "']/following-sibling::td[2][contains(text(),'X')]",
				"xpath").isElementPresent());
		assertTrue(this.page.element(
				"//table/tbody/tr/td[text()='" + strStatusTypeName
						+ "']/following-sibling::td[3][contains(text(),'X')]",
				"xpath").isElementPresent());
		assertTrue(this.page.element(
				"//table/tbody/tr/td[text()='" + strStatusTypeName
						+ "']/following-sibling::td[4][contains(text(),'X')]",
				"xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify status type is not displayed
	  * Arguments	: strStatusTypeName, 
	  * Date        : 17/Jun/2015
	  * Author      : Anitha
	  **********************************************************************************/
	public StatusChangePreference verStatusTypeNotificationBelow(
			String strStatusTypeName) throws Exception {
		objWaitForElement.waitForElements("//table/tbody/tr/td[text()='"
				+ strStatusTypeName
				+ "']/parent::tr/following-sibling::tr[1]/td[5][contains(text(),'X')]", "xpath");
		assertTrue(this.page.element(
				"//table/tbody/tr/td[text()='" + strStatusTypeName
						+ "']/parent::tr/following-sibling::tr[1]/td[5][contains(text(),'X')]",
				"xpath").isElementPresent());
		assertTrue(this.page.element(
				"//table/tbody/tr/td[text()='" + strStatusTypeName
						+ "']/parent::tr/following-sibling::tr[1]/td[6][contains(text(),'X')]",
				"xpath").isElementPresent());
		assertTrue(this.page.element(
				"//table/tbody/tr/td[text()='" + strStatusTypeName
						+ "']/parent::tr/following-sibling::tr[1]/td[7][contains(text(),'X')]",
				"xpath").isElementPresent());
		return this;
	}
	/**********************************************************************************
	  * Description : This function is to select email check box.
	  * Date        : 23/09/2014
	  * Author      : Anitha
	  **********************************************************************************/
	public StatusChangePreference verNotificationChkBoxSelectedForTST(String strResourceVal,
			String strStatusTypesValues) throws Exception {
		objWaitForElement.waitForElements("input[name='emailInd'][value='"
				+ strResourceVal + "|" + strStatusTypesValues + "|T|']", "css");
		
		assertTrue(this.page.element(
						"input[name='emailInd'][value='" + strResourceVal + "|"
								+ strStatusTypesValues + "|T|']", "css").getOne().isSelected());
		assertTrue(this.page.element(
						"input[name='pagerInd'][value='" + strResourceVal + "|"
								+ strStatusTypesValues + "|T|']", "css").getOne().isSelected());
		assertTrue(this.page.element(
						"input[name='webInd'][value='" + strResourceVal + "|"
								+ strStatusTypesValues + "|T|']", "css")
				.getOne().isSelected());
		return this;
	}
	/**********************************************************************************
	  * Description : This function is to click on save
	  * Date        : 23/09/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public StatusChangePreference clickOnCancelNew() throws Exception {
		objWaitForElement.waitForElements(cancel_1, "css");
		this.page.element(cancel_1, "css").getOne().click();
		return this;
	}
	/**********************************************************************************
	  * Description : This function is to select email check box.
	  * Date        : 23/09/2014
	  * Author      : Anitha
	  **********************************************************************************/
	public StatusChangePreference verNotificationChkBoxSelectedForMST(
			String strResourceVal, String strStatusTypesValues,
			String strStatusValue) throws Exception {
		objWaitForElement.waitForElements("input[name='emailInd'][value='"
				+ strResourceVal + "|" + strStatusTypesValues + "|S|']", "css");

		assertTrue(this.page
				.element(
						"input[name='emailInd'][value='" + strResourceVal + "|"
								+ strStatusTypesValues + "|S|" + strStatusValue
								+ "']", "css").getOne().isSelected());
		assertTrue(this.page
				.element(
						"input[name='pagerInd'][value='" + strResourceVal + "|"
								+ strStatusTypesValues + "|S|" + strStatusValue
								+ "']", "css").getOne().isSelected());
		assertTrue(this.page
				.element(
						"input[name='webInd'][value='" + strResourceVal + "|"
								+ strStatusTypesValues + "|S|" + strStatusValue
								+ "']", "css").getOne().isSelected());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select email check box.
	  * Date        : 23/09/2014
	  * Author      : Anil
	  **********************************************************************************/
	public StatusChangePreference verNotificationChkBoxSelectedForOtherAbove(
			String strResourceVal, String strStatusTypesValues)
			throws Exception {
		objWaitForElement
				.waitForElements("input[name='emailInd'][value='"
						+ strResourceVal + "|" + strStatusTypesValues
						+ "|N|A']", "css");

		assertTrue(this.page
				.element(
						"input[name='emailInd'][value='" + strResourceVal + "|"
								+ strStatusTypesValues + "|N|A']", "css")
				.getOne().isSelected());
		assertTrue(this.page
				.element(
						"input[name='pagerInd'][value='" + strResourceVal + "|"
								+ strStatusTypesValues + "|N|A']", "css")
				.getOne().isSelected());
		assertTrue(this.page
				.element(
						"input[name='webInd'][value='" + strResourceVal + "|"
								+ strStatusTypesValues + "|N|A']", "css")
				.getOne().isSelected());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select email check box.
	  * Date        : 23/09/2014
	  * Author      : Anil
	  **********************************************************************************/
	public StatusChangePreference verNotificationChkBoxSelectedForOtherBelow(
			String strResourceVal, String strStatusTypesValues)
			throws Exception {
		objWaitForElement
				.waitForElements("input[name='emailInd'][value='"
						+ strResourceVal + "|" + strStatusTypesValues
						+ "|N|B']", "css");

		assertTrue(this.page
				.element(
						"input[name='emailInd'][value='" + strResourceVal + "|"
								+ strStatusTypesValues + "|N|B']", "css")
				.getOne().isSelected());
		assertTrue(this.page
				.element(
						"input[name='pagerInd'][value='" + strResourceVal + "|"
								+ strStatusTypesValues + "|N|B']", "css")
				.getOne().isSelected());
		assertTrue(this.page
				.element(
						"input[name='webInd'][value='" + strResourceVal + "|"
								+ strStatusTypesValues + "|N|B']", "css")
				.getOne().isSelected());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify no visiblity status type message is displayed
	  * Date        : 23/09/2014
	  * Author      : Anil
	  **********************************************************************************/
	public StatusChangePreference verifyNoVisibilityMessage()
			throws Exception {
		objWaitForElement
				.waitForElements(noVisibleStatusTypeMessage, "xpath");
		assertTrue(this.page
				.element(noVisibleStatusTypeMessage, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify resource type and resource names
	  * Date        : 23/09/2014
	  * Author      : Anil
	  **********************************************************************************/
	public StatusChangePreference verifyRTAndRS(String strResourceType,String strResourceName)
			throws Exception {
		objWaitForElement
				.waitForElements("//h1[@id='r_name'][text()='"+strResourceType+"—"+strResourceName+"']", "xpath");
		assertTrue(this.page
				.element("//h1[@id='r_name'][text()='"+strResourceType+"—"+strResourceName+"']", "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify second selected value under MST
	  * Arguments	: strStatusTypeName, strStatusesName
	  * Date        : 13/Jan/2016
	  * Author      :Sangappa K
	  **********************************************************************************/
	public StatusChangePreference verValueForMultiST2(String strStatusTypeName,
			String strStatusesName) throws Exception {
		objWaitForElement.waitForElements("//td[text()='" + strStatusTypeName
				+ "']/parent::tr/parent::tbody/tr/td[text()='"
				+ strStatusesName + "']", "xpath");
		assertTrue(
				this.page.element(
						"//td[text()='" + strStatusTypeName
								+ "']/parent::tr/parent::tbody/tr/td[text()='"
								+ strStatusesName + "']", "xpath")
						.isElementPresent(), "Value not updated for multi ST2");
		return this;
	}
	
	
	/**********************************************************************************
	  * Description : This function is to Email, Pager, Web cheack boxes are not selected
	  * Date        : 18/01/2016
	  * Author      : Sangappa K
	  **********************************************************************************/
	public StatusChangePreference verEmailPagerWebChkBoxesAreNotSlected(
			String strSTName) throws Exception {

		objWaitForElement.waitForElements("//div[text()='" + strSTName
				+ "']/following::table/tbody/tr/td/input[@name='emailInd']",
				"xpath");

		assertTrue(!this.page
				.element(
						"//div[text()='"
								+ strSTName
								+ "']/following::table/tbody/tr/td/input[@name='emailInd']",
						"xpath").getOne().isSelected());
		assertTrue(!this.page
				.element(
						"//div[text()='"
								+ strSTName
								+ "']/following::table/tbody/tr/td/input[@name='pagerInd']",
						"xpath").getOne().isSelected());
		assertTrue(!this.page
				.element(
						"//div[text()='"
								+ strSTName
								+ "']/following::table/tbody/tr/td/input[@name='webInd']",
						"xpath").getOne().isSelected());
		return this;

	}

	/**********************************************************************************
	  * Description : This function is to deSelect email check box.
	  * Date        : 09-Feb-2016
	  * Author      : Pallavi
	  **********************************************************************************/
	public StatusChangePreference deSelEmailChkBoxForAboveAndBelowVal(
			String strResourceVal, String strStatusTypesValues)
			throws Exception {
		objWaitForElement
				.waitForElements("input[name='emailInd'][value='"
						+ strResourceVal + "|" + strStatusTypesValues
						+ "|N|A']", "css");
		String strAboveEle = "input[name='emailInd'][value='" + strResourceVal
				+ "|" + strStatusTypesValues + "|N|A']";
		String strBelowEle = "input[name='emailInd'][value='" + strResourceVal
				+ "|" + strStatusTypesValues + "|N|B']";
		if (this.page.element(strAboveEle, "css").getOne().isSelected()) {
			this.page.element(strAboveEle, "css").getOne().click();
			assertFalse(this.page.element(strAboveEle, "css").getOne()
					.isSelected());
		}
		if (this.page.element(strBelowEle, "css").getOne().isSelected()) {
			this.page.element(strBelowEle, "css").getOne().click();
			assertFalse(this.page.element(strBelowEle, "css").getOne()
					.isSelected());
		}
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to deSelect pager check box.
	  * Date        : 09-Feb-2016
	  * Author      : Pallavi
	  **********************************************************************************/
	public StatusChangePreference deSelPagerChkBoxForAboveAndBelowVal(
			String strResourceVal, String strStatusTypesValues)
			throws Exception {
		String strAboveEle = "input[name='pagerInd'][value='" + strResourceVal
				+ "|" + strStatusTypesValues + "|N|A']";
		String strBelowEle = "input[name='pagerInd'][value='" + strResourceVal
				+ "|" + strStatusTypesValues + "|N|B']";
		objWaitForElement.waitForElements(strAboveEle, "css");
		if (this.page.element(strAboveEle, "css").getOne().isSelected()) {
			this.page.element(strAboveEle, "css").getOne().click();
			assertFalse(this.page.element(strAboveEle, "css").getOne()
					.isSelected());
		}
		objWaitForElement.waitForElements(strBelowEle, "css");
		if (this.page.element(strBelowEle, "css").getOne().isSelected()) {
			this.page.element(strBelowEle, "css").getOne().click();
			assertFalse(this.page.element(strBelowEle, "css").getOne()
					.isSelected());
		}
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to deselect web check box.
	  * Date        : 09-Feb-2016
	  * Author      : Pallavi
	  **********************************************************************************/
	public StatusChangePreference deselWebChkBoxForAboveAndBelowVal(String strResourceVal,
			String strStatusTypesValues) throws Exception {
		String strAboveEle = "input[name='webInd'][value='" + strResourceVal + "|"
				+ strStatusTypesValues + "|N|A']";
		String strBelowEle = "input[name='webInd'][value='" + strResourceVal + "|"
				+ strStatusTypesValues + "|N|B']";
		objWaitForElement.waitForElements(strAboveEle, "css");
		if(this.page.element(strAboveEle, "css").getOne().isSelected()) {
			this.page.element(strAboveEle, "css").getOne().click();
			assertFalse(this.page.element(strAboveEle, "css").getOne()
					.isSelected());
		}
		objWaitForElement.waitForElements(strBelowEle, "css");
		if (this.page.element(strBelowEle, "css").getOne().isSelected()) {
			this.page.element(strBelowEle, "css").getOne().click();
			assertFalse(this.page.element(strBelowEle, "css").getOne()
					.isSelected());
		}
		return this;
	}
}
