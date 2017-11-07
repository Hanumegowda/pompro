package EMR.pages;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import EMR.Locators.InterfaceSetUp.Locators;
import EMR.data.InterfaceData;
import qaFramework.WaitTimeConstants;
import qaFramework.UserDefinedFunctions.WaitForElement;
import qaFramework.pageObject.PageObject;

public class InterfaceSetUp extends PageObject {

	WebDriver driver;
	WaitForElement waitForElement;
	Shared navigateTo;
	Alert alert;

	public InterfaceSetUp(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver= _driver;
		waitForElement= new WaitForElement(driver);
		navigateTo= new Shared(driver);
	}

	public InterfaceSetUp verifyCreateNewInterfaceAndInterfaceListPage() throws Exception {
		waitForElement.waitForElements(Locators.INTERFACELISTPAGE, "xpath");
		assertTrue(this.page.element(Locators.INTERFACELISTPAGE, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.INTERFACELISTPAGE, "xpath").getOne().isDisplayed());
		assertTrue(this.page.element(Locators.CREATE_NEW_INTERFACE, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.CREATE_NEW_INTERFACE, "xpath").getOne().isDisplayed());
		return this;
	}

	public InterfaceSetUp clickCreateNewInterface() throws Exception {
		waitForElement.waitForElements(Locators.CREATE_NEW_INTERFACE, "xpath");
		this.page.element(Locators.CREATE_NEW_INTERFACE, "xpath").getOne().click();
		return this;
	}

	public InterfaceSetUp selectInterfaceType(String interfaceType)
			throws Exception {
		waitForElement.waitForElements(Locators.SELECTINTERFACETYPE,"name");
		this.page.element(Locators.SELECTINTERFACETYPE,"name").webElementToSelect().selectByVisibleText(interfaceType);
		String selectedInterfaceType=this.page.element(Locators.SELECTINTERFACETYPE,"name").webElementToSelect().getFirstSelectedOption().getText();
		assertEquals(interfaceType, selectedInterfaceType,"selected interface is other than expected");
		return this;
	}

	public InterfaceSetUp clickNext() throws Exception {
		waitForElement.waitForElements(Locators.NEXT, "xpath");
		this.page.element(Locators.NEXT, "xpath").getOne().click();
		waitForElement.waitForElements(Locators.DESCRIPTION, "name");
		return this;
	}

	public InterfaceSetUp verifyCreateRegionInterfacePage() throws Exception {
		waitForElement.waitForElements(Locators.CREATE_REGION_INTERFACE_PAGE, "xpath");
		assertTrue(this.page.element(Locators.CREATE_REGION_INTERFACE_PAGE, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.CREATE_REGION_INTERFACE_PAGE, "xpath").getOne().isDisplayed());
		return this;
	}

	public InterfaceSetUp enterInterfaceName(String name) throws Exception {
		waitForElement.waitForElements(Locators.DESCRIPTION, "name");
		if(this.page.element(Locators.NAME_FOR_REGION_INTERFACE, "name").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE)){
			this.page.element(Locators.NAME_FOR_REGION_INTERFACE, "name").clearInputValue().sendKeys(name);
			assertTrue(this.page.element(Locators.NAME_FOR_REGION_INTERFACE, "name").getOne().getAttribute("value").equals(name));
			this.verifyCreateRegionInterfacePage();
		}
		else{
			this.page.element(Locators.NAME_FOR_MULTIREGION_INTERFACE, "name").clearInputValue().sendKeys(name);
			assertTrue(this.page.element(Locators.NAME_FOR_MULTIREGION_INTERFACE, "name").getOne().getAttribute("value").equals(name));
			this.verifyCreateProductInterfacePage();
		}
		return this;
	}

	public InterfaceSetUp enterInterfaceDescription(String description) throws Exception {
		waitForElement.waitForElements(Locators.DESCRIPTION, "name");
		this.page.element(Locators.DESCRIPTION, "name").clearInputValue().sendKeys(description);
		return this;
	}

	public InterfaceSetUp enterContactInformation(String contactInformation) throws Exception {
		waitForElement.waitForElements(Locators.CONTACTINFO, "name");
		this.page.element(Locators.CONTACTINFO, "name").clearInputValue().sendKeys(contactInformation);
		return this;
	}

	public InterfaceSetUp verifyAppropraiteWebServiceAction(String webServiceActions) throws Exception {
		waitForElement.waitForElements(Locators.WEBSERVICEACTION, "name");
		String webServiceAction = this.page.element(Locators.WEBSERVICEACTION, "name")
				.getOne().getAttribute("value");
		assertEquals(webServiceActions, webServiceAction,"Displayed webservice action is inAppropriatte for"+" "+webServiceActions);
		return this;
	}

	public InterfaceSetUp selectActive() throws Exception {
		waitForElement.waitForElements(Locators.ACTIVE, "name");
		this.page.element(Locators.ACTIVE, "name").getOne().click();
		if(!this.page.element(Locators.ACTIVE, "name").getOne().isSelected()){
			this.page.element(Locators.ACTIVE, "name").clickUsingJSE(); 
		}  
		return this;
	}

	public InterfaceSetUp clickSave() throws Exception {
		waitForElement.waitForElements(Locators.SAVE, "css");
		this.page.element(Locators.SAVE, "css").clickUsingJSE();
		waitForElement.waitForElements(Locators.CREATE_NEW_INTERFACE, "xpath");
		return this;
	}

	public InterfaceSetUp createInterface(String name,String description,String interfaceType,String webServiceAction) throws Exception {
		this.verifyActiveWebServicesActionOfInterfaceAndDelete(webServiceAction);
		this.clickCreateNewInterface();
		this.selectInterfaceType(interfaceType);
		this.clickNext();  		
		this.enterInterfaceName(name);
		this.enterInterfaceDescription(description);
		this.verifyAppropraiteWebServiceAction(webServiceAction);
		this.selectActive();
		this.clickSave();
		return this;
	}

	public InterfaceSetUp verifyCreatedInterfaceDetailesInInterfaceList(
			String interfacename, String description, String contactInformation,
			String webServiceAction, String activateStatus,String interfaceType,String schema) throws Exception {

		String[] interfaceDetailes={description,contactInformation,webServiceAction,activateStatus,interfaceType,schema};
		for(int i=0;i<interfaceDetailes.length;i++){
			String interfaceDetaile=Locators.INTERFACE_NAME_IN_TABLE+interfacename+Locators.CLOSINGBRACKETS+Locators.FOLLOWING_COLUMNS_OF_INTERFACE_NAME+interfaceDetailes[i]+Locators.CLOSINGBRACKETS;
			assertTrue(this.page.element(interfaceDetaile,"xpath").isElementPresent(),interfaceDetailes[i]+" "+" detaile is not displayed in interface list page");
			assertTrue(this.page.element(interfaceDetaile,"xpath").getOne().isDisplayed(),interfaceDetailes[i]+" "+" detaile is not displayed in interface list page");
		}
		return this; 	
	}

	public InterfaceSetUp verifyEditLink(String interfaceName) throws Exception {
		waitForElement.waitForElements(Locators.INTERFACE_NAME_IN_TABLE + interfaceName+Locators.CLOSINGBRACKETS+Locators.EDITLINKPART2, "xpath");
		assertTrue(this.page.element(Locators.INTERFACE_NAME_IN_TABLE + interfaceName+Locators.CLOSINGBRACKETS+Locators.EDITLINKPART2, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.INTERFACE_NAME_IN_TABLE + interfaceName+Locators.CLOSINGBRACKETS+Locators.EDITLINKPART2,"xpath").getOne().isDisplayed());
		return this;
	}

	public InterfaceSetUp clickEditLink(String interfaceName) throws Exception {
		waitForElement.waitForElements(Locators.INTERFACE_NAME_IN_TABLE + interfaceName+Locators.CLOSINGBRACKETS+Locators.EDITLINKPART2, "xpath");
		this.page.element(Locators.INTERFACE_NAME_IN_TABLE + interfaceName+Locators.CLOSINGBRACKETS+Locators.EDITLINKPART2,"xpath").getOne().click();
		return this;
	}

	public InterfaceSetUp verifyDeleteLink(String interfaceName) throws Exception {
		waitForElement.waitForElements(Locators.INTERFACE_NAME_IN_TABLE + interfaceName+Locators.CLOSINGBRACKETS+Locators.DELETELINK, "xpath");
		assertTrue(this.page.element(Locators.INTERFACE_NAME_IN_TABLE + interfaceName+Locators.CLOSINGBRACKETS+Locators.DELETELINK,"xpath").isElementPresent());
		assertTrue(this.page.element(Locators.INTERFACE_NAME_IN_TABLE + interfaceName+Locators.CLOSINGBRACKETS+Locators.DELETELINK,"xpath").getOne().isDisplayed());
		return this;
	}

	public InterfaceSetUp clickDeleteLink(String interfaceName) throws Exception {
		waitForElement.waitForElements(Locators.INTERFACE_NAME_IN_TABLE + interfaceName + Locators.CLOSINGBRACKETS+Locators.DELETELINK, "xpath");
		this.page.element(Locators.INTERFACE_NAME_IN_TABLE + interfaceName+Locators.CLOSINGBRACKETS + Locators.DELETELINK,"xpath").getOne().click();
		return this;
	}

	public InterfaceSetUp verifyParametersLink(String interfaceName) throws Exception {
		waitForElement.waitForElements(Locators.INTERFACE_NAME_IN_TABLE+interfaceName+Locators.CLOSINGBRACKETS+Locators.PARAMETRESLINK, "xpath");
		assertTrue(this.page.element(Locators.INTERFACE_NAME_IN_TABLE+interfaceName+Locators.CLOSINGBRACKETS+Locators.PARAMETRESLINK,"xpath").isElementPresent());
		assertTrue(this.page.element(Locators.INTERFACE_NAME_IN_TABLE+interfaceName+Locators.CLOSINGBRACKETS+Locators.PARAMETRESLINK,"xpath").getOne().isDisplayed());
		return this;
	}

	public InterfaceSetUp clickParametersLink(String interfaceName) throws Exception {
		waitForElement.waitForElements(Locators.INTERFACE_NAME_IN_TABLE+interfaceName+Locators.CLOSINGBRACKETS+Locators.PARAMETRESLINK, "xpath");
		this.page.element(Locators.INTERFACE_NAME_IN_TABLE+interfaceName+Locators.CLOSINGBRACKETS+Locators.PARAMETRESLINK, "xpath").getOne().click();
		return this;
	}

	public InterfaceSetUp verifyStatusTypesLink(String interfaceName) throws Exception {
		waitForElement.waitForElements(Locators.INTERFACE_NAME_IN_TABLE+interfaceName+Locators.CLOSINGBRACKETS+Locators.STATUSTYPESLINK, "xpath");
		assertTrue(this.page.element(Locators.INTERFACE_NAME_IN_TABLE+interfaceName+Locators.CLOSINGBRACKETS+Locators.STATUSTYPESLINK, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.INTERFACE_NAME_IN_TABLE+interfaceName+Locators.CLOSINGBRACKETS+Locators.STATUSTYPESLINK, "xpath").getOne().isDisplayed());
		return this;
	}

	public InterfaceSetUp clickStatusTypesLink(String interfaceName) throws Exception {
		waitForElement.waitForElements(Locators.INTERFACE_NAME_IN_TABLE+interfaceName+Locators.CLOSINGBRACKETS+Locators.STATUSTYPESLINK, "xpath");
		this.page.element(Locators.INTERFACE_NAME_IN_TABLE+interfaceName+Locators.CLOSINGBRACKETS+Locators.STATUSTYPESLINK, "xpath").getOne().click();
		return this;
	}

	public InterfaceSetUp verifyUsersLink(String interfaceName) throws Exception {
		waitForElement.waitForElements(Locators.INTERFACE_NAME_IN_TABLE+interfaceName+Locators.CLOSINGBRACKETS+Locators.USERSLINK, "xpath");
		assertTrue(this.page.element(Locators.INTERFACE_NAME_IN_TABLE+interfaceName+Locators.CLOSINGBRACKETS+Locators.USERSLINK, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.INTERFACE_NAME_IN_TABLE+interfaceName+Locators.CLOSINGBRACKETS+Locators.USERSLINK, "xpath").getOne().isDisplayed());
		return this;
	}

	public InterfaceSetUp clickUsersLink(String interfaceName) throws Exception {
		waitForElement.waitForElements(Locators.INTERFACE_NAME_IN_TABLE+interfaceName+Locators.CLOSINGBRACKETS+Locators.USERSLINK, "xpath");
		this.page.element(Locators.INTERFACE_NAME_IN_TABLE+interfaceName+Locators.CLOSINGBRACKETS+Locators.USERSLINK, "xpath").getOne().click();
		waitForElement.waitForElements(Locators.PRODUCT_INTERFACE_USERS_LIST_PAGE, "xpath");
		return this;
	}

	public InterfaceSetUp verifyResourceLink(String interfaceName) throws Exception {
		waitForElement.waitForElements(Locators.INTERFACE_NAME_IN_TABLE+interfaceName+Locators.CLOSINGBRACKETS+Locators.RESOURCELINK, "xpath");
		assertTrue(this.page.element(Locators.INTERFACE_NAME_IN_TABLE+interfaceName+Locators.CLOSINGBRACKETS+Locators.RESOURCELINK, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.INTERFACE_NAME_IN_TABLE+interfaceName+Locators.CLOSINGBRACKETS+Locators.RESOURCELINK, "xpath").getOne().isDisplayed());
		return this;
	}

	public InterfaceSetUp clickResourceLink(String interfaceName) throws Exception {
		waitForElement.waitForElements(Locators.INTERFACE_NAME_IN_TABLE+interfaceName+Locators.CLOSINGBRACKETS+Locators.RESOURCELINK, "xpath");
		this.page.element(Locators.INTERFACE_NAME_IN_TABLE+interfaceName+Locators.CLOSINGBRACKETS+Locators.RESOURCELINK, "xpath").clickUsingJSE();
		return this;
	}

	public InterfaceSetUp verifyInterfaceTypeAndDeleteCorrespondingInterfaceIfPresent(String interfacetype) throws Exception {

		if(this.page.element(Locators.INTERFACE_NAME_IN_TABLE+interfacetype+Locators.CLOSINGBRACKETS+Locators.DELETELINK, "xpath").isElementPresent()==true)
		{
			this.page.element(Locators.INTERFACE_NAME_IN_TABLE + interfacetype+Locators.CLOSINGBRACKETS + Locators.DELETELINK, "xpath").getOne().click();
			String alert=driver.switchTo().alert().getText();
			System.out.println("alert" + alert);
			driver.switchTo().alert().accept();
		}
		this.page.element_wait(Locators.INTERFACE_NAME_IN_TABLE + interfacetype+Locators.CLOSINGBRACKETS + Locators.DELETELINK,"xpath").waitForInvisibilityOfElement();
		assertTrue(this.page.element(Locators.INTERFACE_NAME_IN_TABLE+interfacetype+Locators.CLOSINGBRACKETS, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_TOO_SMALL)==false);
		return this;
	}

	public InterfaceSetUp verifyProductInterfaceUsersListPage() throws Exception {
		waitForElement.waitForElements(Locators.PRODUCT_INTERFACE_USERS_LIST_PAGE, "xpath");
		assertTrue(this.page.element(Locators.PRODUCT_INTERFACE_USERS_LIST_PAGE, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.PRODUCT_INTERFACE_USERS_LIST_PAGE, "xpath").getOne().isDisplayed());
		return this;
	}

	public InterfaceSetUp verifyWebServiceUserUnderProductInterfaceUsersListPage(String webServiceUserName,String webServiceUserFullName) throws Exception {
		this.verifyProductInterfaceUsersListPage();
		System.out.println(Locators.INTERFACE_NAME_IN_TABLE+webServiceUserFullName+Locators.CLOSINGBRACKETS+Locators.FOLLOWING_COLUMNS_OF_INTERFACE_NAME+webServiceUserName+Locators.CLOSINGBRACKETS);
		assertTrue(this.page.element(Locators.INTERFACE_NAME_IN_TABLE+webServiceUserFullName+Locators.CLOSINGBRACKETS+Locators.FOLLOWING_COLUMNS_OF_INTERFACE_NAME+webServiceUserName+Locators.CLOSINGBRACKETS, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.INTERFACE_NAME_IN_TABLE+webServiceUserFullName+Locators.CLOSINGBRACKETS+Locators.FOLLOWING_COLUMNS_OF_INTERFACE_NAME+webServiceUserName+Locators.CLOSINGBRACKETS,"xpath").getOne().isDisplayed());
		return this;
	}

	public InterfaceSetUp verifyNoOtherUserIsDisplayedExcpetWebServiceUserOnProductInterfaceList(String username,String fullName) throws Exception {
		this.verifyProductInterfaceUsersListPage();
		assertFalse(this.page.element(Locators.INTERFACE_NAME_IN_TABLE+fullName+Locators.CLOSINGBRACKETS+Locators.FOLLOWING_COLUMNS_OF_INTERFACE_NAME+username+Locators.CLOSINGBRACKETS, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	public InterfaceSetUp verifyInterfaceIsActive(String InterfaceName) throws Exception {
		waitForElement.waitForElements(Locators.INTERFACE_NAME_IN_TABLE + InterfaceName + Locators.CLOSINGBRACKETS + Locators.ACTIVE_STATUS, "xpath");
		assertTrue(this.page.element(Locators.INTERFACE_NAME_IN_TABLE + InterfaceName + Locators.CLOSINGBRACKETS + Locators.ACTIVE_STATUS, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.INTERFACE_NAME_IN_TABLE + InterfaceName + Locators.CLOSINGBRACKETS + Locators.ACTIVE_STATUS, "xpath").getOne().isDisplayed());
		return this;
	}

	public InterfaceSetUp verifyWebServiceActionOfInterface(String InterfaceName, String webServiceAction) throws Exception {
		waitForElement.waitForElements(Locators.INTERFACE_NAME_IN_TABLE + InterfaceName + Locators.CLOSINGBRACKETS + Locators.FOLLOWING_COLUMNS_OF_INTERFACE_NAME + webServiceAction + Locators.CLOSINGBRACKETS, "xpath");
		assertTrue(this.page.element(Locators.INTERFACE_NAME_IN_TABLE + InterfaceName + Locators.CLOSINGBRACKETS + Locators.FOLLOWING_COLUMNS_OF_INTERFACE_NAME + webServiceAction + Locators.CLOSINGBRACKETS, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.INTERFACE_NAME_IN_TABLE + InterfaceName + Locators.CLOSINGBRACKETS + Locators.FOLLOWING_COLUMNS_OF_INTERFACE_NAME + webServiceAction + Locators.CLOSINGBRACKETS, "xpath").getOne().isDisplayed());
		return this;
	}

	public InterfaceSetUp verifyInterfaceType(String InterfaceName, String webServiceAction) throws Exception {
		waitForElement.waitForElements(Locators.INTERFACE_NAME_IN_TABLE + InterfaceName + Locators.CLOSINGBRACKETS + Locators.FOLLOWING_COLUMNS_OF_INTERFACE_NAME + webServiceAction + Locators.CLOSINGBRACKETS, "xpath");
		assertTrue(this.page.element(Locators.INTERFACE_NAME_IN_TABLE + InterfaceName + Locators.CLOSINGBRACKETS + Locators.FOLLOWING_COLUMNS_OF_INTERFACE_NAME + webServiceAction + Locators.CLOSINGBRACKETS, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.INTERFACE_NAME_IN_TABLE + InterfaceName + Locators.CLOSINGBRACKETS + Locators.FOLLOWING_COLUMNS_OF_INTERFACE_NAME + webServiceAction + Locators.CLOSINGBRACKETS, "xpath").getOne().isDisplayed());
		return this;
	}

	public InterfaceSetUp verifyInterfaceSchema(String InterfaceName, String schema) throws Exception {
		waitForElement.waitForElements(Locators.INTERFACE_NAME_IN_TABLE + InterfaceName + Locators.CLOSINGBRACKETS + Locators.FOLLOWING_COLUMNS_OF_INTERFACE_NAME + schema + Locators.CLOSINGBRACKETS, "xpath");
		assertTrue(this.page.element(Locators.INTERFACE_NAME_IN_TABLE + InterfaceName + Locators.CLOSINGBRACKETS + Locators.FOLLOWING_COLUMNS_OF_INTERFACE_NAME + schema + Locators.CLOSINGBRACKETS, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.INTERFACE_NAME_IN_TABLE + InterfaceName + Locators.CLOSINGBRACKETS + Locators.FOLLOWING_COLUMNS_OF_INTERFACE_NAME + schema + Locators.CLOSINGBRACKETS, "xpath").getOne().isDisplayed());
		return this;
	}

	public InterfaceSetUp verifyInterfaceDescription(String InterfaceName, String description) throws Exception {
		waitForElement.waitForElements(Locators.INTERFACE_NAME_IN_TABLE + InterfaceName + Locators.CLOSINGBRACKETS + Locators.FOLLOWING_COLUMNS_OF_INTERFACE_NAME + description + Locators.CLOSINGBRACKETS, "xpath");
		assertTrue(this.page.element(Locators.INTERFACE_NAME_IN_TABLE + InterfaceName + Locators.CLOSINGBRACKETS + Locators.FOLLOWING_COLUMNS_OF_INTERFACE_NAME + description + Locators.CLOSINGBRACKETS, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.INTERFACE_NAME_IN_TABLE + InterfaceName + Locators.CLOSINGBRACKETS + Locators.FOLLOWING_COLUMNS_OF_INTERFACE_NAME + description + Locators.CLOSINGBRACKETS, "xpath").getOne().isDisplayed());
		return this;
	}

	public InterfaceSetUp verifyCreatedInterfaceDetails(String interfaceName, String webServiceAction, String type, String schema, String description) throws Exception {
		this.verifyInterfaceInInterfaceList(interfaceName);
		this.verifyInterfaceIsActive(interfaceName);
		this.verifyInterfaceType(interfaceName, webServiceAction);
		this.verifyInterfaceType(interfaceName, type);
		this.verifyInterfaceSchema(interfaceName, schema);
		this.verifyInterfaceDescription(interfaceName, description);
		return this;
	}

	public InterfaceSetUp clickOnUsersLinkCorrespondingToInterface(String interfaceName) throws Exception {
		waitForElement.waitForElements(Locators.INTERFACE_NAME_IN_TABLE+interfaceName+Locators.CLOSINGBRACKETS+Locators.USERSLINK, "xpath");
		this.page.element(Locators.INTERFACE_NAME_IN_TABLE+interfaceName+Locators.CLOSINGBRACKETS+Locators.USERSLINK, "xpath").getOne().click();
		return this;
	}

	public InterfaceSetUp verifyRegionInterfaceUsersListPage() throws Exception {
		waitForElement.waitForElements(Locators.REGION_INTERFACE_USERS_LIST_PAGE, "xpath");
		assertTrue(this.page.element(Locators.REGION_INTERFACE_USERS_LIST_PAGE, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.REGION_INTERFACE_USERS_LIST_PAGE, "xpath").getOne().isDisplayed());
		return this;
	}

	public InterfaceSetUp verifyParameterListForInterfacePage(String interfaceName) throws Exception {
		waitForElement.waitForElements(Locators.PARAMETER_LIST_FOR_INTERFACE_HEADER+interfaceName+Locators.CLOSINGBRACKETS, "xpath");
		assertTrue(this.page.element(Locators.PARAMETER_LIST_FOR_INTERFACE_HEADER+interfaceName+Locators.CLOSINGBRACKETS, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.PARAMETER_LIST_FOR_INTERFACE_HEADER+interfaceName+Locators.CLOSINGBRACKETS, "xpath").getOne().isDisplayed());
		return this;
	}

	public InterfaceSetUp clickCreateNewParameter() throws Exception {
		waitForElement.waitForElements(Locators.CREATE_NEW_PARAMETER, "css");
		this.page.element(Locators.CREATE_NEW_PARAMETER, "css").getOne().click();
		waitForElement.waitForElements(Locators.PARAMETER_NAME, "name");
		return this;
	}

	public InterfaceSetUp enterParameterName(String parameterName) throws Exception {
		waitForElement.waitForElements(Locators.PARAMETER_NAME, "name");
		this.page.element(Locators.PARAMETER_NAME, "name").clearInputValue().sendKeys(parameterName);
		return this;
	}

	public InterfaceSetUp enterParameterValue(String parameterValue) throws Exception {
		waitForElement.waitForElements(Locators.PARAMETER_VALUE, "name");
		this.page.element(Locators.PARAMETER_VALUE, "name").clearInputValue().sendKeys(parameterValue);
		return this;
	}

	public InterfaceSetUp clickSaveParameter() throws Exception {
		waitForElement.waitForElements(Locators.SAVE, "css");
		this.page.element(Locators.SAVE, "css").getOne().click();
		waitForElement.waitForElements(Locators.CREATE_NEW_PARAMETER, "css");
		return this;
	}

	public InterfaceSetUp createParameter(String parameterName,String parameterValue) throws Exception {
		this.clickCreateNewParameter();
		this.enterParameterName(parameterName);
		this.enterParameterValue(parameterValue);
		this.clickSaveParameter();
		return this;
	}

	public InterfaceSetUp verifyInterfaceInInterfaceList(String interfaceName) throws Exception {
		String interface_Name=Locators.INTERFACE_NAME_IN_TABLE +interfaceName+ Locators.CLOSINGBRACKETS;
		waitForElement.waitForElements(interface_Name, "xpath");
		assertTrue(this.page.element(interface_Name, "xpath").isElementPresent());
		assertTrue(this.page.element(interface_Name, "xpath").getOne().isDisplayed());
		return this;
	}

	public InterfaceSetUp verifyActionsOfTheInterface(String interfaceName) throws Exception {
		this.verifyEditLink(interfaceName);
		this.verifyDeleteLink(interfaceName);
		this.verifyParametersLink(interfaceName);
		this.verifyUsersLink(interfaceName);
		return this;
	}

	public InterfaceSetUp verifyActionsAndStatusTypesOfInterface(String interfaceName) throws Exception {
		this.verifyActionsOfTheInterface(interfaceName);
		this.verifyStatusTypesLink(interfaceName);
		return this;
	}

	public InterfaceSetUp verifyActionsAndResourcesOfInterface(String interfaceName) throws Exception {
		this.verifyActionsOfTheInterface(interfaceName);
		this.verifyResourceLink(interfaceName);
		return this;
	}

	public InterfaceSetUp clickOnUsersLinkAndVerifyRegionInterfaceUsersListPageIsDisplayed(String interfaceName) throws Exception {
		this.clickOnUsersLinkCorrespondingToInterface(interfaceName);
		this.verifyRegionInterfaceUsersListPage();
		return this;
	}

	public InterfaceSetUp verifyParameterListForRegionInterfacePage(String interfaceName) throws Exception {
		waitForElement.waitForElements(Locators.PARAMETER_LIST_FOR_REGION_INTERFACE_PAGE+interfaceName+Locators.CLOSINGBRACKETS, "xpath");
		assertTrue(this.page.element(Locators.PARAMETER_LIST_FOR_REGION_INTERFACE_PAGE+interfaceName+Locators.CLOSINGBRACKETS, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.PARAMETER_LIST_FOR_REGION_INTERFACE_PAGE+interfaceName+Locators.CLOSINGBRACKETS, "xpath").getOne().isDisplayed());
		return this;
	}

	public InterfaceSetUp verifyActiveWebServicesActionOfInterfaceAndDelete(String webServiceAction) throws Exception {
		if(this.page.element(Locators.INTERFACE_NAME_IN_TABLE + webServiceAction + Locators.CLOSINGBRACKETS + Locators.ACTIVE_STATUS_CORRESPONDING_TO_WEBSERVICEACTION, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE)) {
			this.deleteActiveWebServiceAction(webServiceAction);
		}
		return this;
	}

	public InterfaceSetUp deleteActiveWebServiceAction(String webServiceAction) throws Exception {
		boolean alertIsPresnt = false;
		boolean bln = false;
		int i = 0;
		try {
			try {
				this.page.element(Locators.INTERFACE_NAME_IN_TABLE + webServiceAction + Locators.CLOSINGBRACKETS + Locators.DELETELINK, "xpath").getOne().click();
				System.out.println("clicked with click method");
				while (!bln && i < 5) {
					try {
						System.out.println("trying to switch to alert");
						alert = driver.switchTo().alert();
						break;
					} catch (Exception e) {
						System.out.println("got exception");
						i = i++;
						Thread.sleep(1000);
						continue;
					}
				}
				alertIsPresnt = driver.switchTo().alert() != null;
				System.out.println("1: "+alertIsPresnt);
				assertTrue(alertIsPresnt);
			}catch(Exception e) {
				this.page.element(Locators.INTERFACE_NAME_IN_TABLE + webServiceAction + Locators.CLOSINGBRACKETS + Locators.DELETELINK, "xpath").getOne().sendKeys(Keys.ENTER);
				System.out.println("clicked with sendkeys");
				alertIsPresnt = driver.switchTo().alert() != null;
				System.out.println("2: "+alertIsPresnt);
				assertTrue(alertIsPresnt);
			}
		} catch (Exception e) {
			this.page.element(Locators.INTERFACE_NAME_IN_TABLE + webServiceAction + Locators.CLOSINGBRACKETS + Locators.DELETELINK, "xpath").mouseOver();
			this.page.element(Locators.INTERFACE_NAME_IN_TABLE + webServiceAction + Locators.CLOSINGBRACKETS + Locators.DELETELINK, "xpath").Click();
			System.out.println("clicked with mouse hover and click");
			alertIsPresnt = driver.switchTo().alert() != null;
			System.out.println("3: "+alertIsPresnt);
			assertTrue(alertIsPresnt);
		}

		try{
			System.out.println("switched to alert popup");
			String deleteConfirmation = alert.getText();
			assertTrue(deleteConfirmation.equals("This region interface will be permanently deleted and cannot be recovered. Are you sure?"));
			alert.accept();
			System.out.println("clicked on ok button");
		} catch(Exception e){

		}
		this.page.element_wait(Locators.INTERFACE_NAME_IN_TABLE + webServiceAction + Locators.CLOSINGBRACKETS + Locators.ACTIVE_STATUS_CORRESPONDING_TO_WEBSERVICEACTION, "xpath").waitForInvisibilityOfElement();
		assertFalse(this.page.element(Locators.INTERFACE_NAME_IN_TABLE + webServiceAction + Locators.CLOSINGBRACKETS + Locators.ACTIVE_STATUS_CORRESPONDING_TO_WEBSERVICEACTION, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}

	public InterfaceSetUp verifyAllActionsOfInterface(String interfaceName) throws Exception {
		this.verifyActionsOfTheInterface(interfaceName);
		this.verifyStatusTypesLink(interfaceName);
		this.verifyResourceLink(interfaceName);
		return this;
	}

	public InterfaceSetUp clickOnCancel() throws Exception {
		waitForElement.waitForElements(Locators.CANCEL, "css");
		this.page.element(Locators.CANCEL, "css").clickUsingJSE();
		return this;
	}

	public InterfaceSetUp verifyCreateNewParameterButton(String interfaceName) throws Exception {
		waitForElement.waitForElements(Locators.CREATE_NEW_PARAMETER, "css");
		assertTrue(this.page.element(Locators.CREATE_NEW_PARAMETER, "css").isElementPresent());
		assertTrue(this.page.element(Locators.CREATE_NEW_PARAMETER, "css").getOne().isDisplayed());
		return this;
	}

	public InterfaceSetUp clickOnParametersLinkAndVerifyParameterListForRegionInterfacePageIsDisplayed(String interfaceName) throws Exception {
		this.clickParametersLink(interfaceName);
		this.verifyParameterListForRegionInterfacePage(interfaceName);
		this.verifyCreateNewParameterButton(interfaceName);
		return this;
	}

	public InterfaceSetUp verifyEditLinkCorrespondingToParameter(String parameterName) throws Exception {
		parameterName=parameterName.toUpperCase();
		waitForElement.waitForElements(Locators.INTERFACE_NAME_IN_TABLE + parameterName + Locators.CLOSINGBRACKETS + Locators.EDIT_PARAMETER , "xpath");
		assertTrue(this.page.element(Locators.INTERFACE_NAME_IN_TABLE + parameterName + Locators.CLOSINGBRACKETS + Locators.EDIT_PARAMETER , "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.INTERFACE_NAME_IN_TABLE + parameterName + Locators.CLOSINGBRACKETS + Locators.EDIT_PARAMETER , "xpath").getOne().isDisplayed());
		return this;
	}

	public InterfaceSetUp verifyDeleteLinkCorrespondingToParameter(String parameterName) throws Exception {
		parameterName=parameterName.toUpperCase();
		waitForElement.waitForElements(Locators.INTERFACE_NAME_IN_TABLE + parameterName + Locators.CLOSINGBRACKETS + Locators.DELETE_PARAMETER , "xpath");
		assertTrue(this.page.element(Locators.INTERFACE_NAME_IN_TABLE + parameterName + Locators.CLOSINGBRACKETS + Locators.DELETE_PARAMETER, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.INTERFACE_NAME_IN_TABLE + parameterName + Locators.CLOSINGBRACKETS + Locators.DELETE_PARAMETER , "xpath").getOne().isDisplayed());
		return this;
	}

	public InterfaceSetUp verifyEditAndDeleteLinksCorrespondingToParameter(String parameterName) throws Exception {
		verifyEditLinkCorrespondingToParameter(parameterName);
		verifyDeleteLinkCorrespondingToParameter(parameterName);
		return this;
	}

	public InterfaceSetUp navigateToInterFaceAndClickStatusTypeLink(String interfaceName) throws Exception {
		navigateTo.interfaces();
		this.clickStatusTypesLink(interfaceName);
		return this;
	}
	public InterfaceSetUp verfiyRegionStatusTypeColumnInSelectInterfaceStatusTypePage() throws Exception {
		waitForElement.waitForElements(Locators.REGIONAL_STATUS_TYPE_COLUMN, "linktext");
		assertTrue(this.page.element(Locators.REGIONAL_STATUS_TYPE_COLUMN, "linktext").isElementPresent());
		assertTrue(this.page.element(Locators.REGIONAL_STATUS_TYPE_COLUMN, "linktext").getOne().isDisplayed());
		return this;		
	}

	public InterfaceSetUp verifySelectInterfaceStatusTypePage() throws Exception {
		waitForElement.waitForElements(Locators.SELECT_INTERFACE_STATUS_TYPES_PAGE, "xpath");
		assertTrue(this.page.element(Locators.SELECT_INTERFACE_STATUS_TYPES_PAGE, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.SELECT_INTERFACE_STATUS_TYPES_PAGE, "xpath").getOne().isDisplayed());
		assertTrue(this.page.element(Locators.REQUIRED_STATUS_TYPE_MAPPING_HEADER, "xpath").getOne().isDisplayed());
		verfiyRegionStatusTypeColumnInSelectInterfaceStatusTypePage();
		return this;
	}

	public InterfaceSetUp verifyParameterValue(String parameterName, String parameterValue) throws Exception {
		waitForElement.waitForElements(Locators.INTERFACE_NAME_IN_TABLE + parameterName + Locators.CLOSINGBRACKETS + Locators.FOLLOWING_COLUMNS_OF_INTERFACE_NAME + parameterValue + Locators.CLOSINGBRACKETS, "xpath");
		assertTrue(this.page.element(Locators.INTERFACE_NAME_IN_TABLE + parameterName + Locators.CLOSINGBRACKETS + Locators.FOLLOWING_COLUMNS_OF_INTERFACE_NAME + parameterValue + Locators.CLOSINGBRACKETS, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.INTERFACE_NAME_IN_TABLE + parameterName + Locators.CLOSINGBRACKETS + Locators.FOLLOWING_COLUMNS_OF_INTERFACE_NAME + parameterValue + Locators.CLOSINGBRACKETS, "xpath").getOne().isDisplayed());
		return this;
	}

	public InterfaceSetUp verifyEditInterfaceSelectResourcesPage() throws Exception {
		waitForElement.waitForElements(Locators.EDITINTERFACE_SELECTRESOURCES_PAGE, "xpath");
		assertTrue(this.page.element(Locators.EDITINTERFACE_SELECTRESOURCES_PAGE, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.EDITINTERFACE_SELECTRESOURCES_PAGE, "xpath").getOne().isDisplayed());
		return this;
	}  

	public InterfaceSetUp verifyWebServiceUserUnderRegionInterfaceUsersListPage(String webServiceUserName,String webServiceUserFullName) throws Exception {
		this.verifyRegionInterfaceUsersListPage();
		System.out.println(Locators.INTERFACE_NAME_IN_TABLE+webServiceUserFullName+Locators.CLOSINGBRACKETS+Locators.FOLLOWING_COLUMNS_OF_INTERFACE_NAME+webServiceUserName+Locators.CLOSINGBRACKETS);
		assertTrue(this.page.element(Locators.INTERFACE_NAME_IN_TABLE+webServiceUserFullName+Locators.CLOSINGBRACKETS+Locators.FOLLOWING_COLUMNS_OF_INTERFACE_NAME+webServiceUserName+Locators.CLOSINGBRACKETS, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.INTERFACE_NAME_IN_TABLE+webServiceUserFullName+Locators.CLOSINGBRACKETS+Locators.FOLLOWING_COLUMNS_OF_INTERFACE_NAME+webServiceUserName+Locators.CLOSINGBRACKETS,"xpath").getOne().isDisplayed());
		return this;
	}

	public InterfaceSetUp verifyNoOtherUserIsDisplayedExcpetWebServiceUserOnRegionInterfaceList(String username,String fullName) throws Exception {
		this.verifyRegionInterfaceUsersListPage();
		assertFalse(this.page.element(Locators.INTERFACE_NAME_IN_TABLE+fullName+Locators.CLOSINGBRACKETS+Locators.FOLLOWING_COLUMNS_OF_INTERFACE_NAME+username+Locators.CLOSINGBRACKETS, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}

	public InterfaceSetUp clickOnStatusTypesLinkCorrespondingToInterface(String interfaceName) throws Exception {
		waitForElement.waitForElements(Locators.INTERFACE_NAME_IN_TABLE+interfaceName+Locators.CLOSINGBRACKETS+Locators.STATUSTYPESLINK, "xpath");
		this.page.element(Locators.INTERFACE_NAME_IN_TABLE+interfaceName+Locators.CLOSINGBRACKETS+Locators.STATUSTYPESLINK, "xpath").clickUsingJSE();
		return this;
	}

	public InterfaceSetUp verifySelectInterfaceStatusTypes() throws Exception {
		waitForElement.waitForElements(Locators.SELECT_INTERFACE_STATUS_TYPES_PAGE, "xpath");
		assertTrue(this.page.element(Locators.SELECT_INTERFACE_STATUS_TYPES_PAGE, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.SELECT_INTERFACE_STATUS_TYPES_PAGE, "xpath").getOne().isDisplayed());
		return this;
	}

	public InterfaceSetUp verifyParameterIsListed(String parameterName) throws Exception {
		parameterName=parameterName.toUpperCase();
		String parameter_Name=Locators.INTERFACE_NAME_IN_TABLE +parameterName+ Locators.CLOSINGBRACKETS;
		waitForElement.waitForElements(parameter_Name, "xpath");
		assertTrue(this.page.element(parameter_Name, "xpath").isElementPresent());
		assertTrue(this.page.element(parameter_Name, "xpath").getOne().isDisplayed());
		return this;
	}

	public InterfaceSetUp editInterface(String editedName,String editedDescription) throws Exception { 	
		this.enterEditedInterfaceName(editedName);
		this.enterInterfaceDescription(editedDescription);
		this.clickSave();
		return this;
	}

	public InterfaceSetUp editParameterCorrespondingToInterface(String interfaceName,String parameterName,String editParameterName, String editParameterValue) throws Exception {
		this.clickParametersLink(interfaceName);
		this.clickOnEditOfParameter(parameterName);
		this.enterParameterName(editParameterName);
		this.enterParameterValue(editParameterValue);
		this.clickSave();
		return this;
	}

	public InterfaceSetUp verifyEditedInterfaceDetails(String editedInterfaceName,String editedDescription) throws Exception {
		this.verifyInterfaceInInterfaceList(editedInterfaceName);
		this.verifyInterfaceDescription(editedInterfaceName, editedDescription);
		return this;
	}

	public InterfaceSetUp verifyCreatedParameterDetails(String interfaceName, String parameterName, String parameterValue) throws Exception {
		this.verifyParameterListForRegionInterfacePage(interfaceName);
		this.verifyParameterIsListed(parameterName);
		this.verifyParameterValue(parameterName, parameterValue);
		return this;
	}

	public InterfaceSetUp clickOnUsersLinkAndVerifyProductInterfaceUsersListPageIsDisplayed(String interfaceName) throws Exception {
		this.clickOnUsersLinkCorrespondingToInterface(interfaceName);
		this.verifyProductInterfaceUsersListPage();
		return this;
	}

	public InterfaceSetUp clickOnParametersLinkAndVerifyParameterListForInterfacePageIsDisplayed(String interfaceName) throws Exception {
		this.clickParametersLink(interfaceName);
		this.verifyParameterListForInterfacePage(interfaceName);
		this.verifyCreateNewParameterButton(interfaceName);
		return this;
	}

	public InterfaceSetUp verifyEditedParameterDetails(String editParameterName, String editParameterValue) throws Exception {
		this.verifyParameterIsListed(editParameterName);
		this.verifyParameterValue(editParameterName, editParameterValue);
		return this;
	}

	public InterfaceSetUp verifyEditRegionInterfacePage() throws Exception {
		waitForElement.waitForElements(Locators.EDIT_REGION_INTERFACE_PAGE, "xpath");
		assertTrue(this.page.element(Locators.EDIT_REGION_INTERFACE_PAGE, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.EDIT_REGION_INTERFACE_PAGE, "xpath").getOne().isDisplayed());
		return this;
	}

	public InterfaceSetUp deleteParameterOfRegionInterfaceAndVerifyParameterIsNotDisplayed(String parameterName) throws Exception {
		boolean alertIsPresnt = false;
		boolean bln = false;
		int i = 0;
		try {
			try {
				this.page.element(Locators.INTERFACE_NAME_IN_TABLE + parameterName + Locators.CLOSINGBRACKETS + Locators.DELETE_PARAMETER, "xpath").getOne().click();
				System.out.println("clicked with click method");
				while (!bln && i < 5) {
					try {
						System.out.println("trying to switch to alert");
						alert = driver.switchTo().alert();
						break;
					} catch (Exception e) {
						System.out.println("got exception");
						Thread.sleep(1000);						
					}
					i = i++;
				}
				alertIsPresnt = driver.switchTo().alert() != null;
				System.out.println("1: "+alertIsPresnt);
				assertTrue(alertIsPresnt);
			}catch(Exception e) {
				this.page.element(Locators.INTERFACE_NAME_IN_TABLE + parameterName + Locators.CLOSINGBRACKETS + Locators.DELETE_PARAMETER, "xpath").getOne().sendKeys(Keys.ENTER);
				System.out.println("clicked with sendkeys");
				alertIsPresnt = driver.switchTo().alert() != null;
				System.out.println("2: "+alertIsPresnt);
				assertTrue(alertIsPresnt);
			}
		} catch (Exception e) {
			this.page.element(Locators.INTERFACE_NAME_IN_TABLE + parameterName + Locators.CLOSINGBRACKETS + Locators.DELETE_PARAMETER, "xpath").mouseOver();
			this.page.element(Locators.INTERFACE_NAME_IN_TABLE + parameterName + Locators.CLOSINGBRACKETS + Locators.DELETE_PARAMETER, "xpath").Click();
			System.out.println("clicked with mouse hover and click");
			alertIsPresnt = driver.switchTo().alert() != null;
			System.out.println("3: "+alertIsPresnt);
			assertTrue(alertIsPresnt);
		}

		try{
			System.out.println("switched to alert popup");
			String deleteConfirmation = alert.getText();
			assertTrue(deleteConfirmation.equals("This region interface parameter will be permanently deleted and cannot be recovered. Are you sure?"));
			alert.accept();
			System.out.println("clicked on ok button");
		} catch(Exception e){

		}
		this.page.element_wait(Locators.INTERFACE_NAME_IN_TABLE + parameterName + Locators.CLOSINGBRACKETS , "xpath").waitForInvisibilityOfElement();
		assertFalse(this.page.element(Locators.INTERFACE_NAME_IN_TABLE + parameterName + Locators.CLOSINGBRACKETS , "xpath").isElementPresent());
		return this;
	}

	public InterfaceSetUp clickOnDeleteCorrespondingToInterfaceAndDismiss(String interfaceName) throws Exception {
		boolean alertIsPresnt = false;
		boolean bln = false;
		int i = 0;
		try {
			try {
				this.page.element(Locators.INTERFACE_NAME_IN_TABLE + interfaceName + Locators.CLOSINGBRACKETS + Locators.DELETELINK, "xpath").getOne().click();
				System.out.println("clicked with click method");
				while (!bln && i < 5) {
					try {
						System.out.println("trying to switch to alert");
						alert = driver.switchTo().alert();
						break;
					} catch (Exception e) {
						System.out.println("got exception");

						Thread.sleep(1000);
					}
					i = i++;
				}
				alertIsPresnt = driver.switchTo().alert() != null;
				System.out.println("1: "+alertIsPresnt);
				assertTrue(alertIsPresnt);
			}catch(Exception e) {
				this.page.element(Locators.INTERFACE_NAME_IN_TABLE + interfaceName + Locators.CLOSINGBRACKETS + Locators.DELETELINK, "xpath").getOne().sendKeys(Keys.ENTER);
				System.out.println("clicked with sendkeys");
				alertIsPresnt = driver.switchTo().alert() != null;
				System.out.println("2: "+alertIsPresnt);
				assertTrue(alertIsPresnt);
			}
		} catch (Exception e) {
			this.page.element(Locators.INTERFACE_NAME_IN_TABLE + interfaceName + Locators.CLOSINGBRACKETS + Locators.DELETELINK, "xpath").mouseOver();
			this.page.element(Locators.INTERFACE_NAME_IN_TABLE + interfaceName + Locators.CLOSINGBRACKETS + Locators.DELETELINK, "xpath").Click();
			System.out.println("clicked with mouse hover and click");
			alertIsPresnt = driver.switchTo().alert() != null;
			System.out.println("3: "+alertIsPresnt);
			assertTrue(alertIsPresnt);
		}

		try{
			System.out.println("switched to alert popup");
			String deleteConfirmation = alert.getText();
			assertTrue(deleteConfirmation.equals("This region interface will be permanently deleted and cannot be recovered. Are you sure?"));
			alert.dismiss();
			System.out.println("clicked on cancel button");
		} catch(Exception e){

		}
		this.page.element_wait(Locators.INTERFACE_NAME_IN_TABLE + interfaceName + Locators.CLOSINGBRACKETS , "xpath").waitForVisibilityOfElement();
		assertTrue(this.page.element(Locators.INTERFACE_NAME_IN_TABLE + interfaceName + Locators.CLOSINGBRACKETS , "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.INTERFACE_NAME_IN_TABLE + interfaceName + Locators.CLOSINGBRACKETS , "xpath").getOne().isDisplayed());
		return this;
	}

	public InterfaceSetUp clickOnDeleteCorrespondingToInterfaceAndAccept(String interfaceName) throws Exception {
		boolean alertIsPresnt = false;
		boolean bln = false;
		int i = 0;
		try {
			try {
				this.page.element(Locators.INTERFACE_NAME_IN_TABLE + interfaceName + Locators.CLOSINGBRACKETS + Locators.DELETELINK, "xpath").getOne().click();
				System.out.println("clicked with click method");
				while (!bln && i < 5) {
					try {
						System.out.println("trying to switch to alert");
						alert = driver.switchTo().alert();
						break;
					} catch (Exception e) {
						System.out.println("got exception");
						Thread.sleep(1000);
					}
					i = i++;
				}
				alertIsPresnt = driver.switchTo().alert() != null;
				System.out.println("1: "+alertIsPresnt);
				assertTrue(alertIsPresnt);
			}catch(Exception e) {
				this.page.element(Locators.INTERFACE_NAME_IN_TABLE + interfaceName + Locators.CLOSINGBRACKETS + Locators.DELETELINK, "xpath").getOne().sendKeys(Keys.ENTER);
				System.out.println("clicked with sendkeys");
				alertIsPresnt = driver.switchTo().alert() != null;
				System.out.println("2: "+alertIsPresnt);
				assertTrue(alertIsPresnt);
			}
		} catch (Exception e) {
			this.page.element(Locators.INTERFACE_NAME_IN_TABLE + interfaceName + Locators.CLOSINGBRACKETS + Locators.DELETELINK, "xpath").mouseOver();
			this.page.element(Locators.INTERFACE_NAME_IN_TABLE + interfaceName + Locators.CLOSINGBRACKETS + Locators.DELETELINK, "xpath").Click();
			System.out.println("clicked with mouse hover and click");
			alertIsPresnt = driver.switchTo().alert() != null;
			System.out.println("3: "+alertIsPresnt);
			assertTrue(alertIsPresnt);
		}
		try{
			System.out.println("switched to alert popup");
			String deleteConfirmation = alert.getText();
			assertTrue(deleteConfirmation.equals("This region interface will be permanently deleted and cannot be recovered. Are you sure?"));
			alert.accept();
			System.out.println("clicked on ok button");
		} catch(Exception e){

		}
		this.page.element_wait(Locators.INTERFACE_NAME_IN_TABLE + interfaceName + Locators.CLOSINGBRACKETS , "xpath").waitForInvisibilityOfElement();
		assertFalse(this.page.element(Locators.INTERFACE_NAME_IN_TABLE + interfaceName + Locators.CLOSINGBRACKETS , "xpath").isElementPresent());
		return this;
	}

	public InterfaceSetUp deleteParameterOfInterfaceAndVerifyParameterIsNotDisplayed(String parameterName) throws Exception {
		boolean alertIsPresnt = false;
		boolean bln = false;
		int i = 0;
		try {
			try {
				this.page.element(Locators.INTERFACE_NAME_IN_TABLE + parameterName + Locators.CLOSINGBRACKETS + Locators.DELETE_PARAMETER, "xpath").getOne().click();
				System.out.println("clicked with click method");
				while (!bln && i < 5) {
					try {
						System.out.println("trying to switch to alert");
						alert = driver.switchTo().alert();
						break;
					} catch (Exception e) {
						System.out.println("got exception");
						Thread.sleep(1000);

					}
					i = i++;
				}
				alertIsPresnt = driver.switchTo().alert() != null;
				System.out.println("1: "+alertIsPresnt);
				assertTrue(alertIsPresnt);
			}catch(Exception e) {
				this.page.element(Locators.INTERFACE_NAME_IN_TABLE + parameterName + Locators.CLOSINGBRACKETS + Locators.DELETE_PARAMETER, "xpath").getOne().sendKeys(Keys.ENTER);
				System.out.println("clicked with sendkeys");
				alertIsPresnt = driver.switchTo().alert() != null;
				System.out.println("2: "+alertIsPresnt);
				assertTrue(alertIsPresnt);
			}
		} catch (Exception e) {
			this.page.element(Locators.INTERFACE_NAME_IN_TABLE + parameterName + Locators.CLOSINGBRACKETS + Locators.DELETE_PARAMETER, "xpath").mouseOver();
			this.page.element(Locators.INTERFACE_NAME_IN_TABLE + parameterName + Locators.CLOSINGBRACKETS + Locators.DELETE_PARAMETER, "xpath").Click();
			System.out.println("clicked with mouse hover and click");
			alertIsPresnt = driver.switchTo().alert() != null;
			System.out.println("3: "+alertIsPresnt);
			assertTrue(alertIsPresnt);
		}

		try{
			System.out.println("switched to alert popup");
			String deleteConfirmation = alert.getText();
			assertTrue(deleteConfirmation.equals("This interface parameter will be permanently deleted and cannot be recovered. Are you sure?"));
			alert.accept();
			System.out.println("clicked on ok button");
		} catch(Exception e){

		}
		this.page.element_wait(Locators.INTERFACE_NAME_IN_TABLE + parameterName + Locators.CLOSINGBRACKETS , "xpath").waitForInvisibilityOfElement();
		assertFalse(this.page.element(Locators.INTERFACE_NAME_IN_TABLE + parameterName + Locators.CLOSINGBRACKETS , "xpath").isElementPresent());
		return this;
	}

	public InterfaceSetUp verifyEditProductInterfacePage() throws Exception {
		waitForElement.waitForElements(Locators.EDIT_PRODUCT_INTERFACE_PAGE, "xpath");
		assertTrue(this.page.element(Locators.EDIT_PRODUCT_INTERFACE_PAGE, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.EDIT_PRODUCT_INTERFACE_PAGE, "xpath").getOne().isDisplayed());
		return this;
	}
	public InterfaceSetUp createInterfaceByProvidingMandatoryData(String name,String description,String webServiceAction) throws Exception {
		this.enterInterfaceName(name);
		this.enterInterfaceDescription(description);
		this.verifyAppropraiteWebServiceAction(webServiceAction);
		this.selectActive();
		this.clickSave();
		return this;
	}

	public InterfaceSetUp verifyCreateRegionInterfaceParameterPage() throws Exception {
		waitForElement.waitForElements(Locators.CREATE_REGION_INTERFACE_PARAMETER_PAGE, "xpath");
		assertTrue(this.page.element(Locators.CREATE_REGION_INTERFACE_PARAMETER_PAGE, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.CREATE_REGION_INTERFACE_PARAMETER_PAGE, "xpath").getOne().isDisplayed());
		return this;
	}

	public InterfaceSetUp verifyParameterNameFieldIsDisplayed() throws Exception {
		waitForElement.waitForElements(Locators.PARAMETER_NAME, "name");
		assertTrue(this.page.element(Locators.PARAMETER_NAME, "name").isElementPresent());
		assertTrue(this.page.element(Locators.PARAMETER_NAME, "name").getOne().isDisplayed());
		return this;
	}

	public InterfaceSetUp verifyParameterValueFieldIsDisplayed() throws Exception {
		waitForElement.waitForElements(Locators.PARAMETER_VALUE, "name");
		assertTrue(this.page.element(Locators.PARAMETER_VALUE, "name").isElementPresent());
		assertTrue(this.page.element(Locators.PARAMETER_VALUE, "name").getOne().isDisplayed());
		return this;
	}

	public InterfaceSetUp clickOnCreateNewParameterAndVerifyCreateRegionInterfaceParameterPage() throws Exception {
		this.clickCreateNewParameter();
		this.verifyCreateRegionInterfaceParameterPage();
		this.verifyParameterNameFieldIsDisplayed();
		this.verifyParameterValueFieldIsDisplayed();
		return this;
	}

	public InterfaceSetUp createParameterByProvidingMandatoryData(String parameterName,String parameterValue) throws Exception {
		this.enterParameterName(parameterName);
		this.enterParameterValue(parameterValue);
		this.clickSaveParameter();
		return this;
	}

	public InterfaceSetUp clickOnEditLinkAndVerifyEditRegionInterfacePage(String interfaceName) throws Exception {
		this.clickEditLink(interfaceName);
		this.verifyEditRegionInterfacePage();
		return this;
	}

	public InterfaceSetUp editParameter(String parameterName, String editParameterName, String editParameterValue) throws Exception {
		this.clickEditLink(parameterName);
		this.enterParameterName(editParameterName);
		this.enterParameterValue(editParameterValue);
		this.clickSave();
		return this;
	}

	public InterfaceSetUp selectInterfaceTypeAndVerifyCreateRegionInterfacePage(String interfaceType) throws Exception {
		this.clickCreateNewInterface();
		this.selectInterfaceType(interfaceType);
		this.clickNext();  		
		this.verifyCreateRegionInterfacePage();
		return this;
	}

	public InterfaceSetUp verifyInterfaceNameIsRetained(String interfaceName) throws Exception {
		waitForElement.waitForElements(Locators.NAME_FOR_REGION_INTERFACE, "name");
		assertTrue(this.page.element(Locators.NAME_FOR_REGION_INTERFACE, "name").isElementPresent());
		assertTrue(this.page.element(Locators.NAME_FOR_REGION_INTERFACE, "name").getOne().isDisplayed());
		assertTrue(this.page.element(Locators.NAME_FOR_REGION_INTERFACE, "name").getOne().getAttribute("value").equals(interfaceName));
		return this;
	}

	public InterfaceSetUp verifyInterfaceDescriptionIsRetained(String interfaceDescription) throws Exception {
		waitForElement.waitForElements(Locators.DESCRIPTION, "name");
		assertTrue(this.page.element(Locators.DESCRIPTION, "name").isElementPresent());
		assertTrue(this.page.element(Locators.DESCRIPTION, "name").getOne().isDisplayed());
		assertTrue(this.page.element(Locators.DESCRIPTION, "name").getOne().getAttribute("value").equals(interfaceDescription));
		return this;
	}

	public InterfaceSetUp verifyInterfaceRetainedDetails(String interfaceName, String interfaceDescription) throws Exception {
		this.verifyInterfaceNameIsRetained(interfaceName);
		this.verifyInterfaceDescriptionIsRetained(interfaceDescription);
		return this;
	}

	public InterfaceSetUp verifyCreateProductInterfacePage() throws Exception {
		waitForElement.waitForElements(Locators.CREATE_PRODUCT_INTERFACE_PAGE, "xpath");
		assertTrue(this.page.element(Locators.CREATE_PRODUCT_INTERFACE_PAGE, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.CREATE_PRODUCT_INTERFACE_PAGE, "xpath").getOne().isDisplayed());
		return this;
	}

	public InterfaceSetUp enterEditedInterfaceName(String name) throws Exception {
		waitForElement.waitForElements(Locators.DESCRIPTION, "name");
		if(this.page.element(Locators.NAME_FOR_REGION_INTERFACE, "name").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE)){
			this.page.element(Locators.NAME_FOR_REGION_INTERFACE, "name").clearInputValue().sendKeys(name);
			assertTrue(this.page.element(Locators.NAME_FOR_REGION_INTERFACE, "name").getOne().getAttribute("value").equals(name));
			this.verifyEditRegionInterfacePage();
		}
		else{
			this.page.element(Locators.NAME_FOR_MULTIREGION_INTERFACE, "name").clearInputValue().sendKeys(name);
			assertTrue(this.page.element(Locators.NAME_FOR_MULTIREGION_INTERFACE, "name").getOne().getAttribute("value").equals(name));
			this.verifyEditProductInterfacePage();
		}
		return this;
	}	

	public InterfaceSetUp verifyOptionalStatusTypeMappingsSection() throws Exception {
		waitForElement.waitForElements(Locators.OPTIONAL_STATUS_TYPE_MAPPINGS, "xpath");
		assertTrue(this.page.element(Locators.OPTIONAL_STATUS_TYPE_MAPPINGS, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.OPTIONAL_STATUS_TYPE_MAPPINGS, "xpath").getOne().isDisplayed());
		return this;
	}

	public InterfaceSetUp verifyOptionsInSelectInterfaceStatusTypes(String statusTypeMapping) throws Exception {
		waitForElement.waitForElements(Locators.SELECT_INTERFACE_STATUS_TYPES_PAGE, "xpath");
		for(int i=1;i<=InterfaceData.OPTIONS.length;i++){
			if(i==1) {
				String option= this.page.element(Locators.STATUS_TYPES_MAPPING_1 + statusTypeMapping + Locators.COLUMN_HEADERS + i + Locators.CLOSINGBRACKETS_WITHOUT_QUOTE, "xpath").getOne().getText();
				System.out.println(option);
				assertTrue(option.equals(InterfaceData.OPTIONS[i-1]), option+" is not present.");
			} else {
				String option= this.page.element(Locators.STATUS_TYPES_MAPPING_1 + statusTypeMapping + Locators.COLUMN_HEADERS + i + Locators.CLOSINGBRACKETS_WITHOUT_QUOTE + Locators.ANCHOR_TAG, "xpath").getOne().getText();
				System.out.println(option);
				assertTrue(option.equals(InterfaceData.OPTIONS[i-1]), option+" is not present.");
			}
		}
		return this; 	
	}

	public InterfaceSetUp verifyWebServiceActionIsActive(String interfaceName, String webServiceAction) throws Exception {
		this.verifyWebServiceActionOfInterface(interfaceName, webServiceAction);
		this.verifyInterfaceIsActive(interfaceName);
		return this;
	}

	public InterfaceSetUp verifyResourceIsSelectedUnderEditInterfaceSelectResourcesPage(String interfaceName, String resourceName) throws Exception {
		this.clickResourceLink(interfaceName);
		waitForElement.waitForElements(Locators.EDITINTERFACE_SELECTRESOURCES_PAGE, "xpath");
		assertTrue(this.page.element(Locators.ALLOWED_RESOURCES_PART1 + resourceName + Locators.ALLOWED_RESOURCES_PART2, "xpath").getOne().isDisplayed(), "Resource check box is not present");
		assertTrue(this.page.element(Locators.ALLOWED_RESOURCES_PART1 + resourceName + Locators.ALLOWED_RESOURCES_PART2, "xpath").getOne().isSelected(), "Resource check box is not selected");
		return this;
	}
	
	public InterfaceSetUp clickOnEditOfParameter(String parameterName) throws Exception {
		waitForElement.waitForElements(Locators.INTERFACE_NAME_IN_TABLE + parameterName + Locators.CLOSINGBRACKETS+Locators.EDIT_PARAMETER, "xpath");
		this.page.element(Locators.INTERFACE_NAME_IN_TABLE + parameterName + Locators.CLOSINGBRACKETS+Locators.EDIT_PARAMETER,"xpath").getOne().click();
		return this;
	}
	
	public InterfaceSetUp enterProductInterfaceKey(String key) throws Exception {
		waitForElement.waitForElements(Locators.PRODUCT_INTERFACE_KEY, "name");
		this.page.element(Locators.PRODUCT_INTERFACE_KEY, "name").clearInputValue().sendKeys(key);
		return this;
	}
	
	public InterfaceSetUp createProductInterface(String name,String description,String interfaceType,String webServiceAction,String key) throws Exception {
		this.verifyActiveWebServicesActionOfInterfaceAndDelete(webServiceAction);
		this.clickCreateNewInterface();
		this.selectInterfaceType(interfaceType);
		this.clickNext();  		
		this.enterInterfaceName(name);
		this.enterInterfaceDescription(description);
		this.verifyAppropraiteWebServiceAction(webServiceAction);
		this.enterProductInterfaceKey(key);
		this.selectActive();
		this.clickSave();
		return this;
	}
	
	public InterfaceSetUp verifyEnteredInterfaceKeyUnderEditInterfacePage(String key) throws Exception {
		waitForElement.waitForElements(Locators.PRODUCT_INTERFACE_KEY_IN_EDIT_INTERFACE_PAGE+key+Locators.CLOSINGBRACKETS, "css");
		assertTrue(this.page.element(Locators.PRODUCT_INTERFACE_KEY_IN_EDIT_INTERFACE_PAGE+key+Locators.CLOSINGBRACKETS, "css").isElementPresent());
		assertTrue(this.page.element(Locators.PRODUCT_INTERFACE_KEY_IN_EDIT_INTERFACE_PAGE+key+Locators.CLOSINGBRACKETS, "css").getOne().isDisplayed());
		return this;
	}
}