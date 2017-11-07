package lib.dataObject;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;

public class StatusTypes_data {

	Date_Time_settings objDate_Time_settings = new Date_Time_settings();
	String strTimeText = objDate_Time_settings.getCurrentDate("MM/dd/yyyy-hhmmss");
	String strCurrentDate = objDate_Time_settings.getCurrentDate("MM/dd/yyyy");
	String strFutureDate = objDate_Time_settings.getFutureDay(2, "MM/dd/yyyy");

	public String strNumberStatusType = "Number", strTextStatusType = "Text",
			strMultiStatusType = "Multi",
			strSaturationScoreStatusType = "Saturation Score",
			strNedocCalculationStatusType = "NEDOCS Calculation",
			strNSTStatusTypeName = "NST" + strTimeText,
			strPNSTStatusTypeName = "PNST" + strTimeText,
			strTSTStatusTypeName = "TST" + strTimeText,
			strMSTStatusTypeName = "MST" + strTimeText,
			strSSTStatusTypeName = "SST" + strTimeText,
			strSSSTStatusTypeName = "SSST" + strTimeText,
			strNDSTStatusTypeName = "NDST" + strTimeText,
			streNSTStatusTypeName = "eNST" + strTimeText,
			streTSTStatusTypeName = "eTST" + strTimeText,
			streMSTStatusTypeName = "eMST" + strTimeText,
			streSSTStatusTypeName = "eSST" + strTimeText,
			streNDSTStatusTypeName = "eNDST" + strTimeText,
			strStatusDescription = "Automation",
			strStatusExpirationTime = "05",
			strNSTStatusTypeName1 = "NST1" + strTimeText,
			strTSTStatusTypeName1 = "TST1" + strTimeText,
			strMSTStatusTypeName1 = "MST1" + strTimeText,
			strSSTStatusTypeName1 = "SST1" + strTimeText,
			strNDSTStatusTypeName1 = "NDST1" + strTimeText,
			strUncategorizedValInSection = "Uncategorized",
			strStatusNameInMulti = "SN"+ strTimeText,
			strStatusNameInMulti1 = "SN1"+ strTimeText,
	        strNSTStatusTypeName2 = "NST2" + strTimeText,
			strTSTStatusTypeName2 = "TST2" + strTimeText,
			strMSTStatusTypeName2 = "MST2" + strTimeText,
			strSSTStatusTypeName2 = "SST2" + strTimeText,
			strNDSTStatusTypeName2 = "NDST2" + strTimeText,
			strNDSTStatusTypeName3 = "NDST3" + strTimeText,
			strNotApllicable = "N/A",
			strDashStatusTypes = "--",
			strpSSTStatusTypeName = "PSST" + strTimeText,
			strpeTSTStatusTypeName = "peTST" + strTimeText,
			streNSTStatusTypeName1 = "eNST1" + strTimeText,
			streTSTStatusTypeName1 = "eTST1" + strTimeText,
			streMSTStatusTypeName1 = "eMST1" + strTimeText,
			streSSTStatusTypeName1 = "eSST1" + strTimeText,
			streNDSTStatusTypeName1 = "eNDST1" + strTimeText,
			streNSTStatusTypeName2 = "eNST2" + strTimeText,
			streTSTStatusTypeName2 = "eTST2" + strTimeText,
			streMSTStatusTypeName2 = "eMST2" + strTimeText,
			streSSTStatusTypeName2 = "eSST2" + strTimeText,
			streNDSTStatusTypeName2 = "eNDST2" + strTimeText,
			strStandardStatusTypename = "Average Wait Time",
			strStandardStatusTypename1="Bed Capacity: Long Term Care",
			strStandardStatusTypename2="Contact: Last Name",
			strStandardStatusTypename4="Clinical Status",
			strTextStandardStatusTypename="Utilities Notes",
			strpMSTStatusTypeName = "pMST" + strTimeText,
			strDateStatusType = "Date",
			strDateStatusTypeName = "Date" + strTimeText,
			strDateStatusTypeName1 = "Date1" + strTimeText,
			strDateStatusTypeName2 = "Date2" + strTimeText,
			streDateStatusTypeName = "eDate" + strTimeText,
			streDateStatusTypeName1 = "eDate1" + strTimeText,
			streDateStatusTypeName2 = "eDate2" + strTimeText,
			strStatusColor = "Purple",
			strNoStatus = "No Status",
			strDateFromRange = strCurrentDate,
			strDateToRange = strFutureDate,
			strStatusExpirationTime1 = "10",
			strStatusNameIn25Char = "Status25"+ strTimeText,
			strStatusName1Char="C",
			strStatusNameInMulti2 = "SN2"+ strTimeText,
			strStatusNameInMulti3 = "SN3"+ strTimeText,
			strStatusNameInMulti4 = "SN4"+ strTimeText,
			strStatusNameInMulti5 = "SN5"+ strTimeText,
			strStatusNameInMulti6 = "SN6"+ strTimeText,
	        strStatusNameInMulti7 = "SN7"+ strTimeText,
	        strStatusNameInMulti8 = "SN8"+ strTimeText,
	        strStatusNameInMulti9 = "SN9"+ strTimeText,
	        strStatusNameInMulti10 = "SN10"+ strTimeText,
	     	 strStatusNameInMulti11 = "SN11"+ strTimeText,
	     	strMSTStatusTypeName3 = "MST3" + strTimeText,
	       strMSTStatusTypeName4 = "MST4" + strTimeText,
	    	strMSTStatusTypeName5 = "MST5" + strTimeText,
	    	strMSTStatusTypeName6 = "MST6" + strTimeText,
			strStandardStatusTypeLabel = "Average Wait Time:",
			eventOnlyYes = "Yes",
			eventOnlyNo = "No",
			strExpMin="00",
			strExpSec="05",
			countDownAndStopCounting = "Count down to expiration, then stop counting",
			countUptoExpThenStop = "Count up to expiration, then stop counting",
			countUptoExpThenStart = "Count up to expiration, then start counting up again from zero",
			countDownToExpThenCountUp = "Count down to expiration, then count up",
			strEdStatusNameInMulti = "Ed"+ strStatusNameInMulti,
			strStatusDescription2 = "Automation2",
			strOrder1 = "1",
			strOrder2 = "2",
			strOrder3 = "3",
			strsMSTStatusTypeName = "sMST" + strTimeText,
			strsSSTStatusTypeName = "sSST" + strTimeText,
			strsTSTStatusTypeName = "sTST" + strTimeText,
			strpTSTStatusTypeName = "pTST" + strTimeText,
			strpDateStatusTypeName = "pDate" + strTimeText,
			strpNDSTStatusTypeName = "pNDST" + strTimeText,
			strsNSTStatusTypeName1 = "sNST1" + strTimeText,
			strsTSTStatusTypeName1 = "sTST1" + strTimeText,
			strsMSTStatusTypeName1 = "sMST1" + strTimeText,
			strsSSTStatusTypeName1 = "sSST1" + strTimeText,
			strsNDSTStatusTypeName1 = "sNDST1" + strTimeText,
			strGreenColor = "Green",
			strStandardStatusTypename3="CEO Name",
			strStandardStatusTypeName2 = "Bed Availability: Adult ICU",
			strSNSTStatusTypeName = "sNST" + strTimeText,
			strStandardStatusTypeName4 = "FL: Active",
			strStandardStatusTypeName5 = "File Number",
			strNSTStatusTypeName3 = "NST3" + strTimeText,
			noSectionAssigned	= "No Section Assigned";

}