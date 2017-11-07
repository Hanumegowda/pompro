package requirementGroup.SettingUpStatusTypes;

import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.NavigationToSubMenus;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UpdateStatus;
import lib.page.UsersList;
import lib.page.ViewsList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewNEDOCSLabels extends TestNG_UI_EXTENSIONS{

	public NewNEDOCSLabels() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/*****************************************************************************
	 * 'Description : Verify that 'Display NEDOCS labels' checkbox is selected by default on 'Create NEDOCS Calculation Status Type' page 
	 * 'Date        :15-Jun-2015
	 * 'Author      :Anil
	 *****************************************************************************/

	@Test(description = "Verify that 'Display NEDOCS labels' checkbox is selected by default on 'Create NEDOCS Calculation Status Type' page ")
	public void testHappyDay131411() throws Exception {
		gstrTCID = "131411";
		gstrTO = "Verify that 'Display NEDOCS labels' checkbox is selected by default on 'Create NEDOCS Calculation Status Type' page ";
	
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList1 = new StatusTypeList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		
		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();
				
		//User
		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.clickAdvancedOptionAndExpand()
				.selectSetupStatusTypesOption()
				.clickSaveButton();
		
		System.out.println(objUserdata.strNewUserName);
		
		objLogin.clickLogOut();

		System.out.println("----------------Precodition execution ends---------");

		System.out.println("-----------------Test execution starts---------------");

		
		objLogin1.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objRegionDefault1.selectFrame();
		
		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();
		
		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToStatusTypesInSetup();
		
		objStatusTypeList1.clickCreateNewStatusTypeButton();
		objStatusTypeList1.selectStatusType(objStatusTypes_data.strNedocCalculationStatusType);
		objStatusTypeList1.clickNextButton();
		objStatusTypeList1.enterStatusTypeName(objStatusTypes_data.strNDSTStatusTypeName);
		objStatusTypeList1.verifynedocsTextDisplayIsSelected();
		objLogin1.clickLogOut();
		
		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.navigateToStatusTypesInSetup();
		
		objStatusTypeList1.clickCreateNewStatusTypeButton();
		objStatusTypeList1.selectStatusType(objStatusTypes_data.strNedocCalculationStatusType);
		objStatusTypeList1.clickNextButton();
		objStatusTypeList1.enterStatusTypeName(objStatusTypes_data.strNDSTStatusTypeName);
		objStatusTypeList1.verifynedocsTextDisplayIsSelected();	
		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	
	/*****************************************************************************
	 * 'Description :Verify that NEDOC labels are NOT displayed on the view screens
	 *               corresponding to the calculated scores when 'Display NEDOCS labels' checkbox is
	 *               deselected for the NEDOCS status type. 
	 * 'Date        :25-Jan-2016
	 * 'Author      :Sangappa K
	 *****************************************************************************/

	@Test(description =" Verify that NEDOC labels are NOT displayed on the view screens corresponding to "
			+ "the calculated scores when 'Display NEDOCS labels' checkbox is deselected for the NEDOCS status type ")
	public void testHappyDay162668() throws Exception {
		
		gstrTCID ="162668";
		gstrTO =" Verify that NEDOC labels are NOT displayed on the view screens corresponding to the calculated scores when"
				+ " 'Display NEDOCS labels' checkbox is deselected for the NEDOCS status type ";
	
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data= new Resource_data();
		View_data objView_data = new View_data();
		

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		UpdateStatus objUpdateStatus_Page1 = new UpdateStatus(this.driver1);
		
		String[] strStatusTypeValues= new String[1];
		String[] strResType= new String[1];
		String[] strREs= new String[1];
		
		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(
						objStatusTypes_data.strNedocCalculationStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strNDSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription)
				.verifynedocsTextDisplayIsSelected()
				.deselectDisplayNEDOCSLabelCheckbox().clickOnSaveButton();

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResType[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource.createResourceWithAddress(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);

		strREs[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		System.out.println(objResource_data.strResourceName);

		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickSaveButton();

		System.out.println(objUserdata.strNewUserName);

		objNavigationToSubmenus.navigateToViews();

//		objViewsList.clickCreateNewViewButton()
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc)
//				.selectStatusTypeForView(strStatusTypeValues)
//				.selectResourceType(strResType[0]).clickOnSaveOfCreateNewView();

		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc, 
						objResource_data.strResourceName, objStatusTypes_data.strNDSTStatusTypeName);
		
		System.out.println(objView_data.strViewName);

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus_Page1
				.enterNedocsUpdateValue(strStatusTypeValues[0],
						objView_data.strValueForNDST)
				.clickOnCalculate()
				.verDisasterTextIsNotDispWhileCalculataingNedocs(
						objView_data.strNEDOCValueInUpdateScreen)
				.clickOnSaveButton()
				.verUpdatedNedocsDoesNotIncludesDisasterTextInViewPage(
						objStatusTypes_data.strNDSTStatusTypeName,
						objView_data.strNEDOCValueInUpdateScreen);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

	
	
	/*****************************************************************************
	 * 'Description : Verify that NEDOC labels are displayed on the view screens 
	 * 				corresponding to the calculated scores when 'Display NEDOCS labels'
	 * 				 checkbox is selected for the NEDOCS status type
	 * 'Date        :25-Jan-2016
	 * 'Author      :Anil 
	 *****************************************************************************/

	@Test(description ="Verify that NEDOC labels are displayed on the view screens corresponding "+
				"to the calculated scores when 'Display NEDOCS labels' checkbox is selected for the NEDOCS status type")
	public void testHappyDay162667() throws Exception {
		gstrTCID ="162667";
		gstrTO ="Verify that NEDOC labels are displayed on the view screens corresponding "+
				"to the calculated scores when 'Display NEDOCS labels' checkbox is selected for the NEDOCS status type";
	
		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data= new Resource_data();
		View_data objView_data = new View_data();
		

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		UpdateStatus objUpdateStatus_Page1 = new UpdateStatus(this.driver1);
		
		String[] strStatusTypeValues= new String[3];
		String[] strResourceTypeValue= new String[1];
		String[] strResourceValue= new String[1];
		
		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(
						objStatusTypes_data.strNedocCalculationStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strNDSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription)
				.selectDisplayNEDOCSLabelCheckbox()
				.verifynedocsTextDisplayIsSelected()
				.clickOnSaveButton();

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objStatusTypeList
		.clickCreateNewStatusTypeButton()
		.selectStatusType(
				objStatusTypes_data.strNedocCalculationStatusType)
		.clickNextButton()
		.enterStatusTypeName(objStatusTypes_data.strNDSTStatusTypeName1)
		.selectPrivateStatusTypeRadioBtn()
		.enterStatusTypeDescription(
				objStatusTypes_data.strStatusDescription)
		.selectDisplayNEDOCSLabelCheckbox()
		.verifynedocsTextDisplayIsSelected()
		.clickOnSaveButton();
		
		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName1);

		objStatusTypeList
		.clickCreateNewStatusTypeButton()
		.selectStatusType(
				objStatusTypes_data.strNedocCalculationStatusType)
		.clickNextButton()
		.enterStatusTypeName(objStatusTypes_data.strNDSTStatusTypeName2)
		.selectSharedStatusTypeRadioBtn()
		.enterStatusTypeDescription(
				objStatusTypes_data.strStatusDescription)
		.selectDisplayNEDOCSLabelCheckbox()
		.verifynedocsTextDisplayIsSelected()
		.clickOnSaveButton();
		
		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName2);
		
		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource.createResourceWithAddress(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		System.out.println(objResource_data.strResourceName);

		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickSaveButton();

		System.out.println(objUserdata.strNewUserName);

		objNavigationToSubmenus.navigateToViews();
//
//		objViewsList.clickCreateNewViewButton()
//
//				.enterViewName(objView_data.strViewName)
//				.enterViewDesc(objView_data.strViewDesc)
//				.selectStatusTypeForView(strStatusTypeValues)
//				.selectResourceType(strResourceTypeValue[0]).clickOnSaveOfCreateNewView();

		String strStatusTypeNames[] = {objStatusTypes_data.strNDSTStatusTypeName, objStatusTypes_data.strNDSTStatusTypeName1, objStatusTypes_data.strNDSTStatusTypeName2};
		
		objViewsList.createView(objView_data.strViewName, objView_data.strViewDesc, objResource_data.strResourceName, strStatusTypeNames);
		
		System.out.println(objView_data.strViewName);

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus_Page1
				.enterNedocsUpdateValue(strStatusTypeValues[0],
						objView_data.strValueForNDST)
				.clickOnCalculateButton(strStatusTypeValues[0])
						
				.enterNedocsUpdateValue(strStatusTypeValues[1],
						objView_data.strValueForNDST1)
				.clickOnCalculateButton(strStatusTypeValues[1])
				.enterNedocsUpdateValue(strStatusTypeValues[2],
						objView_data.strValueForNDST2)
				.clickOnCalculateButton(strStatusTypeValues[1])		
											
				.clickOnSaveButton()
				.verifyUpdatedStatusValues(strResourceValue[0], strStatusTypeValues[0], objView_data.strNEDOCValueInUpdateScreen)
				.verifyUpdatedStatusValues(strResourceValue[0], strStatusTypeValues[1], objView_data.strNEDOCValue2)
				.verifyUpdatedStatusValues(strResourceValue[0], strStatusTypeValues[2], objView_data.strNEDOCValue3);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}


	/*****************************************************************************
	 * 'Description : Verify that user with 'Setup Status types' right can select/deselect the 'Display NEDOCS labels' 
	 * 					check box to display the labels respectively for a resource
	 * 'Date        :21-Mar-2016
	 * 'Author      :Renushree 
	 *****************************************************************************/

	@Test(description = "Verify that user with 'Setup Status types' right can select/deselect the 'Display NEDOCS labels' "
			+ "check box to display the labels respectively for a resource")
	public void testHappyDay162669() throws Exception {

		gstrTCID = "162669";
		gstrTO = "Verify that user with 'Setup Status types' right can select/deselect the 'Display NEDOCS labels' "
				+ "check box to display the labels respectively for a resource";

		Login_data objLogindata = new Login_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		View_data objView_data = new View_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		ViewsList objViewsList = new ViewsList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		Resource objResource = new Resource(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		StatusTypeList objStatusTypeList1 = new StatusTypeList(this.driver1);
		ViewsList objViewsList1 = new ViewsList(this.driver1);
		UpdateStatus objUpdateStatus_Page1 = new UpdateStatus(this.driver1);

		String[] strStatusTypeValues = new String[3];
		String[] strResourceTypeValue = new String[1];
		String[] strResourceValue = new String[1];

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objNavigationToSubmenus.navigateToStatusTypesInSetup();

		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(
						objStatusTypes_data.strNedocCalculationStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strNDSTStatusTypeName)
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription)
				.selectDisplayNEDOCSLabelCheckbox()
				.verifynedocsTextDisplayIsSelected().clickOnSaveButton();

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName);

		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(
						objStatusTypes_data.strNedocCalculationStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strNDSTStatusTypeName1)
				.selectPrivateStatusTypeRadioBtn()
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription)
				.selectDisplayNEDOCSLabelCheckbox()
				.verifynedocsTextDisplayIsSelected().clickOnSaveButton();

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName1);

		objStatusTypeList
				.clickCreateNewStatusTypeButton()
				.selectStatusType(
						objStatusTypes_data.strNedocCalculationStatusType)
				.clickNextButton()
				.enterStatusTypeName(objStatusTypes_data.strNDSTStatusTypeName2)
				.selectSharedStatusTypeRadioBtn()
				.enterStatusTypeDescription(
						objStatusTypes_data.strStatusDescription)
				.selectDisplayNEDOCSLabelCheckbox()
				.verifynedocsTextDisplayIsSelected().clickOnSaveButton();

		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strNDSTStatusTypeName2);

		objNavigationToSubmenus.navigateToResourceTypesInSetup();

		objResourceType.createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		objNavigationToSubmenus.navigateToResourceInSetup();

		objResource.createResourceWithAddress(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName,
				objResource_data.strStreetAddress, objResource_data.strCity,
				objResource_data.strState, objResource_data.strCounty,
				objResource_data.strZipcode);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);

		System.out.println(objResource_data.strResourceName);

		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectSetupStatusTypesOption()
				.clickSaveButton();

		System.out.println(objUserdata.strNewUserName);

		objNavigationToSubmenus.navigateToViews();

		String strStatusTypeNames[] = {
				objStatusTypes_data.strNDSTStatusTypeName,
				objStatusTypes_data.strNDSTStatusTypeName1,
				objStatusTypes_data.strNDSTStatusTypeName2 };

		objViewsList.createView(objView_data.strViewName,
				objView_data.strViewDesc, objResource_data.strResourceName,
				strStatusTypeNames);

		System.out.println(objView_data.strViewName);

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus_Page1
				.clickOnSelectAll()
				.enterNedocsUpdateValue(strStatusTypeValues[0],
						objView_data.strValueForNDST)
				.clickOnCalculateButton(strStatusTypeValues[0])

				.enterNedocsUpdateValue(strStatusTypeValues[1],
						objView_data.strValueForNDST1)
				.clickOnCalculateButton(strStatusTypeValues[1])
				.enterNedocsUpdateValue(strStatusTypeValues[2],
						objView_data.strValueForNDST2)
				.clickOnCalculateButton(strStatusTypeValues[1])

				.clickOnSaveButton()
				.verifyUpdatedStatusValues(strResourceValue[0],
						strStatusTypeValues[0], objView_data.strNEDOCValue)
				.verifyUpdatedStatusValues(strResourceValue[0],
						strStatusTypeValues[1], objView_data.strNEDOCValue2)
				.verifyUpdatedStatusValues(strResourceValue[0],
						strStatusTypeValues[2], objView_data.strNEDOCValue3);

		objNavigationToSubmenus1.navigateToStatusTypesInSetup();

		objStatusTypeList1
				.clickOnEditOfStatusType(
						objStatusTypes_data.strNDSTStatusTypeName)
				.deselectDisplayNEDOCSLabelCheckbox()
				.clickOnSaveButton()
				.clickOnEditOfStatusType(
						objStatusTypes_data.strNDSTStatusTypeName1)
				.deselectDisplayNEDOCSLabelCheckbox()
				.clickOnSaveButton()
				.clickOnEditOfStatusType(
						objStatusTypes_data.strNDSTStatusTypeName2)
				.deselectDisplayNEDOCSLabelCheckbox().clickOnSaveButton();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus_Page1
		.clickOnSelectAll()
				.enterNedocsUpdateValue(strStatusTypeValues[0],
						objView_data.strValueForNDST1)

				.enterNedocsUpdateValue(strStatusTypeValues[1],
						objView_data.strValueForNDST2)

				.enterNedocsUpdateValue(strStatusTypeValues[2],
						objView_data.strValueForNDST)
				.clickOnCalculateButton(strStatusTypeValues[1])
				.verDisasterTextIsNotDispWhileCalculataingNedocs(
						objView_data.strNEDOCValueInUpdateScreen)

				.clickOnSaveButton()
				.verUpdatedNedocsDoesNotIncludesDisasterTextInViewPage(
						objStatusTypes_data.strNDSTStatusTypeName,
						objView_data.strNEDOCValue2)
				.verUpdatedNedocsDoesNotIncludesDisasterTextInViewPage(
						objStatusTypes_data.strNDSTStatusTypeName1,
						objView_data.strNEDOCValue3)
				.verUpdatedNedocsDoesNotIncludesDisasterTextInViewPage(
						objStatusTypes_data.strNDSTStatusTypeName2,
						objView_data.strNEDOCValue);

		objNavigationToSubmenus1.navigateToStatusTypesInSetup();

		objStatusTypeList1
				.clickOnEditOfStatusType(
						objStatusTypes_data.strNDSTStatusTypeName)
				.selectDisplayNEDOCSLabelCheckbox()
				.clickOnSaveButton()
				.clickOnEditOfStatusType(
						objStatusTypes_data.strNDSTStatusTypeName1)
				.selectDisplayNEDOCSLabelCheckbox()
				.clickOnSaveButton()
				.clickOnEditOfStatusType(
						objStatusTypes_data.strNDSTStatusTypeName2)
				.selectDisplayNEDOCSLabelCheckbox().clickOnSaveButton();

		objNavigationToSubmenus1
				.navigateToParticularViewUnderViewMenu(objView_data.strViewName);

		objViewsList1.clickOnUpdateStatus(objResource_data.strResourceName);

		objUpdateStatus_Page1
		.clickOnSelectAll()
				.enterNedocsUpdateValue(strStatusTypeValues[0],
						objView_data.strValueForNDST2)

				.enterNedocsUpdateValue(strStatusTypeValues[1],
						objView_data.strValueForNDST)

				.enterNedocsUpdateValue(strStatusTypeValues[2],
						objView_data.strValueForNDST1)
				.clickOnCalculateButton(strStatusTypeValues[1])
				.clickOnSaveButton()

				.verifyUpdatedStatusValues(strResourceValue[0],
						strStatusTypeValues[0], objView_data.strNEDOCValue3)
				.verifyUpdatedStatusValues(strResourceValue[0],
						strStatusTypeValues[1], objView_data.strNEDOCValue)
				.verifyUpdatedStatusValues(strResourceValue[0],
						strStatusTypeValues[2], objView_data.strNEDOCValue2);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
}
