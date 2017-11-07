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
import page.PatientScheduleRegistration;
import page.Statistics;
import page.ViewPatients;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;
import qaframework.lib.userDefinedFunctions.PathsProperties;

public class HappyDayPatientReview extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayPatientReview() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that the total number of studies created in a certain time period is 
                     displayed when a custom date is selected.     
    'Precondition  :
    'Date          : 21-Apr-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the total number of studies created in a certain time period is "
			+ "displayed when a custom date is selected.")
	public void testHappyDay69332() throws Exception {

		gstrTCID = "69332";
		gstrTO = "Verify that the total number of studies created in a certain time period is displayed "
				+ "when a custom date is selected.";

		Login_data objLogin_data = new Login_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		MedwebRadiologyStatistics_data objMedwebRadiologyStatistics_data = new MedwebRadiologyStatistics_data();
		Home objHome = new Home(this.driver);
		Statistics objStatistics = new Statistics(this.driver);
		Login objLogin = new Login(this.driver);
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		PathData objPathData = new PathData();
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		AutoIT objAutoIT = new AutoIT(this.driver);
		PatientScheduleRegistration objPatientScheduleRegistration = new PatientScheduleRegistration(
				this.driver);

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
		objViewPatients.clickOnSearch1();
		objHome.clickOnStatistics();
		objStatistics
				.clickOnRadiology()
				.clickOnPatientReviewLink()
				.verDailyPatientReviewLogPage()
				.selLimitDropdownOption(
						objMedwebRadiologyStatistics_data.strLimit50);
		objPatientScheduleRegistration.selStartOrEndDateFromCalenderWindow(
				objMedwebRadiologyStatistics_data.strStartDate)
				.selStartOrEndDateFromCalenderWindow(
						objMedwebRadiologyStatistics_data.strEndDate);
		objStatistics.clickOnSearch().verTotalCount();
		objStatistics.enterTextInFindField(objViewPatients_data.strStudy)
				.clickOnSearch()
				.verStudyIsPresent(objViewPatients_data.strStudy);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}

}
