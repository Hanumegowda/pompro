package EMR.pages;

import static org.testng.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import qaFramework.WaitTimeConstants;
import qaFramework.UserDefinedFunctions.WaitForElement;
import qaFramework.pageObject.PageObject;
import EMR.Locators.UsersList.Locators;
import EMR.data.UsersData;

public class UsersList extends PageObject {

	WebDriver driver;
	WaitForElement waitForElement;
	WebDriverWait wait;
	Alert alert;
	String ErrorMessage;
	Shared navigateTo;
	RegionList regions;
	Login login;

	public UsersList(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		waitForElement = new WaitForElement(this.driver);
		wait = new WebDriverWait(this.driver, WaitTimeConstants.WAIT_TIME_LONG);
		navigateTo= new Shared(this.driver);
		regions= new RegionList(this.driver);
		login = new Login(this.driver);
	}

	public UsersList clickOnCreateNewUser() throws Exception {
		waitForElement.waitForElements(Locators.CREATENEWUSER, "css");
		this.page.element(Locators.CREATENEWUSER, "css").getOne().click();
		return this;
	}

	public UsersList enterUserMandatoryDetails(String username,
			String Password, String fullName) throws Exception {
		this.enterUsername(username);
		this.enterPassword(Password);
		this.enterConfirmPassword(Password);
		this.enterFullName(fullName);
		return this;
	}

	public UsersList enterUsername(String _username) throws Exception {
		waitForElement.waitForElements(Locators.USERNAME, "name");
		this.page.element(Locators.USERNAME, "name").clearInputValue().sendKeys(_username);
		assertTrue(this.page.element(Locators.USERNAME, "name").getOne().getAttribute("value").equals(_username));
		System.out.println(_username);
		return this;
	}

	public UsersList enterPassword(String _password) throws Exception {
		waitForElement.waitForElements(Locators.INITPASSWORD, "name");
		this.page.element(Locators.INITPASSWORD, "name").clearInputValue()
		.sendKeys(_password);
		return this;
	}

	public UsersList enterConfirmPassword(String _password) throws Exception {
		waitForElement.waitForElements(Locators.CONFIRMPASSWORD, "name");
		this.page.element(Locators.CONFIRMPASSWORD, "name").clearInputValue()
		.sendKeys(_password);
		return this;
	}

	public UsersList enterFullName(String _fullName) throws Exception {
		waitForElement.waitForElements(Locators.FULLNAME, "name");
		this.page.element(Locators.FULLNAME, "name").clearInputValue()
		.sendKeys(_fullName);
		return this;
	}

	public UsersList clickOnSave() throws Exception {
		waitForElement.waitForElements(Locators.SAVE, "css");
		this.page.element(Locators.SAVE, "css").getOne().click();
		return this;
	}

	public UsersList clickOnAdvancedOptionAndExpand() throws Exception {
		waitForElement.waitForElements(Locators.ADVANCEDOPTIONBUTTON, "xpath");
		if (this.page.element(Locators.ADVANCEDOPTIONBUTTON, "xpath").getDisplayedOne()
				.getAttribute("src").contains("img/icons/collapse_open.gif")) {
			this.page.element(Locators.ADVANCEDOPTIONBUTTON, "xpath").getDisplayedOne().click();
		}
		return this;
	}

	public UsersList selectUpdateStatusOfResource(String _resource)
			throws Exception {
		String mappedResource = Locators.RESOURCELISTPART1 + _resource + Locators.UPDATERIGHT;
		waitForElement.waitForElements(mappedResource, "xpath");
		if (this.page.element(mappedResource, "xpath").getOne().isSelected() == false) {
			this.page.element(mappedResource, "xpath").getOne().sendKeys(Keys.SPACE);
		}
		if (this.page.element(mappedResource, "xpath").getOne().isSelected() == false) {
			this.page.element(mappedResource, "xpath").getOne().click();
		}
		if (this.page.element(mappedResource, "xpath").getOne().isSelected() == false) {
			this.page.element(mappedResource, "xpath").getOne().sendKeys(Keys.ENTER);
		}
		assertTrue(this.page.element(mappedResource, "xpath").getOne().isSelected());
		return this;
	}

	public UsersList selectUpdateStatusOfResource(String[] _resource)
			throws Exception {
		for(int loopCount = 0; loopCount < _resource.length; loopCount++){
			String mappedResource = Locators.RESOURCELISTPART1 + _resource[loopCount] + Locators.UPDATERIGHT;
			waitForElement.waitForElements(mappedResource, "xpath");
			if (this.page.element(mappedResource, "xpath").getOne().isSelected() == false) {
				this.page.element(mappedResource, "xpath").getOne().sendKeys(Keys.SPACE);
			}
			if (this.page.element(mappedResource, "xpath").getOne().isSelected() == false) {
				this.page.element(mappedResource, "xpath").getOne().click();
			}
			if (this.page.element(mappedResource, "xpath").getOne().isSelected() == false) {
				this.page.element(mappedResource, "xpath").getOne().sendKeys(Keys.ENTER);
			}
			assertTrue(this.page.element(mappedResource, "xpath").getOne().isSelected());
		}
		return this;
	}

	public UsersList provideMaintainEventsRight() throws Exception {
		this.clickOnAdvancedOptionAndExpand();
		waitForElement.waitForElements(Locators.MAINTAINEVENTS, "css");
		this.page.element(Locators.MAINTAINEVENTS, "css").getOne().click();
		return this;
	}

	public UsersList selectAllUpdateStatusResourceRight() throws Exception {
		waitForElement.waitForElements(Locators.UPDATESTATUSALL, "css");
		this.page.element(Locators.UPDATESTATUSALL, "css").getOne().click();
		return this;
	}

	public UsersList selectMaintainEventTemplateOption() throws Exception {
		waitForElement.waitForElements(Locators.MAINTAINEVENTTEMPLATE, "css");
		this.page.element(Locators.MAINTAINEVENTTEMPLATE, "css").getOne().click();
		return this;
	}

	public UsersList selectRole(String _roleValue) throws Exception {
		waitForElement.waitForElements(Locators.SELECTROLEPART1 + _roleValue + Locators.SLECTROLEPART2, "xpath");
		this.page.element(Locators.SELECTROLEPART1 + _roleValue + Locators.SLECTROLEPART2, "xpath").getDisplayedOne().click();
		return this;
	}

	public UsersList selectConfigureRegionViewsOption() throws Exception {
		waitForElement.waitForElements(Locators.SETUPREGIONVIEWS, "css");
		this.page.element(Locators.SETUPREGIONVIEWS, "css").getOne().click();
		return this;
	}

	public UsersList selectConfigureRegionalUserAccessOption() throws Exception {
		waitForElement.waitForElements(Locators.CONFIGUREREGIONALUSERACCESS, "css");
		if(!this.page.element(Locators.CONFIGUREREGIONALUSERACCESS, "css").getOne().isSelected()) {
			this.page.element(Locators.CONFIGUREREGIONALUSERACCESS, "css").getOne().sendKeys(Keys.SPACE);
		}
		if(!this.page.element(Locators.CONFIGUREREGIONALUSERACCESS, "css").getOne().isSelected()) {
			this.page.element(Locators.CONFIGUREREGIONALUSERACCESS, "css").Click();
		}
		if(!this.page.element(Locators.CONFIGUREREGIONALUSERACCESS, "css").getOne().isSelected()) {
			this.page.element(Locators.CONFIGUREREGIONALUSERACCESS, "css").clickUsingJSE();
		}
		assertTrue(this.page.element(Locators.CONFIGUREREGIONALUSERACCESS, "css").getOne().isSelected());
		return this;
	}

	public UsersList searchUserName(String strUsername)
			throws Exception {
		this.enterUsernameInSearchInputField(strUsername);
		this.clickSearchButton();
		return this;
	}

	public UsersList enterUsernameInSearchInputField(String _username) throws Exception {
		waitForElement.waitForElements(Locators.SEARCHFIELD, "id");
		this.page.element(Locators.SEARCHFIELD, "id").clearInputValue().sendKeys(_username);
		assertEquals(this.page.element(Locators.SEARCHFIELD, "id").getOne().getAttribute("value"), _username);
		return this;
	}

	public UsersList clickSearchButton() throws Exception {
		waitForElement.waitForElements(Locators.SEARCH, "css");
		this.page.element(Locators.SEARCH, "css").getOne().click();
		return this;
	}

	public UsersList clickOnEdit(String _userName) throws Exception {
		waitForElement
		.waitForElements(Locators.USERSTABLE + _userName + Locators.EDITLINKOFUSER, "xpath");
		this.page
		.element(Locators.USERSTABLE + _userName + Locators.EDITLINKOFUSER, "xpath").getOne().click();
		waitForElement.waitForElements(Locators.USERNAME, "name");
		return this;
	}

	public UsersList enterPrimaryEmailId(String primaryMailId) throws Exception {
		waitForElement.waitForElements(Locators.PRIMARYEMAIL, "name");
		this.page.element(Locators.PRIMARYEMAIL, "name").clearInputValue()
		.sendKeys(primaryMailId);
		return this;
	}

	public UsersList entertextPagerId(String strtextPagerId) throws Exception {
		waitForElement.waitForElements(Locators.TEXTPAGER, "name");
		this.page.element(Locators.TEXTPAGER, "name").clearInputValue()
		.sendKeys(strtextPagerId);
		return this;
	}

	public UsersList enterOrganization(String organization) throws Exception {
		waitForElement.waitForElements(Locators.ORGANIZATION, "name");
		this.page.element(Locators.ORGANIZATION, "name").clearInputValue()
		.sendKeys(organization);
		return this;
	}

	public UsersList enterUserMandatoryDetailsWithEMailAndPager(
			String username, String Password, String fullName, String email,
			String pager) throws Exception {
		this.enterUserMandatoryDetails(username, Password, fullName);
		this.enterPrimaryEmailId(email);
		this.enterSecondaryEmailId(email);
		this.entertextPagerId(pager);
		return this;
	}

	public UsersList enterUserDetailsWithEMailAndPager(
			String username, String Password, String fullName, String email,
			String pager) throws Exception {
		this.clickOnCreateNewUser();
		this.enterUserMandatoryDetails(username, Password, fullName);
		this.enterPrimaryEmailId(email);
		this.entertextPagerId(pager);
		this.selectFirstRole();
		return this;
	}

	public UsersList selectFormUserMayActivateFormsOption() throws Exception {
		waitForElement.waitForElements(Locators.USERMAYACTIVATEFORM, "css");
		this.page.element(Locators.USERMAYACTIVATEFORM, "css").getOne().click();
		return this;
	}

	public UsersList selectFormUserMayActivateAndModifyFormsOption()
			throws Exception {
		waitForElement.waitForElements(Locators.USERMAYCREATEANDMODIFYFORMS, "css");
		this.page.element(Locators.USERMAYCREATEANDMODIFYFORMS, "css").getOne()
		.click();
		return this;
	}

	public UsersList createUserWithUpdateRightOnResource(
			String username, String Password, String fullName, String email,
			String pager, String[] resourceName) throws Exception {
		this.clickOnCreateNewUser();
		this.enterUserMandatoryDetails(username, Password, fullName);
		this.enterPrimaryEmailId(email);
		this.enterSecondaryEmailId(email);
		this.entertextPagerId(pager);
		this.selectFirstRole();
		this.selectViewResourceCheckBox(resourceName);
		this.selectUpdateStatusOfResource(resourceName);
		return this;
	}

	public UsersList createUserWithMandatoryDetailsAndEMailPager(
			String username, String Password, String fullName, String email,
			String pager, String roleValue) throws Exception {
		this.clickOnCreateNewUser();
		this.enterUserMandatoryDetailsWithEMailAndPager(username, Password, fullName, email, pager);
		this.selectRole(roleValue);
		return this;
	}

	public UsersList provideMaintainEventsRightAndSave() throws Exception {
		this.provideMaintainEventsRight();
		this.clickOnSave();
		return this;
	}

	public UsersList createUserWithMandatoryDetailsAndEMailPager(
			String username, String Password, String fullName, String email,
			String pager) throws Exception {
		this.clickOnCreateNewUser();
		this.enterUserMandatoryDetailsWithEMailAndPager(username, Password, fullName, email, pager);
		this.selectFirstRole();
		this.clickOnSave();
		return this;
	}

	public UsersList selectFirstRole() throws Exception {
		waitForElement.waitForElements(Locators.FIRSTROLE, "xpath");
		this.page.element(Locators.FIRSTROLE, "xpath").getDisplayedOne().click();
		return this;
	}

	public UsersList provideUserMayCreateAndModifyFormsAndUserMayActivateFormsRight() throws Exception {
		this.provideFormUserMayCreateAndModifyFormsRight();
		this.provideFormUserMayActivateFormsRight();
		this.clickOnSave();
		return this;
	}

	public UsersList provideFormUserMayCreateAndModifyFormsRight() throws Exception {
		this.clickOnAdvancedOptionAndExpand();
		waitForElement.waitForElements(Locators.USERMAYCREATEANDMODIFYFORMS, "css");
		this.page.element(Locators.USERMAYCREATEANDMODIFYFORMS, "css").getOne().click();
		return this;
	}

	public UsersList provideFormUserMayActivateFormsRight() throws Exception {
		this.clickOnAdvancedOptionAndExpand();
		waitForElement.waitForElements(Locators.USERMAYACTIVATEFORM, "css");
		this.page.element(Locators.USERMAYACTIVATEFORM, "css").getOne().click();
		return this;
	}

	public UsersList clickOnImportUser() throws Exception {
		waitForElement.waitForElements(Locators.IMPORT_USERS, "css");
		this.page.element(Locators.IMPORT_USERS, "css").getOne().click();
		return this;
	}

	public UsersList verifyEditUsersScreen() throws Exception {
		waitForElement.waitForElements(Locators.EDIT_USERS_SCREEN, "xpath");
		assertTrue(this.page.element(Locators.EDIT_USERS_SCREEN, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.EDIT_USERS_SCREEN, "xpath").getOne().isDisplayed());
		return this;
	}

	public UsersList verifyUsername(String username) throws Exception {
		waitForElement.waitForElements(Locators.USERNAME, "name");
		assertTrue(this.page.element(Locators.USERNAME, "name").getOne().getAttribute("value").equals(username));
		return this;
	}

	public UsersList verifyUserFullname(String firstName, String userLastname) throws Exception {
		waitForElement.waitForElements(Locators.FULLNAME, "name");
		assertTrue(this.page.element(Locators.FULLNAME, "name").getOne().getAttribute("value").equals(firstName + " " + userLastname));
		return this;
	}

	public UsersList verifyLastname(String lastname) throws Exception {
		waitForElement.waitForElements(Locators.LASTNAME, "name");
		assertTrue(this.page.element(Locators.LASTNAME, "name").getOne().getAttribute("value").equals(lastname));
		return this;
	}

	public UsersList verifyOrganization(String organization) throws Exception {
		waitForElement.waitForElements(Locators.ORGANIZATION, "name");
		assertTrue(this.page.element(Locators.ORGANIZATION, "name").getOne().getAttribute("value").equals(organization));
		return this;
	}

	public UsersList verifyPhoneNumber(String phoneNumber) throws Exception {
		waitForElement.waitForElements(Locators.PHONENUMBER, "name");
		assertTrue(this.page.element(Locators.PHONENUMBER, "name").getOne().getAttribute("value").equals(phoneNumber));
		return this;
	}

	public UsersList verifyImportedUserDetailsAndSave(String username, String firstName, String userLastname, String organization, String phoneNumber) throws Exception {
		this.verifyEditUsersScreen();
		this.verifyUsername(username);
		this.verifyUserFullname(firstName, userLastname);
		this.verifyLastname(userLastname);
		this.verifyPhoneNumber(phoneNumber);
		this.verifyOrganization(organization);
		this.clickOnSave();
		return this;
	}

	public UsersList provideReceiveIncomingPatientNotificationsRight()throws Exception {
		waitForElement.waitForElements(Locators.RECEIVEINCOMINGPATIENTNOTIFICATION, "css");
		this.page.element(Locators.RECEIVEINCOMINGPATIENTNOTIFICATION, "css").getOne().click();
		assertTrue(this.page.element(Locators.RECEIVEINCOMINGPATIENTNOTIFICATION, "css").getOne().isSelected());
		return this;
	}

	public UsersList provideReceiveIncomingPatientNotificationsRightAndSave() throws Exception {
		this.clickOnAdvancedOptionAndExpand();
		this.provideReceiveIncomingPatientNotificationsRight();
		this.clickOnSave();
		return this;
	}
	public UsersList clickOnSystemNotificationPrefrences() throws Exception {
		waitForElement.waitForElements(Locators.SYSTEMNOTIFICATIONPREFERNCES, "linktext");
		this.page.element(Locators.SYSTEMNOTIFICATIONPREFERNCES, "linktext").getOne().click();
		return this;
	}

	public UsersList selectEmail() throws Exception {
		waitForElement.waitForElements(Locators.EMAIL, "xpath");
		this.page.element(Locators.EMAIL, "xpath").getOne().click();
		assertTrue(this.page.element(Locators.EMAIL, "xpath").getOne().isSelected());
		return this;
	}

	public UsersList selectPager() throws Exception {
		waitForElement.waitForElements(Locators.PAGER, "xpath");
		this.page.element(Locators.PAGER, "xpath").getOne().click();
		assertTrue(this.page.element(Locators.PAGER, "xpath").getOne().isSelected());
		return this;
	}

	public UsersList clickOnSaveOfNotifications() throws Exception {
		waitForElement.waitForElements(Locators.SAVE, "css");
		this.page.element(Locators.SAVE, "css").getOne().click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		return this;
	}

	public UsersList verifySystemNotificationForUser(String username) throws Exception {
		String userName=Locators.SYSTEMNOTIFICATIONPREFERNCESPGAEFORUSER +username+ Locators.CLOSEBRACKETS;
		waitForElement.waitForElements(userName, "xpath");
		assertTrue(this.page.element(userName, "xpath").isElementPresent());
		assertTrue(this.page.element(userName, "xpath").getOne().isDisplayed());
		return this;
	}

	public UsersList enableUserToReceivePagerAndMailNotifiactionsOfIPN(String username) throws Exception {
		searchUserName(username);
		clickOnEdit(username);
		clickOnSystemNotificationPrefrences();
		verifySystemNotificationForUser(username);
		selectEmail();
		selectPager();
		clickOnSaveOfNotifications();
		return this;
	}

	public UsersList searchUser(String username)
			throws Exception {
		enterUsernameInSearchInputField(username);
		this.clickSearchButton();
		this.clickOnEdit(username);
		return this;
	}

	public UsersList clickOnStatusChangeNotificationPreferences() throws Exception {
		waitForElement.waitForElements(Locators.STATUSCHANGENOTIFICATIONSPREFERENCES, "linktext");
		this.page.element(Locators.STATUSCHANGENOTIFICATIONSPREFERENCES, "linktext").getOne().click();
		return this;
	}

	public UsersList provideUpdateRightOnResourceAndSave(String _resource) throws Exception {
		this.selectUpdateStatusOfResource(_resource);
		this.clickOnSave();
		return this;
	}

	public UsersList verifyRegionNameDisplayedUnderViewOtherRegions(String region) throws Exception {
		String otherRegionView=Locators.VIEWOTHERREGIONS +region+ Locators.CLOSEBRACKETS;
		waitForElement.waitForElements(otherRegionView, "xpath");
		assertTrue(this.page.element(otherRegionView, "xpath").isElementPresent());
		assertTrue(this.page.element(otherRegionView, "xpath").getOne().isDisplayed());
		return this;
	}

	public UsersList verifyRegionNameDisplayedUnderViewOtherRegionsAndSave(String region) throws Exception {
		verifyRegionNameDisplayedUnderViewOtherRegions(region);
		clickOnSave();
		return this;
	}

	public UsersList selectViewResourceCheckBox(String resourceName)
			throws Exception {
		waitForElement.waitForElements(Locators.RESOURCELISTPART1 + resourceName + Locators.VIEWRIGHT, "xpath");
		if (this.page.element(Locators.RESOURCELISTPART1 + resourceName + Locators.VIEWRIGHT, "xpath").getOne().isSelected() == false) {
			this.page.element(Locators.RESOURCELISTPART1 + resourceName + Locators.VIEWRIGHT, "xpath").mouseOver();
			this.page.element(Locators.RESOURCELISTPART1 + resourceName + Locators.VIEWRIGHT, "xpath").getDisplayedOne().sendKeys(Keys.SPACE);
		}
		if (this.page.element(Locators.RESOURCELISTPART1 + resourceName + Locators.VIEWRIGHT, "xpath").getOne().isSelected() == false) {
			this.page.element(Locators.RESOURCELISTPART1 + resourceName + Locators.VIEWRIGHT, "xpath").clickUsingJSE();
		}
		if (this.page.element(Locators.RESOURCELISTPART1 + resourceName + Locators.VIEWRIGHT, "xpath").getOne().isSelected() == false) {
			this.page.element(Locators.RESOURCELISTPART1 + resourceName + Locators.VIEWRIGHT, "xpath").getDisplayedOne().click();
		}
		assertTrue(this.page.element(Locators.RESOURCELISTPART1 + resourceName + Locators.VIEWRIGHT, "xpath").getDisplayedOne().isSelected());
		return this;
	}

	public UsersList selectViewResourceCheckBox(String[] resourceName) throws Exception {
		for(int loopCount = 0; loopCount <resourceName.length; loopCount++) {
			waitForElement.waitForElements(Locators.RESOURCELISTPART1 + resourceName[loopCount] + Locators.VIEWRIGHT, "xpath");
			if (this.page.element(Locators.RESOURCELISTPART1 + resourceName[loopCount] + Locators.VIEWRIGHT, "xpath").getOne().isSelected() == false) {
				this.page.element(Locators.RESOURCELISTPART1 + resourceName[loopCount] + Locators.VIEWRIGHT, "xpath").mouseOver();
				this.page.element(Locators.RESOURCELISTPART1 + resourceName[loopCount] + Locators.VIEWRIGHT, "xpath").getOne().sendKeys(Keys.SPACE);
			}
			assertTrue(this.page.element(Locators.RESOURCELISTPART1 + resourceName[loopCount] + Locators.VIEWRIGHT, "xpath").getOne().isSelected());
		}
		return this;
	}

	public UsersList createUserWithMandatoryDetailsAndUpdateRightOnResource(
			String username, String Password, String fullName, String email,
			String pager, String roleValue, String resourceName) throws Exception {
		this.clickOnCreateNewUser();
		this.enterUserMandatoryDetailsWithEMailAndPager(username, Password, fullName, email, pager);
		this.selectRole(roleValue);
		this.selectViewResourceCheckBox(resourceName);
		this.selectUpdateStatusOfResource(resourceName);
		return this;
	}

	public UsersList provideUpdateRightOnResourcesAndSave(String _resource1,String _resource2) throws Exception {
		this.selectUpdateStatusOfResource(_resource1);
		this.selectUpdateStatusOfResource(_resource2);
		this.clickOnSave();
		return this;	
	}

	public UsersList provideConfigureRegionViewsRightAndSave() throws Exception {
		this.clickOnAdvancedOptionAndExpand();
		this.selectConfigureRegionViewsOption();
		this.clickOnSave();
		return this;	
	}

	public UsersList selectViewCustomViewOption() throws Exception {
		waitForElement.waitForElements(Locators.VIEW_CUSTOM_VIEW_RIHT, "css");
		if(this.page.element(Locators.VIEW_CUSTOM_VIEW_RIHT, "css").getOne().isSelected()==false){
			this.page.element(Locators.VIEW_CUSTOM_VIEW_RIHT, "css").getOne().click();
		}
		try{
			assertTrue(this.page.element(Locators.VIEW_CUSTOM_VIEW_RIHT, "css").getOne().isSelected());
		}catch(Exception e) {
			if(this.page.element(Locators.VIEW_CUSTOM_VIEW_RIHT, "css").getOne().isSelected()==false){
				this.page.element(Locators.VIEW_CUSTOM_VIEW_RIHT, "css").getOne().sendKeys(Keys.SPACE);
			}
		}
		assertTrue(this.page.element(Locators.VIEW_CUSTOM_VIEW_RIHT, "css").getOne().isSelected());
		return this;
	}

	public UsersList provideViewCustomViewRight() throws Exception {
		this.clickOnAdvancedOptionAndExpand();
		this.selectViewCustomViewOption();
		return this;	
	}

	public UsersList selectWebService() throws Exception {
		waitForElement.waitForElements(Locators.WEBSERVICE, "name");
		this.page.element(Locators.WEBSERVICE, "name").getOne().click();
		if (!this.page.element(Locators.WEBSERVICE, "name").getOne().isSelected()) {
			this.page.element(Locators.WEBSERVICE, "name").clickUsingJSE();
		}
		assertTrue(this.page.element(Locators.WEBSERVICE, "name").getOne().isSelected(),
				"Web service check box is not selected while creating the user");
		return this;
	}

	public UsersList createUserBySelectingFirstRole(
			String username, String Password, String fullName, String email,
			String pager) throws Exception {
		this.clickOnCreateNewUser();
		this.enterUserMandatoryDetailsWithEMailAndPager(username, Password, fullName, email, pager);
		this.selectFirstRole();
		this.clickOnSave();
		return this;
	}

	public UsersList createWebServiceUserBySelectingFirstRole(
			String username, String Password, String fullName, String email,
			String pager,String organization) throws Exception {
		this.clickOnCreateNewUser();
		this.enterUserMandatoryDetailsWithEMailAndPager(username, Password, fullName, email, pager);
		this.enterOrganization(organization);
		this.selectWebService();
		this.selectFirstRole();
		this.clickOnSave();
		return this;
	}

	public UsersList provideSetupOtherRegionViewsRight() throws Exception {
		this.clickOnAdvancedOptionAndExpand();
		this.selectSetupOtherRegionViewsOption();
		return this;	
	}

	public UsersList selectSetupOtherRegionViewsOption() throws Exception {
		waitForElement.waitForElements(Locators.SETUP_OTHER_REGION_VIEWS_RIGHT, "css");
		if(this.page.element(Locators.SETUP_OTHER_REGION_VIEWS_RIGHT, "css").getOne().isSelected()==false){
			this.page.element(Locators.SETUP_OTHER_REGION_VIEWS_RIGHT, "css").clickUsingJSE();
		}
		try{
			assertTrue(this.page.element(Locators.SETUP_OTHER_REGION_VIEWS_RIGHT, "css").getOne().isSelected());
		}catch(Exception e) {
			if(this.page.element(Locators.SETUP_OTHER_REGION_VIEWS_RIGHT, "css").getOne().isSelected()==false){
				this.page.element(Locators.SETUP_OTHER_REGION_VIEWS_RIGHT, "css").getOne().sendKeys(Keys.SPACE);
			}
		}
		assertTrue(this.page.element(Locators.SETUP_OTHER_REGION_VIEWS_RIGHT, "css").getOne().isSelected());
		return this;
	}

	public UsersList provideEditStatusChangeNotificationPreferences() throws Exception {
		this.clickOnAdvancedOptionAndExpand();
		this.EditStatusChangeNotificationPreferences();
		return this;	
	}

	public UsersList EditStatusChangeNotificationPreferences() throws Exception {
		waitForElement.waitForElements(Locators.EDIT_STATUS_CHANGE_NOTIFICATION_PREFERENCES, "css");
		if(this.page.element(Locators.EDIT_STATUS_CHANGE_NOTIFICATION_PREFERENCES, "css").getOne().isSelected()==false){
			this.page.element(Locators.EDIT_STATUS_CHANGE_NOTIFICATION_PREFERENCES, "css").getOne().click();
		}
		try{
			assertTrue(this.page.element(Locators.EDIT_STATUS_CHANGE_NOTIFICATION_PREFERENCES, "css").getOne().isSelected());
		}catch(Exception e) {
			if(this.page.element(Locators.EDIT_STATUS_CHANGE_NOTIFICATION_PREFERENCES, "css").getOne().isSelected()==false){
				this.page.element(Locators.EDIT_STATUS_CHANGE_NOTIFICATION_PREFERENCES, "css").getOne().sendKeys(Keys.SPACE);
			}
		}
		assertTrue(this.page.element(Locators.EDIT_STATUS_CHANGE_NOTIFICATION_PREFERENCES, "css").getOne().isSelected());
		return this;
	}

	public UsersList provideEditStatusChangeNotificationPreferencesAndSave() throws Exception {
		this.clickOnAdvancedOptionAndExpand();
		this.EditStatusChangeNotificationPreferences();
		this.clickOnSave();
		this.verifyUsersListPage();
		return this;	
	}

	public UsersList provideSetupOtherRegionViewsRightAndSetupResourcesAddAndEditRight() throws Exception {
		this.clickOnAdvancedOptionAndExpand();
		this.selectSetupOtherRegionViewsOption();
		this.selectSetupResourcesAddAndEditRight();
		this.clickOnSave();
		return this;	
	}

	public UsersList selectSendIncomingPatientNotificationsRight()throws Exception {
		waitForElement.waitForElements(Locators.SEND_INCOMING_PATIENT_NOTIFICATIONS, "css");
		this.page.element(Locators.SEND_INCOMING_PATIENT_NOTIFICATIONS, "css").getOne().click();
		assertTrue(this.page.element(Locators.SEND_INCOMING_PATIENT_NOTIFICATIONS, "css").getOne().isSelected());
		return this;
	}

	public UsersList provideSendIncomingPatientNotificationsRightAndSave() throws Exception {
		this.clickOnAdvancedOptionAndExpand();
		this.selectSendIncomingPatientNotificationsRight();
		this.clickOnSave();
		return this;	
	}

	public UsersList createUserWithMandatoryDetailsWithRoleWithoutSave(
			String username, String Password, String fullName, String email,
			String pager) throws Exception {
		this.clickOnCreateNewUser();
		this.enterUserMandatoryDetailsWithEMailAndPager(username, Password, fullName, email, pager);
		this.selectFirstRole();
		return this;
	}

	public UsersList VerifyWebServiceAccountErrorMessage() throws Exception {
		waitForElement.waitForElements(Locators.WEB_SERVICE_ACCOUNT_ERROR, "xpath");
		assertTrue(this.page.element(Locators.WEB_SERVICE_ACCOUNT_ERROR, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.WEB_SERVICE_ACCOUNT_ERROR, "xpath").getOne().isDisplayed());
		assertTrue(this.page.element(Locators.WEB_SERVICE_ACCOUNT_ERROR_MESSAGE_BODY, "xpath").isElementPresent());
		ErrorMessage=this.page.element(Locators.WEB_SERVICE_ACCOUNT_ERROR_MESSAGE_BODY, "xpath").getOne().getText();
		String message="Error\n"+
				"Web service accounts are not allowed to log in to EMResource. To obtain an account or for login assistance contact the Support Center by sending an email to support@intermedix.com or calling 1-888-735-9559, then press 1 for Client Application Support and 6 for EMSystems.\n"+
				"NOTE: This will not affect the ability for web service accounts to programmatically interact with EMResource.\n"+
				"Click here to return to the login page.";
		System.out.println(ErrorMessage);
		assertTrue(ErrorMessage.equals(message));
		return this;
	}

	public UsersList verifyRegionUnderViewOtherRegionsSectionIsDisabledAndChecked(String regionValue) throws Exception {
		String otherViewSection=Locators.OTHER_REGION_VIEW_SECTION_DISABLED+regionValue+Locators.CLOSEBRACKETS;
		waitForElement.waitForElements(otherViewSection, "xpath");
		this.page.element(otherViewSection, "xpath").mouseOver();
		assertTrue(this.page.element(otherViewSection, "xpath").getOne().isSelected(),"check box followed by region under other region view section is not selected");
		assertTrue(!this.page.element(otherViewSection, "xpath").getOne().isEnabled(),"check box followed by region under other region view section is enabled");
		return this;
	}

	public UsersList verifyViewOtherRegionSectionIsDisabledAndCheckedForCreateUser(String regionName,String regionValue) throws Exception {
		navigateTo.users();
		this.clickOnCreateNewUser();
		this.verifyRegionUnderViewOtherRegionsSectionIsDisabledAndChecked(regionValue);
		return this;
	}

	public UsersList verifyViewOtherRegionSectionIsDisabledAndCheckedForEditUser(String regionName,String userName,String regionValue) throws Exception {
		navigateTo.users();
		this.searchUser(userName);
		this.verifyRegionUnderViewOtherRegionsSectionIsDisabledAndChecked(regionValue);
		return this;
	}

	public UsersList verifyRegionUnderViewOtherRegionsSectionIsEnabledAndUnChecked(String regionValue) throws Exception {
		String otherViewSection=Locators.OTHER_REGION_VIEW_SECTION_ENABLED+regionValue+Locators.CLOSEBRACKETS;
		waitForElement.waitForElements(otherViewSection, "xpath");
		this.page.element(otherViewSection, "xpath").mouseOver();
		assertTrue(!this.page.element(otherViewSection, "xpath").getOne().isSelected(),"check box followed by region under other region view section is selected");
		assertTrue(this.page.element(otherViewSection, "xpath").getOne().isEnabled(),"check box followed by region under other region view section is not enabled");
		return this;
	}

	public UsersList verifyViewOtherRegionSectionIsEnabledAndUnCheckedForCreateUser(String regionName,String regionValue) throws Exception {
		navigateTo.users();
		this.clickOnCreateNewUser();
		this.verifyRegionUnderViewOtherRegionsSectionIsEnabledAndUnChecked(regionValue);
		return this;
	}

	public UsersList verifyViewOtherRegionSectionIsEnabledAndUnCheckedForEditUser(String regionName,String userName,String regionValue) throws Exception {
		navigateTo.users();
		this.searchUser(userName);
		this.verifyRegionUnderViewOtherRegionsSectionIsEnabledAndUnChecked(regionValue);
		return this;
	}

	public UsersList provideReportIncomingPatientNotificationDetailRight()throws Exception {
		waitForElement.waitForElements(Locators.REPORT_INCOMING_PATIENT_NOTIFICATION_DETAIL_RIGHT, "css");
		this.page.element(Locators.REPORT_INCOMING_PATIENT_NOTIFICATION_DETAIL_RIGHT, "css").clickUsingJSE();
		assertTrue(this.page.element(Locators.REPORT_INCOMING_PATIENT_NOTIFICATION_DETAIL_RIGHT, "css").getOne().isSelected());
		return this;
	}

	public UsersList provideReceiveIncomingPatientNotificationsAndReportIPNDetailsRight() throws Exception {
		this.clickOnAdvancedOptionAndExpand();
		this.provideReceiveIncomingPatientNotificationsRight();
		this.provideReportIncomingPatientNotificationDetailRight();
		this.clickOnSave();
		return this;	
	}

	public UsersList clickOnRegionLinkOfUser(String userName) throws Exception {
		waitForElement.waitForElements(Locators.TABLE_CELL_WITH_TEXT + userName + Locators.TABLE_CELL_WITH_TEXT_PART1 + UsersData.REGION_LINK + Locators.CLOSEBRACKETS, "xpath");
		this.page.element(Locators.TABLE_CELL_WITH_TEXT + userName + Locators.TABLE_CELL_WITH_TEXT_PART1 + UsersData.REGION_LINK + Locators.CLOSEBRACKETS, "xpath").getOne().click();
		if(this.page.element(Locators.EDIT_USERS_REGIONS_SCREEN, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE)==false)
		{
			this.page.element(Locators.TABLE_CELL_WITH_TEXT + userName + Locators.TABLE_CELL_WITH_TEXT_PART1 + UsersData.REGION_LINK + Locators.CLOSEBRACKETS, "xpath").clickUsingJSE();
		}
		return this;
	}

	public UsersList selectRegion(String regionValue) throws Exception {
		waitForElement.waitForElements(Locators.USER_REGIONS + regionValue + Locators.CLOSEBRACKETS, "css");
		if (this.page.element(Locators.USER_REGIONS + regionValue + Locators.CLOSEBRACKETS, "css").getOne().isSelected() == false) {
			this.page.element(Locators.USER_REGIONS + regionValue + Locators.CLOSEBRACKETS, "css").clickUsingJSE();
		}
		assertTrue(this.page.element(Locators.USER_REGIONS + regionValue + Locators.CLOSEBRACKETS, "css").getOne().isSelected());
		return this;
	}

	public UsersList provideMultiRegionAccessToUser(String userName, String[] regionValue) throws Exception {
		this.clickOnRegionLinkOfUser(userName);
		for(int intCount=0; intCount<regionValue.length; intCount++){
			this.selectRegion(regionValue[intCount]);
		}
		this.clickOnSave();
		return this;
	}

	public UsersList createUserWithMandatoryDetailsBySelectingFirstRoleWithoutSave(
			String username, String Password, String fullName, String email,
			String pager) throws Exception {
		this.clickOnCreateNewUser();
		this.enterUserMandatoryDetailsWithEMailAndPager(username, Password, fullName, email, pager);
		this.selectFirstRole();
		return this;
	}

	public UsersList createUserWithMandatoryDetailsAndSave(
			String username, String Password, String fullName, String email,
			String pager, String roleValue) throws Exception {
		this.clickOnCreateNewUser();
		this.enterUserMandatoryDetailsWithEMailAndPager(username, Password, fullName, email, pager);
		this.selectRole(roleValue);
		this.clickOnSave();
		return this;
	}

	public UsersList selectSetupResourcesAddAndEditRight() throws Exception {
		waitForElement.waitForElements(Locators.SETUP_RESOURCES_ADD_AND_EDIT_RIGHT, "css");
		if(this.page.element(Locators.SETUP_RESOURCES_ADD_AND_EDIT_RIGHT, "css").getOne().isSelected()==false){
			this.page.element(Locators.SETUP_RESOURCES_ADD_AND_EDIT_RIGHT, "css").clickUsingJSE();
		}
		try{
			assertTrue(this.page.element(Locators.SETUP_RESOURCES_ADD_AND_EDIT_RIGHT, "css").getOne().isSelected());
		}catch(Exception e) {
			if(this.page.element(Locators.SETUP_RESOURCES_ADD_AND_EDIT_RIGHT, "css").getOne().isSelected()==false){
				this.page.element(Locators.SETUP_RESOURCES_ADD_AND_EDIT_RIGHT, "css").getOne().sendKeys(Keys.SPACE);
			}
		}
		assertTrue(this.page.element(Locators.SETUP_RESOURCES_ADD_AND_EDIT_RIGHT, "css").getOne().isSelected());
		return this;
	}

	public UsersList selectSetupResourcesEditOnlyRight() throws Exception {
		waitForElement.waitForElements(Locators.SETUP_RESOURCES_EDIT_ONLY_RIGHT, "css");
		if(this.page.element(Locators.SETUP_RESOURCES_EDIT_ONLY_RIGHT, "css").getOne().isSelected()==false){
			this.page.element(Locators.SETUP_RESOURCES_EDIT_ONLY_RIGHT, "css").clickUsingJSE();
		}
		try{
			assertTrue(this.page.element(Locators.SETUP_RESOURCES_EDIT_ONLY_RIGHT, "css").getOne().isSelected());
		}catch(Exception e) {
			if(this.page.element(Locators.SETUP_RESOURCES_EDIT_ONLY_RIGHT, "css").getOne().isSelected()==false){
				this.page.element(Locators.SETUP_RESOURCES_EDIT_ONLY_RIGHT, "css").getOne().sendKeys(Keys.SPACE);
			}
		}
		assertTrue(this.page.element(Locators.SETUP_RESOURCES_EDIT_ONLY_RIGHT, "css").getOne().isSelected());
		return this;
	}

	public UsersList verifyUsersListPage() throws Exception {
		waitForElement.waitForElements(Locators.USERS_LIST_SCREEN, "xpath");
		assertTrue(this.page.element(Locators.USERS_LIST_SCREEN, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.USERS_LIST_SCREEN, "xpath").getOne().isDisplayed());
		return this;
	}

	public UsersList provideSetupOtherRegionViewsRightAndSave() throws Exception {
		this.clickOnAdvancedOptionAndExpand();
		this.selectSetupOtherRegionViewsOption();
		this.clickOnSave();
		return this;	
	}

	public UsersList selectAllViewResourceRight() throws Exception {
		waitForElement.waitForElements(Locators.VIEW_RESOURCE_RIGHT_SELECT_ALL, "css");
		if(!this.page.element(Locators.VIEW_RESOURCE_RIGHT_SELECT_ALL, "css").getDisplayedOne().isSelected()) {
			this.page.element(Locators.VIEW_RESOURCE_RIGHT_SELECT_ALL, "css").clickUsingJSE();
		}
		assertTrue(this.page.element(Locators.VIEW_RESOURCE_RIGHT_SELECT_ALL, "css").getDisplayedOne().isSelected(), "View right on all resources is not selected.");
		return this;
	}

	public UsersList clickOnMultiRegionEventRightsLink() throws Exception {
		waitForElement.waitForElements(Locators.MULTI_REGION_EVENT_RIGHTS_LINK, "xpath");
		this.page.element(Locators.MULTI_REGION_EVENT_RIGHTS_LINK, "xpath").clickUsingJSE();
		return this;
	}
	public UsersList selectRegionsUnderEditMultiRegionEventRightsPage(String regionValue) throws Exception {
		waitForElement.waitForElements(Locators.MULTI_REGION_EVENT_RIGHTS_FOR_USER + regionValue + Locators.CLOSEBRACKETS, "css");
		if (this.page.element(Locators.MULTI_REGION_EVENT_RIGHTS_FOR_USER + regionValue + Locators.CLOSEBRACKETS, "css").getOne().isSelected() == false) {
			this.page.element(Locators.MULTI_REGION_EVENT_RIGHTS_FOR_USER + regionValue + Locators.CLOSEBRACKETS, "css").clickUsingJSE();
		}
		assertTrue(this.page.element(Locators.MULTI_REGION_EVENT_RIGHTS_FOR_USER + regionValue + Locators.CLOSEBRACKETS, "css").getOne().isSelected());
		return this;
	}

	public UsersList editUserAndProvideMultiRegionEventsRight(String username, String[] regionValue) throws Exception {
		this.searchUserName(username);
		this.clickOnEdit(username);
		this.clickOnMultiRegionEventRightsLink();
		for(int intCount=0; intCount<regionValue.length; intCount++){
			this.selectRegionsUnderEditMultiRegionEventRightsPage(regionValue[intCount]);
		}
		this.clickOnSave();
		this.verifyEditUsersScreen();
		this.clickOnSave();
		this.verifyUsersListPage();
		return this;
	}

	public UsersList enterSecondaryEmailId(String eMailId) throws Exception {
		waitForElement.waitForElements(Locators.SECONDARY_EMAIL, "name");
		this.page.element(Locators.SECONDARY_EMAIL, "name").clearInputValue().sendKeys(eMailId);
		assertTrue(this.page.element(Locators.SECONDARY_EMAIL, "name").getOne().getAttribute("value").equals(eMailId), eMailId + " is not present in the field.");
		return this;
	}

	public UsersList providePreferencesEditStatusChangeNotificationPreferencesRightAndSave() throws Exception {
		this.clickOnAdvancedOptionAndExpand();
		this.selectPreferencesEditStatusChangeNotificationPreferencesOption();
		this.clickOnSave();
		return this;	
	}

	public UsersList selectPreferencesEditStatusChangeNotificationPreferencesOption() throws Exception {
		waitForElement.waitForElements(Locators.EDIT_STATUS_CHANGE_NOTIFICATION_PREFERENCES, "css");
		if(this.page.element(Locators.EDIT_STATUS_CHANGE_NOTIFICATION_PREFERENCES, "css").getOne().isSelected()==false){
			this.page.element(Locators.EDIT_STATUS_CHANGE_NOTIFICATION_PREFERENCES, "css").clickUsingJSE();
		}
		try{
			assertTrue(this.page.element(Locators.EDIT_STATUS_CHANGE_NOTIFICATION_PREFERENCES, "css").getOne().isSelected());
		}catch(Exception e) {
			if(this.page.element(Locators.EDIT_STATUS_CHANGE_NOTIFICATION_PREFERENCES, "css").getOne().isSelected()==false){
				this.page.element(Locators.EDIT_STATUS_CHANGE_NOTIFICATION_PREFERENCES, "css").getOne().sendKeys(Keys.SPACE);
			}
		}
		assertTrue(this.page.element(Locators.EDIT_STATUS_CHANGE_NOTIFICATION_PREFERENCES, "css").getOne().isSelected());
		return this;
	}

	public UsersList provideSetupResourcesAddAndEditRight() throws Exception {
		this.clickOnAdvancedOptionAndExpand();
		this.selectSetupResourcesAddAndEditRight();
		return this;	
	}

	public UsersList provideSetupResourcesAddAndEditRightAndSave() throws Exception {
		this.provideSetupResourcesAddAndEditRight();
		this.clickOnSave();
		return this;	
	}

	public UsersList selectMaintainAdHocEventsOption() throws Exception {
		waitForElement.waitForElements(Locators.EVENT_MAINTAIN_AD_HOC_EVENT, "css");
		if(this.page.element(Locators.EVENT_MAINTAIN_AD_HOC_EVENT, "css").getOne().isSelected()==false){
			this.page.element(Locators.EVENT_MAINTAIN_AD_HOC_EVENT, "css").clickUsingJSE();
		}
		try{
			assertTrue(this.page.element(Locators.EVENT_MAINTAIN_AD_HOC_EVENT, "css").getOne().isSelected());
		}catch(Exception e) {
			if(this.page.element(Locators.EVENT_MAINTAIN_AD_HOC_EVENT, "css").getOne().isSelected()==false){
				this.page.element(Locators.EVENT_MAINTAIN_AD_HOC_EVENT, "css").getOne().sendKeys(Keys.SPACE);
			}
		}
		assertTrue(this.page.element(Locators.EVENT_MAINTAIN_AD_HOC_EVENT, "css").getOne().isSelected());
		return this;
	}

	public UsersList provideMaintainAdHocEventsRight() throws Exception {
		this.clickOnAdvancedOptionAndExpand();
		this.selectMaintainAdHocEventsOption();
		return this;	
	}

	public UsersList provideMaintainEventAndMaintainAdHocEventsRightSave() throws Exception {
		this.provideMaintainEventsRight();
		this.selectMaintainAdHocEventsOption();
		this.clickOnSave();
		return this;	
	}

	public UsersList createUserWithUpdateRightOnResourceAndMantainEventRightAndSave(
			String username, String Password, String fullName, String email,
			String pager, String resourceName) throws Exception {
		this.clickOnCreateNewUser();
		this.enterUserMandatoryDetails(username, Password, fullName);
		this.enterPrimaryEmailId(email);
		this.entertextPagerId(pager);
		this.selectFirstRole();
		this.selectUpdateStatusOfResource(resourceName);
		this.provideMaintainEventsRightAndSave();
		return this;
	}

	public UsersList selectRunReportRightOnResource(String _resource)
			throws Exception {
		String mappedResource = Locators.RESOURCELISTPART1 + _resource + Locators.RUN_REPORT_RIGHT;
		waitForElement.waitForElements(mappedResource, "xpath");
		if (this.page.element(mappedResource, "xpath").getOne().isSelected() == false) {
			this.page.element(mappedResource, "xpath").getOne().sendKeys(Keys.SPACE);
		}
		if (this.page.element(mappedResource, "xpath").getOne().isSelected() == false) {
			this.page.element(mappedResource, "xpath").getOne().click();
		}
		if (this.page.element(mappedResource, "xpath").getOne().isSelected() == false) {
			this.page.element(mappedResource, "xpath").getOne().sendKeys(Keys.ENTER);
		}
		assertTrue(this.page.element(mappedResource, "xpath").getOne().isSelected());
		return this;
	}

	public UsersList createUserWithRunReportRightOnResourceAndMantainEventRightAndSave(
			String username, String Password, String fullName, String email,
			String pager, String resourceName) throws Exception {
		this.clickOnCreateNewUser();
		this.enterUserMandatoryDetails(username, Password, fullName);
		this.enterPrimaryEmailId(email);
		this.entertextPagerId(pager);
		this.selectFirstRole();
		this.selectRunReportRightOnResource(resourceName);
		this.provideMaintainEventsRightAndSave();
		return this;
	}

	public UsersList selectAssociateRightOnResource(String _resource)
			throws Exception {
		String mappedResource = Locators.RESOURCELISTPART1 + _resource + Locators.ASSOCIATE_RIGHT;
		waitForElement.waitForElements(mappedResource, "xpath");
		if (this.page.element(mappedResource, "xpath").getOne().isSelected() == false) {
			this.page.element(mappedResource, "xpath").getOne().sendKeys(Keys.SPACE);
		}
		if (this.page.element(mappedResource, "xpath").getOne().isSelected() == false) {
			this.page.element(mappedResource, "xpath").getOne().click();
		}
		if (this.page.element(mappedResource, "xpath").getOne().isSelected() == false) {
			this.page.element(mappedResource, "xpath").getOne().sendKeys(Keys.ENTER);
		}
		assertTrue(this.page.element(mappedResource, "xpath").getOne().isSelected());
		return this;
	}

	public UsersList createUserWithAssociateRightOnResourceAndMantainEventRightAndSave(
			String username, String Password, String fullName, String email,
			String pager, String resourceName) throws Exception {
		this.clickOnCreateNewUser();
		this.enterUserMandatoryDetails(username, Password, fullName);
		this.enterPrimaryEmailId(email);
		this.entertextPagerId(pager);
		this.selectFirstRole();
		this.selectAssociateRightOnResource(resourceName);
		this.provideMaintainEventsRightAndSave();
		return this;
	}

	public UsersList createUserWithViewResourceRightOnResourceAndMantainEventRightAndSave(
			String username, String Password, String fullName, String email,
			String pager, String resourceName) throws Exception {
		this.clickOnCreateNewUser();
		this.enterUserMandatoryDetails(username, Password, fullName);
		this.enterPrimaryEmailId(email);
		this.entertextPagerId(pager);
		this.selectFirstRole();
		this.provideMaintainEventsRightAndSave();
		return this;
	}

	public UsersList provideOverideviewingRistrictionRight() throws Exception {
		this.clickOnAdvancedOptionAndExpand();
		waitForElement.waitForElements(Locators.OVERRIDE_VIEWING_RESTRICTION, "css");
		this.page.element(Locators.OVERRIDE_VIEWING_RESTRICTION, "css").clickUsingJSE();
		return this;
	}

	public UsersList createUserWithViewResourceOverrideViewingRestrictionAndMantainEventRightAndSave(
			String username, String Password, String fullName, String email,
			String pager, String resourceName) throws Exception {
		this.clickOnCreateNewUser();
		this.enterUserMandatoryDetails(username, Password, fullName);
		this.enterPrimaryEmailId(email);
		this.entertextPagerId(pager);
		this.selectFirstRole();
		this.provideOverideviewingRistrictionRight();
		this.provideMaintainEventsRightAndSave();
		return this;
	}

	public UsersList clickOnCancel() throws Exception {
		waitForElement.waitForElements(Locators.CANCEL, "css");
		this.page.element(Locators.CANCEL, "css").getDisplayedOne().click();
		return this;
	}

	public UsersList verifyIPNSendIncomingPatientNotifications() throws Exception {
		waitForElement.waitForElements(Locators.SEND_INCOMING_PATIENT_NOTIFICATIONS, "css");
		assertTrue(this.page.element(Locators.SEND_INCOMING_PATIENT_NOTIFICATIONS, "css").isElementPresent());
		assertTrue(this.page.element(Locators.SEND_INCOMING_PATIENT_NOTIFICATIONS, "css").getOne().isDisplayed());
		return this;
	}

	public UsersList verifySendIPNUnderAdvancedOption() throws Exception {
		this.clickOnCreateNewUser();
		this.clickOnAdvancedOptionAndExpand();
		waitForElement.waitForElements(Locators.MAINTAINEVENTS, "css");
		this.verifyIPNSendIncomingPatientNotifications();
		return this;
	}

	public UsersList provideStatusSnapShotRight() throws Exception {
		waitForElement.waitForElements(Locators.STATUS_SNAPSHOT_RIGHT, "css");
		this.page.element(Locators.STATUS_SNAPSHOT_RIGHT, "css").getOne().click();
		return this;
	}

	public UsersList provideEventSnapShotRight() throws Exception {
		waitForElement.waitForElements(Locators.EVENT_SNAPSHOT_RIGHT, "css");
		this.page.element(Locators.EVENT_SNAPSHOT_RIGHT, "css").getOne().click();
		return this;
	}

	public UsersList createUserWithOnlyMantainEventRightAndSave(
			String username, String Password, String fullName, String email,
			String pager) throws Exception {
		this.clickOnCreateNewUser();
		this.enterUserMandatoryDetails(username, Password, fullName);
		this.enterPrimaryEmailId(email);
		this.entertextPagerId(pager);
		this.selectFirstRole();
		this.provideMaintainEventsRightAndSave();
		return this;
	}

	public UsersList selectMaintainEventTemplateRight() throws Exception {
		waitForElement.waitForElements(Locators.MAINTAIN_EVENT_TEMPLATE_RIGHT, "css");
		if(this.page.element(Locators.MAINTAIN_EVENT_TEMPLATE_RIGHT, "css").getOne().isSelected()==false){
			this.page.element(Locators.MAINTAIN_EVENT_TEMPLATE_RIGHT, "css").getOne().click();
		}
		try{
			assertTrue(this.page.element(Locators.MAINTAIN_EVENT_TEMPLATE_RIGHT, "css").getOne().isSelected());
		}catch(Exception e) {
			if(this.page.element(Locators.MAINTAIN_EVENT_TEMPLATE_RIGHT, "css").getOne().isSelected()==false){
				this.page.element(Locators.MAINTAIN_EVENT_TEMPLATE_RIGHT, "css").getOne().sendKeys(Keys.SPACE);
			}
		}
		assertTrue(this.page.element(Locators.MAINTAIN_EVENT_TEMPLATE_RIGHT, "css").getOne().isSelected());
		return this;
	}

	public UsersList provideMaintainEventTemplateRight() throws Exception {
		this.clickOnAdvancedOptionAndExpand();
		this.selectMaintainEventTemplateRight();
		return this;	
	}

	public UsersList selectSetUpStatusTypesRight() throws Exception {
		waitForElement.waitForElements(Locators.SETUP_STATUS_TYPE_RIGHT, "css");
		if(this.page.element(Locators.SETUP_STATUS_TYPE_RIGHT, "css").getOne().isSelected()==false){
			this.page.element(Locators.SETUP_STATUS_TYPE_RIGHT, "css").getOne().click();
		}
		try{
			assertTrue(this.page.element(Locators.SETUP_STATUS_TYPE_RIGHT, "css").getOne().isSelected());
		}catch(Exception e) {
			if(this.page.element(Locators.SETUP_STATUS_TYPE_RIGHT, "css").getOne().isSelected()==false){
				this.page.element(Locators.SETUP_STATUS_TYPE_RIGHT, "css").getOne().sendKeys(Keys.SPACE);
			}
		}
		assertTrue(this.page.element(Locators.SETUP_STATUS_TYPE_RIGHT, "css").getOne().isSelected());
		return this;
	}

	public UsersList provideSetUpStatusTypesRight() throws Exception {
		this.clickOnAdvancedOptionAndExpand();
		this.selectSetUpStatusTypesRight();
		return this;	
	}

	public UsersList selectSetupResourceTypesRight() throws Exception {
		waitForElement.waitForElements(Locators.SETUP_RESOURCE_TYPES_RIGHT, "css");
		if(this.page.element(Locators.SETUP_RESOURCE_TYPES_RIGHT, "css").getOne().isSelected()==false){
			this.page.element(Locators.SETUP_RESOURCE_TYPES_RIGHT, "css").getOne().click();
		}
		try{
			assertTrue(this.page.element(Locators.SETUP_RESOURCE_TYPES_RIGHT, "css").getOne().isSelected());
		}catch(Exception e) {
			if(this.page.element(Locators.SETUP_RESOURCE_TYPES_RIGHT, "css").getOne().isSelected()==false){
				this.page.element(Locators.SETUP_RESOURCE_TYPES_RIGHT, "css").getOne().sendKeys(Keys.SPACE);
			}
		}
		assertTrue(this.page.element(Locators.SETUP_RESOURCE_TYPES_RIGHT, "css").getOne().isSelected());
		return this;
	}

	public UsersList provideSetupResourceTypesRight() throws Exception {
		this.clickOnAdvancedOptionAndExpand();
		this.selectSetupResourceTypesRight();
		return this;	
	}

	public UsersList selectSetupRolesRight() throws Exception {
		waitForElement.waitForElements(Locators.SETUP_ROLES_RIGHT, "css");
		if(this.page.element(Locators.SETUP_ROLES_RIGHT, "css").getOne().isSelected()==false){
			this.page.element(Locators.SETUP_ROLES_RIGHT, "css").getOne().click();
		}
		try{
			assertTrue(this.page.element(Locators.SETUP_ROLES_RIGHT, "css").getOne().isSelected());
		}catch(Exception e) {
			if(this.page.element(Locators.SETUP_ROLES_RIGHT, "css").getOne().isSelected()==false){
				this.page.element(Locators.SETUP_ROLES_RIGHT, "css").getOne().sendKeys(Keys.SPACE);
			}
		}
		assertTrue(this.page.element(Locators.SETUP_ROLES_RIGHT, "css").getOne().isSelected());
		return this;
	}

	public UsersList provideSetupRolesRight() throws Exception {
		this.clickOnAdvancedOptionAndExpand();
		this.selectSetupRolesRight();
		return this;	
	}

	public UsersList selectUserMayCreateAndModifyFormsRight() throws Exception {
		waitForElement.waitForElements(Locators.USER_MAY_CREAT_AND_MODIFY_FORMS, "css");
		if(this.page.element(Locators.USER_MAY_CREAT_AND_MODIFY_FORMS, "css").getOne().isSelected()==false){
			this.page.element(Locators.USER_MAY_CREAT_AND_MODIFY_FORMS, "css").getOne().click();
		}
		try{
			assertTrue(this.page.element(Locators.USER_MAY_CREAT_AND_MODIFY_FORMS, "css").getOne().isSelected());
		}catch(Exception e) {
			if(this.page.element(Locators.USER_MAY_CREAT_AND_MODIFY_FORMS, "css").getOne().isSelected()==false){
				this.page.element(Locators.USER_MAY_CREAT_AND_MODIFY_FORMS, "css").getOne().sendKeys(Keys.SPACE);
			}
		}
		assertTrue(this.page.element(Locators.USER_MAY_CREAT_AND_MODIFY_FORMS, "css").getOne().isSelected());
		return this;
	}

	public UsersList provideUserMayCreateAndModifyFormsRight() throws Exception {
		this.clickOnAdvancedOptionAndExpand();
		this.selectUserMayCreateAndModifyFormsRight();
		return this;	
	}

	public UsersList createUserWithRole(String username, String Password, String fullName, String email,
			String pager, String roleValue) throws Exception {
		this.clickOnCreateNewUser();
		this.enterUserMandatoryDetailsWithEMailAndPager(username, Password, fullName, email, pager);
		this.deselectAllRoles();
		this.selectRole(roleValue);
		return this;
	}

	public UsersList provideRegionAccessToUser(String userName, String regionValue) throws Exception {
		this.clickOnRegionLinkOfUser(userName);
		this.selectRegion(regionValue);
		this.clickOnSave();
		return this;
	}
	
	public UsersList provideStatusReasonRight() throws Exception {
		this.clickOnAdvancedOptionAndExpand();
		this.selectStatusReasonRight();
		return this;	
	}

	public UsersList provideConfigureRegionalUserAccessRight() throws Exception {
		this.clickOnAdvancedOptionAndExpand();
		this.selectConfigureRegionalUserAccessOption();
		return this;	
	}

	public UsersList editUserAndProvideUpdateRight(String username,String resource) throws Exception {
		this.searchUserName(username);
		this.clickOnEdit(username);
		this.provideUpdateRightOnResourceAndSave(resource);
		return this;
	}

	public UsersList selectStatusReasonRight() throws Exception {
		waitForElement.waitForElements(Locators.STATUS_REASON_RIGHT, "css");
		if(this.page.element(Locators.STATUS_REASON_RIGHT, "css").getOne().isSelected()==false){
			this.page.element(Locators.STATUS_REASON_RIGHT, "css").clickUsingJSE();
		}
		try{
			assertTrue(this.page.element(Locators.STATUS_REASON_RIGHT, "css").getOne().isSelected());
		}catch(Exception e) {
			if(this.page.element(Locators.STATUS_REASON_RIGHT, "css").getOne().isSelected()==false){
				this.page.element(Locators.STATUS_REASON_RIGHT, "css").getOne().sendKeys(Keys.SPACE);
			}
		}
		assertTrue(this.page.element(Locators.STATUS_REASON_RIGHT, "css").getOne().isSelected());
		return this;
	}

	public UsersList clickRefineLinkOfParticularResource(String resourceName) throws Exception {
		waitForElement.waitForElements(Locators.TABLE_CELL_WITH_TEXT + resourceName + Locators.CLOSEBRACKETS + Locators.REFINE_RESOURCE, "xpath");
		this.page.element(Locators.TABLE_CELL_WITH_TEXT + resourceName + Locators.CLOSEBRACKETS + Locators.REFINE_RESOURCE, "xpath").getDisplayedOne().click();
		return this;
	}

	public UsersList verifyWebNotificationFrame() throws Exception {
		WebDriverWait wait = new WebDriverWait(this.driver,
				WaitTimeConstants.COUNT);
		wait.until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(Locators.WEB_NOTIFICATION_FRAME));
		return this;
	}

	public UsersList deSelectStatusType(ArrayList<String> statusTypeValues) throws Exception {
		String[] STs_Values = new String[statusTypeValues.size()];
		for(int i =0;i<statusTypeValues.size();i++){
			STs_Values[i] = statusTypeValues.get(i);
		}
		for (int i = 0; i < STs_Values.length; i++) {
			String selectStatusType = Locators.STATUS_TYPE_ID + STs_Values[i] + Locators.CLOSEBRACKETS;
			waitForElement.waitForElements(selectStatusType, "css");
			if (this.page.element(selectStatusType, "css").getDisplayedOne().isSelected()) {
				this.page.element(selectStatusType, "css").getDisplayedOne().sendKeys(Keys.SPACE);
			}
			if (this.page.element(selectStatusType, "css").getDisplayedOne().isSelected()) {
				this.page.element(selectStatusType, "css").getDisplayedOne().sendKeys(Keys.ENTER);
			}
			if (this.page.element(selectStatusType, "css").getDisplayedOne().isSelected()) {
				this.page.element(selectStatusType, "css").Click();
			}
			if (this.page.element(selectStatusType, "css").getDisplayedOne().isSelected()) {
				this.page.element(selectStatusType, "css").clickUsingJSE();
			}
			assertFalse((this.page.element(selectStatusType, "css").getDisplayedOne().isSelected()));
		}
		return this;
	}

	public UsersList clickSaveChangesOnRefineWindow() throws Exception {
		waitForElement.waitForElements(Locators.SAVE_CHANGES_ON_REFINE_WINDOW, "xpath");
		this.page.element(Locators.SAVE_CHANGES_ON_REFINE_WINDOW, "xpath").getDisplayedOne().click();
		return this;
	}

	public UsersList clickRefineAndDeselectStatusType(String resourceName, ArrayList<String> statusTypeValues) throws Exception {
		this.clickRefineLinkOfParticularResource(resourceName);
		this.verifyWebNotificationFrame();
		this.deSelectStatusType(statusTypeValues);
		this.clickSaveChangesOnRefineWindow();
		login.switchToDefaultWindow();
		login.selectFrame();
		this.clickOnSave();
		return this;
	}

	public UsersList verifyViewOtherRegionIsEnabled() throws Exception {
		waitForElement.waitForElements(Locators.VIEW_OTHER_REGION_SELECT_ALL, "css");
		assertTrue(this.page.element(Locators.VIEW_OTHER_REGION_SELECT_ALL, "css").getOne().isSelected());
		return this;
	}

	public UsersList enableViewOtherRegionIfNot(String regionValue) throws Exception {
		String viewOtherRegionDisabled = Locators.OTHER_REGION_VIEW_SECTION_DISABLED + regionValue+Locators.CLOSEBRACKETS;
		String viewOtherRegionEnabled = Locators.OTHER_REGION_VIEW_SECTION_ENABLED + regionValue+Locators.CLOSEBRACKETS;
		if(this.page.element(viewOtherRegionEnabled, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE)){
			this.page.element(viewOtherRegionEnabled, "xpath").getOne().sendKeys(Keys.SPACE);
			if(this.page.element(viewOtherRegionEnabled, "xpath").getOne().isSelected()){
				this.page.element(viewOtherRegionEnabled, "xpath").getOne().sendKeys(Keys.SPACE);
			}
			if(this.page.element(viewOtherRegionEnabled, "xpath").getOne().isSelected()){
				this.page.element(viewOtherRegionEnabled, "xpath").clickUsingJSE();
			}
			assertTrue(this.page.element(viewOtherRegionEnabled, "xpath").getOne().isSelected());
		} else {
			assertTrue(this.page.element(viewOtherRegionDisabled, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		}
		return this;
	}
	public UsersList createUserWithRunReportRightOnResourceAndSave(
			String username, String Password, String fullName, String email,
			String pager, String resourceName) throws Exception {
		this.clickOnCreateNewUser();
		this.enterUserMandatoryDetails(username, Password, fullName);
		this.enterPrimaryEmailId(email);
		this.enterSecondaryEmailId(email);
		this.entertextPagerId(pager);
		this.selectFirstRole();
		this.selectRunReportRightOnResource(resourceName);
		this.clickOnSave();
		return this;
	}

	public UsersList deselectViewResourceCheckBox(String[] resourceName) throws Exception {
		for(int loopCount = 0; loopCount <resourceName.length; loopCount++) {
			waitForElement.waitForElements(Locators.RESOURCELISTPART1 + resourceName[loopCount] + Locators.VIEWRIGHT, "xpath");
			if (this.page.element(Locators.RESOURCELISTPART1 + resourceName[loopCount] + Locators.VIEWRIGHT, "xpath").getOne().isSelected()) {
				this.page.element(Locators.RESOURCELISTPART1 + resourceName[loopCount] + Locators.VIEWRIGHT, "xpath").mouseOver();
				this.page.element(Locators.RESOURCELISTPART1 + resourceName[loopCount] + Locators.VIEWRIGHT, "xpath").getOne().sendKeys(Keys.SPACE);
			}
			if (this.page.element(Locators.RESOURCELISTPART1 + resourceName[loopCount] + Locators.VIEWRIGHT, "xpath").getOne().isSelected()) {
				this.page.element(Locators.RESOURCELISTPART1 + resourceName[loopCount] + Locators.VIEWRIGHT, "xpath").mouseOver();
				this.page.element(Locators.RESOURCELISTPART1 + resourceName[loopCount] + Locators.VIEWRIGHT, "xpath").clickUsingJSE();
			}
			assertFalse(this.page.element(Locators.RESOURCELISTPART1 + resourceName[loopCount] + Locators.VIEWRIGHT, "xpath").getOne().isSelected());
		}
		return this;
	}

	public UsersList createUserWithOverrideViewingRestrictionAndSave(
			String username, String Password, String fullName, String email,
			String pager, String[] resourceName) throws Exception {
		this.clickOnCreateNewUser();
		this.enterUserMandatoryDetails(username, Password, fullName);
		this.enterPrimaryEmailId(email);
		this.entertextPagerId(pager);
		this.selectFirstRole();
		this.deselectViewResourceCheckBox(resourceName);
		this.provideOverideviewingRistrictionRight();
		this.clickOnSave();
		return this;
	}

	public UsersList createUserWithoutSelectingAnyRightOnResourceAndSave(
			String username, String Password, String fullName, String email,
			String pager, String[] resourceName) throws Exception {
		this.clickOnCreateNewUser();
		this.enterUserMandatoryDetails(username, Password, fullName);
		this.enterPrimaryEmailId(email);
		this.entertextPagerId(pager);
		this.selectFirstRole();
		this.deselectViewResourceCheckBox(resourceName);
		this.clickOnSave();
		return this;
	}

	public UsersList createUserWithUpdateRightOnResourceAndSave(
			String username, String Password, String fullName, String email,
			String pager, String[] resourceName) throws Exception {
		this.clickOnCreateNewUser();
		this.enterUserMandatoryDetails(username, Password, fullName);
		this.enterPrimaryEmailId(email);
		this.entertextPagerId(pager);
		this.selectFirstRole();
		this.selectViewResourceCheckBox(resourceName);
		this.selectUpdateStatusOfResource(resourceName);
		this.clickOnSave();
		return this;
	}

	public UsersList provideFormUserMayActivateFormsRightAndSave() throws Exception {
		this.clickOnAdvancedOptionAndExpand();
		waitForElement.waitForElements(Locators.USERMAYACTIVATEFORM, "css");
		this.page.element(Locators.USERMAYACTIVATEFORM, "css").getOne().click();
		this.clickOnSave();
		return this;
	}

	public UsersList createUserWithAssociateRightOnResourceAndSave(
			String username, String Password, String fullName, String email,
			String pager, String resourceName) throws Exception {
		this.clickOnCreateNewUser();
		this.enterUserMandatoryDetails(username, Password, fullName);
		this.enterPrimaryEmailId(email);
		this.entertextPagerId(pager);
		this.selectFirstRole();
		this.selectAssociateRightOnResource(resourceName);
		this.clickOnSave();
		return this;
	}

	public UsersList deselectViewResourceRightOfResource(String resourceName) throws Exception {
		waitForElement.waitForElements(Locators.RESOURCELISTPART1 + resourceName + Locators.VIEW_RESOURCE_RIGHT_OF_RESOURCE, "xpath");
		if (this.page.element(Locators.RESOURCELISTPART1 + resourceName + Locators.VIEW_RESOURCE_RIGHT_OF_RESOURCE, "xpath").getDisplayedOne().isSelected()) {
			this.page.element(Locators.RESOURCELISTPART1 + resourceName + Locators.VIEW_RESOURCE_RIGHT_OF_RESOURCE, "xpath").getDisplayedOne().click();
		}
		assertFalse((this.page.element(Locators.RESOURCELISTPART1 + resourceName + Locators.VIEW_RESOURCE_RIGHT_OF_RESOURCE, "xpath").getDisplayedOne().isSelected()));
		return this;
	}

	public UsersList deselectUpdateResourceRightOfResource(String resourceName) throws Exception {
		waitForElement.waitForElements(Locators.RESOURCELISTPART1 + resourceName + Locators.UPDATERIGHT, "xpath");
		if (this.page.element(Locators.RESOURCELISTPART1 + resourceName + Locators.UPDATERIGHT, "xpath").getDisplayedOne().isSelected()) {
			this.page.element(Locators.RESOURCELISTPART1 + resourceName + Locators.UPDATERIGHT, "xpath").getDisplayedOne().click();
		}
		assertFalse((this.page.element(Locators.RESOURCELISTPART1 + resourceName + Locators.UPDATERIGHT, "xpath").getDisplayedOne().isSelected()));
		return this;
	}


	public UsersList createUserWithCustomViewRightsAndMantainEventRightAndSave(
			String username, String Password, String fullName, String email,
			String pager, String resourceName) throws Exception {
		this.clickOnCreateNewUser();
		this.enterUserMandatoryDetails(username, Password, fullName);
		this.enterPrimaryEmailId(email);
		this.entertextPagerId(pager);
		this.selectFirstRole();
		this.selectUpdateStatusOfResource(resourceName);
		this.provideMaintainEventsRight();
		this.provideViewCustomViewRightAndSave();
		return this;
	}

	public UsersList editAnddeselectUpdateViewResourceRightofresource(String userName, String resourceName) throws Exception {
		this.searchUser(userName);
		this.deselectUpdateResourceRightOfResource(resourceName);
		this.deselectViewResourceRightOfResource(resourceName);
		this.clickOnSave();
		return this;
	}

	public UsersList provideAllAffiliatedRightOnResource(String resourceName) throws Exception {
		this.selectAssociateRightOnResource(resourceName);
		this.selectUpdateStatusOfResource(resourceName);
		this.selectRunReportRightOnResource(resourceName);
		this.clickOnSave();
		return this;
	}

	public UsersList deselectAssociatedWithRightOfResource(String resourceName) throws Exception {
		waitForElement.waitForElements(Locators.RESOURCELISTPART1 + resourceName + Locators.ASSOCIATE_RIGHT, "xpath");
		if (this.page.element(Locators.RESOURCELISTPART1 + resourceName + Locators.ASSOCIATE_RIGHT, "xpath").getDisplayedOne().isSelected()) {
			this.page.element(Locators.RESOURCELISTPART1 + resourceName + Locators.ASSOCIATE_RIGHT, "xpath").getDisplayedOne().click();
		}
		assertFalse((this.page.element(Locators.RESOURCELISTPART1 + resourceName + Locators.ASSOCIATE_RIGHT, "xpath").getDisplayedOne().isSelected()));
		return this;
	}

	public UsersList deselectRunReportRightOfResource(String resourceName) throws Exception {
		waitForElement.waitForElements(Locators.RESOURCELISTPART1 + resourceName + Locators.RUN_REPORT_RIGHT, "xpath");
		if (this.page.element(Locators.RESOURCELISTPART1 + resourceName + Locators.RUN_REPORT_RIGHT, "xpath").getDisplayedOne().isSelected()) {
			this.page.element(Locators.RESOURCELISTPART1 + resourceName + Locators.RUN_REPORT_RIGHT, "xpath").getDisplayedOne().click();
		}
		assertFalse((this.page.element(Locators.RESOURCELISTPART1 + resourceName + Locators.RUN_REPORT_RIGHT, "xpath").getDisplayedOne().isSelected()));
		return this;
	}

	public UsersList editAnddeselectAllAffiliatedRightOnResource(String userName, String resourceName) throws Exception {
		this.searchUser(userName);
		this.deselectAssociatedWithRightOfResource(resourceName);
		this.deselectUpdateResourceRightOfResource(resourceName);
		this.deselectRunReportRightOfResource(resourceName);
		this.clickOnSave();
		return this;
	}

	public UsersList provideViewCustomViewRightAndSave() throws Exception {
		this.clickOnAdvancedOptionAndExpand();
		this.selectViewCustomViewOption();
		this.clickOnSave();
		this.verifyUsersListPage();
		return this;	
	}

	public UsersList createUserWithSetupRegionViewRightsAndMantainEventRightAndSave(
			String username, String Password, String fullName, String email,
			String pager, String resourceName) throws Exception {
		this.clickOnCreateNewUser();
		this.enterUserMandatoryDetails(username, Password, fullName);
		this.enterPrimaryEmailId(email);
		this.entertextPagerId(pager);
		this.selectFirstRole();
		this.selectUpdateStatusOfResource(resourceName);
		this.provideMaintainEventsRight();
		this.selectConfigureRegionViewsOption();
		this.clickOnSave();
		return this;
	}

	public UsersList editAndSelectUpdateViewResourceRightofresource(String userName, String resourceName) throws Exception {
		this.searchUser(userName);
		this.selectViewResourceCheckBox(resourceName);
		this.selectUpdateStatusOfResource(resourceName);
		return this;
	}

	public UsersList createUserWithAssociateRightOnResource(String username, String Password, String fullName, String email, String pager, String resourceName) throws Exception {
		this.createUserWithMandatoryDetailsWithRoleWithoutSave(username, Password, fullName, email, pager);
		this.selectViewResourceCheckBox(resourceName);
		this.selectAssociateRightOnResource(resourceName);
		return this;
	}

	public UsersList providePreferencesEditEventNotificationPreferencesRight() throws Exception {
		waitForElement.waitForElements(Locators.PREFRENCES_EDIT_EVENT_NOTIFICATION_PREFERENCES, "css");
		this.page.element(Locators.PREFRENCES_EDIT_EVENT_NOTIFICATION_PREFERENCES, "css").getDisplayedOne().click();
		return this;
	}

	public UsersList provideMaintainEventsMaintainEventTemplatesEditEventNotificationPreferencesRightSave()throws Exception {
		this.provideMaintainEventsRight();
		this.selectMaintainEventTemplateRight();
		this.providePreferencesEditEventNotificationPreferencesRight();
		this.clickOnSave();
		return this;
	}

	public UsersList selectUpdateStatusOfResource(ArrayList<String> resourceName) throws Exception {
		Iterator<String> iterator = resourceName.iterator();
		while(iterator.hasNext()){
			String resource = iterator.next();
			String mappedResource = Locators.RESOURCELISTPART1 + resource + Locators.UPDATERIGHT;
			waitForElement.waitForElements(mappedResource, "xpath");
			if (this.page.element(mappedResource, "xpath").getDisplayedOne().isSelected() == false) {
				this.page.element(mappedResource, "xpath").getDisplayedOne().sendKeys(Keys.SPACE);
			}
			if (this.page.element(mappedResource, "xpath").getDisplayedOne().isSelected() == false) {
				this.page.element(mappedResource, "xpath").getDisplayedOne().sendKeys(Keys.ENTER);
			}
			if (this.page.element(mappedResource, "xpath").getDisplayedOne().isSelected() == false) {
				this.page.element(mappedResource, "xpath").clickUsingJSE();
			}
			assertTrue(this.page.element(mappedResource, "xpath").getOne().isSelected());
		}
		return this;
	}

	public UsersList selectViewResourceCheckBox(ArrayList<String> resourceName) throws Exception {
		Iterator<String> iterator = resourceName.iterator();
		while(iterator.hasNext()){
			String resource = iterator.next();
			String mappedResource = Locators.RESOURCELISTPART1 + resource + Locators.VIEWRIGHT;
			waitForElement.waitForElements(mappedResource, "xpath");
			if (this.page.element(mappedResource, "xpath").getDisplayedOne().isSelected() == false) {
				this.page.element(mappedResource, "xpath").getDisplayedOne().sendKeys(Keys.SPACE);
			}
			if (this.page.element(mappedResource, "xpath").getDisplayedOne().isSelected() == false) {
				this.page.element(mappedResource, "xpath").getDisplayedOne().sendKeys(Keys.ENTER);
			}
			if (this.page.element(mappedResource, "xpath").getDisplayedOne().isSelected() == false) {
				this.page.element(mappedResource, "xpath").clickUsingJSE();
			}
			assertTrue(this.page.element(mappedResource, "xpath").getOne().isSelected());
		}
		return this;
	}

	public UsersList createUserWithUpdateRightOnResource(
			String username, String Password, String fullName, String email,
			String pager, String resourceName) throws Exception {
		this.clickOnCreateNewUser();
		this.enterUserMandatoryDetails(username, Password, fullName);
		this.enterPrimaryEmailId(email);
		this.entertextPagerId(pager);
		this.enterSecondaryEmailId(email);
		this.selectFirstRole();
		this.selectViewResourceCheckBox(resourceName);
		this.selectUpdateStatusOfResource(resourceName);
		return this;
	}

	public UsersList verifyUserInUsersList(String userName) throws Exception {
		this.searchUserName(userName);
		waitForElement.waitForElements(Locators.USERSTABLE + userName + Locators.CLOSEBRACKETS, "xpath");
		assertTrue(this.page.element(Locators.USERSTABLE + userName + Locators.CLOSEBRACKETS, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.USERSTABLE + userName + Locators.CLOSEBRACKETS, "xpath").getDisplayedOne().isDisplayed());
		return this;
	}

	public UsersList createUserWithUpdateRightOnResourceAndSave(
			String username, String Password, String fullName, String email,
			String pager, String resourceName) throws Exception {
		this.clickOnCreateNewUser();
		this.enterUserMandatoryDetails(username, Password, fullName);
		this.enterPrimaryEmailId(email);
		this.enterSecondaryEmailId(email);
		this.entertextPagerId(pager);
		this.selectFirstRole();
		this.selectViewResourceCheckBox(resourceName);
		this.selectUpdateStatusOfResource(resourceName);
		this.clickOnSave();
		return this;
	}

	public UsersList clickOnEventNotificationPrefrences() throws Exception {
		waitForElement.waitForElements(Locators.EVENT_NOTIFICATION_PREFERENCES, "xpath");
		this.page.element(Locators.EVENT_NOTIFICATION_PREFERENCES, "xpath").clickUsingJSE();
		return this;
	}

	public UsersList verifyEventNotificationPrefrencesForUser(String userName) throws Exception {
		waitForElement.waitForElements(Locators.EVENT_NOTIFICATION_PREFERENCES_FOR_USER + userName +Locators.CLOSEBRACKETS, "xpath");
		assertTrue(this.page.element(Locators.EVENT_NOTIFICATION_PREFERENCES_FOR_USER + userName +Locators.CLOSEBRACKETS, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.EVENT_NOTIFICATION_PREFERENCES_FOR_USER + userName +Locators.CLOSEBRACKETS, "xpath").getOne().isDisplayed());
		return this;
	}

	public UsersList enableUserToReceiveMyResourcesOnlyEmailForEventNotification(ArrayList<String> userName, String eventTemplate) throws Exception {
		for (String username : userName) {
			this.searchUserName(username);
			this.clickOnEdit(username);
			this.clickOnEventNotificationPrefrences();
			this.verifyEventNotificationPrefrencesForUser(username);
			navigateTo.selectMyResourcesOnlyEmailNotificationMethod(eventTemplate)
			.users();
		}
		return this;
	}

	public UsersList createUserWithUpdateRightOnSigleResource(
			String username, String Password, String fullName, String email,
			String pager, String resourceName) throws Exception {
		this.clickOnCreateNewUser();
		this.enterUserMandatoryDetails(username, Password, fullName);
		this.enterPrimaryEmailId(email);
		this.entertextPagerId(pager);
		this.selectFirstRole();
		this.selectViewResourceCheckBox(resourceName);
		this.selectUpdateStatusOfResource(resourceName);
		return this;
	}

	public UsersList createUserWithUpdateRightOnSigleResourceMantainEventRightCustomViewRightAndSave(
			String username, String Password, String fullName, String email,
			String pager, String resourceName) throws Exception {
		this.clickOnCreateNewUser();
		this.enterUserMandatoryDetails(username, Password, fullName);
		this.enterPrimaryEmailId(email);
		this.entertextPagerId(pager);
		this.selectFirstRole();
		this.selectViewResourceCheckBox(resourceName);
		this.selectUpdateStatusOfResource(resourceName);
		this.provideViewCustomViewRight();
		this.provideMaintainEventsRightAndSave();
		return this;
	}

	public UsersList provideConfigureRegionalUserAccessMainTainEventAndMaintainEventTemplateRights() throws Exception {
		this.provideMaintainEventsRight();
		this.selectMaintainEventTemplateRight();
		this.selectConfigureRegionalUserAccessOption();
		this.clickOnSave();
		return this;
	}

	public UsersList editUserAndProvideMultiRegionEventsRight(String username, ArrayList<String> regionValues) throws Exception {
		this.searchUserName(username);
		this.clickOnEdit(username);
		this.clickOnMultiRegionEventRightsLink();
		for(int intCount=0; intCount<regionValues.size(); intCount++){
			this.selectRegionsUnderEditMultiRegionEventRightsPage(regionValues.get(intCount));
		}

		this.clickOnSave();
		this.verifyEditUsersScreen();
		this.clickOnSave();
		this.verifyUsersListPage();
		return this;
	}

	public UsersList deSelectMaintainEventTemplateRight() throws Exception {
		waitForElement.waitForElements(Locators.MAINTAIN_EVENT_TEMPLATE_RIGHT, "css");
		if(this.page.element(Locators.MAINTAIN_EVENT_TEMPLATE_RIGHT, "css").getOne().isSelected()){
			this.page.element(Locators.MAINTAIN_EVENT_TEMPLATE_RIGHT, "css").getOne().click();
		}
		try{
			assertFalse(this.page.element(Locators.MAINTAIN_EVENT_TEMPLATE_RIGHT, "css").getOne().isSelected(), "Maintain EventTemplate Right is not deselected.");
		}catch(Exception e) {
			if(this.page.element(Locators.MAINTAIN_EVENT_TEMPLATE_RIGHT, "css").getOne().isSelected()){
				this.page.element(Locators.MAINTAIN_EVENT_TEMPLATE_RIGHT, "css").getOne().sendKeys(Keys.SPACE);
			}
		}
		assertFalse(this.page.element(Locators.MAINTAIN_EVENT_TEMPLATE_RIGHT, "css").getOne().isSelected(), "Maintain EventTemplate Right is not deselected.");
		return this;
	}

	public UsersList deselectMaintainEventTemplatesRightAndSave(String username) throws Exception {
		this.searchUser(username);
		this.clickOnAdvancedOptionAndExpand();
		this.deSelectMaintainEventTemplateRight();
		this.clickOnSave();
		return this;
	}

	public UsersList enableUserToReceiveAllEventNotification(ArrayList<String> userName, String eventTemplate) throws Exception {
		for (String username : userName) {
			this.searchUserName(username);
			this.clickOnEdit(username);
			this.clickOnEventNotificationPrefrences();
			this.verifyEventNotificationPrefrencesForUser(username);
			navigateTo.selectAllNotificationMethod(eventTemplate)
			.users();
		}
		return this;
	}

	public UsersList enableUserToReceivePagerAndWebEventNotification(ArrayList<String> userName, String eventTemplate) throws Exception {
		for (String username : userName) {
			this.searchUserName(username);
			this.clickOnEdit(username);
			this.clickOnEventNotificationPrefrences();
			this.verifyEventNotificationPrefrencesForUser(username);
			navigateTo.selectTextPagerAndWebNotificationMethod(eventTemplate)
			.users();
		}
		return this;
	}

	public UsersList editUserSelectUpdateRightOnResource(String username, String resourceName) throws Exception {
		this.searchUserName(username);
		this.clickOnEdit(username);
		this.selectUpdateStatusOfResource(resourceName);
		this.clickOnSave();
		this.verifyUsersListPage();
		return this;
	}

	public UsersList provideSetUpStatusTypesRightAndSave() throws Exception {
		this.provideSetUpStatusTypesRight();
		this.clickOnSave();
		return this;	
	}

	public UsersList deSelectAdhocEventRight() throws Exception {
		waitForElement.waitForElements(Locators.EVENT_MAINTAIN_AD_HOC_EVENT, "css");
		if(this.page.element(Locators.EVENT_MAINTAIN_AD_HOC_EVENT, "css").getOne().isSelected()){
			this.page.element(Locators.EVENT_MAINTAIN_AD_HOC_EVENT, "css").getOne().click();
		}
		try{
			assertFalse(this.page.element(Locators.EVENT_MAINTAIN_AD_HOC_EVENT, "css").getOne().isSelected(), "Adhoc Event Right is not deselected.");
		}catch(Exception e) {
			if(this.page.element(Locators.EVENT_MAINTAIN_AD_HOC_EVENT, "css").getOne().isSelected()){
				this.page.element(Locators.EVENT_MAINTAIN_AD_HOC_EVENT, "css").getOne().sendKeys(Keys.SPACE);
			}
		}
		assertFalse(this.page.element(Locators.EVENT_MAINTAIN_AD_HOC_EVENT, "css").getOne().isSelected(), "Adhoc Event Right is not deselected.");
		return this;
	}

	public UsersList deselectMainatinAdhocEventRightAndSave() throws Exception{
		this.clickOnAdvancedOptionAndExpand();
		this.deSelectAdhocEventRight();
		this.clickOnSave();
		return this;
	}

	public UsersList selectRoleCriteria(String role) throws Exception{
		waitForElement.waitForElements(Locators.SEARCH_OPTIONS_ROLE, "id");
		this.page.element(Locators.SEARCH_OPTIONS_ROLE, "id").webElementToSelect().selectByVisibleText(role);
		waitForElement.waitForPageLoad();
		assertEquals(this.page.element(Locators.SEARCH_OPTIONS_ROLE, "id").webElementToSelect().getFirstSelectedOption().getText(), role);
		return this;
	}

	public UsersList selectResourceTypeCriteria(String resourceType) throws Exception{
		waitForElement.waitForElements(Locators.SEARCH_OPTIONS_RESOURCE_TYPE, "id");
		this.page.element(Locators.SEARCH_OPTIONS_RESOURCE_TYPE, "id").webElementToSelect().selectByVisibleText(resourceType);
		waitForElement.waitForPageLoad();
		assertEquals(this.page.element(Locators.SEARCH_OPTIONS_RESOURCE_TYPE, "id").webElementToSelect().getFirstSelectedOption().getText(), resourceType);
		return this;
	}

	public UsersList selectUserNameCriteria(String searchWhat) throws Exception{
		waitForElement.waitForElements(Locators.SEARCH_OPTIONS_SEARCH_FIELD, "id");
		this.page.element(Locators.SEARCH_OPTIONS_SEARCH_FIELD, "id").webElementToSelect().selectByVisibleText(searchWhat);
		waitForElement.waitForPageLoad();
		assertEquals(this.page.element(Locators.SEARCH_OPTIONS_SEARCH_FIELD, "id").webElementToSelect().getFirstSelectedOption().getText(), searchWhat);
		return this;
	}

	public UsersList selectSearchCriteria(String searchType) throws Exception{
		waitForElement.waitForElements(Locators.SEARCH_OPTIONS_CONDITION, "id");
		this.page.element(Locators.SEARCH_OPTIONS_CONDITION, "id").webElementToSelect().selectByVisibleText(searchType);
		waitForElement.waitForPageLoad();
		assertEquals(this.page.element(Locators.SEARCH_OPTIONS_CONDITION, "id").webElementToSelect().getFirstSelectedOption().getText(), searchType);
		return this;
	}

	public UsersList searchUser(String role, String resourceType, String searchWhat, String searchCondition, String searchString) throws Exception{
		this.enterUsernameInSearchInputField(searchString);
		this.selectRoleCriteria(role);
		this.selectResourceTypeCriteria(resourceType);
		this.selectUserNameCriteria(searchWhat);
		this.selectSearchCriteria(searchCondition);
		this.clickSearchButton();
		return this;
	}

	public UsersList switchToUserAsAdmin(String username) throws Exception{
		waitForElement.waitForElements(Locators.TABLE_CELL_WITH_TEXT + username + Locators.SWITCH_PART2, "xpath");
		this.page.element(Locators.TABLE_CELL_WITH_TEXT + username + Locators.SWITCH_PART2, "xpath").getDisplayedOne().click();
		try{
			if(!this.page.element(Locators.RETURN_TO_SELF, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE)) {
				this.page.element(Locators.TABLE_CELL_WITH_TEXT + username + Locators.SWITCH_PART2, "xpath").clickUsingJSE();
			}
			if(!this.page.element(Locators.RETURN_TO_SELF, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE)) {
				this.page.element(Locators.TABLE_CELL_WITH_TEXT + username + Locators.SWITCH_PART2, "xpath").getDisplayedOne().sendKeys(Keys.ENTER);
			}
			assertTrue(this.page.element(Locators.RETURN_TO_SELF, "xpath").isElementPresent(), Locators.RETURN_TO_SELF + " is not displayed.");
		} catch(Exception e) {

		}
		return this;
	}

	public UsersList returnToSelf() throws Exception{
		waitForElement.waitForElements(Locators.RETURN_TO_SELF, "xpath");
		this.page.element(Locators.RETURN_TO_SELF, "xpath").getDisplayedOne().click();
		Boolean until = wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//li/a[text()='Return to Self']"), "Return to Self"));
		assertTrue(until);
		return this;
	}

	public UsersList provideAccessToRegionsForUser(ArrayList<String> regionValues) throws Exception {
		Iterator<String> iterator = regionValues.iterator();
		while(iterator.hasNext()) {
			String next = iterator.next();
			String element = Locators.USER_REGIONS + next + Locators.CLOSEBRACKETS;
			waitForElement.waitForElements(element, "css");
			if(!this.page.element(element, "css").getOne().isSelected()) {
				this.page.element(element, "css").getOne().sendKeys(Keys.SPACE);
			}
			if(!this.page.element(element, "css").getOne().isSelected()) {
				this.page.element(element, "css").Click();
			}
			if(!this.page.element(element, "css").getOne().isSelected()) {
				this.page.element(element, "css").clickUsingJSE();
			}
			assertTrue(this.page.element(element, "css").getOne().isSelected());
		}
		return this;
	}

	public UsersList provideMultiRegionAccessToUser(String username, ArrayList<String> regionValues) throws Exception {
		this.clickOnRegionLinkOfUser(username);
		this.provideAccessToRegionsForUser(regionValues);
		this.clickOnSave();
		return this;
	}

	public UsersList removeAccessToRegionsForUser(String regionValue) throws Exception {
		String element = Locators.USER_REGIONS + regionValue + Locators.CLOSEBRACKETS;
		waitForElement.waitForElements(element, "css");
		if(this.page.element(element, "css").getOne().isSelected()) {
			this.page.element(element, "css").getOne().sendKeys(Keys.SPACE);
		}
		if(this.page.element(element, "css").getOne().isSelected()) {
			this.page.element(element, "css").Click();
		}
		if(this.page.element(element, "css").getOne().isSelected()) {
			this.page.element(element, "css").clickUsingJSE();
		}
		assertFalse(this.page.element(element, "css").getOne().isSelected());
		return this;
	}

	public UsersList removeMultiRegionAccessToUser(String username, String regionValue) throws Exception {
		this.clickOnRegionLinkOfUser(username);
		this.removeAccessToRegionsForUser(regionValue);
		this.clickOnSave();
		return this;
	}

	public UsersList deselectConfigureRegionalUserAccess() throws Exception {
		this.clickOnAdvancedOptionAndExpand();
		waitForElement.waitForElements(Locators.CONFIGUREREGIONALUSERACCESS, "css");
		if(this.page.element(Locators.CONFIGUREREGIONALUSERACCESS, "css").getOne().isSelected()){
			this.page.element(Locators.CONFIGUREREGIONALUSERACCESS, "css").getDisplayedOne().click();
		}
		try{
			assertFalse(this.page.element(Locators.CONFIGUREREGIONALUSERACCESS, "css").getOne().isSelected(), "Configure Regional User Access Right is not deselected.");
		}catch(Exception e) {
			if(this.page.element(Locators.CONFIGUREREGIONALUSERACCESS, "css").getOne().isSelected()){
				this.page.element(Locators.CONFIGUREREGIONALUSERACCESS, "css").getOne().sendKeys(Keys.SPACE);
			}
		}
		assertFalse(this.page.element(Locators.CONFIGUREREGIONALUSERACCESS, "css").getOne().isSelected(), "Configure Regional User Access Right is not deselected.");
		return this;
	}

	public UsersList provideMaintainEventAndMaintainEventTemplateRight() throws Exception {
		this.provideMaintainEventsRight();
		this.selectMaintainEventTemplateRight();
		this.clickOnSave();
		return this;	
	}

	public UsersList deselectAllRoles() throws Exception {
		List<WebElement> roles = this.page.element(Locators.ALL_ROLES, "xpath").get();
		Iterator<WebElement> iterator = roles.iterator();
		while(iterator.hasNext()) {
			WebElement next = iterator.next();
			if(next.isSelected()) {
				next.sendKeys(Keys.SPACE);
			}
			if(next.isSelected()) {
				Actions action = new Actions(this.driver);
				action.moveToElement(next).build().perform();
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", next);
			}
			assertFalse(next.isSelected(), next + " is selected.");
		}
		return this;	
	}

	public UsersList createUserWithMandatoryDetailsAndEMailPager(
			String username, String Password, String fullName, String email,
			String pager, String roleValue,String defaultRoleValue) throws Exception {
		this.clickOnCreateNewUser();
		this.enterUserMandatoryDetailsWithEMailAndPager(username, Password, fullName, email, pager);
		this.selectRole(roleValue);
		this.deselectDefaultRoleIfExistUnderRolesSection(defaultRoleValue);
		return this;
	}

	public UsersList deselectDefaultRoleIfExistUnderRolesSection(String _roleValue) throws Exception{
		try
		{
			String defaultRole = Locators.SELECTROLEPART1 + _roleValue + Locators.SLECTROLEPART2;
			if(this.page.element(defaultRole, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL)){
				if(this.page.element(defaultRole, "xpath").getOne().isSelected())
				{
					this.page.element(defaultRole, "xpath").mouseOver();
					this.page.element(defaultRole, "xpath").getDisplayedOne().click();
				}
				if(this.page.element(defaultRole, "xpath").getOne().isSelected())
				{	
					this.page.element(defaultRole, "xpath").mouseOver();
					this.page.element(defaultRole, "xpath").getOne().sendKeys(Keys.SPACE);
				}
				if(this.page.element(defaultRole, "xpath").getOne().isSelected())
				{	
					this.page.element(defaultRole, "xpath").mouseOver();
					this.page.element(defaultRole, "xpath").clickUsingJSE();
				}
				assertFalse(this.page.element(defaultRole, "xpath").getOne().isSelected());
			}
		}
		catch(NoSuchElementException e)
		{
			System.out.println("No default role present while crating user");
		}
		return this;
	}

	public UsersList editUserAndGiveViewRightOnResource(String userName, String resourceName) throws Exception {
		this.searchUser(userName);
		this.selectViewResourceCheckBox(resourceName);
		this.clickOnSave();
		return this;
	}

	public UsersList editUserAndRemoveUpdateAndAssociateRightsOnResource(String userName, String resourceName) throws Exception {
		this.searchUser(userName);
		this.deselectUpdateResourceRightOfResource(resourceName);
		this.deselectAssociatedWithRightOfResource(resourceName);
		this.clickOnSave();
		return this;
	}
	
	public UsersList verifyRoleIsNotPresentInUserPage(ArrayList<String> roleValues) throws Exception{
		waitForElement.waitForElements(Locators.ROLE_VALUE_IN_TABLE+roleValues+Locators.CLOSEBRACKETS+Locators.ROLE_VALUE_IN_TABLE_PART1, "xpath");
		assertFalse(this.page.element(Locators.ROLE_VALUE_IN_TABLE+roleValues+Locators.CLOSEBRACKETS+Locators.ROLE_VALUE_IN_TABLE_PART1, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE), roleValues +"Role is displayed");
	return this;
	}
	
	public UsersList verifyRoleIsNotPresentInDropDown(ArrayList<String> roleValue) throws Exception{
		waitForElement.waitForElements(Locators.ROLE_IN_DROPDOWN + roleValue + Locators.CLOSEBRACKETS, "xpath");
		assertFalse(this.page.element(Locators.ROLE_IN_DROPDOWN + roleValue + Locators.CLOSEBRACKETS, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE), roleValue +"Role is dispalyed");
		return this;
	}
	
	public UsersList provideSetupResourceTypesRightAndSave() throws Exception {
		this.clickOnAdvancedOptionAndExpand();
		this.selectSetupResourceTypesRight();
		this.clickOnSave();
		return this;	
	}
	
	public UsersList createUserWithMandatoryDetailsWithoutSave(
			String username, String Password, String fullName, String email,
			String pager) throws Exception {
		this.clickOnCreateNewUser();
		this.enterUserMandatoryDetailsWithEMailAndPager(username, Password, fullName, email, pager);
		return this;
	}
	
	public UsersList selectInstantMessaging_InitiateChatSessionRight() throws Exception {
		waitForElement.waitForElements(Locators.INSTANT_MESSAGING_INTIATE_CHAT_SESSION, "css");
		if(this.page.element(Locators.INSTANT_MESSAGING_INTIATE_CHAT_SESSION, "css").getOne().isSelected()==false){
			this.page.element(Locators.INSTANT_MESSAGING_INTIATE_CHAT_SESSION, "css").getOne().click();
		}
		try{
			assertTrue(this.page.element(Locators.INSTANT_MESSAGING_INTIATE_CHAT_SESSION, "css").getOne().isSelected());
		}catch(Exception e) {
			if(this.page.element(Locators.INSTANT_MESSAGING_INTIATE_CHAT_SESSION, "css").getOne().isSelected()==false){
				this.page.element(Locators.INSTANT_MESSAGING_INTIATE_CHAT_SESSION, "css").getOne().sendKeys(Keys.SPACE);
			}
		}
		assertTrue(this.page.element(Locators.INSTANT_MESSAGING_INTIATE_CHAT_SESSION, "css").getOne().isSelected());
		return this;
	}
	
	public UsersList verifyAllTheRightsAreSelectedCorrespondingToResource(String resourceName,String userName) throws Exception {
		this.clickOnEdit(userName);
		this.verifyViewResourceRigtIsSelectedCorrespondingToResource(resourceName);
		this.verifyUpdateStatusRigtIsSelectedCorrespondingToResource(resourceName);
		this.verifyRunReportsRigtIsSelectedCorrespondingToResource(resourceName);
		this.verifyAssociatedWithRigtIsSelectedCorrespondingToResource(resourceName);
		this.clickOnSave();
		return this;
	}
	
	public UsersList verifyViewResourceRigtIsSelectedCorrespondingToResource(String resourceName) throws Exception {
		String viewResourceRightElement = Locators.RESOURCELISTPART1 + resourceName + Locators.VIEWRIGHT;
		waitForElement.waitForElements(viewResourceRightElement, "xpath");
		assertTrue(this.page.element(viewResourceRightElement, "xpath").getOne().isSelected(),viewResourceRightElement + "is not selected" );
		return this;
	}	
	
	public UsersList verifyUpdateStatusRigtIsSelectedCorrespondingToResource(String resourceName) throws Exception {
		String updateStatusRigtElement = Locators.RESOURCELISTPART1 + resourceName + Locators.UPDATERIGHT;
		waitForElement.waitForElements(updateStatusRigtElement, "xpath");
		assertTrue(this.page.element(updateStatusRigtElement, "xpath").getOne().isSelected(),updateStatusRigtElement + "is not selected" );
		return this;
	}
	
	public UsersList verifyRunReportsRigtIsSelectedCorrespondingToResource(String resourceName) throws Exception {
		String runReportsRigtElement = Locators.RESOURCELISTPART1 + resourceName + Locators.RUN_REPORT_RIGHT;
		waitForElement.waitForElements(runReportsRigtElement, "xpath");
		assertTrue(this.page.element(runReportsRigtElement, "xpath").getOne().isSelected(),runReportsRigtElement + "is not selected" );
		return this;
	}
	
	public UsersList verifyAssociatedWithRigtIsSelectedCorrespondingToResource(String resourceName) throws Exception {
		String associatedWithRigtElement = Locators.RESOURCELISTPART1 + resourceName + Locators.ASSOCIATE_RIGHT;
		waitForElement.waitForElements(associatedWithRigtElement, "xpath");
		assertTrue(this.page.element(associatedWithRigtElement, "xpath").getOne().isSelected(),associatedWithRigtElement + "is not selected" );
		return this;
	}
	
	public UsersList selectStatusSummuryRight() throws Exception {
		waitForElement.waitForElements(Locators.REPORT_STATUS_SUMMARY, "css");
		if(this.page.element(Locators.REPORT_STATUS_SUMMARY, "css").getOne().isSelected()==false){
			this.page.element(Locators.REPORT_STATUS_SUMMARY, "css").getOne().click();
		}
		try{
			assertTrue(this.page.element(Locators.REPORT_STATUS_SUMMARY, "css").getOne().isSelected());
		}catch(Exception e) {
			if(this.page.element(Locators.REPORT_STATUS_SUMMARY, "css").getOne().isSelected()==false){
				this.page.element(Locators.REPORT_STATUS_SUMMARY, "css").getOne().sendKeys(Keys.SPACE);
			}
		}
		assertTrue(this.page.element(Locators.REPORT_STATUS_SUMMARY, "css").getOne().isSelected());
		return this;
	}
	
	public UsersList verifyRoleIsSelected(String roleValue) throws Exception{
		waitForElement.waitForElements( Locators.SELECTROLEPART1 + roleValue + Locators.SLECTROLEPART2, "xpath");
		assertTrue(this.page.element( Locators.SELECTROLEPART1 + roleValue + Locators.SLECTROLEPART2, "xpath").getOne().isSelected(),roleValue+ "Role is not selected");
		return this;
	}
	
	public UsersList provideSetupResourcesEditOnlyRight() throws Exception {
		this.clickOnAdvancedOptionAndExpand();
		this.selectSetupResourcesEditOnlyRight();
		return this;
	}
	
	public UsersList provideSetupResourcesEditOnlyRightAndSave() throws Exception {
		this.provideSetupResourcesEditOnlyRight();
		this.clickOnSave();
		return this;
	}
	
	public UsersList provideSetupStatusReasonsRightAndSave() throws Exception {
		this.provideStatusReasonRight();
		this.clickOnSave();
		return this;
	}
}