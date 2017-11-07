package RequirementGroups.Smoke;
import org.testng.annotations.Test;
import qaFramework.Configurations.Configuration_Mails;
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
import EMR.pages.Mails;
import EMR.pages.RegionDefault;
import EMR.pages.SelectRegion;
import EMR.pages.Shared;
import EMR.pages.UpdateStatus;
import EMR.pages.UsersList;
import EMR.pages.ViewsUnderSetup;
import EMR.pages.ViewResourceDetail;
import EMR.pages.View;
import eICS.data.ContactsData;
import eICS.data.ContactsData.ContactsCreateData;

public class StatusChangeNotification extends Configuration_Mails {

	public StatusChangeNotification() throws Exception {
		super();
		// TODO Auto-generated constructor stub
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
	ViewData viewData;

	Login login;
	RegionDefault regionDefault;
	Shared navigateTo;
	SelectRegion selectRegion;
	UsersList usersList;
	ViewsUnderSetup views;
	View viewsList;
	UpdateStatus updateStatus;
	ViewResourceDetail viewResourceDetail;
	Mails mail;
	
	
	@Test(groups = {"Smoke","Notifications", "Smoke187227"})
	public void Smoke187227() throws Exception {
		
		TCID = "187227";
		TC_DESCRIPTION ="Verify that user with appropriate right receives status change notifications";

		login= new Login(this.driver);
		updateStatus= new UpdateStatus(this.driver);
		regionDefault= new RegionDefault(this.driver);
		loginData = new LoginData();
		viewResourceDetail= new ViewResourceDetail(this.driver);
		mail=new Mails(this.driver1);
		
		resourceData = new ResourceData();
		usersData=new UsersData();
		statusTypeData= new StatusTypeData();
		resourceTypeData= new ResourceTypeData();
		updateStatusData = new UpdateStatusData();
		updateStatusCreateData=updateStatusData.new UpdateStatusCreateData();
		viewData= new ViewData();
		
		String updatedDateWithTime;
		String updatedSaturationScore="";
		String updatedNedocsScore="";
		String updatedMultiStatus="";
		String updatedCurrentNedocsScoreWithoutDisasterText;
		String updatedPrevousNedocsScoreWithoutDisasterText;
		
		String[] statusTypeNames ={statusTypeData.roleBasedSaturationStatusType,
				statusTypeData.roleBasedNedocsStatusType,
				statusTypeData.roleBasedMultiStatusType,
				statusTypeData.roleBasedTextStatusType,
				statusTypeData.roleBasedDateStatusType ,
				statusTypeData.roleBasedNumberStatusType};
		
		login.loginAsUserAndAcknowledgeWebNotification(
				usersData.preferanceUser, UsersData.PASSWORD);
		regionDefault.verifyResourceAndCorrespondingStatusTypes(
				resourceTypeData.preferanceResourceType,
				resourceData.preferenceResourceName, statusTypeNames);

		  String previousUpdatedNumberValue=updateStatus.getUpdatedValueOfNumberStatusType(resourceData.preferenceResourceName);
		  String previousUpdatedText= updateStatus.getUpdatedValueOfTextStatusType(resourceData.preferenceResourceName);
		  String previousUpdatedDate= updateStatus.getUpdatedValueOfDateStatusType(resourceData.preferenceResourceName);
		  String previousUpdatedSaturationScore=updateStatus.getUpdatedValueOfSaturationStatusType(resourceData.preferenceResourceName);
		  String previousUpdatedNedocsScore= updateStatus.getUpdatedValueOfNedocsStatusType(resourceData.preferenceResourceName);
		  String previousUpdatedMultiStatus= updateStatus.getUpdatedValueOfMultiStatusType(resourceData.preferenceResourceName);
		  
		regionDefault.clickOnUpdateStatusKeyAndNavigateToUpdateStatusPage(resourceData.preferenceResourceName);
		updateStatus.verifyUpdateStatusPage().clickOnSelectAll();
	  	         
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
				     .enterNumberOrTextOrDateStatusTypesUpdateValue(statusTypeData.roleBasedNumberStatusTypeValue,updateStatusCreateData.numberValueToUpdate1);
	     
	     String dateUpdated = updateStatus.enterDateStatusTypesUpdateValue(statusTypeData.roleBasedDateStatusTypeValue,updateStatusCreateData.currentDateToUpdate);
	     updateStatus.clickOnSave();
	     
	     String currentUpdatedNumberValue=updateStatus.getUpdatedValueOfNumberStatusType(resourceData.preferenceResourceName);
	     updatedPrevousNedocsScoreWithoutDisasterText=updateStatus.getUpdatedNedocsValueWithoutDisasterText(previousUpdatedNedocsScore);
		 updatedCurrentNedocsScoreWithoutDisasterText = updateStatus. getUpdatedNedocsValueWithoutDisasterText(updatedNedocsScore);
	     updatedDateWithTime=updateStatus.getStatusUpdatedDateAndTimeWithoutTimeZone();
	     
		String[] previousUpdatedValues = {previousUpdatedSaturationScore,
				updatedPrevousNedocsScoreWithoutDisasterText, previousUpdatedMultiStatus,
				previousUpdatedText, previousUpdatedDate,
				previousUpdatedNumberValue };
	     
	     String[] currentUpdatedValues = {updatedSaturationScore,updatedCurrentNedocsScoreWithoutDisasterText,
				 updatedMultiStatus,updateStatusCreateData.textValueToUpdate,
				 dateUpdated, currentUpdatedNumberValue};

		updateStatus.verifyUpdateStatusWebNotificationAndAcknolewdge(
				resourceData.preferenceResourceName, statusTypeNames,
				previousUpdatedValues, currentUpdatedValues,
				updatedDateWithTime);
	     
		mail.loginToMail(UsersData.PRIMARY_EMAILID, UsersData.EMAILPASSWORD);
		mail.verifyMailAndPagerNotificationsForStatusChangeNotifications(
				resourceData.preferenceResource1Abbrevation,usersData.preferanceUserFullName, updatedDateWithTime,
				resourceData.preferenceResourceName, statusTypeNames,
				previousUpdatedValues, currentUpdatedValues,
				RegionData.REGIONNAME, resourceTypeData.preferanceResourceType)
				.logoutMail();
	    login.logOut();
	    Result = "PASS";
	}
}



