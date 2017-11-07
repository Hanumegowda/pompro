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
import page.UserManagement;
import page.ViewPatients;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;
import qaframework.lib.userDefinedFunctions.PathsProperties;

public class HappyDayAttachmentsInWebReporterPage extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayAttachmentsInWebReporterPage() throws Exception {
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that "remove" link is displayed next to uploaded attachments in the
                     web reporter page and attachments are deleted when clicked on thos link.     
    'Precondition  :
    'Date          : 16-Nov-2015
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that 'remove' link is displayed next to uploaded attachments in the"
			+ " web reporter page and attachments are deleted when clicked on thos link.")
	public void testHappyDay96764() throws Exception {

		gstrTCID = "96764";
		gstrTO = "Verify that 'remove' link is displayed next to uploaded attachments in the web"
				+ " reporter page and attachments are deleted when clicked on thos link.";

		Login_data objLogin_data = new Login_data();
		PathData objPathData = new PathData();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		Home objHome = new Home(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		Login objLogin = new Login(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
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
		// pdf file
		String fileUploadPath = pathProps
				.getProperty(objPathData.strPdfFileUpload);

		File file = new File(System.getProperty("user.dir") + fileUploadPath);
		String strPath = file.toString();
		String a[] = strPath.split("\\\\");
		String b = a[(a.length) - 1];
		System.out.println(b);

		// doc file

		String fileUploadPath1 = pathProps
				.getProperty(objPathData.strDocFileUpload);

		File file1 = new File(System.getProperty("user.dir") + fileUploadPath1);
		String strPath1 = file1.toString();
		String a1[] = strPath1.split("\\\\");
		String b1 = a1[(a1.length) - 1];
		System.out.println(b1);

		// docx file

		String fileUploadPath2 = pathProps
				.getProperty(objPathData.strDocxFileUpload);

		File file2 = new File(System.getProperty("user.dir") + fileUploadPath2);
		String strPath2 = file2.toString();
		String a2[] = strPath2.split("\\\\");
		String b2 = a2[(a2.length) - 1];
		System.out.println(b2);

		// xls file

		String fileUploadPath3 = pathProps
				.getProperty(objPathData.strXlsFileUpload);

		File file3 = new File(System.getProperty("user.dir") + fileUploadPath3);
		String strPath3 = file3.toString();
		String a3[] = strPath3.split("\\\\");
		String b3 = a3[(a3.length) - 1];
		System.out.println(b3);

		// xlsx file

		String fileUploadPath4 = pathProps
				.getProperty(objPathData.strXlsxFileUpload);

		File file4 = new File(System.getProperty("user.dir") + fileUploadPath4);
		String strPath4 = file4.toString();
		String a4[] = strPath4.split("\\\\");
		String b4 = a4[(a4.length) - 1];
		System.out.println(b4);

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();

		System.out.println(objViewPatients_data.strStudy);
		objViewPatients.clickOnNewStudy();
		Thread.sleep(5000);
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy,
				objViewPatients_data.strStudy, strImagePath,
				objViewPatients_data.strModalityDS);
		Thread.sleep(3000);

		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients
				.clickOnSearch1()
				.clickOnViewModifyWebReportsOfAStudy(
						objViewPatients_data.strStudy);
		String mainwindow = driver.getWindowHandle();
		Set<String> allwindow = driver.getWindowHandles();
		Iterator<String> itr = allwindow.iterator();
		while (itr.hasNext() == true) {
			String childwindow = itr.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objViewPatients.clickOnAddButton();
				Set<String> allwindow1 = driver.getWindowHandles();
				Iterator<String> itr1 = allwindow1.iterator();
				while (itr1.hasNext()) {
					String chidwindow1 = itr1.next().toString();
					if ((!chidwindow1.contains(mainwindow))
							&& (!chidwindow1.contains(childwindow))) {
						driver.switchTo().window(chidwindow1);
						Thread.sleep(3000);
						objViewPatients.clickOnSaveReport();
					}
				}
				driver.switchTo().window(childwindow);

				objViewPatients.verSavedReportIsDisplayed();
				objViewPatients.verWebReporterPage("Web-Reporter");
				for (int i = 0; i < 5; i++) {

					objViewPatients.clickOnAttachDocumentIcon();
					String[] allfiles = { strPath, strPath1, strPath2,
							strPath3, strPath4 };
					Set<String> allwin = driver.getWindowHandles();
					Iterator<String> itrr = allwin.iterator();
					while (itrr.hasNext()) {
						String cw = itrr.next().toString();
						if ((!cw.contains(mainwindow))
								&& (!cw.contains(childwindow))) {
							driver.switchTo().window(cw);
							driver.manage().window().maximize();
							objViewPatients.clickOnBrowseButton(allfiles[i]);
							objViewPatients.clickOnUploadButton1();
							Thread.sleep(3000);
						}
					}

					driver.switchTo().window(childwindow);
				}
				for (int i = 0; i < 5; i++) {
					String[] strallfiles = { b, b1, b2, b3, b4 };
					objViewPatients
							.verUploadedDocument(strallfiles[i])
							.verRemoveLinkInUploadedAttachment(strallfiles[i])
							.clickRemoveLinkInUploadedAttachment(strallfiles[i]);
					objUserManagement.clickOnOkInAlertPopUp();
					Thread.sleep(3000);
					driver.navigate().refresh();
					System.out.println(i);
					objViewPatients
							.verRemoveLinkInUploadedAttachmentIsNotPresent(strallfiles[i]);
				}
				objViewPatients.verSavedReportIsDisplayed();
				driver.close();
			}
		}
		driver.switchTo().window(mainwindow);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}

}
