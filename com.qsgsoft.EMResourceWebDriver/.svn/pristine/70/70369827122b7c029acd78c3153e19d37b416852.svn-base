package requirementGroup.CreatingAndManagingForms;

import java.util.Iterator;
import java.util.Set;
import lib.dataObject.BlankFormData;
import lib.dataObject.FormConfigeration_data;
import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.dataObject.User_data;
import lib.module.NavigationToSubMenus;
import lib.page.ActivateForms;
import lib.page.BlankForm;
import lib.page.DispatchForm;
import lib.page.FormConfiguration;
import lib.page.Login;
import lib.page.MailVerificationFunctions;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;
import lib.page.UsersList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class HappyDayStandardListsOfQuestionnaire extends TestNG_UI_EXTENSIONS  {

	public HappyDayStandardListsOfQuestionnaire() throws Exception {
		super();
		
	}
	/****************************************************************************************************
	'Description : Verify that user can add 'All Resources' standard list to a questionnaire 
	'Date	 	 : 31-Aug-2015
	'Author		 : Sangappa.K
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*****************************************************************************************************/
	@Test(description ="Verify that user can add 'All Resources' standard list to a questionnaire")
	public void testHappyDay166432() throws Exception {

		gstrTCID = "166432";
		gstrTO = "Verify that user can add 'All Resources' standard list to a questionnaire";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();

		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);
		String strStatusTypeValues[] = new String[2];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList()

		.createStatusTypeWithStdStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objStatuTypes_data.strStandardStatusTypename1);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithStdStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objStatuTypes_data.strStandardStatusTypename2);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		System.out.println(objResourceType_data.strResourceTypeName);

	
		objResource
				.navigateToResourceListPage()
				.createResource(objResource_data.strResourceName,
						objResource_data.strResourceAbbrivation,
						objResourceType_data.strResourceTypeName,
						objResource_data.strStandardResourceTypename,
						objResource_data.strResourceFirstName,
						objResource_data.strResourceLastName)

				.createResource(objResource_data.strResourceName1,
						objResource_data.strResourceAbbrivation1,
						objResourceType_data.strResourceTypeName,
						objResource_data.strStandardResourceTypename,
						objResource_data.strResourceFirstName,
						objResource_data.strResourceLastName)

				.createResource(objResource_data.strResourceName2,
						objResource_data.strResourceAbbrivation1,
						objResourceType_data.strResourceTypeName,
						objResource_data.strStandardResourceTypename,
						objResource_data.strResourceFirstName,
						objResource_data.strResourceLastName);

		System.out.println(objResource_data.strResourceName);
		System.out.println(objResource_data.strResourceName1);
		System.out.println(objResource_data.strResourceName2);

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickSaveButton();

		objNavigationToSubmenus.clickOnConfigureForm();

		objFormConfiguration
				.verFormConfigurePage()
				.createNewFormTempltete()
				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strFormName,
						objFormConfiguration_data.strDiscriptiveName)
				.selectOptionInFormActivationDropDown(
						objFormConfiguration_data.strFormActivatnUIOTFO)
				.selCompletedFormDelivery(
						objFormConfiguration_data.strComptdFormDelvry)
				.clickOnNextButton()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton().clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();

		System.out.println(objFormConfiguration_data.strFormName);

		objFormConfiguration
				.clickOnAcknowledgeForm(objFormConfiguration_data.strFormName);

		String mainWindowHandle1 = driver.getWindowHandle();
		Set<String> a1 = driver.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle1 = ite1.next().toString();

			if (!popupHandle1.contains(mainWindowHandle1)) {
				driver.switchTo().window(popupHandle1);

			}
		}

		Thread.sleep(5000);
		objFormConfiguration
				.clickOnInsert()
				.clickOnGroupLink()
				.verifyEditGroupOrTable()
				.enterNewGroupName(objFormConfiguration_data.strGroupName)
				.clickOnGroupDoneButton()
				.clickOnAddButton(objFormConfiguration_data.strGroupName)
				.clickOnFieldSet(objFormConfiguration_data.strGroupName)
				.verifyEditFieldSetWindow()
				.enterAttributesLabelName(
						objFormConfiguration_data.strAttributeName)
				.clickOnEditFieldDoneButton()

				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strSingleSelect)
				.enterLabelName(objFormConfiguration_data.strLabelName1)
				.clickOnUseStanderdListChkBox()
				.selectValueFromListToUseDropdown(
						objFormConfiguration_data.strAllResources)
				.clickOnAddToSummary()
				.clickOnDoneButton()

				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strMultiSelect)
				.enterLabelName(objFormConfiguration_data.strLabelName2)
				.clickOnUseStanderdListChkBox()
				.selectValueFromListToUseDropdown(
						objFormConfiguration_data.strAllResources)
				.clickOnAddToSummary()
				.clickOnDoneButton()

				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strRadio)
				.enterLabelName(objFormConfiguration_data.strLabelName3)
				.clickOnUseStanderdListChkBox()
				.selectValueFromListToUseDropdown(
						objFormConfiguration_data.strAllResources)
				.clickOnAddToSummary()
				.clickOnDoneButton()

				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strCheckBox)
				.enterLabelName(objFormConfiguration_data.strLabelName4)
				.clickOnUseStanderdListChkBox()
				.selectValueFromListToUseDropdown(
						objFormConfiguration_data.strAllResources)
				.clickOnAddToSummary()
				.clickOnDoneButton()

				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(
						objFormConfiguration_data.strTypeaheadSelect)
				.enterLabelName(objFormConfiguration_data.strLabelName5)
				.clickOnUseStanderdListChkBox()
				.selectValueFromListToUseDropdown(
						objFormConfiguration_data.strAllResources)
				.clickOnAddToSummary().clickOnDoneButton().clickOnSaveButton();

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(5000);
		driver.close();

		driver.switchTo().window(mainWindowHandle1);

		objRegionDefault.selectFrame();

		objLogin.clickLogOut();

		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage1
				.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();

		objNavigationToSubmenus1.clickOnConfigureForm();

		objFormConfiguration1
				.clickOnAcknowledgeFormOnIE(objFormConfiguration_data.strFormName);

		String mainWindowHandle = driver1.getWindowHandle();

		Set<String> a = driver1.getWindowHandles();
		Iterator<String> ite = a.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();

			if (!popupHandle.contains(mainWindowHandle)) {
				driver1.switchTo().window(popupHandle);

			}
		}

		Thread.sleep(8000);

		objFormConfiguration1
				.verTemplateDesignPage()

				.verResIsDispInTempPgForSingleOrMultiSelect(
						objFormConfiguration_data.strLabelName1,
						objResource_data.strResourceName)
				.verResIsDispInTempPgForSingleOrMultiSelect(
						objFormConfiguration_data.strLabelName1,
						objResource_data.strResourceName1)
				.verResIsDispInTempPgForSingleOrMultiSelect(
						objFormConfiguration_data.strLabelName1,
						objResource_data.strResourceName2)

				.verResIsDispInTempPgForSingleOrMultiSelect(
						objFormConfiguration_data.strLabelName2,
						objResource_data.strResourceName)
				.verResIsDispInTempPgForSingleOrMultiSelect(
						objFormConfiguration_data.strLabelName2,
						objResource_data.strResourceName1)
				.verResIsDispInTempPgForSingleOrMultiSelect(
						objFormConfiguration_data.strLabelName2,
						objResource_data.strResourceName2)

				.verResIsDispInTempPgForChkBoxOrRadio(
						objFormConfiguration_data.strLabelName3,
						objResource_data.strResourceName)
				.verResIsDispInTempPgForChkBoxOrRadio(
						objFormConfiguration_data.strLabelName3,
						objResource_data.strResourceName1)
				.verResIsDispInTempPgForChkBoxOrRadio(
						objFormConfiguration_data.strLabelName3,
						objResource_data.strResourceName2)

				.verResIsDispInTempPgForChkBoxOrRadio(
						objFormConfiguration_data.strLabelName4,
						objResource_data.strResourceName)
				.verResIsDispInTempPgForChkBoxOrRadio(
						objFormConfiguration_data.strLabelName4,
						objResource_data.strResourceName1)
				.verResIsDispInTempPgForChkBoxOrRadio(
						objFormConfiguration_data.strLabelName4,
						objResource_data.strResourceName2)
							
				.entereResInTypeHeadField(
						objFormConfiguration_data.strLabelName5,
						objResource_data.strResourceName)
				.verResouLstedInTempPgForTypeHeadQsnry(
						objResource_data.strResourceName)

				.entereResInTypeHeadField(
						objFormConfiguration_data.strLabelName5,
						objResource_data.strResourceName1)
				.verResouLstedInTempPgForTypeHeadQsnry(
						objResource_data.strResourceName1)

				.entereResInTypeHeadField(
						objFormConfiguration_data.strLabelName5,
						objResource_data.strResourceName2)
				.verResouLstedInTempPgForTypeHeadQsnry(
						objResource_data.strResourceName2);
			
						
		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(5000);

		driver1.close();

		driver1.switchTo().window(mainWindowHandle);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();

		gstrResult = "PASS";
	}
	
	/****************************************************************************************************
	'Description : Verify that user can add 'Hospital Resources' standard list to a questionnaire 
	'Date	 	 : 29-Oct-2015
	'Author		 : Sangappa.K
	'---------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	*****************************************************************************************************/
	@Test(description ="Verify that user can add 'Hospital Resources' standard list to a questionnaire ")
	public void testHappyDay166855() throws Exception {

		gstrTCID ="166855";
		gstrTO ="Verify that user can add 'Hospital Resources' standard list to a questionnaire";

		Login objLogin = new Login(this.driver1);
		Login_data objLogindata = new Login_data();
		FormConfigeration_data objFormConfiguration_data = new FormConfigeration_data();
		User_data objUserdata = new User_data();
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();

		SelectRegion objSelectRegionpage = new SelectRegion(this.driver1);
		UsersList objUsersList = new UsersList(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus = new NavigationToSubMenus(
				this.driver1);
		FormConfiguration objFormConfiguration = new FormConfiguration(
				this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		NavigationToSubMenus objNavigationToSubmenus1 = new NavigationToSubMenus(
				this.driver1);
		SelectRegion objSelectRegionpage1 = new SelectRegion(this.driver1);
		FormConfiguration objFormConfiguration1 = new FormConfiguration(
				this.driver1);
		String strStatusTypeValues[] = new String[2];

		objLogin.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList()

		.createStatusTypeWithStdStatusType(
				objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objStatuTypes_data.strStandardStatusTypename1);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusTypeWithStdStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription,
				objStatuTypes_data.strStandardStatusTypename2);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);

		objResourceType.navigateToResourceTypePage().createResourceType(
				objResourceType_data.strResourceTypeName, strStatusTypeValues);

		System.out.println(objResourceType_data.strResourceTypeName);

	
		objResource
				.navigateToResourceListPage()				
		.clickOnCreateNewResourceButton()
		.enterResourceName(objResource_data.strResourceName1)
		.enterResourceAbbrivation(objResource_data.strResourceAbbrivation)
		.selectResourceTypename(objResourceType_data.strResourceTypeName)
		.selectStandardStatusType(objResource_data.strHospital)
		.enterResourceFirstName(	objResource_data.strResourceFirstName)
		.enterResourceLastName(objResource_data.strResourceLastName)
		.clickOnSaveButton()
		.clickOnSaveButton()
						
		.clickOnCreateNewResourceButton()
		.enterResourceName(objResource_data.strResourceName2)
		.enterResourceAbbrivation(objResource_data.strResourceAbbrivation1)
		.selectResourceTypename(objResourceType_data.strResourceTypeName)
		.selectStandardStatusType(objResource_data.strTraumaHospital)
		.enterResourceFirstName(	objResource_data.strResourceFirstName)
		.enterResourceLastName(objResource_data.strResourceLastName)
		.clickOnSaveButton()
		.clickOnSaveButton()
		
		.clickOnCreateNewResourceButton()
		.enterResourceName(objResource_data.strResourceName3)
		.enterResourceAbbrivation(objResource_data.strResourceAbbrivation2)
		.selectResourceTypename(objResourceType_data.strResourceTypeName)
		.selectStandardStatusType(objResource_data.strTraumaHospital)
		.enterResourceFirstName(	objResource_data.strResourceFirstName)
		.enterResourceLastName(objResource_data.strResourceLastName)
		.clickOnSaveButton()
		.clickOnSaveButton()
		
		.clickOnCreateNewResourceButton()
		.enterResourceName(objResource_data.strResourceName4)
		.enterResourceAbbrivation(objResource_data.strResourceAbbrivation)
		.selectResourceTypename(objResourceType_data.strResourceTypeName)
		.selectStandardStatusType(objResource_data.strTraumaLevel1)
		.enterResourceFirstName(	objResource_data.strResourceFirstName)
		.enterResourceLastName(objResource_data.strResourceLastName)
		.clickOnSaveButton()
		.clickOnSaveButton()
		
		.clickOnCreateNewResourceButton()
		.enterResourceName(objResource_data.strResourceName5)
		.enterResourceAbbrivation(objResource_data.strResourceAbbrivation1)
		.selectResourceTypename(objResourceType_data.strResourceTypeName)
		.selectStandardStatusType(objResource_data.strTraumaLevel2)
		.enterResourceFirstName(	objResource_data.strResourceFirstName)
		.enterResourceLastName(objResource_data.strResourceLastName)
		.clickOnSaveButton()
		.clickOnSaveButton()
		
		.clickOnCreateNewResourceButton()
		.enterResourceName(objResource_data.strResourceName6)
		.enterResourceAbbrivation(objResource_data.strResourceAbbrivation2)
		.selectResourceTypename(objResourceType_data.strResourceTypeName)
		.selectStandardStatusType(objResource_data.strTraumaLevel3)
		.enterResourceFirstName(	objResource_data.strResourceFirstName)
		.enterResourceLastName(objResource_data.strResourceLastName)
		.clickOnSaveButton()
		.clickOnSaveButton();

		objNavigationToSubmenus.navigateToUsers();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickAdvancedOptionAndExpand()
				.selectFormUserMayActivateFormsOption().clickSaveButton();

		objUsersList
				.clickCreateNewUserButton()
				.enterUserDetails(objUserdata.strNewUserName1,
						objUserdata.strNewPassword, objUserdata.strFullName)
				.selectFirstRole().clickSaveButton();

		objNavigationToSubmenus.clickOnConfigureForm();

		objFormConfiguration
				.verFormConfigurePage()
				.createNewFormTempltete()
				.entireTittleName_DescriptionName(
						objFormConfiguration_data.strFormName,
						objFormConfiguration_data.strDiscriptiveName)
				.selectOptionInFormActivationDropDown(
						objFormConfiguration_data.strFormActivatnUIOTFO)
				.selCompletedFormDelivery(
						objFormConfiguration_data.strComptdFormDelvry)
				.clickOnNextButton()
				.selUserInUsersToFillOutForm(objUserdata.strNewUserName1)
				.clickOnNextButton().clickOnNextButton()
				.selectActivateFormChkBox(objUserdata.strNewUserName)
				.clickOnSaveOfFormSecuritySetting();
		
		objFormConfiguration
		.clickOnAcknowledgeFormOnIE(objFormConfiguration_data.strFormName);
		
		String mainWindowHandle1 = driver.getWindowHandle();
		Set<String> a1 = driver.getWindowHandles();
		Iterator<String> ite1 = a1.iterator();

		while (ite1.hasNext()) {
			String popupHandle1 = ite1.next().toString();

			if (!popupHandle1.contains(mainWindowHandle1)) {
				driver.switchTo().window(popupHandle1);

			}
		}

		Thread.sleep(50000);
		objFormConfiguration
				.clickOnInsert()
				.clickOnGroupLink()
				.verifyEditGroupOrTable()
				.enterNewGroupName(objFormConfiguration_data.strGroupName)
				.clickOnGroupDoneButton()
				.clickOnAddButton(objFormConfiguration_data.strGroupName)
				.clickOnFieldSet(objFormConfiguration_data.strGroupName)
				.verifyEditFieldSetWindow()
				.enterAttributesLabelName(
						objFormConfiguration_data.strAttributeName)
				.clickOnEditFieldDoneButton()

				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strSingleSelect)
				.enterLabelName(objFormConfiguration_data.strLabelName1)
				.clickOnUseStanderdListChkBox()
				.selectValueFromListToUseDropdown(
						objFormConfiguration_data.strAllResources)
				.clickOnAddToSummary()
				.clickOnDoneButton()

				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strMultiSelect)
				.enterLabelName(objFormConfiguration_data.strLabelName2)
				.clickOnUseStanderdListChkBox()
				.selectValueFromListToUseDropdown(
						objFormConfiguration_data.strAllResources)
				.clickOnAddToSummary()
				.clickOnDoneButton()

				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strRadio)
				.enterLabelName(objFormConfiguration_data.strLabelName3)
				.clickOnUseStanderdListChkBox()
				.selectValueFromListToUseDropdown(
						objFormConfiguration_data.strAllResources)
				.clickOnAddToSummary()
				.clickOnDoneButton()

				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(objFormConfiguration_data.strCheckBox)
				.enterLabelName(objFormConfiguration_data.strLabelName4)
				.clickOnUseStanderdListChkBox()
				.selectValueFromListToUseDropdown(
						objFormConfiguration_data.strAllResources)
				.clickOnAddToSummary()
				.clickOnDoneButton()

				.clickOnInsertElement(
						objFormConfiguration_data.strAttributeName)
				.verifyEditQuestionWindow()
				.selectQuestionType(
						objFormConfiguration_data.strTypeaheadSelect)
				.enterLabelName(objFormConfiguration_data.strLabelName5)
				.clickOnUseStanderdListChkBox()
				.selectValueFromListToUseDropdown(
						objFormConfiguration_data.strAllResources)
				.clickOnAddToSummary().clickOnDoneButton().clickOnSaveButton();
		
		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration.clickOnPublishButton();
		Thread.sleep(5000);
		driver.close();
		driver.switchTo().window(mainWindowHandle1);

		objRegionDefault.selectFrame();

		objLogin.clickLogOut();

		System.out.println(objFormConfiguration_data.strFormName);
		
		
		objLogin1.loginToApplication(objLogindata.strAdminUser,
				objLogindata.strAdminUserPwd);

		objSelectRegionpage1.selectRegionAndNavigate(objLogindata.strRegionName);

		objRegionDefault1.selectFrame();
		
		objNavigationToSubmenus1.clickOnConfigureForm();
		
		objFormConfiguration1
				.clickOnAcknowledgeFormOnIE(objFormConfiguration_data.strFormName);
	
		String mainWindowHandle2 = driver1.getWindowHandle();
		Set<String> a2 = driver1.getWindowHandles();
		Iterator<String> ite2 = a2.iterator();

		while (ite2.hasNext()) {
			String popupHandle2 = ite2.next().toString();

			if (!popupHandle2.contains(mainWindowHandle2)) {
				driver1.switchTo().window(popupHandle2);

			}
		}

		Thread.sleep(100000);
		
		String[] strResources = { objResource_data.strResourceName1,
				objResource_data.strResourceName2,
				objResource_data.strResourceName3,
				objResource_data.strResourceName4,
				objResource_data.strResourceName5,
				objResource_data.strResourceName6 };
		
		for(int i=0;i<=strResources.length-1;i++)
		{	
			
		objFormConfiguration1		
		.verResIsDispInTempPgForSingleOrMultiSelect(
				objFormConfiguration_data.strLabelName1,strResources[i]);
		}
		
		for(int j=0;j<=strResources.length-1;j++)
		{	
					
		objFormConfiguration1   
		.verResIsDispInTempPgForSingleOrMultiSelect(
				objFormConfiguration_data.strLabelName2,strResources[j]);
		}
		
		for(int k=0;k<=strResources.length-1;k++)
		{	
			
		objFormConfiguration1		
		.verResIsDispInTempPgForChkBoxOrRadio(
				objFormConfiguration_data.strLabelName3,strResources[k]);
		}
		
		for(int l=0;l<=strResources.length-1;l++)
		{	
					
		objFormConfiguration1   
		.verResIsDispInTempPgForChkBoxOrRadio(
				objFormConfiguration_data.strLabelName4,
         		strResources[l]);
		}
		
	  for(int m=0;m<=strResources.length-1;m++)
		{			
		objFormConfiguration1
		.entereResInTypeHeadField(objFormConfiguration_data.strLabelName5,strResources[m])
		.verResouLstedInTempPgForTypeHeadQsnry(strResources[m]);
		
		}

		System.out.println("started");
		Thread.sleep(5000);
		System.out.println("ended");
		objFormConfiguration1.clickOnPublishButton();
		Thread.sleep(5000);
		driver1.close();

		driver1.switchTo().window(mainWindowHandle2);

		objRegionDefault1.selectFrame();

		objLogin1.clickLogOut();
	

		gstrResult = "PASS";
	}
	

}