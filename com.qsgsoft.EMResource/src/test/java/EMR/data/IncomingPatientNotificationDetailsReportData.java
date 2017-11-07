package EMR.data;

import qaFramework.UserDefinedFunctions.Date_Time_settings;

public class IncomingPatientNotificationDetailsReportData {

	 public IncomingPatientNotificationDetailsReportData() throws Exception {
		 
	 }
	 public class IncomingPatientNotificationDetailsReportCreateData {
			
		 		Date_Time_settings dts = new Date_Time_settings();
		 		String timeText = dts.getCurrentDate("MM/dd/yyyy");
		 		String timeText1 = dts.getCurrentDate("MM-dd-yyyy-hhmm");
		
		public String IncomingPatientNotificationDeatisReport_Keys = dts.getCurrentDate("ddMM"),
				           startDate	 = timeText,
						   endDate 		 = timeText;
 }
	 
	 
}