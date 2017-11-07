package EMR.data;

import qaFramework.UserDefinedFunctions.Date_Time_settings;

public class ManualIPNEntryData {

    
	public ManualIPNEntryData() throws Exception{
     }
	
     public static final String MALE			 = "MALE",
     							AGE 		   	 = "30",
     							CHEIF_COMPLAINT  = "UNKNOWN",
     							TRAIAGE_CATEGORY = "GREEN",
     							LEVEL_OF_CARE	 = "BLS",
     							TANSPORTING_TO	 = "Columbus Community*",
     							ETA 			 = "5";
     
     public class ManualIPNEntryCreateData {
 		Date_Time_settings dts = new Date_Time_settings();
 		String timeText = dts.getCurrentDate("MM-dd-yyyy-hhmmss");
 		String timeText1 = dts.getCurrentDate("MM-dd-yyyy-hhmm");
 		
     public String ManualIPNEntry_Keys	= dts.getCurrentDate("ddMM"),
    		 		emsAgency 			= "EMSAgency"+timeText,
    		 		emsUnit				= "EMSUnit"+timeText;
 }
}