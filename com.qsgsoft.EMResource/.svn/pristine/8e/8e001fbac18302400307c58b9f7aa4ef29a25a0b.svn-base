package RequirementGroups.SettingRegionInterfaces;

import org.testng.annotations.Test;
import qaFramework.Configurations.Configuration;
import EMR.data.InterfaceData;
import EMR.data.LoginData;
import EMR.data.RegionData;
import EMR.data.UsersData;
import EMR.data.InterfaceData.InterfaceCreateData;
import EMR.pages.InterfaceSetUp;
import EMR.pages.Login;
import EMR.pages.SelectRegion;
import EMR.pages.Shared;

public class CreatingAndManagingRegionInterface extends Configuration {

	InterfaceData interfaceData;
	InterfaceCreateData interfaceDataCreation;
	UsersData usersData;

	Login login;
	SelectRegion selectRegion;
	Shared navigateTo; 
	InterfaceSetUp interfaceSetup;
	LoginData loginData;
	RegionData regionData;

	String PRODUCT_INTERFACE_KEY;
	static String UPDATERESOURCE_AVAILBILITY_MULTIREGIONINTERFACE,EDITED_UPDATERESOURCE_AVAILBILITY_MULTIREGIONINTERFACE,PARAMETER_OF_UPDATERESOURCE_AVAILBILITY_MULTIREGIONINTERFACE,EDITED_PARAMETER_OF_UPDATERESOURCE_AVAILBILITY_MULTIREGIONINTERFACE;
	static String POSTHAvBEDINFORMATION_INTERFACE, PARAMETER_OF_POSTHAvBEDINFORMATION_INTERFACE, GET_REGION_CONFIGURATION_INTERFACE, PARAMETER_OF_GET_REGION_CONFIGURATION_INTERFACE, POST_RESOURCE_DETAIL_STATUS_INTERFACE, DESCRIPTION_OF_POST_RESOURCE_DETAIL_STATUS_INTERFACE, UPDATE_CAD_STATUS_INTERFACE, DESCRIPTION_OF_UPDATE_CAD_STATUS_INTERFACE, GET_CAD_STATUS_INTERFACE, DESCRIPTION_OF_GET_CAD_STATUS_INTERFACE, UPDATE_RESOURCE_AVAILABILITY_INTERFACE, DESCRIPTION_OF_UPDATE_RESOURCE_AVAILABILITY_INTERFACE;	
	static String FLEXIBLE_WEBEOC_INTERFACE, EDITED_FLEXIBLE_WEBEOC_INTERFACE,PARAMETER_OF_FLEXIBLE_WEBEOC_INTERFACE,EDITED_PARAMETER_OF_FLEXIBLE_WEBEOC_INTERFACE;
	static String POST_INCOMING_PATIENT,PARAMETERE_NAME_OF_POSTINCOMINGPATIENT,EDIT_INTERFACE_NAME_OF_POSTINCOMINGPATIENT,EDIT_INTERFACE_DESCRIPTION_OF_POSTINCOMINGPATIENT,EDIT_PARAMETER_NAME_OF_POSTINCOMINGPATIENT, GET_ACTIVE_EVENTS_INTERFACE, PARAMETER_OF_GET_ACTIVE_EVENTS_INTERFACE,CHICAGO_GET_HOSPITAL_STATUS_INTERFACE, PARAMETER_OF_CHICAGO_GET_HOSPITAL_STATUS_INTERFACE,EDITED_PARAMETER_OF_CHICAGO_GET_HOSPITAL_STATUS_INTERFACE,EDITED_INTERFACE_NAME_OF_CHICAGO_GET_HOSPITAL_STATUS;
	static String LAGACY_GET_HOSPITAL_STATUS,PARAMETER_OF_LAGACY_GET_HOSPITAL_STATUS,EDIT_PARAMETER_NAME_OF_LAGACY_GET_HOSPITAL_STATUS,EDIT_INTERFACE_NAME_OF_LAGACY_GET_HOSPITAL_STATUS;
	static String GET_HOSPITAL_STATUS,DESCRIPTION_GET_HOSPITAL_STATUS;
	static String GET_EDXL_HAVE,DESCRIPTION_GET_EDXL_HAVE;
	public CreatingAndManagingRegionInterface() throws Exception {
		super();
	}

	@Test (groups = {"HappyDay", "Setting Region Interfaces", "HappyDay188022"})
	public void HappyDay188022() throws Exception {

		TCID = "188022";
		TC_DESCRIPTION = "Verify that a region interface of type 'Post HAvBED 2.5.2 Information' can be created.";

		interfaceData = new InterfaceData();
		interfaceDataCreation = interfaceData.new InterfaceCreateData();
		usersData = new UsersData();

		navigateTo = new Shared(this.driver);
		interfaceSetup = new InterfaceSetUp(this.driver);

		navigateTo.interfaces();
		interfaceSetup.createInterface(interfaceDataCreation.name1, interfaceDataCreation.description1, InterfaceData.POST_HAVBED_INFORMATION, InterfaceData.WEBSERVICEACTION_FOR_POSTHAvBEDINFORMATION)
		.verifyActionsAndResourcesOfInterface(interfaceDataCreation.name1)
		.verifyCreatedInterfaceDetails(interfaceDataCreation.name1, InterfaceData.WEBSERVICEACTION_FOR_POSTHAvBEDINFORMATION, InterfaceData.POST_HAVBED_INFORMATION, InterfaceData.SCHEMA_FOR_POSTHAvBEDINFORMATION, interfaceDataCreation.description1)
		.clickOnUsersLinkAndVerifyRegionInterfaceUsersListPageIsDisplayed(interfaceDataCreation.name1)
		.verifyWebServiceUserUnderRegionInterfaceUsersListPage(usersData.interfaceRelatedWebSerivceUser, usersData.interfaceRelatedWebSerivceUserFullName)
		.verifyNoOtherUserIsDisplayedExcpetWebServiceUserOnRegionInterfaceList(usersData.interfaceRelatedUser, usersData.interfaceRelatedUserFullName)
		.clickOnCancel()
		.clickOnParametersLinkAndVerifyParameterListForRegionInterfacePageIsDisplayed(interfaceDataCreation.name1)
		.createParameter(interfaceDataCreation.parameterName, interfaceDataCreation.parameterValue)
		.verifyEditAndDeleteLinksCorrespondingToParameter(interfaceDataCreation.parameterName);
		navigateTo.interfaces();
		interfaceSetup.clickResourceLink(interfaceDataCreation.name1)
		.verifyEditInterfaceSelectResourcesPage()
		.clickOnCancel();		

		POSTHAvBEDINFORMATION_INTERFACE = interfaceDataCreation.name1;
		PARAMETER_OF_POSTHAvBEDINFORMATION_INTERFACE = interfaceDataCreation.parameterName;

		Result = "PASS";
	}

	@Test(groups = {"HappyDay","Setting Region Interfaces", "HappyDay188019"})
	public void HappyDay188019() throws Exception {

		TCID ="188019";
		TC_DESCRIPTION ="Verify that a region interface of type 'Update Resource Availability (multi-region)' can be created.";

		interfaceData = new InterfaceData();
		interfaceDataCreation = interfaceData.new InterfaceCreateData();
		usersData= new UsersData();

		navigateTo= new Shared(this.driver);
		interfaceSetup= new InterfaceSetUp(this.driver);
		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);

		navigateTo.interfaces();
		interfaceSetup
		.createProductInterface(
				interfaceDataCreation.name,
				interfaceDataCreation.description,
				InterfaceData.UPDATE_RESOURCE_AVAILAIBILTY_MULTI_REGION,
				InterfaceData.WEBSERVICE_ACTIONS_FOR_UPDATE_RESOURCE_AVAILAIBILTY_INTERFACE_MULTI_REGION,interfaceDataCreation.interface_Key)

				.verifyCreatedInterfaceDetails(
						interfaceDataCreation.name,
						InterfaceData.WEBSERVICE_ACTIONS_FOR_UPDATE_RESOURCE_AVAILAIBILTY_INTERFACE_MULTI_REGION,
						InterfaceData.UPDATE_RESOURCE_AVAILAIBILTY_MULTI_REGION,
						InterfaceData.SCHEMA_FOR_UPDATE_RESOURCE_AVAILAIBILTY_INTERFACE_MULTI_REGION,
						interfaceDataCreation.description)

						.clickUsersLink(interfaceDataCreation.name)
						.verifyWebServiceUserUnderProductInterfaceUsersListPage(usersData.interfaceRelatedWebSerivceUser,usersData.interfaceRelatedWebSerivceUserFullName)	
						.verifyNoOtherUserIsDisplayedExcpetWebServiceUserOnProductInterfaceList(usersData.interfaceRelatedUser,usersData.interfaceRelatedUserFullName)
						.clickSave()
						.clickOnParametersLinkAndVerifyParameterListForInterfacePageIsDisplayed(interfaceDataCreation.name)
						.createParameter(interfaceDataCreation.parameterName,interfaceDataCreation.parameterValue)
						.verifyEditAndDeleteLinksCorrespondingToParameter(interfaceDataCreation.parameterName)
						.navigateToInterFaceAndClickStatusTypeLink(interfaceDataCreation.name)
						.verifySelectInterfaceStatusTypePage();

		UPDATERESOURCE_AVAILBILITY_MULTIREGIONINTERFACE = interfaceDataCreation.name;
		PARAMETER_OF_UPDATERESOURCE_AVAILBILITY_MULTIREGIONINTERFACE = interfaceDataCreation.parameterName;
		PRODUCT_INTERFACE_KEY=interfaceDataCreation.interface_Key;
		Result = "PASS";
	}

	@Test(dependsOnMethods={"HappyDay188019"},groups = {"HappyDay","Setting Region Interfaces","HappyDay188020"})
	public void HappyDay188020() throws Exception {

		TCID ="188020";
		TC_DESCRIPTION ="Verify that a region interface of type 'Update Resource Availability (multi-region)' can be edited.";

		interfaceData = new InterfaceData();
		interfaceDataCreation = interfaceData.new InterfaceCreateData();

		navigateTo = new Shared(this.driver);
		interfaceSetup = new InterfaceSetUp(this.driver);

		navigateTo.interfaces();

		interfaceSetup
		.verifyInterfaceInInterfaceList(UPDATERESOURCE_AVAILBILITY_MULTIREGIONINTERFACE)
		.clickParametersLink(UPDATERESOURCE_AVAILBILITY_MULTIREGIONINTERFACE)
		.verifyParameterIsListed(PARAMETER_OF_UPDATERESOURCE_AVAILBILITY_MULTIREGIONINTERFACE);

		navigateTo.interfaces();
		interfaceSetup
		.clickEditLink(UPDATERESOURCE_AVAILBILITY_MULTIREGIONINTERFACE)
		.verifyEditProductInterfacePage()
		.verifyEnteredInterfaceKeyUnderEditInterfacePage(PRODUCT_INTERFACE_KEY)
		.editInterface(interfaceDataCreation.editInterfaceName1,
				interfaceDataCreation.editInterfaceDescription)
		.verifyCreatedInterfaceDetails(
						interfaceDataCreation.editInterfaceName1,
						InterfaceData.WEBSERVICE_ACTIONS_FOR_UPDATE_RESOURCE_AVAILAIBILTY_INTERFACE_MULTI_REGION,
						InterfaceData.UPDATE_RESOURCE_AVAILAIBILTY_MULTI_REGION,
						InterfaceData.SCHEMA_FOR_UPDATE_RESOURCE_AVAILAIBILTY_INTERFACE_MULTI_REGION,
						interfaceDataCreation.editInterfaceDescription)

		.editParameterCorrespondingToInterface(
								interfaceDataCreation.editInterfaceName1,
								PARAMETER_OF_UPDATERESOURCE_AVAILBILITY_MULTIREGIONINTERFACE,
								interfaceDataCreation.editParameterName,
								interfaceDataCreation.editParameterValue)
		.verifyParameterListForInterfacePage(interfaceDataCreation.editInterfaceName1)
		.verifyParameterIsListed(interfaceDataCreation.editParameterName)
		.verifyParameterValue(interfaceDataCreation.editParameterName,interfaceDataCreation.editParameterValue);

		EDITED_UPDATERESOURCE_AVAILBILITY_MULTIREGIONINTERFACE=interfaceDataCreation.editInterfaceName1;
		EDITED_PARAMETER_OF_UPDATERESOURCE_AVAILBILITY_MULTIREGIONINTERFACE=interfaceDataCreation.editParameterName;
		Result = "PASS";
	}

	@Test(dependsOnMethods={"HappyDay188020"},groups = {"HappyDay","Setting Region Interfaces", "HappyDay188021"})
	public void HappyDay188021() throws Exception {

		TCID ="188021";
		TC_DESCRIPTION ="Verify that a region interface of type 'Update Resource Availability (multi-region)' can be deleted.";

		interfaceData = new InterfaceData();
		interfaceDataCreation = interfaceData.new InterfaceCreateData();

		navigateTo = new Shared(this.driver);
		interfaceSetup = new InterfaceSetUp(this.driver);

		navigateTo.interfaces();

		interfaceSetup
		.verifyInterfaceInInterfaceList(
				EDITED_UPDATERESOURCE_AVAILBILITY_MULTIREGIONINTERFACE)
				.clickParametersLink(EDITED_UPDATERESOURCE_AVAILBILITY_MULTIREGIONINTERFACE)
				.deleteParameterOfInterfaceAndVerifyParameterIsNotDisplayed(EDITED_PARAMETER_OF_UPDATERESOURCE_AVAILBILITY_MULTIREGIONINTERFACE);

		navigateTo.interfaces();
		interfaceSetup
		.clickOnDeleteCorrespondingToInterfaceAndDismiss(EDITED_UPDATERESOURCE_AVAILBILITY_MULTIREGIONINTERFACE)
		.verifyInterfaceInInterfaceList(EDITED_UPDATERESOURCE_AVAILBILITY_MULTIREGIONINTERFACE)
		.verifyInterfaceType(EDITED_UPDATERESOURCE_AVAILBILITY_MULTIREGIONINTERFACE,InterfaceData.WEBSERVICE_ACTIONS_FOR_UPDATE_RESOURCE_AVAILAIBILTY_INTERFACE_MULTI_REGION)
		.clickOnDeleteCorrespondingToInterfaceAndAccept(EDITED_UPDATERESOURCE_AVAILBILITY_MULTIREGIONINTERFACE);
		Result = "PASS";
	}

	@Test(groups= {"HappyDay", "Setting Region Interfaces", "HappyDay188025"})
	public void HappyDay188025() throws Exception{

		TCID = "188025";
		TC_DESCRIPTION = "Verify that a region interface of type 'Post Incoming Patient' can be created.";

		interfaceData = new InterfaceData();
		interfaceDataCreation = interfaceData.new InterfaceCreateData();
		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		interfaceSetup = new InterfaceSetUp(this.driver);
		usersData = new UsersData();
		loginData = new  LoginData();
		regionData = new RegionData();

		login.loginToApplication(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD);
		selectRegion.selectRegionAndClickOnNext(RegionData.REGIONNAME);
		navigateTo.interfaces();

		interfaceSetup.createInterface(interfaceDataCreation.name2, interfaceDataCreation.description2, InterfaceData.POST_INCOMING_PATIENT, InterfaceData.WEBSERVICEACTION_FOR_POSTINCOMINGPATIENT);

		interfaceSetup.verifyCreatedInterfaceDetails(interfaceDataCreation.name2, InterfaceData.WEBSERVICEACTION_FOR_POSTINCOMINGPATIENT, InterfaceData.POST_INCOMING_PATIENT, InterfaceData.SCHEMA_FOR_POSTINCOMINGPATIENT, interfaceDataCreation.description2);
		interfaceSetup.clickOnUsersLinkAndVerifyRegionInterfaceUsersListPageIsDisplayed(interfaceDataCreation.name2)
		.verifyWebServiceUserUnderRegionInterfaceUsersListPage(usersData.interfaceRelatedWebSerivceUser, usersData.interfaceRelatedWebSerivceUserFullName);

		interfaceSetup.verifyNoOtherUserIsDisplayedExcpetWebServiceUserOnRegionInterfaceList(usersData.interfaceRelatedUser, usersData.interfaceRelatedUserFullName).clickOnCancel();
		interfaceSetup.clickOnParametersLinkAndVerifyParameterListForRegionInterfacePageIsDisplayed(interfaceDataCreation.name2);
		interfaceSetup.createParameter(interfaceDataCreation.parameterName, interfaceDataCreation.parameterValue)
		.verifyEditAndDeleteLinksCorrespondingToParameter(interfaceDataCreation.parameterName);
		navigateTo.interfaces();
		interfaceSetup.clickResourceLink(interfaceDataCreation.name2).verifyEditInterfaceSelectResourcesPage();

		POST_INCOMING_PATIENT=interfaceDataCreation.name2;
		PARAMETERE_NAME_OF_POSTINCOMINGPATIENT=interfaceDataCreation.parameterName;
		Result = "PASS";
	}


	@Test(dependsOnMethods={"HappyDay188022"},groups = {"HappyDay", "Setting Region Interfaces", "HappyDay188023"})

	public void HappyDay188023() throws Exception {

		TCID = "188023";
		TC_DESCRIPTION = "Verify that a region interface of type 'Post HAvBED 2.5.2 Information' can be edited.";

		interfaceData = new InterfaceData();
		interfaceDataCreation = interfaceData.new InterfaceCreateData();

		navigateTo = new Shared(this.driver);
		interfaceSetup = new InterfaceSetUp(this.driver);

		interfaceSetup.verifyInterfaceInInterfaceList(POSTHAvBEDINFORMATION_INTERFACE)
		.clickParametersLink(POSTHAvBEDINFORMATION_INTERFACE)
		.verifyParameterIsListed(PARAMETER_OF_POSTHAvBEDINFORMATION_INTERFACE);

		navigateTo.interfaces();
		interfaceSetup.clickEditLink(POSTHAvBEDINFORMATION_INTERFACE)
		.verifyEditRegionInterfacePage()
		.editInterface(interfaceDataCreation.editInterfaceName, interfaceDataCreation.editInterfaceDescription)
		.verifyCreatedInterfaceDetails(interfaceDataCreation.editInterfaceName, InterfaceData.WEBSERVICEACTION_FOR_POSTHAvBEDINFORMATION, InterfaceData.POST_HAVBED_INFORMATION, InterfaceData.SCHEMA_FOR_POSTHAvBEDINFORMATION, interfaceDataCreation.editInterfaceDescription);

		POSTHAvBEDINFORMATION_INTERFACE = interfaceDataCreation.editInterfaceName;

		interfaceSetup.editParameterCorrespondingToInterface(POSTHAvBEDINFORMATION_INTERFACE, PARAMETER_OF_POSTHAvBEDINFORMATION_INTERFACE, interfaceDataCreation.editParameterName, interfaceDataCreation.editParameterValue)
		.verifyCreatedParameterDetails(interfaceDataCreation.editInterfaceName, interfaceDataCreation.editParameterName, interfaceDataCreation.editParameterValue);
		PARAMETER_OF_POSTHAvBEDINFORMATION_INTERFACE = interfaceDataCreation.editParameterName;

		Result = "PASS";
	}

	@Test(dependsOnMethods={"HappyDay188023"},groups = {"HappyDay", "Setting Region Interfaces", "HappyDay188024"})

	public void HappyDay188024() throws Exception {

		TCID = "188024";
		TC_DESCRIPTION = "Verify that a region interface of type 'Post HAvBED 2.5.2 Information' can be deleted.";

		interfaceData = new InterfaceData();
		interfaceDataCreation = interfaceData.new InterfaceCreateData();

		navigateTo = new Shared(this.driver);
		interfaceSetup = new InterfaceSetUp(this.driver);

		navigateTo.interfaces();

		interfaceSetup.verifyInterfaceInInterfaceList(POSTHAvBEDINFORMATION_INTERFACE)
		.clickParametersLink(POSTHAvBEDINFORMATION_INTERFACE)
		.verifyParameterIsListed(PARAMETER_OF_POSTHAvBEDINFORMATION_INTERFACE)
		.deleteParameterOfRegionInterfaceAndVerifyParameterIsNotDisplayed(PARAMETER_OF_POSTHAvBEDINFORMATION_INTERFACE);
		navigateTo.interfaces();
		interfaceSetup.clickOnDeleteCorrespondingToInterfaceAndDismiss(POSTHAvBEDINFORMATION_INTERFACE)
		.verifyInterfaceInInterfaceList(POSTHAvBEDINFORMATION_INTERFACE)
		.clickOnDeleteCorrespondingToInterfaceAndAccept(POSTHAvBEDINFORMATION_INTERFACE);

		Result = "PASS";
	}

	@Test(groups = {"HappyDay", "Setting Region Interfaces", "HappyDay188028"})

	public void HappyDay188028() throws Exception {

		TCID = "188028";
		TC_DESCRIPTION = "Verify that a region interface of type 'Flexible WebEOC Interface' can be created.";

		interfaceData = new InterfaceData();
		interfaceDataCreation = interfaceData.new InterfaceCreateData();
		usersData = new UsersData();

		navigateTo = new Shared(this.driver);
		interfaceSetup = new InterfaceSetUp(this.driver);

		navigateTo.interfaces();

		interfaceSetup.createProductInterface(interfaceDataCreation.name3, interfaceDataCreation.description3, InterfaceData.FLEXIBLE_WEBEOC_INTERFACE, InterfaceData.WEBSERVICEACTION_FOR_FLEXIBLE_WEBEOC_INTERFACE,interfaceDataCreation.interface_Key)
		.verifyCreatedInterfaceDetails(interfaceDataCreation.name3, InterfaceData.WEBSERVICEACTION_FOR_FLEXIBLE_WEBEOC_INTERFACE, InterfaceData.FLEXIBLE_WEBEOC_INTERFACE, InterfaceData.SCHEMA_FOR_FLEXIBLE_WEBEOC_INTERFACE, interfaceDataCreation.description3)
		.verifyAllActionsOfInterface(interfaceDataCreation.name3)
		.clickOnUsersLinkAndVerifyProductInterfaceUsersListPageIsDisplayed(interfaceDataCreation.name3)
		.verifyWebServiceUserUnderProductInterfaceUsersListPage(usersData.interfaceRelatedWebSerivceUser, usersData.interfaceRelatedWebSerivceUserFullName)
		.verifyNoOtherUserIsDisplayedExcpetWebServiceUserOnProductInterfaceList(usersData.interfaceRelatedUser, usersData.interfaceRelatedUserFullName)
		.clickOnCancel()
		.clickOnParametersLinkAndVerifyParameterListForInterfacePageIsDisplayed(interfaceDataCreation.name3)
		.createParameter(interfaceDataCreation.parameterName, interfaceDataCreation.parameterValue)
		.verifyEditAndDeleteLinksCorrespondingToParameter(interfaceDataCreation.parameterName);

		navigateTo.interfaces();
		interfaceSetup.clickOnStatusTypesLinkCorrespondingToInterface(interfaceDataCreation.name3)
		.verifySelectInterfaceStatusTypes()
		.clickOnCancel();

		navigateTo.interfaces();
		interfaceSetup.clickResourceLink(interfaceDataCreation.name3)
		.verifyEditInterfaceSelectResourcesPage()
		.clickOnCancel();

		PRODUCT_INTERFACE_KEY = interfaceDataCreation.interface_Key;
		FLEXIBLE_WEBEOC_INTERFACE=interfaceDataCreation.name3;
		PARAMETER_OF_FLEXIBLE_WEBEOC_INTERFACE=interfaceDataCreation.parameterName;

		Result = "PASS";
	}


	@Test(dependsOnMethods={"HappyDay188026"},groups = {"HappyDay", "Setting Region Interface, HappyDay188027"})
	public void HappyDay188027() throws Exception{

		TCID = "188027";
		TC_DESCRIPTION = "  Verify that a region interface of type 'Post Incoming Patient' can be deleted.";	

		interfaceData = new InterfaceData();
		interfaceDataCreation = interfaceData.new InterfaceCreateData();

		navigateTo = new Shared(this.driver);
		interfaceSetup = new InterfaceSetUp(this.driver);

		navigateTo.interfaces();
		interfaceSetup.verifyInterfaceInInterfaceList(EDIT_INTERFACE_NAME_OF_POSTINCOMINGPATIENT);
		interfaceSetup.clickParametersLink(EDIT_INTERFACE_NAME_OF_POSTINCOMINGPATIENT)
		.verifyParameterIsListed(EDIT_PARAMETER_NAME_OF_POSTINCOMINGPATIENT)
		.deleteParameterOfRegionInterfaceAndVerifyParameterIsNotDisplayed(EDIT_PARAMETER_NAME_OF_POSTINCOMINGPATIENT);
		navigateTo.interfaces();
		interfaceSetup.clickOnDeleteCorrespondingToInterfaceAndDismiss(EDIT_INTERFACE_NAME_OF_POSTINCOMINGPATIENT);
		interfaceSetup.verifyInterfaceInInterfaceList(EDIT_INTERFACE_NAME_OF_POSTINCOMINGPATIENT);
		interfaceSetup.clickOnDeleteCorrespondingToInterfaceAndAccept(EDIT_INTERFACE_NAME_OF_POSTINCOMINGPATIENT);

		Result = "PASS";
	}

	@Test(dependsOnMethods={"HappyDay188028"},groups = {"HappyDay", "Setting Region Interfaces", "HappyDay188029"})

	public void HappyDay188029() throws Exception {

		TCID = "188029";
		TC_DESCRIPTION = "Verify that a region interface of type 'Flexible WebEOC Interface' can be edited. ";

		interfaceData = new InterfaceData();
		interfaceDataCreation = interfaceData.new InterfaceCreateData();

		navigateTo = new Shared(this.driver);
		interfaceSetup = new InterfaceSetUp(this.driver);

		navigateTo.interfaces();

		interfaceSetup
		.verifyInterfaceInInterfaceList(FLEXIBLE_WEBEOC_INTERFACE)
		.clickParametersLink(FLEXIBLE_WEBEOC_INTERFACE)
		.verifyParameterIsListed(PARAMETER_OF_FLEXIBLE_WEBEOC_INTERFACE);

		navigateTo.interfaces();
		interfaceSetup
		.clickEditLink(FLEXIBLE_WEBEOC_INTERFACE)
		.verifyEditProductInterfacePage()
		.verifyEnteredInterfaceKeyUnderEditInterfacePage(PRODUCT_INTERFACE_KEY)
		.editInterface(interfaceDataCreation.editInterfaceName3,
				interfaceDataCreation.editInterfaceDescription)
				.verifyCreatedInterfaceDetails(
						interfaceDataCreation.editInterfaceName3,
						InterfaceData.WEBSERVICEACTION_FOR_FLEXIBLE_WEBEOC_INTERFACE,
						InterfaceData.FLEXIBLE_WEBEOC_INTERFACE,
						InterfaceData.SCHEMA_FOR_FLEXIBLE_WEBEOC_INTERFACE,
						interfaceDataCreation.editInterfaceDescription)
						.editParameterCorrespondingToInterface(
								interfaceDataCreation.editInterfaceName3,
								PARAMETER_OF_FLEXIBLE_WEBEOC_INTERFACE,
								interfaceDataCreation.editParameterName,
								interfaceDataCreation.editParameterValue)
								.verifyParameterListForInterfacePage(
										interfaceDataCreation.editInterfaceName3)
										.verifyParameterIsListed(interfaceDataCreation.editParameterName)
										.verifyParameterValue(interfaceDataCreation.editParameterName,
												interfaceDataCreation.editParameterValue);

		EDITED_FLEXIBLE_WEBEOC_INTERFACE = interfaceDataCreation.editInterfaceName3;
		EDITED_PARAMETER_OF_FLEXIBLE_WEBEOC_INTERFACE = interfaceDataCreation.editParameterName;

		Result = "PASS";
	}


	@Test(dependsOnMethods={"HappyDay188029"},groups = {"HappyDay", "Setting Region Interfaces", "HappyDay188030"})

	public void HappyDay188030() throws Exception {

		TCID = "188030";
		TC_DESCRIPTION = "Verify that a region interface of type 'Flexible WebEOC Interface' can be deleted.";


		interfaceData = new InterfaceData();
		interfaceDataCreation = interfaceData.new InterfaceCreateData();

		navigateTo = new Shared(this.driver);
		interfaceSetup = new InterfaceSetUp(this.driver);

		navigateTo.interfaces();

		interfaceSetup
		.verifyInterfaceInInterfaceList(
				EDITED_FLEXIBLE_WEBEOC_INTERFACE)
				.clickParametersLink(EDITED_FLEXIBLE_WEBEOC_INTERFACE)
				.deleteParameterOfInterfaceAndVerifyParameterIsNotDisplayed(
						EDITED_PARAMETER_OF_FLEXIBLE_WEBEOC_INTERFACE);

		navigateTo.interfaces();
		interfaceSetup
		.clickOnDeleteCorrespondingToInterfaceAndDismiss(
				EDITED_FLEXIBLE_WEBEOC_INTERFACE)
				.verifyInterfaceInInterfaceList(
						EDITED_FLEXIBLE_WEBEOC_INTERFACE)
						.verifyInterfaceType(EDITED_FLEXIBLE_WEBEOC_INTERFACE,
								InterfaceData.WEBSERVICEACTION_FOR_FLEXIBLE_WEBEOC_INTERFACE)
								.clickOnDeleteCorrespondingToInterfaceAndAccept(EDITED_FLEXIBLE_WEBEOC_INTERFACE);

		Result = "PASS";
	}

	@Test (groups = {"HappyDay", "Setting Region Interfaces", "HappyDay129477"})
	public void HappyDay129477() throws Exception {

		TCID = "129477";
		TC_DESCRIPTION = "Verify that a region interface of type 'Get Region Configuration' can be created.";

		interfaceData = new InterfaceData();
		interfaceDataCreation = interfaceData.new InterfaceCreateData();
		usersData = new UsersData();

		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		interfaceSetup = new InterfaceSetUp(this.driver);

		login.loginToApplication(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD);
		selectRegion.selectRegionAndClickOnNext(RegionData.REGIONNAME);
		navigateTo.interfaces();
		interfaceSetup.verifyActiveWebServicesActionOfInterfaceAndDelete(InterfaceData.WEBSERVICEACTION_FOR_GET_REGION_CONFIGURATION)
		.selectInterfaceTypeAndVerifyCreateRegionInterfacePage(InterfaceData.GET_REGION_CONFIGURATION)
		.createInterfaceByProvidingMandatoryData(interfaceDataCreation.name4, interfaceDataCreation.description4, InterfaceData.WEBSERVICEACTION_FOR_GET_REGION_CONFIGURATION)
		.verifyActionsOfTheInterface(interfaceDataCreation.name4)
		.verifyCreatedInterfaceDetails(interfaceDataCreation.name4, InterfaceData.WEBSERVICEACTION_FOR_GET_REGION_CONFIGURATION, InterfaceData.GET_REGION_CONFIGURATION, InterfaceData.SCHEMA_FOR_GET_REGION_CONFIGURATION, interfaceDataCreation.description4)
		.clickOnUsersLinkAndVerifyRegionInterfaceUsersListPageIsDisplayed(interfaceDataCreation.name4)
		.verifyWebServiceUserUnderRegionInterfaceUsersListPage(usersData.interfaceRelatedWebSerivceUser, usersData.interfaceRelatedWebSerivceUserFullName)
		.verifyNoOtherUserIsDisplayedExcpetWebServiceUserOnRegionInterfaceList(usersData.interfaceRelatedUser, usersData.interfaceRelatedUserFullName)
		.clickOnCancel()
		.clickOnParametersLinkAndVerifyParameterListForRegionInterfacePageIsDisplayed(interfaceDataCreation.name4)
		.clickOnCreateNewParameterAndVerifyCreateRegionInterfaceParameterPage()
		.createParameterByProvidingMandatoryData(interfaceDataCreation.parameterName, interfaceDataCreation.parameterValue)
		.verifyEditAndDeleteLinksCorrespondingToParameter(interfaceDataCreation.parameterName)
		.verifyCreatedParameterDetails(interfaceDataCreation.name4, interfaceDataCreation.parameterName, interfaceDataCreation.parameterValue);

		GET_REGION_CONFIGURATION_INTERFACE = interfaceDataCreation.name4;
		PARAMETER_OF_GET_REGION_CONFIGURATION_INTERFACE = interfaceDataCreation.parameterName;

		Result = "PASS";
	}

	@Test (dependsOnMethods={"HappyDay129477"}, groups = {"HappyDay", "Setting Region Interfaces", "HappyDay129479"})
	public void HappyDay129479() throws Exception {

		TCID = "129479";
		TC_DESCRIPTION = "Verify that a region interface of type 'Get Region Configuration' can be edited.";

		interfaceData = new InterfaceData();
		interfaceDataCreation = interfaceData.new InterfaceCreateData();

		navigateTo = new Shared(this.driver);
		interfaceSetup = new InterfaceSetUp(this.driver);

		navigateTo.interfaces();
		interfaceSetup.verifyInterfaceInInterfaceList(GET_REGION_CONFIGURATION_INTERFACE)
		.clickParametersLink(GET_REGION_CONFIGURATION_INTERFACE)
		.verifyParameterIsListed(PARAMETER_OF_GET_REGION_CONFIGURATION_INTERFACE);
		navigateTo.interfaces();
		interfaceSetup.clickOnEditLinkAndVerifyEditRegionInterfacePage(GET_REGION_CONFIGURATION_INTERFACE)
		.editInterface(interfaceDataCreation.editInterfaceName4, interfaceDataCreation.editInterfaceDescription)
		.verifyCreatedInterfaceDetails(interfaceDataCreation.editInterfaceName4, InterfaceData.WEBSERVICEACTION_FOR_GET_REGION_CONFIGURATION, InterfaceData.GET_REGION_CONFIGURATION, InterfaceData.SCHEMA_FOR_GET_REGION_CONFIGURATION, interfaceDataCreation.editInterfaceDescription)
		.clickOnParametersLinkAndVerifyParameterListForRegionInterfacePageIsDisplayed(interfaceDataCreation.editInterfaceName4)
		.verifyEditAndDeleteLinksCorrespondingToParameter(PARAMETER_OF_GET_REGION_CONFIGURATION_INTERFACE)
		.editParameter(PARAMETER_OF_GET_REGION_CONFIGURATION_INTERFACE,interfaceDataCreation.editParameterName, interfaceDataCreation.editParameterValue)
		.verifyCreatedParameterDetails(interfaceDataCreation.editInterfaceName4, interfaceDataCreation.editParameterName, interfaceDataCreation.editParameterValue);

		GET_REGION_CONFIGURATION_INTERFACE = interfaceDataCreation.editInterfaceName4;
		PARAMETER_OF_GET_REGION_CONFIGURATION_INTERFACE = interfaceDataCreation.editParameterName;

		Result = "PASS";
	}

	@Test (dependsOnMethods={"HappyDay129479"}, groups = {"HappyDay", "Setting Region Interfaces", "HappyDay129480"})
	public void HappyDay129480() throws Exception {

		TCID = "129480";
		TC_DESCRIPTION = "Verify that a region interface of type 'Get Region Configuration' can be deleted.";

		interfaceData = new InterfaceData();
		interfaceDataCreation = interfaceData.new InterfaceCreateData();

		navigateTo = new Shared(this.driver);
		interfaceSetup = new InterfaceSetUp(this.driver);

		navigateTo.interfaces();

		interfaceSetup.verifyInterfaceInInterfaceList(GET_REGION_CONFIGURATION_INTERFACE)
		.clickParametersLink(GET_REGION_CONFIGURATION_INTERFACE)
		.verifyParameterIsListed(PARAMETER_OF_GET_REGION_CONFIGURATION_INTERFACE)
		.deleteParameterOfRegionInterfaceAndVerifyParameterIsNotDisplayed(PARAMETER_OF_GET_REGION_CONFIGURATION_INTERFACE);
		navigateTo.interfaces();
		interfaceSetup.clickOnDeleteCorrespondingToInterfaceAndDismiss(GET_REGION_CONFIGURATION_INTERFACE)
		.verifyInterfaceInInterfaceList(GET_REGION_CONFIGURATION_INTERFACE)
		.clickOnDeleteCorrespondingToInterfaceAndAccept(GET_REGION_CONFIGURATION_INTERFACE);

		Result = "PASS";
	}

	@Test(groups = {"HappyDay", "Setting Region Interfaces", "HappyDay129484"})
	public void HappyDay129484() throws Exception {

		TCID = "129484";
		TC_DESCRIPTION = "Verify that a region interface of type 'Get Active Events' can be created.";

		interfaceData = new InterfaceData();
		interfaceDataCreation = interfaceData.new InterfaceCreateData();

		navigateTo = new Shared(this.driver);
		interfaceSetup = new InterfaceSetUp(this.driver);
		usersData = new UsersData();
		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		loginData = new LoginData();

		login.loginToApplication(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD);
		selectRegion.selectRegionAndClickOnNext(RegionData.REGIONNAME);
		navigateTo.interfaces();

		interfaceSetup.createInterface(interfaceDataCreation.name4, interfaceDataCreation.description4, InterfaceData.GET_ACTIVE_EVENTS, InterfaceData.WEBSERVICEACTION_FOR_GET_ACTIVE_EVENTS)
		.verifyCreatedInterfaceDetails(interfaceDataCreation.name4, InterfaceData.WEBSERVICEACTION_FOR_GET_ACTIVE_EVENTS, InterfaceData.GET_ACTIVE_EVENTS, InterfaceData.WEBSERVICEACTION_FOR_GET_ACTIVE_EVENTS, interfaceDataCreation.description4)
		.verifyActionsOfTheInterface(interfaceDataCreation.name4)
		.clickOnUsersLinkAndVerifyRegionInterfaceUsersListPageIsDisplayed(interfaceDataCreation.name4)
		.verifyWebServiceUserUnderRegionInterfaceUsersListPage(usersData.interfaceRelatedWebSerivceUser, usersData.interfaceRelatedWebSerivceUserFullName)
		.verifyNoOtherUserIsDisplayedExcpetWebServiceUserOnRegionInterfaceList(usersData.interfaceRelatedUser, usersData.interfaceRelatedUserFullName)
		.clickOnCancel()
		.clickOnParametersLinkAndVerifyParameterListForRegionInterfacePageIsDisplayed(interfaceDataCreation.name4)
		.createParameter(interfaceDataCreation.parameterName, interfaceDataCreation.parameterValue)
		.verifyEditAndDeleteLinksCorrespondingToParameter(interfaceDataCreation.parameterName);

		GET_ACTIVE_EVENTS_INTERFACE = interfaceDataCreation.name4;
		PARAMETER_OF_GET_ACTIVE_EVENTS_INTERFACE = interfaceDataCreation.parameterName;

		Result = "PASS";
	}

	@Test(dependsOnGroups = {"HappyDay129484"}, groups = {"HappyDay", "Setting Region Interfaces", "HappyDay129485"})
	public void HappyDay129485() throws Exception {

		TCID = "129485";
		TC_DESCRIPTION = "Verify that a region interface of type 'Get Active Events' can be edited.";

		interfaceData = new InterfaceData();
		interfaceDataCreation = interfaceData.new InterfaceCreateData();

		navigateTo = new Shared(this.driver);
		interfaceSetup = new InterfaceSetUp(this.driver);

		navigateTo.interfaces();

		interfaceSetup.verifyInterfaceInInterfaceList(GET_ACTIVE_EVENTS_INTERFACE)
		.clickParametersLink(GET_ACTIVE_EVENTS_INTERFACE)
		.verifyParameterIsListed(PARAMETER_OF_GET_ACTIVE_EVENTS_INTERFACE);

		navigateTo.interfaces();

		interfaceSetup.clickEditLink(GET_ACTIVE_EVENTS_INTERFACE)
		.verifyEditRegionInterfacePage()
		.editInterface(interfaceDataCreation.editInterfaceName5, interfaceDataCreation.editInterfaceDescription)
		.verifyCreatedInterfaceDetails(interfaceDataCreation.editInterfaceName5, InterfaceData.WEBSERVICEACTION_FOR_GET_ACTIVE_EVENTS, InterfaceData.GET_ACTIVE_EVENTS, InterfaceData.SCHEMA_FOR_GET_ACTIVE_EVENTS, interfaceDataCreation.editInterfaceDescription);

		interfaceSetup.editParameterCorrespondingToInterface(GET_ACTIVE_EVENTS_INTERFACE, PARAMETER_OF_GET_ACTIVE_EVENTS_INTERFACE, interfaceDataCreation.editParameterName, interfaceDataCreation.editParameterValue)
		.verifyCreatedParameterDetails(interfaceDataCreation.editInterfaceName5, interfaceDataCreation.editParameterName, interfaceDataCreation.editParameterValue);

		GET_ACTIVE_EVENTS_INTERFACE = interfaceDataCreation.editInterfaceName5;
		PARAMETER_OF_GET_ACTIVE_EVENTS_INTERFACE = interfaceDataCreation.editParameterName;

		Result = "PASS";
	}

	@Test(dependsOnGroups = {"HappyDay129485"}, groups = {"HappyDay", "Setting Region Interfaces", "HappyDay129481"})
	public void HappyDay129481() throws Exception {

		TCID = "129481";
		TC_DESCRIPTION = "Verify that a region interface of type 'Get Active Events' can be deleted.";

		interfaceData = new InterfaceData();
		interfaceDataCreation = interfaceData.new InterfaceCreateData();

		navigateTo = new Shared(this.driver);
		interfaceSetup = new InterfaceSetUp(this.driver);

		interfaceSetup.deleteParameterOfRegionInterfaceAndVerifyParameterIsNotDisplayed(PARAMETER_OF_GET_ACTIVE_EVENTS_INTERFACE);
		navigateTo.interfaces();
		interfaceSetup.clickOnDeleteCorrespondingToInterfaceAndDismiss(GET_ACTIVE_EVENTS_INTERFACE)
		.verifyInterfaceInInterfaceList(GET_ACTIVE_EVENTS_INTERFACE)
		.clickOnDeleteCorrespondingToInterfaceAndAccept(GET_ACTIVE_EVENTS_INTERFACE);

		Result = "PASS";
	}

	@Test(dependsOnMethods={"HappyDay188025"},groups = {"HappyDay", "Setting Region Interface, HappyDay188026"})
	public void HappyDay188026() throws Exception{

		TCID = "188026";
		TC_DESCRIPTION = " Verify that a region interface of type 'Post Incoming Patient' can be edited.";	

		interfaceData = new InterfaceData();
		interfaceDataCreation = interfaceData.new InterfaceCreateData();

		navigateTo = new Shared(this.driver);
		interfaceSetup = new InterfaceSetUp(this.driver);
		usersData = new UsersData();

		navigateTo.interfaces();
		interfaceSetup.verifyInterfaceInInterfaceList(POST_INCOMING_PATIENT);
		interfaceSetup.clickEditLink(POST_INCOMING_PATIENT);
		interfaceSetup.editInterface(interfaceDataCreation.editInterfaceName2,interfaceDataCreation.editInterfaceDescription)
		.verifyCreatedInterfaceDetails(interfaceDataCreation.editInterfaceName2,InterfaceData.WEBSERVICEACTION_FOR_POSTINCOMINGPATIENT,InterfaceData.POST_INCOMING_PATIENT, InterfaceData.SCHEMA_FOR_POSTINCOMINGPATIENT, interfaceDataCreation.editInterfaceDescription);

		interfaceSetup.clickOnParametersLinkAndVerifyParameterListForRegionInterfacePageIsDisplayed(interfaceDataCreation.editInterfaceName2)
		.verifyEditAndDeleteLinksCorrespondingToParameter(PARAMETERE_NAME_OF_POSTINCOMINGPATIENT);

		interfaceSetup.editParameter(PARAMETERE_NAME_OF_POSTINCOMINGPATIENT, interfaceDataCreation.editParameterName, interfaceDataCreation.editParameterValue)
		.verifyParameterValue(interfaceDataCreation.editParameterName, interfaceDataCreation.editParameterValue);
		EDIT_INTERFACE_NAME_OF_POSTINCOMINGPATIENT=interfaceDataCreation.editInterfaceName2;
		EDIT_INTERFACE_DESCRIPTION_OF_POSTINCOMINGPATIENT=interfaceDataCreation.editInterfaceDescription;
		EDIT_PARAMETER_NAME_OF_POSTINCOMINGPATIENT=interfaceDataCreation.editParameterName;

		Result = "PASS";
	}

	@Test (groups = {"HappyDay", "Setting Region Interfaces", "HappyDay129478"})
	public void HappyDay129478() throws Exception {

		TCID = "129478";
		TC_DESCRIPTION = "Verify that a region interface of type 'Legacy Get Hospital status' can be created.";

		interfaceData = new InterfaceData();
		interfaceDataCreation = interfaceData.new InterfaceCreateData();

		navigateTo = new Shared(this.driver);
		interfaceSetup = new InterfaceSetUp(this.driver);
		usersData = new UsersData();
		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);


		login.loginToApplication(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD);
		selectRegion.selectRegionAndClickOnNext(RegionData.REGIONNAME);
		navigateTo.interfaces();
		interfaceSetup.createInterface(interfaceDataCreation.name6, interfaceDataCreation.description6, InterfaceData.LEGACY_GET_HOSPITAL_STATUS, InterfaceData.WEBSERVICEACTION_FOR_LAGACY_GET_HOSPITAL_STATUS)
		.verifyCreatedInterfaceDetails(interfaceDataCreation.name6, InterfaceData.WEBSERVICEACTION_FOR_LAGACY_GET_HOSPITAL_STATUS, InterfaceData.LEGACY_GET_HOSPITAL_STATUS, InterfaceData.SCHEMA_FOR_LAGACY_GET_HOSPITAL_STATUS, interfaceDataCreation.description6);
		interfaceSetup.clickOnUsersLinkAndVerifyRegionInterfaceUsersListPageIsDisplayed(interfaceDataCreation.name6)
		.verifyWebServiceUserUnderRegionInterfaceUsersListPage(usersData.interfaceRelatedWebSerivceUser, usersData.interfaceRelatedWebSerivceUserFullName)
		.verifyNoOtherUserIsDisplayedExcpetWebServiceUserOnRegionInterfaceList(usersData.interfaceRelatedUser, usersData.interfaceRelatedUserFullName).clickOnCancel();
		interfaceSetup.clickOnParametersLinkAndVerifyParameterListForRegionInterfacePageIsDisplayed(interfaceDataCreation.name6)
		.clickOnCreateNewParameterAndVerifyCreateRegionInterfaceParameterPage();
		interfaceSetup.createParameterByProvidingMandatoryData(interfaceDataCreation.parameterName, interfaceDataCreation.parameterValue)
		.verifyEditAndDeleteLinksCorrespondingToParameter(interfaceDataCreation.parameterName);

		LAGACY_GET_HOSPITAL_STATUS=interfaceDataCreation.name6;
		PARAMETER_OF_LAGACY_GET_HOSPITAL_STATUS=interfaceDataCreation.parameterName;

		Result ="PASS";
	}

	@Test(dependsOnMethods={"HappyDay129478"},groups = {"HappyDay", "Setting Region Interface, HappyDay129482"})
	public void HappyDay129482() throws Exception{

		TCID = "129482";
		TC_DESCRIPTION = "Verify that a region interface of type 'Legacy Get Hospital status' can be edited.";

		interfaceData = new InterfaceData();
		interfaceDataCreation = interfaceData.new InterfaceCreateData();

		navigateTo = new Shared(this.driver);
		interfaceSetup = new InterfaceSetUp(this.driver);
		usersData = new UsersData();

		navigateTo.interfaces();
		interfaceSetup.verifyInterfaceInInterfaceList(LAGACY_GET_HOSPITAL_STATUS);
		interfaceSetup.clickEditLink(LAGACY_GET_HOSPITAL_STATUS)
		.editInterface(interfaceDataCreation.editInterfaceName6, interfaceDataCreation.editInterfaceDescription)
		.verifyCreatedInterfaceDetails(interfaceDataCreation.editInterfaceName6, InterfaceData.WEBSERVICEACTION_FOR_LAGACY_GET_HOSPITAL_STATUS, InterfaceData.LEGACY_GET_HOSPITAL_STATUS, InterfaceData.SCHEMA_FOR_LAGACY_GET_HOSPITAL_STATUS, interfaceDataCreation.editInterfaceDescription);
		interfaceSetup.clickOnParametersLinkAndVerifyParameterListForRegionInterfacePageIsDisplayed(interfaceDataCreation.editInterfaceName6)
		.verifyEditAndDeleteLinksCorrespondingToParameter(PARAMETER_OF_LAGACY_GET_HOSPITAL_STATUS);
		interfaceSetup.editParameter(PARAMETER_OF_LAGACY_GET_HOSPITAL_STATUS, interfaceDataCreation.editParameterName, interfaceDataCreation.editParameterValue)
		.verifyParameterValue(interfaceDataCreation.editParameterName, interfaceDataCreation.editParameterValue);

		EDIT_PARAMETER_NAME_OF_LAGACY_GET_HOSPITAL_STATUS=interfaceDataCreation.editParameterName;
		EDIT_INTERFACE_NAME_OF_LAGACY_GET_HOSPITAL_STATUS=interfaceDataCreation.editInterfaceName6;
		Result="PASS";
	}

	@Test(dependsOnMethods={"HappyDay129482"},groups = {"HappyDay", "Setting Region Interface, HappyDay129483"})
	public void HappyDay129483() throws Exception{

		TCID = "129483";
		TC_DESCRIPTION = "Verify that a region interface of type 'Legacy Get Hospital status' can be deleted.";

		interfaceData = new InterfaceData();
		interfaceDataCreation = interfaceData.new InterfaceCreateData();

		navigateTo = new Shared(this.driver);
		interfaceSetup = new InterfaceSetUp(this.driver);

		navigateTo.interfaces();
		interfaceSetup.verifyInterfaceInInterfaceList(EDIT_INTERFACE_NAME_OF_LAGACY_GET_HOSPITAL_STATUS);
		interfaceSetup.clickOnParametersLinkAndVerifyParameterListForRegionInterfacePageIsDisplayed(EDIT_INTERFACE_NAME_OF_LAGACY_GET_HOSPITAL_STATUS)
		.deleteParameterOfRegionInterfaceAndVerifyParameterIsNotDisplayed(EDIT_PARAMETER_NAME_OF_LAGACY_GET_HOSPITAL_STATUS);
		navigateTo.interfaces();
		interfaceSetup.clickOnDeleteCorrespondingToInterfaceAndDismiss(EDIT_INTERFACE_NAME_OF_LAGACY_GET_HOSPITAL_STATUS)
		.verifyInterfaceInInterfaceList(EDIT_INTERFACE_NAME_OF_LAGACY_GET_HOSPITAL_STATUS)
		.clickOnDeleteCorrespondingToInterfaceAndAccept(EDIT_INTERFACE_NAME_OF_LAGACY_GET_HOSPITAL_STATUS);

		Result ="PASS";

	}

	@Test (groups = {"HappyDay", "Setting Region Interfaces", "HappyDay94039"})
	public void HappyDay94039() throws Exception {

		TCID = "94039";
		TC_DESCRIPTION = "Verify that a region interface of type 'Get EDXL-HAVE 1.0' can be created.";

		interfaceData = new InterfaceData();
		interfaceDataCreation = interfaceData.new InterfaceCreateData();

		navigateTo = new Shared(this.driver);
		interfaceSetup = new InterfaceSetUp(this.driver);
		usersData = new UsersData();
		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);

		login.loginToApplication(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD);
		selectRegion.selectRegionAndClickOnNext(RegionData.REGIONNAME);
		navigateTo.interfaces();
		interfaceSetup.verifyCreateNewInterfaceAndInterfaceListPage();
		interfaceSetup.createInterface(interfaceDataCreation.name4, interfaceDataCreation.description4, InterfaceData.GET_EDXL_HAVE, InterfaceData.WEBSERVICEACTION_FOR_GET_EDXL_HAVE);
		interfaceSetup.verifyCreatedInterfaceDetails(interfaceDataCreation.name4, InterfaceData.WEBSERVICEACTION_FOR_GET_EDXL_HAVE, InterfaceData.GET_EDXL_HAVE, InterfaceData.SCHEMA_FOR_GET_EDXL_HAVE, interfaceDataCreation.description4)
		.clickOnStatusTypesLinkCorrespondingToInterface(interfaceDataCreation.name4)
		.verifyOptionsInSelectInterfaceStatusTypes(InterfaceData.OPTIONAL_STATUS_TYPE_MAPPINGS_SECTION)
		.verifyOptionsInSelectInterfaceStatusTypes(InterfaceData.CUSTOM_STATUS_TYPE_MAPPINGS_SECTION);

		GET_EDXL_HAVE=interfaceDataCreation.name4;
		DESCRIPTION_GET_EDXL_HAVE=interfaceDataCreation.description4;
		Result ="PASS";
	}

	@Test(dependsOnMethods={"HappyDay94039"},groups = {"HappyDay", "Setting Region Interface, HappyDay101820"})
	public void HappyDay101820() throws Exception{

		TCID = "101820";
		TC_DESCRIPTION = "Verify that a region interface of type 'Get EDXL-HAVE 1.0' can be edited.";

		interfaceData = new InterfaceData();
		interfaceDataCreation = interfaceData.new InterfaceCreateData();

		navigateTo = new Shared(this.driver);
		interfaceSetup = new InterfaceSetUp(this.driver);

		navigateTo.interfaces();
		interfaceSetup.verifyInterfaceInInterfaceList(GET_EDXL_HAVE)
		.clickEditLink(GET_EDXL_HAVE)
		.verifyInterfaceRetainedDetails(GET_EDXL_HAVE, DESCRIPTION_GET_EDXL_HAVE)
		.editInterface(interfaceDataCreation.editInterfaceName7, interfaceDataCreation.editInterfaceDescription)
		.verifyEditedInterfaceDetails(interfaceDataCreation.editInterfaceName7,  interfaceDataCreation.editInterfaceDescription);
		Result ="PASS";

	}
	@Test(groups = {"HappyDay", "Setting Region Interfaces", "HappyDay94127"})
	public void HappyDay94127() throws Exception{

		TCID = "94127";
		TC_DESCRIPTION = "Verify that a region interface of type 'Post Resource Detail Status' can be created.";	

		interfaceData = new InterfaceData();
		interfaceDataCreation = interfaceData.new InterfaceCreateData();

		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		interfaceSetup = new InterfaceSetUp(this.driver);

		login.loginToApplication(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD);
		selectRegion.selectRegionAndClickOnNext(RegionData.REGIONNAME);
		navigateTo.interfaces();
		interfaceSetup.verifyCreateNewInterfaceAndInterfaceListPage()
		.createInterface(interfaceDataCreation.name1, interfaceDataCreation.description1, InterfaceData.POST_RESOURCE_DETAIL_STATUS, InterfaceData.WEBSERVICEACTION_FOR_POST_RESOURCE_DETAIL_STATUS)
		.verifyCreatedInterfaceDetails(interfaceDataCreation.name1, InterfaceData.WEBSERVICEACTION_FOR_POST_RESOURCE_DETAIL_STATUS, InterfaceData.POST_RESOURCE_DETAIL_STATUS, InterfaceData.SCHEMA_FOR_POST_RESOURCE_DETAIL_STATUS, interfaceDataCreation.description1);

		POST_RESOURCE_DETAIL_STATUS_INTERFACE = interfaceDataCreation.name1;
		DESCRIPTION_OF_POST_RESOURCE_DETAIL_STATUS_INTERFACE = interfaceDataCreation.description1;

		Result="PASS";
	}

	@Test(dependsOnMethods={"HappyDay94127"}, groups = {"HappyDay", "Setting Region Interfaces", "HappyDay101823"})
	public void HappyDay101823() throws Exception{

		TCID = "101823";
		TC_DESCRIPTION = "Verify that a region interface of type 'Post Resource Detail Status' can be edited.";	

		interfaceData = new InterfaceData();
		interfaceDataCreation = interfaceData.new InterfaceCreateData();

		navigateTo = new Shared(this.driver);
		interfaceSetup = new InterfaceSetUp(this.driver);

		navigateTo.interfaces();
		interfaceSetup.verifyInterfaceInInterfaceList(POST_RESOURCE_DETAIL_STATUS_INTERFACE)
		.clickEditLink(POST_RESOURCE_DETAIL_STATUS_INTERFACE)
		.verifyInterfaceRetainedDetails(POST_RESOURCE_DETAIL_STATUS_INTERFACE, DESCRIPTION_OF_POST_RESOURCE_DETAIL_STATUS_INTERFACE)
		.editInterface(interfaceDataCreation.editInterfaceName8, interfaceDataCreation.editInterfaceDescription)
		.verifyCreatedInterfaceDetails(interfaceDataCreation.editInterfaceName8, InterfaceData.WEBSERVICEACTION_FOR_POST_RESOURCE_DETAIL_STATUS, InterfaceData.POST_RESOURCE_DETAIL_STATUS, InterfaceData.SCHEMA_FOR_POST_RESOURCE_DETAIL_STATUS, interfaceDataCreation.editInterfaceDescription);

		Result="PASS";
	}

	@Test(groups = {"HappyDay", "Setting Region Interfaces", "HappyDay94125"})
	public void HappyDay94125() throws Exception{

		TCID = "94125";
		TC_DESCRIPTION = "Verify that a region interface of type 'Update CAD Status' can be created.";	

		interfaceData = new InterfaceData();
		interfaceDataCreation = interfaceData.new InterfaceCreateData();

		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		interfaceSetup = new InterfaceSetUp(this.driver);

		login.loginToApplication(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD);
		selectRegion.selectRegionAndClickOnNext(RegionData.REGIONNAME);
		navigateTo.interfaces();
		interfaceSetup.verifyCreateNewInterfaceAndInterfaceListPage()
		.createInterface(interfaceDataCreation.name4, interfaceDataCreation.description4, InterfaceData.UPDATE_CAD_STATUS , InterfaceData.WEBSERVICEACTION_FOR_UPDATE_CAD_STATUS)
		.verifyCreatedInterfaceDetails(interfaceDataCreation.name4, InterfaceData.WEBSERVICEACTION_FOR_UPDATE_CAD_STATUS, InterfaceData.UPDATE_CAD_STATUS, InterfaceData.SCHEMA_FOR_UPDATE_CAD_STATUS, interfaceDataCreation.description4)
		.clickOnStatusTypesLinkCorrespondingToInterface(interfaceDataCreation.name4)
		.verifyOptionsInSelectInterfaceStatusTypes(InterfaceData.OPTIONAL_STATUS_TYPE_MAPPINGS_SECTION);

		UPDATE_CAD_STATUS_INTERFACE = interfaceDataCreation.name4;
		DESCRIPTION_OF_UPDATE_CAD_STATUS_INTERFACE = interfaceDataCreation.description4;

		Result="PASS";
	}

	@Test(dependsOnMethods={"HappyDay94125"}, groups = {"HappyDay", "Setting Region Interfaces", "HappyDay94126"})
	public void HappyDay94126() throws Exception{

		TCID = "94126";
		TC_DESCRIPTION = "Verify that a region interface of type 'Update CAD Status' can be edited.";	

		interfaceData = new InterfaceData();
		interfaceDataCreation = interfaceData.new InterfaceCreateData();

		navigateTo = new Shared(this.driver);
		interfaceSetup = new InterfaceSetUp(this.driver);

		navigateTo.interfaces();
		interfaceSetup.verifyInterfaceInInterfaceList(UPDATE_CAD_STATUS_INTERFACE)
		.clickEditLink(UPDATE_CAD_STATUS_INTERFACE)
		.verifyInterfaceRetainedDetails(UPDATE_CAD_STATUS_INTERFACE, DESCRIPTION_OF_UPDATE_CAD_STATUS_INTERFACE)
		.editInterface(interfaceDataCreation.editInterfaceName9, interfaceDataCreation.editInterfaceDescription)
		.verifyCreatedInterfaceDetails(interfaceDataCreation.editInterfaceName9, InterfaceData.WEBSERVICEACTION_FOR_UPDATE_CAD_STATUS, InterfaceData.UPDATE_CAD_STATUS, InterfaceData.SCHEMA_FOR_UPDATE_CAD_STATUS, interfaceDataCreation.editInterfaceDescription);
		login.logOut();
		Result="PASS";
	}

	@Test(groups = {"HappyDay", "Setting Region Interfaces", "HappyDay94122"})
	public void HappyDay94122() throws Exception{

		TCID = "94122";
		TC_DESCRIPTION = "Verify that a region interface of type 'Get CAD Status' can be created.";	

		interfaceData = new InterfaceData();
		interfaceDataCreation = interfaceData.new InterfaceCreateData();

		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		interfaceSetup = new InterfaceSetUp(this.driver);

		login.loginToApplication(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD);
		selectRegion.selectRegionAndClickOnNext(RegionData.REGIONNAME);
		navigateTo.interfaces();
		interfaceSetup.verifyCreateNewInterfaceAndInterfaceListPage()
		.createInterface(interfaceDataCreation.name1, interfaceDataCreation.description1, InterfaceData.GET_CAD_STATUS , InterfaceData.WEBSERVICEACTION_FOR_GET_CAD_STATUS)
		.verifyCreatedInterfaceDetails(interfaceDataCreation.name1, InterfaceData.WEBSERVICEACTION_FOR_GET_CAD_STATUS, InterfaceData.GET_CAD_STATUS, InterfaceData.SCHEMA_FOR_GET_CAD_STATUS, interfaceDataCreation.description1)
		.clickOnStatusTypesLinkCorrespondingToInterface(interfaceDataCreation.name1)
		.verifyOptionsInSelectInterfaceStatusTypes(InterfaceData.OPTIONAL_STATUS_TYPE_MAPPINGS_SECTION);

		GET_CAD_STATUS_INTERFACE = interfaceDataCreation.name1;
		DESCRIPTION_OF_GET_CAD_STATUS_INTERFACE = interfaceDataCreation.description1;

		Result="PASS";
	}

	@Test(dependsOnMethods={"HappyDay94122"}, groups = {"HappyDay", "Setting Region Interfaces", "HappyDay101822"})
	public void HappyDay101822() throws Exception{

		TCID = "101822";
		TC_DESCRIPTION = "Verify that a region interface of type 'Get CAD Status' can be edited.";	

		interfaceData = new InterfaceData();
		interfaceDataCreation = interfaceData.new InterfaceCreateData();

		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		interfaceSetup = new InterfaceSetUp(this.driver);

		navigateTo.interfaces();
		interfaceSetup.verifyInterfaceInInterfaceList(GET_CAD_STATUS_INTERFACE)
		.clickEditLink(GET_CAD_STATUS_INTERFACE)
		.verifyInterfaceRetainedDetails(GET_CAD_STATUS_INTERFACE, DESCRIPTION_OF_GET_CAD_STATUS_INTERFACE)
		.editInterface(interfaceDataCreation.editInterfaceName10, interfaceDataCreation.editInterfaceDescription)
		.verifyCreatedInterfaceDetails(interfaceDataCreation.editInterfaceName10, InterfaceData.WEBSERVICEACTION_FOR_GET_CAD_STATUS, InterfaceData.GET_CAD_STATUS, InterfaceData.SCHEMA_FOR_GET_CAD_STATUS, interfaceDataCreation.editInterfaceDescription);
		login.logOut();
		Result="PASS";
	}

	@Test(groups = {"HappyDay", "Setting Region Interfaces", "HappyDay94043"})
	public void HappyDay94043() throws Exception{

		TCID = "94043";
		TC_DESCRIPTION = "Verify that a region interface of type 'Update Resource Availability' can be created.";	

		interfaceData = new InterfaceData();
		interfaceDataCreation = interfaceData.new InterfaceCreateData();

		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		interfaceSetup = new InterfaceSetUp(this.driver);

		login.loginToApplication(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD);
		selectRegion.selectRegionAndClickOnNext(RegionData.REGIONNAME);
		navigateTo.interfaces();
		interfaceSetup.verifyCreateNewInterfaceAndInterfaceListPage()
		.createInterface(interfaceDataCreation.name4, interfaceDataCreation.description4, InterfaceData.UPDATE_RESOURCE_AVAILABILITY , InterfaceData.WEBSERVICEACTION_FOR_UPDATE_RESOURCE_AVAILABILITY)
		.verifyCreatedInterfaceDetails(interfaceDataCreation.name4, InterfaceData.WEBSERVICEACTION_FOR_UPDATE_RESOURCE_AVAILABILITY, InterfaceData.UPDATE_RESOURCE_AVAILABILITY, InterfaceData.SCHEMA_FOR_UPDATE_RESOURCE_AVAILABILITY, interfaceDataCreation.description4)
		.clickOnStatusTypesLinkCorrespondingToInterface(interfaceDataCreation.name4)
		.verifyOptionsInSelectInterfaceStatusTypes(InterfaceData.REQUIRED_STATUS_TYPE_MAPPINGS_SECTION);

		UPDATE_RESOURCE_AVAILABILITY_INTERFACE = interfaceDataCreation.name4;
		DESCRIPTION_OF_UPDATE_RESOURCE_AVAILABILITY_INTERFACE = interfaceDataCreation.description4;

		Result="PASS";	
	}

	@Test(dependsOnMethods={"HappyDay94043"}, groups = {"HappyDay", "Setting Region Interfaces", "HappyDay94044"})
	public void HappyDay94044() throws Exception{

		TCID = "94044";
		TC_DESCRIPTION = "Verify that a region interface of type 'Update Resource Availability' can be edited.";	

		interfaceData = new InterfaceData();
		interfaceDataCreation = interfaceData.new InterfaceCreateData();

		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		interfaceSetup = new InterfaceSetUp(this.driver);

		navigateTo.interfaces();
		interfaceSetup.verifyInterfaceInInterfaceList(UPDATE_RESOURCE_AVAILABILITY_INTERFACE)
		.clickEditLink(UPDATE_RESOURCE_AVAILABILITY_INTERFACE)
		.verifyInterfaceRetainedDetails(UPDATE_RESOURCE_AVAILABILITY_INTERFACE, DESCRIPTION_OF_UPDATE_RESOURCE_AVAILABILITY_INTERFACE)
		.editInterface(interfaceDataCreation.editInterfaceName11, interfaceDataCreation.editInterfaceDescription)
		.verifyCreatedInterfaceDetails(interfaceDataCreation.editInterfaceName11, InterfaceData.WEBSERVICEACTION_FOR_UPDATE_RESOURCE_AVAILABILITY, InterfaceData.UPDATE_RESOURCE_AVAILABILITY, InterfaceData.SCHEMA_FOR_UPDATE_RESOURCE_AVAILABILITY, interfaceDataCreation.editInterfaceDescription);
		Result="PASS";
	}

	@Test (groups = {"HappyDay", "Setting Region Interfaces", "HappyDay94041"})
	public void HappyDay94041() throws Exception {

		TCID = "94041";
		TC_DESCRIPTION = "Verify that a region interface of type 'Get Hospital Status' can be created.";

		interfaceData = new InterfaceData();
		interfaceDataCreation = interfaceData.new InterfaceCreateData();

		navigateTo = new Shared(this.driver);
		interfaceSetup = new InterfaceSetUp(this.driver);
		usersData = new UsersData();
		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);

		login.loginToApplication(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD);
		selectRegion.selectRegionAndClickOnNext(RegionData.REGIONNAME);

		navigateTo.interfaces();
		interfaceSetup.verifyCreateNewInterfaceAndInterfaceListPage();

		interfaceSetup.createInterface(interfaceDataCreation.name7, interfaceDataCreation.description7, InterfaceData.GET_HOSPITAL_STATUS, InterfaceData.WEBSERVICEACTION_FOR_GET_HOSPITAL_STATUS)
		.verifyCreatedInterfaceDetails(interfaceDataCreation.name7, InterfaceData.WEBSERVICEACTION_FOR_GET_HOSPITAL_STATUS, InterfaceData.GET_HOSPITAL_STATUS, InterfaceData.SCHEMA_FOR_GET_HOSPITAL_STATUS, interfaceDataCreation.description7);
		interfaceSetup.clickOnStatusTypesLinkCorrespondingToInterface(interfaceDataCreation.name7)
		.verifyOptionsInSelectInterfaceStatusTypes(InterfaceData.OPTIONAL_STATUS_TYPE_MAPPINGS_SECTION)
		.verifyOptionsInSelectInterfaceStatusTypes(InterfaceData.CUSTOM_STATUS_TYPE_MAPPINGS_SECTION);


		GET_HOSPITAL_STATUS =interfaceDataCreation.name7;
		DESCRIPTION_GET_HOSPITAL_STATUS=interfaceDataCreation.description7;
	}

	@Test(dependsOnMethods={"HappyDay94041"},groups = {"HappyDay", "Setting Region Interface, HappyDay101821"})
	public void HappyDay101821() throws Exception{

		TCID = "101821";
		TC_DESCRIPTION = "Verify that a region interface of type 'Get Hospital Status' can be edited.";

		interfaceData = new InterfaceData();
		interfaceDataCreation = interfaceData.new InterfaceCreateData();

		navigateTo = new Shared(this.driver);
		interfaceSetup = new InterfaceSetUp(this.driver);

		navigateTo.interfaces();
		interfaceSetup.verifyInterfaceInInterfaceList(GET_HOSPITAL_STATUS)
		.clickEditLink(GET_HOSPITAL_STATUS)
		.verifyInterfaceRetainedDetails(GET_HOSPITAL_STATUS, DESCRIPTION_GET_HOSPITAL_STATUS)
		.editInterface(interfaceDataCreation.editInterfaceName12, interfaceDataCreation.editInterfaceDescription)
		.verifyCreatedInterfaceDetails(interfaceDataCreation.editInterfaceName12, InterfaceData.WEBSERVICEACTION_FOR_GET_HOSPITAL_STATUS, InterfaceData.GET_HOSPITAL_STATUS, InterfaceData.SCHEMA_FOR_GET_HOSPITAL_STATUS, interfaceDataCreation.editInterfaceDescription);
		Result = "PASS";
	}

	@Test(dependsOnMethods={"HappyDay148731"},groups = {"HappyDay", "Setting Region Interface, HappyDay148732"})
	public void HappyDay148732() throws Exception{

		TCID = "148732";
		TC_DESCRIPTION = " Verify that a region interface of type 'Chicago Get Hospital Status' can be deleted.";

		interfaceData = new InterfaceData();
		interfaceDataCreation = interfaceData.new InterfaceCreateData();

		navigateTo = new Shared(this.driver);
		interfaceSetup = new InterfaceSetUp(this.driver);

		navigateTo.interfaces();
		interfaceSetup.verifyInterfaceInInterfaceList(EDITED_INTERFACE_NAME_OF_CHICAGO_GET_HOSPITAL_STATUS);
		interfaceSetup.clickOnParametersLinkAndVerifyParameterListForRegionInterfacePageIsDisplayed(EDITED_INTERFACE_NAME_OF_CHICAGO_GET_HOSPITAL_STATUS)
		.deleteParameterOfRegionInterfaceAndVerifyParameterIsNotDisplayed(EDITED_PARAMETER_OF_CHICAGO_GET_HOSPITAL_STATUS_INTERFACE);
		navigateTo.interfaces();
		interfaceSetup.clickOnDeleteCorrespondingToInterfaceAndDismiss(EDITED_INTERFACE_NAME_OF_CHICAGO_GET_HOSPITAL_STATUS)
		.verifyInterfaceInInterfaceList(EDITED_INTERFACE_NAME_OF_CHICAGO_GET_HOSPITAL_STATUS)
		.clickOnDeleteCorrespondingToInterfaceAndAccept(EDITED_INTERFACE_NAME_OF_CHICAGO_GET_HOSPITAL_STATUS);

		Result= "PASS";
	}

	@Test(groups = {"HappyDay", "Setting Region Interfaces", "HappyDay148729"})
	public void HappyDay148729() throws Exception {

		TCID = "148729";
		TC_DESCRIPTION = "Verify that a region interface of type 'Chicago Get Hospital Status'can be created.";

		interfaceData = new InterfaceData();
		interfaceDataCreation = interfaceData.new InterfaceCreateData();
		usersData = new UsersData();

		navigateTo = new Shared(this.driver);
		interfaceSetup = new InterfaceSetUp(this.driver);

		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);

		login.loginToApplication(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD);
		selectRegion.selectRegionAndClickOnNext(RegionData.REGIONNAME);

		navigateTo.interfaces();

		interfaceSetup.createInterface(interfaceDataCreation.name8, interfaceDataCreation.description8, InterfaceData.CHICAGO_GET_HOSPITAL_STATUS, InterfaceData.WEBSERVICEACTION_FOR_CHICAGO_GET_HOSPITAL_STATUS)
		.verifyCreatedInterfaceDetails(interfaceDataCreation.name8, InterfaceData.WEBSERVICEACTION_FOR_CHICAGO_GET_HOSPITAL_STATUS, InterfaceData.CHICAGO_GET_HOSPITAL_STATUS, InterfaceData.SCHEMA_FOR_CHICAGO_GET_HOSPITAL_STATUS, interfaceDataCreation.description8)
		.verifyActionsOfTheInterface(interfaceDataCreation.name8)
		.clickOnUsersLinkAndVerifyRegionInterfaceUsersListPageIsDisplayed(interfaceDataCreation.name8)
		.verifyWebServiceUserUnderRegionInterfaceUsersListPage(usersData.interfaceRelatedWebSerivceUser, usersData.interfaceRelatedWebSerivceUserFullName)
		.verifyNoOtherUserIsDisplayedExcpetWebServiceUserOnRegionInterfaceList(usersData.interfaceRelatedUser, usersData.interfaceRelatedUserFullName)
		.clickOnCancel()
		.clickOnParametersLinkAndVerifyParameterListForRegionInterfacePageIsDisplayed(interfaceDataCreation.name8)
		.createParameter(interfaceDataCreation.parameterName, interfaceDataCreation.parameterValue)
		.verifyEditAndDeleteLinksCorrespondingToParameter(interfaceDataCreation.parameterName);

		CHICAGO_GET_HOSPITAL_STATUS_INTERFACE = interfaceDataCreation.name8;
		PARAMETER_OF_CHICAGO_GET_HOSPITAL_STATUS_INTERFACE = interfaceDataCreation.parameterName;

		Result = "PASS";
	}

	@Test(dependsOnGroups = {"HappyDay148729"}, groups = {"HappyDay", "Setting Region Interfaces", "HappyDay148731"})
	public void HappyDay148731() throws Exception {

		TCID = "148731";
		TC_DESCRIPTION = "Verify that a region interface of type 'Chicago Get Hospital Status'can be edited.";

		interfaceData = new InterfaceData();
		interfaceDataCreation = interfaceData.new InterfaceCreateData();

		navigateTo = new Shared(this.driver);
		interfaceSetup = new InterfaceSetUp(this.driver);

		navigateTo.interfaces();
		interfaceSetup.verifyInterfaceInInterfaceList(CHICAGO_GET_HOSPITAL_STATUS_INTERFACE);
		interfaceSetup.clickEditLink(CHICAGO_GET_HOSPITAL_STATUS_INTERFACE)
		.editInterface(interfaceDataCreation.editInterfaceName13, interfaceDataCreation.editInterfaceDescription)
		.verifyCreatedInterfaceDetails(interfaceDataCreation.editInterfaceName13, InterfaceData.WEBSERVICEACTION_FOR_CHICAGO_GET_HOSPITAL_STATUS, InterfaceData.CHICAGO_GET_HOSPITAL_STATUS, InterfaceData.SCHEMA_FOR_CHICAGO_GET_HOSPITAL_STATUS, interfaceDataCreation.editInterfaceDescription);
		interfaceSetup.clickOnParametersLinkAndVerifyParameterListForRegionInterfacePageIsDisplayed(interfaceDataCreation.editInterfaceName13)
		.verifyEditAndDeleteLinksCorrespondingToParameter(PARAMETER_OF_CHICAGO_GET_HOSPITAL_STATUS_INTERFACE);
		interfaceSetup.editParameter(PARAMETER_OF_CHICAGO_GET_HOSPITAL_STATUS_INTERFACE, interfaceDataCreation.editParameterName, interfaceDataCreation.editParameterValue)
		.verifyParameterValue(interfaceDataCreation.editParameterName, interfaceDataCreation.editParameterValue);

		EDITED_PARAMETER_OF_CHICAGO_GET_HOSPITAL_STATUS_INTERFACE = interfaceDataCreation.editParameterName;
		EDITED_INTERFACE_NAME_OF_CHICAGO_GET_HOSPITAL_STATUS=interfaceDataCreation.editInterfaceName13;
		Result = "PASS";
	}
}