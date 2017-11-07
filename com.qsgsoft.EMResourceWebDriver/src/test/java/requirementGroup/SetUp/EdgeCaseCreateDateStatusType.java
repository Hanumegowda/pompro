package requirementGroup.SetUp;

import lib.dataObject.FormConfigeration_data;
import lib.dataObject.Login_data;
import lib.dataObject.StatusTypes_data;
import lib.module.NavigationToSubMenus;
import lib.page.FormConfiguration;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class EdgeCaseCreateDateStatusType extends TestNG_UI_EXTENSIONS {

	public EdgeCaseCreateDateStatusType() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	/***********************************************************************************
	 * 'Description : Verify that date status types are not displayed on 'Form
	 * Activation Status Type' when is configured selecting 'As certain status
	 * changes' as activation method.
	 * 'Date : 10-Oct-2014 
	 * Author : sangappa.k
	 ************************************************************************************/
	@Test(description = " Verify that date status types are not displayed on 'Form Activation "
			+ "Status Type' when is configured selecting 'As certain status changes' as activation method. ")
	public void testEdgeCase145815() throws Exception {

		gstrTCID = "145815";
		gstrTO = " Verify that date status types are not displayed on 'Form Activation Status Type' when is "
				+ "configured selecting 'As certain status changes' as activation method. ";

		// objects for TC
		Login objLogin_page1 = new Login(this.driver1);
		RegionDefault objRegDefault_page1 = new RegionDefault(driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(driver1);
		SelectRegion objSelectRegion = new SelectRegion(driver1);
		NavigationToSubMenus objNavigationToSubMenus = new NavigationToSubMenus(
				driver1);
		FormConfiguration objFormConfiguration_page1 = new FormConfiguration(
				driver1);

		String[] StatusTypeValue = new String[1];

		// data for TC
		Login_data objLogin_data = new Login_data();
		StatusTypes_data objStatusTypes_data = new StatusTypes_data();
		FormConfigeration_data objFormConfigeration_data = new FormConfigeration_data();

		// login as a admin
		objLogin_page1.loginToApplication(objLogin_data.strUserName,
				objLogin_data.strPassword);

		objRegDefault_page1.selectFrame();

		objSelectRegion.selectRegionAndNavigate(objLogin_data.strRegionName);

		objRegDefault_page1.selectFrame();

		objStatusTypeList.navigateToStatusTypeList();

		objStatusTypeList.createStatusType(
				objStatusTypes_data.strDateStatusType,
				objStatusTypes_data.strDateStatusTypeName2,
				objStatusTypes_data.strStatusDescription);

		StatusTypeValue[0] = objStatusTypeList
				.getStatusValue(objStatusTypes_data.strDateStatusTypeName2);
		// navigate to form

		objNavigationToSubMenus.clickOnConfigureForm();

		objFormConfiguration_page1
				.verFormConfigurePage()
				.createNewFormTempltete()

				.entireTittleName_DescriptionName(
						objFormConfigeration_data.strTittleName,
						objFormConfigeration_data.strDiscriptiveName);

		objFormConfiguration_page1
				.selectOptionInFormActivationDropDown(objFormConfigeration_data.strsCertainStatusChanges);

		objFormConfiguration_page1.clickOnNextButton();

		// verify the status type is not displyed

		objFormConfiguration_page1
				.verStatusTypeIsNotDisplyed(StatusTypeValue[0]);

		objLogin_page1.clickLogOut();
		
		gstrResult = "PASS";
	}
}
