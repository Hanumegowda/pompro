package lib.page;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import qaframework.lib.WaitTimeConstants;
import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;
import qaframework.lib.webElements.WebElements;

public class BlankForm extends PageObject{
	
	WebDriver driver;
	WaitForElement objWaitForElement;
	
	private String saveAsDraft = "//button[@class='btn'][text()='Save as Draft']",
				   submit = "//span[text()='Submit']/parent::button[@class='btn btn-primary']",
				   dateField = "//input[@placeholder='mm/dd/yyyy']",
				   textAreaField = "//span[@data-bind='if: !is.Instructions()']/div//textarea",
				   textField = "span[data-bind='if: !is.Instructions()']>div>div>input",
				   selectOne = "//span[@data-bind='if: !is.Instructions()']/div/div/select",
				   errMsgWhenFormNotPublished = "//div[@id='workflowErrors']/ul/li",
				   save = "//button[@class='btn'][text()='Save']",
				   complete = "//button[@class='btn btn-primary'][text()='Complete']",
				   review="//button[text()='Review Form']";

	public BlankForm(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
	}

	/**********************************************************************************
	* Description : This function is to verify Form title
	* Arguments   : strFormTitle
	* Date 		  : 15/12/2014
	* Author 	  : Renushree
	**********************************************************************************/
	public BlankForm verFormTitle(String strFormTitle) throws Exception {
		switchToFormFrame();
//		objWaitForElement.waitForElements(saveAsDraft, "xpath");
		String strTitleElement = "//div[@id='header']//div//h3[contains(text(),'"
				+ strFormTitle + "')]";
		objWaitForElement.waitForElements(strTitleElement, "xpath");
		assertTrue(this.page.element(strTitleElement, "xpath")
				.isElementPresent(), "Form title is not displayed");
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify Group name
	* Arguments   : strGroupName
	* Date 		  : 15/12/2014
	* Author 	  : Renushree
	**********************************************************************************/
	public BlankForm verGroupName(String strGroupName) throws Exception {
		objWaitForElement.waitForElements("//span[text()='" + strGroupName
				+ "']", "xpath");
		assertTrue(
				this.page.element("//span[text()='" + strGroupName + "']",
						"xpath").isElementPresent(),
				"Group name is not displayed");
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify Field set name
	* Arguments   : strFieldSetName
	* Date 		  : 15/12/2014
	* Author 	  : Renushree
	**********************************************************************************/
	public BlankForm verFieldSetName(String strFieldSetName) throws Exception {
		objWaitForElement.waitForElements("//fieldset/legend[text()='"
				+ strFieldSetName + "']", "xpath");
		assertTrue(
				this.page.element(
						"//fieldset/legend[text()='" + strFieldSetName + "']",
						"xpath").isElementPresent(),
				"Fieldset is not displayed");
		return this;
	}
		
	/**********************************************************************************
	* Description : This function is to click on save button
	* Arguments   : None
	* Date 		  : 15/12/2014
	* Author 	  : Renushree
	**********************************************************************************/
	public BlankForm clickOnSave() throws Exception {
		objWaitForElement.waitForElements(saveAsDraft, "xpath");
		assertTrue(this.page.element(saveAsDraft, "xpath").isElementPresent(),
				"Save is not displayed");
		this.page.element(saveAsDraft, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on Complete button
	* Arguments   : None
	* Date 		  : 15/12/2014
	* Author 	  : Renushree
	**********************************************************************************/
	public BlankForm clickOnComplete() throws Exception {
		Thread.sleep(5000);
		objWaitForElement.waitForElements("//span[text()='Submit']/parent::button[@class='btn btn-primary']", "xpath");
		this.page.element_wait(submit, "xpath").waitForElementEnable();
	    assertTrue(this.page.element(submit, "xpath").isElementPresent(),
					"Complete is not displayed");
		this.page.element(submit, "xpath").getOne().click();
//		if(this.page.element(submit, "xpath").getOne().isEnabled()==true){
//			this.page.element(submit, "xpath").getOne().sendKeys(Keys.ENTER);
//		}
//		if(this.page.element(submit, "xpath").getOne().isEnabled()==true){
//			this.page.element(submit, "xpath").getOne().sendKeys(Keys.SPACE);
//		}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter answer in numeric field
	* Arguments   : strAnswer
	* Date 		  : 15/12/2014
	* Author 	  : Renushree
	**********************************************************************************/
	public BlankForm enterAnswerInDateField(String strAnswer) throws Exception {
		driver.manage().window().maximize();
		objWaitForElement.waitForElements(dateField, "xpath");
		assertTrue(this.page.element(dateField, "xpath").isElementPresent(),
				"Date field is not displayed");
		this.page.element(dateField, "xpath").getOne().click();
		Thread.sleep(5000);
		String strGetText = this.page.element(dateField, "xpath").getOne().getAttribute("value");
		this.page.element(dateField, "xpath").getOne().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		this.page.element(dateField, "xpath").getOne().sendKeys(Keys.BACK_SPACE);
		this.page.element(dateField, "xpath").getOne().sendKeys(strAnswer);
		assertEquals(this.page.element(dateField, "xpath").getDisplayedOne().getAttribute("value"), strAnswer);
		return this;
	}
	/**********************************************************************************
	* Description : This function is to enter answer in checkbox field
	* Arguments   : strAnswer
	* Date 		  : 16-Dec-2014
	* Author 	  : Deepa
	**********************************************************************************/
	public BlankForm enterAnswerInChkBox(String strAnswer) throws Exception {
		String strElement = "//span[@data-bind='text: text'][contains(text(),'"
				+ strAnswer + "')]/preceding-sibling::input";
		objWaitForElement.waitForElements(strElement, "xpath");
		assertTrue(this.page.element(strElement, "xpath").isElementPresent(),
				"Checkbox is not displayed");
		this.page.element(strElement, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
     * Description : This function is to enter answer in text area field
     * Arguments   : strAnswer
     * Date        : 16/12/2014
     * Author      : Pallavi
     **********************************************************************************/
	public BlankForm enterAnswerInTextAreaField(String strAnswer)
			throws Exception {
		objWaitForElement.waitForElements(textAreaField, "xpath");
		assertTrue(
				this.page.element(textAreaField, "xpath").isElementPresent(),
				"Text Area field is not displayed");
		
		this.page.element(textAreaField, "xpath").clearInputValue().sendKeys(strAnswer);
		return this;
	}

     /**********************************************************************************
 	* Description : This function is to enter answer in Multi select field
 	* Arguments   : strAnswer
 	* Date 		  : 17-Dec-2014
 	* Author 	  : Deepa
 	**********************************************************************************/
	public BlankForm enterAnswerInMultiSelectBox(String strAnswer)
			throws Exception {
		String strElement = "//select[@class='glow']/option[contains(text(),'"
				+ strAnswer + "')]";
		objWaitForElement.waitForElements(strElement, "xpath");
		assertTrue(this.page.element(strElement, "xpath").isElementPresent(),
				"Multi select field is not displayed");
		this.page.element(strElement, "xpath").getOne().click();
		return this;
	}
 	
 	/**********************************************************************************
 	* Description : This function is to select Perticuler option on Form Activation Drop Down
 	* Date 		  :10/11/2014
 	* Author 	  : Anil
 	**********************************************************************************/
	public BlankForm selectSingleOption(String selectDropDown) throws Exception {
		objWaitForElement.waitForElements(selectOne, "xpath");
		this.page.element(selectOne, "xpath").webElementToSelect()
				.selectByVisibleText(selectDropDown);
		return this;
	}
 	
    /**********************************************************************************
    * Description : This function is to enter answer in radio button field
    * Arguments   : strChoice
    * Date        : 17-Dec-2014
    * Author      : Pallavi
    **********************************************************************************/
	public BlankForm enterAnswerInRadioBtn(String strChoice) throws Exception {
		String strRadioBtn = "//span[@data-bind='text: text'][text()='"
				+ strChoice + "']/preceding-sibling::input[@type='radio']";
		objWaitForElement.waitForElements(strRadioBtn, "xpath");
		assertTrue(this.page.element(strRadioBtn, "xpath").isElementPresent(),
				"Radio button is not displayed");
		this.page.element(strRadioBtn, "xpath").getOne().click();
		assertTrue(this.page.element(strRadioBtn, "xpath").getDisplayedOne().isSelected(),
				strRadioBtn + "Radio button is not selected.");
		return this;
	}
    
    /**********************************************************************************
    * Description : This function is to verify radio button field is non editable.
    * Arguments   : strChoice
    * Date        : 17-Dec-2014
    * Author      : Pallavi
    **********************************************************************************/
	public BlankForm verRadioBtnIsNotEditable(String strChoice)
			throws Exception {
		String strRadioBtn = "//span[text()='"
				+ strChoice + "']";
		objWaitForElement.waitForElements(strRadioBtn, "xpath");
		assertTrue(this.page.element(strRadioBtn, "xpath").getOne().isEnabled()==false);
		return this;
	}
    
    
    /**********************************************************************************
    * Description : This function is to verify radio button field is non editable.
    * Arguments   : strChoice
    * Date        : 17-Dec-2014
    * Author      : Pallavi
    **********************************************************************************/
	public BlankForm verSelectOptionNotEditable(String strChoice)
			throws Exception {
		String strSelectedOption = "//span[@data-bind='if: isSelect']/select[@disabled='']/option[text()='"
				+ strChoice + "']";
		objWaitForElement.waitForElements(strSelectedOption, "xpath");
		assertTrue(this.page.element(strSelectedOption, "xpath")
				.isElementPresent(), "Non Editable dropdown is not present");
		assertTrue(this.page.element(strSelectedOption, "xpath").getOne()
				.isDisplayed(), "Non Editable dropdown is not displayed");
		return this;
	}
  
    
	/**********************************************************************************
	* Description : This function is to enter answer in numeric field
	* Arguments   : strAnswer
	* Date 		  : 15/12/2014
	* Author 	  : Anil
	**********************************************************************************/
	public BlankForm enterAnswerInField(String strLabelName, String strAnswer)
			throws Exception {
		String strLabelAnswer = "//label/span[text()='" + strLabelName
				+ "']/parent::label/parent::div//input";
		objWaitForElement.waitForElements(strLabelAnswer, "xpath");
		assertTrue(this.page.element(strLabelAnswer, "xpath")
				.isElementPresent(), "Numeric field is not displayed");
		this.page.element(strLabelAnswer, "xpath").clearInputValue().sendKeys(strAnswer);
		return this;
	}
	 
    /**********************************************************************************
    * Description : This function is to verify radio button field is non editable.
    * Arguments   : strChoice
    * Date        : 17-Dec-2014
    * Author      : Anil
    **********************************************************************************/
	public BlankForm verifyEnteredValueIsDisplayed(String strLabelName,
			String strChoice) throws Exception {
		String strSelectedOption = "//span[text()='"+strLabelName+"']/parent::label/following-sibling::label/span";
		objWaitForElement.waitForElements(strSelectedOption, "xpath");
		assertTrue((this.page.element(strSelectedOption, "xpath").getOne().getText().trim()).equals(strChoice), "Non Editable dropdown is not present");
		return this;
	}
	
    /**********************************************************************************
    * Description : This function is to verify radio button field is non editable.
    * Arguments   : strChoice
    * Date        : 17-Dec-2014
    * Author      : Pallavi
    **********************************************************************************/
	public BlankForm verifyEnteredValue(String strChoice) throws Exception {
		String strSelectedOption = "//span[@data-bind='if: isText() || isNumeric()']/input[@disabled=''][contains(text(),'')]";
		objWaitForElement.waitForElements(strSelectedOption, "xpath");
		assertTrue(this.page.element(strSelectedOption, "xpath")
				.isElementPresent(), "Non Editable dropdown is not present");
		assertTrue(this.page.element(strSelectedOption, "xpath").getOne()
				.isDisplayed(), "Non Editable dropdown is not displayed");
		return this;
	}

   /**********************************************************************************
  	* Description : This function is to verify Row name and Question type fields details
  	* 				 for numeric or Text type as first question type and Text Area type as
  	* 				 second question type
  	* Arguments   : strRowName, strQuestionType1
  	* Date 		  : 18-Dec-2014
  	* Author 	  : Pallavi
  	**********************************************************************************/
	public BlankForm verRowDetails(String strRowName, String strQuestionType1)
			throws Exception {
		if (strQuestionType1.contains("Text")) {
			String[] arrQtnType = strQuestionType1.split(" ");
			strQuestionType1 = arrQtnType[2];
		}
		objWaitForElement.waitForElements(
				"//tbody[@data-bind='foreach: my.tableRows']/tr/th/span[text()='"
						+ strRowName
						+ "']/ancestor::th/following-sibling::td[1]//input",
				"xpath");
		assertTrue(
				this.page
						.element(
								"//tbody[@data-bind='foreach: my.tableRows']/tr/th/span[text()='"
										+ strRowName
										+ "']/ancestor::th/following-sibling::td[1]//input",
								"xpath").isElementPresent(),
				"Row details are not displayed.");
		assertTrue(
				this.page
						.element(
								"//tbody[@data-bind='foreach: my.tableRows']/tr/th/span[text()='"
										+ strRowName
										+ "']/ancestor::th/following-sibling::td[2]//textarea",
								"xpath").isElementPresent(),
				"Row details are not displayed.");
		return this;
	}

  	/**********************************************************************************
  	* Description : This function is to enter Answer In First Column for Numeric or Text
  	* 				type as first question type
  	* Arguments   : strRowName, strQuestionType, strTextAnswer
  	* Date 		  : 18-Dec-2014
  	* Author 	  : Pallavi
  	**********************************************************************************/
	public BlankForm enterAnswerInFirstColumn(String strRowName,
			String strQuestionType, String strTextAnswer) throws Exception {
		if (strQuestionType.contains("Text")) {
			String[] arrQtnType = strQuestionType.split(" ");
			strQuestionType = arrQtnType[2];
		}
		String strTextBox = "//tbody[@data-bind='foreach: my.tableRows']/tr/th/span[text()='"
				+ strRowName
				+ "']/ancestor::th/following-sibling::td[1]//input";
		objWaitForElement.waitForElements(strTextBox, "xpath");
		this.page.element(strTextBox, "xpath").clearInputValue().sendKeys(strTextAnswer);
		/*assertTrue(strTextAnswer.equals(this.page.element(strTextBox, "xpath")
				.getOne().getAttribute("value")));*/
		return this;
	}
	
  	/**********************************************************************************
  	* Description : This function is to enter Answer In Second Column for Text Area
  	* 				type as second question type
  	* Arguments   : strRowName, strTextAreaAnswer
  	* Date 		  : 18-Dec-2014
  	* Author 	  : Pallavi
  	**********************************************************************************/
	public BlankForm enterAnswerInSecondColumn(String strRowName,
			String strTextAreaAnswer) throws Exception {
		String strTextAreaBox = "//tbody[@data-bind='foreach: my.tableRows']/tr/th/span[text()='"
				+ strRowName
				+ "']/ancestor::th/following-sibling::td[2]//input";
		objWaitForElement.waitForElements(strTextAreaBox, "xpath");
		this.page.element(strTextAreaBox, "xpath").clearInputValue().sendKeys(strTextAreaAnswer);
		/*assertTrue(strTextAreaAnswer.equals(this.page
				.element(strTextAreaBox, "xpath").getOne()
				.getAttribute("value")));*/
		return this;
	}
	
  	/**********************************************************************************
  	* Description : This function is to verify all Rows are DISABLED for first Column Question
  	* 				 as numeric or Text type and the entered answer is retained.
  	* Arguments   : strRowName, strQuestionType, strAnswer
  	* Date 		  : 18-Dec-2014
  	* Author 	  : Pallavi
  	**********************************************************************************/
	public BlankForm verRowsInFirstColumnAreDisabled(String strRowName,
			String strQuestionType, String strAnswer) throws Exception {
		if (strQuestionType.contains("Text")) {
			String[] arrQtnType = strQuestionType.split(" ");
			strQuestionType = arrQtnType[2];
		}
		String strTextBox = "//tbody[@data-bind='foreach: my.tableRows']/tr/th/span[text()='"
				+ strRowName
				+ "']/ancestor::th/following-sibling::td[1]/span/span[contains(@data-bind,'"
				+ strQuestionType + "')]/input[@disabled='']";
		objWaitForElement.waitForElements(strTextBox, "xpath");
		assertTrue(this.page.element(strTextBox, "xpath").isElementPresent(),
				"First column is not disabled.");
		assertTrue(strAnswer.equals(this.page.element(strTextBox, "xpath")
				.getOne().getAttribute("value")));
		return this;
	}
	
  	/**********************************************************************************
  	* Description : This function is to verify all Rows are DISABLED for Second Column Question type
  	* 				 as Text Area and the entered answer is retained.
  	* Arguments   : strRowName, strTextAreaAnswer
  	* Date 		  : 18-Dec-2014
  	* Author 	  : Pallavi
  	**********************************************************************************/
	public BlankForm verRowsInSecondColumnAreDisabled(String strRowName,
			String strTextAreaAnswer) throws Exception {
		String strTextAreaBox = "//tbody[@data-bind='foreach: my.tableRows']/tr/th/span[text()='"
				+ strRowName
				+ "']/ancestor::th/following-sibling::td[2]/span/span[@data-bind='if: isTextArea']//textarea[@disabled='']";
		objWaitForElement.waitForElements(strTextAreaBox, "xpath");
		assertTrue(this.page.element(strTextAreaBox, "xpath")
				.isElementPresent(), "Second column is not disabled.");
		assertTrue(strTextAreaAnswer.equals(this.page
				.element(strTextAreaBox, "xpath").getOne()
				.getAttribute("value")));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter answer in text field
	* Arguments   : strAnswer
	* Date 		  : 23/12/2014
	* Author 	  : Renushree
	**********************************************************************************/
	public BlankForm enterAnswerInTextField(String strAnswer) throws Exception {
		objWaitForElement.waitForElements(textField, "css");
		assertTrue(this.page.element(textField, "css").isElementPresent(),
				"Numeric field is not displayed");
		this.page.element(textField, "css").getOne().sendKeys(strAnswer);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter answer in numeric field
	* Arguments   : strAnswer
	* Date 		  : 15/12/2014
	* Author 	  : Renushree
	**********************************************************************************/
	public BlankForm enterAnswerInNumericFieldForPercentage(
			String strLabelName, String strAnswer) throws Exception {
		String strLabelAnswer = "//span[text()='" + strLabelName
				+ "']/parent::label/parent::div//input";
		objWaitForElement.waitForElements(strLabelAnswer, "xpath");
		assertTrue(this.page.element(strLabelAnswer, "xpath")
				.isElementPresent(), "Numeric field is not displayed");
		this.page.element(strLabelAnswer, "xpath").getOne()
				.sendKeys(Keys.chord(Keys.BACK_SPACE));
		this.page.element(strLabelAnswer, "xpath").getOne()
				.sendKeys(Keys.chord(Keys.BACK_SPACE));
		this.page.element(strLabelAnswer, "xpath").getOne().sendKeys(strAnswer);
		return this;
	}

	/**********************************************************************************
	* Description : This function is to enter answer in numeric field
	* Arguments   : strAnswer
	* Date 		  : 15/12/2014
	* Author 	  : Anil
	**********************************************************************************/
	public BlankForm enterAnswerForMultiLineText(String strLabelName,
			String strAnswer) throws Exception {
		String strLabelAnswer = "//label/span[text()='" + strLabelName
				+ "']/parent::label/parent::div//textarea";
		objWaitForElement.waitForElements(strLabelAnswer, "xpath");
		assertTrue(this.page.element(strLabelAnswer, "xpath")
				.isElementPresent(), "Numeric field is not displayed");
		this.page.element(strLabelAnswer, "xpath").clearInputValue()
				.sendKeys(strAnswer);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter answer in checkbox field
	* Arguments   : strAnswer
	* Date 		  : 16-Dec-2014
	* Author 	  : Deepa
	**********************************************************************************/
	public BlankForm verifyChkBoxIsDisplayed(String strLabelName,
			String strChoice) throws Exception {
		String strElement = "//span[text()='" + strLabelName
				+ "']/parent::label/parent::div//span[text()='" + strChoice
				+ "']/preceding-sibling::input";
		objWaitForElement.waitForElements(strElement, "xpath");
		assertTrue(this.page.element(strElement, "xpath").isElementPresent(),
				"Checkbox is not displayed");
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify choice is displayed in the drop-down for
	* 				'Single-Select' type question
	* Arguments   : strForm
	* Date 		  : 26-Dec-2014
	* Author 	  : Pallavi
	**********************************************************************************/
	public BlankForm verifyChoiceIsDisplayedForSingleSelectQtn(String strLabel,
			String strChoice) throws Exception {
		String strSingleSelectChoice = "//span[text()='"
				+ strLabel
				+ "']/parent::label/following-sibling::div//select/option[text()='"
				+ strChoice + "']";
		objWaitForElement.waitForElements(strSingleSelectChoice, "xpath");
		assertTrue(this.page.element(strSingleSelectChoice, "xpath")
				.isElementPresent());
		return this;
	}
	
    /**********************************************************************************
    * Description 	: This function is to verify that the entered instruction is retained.
    * Date      	: 23-Dec-2014
    * Author    	: Pallavi
    **********************************************************************************/
	public BlankForm verifyEnteredInstructionIsRetained(String strInstruction)
			throws Exception {
		objWaitForElement.waitForElements(
				"//div[@class='alert alert-info alert-block instructions']/span/p[text()='"
						+ strInstruction + "']", "xpath");
		assertTrue(this.page.element(
				"//div[@class='alert alert-info alert-block instructions']/span/p[text()='"
						+ strInstruction + "']", "xpath").isElementPresent());
		return this;
	}
    
    /**********************************************************************************
	* Description : This function is to verify Group name is not displayed
	* Arguments   : strGroupName
	* Date 		  : 06/01/2015
	* Author 	  : Renushree
	**********************************************************************************/
	public BlankForm verGroupNameIsNotDisplayed(String strGroupName)
			throws Exception {
		assertFalse(
				this.page.element("//span[text()='" + strGroupName + "']",
						"xpath").isElementPresent(
						WaitTimeConstants.WAIT_TIME_FOR_FALSE),
				"Group name is displayed");
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify checkbox field is not present
	* Arguments   : strAnswer
	* Date 		  : 06-Jan-2015
	* Author 	  : Renushree
	**********************************************************************************/
	public BlankForm verifyChkBoxIsNotDisplayed(String strLabelName,
			String strChoice) throws Exception {
		String strElement = "//span[text()='" + strLabelName
				+ "']/parent::label/parent::div//span[text()='" + strChoice
				+ "']/preceding-sibling::input";
		assertFalse(
				this.page.element(strElement, "xpath").isElementPresent(
						WaitTimeConstants.WAIT_TIME_FOR_FALSE),
				"Checkbox is not displayed");
		return this;
	}
		
	/**********************************************************************************
	 * Description : This function is to click on Delete element
	  * Date		: 07/1/2015
	  * Author		: Anil
	 **********************************************************************************/
	public BlankForm clickOnFieldSetDelete(String strAttributeName)
			throws Exception {
		objWaitForElement.waitForElements("//span[text()='" + strAttributeName
				+ "']/ancestor::fieldset//i[@class='icon-large icon-trash']", "xpath");
		this.page
				.element(
						"//span[text()='"
								+ strAttributeName
								+ "']/ancestor::fieldset//i[@class='icon-large icon-trash']",
						"xpath").getOne().click();
		Alert alert = driver.switchTo().alert();
		String strVar = alert.getText();
		System.out.println(strVar);
		assertEquals(
				"Are you sure you want to remove this FieldSet and ALL its elements?",
				strVar);
		alert.accept();
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify Field set name is not displayed
	* Arguments   : strFieldSetName
	* Date 		  : 07/01/2014
	* Author 	  : Anil
	**********************************************************************************/
	public BlankForm verFieldSetNameIsNotDisplayed(String strFieldSetName)
			throws Exception {
		assertFalse(
				this.page.element(
						"//fieldset/legend[text()='" + strFieldSetName + "']",
						"xpath").isElementPresent(
						WaitTimeConstants.WAIT_TIME_FOR_FALSE),
				"Fieldset is displayed");
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter answer is not displayed
	* Arguments   : strAnswer
	* Date 		  : 07/01/2014
	* Author 	  : Anil
	**********************************************************************************/
	public BlankForm enterAnswerInChkBoxIsNotDisplayed() throws Exception {
		String strElement = "//span[@data-bind='text: text']/preceding-sibling::input";
		assertFalse(
				this.page.element(strElement, "xpath").isElementPresent(
						WaitTimeConstants.WAIT_TIME_FOR_FALSE),
				"Checkbox is displayed");
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to verify that the removed instruction is not retained.
	  * Arguments   : strInstruction
	  * Date        : 07-Jan-2014
	  * Author      : Renushree
   **********************************************************************************/
	public BlankForm verifyRemovedInstructionIsNotRetained(String strInstruction)
			throws Exception {
		assertFalse(this.page.element(
				"//div[@class='alert alert-info alert-block instructions']/span/p[text()='"
						+ strInstruction + "']", "xpath").isElementPresent(
				WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
   
	/**********************************************************************************
	* Description : This function is to verify edit link is not present for instructions
	* Arguments   : strInstruction
	* Date 		  : 08-Jan-2015
	* Author 	  : Pallavi
	**********************************************************************************/
	public BlankForm verifyEditLinkNotPresentForInstructions(
			String strInstruction) throws Exception {
		String strElement = "//p[text()='"
				+ strInstruction
				+ "']/parent::span/preceding-sibling::div/div/a[contains(@data-bind,'editQuestion')]";
		assertFalse(
				this.page.element(strElement, "xpath").isElementPresent(
						WaitTimeConstants.WAIT_TIME_FOR_FALSE),
				"Edit link is displayed");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Instruction Under Group Is Not Present
	 * Arguments   : strGroupName
	 * Date		   : 08-Jan-2015
	 * Author	   : Pallavi
	 **********************************************************************************/
	public BlankForm verifyInstructionInGroupIsNotPresent(String strGroupName)
			throws Exception {
		String strElement = "//span[text()='" + strGroupName
				+ "']/ancestor::header//a[text()='Instructions']";
		assertFalse(
				this.page.element(strElement, "xpath").isElementPresent(
						WaitTimeConstants.WAIT_TIME_FOR_FALSE),
				"Instruction Link under Group is present");
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on Delete element
	  * Date		: 07/1/2015
	  * Author		: Anil
	 **********************************************************************************/
	public BlankForm deleteTable() throws Exception {
		objWaitForElement.waitForElements("//i[@class='icon-large icon-trash']", "xpath");
		this.page.element("//i[@class='icon-large icon-trash']", "xpath").getOne().click();
		Alert alert = driver.switchTo().alert();
		String strVar = alert.getText();
		System.out.println(strVar);
		assertEquals(
				"Are you sure you want to remove this Table and ALL its rows and columns?",
				strVar);
		alert.accept();
		return this;
	}
	
   /**********************************************************************************
  	* Description : This function is to verify Row name and Question type fields details
  	* 				 for numeric or Text type as first question type and Text Area type as
  	* 				 second question type
  	* Arguments   : strRowName, strQuestionType1
  	* Date 		  : 18-Dec-2014
  	* Author 	  : Anil
  	**********************************************************************************/
	public BlankForm verRowDetailsAreNotDisplayed(String strRowName,
			String strQuestionType1) throws Exception {
		if (strQuestionType1.contains("Text")) {
			String[] arrQtnType = strQuestionType1.split(" ");
			strQuestionType1 = arrQtnType[2];
		}
		assertFalse(
				this.page
						.element(
								"//tbody[@data-bind='foreach: my.tableRows']/tr/th/span[text()='"
										+ strRowName
										+ "']/ancestor::th/following-sibling::td[1]/span/span[contains(@data-bind,'"
										+ strQuestionType1 + "')]/input",
								"xpath").isElementPresent(
								WaitTimeConstants.WAIT_TIME_FOR_FALSE),
				"Row details are displayed.");
		assertFalse(
				this.page
						.element(
								"//tbody[@data-bind='foreach: my.tableRows']/tr/th/span[text()='"
										+ strRowName
										+ "']/ancestor::th/following-sibling::td[2]/span/span[contains(@data-bind,'"
										+ "TextArea')]//textarea", "xpath")
						.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE),
				"Row details are displayed.");
		return this;
	}
		
	/**********************************************************************************
	* Description : This function is to verify Form name
	* Arguments   : strFormTitle
	* Date 		  : 12/01/2014
	* Author 	  : Anil
	**********************************************************************************/
	public BlankForm verFormName(String strFormTitle) throws Exception {
		objWaitForElement.waitForElements(saveAsDraft, "xpath");
		String strTitleElement = "//div//span[text()='" + strFormTitle + "']";
		objWaitForElement.waitForElements(strTitleElement, "xpath");
		assertTrue(this.page.element(strTitleElement, "xpath")
				.isElementPresent(), "Form title is not displayed");
		assertTrue(this.page.element(strTitleElement, "xpath").getOne()
				.isDisplayed(), "Form title is not displayed");
		return this;
	}
	
	 /**********************************************************************************
	  * Description : This function is to switch to frame
	  * Date   : 13-Jan-2015
	  * Author  : Pallavi
	  **********************************************************************************/
	 public BlankForm switchToFormFrame() throws Exception {
//	  WebDriverWait wait = new WebDriverWait(this.driver, WaitTimeConstants.WAIT_TIME_LONG);
//		if(this.page.element("//frame[@name='myiframe']", "xpath").getOne().isDisplayed()){
//			WebDriverWait wait1 = new WebDriverWait(this.driver, WaitTimeConstants.WAIT_TIME_LONG);
//			wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("myiframe"));
//		}
//	  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("myiframe"));
//	  objWaitForElement.waitForElements(saveAsDraft, "xpath");
	  Thread.sleep(5000);
	  this.driver.switchTo().frame(0);
	  objWaitForElement.waitForElements(saveAsDraft, "xpath");
	  assertTrue(this.page.element(saveAsDraft, "xpath").isElementPresent());
	  return this;
	 }
	 
	/**********************************************************************************
	* Description : This function is to verify delete link of a question corresponding to label name is not displayed
	* Arguments	  : strLabel
	* Date 		  : 16-Jan-2015
	* Author 	  : Renushree
	**********************************************************************************/
	public BlankForm verDeleteLinkOfQuestionIsNotDisplayed(String strLabel)
			throws Exception {
		assertFalse(this.page
				.element(
						"//span[text()='"
								+ strLabel
								+ "']/parent::label/following-sibling::div/div/a[contains(@data-bind,'removeQuestion')]",
						"xpath").isElementPresent(
						WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}

	/**********************************************************************************
	* Description : This function is to enter answer in numeric field
	* Arguments   : strAnswer
	* Date 		  : 15/12/2014
	* Author 	  : Anil
	**********************************************************************************/
	public BlankForm enterAnswerInFieldForCurrencyAndPercent(
			String strLabelName, String strAnswer) throws Exception {
		String strLabelAnswer = "//label/span[text()='" + strLabelName
				+ "']/parent::label/parent::div//input";
		objWaitForElement.waitForElements(strLabelAnswer,"xpath");
		assertTrue(this.page.element(strLabelAnswer, "xpath")
				.isElementPresent(), "Numeric field is not displayed");
		this.page.element(strLabelAnswer, "xpath").getOne()
				.sendKeys(Keys.chord(Keys.BACK_SPACE));
		this.page.element(strLabelAnswer, "xpath").getOne()
				.sendKeys(Keys.chord(Keys.BACK_SPACE));
		this.page.element(strLabelAnswer, "xpath").getOne().sendKeys(strAnswer);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify the error message when a form is not published.
	* Arguments   : None
	* Date 		  : 27-Jan-2015
	* Author 	  : Pallavi
	**********************************************************************************/
	public BlankForm verErrorWenFormIsNotPublished() throws Exception {
		WebDriverWait wait = new WebDriverWait(this.driver,
				WaitTimeConstants.WAIT_TIME_LONG);
		wait.until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt("myiframe"));
		String strErrorMsg = "Template does not exist, or has not been published.";
		objWaitForElement.waitForElements(errMsgWhenFormNotPublished, "xpath");
		assertTrue(this.page.element(errMsgWhenFormNotPublished, "xpath")
				.getOne().getText().contains(strErrorMsg));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Required' text is present for a mandatory question.
	* Arguments   : strLabelName
	* Date 		  : 09-Feb-2015
	* Author 	  : Pallavi
	**********************************************************************************/
	public BlankForm verifyRequiedTextForMandatoryQuestion(String strLabelName)
			throws Exception {
		objWaitForElement
				.waitForElements(
						"//span[text()='"
								+ strLabelName
								+ "']/parent::label/span[2]/i[@data-original-title='Mandatory']",
						"xpath");
		assertTrue(this.page
				.element(
						"//span[text()='"
								+ strLabelName
								+ "']/parent::label/span[2]/i[@data-original-title='Mandatory']",
						"xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Required' text is present for a mandatory question.
	* Arguments   : strLabelName
	* Date 		  : 09-Feb-2015
	* Author 	  : Pallavi
	**********************************************************************************/
	public BlankForm verMandatoryQuestionCantBeSavedWithoutAnswering(
			String strLabelName) throws Exception {
		String strWebElement = "//span[text()='"
				+ strLabelName
				+ "']/parent::label/following-sibling::div/input[@class='error cutPasteCleanup']/parent::div/span[text()='Required']";
		objWaitForElement.waitForElements(strWebElement, "xpath");
		assertTrue(this.page.element(strWebElement, "xpath").isElementPresent());
		return this;
	}

	/**********************************************************************************
	* Description : This function is to verify numeric default value
	* Arguments   : None
	* Date 		  : 13-Feb-2015
	* Author 	  : Deepa
	**********************************************************************************/
	public BlankForm verNumericDefaultValue(String strLabelName,
			String strAnswer) throws Exception {
		String strLabelAnswer = "//div[@class='elements']/div[1]//input";
		objWaitForElement.waitForElements(strLabelAnswer, "xpath");
		String strActualStr = this.page.element(strLabelAnswer, "xpath")
				.getOne().getAttribute("value");
		assertEquals(strActualStr, strAnswer);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify default value for date field. 
	* Arguments   : strAnswer
	* Date 		  : 13-Feb-2015
	* Author 	  : Deepa
	**********************************************************************************/
	public BlankForm verDateDefaultValue(String strLabelName, String strAnswer)
			throws Exception {
		String strLabelAnswer = "//div[@class='elements']/div[2]//input";
		objWaitForElement.waitForElements(strLabelAnswer, "xpath");
		String strActualStr = this.page.element(strLabelAnswer, "xpath")
				.getOne().getAttribute("value");
		assertEquals(strActualStr, strAnswer);
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify default value for question. 
	* Arguments   : strAnswer
	* Date 		  : 13-Feb-2015
	* Author 	  : Anil
	**********************************************************************************/
	public BlankForm verifyDefaultValue(String strLabelName, String strAnswer)
			throws Exception {
		String strLabelAnswer = "//span[text()='" + strLabelName
				+ "']/parent::label/following-sibling::div//span[text()='"
				+ strAnswer + "']/../input";
		objWaitForElement.waitForElements(strLabelAnswer, "xpath");
		assertTrue(this.page.element(strLabelAnswer, "xpath").getOne()
				.isSelected());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify default answer for question
	* Arguments   : None
	* Date 		  : 13-Feb-2015
	* Author 	  : Anil
	**********************************************************************************/
	public BlankForm verifyDefaultSelectedValue(String strLabelName,
			String strAnswer) throws Exception {
		String strLabelAnswer = "//span[text()='"
				+ strLabelName
				+ "']/parent::label/following-sibling::div/select/option[text()='"
				+ strAnswer + "']";
		objWaitForElement.waitForElements(strLabelAnswer, "xpath");
		assertTrue(this.page.element(strLabelAnswer, "xpath").getOne()
				.isSelected());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to enter answer in numeric field
	* Arguments   : strAnswer
	* Date 		  : 15/12/2014
	* Author 	  : Anil
	**********************************************************************************/
	public BlankForm enterAnswerInFieldForBoolean(String strLabelName)
			throws Exception {
		String strLabelAnswer = "//label/span[text()='" + strLabelName
				+ "']/parent::label/parent::div//input";
		objWaitForElement.waitForElements(strLabelAnswer, "xpath");
		assertTrue(this.page.element(strLabelAnswer, "xpath")
				.isElementPresent(), "Boolean is not displayed");
		this.page.element(strLabelAnswer, "xpath").getOne().click();
		assertTrue(this.page.element(strLabelAnswer, "xpath").getOne().isSelected());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to check added choice is present 
	* Date 		  : 15/12/2014
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public BlankForm verAddedChoice(String strChoice, String lablelname) throws Exception {
		String choice1 = "//span[text()='"+lablelname+"']/../../div/select/option[text()='"
				+ strChoice + "']";
		objWaitForElement.waitForElements(choice1, "xpath");
		assertTrue(this.page.element(choice1, "xpath").isElementPresent(),
				"Save is not displayed");
		return this;
	}
	  
	/**********************************************************************************
	* Description : This function is to enter answer in numeric field
	* Arguments   : strAnswer
	* Date 		  : 15/12/2014
	* Author 	  : Anil
	**********************************************************************************/
	public BlankForm deselectAnswerInFieldForBoolean(String strLabelName)
			throws Exception {
		String strLabelAnswer = "//label/span[text()='"+strLabelName+"']/parent::label/parent::div//input";
		objWaitForElement.waitForElements(strLabelAnswer, "xpath");
		assertTrue(this.page.element(strLabelAnswer, "xpath").isElementPresent(),
				"Boolean is not displayed");
		if(this.page.element(strLabelAnswer, "xpath").getOne().isSelected()== true){
			this.page.element(strLabelAnswer, "xpath").getOne().click();
		}	
		return this;
	}

	/**********************************************************************************
	* Description : This function is to verify review and acknowledgment links are displayed
	* Date 		  : 15/12/2014
	* Author 	  : Anil
	**********************************************************************************/
	public BlankForm verifyReviewAndAcknowledgeLink(String strFormName)
			throws Exception {
		objWaitForElement.waitForElements(
				"//table[@summary='Recent Forms']//td[2][text()='"
						+ strFormName
						+ "']/preceding-sibling::td/a[text()='Review']",
				"xpath");
		assertTrue(this.page
				.element(
						"//table[@summary='Recent Forms']//td[2][text()='"
								+ strFormName
								+ "']/preceding-sibling::td/a[text()='Review']",
						"xpath").getOne().isDisplayed());
		assertTrue(this.page
				.element(
						"//table[@summary='Recent Forms']//td[2][text()='"
								+ strFormName
								+ "']/preceding-sibling::td/a[text()='Acknowledgements']",
						"xpath").getOne().isDisplayed());
		return this;
	}
	  
	/**********************************************************************************
	  * Description : This function is to verify AutoSaved and Saved text on the Template Designer page.ssssss
	  * Arguments   : None
	  * Date     	: 12-Mar-2015
	  * Author    	: Pallavi
	**********************************************************************************/
	public BlankForm verifyAutoSavedAndSaveTextAfter5Mins(String strTimeSaved)
			throws Exception {
		Date_Time_settings objDTS = new Date_Time_settings();
		String strTimeSaved1 = objDTS.addTimetoExisting(strTimeSaved, -1,
				"h:mm aa").toLowerCase();
		String strTimeSaved2 = objDTS.addTimetoExisting(strTimeSaved, 1,
				"h:mm aa").toLowerCase();
		objWaitForElement
				.waitForElements(
						"//span[contains(@data-bind,'lastUpdate')][contains(text(),'Saved:')]",
						"xpath");
		String TimeWebElement = "//span[contains(@data-bind,'lastUpdate')][text()='Saved: "
				+ strTimeSaved + "']";
		String TimeWebElement1 = "//span[contains(@data-bind,'lastUpdate')][text()='Saved: "
				+ strTimeSaved1 + "']";
		String TimeWebElement2 = "//span[contains(@data-bind,'lastUpdate')][text()='Saved: "
				+ strTimeSaved2 + "']";
		assertTrue(this.page.element(TimeWebElement, "xpath")
				.isElementPresent()
				|| this.page.element(TimeWebElement1, "xpath")
						.isElementPresent()
				|| this.page.element(TimeWebElement2, "xpath")
						.isElementPresent());
		return this;
	}
	   
   /**********************************************************************************
	  * Description : This function is to verify entered answer in numeric field/Text field is retained
	  * Arguments   : strLabelName, strAnswer
	  * Date     	: 12-Mar-2015
	  * Author    	: Pallavi
	**********************************************************************************/
	public BlankForm verifyEnteredAnswerIsRetainedInField(String strLabelName,
			String strAnswer) throws Exception {
		String strLabelAnswer = "//label/span[text()='" + strLabelName
				+ "']/parent::label/parent::div//input";
		objWaitForElement.waitForElements(strLabelAnswer, "xpath");
		assertTrue(this.page.element(strLabelAnswer, "xpath")
				.isElementPresent(), "Numeric field is not displayed");
		assertTrue(this.page.element(strLabelAnswer, "xpath").getOne()
				.getAttribute("value").equals(strAnswer));
		return this;
	}

   /**********************************************************************************
   * Description : This function is to virtually click on Group name
   * Arguments   : strGroupName
   * Date     	 : 12-Mar-2015
   * Author    	 : Pallavi
   **********************************************************************************/
	public BlankForm clickOnGrpNameVirtually(String strGroupName)
			throws Exception {
		objWaitForElement.waitForElements("//span[text()='" + strGroupName
				+ "']", "xpath");
		this.page.element("//span[text()='" + strGroupName + "']", "xpath")
				.getOne().click();
		return this;
	}

	/**********************************************************************************
	* Description : This function is to verify Warning mssage when the text length exceeds the maximum value
	* Arguments   : strLabelName, strAnswer
	* Date 		  : 19-Mar-2015
	* Author 	  : Pallavi
	**********************************************************************************/
	public BlankForm verErrorMsgWhenTextExceedsMaxLength(String strLabelName,
			String strMinimunLength, String strMaximumLength) throws Exception {
		String strErrMsgElement = "//label/span[text()='"
				+ strLabelName
				+ "']/parent::label/following-sibling::div/span[text()='Text length must be a minimum of "
				+ strMinimunLength + " and a maximum of " + strMaximumLength
				+ "']";
		objWaitForElement.waitForElements(strErrMsgElement, "xpath");
		assertTrue(this.page.element(strErrMsgElement, "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
 	* Description : This function is to enter answer in Multi select & single select fields
 	* Arguments   : strAnswer, strlableName
 	* Date 		  : 17-Dec-2014
 	* Author 	  : Hanumegowda
 	**********************************************************************************/
 	public BlankForm enterAnswerInMultiSelectBoxWithLable(String strlableName,String strAnswer) throws Exception {
 		String strElement = "//span[text()='" + strlableName + "']/../..//select[@class='glow']/option[contains(text(),'" + strAnswer + "')]";
 		assertTrue(this.page.element(strElement, "xpath").isElementPresent(),
 				"Multi select field is not displayed");
 		this.page.element(strElement, "xpath").getOne().click();
 		return this;
 	}
 	
 	/**********************************************************************************
  	* Description : This function is to enter Answer In Third Column for Text Area
  	* 				type as second question type
  	* Arguments   : strRowName, strTextAreaAnswer
  	* Date 		  : 30-Mar-2015
  	* Author 	  : Hanumegowda
  	**********************************************************************************/
	public BlankForm enterAnswerInThirdColumn(String strRowName,
			String strTextAreaAnswer) throws Exception {
		String strTextAreaBox = "//tbody[@data-bind='foreach: my.tableRows']/tr/th/span[text()='"
				+ strRowName
				+ "']/ancestor::th/following-sibling::td[3]//input";
		objWaitForElement.waitForElements(strTextAreaBox, "xpath");
		this.page.element(strTextAreaBox, "xpath").getOne()
				.sendKeys(strTextAreaAnswer);
		assertTrue(strTextAreaAnswer.equals(this.page
				.element(strTextAreaBox, "xpath").getOne()
				.getAttribute("value")));
		return this;
	}
	
 	/**********************************************************************************
	* Description : This function is to verify watermark is not displayed for numeric question type
	* Arguments   : strLabelName
	* Date 		  : 30/Mar/2015
	* Author 	  : Renushree
	**********************************************************************************/
	public BlankForm verNoWaterMarkFoundInNumericType(String strLabelName)
			throws Exception {
		String strLabelAnswer = "//label/span[text()='" + strLabelName
				+ "']/parent::label/parent::div//input";
		objWaitForElement.waitForElements(strLabelAnswer, "xpath");
		String strValueInField = this.page.element(strLabelAnswer, "xpath")
				.getOne().getText();
		assertEquals("", strValueInField, "WaterMark is present");
		return this;
	}
	
   /**********************************************************************************
    * Description : This function is to verify Row name and Question type fields details
  	* 				 for numeric, Multi-Line Text and Text type respectively.
  	* Arguments   : strRowName
  	* Date 		  : 30-Mar-2015
  	* Author 	  : Hanumegowda
  	**********************************************************************************/
	public BlankForm verRowDetailsForThreeColumns(String strRowName)
			throws Exception {

		assertTrue(
				this.page
						.element(
								"//tbody[@data-bind='foreach: my.tableRows']/tr/th/span[text()='"
										+ strRowName
										+ "']/ancestor::th/following-sibling::td[1]//input",
								"xpath").isElementPresent(),
				"Row details are not displayed.");
		assertTrue(
				this.page
						.element(
								"//tbody[@data-bind='foreach: my.tableRows']/tr/th/span[text()='"
										+ strRowName
										+ "']/ancestor::th/following-sibling::td[2]//textarea", "xpath")
						.isElementPresent(), "Row details are not displayed.");
		assertTrue(
				this.page
						.element(
								"//tbody[@data-bind='foreach: my.tableRows']/tr/th/span[text()='"
										+ strRowName
										+ "']/ancestor::th/following-sibling::td[3]//input", "xpath")
						.isElementPresent(), "Row details are not displayed.");
		return this;
	}
	

	/**********************************************************************************
	* Description : This function is to verify Form title
	* Arguments   : strFormTitle
	* Date 		  : 15/12/2014
	* Author 	  : Renushree
	**********************************************************************************/
	public BlankForm verFormTitleInReviewForm(String strFormTitle)
			throws Exception {
		String strTitleElement = "//div[@id='header']//h3[contains(text(),'"
				+ strFormTitle + "')]";
		objWaitForElement.waitForElements(strTitleElement, "xpath");
		assertTrue(this.page.element(strTitleElement, "xpath")
				.isElementPresent(), "Form title is not displayed");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify question type and entered answer is displayed in review page
	 *               for single select & multiselect question type.
	 * Arguments   : strChoice
	 * Date        : 02-Apr-2015
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public BlankForm verifyEnteredValueIsDisplayedForSingleSelectInPreviewPage(
			String strLabelName, String strChoice) throws Exception {
		String strSelectedOption = "//span[text()='"
				+ strLabelName
				+ "']/parent::label/following-sibling::label/span[contains(text(),'"
				+ strChoice + "')]";
		objWaitForElement.waitForElements(strSelectedOption, "xpath");
		assertTrue(this.page.element(strSelectedOption, "xpath")
				.isElementPresent(), "Non Editable dropdown is not present");
		assertTrue(this.page.element(strSelectedOption, "xpath").getOne()
				.isDisplayed(), "Non Editable dropdown is not displayed");
		return this;
	}

    /**********************************************************************************
	 * Description : This function is to verify Row name, and Question types of a table 
	 * Arguments   : strRowName, columns
	 * Date 	   : 01-Apr-2015
	 * Author 	   : Hanumegowda
	 **********************************************************************************/
	public BlankForm verRowAndQuestionTypeOfTable(String strRowName,
			String[] columns) throws Exception {
		for (int i = 1; i <= columns.length; i++) {
			System.out.println("value of i="+i);
			if (i == 3) {
				assertTrue(
						this.page
								.element(
										"//tbody[@data-bind='foreach: my.tableRows']/tr/th/span[text()='"
												+ strRowName
												+ "']/ancestor::th/following-sibling::td["
												+ i + "]//textarea", "xpath")
								.isElementPresent(),
						"Row details are not displayed.");
			} else if (i == 2) {

				assertTrue(
						this.page
								.element(
										"//tbody[@data-bind='foreach: my.tableRows']/tr/th/span[text()='"
												+ strRowName
												+ "']/ancestor::th/following-sibling::td["
												+ i + "]//select", "xpath")
								.isElementPresent(),
						"Row details are not displayed.");
			} else {
				assertTrue(this.page.element(
						"//tbody[@data-bind='foreach: my.tableRows']/tr/th/span[text()='"
								+ strRowName
								+ "']/ancestor::th/following-sibling::td[" + i
								+ "]//input", "xpath").isElementPresent());
			}
		}
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to enter Answer In five columns of 'Numeric', 'Checkbox', 'Single Line Text',
	 *               'Multi-Line Text', & 'Single Select' respectively.
	 * Arguments   : strRowName, columns, strTextAnswer
	 * Date 	   : 01-Apr-2015
	 * Author 	   : Hanumegowda
	 **********************************************************************************/
	public BlankForm enterAnswerInRows(String strRowName, String[] columns,
			String[] strTextAnswer) throws Exception {

		for (int i = 1; i <= columns.length; i++) {
			System.out.println("value of i="+i);
			if (i == 3) {
				String strTextBox = "//tbody[@data-bind='foreach: my.tableRows']/tr/th/span[text()='"
						+ strRowName
						+ "']/ancestor::th/following-sibling::td["
						+ i + "]//textarea";

				this.page.element(strTextBox, "xpath").getOne()
						.sendKeys(strTextAnswer[2]);
				assertTrue(strTextAnswer[2].equals(this.page
						.element(strTextBox, "xpath").getOne()
						.getAttribute("value")));
			} else if (i == 5) {
				String strTextBox = "//tbody[@data-bind='foreach: my.tableRows']/tr/th/span[text()='"
						+ strRowName
						+ "']/ancestor::th/following-sibling::td["
						+ i + "]//input";
				this.page.element(strTextBox, "xpath").getOne().click();

			} else if (i == 2) {
				String strTextBox = "//tbody[@data-bind='foreach: my.tableRows']/tr/th/span[text()='"
						+ strRowName
						+ "']/ancestor::th/following-sibling::td["
						+ i + "]//select";
				this.page.element(strTextBox, "xpath").webElementToSelect()
						.selectByVisibleText("New Choice");

			}

			else if (i == 1) {
				String strTextBox = "//tbody[@data-bind='foreach: my.tableRows']/tr/th/span[text()='"
						+ strRowName
						+ "']/ancestor::th/following-sibling::td["
						+ i + "]//input";
				this.page.element(strTextBox, "xpath").getOne()
						.sendKeys(strTextAnswer[0]);
				assertTrue(strTextAnswer[0].equals(this.page
						.element(strTextBox, "xpath").getOne()
						.getAttribute("value")));
			} else {
				String strTextBox = "//tbody[@data-bind='foreach: my.tableRows']/tr/th/span[text()='"
						+ strRowName
						+ "']/ancestor::th/following-sibling::td["
						+ i + "]//input";
				this.page.element(strTextBox, "xpath").getOne()
						.sendKeys(strTextAnswer[1]);
				assertTrue(strTextAnswer[1].equals(this.page
						.element(strTextBox, "xpath").getOne()
						.getAttribute("value")));
			}
		}
		return this;
	}
	
    /**********************************************************************************
	 * Description : This function is to enter answer in numeric field and to verify error messages by entering maximum & minimum values
	 * Arguments   : strLabelName, minvalue, maxvalue
	 * Date        : 06-Apr-2015
	 * Author      : Hanumegowda
	 **********************************************************************************/
	public BlankForm enterAndVerMinMaxValForNumericQuesType(String minvalue,
			String maxvalue, String strLabelName) throws Exception {
		int[] a = { Integer.parseInt(minvalue), Integer.parseInt(maxvalue),
				(Integer.parseInt(minvalue)) - 1,
				(Integer.parseInt(maxvalue)) + 1 };
		String strLabelAnswer = "//span[text()='" + strLabelName
				+ "']/parent::label/parent::div//input";
		for (int i = 0; i < a.length; i++) {
			if (i == 2 || i == 3) {
				assertTrue(this.page.element(strLabelAnswer, "xpath")
						.isElementPresent(), "Numeric field is not displayed");
				this.page.element(strLabelAnswer, "xpath").clearInputValue()
						.sendKeys("" + a[i] + "");
				this.clickOnSave();
				assertTrue(this.page.element(
						"//div/span[text()='Value must be a minimum of " + a[0]
								+ " and a maximum of " + a[1] + "']", "xpath")
						.isElementPresent());

			} else {
				this.page.element(strLabelAnswer, "xpath").clearInputValue()
						.sendKeys("" + a[i] + "");
				this.clickOnSave();
				assertFalse(this.page
						.element(
								"//div/span[text()='Value must be a minimum of "
										+ a[0] + " and a maximum of " + a[1]
										+ "']", "xpath")
						.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));

			}
		}

		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify Warning mssage when entered numeric value is lessthan the min value.
	* Arguments   : strLabelName, strAnswer
	* Date 		  : 09-Apr-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public BlankForm verErrorMsgWhenNumericValueExceedsMinValue(String strLabelName,
			String strAnswer) throws Exception {
		String strErrMsgElement = "//span[text()='"+strLabelName+"']/../..//span[text()='Value must be a minimum of "+strAnswer+"']";
		objWaitForElement.waitForElements(strErrMsgElement, "xpath");
		assertTrue(this.page.element(strErrMsgElement, "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify Warning mssage not displayed when entered numeric value is equal or greaterthan the min value.
	* Arguments   : strLabelName, strAnswer
	* Date 		  : 09-Apr-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public BlankForm verErrorMsgNotDisplayedWhenEnteringNumForMinValue(String strLabelName,
			String strAnswer) throws Exception {
		String strErrMsgElement = "//span[text()='"+strLabelName+"']/../..//span[text()='Value must be a minimum of "+strAnswer+"']";
		assertFalse(this.page.element(strErrMsgElement, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify Warning mssage when entered numeric value is greater than max value.
	* Arguments   : strLabelName, strAnswer
	* Date 		  : 09-Apr-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public BlankForm verErrorMsgWhenNumericValueExceedsMaxValue(String strLabelName,
			String strAnswer) throws Exception {
		String strErrMsgElement = "//span[text()='"+strLabelName+"']/../..//span[text()='Value must be a maximum of "+strAnswer+"']";
		objWaitForElement.waitForElements(strErrMsgElement, "xpath");
		assertTrue(this.page.element(strErrMsgElement, "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify Warning mssage not displayed when entered numeric value is equal or lessthan the max value.
	* Arguments   : strLabelName, strAnswer
	* Date 		  : 09-Apr-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public BlankForm verErrorMsgNotDisplayedWhenEnteringNumForMaxValue(String strLabelName,
			String strAnswer) throws Exception {
		String strErrMsgElement = "//span[text()='"+strLabelName+"']/../..//span[text()='Value must be a maximum of "+strAnswer+"']";
		assertFalse(this.page.element(strErrMsgElement, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify 'Required' text is present for a mandatory question.
	* Arguments   : strLabelName
	* Date 		  : 09-Feb-2015
	* Author 	  : sangappa.k
	**********************************************************************************/
	public BlankForm verifyRequiedTextForMandatoryQuestionIsNotDisplayed(String strLabelName)
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
	* Description : This function is to clear answer in numeric field
	* Arguments   : strAnswer
	* Date 		  : 15/12/
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public BlankForm clearAnswerField(String strLabelName)
			throws Exception {
		String strLabelAnswer = "//label/span[text()='" + strLabelName
				+ "']/parent::label/parent::div//input";
		assertTrue(this.page.element(strLabelAnswer, "xpath")
				.isElementPresent(), "Numeric field is not displayed");
		this.page.element(strLabelAnswer, "xpath").clearInputValue();
		return this;
	}	
	
	/**********************************************************************************
	* Description : This function is to switch to new window
	* Arguments   : None
	* Date 		  : 13/04/2015
	* Author 	  : Renushree
	**********************************************************************************/
	public BlankForm switchToNewWin() throws InterruptedException{
		int winCount=0;
		int maxLoopCnt=0;
		Set<String> a1;
		String mainWindowHandle1 = driver.getWindowHandle();
		do{
			Thread.sleep(2000);
			a1 = driver.getWindowHandles();
			winCount=a1.size();
			maxLoopCnt++;
		}while(winCount<2 && maxLoopCnt <= 10);
		Iterator<String> ite1 = a1.iterator();
	
		while (ite1.hasNext()) {
		String popupHandle = ite1.next().toString();

		if (!popupHandle.contains(mainWindowHandle1)) {
			driver.switchTo().window(popupHandle);
		}
	}
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify Save and complete buttons no longer displayed.
	* Arguments   : None
	* Date 		  : 17/04/2015
	* Author 	  : Renushree
	**********************************************************************************/
	public BlankForm verSaveAndCompleteNoLongerDisplayed()
			throws Exception {
		assertFalse(
				this.page.element(save, "xpath").isElementPresent(
						WaitTimeConstants.WAIT_TIME_FOR_FALSE),
				"Save is displayed");
		assertFalse(
				this.page.element(complete, "xpath").isElementPresent(
						WaitTimeConstants.WAIT_TIME_FOR_FALSE),
				"Save is displayed");
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify default value
	* Arguments   : None
	* Date 		  : 20-Apr-2015
	* Author 	  : Anil
	**********************************************************************************/
	public BlankForm verDefaultValue(String strLabelName,
			String strAnswer) throws Exception {
		String strLabelAnswer = "//label/span[text()='" + strLabelName
				+ "']/parent::label/parent::div//input";
		objWaitForElement.waitForElements(strLabelAnswer, "xpath");
		String strActualStr = this.page.element(strLabelAnswer, "xpath")
				.getOne().getAttribute("value");
		assertEquals(strActualStr, strAnswer);
		return this;
	}
	
    /**********************************************************************************
	 * Description : This function is to verify 'Required' text is displayed for mandatory question.
	 * Arguments   : strLabelName
	 * Date 	   : 20/Apr/2015
	 * Author 	   : Hanumegowda
	 **********************************************************************************/
	public BlankForm verRequiredTextIsDisplayedForMandatoryQuestionType(
			String strLabelName) throws Exception {
		String strLabelAnswer = "//span[text()='" + strLabelName
				+ "']/../..//span[text()='Required']";
		objWaitForElement.waitForElements(strLabelAnswer, "xpath");
		assertTrue(this.page.element(strLabelAnswer, "xpath")
				.isElementPresent(), "Required text is not displayed");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify error message is displayed, when entered text for 'Multi-Line-Text'
	 *               question type crosses the maximum length
	 * Arguments   : strLabelName
	 * Date 	   : 21/Apr/2015
	 * Author 	   : Hanumegowda
	 **********************************************************************************/
	public BlankForm verErrorMsgDisplayedForMaxLengthForMultiLineTextQuestionType(
			String strLabelName, String maxlength) throws Exception {
		String str1 = "//span[text()='" + strLabelName
				+ "']/../..//span[text()='Text length must be a maximum of "
				+ maxlength + "']";
		objWaitForElement.waitForElements(str1, "xpath");
		assertTrue(this.page.element(str1, "xpath").isElementPresent(),
				"Msg is not displayed");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify error message is not displayed, when entered text for 'Multi-Line-Text'
	 *               question type is lessthan or equal to the maximum length
	 * Arguments   : strLabelName
	 * Date 	   : 21/Apr/2015
	 * Author 	   : Hanumegowda
	 **********************************************************************************/
	public BlankForm verErrorMsgNotDisplayedForMaxLengthForMultiLineTextQuestionType(
			String strLabelName, String maxlength) throws Exception {
		String str1 = "//span[text()='" + strLabelName
				+ "']/../..//span[text()='Text length must be a maximum of "
				+ maxlength + "']";
		assertFalse(
				this.page.element(str1, "xpath").isElementPresent(
						WaitTimeConstants.WAIT_TIME_FOR_FALSE),
				"Error Msg is displayed");
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify appropriate  text for Past & Current dates is displayed for date question.
	* Arguments   : strLabelName
	* Date 	   : 21/Apr/2015
	* Author 	   : Sangappa.k
	**********************************************************************************/
	public BlankForm verTextIsDisplayedForFutureDatesOnlyExcludingOrIncludingToday(
			String strLabelName, String strDateTomo) throws Exception {
		String strText="//span[contains(text(),'" + strLabelName + "')]/../..//span[contains(text(),'Date must be " + 

strDateTomo + " or after')]";
		System.out.println("Eid " + strText);
		objWaitForElement.waitForElements(strText, "xpath");
		String Dispalyedtext = this.page.element(strText, "xpath").getOne().getText();
		System.out.println("Displayed yext" + Dispalyedtext);
		//Dispalyedtext.equalsIgnoreCase("Date must be " + strDateTomo + " or after");
          assertTrue(this.page.element(strText, "xpath")
				.isElementPresent(), "Appropraite text is not displayed");
		return this;
		}
	
	/**********************************************************************************
	* Description : This function is to verify appropriate  text for Past & Current dates is not displayed for date question.
	* Arguments   : strLabelName
	* Date 	   : 21/Apr/2015
	* Author 	   : Sangappa.k
	**********************************************************************************/
	public BlankForm verTextIsNotDisplayedForFutureDatesOnlyExcludingOrIncludingToday(
			String strLabelName, String strDateTomo) throws Exception {
		String strText="//span[contains(text(),'" + strLabelName + "')]/../..//span[contains(text(),'Date must be " + 

strDateTomo + " or after')]";
		System.out.println("Eid " + strText);
          assertFalse(this.page.element(strText, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE), "Appropraite text is displayed");
		return this;
		}
	
	/**********************************************************************************
	* Description : This function is to click on done button of the calender
	* Arguments   : strLabelName
	* Date 	   : 21/Apr/2015
	* Author 	   : Sangappa.k
	**********************************************************************************/
	public BlankForm strClickOnDoneButtonOfCalender() throws Exception {
		String strText="//button[contains(text(),'Done')]";
		objWaitForElement.waitForElements(strText, "xpath");
       this.page.element(strText, "xpath").getOne().click();
    return this;
				
		}
	
	/**********************************************************************************
	 * Description : This function is to verify error message displayed, when entered date exceeds for 'Past dates only (excluding today)'
	 *               and 'Past dates only (icluding today)' of date question type.
	 * Arguments   : strLabelName
	 * Date 	   : 22/Apr/2015
	 * Author 	   : Hanumegowda
	 **********************************************************************************/
	public BlankForm verErrorMsgDisplayedForPastDateOnlyExcludingOrIncludingTodayDateQuestionType(
			String strLabelName, String date) throws Exception {
		String str1 = "//span[text()='" + strLabelName
				+ "']/../..//span[text()='Date must be " + date
				+ " or before']";
		objWaitForElement.waitForElements(str1, "xpath");
		assertTrue(this.page.element(str1, "xpath").isElementPresent(),
				"Error Msg is not displayed");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify error message is not displayed, when entered date not exceeds for 'Past dates only (excluding today)'
	 *               and 'Past dates only (icluding today)' of date question type.
	 * Arguments   : strLabelName
	 * Date 	   : 22/Apr/2015
	 * Author 	   : Hanumegowda
	 **********************************************************************************/
	public BlankForm verErrorMsgNotDisplayedForPastDateOnlyExcludingOrIncludingTodayDateQuestionType(
			String strLabelName, String date) throws Exception {
		String str1 = "//span[text()='" + strLabelName
				+ "']/../..//span[text()='Date must be " + date
				+ " or before']";
		assertFalse(
				this.page.element(str1, "xpath").isElementPresent(
						WaitTimeConstants.WAIT_TIME_FOR_FALSE),
				"Error Msg is displayed");
		return this;
		}
/**********************************************************************************
* Description : This function is to verify appropriate  text for  Date range between mm/dd/yyyy and mm/dd/yyyy radio 
              radio button
*  Date 	   : 22/Apr/2015
* Author 	   : Sangappa.k
	**********************************************************************************/
	public BlankForm verTextIsDisplayedForDateRangeBetweenRadioBtn(
			String strLabelName, String strFromdate, String strTodate)
			throws Exception {
		String strText = "//span[contains(text(),'" + strLabelName
				+ "')]/../..//span[contains(text(),'Date must be between "
				+ strFromdate + " and " + strTodate + "')]";
		System.out.println("Eid " + strText);
		objWaitForElement.waitForElements(strText, "xpath");
		assertTrue(this.page.element(strText, "xpath").isElementPresent(),
				"Appropraite text is not displayed");
		return this;
	}
	/**********************************************************************************
	* Description : This function is to verify appropriate  text for  Date range between mm/dd/yyyy and mm/dd/yyyy radio 
	              radio button
	*  Date 	   : 22/Apr/2015
	* Author 	   : Sangappa.k
	**********************************************************************************/
		public BlankForm verTxtIsDisplayedForXdaysAgoAndYdaysAfterRdBtn(
				String strLabelName, String strFromdate, String strTodate)
				throws Exception {
			String strText = "//span[contains(text(),'" + strLabelName
					+ "')]/../..//span[contains(text(),'Date must be between "
					+ strFromdate + " and " + strTodate + "')]";
			objWaitForElement.waitForElements(strText, "xpath");
			assertTrue(this.page.element(strText, "xpath").isElementPresent(),
					"Appropraite text is not displayed");
			return this;
		}
		
     /**********************************************************************************
	  * Description : This function is to verify entered decimal value for numeric question type is within excpected range.
	  * Arguments   : strLabelName
	  * Date 	   : 05/May/2015
	  * Author 	   : Hanumegowda
      **********************************************************************************/
	public BlankForm verEnteredDecimalvalueIsWithinAcceptedValueForNumericQuestionType(
			String strLabelName, String expected) throws Exception {
		String str1 = "//label/span[text()='" + strLabelName
				+ "']/../..//input";
		objWaitForElement.waitForElements(str1, "xpath");
		assertTrue(
				this.page.element(str1, "xpath").isElementPresent(
						WaitTimeConstants.WAIT_TIME_FOR_FALSE),
				"Error Msg is displayed");

		String actual = this.page.element(str1, "xpath").getOne()
				.getAttribute("value");
		assertEquals(expected, actual);
		return this;
	}
		
	/**********************************************************************************
	 * Description : This function is to verify entered decimal value for numeric question type is not within excpected range.
	 * Arguments   : strLabelName
	 * Date 	   : 05/May/2015
	 * Author 	   : Hanumegowda
	 **********************************************************************************/
	public BlankForm verEnteredDecimalvalueIsNotWithinAcceptedValueForNumericQuestionType(
			String strLabelName, String expected) throws Exception {
		String str1 = "//label/span[text()='" + strLabelName
				+ "']/../..//input";
		objWaitForElement.waitForElements(str1, "xpath");
		assertTrue(
				this.page.element(str1, "xpath").isElementPresent(
						WaitTimeConstants.WAIT_TIME_FOR_FALSE),
				"Error Msg is displayed");

		String actual = this.page.element(str1, "xpath").getOne()
				.getAttribute("value");
		assertNotEquals(expected, actual,
				"both expected and actual values are equals");
		return this;
	}
	
	/**********************************************************************************
  	* Description : This function is to enter Answer In First Column for Numeric or Text
  	* 				type as first question type of duplicate rows
  	* Arguments   : strRowName, Answer
  	* Date 		  : 11-May-2015
  	* Author 	  : Hanumegowda
  	**********************************************************************************/
	public BlankForm enterAnswerInFirstColumnOfDuplicateRows(String strRowName,
			String[] answer) throws Exception {
		int i = answer.length;
		for (int i1 = 0; i1 < i; i1++) {
			String strTextBox = "//tbody[@data-bind='foreach: my.tableRows']/tr["
					+ (i1 + 1) + "]/th/span[text()='" + strRowName
					+ "']/ancestor::th/following-sibling::td[1]//input";
			objWaitForElement.waitForElements(strTextBox, "xpath");
			this.page.element(strTextBox, "xpath").getOne()
					.sendKeys(answer[i1]);
			assertTrue(answer[i1].equals(this.page.element(strTextBox, "xpath")
					.getOne().getAttribute("value")));
		}
		return this;
	}
	
	/**********************************************************************************
  	* Description : This function is to enter Answer In Second Column for Text Area
  	* 				type as second question type of duplicate rows
  	* Arguments   : strRowName, Answer
  	* Date 		  : 11-May-2015
  	* Author 	  : Hanumegowda
  	**********************************************************************************/
	public BlankForm enterAnswerInSecondColumnOfDuplicateRows(
			String strRowName, String[] answer) throws Exception {
		int i = answer.length;
		for (int i1 = 0; i1 < i; i1++) {
			String strTextAreaBox = "//tbody[@data-bind='foreach: my.tableRows']/tr["
					+ (i1 + 1)
					+ "]/th/span[text()='"
					+ strRowName
					+ "']/ancestor::th/following-sibling::td[2]//textarea";
			objWaitForElement.waitForElements(strTextAreaBox, "xpath");
			this.page.element(strTextAreaBox, "xpath").getOne()
					.sendKeys(answer[i1]);
			assertTrue(answer[i1].equals(this.page
					.element(strTextAreaBox, "xpath").getOne()
					.getAttribute("value")));

		}
		return this;
	}
	
	/**********************************************************************************
  	* Description : This function is to verify Column names of table question type.
  	* Date 		  : 12-May-2015
  	* Author 	  : Hanumegowda
  	**********************************************************************************/
	public BlankForm verColumnDetails(String[] strColumnName) throws Exception {
		int i1 = strColumnName.length;
		for (int i = 0; i < i1; i++) {
			objWaitForElement.waitForElements("//table/thead/tr/th[" + (i + 2)
					+ "]/span[text()='" + strColumnName[i] + "']", "xpath");
			assertTrue(
					this.page.element(
							"//table/thead/tr/th[" + (i + 2)
									+ "]/span[text()='" + strColumnName[i]
									+ "']", "xpath").isElementPresent(),
					"Element Not Present");
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify error message is not displayed for non mandatory
	 *               field of table question of 'numeric','single line text','checkbox' type.
	 * Arguments   : strLabelName
	 * Date 	   : 13/May/2015
	 * Author 	   : Hanumegowda
	 **********************************************************************************/
	public BlankForm verErrorMsgIsNotDisplayedForNonMandatoryFieldOfTableQuestion(
			String rowName) throws Exception {
		String str1 = "//span[text()='" + rowName
				+ "']/../..//input[@class='error cutPasteCleanup']";
		assertFalse(this.page.element(str1, "xpath").isElementPresent(),
				"Error Msg displayed");
		return this;
	}

	/**********************************************************************************
  	* Description : This function is to enter Answer In Nth Column for 'multi line text' question type
  	* Arguments   : strRowName, strTextAreaAnswer, columnNum
  	* Date 		  : 13-May-2015
  	* Author 	  : Hanumegowda
  	**********************************************************************************/
	public BlankForm enterAnswerInNthColumn(String strRowName,
			String strTextAreaAnswer, String columnNum) throws Exception {
		String strTextAreaBox = "//tbody[@data-bind='foreach: my.tableRows']/tr/th/span[text()='"
				+ strRowName
				+ "']/ancestor::th/following-sibling::td["
				+ columnNum + "]//textarea";
		objWaitForElement.waitForElements(strTextAreaBox, "xpath");
		this.page.element(strTextAreaBox, "xpath").getOne()
				.sendKeys(strTextAreaAnswer);
		assertTrue(strTextAreaAnswer.equals(this.page
				.element(strTextAreaBox, "xpath").getOne()
				.getAttribute("value")));
		return this;
	}
	
	/**********************************************************************************
  	* Description : This function is to verify Row name and Question type fields details
  	* 				for numeric or Text type as first question type and Text Area type as
  	* 				second question type of second table of same form.
  	* Arguments   : strRowName, strQuestionType1
  	* Date 		  : 14-May-2015
  	* Author 	  : Hanumegowda
  	**********************************************************************************/
	public BlankForm verRowDetailsInSecondTableOfSameForm(String strRowName)
			throws Exception {

		objWaitForElement.waitForElements(
				"//span/div[2]//tbody[@data-bind='foreach: my.tableRows']/tr/th/span[text()='"
						+ strRowName
						+ "']/ancestor::th/following-sibling::td[1]//input",
				"xpath");
		assertTrue(
				this.page
						.element(
								"//tbody[@data-bind='foreach: my.tableRows']/tr/th/span[text()='"
										+ strRowName
										+ "']/ancestor::th/following-sibling::td[1]//input",
								"xpath").isElementPresent(),
				"Row details are not displayed.");
		assertTrue(
				this.page
						.element(
								"//span/div[2]//tbody[@data-bind='foreach: my.tableRows']/tr/th/span[text()='"
										+ strRowName
										+ "']/ancestor::th/following-sibling::td[2]//textarea",
								"xpath").isElementPresent(),
				"Row details are not displayed.");
		return this;
	}

	/**********************************************************************************
  	* Description : This function is to enter Answer In Nth Column in second table of same form.
  	* Arguments   : strRowName, strTextAreaAnswer, columnNum
  	* Date 		  : 14-May-2015
  	* Author 	  : Hanumegowda
  	**********************************************************************************/
	public BlankForm enterAnswerInNthColumnInSecondTableOfSameForm(
			String strRowName, String strTextAreaAnswer, String columnNum,
			String questiontype) throws Exception {
		if (questiontype == "Multi-Line Text") {
			String strTextAreaBox = "//span/div[2]//tbody[@data-bind='foreach: my.tableRows']/tr/th/span[text()='"
					+ strRowName
					+ "']/ancestor::th/following-sibling::td["
					+ columnNum + "]//textarea";
			objWaitForElement.waitForElements(strTextAreaBox, "xpath");
			this.page.element(strTextAreaBox, "xpath").getOne()
					.sendKeys(strTextAreaAnswer);
			assertTrue(strTextAreaAnswer.equals(this.page
					.element(strTextAreaBox, "xpath").getOne()
					.getAttribute("value")));
		} else {
			String strTextAreaBox = "//span/div[2]//tbody[@data-bind='foreach: my.tableRows']/tr/th/span[text()='"
					+ strRowName
					+ "']/ancestor::th/following-sibling::td["
					+ columnNum + "]//input";
			objWaitForElement.waitForElements(strTextAreaBox, "xpath");
			this.page.element(strTextAreaBox, "xpath").getOne()
					.sendKeys(strTextAreaAnswer);
			assertTrue(strTextAreaAnswer.equals(this.page
					.element(strTextAreaBox, "xpath").getOne()
					.getAttribute("value")));

		}
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify  duplicate column names of table               
	 * Date 	   : 14/May/2015
	 * Author 	   : Sangappa.k
	 **********************************************************************************/
	public BlankForm verDuplicateColumnNamesOfTable1And2(
			String strDuplicateColumnNames) throws Exception {
		String str1 = "//span[contains(text(),'"+strDuplicateColumnNames+"')]";
		assertTrue(this.page.element(str1, "xpath").isElementPresent());
		assertEquals(this.page.element(str1, "xpath").getOne().getText(),
				strDuplicateColumnNames);		
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify Warning mssage when entered numeric value is Exceeds Specified Minimum And Maximum Value.
	* Arguments   : strLabelName, minValue, maxValue
	* Date 		  : 26-May-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public BlankForm verErrorMsgWhenNumericValueExceedsSpecifiedMinAndMaxValue(
			String strLabelName, String minValue, String maxValue)
			throws Exception {
		String strErrMsgElement = "//span[text()='" + strLabelName
				+ "']/../..//span[text()='Value must be a minimum of "
				+ minValue + " and a maximum of " + maxValue + "']";
		objWaitForElement.waitForElements(strErrMsgElement, "xpath");
		assertTrue(this.page.element(strErrMsgElement, "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to verify Warning mssage not displayed when entered numeric value is Exceeds Specified Minimum And Maximum Value.
	* Arguments   : strLabelName, minValue, maxValue
	* Date 		  : 26-May-2015
	* Author 	  : Hanumegowda
	**********************************************************************************/
	public BlankForm verErrorMsgNotDisplayedWhenNumericValueNotExceedsSpecifiedMinAndMaxValue(
			String strLabelName, String minValue, String maxValue)
			throws Exception {
		String strErrMsgElement = "//span[text()='" + strLabelName
				+ "']/../..//span[text()='Value must be a minimum of "
				+ minValue + " and a maximum of " + maxValue + "']";
		objWaitForElement.waitForElements(strErrMsgElement, "xpath");
		assertFalse(this.page.element(strErrMsgElement, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	* Description : This function is to click on "Review Form" button.
	* Arguments   : strAnswer
	* Date 		  : 10-July-2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public BlankForm clickReviewButton() throws Exception {
		objWaitForElement.waitForElements(review, "xpath");
		this.page.element(review, "xpath").getOne().click();

		return this;
	}

	/**********************************************************************************
	* Description : This function is to verify  Qsnry & choices in Review page
	* Arguments   : strAnswer
	* Date 		  : 10-July-2015
	* Author 	  : Sangappa.k
	**********************************************************************************/
	public BlankForm verChoicesAddedForQsnryInReviewPage(String strFieldSet,String strLabelName, String strChoises)
			throws Exception {
	String strLabelAnswer = "//legend[text()='"+strFieldSet+"']/parent::fieldset//span[text()='"+strLabelName+"']/parent::label/following-sibling::label//span[text()='"+strChoises+"']";
	objWaitForElement.waitForElements(strLabelAnswer, "xpath");
     assertTrue(this.page.element(strLabelAnswer, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
  	* Description : Verify last  Update time in temp desgine page 
  	*
  	* Date 		  :22-Oct-2015
  	* Author 	  :Sangappa K
  	**********************************************************************************/
	public BlankForm verLastUpdateTime(String strUpdatedtime,String str1MinUpdatedtime) throws Exception {
		String strUpdateTime = "//span[@data-bind='text: $root.lastUpdate']";
		String strSubmit="//span[text()='Submit']/parent::button[@class='btn btn-primary']";
		objWaitForElement.waitForElements(strUpdateTime, "xpath");
		this.page.element_wait(submit, "xpath").waitForVisibilityOfElement();
	    WebElement element=driver.findElement(By.xpath(strSubmit));
	    this.page.element(strSubmit, "xpath").scrollDownTillElement(element);
		this.page.element(strUpdateTime, "xpath").mouseOver();
	//	assertTrue(this.page.element(strUpdateTime, "xpath").isElementPresent());
		String strTimeCaptured=this.page.element(strUpdateTime, "xpath").getOne().getText();
		System.out.println("captured updated time"+ strTimeCaptured);
		assertTrue(strTimeCaptured.contains(strUpdatedtime)||strTimeCaptured.contains(str1MinUpdatedtime));
		
			
	return this;
		}
	
	/**********************************************************************************
  	* Description : This function is to verify Row name and Question type fields details
  	* 				 for numeric or Text type as first question type and Text Area type as
  	* 				 second question type
  	* Arguments   : strRowName, strQuestionType1
  	* Date 		  : 03-Feb-2016
  	* Author 	  : Renushree
  	**********************************************************************************/
	public BlankForm verRowDetailsForTextAndNumeric(String strRowName,
			String strQuestionType1, String strAnswer, String strQuestionType2,
			String strAnswer2) throws Exception {
		objWaitForElement.waitForElements(
				"//tbody[@data-bind='foreach: my.tableRows']/tr/th/span[text()='"
						+ strRowName
						+ "']/ancestor::th/following-sibling::td[1]//input",
				"xpath");
		assertTrue(
				this.page
						.element(
								"//tbody[@data-bind='foreach: my.tableRows']/tr/th/span[text()='"
										+ strRowName
										+ "']/ancestor::th/following-sibling::td[1]//input",
								"xpath").isElementPresent(),
				"Row details are not displayed.");

		this.enterAnswerInFirstColumn(strRowName, strQuestionType1, strAnswer);
		assertTrue(
				this.page
						.element(
								"//tbody[@data-bind='foreach: my.tableRows']/tr/th/span[text()='"
										+ strRowName
										+ "']/ancestor::th/following-sibling::td[2]//input",
								"xpath").isElementPresent(),
				"Row details are not displayed.");
		this.enterAnswerInSecondColumn(strRowName, strAnswer);
		this.clickOnSave();
		String strTextBox = "//tbody[@data-bind='foreach: my.tableRows']/tr/th/span[text()='"
				+ strRowName
				+ "']/ancestor::th/following-sibling::td[1]//input";
		assertEquals(strAnswer, this.page.element(strTextBox, "xpath").getOne()
				.getAttribute("value"));
		String strTextBox1 = "//tbody[@data-bind='foreach: my.tableRows']/tr/th/span[text()='"
				+ strRowName
				+ "']/ancestor::th/following-sibling::td[2]//input";
		assertEquals("0", this.page.element(strTextBox1, "xpath").getOne()
				.getAttribute("value"));
		return this;
	}
	
	/**********************************************************************************
  	* Description : This function is to enter Answer In Second Column for Text Area
  	* 				type as second question type
  	* Arguments   : strRowName, strTextAreaAnswer
  	* Date 		  : 03-Feb-2016
  	* Author 	  : Renushree
  	**********************************************************************************/
	public BlankForm enterAnswerInSecondColumnForTextArea(String strRowName,
			String strTextAreaAnswer) throws Exception {
		String strTextAreaBox = "//tbody[@data-bind='foreach: my.tableRows']/tr/th/span[text()='"
				+ strRowName
				+ "']/ancestor::th/following-sibling::td[2]//textarea";
		objWaitForElement.waitForElements(strTextAreaBox, "xpath");
		this.page.element(strTextAreaBox, "xpath").clearInputValue()
				.sendKeys(strTextAreaAnswer);
		return this;
	}
	
	/**********************************************************************************
  	* Description : This function is to verify table in review window
  	* Arguments   : strRowNum, strCol1Value, strCol2Value
  	* Date 		  : 03-Feb-2016
  	* Author 	  : Renushree
  	**********************************************************************************/
	public BlankForm ver2ColTableInReviewWind(String strRowNum,
			String strCol1Value, String strCol2Value) throws Exception {
		String strValues = "//table[@class='table table-striped']/tbody/tr["
				+ strRowNum + "]/td/span/span[text()='" + strCol1Value
				+ "']/ancestor::td/following-sibling::td/span/span[text()='"
				+ strCol2Value + "']";
		assertTrue(this.page.element(strValues, "xpath").isElementPresent());
		return this;
	}
}
	
	

