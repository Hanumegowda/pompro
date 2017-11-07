package EMR.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import qaFramework.WaitTimeConstants;
import qaFramework.UserDefinedFunctions.WaitForElement;
import qaFramework.pageObject.PageObject;
import EMR.Locators.ViewUnderSetup.Locators;

public class ViewsUnderSetup extends PageObject {

	WebDriver driver;
	WaitForElement waitForElement ;

	public ViewsUnderSetup(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		waitForElement = new WaitForElement(this.driver);
	}

	public ViewsUnderSetup clickOnCreateNewView() throws Exception {
		waitForElement.waitForElements(Locators.CREATENEWVIEW, "css");
		this.page.element(Locators.CREATENEWVIEW, "css").getOne().click();
		try{
			this.page.element_wait(Locators.LOADING, "xpath").waitForInvisibilityOfElement();
		} catch(Exception e) {
			
		}
		return this;
	}

	public ViewsUnderSetup enterViewName(String _viewName) throws Exception {
		waitForElement.waitForElements(Locators.VIEWNAME, "xpath");
		this.page.element_wait(Locators.LOADING, "xpath").waitForInvisibilityOfElement();
		this.page.element(Locators.VIEWNAME, "xpath").clearInputValue().sendKeys(_viewName);
		this.page.element(Locators.VIEWNAME, "xpath").getOne().clear();
		this.page.element(Locators.VIEWNAME, "xpath").getOne().sendKeys(_viewName);
		System.out.println(_viewName);
		assertEquals(this.page.element(Locators.VIEWNAME, "xpath").getOne().getAttribute("value"), _viewName);
		return this;
	}

	public ViewsUnderSetup enterViewDescription(String _viewDescription) throws Exception {
		waitForElement.waitForElements(Locators.VIEW_DESCRIPTION, "xpath");
		this.page.element(Locators.VIEW_DESCRIPTION, "xpath").clearInputValue()
		.sendKeys(_viewDescription);
		return this;
	}

	public ViewsUnderSetup clickOnNext() throws Exception {
		waitForElement.waitForElements(Locators.NEXT, "css");
		this.page.element_wait(Locators.NEXT, "css").waitForElementEnable();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", this.page.element(Locators.NEXT, "css").getOne());
		try{
			this.page.element_wait(Locators.LOADING, "xpath").waitForInvisibilityOfElement();
			this.page.element_wait(Locators.LOADING_1, "xpath").waitForInvisibilityOfElement();
			waitForElement.waitForElements(Locators.LOADING_1, "xpath");
			assertTrue(this.page.element(Locators.LOADING_1, "xpath").isElementPresent());
		} catch (Exception e) {
			this.page.element_wait(Locators.LOADING, "xpath").waitForInvisibilityOfElement();
		}
		return this;
	}

	public ViewsUnderSetup selectRegionName(String regionName) throws Exception {
		String selectRegion = Locators.SELECT_REGION + regionName
				+ Locators.CLOSINGBRACKET + Locators.SELECT_REGION1;
		System.out.println(selectRegion);
		this.page.element_wait(Locators.LOADING, "xpath").waitForInvisibilityOfElement();
		waitForElement.waitForElements(selectRegion, "xpath");
		if (this.page.element(selectRegion, "xpath").getOne().isSelected() == false) {
			this.page.element(selectRegion, "xpath").getOne().sendKeys(Keys.SPACE);
		}
		if (this.page.element(selectRegion, "xpath").getOne().isSelected() == false) {
			this.page.element(selectRegion, "xpath").getOne().sendKeys(Keys.SPACE);
		}
		if (this.page.element(selectRegion, "xpath").getOne().isSelected() == false) {
			this.page.element(selectRegion, "xpath").Click();
		}
		if (this.page.element(selectRegion, "xpath").getOne().isSelected() == false) {
			this.page.element(selectRegion, "xpath").clickUsingJSE();
		}
		assertTrue(this.page.element(selectRegion, "xpath").getOne().isSelected());
		return this;
	}

	public String getRegionNameFromHeader() throws Exception {
		String RegionName[] = new String[2];
		String RegionName1 = this.page.element(Locators.REGION_NAME, "xpath").getOne()
				.getText();
		RegionName = RegionName1.split(" ");
		RegionName[0] = RegionName[0].trim();
		return RegionName[0];
	}

	public ViewsUnderSetup selectResource(String resource) throws Exception {
		String selectResource = Locators.SELECT_REGION + resource + Locators.CLOSINGBRACKET + Locators.SELECT_RESOURCE;
		this.page.element_wait(Locators.LOADING, "xpath").waitForInvisibilityOfElement();
		waitForElement.waitForElements(selectResource, "xpath");
		this.page.element_wait(selectResource, "xpath").waitForElementEnable();
		if (this.page.element(selectResource, "xpath").getOne().isSelected() == false) {
			this.page.element(selectResource, "xpath").getOne().sendKeys(Keys.SPACE);
		}
		if (this.page.element(selectResource, "xpath").getOne().isSelected() == false) {
			this.page.element(selectResource, "xpath").getOne().sendKeys(Keys.ENTER);
		}
		if (this.page.element(selectResource, "xpath").getOne().isSelected() == false) {
			this.page.element(selectResource, "xpath").Click();
		}
		if (this.page.element(selectResource, "xpath").getOne().isSelected() == false) {
			this.page.element(selectResource, "xpath").clickUsingJSE();
		}
		assertTrue(this.page.element(selectResource, "xpath").getOne().isSelected());
		return this;
	}

	public ViewsUnderSetup selectStatusType(String[] statusTypeNames) throws Exception {
		for (int i = 0; i < statusTypeNames.length; i++) {
			String selectStatusType = Locators.SELECT_STATUS_TYPES
					+ statusTypeNames[i] + Locators.CLOSINGBRACKET
					+ Locators.SELECT_STATUS_TYPES1;
			waitForElement.waitForElements(selectStatusType, "xpath");
			if (this.page.element(selectStatusType, "xpath").getOne().isSelected() == false) {
				this.page.element(selectStatusType, "xpath").getOne().sendKeys(Keys.SPACE);
			}
			if (this.page.element(selectStatusType, "xpath").getOne().isSelected() == false) {
				this.page.element(selectStatusType, "xpath").getOne().sendKeys(Keys.SPACE);
			}
			if (this.page.element(selectStatusType, "xpath").getOne().isSelected() == false) {
				this.page.element(selectStatusType, "xpath").Click();
			}
			if (this.page.element(selectStatusType, "xpath").getOne().isSelected() == false) {
				this.page.element(selectStatusType, "xpath").clickUsingJSE();
			}
			assertTrue((this.page.element(selectStatusType, "xpath").getOne().isSelected()));
		}
		return this;
	}

	public ViewsUnderSetup clickOnSaveOfCreateNewView() throws Exception {
		waitForElement.waitForElements(Locators.SAVE_OF_CREATE_NEW_VIEW, "xpath");
		this.page.element(Locators.SAVE_OF_CREATE_NEW_VIEW, "xpath").getOne().click();
		this.page.element_wait(Locators.LOADING, "xpath").waitForInvisibilityOfElement();
		return this;
	}	

	public ViewsUnderSetup verifyViewInList(String viewName) throws Exception {
		String view = Locators.VERIFY_VIEW + viewName + Locators.CLOSINGBRACKET;
		waitForElement.waitForElements(view, "xpath");
		assertTrue(this.page.element(view, "xpath").isElementPresent(),
				view+" View is not displayed.");
		return this;
	}

	public ViewsUnderSetup createView(String viewName, String viewDescription,
			String resourceName, String statusTypeNames[]) throws Exception {
		this.clickOnCreateNewView();
		this.enterViewName(viewName);
		this.enterViewDescription(viewDescription);
		this.clickOnNext();
		String regionName = this.getRegionNameFromHeader();
		this.selectRegionName(regionName);
		this.clickOnNext();
		this.selectResource(resourceName);
		this.clickOnNext();
		this.selectStatusType(statusTypeNames);
		this.clickOnSaveOfCreateNewView();
		this.verifyViewInList(viewName);
		return this;
	}

	public ViewsUnderSetup clickOnEditOfRegDefault() throws Exception {
		waitForElement.waitForElements(Locators.EDIT_REGION_DEFUALT, "xpath");
		this.page.element(Locators.EDIT_REGION_DEFUALT, "xpath").getOne().click();
		this.page.element_wait(Locators.LOADING, "xpath").waitForInvisibilityOfElement();
		return this;
	}

	public ViewsUnderSetup clickOnRegionsSection() throws Exception {
		waitForElement.waitForElements(Locators.REGIONS, "xpath");
		this.page.element(Locators.REGIONS, "xpath").getOne().sendKeys(Keys.ENTER);
		this.page.element_wait(Locators.LOADING, "xpath").waitForInvisibilityOfElement();
		return this;
	}

	public ViewsUnderSetup clickOnResourcesSection() throws Exception {
		waitForElement.waitForElements(Locators.RESOURCES, "xpath");
		this.page.element(Locators.RESOURCES, "xpath").getOne().sendKeys(Keys.ENTER);
		waitForElement.waitForElements(Locators.SELECT_RESOURCE_TAB_TEXT, "xpath");
		return this;
	}

	public ViewsUnderSetup clickOnStatusTypeSection() throws Exception {
		waitForElement.waitForElements(Locators.STATUS_TYPES, "xpath");
		this.page.element(Locators.STATUS_TYPES, "xpath").getOne().sendKeys(Keys.ENTER);
		waitForElement.waitForElements(Locators.SELECT_STATUSTYPE_TAB_TEXT, "xpath");
     try{
			if(!this.page.element(Locators.SELECT_STATUSTYPE_TAB_TEXT, "xpath").isElementPresent())
			{	
				this.page.element(Locators.STATUS_TYPES, "xpath").Click();
				waitForElement.waitForElements(Locators.SELECT_STATUSTYPE_TAB_TEXT, "xpath");
			}	
		}
		catch(Exception e)
		{
			this.page.element(Locators.STATUS_TYPES, "xpath").clickUsingJSE();
			waitForElement.waitForElements(Locators.SELECT_STATUSTYPE_TAB_TEXT, "xpath");	
		}
	assertTrue(this.page.element(Locators.SELECT_STATUSTYPE_TAB_TEXT, "xpath").isElementPresent());
		return this;
	
	}	

	public ViewsUnderSetup selectMultipleRegionNames(String[] regionNames) throws Exception {
		waitForElement.waitForElements(Locators.SPAN_WITH_TEXT  + regionNames[0]
				+ "']/preceding-sibling::input", "xpath");

		for(int i=0; i < regionNames.length; i++){

			if (this.page
					.element(
							Locators.SPAN_WITH_TEXT  + regionNames[i]
									+ "']/preceding-sibling::input", "xpath")
									.getOne().isSelected() == false) {
				this.page
				.element(
						Locators.SPAN_WITH_TEXT  + regionNames[i]
								+ "']/preceding-sibling::input", "xpath")
								.getOne().click();
			}
		}
		return this;	
	}

	public ViewsUnderSetup selectMultipleResources(String[] resource) throws Exception {
		waitForElement.waitForElements(Locators.SPAN_WITH_TEXT  + resource[0]
				+ "']/parent::td/preceding-sibling::td[1]/input", "xpath");
		for (int i = 0; i < resource.length; i++) {
			if (this.page
					.element(
							Locators.SPAN_WITH_TEXT 
							+ resource[i]
									+ "']/parent::td/preceding-sibling::td[1]/input",
							"xpath").getOne().isSelected() == false) {
				this.page
				.element(
						Locators.SPAN_WITH_TEXT 
						+ resource[i]
								+ "']/parent::td/preceding-sibling::td[1]/input",
						"xpath").getOne().click();
			}
		}
		return this;
	}

	public ViewsUnderSetup verifyRegionNameCorrespondingToStatusTypes(
			String[] statusTypeNames, String regionName) throws Exception {
		waitForElement.waitForElements("//a[text()='" + statusTypeNames[0]
				+ "']/parent::td/following-sibling::td/span[text()='"
				+ regionName + Locators.CLOSINGBRACKET, "xpath");
		for (int i = 0; i < statusTypeNames.length; i++) {
			assertTrue(
					this.page
					.element(
							"//a[text()='"
									+ statusTypeNames[i]
											+ "']/parent::td/following-sibling::td/span[text()='"
											+ regionName + Locators.CLOSINGBRACKET, "xpath")
											.isElementPresent(),
					"ST not displayed corresponding to region name");
		}
		return this;
	}

	public ViewsUnderSetup verifyRegionNameCorrespondingToResources(
			String[] resourceNames, String regionName) throws Exception {
		waitForElement.waitForElements(Locators.SPAN_WITH_TEXT  + resourceNames[0]
				+ "']/parent::td/following-sibling::td/span[text()='"
				+ regionName + Locators.CLOSINGBRACKET, "xpath");
		for (int i = 0; i < resourceNames.length; i++) {
			assertTrue(
					this.page
					.element(
							Locators.SPAN_WITH_TEXT 
							+ resourceNames[i]
									+ "']/parent::td/following-sibling::td/span[text()='"
									+ regionName + Locators.CLOSINGBRACKET, "xpath")
									.isElementPresent(),
					"Resource not displayed corresponding to region name");
		}
		return this;
	}

	public ViewsUnderSetup clickOnCancelOfCreateNewView() throws Exception {
		waitForElement.waitForElements(Locators.CANCELOFCREATENEWVIEW, "xpath");
		this.page.element(Locators.CANCELOFCREATENEWVIEW, "xpath").getOne().click();
		return this;
	}	

	public ViewsUnderSetup clickOnEdit(String viewName) throws Exception {
		String editView = Locators.EDITVIEW + viewName
				+ Locators.CLOSINGBRACKET + Locators.EDITVIEW1;
		waitForElement.waitForElements(editView, "xpath");
		this.page.element(editView, "xpath").mouseOver();
		this.page.element(editView, "xpath").getOne().click();
		try{
		this.page.element_wait(Locators.LOADING, "xpath").waitForInvisibilityOfElement();
		}
		catch(Exception e)
		{
		  this.page.element_wait(Locators.LOADING_1, "xpath").waitForInvisibilityOfElement();	
		}
		return this;
	}

	public ViewsUnderSetup createNewSection(String sectionName) throws Exception {
		this.clickOncustomizeResourceDetailView();
		this.enterSectionName(sectionName);
		this.clickOnCreateSection();
		this.clickOnSave();
		return this;
	}

	public ViewsUnderSetup clickOncustomizeResourceDetailView() throws Exception {
		waitForElement.waitForElements(Locators.CUSTOMIZE_RESOURCE_DETAIL_VIEW, "css");
		this.page.element(Locators.CUSTOMIZE_RESOURCE_DETAIL_VIEW, "css").getOne().click();
		waitForElement.waitForElements(Locators.CREATESECTION, "css");
		return this;
	}

	public ViewsUnderSetup enterSectionName(String sectionName) throws Exception {
		waitForElement.waitForElements(Locators.ENTERSECTIONNAME, "css");
		this.page.element(Locators.ENTERSECTIONNAME, "css").getOne().clear();
		this.page.element(Locators.ENTERSECTIONNAME, "css").getOne().sendKeys(sectionName);
		return this;
	}

	public ViewsUnderSetup clickOnCreateSection() throws Exception {
		waitForElement.waitForElements(Locators.CREATESECTION, "css");
		this.page.element(Locators.CREATESECTION, "css").getOne().click();
		return this;
	}

	public ViewsUnderSetup clickOnSave() throws Exception {
		waitForElement.waitForElements(Locators.SAVE, "css");
		this.page.element(Locators.SAVE, "css").getOne().click();
		return this;
	}

	public ViewsUnderSetup createView(String viewName, String viewDescription,
			String resourceName[], String statusTypeNames[]) throws Exception {
		this.clickOnCreateNewView();
		this.enterViewName(viewName);
		this.enterViewDescription(viewDescription);
		this.clickOnNext();
		String regionName = this.getRegionNameFromHeader();
		this.selectRegionName(regionName);
		this.clickOnNext();
		for(int intCount=0; intCount<resourceName.length; intCount++){
			this.selectResource(resourceName[intCount]);
		}
		this.clickOnNext();
		this.selectStatusType(statusTypeNames);
		this.clickOnSaveOfCreateNewView();
		this.verifyViewInList(viewName);
		return this;
	}

	public ViewsUnderSetup clickOnAdvancedSection() throws Exception {
		waitForElement.waitForElements(Locators.ADVANCED, "xpath");
		this.page.element(Locators.ADVANCED, "xpath").getOne().sendKeys(Keys.ENTER);
		return this;
	}

	public ViewsUnderSetup createMultiRegionView(String viewName, String viewDescription,String[] regionNames,
			String resourceName, String statusTypeNames[]) throws Exception {
		this.clickOnCreateNewView();
		this.enterViewName(viewName);
		this.enterViewDescription(viewDescription);
		this.clickOnNext();
		String regionName = this.getRegionNameFromHeader();
		this.selectRegionName(regionName);
		for(int i =0;i<=regionNames.length-1;i++)
		{
			this.selectRegionName(regionNames[i]);
		}
		this.clickOnNext();
		this.selectResource(resourceName);
		this.clickOnNext();
		this.selectStatusType(statusTypeNames);
		this.clickOnSaveOfCreateNewView();
		this.verifyViewInList(viewName);
		return this;
	}

	public ViewsUnderSetup selectStatusesByColumn(String resourceType) throws Exception {
		waitForElement.waitForElements(Locators.SPAN_WITH_TEXT +resourceType+Locators.CLOSINGBRACKET+Locators.RESOURCE_TYPE_STATUSES_BY_COLUMN_INPUT ,"xpath");
		if(this.page.element(Locators.SPAN_WITH_TEXT + resourceType+Locators.CLOSINGBRACKET+Locators.RESOURCE_TYPE_STATUSES_BY_COLUMN_INPUT ,"xpath").getOne().isSelected()==false){
			this.page.element(Locators.SPAN_WITH_TEXT +resourceType+Locators.CLOSINGBRACKET+Locators.RESOURCE_TYPE_STATUSES_BY_COLUMN_INPUT ,"xpath").getOne().click();
		}
		return this;
	}

	public ViewsUnderSetup selectNewRTAddedInFutureStatusesbyColumn() throws Exception {
		waitForElement.waitForElements(Locators.NEW_RT_ADDED_IN_FUTURE_STATUSES_BY_COLUMN ,"xpath");
		if(this.page.element(Locators.NEW_RT_ADDED_IN_FUTURE_STATUSES_BY_COLUMN ,"xpath").getOne().isSelected()==false){
			this.page.element(Locators.NEW_RT_ADDED_IN_FUTURE_STATUSES_BY_COLUMN ,"xpath").getOne().click();
		}
		return this;
	}

	public ViewsUnderSetup selectNewRTAddedInFutureComments() throws Exception {
		waitForElement.waitForElements(Locators.NEW_RT_ADDED_IN_FUTURE_COMMENTS ,"xpath");
		if(this.page.element(Locators.NEW_RT_ADDED_IN_FUTURE_COMMENTS ,"xpath").getOne().isSelected()==false){
			this.page.element(Locators.NEW_RT_ADDED_IN_FUTURE_COMMENTS ,"xpath").getOne().click();
		}
		return this;
	}

	public ViewsUnderSetup selectComments(String resourceType) throws Exception {
		waitForElement.waitForElements(Locators.SPAN_WITH_TEXT +resourceType+Locators.CLOSINGBRACKET+Locators.RESOURCE_TYPE_COMMENTS_INPUT ,"xpath");
		if(this.page.element(Locators.SPAN_WITH_TEXT +resourceType+Locators.CLOSINGBRACKET+Locators.RESOURCE_TYPE_COMMENTS_INPUT ,"xpath").getOne().isSelected()==false){
			this.page.element(Locators.SPAN_WITH_TEXT +resourceType+Locators.CLOSINGBRACKET+Locators.RESOURCE_TYPE_COMMENTS_INPUT ,"xpath").getOne().click();
		}
		return this;
	}

	public ViewsUnderSetup deselectComments(String resourceType) throws Exception {
		waitForElement.waitForElements(Locators.SPAN_WITH_TEXT +resourceType+Locators.CLOSINGBRACKET+Locators.RESOURCE_TYPE_COMMENTS_INPUT ,"xpath");
		if(this.page.element(Locators.SPAN_WITH_TEXT +resourceType+Locators.CLOSINGBRACKET+Locators.RESOURCE_TYPE_COMMENTS_INPUT ,"xpath").getOne().isSelected()==true){
			this.page.element(Locators.SPAN_WITH_TEXT +resourceType+Locators.CLOSINGBRACKET+Locators.RESOURCE_TYPE_COMMENTS_INPUT ,"xpath").getOne().click();
		}
		return this;
	}

	public ViewsUnderSetup deselectNewRTAddedInFutureComments() throws Exception {
		waitForElement.waitForElements(Locators.NEW_RT_ADDED_IN_FUTURE_COMMENTS ,"xpath");
		if(this.page.element(Locators.NEW_RT_ADDED_IN_FUTURE_COMMENTS ,"xpath").getOne().isSelected()==true){
			this.page.element(Locators.NEW_RT_ADDED_IN_FUTURE_COMMENTS ,"xpath").getOne().click();
		}
		return this;
	}

	public ViewsUnderSetup createViewSelectingMultipleRSAndST(String viewName, String viewDescription,
			String resourceName[], String statusTypeNames[]) throws Exception {
		this.clickOnCreateNewView();
		this.enterViewName(viewName);
		this.enterViewDescription(viewDescription);
		this.clickOnNext();
		String regionName = this.getRegionNameFromHeader();
		this.selectRegionName(regionName);
		this.clickOnNext();
		for(int intCount=0; intCount<resourceName.length; intCount++){
			this.selectResource(resourceName[intCount]);
		}
		this.clickOnNext();
		this.selectStatusType(statusTypeNames);
		return this;
	}

	public ViewsUnderSetup selectNewRTAddedInFuture() throws Exception {
		waitForElement.waitForElements(Locators.NEW_RT_ADDED_IN_FUTURE ,"xpath");
		if(this.page.element(Locators.NEW_RT_ADDED_IN_FUTURE, "xpath").getOne().isSelected()==false){
			this.page.element(Locators.NEW_RT_ADDED_IN_FUTURE, "xpath").getOne().click();
		}
		return this;
	}

	public ViewsUnderSetup deselectStatusesByColumn(String resourceType) throws Exception {
		waitForElement.waitForElements(Locators.SPAN_WITH_TEXT +resourceType+Locators.CLOSINGBRACKET+Locators.RESOURCE_TYPE_STATUSES_BY_COLUMN_INPUT ,"xpath");
		if(this.page.element(Locators.SPAN_WITH_TEXT +resourceType+Locators.CLOSINGBRACKET+Locators.RESOURCE_TYPE_STATUSES_BY_COLUMN_INPUT ,"xpath").getOne().isSelected()==true){
			this.page.element(Locators.SPAN_WITH_TEXT +resourceType+Locators.CLOSINGBRACKET+Locators.RESOURCE_TYPE_STATUSES_BY_COLUMN_INPUT ,"xpath").getOne().click();
		}
		return this;
	}

	public ViewsUnderSetup selectnewRTAddedInFutureUser() throws Exception {
		waitForElement.waitForElements(Locators.NEW_RT_ADDED_IN_FUTURE_USER ,"xpath");
		if(this.page.element(Locators.NEW_RT_ADDED_IN_FUTURE_USER, "xpath").getOne().isSelected()==false){
			this.page.element(Locators.NEW_RT_ADDED_IN_FUTURE_USER, "xpath").getOne().click();
		}
		return this;
	}

	public ViewsUnderSetup deselectnewRTAddedInFutureUser() throws Exception {
		waitForElement.waitForElements(Locators.NEW_RT_ADDED_IN_FUTURE_USER ,"xpath");
		if(this.page.element(Locators.NEW_RT_ADDED_IN_FUTURE_USER, "xpath").getOne().isSelected()==true){
			this.page.element(Locators.NEW_RT_ADDED_IN_FUTURE_USER, "xpath").getOne().click();
		}
		return this;
	}

	public ViewsUnderSetup selectFutureResources(String resourceType) throws Exception {
		waitForElement.waitForElements(Locators.SPAN_WITH_TEXT +resourceType+Locators.CLOSINGBRACKET+Locators.RESOURCE_TYPE_FUTURE_RESOURCES_INPUT ,"xpath");
		if(this.page.element(Locators.SPAN_WITH_TEXT +resourceType+Locators.CLOSINGBRACKET+Locators.RESOURCE_TYPE_FUTURE_RESOURCES_INPUT ,"xpath").getOne().isSelected()==false){
			this.page.element(Locators.SPAN_WITH_TEXT +resourceType+Locators.CLOSINGBRACKET+Locators.RESOURCE_TYPE_FUTURE_RESOURCES_INPUT ,"xpath").getOne().click();
		}
		return this;
	}

	public ViewsUnderSetup selectNewRTAddedInFutureResources() throws Exception {
		waitForElement.waitForElements(Locators.NEW_RT_ADDED_IN_FUTURE_RESOURCES ,"xpath");
		if(this.page.element(Locators.NEW_RT_ADDED_IN_FUTURE_RESOURCES, "xpath").getOne().isSelected()==false){
			this.page.element(Locators.NEW_RT_ADDED_IN_FUTURE_RESOURCES, "xpath").getOne().click();
		}
		return this;
	}

	public ViewsUnderSetup selectUser(String resourceType) throws Exception {
		waitForElement.waitForElements(Locators.SPAN_WITH_TEXT +resourceType+Locators.CLOSINGBRACKET+Locators.RESOURCE_TYPE_USER_INPUT ,"xpath");
		if(this.page.element(Locators.SPAN_WITH_TEXT +resourceType+Locators.CLOSINGBRACKET+Locators.RESOURCE_TYPE_USER_INPUT ,"xpath").getOne().isSelected()==false){
			this.page.element(Locators.SPAN_WITH_TEXT +resourceType+Locators.CLOSINGBRACKET+Locators.RESOURCE_TYPE_USER_INPUT ,"xpath").getOne().click();
		}
		return this;
	}

	public ViewsUnderSetup deselectUser(String resourceType) throws Exception {
		waitForElement.waitForElements(Locators.SPAN_WITH_TEXT +resourceType+Locators.CLOSINGBRACKET+Locators.RESOURCE_TYPE_USER_INPUT ,"xpath");
		if(this.page.element(Locators.SPAN_WITH_TEXT +resourceType+Locators.CLOSINGBRACKET+Locators.RESOURCE_TYPE_USER_INPUT ,"xpath").getOne().isSelected()==true){
			this.page.element(Locators.SPAN_WITH_TEXT +resourceType+Locators.CLOSINGBRACKET+Locators.RESOURCE_TYPE_USER_INPUT ,"xpath").getOne().click();
		}
		return this;
	}

	public ViewsUnderSetup selectTimeStamp(String resourceType) throws Exception {
		waitForElement.waitForElements(Locators.SPAN_WITH_TEXT +resourceType+Locators.CLOSINGBRACKET+Locators.RESOURCE_TYPE_TIME_STAMP_INPUT ,"xpath");
		if(this.page.element(Locators.SPAN_WITH_TEXT +resourceType+Locators.CLOSINGBRACKET+Locators.RESOURCE_TYPE_TIME_STAMP_INPUT ,"xpath").getOne().isSelected()==false){
			this.page.element(Locators.SPAN_WITH_TEXT +resourceType+Locators.CLOSINGBRACKET+Locators.RESOURCE_TYPE_TIME_STAMP_INPUT ,"xpath").getOne().click();
		}
		return this;
	}

	public ViewsUnderSetup deselectTimeStamp(String resourceType) throws Exception {
		waitForElement.waitForElements(Locators.SPAN_WITH_TEXT +resourceType+Locators.CLOSINGBRACKET+Locators.RESOURCE_TYPE_TIME_STAMP_INPUT ,"xpath");
		if(this.page.element(Locators.SPAN_WITH_TEXT +resourceType+Locators.CLOSINGBRACKET+Locators.RESOURCE_TYPE_TIME_STAMP_INPUT ,"xpath").getOne().isSelected()==false){
			this.page.element(Locators.SPAN_WITH_TEXT +resourceType+Locators.CLOSINGBRACKET+Locators.RESOURCE_TYPE_TIME_STAMP_INPUT ,"xpath").getOne().click();
		}
		return this;
	}

	public ViewsUnderSetup deselectNewRTAddedInFuture() throws Exception {
		waitForElement.waitForElements(Locators.NEW_RT_ADDED_IN_FUTURE ,"xpath");
		if(this.page.element(Locators.NEW_RT_ADDED_IN_FUTURE, "xpath").getOne().isSelected()==true){
			this.page.element(Locators.NEW_RT_ADDED_IN_FUTURE, "xpath").getOne().click();
		}
		return this;
	}

	public ViewsUnderSetup deselectNewRTAddedInFutureResources() throws Exception {
		waitForElement.waitForElements(Locators.NEW_RT_ADDED_IN_FUTURE_RESOURCES ,"xpath");
		if(this.page.element(Locators.NEW_RT_ADDED_IN_FUTURE_RESOURCES, "xpath").getOne().isSelected()==true){
			this.page.element(Locators.NEW_RT_ADDED_IN_FUTURE_RESOURCES, "xpath").getOne().click();
		}
		return this;
	}

	public ViewsUnderSetup verifyResourceTypeAndStatusType(String _resourceType, String _statusType) throws Exception {
		waitForElement.waitForElements("//a[text()='"+_resourceType+"']/parent::th/following-sibling::th/a[text()='"+_statusType+Locators.CLOSINGBRACKET, "xpath");
		assertTrue(this.page
				.element("//a[text()='"+_resourceType+"']/parent::th/following-sibling::th/a[text()='"+_statusType+Locators.CLOSINGBRACKET, "xpath").getOne().isDisplayed());
		return this;
	}

	public ViewsUnderSetup verifyResourceTypeAndResource(String _resourceType, String _resource) throws Exception {
		waitForElement.waitForElements("//a[text()='"+_resourceType+"']/ancestor::thead/following-sibling::tbody/tr/td[2]/a[text()='"+_resource+Locators.CLOSINGBRACKET, "xpath");
		assertTrue(this.page
				.element("//a[text()='"+_resourceType+"']/ancestor::thead/following-sibling::tbody/tr/td[2]/a[text()='"+_resource+Locators.CLOSINGBRACKET, "xpath").getOne().isDisplayed());
		return this;
	}

	public ViewsUnderSetup verifyResourceTypeAndStatusType(String _resourceType, String _statusType[]) throws Exception {
		waitForElement.waitForElements("//a[text()='"+_resourceType+"']/parent::th/following-sibling::th/a[text()='"+_statusType+Locators.CLOSINGBRACKET, "xpath");

		for(int intCount=0; intCount<_statusType.length; intCount++){
			assertTrue(this.page
					.element("//a[text()='"+_resourceType+"']/parent::th/following-sibling::th/a[text()='"+_statusType+Locators.CLOSINGBRACKET, "xpath").getOne().isDisplayed());
		}
		return this;
	}

	public ViewsUnderSetup verifyResourceTypeAndResource(String _resourceType, String _resource[]) throws Exception {
		waitForElement.waitForElements("//a[text()='"+_resourceType+"']/ancestor::thead/following-sibling::tbody/tr/td[2]/a[text()='"+_resource+Locators.CLOSINGBRACKET, "xpath");
		for(int intCount=0; intCount<_resource.length; intCount++){
			assertTrue(this.page
					.element("//a[text()='"+_resourceType+"']/ancestor::thead/following-sibling::tbody/tr/td[2]/a[text()='"+_resource+Locators.CLOSINGBRACKET, "xpath").getOne().isDisplayed());
		}
		return this;
	}

	public ViewsUnderSetup addResourceAndStatusTypesToRegionDefaultView(String _regionName, String _resource[],String _statusTypeNames[]) throws Exception {
		this.clickOnEditOfRegDefault();
		this.clickOnRegionsSection();
		this.selectRegionName(_regionName);
		this.clickOnResourcesSection();
		for(int intCount=0; intCount<=_resource.length-1; intCount++){
			this.selectResource(_resource[intCount]);
		}
		this.clickOnNext();
		this.selectStatusType(_statusTypeNames);
		this.clickOnSaveOfCreateNewView();

		return this;
	}
	
	public ViewsUnderSetup createMultiRegionView(String viewName, String viewDescription,String[] regionNames,
			String resourceName[], String statusTypeNames[]) throws Exception {
		this.clickOnCreateNewView();
		this.enterViewName(viewName);
		this.enterViewDescription(viewDescription);
		this.clickOnNext();
		String regionName = this.getRegionNameFromHeader();
		this.selectRegionName(regionName);
		for(int i =0;i<=regionNames.length-1;i++)
		{
			this.selectRegionName(regionNames[i]);
		}
		this.clickOnNext();
		this.selectResource(resourceName);
		this.clickOnNext();
		this.selectStatusType(statusTypeNames);
		this.clickOnSaveOfCreateNewView();
		this.verifyViewInList(viewName);
		return this;
	}
	
	public ViewsUnderSetup selectResource(String[] resource) throws Exception {
		this.page.element_wait(Locators.SELECT_REGION + resource[0] + Locators.CLOSINGBRACKET + Locators.SELECT_RESOURCE, "xpath").waitForElementEnable();
		for(int i = 0; i < resource.length; i++) {
			String selectResource = Locators.SELECT_REGION + resource[i] + Locators.CLOSINGBRACKET + Locators.SELECT_RESOURCE;
			this.page.element_wait(Locators.LOADING, "xpath").waitForInvisibilityOfElement();
			waitForElement.waitForElements(selectResource, "xpath");
			if (this.page.element(selectResource, "xpath").getOne().isSelected() == false) {
				this.page.element(selectResource, "xpath").getOne().sendKeys(Keys.SPACE);
			}
			if (this.page.element(selectResource, "xpath").getOne().isSelected() == false) {
				this.page.element(selectResource, "xpath").getOne().click();
			}
			assertTrue(this.page.element(selectResource, "xpath").getOne().isSelected());
		}
		return this;
	}
	
	public ViewsUnderSetup selectStatusType(ArrayList<String> statusTypeNames) throws Exception {
		Iterator<String> iterator = statusTypeNames.iterator();
		while(iterator.hasNext()) {
			String statusTypeName = iterator.next();
			String eleString = Locators.SELECT_STATUS_TYPES + statusTypeName + Locators.CLOSINGBRACKET + Locators.SELECT_STATUS_TYPES1;
			if(!this.page.element(eleString, "xpath").getDisplayedOne().isSelected()){
				this.page.element(eleString, "xpath").getDisplayedOne().sendKeys(Keys.SPACE);
			}
			if(!this.page.element(eleString, "xpath").getDisplayedOne().isSelected()){
				this.page.element(eleString, "xpath").Click();
			}
			if(!this.page.element(eleString, "xpath").getDisplayedOne().isSelected()){
				this.page.element(eleString, "xpath").clickUsingJSE();
			}
			assertTrue(this.page.element(eleString, "xpath").getDisplayedOne().isSelected(), eleString + "is not selected");
		}
		return this;
	}
	
	public ViewsUnderSetup createMultiRegionView(String viewName, String viewDescription,ArrayList<String> regionNames,
			ArrayList<String>  resourceNames, ArrayList<String> statusTypeNames) throws Exception {
		this.clickOnCreateNewView();
		this.enterViewName(viewName);
		this.enterViewDescription(viewDescription);
		this.clickOnNext();
		String regionName = this.getRegionNameFromHeader();
		this.selectRegionName(regionName);
		for(String region_Name : regionNames) {
			this.selectRegionName(region_Name);
		}
		this.clickOnNext();
		for(String resourceName : resourceNames) {
			this.selectResource(resourceName);
		}
		this.clickOnNext();
		this.selectStatusType(statusTypeNames);
		this.clickOnSaveOfCreateNewView();
		this.verifyViewInList(viewName);
		return this;
	}
	
	public ViewsUnderSetup VerifyResourceNameIsUpdated(String viewName, String viewDescription,
			String editResourceName) throws Exception {
		this.clickOnCreateNewView();
		this.enterViewName(viewName);
		this.enterViewDescription(viewDescription);
		this.clickOnNext();
		String regionName = this.getRegionNameFromHeader();
		this.selectRegionName(regionName);
		this.clickOnNext();
		this.verifyResourceNameIsUpdated(editResourceName);
		this.clickOnSaveOfCreateNewView();
		this.verifyViewInList(viewName);
		return this;
	}
	
	public ViewsUnderSetup verifyResourceNameIsUpdated(String editResourceName) throws Exception {
		waitForElement.waitForElements(Locators.SPAN_TEXT+ editResourceName +Locators.CLOSINGBRACKET, "xpath");
		assertTrue(this.page
				.element(Locators.SPAN_TEXT+ editResourceName +Locators.CLOSINGBRACKET, "xpath").getOne().isDisplayed(), editResourceName + "is not displayed" );
		return this;
	}
	
	public ViewsUnderSetup verfiyStatusTypesUnderCreateViwPage(String viewName,String viewDescription,String region,String resourceName,ArrayList<String> statusTypeNames) throws Exception {
		this.clickOnCreateNewView();
		this.enterViewName(viewName);
		this.enterViewDescription(viewDescription);
		this.clickOnNext();
		this.selectRegionName(region);
		this.clickOnNext();
		this.selectResource(resourceName);
		this.clickOnNext();
		this.verifyStatusTypesUnderStatusTypesTabOfView(statusTypeNames);
		this.clickOnCancelOfCreateNewView();
		this.clickOnProceedWithoutSaving();
		return this;
	}
	

	public ViewsUnderSetup clickOnProceedWithoutSaving() throws Exception {
		waitForElement.waitForElements(Locators.PROCEED_WITHOUT_SAVING, "css");
		this.page.element(Locators.PROCEED_WITHOUT_SAVING, "css").getOne().click();
		this.page.element_wait(Locators.PROCEED_WITHOUT_SAVING, "css").waitForInvisibilityOfElement();
		waitForElement.waitForElements(Locators.VIEW_LIST_PAGE, "xpath");
		return this;
	}
	
	public ViewsUnderSetup verifyStatusTypesUnderStatusTypesTabOfView(ArrayList<String> statusTypeNames) throws Exception {
		    waitForElement.waitForPageToLoad();
			for(int i=0;i<statusTypeNames.size();i++)
			{
			String selectStatusType = Locators.SELECT_STATUS_TYPES + statusTypeNames.get(i) + Locators.CLOSINGBRACKET + Locators.SELECT_STATUS_TYPES1;
			waitForElement.waitForElements(selectStatusType, "xpath");
			this.page.element(selectStatusType, "xpath").mouseOver();
			assertTrue((this.page.element(selectStatusType, "xpath").isElementPresent()),statusTypeNames.get(i)+ " is not dispalyed under statusTypes tab Of View");
			assertTrue((this.page.element(selectStatusType, "xpath").getOne().isDisplayed()),statusTypeNames.get(i)+ " is not dispalyed under statusTypes tab Of View");
		}
		return this;
	}
	
	public ViewsUnderSetup clickOnCopy(String viewName)  throws Exception {
		waitForElement.waitForElements(Locators.VERIFY_VIEW+viewName+Locators.CLOSINGBRACKET+Locators.COPY, "xpath");
		this.page.element(Locators.VERIFY_VIEW+viewName+Locators.CLOSINGBRACKET+Locators.COPY, "xpath").mouseOver();
		this.page.element(Locators.VERIFY_VIEW+viewName+Locators.CLOSINGBRACKET+Locators.COPY, "xpath").getOne().click();
		this.page.element_wait(Locators.LOADING, "xpath").waitForInvisibilityOfElement();
		try{
			this.page.element_wait(Locators.LOADING, "xpath").waitForInvisibilityOfElement();
			this.page.element_wait(Locators.LOADING_1, "xpath").waitForInvisibilityOfElement();
			waitForElement.waitForElements(Locators.LOADING_1, "xpath");
			assertTrue(this.page.element(Locators.LOADING_1, "xpath").isElementPresent());
		} catch (Exception e) {
			this.page.element_wait(Locators.LOADING, "xpath").waitForInvisibilityOfElement();
		}
		return this;
	}
	
	public ViewsUnderSetup verfiyStatusTypesWhileCopyingView(String viewName,ArrayList<String> statusTypeNames) throws Exception {
		this.clickOnCopy(viewName);
		this.clickOnNext();
		this.clickOnNext();
		this.clickOnNext();
		this.verifyStatusTypesUnderStatusTypesTabOfView(statusTypeNames);
		this.clickOnCancelOfCreateNewView();
		this.clickOnProceedWithoutSaving();
		return this;
	}
	
	public ViewsUnderSetup verifyAndAddStatusTypesToExsistingView(String viewName,ArrayList<String> statusTypeNames) throws Exception {
		this.clickOnEdit(viewName);
		this.clickOnNext();
		this.clickOnNext();
		this.clickOnNext();
		this.selectStatusType(statusTypeNames);
		this.clickOnSaveOfCreateNewView();
		return this;
	}
	
	public ViewsUnderSetup createViewByUser(String viewName, String viewDescription,
			String resourceName, ArrayList<String> statusTypeNames,String region) throws Exception {
		this.clickOnCreateNewView();
		this.enterViewName(viewName);
		this.enterViewDescription(viewDescription);
		this.clickOnNext();
		this.selectRegionName(region);
		this.clickOnNext();
		this.selectResource(resourceName);
		this.clickOnNext();
		this.selectStatusType(statusTypeNames);
		this.clickOnSaveOfCreateNewView();
		this.verifyViewInList(viewName);
		return this;
	}

	public ViewsUnderSetup createView(String viewName, String viewDescription,
			String resourceName, ArrayList<String> statusTypeNames) throws Exception {
		this.clickOnCreateNewView();
		this.enterViewName(viewName);
		this.enterViewDescription(viewDescription);
		this.clickOnNext();
		String regionName = this.getRegionNameFromHeader();
		this.selectRegionName(regionName);
		this.clickOnNext();
		this.selectResource(resourceName);
		this.clickOnNext();
		this.selectStatusType(statusTypeNames);
		this.clickOnSaveOfCreateNewView();
		this.verifyViewInList(viewName);
		return this;
	}
	
	public ViewsUnderSetup deSelectStatusType(ArrayList<String> statusTypeNames) throws Exception {
		Iterator<String> iterator = statusTypeNames.iterator();
		while(iterator.hasNext()) {
			String statusTypeName = iterator.next();
			String element = Locators.SELECT_STATUS_TYPES + statusTypeName + Locators.CLOSINGBRACKET + Locators.SELECT_STATUS_TYPES1;
			if (this.page.element(element, "xpath").getDisplayedOne().isSelected()) {
				this.page.element(element, "xpath").getDisplayedOne().sendKeys(Keys.SPACE);
			}
			if (this.page.element(element, "xpath").getDisplayedOne().isSelected()) {
				this.page.element(element, "xpath").getDisplayedOne().sendKeys(Keys.SPACE);
			}
			if (this.page.element(element, "xpath").getDisplayedOne().isSelected()) {
				this.page.element(element, "xpath").Click();
			}
			if (this.page.element(element, "xpath").getDisplayedOne().isSelected()) {
				this.page.element(element, "xpath").clickUsingJSE();
			}
			assertFalse((this.page.element(element, "xpath").getDisplayedOne().isSelected()));
		}
		return this;
	}
	
	public ViewsUnderSetup deSelectResource(String resource) throws Exception {
		String selectResource = Locators.SELECT_REGION + resource + Locators.CLOSINGBRACKET + Locators.SELECT_RESOURCE;
		this.page.element_wait(Locators.LOADING, "xpath").waitForInvisibilityOfElement();
		waitForElement.waitForElements(selectResource, "xpath");
		this.page.element_wait(selectResource, "xpath").waitForElementEnable();
		if (this.page.element(selectResource, "xpath").getOne().isSelected()) {
			this.page.element(selectResource, "xpath").getOne().sendKeys(Keys.SPACE);
		}
		if (this.page.element(selectResource, "xpath").getOne().isSelected()) {
			this.page.element(selectResource, "xpath").getOne().sendKeys(Keys.SPACE);
		}
		if (this.page.element(selectResource, "xpath").getOne().isSelected()) {
			this.page.element(selectResource, "xpath").Click();
		}
		if (this.page.element(selectResource, "xpath").getOne().isSelected()) {
			this.page.element(selectResource, "xpath").clickUsingJSE();
		}
		assertFalse(this.page.element(selectResource, "xpath").getOne().isSelected());
		return this;
	}
	
	public ViewsUnderSetup navigateToUsersSection() throws Exception {
		waitForElement.waitForElements(Locators.USERS_TAB, "xpath");
		this.page.element(Locators.USERS_TAB, "xpath").getDisplayedOne().sendKeys(Keys.ENTER);
		waitForElement.waitForElements(Locators.VISIBILITY_FOR_USERS, "xpath");
		return this;
	}
	
	public ViewsUnderSetup removeUsersAccessInView() throws Exception {
		this.page.element_wait(Locators.LOADING, "xpath").waitForInvisibilityOfElement();
		waitForElement.waitForElements(Locators.VISIBILITY_FOR_USERS, "xpath");
		this.page.element_wait(Locators.VISIBILITY_FOR_USERS, "xpath").waitForElementEnable();
		if (this.page.element(Locators.VISIBILITY_FOR_USERS, "xpath").getOne().isSelected()) {
			this.page.element(Locators.VISIBILITY_FOR_USERS, "xpath").getOne().sendKeys(Keys.SPACE);
		}
		if (this.page.element(Locators.VISIBILITY_FOR_USERS, "xpath").getOne().isSelected()) {
			this.page.element(Locators.VISIBILITY_FOR_USERS, "xpath").getOne().sendKeys(Keys.ENTER);
		}
		if (this.page.element(Locators.VISIBILITY_FOR_USERS, "xpath").getOne().isSelected()) {
			this.page.element(Locators.VISIBILITY_FOR_USERS, "xpath").Click();
		}
		if (this.page.element(Locators.VISIBILITY_FOR_USERS, "xpath").getOne().isSelected()) {
			this.page.element(Locators.VISIBILITY_FOR_USERS, "xpath").clickUsingJSE();
		}
		assertFalse(this.page.element(Locators.VISIBILITY_FOR_USERS, "xpath").getOne().isSelected());
		return this;
	}
	
	public ViewsUnderSetup removeAllUsersAccessFromView() throws Exception {
		this.navigateToUsersSection();
		this.removeUsersAccessInView();
		return this;
	}
	
	public ViewsUnderSetup enableViewAccesForUser(String username) throws Exception {
		waitForElement.waitForElements(Locators.SPAN_WITH_TEXT + username + Locators.USER_ACCESS_TO_VIEW_PART2, "xpath");
		this.page.element(Locators.SPAN_WITH_TEXT + username + Locators.USER_ACCESS_TO_VIEW_PART2, "xpath").isElementPresent();
		if (!this.page.element(Locators.SPAN_WITH_TEXT + username + Locators.USER_ACCESS_TO_VIEW_PART2, "xpath").getOne().isSelected()) {
			this.page.element(Locators.SPAN_WITH_TEXT + username + Locators.USER_ACCESS_TO_VIEW_PART2, "xpath").getOne().sendKeys(Keys.SPACE);
		}
		if (!this.page.element(Locators.SPAN_WITH_TEXT + username + Locators.USER_ACCESS_TO_VIEW_PART2, "xpath").getOne().isSelected()) {
			this.page.element(Locators.SPAN_WITH_TEXT + username + Locators.USER_ACCESS_TO_VIEW_PART2, "xpath").getOne().sendKeys(Keys.ENTER);
		}
		if (!this.page.element(Locators.SPAN_WITH_TEXT + username + Locators.USER_ACCESS_TO_VIEW_PART2, "xpath").getOne().isSelected()) {
			this.page.element(Locators.SPAN_WITH_TEXT + username + Locators.USER_ACCESS_TO_VIEW_PART2, "xpath").Click();
		}
		if (!this.page.element(Locators.SPAN_WITH_TEXT + username + Locators.USER_ACCESS_TO_VIEW_PART2, "xpath").getOne().isSelected()) {
			this.page.element(Locators.SPAN_WITH_TEXT + username + Locators.USER_ACCESS_TO_VIEW_PART2, "xpath").clickUsingJSE();
		}
		assertTrue(this.page.element(Locators.SPAN_WITH_TEXT + username + Locators.USER_ACCESS_TO_VIEW_PART2, "xpath").getOne().isSelected(), username + " is not selected");
		return this;
	}
	
	public ViewsUnderSetup provideAccessToViewForUser(String username) throws Exception {
		this.navigateToUsersSection();
		this.removeUsersAccessInView();
		this.enableViewAccesForUser(username);
		return this;
	}

	public ViewsUnderSetup provideAccessToViewForUserAndSave(String username) throws Exception {
		this.navigateToUsersSection();
		this.removeUsersAccessInView();
		this.enableViewAccesForUser(username);
		this.clickOnSave();
		return this;
	}
	
	public ViewsUnderSetup clickOnSection(String sectionName) throws Exception {
		waitForElement.waitForElements(Locators.SPAN_WITH_TEXT + sectionName + Locators.CLOSINGBRACKET, "xpath");
		this.page.element(Locators.SPAN_WITH_TEXT + sectionName + Locators.CLOSINGBRACKET, "xpath").getDisplayedOne().click();
		if(!this.page.element(Locators.SPAN_WITH_TEXT + sectionName + Locators.CLOSINGBRACKET + Locators.EDIT_SECTION_PART_2, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE)) {
			this.page.element(Locators.SPAN_WITH_TEXT + sectionName + Locators.CLOSINGBRACKET, "xpath").clickUsingJSE();
		}
		if(!this.page.element(Locators.SPAN_WITH_TEXT + sectionName + Locators.CLOSINGBRACKET + Locators.EDIT_SECTION_PART_2, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE)) {
			this.page.element(Locators.SPAN_WITH_TEXT + sectionName + Locators.CLOSINGBRACKET, "xpath").Click();
		}
		return this;
	}
	
	public ViewsUnderSetup dragAndDropStatusTypeFromOneSectionToAnother(ArrayList<String> StatusTypeName, String targetSection) throws Exception {
		Iterator<String> iterator = StatusTypeName.iterator();
		while(iterator.hasNext()) {
			String next = iterator.next();
			String statusTypeElement = Locators.ST_NAME_IN_EDIT_RESOURCE_DETAIL_VIEW_SECTIONS + next + Locators.CLOSINGBRACKET;
			waitForElement.waitForElements(statusTypeElement, "xpath");
			this.page.element(statusTypeElement, "xpath").getDisplayedOne().click();
			WebElement destinationSection = this.page.element(Locators.SPAN_WITH_TEXT + targetSection + Locators.CLOSINGBRACKET, "xpath").getDisplayedOne();
			this.page.element(statusTypeElement, "xpath").dragAndDrop(destinationSection);
		}
		return this;
	}
	
	public ViewsUnderSetup moveStatusTypeToAnotherSection(ArrayList<String> StatusTypeName, String sourceSection, String targetSection) throws Exception {
		this.clickOnSection(sourceSection);
		this.dragAndDropStatusTypeFromOneSectionToAnother(StatusTypeName, targetSection);
		this.clickOnSave();
		return this;
	}
	
	public ViewsUnderSetup clickOnDeleteInRegionViewList(String viewName) throws Exception {
		waitForElement.waitForElements(Locators.DELETE_REGION_VIEW_PART1 + viewName + Locators.DELETE_REGION_VIEW_PART2, "xpath");
		try{
			this.page.element(Locators.DELETE_REGION_VIEW_PART1 + viewName + Locators.DELETE_REGION_VIEW_PART2, "xpath").getDisplayedOne().click();
			if(!this.page.element(Locators.DELETE_VIEW_CONFIRMATION_PAGE, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE)) {
				this.page.element(Locators.DELETE_REGION_VIEW_PART1 + viewName + Locators.DELETE_REGION_VIEW_PART2, "xpath").getDisplayedOne().sendKeys(Keys.ENTER);
			}
			if(!this.page.element(Locators.DELETE_VIEW_CONFIRMATION_PAGE, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE)) {
				this.page.element(Locators.DELETE_REGION_VIEW_PART1 + viewName + Locators.DELETE_REGION_VIEW_PART2, "xpath").clickUsingJSE();
			}
		} catch(Exception e) { }
		assertTrue(this.page.element(Locators.DELETE_VIEW_CONFIRMATION_PAGE, "xpath").isElementPresent(), Locators.DELETE_VIEW_CONFIRMATION_PAGE + " is not displayed");
		return this;
	}
	
	public ViewsUnderSetup clickOnDeleteInConfirmationScreen() throws Exception {
		waitForElement.waitForElements(Locators.DELETE_IN_CONFIRMATION_SCREEN, "css");
		try{
			this.page.element(Locators.DELETE_IN_CONFIRMATION_SCREEN, "css").getDisplayedOne().click();
			if(!this.page.element(Locators.VIEW_LIST_PAGE, "xpath").isElementPresent(WaitTimeConstants.COUNT)) {
				this.page.element(Locators.DELETE_IN_CONFIRMATION_SCREEN, "css").getDisplayedOne().sendKeys(Keys.ENTER);
			}
			if(!this.page.element(Locators.VIEW_LIST_PAGE, "xpath").isElementPresent(WaitTimeConstants.COUNT)) {
				this.page.element(Locators.DELETE_IN_CONFIRMATION_SCREEN, "css").clickUsingJSE();
			}
		} catch(Exception e) { }
		assertTrue(this.page.element(Locators.VIEW_LIST_PAGE, "xpath").isElementPresent(), Locators.VIEW_LIST_PAGE + " is not displayed");
		return this;
	}
	
	public ViewsUnderSetup deleteView(String viewName) throws Exception {
		this.clickOnDeleteInRegionViewList(viewName);
		this.clickOnDeleteInConfirmationScreen();
		return this;
	}
	
	public ViewsUnderSetup verifyViewIsNotPresentInViewList(String viewName) throws Exception {
		String view = Locators.VERIFY_VIEW + viewName + Locators.CLOSINGBRACKET;
		waitForElement.waitForElements(view, "xpath");
		assertFalse(this.page.element(view, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE), view + " View is displayed.");
		return this;
	}
	
	public ViewsUnderSetup clickOnCopyOfView(String existingView) throws Exception {
		waitForElement.waitForElements(Locators.DELETE_REGION_VIEW_PART1 + existingView + Locators.COPY_OF_VIEW_PART2, "xpath");
		try{
			this.page.element(Locators.DELETE_REGION_VIEW_PART1 + existingView + Locators.COPY_OF_VIEW_PART2, "xpath").getDisplayedOne().click();
			if(!this.page.element(Locators.VIEW_LIST_PAGE, "xpath").isElementPresent(WaitTimeConstants.COUNT)) {
				this.page.element(Locators.DELETE_REGION_VIEW_PART1 + existingView + Locators.COPY_OF_VIEW_PART2, "xpath").getDisplayedOne().sendKeys(Keys.ENTER);
			}
			if(!this.page.element(Locators.COPY_VIEW_HEADER_PART1 + existingView + Locators.CLOSINGBRACKET, "xpath").isElementPresent(WaitTimeConstants.COUNT)) {
				this.page.element(Locators.DELETE_REGION_VIEW_PART1 + existingView + Locators.COPY_OF_VIEW_PART2, "xpath").clickUsingJSE();
			}
		} catch(Exception e) { }
		assertTrue(this.page.element(Locators.COPY_VIEW_HEADER_PART1 + existingView + Locators.CLOSINGBRACKET, "xpath").isElementPresent(), "Copy view screen is not displayed");
		return this;
	}
	
	public ViewsUnderSetup verifyRegionIsSelected(String regionName) throws Exception {
		String selectRegion = Locators.SELECT_REGION + regionName + Locators.CLOSINGBRACKET + Locators.SELECT_REGION1;
		this.page.element_wait(Locators.LOADING, "xpath").waitForInvisibilityOfElement();
		waitForElement.waitForElements(selectRegion, "xpath");
		assertTrue(this.page.element(selectRegion, "xpath").getOne().isSelected());
		return this;
	}
	
	public ViewsUnderSetup verifyResourceIsSelected(String resource) throws Exception {
		String selectResource = Locators.SELECT_REGION + resource + Locators.CLOSINGBRACKET + Locators.SELECT_RESOURCE;
		this.page.element_wait(Locators.LOADING, "xpath").waitForInvisibilityOfElement();
		waitForElement.waitForElements(selectResource, "xpath");
		this.page.element_wait(selectResource, "xpath").waitForElementEnable();
		assertTrue(this.page.element(selectResource, "xpath").getOne().isSelected());
		return this;
	}
	
	public ViewsUnderSetup verifyStatusTypesAreSelected(ArrayList<String> statusTypeNames) throws Exception {
		Iterator<String> iterator = statusTypeNames.iterator();
		while(iterator.hasNext()) {
			String statusTypeName = iterator.next();
			String eleString = Locators.SELECT_STATUS_TYPES + statusTypeName + Locators.CLOSINGBRACKET + Locators.SELECT_STATUS_TYPES1;
			assertTrue(this.page.element(eleString, "xpath").getDisplayedOne().isSelected(), eleString + "is not selected");
		}
		return this;
	}
	
	public ViewsUnderSetup editViewAndSelectStatusTypes(String viewName, ArrayList<String> statusTypeNames) throws Exception {
		this.clickOnEdit(viewName);
		this.clickOnStatusTypeSection();
		this.selectStatusType(statusTypeNames);
		this.clickOnSave();
		return this;
	}

	public ViewsUnderSetup verifyStatusTypesOfCorrespondingSection(ArrayList<String> statusTypNames) throws Exception {
		Iterator<String> iterator = statusTypNames.iterator();
		while(iterator.hasNext()) {
		String 	statusTypName=Locators.ST_NAME_IN_EDIT_RESOURCE_DETAIL_VIEW_SECTIONS + iterator.next() + Locators.CLOSINGBRACKET;
		this.page.element(statusTypName,"xpath").mouseOver();
		assertTrue(this.page.element(statusTypName,"xpath").isElementPresent());
		assertTrue(this.page.element(statusTypName,"xpath").getOne().isDisplayed());
		}
		return this;
	}
	
	public ViewsUnderSetup openSectionUnderEdiResourceDetailViewAndVerifyStatusTypes(String section,ArrayList<String> statusTypValues) throws Exception {
		this.clickOncustomizeResourceDetailView();
		this.clickOnSection(section);
		this.verifyStatusTypesOfCorrespondingSection(statusTypValues);
		return this;
	}

	public ViewsUnderSetup selectResource(ArrayList<String> resourceNames) throws Exception {
		Iterator<String> iterator = resourceNames.iterator();
		while(iterator.hasNext()) {
			String resource = iterator.next();
			String selectResource = Locators.SELECT_REGION + resource + Locators.CLOSINGBRACKET + Locators.SELECT_RESOURCE;
			this.page.element_wait(Locators.LOADING, "xpath").waitForInvisibilityOfElement();
			waitForElement.waitForElements(selectResource, "xpath");
			this.page.element_wait(selectResource, "xpath").waitForElementEnable();
			if (this.page.element(selectResource, "xpath").getOne().isSelected() == false) {
				this.page.element(selectResource, "xpath").getOne().sendKeys(Keys.SPACE);
			}
			if (this.page.element(selectResource, "xpath").getOne().isSelected() == false) {
				this.page.element(selectResource, "xpath").clickUsingJSE();
			}
			if (this.page.element(selectResource, "xpath").getOne().isSelected() == false) {
				this.page.element(selectResource, "xpath").Click();
			}
			assertTrue(this.page.element(selectResource, "xpath").getOne().isSelected());
		}
		return this;
	}
	
	public ViewsUnderSetup createView(String viewName, String viewDescription,
			ArrayList<String> resourceName, ArrayList<String> statusTypeNames) throws Exception {
		this.clickOnCreateNewView();
		this.enterViewName(viewName);
		this.enterViewDescription(viewDescription);
		this.clickOnNext();
		String regionName = this.getRegionNameFromHeader();
		this.selectRegionName(regionName);
		this.clickOnNext();
		this.selectResource(resourceName);
		this.clickOnNext();
		this.selectStatusType(statusTypeNames);
		this.clickOnSaveOfCreateNewView();
		this.verifyViewInList(viewName);
		return this;
	}
}