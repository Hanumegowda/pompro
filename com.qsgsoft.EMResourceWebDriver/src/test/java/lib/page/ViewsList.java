package lib.page;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import qaframework.lib.WaitTimeConstants;
import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;

public class ViewsList extends PageObject {
	
	WebDriver driver;
	WaitForElement objWaitForElement;
	WebDriverWait wait;

	//Locators
	private String setUpLink = "//a[@class='mainLink'][text()='Setup']",
				   setUpLink1 = "//a[@class='mainLink selected'][text()='Setup']",
				   viewsLink = "//td/a[text()='Views']",
				   createNewView = "//input[@value='Create New View']",
				   viewName = "//tr[@title='View Name']//input",
				   viewDesc = "//tr[@title='Description']//textarea",
				   viewLink = "//div[@id='topNav']/div/a[text()='View']",
				   saveOfCreateNewView = "//input[@value='Save']",
				   saveOfUpdate = "//input[@value='Save']",
				   customizeResourceDetailView = "input[value='Customize Resource Detail View']",
				   enterSectionName = "input[value='Enter New Section Name']",
				   createSection = "input[value='Create Section']",
				   saveButton = "input[value='Save']",
				   uncategorized = "#uncategorized>div>span",
				   createdStatuaTypesInList = "//div[@id='itemBox']/ul/li/div",
				   editSection = "editGroup",
				   editSectionNameField = "editGroupNewName",
				   sumbmitOfEditedName = "submitGroupEdit",
				   headerName = "div#topSubNav > h1",
				   save = "input[value='Save']",
				   viewNameInDelPge = "input[name='name']",
				   descriptionInDelPge = "textarea[name='description']",
				   confmDel = "//div[@id='mainContainer']/form/h1",
				   delete = "input[value='Delete']",
				   cancel = "input[value='Cancel']",//[ng-click='onCancelClick()']",
			       numberOfEDBedsOccupied = "//label[text()='Number of ED beds occupied']/preceding-sibling::input",
				   numberOfPatientsInLobby = "//label[text()='Number of patients in lobby']/preceding-sibling::input",
				   numberOfAmbulancePatientsEnRouteOrWaiting = "//label[text()='Number of ambulance patients en route or waiting']/preceding-sibling::input",
				   numberOfGeneralAdmits = "//label[text()='Number of general admits']/preceding-sibling::input",
			   	   numberOfICUAdmits = "//label[text()='Number of ICU admits']/preceding-sibling::input",
				   numberOfPatientsRequiringCare = "//label[text()='Number of patients requiring 1:1 care']/preceding-sibling::input",
				   numberOfRNsShortStaffed = "//label[text()='Number of RNs short-staffed']/preceding-sibling::input",
				   numberOfEDBedsAssigned = "//label[text()='Number of ED beds assigned']/preceding-sibling::input",
				   reasonableLobbyCapacity = "//label[text()='Reasonable lobby capacity']/preceding-sibling::input",
				   subResourceButton = "input[value='Sub-resources']",
				   sortAllButton = "input[value='Sort All']",
				   viewType = "viewType",
				   editResDetailLink = "//div[@id='resource_summary']/div/a[text()='edit']",
				   visibleToAll = "visibleToAll",
				   usersCheckBox = "input[name='SELECT_ALL'][value='userID']",
				   reOrderViews = "input[value='Re-order Views']", 
				   doneReOrdering = "input[value='Done Re-ordering']",
				   warningMessage1 = "//div[@id='saveWarning']/ul/li",
				   warningMessage2 = "//div[@id='saveWarning']/ul/li[2]",
				   ReturnToViewLink="Return to View",
				   nextButton = "//input[@value='Next']",
				   regionLink = "//*[@id='regionName']",
				   statusTypeTab = "//li/a[text()='Status Types']",
				   resourcesTab = "//li/a[text()='Resources']",
				   regionsTab = "//li/a[text()='Resources']",
				   searchRes="//input[@placeholder='Resource Name']",
				   search="//input[@value='Search']",
				   resourceTable="//table[@id='grid']/tbody",
				   usersTab = "//li/a[text()='Users']",
				   securityChkBoxInUserTab = "//input[@ng-model='ctrl.form.allUserAccess']",
				   searchUser="input[placeholder='Field Value']";
	             
				   
					

	public ViewsList(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement =  new WaitForElement(this.driver);
		wait = new WebDriverWait(this.driver, WaitTimeConstants.WAIT_TIME_LONG);
	}

	/**********************************************************************************
	  * Description : This function is to navigate to 'Views'
	  * Date        : 20/06/2014
	  * Author      : Yugender
	  **********************************************************************************/
	public ViewsList clickOnSetUp() throws Exception {
		objWaitForElement.waitForElements(setUpLink, "xpath");
		this.page.element(setUpLink, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to navigate to 'Views'
	  * Date        : 20/06/2014
	  * Author      : Yugender
	  **********************************************************************************/
	public ViewsList clickOnSetUp1() throws Exception {
		objWaitForElement.waitForElements(setUpLink1, "xpath");
		this.page.element(setUpLink1, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to navigate to 'Views'
	  * Date        : 20/06/2014
	  * Author      : Yugender
	  **********************************************************************************/
	public ViewsList navigateToStatusTypeList() throws Exception {
		this.clickOnSetUp();
		objWaitForElement.waitForElements(viewsLink, "xpath");
		this.page.element(viewsLink, "xpath").getOne().click();
		return new ViewsList(this.driver);
	}
	
	/**********************************************************************************
	  * Description : This function is to navigate to 'Views'
	  * Date        : 20/06/2014
	  * Author      : Yugender
	  **********************************************************************************/
	public ViewsList navigateToViewsList() throws Exception {
		this.clickOnSetUp1();
		objWaitForElement.waitForElements(viewsLink, "xpath");
		this.page.element(viewsLink, "xpath").getOne().click();
		return new ViewsList(this.driver);
	}
	
	/**********************************************************************************
	  * Description : This function is to click on create new View button
	  * Date        : 20/06/2014
	  * Author      : Yugender
	  **********************************************************************************/
	public ViewsList clickCreateNewViewButton() throws Exception {
		objWaitForElement.waitForElements(createNewView, "xpath");		
		this.page.element(createNewView, "xpath").getOne().click();
		try {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='TB_load']/img[@src='/img/loadingAnimation.gif']")));
		} catch(Exception e) {
			
		}
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter View Name
	  * Date        : 20/06/2014
	  * Author      : Yugender
	  **********************************************************************************/
	public ViewsList enterViewName(String strViewName) throws Exception {
		objWaitForElement.waitForElements(viewName, "xpath");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(viewName))));
		this.page.element(viewName, "xpath").getOne().clear();
		this.page.element(viewName, "xpath").getOne().sendKeys(strViewName);
		this.page.element(viewName, "xpath").getOne().clear();
		this.page.element(viewName, "xpath").getOne().sendKeys(strViewName);
		Thread.sleep(2000);
		System.out.println(strViewName);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter View Name
	  * Date        : 20/06/2014
	  * Author      : Yugender
	  **********************************************************************************/
	public ViewsList enterViewDesc(String strViewDesc) throws Exception {
		objWaitForElement.waitForElements(viewDesc, "xpath");
		this.page.element(viewDesc, "xpath").getOne().clear();
		this.page.element(viewDesc, "xpath").getOne().sendKeys(strViewDesc);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select status type
	  * Date        : 20/06/2014
	  * Author      : Yugender
	  **********************************************************************************/
	public ViewsList selectStatusType(String strStatusTypes) throws Exception {
		Thread.sleep(2000);
		objWaitForElement.waitForElements("//td//a[text()='"+strStatusTypes+"']/ancestor::td/preceding-sibling::td[1]/input",
		"xpath");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='TB_load']/img[@src='/img/loadingAnimation.gif']")));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//td//a[text()='"+strStatusTypes+"']/ancestor::td/preceding-sibling::td[1]/input"))));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//td//a[text()='"+strStatusTypes+"']/ancestor::td/preceding-sibling::td[1]/input"))));
		if(this.page.element("//td//a[text()='"+strStatusTypes+"']/ancestor::td/preceding-sibling::td[1]/input",
				"xpath").getOne().isSelected()==false){
			this.page.element("//td//a[text()='"+strStatusTypes+"']/ancestor::td/preceding-sibling::td[1]/input",
					"xpath").getOne().sendKeys(Keys.SPACE);	
		}
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select resource
	  * Date        : 20/06/2014
	  * Author      : Yugender
	  **********************************************************************************/
	public ViewsList selectResource(String strResource) throws Exception {
		/*boolean blnChk = false; int i = 0;
		objWaitForElement.waitForElements("//table[@id='grid']/tbody/tr/td[2]/span[text()='"+strResource+"']/parent::td/preceding-sibling::td[1]/input", "xpath");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='TB_load']/img[@src='/img/loadingAnimation.gif']")));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//table[@id='grid']/tbody/tr/td[2]/span[text()='"+strResource+"']/parent::td/preceding-sibling::td[1]/input"))));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//table[@id='grid']/tbody/tr/td[2]/span[text()='"+strResource+"']/parent::td/preceding-sibling::td[1]/input"))));
		Thread.sleep(2000);
		if(this.page.element("//table[@id='grid']/tbody/tr/td[2]/span[text()='"+strResource+"']/parent::td/preceding-sibling::td[1]/input", "xpath")
				.getOne().isSelected()==false){
			while(!blnChk && i<10) {
				this.page.element("//table[@id='grid']/tbody/tr/td[2]/span[text()='"+strResource+"']/parent::td/preceding-sibling::td[1]/input", "xpath").getOne().sendKeys(Keys.SPACE);
				Thread.sleep(1000);
				blnChk = this.page
						.element("//table[@id='grid']/tbody/tr/td[2]/span[text()='"+strResource+"']/parent::td/preceding-sibling::td[1]/input", "xpath")
						.getOne().isSelected();
			}
		
		}
		assertTrue(this.page
				.element("//table[@id='grid']/tbody/tr/td[2]/span[text()='"+strResource+"']/parent::td/preceding-sibling::td[1]/input", "xpath")
				.getOne().isSelected());
		return this;*/
		 boolean blnChk = false; int i = 0;
		  objWaitForElement.waitForElements("//table[@id='grid']/tbody/tr/td[2]/span[text()='"+strResource+"']/parent::td/preceding-sibling::td[1]/input", "xpath");
		  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='TB_load']/img[@src='/img/loadingAnimation.gif']")));
		  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//table[@id='grid']/tbody/tr/td[2]/span[text()='"+strResource+"']/parent::td/preceding-sibling::td[1]/input"))));
		  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//table[@id='grid']/tbody/tr/td[2]/span[text()='"+strResource+"']/parent::td/preceding-sibling::td[1]/input"))));
		  if(this.page.element("//table[@id='grid']/tbody/tr/td[2]/span[text()='"+strResource+"']/parent::td/preceding-sibling::td[1]/input", "xpath")
		    .getOne().isSelected()==false){
		   while(!blnChk && i<10) {
		    this.page.element("//table[@id='grid']/tbody/tr/td[2]/span[text()='"+strResource+"']/parent::td/preceding-sibling::td[1]/input", "xpath").getOne().sendKeys(Keys.SPACE);
		    Thread.sleep(1000);
		    blnChk = this.page
		      .element("//table[@id='grid']/tbody/tr/td[2]/span[text()='"+strResource+"']/parent::td/preceding-sibling::td[1]/input", "xpath")
		      .getOne().isSelected();
		   }
		  
		  }
		  assertTrue(this.page
		    .element("//table[@id='grid']/tbody/tr/td[2]/span[text()='"+strResource+"']/parent::td/preceding-sibling::td[1]/input", "xpath")
		    .getOne().isSelected());
		  if(this.page.element("//input[@value='Clear Selections']/preceding-sibling::span[contains(text(),'Resources selected')]", "xpath").getOne().getText().equals("0 Resources selected")) {
		   this.clickOnSTTab();
		   Thread.sleep(10000);
		   this.clickOnResourcesTab();
		   Thread.sleep(10000);
		   blnChk = false; i = 0;
		   objWaitForElement.waitForElements("//table[@id='grid']/tbody/tr/td[2]/span[text()='"+strResource+"']/parent::td/preceding-sibling::td[1]/input", "xpath");
		   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='TB_load']/img[@src='/img/loadingAnimation.gif']")));
		   wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//table[@id='grid']/tbody/tr/td[2]/span[text()='"+strResource+"']/parent::td/preceding-sibling::td[1]/input"))));
		   wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//table[@id='grid']/tbody/tr/td[2]/span[text()='"+strResource+"']/parent::td/preceding-sibling::td[1]/input"))));
		   if(this.page.element("//table[@id='grid']/tbody/tr/td[2]/span[text()='"+strResource+"']/parent::td/preceding-sibling::td[1]/input", "xpath")
		     .getOne().isSelected()==false){
		    while(!blnChk && i<10) {
		     this.page.element("//table[@id='grid']/tbody/tr/td[2]/span[text()='"+strResource+"']/parent::td/preceding-sibling::td[1]/input", "xpath").getOne().sendKeys(Keys.SPACE);
		     Thread.sleep(1000);
		     blnChk = this.page
		       .element("//table[@id='grid']/tbody/tr/td[2]/span[text()='"+strResource+"']/parent::td/preceding-sibling::td[1]/input", "xpath")
		       .getOne().isSelected();
		    }
		   
		   }
		   assertTrue(this.page
		     .element("//table[@id='grid']/tbody/tr/td[2]/span[text()='"+strResource+"']/parent::td/preceding-sibling::td[1]/input", "xpath")
		     .getOne().isSelected());
		   
		  }
		  return this;
		 }	
	
	/**********************************************************************************
	  * Description : This function is to select resource
	  * Date        : 20/06/2014
	  * Author      : Yugender
	  **********************************************************************************/
	public ViewsList verfyResourceselectedForView(String strResource)
			throws Exception {
		objWaitForElement
				.waitForElements("//table[@id='grid']/tbody/tr/td[2]/span[text()='"+strResource+"']/parent::td/preceding-sibling::td[1]/input", "xpath");
		assertTrue(this.page
				.element("//table[@id='grid']/tbody/tr/td[2]/span[text()='"+strResource+"']/parent::td/preceding-sibling::td[1]/input", "xpath").getOne().isSelected());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select resource
	  * Date        : 20/06/2014
	  * Author      : Yugender
	  **********************************************************************************/
	public ViewsList selectResourceType(String strResourceTypeValue) throws Exception {
		objWaitForElement.waitForElements("//input[@value='" + strResourceTypeValue
				+ "'][@name='resourceTypeID']", "xpath");
			this.page.element(
					"//input[@value='" + strResourceTypeValue
							+ "'][@name='resourceTypeID']", "xpath").mouseOver();
			this.page
					.element(
							"//input[@value='" + strResourceTypeValue
									+ "'][@name='resourceTypeID']", "xpath")
					.getOne().sendKeys(Keys.SPACE);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on save of create new View
	  * Date        : 20/06/2014
	  * Author      : Yugender
	  **********************************************************************************/
	public ViewsList clickOnSaveOfCreateNewView() throws Exception {
		objWaitForElement.waitForElements(saveOfCreateNewView, "xpath");
		this.page.element(saveOfCreateNewView, "xpath").getOne().sendKeys(Keys.ENTER);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to navigate to 'Views'
	  * Date        : 23/06/2014
	  * Author      : Yugender
	  **********************************************************************************/
	public ViewsList clickOnView() throws Exception {
		objWaitForElement.waitForElements(viewLink, "xpath");
		this.page.element(viewLink, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on new view
	  * Date        : 23/06/2014
	  * Author      : Yugender
	  **********************************************************************************/
	public ViewsList navigateToCreatedView(String strViewName) throws Exception {
		this.clickOnView();
		objWaitForElement.waitForElements("//td/a[text()='" + strViewName + "']", "xpath");
		this.page
				.dynamicElement(strViewName,
						"//td/a[text()='" + strViewName + "']", "xpath")
				.getOne().click();
		return new ViewsList(this.driver);
	}
	
	/**********************************************************************************
	  * Description : This function is to click on Update Status
	  * Date        : 23/06/2014
	  * Author      : Yugender
	  **********************************************************************************/
	public ViewsList clickOnUpdateStatus(String strResourceName)
			throws Exception {
		
		Thread.sleep(2000);
		objWaitForElement.waitForElements("//div[@id='viewContainer']/table/tbody/tr/td[2]/a[text()='"
				+ strResourceName
				+ "']/parent::td/preceding-sibling::td/a/img[@title='Update Status']",
		"xpath");
		this.page
				.element_wait(
						"//div[@id='viewContainer']/table/tbody/tr/td[2]/a[text()='"
								+ strResourceName
								+ "']/parent::td/preceding-sibling::td/a/img[@title='Update Status']",
						"xpath").waitForVisibilityOfElement();
		assertTrue(this.page
				.element(
						"//div[@id='viewContainer']/table/tbody/tr/td[2]/a[text()='"
								+ strResourceName
								+ "']/parent::td/preceding-sibling::td/a/img[@title='Update Status']",
						"xpath").isElementPresent());
		this.page
				.dynamicElement(
						strResourceName,
						"//div[@id='viewContainer']/table/tbody/tr/td[2]/a[text()='"
								+ strResourceName
								+ "']/parent::td/preceding-sibling::td/a/img[@title='Update Status']",
						"xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on check box of Status
	  * Date        : 23/06/2014
	  * Author      : Yugender
	  **********************************************************************************/
	public ViewsList selectStatusToUpdate(String strStatusName)
			throws Exception {
		objWaitForElement.waitForElements("//div[@class='status']/div/label[text()='"
				+ strStatusName
				+ ": ']/preceding-sibling::input[@name='status_type_id']",
		"xpath");
		this.page
				.dynamicElement(
						strStatusName,
						"//div[@class='status']/div/label[text()='"
								+ strStatusName
								+ ": ']/preceding-sibling::input[@name='status_type_id']",
						"xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is used to update status of NEDOC
	  * Date        : 23/06/2014
	  * Author      : Yugender
	  **********************************************************************************/
	public ViewsList updateNEDOCStatus(String strStatusName, String strValue)
			throws Exception {
		this.enterNumberOfEDPatients(strStatusName,strValue);
		this.enterNumberOfEDAdmits(strStatusName, strValue);
		this.enterLastDoorToBedTime(strStatusName, strValue);
		this.enterNumberOfCriticalCarePatients(strStatusName, strValue);
		this.enterLongestEDAdmit(strStatusName, strValue);
		this.enterNumberOfEDBeds(strStatusName, strValue);
		this.enterNumberOfInpatientBeds(strStatusName, strValue);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is used to enter Number Of ED Patients
	  * Date        : 23/06/2014
	  * Author      : Yugender
	  **********************************************************************************/
	public ViewsList enterNumberOfEDPatients(String strStatusName, String strValue)
			throws Exception {
		objWaitForElement.waitForElements("//div[@class='status statusOpen']/div/label[text()='"
				+ strStatusName
				+ ": ']/parent::div/following-sibling::div/div/div/label[text()='Number of ED Patients']/preceding-sibling::input",
		"xpath");
		this.page.dynamicElement(
						strStatusName,
						"//div[@class='status statusOpen']/div/label[text()='"
								+ strStatusName
								+ ": ']/parent::div/following-sibling::div/div/div/label[text()='Number of ED Patients']/preceding-sibling::input",
						"xpath").clearInputValue().sendKeys(strValue);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is used to enter Number Of ED Admits
	  * Date        : 23/06/2014
	  * Author      : Yugender
	  **********************************************************************************/
	public ViewsList enterNumberOfEDAdmits(String strStatusName, String strValue)
			throws Exception {
		objWaitForElement.waitForElements("//div[@class='status statusOpen']/div/label[text()='"
				+ strStatusName
				+ ": ']/parent::div/following-sibling::div/div/div/label[text()='Number of ED Admits']/preceding-sibling::input",
		"xpath");
		this.page.dynamicElement(
						strStatusName,
						"//div[@class='status statusOpen']/div/label[text()='"
								+ strStatusName
								+ ": ']/parent::div/following-sibling::div/div/div/label[text()='Number of ED Admits']/preceding-sibling::input",
						"xpath").clearInputValue().sendKeys(strValue);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is used to enter Last Door To Bed Time
	  * Date        : 23/06/2014
	  * Author      : Yugender
	  **********************************************************************************/
	public ViewsList enterLastDoorToBedTime(String strStatusName, String strValue)
			throws Exception {
		objWaitForElement.waitForElements("//div[@class='status statusOpen']/div/label[text()='"
				+ strStatusName
				+ ": ']/parent::div/following-sibling::div/div/div/label[text()='Last Door-to-bed Time (hours, ex: 1.25)']/preceding-sibling::input",
		"xpath");
		this.page.dynamicElement(
						strStatusName,
						"//div[@class='status statusOpen']/div/label[text()='"
								+ strStatusName
								+ ": ']/parent::div/following-sibling::div/div/div/label[text()='Last Door-to-bed Time (hours, ex: 1.25)']/preceding-sibling::input",
						"xpath").clearInputValue().sendKeys(strValue);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is used to enter Number of Critical Care Patients
	  * Date        : 23/06/2014
	  * Author      : Yugender
	  **********************************************************************************/
	public ViewsList enterNumberOfCriticalCarePatients(String strStatusName, String strValue)
			throws Exception {
		objWaitForElement.waitForElements("//div[@class='status statusOpen']/div/label[text()='"
				+ strStatusName
				+ ": ']/parent::div/following-sibling::div/div/div/label[text()='Number of Critical Care Patients (in ED)']/preceding-sibling::input",
		"xpath");
		this.page.dynamicElement(
						strStatusName,
						"//div[@class='status statusOpen']/div/label[text()='"
								+ strStatusName
								+ ": ']/parent::div/following-sibling::div/div/div/label[text()='Number of Critical Care Patients (in ED)']/preceding-sibling::input",
						"xpath").clearInputValue().sendKeys(strValue);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is used to enter Number of Critical Care Patients
	  * Date        : 23/06/2014
	  * Author      : Yugender
	  **********************************************************************************/
	public ViewsList enterLongestEDAdmit(String strStatusName, String strValue)
			throws Exception {
		objWaitForElement.waitForElements("//div[@class='status statusOpen']/div/label[text()='"
				+ strStatusName
				+ ": ']/parent::div/following-sibling::div/div/div/label[text()='Longest ED Admit (hours, ex: 1.25)']/preceding-sibling::input",
		"xpath");
		this.page.dynamicElement(
						strStatusName,
						"//div[@class='status statusOpen']/div/label[text()='"
								+ strStatusName
								+ ": ']/parent::div/following-sibling::div/div/div/label[text()='Longest ED Admit (hours, ex: 1.25)']/preceding-sibling::input",
						"xpath").clearInputValue().sendKeys(strValue);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is used to enter Number of Critical Care Patients
	  * Date        : 23/06/2014
	  * Author      : Yugender
	  **********************************************************************************/
	public ViewsList enterNumberOfEDBeds(String strStatusName, String strValue)
			throws Exception {
		objWaitForElement.waitForElements("//div[@class='status statusOpen']/div/label[text()='"
				+ strStatusName
				+ ": ']/parent::div/following-sibling::div/div/div/label[text()='Number of ED Beds']/preceding-sibling::input",
		"xpath");
		this.page.dynamicElement(
						strStatusName,
						"//div[@class='status statusOpen']/div/label[text()='"
								+ strStatusName
								+ ": ']/parent::div/following-sibling::div/div/div/label[text()='Number of ED Beds']/preceding-sibling::input",
						"xpath").clearInputValue().sendKeys(strValue);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is used to enter Number of Critical Care Patients
	  * Date        : 23/06/2014
	  * Author      : Yugender
	  **********************************************************************************/
	public ViewsList enterNumberOfInpatientBeds(String strStatusName, String strValue)
			throws Exception {
		objWaitForElement.waitForElements("//div[@class='status statusOpen']/div/label[text()='"
				+ strStatusName
				+ ": ']/parent::div/following-sibling::div/div/div/label[text()='Number of Inpatient Beds (excluding PEDS and OB)']/preceding-sibling::input",
		"xpath");
		this.page.dynamicElement(
						strStatusName,
						"//div[@class='status statusOpen']/div/label[text()='"
								+ strStatusName
								+ ": ']/parent::div/following-sibling::div/div/div/label[text()='Number of Inpatient Beds (excluding PEDS and OB)']/preceding-sibling::input",
						"xpath").clearInputValue().sendKeys(strValue);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is used to update status of NST
	  * Date        : 23/06/2014
	  * Author      : Yugender
	  **********************************************************************************/
	public ViewsList updateNSTStatus(String strStatusName, String strValue)
			throws Exception {
		objWaitForElement.waitForElements("//div[@class='status statusOpen']/div/label[text()='"
				+ strStatusName
				+ ": ']/parent::div/following-sibling::div/input[@class='number']",
		"xpath");
		this.page.dynamicElement(
						strStatusName,
						"//div[@class='status statusOpen']/div/label[text()='"
								+ strStatusName
								+ ": ']/parent::div/following-sibling::div/input[@class='number']",
						"xpath").clearInputValue().sendKeys(strValue);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is used to update status of NST
	  * Date        : 23/06/2014
	  * Author      : Yugender
	  **********************************************************************************/
	public ViewsList clickOnSaveOfUpdateStatus()
			throws Exception {
		objWaitForElement.waitForElements(saveOfUpdate, "xpath");
		this.page.element(saveOfUpdate, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is used to update status of NST
	  * Date        : 23/06/2014
	  * Author      : Yugender
	  **********************************************************************************/
	public ViewsList verifyNEDOCSUpdatedStatus(String strStatusName) throws Exception {
		Actions action = new Actions(driver);
		objWaitForElement.waitForElements("//div[@id='viewContainer']/table/thead/tr/th/a[text()='"
				+ strStatusName
				+ "']/parent::th/parent::tr/parent::thead/following-sibling::tbody/tr/td[3]",
		"xpath");
		action.moveToElement(this.page
				.dynamicElement(
						strStatusName,
						"//div[@id='viewContainer']/table/thead/tr/th/a[text()='"
								+ strStatusName
								+ "']/parent::th/parent::tr/parent::thead/following-sibling::tbody/tr/td[3]",
						"xpath").getOne()).build().perform();
		Thread.sleep(5000);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is used to update status of NST
	  * Date        : 23/06/2014
	  * Author      : Yugender
	  **********************************************************************************/
	public ViewsList verifyNSTUpdatedStatus(String strStatusName) throws Exception {
		Actions action = new Actions(driver);
		objWaitForElement.waitForElements("//div[@id='viewContainer']/table/thead/tr/th/a[text()='"
				+ strStatusName
				+ "']/parent::th/parent::tr/parent::thead/following-sibling::tbody/tr/td[4]",
		"xpath");
		action.moveToElement(this.page
				.dynamicElement(
						strStatusName,
						"//div[@id='viewContainer']/table/thead/tr/th/a[text()='"
								+ strStatusName
								+ "']/parent::th/parent::tr/parent::thead/following-sibling::tbody/tr/td[4]",
						"xpath").getOne()).build().perform();
		Thread.sleep(5000);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on customize Resource Detail View
	  * Date        : 05/08/2014
	  * Author      : Anil
	  **********************************************************************************/
	public ViewsList clickOncustomizeResourceDetailView() throws Exception {
		/*objWaitForElement.waitForElements(customizeResourceDetailView, "css");
		this.page.element(customizeResourceDetailView, "css").getOne().click();
		return this;*/
		WebDriverWait wait =new WebDriverWait(driver, WaitTimeConstants.WAIT_TIME_LONG2);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(customizeResourceDetailView)));
		this.page.element(customizeResourceDetailView, "css").getOne().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(enterSectionName)));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to enter Section Name
	  * Date        : 20/06/2014
	  * Author      : Yugender
	  **********************************************************************************/
	public ViewsList enterSectionName(String strSectionName) throws Exception {
		objWaitForElement.waitForElements(enterSectionName, "css");
		this.page.element(enterSectionName, "css").getOne().clear();
		this.page.element(enterSectionName, "css").getOne().sendKeys(strSectionName);
		return this;
	}
	
	
	/**********************************************************************************
	  * Description : This function is to click on create Section
	  * Date        : 05/08/2014
	  * Author      : Anil
	  **********************************************************************************/
	public ViewsList clickOnCreateSection() throws Exception {
		objWaitForElement.waitForElements(createSection, "css");
		this.page.element(createSection, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on save button
	  * Date        : 05/08/2014
	  * Author      : Anil
	  **********************************************************************************/
	public ViewsList clickOnSaveButton() throws Exception {
		objWaitForElement.waitForElements(saveButton, "css");
		this.page.element(saveButton, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to create new section
	  * Date        : 05/08/2014
	  * Author      : Anil
	  **********************************************************************************/
	public ViewsList createNewSection(String strSectionName) throws Exception {
		this.clickOncustomizeResourceDetailView();
		this.enterSectionName(strSectionName);
		this.clickOnCreateSection();
		this.clickOnSaveButton();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on uncategorized.
	  * Date        : 06/08/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList clickOnUncategorized() throws Exception {
		this.driver.manage().timeouts().pageLoadTimeout(WaitTimeConstants.WAIT_TIME_SMALL,
				TimeUnit.SECONDS);
		objWaitForElement.waitForElements(uncategorized, "css");
		this.page.element(uncategorized, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify created status types in list
	  * Date        : 06/08/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList verStatusTypesInList(String[] strStatusTypes,
			String[] strStatusTypeVal) throws Exception {
		objWaitForElement.waitForElements(createdStatuaTypesInList + "/input[@name='sort_"
				+ strStatusTypeVal[0]
				+ "']/parent::div[text()='"
				+ strStatusTypes[0] + "']", "xpath");
		for (int i = 0; i < strStatusTypes.length; i++) {
			assertTrue(
					this.page.element(
							createdStatuaTypesInList + "/input[@name='sort_"
									+ strStatusTypeVal[i]
									+ "']/parent::div[text()='"
									+ strStatusTypes[i] + "']", "xpath")
							.isElementPresent(),
					"Created status type not displayed.");
		}
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify created status types in list
	  * Date        : 06/08/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList verStatusTypesInList(String strStatusTypes,
			String strStatusTypeVal) throws Exception {
		objWaitForElement.waitForElements(createdStatuaTypesInList + "/input[@name='sort_"
				+ strStatusTypeVal + "']/parent::div[text()='"
				+ strStatusTypes + "']", "xpath");
		assertTrue(
				this.page.element(
						createdStatuaTypesInList + "/input[@name='sort_"
								+ strStatusTypeVal + "']/parent::div[text()='"
								+ strStatusTypes + "']", "xpath")
						.isElementPresent(),
				"Created status type not displayed.");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is used to drag and drop status type.
	  * Arguments	: strStatusTypes, strSectionName
	  * Date        : 06/08/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList dragAndDropStatusType(String strStatusTypes,
			String strSectionName) throws Exception {
		objWaitForElement.waitForElements("//ul[@id='groups']/li/div/span[contains(text(),'"
				+ strSectionName + "')]", "xpath");
		WebElement element = this.page.element(
				"//ul[@id='groups']/li/div/span[contains(text(),'"
								+ strSectionName + "')]", "xpath")
				.getOne();
		
		/*Actions builder = new Actions(driver); 
		Action dragAndDrop = builder.clickAndHold(this.page.element(
				createdStatuaTypesInList + "[text()='" + strStatusTypes + "']",
				"xpath").getOne()).sendKeys(element, Keys.ARROW_DOWN).moveToElement(element).release(element).build();
		dragAndDrop.perform();*/
		
		this.page.element(createdStatuaTypesInList + "[text()='" + strStatusTypes + "']",
				"xpath").dragAndDrop(element);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify created status types in list
	  * Arguments	: strSectionName
	  * Date        : 06/08/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList verCreatedSection(String strSectionName) throws Exception {
		objWaitForElement.waitForElements("//ul[@id='groups']/li/div/span[contains(text(),'"
				+ strSectionName + "')]", "xpath");
		assertTrue(
				this.page.element(
						"//ul[@id='groups']/li/div/span[contains(text(),'"
								+ strSectionName + "')]", "xpath")
						.isElementPresent(),
				"Created section is not displayed.");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on section.
	  * Arguments	: strSectionName
	  * Date        : 06/08/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList clickOnSection(String strSectionName) throws Exception {
		objWaitForElement.waitForElements(
				"//ul[@id='groups']/li/div/span[contains(text(),'"
						+ strSectionName + "')]", "xpath");
		this.page
				.element(
						"//ul[@id='groups']/li/div/span[contains(text(),'"
								+ strSectionName + "')]", "xpath").getOne()
				.click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to get number of status type in section.
	  * Date        : 06/08/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public int getNumOfStatusTypePresentInSection() throws Exception {
		objWaitForElement.waitForElements("//div[@id='itemBox']/ul[@style='display: block;']/li",
				"xpath");
		int intCount = this.page
				.element(
						"//div[@id='itemBox']/ul[@style='display: block;']/li",
						"xpath").getXpathCount();
		return intCount;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify section count.
	  * Arguments	: strSection, intCount
	  * Date        : 06/08/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList verCountInSection(String strSection, int intCount)
			throws Exception {
		objWaitForElement.waitForElements("//ul[@id='groups']/li/div/span[contains(text(),'"
				+ strSection + "')]/span[contains(text(),'(" + intCount + ")')]",
		"xpath");
		assertTrue(
				this.page.element(
						"//ul[@id='groups']/li/div/span[contains(text(),'"
								+ strSection + "')]/span[contains(text(),'(" + intCount + ")')]",
						"xpath").isElementPresent(), "Count is not correct.");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify view in list
	  * Arguments	: strViewName
	  * Date        : 06/08/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList verViewInList(String strViewName) throws Exception {
		objWaitForElement.waitForElements("//table[@id='listViews']/tbody/tr/td[2][text()='"+strViewName+"']",
				"xpath");
		assertTrue(
				this.page.element(
						"//table[@id='listViews']/tbody/tr/td[2][text()='"+strViewName+"']",
						"xpath").isElementPresent(), "View is not displayed.");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on edit link of section.
	  * Date        : 11/08/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList clickOnEditOfSection() throws Exception {
		objWaitForElement.waitForElements(editSection, "id");
		assertTrue(this.page.element(editSection, "id").isElementPresent(),
				"Edit link is not present.");
		this.page.element(editSection, "id").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on submit of edited section name.
	  * Date        : 11/08/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList clickOnSubmitOfEditedSection() throws Exception {
		objWaitForElement.waitForElements(sumbmitOfEditedName, "id");
		this.page.element(sumbmitOfEditedName, "id").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on submit of edited section name.
	  * Arguments	: strSectionName
	  * Date        : 11/08/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList enterEditedSectionName(String strSectionName) throws Exception {
		objWaitForElement.waitForElements(editSectionNameField, "id");
		assertTrue(this.page.element(editSectionNameField, "id").isElementPresent(),
				"Edit section name field is not present.");
		this.page.element(editSectionNameField, "id").clearInputValue().sendKeys(strSectionName);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on edit link of section.
	  * Arguments	: strSectionName
	  * Date        : 11/08/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList editSectionName(String strSectionName, String strEditedSecName) throws Exception {
		this.clickOnSection(strSectionName);
		this.clickOnEditOfSection();
		this.enterEditedSectionName(strEditedSecName);
		this.clickOnSubmitOfEditedSection();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Region view list page is displayed
	  * Date        : 11/08/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList verRegionViewListPageIsDisplayed() throws Exception {
		objWaitForElement.waitForElements("//div[@id='topSubNav']/h1[text()='Region Views List']", "xpath");
		assertTrue(this.page.element("//div[@id='topSubNav']/h1[text()='Region Views List']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify delete link associated with multi region view
	  * Precondition: strView
	  * Date        : 08/09/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList verDeleteAssociatedWithMulRegView(String strView) throws Exception {
		objWaitForElement.waitForElements("//a[text()='Delete']/parent::td/following-sibling::td[text()='"+strView+"']",
				"xpath");
		assertTrue(
				this.page
						.element(
								"//a[text()='Delete']/parent::td/following-sibling::td[text()='"+strView+"']",
								"xpath").isElementPresent(),
				"Delte link with multi region view is not displayed.");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify users link associated with multi region view
	  * Precondition: strView
	  * Date        : 08/09/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList verUsersAssociatedWithMulRegView(String strView) throws Exception {
		objWaitForElement.waitForElements("//a[text()='Users']/parent::td/following-sibling::td[text()='"+strView+"']",
				"xpath");
		assertTrue(
				this.page
						.element(
								"//a[text()='Users']/parent::td/following-sibling::td[text()='"+strView+"']",
								"xpath").isElementPresent(),
				"Delte link with multi region view is not displayed.");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify demote link associated with multi region view
	  * Precondition: strView
	  * Date        : 08/09/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList verDemoteAssociatedWithMulRegView(String strView) throws Exception {
		objWaitForElement.waitForElements("//a[text()='Demote']/parent::td/following-sibling::td[text()='"+strView+"']",
				"xpath");
		assertTrue(
				this.page
						.element(
								"//a[text()='Demote']/parent::td/following-sibling::td[text()='"+strView+"']",
								"xpath").isElementPresent(),
				"Delte link with multi region view is not displayed.");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to clcik on users link associated with multi region view
	  * Precondition: strView
	  * Date        : 08/09/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList clickOnUsersAssociatedWithMulRegView(String strView)
			throws Exception {
		objWaitForElement.waitForElements("//td[text()='" + strView
				+ "']/preceding-sibling::td/a[text()='Users']",
		"xpath");
		this.page
				.element(
						"//td[text()='" + strView
								+ "']/preceding-sibling::td/a[text()='Users']",
						"xpath").mouseOver();
		this.page
				.element(
						"//td[text()='" + strView
								+ "']/preceding-sibling::td/a[text()='Users']",
						"xpath").getOne().sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		return this;
	}
	
	/*******************************************************************************
	 * Description : This function is to select username in Assign Users to View Custom
	 * Arguments   : strUserName
	 * Date        : 08/09/2014
	 * Author      : Renushree
	*******************************************************************************/	
	public ViewsList selectUserInEveSecutityPage(String strUserName)
			throws Exception {
		objWaitForElement.waitForElements("//input[@value='"+strUserName+"']", "xpath");
		this.page.element("//input[@value='"+strUserName+"']", "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to click on save button
	 * Date 		: 08/09/2014
	 * Author 		: Renushree
	 **********************************************************************************/
	public ViewsList clickOnSave() throws Exception {
		objWaitForElement.waitForElements(save, "css");
		this.page.element(save, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Region view list page is displayed
	  * Precondition: strView
	  * Date        : 08/09/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList verAssgnUserToViewCustomPgeIsDisplayed(String strView)
			throws Exception {
		Thread.sleep(5000);
		objWaitForElement.waitForElements("//div[@id='topSubNav']/h1[text()='Assign Users to View "+strView+"']", "xpath");
		assertEquals("Assign Users to View " + strView + "",
				this.page.element(headerName, "css").getOne().getText(),
				"Assign Users to View Custom page is not displayed.");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on demote link associated with multi region view
	  * Precondition: strView
	  * Date        : 08/09/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList clickOnDemoteAssociatedWithMulRegView(String strView)
			throws Exception {
		objWaitForElement.waitForElements("//td[text()='"+ strView +"']/preceding-sibling::td/a[text()='Demote']", "xpath");
		this.page
				.element("//td[text()='"+ strView +"']/preceding-sibling::td/a[text()='Demote']", "xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to verify emresource warning message.
	  * Date        : 08/09/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList verEMRWarningMsg() throws Exception {
		objWaitForElement.waitForElements("//div[@id='topSubNav']/h1[text()='EMResource Warning - Not Authorized']", "xpath");
		assertEquals("EMResource Warning - Not Authorized",
				this.page.element(headerName, "css").getOne().getText());
		assertEquals("You are not authorized to perform this action.",
				this.page.element("//div[@class='emsLevel1']", "xpath")
						.getOne().getText());
		assertEquals(
				"All unauthorized access is logged.\nIf you feel you have reached this page in error, contact your regional administrator.",
				this.page.element("//div[@class='emsLevel2']", "xpath")
						.getOne().getText());
		assertEquals("Click here to return to the status view.", this.page
				.element("//div[@class='emsLevel3']", "xpath").getOne()
				.getText());
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to click on delete link associated with multi region view
	  * Precondition: strView
	  * Date        : 08/09/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList clickOnDeleteAssociatedWithMulRegView(String strView)
			throws Exception {
		objWaitForElement.waitForElements("//td[text()='"+ strView +"']/preceding-sibling::td/a[text()='Delete']", "xpath");
		this.page
				.element("//td[text()='"+ strView +"']/preceding-sibling::td/a[text()='Delete']", "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Delete view confirmation page is displayed
	  * Date        : 08/09/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList verDelViewConfPgeIsDisplayed() throws Exception {
		objWaitForElement.waitForElements("//div[@id='topSubNav']/h1[text()='Delete View Confirmation']", "xpath");
		assertEquals("Delete View Confirmation", this.page.element(headerName, "css").getOne().getText(),
				"Delete View Confirmation page is not displayed.");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Delete view confirmation page details.
	  * Date        : 08/09/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList verDelViewConfirmationPge() throws Exception {
		objWaitForElement.waitForElements(viewNameInDelPge, "css");
		assertTrue(this.page.element(viewNameInDelPge, "css")
				.isElementPresent(), "View name field is not displayed.");
		assertTrue(this.page.element(descriptionInDelPge, "css")
				.isElementPresent(), "Description field is not displayed.");
		assertEquals("Confirm Delete", this.page.element(confmDel, "xpath")
				.getOne().getText());
		assertTrue(this.page
				.element("//div[@id='mainContainer']/form", "xpath")
				.getOne()
				.getText()
				.contains(
						"If it is OK to delete this Region View, please click on the 'Delete' button below. Otherwise, click on the 'Cancel' button."));
		assertTrue(this.page.element(delete, "css").isElementPresent(),
				"Delete button is not displayed.");
		assertTrue(this.page.element(cancel, "css").isElementPresent(),
				"Cancel button is not displayed.");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on Delete.
	  * Date        : 08/09/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList clickOnDelete() throws Exception {
		objWaitForElement.waitForElements(delete, "css");
		this.page.element(delete, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify view is not displayed.
	  * Arguments	: strViewName
	  * Date        : 06/08/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList verViewIsNotListed(String strViewName) throws Exception {
		assertFalse(
				this.page.element(
						"//table[@summary='Menu Options']/tbody/tr/td/a[text()='"+strViewName+"']",
						"xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE), "View is displayed.");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify view is not displayed.
	  * Arguments	: strViewName
	  * Date        : 06/08/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList verViewIsNotInMenuDroDown(String strViewName)
			throws Exception {
		assertFalse(
				this.page.element(
						"//table/tbody/tr/td/a[text()='" + strViewName + "']",
						"xpath").isElementPresent(
						WaitTimeConstants.WAIT_TIME_FOR_FALSE),
				"View is displayed.");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter NumberOfEDBedsOccupied in update status page
	 * Date        : 09/09/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public ViewsList enterNumberOfEDBedsOccupied(String strValue)
			throws Exception {
		objWaitForElement.waitForElements(numberOfEDBedsOccupied, "xpath");
		this.page.element(numberOfEDBedsOccupied, "xpath").clearInputValue()
				.sendKeys(strValue);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter NumberOfPatientsInLobby in update status page
	 * Date        : 04/09/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public ViewsList enterNumberOfPatientsInLobby(String strValue)
			throws Exception {
		objWaitForElement.waitForElements(numberOfPatientsInLobby, "xpath");
		this.page.element(numberOfPatientsInLobby, "xpath").clearInputValue()
				.sendKeys(strValue);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter NumberOfAmbulancePatientsEnRouteOrWaiting in update status page
	 * Date        : 04/09/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public ViewsList enterNumberOfAmbulancePatientsEnRouteOrWaiting(String strValue)
			throws Exception {
		objWaitForElement.waitForElements(numberOfAmbulancePatientsEnRouteOrWaiting, "xpath");
		this.page.element(numberOfAmbulancePatientsEnRouteOrWaiting, "xpath").clearInputValue()
				.sendKeys(strValue);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter numberOfGeneralAdmits in update status page
	 * Date        : 04/09/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public ViewsList enterNumberOfGeneralAdmits(String strValue)
			throws Exception {
		objWaitForElement.waitForElements(numberOfGeneralAdmits, "xpath");
		this.page.element(numberOfGeneralAdmits, "xpath").clearInputValue()
				.sendKeys(strValue);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter NumberOfICUAdmits in update status page
	 * Date        : 04/09/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public ViewsList enterNumberOfICUAdmits(String strValue)
			throws Exception {
		objWaitForElement.waitForElements(numberOfICUAdmits, "xpath");
		this.page.element(numberOfICUAdmits, "xpath").clearInputValue()
				.sendKeys(strValue);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter NumberOfPatientsRequiringCare in update status page
	 * Date        : 04/09/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public ViewsList enterNumberOfPatientsRequiringCare(String strValue)
			throws Exception {
		objWaitForElement.waitForElements(numberOfPatientsRequiringCare, "xpath");
		this.page.element(numberOfPatientsRequiringCare, "xpath").clearInputValue()
				.sendKeys(strValue);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter NumberOfRNsShortStaffed in update status page
	 * Date        : 04/09/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public ViewsList enterNumberOfRNsShortStaffed(String strValue)
			throws Exception {
		objWaitForElement.waitForElements(numberOfRNsShortStaffed, "xpath");
		this.page.element(numberOfRNsShortStaffed, "xpath").clearInputValue()
				.sendKeys(strValue);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter NumberOfEDBedsAssigned in update status page
	 * Date        : 04/09/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public ViewsList enterNumberOfEDBedsAssigned(String strValue)
			throws Exception {
		objWaitForElement.waitForElements(numberOfEDBedsAssigned, "xpath");
		this.page.element(numberOfEDBedsAssigned, "xpath").clearInputValue()
				.sendKeys(strValue);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter ReasonableLobbyCapacity in update status page
	 * Date        : 04/09/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public ViewsList enterReasonableLobbyCapacity(String strValue)
			throws Exception {
		objWaitForElement.waitForElements(reasonableLobbyCapacity, "xpath");
		this.page.element(reasonableLobbyCapacity, "xpath").clearInputValue()
				.sendKeys(strValue);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter Charge Nurse/ManagerVal in update status page
	 * Date        : 11/09/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public ViewsList enterChargeNurseManagerVal(String strValue)
			throws Exception {
		objWaitForElement.waitForElements(reasonableLobbyCapacity, "xpath");
		this.page.element(reasonableLobbyCapacity, "xpath").clearInputValue()
				.sendKeys(strValue);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter Physician value in update status page
	 * Date        : 11/09/2014
	 * Author      : Renushree
	 **********************************************************************************/
	public ViewsList enterPhysicianVal(String strValue)
			throws Exception {
		objWaitForElement.waitForElements(reasonableLobbyCapacity, "xpath");
		this.page.element(reasonableLobbyCapacity, "xpath").clearInputValue()
				.sendKeys(strValue);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is used to update status of NEDOC
	  * Date        : 23/06/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public ViewsList updateSSTStatus(String strValue)
			throws Exception {
		this.enterNumberOfEDBedsOccupied(strValue);
		this.enterNumberOfPatientsInLobby(strValue);
		this.enterNumberOfAmbulancePatientsEnRouteOrWaiting(strValue);
		this.enterNumberOfGeneralAdmits(strValue);
		this.enterNumberOfICUAdmits(strValue);
		this.enterNumberOfPatientsRequiringCare(strValue);
		this.enterNumberOfRNsShortStaffed(strValue);
		this.enterNumberOfEDBedsAssigned(strValue);
		this.enterReasonableLobbyCapacity(strValue);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter ReasonableLobbyCapacity in update status page
	 * Date        : 04/09/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public ViewsList selectMultiStatusRadioBtn(String strMultiStatusName)
			throws Exception {
		objWaitForElement.waitForElements("//label[text()='" + strMultiStatusName
				+ "']/preceding-sibling::input", "xpath");
		this.page
				.element(
						"//label[text()='" + strMultiStatusName
								+ "']/preceding-sibling::input", "xpath")
				.getOne().click();
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to click on 'Edit' link of View
	 * Date        : 19/06/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public ViewsList clickOnEditLinkOfView(String strViewName) throws Exception {
		objWaitForElement.waitForElements("//table[@id='listViews']/tbody/tr/td[text()='"
				+ strViewName + "']/"
				+ "preceding-sibling::td/a[text()='Edit']",
		"xpath");
		this.page
				.element(
						"//table[@id='listViews']/tbody/tr/td[text()='"
								+ strViewName + "']/"
								+ "preceding-sibling::td/a[text()='Edit']",
						"xpath").getOne().sendKeys(Keys.ENTER);Thread.sleep(10000);Thread.sleep(10000);
		Thread.sleep(10000);
		return this;
	}
	/**********************************************************************
	  * Description : This function is to select status type
	  * Date        : 28/07/2014
	  * Author      : Anil
	  **********************************************************************/	

	public ViewsList selectStatusTypeForView(String[] strStatusTypeValue)
			throws Exception {
		objWaitForElement.waitForElements("//input[@value='" + strStatusTypeValue[0]
				+ "'][@name='statusTypeID']", "xpath");
		for (int i = 0; i < strStatusTypeValue.length; i++) {
			this.page.element(
					"//input[@value='" + strStatusTypeValue[i]
							+ "'][@name='statusTypeID']", "xpath").mouseOver();
			this.page
					.element(
							"//input[@value='" + strStatusTypeValue[i]
									+ "'][@name='statusTypeID']", "xpath")
					.getOne().sendKeys(Keys.SPACE);
		}
		return this;
	}
	
	/**********************************************************************
	  * Description : This function is to select status type
	  * Date        : 28/07/2014
	  * Author      : Anil
	  **********************************************************************/	

	public ViewsList verfyStatusTypeSelectedForView(String[] strStatusTypeNames)
			throws Exception {
//		objWaitForElement.waitForElements("//input[@value='"
//				+ strStatusTypeValue[0] + "'][@name='statusTypeID']", "xpath");
//		for (int i = 0; i < strStatusTypeValue.length; i++) {
//			assertTrue(this.page
//					.element(
//							"//input[@value='" + strStatusTypeValue[i]
//									+ "'][@name='statusTypeID']", "xpath")
//					.getOne().isSelected());
//		}
		String strElement = "//td//a[text()='" + strStatusTypeNames
				+ "']/ancestor::td/preceding-sibling::td[1]/input";
		objWaitForElement.waitForElements(strElement, "xpath");
		for (int i = 0; i < strStatusTypeNames.length; i++) {
			assertTrue(this.page
					.element(
							"//td//a[text()='"
									+ strStatusTypeNames[i]
									+ "']/ancestor::td/preceding-sibling::td[1]/input",
							"xpath").getOne().isSelected());
		}
		return this;
	}
	
	/**********************************************************************
	  * Description : This function is to click on resource name and navigate to resource detail page
	  * Date        : 11/09/2014
	  * Author      : Anil
	  **********************************************************************/	

	public ViewsList clickOnResourceAndNavigateToResourceDetail(String strResourceName)
			throws Exception {
		objWaitForElement.waitForElements("//td[@class='resourceName']/a[text()='"+strResourceName+"']", "xpath");
			this.page
					.dynamicElement(
							"statusTypes",
							"//td[@class='resourceName']/a[text()='"+strResourceName+"']", "xpath")
					.getOne().click();
		return this;
	}
	
	
	/**********************************************************************
	  * Description : This function is to click on resource name and navigate to resource detail page
	  * Date        : 11/09/2014
	  * Author      : Anil
	  **********************************************************************/	

	public ViewsList verifyStatusTypeName(String strStatusTypeName)
			throws Exception {
		objWaitForElement.waitForElements("//table/tbody/tr/td[2]/a[@title='Definition'][text()='"+strStatusTypeName+"']", "xpath");
		assertTrue(this.page.dynamicElement(strStatusTypeName, "//table/tbody/tr/td[2]/a[@title='Definition'][text()='"+strStatusTypeName+"']", "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on Sub resources
	  * Date        : 12/09/2014
	  * Author      : Anil
	  **********************************************************************************/
	public ViewsList clickSubResourceButton() throws Exception {
		objWaitForElement.waitForElements(subResourceButton, "css");
		this.page.element(subResourceButton, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on Sub resource type name
	  * Date        : 12/09/2014
	  * Author      : Anil
	  **********************************************************************************/
	public ViewsList clickOnSubResourceTypeName(String strSubResourceType) throws Exception {
		objWaitForElement.waitForElements("//div/span[text()='"+strSubResourceType+"']", "xpath");
		this.page.dynamicElement(strSubResourceType, "//div/span[text()='"+strSubResourceType+"']", "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on Sub resource type name
	  * Date        : 12/09/2014
	  * Author      : Anil
	  **********************************************************************************/
	public ViewsList selectSubResourceTypeCheckBox(String strSubResourceTypeValue) throws Exception {
		objWaitForElement.waitForElements( "//input[@name='subresourceSelect'][@id='g_"+strSubResourceTypeValue+"']", "xpath");
		this.page.dynamicElement(strSubResourceTypeValue, "//input[@name='subresourceSelect'][@id='g_"+strSubResourceTypeValue+"']", "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select on Sub resource
	  * Date        : 12/09/2014
	  * Author      : Anil
	  **********************************************************************************/
	public ViewsList selectSubResourceCheckBox(String strSubResourceValue) throws Exception {
		objWaitForElement.waitForElements("//input[@value='"
				+ strSubResourceValue + "']", "xpath");
			this.page
			.element("//input[@value='" + strSubResourceValue + "']",
					"xpath").mouseOver();
			this.page
					.element("//input[@value='" + strSubResourceValue + "']",
							"xpath").getOne().click();
		return this;
	}
	/**********************************************************************
	  * Description : This function is to click on resource name and navigate to resource detail page
	  * Date        : 11/09/2014
	  * Author      : Anil
	  **********************************************************************/	

	public ViewsList verifyStatusTypeNameIsNotInView(String strStatusTypeName)
			throws Exception {
		assertFalse(this.page
				.dynamicElement(
						strStatusTypeName,
						"//table/tbody/tr/td[2]/a[@title='Definition'][text()='"
								+ strStatusTypeName + "']", "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify the save button
	  * Date        : 23/09/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public ViewsList verifySaveButton() throws Exception {
		objWaitForElement.waitForElements(saveButton, "css");
		assertTrue(this.page.element(saveButton, "css").isElementPresent(),
				"Save button is not present");
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to verify the Cancel button
	  * Date        : 23/09/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public ViewsList verifyCancelButton() throws Exception {
		objWaitForElement.waitForElements(cancel, "css");
		assertTrue(this.page.element(cancel, "css").isElementPresent(),
				"Cancel button is not displayed.");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to Verify the Sub resources
	  * Date        : 23/09/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public ViewsList verifySubResourceButton() throws Exception {
		objWaitForElement.waitForElements(subResourceButton, "css");
		assertTrue(this.page.element(subResourceButton, "css")
				.isElementPresent(), "Sub-Resource button is not present");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to Verify the 'sortAll'
	  * Date        : 23/09/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public ViewsList verifySortAllButton() throws Exception {
		objWaitForElement.waitForElements(sortAllButton, "css");
		assertTrue(this.page.element(sortAllButton, "css")
				.isElementPresent(), "SortAll button is not present");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Edit Resource Detail View Sections' page is displayed
	  * Date        : 23/09/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public ViewsList verEditResourceDetailViewSectionsPageIsDisplayed()
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='topSubNav']/h1[text()='Edit Resource Detail View Sections']", "xpath");
		assertEquals("Edit Resource Detail View Sections",
				this.page.element(headerName, "css").getOne().getText(),
				"Edit Resource Detail View Sections page is not displayed.");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Edit Sub Resource Detail View Sections' page is displayed
	  * Date        : 23/09/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public ViewsList verEditSubResourceDetailViewSectionsPageIsDisplayed()
			throws Exception {
		objWaitForElement.waitForElements("//div[@id='topSubNav']/h1[text()='Edit Sub Resource Detail View Sections']", "xpath");
		assertEquals("Edit Sub Resource Detail View Sections", this.page
				.element(headerName, "css").getOne().getText(),
				"Edit Sub Resource Detail View Sections page is not displayed.");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify 'Edit Sub Resource Detail View Sections' page is displayed
	  * Date        : 23/09/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public ViewsList verEditViewPageIsDisplayed() throws Exception {
		objWaitForElement.waitForElements(
				"//div[@id='topSubNav']/h1[contains(text(),'Edit View:')]", "xpath");
		assertTrue(this.page.element("//div[@id='topSubNav']/h1[contains(text(),'Edit View:')]", "xpath").isElementPresent(),
				"Edit View page is not displayed.");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on Sub resource type name
	  * Date        : 12/09/2014
	  * Author      : Anil
	  **********************************************************************************/
	public ViewsList verSubResourceTypeNameIsNotPresentInEditSubResPage(
			String strSubResourceType) throws Exception {
		assertFalse(this.page.dynamicElement(strSubResourceType,
				"//div/span[text()='" + strSubResourceType + "']", "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Sub resource type check box is selected
	  * Date        : 23/09/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public ViewsList verSubResourceTypeCheckBoxIsSelected(
			String strSubResourceTypeValue) throws Exception {
		objWaitForElement.waitForElements("//input[@name='subresourceSelect'][@id='g_"
				+ strSubResourceTypeValue + "']", "xpath");
		assertTrue(this.page
				.dynamicElement(
						strSubResourceTypeValue,
						"//input[@name='subresourceSelect'][@id='g_"
								+ strSubResourceTypeValue + "']", "xpath")
				.getOne().isSelected());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Sub resource checkbox is selected
	  * Date        : 23/09/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public ViewsList verSubResourceCheckBoxIsSelected(String strSubResourceValue)
			throws Exception {
		objWaitForElement.waitForElements("//input[@value='" + strSubResourceValue + "']",
				"xpath");
		assertTrue(this.page
				.dynamicElement(strSubResourceValue,
						"//input[@value='" + strSubResourceValue + "']",
						"xpath").getOne().isSelected());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Sub resource checkbox is selected
	  * Date        : 23/09/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public ViewsList verSubResourceCheckBoxIsNotSelected(
			String strSubResourceValue) throws Exception {
		assertFalse(this.page
				.dynamicElement(strSubResourceValue,
						"//input[@value='" + strSubResourceValue + "']",
						"xpath").getOne().isSelected());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on Update Status of sub resource
	  * Date        : 23/09/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList clickOnUpdateStatusOfSubResource(String strSubResourceName)
			throws Exception {
		objWaitForElement.waitForElements("//a[text()='"
				+ strSubResourceName
				+ "']/parent::td/preceding-sibling::td/a/img[@title='Update Status']",
		"xpath");
		this.page
				.dynamicElement(
						strSubResourceName,
						"//a[text()='"
								+ strSubResourceName
								+ "']/parent::td/preceding-sibling::td/a/img[@title='Update Status']",
						"xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Resource List Page is displayed 
	  * Arguements  : strResourceName
	  * Date        : 24/09/2014
	  * Author      : Prasanna Lakshmi
	  **********************************************************************************/
	public ViewsList verSubResourceListPageisDisplayed(
			String strResourceNameTypeName) throws Exception {
		objWaitForElement.waitForElements("//div[@id='topSubNav']/h1[text()='"+strResourceNameTypeName+"']", "xpath");
		assertEquals(strResourceNameTypeName,
				this.page.element(headerName, "css").getOne().getText());
		return this;
	}

	 /**********************************************************************************
	  * Description : This function is to verify Resource List Page is displayed 
	  * Date        : 07/10/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList clickOnEditOfRegDefault() throws Exception {
		objWaitForElement.waitForElements("//td[text()='Region Default (default)']/preceding-sibling::td/a[text()='Edit']",
				"xpath");
		this.page
				.element(
						"//td[text()='Region Default (default)']/preceding-sibling::td/a[text()='Edit']",
						"xpath").getOne().click();
		return this;
	}
	 
	 
	 /**********************************************************************************
	  * Description : This function is to Select Users in Multi Region View
	  * Arguements  : strUserName
	  * Date        : 07/10/2014
	  * Author      : Prasanna Lakshmi
	  **********************************************************************************/
	public ViewsList selUserInMulRegView(String strUserName) throws Exception {
		objWaitForElement.waitForElements("//table[@id='tbl_userID']/tbody/tr/td/input[@value='"
				+ strUserName + "']", "xpath");
		if (this.page
				.element(
						"//table[@id='tbl_userID']/tbody/tr/td/input[@value='"
								+ strUserName + "']", "xpath").getOne()
				.isSelected() == false) {
			this.page
					.element(
							"//table[@id='tbl_userID']/tbody/tr/td/input[@value='"
									+ strUserName + "']", "xpath").getOne()
					.click();
		}
		return this;
	}

	 /**********************************************************************************
	  * Description : This function is to verify view is  displayed.
	  * Arguments	: 07/10/2014
	  * Date        : 06/08/2014
	  * Author      : Prasanna Lakshmi
	  **********************************************************************************/
	public ViewsList verViewIsListed(String strViewName) throws Exception {
		objWaitForElement.waitForElements("//table[@summary='Menu Options']/tbody/tr/td/a[text()='"+strViewName+"']",
				"xpath");
		assertTrue(
				this.page.element(
						"//table[@summary='Menu Options']/tbody/tr/td/a[text()='"+strViewName+"']",
						"xpath").isElementPresent(), "View is not displayed.");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify view is  displayed.
	  * Arguments	: 07/10/2014
	  * Date        : 06/08/2014
	  * Author      : Prasanna Lakshmi
	  **********************************************************************************/
	public ViewsList verViewIsNotListedInRegionViewList(String strViewName)
			throws Exception {
		assertFalse(
				this.page
						.element(
								"//table[@id='listViews']/tbody/tr/td[text()='"+strViewName+"']", "xpath")
						.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE),
				"View is Listed.");
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to verify created status types in list
	  * Arguments	: strSectionName
	  * Date        : 10/10/2014
	  * Author      : Anil
	  **********************************************************************************/
	public String getSectionValue(String strSectionName) throws Exception {	
		objWaitForElement.waitForElements("//ul[@id='groups']/li/div/span[contains(text(),'"+strSectionName+"')]/parent::div/parent::li", "xpath");
			String strSectionValue = this.page.element(
						"//ul[@id='groups']/li/div/span[contains(text(),'"+strSectionName+"')]/parent::div/parent::li", "xpath")
						.getOne().getAttribute("id");
			strSectionValue = strSectionValue.replace("g_", "");
		return strSectionValue;
	}
	
	
	/**********************************************************************************
	  * Description : This function is to select view type
	  * Date        : 21/11/2014
	  * Author      : Anil
	  **********************************************************************************/
	public ViewsList selectViewType(String strViewType) throws Exception {
//		objWaitForElement.waitForElements(viewType, "id");
//		this.page.element(viewType, "id").webElementToSelect().selectByVisibleText(strViewType);
		return this;
	}
	
	 
	 public ViewsList verDeactivatedStatusTypesNotDisplyed(String[] strStatusTypes,
	   String[] strStatusTypeVal) throws Exception {
	  for (int i = 0; i < strStatusTypes.length; i++) {
	   assertFalse(
	     this.page.element(
	       createdStatuaTypesInList + "/input[@name='sort_"
	         + strStatusTypeVal[i]
	         + "']/parent::div[text()='"
	         + strStatusTypes[i] + "']", "xpath")
	       .isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE),
	     "Created status type not displayed.");
	  }
	  return this;
	  
	 }
	 
	 /**********************************************************************************
	  * Description : This function is to navigate to 'Views'
	  * Date        : 20/06/2014
	  * Author      : Yugender
	  **********************************************************************************/
	public ViewsList navigateToViewsListNew() throws Exception {
		this.clickOnSetUp();
		objWaitForElement.waitForElements(viewsLink, "xpath");
		this.page.element(viewsLink, "xpath").getOne().click();
		return new ViewsList(this.driver);
	}
	/**********************************************************************************
	  * Description : This function is to verify the Cancel button
	  * Date        : 23/09/2014
	  * Author      : Sowmya
	  * Modified due change in cancel button Id
	  **********************************************************************************/
	public ViewsList clickOnCancelButton() throws Exception {
		objWaitForElement.waitForElements(cancel, "css");
		this.page.element(cancel, "css").getOne().sendKeys(Keys.ENTER);
		boolean bln = false; int i =0;
		try{
			while(!bln && i<5) {
				bln = this.page.element("input[value='Proceed Without Saving']", "css").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE);
				this.page.element("input[value='Proceed Without Saving']", "css").getOne().click();
			}
		}
		catch(Exception e){

		}
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to verify demote link associated with multi region view
	  * 				is not displayed
	  * Arguement	: strView
	  * Date        : 30-Apr-2015
	  * Author      : Pallavi
	  **********************************************************************************/
	public ViewsList verDemoteLinkAssociatedWithMulRegViewIsNotDisplayed(
			String strView) throws Exception {
		assertFalse(this.page.element(
				"//td[text()='" + strView
						+ "']/preceding-sibling::td/a[text()='Demote']",
				"xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on new view
	  * Date        : 23/06/2014
	  * Author      : Yugender
	  **********************************************************************************/
	public ViewsList navigateToCreatedViewNew(String strViewName) throws Exception {
		this.page
				.dynamicElement(strViewName,
						"//td/a[text()='" + strViewName + "']", "xpath")
				.getOne().click();
		return new ViewsList(this.driver);
	}
	 /**********************************************************************************
	  * Description : This function is to verify view is not displayed.
	  * Date        : 06/08/2014
	  * Author      : Prasanna Lakshmi
	  **********************************************************************************/
	public ViewsList verViewIsNotListedMessage() throws Exception {
		objWaitForElement.waitForElements(
				"//div[@id='viewContainer']/h1[text()='View Not Available']",
				"xpath");
		assertTrue(this.page.element(
				"//div[@id='viewContainer']/h1[text()='View Not Available']",
				"xpath").isElementPresent());
		return this;
	}
	
	 /**********************************************************************
	  * Description : This function is to verify StatusTypeNames
	  * Date        : 11/09/2014
	  * Author      : Anil
	  **********************************************************************/	

	public ViewsList verifyStatusTypeNameInView(String strRTValue,
			String strStatusTypeName) throws Exception {
		objWaitForElement.waitForElements("//table[@id='rtt_" + strRTValue
				+ "']/thead/tr/th/a[text()='" + strStatusTypeName + "']",
				"xpath");
		assertTrue(this.page
				.dynamicElement(
						strStatusTypeName,
						"//table[@id='rtt_" + strRTValue
								+ "']/thead/tr/th/a[text()='"
								+ strStatusTypeName + "']", "xpath").isElementPresent());
		return this;
	}
	/**********************************************************************
	  * Description : This function is to verify StatusTypeNames
	  * Date        : 11/09/2014
	  * Author      : Anil
	  **********************************************************************/	

	public ViewsList verifyResourceTypeNameInView(String strRTValue,
			String strResourceTypeName) throws Exception {
		objWaitForElement.waitForElements("//table[@id='rtt_" + strRTValue
				+ "']/thead/tr/th/a[text()='" + strResourceTypeName + "']",
				"xpath");
		assertTrue(this.page
				.dynamicElement(
						strResourceTypeName,
						"//table[@id='rtt_" + strRTValue
								+ "']/thead/tr/th/a[text()='"
								+ strResourceTypeName + "']", "xpath").getOne()
				.isDisplayed());
		return this;
	}
	/**********************************************************************
	  * Description : This function is to click on resource name and navigate to resource detail page
	  * Date        : 11/09/2014
	  * Author      : Anil
	  **********************************************************************/	

	public ViewsList verifyStatusTypeNameIsNotInUserView(String strRTValue,
			String strStatusTypeName) throws Exception {
		
		assertFalse(this.page.dynamicElement(
				strStatusTypeName,
				"//table[@id='rtt_" + strRTValue + "']/thead/tr/th/a[text()='"
						+ strStatusTypeName + "']", "xpath").isElementPresent(
				WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify delete link associated with multi region view
	  * Arguments	: strView
	  * Date        : 08/09/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList verDeleteLinkNotWithView(String strView) throws Exception {
		assertFalse(this.page.element(
				"//a[text()='Delete']/parent::td/following-sibling::td[text()='"
						+ strView + "']", "xpath").isElementPresent(
				WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify delete link associated with multi region view
	  * Arguments	: strView 
	  * Date        : 08/09/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList verEditAssociatedWithMulRegView(String strView) throws Exception {
		objWaitForElement.waitForElements("//a[text()='Edit']/parent::td/following-sibling::td[text()='"+strView+"']",
				"xpath");
		assertTrue(
				this.page
						.element(
								"//a[text()='Edit']/parent::td/following-sibling::td[text()='"+strView+"']",
								"xpath").isElementPresent(),
				"Edit link with multi region view is not displayed.");
		return this;
	}
	/**********************************************************************************
	  * Description : This function is to verify delete link associated with multi region view
	  * Arguments	: strView
	  * Date        : 08/09/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList verCopyAssociatedWithMulRegView(String strView) throws Exception {
		objWaitForElement.waitForElements("//a[text()='Copy']/parent::td/following-sibling::td[text()='"+strView+"']",
				"xpath");
		assertTrue(
				this.page
						.element(
								"//a[text()='Copy']/parent::td/following-sibling::td[text()='"+strView+"']",
								"xpath").isElementPresent(),
				"Copy link with multi region view is not displayed.");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click status cell
	  * Date        : 23/06/2014
	  * Author      : Anil
	  **********************************************************************************/
	public ViewsList clickOnIndividualUpdateStatus(String strResourceValue, String strStatusTypeValue)
			throws Exception {
		
		Thread.sleep(5000);
		objWaitForElement.waitForElements("//td[@id='v_"+strResourceValue+"_"+strStatusTypeValue+"']",
		"xpath");

		assertTrue(this.page
				.element("//td[@id='v_"+strResourceValue+"_"+strStatusTypeValue+"']",
						"xpath").isElementPresent());
		this.page
				.element("//td[@id='v_"+strResourceValue+"_"+strStatusTypeValue+"']",
						"xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to click on Status Header
	  * Date        : 19-May-2015
	  * Author      : Pallavi
	  **********************************************************************************/
	public ViewsList clickOnStatusHeader(String strStatusTypeValue)
			throws Exception {
		String strStatusHeader = "//th/a[@class='st_" + strStatusTypeValue + "']";
		objWaitForElement.waitForElements(strStatusHeader, "xpath");
		assertTrue(this.page.element(strStatusHeader, "xpath")
				.isElementPresent());
		this.page.element(strStatusHeader, "xpath").getOne().click();
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to verify Status type Name and Definition (description)
	  * 			  on 'Definiton' screen
	  * Date        : 19-May-2015
	  * Author      : Pallavi
	  **********************************************************************************/
	public ViewsList verifyNameAndDefinitionOnDefnScreen(
			String strStatusTypeName, String strStatusDescription)
			throws Exception {
		assertTrue(this.page.element(
				"//body/h1[text()='" + strStatusTypeName + "']", "xpath")
				.isElementPresent());
		String strDefn = this.page
				.element("//body/p/b[text()='Definition:']/parent::p", "xpath")
				.getOne().getText();
		assertTrue(strDefn.contains(strStatusDescription));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify status type is present Under Select 
	  * 			  Status Types section
	  * Date        : 19-May-2015
	  * Author      : Pallavi
	  **********************************************************************************/
	public ViewsList verifyStatusTypeUnderSelectSTSection(String strStatusTypeName) throws Exception {
		String strST = "//td//a[text()='" + strStatusTypeName
				+ "']/ancestor::td/preceding-sibling::td[1]/input";
		objWaitForElement.waitForElements(strST, "xpath");
		assertTrue(this.page.element(strST, "xpath").isElementPresent());
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to verify status type is present Under Sections
	  * 				in resource detail screen.
	  * Date        : 25-May-2015
	  * Author      : Pallavi
	  **********************************************************************************/
	public ViewsList verifyStatusTypeUnderSectionsInResourceDetailPage(
			String strStatusTypeName, String strSectionName) throws Exception {
		String strSTUnderSection = "//table/thead/tr/th/a[text()='"
				+ strSectionName
				+ "']/ancestor::thead/following-sibling::tbody/tr/td/a[text()='"
				+ strStatusTypeName + "']";
		objWaitForElement.waitForElements(strSTUnderSection, "xpath");
		assertTrue(this.page.element(strSTUnderSection, "xpath")
				.isElementPresent());
		return this;
	}
	
	/**********************************************************************
	  * Description : This function is to verify status type updated time in resource detail page
	  * Date        : 11/09/2014
	  * Author      : Anil
	  **********************************************************************/	

	public ViewsList verifyUpdatedTime(String strStatusTypeName, String strUpdatedValue, String strUpdatedTime, String strUserFullName)
			throws Exception {
		objWaitForElement.waitForElements("//table/tbody/tr/td[2]/a[@title='Definition'][text()='"+strStatusTypeName+"']/parent::td/following-sibling::td[1][text()='"+strUpdatedValue+"']", "xpath");
		this.page.element("//table/tbody/tr/td[2]/a[@title='Definition'][text()='"+strStatusTypeName+"']/parent::td/following-sibling::td[1][text()='"+strUpdatedValue+"']", "xpath").mouseOver();	
		objWaitForElement.waitForElements("//div[@id='theToolTip']/h1", "xpath");
		String strValue1 = this.page.element("//div[@id='theToolTip']/h1", "xpath").getOne().getText();
		String strValue2 = this.page.element("//div[@id='theToolTip']/p", "xpath").getOne().getText();
		System.out.println(strValue1);
		System.out.println(strValue2);
		assertEquals(strValue1, strUpdatedTime);
		assertEquals(strValue2, strUserFullName);
		return this;
	}
	
	/**********************************************************************
	  * Description : This function is to verify status type updated time in resource detail page
	  * Date        : 11/09/2014
	  * Author      : Anil
	  **********************************************************************/	

	public ViewsList verifyUpdatedValueAndComments(String strStatusTypeName, String strUpdatedValue, String strComments)
			throws Exception {
		objWaitForElement.waitForElements("//table/tbody/tr/td[2]/a[@title='Definition'][text()='"+strStatusTypeName+"']/parent::td/following-sibling::td[1][text()='"+strUpdatedValue+"']", "xpath");
		assertTrue(this.page.element("//table/tbody/tr/td[2]/a[@title='Definition'][text()='"+strStatusTypeName+"']/parent::td/following-sibling::td[1][text()='"+strUpdatedValue+"']", "xpath").getOne().isDisplayed());
		assertTrue(this.page.element("//table/tbody/tr/td[2]/a[@title='Definition'][text()='"+strStatusTypeName+"']/parent::td/following-sibling::td[2][text()='"+strComments+"']", "xpath").getOne().isDisplayed());
		return this;
	}
	
	
	/**********************************************************************************
	  * Description : This function is to click status cell
	  * Date        : 23/06/2014
	  * Author      : Anil
	  **********************************************************************************/
	public ViewsList verifyUserUpdatedValue(String strResourceValue, String strStatusTypeValue, String strUpdatedTime, String strFullName, String strComments)
			throws Exception {
		
		Thread.sleep(5000);
		objWaitForElement.waitForElements("//td[@id='v_"+strResourceValue+"_"+strStatusTypeValue+"']",
		"xpath");

		this.page
				.element("//td[@id='v_"+strResourceValue+"_"+strStatusTypeValue+"']",
						"xpath").mouseOver();
		
		String strValue1 = this.page.element("//div[@id='theToolTip']/h1", "xpath").getOne().getText();
		String strValue2 = this.page.element("//div[@id='theToolTip']/p", "xpath").getOne().getText();
		String strValue3 = this.page.element("//div[@id='theToolTip']/p[2]", "xpath").getOne().getText();
		System.out.println(strValue1);
		System.out.println(strValue2);
		assertEquals(strValue1, strUpdatedTime);
		assertEquals(strValue2, strFullName);
		assertEquals(strValue3, strComments);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Status type Name and statuses
	  * 			  on 'Definiton' screen
	  * Date        : 29-May-2015
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList verifyNameAndStatusesOnDefnScreen(
			String strStatusTypeName, String strStatusesName)
			throws Exception {
		assertTrue(this.page.element(
				"//body/h1[text()='" + strStatusTypeName + "']", "xpath")
				.isElementPresent());
		String str = this.page.element(
				"//ul/li/strong", "xpath").getOne().getText();
		assertEquals(strStatusesName+":", str);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify status type is present Under Sections
	  * 				in resource detail screen.
	  * Date        : 25-May-2015
	  * Author      : Pallavi
	  **********************************************************************************/
	public ViewsList verifyStatuessInResourceDetailPage(
			String strStatusTypeName, String strSectionName, String strStatusName) throws Exception {
		String strSTUnderSection = "//table/thead/tr/th/a[text()='"
				+ strSectionName
				+ "']/ancestor::thead/following-sibling::tbody/tr/td[2]/a[text()='"
				+ strStatusTypeName + "']/parent::td/following-sibling::td[text()='"+strStatusName+"']";
		objWaitForElement.waitForElements(strSTUnderSection, "xpath");
		assertTrue(this.page.element(strSTUnderSection, "xpath")
				.isElementPresent());
		return this;
	}
	/**********************************************************************
	  * Description : This function is to click on edit resource detail link
	  * Date        : 02/Jun/2015
	  * Author      : Anitha
	 **********************************************************************/	
	public ViewsList verifyEditResourceDetailsLinkIsNotPresent()
			throws Exception {
		assertFalse(this.page.element(editResDetailLink, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************
	  * Description : This function is to click on edit resource detail link
	  * Date        : 02/Jun/2015
	  * Author      : Anitha
	 **********************************************************************/	
	public ViewsList verifyEditResourceDetailsLinkIsPresent() throws Exception {
		objWaitForElement.waitForElements(editResDetailLink, "xpath");
		assertTrue(this.page.element(editResDetailLink, "xpath")
				.isElementPresent());
		return this;
	}

	/**********************************************************************
	  * Description : This function is to click on edit resource detail link
	  * Date        : 02/Jun/2015
	  * Author      : Renushere
	 **********************************************************************/	
	public ViewsList clickOnEditResourceDetailsLink() throws Exception {
		objWaitForElement.waitForElements(editResDetailLink, "xpath");
		this.page.element(editResDetailLink, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to get View Name
	  * Date        : 20/06/2014
	  * Author      : Anil
	  **********************************************************************************/
	public ViewsList verifyViewName(String strViewName) throws Exception {
		objWaitForElement.waitForElements(viewName, "xpath");
		String strValue = this.page.element(viewName, "xpath").getOne().getAttribute("value");
		assertEquals(strValue, strViewName);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to get View dexcription
	  * Date        : 20/06/2014
	  * Author      : Anil
	  **********************************************************************************/
	public ViewsList verifyViewDescription(String strViewDescription) throws Exception {
		objWaitForElement.waitForElements(viewDesc, "xpath");
		String strValue = this.page.element(viewDesc, "xpath").getOne().getAttribute("value");
		assertEquals(strValue, strViewDescription);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on submit of edited section name.
	  * Arguments	: strSectionName
	  * Date        : 11/08/2014
	  * Author      : Anil
	  **********************************************************************************/
	public ViewsList verifyAssignUsersToViewPage(String strViewName) throws Exception {
		objWaitForElement.waitForElements("//div[@id='topSubNav']/h1[text()='Assign Users to View "+strViewName+"']", "xpath");
		assertTrue(this.page.element("//div[@id='topSubNav']/h1[text()='Assign Users to View "+strViewName+"']", "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on security checkbox
	  * Date        : 20/06/2014
	  * Author      : Anil
	  **********************************************************************************/
	public ViewsList deselectSecurityCheckbox() throws Exception {
		objWaitForElement.waitForElements(visibleToAll, "id");
		if(this.page.element(visibleToAll, "id").getOne().isSelected()==true){
			this.page.element(visibleToAll, "id").getOne().click();
		}		
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on security checkbox
	  * Date        : 20/06/2014
	  * Author      : Anil
	  **********************************************************************************/
	public ViewsList verifySecurityCheckboxisSelected() throws Exception {
		objWaitForElement.waitForElements(visibleToAll, "id");
		assertTrue(this.page.element(visibleToAll, "id").getOne().isSelected());	
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify users checkbox
	  * Date        : 20/06/2014
	  * Author      : Anil
	  **********************************************************************************/
	public ViewsList verifyUsersCheckBoxIsdisabled(String strUsername)
			throws Exception {
		objWaitForElement.waitForElements("input[name='userID'][value='"
				+ strUsername + "']", "css");
		assertTrue(this.page
				.element("input[name='userID'][value='" + strUsername + "']",
						"css").getOne().isEnabled() == false);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify users checkbox Date : 20/06/2014
	 * Author : Anil Modified due change in User element Id
	 **********************************************************************************/
	public ViewsList verifyUsersCheckBoxIsEnabled(String strUsername)
			throws Exception {
		String userChkBox = "//input[@value='" + strUsername
				+ "'][@type='checkbox']";
		objWaitForElement.waitForElements(userChkBox, "xpath");
		assertTrue(this.page.element(userChkBox, "xpath").getOne().isEnabled());
		return this;
	}
	
	
	/**********************************************************************************
	  * Description : This function is to verify users checkbox
	  * Date        : 20/06/2014
	  * Author      : Anil
	  * Modified due change in User element Id
	  **********************************************************************************/
	public ViewsList selectUsersCheckBoxinAssigUsers(String strUsername)
			throws Exception {
		this.deselectAllUsersCheckBox();
		String selUser = "//input[@value='" + strUsername
				+ "'][@type='checkbox']";

		objWaitForElement.waitForElements(selUser, "xpath");
		if (this.page.element(selUser, "xpath").getOne().isSelected() == false) {
			this.page.element(selUser, "xpath").getOne().click();
		}

		if (this.page.element(selUser, "xpath").getOne().isSelected() == false) {
			this.page.element(selUser, "xpath").getOne().sendKeys(Keys.ENTER);
		}
		assertTrue(this.page.element(selUser, "xpath").getOne().isSelected());
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to verify users checkbox
	  * Date        : 20/06/2014
	  * Author      : Anil
	  **********************************************************************************/
	public ViewsList verifyUsersCheckBoxIsDeselected() throws Exception {
		objWaitForElement.waitForElements(usersCheckBox, "css");
		assertTrue(this.page.element(usersCheckBox, "css").getOne().isEnabled()==false);	
		return this;
	}
	/**********************************************************************************
	  * Description : This function is to verify users checkbox
	  * Date        : 20/06/2014
	  * Author      : Anil
	  **********************************************************************************/
	public ViewsList verifyUsersCheckBoxIsSelected() throws Exception {
		objWaitForElement.waitForElements(usersCheckBox, "css");
		assertTrue(this.page.element(usersCheckBox, "css").getOne().isEnabled());	
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is used to drag and drop views
	  * Arguments	: strViewName, strViewName2
	  * Date        : 06/08/2014
	  * Author      : Anil
	  **********************************************************************************/
	public ViewsList dragAndDropViews(String strViewName,
			String strViewName2) throws Exception {
		objWaitForElement.waitForElements("//td[text()='"+strViewName+"']", "xpath");
		WebElement element = this.page.element("//td[text()='"+strViewName+"']", "xpath")
				.getOne();
		this.page.element("//td[text()='"+strViewName2+"']", "xpath").dragAndDrop(element);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on reorder views
	  * Date        : 20/06/2014
	  * Author      : Anil
	  **********************************************************************************/
	public ViewsList clickOnReorderViews() throws Exception {
		objWaitForElement.waitForElements(reOrderViews, "css");
		this.page.element(reOrderViews, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on done reorder views
	  * Date        : 20/06/2014
	  * Author      : Anil
	  **********************************************************************************/
	public ViewsList verifyOndoneReOrderingViews() throws Exception {
		objWaitForElement.waitForElements(doneReOrdering, "css");
		assertTrue(this.page.element(doneReOrdering, "css").getOne().isDisplayed());
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to verify error message
	  * Date        : 20/06/2014
	  * Author      : Anil
	  **********************************************************************************/
	public ViewsList verifyErrorMessage() throws Exception {
		objWaitForElement.waitForElements(warningMessage1, "xpath");
		String strValue = this.page.element(warningMessage1, "xpath").getOne().getText();
		assertEquals(strValue, "You must click on the 'Save' button below to save your view order changes.");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify error message
	  * Date        : 20/06/2014
	  * Author      : Anil
	  **********************************************************************************/
	public ViewsList verifyErrorMessage2() throws Exception {
		objWaitForElement.waitForElements(warningMessage2, "xpath");
		String strValue = this.page.element(warningMessage2, "xpath").getOne().getText();
		assertEquals(strValue, "Click on the 'Cancel' button below to undo your view order changes.");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Copy' link of View
	 * Date        : 19/06/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public ViewsList clickOnCopyLinkOfView(String strViewName) throws Exception {
		objWaitForElement.waitForElements("//table[@id='listViews']/tbody/tr/td[text()='"
				+ strViewName + "']/"
				+ "preceding-sibling::td/a[text()='Copy']",
		"xpath");
		this.page
				.element(
						"//table[@id='listViews']/tbody/tr/td[text()='"
								+ strViewName + "']/"
								+ "preceding-sibling::td/a[text()='Copy']",
						"xpath").getOne().sendKeys(Keys.ENTER);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Delete' link of View
	 * Date        : 19/06/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public ViewsList clickOnDeleteLinkOfView(String strViewName) throws Exception {
		objWaitForElement.waitForElements("//table[@id='listViews']/tbody/tr/td[text()='"
				+ strViewName + "']/"
				+ "preceding-sibling::td/a[text()='Copy']",
		"xpath");
		this.page
				.element(
						"//table[@id='listViews']/tbody/tr/td[text()='"
								+ strViewName + "']/"
								+ "preceding-sibling::td/a[text()='Delete']",
						"xpath").getOne().sendKeys(Keys.ENTER);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is used to drag and drop views
	  * Arguments	: strViewName, strViewName2
	  * Date        : 06/08/2014
	  * Author      : Anil
	  **********************************************************************************/
	public String[] dragAndDropLastTwoViews() throws Exception {
		objWaitForElement.waitForElements("//tr[last()]/td[2]", "xpath");
		String[] strValues = new String[2];
		strValues[0] = this.page.element("//tr[last()]/td[2]", "xpath")
				.getOne().getAttribute("value");
		strValues[1] = this.page.element("//tr[last()-1]/td[2]", "xpath")
				.getOne().getAttribute("value");
		WebElement element = this.page.element("//tr[last()]/td[2]", "xpath")
				.getOne();
		this.page.element("//tr[last()-1]/td[2]", "xpath").dragAndDrop(element);
		return strValues;
	}
	
	
	/**********************************************************************************
	  * Description : This function is used to drag and drop views
	  * Arguments	: strViewName, strViewName2
	  * Date        : 06/08/2014
	  * Author      : Anil
	  **********************************************************************************/
	public String[] verifyLastTwoViewsOrder(String[] strViewNames) throws Exception {
		objWaitForElement.waitForElements("//tr[last()]/td[2]", "xpath");
		String[] strValues = new String[2];
		strValues[0] = this.page.element("//tr[last()]/td[2]", "xpath")
				.getOne().getAttribute("value");
		strValues[1] = this.page.element("//tr[last()-1]/td[2]", "xpath")
				.getOne().getAttribute("value");
		assertEquals(strViewNames[0], strValues[1]);
		assertEquals(strViewNames[1], strValues[0]);
		return strValues;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Create New View page is displayed
	  * Date        : 11/06/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList verCreateNewViewPageIsDisplayed() throws Exception {
		objWaitForElement.waitForElements("//div[@id='topSubNav']/h1[text()='Create New View']", "xpath");
		assertEquals("Create New View", this.page.element(headerName, "css").getOne().getText(),
				"Create New View page is not displayed.");
		return this;
	}
	/**********************************************************************************
	  * Description : This function is to deselect resource
	  * Date        : 20/06/2014
	  * Author      : Yugender
	  **********************************************************************************/
	public ViewsList deselectResource(String strResource) throws Exception {
		String strElement = "//table[@id='grid']/tbody/tr/td[2]/span[text()='"
				+ strResource
				+ "']/parent::td/preceding-sibling::td[1]/input";
		objWaitForElement.waitForElements(strElement, "xpath");
		if(this.page.element(
						strElement, "xpath")
				.getOne().isSelected()==true){
		this.page
				.element(strElement, "xpath")
				.getOne().click();
		}
		return this;
	}
	
	/**********************************************************************
	  * Description : This function is to deselect status type
	  * Date        : 28/07/2014
	  * Author      : Anil
	  **********************************************************************/	

	public ViewsList deselectStatusTypeForView(String[] strStatusTypeValue)
			throws Exception {
		objWaitForElement.waitForElements("//input[@value='" + strStatusTypeValue[0]
				+ "'][@name='statusTypeID']", "xpath");
		for (int i = 0; i < strStatusTypeValue.length; i++) {
			if(this.page
					.element(
							"//input[@value='" + strStatusTypeValue[i]
									+ "'][@name='statusTypeID']", "xpath")
					.getOne().isSelected()==true){
			this.page.element(
					"//input[@value='" + strStatusTypeValue[i]
							+ "'][@name='statusTypeID']", "xpath").mouseOver();
			this.page
					.element(
							"//input[@value='" + strStatusTypeValue[i]
									+ "'][@name='statusTypeID']", "xpath")
					.getOne().sendKeys(Keys.SPACE);
			}
		}
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify update status key is not displayed
	  * Date        : 16/06/2015
	  * Author      : Anil
	  **********************************************************************************/
	public ViewsList verifyUpdateStatusKeyIsNotDisplayed(String strResourceName)
			throws Exception {	
		assertFalse(this.page
				.element(
						"//div[@id='viewContainer']/table/tbody/tr/td[2]/a[text()='"
								+ strResourceName
								+ "']/parent::td/preceding-sibling::td/a/img[@title='Update Status']",
						"xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));

		return this;
	}
	
	/**********************************************************************
	  * Description : This function is to click on key icon 
	  * Date        : 11/09/2014
	  * Author      : Anitha
	  *********************************************************************/	
	public ViewsList clickOnKeyIcon() throws Exception {
		objWaitForElement.waitForElements("img.noprint", "css");
		this.page.element("img.noprint", "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify emresource warning message.
	  * Date        : 08/09/2014
	  * Author      : Anitha
	  **********************************************************************************/
	public ViewsList verUnauthorizedErrorMsg() throws Exception {
		objWaitForElement.waitForElements(
				"//div[@id='mainContainer']/h2[text()='You are not authorized to update any statuses for this resource.']",
				"xpath");
		assertTrue(this.page
				.element(
						"//div[@id='mainContainer']/h2[text()='You are not authorized to update any statuses for this resource.']",
						"xpath").isElementPresent());

		assertTrue(this.page.element(
				"//div[@id='mainContainer']/a[text()='Return to View']",
				"xpath").isElementPresent());

		return this;
	}
	/**********************************************************************************
	* Description  	: This function is to navigate to 'Statsu change prefernce' in 'Preferences'
	* Date 			: 23/09/2014
	* Author 		: Anitha
	**********************************************************************************/
	public ViewsList clickOnReturnToView()
			throws Exception {
		objWaitForElement.waitForElements(ReturnToViewLink, "linktext");
		this.page.element(ReturnToViewLink, "linktext").getOne().click();
		return this;
	}

	 /**********************************************************************
	  * Description : This function is to verify StatusTypeNames
	  * Date        : 21-Jul-2015
	  * Author      : Renushree
	  **********************************************************************/	
	public ViewsList verResAndStatuaTypesWithValue(String strResTypeVal,
			String strResName, String strStatusTypeName, String strValue)
			throws Exception {
		assertTrue(
				this.page.element(
						"//table[@id='rtt_" + strResTypeVal
								+ "']/thead/tr/th/a[text()='"
								+ strStatusTypeName
								+ "']/ancestor::table/tbody/tr/td[text()='"
								+ strValue
								+ "']/preceding-sibling::td/a[text()='"
								+ strResName + "']", "xpath")
						.isElementPresent(),
				"N/A is not displayed for status type.");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify status type is not present Under Sections
	  * 				in resource detail screen.
	  * Date        : 21-Jul-2015
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList verifyStatusTypeIsNotUnderSectionsInResourceDetailPage(
			String strStatusTypeName, String strSectionName) throws Exception {
		String strSTUnderSection = "//table/thead/tr/th/a[text()='"
				+ strSectionName
				+ "']/ancestor::thead/following-sibling::tbody/tr/td/a[text()='"
				+ strStatusTypeName + "']";
		assertFalse(this.page.element(strSTUnderSection, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	 /**********************************************************************
	  * Description : This function is to verify StatusTypeNames
	  * Date        : 21-Jul-2015
	  * Author      : Renushree
	  **********************************************************************/	
	public ViewsList verResAndStatusTypes(String strResTypeVal,
			String strResName, String strStatusTypeName) throws Exception {
		String strElement = "//table[@id='rtt_" + strResTypeVal
				+ "']/thead/tr/th/a[text()='" + strStatusTypeName
				+ "']/ancestor::table/tbody/tr/td/a[text()='" + strResName
				+ "']";
		objWaitForElement.waitForElements(strElement, "xpath");
		assertTrue(this.page.element(strElement, "xpath").isElementPresent(),
				"ST is not displayed for Res.");
		return this;
	}
	
	/**********************************************************************
	  * Description : This function is to verify StatusTypeNames
	  * Date        : 21-Jul-2015
	  * Author      : Renushree
	  **********************************************************************/	
	public ViewsList verStatusTypesNotDisplayedWithRes(String strResTypeVal,
			String strResName, String strStatusTypeName)
			throws Exception {
		assertFalse(
				this.page.element(
						"//table[@id='rtt_" + strResTypeVal
								+ "']/thead/tr/th/a[text()='"
								+ strStatusTypeName
								+ "']/ancestor::table/tbody/tr/td/a[text()='"
								+ strResName + "']", "xpath")
						.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE),
				"N/A is not displayed for status type.");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on ST in resource detail page to update
	  * Date        : 22-Jul-2015
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList selStatusTypeInResDetailScreenToUpdate(
			String strStatusTypeName, String strResValue,
			String strStatusTypeVal) throws Exception {
		String strSTUnderSection = "//table/tbody/tr/td/a[text()='"
				+ strStatusTypeName
				+ "']/parent::td/following-sibling::td[@id='v_" + strResValue
				+ "_" + strStatusTypeVal + "']";
		objWaitForElement.waitForElements(strSTUnderSection, "xpath");
		this.page.element(strSTUnderSection, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on ST in resource detail page to update
	  * Date        : 22-Jul-2015
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList verStatusTypeCannotUpdate(String strRestYpeVal,
			String strStatusTypeName, String strResValue,
			String strStatusTypeVal) throws Exception {
		String strSTUnderSection = "//table[@id='rtt_" + strRestYpeVal
				+ "']/thead/tr/th/a[text()='" + strStatusTypeName
				+ "']/ancestor::table/tbody/tr/td[@id='v_" + strResValue + "_"
				+ strStatusTypeVal
				+ "'][@class='addToolTipText statusWhite editable']";
		assertFalse(this.page.element(strSTUnderSection, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE),
				"ST can be update");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on ST in resource detail page to update
	  * Date        : 22-Jul-2015
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList verSTCannotUpdateInResDetailPage(
			String strStatusTypeName, String strResValue,
			String strStatusTypeVal) throws Exception {
		String strSTUnderSection = "//table/tbody/tr/td/a[text()='"
				+ strStatusTypeName
				+ "']/parent::td/following-sibling::td[@id='v_" + strResValue
				+ "_" + strStatusTypeVal + "'][@class='addToolTipText statusWhite editable']";
		assertFalse(this.page.element(strSTUnderSection, "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE),
				"ST can be update");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify create new View, reorder and Customize Resource detail button
	  * Date        : 31/08/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList verCreateNewViewReorderAndCustomizeDetailViewButton()
			throws Exception {
		objWaitForElement.waitForElements(createNewView, "xpath");
		assertTrue(this.page.element(createNewView, "xpath").isElementPresent(), "Create new view button not displayed");
		assertTrue(this.page.element(reOrderViews, "css").isElementPresent(), "Reorder button not displayed");
		assertTrue(this.page.element(customizeResourceDetailView, "css")
				.isElementPresent(), "Customize resource detial view button not displayed");
		return this;
	}
	
	/**********************************************************************
	  * Description : This function is to verify update key icon 
	  * Date        : 31/08/2015
	  * Author      : Renushree
	  *********************************************************************/	
	public ViewsList verUpdateKeyIcon() throws Exception {
		objWaitForElement.waitForElements("img.noprint", "css");
		assertTrue(this.page.element("img.noprint", "css").isElementPresent(),
				"Update Key icon not dispalyed");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Update Status of sub resource
	  * Date        : 23/09/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList verUpdateStatusOfSubResource(String strSubResourceName)
			throws Exception {
		objWaitForElement.waitForElements("//a[text()='"
				+ strSubResourceName
				+ "']/parent::td/preceding-sibling::td/a/img[@title='Update Status']",
		"xpath");
		assertTrue(this.page
				.dynamicElement(
						strSubResourceName,
						"//a[text()='"
								+ strSubResourceName
								+ "']/parent::td/preceding-sibling::td/a/img[@title='Update Status']",
						"xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify updated values
	  * Date        : 31/08/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList verifyUpdatedValue(String strResourceValue, String strStatusTypeValue, String strUpdatedVal)
			throws Exception {
		objWaitForElement.waitForElements("//td[@id='v_"+strResourceValue+"_"+strStatusTypeValue+"']",
		"xpath");
		this.page
				.element("//td[@id='v_"+strResourceValue+"_"+strStatusTypeValue+"']",
						"xpath").mouseOver();
		assertEquals(strUpdatedVal, this.page
				.element("//td[@id='v_"+strResourceValue+"_"+strStatusTypeValue+"']",
						"xpath").getOne().getText());
		return this;
	}
	/**********************************************************************************
	  * Description : This function is to select resource
	  * Date        : 20/06/2014
	  * Author      : Yugender
	  **********************************************************************************/
	public ViewsList VerResourceInCreateViewPage(String strResource)
			throws Exception {
		objWaitForElement
				.waitForElements(
						"//table[@id='grid']/tbody/tr/td[2]/span[text()='"+strResource+"']/parent::td/preceding-sibling::td[1]/input",
						"xpath");
		assertTrue(this.page
				.element("//table[@id='grid']/tbody/tr/td[2]/span[text()='"+strResource+"']/parent::td/preceding-sibling::td[1]/input",
						"xpath").isElementPresent());
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to select resource
	  * Date        : 20/06/2014
	  * Author      : Yugender
	  **********************************************************************************/
	public ViewsList VerSubResourceNotInCreateView(String strResource)
			throws Exception {
		assertFalse(this.page
				.element("//table[@id='grid']/tbody/tr/td[2]/span[text()='"+strResource+"']/parent::td/preceding-sibling::td[1]/input",
						"xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	/**********************************************************************************
	  * Description : This function is to select resource
	  * Date        : 20/06/2014
	  * Author      : Anitha
	  **********************************************************************************/
	public ViewsList VerViewInViewList(String strViewName)
			throws Exception {
		objWaitForElement
				.waitForElements(
						"//table[@id='listViews']/tbody/tr/td[text()='"+strViewName+"']",
						"xpath");
		assertTrue(this.page
				.element("//table[@id='listViews']/tbody/tr/td[text()='"+strViewName+"']",
						"xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************
	  * Description : This function is to verify update key icon 
	  * Date        : 01/09/2015
	  * Author      : Renushree
	  *********************************************************************/	
	public ViewsList verUpdateKeyIconNotDispalyed() throws Exception {
		assertFalse(
					this.page.element("//img[@title='Update Status']", "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE),
					"Update Key icon is dispalyed");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Update Status of sub resource is not displayed
	  * Date        : 23/09/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList verUpdateStatusOfSubResourceNotDisplayed(
			String strSubResourceName) throws Exception {
		assertFalse(this.page
				.element(
						"//a[text()='"
								+ strSubResourceName
								+ "']/parent::td/preceding-sibling::td/img[@title='Update Status']",
						"xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify Update Status of sub resource is not displayed
	  * Date        : 23/09/2014
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList verAssociatedUsrInContactTable(String strUserFullName)
			throws Exception {
		assertTrue(this.page
				.element(
						"//table[@id='contacts']/tbody/tr/td[text()='"
								+ strUserFullName + "']", "xpath").getOne()
				.isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify sub resource is not displayed in resource detail view
	  * Date        : 07/09/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList verSubResourceNotDisplayedInResourceDetailView(
			String strSubResourceName) throws Exception {
		assertFalse(this.page.element(
				"//a[text()='" + strSubResourceName + "']", "xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select status type
	  * Date        : 05/01/2016
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList verStatusTypeInViewUnderSetup(String strStatusTypes)
			throws Exception {
		objWaitForElement.waitForElements("//td//a[text()='" + strStatusTypes
				+ "']", "xpath");
		assertTrue(
				this.page.dynamicElement(strStatusTypes,
						"//td//a[text()='" + strStatusTypes + "']", "xpath")
						.isElementPresent(), "ST not Displayed");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify updated values
	  * Date        : 31/08/2015
	  * Author      : Anil
	  **********************************************************************************/
	public ViewsList verifyUpdatedValueGreenColor(String strResourceValue, String strStatusTypeValue, String strUpdatedVal)
			throws Exception {
		objWaitForElement.waitForElements("//td[@id='v_"+strResourceValue+"_"+strStatusTypeValue+"'][@class='addToolTipText statusGreen editable']",
		"xpath");
		this.page
				.element("//td[@id='v_"+strResourceValue+"_"+strStatusTypeValue+"'][@class='addToolTipText statusGreen editable']",
						"xpath").mouseOver();
		assertEquals(strUpdatedVal, this.page
				.element("//td[@id='v_"+strResourceValue+"_"+strStatusTypeValue+"']",
						"xpath").getOne().getText());
		return this;
	}
	
	/**********************************************************************
	  * Description : This function is to verify status type updated time in resource detail page
	  * Date        : 11/09/2014
	  * Author      : Anil
	  **********************************************************************/	

	public ViewsList verifyUpdatedValuesInResourceDetailPage(String strStatusTypeName, String strUpdatedValue)
			throws Exception {
		objWaitForElement.waitForElements("//table/tbody/tr/td[2]/a[@title='Definition'][text()='"+strStatusTypeName+"']/parent::td/following-sibling::td[1][text()='"+strUpdatedValue+"']", "xpath");
		assertTrue(this.page.element("//table/tbody/tr/td[2]/a[@title='Definition'][text()='"+strStatusTypeName+"']/parent::td/following-sibling::td[1][text()='"+strUpdatedValue+"']", "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to select status types in Views page
	 * Date 		: 04/Feb/2016
	 * Author 		: Anitha
	 **********************************************************************************/
	public ViewsList verifyStatusTypesViewsPage(String[] strStatusTypeValues)
			throws Exception {
		for (int i = 0; i < strStatusTypeValues.length; i++) {
			objWaitForElement.waitForElements("//input[@value='"
					+ strStatusTypeValues[i] + "'][@name='statusTypeID']", "xpath");		
			assertTrue(this.page
					.dynamicElement(
							"StatusTypeValues",
							"//input[@value='" + strStatusTypeValues[i]
									+ "'][@name='statusTypeID']", "xpath").getOne()
					.isDisplayed());
		}
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select on Sub resource
	  * Date        : 09/Feb/2016
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList deselectSubResourceCheckBox(String strSubResourceValue, String strSubRTValue) throws Exception {
		objWaitForElement.waitForElements( "//input[@value='"+strSubResourceValue+"'][@name='g_"+strSubRTValue+"']", "xpath");
		if(this.page.element("//input[@value='"+strSubResourceValue+"'][@name='g_"+strSubRTValue+"']", "xpath").getOne().isSelected()==true){
			this.page.element("//input[@value='"+strSubResourceValue+"'][@name='g_"+strSubRTValue+"']", "xpath").getOne().click();
		}
		return this;
	}
	
	/**********************************************************************
	  * Description : This function is to verify sub resorce type not dispalyed in resource detail screen
	  * Date        : 09/Feb/2016
	  * Author      : Renushree
	  **********************************************************************/	
	public ViewsList verifySubResTypeNotInResDetailView(String strRTValue)
			throws Exception {
		assertFalse(this.page.element("//table[@id='rtt_" + strRTValue + "']",
				"xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select on Sub resource
	  * Date        : 10/Feb/2016
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList selectSubResourceCheckBoxWithSubRTValue(
			String strSubResourceValue, String strSubRTValue) throws Exception {
		objWaitForElement.waitForElements("//input[@value='"
				+ strSubResourceValue + "']", "xpath");
		this.page.element(
				"//input[@value='" + strSubResourceValue + "'][@name='g_"
						+ strSubRTValue + "']", "xpath").mouseOver();
		this.page
				.element(
						"//input[@value='" + strSubResourceValue
								+ "'][@name='g_" + strSubRTValue + "']",
						"xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify sub resource is not displayed in resource detail view
	  * Date        : 07/09/2015
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList verSubResourceTableNotDisplayedInResourceDetail(
			String strSubRTVal) throws Exception {
		assertFalse(this.page.element("//table[@id='rtt_" + strSubRTVal + "']",
				"xpath")
				.isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select region name while creating views
	  * Date        : 07/09/2015
	  * Author      : Anil
	  **********************************************************************************/
	public ViewsList selectRegionName(String strRegionName) throws Exception {
		objWaitForElement.waitForElements("//span[text()='"+strRegionName+"']/preceding-sibling::input", "xpath");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='"+strRegionName+"']/preceding-sibling::input"))));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[text()='"+strRegionName+"']/preceding-sibling::input"))));
		if(this.page.element("//span[text()='"+strRegionName+"']/preceding-sibling::input", "xpath").getOne().isSelected()==false){
			this.page.element("//span[text()='"+strRegionName+"']/preceding-sibling::input", "xpath").getOne().click();
		}
		Thread.sleep(4000);
		return this;
	}
	/**********************************************************************************
	  * Description : This function is to click on next button
	  * Date        : 07/09/2015
	  * Author      : Anil
	  **********************************************************************************/
	public ViewsList clickNextButton() throws Exception {
		Thread.sleep(1000);
		objWaitForElement.waitForElements(nextButton, "xpath");
		this.page.element(nextButton, "xpath").getOne().click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='TB_load']/img[@src='/img/loadingAnimation.gif']")));
		Thread.sleep(2000);
		return this;
	}

	/**********************************************************************************
	  * Description : This function is to get region name
	  * Date        : 07/09/2015
	  * Author      : Anil
	  **********************************************************************************/
	public String getRegionNameFromHeader() throws Exception {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='TB_load']/img[@src='/img/loadingAnimation.gif']")));
		String strRegionName[]  = new String[2];
			String strRegionName1 = this.page.element(regionLink, "xpath").getOne().getText();
			strRegionName = strRegionName1.split(" ");
			strRegionName[0] = strRegionName[0].trim();
		return strRegionName[0];
	}
	
	
	/**********************************************************************************
	  * Description : This function is to create view
	  * Date        : 07/09/2015
	  * Author      : Anil
	  **********************************************************************************/
	public ViewsList createView(String strViewName, String strViewDesc, String strResourceName, String strStatusTypeNames[]) throws Exception {
		this.clickCreateNewViewButton();
		//Thread.sleep(20000);
		this.enterViewName(strViewName);
		this.enterViewDesc(strViewDesc);
		this.clickNextButton();
		String strRegionName = this.getRegionNameFromHeader();
		this.selectRegionName(strRegionName);
		this.clickNextButton();
		//Thread.sleep(20000);
		this.selectResource(strResourceName);
		//Thread.sleep(10000);
		this.clickNextButton();
		for (int i = 0; i < strStatusTypeNames.length; i++) {	
			this.selectStatusType(strStatusTypeNames[i]);
		}
		this.clickOnSaveOfCreateNewView();
		Thread.sleep(20000);
		this.verViewInList(strViewName);
		return this;
	}
	
	
	/**********************************************************************************
	  * Description : This function is to create view
	  * Date        : 07/09/2015
	  * Author      : Anil
	  **********************************************************************************/
	public ViewsList createView(String strViewName, String strViewDesc, String strResourceName, String strStatusTypeNames) throws Exception {
		this.clickCreateNewViewButton();
		Thread.sleep(2000);
		this.enterViewName(strViewName);
		this.enterViewDesc(strViewDesc);
		this.clickNextButton();
		String strRegionName = this.getRegionNameFromHeader();
		this.selectRegionName(strRegionName);
		this.clickNextButton();
		this.selectResource(strResourceName);
		Thread.sleep(2000);
		this.clickNextButton();
		Thread.sleep(2000);
		this.selectStatusType(strStatusTypeNames);
		this.clickOnSaveOfCreateNewView();
		this.verViewInList(strViewName);
		return this;
	}
	
	
	/**********************************************************************************
	  * Description : This function is to create view
	  * Date        : 07/09/2015
	  * Author      : Anil
	  **********************************************************************************/
	public ViewsList createViewForMultipleResourcesAndStatusTypes(String strViewName, String strViewDesc, String strResourceName[], String strStatusTypeNames[]) throws Exception {
		this.clickCreateNewViewButton();
		this.enterViewName(strViewName);
		this.enterViewDesc(strViewDesc);
		this.clickNextButton();
		String strRegionName = this.getRegionNameFromHeader();
		this.selectRegionName(strRegionName);
		this.clickNextButton();
		for (int i = 0; i < strResourceName.length; i++) {	
			this.selectResource(strResourceName[i]);
		}
		this.clickNextButton();
		for (int i = 0; i < strStatusTypeNames.length; i++) {	
			this.selectStatusType(strStatusTypeNames[i]);
		}
		this.clickOnSaveOfCreateNewView();
		this.verViewInList(strViewName);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to create view
	  * Date        : 07/09/2015
	  * Author      : Anil
	  **********************************************************************************/
	public ViewsList createViewForMultipleResources(String strViewName, String strViewDesc, String strResourceName[], String strStatusTypeNames) throws Exception {
		this.clickCreateNewViewButton();
		this.enterViewName(strViewName);
		this.enterViewDesc(strViewDesc);
		this.clickNextButton();
		String strRegionName = this.getRegionNameFromHeader();
		this.selectRegionName(strRegionName);
		this.clickNextButton();
		for (int i = 0; i < strResourceName.length; i++) {	
			this.selectResource(strResourceName[i]);
		}
		this.clickNextButton();
		this.selectStatusType(strStatusTypeNames);
		this.clickOnSaveOfCreateNewView();
		this.verViewInList(strViewName);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on Status Types Tab while creating/Edit View
	  * Date        : 09-Mar-2016
	  * Author      : Pallavi
	  **********************************************************************************/
	public ViewsList clickOnSTTab() throws Exception {
		objWaitForElement.waitForElements(statusTypeTab, "xpath");
		this.page.element(statusTypeTab, "xpath").getOne().sendKeys(Keys.ENTER);
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on Resources Tab while creating/Edit View
	  * Date        : 09-Mar-2016
	  * Author      : Pallavi
	  **********************************************************************************/
	public ViewsList clickOnResourcesTab() throws Exception {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='TB_load']/img[@src='/img/loadingAnimation.gif']")));
		objWaitForElement.waitForElements(resourcesTab, "xpath");
		this.page.element(resourcesTab, "xpath").getOne().sendKeys(Keys.ENTER);
		this.page.element_wait("//div[@id='TB_load']/img", "xpath").waitForInvisibilityOfElement();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to de-select status types
	  * Date        : 09-Mar-2016
	  * Author      : Pallavi
	  **********************************************************************************/
	public ViewsList deSelectStatusType(String strStatusTypes) throws Exception {
		String strElement = "//td//a[text()='" + strStatusTypes
				+ "']/ancestor::td/preceding-sibling::td[1]/input";
		objWaitForElement.waitForElements(strElement, "xpath");
		if (this.page.element(strElement, "xpath").getOne().isSelected() == true) {
			this.page.element(strElement, "xpath").getOne().sendKeys(Keys.SPACE);
			assertFalse(this.page.element(strElement, "xpath").getOne()
					.isSelected());
		}
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on Regions Tab while creating/Edit View
	  * Date        : 09-Mar-2016
	  * Author      : Pallavi
	  **********************************************************************************/
	public ViewsList clickOnRegionsTab() throws Exception {
		objWaitForElement.waitForElements(regionsTab, "xpath");
		this.page.element(regionsTab, "xpath").getOne().click();
		this.page.element_wait("//div[@id='TB_load']/img", "xpath").waitForInvisibilityOfElement();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify users not displyed in contact table of resource detail screen
	  * Date        : 14/03/2016
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList verAssociatedUsrNotInContactTable(String strUserFullName)
			throws Exception {
		assertFalse(this.page.element(
				"//table[@id='contacts']/tbody/tr/td[text()='"
						+ strUserFullName + "']", "xpath").isElementPresent(
				WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify summary table is displayed for the resource type
	  * Date        : 14/03/2016
	  * Author      : Anil
	  **********************************************************************************/
	public ViewsList verifySummaryTableIsDisplayed(String strResourceTypeName)
			throws Exception {
		objWaitForElement.waitForElements("//a[text()='"+strResourceTypeName+"']/ancestor::thead/following-sibling::tbody/tr[2]/td[text()='Summary']", "xpath");
		assertTrue(this.page.element("//a[text()='"+strResourceTypeName+"']/ancestor::thead/following-sibling::tbody/tr[2]/td[text()='Summary']", "xpath").getOne().isDisplayed());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify summary table is displayed for the resource type
	  * Date        : 14/03/2016
	  * Author      : Anil
	  **********************************************************************************/
	public ViewsList verifyValueDisplayedInSummary(String strResourceTypeName, String strValue)
			throws Exception {
		objWaitForElement.waitForElements("//a[text()='"+strResourceTypeName+"']/ancestor::thead/following-sibling::tbody/tr[2]/td[3][text()='"+strValue+"']", "xpath");
		assertTrue(this.page.element("//a[text()='"+strResourceTypeName+"']/ancestor::thead/following-sibling::tbody/tr[2]/td[3][text()='"+strValue+"']", "xpath").getOne().isDisplayed());
		return this;
	}
	/**********************************************************************************
	  * Description : This function is to enter resource name in search field
	  * Date        : 09-Mar-2016
	  * Author      : Sangappa 
	  **********************************************************************************/
	public ViewsList eneterResnameInSearchResField(String strRes)
			throws Exception {
		objWaitForElement.waitForElements(resourceTable, "xpath");
		this.page.element(searchRes, "xpath").clearInputValue()
				.sendKeys(strRes);
		Thread.sleep(8000);
		this.page.element(search, "xpath").getOne().click();
		Thread.sleep(6000);
		return this;
	}
	/**********************************************************************************
	  * Description : This function is to click on Resources Tab while creating/Edit View
	  * Date        : 09-Mar-2016
	  * Author      : Sangappa k
	  **********************************************************************************/
	public ViewsList clickOnResourcesTabInIE() throws Exception {
		objWaitForElement.waitForElements(resourceTable, "xpath");
		objWaitForElement.waitForElements(resourcesTab, "xpath");
		this.page.element(resourcesTab, "xpath").getOne().sendKeys(Keys.ENTER);
		return this;
	}
	/**********************************************************************************
	  * Description : This function is to verify SurRes/SubRT in under Res tab
	  * Date        : 20/06/2014
	  * Author      : Sangappa k
	  **********************************************************************************/
	public ViewsList verifySubRSOrSubRTAreNotDispInResTab(String strSubRsOrSubRT)
			throws Exception {
		objWaitForElement
				.waitForElements("//table[@id='grid']/tbody/tr/td[2]/span[text()='"+strSubRsOrSubRT+"']", "xpath");
		assertFalse((this.page
				.element("//table[@id='grid']/tbody/tr/td[2]/span[text()='"+strSubRsOrSubRT+"']", "xpath")).isElementPresent(WaitTimeConstants.WAIT_TIME_TOO_SMALL));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify summary table is displayed for the resource type
	  * Date        : 14/03/2016
	  * Author      : Anil
	  **********************************************************************************/
	public ViewsList verifySummaryTableIsNotDisplayed(String strResourceTypeName)
			throws Exception {
		assertFalse(this.page.element("//a[text()='"+strResourceTypeName+"']/ancestor::thead/following-sibling::tbody/tr[2]/td[text()='Summary']", "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_TOO_SMALL));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select status type
	  * Date        : 20/06/2014
	  * Author      : Yugender
	  **********************************************************************************/
	public ViewsList verifyStatusTypeInViewsPageIsDisplayed(String strStatusTypes) throws Exception {
		objWaitForElement.waitForElements("//td//a[text()='"+strStatusTypes+"']/ancestor::td/preceding-sibling::td[1]/input",
		"xpath");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='TB_load']/img[@src='/img/loadingAnimation.gif']")));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//td//a[text()='"+strStatusTypes+"']/ancestor::td/preceding-sibling::td[1]/input"))));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//td//a[text()='"+strStatusTypes+"']/ancestor::td/preceding-sibling::td[1]/input"))));
		this.page.element("//td//a[text()='"+strStatusTypes+"']/ancestor::td/preceding-sibling::td[1]/input",
				"xpath").getOne().isDisplayed();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to deslect timestamp chkbox
	  * Date        : 11-May-2016
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList deslectTimestampCol() throws Exception {
		this.page.element("//span[text()='Timestamp']/parent::a/preceding-sibling::input", "xpath")
				.getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to deslect users column chkbox
	  * Date        : 11-May-2016
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList deslectUserCol() throws Exception {
		this.page.element("//span[text()='User']/parent::a/preceding-sibling::input", "xpath")
				.getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to deslect future resource column chkbox
	  * Date        : 11-May-2016
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList deslectFutureResourceCol() throws Exception {
		this.page.element("//span[text()='Future Resources']/parent::a/preceding-sibling::input", "xpath")
				.getOne().click();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to click on Users Tab while creating/Edit View
	  * Date        : 11-May-2016
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList clickOnUsersTab() throws Exception {
		objWaitForElement.waitForElements(usersTab, "xpath");
		this.page.element(usersTab, "xpath").getOne().sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='TB_load']/img[@src='/img/loadingAnimation.gif']")));
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to deslect security checkbox in Users Tab while creating/Edit View
	  * Date        : 11-May-2016
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList deselectSecurityChkBoxInUsersTab() throws Exception {
		objWaitForElement.waitForElements(securityChkBoxInUserTab, "xpath");
		if(this.page.element(securityChkBoxInUserTab, "xpath").getOne().isSelected()==true){
			this.page.element(securityChkBoxInUserTab, "xpath").getOne().click();
			
		if(this.page.element(securityChkBoxInUserTab, "xpath").getOne().isSelected()==true){
				this.page.element(securityChkBoxInUserTab, "xpath").getOne().sendKeys(Keys.ENTER);		
		}
		}
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select user in Users Tab while creating/Edit View
	  * Date        : 11-May-2016
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList searchUserUnderUsersTabOfView(String userName) throws Exception {
		String fetchUser="//span[text()='"+userName+"']";
		objWaitForElement.waitForElements(searchUser, "css");
		this.page.element(searchUser, "css").clearInputValue().sendKeys(userName);
		this.page.element(search, "xpath").getOne().click();
		objWaitForElement.waitForElements(fetchUser, "xpath");
		assertTrue(this.page.element(fetchUser, "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to select user in Users Tab while creating/Edit View
	  * Date        : 11-May-2016
	  * Author      : Renushree
	  **********************************************************************************/
	public ViewsList verifyUserIsSelectedInUserTabOfView(String strUserName)
			throws Exception {
		assertTrue(
				this.page
						.element("//input[@value='" + strUserName + "']",
								"xpath").getOne().isSelected(),
				"USer is not selected");
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify that the security checkbox is selected in users tab
	  * Date        : 10/06/2016
	  * Author      : Sandhya
	  **********************************************************************************/
	public ViewsList verifySecurityChkBoxInUsersTabisSelected() throws Exception {
		objWaitForElement.waitForElements(securityChkBoxInUserTab, "xpath");
		assertTrue(this.page.element(securityChkBoxInUserTab, "xpath").getOne().isSelected());	
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to verify that the user is not listed in users tab table
	  * Date        : 10/06/2016
	  * Author      : Sandhya
	  **********************************************************************************/
	public ViewsList verifyUserIsNotListedInUsersTab(String strUserName) throws Exception {
		boolean visibility = false;
		try {
			visibility = this.page.element("//table/tbody/tr/td/span[text()='" + strUserName + "']", "xpath")
			        .getOne().isDisplayed();
		} catch (Exception e) {
			assertFalse(visibility);
		}
			return this;	
	}
	
	/**********************************************************************
	  * Description : This function is to select status type
	  * Date        : 28/07/2014
	  * Author      : Anil
	  **********************************************************************/	

	public ViewsList selectStatusTypesForView(String[] strStatusTypeValue)
			throws Exception {
		objWaitForElement.waitForElements("//input[@value='" + strStatusTypeValue[0]
				+ "']", "xpath");
		for (int i = 0; i < strStatusTypeValue.length; i++) {
			this.page.element("//input[@value='" + strStatusTypeValue[0]
					+ "']", "xpath").mouseOver();
			this.page
					.element("//input[@value='" + strStatusTypeValue[0]
							+ "']", "xpath")
					.getOne().sendKeys(Keys.SPACE);
		}
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to deselect master chk box
	  * Date        : 21-Dec-2016
	  * Author      : Pallavi
	  * Modified due change in User element Id
	  **********************************************************************************/
	public ViewsList deselectAllUsersCheckBox() throws Exception {
		String selUser = ".view-configuration-users>input";

		objWaitForElement.waitForElements(selUser, "css");
		if (this.page.element(selUser, "css").getOne().isSelected()) {
			this.page.element(selUser, "css").getOne().click();
		}

		if (this.page.element(selUser, "css").getOne().isSelected()) {
			this.page.element(selUser, "css").getOne().sendKeys(Keys.ENTER);
		}
		assertFalse(this.page.element(selUser, "css").getOne().isSelected());
		return this;
	}
}