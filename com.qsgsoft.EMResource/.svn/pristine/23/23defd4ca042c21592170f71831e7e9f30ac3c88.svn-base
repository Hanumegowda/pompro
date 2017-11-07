package EMR.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import qaFramework.UserDefinedFunctions.PathsProperties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import qaFramework.WaitTimeConstants;
import qaFramework.UserDefinedFunctions.WaitForElement;
import qaFramework.pageObject.PageObject;
import EMR.Locators.UserLinks.Locators;

public class UserLinks extends PageObject {

	WebDriver driver;
	WaitForElement waitForElement;
	WebDriverWait wait;
	Login login;

	public UserLinks(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		waitForElement = new WaitForElement(this.driver);
		login = new Login(this.driver);
		wait = new WebDriverWait(this.driver, WaitTimeConstants.WAIT_TIME_SMALL);
	}

	public UserLinks clickOnCreateNewUserLink() throws Exception {
		waitForElement.waitForElements(Locators.CREATE_NEW_USERLINK, "xpath");
		this.page.element(Locators.CREATE_NEW_USERLINK, "xpath").getOne().click();
		return this;
	}

	public UserLinks enterUserLinkLabel(String userLinkLabel) throws Exception {
		waitForElement.waitForElements(Locators.LINK_LABEL, "xpath");
		assertTrue(this.page.element(Locators.LINK_LABEL, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.LINK_LABEL, "xpath").getOne().isDisplayed());
		this.page.element(Locators.LINK_LABEL, "xpath").clearInputValue().sendKeys(userLinkLabel);
		assertTrue(this.page.element(Locators.LINK_LABEL, "xpath").getOne().getAttribute("value").equals(userLinkLabel));
		return this;
	}

	public UserLinks uploadImage(String pathOfTheImage) throws Exception {

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();
		String filePath = pathProps.getProperty(pathOfTheImage);
		filePath = System.getProperty("user.dir")+filePath;

		waitForElement.waitForElements(Locators.IMAGE_FILE, "xpath");
		this.page.element(Locators.IMAGE_FILE, "xpath").getOne().sendKeys(filePath);
		return this;
	}

	public UserLinks enterURL(String URL) throws Exception {
		waitForElement.waitForElements(Locators.URL_FOR_EXTERNAL_SITE, "xpath");
		this.page.element(Locators.URL_FOR_EXTERNAL_SITE, "xpath").clearInputValue().sendKeys(URL);
		assertTrue(this.page.element(Locators.URL_FOR_EXTERNAL_SITE, "xpath").getOne().getAttribute("value").equals(URL));
		return this;
	}
	
	public UserLinks clickOnSave() throws Exception {
		waitForElement.waitForElements(Locators.SAVE, "xpath");
		this.page.element(Locators.SAVE, "xpath").getOne().click();
		return this;
	}
	
	public UserLinks createUserLink(String userLinkLabel, String pathOfTheImage, String URL) throws Exception {
		this.clickOnCreateNewUserLink();
		this.enterUserLinkLabel(userLinkLabel);
		this.uploadImage(pathOfTheImage);
		this.enterURL(URL);
		this.clickOnSave();
		return this;
	}
	
	public UserLinks verifyEditOptionIsPresent(String linkName)
			throws Exception {
		waitForElement.waitForElements(Locators.CREATED_LINK_PART1 + linkName + Locators.EDIT_OF_LINK, "xpath");
		assertTrue(this.page.element(Locators.CREATED_LINK_PART1 + linkName + Locators.EDIT_OF_LINK, "xpath").isElementPresent());
		return this;
	}
	
	public UserLinks verifyDeleteOptionIsPresent(String linkName)
			throws Exception {
		waitForElement.waitForElements(Locators.CREATED_LINK_PART1 + linkName + Locators.DELETE_OF_LINK, "xpath");
		assertTrue(this.page.element(Locators.CREATED_LINK_PART1 + linkName + Locators.DELETE_OF_LINK, "xpath").isElementPresent());
		return this;
	}
	
	public UserLinks verifyShowOptionIsPresent(String linkName)
			throws Exception {
		waitForElement.waitForElements(Locators.CREATED_LINK_PART1 + linkName + Locators.SHOW_OF_LINK, "xpath");
		assertTrue(this.page.element(Locators.CREATED_LINK_PART1 + linkName + Locators.SHOW_OF_LINK, "xpath").isElementPresent());
		return this;
	}
	
	public UserLinks verifyHideOptionIsPresent(String linkName)
			throws Exception {
		waitForElement.waitForElements(Locators.CREATED_LINK_PART1 + linkName + Locators.HIDE_OF_LINK, "xpath");
		assertTrue(this.page.element(Locators.CREATED_LINK_PART1 + linkName + Locators.HIDE_OF_LINK, "xpath").isElementPresent());
		return this;
	}
	
	public UserLinks verifyUpOptionIsPresent(String linkName)
			throws Exception {
		waitForElement.waitForElements(Locators.CREATED_LINK_PART1 + linkName + Locators.UP_OF_LINK, "xpath");
		assertTrue(this.page.element(Locators.CREATED_LINK_PART1 + linkName + Locators.UP_OF_LINK, "xpath").isElementPresent());
		return this;
	}
	
	public UserLinks verifyDownOptionIsPresent(String linkName)
			throws Exception {
		waitForElement.waitForElements(Locators.CREATED_LINK_PART1 + linkName + Locators.DOWN_OF_LINK, "xpath");
		assertTrue(this.page.element(Locators.CREATED_LINK_PART1 + linkName + Locators.DOWN_OF_LINK, "xpath").isElementPresent());
		return this;
	}
	
	public UserLinks verifyShowAs(String linkName, String showAs)
			throws Exception {
		waitForElement.waitForElements(Locators.CREATED_LINK_PART1 + linkName + Locators.SHOW_AS + showAs + Locators.CLOSING_BRACKET, "xpath");
		assertTrue(this.page.element(Locators.CREATED_LINK_PART1 + linkName + Locators.SHOW_AS + showAs + Locators.CLOSING_BRACKET, "xpath").isElementPresent());
		return this;
	}
	
	public UserLinks verifyFileSize(String linkName, String fileSize)
			throws Exception {
		waitForElement.waitForElements(Locators.CREATED_LINK_PART1 + linkName + Locators.FILE_SIZE + fileSize + Locators.CLOSING_BRACKET, "xpath");
		assertTrue(this.page.element(Locators.CREATED_LINK_PART1 + linkName + Locators.FILE_SIZE + fileSize + Locators.CLOSING_BRACKET, "xpath").isElementPresent());
		return this;
	}
	
	public UserLinks verifyImageSize(String linkName, String imageSize)
			throws Exception {
		waitForElement.waitForElements(Locators.CREATED_LINK_PART1 + linkName + Locators.IMAGE_SIZE + imageSize + Locators.CLOSING_BRACKET, "xpath");
		assertTrue(this.page.element(Locators.CREATED_LINK_PART1 + linkName + Locators.IMAGE_SIZE + imageSize + Locators.CLOSING_BRACKET, "xpath").isElementPresent());
		return this;
	}
	
	public UserLinks clickOnShowOfLink(String linkName) throws Exception {
		waitForElement.waitForElements(Locators.CREATED_LINK_PART1 + linkName + Locators.SHOW_OF_LINK, "xpath");
		this.page.element(Locators.CREATED_LINK_PART1 + linkName + Locators.SHOW_OF_LINK, "xpath").getOne().click();
		return this;
	}
	
	public UserLinks verifyLinkDetailsAndClickOnShowOfLink(String linkName, String showAs, String fileSize, String imageSize)
			throws Exception {
		this.verifyEditOptionIsPresent(linkName);
		this.verifyDeleteOptionIsPresent(linkName);
		this.verifyUpOptionIsPresent(linkName);
		this.verifyDownOptionIsPresent(linkName);
		this.verifyShowAs(linkName, showAs);
		this.verifyFileSize(linkName, fileSize);
		this.verifyImageSize(linkName, imageSize);
		this.clickOnShowOfLink(linkName);
		return this;
	}
	
	public UserLinks mouseOverOnUserLinksInHeader()
			throws Exception {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.linkText("User Links"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		executor.executeScript("return $(\"a:contains('User Links')\").mouseover();");
		return this;
	}
	
	public UserLinks verifyAndClickOnCreatedUserLink(String linkName) throws Exception {
		this.mouseOverOnUserLinksInHeader();
		assertTrue(this.page.element(Locators.USER_LINK_AT_TOP_RIGHT_PART1 + linkName + Locators.USER_LINK_AT_TOP_RIGHT_IMAGE, "xpath").isElementPresent());
		this.page.element(Locators.USER_LINK_AT_TOP_RIGHT_PART1 + linkName + Locators.CLOSING_BRACKET, "xpath").mouseOver();
		this.page.element(Locators.USER_LINK_AT_TOP_RIGHT_PART1 + linkName + Locators.CLOSING_BRACKET, "xpath").clickUsingJSE();
		return this;
	}
	
	public UserLinks switchToNewWindowAndVerifyWindowTitle(String mainWindowHandle, String UserLinkTitle) throws Exception {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> windowsIterator = windows.iterator();
		boolean ChildWindowIsPresent = false; int numberOfIterations = 0;
		while(!ChildWindowIsPresent && numberOfIterations < 2) {
			try{
				while (windowsIterator.hasNext()) {
					String popupHandle = windowsIterator.next().toString();
					if (!popupHandle.contains(mainWindowHandle)) {
						driver.switchTo().window(popupHandle);
						ChildWindowIsPresent = true;
					}
				}
			} catch(Exception e) {
				Thread.sleep(1000);
				numberOfIterations++;
			}
		}
		String titleName = driver.getTitle();
		System.out.println(titleName);
		assertEquals(UserLinkTitle, titleName);
		driver.close();
		driver.switchTo().window(mainWindowHandle);
		login.selectFrame();
		return this;
	}
	
	public UserLinks selectQuickLinkCheckBox() throws Exception {
		waitForElement.waitForElements(Locators.QUICK_LINK_CHECKBOX, "xpath");
		try{
			if(this.page.element(Locators.QUICK_LINK_CHECKBOX, "xpath").getOne().isSelected()==false){
				this.page.element(Locators.QUICK_LINK_CHECKBOX, "xpath").getOne().click();
				assertTrue(this.page.element(Locators.QUICK_LINK_CHECKBOX, "xpath").getOne().isSelected());
			}
		}catch (Exception e) {
			this.page.element(Locators.QUICK_LINK_CHECKBOX, "xpath").getOne().sendKeys(Keys.SPACE);
		}
		assertTrue(this.page.element(Locators.QUICK_LINK_CHECKBOX, "xpath").getOne().isSelected());
		return this;
	}
	
	public UserLinks createQuickLink(String userLinkLabel, String pathOfTheImage, String URL) throws Exception {
		this.deleteExistingQuickLinks();
		this.clickOnCreateNewUserLink();
		this.enterUserLinkLabel(userLinkLabel);
		this.uploadImage(pathOfTheImage);
		this.enterURL(URL);
		this.selectQuickLinkCheckBox();
		this.clickOnSave();
		return this;
	}
	
	public UserLinks verifyAndClickOnCreatedQuickLink(String linkName) throws Exception {
		assertTrue(this.page.element(Locators.QUICK_LINK_IMAGE_PART1 + linkName + Locators.CLOSING_BRACKET, "xpath").isElementPresent());
		this.page.element(Locators.QUICK_LINK_IMAGE_PART1 + linkName + Locators.CLOSING_BRACKET, "xpath").mouseOver();
		this.page.element(Locators.QUICK_LINK_IMAGE_PART1 + linkName + Locators.CLOSING_BRACKET, "xpath").clickUsingJSE();
		return this;
	}
	
	public UserLinks deleteExistingQuickLinks() throws Exception {
		while(this.page.element(Locators.DELETE_QUICK_LINK, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE)){
			this.page.element(Locators.DELETE_QUICK_LINK, "xpath").mouseOver();
			this.page.element(Locators.DELETE_QUICK_LINK, "xpath").clickUsingJSE();
			waitForElement.waitForPageLoad();
		}
		return this;
	}
}
