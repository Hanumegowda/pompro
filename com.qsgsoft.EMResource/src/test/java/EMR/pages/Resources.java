package EMR.pages;
import static org.testng.Assert.*;
import java.util.ArrayList;
import java.util.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import qaFramework.WaitTimeConstants;
import qaFramework.UserDefinedFunctions.WaitForElement;
import qaFramework.pageObject.PageObject;
import EMR.Locators.Resources.Locators;

public class Resources extends PageObject {

	WebDriver driver;
	WaitForElement waitForElement ;
	WebDriverWait wait;
	UsersList userlist;

	public Resources(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		waitForElement =  new WaitForElement(this.driver);
		wait = new WebDriverWait(this.driver, WaitTimeConstants.WAIT_TIME_LONG);
		userlist =new UsersList(this.driver);
	}

	public Resources clickOnCreateNewResourceButton() throws Exception {
		waitForElement.waitForElements(Locators.CREATENEWRESOURCE, "xpath");
		this.page.element(Locators.CREATENEWRESOURCE, "xpath").clickUsingJSE();
		return this;
	}

	public Resources enterName(String _resourceName)
			throws Exception {
		waitForElement.waitForElements(Locators.RESOURCENAME, "name");
		this.page.element(Locators.RESOURCENAME, "name").clearInputValue().sendKeys(_resourceName);
		return this;
	}

	public Resources enterAbbrivation(
			String strResourceAbbrivation) throws Exception {
		waitForElement.waitForElements(Locators.DESCRIPTION, "name");
		this.page.element(Locators.DESCRIPTION, "name").clearInputValue().sendKeys(strResourceAbbrivation);
		return this;
	}

	public Resources enterFirstName(String _resourceFirstName)
			throws Exception {
		waitForElement.waitForElements(Locators.RESOURCEFIRSTNAME, "name");
		this.page.element(Locators.RESOURCEFIRSTNAME, "name").clearInputValue().sendKeys(_resourceFirstName);
		return this;
	}

	public Resources enterLastName(
			String _resourceLastName) throws Exception {
		waitForElement.waitForElements(Locators.RESOURCELASTNAME, "name");
		this.page.element(Locators.RESOURCELASTNAME, "name").clearInputValue().sendKeys(_resourceLastName);
		return this;
	}

	public Resources selectResourceType(String resourceTypeName)
			throws Exception {
		waitForElement.waitForElements(Locators.RESOURCETYPELIST, "xpath");
		this.page.element(Locators.RESOURCETYPELIST, "xpath").webElementToSelect().selectByVisibleText(resourceTypeName);
		assertEquals(this.page.element(Locators.RESOURCETYPELIST, "xpath").webElementToSelect().getFirstSelectedOption().getText(), resourceTypeName);
		return this;
	}

	public Resources selectStandardResourceType(
			String standardResourceTypename) throws Exception {
		waitForElement.waitForElements(Locators.STANDARDRESOURCETYPELIST, "name");
		this.page.element(Locators.STANDARDRESOURCETYPELIST, "name").webElementToSelect().selectByVisibleText(standardResourceTypename);
		return this;
	}

	public Resources clickOnSave() throws Exception {
		waitForElement.waitForElements(Locators.SAVE, "css");
		this.page.element(Locators.SAVE, "css").getDisplayedOne().click();
		return this;
	}

	public Resources createResource(String resourceName,
			String resourceAbbrivation, String resourceTypeName,
			String standardResourceTypename, String resourceFirstName,
			String resourceLastName) throws Exception {
		this.clickOnCreateNewResourceButton();
		this.enterName(resourceName);
		this.enterAbbrivation(resourceAbbrivation);
		this.selectResourceType(resourceTypeName);
		this.selectStandardResourceType(standardResourceTypename);
		this.enterFirstName(resourceFirstName);
		this.enterLastName(resourceLastName);
		this.verfiyAllUsersHaveViewRightOnResource();
		this.clickOnSave();
		this.verifyAssignUsersToResourcePage(resourceName);
		this.clickOnSave();
		this.verifyResourceIsPresentUnderResourceListPage(resourceName);
		return this;
	}

	public Resources clickOnCreateNewSubResource() throws Exception {
		waitForElement.waitForElements(Locators.CREATENEWSUBRESOURCE, "xpath");
		this.page.element(Locators.CREATENEWSUBRESOURCE, "xpath").clickUsingJSE();
		return this;
	}

	public Resources clickOnSubResources(String resourceName)
			throws Exception {
		String subResourceLink = Locators.SUBRESOURCELINKPART1 + resourceName + Locators.SUBRESOURCELINKPART2;
		WebElement element = driver.findElement(By.xpath(subResourceLink));
		this.page.element(subResourceLink, "xpath").scrollDownTillElement(element);
		Actions action = new Actions(driver);
		waitForElement.waitForElements(subResourceLink, "xpath");
		action.moveToElement(this.page.element(subResourceLink, "xpath").getOne()).perform();
		this.page.element(subResourceLink, "xpath").clickUsingJSE();
		return this;
	}

	public Resources createSubResource(String subResourceName,
			String resourceName, String resourceAbbrivation,
			String resourceTypeName, String standardResourceTypename,
			String resourceFirstName, String resourceLastName) throws Exception {
		if(this.page.element(Locators.SUBRESOURCELISTPAGE + resourceName + Locators.CLOSEBRACKETSWITHPARENTHESIS, "xpath").isElementPresent() == false){
			this.clickOnSubResources(resourceName);
		}
		this.clickOnCreateNewSubResource();
		this.enterName(subResourceName);
		this.enterAbbrivation(resourceAbbrivation);
		this.selectResourceType(resourceTypeName);
		this.selectStandardResourceType(standardResourceTypename);
		this.enterFirstName(resourceFirstName);
		this.enterLastName(resourceLastName);
		this.clickOnSave();
		return this;
	}

	public Resources createResourceWithAddress(String resourceName,
			String resourceAbbrivation, String resourceTypeName,
			String standardResourceTypename, String resourceFirstName,
			String resourceLastName,String streetAddress,String cityName,String stateName,String zipCode,String county) throws Exception {
		this.clickOnCreateNewResourceButton();
		this.enterName(resourceName);
		this.enterAbbrivation(resourceAbbrivation);
		this.selectResourceType(resourceTypeName);
		this.selectStandardResourceType(standardResourceTypename);		
		this.enterStreetAddress(streetAddress);
		this.enterCityName(cityName);
		this.selectStateName(stateName);
		this.enterZipCode(zipCode);
		this.selectCounty(county);
		this.clickOnLookupAddress();
		this.verifyMap();
		this.enterFirstName(resourceFirstName);
		this.enterLastName(resourceLastName);
		this.verfiyAllUsersHaveViewRightOnResource();
		this.clickOnSave();
		this.verifyAssignUsersToResourcePage(resourceName);
		this.clickOnSave();
		this.verifyResourceIsPresentUnderResourceListPage(resourceName);
		return this;
	}

	public Resources enterStreetAddress(String _streetAddress) throws Exception {
		waitForElement.waitForElements(Locators.STREETADDRESS, "id");
		this.page.element(Locators.STREETADDRESS, "id").clearInputValue().sendKeys(_streetAddress);
		return this;
	}

	public Resources enterCityName(String _cityName) throws Exception {
		waitForElement.waitForElements(Locators.CITYNAME, "id");
		this.page.element(Locators.CITYNAME, "id").clearInputValue().sendKeys(_cityName);
		return this;
	}

	public Resources selectStateName(String _stateName) throws Exception {
		waitForElement.waitForElements(Locators.STATENAME, "id");
		this.page.element(Locators.STATENAME, "id").webElementToSelect().selectByVisibleText(_stateName);
		return this;
	}

	public Resources enterZipCode(String _zipCode) throws Exception {
		waitForElement.waitForElements(Locators.ZIPCODE, "id");
		this.page.element(Locators.ZIPCODE, "id").clearInputValue().sendKeys(_zipCode);
		return this;
	}

	public Resources selectCounty(String _county) throws Exception {
		waitForElement.waitForElements(Locators.COUNTY, "id");
		this.page.element(Locators.COUNTY, "id").webElementToSelect().selectByVisibleText(_county);
		return this;
	}

	public Resources clickOnLookupAddress() throws Exception {
		waitForElement.waitForElements(Locators.LOOKUPADDRESS, "css");
		this.page.element(Locators.LOOKUPADDRESS, "css").clickUsingJSE();
		return this;
	}

	public Resources verifyMap() throws Exception {
		waitForElement.waitForElements(Locators.MAP, "id");
		assertTrue(this.page.element(Locators.MAP, "id").isElementPresent(),
				"MAP is not present");
		return this;
	}

	public Resources clickOnViewResource() throws Exception {
		waitForElement.waitForElements(Locators.VIEWRESOURCE, "css");
		this.page.element(Locators.VIEWRESOURCE, "css").getOne().click();
		return this;
	}

	public Resources clickOnshareWithOtherReg() throws Exception {
		waitForElement.waitForElements(Locators.SHAREWITHOTHERREGION, "css");
		if(this.page.element(Locators.SHAREWITHOTHERREGION, "css").getOne().isSelected() == false) {
			this.page.element(Locators.SHAREWITHOTHERREGION, "css").getOne().sendKeys(Keys.SPACE);
		}
		if(this.page.element(Locators.SHAREWITHOTHERREGION, "css").getOne().isSelected() == false) {
			this.page.element(Locators.SHAREWITHOTHERREGION, "css").getOne().click();
		}
		assertTrue(this.page.element(Locators.SHAREWITHOTHERREGION, "css").getOne().isSelected(), "share with other regions check box is not selected");
		return this;
	}

	public Resources createSharedResourceWithAddress(String resourceName,
			String resourceAbbrivation, String resourceTypeName,
			String standardResourceTypename, String resourceFirstName,
			String resourceLastName,String streetAddress,String cityName,String stateName,String zipCode,String county) throws Exception {
		this.clickOnCreateNewResourceButton();
		this.enterName(resourceName);
		this.enterAbbrivation(resourceAbbrivation);
		this.selectResourceType(resourceTypeName);
		this.clickOnshareWithOtherReg();
		this.selectStandardResourceType(standardResourceTypename);		
		this.enterStreetAddress(streetAddress);
		this.enterCityName(cityName);
		this.selectStateName(stateName);
		this.enterZipCode(zipCode);
		this.selectCounty(county);
		this.clickOnLookupAddress();
		this.verifyMap();
		this.enterFirstName(resourceFirstName);
		this.enterLastName(resourceLastName);
		this.verfiyAllUsersHaveViewRightOnResource();
		this.clickOnSave();
		this.verifyAssignUsersToResourcePage(resourceName);
		this.clickOnSave();
		this.verifyResourceIsPresentUnderResourceListPage(resourceName);
		return this;
	}

	public String getResourceValue(String strResourceName) throws Exception {
		String resourceValue = Locators.RESOURCEVALUE + strResourceName
				+ Locators.CLOSEBRACKETS + Locators.RESOURCEVALUE1;
		waitForElement.waitForElements(resourceValue, "xpath");
		String strStatValue = this.page.element(resourceValue, "xpath").getOne().getAttribute("href");
		String strResValueArr[] = strStatValue.split("resourceID=");
		strStatValue = strResValueArr[1];
		return strStatValue;
	}

	public Resources verfiyAllUsersHaveViewRightOnResource() throws Exception {
		waitForElement.waitForElements(Locators.VIEW_RESOURCE_UNDER_CREATE_RESOURCE, "xpath");
		assertTrue(this.page.element(Locators.VIEW_RESOURCE_UNDER_CREATE_RESOURCE, "xpath").getOne().isSelected());
		return this;
	}

	public Resources verifyResourceIsNotPresent(String resourceName) throws Exception {
		waitForElement.waitForElements(Locators.RESOURCEVALUE + resourceName + Locators.CLOSEBRACKETS, "xpath");
		assertFalse(this.page.element(Locators.RESOURCEVALUE + resourceName + Locators.CLOSEBRACKETS, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE), resourceName + " resource is displayed.");
		return this;
	}

	public Resources verifyResourceIsPresentUnderResourceListPage(String resourceName) throws Exception {
		waitForElement.waitForElements(Locators.RESOURCEVALUE + resourceName + Locators.CLOSEBRACKETS, "xpath");
		assertTrue(this.page.element(Locators.RESOURCEVALUE + resourceName + Locators.CLOSEBRACKETS, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE), resourceName + " resource is not displayed.");
		return this;
	}

	public Resources addStatusTypeAtResourceLevel(String resourceName,String[] strStatusTypeValue) throws Exception {
		this.navigateToEditResourceLevelStatusTypes(resourceName);
		this.selectStatusType(strStatusTypeValue);
		this.clickOnSave();
		return this;
	}

	public Resources editResourceName(String resourceName,String editResourceName) throws Exception {
		this.navigateToEditResourcePage(resourceName);
		this.enterName(editResourceName);
		this.clickOnSave();
		return this;
	}

	public Resources navigateToEditResourcePage(String resourceName) throws Exception {
		waitForElement.waitForElements(Locators.TABLECELLWITHTEXT + resourceName + Locators.ADD_STATUS_TYPE, "xpath");
		this.page.element(Locators.TABLECELLWITHTEXT + resourceName + Locators.ADD_STATUS_TYPE, "xpath").clickUsingJSE();
		waitForElement.waitForElements(Locators.EDIT_RESOURCE_PAGE, "xpath");
		assertTrue(this.page.element(Locators.EDIT_RESOURCE_PAGE, "xpath").isElementPresent(), Locators.EDIT_RESOURCE_PAGE + " page is not displayed.");
		return this;
	}

	public Resources navigateToEditResourceLevelStatusTypes(String resourceName) throws Exception {
		waitForElement.waitForElements(Locators.TABLECELLWITHTEXT + resourceName + Locators.ADD_STATUS_TYPE, "xpath");
		this.page.element(Locators.TABLECELLWITHTEXT + resourceName + Locators.ADD_STATUS_TYPE, "xpath").clickUsingJSE();
		return this;
	}

	public Resources selectStatusType(String[] strStatusTypeValue)
			throws Exception {
		for (int intCount = 0; intCount < strStatusTypeValue.length; intCount++) {
			waitForElement.waitForElements(Locators.STATUSTYPE+ strStatusTypeValue[intCount] + Locators.CLOSEBRACKETS, "xpath");
			this.page.element(Locators.STATUSTYPE + strStatusTypeValue[intCount] +Locators.CLOSEBRACKETS, "xpath").getOne().sendKeys(Keys.SPACE);
			if(this.page.element(Locators.STATUSTYPE + strStatusTypeValue[intCount] +Locators.CLOSEBRACKETS, "xpath").getOne().isSelected() == false) {
				this.page.element(Locators.STATUSTYPE + strStatusTypeValue[intCount] +Locators.CLOSEBRACKETS, "xpath").getOne().click();
			}
			if(this.page.element(Locators.STATUSTYPE + strStatusTypeValue[intCount] +Locators.CLOSEBRACKETS, "xpath").getOne().isSelected() == false) {
				this.page.element(Locators.STATUSTYPE + strStatusTypeValue[intCount] +Locators.CLOSEBRACKETS, "xpath").Click();
			}
			assertTrue(this.page.element(Locators.STATUSTYPE + strStatusTypeValue[intCount] +Locators.CLOSEBRACKETS, "xpath").getOne().isSelected());
		}
		return this;
	}

	public Resources clickOnStatusTypesLink(String resource) throws Exception {
		waitForElement.waitForElements(Locators.TABLECELLWITHTEXT+resource+Locators.STATUS_TYPES_LINK,"xpath");
		this.page.element(Locators.TABLECELLWITHTEXT+resource+Locators.STATUS_TYPES_LINK,"xpath").getOne().click();
		waitForElement.waitForElements(Locators.EDIT_RESOURCE_LEVEL_STATUS_TYPES,"xpath");
		return this;
	}

	public Resources selectStatusTypesAtResourceLevel(ArrayList<String> statusTypevalue) throws Exception {
		Iterator<String> iterator = statusTypevalue.iterator();
		while(iterator.hasNext()){
			String ST_value = iterator.next();
			String selectStatusType = Locators.STATUS_TYPES_UNDER_EDIT_RESOURCE_LEVEL + ST_value + Locators.CLOSEBRACKETS;
			if(this.page.element(selectStatusType, "xpath").getOne().isSelected() == false) {
				this.page.element(selectStatusType, "xpath").clickUsingJSE();
			}
			if(this.page.element(selectStatusType, "xpath").getOne().isSelected() == false) {
				this.page.element(selectStatusType, "xpath").getOne().sendKeys(Keys.SPACE);
			}
			if(this.page.element(selectStatusType, "xpath").getOne().isSelected() == false) {
				this.page.element(selectStatusType, "xpath").Click();
			}
			assertTrue(this.page.element(selectStatusType, "xpath").getOne().isSelected());
		}
		return this;
	}

	public Resources verifyAndAddStatusTypesAtResourceLevel(String resource,ArrayList<String> statusTypevalue) throws Exception {
		this.clickOnStatusTypesLink(resource);
		this.selectStatusTypesAtResourceLevel(statusTypevalue);
		this.clickOnSave();
		return this;
	}

	public String getSubResourceValue(String strSubResourceName) throws Exception {
		String resourceValue = Locators.SUBRESOURCEVALUE + strSubResourceName
				+ Locators.CLOSEBRACKETS + Locators.RESOURCEVALUE1;
		waitForElement.waitForElements(resourceValue, "xpath");
		String strStatValue = this.page.element(resourceValue, "xpath").getOne().getAttribute("href");
		String strResValueArr[] = strStatValue.split("resourceID=");
		strStatValue = strResValueArr[1];
		return strStatValue;
	}

	public Resources clickOnUsersLinkAndNavigateToAssignUsersPage(String resource) throws Exception {
		waitForElement.waitForElements(Locators.TABLE_ROW_FOLLOWED_BY_TABLE_DATA+resource+Locators.USERS_LINK, "xpath");
		this.page.element(Locators.TABLE_ROW_FOLLOWED_BY_TABLE_DATA+resource+Locators.USERS_LINK, "xpath").mouseOver();
		this.page.element(Locators.TABLE_ROW_FOLLOWED_BY_TABLE_DATA+resource+Locators.USERS_LINK, "xpath").getDisplayedOne().click();
		return this;
	}

	public Resources provideUpdateRightToUser(String username) throws Exception {
		userlist.selectUpdateStatusOfResource(username);
		return this;
	}

	public Resources provideRunReportRightToUser(String username)throws Exception {
		userlist.selectRunReportRightOnResource(username);
		return this;
	}

	public Resources provideAssociateRightToUser(String username) throws Exception {
		userlist .selectAssociateRightOnResource(username);
		return this;
	}
	public Resources provideViewRightToUser(String username) throws Exception {
		userlist .selectViewResourceCheckBox(username);
		return this;
	}

	public Resources verifyStatusTypesAddedAtResourceTypeLevelAreSelectedAndDisabled(String resource,ArrayList<String> statusTypevalue) throws Exception {
		this.clickOnStatusTypesLink(resource);
		this.verifyStatusTypesAreSelectedAndDisabled(statusTypevalue);
		return this;
	}

	public Resources verifyStatusTypesAreSelectedAndDisabled(ArrayList<String> statusTypevalue) throws Exception {
		for(int i=0;i<statusTypevalue.size();i++)
		{
			String selectStatusTypeElement = Locators.STATUS_TYPE_VALUE + statusTypevalue.get(i) + Locators.CLOSEBRACKETS;
			waitForElement.waitForElements(selectStatusTypeElement, "css");
			assertFalse(this.page.element(selectStatusTypeElement, "css").getOne().isEnabled(), selectStatusTypeElement + "is Enabled");
			assertTrue(this.page.element(selectStatusTypeElement, "css").getOne().isSelected(), selectStatusTypeElement + "is not Selected");
		}
		return this;
	}

	public Resources verifyStatusTypeAreUncheckedAndEnabled(ArrayList<String> statusTypevalue) throws Exception {
		for(int i=0;i<statusTypevalue.size();i++)
		{
			String selectStatusTypeElement = Locators.STATUS_TYPE_VALUE + statusTypevalue.get(i) + Locators.CLOSEBRACKETS;
			waitForElement.waitForElements(selectStatusTypeElement, "css");
			assertTrue(this.page.element(selectStatusTypeElement, "css").getOne().isEnabled(), selectStatusTypeElement + "is Disabled");
			assertFalse(this.page.element(selectStatusTypeElement, "css").getOne().isSelected(), selectStatusTypeElement + "is Selected");
		}
		return this;
	}

	public Resources verifyStatusTypeAreSelectedAndEnabled(String resource,ArrayList<String> statusTypevalue) throws Exception {
		this.clickOnStatusTypesLink(resource);
		for(int i=0;i<statusTypevalue.size();i++)
		{
			String selectStatusTypeElement = Locators.STATUS_TYPE_VALUE + statusTypevalue.get(i) + Locators.CLOSEBRACKETS;
			waitForElement.waitForElements(selectStatusTypeElement, "css");
			assertTrue(this.page.element(selectStatusTypeElement, "css").getOne().isEnabled(), selectStatusTypeElement + "is Disabled");
			assertTrue(this.page.element(selectStatusTypeElement, "css").getOne().isSelected(), selectStatusTypeElement + "is not Selected");
		}
		return this;
	}

	public Resources addStatusTypeFromResourceLevel(ArrayList<String> statusTypevalue) throws Exception {
		this.selectStatusTypesAtResourceLevel(statusTypevalue);
		this.clickOnSave();
		return this;
	}

	public Resources selectSingleStatusTypesAtResourceLevel(String statusTypevalue) throws Exception {
		{
			String selectStatusType = Locators.STATUS_TYPES_UNDER_EDIT_RESOURCE_LEVEL + statusTypevalue + Locators.CLOSEBRACKETS;
			this.page.element(selectStatusType, "xpath").mouseOver();
			assertTrue(this.page.element(selectStatusType, "xpath").isElementPresent());
			this.page.element(selectStatusType, "xpath").getOne().click();	

			if(this.page.element(selectStatusType, "xpath").getOne().isSelected() == false) {
				this.page.element(selectStatusType, "xpath").getOne().sendKeys(Keys.SPACE);
			}
			assertTrue(this.page.element(selectStatusType, "xpath").getOne().isSelected());
		}
		return this;
	}

	public Resources selectStatusType(ArrayList<String> statusTypevalue) throws Exception {
		Iterator<String> iterator = statusTypevalue.iterator();
		while(iterator.hasNext()) {
			String next = iterator.next();
			String selectStatusType = Locators.STATUS_TYPES_UNDER_EDIT_RESOURCE_LEVEL + next + Locators.CLOSEBRACKETS;
			if(!this.page.element(selectStatusType, "xpath").getOne().isSelected()) {
				this.page.element(selectStatusType, "xpath").getOne().sendKeys(Keys.SPACE);
			}
			if(!this.page.element(selectStatusType, "xpath").getOne().isSelected()) {
				this.page.element(selectStatusType, "xpath").clickUsingJSE();
			}
			if(!this.page.element(selectStatusType, "xpath").getOne().isSelected()) {
				this.page.element(selectStatusType, "xpath").getOne().sendKeys(Keys.ENTER);
			}
			assertTrue(this.page.element(selectStatusType, "xpath").getOne().isSelected(), selectStatusType + " is not selected.");
		}
		return this;
	}

	public Resources selectStatusTypesForResource(String resource, ArrayList<String> statusTypevalue) throws Exception {
		this.clickOnStatusTypesLink(resource);
		this.selectStatusType(statusTypevalue);
		this.clickOnSave();
		return this;
	}

	public Resources verifyStatusTypesAtResourceLevel(String resource, ArrayList<String> statusTypeNames) throws Exception {
		this.clickOnStatusTypesLink(resource);
		Iterator<String> itr=statusTypeNames.iterator();
		while(itr.hasNext())
		{
			String selectStatusTypeElement = Locators.STATUS_TYPES_AT_RESOURCE_LAVEL + itr.next() + Locators.CLOSINGTWOBRACES;
			waitForElement.waitForElements(selectStatusTypeElement, "xpath");
			assertTrue(this.page.element(selectStatusTypeElement, "xpath").isElementPresent());
			assertTrue(this.page.element(selectStatusTypeElement, "xpath").getOne().isDisplayed());
		}
		return this;
	}

	public Resources changeTheResourceType(String resourceName,String resourceTypeName) throws Exception {
		this.navigateToEditResourcePage(resourceName);
		this.selectResourceType(resourceTypeName);
		System.out.println(resourceTypeName);
		this.clickOnSave();
		return this;
	}

	public Resources clickOnCancel() throws Exception {
		waitForElement.waitForElements(Locators.CANCEL, "css");
		this.page.element(Locators.CANCEL, "css").getOne().click();
		return this;
	}

	public Resources selectAnotherResourceType(String resourceTypeName1, String resourceTypeName2) throws Exception {
		waitForElement.waitForElements(Locators.SELECTED_RESOURCETYPE + resourceTypeName1 + Locators.CLOSEBRACKETS, "xpath");
		this.page.element(Locators.SELECTED_RESOURCETYPE + resourceTypeName1 + Locators.CLOSEBRACKETS, "xpath").webElementToSelect().selectByVisibleText(resourceTypeName2);
		return this;
	}

	public Resources verifyStatusTypesAreSelectedAndDisabledAndSave(String resource, ArrayList<String> statusTypevalue) throws Exception {
		this.clickOnStatusTypesLink(resource);
		for(int i=0;i<statusTypevalue.size();i++)
		{
			String selectStatusTypeElement = Locators.STATUS_TYPE_VALUE + statusTypevalue.get(i) + Locators.CLOSEBRACKETS;
			waitForElement.waitForElements(selectStatusTypeElement, "css");
			assertFalse(this.page.element(selectStatusTypeElement, "css").getOne().isEnabled(), selectStatusTypeElement + "is Enabled");
			assertTrue(this.page.element(selectStatusTypeElement, "css").getOne().isSelected(), selectStatusTypeElement + "is not Selected");
		}
		//this.clickOnSave();
		this.clickOnCancel();
		return this;
	}

	public Resources verifyStatusTypeAreSelectedAndEnabledAndSave(String resource,ArrayList<String> statusTypevalue) throws Exception {
		this.clickOnStatusTypesLink(resource);
		for(int i=0;i<statusTypevalue.size();i++)
		{
			String selectStatusTypeElement = Locators.STATUS_TYPE_VALUE + statusTypevalue.get(i) + Locators.CLOSEBRACKETS;
			waitForElement.waitForElements(selectStatusTypeElement, "css");
			assertTrue(this.page.element(selectStatusTypeElement, "css").getOne().isEnabled(), selectStatusTypeElement + "is Disabled");
			assertTrue(this.page.element(selectStatusTypeElement, "css").getOne().isSelected(), selectStatusTypeElement + "is not Selected");
		}
		this.clickOnSave();
		return this;
	}

	public Resources deselectViewResourceRightForResourceForCorrespondingUser(String resourceName,String userName) throws Exception {
		this.clickOnUsersLinkAndNavigateToAssignUsersPage(resourceName);
		this.deselectViewResourceRightForCorrespondingUser(userName);
		this.clickOnSave();
		return this;
	}

	public Resources deselectViewResourceRightForCorrespondingUser(String userName) throws Exception {
		String viewResourcerightElement = Locators.VIEW_RESOURCE_RIGHT_ON_USER_PART1+ userName +Locators.VIEW_RESOURCE_RIGHT_ON_USER_PART2;
		waitForElement.waitForElements(viewResourcerightElement, "css");
		if(this.page.element(viewResourcerightElement, "css").getOne().isSelected()){
			this.page.element(viewResourcerightElement, "css").clickUsingJSE();
		}
		if(this.page.element(viewResourcerightElement, "css").getOne().isSelected()){
			this.page.element(viewResourcerightElement, "css").getOne().sendKeys(Keys.SPACE);
		}
		if(this.page.element(viewResourcerightElement, "css").getOne().isSelected()){
			this.page.element(viewResourcerightElement, "css").Click();
		}
		assertFalse(this.page.element(viewResourcerightElement, "css").getOne().isSelected(),viewResourcerightElement + "is selected" );
		return this;
	}

	public Resources verifyAssignUsersToResourcePage(String resourceName) throws Exception {
		waitForElement.waitForElements(Locators.ASSIGN_USERS_TO_RESOURCE_PAGE + resourceName + Locators.CLOSEBRACKETS, "xpath");
		assertTrue(this.page.element(Locators.ASSIGN_USERS_TO_RESOURCE_PAGE + resourceName + Locators.CLOSEBRACKETS, "xpath").isElementPresent());
		return this;
	}

	public Resources createResourceByUser(String resourceName,
			String resourceAbbrivation, String resourceTypeName,
			String standardResourceTypename, String resourceFirstName,
			String resourceLastName,String streetAddress,String cityName,String stateName,String zipCode,String county) throws Exception {
		this.clickOnCreateNewResourceButton();
		this.enterName(resourceName);
		this.enterAbbrivation(resourceAbbrivation);
		this.selectResourceType(resourceTypeName);
		this.selectStandardResourceType(standardResourceTypename);		
		this.enterStreetAddress(streetAddress);
		this.enterCityName(cityName);
		this.selectStateName(stateName);
		this.enterZipCode(zipCode);
		this.selectCounty(county);
		this.clickOnLookupAddress();
		this.verifyMap();
		this.enterFirstName(resourceFirstName);
		this.enterLastName(resourceLastName);
		this.verfiyAllUsersHaveViewRightOnResource();
		this.clickOnSave();
		this.verifyResourceIsPresentUnderResourceListPage(resourceName);
		return this;
	}

	public Resources navigateTo_AssignUsersToResourcePage()throws Exception{
		waitForElement.waitForElements(Locators.USERLINK_CORRESPONDING_TO_FIRST_RESOURCE, "xpath");
		this.page.element(Locators.USERLINK_CORRESPONDING_TO_FIRST_RESOURCE, "xpath").getDisplayedOne().click();
		return this;
	}

	public Resources verifyOnlyUpdateStatusRightSelectedForResourceCorrespondingToUserIsNotSaved(String resourceName,String userName) throws Exception {
		this.clickOnUsersLinkAndNavigateToAssignUsersPage(resourceName);
		this.deselectViewResourceRightForCorrespondingUser(userName);
		this.deselectAssociatedWithRightForResourceForCorrespondingUser(userName);
		this.deselectRunReportRightForResourceForCorrespondingUser(userName);
		this.provideUpdateRightToUser(userName);
		this.clickOnSave();
		this.verifyValidationMessageIsDisplayed(userName);
		this.clickOnCancel();
		return this;
	}

	public Resources deselectAssociatedWithRightForResourceForCorrespondingUser(String userName) throws Exception {
		String associatedWithRightElement = Locators.ASSOCIATED_WITH_RIGHT_ON_USER_PART1+ userName +Locators.ASSOCIATED_WITH_RIGHT_ON_USER_PART2;
		waitForElement.waitForElements(associatedWithRightElement, "css");
		if(this.page.element(associatedWithRightElement, "css").getOne().isSelected()){
			this.page.element(associatedWithRightElement, "css").clickUsingJSE();
		}
		if(this.page.element(associatedWithRightElement, "css").getOne().isSelected()){
			this.page.element(associatedWithRightElement, "css").getOne().sendKeys(Keys.SPACE);
		}
		if(this.page.element(associatedWithRightElement, "css").getOne().isSelected()){
			this.page.element(associatedWithRightElement, "css").Click();
		}
		assertFalse(this.page.element(associatedWithRightElement, "css").getOne().isSelected(),associatedWithRightElement + "is selected" );
		return this;
	}

	public Resources deselectRunReportRightForResourceForCorrespondingUser(String userName) throws Exception {
		String runReportRightElement = Locators.RUNREPORT_RIGHT_ON_USER_PART1+ userName +Locators.RUNREPORT_RIGHT_ON_USER_PART2;
		waitForElement.waitForElements(runReportRightElement, "css");
		if(this.page.element(runReportRightElement, "css").getOne().isSelected()){
			this.page.element(runReportRightElement, "css").clickUsingJSE();
		}
		if(this.page.element(runReportRightElement, "css").getOne().isSelected()){
			this.page.element(runReportRightElement, "css").getOne().sendKeys(Keys.SPACE);
		}
		if(this.page.element(runReportRightElement, "css").getOne().isSelected()){
			this.page.element(runReportRightElement, "css").Click();
		}
		assertFalse(this.page.element(runReportRightElement, "css").getOne().isSelected(),runReportRightElement + "is selected" );
		return this;
	}

	public Resources deselectUpdateStatusRightForResourceForCorrespondingUser(String userName) throws Exception {
		String updateStatusRightElement = Locators.UPDATE_RIGHT_ON_USER_PART1+ userName +Locators.UPDATE_RIGHT_ON_USER_PART2;
		waitForElement.waitForElements(updateStatusRightElement, "css");
		if(this.page.element(updateStatusRightElement, "css").getOne().isSelected()){
			this.page.element(updateStatusRightElement, "css").clickUsingJSE();
		}
		if(this.page.element(updateStatusRightElement, "css").getOne().isSelected()){
			this.page.element(updateStatusRightElement, "css").getOne().sendKeys(Keys.SPACE);
		}
		if(this.page.element(updateStatusRightElement, "css").getOne().isSelected()){
			this.page.element(updateStatusRightElement, "css").Click();
		}
		assertFalse(this.page.element(updateStatusRightElement, "css").getOne().isSelected(),updateStatusRightElement + "is selected" );
		return this;
	}	

	public Resources verifyValidationMessageIsDisplayed(String userName) throws Exception {
		String emrErrorTitleElement = Locators.EMR_ERROR_TITLE;
		String emrErrorElement = Locators.EMR_ERROR;
		waitForElement.waitForElements(emrErrorTitleElement, "xpath");
		assertTrue(this.page.element(emrErrorTitleElement, "xpath").getOne().isDisplayed(),emrErrorTitleElement + "is not Displayed" );
		assertTrue(this.page.element(emrErrorElement, "xpath").getOne().isDisplayed(),emrErrorElement + "is not Displayed" );
		return this;
	}

	public Resources verifyOnlyRunReportsRightSelectedForResourceCorrespondingToUserIsNotSaved(String resourceName,String userName) throws Exception {
		this.clickOnUsersLinkAndNavigateToAssignUsersPage(resourceName);
		this.deselectViewResourceRightForCorrespondingUser(userName);
		this.deselectAssociatedWithRightForResourceForCorrespondingUser(userName);
		this.deselectUpdateStatusRightForResourceForCorrespondingUser(userName);
		this.provideRunReportRightToUser(userName);
		this.clickOnSave();
		this.verifyValidationMessageIsDisplayed(userName);
		this.clickOnCancel();
		return this;
	}

	public Resources verifyOnlyAssociatedWithRightSelectedForResourceCorrespondingToUserIsNotSaved(String resourceName,String userName) throws Exception {
		this.clickOnUsersLinkAndNavigateToAssignUsersPage(resourceName);
		this.deselectViewResourceRightForCorrespondingUser(userName);
		this.deselectUpdateStatusRightForResourceForCorrespondingUser(userName);
		this.deselectRunReportRightForResourceForCorrespondingUser(userName);
		this.provideAssociateRightToUser(userName);
		this.clickOnSave();
		this.verifyValidationMessageIsDisplayed(userName);
		this.clickOnCancel();
		return this;
	}

	public Resources verifyAllThreeRightSelectedExpectViewResourceRightForResourceCorrespondingToUserIsNotSaved(String resourceName,String userName) throws Exception {
		this.clickOnUsersLinkAndNavigateToAssignUsersPage(resourceName);
		this.deselectViewResourceRightForCorrespondingUser(userName);
		this.provideUpdateRightToUser(userName);
		this.provideAssociateRightToUser(userName);
		this.provideRunReportRightToUser(userName);
		this.clickOnSave();
		this.verifyValidationMessageIsDisplayed(userName);
		this.clickOnCancel();
		return this;
	}

	public Resources verifyAllThreeRightSelectedIncludingViewResourceRightForResourceCorrespondingToUserIsSaved(String resourceName,String userName) throws Exception {
		this.clickOnUsersLinkAndNavigateToAssignUsersPage(resourceName);
		this.provideViewRightToUser(userName);
		this.provideUpdateRightToUser(userName);
		this.provideAssociateRightToUser(userName);
		this.provideRunReportRightToUser(userName);
		this.clickOnSave();
		return this;
	}

	public Resources verifyUserWithViewResourceAndUpdateStatusRightIsSaved(String resourceName,String userName) throws Exception {
		this.clickOnUsersLinkAndNavigateToAssignUsersPage(resourceName);
		this.provideViewRightToUser(userName);
		this.provideUpdateRightToUser(userName);
		this.deselectAssociatedWithRightForResourceForCorrespondingUser(userName);
		this.deselectRunReportRightForResourceForCorrespondingUser(userName);
		this.clickOnSave();
		return this;
	}

	public Resources verifyUserWithViewResourceAndRunReportsRightIsSaved(String resourceName,String userName) throws Exception {
		this.clickOnUsersLinkAndNavigateToAssignUsersPage(resourceName);
		this.provideViewRightToUser(userName);
		this.provideRunReportRightToUser(userName);
		this.deselectAssociatedWithRightForResourceForCorrespondingUser(userName);
		this.deselectUpdateStatusRightForResourceForCorrespondingUser(userName);
		this.clickOnSave();
		return this;
	}

	public Resources verifyUserWithViewResourceAndAssociatedWithRightIsSaved(String resourceName,String userName) throws Exception {
		this.clickOnUsersLinkAndNavigateToAssignUsersPage(resourceName);
		this.provideViewRightToUser(userName);
		this.provideAssociateRightToUser(userName);
		this.deselectRunReportRightForResourceForCorrespondingUser(userName);
		this.deselectUpdateStatusRightForResourceForCorrespondingUser(userName);
		this.clickOnSave();
		return this;
	}

	public Resources verifyAbbreviation_InList(String resourceName, String Abbreviation) throws Exception {
		waitForElement.waitForElements(Locators.RESOURCEVALUE + resourceName + Locators.ABBREVIATION_AND_RT + Abbreviation + Locators.CLOSEBRACKETS, "xpath");
		assertTrue(this.page.element(Locators.RESOURCEVALUE + resourceName + Locators.ABBREVIATION_AND_RT + Abbreviation + Locators.CLOSEBRACKETS, "xpath").isElementPresent(), resourceName + " resource is not displayed.");
		return this;
	}
	
	public Resources editResourceMandatoryDetails(String resourceName, String edit_resourceName, String edit_Abb, String edit_Std_RTName) throws Exception {
		this.navigateToEditResourcePage(resourceName);
		this.enterName(edit_resourceName);
		this.enterAbbrivation(edit_Abb);
		this.selectStandardResourceType(edit_Std_RTName);
		this.clickOnSave();
		this.verifyResourceIsPresentUnderResourceListPage(edit_resourceName);
		this.verifyAbbreviation_InList(edit_resourceName, edit_Abb);
		return this;
	}
	
	public Resources updateResourceNameAndAbbreviation(String edit_resourceName, String edit_Abb) throws Exception {
		this.enterName(edit_resourceName);
		this.enterAbbrivation(edit_Abb);
		this.clickOnSave();
		return this;
	}
	
	public Resources verifyCreateNewResourceOptionNotAvailable() throws Exception {
		assertFalse(this.page.element(Locators.CREATENEWRESOURCE, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE), "create new resource is displayed.");
		return this;
	}
	
}