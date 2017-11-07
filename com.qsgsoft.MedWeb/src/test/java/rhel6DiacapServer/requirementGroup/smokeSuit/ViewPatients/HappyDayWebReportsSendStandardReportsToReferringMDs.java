package rhel6DiacapServer.requirementGroup.smokeSuit.ViewPatients;

import java.io.File;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import dataObject.DICOMSettings_data;
import dataObject.Login_data;
import dataObject.PathData;
import dataObject.ViewPatients_data;
import page.AutoIT;
import page.Home;
import page.Login;
import page.MailVerificationFunctions;
import page.ViewPatients;
import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;
import qaframework.lib.userDefinedFunctions.PathsProperties;

public class HappyDayWebReportsSendStandardReportsToReferringMDs extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayWebReportsSendStandardReportsToReferringMDs() throws Exception{
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that the report is delivered to the recipient's email address when 
                     the user 'Saves and Signs' the report.     
    'Precondition  :
    'Date          : 06-Nov-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the report is delivered to the recipient's email address when"
			+ "the user 'Saves and Signs' the report.")
	public void testHappyDay107966() throws Exception {

		gstrTCID = "107966";
		gstrTO = "Verify that the report is delivered to the recipient's email address when the user"
				+ " 'Saves and Signs' the report.";

		Login_data objLogin_data = new Login_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		PathData objPathData = new PathData();
		Home objHome = new Home(this.driver);
		Login objLogin = new Login(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		MailVerificationFunctions objMailVerificationFunctions = new MailVerificationFunctions(
				this.driver);

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
		Thread.sleep(3000);
		System.out.println(objViewPatients_data.strStudy);
		objViewPatients.clickOnNewStudy();
		String mw = driver.getWindowHandle();
		Set<String> aw = driver.getWindowHandles();
		System.out.println(aw.size() + " no of windows");
		Iterator<String> it = aw.iterator();
		while (it.hasNext()) {
			String cw = it.next().toString();
			if (!cw.contains(mw)) {
				driver.switchTo().window(cw);

			}

		}
		Thread.sleep(5000);
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy,
				objViewPatients_data.strStudy, strImagePath,
				objViewPatients_data.strModalityDS);
		Thread.sleep(3000);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch1().clickOnViewModifyWebReportsOfAStudy(
				objViewPatients_data.strStudy);
		String mainwindow = driver.getWindowHandle();
		Set<String> allwindow = driver.getWindowHandles();
		for (String childwindow : allwindow) {
			driver.switchTo().window(childwindow);
		}
		objViewPatients.clickOnAddButton();
		Set<String> allwindow1 = driver.getWindowHandles();
		for (String childwindow1 : allwindow1) {
			driver.switchTo().window(childwindow1);
		}
		objViewPatients
				.enterTextInSendToFieldInEditReportPage(
						objViewPatients_data.strUN).clickOnSaveSignReport()
				.clickOnSignReport();
		Set<String> allwindow2 = driver.getWindowHandles();
		for (String childwindow2 : allwindow2) {
			driver.switchTo().window(childwindow2);
		}
		driver.close();

		driver.switchTo().window(mainwindow);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch();
		objMailVerificationFunctions
				.loginToMail(objViewPatients_data.strUN,
						objViewPatients_data.strPWD)
				.navigateToInbox1(objViewPatients_data.strStudy)
				.verPdfFile(objViewPatients_data.strStudy).clickOnMailLogout();

		gstrResult = "PASS";
	}

}
