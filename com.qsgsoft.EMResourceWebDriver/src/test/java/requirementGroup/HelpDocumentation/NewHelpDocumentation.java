package requirementGroup.HelpDocumentation;

import java.util.Iterator;
import java.util.Set;

import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.Roles_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.Login;
import lib.page.Map;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.Roles;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UpdateStatus;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewHelpDocumentation extends TestNG_UI_EXTENSIONS{

	public NewHelpDocumentation() throws Exception {
		super();
	}
	
	/*********************************************************************************
	'Description :  Verify that user is taken to 'NEDOC' screen in help center when user clicks on 'NEDOCS Help Document' link
	'Precondition:
	'Date	 	 : 29-July-2014
	'Author		 : Sowmya
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************/
	@Test(description = " Verify that user is taken to 'NEDOC' screen in help center when user clicks on 'NEDOCS Help Document' link")
	public void testHappyDay119758() throws Exception {
		gstrTCID = "119758";
		gstrTO = " Verify that user is taken to 'NEDOC' screen in help center when user clicks on 'NEDOCS Help Document' link";
		
		Login_data objTest_data = new Login_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		Roles_data objRolesData = new Roles_data();
		
		ResourceType objResourceType_Page = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(this.driver1);
		Resource objResource_Page = new Resource(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		Roles objRoles = new Roles(this.driver1);
		Map objMap = new Map(this.driver1);
		UsersList objUsersList_page = new UsersList(this.driver1);
		UpdateStatus objUpdateStatus_Page = new UpdateStatus(this.driver1);
		
		String strResourceValue[] = new String[1];
		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strRoleValue[] = new String[1];
		
		System.out.println("-----Precondtion execution starts------");

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault.selectFrame();

		objSelectRegion.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		// RoleBased statustypes
		objStatusTypeList.createStatusType(
				objStatusTypes_data.strNedocCalculationStatusType,
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objNavigationToSubMenus.navigateToResourceInSetup();

		// Resource type creation
		objResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation with address

		objResource_Page.navigateToResourceListPage()

		.createResourceWithAddress(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);

		strResourceValue[0] = objResource_Page
				.getResourceValue(objResource_data.strResourceName);

		// Create role
		objNavigationToSubMenus.navigateToRoles();

		objRoles.createRole(objRolesData.strRoleName);

		strRoleValue[0] = objRoles.getRoleValue(objRolesData.strRoleName);

		// Create User
		objUsersList_page
				.navigateToUsersNew()

				.clickCreateNewUserButton()

				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectRoleCheckBox(strRoleValue)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.clickSaveButton();
		
		System.out.println(objUserdata.strNewUserName); 
		
		objLogin.clickLogOut();
		
		//---------------------Precondition ends --------------------------------//
		
		objLogin.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault.selectFrame();

		objNavigationToSubMenus.navigateToMap();

		String[] strStatusTypeNames = { objStatusTypes_data.strNDSTStatusTypeName };

		objMap.selectResourceNameInFindResourceDropdown(
				objResource_data.strResourceName)
				.verResourceNameInPopupWindow(objResource_data.strResourceName)
				.verStatusTypesInPopupWindow(strStatusTypeNames)
				.verUpdateStatusInPopupWindow()
				.clickUpdateStatusInPopupWindow();

		String mainWindowHandle = driver.getWindowHandle();

		objUpdateStatus_Page.selectStatusTypes(strStatusTypeValues[0])
				.clickOnNEDOCShelpDocLink();

		Set<String> a = driver.getWindowHandles();
		Iterator<String> ite = a.iterator();
		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver.switchTo().window(popupHandle);
				driver.manage().window().maximize();
			}
		}

		objUpdateStatus_Page.verEMResourceHelpLinkInNewWindow();

		driver.close();

		driver.switchTo().window(mainWindowHandle);
		
		objRegionDefault.selectFrame();

		objLogin.clickLogOut();

		gstrResult = "PASS";
	}
}