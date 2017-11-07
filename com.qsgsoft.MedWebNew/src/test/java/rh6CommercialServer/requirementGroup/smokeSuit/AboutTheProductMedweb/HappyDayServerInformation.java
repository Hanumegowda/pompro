package rh6CommercialServer.requirementGroup.smokeSuit.AboutTheProductMedweb;

import dataObject.Login_data;
import page.Home;
import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;

public class HappyDayServerInformation extends TestNG_UI_EXTENSIONSForOneBrowser{
	public  HappyDayServerInformation() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that the brief Server Information is displayed under "Server Information"
                     section without any Spelling mistake and giving appropriate information (Please see
                     the attached note).     
    'Precondition  :
    'Date          : 16-Sep-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the brief Server Information is displayed under Server Information section "
			+ "without any Spelling mistake and giving appropriate information (Please see the attached note).")
	public void testHappyDay128699() throws Exception {

		gstrTCID = "128699";
		gstrTO = "Verify that the brief Server Information is displayed under Server Information section without "
				+ "any Spelling mistake and giving appropriate information (Please see the attached note).";

		Login_data objLogin_data = new Login_data();
		Home objHome = new Home(this.driver);
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnMedwebLogo().verServerInformationPage() 
		.verServerInformationMessage(objLogin_data.serverInformation)
		.verServerInformationMessage(objLogin_data.serverInformation1)
		.verServerInformationMessage(objLogin_data.serverInformation2);
		
		gstrResult = "PASS";


}
}
