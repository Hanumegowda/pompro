package eICS.Locators;

public class Contacts {

	public static class Locators {
		public static final String USERNAME 	= "#newUserId",
				FIRSTNAME						= "#body_firstName",
				MIDNAME							= "#body_middleName",
				LASTNAME						= "#body_lastName",
				PHONE_NUMBER 					= "//input[@binding='PrimaryPhone']",
				EMAIL							= "//input[@binding='PrimaryEmail']",
				ADDNEWCONTACT					= "#body_addContactButton",
				DOMAIN_OR_FACILITY				= "#navbar_Navigation2_defaultFacilityList",
				ENABLE_USER_ACCOUNT 			= "#body_newSystemAccess",
				ORGANIZATION					= "#body_newOrganization",
				CREATE							= "#pageNewNext[value='Create']",
				LOADING_PAGE_BLOCKER			= "//div[@class='blockUI blockMsg blockPage']",
				ACCOUNT_INFORMATION_DRAWER		= "//h3/a[contains(text(),'Account Information')]",
				RESET_PASSWORD					= "input[title='Reset Password']",
				CHANGE_PASSWORD_FRAME			= "changePasswordIframe",
				NEW_PASSWORD					= "newPassword",
				VERIFY_PASSWORD					= "confirmPassword",
				SUBMIT_BUTTON					= "#submitButton",
				PASSOWRD_CHANGE_SUCCESS_MESSAGE	= "//div[@id='headingSubtitle'][text()='Password set or changed successfully.']",
				CLOSE_RESET_PASSWORD_WINDOW		= "//span[text()='Reset Password']/following-sibling::button[@title='close']",
				LOADING_BLOCKER					= "//div[@class='blockUI blockOverlay']";
	}
}
