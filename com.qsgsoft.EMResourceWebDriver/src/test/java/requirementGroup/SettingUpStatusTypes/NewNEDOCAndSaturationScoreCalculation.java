package requirementGroup.SettingUpStatusTypes;

import lib.dataObject.EventSetUp_data;
import lib.dataObject.Event_data;
import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.dataObject.View_data;
import lib.module.NavigationToSubMenus;
import lib.page.EventManagement;
import lib.page.EventSetUp;
import lib.page.EventStatus;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UpdateStatus;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewNEDOCAndSaturationScoreCalculation extends TestNG_UI_EXTENSIONS {

	public NewNEDOCAndSaturationScoreCalculation()
			throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/*********************************************************************************
	'Description : Verify that scores for 'Saturation score' and 'NEDOC' is calculated only when clicked on 'Calculate' button  
	'Precondition:
	'Date	 	 : 05-Oct-2015
	'Author		 : Renushree
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**********************************************************************************/
	@Test(description = "Verify that scores for 'Saturation score' and 'NEDOC' is calculated only when clicked on 'Calculate' button ")
	public void testHappyDay120528() throws Exception {

		gstrTCID = "120528";
		gstrTO = "Verify that scores for 'Saturation score' and 'NEDOC' is calculated only when clicked on 'Calculate' button ";

		Login_data objTest_data = new Login_data();

		UsersList objUsersList_page = new UsersList(this.driver1);
		User_data objUserdata = new User_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		View_data objView_data = new View_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		Event_data objEvent_data = new Event_data();

		EventSetUp objEventSetUp = new EventSetUp(this.driver1);
		EventManagement objEventManagement = new EventManagement(this.driver1);
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();

		ResourceType objResourceType_Page = new ResourceType(this.driver1);
		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver1);
		Resource objResource_Page = new Resource(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);

		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		UpdateStatus objUpdateStatus1 = new UpdateStatus(this.driver1);

		String strResourceValue[] = new String[1];
		String strStatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strEventTemplateValue[] = new String[1];

		Login objLogin1 = new Login(this.driver1);
		EventManagement objEventManagement1 = new EventManagement(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);

		System.out.println("-----Precondtion execution starts------");

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

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

		// Resource creation
		objResource_Page.navigateToResourceListPage()

		.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource_Page
				.getResourceValue(objResource_data.strResourceName);

		objUsersList_page
				.navigateToUsersNew()
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole()
				.selectRunReportRight(objResource_data.strResourceName)
				.selectUpdateStatusOfResource(objResource_data.strResourceName)
				.selectViewResourceRights(objResource_data.strResourceName)
				.clickAdvancedOptionAndExpand().selectReportEventDetailOption()
				.selectMaintainEventsOption()
				.clickSaveButton();

		System.out.println(objUserdata.strNewUserName);

		objEventSetUp.navigateToEventSetUp();

		String[] strResTypeVal = { strResourceTypeValue[0] };

		objEventSetUp.createEventTemplate(objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResTypeVal,
				strStatusTypeValues).deselectSelectAllWebOption();

		strEventTemplateValue[0] = objEventManagement
				.getEventTemplateValue(objEventSetUp_data.strEventTemplate);

		objLogin.clickLogOut();

		objLogin1.loginAsNewUser(objUserdata.strNewUserName,
				objUserdata.strNewPassword);

		objRegionDefault1.selectFrame();
		
		objEventManagement1.navigateToEventManagement();

		objEventManagement1.clickOnCreateNewEvent();

		String[] strResVal = { strResourceValue[0] };

		objEventManagement1
				.clickOnCreateEvent(objEventSetUp_data.strEventTemplate)
				.enterAdHocEventName(objEvent_data.strEventName)
				.enterAdHocEventDescription(objEvent_data.strEventDescription)
				.selectResource(strResVal).clickOnSaveButton()
				.verifyEventName(objEvent_data.strEventName);

		objEventManagement1
				.clickOnEventNameInEventBanner(objEvent_data.strEventName);

		objEventStatus1
				.clickOnUpdateStatusKey(objResource_data.strResourceName);

		objUpdateStatus1
				.enterNedocsUpdateValue(strStatusTypeValues[0],
						objView_data.strValueForNDST)
				.verNedocScoreCalculatedOnlyAfterClickOnCalcute(
						strStatusTypeValues[0], objView_data.strNEDOCValueInUpdateScreen)
				.clickOnSaveButton();

		objLogin1.clickLogOut();
		
		gstrResult = "PASS";
	}
}
