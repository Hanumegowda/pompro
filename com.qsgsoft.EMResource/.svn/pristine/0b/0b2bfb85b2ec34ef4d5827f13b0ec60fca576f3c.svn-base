package RequirementGroups.Smoke;

import org.testng.annotations.Test;
import eICS.data.IRGData;
import eICS.data.IncidentData;
import eICS.data.IncidentData.IncidentCreateData;
import eICS.pages.CreateIncident;
import eICS.pages.EicsLogin;
import eICS.pages.NavigateToEics;
import EMR.data.LoginData;
import EMR.data.ResourceData;
import EMR.data.UsersData;
import EMR.pages.Login;
import EMR.pages.Map;
import EMR.pages.Shared;
import EMR.pages.ViewResourceDetail;
import qaFramework.Configurations.Configuration;

public class IntegrationWithEics extends Configuration {

	public IntegrationWithEics() throws Exception {
		super();
	}

	UsersData usersData;
	IncidentData incidentData;
	IncidentCreateData incidentDataCreation;

	Login login;
	Shared navigateTo;
	EicsLogin eicsLogin;
	NavigateToEics navigateToEics;
	CreateIncident createIncident;
	Map map;
	ViewResourceDetail viewResourceDetail;


	@Test(groups = { "Smoke", "Integration with other products", "Smoke186548" })
	public void Smoke186548() throws Exception {
		
		TCID = "186548";
		TC_DESCRIPTION = "Verify that facility status details displayed in EMResource when indecent is created in eICS";
		
		incidentData = new IncidentData();
		incidentDataCreation = incidentData.new IncidentCreateData();
		usersData = new UsersData();
		
		eicsLogin = new EicsLogin(this.driver);
		navigateToEics = new NavigateToEics(this.driver);
		login = new Login(this.driver);
		navigateTo = new Shared(this.driver);
		createIncident = new CreateIncident(this.driver);
		viewResourceDetail = new ViewResourceDetail(this.driver);
		map = new Map(this.driver);

		eicsLogin.LoginToEics(LoginData.QSGTESTER_ADMIN, LoginData.ADMINPASSWORD);
		eicsLogin.verifyHomePage();
		navigateToEics.createIncident();
		createIncident.createIncident(ResourceData.SETRAC_RESOURCE_FREEMAN_WEST, IRGData.IRG_NAME, incidentDataCreation.name, incidentDataCreation.description);
		navigateToEics.logoutFromIncidentScreen();
		
		login.loginAsUser(usersData.userWithUpdateRightOnFreemanWest, UsersData.PASSWORD);
		navigateTo.map();
		map.openViewResourceDetailPage(ResourceData.SETRAC_RESOURCE_FREEMAN_WEST);
		viewResourceDetail.verifyIncidentDetailsInICSSection(incidentDataCreation.name, incidentDataCreation.description);
		login.logOut();

		Result = "PASS";
	}
}
