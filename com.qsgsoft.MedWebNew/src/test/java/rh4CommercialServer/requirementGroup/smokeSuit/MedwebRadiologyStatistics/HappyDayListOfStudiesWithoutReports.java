package rh4CommercialServer.requirementGroup.smokeSuit.MedwebRadiologyStatistics;

import java.io.File;
import java.util.Properties;

import dataObject.DICOMSettings_data;
import dataObject.Login_data;
import dataObject.MedwebRadiologyStatistics_data;
import dataObject.PathData;
import dataObject.ViewPatients_data;
import page.AutoIT;
import page.Home;
import page.Login;
import page.Statistics;
import page.ViewPatients;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;
import qaframework.lib.userDefinedFunctions.PathsProperties;

public class HappyDayListOfStudiesWithoutReports extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayListOfStudiesWithoutReports() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that list of studies thats not having reports created in the current
                     day is displayed when "Today" is selected in the "Time Period of arrival studies"
                     dropdown.     
    'Precondition  :
    'Date          : 16-Oct-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that list of studies thats not having reports created in the current day "
			+ "is displayed when Today is selected in the Time Period of arrival studies dropdown.")
	public void testHappyDay71062() throws Exception {

		gstrTCID = "71062";
		gstrTO = "Verify that list of studies thats not having reports created in the current day is "
				+ "displayed when Today is selected in the Time Period of arrival studies dropdownd.";

		Login_data objLogin_data = new Login_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		PathData objPathData = new PathData();
		MedwebRadiologyStatistics_data objMedwebRadiologyStatistics_data = new MedwebRadiologyStatistics_data();
		Home objHome = new Home(this.driver);
		Statistics objStatistics = new Statistics(this.driver);
		Login objLogin = new Login(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
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
		objHome.verHomePage();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();

		objViewPatients.clickOnNewStudy();
		Thread.sleep(5000);
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy,
				objViewPatients_data.strStudy, strImagePath,
				objViewPatients_data.strModalityDS);
		Thread.sleep(3000);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch().clickOnSearch();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnStatistics();
		objStatistics.clickOnRadiology().clickOnListOfStudiesWithoutReports()
				.selTimePeriod(objMedwebRadiologyStatistics_data.strTimePeriod)
				.enterTextInFindField(objViewPatients_data.strStudy)
				.clickOnSearch()
				.verStudyIsPresent(objViewPatients_data.strStudy);

		gstrResult = "PASS";

	}

}
