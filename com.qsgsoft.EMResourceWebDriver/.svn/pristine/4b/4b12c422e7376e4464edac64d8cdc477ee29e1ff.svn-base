package requirementGroup.CreatingAndManagingEvents;

import lib.dataObject.Event_data;
import lib.dataObject.Login_data;
import lib.page.EventManagement;
import lib.page.Login;
import lib.page.RegionDefault;
import lib.page.Resource;
import lib.page.ResourceType;
import org.testng.annotations.Test;
import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.testngExtensions.TestNG_UI_EXTENSIONS;

public class HappyDayAdhocEventsOne extends TestNG_UI_EXTENSIONS {

	public HappyDayAdhocEventsOne() throws Exception {
		super();
	}

	/********************************************************************************
	'Description	:Verify that Ad Hoc event starts and ends at the newly provided 
	                 date and time before the previously provided event start and 
	                 end date/time for a future Ad Hoc event.
	'Date	 		:19-June-2014
	'Author			:Sowmya
	**********************************************************************************/
	@Test(description = "Verify that Ad Hoc event starts and ends at the newly provided date and time before " +
			"the previously provided event start and end date/time for a future Ad Hoc event.")
	public void testHappyDay140392() throws Exception {
		
		gstrTCID = "140392";
		gstrTO	 = "Verify that Ad Hoc event starts and ends at the newly provided date and time before " +
			"the previously provided event start and end date/time for a future Ad Hoc event.";
		
		Event_data objEvent_data=new Event_data();
		Date_Time_settings objDts = new Date_Time_settings();
		OfficeCommonFunctions objOffCommonFunc=new OfficeCommonFunctions();

		Login login_page1 = new Login(this.driver1);
		RegionDefault RegionDefault_page1 = new RegionDefault(this.driver1); 
		EventManagement EventManagement_page1=new EventManagement(this.driver1);
		ResourceType ResourceType_Page1=new ResourceType(this.driver1);
		Resource Resource_Page1 =new Resource(this.driver1);
		String strRegionName[]=new String[1];
		String strstatusTypeNames[]=new String[10];
		String strstatusTypeValues[]=new String[10];
		String strResourceName[]=new String[1];
		String strResourceValue[]=new String[1];
		String strResourceTypeName[]=new String[1];
		String strUserNameAndPwd[]=new String[2];
		
		String strFilePath = Login_data.strTestDataPath;
		strRegionName[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 2, strFilePath);
		
		strUserNameAndPwd[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 15, strFilePath);
		strUserNameAndPwd[1]=objOffCommonFunc.readInfoExcel("TestData", 2, 16, strFilePath);
		
		strResourceTypeName[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 13, strFilePath);
		strResourceName[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 14, strFilePath);
		strResourceValue[0]=objOffCommonFunc.readInfoExcel("TestData", 3, 14, strFilePath);
		
		strstatusTypeNames[0]=objOffCommonFunc.readInfoExcel("TestData", 2, 3, strFilePath);	
		strstatusTypeNames[1]=objOffCommonFunc.readInfoExcel("TestData", 2, 4, strFilePath);		
		strstatusTypeNames[2]=objOffCommonFunc.readInfoExcel("TestData", 2, 5, strFilePath);
		strstatusTypeNames[3]=objOffCommonFunc.readInfoExcel("TestData", 2, 6, strFilePath);
		strstatusTypeNames[4]=objOffCommonFunc.readInfoExcel("TestData", 2, 7, strFilePath);
		strstatusTypeNames[5]=objOffCommonFunc.readInfoExcel("TestData", 2, 8, strFilePath);
		strstatusTypeNames[6]=objOffCommonFunc.readInfoExcel("TestData", 2, 9, strFilePath);
		strstatusTypeNames[7]=objOffCommonFunc.readInfoExcel("TestData", 2, 10, strFilePath);
		strstatusTypeNames[8]=objOffCommonFunc.readInfoExcel("TestData", 2, 11, strFilePath);
		strstatusTypeNames[9]=objOffCommonFunc.readInfoExcel("TestData", 2, 12, strFilePath);
			
		strstatusTypeValues[0]=objOffCommonFunc.readInfoExcel("TestData", 3, 3, strFilePath);	
		strstatusTypeValues[1]=objOffCommonFunc.readInfoExcel("TestData", 3, 4, strFilePath);		
		strstatusTypeValues[2]=objOffCommonFunc.readInfoExcel("TestData", 3, 5, strFilePath);
		strstatusTypeValues[3]=objOffCommonFunc.readInfoExcel("TestData", 3, 6, strFilePath);
		strstatusTypeValues[4]=objOffCommonFunc.readInfoExcel("TestData", 3, 7, strFilePath);
		strstatusTypeValues[5]=objOffCommonFunc.readInfoExcel("TestData", 3, 8, strFilePath);
		strstatusTypeValues[6]=objOffCommonFunc.readInfoExcel("TestData", 3, 9, strFilePath);
		strstatusTypeValues[7]=objOffCommonFunc.readInfoExcel("TestData", 3, 10, strFilePath);
		strstatusTypeValues[8]=objOffCommonFunc.readInfoExcel("TestData", 3, 11, strFilePath);
		strstatusTypeValues[9]=objOffCommonFunc.readInfoExcel("TestData", 3, 12, strFilePath);
		   
		System.out.println("-----Precondition ends and test execution starts-------");

		login_page1.loginToApplication(strUserNameAndPwd[0],
				strUserNameAndPwd[1]);

		RegionDefault_page1.selectFrame();

		EventManagement_page1.navigateToEventManagement()
                             .clickOnCreateAdHocEventButton()
                             .enterAdHocEventName(objEvent_data.strEventName)
                             .enterAdHocEventDescription(objEvent_data.strEventDescription);
		
		String strEventStartTime = EventManagement_page1.getEventStartDateAndTime();
		
		objEvent_data.strGetEventStartTime = objDts.AddTimeToExistingTimeHourAndMin(strEventStartTime, 0, 10, "yyyy-MMM-dd HH:mm");
		
		objEvent_data.strGetEventStartTime = objDts.converDateFormat(objEvent_data.strGetEventStartTime, "yyyy-MMM-dd HH:mm", "yyyy-MM-dd HH:mm");
		
		objEvent_data.strEventStartTime = objDts.converDateFormat(objEvent_data.strGetEventStartTime, "yyyy-MM-dd HH:mm", "yyyy MMM dd HH mm");
		
		String strStartTimeNew[] =  objEvent_data.strEventStartTime.split(" ");
	
		EventManagement_page1.selectEventStartDateAndTime(strStartTimeNew)
		                     .clickOnNextButton()
                             .verifySelectResourcesDisplayed();
		
		Resource_Page1.clickResource(strResourceValue);
		
		EventManagement_page1.clickOnNextButton()
		  .verifySelectStatusTypesDisplayed();
		
		String[] strStatusTypeNames = { strstatusTypeNames[7],
				strstatusTypeNames[9], strstatusTypeNames[5],
				strstatusTypeNames[8], strstatusTypeNames[6],
				strstatusTypeNames[2], strstatusTypeNames[4],
				strstatusTypeNames[0], strstatusTypeNames[3],
				strstatusTypeNames[1] };	

		EventManagement_page1
				.verifyStatusTypesNameInSelectStausTypePage(strStatusTypeNames);
		
		String[] strStatusTypeValues = { strstatusTypeValues[7],
				strstatusTypeValues[9], strstatusTypeValues[5],
				strstatusTypeValues[8], strstatusTypeValues[6],
				strstatusTypeValues[2], strstatusTypeValues[4],
				strstatusTypeValues[0], strstatusTypeValues[3],
				strstatusTypeValues[1] };

		ResourceType_Page1.clickStatusType(strStatusTypeValues);
		
		EventManagement_page1.clickOnNextButton()
                             .clickOnYesButton()
                            .verifyEventStartTime(objEvent_data.strEventName, objEvent_data.strGetEventStartTime);
		
		objEvent_data.strEventEndTime = objDts.AddDaytoExistingDate(
				objEvent_data.strGetEventStartTime, 1, "yyyy-MM-dd HH:mm");
		
		EventManagement_page1.verifyEventEndTime(objEvent_data.strEventName,
				objEvent_data.strEventEndTime);
			
		EventManagement_page1.verifyEditEventLink(objEvent_data.strEventName)
		                     .verifyCancelEventLink(objEvent_data.strEventName)
		                     .clickOnEditLink(objEvent_data.strEventName);
		
        String strEventStartTimeNew = objDts.AddTimeToExistingTimeHourAndMin(strEventStartTime, 0, 3, "yyyy-MMM-dd HH:mm");
         
        String strGetEventStartTime = objDts.converDateFormat(strEventStartTimeNew, "yyyy-MMM-dd HH:mm", "yyyy-MM-dd HH:mm");
         
        objEvent_data.strEventEndTime = objDts.AddDaytoExistingDate(strGetEventStartTime, 1, "yyyy-MM-dd HH:mm");
		
		objEvent_data.strEventStartTime = objDts.converDateFormat(strGetEventStartTime, "yyyy-MM-dd HH:mm", "yyyy MMM dd HH mm");
		
        String strChangeStartTime[] =  objEvent_data.strEventStartTime.split(" ");
		
		EventManagement_page1.selectEventStartDateAndTime(strChangeStartTime)
		                     .clickOnNextButton()
                             .verifySelectResourcesDisplayed()
                             .clickOnNextButton()
                             .verifySelectStatusTypesDisplayed()
                             .clickOnNextButton()
                             .verifyAdHocEventConfirmationDisplayed()
                             .clickOnYesButton();
		
		Thread.sleep(180000);
                            
		EventManagement_page1.navigateToEventManagementNew()
		                     .verifyEventStartTime(objEvent_data.strEventName, strGetEventStartTime)
		                     .verifyEventEndTime(objEvent_data.strEventName, objEvent_data.strEventEndTime)
		                     .verifyEditEventLink(objEvent_data.strEventName)
		                     .verifyEndEventLink(objEvent_data.strEventName);	
		
		gstrResult = "PASS";
	}
}