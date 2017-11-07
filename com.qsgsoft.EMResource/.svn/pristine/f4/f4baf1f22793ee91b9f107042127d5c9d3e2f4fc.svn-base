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
import EMR.Locators.BlankForm.Locators;

public class BlankForm extends PageObject {

	WebDriver driver;
	WaitForElement waitForElement;
	WebDriverWait wait;
	Login login;

	public BlankForm(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		waitForElement = new WaitForElement(this.driver);
		login = new Login(this.driver);
	}

	public BlankForm verifyFormTitle(String formTitle) throws Exception {
		String titleElement = Locators.TITLEOFFORM + formTitle + Locators.CLOSINGTWOBRACES;
		System.out.println(titleElement);
		waitForElement.waitForElements(titleElement, "xpath");
		assertTrue(this.page.element(titleElement, "xpath").isElementPresent(), "Form TITLE is not displayed");
		assertTrue(this.page.element(titleElement, "xpath").getOne().isDisplayed());
		return this;
	}

	public BlankForm switchToFormFrame() throws Exception {
		this.page.element_wait(Locators.FORMFRAME, "id").switchToFrame(Locators.FORMFRAME);
		return this;
	}

	public BlankForm verifyGroupName(String groupName) throws Exception {
		waitForElement.waitForElements(Locators.GROUPNAME + groupName
				+ Locators.CLOSINGBRACKETS, "xpath");
		assertTrue(
				this.page.element(
						Locators.GROUPNAME + groupName
								+ Locators.CLOSINGBRACKETS, "xpath")
						.isElementPresent(), "Group name is not displayed");
		return this;
	}

	public BlankForm verifyFieldSetName(String fieldSetName) throws Exception {
		waitForElement.waitForElements(Locators.FIELDSETNAME + fieldSetName
				+ Locators.CLOSINGBRACKETS, "xpath");
		assertTrue(
				this.page.element(Locators.FIELDSETNAME + fieldSetName
						+ Locators.CLOSINGBRACKETS, "xpath").isElementPresent(),
				"Fieldset is not displayed");
		return this;
	}

	public BlankForm clickOnSave() throws Exception {
		assertTrue(this.page.element(Locators.SAVEASDRAFT, "xpath")
				.isElementPresent(), "Save is not displayed");
		this.page.element(Locators.SAVEASDRAFT, "xpath").getOne().click();
		return this;
	}

	public BlankForm clickOnSubmit() throws Exception {
		this.page.element_wait(Locators.SUBMIT, "xpath").waitForElementEnable();
		assertTrue(this.page.element(Locators.SUBMIT, "xpath")
				.isElementPresent(), "Submit is not displayed");
		this.page.element(Locators.SUBMIT, "xpath").getOne()
				.sendKeys(Keys.ENTER);
		return this;
	}

	public BlankForm enterAnswerInNumericOrTextField(String labelName,
			String answer) throws Exception {
		String answerField = Locators.NUMERICANDTEXTANSWERPART1 + labelName
				+ Locators.NUMERICANDTEXTANSWERPART2;
		waitForElement.waitForElements(answerField, "xpath");
		assertTrue(this.page.element(answerField, "xpath").isElementPresent(),
				"Numeric/Text FIELD is not displayed");
		this.page.element(answerField, "xpath").clearInputValue()
				.sendKeys(answer);
		return this;
	}

	public BlankForm enterAnswerInCheckBox(String answer) throws Exception {
		String element = Locators.CHECKBOXANSWERPART1 + answer + Locators.CHECKBOXANSWERPART2;
		waitForElement.waitForElements(element, "xpath");
		assertTrue(this.page.element(element, "xpath").isElementPresent(),
				"Checkbox is not displayed");
		this.page.element(element, "xpath").getOne().click();
		return this;
	}

	public BlankForm selectUserToReceiveCompletedForm(String userName)
			throws Exception {
		waitForElement.waitForElements(Locators.USERTORECEIVECOMPLETEDFORM
				+ userName + Locators.CLOSINGBRACKETS, "css");
		this.page
				.element(Locators.USERTORECEIVECOMPLETEDFORM
						+ userName + Locators.CLOSINGBRACKETS, "css").getOne().click();
		return this;
	}

	public BlankForm clickOnDispatchForm(String mainWindowHandle) throws Exception {
		waitForElement.waitForElements(Locators.SENDFORM, "css");
		this.page.element(Locators.SENDFORM, "css").getOne().click();
		driver.switchTo().window(mainWindowHandle);
		login.switchToDefaultWindow().selectFrame();
		return this;
	}

	public BlankForm switchToBlankFormWindow(String mainWindowHandle)
			throws Exception {
		Set<String> blankFormWindow = driver.getWindowHandles();
		Iterator<String> windowsIterator = blankFormWindow.iterator();
		boolean ChildWindowIsPresent = false;
		int numberOfIterations = 0;
		while(!ChildWindowIsPresent && numberOfIterations < 2) {
			try{
				while (windowsIterator.hasNext()) {
					String popupHandle = windowsIterator.next().toString();
					if (!popupHandle.contains(mainWindowHandle)) {
						driver.switchTo().window(popupHandle);
						if(this.page.element(Locators.FORMFRAME, "id").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL)){
							wait = new WebDriverWait(this.driver, WaitTimeConstants.COUNT);
							wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(Locators.FORMFRAME));
							System.out.println("switched to form frame");
							ChildWindowIsPresent = true;
						}
						this.driver.manage().window().maximize();
					}
				}
			} catch(Exception e) {
				Thread.sleep(1000);
				numberOfIterations++;
			}
		}
		System.out.println(ChildWindowIsPresent);
		System.out.println(numberOfIterations);
		return this;
	}

	public BlankForm verifyTitleGroupField(String formTitle, String group,
			String fieldSet) throws Exception {
		verifyFormTitle(formTitle);
		verifyGroupName(group);
		verifyFieldSetName(fieldSet);
		return this;
	}
	
	public BlankForm enterAnswerInTextAreaField(String labelName, String answer) throws Exception {
		String answerField = Locators.SPANWITHTEXT + labelName + Locators.TEXTAREA_FIELD;
		waitForElement.waitForElements(answerField, "xpath");
		assertTrue(this.page.element(answerField, "xpath").isElementPresent());
		this.page.element(answerField, "xpath").clearInputValue().sendKeys(answer);
		assertTrue(this.page.element(answerField, "xpath").getOne().getAttribute("value").equals(answer));
		return this;
	}
}
