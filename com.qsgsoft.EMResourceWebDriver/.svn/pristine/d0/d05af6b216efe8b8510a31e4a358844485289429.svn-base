package requirementGroup.CreatingAndManagingViews;

import lib.dataObject.EventSetUp_data;
import lib.dataObject.Login_data;
import lib.dataObject.ResourceType_data;
import lib.dataObject.Resource_data;
import lib.dataObject.StatusTypes_data;
import lib.page.EventSetUp;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import lib.page.SelectRegion;
import lib.page.StatusTypeList;

import org.testng.annotations.Test;

import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class HappyDayCreatingAndManagingViews extends TestNG_UI_EXTENSIONS{

	public HappyDayCreatingAndManagingViews() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/*************************************************************************************
	'Description 	: Verify that Status Type is retrieved when searched providing its name
	 				  in View/Edit Other Region Security - Status Types page. 
	'Precondition	: 
	'Date 			: 05-Jan-2014 
	'Author 		: Deepa
	'------------------------------------------------------------------------------------
	'Modified Date			                        	Modified By
	'Date					                            Name
	**************************************************************************************/
	@Test(description = "Verify that Status Type is retrieved when searched providing its name in View/Edit Other Region Security - Status Types page.")
	public void testHappyDay151542() throws Exception {

		gstrTCID = "151542";
		gstrTO = "Verify that Status Type is retrieved when searched providing its name in View/Edit Other Region Security - Status Types page.";
		
		StatusTypes_data objStatuTypes_data = new StatusTypes_data();
		Login_data objTest_data = new Login_data();
		
		Login objLogin = new Login(this.driver1);
		RegionDefault objRegionDefault = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion = new SelectRegion(this.driver1);
		StatusTypeList objStatusTypeList = new StatusTypeList(this.driver1);
		ResourceType objResourceType = new ResourceType(this.driver1);
		ResourceType_data objResourceType_data = new ResourceType_data();
		Resource objResource = new Resource(this.driver1);
		Resource_data objResource_data = new Resource_data();

		Login objLogin1 = new Login(this.driver1);
		RegionDefault objRegionDefault1 = new RegionDefault(this.driver1);
		SelectRegion objSelectRegion1 = new SelectRegion(this.driver1);
		EventSetUp_data objEventSetUp_data = new EventSetUp_data();
		EventSetUp objEventSetUp = new EventSetUp(this.driver1);

		String strStatusTypeValues[] = new String[3];
		String strResourceTypeValue[] = new String[1];
		String strResourceValue[] = new String[1];

		objLogin.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objSelectRegion
				.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault.selectFrame();

		objStatusTypeList.navigateToStatusTypeList()

		.createStatusType(objStatuTypes_data.strNumberStatusType,
				objStatuTypes_data.strNSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[0] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strNSTStatusTypeName);

		objStatusTypeList.createStatusType(
				objStatuTypes_data.strTextStatusType,
				objStatuTypes_data.strTSTStatusTypeName,
				objStatuTypes_data.strStatusDescription);

		strStatusTypeValues[1] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strTSTStatusTypeName);
		
		objStatusTypeList.createStatusType(
				objStatuTypes_data.strMultiStatusType,
				objStatuTypes_data.strMSTStatusTypeName,
				objStatuTypes_data.strStatusDescription)
			.createNewStatus(objStatuTypes_data.strStatusNameInMulti,
					objStatuTypes_data.strStatusColor)
			.createNewStatus(objStatuTypes_data.strStatusNameInMulti1,	objStatuTypes_data.strStatusColor)
			.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameInMulti)
			.verCreatedStatusInStatusListForMulti(objStatuTypes_data.strStatusNameInMulti1)
	.clickOnReturnToStatusTypeList();
		
		strStatusTypeValues[2] = objStatusTypeList
				.getStatusValue(objStatuTypes_data.strMSTStatusTypeName);
		
		// First resource type creation
		objResourceType.navigateToResourceTypePage()
				.createResourceType(objResourceType_data.strResourceTypeName,
						strStatusTypeValues);

		strResourceTypeValue[0] = objResourceType
				.getResourceTypeValue(objResourceType_data.strResourceTypeName);
		
		// Resource creation
		objResource.navigateToResourceListPage().createResource(
				objResource_data.strResourceName,
				objResource_data.strResourceAbbrivation,
				objResourceType_data.strResourceTypeName,
				objResource_data.strStandardResourceTypename,
				objResource_data.strResourceFirstName,
				objResource_data.strResourceLastName);

		strResourceValue[0] = objResource
				.getResourceValue(objResource_data.strResourceName);
		
		objLogin.clickLogOut();
		
		objLogin1.loginToApplication(objTest_data.strUserName,
				objTest_data.strPassword);

		objRegionDefault1.selectFrame()
		                 .clickRegionLink();

		objSelectRegion1
				.selectRegionAndNavigate(objTest_data.strRegionName);

		objRegionDefault1.selectFrame();
		
		objEventSetUp.navigateToEventSetUp();
		
		objEventSetUp
					.clickOncreateEventTemplate()
					.verifyTheFields()
					.enterEventTemplateName(objEventSetUp_data.strEventTemplate)
					.enterEventTemplateDefintion(
							objEventSetUp_data.strTemplateDefinition)
					.selectResourceType(strResourceTypeValue[0])
					.searchStatusType(objStatuTypes_data.strTSTStatusTypeName);
		Thread.sleep(5000);
		objEventSetUp.selectStatusType(strStatusTypeValues[1])
					.clickSaveButton()
					.clickSaveButton()
				    .clickOnEditTempLink(objEventSetUp_data.strEventTemplate)
				    .searchStatusType(objStatuTypes_data.strMSTStatusTypeName);
		Thread.sleep(5000);
		objEventSetUp.selectStatusType(strStatusTypeValues[2])
				    .clickSaveButton();
		
		gstrResult = "PASS";
	}
}
