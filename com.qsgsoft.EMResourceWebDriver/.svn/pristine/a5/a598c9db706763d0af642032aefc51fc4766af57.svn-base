package requirementGroup.HomeButton;

import lib.dataObject.Login_data;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.SelectRegion;
import org.testng.annotations.Test;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class HappyDayHomeButton extends TestNG_UI_EXTENSIONS{

	public HappyDayHomeButton() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/***********************************************************************************************
	'Description : Verify that clicking on the 'Home' button takes the user to region default screen 
	'Date	 	 : 20-Oct-2014
	'Author		 : Anitha
	************************************************************************************************/
	
	@Test(description ="Verify that clicking on the 'Home' button takes the user to region default screen")
	public void testHappyDay147097() throws Exception {
	
		gstrTCID = "147097";
		gstrTO = "Verify that clicking on the 'Home' button takes the user to region default screen";

		Login_data login_data = new Login_data();
		
		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1);
		SelectRegion SelectRegion_page1 = new SelectRegion(this.driver1);

		login_page1.loginToApplication(login_data.strUserName, login_data.strPassword);
	    	    	
		RegionDefault_page1.selectFrame();
		
		SelectRegion_page1.selectRegionAndNavigate(login_data.strQuickLinkRegion);
	    
	    RegionDefault_page1.selectFrame();
	    
	    RegionDefault_page1.clickOnHomeButton();
	    
	    RegionDefault_page1.verifyRegionDefaultPage();
  
	    login_page1.clickLogOut();

	    gstrResult = "PASS";
	}
}
