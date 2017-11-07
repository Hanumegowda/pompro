package RequirementGroups.MultiRegion;

import org.testng.annotations.Test;

import qaFramework.Configurations.Configuration;
import EMR.data.EventData;
import EMR.data.EventSetUpData;
import EMR.data.LoginData;
import EMR.data.OtherRegionData;
import EMR.data.RegionData;
import EMR.data.ResourceData;
import EMR.data.ResourceTypeData;
import EMR.data.StatusTypeData;
import EMR.data.UsersData;
import EMR.data.EventData.EventCreateData;
import EMR.data.EventSetUpData.EventSetUpCreateData;
import EMR.data.ResourceData.ResourceCreateData;
import EMR.data.UsersData.UsersCreateData;
import EMR.pages.ConfigureNewRelationship;
import EMR.pages.EventManagement;
import EMR.pages.Login;
import EMR.pages.OtherRegionList;
import EMR.pages.RegionDefault;
import EMR.pages.ResourceTypes;
import EMR.pages.Resources;
import EMR.pages.SelectRegion;
import EMR.pages.Shared;
import EMR.pages.UsersList;
import EMR.pages.View;

public class AddingMutualAidRelationship extends Configuration {

	Login login;
	SelectRegion selectRegion;
	RegionDefault regionDefault;
	Shared navigateTo;
	UsersList usersList;
	OtherRegionList otherRegionList;
	ConfigureNewRelationship configurRelationShip;
	EventManagement eventManagement;
	Resources resources;

	LoginData loginData;
	ResourceTypeData resourceTypeData;
	ResourceData resourceData;
	StatusTypeData statusTypeData;
	UsersData usersData;
	UsersCreateData usersDataCreation;
	View view;
	EventSetUpData eventSetUpData;
	EventData eventData;
	EventCreateData eventCreateData;
	ResourceCreateData resourceDataCreation;

	static String USERNAME ;
	public AddingMutualAidRelationship() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test(groups = {"HappyDay","Multi Region", "HappyDay172442"})
	public void HappyDay172442() throws Exception {

		TCID ="172442";
		TC_DESCRIPTION ="Verify that Mutual aid relationship can be created between any two regions.";

		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		regionDefault = new RegionDefault(this.driver);
		navigateTo = new Shared(this.driver);
		usersList = new UsersList(this.driver);
		configurRelationShip = new ConfigureNewRelationship(this.driver);
		otherRegionList = new OtherRegionList(this.driver);

		loginData = new LoginData();
		statusTypeData = new StatusTypeData();
		resourceTypeData = new ResourceTypeData();
		resourceData = new ResourceData();
		usersData = new UsersData();
		String verifiedDate;

		String sharedStatusTypesNamesInReg1[] = {statusTypeData.sharedNSTName_InMutualAgreemnet_RG1,statusTypeData.sharedMSTName_InMutualAgreemnet_RG1,statusTypeData.sharedTSTName_InMutualAgreemnet_RG1,statusTypeData.sharedNedocName_InMutualAgreemnet_RG1,statusTypeData.sharedSSTName_InMutualAgreemnet_RG1,statusTypeData.sharedDateName_InMutualAgreemnet_RG1};
		String ResourceTypeInReg1 = resourceTypeData.RT_NAME_MutualAgreementRegion1;	
		String shredResourceInReg1 = resourceData.sharedResourceNAME1_MutualAgreement_RG1;
		String userInReg1= usersData.UserInMutualAidRegion1_WithAdditionalRights;

		String sharedStatusTypesNamesInReg2[] = {statusTypeData.sharedNSTName_InMutualAgreemnet_RG2,statusTypeData.sharedMSTName_InMutualAgreemnet_RG2,statusTypeData.sharedTSTName_InMutualAgreemnet_RG2,statusTypeData.sharedNedocName_InMutualAgreemnet_RG2,statusTypeData.sharedSSTName_InMutualAgreemnet_RG2,statusTypeData.sharedDateName_InMutualAgreemnet_RG2};
		String ResourceTypeInReg2 = resourceTypeData.RT_NAME_MutualAgreementRegion2;
		String shredResourceInReg2 = resourceData.sharedResourceNAME1_MutualAgreement_RG2;

		String region1=RegionData.REGION_WITH_MUTUAL_AGREEMENT1,
				region2=RegionData.REGIONNAME;

		login.loginToApplication(
				LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD);
		configurRelationShip.deleteExistingMutualAidRelationShip(region1, region2);
		selectRegion.selectRegionAndClickOnNext(region1);
		configurRelationShip.verifyOtherRegionDetailes(OtherRegionData.REGION_THAT_CAN_VIEW_TABLE_HEADER,OtherRegionData.CAN_VIEW_TABLE_HEADER);
		verifiedDate=configurRelationShip.createNewRelationShip(region2);

		otherRegionList.verifyingMutualAidAgreement(region2, OtherRegionData.ACTIVE_STATUS_NO, OtherRegionData.VERIFIED_STATUS_NO, OtherRegionData.VERIFIED_STATUS_YES, OtherRegionData.VERFIED_BY, verifiedDate);
		selectRegion.selectRegionAndClickOnNext(region2);
		otherRegionList.verifyRegionNotPresentInCanViewSection(region1);
		selectRegion.selectRegionAndClickOnNext(region1);
		otherRegionList.activateMutualAidAndVerifyActivationDetailes(region2, OtherRegionData.ACTIVE_STATUS_YES, OtherRegionData.VERFIED_BY, verifiedDate)
		.verifyManageUsersOptionNotAvailable(region2);

		selectRegion.selectRegionAndClickOnNext(region2);   
		otherRegionList.verifyingMutualAidAgreement(region1, OtherRegionData.ACTIVE_STATUS_NO, OtherRegionData.VERIFIED_STATUS_NO, OtherRegionData.VERIFIED_STATUS_YES, OtherRegionData.VERFIED_BY, verifiedDate);
		selectRegion.selectRegionAndClickOnNext(region1);
		otherRegionList.verifyRegionNotPresentInCanViewSection(region2);
		selectRegion.selectRegionAndClickOnNext(region2);
		otherRegionList.activateMutualAidAndVerifyActivationDetailes(region1, OtherRegionData.ACTIVE_STATUS_YES, OtherRegionData.VERFIED_BY, verifiedDate)
		.navigateToOtherRegionAndVerifyManageUserOption(region1)
		.verifySharedResourceAndStatusTypes(region1,ResourceTypeInReg1, shredResourceInReg1, sharedStatusTypesNamesInReg1);
		selectRegion.selectRegionAndClickOnNext(region1);   
		otherRegionList.verifySharedResourceAndStatusTypes(region2,ResourceTypeInReg2,shredResourceInReg2,sharedStatusTypesNamesInReg2)
		.navigateToOtherRegionAndVerifyManageUserOption(region2);
		login.logOut();
		login.loginAsUserAndAcknowledgeWebNotification(userInReg1,UsersData.PASSWORD);
		otherRegionList.verifySharedResourceAndStatusTypes(region2,ResourceTypeInReg2,shredResourceInReg2,sharedStatusTypesNamesInReg2);
		login.logOut();                      
		Result = "PASS";
	}
	
	@Test(dependsOnMethods={"HappyDay172442"},groups = {"HappyDay","Multi Region", "HappyDay172443"})
	public void HappyDay172443() throws Exception {

		//Verification part of "Manage Users Option Not Available" after activating mutual aid relation in RG1 region is covered in test case HappyDay172442.	

		TCID ="172443";
		TC_DESCRIPTION ="Verify that ‘manage users’ link will be available corresponding to ‘RG1’ under '[activeregion] can view' section when mutual aid is activated in both the regions.";

		otherRegionList = new OtherRegionList(this.driver);
		String region1=RegionData.REGION_WITH_MUTUAL_AGREEMENT1;
		String region2=RegionData.REGIONNAME;	
		
		login.loginToApplication(
				LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD);
		selectRegion.selectRegionAndClickOnNext(region1);
		otherRegionList.navigateToOtherRegionAndVerifyManageUserOption(region2);
		login.logOut();   
		Result = "PASS";	
	}

	@Test(groups = {"HappyDay","Multi Region", "HappyDay172444"})
	public void HappyDay172444() throws Exception {

		TCID ="172444";
		TC_DESCRIPTION ="Verify that when a mutual agreement is created between two regions say ‘RG1’ and ‘RG2’ and admin makes an attempt to create new agreement, ‘RG1’ will not be available under 'New Mutual Aid Agreement' selection list under 'Configure New Relationship' page.";

		String region1=RegionData.REGION_WITH_MUTUAL_AGREEMENT1,
				region2=RegionData.REGION_WITH_MUTUAL_AGREEMENT2;

		login = new Login(this.driver);
		selectRegion = new SelectRegion(this.driver);
		navigateTo = new Shared(this.driver);
		configurRelationShip=new ConfigureNewRelationship(this.driver);

		login.loginToApplication(
				LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD);
		selectRegion.selectRegionAndClickOnNext(region1);	
		configurRelationShip.verifyRegionIsUnavailabUnderSelectRegionOfConfigureNewRelationShip(region2);
		Result = "PASS";
	}

	@Test(dependsOnMethods={"HappyDay172444"},groups = {"HappyDay","Multi Region", "HappyDay172441"})
	public void HappyDay172441() throws Exception {

		TCID ="172441";
		TC_DESCRIPTION ="Verify that while creating and editing a user check-box corresponding to region under 'View Other Regions' section is disabled and checked. Only when there exists a mutual agreement between the regions";

		otherRegionList = new OtherRegionList(this.driver);	
		usersList= new UsersList(this.driver);

		String regionValue;
		String region2=RegionData.REGION_WITH_MUTUAL_AGREEMENT2;
		String userInReg2=usersData.UserInMutualAidRegion2_WithAdditionalRights;
		
		regionValue=otherRegionList.verifyAssigneForAllUsersIsChecked(region2);
		usersList.verifyViewOtherRegionSectionIsDisabledAndCheckedForCreateUser(region2,regionValue)
		.verifyViewOtherRegionSectionIsDisabledAndCheckedForEditUser(region2,userInReg2,regionValue);
		Result = "PASS";	
	}

	@Test(dependsOnMethods={"HappyDay172444"},groups = {"HappyDay","Multi Region", "HappyDay172440"})
	public void HappyDay172440() throws Exception {

		login= new Login(this.driver);	
		otherRegionList = new OtherRegionList(this.driver);
		usersList= new UsersList(this.driver);

		TCID ="172440";
		TC_DESCRIPTION ="Verify that while creating or editing a user 'View Other Regions' check box corresponding to a region is unchecked, only when assign for all users check box is deselected after creating a mutual agreement between two regions.";

		String regionValue;
		String region2 = RegionData.REGION_WITH_MUTUAL_AGREEMENT2;
		String userInReg2 = usersData.UserInMutualAidRegion2_WithAdditionalRights;

		regionValue = otherRegionList.unCheckAssigneForAllUsers(region2);
		usersList.verifyViewOtherRegionSectionIsEnabledAndUnCheckedForCreateUser(region2,regionValue)
		.verifyViewOtherRegionSectionIsEnabledAndUnCheckedForEditUser(region2,userInReg2,regionValue);
		otherRegionList.selectCheckForAllUsers(region2);
		login.logOut();
		Result = "PASS";	
	 }

	@Test(groups = {"HappyDay","Multi Region", "HappyDay172446"})
	 public void HappyDay172446() throws Exception {
		
	otherRegionList = new OtherRegionList(this.driver);		
	configurRelationShip= new ConfigureNewRelationship(this.driver);
	selectRegion= new SelectRegion(this.driver);
	login= new Login(this.driver);
		
	TCID ="172446";
	TC_DESCRIPTION ="Verify that when ‘reciprocal’ check box is deselected while creating the agreement between two regions ‘RG1’ to ‘RG2’, mutual agreement is created for only region ‘RG1’ and not to ‘RG2’. ";
	//Verification part of "Region is available in Rg2 if reciprocal check box is selected while creting mutual aid in Rg1" is coverd in test case HappyDay172442.	
	
	login.loginToApplication(
			LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD);
	configurRelationShip.deleteExistingMutualAidRelationShip(RegionData.SETRACREGION, RegionData.STATE_OF_MISSOURI);
	selectRegion.selectRegionAndClickOnNext(RegionData.SETRACREGION);	
	configurRelationShip.createNewRelationShipWithoutReciprocal(RegionData.STATE_OF_MISSOURI);
	otherRegionList.verifyRegionUnderThatCanViewSection(RegionData.STATE_OF_MISSOURI);
	selectRegion.selectRegionAndClickOnNext(RegionData.STATE_OF_MISSOURI);	
	otherRegionList.verifyRegionIsNotUnderThatCanViewSection(RegionData.SETRACREGION);
	Result = "PASS";
   }
	
	@Test(dependsOnMethods="HappyDay172446",groups = {"HappyDay","Multi Region", "HappyDay172445"})
	 public void HappyDay172445() throws Exception {
		
	navigateTo = new Shared(this.driver);
	otherRegionList = new OtherRegionList(this.driver);		
	configurRelationShip= new ConfigureNewRelationship(this.driver);
	selectRegion= new SelectRegion(this.driver);
	login= new Login(this.driver);
		
	TCID ="172445";
	TC_DESCRIPTION ="Verify that when reciprocal check box is selected while creating the agreement between regions’ RG1’ and ‘RG2’ then the agreement will be available in both the regions 'RG1' and ‘RG2’. ";
	
	configurRelationShip.deleteExistingMutualAidRelationShip(RegionData.SETRACREGION, RegionData.STATE_OF_MISSOURI);
	selectRegion.selectRegionAndClickOnNext(RegionData.SETRACREGION);	
	navigateTo.otherRegion();
	configurRelationShip.createNewRelationShip(RegionData.STATE_OF_MISSOURI);
	otherRegionList.verifyRegionUnderThatCanViewSection(RegionData.STATE_OF_MISSOURI);
	selectRegion.selectRegionAndClickOnNext(RegionData.STATE_OF_MISSOURI);	
	navigateTo.otherRegion();
	otherRegionList.verifyRegionUnderThatCanViewSection(RegionData.SETRACREGION);
	configurRelationShip.deleteExistingMutualAidRelationShip(RegionData.SETRACREGION, RegionData.STATE_OF_MISSOURI);
	login.logOut();
	Result = "PASS";
   }
	
	@Test(groups = {"HappyDay","Multi Region", "HappyDay172448"})
	public void HappyDay172448() throws Exception {

		TCID ="172448";
		TC_DESCRIPTION ="Verify that When region ‘RG1’ creates an agreement with region ‘RG2’. Users created in ‘RG1’ can view the shared status types and resource of ‘RG2’and vice versa.";

		String region1=RegionData.REGION_WITH_MUTUAL_AGREEMENT1,
				region2=RegionData.REGION_WITH_MUTUAL_AGREEMENT2;

		login= new Login(this.driver);
		otherRegionList = new OtherRegionList(this.driver);		

		String sharedStatusTypesNamesInReg1[] = {statusTypeData.sharedNSTName_InMutualAgreemnet_RG1,statusTypeData.sharedMSTName_InMutualAgreemnet_RG1,statusTypeData.sharedTSTName_InMutualAgreemnet_RG1,statusTypeData.sharedNedocName_InMutualAgreemnet_RG1,statusTypeData.sharedSSTName_InMutualAgreemnet_RG1,statusTypeData.sharedDateName_InMutualAgreemnet_RG1};
		String ResourceTypeInReg1 = resourceTypeData.RT_NAME_MutualAgreementRegion1;	
		String shredResourceInReg1 = resourceData.sharedResourceNAME1_MutualAgreement_RG1;
		String userInReg1= usersData.UserInMutualAidRegion1_WithAdditionalRights;

		String sharedStatusTypesNamesInReg2[] = {statusTypeData.sharedNSTName_InMutualAgreemnet_RG2,statusTypeData.sharedMSTName_InMutualAgreemnet_RG2,statusTypeData.sharedTSTName_InMutualAgreemnet_RG2,statusTypeData.sharedNedocName_InMutualAgreemnet_RG2,statusTypeData.sharedSSTName_InMutualAgreemnet_RG2,statusTypeData.sharedDateName_InMutualAgreemnet_RG2};
		String ResourceTypeInReg2 = resourceTypeData.RT_NAME_MutualAgreementRegion2;
		String shredResourceInReg2 = resourceData.sharedResourceNAME1_MutualAgreement_RG2;
		String userInReg2=usersData.UserInMutualAidRegion2_WithAdditionalRights;

		login.loginAsUserAndAcknowledgeWebNotification(userInReg1,UsersData.PASSWORD);
		otherRegionList.verifySharedResourceAndStatusTypes(region2,ResourceTypeInReg2,shredResourceInReg2,sharedStatusTypesNamesInReg2);
		login.logOut();  
		login.loginAsUserAndAcknowledgeWebNotification(userInReg2,UsersData.PASSWORD);
		otherRegionList.verifySharedResourceAndStatusTypes(region1,ResourceTypeInReg1,shredResourceInReg1,sharedStatusTypesNamesInReg1);
		login.logOut(); 
		Result = "PASS";
	}

	@Test(groups = {"HappyDay","Multi Region", "HappyDay172452"})
	public void HappyDay172452() throws Exception {
		
		TCID ="172452";
		TC_DESCRIPTION ="Verify that after creating mutual agreement between the regions user from 'RG2' with appropriate right should be able to create custom view by selecting region RG1's resource. ";
		
		login= new Login(this.driver);
		otherRegionList = new OtherRegionList(this.driver);	
		view= new View(this.driver);
		navigateTo= new Shared(this.driver);
		
		statusTypeData = new StatusTypeData();
		resourceData = new ResourceData();
		resourceTypeData = new ResourceTypeData();
		usersData = new UsersData();
	
		String[] ResourceTypeInReg1 = new String[1];
		String[] shredResourceInReg1 = new String[1];
		String[] shredResourceValueInReg1= new String[1];
		
		String sharedStatusTypesNamesInReg1[] = {statusTypeData.sharedNSTName_InMutualAgreemnet_RG1,statusTypeData.sharedMSTName_InMutualAgreemnet_RG1,statusTypeData.sharedTSTName_InMutualAgreemnet_RG1,statusTypeData.sharedNedocName_InMutualAgreemnet_RG1,statusTypeData.sharedSSTName_InMutualAgreemnet_RG1,statusTypeData.sharedDateName_InMutualAgreemnet_RG1};
		String sharedStatusTypeValues[] = {statusTypeData.sharedNSTValue_InMutualAgreemnet_RG1, statusTypeData.sharedMSTValue_InMutualAgreemnet_RG1,statusTypeData.sharedTSTValue_InMutualAgreemnet_RG1,statusTypeData.sharedNedocValue_InMutualAgreemnet_RG1,statusTypeData.sharedSSTValue_InMutualAgreemnet_RG1,statusTypeData.sharedDateValue_InMutualAgreemnet_RG1};
		ResourceTypeInReg1[0] = resourceTypeData.RT_NAME_MutualAgreementRegion1;	
		shredResourceInReg1[0] = resourceData.sharedResourceNAME1_MutualAgreement_RG1;
		shredResourceValueInReg1[0] = resourceData.sharedResourceVALUE1_MutualAgreement_RG1;
		String userInReg2=usersData.UserInMutualAidRegion2_WithAdditionalRights;

		login.loginAsUserAndAcknowledgeWebNotification(userInReg2,UsersData.PASSWORD);
		navigateTo.customView();
		view.createCustomViewByDeletingExistingCustomView(shredResourceInReg1[0], shredResourceValueInReg1,sharedStatusTypeValues, ResourceTypeInReg1[0]);
		view.verifyCreatedCustomViewDetailes(ResourceTypeInReg1[0], shredResourceInReg1[0],sharedStatusTypesNamesInReg1);
		login.logOut(); 
		Result = "PASS";
	}

	@Test(groups = {"HappyDay","Multi Region", "HappyDay172688"})
	public void HappyDay172688() throws Exception {

		TCID ="172688";
		TC_DESCRIPTION ="Verify that System admin can verify/unverify the mutual aid agreement";

		login= new Login(this.driver);
		otherRegionList = new OtherRegionList(this.driver);
		navigateTo = new Shared(this.driver);
		configurRelationShip=new ConfigureNewRelationship(this.driver);
		otherRegionList = new OtherRegionList(this.driver);

		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		navigateTo.otherRegion();
		configurRelationShip.createMutualAidAgreement(RegionData.REGION_NAME_2);
		otherRegionList.verifyDeleteOptionExists(RegionData.REGION_NAME_2)
		.clickOnVerify(RegionData.REGION_NAME_2)
		.verifyUnVerifyOptionExists(RegionData.REGION_NAME_2)
		.verifyActivateOptionExists(RegionData.REGION_NAME_2)
		.unverifyRegionAgreements(RegionData.REGION_NAME_2)
		.deleteMutualAidRelationship(RegionData.REGION_NAME_2);
		login.logOut();
		Result = "PASS";
	} 

	@Test(groups = {"HappyDay","Multi Region", "HappyDay172707"})
	public void HappyDay172707() throws Exception {

		TCID ="172707";
		TC_DESCRIPTION ="Verify that user can activate/deactivate mutual aid agreement only in the regions in which user has 'Administer Other Region Views' right";

		usersData = new UsersData();
		usersDataCreation = usersData.new UsersCreateData();

		login= new Login(this.driver);
		navigateTo = new Shared(this.driver);
		usersList = new UsersList(this.driver);
		configurRelationShip=new ConfigureNewRelationship(this.driver);
		otherRegionList = new OtherRegionList(this.driver);

		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		navigateTo.users();
		usersList.createUserWithMandatoryDetailsWithRoleWithoutSave(
				usersDataCreation.name, UsersData.INITIAL_PASSWORD,
				usersDataCreation.fullName, UsersData.PRIMARY_EMAILID,
				UsersData.PRIMARY_EMAILID)
				.provideSetupOtherRegionViewsRightAndSetupResourcesAddAndEditRight();
		USERNAME = usersDataCreation.name;
		navigateTo.otherRegion();
		configurRelationShip.createNewRelationshipAndVerifyAgreement(RegionData.REGION_NAME_2);
		login.logOut();

		login.loginAsNewUser(usersDataCreation.name, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
		navigateTo.otherRegion();
		otherRegionList.activateMutualAgreementWithRegion(RegionData.REGION_NAME_2)
		.verifyDeActivateOptionExists(RegionData.REGION_NAME_2)
		.deactivateRegionAgreement(RegionData.REGION_NAME_2)
		.verifyActivateOptionExists(RegionData.REGION_NAME_2);
		
		login.logOut();
		Result = "PASS";
	}
	
	@Test(dependsOnMethods = {"HappyDay172707"}, groups = {"HappyDay","Multi Region", "HappyDay172915"})
	public void HappyDay172915() throws Exception {

		TCID ="172915";
		TC_DESCRIPTION ="Verify that 'Regional Admin' (Administer Other Region Views right) cannot 'activate/deactivate' mutual aid agreement for the unverified regions.";

		usersData = new UsersData();
		usersDataCreation = usersData.new UsersCreateData();

		login= new Login(this.driver);
		navigateTo = new Shared(this.driver);
		usersList = new UsersList(this.driver);
		configurRelationShip=new ConfigureNewRelationship(this.driver);
		otherRegionList = new OtherRegionList(this.driver);

		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);

		navigateTo.otherRegion();
		configurRelationShip.unverifyRegionAgreement(RegionData.REGION_NAME_2);
		login.logOut();

		login.loginAsUser(USERNAME, UsersData.PASSWORD);
		navigateTo.otherRegion();
		otherRegionList.verifyActionLinksAreNotAvailable(RegionData.REGION_NAME_2);
		login.logOut();
		Result = "PASS";
	}
	
	@Test(groups = {"HappyDay","Multi Region", "HappyDay172453"})
	public void HappyDay172453() throws Exception {

		TCID ="172453";
		TC_DESCRIPTION ="Verify that region RG1's resource can be viewed in event detail view and other region view of RG1 from region RG2, after creating mutual agreement between the regions RG1 and RG2";

		usersData = new UsersData();
		eventData = new EventData();
	    eventCreateData = eventData.new EventCreateData();
	    eventSetUpData = new EventSetUpData();
	    resourceData = new ResourceData();
	    resourceTypeData = new ResourceTypeData();
	    statusTypeData = new StatusTypeData();

		login= new Login(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement = new EventManagement(this.driver);
		regionDefault = new RegionDefault(this.driver);
		view = new View(this.driver);

		String region1_name = RegionData.REGION_WITH_MUTUAL_AGREEMENT1,
			username_Region1 = usersData.UserInMutualAidRegion1_WithAdditionalRights,
			username_Region2 = usersData.UserInMutualAidRegion2_WithAdditionalRights,
			eventTemplate = eventSetUpData.eventTemplateInMutualAidRegion1,
			resourceType = resourceTypeData.RT_NAME_MutualAgreementRegion1,
			resourceName = resourceData.sharedResourceNAME1_MutualAgreement_RG1;
		String[] statusTypes = {statusTypeData.sharedNSTName_InMutualAgreemnet_RG1, statusTypeData.sharedMSTName_InMutualAgreemnet_RG1, statusTypeData.sharedTSTName_InMutualAgreemnet_RG1,
				statusTypeData.sharedNedocName_InMutualAgreemnet_RG1, statusTypeData.sharedSSTName_InMutualAgreemnet_RG1, statusTypeData.sharedDateName_InMutualAgreemnet_RG1,
				statusTypeData.eventSharedNSTName_InMutualAgreemnet_RG1, statusTypeData.eventSharedMSTName_InMutualAgreemnet_RG1, statusTypeData.eventSharedTSTName_InMutualAgreemnet_RG1,
				statusTypeData.eventSharedNedocName_InMutualAgreemnet_RG1, statusTypeData.eventSharedSSTName_InMutualAgreemnet_RG1, statusTypeData.eventSharedDateName_InMutualAgreemnet_RG1};
		
		login.loginAsUser(username_Region1, UsersData.PASSWORD);

		navigateTo.eventManagment();
		eventManagement.createEvent(eventTemplate, eventCreateData.name, eventCreateData.description, resourceData.sharedResourceNAME1_MutualAgreement_RG1);
		login.logOut();

		login.loginAsUser(username_Region2, UsersData.PASSWORD);
		navigateTo.regionUnderOtherRegion(region1_name);
		view.verifyResourceTypeResourceAndStatusType(resourceType, resourceName, statusTypes);
		eventManagement.navigateToEventStatusFromEventBanner(eventCreateData.name);
		view.verifyResourceTypeResourceAndStatusType(resourceType, resourceName, statusTypes);
		login.logOut();
		Result = "PASS";
	}
	
	@Test(groups = {"HappyDay","Multi Region", "HappyDay172462"})
	public void HappyDay172462() throws Exception {

		TCID ="172462";
		TC_DESCRIPTION ="Verify that region RG1's resource can be viewed in event detail view and other region view of RG1 from region RG2, after creating mutual agreement between the regions RG1 and RG2";

		usersData = new UsersData();
		eventData = new EventData();
	    eventCreateData = eventData.new EventCreateData();
	    eventSetUpData = new EventSetUpData();
	    resourceData = new ResourceData();
	    resourceTypeData = new ResourceTypeData();
	    statusTypeData = new StatusTypeData();
	    resourceData=new ResourceData();
	    resourceDataCreation=resourceData.new ResourceCreateData();

		login= new Login(this.driver);
		navigateTo = new Shared(this.driver);
		eventManagement = new EventManagement(this.driver);
		regionDefault = new RegionDefault(this.driver);
		view = new View(this.driver);
		resources = new Resources(this.driver);

		String region1_name = RegionData.REGION_WITH_MUTUAL_AGREEMENT1,
			username_Region1 = usersData.UserInMutualAidRegion1_WithAdditionalRights,
			username_Region2 = usersData.UserInMutualAidRegion2_WithAdditionalRights,
			eventTemplate = eventSetUpData.eventTemplateInMutualAidRegion1,
			resourceType = resourceTypeData.RT_NAME_MutualAgreementRegion1,
			resourceName = resourceDataCreation.sharedRS_Name;
		String[] statusTypes = {statusTypeData.sharedNSTName_InMutualAgreemnet_RG1, statusTypeData.sharedMSTName_InMutualAgreemnet_RG1,
					statusTypeData.sharedTSTName_InMutualAgreemnet_RG1, statusTypeData.sharedNedocName_InMutualAgreemnet_RG1,
					statusTypeData.sharedSSTName_InMutualAgreemnet_RG1, statusTypeData.sharedDateName_InMutualAgreemnet_RG1,
					statusTypeData.eventSharedNSTName_InMutualAgreemnet_RG1, statusTypeData.eventSharedMSTName_InMutualAgreemnet_RG1,
					statusTypeData.eventSharedTSTName_InMutualAgreemnet_RG1, statusTypeData.eventSharedNedocName_InMutualAgreemnet_RG1,
					statusTypeData.eventSharedSSTName_InMutualAgreemnet_RG1, statusTypeData.eventSharedDateName_InMutualAgreemnet_RG1};
		
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, region1_name);
		
		navigateTo.resources();
	    resources.createSharedResourceWithAddress(
	    		resourceName, resourceDataCreation.abbrevation,
	    		resourceType, ResourceData.STANDARDRESOURCETYPE,
	    		ResourceData.FIRSTNAME, ResourceData.LASTNAME, ResourceData.STREETADDRESS, 
	    		ResourceData.CITY, ResourceData.STATE, ResourceData.ZIPCODE, ResourceData.COUNTY);
		
		login.logOut()
			.loginAsUser(username_Region1, UsersData.PASSWORD);

		navigateTo.eventManagment();
		eventManagement.createPrivateEvent(eventTemplate, eventCreateData.name, eventCreateData.description, resourceName);
		login.logOut();

		login.loginAsUser(username_Region2, UsersData.PASSWORD);
		navigateTo.regionUnderOtherRegion(region1_name);
		view.verifyResourceTypeResourceAndStatusType(resourceType, resourceName, statusTypes);
		eventManagement.navigateToEventStatusFromEventBanner(eventCreateData.name);
		view.verifyNoResourceTypeResourceAndStatusTypeIsPresent(resourceType, resourceName, statusTypes);
		login.logOut();
		Result = "PASS";
	}
	
	@Test(groups = {"HappyDay","Multi Region", "HappyDay172463"})
	public void HappyDay172463() throws Exception {

		TCID ="172463";
		TC_DESCRIPTION ="Verify that the resource of RG1 cannot be edited from RG2 When there exists a mutual agreement between the regions RG1 and RG2";

		usersData = new UsersData();
	    usersData = new UsersData();
		usersDataCreation = usersData.new UsersCreateData();
		resourceData = new ResourceData();

		login= new Login(this.driver);
		navigateTo = new Shared(this.driver);
		resources = new Resources(this.driver);
		usersList = new UsersList(this.driver);

		String region1_name = RegionData.REGION_WITH_MUTUAL_AGREEMENT1,
			resourceName = resourceData.sharedResourceNAME1_MutualAgreement_RG2;
		
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, region1_name);
		
		navigateTo.users();
		usersList.createUserWithMandatoryDetailsWithRoleWithoutSave(usersDataCreation.name, UsersData.INITIAL_PASSWORD, usersDataCreation.fullName, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID)
				 .provideSetupResourcesAddAndEditRightAndSave();
		
		login.logOut()
			.loginAsNewUser(usersDataCreation.name, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);

		navigateTo.resources();
		resources.verifyResourceIsNotPresent(resourceName);
		login.logOut();

		Result = "PASS";
	}
}	