package EMR.pages;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import qaFramework.WaitTimeConstants;
import qaFramework.UserDefinedFunctions.Date_Time_settings;
import qaFramework.UserDefinedFunctions.WaitForElement;
import qaFramework.pageObject.PageObject;
import EMR.Locators.Map.Locators;

public class Map extends PageObject {

	WebDriver driver;
	WaitForElement waitForElement ;
	Login login;
	Shared navigateTo;
	Date_Time_settings dts;
	View view;

	public Map(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		waitForElement = new WaitForElement(this.driver);
		navigateTo = new Shared(this.driver);
		dts = new Date_Time_settings();
		view = new View(this.driver);
	}

	public Map selectResourceNameInFindResourceDropdown(String resourceName)
			throws Exception {
		waitForElement.waitForElements(Locators.FINDRESOURCEDROPDOWN, "id");
		this.page.element(Locators.FINDRESOURCEDROPDOWN, "id").webElementToSelect().selectByVisibleText(resourceName);
		assertTrue(this.page.element(Locators.FINDRESOURCEDROPDOWN, "id").webElementToSelect().getFirstSelectedOption().getText().equals(resourceName));
		return this;
	}

	public Map verifyUpdateStatusInPopupWindow()
			throws Exception {
		waitForElement.waitForElements(Locators.UPDATESTATUS, "linktext");
		assertTrue(this.page.element(Locators.UPDATESTATUS, "linktext").getOne().isDisplayed(), "Update status is not present in pop window.");
		return this;
	}

	public Map clickUpdateStatusInPopupWindow() throws Exception {
		waitForElement.waitForElements(Locators.UPDATESTATUS, "linktext");
		this.page.element(Locators.UPDATESTATUS, "linktext").getOne().click();
		return this;
	}

	public Map verifyStatusTypesInPopupWindow(String[] strStatusTypesName)
			throws Exception {
		waitForElement.waitForElements(Locators.TEXTOFPOPUPINMAP, "css");

		String strStatusTypeNam = this.page
				.element(Locators.TEXTOFPOPUPINMAP, "css").getOne()
				.getText();
		for (int i = 0; i < strStatusTypesName.length; i++) {
			assertTrue(strStatusTypeNam.contains(strStatusTypesName[i]));
		}
		return this;
	}

	public Map verStatusTypesNotInPopupWindow(String[] strStatusTypesValue)
			throws Exception {
		waitForElement.waitForElements(Locators.TEXTOFPOPUPINMAP, "css");

		String strStatusTypeNam = this.page
				.element(Locators.TEXTOFPOPUPINMAP, "css").getOne()
				.getText();
		for (int i = 0; i < strStatusTypesValue.length; i++) {
			assertFalse(strStatusTypeNam.contains(strStatusTypesValue[i]));
		}
		return this;
	}

	public Map verifyUpdateValuesInPopupWindow(String[] strUpdatedVal) throws Exception {
		waitForElement.waitForElements(Locators.SPANWITHTEXT + strUpdatedVal + Locators.CLOSEBRACKET, "xpath");
		for(int i = 0; i<strUpdatedVal.length; i++) {
			assertTrue(this.page.element(Locators.SPANWITHTEXT + strUpdatedVal + Locators.CLOSEBRACKET, "xpath").isElementPresent());
		}
		return this;
	}

	public Map verifyViewInfoInPopupWindow()
			throws Exception {
		waitForElement.waitForElements(Locators.VIEWINFO, "linktext");
		assertTrue(this.page.element(Locators.VIEWINFO, "linktext").getOne().isDisplayed(), "View Info is not present in pop window.");
		return this;
	}

	public Map clickViewInfoInPopupWindow()
			throws Exception {
		waitForElement.waitForElements(Locators.VIEWINFO, "linktext");
		assertTrue(this.page.element(Locators.VIEWINFO, "linktext").getOne().isDisplayed(), "View Info is not present in pop window.");
		this.page.element(Locators.VIEWINFO, "linktext").getOne().click();
		return this;
	}

	public Map verifyViewResDetailScreenIsDisplayedWithResName(String ResourceName) throws Exception {
		waitForElement.waitForElements(Locators.HEADER, "xpath");
		assertTrue(this.page.element(Locators.HEADER, "xpath").getOne().isDisplayed());
		assertEquals(ResourceName, this.page.element(Locators.RESOURCENAME, "id")
				.getOne().getText(), "Resource name not displayed");
		return this;
	}

	public Map verifyStatusTypesUnderSection(String[] strStatusType, String strSection) throws Exception {
		for (int i = 0; i < strStatusType.length; i++) {
			waitForElement.waitForElements(Locators.SECTIONINVIEWRESOURCEDETAILPART1 + strStatusType[i] + Locators.CLOSEBRACKET + Locators.SECTIONINVIEWRESOURCEDETAILPART2 + strSection + Locators.CLOSEBRACKET, "xpath");
			assertTrue(this.page.element(Locators.SECTIONINVIEWRESOURCEDETAILPART1 + strStatusType[i] + Locators.CLOSEBRACKET + Locators.SECTIONINVIEWRESOURCEDETAILPART2 + strSection + Locators.CLOSEBRACKET, "xpath").isElementPresent(),
					"Status type is not present under corresponding section.");
		}
		return this;
	}

	public Map openViewResourceDetailPage(String resourceName) throws Exception {
		this.selectResourceNameInFindResourceDropdown(resourceName);
		this.verifyViewInfoInPopupWindow();
		this.clickViewInfoInPopupWindow();
		waitForElement.waitForElements(EMR.Locators.ViewResourceDetail.Locators.VIEW_RESOURCE_DETAIL_OF_RESOURCE_PART1 + resourceName + Locators.CLOSEBRACKET, "xpath");
		assertTrue(this.page.element(EMR.Locators.ViewResourceDetail.Locators.VIEW_RESOURCE_DETAIL_OF_RESOURCE_PART1 + resourceName + Locators.CLOSEBRACKET, "xpath").isElementPresent());
		return this;
	}

	public Map verResourceInPopupWindow(String resourceName)
			throws Exception {
		waitForElement.waitForElements(Locators.RESOURCE_ON_MAP+resourceName+Locators.CLOSEBRACKET, "xpath");
		assertTrue(this.page.element(Locators.RESOURCE_ON_MAP+resourceName+Locators.CLOSEBRACKET, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.RESOURCE_ON_MAP+resourceName+Locators.CLOSEBRACKET, "xpath").getOne().isDisplayed());
		return this;
	}	

	public Map verifyResourceIsNotFindresourceDropDown(String resourceName)
			throws Exception {
		waitForElement.waitForElements(Locators.RESOURCE_ON_FIND_RESOURCE_DROPEDOWN+resourceName+Locators.CLOSEBRACKET, "xpath");
		assertFalse(this.page.element(Locators.RESOURCE_ON_FIND_RESOURCE_DROPEDOWN+resourceName+Locators.CLOSEBRACKET, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL));
		return this;
	}

	public Map navigateToMapAndVerifyResourceInFindResourceDropDown(String resourceName) throws Exception {
		navigateTo.clickOnShowMap();
		this.selectResourceNameInFindResourceDropdown(resourceName);
		this.verResourceInPopupWindow(resourceName);
		return this;
	}

	public Map openResourceOnMapAndVerifyResourceAndStatusTypes(String resourceName,String[] statusTypesNames) throws Exception {
		this.selectResourceNameInFindResourceDropdown(resourceName);
		this.verifyViewInfoInPopupWindow();
		this.verResourceInPopupWindow(resourceName);
		this.verifyStatusTypesInPopupWindow(statusTypesNames);
		return this;
	}

	public Map openResourceOnMapAndVerifyNoStatusTypesDisplayed(String resourceName,String[] statusTypesValues) throws Exception {
		this.selectResourceNameInFindResourceDropdown(resourceName);
		this.verifyViewInfoInPopupWindow();
		this.verResourceInPopupWindow(resourceName);
		this.verStatusTypesNotInPopupWindow(statusTypesValues);
		return this;
	}

	public Map openResourceOnMapToUpdate(String resourceName,ArrayList<String> statuTypesNames) throws Exception {
		this.selectResourceNameInFindResourceDropdown(resourceName);
		this.verifyViewInfoInPopupWindow();
		this.verResourceInPopupWindow(resourceName);
		this.verifyStatusTypesInPopupWindow(statuTypesNames);
		this.clickUpdateStatusInPopupWindow();
		return this;
	}

	public String getUpdatedDateAndTimeFromMap() throws Exception {
		String updatedDateTime=Locators.UPDATED_TIME_ON_MAP;
		waitForElement.waitForElements(updatedDateTime, "xpath");
		String getUpdatedTime=this.page.element(updatedDateTime, "xpath").getOne().getText();
		String[] updatedTime=getUpdatedTime.split(" ");
		System.out.println(updatedTime[2]);
		String currentYear=dts.getCurrentDate("yyyy");
		String updatedDateAndTime = updatedTime[0]+" "+updatedTime[1]+" "+currentYear+" "+updatedTime[2];
		System.out.println("updatedDateAndTime "+  updatedDateAndTime);
		String returnUpdated=updatedDateAndTime.replace('(', ' ').trim();
		return returnUpdated;
	}  

	public Map navigateToMapAndVerifyResourceIsNotFindresourceDropDown(String resourceName) throws Exception {
		navigateTo.clickOnShowMap();
		this.verifyResourceIsNotFindresourceDropDown(resourceName);
		return this;
	}
	public Map verifyStatusTypeFromStatusTypeDropdown(String statusType)
			throws Exception {
		waitForElement.waitForElements(Locators.FIND_STATUS_TYPE_DROP_DOWN_PART1,"id");
		assertTrue(this.page.element(Locators.FIND_STATUS_TYPE_DROP_DOWN_PART2+statusType+Locators.CLOSEBRACKET, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.FIND_STATUS_TYPE_DROP_DOWN_PART2+statusType+Locators.CLOSEBRACKET, "xpath").getOne().isDisplayed());
		return this;
	}

	public Map openResourceOnMapAndVerifyResourceAndStatusTypes(String resourceName,ArrayList<String> statuTypesNames) throws Exception {
		this.selectResourceNameInFindResourceDropdown(resourceName);
		this.verifyViewInfoInPopupWindow();
		this.verResourceInPopupWindow(resourceName);
		this.verifyStatusTypesInPopupWindow(statuTypesNames);
		return this;
	}

	public Map navigateToCustomViewMapAndVerifyStatusTypesInPopUpWindowInMap(String resource, ArrayList<String> _statusType) throws Exception {
		navigateTo.customView()
		.clickOnShowMap();
		view.verifyCustomViewMapPage();
		this.selectResourceNameInFindResourceDropdown(resource);
		this.verifyStatusTypesInPopupWindow(_statusType);
		navigateTo.clickOnShowTable();
		return this;
	}

	public Map verifyStatusTypesNotDisplayedInPopupWindow(ArrayList<String> statuTypesNames)
			throws Exception {
		waitForElement.waitForElements(Locators.TEXTOFPOPUPINMAP, "css");
		String StNames = this.page.element(Locators.TEXTOFPOPUPINMAP, "css").getOne().getText();
		Iterator<String> StNamesInPopUp = statuTypesNames.iterator();
		while(StNamesInPopUp.hasNext()){
			String statusTypenames =	StNamesInPopUp.next();
			assertFalse(StNames.contains(statusTypenames));
		}
		return this;
	}

	public Map openResourceOnMapAndVerifyStatusTypesNotDispalyedOnPopUpWindowOfMap(String resourceName,ArrayList<String> statuTypesNames) throws Exception {
		this.selectResourceNameInFindResourceDropdown(resourceName);
		this.verifyViewInfoInPopupWindow();
		this.verResourceInPopupWindow(resourceName);
		this.verifyStatusTypesNotDisplayedInPopupWindow(statuTypesNames);
		return this;
	}

	public Map verifyStatusTypeNotListedInStatusTypeDropdown(String statusType)
			throws Exception {
		waitForElement.waitForElements(Locators.FIND_STATUS_TYPE_DROP_DOWN_PART1,"id");
		assertFalse(this.page.element(Locators.FIND_STATUS_TYPE_DROP_DOWN_PART2+statusType+Locators.CLOSEBRACKET, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_TOO_SMALL));
		return this;
	}

	public Map navigateToCustomViewMapAndVerifyStatusTypesNotDispalyedOnPopUpWindowInMap(String resource, ArrayList<String> _statusType) throws Exception {
		navigateTo.customView()
		.clickOnShowMap();
		view.verifyCustomViewMapPage();
		this.selectResourceNameInFindResourceDropdown(resource);
		this.verifyStatusTypesNotDisplayedInPopupWindow(_statusType);
		return this;
	}

	public Map clickOnShowMapAndVerifyStatusTypesOnPopUpWindow(String resource, ArrayList<String> statusTypesNames) throws Exception {
		navigateTo.clickOnShowMap();
		view.verifyCustomViewMapPage();
		this.selectResourceNameInFindResourceDropdown(resource);
		this.verifyStatusTypesInPopupWindow(statusTypesNames);
		return this;
	}

	public Map clickViewInfoOnMapAndNavigateToResourceDetailPage(String resourceName) throws Exception {
		this.clickViewInfoInPopupWindow();
		this.verifyViewResDetailScreenIsDisplayedWithResName(resourceName);
		return this;
	}

	public Map verifyStatusTypeNotListedInStatusTypeDropdown(ArrayList<String> statusType)
			throws Exception {
		waitForElement.waitForElements(Locators.FIND_STATUS_TYPE_DROP_DOWN_PART1,"id");
		assertFalse(this.page.element(Locators.FIND_STATUS_TYPE_DROP_DOWN_PART2+statusType+Locators.CLOSEBRACKET, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_TOO_SMALL));
		return this;
	}

	public Map verifyStatusTypeFromStatusTypeDropdown(ArrayList<String> statusType)
			throws Exception {
		waitForElement.waitForElements(Locators.FIND_STATUS_TYPE_DROP_DOWN_PART1,"id");
		assertTrue(this.page.element(Locators.FIND_STATUS_TYPE_DROP_DOWN_PART2+statusType+Locators.CLOSEBRACKET, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.FIND_STATUS_TYPE_DROP_DOWN_PART2+statusType+Locators.CLOSEBRACKET, "xpath").getOne().isDisplayed());
		return this;
	}

	public Map verifyStatusTypesInPopupWindow(ArrayList<String> statusTypesName)
			throws Exception {
		waitForElement.waitForElements(Locators.TEXTOFPOPUPINMAP, "css");
		String strStatusTypeNam = this.page
				.element(Locators.TEXTOFPOPUPINMAP, "css").getOne()
				.getText();
		Iterator<String> iterator = statusTypesName.iterator();
		while(iterator.hasNext()) {
			String ST_Name = iterator.next();
			assertTrue(strStatusTypeNam.contains(ST_Name));
		}
		return this;
	}

	public Map selectToUpdateFromMapWindow() throws Exception {
		this.clickUpdateStatusInPopupWindow();
		return this;
	}	

	public Map verifyUpdatedValuesInPopupWindow(ArrayList<String> updatedValues) throws Exception {
		Iterator<String> itr=updatedValues.iterator();
		while(itr.hasNext())
		{
			String valuesUpdated=Locators.SPANWITHTEXT + itr.next() + Locators.CLOSEBRACKET;
			assertTrue(this.page.element(valuesUpdated, "xpath").isElementPresent());
			assertTrue(this.page.element(valuesUpdated, "xpath").getOne().isDisplayed());
		}
		return this;
	}

	public Map openResourceOnMapAndVerifyUpdatedValues(String resourceName,ArrayList<String> updatedValues) throws Exception {
		this.selectResourceNameInFindResourceDropdown(resourceName);
		this.verifyViewInfoInPopupWindow();
		this.verResourceInPopupWindow(resourceName);
		this.verifyUpdatedValuesInPopupWindow(updatedValues);
		return this;
	}
	
	public Map openResourceOnMapAndVerifyNoStatusTypesDisplayed(String resourceName,ArrayList<String> statusTypesValues) throws Exception {
		this.selectResourceNameInFindResourceDropdown(resourceName);
		this.verifyViewInfoInPopupWindow();
		this.verResourceInPopupWindow(resourceName);
		this.verStatusTypesNotInPopupWindow(statusTypesValues);
		return this;
	}
	
	public Map verStatusTypesNotInPopupWindow(ArrayList<String> strStatusTypesValue)
			throws Exception {
		waitForElement.waitForElements(Locators.TEXTOFPOPUPINMAP, "css");

		String strStatusTypeNam = this.page
				.element(Locators.TEXTOFPOPUPINMAP, "css").getOne()
				.getText();
		Iterator<String> iterator = strStatusTypesValue.iterator();
		while(iterator.hasNext()) {
			assertFalse(strStatusTypeNam.contains(iterator.next()));
		}
		return this;
	}
	

	public Map navigateToEditResourceFromMap() throws Exception {
		waitForElement.waitForElements(Locators.EDIT_INFO, "linktext");
		assertTrue(this.page.element(Locators.EDIT_INFO, "linktext").getOne().isDisplayed(), "Edit Info is not present in pop window.");
		this.page.element(Locators.EDIT_INFO, "linktext").getOne().click();
		waitForElement.waitForElements(EMR.Locators.Resources.Locators.EDIT_RESOURCE_PAGE, "xpath");
		assertTrue(this.page.element(EMR.Locators.Resources.Locators.EDIT_RESOURCE_PAGE, "xpath").isElementPresent(), "Edit resource page is not displayed.");
		return this;
	}
	
	public Map verifyEditOptionIsNotPresent() throws Exception {
		waitForElement.waitForElements(Locators.VIEWINFO, "linktext");
		assertFalse(this.page.element(Locators.EDIT_INFO, "linktext").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE), "Edit Info is present in pop window.");
		return this;
	}
	
	public Map verifyResourceNotUnderSelectResource(String resourceName) throws Exception {
		waitForElement.waitForElements(Locators.FINDRESOURCEDROPDOWN, "id");
		List<WebElement> options = this.page.element(Locators.FINDRESOURCEDROPDOWN, "id").webElementToSelect().getOptions();
		Iterator<WebElement> iterator = options.iterator();
		while(iterator.hasNext()) {
			WebElement next = iterator.next();
			String resource_name = next.getText();
			System.out.println(resource_name);
			assertFalse(resourceName.equals(resource_name), resourceName + " option is present in application.");
		}
		return this;
	}
}