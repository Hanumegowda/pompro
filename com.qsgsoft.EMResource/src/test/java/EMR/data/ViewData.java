package EMR.data;

import qaFramework.UserDefinedFunctions.Date_Time_settings;
import qaFramework.UserDefinedFunctions.ReadAndWriteFromXMLFile;

public class ViewData {
	
	public ViewData() throws Exception {
		
	}
	
	static final String FILEPATH = "SectionDataXml";
	ReadAndWriteFromXMLFile xml  = new ReadAndWriteFromXMLFile();
	
	public static final String DESCRIPTION = "ViewDescription",
			NO_SECTION_ASSIGNED = "No Section Assigned";
	
	public final String sectionNameWithRoledStatusTypes	= xml.read(ViewTags.SECTION_WITH_ROLED_STATUSTYPES, FILEPATH),
			hybridViewName								= xml.read(ViewTags.SMOKE_HYBRID_VIEW, FILEPATH),
			SummaryViewName								= xml.read(ViewTags.SMOKE_SUMMARY_VIEW, FILEPATH),
			SummaryPlusViewName							= xml.read(ViewTags.SMOKE_SUMMARY_PLUS_VIEW, FILEPATH),
			ResourceViewName							= xml.read(ViewTags.SMOKE_RESOURCE_VIEW, FILEPATH),
			sectionInMutualAgreementRegion1				= xml.read(ViewTags.SECTION_IN_MUTUAL_AID_REGION1, FILEPATH),
			sectionForEventBasedSTsInMutualAidRegion1	= xml.read(ViewTags.SECTION_FOR_EVENTS_ST_IN_MUTUAL_AID_REGION1, FILEPATH),
			sectionInMutualAgreementRegion2				= xml.read(ViewTags.SECTION_IN_MUTUAL_AID_REGION2, FILEPATH),
			sectionInMutualAgreementRegion3				= xml.read(ViewTags.SECTION_IN_MUTUAL_AID_REGION3, FILEPATH),
			sectionInRegionName							= xml.read(ViewTags.SECTION_IN_REGION_NAME, FILEPATH),
			sectionInRegionName2						= xml.read(ViewTags.SECTION_IN_REGION_NAME_2, FILEPATH),
			sectionInRegionWithMutualAgreement3			= xml.read(ViewTags.SECTION_IN_REGION_WITH_MUTUAL_AGREEMENT3, FILEPATH);
    
	public class ViewCreateData {
		
		Date_Time_settings dts = new Date_Time_settings();
		String timeText = dts.getCurrentDate("MMddyyyyHHmmss");
		
		public String name           	= "View" + timeText,				  
					  section         	= "Section"  +timeText,
					  section_1         = "Section1"  +timeText,
					  section_2         = "Section2"  +timeText,
					  section_3         = "Section3"  +timeText,
					  section_4         = "Section4"  +timeText,
					  section_5         = "Section5"  +timeText,
					  section_6         = "Section6"  +timeText,
		              multiRegViewName	= "MultiRegView" + timeText,
		              name1 		 	= "View1" + timeText,
		              name2          	= "View2" + timeText,
		              name3 		 	= "View3" + timeText,
		              name4          	= "View4" + timeText,
		              name5          	= "View5" + timeText,
		    	      name6           	= "View6" + timeText,
		    	      name7				= "View7" + timeText,
		    	      name8				= "View8" + timeText,
		    	      description		= "description" + timeText,
		    	      description1		= "description1" + timeText,
		    	      description2		= "description2" + timeText,
		    	      description3		= "description3" + timeText,
		    	      description4		= "description4" + timeText,
		    	      description5		= "description5" + timeText,
		    	      description6		= "description6" + timeText,
		    	      editedName		= "ViewEdit" + timeText;
		
		public void writeViewDataToXml(String value, String node) throws Exception {
			xml.write(FILEPATH, value, node);
		}
	    	    	              
	}
	
	public static class ViewTags {
		public static final String SECTION_WITH_ROLED_STATUSTYPES = "SectionWithRoleBasedStatusTypes",
				SMOKE_HYBRID_VIEW							= "SmokeHybridView",
				SMOKE_SUMMARY_VIEW							= "SmokeSummaryView",
				SMOKE_SUMMARY_PLUS_VIEW						= "SmokeSummaryPlusView",
				SMOKE_RESOURCE_VIEW							= "SmokeResourceView",
				SECTION_IN_MUTUAL_AID_REGION1				= "sectionInMutualAgreementRegion1",
				SECTION_FOR_EVENTS_ST_IN_MUTUAL_AID_REGION1	= "sectionForEventBasedSTsInMutualAidRegion1",
				SECTION_IN_MUTUAL_AID_REGION2				= "sectionInMutualAgreementRegion2",
				SECTION_IN_MUTUAL_AID_REGION3				= "sectionInMutualAgreementRegion3",
				SECTION_IN_REGION_NAME 						= "sectionInRegionName",
				SECTION_IN_REGION_NAME_2 					= "sectionInRegionName2",
				SECTION_IN_REGION_WITH_MUTUAL_AGREEMENT3	= "sectionInRegionWithMutualAgreement3";
	}
}
