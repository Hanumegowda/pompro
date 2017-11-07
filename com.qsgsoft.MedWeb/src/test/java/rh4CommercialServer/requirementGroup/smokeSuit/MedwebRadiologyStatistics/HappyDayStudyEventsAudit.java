package rh4CommercialServer.requirementGroup.smokeSuit.MedwebRadiologyStatistics;

import java.io.File;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

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

public class HappyDayStudyEventsAudit extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayStudyEventsAudit() throws Exception{
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that the studies read & unread (signed & unsigned) is displayed when 
                     'Both' is selected in the 'Status'dropdown.     
    'Precondition  :
    'Date          : 19-Apr-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the studies read & unread (signed & unsigned) is displayed when "
			+ "'Both' is selected in the 'Status'dropdown.")
	public void testHappyDay69330() throws Exception {

		gstrTCID = "69330";
		gstrTO = "Verify that the studies read & unread (signed & unsigned) is displayed when 'Both'"
				+ "is selected in the 'Status'dropdown.";

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
		String str = objViewPatients
				.getIdOfParticularStudy(objViewPatients_data.strStudy);
		System.out.println(str + " id of first study");

		objViewPatients
				.clickOnViewModifyWebReportsOfAStudy(objViewPatients_data.strStudy);

		String mainwindowhandle = driver.getWindowHandle();
		String childwindow;
		System.out.println(mainwindowhandle);
		Set<String> windowhandles = driver.getWindowHandles();
		Iterator<String> ite = windowhandles.iterator();
		while (ite.hasNext()) {
			childwindow = ite.next().toString();
			if (!childwindow.contains(mainwindowhandle)) {
				driver.switchTo().window(childwindow);
			}
		}

		objViewPatients.verWebReporterPage("Web-Reporter").clickOnAddButton();
		String mainwindowHandle1 = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> ite1 = allwindows.iterator();
		while (ite1.hasNext()) {
			String childwindow1 = ite1.next().toString();
			if ((!childwindow1.contains(mainwindowHandle1))
					&& (!childwindow1.contains(mainwindowhandle))) {
				driver.switchTo().window(childwindow1);
				objViewPatients.clickOnSaveSignReport();
				Thread.sleep(5000);
				objViewPatients.clickOnSignReport();
				driver.switchTo().window(mainwindowHandle1);
				driver.navigate().refresh();
				objViewPatients.verSignedByWebReport();

			}
		}
		driver.close();
		driver.switchTo().window(mainwindowhandle);
		objViewPatients.clickOnSearch().clickOnSearch();

		objViewPatients.clickOnNewStudy();
		Thread.sleep(5000);
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy1,
				objViewPatients_data.strStudy1, strImagePath,
				objViewPatients_data.strModalityDS);
		Thread.sleep(3000);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy1);
		objViewPatients.clickOnSearch1();

		objViewPatients
				.clickOnViewModifyWebReportsOfAStudy(objViewPatients_data.strStudy1);

		Set<String> aw = driver.getWindowHandles();
		Iterator<String> itr = aw.iterator();
		while (itr.hasNext()) {
			String childwindow2 = itr.next().toString();
			if (!childwindow2.contains(mainwindowhandle)) {
				driver.switchTo().window(childwindow2);
				objViewPatients.verWebReporterPage("Web-Reporter")
						.clickOnAddButton();
				Set<String> aw1 = driver.getWindowHandles();
				Iterator<String> itr1 = aw1.iterator();
				while (itr1.hasNext()) {
					String cw = itr1.next().toString();
					if ((!cw.contains(mainwindowhandle))
							&& (!cw.contains(childwindow2))) {
						driver.switchTo().window(cw);
						driver.manage().window().maximize();
						objViewPatients.clickOnSaveReport();
					}
				}
				driver.switchTo().window(childwindow2);
				driver.close();
			}
		}
		driver.switchTo().window(mainwindowhandle);

		objViewPatients.clickOnSearch().deSelMarkStudyAsReadCheckbox(
				objViewPatients_data.strStudy1);
		String str1 = objViewPatients
				.getIdOfParticularStudy(objViewPatients_data.strStudy1);
		System.out.println(str1 + " id of second study");
		objHome.clickOnStatistics();
		objStatistics
				.clickOnRadiology()
				.clickOnStudyEventsAuditLink()
				.selStatusDropdownOption(
						objMedwebRadiologyStatistics_data.strStatusRead)
				.selTimePeriod(objMedwebRadiologyStatistics_data.strTimePeriod)
				.selLimitDropdownOption(
						objMedwebRadiologyStatistics_data.strLimit50)
				.enterTextInFindField(str)
				.clickOnSearch()
				.verStudyIsPresent(str)
				.selStatusDropdownOption(
						objMedwebRadiologyStatistics_data.strStatusUnRead)
				.selTimePeriod(objMedwebRadiologyStatistics_data.strTimePeriod)
				.selLimitDropdownOption(
						objMedwebRadiologyStatistics_data.strLimit50)
				.enterTextInFindField(str1)
				.clickOnSearch()
				.verStudyIsPresent(str1)
				.selStatusDropdownOption(
						objMedwebRadiologyStatistics_data.strStatusBoth)
				.selTimePeriod(objMedwebRadiologyStatistics_data.strTimePeriod)
				.selLimitDropdownOption(
						objMedwebRadiologyStatistics_data.strLimit50)
				.enterTextInFindField(str).clickOnSearch()
				.verStudyIsPresent(str).enterTextInFindField(str1)
				.clickOnSearch().verStudyIsPresent(str1);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}

}
