package RequirementGroups.Smoke;

import org.testng.annotations.Test;
import qaFramework.Configurations.Configuration_Mails;
import EMTrack.pages.DashBoard;
import EMTrack.pages.EMTrackLogin;
import EMTrack.pages.PageNavigation;
import EMTrack.pages.Patient;
import EMTrack.data.EMTrackData;
import EMTrack.data.DashBoardData;
import EMTrack.data.EMTrackLoginData;
import EMTrack.data.EMTrackData.EMTrackCreateData;
import EMR.pages.Login;
import EMR.pages.Mails;
import EMR.pages.RegionDefault;
import EMR.data.LoginData;
import EMR.data.RegionData;
import EMR.data.UsersData;

public class IntegrationWithEMTrack extends Configuration_Mails {

	LoginData loginData;
	UsersData usersData;
	EMTrackCreateData createPatientData;
	DashBoardData dashBoardData;
	EMTrackData patientData;

	Login loginToEMR;
	RegionDefault regionDefault;
	Mails mails;

	EMTrackLogin login;
	Patient patient;
	DashBoard dashBoard;
	PageNavigation navigateTo;

	static String estimattedArrivalTime="";
	String arrivalTime="";

	public IntegrationWithEMTrack() throws Exception {
		super();
	}

	@Test(groups = { "Smoke", "Integration with other products", "Smoke186230" })
	public void Smoke186230() throws Exception {

		TCID = "186230";
		TC_DESCRIPTION = "Verify that user with appropriate right receives incoming patient notification when patient is added in EMTrack.";

		login = new EMTrackLogin(this.driver);
		navigateTo = new PageNavigation(this.driver);
		patient= new Patient(this.driver);
		dashBoard= new DashBoard(this.driver);
		loginToEMR = new Login(this.driver);
		regionDefault = new RegionDefault(this.driver);
		mails= new Mails(this.driver1);

		usersData = new UsersData();
		dashBoardData=new DashBoardData();
		patientData= new EMTrackData();
		createPatientData = patientData.new EMTrackCreateData();

		login.loginToEMTrack(EMTrackLoginData.EMTRACKADMINUSER, EMTrackLoginData.EMTRACKPASSWORD);
		dashBoard.selectLocation(DashBoardData.SETRAC_REGION);
		navigateTo.patients();

		patient.addPatient_UsingForm(EMTrackData.FORM_NAME, createPatientData.patientId,
				EMTrackData.GENDERMALE, createPatientData.age, 
				EMTrackData.BAYSHORE_MEDICAL_HOSPITAL, EMTrackData.DISASTER_EMS_UNIT_PROVIDER, 
				EMTrackData.PROVIDERUNIT, EMTrackData.ETA);
		login.logOut();
		
		loginToEMR.loginAsUser(
				usersData.setracIPNUser, UsersData.PASSWORD);
		regionDefault.verifyRegionName(RegionData.SETRACREGION);
		arrivalTime = regionDefault
				.verifyIPNWebNotifaicationContentAndAcknowledge(
						EMTrackData.BAYSHORE_MEDICAL_HOSPITAL,
						EMTrackLoginData.EMTRACKADMINUSER,
						createPatientData.age, EMTrackData.CHIEFCOMPLAINT,
						EMTrackData.UNSPECIFIED, EMTrackData.GENDERMALE,
						RegionData.SETRACREGION, EMTrackData.UNSPECIFIED,
						EMTrackData.DISASTER_EMS_UNIT_PROVIDER, EMTrackData.PROVIDERUNIT);
		loginToEMR.logOut();

		mails.loginToMail(UsersData.PRIMARY_EMAILID, UsersData.EMAILPASSWORD);
		mails.verifyMailAndPagerNotificationsForPatientAddedInEMTrack(
				EMTrackLoginData.EMTRACKADMINUSER, RegionData.SETRACREGION,
				arrivalTime, EMTrackData.GENDERMALE,
				createPatientData.age, EMTrackData.CHIEFCOMPLAINT,
				EMTrackData.UNSPECIFIED, EMTrackData.UNSPECIFIED,
				EMTrackData.DISASTER_EMS_UNIT_PROVIDER, EMTrackData.PROVIDERUNIT,
				UsersData.PRIMARY_EMAILID,EMTrackData.BAYSHORE_MEDICAL_HOSPITAL)
				.logoutMail();
		Result = "PASS";
	}
}



