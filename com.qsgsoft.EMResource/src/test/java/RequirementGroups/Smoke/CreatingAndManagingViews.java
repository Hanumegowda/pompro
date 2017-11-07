package RequirementGroups.Smoke;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.annotations.Test;

import qaFramework.Configurations.Configuration;
import EMR.data.LoginData;
import EMR.data.RegionData;
import EMR.data.ResourceData;
import EMR.data.ResourceTypeData;
import EMR.data.StatusTypeData;
import EMR.data.UpdateStatusData;
import EMR.data.UpdateStatusData.UpdateStatusCreateData;
import EMR.data.UsersData;
import EMR.data.ViewData;
import EMR.data.ViewData.ViewCreateData;
import EMR.pages.Login;
import EMR.pages.RegionDefault;
import EMR.pages.SelectRegion;
import EMR.pages.Shared;
import EMR.pages.UpdateStatus;
import EMR.pages.UsersList;
import EMR.pages.View;
import EMR.pages.ViewResourceDetail;
import EMR.pages.ViewsUnderSetup;
import eICS.data.ContactsData;
import eICS.data.ContactsData.ContactsCreateData;

public class CreatingAndManagingViews extends Configuration {

	public CreatingAndManagingViews() throws Exception {
		super();
	}

	LoginData loginData;
	UsersData usersData;
	ContactsData contactsData;
	ContactsCreateData contactsDataCreation;
	RegionData regionData;
	ResourceTypeData resourceTypeData;
	ResourceData resourceData;
	StatusTypeData statusTypeData;
	ViewData viewsData;
	ViewCreateData viewsDataCreation;
	UpdateStatusData updateStatusData;
	UpdateStatusCreateData updateStatusCreateData;
	
	Login login;
	RegionDefault regionDefault;
	Shared navigateTo;
	SelectRegion selectRegion;
	UsersList usersList;
	ViewsUnderSetup views;
	View viewsList;
	UpdateStatus updateStatus;
	ViewResourceDetail viewResourceDetail;
	ViewData viewData;
	
	@Test(groups = {"Smoke", "Views", "Smoke183489"})
	
	public void Smoke186241() throws Exception {
		
	    TCID = "186241";
	    TC_DESCRIPTION = "Verify that user can view 'other region view'";
		
	    regionData 			= new RegionData();
	    resourceTypeData	= new ResourceTypeData();
	    usersData 			= new UsersData();
	    resourceData 		= new ResourceData();
	    statusTypeData		= new StatusTypeData();
	 
	    usersList 		= new UsersList(this.driver);
	    regionDefault	= new RegionDefault(this.driver);
	    login 			= new Login(this.driver);
	    navigateTo 		= new Shared(this.driver);
	
		String StatusTypeNames[] = { statusTypeData.sharedNumberStatusTypeInMutualAgreementRegion1,
									statusTypeData.sharedMultiStatusTypeInMutualAgreementRegion1,
									statusTypeData.sharedSaturationStatusTypeInMutualAgreementdRegion1,
									statusTypeData.sharedNedocsStatusTypeInMutualAgreementRegion1,
									statusTypeData.sharedTextStatusTypeInMutualAgreementRegion1,
									statusTypeData.sharedDateStatusTypeInMutualAgreementRegion1 };

		login.loginAsUser(usersData.userInMutualAgreementRegion2, UsersData.PASSWORD);
		navigateTo.regionUnderOtherRegion(RegionData.REGION_WITH_MUTUAL_AGREEMENT1);
		regionDefault.verifyResourceTypeAndResource(resourceTypeData.resourceTypeNameInMutualAgreementRegion1, resourceData.sharedResourceNameInMutualAgreementRegion1)
					 .verifyResourceTypeAndStatusType(resourceTypeData.resourceTypeNameInMutualAgreementRegion1, StatusTypeNames);
		 login.logOut();
		Result = "PASS";
	}
	
	@Test(groups = {"Smoke", "Views", "Smoke186243"})
	public void Smoke186243() throws Exception {
		
	    TCID = "186243";
	    TC_DESCRIPTION = "Verify that SystemAdmin is able to create a view";
		
	    resourceTypeData 	= new ResourceTypeData();
	    resourceData 		= new ResourceData();
	    statusTypeData		= new StatusTypeData();
	    viewsData			= new ViewData();
	    viewsDataCreation	= viewsData.new ViewCreateData();
	    
	    usersList = new UsersList(this.driver);
	    selectRegion = new SelectRegion(this.driver);
	    regionDefault = new RegionDefault(this.driver);
	    login = new Login(this.driver);
	    navigateTo = new Shared(this.driver);
	    views = new ViewsUnderSetup(this.driver);
	    viewsList = new View(this.driver);
	
	    String StatusTypeNames[] = { statusTypeData.sharedNumberStatusTypeInMutualAgreementRegion1,
									statusTypeData.sharedMultiStatusTypeInMutualAgreementRegion1,
									statusTypeData.sharedSaturationStatusTypeInMutualAgreementdRegion1,
									statusTypeData.sharedNedocsStatusTypeInMutualAgreementRegion1,
									statusTypeData.sharedTextStatusTypeInMutualAgreementRegion1,
									statusTypeData.sharedDateStatusTypeInMutualAgreementRegion1};

		login.loginToApplication(LoginData.QSGTESTER_ADMIN, UsersData.PASSWORD);
		selectRegion.selectRegionAndClickOnNext(RegionData.REGION_WITH_MUTUAL_AGREEMENT1);
		navigateTo.viewUnderSetup();
		views.createView(viewsDataCreation.name, ViewData.DESCRIPTION, resourceData.sharedResourceNameInMutualAgreementRegion1, StatusTypeNames);
		navigateTo.particularView(viewsDataCreation.name);
		viewsList.verifyResourceTypeAndResource(resourceTypeData.resourceTypeNameInMutualAgreementRegion1, resourceData.sharedResourceNameInMutualAgreementRegion1)
				 .verifyResourceTypeAndStatusType(resourceTypeData.resourceTypeNameInMutualAgreementRegion1, StatusTypeNames);
		login.logOut();
		Result = "PASS";
	}
	
	@Test(groups = {"Smoke","Views", "Smoke186259"})
	public void Smoke186259() throws Exception {
		
		TCID = "186259";
		TC_DESCRIPTION ="Verify that user with appropriate right can update status types 'View Resource detail' page";

		login= new Login(this.driver);
		updateStatus= new UpdateStatus(this.driver);
		regionDefault= new RegionDefault(this.driver);
		loginData = new LoginData();
		viewResourceDetail= new ViewResourceDetail(this.driver);
		
		resourceData = new ResourceData();
		usersData=new UsersData();
		statusTypeData= new StatusTypeData();
		resourceTypeData= new ResourceTypeData();
		updateStatusData = new UpdateStatusData();
		updateStatusCreateData=updateStatusData.new UpdateStatusCreateData();
		viewData= new ViewData();
		String updatedSaturationScore="";
		String updatedNedocsScore="";
		String updatedMultiStatus="";
		String[] statusTypeNames ={statusTypeData.roleBasedSaturationStatusType,
				statusTypeData.roleBasedNedocsStatusType,
				statusTypeData.roleBasedMultiStatusType,
				statusTypeData.roleBasedTextStatusType,
				statusTypeData.roleBasedDateStatusType ,
				statusTypeData.roleBasedNumberStatusType};
		
		login.loginAsUserAndAcknowledgeWebNotification(usersData.preferanceUser, UsersData.PASSWORD);
		regionDefault.verifyResourceAndCorrespondingStatusTypes(resourceTypeData.preferanceResourceType, resourceData.roleBasedResourceName,statusTypeNames);
		
		  String previousUpdatedSaturationScore=updateStatus.getUpdatedValueOfSaturationStatusType(resourceData.roleBasedResourceName);
		  String previousUpdatedNedocsScore= updateStatus.getUpdatedValueOfNedocsStatusType(resourceData.roleBasedResourceName);
		  String previousUpdatedMultiStatus= updateStatus.getUpdatedValueOfMultiStatusType(resourceData.roleBasedResourceName);
		  
		  System.out.println("previousUpdatedSaturationScore" +previousUpdatedSaturationScore);
		  System.out.println("previousUpdatedNedocsScore" +previousUpdatedNedocsScore);
		  System.out.println(resourceData.roleBasedResourceName);
		  
		  regionDefault.clickOnResourceToNavigateResourceDetailPage(resourceData.roleBasedResourceName);
		  viewResourceDetail.verifyViewResourceDetailsPage()
		                    .verifyStatusTypesUnderSection(statusTypeNames, viewData.sectionNameWithRoledStatusTypes);
		                  
		updateStatus.clickOnStatusTypeNavigateToUpdateStatusPageAndSelectAll(statusTypeData.roleBasedNumberStatusType); 
		
	    updatedSaturationScore=updateStatus.updateSaturationStatusTypeOtherThenPreviousUpdatedScore(
				statusTypeData.roleBasedSaturationStatusTypeValue,
				UpdateStatusData.SATURATIONSCORE_VALUES_TO_UPDATE1,
				UpdateStatusData.SATURATIONSCORE_VALUES_TO_UPDATE2,
				UpdateStatusData.CALCULATED_SATURATION_SCORE1,
				UpdateStatusData.CALCULATED_SATURATION_SCORE2,
				previousUpdatedSaturationScore);
		
	    updatedNedocsScore=	updateStatus.updateNedocsStatusTypeOtherThenPreviousUpdatedScore(
				statusTypeData.roleBasedNedocsStatusTypeValue,
				UpdateStatusData.NEDOCS_VALUES_TO_UPDATE1,
				UpdateStatusData.NEDOCS_VALUES_TO_UPDATE2,
				UpdateStatusData.CALCULATED_NEDOCS_SCORE1,
				UpdateStatusData.CALCULATED_NEDOCS_SCORE2,
				previousUpdatedNedocsScore);
		
	     updatedMultiStatus=updateStatus.updateMultiStatusOtherThenPreviousUpdatedStatus(
				statusTypeData.roleBasedMultiStatusTypeValue,
				statusTypeData.roleStatus1, statusTypeData.roleStatus2,
				statusTypeData.roleStatus1Value,
				statusTypeData.roleStatus2Value, previousUpdatedMultiStatus);
				
	     updateStatus.enterNumberOrTextOrDateStatusTypesUpdateValue(statusTypeData.roleBasedTextStatusTypeValue,updateStatusCreateData.textValueToUpdate)
				 .enterNumberOrTextOrDateStatusTypesUpdateValue(statusTypeData.roleBasedDateStatusTypeValue,updateStatusCreateData.currentDateToUpdate)
				 .enterNumberOrTextOrDateStatusTypesUpdateValue(statusTypeData.roleBasedNumberStatusTypeValue,updateStatusCreateData.numberValueToUpdate)
				 .clickOnSave();
	 
		 String[] updatedValues = {updatedSaturationScore, updatedNedocsScore,
				 updatedMultiStatus,updateStatusCreateData.textValueToUpdate,
				 updateStatusCreateData.currentDateToUpdate,
				 updateStatusCreateData.numberValueToUpdate};
	 
	    viewResourceDetail.verifyUpdatedStatusTypes(statusTypeNames, updatedValues); 
	    login.logOut();

	    Result = "PASS";
	}
	
	@Test(groups = {"Smoke","Views", "Smoke186199"})
	public void Smoke186199() throws Exception {
		
		TCID = "186199";
		TC_DESCRIPTION = "Verify that user switch to all the view screens";
		
		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		updateStatus= new UpdateStatus(this.driver);
		viewsList = new View(this.driver);
		
		usersData = new UsersData();
		viewsData = new ViewData();
		usersData = new UsersData();
		resourceTypeData = new ResourceTypeData();
		resourceData = new ResourceData();
		statusTypeData = new StatusTypeData();
		updateStatusData = new UpdateStatusData();
		updateStatusCreateData = updateStatusData.new UpdateStatusCreateData();
		
		String username		= usersData.userWithViewCustomViewRight,
			resourceType_1	= resourceTypeData.resourceTypeName1_Region, resourceType_2	= resourceTypeData.resourceTypeName2_Region,
			resourceType_value1	= resourceTypeData.resourceTypeValue1_Region, resourceType_value2	= resourceTypeData.resourceTypeValue2_Region,
			
			resource1		= resourceData.sharedResourceName1_Region1, resource2	= resourceData.sharedResourceName2_Region1,
			resource3		= resourceData.sharedResourceName3_Region1, resource4	= resourceData.sharedResourceName4_Region1,
			
			resource_value1	= resourceData.sharedResourceValue1_Region1, resource_value2	= resourceData.sharedResourceValue2_Region1,
			resource_value3	= resourceData.sharedResourceValue3_Region1, resource_value4	= resourceData.sharedResourceValue4_Region1,
			
			NST1_value	= statusTypeData.sharedNumberStatusTypeValue1_Region, NST2_value	= statusTypeData.sharedNumberStatusTypeValue2_Region,
			NST1_Name	= statusTypeData.sharedNumberStatusTypeName1_Region, NST2_Name	= statusTypeData.sharedNumberStatusTypeName2_Region,
			
			MST1_value	= statusTypeData.sharedMultiStatusTypeValue1_Region, MST2_value	= statusTypeData.sharedMultiStatusTypeValue2_Region,
			MST1_Name	= statusTypeData.sharedMultiStatusTypeName1_Region, MST2_Name	= statusTypeData.sharedMultiStatusTypeName2_Region,			
			
			MST1_S1_Value	= statusTypeData.sharedMultiStatusType1_Status1Value_Region, MST1_S2_Value	= statusTypeData.sharedMultiStatusType1_Status2Value_Region,
			MST1_S3_Value	= statusTypeData.sharedMultiStatusType1_Status3Value_Region, MST2_S1_Value	= statusTypeData.sharedMultiStatusType2_Status1Value_Region,
			MST2_S2_Value	= statusTypeData.sharedMultiStatusType2_Status2Value_Region, MST2_S3_Value	= statusTypeData.sharedMultiStatusType2_Status3Value_Region,
		
			MST1_S1_Name	= statusTypeData.sharedMultiStatusType1_Status1Name_Region, MST1_S2_Name	= statusTypeData.sharedMultiStatusType1_Status2Name_Region,
			MST1_S3_Name	= statusTypeData.sharedMultiStatusType1_Status3Name_Region, MST2_S1_Name	= statusTypeData.sharedMultiStatusType2_Status1Name_Region,
			MST2_S2_Name	= statusTypeData.sharedMultiStatusType2_Status2Name_Region, MST2_S3_Name	= statusTypeData.sharedMultiStatusType2_Status3Name_Region,
			
			NST_update1	= updateStatusCreateData.numberToUpdate_dynamic, NST_update2	= updateStatusCreateData.numberToUpdate_dynamic1,
			NST_update3	= updateStatusCreateData.numberToUpdate_dynamic2, NST_update4	= updateStatusCreateData.numberToUpdate_dynamic3, 
			NST_update5	= updateStatusCreateData.numberToUpdate_dynamic4, NST_update6	= updateStatusCreateData.numberToUpdate_dynamic5,
			NST_update7	= updateStatusCreateData.numberToUpdate_dynamic6, NST_update8	= updateStatusCreateData.numberToUpdate_dynamic7;
		
		ArrayList<String> statusTypes = new ArrayList<String>();
		statusTypes.addAll(Arrays.asList(NST1_Name, NST2_Name, MST1_Name, MST2_Name));
		
		ArrayList<String> statusTypes_values = new ArrayList<String>();
		statusTypes_values.addAll(Arrays.asList(NST1_value, NST2_value, MST1_value, MST2_value));
		
		ArrayList<String> updatedValues_RS1 = new ArrayList<String>();
		ArrayList<String> updatedValues_RS2 = new ArrayList<String>();
		ArrayList<String> updatedValues_RS3 = new ArrayList<String>();
		ArrayList<String> updatedValues_RS4 = new ArrayList<String>();
		
		login.loginAsUser(username, UsersData.PASSWORD);
		navigateTo.particularView(viewsData.hybridViewName);
		viewsList.verifyResourceTypeResourceAndStatusType(resourceType_1, resource1, statusTypes)
				.verifyResourceTypeResourceAndStatusType(resourceType_1, resource2, statusTypes)
				.verifyResourceTypeResourceAndStatusType(resourceType_2, resource3, statusTypes)
				.verifyResourceTypeResourceAndStatusType(resourceType_2, resource4, statusTypes);
		
		//update the STs
		String previousUpdate_MST_1 = updateStatus.getUpdatedValueOfStatusType(resource_value1, statusTypes_values.get(2));
		String previousUpdate_MST_2 = updateStatus.getUpdatedValueOfStatusType(resource_value1, statusTypes_values.get(3));
		
		String previousUpdate_MST_3 = updateStatus.getUpdatedValueOfStatusType(resource_value2, statusTypes_values.get(2));
		String previousUpdate_MST_4 = updateStatus.getUpdatedValueOfStatusType(resource_value2, statusTypes_values.get(3));
		
		String previousUpdate_MST_5 = updateStatus.getUpdatedValueOfStatusType(resource_value3, statusTypes_values.get(2));
		String previousUpdate_MST_6 = updateStatus.getUpdatedValueOfStatusType(resource_value3, statusTypes_values.get(3));
		
		String previousUpdate_MST_7 = updateStatus.getUpdatedValueOfStatusType(resource_value4, statusTypes_values.get(2));
		String previousUpdate_MST_8 = updateStatus.getUpdatedValueOfStatusType(resource_value4, statusTypes_values.get(3));
		
		updateStatus.clickOnUpdateStatusKey(resource1)
		.clickOnSelectAll()
		.enterNumberOrTextOrDateStatusTypesUpdateValue(NST1_value, NST_update1)
		.enterNumberOrTextOrDateStatusTypesUpdateValue(NST2_value, NST_update2);
		String RS1_MST1_updatedValue = updateStatus.updateMultiStatusOtherThanPreviousUpdatedStatus(MST1_value, MST1_S1_Name, MST1_S2_Name, MST1_S3_Name, MST1_S1_Value, MST1_S2_Value, MST1_S3_Value, previousUpdate_MST_1);
		String RS1_MST2_updatedValue = updateStatus.updateMultiStatusOtherThanPreviousUpdatedStatus(MST2_value, MST2_S1_Name, MST2_S2_Name, MST2_S3_Name, MST2_S1_Value, MST2_S2_Value, MST2_S3_Value, previousUpdate_MST_2);
		updateStatus.clickOnSave();
		updatedValues_RS1.addAll(Arrays.asList(NST_update1, NST_update2, RS1_MST1_updatedValue, RS1_MST2_updatedValue));
		
		updateStatus.clickOnUpdateStatusKey(resource2)
		.clickOnSelectAll()
		.enterNumberOrTextOrDateStatusTypesUpdateValue(NST1_value, NST_update3)
		.enterNumberOrTextOrDateStatusTypesUpdateValue(NST2_value, NST_update4);
		String RS2_MST1_updatedValue = updateStatus.updateMultiStatusOtherThanPreviousUpdatedStatus(MST1_value, MST1_S1_Name, MST1_S2_Name, MST1_S3_Name, MST1_S1_Value, MST1_S2_Value, MST1_S3_Value, previousUpdate_MST_3);
		String RS2_MST2_updatedValue = updateStatus.updateMultiStatusOtherThanPreviousUpdatedStatus(MST2_value, MST2_S1_Name, MST2_S2_Name, MST2_S3_Name, MST2_S1_Value, MST2_S2_Value, MST2_S3_Value, previousUpdate_MST_4);
		updateStatus.clickOnSave();
		updatedValues_RS2.addAll(Arrays.asList(NST_update3, NST_update4, RS2_MST1_updatedValue, RS2_MST2_updatedValue));
		
		updateStatus.clickOnUpdateStatusKey(resource3)
		.clickOnSelectAll()
		.enterNumberOrTextOrDateStatusTypesUpdateValue(NST1_value, NST_update5)
		.enterNumberOrTextOrDateStatusTypesUpdateValue(NST2_value, NST_update6);
		String RS3_MST1_updatedValue = updateStatus.updateMultiStatusOtherThanPreviousUpdatedStatus(MST1_value, MST1_S1_Name, MST1_S2_Name, MST1_S3_Name, MST1_S1_Value, MST1_S2_Value, MST1_S3_Value, previousUpdate_MST_5);
		String RS3_MST2_updatedValue = updateStatus.updateMultiStatusOtherThanPreviousUpdatedStatus(MST2_value, MST2_S1_Name, MST2_S2_Name, MST2_S3_Name, MST2_S1_Value, MST2_S2_Value, MST2_S3_Value, previousUpdate_MST_6);
		updateStatus.clickOnSave();
		updatedValues_RS3.addAll(Arrays.asList(NST_update5, NST_update6, RS3_MST1_updatedValue, RS3_MST2_updatedValue));
		
		updateStatus.clickOnUpdateStatusKey(resource4)
		.clickOnSelectAll()
		.enterNumberOrTextOrDateStatusTypesUpdateValue(NST1_value, NST_update7)
		.enterNumberOrTextOrDateStatusTypesUpdateValue(NST2_value, NST_update8);
		String RS4_MST1_updatedValue = updateStatus.updateMultiStatusOtherThanPreviousUpdatedStatus(MST1_value, MST1_S1_Name, MST1_S2_Name, MST1_S3_Name, MST1_S1_Value, MST1_S2_Value, MST1_S3_Value, previousUpdate_MST_7);
		String RS4_MST2_updatedValue = updateStatus.updateMultiStatusOtherThanPreviousUpdatedStatus(MST2_value, MST2_S1_Name, MST2_S2_Name, MST2_S3_Name, MST2_S1_Value, MST2_S2_Value, MST2_S3_Value, previousUpdate_MST_8);
		updateStatus.clickOnSave();
		updatedValues_RS4.addAll(Arrays.asList(NST_update7, NST_update8, RS4_MST1_updatedValue, RS4_MST2_updatedValue));
		
		viewsList.verifyHeadersOfResourceTypeTable_InView(resourceType_value1, UpdateStatusData.COMMENT_LAST_UPDATE_BY_USER)
		.verifyHeadersOfResourceTypeTable_InView(resourceType_value2, UpdateStatusData.COMMENT_LAST_UPDATE_BY_USER)
		.verifyUpdatedStatusTypeValue(resourceType_value1, resource_value1, statusTypes_values, updatedValues_RS1)
		.verifyUpdatedStatusTypeValue(resourceType_value1, resource_value2, statusTypes_values, updatedValues_RS2)
		.verifyUpdatedStatusTypeValue(resourceType_value2, resource_value3, statusTypes_values, updatedValues_RS3)
		.verifyUpdatedStatusTypeValue(resourceType_value2, resource_value4, statusTypes_values, updatedValues_RS4);
		
		navigateTo.particularView(viewsData.SummaryViewName);
		viewsList.verifyHeadersOfResourceTypeTable_InView(resourceType_value1, UpdateStatusData.LAST_UPDATE)
		.verifyHeadersOfResourceTypeTable_InView(resourceType_value2, UpdateStatusData.LAST_UPDATE)
		.verifyResourceTypeResourceAndStatusType(resourceType_1, resource1, statusTypes)
		.verifyResourceTypeResourceAndStatusType(resourceType_1, resource2, statusTypes)
		.verifyResourceTypeResourceAndStatusType(resourceType_2, resource3, statusTypes)
		.verifyResourceTypeResourceAndStatusType(resourceType_2, resource4, statusTypes)
		.verifyUpdatedStatusTypeValue(resourceType_value1, resource_value1, statusTypes_values, updatedValues_RS1)
		.verifyUpdatedStatusTypeValue(resourceType_value1, resource_value2, statusTypes_values, updatedValues_RS2)
		.verifyUpdatedStatusTypeValue(resourceType_value2, resource_value3, statusTypes_values, updatedValues_RS3)
		.verifyUpdatedStatusTypeValue(resourceType_value2, resource_value4, statusTypes_values, updatedValues_RS4);
		
		navigateTo.particularView(viewsData.SummaryPlusViewName);
		viewsList.verifyHeadersOfResourceTypeTable_InView(resourceType_value1, UpdateStatusData.COMMENT_LAST_UPDATE)
		.verifyHeadersOfResourceTypeTable_InView(resourceType_value2, UpdateStatusData.COMMENT_LAST_UPDATE)
		.verifyResourceTypeResourceAndStatusType(resourceType_1, resource1, statusTypes)
		.verifyResourceTypeResourceAndStatusType(resourceType_1, resource2, statusTypes)
		.verifyResourceTypeResourceAndStatusType(resourceType_2, resource3, statusTypes)
		.verifyResourceTypeResourceAndStatusType(resourceType_2, resource4, statusTypes)
		.verifyUpdatedStatusTypeValue(resourceType_value1, resource_value1, statusTypes_values, updatedValues_RS1)
		.verifyUpdatedStatusTypeValue(resourceType_value1, resource_value2, statusTypes_values, updatedValues_RS2)
		.verifyUpdatedStatusTypeValue(resourceType_value2, resource_value3, statusTypes_values, updatedValues_RS3)
		.verifyUpdatedStatusTypeValue(resourceType_value2, resource_value4, statusTypes_values, updatedValues_RS4);
		
		
		navigateTo.particularView(viewsData.ResourceViewName);
		
		viewsList.verifyHeadersOfResourceTypeTable_InView(resourceType_value1, UpdateStatusData.COMMENT_LAST_UPDATE)
		.verifyHeadersOfResourceTypeTable_InView(resourceType_value2, UpdateStatusData.COMMENT_LAST_UPDATE);
		//verify updated values
		
		//navigate to map
		//select all 4 RS, verify updated values,
		//custom view >> verify updated values,
		
		Result = "PASS";
	}
}
