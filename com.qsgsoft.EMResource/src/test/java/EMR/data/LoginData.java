package EMR.data;

import qaFramework.UserDefinedFunctions.Date_Time_settings;

public class LoginData {

	public static final String ADMINUSERNAME = "qsgtester",
			QSGTESTER_ADMIN = "qsgtester",
			ADMINPASSWORD	= "Abc@1234",
			ADMIN_USER_FULL_NAME = "QSG Tester";

	public static class LoginCreateData {
		Date_Time_settings dts = new Date_Time_settings();
		String timeText = dts.getCurrentDate("MM-dd-yyyy-hhmmss");

		public String name 				= "Form" + timeText,
					  description 		= "Disc" + timeText,
					  editName 			= "Edit" + name,
					  editDescription 	= "Edit" + description,
					  group 			= "Grp" + timeText,
					  fieldSet 			= "Field" + timeText,
					  labelName 		= "label" + timeText,
					  labelName1 		= "label1_" + timeText,
					  labelName2 		= "label2_" + timeText,
					  labelName3 		= "label3_" + timeText,
					  editLabel 		= "Edit" + labelName;

	}

	public static class LoginTags {

	}
}

