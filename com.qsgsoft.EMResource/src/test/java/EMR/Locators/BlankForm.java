package EMR.Locators;

public class BlankForm {

	public static class Locators {

		public static final String CLOSINGBRACKETS = "']",
				SPANWITHTEXT				= "//span[text()='",
				CLOSINGTWOBRACES 			= "')]",
				SAVEASDRAFT 				= "//button[@class='btn'][text()='Save as Draft']",
				FORMFRAME 					= "myiframe",
				SUBMIT 						= "//span[text()='Submit']/parent::button[@class='btn btn-primary']",
				SENDFORM 					= "input[value='Send Form']",
				TITLEOFFORM 				= "//div[@id='header']//div//h3[contains(text(),'",
				GROUPNAME 					= "//span[text()='",
				FIELDSETNAME 				= "//fieldset/legend[text()='",
				NUMERICANDTEXTANSWERPART1 	= "//label/span[text()='",
				NUMERICANDTEXTANSWERPART2 	= "']/parent::label/parent::div//input",
				CHECKBOXANSWERPART1 		= "//span[@data-bind='text: text'][contains(text(),'",
				CHECKBOXANSWERPART2 		= "')]/preceding-sibling::input",
				USERTORECEIVECOMPLETEDFORM	= "input[name='userID'][value='",
				TEXTAREA_FIELD				= "']/parent::label/following-sibling::div/span/div/textarea";
				
	}
}
