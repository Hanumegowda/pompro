package EMR.pages;

import static org.testng.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;

import EMR.Locators.ViewResourceDetail.Locators;
import qaFramework.WaitTimeConstants;
import qaFramework.UserDefinedFunctions.WaitForElement;
import qaFramework.pageObject.PageObject;

public class ViewResourceDetail extends PageObject {

	WebDriver driver;
	WaitForElement waitForElement ;
	Login login;
	Map map;
	Resources resource;

	public ViewResourceDetail(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		waitForElement = new WaitForElement(this.driver);
		map= new Map(this.driver);
		resource = new Resources(this.driver);
	}

	public ViewResourceDetail verifyDetailViewPage() throws Exception {
		waitForElement.waitForElements(Locators.VIEW_RESOURCE_DETAIL_PAGE, "xpath");
		assertTrue(this.page.element(Locators.VIEW_RESOURCE_DETAIL_PAGE, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.VIEW_RESOURCE_DETAIL_PAGE, "xpath").getOne().isDisplayed());
		return this;
	}

	public ViewResourceDetail verifyIncidentCommandSystemSection() throws Exception {
		waitForElement.waitForElements(Locators.INCIDENT_COMMAND_SYSTEM, "xpath");
		assertTrue(this.page.element(Locators.INCIDENT_COMMAND_SYSTEM, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.INCIDENT_COMMAND_SYSTEM, "xpath").getOne().isDisplayed());
		return this;
	}

	public ViewResourceDetail verifyIncidentInICSSection(String incidentName, String incidentDescription) throws Exception {
		waitForElement.waitForElements(Locators.INCIDENT_IN_ICS_SECTION_PART1 + incidentName + Locators.INCIDENT_IN_ICS_SECTION_PART2 + incidentDescription + Locators.CLOSEBRACKET, "xpath");
		assertTrue(this.page.element(Locators.INCIDENT_IN_ICS_SECTION_PART1 + incidentName + Locators.INCIDENT_IN_ICS_SECTION_PART2 + incidentDescription + Locators.CLOSEBRACKET, "xpath").isElementPresent());
		return this;
	}

	public ViewResourceDetail switchToHicsFrame() throws Exception {
		waitForElement.waitForElements(Locators.HICS_FRAME, "id");
		boolean switched = this.page.element_wait(Locators.HICS_FRAME, "id").switchToFrame(Locators.HICS_FRAME);
		assertTrue(switched);
		return this;
	}

	public ViewResourceDetail verifyIncidentDetailsInICSSection(String incidentName, String incidentDescription) throws Exception {
		login = new Login(this.driver);
		this.verifyIncidentCommandSystemSection();
		this.switchToHicsFrame();
		this.verifyIncidentInICSSection(incidentName, incidentDescription);
		login.selectFrame();
		return this;
	}

	public ViewResourceDetail verifyViewResourceDetailsPage()
			throws Exception {
		waitForElement.waitForElements(Locators.VIEW_RESOURCE_DETAIL, "xpath");
		assertTrue(this.page.element(Locators.VIEW_RESOURCE_DETAIL, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.VIEW_RESOURCE_DETAIL, "xpath").getOne().isDisplayed());
		return this;
	}

	public ViewResourceDetail verifyResourceInViewResourceDetailsPage(String resource)
			throws Exception {
		waitForElement.waitForElements(Locators.RESOURCE_IN_RESOURCE_DETAIL, "xpath");
		assertTrue(this.page.element(Locators.RESOURCE_IN_RESOURCE_DETAIL, "xpath").getDisplayedOne().getText().equals(resource));
		assertTrue(this.page.element(Locators.RESOURCE_IN_RESOURCE_DETAIL, "xpath").getOne().isDisplayed());
		return this;
	}

	public ViewResourceDetail verifyStatusTypesUnderSection(String statusTypesNames[],String section) throws Exception {

		for(int i =0; i<=statusTypesNames.length-1;i++)
		{	
			String StatusTypesUnderSection=Locators.STATUSTYPES_UNDER_SECTION+statusTypesNames[i]+Locators.CLOSEBRACKET+Locators.STATUSTYPES_UNDER_SECTION_PART1+section+Locators.CLOSEBRACKET;
			waitForElement.waitForElements(StatusTypesUnderSection, "xpath");
			assertTrue(this.page.element(StatusTypesUnderSection, "xpath").isElementPresent(),"Status type is not present under corresponding section.");
			assertTrue(this.page.element(StatusTypesUnderSection, "xpath").getOne().isDisplayed(),"Status type is not present under corresponding section.");

		}
		return this;
	}

	public ViewResourceDetail clickOnAnyStatusTypeLinkToUpdate(String numberStatusType)
			throws Exception {
		String numberStUpdateLink=Locators.TABLE_DATA_TEXT+numberStatusType+Locators.CLOSEBRACKET+Locators.FOLLOWING_TABLE_DATA;
		waitForElement.waitForElements(numberStUpdateLink, "xpath");
		this.page.element(numberStUpdateLink, "xpath").mouseOver();
		this.page.element(numberStUpdateLink, "xpath").getOne().click();
		waitForElement.waitForElements(Locators.SHOW_ALL, "css");
		return this;
	}

	public ViewResourceDetail verifyUpdatedStatusTypes(String StatusTypeNames[],String updatedValues[])
			throws Exception {
		for(int i =0; i<=StatusTypeNames.length-1;i++)
		{	
			String verifyUpdated=Locators.TABLE_DATA_TEXT+StatusTypeNames[i]+Locators.CLOSEBRACKET+Locators.VERIFY_UPDATED_VALUES+updatedValues[i]+Locators.CLOSEBRACKET;
			waitForElement.waitForElements(verifyUpdated, "xpath");
			assertTrue(this.page.element(verifyUpdated, "xpath").isElementPresent(),"Status type is not updated correctly");
			assertTrue(this.page.element(verifyUpdated, "xpath").getOne().isDisplayed(),"Status type is not updated correctly");
		}
		return this;
	}

	public ViewResourceDetail verifyEditResourceDetailsLinkNotPresent(String resourceName) throws Exception {
		assertFalse(this.page.element(Locators.RESOURCE_NAME_IN_VIEW_RESOURCE_DETAIL + resourceName + Locators.EDIT_LINK_OF_RESOURCE, "xpath").isElementPresent());
		return this;
	}

	public ViewResourceDetail verifyStatusTypesUnderSection(List<String> statusTypesNames,String section) throws Exception {

		Iterator<String> itr=statusTypesNames.iterator();
		while(itr.hasNext())
		{
			String value=itr.next();
			String StatusTypesUnderSection=Locators.STATUSTYPES_UNDER_SECTION+value+Locators.CLOSEBRACKET+Locators.STATUSTYPES_UNDER_SECTION_PART1+section+Locators.CLOSEBRACKET;
			waitForElement.waitForElements(StatusTypesUnderSection, "xpath");
			assertTrue(this.page.element(StatusTypesUnderSection, "xpath").isElementPresent(),"Status type is not present under corresponding section.");
			assertTrue(this.page.element(StatusTypesUnderSection, "xpath").getOne().isDisplayed(),"Status type is not present under corresponding section.");

		}
		return this;
	}

	public ViewResourceDetail verifyStatusTypesNotDispalyedUnderSectionOfViewResourceDetailScreen(List<String> statusTypesNames,String section) throws Exception {
		this.verifyViewResourceDetailsPage();
		Iterator<String> itr=statusTypesNames.iterator();
		while(itr.hasNext())
		{
			String value=itr.next();
			String StatusTypesUnderSection=Locators.STATUSTYPES_VALUES_UNDER_SECTION+value+Locators.CLOSEBRACKET;
			assertFalse(this.page.element(StatusTypesUnderSection, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_TOO_SMALL),"Status type is present under corresponding section.");
		}
		return this;
	}

	public ViewResourceDetail verifyStatusTypesDispalyedUnderSectionOfViewResourceDetailScreen(List<String> statusTypesNames,String section) throws Exception {

		Iterator<String> itr=statusTypesNames.iterator();
		while(itr.hasNext())
		{
			String value=itr.next();
			String StatusTypesUnderSection=Locators.STATUSTYPES_UNDER_SECTION+value+Locators.CLOSEBRACKET+Locators.STATUSTYPES_UNDER_SECTION_PART1+section+Locators.CLOSEBRACKET;
			waitForElement.waitForElements(StatusTypesUnderSection, "xpath");
			assertTrue(this.page.element(StatusTypesUnderSection, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_TOO_SMALL),"Status type is not present under corresponding section.");
			assertTrue(this.page.element(StatusTypesUnderSection, "xpath").getOne().isDisplayed());
		}
		return this;
	}

	public ViewResourceDetail verifyStatusTypesUnderViewResourceDetailScreen(String resource,List<String> statusTypesNames,String section) throws Exception {
		map.openViewResourceDetailPage(resource);
		this.verifyStatusTypesDispalyedUnderSectionOfViewResourceDetailScreen(statusTypesNames, section);
		return this;
	}

	public ViewResourceDetail verifyStatusTypesNotDisplayedUnderViewResourceDetailScreen(String resource,List<String> statusTypesNames,String section) throws Exception {
		map.openViewResourceDetailPage(resource);
		this.verifyStatusTypesNotDispalyedUnderSectionOfViewResourceDetailScreen(statusTypesNames, section);
		return this;
	}

	public ViewResourceDetail verifyStatusTypesUnderSection(ArrayList<String> statusTypesNames,String section) throws Exception {
		Iterator<String> iterator = statusTypesNames.iterator();
		while(iterator.hasNext()){
			String ST_Name = iterator.next();
			String StatusTypesUnderSection = Locators.STATUSTYPES_UNDER_SECTION + ST_Name + Locators.CLOSEBRACKET + Locators.STATUSTYPES_UNDER_SECTION_PART1 + section+Locators.CLOSEBRACKET;
			waitForElement.waitForElements(StatusTypesUnderSection, "xpath");
			assertTrue(this.page.element(StatusTypesUnderSection, "xpath").isElementPresent(), StatusTypesUnderSection + " Status type is not present under section.");
			assertTrue(this.page.element(StatusTypesUnderSection, "xpath").getOne().isDisplayed(), StatusTypesUnderSection + " Status type is not present under section.");
		}
		return this;
	}

	public ViewResourceDetail verifyTrafficInMap() throws Exception {
		waitForElement.waitForElements(Locators.TRAFFIC_IN_MAP, "xpath");
		assertTrue(this.page.element(Locators.TRAFFIC_IN_MAP, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.TRAFFIC_IN_MAP, "xpath").getDisplayedOne().isDisplayed());
		return this;
	}

	public ViewResourceDetail verifyMapAndSatelliteInMap() throws Exception {
		waitForElement.waitForElements(Locators.MAP_TAG_IN_MAP, "xpath");
		assertTrue(this.page.element(Locators.MAP_TAG_IN_MAP, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.MAP_TAG_IN_MAP, "xpath").getDisplayedOne().isDisplayed());
		assertTrue(this.page.element(Locators.SATELLITE_IN_MAP, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.SATELLITE_IN_MAP, "xpath").getDisplayedOne().isDisplayed());
		return this;
	}

	public ViewResourceDetail verifyUpdatedStatusTypesValuesUnderSection(ArrayList<String> statusTypeNames,ArrayList<String> updatedValues)throws Exception {

		Iterator<String> statusTypesNames =statusTypeNames.iterator();
		Iterator<String> valuesUpdated =updatedValues.iterator();
		while(statusTypesNames.hasNext()&&valuesUpdated.hasNext())
		{
			String verifyUpdated=Locators.TABLE_DATA_TEXT+statusTypesNames.next()+Locators.CLOSEBRACKET+Locators.VERIFY_UPDATED_VALUES+valuesUpdated.next()+Locators.CLOSEBRACKET;
			waitForElement.waitForElements(verifyUpdated, "xpath");
			assertTrue(this.page.element(verifyUpdated, "xpath").isElementPresent(),"Status type is not updated correctly");
			assertTrue(this.page.element(verifyUpdated, "xpath").getOne().isDisplayed(),"Status type is not updated correctly");
		}
		return this;
	}
	
	public ViewResourceDetail verifyResourceTypeInDetailViewPage(String resourceTypeName) throws Exception {
		waitForElement.waitForElements(Locators.RESOURCE_TYPE, "id");
		assertEquals(this.page.element(Locators.RESOURCE_TYPE, "id").getDisplayedOne().getText(), resourceTypeName);
		return this;
	}
	
	public ViewResourceDetail navigateToEditResourceFromDetailView(String resourceName) throws Exception {
		waitForElement.waitForElements(Locators.RESOURCE_NAME_IN_VIEW_RESOURCE_DETAIL + resourceName + Locators.EDIT_LINK_OF_RESOURCE, "xpath");
		this.page.element(Locators.RESOURCE_NAME_IN_VIEW_RESOURCE_DETAIL + resourceName + Locators.EDIT_LINK_OF_RESOURCE, "xpath").getDisplayedOne().click();
		try{
			if(!this.page.element(EMR.Locators.Resources.Locators.EDIT_RESOURCE_PAGE, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE)) {
				this.page.element(Locators.RESOURCE_NAME_IN_VIEW_RESOURCE_DETAIL + resourceName + Locators.EDIT_LINK_OF_RESOURCE, "xpath").clickUsingJSE();
			}
		}catch(Exception e) { }
		assertTrue(this.page.element(EMR.Locators.Resources.Locators.EDIT_RESOURCE_PAGE, "xpath").isElementPresent(), "'Edit Resource' page is not displayed.");
		return this;
	}
	
	public ViewResourceDetail editResourceFromViewResourceDetailScreen(String resourceName, String edit_resourceName) throws Exception {
		this.navigateToEditResourceFromDetailView(resourceName);
		resource.enterName(edit_resourceName);
		resource.clickOnSave();
		this.verifyDetailViewPage();
		return this;
	}
}