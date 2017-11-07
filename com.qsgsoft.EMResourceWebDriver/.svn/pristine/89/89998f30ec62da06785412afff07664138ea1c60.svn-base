package requirementGroup.SetUp;

import lib.dataObject.Login_data;
import lib.dataObject.StatusTypes_data;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import org.testng.annotations.Test;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class EdgeCaseMultiStatusesLabel extends TestNG_UI_EXTENSIONS{

	public EdgeCaseMultiStatusesLabel() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/************************************************************************************
	 * 'Description 	:  Verify that statuses can be created by entering 25 characters.
	 * 'Precondition	: None
	 * 'Date 	        : 04-Dec-2014 
	 * 'Author 			: Anitha
	 ************************************************************************************/
	@Test(description = " Verify that statuses can be created by entering 25 characters.")
	public void testEdgeCase149939() throws Exception {
		
		gstrTCID = "149939";
		gstrTO = " Verify that statuses can be created by entering 25 characters";
	
		Login login_page = new Login(this.driver1);
		Login_data login_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		RegionDefault RegionDefault_Page1 = new RegionDefault(this.driver1);

		login_page.loginToApplication(login_data.strUserName,
				login_data.strPassword);
		
		RegionDefault_Page1.selectFrame();

		SelectRegion_page.selectRegionAndNavigate(login_data.strRegionName);

		RegionDefault_Page1.selectFrame();

		objStatusTypeList.navigateToStatusTypeList()

		.createStatusType(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription)
				
		.verifyCreateStatusPage(objStatuTypes_data.strMSTStatusTypeName)
		
		.clickOnCreateNewStatus()
		
		.verifyCreateNewStatusPage()
		
		.enterStatusName(objStatuTypes_data.strStatusNameIn25Char)
		
		.clickOnSaveButton()
		
		.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameIn25Char);

		login_page.clickLogOut();
		
		gstrResult = "PASS";
	}
	
	/************************************************************************************************
	 * 'Description 	: Verify that more than 25 characters cannot be entered to statues name field
	 * 'Precondition	: None
	 * 'Date 	        : 08-Dec-2014 
	 * 'Author 			: Anitha
	 ************************************************************************************************/
	@Test(description = "Verify that more than 25 characters cannot be entered to statues name field")
	public void testEdgeCase149940() throws Exception {
		
		gstrTCID = "149940";
		gstrTO = " Verify that more than 25 characters cannot be entered to statues name field";
	
		Login login_page = new Login(this.driver1);
		Login_data login_data = new Login_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		
		SelectRegion SelectRegion_page = new SelectRegion(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		RegionDefault RegionDefault_Page1 = new RegionDefault(this.driver1);

		login_page.loginToApplication(login_data.strUserName,
				login_data.strPassword);
		
		RegionDefault_Page1.selectFrame();

		SelectRegion_page.selectRegionAndNavigate(login_data.strRegionName);

		RegionDefault_Page1.selectFrame();

		objStatusTypeList.navigateToStatusTypeList()

		.createStatusType(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription)
				
		.verifyCreateStatusPage(objStatuTypes_data.strMSTStatusTypeName)
		
		.clickOnCreateNewStatus()
		
		.verifyCreateNewStatusPage()
		
		.enterStatusName(objStatuTypes_data.strStatusNameIn25Char)
		
		.enterStatusNameOneChar(objStatuTypes_data.strStatusName1Char)
		
		.clickOnSaveButton()
		
		.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameIn25Char);	

		login_page.clickLogOut();
		
		gstrResult = "PASS";
	}
}
