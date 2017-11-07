package lib.page;

import static org.testng.Assert.*;
import static org.testng.AssertJUnit.assertTrue;

import java.text.NumberFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mysql.jdbc.AssertionFailedException;

import qaframework.lib.WaitTimeConstants;
import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;

public class Resource extends PageObject {

	WebDriver driver;
	WaitForElement objWaitForElement ;
    //Locators
	private String setUpLink = "//a[@class='mainLink'][text()='Setup']",
				   setUpLink1 = "//a[@class='mainLink selected'][text()='Setup']",
				   resource = "//div[@id='mainContainer']/table/tbody/tr/td/a[text()='Resources']",
				   createNewResource = "//input[@value='Create New Resource'][@type='button']",
				   resourceName = "resourceName",
				   resourceFirstName = "firstName",
				   resourceLastName = "lastName",
				   resourceDescription = "abbreviation",
				   reSSaveButton = "input[value='Save'][type='submit']",
				   resourceTypeList = "resourceTypeID",
				   standardResourceTypeList = "standardResourceTypeID",
				   viewResourceChkBox = "input[value='viewRight']",
				   streetAddress = "streetAddress",
				   city = "city",
				   state = "stateAbbrev",
				   zipCode = "zipCode",
				   county = "county",
				   lookUpAddress = "//div[@id='mainContainer']//input[@class='emsButtonText'][@value='Lookup Address']",
				   map = "map",
				   shareWithOtherRegion = "input[name='shareWithOtherRegions']",
				   latitude = "#latitude",
                   longitude="#longitude",
                   createNewSubResource = "//input[@value='Create New Sub-Resource'][@type='button']",
        		   headerName = "div#topSubNav > h1",
        		   resourcenameUnderParent = "//div[@id='mainContainer']/table/tbody/tr/td[3]",
        		   cancelButton	= "input[value='Cancel']",
        		   associatedWithAll = "//table[@id='tbl_association']/thead/tr/th[contains(text(),'Associated')]/input[@name='SELECT_ALL']",
        		   updateStatusAll = "//table[@id='tbl_association']/thead/tr/th[contains(text(),'Update')]/input[@name='SELECT_ALL']",
        		   runReportsAll = "//table[@id='tbl_association']/thead/tr/th[contains(text(),'Run')]/input[@name='SELECT_ALL']",
        		   viewResourceAll = "//table[@id='tbl_association']/thead/tr/th[contains(text(),'View')]/input[@name='SELECT_ALL']",
        		   anyResourceType="//select[@name='statusTypeID_filterResourceTypeID']/option[text()='(Any Resource Type)']",
        		   anySection="//select[@name='statusTypeID_filterSection']/option[text()='(Any Section)']",
        		   anyStandardStatusType="//select[@name='statusTypeID_filterStandardStatusType']/option[text()='(Any Standard Status Type)']",
        		   statusTypeField="//input[@name='statusTypeID_filterText']",
        		   searchButton = "input[value='Search'][type='button']",
        		   showAllButton = "input[value='Show All'][type='button']",
	               searchTextName = "statusTypeID_filterText",
	               reportsHavBedDataCheckBox = "input[name='reportHavbedInd'][value='Y']",
	               includeInactiveResources = "input[name='inactive_r'][value='Y']";
            		  
	public Resource(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement =  new WaitForElement(this.driver);
	}
	
	  /**********************************************************************************
	   * Description : This function is to navigate to Resource list screen
	   * Date        : 12/06/2014
	   * Author      : Anitha
	   **********************************************************************************/
	public Resource navigateToResourceListPage() throws Exception {
		objWaitForElement.waitForElements(setUpLink1, "xpath");
		this.page.element(setUpLink1, "xpath").getOne().click();
		objWaitForElement.waitForElements(resource, "xpath");
		this.page.element(resource, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to navigate to Resource list screen
	   * Date        : 12/06/2014
	   * Author      : Anitha
	   **********************************************************************************/
	public Resource navigateToResourceListPageNew() throws Exception {
		objWaitForElement.waitForElements(setUpLink, "xpath");
		this.page.element(setUpLink, "xpath").getOne().click();
		objWaitForElement.waitForElements(resource, "xpath");
		this.page.element(resource, "xpath").getOne().click();
		return this;
	}
	  /**********************************************************************************
	   * Description : This function is to Click CreateNewResource button
	   * Date        : 12/06/2014
	   * Author      : Anitha
	   **********************************************************************************/
	public Resource clickOnCreateNewResourceButton() throws Exception {
		objWaitForElement.waitForElements(createNewResource, "xpath");
		this.page.element(createNewResource, "xpath").getOne().click();
		return this;
	}
	
	  /**********************************************************************************
	   * Description : This function is to enter resourceType Name
	   * Date        : 11/06/2014
	   * Author      : Anitha
	   **********************************************************************************/
	public Resource enterResourceName(String strResourceName)
			throws Exception {
		objWaitForElement.waitForElements(resourceName, "name");
		this.page.element(resourceName, "name").clearInputValue()
				.sendKeys(strResourceName);
		return this;
	}

	  /**********************************************************************************
	   * Description : This function is to enter resource Abbrivation
	   * Date        : 11/06/2014
	   * Author      : Anitha
	   **********************************************************************************/
	public Resource enterResourceAbbrivation(
			String strResourceAbbrivation) throws Exception {
		objWaitForElement.waitForElements(resourceDescription, "name");
		this.page.element(resourceDescription, "name").clearInputValue()
				.sendKeys(strResourceAbbrivation);
		return this;
	}
	
	  /**********************************************************************************
	   * Description : This function is to enter resource first Name
	   * Date        : 11/06/2014
	   * Author      : Anitha
	   **********************************************************************************/
	public Resource enterResourceFirstName(String strResourceFirstName)
			throws Exception {
		objWaitForElement.waitForElements(resourceFirstName, "name");
		this.page.element(resourceFirstName, "name").clearInputValue()
				.sendKeys(strResourceFirstName);
		return this;
	}
	
	  /**********************************************************************************
	   * Description : This function is to enter resource Last Name
	   * Date        : 11/06/2014
	   * Author      : Anitha
	   **********************************************************************************/
	public Resource enterResourceLastName(
			String strResourceLastName) throws Exception {
		objWaitForElement.waitForElements(resourceLastName, "name");
		this.page.element(resourceLastName, "name").clearInputValue().sendKeys(strResourceLastName);
		assertTrue(this.page.element(resourceLastName, "name").getOne().getAttribute("value").equals(strResourceLastName));
		if(this.page.element("//td[text()='View Rights:']/following-sibling::td/input[@name='viewRightForAllUsersInd']", "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_TOO_SMALL)){
			if(this.page.element("//td[text()='View Rights:']/following-sibling::td/input[@name='viewRightForAllUsersInd']", "xpath").getOne().isSelected()){
				this.page.element("//td[text()='View Rights:']/following-sibling::td/input[@name='viewRightForAllUsersInd']", "xpath").getOne().sendKeys(Keys.SPACE);
			}
		}
		return this;
	}
	  /**********************************************************************************
	   * Description : This function is to select ResourceTypename
	   * Date        : 11/06/2014
	   * Author      : Anitha
	   **********************************************************************************/
	public Resource selectResourceTypename(String strResourceTypeName)
			throws Exception {
		objWaitForElement.waitForElements(resourceTypeList, "name");
		this.page.element(resourceTypeList, "name").webElementToSelect()
				.selectByVisibleText(strResourceTypeName);
		return this;
	}
	
	 /**********************************************************************************
	   * Description : This function is to select StandardResourceTypename
	   * Date        : 11/06/2014
	   * Author      : Anitha
	   **********************************************************************************/
	public Resource selectStandardResourceTypename(
			String strStandardResourceTypename) throws Exception {
		objWaitForElement.waitForElements(standardResourceTypeList, "name");
		this.page.element(standardResourceTypeList, "name")
				.webElementToSelect()
				.selectByVisibleText(strStandardResourceTypename);
		return this;
	}
	  /**********************************************************************************
	   * Description : This function is to click save resource button
	   * Date        : 11/06/2014
	   * Author      : Anitha
	   **********************************************************************************/
	public Resource clickOnSaveButton() throws Exception {
		objWaitForElement.waitForElements(reSSaveButton, "css");
		this.page.element(reSSaveButton, "css").clickUsingJSE();
		Thread.sleep(5000);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to create status type
	  * Date        : 11/06/2014
	  * Author      : Anitha
	  **********************************************************************************/
	public String getResourceValue(String strResourceName) throws Exception {
		/*this.navigateToResourceListPage();*/
		objWaitForElement.waitForElements("//tr/td[5][text()='"+
	strResourceName + "']/parent::"
     + "tr/td[1]/a[1]", "xpath");
		String strStatValue = this.page.dynamicElement("ResourceName", "//tr/td[5][text()='"+
				strResourceName + "']/parent::"
		         + "tr/td[1]/a[1]", "xpath").getOne().getAttribute("href");

		String strResValueArr[] = strStatValue.split("resourceID=");
			 strStatValue = strResValueArr[1];
			   
		return strStatValue;
	}
	
	/**********************************************************************************
	   * Description : This function is to Create Resource
	   * Date        : 11/06/2014
	   * Author      : Anitha
	   **********************************************************************************/

	public Resource createResource(String strResourceName,
			String strResourceAbbrivation, String strResourceTypeName,
			String strStandardResourceTypename, String strResourceFirstName,
			String strResourceLastName) throws Exception {
		this.clickOnCreateNewResourceButton();
		this.enterResourceName(strResourceName);
		this.enterResourceAbbrivation(strResourceAbbrivation);
		this.selectResourceTypename(strResourceTypeName);
		this.selectStandardResourceTypename(strStandardResourceTypename);
		this.enterResourceFirstName(strResourceFirstName);
		this.enterResourceLastName(strResourceLastName);
		this.clickOnSaveButton();
		this.selectAllViewResourceOption();
		this.clickOnSaveButton();
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to click Resource
	   * Date        : 11/06/2014
	   * Author      : Anitha
	   **********************************************************************************/
	public Resource clickResource(String[] strResourceValues)
			throws Exception {
		for (int i = 0; i < strResourceValues.length; i++) {
			objWaitForElement.waitForElements("//input[@value='" + strResourceValues[i]
					+ "'][@name='resourceID']", "xpath");

			Thread.sleep(2000);
			WebElement element = driver.findElement(By.xpath("//input[@value='" + strResourceValues[i]
							+ "'][@name='resourceID']"));

			this.page
			.dynamicElement(
					"strResourceValues",
					"//input[@value='" + strResourceValues[i]
							+ "'][@name='resourceID']", "xpath").scrollDownTillElement(element);
			Thread.sleep(2000);
				this.page
				.dynamicElement(
						"strResourceValues",
						"//input[@value='" + strResourceValues[i]
								+ "'][@name='resourceID']", "xpath").getOne().click();
				
				if(this.page
						.dynamicElement(
								"strResourceValues",
								"//input[@value='" + strResourceValues[i]
										+ "'][@name='resourceID']", "xpath").getOne().isSelected()==false){
					this.page
					.dynamicElement(
							"strResourceValues",
							"//input[@value='" + strResourceValues[i]
									+ "'][@name='resourceID']", "xpath").getOne().click();
				}		
		}
		return this;
	}

  /*****************************************************************************
   * Description : This function is to deselect Resource
   * Date        : 11/06/2014
   * Author      : Anitha
   *****************************************************************************/
	public Resource deselectResource(String[] strResourceValues)
			throws Exception {
		objWaitForElement.waitForElements("//input[@value='" + strResourceValues[0]
				+ "'][@name='resourceID']", "xpath");
		for (int i = 0; i < strResourceValues.length; i++) {
			if (this.page
					.dynamicElement(
							"strResourceValues",
							"//input[@value='" + strResourceValues[i]
									+ "'][@name='resourceID']", "xpath")
					.getOne().isSelected() == true) {
				this.page
						.dynamicElement(
								"strResourceValues",
								"//input[@value='" + strResourceValues[i]
										+ "'][@name='resourceID']", "xpath")
						.getOne().click();
			}
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click view resource check box.
	 * Date        : 06/08/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public Resource clickOnViewResChkBox() throws Exception {
		objWaitForElement.waitForElements(viewResourceChkBox, "css");
		this.page.element(viewResourceChkBox, "css").getOne().sendKeys(Keys.SPACE);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify resource in list.
	  * Date        : 06/08/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public Resource verResourceInList(String strResource) throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table[2]/tbody/tr/td[5][text()='"
				+ strResource + "']", "xpath");
		assertTrue(this.page.element(
				"//div[@id='mainContainer']/table[2]/tbody/tr/td[5][text()='"
						+ strResource + "']", "xpath").isElementPresent(), "Resource is not present");
		return this;
	}
	
	  /**********************************************************************************
	   * Description : This function is to enter resource StreetAddress
	   * Date        : 11/08/2014
	   * Author      : Sowmya
	   **********************************************************************************/
	public Resource enterStreetAddress(String strStreetAddress)
			throws Exception {
		objWaitForElement.waitForElements(streetAddress, "id");
		this.page.element(streetAddress, "id").clearInputValue()
				.sendKeys(strStreetAddress);
		return this;
	}
	
	  /**********************************************************************************
	   * Description : This function is to enter resource city
	   * Date        : 11/08/2014
	   * Author      : Sowmya
	   **********************************************************************************/
	public Resource enterCity(String strCityName) throws Exception {
		objWaitForElement.waitForElements(city, "id");
		this.page.element(city, "id").clearInputValue().sendKeys(strCityName);
		return this;
	}
	
	  /**********************************************************************************
	   * Description : This function is to select state
	   * Date        : 11/08/2014
	   * Author      : Sowmya
	   **********************************************************************************/
	public Resource selectState(String strStateName) throws Exception {
		objWaitForElement.waitForElements(state, "id");
		this.page.element(state, "id").webElementToSelect()
				.selectByVisibleText(strStateName);
		return this;
	}
	
	  /**********************************************************************************
	   * Description : This function is to select country
	   * Date        : 11/08/2014
	   * Author      : Sowmya
	   **********************************************************************************/
	public Resource selectCounty(String strCountry) throws Exception {
		objWaitForElement.waitForElements(county, "id");
		this.page.element(county, "id").webElementToSelect()
				.selectByVisibleText(strCountry);
		return this;
	}
	
	  /**********************************************************************************
	   * Description : This function is to enter zipCode
	   * Date        : 11/08/2014
	   * Author      : Sowmya
	   **********************************************************************************/
	public Resource enterzipCode(String strZipCode) throws Exception {
		objWaitForElement.waitForElements(zipCode, "id");
		this.page.element(zipCode, "id").clearInputValue()
				.sendKeys(strZipCode);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on lookup address button
	 * Date        : 11/08/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public Resource clickOnLookupAddressBtn() throws Exception {
		objWaitForElement.waitForElements(lookUpAddress, "xpath");
		this.page.element(lookUpAddress, "xpath").getOne().click();
		this.page.element(lookUpAddress, "xpath").getOne().sendKeys(Keys.ENTER);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Map' is present after clicking on 'Lookup Address' button
	  * Date        : 11/08/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public Resource verMap() throws Exception {
		objWaitForElement.waitForElements(map, "id");
		assertTrue(this.page.element(map, "id").isElementPresent(),
				"map is not present");
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to Create Resource
	   * Date        : 11/06/2014
	   * Author      : Sowmya
	   **********************************************************************************/
	public Resource createResourceWithAddress(String strResourceName,
			String strResourceAbbrivation, String strResourceTypeName,
			String strStandardResourceTypename, String strResourceFirstName,
			String strResourceLastName, String strStreetAddress,
			String strCityName, String strStateName, String strCounty,
			String strZipCode) throws Exception {
		this.clickOnCreateNewResourceButton();
		this.enterResourceName(strResourceName);
		this.enterResourceAbbrivation(strResourceAbbrivation);
		this.selectResourceTypename(strResourceTypeName);
		this.selectStandardResourceTypename(strStandardResourceTypename);
		this.enterResourceFirstName(strResourceFirstName);
		this.enterResourceLastName(strResourceLastName);
		this.enterStreetAddress(strStreetAddress);
		this.selectState(strStateName);
		this.enterCity(strCityName);
		this.enterzipCode(strZipCode);
		this.selectCounty(strCounty);
		this.clickOnLookupAddressBtn();this.clickOnLookupAddressBtn();
		this.verMap();
		this.clickOnSaveButton();
		this.clickOnViewResChkBox();
		this.clickOnSaveButton();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on status types link in resource page.
	  * Date        : 11/08/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public Resource clickOnStatusTypeLinkInResourcePage(String strResource)
			throws Exception {
		objWaitForElement.waitForElements(
				"//div[@id='mainContainer']/table[2]/tbody/tr/td[5][text()='"
						+ strResource
						+ "']/parent::tr/td[1]/a[text()='Status Types']",
				"xpath");
		this.page.element(
				"//div[@id='mainContainer']/table[2]/tbody/tr/td[5][text()='"
						+ strResource
						+ "']/parent::tr/td[1]/a[text()='Status Types']",
				"xpath").mouseOver();
		this.page
				.element(
						"//div[@id='mainContainer']/table[2]/tbody/tr/td[5][text()='"
								+ strResource
								+ "']/parent::tr/td[1]/a[text()='Status Types']",
						"xpath").getOne().sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to select status type
	  * Date        : 11/08/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public Resource selectStatusType(String[] strStatusTypeValues)
			throws Exception {
		objWaitForElement.waitForElements("//input[@value='"
				+ strStatusTypeValues[0] + "'][@name='statusTypeID']", "xpath");
		for (int i = 0; i < strStatusTypeValues.length; i++) {
			if (this.page
					.element(
							"//input[@value='" + strStatusTypeValues[i]
									+ "'][@name='statusTypeID']", "xpath")
					.getOne().isSelected() == false) {
				this.page.dynamicElement(
						"StatusTypeValues",
						"//input[@value='" + strStatusTypeValues[i]
								+ "'][@name='statusTypeID']", "xpath")
						.mouseOver();
				this.page
						.dynamicElement(
								"StatusTypeValues",
								"//input[@value='" + strStatusTypeValues[i]
										+ "'][@name='statusTypeID']", "xpath")
						.getOne().sendKeys(Keys.SPACE);
			}
		}
		return this;

	}

	/**********************************************************************************
	  * Description : This function is to click on edit link in resource page.
	  * Arguments	: strResource
	  * Date        : 09/09/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public Resource clickOnEditLinkInResourcePage(String strResource)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table[2]/tbody/tr/td[5][text()='"+ strResource+ "']/parent::tr/td[1]/a[text()='Edit']",
				"xpath");
		this.page.element(
				"//div[@id='mainContainer']/table[2]/tbody/tr/td[5][text()='"+ strResource+ "']/parent::tr/td[1]/a[text()='Edit']",
				"xpath").mouseOver();
		this.page
				.element("//div[@id='mainContainer']/table[2]/tbody/tr/td[5][text()='"
								+ strResource+ "']/parent::tr/td[1]/a[text()='Edit']",
						"xpath").getOne().sendKeys(Keys.ENTER);
		Thread.sleep(10000);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on share with other region check box
	  * Date        : 09/09/2014
	  * Author      : Renushree
	 **********************************************************************************/
	public Resource clickOnshareWithOtherReg() throws Exception {
		objWaitForElement.waitForElements(shareWithOtherRegion, "css");
		this.page.element(shareWithOtherRegion, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to get Latitude value
	 * Date        : 11/09/2014 
	 * Author      : Sinchana
	 **********************************************************************************/
	public String getLatitude() throws Exception {
		objWaitForElement.waitForElements(latitude, "css");
		String strlatitude = this.page.element(latitude, "css").getOne().getAttribute("value");
		String[] str = strlatitude.split("\\.");
		return str[0];
	}
	
	/**********************************************************************************
	 * Description : This function is to get Longitude value
	 * Date        : 11/09/2014 
	 * Author      : Sinchana
	 **********************************************************************************/
	public String getLongitude() throws Exception {
		objWaitForElement.waitForElements(longitude, "css");
		String strLongitude = this.page.element(longitude, "css").getOne().getAttribute("value");
		String[] str = strLongitude.split("\\.");
		return str[0];
	}
	
	
	/**********************************************************************************
	   * Description : This function is to Create Sub Resource
	   * Date        : 11/07/2014
	   * Author      : Anil
	   **********************************************************************************/

	public Resource createSubResource(String strSubResourceName, String strResourceName,
			String strResourceAbbrivation, String strResourceTypeName,
			String strStandardResourceTypename, String strResourceFirstName,
			String strResourceLastName) throws Exception {
		
		this.clickOnSubResourcesLink(strResourceName);
		this.clickOnCreateNewSubResourceButton();
		this.enterResourceName(strSubResourceName);
		this.enterResourceAbbrivation(strResourceAbbrivation);
		this.selectResourceTypename(strResourceTypeName);
		this.selectStandardResourceTypename(strStandardResourceTypename);
		this.enterResourceFirstName(strResourceFirstName);
		this.enterResourceLastName(strResourceLastName);
		this.clickOnSaveButton();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to get sub resource value
	  * Date        : 11/09/2014
	  * Author      : Anil
	  **********************************************************************************/
	public String getSubResourceValue(String strResourceName) throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']"
				+ "/table[2]/tbody/tr/td[3][text()='"+
	strResourceName + "']/parent::"
     + "tr/td[1]/a", "xpath");
		String strStatValue = this.page.dynamicElement("ResourceName", "//div[@id='mainContainer']"
							+ "/table[2]/tbody/tr/td[3][text()='"+
				strResourceName + "']/parent::"
		         + "tr/td[1]/a", "xpath").getOne().getAttribute("href");

		String strResValueArr[] = strStatValue.split("resourceID=");
			 strStatValue = strResValueArr[1];
			   
		return strStatValue;
	}
	
	  /**********************************************************************************
	   * Description : This function is to Click on sub resource link
	   * Date        : 12/09/2014
	   * Author      : Anil
	   **********************************************************************************/
	public Resource clickOnSubResourcesLink(String strResourceName) throws Exception {
		WebElement element = driver.findElement(By.xpath("//table/tbody/tr/td[5][text()='"+strResourceName+"']/preceding-sibling::td[4]/a[contains(text(),'Sub-Resources')]"));
	this.page
	.element("//table/tbody/tr/td[5][text()='"+strResourceName+"']/preceding-sibling::td[4]/a[contains(text(),'Sub-Resources')]", "xpath").scrollDownTillElement(element);
	Actions action = new Actions(driver);
	objWaitForElement.waitForElements("//table/tbody/tr/td[5][text()='"+strResourceName+"']/preceding-sibling::td[4]/a[contains(text(),'Sub-Resources')]", "xpath");
	action.moveToElement(this.page.element("//table/tbody/tr/td[5][text()='"+strResourceName+"']/preceding-sibling::td[4]/a[contains(text(),'Sub-Resources')]", "xpath").getOne()).perform();
		this.page.dynamicElement(strResourceName, "//table/tbody/tr/td[5][text()='"+strResourceName+"']/preceding-sibling::td[4]/a[contains(text(),'Sub-Resources')]", "xpath").getOne().click();
		return this;
	}
	
	  /**********************************************************************************
	   * Description : This function is to Click on CreateNewSubResource button
	   * Date        : 12/06/2014
	   * Author      : Anitha
	   **********************************************************************************/
	public Resource clickOnCreateNewSubResourceButton() throws Exception {
		objWaitForElement.waitForElements(createNewSubResource, "xpath");
		this.page.element(createNewSubResource, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to fetch standard Resource value
	  * Date   : 15/09/2014
	  * Author  : Sinchana
	  **********************************************************************************/
	public String getStandardResourceValue(String strStandardResourceTypeName) throws Exception {
		objWaitForElement.waitForElements( "//div[@id='mainContainer']//table/tbody/tr/td/select[@name='standardResourceTypeID']/option[text()='"+
				strStandardResourceTypeName + "']", "xpath");
		String strStdResourceValue = this.page.dynamicElement("StandardResourceTypeName", "//div[@id='mainContainer']//table/tbody/tr/td/select[@name='standardResourceTypeID']/option[text()='"+
				strStandardResourceTypeName + "']", "xpath").getOne().getAttribute("value");

		return strStdResourceValue;
	}
	
	/**********************************************************************************
	   * Description : This function is to Create Sub Resource
	   * Date        : 16/07/2014
	   * Author      : Anil
	   **********************************************************************************/

	public Resource createSubResourceForResource(String strSubResourceName,
			String strResourceAbbrivation, String strResourceTypeName,
			String strStandardResourceTypename, String strResourceFirstName,
			String strResourceLastName) throws Exception {
		this.clickOnCreateNewSubResourceButton();
		this.enterResourceName(strSubResourceName);
		this.enterResourceAbbrivation(strResourceAbbrivation);
		this.selectResourceTypename(strResourceTypeName);
		this.selectStandardResourceTypename(strStandardResourceTypename);
		this.enterResourceFirstName(strResourceFirstName);
		this.enterResourceLastName(strResourceLastName);
		this.clickOnSaveButton();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Create AdHoc Event' Button is not displayed 
	 * Date : 16/09/2014 
	 * Author : Sinchana
	 **********************************************************************************/
	public Resource verifySubResourceIsNotDisplayed(String strSubResource)
			throws Exception {
		assertFalse(this.page.dynamicElement(
				"SubRsourceTypeName",
				"//table/tbody/tr/td[text()='" + strSubResource
				+ "']","xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify IPN Coloumn Is Present In ResourcesPage
	 * Date        : 10/06/2014
	 * Author      : Anitha
	 **********************************************************************************/
	public Resource verIPNColoumnIsPresentInResourcesPage() throws Exception {
		objWaitForElement.waitForElements("//table[@class='displayTable striped border sortable']/thead/tr/th/a/span[text()='IPN']",
				"xpath");
		assertTrue(this.page
				.element(
						"//table[@class='displayTable striped border sortable']/thead/tr/th/a/span[text()='IPN']",
						"xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Edit' link in Resource list page
	 * Date        : 22/09/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public Resource verifyEditLink(String strResourceName)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table/tbody/tr/td[5][text()='"
				+ strResourceName
				+ "']/parent::tr/td[1]/a[1][text()='Edit']",
		"xpath");
		assertEquals(
				"Edit",
				this.page
						.element(
								"//div[@id='mainContainer']/table/tbody/tr/td[5][text()='"
										+ strResourceName
										+ "']/parent::tr/td[1]/a[1][text()='Edit']",
								"xpath").getOne().getText());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Status type' link in Resource list page
	 * Date        : 22/09/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public Resource verifyStatusTypeLink(String strResourceName)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table/tbody/tr/td[5][text()='"
				+ strResourceName
				+ "']/parent::tr/td[1]/a[2][text()='Status Types']",
		"xpath");
		assertEquals(
				"Status Types",
				this.page
						.element(
								"//div[@id='mainContainer']/table/tbody/tr/td[5][text()='"
										+ strResourceName
										+ "']/parent::tr/td[1]/a[2][text()='Status Types']",
								"xpath").getOne().getText());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Users' link in Resource list page
	 * Date        : 22/09/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public Resource verifyUsersLink(String strResourceName)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table/tbody/tr/td[5][text()='"
				+ strResourceName
				+ "']/parent::tr/td[1]/a[3][text()='Users']",
		"xpath");
		assertEquals(
				"Users",
				this.page
						.element(
								"//div[@id='mainContainer']/table/tbody/tr/td[5][text()='"
										+ strResourceName
										+ "']/parent::tr/td[1]/a[3][text()='Users']",
								"xpath").getOne().getText());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'SubResources' link in Resource list page
	 * Date        : 22/09/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public Resource verifySubResourcesLink(String strResourceName)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table/tbody/tr/td[5][text()='"
				+ strResourceName
				+ "']/parent::tr/td[1]/a[4][text()='Sub-Resources']",
		"xpath");
		assertEquals(
				"Sub-Resources",
				this.page
						.element(
								"//div[@id='mainContainer']/table/tbody/tr/td[5][text()='"
										+ strResourceName
										+ "']/parent::tr/td[1]/a[4][text()='Sub-Resources']",
								"xpath").getOne().getText());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Demote' link in Resource list page
	 * Date        : 22/09/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public Resource verifyDemoteLink(String strResourceName)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table/tbody/tr/td[5][text()='"
				+ strResourceName
				+ "']/parent::tr/td[1]/a[5][text()='Demote']",
		"xpath");
		assertEquals(
				"Demote",
				this.page
						.element(
								"//div[@id='mainContainer']/table/tbody/tr/td[5][text()='"
										+ strResourceName
										+ "']/parent::tr/td[1]/a[5][text()='Demote']",
								"xpath").getOne().getText());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Sub-Resource list page is displayed
	  * Date        : 22/09/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public Resource verSubResourceListPageIsDisplayed(String strResourceName)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='topSubNav']/h1[text()='Sub-Resource List for "+strResourceName+"']", "xpath");
		assertTrue(this.page.element("//div[@id='topSubNav']/h1[text()='Sub-Resource List for "+strResourceName+"']", "xpath").getOne().isDisplayed());
//		assertEquals("Sub-Resource List for " + strResourceName, this.page
//				.element(headerName, "css").getOne().getText(),
//				"Sub-Resource List page is not displayed.");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify sub resource  in Resource list page
	 * Date        : 22/09/2014
	 * Author      : Sowmya
	**********************************************************************************/
	public Resource verSubResourceInResourceListPage(String strSubResourceName)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table/tbody/tr/td[3][text()='"
				+ strSubResourceName + "']", "xpath");
		assertTrue(this.page.element(
				"//div[@id='mainContainer']/table/tbody/tr/td[3][text()='"
						+ strSubResourceName + "']", "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify resource is not in list.
	  * Date        : 24/09/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public Resource verResourceNotInList(String strResource) throws Exception {
		assertFalse(this.page.element(
				"//div[@id='mainContainer']/table[2]/tbody/tr/td[5][text()='"
						+ strResource + "']", "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE), "Resource is not present");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Sub-Resources(1)' link in Resource list page
	 * Date        : 22/09/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public Resource verSubResources1LinkInResourceList(String strResourceName)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table/tbody/tr/td[5][text()='"
				+ strResourceName
				+ "']/parent::tr/td[1]/a[text()='Sub-Resources (1)']",
		"xpath");
		assertEquals(
				"Sub-Resources (1)",
				this.page
						.element(
								"//div[@id='mainContainer']/table/tbody/tr/td[5][text()='"
										+ strResourceName
										+ "']/parent::tr/td[1]/a[text()='Sub-Resources (1)']",
								"xpath").getOne().getText());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify 'Sub-Resources(1)' link in Resource list page
	 * Date        : 22/09/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public Resource clickOnSubResources1LinkInResourceList(String strResourceName)
			throws Exception {

		WebElement element = driver.findElement(By.xpath("//div[@id='mainContainer']/table/tbody/tr/td[5][text()='"
				+ strResourceName
				+ "']/parent::tr/td[1]/a[text()='Sub-Resources (1)']"));
		this.page
		.element(
				"//div[@id='mainContainer']/table/tbody/tr/td[5][text()='"
						+ strResourceName
						+ "']/parent::tr/td[1]/a[text()='Sub-Resources (1)']",
				"xpath").scrollDownTillElement(element);
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table/tbody/tr/td[5][text()='"
				+ strResourceName
				+ "']/parent::tr/td[1]/a[text()='Sub-Resources (1)']",
		"xpath");
		WebDriverWait wait = new WebDriverWait(this.driver, WaitTimeConstants.WAIT_TIME_SMALL);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='mainContainer']/table/tbody/tr/td[5][text()='"
				+ strResourceName
				+ "']/parent::tr/td[1]/a[text()='Sub-Resources (1)']")));
//		this.page.element(
//					"//div[@id='mainContainer']/table/tbody/tr/td[5][text()='"
//					+ strResourceName
//					+ "']/parent::tr/td[1]/a[text()='Sub-Resources (1)']",
//								"xpath").getOne().click();
		this.page
		.element("//div[@id='mainContainer']/table/tbody/tr/td[5][text()='"
				+ strResourceName
				+ "']/parent::tr/td[1]/a[text()='Sub-Resources (1)']",
				"xpath").getOne().sendKeys(Keys.ENTER);
//		  Actions moveTO = new Actions(driver);
//		  moveTO.moveToElement(driver.findElement(By.xpath("//div[@id='mainContainer']/table/tbody/tr/td[5][text()='"
//					+ strResourceName
//					+ "']/parent::tr/td[1]/a[text()='Sub-Resources (1)']"))).click()
//		    .build().perform();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on edit link in Sub-Resource List for Page
	  * Arguments	: strSubResource
	  * Date        : 24/09/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public Resource clickOnEditLinkInSubResourceListPage(String strSubResource)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table[2]/tbody/tr/td[3][text()='"
				+ strSubResource
				+ "']/parent::tr/td[1]/a[text()='Edit']",
		"xpath");
		this.page
				.element(
						"//div[@id='mainContainer']/table[2]/tbody/tr/td[3][text()='"
								+ strSubResource
								+ "']/parent::tr/td[1]/a[text()='Edit']",
						"xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Edit Sub-Resource of ' page is displayed
	  * Date        : 22/09/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public Resource verEditSubResourceOfPageIsDisplayed(String strResourceName)
			throws Exception {
		objWaitForElement.waitForElements(headerName, "css");
		assertEquals("Edit Sub-Resource of " + strResourceName, this.page
				.element(headerName, "css").getOne().getText(),
				"Edit Sub-Resource of page is not displayed.");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify edit link in Sub-Resource List for Page
	  * Arguments	: strSubResource
	  * Date        : 24/09/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public Resource verEditLinkInSubResourceListPage(String strSubResource)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table[2]/tbody/tr/td[3][text()='"
				+ strSubResource
				+ "']/parent::tr/td[1]/a[text()='Edit']", "xpath");
		assertTrue(this.page.element(
				"//div[@id='mainContainer']/table[2]/tbody/tr/td[3][text()='"
						+ strSubResource
						+ "']/parent::tr/td[1]/a[text()='Edit']", "xpath")
				.isElementPresent());
		return this;
	}
	
	  /**********************************************************************************
	   * Description : This function is to verify CreateNewSubResource button
	   * Date        : 24/09/2014
	   * Author      : Sowmya
	   **********************************************************************************/
	public Resource verCreateNewSubResourceButtonIsPresent() throws Exception {
		objWaitForElement.waitForElements(createNewSubResource, "xpath");
		assertTrue(this.page.element(createNewSubResource, "xpath")
				.isElementPresent());
		return this;
	}
	
	 /**********************************************************************************
	   * Description : This function is to verify CreateNewSubResource button
	   * Date        : 24/09/2014
	   * Author      : Sowmya
	   **********************************************************************************/
	public Resource verCreateNewResourceButtonIsPresent() throws Exception {
		objWaitForElement.waitForElements(createNewResource, "xpath");
		assertTrue(this.page.element(createNewResource, "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to verify CreateNewSubResource button
	   * Date        : 24/09/2014
	   * Author      : Sowmya
	   **********************************************************************************/
	public Resource verCreateNewResourceButtonIsNotPresent() throws Exception {
		assertFalse(this.page.element(createNewResource, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	  /**********************************************************************************
	   * Description : This function is to verify CreateNewSubResource button is not present
	   * Date        : 24/09/2014
	   * Author      : Sowmya
	   **********************************************************************************/
	public Resource verCreateNewSubResourceButtonIsNotPresent() throws Exception {
		assertFalse(this.page.element(createNewSubResource, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Create New Sub-Resource for' page is displayed
	  * Date        : 22/09/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public Resource verCreateNewSubResourceForPageIsDisplayed(
			String strResourceName) throws Exception {
		objWaitForElement.waitForElements(
				"//div[@id='topSubNav']/h1[text()='Create New Sub-Resource for "
						+ strResourceName + "']", "xpath");
		assertTrue(this.page
				.element(
						"//div[@id='topSubNav']/h1[text()='Create New Sub-Resource for "
								+ strResourceName + "']", "xpath").getOne()
				.isDisplayed());
		// assertEquals("Create New Sub-Resource for " + strResourceName,
		// this.page.element(headerName, "css").getOne().getText(),
		// "Create New Sub-Resource for page is not displayed.");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on Demote link
	 * Parameters  : strResourceValue
	 * Date        : 22/06/2014
	 * Author      : Prasanna Lakshmi
	 **********************************************************************************/
	public Resource clickOnDemoteLink(String strResourceValue) throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table/tbody/tr/td[5][text()='" + strResourceValue + "']/parent::tr/td[1]/a[text()='Demote']", "xpath");
		this.page.element("//div[@id='mainContainer']/table/tbody/tr/td[5][text()='" + strResourceValue + "']/parent::tr/td[1]/a[text()='Demote']", "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select checkbox corresponding to Resource 
	 * Parameters  : strResource
	 * Date        : 22/06/2014
	 * Author      : Prasanna Lakshmi
	 **********************************************************************************/
	public Resource clickOnChkBoxForResource(String strResource)
			throws Exception {
		objWaitForElement.waitForElements("//table[@id='tbl_resourceID']/tbody/tr/td[2][text()='"
				+ strResource
				+ "']/preceding-sibling::td/input[@name='resourceID']",
		"xpath");
		this.page
				.element(
						"//table[@id='tbl_resourceID']/tbody/tr/td[2][text()='"
								+ strResource
								+ "']/preceding-sibling::td/input[@name='resourceID']",
						"xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to verify resource in not in the list.
	 * Arguements   : strResource
	 * Date 		: 23/09/2014 
	 * Author 		: Prasanna Lakshmi
	 **********************************************************************************/
	public Resource verResourceInNotInList(String strResource) throws Exception {
		assertFalse(
				this.page.element(
						"//div[@id='mainContainer']/table[2]/tbody/tr/td[5][text()='"
								+ strResource + "']", "xpath")
						.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE), "Resource is not present");
		return this;
	}
	/**********************************************************************************
	  * Description : This function is to verify Resource List Page is displayed 
	  * Arguements  : strResourceName
	  * Date        : 23/09/2014
	  * Author      : Prasanna Lakshmi
	  **********************************************************************************/
	 public Resource verSubResourceListPageisDisplayed(String strResourceName) throws Exception {
		 objWaitForElement.waitForElements("//div[@id='topSubNav']/h1[text()='Sub-Resource List for "+strResourceName+"']", "xpath");
		 assertTrue(this.page.element("//div[@id='topSubNav']/h1[text()='Sub-Resource List for "+strResourceName+"']", "xpath").getOne().isDisplayed());
	  	  assertEquals("Sub-Resource List for " +strResourceName, this.page.element(headerName, "css").getOne().getText());
	  return this;
	 }
	
	 /**********************************************************************************
	  * Description : This function is to verify Sub resource in under Parent Resource
	  * Arguements  : strResourceName
	  * Date        : 23/09/2014
	  * Author      : Prasanna Lakshmi
	  **********************************************************************************/
	 public Resource verSubResourceInSubResPage(String strResourceName) throws Exception {
		 objWaitForElement.waitForElements(resourcenameUnderParent, "xpath");
		  assertEquals(strResourceName, this.page.element(resourcenameUnderParent, "xpath").getOne().getText());
		  return this;
	 }
	 
	 /**********************************************************************************
	   * Description : This function is to verify status type listed
	   * Date        : 26/09/2014
	   * Author      : Anitha
	   **********************************************************************************/
	public Resource verifyStatusTypeNameIsListedInEditResLevelPage(String strStatusTypenames)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/form/table/tbody/tr[2]/td[2]",
				"xpath");
		assertTrue(this.page.element(
				"//div[@class='selectorData']/table/tbody/tr/td[2"
				+ "]/a[contains(text(),'"+strStatusTypenames+"')]","xpath").isElementPresent());
		return this;
	}
	
	 /**********************************************************************************
	 * Description : This function is to verify Resource list page is displayed
	 * Date :29/09/2014
	 * Author :shradha
	 **********************************************************************************/
		public Resource verResourceListPageIsDisplayed() throws Exception {
			objWaitForElement.waitForElements("//div[@id='topSubNav']/h1[text()='Resource List']", "xpath");
		assertTrue(this.page.element("//div[@id='topSubNav']/h1[text()='Resource List']", "xpath").getOne().isDisplayed());
			return this;
		}
	 /**********************************************************************************
	  * Description : This function is to click on cancel in resource list page
	  * Date        : 29/09/2014
	  * Author      : Shradha
	  **********************************************************************************/
		public Resource clickOncancelButton() throws Exception {
			objWaitForElement.waitForElements(cancelButton, "css");
			this.page.element(cancelButton, "css").getOne().click();
			return this;
		}

	/**********************************************************************************
	  * Description : This function is to verify Edit resource Page is displayed 
	  * Date        : 29/09/2014
	  * Author      : shradha
	  **********************************************************************************/
		public Resource verEditResourcePageisDisplayed() throws Exception {
			objWaitForElement.waitForElements("//div[@id='topSubNav']/h1[text()='Edit Resource']", "xpath");
			assertTrue(this.page.element("//div[@id='topSubNav']/h1[text()='Edit Resource']", "xpath").getOne().isDisplayed());
			assertEquals("Edit Resource", this.page.element(headerName, "css")
					.getOne().getText());
			return this;
		}

		/**********************************************************************************
		 * Description : This function is to verify Edit resource Page is displayed 
		 * Date        : 29/09/2014
		 * Author      : shradha
		 **********************************************************************************/
		public Resource verEditSubResourcePageisDisplayed() throws Exception {
			objWaitForElement.waitForElements("//div[@id='topSubNav']/h1[text()='Edit Sub Resource']", "xpath");
			assertTrue(this.page.element("//div[@id='topSubNav']/h1[text()='Edit Sub Resource']", "xpath").getOne().isDisplayed());
			assertEquals("Edit Sub Resource", this.page.element(headerName, "css")
					.getOne().getText());
			return this;
		}

	/**********************************************************************************
	  * Description : This function is to verify Subresourcelist of resource Page is displayed 
	  * Arguments	: strSubResourceName, strResourceAbbrivation, strSubResourceTypeName
	  * Date        : 29/09/2014
	  * Author      : shradha
	  **********************************************************************************/
		public Resource verSubResourcelistDetails(String strSubResourceName,
				String strResourceAbbrivation, String strSubResourceTypeName)
				throws Exception {
			objWaitForElement.waitForElements("//div[@id='mainContainer']/table[2]/tbody/tr/td[3][text()='"
					+ strSubResourceName
					+ "']/following-sibling::td[1][text()='"
					+ strResourceAbbrivation
					+ "']/following-sibling::td[1][text()='"
					+ strSubResourceTypeName + "']", "xpath");
			assertTrue(
					this.page.element(
							"//div[@id='mainContainer']/table[2]/tbody/tr/td[3][text()='"
									+ strSubResourceName
									+ "']/following-sibling::td[1][text()='"
									+ strResourceAbbrivation
									+ "']/following-sibling::td[1][text()='"
									+ strSubResourceTypeName + "']", "xpath")
							.isElementPresent(),
					"Subresorce list details is not present.");
			return this;
		}

	/**********************************************************************************
	 * Description : This function is to verify Resource appropriate values are displayed
	 * Date        : 08/10/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public Resource verResourceNameAndDetailsInResourceList(String strResourceName,
			String strAbbrivation, String strResourceTypeName) throws Exception {
		objWaitForElement.waitForElements("//tbody/tr/td[5][text()='" + strResourceName
				+ "']/parent::tr/td[6][text()='"
				+ strAbbrivation
				+ "']/parent::tr/td[7][text()='"
				+ strResourceTypeName + "']", "xpath");
		this.page
				.element(
						"//tbody/tr/td[5][text()='" + strResourceName
								+ "']/parent::tr/td[6][text()='"
								+ strAbbrivation
								+ "']/parent::tr/td[7][text()='"
								+ strResourceTypeName + "']", "xpath").getOne()
				.click();
		return this;
	}
	
  /**********************************************************************************
   * Description : This function is to verify resourceType Name In 'Edit Resource' page
   * Date        : 08/10/2014
   * Author      : Sowmya
   **********************************************************************************/
	public Resource verifyResourceNameInEditResource(String strResourceName)
			throws Exception {
		objWaitForElement.waitForElements(resourceName, "name");
		String strResName = this.page.element(resourceName, "name").getOne()
				.getAttribute("value");
		assertEquals(strResName, strResourceName);
		return this;
	}
	
	  /**********************************************************************************
	   * Description : This function is to verify resource Abbrivation In 'Edit Resource' page
	   * Date        : 08/10/2014
	   * Author      : Sowmya
	   **********************************************************************************/
	public Resource verifyResourceAbbrivationInEditResource(
			String strResourceAbbrivation) throws Exception {
		objWaitForElement.waitForElements(resourceDescription, "name");
		String strResAbb = this.page.element(resourceDescription, "name")
				.getOne().getAttribute("value");
		assertEquals(strResAbb, strResourceAbbrivation);
		return this;
	}
	
	  /**********************************************************************************
	   * Description : This function is to verify resource first Name In 'Edit Resource' page
	   * Date        : 08/10/2014
	   * Author      : Sowmya
	   **********************************************************************************/
	public Resource verifyResourceFirstNameInEditResource(
			String strResourceFirstName) throws Exception {
		objWaitForElement.waitForElements(resourceFirstName, "name");
		String strResFN = this.page.element(resourceFirstName, "name").getOne()
				.getAttribute("value");
		assertEquals(strResFN, strResourceFirstName);
		return this;
	}
	
	  /**********************************************************************************
	   * Description : This function is to verify resource Last Name In 'Edit Resource' page
	   * Date        : 08/10/2014
	   * Author      : Sowmya
	   **********************************************************************************/
	public Resource verifyResourceLastNameInEditResource(
			String strResourceLastName) throws Exception {
		objWaitForElement.waitForElements(resourceLastName, "name");
		String strResLN = this.page.element(resourceLastName, "name").getOne()
				.getAttribute("value");
		assertEquals(strResLN, strResourceLastName);
		return this;
	}
	
	  /**********************************************************************************
	   * Description : This function is to verify ResourceTypename In 'Edit Resource' page
	   * Date        : 08/10/2014
	   * Author      : Sowmya
	   **********************************************************************************/
	public Resource verifyResourceTypenameInEditResource(
			String strResourceTypeName) throws Exception {
		objWaitForElement.waitForElements(resourceTypeList, "name");
		String strResTypeName = this.page.element(resourceTypeList, "name")
				.webElementToSelect().getFirstSelectedOption().getText();
		assertEquals(strResTypeName, strResourceTypeName);
		return this;
	}

	/**********************************************************************************
	   * Description : This function is to verify 'resource is displayed appropriately for the respective fields'
	   *               in 'Edit Resource' page. 
	   * Date        : 08/10/2014
	   * Author      : Sowmya
	   **********************************************************************************/
	public Resource verifyResourceFieldsInEditResource(String strResourceName,
			String strResourceAbbrivation, String strResourceTypeName,
			String strResourceFirstName,
			String strResourceLastName) throws Exception {
		this.verifyResourceNameInEditResource(strResourceName);
		this.verifyResourceAbbrivationInEditResource(strResourceAbbrivation);
		this.verifyResourceFirstNameInEditResource(strResourceFirstName);
		this.verifyResourceLastNameInEditResource(strResourceLastName);
		this.verifyResourceTypenameInEditResource(strResourceTypeName);	
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Name in edit  resource details
	  * Arguments	: 
	  * Date        : 07/10/2014
	  * Author      : shradha
	  **********************************************************************************/
	public Resource verNameInEditResource(String strResourceName)
			throws Exception {
		objWaitForElement.waitForElements(resourceName, "name");
		String strFileNameInApp = this.page.element(resourceName, "name")
				.getOne().getAttribute("value");
		assertEquals(strResourceName, strFileNameInApp);
		return this;

	}
	
	/**********************************************************************************
	  * Description : This function is to verify Abbreviation in edit  resource details
	  * Arguments	: 
	  * Date        : 07/10/2014
	  * Author      : shradha
	  **********************************************************************************/
	public Resource verAbbreviationInEditResource(String strResourceAbbrivation)
			throws Exception {
		objWaitForElement.waitForElements(resourceDescription, "name");
		assertEquals(strResourceAbbrivation,
				this.page.element(resourceDescription, "name").getOne()
						.getAttribute("value"));

		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to verify ResourceTypename
	   * Date        : 07/10/2014
	   * Author      :shradha
	   **********************************************************************************/
	public Resource verResourceTypenameInEditResource(String strResourceTypeName)
			throws Exception {
		objWaitForElement.waitForElements(resourceTypeList, "name");
		String strFileNameInApp = this.page.element(resourceTypeList, "name")
				.webElementToSelect().getFirstSelectedOption().getText();
		assertEquals(strResourceTypeName, strFileNameInApp);
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to verify standard ResourceTypename
	   * Date        : 07/10/2014
	   * Author      :shradha
	   **********************************************************************************/
	public Resource verStandardResourceTypenameInEditResource(String strStandardResourceTypeName)
			throws Exception {
		objWaitForElement.waitForElements(standardResourceTypeList, "name");
		String strFileNameInApp=this.page.element(standardResourceTypeList, "name")
				 .webElementToSelect().getFirstSelectedOption().getText();
		assertEquals(strStandardResourceTypeName,strFileNameInApp);	
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify contactlastname in edit  resource details
	  * Arguments	: 
	  * Date        : 07/10/2014
	  * Author      : shradha
	  **********************************************************************************/
	public Resource verResourcefirstNameInEditResource(
			String strResourceFirstName) throws Exception {
		objWaitForElement.waitForElements(resourceFirstName, "name");
		assertEquals(strResourceFirstName,
				this.page.element(resourceFirstName, "name").getOne()
						.getAttribute("value"));
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to verify contactlastname in edit  resource details
	  * Arguments	: 
	  * Date        : 07/10/2014
	  * Author      : shradha
	  **********************************************************************************/
	public Resource verResourceLastNameInEditResource(String strResourceLastName)
			throws Exception {
		objWaitForElement.waitForElements(resourceLastName, "name");
		String strFileNameInApp=this.page.element(resourceLastName, "name")
				.getOne().getAttribute("value");
				assertEquals(strResourceLastName,strFileNameInApp);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify abbrevation in resourcelistpage
	  * Arguments	: 
	  * Date        : 07/10/2014
	  * Author      : shradha
	  **********************************************************************************/
	public Resource verResourceAbbrivationInResourceListPage(
			String strResourceAbbrivation) throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table/tbody/tr/td[text()='"
				+ strResourceAbbrivation + "']", "xpath");
		assertTrue(this.page.element(
				"//div[@id='mainContainer']/table/tbody/tr/td[text()='"
						+ strResourceAbbrivation + "']", "xpath")
				.getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify resouircetype in resourcelistpage
	  * Arguments	: 
	  * Date        : 07/10/2014
	  * Author      : shradha
	  **********************************************************************************/
	public Resource verResourceTypeInResourceListPage(String strResourceType)
			throws Exception {
		objWaitForElement.waitForElements("//tr/td[text()='"
				+ strResourceType + "']", "xpath");
		assertTrue(this.page.element(
				"//tr/td[text()='"
						+ strResourceType + "']", "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'verAssignUserstoResourcePageIsDisplayedf ' page is displayed
	  * Date        : 07/10/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public Resource verAssignUserstoResourcePageIsDisplayed(String strResourceName)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='topSubNav']/h1[text()='Assign Users to "+strResourceName+"']", "xpath");
		assertTrue(this.page.element("//div[@id='topSubNav']/h1[text()='Assign Users to "+strResourceName+"']", "xpath").getOne().isDisplayed());
		assertEquals("Assign Users to " + strResourceName, this.page
				.element(headerName, "css").getOne().getText(),
				"Edit Sub-Resource of page is not displayed.");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select is UsersLink In Resource List Page 
	  * Arguments	: 
	  * Date        : 29/09/2014
	  * Author      : shradha
	  **********************************************************************************/
	public Resource selectUsersLinkInResourceList(String strResourceName)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table[2]/tbody/tr/td[text()='"
				+ strResourceName
				+ "']/preceding-sibling::td/a[text()='Users']",
		"xpath");
		this.page
				.element(
						"//div[@id='mainContainer']/table[2]/tbody/tr/td[text()='"
								+ strResourceName
								+ "']/preceding-sibling::td/a[text()='Users']",
						"xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify view resourceright is selected
	  * Arguments	: 
	  * Date        : 07/10/2014
	  * Author      : shradha
	  **********************************************************************************/
	public Resource verViewResourceChkboxIsSelected(String strNewUserName)
			throws Exception {
		objWaitForElement.waitForElements("//table[@id='tbl_association']/tbody/tr/td[6][text()='"
				+ strNewUserName
				+ "']/preceding-sibling::td[2]/input[@checked='checked']",
		"xpath");
		assertTrue(this.page
				.element(
						"//table[@id='tbl_association']/tbody/tr/td[6][text()='"
								+ strNewUserName
								+ "']/preceding-sibling::td[2]/input[@checked='checked']",
						"xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************
	  * Description : This function is to deselect 'Associated with'
	  * Date        : 29/10/2014
	  * Author      : Sowmya
	  **********************************************************************/	
	public Resource deselectAllAssociatedWithOption() throws Exception {
		objWaitForElement.waitForElements(associatedWithAll, "xpath");
		if (this.page.element(associatedWithAll, "xpath").getOne().isSelected() == false) {
			this.page.element(associatedWithAll, "xpath").getOne().click();
			this.page.element(associatedWithAll, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************
	  * Description : This function is to deselect 'Update Status'
	  * Date        : 29/10/2014
	  * Author      : Sowmya
	  **********************************************************************/	
	public Resource deselectAllUpdateStatusOption() throws Exception {
		objWaitForElement.waitForElements(updateStatusAll, "xpath");
		if (this.page.element(updateStatusAll, "xpath").getOne().isSelected() == false) {
			this.page.element(updateStatusAll, "xpath").getOne().click();
			this.page.element(updateStatusAll, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************
	  * Description : This function is to deselect 'Run Reports'
	  * Date        : 29/10/2014
	  * Author      : Sowmya
	  **********************************************************************/	
	public Resource deselectAllRunReportsOption() throws Exception {
		objWaitForElement.waitForElements(runReportsAll, "xpath");
		if (this.page.element(runReportsAll, "xpath").getOne().isSelected() == false) {
			this.page.element(runReportsAll, "xpath").getOne().click();
			this.page.element(runReportsAll, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************
	  * Description : This function is to deselect 'View Resource'
	  * Date        : 29/10/2014
	  * Author      : Sowmya
	  **********************************************************************/	
	public Resource deselectAllViewResourceOption() throws Exception {
		objWaitForElement.waitForElements(viewResourceAll, "xpath");
		if (this.page.element(viewResourceAll, "xpath").getOne().isSelected() == false) {
			this.page.element(viewResourceAll, "xpath").getOne().click();
			this.page.element(viewResourceAll, "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select the 'View Resource' check box
	 * Date        : 29/08/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public Resource selectViewResourceCheckBox(String strUserName)
			throws Exception {
		objWaitForElement.waitForElements("input[value='" + strUserName
				+ "'][name='viewRight']", "css");
		
		if (this.page.element(
						"input[value='" + strUserName
								+ "'][name='viewRight']", "css").getOne()
				.isSelected() == false) {
			
			this.page.element(
					"input[value='" + strUserName + "'][name='viewRight']",
					"css").mouseOver();
			this.page
					.element(
							"input[value='" + strUserName
									+ "'][name='viewRight']", "css").getOne()
					.sendKeys(Keys.SPACE);
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to Verify Administer Users Check Box is displayed
	 * Date        : 29/10/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public Resource selectUpdateStatusOfResource(String strUserName)
			throws Exception {
		String strAdministerUser = "//table[@id='tbl_association']/tbody/tr/td[text()='"
				+ strUserName
				+ "']/preceding-sibling::td/input[@name='updateRight']";
		objWaitForElement.waitForElements(strAdministerUser, "xpath");
		assertTrue(this.page.dynamicElement(strUserName, strAdministerUser,
				"xpath").isElementPresent());
		if (this.page.dynamicElement(strUserName, strAdministerUser, "xpath")
				.getOne().isSelected() == false) {
			this.page.dynamicElement(strUserName, strAdministerUser, "xpath")
					.mouseOver();
			this.page.dynamicElement(strUserName, strAdministerUser, "xpath")
			.getOne().sendKeys(Keys.SPACE);
		}
		return this;
	}	
	
	
	/**********************************************************************************
	   * Description : This function is to Create shared Resource
	   * Date        : 11/06/2014
	   * Author      : Anitha
	   **********************************************************************************/

	public Resource createSharedResource(String strResourceName,
			String strResourceAbbrivation, String strResourceTypeName,
			String strStandardResourceTypename, String strResourceFirstName,
			String strResourceLastName) throws Exception {
		this.clickOnCreateNewResourceButton();
		this.enterResourceName(strResourceName);
		this.enterResourceAbbrivation(strResourceAbbrivation);
		this.selectResourceTypename(strResourceTypeName);
		this.selectStandardResourceTypename(strStandardResourceTypename);
		this.clickOnshareWithOtherReg();
		this.enterResourceFirstName(strResourceFirstName);
		this.enterResourceLastName(strResourceLastName);
		this.clickOnSaveButton();
		this.selectAllViewResourceOption();
		this.clickOnSaveButton();
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to Create Sub Resource With Address
	   * Date        : 11-Nov-2014 
	   * Author      : sangappa.k
	   **********************************************************************************/

	public Resource createSubResourceWithAddress(String strSubResourceName,
			String strResourceName, String strResourceAbbrivation,
			String strResourceTypeName, String strStandardResourceTypename,
			String strResourceFirstName, String strResourceLastName,
			String strStreetAddress, String strStateName, String strCityName,
			String strZipCode, String strCounty) throws Exception {
	        this.clickOnSubResourcesLink(strResourceName);
			this.clickOnCreateNewSubResourceButton();
			this.enterResourceName(strSubResourceName);
			this.enterResourceAbbrivation(strResourceAbbrivation);
			this.selectResourceTypename(strResourceTypeName);
			this.selectStandardResourceTypename(strStandardResourceTypename);
			this.enterResourceFirstName(strResourceFirstName);
			this.enterResourceLastName(strResourceLastName);
	        this.enterStreetAddress(strStreetAddress);
			this.selectState(strStateName);
			this.enterCity(strCityName);
			this.enterzipCode(strZipCode);
			this.selectCounty(strCounty);
			this.clickOnLookupAddressBtn();
			this.clickOnSaveButton();
			return this;
		}
	
	/**********************************************************************************
	 * Description : This function is to verify Search fields
	 * Date        : 10/06/2014
	 * Author      : Anitha
	 **********************************************************************************/
	public Resource verifySearchfieldsForStatusType() throws Exception {
		objWaitForElement.waitForElements(anyResourceType, "xpath");
		assertTrue(this.page.element(anyResourceType, "xpath")
				.isElementPresent());
		objWaitForElement.waitForElements(anySection, "xpath");
		assertTrue(this.page.element(anySection, "xpath")
				.isElementPresent());

		assertTrue(this.page.element(anyStandardStatusType, "xpath")
				.isElementPresent());
		
		assertTrue(this.page.element(statusTypeField, "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Search and ShowAll Buttons is displayed
	 * Date        : 06/08/2014
	 * Author      : Anil
	 **********************************************************************************/
	public Resource verifySearchAndShowAllButtons() throws Exception {
		objWaitForElement.waitForElements(searchButton, "css");
		assertTrue(this.page.element(searchButton, "css").getOne()
				.isDisplayed());
		assertTrue(this.page.element(showAllButton, "css").getOne()
				.isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to enter resourceType Name
	   * Date        : 11/06/2014
	   * Author      : Anitha
	   **********************************************************************************/
	public Resource enterStatusTypeName(String strStatusTypeName)
			throws Exception {
		objWaitForElement.waitForElements(searchTextName, "name");
		this.page.element(searchTextName, "name").clearInputValue()
				.sendKeys(strStatusTypeName);
		return this;
	}

	/**********************************************************************************
	   * Description : This function is to verify status type is displayed under Edit 
	   * 			   Resource-Level Status Types screen
	   * Date        : 19-May-2015
	   * Author      : Pallavi
	   **********************************************************************************/
	public Resource verifyStatusTypeIsDisplayedUnderEditResLevelST(
			String strStatusTypeName) throws Exception {
		objWaitForElement.waitForElements(
				"//div[@id='statusTypeID']//table/tbody/tr/td[2]/a[contains(text(),'"
						+ strStatusTypeName + "')]", "xpath");
		assertTrue(this.page.element(
				"//div[@id='statusTypeID']//table/tbody/tr/td[2]/a[contains(text(),'"
						+ strStatusTypeName + "')]", "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Create New Resource' page is displayed
	  * Date        : 29/May/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public Resource verCreateNewResourcePageIsDisplayed() throws Exception {
		objWaitForElement.waitForElements(headerName, "css");
		assertEquals("Create New Resource", this.page
				.element(headerName, "css").getOne().getText(),
				"Create New Resource page is not displayed.");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to Latitude value polpulated
	 * Date        : 29/May/2015 
	 * Author      : Renushree
	 **********************************************************************************/
	public Resource verLattitudePopulated() throws Exception {
		objWaitForElement.waitForElements(latitude, "css");
		String strlatitude = this.page.element(latitude, "css").getOne().getAttribute("value");
		assertTrue(!(strlatitude== null));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to Longitude value Populated
	 * Date        : 29/May/2015 
	 * Author      : Renushree
	 **********************************************************************************/
	public Resource verLongitudePopulated() throws Exception {
		objWaitForElement.waitForElements(longitude, "css");
		String strLongitude = this.page.element(longitude, "css").getOne().getAttribute("value");
		assertTrue(!(strLongitude== null));
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to Create Resource
	   * Date        : 11/06/2014
	   * Author      : Anil
	   **********************************************************************************/
	public Resource createSharedResourceWithAddress(String strResourceName,
			String strResourceAbbrivation, String strResourceTypeName,
			String strStandardResourceTypename, String strResourceFirstName,
			String strResourceLastName, String strStreetAddress,
			String strCityName, String strStateName, String strCounty,
			String strZipCode) throws Exception {
		this.clickOnCreateNewResourceButton();
		this.enterResourceName(strResourceName);
		this.enterResourceAbbrivation(strResourceAbbrivation);
		this.selectResourceTypename(strResourceTypeName);
		this.selectStandardResourceTypename(strStandardResourceTypename);
		this.clickOnshareWithOtherReg();
		this.enterResourceFirstName(strResourceFirstName);
		this.enterResourceLastName(strResourceLastName);
		this.enterStreetAddress(strStreetAddress);
		this.selectState(strStateName);
		this.enterCity(strCityName);
		this.enterzipCode(strZipCode);
		this.selectCounty(strCounty);
		this.clickOnLookupAddressBtn();
		this.verMap();
		this.clickOnSaveButton();
		this.selectAllViewResourceOption();
		this.clickOnSaveButton();
		return this;
	}


	/**********************************************************************************
	 * Description : This function is to get 6 digit after dicimal point Date :
	 *  Date:     25/June/2015
	 *  Author : Sangappa.k
	 **********************************************************************************/
	public String getDecimalFormatUpToSixDigits(String StrDecimal)
			throws Exception {
		double decimal1 = Double.valueOf(StrDecimal);
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(6);
		String Sixdigits = nf.format(decimal1);
        System.out.println("Six digits"+  Sixdigits);
		return Sixdigits;
	}
	
	/**********************************************************************************
	 * Description : This function is to get Latitude value with decimal value
	 * Date        : 25/June/2015
	 * Author      : Sangappa.k
	 **********************************************************************************/
	public String getLatitudeWithFraction() throws Exception {
		objWaitForElement.waitForElements(latitude, "css");
		String strlatitude = this.page.element(latitude, "css").getOne().getAttribute("value");
		return strlatitude;
	
	}
	
	/**********************************************************************************
	 * Description : This function is to get Longitude value with decimal value
	 * Date        :  25/June/2015
	 * Author      : Sangappa.k
	 **********************************************************************************/
	public String getLongitudeWithFraction() throws Exception {
		objWaitForElement.waitForElements(longitude, "css");
		String strLongitude = this.page.element(longitude, "css").getOne().getAttribute("value");
		return strLongitude;
	}

	
	/**********************************************************************************
	 * Description : This function is to get Latitude value
	 * Date        : 11/09/2014 
	 * Author      : Sinchana
	 **********************************************************************************/
	public String getLatitudeNew() throws Exception {
		objWaitForElement.waitForElements(latitude, "css");
		String strlatitude = this.page.element(latitude, "css").getOne().getAttribute("value");
		String str = strlatitude.substring(0, 9);
		System.out.println(str);
		return str;
	}
	
	/**********************************************************************************
	 * Description : This function is to get Longitude value
	 * Date        : 11/09/2014 
	 * Author      : Sinchana
	 **********************************************************************************/
	public String getLongitudeNew() throws Exception {
		objWaitForElement.waitForElements(longitude, "css");
		String strLongitude = this.page.element(longitude, "css").getOne().getAttribute("value");
		String str = strLongitude.substring(0, 10);
		System.out.println(str);
		return str;
	}
	/**********************************************************************************
	   * Description : This function is to verify status type is displayed under Edit 
	   * 			   Resource-Level Status Types screen
	   * Date        : 19-May-2015
	   * Author      : Anil
	   **********************************************************************************/
	public Resource verifyStatusTypeIsSelectedAndDisabledUnderEditResLevelST(
			String strStatusTypeName) throws Exception {
		objWaitForElement.waitForElements(
				"//div[@id='statusTypeID']//table/tbody/tr/td[2]/a[contains(text(),'"
						+ strStatusTypeName + "')]", "xpath");
		assertTrue(this.page.element(
				"//div[@id='statusTypeID']//table/tbody/tr/td[2]/a[contains(text(),'"+strStatusTypeName+"')]/parent::td/preceding-sibling::td[1]/input", "xpath")
				.getOne().isSelected());
		assertTrue(this.page.element(
				"//div[@id='statusTypeID']//table/tbody/tr/td[2]/a[contains(text(),'"+strStatusTypeName+"')]/parent::td/preceding-sibling::td[1]/input", "xpath")
				.getOne().isEnabled()==false);
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to verify status type is displayed under Edit 
	   * 			   Resource-Level Status Types screen
	   * Date        : 19-May-2015
	   * Author      : Anil
	   **********************************************************************************/
	public Resource verifyStatusTypeIsSelectedUnderEditResLevelST(
			String strStatusTypeName) throws Exception {
		objWaitForElement.waitForElements(
				"//div[@id='statusTypeID']//table/tbody/tr/td[2]/a[contains(text(),'"+strStatusTypeName+"')]/parent::td/preceding-sibling::td[1]/input", "xpath");
		assertTrue(this.page.element(
				"//div[@id='statusTypeID']//table/tbody/tr/td[2]/a[contains(text(),'"+strStatusTypeName+"')]/parent::td/preceding-sibling::td[1]/input", "xpath")
				.getOne().isSelected());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Edit Resource-Level Status Types Page is displayed 
	  * Date        : 29/09/2014
	  * Author      : Anil
	  **********************************************************************************/
	public Resource verEditResourceLevelStatusTypesPageisDisplayed() throws Exception {
		objWaitForElement.waitForElements("//div[@id='topSubNav']/h1[text()='Edit Resource-Level Status Types']", "xpath");
		assertTrue(this.page.element("//div[@id='topSubNav']/h1[text()='Edit Resource-Level Status Types']", "xpath").getOne().isDisplayed());
		return this;
	}
	/**********************************************************************************
	   * Description : This function is to verify status type is displayed under Edit 
	   * 			   Resource-Level Status Types screen
	   * Date        : 19-May-2015
	   * Author      : Anil
	   **********************************************************************************/
	public Resource verifyStatusTypeIsNotSelectedAndEnabledUnderEditResLevelST(
			String strStatusTypeName) throws Exception {
		objWaitForElement.waitForElements(
				"//div[@id='statusTypeID']//table/tbody/tr/td[2]/a[contains(text(),'"
						+ strStatusTypeName + "')]", "xpath");
		assertFalse(this.page.element(
				"//div[@id='statusTypeID']//table/tbody/tr/td[2]/a[contains(text(),'"+strStatusTypeName+"')]/parent::td/preceding-sibling::td[1]/input", "xpath")
				.getOne().isSelected());
		assertTrue(this.page.element(
				"//div[@id='statusTypeID']//table/tbody/tr/td[2]/a[contains(text(),'"+strStatusTypeName+"')]/parent::td/preceding-sibling::td[1]/input", "xpath")
				.getOne().isEnabled());
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to verify status type is displayed under Edit 
	   * 			   Resource-Level Status Types screen
	   * Date        : 19-May-2015
	   * Author      : Anil
	   **********************************************************************************/
	public Resource verifyStatusTypeIsSelectedAndEnabledUnderEditResLevelST(
			String strStatusTypeName) throws Exception {
		objWaitForElement.waitForElements(
				"//div[@id='statusTypeID']//table/tbody/tr/td[2]/a[contains(text(),'"
						+ strStatusTypeName + "')]", "xpath");
		assertTrue(this.page.element(
				"//div[@id='statusTypeID']//table/tbody/tr/td[2]/a[contains(text(),'"+strStatusTypeName+"')]/parent::td/preceding-sibling::td[1]/input", "xpath")
				.getOne().isSelected());
		assertTrue(this.page.element(
				"//div[@id='statusTypeID']//table/tbody/tr/td[2]/a[contains(text(),'"+strStatusTypeName+"')]/parent::td/preceding-sibling::td[1]/input", "xpath")
				.getOne().isEnabled());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select the 'View Resource' check box
	 * Date        : 01/7/2014
	 * Author      : Anitha
	 **********************************************************************************/
	public Resource deSelectViewResourceCheckBox(String strUserName)
			throws Exception {
		objWaitForElement.waitForElements(
				"//table[@id='tbl_association']/tbody/tr/td[text()='"
						+ strUserName + "']/parent::tr/td[4]/input", "xpath");
		if (this.page
				.element(
						"//table[@id='tbl_association']/tbody/tr/td[text()='"
								+ strUserName + "']/parent::tr/td[4]/input",
						"xpath").getOne().isSelected() == true) {
			this.page.element(
					"//table[@id='tbl_association']/tbody/tr/td[text()='"
							+ strUserName + "']/parent::tr/td[4]/input",
					"xpath").mouseOver();
			this.page
			.element(
					"//table[@id='tbl_association']/tbody/tr/td[text()='"
							+ strUserName + "']/parent::tr/td[4]/input",
					"xpath").getOne().click();
		}
		
		if (this.page
				.element(
						"//table[@id='tbl_association']/tbody/tr/td[text()='"
								+ strUserName + "']/parent::tr/td[4]/input",
						"xpath").getOne().isSelected() == true) {
			
			this.page
			.element(
					"//table[@id='tbl_association']/tbody/tr/td[text()='"
							+ strUserName + "']/parent::tr/td[4]/input",
					"xpath").getOne().sendKeys(Keys.SPACE);
		 }
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Users' link in Resource list page
	 * Date        : 02/Jul/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public Resource clickOnUsersLink(String strResourceName) throws Exception {
		objWaitForElement.waitForElements(
				"//div[@id='mainContainer']/table/tbody/tr/td[5][text()='"
						+ strResourceName
						+ "']/parent::tr/td[1]/a[text()='Users']", "xpath");
		this.page
				.element(
						"//div[@id='mainContainer']/table/tbody/tr/td[5][text()='"
								+ strResourceName
								+ "']/parent::tr/td[1]/a[text()='Users']",
						"xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify run report resourceright is selected
	  * Arguments	: strNewUserName
	  * Date        : 02/Jul/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public Resource verRunReportChkboxIsSelected(String strNewUserName)
			throws Exception {
		objWaitForElement.waitForElements("//table[@id='tbl_association']/tbody/tr/td[6][text()='"
				+ strNewUserName
				+ "']/preceding-sibling::td[3]/input[@checked='checked'][@name='reportRight']",
		"xpath");
		assertTrue(this.page
				.element(
						"//table[@id='tbl_association']/tbody/tr/td[6][text()='"
								+ strNewUserName
								+ "']/preceding-sibling::td[3]/input[@checked='checked'][@name='reportRight']",
						"xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify update resource right is selected
	  * Arguments	: strNewUserName
	  * Date        : 02/Jul/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public Resource verUpdateRightChkboxIsSelected(String strNewUserName)
			throws Exception {
		objWaitForElement.waitForElements("//table[@id='tbl_association']/tbody/tr/td[6][text()='"
				+ strNewUserName
				+ "']/preceding-sibling::td[4]/input[@checked='checked'][@name='updateRight']",
		"xpath");
		assertTrue(this.page
				.element(
						"//table[@id='tbl_association']/tbody/tr/td[6][text()='"
								+ strNewUserName
								+ "']/preceding-sibling::td[4]/input[@checked='checked'][@name='updateRight']",
						"xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify update resource right is selected
	  * Arguments	: strNewUserName
	  * Date        : 02/Jul/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public Resource verAssociateRightChkboxIsSelected(String strNewUserName)
			throws Exception {
		objWaitForElement.waitForElements("//table[@id='tbl_association']/tbody/tr/td[6][text()='"
				+ strNewUserName
				+ "']/preceding-sibling::td[5]/input[@checked='checked'][@name='association']",
		"xpath");
		assertTrue(this.page
				.element(
						"//table[@id='tbl_association']/tbody/tr/td[6][text()='"
								+ strNewUserName
								+ "']/preceding-sibling::td[5]/input[@checked='checked'][@name='association']",
						"xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify error Message in find resource screen 
	  * Date        : 1/July/2015
	  * Author      : Anil
	  **********************************************************************************/	
	public Resource verifyErrorMsgInAssignResourcePage() throws Exception {
		objWaitForElement
				.waitForElements(
						"//span[@class='emsErrorTitle'][text()='The following error occurred on this page:']",
						"xpath");
		assertTrue(this.page
				.element(
						"//span[@class='emsErrorTitle'][text()='The following error occurred on this page:']",
						"xpath").getOne().isDisplayed());
		assertTrue(this.page
				.element(
						"//div[@class='emsError']/ul/li[text()='A user that has any of Associated With, "
						+ "Update Status, or Run Reports for a resource must have View Resource.']",
						"xpath").getOne().isDisplayed());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to Verify Administer Users Check Box is displayed
	 * Date        : 29/10/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public Resource deSelectUpdateStatusOfResource(String strUserName)
			throws Exception {
		objWaitForElement.waitForElements("input[value='" + strUserName
				+ "'][name='updateRight']", "css");
		
		if (this.page.element(
						"input[value='" + strUserName
								+ "'][name='updateRight']", "css").getOne()
				.isSelected() == true) {
			
			this.page.element(
					"input[value='" + strUserName + "'][name='updateRight']",
					"css").mouseOver();
			this.page
					.element(
							"input[value='" + strUserName
									+ "'][name='updateRight']", "css").getOne()
					.sendKeys(Keys.SPACE);
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select the 'View Resource' check box
	 * Date        : 01/7/2014
	 * Author      : Anitha
	 **********************************************************************************/
	public Resource selectRunReportCheckBox(String strUserName)
			throws Exception {
		objWaitForElement.waitForElements("input[value='" + strUserName
				+ "'][name='reportRight']", "css");
		
		if (this.page.element(
						"input[value='" + strUserName
								+ "'][name='reportRight']", "css").getOne()
				.isSelected() == false) {
			
			this.page.element(
					"input[value='" + strUserName + "'][name='reportRight']",
					"css").mouseOver();
			this.page
					.element(
							"input[value='" + strUserName
									+ "'][name='reportRight']", "css").getOne()
					.sendKeys(Keys.SPACE);
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select the 'View Resource' check box
	 * Date        : 01/7/2014
	 * Author      : Anitha
	 **********************************************************************************/
	public Resource deSelectRunReportCheckBox(String strUserName)
			throws Exception {
		objWaitForElement.waitForElements("input[value='" + strUserName
				+ "'][name='reportRight']", "css");
		
		if (this.page.element(
						"input[value='" + strUserName
								+ "'][name='reportRight']", "css").getOne()
				.isSelected() == true) {
			
			this.page.element(
					"input[value='" + strUserName + "'][name='reportRight']",
					"css").mouseOver();
			this.page
					.element(
							"input[value='" + strUserName
									+ "'][name='reportRight']", "css").getOne()
					.sendKeys(Keys.SPACE);
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select the 'View Resource' check box
	 * Date        : 01/7/2014
	 * Author      : Anitha
	 **********************************************************************************/
	public Resource selectAssociatedWithCheckBox(String strUserName)
			throws Exception {
		objWaitForElement.waitForElements("input[value='" + strUserName
				+ "'][name='association']", "css");
		
		if (this.page.element(
						"input[value='" + strUserName
								+ "'][name='association']", "css").getOne()
				.isSelected() == false) {
			
			this.page.element(
					"input[value='" + strUserName + "'][name='association']",
					"css").mouseOver();
			this.page
					.element(
							"input[value='" + strUserName
									+ "'][name='association']", "css").getOne()
					.sendKeys(Keys.SPACE);
		}
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select the 'View Resource' check box
	 * Date        : 01/7/2014
	 * Author      : Anitha
	 **********************************************************************************/
	public Resource deSelectAssociatedWithCheckBox(String strUserName)
			throws Exception {
		objWaitForElement.waitForElements("input[value='" + strUserName
				+ "'][name='association']", "css");
		
		if (this.page.element(
						"input[value='" + strUserName
								+ "'][name='association']", "css").getOne()
				.isSelected() == true) {
			
			this.page.element(
					"input[value='" + strUserName + "'][name='association']",
					"css").mouseOver();
			this.page
					.element(
							"input[value='" + strUserName
									+ "'][name='association']", "css").getOne()
					.sendKeys(Keys.SPACE);
		}
		return this;
	}
	/**********************************************************************************
	 * Description : This function is used to click on 'Refine' link in View resource
	 * Date        : 05/08/2014
	 * Author      : Anil
	 **********************************************************************************/
	public Resource clickRefineLinkOfUserName(String strUserName)
			throws Exception {
		objWaitForElement.waitForElements("//table[@id='tbl_association']/tbody/tr/td[text()='"
				+ strUserName
				+ "']/parent::tr/td/a[text()='Refine']",
		"xpath");
		this.page
				.element(
						"//table[@id='tbl_association']/tbody/tr/td[text()='"
								+ strUserName
								+ "']/parent::tr/td/a[text()='Refine']",
						"xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select status type
	  * Date        : 11/08/2014
	  * Author      : Anil
	  **********************************************************************************/
	public Resource deselectStatusType(String[] strStatusTypeValues)
			throws Exception {
		objWaitForElement.waitForElements("//input[@value='"
				+ strStatusTypeValues[0] + "'][@name='statusTypeID']", "xpath");
		
		for (int i = 0; i < strStatusTypeValues.length; i++) {
			if (this.page
					.element(
							"//input[@value='" + strStatusTypeValues[i]
									+ "'][@name='statusTypeID']", "xpath")
					.getOne().isSelected() == true) {
				this.page.dynamicElement(
						"StatusTypeValues",
						"//input[@value='" + strStatusTypeValues[i]
								+ "'][@name='statusTypeID']", "xpath")
						.mouseOver();
				this.page.dynamicElement(
						"StatusTypeValues",
						"//input[@value='" + strStatusTypeValues[i]
								+ "'][@name='statusTypeID']", "xpath")
						.getOne().sendKeys(Keys.SPACE);
			}
		}
		return this;

	}
	
	/*******************************************************************************************************
	 * Description : This function is to verify 'Sub-Resources(1)' link is not present in Resource list page
	 * Date        : 30/07/2015
	 * Author      : Sowmya
	 ******************************************************************************************************/
	public Resource verSubResources1LinkInResourceListIsNotDiaplayed(
			String strResourceName) throws Exception {
		assertFalse(this.page.element(
				"//div[@id='mainContainer']/table/tbody/tr/td[5][text()='"
						+ strResourceName
						+ "']/parent::tr/td[1]/a[text()='Sub-Resources (1)']",
				"xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to verify street in edit resource page
	   * Date        : 30-Jul-2015
	   * Author      : Deepa
	   **********************************************************************************/
	public Resource verifyStreetInEditResource(
			String strStreetAddress) throws Exception {
		objWaitForElement.waitForElements(streetAddress, "id");
		String strResFN = this.page.element(streetAddress, "id").getOne()
				.getAttribute("value");
		assertEquals(strResFN, strStreetAddress);
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to verify city in edit resource page
	   * Date        : 30-Jul-2015
	   * Author      : Deepa
	   **********************************************************************************/
	public Resource verifyCityInEditResource(
			String strCity) throws Exception {
		String strResFN = this.page.element(city, "id").getOne()
				.getAttribute("value");
		assertEquals(strResFN, strCity);
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to verify state in edit resource page
	   * Date        : 30-Jul-2015
	   * Author      : Deepa
	   **********************************************************************************/
	public Resource verifyStateInEditResource(
			String strState) throws Exception {
		String strResFN = this.page.element(state, "id").getOne()
				.getAttribute("value");
		assertEquals(strResFN, strState);
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to verify zip in edit resource page
	   * Date        : 30-Jul-2015
	   * Author      : Deepa
	   **********************************************************************************/
	public Resource verifyZipInEditResource(
			String strZip) throws Exception {
		String strResFN = this.page.element(zipCode, "id").getOne()
				.getAttribute("value");
		assertEquals(strResFN, strZip);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on edit link of first resource page.
	  * Arguments	: strResource
	  * Date        : 09/09/20130-Jul-20154
	  * Author      : Deepa
	  **********************************************************************************/
	public Resource clickOnEditFirstResource()
			throws Exception {
		this.page
				.element(
						"//div[@id='mainContainer']/table[2]/tbody/tr[1]/td[1]/a[text()='Edit']",
						"xpath").mouseOver();
		this.page
				.element(
						"//div[@id='mainContainer']/table[2]/tbody/tr[1]/td[1]/a[text()='Edit']",
						"xpath").getOne().sendKeys(Keys.ENTER);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Users' link of first Resource 
	 * Date        : 31-Jul-2015
	 * Author      : Deepa
	 **********************************************************************************/
	public Resource clickOnUsersLinkOfFirstRes()
			throws Exception {
		this.page
				.element(
						"//div[@id='mainContainer']/table/tbody/tr[1]/td[1]/a[text()='Users']",
						"xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify user is not displayed in users list
	  * Arguments	: 
	  * Date        : 31-Jul-2015
	  * Author      : Deepa
	  **********************************************************************************/
	public Resource verUserIsNotDisInUsersList(String strNewUserName)
			throws Exception {
		assertFalse(this.page.element(
				"//table[@id='tbl_association']/tbody/tr/td[6][text()='"
						+ strNewUserName + "']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to verify that resource is displayed once in the list.
	   * Date        : 08-Aug-2015
	   * Author      : Deepa
	   **********************************************************************************/
	 public Resource verResourceIsDisplayedOnceInList(String strResource)
	   throws Exception {
	  int num = driver
	    .findElements(
	      By.xpath("//div[@id='mainContainer']/table[2]/tbody/tr/td[5][text()='"
	        + strResource + "']")).size();
	  assertEquals(num, 1);
	  return this;
	 }
	 
	 /**********************************************************************************
	   * Description : This function is to verify that Sub resourceType is listed under under Resource Type drop down
	   * Date        : 14-Aug-2015
	   * Author      : Sangappa.k
	   **********************************************************************************/
	 public Resource verSubResTypeIsListedUnderResTypDropDown(String strSubResourceType)
	   throws Exception {
		
	String strRType="//select[@name='resourceTypeID']/option[text()='"+strSubResourceType+"']";	 
	 assertTrue((this.page.element(strRType, "xpath").isElementPresent()), "sub RT is not listed"); 
	 
	  return this;
	 }
	 /**********************************************************************************
	  * Description : This function is to verify Sub resource abbrevation
	  * Arguements  : strResourceName
	  * Date        : 14-Aug-2015
	  * Author      : Prasanna Lakshmi
	  **********************************************************************************/
	 public Resource verSubResourceAbbInSubResPage(String strSubRes,String strAbb) throws Exception {
		 
		 String strAbbb="//table[@class='displayTable striped border sortable']/tbody/tr/td[text()='"+strSubRes+"']/following-sibling::td[text()='"+strAbb+"']";
		 objWaitForElement.waitForElements(strAbbb, "xpath");
		 assertEquals(strAbb, this.page.element(strAbbb, "xpath").getOne().getText());
		  return this;
	 } 
	 
	 /**********************************************************************************
	  * Description : This function is to verify Sub resource abbrevation
	  * Arguements  : strResourceName
	  * Date        : 14-Aug-2015
	  * Author      : Prasanna Lakshmi
	  **********************************************************************************/
	 public Resource verSubResTypeForSubResourInSubResPage(String strSubRes,String strSubRT) throws Exception {
		 
		 String strSubRTy="//table[@class='displayTable striped border sortable']/tbody/tr/td[text()='"+strSubRes+"']/following-sibling::td[text()='"+strSubRT+"']";
		 objWaitForElement.waitForElements(strSubRTy, "xpath");
		 assertTrue( this.page.element(strSubRTy, "xpath").getOne().isDisplayed());
		  return this;
	 } 
	  /**********************************************************************************
	   * Description : This function is to verify Sub resource in under Parent Resource
	   * Arguements  : strResourceName
	   * Date        : 23/09/2014
	   * Author      : Prasanna Lakshmi
	   **********************************************************************************/
	  public Resource verSubResourceinSubResPage(String strResourceName) throws Exception {
	   objWaitForElement.waitForElements(resourcenameUnderParent, "xpath");
	    assertEquals(strResourceName, this.page.element(resourcenameUnderParent, "xpath").getOne().getText());
	    return this;
	  }
	  /**********************************************************************************
	   * Description : This function is to select ResourceTypename
	   * Date        : 11/06/2014
	   * Author      : Anitha
	   **********************************************************************************/
	public Resource verifySRTNotInDropDown(String strSubResourceTypeName)
			throws Exception {
		assertFalse(this.page.element(
				"//select[@name='resourceTypeID']/option[text()='"
						+ strSubResourceTypeName + "']", "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	  /**********************************************************************************
	   * Description : This function is to verify sub ResourceTypename In 'Edit sub Resource' page
	   * Date        : 08/10/2014
	   * Author      : Anil
	   **********************************************************************************/
	public Resource verifySubResourceTypenameInEditSubResource(
			String strResourceTypeName) throws Exception {
		objWaitForElement.waitForElements("//input[@name='resourceTypeName'][@value='"+strResourceTypeName+"']", "xpath");
		assertTrue(this.page.element("//input[@name='resourceTypeName'][@value='"+strResourceTypeName+"']", "xpath").getOne().isDisplayed());
		return this;
	}
	
		  /**********************************************************************************
	 * Description : This function is to verify sub ResourceTypename In 'Edit sub Resource' page is disabled
	 * Date        : 08/10/2014
	 * Author      : Anil
	 **********************************************************************************/
	public Resource verifySubResourceTypenameInEditSubResourceIsDisabled(
			String strResourceTypeName) throws Exception {
		objWaitForElement.waitForElements("//input[@name='resourceTypeName'][@value='"+strResourceTypeName+"']", "xpath");
		assertTrue(this.page.element("//input[@name='resourceTypeName'][@value='"+strResourceTypeName+"']", "xpath").getOne().isEnabled()==false);
		return this;
	}

	/**********************************************************************************
	* Description : This function is to verifye fields in create sub resource type page
	* Date        : 08/10/2014
	* Author      : Anil
	**********************************************************************************/
			public Resource verifySubResourceFields() throws Exception {
				String strFieldNames[] = {"Name:","Abbreviation:", "Resource Type:", "Standard Resource Type:", "External ID:", "Street Address:", "City:", "State:", "Zip Code:", "County:", "Latitude/Longitude:", "Website:",
						"Contact First Name:", "Contact Last Name:", "Title:", "Contact Address:", "Contact Phone 1 (e.g. 888-555-1212):", "Contact Phone 2 (e.g. 888-555-1212):",
						"Contact Fax (e.g. 888-555-1212):", "Contact E-Mail (e.g. person@hospital.com):", "Notes:" };
		String strFields[] = {"resourceName", "abbreviation", "resourceTypeID", "standardResourceTypeID", "externalID", "streetAddress", "city", "stateAbbrev", "zipCode", "county", "latitude", "website",
						"firstName", "lastName", "title", "contactAddr", "phone1", "phone2", "fax", "eMail", "notes" };
		
		for(int intCount=0; intCount<strFieldNames.length;intCount++){
				objWaitForElement.waitForElements("//td[text()='"+strFieldNames[intCount]+"']/following-sibling::td/*[@name='"+strFields[intCount]+"']", "xpath");
				assertTrue(this.page.element("//td[text()='"+strFieldNames[intCount]+"']/following-sibling::td/*[@name='"+strFields[intCount]+"']", "xpath").getOne().isDisplayed(), "Failed for "+strFieldNames[intCount]+" "+strFields[intCount]);
		}
				return this;
			}
	
	  /**********************************************************************************
		* Description : This function is to verify subresource type is not displayed in dropdown
		* Date        : 08/10/2014
		* Author      : Anil
		**********************************************************************************/
		public Resource verifySubResourceTypeNotDisplayedInDropDown(
				String strResourceTypeName) throws Exception {
			assertFalse(this.page.element("//select[@name='resourceTypeID']/option[text()='"+strResourceTypeName+"']", "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
			return this;
		}
		
		/**********************************************************************************
		   * Description : This function is to select Standard Status Type
		   * Date        : 29/09/2015
		   * Author      : Sangappa.k
		   **********************************************************************************/
		public Resource selectStandardStatusType(
				String strStandardStatusTypename) throws Exception {
			objWaitForElement.waitForElements("standardResourceTypeID", "name");
			assertTrue(this.page.element("standardResourceTypeID", "name").isElementPresent());
			this.page.element("standardResourceTypeID", "name")
					.webElementToSelect()
					.selectByVisibleText(strStandardStatusTypename);
			return this;
		}
		
	 /**********************************************************************************
	  * Description : This function is to verify Sub resource Edit link
	  * Date        : 14-Aug-2015
	  * Author      : Anitha
	  **********************************************************************************/
	public Resource verEditLinkForSubResource(String strSubResourceName)
			throws Exception {
		String strSubResourceEditLink = "//table/thead/tr/th[text()='Action']/ancestor::table/tbody/tr/td[text()='"
				+ strSubResourceName
				+ "']/preceding-sibling::td/a[text()='Edit']";
		objWaitForElement.waitForElements(strSubResourceEditLink, "xpath");
		assertTrue(this.page.element(strSubResourceEditLink, "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Sub resource Icon
	  * Date        : 14-Aug-2015
	  * Author      : Anitha
	  **********************************************************************************/
	public Resource verIconForSubResource(String strSubResourceName,
			String strSubResourceIcon) throws Exception {
		String strSubResourceIcon1 = "//table/tbody/tr/td[text()='"
				+ strSubResourceName + "']/preceding-sibling::td/img[@src='"
				+ strSubResourceIcon + "']";
		objWaitForElement.waitForElements(strSubResourceIcon1, "xpath");
		assertTrue(this.page.element(strSubResourceIcon1, "xpath")
				.isElementPresent());
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify 'Sub-Resources(1)' link in Resource list page
	 * Date        : 22/09/2014
	 * Author      : Anitha
	 **********************************************************************************/
	public Resource verSubResources2LinkInResourceList(String strResourceName)
			throws Exception {
		objWaitForElement.waitForElements(
				"//div[@id='mainContainer']/table/tbody/tr/td[5][text()='"
						+ strResourceName
						+ "']/parent::tr/td[1]/a[text()='Sub-Resources (2)']",
				"xpath");
		assertEquals(
				"Sub-Resources (2)",
				this.page
						.element(
								"//div[@id='mainContainer']/table/tbody/tr/td[5][text()='"
										+ strResourceName
										+ "']/parent::tr/td[1]/a[text()='Sub-Resources (2)']",
								"xpath").getOne().getText());
		return this;
	}
	
	 /**********************************************************************************
	 * Description 	: This function is to verify Demote Resource list page is displayed
	 * Date 		: 11/01/2016
	 * Author 		: Rensuhree
	 **********************************************************************************/
	public Resource verDemoteResorcePageIsDisplayed(String strResourceName)
			throws Exception {
		objWaitForElement.waitForElements(
				"//div[@id='topSubNav']/h1[text()='Demote Resource -- "
						+ strResourceName + "']", "xpath");
		assertTrue(this.page
				.element(
						"//div[@id='topSubNav']/h1[text()='Demote Resource -- "
								+ strResourceName + "']", "xpath").getOne()
				.isDisplayed());
		return this;
	}
	
	 /**********************************************************************************
	 * Description 	: This function is to verify selected Resource is displayed and disabled ind emote resource page
	 * Date 		: 11/01/2016
	 * Author 		: Rensuhree
	 **********************************************************************************/
	public Resource verSelResorceDisplyedAndDisabledInDemoteResPage(
			String strResourceName) throws Exception {
		assertTrue(this.page.element(
				"//input[@name='resourceName'][@disabled='disabled'][@value='"
						+ strResourceName + "']", "xpath").isElementPresent());
		return this;
	}
		
	/**********************************************************************************
	 * Description : This function is to verify 'Demote' link in Resource list page
	 * Date        : 22/09/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public Resource verifyDemoteLinkNotDisplayed(String strResourceName)
			throws Exception {
		assertFalse(this.page.element(
				"//div[@id='mainContainer']/table/tbody/tr/td[5][text()='"
						+ strResourceName
						+ "']/parent::tr/td[1]/a[5][text()='Demote']", "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
		}
	
	
	/**********************************************************************************
	  * Description : This function is to verify "You may not demote a resource that is in an ongoing event."
	  * Date        : 11-Jan-2015
	  * Author      : Sangappa K
	  **********************************************************************************/
	public Resource verCantDemoteResInOnGoingEventErrorMsg() throws Exception {
		String strErrorMsg = "//div[@class='emsError']";
		objWaitForElement.waitForElements(strErrorMsg, "xpath");

		System.out.println(this.page.element(strErrorMsg, "xpath").getOne()
				.getText());

		assertEquals(
				this.page.element(strErrorMsg, "xpath").getOne().getText(),
				"The following error occurred on this page:"+"\n"+
						 "You may not demote a resource that is in an ongoing event.");
		return this;
	}
	
	  /**********************************************************************************
	   * Description : This function is to verify Sub resource in under Parent Resource
	   * Arguements  : strResourceName
	   * Date        : 11-Jan-2015
	   * Author      : Sangappa K
	   **********************************************************************************/
	  public Resource verSubResourceNotinSubResPage(String strResourceName,String strsubResName) throws Exception {
	   objWaitForElement.waitForElements("//td[text()='"+strResourceName+"']/following-sibling::td[text()='"+strsubResName+"']", "xpath");
	    assertFalse(this.page.element("//td[text()='"+strResourceName+"']/following-sibling::td[text()='"+strsubResName+"']", "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
	    return this;
	  }
	
  /**********************************************************************************
	 * Description : This function is to click on Demote link not present for corresponding res. 
	 * Parameters  : strResourceValue
	 * Date        : 11-Jan-2015
	 * Author      : Sangappa K
	 **********************************************************************************/
	public Resource verDemoteLinkNotPresentForAscRes(String strResourceValue)
			throws Exception {
		objWaitForElement.waitForElements(
				"//div[@id='mainContainer']/table/tbody/tr/td[5][text()='"
						+ strResourceValue
						+ "']/parent::tr/td[1]/a[text()='Demote']", "xpath");
		assertFalse(this.page.element(
				"//div[@id='mainContainer']/table/tbody/tr/td[5][text()='"
						+ strResourceValue
						+ "']/parent::tr/td[1]/a[text()='Demote']", "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to click on 'Create Ne
	 * w User' button
	 * Date        : 09/06/2014
	 * Author      : Anil
	 **********************************************************************************/
	public Resource verRoleIsNotPresentInSearchDropDown(String strRoleName)
			throws Exception {
		assertFalse(this.page.element(
				"//select[@id='tbl_association_ROLE']/option[text()='"
						+ strRoleName + "']", "xpath").isElementPresent(
				WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to seelct 'Reports HAvBED data' check box while
	 * 				 creating Resource
	 * Date        : 17-Feb-2016
	 * Author      : Pallavi
	 **********************************************************************************/
	public Resource selectReportsHavBedDataChaeckBox() throws Exception {
		if (!this.page.element(reportsHavBedDataCheckBox, "css").getOne()
				.isSelected()) {
			this.page.element(reportsHavBedDataCheckBox, "css").getOne()
					.click();
		}
		assertTrue(this.page.element(reportsHavBedDataCheckBox, "css").getOne()
				.isSelected());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify error Message stating 
	  * 			  "The 'State' is required for resources that report HAvBED data." 
	  * Date        : 17-Feb-2016
	  * Author      : Pallavi
	  **********************************************************************************/	
	public Resource verifyErrorMsgReportsHAvBEDDataSelectedWithoutSelectingState()
			throws Exception {
		objWaitForElement
				.waitForElements(
						"//span[@class='emsErrorTitle'][text()='The following error occurred on this page:']",
						"xpath");
		assertTrue(this.page
				.element(
						"//span[@class='emsErrorTitle'][text()='The following error occurred on this page:']",
						"xpath").getOne().isDisplayed());
		String strErrorMsg = "//div[@class='emsError']/ul/li[text()=\"The \'State\' is required for resources that report HAvBED data.\"]";
		assertTrue(this.page.element(strErrorMsg, "xpath").getOne()
				.isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Yes' under HavBed Column for a resource in the list.
	  * Date        : 17-Feb-2016
	  * Author      : Pallavi
	  **********************************************************************************/
	public Resource verifyYesUnderHavBedForResource(String strResource)
			throws Exception {
		String strElement = "//div[@id='mainContainer']/table[2]/tbody/tr/td[5][text()='"
				+ strResource + "']/preceding-sibling::td[2][text()='Yes']";
		objWaitForElement.waitForElements(strElement, "xpath");
		assertTrue(this.page.element(strElement, "xpath").isElementPresent(),
				"Yes under HavBed column corresponding to Resource is not present");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select Include Inactive Resources CheckBox.
	  * Date        : 19-Feb-2016
	  * Author      : Pallavi
	  **********************************************************************************/
	public Resource selectIncludeInactiveResourcesCheckBox() throws Exception {
		objWaitForElement.waitForElements(includeInactiveResources, "css");
		assertTrue(this.page.element(includeInactiveResources, "css").getOne()
				.isDisplayed(),
				"include Inactive Resources check box is not displayed");
		if (!this.page.element(includeInactiveResources, "css").getOne()
				.isSelected()) {
			this.page.element(includeInactiveResources, "css").getOne().click();
		}
		assertTrue(this.page.element(includeInactiveResources, "css").getOne()
				.isSelected());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify all the headers in resource list screen.
	  * Date        : 19-Feb-2016
	  * Author      : Pallavi
	  **********************************************************************************/
	public Resource verifyHeadersInResourceListScreen(
			String[] strHeadersOfResources) throws Exception {
		for (int intCount = 0; intCount < strHeadersOfResources.length; intCount++) {
			if (intCount == 0 || intCount == 1) {
				objWaitForElement.waitForElements(
						"//div[@id='mainContainer']/table/thead/tr/th[text()='"
								+ strHeadersOfResources[intCount] + "']",
						"xpath");
				assertTrue(
						this.page
								.element(
										"//div[@id='mainContainer']/table/thead/tr/th[text()='"
												+ strHeadersOfResources[intCount]
												+ "']", "xpath").getOne()
								.isDisplayed(), strHeadersOfResources[intCount]
								+ "header is not displayed");
			} else if (intCount == 7) {
				String[] strRT = strHeadersOfResources[intCount].split(" ");
				assertTrue(
						this.page
								.element(
										"//div[@id='mainContainer']/table/thead/tr/th/a[contains(text(),'"
												+ strRT[0] + "')]", "xpath")
								.getOne().isDisplayed()
								&& this.page
										.element(
												"//div[@id='mainContainer']/table/thead/tr/th/a[contains(text(),'"
														+ strRT[1] + "')]",
												"xpath").getOne().isDisplayed(),
						strHeadersOfResources[intCount]
								+ "header is not displayed");
			} else {
				objWaitForElement.waitForElements(
						"//div[@id='mainContainer']/table/thead/tr/th/a[text()='"
								+ strHeadersOfResources[intCount] + "']",
						"xpath");
				assertTrue(
						this.page
								.element(
										"//div[@id='mainContainer']/table/thead/tr/th/a[text()='"
												+ strHeadersOfResources[intCount]
												+ "']", "xpath").getOne()
								.isDisplayed(), strHeadersOfResources[intCount]
								+ "header is not displayed");
			}

		}
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to de-select Include Inactive Resources CheckBox.
	  * Date        : 19-Feb-2016
	  * Author      : Pallavi
	  **********************************************************************************/
	public Resource deSelectIncludeInactiveResourcesCheckBox() throws Exception {
		objWaitForElement.waitForElements(includeInactiveResources, "css");
		assertTrue(this.page.element(includeInactiveResources, "css").getOne()
				.isDisplayed(),
				"include Inactive Resources check box is not displayed");
		if (this.page.element(includeInactiveResources, "css").getOne()
				.isSelected()) {
			this.page.element(includeInactiveResources, "css").getOne().click();
		}
		assertFalse(this.page.element(includeInactiveResources, "css").getOne()
				.isSelected());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to get Latitude value with decimal value
	 * Date        : 25/June/2015
	 * Author      : Sangappa.k
	 **********************************************************************************/
	public Resource verLongitudeAndLattudeInEditResPage(String Long, String Latt)
			throws Exception {
		objWaitForElement.waitForElements(latitude, "css");
		try {
			assertEquals(this.page.element(latitude, "css").getOne()
					.getAttribute("value"), Latt);
			assertEquals(this.page.element(longitude, "css").getOne()
					.getAttribute("value"), Long);
		} catch (AssertionFailedException e) {
			System.out.println(e);
		}
		return this;
	}
	
	/**********************************************************************
	  * Description : This function is to select 'View Resource'
	  * Date        : 29/10/2014
	  * Author      : Sowmya
	  **********************************************************************/	
	public Resource selectAllViewResourceOption() throws Exception {
		objWaitForElement.waitForElements(viewResourceAll, "xpath");
		if (this.page.element(viewResourceAll, "xpath").getOne().isSelected() == false) {
			this.page.element(viewResourceAll, "xpath").getOne().click();
		}
		return this;
	}
}