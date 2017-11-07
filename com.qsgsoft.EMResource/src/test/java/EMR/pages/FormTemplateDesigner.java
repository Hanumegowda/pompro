package EMR.pages;

import static org.testng.Assert.assertTrue;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import qaFramework.WaitTimeConstants;
import qaFramework.UserDefinedFunctions.WaitForElement;
import qaFramework.pageObject.PageObject;
import EMR.Locators.FormTemplateDesigner.Locators;

public class FormTemplateDesigner extends PageObject {

	WebDriver driver;
	WaitForElement waitForElement;
	WebDriverWait wait;

	public FormTemplateDesigner(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		waitForElement = new WaitForElement(this.driver);
		wait = new WebDriverWait(this.driver, WaitTimeConstants.WAIT_TIME_LONG);
	}

	public FormTemplateDesigner verifyTemplateDesigner() throws Exception {
		driver.navigate().refresh();
		waitForElement.waitForElements(Locators.INTERMEDIXLOGO, "xpath");
		assertTrue(this.page.element(Locators.INTERMEDIXLOGO, "xpath").getOne().isDisplayed());
		return this;
	}

	public FormTemplateDesigner clickOnInsert() throws Exception {
		waitForElement.waitForElements(Locators.INSERT, "xpath");
		this.page.element_wait(Locators.INSERT, "xpath").waitForElementEnable();
		this.page.element(Locators.INSERT, "xpath").getOne().click();
		return this;
	}

	public FormTemplateDesigner clickOnGroup() throws Exception {
		waitForElement.waitForElements(Locators.group, "xpath");
		this.page.element(Locators.group, "xpath").getOne().click();
		return this;
	}

	public FormTemplateDesigner verifyEditGroupOrTable() throws Exception {
		waitForElement.waitForElements(Locators.EDITGROUPTABLE, "css");
		assertTrue(this.page.element(Locators.EDITGROUPTABLE, "css").isElementPresent());
		return this;
	}

	public FormTemplateDesigner enterNewGroupName(String _groupName) throws Exception {
		waitForElement.waitForElements(Locators.GROUPNAME, "xpath");
		this.page.element(Locators.GROUPNAME, "xpath").clearInputValue().sendKeys(_groupName);
		return this;
	}

	public FormTemplateDesigner clickOnGroupSave() throws Exception {
		waitForElement.waitForElements(Locators.GROUPSAVE, "xpath");
		assertTrue(this.page.element(Locators.GROUPSAVE, "xpath").isElementPresent());
		this.page.element(Locators.GROUPSAVE, "xpath").getOne().click();
		return this;
	}

	public FormTemplateDesigner clickOnAdd(String groupName) throws Exception {
		String strAddButton = Locators.SPANWITHTEXT + groupName + Locators.ADDBUTTON;
		waitForElement.waitForElements(strAddButton, "xpath");
		this.page.element(strAddButton, "xpath").getOne().click();
		return this;
	}

	public FormTemplateDesigner clickOnFieldSet(String groupName) throws Exception {
		waitForElement.waitForElements(Locators.SPANWITHTEXT + groupName + Locators.FIELDSETBTTON, "xpath");
		this.page.element(Locators.SPANWITHTEXT + groupName + Locators.FIELDSETBTTON, "xpath").getOne().click();
		return this;
	}

	public FormTemplateDesigner verifyEditFieldSet() throws Exception {
		waitForElement.waitForElements(Locators.EDITFIELDSET, "xpath");
		assertTrue(this.page.element(Locators.EDITFIELDSET, "xpath").isElementPresent());
		return this;
	}

	public FormTemplateDesigner enterField(String fieldName) throws Exception {
		waitForElement.waitForElements(Locators.FIELD, "xpath");
		this.page.element(Locators.FIELD, "xpath").clearInputValue().sendKeys(fieldName);
		return this;
	}

	public FormTemplateDesigner clickOnEditFieldSave() throws Exception {
		waitForElement.waitForElements(Locators.EDITFIELDSETSAVE, "xpath");
		this.page.element(Locators.EDITFIELDSETSAVE, "xpath").getOne().click();
		return this;
	}

	public FormTemplateDesigner clickOnInsertElementOfField(String fieldName) throws Exception {
		waitForElement.waitForElementByxpathSelector(Locators.SPANWITHTEXT + fieldName + Locators.INSERTELEMENT);
		this.page.element(Locators.SPANWITHTEXT + fieldName + Locators.INSERTELEMENT, "xpath").clickUsingJSE();
		try{
			if(this.page.element(Locators.EDITQUESTION, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL)==false){
				this.page.element(Locators.SPANWITHTEXT + fieldName + Locators.INSERTELEMENT, "xpath").getOne().click();
				System.out.println("clicked after using javascript executor");
			}
		}catch(Exception e) {
			assertTrue(this.page.element(Locators.EDITQUESTION, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL));
		}
		return this;
	}

	public FormTemplateDesigner verifyEditQuestion() throws Exception {
		waitForElement.waitForElementByxpathSelector(Locators.EDITQUESTION);
		assertTrue(this.page.element(Locators.EDITQUESTION, "xpath").getOne().isDisplayed());
		return this;
	}

	public FormTemplateDesigner selectQuestionType(String questionType) throws Exception {
		waitForElement.waitForElements(Locators.QUESTIONAIRETYPE, "xpath");
		this.page.element(Locators.QUESTIONAIRETYPE, "xpath").webElementToSelect().selectByVisibleText(questionType);
		return this;
	}

	public FormTemplateDesigner enterLabelName(String _labelName) throws Exception {
		waitForElement.waitForElements(Locators.LABELNAME, "xpath");
		this.page.element(Locators.LABELNAME, "xpath").clearInputValue().sendKeys(_labelName);
		return this;
	}

	public FormTemplateDesigner clickOnSaveOfQuestionnaire() throws Exception {
		waitForElement.waitForElements(Locators.SAVEOFQUESTIONNAIRE, "xpath");
		this.page.element(Locators.SAVEOFQUESTIONNAIRE, "xpath").getOne().click();
		return this;
	}

	public FormTemplateDesigner clickOnAddToSummary() throws Exception {
		waitForElement.waitForElements(Locators.ADDTOSUMMARY, "xpath");
		if (this.page.element(Locators.ADDTOSUMMARY, "xpath").getOne().isSelected() == false) {
			this.page.element(Locators.ADDTOSUMMARY, "xpath").getOne().click();
		}
		return this;
	}

	public FormTemplateDesigner clickOnSaveOfTemplateDesigner() throws Exception {
		this.page.element_wait(Locators.SAVEOFTEMPLATEDESIGNER, "xpath").waitForVisibilityOfElement();
		this.page.element(Locators.SAVEOFTEMPLATEDESIGNER, "xpath").getOne().sendKeys(Keys.ENTER);
		return this;
	}

	public FormTemplateDesigner clickOnPublish() throws Exception {
		this.page.element_wait(Locators.PUBLISH, "xpath").waitForVisibilityOfElement();
		this.page.element(Locators.PUBLISH, "xpath").mouseOver();
		this.page.element(Locators.PUBLISH, "xpath").getOne().click();
		this.page.element_wait(Locators.PUBLISH_DISABLED, "xpath").waitForInvisibilityOfElement();
		return this;
	}

	public FormTemplateDesigner switchToMainWindow(String mainWindowHandle) throws Exception {		
		driver.switchTo().window(mainWindowHandle);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(Locators.FRAME));
		return this;
	}

	public FormTemplateDesigner switchToFormTemplateWindow(String mainWindowHandle) throws Exception {
		Set<String> a = driver.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver.switchTo().window(popupHandle);

			}
		}
		return this;
	}

	public FormTemplateDesigner enterGroupFieldSet(String _groupName, String fieldName) throws Exception {
		this.verifyTemplateDesigner();
		this.clickOnInsert();
		this.clickOnGroup();
		this.verifyEditGroupOrTable();
		this.enterNewGroupName(_groupName);
		this.clickOnGroupSave();
		this.clickOnAdd(_groupName);
		this.clickOnFieldSet(_groupName);
		this.verifyEditFieldSet();
		this.enterField(fieldName);
		this.clickOnEditFieldSave();
		return this;
	}

	public FormTemplateDesigner addQuestionnaire(String fieldName, String questionnaireType, String labelName)
			throws Exception {
		this.clickOnInsertElementOfField(fieldName);
		this.verifyEditQuestion();
		this.selectQuestionType(questionnaireType);
		this.enterLabelName(labelName);
		this.clickOnAddToSummary();
		this.clickOnSaveOfQuestionnaire();
		return this;
	}

	public FormTemplateDesigner addQuestionnaireCheckBox(String fieldName, String questionnaireType, String labelName,
			String choice) throws Exception {
		this.clickOnInsertElementOfField(fieldName);
		this.verifyEditQuestion();
		this.selectQuestionType(questionnaireType);
		this.enterLabelName(labelName);
		this.clickOnAddToSummary();
		this.addChoices(choice);
		this.clickOnSaveOfQuestionnaire();
		return this;
	}

	public FormTemplateDesigner enterChoice(String choice) throws Exception {
		waitForElement.waitForElements(Locators.CHOICE1, "xpath");
		this.page.element(Locators.CHOICE1, "xpath").clearInputValue().sendKeys(choice);
		return this;
	}

	public FormTemplateDesigner addChoices(String choice) throws Exception {
		this.enterChoice(choice);
		return this;
	}

	public FormTemplateDesigner clickOnEditQuestionnaire(String questionName) throws Exception {
		String question = Locators.SPANWITHTEXT + questionName + Locators.EDITQUESTIONNAMEODQUESTIONNAIRE;
		waitForElement.waitForElements(question, "xpath");
		this.page.element(question, "xpath").getOne().click();
		waitForElement.waitForElementByxpathSelector(Locators.EDITQUESTION);
		return this;
	}

	public FormTemplateDesigner editQuestionnaire(String questionName, String label) throws Exception {
		this.clickOnEditQuestionnaire(questionName);
		this.enterLabelName(label);
		this.clickOnSaveOfQuestionnaire();
		return this;
	}

	public FormTemplateDesigner verifyLabelName(String labelName) throws Exception {
		String label = Locators.LABELNAMEOFQUESTION + labelName + Locators.CLOSEBRACKET;
		this.page.element_wait(label, "xpath").waitForVisibilityOfElement();
		assertTrue(this.page.element(label, "xpath").getOne().isDisplayed());
		return this;
	}
	
	public FormTemplateDesigner publishAndCloseTemplateDesignerWindow() throws Exception {
		this.clickOnPublish();	
		driver.close();
		return this;
	}

}
