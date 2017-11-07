package rh4CommercialServer.requirementGroup.smokeSuit.UserGroups;

import java.io.File;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import dataObject.DICOMSettings_data;
import dataObject.Groups_data;
import dataObject.Locations_data;
import dataObject.Login_data;
import dataObject.PathData;
import dataObject.User_data;
import dataObject.ViewPatients_data;
import module.NavigationToSubMenus;
import page.AddUser;
import page.AdministratorSite;
import page.AutoIT;
import page.DICOMSetting;
import page.Destinations;
import page.Groups;
import page.Home;
import page.Locations;
import page.Login;
import page.ReportTemplatesManagement;
import page.UserManagement;
import page.ViewPatients;

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;
import qaframework.lib.userDefinedFunctions.PathsProperties;

public class HappyDayManageGroups extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayManageGroups() throws Exception{
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that user from "User and Group Management" group can add/modify/delete
                     data from 1) Users Page 2) Groups Page 3) Locations Page and 4) Local Settings >
                     Report Templates Management page.     
    'Precondition  :
    'Date          : 22-Jun-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that user from User and Group Management group can add/modify/delete"
			+ " data from 1) Users Page 2) Groups Page 3) Locations Page and 4) Local Settings > Report"
			+ " Templates Management page.")
	public void testHappyDay122285() throws Exception {

		gstrTCID = "122285";
		gstrTO = "Verify that user from User and Group Management group can add/modify/delete data from "
				+ "1) Users Page 2) Groups Page 3) Locations Page and 4) Local Settings > Report Templates "
				+ "Management page.";

		Login_data objLogin_data = new Login_data();
		User_data objUser_data = new User_data();
		Groups_data objGroups_data = new Groups_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		PathData objPathData = new PathData();
		Locations_data objLocations_data = new Locations_data();
		Home objHome = new Home(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		AddUser objAddUser = new AddUser(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		Destinations objDestinations = new Destinations(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		Login objLogin = new Login(this.driver);
		Groups objGroups = new Groups(this.driver);
		Locations objLocations = new Locations(this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		ReportTemplatesManagement objReportTemplatesManagement = new ReportTemplatesManagement(
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
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objUserManagement.clickOnAddUser();
		objAddUser
				.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(
						objUser_data.userAndGroupManagement)
				.enterFullNameLast(objUser_data.strNewUserName)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		System.out.println(objUser_data.strNewUserName);
		objHome.clickOnLogOut();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objUser_data.strNewUserName, objUser_data.strNewPassword)
				.clickLogin();
		objUserManagement.clickOnAddUser();
		objAddUser.verAddNewUserPage()
				.selectOptionInACLgroupDropDown(objUser_data.radioLogist)
				.enterFullNameLast(objUser_data.strNewUserName1)
				.enterPassWord(objUser_data.strNewPassword)
				.confirmPassWord(objUser_data.strNewPassword)
				.clickOnSaveChanges();
		try{
			objUserManagement
					.enterTextInUserNameSearchField(objUser_data.strNewUserName1)
					.clickOnSearch();
			}
			catch(NoSuchElementException e){
				System.out.println("");
			}
		objUserManagement.verUserWithACLGroup(objUser_data.strNewUserName1,
						objUser_data.radioLogist)
				.clickOnModifyUser(objUser_data.strNewUserName1);
		objAddUser.selectOptionInACLgroupDropDown(objUser_data.generalist);
		Thread.sleep(3000);
		objAddUser.clickOnSaveChanges();
		try{
		objUserManagement
				.enterTextInUserNameSearchField(objUser_data.strNewUserName1)
				.clickOnSearch();
		}
		catch(NoSuchElementException e){
			System.out.println("");
		}
		objUserManagement.verUserWithACLGroup(objUser_data.strNewUserName1,
						objUser_data.generalist)
				.clickOnRemoveUser(objUser_data.strNewUserName1)
				.clickOnOkInAlertPopUp();
		Thread.sleep(3000);
		objUserManagement
				.enterTextInUserNameSearchField(objUser_data.strNewUserName1)
				.clickOnSearch().verUserNotFoundErrMsg();
		objHome.clickOnGroups();
		objGroups.clickOnAddGroup();
		objGroups.verAddNewGroup().enterGroupName(objGroups_data.groupname)
				.enterFullGroupName(objGroups_data.groupname);
		objAddUser.clickOnSaveChanges();
		System.out.println(objGroups_data.groupname);
		objGroups.verGroupNameInGroupList(objGroups_data.groupname)
				.clickOnModifyGroupIcon(objGroups_data.groupname)
				.enterFullGroupName(objGroups_data.groupnamemod);
		objAddUser.clickOnSaveChanges();
		objGroups.verGroupNameInGroupList(objGroups_data.groupnamemod).deleteGroup(objGroups_data.groupnamemod);
		objUserManagement.clickOnOkInAlertPopUp();
		Thread.sleep(5000);
		objGroups.verGroupNameIsNotDisplayingInGroupList(objGroups_data.groupnamemod);
		objNavigationToSubMenus.clickOnLocations();
		objLocations
				.clickOnAddLocation()
				.verAddnewLocationPage()
				.enterTextInFacilityNameField(objLocations_data.strfacilityname)
				.enterTextInLocationIDField(objLocations_data.locationid)
				.enterTextInCityField(objLocations_data.city)
				.enterTextInCountryField(objLocations_data.country);
		objAddUser.clickOnSaveChanges();
		objLocations
				.verLocationIsDisplayed(objLocations_data.strfacilityname,
						objLocations_data.locTypeOther)
				.clickOnModifyLocation(objLocations_data.strfacilityname)
				.enterTextInFacilityNameField(
						objLocations_data.strfacilityname1);
		objAddUser.clickOnSaveChanges();
		objLocations.verLocationIsDisplayed(objLocations_data.strfacilityname1,
				objLocations_data.locTypeOther).clickOnDeleteLocation(
				objLocations_data.strfacilityname1);
		objUserManagement.clickOnOkInAlertPopUp();
		objLocations.verLocationIsNotDisplayed(
				objLocations_data.strfacilityname1,
				objLocations_data.locTypeOther);

		String temp[] = { objViewPatients_data.strTemplate,
				objViewPatients_data.strTemplate2,
				objViewPatients_data.strTemplate4 };
		System.out.println(temp.length);
		System.out.println(temp[0]);
		System.out.println(temp[1]);
		objHome.launchApplication(objLogin_data.strAppURL);
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
		for (int i = 0; i < temp.length; i++) {
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
							objViewPatients.clickOnTemplateEditorIcon();
							Thread.sleep(10000);
							Set<String> allwindows2 = driver.getWindowHandles();
							Iterator<String> itr2 = allwindows2.iterator();
							while (itr2.hasNext()) {
								String childwindow2 = itr2.next().toString();
								if ((!childwindow2.contains(mainwindow))
										&& (!childwindow2.contains(childwindow))
										&& (!childwindow2
												.contains(childwindow1))) {
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
									Iterator<String> itr3 = allwindows3
											.iterator();
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
											driver.switchTo().window(
													childwindow3);
											driver.manage().window().maximize();
											Thread.sleep(5000);
											System.out
													.println(objViewPatients_data.strTemplate);
											objViewPatients
													.enterTextInTemplateNameTextField(
															temp[i])
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

									driver.switchTo().window(childwindow2);
									objViewPatients
											.selTemplateFromDropdown(objViewPatients_data.strTemplate);
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

		}
		objViewPatients.clickOnLogout();
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.clickOnAdminSite();
		objLogin.login(objUser_data.strNewUserName, objUser_data.strNewPassword)
				.clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();

		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.clickOnReportTemplatesManagementLink();
		objReportTemplatesManagement.verReportTemplatesManagementPage();
		objReportTemplatesManagement.enterTextInTemplateNameTextField(temp[0])
				.clickOnStartSearch().clickOnATemplateLink(temp[0]);
		String mw = driver.getWindowHandle();
		Set<String> aw = driver.getWindowHandles();
		Iterator<String> itr = aw.iterator();
		while (itr.hasNext()) {
			String cw = itr.next().toString();
			if (!cw.contains(mw)) {
				driver.switchTo().window(cw);
				objViewPatients.clickOnAddTemplateIcon();
				objUserManagement.clickOnOkInAlertPopUp();
				Thread.sleep(5000);
				Set<String> aw1 = driver.getWindowHandles();
				Iterator<String> itr1 = aw1.iterator();
				while (itr1.hasNext()) {
					String cw1 = itr1.next().toString();
					if ((!cw1.contains(mw)) && (!cw1.contains(cw))) {
						driver.switchTo().window(cw1);
						driver.manage().window().maximize();
						objViewPatients.enterTextInTemplateNameTextField(
								objViewPatients_data.strTemplate1)
								.clickOnSaveChangesInAddTemplatePage();

					}
				}
				driver.switchTo().window(cw);
				driver.close();
			}
		}
		driver.switchTo().window(mw);
		objReportTemplatesManagement
				.enterTextInTemplateNameTextField(
						objViewPatients_data.strTemplate1).clickOnStartSearch()
				.verATemplateIsPresent(objViewPatients_data.strTemplate1);
		objReportTemplatesManagement
				.clickOnModifyIconOfTemplate(objViewPatients_data.strTemplate1);
		Thread.sleep(5000);
		String[] req = objViewPatients_data.strTemplateField1.split("-");
		String req1 = req[0].trim();
		System.out.println(req1);
		String[] req2 = objViewPatients_data.strTemplateField.split("-");
		String req12 = req2[0].trim();
		System.out.println(req12);

		String mw1 = driver.getWindowHandle();
		Set<String> aw2 = driver.getWindowHandles();
		Iterator<String> itr2 = aw2.iterator();
		while (itr2.hasNext()) {
			String cw = itr2.next().toString();
			if (!cw.contains(mw1)) {
				driver.switchTo().window(cw);
				driver.manage().window().maximize();
				objViewPatients
						.enterTextInTemplateNameTextField(
								objViewPatients_data.strTemplate3)
						.selTemplateType(objViewPatients_data.strTemplateType1)
						.selTemplateSubType(
								objViewPatients_data.strTemplateSubType)
						.selTemplatePackage(
								objViewPatients_data.strTemplatePackage1);
				Thread.sleep(5000);
				objViewPatients
						.selTemplateField(
								objViewPatients_data.strTemplateField1)
						.enterTextInMatchTextField()
						.clickOnSaveChangesInAddTemplatePage()
						.clickOnSaveChangesInAddTemplatePage();
			}
		}
		driver.switchTo().window(mw1);
		objReportTemplatesManagement
				.enterTextInTemplateNameTextField(
						objViewPatients_data.strTemplate3)
				.clickOnStartSearch()
				.verModifiedTemplateDetails(
						objViewPatients_data.strTemplatePackage1,
						objViewPatients_data.strTemplate3,
						objViewPatients_data.strTemplateType1,
						objViewPatients_data.strAclType,
						objUser_data.strNewUserName, req1);
		objReportTemplatesManagement
				.clickOnDeleteATemplate(objViewPatients_data.strTemplate3);
		objUserManagement.clickOnOkInAlertPopUp();
		Thread.sleep(4000);
		objReportTemplatesManagement
				.enterTextInTemplateNameTextField(
						objViewPatients_data.strTemplate3).clickOnStartSearch()
				.verNoOrderMsg().clickOnEditorProperty();
		Set<String> aw1 = driver.getWindowHandles();
		Iterator<String> itr1 = aw1.iterator();
		while (itr1.hasNext()) {
			String cw1 = itr1.next().toString();
			if (!cw1.contains(mw)) {
				driver.switchTo().window(cw1);
				driver.manage().window().maximize();
				objReportTemplatesManagement
						.enterTextInTemplatePackagesTextField(objViewPatients_data.tempPackage);
				objViewPatients.clickOnAddIconInEditorPropertiesPage();
				Thread.sleep(3000);
				objReportTemplatesManagement
						.verTemplatePackages(objViewPatients_data.tempPackage);
				driver.close();
			}
		}
		driver.switchTo().window(mw);
		String str = (objViewPatients_data.strTemplate3).substring(20);
		System.out.println(str);
		objReportTemplatesManagement.enterTextInTemplateNameTextField(str)
				.clickOnStartSearch();
		objReportTemplatesManagement.selPackage(objViewPatients_data.packagen)
				.selOwner(objViewPatients_data.strOwner)
				.selType(objViewPatients_data.type).clickOnAclModifyIcon();
		Set<String> aw11 = driver.getWindowHandles();
		Iterator<String> itr11 = aw11.iterator();
		while (itr11.hasNext()) {
			String cw1 = itr11.next().toString();
			if (!cw1.contains(mw)) {
				driver.switchTo().window(cw1);
				objReportTemplatesManagement
						.selAcl(objViewPatients_data.strRadiology);
				objViewPatients.clickOnSaveChangesInAddTemplatePage();
			}
		}
		Thread.sleep(3000);
		driver.switchTo().window(mw);
		objReportTemplatesManagement.selAllCheckbox();
		objDestinations.clickOnSaveChanges();
		objUserManagement.clickOnOkInAlertPopUp();
		Thread.sleep(3000);

		objReportTemplatesManagement
				.enterTextInTemplateNameTextField(
						objViewPatients_data.strTemplate2)
				.clickOnStartSearch()
				.verModifiedTemplateDetails(objViewPatients_data.packagen,
						objViewPatients_data.strTemplate2,
						objViewPatients_data.type,
						objViewPatients_data.strRadiology,
						objViewPatients_data.strOwner, req12);
		objReportTemplatesManagement
				.enterTextInTemplateNameTextField(
						objViewPatients_data.strTemplate4)
				.clickOnStartSearch()
				.verModifiedTemplateDetails(objViewPatients_data.packagen,
						objViewPatients_data.strTemplate4,
						objViewPatients_data.type,
						objViewPatients_data.strRadiology,
						objViewPatients_data.strOwner, req12);

		objReportTemplatesManagement.enterTextInTemplateNameTextField(str)
				.clickOnStartSearch();
		objReportTemplatesManagement.selAllCheckbox().clickOnDeleteIcon();
		objUserManagement.clickOnOkInAlertPopUp();
		Thread.sleep(5000);
		objReportTemplatesManagement
				.enterTextInTemplateNameTextField(
						objViewPatients_data.strTemplate2).clickOnStartSearch()
				.verNoOrderMsg();
		objReportTemplatesManagement
				.enterTextInTemplateNameTextField(
						objViewPatients_data.strTemplate4).clickOnStartSearch()
				.verNoOrderMsg();
		objHome.clickOnLogOut();

		gstrResult = "PASS";

	}
	
}
