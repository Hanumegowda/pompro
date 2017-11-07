package lib.page;

import org.openqa.selenium.WebDriver;

import static org.testng.Assert.*;
import qaframework.lib.WaitTimeConstants;
import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;

public class Upload extends PageObject {
	
	WebDriver driver;
	WaitForElement objWaitForElement ;
	
	//Locators
	private String headerName 			= "div#topSubNav > h1",
			uploadTemplate		 		= "Upload Template",
			uploadResourceBtn 			= "input[value='Upload Resources']",
			browserBtn 					= "//div[@id='mainContainer']/form/table/tbody/tr/td[text()='No file attached']/input[2]",
			spreadSheetAndBrowserBtn 	= "//td[@class='emsLabel'][text()='Spreadsheet:']/following-sibling::td[text()='No file attached']/input[2]/following-sibling::span[text()='Only .xls files are allowed. Maximum file size is 5 megabytes (MB).']",
			test 						= "//td[@class='emsLabel'][text()='Test?:']/following-sibling::td[contains(text(),'If selected, then the system will not actually create Resources.')]",
			saveBtn 					= "input[value='Save']",
			returnInUploadDetPage  		= "input[value='Return']",
			deselectTestCheckbox 		= "input[name='test']",
			uploadFileName				= "//td[contains(text(),'Spreadsheet')]/following-sibling::td/input[@name='spreadsheetName'][@disabled='disabled']",
			testCheckbox  				= "//input[@name='test'][@disabled='disabled']/parent::td/preceding-sibling::td[text()='Test?:']",
			returnBtn					= "input[value='Return']",
			resourceId                  = "//table[@class='displayTable striped border sortable']/tbody/tr/td[2]/a",
			uploadListHeader            = "//div[@id='mainContainer']/table/thead/tr/th[text()='Action']/following-sibling::th[1]/a[text()='Test?']/parent::th/following-sibling::th[1]/a[text()='Date']/parent::th/following-sibling::th[1]/a[text()='User']",
			browseInputField            = "document";
   
	public Upload(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Upload List' page is displayed
	  * Date        : 26/09/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public Upload verUploadListPageIsDisplayed() throws Exception {
		objWaitForElement.waitForElements(headerName, "css");
		assertEquals("Upload List", this.page.element(headerName, "css")
				.getOne().getText(), "Upload List page is not displayed.");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Upload Template' link is displayed
	  * Date        : 26/09/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public Upload verUploadTemplateIsDisplayed() throws Exception {
		objWaitForElement.waitForElements(uploadTemplate, "linktext");
		assertTrue(this.page.element(uploadTemplate, "linktext")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Upload Resource' button is displayed
	  * Date        : 26/09/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public Upload verUploadResourceBtnIsDisplayed() throws Exception {
		objWaitForElement.waitForElements(uploadResourceBtn, "css");
		assertTrue(this.page.element(uploadResourceBtn, "css")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on 'Upload Template' link 
	  * Date        : 26/09/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public Upload clickOnUploadTemplateLink() throws Exception {
		objWaitForElement.waitForElements(uploadTemplate, "linktext");
		this.page.element(uploadTemplate, "linktext").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on 'Upload Resource' button
	  * Date        : 26/09/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public Upload clickOnUploadResourceBtn() throws Exception {
		objWaitForElement.waitForElements(uploadResourceBtn, "css");
		this.page.element(uploadResourceBtn, "css").getOne().click();
		try{
			if(this.page.element("//div[@id='topSubNav']/h1[text()='New Upload']", "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE)==false){
				this.page.element(uploadResourceBtn, "css").clickUsingJSE();
			}
		}catch(Exception e) {
			
		}
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'New Upload' page is displayed
	  * Date        : 26/09/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public Upload verNewUploadPageIsDisplayed() throws Exception {
		objWaitForElement.waitForElements("//div[@id='topSubNav']/h1[text()='New Upload']", "xpath");
		assertTrue(this.page.element("//div[@id='topSubNav']/h1[text()='New Upload']", "xpath").isElementPresent(), "New Upload page is not displayed.");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to 'Upload a file'
	 * Date        : 30/07/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public Upload uploadFile(String strPathOfTheFile)
			throws Exception {
		objWaitForElement.waitForElements(browserBtn, "xpath");
		this.page.element(browserBtn, "xpath").getOne().sendKeys(strPathOfTheFile);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Spread sheet and Browser button' is displayed
	  * Date        : 26/09/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public Upload verSpreadSheetAndBrowserBtnIsDisplayed() throws Exception {
		objWaitForElement.waitForElements(spreadSheetAndBrowserBtn, "xpath");
		assertTrue(this.page.element(spreadSheetAndBrowserBtn, "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Test' is displayed
	  * Date        : 26/09/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public Upload verTestIsDisplayed() throws Exception {
		objWaitForElement.waitForElements(test, "xpath");
		assertTrue(this.page.element(test, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on 'Upload Resource' button
	  * Date        : 26/09/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public Upload clickOnSaveBtn() throws Exception {
		objWaitForElement.waitForElements(saveBtn, "css");
		this.page.element(saveBtn, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Row' in Upload detail page
	  * Date        : 26/09/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public Upload verRowInUploadDetails(String strRow) throws Exception {
		objWaitForElement.waitForElements("//table[@summary='Upload Details']/thead/tr/th/a[text()='Row']/ancestor::table/tbody/tr/td[1][text()='"
				+ strRow + "']", "xpath");
		assertTrue(this.page
				.element(
						"//table[@summary='Upload Details']/thead/tr/th/a[text()='Row']/ancestor::table/tbody/tr/td[1][text()='"
								+ strRow + "']", "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Resource ID' in Upload detail page
	  * Date        : 26/09/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public Upload verResourceIDInUploadDetails(String strResourceID)
			throws Exception {
		objWaitForElement.waitForElements("//table[@summary='Upload Details']/thead/tr/th[2]/a[text()='Resource ID']/ancestor::table/tbody/tr/td[2][text()='"
				+ strResourceID + "']", "xpath");
		assertTrue(this.page
				.element(
						"//table[@summary='Upload Details']/thead/tr/th[2]/a[text()='Resource ID']/ancestor::table/tbody/tr/td[2][text()='"
								+ strResourceID + "']", "xpath")
				.getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on 'Return' in Upload Detail Page
	  * Date        : 26/09/2014
	  * Author      : Prasanna Lakshmi
	  **********************************************************************************/
	public Upload clickOnReturnInUploadDetPage() throws Exception {
		objWaitForElement.waitForElements(returnInUploadDetPage, "css");
		this.page.element(returnInUploadDetPage, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to Deselect Test? CheckBox
	   * Date        : 26/09/2014
	   * Author      : Prasanna Lakshmi
	   **********************************************************************************/
	public Upload deselectTestCheckBox() throws Exception 
	{
		objWaitForElement.waitForElements(deselectTestCheckbox, "css");
	if(this.page.element(deselectTestCheckbox, "css").getOne().isSelected() == true)
	{
		this.page.element(deselectTestCheckbox, "css").getOne().click();
	}
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Upload Detail Page is displayed 
	  * Date        : 26/09/2014
	  * Author      : Prasanna Lakshmi
	  **********************************************************************************/
	 public Upload verUploadDetaillPageisDisplayed() throws Exception {
		 objWaitForElement.waitForElements(headerName, "css");
	  	  assertEquals("Upload Details", this.page.element(headerName, "css").getOne().getText());
	  return this;
	 }
	 
	 /**********************************************************************************
	  * Description : This function is to verify 'Spreadsheet' and its 'Value' in Upload Details Page
	  * Arguments	: strFileName
	  * Date        : 26/09/2014
	  * Author      : Prasanna Lakshmi
	  **********************************************************************************/
	public Upload verUploadedFilename(String strFileName) throws Exception {
		 objWaitForElement.waitForElements(uploadFileName, "xpath");
		assertTrue(this.page.element(uploadFileName, "xpath")
				.getOne().isDisplayed());
		String strFileNameInApp = this.page.element(uploadFileName, "xpath")
				.getOne().getAttribute("value");
		assertTrue(strFileNameInApp.contains(strFileName));
		return this;
	}
	
	 /**********************************************************************************
	  * Description : This function is to verify 'Test?.' and its 'Checkbox is checked' in Upload Details Page
	  * Arguments	: strFileName
	  * Date        : 26/09/2014
	  * Author      : Prasanna Lakshmi
	  **********************************************************************************/
	public Upload verTestCheckboxIsChecked() throws Exception {
		 objWaitForElement.waitForElements(testCheckbox , "xpath");
		assertTrue(this.page.element(testCheckbox , "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Test?.' and its 'Checkbox is Unchecked' in Upload Details Page
	  * Arguments	: strFileName
	  * Date        : 26/09/2014
	  * Author      : Prasanna Lakshmi
	  **********************************************************************************/
	public Upload verTestCheckboxIsUnchecked() throws Exception {
		objWaitForElement.waitForElements(deselectTestCheckbox , "css");
		assertFalse(this.page.element(deselectTestCheckbox , "css").getOne().isSelected());
		return this;
	}
	
	 /**********************************************************************************
	  * Description : This function is to verify 'User' and its 'Value' in Upload Details Page
	  * Arguments	: strFileName
	  * Date        : 26/09/2014
	  * Author      : Prasanna Lakshmi
	  **********************************************************************************/
	public Upload verUserName(String strUserName) throws Exception {
		objWaitForElement.waitForElements("//td[contains(text(),'User')]/following-sibling::td/input[@value='"+ strUserName + "'][@disabled='disabled']", "xpath");
		assertTrue(this.page.element("//td[contains(text(),'User')]/following-sibling::td/input[@value='"+ strUserName + "'][@disabled='disabled']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Date' and its 'Value' in Upload Details Page
	  * Arguments	: StrDate
	  * Date        : 26/09/2014
	  * Author      : Prasanna Lakshmi
	  **********************************************************************************/
	public Upload verDate(String strDate) throws Exception {
		objWaitForElement.waitForElements("//td[text()='Date:']/following-sibling::td/input[@value='"+strDate+"'][@disabled='disabled']", "xpath");
		assertTrue(this.page.element("//td[text()='Date:']/following-sibling::td/input[@value='"+strDate+"'][@disabled='disabled']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on User HpyerLink under UserID Column
	  * Arguments	: strUserName
	  * Date        : 26/09/2014
	  * Author      : Prasanna Lakshmi
	  **********************************************************************************/
	public Upload clickOnUserName(String strUserName) throws Exception {
		objWaitForElement.waitForElements(strUserName, "linktext");
		this.page.element(strUserName, "linktext").getOne().click();
		return this;
	}
	
	
	/**********************************************************************************
	  * Description : This function is to verify 'Resource Name' in Upload detail page
	  * Date        : 26/09/2014
	  * Author      : Rensuhree
	  **********************************************************************************/
	public Upload verResourceNameInUploadDetails(String strResourceName)
			throws Exception {
		objWaitForElement.waitForElements("//table[@summary='Upload Details']/thead/tr/th[3]/a[text()='Resource Name']/ancestor::table/tbody/tr/td[3]", "xpath");
		String strResName =this.page
				.element(
						"//table[@summary='Upload Details']/thead/tr/th[3]/a[text()='Resource Name']/ancestor::table/tbody/tr/td[3]", "xpath").getOne().getText();
		assertEquals(strResourceName, strResName);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Failed' in Upload detail page
	  * Date        : 26/09/2014
	  * Author      : Rensuhree
	  **********************************************************************************/
	public Upload verFailedInUploadDetails(String strYesOrNoValue)
			throws Exception {
		objWaitForElement.waitForElements("//table[@summary='Upload Details']/thead/tr/th[4]/a[text()='Failed']/ancestor::table/tbody/tr/td[4][text()='"+strYesOrNoValue+"']", "xpath");
		assertTrue(this.page
				.element(
						"//table[@summary='Upload Details']/thead/tr/th[4]/a[text()='Failed']/ancestor::table/tbody/tr/td[4][text()='"+strYesOrNoValue+"']", "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'GeoCode' in Upload detail page
	  * Date        : 26/09/2014
	  * Author      : Rensuhree
	  **********************************************************************************/
	public Upload verGeocodeInUploadDetails(String strGeoCodeValue)
			throws Exception {
		objWaitForElement.waitForElements("//table[@summary='Upload Details']/thead/tr/th[5]/a[text()='Geocode']/ancestor::table/tbody/tr/td[5]", "xpath");
		String strGeoCode = this.page
				.element(
						"//table[@summary='Upload Details']/thead/tr/th[5]/a[text()='Geocode']/ancestor::table/tbody/tr/td[5]", "xpath")
				.getOne().getText();
		assertEquals(strGeoCodeValue,strGeoCode);
		return this;
	}
	
	
	/**********************************************************************************
	  * Description : This function is to verify 'ResourceComments' in Upload detail page
	  * Date        : 26/09/2014
	  * Author      : Rensuhree
	  **********************************************************************************/
	public Upload verResCommentsInUploadDetails(String strRescomments)
			throws Exception {
		objWaitForElement.waitForElements("//table[@summary='Upload Details']/thead/tr/th[6]/a[text()='Resource Comments']/ancestor::table/tbody/tr/td[6][text()='"
				+ strRescomments + "']", "xpath");
		assertTrue(this.page
				.element(
						"//table[@summary='Upload Details']/thead/tr/th[6]/a[text()='Resource Comments']/ancestor::table/tbody/tr/td[6][text()='"
								+ strRescomments + "']", "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'UserID' in Upload detail page
	 * Date : 26/09/2014 Author : Rensuhree
	 **********************************************************************************/
	public Upload verUserIDInUploadDetails(String strUserID) throws Exception {
		objWaitForElement
				.waitForElements(
						"//table[@summary='Upload Details']/thead/tr/th[7]/a[text()='User ID']/ancestor::table/tbody/tr/td[7]",
						"xpath");
		String strFetchedUserID = this.page
				.element(
						"//table[@summary='Upload Details']/thead/tr/th[7]/a[text()='User ID']/ancestor::table/tbody/tr/td[7]",
						"xpath").getOne().getText();
		assertEquals(strUserID, strFetchedUserID);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'UserFullName' in Upload detail page
	  * Date        : 26/09/2014
	  * Author      : Rensuhree
	  **********************************************************************************/
	public Upload verUserFullNameInUploadDetails(String strUserFullName)
			throws Exception {
		objWaitForElement.waitForElements("//table[@summary='Upload Details']/thead/tr/th[8]/a[text()='Full Name']/ancestor::table/tbody/tr/td[8]",
				"xpath");
		String strFetchedUserFulName = this.page
				.element(
						"//table[@summary='Upload Details']/thead/tr/th[8]/a[text()='Full Name']/ancestor::table/tbody/tr/td[8]",
						"xpath").getOne().getText();
		assertEquals(strUserFullName, strFetchedUserFulName);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'User Failed' in Upload detail page
	  * Date        : 26/09/2014
	  * Author      : Rensuhree
	  **********************************************************************************/
	public Upload verUserFailedInUploadDetails(String strYesOrNoValue) throws Exception {
		objWaitForElement.waitForElements("//table[@summary='Upload Details']/thead/tr/th[9]/a[text()='Failed']/ancestor::table/tbody/tr/td[9][text()='"
				+ strYesOrNoValue + "']", "xpath");
		assertTrue(this.page
				.element(
						"//table[@summary='Upload Details']/thead/tr/th[9]/a[text()='Failed']/ancestor::table/tbody/tr/td[9][text()='"
								+ strYesOrNoValue + "']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'User Comments' in Upload detail page
	  * Date        : 26/09/2014
	  * Author      : Rensuhree
	  **********************************************************************************/
	public Upload verUserCommentsInUploadDetails(String strUserComments)
			throws Exception {
		objWaitForElement.waitForElements("//table[@summary='Upload Details']/thead/tr/th[10]/a[text()='User Comments']/ancestor::table/tbody/tr/td[10][text()='"
				+ strUserComments + "']", "xpath");
		assertTrue(this.page
				.element(
						"//table[@summary='Upload Details']/thead/tr/th[10]/a[text()='User Comments']/ancestor::table/tbody/tr/td[10][text()='"
								+ strUserComments + "']", "xpath")
				.getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify return in Upload detail page
	  * Date        : 26/09/2014
	  * Author      : Rensuhree
	  **********************************************************************************/
	public Upload verReturnInUploadDetails() throws Exception {
		objWaitForElement.waitForElements(returnBtn, "css");
		assertTrue(this.page.element(returnBtn, "css").getOne().isDisplayed());
		return this;
	}

	 
	 /**********************************************************************************
	  * Description : This function is to click on view detail of respective upload
	  * Date        : 26/09/2014
	  * Author      : Rensuhree
	  **********************************************************************************/
	public Upload clickOnViewDetails(String strDate) throws Exception {
		objWaitForElement.waitForElements("//table[@summary='Uploads']/tbody/tr/td[3][text()='"
				+ strDate
				+ "']/preceding-sibling::td[2]/a[text()='View Details']",
		"xpath");
		this.page
				.element(
						"//table[@summary='Uploads']/tbody/tr/td[3][text()='"
								+ strDate
								+ "']/preceding-sibling::td[2]/a[text()='View Details']",
						"xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify user is not hyperlinked.
	  * Date        : 26/09/2014
	  * Author      : Rensuhree
	  **********************************************************************************/
	public Upload verUserIsNotHyperLinked(String strUserName) throws Exception {
		assertFalse(this.page.element(strUserName, "linktext").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'UserID' Link in Upload detail page
	  * Date        : 29/09/2014
	  * Author      : Prasanna Lakshmi
	  **********************************************************************************/
	public Upload verUserIDLinkInUploadDetails(String strUserID) throws Exception {
		objWaitForElement.waitForElements("//table[@summary='Upload Details']/thead/tr/th[7]/a[text()='User ID']/ancestor::table/tbody/tr/td[7]/a[text()='"
				+ strUserID + "']", "xpath");
		assertTrue(this.page
				.element(
						"//table[@summary='Upload Details']/thead/tr/th[7]/a[text()='User ID']/ancestor::table/tbody/tr/td[7]/a[text()='"
								+ strUserID + "']", "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on  Resource ID in Upload page
	  * Date        : 29/09/2014
	  * Author      : Shradha
	  **********************************************************************************/
		public Upload clickOnResourceId(String strResourceName) throws Exception {
			objWaitForElement.waitForElements( "//div[@id='mainContainer']/form/table[2]/tbody/tr/td[3][text()='"+strResourceName+"']/preceding-sibling::td/a",
				      "xpath");
		  this.page
		    .element(
		      "//div[@id='mainContainer']/form/table[2]/tbody/tr/td[3][text()='"+strResourceName+"']/preceding-sibling::td/a",
		      "xpath").getOne().click();
		  return this;
	 }
	/**********************************************************************************
	  * Description : This function is to click on 'Return' button in Upload detail page
	  * Date        : 08/10/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public Upload clickOnReturnInUploadDetails() throws Exception {
		objWaitForElement.waitForElements(returnBtn, "css");
		this.page.element(returnBtn, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to get the Resource ID in Upload page
	  * Date        : 09/10/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public String getResourceIdInUploadDetails() throws Exception {
		objWaitForElement.waitForElements(resourceId, "xpath");
		String strResourceID = this.page.element(resourceId, "xpath").getOne()
				.getText();
		return strResourceID;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify ResourceId is  hyperlinked.
	  * Date        : 06/10/2014
	  * Author      : shradha
	  **********************************************************************************/
	public Upload verResourceIdIsHperlinked(String strResourceName)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/form/table[2]/tbody/tr/td[3][text()='"
				+ strResourceName
				+ "']/preceding-sibling::td/a[contains(@href,'resourceID')]",
		"xpath");
		assertTrue(this.page
				.element(
						"//div[@id='mainContainer']/form/table[2]/tbody/tr/td[3][text()='"
								+ strResourceName
								+ "']/preceding-sibling::td/a[contains(@href,'resourceID')]",
						"xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify UserID is  hyperlinked.
	  * Date        : 06/10/2014
	  * Author      : shradha
	  **********************************************************************************/
	public Upload verUserIdIsHperlinked(String strUserName ) throws Exception{
		objWaitForElement.waitForElements(strUserName, "linktext");
		assertTrue(this.page.element(strUserName, "linktext").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Upload list Headers
	  * Date        : 28/07/2015
	  * Author      : Sowmya
	  **********************************************************************************/
	public Upload verUploadListHeaders() throws Exception {
		assertTrue(this.page.element(uploadListHeader, "xpath")
				.isElementPresent());
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to verify UserList values
	  * Date        : 28/07/2015
	  * Author      : Sowmya
	  **********************************************************************************/
	public Upload verUploadListDetails(String strUser, String strDate,
			String strTest) throws Exception {
		assertTrue(this.page.element(
				"//div[@id='mainContainer']/table/tbody/tr/td[4][text()='"
						+ strUser + "']/preceding-sibling::td[1][text()='"
						+ strDate + "']/preceding-sibling::td[1][text()='"
						+ strTest
						+ "']/preceding-sibling::td/a[text()='View Details']",
				"xpath").isElementPresent());
		return this;
	}
	
	 /**********************************************************************************
	  * Description : This function is to verify 'Spreadsheet' and its 'Value' in Upload Details Page
	  * Arguments	: strFileName
	  * Date        : 26/09/2014
	  * Author      : Prasanna Lakshmi
	  **********************************************************************************/
	public Upload verUploadedFilenameBeforeSave(String strFileName) throws Exception {
		 objWaitForElement.waitForElements(browseInputField, "name");
		assertTrue(this.page.element(browseInputField, "name")
				.getOne().isDisplayed());
		String strFileNameInApp = this.page.element(browseInputField, "name")
				.getOne().getAttribute("value");
		assertTrue(strFileNameInApp.contains(strFileName));
		return this;
	}
	
	/************************************************************************************************************
	  * Description : This function is to verify 'Test?.' and its 'Checkbox is checked' in Upload Details Page
	  * Arguments	: strFileName
	  * Date        : 30/07/2015
	  * Author      : Sowmya
	  **********************************************************************************************************/
	public Upload verTestCheckboxIsCheckedBeforeSave() throws Exception {
		objWaitForElement.waitForElements(deselectTestCheckbox, "css");
		assertTrue(this.page.element(deselectTestCheckbox, "css").getOne()
				.isSelected());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify resources 'Failed' in Upload detail page
	  * Date        : 30-Jul-2015
	  * Author      : Deepa
	  **********************************************************************************/
	public Upload verResFailedInUploadDetails(String[] strResName,
			String[] strFailedvalue) throws Exception {
		for (int i = 0; i < strResName.length; i++) {
			assertTrue(this.page
					.element(
							"//table[@summary='Upload Details']/thead/tr/th[4]/a[text()='Failed']/ancestor::table/tbody/tr/td[3][text()='"
									+ strResName[i]
									+ "']/parent::tr/td[4][text()='"
									+ strFailedvalue[i] + "']", "xpath")
					.isElementPresent());
		}
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify resources 'Failed' comment
	  * Date        : 30-Jul-2015
	  * Author      : Deepa
	  **********************************************************************************/
	public Upload verDuplicateResComment(String strResName) throws Exception {
		String strComment = this.page
				.element(
						"//table[@summary='Upload Details']/thead/tr/th[4]/a[text()='Failed']/ancestor::table/tbody/tr/td[3][text()='"
								+ strResName + "']/parent::tr/td[4][text()='Yes']/parent::tr/td[6]", "xpath")
				.getOne().getText();
		assertTrue(strComment.contains("duplicates resource"));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'User Comments' in Upload detail page
	  * Date        : 26/09/2014
	  * Author      : Rensuhree
	  **********************************************************************************/
	public Upload verUserCommentsInUploadDetailsRowWise(String strUserComments,
			int row) throws Exception {
		objWaitForElement
				.waitForElements(
						"//table[@summary='Upload Details']/thead/tr/th[10]/a[text()='User Comments']/ancestor::table/tbody/tr["
								+ row
								+ "]/td[10][text()='"
								+ strUserComments
								+ "']", "xpath");
		assertTrue(this.page
				.element(
						"//table[@summary='Upload Details']/thead/tr/th[10]/a[text()='User Comments']/ancestor::table/tbody/tr["
								+ row
								+ "]/td[10][text()='"
								+ strUserComments
								+ "']", "xpath").getOne().isDisplayed());
		return this;
	}
	/**********************************************************************************
	  * Description : This function is to verify 'User Failed' in Upload detail page
	  * Date        : 26/09/2014
	  * Author      : Rensuhree
	  **********************************************************************************/
	public Upload verUserDeatailsInUploadDetails(String strYesOrNoValue, int row)
			throws Exception {
		objWaitForElement
				.waitForElements(
						"//table[@summary='Upload Details']/thead/tr/th[9]/a[text()='Failed']/ancestor::table/tbody/tr["
								+ row
								+ "]/td[9][text()='"
								+ strYesOrNoValue
								+ "']", "xpath");
		assertTrue(this.page
				.element(
						"//table[@summary='Upload Details']/thead/tr/th[9]/a[text()='Failed']/ancestor::table/tbody/tr["
								+ row
								+ "]/td[9][text()='"
								+ strYesOrNoValue
								+ "']", "xpath").isElementPresent());
		return this;
	}
	/**********************************************************************************
	  * Description : This function is to verify 'User Comments' in Upload detail page
	  * Date        : 26/09/2014
	  * Author      : Anitha
	  **********************************************************************************/
	public Upload verUserComments(String strUserComments, int row)
			throws Exception {
		String struser = this.page
				.element(
						"//table[@summary='Upload Details']/thead/tr/th[10]/a[text()='User Comments']/ancestor::table/tbody/tr["
								+ row
								+ "]/td[10]", "xpath").getOne().getText();
		assertTrue(struser.equals(strUserComments));
		return this;
	}
	/**********************************************************************************
	  * Description : This function is to verify 'Resource Name' in Upload detail page
	  * Date        : 26/09/2014
	  * Author      : Rensuhree
	  **********************************************************************************/
	public Upload verResourceNameInUploadDetailsRowWise(String strResourceName,
			int row) throws Exception {
		objWaitForElement
				.waitForElements(
						"//table[@summary='Upload Details']/thead/tr/th[3]/a[text()='Resource Name']/ancestor::table/tbody/tr["
								+ row + "]/td[3]", "xpath");
		String strResName = this.page
				.element(
						"//table[@summary='Upload Details']/thead/tr/th[3]/a[text()='Resource Name']/ancestor::table/tbody/tr["
								+ row + "]/td[3]", "xpath").getOne().getText();
		assertEquals(strResourceName, strResName);
		return this;
	}
	/**********************************************************************************
	  * Description : This function is to verify 'Resource ID' in Upload detail page
	  * Date        : 26/09/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public Upload verResourceIDInUploadDetailsRowWise(String strResourceID,
			int row) throws Exception {
		objWaitForElement
				.waitForElements(
						"//table[@summary='Upload Details']/thead/tr/th[2]/a[text()='Resource ID']/ancestor::table/tbody/tr["
								+ row
								+ "]/td[2]/a[text()='"
								+ strResourceID
								+ "']", "xpath");
		assertTrue(this.page
				.element(
						"//table[@summary='Upload Details']/thead/tr/th[2]/a[text()='Resource ID']/ancestor::table/tbody/tr["
								+ row
								+ "]/td[2]/a[text()='"
								+ strResourceID
								+ "']", "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Failed' in Upload detail page
	  * Date        : 26/09/2014
	  * Author      : Rensuhree
	  **********************************************************************************/
	public Upload verFailedInUploadDetailsRowWise(String strYesOrNoValue, int row)
			throws Exception {
		objWaitForElement
				.waitForElements(
						"//table[@summary='Upload Details']/thead/tr/th[4]/a[text()='Failed']/ancestor::table/tbody/tr["
								+ row
								+ "]/td[4][text()='"
								+ strYesOrNoValue
								+ "']", "xpath");
		assertTrue(this.page
				.element(
						"//table[@summary='Upload Details']/thead/tr/th[4]/a[text()='Failed']/ancestor::table/tbody/tr["
								+ row
								+ "]/td[4][text()='"
								+ strYesOrNoValue
								+ "']", "xpath").isElementPresent());
		return this;
	}
	/**********************************************************************************
	  * Description : This function is to verify 'GeoCode' in Upload detail page
	  * Date        : 26/09/2014
	  * Author      : Rensuhree
	  **********************************************************************************/
	public Upload verGeocodeInUploadDetailsRowWise(String strGeoCodeValue,
			int row) throws Exception {
		objWaitForElement
				.waitForElements(
						"//table[@summary='Upload Details']/thead/tr/th[5]/a[text()='Geocode']/ancestor::table/tbody/tr["
								+ row + "]/td[5]", "xpath");
		String strGeoCode = this.page
				.element(
						"//table[@summary='Upload Details']/thead/tr/th[5]/a[text()='Geocode']/ancestor::table/tbody/tr["
								+ row + "]/td[5]", "xpath").getOne().getText();
		assertEquals(strGeoCodeValue, strGeoCode);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'ResourceComments' in Upload detail page
	  * Date        : 26/09/2014
	  * Author      : Rensuhree
	  **********************************************************************************/
	public Upload verResCommentsInUploadDetailsRowWise(String strRescomments,
			int row) throws Exception {
		objWaitForElement
				.waitForElements(
						"//table[@summary='Upload Details']/thead/tr/th[6]/a[text()='Resource Comments']/ancestor::table/tbody/tr["
								+ row
								+ "]/td[6][text()='"
								+ strRescomments
								+ "']", "xpath");
		assertTrue(this.page
				.element(
						"//table[@summary='Upload Details']/thead/tr/th[6]/a[text()='Resource Comments']/ancestor::table/tbody/tr["
								+ row
								+ "]/td[6][text()='"
								+ strRescomments
								+ "']", "xpath").isElementPresent());
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify 'UserID' in Upload detail page
	 * Date        : 26/09/2014 
	 * Author      : Rensuhree
	 **********************************************************************************/
	public Upload verUserIDInUploadDetailsRowWise(String strUserID, int row)
			throws Exception {
		objWaitForElement
				.waitForElements(
						"//table[@summary='Upload Details']/thead/tr/th[7]/a[text()='User ID']/ancestor::table/tbody/tr["
								+ row + "]/td[7]/a", "xpath");
		String strFetchedUserID = this.page
				.element(
						"//table[@summary='Upload Details']/thead/tr/th[7]/a[text()='User ID']/ancestor::table/tbody/tr["
								+ row + "]/td[7]/a", "xpath").getOne().getText();
		assertEquals(strUserID, strFetchedUserID);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'UserFullName' in Upload detail page
	  * Date        : 26/09/2014
	  * Author      : Rensuhree
	  **********************************************************************************/
	public Upload verUserFullNameInUploadDetailsRowWise(String strUserFullName,
			int row) throws Exception {
		objWaitForElement
				.waitForElements(
						"//table[@summary='Upload Details']/thead/tr/th[8]/a[text()='Full Name']/ancestor::table/tbody/tr["
								+ row + "]/td[8]", "xpath");
		String strFetchedUserFulName = this.page
				.element(
						"//table[@summary='Upload Details']/thead/tr/th[8]/a[text()='Full Name']/ancestor::table/tbody/tr["
								+ row + "]/td[8]", "xpath").getOne().getText();
		assertEquals(strUserFullName, strFetchedUserFulName);
		return this;
	}
}