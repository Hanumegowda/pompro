package lib.dataObject;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;

public class RegionalInfo_data {

	Date_Time_settings objDate_Time_settings = new Date_Time_settings();
	String strTimeText = objDate_Time_settings.getCurrentDate("MM/dd/yyyy-hhmmss");

	public String strFolderName = "FolderName" + strTimeText,
			      strFolderName1="FolderName1" + strTimeText,
			      strRenamed="Rename"+ strTimeText,
			      strDocumentTitle = "DocumentName" + strTimeText,
			      strDocumentTitle1 = "DocumentName1" + strTimeText,
			      strDocumentTitle2 = "DocumentName2" + strTimeText,
			      strDocumentTitle3 = "ThisDocumentIsToEnterAndVerifyTitleIs75CharacterDocNameTit" + strTimeText,
			      strFileUpload = "UploadTextFilePath",
	              strPdfFileUpload = "UploadPdfFilePath",
	              strHtmlFileUpload = "UploadHtmlFilePath",
	              strFolderName2="FolderName2" + strTimeText,
	              strAllFolders = "All Folders";
}
