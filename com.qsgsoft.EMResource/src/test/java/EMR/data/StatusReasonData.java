package EMR.data;

import qaFramework.UserDefinedFunctions.Date_Time_settings;
import qaFramework.UserDefinedFunctions.ReadAndWriteFromXMLFile;

public class StatusReasonData {
	
	public StatusReasonData() throws Exception {		
	}
	
	static final String FILEPATH = "ReasonDataXml";
	ReadAndWriteFromXMLFile xml = new ReadAndWriteFromXMLFile();

	public static final String POST_HAVBED_INFORMATION 														= "Post HAvBED 2.5.2 Information",
			                   UPDATE_RESOURCE_AVAILAIBILTY_MULTI_REGION									= "Update Resource Availability (multi-region)",
			                   WEBSERVICE_ACTIONS_FOR_UPDATE_RESOURCE_AVAILAIBILTY_INTERFACE_MULTI_REGION	= "postResourceStatus";
			             
	
	public class StatusReasonCreateData {
		Date_Time_settings dts = new Date_Time_settings();
		String timeText = dts.getCurrentDate("MM-dd-yyyy-hhmmss");
		String timeText1 = dts.getCurrentDate("MM-dd-yyyy-hhmm");
		
		
	public void writeInterfaceDataToXml(String value, String node) throws Exception {
			xml.write(FILEPATH, value, node);
		}

	public String name = "Reason" + timeText,
			definition = "Definition of the Reason" + timeText,
			name1      = "Reason1" + timeText,
			definition1 = "Definition of the Reason1" + timeText,
			name2       = "Reason2" + timeText,
			editName	= "edited" + name,
			editDefinition	=  "edited" + definition,
			abbreviation	= dts.getCurrentDate("HHmm"),
			abbreviation1	= "1" + dts.getCurrentDate("HHmm");
	}

	
}
