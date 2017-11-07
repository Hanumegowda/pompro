package requirementGroup.CreatingAndManagingEvents;

import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import lib.dataObject.EventSetUp_data;
import lib.dataObject.Event_data;
import lib.dataObject.Login_data;
import lib.dataObject.RegionalInfo_data;
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
import lib.page.Regions;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UsersList;
import lib.page.ViewsList;

import org.testng.annotations.Test;

import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.UserDefinedFunctions.PathsProperties;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewCreatingAndManagingEvents extends TestNG_UI_EXTENSIONS{

	public NewCreatingAndManagingEvents() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/*******************************************************************************************************************
	'Description	: 	Verify that resources can be added to a multi region event.
	'Date	 		:	06-Aug-2014
	'Author			:	Anil
	********************************************************************************************************************/
	@Test(description = "Verify that resources can be added to a multi region event.")
	public void testHappyDay68595() throws Exception {
		
		gstrTCID = "68595";
		gstrTO = "Verify that resources can be added to a multi region event.";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();
		View_data objView_data = new View_data();
		NavigationToSubMenus NavigationToSubMenus_page = new NavigationToSubMenus(this.driver1);
		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		EventSetUp EventSetUp_page = new EventSetUp(this.driver1);
		Regions Regions_page = new Regions(this.driver1);
		ViewsList ViewsList_page = new ViewsList(this.driver1);
		EventManagement EventManagement_page = new EventManagement(this.driver1);
		
		String strstatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		String strstatusTypeValues1[] = new String[1];
		String strResourceTypeValue1[] = new String[1];
		String strResourceValue1[] = new String[1];
		String strRegionValue[] = new String[2];

		OfficeCommonFunctions objOffCommonFunc=new OfficeCommonFunctions();
		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		
		String strRegionNames[] = {objTest_data.strRegionName, objTest_data.strRegionName1};
		Arrays.sort(strRegionNames);
		
		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(strRegionNames[0]);
		
		RegionDefault_page.selectFrame();
		
		NavigationToSubMenus_page.navigateToRegions();
		
		strRegionValue[0] = Regions_page.getRegionValue(strRegionNames[0]);
		System.out.println(strRegionValue[0]);
		
		strRegionValue[1] = Regions_page.getRegionValue(strRegionNames[1]);

		System.out.println(strRegionValue[1]);
		
		NavigationToSubMenus_page.navigateToViews();
		
		ViewsList_page.createNewSection(objView_data.strSectionName);
		
		// RoleBased statustypes
		StatusTypeList_page.navigateToStatusTypeListNew()
					
		.createStatusTypeWithSection(objStatuTypes_data.strNumberStatusType,
						objStatuTypes_data.strNSTStatusTypeName,
						objStatuTypes_data.strStatusDescription, objView_data.strSectionName);

		strstatusTypeValues[0] = StatusTypeList_page
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		// Resource type creation		
		ResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strstatusTypeValues);

		strResourceTypeValue[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		Resource_Page.navigateToResourceListPage()

		.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName);

		// Event Template creation
		EventSetUp_page.navigateToEventSetUp();

		EventSetUp_page.createEventTemplateWithMultiRegion(
				objEventSetUp_data.strEventTemplate,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
				strstatusTypeValues)

		.deselectSelectAllWebOption();
		
		// User creation
		UsersList_page
				.navigateToUsers()

				.clickCreateNewUserButton()

				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				
				.selectFirstRole()
								
				.selectUpdateStatusOfResource(objResource_data.strResourceName)

				.clickAdvancedOptionAndExpand()

				.selectMaintainEventsOption()

				.clickSaveButton()
	
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
					
				.clickRegionsLinkForUser(objUser_data.strNewUserName)
				
				.selectRegion(strRegionValue[1])
				
				.clickSaveButton();
		
		RegionDefault_page.clickRegionLink();
		
		SelectRegion_page.selectRegionAndNavigate(strRegionNames[1]);
		
		RegionDefault_page.selectFrame();
		// RoleBased statustypes
		
		NavigationToSubMenus_page.navigateToViews();
		
		ViewsList_page.createNewSection(objView_data.strSectionName1);
		
		StatusTypeList_page.navigateToStatusTypeListNew()
					
		.createStatusTypeWithSection(objStatuTypes_data.strNumberStatusType,
						objStatuTypes_data.strNSTStatusTypeName1,
						objStatuTypes_data.strStatusDescription, objView_data.strSectionName1);

		strstatusTypeValues1[0] = StatusTypeList_page
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName1);

		// Resource type creation		
		ResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName1,
				strstatusTypeValues1);

		strResourceTypeValue1[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName1);

		// Resource creation
		Resource_Page.navigateToResourceListPage()

		.createResource(objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName1,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue1[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName1);

		// Event Template creation
		EventSetUp_page.navigateToEventSetUp();

		EventSetUp_page.createEventTemplateWithMultiRegion(
				objEventSetUp_data.strEventTemplate1,
				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue1,
				strstatusTypeValues1)

		.deselectSelectAllWebOption();

		// User creation
		UsersList_page
				.navigateToUsers()

				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)

				.editUserDetails(objUser_data.strNewUserName)
				
				.selectFirstRole()
								
				.selectUpdateStatusOfResource(objResource_data.strResourceName1)

				.selectViewResourceRights(objResource_data.strResourceName1)
				
				.clickAdvancedOptionAndExpand()

				.selectMaintainEventsOption()

				.clickSaveButton()
		
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
		
				.editUserDetails(objUser_data.strNewUserName)
						
				.clickMultiRegionEventRights()
				
				.selectUserRegion(strRegionValue[0])
				
				.selectUserRegion(strRegionValue[1])
				
				.clickSaveButton()
				
				.clickSaveButton();

		login_page.clickLogOut();

		login_page.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		
		SelectRegion_page.selectRegionAndNavigate(strRegionNames[1]);
		
		RegionDefault_page.selectFrame();
		
		// Event  creation		
		EventManagement_page.navigateToEventManagement()

		.createNewMultiEventButton()

		.enterAdHocEventName(objEvent_data.strEventName)

		.enterAdHocEventDescription(objEvent_data.strEventDescription)

		.selectEventTemplateForMRE(strRegionValue[0], objEventSetUp_data.strEventTemplate)
		
		.selectEventTemplateForMRE(strRegionValue[1], objEventSetUp_data.strEventTemplate1)
				
		.deselectIncludeAllResourcesOption()
			
		.clickOnNextButton()
		
		.clickOnNextButton()
		
		.clickOnNextButton()
		
		.clickOnYesButton()
	
		.verifyEventName(objEvent_data.strEventName);	

		login_page.clickLogOut();
		
		login_page1.loginToApplication(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		
		RegionDefault_page1.selectFrame();
		
		SelectRegion_page1.selectRegionAndNavigate(strRegionNames[0]);
		
		RegionDefault_page1.selectFrame();
		
		EventManagement_page1.navigateToEventManagement()
		
		.clickOnEditLink(objEvent_data.strEventName)
		
		.clickOnNextButton()
		
		.selectResource(strResourceValue[0])
		
		.clickOnNextButton()
		
		.selectResource(strResourceValue1[0])
			
		.clickOnNextButton()
		
		.clickOnYesButton()
		
		.verifyEventName(objEvent_data.strEventName);
		String strEvent = "Update 1: "+objEvent_data.strEventName;
		
		EventManagement_page1.clickOnEventNameInEventBanner(strEvent);
		
			objEventStatus1.verResourceTypeAndResourceName(
				objResourceType_data.strResourceTypeName,
				objResource_data.strResourceName);

			objEventStatus1.verStatusTypes(
					objResourceType_data.strResourceTypeName,
					objStatuTypes_data.strNSTStatusTypeName);
		
		SelectRegion_page1.selectRegionAndNavigate(strRegionNames[1]);
		
		RegionDefault_page1.selectFrame();
		
		EventManagement_page1.clickOnEventNameInEventBanner(strEvent);
		
		objEventStatus1.verResourceTypeAndResourceName(
			objResourceType_data.strResourceTypeName1,
			objResource_data.strResourceName1);

		objEventStatus1.verStatusTypes(
				objResourceType_data.strResourceTypeName1,
				objStatuTypes_data.strNSTStatusTypeName1);
	
		login_page1.clickLogOut();
		
		String[] strTestData = {
				Login_data.strBuildName,
				gstrTCID,
				objUser_data.strNewUserName + "/" + objUser_data.strNewPassword,
				objEventSetUp_data.strEventTemplate,
				objEvent_data.strEventName,
				"Verify mobile end condition with event name and both resources name displayed",
				objStatuTypes_data.strNSTStatusTypeName ,
				objResource_data.strResourceName,
				objResourceType_data.strResourceTypeName,
				strRegionNames[0] };

		String[] strTestData1 = {
				Login_data.strBuildName,
				gstrTCID,
				objUser_data.strNewUserName + "/" + objUser_data.strNewPassword,
				objEventSetUp_data.strEventTemplate1,
				objEvent_data.strEventName,
				"Verify mobile end condition with event name and both resources name displayed",
				objStatuTypes_data.strNSTStatusTypeName1 ,
				objResource_data.strResourceName1,
				objResourceType_data.strResourceTypeName1,
				strRegionNames[1] };
		objOffCommonFunc.writeResultData(strTestData,
				strPartialAutoResultsPath, "Events");
		
		objOffCommonFunc.writeResultData(strTestData1,
				strPartialAutoResultsPath, "Events");
		
		gstrResult= "PASS";
	}	
	
	/*******************************************************************************************************************
	'Description	: 	Verify that a file can be attached to a multi region event.
	'Date	 		:	06-Aug-2014
	'Author			:	Anil
	********************************************************************************************************************/
	@Test(description = "Verify that a file can be attached to a multi region event.")
	public void testHappyDay68598() throws Exception {
		
		gstrTCID = "68598";
		gstrTO = "Verify that a file can be attached to a multi region event.";

		Login_data objTest_data = new Login_data();
		User_data objUser_data = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();
		RegionalInfo_data objRegionalInfo_data = new RegionalInfo_data();
		
		NavigationToSubMenus NavigationToSubMenus_page = new NavigationToSubMenus(this.driver1);
		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		EventSetUp EventSetUp_page = new EventSetUp(this.driver1);
		Regions Regions_page = new Regions(this.driver1);

		String strRegionValue[] = new String[2];

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);
		
		String strRegionNames[] = {objTest_data.strRegionName, objTest_data.strRegionName1};
		Arrays.sort(strRegionNames);
		
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();
		
		String fileDownloadPath = pathProps
				.getProperty(objRegionalInfo_data.strFileUpload);

		File file = new File(System.getProperty("user.dir") + fileDownloadPath);	
		String strPath = file.toString();
		
		String fileDownloadPath2 = pathProps
				.getProperty(objRegionalInfo_data.strHtmlFileUpload);

		File file2 = new File(System.getProperty("user.dir") + fileDownloadPath2);	
		String strPath2 = file2.toString();
		
		String fileDownloadPath3 = pathProps
				.getProperty(objRegionalInfo_data.strPdfFileUpload);

		File file3 = new File(System.getProperty("user.dir") + fileDownloadPath3);	
		String strPath3 = file3.toString();
		
		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(strRegionNames[0]);
		
		RegionDefault_page.selectFrame();
		
		NavigationToSubMenus_page.navigateToRegions();
		
		strRegionValue[0] = Regions_page.getRegionValue(strRegionNames[0]);
		System.out.println(strRegionValue[0]);
		
		strRegionValue[1] = Regions_page.getRegionValue(strRegionNames[1]);

		System.out.println(strRegionValue[1]);

		// Event Template creation
		EventSetUp_page.navigateToEventSetUp();

//		EventSetUp_page.createEventTemplateWithMultiRegion(
//				objEventSetUp_data.strEventTemplate,
//				objEventSetUp_data.strTemplateDefinition, strResourceTypeValue,
//				strstatusTypeValues)
		EventSetUp_page.clickOncreateEventTemplate();
		EventSetUp_page.enterEventTemplateName(objEventSetUp_data.strEventTemplate);
		EventSetUp_page.enterEventTemplateDefintion(objEventSetUp_data.strTemplateDefinition);
				
		EventSetUp_page.selectMultiRegionOption();
		EventSetUp_page.clickSaveButton()
		.deselectSelectAllWebOption();
		
		// User creation
		UsersList_page
				.navigateToUsers()

				.clickCreateNewUserButton()

				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				
				.selectFirstRole()

				.clickAdvancedOptionAndExpand()

				.selectMaintainEventsOption()

				.clickSaveButton()
	
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
					
				.clickRegionsLinkForUser(objUser_data.strNewUserName)
				
				.selectRegion(strRegionValue[1])
				
				.clickSaveButton();
		
		RegionDefault_page.clickRegionLink();
		
		SelectRegion_page.selectRegionAndNavigate(strRegionNames[1]);
		
		RegionDefault_page.selectFrame();
		// RoleBased statustypes
		

		// Event Template creation
		EventSetUp_page.navigateToEventSetUp();

		EventSetUp_page.clickOncreateEventTemplate();
		EventSetUp_page.enterEventTemplateName(objEventSetUp_data.strEventTemplate1);
		EventSetUp_page.enterEventTemplateDefintion(objEventSetUp_data.strTemplateDefinition);
				
		EventSetUp_page.selectMultiRegionOption();
		EventSetUp_page.clickSaveButton()
		.deselectSelectAllWebOption();

		// User creation
		UsersList_page
				.navigateToUsers()

				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)

				.editUserDetails(objUser_data.strNewUserName)
				
				.selectFirstRole()
				
				.clickAdvancedOptionAndExpand()

				.selectMaintainEventsOption()

				.clickSaveButton()
		
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
		
				.editUserDetails(objUser_data.strNewUserName)
						
				.clickMultiRegionEventRights()
				
				.selectUserRegion(strRegionValue[0])
				
				.selectUserRegion(strRegionValue[1])
				
				.clickSaveButton()
				
				.clickSaveButton();

		login_page.clickLogOut();

		System.out.println(objUser_data.strNewUserName);
		
		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		
		SelectRegion_page1.selectRegionAndNavigate(strRegionNames[0]);
		
		RegionDefault_page1.selectFrame();
		
		// Event  creation		
		EventManagement_page1.navigateToEventManagement()

		.createNewMultiEventButton()

		.enterAdHocEventName(objEvent_data.strEventName)
		
		.enterFilePath(strPath)
		.enterAdHocEventDescription(objEvent_data.strEventDescription)

		.selectEventTemplateForMRE(strRegionValue[0], objEventSetUp_data.strEventTemplate)
		
		.selectEventTemplateForMRE(strRegionValue[1], objEventSetUp_data.strEventTemplate1)
			
		.clickOnNextButton()
		
		.clickOnYesButton()
	
		.verifyEventName(objEvent_data.strEventName);	

		String strEventId =EventManagement_page1.getEventId(objEvent_data.strEventName);
		
		EventManagement_page1.clickOnEventNameInEventBanner(objEvent_data.strEventName);
		
		EventManagement_page1.clickOnAttachedFileLink(strEventId);
		
		Thread.sleep(5000);
		
		String mainWindowHandle = driver1.getWindowHandle();

		Set<String> a = driver1.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		EventManagement_page1.verifyAttachedText(objEvent_data.strAttachedFileText);
		
		driver1.close();

		driver1.switchTo().window(mainWindowHandle);

		RegionDefault_page1.selectFrame();

		// Event  creation		
		EventManagement_page1.navigateToEventManagement()

		.createNewMultiEventButton()

		.enterAdHocEventName(objEvent_data.strEventName1)
		
		.enterFilePath(strPath2)
		.enterAdHocEventDescription(objEvent_data.strEventDescription)

		.selectEventTemplateForMRE(strRegionValue[0], objEventSetUp_data.strEventTemplate)
		
		.selectEventTemplateForMRE(strRegionValue[1], objEventSetUp_data.strEventTemplate1)
			
		.clickOnNextButton()
		
		.clickOnYesButton()
	
		.verifyEventName(objEvent_data.strEventName1);	

		String strEventId1 =EventManagement_page1.getEventId(objEvent_data.strEventName1);
		
		EventManagement_page1.clickOnEventNameInEventBanner(objEvent_data.strEventName1);
		
		EventManagement_page1.clickOnAttachedFileLink(strEventId1);

		
		String mainWindowHandle1 = driver1.getWindowHandle();
		
		Thread.sleep(5000);
		
		Set<String> a1 = driver1.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle = ite1.next().toString();

			if (!popupHandle.contains(mainWindowHandle1)) {
				driver1.switchTo().window(popupHandle);
				System.out.println("In");
			}
		}
		EventManagement_page1.verifyHTMLAttachedFile(objEvent_data.strAttachedHTMLText);
		
		driver1.close();

		driver1.switchTo().window(mainWindowHandle1);

		RegionDefault_page1.selectFrame();
		
		// Event  creation		
		EventManagement_page1.navigateToEventManagement()

		.createNewMultiEventButton()

		.enterAdHocEventName(objEvent_data.strEventName2)
		
		.enterFilePath(strPath3)
		
		.enterAdHocEventDescription(objEvent_data.strEventDescription)

		.selectEventTemplateForMRE(strRegionValue[0], objEventSetUp_data.strEventTemplate)
		
		.selectEventTemplateForMRE(strRegionValue[1], objEventSetUp_data.strEventTemplate1)
			
		.clickOnNextButton()
		
		.clickOnYesButton()
	
		.verifyEventName(objEvent_data.strEventName2);	

		String strEventId2 =EventManagement_page1.getEventId(objEvent_data.strEventName2);
		
		EventManagement_page1.clickOnEventNameInEventBanner(objEvent_data.strEventName2);
		
		EventManagement_page1.verifyAttachedFileLink(strEventId2);
		
		SelectRegion_page1.selectRegionAndNavigate(strRegionNames[1]);
		
		RegionDefault_page1.selectFrame();

		EventManagement_page1.clickOnEventNameInEventBanner(objEvent_data.strEventName);
		
		EventManagement_page1.clickOnAttachedFileLink(strEventId);
		
		Thread.sleep(5000);
		
		String mainWindowHandle2 = driver1.getWindowHandle();

		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle = ite2.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		EventManagement_page1.verifyAttachedText(objEvent_data.strAttachedFileText);
		
		driver1.close();

		driver1.switchTo().window(mainWindowHandle2);

		RegionDefault_page1.selectFrame();
		
		EventManagement_page1.clickOnEventNameInEventBanner(objEvent_data.strEventName1);
		
		Thread.sleep(5000);
		
		String mainWindowHandle3 = driver1.getWindowHandle();

		Set<String> a3 = driver1.getWindowHandles();
		Iterator<String> ite3 = a3.iterator();

		while (ite3.hasNext()) {
			String popupHandle = ite3.next().toString();

			if (!popupHandle.contains(mainWindowHandle3)) {
				driver1.switchTo().window(popupHandle);

			}
		}
		
		EventManagement_page1.verifyHTMLAttachedFile(strEventId1);
		
		driver1.close();

		driver1.switchTo().window(mainWindowHandle3);

		RegionDefault_page1.selectFrame();
		
		EventManagement_page1.clickOnEventNameInEventBanner(objEvent_data.strEventName2);
		
		EventManagement_page1.verifyAttachedFileLink(strEventId2);
		
		login_page.clickLogOut();
		
		gstrResult= "PASS";
	}	

	
	
	/*******************************************************************************************************************
	'Description	: 	 " 	Create a multi region event by selecting different templates ,T1 from region X and T2 from region Y and verify that:"+
				"a. The event banner is present for region X with the color and icon of template T1"+
				"b. The event banner is present for region Y with the color and icon of template T2. 
	'Date	 		:	06-Aug-2014
	'Author			:	Anil
	********************************************************************************************************************/
	@Test(description = "	Create a multi region event by selecting different templates ,T1 from region X and T2 from region Y and verify that:"+
				"a. The event banner is present for region X with the color and icon of template T1"+
				"b. The event banner is present for region Y with the color and icon of template T2. ")
	public void testHappyDay68534() throws Exception {
		
		gstrTCID = "68534";
		gstrTO = " 	Create a multi region event by selecting different templates ,T1 from region X and T2 from region Y and verify that:"+
				"a. The event banner is present for region X with the color and icon of template T1"+
				"b. The event banner is present for region Y with the color and icon of template T2. ";

		Login_data objTest_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource_data objResource_data = new Resource_data();
		User_data objUser_data = new User_data();
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		Event_data objEvent_data = new Event_data();
		View_data objView_data = new View_data();
		NavigationToSubMenus NavigationToSubMenus_page = new NavigationToSubMenus(this.driver1);
		Login login_page = new Login(this.driver1);
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);
		StatusTypeList StatusTypeList_page = new StatusTypeList(this.driver1);
		ResourceType ResourceType_Page = new ResourceType(this.driver1);
		Resource Resource_Page = new Resource(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		EventSetUp EventSetUp_page = new EventSetUp(this.driver1);
		Regions Regions_page = new Regions(this.driver1);
		ViewsList ViewsList_page = new ViewsList(this.driver1);
		EventManagement EventManagement_page = new EventManagement(this.driver1);
		
		String strstatusTypeValues[] = new String[1];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		String strstatusTypeValues1[] = new String[1];
		String strResourceTypeValue1[] = new String[1];
		String strResourceValue1[] = new String[1];
		String strRegionValue[] = new String[2];

		OfficeCommonFunctions objOffCommonFunc=new OfficeCommonFunctions();
		String strPartialAutoResultsPath = Login_data.strPartialAutoResultsPath;

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		EventManagement EventManagement_page1 = new EventManagement(this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);
		EventStatus objEventStatus1 = new EventStatus(this.driver1);
		UsersList UsersList_page1 = new UsersList(this.driver1);
		EventSetUp EventSetUp_page1 = new EventSetUp(this.driver1);
		
		String strRegionNames[] = {objTest_data.strRegionName, objTest_data.strRegionName1};
		Arrays.sort(strRegionNames);
		
		login_page.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page.selectRegionAndNavigate(strRegionNames[0]);
		
		RegionDefault_page.selectFrame();
		
		NavigationToSubMenus_page.navigateToRegions();
		
		strRegionValue[0] = Regions_page.getRegionValue(strRegionNames[0]);
		System.out.println(strRegionValue[0]);
		
		strRegionValue[1] = Regions_page.getRegionValue(strRegionNames[1]);

		System.out.println(strRegionValue[1]);
		
		NavigationToSubMenus_page.navigateToViews();
		
		ViewsList_page.createNewSection(objView_data.strSectionName);
		
		// RoleBased statustypes
		StatusTypeList_page.navigateToStatusTypeListNew()
					
		.createStatusTypeWithSection(objStatuTypes_data.strNumberStatusType,
						objStatuTypes_data.strNSTStatusTypeName,
						objStatuTypes_data.strStatusDescription, objView_data.strSectionName);

		strstatusTypeValues[0] = StatusTypeList_page
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		// Resource type creation		
		ResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName,
				strstatusTypeValues);

		strResourceTypeValue[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);

		// Resource creation
		Resource_Page.navigateToResourceListPage()

		.createResource(objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName);
		System.out.println(objUser_data.strNewUserName);
		// User creation
		UsersList_page
				.navigateToUsers()

				.clickCreateNewUserButton()

				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				
				.selectFirstRole()
								
				.selectUpdateStatusOfResource(objResource_data.strResourceName)

				.clickAdvancedOptionAndExpand()

				.selectMaintainEventsOption()

				.clickSaveButton()
	
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
					
				.clickRegionsLinkForUser(objUser_data.strNewUserName)
				
				.selectRegion(strRegionValue[1])
				
				.clickSaveButton();
		
		SelectRegion_page.selectRegionAndNavigate(strRegionNames[1]);
		
		RegionDefault_page.selectFrame();
		// RoleBased statustypes
		
		NavigationToSubMenus_page.navigateToViews();
		
		ViewsList_page.createNewSection(objView_data.strSectionName1);
		
		StatusTypeList_page.navigateToStatusTypeListNew()
					
		.createStatusTypeWithSection(objStatuTypes_data.strNumberStatusType,
						objStatuTypes_data.strNSTStatusTypeName1,
						objStatuTypes_data.strStatusDescription, objView_data.strSectionName1);

		strstatusTypeValues1[0] = StatusTypeList_page
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName1);

		// Resource type creation		
		ResourceType_Page.navigateToResourceTypePage()

		.createResourceType(objResourceType_data.strResourceTypeName1,
				strstatusTypeValues1);

		strResourceTypeValue1[0] = ResourceType_Page
				.getResourceTypeValue(objResourceType_data.strResourceTypeName1);

		// Resource creation
		Resource_Page.navigateToResourceListPage()

		.createResource(objResource_data.strResourceName1,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName1,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue1[0] = Resource_Page
				.getResourceValue(objResource_data.strResourceName1);

		UsersList_page
		.navigateToUsers()

		.searchUserName(objUser_data.strNewUserName,
				objUser_data.strRole, objUser_data.strResourceType,
				objUser_data.strUsername, objUser_data.strsearchOption)
		
		.editUserDetails(objUser_data.strNewUserName)
		
		.selectFirstRole()
						
		.selectUpdateStatusOfResource(objResource_data.strResourceName1)

		.selectViewResourceCheckBox(objResource_data.strResourceName1)
		
		.clickAdvancedOptionAndExpand()

		.selectMaintainEventsOption()

		.clickSaveButton();

		login_page.clickLogOut();
		
		login_page1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		SelectRegion_page1.selectRegionAndNavigate(strRegionNames[0]);
		
		RegionDefault_page1.selectFrame();


		// User creation
		UsersList_page1
				.navigateToUsers()
		
				.searchUserName(objUser_data.strNewUserName,
						objUser_data.strRole, objUser_data.strResourceType,
						objUser_data.strUsername, objUser_data.strsearchOption)
		
				.editUserDetails(objUser_data.strNewUserName)
						
				.clickMultiRegionEventRights()
				
				.verifyRegionName(strRegionValue[0])
				.verifyRegionName(strRegionValue[1]).verifySelectAllButton()
				.verifyEditMultiRegionEventRights()
				
				.selectUserRegion(strRegionValue[0])
				
				.selectUserRegion(strRegionValue[1])
				
				.clickSaveButton()
				
				.clickSaveButton();	
		
		// Event Template creation
		EventSetUp_page1.navigateToEventSetUp();

		EventSetUp_page1.clickOncreateEventTemplate();
		EventSetUp_page1.verCreateNewTemplateScreenIsDisplayed();
		
		EventSetUp_page1.enterEventTemplateName(objEventSetUp_data.strEventTemplate);
		EventSetUp_page1.enterEventTemplateDefintion(objEventSetUp_data.strTemplateDefinition);

		EventSetUp_page1.selectETColor(objEventSetUp_data.strBlackColor);
		
		EventSetUp_page1.selectResourceType(strResourceTypeValue[0]);

		EventSetUp_page1.selectStatusType(strstatusTypeValues[0]);
		EventSetUp_page1.selectMultiRegionOption();
		EventSetUp_page1.clickSaveButton()

		.deselectSelectAllWebOption();
		EventSetUp_page1.verEveTemplateListScreenIsDisplayed();
		
		SelectRegion_page1.selectRegionAndNavigate(strRegionNames[1]);
		
		RegionDefault_page1.selectFrame();
		
		// Event Template creation
		EventSetUp_page1.navigateToEventSetUp();

		EventSetUp_page1.clickOncreateEventTemplate();
		EventSetUp_page1.verCreateNewTemplateScreenIsDisplayed();
		EventSetUp_page1.enterEventTemplateName(objEventSetUp_data.strEventTemplate1);
		EventSetUp_page1.enterEventTemplateDefintion(objEventSetUp_data.strTemplateDefinition);

		EventSetUp_page1.selectResourceType(strResourceTypeValue1[0]);
		EventSetUp_page1.selectETColor(objEventSetUp_data.strETBlueColor);
		EventSetUp_page1.selectStatusType(strstatusTypeValues1[0]);
		EventSetUp_page1.selectMultiRegionOption();
		EventSetUp_page1.clickSaveButton()

		.deselectSelectAllWebOption();
		EventSetUp_page1.verEveTemplateListScreenIsDisplayed();
		
		login_page1.clickLogOut();

		login_page1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		
		SelectRegion_page1.selectRegionAndNavigate(strRegionNames[1]);
		
		RegionDefault_page1.selectFrame();
		
		// Event  creation		
		EventManagement_page1.navigateToEventManagement()

		.createNewMultiEventButton()
		
		.enterAdHocEventName(objEvent_data.strEventName)

		.enterAdHocEventDescription(objEvent_data.strEventDescription)

		.selectEventTemplateForMRE(strRegionValue[0], objEventSetUp_data.strEventTemplate)
		
		.selectEventTemplateForMRE(strRegionValue[1], objEventSetUp_data.strEventTemplate1)
			
		.clickOnNextButton()
		
		.verifyMultiRegionEventConfirmationPage()

		.verifyRegionAndETName(strRegionNames[0], objEventSetUp_data.strEventTemplate)

		.verifyRegionAndETName(strRegionNames[1], objEventSetUp_data.strEventTemplate1)

		.verifyConfirmationMessage()
		
		.clickOnYesButton()
	
		.verifyEventName(objEvent_data.strEventName)
		
		.verifyEventColorInEventBanner(objEvent_data.strEventName, objEventSetUp_data.strETBlueColor);

		login_page1.clickLogOut();
		
		login_page1.loginToApplication(objUser_data.strNewUserName,
				objUser_data.strNewPassword);
		
		RegionDefault_page1.selectFrame();
		
		SelectRegion_page1.selectRegionAndNavigate(strRegionNames[0]);
		
		RegionDefault_page1.selectFrame();
		
		EventManagement_page1.navigateToEventManagement();
	
		EventManagement_page1.verifyEventName(objEvent_data.strEventName);	
		
		EventManagement_page1.verifyEventColorInEventBanner(objEvent_data.strEventName, objEventSetUp_data.strBlackColor);
		
		login_page1.clickLogOut();

		
		gstrResult= "PASS";
	}	

}
