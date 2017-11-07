package lib.page;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import qaframework.lib.WaitTimeConstants;
import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;

public class EventSetUp extends PageObject {
	WebDriver driver;
	WaitForElement objWaitForElement;

	public EventSetUp(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
	}
	
	//Locators
		private String eventLink = "//a[@href='/EMSystem?uc=GENERAL&nextStep=menuItemList&nextStepDetail=EVENT'][text()='Event']";
		private String eventSetUp = "//td/a[text()='Event Setup']";
		private String createEventTemplate = "input[value='Create New Event Template']",
				templateName = "eventTypeName",
				templateDescription = "definition",
				eventNotPrefSave = "input[value='Save']",
				webMailSelectAll = "//table[@id='tbl_emailInd']/thead/tr/th[contains(text(),'Web')]/input[@name='SELECT_ALL']",
				emailSelectAll = "//table[@id='tbl_emailInd']/thead/tr/th[contains(text(),'Email')]/input[@name='SELECT_ALL']",
				pagerSelectAll = "//table[@id='tbl_emailInd']/thead/tr/th[contains(text(),'Pager')]/input[@name='SELECT_ALL']",
				ResSelectAll = "//table[@id='tbl_emailInd']/thead/tr/th[contains(text(),'Res?')]/input[@name='SELECT_ALL']",
				multiRegion = "input[name='multiRegion']",
				security = "secured",
				header = "div#topSubNav > h1",
				mandatoryAddChkBox = "input[name='addressRequired']",
				resType="select[name='st_filterResourceTypeID']",
				section="select[name='st_filterSection']",
				stdStatusType="select[name='st_filterStandardStatusType']",
				statusTypeName="input[name='st_filterText']",
				searchBtn="input[class='searchButton']",
				showAllBtn="input[class='showAllButton']",
				eventmanagement="//td/a[text()='Event Management']",
				activeChkBox = "input[name='active']",
				inactiveEventTypes="inactive_et",
				ETColor = "color",
				ETIcon = "eventIcon",
				cancelButton = "input[value='Cancel']",
				stdEventTypeID="standardEventTypeID",
				imageOfAssociatedIcon = "//select[@id='eventIcon']/following-sibling::img",
				defaultEventName = "input[name='defaultTitle']",
				defaultEventDefinition = "//td[text()='Default Event Information:']/following-sibling::td/textarea";
	
/**********************************************************************
  * Description : This function is to navigate To EventSetUp Page
  * Date        : 09/06/2014
  * Author      : Anitha
  **********************************************************************/	
	
	public EventManagement navigateToEventSetUp() throws Exception {
		objWaitForElement.waitForElements(eventLink, "xpath");
		this.page.element(eventLink, "xpath").getOne().click();
		objWaitForElement.waitForElements(eventSetUp, "xpath");
		this.page.element(eventSetUp, "xpath").getOne().click();
		return new EventManagement(this.driver);
	}
 /**********************************************************************
  * Description : This function is to verify template Name
  * Date        : 09/06/2014
  * Author      : Anitha
  **********************************************************************/	

	public EventSetUp verifyEventTempName(String strAdHocEventTempName)
			throws Exception {
		objWaitForElement.waitForElements("//table/tbody/tr/td[3][text()='"
				+ strAdHocEventTempName + "']", "xpath");
		assertTrue(this.page
				.dynamicElement(
						"AdHocEventTempName",
						"//table/tbody/tr/td[3][text()='"
								+ strAdHocEventTempName + "']", "xpath")
				.getOne().isDisplayed());
		return this;
	}

	 /**********************************************************************
	  * Description : This function is to verify template Edit link
	  * Date        : 09/06/2014
	  * Author      : Anitha
	  **********************************************************************/	

	public EventSetUp verifyEditTempLinkIsDisplayed(
			String strAdHocEventTempName) throws Exception {
		objWaitForElement.waitForElements("//table/tbody/tr/td[3][text()='" + strAdHocEventTempName
				+ "']/preceding-sibling::td[2]/a[text()='Edit']", "xpath");
		assertTrue(this.page.dynamicElement(
				"AdHocEventTempName",
				"//table/tbody/tr/td[3][text()='" + strAdHocEventTempName
						+ "']/preceding-sibling::td[2]/a[text()='Edit']",
				"xpath").getOne().isDisplayed());
		return this;
	}
	 /**********************************************************************
	  * Description : This function is to verify template Notification link
	  * Date        : 09/06/2014
	  * Author      : Anitha
	  **********************************************************************/	

	public EventSetUp verifyNotificationTempLinkIsDisplayed(
			String strAdHocEventTempName) throws Exception {
		objWaitForElement.waitForElements("//table/tbody/tr/td[3][text()='"
				+ strAdHocEventTempName
				+ "']/preceding-sibling::td[2]/a[text()='Notifications']", "xpath");
		assertTrue(this.page
				.dynamicElement(
						"AdHocEventTempName",
						"//table/tbody/tr/td[3][text()='"
								+ strAdHocEventTempName
								+ "']/preceding-sibling::td[2]/a[text()='Notifications']",
						"xpath").isElementPresent());
		return this;
	}

	 /**********************************************************************
	  * Description : This function is to verify template Security link
	  * Date        : 09/06/2014
	  * Author      : Anitha
	  **********************************************************************/	

	public EventSetUp verifySecurityLinkForTempIsNotDisplayed(
			String strAdHocEventTempName) throws Exception {
		assertFalse(this.page.dynamicElement(
				"AdHocEventTempName",
				"//table/tbody/tr/td[3][text()='" + strAdHocEventTempName
						+ "']/preceding-sibling::td[2]/a[text()='Security']",
				"xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	 /**********************************************************************
	  * Description : This function is to click on 'Create Event Template' button
	  * Date        : 28/07/2014
	  * Author      : Anil
	  **********************************************************************/	

	public EventSetUp clickOncreateEventTemplate() throws Exception {
		objWaitForElement.waitForElements(createEventTemplate, "css");
		this.page.element(createEventTemplate, "css").getOne().click();
		return this;
	}
	
	 /**********************************************************************
	  * Description : This function is to enter event template name
	  * Date        : 28/07/2014
	  * Author      : Anil
	  **********************************************************************/	
	public EventSetUp enterEventTemplateName(String strTemplateName) throws Exception {
		objWaitForElement.waitForElements(templateName, "name");
		this.page.element(templateName, "name").clearInputValue().sendKeys(strTemplateName);
		return this;
	}
	
	 /**********************************************************************
	  * Description : This function is to enter event template definition
	  * Date        : 28/07/2014
	  * Author      : Anil
	  **********************************************************************/	
	public EventSetUp enterEventTemplateDefintion(String strDefinition) throws Exception {
		objWaitForElement.waitForElements(templateDescription, "name");
		this.page.element(templateDescription, "name").clearInputValue().sendKeys(strDefinition);
		return this;
	}
	
	 /**********************************************************************
	  * Description : This function is to select resource type
	  * Date        : 28/07/2014
	  * Author      : Anil
	  **********************************************************************/	

	public EventSetUp selectResourceType(String strResourceTypeValue) throws Exception {
		objWaitForElement.waitForElements("input[name='rt'][value='"+strResourceTypeValue+"']", "css");
		this.page.dynamicElement("Resourcetype","input[name='rt'][value='"+strResourceTypeValue+"']", "css").getOne().click();
		return this;
	}
	
	 /**********************************************************************
	  * Description : This function is to select status type
	  * Date        : 28/07/2014
	  * Author      : Anil
	  **********************************************************************/	

	public EventSetUp selectStatusType(String strStatusTypeValue) throws Exception {
		objWaitForElement.waitForElements("input[value='" + strStatusTypeValue
				+ "'][name='st']", "css");
		this.page.dynamicElement("statusTypes","input[value='" + strStatusTypeValue
				+ "'][name='st']", "css").getOne().click();
		return this;
	}
	
	 /**********************************************************************
	  * Description : This function is to click on 'Event Notify Preferences' button
	  * Date        : 28/07/2014
	  * Author      : Anil
	  **********************************************************************/	

	public EventSetUp clickSaveButton() throws Exception {
		objWaitForElement.waitForElements(eventNotPrefSave, "css");
		this.page.element(eventNotPrefSave, "css").getOne().click();
		return this;
	}
	
	 /**********************************************************************
	  * Description : This function is to create event template
	  * Date        : 08/07/2014
	  * Author      : Anil
	  **********************************************************************/	
	public EventSetUp createEventTemplate(String strEventTemplate, String strTemplateDefinition, String[] strResourceTypeValue, String[] strStatusTypeValue) throws Exception {			
		this.clickOncreateEventTemplate();
		this.enterEventTemplateName(strEventTemplate);
		this.enterEventTemplateDefintion(strTemplateDefinition);
		
		for(int intCount=0; intCount<strResourceTypeValue.length;intCount++){
			this.selectResourceType(strResourceTypeValue[intCount]);
		}
		
		for(int intCount=0; intCount<strStatusTypeValue.length;intCount++){
			this.selectStatusType(strStatusTypeValue[intCount]);
		}
		
		this.clickSaveButton();
		return this;
	}
	
	 /**********************************************************************
	  * Description : This function is to deselect web mail notifications
	  * Date        : 08/07/2014
	  * Author      : Anil
	  **********************************************************************/	
	public EventSetUp verAllcheckBoxes() throws Exception {
		objWaitForElement.waitForElements(webMailSelectAll, "xpath");
		assertTrue(this.page.element(webMailSelectAll, "xpath")
				.isElementPresent());
		assertTrue(this.page.element(emailSelectAll, "xpath")
				.isElementPresent());
		assertTrue(this.page.element(pagerSelectAll, "xpath")
				.isElementPresent());
		assertTrue(this.page.element(webMailSelectAll, "xpath").getOne()
				.isSelected());
		return this;
	}

	 /**********************************************************************
	  * Description : This function is to deselect web mail notifications
	  * Date        : 08/07/2014
	  * Author      : Anil
	  **********************************************************************/	
	public EventSetUp deselectSelectAllWebOption() throws Exception {
		objWaitForElement.waitForElements(webMailSelectAll, "xpath");
		if (this.page.element(webMailSelectAll, "xpath").getOne().isSelected() == false) {
			this.page.element(webMailSelectAll, "xpath").getOne().click();
		}
		this.page.element(webMailSelectAll, "xpath").getOne().click();
		this.clickSaveButton();
		return this;
	}

	/**********************************************************************
	  * Description : This function is to deselect Res notifications
	  * Date        : 08/07/2014
	  * Author      : Anil
	  **********************************************************************/	
	public EventSetUp deselectSelectAllEmailOption() throws Exception {			
		objWaitForElement.waitForElements(emailSelectAll, "xpath");
		if(this.page.element(emailSelectAll,"xpath").getOne().isSelected()==false){
			this.page.element(emailSelectAll, "xpath").getOne().click();
			
		}
		this.page.element(emailSelectAll, "xpath").getOne().click();
		return this;
	}
	 /**********************************************************************
	  * Description : This function is to deselect Email notifications
	  * Date        : 08/07/2014
	  * Author      : Anil
	  **********************************************************************/	
	public EventSetUp deselectSelectAllPagerOption() throws Exception {
		objWaitForElement.waitForElements(pagerSelectAll, "xpath");
		if (this.page.element(pagerSelectAll, "xpath").getOne().isSelected() == false) {
			this.page.element(pagerSelectAll, "xpath").getOne().click();			
		}
		this.page.element(pagerSelectAll, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************
	  * Description : This function is to deselect pager notifications
	  * Date        : 08/07/2014
	  * Author      : Anil
	  **********************************************************************/	
	public EventSetUp deselectSelectAllResOption() throws Exception {
		objWaitForElement.waitForElements(ResSelectAll, "xpath");
		if (this.page.element(ResSelectAll, "xpath").getOne().isSelected() == false) {
			this.page.element(ResSelectAll, "xpath").getOne().click();		
		}
		this.page.element(ResSelectAll, "xpath").getOne().click();
		return this;
	}

	/*******************************************************************************
	  * Description : This function is to navigate to Event Notification Preferences
	  * Date        : 07/28/2014
	  * Author      : Anitha
	  *******************************************************************************/	
	
	public EventSetUp navigateToEventNotificationPreferences(
			String strEventTempName) throws Exception {

		WebElement element = driver.findElement(By.xpath("//table/tbody/tr/td[3][text()='"
				+ strEventTempName
				+ "']/preceding-sibling::td[2]/a[text()='Notifications']"));
		this.page
		.element("//table/tbody/tr/td[3][text()='"
				+ strEventTempName
				+ "']/preceding-sibling::td[2]/a[text()='Notifications']",
		"xpath").scrollDownTillElement(element);
		objWaitForElement.waitForElements("//table/tbody/tr/td[3][text()='"
				+ strEventTempName
				+ "']/preceding-sibling::td[2]/a[text()='Notifications']", "xpath");
		this.page
		.dynamicElement(
				"EventTempName",
				"//table/tbody/tr/td[3][text()='"
						+ strEventTempName
						+ "']/preceding-sibling::td[2]/a[text()='Notifications']",
				"xpath").mouseOver();
		this.page
				.dynamicElement(
						"EventTempName",
						"//table/tbody/tr/td[3][text()='"
								+ strEventTempName
								+ "']/preceding-sibling::td[2]/a[text()='Notifications']",
						"xpath").getOne().click();
		Thread.sleep(5000);
		return this;
	}
	
	/*******************************************************************************
	  * Description : This function is to navigate to Event Notification Preferences
	  * Date        : 07/28/2014
	  * Author      : Anitha
	  *******************************************************************************/	

	public EventSetUp clickOnEmailNotification(String strFullUserName,
			boolean blnEmail) throws Exception {
		WebElement element = driver.findElement(By
				.xpath("//table[@id='tbl_emailInd']/tbody/tr/td[text()='"
						+ strFullUserName
						+ "']/parent::tr/td/input[@name='emailInd']"));
		this.page.element(
				"//table[@id='tbl_emailInd']/tbody/tr/td[text()='"
						+ strFullUserName
						+ "']/parent::tr/td/input[@name='emailInd']", "xpath")
				.scrollDownTillElement(element);
		objWaitForElement.waitForElements(
				"//table[@id='tbl_emailInd']/tbody/tr/td[text()='"
						+ strFullUserName
						+ "']/parent::tr/td/input[@name='emailInd']", "xpath");
		if (blnEmail) {
			if (this.page
					.dynamicElement(
							"EventTempNameEmail",
							"//table[@id='tbl_emailInd']/tbody/tr/td[text()='"
						+ strFullUserName
						+ "']/parent::tr/td/input[@name='emailInd']",
							"xpath").getOne().isSelected() == false) {
				this.page
						.dynamicElement(
								"EventTempNameEmail",
								"//table[@id='tbl_emailInd']/tbody/tr/td[text()='"
						+ strFullUserName
						+ "']/parent::tr/td/input[@name='emailInd']",
								"xpath").getOne().click();
			}
		} else {
			if (this.page
					.dynamicElement(
							"EventTempNameEmail",
							"//table[@id='tbl_emailInd']/tbody/tr/td[text()='"
						+ strFullUserName
						+ "']/parent::tr/td/input[@name='emailInd']",
							"xpath").getOne().isSelected()) {
				this.page
						.dynamicElement(
								"EventTempNameEmail",
								"//table[@id='tbl_emailInd']/tbody/tr/td[text()='"
						+ strFullUserName
						+ "']/parent::tr/td/input[@name='emailInd']",
								"xpath").getOne().click();
			}
		}
		return this;
	}
	/*******************************************************************************
	  * Description : This function is to navigate to Event Notification Preferences
	  * Date        : 07/28/2014
	  * Author      : Anitha
	  *******************************************************************************/	

	public EventSetUp clickOnResNotification(String strFullUserName,
			boolean blnEmail) throws Exception {
		objWaitForElement.waitForElements(
				"//table[@id='tbl_emailInd']/tbody/tr/td[text()='"
						+ strFullUserName
						+ "']/parent::tr/td/input[@name='resInd']", "xpath");
		if (blnEmail) {
			if (this.page
					.dynamicElement(
							"EventTempNameEmail",
							"//table[@id='tbl_emailInd']/tbody/tr/td[text()='"
									+ strFullUserName
									+ "']/parent::tr/td/input[@name='resInd']",
							"xpath").getOne().isSelected() == false) {
				this.page
						.dynamicElement(
								"EventTempNameEmail",
								"//table[@id='tbl_emailInd']/tbody/tr/td[text()='"
										+ strFullUserName
										+ "']/parent::tr/td/input[@name='resInd']",
								"xpath").getOne().click();
			}
		} else {
			if (this.page
					.dynamicElement(
							"EventTempNameEmail",
							"//table[@id='tbl_emailInd']/tbody/tr/td[text()='"
									+ strFullUserName
									+ "']/parent::tr/td/input[@name='resInd']",
							"xpath").getOne().isSelected()) {
				this.page
						.dynamicElement(
								"EventTempNameEmail",
								"//table[@id='tbl_emailInd']/tbody/tr/td[text()='"
										+ strFullUserName
										+ "']/parent::tr/td/input[@name='resInd']",
								"xpath").getOne().click();
			}
		}
		return this;
	}

	/*******************************************************************************
	  * Description : This function is to select pager notification
	  * Date        : 07/28/2014
	  * Author      : Anitha
	  *******************************************************************************/	

	public EventSetUp clickOnPagerNotification(String strFullUserName,
			boolean blnPager) throws Exception {
		objWaitForElement.waitForElements(
				"//table[@id='tbl_emailInd']/tbody/tr/td[text()='"
						+ strFullUserName
						+ "']/parent::tr/td/input[@name='pagerInd']", "xpath");
		if (blnPager) {
			if (this.page
					.dynamicElement(
							"EventTempNameEmail",
							"//table[@id='tbl_emailInd']/tbody/tr/td[text()='"
									+ strFullUserName
									+ "']/parent::tr/td/input[@name='pagerInd']",
							"xpath").getOne().isSelected() == false) {
				this.page
						.dynamicElement(
								"EventTempNameEmail",
								"//table[@id='tbl_emailInd']/tbody/tr/td[text()='"
										+ strFullUserName
										+ "']/parent::tr/td/input[@name='pagerInd']",
								"xpath").getOne().click();
			}
		} else {
			if (this.page
					.dynamicElement(
							"EventTempNameEmail",
							"//table[@id='tbl_emailInd']/tbody/tr/td[text()='"
									+ strFullUserName
									+ "']/parent::tr/td/input[@name='pagerInd']",
							"xpath").getOne().isSelected()) {
				this.page
						.dynamicElement(
								"EventTempNameEmail",
								"//table[@id='tbl_emailInd']/tbody/tr/td[text()='"
										+ strFullUserName
										+ "']/parent::tr/td/input[@name='pagerInd']",
								"xpath").getOne().click();
			}
		}
		return this;
	}

	/*******************************************************************************
	  * Description : This function is to select web notification
	  * Date        : 07/28/2014
	  * Author      : Anitha
	  *******************************************************************************/	

	public EventSetUp clickOnWebNotification(String strFullUserName,
			boolean blnWeb) throws Exception {
		objWaitForElement.waitForElements(
				"//table[@id='tbl_emailInd']/tbody/tr/td[text()='"
						+ strFullUserName
						+ "']/parent::tr/td/input[@name='webInd']", "xpath");
		if (blnWeb) {
			if (this.page
					.dynamicElement(
							"EventTempNameEmail",
							"//table[@id='tbl_emailInd']/tbody/tr/td[text()='"
									+ strFullUserName
									+ "']/parent::tr/td/input[@name='webInd']",
							"xpath").getOne().isSelected() == false) {
				this.page
						.dynamicElement(
								"EventTempNameEmail",
								"//table[@id='tbl_emailInd']/tbody/tr/td[text()='"
										+ strFullUserName
										+ "']/parent::tr/td/input[@name='webInd']",
								"xpath").getOne().click();
			}
		} else {
			if (this.page
					.dynamicElement(
							"EventTempNameEmail",
							"//table[@id='tbl_emailInd']/tbody/tr/td[text()='"
									+ strFullUserName
									+ "']/parent::tr/td/input[@name='webInd']",
							"xpath").getOne().isSelected()) {
				this.page
						.dynamicElement(
								"EventTempNameEmail",
								"//table[@id='tbl_emailInd']/tbody/tr/td[text()='"
										+ strFullUserName
										+ "']/parent::tr/td/input[@name='webInd']",
								"xpath").getOne().click();
			}
		}
		return this;
	}
	
	/*******************************************************************************
	  * Description : This function is to select multi region option
	  * Date        : 08/28/2014
	  * Author      : Anil
	  *******************************************************************************/	
	
	public EventSetUp selectMultiRegionOption() throws Exception {
		objWaitForElement.waitForElements(multiRegion, "css");
		this.page.element(multiRegion, "css").getOne().click();			
		return this;
	}
	
	 /**********************************************************************
	  * Description : This function is to create event template
	  * Date        : 08/07/2014
	  * Author      : Anil
	  **********************************************************************/	
	public EventSetUp createEventTemplateWithMultiRegion(String strEventTemplate, String strTemplateDefinition, String[] strResourceTypeValue, String[] strStatusTypeValue) throws Exception {			
		this.clickOncreateEventTemplate();
		this.enterEventTemplateName(strEventTemplate);
		this.enterEventTemplateDefintion(strTemplateDefinition);
		
		for(int intCount=0; intCount<strResourceTypeValue.length;intCount++){
			this.selectResourceType(strResourceTypeValue[intCount]);
		}
		
		for(int intCount=0; intCount<strStatusTypeValue.length;intCount++){
			this.selectStatusType(strStatusTypeValue[intCount]);
		}
		this.selectMultiRegionOption();
		this.clickSaveButton();
		return this;
	}
	
	/*******************************************************************************
	 * Description : This function is to select security option
	 * Date        : 13/08/2014
	 * Author      : Renushree
	*******************************************************************************/	
	public EventSetUp selectSecurityOption() throws Exception {
		objWaitForElement.waitForElements(security, "name");
		this.page.element(security, "name").getOne().click();			
		return this;
	}
	
	/*******************************************************************************
	 * Description : This function is to verify event template in list
	 * Arguments   : strEveTemplate
	 * Date        : 13/08/2014
	 * Author      : Renushree
	*******************************************************************************/	
	public EventSetUp verEveTemplateInList(String strEveTemplate)
			throws Exception {
		objWaitForElement.waitForElements(
				"//div[@id='mainContainer']/table[2]/tbody/tr/td[3][text()='"
						+ strEveTemplate + "']", "xpath");
		assertTrue(
				this.page.element(
						"//div[@id='mainContainer']/table[2]/tbody/tr/td[3][text()='"
								+ strEveTemplate + "']", "xpath")
						.isElementPresent(), "Event template not displayed");
		return this;
	}
	
	/*******************************************************************************
	 * Description : This function is to verify event template in list
	 * Arguments   : strEveTemplate
	 * Date        : 13/08/2014
	 * Author      : Renushree
	*******************************************************************************/	
	public EventSetUp verEveTemplateDescription(String strEveTemplate,String strEveTemplateDesc)
			throws Exception {
		objWaitForElement.waitForElements(
				"//div[@id='mainContainer']/table[2]/tbody/tr/td[3][text()='"
						+ strEveTemplate + "']", "xpath");
		assertTrue(
				this.page.element(
						"//div[@id='mainContainer']/table[2]/tbody/tr/td[3][text()='"
								+ strEveTemplate
								+ "']/following-sibling::td[text()='"
								+ strEveTemplateDesc + "']", "xpath")
						.isElementPresent(), "Event template not displayed");
		return this;
	}
	
	/*******************************************************************************
	 * Description : This function is to click on security of event template in list
	 * Arguments   : strEveTemplate
	 * Date        : 13/08/2014
	 * Author      : Renushree
	*******************************************************************************/	
	public EventSetUp clickOnSecurityOfEveTemplate(String strEveTemplate)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table[2]/tbody/tr/td[3][text()='"
				+ strEveTemplate + "']/preceding-sibling::td/a[text()='Security']", "xpath");
		this.page
				.element(
						"//div[@id='mainContainer']/table[2]/tbody/tr/td[3][text()='"
								+ strEveTemplate + "']/preceding-sibling::td/a[text()='Security']", "xpath").getOne()
				.click();
		assertTrue(
				this.page.element(
						"//div[@id='topSubNav']/h1[contains(text(),'Event Security for')]", "xpath")
						.isElementPresent());
		assertEquals("Event Security for "+strEveTemplate+"", this.page.element(header, "css").getOne().getText());
		return this;
	}
	
	/*******************************************************************************
	 * Description : This function is to verify username in event security page
	 * Arguments   : strUserName
	 * Date        : 13/08/2014
	 * Author      : Renushree
	*******************************************************************************/	
	public EventSetUp verUsersListedInEveSecurityPage(String strUserName)
			throws Exception {
		objWaitForElement.waitForElements("//table[@id='tbl_userID']/tbody/tr/td[3][text()='"
				+ strUserName + "']", "xpath");
		assertTrue(
				this.page.element(
						"//table[@id='tbl_userID']/tbody/tr/td[3][text()='"
								+ strUserName + "']", "xpath")
						.isElementPresent(), "Username is not displayed");
		return this;
	}
	/*******************************************************************************
	 * Description : This function is to verify username in event security page
	 * Arguments   : strUserName
	 * Date        : 13/08/2014
	 * Author      : Renushree
	*******************************************************************************/	
	public EventSetUp verUsersListedInEvePrefPage(String strUserName)
			throws Exception {
		objWaitForElement.waitForElements("//table[@id='tbl_emailInd']/tbody/tr/td[text()='"
				+ strUserName + "']", "xpath");
		assertTrue(
				this.page.element(
						"//table[@id='tbl_emailInd']/tbody/tr/td[text()='" + strUserName + "']",
						"xpath").isElementPresent(),
				"Username is not displayed");
		return this;
	}
	/*******************************************************************************
	 * Description : This function is to verify username in event security page
	 * Arguments   : strUserName
	 * Date        : 13/08/2014
	 * Author      : Renushree
	*******************************************************************************/	
	public EventSetUp verUsersNotListedInEveSecurityPage(String strUserName)
			throws Exception {
		assertFalse(
				this.page.element(
						"//table[@id='tbl_userID']/tbody/tr/td[3][text()='"
								+ strUserName + "']", "xpath")
						.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/*******************************************************************************
	 * Description : This function is to select username in event security page
	 * Arguments   : strUserName
	 * Date        : 13/08/2014
	 * Author      : Renushree
	*******************************************************************************/	
	public EventSetUp selectUserInEveSecutityPage(String strUserName)
			throws Exception {
		objWaitForElement.waitForElements("//input[@value='"+strUserName+"']", "xpath");
		this.page.element("//input[@value='"+strUserName+"']", "xpath").getOne().sendKeys(Keys.SPACE);
		return this;
	}
	
	/*******************************************************************************
	 * Description : This function is to verify event template list screen.
	 * Date        : 13/08/2014
	 * Author      : Renushree
	*******************************************************************************/	
	public EventSetUp verEveTemplateListScreenIsDisplayed() throws Exception {
		objWaitForElement.waitForElements(
				"//div[@id='topSubNav']/h1[text()='Event Template List']",
				"xpath");
		assertEquals("Event Template List", this.page.element(header, "css")
				.getOne().getText());
		return this;
	}
	
	/*******************************************************************************
	 * Description : This function is to verify event template list screen.
	 * Date        : 13/08/2014
	 * Author      : Renushree
	*******************************************************************************/	
	public EventSetUp verCreateNewTemplateScreenIsDisplayed() throws Exception {
		objWaitForElement.waitForElements(
				"//div[@id='topSubNav']/h1[text()='Create New Event Template']",
				"xpath");
		assertEquals("Create New Event Template", this.page.element(header, "css")
				.getOne().getText());
		return this;
	}
	
	/*******************************************************************************
	 * Description : This function is to verify event notification preference list screen.
	 * Date        : 18/08/2014
	 * Author      : Renushree
	*******************************************************************************/	
	public EventSetUp verEveNotPreferenceScreenIsDisplayed(String strEveTemplate)
			throws Exception {
		objWaitForElement.waitForElements(header, "css");
		assertEquals("Event Notification Preferences for " + strEveTemplate
				+ "", this.page.element(header, "css").getOne().getText());
		return this;
	}
	
	/*******************************************************************************
	 * Description : This function is to select mandatory address check box while creating event template.
	 * Date        : 02/09/2014
	 * Author      : Renushree
	*******************************************************************************/	
	public EventSetUp selMandatoryAddInCreateTemplatePage() throws Exception {
		objWaitForElement.waitForElements(mandatoryAddChkBox, "css");
		this.page.element(mandatoryAddChkBox, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************
	  * Description : This function is to click on template Edit link
	  * Date        : 03/09/2014
	  * Author      : Renushree
	**********************************************************************/	
	public EventSetUp clickOnEditTempLink(String strAdHocEventTempName)
			throws Exception {
		objWaitForElement.waitForElements("//table/tbody/tr/td[3][text()='"
				+ strAdHocEventTempName
				+ "']/preceding-sibling::td[2]/a[text()='Edit']",
		"xpath");
		this.page
				.dynamicElement(
						"AdHocEventTempName",
						"//table/tbody/tr/td[3][text()='"
								+ strAdHocEventTempName
								+ "']/preceding-sibling::td[2]/a[text()='Edit']",
						"xpath").getOne().sendKeys(Keys.ENTER);
		return this;
	}
	
	/*******************************************************************************
	 * Description : This function is to verify the fields
	 * Date        : 30-Dec-2013
	 * Author      : Deepa
	*******************************************************************************/	
	public EventSetUp verifyTheFields() throws Exception {
		objWaitForElement.waitForElements(resType, "css");
		assertTrue(this.page.element(resType, "css").getOne().isDisplayed());
		objWaitForElement.waitForElements(section, "css");
		assertTrue(this.page.element(section, "css").getOne().isDisplayed());
		objWaitForElement.waitForElements(stdStatusType, "css");
		assertTrue(this.page.element(stdStatusType, "css").getOne().isDisplayed());
		objWaitForElement.waitForElements(searchBtn, "css");
		assertTrue(this.page.element(searchBtn, "css").getOne().isDisplayed());
		objWaitForElement.waitForElements(showAllBtn, "css");
		assertTrue(this.page.element(showAllBtn, "css").getOne().isDisplayed());
		objWaitForElement.waitForElements(statusTypeName, "css");
		assertTrue(this.page.element(statusTypeName, "css").getOne().isDisplayed());
		return this;
	}
	
	/*******************************************************************************
	 * Description : This function is to search status type
	 * Date        : 30-Dec-2013
	 * Author      : Deepa
	*******************************************************************************/	
	public EventSetUp searchStatusType(String strStatusType) throws Exception {
		objWaitForElement.waitForElements(statusTypeName, "css");
		this.page.element(statusTypeName, "css").getOne()
				.sendKeys(strStatusType);
		this.page.element(searchBtn, "css").getOne().click();
		return this;
	}

	/*******************************************************************************
	 * Description : This function is to navigate to event setup page
	 * Date        : 03-Feb-2013
	 * Author      : Deepa
	*******************************************************************************/
	public EventManagement navigateToEventSetUp2() throws Exception {
		objWaitForElement.waitForElements(eventLink, "xpath");
		this.page.element(eventLink, "xpath").getOne().click();
		objWaitForElement.waitForElements(eventmanagement, "xpath");
		this.page.element(eventmanagement, "xpath").getOne().click();
		return new EventManagement(this.driver);
	}
	
	 /**********************************************************************
	  * Description : This function is to deselect web mail notifications
	  * Date        : 08/07/2014
	  * Author      : Anil
	  **********************************************************************/	
	public EventSetUp deselectSelectAllWebOptionOnly() throws Exception {
		this.page.element(webMailSelectAll, "xpath").getOne().click();
		objWaitForElement.waitForElements(webMailSelectAll, "xpath");
		if (this.page.element(webMailSelectAll, "xpath").getOne().isSelected() == true) {
			this.page.element(webMailSelectAll, "xpath").getOne().click();
		}
		return this;
	}
	
	/*******************************************************************************
	 * Description : This function is to inactive event template
	 * Date        : 29-Apr-2015
	 * Author      : Renushree
	*******************************************************************************/	
	public EventSetUp inactiveEveTemplate() throws Exception {
		objWaitForElement.waitForElements(activeChkBox, "css");
		if (this.page.element(activeChkBox, "css").getOne().isSelected() == true) {
			this.page.element(activeChkBox, "css").getOne().click();
		}
		return this;
	}
	
	 /**********************************************************************
	  * Description : This function is to create inactive event template
	  * Date        : 29-Apr-2015
	  * Author      : Renushee
	  **********************************************************************/	
	public EventSetUp createInactiveEventTemplate(String strEventTemplate, String strTemplateDefinition, String[] strResourceTypeValue, String[] strStatusTypeValue) throws Exception {			
		this.clickOncreateEventTemplate();
		this.enterEventTemplateName(strEventTemplate);
		this.enterEventTemplateDefintion(strTemplateDefinition);
		
		for(int intCount=0; intCount<strResourceTypeValue.length;intCount++){
			this.selectResourceType(strResourceTypeValue[intCount]);
		}
		
		for(int intCount=0; intCount<strStatusTypeValue.length;intCount++){
			this.selectStatusType(strStatusTypeValue[intCount]);
		}
		this.inactiveEveTemplate();
		this.clickSaveButton();
		return this;
	}

	/*******************************************************************************
	 * Description : This function is to verify Status type name is displayed in Create
	 * 				 New Event Template
	 * Date        : 19-May-2015
	 * Author      : Pallavi
	*******************************************************************************/	
	public EventSetUp verifyStatusTypeIsDispInCreateNewEventTemp(
			String strStatusTypeName) throws Exception {
		objWaitForElement
				.waitForElements(
						"//div[@id='st']/div[@class='selectorData']/table/tbody/tr/td/a[contains(text(),'"
								+ strStatusTypeName + "')]", "xpath");
		assertTrue(this.page
				.element(
						"//div[@id='st']/div[@class='selectorData']/table/tbody/tr/td/a[contains(text(),'"
								+ strStatusTypeName + "')]", "xpath")
				.isElementPresent());
		return this;
	}
	/*******************************************************************************
	 * Description : This function is to verify event template in list
	 * Arguments   : strEveTemplate, strEveTemplateIcon
	 * Date        : 13/08/2014
	 * Author      : Anitha
	*******************************************************************************/	
	public EventSetUp verEveTemplateIcon(String strEveTemplate,String strEveTemplateIcon)
			throws Exception {
		objWaitForElement.waitForElements(
				"//div[@id='mainContainer']/table/tbody/tr/td[3][text()='"
						+ strEveTemplate + "']", "xpath");
		assertTrue(
				this.page.element(
						"//div[@id='mainContainer']/table/tbody/tr/td[3][text()='"
								+ strEveTemplate
								+ "']/preceding-sibling::td/img[@src='"+strEveTemplateIcon+"']", "xpath")
						.isElementPresent());
		return this;
	}
	/*******************************************************************************
	 * Description : This function is to verify event template in list
	 * Arguments   : strEveTemplate, strETStatus
	 * Date        : 13/08/2014
	 * Author      : Anitha
	*******************************************************************************/	

	public EventSetUp verEveTemplateIsActive(String strEveTemplate,String strETStatus)
			throws Exception {
		objWaitForElement.waitForElements(
				"//div[@id='mainContainer']/table/tbody/tr/td[3][text()='"
						+ strEveTemplate + "']", "xpath");
		assertTrue(
				this.page.element(
						"//div[@id='mainContainer']/table/tbody/tr/td[3][text()='"
								+ strEveTemplate
								+ "']/following-sibling::td[text()='"+strETStatus+"']", "xpath")
						.isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select the active check box
	 * Date        : 09/06/2014
	 * Author     : Anil
	 **********************************************************************************/		
	public EventSetUp selectInactiveEventTemplateCheckBox() throws Exception {
		objWaitForElement.waitForElements(inactiveEventTypes, "name");
		if (this.page.element(inactiveEventTypes, "name").getOne()
				.isSelected() == false) {
			this.page.element(inactiveEventTypes, "name").getOne().click();
		}
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to select the active check box
	 * Date        : 09/06/2014
	 * Author     : Anil
	 **********************************************************************************/		
	public EventSetUp deSelectInactiveEventTemplateCheckBox() throws Exception {
		objWaitForElement.waitForElements(inactiveEventTypes, "name");
		if (this.page.element(inactiveEventTypes, "name").getOne()
				.isSelected() == true) {
			this.page.element(inactiveEventTypes, "name").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select Event template colour
	  * Date        : 09/06/2014
	  * Author      : Anil
	  **********************************************************************************/
	public EventSetUp selectETColor(String strETColor) throws Exception {
		objWaitForElement.waitForElements(ETColor, "name");
		this.page.element(ETColor, "name").webElementToSelect().selectByVisibleText(strETColor);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select Event template icon
	  * Date        : 09/06/2014
	  * Author      : Anil
	  **********************************************************************************/
	public EventSetUp selectETIcon(String strETIcon) throws Exception {
		objWaitForElement.waitForElements(ETIcon, "id");
		this.page.element(ETIcon, "id").webElementToSelect().selectByVisibleText(strETIcon);
		return this;
	}
	/**********************************************************************************
	   * Description : This function is to click statustypes
	   * Date        : 11/06/2014
	   * Author      : Anil
	   **********************************************************************************/
	public EventSetUp clickOnEmailCheckBox(String struserName) throws Exception {
		objWaitForElement.waitForElements("//input[@value='" + struserName
				+ "'][@name='emailInd']", "xpath");
		this.page.element(
				"//input[@value='" + struserName + "'][@name='emailInd']",
				"xpath").mouseOver();
		this.page
				.element(
						"//input[@value='" + struserName
								+ "'][@name='emailInd']", "xpath").getOne()
				.sendKeys(Keys.SPACE);

		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to click statustypes
	   * Date        : 11/06/2014
	   * Author      : Anil
	   **********************************************************************************/
	public EventSetUp clickOnPagerCheckBox(String struserName) throws Exception {
		objWaitForElement.waitForElements("//input[@value='" + struserName
				+ "'][@name='pagerInd']", "xpath");
		this.page.element(
				"//input[@value='" + struserName + "'][@name='pagerInd']",
				"xpath").mouseOver();
		this.page
				.element(
						"//input[@value='" + struserName
								+ "'][@name='pagerInd']", "xpath").getOne()
				.sendKeys(Keys.SPACE);

		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to click statustypes
	   * Date        : 11/06/2014
	   * Author      : Anil
	   **********************************************************************************/
	public EventSetUp clickOnWebCheckBox(String struserName) throws Exception {
		objWaitForElement.waitForElements("//input[@value='" + struserName
				+ "'][@name='webInd']", "xpath");
		this.page.element(
				"//input[@value='" + struserName + "'][@name='webInd']",
				"xpath").mouseOver();
		this.page
				.element(
						"//input[@value='" + struserName
								+ "'][@name='webInd']", "xpath").getOne()
				.sendKeys(Keys.SPACE);

		return this;
	}
	
	/*******************************************************************************
	 * Description : This function is to inactive event template
	 * Date        : 29-Apr-2015
	 * Author      : Renushree
	*******************************************************************************/	
	public EventSetUp activateEveTemplate() throws Exception {
		objWaitForElement.waitForElements(activeChkBox, "css");
		if (this.page.element(activeChkBox, "css").getOne().isSelected() == false) {
			this.page.element(activeChkBox, "css").getOne().click();
		}
		return this;
	}
	/**********************************************************************
	  * Description : This function is to verify template Name
	  * Date        : 09/06/2014
	  * Author      : Anitha
	  **********************************************************************/	
	public EventSetUp verifyActionHeader()
			throws Exception {
		objWaitForElement
				.waitForElements(
						"//div[@id='mainContainer']/table/thead/tr/th/a[text()='Active']",
						"xpath");
		assertTrue(this.page
				.element(
						"//div[@id='mainContainer']/table/thead/tr/th/a[text()='Active']",
						"xpath").getOne().isDisplayed());
		return this;
	}
	
	/*******************************************************************************
	 * Description : This function is to verify event template not in list
	 * Arguments   : strEveTemplate
	 * Date        : 13/08/2014
	 * Author      : Renushree
	*******************************************************************************/	
	public EventSetUp verEveTemplateNotInList(String strEveTemplate)
			throws Exception {
		assertFalse(
				this.page.element(
						"//div[@id='mainContainer']/table[2]/tbody/tr/td[3][text()='"
								+ strEveTemplate + "']", "xpath")
						.isElementPresent(), "Event template is displayed");
		return this;
	}
	
	 /**********************************************************************
	  * Description : This function is to deselect resource type
	  * Date        : 28/07/2014
	  * Author      : Anil
	  **********************************************************************/	
	public EventSetUp deselectResourceType(String strResourceTypeValue) throws Exception {
		objWaitForElement.waitForElements("input[name='rt'][value='"+strResourceTypeValue+"']", "css");
		if(this.page.element("input[name='rt'][value='"+strResourceTypeValue+"']", "css").getOne().isSelected()==true){
			this.page.element("input[name='rt'][value='"+strResourceTypeValue+"']", "css").getOne().click();
		}
		return this;
	}
	
	 /**********************************************************************
	  * Description : This function is to deselect status type
	  * Date        : 28/07/2014
	  * Author      : Anil
	  **********************************************************************/	

	public EventSetUp deselectStatusType(String strStatusTypeValue) throws Exception {
		objWaitForElement.waitForElements("input[value='" + strStatusTypeValue
				+ "'][name='st']", "css");
		if(this.page.element("input[value='" + strStatusTypeValue
				+ "'][name='st']", "css").getOne().isSelected()==true){
		this.page.element("input[value='" + strStatusTypeValue
				+ "'][name='st']", "css").getOne().click();
		}
		return this;
	}
	 /**********************************************************************
	  * Description : This function is to deselect web mail notifications
	  * Date        : 14/07/2015
	  * Author      : Sangappa.k
	  **********************************************************************/	
	public EventSetUp deselectSelectAllWebOptionChkBox() throws Exception {
		objWaitForElement.waitForElements(webMailSelectAll, "xpath");
		if (this.page.element(webMailSelectAll, "xpath").getOne().isSelected() == true) {
			this.page.element(webMailSelectAll, "xpath").getOne().click();
		}
		return this;
	}	
	 /**********************************************************************
	  * Description : This function is to select resource type
	  * Date        : 28/07/2014
	  * Author      : Anitha
	  **********************************************************************/	

	public EventSetUp verifySubRTNotDisplayed(String strSubResourceTypeValue)
			throws Exception {
		assertFalse(this.page.element(
				"input[name='rt'][value='" + strSubResourceTypeValue + "']",
				"css").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/*******************************************************************************
	 * Description : This function is to select mandatory address check box while creating event template.
	 * Date        : 02/09/2014
	 * Author      : Anil
	*******************************************************************************/	
	public EventSetUp deselMandatoryAddInCreateTemplatePage() throws Exception {
		objWaitForElement.waitForElements(mandatoryAddChkBox, "css");
		if (this.page.element(mandatoryAddChkBox, "css").getOne().isSelected() == true) {
			this.page.element(mandatoryAddChkBox, "css").getOne().click();
		}
		return this;
	}
	
	/*******************************************************************************
	 * Description : This function is to select mandatory address check box while creating event template.
	 * Date        : 02/09/2014
	 * Author      : Anil
	*******************************************************************************/	
	public EventSetUp verifySelectedStatusTypeCount(String strCount) throws Exception {
		objWaitForElement.waitForElements("//div[@class='selectorTotalsChecked']/span[text()='"+strCount+"']", "xpath");
		assertTrue(this.page.element("//div[@class='selectorTotalsChecked']/span[text()='"+strCount+"']", "xpath").getOne().isDisplayed() == true);
		return this;
	}
	
	/*************************************************************************
	  * Description : This function is to verify template Notification link
	  * Date        : 09/06/2014
	  * Author      : Anitha
	  *************************************************************************/	
	public EventSetUp verifyNotificationTempLinkIsNotDisplayed(
			String strEventTempName) throws Exception {
		assertFalse(this.page
				.dynamicElement(
						"AdHocEventTempName",
						"//table/tbody/tr/td[3][text()='"
								+ strEventTempName
								+ "']/preceding-sibling::td[2]/a[text()='Notifications']",
						"xpath").isElementPresent(
						WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/*****************************************************************************************
	 * Description : This function is to Not verify event notification preference list screen.
	 * Date        : 18/08/2014
	 * Author      : Anitha
	*****************************************************************************************/	
	public EventSetUp verEveNotPrePageIsNotDisplayed(String strEveTemplate)
			throws Exception {
		assertFalse(this.page.element(
				"//div[@id='topSubNav']/h1[text()='Event Notification Preferences for "
						+ strEveTemplate + "']", "xpath").isElementPresent(
				WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	/**********************************************************************
	  * Description : This function is to click on 'Cancel' button
	  * Date        : 28/07/2014
	  * Author      : Anitha
	  **********************************************************************/	

	public EventSetUp clickCancelButton() throws Exception {
		objWaitForElement.waitForElements(cancelButton, "css");
		this.page.element(cancelButton, "css").getOne().click();
		return this;
	}
	/**********************************************************************
	  * Description : This function is to verify template Security link
	  * Date        : 09/06/2014
	  * Author      : Anitha
	  **********************************************************************/	
	public EventSetUp verifySecurityLinkForTempIsDisplayed(
			String strAdHocEventTempName) throws Exception {
		objWaitForElement.waitForElements("//table/tbody/tr/td[3][text()='"
				+ strAdHocEventTempName
				+ "']/preceding-sibling::td[2]/a[text()='Security']", "xpath");
		assertTrue(this.page.dynamicElement(
				"AdHocEventTempName",
				"//table/tbody/tr/td[3][text()='" + strAdHocEventTempName
						+ "']/preceding-sibling::td[2]/a[text()='Security']",
				"xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to select standard event Type
	   * Date        : 11/06/2014
	   * Author      : Anitha
	   **********************************************************************************/
	public EventSetUp selectStdEventType(String StrStandardEventTypeID)
			throws Exception {
		objWaitForElement.waitForElements(stdEventTypeID, "name");
		this.page.element(stdEventTypeID, "name").webElementToSelect()
				.selectByVisibleText(StrStandardEventTypeID);
		return this;
	}
	
	/*******************************************************************************
	 * Description : This function is to verify StrStandardEventTypeID template list
	 * Arguments   : strEveTemplate, StrStandardEventTypeID
	 * Date        : 13/08/2014
	 * Author      : Anitha
	*******************************************************************************/	
	public EventSetUp verStandardEventTypeID(String strEveTemplate,
			String StrStandardEventTypeID) throws Exception {
		objWaitForElement.waitForElements(
				"//div[@id='mainContainer']/table[2]/tbody/tr/td[3][text()='"
						+ strEveTemplate + "']", "xpath");
		assertTrue(
				this.page.element(
						"//div[@id='mainContainer']/table[2]/tbody/tr/td[3][text()='"
								+ strEveTemplate
								+ "']/following-sibling::td[text()='"
								+ StrStandardEventTypeID + "']", "xpath")
						.isElementPresent(), "Event template not displayed");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to get image associated with ET's 'Associated Icon'
	  * Date        : 23-Feb-2014
	  * Author      : Pallavi
	  **********************************************************************************/
	public String getImageOfAssociatedIcon(String strETIcon) throws Exception {
		objWaitForElement.waitForElements(ETIcon, "id");
		assertTrue(this.page.element(ETIcon, "id").webElementToSelect().getFirstSelectedOption().equals(strETIcon));
		String strImage = this.page.element(imageOfAssociatedIcon, "xpath").getOne().getAttribute("src");
		return strImage;
	}
	
	
	/*******************************************************************************
	 * Description : This function is to click on security of event template in list
	 * Arguments   : strEveTemplate
	 * Date        : 13/08/2014
	 * Author      : Sangappa K
	*******************************************************************************/	
	public EventSetUp clickOnSecurityOfEveTemp(String strEveTemplate)
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table[2]/tbody/tr/td[3][text()='"
				+ strEveTemplate + "']/preceding-sibling::td/a[text()='Security']", "xpath");
		this.page
				.element(
						"//div[@id='mainContainer']/table[2]/tbody/tr/td[3][text()='"
								+ strEveTemplate + "']/preceding-sibling::td/a[text()='Security']", "xpath").getOne()
				.sendKeys(Keys.ENTER);
		return this;
	

	}
	
	/*****************************************************************************************
	 * Description : This function is to verify resource only cheack box is not present
	 * Date        : 18/08/2014
	 * Author      : Sangappa K
	*****************************************************************************************/	
	public EventSetUp verResOnlyChkBoxNotPresent()
			throws Exception {
		assertFalse(this.page.element(
				"//input[@name='SELECT_ALL'][@value='resInd']", "xpath").isElementPresent(
				WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}	

	/**********************************************************************
	  * Description : This function is to click on Notifications link corresponding to ET.
	  * Date        : 29-Feb-2016
	  * Author      : Pallavi
	  **********************************************************************/	
	public EventSetUp clickOnNotificationsLinkOfET(String strETName)
			throws Exception {
		String strElemnt = "//td[text()='" + strETName
				+ "']/preceding-sibling::td/a[text()='Notifications']";
		objWaitForElement.waitForElements(strElemnt, "xpath");
		this.page.element(strElemnt, "xpath").getOne().click();
		return this;
	}
	
	 /**********************************************************************
	  * Description : This function is to enter default event name
	  * Date        : 11-Mar-2016
	  * Author      : Pallavi
	  **********************************************************************/	
	public EventSetUp enterDefaultEventName(String strDefaultEveName)
			throws Exception {
		objWaitForElement.waitForElements(defaultEventName, "css");
		this.page.element(defaultEventName, "css").clearInputValue()
				.sendKeys(strDefaultEveName);
		assertTrue(this.page.element(defaultEventName, "css").getOne()
				.getAttribute("value").equals(strDefaultEveName));
		return this;
	}
	
	 /**********************************************************************
	  * Description : This function is to enter default event name
	  * Date        : 11-Mar-2016
	  * Author      : Pallavi
	  **********************************************************************/	
	public EventSetUp enterDefaultEventDefinition(String strDefaultEveDefinition)
			throws Exception {
		objWaitForElement.waitForElements(defaultEventDefinition, "xpath");
		this.page.element(defaultEventDefinition, "xpath").clearInputValue()
				.sendKeys(strDefaultEveDefinition);
		assertTrue(this.page.element(defaultEventDefinition, "xpath").getOne()
				.getAttribute("value").equals(strDefaultEveDefinition));
		return this;
	}
}
