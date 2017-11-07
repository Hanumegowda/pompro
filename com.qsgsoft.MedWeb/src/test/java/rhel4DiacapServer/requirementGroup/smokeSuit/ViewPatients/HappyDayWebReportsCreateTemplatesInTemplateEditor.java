package rhel4DiacapServer.requirementGroup.smokeSuit.ViewPatients;

import java.io.File;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import dataObject.DICOMSettings_data;
import dataObject.Groups_data;
import dataObject.Login_data;
import dataObject.PathData;
import dataObject.User_data;
import dataObject.ViewPatients_data;
import module.NavigationToSubMenus;
import page.AddUser;
import page.AdministratorSite;
import page.AutoIT;
import page.Destinations;
import page.Groups;
import page.Home;
import page.Login;
import page.UserManagement;
import page.ViewPatients;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;
import qaframework.lib.userDefinedFunctions.PathsProperties;

public class HappyDayWebReportsCreateTemplatesInTemplateEditor extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayWebReportsCreateTemplatesInTemplateEditor() throws Exception {
		super();
	}
	
	/*************************************************************************************
	  'Description   : Verify that a user with rights to add new reports is allowed to create new report templates.     
	  'Precondition  :
	  'Date          : 03-Dec-2015
	  'Author        : Hanumegowda
	  '---------------------------------------------------------------
	  'Modified Date                                               Modified By
	  'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that a user with rights to add new reports is allowed to create new report templates.")
	public void testHappyDay68582() throws Exception {

		gstrTCID = "68582";
		gstrTO = "Verify that a user with rights to add new reports is allowed to create new report templates.";

		Login_data objLogin_data = new Login_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		PathData objPathData = new PathData();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		Login objLogin = new Login(this.driver);
		Groups objGroups = new Groups(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		Groups_data objGroups_data = new Groups_data();
		UserManagement objUserManagement = new UserManagement(this.driver);
		User_data objUser_data = new User_data();

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
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();

		objHome.clickOnGroups();
		objGroups.verGroupsPage().clickOnAddGroup();
		objGroups.verAddNewGroup().enterGroupName(objGroups_data.groupname)
				.enterFullGroupName(objGroups_data.groupname)
				.selectGroupType(objGroups_data.grouptypeRadio)
				.selectCopyPermissionsFromOption(objGroups_data.grouptypeRadio)
				.clickOnCopy().selectAllowedCreateNewStudiesCheckBox()
				.selectShowNewStudyLinkOnPatientPageCheckBox();

		objAddUser.clickOnSaveChanges();
		System.out.println(objGroups_data.groupname);
		objNavigationToSubMenus.clickOnUser();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objGroups_data.groupname)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		objNavigationToSubMenus.clickOnPublicSite();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword).clickLogin();
		Thread.sleep(3000);
		objViewPatients.clickOnNewStudy();
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
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> itr = allwindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objViewPatients.clickOnAddButton();
				Set<String> allwindows1 = driver.getWindowHandles();
				Iterator<String> itr1 = allwindows1.iterator();
				while (itr1.hasNext()) {
					String childwindow1 = itr1.next().toString();
					if ((!childwindow1.contains(mainwindow))
							&& (!childwindow1.contains(childwindow))) {
						driver.switchTo().window(childwindow1);
						objViewPatients.clickOnTemplateEditorIcon();
						Thread.sleep(10000);
						Set<String> allwindows2 = driver.getWindowHandles();
						Iterator<String> itr2 = allwindows2.iterator();
						while (itr2.hasNext()) {
							String childwindow2 = itr2.next().toString();
							if ((!childwindow2.contains(mainwindow))
									&& (!childwindow2.contains(childwindow))
									&& (!childwindow2.contains(childwindow1))) {
								driver.switchTo().window(childwindow2);
								objViewPatients
										.clickOnClearDocumentIcon()
										.enterTextInTemplateEditorPage(
												objViewPatients_data.strTempText)
										.clickOnAddTemplateIcon();
								objUserManagement.clickOnOkInAlertPopUp();
								Thread.sleep(10000);
								Set<String> allwindows3 = driver
										.getWindowHandles();
								System.out.println(allwindows3.size()
										+ "total number of windows");
								Iterator<String> itr3 = allwindows3.iterator();
								while (itr3.hasNext()) {
									String childwindow3 = itr3.next()
											.toString();
									if ((!childwindow3.contains(mainwindow))
											&& (!childwindow3
													.contains(childwindow))
											&& (!childwindow3
													.contains(childwindow1))
											&& (!childwindow3
													.contains(childwindow2))) {
										driver.switchTo().window(childwindow3);
										driver.manage().window().maximize();
										Thread.sleep(5000);
										objViewPatients
												.enterTextInTemplateNameTextField(
														objViewPatients_data.strTemplate)
												.selTemplateType(
														objViewPatients_data.strTemplateType)
												.selTemplatePackage(
														objViewPatients_data.strTemplatePackage)
												.selTemplateField(
														objViewPatients_data.strTemplateField)
												.enterTextInMatchTextField()
												.clickOnSaveChangesInAddTemplatePage()
												.clickOnSaveChangesInAddTemplatePage();
									}
								}
								Thread.sleep(3000);

								driver.switchTo().window(childwindow2);
								objViewPatients
										.selTemplateFromDropdown1(
												objViewPatients_data.strTemplate)
										.verSelectedTemplateDisplayed(
												objViewPatients_data.strTempText);
								driver.close();
							}
						}
						driver.switchTo().window(childwindow1);
						driver.close();
					}
				}
				driver.switchTo().window(childwindow);
				driver.close();
			}
		}
		driver.switchTo().window(mainwindow);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	  'Description   : Verify that tags having multiple matches are displayed in the report when 
	                   selected from the pop-up window.     
	  'Precondition  :
	  'Date          : 04-Dec-2015
	  'Author        : Hanumegowda
	  '---------------------------------------------------------------
	  'Modified Date                                               Modified By
	  'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that tags having multiple matches are displayed in the report when "
			+ "selected from the pop-up window.")
	public void testHappyDay64432() throws Exception {

		gstrTCID = "64432";
		gstrTO = "Verify that tags having multiple matches are displayed in the report when selected"
				+ " from the pop-up window.";

		Login_data objLogin_data = new Login_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		PathData objPathData = new PathData();
		Home objHome = new Home(this.driver);
		Login objLogin = new Login(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		Destinations objDestinations = new Destinations(this.driver);
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
		objViewPatients.clickOnNewStudy();
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
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> itr = allwindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objViewPatients.clickOnAddButton();
				Set<String> allwindows1 = driver.getWindowHandles();
				Iterator<String> itr1 = allwindows1.iterator();
				while (itr1.hasNext()) {
					String childwindow1 = itr1.next().toString();
					if ((!childwindow1.contains(mainwindow))
							&& (!childwindow1.contains(childwindow))) {
						driver.switchTo().window(childwindow1);
						objViewPatients
								.clickOnSubstitutionFieldsManagementIcon();
						Thread.sleep(5000);
						Set<String> allwindows2 = driver.getWindowHandles();
						Iterator<String> itr2 = allwindows2.iterator();
						while (itr2.hasNext()) {
							String childwindow2 = itr2.next().toString();
							if ((!childwindow2.contains(mainwindow))
									&& (!childwindow2.contains(childwindow))
									&& (!childwindow2.contains(childwindow1))) {
								driver.switchTo().window(childwindow2);
								objViewPatients
										.selSmartTagRadioButton()
										.enterTextInTagField(
												objViewPatients_data.strTagName)
										.enterTextInPersonalPhraseField(
												objViewPatients_data.strPersonalPhrase);
								objDestinations.clickOnSaveChanges();
								Thread.sleep(5000);
								objViewPatients
										.enterTextInTagField(
												objViewPatients_data.strTagName1)
										.enterTextInPersonalPhraseField(
												objViewPatients_data.strPersonalPhrase1);
								objDestinations.clickOnSaveChanges();
								Thread.sleep(5000);
								objViewPatients
										.enterTextInTagField(
												objViewPatients_data.strTagName2)
										.enterTextInPersonalPhraseField(
												objViewPatients_data.strPersonalPhrase2);
								objDestinations.clickOnSaveChanges();
								Thread.sleep(5000);
								objViewPatients
										.enterTextInTagField(
												objViewPatients_data.strTagName3)
										.enterTextInPersonalPhraseField(
												objViewPatients_data.strPersonalPhrase3);
								objDestinations.clickOnSaveChanges();
								driver.close();
							}
						}

						driver.switchTo().window(childwindow1);
						driver.manage().window().maximize();
						String[] str = { objViewPatients_data.strTagName,
								objViewPatients_data.strTagName1,
								objViewPatients_data.strTagName2 };
						for (int i = 0; i < str.length; i++) {
							String req = (objViewPatients_data.strTagName)
									.substring(0, 4);
							System.out.println(req + " substr");
							objViewPatients.enterTextInReportEditorPage(
									"  " + req + " ")
									.moveCursorOntoTagName(req);
							Thread.sleep(3000);
							objViewPatients.selTagNameFromToolTip(str[i]);
							Thread.sleep(3000);
						}
						objViewPatients.clickOnSaveReport();
						driver.switchTo().window(childwindow);
						objViewPatients.clickOnStudyInWebReporterPage();
						Set<String> allwindows3 = driver.getWindowHandles();
						Iterator<String> itr3 = allwindows3.iterator();
						while (itr3.hasNext()) {
							String cw = itr3.next().toString();
							if (!(cw.contains(mainwindow))
									&& !(cw.contains(childwindow))) {
								driver.switchTo().window(cw);
								driver.manage().window().maximize();
								Thread.sleep(3000);
								objViewPatients
										.verValueOfTagNameIsDisplayed(
												objViewPatients_data.strPersonalPhrase)
										.verValueOfTagNameIsDisplayed(
												objViewPatients_data.strPersonalPhrase1)
										.verValueOfTagNameIsDisplayed(
												objViewPatients_data.strPersonalPhrase2);
							}
						}

						driver.close();
					}
				}
				driver.switchTo().window(childwindow);
				driver.close();
			}
		}
		driver.switchTo().window(mainwindow);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";
	}
	
	/*************************************************************************************
	  'Description   : Verify that the corresponding block of phrases are populated automatically
	                   if there are single matche for the Tag when that tag is typed and Spacebar key is clicked.     
	  'Precondition  :
	  'Date          : 27-Jul-2016
	  'Author        : Hanumegowda
	  '---------------------------------------------------------------
	  'Modified Date                                               Modified By
	  'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that the corresponding block of phrases are populated automatically if "
			+ "there are single matche for the Tag when that tag is typed and Spacebar key is clicked.")
	public void testHappyDay64431() throws Exception {

		gstrTCID = "64431";
		gstrTO = "Verify that the corresponding block of phrases are populated automatically if there "
				+ "are single matche for the Tag when that tag is typed and Spacebar key is clicked.";

		Login_data objLogin_data = new Login_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		PathData objPathData = new PathData();
		Home objHome = new Home(this.driver);
		Login objLogin = new Login(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		Destinations objDestinations = new Destinations(this.driver);
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
		objViewPatients.clickOnNewStudy();
		Thread.sleep(3000);
		objAutoIT.CreateStudy(strAutoitPath, objViewPatients_data.strStudy,
				objViewPatients_data.strStudy, strImagePath,
				objViewPatients_data.strModalityDS);
		Thread.sleep(8000);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients
				.clickOnSearch()
				.clickOnSearch()
				.clickOnSearch()
				.clickOnSearch()
				.clickOnSearch()
				.clickOnViewModifyWebReportsOfAStudy(
						objViewPatients_data.strStudy);
		String mainwindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> itr = allwindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!childwindow.contains(mainwindow)) {
				driver.switchTo().window(childwindow);
				objViewPatients.clickOnAddButton();
				Set<String> allwindows1 = driver.getWindowHandles();
				Iterator<String> itr1 = allwindows1.iterator();
				while (itr1.hasNext()) {
					String childwindow1 = itr1.next().toString();
					if ((!childwindow1.contains(mainwindow))
							&& (!childwindow1.contains(childwindow))) {
						driver.switchTo().window(childwindow1);
						objViewPatients
								.clickOnSubstitutionFieldsManagementIcon();
						Thread.sleep(5000);
						Set<String> allwindows2 = driver.getWindowHandles();
						Iterator<String> itr2 = allwindows2.iterator();
						while (itr2.hasNext()) {
							String childwindow2 = itr2.next().toString();
							if ((!childwindow2.contains(mainwindow))
									&& (!childwindow2.contains(childwindow))
									&& (!childwindow2.contains(childwindow1))) {
								driver.switchTo().window(childwindow2);
								objViewPatients
										.selSmartTagRadioButton()
										.enterTextInTagField(
												objViewPatients_data.strTagName)
										.enterTextInPersonalPhraseField(
												objViewPatients_data.strPersonalPhrase);
								objDestinations.clickOnSaveChanges();
								Thread.sleep(5000);
								objViewPatients
										.enterTextInTagField(
												objViewPatients_data.strTagName1)
										.enterTextInPersonalPhraseField(
												objViewPatients_data.strPersonalPhrase1);
								objDestinations.clickOnSaveChanges();
								Thread.sleep(5000);
								objViewPatients
										.enterTextInTagField(
												objViewPatients_data.strTagName2)
										.enterTextInPersonalPhraseField(
												objViewPatients_data.strPersonalPhrase2);
								objDestinations.clickOnSaveChanges();
								Thread.sleep(5000);
								objViewPatients
										.enterTextInTagField(
												objViewPatients_data.strTagName3)
										.enterTextInPersonalPhraseField(
												objViewPatients_data.strPersonalPhrase3);
								objDestinations.clickOnSaveChanges();
								driver.close();
							}
						}
						Thread.sleep(5000);

						driver.switchTo().window(childwindow1);
						driver.manage().window().maximize();
						String[] str = {
								objViewPatients_data.strPersonalPhrase,
								objViewPatients_data.strPersonalPhrase1,
								objViewPatients_data.strPersonalPhrase2 };
						for (int i = 0; i < str.length; i++) {
							String req = (objViewPatients_data.strTagName)
									.substring(0, 4);
							System.out.println(req + " substr");
							objViewPatients.enterTextInReportEditorPage1(
									"  " + req + " ")
									.moveCursorOntoTagName(req);
							Thread.sleep(3000);
							objViewPatients.verPhrasesAreDisplayed(str[i]);
							Thread.sleep(3000);
						}
						//Thread.sleep(5000);
						objViewPatients
								.clickOnSubstitutionFieldsManagementIcon();
						Thread.sleep(5000);
						Set<String> aw = driver.getWindowHandles();
						Iterator<String> itr11 = aw.iterator();
						while (itr11.hasNext()) {
							String cw = itr11.next().toString();
							Thread.sleep(5000);
							if ((!cw.contains(mainwindow))
									&& (!cw.contains(childwindow))
									&& (!cw.contains(childwindow1))) {
								Thread.sleep(5000);
								driver.switchTo().window(cw);
								Thread.sleep(5000);
								driver.manage().window().maximize();
								Thread.sleep(5000);
								objViewPatients
										.selSmartTagRadioButton()
										.clickOnDelTags(
												objViewPatients_data.strTagName)
										.clickOnDelTags(
												objViewPatients_data.strTagName1)
										.clickOnDelTags(
												objViewPatients_data.strTagName2);
								System.out.println("yyyyyyyyy");
								driver.close();
							}
						}
						driver.switchTo().window(childwindow1);

						driver.close();
					}
				}
				driver.switchTo().window(childwindow);
				driver.close();
			}
		}
		driver.switchTo().window(mainwindow);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";
	}

}
