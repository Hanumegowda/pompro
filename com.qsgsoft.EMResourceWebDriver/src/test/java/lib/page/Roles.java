package lib.page;

import static org.testng.Assert.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import qaframework.lib.WaitTimeConstants;
import qaframework.lib.UserDefinedFunctions.WaitForElement;
import qaframework.lib.pageObject.PageObject;

public class Roles extends PageObject{
	
	WebDriver driver;
	WebDriverWait wait;
	WaitForElement objWaitForElement ;

	//Locaters
	private String CreateNewRoleBtn = "input[value='Create New Role']",
			rolename = "description",
			saveBtn = "input[value='Save']",
			selectAll = "//td[@class='emsLabel'][text()='Select the Status Types this Role may view:']"
					+ "/following-sibling::td/input[@name='SELECT_ALL']",
			viewSelectAll="//input[@class='toggleAllAdditional'][@data-name='viewRightIDs[]']",
			updateSelectAll="//input[@class='toggleAllAdditional'][@data-name='updateRightIDs[]']",
			header = "//div[@id='topSubNav']/h1",
		    statusSummerychkBox  = "//input[@value='40'][@type='checkbox']",
		    statusReasonchkBox  = "//input[@value='3'][@type='checkbox']",
			formUserMayAtivateForms = "input[value='32'][name='rightID']",
			formUserMayConfigureFormSecurity = "input[value='33'][name='rightID']",
			eventSnapshot = "input[value='49'][name='rightID']",
			configureRegionalUserAccess = "input[value='5'][name='rightID']",
			editRegionalBltnBoard="//input[@value='28'][@type='checkbox']",
			editStatusChangeNotification="//input[@value='12'][@type='checkbox']",
			viewCustomView = "input[value='26'][name='rightID']",
			configureMultiRegionViews = "input[value='71'][name='rightID']",
			configureRegionViews = "input[value='51'][name='rightID']",
			cancelButton = "input[value='Cancel']",
			formUserMayCreateAndModifyForms = "input[value='39'][name='rightID']",
			strRightsName = "//table[@summary='Data Input Form']/tbody/tr/td[text()='Select the Rights for this Role:']/following-sibling::td[1]";


	public Roles(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		objWaitForElement = new WaitForElement(this.driver);
		wait= new WebDriverWait(driver, 500);
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Crete New Role' button
	 * Date        : 13/08/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public Roles clickOnCreateNewRoleBtn() throws Exception {
		objWaitForElement.waitForElements(CreateNewRoleBtn, "css");
		this.page.element(CreateNewRoleBtn, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to enter role name
	 * Date        : 13/08/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public Roles enterRoleName(String strRoleName) throws Exception {
		objWaitForElement.waitForElements(rolename, "name");
		this.page.element(rolename, "name").clearInputValue()
				.sendKeys(strRoleName);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Save' button
	 * Date        : 13/08/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public Roles clickOnSaveBtn() throws Exception {
		objWaitForElement.waitForElements(saveBtn, "css");
		this.page.element(saveBtn, "css").clickUsingJSE();
		Thread.sleep(3000);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to create 'Role'
	 * Date        : 13/08/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public Roles createRole(String strRoleName) throws Exception {
		this.clickOnCreateNewRoleBtn();
		this.enterRoleName(strRoleName);
		this.clickOnSaveBtn();
		return this;
	}
	
	/**********************************************************************************
	  * Description : This function is to get the value of role
	  * Arguments   : strRoleName
	  * Date        : 13/08/2014
	  * Author      : Sowmya
	  **********************************************************************************/
	public String getRoleValue(String strRoleName) throws Exception {
		objWaitForElement.waitForElements("//div[@id='mainContainer']/table/tbody/tr/td[3][text()='"
				+ strRoleName
				+ "']/parent::tr/td[1]/a[text()='Edit']",
		"xpath");
		String strRoleValue = this.page
				.dynamicElement(
						"RoleName",
						"//div[@id='mainContainer']/table/tbody/tr/td[3][text()='"
								+ strRoleName
								+ "']/parent::tr/td[1]/a[text()='Edit']",
						"xpath").getOne().getAttribute("href");

		String strResValueArr[] = strRoleValue.split("roleID=");
		strRoleValue = strResValueArr[1];

		return strRoleValue;
	}
	/**********************************************************************************
	 * Description : This function is to  select All checkbox in Roles 
	 * Date        : 07/10/2014
	 * Author      : Prasanna Lakshmi
	 **********************************************************************************/
	public Roles ClickSelectAllCheckboxInRoles() throws Exception {
		objWaitForElement.waitForElements(selectAll,
		"xpath");
		this.page.element(selectAll, "xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to create 'Role'
	 * Date        : 07/10/2014
	 * Author      : Prasanna Lakshmi
	 **********************************************************************************/
	public Roles createRoleBySelAllCheckbox(String strRoleName) throws Exception {
		this.clickOnCreateNewRoleBtn();
		this.enterRoleName(strRoleName);
		this.ClickSelectAllCheckboxInRoles();
		this.clickOnSaveBtn();
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to click statustypes RoleMayViewSection
	   * Date        : 11/06/2014
	   * Author      : Anil
	   **********************************************************************************/
	public Roles clickStatusTypeInRoleMayViewSection(String[] strStatusTypeValues)
			throws Exception {
		objWaitForElement.waitForElements("//input[@value='" + strStatusTypeValues[0]
				+ "'][@name='statusTypes_viewRightIDs']", "xpath");
		for (int i = 0; i < strStatusTypeValues.length; i++) {
			
			if (this.page
					.element(
							"//input[@value='" + strStatusTypeValues[i]
									+ "'][@name='statusTypes_viewRightIDs']",
							"xpath").getOne().isSelected() == false) {
			this.page.element(
					"//input[@value='" + strStatusTypeValues[i]
							+ "'][@name='statusTypes_viewRightIDs']", "xpath").mouseOver();
			this.page
					.element(
							"//input[@value='" + strStatusTypeValues[i]
									+ "'][@name='statusTypes_viewRightIDs']", "xpath")
					.getOne().sendKeys(Keys.SPACE);
			}
		}
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to click statustypes RoleMayViewSection
	   * Date        : 11/06/2014
	   * Author      : Anil
	   **********************************************************************************/
	public Roles clickStatusTypeInRoleMayUpdateSection(
			String[] strStatusTypeValues) throws Exception {
		objWaitForElement.waitForElements("//input[@value='"
				+ strStatusTypeValues[0]
				+ "'][@name='statusTypes_updateRightIDs']", "xpath");
		for (int i = 0; i < strStatusTypeValues.length; i++) {

			if (this.page
					.element(
							"//input[@value='" + strStatusTypeValues[i]
									+ "'][@name='statusTypes_updateRightIDs']",
							"xpath").getOne().isSelected() == false) {
				this.page.element(
						"//input[@value='" + strStatusTypeValues[i]
								+ "'][@name='statusTypes_updateRightIDs']",
						"xpath").mouseOver();
				this.page
						.element(
								"//input[@value='"
										+ strStatusTypeValues[i]
										+ "'][@name='statusTypes_updateRightIDs']",
								"xpath").getOne().sendKeys(Keys.SPACE);
			}
		}
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to  deselect All checkbox in Roles 
	 * Date        : 07/10/2014
	 * Author      : Anil
	 **********************************************************************************/
	public Roles deSelectAllCheckboxInRolesMayViewsec() throws Exception {
		objWaitForElement.waitForElements(viewSelectAll, "xpath");
		this.page.element(viewSelectAll, "xpath").getOne().click();
		if (this.page.element(viewSelectAll, "xpath").getOne().isSelected()==true) {		
			this.page.element(viewSelectAll, "xpath").getOne().click();
		}
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to  deselect All checkbox in Roles 
	 * Date        : 07/10/2014
	 * Author      : Anil
	 **********************************************************************************/
	public Roles deSelectAllCheckboxInRolesMayUpdatesec() throws Exception {
		objWaitForElement.waitForElements(updateSelectAll, "xpath");
		this.page.element(updateSelectAll, "xpath").getOne().click();
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to click on 'Edit' link of resource type
	 * Date        : 19/06/2014
	 * Author      : Sowmya
	 **********************************************************************************/
	public Roles clickOnEditLinkOfRole(String strRoleName) throws Exception {
		objWaitForElement.waitForElements(
				"//table[@class='displayTable striped border']/tbody"
						+ "/tr/td[3][text()='" + strRoleName
						+ "']/parent::tr/td[1]/a[text()='Edit']", "xpath");
		this.page.element(
				"//table[@class='displayTable striped border']/tbody"
						+ "/tr/td[3][text()='" + strRoleName
						+ "']/parent::tr/td[1]/a[text()='Edit']", "xpath")
				.mouseOver();
		this.page
				.element(
						"//table[@class='displayTable striped border']/tbody"
								+ "/tr/td[3][text()='" + strRoleName
								+ "']/parent::tr/td[1]/a[text()='Edit']",
						"xpath").getOne().sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify action header
	 * Date        : 12/09/2014
	 * Author      : Renushree
	**********************************************************************************/
	public Roles verViewRightHeader() throws Exception {
		objWaitForElement.waitForElements(
				"//table/tbody/tr/th/span/input[@data-name='viewRightIDs[]']",
				"xpath");
		assertTrue(this.page.element(
				"//table/tbody/tr/th/span/input[@data-name='viewRightIDs[]']",
				"xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify action header
	 * Date        : 12/09/2014
	 * Author      : Renushree
	**********************************************************************************/
	public Roles verUpdateRightHeader() throws Exception {
		objWaitForElement.waitForElements(
				"//table/tbody/tr/th/span/input[@data-name='updateRightIDs[]']",
				"xpath");
		assertTrue(this.page.element(
				"//table/tbody/tr/th/span/input[@data-name='updateRightIDs[]']",
				"xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Status Type Name With Update And View 
	 * 				 Right Check Boxes
	 * Date        : 19-May-2015
	 * Author      : Pallavi
	**********************************************************************************/
	public Roles verifyStatusTypeNameWithUpdateAndViewRightChkBox(
			String strStatusTypeName) throws Exception {
		String strWebElement = "//div[@id='statusTypes']//table/tbody/tr/td[4]/a[contains(text(),'"
				+ strStatusTypeName
				+ "')]/parent::td/preceding-sibling::td/input[contains(@name,'viewRightIDs')]/parent::"
				+ "td/following-sibling::td/input[contains(@name,'updateRightIDs')]";
		objWaitForElement.waitForElements(strWebElement, "xpath");
		assertTrue(this.page.element(strWebElement, "xpath").isElementPresent());
		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify created Role is listed under Roles page 
	 * Date        : 03-Jun-2015
	 * Author      : Pallavi
	**********************************************************************************/
	public Roles verifyCreatedRoleInRolesList(String strRoleName)
			throws Exception {
		String strWebElement = "//table[@summary='Roles']/tbody/tr/td[text()='"
				+ strRoleName + "']";
		objWaitForElement.waitForElements(strWebElement, "xpath");
		assertTrue(this.page.element(strWebElement, "xpath").isElementPresent());
		return this;
	}
	
	
	/**********************************************************************************
	 * Description : This function is to verify create role page is displayed
	 * Date        : 04/08/2014
	 * Author      : Anil
	 **********************************************************************************/
	public Roles verifyRoleListPageIsDisplayed() throws Exception {
		objWaitForElement.waitForElements("//div[@id='topSubNav']/h1[text()='Create Role']", "xpath");
		assertTrue(this.page.element("//div[@id='topSubNav']/h1[text()='Create Role']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to select Setup Statu sReasons ChkBox
	 * Date        : 03-Jun-2015
	 * Author      : Sangappa.k
	**********************************************************************************/
	public Roles selectSetupStatusReasonsChkBox()
			throws Exception {
		objWaitForElement.waitForElements(statusReasonchkBox, "xpath");
		this.page.element(statusReasonchkBox, "xpath").getOne().click();
		return this;
	}

	
	/**********************************************************************************
	 * Description : This function is to select Report - Status Summary ChkBox
	 * Date        : 09-Jun-2015
	 * Author      : Sangappa.k
	**********************************************************************************/
	public Roles selectReportStatusSummaryChkBox()
			throws Exception {
		objWaitForElement.waitForElements(statusSummerychkBox, "xpath");
		this.page.element(statusSummerychkBox, "xpath").getOne().click();
		return this;
	}

	
	/**********************************************************************************
	 * Description 	: This function is to select Form - User may activate forms
	 * Date 		: 09/06/2015
	 * Author 		: Renushree
	 **********************************************************************************/
	public Roles selectFormUserMayActivateForms() throws Exception {
		objWaitForElement.waitForElements(formUserMayAtivateForms, "css");
		this.page.element(formUserMayAtivateForms, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description  : This function is to select Form - User may configure security form
	 * Date   		: 09/06/2015
	 * Author 		: Deepa
	  **********************************************************************************/
	 public Roles selectFormUserMayConfigureFormSecurity() throws Exception {
	  objWaitForElement.waitForElements(formUserMayConfigureFormSecurity, "css");
	  this.page.element(formUserMayConfigureFormSecurity, "css").getOne().click();
	  return this;
	 }
	 
	 /**********************************************************************************
	   * Description : This function is to click statustypes RoleMayViewSection
	   * Date        : 11/06/2014
	   * Author      : Anitha
	   **********************************************************************************/
	public Roles clickStatusTypeInRoleMayUpdateSection(String strStatusTypeValue)
			throws Exception {
		objWaitForElement.waitForElements(
				"//input[@value='" + strStatusTypeValue
						+ "'][@name='statusTypes_updateRightIDs']", "xpath");
		if (this.page
				.element(
						"//input[@value='" + strStatusTypeValue
								+ "'][@name='statusTypes_updateRightIDs']",
						"xpath").getOne().isSelected() == false) {
			this.page
					.element(
							"//input[@value='" + strStatusTypeValue
									+ "'][@name='statusTypes_updateRightIDs']",
							"xpath").mouseOver();
			this.page
					.element(
							"//input[@value='" + strStatusTypeValue
									+ "'][@name='statusTypes_updateRightIDs']",
							"xpath").getOne().sendKeys(Keys.SPACE);
		}
		return this;
	}

	 /**********************************************************************************
	  * Description  	: This function is to select Report - Event Snapshot
	  * Date   			: 10/06/2015
	  * Author 			: Renushree
	  **********************************************************************************/
	 public Roles selectReportEventSnapshot() throws Exception {
	  objWaitForElement.waitForElements(eventSnapshot, "css");
	  this.page.element(eventSnapshot, "css").getOne().click();
	  return this;
	 }
	 
	 /**********************************************************************************
	 * Description 	: This function is to select Configure Regional User Access
	 * Date 		: 10/06/2015
	 * Author 		: Renushree
	 **********************************************************************************/
	public Roles selectConfigureRegionalUserAccess() throws Exception {
		objWaitForElement.waitForElements(configureRegionalUserAccess, "css");
		this.page.element(configureRegionalUserAccess, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to Select the role
	   * Date        : 08/06/2015
	   * Author      : Renushree
	   **********************************************************************************/
	public Roles deselectConfigureRegionalUserAccess() throws Exception {
		if (this.page.element(configureRegionalUserAccess, "css").getOne()
				.isSelected() == true) {
			this.page.element(configureRegionalUserAccess, "css").getOne()
					.click();
		}
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to select Report - Status Summary ChkBox
		 * Date        : 09-Jun-2015
		 * Author      : Sangappa.k
	**********************************************************************************/
		public Roles  selectEditRegionalMessageBulletinBoard()
				throws Exception {
			objWaitForElement.waitForElements(editRegionalBltnBoard, "xpath");
			this.page.element(editRegionalBltnBoard, "xpath").getOne().click();
			return this;
		}
		
	/**********************************************************************************
	 * Description : This function is to select Report - Status Summary ChkBox
		 * Date        : 09-Jun-2015
		 * Author      : Sangappa.k
	**********************************************************************************/
		public Roles  selectEditStatusChangeNotification()
				throws Exception {
			objWaitForElement.waitForElements(editRegionalBltnBoard, "xpath");
			this.page.element(editStatusChangeNotification, "xpath").getOne().click();
			return this;
		}
	
	/**********************************************************************************
	 * Description  : This function is to select view custom view
	 * Date   		: 15/Jun/2015
	 * Author 		: Renushree
	 **********************************************************************************/
	public Roles selectViewCustomView() throws Exception {
		objWaitForElement.waitForElements(viewCustomView, "css");
		this.page.element(viewCustomView, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	   * Description : This function is to deselect statustypes RoleMayViewSection
	   * Date        : 11/06/2014
	   * Author      : Anil
	   **********************************************************************************/
	public Roles deselectStatusTypeInRoleMayUpdateSection(
			String[] strStatusTypeValues) throws Exception {
		objWaitForElement.waitForElements("//input[@value='"
				+ strStatusTypeValues[0]
				+ "'][@name='statusTypes_updateRightIDs']", "xpath");
		for (int i = 0; i < strStatusTypeValues.length; i++) {

			if (this.page
					.element(
							"//input[@value='" + strStatusTypeValues[i]
									+ "'][@name='statusTypes_updateRightIDs']",
							"xpath").getOne().isSelected() == true) {
				this.page.element(
						"//input[@value='" + strStatusTypeValues[i]
								+ "'][@name='statusTypes_updateRightIDs']",
						"xpath").mouseOver();
				this.page
						.element(
								"//input[@value='"
										+ strStatusTypeValues[i]
										+ "'][@name='statusTypes_updateRightIDs']",
								"xpath").getOne().sendKeys(Keys.SPACE);
			}
		}
		return this;
	}
	
	/**********************************************************************************
	    * Description : This function is to deselect statustypes RoleMayViewSection
	    * Date        : 09/07/2014
	    * Author      : Deepa
	    **********************************************************************************/
	 public Roles deSelStatusTypeInRoleMayViewSection(String[] strStatusTypeValues)
	   throws Exception {
	  objWaitForElement.waitForElements("//input[@value='" + strStatusTypeValues[0]
	    + "'][@name='statusTypes_viewRightIDs']", "xpath");
	  for (int i = 0; i < strStatusTypeValues.length; i++) {
	   
	   if (this.page
	     .element(
	       "//input[@value='" + strStatusTypeValues[i]
	         + "'][@name='statusTypes_viewRightIDs']",
	       "xpath").getOne().isSelected() == true) {
	   this.page.element(
	     "//input[@value='" + strStatusTypeValues[i]
	       + "'][@name='statusTypes_viewRightIDs']", "xpath").mouseOver();
	   this.page
	     .element(
	       "//input[@value='" + strStatusTypeValues[i]
	         + "'][@name='statusTypes_viewRightIDs']", "xpath")
	     .getOne().sendKeys(Keys.SPACE);
	   }
	  }
	  return this;
	 }
	 
	 /**********************************************************************************
	 * Description : This function is to click on 'Default' link of resource type
	 * Date        : 13/10/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public Roles clickOnDefaultLinkOfRole(String strRoleName) throws Exception {
		objWaitForElement.waitForElements(
				"//table[@class='displayTable striped border']/tbody"
						+ "/tr/td[3][text()='" + strRoleName
						+ "']/parent::tr/td[1]/a[text()='Make Default']", "xpath");
		this.page.element(
				"//table[@class='displayTable striped border']/tbody"
						+ "/tr/td[3][text()='" + strRoleName
						+ "']/parent::tr/td[1]/a[text()='Make Default']", "xpath")
				.mouseOver();
		this.page
				.element(
						"//table[@class='displayTable striped border']/tbody"
								+ "/tr/td[3][text()='" + strRoleName
								+ "']/parent::tr/td[1]/a[text()='Make Default']",
						"xpath").getOne().sendKeys(Keys.ENTER);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Users' link of resource type
	 * Date        : 14/10/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public Roles clickOnUsersLinkOfRole(String strRoleName) throws Exception {
		objWaitForElement.waitForElements(
				"//table[@class='displayTable striped border']/tbody"
						+ "/tr/td[3][text()='" + strRoleName
						+ "']/parent::tr/td[1]/a[text()='users']", "xpath");
		this.page.element(
				"//table[@class='displayTable striped border']/tbody"
						+ "/tr/td[3][text()='" + strRoleName
						+ "']/parent::tr/td[1]/a[text()='users']", "xpath")
				.mouseOver();
		this.page
				.element(
						"//table[@class='displayTable striped border']/tbody"
								+ "/tr/td[3][text()='" + strRoleName
								+ "']/parent::tr/td[1]/a[text()='users']",
						"xpath").getOne().sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify create role page is displayed
	 * Argument	   : strRoleName
	 * Date        : 14/10/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public Roles verifyAssignUserPageIsDisplayed(String strRoleName) throws Exception {
		String text = "Assign Users to '"+strRoleName+"' role";
		objWaitForElement.waitForElements("//div[@id='topSubNav']/h1[text()='"+text+"']", "xpath");
		assertTrue(this.page.element("//div[@id='topSubNav']/h1[text()='"+text+"']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to assign username to role
	 * Argument	   : strUserName
	 * Date        : 14/10/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public Roles assignUserToRole(String strUserName) throws Exception {
		objWaitForElement.waitForElements(
				"//table[@id='tbl_userID']/tbody/tr/td[text()='" + strUserName
						+ "']/parent::tr/td/input", "xpath");
		this.page
				.element(
						"//table[@id='tbl_userID']/tbody/tr/td[text()='"
								+ strUserName + "']/parent::tr/td/input",
						"xpath").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to select Configure Multi Region views
	 * Date 		: 03/11/2015
	 * Author 		: Renushree
	 **********************************************************************************/
	public Roles selectConfigureMultiRegionViews() throws Exception {
		objWaitForElement.waitForElements(configureMultiRegionViews, "css");
		this.page.element(configureMultiRegionViews, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description 	: This function is to select Configure Regions views
	 * Date 		: 03/11/2015
	 * Author 		: Renushree
	 **********************************************************************************/
	public Roles selectConfigureRegionViews() throws Exception {
		objWaitForElement.waitForElements(configureRegionViews, "css");
		this.page.element(configureRegionViews, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify edit role page is displayed
	 * Date        : 04/01/2016
	 * Author      : Renushree
	 **********************************************************************************/
	public Roles verifyEditRolePageIsDisplayed() throws Exception {
		objWaitForElement.waitForElements("//div[@id='topSubNav']/h1[text()='Edit Role']", "xpath");
		assertTrue(this.page.element("//div[@id='topSubNav']/h1[text()='Edit Role']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Role may view check box is disabled.
	 * Date        : 04/01/2016
	 * Author      : Renushree
	 **********************************************************************************/
	public Roles verRoleMayViewChkBoxIsDisabled(String strStatusTypeValue)
			throws Exception {
		assertTrue(
				this.page.element(
						"input[value='" + strStatusTypeValue
								+ "'][name='statusTypes_viewRightIDs'][disabled='disabled']", "css")
						.isElementPresent(), "Not Disabled");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Role may view check box is selected
	 * Date        : 04/01/2016
	 * Author      : Renushree
	 **********************************************************************************/
	public Roles verRoleMayViewChkBoxIsChecked(String strStatusTypeValue)
			throws Exception {
		assertTrue(
				this.page
						.element(
								"input[value='"
										+ strStatusTypeValue
										+ "'][name='statusTypes_viewRightIDs'][checked='checked']",
								"css").isElementPresent(), "ST is Checked");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Role may update check box is unchecked
	 * Date        : 04/01/2016
	 * Author      : Renushree
	 **********************************************************************************/
	public Roles verRoleMayUpdateChkBoxIsUnchecked(String strStatusTypeValue)
			throws Exception {
		assertFalse(
				this.page.element(
						"input[value='" + strStatusTypeValue
								+ "'][name='statusTypes_updateRightIDs']", "css")
						.getOne().isSelected(), "ST is Checked");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Role may update check box is selected
	 * Date        : 04/01/2016
	 * Author      : Renushree
	 **********************************************************************************/
	public Roles verRoleMayUpdateChkBoxIsSelected(String strStatusTypeValue)
			throws Exception {
		assertTrue(
				this.page.element(
						"input[value='" + strStatusTypeValue
								+ "'][name='statusTypes_updateRightIDs']", "css")
						.getOne().isSelected(), "ST is not selected");
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to click on 'Default' link of resource type
	 * Date        : 13/10/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public Roles clickOnDeleteRole(String strRoleName) throws Exception {
		objWaitForElement.waitForElements(
				"//table[@class='displayTable striped border']/tbody"
						+ "/tr/td[text()='" + strRoleName
						+ "']/parent::tr/td/a[text()='Delete']", "xpath");
		this.page.element(
				"//table[@class='displayTable striped border']/tbody"
						+ "/tr/td[text()='" + strRoleName
						+ "']/parent::tr/td/a[text()='Delete']", "xpath")
				.mouseOver();
		this.page
				.element(
						"//table[@class='displayTable striped border']/tbody"
								+ "/tr/td[text()='" + strRoleName
								+ "']/parent::tr/td/a[text()='Delete']",
						"xpath").getOne().sendKeys(Keys.ENTER);

		Thread.sleep(8000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(5000);
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Role may update check box is enabled
	 * Date        : 04/01/2016
	 * Author      : Renushree
	 **********************************************************************************/
	public Roles verRoleMayUpdateChkBoxIsEnabled(String strStatusTypeValue)
			throws Exception {
		assertTrue(
				this.page.element(
						"input[value='" + strStatusTypeValue
								+ "'][name='statusTypes_updateRightIDs']", "css")
						.getOne().isEnabled(), "ST is not selected");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to assign username to role
	 * Argument	   : strUserName
	 * Date        : 14/10/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public Roles verifyUserAssignToRole(String strUserName) throws Exception {
		objWaitForElement.waitForElements(
				"//table[@id='tbl_userID']/tbody/tr/td[text()='" + strUserName
						+ "']/parent::tr/td/input", "xpath");
		assertTrue(this.page
				.element(
						"//table[@id='tbl_userID']/tbody/tr/td[text()='"
								+ strUserName + "']/parent::tr/td/input",
						"xpath").getOne().isSelected());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to assign username to role
	 * Argument	   : strUserName
	 * Date        : 14/10/2015
	 * Author      : Renushree
	 **********************************************************************************/
	public Roles verifyUserNotAssignToRole(String strUserName) throws Exception {
		objWaitForElement.waitForElements(
				"//table[@id='tbl_userID']/tbody/tr/td[text()='" + strUserName
						+ "']/parent::tr/td/input", "xpath");
		assertFalse(this.page
				.element(
						"//table[@id='tbl_userID']/tbody/tr/td[text()='"
								+ strUserName + "']/parent::tr/td/input",
						"xpath").getOne().isSelected(), "User is Checked");
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to verify created Role is listed under Roles page 
	 * Date        : 03-Jun-2015
	 * Author      : Anitha
	**********************************************************************************/
	public Roles verifyRoleNotInRolesList(String strRoleName) throws Exception {
		assertFalse(this.page.element(
				"//table[@summary='Roles']/tbody/tr/td[text()='" + strRoleName
						+ "']", "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	/**********************************************************************************
	 * Description : This function is to click on 'Cancel' button
	 * Date        : 13/08/2014
	 * Author      : Anitha
	 **********************************************************************************/
	public Roles clickOnCancelButton() throws Exception {
		objWaitForElement.waitForElements(cancelButton, "css");
		this.page.element(cancelButton, "css").getOne().click();
		return this;
	}
	
	/**********************************************************************************
	 * Description  : This function is to select Form- User May Create And Modify Forms right
	 * Date   		: 25/feb/2016
	 * Author 		: sandhya
	 **********************************************************************************/
	public Roles selectformUserMayCreateAndModifyForms() throws Exception {
		objWaitForElement.waitForElements(formUserMayCreateAndModifyForms, "css");
		this.page.element(formUserMayCreateAndModifyForms, "css").getOne().click();
		return this;
	}

/**********************************************************************************
	 * Description : This function is to verify Form - User May Create And Modify Forms check box is selected.
	 * Date        : 25/02/2016
	 * Author      : sandhya
	 **********************************************************************************/
	public Roles verifyformUserMayCreateAndModifyFormsChkBxIsSelected()
			throws Exception {
		objWaitForElement.waitForElements(formUserMayCreateAndModifyForms,
				"css");
		assertTrue(this.page.element(formUserMayCreateAndModifyForms, "css")
				.getOne().isSelected());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify Role List page is displayed
	 * Date        : 25/02/2016
	 * Author      : sandhya
	 **********************************************************************************/
	public Roles verRoleListPageIsDisplayed() throws Exception {
		objWaitForElement.waitForElements("//div[@id='topSubNav']/h1[text()='Roles List']", "xpath");
		assertTrue(this.page.element("//div[@id='topSubNav']/h1[text()='Roles List']", "xpath").isElementPresent());
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Cancel' button
	 * Date        : 13/08/2014
	 *  Author      :Anil
	 **********************************************************************************/
	public Roles verifyDeleteOptionIsNotDisplayed(String strRoleName) throws Exception {
		objWaitForElement.waitForElements("//table[@summary='Roles']/tbody/tr/td[3][text()='"+strRoleName+"']/preceding-sibling::td[2]/a[text()='Delete']", "xpath");
		assertFalse(this.page.element("//table[@summary='Roles']/tbody/tr/td[3][text()='"+strRoleName+"']/preceding-sibling::td[2]/a[text()='Delete']", "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to verify rights is not displayed
	 * Date        : 17/Feb/2016
	 * Author      : Anil
	 **********************************************************************************/
	public Roles verifyRightsNameIsNotDisplayed(String strRightName)
			throws Exception {
		String strGetValue = this.page
						.element(strRightsName,
								"xpath").getOne().getText();
		String strRights[] = strGetValue.split("\n");
		for(int intCount=0 ; intCount<strRights.length; intCount++){
		assertFalse(strRights[intCount].contains(strRightName));
		}

		return this;
	}

	/**********************************************************************************
	 * Description : This function is to verify rights is displayed
	 * Date        : 17/Feb/2016
	 * Author      : Anil
	 **********************************************************************************/
	public Roles verifyRightsNameIsDisplayed(String strRightName)
			throws Exception {
		boolean boolCheck = false;
		String strGetValue = this.page
						.element(strRightsName,
								"xpath").getOne().getText();
		String strRights[] = strGetValue.split("\n");
		for(int intCount=0 ; intCount<strRights.length; intCount++){
		if(strRights[intCount].contains(strRightName)){
			boolCheck = true;
			break;
		}
		}
		assertTrue(boolCheck, strRightName+" is not displayed");
		return this;
	}
	
	/**********************************************************************************
	 * Description : This function is to delete default  role if exist
	 * Date        : 17/Feb/2016
	 * Author      : Sangappa
	 **********************************************************************************/
	public Roles deleteDefaultRoleIfExist()throws Exception {
		
		String defualtRoleName = "";
		String defaultYes="//td[text()='Yes']/preceding-sibling::td/a[text()='Delete']";
		
		objWaitForElement.waitForElements("//div[@id='topSubNav']/h1[text()='Roles List']", "xpath");
	
		if(this.page.element(defaultYes,"xpath").isElementPresent())
		{	
		 defualtRoleName =this.page.element(defaultYes,"xpath").getOne().getText();
		
		try{
		this.page.element(defaultYes,"xpath").mouseOver();
		this.page.element(defaultYes,"xpath").getOne().click();
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		this.page.element_wait(defaultYes, "xpath").waitForInvisibilityOfElement();		
		}
		catch(Exception e)
		{
			if(this.page.element(defualtRoleName,"xpath").isElementPresent()){
			this.page.element(defaultYes,"xpath").mouseOver();
			this.page.element(defaultYes,"xpath").clickUsingJSE();
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
			this.page.element_wait(defaultYes, "xpath").waitForInvisibilityOfElement();		
		}
	  }
  }
		assertFalse(this.page.element(defaultYes,"xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE));
		return this;
		}	
}
		
