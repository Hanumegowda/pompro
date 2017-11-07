package rh6CommercialServer.requirementGroup.smokeSuit.MedwebRadiologyStatistics;

import java.io.File;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import dataObject.DICOMSettings_data;
import dataObject.Groups_data;
import dataObject.Login_data;
import dataObject.MedwebRadiologyStatistics_data;
import dataObject.PathData;
import dataObject.PatientSchedule_data;
import dataObject.RISSettings_data;
import dataObject.User_data;
import dataObject.ViewPatients_data;
import module.CommonFunctions;
import module.NavigationToSubMenus;
import page.AETitleRouting;
import page.AddUser;
import page.AdministratorSite;
import page.AutoIT;
import page.ControlPanel;
import page.DICOMSetting;
import page.Destinations;
import page.Groups;
import page.Home;
import page.Login;
import page.MachineSchedule;
import page.PatientScheduleRegistration;
import page.RISSettings;
import page.Statistics;
import page.UserManagement;
import page.ViewPatients;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONSForOneBrowser;
import qaframework.lib.userDefinedFunctions.Date_Time_settings;
import qaframework.lib.userDefinedFunctions.PathsProperties;

public class HappyDayEventsLog extends TestNG_UI_EXTENSIONSForOneBrowser{
	public HappyDayEventsLog() throws Exception{
		super();
	}
	
	/*************************************************************************************
    'Description   : Verify that the total number of all the events of the cases in a Medweb Server
                     is displayed for the Event any and for a time period All Days.     
    'Precondition  :
    'Date          : 28-Jun-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(enabled=false,description = "Verify that the total number of all the events of the cases in a Medweb "
			+ "Server is displayed for the Event any and for a time period All Days.")
	public void testHappyDay69331() throws Exception {
		gstrTCID = "69331";
		gstrTO = "Verify that the total number of all the events of the cases in a Medweb Server is "
				+ "displayed for the Event any and for a time period All Days.";

		Login_data objLogin_data = new Login_data();
		PathData objPathData = new PathData();
		PatientSchedule_data objPatientSchedule_data = new PatientSchedule_data();
		RISSettings_data objRISSettings_data = new RISSettings_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		MedwebRadiologyStatistics_data objMedwebRadiologyStatistics_data = new MedwebRadiologyStatistics_data();
		Home objHome = new Home(this.driver);
		Statistics objStatistics = new Statistics(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		UserManagement objUserManagement = new UserManagement(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		RISSettings objRISSettings = new RISSettings(this.driver);
		PatientScheduleRegistration objPatientScheduleRegistration = new PatientScheduleRegistration(
				this.driver);
		MachineSchedule objMachineSchedule = new MachineSchedule(this.driver);
		AddUser objAddUser = new AddUser(this.driver);
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

		String str1 = objPatientSchedule_data.strPatient;
		String str2 = str1.substring(11);
		String str3 = str1.substring(0, 11);
		String str4 = str2.substring(0, 3);
		String str5 = "ln" + str2;
		String str6 = "fn" + str3;
		String str7 = "mod" + str2;
		String str8 = "mod" + str3;
		String str9 = "new" + str2;
		String str10 = "new" + str3;
		System.out.println(str2 + " str2");
		System.out.println(str3 + " str3");
		System.out.println(str4 + " str4");

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnRISSettings();
		objRISSettings.clickClinicsAndMachines();
		objAddUser.clickOnAddInMedicalLicensesPage();
		objRISSettings.enterTextInAddress(objRISSettings_data.strAdrress)
				.enterTextInEmail(objRISSettings_data.strEmail)
				.enterTextInMTF(objRISSettings_data.strMtf)
				.enterTextInName(objRISSettings_data.strClinicName)
				.enterTextInPhone(objRISSettings_data.strPhone)
				.enterTextInState(objRISSettings_data.strState)
				.clickOnSaveChanges();
		objRISSettings.verClinic(objRISSettings_data.strClinicName)
				.clickOnClinicLink(objRISSettings_data.strClinicName)
				.clickOnSecAddButton()
				.enterTextInMachineID(objRISSettings_data.strMachineId);
		objRISSettings.selModality(objRISSettings_data.strModalityMr);
		objUserManagement.clickOnOkInAlertPopUp();
		objRISSettings.clickOnSaveChanges();

		objNavigationToSubMenus.clickOnPublicSite().clickOnMachineSchedule();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		System.out.println(objRISSettings_data.strMachineId);
		objMachineSchedule.verMachineSchedulePage()
				.clickOnMachineLink(objRISSettings_data.strMachineId)
				.clickOnAvailableTimeSlot().verNewMachineEventPage()
				.clickOnSearchDoctorIcon();
		String actual;
		String mainwindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> itr = allwindows.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			if (!childwindow.equals(mainwindow)) {
				driver.switchTo().window(childwindow);
				actual = objMachineSchedule.selAnyDoctor();
				System.out.println(actual);
				driver.switchTo().window(mainwindow);
				objMachineSchedule.clickOnSaveAndBackButton();
			}
		}

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage();
		objHome.clickOnPatientSchedule();
		/*
		 * objLogin.loginAsUser(objLogin_data.strAdminUser,
		 * objLogin_data.strAdminUserPwd).clickLogin();
		 */
		objPatientScheduleRegistration.verPatientRegistrationPage()
				.enterTextInLastName(str2).enterTextInFirstName(str3)

				.enterTextInAddress(objPatientSchedule_data.strAddress)
				.enterTextInCity(objPatientSchedule_data.strCity)
				.enterTextInCountry(objPatientSchedule_data.strCountry)

				.enterTextInZip(objPatientSchedule_data.strZip)

				.selState(objPatientSchedule_data.strState)
				.clickOnSavePatientData();
		objUserManagement.clickOnOkInAlertPopUp();
		objPatientScheduleRegistration.clickOnCreateTheOrder();
		objUserManagement.clickOnOkInAlertPopUp();
		objPatientScheduleRegistration
				.selModality(objRISSettings_data.strModalityMr)
				.selClinic(objRISSettings_data.strClinicName).selStatCheckbox()
				.clickOnSave().verOrderIsMarkedAsStat(str2);
		objHome.clickOnPatientScheduleForSecTime();
		objPatientScheduleRegistration.verPatientRegistrationPage()
				.enterTextInLastName(str5).enterTextInFirstName(str6)

				.enterTextInAddress(objPatientSchedule_data.strAddress)
				.enterTextInCity(objPatientSchedule_data.strCity)
				.enterTextInCountry(objPatientSchedule_data.strCountry)

				.enterTextInZip(objPatientSchedule_data.strZip)

				.selState(objPatientSchedule_data.strState)
				.clickOnSavePatientData();
		objUserManagement.clickOnOkInAlertPopUp();
		Thread.sleep(3000);
		// objHome.clickOnPatientScheduleForSecTime();
		objPatientScheduleRegistration.enterTextInLastName(str7)
				.enterTextInFirstName(str8)

				.enterTextInAddress(objPatientSchedule_data.strAddress)
				.enterTextInCity(objPatientSchedule_data.strCity)
				.enterTextInCountry(objPatientSchedule_data.strCountry)

				.enterTextInZip(objPatientSchedule_data.strZip)

				.selState(objPatientSchedule_data.strState)
				.clickOnSavePatientData();
		objUserManagement.clickOnOkInAlertPopUp();
		Thread.sleep(3000);
		objHome.clickOnPatientScheduleForSecTime();
		objPatientScheduleRegistration.enterTextInLastName(str9)
				.enterTextInFirstName(str10)

				.enterTextInAddress(objPatientSchedule_data.strAddress)
				.enterTextInCity(objPatientSchedule_data.strCity)
				.enterTextInCountry(objPatientSchedule_data.strCountry)

				.enterTextInZip(objPatientSchedule_data.strZip)

				.selState(objPatientSchedule_data.strState)
				.clickOnSavePatientData();
		objUserManagement.clickOnOkInAlertPopUp();
		Thread.sleep(3000);
		objPatientScheduleRegistration.clickOnDeletePatient();
		objUserManagement.clickOnOkInAlertPopUp();
		Thread.sleep(3000);
		objUserManagement.clickOnOkInAlertPopUp();
		Thread.sleep(3000);
		objPatientScheduleRegistration.clickOnLogOut();

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnViewPatients();

		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		Thread.sleep(3000);
		String[] studies = { objViewPatients_data.strStudy,
				objViewPatients_data.strStudy1, objViewPatients_data.strStudy2 };
		for (int i = 0; i < studies.length; i++) {
			objViewPatients.clickOnNewStudy();
			Thread.sleep(5000);
			objAutoIT.CreateStudy(strAutoitPath, studies[i], studies[i],
					strImagePath, objViewPatients_data.strModalityDS);
			Thread.sleep(3000);
			objViewPatients.enterTextInFind(studies[i])
					.selInLastOption(objDICOMSettings_data.hour)
					.clickOnSearch().clickOnSearch().clickOnSearch()
					.clickOnSearch().clickOnSearch()
					.verStudyFromOtherServer(studies[i]);
		}
		System.out.println(studies[1]
				+ " this is d study to which signed report is added");

		objViewPatients.enterTextInFind(studies[1]).clickOnSearch()
				.clickOnViewModifyWebReportsOfAStudy(studies[1]);
		String mw = driver.getWindowHandle();
		Iterator<String> itr2 = driver.getWindowHandles().iterator();
		while (itr2.hasNext()) {
			String cw = itr2.next().toString();
			if (!cw.contains(mw)) {
				driver.switchTo().window(cw);
				objViewPatients.clickOnAddButton();
				Iterator<String> itr1 = driver.getWindowHandles().iterator();
				while (itr1.hasNext()) {
					String cw1 = itr1.next().toString();
					if ((!cw1.contains(mw)) && (!cw1.contains(cw))) {
						driver.switchTo().window(cw1);
						objViewPatients.clickOnSaveReport();
					}
				}
				driver.switchTo().window(cw);
				objViewPatients.clickOnAddButton();
				Iterator<String> itr11 = driver.getWindowHandles().iterator();
				while (itr11.hasNext()) {
					String cw1 = itr11.next().toString();
					if ((!cw1.contains(mw)) && (!cw1.contains(cw))) {
						driver.switchTo().window(cw1);
						objViewPatients.clickOnSaveSignReport()
								.clickOnSignReport();
					}
				}
				driver.switchTo().window(cw);
				driver.close();
			}
		}
		driver.switchTo().window(mw);
		objViewPatients.enterTextInFind(studies[1]).clickOnSearch().clickOnSearch()
				.clickOnViewModifyWebReportsOfAStudy(studies[1]);
		Iterator<String> itr14 = driver.getWindowHandles().iterator();
		while (itr14.hasNext()) {
			String cw = itr14.next().toString();
			if (!cw.contains(mw)) {
				driver.switchTo().window(cw);
				objViewPatients.delReport();
				objUserManagement.clickOnOkInAlertPopUp();
				driver.close();

			}
		}
		driver.switchTo().window(mw);
		String rs = studies[1].substring(15);
		objViewPatients.enterTextInFind(rs).clickOnSearch()
				.selMarkStudyAsReadCheckbox(studies[1])
				.deSelMarkStudyAsReadCheckbox(studies[0])
				.clickOnModifyStudyIconOfAStudy(studies[1]);
		Iterator<String> itr1 = driver.getWindowHandles().iterator();
		while (itr1.hasNext()) {
			String cw = itr1.next().toString();
			if (!cw.contains(mw)) {
				driver.switchTo().window(cw);
				objViewPatients
						.selOneOrMoreCompleteSeriesInThisStudyRadioButton()
						.clickOnProceedButton()
						.clickOnSelAllInSplitMergeMoveWizard()
						.clickOnMoveInSplitMergeMoveWizard()
						.clickOnNewStudyInSplitMergeMoveWizard()
						.clickOnOKInSplitMergeMoveWizard();
			}
		}
		driver.switchTo().window(mw);

		objViewPatients.enterTextInFind(studies[1]).clickOnSearch()
				.clickOnReleaseStudyFromQc();
		Iterator<String> itr11 = driver.getWindowHandles().iterator();
		while (itr11.hasNext()) {
			String cw = itr11.next().toString();
			if (!cw.contains(mw)) {
				driver.switchTo().window(cw);
				objViewPatients.clickOnOkInReleaseStudyFromQcWindow()
						.clickOnCloseInMergeReportsPage();
			}
		}
		driver.switchTo().window(mw);
		objViewPatients.clickOnSearch().clickOnChangeStatStatusOfStudy();
		Iterator<String> itr12 = driver.getWindowHandles().iterator();
		while (itr12.hasNext()) {
			String cw = itr12.next().toString();
			if (!cw.contains(mw)) {
				driver.switchTo().window(cw);
				objViewPatients.clickOnCloseLink();
			}
		}
		for (int i = 0; i < 3; i++) {
			driver.switchTo().window(mw);
			objViewPatients.enterTextInFind(studies[0]).clickOnSearch()
					.clickOnSendThisStudyToDICOMStorageDevice(studies[0]);
			Iterator<String> itr13 = driver.getWindowHandles().iterator();
			while (itr13.hasNext()) {
				String cw = itr13.next().toString();
				if (!cw.contains(mw)) {
					driver.switchTo().window(cw);
					if (i == 0) {
						objViewPatients
								.selRecipientHTMLReportEMailRadioButton();
					} else if (i == 1) {
						objViewPatients
								.selRecipientPDFReportByEFaxRadioButton();
					} else {
						objViewPatients
								.selRecipientMWWAttachmentByEMailRadioButton();

					}
					objViewPatients.clickOnNextInSendStudyWizard()
							.enterTextInToField(objViewPatients_data.strUN)
							.clickOnFinishButton().clickOnFinishButton();
				}
			}
		}
		driver.switchTo().window(mw);
		objViewPatients.enterTextInFind(studies[2]).clickOnSearch()
				.delAPerticularStudy(studies[2]);
		objViewPatients.enterTextInFind(rs).clickOnSearch()
				.selStudy(studies[0]);
		objViewPatients.selStudy(studies[1]);
		objViewPatients.clickOnMergeReportsIcon();
		Iterator<String> itr13 = driver.getWindowHandles().iterator();
		while (itr13.hasNext()) {
			String cw = itr13.next().toString();
			if (!cw.contains(mw)) {
				driver.switchTo().window(cw);
				objViewPatients.selStudyInMergeReportsPage(studies[0])
						.clickOnYesInSplitMergeMoveWizard()
						.clickOnCloseInMergeReportsPage();
			}
		}
		driver.switchTo().window(mw);
		objViewPatients.enterTextInFind(studies[0]).clickOnSearch()
				.clickOnSendThisStudyToDICOMStorageDevice(studies[0]);
		Iterator<String> itrr1 = driver.getWindowHandles().iterator();
		while (itrr1.hasNext()) {
			String cw = itrr1.next().toString();
			if (!cw.contains(mw)) {
				driver.switchTo().window(cw);
				objViewPatients.selDICOMStorageDeviceRadioButton()
						.clickOnNextInSendStudyWizard()
						.selStorageDevice(objDICOMSettings_data.storageDevice1)
						.clickOnFinishButton().clickOnFinishButton();
			}
		}
		driver.switchTo().window(mw);
		objViewPatients.clickOnSearch().clickOnSearch().clickOnSearch()
				.clickOnSearch();
		/*
		 * create,report,signreport,read,unread,qcrelease,stat
		 * ,html,mww,pdfmail,delete,send,view
		 */
		objViewPatients.clickOnLogout();
		Thread.sleep(3000);

		String[] events = { objMedwebRadiologyStatistics_data.strEventOrder,
				objMedwebRadiologyStatistics_data.strEventCreatePatient,
				objMedwebRadiologyStatistics_data.strEventEditPatient,
				objMedwebRadiologyStatistics_data.strEventDeletePatient,

				objMedwebRadiologyStatistics_data.strEventCreate,
				objMedwebRadiologyStatistics_data.strEventNewReport,
				objMedwebRadiologyStatistics_data.strEventSignReport,
				objMedwebRadiologyStatistics_data.strEventDeleteReport,
				objMedwebRadiologyStatistics_data.strEventRead,
				objMedwebRadiologyStatistics_data.strEventQcReleased,
				objMedwebRadiologyStatistics_data.strEventStat,
				objMedwebRadiologyStatistics_data.strEventMerge,

				objMedwebRadiologyStatistics_data.strEventUnRead,
				objMedwebRadiologyStatistics_data.strEventMailHtml,
				objMedwebRadiologyStatistics_data.strEventMailMww,
				objMedwebRadiologyStatistics_data.strEventMailPdf,
				objMedwebRadiologyStatistics_data.strEventSend,
				objMedwebRadiologyStatistics_data.strEventMove,

				objMedwebRadiologyStatistics_data.strEventDelete,

				objMedwebRadiologyStatistics_data.strEventAssign,
				objMedwebRadiologyStatistics_data.strEventEdit,
				objMedwebRadiologyStatistics_data.strEventReceiveReport,
				objMedwebRadiologyStatistics_data.strEventReceiveReportSigned,
				objMedwebRadiologyStatistics_data.strEventSendReport,
				objMedwebRadiologyStatistics_data.strEventView,
				objMedwebRadiologyStatistics_data.strEventViewReport,
				objMedwebRadiologyStatistics_data.strEventViewZip };
		objHome.clickOnStatistics();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objStatistics.clickOnRadiology().clickOnEventsLogLink()
				.selTimePeriod(objMedwebRadiologyStatistics_data.strTimePeriod);
		for (int i = 0; i < events.length; i++) {
			objStatistics.selEventDropdownOption(events[i]).clickOnSearch();
			if (i == 0) {
				objStatistics.enterTextInFindField(str2).clickOnSearch().verStudyIsPresent(str2);
			}/* else if (i == 1) {
				objStatistics.enterTextInFindField(str5).clickOnSearch().verStudyIsPresent(str5);
			} else if (i == 2) {
				objStatistics.enterTextInFindField(str7).clickOnSearch().verStudyIsPresent(str7);
			} else if (i == 3) {
				objStatistics.enterTextInFindField(str9).clickOnSearch().verStudyIsPresent(str9);
			}*/
		else if (i == 18) {
				objStatistics.enterTextInFindField(studies[2]).clickOnSearch().verStudyIsPresent(studies[2]);
			}
			/*for (i = 4; i < 12; i++) {*/else if (i>3&&i<12) {
				objStatistics.enterTextInFindField(studies[1]).clickOnSearch().verStudyIsPresent(studies[1]);
			}

			/*for (i = 12; i < 18; i++) {*/else if (i>12&&i<18) {
				objStatistics.enterTextInFindField(studies[0]).clickOnSearch().verStudyIsPresent(studies[0]);
			}

		}
		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that "Study Date" showing the Date and Time when a Study is created
                     is displayed in the Events Log.     
    'Precondition  :
    'Date          : 23-Nov-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that Study Date showing the Date and Time when a Study is created is displayed in the Events Log.")
	public void testHappyDay125824() throws Exception {

		gstrTCID = "125824";
		gstrTO = "Verify that Study Date showing the Date and Time when a Study is created is displayed in the Events Log.";

		Login_data objLogin_data = new Login_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		Date_Time_settings dts = new Date_Time_settings();
		PathData objPathData = new PathData();
		MedwebRadiologyStatistics_data objMedwebRadiologyStatistics_data = new MedwebRadiologyStatistics_data();
		Home objHome = new Home(this.driver);
		Statistics objStatistics = new Statistics(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		ControlPanel objControlPanel = new ControlPanel(this.driver);
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
		objHome.verHomePage().clickOnAdminSite();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage().verUserManagementPage();
		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.clickOnTime();
		String str = objControlPanel.getCurrentDate();
		String str1 = objControlPanel.getCurrentMonth();
		String str2 = objControlPanel.getCurrentYear();
		String str3 = str + str1 + str2;
		System.out.println(str3 + "  str3");
		String str4 = dts.converDateFormat(str3, "ddMMMyyyy", "MM-dd-yyyy");
		System.out.println(str4);
		String str5 = objControlPanel.getCurrentHourIn24HrFrmt();
		String hr = dts.convert12HourTo24HourFormat(str5);
		String str6 = objControlPanel.getCurrentMinute();
		String mm1 = Integer.toString((Integer.parseInt(str6) + 1));
		String mm2 = Integer.toString((Integer.parseInt(str6) + 2));
		String req = dts.converDateFormat(str4 + hr + str6, "MM-dd-yyyyHHmm",
				"MM-dd-yyyy HH:mm");
		String req1 = dts.converDateFormat(str4 + hr + mm1, "MM-dd-yyyyHHmm",
				"MM-dd-yyyy HH:mm");
		String req2 = dts.converDateFormat(str4 + hr + mm2, "MM-dd-yyyyHHmm",
				"MM-dd-yyyy HH:mm");
		objNavigationToSubMenus.clickOnPublicSite();
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
		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnStatistics();
		objStatistics.clickOnRadiology().clickOnEventsLogLink()
				.selTimePeriod(objMedwebRadiologyStatistics_data.strTimePeriod)
				.enterTextInFindField(objViewPatients_data.strStudy)
				.clickOnSearch()
				.verStudyIsPresent(objViewPatients_data.strStudy)
				.verStudyDateAndTime(req, req1, req2);
		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that Addendum Reports added for study are displayed in Event Logs 
                     when "new_addendum" is selected from "Event" dropdown.     
    'Precondition  :
    'Date          : 29-Nov-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that Addendum Reports added for study are displayed in Event Logs "
			+ "when new_addendum is selected from Event dropdown.")
	public void testHappyDay169370() throws Exception {

		gstrTCID = "169370";
		gstrTO = "Verify that Addendum Reports added for study are displayed in Event Logs when "
				+ "new_addendum is selected from Event dropdown.";

		Login_data objLogin_data = new Login_data();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		MedwebRadiologyStatistics_data objMedwebRadiologyStatistics_data = new MedwebRadiologyStatistics_data();
		PathData objPathData = new PathData();
		Home objHome = new Home(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		Login objLogin = new Login(this.driver);
		Statistics objStatistics = new Statistics(this.driver);
		AutoIT objAutoIT = new AutoIT(this.driver);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();

		// autoIT CreateStudy File Path
		String autoItCreateStudy = pathProps
				.getProperty(objPathData.autoItFilePath2);
		File autoitfile = new File(System.getProperty("user.dir")
				+ autoItCreateStudy);
		String strAutoitPath = autoitfile.toString();
		System.out.println(strAutoitPath + 1);

		// image
		String imagePath = pathProps.getProperty(objPathData.sudyWithImage);
		System.out.println(imagePath);
		File imageFile = new File(System.getProperty("user.dir") + imagePath);
		String strImagePath = imageFile.toString();

		objHome.launchApplication(objLogin_data.strAppURL);
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
		System.out.println(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch1();
		objViewPatients
				.clickOnViewModifyWebReportsOfAStudy(objViewPatients_data.strStudy);
		String mainwindowhandle = driver.getWindowHandle();
		Set<String> windowhandles = driver.getWindowHandles();
		Iterator<String> ite = windowhandles.iterator();
		while (ite.hasNext()) {
			String childwindow = ite.next().toString();
			if (!childwindow.contains(mainwindowhandle)) {
				driver.switchTo().window(childwindow);

				objViewPatients.verWebReporterPage("Web-Reporter")
						.clickOnAddButton();
				Set<String> allwindows = driver.getWindowHandles();
				Iterator<String> ite1 = allwindows.iterator();
				while (ite1.hasNext()) {
					String childwindow1 = ite1.next().toString();
					if ((!childwindow1.contains(childwindow))
							&& (!childwindow1.contains(mainwindowhandle))) {
						driver.switchTo().window(childwindow1);
						objViewPatients.clickOnSaveSignReport()
								.clickOnSignReport();
						Thread.sleep(5000);

					}
				}

				driver.switchTo().window(childwindow);
				objViewPatients.clickOnNewAddEndumIcon();
				Set<String> allwindows1 = driver.getWindowHandles();
				Iterator<String> ite11 = allwindows1.iterator();
				while (ite11.hasNext()) {
					String childwindow11 = ite11.next().toString();
					if ((!childwindow11.contains(mainwindowhandle))
							&& (!childwindow11.contains(childwindow))) {
						driver.switchTo().window(childwindow11);
						objViewPatients
								.enterTextInReferringPhysicianFieldInAddendumReportEditorPage(
										objViewPatients_data.strRefPhyConstant)
								.clickOnSaveAndSignAddendum()
								.clickOnSignReport();

					}
				}
				driver.switchTo().window(childwindow);
				driver.close();
			}
		}
		driver.switchTo().window(mainwindowhandle);
		objViewPatients.clickOnLogout();
		Thread.sleep(5000);
		objHome.clickOnStatistics();
		Thread.sleep(2000);
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objStatistics
				.clickOnRadiology()
				.clickOnEventsLogLink()
				.selEventDropdownOption(
						objMedwebRadiologyStatistics_data.strnewAddendum)
				.enterTextInFindField(objViewPatients_data.strStudy).clickOnSearch()
				.verStudyIsPresent(objViewPatients_data.strStudy);

		gstrResult = "PASS";

	}
	
	/*************************************************************************************
    'Description   : Verify that "Create Date" displaying the Date and Time when the study is 
                     received from another Server is displayed in the Events Log.     
    'Precondition  :
    'Date          : 12-Dec-2016
    'Author        : Hanumegowda
    '---------------------------------------------------------------
    'Modified Date                                               Modified By
    'Date                                                         Name
	**************************************************************************************/
	@Test(description = "Verify that Create Date displaying the Date and Time when the study is"
			+ " received from another Server is displayed in the Events Log.")
	public void testHappyDay125825() throws Exception {

		gstrTCID = "125825";
		gstrTO = "Verify that Create Date displaying the Date and Time when the study is received "
				+ "from another Server is displayed in the Events Log.";

		Login_data objLogin_data = new Login_data();
		MedwebRadiologyStatistics_data objMedwebRadiologyStatistics_data = new MedwebRadiologyStatistics_data();
		PathData objPathData = new PathData();
		ViewPatients_data objViewPatients_data = new ViewPatients_data();
		DICOMSettings_data objDICOMSettings_data = new DICOMSettings_data();
		Date_Time_settings dts = new Date_Time_settings();

		Home objHome = new Home(this.driver);
		CommonFunctions objCommonFunctions = new CommonFunctions(this.driver);
		AdministratorSite objAdministratorSite = new AdministratorSite(
				this.driver);
		DICOMSetting objDICOMSetting = new DICOMSetting(this.driver);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				this.driver);
		ControlPanel objControlPanel = new ControlPanel(this.driver);
		ViewPatients objViewPatients = new ViewPatients(this.driver);
		Destinations objDestinations = new Destinations(this.driver);
		AETitleRouting objAETitleRouting = new AETitleRouting(this.driver);
		Login objLogin = new Login(this.driver);
		Statistics objStatistics = new Statistics(this.driver);
		AutoIT objAutoIT = new AutoIT(this.driver);

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();

		String fileAutoITDownloadPath = pathProps
				.getProperty(objPathData.autoItFilePath5);
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

		objHome.launchApplication(objLogin_data.strAppURL1);
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objHome.verHomePage().clickOnAdminSite();
		objCommonFunctions.clickOnContinueToThisWebsiteLink();
		objLogin.login(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();
		objAdministratorSite.verAdministratorSitePage();
		objNavigationToSubMenus.clickOnDICOMSettings();
		objDICOMSetting.clickOnDestinations();
		objDestinations.clickOnAdd().verDestinationEditorPage();
		objDestinations.selectGenericStorageSCPCheckBox()
				.selectGenericStorageSCUCheckBox().selectMedwebDeviceCheckBox()
				.selectMitraReportSCPCheckBox().selectMitraReportSCUCheckBox()
				.selectReceiveDSMECheckBox().selectRetrievePatientSCPCheckBox()
				.selectRetrievePatientSCUCheckBox()
				.selectRetrievePatientStudySCPCheckBox()
				.selectRetrievePatientStudySCUCheckBox()
				.selectRetrieveStudySCPCheckBox()
				.selectRetrieveStudySCUCheckBox();
		objDestinations.enterTextInAETitleField(objDICOMSettings_data.aETitle2)
				.enterTextInDICOMIPPortField(objDICOMSettings_data.dICOMIPPort)
				.enterTextInIPAddressField(objDICOMSettings_data.ipAddress1)
				.enterTextInLabelField(objDICOMSettings_data.label1)
				.selDICOMProtocolRadioButton()
				.selRouteEngineType(objDICOMSettings_data.routeEngineEnhanced);
		objDestinations.clickOnSaveChanges();
		objDICOMSetting.clickOnAETitleRouting1();
		boolean actual = objAETitleRouting.delAllExistingRoute();
		while (actual == true) {
			objNavigationToSubMenus.clickOnDICOMSettingsForSecondTime();
			objDICOMSetting.clickOnAETitleRouting();
			actual = objAETitleRouting.delAllExistingRoute();
			System.out.println(actual + " aa");

		}

		objNavigationToSubMenus.clickOnControlPanel();
		objControlPanel.clickOnTime1();
		String str = objControlPanel.getCurrentDate();
		String str1 = objControlPanel.getCurrentMonth();
		String str2 = objControlPanel.getCurrentYear();
		String strhr = objControlPanel.getCurrentHourIn24HrFrmt();
		String strmin = objControlPanel.getCurrentMinute();
		String str3 = str + str1 + str2 + strhr + strmin;
		String str3p1 = str + str1 + str2 + strhr
				+ (Integer.toString((Integer.parseInt(strmin)) + 1));
		String str3p2 = str + str1 + str2 + strhr
				+ (Integer.toString((Integer.parseInt(strmin)) + 2));
		String str4 = dts.converDateFormat(str3, "ddMMMyyyyHHmm",
				"MM-dd-yyyy HH:mm");
		String str4p1 = dts.converDateFormat(str3p1, "ddMMMyyyyHHmm",
				"MM-dd-yyyy HH:mm");
		String str4p2 = dts.converDateFormat(str3p2, "ddMMMyyyyHHmm",
				"MM-dd-yyyy HH:mm");
		String min = dts.getCurrentDate("mm");
		String req = dts.getCurrentDate("MM-dd-yyyy HH");
		String reqp1 = req + ":" + min;
		String reqp2 = req + ":"
				+ (Integer.toString((Integer.parseInt(min)) + 1));
		String reqp3 = req + ":"
				+ (Integer.toString((Integer.parseInt(min)) + 2));

		objNavigationToSubMenus.clickOnPublicSite();
		objHome.clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();

		objViewPatients.clickOnNewStudy();
		Thread.sleep(5000);
		objAutoIT.CreateStudy1(strAutoitPath, objViewPatients_data.strStudy,
				objViewPatients_data.strStudy, strImagePath,
				objViewPatients_data.strModalityDS,
				objViewPatients_data.strRefPhy);
		Thread.sleep(3000);
		System.out.println(objViewPatients_data.strStudy);
		objViewPatients.selInLastOption(objDICOMSettings_data.hour)
				.enterTextInFind(objViewPatients_data.strStudy);
		objViewPatients.clickOnSearch1()
				.clickOnSendThisStudyToDICOMStorageDevice(
						objViewPatients_data.strStudy);
		String mainWindow = driver.getWindowHandle();
		Set<String> str11 = driver.getWindowHandles();
		Iterator<String> itr = str11.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next().toString();
			System.out.println(childwindow + "firstcldwnd");
			if (!childwindow.contains(mainWindow)) {
				driver.switchTo().window(childwindow);
				objCommonFunctions.clickOnContinueToThisWebsiteLink();
				objViewPatients.selDICOMStorageDeviceRadioButton()
						.clickOnNextInSendStudyWizard()
						.selStorageDevice(objDICOMSettings_data.storageDevice)
						.clickOnFinishButton();
				Thread.sleep(3000);
				objViewPatients.clickOnFinishButton();
			}
		}

		driver.switchTo().window(mainWindow);
		objViewPatients.clickOnSearchTillStudySent();

		objHome.launchApplication(objLogin_data.strAppURL);
		objHome.verHomePage().clickOnViewPatients();
		objLogin.loginAsUser(objLogin_data.strAdminUser,
				objLogin_data.strAdminUserPwd).clickLogin();

		objViewPatients.enterTextInFind(objViewPatients_data.strStudy)
				.clickOnSearch()
				.verStudyFromOtherServer(objViewPatients_data.strStudy);
		objHome.clickOnStatistics();
		objStatistics.clickOnRadiology().clickOnEventsLogLink()
				.selTimePeriod(objMedwebRadiologyStatistics_data.strTimePeriod)
				.enterTextInFindField(objViewPatients_data.strStudy)
				.clickOnSearch().verStudyCreateDate(str4, str4p1, str4p2)
				.verStudyDate(reqp1, reqp2, reqp3);

		objViewPatients.clickOnLogout();

		gstrResult = "PASS";

	}

}
