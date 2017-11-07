package EMR.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import qaFramework.WaitTimeConstants;
import qaFramework.UserDefinedFunctions.WaitForElement;
import qaFramework.pageObject.PageObject;
import EMR.Locators.Views;
import EMR.Locators.Views.Locators;

public class View extends PageObject {

	WebDriver driver;
	WaitForElement waitForElement ;
	Login login;
	Shared navigateTo;

	public View(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		waitForElement = new WaitForElement(this.driver);
		navigateTo= new Shared(this.driver);
	}

	public View clickOnIndividualUpdateStatus(String statusTypeName) throws Exception {
		waitForElement.waitForElements(Locators.ANCHOR_TAG_WITH_TEXT +statusTypeName+ Locators.CLOSINGBRACKET + Locators.UPDATE_STATUS_UNDER_VIEW_RESOURCE_DETAIL, "xpath");
		assertTrue(this.page.element(Locators.ANCHOR_TAG_WITH_TEXT +statusTypeName+ Locators.CLOSINGBRACKET + Locators.UPDATE_STATUS_UNDER_VIEW_RESOURCE_DETAIL, "xpath").isElementPresent());
		this.page.element(Locators.ANCHOR_TAG_WITH_TEXT +statusTypeName+ Locators.CLOSINGBRACKET + Locators.UPDATE_STATUS_UNDER_VIEW_RESOURCE_DETAIL, "xpath").getOne().click();
		return this;
	}

	public View verifyUpdatedValueOfStatusType(String statusTypeName, String statusTypeValue) throws Exception {
		waitForElement.waitForElements(Locators.ANCHOR_TAG_WITH_TEXT +statusTypeName+ Locators.CLOSINGBRACKET + Locators.UPDATE_STATUS_UNDER_VIEW_RESOURCE_DETAIL, "xpath");
		assertTrue(this.page.element(Locators.ANCHOR_TAG_WITH_TEXT +statusTypeName+ Locators.CLOSINGBRACKET + Locators.UPDATE_STATUS_UNDER_VIEW_RESOURCE_DETAIL, "xpath").getOne().getText().equals(statusTypeValue));
		return this;
	}

	public View verifyResourceTypeAndResource(String _resourceType, String _resource) throws Exception {
		waitForElement.waitForElements(Locators.RESOURCETYPE_AND_STATUSTYPE_PART1  + _resourceType+ Locators.RESOURCETYPE_AND_RESOURCE_PART2 + _resource + Locators.CLOSINGBRACKET, "xpath");
		assertTrue(this.page.element(Locators.RESOURCETYPE_AND_STATUSTYPE_PART1  + _resourceType+ Locators.RESOURCETYPE_AND_RESOURCE_PART2 + _resource + Locators.CLOSINGBRACKET, "xpath").isElementPresent());
		System.out.println("resource present");
		return this;
	}

	public View verifyResourceTypeAndStatusType(String _resourceType, String _statusType[]) throws Exception {
		waitForElement.waitForElements(Locators.RESOURCETYPE_AND_STATUSTYPE_PART1 + _resourceType + Locators.CLOSINGBRACKET, "xpath");
		for(int intCount=0; intCount<_statusType.length; intCount++){
			String element= Locators.RESOURCETYPE_AND_STATUSTYPE_PART1 + _resourceType + Locators.RESOURCETYPE_AND_STATUSTYPE_PART2 +_statusType[intCount] + Locators.CLOSINGBRACKET;
			assertTrue(this.page.element(element, "xpath").isElementPresent(), element+"was not present");
		}
		return this;
	}

	public View verifyCommentColumnIsPresent(String resourceTypeValue) throws Exception {
		waitForElement.waitForElements(Locators.VIEW_TABLE_PART1 + resourceTypeValue + Locators.COMMENT_COLUMN , "xpath");
		assertTrue(this.page.element(Locators.VIEW_TABLE_PART1 + resourceTypeValue + Locators.COMMENT_COLUMN , "xpath").getOne().isDisplayed());
		return this;
	}

	public View verifyLastUpdateColumnIsPresent(String resourceTypeValue) throws Exception {
		waitForElement.waitForElements(Locators.VIEW_TABLE_PART1 + resourceTypeValue + Locators.LAST_UPDATE_COLUMN , "xpath");
		assertTrue(this.page.element(Locators.VIEW_TABLE_PART1 + resourceTypeValue + Locators.LAST_UPDATE_COLUMN , "xpath").getOne().isDisplayed());
		return this;
	}//find xpath

	public View verifyByUserColumnIsPresent(String resourceTypeValue) throws Exception {
		waitForElement.waitForElements(Locators.VIEW_TABLE_PART1 + resourceTypeValue + Locators.BY_USER_COLUMN , "xpath");
		assertTrue(this.page.element(Locators.VIEW_TABLE_PART1 + resourceTypeValue + Locators.BY_USER_COLUMN , "xpath").getOne().isDisplayed());
		return this;
	}//find xpath

	public View verifyStatusTypesColumnIsPresent(String resourceTypeValue, String[] StatusTypeNames) throws Exception {
		waitForElement.waitForElements(Locators.VIEW_TABLE_PART1 + resourceTypeValue + Locators.STATUSTYPE_COLUMN + StatusTypeNames + Locators.CLOSINGBRACKET, "xpath");
		for(int numberOfSTs = 0; numberOfSTs < StatusTypeNames.length; numberOfSTs++){
			//    		assertTrue(this.page.element(Locators.VIEWTABLEPART1 + resourceTypeValue + Locators.STATUSTYPE_COLUMN + StatusTypeNames[numberOfSTs] + Locators.CLOSINGBRACKET, "xpath").isElementPresent());
			assertTrue(this.page.element(Locators.VIEW_TABLE_PART1 + resourceTypeValue + Locators.STATUSTYPE_COLUMN + StatusTypeNames[numberOfSTs] + Locators.CLOSINGBRACKET, "xpath").getOne().isDisplayed());
		}		
		return this;
	}

	public View clickOnSetupCustomViewLink() throws Exception {
		waitForElement.waitForElements(Locators.SETUP_CUSTOM_VIEW_LINK, "linktext");
		this.page.element(Locators.SETUP_CUSTOM_VIEW_LINK, "linktext").clickUsingJSE();
		return this;
	}

	public View clickOnAddMoreResourcesLink() throws Exception {
		waitForElement.waitForElements(Locators.ADD_MORE_RESOURCES, "css");
		this.page.element(Locators.ADD_MORE_RESOURCES, "css").clickUsingJSE();
		waitForElement.waitForElements(Locators.FIND_RESOURCES_PAGE, "xpath");
		return this;
	}

	public View enterResourceNameInWhatSearchField(String resourceName) throws Exception {
		waitForElement.waitForElements(Locators.SEARCH_IN_FIND_RESOURCES, "id");
		this.page.element(Locators.SEARCH_IN_FIND_RESOURCES, "id").clearInputValue().sendKeys(resourceName);
		assertTrue(this.page.element(Locators.SEARCH_IN_FIND_RESOURCES, "id").getOne().getAttribute("value").equals(resourceName));
		return this;
	}

	public View clickOnSearch() throws Exception {
		waitForElement.waitForElements(Locators.SEARCH_BUTTON, "css");
		this.page.element(Locators.SEARCH_BUTTON, "css").clickUsingJSE();
		return this;
	}

	public View selectResource(String[] resourceValue)
			throws Exception {
		for (int i = 0; i < resourceValue.length; i++) {
			waitForElement.waitForElements(Locators.RESOURCE_CHECKBOX_IN_FIND_RESOURCE_PART1 + resourceValue[i] + Locators.CLOSINGBRACKET, "xpath");
			try{
				this.page.element(Locators.RESOURCE_CHECKBOX_IN_FIND_RESOURCE_PART1 + resourceValue[i] + Locators.CLOSINGBRACKET, "xpath").getOne().click();
				assertTrue(this.page.element(Locators.RESOURCE_CHECKBOX_IN_FIND_RESOURCE_PART1 + resourceValue[i] + Locators.CLOSINGBRACKET, "xpath").getOne().isSelected());
			}catch(Exception e){
				this.page.element(Locators.RESOURCE_CHECKBOX_IN_FIND_RESOURCE_PART1 + resourceValue[i] + Locators.CLOSINGBRACKET, "xpath").getOne().sendKeys(Keys.SPACE);
				assertTrue(this.page.element(Locators.RESOURCE_CHECKBOX_IN_FIND_RESOURCE_PART1 + resourceValue[i] + Locators.CLOSINGBRACKET, "xpath").getOne().isSelected());
			}
		}
		return this;
	}

	public View clickOnAddToCustomView() throws Exception {
		waitForElement.waitForElements(Locators.ADD_TO_CUSTOM_VIEW, "css");
		this.page.element(Locators.ADD_TO_CUSTOM_VIEW, "css").clickUsingJSE();
		//waitForElement.waitForElements(Locators.EDIT_CUSTOM_VIEW_OPTIONS_PAGE, "xpath");
		return this;
	}

	public View clickOnOptions() throws Exception {
		waitForElement.waitForElements(Locators.OPTIONS_BUTTON, "css");
		this.page.element(Locators.OPTIONS_BUTTON, "css").clickUsingJSE();
		waitForElement.waitForElements(Locators.EDIT_CUSTOM_VIEW_OPTIONS_PAGE, "xpath");
		return this;
	}

	public View selectAllCheckkBoxInOptions() throws Exception {
		waitForElement.waitForElements(Locators.DISPLAY_COMMENTS_CHECKBOX, "name");
		if(this.page.element(Locators.DISPLAY_COMMENTS_CHECKBOX, "name").getOne().isSelected() == false){
			this.page.element(Locators.DISPLAY_COMMENTS_CHECKBOX, "name").clickUsingJSE();
		}
		if(this.page.element(Locators.DISPLAY_COMMENTS_CHECKBOX, "name").getOne().isSelected() == false){
			this.page.element(Locators.DISPLAY_COMMENTS_CHECKBOX, "name").getOne().sendKeys(Keys.SPACE);
		}
		assertTrue(this.page.element(Locators.DISPLAY_COMMENTS_CHECKBOX, "name").getOne().isSelected());
		if(this.page.element(Locators.DISPLAY_LAST_UPDATED_TIME, "name").getOne().isSelected() == false){
			this.page.element(Locators.DISPLAY_LAST_UPDATED_TIME, "name").clickUsingJSE();
		}
		if(this.page.element(Locators.DISPLAY_LAST_UPDATED_TIME, "name").getOne().isSelected() == false){
			this.page.element(Locators.DISPLAY_LAST_UPDATED_TIME, "name").getOne().sendKeys(Keys.SPACE);
		}
		assertTrue(this.page.element(Locators.DISPLAY_LAST_UPDATED_TIME, "name").getOne().isSelected());
		if(this.page.element(Locators.DISPLAY_LAST_UPDATED_USER, "name").getOne().isSelected() == false){
			this.page.element(Locators.DISPLAY_LAST_UPDATED_USER, "name").clickUsingJSE();
		}
		if(this.page.element(Locators.DISPLAY_LAST_UPDATED_USER, "name").getOne().isSelected() == false){
			this.page.element(Locators.DISPLAY_LAST_UPDATED_USER, "name").getOne().sendKeys(Keys.SPACE);
		}
		assertTrue(this.page.element(Locators.DISPLAY_LAST_UPDATED_USER, "name").getOne().isSelected());
		if(this.page.element(Locators.SHOW_SUMMARY, "name").getOne().isSelected() == false){
			this.page.element(Locators.SHOW_SUMMARY, "name").clickUsingJSE();
		}
		if(this.page.element(Locators.SHOW_SUMMARY, "name").getOne().isSelected() == false){
			this.page.element(Locators.SHOW_SUMMARY, "name").getOne().sendKeys(Keys.SPACE);
		}
		assertTrue(this.page.element(Locators.SHOW_SUMMARY, "name").getOne().isSelected());
		return this;
	}

	public View selectStatusTypesInEditCustomViewOptions(String[] strStatusTypesVal)
			throws Exception {
		for (int i = 0; i < strStatusTypesVal.length; i++) {
			waitForElement.waitForElements(Locators.STATUS_TYPES_CHECKBOX_IN_EDIT_CUSTUM_VIEW_OPTIONS_PART1 + strStatusTypesVal[i] + Locators.CLOSINGBRACKET, "xpath");
			if(this.page.element(Locators.STATUS_TYPES_CHECKBOX_IN_EDIT_CUSTUM_VIEW_OPTIONS_PART1 + strStatusTypesVal[i] + Locators.CLOSINGBRACKET, "xpath").getOne().isSelected() == false){
				this.page.element(Locators.STATUS_TYPES_CHECKBOX_IN_EDIT_CUSTUM_VIEW_OPTIONS_PART1 + strStatusTypesVal[i] + Locators.CLOSINGBRACKET, "xpath").getOne().sendKeys(Keys.SPACE);
			}
			if(this.page.element(Locators.STATUS_TYPES_CHECKBOX_IN_EDIT_CUSTUM_VIEW_OPTIONS_PART1 + strStatusTypesVal[i] + Locators.CLOSINGBRACKET, "xpath").getOne().isSelected() == false){
				this.page.element(Locators.STATUS_TYPES_CHECKBOX_IN_EDIT_CUSTUM_VIEW_OPTIONS_PART1 + strStatusTypesVal[i] + Locators.CLOSINGBRACKET, "xpath").clickUsingJSE();
				assertTrue(this.page.element(Locators.STATUS_TYPES_CHECKBOX_IN_EDIT_CUSTUM_VIEW_OPTIONS_PART1 + strStatusTypesVal[i] + Locators.CLOSINGBRACKET, "xpath").getOne().isSelected());
			}
		}
		return this;
	}

	public View clickOnSave() throws Exception {
		waitForElement.waitForElements(Locators.SAVE_BUTTON, "css");
		this.page.element(Locators.SAVE_BUTTON, "css").clickUsingJSE();
		Thread.sleep(2000);
		return this;
	}

	public View verifyEditCustomViewPage() throws Exception {
		waitForElement.waitForElements(Locators.EDIT_CUSTOM_VIEW_PAGE, "xpath");
		assertTrue(this.page.element(Locators.EDIT_CUSTOM_VIEW_PAGE, "xpath").isElementPresent(), "Edit Custom View page is not displayed");
		return this;
	}

	public View createCustomView(String resourceName, String[] resourceValue, String[] statusTypesValues) throws Exception {
		this.clickOnSetupCustomViewLink();
		this.verifyEditCustomViewPage();
		this.clickOnAddMoreResourcesLink();
		this.enterResourceNameInWhatSearchField(resourceName);
		this.clickOnSearch();
		this.selectResource(resourceValue);
		this.clickOnAddToCustomView();
		this.clickOnOptions();
		this.selectStatusTypesInEditCustomViewOptions(statusTypesValues);
		this.selectAllCheckkBoxInOptions();
		this.clickOnSave();
		return this;
	}

	public View deSelectAllCheckkBoxInOptions() throws Exception {
		waitForElement.waitForElements(Locators.DISPLAY_COMMENTS_CHECKBOX, "name");
		if(this.page.element(Locators.DISPLAY_COMMENTS_CHECKBOX, "name").getOne().isSelected() == true){
			this.page.element(Locators.DISPLAY_COMMENTS_CHECKBOX, "name").getOne().sendKeys(Keys.SPACE);
			assertFalse(this.page.element(Locators.DISPLAY_COMMENTS_CHECKBOX, "name").getOne().isSelected());
		}
		if(this.page.element(Locators.DISPLAY_LAST_UPDATED_TIME, "name").getOne().isSelected() == true){
			this.page.element(Locators.DISPLAY_LAST_UPDATED_TIME, "name").getOne().sendKeys(Keys.SPACE);
			assertFalse(this.page.element(Locators.DISPLAY_LAST_UPDATED_TIME, "name").getOne().isSelected());
		}
		if(this.page.element(Locators.DISPLAY_LAST_UPDATED_USER, "name").getOne().isSelected() == true){
			this.page.element(Locators.DISPLAY_LAST_UPDATED_USER, "name").getOne().sendKeys(Keys.SPACE);
			assertFalse(this.page.element(Locators.DISPLAY_LAST_UPDATED_USER, "name").getOne().isSelected());
		}
		if(this.page.element(Locators.SHOW_SUMMARY, "name").getOne().isSelected() == true){
			this.page.element(Locators.SHOW_SUMMARY, "name").getOne().sendKeys(Keys.SPACE);
			assertFalse(this.page.element(Locators.SHOW_SUMMARY, "name").getOne().isSelected());
		}
		return this;
	}

	public View deSelectStatusTypesInEditCustomViewOptions(String[] statusTypesValues)
			throws Exception {
		for (int i = 0; i < statusTypesValues.length; i++) {
			waitForElement.waitForElements(Locators.STATUS_TYPES_CHECKBOX_IN_EDIT_CUSTUM_VIEW_OPTIONS_PART1 + statusTypesValues[i] + Locators.CLOSINGBRACKET, "xpath");
			if(this.page.element(Locators.STATUS_TYPES_CHECKBOX_IN_EDIT_CUSTUM_VIEW_OPTIONS_PART1 + statusTypesValues[i] + Locators.CLOSINGBRACKET, "xpath").getOne().isSelected() == true){
				this.page.element(Locators.STATUS_TYPES_CHECKBOX_IN_EDIT_CUSTUM_VIEW_OPTIONS_PART1 + statusTypesValues[i] + Locators.CLOSINGBRACKET, "xpath").getOne().sendKeys(Keys.SPACE);
				assertFalse(this.page.element(Locators.STATUS_TYPES_CHECKBOX_IN_EDIT_CUSTUM_VIEW_OPTIONS_PART1 + statusTypesValues[i] + Locators.CLOSINGBRACKET, "xpath").getOne().isSelected());
			}
		}
		return this;
	}

	public View createCustomViewByDeletingExistingCustomView(String resourceName, String[] resourceValue, String[] statusTypesValues,String _resourceType) throws Exception {

		String resource= Locators.RESOURCE_TYPE_AND_RESOURCE_IN_CUSTOM_VIEW_TABLE_PART1  + _resourceType+ Locators.RESOURCE_TYPE_AND_RESOURCE_IN_CUSTOM_VIEW_TABLE_PART2 + resourceName + Locators.CLOSINGBRACKET;

		if(this.page.element(resource, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_TOO_SMALL))
		{   
			navigateTo.clickOnCustomize();
			this.clickOnOptions();
			this.deSelectAllCheckkBoxInOptions();
			this.deSelectStatusTypesInEditCustomViewOptions(statusTypesValues);
			this.clickOnSave();
			this.verifyNoStatusesInCustomViewHeaderDisplayed();
			navigateTo.clickOnCustomize();
			this.verifyEditCustomViewPage();
			this.clickOnAddMoreResourcesLink();
			this.enterResourceNameInWhatSearchField(resourceName);
			this.clickOnSearch();
			this.selectResource(resourceValue);
			this.clickOnAddToCustomView();
			this.verifyEditCustomViewPage();
			this.clickOnOptions();
			this.selectStatusTypesInEditCustomViewOptions(statusTypesValues);
			this.selectAllCheckkBoxInOptions();
			this.clickOnSave();
		}
		else{
			if(this.page.element(Locators.SETUP_CUSTOM_VIEW_LINK, "linktext").isElementPresent(WaitTimeConstants.WAIT_TIME_TOO_SMALL)||this.page.element(Locators.SET_UP_CUSTOM_VIEW_LINK2, "linktext").isElementPresent(WaitTimeConstants.WAIT_TIME_TOO_SMALL))
				navigateTo.clickOnCustomize();
			this.verifyEditCustomViewPage();
			this.clickOnAddMoreResourcesLink();
			this.enterResourceNameInWhatSearchField(resourceName);
			this.clickOnSearch();
			this.selectResource(resourceValue);
			this.clickOnAddToCustomView();
			this.verifyEditCustomViewPage();
			this.clickOnOptions();
			this.selectStatusTypesInEditCustomViewOptions(statusTypesValues);
			this.selectAllCheckkBoxInOptions();
			this.clickOnSave();
		}
		assertTrue(this.page.element(resource, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_TOO_SMALL));
		return this;
	}

	public View verifyResourceTypeAndResourceNotDisplayed(String _resourceType, String _resource) throws Exception {
		assertFalse(this.page.element(Locators.RESOURCETYPE_AND_STATUSTYPE_PART1  + _resourceType+ Locators.RESOURCETYPE_AND_RESOURCE_PART2 + _resource + Locators.CLOSINGBRACKET, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}

	public View verifyResourceTypeAndStatusTypeNotDisplayed(String _resourceType, String _statusType[]) throws Exception {
		waitForElement.waitForElements(Locators.RESOURCETYPE_AND_STATUSTYPE_PART1 + _resourceType + Locators.CLOSINGBRACKET, "xpath");
		for(int intCount=0; intCount<_statusType.length; intCount++){
			String element = Locators.RESOURCETYPE_AND_STATUSTYPE_PART1 + _resourceType + Locators.RESOURCETYPE_AND_STATUSTYPE_PART2 +_statusType[intCount] + Locators.CLOSINGBRACKET;
			assertFalse(this.page.element(element, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE), element+" was present");
		}
		return this;
	}

	public View verifyResourceTypesAndStatusType(String _resourceType[], String _statusType[]) throws Exception {
		for(int intCount1=0; intCount1<_resourceType.length; intCount1++){
			waitForElement.waitForElements(Locators.RESOURCETYPE_AND_STATUSTYPE_PART1 + _resourceType[intCount1] + Locators.CLOSINGBRACKET, "xpath");
			for(int intCount=0; intCount<_statusType.length; intCount++){
				assertTrue(this.page.element(Locators.RESOURCETYPE_AND_STATUSTYPE_PART1 + _resourceType[intCount1] + Locators.RESOURCETYPE_AND_STATUSTYPE_PART2 +_statusType[intCount] + Locators.CLOSINGBRACKET, "xpath").isElementPresent());
			}
		}
		return this;
	}

	public View verifyResourceTypesAndResource(String _resourceType[], String _resource[]) throws Exception {
		for(int intCount1=0; intCount1<_resourceType.length; intCount1++){
			waitForElement.waitForElements(Locators.RESOURCETYPE_AND_STATUSTYPE_PART1 + _resourceType[intCount1] + Locators.CLOSINGBRACKET, "xpath");
			for(int intCount=0; intCount<_resource.length; intCount++){
				waitForElement.waitForElements(Locators.RESOURCETYPE_AND_STATUSTYPE_PART1  + _resourceType[intCount1]+ Locators.RESOURCETYPE_AND_RESOURCE_PART2 + _resource[intCount] + Locators.CLOSINGBRACKET, "xpath");
				assertTrue(this.page.element(Locators.RESOURCETYPE_AND_STATUSTYPE_PART1  + _resourceType[intCount1]+ Locators.RESOURCETYPE_AND_RESOURCE_PART2 + _resource[intCount] + Locators.CLOSINGBRACKET, "xpath").isElementPresent());
			}
		}
		return this;
	}

	public View verifyNoStatusesInCustomViewHeaderDisplayed() throws Exception {
		waitForElement.waitForElements(Locators.NO_STATUSES_IN_CUSTOM_VIEW_HEADER, "xpath");
		assertTrue(this.page.element(Locators.NO_STATUSES_IN_CUSTOM_VIEW_HEADER ,"xpath").isElementPresent());
		return this;
	}

	public View verifyCreateCustomViewLink() throws Exception {
		waitForElement.waitForElements(Locators.SETUP_CUSTOM_VIEW_LINK, "linktext");
		assertTrue(this.page.element(Locators.SETUP_CUSTOM_VIEW_LINK, "linktext").isElementPresent());
		return this;
	}

	public View verifyResourceTypeAndResourceUnderCustomView(String _resourceType, String _resource) throws Exception {
		String resourceAndResourceType= Locators.RESOURCE_TYPE_AND_RESOURCE_IN_CUSTOM_VIEW_TABLE_PART1  + _resourceType+ Locators.RESOURCE_TYPE_AND_RESOURCE_IN_CUSTOM_VIEW_TABLE_PART2 + _resource + Locators.CLOSINGBRACKET;
		waitForElement.waitForElements(resourceAndResourceType, "xpath");
		assertTrue(this.page.element(resourceAndResourceType, "xpath").isElementPresent());
		return this;
	}

	public View verifyResourceTypeAndStatusTypeUnderCustomView(String _resourceType, String _statusType[]) throws Exception {
		waitForElement.waitForElements(Locators.RESOURCETYPE_AND_STATUSTYPE_PART1 + _resourceType + Locators.CLOSINGBRACKET, "xpath");
		for(int intCount=0; intCount<_statusType.length; intCount++){
			String resourceTypeAndStatusTypes= Locators.RESOURCE_TYPE_AND_RESOURCE_IN_CUSTOM_VIEW_TABLE_PART1  + _resourceType+ Locators.STATUS_TYPES_UNDER_CUSTOM_VIEW + _statusType[intCount] + Locators.CLOSINGBRACKET;
			assertTrue(this.page.element(resourceTypeAndStatusTypes, "xpath").isElementPresent());
		}
		return this;
	}

	public View verifyCreatedCustomViewDetailes(String _resourceType, String _resource,String _statusType[]) throws Exception {
		this.verifyResourceTypeAndResourceUnderCustomView(_resourceType, _resource);
		this.verifyResourceTypeAndStatusTypeUnderCustomView(_resourceType, _statusType);
		return this;
	}

	public View verifyAddToCustomViewIsNotPresent() throws Exception {
		waitForElement.waitForElements(Locators.ADD_TO_CUSTOM_VIEW, "css");
		assertFalse(this.page.element(Locators.ADD_TO_CUSTOM_VIEW, "css").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE), "Add to Custom View button is displayed");
		return this;
	}

	public View verifyFindResourcesPage() throws Exception {
		waitForElement.waitForElements(Locators.FIND_RESOURCES_PAGE, "xpath");
		this.page.element(Locators.FIND_RESOURCES_PAGE, "xpath").isElementPresent();
		return this;
	}

	public View searchForResource(String resourceName) throws Exception {
		navigateTo.clickOnSearchInToolBar();
		this.verifyFindResourcesPage();
		this.enterResourceNameInWhatSearchField(resourceName);
		this.clickOnSearch();
		return this;
	}

	public View createCustomizedViewFromPreferences(String resourceName, String[] resourceValue, String[] statusTypesValues) throws Exception {
		navigateTo.customizedViewUnderPreferences();
		this.verifyEditCustomViewPage();
		this.clickOnAddMoreResourcesLink();
		this.enterResourceNameInWhatSearchField(resourceName);
		this.clickOnSearch();
		this.selectResource(resourceValue);
		this.clickOnAddToCustomView();
		this.verifyEditCustomViewPage();
		this.clickOnOptions();
		this.selectStatusTypesInEditCustomViewOptions(statusTypesValues);
		this.selectAllCheckkBoxInOptions();
		this.clickOnSave();
		return this;
	}

	public View verifyResourceTypeResourceAndStatusTypeInCustomizedView(String _resourceType, String _resource, String[] _statusType) throws Exception {
		for(int iterate = 0; iterate < _statusType.length; iterate++){
			String element = Locators.RT_RESOURCE_AND_STATUSTYPE_PART1  + _resourceType+ Locators.RT_RESOURCE_AND_STATUSTYPE_PART2 + _statusType[iterate] + Locators.RESOURCETYPE_AND_RESOURCE_PART2 + _resource + Locators.CLOSINGBRACKET;
			waitForElement.waitForElements(element, "xpath");
			assertTrue(this.page.element(element, "xpath").isElementPresent());
		}
		return this;
	}

	public View searchResourceAndAddToCustomView(String resourceName, String[] resourceValue, String[] statusTypesValues) throws Exception {
		navigateTo.clickOnSearchInToolBar();
		this.verifyFindResourcesPage();
		this.enterResourceNameInWhatSearchField(resourceName);
		this.clickOnSearch();
		this.selectResource(resourceValue);
		this.clickOnAddToCustomView();
		this.verifyEditCustomViewPage();
		this.clickOnOptions();
		this.selectStatusTypesInEditCustomViewOptions(statusTypesValues);
		this.selectAllCheckkBoxInOptions();
		this.clickOnSave();
		return this;
	}

	public View verifyResourceTypeResourceAndStatusType(String _resourceType, String _resource, String[] _statusType) throws Exception {
		for(int iterate = 0; iterate < _statusType.length; iterate++){
			String element = Locators.ANCHOR_TAG_WITH_TEXT  + _resourceType+ Locators.RESOURCETYPE_AND_STATUSTYPE_PART2 + _statusType[iterate] + Locators.RESOURCETYPE_AND_RESOURCE_PART2 + _resource + Locators.CLOSINGBRACKET;
			waitForElement.waitForElements(element, "xpath");
			assertTrue(this.page.element(element, "xpath").isElementPresent(), element+ " is not present.");
		}
		return this;
	}

	public View verifyNoResourceTypeResourceAndStatusTypeIsPresent(String _resourceType, String _resource, String[] _statusType) throws Exception {
		for(int iterate = 0; iterate < _statusType.length; iterate++){
			String element = Locators.ANCHOR_TAG_WITH_TEXT  + _resourceType+ Locators.RESOURCETYPE_AND_STATUSTYPE_PART2 + _statusType[iterate] + Locators.RESOURCETYPE_AND_RESOURCE_PART2 + _resource + Locators.CLOSINGBRACKET;
			assertFalse(this.page.element(element, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL), element + " is present.");
		}
		return this;
	}

	public View verifyResourceTypesAndResource(String _resourceType, String _resource) throws Exception {
		waitForElement.waitForElements(Locators.RESOURCETYPE_AND_STATUSTYPE_PART1 + _resourceType + Locators.CLOSINGBRACKET, "xpath");
		waitForElement.waitForElements(Locators.RESOURCETYPE_AND_STATUSTYPE_PART1  + _resourceType+ Locators.RESOURCETYPE_AND_RESOURCE_PART2 + _resource + Locators.CLOSINGBRACKET, "xpath");
		assertTrue(this.page.element(Locators.RESOURCETYPE_AND_STATUSTYPE_PART1  + _resourceType+ Locators.RESOURCETYPE_AND_RESOURCE_PART2 + _resource + Locators.CLOSINGBRACKET, "xpath").isElementPresent());
		return this;
	}

	public View verifyNoResourceTypeResourceAndStatusTypeIsPresent(String _resourceType, String _resource, ArrayList<String> _statusType) throws Exception {
		for(String statusType : _statusType) {
			String element = Locators.ANCHOR_TAG_WITH_TEXT  + _resourceType+ Locators.RESOURCETYPE_AND_STATUSTYPE_PART2 + statusType + Locators.RESOURCETYPE_AND_RESOURCE_PART2 + _resource + Locators.CLOSINGBRACKET;
			assertFalse(this.page.element(element, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL), element + " is present.");
		}
		return this;
	}

	public View verifyResourceTypeResourceAndStatusType(String _resourceType, String _resource, ArrayList<String> _statusType) throws Exception {
		for(String statusTypes : _statusType) {
			String element = Locators.ANCHOR_TAG_WITH_TEXT  + _resourceType+ Locators.RESOURCETYPE_AND_STATUSTYPE_PART2 + statusTypes + Locators.RESOURCETYPE_AND_RESOURCE_PART2 + _resource + Locators.CLOSINGBRACKET;
			waitForElement.waitForElements(element, "xpath");
			assertTrue(this.page.element(element, "xpath").isElementPresent(), element+ " is not present.");
		}
		return this;
	}

	public View verifyViewSnapShotDetailes(String viewName,String resourceName,String resourcTypName,List<String> updatedDetailes)
			throws Exception {
		waitForElement.waitForElements(Locators.VIEW_NAME_IN_VIEW_SNAP_SHOT+viewName+Locators.CLOSINGTWOBRACES, "xpath");
		assertTrue(this.page.element(Locators.VIEW_NAME_IN_VIEW_SNAP_SHOT+viewName+Locators.CLOSINGTWOBRACES, "xpath").isElementPresent());
		for (int i = 0; i < updatedDetailes.size(); i++) {
			String viewDetailes=Locators.VIEW_SNAP_SHOT_DETAIL_PART1+resourceName+Locators.VIEW_SNAP_SHOT_DETAIL_PART2+updatedDetailes.get(i)+Locators.CLOSINGTWOBRACES;
			assertTrue(this.page.element(viewDetailes, "xpath").isElementPresent(),updatedDetailes.get(i) +"is not displayed in view snap shot");
			assertTrue(this.page.element(viewDetailes, "xpath").getOne().isDisplayed(),updatedDetailes.get(i) +"is not displayed in view snap shot");
		}
		return this;
	}

	public View verifyHeadersOfViewSnapShot(String viewName,String resourceName,String resourcTypName,List<String> headers)
			throws Exception {
		waitForElement.waitForElements(Locators.VIEW_NAME_IN_VIEW_SNAP_SHOT+viewName+Locators.CLOSINGTWOBRACES, "xpath");
		assertTrue(this.page.element(Locators.VIEW_NAME_IN_VIEW_SNAP_SHOT+viewName+Locators.CLOSINGTWOBRACES, "xpath").isElementPresent());
		for (int i = 0; i < headers.size(); i++) {
			String viewHeaders = Locators.VIEW_SNAP_SHOT_HEADERS_PART1+resourcTypName+Locators.VIEW_SNAP_SHOT_HEADERS_PART2+headers.get(i)+Locators.CLOSINGTWOBRACES;
			assertTrue(this.page.element(viewHeaders, "xpath").isElementPresent(),headers.get(i) +"is not displayed in view snap shot");
			assertTrue(this.page.element(viewHeaders, "xpath").getOne().isDisplayed(),headers.get(i) +"is not displayed in view snap shot");
		} 
		return this;
	}

	public View verifyViewSnapShotDetailesAndClose(String viewName,String resourceName,String resourcTypName,List<String> headers,List<String> updatedDetailes)
			throws Exception {
		this.verifyHeadersOfViewSnapShot(viewName, resourceName, resourcTypName, headers);
		this.verifyViewSnapShotDetailes(viewName, resourceName, resourcTypName, updatedDetailes);
		return this;
	} 

	public View selectStatusTypesInEditCustomViewOptions(ArrayList<String> strStatusTypesVal)
			throws Exception {
		for (String statusTypes : strStatusTypesVal) {
			waitForElement.waitForElements(Locators.STATUS_TYPES_CHECKBOX_IN_EDIT_CUSTUM_VIEW_OPTIONS_PART1 + statusTypes + Locators.CLOSINGBRACKET, "xpath");
			if(this.page.element(Locators.STATUS_TYPES_CHECKBOX_IN_EDIT_CUSTUM_VIEW_OPTIONS_PART1 + statusTypes + Locators.CLOSINGBRACKET, "xpath").getDisplayedOne().isSelected() == false){
				this.page.element(Locators.STATUS_TYPES_CHECKBOX_IN_EDIT_CUSTUM_VIEW_OPTIONS_PART1 + statusTypes + Locators.CLOSINGBRACKET, "xpath").getDisplayedOne().sendKeys(Keys.SPACE);
			}
			if(this.page.element(Locators.STATUS_TYPES_CHECKBOX_IN_EDIT_CUSTUM_VIEW_OPTIONS_PART1 + statusTypes + Locators.CLOSINGBRACKET, "xpath").getDisplayedOne().isSelected() == false){
				this.page.element(Locators.STATUS_TYPES_CHECKBOX_IN_EDIT_CUSTUM_VIEW_OPTIONS_PART1 + statusTypes + Locators.CLOSINGBRACKET, "xpath").clickUsingJSE();
			}
			assertTrue(this.page.element(Locators.STATUS_TYPES_CHECKBOX_IN_EDIT_CUSTUM_VIEW_OPTIONS_PART1 + statusTypes + Locators.CLOSINGBRACKET, "xpath").getOne().isSelected());
		}
		return this;
	}

	public View selectResource(ArrayList<String> resourceValues)
			throws Exception {
		for (String resourceValue : resourceValues) {
			waitForElement.waitForElements(Locators.RESOURCE_CHECKBOX_IN_FIND_RESOURCE_PART1 + resourceValue + Locators.CLOSINGBRACKET, "xpath");
			try{
				this.page.element(Locators.RESOURCE_CHECKBOX_IN_FIND_RESOURCE_PART1 + resourceValue + Locators.CLOSINGBRACKET, "xpath").getDisplayedOne().sendKeys(Keys.SPACE);
			}catch(Exception e){
				this.page.element(Locators.RESOURCE_CHECKBOX_IN_FIND_RESOURCE_PART1 + resourceValue + Locators.CLOSINGBRACKET, "xpath").getDisplayedOne().sendKeys(Keys.ENTER);
			}
			if(!this.page.element(Locators.RESOURCE_CHECKBOX_IN_FIND_RESOURCE_PART1 + resourceValue + Locators.CLOSINGBRACKET, "xpath").getOne().isSelected()){
				int count = 0;
				while(!this.page.element(Locators.RESOURCE_CHECKBOX_IN_FIND_RESOURCE_PART1 + resourceValue + Locators.CLOSINGBRACKET, "xpath").getOne().isSelected() && count <= 5) {
					this.page.element(Locators.RESOURCE_CHECKBOX_IN_FIND_RESOURCE_PART1 + resourceValue + Locators.CLOSINGBRACKET, "xpath").clickUsingJSE();
					count = count++;
				}
			}
			assertTrue(this.page.element(Locators.RESOURCE_CHECKBOX_IN_FIND_RESOURCE_PART1 + resourceValue + Locators.CLOSINGBRACKET, "xpath").getOne().isSelected());
		}
		return this;
	}

	public View createCustomizedViewFromPreferences(String resourceName, ArrayList<String> resourceValues, ArrayList<String> statusTypesValues) throws Exception {
		navigateTo.customizedViewUnderPreferences();
		this.verifyEditCustomViewPage();
		this.clickOnAddMoreResourcesLink();
		this.enterResourceNameInWhatSearchField(resourceName);
		this.clickOnSearch();
		this.selectResource(resourceValues);
		this.clickOnAddToCustomView();
		this.verifyEditCustomViewPage();
		this.clickOnOptions();
		this.selectStatusTypesInEditCustomViewOptions(statusTypesValues);
		this.selectAllCheckkBoxInOptions();
		this.clickOnSave();
		return this;
	}

	public View navigateToResourceDetail(String resourceName)
			throws Exception {
		waitForElement.waitForElements(Locators.RESOURCE_NAME_UNDER_VIEW + resourceName + Locators.CLOSINGBRACKET, "xpath");
		try{
			this.page.element(Locators.RESOURCE_NAME_UNDER_VIEW + resourceName + Locators.CLOSINGBRACKET, "xpath").getDisplayedOne().click();
			assertTrue(this.page.element(EMR.Locators.ViewResourceDetail.Locators.VIEW_RESOURCE_DETAIL_PAGE, "xpath").isElementPresent());
		}catch(Exception e){
			this.page.element(Locators.RESOURCE_NAME_UNDER_VIEW + resourceName + Locators.CLOSINGBRACKET, "xpath").clickUsingJSE();
			assertTrue(this.page.element(EMR.Locators.ViewResourceDetail.Locators.VIEW_RESOURCE_DETAIL_PAGE, "xpath").isElementPresent());
		}
		return this;
	}

	public View verifyResourceIsNotAvailable(String resourceTypeName,String resourceName) throws Exception {
		waitForElement.waitForElements(Locators.RESOURCE_NAME_IN_FIND_RESOURCE_PART1 + resourceTypeName + Locators.RESOURCE_NAME_IN_FIND_RESOURCE_PART2 + resourceName + Locators.CLOSINGBRACKET, "xpath");
		assertFalse(this.page.element(Locators.RESOURCE_NAME_IN_FIND_RESOURCE_PART1 + resourceTypeName + Locators.RESOURCE_NAME_IN_FIND_RESOURCE_PART2 + resourceName + Locators.CLOSINGBRACKET, "xpath").isElementPresent(), resourceName + "is present");
		return this;
	}

	public View verifyResourceIsAvailable(String resourceTypeName,String resourceName) throws Exception {
		waitForElement.waitForElements(Locators.RESOURCE_NAME_IN_FIND_RESOURCE_PART1 + resourceTypeName + Locators.RESOURCE_NAME_IN_FIND_RESOURCE_PART2 + resourceName + Locators.CLOSINGBRACKET, "xpath");
		assertTrue(this.page.element(Locators.RESOURCE_NAME_IN_FIND_RESOURCE_PART1 + resourceTypeName + Locators.RESOURCE_NAME_IN_FIND_RESOURCE_PART2 + resourceName + Locators.CLOSINGBRACKET, "xpath").isElementPresent(), resourceName + "is not present");
		return this;
	}

	public View verifyResourceShouldNotRetrived(String resourceTypeName,String resourceName) throws Exception {
		this.enterResourceNameInWhatSearchField(resourceName);
		this.clickOnSearch();
		this.verifyResourceIsNotAvailable(resourceTypeName, resourceName);
		return this;
	}

	public View verifyResourceShouldRetrived(String resourceTypeName,String editResourceName) throws Exception {
		this.enterResourceNameInWhatSearchField(editResourceName);
		this.clickOnSearch();
		this.verifyResourceIsAvailable(resourceTypeName, editResourceName);
		return this;
	}

	public View createCustomView(String resourceName, ArrayList<String> resourceValues, ArrayList<String> statusTypesValues) throws Exception {
		this.clickOnSetupCustomViewLink();
		this.verifyEditCustomViewPage();
		this.clickOnAddMoreResourcesLink();
		this.enterResourceNameInWhatSearchField(resourceName);
		this.clickOnSearch();
		this.selectResource(resourceValues);
		this.clickOnAddToCustomView();
		this.clickOnOptions();
		this.selectStatusTypesInEditCustomViewOptions(statusTypesValues);
		this.selectAllCheckkBoxInOptions();
		this.clickOnSave();
		return this;
	}

	public View selectResourceUnderFindResource(String resourceName) throws Exception {
		waitForElement.waitForElements(Locators.FIND_RESOURCE, "id");
		this.page.element(Locators.FIND_RESOURCE, "id").webElementToSelect().selectByVisibleText(resourceName);
		assertTrue(this.page.element(Locators.FIND_RESOURCE, "id").webElementToSelect().getFirstSelectedOption().getText().equals(resourceName), resourceName + " is not selected");
		return this;
	}

	public View verifyResourceIsNotPresentUnderFindResource(String resourceName) throws Exception {
		waitForElement.waitForElements(Locators.FIND_RESOURCE, "id");
		assertFalse(this.page.element(Locators.FIND_RESOURCE_PART1 + resourceName + Locators.CLOSINGBRACKET, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE), resourceName + " is present.");
		return this;
	}

	public View verifyStatusTypesArePresentInPopup(ArrayList<String> statusTypeNames) throws Exception {
		waitForElement.waitForElements(Locators.MAP_POPUP, "css");
		for(String ST_Names : statusTypeNames) {
			String detailsInPopup = this.page.element(Locators.MAP_POPUP, "css").getDisplayedOne().getText();
			assertTrue(detailsInPopup.contains(ST_Names), ST_Names + " is not present in the popped up window." + detailsInPopup);
		}
		return this;
	}

	public View verifyStatusTypesNotPresentInPopup(ArrayList<String> statusTypeNames) throws Exception {
		waitForElement.waitForElements(Locators.MAP_POPUP, "css");
		for(String ST_Names : statusTypeNames) {
			String detailsInPopup = this.page.element(Locators.MAP_POPUP, "css").getDisplayedOne().getText();
			assertFalse(detailsInPopup.contains(ST_Names), ST_Names + " is present in the popped up window." + detailsInPopup);
		}
		return this;
	}

	public View verifyResourceTypeResourceAndStatusTypeNotDisplayed(String _resourceType, String _resource, ArrayList<String> _statusType) throws Exception {
		for(String statusTypes : _statusType) {
			String element = Locators.ANCHOR_TAG_WITH_TEXT  + _resourceType+ Locators.RESOURCETYPE_AND_STATUSTYPE_PART2 + statusTypes + Locators.RESOURCETYPE_AND_RESOURCE_PART2 + _resource + Locators.CLOSINGBRACKET;
			assertFalse(this.page.element(element, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE), element+ " is present.");
		}
		return this;
	}

	public View verifySubResourceShouldBeRetrived(String resourceName,String subResourceName,String regionName, String subsesourceTypeName) throws Exception {
		this.enterResourceNameInWhatSearchField(subResourceName);
		this.clickOnSearch();
		this.verifySubResourceIsAvailable(resourceName, subResourceName, regionName, subsesourceTypeName);
		return this;
	}

	public View verifySubResourceIsAvailable(String resourceName,String subResourceName,String regionName, String subsesourceTypeName) throws Exception {
		String subresourceElement= Locators.RESOURCE_NAME_IN_FIND_RESOURCE_PART1 + subsesourceTypeName + Locators.RESOURCE_NAME_IN_FIND_RESOURCE_PART2 + regionName + Locators.RESOURCE_NAME_IN_FIND_RESOURCE_PART2 + resourceName + Locators.COLONSPACE +subResourceName + Locators.CLOSINGBRACKET;
		waitForElement.waitForElements(subresourceElement, "xpath");
		assertTrue(this.page.element(subresourceElement, "xpath").isElementPresent(), subResourceName + "is not present");
		return this;
	}

	public View verifySubResourceShouldNotRetrived(String resourceName,String subResourceName,String regionName, String subsesourceTypeName) throws Exception {
		this.enterResourceNameInWhatSearchField(subResourceName);
		this.clickOnSearch();
		this.verifySubResourceNotAvailable(resourceName ,subResourceName, regionName, subsesourceTypeName);
		this.verifyNoResourceValidationDisplayed();
		return this;
	}

	public View verifySubResourceNotAvailable(String resourceName, String subResourceName,String regionName, String subsesourceTypeName) throws Exception {
		String subresourceElement= Locators.RESOURCE_NAME_IN_FIND_RESOURCE_PART1 + subsesourceTypeName + Locators.RESOURCE_NAME_IN_FIND_RESOURCE_PART2 + regionName + Locators.RESOURCE_NAME_IN_FIND_RESOURCE_PART2 + resourceName + Locators.COLONSPACE +subResourceName + Locators.CLOSINGBRACKET;
		waitForElement.waitForElements(subresourceElement, "xpath");
		assertFalse(this.page.element(subresourceElement, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL), subResourceName + "is present");
		return this;
	}

	public View verifyNoResourceValidationDisplayed() throws Exception {
		String noResourceValidationElement= Locators.NORESOURCEVALIDATION;
		waitForElement.waitForElements(noResourceValidationElement, "xpath");
		assertTrue(this.page.element(noResourceValidationElement, "xpath").isElementPresent(), noResourceValidationElement + "is not displayed");
		return this;
	}

	public View verifyTwoSubResourceShouldBeRetrivedWhileSearch(String resourceName,String srs,String subResourceName,String subResourceName1,String regionName, String subsesourceTypeName) throws Exception {
		this.enterResourceNameInWhatSearchField(srs);
		this.clickOnSearch();
		this.verifySubResourceIsAvailable(resourceName, subResourceName, regionName, subsesourceTypeName);
		this.verifySubResourceIsAvailable(resourceName, subResourceName1, regionName, subsesourceTypeName);
		return this;
	}

	public View verifyResourceShouldBeRetrivedWhileSearch(String resourceName,String srs,String subResourceName,String subResourceName1,String regionName, String subsesourceTypeName) throws Exception {
		this.enterResourceNameInWhatSearchField(srs);
		this.clickOnSearch();
		this.verifySubResourceNotAvailable(resourceName, subResourceName, regionName, subsesourceTypeName);
		this.verifyNoResourceValidationDisplayed();
		this.verifySubResourceNotAvailable(resourceName, subResourceName1, regionName, subsesourceTypeName);
		this.verifyNoResourceValidationDisplayed();
		return this;
	}

	public View verifyViewIsNotPresentUnderViewsList(String viewName) throws Exception {
		assertFalse(this.page.element(EMR.Locators.Shared.Locators.PARTICULAR_VIEW_PART1 + viewName + Locators.CLOSINGBRACKET, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE), viewName + " is present.");
		return this;
	}

	public View verifyErrorMessageForResource() throws Exception {
		waitForElement.waitForElements(Locators.NO_RESOURCES_MATCH_TEXT, "xpath");
		assertTrue(this.page.element(Locators.NO_RESOURCES_MATCH_TEXT, "xpath").isElementPresent());
		return this;
	}

	public View verifyThereAreNoStatusesToDisplayInYourCustomView() throws Exception {
		waitForElement.waitForElements(Locators.THERE_ARE_NO_STATUSES_TO_DISPLAY_IN_YOUR_CUSTOM_VIEW, "xpath");
		assertTrue(this.page.element(Locators.THERE_ARE_NO_STATUSES_TO_DISPLAY_IN_YOUR_CUSTOM_VIEW, "xpath").isElementPresent());
		return this;
	}

	public View verifyClickHereToAddStatusColumnsToYourCustomView() throws Exception {
		waitForElement.waitForElements(Locators.SET_UP_CUSTOM_VIEW_LINK2, "linktext");
		assertTrue(this.page.element(Locators.SET_UP_CUSTOM_VIEW_LINK2, "linktext").isElementPresent());
		return this;
	}

	public View verifyErrorMessageOnCustomViewTableScreen() throws Exception {
		this.verifyNoStatusesInCustomViewHeaderDisplayed();
		this.verifyThereAreNoStatusesToDisplayInYourCustomView();
		this.verifyClickHereToAddStatusColumnsToYourCustomView();
		return this;
	}

	public View clickCustomize() throws Exception {
		waitForElement.waitForElements(Locators.CUSTOMIZE, "linktext");
		this.page.element(Locators.CUSTOMIZE, "linktext").getDisplayedOne().click();
		waitForElement.waitForElements(Views.Locators.OPTIONS_BUTTON, "css");
		return this;
	}

	public View verifyResourceIsNotOnEditCustomViewScreen(String resourceNameWithItsResourceType)
			throws Exception {
		waitForElement.waitForElements(Locators.TABLE_CELL_WITH_TEXT_PART1+resourceNameWithItsResourceType+Locators.TABLE_CELL_WITH_TEXT_PART2, "xpath");
		assertFalse(this.page.element(Locators.TABLE_CELL_WITH_TEXT_PART1+resourceNameWithItsResourceType+Locators.TABLE_CELL_WITH_TEXT_PART2, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL));
		return this;
	}

	public View clickOnCustomizeVerifyResourceIsNotOnEditCustomViewScreen(String resourceNameWithItsResourceType) throws Exception {
		this.clickCustomize();
		this.verifyResourceIsNotOnEditCustomViewScreen(resourceNameWithItsResourceType);
		return this;
	}

	public View searchResourceAndVerifyErrorMessageForResource(String resourceName) throws Exception {
		this.verifyEditCustomViewPage();
		this.clickOnAddMoreResourcesLink();
		this.enterResourceNameInWhatSearchField(resourceName);
		this.clickOnSearch();
		this.verifyErrorMessageForResource();
		return this;
	}

	public View clickCancel() throws Exception {
		waitForElement.waitForElements(Locators.CANCEL, "css");
		this.page.element(Locators.CANCEL, "css").getDisplayedOne().click();
		return this;
	}

	public View clickCancelVerifyEditCustomViewPage() throws Exception {
		this.clickCancel();
		this.verifyEditCustomViewPage();
		return this;
	}

	public View verifyStatusTypesNotInEditCustomViewOptionsScreen(ArrayList<String> statusTypesName) throws Exception {
		for (String statusTypesNames : statusTypesName) {
			assertFalse(this.page.element(Locators.VERIFY_STATUS_TYPES+statusTypesNames+Locators.CLOSINGBRACKET, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL));
		}
		return this;
	}

	public View clickOptionsVerifyStatusTypesNotInEditCustomViewOptionsScreen(ArrayList<String> statusTypesName) throws Exception {
		this.clickOnOptions();
		this.verifyStatusTypesNotInEditCustomViewOptionsScreen(statusTypesName);
		return this;
	}

	public View verifyResourceTypeAndStatusTypesUnderPerticulerView(String _resourceType, ArrayList<String> _statusType) throws Exception {

		waitForElement.waitForElements(Locators.RESOURCETYPE_AND_STATUSTYPE_PART1 + _resourceType + Locators.CLOSINGBRACKET, "xpath");
		Iterator<String> itr = _statusType.iterator();
		while(itr.hasNext()){
			String statusTypenames =itr.next();
			String StatusTypesInPerticulerView= Locators.RESOURCETYPE_AND_STATUSTYPE_PART1 + _resourceType + Locators.RESOURCETYPE_AND_STATUSTYPE_PART2 + statusTypenames + Locators.CLOSINGBRACKET;
			assertTrue(this.page.element(StatusTypesInPerticulerView, "xpath").isElementPresent(), StatusTypesInPerticulerView+"was not present");
			assertTrue(this.page.element(StatusTypesInPerticulerView, "xpath").getOne().isDisplayed(), StatusTypesInPerticulerView+"was not present");
		}
		return this;		
	}	

	public View verifyCustomViewMapPage() throws Exception {
		waitForElement.waitForElements(Locators.CUSTOM_VIEW_MAP_PAGE, "xpath");
		assertTrue(this.page.element(Locators.CUSTOM_VIEW_MAP_PAGE, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.CUSTOM_VIEW_MAP_PAGE, "xpath").getOne().isDisplayed());
		return this;
	}

	public View verifyStatusTypesNotDispalyedUnderParticularView(String _resourceType, ArrayList<String> _statusTypeNames) throws Exception {

		waitForElement.waitForElements(Locators.RESOURCETYPE_AND_STATUSTYPE_PART1 + _resourceType + Locators.CLOSINGBRACKET, "xpath");
		Iterator<String> itr = _statusTypeNames.iterator();
		while(itr.hasNext()){
			String _statusTypenames =itr.next();
			String StatusTypesInPerticulerView= Locators.RESOURCETYPE_AND_STATUSTYPE_PART1 + _resourceType + Locators.RESOURCETYPE_AND_STATUSTYPE_PART2 + _statusTypenames + Locators.CLOSINGBRACKET;
			assertFalse(this.page.element(StatusTypesInPerticulerView, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_TOO_SMALL), StatusTypesInPerticulerView+"was  present");
		}
		return this;		
	}

	public View verifyResourceTypeAndStatusTypesUnderCustomView(String resourceTypeName, ArrayList<String> statusTypeName) throws Exception {
		waitForElement.waitForElements(Locators.RT_RESOURCE_AND_STATUSTYPE_PART1 + resourceTypeName + Locators.CLOSINGBRACKET, "xpath");
		Iterator<String> itr = statusTypeName.iterator();
		while(itr.hasNext()){
			String statusTypenames =itr.next();
			String statusTypesInCustomView= Locators.RT_RESOURCE_AND_STATUSTYPE_PART1 + resourceTypeName + Locators.RT_RESOURCE_AND_STATUSTYPE_PART2 + statusTypenames + Locators.CLOSINGBRACKET;
			assertTrue(this.page.element(statusTypesInCustomView, "xpath").isElementPresent(), statusTypesInCustomView +" is not present");
			assertTrue(this.page.element(statusTypesInCustomView, "xpath").getOne().isDisplayed(), statusTypesInCustomView +" is not present");
		}
		return this;		
	}

	public View verifyStatusTypesNotInCustomView(String resourceTypeName, ArrayList<String> statusTypeName) throws Exception {
		waitForElement.waitForElements(Locators.RT_RESOURCE_AND_STATUSTYPE_PART1 + resourceTypeName + Locators.CLOSINGBRACKET, "xpath");
		Iterator<String> itr = statusTypeName.iterator();
		while(itr.hasNext()){
			String statusTypenames =itr.next();
			String statusTypesInCustomView= Locators.RT_RESOURCE_AND_STATUSTYPE_PART1 + resourceTypeName + Locators.RT_RESOURCE_AND_STATUSTYPE_PART2 + statusTypenames + Locators.CLOSINGBRACKET;
			assertFalse(this.page.element(statusTypesInCustomView, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_TOO_SMALL), statusTypesInCustomView + " is  present");
		}
		return this;		
	}

	public View clickCustomizeVerifyEditCustomViewPage() throws Exception {
		this.clickCustomize();
		this.verifyEditCustomViewPage();
		return this;
	}

	public View verifyStatusTypesInEditCustomViewOptionsScreen(ArrayList<String> statusTypesName) throws Exception {
		for (String statusTypesNames : statusTypesName) {
			assertTrue(this.page.element(Locators.VERIFY_STATUS_TYPES+statusTypesNames+Locators.CLOSINGBRACKET, "xpath").isElementPresent(), Locators.VERIFY_STATUS_TYPES+statusTypesNames+Locators.CLOSINGBRACKET + " is not present");
			assertTrue(this.page.element(Locators.VERIFY_STATUS_TYPES+statusTypesNames+Locators.CLOSINGBRACKET, "xpath").getOne().isDisplayed(), Locators.VERIFY_STATUS_TYPES+statusTypesNames+Locators.CLOSINGBRACKET + " is not present");
		}
		return this;
	}

	public View clickOptionsVerifyStatusTypesInEditCustomViewOptionsScreen(ArrayList<String> statusTypesName) throws Exception {
		this.clickOnOptions();
		this.verifyStatusTypesInEditCustomViewOptionsScreen(statusTypesName);
		return this;
	}

	public View verifyStatusColorOnView(String _resourceType, String _resource, String _statusType) throws Exception {
		{
			String element = Locators.ANCHOR_TAG_WITH_TEXT  + _resourceType+ Locators.RESOURCETYPE_AND_STATUSTYPE_PART2 + _statusType + Locators.RESOURCETYPE_AND_RESOURCE_PART2 + _resource + Locators.CLOSINGBRACKET;
			assertFalse(this.page.element(element, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL), element + " is present.");
		}
		return this;
	}

	public View verifyUpdatedValuePurpleColor(String ResourceValue, String StatusTypeValue, String statusValue)
			throws Exception {
		String statusTypeColor=Locators.STATUS_TYPE_COLOUR_PART1+ResourceValue+"_"+StatusTypeValue + Locators.CLOSINGBRACKET+Locators.STATUS_TYPE_COLOUR_PART2;
		waitForElement.waitForElements(statusTypeColor,"xpath");
		this.page.element(statusTypeColor,"xpath").mouseOver();
		assertEquals(statusValue, this.page.element(statusTypeColor,"xpath").getOne().getText());
		return this;
	}
	public View verifyResourceTypeAndStatusType(String _resourceType, ArrayList<String> _statusType) throws Exception {
		waitForElement.waitForElements(Locators.RESOURCETYPE_AND_STATUSTYPE_PART1 + _resourceType + Locators.CLOSINGBRACKET, "xpath");
		for(int intCount=0;intCount< _statusType.size(); intCount++){
			String element= Locators.RESOURCETYPE_AND_STATUSTYPE_PART1 + _resourceType + Locators.RESOURCETYPE_AND_STATUSTYPE_PART2 +_statusType.get(intCount)+ Locators.CLOSINGBRACKET;
			assertTrue(this.page.element(element, "xpath").isElementPresent(), element+"was not present");
		}
		return this;
	}

	public View verifyResourceAndSubResourceShouldBeRetrivedWhileSearch(String resourceName,String resourceTypeName,String subResourceName,String subResourceName1,String regionName, String subResourceTypeName) throws Exception {
		this.enterResourceNameInWhatSearchField(resourceName);
		this.clickOnSearch();
		this.verifyResourceIsAvailable(resourceTypeName, resourceName);
		this.verifySubResourceShouldBeRetrived(resourceName, subResourceName, regionName, subResourceTypeName);
		this.verifySubResourceShouldBeRetrived(resourceName, subResourceName1, regionName, subResourceTypeName);
		return this;
	}

	public View verifyUpdatedNedocsDoesNotIncludesDisasterTextInViewPage(String _resourceValue, String statusTypeValue,String updatedValue) throws Exception {
		String disasterLabelNotDispalyed = Locators.STATUS_TYPE_COLOUR_PART1  + _resourceValue+ "_" +statusTypeValue+ Locators.CLOSINGBRACKET+Locators.TEXT+updatedValue+Locators.CLOSINGBRACKET;
		assertFalse(this.page.element(disasterLabelNotDispalyed, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL),"Disaster Text is displayed corresponding to "+updatedValue+"");
		return this;
	}

	public View verifyUpdatedStatusTypeValue(String resourceTypeValue, String resourceValue, ArrayList<String> statusTypeValue, ArrayList<String> updatedValues) throws Exception {
		Iterator<String> iterator = statusTypeValue.iterator();
		Iterator<String> iterator2 = updatedValues.iterator();
		while(iterator.hasNext() && iterator2.hasNext()) {
			String ST_Value = iterator.next();
			String valuesUpdated = iterator2.next();
			try{
				int updated_value = Integer.parseInt(valuesUpdated);
				DecimalFormat  format = new DecimalFormat  ("#,###");
				valuesUpdated = format.format(updated_value);
			} catch(Exception e) {
				System.out.println("updated value is not Number.");
			}
			String element = Locators.UPDATED_STATUS_TYPE_PART1 + resourceTypeValue + Locators.UNDERSCORE + resourceValue + Locators.UPDATED_STATUS_TYPE_PART2 + resourceValue + Locators.UNDERSCORE + ST_Value+Locators.CLOSINGBRACKET;
			waitForElement.waitForElements(element, "xpath");
			assertEquals(this.page.element(element, "xpath").getDisplayedOne().getText(), valuesUpdated);
		}
		return this;
	}

	public View selectResource(String resourceValue)
			throws Exception {
		waitForElement.waitForElements(Locators.RESOURCE_CHECKBOX_IN_FIND_RESOURCE_PART1 + resourceValue + Locators.CLOSINGBRACKET, "xpath");
		try{
			this.page.element(Locators.RESOURCE_CHECKBOX_IN_FIND_RESOURCE_PART1 + resourceValue + Locators.CLOSINGBRACKET, "xpath").getDisplayedOne().sendKeys(Keys.SPACE);
		}catch(Exception e){
			this.page.element(Locators.RESOURCE_CHECKBOX_IN_FIND_RESOURCE_PART1 + resourceValue + Locators.CLOSINGBRACKET, "xpath").getDisplayedOne().sendKeys(Keys.ENTER);
		}
		if(!this.page.element(Locators.RESOURCE_CHECKBOX_IN_FIND_RESOURCE_PART1 + resourceValue + Locators.CLOSINGBRACKET, "xpath").getOne().isSelected()){
			this.page.element(Locators.RESOURCE_CHECKBOX_IN_FIND_RESOURCE_PART1 + resourceValue + Locators.CLOSINGBRACKET, "xpath").clickUsingJSE();
		}
		assertTrue(this.page.element(Locators.RESOURCE_CHECKBOX_IN_FIND_RESOURCE_PART1 + resourceValue + Locators.CLOSINGBRACKET, "xpath").getOne().isSelected());
		return this;
	}

	public View createCustomView(String resourceName, String resourceValue, ArrayList<String> statusTypesValues) throws Exception {
		this.clickOnSetupCustomViewLink();
		this.verifyEditCustomViewPage();
		this.clickOnAddMoreResourcesLink();
		this.enterResourceNameInWhatSearchField(resourceName);
		this.clickOnSearch();
		this.selectResource(resourceValue);
		this.clickOnAddToCustomView();
		this.clickOnOptions();
		this.selectStatusTypesInEditCustomViewOptions(statusTypesValues);
		this.selectAllCheckkBoxInOptions();
		this.clickOnSave();
		return this;
	}

	public View verifyUpdatedNedocsStatusTypesIncludesDisasterTextInViewPage(String _resourceValue,ArrayList<String> statusTypeValue,ArrayList<String> updatedValue) throws Exception {

		Iterator<String> stValues =statusTypeValue.iterator();
		Iterator<String> updatedValues =updatedValue.iterator();
		while(stValues.hasNext())
		{
			this.verifyUpdatedNedocsIncludesDisasterTextInViewPage(_resourceValue, stValues.next(), updatedValues.next());
		}
		return this;
	}

	public View verifyUpdatedNedocsIncludesDisasterTextInViewPage(String _resourceValue, String statusTypeValue,String updatedValue) throws Exception {
		String disasterLabelDispalyed = Locators.STATUS_TYPE_COLOUR_PART1  + _resourceValue+ "_" +statusTypeValue+ Locators.CLOSINGBRACKET+Locators.TEXT+updatedValue+Locators.CLOSINGBRACKET;
		waitForElement.waitForElements(disasterLabelDispalyed, "xpath");
		assertTrue(this.page.element(disasterLabelDispalyed, "xpath").isElementPresent(),"Disaster Text is not displayed corresponding to "+updatedValue+"");
		assertTrue(this.page.element(disasterLabelDispalyed, "xpath").getOne().isDisplayed(),"Disaster Text is not displayed corresponding to "+updatedValue+"");
		return this;
	}

	public View verifyUpdatedNedocsStatusTypesIncludesDisasterTextInViewPage(String _resourceValue,HashMap<String, String> update) throws Exception {

		Iterator<String> statusTypes =update.keySet().iterator();
		Iterator<String> updateValues=update.values().iterator();
		while(statusTypes.hasNext())
		{
			this.verifyUpdatedNedocsIncludesDisasterTextInViewPage(_resourceValue, statusTypes.next(), updateValues.next());
		}
		return this;
	}

	public View verifyUpdatedNedocsStatusTypesDoesNotIncludesDisasterTextInViewPage(String _resourceValue,HashMap<String, String> update) throws Exception {

		Iterator<String> statusTypes =update.keySet().iterator();
		Iterator<String> updateValues=update.values().iterator();
		while(statusTypes.hasNext())
		{
			this. verifyUpdatedNedocsDoesNotIncludesDisasterTextInViewPage(_resourceValue, statusTypes.next(), updateValues.next());
		}
		return this;
	}

	public View verifyResourceAreNotRetrivedInCustomizedView(String resourceName, String resourceTypeName) throws Exception {
		navigateTo.customizedViewUnderPreferences();
		this.verifyEditCustomViewPage();
		this.clickOnAddMoreResourcesLink();
		this.enterResourceNameInWhatSearchField(resourceName);
		this.clickOnSearch();
		this.verifyResourceIsNotAvailable(resourceTypeName, resourceName);
		this.verifyNoResourceValidationDisplayed();
		return this;
	}

	public View verifyResourceTypeResourceAndStatusTypeInCustomizedView(String _resourceType, String _resource, ArrayList<String> _statusType) throws Exception {
		Iterator<String> statusTypes =_statusType.iterator();
		while(statusTypes.hasNext()){
			String element = Locators.RT_RESOURCE_AND_STATUSTYPE_PART1  + _resourceType+ Locators.RT_RESOURCE_AND_STATUSTYPE_PART2 + statusTypes.next() + Locators.RESOURCETYPE_AND_RESOURCE_PART2 + _resource + Locators.CLOSINGBRACKET;
			waitForElement.waitForElements(element, "xpath");
			assertTrue(this.page.element(element, "xpath").isElementPresent());
		}
		return this;
	}

	public ArrayList<String> getTableIDAndSizeOfWebelements(String resourceTypeName, ArrayList<String> statusTypeNames) throws Exception {
		String element = Locators.SUMMARY_OF_RESOURCETYPE + resourceTypeName + Locators.CLOSINGBRACKET;
		String resourceTypeId = this.page.element(element, "xpath").getOne().getAttribute("id");
		int size= this.page.element(Locators.TABLE_ID_PART1 + resourceTypeId + Locators.TABLE_ID_PART2 + statusTypeNames.get(0) + Locators.TABLE_ID_PART3, "xpath").getXpathCount();
		size = size-1;
		String stringSize = Integer.toString(size);
		ArrayList<String> values = new ArrayList<String>(Arrays.asList(resourceTypeId,stringSize));
		return values;
	}
	public View verifyStatusTypeValueDisplayedInCustomView(String resourceTypeName, String resourceName, ArrayList<String> statusTypeName,String value) throws Exception {
		ArrayList<String> tableIDAndSizeOfWebelements =this.getTableIDAndSizeOfWebelements(resourceTypeName, statusTypeName);
		String element = Locators.TABLE_ID_PART1  + tableIDAndSizeOfWebelements.get(0)+ Locators.STATUSTYPE_VALUE_PART1 + resourceName + Locators.STATUSTYPE_VALUE_PART2 + tableIDAndSizeOfWebelements.get(1) + Locators.SQUARE_BRACKET;
		waitForElement.waitForElements(element, "xpath");
		String statusValue = this.page.element(element, "xpath").getOne().getText();
		assertTrue(statusValue.equals(value), statusValue + "value is displayed instead of "  + value);
		return this;
	}

	public View verifyCustomViewTablePage() throws Exception {
		waitForElement.waitForElements(Locators.CUSTOM_VIEW_TABLE_PAGE, "xpath");
		assertTrue(this.page.element(Locators.CUSTOM_VIEW_TABLE_PAGE, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.CUSTOM_VIEW_TABLE_PAGE, "xpath").getOne().isDisplayed());
		return this;
	}

	public View addStatusTypesToExistingCustomView(ArrayList<String> statusTypesValues) throws Exception {
		navigateTo.clickOnCustomize();
		this.clickOnOptions();
		this.selectStatusTypesInEditCustomViewOptions(statusTypesValues);
		this.clickOnSave();
		this.verifyCustomViewTablePage();
		return this;
	}

	public View verifyUpdatedStatusTypesValuesUnderCustomViewTable(String resourceTypeValue, String resourceValue, ArrayList<String> statusTypeValue, ArrayList<String> updatedValue) throws Exception {
		this.verifyUpdatedStatusTypeValue(resourceTypeValue, resourceValue, statusTypeValue, updatedValue);
		return this;
	}

	public View verifyStatusTypesUnderPerticulerView(String _resourceType, ArrayList<String> _statusTypeNames) throws Exception {

		Iterator<String> itr=_statusTypeNames.iterator();
		while(itr.hasNext()){
			String element =Locators.TABLE_HEADER_TEXT  + _resourceType+ Locators.STATUS_TYPES_IN_VIEW +itr.next()+ Locators.CLOSINGBRACKET;
			waitForElement.waitForElements(element, "xpath");
			assertTrue(this.page.element(element, "xpath").isElementPresent());
			assertTrue(this.page.element(element, "xpath").getOne().isDisplayed());
		}
		return this;
	}

	public View verifyStatusTypesDisplayedUnderCustomViewTable(String _resourceType, ArrayList<String> _statusTypeNames) throws Exception {

		Iterator<String> itr=_statusTypeNames.iterator();
		while(itr.hasNext()){
			String element =Locators.RT_RESOURCE_AND_STATUSTYPE_PART1  + _resourceType+ Locators.STATUS_TYPES_IN_VIEW +itr.next()+ Locators.CLOSINGBRACKET;
			waitForElement.waitForElements(element, "xpath");
			assertTrue(this.page.element(element, "xpath").isElementPresent());
			assertTrue(this.page.element(element, "xpath").getOne().isDisplayed());
		}
		return this;
	}

	public View createCustomViewByCustomizeLink(String resourceName, String resourceValue, ArrayList<String> statusTypesValues) throws Exception {
		navigateTo.clickOnCustomize();
		this.verifyEditCustomViewPage();
		this.clickOnAddMoreResourcesLink();
		this.enterResourceNameInWhatSearchField(resourceName);
		this.clickOnSearch();
		this.selectResource(resourceValue);
		this.clickOnAddToCustomView();
		this.clickOnOptions();
		this.selectStatusTypesInEditCustomViewOptions(statusTypesValues);
		this.selectAllCheckkBoxInOptions();
		this.clickOnSave();
		return this;
	}
	
	public View verifyUpdatedReasonsUnderCommentSection(String resource,ArrayList<String> updatedReason) throws Exception {

		Iterator<String> itr=updatedReason.iterator();
		while(itr.hasNext())
		{	
			String reasonUpdated=Locators.ANCHOR_TAG_WITH_TEXT+resource+Locators.UPDATED_REASONS_UNDER_VIEW+itr.next()+Locators.CLOSINGBRACKET;
			waitForElement.waitForElements(reasonUpdated, "xpath");
			assertTrue(this.page.element(reasonUpdated, "xpath").isElementPresent());
			assertTrue(this.page.element(reasonUpdated, "xpath").getOne().isDisplayed());
		}
		return null;
	}
	
	public View verifyStatusCellOfStatusTypeCantUpdate(String resourceValue,String statusTypeValue) throws Exception {
		String statusCell=Locators.STATUS_CELL_OF_STATUS_TYPE_PART1+resourceValue+","+statusTypeValue+Locators.STATUS_CELL_OF_STATUS_TYPE_PART2;
		//waitForElement.waitForElements(statusCell, "css");
		assertFalse((this.page.element(statusCell, "css").isElementPresent()));
		return this;
	}
	public View deSelectSummeryTotals() throws Exception {

		if(this.page.element(Locators.SHOW_SUMMARY, "name").getOne().isSelected()){
			this.page.element(Locators.SHOW_SUMMARY, "name").getOne().sendKeys(Keys.SPACE);
		}
		if(this.page.element(Locators.SHOW_SUMMARY, "name").getOne().isSelected()){
			this.page.element(Locators.SHOW_SUMMARY, "name").clickUsingJSE();
		}
		assertFalse(this.page.element(Locators.SHOW_SUMMARY, "name").getOne().isSelected());
		return this;
	}

	public View selectResourceAndAddStatusTypesToCustomViewWithoutSummeryTotals(String resourceValue, ArrayList<String> statusTypesValues) throws Exception {
		this.selectResource(resourceValue);
		this.clickOnAddToCustomView();
		this.clickOnOptions();
		this.selectStatusTypesInEditCustomViewOptions(statusTypesValues);
		this.selectAllCheckkBoxInOptions();
		this.deSelectSummeryTotals();
		this.clickOnSave();
		return this;
	}
	
	public View verifyHeadersOfResourceTypeTable_InView(String resourceTypeValue, ArrayList<String> headers_list) throws Exception {
		String element = Locators.VIEW_TABLE_PART1 + resourceTypeValue + Locators.COMMENT_HEADER_PART2;
		List<WebElement> CommentLastUpdatedAndByUser = this.page.element(element, "xpath").get();
		int listSize = CommentLastUpdatedAndByUser.size();
		int toVerify_listSize = headers_list.size();
		ArrayList<String> headers = new ArrayList<String>();
		for(int i = (listSize-toVerify_listSize); i < listSize; i++) {
			headers.add(CommentLastUpdatedAndByUser.get(i).getText());
			System.out.println(headers);
		}
		for(int i = 0; i < toVerify_listSize; i++) {
			assertEquals(headers.get(i), headers_list.get(i));
		}
		return this;
	}
	
}