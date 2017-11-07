package EMR.data;

import java.util.ArrayList;
import java.util.Arrays;

import com.sun.javafx.binding.SelectBinding.AsLong;

import qaFramework.UserDefinedFunctions.Date_Time_settings;
import qaFramework.UserDefinedFunctions.ReadAndWriteFromXMLFile;

public class UpdateStatusData {

	public UpdateStatusData(){
	}

	ReadAndWriteFromXMLFile xml = new ReadAndWriteFromXMLFile();

	public final static String CALCULATED_SATURATION_SCORE1="429",
			CALCULATED_NEDOCS_SCORE1="241 - Disaster",
			CALCULATED_SATURATION_SCORE2="481",
			CALCULATED_NEDOCS_SCORE2="394 - Disaster",
			CALCULATED_NEDOCS_SCORE3="325 - Disaster",
			NOT_UPDATED="--",   
			ZERO_UPDATED="0",
			VALUE_19 ="19",
			VALUE_90 ="90",
			VALUE_254="254",
			CALCULATED_SATURATION_SCORE_17="17",
	        CALCULATED_DISASTER_SCORE_241 ="241",
	        CALCULATED_SATURATION_SCORE_429="429",
	        CALCULATED_SATURATION_SCORE_481="481";

	public static String[] SATURATIONSCORE_VALUES_TO_UPDATE1 = {"1", "2", "3", "4", "5", "6", "7","8","9"},
			SATURATIONSCORE_VALUES_TO_UPDATE2 = {"3", "4", "5", "6", "7","8", "9","10","11"},
			NEDOCS_VALUES_TO_UPDATE1          = {"1", "2", "3", "4", "5", "6","7"}, 
			NEDOCS_VALUES_TO_UPDATE2          = {"3", "4", "5", "6", "7", "8","9"},
			NEDOCS_VALUES_TO_UPDATE3          = {"2","3", "4", "5", "6", "7", "8"},
			SATURATIONSCORE_VALUES_TO_UPDATE3 = {"1", "2", "3", "2", "9", "2", "2","88","98"};
	public static ArrayList<String> NEDOCS_VALUES_TO_UPDATE = new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5", "6","7")),
			COMMENT_LAST_UPDATE_BY_USER = new ArrayList<String>(Arrays.asList("Comment", "Last Update", "By User")),
			LAST_UPDATE	= new ArrayList<>(Arrays.asList("Last Update")),
			COMMENT_LAST_UPDATE	= new ArrayList<>(Arrays.asList("Comment", "Last Update"));

	public class UpdateStatusCreateData {

		Date_Time_settings dts = new Date_Time_settings();
		String currentDate = dts.getCurrentDate("MM/dd/yyyy"); 
		String numberToUpdate = dts.getCurrentDate("d");
		String numberToUpdate1 = dts.getCurrentDate("mm");
		String timeStamp = "" + System.currentTimeMillis();

		public String currentDateToUpdate = currentDate,
				numberValueToUpdate = numberToUpdate,
				textValueToUpdate = "Text" + timeStamp,
				textValueToUpdate1 = "Text1" + timeStamp,
				textValueToUpdate2 = "Text2" + timeStamp,
				textValueToUpdate3 = "Text3" + timeStamp,
				numberValueToUpdate1 = numberToUpdate.concat(numberToUpdate1),
				numberToUpdate_dynamic = dts.getCurrentDate("ms"),
				numberToUpdate_dynamic1 = "1" + dts.getCurrentDate("ms"),
				numberToUpdate_dynamic2 = "2" + dts.getCurrentDate("ms"),
				numberToUpdate_dynamic3 = "3" + dts.getCurrentDate("ms"),
				numberToUpdate_dynamic4 = "4" + dts.getCurrentDate("ms"),
				numberToUpdate_dynamic5 = "5" + dts.getCurrentDate("ms"),
				numberToUpdate_dynamic6 = "6" + dts.getCurrentDate("ms"),
				numberToUpdate_dynamic7 = "7" + dts.getCurrentDate("ms"),
				numberToUpdate_dynamic8 = "8" + dts.getCurrentDate("ms"),
				numberToUpdate_dynamic9 = "9" + dts.getCurrentDate("ms");

	}
}
