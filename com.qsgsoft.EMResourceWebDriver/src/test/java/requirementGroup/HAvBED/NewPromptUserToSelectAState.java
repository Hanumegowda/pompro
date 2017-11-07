package requirementGroup.HAvBED;

import lib.dataObject.Login_data;
import lib.module.NavigationToSubMenus;
import lib.page.HaveBed;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.SelectRegion;
import org.testng.annotations.Test;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewPromptUserToSelectAState extends TestNG_UI_EXTENSIONS{

	public NewPromptUserToSelectAState() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/***********************************************************************************************
	'Description : Verify that, when a region belongs to more than one state, then the system will
	               prompt the user as to select a state to which they are setting a schedule for.
	'Date	 	 : 20-Oct-2014
	'Author		 : Anil
	************************************************************************************************/
	
	@Test(description ="Verify that, when a region belongs to more than one state, then the system"
			+ " will prompt the user as to select a state to which they are setting a schedule for.")
	public void testHappyDay71262() throws Exception {
	
		gstrTCID = "71262";
		gstrTO = "Verify that, when a region belongs to more than one state, then the system will prompt"
				+ " the user as to select a state to which they are setting a schedule for.";

		Login_data login_data = new Login_data();		
		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);
		HaveBed HaveBed_page1=new HaveBed(this.driver1);
		NavigationToSubMenus NavigationToSubMenus_page1=new NavigationToSubMenus(this.driver1);

		login_page1.loginToApplication(login_data.strUserName, login_data.strPassword);
	    	    	
		RegionDefault_page1.selectFrame();
		
		SelectRegion_page1.selectRegionAndNavigate(login_data.strStateOfMissouri);
	    
	    RegionDefault_page1.selectFrame();
	    
	    NavigationToSubMenus_page1.navigateToHaveBedInSetup();
	    
		HaveBed_page1.verSelectBedReportingStatePage()
				.selectState(login_data.strRegionkansas)
				.clickNextButton()
				.verHavBedReportingSchedulePage();
  
	    login_page1.clickLogOut();

	    gstrResult = "PASS";
	}
}
