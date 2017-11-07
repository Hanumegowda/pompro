package EMR.Locators;

public class FormConfiguration {

	public static class Locators {
		public static final String CLOSINGBRACKET = "']",
				TWOCLOSINGBRACES 			= "')]",
				TABLECELLWITHTEXT 			= "//td[text()='",
				TITLE 						= "input[name='title']", 
				DESCRIPTION 				= "textarea[name='description']",
				CREATENEWFORMTEMPLETE 		= "input[value='Create New Form Template']",
				HEADER 						= "div#topSubNav > h1",
				ACTIVATION 					= "select[name='promptType']",
				FORMDELIVERY 				= "select[name='recipientType']",
				NEXTBUTTON 					= "input[value='Next']",
				SAVE 						= "input[value='Save']",
				EDITFORMTEMPLATE 			= "//div/h1[text()='Edit Form Template']",
				ALLUSERSCHECKBOX 			= "//FORM[text()='All Users']/input[@name='allUsersInd']",
				USERTOFILLOUTPART1 			= "//table[@id='tbl_userID']/tbody/tr/td[3][contains(text(),'",
				USERTOFILLOUTPART2 			= "')]/parent::tr/td[1]/input",
				USERTOACTIVATEPART1 		= "//table[@id='tbl_userID']/tbody/tr/td[5][text()='",
				USERTOACTIVATEPART2 		= "']/preceding-sibling::td[4]/input",
				QUESTIONNAIRELINK 			= "']/parent::tr/td/a[text()='Questionnaire']",
				RESOURCETOFILL 				= "']/preceding-sibling::td/input",
				FORMTITLE 					= "//div[@id='content']//div//h2/span[contains(text(),'",
				EDITOFFORM 					= "']/parent::tr/td/a[text()='Edit']",
				FORMTITLEANDDESCRIPTION 	= "']/following-sibling::td[text()='",
				NOTIFYVIAWEB				= "input[name='web']",
				NOTIFYVIAEMAIL				= "input[name='email']",
				NOTIFYVIAPAGER				= "input[name='pager']",
				CANCELBUTTON				= "input[value='Cancel']",
				RESOURCENAME				= "']/preceding-sibling::td[text()='",
				FORM_ACTVATION_STATUS_TYPES	= "//table[@summary='Status Types']/tbody/tr/td[text()='",
				FIRST_SECURITY_LINK_CORRESPONDING_TO_FORM = "//div[@id='mainContainer']/table/tbody/tr[1]/td[1]/a[text()='Security']",
				ROLE_IN_DROPDOWN			= "//select[@id='tbl_userID_ROLE']/option[@value='";
	}
}
