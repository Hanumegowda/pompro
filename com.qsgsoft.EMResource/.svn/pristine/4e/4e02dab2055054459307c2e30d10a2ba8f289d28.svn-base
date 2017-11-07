package EMTrack.data;

import qaFramework.UserDefinedFunctions.Date_Time_settings;

public class EMTrackData {
	    
	public static final String   GENDERMALE					= "Male",
			BAYSHORE_MEDICAL_HOSPITAL						= "Bayshore Medical",
			DISASTER_EMS_UNIT_PROVIDER						= "Disaster EMS Unit",
			PROVIDERUNIT									= "Squad 1",
			ETA			    								= "5",
			CHIEFCOMPLAINT  								= "unknown",
			TRIAGE          								= "Immediate",
			LEVELOFCARE     								= "-",
		    EMSAGENCY       								= "-",
		    EMSUNIT         								= "-",
		    GENDER_FEMALE									= "Female",
		    WISCONSIN_REGION_COLUMBUS_COMMUNITY_HOSPITAL	= "Columbus Community Hospital",
		    ASMC_BUS_PROVIDER								= "ASMC Bus",
		    AURORA_MEDICAL_CENTER_SUMMIT					= "Aurora Medical Center Summit",
		    SETRAC_REGION_COLUMBUS_COMMUNITY				= "Columbus Community",
		    FORM_NAME										= "QA_EMR_Integration",
		    UNSPECIFIED										= "Unspecified";
			
	
	public static final String[] IPN_PATIENT_HEADERS= {"Sent By:", "Age:", "Complaint:",
		"Triage:", "Gender:", "Region:","Level of Care:","EMS Agency:","EMS Unit:"};
	    
	public class EMTrackCreateData{
		Date_Time_settings dts = new Date_Time_settings();
		String strTimeText     = dts.getCurrentDate("MM-dd-yyyy-hhmmss");
		String strAge          = dts.getCurrentDate("d");
		String strAge1		   = dts.getCurrentDate("d");
		String strAge2		   = dts.getCurrentDate("d");
		
		public String patientId  = "AutoPatientId" + strTimeText,
					  patientId1 = "AutoPatientId1" + strTimeText,
					  patientId2 = "AutoPatientId2" + strTimeText,
					  age    =   strAge,
					  age1	 =   strAge1,
					  age2	 =   strAge2;
	}
}
