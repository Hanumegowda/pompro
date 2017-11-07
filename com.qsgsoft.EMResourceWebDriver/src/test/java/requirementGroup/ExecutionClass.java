package requirementGroup;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.Roles_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.EventManagement;
import lib.page.Login;
import lib.page.MailVerificationFunctions;
import lib.page.Map;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.Roles;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UpdateStatus;
import lib.page.UsersList;
import lib.page.ViewsList;
import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class ExecutionClass extends TestNG_UI_EXTENSIONS  {


	public ExecutionClass() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/*****************************************************************************************************
	 * 'Description : Create all 36 types of status types. 
	 * 'Date 		: 20-Oct-2014 
	 * 'Author 		: Pallavi
	 ******************************************************************************************************/
	@Test(description = "Create all 36 types of status types.")
	public void create36STs() throws Exception {

		gstrTCID = "";
		gstrTO = "";

		Login objLogin = new Login(this.driver);
		Login_data objTest_data = new Login_data();
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver);
		RegionDefault objRegionDefault = new RegionDefault(this.driver);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		ViewsList objViewsList = new ViewsList(this.driver);

		String strStatusTypeValues[] = new String[18];
		String strEventStatusTypeValues[] = new String[18];
		

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegionpage
        	.selectRegionAndNavigate("SMSTest Region New");

		objRegionDefault.selectFrame();
		
		objNavigationToSubmenus.navigateToViews();
		
		objViewsList.clickOncustomizeResourceDetailView()
		        .enterSectionName("14Sep-section")
		        .clickOnCreateSection()
		        .verCreatedSection("14Sep-section")
		        .clickOnSaveButton();
		
		objNavigationToSubmenus.navigateToStatusTypesInSetup();
		
		objStatusTypeList.createSharedStatusTypeWithSection(
		        objStatusTypes_data.strNumberStatusType,
		        "14SepST1-sNST",
		        objStatusTypes_data.strStatusDescription,
		        "14Sep-section");
		strStatusTypeValues[0] = objStatusTypeList
		        .getStatusValue("14SepST1-sNST");
		
		objStatusTypeList.createSharedStatusTypeWithSection(
		        objStatusTypes_data.strMultiStatusType,
		        "14SepST1-sMST",
		        objStatusTypes_data.strStatusDescription,
		        "14Sep-section")
				.createNewStatus("S1", "Black")
				.createNewStatus("S2", "Blue")
				.createNewStatus("S3", "Green")
				.verCreatedStatusInStatusListForMulti("S1")
				.verCreatedStatusInStatusListForMulti("S2")
				.verCreatedStatusInStatusListForMulti("S3")
				.clickOnReturnToStatusTypeList();
		
		strStatusTypeValues[1] = objStatusTypeList
		        .getStatusValue("14SepST1-sMST");;
		
		objStatusTypeList.createSharedStatusTypeWithSection(
		        objStatusTypes_data.strTextStatusType,
		        "14SepST1-sTST",
		        objStatusTypes_data.strStatusDescription,
		        "14Sep-section");
		strStatusTypeValues[2] = objStatusTypeList
		        .getStatusValue("14SepST1-sTST");
		
		objStatusTypeList.createSharedStatusTypeWithSection(
		        objStatusTypes_data.strSaturationScoreStatusType,
		        "14SepST1-sSST",
		        objStatusTypes_data.strStatusDescription,
		        "14Sep-section");
		strStatusTypeValues[3] = objStatusTypeList
		        .getStatusValue("14SepST1-sSST");
		
		objStatusTypeList.createSharedStatusTypeWithSection(
		        objStatusTypes_data.strNedocCalculationStatusType,
		        "14SepST1-sNDST",
		        objStatusTypes_data.strStatusDescription,
		        "14Sep-section");
		strStatusTypeValues[4] = objStatusTypeList
		        .getStatusValue("14SepST1-sNDST");
		
		objStatusTypeList.createSharedStatusTypeWithSection(
		        objStatusTypes_data.strDateStatusType,
		        "14SepST1-sDST",
		        objStatusTypes_data.strStatusDescription,
		        "14Sep-section");
		strStatusTypeValues[5] = objStatusTypeList
		        .getStatusValue("14SepST1-sDST");
		
		objStatusTypeList.createStatusTypeWithSection(
		        objStatusTypes_data.strNumberStatusType,
		        "14SepST1-rNST",
		        objStatusTypes_data.strStatusDescription,
		        "14Sep-section");
		strStatusTypeValues[6] = objStatusTypeList
		        .getStatusValue("14SepST1-rNST");
		
		objStatusTypeList.createSharedStatusTypeWithEventSection(
		        objStatusTypes_data.strNumberStatusType,
		        "14SepST1-esNST",
		        objStatusTypes_data.strStatusDescription,
		        "14Sep-section");
		strEventStatusTypeValues[0] = objStatusTypeList
		        .getStatusValue("14SepST1-esNST");
		
		objStatusTypeList.createSharedStatusTypeWithEventSection(
		        objStatusTypes_data.strMultiStatusType,
		        "14SepST1-seMST",
		        objStatusTypes_data.strStatusDescription,
		        "14Sep-section")
		        .createNewStatus("S11", "Black")
				.createNewStatus("S12", "Blue")
				.createNewStatus("S13", "Green")
				.verCreatedStatusInStatusListForMulti("S11")
				.verCreatedStatusInStatusListForMulti("S12")
				.verCreatedStatusInStatusListForMulti("S13")
				.clickOnReturnToStatusTypeList();
		strEventStatusTypeValues[1] = objStatusTypeList
		        .getStatusValue("14SepST1-seMST");
		
		objStatusTypeList.createSharedStatusTypeWithEventSection(
		        objStatusTypes_data.strTextStatusType,
		        "14SepST1-esTST",
		        objStatusTypes_data.strStatusDescription,
		        "14Sep-section");
		strEventStatusTypeValues[2] = objStatusTypeList
		        .getStatusValue("14SepST1-esTST");
		
		objStatusTypeList.createSharedStatusTypeWithEventSection(
		        objStatusTypes_data.strSaturationScoreStatusType,
		        "14SepST1-esSST",
		        objStatusTypes_data.strStatusDescription,
		        "14Sep-section");
		strEventStatusTypeValues[3] = objStatusTypeList
		         .getStatusValue("14SepST1-esSST");
		
		objStatusTypeList.createSharedStatusTypeWithEventSection(
		        objStatusTypes_data.strNedocCalculationStatusType,
		        "14SepST1-esNDST",
		        objStatusTypes_data.strStatusDescription,
		        "14Sep-section");
		strEventStatusTypeValues[4] = objStatusTypeList
		        .getStatusValue("14SepST1-esNDST");
		
		objStatusTypeList.createSharedStatusTypeWithEventSection(
		        objStatusTypes_data.strDateStatusType,
		        "14SepST1-esDST",
		        objStatusTypes_data.strStatusDescription,
		        "14Sep-section");
		strEventStatusTypeValues[5] = objStatusTypeList
		        .getStatusValue("14SepST1-esDST");
		
		objStatusTypeList.createEventStatusTypeWithSection(
		        objStatusTypes_data.strNumberStatusType,
		        "14SepST1-reNST",
		        objStatusTypes_data.strStatusDescription,
		        "14Sep-section");
		strEventStatusTypeValues[6] = objStatusTypeList
		        .getStatusValue("14SepST1-reNST");
		
		objStatusTypeList.createEventStatusTypeWithSection(
		        objStatusTypes_data.strMultiStatusType,
		        "14SepST1-reMST",
		        objStatusTypes_data.strStatusDescription,
		        "14Sep-section")
		        .createNewStatus("S21", "Black")
				.createNewStatus("S22", "Blue")
				.createNewStatus("S23", "Green")
				.verCreatedStatusInStatusListForMulti("S21")
				.verCreatedStatusInStatusListForMulti("S22")
				.verCreatedStatusInStatusListForMulti("S23")
				.clickOnReturnToStatusTypeList();
		strEventStatusTypeValues[7] = objStatusTypeList
		        .getStatusValue("14SepST1-reMST");
		
		objStatusTypeList.createEventStatusTypeWithSection(
		        objStatusTypes_data.strTextStatusType,
		        "14SepST1-reTST",
		        objStatusTypes_data.strStatusDescription,
		        "14Sep-section");
		strEventStatusTypeValues[8] = objStatusTypeList
		        .getStatusValue("14SepST1-reTST");
		
		objStatusTypeList.createEventStatusTypeWithSection(
		        objStatusTypes_data.strSaturationScoreStatusType,
		        "14SepST1-reSST",
		        objStatusTypes_data.strStatusDescription,
		        "14Sep-section");
		strEventStatusTypeValues[9] = objStatusTypeList
		        .getStatusValue("14SepST1-reSST");
		
		objStatusTypeList.createEventStatusTypeWithSection(
		        objStatusTypes_data.strNedocCalculationStatusType,
		        "14SepST1-reNDST",
		        objStatusTypes_data.strStatusDescription,
		        "14Sep-section");
		strEventStatusTypeValues[10] = objStatusTypeList
		        .getStatusValue("14SepST1-reNDST");
		
		objStatusTypeList.createEventStatusTypeWithSection(
		        objStatusTypes_data.strDateStatusType,
		        "14SepST1-reDST",
		        objStatusTypes_data.strStatusDescription,
		        "14Sep-section");
		strEventStatusTypeValues[11] = objStatusTypeList
		        .getStatusValue("14SepST1-reDST");
		
		objStatusTypeList.createPrivateStatusTypeWithEventSection(
		        objStatusTypes_data.strNumberStatusType,
		        "14SepST1-peNST",
		        objStatusTypes_data.strStatusDescription,
		        "14Sep-section");
		strEventStatusTypeValues[12] = objStatusTypeList
		        .getStatusValue("14SepST1-peNST");
		
		objStatusTypeList.createPrivateStatusTypeWithEventSection(
		        objStatusTypes_data.strMultiStatusType,
		        "14SepST1-peMST",
		        objStatusTypes_data.strStatusDescription,
		        "14Sep-section")
		        .createNewStatus("S31", "Black")
				.createNewStatus("S32", "Blue")
				.createNewStatus("S33", "Green")
				.verCreatedStatusInStatusListForMulti("S31")
				.verCreatedStatusInStatusListForMulti("S32")
				.verCreatedStatusInStatusListForMulti("S33")
				.clickOnReturnToStatusTypeList();
		strEventStatusTypeValues[13] = objStatusTypeList
		        .getStatusValue("14SepST1-peMST");
		
		objStatusTypeList.createPrivateStatusTypeWithEventSection(
		        objStatusTypes_data.strTextStatusType,
		        "14SepST1-peTST",
		        objStatusTypes_data.strStatusDescription,
		        "14Sep-section");
		strEventStatusTypeValues[14] = objStatusTypeList
		        .getStatusValue("14SepST1-peTST");
		
		objStatusTypeList.createPrivateStatusTypeWithEventSection(
		        objStatusTypes_data.strSaturationScoreStatusType,
		        "14SepST1-peSST",
		        objStatusTypes_data.strStatusDescription,
		        "14Sep-section");
		strEventStatusTypeValues[15] = objStatusTypeList
		        .getStatusValue("14SepST1-peSST");
		
		objStatusTypeList.createPrivateStatusTypeWithEventSection(
		        objStatusTypes_data.strNedocCalculationStatusType,
		        "14SepST1-peNDST",
		        objStatusTypes_data.strStatusDescription,
		        "14Sep-section");
		strEventStatusTypeValues[16] = objStatusTypeList
		        .getStatusValue("14SepST1-peNDST");
		
		objStatusTypeList.createPrivateStatusTypeWithEventSection(
		         objStatusTypes_data.strDateStatusType,
		         "14SepST1-peDST",
		        objStatusTypes_data.strStatusDescription,
		        "14Sep-section");
		strEventStatusTypeValues[17] = objStatusTypeList
		        .getStatusValue("14SepST1-peDST");
		
		objStatusTypeList.createStatusTypeWithSection(
		        objStatusTypes_data.strMultiStatusType,
		        "14SepST1-rMST",
		        objStatusTypes_data.strStatusDescription,
		        "14Sep-section")
		        .createNewStatus("S41", "Black")
				.createNewStatus("S42", "Blue")
				.createNewStatus("S43", "Green")
				.verCreatedStatusInStatusListForMulti("S41")
				.verCreatedStatusInStatusListForMulti("S42")
				.verCreatedStatusInStatusListForMulti("S43")
				.clickOnReturnToStatusTypeList();
		strStatusTypeValues[7] = objStatusTypeList
		        .getStatusValue("14SepST1-rMST");
		
		objStatusTypeList.createStatusTypeWithSection(
		        objStatusTypes_data.strTextStatusType,
		        "14SepST1-rTST",
		        objStatusTypes_data.strStatusDescription,
		        "14Sep-section");
		strStatusTypeValues[8] = objStatusTypeList
		        .getStatusValue("14SepST1-rTST");
		
		objStatusTypeList.createStatusTypeWithSection(
		        objStatusTypes_data.strSaturationScoreStatusType,
		        "14SepST1-rSST",
		        objStatusTypes_data.strStatusDescription,
		        "14Sep-section");
		strStatusTypeValues[9] = objStatusTypeList
		        .getStatusValue("14SepST1-rSST");
		
		objStatusTypeList.createStatusTypeWithSection(
		        objStatusTypes_data.strNedocCalculationStatusType,
		        "14SepST1-rNDST",
		        objStatusTypes_data.strStatusDescription,
		        "14Sep-section");
		strStatusTypeValues[10] = objStatusTypeList
		        .getStatusValue("14SepST1-rNDST");
		
		objStatusTypeList.createStatusTypeWithSection(
		        objStatusTypes_data.strDateStatusType,
		        "14SepST1-rDST",
		        objStatusTypes_data.strStatusDescription,
		        "14Sep-section");
		strStatusTypeValues[11] = objStatusTypeList
		        .getStatusValue("14SepST1-rDST");
		
		objStatusTypeList.createPrivateStatusTypeWithSection(
		        objStatusTypes_data.strNumberStatusType,
		        "14SepST1-pNST",
		        objStatusTypes_data.strStatusDescription,
		        "14Sep-section");
		strStatusTypeValues[12] = objStatusTypeList
		        .getStatusValue("14SepST1-pNST");
		
		objStatusTypeList.createPrivateStatusTypeWithSection(
		        objStatusTypes_data.strMultiStatusType,
		        "14SepST1-pMST",
		        objStatusTypes_data.strStatusDescription,
		        "14Sep-section")
		        .createNewStatus("S51", "Black")
				.createNewStatus("S52", "Blue")
				.createNewStatus("S53", "Green")
				.verCreatedStatusInStatusListForMulti("S51")
				.verCreatedStatusInStatusListForMulti("S52")
				.verCreatedStatusInStatusListForMulti("S53")
				.clickOnReturnToStatusTypeList();
		strStatusTypeValues[13] = objStatusTypeList
		        .getStatusValue("14SepST1-pMST");
		
		objStatusTypeList.createPrivateStatusTypeWithSection(
		        objStatusTypes_data.strTextStatusType,
		        "14SepST1-pTST",
		        objStatusTypes_data.strStatusDescription,
		        "14Sep-section");
		strStatusTypeValues[14] = objStatusTypeList
		        .getStatusValue("14SepST1-pTST");
		
		objStatusTypeList.createPrivateStatusTypeWithSection(
		        objStatusTypes_data.strSaturationScoreStatusType,
		        "14SepST1-pSST",
		        objStatusTypes_data.strStatusDescription,
		        "14Sep-section");
		strStatusTypeValues[15] = objStatusTypeList
		        .getStatusValue("14SepST1-pSST");
		
		objStatusTypeList.createPrivateStatusTypeWithSection(
		        objStatusTypes_data.strNedocCalculationStatusType,
		        "14SepST1-pNDST",
		        objStatusTypes_data.strStatusDescription,
		        "14Sep-section");
		strStatusTypeValues[16] = objStatusTypeList
		        .getStatusValue("14SepST1-pNDST");
		
		objStatusTypeList.createPrivateStatusTypeWithSection(
		        objStatusTypes_data.strDateStatusType,
		        "14SepST1-pDST",
		        objStatusTypes_data.strStatusDescription,
		        "14Sep-section");
		strStatusTypeValues[17] = objStatusTypeList
		        .getStatusValue("14SepST1-pDST");
	}
	
}