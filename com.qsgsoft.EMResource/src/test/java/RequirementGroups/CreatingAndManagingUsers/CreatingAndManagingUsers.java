package RequirementGroups.CreatingAndManagingUsers;

import org.testng.annotations.Test;

import qaFramework.Configurations.Configuration;
import EMR.data.LoginData;
import EMR.data.RegionData;
import EMR.data.SharedData;
import EMR.data.UsersData;
import EMR.data.UsersData.UsersCreateData;
import EMR.pages.Login;
import EMR.pages.RegionDefault;
import EMR.pages.SelectRegion;
import EMR.pages.Shared;

public class CreatingAndManagingUsers extends Configuration {

	public CreatingAndManagingUsers() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	LoginData loginData;
	UsersData usersData;
	UsersCreateData usersDataCreation;
	
	Login login;
	SelectRegion selectRegion;	
	RegionDefault regionDefault;
	Shared navigationTo;
	
	@Test(groups = {"HappyDay", "Creating And Managing Users", "HappyDay169342" })
	public void HappyDay169342() throws Exception {

		TCID = "169342";
	    TC_DESCRIPTION = "Verify that 'SystemAdmin' cannot Create/Edit/End any events.";

	    login = new Login(this.driver);
	    selectRegion = new SelectRegion(this.driver);
	    navigationTo = new Shared(this.driver);
	    regionDefault = new RegionDefault(this.driver);
	    
	    usersData = new UsersData();
	    
		login.loginAsAdmin(LoginData.ADMINUSERNAME, LoginData.ADMINPASSWORD, RegionData.REGIONNAME);
		regionDefault.verifyRegionDefaultPage();
		navigationTo.verifySubMenu_NotPresent(SharedData.EVENT_MANAGEMENT_UNDER_EVENTS);

		login.logOut();
		
		Result = "PASS";
	}
}
