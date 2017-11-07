package RequirementGroups.CreatingAndManagingUsers;

import org.testng.annotations.Test;
import EMR.data.UsersData;
import EMR.pages.Login;
import EMR.pages.UsersList;
import qaFramework.Configurations.Configuration;

public class WebServiceUser extends Configuration {
	
	Login login;
	UsersData usersData;
	UsersList usersList;
	public WebServiceUser() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Test (groups = {"HappyDay", "Creating And Managing Users", "HappyDay179184"})
	public void HappyDay179184() throws Exception {

		TCID = "179184";
		TC_DESCRIPTION = "Verify that web service user cannot login to EMResource.";
		
//		Check logging in via normal login
//		Verify Web Service Account Error message
		
		login =new Login(this.driver);
		usersList =new UsersList(this.driver);
		usersData =new UsersData();
		
		login.loginToApplication(usersData.interfaceRelatedWebSerivceUser,UsersData.INITIAL_PASSWORD);
		usersList.VerifyWebServiceAccountErrorMessage();
		
		Result = "PASS";
}
		
}