package EMR.data;

import qaFramework.UserDefinedFunctions.Date_Time_settings;
import qaFramework.UserDefinedFunctions.ReadAndWriteFromXMLFile;

public class ResourceTypeData {
	
	public ResourceTypeData() throws Exception {
		
	}
	
	ReadAndWriteFromXMLFile xml = new ReadAndWriteFromXMLFile();
	static final String FILEPATH = "ResourceTypeDataXml";

	public final String resourceTypeNameInMutualAgreementRegion1 = xml.read(ResourceTypeTags.RESOURCE_TYPE_IN_MUTUAL_AID_REGION1, FILEPATH),
            preferanceResourceType				= xml.read(ResourceTypeTags.PREFERANCES_RESOURCETYPE, FILEPATH),
            resourceTypeName1_Region			= xml.read(ResourceTypeTags.VIEWS_RESOURCE_TYPE_NAME, FILEPATH),
            resourceTypeName2_Region			= xml.read(ResourceTypeTags.VIEWS_RESOURCE_TYPE_NAME_1, FILEPATH),
            resourceTypeValue1_Region			= xml.read(ResourceTypeTags.VIEWS_RESOURCE_TYPE_VALUE, FILEPATH),
            resourceTypeValue2_Region			= xml.read(ResourceTypeTags.VIEWS_RESOURCE_TYPE_VALUE_1, FILEPATH),
            RT_NAME_MutualAgreementRegion1		= xml.read(ResourceTypeTags.RT_NAME_IN_MUTUAL_AGREEMENT_RG1, FILEPATH),
            RT_VALUE_MutualAgreementRegion1		= xml.read(ResourceTypeTags.RT_VALUE_IN_MUTUAL_AGREEMENT_RG1, FILEPATH),
    		RT_NAME_MutualAgreementRegion2		= xml.read(ResourceTypeTags.RT_NAME_IN_MUTUAL_AGREEMENT_RG2, FILEPATH),
            RT_VALUE_MutualAgreementRegion2		= xml.read(ResourceTypeTags.RT_VALUE_IN_MUTUAL_AGREEMENT_RG2, FILEPATH),
    		RT_NAME_MutualAgreementRegion3		= xml.read(ResourceTypeTags.RT_NAME_IN_MUTUAL_AGREEMENT_RG3, FILEPATH),
            RT_VALUE_MutualAgreementRegion3		= xml.read(ResourceTypeTags.RT_VALUE_IN_MUTUAL_AGREEMENT_RG3, FILEPATH),
            RT_Name_In_Region					= xml.read(ResourceTypeTags.RT_NAME_IN_REGION, FILEPATH),
            RT_Value_In_Region					= xml.read(ResourceTypeTags.RT_VALUE_IN_REGION, FILEPATH),
            RT_Name_In_Region1					= xml.read(ResourceTypeTags.RT_NAME_IN_REGION1, FILEPATH),
            RT_Value_In_Region1					= xml.read(ResourceTypeTags.RT_VALUE_IN_REGION1, FILEPATH),
            RT_Name_In_MutualAgreementRegion3	= xml.read(ResourceTypeTags.MRE_RT_NAME_IN_MUTUAL_AGREEMENT_RG3, FILEPATH),
            RT_Value_In_MutualAgreementRegion3	= xml.read(ResourceTypeTags.MRE_RT_VALUE_IN_MUTUAL_AGREEMENT_RG3, FILEPATH);
            
	public class ResourceTypeCreateData {
		Date_Time_settings dts = new Date_Time_settings();
		String strTimeText = dts.getCurrentDate("MM-dd-yyyy-hhmmss");

		public void writeResourceTypeDataToXml(String value, String node) throws Exception {
			xml.write(FILEPATH, value, node);
		}

		public String name 					= "RT" + strTimeText,
					  name1 				= "RT1" + strTimeText,
					  name2 				= "RT2" + strTimeText,
					  name3 				= "RT3" + strTimeText,
					  description 			= "RTDescription"+ strTimeText,
					  subRtName				= "subRt" + strTimeText,
					  subRtDesc				= "subRtDesc" + strTimeText,
					  MRE_name3				= "RT3" + strTimeText,
					  MRE_name4				= "RT4" + strTimeText,
					  MRE_name5				= "RT5" + strTimeText,
					  edited_name			= "RTEdit" + strTimeText,
					  edited_description 	= "RTEditDescription"+ strTimeText;
	   }	
	public static class ResourceTypeTags {
		public static final String PREFERANCES_RESOURCETYPE = "PreferanceResourceType",
				PREFERANCES_RESOURCETYPE_VALUE				= "PreferanceResourceTypeValue",
				RESOURCE_TYPE_IN_MUTUAL_AID_REGION1			= "sharedResourceTypeInMutualAidRegion1",
				RESOURCE_TYPE_VALUE_IN_MUTUAL_AID_REGION1	= "sharedResourceTypeInMutualAidRegion1Value",
				VIEWS_RESOURCE_TYPE_NAME					= "ViewsResourceTypeName",
				VIEWS_RESOURCE_TYPE_NAME_1					= "ViewsResourceTypeName1",
				VIEWS_RESOURCE_TYPE_VALUE					= "ViewsResourceTypeValue",
				VIEWS_RESOURCE_TYPE_VALUE_1					= "ViewsResourceTypeValue1",
				RT_NAME_IN_MUTUAL_AGREEMENT_RG1				= "MultiRegionRelatedResourceTypeNAMEInRegion1",
				RT_VALUE_IN_MUTUAL_AGREEMENT_RG1			= "MultiRegionRelatedResourceTypeVALUEInRegion1",
				RT_NAME_IN_MUTUAL_AGREEMENT_RG2				= "MultiRegionRelatedResourceTypeNAMEInRegion2",
				RT_VALUE_IN_MUTUAL_AGREEMENT_RG2			= "MultiRegionRelatedResourceTypeVALUEInRegion2",
				RT_NAME_IN_MUTUAL_AGREEMENT_RG3				= "MultiRegionRelatedResourceTypeNAMEInRegion3",
				RT_VALUE_IN_MUTUAL_AGREEMENT_RG3			= "MultiRegionRelatedResourceTypeVALUEInRegion3",
				RT_NAME_IN_REGION							= "ResourceTypeNameInRegion",
				RT_VALUE_IN_REGION							= "ResourceTypeValueInRegion",
				RT_NAME_IN_REGION1							= "ResourceTypeNameInRegion1",
				RT_VALUE_IN_REGION1							= "ResourceTypeValueInRegion1",
				MRE_RT_NAME_IN_MUTUAL_AGREEMENT_RG3			= "MREResourceTypeNameInMutualAgreementRegion3",
				MRE_RT_VALUE_IN_MUTUAL_AGREEMENT_RG3		= "MREResourceTypeValueInMutualAgreementRegion3";
				
		
		
	}
}
