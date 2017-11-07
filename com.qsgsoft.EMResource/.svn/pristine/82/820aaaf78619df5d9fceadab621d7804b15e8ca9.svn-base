package RequirementGroups.ViewingAndManagingEMResourceEntitiesOnTheViewInterface;

import org.testng.annotations.Test;
import qaFramework.Configurations.Configuration;
import EMR.data.LoginData;
import EMR.data.RegionData;
import EMR.data.ResourceData;
import EMR.data.StatusTypeData;
import EMR.data.UsersData;
import EMR.data.UsersData.UsersCreateData;
import EMR.data.ViewData;
import EMR.pages.Login;
import EMR.pages.RegionDefault;
import EMR.pages.Shared;
import EMR.pages.UsersList;
import EMR.pages.ViewResourceDetail;

public class EMResourceIntegrationWithWebEOC extends Configuration {

	public EMResourceIntegrationWithWebEOC() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	LoginData loginData;
	UsersData usersData;
	UsersCreateData usersDataCreation;
	ResourceData resourceData;
	StatusTypeData statusTypeData;

	Login login;
	RegionDefault regionDefault;
	Shared navigateTo;
	UsersList usersList;
	ViewResourceDetail viewResourceDetail;
	ViewData viewData;
	
	@Test(groups = {"HappyDay", "Viewing And Managing EMResource Entities On The 'View' Interface", "HappyDay131088"})
	public void HappyDay131088() throws Exception {
		
	    TCID = "131088";
	    TC_DESCRIPTION = "Verify that user will be redirected to View resource detail when clicked on the link from WebEOC application";
		
	    usersData			= new UsersData();
	    usersDataCreation	= usersData.new UsersCreateData();
	    
	    usersList = new UsersList(this.driver);
	    regionDefault = new RegionDefault(this.driver);
	    login = new Login(this.driver);
	    navigateTo = new Shared(this.driver);
	    viewResourceDetail = new ViewResourceDetail(this.driver);
	
	    String username		= usersDataCreation.name,
			   userFullName = usersDataCreation.fullName;

	    login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.COLORADO);
		navigateTo.users();
		usersList.createUserWithMandatoryDetailsWithRoleWithoutSave(username, UsersData.INITIAL_PASSWORD, userFullName, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID)
				 .selectAllViewResourceRight()
				 .clickOnSave();
		
		login.logOut()
		.loginAsNewUser(username, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
		
		navigateTo.securityQuestionUnderPreferences();
		login.answerSecurityQuestionAndClose(UsersData.SECURITY_ANSWER)
			 .logOut()
			 .loginToApplication(username, UsersData.PASSWORD)
			 .launchWebEOC_Url();
		
		viewResourceDetail.verifyViewResourceDetailsPage()
			.verifyResourceInViewResourceDetailsPage(ResourceData.LUTHERAN_MEDICAL_CENTER);

		login.selectFrame().logOut();
		
		Result = "PASS";
	}
	
	@Test(groups = {"HappyDay", "Viewing And Managing EMResource Entities On The 'View' Interface", "HappyDay131089"})
	public void HappyDay131089() throws Exception {
		
	    TCID = "131089";
	    TC_DESCRIPTION = "Verify that warning message will be displayed when an attempt is made to login to EMR providing user credentials in any other region";
		
	    usersData			= new UsersData();
	    usersDataCreation	= usersData.new UsersCreateData();
	    
	    usersList = new UsersList(this.driver);
	    regionDefault = new RegionDefault(this.driver);
	    login = new Login(this.driver);
	    navigateTo = new Shared(this.driver);
	
	    String username		= usersDataCreation.name1,
			   userFullName = usersDataCreation.fullName1;

	    login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		navigateTo.users();
		usersList.createUserWithMandatoryDetailsWithRoleWithoutSave(username, UsersData.INITIAL_PASSWORD, userFullName, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID)
				 .selectAllViewResourceRight()
				 .clickOnSave();
		
		login.logOut().loginAsNewUser(username, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);
		
		navigateTo.securityQuestionUnderPreferences();
		login.answerSecurityQuestionAndClose(UsersData.SECURITY_ANSWER)
			 .logOut()
		.loginToApplication(username, UsersData.PASSWORD)
		 .launchWebEOC_Url();
		
		navigateTo.verifyValidationMessage_UnauthorizedAccessLogged();
		login.logOut();
		
		Result = "PASS";
	}
}