package requirementGroup.SettingUpStatusTypes;

import lib.dataObject.Login_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class NewHappyDayCommonScenarios extends TestNG_UI_EXTENSIONS {

	public NewHappyDayCommonScenarios() throws Exception {
		super();
	}

	/*************************************************************************************
	 * 'Description : Visibility of the status type can be changed only by
	 * system admin users. 'Precondition: 'Date : 19-May-2015 'Author : Anil
	 * '---------------------------------------------------------------
	 * 'Modified Date Modified By 'Date Name
	 **************************************************************************************/
	@Test(description = "Visibility of the status type can be changed only by system admin users. ")
	public void testHappyDay48711() throws Exception {

		gstrTCID = "48711";
		gstrTO = "Visibility of the status type can be changed only by system admin users. ";

		Login_data objLogindata = new Login_data();
		User_data objUser_data = new User_data();

		Login objLogin = new Login(this.driver1);
		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);

		Login objLogin1 = new Login(this.driver1);
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();

		objLogin.loginToApplication(objLogindata.strUserName,
				objLogindata.strPassword);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objUsersList
				.navigateToUsers()
				.clickCreateNewUserButton()
				.enterUserDetails(objUser_data.strNewUserName,
						objUser_data.strNewPassword, objUser_data.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectSetupStatusTypesOption().clickSaveButton();

		objStatusTypeList.navigateToStatusTypeListNew();

		objStatusTypeList.clickCreateNewStatusTypeButton();
		objStatusTypeList.verifySelectStatusTypePage();
		objStatusTypeList
				.selectStatusType(objStatusTypes_data.strNumberStatusType);
		objStatusTypeList.clickNextButton();
		objStatusTypeList.verifyCreateNumberStatusTypePage();
		objStatusTypeList.verifyStatusTypeVisibilityOptionISEnabled();
		objStatusTypeList.verifyRoleBasedStatusTypes();
		objStatusTypeList
				.enterStatusTypeName(objStatusTypes_data.strNSTStatusTypeName);
		objStatusTypeList
				.enterStatusTypeDescription(objStatusTypes_data.strStatusDescription);
		objStatusTypeList.clickOnSaveButton();

		objStatusTypeList
				.verifyStatusTypeInList(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList.clickCreateNewStatusTypeButton();
		objStatusTypeList.verifySelectStatusTypePage();
		objStatusTypeList
				.selectStatusType(objStatusTypes_data.strMultiStatusType);
		objStatusTypeList.clickNextButton();
		objStatusTypeList.verifyCreateMultiStatusTypePage();
		objStatusTypeList.verifyStatusTypeVisibilityOptionISEnabled();
		objStatusTypeList.verifyRoleBasedStatusTypes();
		objStatusTypeList
				.enterStatusTypeName(objStatusTypes_data.strMSTStatusTypeName);
		objStatusTypeList
				.enterStatusTypeDescription(objStatusTypes_data.strStatusDescription);
		objStatusTypeList.clickOnSaveButton()
						.createNewStatus(
					     objStatusTypes_data.strStatusNameInMulti,
					     objStatusTypes_data.strStatusColor)
					  .createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
					      objStatusTypes_data.strStatusColor)
					  .verCreatedStatusInStatusListForMulti(
					      objStatusTypes_data.strStatusNameInMulti)
					  .verCreatedStatusInStatusListForMulti(
					      objStatusTypes_data.strStatusNameInMulti1)
					  .clickOnReturnToStatusTypeList();
		
		objStatusTypeList
				.verifyStatusTypeInList(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList.clickCreateNewStatusTypeButton();
		objStatusTypeList.verifySelectStatusTypePage();
		objStatusTypeList
				.selectStatusType(objStatusTypes_data.strTextStatusType);
		objStatusTypeList.clickNextButton();
		objStatusTypeList.verifyCreateTextStatusTypePage();
		objStatusTypeList.verifyStatusTypeVisibilityOptionISEnabled();
		objStatusTypeList.verifyRoleBasedStatusTypes();
		objStatusTypeList
				.enterStatusTypeName(objStatusTypes_data.strTSTStatusTypeName);
		objStatusTypeList
				.enterStatusTypeDescription(objStatusTypes_data.strStatusDescription);
		objStatusTypeList.clickOnSaveButton();

		objStatusTypeList
				.verifyStatusTypeInList(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList.clickCreateNewStatusTypeButton();
		objStatusTypeList.verifySelectStatusTypePage();
		objStatusTypeList
				.selectStatusType(objStatusTypes_data.strSaturationScoreStatusType);
		objStatusTypeList.clickNextButton();
		objStatusTypeList.verifyCreateSaturationStatusTypePage();
		objStatusTypeList.verifyStatusTypeVisibilityOptionISEnabled();
		objStatusTypeList.verifyRoleBasedStatusTypes();
		objStatusTypeList
				.enterStatusTypeName(objStatusTypes_data.strSSTStatusTypeName);
		objStatusTypeList
				.enterStatusTypeDescription(objStatusTypes_data.strStatusDescription);
		objStatusTypeList.clickOnSaveButton();

		objStatusTypeList
				.verifyStatusTypeInList(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList.clickCreateNewStatusTypeButton();
		objStatusTypeList.verifySelectStatusTypePage();
		objStatusTypeList
				.selectStatusType(objStatusTypes_data.strNedocCalculationStatusType);
		objStatusTypeList.clickNextButton();
		objStatusTypeList.verifyCreateNedocStatusTypePage();
		objStatusTypeList.verifyStatusTypeVisibilityOptionISEnabled();
		objStatusTypeList.verifyRoleBasedStatusTypes();
		objStatusTypeList
				.enterStatusTypeName(objStatusTypes_data.strNDSTStatusTypeName);
		objStatusTypeList
				.enterStatusTypeDescription(objStatusTypes_data.strStatusDescription);
		objStatusTypeList.clickOnSaveButton();

		objStatusTypeList
				.verifyStatusTypeInList(objStatusTypes_data.strNDSTStatusTypeName);

		objStatusTypeList
				.clickOnEditOfStatusType(objStatusTypes_data.strNSTStatusTypeName);
		objStatusTypeList.verifyRoleBasedStatusTypes();
		objStatusTypeList.verifyEditNumberStatusTypePage();
		objStatusTypeList.selectSharedStatusTypeRadioBtn();
		objStatusTypeList.clickOnSaveButton();

		objStatusTypeList
				.verifyStatusTypeInList(objStatusTypes_data.strNSTStatusTypeName);

		objStatusTypeList
				.clickOnEditOfStatusType(objStatusTypes_data.strMSTStatusTypeName);
		objStatusTypeList.verifyRoleBasedStatusTypes();
		objStatusTypeList.verifyEditMultiStatusTypePage();
		objStatusTypeList.selectSharedStatusTypeRadioBtn();
		objStatusTypeList.clickOnSaveButton();

		objStatusTypeList
				.verifyStatusTypeInList(objStatusTypes_data.strMSTStatusTypeName);

		objStatusTypeList
				.clickOnEditOfStatusType(objStatusTypes_data.strSSTStatusTypeName);
		objStatusTypeList.verifyRoleBasedStatusTypes();
		objStatusTypeList.verifyEditSaturationStatusTypePage();
		objStatusTypeList.selectSharedStatusTypeRadioBtn();
		objStatusTypeList.clickOnSaveButton();

		objStatusTypeList
				.verifyStatusTypeInList(objStatusTypes_data.strSSTStatusTypeName);

		objStatusTypeList
				.clickOnEditOfStatusType(objStatusTypes_data.strTSTStatusTypeName);
		objStatusTypeList.verifyRoleBasedStatusTypes();
		objStatusTypeList.verifyEditTextStatusTypePage();
		objStatusTypeList.selectSharedStatusTypeRadioBtn();
		objStatusTypeList.clickOnSaveButton();

		objStatusTypeList
				.verifyStatusTypeInList(objStatusTypes_data.strTSTStatusTypeName);

		objStatusTypeList
				.clickOnEditOfStatusType(objStatusTypes_data.strNDSTStatusTypeName);
		objStatusTypeList.verifyRoleBasedStatusTypes();
		objStatusTypeList.verifyEditNedocStatusTypePage();
		objStatusTypeList.selectSharedStatusTypeRadioBtn();
		objStatusTypeList.clickOnSaveButton();

		objStatusTypeList
				.verifyStatusTypeInList(objStatusTypes_data.strNDSTStatusTypeName);
		objLogin1.clickLogOut();

		objLogin1.loginAsNewUser(objUser_data.strNewUserName,
				objUser_data.strNewPassword);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.clickCreateNewStatusTypeButton();
		objStatusTypeList.verifySelectStatusTypePage();
		objStatusTypeList
				.selectStatusType(objStatusTypes_data.strNumberStatusType);
		objStatusTypeList.clickNextButton();
		objStatusTypeList.verifyCreateNumberStatusTypePage();
		objStatusTypeList.verifyStatusTypeVisibilityOptionISEnabled();//Design change, user is able to edit status type visibility option
		objStatusTypeList.verifyRoleBasedStatusTypes();
		objStatusTypeList
				.enterStatusTypeName(objStatusTypes_data.strNSTStatusTypeName1);
		objStatusTypeList
				.enterStatusTypeDescription(objStatusTypes_data.strStatusDescription);
		objStatusTypeList.clickOnSaveButton();

		objStatusTypeList
				.verifyStatusTypeInList(objStatusTypes_data.strNSTStatusTypeName1);

		objStatusTypeList.clickCreateNewStatusTypeButton();
		objStatusTypeList.verifySelectStatusTypePage();
		objStatusTypeList
				.selectStatusType(objStatusTypes_data.strMultiStatusType);
		objStatusTypeList.clickNextButton();
		objStatusTypeList.verifyCreateMultiStatusTypePage();
		objStatusTypeList.verifyStatusTypeVisibilityOptionISEnabled();
		objStatusTypeList.verifyRoleBasedStatusTypes();
		objStatusTypeList
				.enterStatusTypeName(objStatusTypes_data.strMSTStatusTypeName1);
		objStatusTypeList
				.enterStatusTypeDescription(objStatusTypes_data.strStatusDescription);
		objStatusTypeList.clickOnSaveButton();
		objStatusTypeList.createNewStatus(
			     objStatusTypes_data.strStatusNameInMulti,
			     objStatusTypes_data.strStatusColor)
			  .createNewStatus(objStatusTypes_data.strStatusNameInMulti1,
			      objStatusTypes_data.strStatusColor)
			  .verCreatedStatusInStatusListForMulti(
			      objStatusTypes_data.strStatusNameInMulti)
			  .verCreatedStatusInStatusListForMulti(
			      objStatusTypes_data.strStatusNameInMulti1)
			  .clickOnReturnToStatusTypeList();
		objStatusTypeList
				.verifyStatusTypeInList(objStatusTypes_data.strMSTStatusTypeName1);

		objStatusTypeList.clickCreateNewStatusTypeButton();
		objStatusTypeList.verifySelectStatusTypePage();
		objStatusTypeList
				.selectStatusType(objStatusTypes_data.strTextStatusType);
		objStatusTypeList.clickNextButton();
		objStatusTypeList.verifyCreateTextStatusTypePage();
		objStatusTypeList.verifyStatusTypeVisibilityOptionISEnabled();
		objStatusTypeList.verifyRoleBasedStatusTypes();
		objStatusTypeList
				.enterStatusTypeName(objStatusTypes_data.strTSTStatusTypeName1);
		objStatusTypeList
				.enterStatusTypeDescription(objStatusTypes_data.strStatusDescription);
		objStatusTypeList.clickOnSaveButton();

		objStatusTypeList
				.verifyStatusTypeInList(objStatusTypes_data.strTSTStatusTypeName1);

		objStatusTypeList.clickCreateNewStatusTypeButton();
		objStatusTypeList.verifySelectStatusTypePage();
		objStatusTypeList
				.selectStatusType(objStatusTypes_data.strSaturationScoreStatusType);
		objStatusTypeList.clickNextButton();
		objStatusTypeList.verifyCreateSaturationStatusTypePage();
		objStatusTypeList.verifyStatusTypeVisibilityOptionISEnabled();
		objStatusTypeList.verifyRoleBasedStatusTypes();
		objStatusTypeList
				.enterStatusTypeName(objStatusTypes_data.strSSTStatusTypeName1);
		objStatusTypeList
				.enterStatusTypeDescription(objStatusTypes_data.strStatusDescription);
		objStatusTypeList.clickOnSaveButton();

		objStatusTypeList
				.verifyStatusTypeInList(objStatusTypes_data.strSSTStatusTypeName1);

		objStatusTypeList.clickCreateNewStatusTypeButton();
		objStatusTypeList.verifySelectStatusTypePage();
		objStatusTypeList
				.selectStatusType(objStatusTypes_data.strNedocCalculationStatusType);
		objStatusTypeList.clickNextButton();
		objStatusTypeList.verifyCreateNedocStatusTypePage();
		objStatusTypeList.verifyStatusTypeVisibilityOptionISEnabled();
		objStatusTypeList.verifyRoleBasedStatusTypes();
		objStatusTypeList
				.enterStatusTypeName(objStatusTypes_data.strNDSTStatusTypeName1);
		objStatusTypeList
				.enterStatusTypeDescription(objStatusTypes_data.strStatusDescription);
		objStatusTypeList.clickOnSaveButton();

		objStatusTypeList
				.verifyStatusTypeInList(objStatusTypes_data.strNDSTStatusTypeName1);

		objStatusTypeList
				.clickOnEditOfStatusType(objStatusTypes_data.strNSTStatusTypeName1);
		objStatusTypeList.verifyEditNumberStatusTypePage();
		objStatusTypeList.verifyRoleBasedStatusTypes();
		objStatusTypeList.clickOnSaveButton();

		objStatusTypeList
				.verifyStatusTypeInList(objStatusTypes_data.strNSTStatusTypeName1);

		objStatusTypeList
				.clickOnEditOfStatusType(objStatusTypes_data.strMSTStatusTypeName1);
		objStatusTypeList.verifyRoleBasedStatusTypes();
		objStatusTypeList.verifyEditMultiStatusTypePage();
		objStatusTypeList.clickOnSaveButton();

		objStatusTypeList
				.verifyStatusTypeInList(objStatusTypes_data.strMSTStatusTypeName1);

		objStatusTypeList
				.clickOnEditOfStatusType(objStatusTypes_data.strSSTStatusTypeName1);
		objStatusTypeList.verifyRoleBasedStatusTypes();
		objStatusTypeList.verifyEditSaturationStatusTypePage();
		objStatusTypeList.clickOnSaveButton();

		objStatusTypeList
				.verifyStatusTypeInList(objStatusTypes_data.strSSTStatusTypeName1);

		objStatusTypeList
				.clickOnEditOfStatusType(objStatusTypes_data.strTSTStatusTypeName1);
		objStatusTypeList.verifyRoleBasedStatusTypes();
		objStatusTypeList.verifyEditTextStatusTypePage();
		objStatusTypeList.clickOnSaveButton();

		objStatusTypeList
				.verifyStatusTypeInList(objStatusTypes_data.strTSTStatusTypeName1);

		objStatusTypeList
				.clickOnEditOfStatusType(objStatusTypes_data.strNDSTStatusTypeName1);
		objStatusTypeList.verifyRoleBasedStatusTypes();
		objStatusTypeList.verifyEditNedocStatusTypePage();
		objStatusTypeList.clickOnSaveButton();

		objStatusTypeList
				.verifyStatusTypeInList(objStatusTypes_data.strNDSTStatusTypeName1);

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}

}
