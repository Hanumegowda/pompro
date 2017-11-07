package requirementGroup.CreatingAndManagingEvents;

import lib.dataObject.Login_data;
import lib.dataObject.User_data;
import lib.page.EventManagement;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.SelectRegion;
import lib.page.UsersList;
import org.testng.annotations.Test;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class EdgeCaseUsers extends TestNG_UI_EXTENSIONS {

	/**
	 * Test script to test login
	 * @throws Exception
	 */
	
	
	
	public EdgeCaseUsers() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/***************************************************************************************
	'Description	:Verify that appropriate validation message is displayed when attempted 
	                 to create a user selecting only 'Maintain Ad Hoc Events' right.
	'Date	 		:17-June-2014
	'Author			:Sowmya
	***************************************************************************************/
	@Test (description = "Verify that appropriate validation message is displayed when "
			+ "an attempt is made to create an Ad Hoc event without providing mandatory data.")
	public void testEdgeCase139804() throws Exception {

		Login login_page = new Login(this.driver1);	
		Login_data login_data = new Login_data();
		User_data objUser_data = new User_data();
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		UsersList UsersList_page = new UsersList(this.driver1);
		EventManagement EventManagement_page=new EventManagement(this.driver1);
		RegionDefault RegionDefault_page = new RegionDefault(this.driver1);		

	    login_page.loginToApplication(login_data.strUserName, login_data.strPassword);
	    
	    RegionDefault_page.selectFrame()
	                      .clickRegionLink();
	    	    
	    SelectRegion_page.selectRegionAndNavigate(login_data.strRegionName);
	       
	    RegionDefault_page.selectFrame();
	    
	    UsersList_page.navigateToUsers()
	    	          .clickCreateNewUserButton()
	                  .enterUserDetails(objUser_data.strNewUserName, objUser_data.strNewPassword, objUser_data.strFullName)
	                  . clickAdvancedOptionAndExpand()
	                  .selectMaintainAdHocEventsOption()
	                  .clickSaveButton();
	    
	    EventManagement_page.verifyErrorMessageTitle()
	                        .verifyErrorMsgForMaintainAdHocEvents();
	    
	    UsersList_page.enterPassword(objUser_data.strNewPassword)
	                  .enterConfirmPassword(objUser_data.strNewPassword)
	                  . clickAdvancedOptionAndExpand()
	                  .selectMaintainEventsOption()
	                  .clickSaveButton()
	                  .searchUserName(objUser_data.strNewUserName, objUser_data.strRole, objUser_data.strResourceType, 
	                		  objUser_data.strUsername, objUser_data.strEquals);    
	}

	/**
	 * Test script to test login
	 * @throws Exception
	 */
	
	
}