package EMR.pages;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import qaFramework.WaitTimeConstants;
import qaFramework.UserDefinedFunctions.WaitForElement;
import qaFramework.pageObject.PageObject;
import EMR.Locators.RolesList.Locators;

public class RolesList extends PageObject {
	
	WebDriver driver;
	WaitForElement waitForElement ;
	WebDriverWait wait;
	UsersList usersList;
	EventManagement eventManagement;
	
	
	public RolesList(WebDriver _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		waitForElement = new WaitForElement(this.driver);
		usersList = new UsersList(this.driver);
		eventManagement = new EventManagement(this.driver);
		wait = new WebDriverWait(this.driver,800);
	}
	
	public RolesList clickOnCreateNewRoleBtn() throws Exception {
		waitForElement.waitForElements(Locators.CREATENEWROLEBTN, "css");
		this.page.element(Locators.CREATENEWROLEBTN, "css").getOne().click();
		return this;
	}
	
	public RolesList enterRoleName(String _roleName) throws Exception {
		waitForElement.waitForElements(Locators.ROLENAME, "name");
		this.page.element(Locators.ROLENAME, "name").clearInputValue()
				.sendKeys(_roleName);
		return this;
	}
	
	public RolesList clickOnSave() throws Exception {
		waitForElement.waitForElements(Locators.SAVE, "css");
		this.page.element(Locators.SAVE, "css").getOne().click();
		return this;
	}
	
	public RolesList createRole(String roleName) throws Exception {
		this.clickOnCreateNewRoleBtn();
		this.enterRoleName(roleName);
		this.clickOnSave();
		return this;
	}
	
	public String getRoleValue(String RoleName) throws Exception {
		waitForElement.waitForElements(Locators.ROLE + RoleName + Locators.CLOSEBRACKETS + Locators.EDITOFROLE, "xpath");
		String strRoleValue = this.page
				.element(Locators.ROLE + RoleName + Locators.CLOSEBRACKETS + Locators.EDITOFROLE, "xpath").getOne().getAttribute("href");
		String resValueArr[] = strRoleValue.split("roleID=");
		strRoleValue = resValueArr[1];
		return strRoleValue;
	}
	
	public RolesList createRoleSelectingSendIncomingPatientNotifications(String roleName) throws Exception {
		this.clickOnCreateNewRoleBtn();
		this.enterRoleName(roleName);
		usersList.selectSendIncomingPatientNotificationsRight();
		this.clickOnSave();
		return this;
	}
	
	public RolesList createRoleWithViewCustomViewOption(String roleName) throws Exception {
		this.clickOnCreateNewRoleBtn();
		this.enterRoleName(roleName);
		usersList.selectViewCustomViewOption();
		this.clickOnSave();
		return this;
	}
	
	public RolesList clickEditRole(String roleName) throws Exception{
		waitForElement.waitForElements(Locators.TABLECELLWITHTEXT + roleName + Locators.CLOSEBRACKETS + Locators.TABLE_CELL_WITH_TEXT_PART1, "xpath");
		try{
			this.page.element(Locators.TABLECELLWITHTEXT + roleName + Locators.CLOSEBRACKETS + Locators.TABLE_CELL_WITH_TEXT_PART1, "xpath").clickUsingJSE();
			
			if (this.page.element(Locators.EDIT_ROLE_PAGE, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL) == false) {
				this.page.element(Locators.TABLECELLWITHTEXT + roleName + Locators.CLOSEBRACKETS + Locators.TABLE_CELL_WITH_TEXT_PART1, "xpath").getOne().click();
				waitForElement.waitForElements(Locators.EDIT_ROLE_PAGE,"xpath" );
			}
			if(this.page.element(EMR.Locators.RolesList.Locators.EDIT_ROLE_PAGE, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL)==false) {
				this.page.element(Locators.TABLECELLWITHTEXT + roleName + Locators.CLOSEBRACKETS + Locators.TABLE_CELL_WITH_TEXT_PART1, "xpath").getOne().sendKeys(Keys.ENTER);
			}
			waitForElement.waitForElements(Locators.EDIT_ROLE_PAGE,"xpath" );
			assertTrue(this.page.element(EMR.Locators.RolesList.Locators.EDIT_ROLE_PAGE, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL));
		} catch(Exception e) {
			
		}
		return this;
	}
	
	public RolesList clickOnCancel() throws Exception {
		waitForElement.waitForElements(Locators.CANCEL, "css");
		this.page.element(Locators.CANCEL, "css").getDisplayedOne().click();
		return this;
	}
	
	public RolesList verifyStatusTypesUnderRoleUpdateRightSection(List<String> statusTypesValues) throws Exception{
		waitForElement.waitForElements(Locators.ROLENAME,"name");
		for(int i=0;i<statusTypesValues.size();i++)
		{
		this.page.element(Locators.ROLE_MAY_VIEW_OR_UPDATE + statusTypesValues.get(i) + Locators.ROLE_MAY_UPDATE, "xpath").mouseOver();
		assertTrue(this.page.element(Locators.ROLE_MAY_VIEW_OR_UPDATE + statusTypesValues.get(i) + Locators.ROLE_MAY_UPDATE, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.ROLE_MAY_VIEW_OR_UPDATE + statusTypesValues.get(i) + Locators.ROLE_MAY_UPDATE, "xpath").getOne().isDisplayed());	
		}
   	return this;
	}
	
	public RolesList verifyStatusTypesUnderRoleMayViewRightAndIsDisabledAndChecked(List<String> statusTypesValues) throws Exception{
		waitForElement.waitForElements(Locators.ROLENAME,"name");
		for(int i=0;i<statusTypesValues.size();i++)
		{
		this.page.element(Locators.ROLE_MAY_VIEW_OR_UPDATE + statusTypesValues.get(i) + Locators.ROLE_MAY_VIEW, "xpath").mouseOver();
		assertTrue(this.page.element(Locators.ROLE_MAY_VIEW_OR_UPDATE + statusTypesValues.get(i) + Locators.ROLE_MAY_VIEW, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.ROLE_MAY_VIEW_OR_UPDATE + statusTypesValues.get(i) + Locators.ROLE_MAY_VIEW, "xpath").getOne().isDisplayed());	
		}
   	return this;
	}
	
	public RolesList editRoleAndVerifyStatusTypesUnderRoleUpdateSection(String roleName,List<String> statusTypesValues) throws Exception {
		this.clickEditRole(roleName);
		this.verifyStatusTypesUnderRoleUpdateRightSection(statusTypesValues);
		return this;
	}
	
	public RolesList editRoleAndVerifyIPNSendIncomingPatientNotifications(String roleName) throws Exception {
		this.clickEditRole(roleName);
		usersList.verifyIPNSendIncomingPatientNotifications();
		return this;
	}
	
	public RolesList deselectUpdateRight() throws Exception {
		waitForElement.waitForElements(Locators.UPDATE_RIGHT ,"xpath");
		if(this.page.element(Locators.UPDATE_RIGHT ,"xpath").getOne().isSelected()==true){
			this.page.element(Locators.UPDATE_RIGHT ,"xpath").getOne().click();
		}
		return this;
	}

	public RolesList createRoleDeselectUpdateRight(String roleName) throws Exception {
		this.clickOnCreateNewRoleBtn();
		this.enterRoleName(roleName);
		this.deselectUpdateRight();
		this.clickOnSave();
		System.out.println(roleName);
		return this;
	}

	public RolesList deleteRole(String roleName) throws Exception{
		waitForElement.waitForElements(Locators.TABLECELLWITHTEXT + roleName + Locators.CLOSEBRACKETS + Locators.DELETE_ROLE, "xpath");
		this.page.element(Locators.TABLECELLWITHTEXT + roleName + Locators.CLOSEBRACKETS + Locators.DELETE_ROLE, "xpath").getDisplayedOne().click();
		eventManagement.clickOnAcceptOfAlert();
		return this;
	}

	public String getDefaultRoleValueIfExists()throws Exception {
		waitForElement.waitForElements(Locators.ROLES_LIST_PAGE, "xpath");
		String defaultRoleValue = "";
		if(this.page.element(Locators.DEFAULT_ROLE,"xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_SMALL))
		{	
			this.page.element(Locators.DEFAULT_ROLE,"xpath").mouseOver();
			defaultRoleValue=this.page.element(Locators.DEFAULT_ROLE,"xpath").getOne().getAttribute("href");
			String defaultRole[] = defaultRoleValue.split("roleID=");
			defaultRoleValue = defaultRole[1];
		}
		return defaultRoleValue;
	}

	public RolesList editRoleAndVerifyStatusTypesDisplayedUnderRolePage(String roleName, ArrayList<String> statusTypesNames) throws Exception {
		this.clickEditRole(roleName);
		this.verifyStatusTypesDispalyedInRoleListPage(statusTypesNames);
		this.clickOnSave();
		return this;
	}

	public RolesList verifyStatusTypesDispalyedInRoleListPage(ArrayList<String> statusTypesNames) throws Exception{
		Iterator<String> itr=statusTypesNames.iterator();
		while(itr.hasNext())
		{ 
			String statusTypes=EMR.Locators.ViewUnderSetup.Locators.CREATED_SECTION+itr.next()+Locators.STATUS_TYPES_UNDER_EDIT_ROLE;
			this.page.element(statusTypes, "css").mouseOver();
			assertTrue(this.page.element(statusTypes, "css").isElementPresent());
			assertTrue(this.page.element(statusTypes, "css").getOne().isDisplayed());	
		}
		return this;
	}
	
	public RolesList verifyRoleIsNotPresentInRoleList(String roleName) throws Exception {
		waitForElement.waitForElements(Locators.ROLE_NAME_IN_TABLE+ roleName + Locators.CLOSEBRACKETS, "xpath");
		assertFalse(this.page.element(Locators.ROLE_NAME_IN_TABLE+ roleName + Locators.CLOSEBRACKETS, "xpath").isElementPresent(WaitTimeConstants.WAIT_TIME_FOR_FALSE), roleName +"RoleName is displayed");
		return this;
	}
	
	public RolesList makeRoleDefault(String roleName)throws Exception{
		waitForElement.waitForElements(Locators.TABLECELLWITHTEXT + roleName + Locators.CLOSEBRACKETS + Locators.MAKE_DEFAULT, "xpath");
		this.page.element(Locators.TABLECELLWITHTEXT + roleName + Locators.CLOSEBRACKETS + Locators.MAKE_DEFAULT, "xpath").getDisplayedOne().click();
		return this;
	}
	
	public RolesList UserLinkCorrespondingToRole(String roleName) throws Exception {
		waitForElement.waitForElements(Locators.TABLECELLWITHTEXT+ roleName +Locators.CLOSEBRACKETS+Locators.USER_LINK_CORRESPONDING_TO_ROLE, "xpath");
		this.page.element(Locators.TABLECELLWITHTEXT+ roleName +Locators.CLOSEBRACKETS+Locators.USER_LINK_CORRESPONDING_TO_ROLE, "xpath").getDisplayedOne().click();
		return this;
	}
	
	public RolesList selectUserToCorrespondingToRole(String roleName) throws Exception {
		waitForElement.waitForElements(Locators.TABLECELLWITHTEXT + roleName + Locators.CLOSEBRACKETS +Locators.SELECT_ROLE_CHECKBOX,
				"xpath");
		if (this.page
				.element(Locators.TABLECELLWITHTEXT + roleName + Locators.CLOSEBRACKETS +Locators.SELECT_ROLE_CHECKBOX,
						"xpath").getOne().isSelected() == false) {
			this.page
			.element(Locators.TABLECELLWITHTEXT + roleName + Locators.CLOSEBRACKETS +Locators.SELECT_ROLE_CHECKBOX,
					"xpath").getOne().click();
			assertTrue(this.page.element(Locators.TABLECELLWITHTEXT + roleName + Locators.CLOSEBRACKETS +Locators.SELECT_ROLE_CHECKBOX,
					"xpath").getOne().isSelected());
		}
		return this;
	}

	public RolesList verifyAssignUsersToRolePageIsDisplayed(String roleName)throws Exception{
		waitForElement.waitForElements(Locators.ASSIGN_USERS_PART1+ roleName +Locators.ASSIGN_USER_PART2+Locators.CLOSEBRACKETS, "xpath");
		assertTrue(this.page.element(Locators.ASSIGN_USERS_PART1+ roleName +Locators.ASSIGN_USER_PART2+Locators.CLOSEBRACKETS, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.ASSIGN_USERS_PART1+ roleName +Locators.ASSIGN_USER_PART2+Locators.CLOSEBRACKETS, "xpath").getOne().isDisplayed());
		return this;
	}
	
	public RolesList verifyRoleListPage() throws Exception {
		waitForElement.waitForElements(Locators.ROLES_LIST_PAGE, "xpath");
		assertTrue(this.page.element(Locators.ROLES_LIST_PAGE, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.ROLES_LIST_PAGE, "xpath").getOne().isDisplayed());
		return this;
	}
	
	public RolesList createRoleWithSetupStatusReason(String roleName) throws Exception {
		this.clickOnCreateNewRoleBtn();
		this.verifyCreateRolePage();
		this.enterRoleName(roleName);
		usersList.selectStatusReasonRight();
		this.clickOnSave();
		return this;
	}
	
	public RolesList verifyCreateRolePage() throws Exception {
		waitForElement.waitForElements(Locators.CREATE_ROLE_PAGE, "xpath");
		assertTrue(this.page.element(Locators.CREATE_ROLE_PAGE, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.CREATE_ROLE_PAGE, "xpath").getOne().isDisplayed());
		return this;
	}
	
	public RolesList verifyRoleInRoleListPage(String roleName) throws Exception {
		waitForElement.waitForElements(Locators.ROLE_NAME_IN_TABLE+ roleName + Locators.CLOSEBRACKETS, "xpath");
		assertTrue(this.page.element(Locators.ROLE_NAME_IN_TABLE+ roleName + Locators.CLOSEBRACKETS, "xpath").isElementPresent());
		assertTrue(this.page.element(Locators.ROLE_NAME_IN_TABLE+ roleName + Locators.CLOSEBRACKETS, "xpath").getOne().isDisplayed());
		return this;
	}
	
}
