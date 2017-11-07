package RequirementGroups.MultiRegion;

import java.util.ArrayList;
import java.util.Arrays;
import org.testng.annotations.Test;
import qaFramework.Configurations.Configuration;
import EMR.data.LoginData;
import EMR.data.RegionData;
import EMR.data.ResourceData;
import EMR.data.ResourceData.ResourceCreateData;
import EMR.data.ResourceTypeData;
import EMR.data.StatusTypeData;
import EMR.data.UsersData;
import EMR.data.UsersData.UsersCreateData;
import EMR.pages.Login;
import EMR.pages.Shared;
import EMR.pages.UsersList;
import EMR.pages.View;
import EMR.pages.ViewResourceDetail;

public class RegionsWithMutualAgreementAndOtherRegionViewRight extends Configuration {

	public RegionsWithMutualAgreementAndOtherRegionViewRight() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	LoginData loginData;
	ResourceTypeData resourceTypeData;
	StatusTypeData statusTypeData;
	ResourceCreateData resourceDataCreation;
	UsersData usersData;
	UsersCreateData usersDataCreation;
	ResourceData resourceData;

	Login login;
	UsersList usersList;
	Shared navigateTo;
	View viewsList;
	ViewResourceDetail viewResourceDetail;

	@Test(groups = {"HappyDay","Multi Region", "HappyDay71246"})
	public void HappyDay71246() throws Exception {

		TCID ="71246";
		TC_DESCRIPTION ="Verify that the resource of RG1 cannot be edited from RG2 when RG1 and RG2 "
				+ "have other region agreement.";

		usersData = new UsersData();
		usersDataCreation = usersData.new UsersCreateData();
		statusTypeData = new StatusTypeData();
		resourceData = new ResourceData();

		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		viewsList = new View(this.driver);
		usersList = new UsersList(this.driver);
		viewResourceDetail = new ViewResourceDetail(this.driver);

		ArrayList<String> statustypeValues_RG1 = new ArrayList<String>();
		statustypeValues_RG1.addAll(Arrays.asList(statusTypeData.sharedNSTValue_InMutualAgreemnet_RG1,
				statusTypeData.sharedDateValue_InMutualAgreemnet_RG1, statusTypeData.sharedNedocValue_InMutualAgreemnet_RG1,
				statusTypeData.sharedMSTValue_InMutualAgreemnet_RG1,statusTypeData.sharedTSTValue_InMutualAgreemnet_RG1,
				statusTypeData.sharedSSTValue_InMutualAgreemnet_RG1));

		ArrayList<String> resourceValue = new ArrayList<String>(Arrays.asList(resourceData.sharedResourceVALUE1_MutualAgreement_RG1));

		String resourceName = resourceData.sharedResourceNAME1_MutualAgreement_RG1,
			   username		= usersDataCreation.name,
			   userFullName = usersDataCreation.fullName;

		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGION_WITH_MUTUAL_AGREEMENT2);

		navigateTo.users();
		usersList.createUserWithMandatoryDetailsWithRoleWithoutSave(username, UsersData.INITIAL_PASSWORD, userFullName, UsersData.PRIMARY_EMAILID, UsersData.PRIMARY_EMAILID)
				 .provideSetupResourcesAddAndEditRight()
				 .provideViewCustomViewRight()
				 .clickOnSave();

		login.logOut()
		.loginAsNewUser(username, UsersData.INITIAL_PASSWORD, UsersData.PASSWORD);

		viewsList.createCustomizedViewFromPreferences(resourceName, resourceValue, statustypeValues_RG1)
				 .navigateToResourceDetail(resourceName);
		viewResourceDetail.verifyEditResourceDetailsLinkNotPresent(resourceName);
		login.logOut();
		Result = "PASS";
	}
}