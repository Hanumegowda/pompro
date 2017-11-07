package RequirementGroups.Smoke;

import org.testng.annotations.Test;
import EMR.data.LoginData;
import EMR.data.RegionData;
import EMR.data.UserLinksData;
import EMR.data.UserLinksData.UserLinksCreateData;
import EMR.pages.Login;
import EMR.pages.RegionDefault;
import EMR.pages.SelectRegion;
import EMR.pages.Shared;
import EMR.pages.UserLinks;
import qaFramework.Configurations.Configuration;

public class SetupUserLinks extends Configuration {

	public SetupUserLinks() throws Exception {
		super();
	}

	LoginData loginData;
	
	Login login;
	RegionDefault regionDefault;
	Shared navigateTo;
	SelectRegion selectRegion;
	UserLinks userLinks;
	UserLinksData userLinkData;
	UserLinksCreateData userLinksCreateData;
	
	@Test(groups = {"Smoke", "Setup", "Smoke183492"})
	public void Smoke183492() throws Exception {
		
	    TCID = "183492";
	    TC_DESCRIPTION = "Verify that user link / quick link can be created.";
		
	    loginData = new LoginData();
	    userLinkData = new UserLinksData();
	    userLinksCreateData = userLinkData.new UserLinksCreateData();
		
	    regionDefault = new RegionDefault(this.driver);
	    login = new Login(this.driver);
	    navigateTo = new Shared(this.driver);
	    selectRegion = new SelectRegion(this.driver);
	    userLinks = new UserLinks(this.driver);
	
	    login.loginToApplication(LoginData.ADMINUSERNAME,
				LoginData.ADMINPASSWORD);
		selectRegion.selectRegionAndClickOnNext(RegionData.REGIONNAME);
		navigateTo.userLinks();
		userLinks.createUserLink(userLinksCreateData.label, UserLinksData.IMAGE_TO_UPLOAD_PATH, UserLinksData.USER_LINK_URL)
				 .verifyLinkDetailsAndClickOnShowOfLink(userLinksCreateData.label, UserLinksData.SHOWAS_HIDE, UserLinksData.FILE_SIZE, UserLinksData.IMAGE_SIZE)
				 .verifyShowAs(userLinksCreateData.label, UserLinksData.SHOWAS_USER_LINK)
				 .verifyAndClickOnCreatedUserLink(userLinksCreateData.label);
		
		String mainWindowHandle = driver.getWindowHandle();
		userLinks.switchToNewWindowAndVerifyWindowTitle(mainWindowHandle, UserLinksData.USER_LINK_TITLE);
		navigateTo.userLinks();
		userLinks.createQuickLink(userLinksCreateData.label1, UserLinksData.IMAGE_TO_UPLOAD_PATH, UserLinksData.QUICK_LINK_URL)
				 .verifyLinkDetailsAndClickOnShowOfLink(userLinksCreateData.label1, UserLinksData.SHOWAS_HIDE, UserLinksData.FILE_SIZE, UserLinksData.IMAGE_SIZE)
				 .verifyShowAs(userLinksCreateData.label1, UserLinksData.SHOWAS_QUICK_LINK)
				 .verifyAndClickOnCreatedQuickLink(userLinksCreateData.label1);

		mainWindowHandle = driver.getWindowHandle();
		userLinks.switchToNewWindowAndVerifyWindowTitle(mainWindowHandle, UserLinksData.QUICK_LINK_TITLE);

		login.logOut();

		Result = "PASS";
	}
}
