package EMR.data;

import qaFramework.UserDefinedFunctions.Date_Time_settings;
import qaFramework.UserDefinedFunctions.ReadAndWriteFromXMLFile;

public class InterfaceData {
	
	public InterfaceData() throws Exception {		
	}
	
//	public static final String INTERFACEKEY  = "1234";
	
	static final String FILEPATH = "InterfaceDataXml";
	ReadAndWriteFromXMLFile xml = new ReadAndWriteFromXMLFile();

	public static final String POST_HAVBED_INFORMATION 														= "Post HAvBED 2.5.2 Information",
			                   UPDATE_RESOURCE_AVAILAIBILTY_MULTI_REGION									= "Update Resource Availability (multi-region)",
			                   WEBSERVICE_ACTIONS_FOR_UPDATE_RESOURCE_AVAILAIBILTY_INTERFACE_MULTI_REGION	= "postResourceStatus",
			                   SCHEMA_FOR_UPDATE_RESOURCE_AVAILAIBILTY_INTERFACE_MULTI_REGION				= "Availability 1.1",
			                   INTERFACE_ACTIVE_STATUS														= "Active",
			                   CONTACT_INFORMATION															= "5555551234",
			           		   WEBSERVICEACTION_FOR_POSTHAvBEDINFORMATION									= "postHAvBEDStatus",
			           		   SCHEMA_FOR_POSTHAvBEDINFORMATION												= "HHS_HAvBED 2.5.2",
			           		   FLEXIBLE_WEBEOC_INTERFACE													= "Flexible WebEOC Interface",
			           		   WEBSERVICEACTION_FOR_FLEXIBLE_WEBEOC_INTERFACE								= "getFacilityStatus",
			           		   SCHEMA_FOR_FLEXIBLE_WEBEOC_INTERFACE											= "ResourceResponse 1.0",
	                           POST_INCOMING_PATIENT														= "Post Incoming Patient",
	                           WEBSERVICEACTION_FOR_POSTINCOMINGPATIENT										= "postIPN",	
							   SCHEMA_FOR_POSTINCOMINGPATIENT												= "IncomingPatientNotificationDefinition 1.0",
							   GET_ACTIVE_EVENTS															= "Get Active Events",
							   WEBSERVICEACTION_FOR_GET_ACTIVE_EVENTS										= "getActiveEvents",
							   SCHEMA_FOR_GET_ACTIVE_EVENTS													= "EM Common Alert Protocol (wraps CAP 1.1) 1.1",
							   GET_REGION_CONFIGURATION 													= "Get Region Configuration",
							   SCHEMA_FOR_GET_REGION_CONFIGURATION 											= "RegionConfiguration 1.0",
							   WEBSERVICEACTION_FOR_GET_REGION_CONFIGURATION 								= "getRegionalConfiguration",
							   LEGACY_GET_HOSPITAL_STATUS													= "Legacy Get Hospital Status",
							   WEBSERVICEACTION_FOR_LAGACY_GET_HOSPITAL_STATUS								= "getHospitalStatus",
							   SCHEMA_FOR_LAGACY_GET_HOSPITAL_STATUS										= "HospitalStatus draft/pre 1.0",
							   GET_HOSPITAL_STATUS															= "Get Hospital Status",
							   WEBSERVICEACTION_FOR_GET_HOSPITAL_STATUS										= "getHospitalStatus",
							   SCHEMA_FOR_GET_HOSPITAL_STATUS												= "EDXL-HAVE / Hospital Status draft/pre 1.0",
							   POST_RESOURCE_DETAIL_STATUS 													= "Post Resource Detail Status",
							   WEBSERVICEACTION_FOR_POST_RESOURCE_DETAIL_STATUS 							= "postResourceDetailStatus",
							   SCHEMA_FOR_POST_RESOURCE_DETAIL_STATUS 										= "ResourceDetailRequest 1.0",
							   GET_EDXL_HAVE												    			= "Get EDXL-HAVE 1.0",
							   WEBSERVICEACTION_FOR_GET_EDXL_HAVE											= "getEdxlHave",
			                   SCHEMA_FOR_GET_EDXL_HAVE														= "EDXL-HAVE 1.0",
			                   UPDATE_CAD_STATUS															= "Update CAD Status",
			                   WEBSERVICEACTION_FOR_UPDATE_CAD_STATUS										= "postCadStatus",
			                   SCHEMA_FOR_UPDATE_CAD_STATUS													= "CADStatus 1.0",
			                   OPTIONAL_STATUS_TYPE_MAPPINGS_SECTION										= "Optional Status Type Mappings",
			                   CUSTOM_STATUS_TYPE_MAPPINGS_SECTION											= "Custom Status Type Mappings",
			                   REQUIRED_STATUS_TYPE_MAPPINGS_SECTION										= "Required Status Type Mappings",
			                   GET_CAD_STATUS																= "Get CAD Status",
			                   WEBSERVICEACTION_FOR_GET_CAD_STATUS											= "getCadStatus",
			                   SCHEMA_FOR_GET_CAD_STATUS													= "CADStatus 1.0",
			                   UPDATE_RESOURCE_AVAILABILITY													= "Update Resource Availability",
			                   WEBSERVICEACTION_FOR_UPDATE_RESOURCE_AVAILABILITY							= "postResourceStatus",
			                   SCHEMA_FOR_UPDATE_RESOURCE_AVAILABILITY										= "ResourceAvailability 1.1",
			                   CHICAGO_GET_HOSPITAL_STATUS													= "Chicago Get Hospital Status",
			                   WEBSERVICEACTION_FOR_CHICAGO_GET_HOSPITAL_STATUS								= "getChicagoStatus",
			                   SCHEMA_FOR_CHICAGO_GET_HOSPITAL_STATUS										= "IDPH_HAvBED 1.0",
			                   POSTINCOMINGPATIENT_INTERFACE_IN_SETRAC										= "PostIncomingpatient";
	
	public static final String OPTIONS[]={"Include?", "Type", "Standard Status Type", "Regional Status Type", "Description"};
	
	public class InterfaceCreateData {
		Date_Time_settings dts = new Date_Time_settings();
		String timeText = dts.getCurrentDate("MM-dd-yyyy-hhmmss");
		String timeText1 = dts.getCurrentDate("MM-dd-yyyy-hhmm");
		
		
	public void writeInterfaceDataToXml(String value, String node) throws Exception {
			xml.write(FILEPATH, value, node);
		}

		public String interface_Key	= dts.getCurrentDate("ddMM"),
				name						= "Interface" + timeText,
				description					= "Description of the interface" + timeText,
				name1						= "Interface1" + timeText,
				description1				= "Description of the interface1" + timeText,
				name2						= "Interface2" + timeText,
				description2				= "Description of the interface2" + timeText,
				name3						= "Interface3" + timeText,
				description3				= "Description of the interface3" + timeText,
				name4						= "Interface4" + timeText,
				description4				= "Description of the interface4" + timeText,
				name5						= "Interface5" + timeText,
				description5				= "Description of the interface5" + timeText,
				name6						= "Interface6" + timeText,
				description6				= "Description of the interface6" + timeText,
				name7						= "Interface7" + timeText,
				description7				= "Description of the interface7" + timeText,
				name8						= "Interface8" + timeText,
				description8				= "Description of the interface8" + timeText,
				parameterName   			= "PARAMETER"+ timeText,
				parameterValue  			= "Value"+ timeText,
				editInterfaceName			= "EdtInterface" + timeText,
				editInterfaceName1			= "EdtInterface1" + timeText,
				editInterfaceName2			= "EdtInterface2" + timeText,
				editInterfaceName3			= "EdtInterface3" + timeText,
				editInterfaceDescription	= "Edited Interface description" + timeText,
				editInterfaceDescription1	= "Edited Interface description1" + timeText,
				editInterfaceDescription2	= "Edited Interface description2" + timeText,
				editInterfaceDescription3	= "Edited Interface description3" + timeText,
				editParameterName			= "EDIT PN" + timeText,
				editParameterValue			= "Edit PV" + timeText,
				editParameterName1			= "EDIT PN1" + timeText,
				editParameterValue1			= "Edit PV1" + timeText,
				editInterfaceName4			= "EdtInterface4" + timeText,
				editInterfaceName5			= "EdtInterface5" + timeText,
				editInterfaceName6			= "EdtInterface6" + timeText,
				editInterfaceName7			= "EdtInterface7" + timeText,
				editInterfaceName8			= "EdtInterface8" + timeText,
				editInterfaceName9			= "EdtInterface9" + timeText,
				editInterfaceName10			= "EdtInterface10" + timeText,
				editInterfaceName11			= "EdtInterface11" + timeText,
				editInterfaceName12			= "EdtInterface12" + timeText,
				editInterfaceName13			= "EdtInterface13" + timeText,
				editInterfaceName14			= "EdtInterface14" + timeText;
	}

	public static class InterfaceTags {
		public static final String INTERFACE_KEY	= "InterfaceKey";

	}
}
