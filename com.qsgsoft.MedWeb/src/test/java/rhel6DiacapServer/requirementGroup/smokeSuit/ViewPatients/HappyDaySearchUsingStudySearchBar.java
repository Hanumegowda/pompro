package rhel6DiacapServer.requirementGroup.smokeSuit.ViewPatients;

import java.io.File;
import java.util.Properties;

import dataObject.DICOMSettings_data;
import dataObject.Login_data;
import dataObject.PathData;
import dataObject.ViewPatients_data;
import page.AutoIT;
import page.Home;
import page.Login;
import page.ViewPatients;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;
import qaframework.lib.userDefinedFunctions.PathsProperties;


public class HappyDaySearchUsingStudySearchBar extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDaySearchUsingStudySearchBar() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that when search parameter is a keyword and any status, any modality
                     and any time interval, studies matching the keyword are retrieved.     
    'Precondition  :
    'Date          : 22-Sep-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that when search parameter is a keyword and any status, any modality"
			+ " and any time interval, studies matching the keyword are retrieved.")
	public void testHappyDay68536() throws Exception {

		gstrTCID = "68536";
		gstrTO = "Verify that when search parameter is a keyword and any status, any modality and any"
				+ " time interval, studies matching the keyword are retrieved.";

		Login_data objLogin_data = new Login_data();
		PathData objPathData = new PathData();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		Home objHome = new Home(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		Login objLogin = new Login(this.driver);
		AutoIT objAutoIT = new AutoIT(this.driver);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();

		String fileAutoITDownloadPath = pathProps
				.getProperty(objPathData.autoItFilePath2);
		System.out.println(fileAutoITDownloadPath);

		File autoitfile = new File(System.getProperty("user.dir")
				+ fileAutoITDownloadPath);
		String strAutoitPath = autoitfile.toString();
		System.out.println(strAutoitPath + 1);

		// image
		String imagePath = pathProps.getProperty(objPathData.sudyWithImage);
		System.out.println(imagePath);

		File imageFile = new File(System.getProperty("user.dir") + imagePath);
		String strImagePath = imageFile.toString();

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnViewPatients();

		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		Thread.sleep(3000);
		objViewPatients.clickOnNewStudy();
		
		Thread.sleep(5000);
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy,
				objViewPatients_data.strStudy, strImagePath,
				objViewPatients_data.strModalityDS);
		Thread.sleep(5000);
		objViewPatients.enterTextInFind(objViewPatients_data.strStudy)
				.selInLastOption(objDICOMSettings_data.hour)
				.selStatusOption(objViewPatients_data.strStatus2)
				.selWhereOption(objViewPatients_data.strWhereOption)
				.selModalityOption(objViewPatients_data.strModalityDS)
				.clickOnSearch1()
				.verStudyFromOtherServer(objViewPatients_data.strStudy);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}

}
