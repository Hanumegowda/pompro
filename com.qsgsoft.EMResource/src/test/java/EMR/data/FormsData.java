package EMR.data;

import qaFramework.UserDefinedFunctions.Date_Time_settings;
import qaFramework.UserDefinedFunctions.ReadAndWriteFromXMLFile;

public class FormsData {
	
	public FormsData() throws Exception {		
	}
	
	static final String FILEPATH = "FormsDataXml";
	ReadAndWriteFromXMLFile xml = new ReadAndWriteFromXMLFile();

	public static final String USERINITIATEANDOTHERTOFILLOUT  = "User Initiate & Other To Fill Out",
			                   USERTOINDIVIDUALUSERS 		  = "User To Individual Users",
			                   OLDGROUP 					  = "GroupName",
			                   OLDFIELDSET					  = "FieldSet",
			                   OLDQUESTIONNAIRE 			  = "Questionnaire",
			                   OLDQUESTIONNAIRE1 			  = "Questionnaire1",
			                   OLDQUESTIONNAIRE2 			  = "Questionnaire2",
			                   QUESTIONNAIRETYPENUMERIC 	  = "Numeric",
			                   QUESTIONNAIRETYPETEXT 		  = "Single Line Text",
			                   QUESTIONNAIRETYPECHECKBOX 	  = "Checkbox",
			                   QUESTIONNAIRETYPETEXTAREA 	  = "Multi-Line Text",
			                   USERTOUSERSANDRESOURCES 	      = "User To Users And Resources",
			                   INITIATEANDFILLOUTHIMORHERSELF = "User Initiate & Fill Out Him/Herself",
			                   NUMERICANSWER 				  = "55",
			                   TEXTANSWER 					  = "text",
			                   MULTITEXTANSWER 			      = "Multi Line text",
			                   CHOICE 						  = "Choice1",
			                   ASCERTAINSTATUSCHANGES         ="As Certain Status Changes";
	
	public final String oldFormName	        = xml.read(FormsTags.EXISTINGFORMNAME, FILEPATH),
			            oldFormDescription	= xml.read(FormsTags.EXISTINGFORMDESCRIPTION, FILEPATH),
			            formGroup           = xml.read(FormsTags.FORMGROUP, FILEPATH),
			            formFieldset        = xml.read(FormsTags.FORMFIELDSET, FILEPATH),
			            formLabelName       = xml.read(FormsTags.FORMLABELNAME, FILEPATH),
			            formLabelName1      = xml.read(FormsTags.FORMLABELNAME1, FILEPATH),
			            formLabelName2      = xml.read(FormsTags.FORMLABELNAME2, FILEPATH);
	
	public class FormsCreateData {
		Date_Time_settings dts = new Date_Time_settings();
		String timeText = dts.getCurrentDate("MM-dd-yyyy-hhmmss");
		
	public void writeFormsDataToXml(String value, String node) throws Exception {
			xml.write(FILEPATH, value, node);
		}

		public String name 		= "Form" + timeText,
				description 	= "Disc" + timeText,
				editName 		= "Edit" + name,
				editDescription	= "Edit" + description,
				group 			= "Grp" + timeText,
				fieldSet 		= "Field" + timeText,
				labelName 		= "label" + timeText,
				labelName1 		= "label1_" + timeText,
				labelName2 		= "label2_" + timeText,
				labelName3 		= "label3_" + timeText,
				editLabel 		= "Edit" + labelName,
				choiceName		= "Option" + timeText;	

	}

	public static class FormsTags {
		public static final String EXISTINGFORMNAME = "FormName",
				FORMGROUP        		= "GroupName",                           
		        FORMFIELDSET     		= "FieldSet",
		        FORMLABELNAME    		= "LabelName",
		        FORMLABELNAME1   		= "LabelName1",
		        FORMLABELNAME2          = "LabelName2",
		        EXISTINGFORMDESCRIPTION = "FormDescription";	
				
	}
}
