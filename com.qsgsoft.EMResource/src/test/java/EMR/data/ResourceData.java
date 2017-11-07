package EMR.data;

import qaFramework.UserDefinedFunctions.Date_Time_settings;
import qaFramework.UserDefinedFunctions.ReadAndWriteFromXMLFile;

public class ResourceData {
	
	public ResourceData() throws Exception {
		
	}
	
	static final String FILEPATH = "ResourceDataXml";
	ReadAndWriteFromXMLFile xml  = new ReadAndWriteFromXMLFile();
	
	public static final String STANDARDRESOURCETYPE						= "Hospital",
							   FIRSTNAME 								= "FN",
							   LASTNAME 								= "LN",
							   STREETADDRESS 							= "StreetAddress",
							   CITY 									= "City",
							   STATE 									= "California",
							   ZIPCODE 									= "12345",
							   COUNTY 									= "Alpine County",
							   SETRAC_RESOURCE_BAYSHORE_MEDICAL 		= "Bayshore Medical",
							   SETRAC_RESOURCE_FREEMAN_WEST				= "Freeman West",
							   SETRAC_RESOURCE_COLUMBUS_COMMUNITY		= "Columbus Community*",
							   WISCONSIN_COLUMBUS_COMMUNITY_HOSPITAL	= "Columbus Community Hospital",
							   LUTHERAN_MEDICAL_CENTER					= "Lutheran Medical Center^ III",
							   STANDARD_RT_CLINIC						= "Clinic";

	public final String eventsResourceName	= xml.read(ResourceTags.EVENTS_RESOURCE_NAME, FILEPATH),
            preferenceResourceName               		= xml.read(ResourceTags.PREFERANCE_RESOURCE, FILEPATH),
            preferenceResource1Abbrevation               = xml.read(ResourceTags.PREFERANCE_RESOURCE1_ABBREVATION, FILEPATH),
            roleBasedResourceName                		= xml.read(ResourceTags.ROLE_BASED_RESOURCE, FILEPATH),
        	sharedResourceNameInMutualAgreementRegion1  = xml.read(ResourceTags.SHARED_RESOURCE_IN_MUTUAL_AID_REGION1, FILEPATH),
	        sharedResourceValueInMutualAgreementRegion1 = xml.read(ResourceTags.SHARED_RESOURCE_VALUE_IN_MUTUAL_AID_REGION1, FILEPATH),
	        sharedResourceName1_Region1					= xml.read(ResourceTags.VIEWS_RESOURCE_NAME, FILEPATH),
	        sharedResourceName2_Region1					= xml.read(ResourceTags.VIEWS_RESOURCE_NAME_1, FILEPATH),
	        sharedResourceName3_Region1					= xml.read(ResourceTags.VIEWS_RESOURCE_NAME_2, FILEPATH),
	        sharedResourceName4_Region1					= xml.read(ResourceTags.VIEWS_RESOURCE_NAME_3, FILEPATH),
	        sharedResourceValue1_Region1				= xml.read(ResourceTags.VIEWS_RESOURCE_VALUE, FILEPATH),
	        sharedResourceValue2_Region1				= xml.read(ResourceTags.VIEWS_RESOURCE_VALUE_1, FILEPATH),
	        sharedResourceValue3_Region1				= xml.read(ResourceTags.VIEWS_RESOURCE_VALUE_2, FILEPATH),
	        sharedResourceValue4_Region1				= xml.read(ResourceTags.VIEWS_RESOURCE_VALUE_3, FILEPATH),
	        sharedResourceNAME1_MutualAgreement_RG1		= xml.read(ResourceTags.SHARED_RESOURCE_NAME1_IN_MUTUAL_AID_REGION1_MR, FILEPATH),
	        sharedResourceVALUE1_MutualAgreement_RG1	= xml.read(ResourceTags.SHARED_RESOURCE_VALUE1_IN_MUTUAL_AID_REGION1_MR, FILEPATH),
	        sharedResourceNAME2_MutualAgreement_RG1		= xml.read(ResourceTags.SHARED_RESOURCE_NAME2_IN_MUTUAL_AID_REGION1_MR, FILEPATH),
	        sharedResourceVALUE2_MutualAgreement_RG1	= xml.read(ResourceTags.SHARED_RESOURCE_VALUE2_IN_MUTUAL_AID_REGION1_MR, FILEPATH),
	        resourceNAME_MutualAgreement_RG1			= xml.read(ResourceTags.NON_SHARED_RESOURCE_NAME_IN_MUTUAL_AID_REGION1_MR, FILEPATH),
	        resourceVALUE_MutualAgreement_RG1			= xml.read(ResourceTags.NON_SHARED_RESOURCE_VALUE_IN_MUTUAL_AID_REGION1_MR, FILEPATH),
    		sharedResourceNAME1_MutualAgreement_RG2		= xml.read(ResourceTags.SHARED_RESOURCE_NAME1_IN_MUTUAL_AID_REGION2_MR, FILEPATH),
	        sharedResourceVALUE1_MutualAgreement_RG2	= xml.read(ResourceTags.SHARED_RESOURCE_VALUE1_IN_MUTUAL_AID_REGION2_MR, FILEPATH),
	        resourceNAME_MutualAgreement_RG2			= xml.read(ResourceTags.NON_SHARED_RESOURCE_NAME_IN_MUTUAL_AID_REGION2_MR, FILEPATH),
	        resourceVALUE_MutualAgreement_RG2			= xml.read(ResourceTags.NON_SHARED_RESOURCE_VALUE_IN_MUTUAL_AID_REGION2_MR, FILEPATH),
	        sharedResourceNAME1_MutualAgreement_RG3		= xml.read(ResourceTags.SHARED_RESOURCE_NAME1_IN_MUTUAL_AID_REGION3_MR, FILEPATH),
	        sharedResourceVALUE1_MutualAgreement_RG3	= xml.read(ResourceTags.SHARED_RESOURCE_VALUE1_IN_MUTUAL_AID_REGION3_MR, FILEPATH),
	        resourceNAME_MutualAgreement_RG3			= xml.read(ResourceTags.NON_SHARED_RESOURCE_NAME_IN_MUTUAL_AID_REGION3_MR, FILEPATH),
	        resourceVALUE_MutualAgreement_RG3			= xml.read(ResourceTags.NON_SHARED_RESOURCE_VALUE_IN_MUTUAL_AID_REGION3_MR, FILEPATH),
	        resource_Name1_In_Region					= xml.read(ResourceTags.RESOURCE_NAME1_IN_REGION, FILEPATH),
	        resource_Name1_Value_In_Region				= xml.read(ResourceTags.RESOURCE_NAME1_VALUE_IN_REGION, FILEPATH),
	        resource_Name2_In_Region					= xml.read(ResourceTags.RESOURCE_NAME2_IN_REGION, FILEPATH),
	        resource_Name2_Value_In_Region				= xml.read(ResourceTags.RESOURCE_NAME2_VALUE_IN_REGION, FILEPATH),
	        Shared_Resource_Name_In_Region				= xml.read(ResourceTags.SHARED_RESOURCE_NAME_IN_REGION, FILEPATH),
	        Shared_Resource_Name_Value_In_Region		= xml.read(ResourceTags.SHARED_RESOURCE_NAME_VALUE_IN_REGION, FILEPATH),
	        resource_Name1_In_Region1					= xml.read(ResourceTags.RESOURCE_NAME1_IN_REGION1, FILEPATH),
	        resource_Name1_Value_In_Region1				= xml.read(ResourceTags.RESOURCE_NAME1_VALUE_IN_REGION1, FILEPATH),
	        resource_Name2_In_Region1					= xml.read(ResourceTags.RESOURCE_NAME2_IN_REGION1, FILEPATH),
	        resource_Name2_Value_In_Region1				= xml.read(ResourceTags.RESOURCE_NAME2_VALUE_IN_REGION1, FILEPATH),
	        resource_Name1_In_Mutual_Aid_Region3		= xml.read(ResourceTags.RESOURCE_NAME1_IN_MUTUAL_AID_REGION3, FILEPATH),
	    	resource_Name1_Value_In_Mutual_Aid_Region3	= xml.read(ResourceTags.RESOURCE_NAME1_VALUE_IN_MUTUAL_AID_REGION3, FILEPATH),
	    	resource_Name2_In_Mutual_Aid_Region3		= xml.read(ResourceTags.RESOURCE_NAME2_IN_IN_MUTUAL_AID_REGION3, FILEPATH),
	    	resource_Name2_Value_In_Mutual_Aid_Region3	= xml.read(ResourceTags.RESOURCE_NAME2_VALUE_IN_MUTUAL_AID_REGION3, FILEPATH);
	        
							   
	public class ResourceCreateData {
		Date_Time_settings dts = new Date_Time_settings();
		String strTimeText = dts.getCurrentDate("MM-dd-yyyy-hhmmss");
		
	public void writeResourceDataToXml(String value, String node) throws Exception {
			xml.write(FILEPATH, value, node);
		}

		public String name 						= "RS" + strTimeText,
					name1						= "RS1" + strTimeText,
					name2 						= "RS2" + strTimeText,
					name3 						= "RS3" + strTimeText,
					sharedRS_Name				= "SharedRS" + strTimeText,
					sharedRS_Name1				= "SharedRS1" + strTimeText,
					sharedRS_Name2				= "SharedRS2" + strTimeText,
					sharedRS_Name3				= "SharedRS3" + strTimeText,
					description 				= "Description",
					abbrevation 				= dts.getCurrentDate("mmss"),
					abbrevation1 				= dts.getCurrentDate("1mmss"),
					abbrevation2 				= dts.getCurrentDate("2mmss"),
					abbrevation3 				= dts.getCurrentDate("3mmss"),
					abbrevation4 				= dts.getCurrentDate("4mmss"),
					abbrevation5 				= dts.getCurrentDate("5mmss"),
					abbrevation6 				= dts.getCurrentDate("6mmss"),
					abbrevation7 				= dts.getCurrentDate("7mmss"),
					abbrevation8 				= dts.getCurrentDate("8mmss"),
					abbrevation9 				= dts.getCurrentDate("9mmss"),
					abbrevation10 				= dts.getCurrentDate("10mmss"),
					abbrevation11				= dts.getCurrentDate("11mmss"),
					subResName					= "SubRS" + strTimeText,
					subResDesc					= "SubResDesc" + strTimeText,
					sharedResourceDescription	= "Shared Resource Description",
					MRE_name4					= "RS4" + strTimeText,
					MRE_name5					= "RS5" + strTimeText,
					SharedRS_Name4				= "SharedRS4" + strTimeText,
					MRE_name6					= "RS6" + strTimeText,
					MRE_name7					= "RS7" + strTimeText,
					MRE_name8					= "RS8" + strTimeText,
					MRE_name9					= "RS9" + strTimeText,
					editName					= "RSEdit" + strTimeText,
					subResName1					= "SubRS1" + strTimeText,
					editName1					= "RSEdit1" + strTimeText,
					editName2					= "RSEdit2" + strTimeText,
					editName3					= "RSEdit3" + strTimeText,
					editName4					= "RSEdit4" + strTimeText;
	}
	
	public static class ResourceTags {
		public static final String EVENTS_RESOURCE_NAME 			= "EventsResourceName",
				FORM_RESOURCE_NAME                          		= "FormResourceName",
				PREFERANCE_RESOURCE                         		= "PreferanceResource",
				PREFERANCE_RESOURCE_VALUE                   		= "PreferanceResourceValue",
				PREFERANCE_RESOURCE1_ABBREVATION            		= "PreferanceResource1Abbrevation",
				ROLE_BASED_RESOURCE                         		= "RloeBasedResource",
				ROLE_BASED_RESOURCE_VALUE                   		= "RloeBasedResourceValue",
				SHARED_RESOURCE_IN_MUTUAL_AID_REGION1       		= "sharedResourceInMutualAidRegion1",
				SHARED_RESOURCE_VALUE_IN_MUTUAL_AID_REGION1 		= "sharedResourceValueInMutualAidRegion1",
				VIEWS_RESOURCE_NAME									= "sharedResourceName1ForViews",
				VIEWS_RESOURCE_NAME_1								= "sharedResourceName2ForViews",
				VIEWS_RESOURCE_NAME_2								= "sharedResourceName3ForViews",
				VIEWS_RESOURCE_NAME_3								= "sharedResourceName4ForViews",
				VIEWS_RESOURCE_VALUE								= "sharedResourceValue1ForViews",
				VIEWS_RESOURCE_VALUE_1								= "sharedResourceValue2ForViews",
				VIEWS_RESOURCE_VALUE_2								= "sharedResourceValue3ForViews",
				VIEWS_RESOURCE_VALUE_3								= "sharedResourceValue4ForViews",
				SHARED_RESOURCE_NAME1_IN_MUTUAL_AID_REGION1_MR		= "MultiRegionRelatedSHAREDResourceNAME1InRegion1",
				SHARED_RESOURCE_VALUE1_IN_MUTUAL_AID_REGION1_MR		= "MultiRegionRelatedSHAREDResourceVALUE1InRegion1",
				SHARED_RESOURCE_NAME2_IN_MUTUAL_AID_REGION1_MR		= "MultiRegionRelatedSHAREDResourceNAME2InRegion1",
				SHARED_RESOURCE_VALUE2_IN_MUTUAL_AID_REGION1_MR		= "MultiRegionRelatedSHAREDResourceVALUE2InRegion1",
				NON_SHARED_RESOURCE_NAME_IN_MUTUAL_AID_REGION1_MR	= "MultiRegionRelatedNON_SHAREDResourceNAME1InRegion1",
				NON_SHARED_RESOURCE_VALUE_IN_MUTUAL_AID_REGION1_MR	= "MultiRegionRelatedResourceVALUE1InRegion1",
				SHARED_RESOURCE_NAME1_IN_MUTUAL_AID_REGION2_MR		= "MultiRegionRelatedSHAREDResourceNAME1InRegion2",
				SHARED_RESOURCE_VALUE1_IN_MUTUAL_AID_REGION2_MR		= "MultiRegionRelatedSHAREDResourceVALUE1InRegion2",
				NON_SHARED_RESOURCE_NAME_IN_MUTUAL_AID_REGION2_MR	= "MultiRegionRelatedNON_SHAREDResourceNAME1InRegion2",
				NON_SHARED_RESOURCE_VALUE_IN_MUTUAL_AID_REGION2_MR	= "MultiRegionRelatedResourceVALUE1InRegion2",
				SHARED_RESOURCE_NAME1_IN_MUTUAL_AID_REGION3_MR		= "MultiRegionRelatedResourceNAME1InRegion3",
				SHARED_RESOURCE_VALUE1_IN_MUTUAL_AID_REGION3_MR		= "MultiRegionRelatedSHAREDResourceVALUE1InRegion3",
				NON_SHARED_RESOURCE_NAME_IN_MUTUAL_AID_REGION3_MR	= "MultiRegionRelatedNON_SHAREDResourceNAME1InRegion3",
				NON_SHARED_RESOURCE_VALUE_IN_MUTUAL_AID_REGION3_MR	= "MultiRegionRelatedResourceVALUE1InRegion3",
				RESOURCE_NAME1_IN_REGION							= "ResourceName1InRegion",
				RESOURCE_NAME1_VALUE_IN_REGION						= "ResourceName1ValueInRegion",
				RESOURCE_NAME2_IN_REGION							= "ResourceName2InRegion",
				RESOURCE_NAME2_VALUE_IN_REGION						= "ResourceName2ValueInRegion",
				SHARED_RESOURCE_NAME_IN_REGION						= "SharedResourceNameInRegion",
				SHARED_RESOURCE_NAME_VALUE_IN_REGION				= "SharedResourceNameValueInRegion",
				RESOURCE_NAME1_IN_REGION1							= "ResourceName1InRegion1",
				RESOURCE_NAME1_VALUE_IN_REGION1						= "ResourceName1ValueInRegion1",
				RESOURCE_NAME2_IN_REGION1							= "ResourceName2InRegion1",
				RESOURCE_NAME2_VALUE_IN_REGION1						= "ResourceName2ValueInRegion1",
				RESOURCE_NAME1_IN_MUTUAL_AID_REGION3				= "ResourceName1InMutualAidRegion3",
				RESOURCE_NAME1_VALUE_IN_MUTUAL_AID_REGION3			= "ResourceName1ValueInMutualAidRegion3",
				RESOURCE_NAME2_IN_IN_MUTUAL_AID_REGION3				= "ResourceName2InMutualAidRegion3",
				RESOURCE_NAME2_VALUE_IN_MUTUAL_AID_REGION3			= "ResourceName2ValueInMutualAidRegion3";
	}
}
