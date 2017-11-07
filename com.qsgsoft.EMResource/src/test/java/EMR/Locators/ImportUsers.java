package EMR.Locators;

public class ImportUsers {

	public static class Locators {
		public static final String IMPORT_USERS_PAGE = "//h1[text()='Import User']",
			    IMPORT							= "input[value='Import']",
			    IMPORT_USERS_CONFIRMATION_PAGE	= "//h1[text()='Import User Confirmation']",
			    IMPORT_INSTRUCTION				= "//div[@class='emsInstructions'][text()='Please confirm that this is the user you would like to import.']",
			    USERNAME						= "//td[text()='Username: ']/following-sibling::td",
			    USERFULLNAME					= "//td[text()='Full Name: ']/following-sibling::td",
			    USER_FIRSTNAME					= "//td[text()='First Name: ']/following-sibling::td",
			    USER_LASTNAME					= "//td[text()='Last Name: ']/following-sibling::td",
			    USER_ORGANIZATION				= "//td[text()='Organization: ']/following-sibling::td";
	}
}
