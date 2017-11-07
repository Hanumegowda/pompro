package lib.page;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import qaframework.lib.WaitTimeConstants;
import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;

public class InterfacesInSetUp extends PageObject{
	
	WebDriver driver;
	WaitForElement objWaitForElement;
	
	private String createNewInterface = "//input[@value='Create New Interface']",
				   interFaceListScreen = "//div[@id='topSubNav']/h1[text()='Interface List']",
				   interfaceListTblHeaders = "//div[@id='mainContainer']/table/thead/tr/",
				   selInterfaceTypeDropDown = "interfaceID",
				   nextInSelInterfaceType = "//input[@value='Next']",
				   cancelInSelInterfaceType = "//input[@value='Cancel']",
				   name	= "regionInterfaceName",
				   description = "description",
				   contInfo = "contactInfo",
				   activeChkBox = "active",
				   interfaceKey = "interfaceKey",
				   webServAction = "actionName",
				   resIdenMethod = "resourceIdField",
				   saveInCreateInterfaceScreen = "//input[@value='Save']",
				   interfaceListTbl = "//div[@id='mainContainer']/table/tbody/tr/",
				   WebServicesAction = "//tbody//td[text()='Web Services Action:']/..//td/input",
				   OptionalStatusTypeMappings = "//tbody//td[text()='Optional Status Type Mappings']/../following-sibling::tr//table[@summary='Optional Status Type Mappings']",
				   CustomStatusTypeMappings = "//tbody//td[text()='Custom Status Type Mappings']/../following-sibling::tr//table[@summary='Custom Status Type Mappings']",
				   paraName="//input[@name='parmName']",
				   paramValue="//input[@name='parmValue']",
				  searchInputField="tbl_userID_SEARCH_TEXT", 
				  search="tbl_userID_SEARCH",
				  selectResourceForInterfacePage = "//div[@id='topSubNav']/h1[text()='Edit Interface -- Select Resources']";
				

	public InterfacesInSetUp(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
	}
	
	/**********************************************************************************
	* Description 	: This function is used verify interface list screen is displayed. 
	* Date 			: 04/08/2014
	* Author 		: Renushree
	**********************************************************************************/
	public InterfacesInSetUp verifyInterfaceListScreen() throws Exception {
		objWaitForElement.waitForElements(interFaceListScreen, "xpath");
		assertTrue(this.page.element(interFaceListScreen, "xpath")
				.getOne().isDisplayed());
		assertTrue(this.page.element(createNewInterface, "xpath")
				.getOne().isDisplayed());
		assertTrue(this.page.element(
				interfaceListTblHeaders + "th[1][text()='Action']", "xpath")
						.getOne().isDisplayed());
		assertTrue(this.page.element(
				interfaceListTblHeaders + "th[2]/a[text()='Name']", "xpath")
						.getOne().isDisplayed());
		assertTrue(this.page.element(
				interfaceListTblHeaders + "th[3]/a[text()='Active']", "xpath")
				.getOne().isDisplayed());
		assertEquals("Web Services Action",
				this.page.element(interfaceListTblHeaders + "th[4]/a", "xpath")
						.getOne().getText());
		assertTrue(this.page.element(
				interfaceListTblHeaders + "th[5]/a[text()='Type']", "xpath")
				.getOne().isDisplayed());
		assertTrue(this.page.element(
				interfaceListTblHeaders + "th[6]/a[text()='Schema']", "xpath")
				.getOne().isDisplayed());
		assertTrue(this.page.element(
				interfaceListTblHeaders + "th[7]/a[text()='Description']", "xpath")
				.getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is used click on create new interface button.
	* Date 			: 04/08/2014
	* Author 		: Renushree
	**********************************************************************************/
	public InterfacesInSetUp clickOnCreateNewInterfaceBtn() throws Exception {
		objWaitForElement.waitForElements(createNewInterface, "xpath");
		this.page.element(createNewInterface, "xpath").getOne().click();
		objWaitForElement.waitForElements(selInterfaceTypeDropDown, "name");
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is used verify select interface type screen is displayed. 
	* Arguments		: strDropDownValues
	* Date 			: 04/08/2014
	* Author 		: Renushree
	**********************************************************************************/
	public InterfacesInSetUp verifySelInterfaceTypeScreen(
			String[] strDropDownValues) throws Exception {
		ArrayList<String> l1 = new ArrayList<String>(
				Arrays.asList(strDropDownValues));
		ArrayList<String> l3 = new ArrayList<String>();
		List<WebElement> l2 = this.page
				.element(selInterfaceTypeDropDown, "name").webElementToSelect()
				.getOptions();
		for (WebElement webElement : l2) {
			String strSropDownVal = webElement.getText();
			l3.add(strSropDownVal);
		}
		l3.equals(l1);
		objWaitForElement.waitForElements(nextInSelInterfaceType, "xpath");
		assertTrue(this.page.element(nextInSelInterfaceType, "xpath").getOne().isDisplayed());
		assertTrue(this.page.element(cancelInSelInterfaceType, "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is used select interface type.
	* Arguments		: strInterfaceType
	* Date 			: 04/08/2014
	* Author 		: Renushree
	**********************************************************************************/
	public InterfacesInSetUp selInterfaceType(String strInterfaceType)
			throws Exception {
		objWaitForElement.waitForElements(selInterfaceTypeDropDown, "name");
		this.page.element(selInterfaceTypeDropDown, "name")
				.webElementToSelect().selectByVisibleText(strInterfaceType);
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is used select interface type.
	* Date 			: 04/08/2014
	* Author 		: Renushree
	**********************************************************************************/
	public InterfacesInSetUp clickOnNext() throws Exception {
		objWaitForElement.waitForElements(nextInSelInterfaceType, "xpath");
		this.page.element(nextInSelInterfaceType, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is used provide details to create interface
	* Arguments		: strName, strDesc, strContInfo
	* Date 			: 04/08/2014
	* Author 		: Renushree
	**********************************************************************************/
	public InterfacesInSetUp provideDetailsForInterface(String strName,
			String strDesc, String strContInfo) throws Exception {
		objWaitForElement.waitForElements(name, "name");
		this.page.element(name, "name").clearInputValue().sendKeys(strName);
		objWaitForElement.waitForElements(description, "name");
		this.page.element(description, "name").clearInputValue()
				.sendKeys(strDesc);
		objWaitForElement.waitForElements(contInfo, "name");
		this.page.element(contInfo, "name").clearInputValue()
				.sendKeys(strContInfo);
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is used verify create interface screen
	* Date 			: 04/08/2014
	* Author 		: Renushree
	**********************************************************************************/
	public InterfacesInSetUp verifyCreateInterfaceScreen() throws Exception {
		objWaitForElement.waitForElements(name, "name");
		assertTrue(this.page.element(name, "name").getOne().isDisplayed());
		assertTrue(this.page.element(description, "name").getOne().isDisplayed());
		assertTrue(this.page.element(contInfo, "name").getOne().isDisplayed());
		assertTrue(this.page.element(interfaceKey, "name").getOne().isDisplayed());
		assertTrue(this.page.element(webServAction, "name").getOne().isDisplayed());
		assertTrue(this.page.element(resIdenMethod, "name").getOne().isDisplayed());
		assertTrue(this.page.element(activeChkBox, "name").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is used select active check box
	* Date 			: 04/08/2014
	* Author 		: Renushree
	**********************************************************************************/
	public InterfacesInSetUp selActiveChkbox() throws Exception {
		objWaitForElement.waitForElements(activeChkBox, "name");
		this.page.element(activeChkBox, "name").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is used click on save button
	* Date 			: 04/08/2014
	* Author 		: Renushree
	**********************************************************************************/
	public InterfacesInSetUp clickOnSave() throws Exception {
		objWaitForElement.waitForElements(saveInCreateInterfaceScreen, "xpath");
		this.page.element(saveInCreateInterfaceScreen, "xpath").getOne()
				.click();
		objWaitForElement.waitForElements(createNewInterface, "xpath");
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is used get WebServiceAction while creating region interface
	* Date 			: 04/08/2014
	* Author 		: Renushree
	**********************************************************************************/
	public String getWebServiceAction() throws Exception {
		objWaitForElement.waitForElements(webServAction, "name");
		String strWebServAction = this.page.element(webServAction, "name")
				.getOne().getAttribute("value");
		return strWebServAction;
	}
	
	/**********************************************************************************
	* Description 	: This function is used verify created interface in a list.
	* Arguments		: strInterFaceName, strDesc, strInterfaceType, strWebServAction, strStatus
	* Date 			: 04/08/2014
	* Author 		: Renushree
	**********************************************************************************/
	public InterfacesInSetUp verifyCreatedInterfaceInList(
			String strInterFaceName, String strDesc, String strInterfaceType,
			String strWebServAction, String strStatus) throws Exception {
		objWaitForElement.waitForElements(interfaceListTbl + "td[2][text()='"+strInterFaceName+"']", "xpath");
		assertTrue(this.page.element(interfaceListTbl + "td[2][text()='"+strInterFaceName+"']", "xpath").getOne().isDisplayed(), "Created interface not found");
		verCreatedInterfaceStatus(strInterFaceName, strStatus);
		assertTrue(this.page.element(interfaceListTbl + "td[2][text()='"+strInterFaceName+"']/parent::tr/td[4][text()='"+strWebServAction+"']", "xpath").getOne().isDisplayed(), "WebserviceAction is not present");
		assertTrue(this.page.element(interfaceListTbl + "td[2][text()='"+strInterFaceName+"']/parent::tr/td[5][text()='"+strInterfaceType+"']", "xpath").getOne().isDisplayed(), "Interface type is not present");
		assertTrue(this.page.element(interfaceListTbl + "td[2][text()='"+strInterFaceName+"']/parent::tr/td[7][text()='"+strDesc+"']", "xpath").getOne().isDisplayed(), "Description not present");
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is used verify created interface active column value
	* Arguments		: strStatus
	* Date 			: 04/08/2014
	* Author 		: Renushree
	**********************************************************************************/
	public InterfacesInSetUp verCreatedInterfaceStatus(String strInterFaceName, String strStatus)
			throws Exception {
		objWaitForElement.waitForElements(interfaceListTbl + "td[2][text()='"+strInterFaceName+"']/parent::tr/td[3]", "xpath");
		assertEquals(strStatus,
				this.page.element(interfaceListTbl + "td[2][text()='"+strInterFaceName+"']/parent::tr/td[3]", "xpath").getOne()
						.getText());
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is used verify created interface active column value
	* Arguments		: strInterfaceName
	* Date 			: 04/08/2014
	* Author 		: Renushree
	**********************************************************************************/
	public InterfacesInSetUp clickOnEditLink(String strInterfaceName)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table/tbody/tr/td[text()='"
				+ strInterfaceName
				+ "']/parent::tr/td[1]/a[text()='edit']",
		"xpath");
		this.page
				.element(
						"//div[@id='mainContainer']/table/tbody/tr/td[text()='"
								+ strInterfaceName
								+ "']/parent::tr/td[1]/a[text()='edit']",
						"xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	* Description 	: This function is used to verify appropriate selected interface type under web service action 
	* Date 			: 01/06/2015
	* Author 		: Sangappa.k
	**********************************************************************************/
	public InterfacesInSetUp verAppropriateInterfaceTypeUnderWSA(String strWSA) throws Exception {	
	objWaitForElement.waitForElements(webServAction, "name");
	String strIntType="//div[@id='mainContainer']/form/table/tbody/tr[6]/td[2]/input[@value='"+strWSA+"']";
	assertTrue(this.page.element(strIntType, "xpath").getOne().isDisplayed(), "appropriate inter face is not displayed");
	return this;
	}	

	
	/**********************************************************************************
	* Description 	: This function is used to verify default text displayed in 'WebServiceAction' field while creating region interface
	* Date 			: 01-June-2015
	* Author 		: Hanumegowda
	**********************************************************************************/
	public InterfacesInSetUp verDefaultTextInWebServicesActionField(
			String defaulttext) throws Exception {
		objWaitForElement.waitForElements(WebServicesAction, "xpath");
		String strWebServAction = this.page.element(WebServicesAction, "xpath")
				.getOne().getAttribute("value");
		assertEquals(strWebServAction, defaulttext);
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is used verify 'OptionalStatusTypeMappings' fields are displayed while creating region interface
	* Date 			: 01-June-2015
	* Author 		: Hanumegowda
	**********************************************************************************/
	public InterfacesInSetUp verOptionalStatusTypeMappingsFieldIsDisplayed()
			throws Exception {
//		objWaitForElement.waitForElements(OptionalStatusTypeMappings, "xpath");
//		this.page.element(OptionalStatusTypeMappings, "xpath").getOne()
//				.isDisplayed();
		return this;
	}

	/**********************************************************************************
	* Description 	: This function is used verify 'CustomStatusTypeMappings' fields are displayed while creating region interface
	* Date 			: 01-June-2015
	* Author 		: Hanumegowda
	**********************************************************************************/
	public InterfacesInSetUp verCustomStatusTypeMappingsFieldIsDisplayed()
			throws Exception {
//		objWaitForElement.waitForElements(CustomStatusTypeMappings, "xpath");
//		this.page.element(CustomStatusTypeMappings, "xpath").getOne()
//				.isDisplayed();
		return this;
	}

	/**********************************************************************************
	* Description 	: This function is used  delete  created interface
	* Date 			: 01-June-2015
	* Author 		: Sangappa.k
	**********************************************************************************/
	public InterfacesInSetUp clickOnDelete(String strInterfaceName) throws Exception {
		String strDelete="//td[contains(text(),'"+strInterfaceName+"')]/../td//a[contains(text(),'delete')]";
		objWaitForElement.waitForElements(strDelete, "xpath");
		this.page.element(strDelete, "xpath").getOne().click();	
		Thread.sleep(5000);
		Alert popup = this.driver.switchTo().alert();
		popup.accept();
		return this;
	}
	
	
	/**********************************************************************************
	* Description 	: This function is used to search for interface type and to delete all corresponding interface.
	* Date 			: 01-June-2015
	* Author 		: Hanumegowda
	**********************************************************************************/
	public InterfacesInSetUp verInterfaceTypeAndDeleteCorrespondingInterface(
			String interfacetype) throws Exception {
		objWaitForElement.waitForElements("//tbody//tr//td[text()='"
				+ interfacetype + "']", "xpath");
		while (this.page.element(
				"//tbody//tr//td[text()='" + interfacetype + "']", "xpath")
				.isElementPresent()) {
			objWaitForElement.waitForElements("//tbody//tr//td[text()='"
					+ interfacetype + "']/../td/a[text()='delete']", "xpath");
			this.page
					.element(
							"//tbody//tr//td[text()='" + interfacetype
									+ "']/../td/a[text()='delete']", "xpath")
					.getOne().click();
			Thread.sleep(8000);
			Alert alert = driver.switchTo().alert();
			alert.accept();
			Thread.sleep(5000);
		}
		return this;
	}
		
   /**********************************************************************************
	* Description 	: This function is used to search for interface type and to delete only the corresponding active interface.
	* Date 			: 01-June-2015
	* Author 		: Hanumegowda
	**********************************************************************************/
	public InterfacesInSetUp verInterfaceTypeAndDeleteCorrespondingInterface1(
			String interfacetype) throws Exception {
		objWaitForElement.waitForElements(
				"//tbody//tr//td[text()='Active']/..//td[text()='"
						+ interfacetype + "']", "xpath");
		if (this.page.element(
				"//tbody//tr//td[text()='Active']/..//td[text()='"
						+ interfacetype + "']", "xpath").isElementPresent()) {
			objWaitForElement.waitForElements(
					"//tbody//tr//td[text()='Active']/..//td[text()='"
							+ interfacetype + "']/../td/a[text()='delete']",
					"xpath");
			this.page
					.element(
							"//tbody//tr//td[text()='Active']/..//td[text()='"
									+ interfacetype
									+ "']/../td/a[text()='delete']", "xpath")
					.getOne().click();
			Thread.sleep(8000);
			Alert alert = driver.switchTo().alert();
			alert.accept();
			Thread.sleep(5000);
		}
		return this;
	}
	/**********************************************************************************
	* Description 	: This function is used verify created interface in a list.
	* Arguments		: strInterFaceName, strInterfaceType, 
	* Date 			: 04/08/2014
	* Author 		: Sangappa.K
	**********************************************************************************/
	public InterfacesInSetUp verifyCreatedInterfaceTypeInList(
			String strInterFaceName, String strInterfaceType) throws Exception {
		objWaitForElement.waitForElements(interfaceListTbl + "td[text()='"
				+ strInterFaceName + "']", "xpath");

		assertTrue(
				this.page
						.element(
								interfaceListTbl + "td[text()='"
										+ strInterFaceName
										+ "']/parent::tr/td[5][text()='"
										+ strInterfaceType + "']", "xpath")
						.getOne().isDisplayed(),
				"Interface type is not present");

		return this;
	}
	/**********************************************************************************
	* Description 	: This function is used to delete  created interface
	* Date 			: 01-June-2015
	* Author 		: Sangappa.k
	**********************************************************************************/
	public InterfacesInSetUp selectResource(String strResourceeName)
			throws Exception {
		String strResource = "//table[@summary='Select Resources That Are Allowed In This Interface']/tbody/tr/td[text()='"
				+ strResourceeName + "']/preceding-sibling::td/input";
		objWaitForElement.waitForElements(strResource, "xpath");
		assertTrue(this.page.element(strResource, "xpath").isElementPresent());
		if (this.page.element(strResource, "xpath").getOne().isSelected() == false) {
			this.page.element(strResource, "xpath").getOne().click();
		}
		if (this.page.element(strResource, "xpath").getOne().isSelected() == false) {
			this.page.element(strResource, "xpath").getOne()
			.sendKeys(Keys.SPACE);
		}
		assertTrue(this.page.element(strResource, "xpath").getOne()
				.isSelected());
		return this;
	}
	/**********************************************************************************
	* Description 	: This function is used to verify Schema for created interface
	* Date 			: 27-Aug-2015 
	* Author 		: Sangappa.K
	**********************************************************************************/
	public InterfacesInSetUp verAppropriateSchemaForInterface(
			String schema) throws Exception {
		String schemaId="//a[text()='Schema']/parent::th/parent::tr/parent::thead/following-sibling::tbody/tr/td[text()='"+schema+"']";
		objWaitForElement.waitForElements(schemaId, "xpath");
		String strSchema = this.page.element(schemaId, "xpath").getOne().getText();			
		assertEquals(schema, strSchema,"Schema is not dispalyed");
		return this;
	}
	/**********************************************************************************
	* Description 	: This function is used to click on usres link corresponding to Interface
	* Date 			: 27-Aug-2015
	* Author 		: Sangappa.k
	**********************************************************************************/
	public InterfacesInSetUp clickOnUsersLink(String strInterfaceName)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table/tbody/tr/td[2][text()='"
				+ strInterfaceName
				+ "']/parent::tr/td[1]/a[text()='users']",
		"xpath");
		this.page
				.element(
						"//div[@id='mainContainer']/table/tbody/tr/td[2][text()='"
								+ strInterfaceName
								+ "']/parent::tr/td[1]/a[text()='users']",
						"xpath").getOne().click();
		return this;
	}
	/**********************************************************************************
	* Description 	: This function is to verify WebService user name in "Region Interface Users List" page
	* Date 			: 27-Aug-2015 
	* Author 		: Sangappa.K
	**********************************************************************************/
	public InterfacesInSetUp verWebServiceUserNameUnderRegionInterfaceUsersListPage(
			String UserName) throws Exception {
		String User = "//table[@id='tbl_userID']/tbody/tr/td[text()='"
				+ UserName + "']";
		objWaitForElement.waitForElements(User, "xpath");
		assertTrue(this.page.element(User, "xpath").isElementPresent(),
				"Web service user is not displayed in Region Interface Users List page");
		return this;
	}
	/**********************************************************************************
	* Description 	: This function is to verify WebService user name in "Region Interface Users List" page
	* Date 			: 27-Aug-2015 
	* Author 		: Sangappa.K
	**********************************************************************************/
	public InterfacesInSetUp verNormelUsersNotDispUnderRegionInterfaceUsersListPage(
			String UserName) throws Exception {
		String User = "//table[@id='tbl_userID']/tbody/tr/td[text()='"
				+ UserName + "']";
		assertFalse(this.page.element(User, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_TOO_SMALL),
				"Normal user are displayed in Region Interface Users List page");
		return this;
	}
	/**********************************************************************************
	* Description 	: This function is used to click on parameters link corresponding to Interface
	* Date 			: 27-Aug-2015
	* Author 		: Sangappa.k
	**********************************************************************************/
	public InterfacesInSetUp clickOnParameteresLink(String strInterfaceName)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table/tbody/tr/td[2][text()='"
				+ strInterfaceName
				+ "']/parent::tr/td[1]/a[text()='users']",
		"xpath");
		this.page
				.element(
						"//div[@id='mainContainer']/table/tbody/tr/td[2][text()='"
								+ strInterfaceName
								+ "']/parent::tr/td[1]/a[text()='parameters']",
						"xpath").getOne().click();
		return this;
	}
	/**********************************************************************************
	* Description 	: This function is to verify WebService user name in "Region Interface Users List" page
	* Date 			: 27-Aug-2015 
	* Author 		: Sangappa.K
	**********************************************************************************/
	public InterfacesInSetUp verParameterListForRegionInterfacePage(
			String strInterface) throws Exception {
		String parameter = "//div[@id='topSubNav']/h1[text()='Parameter List for Region Interface: "
				+ strInterface + "']";
		objWaitForElement.waitForElements(parameter, "xpath");
		assertTrue(this.page.element(parameter, "xpath").isElementPresent(),
				"Parameter List for Region Interface: page not displayed");
		return this;
	}

	/**********************************************************************************
	* Description 	: This function is used to click on usres link corresponding to Interface
	* Date 			: 27-Aug-2015
	* Author 		: Sangappa.k
	**********************************************************************************/
	public InterfacesInSetUp clickOnCreateParameterBtn() throws Exception {
		objWaitForElement.waitForElements(
				"//input[@value='Create New Parameter']", "xpath");
		this.page.element("//input[@value='Create New Parameter']", "xpath")
				.getOne().click();
		return this;
	}	
	/**********************************************************************************
	* Description 	: This function is to verify "Create Region Interface Parameter" page
	* Date 			: 27-Aug-2015 
	* Author 		: Sangappa.K
	**********************************************************************************/
	public InterfacesInSetUp verCreateRegionInterfaceParameterPage() throws Exception {
		String parameter = "//div[@id='topSubNav']/h1[text()='Create Region Interface Parameter']";
		objWaitForElement.waitForElements(parameter, "xpath");
		assertTrue(this.page.element(parameter, "xpath").isElementPresent(),
				"Create Region Interface Parameter page not displayed");
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to verify "Create Region Interface Parameter" page
	* Date 			: 27-Aug-2015 
	* Author 		: Sangappa.K
	**********************************************************************************/
	public InterfacesInSetUp entereParameterName(String ParaName) throws Exception {
		objWaitForElement.waitForElements(paraName, "xpath");
		this.page.element(paraName, "xpath").clearInputValue().sendKeys(ParaName);
		return this;
	}
	/**********************************************************************************
	* Description 	: This function is to verify "Create Region Interface Parameter" page
	* Date 			: 27-Aug-2015 
	* Author 		: Sangappa.K
	**********************************************************************************/
	public InterfacesInSetUp entereParameterValue(String Paravalue) throws Exception {
		objWaitForElement.waitForElements(paramValue, "xpath");
		this.page.element(paramValue, "xpath").clearInputValue().sendKeys(Paravalue);
		return this;
	}	
	
	/**********************************************************************************
	* Description 	: This function is to click on save
	* Date 			: 27-Aug-2015 
	* Author 		: Sangappa.K
	**********************************************************************************/
	public InterfacesInSetUp clickOnSaveOfParametere() throws Exception {
		objWaitForElement.waitForElements(saveInCreateInterfaceScreen, "xpath");
		this.page.element(saveInCreateInterfaceScreen, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to verify Created Parameters.
	* Date 			: 27-Aug-2015 
	* Author 		: Sangappa.K
	**********************************************************************************/
	public InterfacesInSetUp verCreatedParameterDetailes(
			String Name,String value) throws Exception {
		String parametername = "//table[@summary='Parameters']/tbody/tr/td[text()='"+Name+"']";
		String parameterValue = "//table[@summary='Parameters']/tbody/tr/td[text()='"+value+"']";
		
		objWaitForElement.waitForElements(parametername, "xpath");
		assertTrue(this.page.element(parametername, "xpath").isElementPresent(),
				"Parameter detailes are not displayed");
		assertTrue(this.page.element(parameterValue, "xpath").isElementPresent(),
				"Parameter detailes are not displayed");
		return this;
	}	
	
	/**********************************************************************************
	* Description 	: This function is to click on save
	* Date 			: 27-Aug-2015 
	* Author 		: Sangappa.K
	**********************************************************************************/
	public InterfacesInSetUp creatParameterForInterface(String ParaName,String Paravalue) throws Exception {
		this.clickOnCreateParameterBtn();
		this.entereParameterName(ParaName);
		this.entereParameterValue(Paravalue);
		this.clickOnSaveOfParametere();
		return this;	
	}
	/**********************************************************************************
	* Description 	: This function is to verify Created Parameters.
	* Date 			: 27-Aug-2015 
	* Author 		: Sangappa.K
	**********************************************************************************/
	public InterfacesInSetUp verEditAndDeleteLinksForParameter(
			String paraname) throws Exception {
	String parametername ="//table[@summary='Parameters']/tbody/tr/td[text()='"+paraname+"']/preceding-sibling::td/a[text()='Edit']/following-sibling::a[text()='Delete']";	
	objWaitForElement.waitForElements(parametername, "xpath");
	assertTrue(this.page.element(parametername, "xpath").isElementPresent(),
				"Edit & delete btns not thier");
	return this;
	}	
		
	/**********************************************************************************
	* Description 	: This function is to click on save
	* Date 			: 27-Aug-2015 
	* Author 		: Sangappa.K
	**********************************************************************************/
	public InterfacesInSetUp clickOnSaveOfRegionInterfaceUsersListPge() throws Exception {
		
		 objWaitForElement.waitForElements(saveInCreateInterfaceScreen, "xpath");
		this.page.element(saveInCreateInterfaceScreen, "xpath").getOne().sendKeys(Keys.ENTER);;
		
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to enter Username in 'Search' input field
	 * Date        : 17/06/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public InterfacesInSetUp enterUsernameInSearchInputField(String strUsername)
			throws Exception {
		objWaitForElement.waitForElements(searchInputField, "id");
		this.page.element(searchInputField, "id").clearInputValue()
		.sendKeys(strUsername);
		Thread.sleep(6000);
		this.page.element(search, "id").getOne().click();
		return this;
	}	
	
	/**********************************************************************************
	* Description 	: This function is to verify Created Parameters.
	* Date 			: 27-Aug-2015 
	* Author 		: Sangappa.K
	**********************************************************************************/
	public InterfacesInSetUp clickOnDeleteLinksForParameter(String paraname)
			throws Exception {
		objWaitForElement.waitForElements(
				"//table[@summary='Parameters']/tbody/tr/td[text()='"
						+ paraname + "']", "xpath");
		while (this.page.element(
				"//table[@summary='Parameters']/tbody/tr/td[text()='"
						+ paraname + "']", "xpath").isElementPresent()) {
			objWaitForElement.waitForElements(
					"//table[@summary='Parameters']/tbody/tr/td[text()='"
							+ paraname
							+ "']/preceding-sibling::td/a[text()='Delete']",
					"xpath");
			this.page
					.element(
							"//table[@summary='Parameters']/tbody/tr/td[text()='"
									+ paraname
									+ "']/preceding-sibling::td/a[text()='Delete']",
							"xpath").getOne().click();
			Thread.sleep(8000);
			Alert alert = driver.switchTo().alert();
			alert.accept();
			Thread.sleep(5000);
		}
		return this;
	}
	/**********************************************************************************
	* Description 	: This function is to verify Created Parameters.
	* Date 			: 27-Aug-2015 
	* Author 		: Sangappa.K
	**********************************************************************************/
	public InterfacesInSetUp verParameterNotListed(String paraname)
			throws Exception {
		assertFalse(this.page.element(
				"//table[@summary='Parameters']/tbody/tr/td[text()='"
						+ paraname + "']", "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_TOO_SMALL),
				"Parameter is Listed in the page");
		return this;
	}
	/**********************************************************************************
	* Description 	: This function is used to search for interface type and to delete all corresponding interface.
	* Date 			: 01-June-2015
	* Author 		: Hanumegowda
	**********************************************************************************/
	public InterfacesInSetUp clickOnDeleteLinksForInterface(String interfaceName)
			throws Exception {
		objWaitForElement.waitForElements("//table/tbody/tr/td[text()='"
				+ interfaceName + "']", "xpath");
		while (this.page.element(
				"//table/tbody/tr/td[text()='" + interfaceName
						+ "']/preceding-sibling::td/a[text()='delete']",
				"xpath").isElementPresent()) {
			this.page
					.element(
							"//table/tbody/tr/td[text()='"
									+ interfaceName
									+ "']/preceding-sibling::td/a[text()='delete']",
							"xpath").getOne().click();
			Thread.sleep(8000);
			Alert alert = driver.switchTo().alert();
			alert.accept();
			Thread.sleep(5000);
		}
		return this;
	}
	/**********************************************************************************
	* Description 	: This function is to verify Created Parameters.
	* Date 			: 27-Aug-2015 
	* Author 		: Sangappa.K
	**********************************************************************************/
	public InterfacesInSetUp verInterfaceNotListed(String interfaceName)
			throws Exception {
		assertFalse(
				this.page.element(
						"//table/tbody/tr/td[text()='" + interfaceName + "']",
						"xpath").isElementPresent(
						WaitTimeConstants.WAIT_TIME_TOO_SMALL),
				"Interface is Listed in the page");
		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is to verify Created Parameters.
	* Date 			: 27-Aug-2015 
	* Author 		: Sangappa.K
	**********************************************************************************/
	public InterfacesInSetUp verInterfaceIsListed(String interfaceName)
			throws Exception {
		objWaitForElement.waitForElements("//table/tbody/tr/td[text()='"
				+ interfaceName + "']", "xpath");
		assertTrue(
				this.page.element(
						"//table/tbody/tr/td[text()='" + interfaceName + "']",
						"xpath").isElementPresent(),
				"Interface is not Listed in the page");
		return this;
	}
	/**********************************************************************************
	* Description 	: This function is used to search for interface type and to delete all corresponding interface.
	* Date 			: 01-June-2015
	* Author 		: Hanumegowda
	**********************************************************************************/
	public InterfacesInSetUp clickOnCancelDeleteLinksForInterface(String interfaceName)
			throws Exception {
		objWaitForElement.waitForElements("//table/tbody/tr/td[text()='"
				+ interfaceName + "']", "xpath");
		while (this.page.element(
				"//table/tbody/tr/td[text()='" + interfaceName
						+ "']/preceding-sibling::td/a[text()='delete']",
				"xpath").isElementPresent()) {
			this.page
					.element(
							"//table/tbody/tr/td[text()='"
									+ interfaceName
									+ "']/preceding-sibling::td/a[text()='delete']",
							"xpath").getOne().click();
			Thread.sleep(8000);
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
			Thread.sleep(8000);
		}
		return this;
	}
	/**********************************************************************************
	* Description 	: This function is to verify Created Parameters.
	* Date 			: 27-Aug-2015 
	* Author 		: Sangappa.K
	**********************************************************************************/
	public InterfacesInSetUp verParameterIsListed(String paraname)
			throws Exception {
		objWaitForElement.waitForElements(
				"//table[@summary='Parameters']/tbody/tr/td[text()='"
						+ paraname + "']", "xpath");
		assertTrue(
				this.page.element(
						"//table[@summary='Parameters']/tbody/tr/td[text()='"
								+ paraname + "']", "xpath").isElementPresent(),
				"Parameter is NOT Listed in the page");
		return this;
	}
	/**********************************************************************************
	* Description 	: This function is to verify Created Parameters.
	* Date 			: 27-Aug-2015 
	* Author 		: Sangappa.K
	**********************************************************************************/
	public InterfacesInSetUp verifyEditAndDeleteLinksForParameter(
			String paraname) throws Exception {
		objWaitForElement.waitForElements(
				"//table[@summary='Parameters']/tbody/tr/td[text()='"
						+ paraname
						+ "']/preceding-sibling::td/a[text()='Delete']",
				"xpath");
		assertTrue(
				this.page
						.element(
								"//table[@summary='Parameters']/tbody/tr/td[text()='"
										+ paraname
										+ "']/preceding-sibling::td/a[text()='Delete']",
								"xpath").isElementPresent(),
				"Edi and Delete links NOT Listed in the page");
		assertTrue(
				this.page.element(
						"//table[@summary='Parameters']/tbody/tr/td[text()='"
								+ paraname
								+ "']/preceding-sibling::td/a[text()='Edit']",
						"xpath").isElementPresent(),
				"Edi and Delete links NOT Listed in the page");

		return this;
	}
	
	/**********************************************************************************
	* Description 	: This function is used verify created interface active column value
	* Arguments		: strInterfaceName
	* Date 			: 04/08/2014
	* Author 		: Anitha
	**********************************************************************************/
	public InterfacesInSetUp clickOnEditLinkOfParameter(String paraname)
			throws Exception {
		objWaitForElement.waitForElements("//table[@summary='Parameters']/tbody/tr/td[text()='"
				+ paraname
				+ "']/preceding-sibling::td/a[text()='Edit']",
		"xpath");
		this.page
				.element("//table[@summary='Parameters']/tbody/tr/td[text()='"
						+ paraname
						+ "']/preceding-sibling::td/a[text()='Edit']",
				"xpath").getOne().click();
		return this;
	}
	/**********************************************************************************
	* Description 	: This function is to verify Created Parameters.
	* Date 			: 27-Aug-2015 
	* Author 		: Sangappa.K
	**********************************************************************************/
	public InterfacesInSetUp verifyLinkForInterFace(String strInterFaceName, String strLink)
			throws Exception {
		String ActionHead = "//div[@id='mainContainer']/table/thead/tr/th[text()='Action']";
		objWaitForElement.waitForElements(ActionHead, "xpath");
		assertTrue(this.page.element(
				"//table/tbody/tr/td[text()='" + strInterFaceName
						+ "']/parent::tr/td/a[text()='"+strLink+"']", "xpath")
				.isElementPresent(), ""+strLink+" link not displayed");
		return this;
	}

	/**********************************************************************************
	* Description 	: This function is to click on resources link corresponding to an interface
	* Arguments		: strInterfaceName
	* Date 			: 14/07/2016
	* Author 		: Pallavi
	**********************************************************************************/
	public InterfacesInSetUp clickOnResourceLinkCorrespondingToInterface(String strInterfaceName)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table/tbody/tr/td[text()='"
				+ strInterfaceName
				+ "']/parent::tr/td[1]/a[text()='resources']",
		"xpath");
		this.page
				.element("//div[@id='mainContainer']/table/tbody/tr/td[text()='"
						+ strInterfaceName
						+ "']/parent::tr/td[1]/a[text()='resources']",
				"xpath").getOne().click();
		objWaitForElement.waitForElements(selectResourceForInterfacePage, "xpath");
		return this;
	}
}