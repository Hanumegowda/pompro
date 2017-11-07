package EMR.data;

import qaFramework.UserDefinedFunctions.Date_Time_settings;
import qaFramework.UserDefinedFunctions.ReadAndWriteFromXMLFile;

public class EventSetUpData {
	
	public EventSetUpData() throws Exception {
	}
	
	ReadAndWriteFromXMLFile xml = new ReadAndWriteFromXMLFile();
	static final String FILEPATH = "EventSetUpDataXml";
	
	public static final String NOTIFICATION_LINK	= "Notifications",
			GREEN_COLOUR_IN_EVENT_BANNER	= "green",
			RED_COLOUR_IN_EVENT_BANNER		= "red",
			AMBULANCE_ICON 					= "Ambulance",
			DOCTOR_ICON 					= "Doctor",
			HELICOPTER_ICON 				= "Helicopter",
			CHEMICAL_ICON 					= "Chemical",
			ENVELPOE_ICON 					= "Envelope",
			LANDSLIDE_ICON 					= "Landslide",
			VOLCANO_ICON 					= "Volcano",
			RED_COLOUR 						= "Red",
			GREEN_COLOUR 					= "Green",
			ORANGE_COLOUR 					= "Orange",
			PURPLE_COLOUR					= "Purple",
			AMBER_COLOUR 					= "Amber",
			SILVER_COLOUR 					= "Silver",
			BLUE_COLOUR 					= "Blue",
			AMBER_COLOUR_IN_EVENT_BANNER	= "amber",
			PURPLE_COLOUR_IN_EVENT_BANNER 	= "purple",
			SILVER_COLOUR_IN_EVENT_BANNER	= "silver",
			BLUE_COLOUR_IN_EVENT_BANNER		= "blue",
			SECURITY 						= "Security",
			ORANGE_COLOUR_IN_EVENT_BANNER 	= "orange",
			EVENT_TEMPLATE_ACTIVE_STATUS	= "Active",
			EVENT_TEMPLATE_DISABLED_STATUS 	= "Disabled";
	
	public static final int ZERO	= 0,
			ONE		= 1,
			FIVE	= 5,
			SIX		= 6,
			TW0		= 2; 
	
	public final String SmokeEventTemplate 									= xml.read(EventSetUpTags.SMOKE_EVENT_TEMPLATE, FILEPATH),
			eventTemplateInMutualAidRegion1									= xml.read(EventSetUpTags.EVENT_TEMPLATE_IN_MUTUAL_AGREEMENT_REGION_1, FILEPATH),
			eventTemplate1WithoutNotificationInMutualAidRegion3				= xml.read(EventSetUpTags.EVENT_TEMPLATE1_WITHOUT_NOTIFICATION_IN_MUTUAL_AGREEMENT_REGION3, FILEPATH),
			eventTemplate2WithNotificationInMutualAidRegion3				= xml.read(EventSetUpTags.EVENT_TEMPLATE2_WITH_NOTIFICATION_IN_MUTUAL_AGREEMENT_REGION3, FILEPATH),
			Multi_Region_Event_Template1_Without_Notification_In_Region		= xml.read(EventSetUpTags.MULTI_REGION_EVENT_TEMPLATE1_WITHOUT_NOTIFICATION_IN_REGION, FILEPATH),
			Multi_Region_Event_Template2_With_Notification_In_Region		= xml.read(EventSetUpTags.MULTI_REGION_EVENT_TEMPLATE2_WITH_NOTIFICATION_IN_REGION, FILEPATH),
			Multi_Region_Event_Template3_Without_Notification_In_Region1	= xml.read(EventSetUpTags.MULTI_REGION_EVENT_TEMPLATE3_WITHOUT_NOTIFICATION_IN_REGION1, FILEPATH),
			Multi_Region_Event_Template_With_Address						= xml.read(EventSetUpTags.MULTI_REGION_EVENT_TEMPLATE_WITH_ADDRESS, FILEPATH),
			Multi_Region_Event_Template4_With_Notification_In_Region1		= xml.read(EventSetUpTags.MULTI_REGION_EVENT_TEMPLATE4_WITH_NOTIFICATION_IN_REGION1, FILEPATH),
			EventTemplate1WithoutNotificationInRegion						= xml.read(EventSetUpTags.EVENT_TEMPLATE1_WITHOUT_NOTIFICATION_IN_REGION, FILEPATH),
			EventTemplate2WithNotificationInRegion							= xml.read(EventSetUpTags.EVENT_TEMPLATE2_WITH_NOTIFICATION_IN_REGION, FILEPATH);
	
	public class EventSetUpCreateData {
		
		public void writeEventDataToXml(String value, String node) throws Exception {
			xml.write(FILEPATH, value, node);
		}
		
		Date_Time_settings dts = new Date_Time_settings();
		String strTimeText = dts
				.getCurrentDate("MM-dd-yyyy-hhmmss");

		public String name 				= "ET" + strTimeText,
					  definition 		= "definition" + strTimeText,
					  name1				= "ET1" + strTimeText,
					  definition1 		= "definition1" + strTimeText,
					  name2				= "ET2" + strTimeText,
					  definition2 		= "definition2" + strTimeText,
					  name3				= "ET3" + strTimeText,
					  definition3 		= "definition3" + strTimeText,
					  name4				= "ET4" + strTimeText,
					  definition4 		= "definition4" + strTimeText,
					  name5				= "ET5" + strTimeText,
					  definition5 		= "definition5" + strTimeText,
					  name6				= "ET6" + strTimeText,
					  definition6 		= "definition6" + strTimeText,
					  name7				= "ET7" + strTimeText,
					  definition7 		= "definition7" + strTimeText,
					  name8				= "ET8" + strTimeText,
					  name9				= "ET9" + strTimeText,
					  editname			= "EditEventTemplate" + strTimeText,
					  editdescription	= "Editdescription"	+ strTimeText;
	}
	
	public static class EventSetUpTags {
		public static final String SMOKE_EVENT_TEMPLATE 							= "SmokeEventTemplate",
				EVENT_TEMPLATE_IN_MUTUAL_AGREEMENT_REGION_1							= "eventTemplateInMutualAgreementRegion1",
				EVENT_TEMPLATE1_WITHOUT_NOTIFICATION_IN_MUTUAL_AGREEMENT_REGION3	= "eventTemplate1WithoutNotificationInMutualAgreementRegion3",
				EVENT_TEMPLATE2_WITH_NOTIFICATION_IN_MUTUAL_AGREEMENT_REGION3		= "eventTemplate2WithNotificationInMutualAgreementRegion3",
				MULTI_REGION_EVENT_TEMPLATE1_WITHOUT_NOTIFICATION_IN_REGION			= "MultiRegionEventTemplate1WithoutNotificationInRegion",
				MULTI_REGION_EVENT_TEMPLATE2_WITH_NOTIFICATION_IN_REGION			= "MultiRegionEventTemplate2WithNotificationInRegion",
				MULTI_REGION_EVENT_TEMPLATE3_WITHOUT_NOTIFICATION_IN_REGION1		= "MultiRegionEventTemplate3WithoutNotificationInRegion1",
				MULTI_REGION_EVENT_TEMPLATE_WITH_ADDRESS							= "MultiRegionEventTemplateWithAddress",
				MULTI_REGION_EVENT_TEMPLATE4_WITH_NOTIFICATION_IN_REGION1			= "MultiRegionEventTemplate4WithNotificationInRegion1",
				EVENT_TEMPLATE1_WITHOUT_NOTIFICATION_IN_REGION						= "EventTemplate1WithoutNotificationInRegion",
				EVENT_TEMPLATE2_WITH_NOTIFICATION_IN_REGION							= "EventTemplate2WithNotificationInRegion";
	}
}