package EMR.data;

import qaFramework.UserDefinedFunctions.Date_Time_settings;
import qaFramework.UserDefinedFunctions.ReadAndWriteFromXMLFile;

public class RegionData {
	
	public RegionData() throws Exception {
		
	}
	
	static final String FILEPATH = "RegionDataXml";
	ReadAndWriteFromXMLFile xml = new ReadAndWriteFromXMLFile();
	

	public static final String REGIONNAME		= "Z_NewSmokeSuite_Region",//"Z_NewSmokeSuite_Region","Z_Auto_BQS-rel12",
			TESTREGION 							= "Z_Auto_BQS_Rel11",
			INTERMEDIX_REGION					= "Intermedix",
			FIRST_NAME							= "FN",
			LAST_NAME 							= "LN",
			TIME_ZONE 							= "(GMT-06:00) Central Time (US, Canada)",
	        SETRACREGION                    	= "SETRAC",
	        STATE_OF_MISSOURI					= "State of Missouri",
	        REGION_WITH_MUTUAL_AGREEMENT1		= "Z_NewSmokeSuite_MutualAid_Reg1",
	    	REGION_WITH_MUTUAL_AGREEMENT2		= "Z_NewSmokeSuite_MutualAid_Reg2",
	    	REGION_WITH_MUTUAL_AGREEMENT3		= "Z_NewBQSSuite_MutualAid_Reg1",
	    	REGION_NAME_2						= "Z_NEW_SUITE_REGION_NAME2",//"Z_Auto_BQSPatch_rel12",
	        REGION_WITH_MUTUAL_AGREEMENT4   	= "Z_NewBQSSuite_MutualAid_Reg1",
	        WISCONSIN_REGION					= "Wisconsin",
	        COLORADO							= "Colorado";
	
	public final String regionWithMutualAid1 = xml.read(RegionTags.REGION_WITH_MUTUAL_AID1, FILEPATH),
			regionWithMutualAid2 = xml.read(RegionTags.REGION_WITH_MUTUAL_AID2, FILEPATH);
	
	public class RegionCreateData {
		Date_Time_settings dts = new Date_Time_settings();
		String timeText = dts.getCurrentDate("MM-dd-yyyy-hhmmss");	
		
		public void writeRegionDataToXml(String value, String node) throws Exception {
			xml.write(FILEPATH, value, node);
		}
		
		public String name	= "Z_Smoke2_build_rel-292",
					  name1	= "Z_Reg1_" + timeText,
					  name2	= "Z_Reg2_" + timeText;		
	}
	
	public static class RegionTags {
		public static final String 
				REGIONNAME	                 	= "RegionName",
				REGION_WITH_MUTUAL_AGREEMENT1	= "RegionWithMutualAgreement1",
				REGION_WITH_MUTUAL_AGREEMENT2	= "RegionWithMutualAgreement2",
				REGION_WITH_MUTUAL_AGREEMENT3	= "RegionWithMutualAgreement3",
				REGION_WITH_MUTUAL_AID1			= "RegionWithMutualAid1",
		        REGION_WITH_MUTUAL_AID2			= "RegionWithMutualAid2";				
	}
}
