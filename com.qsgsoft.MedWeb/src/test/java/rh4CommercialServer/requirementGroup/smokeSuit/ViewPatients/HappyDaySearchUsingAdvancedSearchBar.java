package rh4CommercialServer.requirementGroup.smokeSuit.ViewPatients;

import java.io.File;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import dataObject.DICOMSettings_data;
import dataObject.Login_data;
import dataObject.PathData;
import dataObject.ViewPatients_data;
import page.AutoIT;
import page.Destinations;
import page.Home;
import page.Login;
import page.ModifyStudy;
import page.ViewPatients;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;
import qaframework.lib.userDefinedFunctions.Date_Time_settings;
import qaframework.lib.userDefinedFunctions.PathsProperties;

public class HappyDaySearchUsingAdvancedSearchBar extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDaySearchUsingAdvancedSearchBar() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that when Modality, Type, Ref. Physician, Station, Institution name 
                     and time intervals are specified, studies matching all the filters are displayed 
                     as a result of the search.     
    'Precondition  :
    'Date          : 09-Dec-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that when Modality, Type, Ref. Physician, Station, Institution name"
			+ " and time intervals are specified, studies matching all the filters are displayed as a result "
			+ "of the search.")
	public void testHappyDay68544() throws Exception {

		gstrTCID = "68544";
		gstrTO = "Verify that when Modality, Type, Ref. Physician, Station, Institution name and time intervals "
				+ "are specified, studies matching all the filters are displayed as a result of the search.";

		Login_data objLogin_data = new Login_data();
		PathData objPathData = new PathData();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		Home objHome = new Home(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		Destinations objDestinations = new Destinations(this.driver);
		Date_Time_settings objDts = new Date_Time_settings();
		ModifyStudy objModifyStudy = new ModifyStudy(this.driver);
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
		Thread.sleep(3000);

		objViewPatients.enterTextInFind(objViewPatients_data.strStudy)
				.selInLastOption(objDICOMSettings_data.hour).clickOnSearch()
				.clickOnSearch();
		Thread.sleep(3000);
		objViewPatients.selLayout(objViewPatients_data.strLayout)
				.clickOnSearch().clickOnSearch();
		String req = objViewPatients.getStationNameOfAStudy();
		objViewPatients
				.clickOnModifyStudyFieldsOfAStudy(objViewPatients_data.strStudy);
		String mainwindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> itr = allwindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);

				String instname = objModifyStudy
						.getInstitutionNameInStudyEditorPage();
				String modality = objModifyStudy.getModalityInStudyEditorPage();
				String dob = objModifyStudy.getDOBInStudyEditorPage();
				System.out.println(dob + " first");
				String reqdob = objDts.converDateFormat(dob, "yyyyMMdd",
						"yyyy/MM/dd");
				System.out.println(reqdob + " first");
				String patientid = objModifyStudy
						.getPatientIDInStudyEditorPage();
				objModifyStudy
						.enterTextInReferringPhysicianName(
								objViewPatients_data.strRefPhy)
						.enterTextInStudyDescription(
								objViewPatients_data.strDescription)
						.enterTextInPatientSex(
								objViewPatients_data.strPatientSex)
						.enterTextInLocation(objViewPatients_data.strLocation);
				objDestinations.clickOnSaveChanges();
				objModifyStudy.clickOnClose();
				driver.switchTo().window(mainwindow);
				objViewPatients.clickOnSearch().clickOnAdvanced();
				Set<String> allwindows1 = driver.getWindowHandles();
				Iterator<String> itr1 = allwindows1.iterator();
				while (itr1.hasNext()) {
					String childwindow1 = itr1.next().toString();
					if (!childwindow1.contains(mainwindow)) {
						driver.switchTo().window(childwindow1);
						driver.manage().window().maximize();
						objViewPatients
								.clickOnFlip()
								.selReqModalityCheckbox(modality)
								.enterTextInTypeField(
										objViewPatients_data.strDescription)
								.enterTextInRefPhysicianField(
										objViewPatients_data.strRefPhy)
								.enterTextInInstitutionTextField(instname)
								.enterTextInStationField(req)
								.enterTextInNameTextField(
										objViewPatients_data.strStudy)
								.enterTextInIdTextField(patientid)
								.enterTextInBirthDateTextField(reqdob)
								.selSex(objViewPatients_data.strSex)
								.selStatus(objViewPatients_data.strStatus2)
								.clickOnSearchInAdvancedSearch()
								.verStudyInAdvancedSearch(
										objViewPatients_data.strStudy);
					}
				}
			}
		}
				
				driver.close();
				driver.switchTo().window(mainwindow);
			objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}

}
