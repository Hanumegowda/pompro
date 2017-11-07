package EMR.data;

import qaFramework.UserDefinedFunctions.Date_Time_settings;
import qaFramework.UserDefinedFunctions.ReadAndWriteFromXMLFile;

public class RolesData {
	
	public RolesData() throws Exception {
	}
	
	static final String FILEPATH = "RolesDataXml";
	ReadAndWriteFromXMLFile xml = new ReadAndWriteFromXMLFile();
	
	public final String roleValue1				= xml.read(RolesTags.ROLE_VALUE_1, FILEPATH),
			roleName1							= xml.read(RolesTags.ROLE_NAME_1, FILEPATH),
			setrac_Region_Role_Without_Rights	= xml.read(RolesTags.SETRAC_REGION_ROLE_WITHOUT_ANY_RIGHT, FILEPATH);
	
	public class RolesCreateData {
		
		public void writeRolesDataToXml(String value, String node) throws Exception {
			xml.write(FILEPATH, value, node);
		}
		
		Date_Time_settings dts = new Date_Time_settings();
		String strTimeText = dts.getCurrentDate("MM-dd-yyyy-hhmmss");

		public String name 	= "Role" + strTimeText,
					  name1 = "Role1_" + strTimeText,
					  name2 = "Role2_" + strTimeText;
	}

	public static class RolesTags {
		public static final String ROLE_NAME_1				= "RoleName1",
				ROLE_NAME_2									= "RoleName2", 
				ROLE_VALUE_1								= "Role1Value",
				ROLE_VALUE_2								= "Role2Value",
				SETRAC_REGION_ROLE							= "SetracRegionRole",
				SETRAC_REGION_ROLE_VALUE					= "SetracRegionRoleValue",
				STATE_OF_MISSOURI_ROLE_VALUE				= "StateOfMissouriRoleValue",
				STATE_OF_MISSOURI_ROLE_NAME					= "StateOfMissouriRoleName",
				PREFERANCE_ROLE								= "StatusChangePreferanceRole",
				PREFERANCE_ROLE_VALUE						= "StatusChangePreferanceRoleValue",
				ROLE_IN_MUTUAL_AID_REGION2					= "MutualAidRole",
				ROLE_VALUE_IN_MUTUAL_AID_REGION2			= "MutualAidRoleVAlue",
				SETRAC_REGION_ROLE_WITHOUT_ANY_RIGHT		= "SetracRegionRoleWithoutAnyRight",
				SETRAC_REGION_ROLE_VALUE_WITHOUT_ANY_RIGHT	= "SetracRegionRoleValueWithoutAnyRight";
	}
}
