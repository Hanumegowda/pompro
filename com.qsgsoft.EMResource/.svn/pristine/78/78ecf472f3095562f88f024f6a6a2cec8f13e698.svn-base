package EMR.pages;

import static org.testng.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import qaFramework.WaitTimeConstants;
import qaFramework.UserDefinedFunctions.WaitForElement;
import qaFramework.pageObject.PageObject;
import EMR.Locators.ResourceTypes.Locators;

public class ResourceTypes extends PageObject {

	WebDriver driver;
	WaitForElement waitForElement ;
	WebDriverWait wait;

	public ResourceTypes(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		waitForElement =  new WaitForElement(this.driver);
		wait = new WebDriverWait(this.driver, WaitTimeConstants.WAIT_TIME_LONG);
	}

	public ResourceTypes clickOnCreateNewResourceType() throws Exception {
		waitForElement.waitForElements(Locators.CREATENEWRESOURCETYPE, "xpath");
		this.page.element(Locators.CREATENEWRESOURCETYPE, "xpath").getOne().click();
		return this;
	}

	public ResourceTypes enterResourceTypesName(String resourceTypesName)
			throws Exception {
		waitForElement.waitForElements(Locators.RESOURCETYPESNAME, "name");
		this.page.element(Locators.RESOURCETYPESNAME, "name").clearInputValue().sendKeys(resourceTypesName);
		System.out.println(resourceTypesName);
		return this;
	}

	public ResourceTypes enterResourceTypesDescription(
			String resTypeDescription) throws Exception {
		waitForElement.waitForElements(Locators.RESOURCETYPEDESCRIPTION, "name");
		this.page.element(Locators.RESOURCETYPEDESCRIPTION, "name").getOne().sendKeys(resTypeDescription);;
		return this;
	}

	public ResourceTypes selectStatusType(String[] statusTypeValue)
			throws Exception {
		for (int intCount = 0; intCount < statusTypeValue.length; intCount++) {
			waitForElement.waitForElements(Locators.STATUSTYPE+ statusTypeValue[intCount] + Locators.CLOSEBRACKETS, "xpath");
			this.page.element(Locators.STATUSTYPE + statusTypeValue[intCount] +Locators.CLOSEBRACKETS, "xpath").getOne().sendKeys(Keys.SPACE);
			if(this.page.element(Locators.STATUSTYPE + statusTypeValue[intCount] +Locators.CLOSEBRACKETS, "xpath").getOne().isSelected() == false) {
				this.page.element(Locators.STATUSTYPE + statusTypeValue[intCount] +Locators.CLOSEBRACKETS, "xpath").getOne().click();
			}
			if(this.page.element(Locators.STATUSTYPE + statusTypeValue[intCount] +Locators.CLOSEBRACKETS, "xpath").getOne().isSelected() == false) {
				this.page.element(Locators.STATUSTYPE + statusTypeValue[intCount] +Locators.CLOSEBRACKETS, "xpath").Click();
			}
			assertTrue(this.page.element(Locators.STATUSTYPE + statusTypeValue[intCount] +Locators.CLOSEBRACKETS, "xpath").getOne().isSelected());
		}
		return this;
	}

	public ResourceTypes clickOnSaveButton() throws Exception {
		waitForElement.waitForElements(Locators.SAVEBUTTON, "css");
		this.page.element(Locators.SAVEBUTTON, "css").getOne().click();
		return this;
	}

	public ResourceTypes createResourceType(String resourceTypesName,
			String[] statusTypes) throws Exception {
		this.clickOnCreateNewResourceType();
		this.enterResourceTypesName(resourceTypesName);
		this.selectStatusType(statusTypes);
		this.clickOnSaveButton();
		return this;
	}

	public String getResourceTypeValue(String resourceType) throws Exception {
		String RTValue = "";
		waitForElement.waitForElements(Locators.RESOURCETYPEVALUEPART1 + resourceType + Locators.RESOURCETYPEVALUEPART2, "xpath");
		String RTValueArr[] = this.page.element(Locators.RESOURCETYPEVALUEPART1 + resourceType + Locators.RESOURCETYPEVALUEPART2, "xpath").getOne().getAttribute("href").split("resourceTypeID=");
		RTValue = RTValueArr[1];
		return RTValue;
	}

	public ResourceTypes selectSubResourceTypeCheckBox() throws Exception {
		waitForElement.waitForElements(Locators.SUBRESOURCETYPEBUTTON, "css");
		this.page.element(Locators.SUBRESOURCETYPEBUTTON, "css").getOne().click();
		return this;
	}

	public ResourceTypes createSubResourceType(String resourceTypeName,
			String[] statusTypeValue) throws Exception {
		this.clickOnCreateNewResourceType();
		this.enterResourceTypesName(resourceTypeName);
		this.selectSubResourceTypeCheckBox();
		this.selectStatusType(statusTypeValue);
		this.clickOnSaveButton();
		return this;
	}

	public ResourceTypes selectStatusType(List<String> statusTypeValue) throws Exception {
		Iterator<String> iterator = statusTypeValue.iterator();
		while(iterator.hasNext()) {
			String value=iterator.next();
			String statusTypevalues = Locators.STATUSTYPE+ value + Locators.CLOSEBRACKETS;
			waitForElement.waitForElements(statusTypevalues, "xpath");
			if(this.page.element(statusTypevalues, "xpath").getOne().isSelected()==false) {
				this.page.element(statusTypevalues, "xpath").mouseOver();
				this.page.element(statusTypevalues, "xpath").Click();
			}
			if(this.page.element(statusTypevalues, "xpath").getOne().isSelected()==false) {
				this.page.element(statusTypevalues, "xpath").getDisplayedOne().sendKeys(Keys.SPACE);
			}
			if(this.page.element(statusTypevalues, "xpath").getOne().isSelected()==false) {
				this.page.element(statusTypevalues, "xpath").clickUsingJSE();
			}
			assertTrue(this.page.element(statusTypevalues, "xpath").getOne().isSelected(), statusTypevalues + " is not selected");
		}
		return this;
	}

	public ResourceTypes createResourceType(String resourceTypesName,
			List<String> allStatusTypesValues) throws Exception {
		this.clickOnCreateNewResourceType();
		this.enterResourceTypesName(resourceTypesName);
		this.selectStatusType(allStatusTypesValues);
		this.clickOnSaveButton();
		return this;
	}

	public ResourceTypes VerifyResourceTypeInList(String resourceType) throws Exception {
		waitForElement.waitForElements(Locators.RESOURCETYPENAME+resourceType+Locators.CLOSEBRACKETS, "xpath");
		assertTrue(this.page.element(Locators.RESOURCETYPENAME+resourceType+Locators.CLOSEBRACKETS, "xpath").isElementPresent());
		return this;
	}

	public ResourceTypes clickOnEdit(String resourceType) throws Exception {
		waitForElement.waitForElements(Locators.RESOURCETYPEVALUEPART1 + resourceType + Locators.RESOURCETYPEVALUEPART2, "xpath");
		this.page.element(Locators.RESOURCETYPEVALUEPART1 + resourceType + Locators.RESOURCETYPEVALUEPART2, "xpath").getOne().click();
		waitForElement.waitForElements(Locators.EDIT_RESOURCE_TYPE_PAGE, "xpath");
		return this;
	}

	public ResourceTypes addStatusTypesToResourceType(String resourceType,List<String> statusTypeValue) throws Exception {
		this.clickOnEdit(resourceType);
		this.selectStatusType(statusTypeValue);
		this.clickOnSaveButton();
		return this;
	}

	public ResourceTypes verifyStatusTypesUnderCreateNewResourceTypePage(List<String> statusTypeValue)
			throws Exception {
		for (int intCount = 0; intCount < statusTypeValue.size(); intCount++) {
			String statusTypevalues = Locators.STATUSTYPE+ statusTypeValue.get(intCount) + Locators.CLOSEBRACKETS;
			waitForElement.waitForElements(statusTypevalues, "xpath");
			this.page.element(statusTypevalues, "xpath").mouseOver();	
			assertTrue(this.page.element(statusTypevalues, "xpath").isElementPresent());
			assertTrue(this.page.element(statusTypevalues, "xpath").getOne().isDisplayed());
		}
		return this;
	}

	public ResourceTypes verifyStatusTypesDisplayedUnderCreateNewResourceTypePage(List<String> statusTypeValue)
			throws Exception {
		this.clickOnCreateNewResourceType();
		this.verifyStatusTypesUnderCreateNewResourceTypePage(statusTypeValue);
		return this;
	}

	public ResourceTypes createResourceType(String resourceTypesName, ArrayList<String> statusTypes) throws Exception {
		this.clickOnCreateNewResourceType();
		this.enterResourceTypesName(resourceTypesName);
		this.selectStatusType(statusTypes);
		this.clickOnSaveButton();
		this.VerifyResourceTypeInList(resourceTypesName);
		return this;
	}

	public String getSubResourceTypeValue(String subResourceType) throws Exception {
		String RTValue = "";
		waitForElement.waitForElements(Locators.RESOURCETYPEVALUEPART1 + subResourceType + Locators.RESOURCETYPEVALUEPART2, "xpath");
		String RTValueArr[] = this.page.element(Locators.RESOURCETYPEVALUEPART1 + subResourceType + Locators.RESOURCETYPEVALUEPART2, "xpath").getOne().getAttribute("href").split("resourceTypeID=");
		RTValue = RTValueArr[1];
		return RTValue;
	}
	public ResourceTypes selectDefaultMultiStatusType(String statusTypeName) throws Exception {
		waitForElement.waitForElements(Locators.DEFAULT_STATUSTYPE_ID ,"xpath");
		this.page.element(Locators.DEFAULT_STATUSTYPE_ID ,"xpath").webElementToSelect().selectByVisibleText(statusTypeName);
		return this;

	}

	public ResourceTypes editResorceTypeAndSelectDefaultMultiStatusType(String resourceType,String statusTypeName) throws Exception {
		this.clickOnEdit(resourceType);
		this.selectDefaultMultiStatusType(statusTypeName);
		this.clickOnSaveButton();
		return this;
	}

	public ResourceTypes editResorceTypeMandatoryDataDeselectAndSelectStatusTypesAndSave(String resourceType,String resourceTypesName,List<String> statusTypeValueToDeselect,List<String> statusTypeValueToSelect) throws Exception {
		this.clickOnEdit(resourceType);
		this.enterResourceTypesName(resourceTypesName);
		this.deSelectStatusType(statusTypeValueToDeselect);
		this.selectStatusType(statusTypeValueToSelect);
		this.clickOnSaveButton();
		return this;
	}

	public ResourceTypes deSelectStatusType(List<String> statusTypeValue) throws Exception {
		Iterator<String> iterator=statusTypeValue.iterator();
		while(iterator.hasNext()) {
			String value=iterator.next();
			String statusTypevalues = Locators.STATUSTYPE+ value + Locators.CLOSEBRACKETS;
			waitForElement.waitForElements(statusTypevalues, "xpath");
			if(this.page.element(statusTypevalues, "xpath").getOne().isSelected()) {
				this.page.element(statusTypevalues, "xpath").mouseOver();
				this.page.element(statusTypevalues, "xpath").clickUsingJSE();
			}
			if(this.page.element(statusTypevalues, "xpath").getOne().isSelected()) {
				this.page.element(statusTypevalues, "xpath").mouseOver();
				this.page.element(statusTypevalues, "xpath").getDisplayedOne().sendKeys(Keys.SPACE);
			}
			if(this.page.element(statusTypevalues, "xpath").getOne().isSelected()) {
				this.page.element(statusTypevalues, "xpath").mouseOver();
				this.page.element(statusTypevalues, "xpath").getDisplayedOne().sendKeys(Keys.ENTER);
			}
			assertFalse(this.page.element(statusTypevalues, "xpath").getOne().isSelected(), statusTypevalues + " is not deselected.");
		}
		return this;
	}
	
	public ResourceTypes removeStatusTypesFromResourceType(String resourceType,List<String> statusTypeValuesToDeselect) throws Exception {
		this.clickOnEdit(resourceType);
		this.deSelectStatusType(statusTypeValuesToDeselect);
		this.clickOnSaveButton();
		return this;
	}
	
	public ResourceTypes editResourceTypeAndSelectStatusTypes(String resourceType,List<String> statusTypeValuesToselect) throws Exception {
		this.clickOnEdit(resourceType);
		this.selectStatusType(statusTypeValuesToselect);
		this.clickOnSaveButton();
		return this;
	}
	
	public ResourceTypes selectStatusType(String statusTypeValue)
			throws Exception {
			waitForElement.waitForElements(Locators.STATUSTYPE+ statusTypeValue + Locators.CLOSEBRACKETS, "xpath");
			this.page.element(Locators.STATUSTYPE + statusTypeValue +Locators.CLOSEBRACKETS, "xpath").getOne().sendKeys(Keys.SPACE);
			if(this.page.element(Locators.STATUSTYPE + statusTypeValue +Locators.CLOSEBRACKETS, "xpath").getOne().isSelected() == false) {
				this.page.element(Locators.STATUSTYPE + statusTypeValue +Locators.CLOSEBRACKETS, "xpath").getOne().click();
			}
			if(this.page.element(Locators.STATUSTYPE + statusTypeValue +Locators.CLOSEBRACKETS, "xpath").getOne().isSelected() == false) {
				this.page.element(Locators.STATUSTYPE + statusTypeValue +Locators.CLOSEBRACKETS, "xpath").Click();
			}
			assertTrue(this.page.element(Locators.STATUSTYPE + statusTypeValue +Locators.CLOSEBRACKETS, "xpath").getOne().isSelected(), Locators.STATUSTYPE + statusTypeValue +Locators.CLOSEBRACKETS + " is selected.");
		return this;
	}
	
	public ResourceTypes addStatusTypesToResourceType(String resourceType, String statusTypeValue) throws Exception {
		this.clickOnEdit(resourceType);
		this.selectStatusType(statusTypeValue);
		this.clickOnSaveButton();
		return this;
	}
	
	public ResourceTypes deSelectActiveCheckBox() throws Exception {
			String checkboxvalues = Locators.ACTIVE_CHECKBOX;
			waitForElement.waitForElements(checkboxvalues, "xpath");
			if(this.page.element(checkboxvalues, "xpath").getOne().isSelected()) {
				this.page.element(checkboxvalues, "xpath").mouseOver();
				this.page.element(checkboxvalues, "xpath").clickUsingJSE();
			}
			if(this.page.element(checkboxvalues, "xpath").getOne().isSelected()) {
				this.page.element(checkboxvalues, "xpath").mouseOver();
				this.page.element(checkboxvalues, "xpath").getDisplayedOne().sendKeys(Keys.SPACE);
			}
			if(this.page.element(checkboxvalues, "xpath").getOne().isSelected()) {
				this.page.element(checkboxvalues, "xpath").mouseOver();
				this.page.element(checkboxvalues, "xpath").getDisplayedOne().sendKeys(Keys.ENTER);
			}
			assertFalse(this.page.element(checkboxvalues, "xpath").getOne().isSelected(), checkboxvalues + " is not deselected.");
			return this;
		}
		
	
	public ResourceTypes deActivateResourceType(String resourceType) throws Exception {
		this.clickOnEdit(resourceType);
		this.deSelectActiveCheckBox();
		this.clickOnSaveButton();
		return this;
	}
	
	public ResourceTypes reSelectActiveCheckBox() throws Exception {
		String checkboxvalues = Locators.ACTIVE_CHECKBOX;
		waitForElement.waitForElements(checkboxvalues, "xpath");
		if(this.page.element(checkboxvalues, "xpath").getOne().isSelected() == false) {
			this.page.element(checkboxvalues, "xpath").mouseOver();
			this.page.element(checkboxvalues, "xpath").clickUsingJSE();
		}
		if(this.page.element(checkboxvalues, "xpath").getOne().isSelected() == false) {
			this.page.element(checkboxvalues, "xpath").mouseOver();
			this.page.element(checkboxvalues, "xpath").getDisplayedOne().sendKeys(Keys.SPACE);
		}
		if(this.page.element(checkboxvalues, "xpath").getOne().isSelected() == false) {
			this.page.element(checkboxvalues, "xpath").mouseOver();
			this.page.element(checkboxvalues, "xpath").getDisplayedOne().sendKeys(Keys.ENTER);
		}
		assertTrue(this.page.element(checkboxvalues, "xpath").getOne().isSelected(), checkboxvalues + " is selected.");
		return this;
	}
	
	public ResourceTypes selectIncludeAllCheckBox() throws Exception {
		String checkboxvalues = Locators.INCLUDEALL_CHECKBOX;
		waitForElement.waitForElements(checkboxvalues, "xpath");
		if(this.page.element(checkboxvalues, "xpath").getOne().isSelected() == false) {
			this.page.element(checkboxvalues, "xpath").mouseOver();
			this.page.element(checkboxvalues, "xpath").clickUsingJSE();
		}
		if(this.page.element(checkboxvalues, "xpath").getOne().isSelected() == false) {
			this.page.element(checkboxvalues, "xpath").mouseOver();
			this.page.element(checkboxvalues, "xpath").getDisplayedOne().sendKeys(Keys.SPACE);
		}
		if(this.page.element(checkboxvalues, "xpath").getOne().isSelected() == false) {
			this.page.element(checkboxvalues, "xpath").mouseOver();
			this.page.element(checkboxvalues, "xpath").getDisplayedOne().sendKeys(Keys.ENTER);
		}
		assertTrue(this.page.element(checkboxvalues, "xpath").getOne().isSelected(), checkboxvalues + " is selected.");
		return this;
	}
	
	public ResourceTypes reActivateResourceType(String resourceType) throws Exception {
		this.selectIncludeAllCheckBox();
		this.clickOnEdit(resourceType);
		this.reSelectActiveCheckBox();
		this.clickOnSaveButton();
		return this;
	}
	
	public ResourceTypes verifyResourceTypeNameRetained(String resourceTypesName) throws Exception {
		waitForElement.waitForElements(Locators.RESOURCETYPESNAME, "name");
		assertEquals(this.page.element(Locators.RESOURCETYPESNAME, "name").getDisplayedOne().getAttribute("value"), resourceTypesName);
		return this;
	}
	
	public ResourceTypes verifyStatusTypesUnderResourceType(ArrayList<String> selected_statusTypeValue) throws Exception {
		Iterator<String> iterator = selected_statusTypeValue.iterator();
		while(iterator.hasNext()) {
			String value=iterator.next();
			String statusTypevalues = Locators.STATUSTYPE+ value + Locators.CLOSEBRACKETS;
			waitForElement.waitForElements(statusTypevalues, "xpath");
			assertTrue(this.page.element(statusTypevalues, "xpath").getOne().isSelected(), statusTypevalues + " is not selected");
		}
		return this;
	}
	
	public ResourceTypes verifyResourceTypeDetailsAreRetained(String resourceTypesName, ArrayList<String> selected_statusTypeValue) throws Exception {
		this.verifyResourceTypeNameRetained(resourceTypesName);
		this.verifyStatusTypesUnderResourceType(selected_statusTypeValue);
		return this;
	}
	
	public ResourceTypes verifyStatusTypes_NotSelectedForResourceType(ArrayList<String> statusTypeValues) throws Exception {
		Iterator<String> iterator = statusTypeValues.iterator();
		while(iterator.hasNext()) {
			String value=iterator.next();
			String statusTypevalues = Locators.STATUSTYPE+ value + Locators.CLOSEBRACKETS;
			waitForElement.waitForElements(statusTypevalues, "xpath");
			assertFalse(this.page.element(statusTypevalues, "xpath").getOne().isSelected(), statusTypevalues + " is not selected");
		}
		return this;
	}
	
	public ResourceTypes cancelAndReturnToResourceTypeList() throws Exception {
		waitForElement.waitForElements(Locators.CANCEL, "css");
		this.page.element(Locators.CANCEL, "css").getDisplayedOne().click();
		waitForElement.waitForElements(Locators.RESOURCE_TYPE_LIST_PAGE, "xpath");
		if(!this.page.element(Locators.RESOURCE_TYPE_LIST_PAGE, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE)) {
			this.page.element(Locators.CANCEL, "css").clickUsingJSE();
		}
		assertTrue(this.page.element(Locators.RESOURCE_TYPE_LIST_PAGE, "xpath").isElementPresent(), Locators.RESOURCE_TYPE_LIST_PAGE+ " is not displayed.");
		return this;
	}
}