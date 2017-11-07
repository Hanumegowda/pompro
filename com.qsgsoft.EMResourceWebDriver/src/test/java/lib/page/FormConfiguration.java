package lib.page;

import static org.junit.Assert.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import qaframework.lib.WaitTimeConstants;
import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;

public class FormConfiguration extends PageObject{
	
	WebDriver driver;
		Date_Time_settings objDts = new Date_Time_settings();
	WaitForElement objWaitForElement;
	
	private String title =" input[name='title']", discription ="textarea[name='description']",
			checkBoxInForm = "promptType",
			createNewFormTemplete = "input[value='Create New Form Template']",
			certainStatusChangeOption = "select[name='promptType']",
			nextButton = "input[value='Next']",
			headerName = "div#topSubNav > h1",
			intermedixLogo = "//div/h1[text()='Intermedix']",
			groupLink = "//ul/li/a[text()='Group']",
			insertLink = "//a/span[@class='caret']",
			editGroupTable = "#editGroupLabel",
			groupName = "//div[@class='controls controls-row']/span/input[@type='text']",
			groupDoneButton = "//div[@data-bind='with: groupToEditView']/button[text()='Save']",
			editFieldSetWindow = "//h3[@id='editElementSetLabel'][text()='Edit FieldSet']",
			attributesLabel = "//div[@id='editElementSetModal']//input",
			editFieldSetDoneButton = "//div[@data-bind='with: elementSetToEditView']/button[text()='Save']",
			editQuestion = "//h3/span[text()='Edit Question']",
			questionaireType = "//div[@class='controls controls-row']/select",
			labelName = "//label[text()='Label']/parent::div//span/input",
			addToSummary = "//label[text()='Add to Summary']/parent::div//input",
	    	saveButton = "//button[contains(text(),'Save')]",
			publishButton = "//button[contains(text(),'Save & Publish')]",
			notifyViaWeb="input[name='web']",
			notifyViaEmail="input[name='email']",
			notifyViaPager="input[name='pager']",
			nextInUsersToFillOutForm=".emsButtonText",
			completeFormDelivery = "select[name='recipientType']",
			choice1 = "//label[text()='Choices']/following-sibling::div/ul/li[1]/input[@data-bind='value: $data.text']",
			save = "input[value='Save']",
			formActivation= "select[name='promptType']",
			completedFormDelivery = "select[name='recipientType']",
			tableLink = "//ul/li/a[text()='Table']",
			addRowBtn = "//label[text()='Table Rows']/following-sibling::div/ul/li/a[contains(@data-bind,'addRow')]",
			firstRowOfTable = "//label[text()='Table Rows']/parent::div/div[@class='controls controls-row']/ul/li[1]/input",
			secondRowOfTable = "//label[text()='Table Rows']/parent::div/div[@class='controls controls-row']/ul/li[2]/input",
			thirdRowOfTable = "//label[text()='Table Rows']/parent::div/div[@class='controls controls-row']/ul/li[3]/input",
			addColumnBtn = "//label[text()='Table Columns']/following-sibling::div/ul/li/a[contains(@data-bind,'addColumn')]",
			editTableLink = "//div[@class='suit-table-header']//a/i[@title='Edit Table']",
			allResources = "input[name='allResourcesInd']",
			whenToSendOption = "select[name='isAbove']",
			value = "input[name='numericLimit']",
			saveConfiguration = "input[value='Save Configuration']",
			selectStatusTypeButton = "input[value='Select Status Type']",
			allUsersCheckBox = "//form[text()='All Users']/input[@name='allUsersInd']",
			minimumLengthValue = "//label[text()='Min Length']/parent::div//input",
			maximumLengthValue = "//label[text()='Max Length']/parent::div//input",
			numberType = "//div/label[text()='Numeric Type']/parent::div//select",
			applicationTime = "//td[@class='ftRt']/span[@id='statusTime']",
			anyDatesAllowed = "input[value='ANY']",
			FutureToday = "input[value='FUTURETODAY']",
			firstColumnLabel = "//label[text()='Table Columns']/following-sibling::div/ul/li/input",
			nThcolumnLabel = "//label[text()='Table Columns']/following-sibling::div/ul/li/input[@title='Label is required.'][@placeholder='New Column']",
			firstColumnQuestionType = "//label[text()='Table Columns']/following-sibling::div/ul/li/select",
			nThColumnQuestionType = "//input[@title='Label is required.'][@placeholder='New Column']/parent::li/select",
			instructionLink = "//ul/li/a[text()='Instructions']",
			carteBlanche = "//input[@value='cbUserID'][@name='SELECT_ALL']",
			useStandardList = "//label[text()='Use Standard List']/parent::div/div/input",
			plusOption="//label[text()='Choices']/parent::div/div/ul/li/a[1]/i",
			minusOption="//label[text()='Choices']/parent::div/div/ul/li/a[2]/i",
			previewButton = "//button[text()='Preview']",
			readReceipt = "input[name='acknowledgeReview']",
			questionaireOption = "//label[text()='Type']/following-sibling::div[@class='controls controls-row']/select",
			requiredCheckBox = "//label[text()='Required']/parent::div//input",
			strRemoveFirstChoice = "//div//ul/li[1]/a[1]/i",
			dateType = "//div/label[text()='Date Type']/parent::div//select",
			defaultSelect = "//label[text()='Default Value']/following-sibling::div//select",
			choiceplusBtn="//label[text()='Choices']/following-sibling::div/ul/li[1]/input[@data-bind='value: $data.text']//../a[2]",
			choiceminusBtn="//label[text()='Choices']/following-sibling::div/ul/li[1]/input[@data-bind='value: $data.text']//../a[1]",
			UserStandardListCKB="//label[text()='Use Standard List']/..//input[@disabled='']",
			UserstandardListCKB1="//label[text()='Use Standard List']/../div/input",
			previewbutton="//button[text()='Preview']",
			previewbutton1="//button[text()='Preview']",
			printButton="//button[text()='Print']",
			decimalplaces="//label[text()='Decimal Places']/..//input",
		    readReceiptDisabled = "//input[@name='acknowledgeReview'][@disabled='']",
		    cancelButton = "input[value='Cancel']",
		    reportLabel = "input[data-bind='value: reportLabel']",
		    next="//input[@value='Next']",
		    mandatoryOption = "input[name='mandatory']",
		    minimumValue = "//label[text()='Min Value']/parent::div//input",
		    maximumValue = "//label[text()='Max Value']/parent::div//input",
		    activeChkBox = "//td[text()='Active:']/following-sibling::td/input[@value='Y']",
		    strDateRange="//label//span[contains(text(),'Date range between mm/dd/yyyy and mm/dd/yyyy')]",
		    Pastdatesonly = "input[value='PASTONLY']",
		    strDateRange2 ="//label/span[contains(text(),'Date range between XXXX days ago and YYYY days from now')]",
	        strEditpage="//div[@id='topSubNav']/h1",
	    	editFormTemplate = "//div/h1[text()='Edit Form Template']",
	  	    formTitle = "//td[text()='Title:']/..//input[@name='title']",
	  	    formDescription = "//td[text()='Description:']/..//textarea[@name='description']",
	  	    activeCheckBox = "valid",
	  	    conFigureFormsunderForm="Configure Forms",
	  	    createnewForm="//div[@id='topSubNav']/h1",
	  	    regionList = "regionID",
	  	    warning="//div[@class='emsWarning']/ul/li",
	  	    watermark="questionWatermark",
	  	    strSaveDisable="//button[text()='Save'][@disabled=''][@class='btn btn-primary']",
	  	    strSaveEnable="//button[text()='Save'][@class='btn btn-primary']",
	  	    strDisbled="//div[@class='suit-footer-primary-actions']/button[text()='Preview'][@disabled='']/following-sibling::button[@disabled=''][text()='Save']",
	  	    strSavePublishDisable="//div[@class='suit-footer-primary-actions']/button[text()='Save & Publish'][@disabled='']",
	  	    strValidation="//label[@class='control-label']/following-sibling::div/span[text()='Label is required.']",
	  	    strEditQsnry="//div[@class='grid-row ui-sortable'][3]/span/div/div[3]/a[1]",
	  	    strEWCancel="//button[text()='Cancel']",
	  	    strListToUse = "//label[text()='List to Use']/parent::div/div/select";
	
    public FormConfiguration(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
	}
	
	/**********************************************************************************
	* Description : This function is to verify the Form Configure page is Displayed
	* Date 		  : 10/11/2014
	* Author 	  : sangappa.k
	**********************************************************************************/
	public FormConfiguration verFormConfigurePage() throws Exception {
		objWaitForElement.waitForElements(createNewFormTemplete, "css");
		assertTrue("createNewFormTemplete Button is not displayed ", this.page
				.element(createNewFormTemplete, "css").isElementPresent());
		assertEquals("Form Configuration", this.page.element(headerName, "css")
				.getOne().getText());
		return this;
	}

	/**********************************************************************************
	* Description : This function is to click on create new Templete
	* Date 		  : 10/11/2014
	* Author 	  : sangappa.k
	**********************************************************************************/
	public FormConfiguration createNewFormTempltete() throws Exception {
		objWaitForElement.waitForElements(createNewFormTemplete, "css");
		this.page.element(createNewFormTemplete, "css").getOne().click();
		return this;
	}

	/**********************************************************************************
	* Description : This function is to writte the text in title field & Description
	* Date 		  : 10/11/2014
	* Author 	  : sangappa.k
	**********************************************************************************/
	public FormConfiguration entireTittleName_DescriptionName(
			String strTittleName, String strDescription) throws Exception {
		objWaitForElement.waitForElements(title, "css");
		this.page.element(title, "css").clearInputValue()
				.sendKeys(strTittleName);
		this.page.element(discription, "css").clearInputValue()
				.sendKeys(strDescription);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on Form Activation Drop Down
	* Date 		  : 10/11/2014
	* Author 	  : sangappa.k
	**********************************************************************************/
	public FormConfiguration clickOnFormActivation(String strFormActivation)
			throws Exception {
		objWaitForElement.waitForElements(checkBoxInForm, "name");
		this.page.element(checkBoxInForm, "name").getOne().click();
		return this;
	}

	/**********************************************************************************
	* Description : This function is to select Perticuler option on Form Activation Drop Down
	* Date 		  :10/11/2014
	* Author 	  : sangappa.k
	**********************************************************************************/
	public FormConfiguration selectOptionInFormActivationDropDown(
			String selectDropDown) throws Exception {
		objWaitForElement.waitForElements(certainStatusChangeOption, "css");
		this.page.element(certainStatusChangeOption, "css")
				.webElementToSelect().selectByVisibleText(selectDropDown);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on Next Button
	 * Activation Drop Down
	 * Date : 10/11/2014 Author : sangappa.k
	 **********************************************************************************/
	public FormConfiguration clickOnNextButton() throws Exception {
		objWaitForElement.waitForElements(nextButton, "css");
		this.page.element(nextButton, "css").getOne().click();
		return this;
	}
		/**********************************************************************************
		* Description : This function is to verify the StatusType is not Displyed
		* Date 		  : 10/11/2014
		* Author 	  : sangappa.k
		**********************************************************************************/
	public FormConfiguration verStatusTypeIsNotDisplyed(
			String strStatusTypeValue) throws Exception {
		assertFalse(
				"StatusType is Displyed",
				this.page.element(
						"input[name='statusTypeID'][value='"
								+ strStatusTypeValue + "']", "css")
						.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click onAcknowledge link
	  * Date		: 15/12/2014
	  * Author		: Anil
	 **********************************************************************************/
	public FormConfiguration clickOnAcknowledgeForm(String strStrFormName)
			throws Exception {
		objWaitForElement
				.waitForElementByxpathSelector("//td[text()='" + strStrFormName
						+ "']/parent::tr/td/a[text()='Questionnaire']");
		this.page
				.element(
						"//td[text()='" + strStrFormName
								+ "']/parent::tr/td/a[text()='Questionnaire']",
						"xpath").getOne().click();
		
		Thread.sleep(10000);
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to verify template design page is displayed
	  * Date		: 15/12/2014
	  * Author		: Anil
	  **********************************************************************************/
	public FormConfiguration verTemplateDesignPage() throws Exception {
		driver.navigate().refresh();
		objWaitForElement.waitForElements(intermedixLogo, "xpath");
		assertTrue(this.page.element(intermedixLogo, "xpath")
				.getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click onAcknowledge link
	  * Date		: 15/12/2014
	  * Author		: Anil
	 **********************************************************************************/
	public FormConfiguration clickOnInsert() throws Exception {
		objWaitForElement.waitForElements(insertLink, "xpath");
		this.page.element_wait(insertLink, "xpath").waitForElementEnable();
		this.page.element(insertLink, "xpath").clickUsingJSE();
		return this;
	}	
	
	/**********************************************************************************
	 * Description : This function is to click group link
	  * Date		: 15/12/2014
	  * Author		: Anil
	 **********************************************************************************/
	public FormConfiguration clickOnGroupLink() throws Exception {
		objWaitForElement.waitForElements(groupLink, "xpath");
		 this.page.element(groupLink, "xpath").clickUsingJSE();
		return this;
	}	
	
	/**********************************************************************************
	  * Description : This function is to verify template design page is displayed
	  * Date		: 15/12/2014
	  * Author		: Anil
	  **********************************************************************************/
	public FormConfiguration verifyEditGroupOrTable() throws Exception {
		objWaitForElement.waitForElements(editGroupTable, "css");
		assertTrue(this.page.element(editGroupTable, "css").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter group name
	  * Date		: 15/12/2014
	  * Author		: Anil
	**********************************************************************************/
	public FormConfiguration enterNewGroupName(String strGroupName)
			throws Exception {
		objWaitForElement.waitForElements(groupName, "xpath");
		this.page.element(groupName, "xpath").clearInputValue()
				.sendKeys(strGroupName);
		assertTrue(this.page.element(groupName, "xpath").getOne().getAttribute("value").equals(strGroupName));
		Thread.sleep(2000);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click group link
	  * Date		: 15/12/2014
	  * Author		: Anil
	 **********************************************************************************/
	public FormConfiguration clickOnGroupDoneButton() throws Exception {
		objWaitForElement.waitForElements(groupDoneButton, "xpath");
		assertTrue(this.page.element(groupDoneButton, "xpath")
				.isElementPresent());
		this.page.element(groupDoneButton, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click group link
	  * Date		: 15/12/2014
	  * Author		: Anil
	 **********************************************************************************/
	public FormConfiguration clickOnAddButton(String strGroupName)
			throws Exception {
		String strAddButton = "//span[text()='" + strGroupName
				+ "']/ancestor::header//a/i[@class='icon-plus']";
		objWaitForElement.waitForElements(strAddButton, "xpath");
		this.page.element(strAddButton, "xpath").clickUsingJSE();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click group link
	  * Date		: 15/12/2014
	  * Author		: Anil
	 **********************************************************************************/
	public FormConfiguration clickOnFieldSet(String strGroupName)
			throws Exception {
		objWaitForElement.waitForElements("//span[text()='" + strGroupName
				+ "']/ancestor::header//a[text()='FieldSet']",
		"xpath");
		this.page
				.element(
						"//span[text()='" + strGroupName
								+ "']/ancestor::header//a[text()='FieldSet']",
						"xpath").clickUsingJSE();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify template design page is displayed
	  * Date		: 15/12/2014
	  * Author		: Anil
	  **********************************************************************************/
	public FormConfiguration verifyEditFieldSetWindow() throws Exception {
		objWaitForElement.waitForElements(editFieldSetWindow, "xpath");
		assertTrue(this.page.element(editFieldSetWindow, "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter attributes label name
	  * Date		: 15/12/2014
	  * Author		: Anil
	**********************************************************************************/
	public FormConfiguration enterAttributesLabelName(String strAttributeName) throws Exception {
		objWaitForElement.waitForElements(attributesLabel, "xpath");
		this.page.element(attributesLabel, "xpath").clearInputValue()
				.sendKeys(strAttributeName);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click gdone button in edit fieldset
	  * Date		: 15/12/2014
	  * Author		: Anil
	 **********************************************************************************/
	public FormConfiguration clickOnEditFieldDoneButton() throws Exception {
		objWaitForElement.waitForElements(editFieldSetDoneButton, "xpath");
		this.page.element(editFieldSetDoneButton, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click group link
	  * Date		: 15/12/2014
	  * Author		: Anil
	 **********************************************************************************/
	public FormConfiguration clickOnInsertElement(String strAttributeName)
			throws Exception {
		objWaitForElement.waitForElementByxpathSelector("//span[text()='"+strAttributeName+"']/ancestor::fieldset//i[@title='Insert Element']");
		this.page
				.element(
						"//span[text()='"+strAttributeName+"']/ancestor::fieldset//i[@title='Insert Element']",
						"xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Edit Question Window is displayed
	  * Date		: 15/12/2014
	  * Author		: Anil
	  **********************************************************************************/
	public FormConfiguration verifyEditQuestionWindow() throws Exception {
		objWaitForElement.waitForElementByxpathSelector(editQuestion);
		assertTrue(this.page.element(editQuestion, "xpath").getOne()
				.isDisplayed());
		return this;
	}	
	
	/**********************************************************************************
	  * Description : This function is to select question type
	  * Date        : 09/06/2014
	  * Author      : Anil
	  **********************************************************************************/
	public FormConfiguration selectQuestionType(String strQuestionType) throws Exception {
		objWaitForElement.waitForElements(questionaireType,"xpath");
		//this.page.element(questionaireType, "xpath");
		try{
		this.page.element(questionaireType, "xpath").webElementToSelect().selectByVisibleText(strQuestionType);
		}    catch(Exception e) {
//			this.page.element(questionaireType+"/option[text()='"+strQuestionType+"']", "xpath").isElementPresent();
			Thread.sleep(3000);
			this.page.element(questionaireType+"/option[text()='"+strQuestionType+"']", "xpath").getOne().click();
		    }
		return this;
	}

	
	/**********************************************************************************
	* Description : This function is to enter attributes label name
	  * Date		: 15/12/2014
	  * Author		: Anil
	**********************************************************************************/
	public FormConfiguration enterLabelName(String strlabelName)
			throws Exception {
		objWaitForElement.waitForElements(labelName, "xpath");
		this.page.element(labelName, "xpath").clearInputValue()
				.sendKeys(strlabelName);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click group link
	  * Date		: 15/12/2014
	  * Author		: Anil
	 **********************************************************************************/
	public FormConfiguration clickOnDoneButton() throws Exception {
		objWaitForElement.waitForElements("//button[text()='Save']", "xpath");
		this.page.element("//button[text()='Save']", "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click group link
	  * Date		: 15/12/2014
	  * Author		: Anil
	 **********************************************************************************/
	public FormConfiguration clickOnAddToSummary() throws Exception {
		objWaitForElement.waitForElements(addToSummary, "xpath");
		if(this.page.element(addToSummary, "xpath").getOne().isSelected()==false){
		this.page.element(addToSummary, "xpath").getOne().click();
		}
		assertTrue(this.page.element(addToSummary, "xpath").getOne().isSelected());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on Save button
	  * Date		: 15/12/2014
	  * Author		: Anil
	 **********************************************************************************/
	public FormConfiguration clickOnSaveButton() throws Exception {
		Thread.sleep(10000);
		objWaitForElement.waitForElements(saveButton, "xpath");
		while(this.page.element(saveButton, "xpath").getOne().isEnabled()==false){
			Thread.sleep(1000);
		}
		try{
			assertTrue(this.page.element(saveButton, "xpath").getOne().isEnabled());
			this.page.element(saveButton, "xpath").getOne().sendKeys(Keys.ENTER);
		}catch(Exception e){
			
		}
		//this.page.element_wait("//section[@class=''][contains(@style,'background-image: none; background-color')]", "xpath").waitForVisibilityOfElement();
		//this.page.element_wait("//section[@class=''][contains(@style,'background-image: none; background-color')]", "xpath").waitForInvisibilityOfElement();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on Publish button
	  * Date		: 15/12/2014
	  * Author		: Anil
	 **********************************************************************************/
	public FormConfiguration clickOnPublishButton() throws Exception {
		
		objWaitForElement.waitForElements(publishButton, "xpath");
		this.page.element(publishButton, "xpath").mouseOver();
		this.page.element(publishButton, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select option from completed form delivery dropdown
	 * Date        : 15-Dec-2014
	 * Author      : Deepa
	 **********************************************************************************/
	public FormConfiguration selCompletedFormDelivery(String strOption)
			throws Exception {
		objWaitForElement.waitForElements(completeFormDelivery, "css");
		this.page.element(completeFormDelivery, "css").webElementToSelect()
				.selectByVisibleText(strOption);
		assertTrue(this.page.element(completeFormDelivery, "css")
				.webElementToSelect().getFirstSelectedOption().getText()
				.equals(strOption));
		return this;
	}
	 
	 /**********************************************************************************
	 * Description : This function is to check how to notify checkbox
	 * Date     : 15-Dec-2014
	 * Author    : Deepa
	 **********************************************************************************/
	public FormConfiguration selHowToNotify(String strHowToNotify)
			throws Exception {
		if (strHowToNotify.equals("Check if notify via web")) {
			this.page.element(notifyViaWeb, "css").getOne().click();
		} else if (strHowToNotify.equals("Check if notify via email")) {
			this.page.element(notifyViaEmail, "css").getOne().click();
		} else if (strHowToNotify.equals("Check if notify via pager ")) {
			this.page.element(notifyViaPager, "css").getOne().click();
		}
		return this;
	}
	 
	 /**********************************************************************************
	  * Description : This function is to select user in users to fill out form table
	  * Date        : 15-Dec-2014
	  * Author      : Deepa
	  **********************************************************************************/
	public FormConfiguration selUserInUsersToFillOutForm(String strUserName)
			throws Exception {
		String elementID = "//table[@id='tbl_userID']/tbody/tr/td[3][contains(text(),'"
				+ strUserName + "')]/parent::tr/td[1]/input";
		objWaitForElement.waitForElements(elementID, "xpath");
		assertTrue(this.page.element(elementID, "xpath").isElementPresent());
		
		if (!(this.page.element(elementID, "xpath").getOne().isSelected())) {
			 this.page.element(elementID, "xpath").mouseOver();
			this.page.element(elementID, "xpath").getOne().click();
		  }
		
		if (!(this.page.element(elementID, "xpath").getOne().isSelected())) {
			 this.page.element(elementID, "xpath").mouseOver();
			this.page.element(elementID, "xpath").getOne().sendKeys(Keys.SPACE);
		  }
		assertTrue(this.page.element(elementID, "xpath").getOne().isSelected());
		
		
		return this;
	}
	 
	 /**********************************************************************************
	  * Description : This function is to click on Next Button in users to fill out form
	  * Date     	: 15-Dec-2014
	  * Author     	: Deepa
	  **********************************************************************************/
	public FormConfiguration clickOnNextUsersToFillOutForm() throws Exception {
		objWaitForElement.waitForElements(nextInUsersToFillOutForm, "css");
		this.page.element(nextInUsersToFillOutForm, "css").getOne().click();
		return this;
	}
	 
	 /**********************************************************************************
	 * Description : This function is to select 'Activate Form' check box corresponding to user name.
	 * Date 	   : 15/12/2014
	 * Author 	   : Pallavi
	 **********************************************************************************/
	public FormConfiguration selectActivateFormChkBox(String strUserName)
			throws Exception {
		String strChkBox = "//table[@id='tbl_userID']/tbody/tr/td[5][text()='"
							+ strUserName + "']/preceding-sibling::td[4]/input";
		objWaitForElement.waitForElements(strChkBox, "xpath");
		if (!(this.page.element(strChkBox, "xpath").getOne().isSelected())) {
			this.page.element(strChkBox, "xpath").getOne().click();
		}
		
		if (!(this.page.element(strChkBox, "xpath").getOne().isSelected())) {
			this.page.element(strChkBox, "xpath").getOne().sendKeys(Keys.SPACE);;
		}
		assertTrue(this.page.element(strChkBox, "xpath").getOne().isSelected());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Save' button.
	 * Date 	   : 15/12/2014
	 * Author 	   : Pallavi
	 **********************************************************************************/
	public FormConfiguration clickOnSaveOfFormSecuritySetting()
			throws Exception {
		Actions action = new Actions(driver);
		objWaitForElement.waitForElementBycssSelector(save);
		action.moveToElement(this.page.element(save, "css").getOne()).perform();
		this.page.element(save, "css").getOne().click();
		Thread.sleep(3000);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to add choices in add question window
	 * Date        : 16-Dec-2014
	 * Author      : Deepa
	 **********************************************************************************/
	public FormConfiguration addChoices(String strChoice)
			throws Exception {
		enterChoice(strChoice);
//		clickOnAddChoice();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter choices in add question window
	 * Date        : 16-Dec-2014
	 * Author      : Deepa
	 **********************************************************************************/
	public FormConfiguration enterChoice(String strChoice) throws Exception {
		objWaitForElement.waitForElements(choice1, "xpath");
		this.page.element(choice1, "xpath").clearInputValue()
				.sendKeys(strChoice);
		Thread.sleep(100);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on add choices button in add question window
	 * Date        : 16-Dec-2014
	 * Author      : Deepa
	 **********************************************************************************/
	public FormConfiguration clickOnAddChoice() throws Exception {
		objWaitForElement.waitForElements("//label[text()='Choices']/following-sibling::div/ul/li[]/a[contains(@data-bind,'addChoice')]",
				"xpath");
		this.page
				.element(
						"//label[text()='Choices']/following-sibling::div/ul/li[]/a[contains(@data-bind,'addChoice')]",
						"xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to select form activation  option
	  * Date        : 17/12/2014
	  * Author      : Anil
	  **********************************************************************************/
	public FormConfiguration selectFormActivation(String strFormActivationRight)
			throws Exception {
		objWaitForElement.waitForElements(formActivation, "css");
		this.page.element(formActivation, "css").webElementToSelect()
				.selectByVisibleText(strFormActivationRight);
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to select form completed Form Delivery  option
	  * Date        : 17/12/2014
	  * Author      : Anil
	  **********************************************************************************/
	public FormConfiguration selectCompletedFormDelivery(
			String strCompletedFormDelivery) throws Exception {
		objWaitForElement.waitForElements(completedFormDelivery, "css");
		this.page.element(completedFormDelivery, "css").webElementToSelect()
				.selectByVisibleText(strCompletedFormDelivery);
		return this;
	}
	
	 /**********************************************************************************
	  * Description : This function is to select user in users to receive complete form table
	  * Date        : 18-Dec-2014
	  * Author      : Deepa
	  **********************************************************************************/
	public FormConfiguration selUserToRcvCompltdForm(String strUserName)
			throws Exception {
		String elementID = "//table[@id='tbl_userID']/tbody/tr/td[3][contains(text(),'"
				+ strUserName + "')]/parent::tr/td[1]/input";
		objWaitForElement.waitForElements(elementID, "xpath");
		if (this.page.element(elementID, "xpath").getOne().isSelected() == false) {
			assertTrue(this.page.element(elementID, "xpath").isElementPresent());
			this.page.element(elementID, "xpath").mouseOver();
			this.page.element(elementID, "xpath").getOne().click();
		}
		assertTrue(this.page.element(elementID, "xpath").getOne().isSelected());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select user in form security setting form
	  * Date        : 18-Dec-2014
	  * Author      : Deepa
	  **********************************************************************************/
	public FormConfiguration selUserInFormSecuritySetting(String strUserName)
			throws Exception {
		String elementID = "//table[@id='tbl_userID']/tbody/tr/td[5][contains(text(),'"
				+ strUserName + "')]/parent::tr/td[1]/input";
		objWaitForElement.waitForElements(elementID, "xpath");
		assertTrue(this.page.element(elementID, "xpath").isElementPresent());
		this.page.element(elementID, "xpath").mouseOver();
		this.page.element(elementID, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click Table link
	  * Date		: 17-Dec-2014
	  * Author		: Pallavi
	 **********************************************************************************/
	public FormConfiguration clickOnTableLink() throws Exception {
		objWaitForElement.waitForElements(tableLink, "xpath");
		this.page.element(tableLink, "xpath").getOne().click();
		return this;
	}	
	
	/**********************************************************************************
	 * Description : This function is to click on add Table Rows button in Edit FieldSet Window
	 * Date        : 17-Dec-2014
	 * Author      : Pallavi
	 **********************************************************************************/
	public FormConfiguration clickOnAddTableRow() throws Exception {
		objWaitForElement.waitForElements(addRowBtn, "xpath");
		this.page.element(addRowBtn, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to add first Row in Edit FieldSet Window
	 * Date        : 17-Dec-2014
	 * Author      : Pallavi
	 **********************************************************************************/
	public FormConfiguration enterFirstRowLabel(String strRowLabel)
			throws Exception {
		objWaitForElement.waitForElements(firstRowOfTable, "xpath");
		this.page.element(firstRowOfTable, "xpath").clearInputValue()
				.sendKeys(strRowLabel);
		/*assertTrue(strRowLabel.equals(this.page.element(firstRowOfTable, "xpath")
				.getOne().getAttribute("value")));*/
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to add second Row in Edit FieldSet Window
	 * Date        : 18-Dec-2014
	 * Author      : Pallavi
	 **********************************************************************************/
	public FormConfiguration enterSecondRowLabel(String strRowLabel)
			throws Exception {
		clickOnAddTableRow();
		objWaitForElement.waitForElements(secondRowOfTable, "xpath");
		this.page.element(secondRowOfTable, "xpath").clearInputValue()
				.sendKeys(strRowLabel);
		assertTrue(strRowLabel.equals(this.page.element(secondRowOfTable, "xpath")
				.getOne().getAttribute("value")));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to third Row in Edit FieldSet Window
	 * Date        : 18-Dec-2014
	 * Author      : Pallavi
	 **********************************************************************************/
	public FormConfiguration enterThirdRowLabel(String strRowLabel, String strSecRowLabel)
			throws Exception {
		clickOnAddTableRow();
		enterSecondRowLabel(strSecRowLabel);
		objWaitForElement.waitForElements(thirdRowOfTable, "xpath");
		this.page.element(thirdRowOfTable, "xpath").clearInputValue()
				.sendKeys(strRowLabel);
		assertTrue(strRowLabel.equals(this.page.element(thirdRowOfTable, "xpath")
				.getOne().getAttribute("value")));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on add Table column button in Edit FieldSet Window
	 * Date        : 18-Dec-2014
	 * Author      : Pallavi
	 **********************************************************************************/
	public FormConfiguration clickOnAddTableColumn() throws Exception {
		objWaitForElement.waitForElements(addColumnBtn, "xpath");
		this.page.element(addColumnBtn, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on Edit Table Link in Template designer window
	 * Date        : 18-Dec-2014
	 * Author      : Pallavi
	 **********************************************************************************/
	public FormConfiguration clickOnEditTable() throws Exception {
		objWaitForElement.waitForElements(editTableLink, "xpath");
		this.page.element(editTableLink, "xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to deselect select All resources check box
	 * Date 	   : 17/12/2014 
	 * Author	   : Anil
	 **********************************************************************************/
	public FormConfiguration deselectAllResources() throws Exception {
		objWaitForElement.waitForElementBycssSelector(allResources);
		if (this.page.element(allResources, "css").getOne().isSelected() == true) {
			this.page.element(allResources, "css").getOne().click();
		}
		assertFalse(this.page.element(allResources, "css").getOne().isSelected());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to select resources check box 
	 * Date 	   : 17/12/2014
	 * Author 	   : Anil
	 **********************************************************************************/
	public FormConfiguration selectResources(String strResourceName)
			throws Exception {
		objWaitForElement.waitForElementByxpathSelector("//td[text()='"
				+ strResourceName + "']/preceding-sibling::td/input");
		if (this.page
				.element(
						"//td[text()='" + strResourceName
								+ "']/preceding-sibling::td/input", "xpath")
				.getOne().isSelected() == false) {
			this.page
					.element(
							"//td[text()='" + strResourceName
									+ "']/preceding-sibling::td/input", "xpath")
					.getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select status type radio button 
	 * Date : 17/12/2014 
	 * Author : Anil
	 **********************************************************************************/
	public FormConfiguration selectStatusTypes(String strStatusType)
			throws Exception {
		objWaitForElement.waitForElementByxpathSelector("//td[text()='"
				+ strStatusType + "']/preceding-sibling::td/input");
			this.page
					.element(
							"//td[text()='" + strStatusType
									+ "']/preceding-sibling::td/input", "xpath")
					.getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter status type value
	  * Date		: 15/12/2014
	  * Author		: Anil
	**********************************************************************************/
	public FormConfiguration enterStatusTypeValue(String strlabelName)
			throws Exception {
		objWaitForElement.waitForElements(value, "css");
		this.page.element(value, "css").clearInputValue()
				.sendKeys(strlabelName);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select When to send option
	* Date 		  :10/11/2014
	* Author 	  : sangappa.k
	**********************************************************************************/
	public FormConfiguration selectWhenToSendOption(String selectDropDown)
			throws Exception {
		objWaitForElement.waitForElements(whenToSendOption, "css");
		assertTrue(this.page.element(whenToSendOption, "css")
				.isElementPresent());
		this.page.element(whenToSendOption, "css").webElementToSelect()
				.selectByVisibleText(selectDropDown);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on Save Configuration button
	 * Date : 17/12/2014 
	 * Author : Anil
	 **********************************************************************************/
	public FormConfiguration clickOnSaveConfiguration() throws Exception {
		objWaitForElement.waitForElementBycssSelector(saveConfiguration);
		this.page.element(saveConfiguration, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on Select Status Type Button
	 * Date 	   : 17/12/2014 
	 * Author	   : Anil
	 **********************************************************************************/
	public FormConfiguration clickOnSelectStatusTypeButton() throws Exception {
		objWaitForElement.waitForElementBycssSelector(selectStatusTypeButton);
		this.page.element(selectStatusTypeButton, "css").getOne().click();
		return this;
	}
	
    /**********************************************************************************
	 * Description : This function is to deSelect 'All Users' check box
	 * Date        : 19-Dec-2014
	 * Author      : Pallavi
	 **********************************************************************************/
	public FormConfiguration deSelectAllUsersCheckBox() throws Exception {
		objWaitForElement.waitForElements(allUsersCheckBox, "xpath");
		if (this.page.element(allUsersCheckBox, "xpath").getOne().isSelected()) {
			this.page.element(allUsersCheckBox, "xpath").getOne().click();
		}
		assertFalse(this.page.element(allUsersCheckBox, "xpath").getOne()
				.isSelected());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on Select Multi Status Type Button
	 * Date 	   : 17/12/2014 
	 * Author	   : Anil
	 **********************************************************************************/
	public FormConfiguration selectMSTStatusesOption(String strStatuesValue1,
			String strStatuesValue2) throws Exception {
		String strInputValue = "//input[@value='" + strStatuesValue1 + "-"
				+ strStatuesValue2 + "']";
		objWaitForElement.waitForElementByxpathSelector(strInputValue);
		this.page.element(strInputValue, "xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description  : This function is to click on Edit link
	  * Date		: 15/12/2014
	  * Author		: Anil
	 **********************************************************************************/
	public FormConfiguration clickOnEditFormLink(String strStrFormName)
			throws Exception {
		objWaitForElement.waitForElementByxpathSelector("//td[text()='"
				+ strStrFormName + "']/parent::tr/td/a[text()='Edit']");
		this.page.element(
				"//td[text()='" + strStrFormName
						+ "']/parent::tr/td/a[text()='Edit']", "xpath")
				.mouseOver();
		this.page
				.element(
						"//td[text()='" + strStrFormName
								+ "']/parent::tr/td/a[text()='Edit']", "xpath")
				.getOne().sendKeys(Keys.ENTER);
		;
		Thread.sleep(3000);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to write the text in title field 
	* Date 		  : 10/11/2014
	* Author 	  : sangappa.k
	**********************************************************************************/
	public FormConfiguration entireTittleName(String strTittleName)
			throws Exception {
		objWaitForElement.waitForElements(title, "css");
		this.page.element(title, "css").clearInputValue()
				.sendKeys(strTittleName);
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to verify template design page is displayed
	  * Date		: 15/12/2014
	  * Author		: Anil
	  **********************************************************************************/
	public FormConfiguration verifyFormNameInTemplateDesignPage(
			String strTittleName) throws Exception {
		objWaitForElement.waitForElements("//div[@id='content']/div/section/section/header/h2/span[text()='"+strTittleName+"']",
				"xpath");
		assertTrue(this.page.element(
				"//div[@id='content']/div/section/section/header/h2/span[text()='"+strTittleName+"']",
				"xpath").getOne().isDisplayed());
		return this;
	}
	/**********************************************************************************
	* Description   : This function is to enter Minimum Length
	* Date		    : 15/12/2014
	* Author		: Anil
	**********************************************************************************/
	public FormConfiguration enterMinimumLength(String strMinimumValue)
			throws Exception {
		objWaitForElement.waitForElements(minimumLengthValue, "xpath");
		this.page.element(minimumLengthValue, "xpath").clearInputValue()
				.sendKeys(strMinimumValue);
		assertTrue(this.page.element(minimumLengthValue, "xpath").getOne()
				.getAttribute("value").equals(strMinimumValue));
		return this;
	}

	/**********************************************************************************
	* Description   : This function is to enter Minimum Length
	* Date		    : 15/12/2014
	* Author		: Anil
	**********************************************************************************/
	public FormConfiguration enterMaximumLength(String strMaximumValue) throws Exception {
		objWaitForElement.waitForElements(maximumLengthValue, "xpath");
		this.page.element(maximumLengthValue, "xpath").clearInputValue()
				.sendKeys(strMaximumValue);
		assertTrue(this.page.element(maximumLengthValue, "xpath").getOne()
				.getAttribute("value").equals(strMaximumValue));
		return this;
	}
	
	/**********************************************************************************
	 * Description  : This function is to click on edit of questionnaire link
	  * Date		: 15/12/2014
	  * Author		: Anil
	 **********************************************************************************/
	public FormConfiguration clickOnEditQuestionnaire(String strQustionName)
			throws Exception {
		objWaitForElement.waitForElements("//span[text()='"
				+ strQustionName
				+ "']/parent::label/following-sibling::div/following-sibling::div/a[1]", "xpath");
		this.page
				.element(
						"//span[text()='"+strQustionName+"']/parent::label/following-sibling::div/following-sibling::div/a[1]",
						"xpath").getOne().click();
		objWaitForElement.waitForElementByxpathSelector(editQuestion);
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to select Number type
	   * Date        : 09/06/2014
	   * Author      : Anil
	   **********************************************************************************/
	public FormConfiguration selectNumberType(String strNumberType)
			throws Exception {
		objWaitForElement.waitForElements(numberType, "xpath");
		this.page.element(numberType, "xpath").webElementToSelect()
				.selectByVisibleText(strNumberType);
		return this;
	}
	 
	/**********************************************************************************
	 * Description : This function is to enter second choice in add question window
	 * Date        : 23-Dec-2014
	 * Author      : Pallavi
	 **********************************************************************************/
	public FormConfiguration enterNthChoice(String choiceNumber, String strChoice)
			throws Exception {
		int chNum = Integer.parseInt(choiceNumber);
		objWaitForElement.waitForElements("//label[text()='Choices']/following-sibling::div/ul/li["
				+ (chNum-1)
				+ "]/a[contains(@data-bind,'addChoice')]", "xpath");
		this.page.element("//label[text()='Choices']/following-sibling::div/ul/li["
								+ (chNum-1)
								+ "]/a[contains(@data-bind,'addChoice')]", "xpath").getOne().click();
		this.page
				.element(
						"//label[text()='Choices']/following-sibling::div/ul/li["
								+ choiceNumber
								+ "]/input[@data-bind='value: $data.text']",
						"xpath").clearInputValue().sendKeys(strChoice);
		assertTrue(strChoice.equals(this.page
				.element(
						"//label[text()='Choices']/following-sibling::div/ul/li["
								+ choiceNumber
								+ "]/input[@data-bind='value: $data.text']",
						"xpath").getOne().getAttribute("value")));
		return this;
	}
		
	/**********************************************************************************
	 * Description : This function is to add second choice in add question window
	 * Date        : 16-Dec-2014
	 * Author      : Pallavi
	 **********************************************************************************/
	public FormConfiguration addNthChoice(String strChoiceNumber,
			String strChoice) throws Exception {
		enterNthChoice(strChoiceNumber, strChoice);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify completed form delivery dropdown is disabled
	 * Date        : 24-Dec-2014
	 * Author      : Pallavi
	 **********************************************************************************/
	public FormConfiguration verCompletedFormDeliveryIsDisabled(String strOption)
			throws Exception {
		objWaitForElement.waitForElements(completeFormDelivery + "[disabled='']",
				"css");
		assertTrue(this.page.element(completeFormDelivery + "[disabled='']",
				"css").getOne().isDisplayed());
		String selectedOption = this.page.element(completeFormDelivery, "css")
				.webElementToSelect().getFirstSelectedOption().getText();
		assertEquals(strOption, selectedOption);
		return this;
	}
		
	/**********************************************************************************
	 * Description : This function is to get the time from the application.
	 * Date        : 24-Dec-2014
	 * Author      : Pallavi
	 **********************************************************************************/
	public String getApplicationTime() throws Exception {
		objWaitForElement.waitForElements(applicationTime, "xpath");
		String appDateTime = this.page.element(applicationTime, "xpath")
				.getOne().getText();
		String[] arrTime = appDateTime.split(" ");
		return arrTime[2];
	}
	
	/**********************************************************************************
	 * Description : This function is to select shift in form shift delivery option page
	 * Date        : 24-Dec-2014
	 * Author      : Pallavi
	 **********************************************************************************/
	public FormConfiguration selectShift(String strShift) throws Exception {
		objWaitForElement
				.waitForElements("//td[text()='Template to be delivered every: ']/following-sibling::td/input[@name='"
						+ strShift + "']", "xpath");
		this.page
				.element(
						"//td[text()='Template to be delivered every: ']/following-sibling::td/input[@name='"
								+ strShift + "']", "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select time for a shift to deliver the template.
	 * Date        : 24-Dec-2014
	 * Author      : Pallavi
	 **********************************************************************************/
	public String selectTimeByAddingFourMins(String strAppTime, String strSihft)
			throws Exception {
		String strAdd5MinsToAppTime = objDts.AddTimeToExistingTimeHourAndMin(strAppTime, 0, 3, "HH:mm");
		String[] strTime = strAdd5MinsToAppTime.split(":");
		String strHour = strTime[0];
		String strMinute = strTime[1];
		objWaitForElement.waitForElements("//select[@name='" + strSihft + "Hour']", "xpath");
		this.page.element("//select[@name='" + strSihft + "Hour']", "xpath")
				.webElementToSelect().selectByVisibleText(strHour);
		this.page.element("//select[@name='" + strSihft + "Minute']", "xpath")
				.webElementToSelect().selectByVisibleText(strMinute);
		return strAdd5MinsToAppTime;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify application time is greater than or equal
	 * 				 to the given time.
	 * Date        : 24-Dec-2014
	 * Author      : Pallavi
	 **********************************************************************************/
	public FormConfiguration verAppTimeIsGreaterOrEqualToTimeProvided(
			String strAppTime, String strShiftTimeProvided) throws Exception {
		int hour = Integer.parseInt((strAppTime.split(":"))[0]);
		int minute = Integer.parseInt((strAppTime.split(":"))[1]);
		
		int hourShiftTime = Integer.parseInt((strShiftTimeProvided.split(":"))[0]);
		int minuteShiftTime = Integer.parseInt((strShiftTimeProvided.split(":"))[1]);
		assertTrue(hour>hourShiftTime || minute>minuteShiftTime);
//		String strShiftTimeProvidedPlusOne = objDts.addTimetoExisting(
//				strShiftTimeProvided, 1, "HH:mm");
//		String strShiftTimeProvidedPlusTwo = objDts.addTimetoExisting(
//				strShiftTimeProvided, 2, "HH:mm");
//		assertTrue(strShiftTimeProvided.equals(strAppTime)
//				|| strShiftTimeProvidedPlusOne.equals(strAppTime)
//				|| strShiftTimeProvidedPlusTwo.equals(strAppTime));
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to click on Any dates allowed radio button
	 * Date        : 17/12/2014 
	 * Author      : Anitha
	 **********************************************************************************/
	public FormConfiguration clickOnAnyDatesAllowedRadioButton()
			throws Exception {
		objWaitForElement.waitForElements(anyDatesAllowed, "css");
		this.page.element(anyDatesAllowed, "css").getOne().click();
		return this;
	}
	
	/*************************************************************************************
	 * Description : This function is to click on Future Date Including Today radio button
	 * Date        : 17/12/2014 
	 * Author      : Anitha
	 *************************************************************************************/
	public FormConfiguration clickOnFutureDateIncludingToday()
			throws Exception {
		objWaitForElement.waitForElements(FutureToday, "css");
		this.page.element(FutureToday, "css").getOne().click();
		return this;
	}
	/**********************************************************************************
	  * Description : This function is to select user in form security setting form
	  * Date        : 18-Dec-2014
	  * Author      : Deepa
	  **********************************************************************************/
	public FormConfiguration selUserInFormSecuritySettingPageForUser(String strUserName)
			throws Exception {
		String elementID = "//table[@id='tbl_userID']/tbody/tr/td[4][contains(text(),'"
				+ strUserName + "')]/parent::tr/td[1]/input";
		objWaitForElement.waitForElements(elementID, "xpath");
		assertTrue(this.page.element(elementID, "xpath").isElementPresent());
		this.page.element(elementID, "xpath").mouseOver();
		this.page.element(elementID, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to add second Row in Edit FieldSet Window
	 * Date        : 18-Dec-2014
	 * Author      : Pallavi
	 **********************************************************************************/
	public FormConfiguration enterNthRowLabel(String strRowLabel)
			throws Exception {
		clickOnAddTableRow();
		objWaitForElement.waitForElements(secondRowOfTable, "css");
		this.page.element(secondRowOfTable, "css").clearInputValue()
				.sendKeys(strRowLabel);
		assertTrue(strRowLabel.equals(this.page.element(secondRowOfTable, "css")
				.getOne().getAttribute("value")));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to add first table column
	 * Date        : 18-Dec-2014
	 * Author      : Pallavi
	 **********************************************************************************/
	public FormConfiguration addFirstTableColumn(String strColumnLabel,
			String strQuestionnairType) throws Exception {
		enterLabelForFirstColumn(strColumnLabel);
		selctQuestionnairTypeForFirstColumn(strQuestionnairType);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on add n columns
	 * Date        : 18-Dec-2014
	 * Author      : Pallavi
	 **********************************************************************************/
	public FormConfiguration addNthTableColumn(String strColumnLabel,
			String strQuestionnairType) throws Exception {
		clickOnAddTableColumn();
		selctQuestionnairTypeForNthColumn(strQuestionnairType);
		enterLabelForNthColumn(strColumnLabel);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter first Column Label
	 * Date        : 18-Dec-2014
	 * Author      : Pallavi
	 **********************************************************************************/
	public FormConfiguration enterLabelForFirstColumn(String strColumnLabel)
			throws Exception {
		objWaitForElement.waitForElements(firstColumnLabel, "xpath");
		this.page.element(firstColumnLabel, "xpath").clearInputValue()
				.sendKeys(strColumnLabel);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter first Column Label
	 * Date        : 18-Dec-2014
	 * Author      : Pallavi
	 **********************************************************************************/
	public FormConfiguration enterLabelForNthColumn(String strColumnLabel)
			throws Exception {
		objWaitForElement.waitForElements(nThcolumnLabel,"xpath");
		this.page.element(nThcolumnLabel, "xpath").clearInputValue()
				.sendKeys(strColumnLabel);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select question type of first column
	  * Date        : 29-Dec-2014
	  * Author      : Pallavi
	  **********************************************************************************/
	public FormConfiguration selctQuestionnairTypeForFirstColumn(
			String strQuestionType) throws Exception {
		objWaitForElement.waitForElements(firstColumnQuestionType,"xpath");
		this.page.element(firstColumnQuestionType, "xpath")
				.webElementToSelect().selectByVisibleText(strQuestionType);
		assertTrue(this.page.element(firstColumnQuestionType, "xpath")
				.webElementToSelect().getFirstSelectedOption().getText()
				.equals(strQuestionType));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select question type of nth column
	  * Date        : 29-Dec-2014
	  * Author      : Pallavi
	  **********************************************************************************/
	public FormConfiguration selctQuestionnairTypeForNthColumn(
			String strQuestionType) throws Exception {
		objWaitForElement.waitForElements(nThColumnQuestionType,"xpath");
		this.page.element(nThColumnQuestionType, "xpath")
				.webElementToSelect().selectByVisibleText(strQuestionType);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on remove nth column of table in Edit FieldSet window
	 * Date        : 29-Dec-2014
	 * Author      : Pallavi
	 **********************************************************************************/
	public FormConfiguration removeNthColumn(String strColumnNumber)
			throws Exception {
		objWaitForElement.waitForElements("//label[text()='Table Columns']/following-sibling::div/ul/li["
				+ strColumnNumber
				+ "]/a[contains(@data-bind,'removeColumn')]",
		"xpath");
		this.page
				.element(
						"//label[text()='Table Columns']/following-sibling::div/ul/li["
								+ strColumnNumber
								+ "]/a[contains(@data-bind,'removeColumn')]",
						"xpath").getOne().click();
		try{
			Thread.sleep(2000);
			Alert alert = driver.switchTo().alert();
			alert.accept();
			objWaitForElement.waitForElements(editFieldSetDoneButton,"xpath");
			this.page.element_wait(editFieldSetDoneButton, "xpath");
		}catch(Exception e){
			Alert alert = driver.switchTo().alert();
			alert.accept();
			this.page.element_wait(editFieldSetDoneButton, "xpath");
		}
		Thread.sleep(2000);
		return this;
	}
	
   /**********************************************************************************
    * Description : This function is to verify that the instruction entered is displayed.
      * Date        : 23-Dec-2014
      * Author      : Pallavi
    **********************************************************************************/
    public FormConfiguration verifyEnteredInstructionIsDisplayed(
                  String strInstruction) throws Exception {
		objWaitForElement.waitForElements("//div[@class='alert alert-info alert-block instructions']/span/p[text()='"
                + strInstruction + "']", "xpath");
           assertTrue(this.page.element(
                        "//div[@class='alert alert-info alert-block instructions']/span/p[text()='"
                                      + strInstruction + "']", "xpath").getOne().isDisplayed());
           return this;
    }

	/**********************************************************************************
	  * Description : This function is to select frame
	  * Date        : 09/06/2014
	  * Author      : Anil
	  **********************************************************************************/
	public FormConfiguration selectInstructionFrame() throws Exception {
		try{
			if(this.page.element("//iframe[contains(@id,'mce')]", "xpath").getOne().isDisplayed()){
				WebDriverWait wait = new WebDriverWait(this.driver, WaitTimeConstants.WAIT_TIME_LONG);
				String strFrame = this.page.element("//iframe[contains(@id,'mce')]", "xpath").getOne().getAttribute("id");
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(strFrame));
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return this;
	}
	
	
    /**********************************************************************************
    * Description : This function is to verify that the instruction entered is displayed.
      * Date        : 23-Dec-2014
      * Author      : Pallavi
    **********************************************************************************/
    public FormConfiguration enterInstructions(
                  String strInstruction) throws Exception {
    	try{
    		objWaitForElement.waitForElementByxpathSelector("//html/body");
    		Thread.sleep(5000);
    	this.page.element("//html/body", "xpath").getOne().sendKeys(strInstruction);
    	}
    	catch(Exception e){
    		
    	}
           return this;
    }
    
	/**********************************************************************************
	 * Description : This function is to click instruction link
	  * Date		: 15/12/2014
	  * Author		: Anil
	 **********************************************************************************/
	public FormConfiguration clickOnInstructionLink() throws Exception {
		objWaitForElement.waitForElements(instructionLink, "xpath");
		this.page.element(instructionLink, "xpath").getOne().click();
		return this;
	}	
	
	/**********************************************************************************
	 * Description : This function is to click group link
	  * Date		: 15/12/2014
	  * Author		: Anil
	 **********************************************************************************/
	public FormConfiguration clickOnInstructionInGroup(String strGroupName)
			throws Exception {
		objWaitForElement.waitForElements("//span[text()='"
				+ strGroupName
				+ "']/ancestor::header//a[text()='Instructions']",
		"xpath");
		this.page
				.element(
						"//span[text()='"
								+ strGroupName
								+ "']/ancestor::header//a[text()='Instructions']",
						"xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify the Form Security page is Displayed
	* Date 		  : 30/12/2014
	* Author 	  : Renushree
	**********************************************************************************/
	public FormConfiguration verFormSecurityPage(String strForm)
			throws Exception {
		objWaitForElement.waitForElements(headerName, "css");
		assertEquals("Form Security Settings: " + strForm + "", this.page
				.element(headerName, "css").getOne().getText());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on delete link of a question corresponding to label name
	* Date 		  : 2-Jan-2015
	* Author 	  : Pallavi
	**********************************************************************************/
	public FormConfiguration clickOnDeleteLinkOfAQuestion(String strLabel)
			throws Exception {
		objWaitForElement.waitForElements("//span[text()='"
				+ strLabel
				+ "']/parent::label/following-sibling::div//a[contains(@data-bind,'removeQuestion')]",
		"xpath");
		this.page
				.element(
						"//span[text()='"
								+ strLabel
								+ "']/parent::label/following-sibling::div//a[contains(@data-bind,'removeQuestion')]",
						"xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on 'OK' of alert popup
	* Date 		  : 2-Jan-2015
	* Author 	  : Pallavi
	**********************************************************************************/
	public FormConfiguration clickOnOkToRemoveQuestion()
			throws Exception {
		Alert alert = driver.switchTo().alert();
		alert.accept();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to delete a question corresponding to label name
	* Date 		  : 2-Jan-2015
	* Author 	  : Pallavi
	**********************************************************************************/
	public FormConfiguration deleteAQuestion(String strLabel)
			throws Exception {
		clickOnDeleteLinkOfAQuestion(strLabel);
		clickOnOkToRemoveQuestion();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select 'Run Report' check box corresponding to user name in security page.
	 * Date 	   : 05/01/2015
	 * Author 	   : Renushree
	 **********************************************************************************/
	public FormConfiguration selectRunReportChkBoxInSecurityPge(
			String strUserName) throws Exception {
		String strChkBox = "//table[@id='tbl_userID']/tbody/tr/td[5][text()='"
				+ strUserName + "']/preceding-sibling::td[3]/input";
		objWaitForElement.waitForElements(strChkBox, "xpath");
		if (!(this.page.element(strChkBox, "xpath").getOne().isSelected())) {
			this.page.element(strChkBox, "xpath").getOne().click();
		}
		assertTrue(this.page.element(strChkBox, "xpath").getOne().isSelected());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to delete group
	* Date 		  : 06-Jan-2015
	* Author 	  : Renushree
	**********************************************************************************/
	public FormConfiguration deleteGroup(String strGroupName) throws Exception {
		objWaitForElement.waitForElements(
				"//span[text()='"
						+ strGroupName
						+ "']/parent::h3/following-sibling::div/div/a/i[@title='Remove Group']",
				"xpath");
		this.page
				.element(
						"//span[text()='"
								+ strGroupName
								+ "']/parent::h3/following-sibling::div/div/a/i[@title='Remove Group']",
						"xpath").getOne().click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to delete instruction
	* Date 		  : 07-Jan-2015
	* Author 	  : Renushree
	**********************************************************************************/
	public FormConfiguration deleteInstruction(String strInstruction)
			throws Exception {
		objWaitForElement.waitForElements("//p[text()='"
						+ strInstruction
						+ "']/parent::span/preceding-sibling::div/div/a[contains(@data-bind,'removeInstructions')]",
				"xpath");
		this.page
				.element(
						"//p[text()='"
								+ strInstruction
								+ "']/parent::span/preceding-sibling::div/div/a[contains(@data-bind,'removeInstructions')]",
						"xpath").getOne().click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		return this;
	}

	/**********************************************************************************
	* Description : This function is to verify the Form Security page is Displayed
	* Date 		  : 30/12/2014
	* Author 	  : Renushree
	**********************************************************************************/
	public FormConfiguration verFormSecurityPageIsNotDisplayed(String strForm)
			throws Exception {
		objWaitForElement.waitForElementBycssSelector(headerName);
		assertNotEquals("Form Security Settings: " + strForm + "", this.page
				.element(headerName, "css").getOne().getText());
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to click Table link
	  * Date		: 17-Dec-2014
	  * Author		: Pallavi
	 **********************************************************************************/
	public FormConfiguration clickOnTableLinkUnderGroup(String strGroupName)
			throws Exception {
		objWaitForElement.waitForElementByxpathSelector("//span[text()='"
				+ strGroupName + "']/ancestor::header//a[text()='Table']");
		this.page
				.element(
						"//span[text()='" + strGroupName
								+ "']/ancestor::header//a[text()='Table']",
						"xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click onAcknowledge link
	  * Date		: 15/12/2014
	  * Author		: Anil
	 **********************************************************************************/
	public FormConfiguration clickOnSecurityLinkOfForm(String strStrFormName)
			throws Exception {
		objWaitForElement.waitForElementByxpathSelector("//td[text()='"
				+ strStrFormName + "']/parent::tr/td/a[text()='Security']");
		this.page
				.element(
						"//td[text()='" + strStrFormName
								+ "']/parent::tr/td/a[text()='Security']",
						"xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select 'Activate Form' check box corresponding to user name.
	 * Date 	   : 15/12/2014
	 * Author 	   : Pallavi
	 **********************************************************************************/
	public FormConfiguration selectActivateFormChkBoxByUser(String strUserName)
			throws Exception {
		String strChkBox = "//table[@id='tbl_userID']/tbody/tr/td[4][text()='"
				+ strUserName + "']/preceding-sibling::td[3]/input";
		objWaitForElement.waitForElements(strChkBox, "xpath");
		this.page.element(strChkBox, "xpath").mouseOver();
		this.page.element(strChkBox, "xpath").getOne().sendKeys(Keys.SPACE);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify the Carte Blanche is not Displyed
	* Date 		  : 10/01/2015
	* Author 	  : Anil
	**********************************************************************************/
	public FormConfiguration verifyCarteBlancheIsNotDisplayed()
			throws Exception {
		assertFalse(
				"Carte Blanche element is displayed",
				this.page.element(carteBlanche, "xpath").isElementPresent(
						WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify Form title in Template Designer Page.
	* Arguments   : strFormTitle
	* Date 		  : 16-Jan-2015
	* Author 	  : Pallavi
	**********************************************************************************/
	public FormConfiguration verifyFormTitle(String strFormTitle)
			throws Exception {
		objWaitForElement.waitForElements(saveButton, "xpath");
		String strTitleElement = "//div[@id='content']//div//h2/span[contains(text(),'"
				+ strFormTitle + "')]";
		objWaitForElement.waitForElements(strTitleElement, "xpath");
		assertTrue(this.page.element(strTitleElement, "xpath")
				.isElementPresent(), "Form title is not displayed");
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify that the Deleted Question is not displayed
	* 				in Template designer page.
	* Arguments   : strQuestion
	* Date 		  : 16-Jan-2015
	* Author 	  : Pallavi
	**********************************************************************************/
	public FormConfiguration verifyQuestionIsNotDisplayed(String strLabel)
			throws Exception {
		String strQuestionElement = "//span[text()='" + strLabel
				+ "']/parent::label/parent::div";
		assertFalse("Question is displayed", this.page.element(strQuestionElement, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	/**********************************************************************************
	* Description : This function is to click Cancel delete link of a question corresponding to label name
	* Date 		  : 2-Jan-2015
	* Author 	  : Pallavi
	**********************************************************************************/
	public FormConfiguration cancelDeleteLinkOfAQuestion(String strLabel)
			throws Exception {
		objWaitForElement.waitForElements("//span[text()='"
				+ strLabel
				+ "']/parent::label/following-sibling::div/a[contains(@data-bind,'removeQuestion')]",
		"xpath");
		this.page
				.element(
						"//span[text()='"
								+ strLabel
								+ "']/parent::label/following-sibling::div/a[contains(@data-bind,'removeQuestion')]",
						"xpath").getOne().click();
		
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify template design page is displayed
	  * Date		: 15/12/2014
	  * Author		: Anil
	  **********************************************************************************/
	public FormConfiguration verifyLabelNameInTemplateDesignPage(
			String strLabelName) throws Exception {
		objWaitForElement.waitForElements("//label/span[text()='"
				+ strLabelName + "']", "xpath");
		assertTrue(this.page.element(
				"//label/span[text()='" + strLabelName + "']", "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify that the added que choice1 is displayed
	* Arguments   : strLabel
	* Date 		  : 16-Jan-2015
	* Author 	  : Deepa
	**********************************************************************************/
	public FormConfiguration verifyAddedFirstQueChoiceIsDis(String strLabel, String strChoice)
			throws Exception {
		String strElement = "//div/label/span[contains(text(),'"
				+ strLabel
				+ "')]/parent::label/following-sibling::div[1]/span/label/span[contains(text(),'" + strChoice + "')]";
		objWaitForElement.waitForElements(strElement, "xpath");
		assertTrue("First Question choice is not displayed",
					this.page.element(strElement, "xpath").getOne()
							.isDisplayed());
		return this;
	}

	/**********************************************************************************
	* Description : This function is to remove first choice under label
	* Arguments   : strLabel
	* Date 		  : 16-Jan-2015
	* Author 	  : Deepa
	**********************************************************************************/
	public FormConfiguration removeFirstChoice()
			throws Exception {
		objWaitForElement.waitForElements(strRemoveFirstChoice, "xpath");
		this.page.element(strRemoveFirstChoice, "xpath").getOne().click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify that the added choice is listed under the label
	* Arguments   : strLabel, strChoice
	* Date 		  : 16-Jan-2015
	* Author 	  : Deepa
	**********************************************************************************/
	public FormConfiguration verifyChoiceIsNotListedUnderLabel(String strLabel,
			String strChoice) throws Exception {
		String strChoiceElement = "//label/span[contains(text(),'"
				+ strLabel
				+ ")]/parent::label/parent::div/div[2]/label/span[contains(text(),'"
				+ strChoice + "')]";
		assertFalse("Choice is not displayed",
				this.page.element(strChoiceElement, "xpath")
						.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to click group link
	  * Date		: 15/12/2014
	  * Author		: Anil
	 **********************************************************************************/
	public FormConfiguration clickOnUseStanderdListChkBox() throws Exception {
		objWaitForElement.waitForElements(useStandardList,
				"xpath");
		if (this.page.element(useStandardList, "xpath").getOne().isSelected() == false) {
			this.page.element(useStandardList, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click group link
	  * Date		: 15/12/2014
	  * Author		: Anil
	 **********************************************************************************/
	public FormConfiguration verifyChioceOptionsNotPresent() throws Exception {

		assertFalse("Plus option is displayed", this.page.element(plusOption, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		assertFalse("Minus option is displayed", this.page.element(minusOption, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));

		return this;
	}
	/**********************************************************************************
	 * Description : This function is to click group link
	  * Date		: 15/12/2014
	  * Author		: Anil
	 **********************************************************************************/
	public FormConfiguration checkUseStanderdListChkBoxDisabeled()
			throws Exception {
		/*objWaitForElement.waitForElements("//label[text()='Use Standard List']/parent::div/div/input[@disabled='']",
				"xpath");
		assertTrue(this.page
				.element(
						"//label[text()='Use Standard List']/parent::div/div/input[@disabled='']",
						"xpath").getOne().isDisplayed());*/
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify Preview button is displayed.
	* Date 		  : 19-Jan-2015
	* Author 	  : Pallavi
	**********************************************************************************/
	public FormConfiguration verifyPreviewButtonIsDisplayed() throws Exception {
		objWaitForElement.waitForElements(previewButton,
				"xpath");
		assertTrue(
				this.page.element(previewButton, "xpath").getOne().isDisplayed(),
				"Preview Button is not displayed");
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify Preview button is displayed.
	* Date 		  : 19-Jan-2015
	* Author 	  : Pallavi
	**********************************************************************************/
	public FormConfiguration clickPreviewButton() throws Exception {
		objWaitForElement.waitForElements(previewButton,
				"xpath");
		this.page.element(previewButton, "xpath").getOne().sendKeys(Keys.ENTER);
		this.page
				.element_wait(
						"//section[contains(@style,'background-image: none; background-color')]",
						"xpath").waitForVisibilityOfElement();
		return this;
	}
	
    /**********************************************************************************
    * Description : This function is to verify Numeric OR Single Line text (text) Question and its 
    * 				field are in non editable format in preview window
    * Arguments   : strLabelName
    * Date        : 19-Jan-2015
    * Author      : Pallavi
    **********************************************************************************/
	public FormConfiguration verifyNumericOrSingleLineTextQuestionIsDisabled(
			String strLabelName) throws Exception {
		String strElement = "//span[text()='" + strLabelName
				+ "']/parent::label/parent::div//input[@disabled='']";
		objWaitForElement.waitForElements(strElement,
				"xpath");
		assertTrue(this.page.element(strElement, "xpath").getOne()
				.isDisplayed(), "Numeric/Single Line text is not in non editable format");
		return this;
	}
	
    /**********************************************************************************
    * Description : This function is to verify Multi Line text (textArea) Question and its 
    * 				field are in non editable format in preview window
    * Arguments   : strLabelName
    * Date        : 19-Jan-2015
    * Author      : Pallavi
    **********************************************************************************/
	public FormConfiguration verifyMultiLineTextQuestionIsDisabled(
			String strLabelName) throws Exception {
		String strElement = "//span[text()='" + strLabelName
				+ "']/parent::label/parent::div//textArea[@disabled='']";
		objWaitForElement.waitForElements(strElement,
				"xpath");
		assertTrue(this.page.element(strElement, "xpath").getOne()
				.isDisplayed(), "Multi Line text is not in non editable format");
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is to verify that Insert Link is not displayed.
	 * Date			: 19-Jan-2015
     * Author      	: Pallavi
	 **********************************************************************************/
	public FormConfiguration verifyInsertLinkNotDisplayed() throws Exception {
		assertFalse(this.page.element(insertLink, "xpath").isElementPresent(
				WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is to verify that Add button corresponding to Group Name is not displayed.
	 * Arguments   	: strGroupName
	 * Date			: 19-Jan-2015
     * Author      	: Pallavi
	 **********************************************************************************/
	public FormConfiguration verifyAddButtonForGroupIsNotDisplayed(
			String strGroupName) throws Exception {
		objWaitForElement.waitForElements("//span[text()='" + strGroupName + "']/ancestor::header",
				"xpath");
		assertTrue(this.page.element(
				"//span[text()='" + strGroupName + "']/ancestor::header",
				"xpath").getOne().isDisplayed());
		assertFalse(this.page.element(
				"//span[text()='" + strGroupName
						+ "']/ancestor::header//a/i[@class='icon-plus']",
				"xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}

	/**********************************************************************************
	  * Description : This function is verify question type is not displayed
	  * Date        : 09/06/2014
	  * Author      : Anil
	  **********************************************************************************/
	public FormConfiguration verifyQuestionTypeIsNotDisplayed()
			throws Exception {
		assertFalse(this.page.element(questionaireType, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on edit Instruction 
	  * Date		: 15/12/2014
	  * Author		: Anil
	 **********************************************************************************/
	public FormConfiguration clickOnEditInstruction(String strInstruction)
			throws Exception {
		objWaitForElement.waitForElements("//p[text()='"
				+ strInstruction
				+ "']/parent::span/parent::div//a[@href='#editModal']",
		"xpath");
		this.page
				.element(
						"//p[text()='"
								+ strInstruction
								+ "']/parent::span/parent::div//a[@href='#editModal']",
						"xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to select read receipt checkbox.
	 * Date     	: 20-Jan-2015
	 * Author    	: Renushree
	 **********************************************************************************/
	public FormConfiguration selReadReceipt()
			throws Exception {
		objWaitForElement.waitForElements(readReceipt, "css");
		assertTrue(this.page.element(readReceipt, "css").getOne().isDisplayed());
		this.page.element(readReceipt, "css").getOne().click();
		return this;
	}
	/**********************************************************************************
	 * Description  : This function is to click on edit of questionnaire link
	  * Date		: 15/12/2014
	  * Author		: Anil
	 **********************************************************************************/
	public FormConfiguration clickOnEditQuestionnaireNew(String strQustionName)
			throws Exception {
		objWaitForElement.waitForElements("//span[text()='"
				+ strQustionName
				+ "']/parent::label/following-sibling::div/following-sibling::div/a[1]", "xpath");
		this.page
				.element(
						"//span[text()='"+strQustionName+"']/parent::label/following-sibling::div/following-sibling::div/a[1]",
						"xpath").getOne().click();
		objWaitForElement.waitForElements(editQuestion, "xpath");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select question type
	  * Date        : 09/06/2014
	  * Author      : Anil
	  **********************************************************************************/
	public FormConfiguration selectQuestionTypeNew(String strQuestionType)
			throws Exception {
		objWaitForElement.waitForElements(questionaireOption, "xpath");
		assertTrue(this.page.element(questionaireOption, "xpath")
				.getOne().isDisplayed());
		this.page.element(questionaireOption, "xpath").webElementToSelect()
				.selectByVisibleText(strQuestionType);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on Save button in IE Browser.
	  * Date		: 23-Jan-2015
	  * Author		: Pallavi
	 **********************************************************************************/
	public FormConfiguration clickOnSaveButtonInIEBrowser() throws Exception {
		objWaitForElement.waitForElements(saveButton, "xpath");
		this.page.element(saveButton, "xpath").getOne().click();
		this.page
				.element_wait(
						"//section[contains(@style,'background-image: none; background-color')]",
						"xpath").waitForVisibilityOfElement();
		return this;
	}
	
	/**********************************************************************************
	 * Description	: This function is to click on Next Button in IE Browser.
	 * Date			: 23-Jan-2015
	 * Author		: Pallavi
	 **********************************************************************************/
	public FormConfiguration clickOnNextButtonInIEBrowser() throws Exception {
		objWaitForElement.waitForElements(nextButton, "css");
		this.page.element(nextButton, "css").getOne().sendKeys(Keys.ENTER);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Save' button in IE Browser.
	 * Date 	   : 23-Jan-2015
	 * Author 	   : Pallavi
	 **********************************************************************************/
	public FormConfiguration clickOnSaveOfFormSecuritySettingInIEBrowser()
			throws Exception {
		objWaitForElement.waitForElementBycssSelector(save);
		this.page.element(save, "css").getOne().sendKeys(Keys.ENTER);
		return this;
	}
	
	/**********************************************************************************
	* Description	: This function is to click on 'Questionnaire' link in IE Browser.
	* Date			: 23-Jan-2015
	* Author 	   	: Pallavi
	 **********************************************************************************/
	public FormConfiguration clickOnAcknowledgeFormInIEBrowser(
			String strStrFormName) throws Exception {
		objWaitForElement
				.waitForElementByxpathSelector("//td[text()='" + strStrFormName
						+ "']/parent::tr/td/a[text()='Questionnaire']");
		this.page
				.element(
						"//td[text()='" + strStrFormName
								+ "']/parent::tr/td/a[text()='Questionnaire']",
						"xpath").getOne().sendKeys(Keys.ENTER);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select 'Required' check box on 'Edit Question' screen. 
	  * Date		: 9-Feb-2015
	  * Author		: Pallavi
	 **********************************************************************************/
	public FormConfiguration selectRequiredCheckBox() throws Exception {
		objWaitForElement.waitForElements(requiredCheckBox, "xpath");
		if (this.page.element(requiredCheckBox, "xpath").getOne().isSelected() == false) {
			this.page.element(requiredCheckBox, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description  : This function is to verify 'Required' check box is displayed. 
	 * Date			: 10-Feb-2015
	 * Author		: Pallavi
	 **********************************************************************************/
	public FormConfiguration verRequiredCheckboxIsDisplayed() throws Exception {
		objWaitForElement.waitForElements(requiredCheckBox, "xpath");
		assertTrue(this.page.element(requiredCheckBox, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description  : This function is to verify 'Required' check box is not displayed. 
	 * Date			: 10-Feb-2015
	 * Author		: Pallavi
	 **********************************************************************************/
	public FormConfiguration verRequiredCheckboxIsNotDisplayd()
			throws Exception {
		assertFalse(this.page.element(requiredCheckBox, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description  : This function is to click on edit of question
	 * Date			: 15/12/2014
	 * Author		: Deepa
	**********************************************************************************/
	public FormConfiguration editQuestion(String strQustionName)
			throws Exception {
		String Element = "//div/label/span[contains(text(),'" + strQustionName
				+ "')]/parent::label/following-sibling::div[2]/a[1]/i";
		objWaitForElement.waitForElements(Element, "xpath");
		this.page.element(Element, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify that the added que choice2 is displayed
	* Arguments   : strLabel
	* Date 		  : 16-Jan-2015
	* Author 	  : Deepa
	**********************************************************************************/
	public FormConfiguration verifyAddedSecQueChoiceIsDis(String strLabel,
			String strChoice) throws Exception {
		String strElement = "//div/label/span[contains(text(),'"
				+ strLabel
				+ "')]/parent::label/following-sibling::div/span/label/span[contains(text(),'"
				+ strChoice + "')]";
		objWaitForElement.waitForElements(strElement, "xpath");
		assertTrue("Second Question choice is not displayed", this.page
				.element(strElement, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify that the added que choice1 is not displayed
	* Arguments   : strLabel
	* Date 		  : 16-Jan-2015
	* Author 	  : Deepa
	**********************************************************************************/
	public FormConfiguration verifyFirstQueChoiceIsNotDis(String strLabel,
			String strChoice) throws Exception {
		String strElement = "//div/label/span[contains(text(),'"
				+ strLabel
				+ "')]/parent::label/following-sibling::div/span/label/span[contains(text(),'"
				+ strChoice + "')]";
		assertFalse(
				this.page.element(strElement, "xpath").isElementPresent(
						WaitTimeConstants.WAIT_TIME_FOR_FALSE),
				"Checkbox is not displayed");
		return this;
	}
	
	/**********************************************************************************
	 * Description  : This function is to click done in edit question window
	  * Date		: 15/12/2014
	  * Author		: Deepa
	 **********************************************************************************/
	public FormConfiguration clickOnDoneButtonInEditQueWin() throws Exception {
		objWaitForElement.waitForElements("//div[@id='editQuestionModal']/form/div[2]/button", "xpath");
		this.page
				.element("//div[@id='editQuestionModal']/form/div[2]/button",
						"xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click group link
	  * Date		: 15/12/2014
	  * Author		: Anil
	 **********************************************************************************/
	public FormConfiguration deselectAddToSummary() throws Exception {
		objWaitForElement.waitForElements(addToSummary, "xpath");
		if(this.page.element(addToSummary, "xpath").getOne().isSelected()==true){
		this.page.element(addToSummary, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to enter default value in form
	   * Date        : 13-Feb-2015
	   * Author      : Deepa
	   **********************************************************************************/
		public FormConfiguration enterDefaultValue(String strDefaultValue)
				throws Exception {
			try{
				objWaitForElement.waitForElements("//div[@id='editQuestionModal']/form/div/span[3]//input", "xpath");
				
				this.page
				.element(
						"//div[@id='editQuestionModal']/form/div/span[3]//input",
						"xpath").clearInputValue().sendKeys(strDefaultValue);
			}catch(Exception E){
				Thread.sleep(100);
			}
			return this;
		}

	/**********************************************************************************
	   * Description : This function is to select Date type
	   * Date        : 16-Feb-2015
	   * Author      : Pallavi
	   **********************************************************************************/
	public FormConfiguration selectDateType(String strDateType)
			throws Exception {
		objWaitForElement.waitForElements(dateType, "xpath");
		this.page.element(dateType, "xpath").webElementToSelect()
				.selectByVisibleText(strDateType);
		assertTrue(this.page.element(dateType, "xpath").webElementToSelect()
				.getFirstSelectedOption().getText().equals(strDateType));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select 'Run Report' check box corresponding to user name in security page.
	 * Date 	   : 20-Feb-2015
	 * Author 	   : Pallavi
	 **********************************************************************************/
	public FormConfiguration selectRunReportInSecurityPageForAsCertainStatsChangs(String strUserName)
			throws Exception {
		String strChkBox = "//table[@id='tbl_rUserID']/tbody/tr/td[4][text()='"
							+ strUserName + "']/preceding-sibling::td[3]/input";
		objWaitForElement.waitForElements(strChkBox, "xpath");
		if (!(this.page.element(strChkBox, "xpath").getOne().isSelected())) {
			this.page.element(strChkBox, "xpath").getOne().click();
		}
		assertTrue(this.page.element(strChkBox, "xpath").getOne().isSelected());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select 'Activate Form' check box corresponding to user name.
	 * Date 	   : 15/12/2014
	 * Author 	   : Pallavi
	 **********************************************************************************/
	public FormConfiguration verifyAllUsersChkBoxIsSelected()
			throws Exception {
		objWaitForElement.waitForElements(allUsersCheckBox, "xpath");
		assertTrue(this.page.element(allUsersCheckBox, "xpath").getOne().isSelected());
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to select 'Activate Form' check box corresponding to user name.
	 * Date 	   : 15/12/2014
	 * Author 	   : Pallavi
	 **********************************************************************************/

	public FormConfiguration verifyAllResourcesChkBoxIsSelected()
			throws Exception {
		objWaitForElement.waitForElements(allResources, "css");
		assertTrue(this.page.element(allResources, "css").getOne().isSelected());
		return this;
	}
	
    /**********************************************************************************
	 * Description : This function is to select 'Activate Form' check box corresponding to user name.
	 * Date 	   : 15/12/2014
	 * Author 	   : Pallavi
	 **********************************************************************************/
	public FormConfiguration selectActivateFormChkBoxNew(String strUserName)
			throws Exception {
		String strChkBox = "//table[@id='tbl_userID']/tbody/tr/td[5][text()='"
				+ strUserName + "']/preceding-sibling::td[4]/input";
		objWaitForElement
		.waitForElements(strChkBox, "xpath");
		if (!(this.page.element(strChkBox, "xpath").getOne().isSelected())) {
			this.page.element(strChkBox, "xpath").mouseOver();
			this.page.element(strChkBox, "xpath").getOne().sendKeys(Keys.SPACE);
		}
		assertTrue(this.page.element(strChkBox, "xpath").getOne().isSelected());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to DeSelect read receipt checkbox.
	  * Date      	: 20-Feb-2015
	  * Author     	: Pallavi
	  **********************************************************************************/
	 public FormConfiguration deSelectReadReceipt() throws Exception {
			objWaitForElement
			.waitForElements(readReceipt, "css");
	  if (this.page.element(readReceipt, "css").getOne().isSelected() == true) {
	   this.page.element(readReceipt, "css").getOne().click();
	  }
	  assertFalse(this.page.element(readReceipt, "css").getOne().isSelected());
	  return this;
	 }
	 
		/**********************************************************************************
	  * Description : This function is to select question type
	  * Date        : 09/06/2014
	  * Author      : Anil
	  **********************************************************************************/
	public FormConfiguration selectDefaultForSingleSelect(
			String strDefaultAnswer) throws Exception {
		objWaitForElement
		.waitForElements(defaultSelect, "xpath");
		this.page.element(defaultSelect, "xpath").webElementToSelect()
				.selectByVisibleText(strDefaultAnswer);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on questionnaire link
	 * Date		   : 26/01/2015
	 * Author	   : Hanumegowda
	 **********************************************************************************/
	public FormConfiguration clickOnAcknowledgeForm1(String strStrFormName)
			throws Exception {
		objWaitForElement
				.waitForElements("//td[text()='" + strStrFormName
						+ "']/parent::tr/td/a[text()='Questionnaire']", "xpath");
		this.page
				.element(
						"//td[text()='" + strStrFormName
								+ "']/parent::tr/td/a[text()='Questionnaire']",
						"xpath").mouseOver();
		Thread.sleep(100);
		this.page
				.element(
						"//td[text()='" + strStrFormName
								+ "']/parent::tr/td/a[text()='Questionnaire']",
						"xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on AddChoice Pluse Button
	 * Date		   : 26/01/2015
	 * Author	   : Hanumegowda
	 **********************************************************************************/
	public FormConfiguration clickOnAddChoicePlusButton() throws Exception {
		objWaitForElement.waitForElements(choiceplusBtn, "xpath");
		this.page.element(choiceplusBtn, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Standard UserList CheckBox
	 * Date		   : 26/01/2015
	 * Author	   : Hanumegowda
	 **********************************************************************************/
	public FormConfiguration verifyuserStandardUserListCheckBox()
			throws Exception {
		objWaitForElement.waitForElements(UserStandardListCKB, "xpath");
		assertTrue("standard user list check box is not present", this.page
				.element(UserStandardListCKB, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on Standard UserList CheckBox
	 * Date		   : 26/01/2015
	 * Author	   : Hanumegowda
	 **********************************************************************************/
	public FormConfiguration clickOnUserStandardListCheckBox() throws Exception {
		objWaitForElement.waitForElements(UserstandardListCKB1, "xpath");
		this.page.element(UserstandardListCKB1, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Choice Add Button is disabled
	 * Date		   : 26/01/2015
	 * Author	   : Hanumegowda
	 **********************************************************************************/
	public FormConfiguration verifyChoiceBoxAddisDisabeled() throws Exception {
		assertFalse(this.page.element(choiceplusBtn, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Choice Minus Button is disabled
	 * Date		   : 26/01/2015
	 * Author	   : Hanumegowda
	 **********************************************************************************/
	public FormConfiguration verifyChoiceBoxMinusisDisabeled() throws Exception {
		assertFalse(this.page.element(choiceminusBtn, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on edit link of instruction
	 * Date		   : 09/02/2015
	 * Author	   : Hanumegowda
     **********************************************************************************/
	public FormConfiguration clickOnInstructionEditElement(
			String instructionName) throws Exception {
		objWaitForElement.waitForElements("//p[text()='"
				+ instructionName + "']/../..//a[@href='#editModal']", "xpath");
		this.page
				.element(
						"//p[text()='" + instructionName
								+ "']/../..//a[@href='#editModal']", "xpath")
				.getOne().click();
		return this;
	}
	
	/**********************************************************************************
     * Description : This function is to clear and enter new instruction.
	 * Date        : 10-Feb-2015
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public FormConfiguration enterInstructions1(String strInstruction)
			throws Exception {
		try {
			objWaitForElement.waitForElementByxpathSelector("//html/body");
			Thread.sleep(5000);
			driver.findElement(By.xpath("//html/body")).clear();

			this.page.element("//html/body", "xpath").getOne()
					.sendKeys(strInstruction);
		} catch (Exception e) {

		}
		return this;
	}
	 
    /**********************************************************************************
     * Description : This function is to verify Add To Summary check box is selected
	 * Date	       : 10/02/2015
	 * Author	   : Hanumegowda
	 **********************************************************************************/
	public FormConfiguration verifyAddToSummaryCheckBoxSelected()
			throws Exception {
		objWaitForElement
		.waitForElements(addToSummary, "xpath");
		assertTrue(this.page.element(addToSummary, "xpath").getOne()
				.isSelected());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click group link
	 * Date		   : 15/12/2014
	 * Author	   : Anil
	 **********************************************************************************/
	public FormConfiguration clickOnInsertElement1(String strAttributeName)
			throws Exception {
		objWaitForElement
				.waitForElements("//i[@title='Insert Element']", "xpath");
		this.page.element("//i[@title='Insert Element']", "xpath").getOne()
				.click();
		return this;
	}
	
	/**********************************************************************************
	 * Description  : This function is to select multiselect question type
	 * Date		    : 11/02/2015
	 * Author		: Hanumegowda
	 **********************************************************************************/
	public FormConfiguration selectQuestionType1(String strQuestionType)
			throws Exception {
		objWaitForElement.waitForElements(questionaireType, "xpath");
		this.page.element(questionaireType, "xpath");
		this.page.element("//option[text()='Multi Select']", "xpath").getOne()
				.click();
		return this;
	}
	
	/**********************************************************************************
	 * Description  : This function is to click on preview button
	 * Date		    : 11/02/2015
	 * Author		: Hanumegowda
	 **********************************************************************************/
	public FormConfiguration clickOnPreviewButton() throws Exception {
		objWaitForElement.waitForElements(previewbutton,"xpath");
		this.page.element(previewbutton, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description  : This function is to verify Form preview page
	 * Date		    : 11/02/2015
	 * Author		: Hanumegowda
	 **********************************************************************************/
	public FormConfiguration verFormInPreviewPage(String Preview)
			throws Exception {
		objWaitForElement.waitForElements("//h1[text()='Intermedix']/..//h3[contains(text(),'" + Preview
				+ "')]","xpath");
		assertTrue(this.page.element(
				"//h1[text()='Intermedix']/..//h3[contains(text(),'" + Preview
						+ "')]", "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description  : This function is to verify Group Name in preview page
	 * Date         : 11/02/2015
	 * Author		: Hanumegowda
	 **********************************************************************************/
	public FormConfiguration verGroupNameInPreviewPage(String GroupName)
			throws Exception {
		objWaitForElement.waitForElements("//span[text()='" + GroupName + "']",
				"xpath");
		assertTrue(this.page.element("//span[text()='" + GroupName + "']",
				"xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
     * Description  : This function is to verify Fieldset Attribute Name in preview page
	 * Date		    : 11/02/2015
	 * Author		: Hanumegowda
	 **********************************************************************************/
	public FormConfiguration verFieldSetNameInPreviewPage(String FieldSetName)
			throws Exception {
		objWaitForElement.waitForElements("//legend[text()='" + FieldSetName + "']",
				"xpath");
		assertTrue(this.page.element("//legend[text()='" + FieldSetName + "']",
				"xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description  : This function is to verify questionnairies in preview page
	 * Date		    : 11/02/2015
	 * Author		: Hanumegowda
	 **********************************************************************************/
	public FormConfiguration verQuestionTypesInPreviewPage(
			String strFieldSetName, String QuesetionName) throws Exception {
		objWaitForElement.waitForElements("//legend[text()='" + strFieldSetName + "']/..//span[text()='"
				+ QuesetionName + "']", "xpath");
		assertTrue(this.page.element(
				"//legend[text()='" + strFieldSetName + "']/..//span[text()='"
						+ QuesetionName + "']", "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description  : This function is to verify Preview Button in preview page
	 * Date		    : 11/02/2015
	 * Author		: Hanumegowda
	 **********************************************************************************/
	public FormConfiguration verPreviewButtonInPreviewPage() throws Exception {
		objWaitForElement.waitForElements(previewbutton1, "xpath");
		assertTrue(this.page.element(previewbutton1, "xpath")
				.getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description  : This function is to verify Print Button in preview page
	 * Date		    : 11/02/2015
	 * Author		: Hanumegowda
	 **********************************************************************************/
	public FormConfiguration verPrintButtonInPreviewPage() throws Exception {
		objWaitForElement.waitForElements(printButton, "xpath");
		assertTrue(this.page.element(printButton, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description  : This function is to verify Numeric, Singleline text,date question types are disabled in preview page 
	 * Date		    : 12/02/2015
	 * Author		: Hanumegowda
	 **********************************************************************************/
	public FormConfiguration verNumericOrSingleLineTextQuestionIsDisabled(
			String strFieldSetName, String QuesetionName) throws Exception {
		objWaitForElement.waitForElements("//legend[text()='" + strFieldSetName
				+ "']/following-sibling::div//label/span[text()='"
				+ QuesetionName
				+ "']/../following-sibling::div/input[@disabled='']",
		"xpath");
		assertTrue(this.page.element(
				"//legend[text()='" + strFieldSetName
						+ "']/following-sibling::div//label/span[text()='"
						+ QuesetionName
						+ "']/../following-sibling::div/input[@disabled='']",
				"xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Multi question types are disabled in preview page 
	 * Date        : 12/02/2015
	 *  Author     : Hanumegowda
	 **********************************************************************************/
	public FormConfiguration vermultiLineTextQuestionIsDisabled(
			String QuesetionName) throws Exception {
		objWaitForElement.waitForElements("//span[text()='" + QuesetionName
				+ "']/../..//textarea[@disabled='']", "xpath");
		assertTrue(this.page.element(
				"//span[text()='" + QuesetionName
						+ "']/../..//textarea[@disabled='']", "xpath")
				.getOne().isDisplayed());
		return this;

	}
	
	/**********************************************************************************
     * Description  : This function is to verify singleselect question types are disabled in preview page 
	 * Date		    : 12/02/2015
	 * Author		: Hanumegowda
	 **********************************************************************************/
	public FormConfiguration verSingleSelectQuestionIsDisabled(
			String QuesetionName) throws Exception {
		objWaitForElement.waitForElements("//span[text()='" + QuesetionName
				+ "']/../..//select[@disabled='']", "xpath");
		assertTrue(this.page.element(
				"//span[text()='" + QuesetionName
						+ "']/../..//select[@disabled='']", "xpath")
				.getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description  : This function is to verify Multiselect question types are disabled in preview page 
	 * Date		    : 12/02/2015
	 * Author		: Hanumegowda
	 **********************************************************************************/
	public FormConfiguration verMultiSelectQuestionIsDisabled(
			String QuesetionName) throws Exception {
		objWaitForElement.waitForElements("//span[text()='" + QuesetionName
				+ "']/../..//select[@disabled='']", "xpath");
		assertTrue(this.page.element(
				"//span[text()='" + QuesetionName
						+ "']/../..//select[@disabled='']", "xpath")
				.getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description  : This function is to select 'Required checkbox' in field edit page 
	 * Date		    : 13/02/2015
	 * Author		: Hanumegowda
	 **********************************************************************************/
	public FormConfiguration selectRequiredCheckBox1() throws Exception {
		objWaitForElement.waitForElements("//label[text()='Required']/..//input[@type='checkbox']",
				"xpath");
		this.page
				.element(
						"//label[text()='Required']/..//input[@type='checkbox']",
						"xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter a value in DecimalPlace box in field edit page 
	 * Date        : 13/02/2015 
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public FormConfiguration enterDecimalPlaceValue(String decimalValue)
			throws Exception {
		objWaitForElement.waitForElements(decimalplaces,
				"xpath");
		this.page.element(decimalplaces, "xpath").clearInputValue()
				.sendKeys(decimalValue);

		return this;
	}

	/**********************************************************************************
	 * Description  : This function is to click on edit link of choice
	 * Date		    : 13/02/2015
	 * Author		: Hanumegowda
	 **********************************************************************************/
	public FormConfiguration clickOnEditQuestionnaire1(String strQustionName)
			throws Exception {
		objWaitForElement.waitForElements("//span[text()='"
				+ strQustionName + "']/../../..//a[@href='#editModal']", "xpath");
		this.page
				.element(
						"//span[text()='" + strQustionName
								+ "']/../../..//a[@href='#editModal']", "xpath")
				.getOne().click();
		return this;
	}
				
	/**********************************************************************************
	 * Description : This function is to verify that the added que choice2 is displayed
	 * Arguments   : strLabel
	 * Date 	   : 02-Mar-2015
	 * Author 	   : Anil
	 **********************************************************************************/
	public FormConfiguration verifyAddedQueChoiceIsDisplayed(String strLabel,
			String strChoice) throws Exception {
		String strElement = "//div/label/span[contains(text(),'"
				+ strLabel
				+ "')]/parent::label/following-sibling::div/select/option[text()='"
				+ strChoice + "']";
		objWaitForElement.waitForElements(strElement, "xpath");
		assertTrue("Second Question choice is not displayed", this.page
				.element(strElement, "xpath").getOne().isDisplayed());
		return this;
	}
				
	/**********************************************************************************
	 * Description 	: This function is to select read receipt checkbox.
	 * Date     	: 20-Jan-2015
	 * Author    	: Renushree
	 **********************************************************************************/
	public FormConfiguration checkReadReceiptisEnabeled() throws Exception {
		objWaitForElement.waitForElements(readReceipt, "css");
		this.page.element(readReceipt, "css").isElementPresent();
		Thread.sleep(2000);
		assertTrue(this.page.element(readReceipt, "css").getOne().isEnabled());
		return this;
	}
		
    /**********************************************************************************
	 * Description 	: This function is to select read receipt checkbox.
	 * Date     	: 20-Jan-2015
	 * Author    	: Renushree
	 **********************************************************************************/
	public FormConfiguration checkReadReceiptisDisabled() throws Exception {
		objWaitForElement.waitForElements(readReceiptDisabled, "xpath");
		assertTrue(this.page.element(readReceiptDisabled, "xpath")
				.getOne().isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on Next Button
	 * Activation Drop Down
	 * Date : 10/11/2014 Author : sangappa.k
	 **********************************************************************************/
	public FormConfiguration clickOnCancelButton() throws Exception {
		objWaitForElement.waitForElements(cancelButton, "xpath");
		this.page.element(cancelButton, "css").mouseOver();
		this.page.element(cancelButton, "css").getOne().sendKeys(Keys.SPACE);
		return this;
	}
		
	/**********************************************************************************
	 * Description : This function is to select 'Carte Blanche' check box corresponding to user name in security page.
	 * Date 	   : 09/03/2015
	 * Author 	   : Renushree
	 **********************************************************************************/
	public FormConfiguration selectCarteBlancheChkBoxInSecurityPge(
			String strUserName) throws Exception {
		String strChkBox = "//table[@id='tbl_userID']/tbody/tr/td[5][text()='"
				+ strUserName + "']/preceding-sibling::td[2]/input";
		objWaitForElement.waitForElements(strChkBox, "xpath");
		if (!(this.page.element(strChkBox, "xpath").getOne().isSelected())) {
			this.page.element(strChkBox, "xpath").getOne().click();
		}
		assertTrue(this.page.element(strChkBox, "xpath").getOne().isSelected());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter text in 'Report Label' field.
	 * Date 	   : 12/03/2015
	 * Author 	   : Renushree
	 **********************************************************************************/
	public FormConfiguration enterTextInReportLabel(String strReportLabel)
			throws Exception {
		objWaitForElement.waitForElements(reportLabel, "css");
		assertTrue(this.page.element(reportLabel, "css").isElementPresent());
		this.page.element(reportLabel, "css").getOne().sendKeys(strReportLabel);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select 'Carte Blanche' check box corresponding
	 * 				 to user name in security page when Completed Form Delivery is selected 
	 * 				 as Certain Status changes/Templated Defined
	 * Date 	   : 13-Mar-2015
	 * Author 	   : Pallavi
	 **********************************************************************************/
	public FormConfiguration selectCarteBlancheInSecurityPageForAsCertainStatsChangs(String strUserName)
			throws Exception {
		String strChkBox = "//table[@id='tbl_rUserID']/tbody/tr/td[4][text()='"
							+ strUserName + "']/preceding-sibling::td[2]/input";
		objWaitForElement.waitForElements(strChkBox, "xpath");
		if (!(this.page.element(strChkBox, "xpath").getOne().isSelected())) {
			this.page.element(strChkBox, "xpath").getOne().click();
		}
		objWaitForElement.waitForElements(next, "xpath");
		assertTrue(this.page.element(strChkBox, "xpath").getOne().isSelected());
		return this;
	}
	
	/**********************************************************************************
	* Description  : This function is to click on Next button in "resources to fill form page"
	* Date		: 2/Mar/2015
	* Author		: Sangappa.k
	 **********************************************************************************/
	public FormConfiguration clickOnNextInResourcesToFillFormPage() throws Exception {
		objWaitForElement.waitForElements(next, "xpath");
	this.page.element(next, "xpath").getOne().click();
	return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify added choices are displayed
	  * Date		: 15/12/2014
	  * Author		: Anil
	 **********************************************************************************/
	public FormConfiguration verifyAddedChoices(String strChoiceName) throws Exception {
		objWaitForElement.waitForElements("//label/input[@type='checkbox']/following-sibling::span[text()='"+strChoiceName+"']", "xpath");
		assertTrue(this.page.element("//label/input[@type='checkbox']/following-sibling::span[text()='"+strChoiceName+"']", "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify Form title in Preview Page.
	* Arguments   : strFormTitle
	* Date 		  : 18-Mar-2015
	* Author 	  : Pallavi
	**********************************************************************************/
	public FormConfiguration verifyFormTitleInPreviewScreen(String strFormTitle)
			throws Exception {
		String strTitleElement = "//div[@id='header']//div/h3[contains(text(),'"
				+ strFormTitle + "')]";
		objWaitForElement.waitForElements(strTitleElement, "xpath");
		assertTrue(this.page.element(strTitleElement, "xpath")
				.isElementPresent(), "Form title is not displayed");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to Edit second Row in Edit FieldSet Window
	 * Date        : 18-Dec-2014
	 * Author      : Pallavi
	 **********************************************************************************/
	public FormConfiguration editSecondRowLabel(String strRowLabel)
			throws Exception {
		objWaitForElement.waitForElements(secondRowOfTable, "xpath");
		this.page.element(secondRowOfTable, "xpath").clearInputValue()
				.sendKeys(strRowLabel);
		assertTrue(strRowLabel.equals(this.page.element(secondRowOfTable, "xpath")
				.getOne().getAttribute("value")));
		return this;
	}

    /**********************************************************************************
    * Description : This function is to verify Numeric OR Single Line text (text) Question and its 
    * 				field are in non editable format in preview window for Table Questionnaire
    * Arguments   : strRowName, strNoOfColumns
    * Date        : 20-Mar-2015
    * Author      : Pallavi
    **********************************************************************************/
	public FormConfiguration verifyColumnsOfTypeNumOrTxtQtnsAreDisabled(
			String strRowName, String strColumnIndex) throws Exception {
		String strElement = "//span[text()='" + strRowName
				+ "']/parent::th/following-sibling::td[" + strColumnIndex
				+ "]//input[@disabled='']";
		objWaitForElement.waitForElements(strElement, "xpath");
		assertTrue(this.page.element(strElement, "xpath").getOne()
				.isDisplayed(),
				"Numeric/Single Line text is not in non editable format in Table");
		return this;
	}

    /**********************************************************************************
    * Description : This function is to verify Numeric OR Single Line text (text) Question and its 
    * 				field are in non editable format in preview window for Table Questionnaire
    * Arguments   : strRowName, strNoOfColumns
    * Date        : 20-Mar-2015
    * Author      : Pallavi
    **********************************************************************************/
	public FormConfiguration verifyColumnsOfMultiLineTxtQtnsAreDisabled(
			String strRowName, String strColumnIndex) throws Exception {
		String strElement = "//span[text()='" + strRowName
				+ "']/parent::th/following-sibling::td[" + strColumnIndex
				+ "]//textarea[@disabled='']";
		objWaitForElement.waitForElements(strElement, "xpath");
		assertTrue(this.page.element(strElement, "xpath").getOne()
				.isDisplayed(),
				"Multi Line text is not in non editable format in Table");
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on mandatory checkbox
	* Date 		  : 30/03/2015
	* Author 	  : Anil
	**********************************************************************************/
	public FormConfiguration clickOnMandatoryCheckbox() throws Exception {
		objWaitForElement.waitForElements(mandatoryOption, "css");
		this.page.element(mandatoryOption, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify Report Button is not displayed in 'Template Designer' page
	* Date 		  : 31/03/2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public FormConfiguration verReportButton() throws Exception {
		assertFalse(this.page.element("//a[text()='Report']", "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE), "Report Button Displayed");
		return this;
	}

	 /**********************************************************************************
	    * Description : This function is to verify watermark to numeric type while configuring the forms
	    * Arguments   : strLabelName
	    * Date        : 30-Mar-2015
	    * Author      : Renushree
	    **********************************************************************************/
	public FormConfiguration verNumericWaterMarkWhileAddingQues(
			String strLabelName, String strWaterMark) throws Exception {
		objWaitForElement.waitForElements("//span[text()='"
				+ strLabelName
				+ "']/parent::label/following-sibling::div/input[@placeholder='"
				+ strWaterMark + "']", "xpath");
		assertTrue(
				this.page
						.element(
								"//span[text()='"
										+ strLabelName
										+ "']/parent::label/following-sibling::div/input[@placeholder='"
										+ strWaterMark + "']", "xpath")
						.getOne().isDisplayed(), "Watermark is not diplayed");
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify mandatory option is displayed
	* Arguments   : strLabelName
	* Date 		  : 15/12/2014
	* Author 	  : Anil
	**********************************************************************************/
	public FormConfiguration verifyMandatoryMarkForQuestion(String strLabelName)
			throws Exception {
		String strLabelAnswer = "//span[text()='"+strLabelName+"']/following-sibling::span/i[@data-original-title='Mandatory']";
		objWaitForElement.waitForElements(strLabelAnswer, "xpath");
		assertTrue(this.page.element(strLabelAnswer, "xpath").getOne().isDisplayed(),
				"Numeric field is not displayed");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify user not selected in form security setting form
	  * Date        : 18-Dec-2014
	  * Author      : Deepa
	  **********************************************************************************/
	public FormConfiguration verifyUserInFormSecuritySettingNotSelected(String strUserName)
			throws Exception {
		String elementID = "//table[@id='tbl_userID']/tbody/tr/td[5][contains(text(),'"
				+ strUserName + "')]/parent::tr/td[1]/input";
		this.page.element(elementID, "xpath").isElementPresent();
		assertFalse(this.page.element(elementID, "xpath").getOne().isSelected());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click onAcknowledge link
	  * Date		: 15/12/2014
	  * Author		: Anil
	 **********************************************************************************/
	public FormConfiguration clickOnSecurityLinkOfFormNew(String strStrFormName)
			throws Exception {
		objWaitForElement.waitForElementByxpathSelector("//td[text()='"
				+ strStrFormName + "']/parent::tr/td/a[text()='Security']");
		this.page.element(
				"//td[text()='" + strStrFormName
						+ "']/parent::tr/td/a[text()='Security']", "xpath")
				.mouseOver();
		this.page
				.element(
						"//td[text()='" + strStrFormName
								+ "']/parent::tr/td/a[text()='Security']",
						"xpath").getOne().sendKeys(Keys.ENTER);
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify that form is not created.
	 * Arguments	: strStrFormName
	 * Date			: 03/04/2015
	 * Author		: Renushree
	 **********************************************************************************/
	public FormConfiguration verFormIsNotCreated(String strStrFormName)
			throws Exception {
		objWaitForElement.waitForElements("//table[@summary='Form Templates']", "xpath");
		assertFalse(
				this.page.element(
						"//table[@summary='Form Templates']/tbody/tr/td[text()='"
								+ strStrFormName + "']", "xpath")
						.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE), "Form is displayed");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter text in ToolTip Help.
	 * Date 	   : 06/04/2015
	 * Author 	   : Hanumegowda
	 **********************************************************************************/
	public FormConfiguration enterTextInToolTipHelp(String toolTipText)
			throws Exception {
		objWaitForElement.waitForElements("//fieldset//div/label[text()='ToolTip Help']/..//input[@data-bind='value: help']",
				"xpath");
		assertTrue(this.page
				.element(
						"//fieldset//div/label[text()='ToolTip Help']/..//input[@data-bind='value: help']",
						"xpath").isElementPresent());
		this.page
				.element(
						"//fieldset//div/label[text()='ToolTip Help']/..//input[@data-bind='value: help']",
						"xpath").clearInputValue().sendKeys(toolTipText);
		return this;
	}

	/**********************************************************************************
	* Description   : This function is to enter Minimum Value for numeric question type
	* Date		    : 06/04/2015
	* Author		: Hanumegowda
	**********************************************************************************/
	public FormConfiguration enterMinimumValue(String strMinimumValue)
			throws Exception {
		objWaitForElement.waitForElements(minimumValue, "xpath");
		this.page.element(minimumValue, "xpath").clearInputValue()
				.sendKeys(strMinimumValue);
		return this;
	}

	/**********************************************************************************
	* Description   : This function is to enter Maximum Value for numeric question type
	* Date		    : 06/04/2015
	* Author		: Hanumegowda
	**********************************************************************************/
	public FormConfiguration enterMaximumValue(String strMaximumValue)
			throws Exception {
		objWaitForElement.waitForElements(maximumValue, "xpath");
		this.page.element(maximumValue, "xpath").clearInputValue()
				.sendKeys(strMaximumValue);
		return this;
	}

	/**********************************************************************************
	* Description : This function is to verify tooltip help question mark symbol  is displayed
	* Arguments   : strLabelName, toolTipText
	* Date 		  : 06/04/2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public FormConfiguration verifyToolTipQuestionMarkSymbol(String strLabelName, String toolTipText)
			throws Exception {
		String strLabelAnswer = "//span[text()='"+strLabelName+"']/following-sibling::span/i[@data-original-title='"+toolTipText+"']";
		objWaitForElement.waitForElements(strLabelAnswer, "xpath");
		assertTrue(this.page.element(strLabelAnswer, "xpath").getOne().isDisplayed(),
				"Numeric field is not displayed");
		return this;
	}
	/**********************************************************************************
	* Description   : This function is to deSelect 'Active' check box
	* Date		    : 09-Apr-2015
	* Author		: Pallavi
	**********************************************************************************/
	public FormConfiguration deSelctActiveChkBox() throws Exception {
		objWaitForElement.waitForElements(activeChkBox, "xpath");
		if(this.page.element(activeChkBox, "xpath").getOne().isSelected()) {
			this.page.element(activeChkBox, "xpath").getOne().click();
		}
		assertFalse(this.page.element(activeChkBox, "xpath").getOne().isSelected());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Required' text is not present for a mandatory question.
	 * Arguments   : strLabelName
	 * Date     : 13-Apr-2015
	 * Author    : Sangappa.k
	 **********************************************************************************/
	 public FormConfiguration verifyRequiedTextForMandatoryQuestionIsNotDisplayed(String strLabelName)
	   throws Exception {
	 String res="//span[text()='"
	        + strLabelName
	        + "']/parent::label/span[2]/i[@data-original-title='Mandatory']"; 
	  /*objWaitForElement
	    .isElementPresent(By.xpath(res),2);*/
	  assertFalse(this.page
	    .element(res,"xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
	  return this;
	 }
	 
	/**********************************************************************************
	 * Description : This function is to verify mandatoryMark is not displayed for option question type
	 * Arguments   : strLabelName
	 * Date 	   : 14/Apr/2015
	 * Author 	   : Hanumegowda
	 **********************************************************************************/
	public FormConfiguration verifyMandatoryMarkForQuestionIsNotDisplayed(
			String strLabelName) throws Exception {
		String strLabelAnswer = "//span[text()='"
				+ strLabelName
				+ "']/following-sibling::span/i[@data-original-title='Mandatory']";
		assertFalse(this.page.element(strLabelAnswer, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE),
				"Numeric field is displayed");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Required' text is not displayed for optional question.
	 * Arguments   : strLabelName
	 * Date 	   : 14/Apr/2015
	 * Author 	   : Hanumegowda
	 **********************************************************************************/
	public FormConfiguration verRequiredTextIsNotDisplayedForOptionalQuestionType(
			String strLabelName) throws Exception {
		String strLabelAnswer = "//span[text()='" + strLabelName
				+ "']/../..//span[text()='Required']";
		assertFalse(this.page.element(strLabelAnswer, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE),
				"Required text is displayed");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select "Allowed Dates" Radio Button For Date QuestionType"
	 * Arguments   : strLabelName
	 * Date 	   : 21/Apr/2015
	 * Author 	   : Sangappa.k
	 **********************************************************************************/
	public FormConfiguration selectAllowedDatesRadioButtonForDateQuestionType(
			String strRadioBtn) throws Exception {
		String strLabelAnswer = "//label[contains(text(),'" + strRadioBtn + "')]";
		this.page.element(strLabelAnswer, "xpath").getOne().click();		
		return this;
	}	

	/**********************************************************************************
	 * Description : This function is to click on 'Past dates only (excluding today)' radio button
	 * Date        : 22/04/2015 
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public FormConfiguration clickOnPastDatesOnlyExcludingTodayRadioButton()
			throws Exception {
		objWaitForElement.waitForElements(Pastdatesonly, "css");
		this.page.element(Pastdatesonly, "css").getOne().click();
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to select "Allowed Dates"Date range between mm/dd/yyyy and mm/dd/yyyy"
	 *               radio Btn.
	 * Date 	   : 22/Apr/2015
	 * Author 	   : Sangappa.k
	 **********************************************************************************/
	public FormConfiguration selectDateRangeBetweenRadioBtnForDateQuestionType() throws Exception {
		objWaitForElement.waitForElements(strDateRange, "xpath");
		this.page.element(strDateRange, "xpath").getOne().click();		
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select From date for Date range between mm/dd/yyyy and mm/dd/yyyy radio 
	 *               radio button
	 *               radio Btn.
	 * Date 	   : 22/Apr/2015
	 * Author 	   : Sangappa.k
	 **********************************************************************************/
	public FormConfiguration entereStartDateForDateRangeBetweenRadioBtn(String strFromDate) throws Exception {
		
		/*String strFromField="//input[@data-bind='value: lowerDateBound, datePicker: true']";
		objWaitForElement.waitForElements(strFromField, "xpath");
		this.page.element(strFromField, "xpath").getOne().click();
		this.page.element(strFromField, "xpath").getOne().sendKeys(strFromDate);*/
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select To date for Date range between mm/dd/yyyy and mm/dd/yyyy radio 
	 *               radio button
	 *               radio Btn.
	 * Date 	   : 22/Apr/2015
	 * Author 	   : Sangappa.k
	 **********************************************************************************/
	public FormConfiguration entereEndDateForDateRangeBetweenRadioBtn(String strTodate) throws Exception {
		
		/*String strToField="//input[@data-bind='value: upperDateBound, datePicker: true']";
		objWaitForElement.waitForElements(strToField, "xpath");
		this.page.element(strToField, "xpath").getOne().click();
		this.page.element(strToField, "xpath").getOne().sendKeys(strTodate);*/
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select  or click on "Allowed Dates"Date range between XXXX days ago
	                 and YYYY days from now" radio Btn.
	 *           
	 * Date 	   : 23/Apr/2015
	 * Author 	   : Sangappa.k
	 **********************************************************************************/
	public FormConfiguration selXDayAgoAndYDaysFromNowRadioBtn()
			throws Exception {
		objWaitForElement.waitForElements(strDateRange2, "xpath");
		this.page.element(strDateRange2, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to entere Start date for Date range between XXXX days ago
	                 and YYYY days from now" radio Btn.
	 *               radio Btn.
	 * Date 	   : 23/Apr/2015
	 * Author 	   : Sangappa.k
	 **********************************************************************************/
	public FormConfiguration enterStartCountForXDaysAgoField(
			String strStartDay) throws Exception {
		/*objWaitForElement.waitForElements(startDayFiled, "xpath");
		this.page.element(startDayFiled, "xpath").getOne().click();
		this.page.element(startDayFiled, "xpath").getOne()
				.sendKeys(strStartDay);*/
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to entere End date for Date range between XXXX days ago
	                 and YYYY days from now" radio Btn.
	 *               radio Btn.
	 * Date 	   : 23/Apr/2015
	 * Author 	   : Sangappa.k
	 **********************************************************************************/
	public FormConfiguration entersEndCountForYDaysNowField(
			String strEndDay) throws Exception {
		/*objWaitForElement.waitForElements(endDayField, "xpath");
		this.page.element(endDayField, "xpath").getOne().click();
		this.page.element(endDayField, "xpath").getOne().sendKeys(strEndDay);*/
		return this;
	}
	
    /**********************************************************************************
	 * Description : This function is to deSelect 'All Users' check box
	 * Date        : 19-Dec-2014
	 * Author      : Pallavi
	 **********************************************************************************/
	public FormConfiguration deSelectUsersCheckBox(String strUserName) throws Exception {
		String elementID = "//table[@id='tbl_userID']/tbody/tr/td[3][contains(text(),'"
				+ strUserName + "')]/parent::tr/td[1]/input";
		objWaitForElement.waitForElements(elementID, "xpath");
		if (this.page.element(elementID, "xpath").getOne().isSelected()) {
			this.page.element(elementID, "xpath").getOne().click();
		}
		assertFalse(this.page.element(elementID, "xpath").getOne()
				.isSelected());
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to click on Pencil Icon In Edit Field Set OfTable
	 *               (Edit button) 
	 * Date 	   : 23/Apr/2015
	 * Author 	   : Sangappa.k
	 **********************************************************************************/
	public FormConfiguration clickOnPencilIconInEditFieldSetOfTable(int NthColumn) throws Exception {
		
		String icon="//li["+NthColumn+"]/a[@data-target='#editQuestionModal']/i";
		System.out.println(icon);
		objWaitForElement.waitForElements(icon, "xpath");
		this.page.element(icon, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on Pencil Icon In Edit Field Set OfTable
	 *               (Edit button) 
	 * Date 	   : 23/Apr/2015
	 * Author 	   : Sangappa.k
	 **********************************************************************************/
	public FormConfiguration verMandotryMarkIsNotDisplayedForTable(
			String strColumnName) throws Exception {

		String column = "//span[text()='" + strColumnName
				+ "']/..//span/i[@data-original-title='Mandatory']";
		System.out.println(column);
		assertFalse(this.page.element(column, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Form name in Form Configuration page
	 *               
	 * Date 	   : 7/May/2015
	 * Author 	   : Sangappa.k
	 **********************************************************************************/
	public FormConfiguration verFormTittle(String strFormName) throws Exception {

		String form = "//header/h2/span[text()='"+strFormName+"']";
		objWaitForElement.waitForElement(form);
		String Formtittle = this.page.element(form, "xpath").getOne().getText();
		assertTrue(Formtittle.equals(strFormName), "Form  tittle is not equal");
		assertTrue(this.page.element(form, "xpath").isElementPresent());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify Form Description in Form Configuration page
	 *              
	 * Date 	   : 7/May/2015
	 * Author 	   : Sangappa.k
	 **********************************************************************************/
	public FormConfiguration verFormDescription(String strFormDesc)
			throws Exception {

		String desc = "//table[@class='displayTable striped border sortable']/tbody/tr/td[contains(text(),'"
				+ strFormDesc + "')]";
		objWaitForElement.waitForElement(desc);
		String FormDesc = this.page.element(desc, "xpath").getOne().getText();
		assertTrue(FormDesc.equals(strFormDesc),
				"Form  description is not equal");
		assertTrue(this.page.element(desc, "xpath").isElementPresent());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify Form name in Form tittle field
	 *               
	 * Date 	   : 7/May/2015
	 * Author 	   : Sangappa.k
	 **********************************************************************************/
	public FormConfiguration verFormTittleInFormField(String strFormTittle)
			throws Exception {

		String strTittle = "//input[@value='" + strFormTittle + "']";
		objWaitForElement.waitForElement(strTittle);
		assertTrue(this.page.element(strTittle, "xpath").isElementPresent());
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify Form Description in Description field
	 *              
	 * Date 	   : 7/May/2015
	 * Author 	   : Sangappa.k
	 **********************************************************************************/
	public FormConfiguration verFormDescriptionInDescriptionField(
			String strFormDesc) throws Exception {

		String desc = "//td/textarea[contains(text(),'" + strFormDesc + "')]";
		objWaitForElement.waitForElement(desc);
		assertTrue(this.page.element(desc, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Form Activation  field
	 *              
	 * Date 	   : 7/May/2015
	 * Author 	   : Sangappa.k
	 **********************************************************************************/
	public FormConfiguration verSelectedActivationFieldInDropDown(
			String ActField) throws Exception {

		String Act = "//select[@name='promptType']/option[@selected='selected'][contains(text(),'"+ActField+"')]";
		objWaitForElement.waitForElement(Act);
		assertTrue(this.page.element(Act, "xpath").isElementPresent());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify Form Activation  field
	 *              
	 * Date 	   : 7/May/2015
	 * Author 	   : Sangappa.k
	 **********************************************************************************/
	public FormConfiguration verSelecetdCompletedFormDeliveryInDropDown(
			String CField) throws Exception {

		String Cfield = "//select[@name='recipientType']/option[@selected='selected'][contains(text(),'"+CField+"')]";
		objWaitForElement.waitForElement(Cfield);
		assertTrue(this.page.element(Cfield, "xpath").isElementPresent());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify Form Activation  field
	 *              
	 * Date 	   : 7/May/2015
	 * Author 	   : Sangappa.k
	 **********************************************************************************/
	public FormConfiguration verEditFormTempltePage() throws Exception {

		objWaitForElement.waitForElement(strEditpage);

		assertTrue(this.page.element(strEditpage, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description   : This function is to verify 'Edit Form Template' page is displayed.
	* Date		    : 07/May/2015
	* Author		: Hanumegowda
	**********************************************************************************/
	public FormConfiguration verifyEditFormTemplatePageIsDisplayed()
			throws Exception {
		objWaitForElement.waitForElements(editFormTemplate, "xpath");
		assertTrue(this.page.element(editFormTemplate, "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description   : This function is to verify  form title in'Edit Form Template' page.
	* Date		    : 07/May/2015
	* Author		: Hanumegowda
	**********************************************************************************/
	public FormConfiguration verifyFormTitleInEditFormTemplatePage(
			String expected) throws Exception {
		objWaitForElement.waitForElements(formTitle, "xpath");
		String actual = this.page.element(formTitle, "xpath").getOne()
				.getAttribute("value");
		assertEquals(actual, expected);
		return this;
	}
	
	/**********************************************************************************
	* Description   : This function is to verify  form Description in'Edit Form Template' page.
	* Date		    : 07/May/2015
	* Author		: Hanumegowda
	**********************************************************************************/
	public FormConfiguration verifyFormDescriptionInEditFormTemplatePage(
			String expected) throws Exception {
		objWaitForElement.waitForElements(formDescription, "xpath");
		String actual = this.page.element(formDescription, "xpath").getOne()
				.getText();
		assertTrue(actual.contains(expected));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify users to receive complete form checkbox is selected.
	 * Date        : 07-May-2015
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public FormConfiguration verSelUserToRcvCompltdFormCheckBoxIsSelected(
			String strUserName) throws Exception {
		String elementID = "//table[@id='tbl_userID']/tbody/tr/td[3][contains(text(),'"
				+ strUserName + "')]/parent::tr/td[1]/input";
		objWaitForElement.waitForElements(elementID, "xpath");
		assertTrue(this.page.element(elementID, "xpath").getOne().isSelected());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify user is selected in form security setting form page
	 * Date        : 07-May-2015
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public FormConfiguration verifyUserInFormSecuritySettingIsSelected(
			String strUserName) throws Exception {
		String elementID = "//table[@id='tbl_userID']/tbody/tr/td[5][contains(text(),'"
				+ strUserName + "')]/parent::tr/td[1]/input";
		objWaitForElement.waitForElements(elementID, "xpath");
		this.page.element(elementID, "xpath").isElementPresent();
		assertTrue(this.page.element(elementID, "xpath").getOne().isSelected());
		return this;
	}
	
	/**********************************************************************************
     * Description  : This function is to verify Fieldset Attribute Name in Template Designer page
	 * Date		    : 07/05/2015
	 * Author		: Hanumegowda
	 **********************************************************************************/
	public FormConfiguration verFieldSetOrAttributeNameInTemplateDesignerPage(
			String FieldSetName) throws Exception {
		objWaitForElement.waitForElements("//span[text()='"
				+ FieldSetName + "']", "xpath");
		assertTrue(this.page
				.element("//span[text()='" + FieldSetName + "']",
						"xpath").getOne().isDisplayed());
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify  Table Mandotry Mark Is Not Displayed For Table
	 *               (Edit button) 
	 * Date 	   : 23/Apr/2015
	 * Author 	   : Sangappa.k
	 **********************************************************************************/
	public FormConfiguration verMandotryMarkIsNotDisplayedForTableColumn(
			String strColumnName) throws Exception {

		String column = "//span[text()='" + strColumnName
				+ "']/..//span/i[@data-original-title='Mandatory']";
		assertFalse(this.page.element(column, "xpath").isElementPresent(
				WaitTimeConstants.WAIT_TIME_FOR_FALSE));

		return this;
	}
 /**********************************************************************************
	 * Description : This function is to verify  Table Mandotry Mark Is Not Displayed For Table
	 *               (Edit button) 
	 * Date 	   : 23/Apr/2015
	 * Author 	   : Sangappa.k
	**********************************************************************************/
	public FormConfiguration verMandotryMarkIsNotDisplayedForTableRow(
			String RowName) throws Exception {
		String row = "//span[text()='" + RowName
				+ "']/..//span/i[@data-original-title='Mandatory']";
		assertFalse(this.page.element(row, "xpath").isElementPresent(
				WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to check 'how to notify' checkboxes is selected.
	 * Date        : 08-Apr-2015
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public FormConfiguration verHowToNotifyCheckBoxesIsSelected(
			String strHowToNotify) throws Exception {
		if (strHowToNotify.equals("Check if notify via web")) {
			assertTrue(this.page.element(notifyViaWeb, "css").getOne()
					.isSelected());
		} else if (strHowToNotify.equals("Check if notify via email")) {
			assertTrue(this.page.element(notifyViaEmail, "css").getOne()
					.isSelected());
		} else if (strHowToNotify.equals("Check if notify via pager ")) {
			assertTrue(this.page.element(notifyViaPager, "css").getOne()
					.isSelected());
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'users to receive complete form' checkbox is not selected for corresponding user.
	 * Date        : 08-May-2015
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public FormConfiguration verSelUserToRcvCompltdFormCheckBoxIsNotSelected(
			String strUserName) throws Exception {
		String elementID = "//table[@id='tbl_userID']/tbody/tr/td[3][contains(text(),'"
				+ strUserName + "')]/parent::tr/td[1]/input";
		objWaitForElement.waitForElements(elementID, "xpath");
		assertFalse(this.page.element(elementID, "xpath").getOne().isSelected());
		return this;
	}
	
	 /**********************************************************************************
	  * Description : This function is to deselect corresponding user checkbox in 'users to receive complete form' page
	  * Date        : 08-Apr-2015
	  * Author      : Hanumegowda
	  **********************************************************************************/
	public FormConfiguration deselUserToRcvCompltdForm(String strUserName)
			throws Exception {
		String elementID = "//table[@id='tbl_userID']/tbody/tr/td[3][contains(text(),'"
				+ strUserName + "')]/parent::tr/td[1]/input";
		objWaitForElement.waitForElements(elementID, "xpath");
		if (this.page.element(elementID, "xpath").getOne().isSelected() == true) {
			assertTrue(this.page.element(elementID, "xpath").isElementPresent());
			this.page.element(elementID, "xpath").mouseOver();
			this.page.element(elementID, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to deselect 'Activate Form' check box corresponding to user name.
	 * Date 	   : 08-Apr-2015
	 * Author 	   : Hanumegowda
	 **********************************************************************************/
	public FormConfiguration deselectActivateFormChkBox(String strUserName)
			throws Exception {
		String strChkBox = "//table[@id='tbl_userID']/tbody/tr/td[5][text()='"
				+ strUserName + "']/preceding-sibling::td[4]/input";
		objWaitForElement.waitForElements(strChkBox, "xpath");
		if ((this.page.element(strChkBox, "xpath").getOne().isSelected())) {
			this.page.element(strChkBox, "xpath").getOne().click();
		}
		return this;
	}

	/**********************************************************************************
	* Description : This function is to deselect Active checkbox
	* Date 		  : 10/11/2014
	* Author 	  : Anil
	**********************************************************************************/
	public FormConfiguration deselectActiveFormCheckBox() throws Exception {
		objWaitForElement.waitForElements(activeCheckBox, "name");
		if(this.page.element(activeCheckBox, "name").getOne().isSelected()==true){
			this.page.element(activeCheckBox, "name").getOne().click();
		}	
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to select Active checkbox
	* Date 		  : 10/11/2014
	* Author 	  : Anil
	**********************************************************************************/
	public FormConfiguration selectActiveFormCheckBox() throws Exception {
		objWaitForElement.waitForElements(activeCheckBox, "name");
		if(this.page.element(activeCheckBox, "name").getOne().isSelected()==false){
			this.page.element(activeCheckBox, "name").getOne().click();
		}	
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to deselect resources check box 
	 * Date 	   : 08-May-2015
	 * Author 	   : Sangappa.k
	 **********************************************************************************/
	public FormConfiguration deselectResources(String strResourceName)
			throws Exception {
		objWaitForElement.waitForElementByxpathSelector("//td[text()='"
				+ strResourceName + "']/preceding-sibling::td/input");
		if (this.page
				.element(
						"//td[text()='" + strResourceName
								+ "']/preceding-sibling::td/input", "xpath")
				.getOne().isSelected() == true) {
			this.page
					.element(
							"//td[text()='" + strResourceName
									+ "']/preceding-sibling::td/input", "xpath")
					.getOne().click();
		}
		return this;
	}	
	/**********************************************************************************
	 * Description : This function is to verify  Table Mandotry Mark is Displayed For Table
	 *               (Edit button) 
	 * Date 	   : 13/May/2015
	 * Author 	   : Sangappa.k
	 **********************************************************************************/
	public FormConfiguration verMandotryMarkIsDisplayedForTableColumn(
			String strColumnName) throws Exception {
		String column = "//span[text()='" + strColumnName
				+ "']/..//span/i[@data-original-title='Mandatory']";
		objWaitForElement.waitForElement(column, "xpath");
		assertTrue(this.page.element(column, "xpath").isElementPresent());
		return this;
	}	
	
	/**********************************************************************************
  	* Description : This function is to verify rows name of different tables are duplicate in the same form. 
  	* Arguments   : rows
  	* Date 		  : 14-May-2015
  	* Author 	  : Hanumegowda
  	**********************************************************************************/
	public FormConfiguration verRowsOfDifferentTablesAreDuplicate(String[] rows)
			throws Exception {
		int c = rows.length;
		for (int i = 1; i <= c; i++) {
			String str = this.page
					.element("//span/div[1]//tbody/tr[" + i + "]/th/span",
							"xpath").getOne().getText();
			String str1 = this.page
					.element("//span/div[2]//tbody/tr[" + i + "]/th/span",
							"xpath").getOne().getText();
			assertTrue(str.equals(str1));
		}
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify  duplicate column names of table               
	 * Date 	   : 14/May/2015
	 * Author 	   : Sangappa.k
	 **********************************************************************************/
	public FormConfiguration verDuplicateColumnNamesOfTable1And2(
			String strDuplicateColumnNames) throws Exception {
		String column1 = "//div[contains(@data-bind,'template: { data: bareTable, name: ')][1]/div//table/thead/tr/th/span[contains(text(),'"
				+ strDuplicateColumnNames + "')]";
		String column2 = "//div[contains(@data-bind,'template: { data: bareTable, name: ')][2]/div//table/thead/tr/th/span[contains(text(),'"
				+ strDuplicateColumnNames + "')]";
		assertTrue(this.page.element(column1, "xpath").isElementPresent());
		assertEquals(this.page.element(column1, "xpath").getOne().getText(),
				strDuplicateColumnNames);
		/*WebElement element = driver.findElement(By.xpath(column2));
		this.page.element(column2, "xpath").scrollDownTillElement(element);
		this.page.element_wait(column2, "xpath").waitForVisibilityOfElement();*/
		assertTrue(this.page.element(column2, "xpath").isElementPresent());
		assertEquals(this.page.element(column2, "xpath").getOne().getText(),
				strDuplicateColumnNames);
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify  duplicate column names of table under group             
	 * Date 	   : 13/May/2015
	 * Author 	   : Sangappa.k
	 **********************************************************************************/
	public FormConfiguration verDuplicateColumnNamesOfTableUnderGroup(
			String strGroupName, String strColumnNames) throws Exception {

		String column = "//span[@data-bind='text: label'][contains(text(),'"
				+ strGroupName
				+ "')]/../../../div[@class='suit-section-content']//th/span[contains(text(),'"
				+ strColumnNames + "')]";
		objWaitForElement.waitForElement(column, "xpath");
		assertTrue(this.page.element(column, "xpath").isElementPresent());
		assertEquals(this.page.element(column, "xpath").getOne().getText(),
				strColumnNames);

		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify status type name is displayed
	 * Date 	   : 19-May-2015
	 * Author 	   : Pallavi
	 **********************************************************************************/
	public FormConfiguration verifyStatusTypeIsDisplayed(
			String strStatusTypeName) throws Exception {
		objWaitForElement.waitForElementByxpathSelector("//td[text()='"
				+ strStatusTypeName + "']/preceding-sibling::td/input");
		assertTrue(this.page.element(
				"//td[text()='" + strStatusTypeName
						+ "']/preceding-sibling::td/input", "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify status type name is displayed
	 * Arguments   : strStatusTypeName, strStatuses
	 * Date 	   : 19-May-2015
	 * Author 	   : Renushree
	 **********************************************************************************/
	public FormConfiguration verifyStatusesIsDisplayed(
			String strStatusTypeName, String strStatuses) throws Exception {
		objWaitForElement.waitForElementByxpathSelector("//td[text()='"
				+ strStatusTypeName
				+ "']/following-sibling::td[2]/font[text()='" + strStatuses
				+ "']");
		assertTrue(this.page.element(
				"//td[text()='" + strStatusTypeName
						+ "']/following-sibling::td[2]/font[text()='"
						+ strStatuses + "']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify label name in preview page name is displayed
	 * Arguments   : strlabelName
	 * Date 	   : 24-june-2015
	 * Author 	   : Sangappa.k
	 **********************************************************************************/
	public FormConfiguration verifyLabelNameInPreviewPage(String strLabelName) throws Exception {
		String label="//span[text()='"+strLabelName+"']";
		objWaitForElement.waitForElementByxpathSelector(label);
		assertTrue(this.page.element(label,"xpath").isElementPresent());
		return this;
	}	
	
	/**********************************************************************************
	 * Description : This function is to click onAcknowledge link
	  * Date		: 15/12/2014
	  * Author		: Anil
	 **********************************************************************************/
	public FormConfiguration clickOnAcknowledgeFormOnIE(String strStrFormName)
			throws Exception {
		objWaitForElement
				.waitForElementByxpathSelector("//td[text()='" + strStrFormName
						+ "']/parent::tr/td/a[text()='Questionnaire']");
		this.page
				.element(
						"//td[text()='" + strStrFormName
								+ "']/parent::tr/td/a[text()='Questionnaire']",
						"xpath").getOne().sendKeys(Keys.ENTER);
		return this;
	}	
	/**********************************************************************************
	* Description : This function is to click on configure Form under Form
	* Date 		  : 15/10/2014
	* Author 	  : sangappa.k
	**********************************************************************************/
	public FormConfiguration verifyConfigureFormLinkNotDisplayed() throws Exception {
		assertFalse(this.page.element(conFigureFormsunderForm, "linktext")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on configure Form under Form
	* Date 		  : 15/10/2014
	* Author 	  : sangappa.k
	**********************************************************************************/
	public FormConfiguration verifyConfigureFormLinkIsDisplayed()
			throws Exception {
		objWaitForElement.waitForElement(conFigureFormsunderForm, "linktext");
		assertTrue(this.page.element(conFigureFormsunderForm, "linktext")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description  : This function is to verify Edit link
	  * Date		: 15/12/2014
	  * Author		: Anil
	 **********************************************************************************/
	public FormConfiguration verifyEditFormLink(String strStrFormName)
			throws Exception {
		objWaitForElement.waitForElementByxpathSelector("//td[text()='"
				+ strStrFormName + "']/parent::tr/td/a[text()='Edit']");
		assertTrue(this.page.element(
				"//td[text()='" + strStrFormName
						+ "']/parent::tr/td/a[text()='Edit']", "xpath")
				.isElementPresent());
		return this;
	}

	/**********************************************************************************
	 * Description  : This function is to Verify Questionnaire link
	  * Date		: 30/6/2014
	  * Author		: Anitha
	 **********************************************************************************/
	public FormConfiguration VerifyQuestionnaireFormLink(String strStrFormName)
			throws Exception {
		objWaitForElement
				.waitForElementByxpathSelector("//td[text()='" + strStrFormName
						+ "']/parent::tr/td/a[text()='Questionnaire']");
		assertTrue(this.page
				.element(
						"//td[text()='" + strStrFormName
								+ "']/parent::tr/td/a[text()='Questionnaire']",
						"xpath").isElementPresent());
		return this;
	}
	
	
	/**********************************************************************************
	 * Description : This function is to Verify Field set under perticuler group
	 * Date : 8-July-2015 Author : Sangappa.k
	 **********************************************************************************/
	public FormConfiguration verifyFieldSetUnderGroup(String strGruopNmae,
			String strFieldSetName) throws Exception {
		String strfieldSet = "//span[text()='" + strGruopNmae
				+ "']/parent::h3/parent::header/parent::section//span[text()='"
				+ strFieldSetName + "']";

		objWaitForElement.waitForElementByxpathSelector(strfieldSet);
		assertTrue(this.page.element(strfieldSet, "xpath").isElementPresent());
		return this;
	}
	
	
	/**********************************************************************************
	 * Description  : This function is to Verify Field set under perticuler group
	  * Date		: 8-July-2015
	  * Author		: Sangappa.k
	 **********************************************************************************/
	public FormConfiguration dragAndDropFieldSetToOtherGroupe(
			String srcGroupName, String srcFieldSet, String destGroupName,
			String destFieldSet) throws Exception {
		String srcId = "//span[text()='" + srcGroupName
				+ "']/parent::h3/parent::header/parent::section//span[text()='"
				+ srcFieldSet
				+ "']/preceding-sibling::div[@class='btn-group reorder-group']";
		String destId = "//span[text()='" + destGroupName
				+ "']/parent::h3/parent::header/parent::section//span[text()='"
				+ destFieldSet
				+ "']/preceding-sibling::div[@class='btn-group reorder-group']";

		WebElement element = driver.findElement(By.xpath(srcId));
		WebElement target = driver.findElement(By.xpath(destId));
		Actions move = new Actions(driver);
		Action action = move.dragAndDrop(element, target).build();
		action.perform();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click onAcknowledge link in IE
	  * Date		: 15/12/2014
	  * Author		: Sangappa.k
	 **********************************************************************************/
	public FormConfiguration clickOnAcknowledgeFormInIE(String strStrFormName)
			throws Exception {
		objWaitForElement
				.waitForElementByxpathSelector("//td[text()='" + strStrFormName
						+ "']/parent::tr/td/a[text()='Questionnaire']");
		this.page   
				.element(
						"//td[text()='" + strStrFormName
								+ "']/parent::tr/td/a[text()='Questionnaire']",
						"xpath").getOne().sendKeys(Keys.ENTER);
		return this;
	}
	
	
	/**********************************************************************************
	 * Description  : This function is to Verify Field set under perticuler group
	  * Date		: 8-July-2015
	  * Author		: Sangappa.k
	 **********************************************************************************/
	public FormConfiguration verifyFieldSetUnderGroupInPreviewPageAndFilloutPage(
			String strGruopNmae, String strFieldSetName) throws Exception {
		String strfieldSet = "//span[text()='"
				+ strGruopNmae
				+ "']/parent::h3/parent::header/parent::section//legend[text()='"
				+ strFieldSetName + "']";

		objWaitForElement.waitForElementByxpathSelector(strfieldSet);
		assertTrue(this.page.element(strfieldSet, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to Move(Drag and drop) the qsnry to other
	 * fieldset Date : 8-July-2015 Author : Sangappa.k
	 **********************************************************************************/
	public FormConfiguration dragQsnryToOtherFieldSetWithinSameGroup(
			String srcGroupName, String srcFieldSet, String qsnry,
			String destFieldSet) throws Exception {
		String srcId = "//span[text()='" + srcGroupName
				+ "']/parent::h3/parent::header/parent::section//span[text()='"
				+ srcFieldSet
				+ "']/parent::legend/parent::fieldset//span[text()='" + qsnry
				+ "']";
		String destId = "//span[text()='"
				+ srcGroupName
				+ "']/parent::h3/parent::header/parent::section//span[text()='"
				+ destFieldSet
				+ "']/parent::legend/parent::fieldset//div[@class='suit-section-content']";

		WebElement element = driver.findElement(By.xpath(srcId));
		WebElement target = driver.findElement(By.xpath(destId));
		Actions move = new Actions(driver);
		Action action = move.dragAndDrop(element, target).build();
		action.perform();
		return this;
	}
	
	/**********************************************************************************
	 * Description  : This function is to Verify Field set under perticuler group
	  * Date		: 8-July-2015
	  * Author		: Sangappa.k
	 **********************************************************************************/
	public FormConfiguration verifyQsnryNotDisplayed(String strGruopNmae,
			String strFieldSetName, String qsnry) throws Exception {
		String strfieldSet = "//span[text()='" + strGruopNmae
				+ "']/parent::h3/parent::header/parent::section//span[text()='"
				+ strFieldSetName
				+ "']/parent::legend/parent::fieldset//span[text()='" + qsnry
				+ "']";

		
		assertFalse(this.page.element(strfieldSet, "xpath").isElementPresent(
				WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	/**********************************************************************************
	 * Description  : This function is to Verify Field set un
	  * Date		: 8-July-2015
	  * Author		: Sangappa.k
	 **********************************************************************************/
	public FormConfiguration verChoicesLstedInPrePgeForTypeHeadQsnry(String strChoise) throws Exception {
	String strchoices = "//span[text()='"+strChoise+"']";
	objWaitForElement.waitForElementByxpathSelector(strchoices);
	assertTrue(this.page.element(strchoices, "xpath").isElementPresent());
	return this;
	}
	
	/**********************************************************************************
	 * Description  : This function is to Verify Field set un
	  * Date		: 8-July-2015
	  * Author		: Sangappa.k
	 **********************************************************************************/
	public FormConfiguration selChoicesForTypeHeadQsnry(String strLabel,String strChoices) throws Exception {
	String strchoices = "//span[text()='"+strLabel+"']/parent::label/following-sibling::div//input";
	objWaitForElement.waitForElementByxpathSelector(strchoices);
	this.page.element(strchoices, "xpath").getOne().click();
	return this;
	}
	
	/**********************************************************************************
	 * Description  : This function is to  double click on  type head text field
	  * Date		: 8-July-2015
	  * Author		: Sangappa.k
	 **********************************************************************************/
	public FormConfiguration doubleClickOnTypeHeadTextField(String strLabel) throws Exception {
		
		try{
	String strTextField="//span[text()='"+strLabel+"']/parent::label/following-sibling::div//input";
//	String 	strTextField="//input[@id='suit-typeahead-1']";
	
	//WebElement element=driver.findElement(By.id(strTextField));
	objWaitForElement.waitForElement(strTextField, "xpath");
	/*JavascriptExecutor jse=(JavascriptExecutor)driver;
	jse.executeScript("window.document.getElementById('suit-typeahead-1').click();");
	jse.executeScript("window.document.getElementById('suit-typeahead-1').click();");*/
	
	this.page.element(strTextField, "xpath").getOne().sendKeys(Keys.ARROW_DOWN);

     this.page.element(strTextField, "xpath").doubleClick();
		}
		catch(Exception e){
			System.out.println("wait");
		}
	return this;
	
}
	/**********************************************************************************
	 * Description  : This function is to Verify Field set under perticuler group
	  * Date		: 8-July-2015
	  * Author		: Sangappa.k
	 **********************************************************************************/
	public FormConfiguration verifyTableUnderGroup(
			String strGruopNmae, String str1StColumn,String str2NdColumn) throws Exception {
		String strTable = "//span[text()='"
				+ strGruopNmae
				+ "']/parent::h3/parent::header/following-sibling::div[@class='suit-section-content']//table/thead/tr/th/span[text()='"
				+ str1StColumn
				+ "']/parent::th/following-sibling::th/span[text()='"
				+ str2NdColumn + "']";
		objWaitForElement.waitForElementByxpathSelector(strTable);
		assertTrue(this.page.element(strTable, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description  : This function is to Verify Field set under perticuler group
	  * Date		: 8-July-2015
	  * Author		: Sangappa.k
	 **********************************************************************************/
	public FormConfiguration dragAndDropTableToOtherGroupe(
			String srcGroupName, String sr1Stcolumn, String destGroupName,
			String dest2Stcolumn) throws Exception {
		String srcId = "//span[text()='"
				+ srcGroupName
				+ "']/parent::h3/parent::header/following-sibling::div[@class='suit-section-content']//table/thead/tr/th/span[text()='"
				+ sr1Stcolumn
				+ "']";
		String destId = "//span[text()='"
				+ destGroupName
				+ "']/parent::h3/parent::header/following-sibling::div[@class='suit-section-content']//table/thead/tr/th/span[text()='"
				+ dest2Stcolumn
				+ "']";
		WebElement element = driver.findElement(By.xpath(srcId));
		WebElement target = driver.findElement(By.xpath(destId));
		Actions move = new Actions(driver);
		Action action = move.dragAndDrop(element, target).build();
		action.perform();
		return this;
	}
	

	/**********************************************************************************
	 * Description  : This function is to Verify Field set under perticuler group
	  * Date		: 8-July-2015
	  * Author		: Sangappa.k
	 **********************************************************************************/
	public FormConfiguration verifyQsnryUnderFiledSet(String strFieldSet,
			String qsnry) throws Exception {
		String strInst = "//span[text()='"
				+ strFieldSet
				+ "']/parent::legend/following-sibling::div[@class='suit-section-content']//span[text()='"
				+ qsnry + "']";
		objWaitForElement.waitForElements(strInst, "xpath");
		System.out.println(strInst);
		assertTrue(this.page.element(strInst, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description  : This function is to Drag(Move) Instruction under perticuler group to other group
	  * Date		: 22-July-2015
	  * Author		: Sangappa.k
	 **********************************************************************************/
	public FormConfiguration dragAndDropQsnryToOtherFieledsetGroupe(
			String srcFieldSet, String srcQsnry, String destFieldSet,
			String destQsnry) throws Exception {

		String srcId = "//span[text()='"
				+ srcFieldSet
				+ "']/parent::legend/following-sibling::div[@class='suit-section-content']//span[text()='"
				+ srcQsnry + "']";
		String destId = "//span[text()='"
				+ destFieldSet
				+ "']/parent::legend/following-sibling::div[@class='suit-section-content']//span[text()='"
				+ destQsnry + "']";
		objWaitForElement.waitForElements(srcId, "xpath");
		WebElement element = driver.findElement(By.xpath(srcId));
		WebElement target = driver.findElement(By.xpath(destId));
		Actions move = new Actions(driver);
		Action action = move.dragAndDrop(element, target).build();
		action.perform();
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to click on copy link
	  * Date		:  27/07/2015
	  * Author		: Sangappa.k
	 **********************************************************************************/
	public FormConfiguration clickOnCopy(String strFormName)
			throws Exception {
		String copy="//td[text()='"+strFormName+"']/preceding-sibling::td/a[text()='Copy']";
		objWaitForElement.waitForElements(strFormName,"xpath");
		this.page.element(copy,"xpath").mouseOver();
		this.page.element(copy,"xpath").getOne().sendKeys(Keys.ENTER);;
		return this;
	}	
	
	/**********************************************************************************
	 * Description : This function is to click group link
	  * Date		: 27/07/2015
	  * Author		: Sangappa.k
	 **********************************************************************************/
	public FormConfiguration verCreateNewFormPage()
			throws Exception {
		
		objWaitForElement.waitForElements(createnewForm,"xpath");
		assertTrue(this.page.element(createnewForm,"xpath").isElementPresent());
		return this;
	}	
		
	/**********************************************************************************
	 * Description : This function is to verify clone from form name
	  * Date		:  27/07/2015
	  * Author		: Sangappa.k
	 **********************************************************************************/
	public FormConfiguration verCloneFrom(String strFormName)
			throws Exception {
	
		String cloneform="//td[contains(text(),'Clone from:')]/following-sibling::td[text()='"+strFormName+"']";
		objWaitForElement.waitForElements(cloneform,"xpath");
		assertTrue(this.page.element(cloneform,"xpath").isElementPresent());
		return this;
	}	
	/**********************************************************************************
	  * Description : This function is to select region to copy form
	  * Date        :  27/07/2015
	  * Author      : Sangappa.k
	  **********************************************************************************/
	public FormConfiguration selectRegionToCopyForm(String strRegionName) throws Exception {
		objWaitForElement.waitForElements(regionList, "id");
		this.page.element(regionList, "id").webElementToSelect().selectByVisibleText(strRegionName);
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify warning msg
	  * Date		: 27/07/2015
	  * Author		: Sangappa.k
	 **********************************************************************************/
	public FormConfiguration verValidationMsgAfterCopiedTheForm()
			throws Exception {

		objWaitForElement.waitForElements(warning, "xpath");

		assertEquals(
				"Please complete template configuration in destination region. Template is set as not active.",
				this.page.element(warning, "xpath").getOne().getText(),
				"Warning msg is not dispayed");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify warning msg
	  * Date		:  27/07/2015
	  * Author		: Sangappa.k
	 **********************************************************************************/
	public FormConfiguration verActiveColumnStatus(String strFormName,
			String status) throws Exception {
		
		String active = "//td[text()='" + strFormName
				+ "']/following-sibling::td[4]";
		objWaitForElement.waitForElements(active, "xpath");
		this.page.element(active, "xpath").mouseOver();
		Thread.sleep(5000);
		assertEquals(this.page.element(active, "xpath").getOne().getText(),
				status);
		return this;
	}
	
/**********************************************************************************
 * Description : This function is to get Locked Form tittle
  * Date		:  31/07/2015
  * Author		: Sangappa.k
 **********************************************************************************/
	public FormConfiguration clkOnCopyOfFormTempContainingLockedQsrny()
			throws Exception {

		String strCapturedFormName = "";

		String form = "//table[@class='displayTable striped border sortable']/tbody/tr";
		objWaitForElement.waitForElements(form, "xpath");
		int Xpathcount = this.page.element(form, "xpath").getXpathCount();

		for (int i = 1; i <= Xpathcount; i++) {
			String form1 = "//table[@class='displayTable striped border sortable']/tbody/tr["
					+ i + "]/td[1]";
			String strLockedQsnry = this.page.element(form1, "xpath").getOne()
					.getText();
			if (strLockedQsnry.contains("Locked")) {

				String strFomrTitle = "//table[@class='displayTable striped border sortable']/tbody/tr["
						+ i + "]/td[1]/following-sibling::td[1]";
				String copyForm = "//table[@class='displayTable striped border sortable']/tbody/tr["
						+ i
						+ "]/td[1]/following-sibling::td[1]/preceding-sibling::td/a[text()='Copy']";
				strCapturedFormName = this.page.element(strFomrTitle, "xpath")
						.getOne().getText();
				this.page.element(copyForm, "xpath").mouseOver();
				this.page.element(copyForm, "xpath").getOne()
						.sendKeys(Keys.ENTER);
				System.out.println("locked Form tittle    "
						+ strCapturedFormName);

				break;

			}

		}

		return this;
	}

	/**********************************************************************************
	* Description : This function is to verify Form title in Preview Page.
	* Arguments   : strFormTitle
	* Date 		  : 20-Aug-2015
	* Author 	  : Renushree
	**********************************************************************************/
	public FormConfiguration verifyFormTitleInPreviewPage(String strFormTitle)
			throws Exception {
		objWaitForElement.waitForElements(printButton, "xpath");
		String strTitleElement = "//h3[contains(text(),'"
				+ strFormTitle + "')]";
		objWaitForElement.waitForElements(strTitleElement, "xpath");
		assertTrue(this.page.element(strTitleElement, "xpath")
				.isElementPresent(), "Form title is not displayed");
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to enter water mark text
	 * Date        : 16-Dec-2014
	 * Author      : Sangappa.k
	 **********************************************************************************/
	public FormConfiguration enterWaterMark(String strwaterMark) throws Exception {
		objWaitForElement.waitForElements(watermark, "id");
		this.page.element(watermark, "id").clearInputValue()
				.sendKeys(strwaterMark);
		Thread.sleep(100);
		return this;
	}	
	
	/**********************************************************************************
	* Description : This function is to verify Water mark for Single line & Multi line text qsnry's
	* Date 		  : 28-Aug-2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public FormConfiguration verWatermarkForSingleLineText(String strLabel)
			throws Exception {
		
		String watermark="//span[text()='"+strLabel+"']/parent::label/following-sibling::div/input[@class='glow cutPasteCleanup watermark']";
		objWaitForElement.waitForElements(watermark, "xpath");
		assertTrue(this.page.element(watermark, "xpath").isElementPresent(),"No water mark displayed");
		String Capturedwatermarktext=this.page.element(watermark, "xpath").getOne().getAttribute("class");
		System.out.println(Capturedwatermarktext);
		/*String Capturedwatermarktext=this.page.element(watermark, "xpath").getOne().getText();
		System.out.println(Capturedwatermarktext);
		assertEquals(Capturedwatermarktext,strWatermarktext,"No water mark displayed");
				*/
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify Water mark for Single line & Multi line text qsnry's
	* Date 		  : 28-Aug-2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public FormConfiguration verWatermarkForMultiLineText(String strLabel,String strwaterMarkText)
			throws Exception {
		
		String watermark = "//span[text()='"
				+ strLabel
				+ "']/parent::label/following-sibling::div/textarea[@class='glow cutPasteCleanup watermark'][text()='"
				+ strwaterMarkText + "']";
		objWaitForElement.waitForElements(watermark, "xpath");

		assertTrue(this.page.element(watermark, "xpath").isElementPresent(),
				"No water mark displayed");

		String Capturedwatermarktext = this.page.element(watermark, "xpath")
				.getOne().getText();
		System.out.println(Capturedwatermarktext);
		assertEquals(Capturedwatermarktext, strwaterMarkText,
				"No water mark displayed");
		return this;

	}	
	/**********************************************************************************
	* Description : This function is to verify Water mark for Single line & Multi line text qsnry's
	* Date 		  : 28-Aug-2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public FormConfiguration selectValueFromListToUseDropdown(
			String strdropDowValue) throws Exception {

		objWaitForElement.waitForElements("//select[@height='5']", "xpath");
		Select selectByVisibleText = new Select(driver.findElement(By
				.xpath("//select[@height='5']")));
		Thread.sleep(8000);
		selectByVisibleText.selectByVisibleText(strdropDowValue);
		Thread.sleep(5000);
		String selectedOption = selectByVisibleText.getFirstSelectedOption()
				.getText();
		System.out.println(selectedOption);
		assertEquals(strdropDowValue, selectedOption,
				"correct drop down is not selected");
		return this;

	}
	/**********************************************************************************
	* Description : This function is to verify resource Single select & Multi select qsnry's
	* Date 		  : 28-Aug-2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public FormConfiguration verResIsDispInTempPgForSingleOrMultiSelect(
			String strLabel, String strRes) throws Exception {

		String strResoucrce = "//span[text()='"
				+ strLabel
				+ "']/parent::label/following-sibling::div/select[@class='glow']/option[text()='"
				+ strRes + "']";
		objWaitForElement.waitForElements(strResoucrce, "xpath");
		assertTrue(this.page.element(strResoucrce, "xpath").isElementPresent(),
				"no res displayed");

		return this;
	}

	/**********************************************************************************
	* Description : This function is to verify resource for Cheack box &  radio Btn qsnry's
	* Date 		  : 28-Aug-2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public FormConfiguration verResIsDispInTempPgForChkBoxOrRadio(
			String strLabel, String strRes) throws Exception {

		String strResoucrce = "//span[text()='" + strLabel
				+ "']/parent::label/following-sibling::div//span[text()='"
				+ strRes + "']";
		objWaitForElement.waitForElements(strResoucrce, "xpath");
		assertTrue(this.page.element(strResoucrce, "xpath").isElementPresent(),
				"no res displayed");

		return this;
	}
	/**********************************************************************************
	 * Description  : This function is to Verify resource for Type Head qsnry's
	  * Date		: 8-July-2015
	  * Author		: Sangappa.k
	 **********************************************************************************/
	public FormConfiguration verResouLstedInTempPgForTypeHeadQsnry(
			String strresources) throws Exception {
		String strresources1 = "//span[text()='" + strresources + "']";
		objWaitForElement.waitForElementByxpathSelector(strresources1);
		assertTrue(
				this.page.element(strresources1, "xpath").isElementPresent(),
				"Res not displayed");
		return this;
	}
	
	/**********************************************************************************
	 * Description  : This function is to entere resourece name in type head select
	  * Date		: 8-July-2015
	  * Author		: Sangappa.k
	 **********************************************************************************/
	public FormConfiguration entereResInTypeHeadField(String LabelName,
			String strresources) throws Exception {
		String strresources1 = "//span[text()='"+LabelName+"']/parent::label/following-sibling::div//input[@id='suit-typeahead-1']";
		objWaitForElement.waitForElementByxpathSelector(strresources1);
		this.page.element(strresources1, "xpath").clearInputValue().sendKeys(strresources);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select 'Carte Blanche' check box corresponding to user name in security page is not displayed
	 * Date 	   : 09/03/2015
	 * Author 	   : Sangappa K
	 **********************************************************************************/
	public FormConfiguration verCarteBlancheChkBoxNotInSecurityPge(
			String strUserName) throws Exception {
		String strChkBox = "//table[@id='tbl_userID']/tbody/tr/td[5][text()='"
				+ strUserName + "']/preceding-sibling::td[2]/input";
		objWaitForElement.waitForElements(strChkBox, "xpath");
		assertFalse(this.page.element(strChkBox, "xpath").isElementPresent(
				WaitTimeConstants.WAIT_TIME_TOO_SMALL));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Save btn in edit qsn window is disabled
	  * Date        : 19-OCt-2015
	  * Author      : Sangappa K
	  **********************************************************************************/
	public FormConfiguration verSaveBtnIsDaisbledInEditQsnryWin()
			throws Exception {
		objWaitForElement.waitForElements(strSaveDisable, "xpath");
		assertTrue(this.page.element(strSaveDisable, "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Save btn in edit qsn window is enebled
	  * Date        : 19-OCt-2015
	  * Author      : Sangappa K
	  **********************************************************************************/
	public FormConfiguration verSaveBtnIsEnabledInEditQsnryWin()
			throws Exception {
		objWaitForElement.waitForElements(strSaveEnable, "xpath");
		assertTrue(this.page.element(strSaveEnable, "xpath").isElementPresent());
		return this;
	}

	/**********************************************************************************
	* Description : This function is to erase  entered attributes label name & verify requred validation messgage
	  * Date		: 15/12/2014
	  * Author		: Sangappa.K
	**********************************************************************************/
	public FormConfiguration eraseEnteredLabelNameAndVerLablIsRqrdText()
			throws Exception {
		String label = "//label/following-sibling::div/span/span[text()='Label is required.']";
		objWaitForElement.waitForElements(labelName, "xpath");
		this.page.element(labelName, "xpath").clearInputValue();
		Thread.sleep(1000);
		this.page.element(label, "xpath").isElementPresent();
		assertEquals(this.page.element(label, "xpath").getOne().getText(),
				"Label is required.");
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify preview & save buttons are disabled
	  * Date		: 15/12/2014
	  * Author		: Sangappa.K
	**********************************************************************************/
	public FormConfiguration verPrevewAndSaveButtonsAreDisabled()
			throws Exception {

		objWaitForElement.waitForElements(strDisbled, "xpath");
		assertTrue(this.page.element(strDisbled, "xpath").isElementPresent());

		return this;
	}
	/**********************************************************************************
	* Description : This function is to verify save & publish buttons are disabled
	  * Date		: 15/12/2014
	  * Author		: Sangappa.K
	**********************************************************************************/
	public FormConfiguration verSaveAndPublishBtnsAreDisabled()
			throws Exception {
		objWaitForElement.waitForElements(strSavePublishDisable, "xpath");
		assertTrue(this.page.element(strSavePublishDisable, "xpath")
				.isElementPresent());
		return this;
	}
	/**********************************************************************************
	* Description : This function is to erase  entered attributes label name & verify requred validation messgage
	  * Date		: 15/12/2014
	  * Author		: Sangappa.K
	**********************************************************************************/
	public FormConfiguration verValidationMsgLabelReq()
			throws Exception {	
	objWaitForElement.waitForElements(strValidation, "xpath");
	this.page.element(strValidation, "xpath").isElementPresent();
	assertEquals(this.page.element(strValidation, "xpath").getOne().getText(),"Label is required.");
	return this;
	}
	
	/**********************************************************************************
	 * Description  : This function is to click on edit of questionnaire link
	  * Date		: 15/12/2014
	  * Author		: Sangappa.k
	 **********************************************************************************/
	public FormConfiguration clickOnEditOf3RdQuestionnaire()
			throws Exception {
		objWaitForElement.waitForElements(strEditQsnry, "xpath");
		this.page.element(strEditQsnry, "xpath").isElementPresent();
	  this.page.element(strEditQsnry, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on cancel button of edit qsnry
	 * Date : 10/11/2014 
	 * Author : sangappa.k
	 **********************************************************************************/
	public FormConfiguration clickOnCancelOfEditQsnry() throws Exception {
		objWaitForElement.waitForElements(strEWCancel, "xpath");
		this.page.element(strEWCancel, "xpath").mouseOver();
		this.page.element(strEWCancel, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description  : This function is to verify Preview Button in preview page
	 * Date		    : 11/02/2015
	 * Author		: Sangappa K
	 **********************************************************************************/
	public FormConfiguration verLabelNamesInPreviewPage(String strLabel)
			throws Exception {
		String strLabelnames = "//label[@class='control-label']/span[text()='"
				+ strLabel + "']";
		objWaitForElement.waitForElements(strLabelnames, "xpath");
		assertTrue(this.page.element(strLabelnames, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on Save button
	  * Date		: 15/12/2014
	  * Author		: Anil
	 **********************************************************************************/
	public FormConfiguration clickOnSaveButtonOfTempPage() throws Exception {
		objWaitForElement.waitForElements(saveButton, "xpath");
		WebElement element=driver.findElement(By.xpath(saveButton));
		this.page.element(saveButton, "xpath").scrollDownTillElement(element);
		this.page.element(saveButton, "xpath").getOne().click();
		//this.page.element_wait("//section[@class=''][contains(@style,'background-image: none; background-color')]", "xpath").waitForVisibilityOfElement();
		//this.page.element_wait("//section[@class=''][contains(@style,'background-image: none; background-color')]", "xpath").waitForInvisibilityOfElement();
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify Region is not listed under Reg Drop Down While Cloning The Form
	 * Date 	   : 09/03/2015
	 * Author 	   : Sangappa K
	 **********************************************************************************/
	public FormConfiguration verRegIsNotDispdUnderRegDropDownWhileCloningTheForm(
			String strReg) throws Exception {
		String strRegion = "//select[@id='regionID']/option[text()='"+strReg+"'] ";
		objWaitForElement.waitForElements(strRegion, "xpath");
		assertFalse(this.page.element(strRegion, "xpath").isElementPresent(
				WaitTimeConstants.WAIT_TIME_TOO_SMALL));
		return this;
	}
	/**********************************************************************************
	 * Description :This function is to verify Region is  listed under Reg Drop Down While Cloning The Form
	 * Date 	   : 09/03/2015
	 * Author 	   : Sangappa K
	 **********************************************************************************/
	public FormConfiguration verRegISDispdUnderRegDropDownWhileCloningTheForm(
			String strReg) throws Exception {
		String strRegion = "//select[@id='regionID']/option[text()='"+strReg+"'] ";
		objWaitForElement.waitForElements(strRegion, "xpath");
		assertTrue(this.page.element(strRegion, "xpath").isElementPresent(), strRegion+ "reg is not displayed");
		return this;
	}	
	
	/**********************************************************************************
	 * Description : This function is to select values in list to use dropdown
	 * Arguments   : strValue
	 * Date 	   : 01/12/2015
	 * Author 	   : Renushree 
	 **********************************************************************************/
	public FormConfiguration selValInListToUseDropDown(String strValue)
			throws Exception {
		objWaitForElement.waitForElements(strListToUse, "xpath");
		this.page.element(strListToUse, "xpath").webElementToSelect()
				.selectByVisibleText(strValue);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select values in list to use dropdown
	 * Arguments   : strValue
	 * Date 	   : 01/12/2015
	 * Author 	   : Renushree 
	 **********************************************************************************/
	public FormConfiguration verifyResourceNameIsDisplayed(String strResourceName)
			throws Exception {
		objWaitForElement.waitForElements("//table[@id='tbl_resourceID']/tbody/tr/td[2][text()='"+strResourceName+"']", "xpath");
		assertTrue(this.page.element("//table[@id='tbl_resourceID']/tbody/tr/td[2][text()='"+strResourceName+"']", "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to edit Column Label
	 * Date        : 03-Feb-2016
	 * Author      : Renushree
	 **********************************************************************************/
	public FormConfiguration editLabelForNthColumn(String strColumnNum,String strColumnLabel)
			throws Exception {
		objWaitForElement.waitForElements("//label[text()='Table Columns']/following-sibling::div/ul/li["+strColumnNum+"]/input","xpath");
		this.page.element("//label[text()='Table Columns']/following-sibling::div/ul/li["+strColumnNum+"]/input", "xpath").clearInputValue()
				.sendKeys(strColumnLabel);
		return this;
	}
	
	/******************************************************************************************
	* Description : This function is to verify the StatusType is Displyed Form Activation Page
	* Date 		  : 10/11/2014
	* Author 	  : sangappa.k
	*******************************************************************************************/
	public FormConfiguration verStatusTypeIsDisplyedInFormActivationPage(
			String strStatusTypeValue) throws Exception {
		objWaitForElement.waitForElements("input[name='statusTypeID'][value='"
				+ strStatusTypeValue + "']", "css");
		assertTrue(
				"StatusType is Displyed",
				this.page.element(
						"input[name='statusTypeID'][value='"
								+ strStatusTypeValue + "']", "css")
						.isElementPresent());
		return this;
	}
	
	
	/******************************************************************************************
	* Description : This function is to verify published column status in form configuration page
	* Date 		  : 21/103/2016
	* Author 	  : sangappa.k
	*******************************************************************************************/
	public FormConfiguration verPublishedColumnStatusInFormCongPage(
			String strFormTittle, String strColumnStatus) throws Exception {
		objWaitForElement.waitForElements("//table/tbody/tr/td[text()='"
				+ strFormTittle + "']/following-sibling::td[text()='"
				+ strColumnStatus + "'][1]", "xpath");
		assertTrue(
				this.page
						.element(
								"//table/tbody/tr/td[text()='" + strFormTittle
										+ "']/following-sibling::td[text()='"
										+ strColumnStatus + "'][1]", "xpath")
						.getOne().isDisplayed(),
				"published column status is displayed with unappropratte value");

		return this;
	}
	
	
	
	
	
	
	
}
